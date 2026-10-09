package com.example.tickets

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Looper
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import java.io.File
import java.io.FileInputStream
import java.io.InputStreamReader
import java.io.FileOutputStream
import java.net.HttpURLConnection
import java.net.URL
import java.util.Locale
import java.util.PriorityQueue
import java.util.zip.ZipFile
import java.util.zip.GZIPInputStream
import java.util.zip.GZIPOutputStream
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.currentCoroutineContext
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.json.JSONArray
import org.json.JSONObject
import kotlin.math.cos
import kotlin.math.max
import kotlin.math.min
import kotlin.math.sqrt

/**
 * 全球地铁数据统一入口。
 *
 * 设计原则：
 * 1. 数据不硬编码进 APK，不把几十座城市的站点表塞进安装包。
 * 2. 中国大陆地铁使用高德的城市地铁静态数据结构，按需下载当前城市。
 * 3. 香港使用高德地铁数据：站点搜索与地铁/轨道换乘规划均走本地索引与高德数据。
 * 4. 美国城市继续使用本地线路/站点轻量索引；美国 7 个支持城市统一从 Cloudflare Worker 获取服务器翻译后的 Pattern，
 *    Android 不直接读取/解析美国原始 GTFS/API 数据。纽约另外保留 Worker 的实时覆盖层。
 * 5. 中国大陆和香港只在 cacheDir 保留当前城市压缩索引；美国使用预编译本地轻量索引作为站点/线路基础。
 * 6. 动态运行状态仍保持现有本地 GPS/速度引擎；纽约 Worker 的 Realtime Overlay 只作为新增美国数据层接口，
 *    本次不改 SmartSubwayRealtime / LiveUpdate / Samsung Now Bar / Xiaomi SuperIsland。
 *
 * 中国优先顺序：武汉、深圳、香港、广州、上海、北京，然后是其它中国城市。
 * 美国支持城市：纽约、华盛顿、波士顿、费城、芝加哥、旧金山湾区、洛杉矶。
 */
object GlobalSubwayDataManager {

    enum class SourceType {
        AMAP,
        GOOGLE,
        LOCAL_US,
        TAIWAN_DISPLAY_ONLY
    }

    data class SubwayCity(
        val id: String,
        val nameZh: String,
        val nameEn: String,
        val country: String,
        val sourceType: SourceType,
        val sourceUrl: String = "",
        val amapCode: String = "",
        val amapSlug: String = "",
        val localAssetPath: String = "",
        val staticGtfsUrl: String = "",
        val gtfsRouteTypes: Set<Int> = emptySet()
    )

    data class SubwayRouteInfo(
        val routeId: String,
        val shortName: String,
        val longName: String,
        val color: Int
    )

    data class SubwayStationOption(
        val key: String,
        val name: String,
        val latitude: Double,
        val longitude: Double,
        val routes: List<SubwayRouteInfo>,
        val searchNames: List<String> = emptyList()
    )

    data class SubwayRouteStation(
        val stationKey: String,
        val name: String,
        val latitude: Double,
        val longitude: Double,
        val routeId: String
    )

    data class SubwayRoutePlan(
        val cityId: String,
        val primaryRoute: SubwayRouteInfo,
        val secondaryRoute: SubwayRouteInfo? = null,
        val transferStation: SubwayStationOption? = null,
        val transferStationKey: String = "",
        val stations: List<SubwayRouteStation>,
        val routePath: List<RoutePoint> = emptyList(),
        val routeInfos: List<SubwayRouteInfo> = emptyList()
    )

    data class RoutePoint(
        val latitude: Double,
        val longitude: Double
    )

    /**
     * NYC Worker 返回的实时覆盖层。
     * 这是美国地铁专用数据接口；不改变现有 SmartSubwayRealtime 数据模型。
     */
    data class NycRealtimeOverlay(
        val tripId: String,
        val routeId: String,
        val directionId: String,
        val startDate: String,
        val headsign: String,
        val currentStationKey: String?,
        val nextStationKey: String?,
        val currentStopSequence: Int?,
        val nextStopSequence: Int?,
        val nextArrivalEpochSec: Long?,
        val nextDepartureEpochSec: Long?,
        val delaySec: Int?,
        val scheduleRelationship: String,
        val sourceFeed: String,
        val updatedAt: Long
    )

    private data class UsServerPatternCache(
        val fetchedAt: Long,
        val index: StaticIndex
    )

    internal data class StaticIndex(
        val stationsByKey: Map<String, SubwayStationOption>,
        val routeByStation: Map<String, Set<String>>,
        val routePatterns: Map<String, List<List<String>>>,
        val routeInfo: Map<String, SubwayRouteInfo>
    ) {
        fun routesForStation(key: String): Set<String> = routeByStation[key].orEmpty()

        fun stationOption(key: String): SubwayStationOption? = stationsByKey[key]

        fun routeInfo(routeId: String): SubwayRouteInfo =
            routeInfo[routeId] ?: SubwayRouteInfo(
                routeId = routeId,
                shortName = routeId.substringAfterLast(':'),
                longName = "",
                color = FALLBACK_ROUTE_COLOR
            )
    }

    private const val PREFS_NAME = "global_subway_data"
    private const val PREF_ACTIVE_CITY = "active_city_id"
    private const val PREF_LAST_BUILD = "last_build_time"
    private const val CACHE_FILE_NAME = "global_subway_current_v2.bin.gz"
    private const val STATIC_REFRESH_MS = 7L * 24L * 60L * 60L * 1000L
    private const val FALLBACK_ROUTE_COLOR = 0xFF5A91D5.toInt()
    private const val MAX_SEARCH_RESULTS = 12
    private const val LOCAL_US_ASSET_PREFIX = "subway/us/"
    private const val LOCAL_US_FILE_DIR = "subway/us"
    private const val LOCAL_US_REFRESH_MS = 7L * 24L * 60L * 60L * 1000L

    /**
     * 只用于美国 7 城：服务器翻译层的基础地址。
     * 这里不写真实密钥，也不把 MTA 原始 GTFS 地址交给 Android。
     */
    private const val US_TRANSIT_SERVER_BASE_URL =
        "https://tickets-transit.hyl120309.workers.dev"

    private const val US_SERVER_PATTERN_CACHE_MS =
        10L * 60L * 1000L

    private val SERVER_PATTERN_US_CITY_IDS = setOf(
        "nyc",
        "washington_dc",
        "boston",
        "philadelphia",
        "chicago",
        "san_francisco_bay",
        "los_angeles"
    )

    private val cacheLock = Any()
    private val memoryIndexes = java.util.concurrent.ConcurrentHashMap<String, StaticIndex>()

    private val usServerPatternCaches =
        java.util.concurrent.ConcurrentHashMap<String, UsServerPatternCache>()

    /** 中国优先、美国随后。 */
    private val cityCatalog: List<SubwayCity> = listOf(
        city("wuhan", "武汉", "Wuhan", "中国", "4201", "wuhan"),
        city("shenzhen", "深圳", "Shenzhen", "中国", "4403", "shenzhen"),
        city("guangzhou", "广州", "Guangzhou", "中国", "4401", "guangzhou"),
        city("shanghai", "上海", "Shanghai", "中国", "3100", "shanghai"),
        city("beijing", "北京", "Beijing", "中国", "1100", "beijing"),
        city("tianjin", "天津", "Tianjin", "中国", "1200", "tianjin"),
        city("nanjing", "南京", "Nanjing", "中国", "3201", "nanjing"),
        city("chongqing", "重庆", "Chongqing", "中国", "5000", "chongqing"),
        city("hangzhou", "杭州", "Hangzhou", "中国", "3301", "hangzhou"),
        city("chengdu", "成都", "Chengdu", "中国", "5101", "chengdu"),
        city("shenyang", "沈阳", "Shenyang", "中国", "2101", "shenyang"),
        city("dalian", "大连", "Dalian", "中国", "2102", "dalian"),
        city("changchun", "长春", "Changchun", "中国", "2201", "changchun"),
        city("suzhou", "苏州", "Suzhou", "中国", "3205", "suzhou"),
        city("foshan", "佛山", "Foshan", "中国", "4406", "foshan"),
        city("kunming", "昆明", "Kunming", "中国", "5301", "kunming"),
        city("xian", "西安", "Xi'an", "中国", "6101", "xian"),
        city("zhengzhou", "郑州", "Zhengzhou", "中国", "4101", "zhengzhou"),
        city("changsha", "长沙", "Changsha", "中国", "4301", "changsha"),
        city("ningbo", "宁波", "Ningbo", "中国", "3302", "ningbo"),
        city("wuxi", "无锡", "Wuxi", "中国", "3202", "wuxi"),
        city("qingdao", "青岛", "Qingdao", "中国", "3702", "qingdao"),
        city("nanchang", "南昌", "Nanchang", "中国", "3601", "nanchang"),
        city("fuzhou", "福州", "Fuzhou", "中国", "3501", "fuzhou"),
        city("dongguan", "东莞", "Dongguan", "中国", "4419", "dongguan"),
        city("nanning", "南宁", "Nanning", "中国", "4501", "nanning"),
        city("hefei", "合肥", "Hefei", "中国", "3401", "hefei"),
        city("guiyang", "贵阳", "Guiyang", "中国", "5201", "guiyang"),
        city("xiamen", "厦门", "Xiamen", "中国", "3502", "xiamen"),
        city("harbin", "哈尔滨", "Harbin", "中国", "2301", "haerbin"),
        city("shijiazhuang", "石家庄", "Shijiazhuang", "中国", "1301", "shijiazhuang"),
        city("urumqi", "乌鲁木齐", "Urumqi", "中国", "6501", "wulumuqi"),
        city("wenzhou", "温州", "Wenzhou", "中国", "3303", "wenzhou"),
        city("jinan", "济南", "Jinan", "中国", "3701", "jinan"),
        city("lanzhou", "兰州", "Lanzhou", "中国", "6201", "lanzhou"),
        city("changzhou", "常州", "Changzhou", "中国", "3204", "changzhou"),
        city("xuzhou", "徐州", "Xuzhou", "中国", "3203", "xuzhou"),
        city("huhehaote", "呼和浩特", "Hohhot", "中国", "1501", "huhehaote"),
        city(
            id = "hong_kong",
            nameZh = "香港",
            nameEn = "Hong Kong",
            country = "中国香港",
            sourceType = SourceType.AMAP,
            code = "8100",
            slug = "xianggang"
        ),
        city(
            id = "taipei",
            nameZh = "台北",
            nameEn = "Taipei",
            country = "中国台湾",
            sourceType = SourceType.TAIWAN_DISPLAY_ONLY
        ),
        localUsCity("nyc", "纽约", "New York", "subway/us/nyc.json.gz", "", setOf(1)),
        localUsCity("washington_dc", "华盛顿", "Washington, DC", "subway/us/washington_dc.json.gz", "", setOf(1)),
        localUsCity("boston", "波士顿", "Boston", "subway/us/boston.json.gz", "", setOf(0, 1)),
        localUsCity("philadelphia", "费城", "Philadelphia", "subway/us/philadelphia.json.gz", "", setOf(0, 1)),
        localUsCity("chicago", "芝加哥", "Chicago", "subway/us/chicago.json.gz", "", setOf(1)),
        localUsCity("san_francisco_bay", "旧金山湾区", "San Francisco Bay Area", "subway/us/san_francisco_bay.json.gz", "", setOf(1)),
        localUsCity("los_angeles", "洛杉矶", "Los Angeles", "subway/us/los_angeles.json.gz", "", setOf(0, 1)),
    )

    private fun city(
        id: String,
        nameZh: String,
        nameEn: String,
        country: String,
        code: String = "",
        slug: String = "",
        sourceType: SourceType = SourceType.AMAP,
        sourceUrl: String = "",
        localAssetPath: String = ""
    ): SubwayCity = SubwayCity(
        id = id,
        nameZh = nameZh,
        nameEn = nameEn,
        country = country,
        sourceType = sourceType,
        sourceUrl = sourceUrl,
        amapCode = code,
        amapSlug = slug,
        localAssetPath = localAssetPath
    )


    private fun localUsCity(
        id: String,
        nameZh: String,
        nameEn: String,
        assetPath: String,
        staticGtfsUrl: String,
        gtfsRouteTypes: Set<Int>
    ): SubwayCity = SubwayCity(
        id = id,
        nameZh = nameZh,
        nameEn = nameEn,
        country = "美国",
        sourceType = SourceType.LOCAL_US,
        localAssetPath = assetPath,
        staticGtfsUrl = staticGtfsUrl,
        gtfsRouteTypes = gtfsRouteTypes
    )

    fun allCities(): List<SubwayCity> = cityCatalog

    fun chinaCities(): List<SubwayCity> = cityCatalog.filter { it.country.startsWith("中国") }

    fun americanCities(): List<SubwayCity> = cityCatalog.filter { it.country == "美国" }

    fun cityOrNull(cityId: String): SubwayCity? =
        cityCatalog.firstOrNull { it.id == cityId }

    fun cityName(cityId: String): String = cityOrNull(cityId)?.nameZh ?: cityId

    suspend fun searchStations(
        context: Context,
        cityId: String,
        query: String,
        limit: Int = MAX_SEARCH_RESULTS
    ): List<SubwayStationOption> = withContext(Dispatchers.IO) {
        val city = cityOrNull(cityId) ?: return@withContext emptyList()

        if (city.sourceType == SourceType.TAIWAN_DISPLAY_ONLY) {
            return@withContext emptyList()
        }

        if (city.sourceType == SourceType.GOOGLE) {
            return@withContext googleSearchStations(
                context = context,
                city = city,
                query = query,
                limit = limit.coerceIn(1, 20)
            )
        }

        val index = if (SERVER_PATTERN_US_CITY_IDS.contains(cityId)) {
            loadUsServerRoutingIndex(context, cityId)
                ?: loadOrBuildIndex(context, cityId)
        } else {
            loadOrBuildIndex(context, cityId)
        }
        val normalized = normalizeStationSearch(query)

        index.stationsByKey.values.asSequence()
            .filter { station ->
                normalized.isBlank() ||
                        stationNameMatchesSearch(station, normalized) ||
                        station.routes.any {
                            normalizeSearch(it.shortName).contains(normalizeSearch(query))
                        }
            }
            .sortedWith(
                compareBy<SubwayStationOption> { station ->
                    when {
                        normalized.isBlank() -> 2
                        normalizeStationSearch(station.name) == normalized -> 0
                        station.searchNames.any {
                            normalizeStationSearch(it) == normalized
                        } -> 0
                        normalizeStationSearch(station.name).startsWith(normalized) -> 1
                        station.searchNames.any {
                            normalizeStationSearch(it).startsWith(normalized)
                        } -> 1
                        else -> 2
                    }
                }.thenBy { it.name }
            )
            .take(limit.coerceIn(1, 50))
            .toList()
    }

    /**
     * Smart Subway 线路标志内的短标签。
     * 仅改变彩色线路标志里的文字；内部线路身份、
     * 行程主文本和通知正文仍保留“机场快线”。
     */
    internal fun displayLineBadgeName(cityId: String, shortName: String, routeId: String = ""): String {
        if (cityId != "hong_kong") return shortName

        val normalized = shortName
            .trim()
            .lowercase(Locale.ROOT)
            .replace('綫', '线')
            .replace('線', '线')
            .replace(Regex("[\\s_\\-–—:/·•()（）]+"), "")

        val normalizedRoute = routeId
            .trim()
            .lowercase(Locale.ROOT)
            .replace('綫', '线')
            .replace('線', '线')
            .replace(Regex("[\\s_\\-–—:/·•()（）]+"), "")

        return when {
            normalized == "机场快线" ||
                    normalized == "airportexpress" ||
                    normalized == "airportexpressline" ||
                    normalized == "ael" ||
                    normalizedRoute.endsWith(":ae") ||
                    normalizedRoute.endsWith("ael") -> "机场线"
            else -> shortName
        }
    }

    private fun normalizedRouteToken(value: String): String =
        value.trim()
            .removeSuffix("号线")
            .replace("Line", "", ignoreCase = true)
            .replace(Regex("\\s+"), "")
            .lowercase()

    /**
     * 根据“当前站 + 下一站”的实际顺序，从静态线路 pattern 中反推当前站前一站。
     * 不把出发站当成“上一站”，因此当行程从科普公园开始时仍可得到真实的建设二路。
     */
    internal fun previousPhysicalStationFromIndex(
        index: StaticIndex,
        lineName: String,
        currentKey: String,
        nextKey: String?
    ): String {
        val activeToken = normalizedRouteToken(lineName)
        val routeIds = index.routesForStation(currentKey).toList()
        val orderedRouteIds = routeIds.sortedWith(
            compareByDescending<String> { routeId ->
                val token = normalizedRouteToken(index.routeInfo(routeId).shortName)
                activeToken.isNotBlank() &&
                        (token == activeToken ||
                                token.contains(activeToken) ||
                                activeToken.contains(token))
            }.thenBy { it }
        )

        for (routeId in orderedRouteIds) {
            for (pattern in index.routePatterns[routeId].orEmpty()) {
                for (patternIndex in pattern.indices) {
                    if (pattern[patternIndex] != currentKey) continue

                    // 正向：当前站 -> 下一站，因此上一站就是当前站前一个节点。
                    if (nextKey != null &&
                        patternIndex + 1 < pattern.size &&
                        pattern[patternIndex + 1] == nextKey &&
                        patternIndex > 0
                    ) {
                        val previous =
                            index.stationOption(pattern[patternIndex - 1])?.name.orEmpty()
                        if (previous.isNotBlank()) return previous
                    }

                    // 反向：下一站位于当前站前一个节点，因此上一站位于后一个节点。
                    if (nextKey != null &&
                        patternIndex > 0 &&
                        pattern[patternIndex - 1] == nextKey &&
                        patternIndex + 1 < pattern.size
                    ) {
                        val previous =
                            index.stationOption(pattern[patternIndex + 1])?.name.orEmpty()
                        if (previous.isNotBlank()) return previous
                    }
                }
            }
        }

        // 没有可靠的下一站时，也按完整线路中当前站的前一个节点取上一站。
        for (routeId in orderedRouteIds) {
            for (pattern in index.routePatterns[routeId].orEmpty()) {
                val patternIndex = pattern.indexOf(currentKey)
                if (patternIndex > 0) {
                    val previous =
                        index.stationOption(pattern[patternIndex - 1])?.name.orEmpty()
                    if (previous.isNotBlank()) return previous
                }
            }
        }

        return ""
    }

    internal suspend fun previousPhysicalStationForRoute(
        context: Context,
        cityId: String,
        lineName: String,
        currentStation: String,
        nextStation: String
    ): String = withContext(Dispatchers.IO) {
        val city = cityOrNull(cityId) ?: return@withContext ""
        if (city.sourceType == SourceType.GOOGLE) return@withContext ""

        val index = if (SERVER_PATTERN_US_CITY_IDS.contains(cityId)) {
            loadUsServerRoutingIndex(context, cityId)
                ?: loadOrBuildIndex(context, cityId)
        } else {
            loadOrBuildIndex(context, cityId)
        }
        val currentKey = resolveStationKey(index, currentStation)
            ?: return@withContext ""
        val nextKey = resolveStationKey(index, nextStation)

        previousPhysicalStationFromIndex(
            index = index,
            lineName = lineName,
            currentKey = currentKey,
            nextKey = nextKey
        )
    }

    internal fun currentStationTransferOptions(
        index: StaticIndex,
        stationKey: String,
        activeRouteId: String
    ): List<String> {
        return index.stationOption(stationKey)
            ?.routes
            ?.filter { it.routeId != activeRouteId }
            ?.map { it.shortName }
            ?.filter { it.isNotBlank() }
            ?.distinct()
            .orEmpty()
    }

    internal suspend fun prepareTrip(
        context: Context,
        trip: SmartSubwayTrip
    ): SmartSubwayTrip = withContext(Dispatchers.IO) {
        val city = cityOrNull(trip.cityId)
            ?: return@withContext trip

        val plan = if (city.sourceType == SourceType.GOOGLE) {
            googleResolvePlan(context, city, trip.origin, trip.destination)
        } else {
            val index = if (SERVER_PATTERN_US_CITY_IDS.contains(trip.cityId)) {
                loadUsServerRoutingIndex(context, trip.cityId)
                    ?: loadOrBuildIndex(context, trip.cityId)
            } else {
                loadOrBuildIndex(context, trip.cityId)
            }
            resolvePlan(index, trip.cityId, trip.origin, trip.destination)
        }

        if (plan == null) {
            return@withContext trip.copy(
                cityName = cityName(trip.cityId),
                nextStation = trip.destination
            )
        }

        val firstNext = plan.stations.drop(1).firstOrNull()
        val initialCurrent = plan.stations.firstOrNull()?.name ?: trip.origin
        val initialNext = firstNext?.name ?: trip.destination
        val transferName = plan.transferStation?.name.orEmpty()
        val transferRequired = plan.secondaryRoute != null && transferName.isNotBlank()
        // 行程刚开始时，当前站就是本次有效服务计划的起点，上一站严格显示“无”。
        // 不使用完整物理线路 Pattern 反推起点前的站，避免把未开通区段或线路外站点显示成上一站。
        val previousPhysical = ""

        val initialTransferOptions = if (city.sourceType != SourceType.GOOGLE) {
            val initialIndex = if (SERVER_PATTERN_US_CITY_IDS.contains(trip.cityId)) {
                loadUsServerRoutingIndex(context, trip.cityId)
                    ?: loadOrBuildIndex(context, trip.cityId)
            } else {
                loadOrBuildIndex(context, trip.cityId)
            }
            val initialStationKey = resolveStationKey(
                initialIndex,
                initialCurrent
            )
            if (initialStationKey != null) {
                currentStationTransferOptions(
                    initialIndex,
                    initialStationKey,
                    plan.primaryRoute.routeId
                )
            } else {
                emptyList()
            }
        } else {
            emptyList()
        }

        trip.copy(
            cityName = cityName(trip.cityId),
            currentStation = initialCurrent,
            nextStation = initialNext,
            previousStation = previousPhysical,
            lineName = plan.primaryRoute.shortName.ifBlank { plan.primaryRoute.routeId },
            primaryLineColor = Color(plan.primaryRoute.color),
            secondaryLineColor = Color(plan.secondaryRoute?.color ?: plan.primaryRoute.color),
            isTransferRequired = transferRequired,
            isDestination = false,
            transferStation = transferName,
            transferLineName = plan.secondaryRoute?.shortName.orEmpty(),
            transferOptions = initialTransferOptions
        )
    }

    suspend fun resolveRoutePlan(
        context: Context,
        cityId: String,
        origin: String,
        destination: String
    ): SubwayRoutePlan? = withContext(Dispatchers.IO) {
        val city = cityOrNull(cityId) ?: return@withContext null
        if (city.sourceType == SourceType.GOOGLE) {
            googleResolvePlan(context, city, origin, destination)
        } else {
            val index = if (SERVER_PATTERN_US_CITY_IDS.contains(cityId)) {
                loadUsServerRoutingIndex(context, cityId)
                    ?: loadOrBuildIndex(context, cityId)
            } else {
                loadOrBuildIndex(context, cityId)
            }
            resolvePlan(index, cityId, origin, destination)
        }
    }


    /**
     * 美国 7 城服务器静态索引接入。
     *
     * NYC 与其它 6 城都由 Worker 提供完整 Android 静态索引；
     * Android 统一解析 routes / stations / 坐标 / route associations / patterns。
     * Worker 不可用时仍自动回退到现有本地索引。
     */
    private suspend fun loadUsServerRoutingIndex(
        context: Context,
        cityId: String
    ): StaticIndex? = withContext(Dispatchers.IO) {
        if (!SERVER_PATTERN_US_CITY_IDS.contains(cityId)) return@withContext null
        if (US_TRANSIT_SERVER_BASE_URL.contains("YOUR-US-TRANSIT-WORKER")) {
            return@withContext null
        }

        val now = System.currentTimeMillis()
        usServerPatternCaches[cityId]?.let { cached ->
            if (now - cached.fetchedAt <= US_SERVER_PATTERN_CACHE_MS) {
                return@withContext cached.index
            }
        }

        // NYC 现在由 Worker 直接提供“完整 Android 静态索引”：
        // routes + stations + StationKey + 坐标 + 线路关系 + Pattern。
        // 这样 NYC 不再要求 APK 内预置 nyc.json.gz，也不再让 Android 解析原始 GTFS。
        if (cityId == "nyc") {
            val endpoint =
                US_TRANSIT_SERVER_BASE_URL.trimEnd('/') + "/api/v1/us/nyc/index"

            val fetched = runCatching {
                val connection =
                    (URL(endpoint).openConnection() as HttpURLConnection).apply {
                        requestMethod = "GET"
                        connectTimeout = 8_000
                        readTimeout = 15_000
                        instanceFollowRedirects = true
                        setRequestProperty("Accept", "application/json")
                        setRequestProperty("User-Agent", "Tickets/7.0 USSubway")
                    }

                try {
                    if (connection.responseCode !in 200..299) {
                        throw IllegalStateException(
                            "US Transit Worker NYC index HTTP ${connection.responseCode}"
                        )
                    }

                    val root = JSONObject(
                        connection.inputStream
                            .bufferedReader(Charsets.UTF_8)
                            .use { it.readText() }
                    )
                    if (root.optString("cityId") != "nyc") {
                        throw IllegalStateException(
                            "US Transit Worker NYC index returned wrong cityId: ${root.optString("cityId").orEmpty()}"
                        )
                    }

                    val index = normalizeLocalUsIndex("nyc", fromJson(root))
                    if (index.stationsByKey.isEmpty()) {
                        throw IllegalStateException("US Transit Worker NYC index has no stations")
                    }
                    if (index.routePatterns.isEmpty()) {
                        throw IllegalStateException("US Transit Worker NYC index has no patterns")
                    }
                    if (index.routeInfo.isEmpty()) {
                        throw IllegalStateException("US Transit Worker NYC index has no routes")
                    }

                    UsServerPatternCache(
                        fetchedAt = now,
                        index = index
                    )
                } finally {
                    connection.disconnect()
                }
            }.getOrNull()

            if (fetched != null) {
                usServerPatternCaches[cityId] = fetched
                return@withContext fetched.index
            }

            // Worker 暂时不可用时，仍允许已有 APK 本地缓存继续工作。
            return@withContext runCatching {
                loadOrBuildIndex(context, cityId)
            }.getOrNull()
        }

        // 其它美国 6 城现在与 NYC 一样由 Worker 提供完整静态 Android 索引：
        // routes + stations + 坐标 + route associations + patterns。
        // 不再依赖 APK 本地站点库，也不再把 schedule 当作站点搜索索引。
        val endpoint =
            US_TRANSIT_SERVER_BASE_URL.trimEnd('/') +
                    "/api/v1/us/" +
                    java.net.URLEncoder.encode(cityId, "UTF-8") +
                    "/index"

        val fetched = runCatching {
            val connection =
                (URL(endpoint).openConnection() as HttpURLConnection).apply {
                    requestMethod = "GET"
                    connectTimeout = 8_000
                    readTimeout = 15_000
                    instanceFollowRedirects = true
                    setRequestProperty("Accept", "application/json")
                    setRequestProperty("User-Agent", "Tickets/7.0 USSubway")
                }

            try {
                if (connection.responseCode !in 200..299) {
                    throw IllegalStateException(
                        "US Transit Worker $cityId index HTTP ${connection.responseCode}"
                    )
                }

                val root = JSONObject(
                    connection.inputStream
                        .bufferedReader(Charsets.UTF_8)
                        .use { it.readText() }
                )
                if (root.optString("cityId") != cityId) {
                    throw IllegalStateException(
                        "US Transit Worker returned wrong cityId: ${root.optString("cityId").orEmpty()}"
                    )
                }

                val index = normalizeLocalUsIndex(cityId, fromJson(root))
                if (index.stationsByKey.isEmpty()) {
                    throw IllegalStateException(
                        "US Transit Worker $cityId index has no stations"
                    )
                }
                if (index.routePatterns.isEmpty()) {
                    throw IllegalStateException(
                        "US Transit Worker $cityId index has no patterns"
                    )
                }
                if (index.routeInfo.isEmpty()) {
                    throw IllegalStateException(
                        "US Transit Worker $cityId index has no routes"
                    )
                }

                UsServerPatternCache(
                    fetchedAt = now,
                    index = index
                )
            } finally {
                connection.disconnect()
            }
        }.getOrNull()

        if (fetched != null) {
            usServerPatternCaches[cityId] = fetched
            return@withContext fetched.index
        }

        // Worker 暂时不可用时，继续使用现有 APK 本地缓存。
        return@withContext runCatching {
            loadOrBuildIndex(context, cityId)
        }.getOrNull()
    }

    /**
     * NYC GTFS-RT → Worker → Realtime Overlay。
     *
     * 该方法目前只提供新的美国数据层 API，不主动改动 SmartSubwayRealtime。
     * 因此不会改变当前已稳定的地铁 UI / 通知行为。
     */
    internal suspend fun fetchNycRealtimeOverlay(
        context: Context,
        routeIds: Set<String> = emptySet(),
        stationKeys: Set<String> = emptySet()
    ): List<NycRealtimeOverlay> = withContext(Dispatchers.IO) {
        if (US_TRANSIT_SERVER_BASE_URL.contains("YOUR-US-TRANSIT-WORKER")) {
            return@withContext emptyList()
        }

        val endpoint = buildString {
            append(US_TRANSIT_SERVER_BASE_URL.trimEnd('/'))
            append("/api/v1/nyc/realtime")
            if (routeIds.isNotEmpty()) {
                append("?routes=")
                append(java.net.URLEncoder.encode(routeIds.sorted().joinToString(","), "UTF-8"))
            }
        }

        runCatching {
            val connection =
                (URL(endpoint).openConnection() as HttpURLConnection).apply {
                    requestMethod = "GET"
                    connectTimeout = 12_000
                    readTimeout = 20_000
                    instanceFollowRedirects = true
                    setRequestProperty("Accept", "application/json")
                    setRequestProperty("User-Agent", "Tickets/6.0 NYCTransit")
                }

            try {
                if (connection.responseCode !in 200..299) {
                    throw IllegalStateException(
                        "US Transit Worker realtime HTTP ${connection.responseCode}"
                    )
                }

                val root = JSONObject(
                    connection.inputStream
                        .bufferedReader(Charsets.UTF_8)
                        .use { it.readText() }
                )
                val array = root.optJSONArray("overlays") ?: JSONArray()
                val result = ArrayList<NycRealtimeOverlay>(array.length())

                for (i in 0 until array.length()) {
                    val item = array.optJSONObject(i) ?: continue
                    val currentKey = item.optString("currentStationKey")
                        .takeIf { it.isNotBlank() }
                    val nextKey = item.optString("nextStationKey")
                        .takeIf { it.isNotBlank() }

                    if (stationKeys.isNotEmpty() &&
                        currentKey !in stationKeys &&
                        nextKey !in stationKeys
                    ) {
                        continue
                    }

                    result += NycRealtimeOverlay(
                        tripId = item.optString("tripId"),
                        routeId = item.optString("routeId"),
                        directionId = item.optString("directionId"),
                        startDate = item.optString("startDate"),
                        headsign = item.optString("headsign"),
                        currentStationKey = currentKey,
                        nextStationKey = nextKey,
                        currentStopSequence = if (item.has("currentStopSequence")) item.optInt("currentStopSequence") else null,
                        nextStopSequence = if (item.has("nextStopSequence")) item.optInt("nextStopSequence") else null,
                        nextArrivalEpochSec = if (item.has("nextArrivalEpochSec")) item.optLong("nextArrivalEpochSec") else null,
                        nextDepartureEpochSec = if (item.has("nextDepartureEpochSec")) item.optLong("nextDepartureEpochSec") else null,
                        delaySec = if (item.has("delaySec") && !item.isNull("delaySec")) item.optInt("delaySec") else null,
                        scheduleRelationship = item.optString("scheduleRelationship", "UNKNOWN"),
                        sourceFeed = item.optString("sourceFeed"),
                        updatedAt = item.optLong("updatedAt", 0L)
                    )
                }

                result
            } finally {
                connection.disconnect()
            }
        }.getOrDefault(emptyList())
    }


    /**
     * 美国本地索引说明：
     * 正式 APK 优先读取 assets 中的预编译索引；缺失时才使用静态 GTFS
     * 下载/转换为本地压缩索引。这里不使用 GTFS-RT。
     */
    object LocalUsDataConfig {
        fun assetPath(cityId: String): String =
            "${LOCAL_US_ASSET_PREFIX}${cityId}.json.gz"
    }

    /**
     * Google Maps Platform API Key（仅香港使用）。
     * 美国主要城市已经改为本地预编译数据，不再读取此 Key。
     *
     * 这里只保留一个可编译的默认入口，不把真实密钥写入代码库。
     * 你可以把真实 key 直接替换下面常量，或者在运行时写入
     * SharedPreferences 的 global_subway_data / google_maps_api_key。
     */
    object GoogleMapsConfig {
        const val API_KEY = "PASTE_YOUR_GOOGLE_MAPS_PLATFORM_API_KEY_HERE"

        fun getApiKey(context: Context): String {
            val stored = context
                .getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
                .getString("google_maps_api_key", "")
                .orEmpty()
            return stored.ifBlank { API_KEY }
        }
    }

    private const val GOOGLE_PLACES_SEARCH_URL =
        "https://places.googleapis.com/v1/places:searchText"
    private const val GOOGLE_PLACES_NEARBY_URL =
        "https://places.googleapis.com/v1/places:searchNearby"
    private const val GOOGLE_ROUTES_URL =
        "https://routes.googleapis.com/directions/v2:computeRoutes"

    private fun requireGoogleApiKey(context: Context): String {
        val key = GoogleMapsConfig.getApiKey(context)
        require(
            key.isNotBlank() &&
                    key != GoogleMapsConfig.API_KEY
        ) {
            "请在 GlobalSubwayDataManager.GoogleMapsConfig.API_KEY 填入 Google Maps Platform API Key。"
        }
        return key
    }

    private fun googleSearchStationsBlocking(
        context: Context,
        city: SubwayCity,
        query: String,
        limit: Int
    ): List<SubwayStationOption> {
        val key = requireGoogleApiKey(context)
        val safeQuery = query.trim().ifBlank { "subway station" }
        val textQuery = "$safeQuery in ${city.nameEn}"

        val body = JSONObject().apply {
            put("textQuery", textQuery)
            put("includedType", "transit_station")
            put("strictTypeFiltering", true)
            put("pageSize", limit.coerceIn(1, 20))
            put("languageCode", if (city.id == "hong_kong") "zh-HK" else "en")
        }

        val response = googlePostJson(
            urlString = GOOGLE_PLACES_SEARCH_URL,
            apiKey = key,
            fieldMask = "places.id,places.displayName,places.location,places.transitStation",
            body = body
        )

        return parseGooglePlacesStations(city, response)
    }

    private suspend fun googleSearchStations(
        context: Context,
        city: SubwayCity,
        query: String,
        limit: Int
    ): List<SubwayStationOption> = withContext(Dispatchers.IO) {
        runCatching {
            googleSearchStationsBlocking(context, city, query, limit)
        }.getOrElse {
            emptyList()
        }
    }

    private suspend fun googleNearbyStations(
        context: Context,
        city: SubwayCity,
        latitude: Double,
        longitude: Double,
        radiusMeters: Double = 2_500.0
    ): List<SubwayStationOption> = withContext(Dispatchers.IO) {
        runCatching {
            val key = requireGoogleApiKey(context)
            val body = JSONObject().apply {
                put("includedTypes", JSONArray().put("transit_station"))
                put("maxResultCount", 20)
                put(
                    "locationRestriction",
                    JSONObject().put(
                        "circle",
                        JSONObject()
                            .put(
                                "center",
                                JSONObject()
                                    .put("latitude", latitude)
                                    .put("longitude", longitude)
                            )
                            .put("radius", radiusMeters.coerceIn(1.0, 50_000.0))
                    )
                )
                put("languageCode", "en")
            }

            val response = googlePostJson(
                urlString = GOOGLE_PLACES_NEARBY_URL,
                apiKey = key,
                fieldMask = "places.id,places.displayName,places.location,places.transitStation",
                body = body
            )

            parseGooglePlacesStations(city, response)
        }.getOrElse {
            emptyList()
        }
    }

    private fun parseGooglePlacesStations(
        city: SubwayCity,
        root: JSONObject
    ): List<SubwayStationOption> {
        val places = root.optJSONArray("places") ?: JSONArray()
        val result = LinkedHashMap<String, SubwayStationOption>()

        for (i in 0 until places.length()) {
            val place = places.optJSONObject(i) ?: continue
            val id = place.optString("id").ifBlank {
                place.optString("name").removePrefix("places/")
            }
            val displayName = firstNonBlank(
                place.optJSONObject("transitStation")
                    ?.optJSONObject("displayName")
                    ?.optString("text")
                    .orEmpty(),
                place.optJSONObject("displayName")
                    ?.optString("text")
                    .orEmpty()
            )
            val location = place.optJSONObject("location") ?: continue
            val latitude = location.optDouble("latitude", Double.NaN)
            val longitude = location.optDouble("longitude", Double.NaN)
            if (
                displayName.isBlank() ||
                !latitude.isFinite() ||
                !longitude.isFinite()
            ) {
                continue
            }

            val routes = ArrayList<SubwayRouteInfo>()
            val transitStation = place.optJSONObject("transitStation")
            val agencies = transitStation?.optJSONArray("agencies") ?: JSONArray()

            for (agencyIndex in 0 until agencies.length()) {
                val agency = agencies.optJSONObject(agencyIndex) ?: continue
                val lines = agency.optJSONArray("lines") ?: JSONArray()
                for (lineIndex in 0 until lines.length()) {
                    val line = lines.optJSONObject(lineIndex) ?: continue
                    val display = firstNonBlank(
                        line.optJSONObject("displayName")?.optString("text").orEmpty(),
                        line.optString("name"),
                        line.optString("id")
                    )
                    if (display.isBlank()) continue

                    val short = firstNonBlank(
                        line.optString("shortName"),
                        display
                    )
                    val routeId = "${city.id}:google:${line.optString("id").ifBlank { display }}"
                    val color = routeColor(
                        cityId = city.id,
                        shortName = short,
                        routeCode = routeId,
                        seed = routes.size,
                        sourceColor = parseHexColor(
                            firstNonBlank(
                                line.optString("backgroundColor"),
                                line.optString("color")
                            )
                        )
                    )

                    if (routes.none { it.routeId == routeId }) {
                        routes += SubwayRouteInfo(
                            routeId = routeId,
                            shortName = short,
                            longName = display,
                            color = color
                        )
                    }
                }
            }

            val fallbackRoute = if (routes.isEmpty()) {
                listOf(
                    SubwayRouteInfo(
                        routeId = "${city.id}:google:transit",
                        shortName = "地铁",
                        longName = "Transit",
                        color = FALLBACK_ROUTE_COLOR
                    )
                )
            } else {
                routes
            }

            val key = "${city.id}:google:place:$id"
            result[id] = SubwayStationOption(
                key = key,
                name = displayName,
                latitude = latitude,
                longitude = longitude,
                routes = fallbackRoute.sortedBy { it.shortName }
            )
        }

        return result.values.toList()
    }

    private fun googleResolvePlanBlocking(
        context: Context,
        city: SubwayCity,
        originName: String,
        destinationName: String
    ): SubwayRoutePlan? {
        val origin = googleFindStationBlocking(context, city, originName) ?: return null
        val destination = googleFindStationBlocking(context, city, destinationName) ?: return null
        if (origin.key == destination.key) return null

        val key = requireGoogleApiKey(context)
        val body = JSONObject().apply {
            put(
                "origin",
                JSONObject().put(
                    "location",
                    JSONObject().put(
                        "latLng",
                        JSONObject()
                            .put("latitude", origin.latitude)
                            .put("longitude", origin.longitude)
                    )
                )
            )
            put(
                "destination",
                JSONObject().put(
                    "location",
                    JSONObject().put(
                        "latLng",
                        JSONObject()
                            .put(
                                "latitude",
                                destination.latitude
                            )
                            .put(
                                "longitude",
                                destination.longitude
                            )
                    )
                )
            )
            put("travelMode", "TRANSIT")
            put("languageCode", "en")
            put(
                "transitPreferences",
                JSONObject()
                    .put(
                        "allowedTravelModes",
                        JSONArray()
                            .put("SUBWAY")
                            .put("TRAIN")
                            .put("LIGHT_RAIL")
                            .put("RAIL")
                    )
                    .put("routingPreference", "FEWER_TRANSFERS")
            )
            put("computeAlternativeRoutes", false)
        }

        val response = googlePostJson(
            urlString = GOOGLE_ROUTES_URL,
            apiKey = key,
            fieldMask = "routes.legs.steps.transitDetails,routes.legs.steps.polyline.encodedPolyline",
            body = body,
            apiKeyHeader = "X-Goog-Api-Key"
        )

        val routes = response.optJSONArray("routes") ?: return null
        val route = routes.optJSONObject(0) ?: return null
        val legs = route.optJSONArray("legs") ?: return null

        val planStations = ArrayList<SubwayRouteStation>()
        val routeInfos = ArrayList<SubwayRouteInfo>()
        val routePath = ArrayList<RoutePoint>()
        var transferStation: SubwayStationOption? = null
        var previousRouteId: String? = null

        for (legIndex in 0 until legs.length()) {
            val leg = legs.optJSONObject(legIndex) ?: continue
            val steps = leg.optJSONArray("steps") ?: JSONArray()

            for (stepIndex in 0 until steps.length()) {
                val step = steps.optJSONObject(stepIndex) ?: continue

                val encodedPolyline = step
                    .optJSONObject("polyline")
                    ?.optString("encodedPolyline")
                    .orEmpty()
                if (encodedPolyline.isNotBlank()) {
                    decodeEncodedPolyline(encodedPolyline).forEach { point ->
                        if (
                            routePath.lastOrNull()?.latitude != point.latitude ||
                            routePath.lastOrNull()?.longitude != point.longitude
                        ) {
                            routePath += point
                        }
                    }
                }

                val transit = step.optJSONObject("transitDetails") ?: continue
                val transitLine = transit.optJSONObject("transitLine") ?: continue
                val vehicleType = transitLine
                    .optJSONObject("vehicle")
                    ?.optString("type")
                    .orEmpty()
                    .uppercase(Locale.ROOT)

                val isSupportedRailTransit = when (vehicleType) {
                    "SUBWAY",
                    "HEAVY_RAIL",
                    "METRO_RAIL",
                    "RAIL",
                    "LIGHT_RAIL",
                    "TRAIN",
                    "COMMUTER_TRAIN" -> true
                    else -> false
                }

                if (vehicleType.isNotBlank() && !isSupportedRailTransit) {
                    continue
                }

                val shortName = firstNonBlank(
                    transitLine.optString("nameShort"),
                    transitLine.optString("name"),
                    "地铁"
                )
                val longName = firstNonBlank(
                    transitLine.optString("name"),
                    shortName
                )
                val routeId = "${city.id}:google:line:${shortName}"
                val color = routeColor(
                    cityId = city.id,
                    shortName = shortName,
                    routeCode = routeId,
                    seed = routeInfos.size,
                    sourceColor = parseHexColor(transitLine.optString("color"))
                        ?: parseHexColor(transitLine.optString("backgroundColor"))
                )

                val info = SubwayRouteInfo(
                    routeId = routeId,
                    shortName = shortName,
                    longName = longName,
                    color = color
                )
                if (routeInfos.none { it.routeId == routeId }) {
                    routeInfos += info
                }

                if (
                    previousRouteId != null &&
                    previousRouteId != routeId &&
                    transferStation == null
                ) {
                    val transferName = transit
                        .optJSONObject("stopDetails")
                        ?.optJSONObject("departureStop")
                        ?.optString("name")
                        .orEmpty()
                    if (transferName.isNotBlank()) {
                        val transferStop = transit
                            .optJSONObject("stopDetails")
                            ?.optJSONObject("departureStop")
                        val transferLocation = transferStop?.let { googleRouteLocation(it) }
                        transferStation = SubwayStationOption(
                            key = "${city.id}:google:transfer:$transferName",
                            name = transferName,
                            latitude = transferLocation?.first ?: origin.latitude,
                            longitude = transferLocation?.second ?: origin.longitude,
                            routes = listOf(info)
                        )
                    }
                }

                val stopDetails = transit.optJSONObject("stopDetails") ?: continue
                val departureStop = stopDetails.optJSONObject("departureStop")
                val arrivalStop = stopDetails.optJSONObject("arrivalStop")

                if (departureStop != null) {
                    val station = googleTransitStopToStation(
                        city = city,
                        stop = departureStop,
                        routeInfo = info
                    )
                    addUniqueRouteStation(planStations, station)
                }

                if (arrivalStop != null) {
                    val station = googleTransitStopToStation(
                        city = city,
                        stop = arrivalStop,
                        routeInfo = info
                    )
                    addUniqueRouteStation(planStations, station)
                }

                previousRouteId = routeId
            }
        }

        if (planStations.isEmpty()) {
            planStations += SubwayRouteStation(
                stationKey = origin.key,
                name = origin.name,
                latitude = origin.latitude,
                longitude = origin.longitude,
                routeId = routeInfos.firstOrNull()?.routeId ?: origin.routes.firstOrNull()?.routeId ?: ""
            )
            planStations += SubwayRouteStation(
                stationKey = destination.key,
                name = destination.name,
                latitude = destination.latitude,
                longitude = destination.longitude,
                routeId = routeInfos.lastOrNull()?.routeId ?: destination.routes.firstOrNull()?.routeId ?: ""
            )
        } else {
            if (planStations.first().name != origin.name) {
                planStations.add(
                    0,
                    SubwayRouteStation(
                        stationKey = origin.key,
                        name = origin.name,
                        latitude = origin.latitude,
                        longitude = origin.longitude,
                        routeId = routeInfos.firstOrNull()?.routeId ?: ""
                    )
                )
            }
            if (planStations.last().name != destination.name) {
                planStations += SubwayRouteStation(
                    stationKey = destination.key,
                    name = destination.name,
                    latitude = destination.latitude,
                    longitude = destination.longitude,
                    routeId = routeInfos.lastOrNull()?.routeId ?: ""
                )
            }
        }

        val primaryRoute = routeInfos.firstOrNull()
            ?: origin.routes.firstOrNull()
            ?: SubwayRouteInfo(
                routeId = "${city.id}:google:transit",
                shortName = "地铁",
                longName = "Transit",
                color = FALLBACK_ROUTE_COLOR
            )
        val secondaryRoute = routeInfos.drop(1).firstOrNull()
        val actualTransfer = transferStation
            ?: if (secondaryRoute != null) {
                val index = planStations.indexOfFirst {
                    it.routeId == secondaryRoute.routeId
                }
                planStations.getOrNull(index).let {
                    it?.let { station ->
                        SubwayStationOption(
                            key = station.stationKey,
                            name = station.name,
                            latitude = station.latitude,
                            longitude = station.longitude,
                            routes = listOf(secondaryRoute)
                        )
                    }
                }
            } else {
                null
            }

        val finalPath = if (routePath.size >= 2) {
            routePath
        } else {
            listOf(
                RoutePoint(origin.latitude, origin.longitude),
                RoutePoint(destination.latitude, destination.longitude)
            )
        }

        return SubwayRoutePlan(
            cityId = city.id,
            primaryRoute = primaryRoute,
            secondaryRoute = secondaryRoute,
            transferStation = actualTransfer,
            transferStationKey = actualTransfer?.key.orEmpty(),
            stations = planStations,
            routePath = finalPath,
            routeInfos = routeInfos.toList()
        )
    }

    private suspend fun googleResolvePlan(
        context: Context,
        city: SubwayCity,
        originName: String,
        destinationName: String
    ): SubwayRoutePlan? = withContext(Dispatchers.IO) {
        runCatching {
            googleResolvePlanBlocking(
                context = context,
                city = city,
                originName = originName,
                destinationName = destinationName
            )
        }.getOrNull()
    }

    private fun googleFindStationBlocking(
        context: Context,
        city: SubwayCity,
        input: String
    ): SubwayStationOption? {
        val results = googleSearchStationsBlocking(
            context = context,
            city = city,
            query = input,
            limit = 8
        )
        val normalized = normalizeSearch(input)
        return results.firstOrNull {
            normalizeSearch(it.name) == normalized
        } ?: results.firstOrNull()
    }

    private fun googleTransitStopToStation(
        city: SubwayCity,
        stop: JSONObject,
        routeInfo: SubwayRouteInfo
    ): SubwayRouteStation {
        val name = stop.optString("name").ifBlank { "站点" }
        val (latitude, longitude) = googleRouteLocation(stop)
        return SubwayRouteStation(
            stationKey = "${city.id}:google:route:${normalizeSearch(name)}",
            name = name,
            latitude = latitude,
            longitude = longitude,
            routeId = routeInfo.routeId
        )
    }

    private fun googleRouteLocation(stopOrLocation: JSONObject): Pair<Double, Double> {
        val directLat = stopOrLocation.optDouble("latitude", Double.NaN)
        val directLon = stopOrLocation.optDouble("longitude", Double.NaN)
        if (directLat.isFinite() && directLon.isFinite()) {
            return directLat to directLon
        }

        val location = stopOrLocation.optJSONObject("location")
        val latLng = location?.optJSONObject("latLng")
        val nestedLat = latLng?.optDouble("latitude", Double.NaN) ?: Double.NaN
        val nestedLon = latLng?.optDouble("longitude", Double.NaN) ?: Double.NaN
        return if (nestedLat.isFinite() && nestedLon.isFinite()) {
            nestedLat to nestedLon
        } else {
            0.0 to 0.0
        }
    }

    private fun addUniqueRouteStation(
        list: MutableList<SubwayRouteStation>,
        station: SubwayRouteStation
    ) {
        val duplicate = list.lastOrNull {
            normalizeSearch(it.name) == normalizeSearch(station.name)
        }
        if (duplicate == null) {
            list += station
        }
    }

    private fun googlePostJson(
        urlString: String,
        apiKey: String,
        fieldMask: String,
        body: JSONObject,
        apiKeyHeader: String = "X-Goog-Api-Key"
    ): JSONObject {
        val connection = (URL(urlString).openConnection() as HttpURLConnection).apply {
            requestMethod = "POST"
            connectTimeout = 20_000
            readTimeout = 30_000
            instanceFollowRedirects = true
            doOutput = true
            setRequestProperty("Content-Type", "application/json")
            setRequestProperty(apiKeyHeader, apiKey)
            setRequestProperty("X-Goog-FieldMask", fieldMask)
            setRequestProperty("User-Agent", "Tickets/6.0 SubwayData")
        }

        return try {
            connection.outputStream.bufferedWriter(Charsets.UTF_8).use {
                it.write(body.toString())
            }

            val status = connection.responseCode
            val stream = if (status in 200..299) {
                connection.inputStream
            } else {
                connection.errorStream
            }
            val raw = stream?.bufferedReader(Charsets.UTF_8)?.use { it.readText() }.orEmpty()
            if (status !in 200..299) {
                throw IllegalStateException("Google Maps API HTTP $status: $raw")
            }
            JSONObject(raw)
        } finally {
            connection.disconnect()
        }
    }

    private fun parseHexColor(raw: String): Int? {
        val clean = raw.trim().removePrefix("#")
        if (clean.length != 6) return null
        return runCatching {
            (0xFF000000L or clean.toLong(16)).toInt()
        }.getOrNull()
    }

    private fun decodeEncodedPolyline(encoded: String): List<RoutePoint> {
        val result = ArrayList<RoutePoint>()
        var index = 0
        var latitude = 0
        var longitude = 0

        while (index < encoded.length) {
            var shift = 0
            var value = 0
            while (index < encoded.length) {
                val b = encoded[index++].code - 63
                value = value or ((b and 0x1F) shl shift)
                shift += 5
                if (b < 0x20) break
            }
            val deltaLat = if ((value and 1) != 0) {
                (value ushr 1).inv()
            } else {
                value ushr 1
            }
            latitude += deltaLat

            shift = 0
            value = 0
            while (index < encoded.length) {
                val b = encoded[index++].code - 63
                value = value or ((b and 0x1F) shl shift)
                shift += 5
                if (b < 0x20) break
            }
            val deltaLon = if ((value and 1) != 0) {
                (value ushr 1).inv()
            } else {
                value ushr 1
            }
            longitude += deltaLon

            result += RoutePoint(
                latitude = latitude / 100_000.0,
                longitude = longitude / 100_000.0
            )
        }

        return result
    }

    private fun nearestDistanceToRoute(
        latitude: Double,
        longitude: Double,
        path: List<RoutePoint>
    ): Double {
        if (path.isEmpty()) return Double.MAX_VALUE
        var best = Double.MAX_VALUE
        for (point in path) {
            best = min(
                best,
                distanceMeters(
                    latitude,
                    longitude,
                    point.latitude,
                    point.longitude
                )
            )
        }
        return best
    }

    internal suspend fun searchNearbyGoogleStations(
        context: Context,
        city: SubwayCity,
        latitude: Double,
        longitude: Double,
        radiusMeters: Double
    ): List<SubwayStationOption> =
        googleNearbyStations(
            context = context,
            city = city,
            latitude = latitude,
            longitude = longitude,
            radiusMeters = radiusMeters
        )

    fun clearCurrentCache(context: Context) {
        synchronized(cacheLock) {
            memoryIndexes.clear()
            runCatching { File(context.cacheDir, CACHE_FILE_NAME).delete() }
            runCatching {
                context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
                    .edit()
                    .remove(PREF_ACTIVE_CITY)
                    .remove(PREF_LAST_BUILD)
                    .apply()
            }
        }
    }

    internal fun loadOrBuildIndex(context: Context, cityId: String): StaticIndex {
        // 颜色库必须在任何线路索引构建/恢复之前完成初始化。
        // 否则 SubwayLineColorRepository.colorFor() 会一直处于未加载状态，
        // 最终退回旧的城市颜色表或 GTFS/sourceColor，导致 JSON 没有真正生效。
        SubwayLineColorRepository.ensureInitialized(context)

        memoryIndexes[cityId]?.let { return it }

        val city = cityOrNull(cityId) ?: cityOrNull("nyc")
        ?: throw IllegalStateException("No subway city configured")

        if (city.sourceType == SourceType.TAIWAN_DISPLAY_ONLY) {
            return StaticIndex(
                stationsByKey = emptyMap(),
                routeByStation = emptyMap(),
                routePatterns = emptyMap(),
                routeInfo = emptyMap()
            )
        }

        if (city.sourceType == SourceType.LOCAL_US) {
            val index = loadLocalUsIndex(context, city)
            val colored = runCatching {
                applyCanonicalLineColors(city.id, index)
            }.getOrDefault(index)
            val sanitized = runCatching {
                sanitizeWuhanRouteTopology(city.id, colored)
            }.getOrDefault(colored)
            val normalizedTopology = runCatching {
                normalizeStaticIndexTopology(sanitized)
            }.getOrDefault(sanitized)
            memoryIndexes[cityId] = normalizedTopology
            return normalizedTopology
        }

        val cacheFile = File(context.cacheDir, CACHE_FILE_NAME)

        synchronized(cacheLock) {
            val prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
            val cachedCity = prefs.getString(PREF_ACTIVE_CITY, "").orEmpty()
            val age = System.currentTimeMillis() - prefs.getLong(PREF_LAST_BUILD, 0L)

            if (cachedCity == city.id && cacheFile.exists() && age < STATIC_REFRESH_MS) {
                runCatching {
                    val rawIndex = loadIndex(cacheFile)
                    val coloredIndex = runCatching {
                        applyCanonicalLineColors(city.id, rawIndex)
                    }.getOrDefault(rawIndex)
                    val index = runCatching {
                        sanitizeWuhanRouteTopology(city.id, coloredIndex)
                    }.getOrDefault(coloredIndex)
                    val normalizedTopology = runCatching {
                        normalizeStaticIndexTopology(index)
                    }.getOrDefault(index)
                    memoryIndexes[city.id] = normalizedTopology
                    runCatching { saveIndex(cacheFile, normalizedTopology) }
                    return normalizedTopology
                }
            }

            runCatching { cacheFile.delete() }

            val rawIndex = buildIndexForCity(context, city)
            val coloredIndex = runCatching {
                applyCanonicalLineColors(city.id, rawIndex)
            }.getOrDefault(rawIndex)
            val index = runCatching {
                sanitizeWuhanRouteTopology(city.id, coloredIndex)
            }.getOrDefault(coloredIndex)
            val normalizedTopology = runCatching {
                normalizeStaticIndexTopology(index)
            }.getOrDefault(index)
            memoryIndexes[city.id] = normalizedTopology
            runCatching { saveIndex(cacheFile, normalizedTopology) }
            prefs.edit()
                .putString(PREF_ACTIVE_CITY, city.id)
                .putLong(PREF_LAST_BUILD, System.currentTimeMillis())
                .apply()
            return normalizedTopology
        }
    }

    private fun buildIndexForCity(context: Context, city: SubwayCity): StaticIndex {
        return when (city.sourceType) {
            SourceType.AMAP -> buildAmapIndex(city)
            SourceType.GOOGLE -> error("Google 城市不建立静态索引")
            SourceType.LOCAL_US -> loadLocalUsIndex(context, city)
            SourceType.TAIWAN_DISPLAY_ONLY -> StaticIndex(
                stationsByKey = emptyMap(),
                routeByStation = emptyMap(),
                routePatterns = emptyMap(),
                routeInfo = emptyMap()
            )
        }
    }

    private fun loadLocalUsIndex(
        context: Context,
        city: SubwayCity
    ): StaticIndex {
        require(city.sourceType == SourceType.LOCAL_US)

        val assetPath = city.localAssetPath.ifBlank {
            "${LOCAL_US_ASSET_PREFIX}${city.id}.json.gz"
        }

        // 1. 正式 APK 优先读取预编译本地资产。
        runCatching {
            context.assets.open(assetPath).use { rawInput ->
                GZIPInputStream(rawInput).bufferedReader(Charsets.UTF_8).use { reader ->
                    val index = normalizeLocalUsIndex(
                        city.id,
                        fromJson(JSONObject(reader.readText()))
                    )
                    if (index.stationsByKey.isNotEmpty()) return index
                }
            }
        }

        // 2. 没有随 APK 打包时，读取已经下载并转换好的本地静态缓存。
        val localDir = File(context.filesDir, LOCAL_US_FILE_DIR)
        val localFile = File(localDir, "${city.id}.json.gz")
        if (localFile.exists()) {
            val age = System.currentTimeMillis() - localFile.lastModified()
            if (age <= LOCAL_US_REFRESH_MS) {
                runCatching {
                    val index = normalizeLocalUsIndex(
                        city.id,
                        loadIndex(localFile)
                    )
                    if (index.stationsByKey.isNotEmpty()) return index
                }
            }
        }

        // 3. 美国支持城市已改为“App 本地站点/线路 + Cloudflare Pattern 翻译层”。
        // 因此 Android 不再直接下载/解析美国原始静态 GTFS。
        if (SERVER_PATTERN_US_CITY_IDS.contains(city.id)) {
            return localFile.takeIf { it.exists() }?.let {
                runCatching {
                    normalizeLocalUsIndex(city.id, loadIndex(it))
                }.getOrNull()
            } ?: StaticIndex(emptyMap(), emptyMap(), emptyMap(), emptyMap())
        }

        // 非服务器接入的美国城市走原有逻辑（当前城市目录已不再包含它们）。
        if (city.staticGtfsUrl.isBlank()) {
            return localFile.takeIf { it.exists() }?.let {
                runCatching {
                    normalizeLocalUsIndex(city.id, loadIndex(it))
                }.getOrNull()
            } ?: StaticIndex(emptyMap(), emptyMap(), emptyMap(), emptyMap())
        }

        return runCatching {
            localDir.mkdirs()
            val zipFile = File(localDir, "${city.id}.gtfs.zip")
            val tempZip = File(localDir, "${city.id}.gtfs.zip.tmp")
            downloadBinary(city.staticGtfsUrl, tempZip)
            if (zipFile.exists()) zipFile.delete()
            tempZip.renameTo(zipFile)

            val index = normalizeLocalUsIndex(
                city.id,
                parseGtfsStaticZip(
                    city = city,
                    zipFile = zipFile
                )
            )
            saveIndex(localFile, index)
            runCatching { zipFile.delete() }
            index
        }.getOrElse {
            runCatching {
                if (localFile.exists()) {
                    normalizeLocalUsIndex(city.id, loadIndex(localFile))
                } else {
                    StaticIndex(emptyMap(), emptyMap(), emptyMap(), emptyMap())
                }
            }.getOrDefault(StaticIndex(emptyMap(), emptyMap(), emptyMap(), emptyMap()))
        }
    }

    private fun normalizeLocalUsIndex(
        cityId: String,
        index: StaticIndex
    ): StaticIndex {
        val normalizedRoutes = index.routeInfo.mapValues { (_, route) ->
            val color = canonicalLineColor(
                cityId = cityId,
                shortName = route.shortName,
                routeId = route.routeId,
                sourceColor = route.color
            )
            route.copy(color = color)
        }

        val normalizedStations = index.stationsByKey.mapValues { (_, station) ->
            station.copy(
                routes = station.routes.map { route ->
                    normalizedRoutes[route.routeId] ?: route
                }
            )
        }

        val normalizedIndex = index.copy(
            stationsByKey = normalizedStations,
            routeInfo = normalizedRoutes
        )

        return sanitizeWuhanRouteTopology(
            cityId = cityId,
            index = normalizedIndex
        )
    }

    private fun nycSubwayRouteColor(shortName: String): Int? {
        val key = normalizeSearch(shortName)
        return when {
            key == "1" || key == "2" || key == "3" -> 0xFFEE352E.toInt()
            key == "4" || key == "5" || key == "6" -> 0xFF00933C.toInt()
            key == "7" -> 0xFFB933AD.toInt()
            key == "a" || key == "c" || key == "e" -> 0xFF0039A6.toInt()
            key == "b" || key == "d" || key == "f" || key == "m" -> 0xFFFF6319.toInt()
            key == "g" -> 0xFF6CBE45.toInt()
            key == "j" || key == "z" -> 0xFF996633.toInt()
            key == "l" -> 0xFFA7A9AC.toInt()
            key == "n" || key == "q" || key == "r" || key == "w" -> 0xFFFCCC0A.toInt()
            key == "s" -> 0xFF808183.toInt()
            else -> null
        }
    }

    private fun downloadBinary(urlString: String, target: File) {
        val connection = (URL(urlString).openConnection() as HttpURLConnection).apply {
            requestMethod = "GET"
            connectTimeout = 30_000
            readTimeout = 120_000
            instanceFollowRedirects = true
            setRequestProperty("User-Agent", "Tickets/6.0 SubwayData")
        }
        try {
            if (connection.responseCode !in 200..299) {
                throw IllegalStateException("HTTP ${connection.responseCode}: $urlString")
            }
            connection.inputStream.use { input ->
                FileOutputStream(target).use { output ->
                    val buffer = ByteArray(64 * 1024)
                    while (true) {
                        val read = input.read(buffer)
                        if (read <= 0) break
                        output.write(buffer, 0, read)
                    }
                    output.fd.sync()
                }
            }
        } finally {
            connection.disconnect()
        }
    }

    private fun parseGtfsStaticZip(
        city: SubwayCity,
        zipFile: File
    ): StaticIndex {
        data class GtfsStop(
            val id: String,
            val name: String,
            val lat: Double,
            val lon: Double,
            val parentId: String,
            val locationType: Int,
            val platformCode: String
        )

        data class GtfsRoute(
            val id: String,
            val shortName: String,
            val longName: String,
            val color: Int,
            val type: Int
        )

        val stops = LinkedHashMap<String, GtfsStop>()
        val routes = LinkedHashMap<String, GtfsRoute>()
        val rawRouteToCanonical = HashMap<String, String>()
        val tripToRoute = HashMap<String, String>()

        ZipFile(zipFile).use { zip ->
            readGtfsRows(zip, "routes.txt").forEach { row ->
                val routeType = row["route_type"]?.toIntOrNull() ?: return@forEach
                if (city.gtfsRouteTypes.isNotEmpty() && routeType !in city.gtfsRouteTypes) return@forEach
                val rawRouteId = row["route_id"].orEmpty()
                if (rawRouteId.isBlank()) return@forEach
                val rawShortName = firstNonBlank(
                    row["route_short_name"].orEmpty(),
                    row["route_long_name"].orEmpty(),
                    rawRouteId
                )
                val rawLongName = firstNonBlank(
                    row["route_long_name"].orEmpty(),
                    rawShortName
                )

                // ==============================
                // US-only route identity normalization.
                // 中国大陆 + 香港 AMAP parser 不进入这里。
                // ==============================
                val canonical = canonicalUsRouteIdentity(
                    cityId = city.id,
                    rawRouteId = rawRouteId,
                    rawShortName = rawShortName,
                    rawLongName = rawLongName
                ) ?: return@forEach

                val canonicalRouteId = canonical.first
                val shortName = canonical.second
                val longName = canonical.third

                // US static-feed colors: first use the agency-published GTFS route_color.
                // normalizeLocalUsIndex() may replace it with a separately verified official
                // brand value for cities where we have a direct official color specification.
                val sourceColor =
                    parseGtfsRouteColor(row["route_color"].orEmpty())
                        ?: FALLBACK_ROUTE_COLOR

                val existing = routes[canonicalRouteId]
                routes[canonicalRouteId] = if (existing == null) {
                    GtfsRoute(
                        id = canonicalRouteId,
                        shortName = shortName,
                        longName = longName,
                        color = sourceColor,
                        type = routeType
                    )
                } else {
                    existing.copy(
                        longName = existing.longName.ifBlank { longName }
                    )
                }

                rawRouteToCanonical[rawRouteId] = canonicalRouteId
            }

            readGtfsRows(zip, "stops.txt").forEach { row ->
                val id = row["stop_id"].orEmpty()
                val name = firstNonBlank(
                    row["stop_name"].orEmpty(),
                    row["tts_stop_name"].orEmpty(),
                    row["stop_code"].orEmpty()
                )
                if (id.isBlank() || name.isBlank()) return@forEach
                val lat = row["stop_lat"]?.toDoubleOrNull() ?: Double.NaN
                val lon = row["stop_lon"]?.toDoubleOrNull() ?: Double.NaN
                val locationType = row["location_type"]?.toIntOrNull() ?: 0
                if (!lat.isFinite() || !lon.isFinite()) return@forEach
                stops[id] = GtfsStop(
                    id = id,
                    name = name,
                    lat = lat,
                    lon = lon,
                    parentId = row["parent_station"].orEmpty(),
                    locationType = locationType,
                    platformCode = row["platform_code"].orEmpty()
                )
            }

            readGtfsRows(zip, "trips.txt").forEach { row ->
                val tripId = row["trip_id"].orEmpty()
                val rawRouteId = row["route_id"].orEmpty()
                val routeId = rawRouteToCanonical[rawRouteId] ?: rawRouteId
                if (tripId.isNotBlank() && routes.containsKey(routeId)) {
                    tripToRoute[tripId] = routeId
                }
            }

            val tripRows = HashMap<String, MutableList<Pair<Int, String>>>()
            readGtfsRows(zip, "stop_times.txt").forEach { row ->
                val tripId = row["trip_id"].orEmpty()
                val routeId = tripToRoute[tripId] ?: return@forEach
                val stopId = row["stop_id"].orEmpty()
                if (!stops.containsKey(stopId)) return@forEach
                val sequence = row["stop_sequence"]?.toIntOrNull() ?: return@forEach
                tripRows.getOrPut(tripId) { ArrayList() }.add(sequence to stopId)
            }

            val stationKeyByStopId = HashMap<String, String>()
            val stationMeta = LinkedHashMap<String, SubwayStationOption>()

            fun stationKeyFor(stopId: String): String {
                stationKeyByStopId[stopId]?.let { return it }
                val stop = stops.getValue(stopId)
                val parentId = stop.parentId.takeIf { it.isNotBlank() && stops.containsKey(it) }
                val key = "${city.id}:gtfs:${parentId ?: stop.id}"
                stationKeyByStopId[stopId] = key
                return key
            }

            fun stationNameFor(key: String, stopId: String): String {
                val parentId = stops[stopId]?.parentId.orEmpty()
                return stops[parentId]?.name
                    ?.takeIf { it.isNotBlank() }
                    ?: stops[stopId]?.name
                    ?: key.substringAfterLast(':')
            }

            for ((routeId, route) in routes) {
                // 预先登记线路，真正的站点关系在 trip pattern 阶段生成。
                @Suppress("UNUSED_VARIABLE")
                val ignored = route
            }

            val routeInfo = HashMap<String, SubwayRouteInfo>()
            routes.values.forEach { route ->
                routeInfo[route.id] = SubwayRouteInfo(
                    routeId = route.id,
                    shortName = route.shortName,
                    longName = route.longName,
                    color = route.color
                )
            }

            val routePatterns = HashMap<String, MutableList<List<String>>>()
            val routePatternSignatures = HashMap<String, MutableSet<String>>()
            val routeByStation = HashMap<String, MutableSet<String>>()

            for ((tripId, rows) in tripRows) {
                val routeId = tripToRoute[tripId] ?: continue
                val route = routes[routeId] ?: continue
                val ordered = rows.sortedBy { it.first }
                val stationKeys = ArrayList<String>(ordered.size)
                for ((_, stopId) in ordered) {
                    val key = stationKeyFor(stopId)
                    if (stationKeys.lastOrNull() != key) stationKeys += key
                }
                if (stationKeys.size < 2) continue

                val routeInfoValue = routeInfo.getValue(routeId)
                for ((index, stationKey) in stationKeys.withIndex()) {
                    val representativeStopId = ordered.firstOrNull { stationKeyFor(it.second) == stationKey }?.second
                    val stationStop = representativeStopId?.let { stops[it] } ?: continue
                    val parentStop = stationStop.parentId.takeIf { it.isNotBlank() }?.let { stops[it] }
                    val coordinateStop = parentStop ?: stationStop
                    val displayName = parentStop?.name?.ifBlank { null } ?: stationStop.name
                    val existing = stationMeta[stationKey]
                    val aliasSet = LinkedHashSet<String>(existing?.searchNames.orEmpty())
                    aliasSet += stationStop.name
                    parentStop?.name?.let { aliasSet += it }
                    stationStop.platformCode.takeIf { it.isNotBlank() }?.let { aliasSet += "${stationStop.name} $it" }
                    stationMeta[stationKey] = if (existing == null) {
                        SubwayStationOption(
                            key = stationKey,
                            name = displayName,
                            latitude = coordinateStop.lat,
                            longitude = coordinateStop.lon,
                            routes = listOf(routeInfoValue),
                            searchNames = aliasSet.toList()
                        )
                    } else {
                        existing.copy(
                            routes = (existing.routes + routeInfoValue)
                                .distinctBy { it.routeId }
                                .sortedBy { it.shortName },
                            searchNames = aliasSet.toList()
                        )
                    }
                    routeByStation.getOrPut(stationKey) { LinkedHashSet() }.add(routeId)
                }

                val signature = stationKeys.joinToString("|")
                val signatures = routePatternSignatures.getOrPut(routeId) { LinkedHashSet() }
                if (signatures.add(signature)) {
                    routePatterns.getOrPut(routeId) { ArrayList() }.add(stationKeys)
                }
            }

            return StaticIndex(
                stationsByKey = stationMeta,
                routeByStation = routeByStation.mapValues { it.value.toSet() },
                routePatterns = routePatterns.mapValues { it.value.toList() },
                routeInfo = routeInfo
            )
        }
    }


    /**
     * US-only GTFS route identity mapping. Branches are folded into the same
     * passenger-facing line where the agency defines them as one line;
     * non-subway/non-rail service is excluded for the selected city feed.
     */
    private fun canonicalUsRouteIdentity(
        cityId: String,
        rawRouteId: String,
        rawShortName: String,
        rawLongName: String
    ): Triple<String, String, String>? {
        val key = normalizeSearch(rawShortName)
            .replace("-", "")
            .replace("_", "")
            .lowercase(Locale.US)

        return when (cityId) {
            "nyc" -> {
                when {
                    key == "sir" || key == "si" ->
                        Triple("us:nyc:sir", "SIR", "Staten Island Railway")
                    key == "s" ->
                        Triple("us:nyc:s:${rawRouteId.lowercase(Locale.US)}", "S", rawLongName)
                    else ->
                        Triple(
                            "us:nyc:${key.ifBlank { rawRouteId.lowercase(Locale.US) }}",
                            rawShortName,
                            rawLongName
                        )
                }
            }

            "washington_dc" -> {
                val line = when (key) {
                    "rd", "red", "redline" -> "Red Line"
                    "or", "orange", "orangeline" -> "Orange Line"
                    "bl", "blue", "blueline" -> "Blue Line"
                    "gr", "green", "greenline" -> "Green Line"
                    "yl", "yellow", "yellowline" -> "Yellow Line"
                    "sv", "silver", "silverline" -> "Silver Line"
                    else -> null
                } ?: return null
                val token = line.lowercase(Locale.US).replace(Regex("\\s+"), "_")
                Triple("us:washington_dc:$token", line, line)
            }

            "boston" -> {
                val line = when {
                    key == "red" || key.startsWith("red") -> "Red Line"
                    key == "orange" || key.startsWith("orange") -> "Orange Line"
                    key == "blue" || key.startsWith("blue") -> "Blue Line"
                    key == "green" || key.startsWith("green") -> "Green Line"
                    else -> return null
                }
                val token = line.lowercase(Locale.US).replace(Regex("\\s+"), "_")
                Triple("us:boston:$token", line, line)
            }

            "philadelphia" -> {
                val line = when {
                    key == "l1" || key == "mfl" || key == "l" -> "L"
                    key == "b1" || key == "b2" || key == "b3" || key == "bsl" || key == "b" -> "B"
                    key.startsWith("t") -> "T"
                    key == "g1" || key == "g" -> "G"
                    key.startsWith("d") -> "D"
                    key.startsWith("m") -> "M"
                    else -> return null
                }
                Triple("us:philadelphia:$line", line, rawLongName)
            }

            "chicago" -> {
                val line = rawShortName.trim()
                val normalized = normalizeSearch(line).lowercase(Locale.US)
                if (normalized.isBlank()) return null
                Triple("us:chicago:$normalized", line, rawLongName)
            }

            "san_francisco_bay" -> {
                if (key == "oak" || rawLongName.contains("Oakland Airport", ignoreCase = true)) {
                    null
                } else {
                    val line = rawShortName.trim()
                    Triple(
                        "us:san_francisco_bay:${key.ifBlank { rawRouteId.lowercase(Locale.US) }}",
                        line,
                        rawLongName
                    )
                }
            }

            "los_angeles" -> {
                val line = normalizeSearch(rawShortName)
                    .removeSuffix("line")
                    .uppercase(Locale.US)
                    .trim()
                if (line == "G" || line == "J") {
                    null
                } else if (line in setOf("A", "B", "C", "D", "E", "K")) {
                    Triple("us:los_angeles:$line", line, rawLongName)
                } else {
                    null
                }
            }

            else -> null
        }
    }

    private fun readGtfsRows(
        zip: ZipFile,
        fileName: String
    ): Sequence<Map<String, String>> = sequence {
        val entry = zip.getEntry(fileName) ?: return@sequence
        val input = zip.getInputStream(entry)
        val reader = input.bufferedReader(Charsets.UTF_8)
        try {
            val headerLine = reader.readLine() ?: return@sequence
            val headers = parseCsvLine(headerLine)
            while (true) {
                val raw = reader.readLine() ?: break
                if (raw.isBlank()) continue
                val values = parseCsvLine(raw)
                val row = HashMap<String, String>(headers.size)
                headers.forEachIndexed { index, header ->
                    row[header.trim().removePrefix("\uFEFF")] =
                        values.getOrNull(index).orEmpty()
                }
                yield(row)
            }
        } finally {
            runCatching { reader.close() }
        }
    }

    private fun parseCsvLine(line: String): List<String> {
        val result = ArrayList<String>()
        val current = StringBuilder()
        var quoted = false
        var index = 0
        while (index < line.length) {
            val ch = line[index]
            when {
                ch == '"' -> {
                    if (quoted && index + 1 < line.length && line[index + 1] == '"') {
                        current.append('"')
                        index++
                    } else {
                        quoted = !quoted
                    }
                }
                ch == ',' && !quoted -> {
                    result += current.toString()
                    current.setLength(0)
                }
                else -> current.append(ch)
            }
            index++
        }
        result += current.toString()
        return result
    }

    private fun parseGtfsRouteColor(raw: String): Int? {
        val clean = raw.trim().removePrefix("#")
        if (clean.length != 6) return null
        return runCatching { (0xFF000000L or clean.toLong(16)).toInt() }.getOrNull()
    }

    private fun buildAmapIndex(city: SubwayCity): StaticIndex {
        require(city.amapCode.isNotBlank() && city.amapSlug.isNotBlank())
        val url =
            "https://map.amap.com/service/subway?_1555502190153&srhdata=${city.amapCode}_drw_${city.amapSlug}.json"
        val json = downloadText(url)
        return parseAmapJson(city, json)
    }

    private fun parseAmapJson(city: SubwayCity, text: String): StaticIndex {
        val root = JSONObject(text)
        val lines = root.optJSONArray("l") ?: root.optJSONArray("lines") ?: JSONArray()
        val stations = LinkedHashMap<String, SubwayStationOption>()
        val routeByStation = HashMap<String, MutableSet<String>>()
        val routePatterns = HashMap<String, MutableList<List<String>>>()
        val routeInfo = HashMap<String, SubwayRouteInfo>()

        for (i in 0 until lines.length()) {
            val line = lines.optJSONObject(i) ?: continue
            val rawName = firstNonBlank(
                line.optString("ln"),
                line.optString("name"),
                line.optString("la"),
                line.optString("ls")
            )
            if (rawName.isBlank()) continue

            val routeCode = firstNonBlank(
                line.optString("ls"),
                line.optString("lineId"),
                normalizeLineName(rawName)
            )
            val routeId = "${city.id}:$routeCode"
            val shortName = normalizeLineName(rawName).ifBlank { rawName }
            val longName = rawName
            val color = routeColor(city.id, shortName, routeCode, i)
            routeInfo[routeId] = SubwayRouteInfo(routeId, shortName, longName, color)

            val stationArray = line.optJSONArray("st") ?: line.optJSONArray("stations") ?: continue
            val pattern = ArrayList<String>(stationArray.length())

            for (j in 0 until stationArray.length()) {
                val stop = stationArray.optJSONObject(j) ?: continue
                val stationId = firstNonBlank(
                    stop.optString("sid"),
                    stop.optString("id"),
                    stop.optString("si")
                )
                val stationName = firstNonBlank(
                    stop.optString("n"),
                    stop.optString("name"),
                    stop.optString("sn")
                )
                val coord = firstNonBlank(
                    stop.optString("sl"),
                    stop.optString("location"),
                    stop.optString("coord")
                )
                val pair = parseCoordinatePair(coord) ?: continue
                if (stationName.isBlank()) continue

                val key = "${city.id}:$stationId:${normalizeSearch(stationName)}"
                val existing = stations[key]
                if (existing == null) {
                    stations[key] = SubwayStationOption(
                        key = key,
                        name = stationName,
                        latitude = pair.first,
                        longitude = pair.second,
                        routes = listOf(routeInfo.getValue(routeId))
                    )
                } else if (existing.routes.none { it.routeId == routeId }) {
                    stations[key] = existing.copy(
                        routes = (existing.routes + routeInfo.getValue(routeId))
                            .sortedBy { it.shortName }
                    )
                }

                routeByStation.getOrPut(key) { LinkedHashSet() }.add(routeId)
                if (pattern.lastOrNull() != key) pattern += key
            }

            if (pattern.size >= 2) {
                val signature = pattern.joinToString("|")
                val existingSignatures = routePatterns
                    .getOrPut(routeId) { ArrayList() }
                    .map { it.joinToString("|") }
                if (signature !in existingSignatures) {
                    routePatterns.getValue(routeId).add(pattern)
                }
            }
        }

        return StaticIndex(
            stationsByKey = stations,
            routeByStation = routeByStation.mapValues { it.value.toSet() },
            routePatterns = routePatterns.mapValues { it.value.toList() },
            routeInfo = routeInfo
        )
    }



    private data class RouteSearchState(
        val stationKey: String,
        val routeId: String
    )

    private data class RouteSearchScore(
        val transfers: Int,
        val stops: Int
    ) : Comparable<RouteSearchScore> {
        override fun compareTo(other: RouteSearchScore): Int {
            val transferCompare = transfers.compareTo(other.transfers)
            return if (transferCompare != 0) {
                transferCompare
            } else {
                stops.compareTo(other.stops)
            }
        }
    }

    private data class RouteQueueNode(
        val state: RouteSearchState,
        val score: RouteSearchScore
    )

    private const val MAX_ROUTE_TRANSFERS = 6

    /**
     * 全城市统一的多次换乘路线搜索。
     *
     * 旧实现只枚举“起始线路 + 目的线路”，因此最多只能处理一次换乘。
     * 现在把“车站 + 当前所在线路”作为搜索状态：
     * - 同线路相邻站：移动一步，增加 1 个站点成本
     * - 同站不同线路：换乘一步，增加 1 次换乘成本
     *
     * 优先级为“少换乘” > “少站”，这样不会为了少几个站而强行增加换乘。
     */
    private fun resolvePlan(
        index: StaticIndex,
        cityId: String,
        origin: String,
        destination: String
    ): SubwayRoutePlan? {
        val from = resolveStationKey(index, origin) ?: return null
        val to = resolveStationKey(index, destination) ?: return null

        if (from == to) {
            val routeId = index.routesForStation(from).sorted().firstOrNull()
                ?: return null
            val route = index.routeInfo(routeId)
            val startStation = routeStation(index, from, routeId) ?: return null
            return SubwayRoutePlan(
                cityId = cityId,
                primaryRoute = route,
                stations = listOf(startStation),
                routePath = listOf(
                    RoutePoint(startStation.latitude, startStation.longitude)
                ),
                routeInfos = listOf(route)
            )
        }

        val path = findBestRoutePath(
            index = index,
            originKey = from,
            destinationKey = to
        ) ?: return null

        // 防止武汉宏图大道再次以12号线状态进入最终路线。
        // 这是“错误路线宁可不返回，也不能返回假换乘”的最后一道保险。
        if (cityId == "wuhan") {
            val invalidPathState = path.any { state ->
                val station = index.stationOption(state.stationKey)
                station != null &&
                        normalizeLineName(index.routeInfo(state.routeId).shortName) == "12" &&
                        normalizeSearch(station.name) == normalizeSearch("宏图大道")
            }
            if (invalidPathState) return null
        }

        val stations = ArrayList<SubwayRouteStation>()
        var lastStationKey = ""

        path.forEach { state ->
            // 搜索路径在换乘时会出现“同一站、不同线路”的连续两个状态。
            // 详情路线只保留一个物理站点，并保留换乘前的线路身份；
            // 离开换乘站后的下一站自然切换到新线路。
            if (state.stationKey == lastStationKey) return@forEach

            routeStation(index, state.stationKey, state.routeId)?.let {
                stations += it
                lastStationKey = state.stationKey
            }
        }

        if (stations.isEmpty()) return null

        val routeIds = stations
            .map { it.routeId }
            .fold(ArrayList<String>()) { acc, routeId ->
                if (acc.lastOrNull() != routeId) {
                    acc += routeId
                }
                acc
            }

        val routeInfos = routeIds.map { index.routeInfo(it) }
        val primaryRoute = routeInfos.firstOrNull() ?: return null
        val secondaryRoute = routeInfos.getOrNull(1)

        var transferIndex = -1
        for (i in 0 until stations.lastIndex) {
            if (stations[i].routeId != stations[i + 1].routeId) {
                transferIndex = i
                break
            }
        }

        val transferStation = if (transferIndex >= 0) {
            index.stationOption(stations[transferIndex].stationKey)
        } else {
            null
        }

        return SubwayRoutePlan(
            cityId = cityId,
            primaryRoute = primaryRoute,
            secondaryRoute = secondaryRoute,
            transferStation = transferStation,
            transferStationKey = transferStation?.key.orEmpty(),
            stations = stations,
            routePath = stations.map {
                RoutePoint(it.latitude, it.longitude)
            },
            routeInfos = routeInfos
        )
    }

    /**
     * 在“车站 + 当前线路”状态图上做最短路径搜索。
     * 换乘次数优先，站数次优。
     */
    private fun findBestRoutePath(
        index: StaticIndex,
        originKey: String,
        destinationKey: String
    ): List<RouteSearchState>? {
        val adjacency = HashMap<RouteSearchState, MutableSet<RouteSearchState>>()

        fun addEdge(
            from: RouteSearchState,
            to: RouteSearchState
        ) {
            adjacency.getOrPut(from) { LinkedHashSet() }.add(to)
        }

        // 同一线路中，相邻站点双向连边。
        index.routePatterns.forEach { (routeId, patterns) ->
            patterns.forEach { pattern ->
                for (i in 0 until pattern.lastIndex) {
                    val a = RouteSearchState(
                        stationKey = pattern[i],
                        routeId = routeId
                    )
                    val b = RouteSearchState(
                        stationKey = pattern[i + 1],
                        routeId = routeId
                    )
                    addEdge(a, b)
                    addEdge(b, a)
                }
            }
        }

        // 同一物理站不同线路之间建立换乘边。
        // 线路身份必须来自真实 routePatterns，而不能只相信 station.routes 元数据。
        val patternRoutesByStation = HashMap<String, MutableSet<String>>()
        index.routePatterns.forEach { (routeId, patterns) ->
            patterns.forEach { pattern ->
                pattern.forEach { stationKey ->
                    patternRoutesByStation
                        .getOrPut(stationKey) { LinkedHashSet() }
                        .add(routeId)
                }
            }
        }

        patternRoutesByStation.forEach { (stationKey, routeIdSet) ->
            val routeIds = routeIdSet.sorted()
            for (i in 0 until routeIds.lastIndex) {
                for (j in i + 1 until routeIds.size) {
                    val a = RouteSearchState(
                        stationKey = stationKey,
                        routeId = routeIds[i]
                    )
                    val b = RouteSearchState(
                        stationKey = stationKey,
                        routeId = routeIds[j]
                    )
                    addEdge(a, b)
                    addEdge(b, a)
                }
            }
        }

        val bestScore = HashMap<RouteSearchState, RouteSearchScore>()
        val previous = HashMap<RouteSearchState, RouteSearchState>()
        val queue = PriorityQueue<RouteQueueNode> { a, b ->
            a.score.compareTo(b.score)
        }

        patternRoutesByStation[originKey].orEmpty()
            .sorted()
            .forEach { routeId ->
                val state = RouteSearchState(
                    stationKey = originKey,
                    routeId = routeId
                )
                val score = RouteSearchScore(
                    transfers = 0,
                    stops = 0
                )
                bestScore[state] = score
                queue += RouteQueueNode(
                    state = state,
                    score = score
                )
            }

        var bestDestination: RouteSearchState? = null
        var bestDestinationScore: RouteSearchScore? = null

        while (queue.isNotEmpty()) {
            val node = queue.poll()
            val knownScore = bestScore[node.state] ?: continue
            if (knownScore != node.score) continue

            if (node.state.stationKey == destinationKey) {
                if (
                    bestDestinationScore == null ||
                    node.score < bestDestinationScore!!
                ) {
                    bestDestination = node.state
                    bestDestinationScore = node.score
                }
                continue
            }

            adjacency[node.state]
                .orEmpty()
                .forEach { nextState ->
                    val isTransfer =
                        nextState.stationKey == node.state.stationKey &&
                                nextState.routeId != node.state.routeId

                    val nextTransfers =
                        node.score.transfers + if (isTransfer) 1 else 0
                    if (nextTransfers > MAX_ROUTE_TRANSFERS) return@forEach

                    val nextScore = RouteSearchScore(
                        transfers = nextTransfers,
                        stops = node.score.stops + if (isTransfer) 0 else 1
                    )
                    val oldScore = bestScore[nextState]

                    if (oldScore == null || nextScore < oldScore) {
                        bestScore[nextState] = nextScore
                        previous[nextState] = node.state
                        queue += RouteQueueNode(
                            state = nextState,
                            score = nextScore
                        )
                    }
                }
        }

        val end = bestDestination ?: return null
        val path = ArrayList<RouteSearchState>()
        var cursor: RouteSearchState? = end
        while (cursor != null) {
            path += cursor
            cursor = previous[cursor]
        }
        path.reverse()
        return path
    }

    private fun routeForPair(
        index: StaticIndex,
        cityId: String,
        routeId: String,
        from: String,
        to: String
    ): SubwayRoutePlan? {
        val route = index.routeInfo(routeId)
        val stations = stationsForRouteRange(index, routeId, from, to)
        if (stations.isEmpty()) return null
        return SubwayRoutePlan(
            cityId = cityId,
            primaryRoute = route,
            stations = stations,
            routePath = stations.map {
                RoutePoint(it.latitude, it.longitude)
            }
        )
    }

    private fun preferredTransferStationKey(
        index: StaticIndex,
        cityId: String,
        primaryId: String,
        secondaryId: String
    ): String? {
        if (cityId != "wuhan") return null

        val primary = normalizeLineName(index.routeInfo(primaryId).shortName)
        val secondary = normalizeLineName(index.routeInfo(secondaryId).shortName)
        val pair = setOf(primary, secondary)

        val preferredName = when {
            pair == setOf("2", "5") -> "积玉桥"
            pair == setOf("4", "5") -> "复兴路"
            pair == setOf("5", "7") -> "徐家棚"
            pair == setOf("5", "8") -> "徐家棚"
            pair == setOf("5", "12") -> "光霞"
            pair == setOf("4", "12") -> "园林路"
            pair == setOf("8", "12") -> "汪家墩"
            pair == setOf("6", "12") -> "国博中心南"
            pair == setOf("11", "12") -> "武昌站东广场"
            pair == setOf("12", "16") -> "国博中心南"
            pair == setOf("5", "19") -> "武汉站东广场"
            else -> return null
        }

        val normalized = normalizeSearch(preferredName)
        return index.stationsByKey.values
            .firstOrNull { station ->
                normalizeSearch(station.name) == normalized &&
                        station.routes.any { it.routeId == primaryId } &&
                        station.routes.any { it.routeId == secondaryId }
            }
            ?.key
    }


    private fun findTransferStation(
        index: StaticIndex,
        primaryId: String,
        secondaryId: String,
        from: String,
        to: String
    ): String? {
        val primaryCandidates = reachableAlongRoute(index, primaryId, from)
        val secondaryCandidates = reachableAlongRoute(index, secondaryId, to)

        return primaryCandidates
            .intersect(secondaryCandidates)
            .asSequence()
            .mapNotNull { key ->
                val station = index.stationOption(key) ?: return@mapNotNull null
                val primaryDistance = stationDistanceAlongRoute(
                    index,
                    primaryId,
                    from,
                    key
                ) ?: return@mapNotNull null
                val secondaryDistance = stationDistanceAlongRoute(
                    index,
                    secondaryId,
                    to,
                    key
                ) ?: return@mapNotNull null
                Triple(
                    key,
                    primaryDistance + secondaryDistance,
                    station.name
                )
            }
            .sortedWith(
                compareBy<Triple<String, Int, String>> { it.second }
                    .thenBy { it.third }
            )
            .firstOrNull()
            ?.first
    }

    private fun reachableAlongRoute(
        index: StaticIndex,
        routeId: String,
        anchor: String
    ): Set<String> {
        return index.routePatterns[routeId].orEmpty()
            .asSequence()
            .filter { anchor in it }
            .flatMap { it.asSequence() }
            .toSet()
    }

    private fun stationDistanceAlongRoute(
        index: StaticIndex,
        routeId: String,
        anchor: String,
        candidate: String
    ): Int? {
        return index.routePatterns[routeId].orEmpty()
            .mapNotNull { pattern ->
                val anchorIndex = pattern.indexOf(anchor)
                val candidateIndex = pattern.indexOf(candidate)
                if (anchorIndex >= 0 && candidateIndex >= 0) {
                    kotlin.math.abs(anchorIndex - candidateIndex)
                } else {
                    null
                }
            }
            .minOrNull()
    }

    private fun stationsForRouteRange(
        index: StaticIndex,
        routeId: String,
        from: String,
        to: String
    ): List<SubwayRouteStation> {
        val patterns = index.routePatterns[routeId].orEmpty()

        /*
         * 同一条美国 GTFS 线路通常同时包含：
         * - 全程车
         * - 短线车
         * - 快车/区间车
         * - 不同时段服务模式
         *
         * 不能简单取第一个同时包含起终点的 pattern。
         * 例如纽约 7 号线存在较短的 service pattern 时，
         * 直接取第一条会把 Grand Central-42 St 直接连到 Flushing-Main St。
         * 对同一对站点，优先选择“起点到终点之间实际包含站点最多”的 pattern，
         * 才能保留真实的中间站序列。
         */
        val candidates = patterns.mapNotNull { pattern ->
            val fromIndex = pattern.indexOf(from)
            val toIndex = pattern.indexOf(to)
            if (fromIndex < 0 || toIndex < 0 || fromIndex == toIndex) {
                null
            } else {
                val distance = kotlin.math.abs(toIndex - fromIndex)
                Triple(pattern, fromIndex, toIndex) to distance
            }
        }

        val best = candidates
            .maxByOrNull { it.second }
            ?.first
            ?: return emptyList()

        val fromIndex = best.second
        val toIndex = best.third
        val pattern = best.first
        val selected = if (fromIndex <= toIndex) {
            pattern.subList(fromIndex, toIndex + 1)
        } else {
            pattern.subList(toIndex, fromIndex + 1).reversed()
        }

        return selected
            .distinct()
            .mapNotNull { routeStation(index, it, routeId) }
    }

    private fun routeStation(
        index: StaticIndex,
        stationKey: String,
        routeId: String
    ): SubwayRouteStation? {
        val station = index.stationOption(stationKey) ?: return null
        return SubwayRouteStation(
            stationKey = stationKey,
            name = station.name,
            latitude = station.latitude,
            longitude = station.longitude,
            routeId = routeId
        )
    }

    private fun resolveStationKey(index: StaticIndex, input: String): String? {
        val normalized = normalizeStationSearch(input)
        if (normalized.isBlank()) return null

        val stations = index.stationsByKey.values

        // 第一优先级：全局精确匹配。
        // 例如“坂田北”绝不能因为“坂田”是其前缀，就先被模糊命中成“坂田”。
        stations.firstOrNull { station ->
            sequenceOf(station.name)
                .plus(station.searchNames.asSequence())
                .any { candidate ->
                    normalizeStationSearch(candidate) == normalized
                }
        }?.key?.let { return it }

        // 第二优先级：名称以用户输入开头的站点。
        stations.firstOrNull { station ->
            sequenceOf(station.name)
                .plus(station.searchNames.asSequence())
                .any { candidate ->
                    normalizeStationSearch(candidate).startsWith(normalized)
                }
        }?.key?.let { return it }

        // 第三优先级：最后才使用原有 contains 兼容逻辑。
        return stations
            .firstOrNull { stationNameMatchesSearch(it, normalized) }
            ?.key
    }

    private fun stationNameMatchesSearch(
        station: SubwayStationOption,
        normalizedQuery: String
    ): Boolean {
        if (normalizedQuery.isBlank()) return false

        val candidates = sequenceOf(station.name) + station.searchNames.asSequence()
        return candidates.any { candidate ->
            val normalizedCandidate = normalizeStationSearch(candidate)
            normalizedCandidate == normalizedQuery ||
                    normalizedCandidate.contains(normalizedQuery) ||
                    normalizedQuery.contains(normalizedCandidate)
        }
    }

    private fun normalizeStationSearch(value: String): String {
        var text = value.lowercase(Locale.ROOT)

        // 美国/英语 GTFS 站名常用缩写与完整单词混用。
        // 先统一英文词汇，再去掉标点和空格，避免例如
        // “Times Square” 与 “Times Sq” 无法命中同一站。
        val replacements = listOf(
            "street" to "st",
            "avenue" to "av",
            "square" to "sq",
            "center" to "ctr",
            "road" to "rd",
            "boulevard" to "blvd",
            "parkway" to "pkwy",
            "highway" to "hwy",
            "junction" to "jct",
            "terminal" to "",
            "station" to ""
        )

        replacements.forEach { (full, short) ->
            text = text.replace(
                Regex("\\b${Regex.escape(full)}\\b"),
                short
            )
        }

        return normalizeSearch(text)
    }

    private fun loadIndex(file: File): StaticIndex {
        val json = GZIPInputStream(FileInputStream(file)).use { input ->
            InputStreamReader(input, Charsets.UTF_8).use { it.readText() }
        }
        return fromJson(JSONObject(json))
    }

    private fun saveIndex(file: File, index: StaticIndex) {
        val temp = File(file.parentFile, file.name + ".tmp")
        val json = toJson(index).toString()
        GZIPOutputStream(temp.outputStream().buffered()).use { output ->
            output.write(json.toByteArray(Charsets.UTF_8))
        }
        if (file.exists()) file.delete()
        temp.renameTo(file)
    }

    private fun toJson(index: StaticIndex): JSONObject {
        val root = JSONObject()
        val routes = JSONArray()
        index.routeInfo.values.sortedBy { it.routeId }.forEach { route ->
            routes.put(
                JSONObject()
                    .put("id", route.routeId)
                    .put("short", route.shortName)
                    .put("long", route.longName)
                    .put("color", route.color)
            )
        }
        root.put("routes", routes)

        val stations = JSONArray()
        index.stationsByKey.values.forEach { station ->
            stations.put(
                JSONObject()
                    .put("key", station.key)
                    .put("name", station.name)
                    .put("lat", station.latitude)
                    .put("lon", station.longitude)
                    .put(
                        "routes",
                        JSONArray(station.routes.map { it.routeId })
                    )
                    .put(
                        "searchNames",
                        JSONArray(station.searchNames)
                    )
            )
        }
        root.put("stations", stations)

        val patterns = JSONObject()
        index.routePatterns.forEach { (routeId, values) ->
            val routeArray = JSONArray()
            values.take(24).forEach { pattern ->
                routeArray.put(JSONArray(pattern.take(220)))
            }
            patterns.put(routeId, routeArray)
        }
        root.put("patterns", patterns)
        return root
    }

    private fun fromJson(root: JSONObject): StaticIndex {
        val routeInfo = HashMap<String, SubwayRouteInfo>()

        // Worker 的 NYC Android index 历史上存在两种合法的 routes 形态：
        // 1) 数组：[{id, short, long, color}, ...]
        // 2) 对象：{routeId: {id, short, long, color}, ...}
        // Android 必须兼容两种形态，否则对象形态会被解析成“0 条线路”，
        // 随后 loadUsServerRoutingIndex() 会误判服务器索引无线路并回退到空的本地索引。
        val routesArray = root.optJSONArray("routes")
        if (routesArray != null) {
            for (i in 0 until routesArray.length()) {
                val obj = routesArray.optJSONObject(i) ?: continue
                val routeId = obj.optString("id").trim()
                if (routeId.isBlank()) continue
                val route = SubwayRouteInfo(
                    routeId = routeId,
                    shortName = obj.optString("short"),
                    longName = obj.optString("long"),
                    color = obj.optInt("color", FALLBACK_ROUTE_COLOR)
                )
                routeInfo[route.routeId] = route
            }
        } else {
            val routesObject = root.optJSONObject("routes")
            if (routesObject != null) {
                val routeKeys = routesObject.keys()
                while (routeKeys.hasNext()) {
                    val key = routeKeys.next()
                    val obj = routesObject.optJSONObject(key) ?: continue
                    val routeId = obj.optString("id").trim().ifBlank { key.trim() }
                    if (routeId.isBlank()) continue
                    val route = SubwayRouteInfo(
                        routeId = routeId,
                        shortName = obj.optString("short"),
                        longName = obj.optString("long"),
                        color = obj.optInt("color", FALLBACK_ROUTE_COLOR)
                    )
                    routeInfo[route.routeId] = route
                }
            }
        }

        val stationByKey = LinkedHashMap<String, SubwayStationOption>()
        val routeByStation = HashMap<String, MutableSet<String>>()
        val stationArray = root.optJSONArray("stations") ?: JSONArray()
        for (i in 0 until stationArray.length()) {
            val obj = stationArray.optJSONObject(i) ?: continue
            val key = obj.optString("key")
            val routeIds = obj.optJSONArray("routes") ?: JSONArray()
            val searchNames = buildList {
                val names = obj.optJSONArray("searchNames") ?: JSONArray()
                for (j in 0 until names.length()) {
                    names.optString(j).takeIf { it.isNotBlank() }?.let { add(it) }
                }
            }
            val routeList = buildList {
                for (j in 0 until routeIds.length()) {
                    val route = routeInfo[routeIds.optString(j)] ?: continue
                    add(route)
                    routeByStation.getOrPut(key) { LinkedHashSet() }.add(route.routeId)
                }
            }
            stationByKey[key] = SubwayStationOption(
                key = key,
                name = obj.optString("name"),
                latitude = obj.optDouble("lat"),
                longitude = obj.optDouble("lon"),
                routes = routeList.sortedBy { it.shortName },
                searchNames = searchNames
            )
        }

        val routePatterns = HashMap<String, List<List<String>>>()
        val patterns = root.optJSONObject("patterns") ?: JSONObject()
        val keys = patterns.keys()
        while (keys.hasNext()) {
            val routeId = keys.next()
            val routeArray = patterns.optJSONArray(routeId) ?: continue
            val list = ArrayList<List<String>>(routeArray.length())
            for (i in 0 until routeArray.length()) {
                val arr = routeArray.optJSONArray(i) ?: continue
                val pattern = ArrayList<String>(arr.length())
                for (j in 0 until arr.length()) pattern += arr.optString(j)
                if (pattern.size >= 2) list += pattern
            }
            routePatterns[routeId] = list
        }

        return StaticIndex(
            stationsByKey = stationByKey,
            routeByStation = routeByStation.mapValues { it.value.toSet() },
            routePatterns = routePatterns,
            routeInfo = routeInfo
        )
    }

    private fun downloadText(urlString: String): String {
        val connection = (URL(urlString).openConnection() as HttpURLConnection).apply {
            requestMethod = "GET"
            connectTimeout = 20_000
            readTimeout = 40_000
            instanceFollowRedirects = true
            setRequestProperty("User-Agent", "Tickets/6.0 SubwayData")
        }
        try {
            if (connection.responseCode !in 200..299) {
                throw IllegalStateException("HTTP ${connection.responseCode}: $urlString")
            }
            return connection.inputStream.bufferedReader(Charsets.UTF_8).use { it.readText() }
        } finally {
            connection.disconnect()
        }
    }

    private fun routeColor(
        cityId: String,
        shortName: String,
        routeCode: String,
        seed: Int,
        sourceColor: Int? = null
    ): Int {
        // 中国大陆 + 香港：颜色唯一以用户提供的 23 张线路颜色图对应 JSON 为主。
        // 找不到时只允许保留上游数据自己的 sourceColor；绝不再使用旧城市 preset / 随机 palette。
        SubwayLineColorRepository.colorFor(
            cityId = cityId,
            shortName = shortName,
            routeId = routeCode,
            cityNameZh = cityName(cityId)
        )?.let { return it }

        // 美国等其它城市继续允许官方颜色仓库提供已核验的线路色。
        OfficialSubwayLineColorRepository.colorFor(
            cityId = cityId,
            shortName = shortName,
            routeId = routeCode
        )?.let { return it }

        return sourceColor ?: FALLBACK_ROUTE_COLOR
    }


    private fun canonicalLineColor(
        cityId: String,
        shortName: String,
        routeId: String,
        sourceColor: Int
    ): Int = routeColor(
        cityId = cityId,
        shortName = shortName,
        routeCode = routeId,
        seed = 0,
        sourceColor = sourceColor
    )

    private fun applyCanonicalLineColors(
        cityId: String,
        index: StaticIndex
    ): StaticIndex {
        val normalizedRoutes = index.routeInfo.mapValues { (_, route) ->
            route.copy(
                color = canonicalLineColor(
                    cityId = cityId,
                    shortName = route.shortName,
                    routeId = route.routeId,
                    sourceColor = route.color
                )
            )
        }

        val normalizedStations = index.stationsByKey.mapValues { (_, station) ->
            station.copy(
                routes = station.routes.map { route ->
                    normalizedRoutes[route.routeId] ?: route
                }
            )
        }

        return index.copy(
            stationsByKey = normalizedStations,
            routeInfo = normalizedRoutes
        )
    }


    /**
     * 全城市通用的静态拓扑一致性清理。
     *
     * routePatterns 是路线搜索的唯一“真实边”来源：
     * - pattern 中不存在的车站，不允许挂在线路上；
     * - station.routeByStation 只能来自实际 pattern；
     * - 防止上游数据或人工校正留下“站点挂在线路上，但线路 pattern 根本没有经过该站”的假换乘。
     *
     * 不猜测新的线路/换乘，只删除无法被现有 pattern 证明的关系。
     */
    private fun normalizeStaticIndexTopology(
        index: StaticIndex
    ): StaticIndex {
        val knownRouteIds = index.routeInfo.keys
        val validPatterns = LinkedHashMap<String, List<List<String>>>()
        val patternRoutesByStation = LinkedHashMap<String, MutableSet<String>>()

        index.routePatterns.forEach { (routeId, patterns) ->
            if (routeId !in knownRouteIds) return@forEach

            val normalizedPatterns = patterns.mapNotNull { rawPattern ->
                val filtered = rawPattern
                    .filter { it in index.stationsByKey }
                    .fold(ArrayList<String>()) { acc, stationKey ->
                        if (acc.lastOrNull() != stationKey) {
                            acc += stationKey
                        }
                        acc
                    }
                filtered.takeIf { it.size >= 2 }
            }.distinct()

            if (normalizedPatterns.isNotEmpty()) {
                validPatterns[routeId] = normalizedPatterns
                normalizedPatterns.forEach { pattern ->
                    pattern.forEach { stationKey ->
                        patternRoutesByStation
                            .getOrPut(stationKey) { LinkedHashSet() }
                            .add(routeId)
                    }
                }
            }
        }

        val normalizedRouteByStation = patternRoutesByStation
            .mapValues { (_, routeIds) ->
                routeIds.toSet()
            }

        val normalizedStations = index.stationsByKey.mapValues { (stationKey, station) ->
            val actualRouteIds = normalizedRouteByStation[stationKey].orEmpty()
            station.copy(
                routes = actualRouteIds
                    .mapNotNull { index.routeInfo[it] }
                    .distinctBy { it.routeId }
                    .sortedBy { it.shortName }
            )
        }

        return index.copy(
            stationsByKey = normalizedStations,
            routeByStation = normalizedRouteByStation,
            routePatterns = validPatterns
        )
    }

    /**
     * 武汉当前运营拓扑的强制校正。
     *
     * 依据 2026-05-01 已开通的 12 号线一期：
     * 钢都花园 → 园林路 → 团结大道 → 汪家墩 → 秦园中路 →
     * 公正路 → 何家垅 → 十五中 → 武昌站东广场 → 瑞安街东 →
     * 富安街 → 楚祥大道 → 省农科院南 → 光霞 → 市农科院 →
     * 夹套河 → 国博中心南 → 国博新城 → 四新南路 → 四新中路 →
     * 芳草路 → 港口村 → 墨水湖公园。
     *
     * 高德数据若混入 12 号线全环规划段、把未来站点当成当前运营段，
     * 或把 12 号线错误挂到其它换乘站，则在进入统一路线搜索图之前剔除。
     *
     * 同时固定已核验的 12 号线换乘拓扑：
     * 园林路 4/12
     * 汪家墩 8/12
     * 光霞 5/12
     * 国博中心南 6/12/16
     * 武昌站东广场 11/12
     *
     * 宏图大道只允许 2/3/8，不允许 12。
     */
    /**
     * 武汉宏图大道线路身份/换乘拓扑强制校正。
     *
     * 已确认：宏图大道属于 2 / 3 / 8 号线，不属于 12 号线。
     * 12 号线当前首开段为钢都花园 → 墨水湖公园，共 23 站。
     *
     * 这层校正发生在路线搜索之前，因此不是“改显示文字”，而是直接修改搜索图。
     */
    private fun sanitizeWuhanRouteTopology(
        cityId: String,
        index: StaticIndex
    ): StaticIndex {
        if (cityId != "wuhan") return index

        val line12RouteIds = index.routeInfo.values
            .filter { normalizeLineName(it.shortName) == "12" }
            .map { it.routeId }
            .toSet()
        if (line12RouteIds.isEmpty()) return index

        val routeIdByShortName = index.routeInfo.values.associateBy(
            keySelector = { normalizeLineName(it.shortName) },
            valueTransform = { it.routeId }
        )

        val line2RouteId = routeIdByShortName["2"]
        val line3RouteId = routeIdByShortName["3"]
        val line8RouteId = routeIdByShortName["8"]

        fun normalizeWuhanStation(value: String): String =
            normalizeSearch(value)
                .removePrefix("武汉")
                .removeSuffix("地铁站")
                .removeSuffix("站")

        val currentLine12StationNames = setOf(
            "钢都花园",
            "园林路",
            "团结大道",
            "汪家墩",
            "秦园中路",
            "公正路",
            "何家垅",
            "十五中",
            "武昌站东广场",
            "瑞安街东",
            "富安街",
            "楚祥大道",
            "省农科院南",
            "光霞",
            "市农科院",
            "夹套河",
            "国博中心南",
            "国博新城",
            "四新南路",
            "四新中路",
            "芳草路",
            "港口村",
            "墨水湖公园"
        ).map(::normalizeWuhanStation).toSet()

        val currentLine12Keys = index.stationsByKey.values
            .filter { normalizeWuhanStation(it.name) in currentLine12StationNames }
            .map { it.key }
            .toSet()

        val hongtuKeys = index.stationsByKey.values
            .filter {
                normalizeWuhanStation(it.name) == normalizeWuhanStation("宏图大道")
            }
            .map { it.key }
            .toSet()

        // 宏图大道是 2 / 3 / 8 换乘站；绝不允许 12 参与。
        val normalizedStations = index.stationsByKey.mapValues { (stationKey, station) ->
            when {
                stationKey in hongtuKeys -> {
                    val expected = listOfNotNull(
                        line2RouteId?.let { index.routeInfo[it] },
                        line3RouteId?.let { index.routeInfo[it] },
                        line8RouteId?.let { index.routeInfo[it] }
                    )
                    station.copy(routes = expected.distinctBy { it.routeId })
                }

                station.routes.any { it.routeId in line12RouteIds } &&
                        normalizeWuhanStation(station.name) !in currentLine12StationNames -> {
                    station.copy(
                        routes = station.routes
                            .filterNot { it.routeId in line12RouteIds }
                            .sortedBy { it.shortName }
                    )
                }

                else -> station
            }
        }

        val normalizedRouteByStation = index.routeByStation.mapValues { (stationKey, routeIds) ->
            when {
                stationKey in hongtuKeys -> {
                    setOfNotNull(line2RouteId, line3RouteId, line8RouteId)
                }

                stationKey !in currentLine12Keys -> {
                    routeIds.filterNot { it in line12RouteIds }.toSet()
                }

                else -> routeIds
            }
        }

        val normalizedPatterns = LinkedHashMap<String, List<List<String>>>()
        index.routePatterns.forEach { (routeId, patterns) ->
            when {
                routeId in line12RouteIds -> {
                    val filtered = patterns.mapNotNull { pattern ->
                        val cleaned = pattern
                            .filter { it in currentLine12Keys }
                            .fold(ArrayList<String>()) { acc, key ->
                                if (acc.lastOrNull() != key) acc += key
                                acc
                            }
                        cleaned.takeIf { it.size >= 2 }
                    }.distinct()
                    if (filtered.isNotEmpty()) normalizedPatterns[routeId] = filtered
                }

                routeId == line2RouteId && hongtuKeys.isNotEmpty() -> {
                    // 高德少数版本可能没有把宏图大道写进 2 号线机场段 pattern；
                    // 如果已经存在则保持原顺序，否则按官方线路顺序在“常青花园”之后补入。
                    val canonicalHongtuKey = hongtuKeys.firstOrNull { key ->
                        index.routeByStation[key].orEmpty().any { id ->
                            id == line3RouteId || id == line8RouteId
                        }
                    } ?: hongtuKeys.first()

                    val rewritten = patterns.map { rawPattern ->
                        if (canonicalHongtuKey in rawPattern) {
                            rawPattern
                        } else {
                            val mutable = rawPattern.toMutableList()
                            val afterChangqing = mutable.indexOfFirst { key ->
                                normalizeWuhanStation(
                                    index.stationOption(key)?.name.orEmpty()
                                ) == normalizeWuhanStation("常青花园")
                            }
                            val beforeJulong = mutable.indexOfFirst { key ->
                                normalizeWuhanStation(
                                    index.stationOption(key)?.name.orEmpty()
                                ) == normalizeWuhanStation("巨龙大道")
                            }

                            when {
                                afterChangqing >= 0 -> {
                                    mutable.add(afterChangqing + 1, canonicalHongtuKey)
                                }
                                beforeJulong > 0 -> {
                                    mutable.add(beforeJulong, canonicalHongtuKey)
                                }
                                else -> mutable
                            }
                            mutable
                        }
                    }.distinct()
                    normalizedPatterns[routeId] = rewritten
                }

                else -> {
                    normalizedPatterns[routeId] = patterns
                }
            }
        }

        return normalizeStaticIndexTopology(
            index.copy(
                stationsByKey = normalizedStations,
                routeByStation = normalizedRouteByStation,
                routePatterns = normalizedPatterns
            )
        )
    }


    private fun extractNumericLine(value: String): String {
        val match = Regex("(\\d{1,2})").find(value)
        return match?.groupValues?.getOrNull(1).orEmpty()
    }

    private fun stableHash(value: String): Int = value.fold(7) { acc, c -> acc * 31 + c.code }.absoluteValue()

    private fun Int.absoluteValue(): Int = if (this == Int.MIN_VALUE) Int.MAX_VALUE else kotlin.math.abs(this)

    private fun normalizeLineName(value: String): String {
        val cleaned = value
            .replace("地铁", "", ignoreCase = true)
            .replace("号线", "", ignoreCase = true)
            .replace("线路", "", ignoreCase = true)
            .replace("Line", "", ignoreCase = true)
            .replace("LINE", "", ignoreCase = true)
            .trim()
        return if (cleaned.isBlank()) value.trim() else cleaned
    }

    private fun normalizeSearch(value: String): String = value
        .lowercase(Locale.ROOT)
        .replace("–", "-")
        .replace("—", "-")
        .replace("－", "-")
        .replace(Regex("[\\s\\p{Punct}·•]+"), "")

    private fun firstNonBlank(vararg values: String): String =
        values.firstOrNull { it.isNotBlank() }?.trim().orEmpty()

    private fun parseCoordinatePair(raw: String): Pair<Double, Double>? {
        val parts = raw.split(',')
        if (parts.size < 2) return null
        val a = parts[0].trim().toDoubleOrNull() ?: return null
        val b = parts[1].trim().toDoubleOrNull() ?: return null
        return if (a in -180.0..180.0 && b in -90.0..90.0) {
            Pair(b, a)
        } else if (a in -90.0..90.0 && b in -180.0..180.0) {
            Pair(a, b)
        } else {
            null
        }
    }
    private fun distanceMeters(
        lat1: Double,
        lon1: Double,
        lat2: Double,
        lon2: Double
    ): Double {
        val earth = 6_371_000.0
        val dLat = Math.toRadians(lat2 - lat1)
        val dLon = Math.toRadians(lon2 - lon1)
        val a =
            kotlin.math.sin(dLat / 2) *
                    kotlin.math.sin(dLat / 2) +
                    kotlin.math.cos(Math.toRadians(lat1)) *
                    kotlin.math.cos(Math.toRadians(lat2)) *
                    kotlin.math.sin(dLon / 2) *
                    kotlin.math.sin(dLon / 2)
        return earth * 2.0 *
                kotlin.math.atan2(
                    kotlin.math.sqrt(a),
                    kotlin.math.sqrt(
                        max(
                            0.0,
                            1.0 - a
                        )
                    )
                )
    }

}

/**
 * 全球智能地铁定位引擎。
 * 不调用实时列车接口。使用手机定位 + Location.speed / 相邻定位计算速度。
 */
object GlobalSubwayLocationEngine {

    private const val UPDATE_INTERVAL_MS = 1_000L
    private const val MIN_DISTANCE_M = 4f
    private const val STATION_REACHED_RADIUS_M = 65.0
    private const val MAX_ACCURACY_FOR_STATION_JUMP_M = 120.0
    private const val GOOGLE_NEARBY_REFRESH_MS = 15_000L
    private const val GOOGLE_NEARBY_RADIUS_M = 2_500.0
    private const val GOOGLE_ROUTE_CORRIDOR_M = 180.0

    fun hasLocationPermission(context: Context): Boolean {
        val fine = ContextCompat.checkSelfPermission(
            context,
            Manifest.permission.ACCESS_FINE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED
        val coarse = ContextCompat.checkSelfPermission(
            context,
            Manifest.permission.ACCESS_COARSE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED
        return fine || coarse
    }

    @android.annotation.SuppressLint("MissingPermission")
    internal suspend fun trackTrip(
        context: Context,
        initialTrip: SmartSubwayTrip,
        onUpdate: (SmartSubwayTrip) -> Unit
    ) {
        val city = GlobalSubwayDataManager.cityOrNull(initialTrip.cityId)
            ?: run {
                onUpdate(initialTrip)
                return
            }

        // 新建行程才需要第一次解析 origin -> destination。
        // 已经运行中的行程（包括“我已到达下一站”手动推进后的状态）必须原样传给
        // tracker，否则 prepareTrip 会把 currentStation 重新初始化成出发站。
        val needsInitialPreparation =
            initialTrip.nextStation == "正在加载路线…" ||
                    initialTrip.nextStation == "正在加载路线..."

        val prepared = if (needsInitialPreparation) {
            try {
                GlobalSubwayDataManager.prepareTrip(context, initialTrip)
            } catch (_: Throwable) {
                initialTrip
            }
        } else {
            initialTrip
        }

        onUpdate(prepared)

        if (!hasLocationPermission(context)) return

        if (city.sourceType == GlobalSubwayDataManager.SourceType.GOOGLE) {
            trackGoogleTrip(
                context = context,
                initialTrip = prepared,
                onUpdate = onUpdate
            )
        } else {
            trackStaticTrip(
                context = context,
                initialTrip = prepared,
                onUpdate = onUpdate
            )
        }
    }

    @android.annotation.SuppressLint("MissingPermission")
    private suspend fun trackStaticTrip(
        context: Context,
        initialTrip: SmartSubwayTrip,
        onUpdate: (SmartSubwayTrip) -> Unit
    ) {
        val locationManager = context.getSystemService(Context.LOCATION_SERVICE) as LocationManager
        val providers = buildList {
            if (locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
                add(LocationManager.GPS_PROVIDER)
            }
            if (locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)) {
                add(LocationManager.NETWORK_PROVIDER)
            }
        }.ifEmpty {
            listOf(LocationManager.GPS_PROVIDER)
        }

        var current = initialTrip
        var lastLocation: Location? = null
        var lastTimeMs = 0L

        val activePlan = try {
            GlobalSubwayDataManager.resolveRoutePlan(
                context,
                current.cityId,
                current.origin,
                current.destination
            )
        } catch (_: Throwable) {
            null
        } ?: return

        if (activePlan.stations.isEmpty()) return

        var currentIndex = activePlan.stations.indexOfFirst {
            it.name.equals(current.currentStation, ignoreCase = true)
        }.coerceAtLeast(0)

        val routeInfoById = buildMap {
            activePlan.routeInfos.forEach { route ->
                put(route.routeId, route)
            }
            put(activePlan.primaryRoute.routeId, activePlan.primaryRoute)
            activePlan.secondaryRoute?.let { put(it.routeId, it) }
        }

        val staticIndex = runCatching {
            GlobalSubwayDataManager.loadOrBuildIndex(
                context,
                current.cityId
            )
        }.getOrNull()

        var segmentProgress = current.segmentProgress.coerceIn(0f, 1f)
        var previousStation = if (currentIndex <= 0) {
            val currentKey = activePlan.stations
                .getOrNull(currentIndex)
                ?.stationKey
                .orEmpty()
            val nextKey = activePlan.stations
                .getOrNull(currentIndex + 1)
                ?.stationKey
            if (staticIndex != null && currentKey.isNotBlank()) {
                GlobalSubwayDataManager.previousPhysicalStationFromIndex(
                    index = staticIndex,
                    lineName = current.lineName.ifBlank { activePlan.primaryRoute.shortName },
                    currentKey = currentKey,
                    nextKey = nextKey
                )
            } else {
                current.previousStation
            }
        } else {
            current.previousStation
        }

        val listener = object : LocationListener {
            override fun onLocationChanged(location: Location) {
                val now = location.time.takeIf { it > 0 }
                    ?: System.currentTimeMillis()

                val derivedSpeed = lastLocation?.let { previous ->
                    val dt = max(
                        0.2,
                        (now - lastTimeMs).toDouble() / 1000.0
                    )
                    distanceMeters(
                        previous.latitude,
                        previous.longitude,
                        location.latitude,
                        location.longitude
                    ) / dt
                } ?: 0.0

                val sensorSpeed = if (
                    location.hasSpeed() &&
                    location.speed.isFinite() &&
                    location.speed >= 0f
                ) {
                    location.speed.toDouble()
                } else {
                    0.0
                }

                val speedMps = when {
                    sensorSpeed > 0.5 -> sensorSpeed
                    derivedSpeed > 0.5 -> derivedSpeed
                    else -> 0.0
                }

                val stationList = activePlan.stations
                val searchEnd = min(
                    stationList.lastIndex,
                    currentIndex + 4
                )

                var nearestIndex = currentIndex
                var nearestDistance = Double.MAX_VALUE

                for (index in currentIndex..searchEnd) {
                    val station = stationList[index]
                    val distance = distanceMeters(
                        location.latitude,
                        location.longitude,
                        station.latitude,
                        station.longitude
                    )
                    if (distance < nearestDistance) {
                        nearestDistance = distance
                        nearestIndex = index
                    }
                }

                val accuracy = if (location.hasAccuracy()) {
                    location.accuracy.toDouble()
                } else {
                    60.0
                }

                val reachedRadius = max(
                    STATION_REACHED_RADIUS_M,
                    min(
                        MAX_ACCURACY_FOR_STATION_JUMP_M,
                        accuracy * 1.4
                    )
                )

                if (
                    nearestIndex > currentIndex &&
                    nearestDistance <= reachedRadius
                ) {
                    currentIndex = nearestIndex
                    previousStation = if (currentIndex > 0) {
                        stationList[currentIndex - 1].name
                    } else {
                        ""
                    }
                    segmentProgress = 0f
                }

                val destinationReached =
                    currentIndex >= stationList.lastIndex ||
                            distanceMeters(
                                location.latitude,
                                location.longitude,
                                stationList.last().latitude,
                                stationList.last().longitude
                            ) <= reachedRadius

                if (destinationReached) {
                    currentIndex = stationList.lastIndex
                    segmentProgress = 1f
                } else if (currentIndex < stationList.lastIndex) {
                    val currentStation = stationList[currentIndex]
                    val nextStation = stationList[currentIndex + 1]
                    val geometric = projectToSegment(
                        location.latitude,
                        location.longitude,
                        currentStation.latitude,
                        currentStation.longitude,
                        nextStation.latitude,
                        nextStation.longitude
                    )

                    val speedBoost = when {
                        speedMps <= 0.5 -> 0f
                        speedMps >= 25.0 -> 0.02f
                        else -> (
                                speedMps / 25.0 * 0.02
                                ).toFloat()
                    }

                    segmentProgress = max(
                        segmentProgress,
                        (geometric + speedBoost).coerceIn(
                            0f,
                            1f
                        )
                    )
                }

                val next = if (destinationReached) {
                    stationList[currentIndex].name
                } else {
                    stationList.getOrNull(currentIndex + 1)?.name
                        ?: current.destination
                }

                val currentName = stationList[currentIndex].name
                val currentRouteId = stationList[currentIndex].routeId
                val currentRoute = routeInfoById[currentRouteId]
                    ?: activePlan.primaryRoute

                var nextTransferIndex = -1
                for (i in currentIndex until stationList.lastIndex) {
                    if (stationList[i].routeId != stationList[i + 1].routeId) {
                        nextTransferIndex = i
                        break
                    }
                }

                val nextRoute = if (nextTransferIndex >= 0) {
                    routeInfoById[stationList[nextTransferIndex + 1].routeId]
                } else {
                    null
                }

                val transferRequired =
                    !destinationReached &&
                            nextTransferIndex >= currentIndex &&
                            nextRoute != null

                val nextTransferStationName =
                    if (transferRequired) {
                        stationList[nextTransferIndex].name
                    } else {
                        ""
                    }

                if (currentIndex <= 0) {
                    val currentKey = stationList[currentIndex].stationKey
                    val nextKey = stationList
                        .getOrNull(currentIndex + 1)
                        ?.stationKey
                    if (staticIndex != null && currentKey.isNotBlank()) {
                        previousStation =
                            GlobalSubwayDataManager.previousPhysicalStationFromIndex(
                                index = staticIndex,
                                lineName = currentRoute.shortName.ifBlank { currentRouteId },
                                currentKey = currentKey,
                                nextKey = nextKey
                            )
                    }
                }

                val currentTransferOptions = staticIndex
                    ?.let { index ->
                        GlobalSubwayDataManager.currentStationTransferOptions(
                            index = index,
                            stationKey = stationList[currentIndex].stationKey,
                            activeRouteId = currentRouteId
                        )
                    }
                    ?: current.transferOptions

                val refreshed = current.copy(
                    cityName = GlobalSubwayDataManager.cityName(
                        current.cityId
                    ),
                    currentStation = currentName,
                    nextStation = next,
                    previousStation = previousStation,
                    segmentProgress = segmentProgress,
                    lineName = currentRoute.shortName.ifBlank { currentRouteId },
                    primaryLineColor = Color(currentRoute.color),
                    secondaryLineColor = Color(
                        nextRoute?.color ?: currentRoute.color
                    ),
                    transferStation = nextTransferStationName,
                    transferLineName = nextRoute?.shortName.orEmpty(),
                    transferOptions = currentTransferOptions,
                    isTransferRequired = transferRequired,
                    isDestination = destinationReached
                )

                current = refreshed
                onUpdate(refreshed)

                lastLocation = location
                lastTimeMs = now
            }
        }

        val requestedProviders = providers.toSet()
        try {
            withContext(Dispatchers.Main.immediate) {
                requestedProviders.forEach { provider ->
                    runCatching {
                        locationManager.requestLocationUpdates(
                            provider,
                            UPDATE_INTERVAL_MS,
                            MIN_DISTANCE_M,
                            listener,
                            Looper.getMainLooper()
                        )
                    }
                }
            }

            while (currentCoroutineContext().isActive) {
                delay(1_000L)
                if (current.isDestination) break
            }
        } finally {
            withContext(Dispatchers.Main.immediate) {
                runCatching {
                    locationManager.removeUpdates(listener)
                }
            }
        }
    }

    @android.annotation.SuppressLint("MissingPermission")
    private suspend fun trackGoogleTrip(
        context: Context,
        initialTrip: SmartSubwayTrip,
        onUpdate: (SmartSubwayTrip) -> Unit
    ) {
        val locationManager = context.getSystemService(Context.LOCATION_SERVICE) as LocationManager
        val providers = buildList {
            if (locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
                add(LocationManager.GPS_PROVIDER)
            }
            if (locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)) {
                add(LocationManager.NETWORK_PROVIDER)
            }
        }.ifEmpty {
            listOf(LocationManager.GPS_PROVIDER)
        }

        val plan = try {
            GlobalSubwayDataManager.resolveRoutePlan(
                context,
                initialTrip.cityId,
                initialTrip.origin,
                initialTrip.destination
            )
        } catch (_: Throwable) {
            null
        } ?: return

        val routePath = if (plan.routePath.size >= 2) {
            plan.routePath
        } else {
            listOf(
                GlobalSubwayDataManager.RoutePoint(
                    plan.stations.firstOrNull()?.latitude
                        ?: 0.0,
                    plan.stations.firstOrNull()?.longitude
                        ?: 0.0
                ),
                GlobalSubwayDataManager.RoutePoint(
                    plan.stations.lastOrNull()?.latitude
                        ?: 0.0,
                    plan.stations.lastOrNull()?.longitude
                        ?: 0.0
                )
            )
        }

        val routeLengthMeters = totalPathLength(routePath).coerceAtLeast(1.0)

        val planStops = plan.stations
        val stopPositions = LinkedHashMap<String, Double>()
        planStops.forEach { station ->
            stopPositions[station.stationKey] =
                projectDistanceOnPath(
                    station.latitude,
                    station.longitude,
                    routePath
                )
        }

        val knownStops = LinkedHashMap<String, GlobalSubwayDataManager.SubwayStationOption>()

        planStops.forEach { station ->
            knownStops[station.stationKey] =
                GlobalSubwayDataManager.SubwayStationOption(
                    key = station.stationKey,
                    name = station.name,
                    latitude = station.latitude,
                    longitude = station.longitude,
                    routes = listOf(
                        if (
                            station.routeId == plan.secondaryRoute?.routeId &&
                            plan.secondaryRoute != null
                        ) {
                            plan.secondaryRoute
                        } else {
                            plan.primaryRoute
                        }
                    )
                )
        }

        val nearbyLock = Any()
        var lastNearbyRefresh = 0L

        val nearbyRefreshScope = kotlinx.coroutines.CoroutineScope(
            kotlinx.coroutines.SupervisorJob() +
                    Dispatchers.IO
        )

        var current = initialTrip
        var currentPosition = stopPositions[
            planStops.firstOrNull()?.stationKey
        ] ?: 0.0
        val startsAtPlanOrigin =
            planStops.firstOrNull()?.name?.equals(
                current.currentStation,
                ignoreCase = true
            ) == true
        var previousStation = current.previousStation
        var lastLocation: Location? = null
        var lastTimeMs = 0L

        fun snapshotKnownStops(): List<GlobalSubwayDataManager.SubwayStationOption> =
            synchronized(nearbyLock) {
                knownStops.values.toList()
            }

        fun mergeNearby(
            stations: List<GlobalSubwayDataManager.SubwayStationOption>
        ) {
            synchronized(nearbyLock) {
                for (station in stations) {
                    val routeDistance = nearestDistanceToPath(
                        station.latitude,
                        station.longitude,
                        routePath
                    )
                    if (routeDistance <= GOOGLE_ROUTE_CORRIDOR_M) {
                        knownStops[station.key] = station
                        stopPositions[station.key] =
                            projectDistanceOnPath(
                                station.latitude,
                                station.longitude,
                                routePath
                            )
                    }
                }
            }
        }

        fun triggerNearbyRefresh(
            latitude: Double,
            longitude: Double,
            now: Long
        ) {
            if (now - lastNearbyRefresh < GOOGLE_NEARBY_REFRESH_MS) {
                return
            }

            lastNearbyRefresh = now

            nearbyRefreshScope.launch {
                val city = GlobalSubwayDataManager.cityOrNull(
                    current.cityId
                ) ?: return@launch

                val found = GlobalSubwayDataManager.searchNearbyGoogleStations(
                    context = context,
                    city = city,
                    latitude = latitude,
                    longitude = longitude,
                    radiusMeters = GOOGLE_NEARBY_RADIUS_M
                )

                if (found.isNotEmpty()) {
                    mergeNearby(found)
                }
            }
        }

        val listener = object : LocationListener {
            override fun onLocationChanged(location: Location) {
                val now = location.time.takeIf { it > 0 }
                    ?: System.currentTimeMillis()

                val previousLocation = lastLocation
                val derivedSpeed = previousLocation?.let { previous ->
                    val dt = max(
                        0.2,
                        (now - lastTimeMs).toDouble() / 1000.0
                    )
                    distanceMeters(
                        previous.latitude,
                        previous.longitude,
                        location.latitude,
                        location.longitude
                    ) / dt
                } ?: 0.0

                val sensorSpeed = if (
                    location.hasSpeed() &&
                    location.speed.isFinite() &&
                    location.speed >= 0f
                ) {
                    location.speed.toDouble()
                } else {
                    0.0
                }

                val speedMps = when {
                    sensorSpeed > 0.5 -> sensorSpeed
                    derivedSpeed > 0.5 -> derivedSpeed
                    else -> 0.0
                }

                triggerNearbyRefresh(
                    location.latitude,
                    location.longitude,
                    now
                )

                val currentPathPosition = projectDistanceOnPath(
                    location.latitude,
                    location.longitude,
                    routePath
                )

                val motionAdvance = when {
                    speedMps <= 0.5 -> 0.0
                    speedMps >= 30.0 -> 10.0
                    else -> speedMps * 0.35
                }

                currentPosition = max(
                    currentPosition,
                    min(
                        routeLengthMeters,
                        currentPathPosition + motionAdvance
                    )
                )

                val accuracy = if (location.hasAccuracy()) {
                    location.accuracy.toDouble()
                } else {
                    60.0
                }
                val reachedRadius = max(
                    STATION_REACHED_RADIUS_M,
                    min(
                        MAX_ACCURACY_FOR_STATION_JUMP_M,
                        accuracy * 1.4
                    )
                )

                val candidates = snapshotKnownStops()
                    .mapNotNull { station ->
                        val position = synchronized(nearbyLock) {
                            stopPositions[station.key]
                        } ?: return@mapNotNull null

                        if (position <= currentPosition + 15.0) {
                            null
                        } else {
                            val distance = distanceMeters(
                                location.latitude,
                                location.longitude,
                                station.latitude,
                                station.longitude
                            )
                            Triple(station, position, distance)
                        }
                    }
                    .sortedBy { it.second }

                val reachedNext = candidates.firstOrNull {
                    it.third <= reachedRadius
                }

                if (reachedNext != null) {
                    currentPosition = max(
                        currentPosition,
                        reachedNext.second
                    )
                    current = current.copy(
                        currentStation = reachedNext.first.name
                    )
                }

                val currentKnown = snapshotKnownStops()
                    .filter { station ->
                        val position = synchronized(nearbyLock) {
                            stopPositions[station.key]
                        } ?: return@filter false
                        position <= currentPosition + 10.0
                    }
                    .maxByOrNull {
                        synchronized(nearbyLock) {
                            stopPositions[it.key] ?: 0.0
                        }
                    }

                if (currentKnown != null) {
                    if (
                        current.currentStation == "等待定位" ||
                        currentKnown.name != current.currentStation &&
                        synchronized(nearbyLock) {
                            stopPositions[currentKnown.key] ?: 0.0
                        } > currentPosition - 20.0
                    ) {
                        current = current.copy(
                            currentStation = currentKnown.name
                        )
                    }
                }

                val nextKnown = snapshotKnownStops()
                    .mapNotNull { station ->
                        val position = synchronized(nearbyLock) {
                            stopPositions[station.key]
                        } ?: return@mapNotNull null
                        if (position <= currentPosition + 25.0) {
                            null
                        } else {
                            station to position
                        }
                    }
                    .minByOrNull { it.second }

                val destinationPoint = planStops.lastOrNull()
                    ?.let {
                        GlobalSubwayDataManager.RoutePoint(
                            it.latitude,
                            it.longitude
                        )
                    }

                val distanceToDestination = destinationPoint?.let {
                    distanceMeters(
                        location.latitude,
                        location.longitude,
                        it.latitude,
                        it.longitude
                    )
                } ?: Double.MAX_VALUE

                val destinationReached =
                    distanceToDestination <= reachedRadius ||
                            currentPosition >= routeLengthMeters * 0.985

                val displayNextStation = when {
                    destinationReached -> initialTrip.destination
                    nextKnown != null -> nextKnown.first.name
                    else -> planStops.getOrNull(1)?.name
                        ?: initialTrip.destination
                }

                val nextPosition = nextKnown?.second
                    ?: planStops
                        .mapNotNull { stop ->
                            stopPositions[stop.stationKey]
                                ?.let { pos ->
                                    if (pos > currentPosition + 25.0) {
                                        pos
                                    } else {
                                        null
                                    }
                                }
                        }
                        .minOrNull()
                    ?: routeLengthMeters

                val previousBoundary = currentKnown?.let {
                    synchronized(nearbyLock) {
                        stopPositions[it.key] ?: currentPosition
                    }
                } ?: currentPosition

                val segmentLength = max(
                    1.0,
                    nextPosition - previousBoundary
                )

                val segmentProgress = if (destinationReached) {
                    1f
                } else {
                    (
                            (currentPosition - previousBoundary) /
                                    segmentLength
                            )
                        .coerceIn(0.0, 1.0)
                        .toFloat()
                }

                val routeInfoById = buildMap {
                    plan.routeInfos.forEach { route ->
                        put(route.routeId, route)
                    }
                    put(plan.primaryRoute.routeId, plan.primaryRoute)
                    plan.secondaryRoute?.let { put(it.routeId, it) }
                }

                val currentPlanIndex = currentKnown
                    ?.let { known ->
                        planStops.indexOfFirst {
                            it.stationKey == known.key
                        }
                    }
                    ?.takeIf { it >= 0 }
                    ?: planStops.indexOfFirst {
                        it.name.equals(current.currentStation, ignoreCase = true)
                    }.coerceAtLeast(0)

                // 上一站严格跟随当前选中的线路 Pattern：
                // 线路起点或当前 Pattern 中不存在上一站时，保持空值，UI 显示“无”。
                previousStation = planStops
                    .getOrNull(currentPlanIndex - 1)
                    ?.name
                    .orEmpty()

                var nextTransferIndex = -1
                for (i in currentPlanIndex until planStops.lastIndex) {
                    if (planStops[i].routeId != planStops[i + 1].routeId) {
                        nextTransferIndex = i
                        break
                    }
                }

                val currentRouteId = planStops
                    .getOrNull(currentPlanIndex)
                    ?.routeId
                    .orEmpty()

                val currentRoute = routeInfoById[currentRouteId]
                    ?: plan.primaryRoute

                val nextRoute = if (nextTransferIndex >= 0) {
                    routeInfoById[
                        planStops[nextTransferIndex + 1].routeId
                    ]
                } else {
                    null
                }

                val transferRequired =
                    !destinationReached &&
                            nextTransferIndex >= currentPlanIndex &&
                            nextRoute != null

                val nextTransferStationName =
                    if (transferRequired) {
                        planStops[nextTransferIndex].name
                    } else {
                        ""
                    }

                // 不因“当前站 = 出发站”而强制清空上一站。
                // 出发站只在确实没有线路前序站时显示“无”；有真实前序站则保留。

                current = current.copy(
                    cityName = GlobalSubwayDataManager.cityName(
                        current.cityId
                    ),
                    currentStation = current.currentStation,
                    previousStation = previousStation,
                    nextStation = displayNextStation,
                    lineName = currentRoute.shortName.ifBlank { currentRouteId },
                    primaryLineColor = Color(currentRoute.color),
                    secondaryLineColor = Color(
                        nextRoute?.color ?: currentRoute.color
                    ),
                    transferStation = nextTransferStationName,
                    transferLineName = nextRoute?.shortName.orEmpty(),
                    segmentProgress = segmentProgress,
                    isTransferRequired = transferRequired,
                    isDestination = destinationReached
                )

                onUpdate(current)

                lastLocation = location
                lastTimeMs = now
            }
        }

        val requestedProviders = providers.toSet()
        try {
            withContext(Dispatchers.Main.immediate) {
                requestedProviders.forEach { provider ->
                    runCatching {
                        locationManager.requestLocationUpdates(
                            provider,
                            UPDATE_INTERVAL_MS,
                            MIN_DISTANCE_M,
                            listener,
                            Looper.getMainLooper()
                        )
                    }
                }
            }

            while (currentCoroutineContext().isActive) {
                delay(1_000L)
                if (current.isDestination) break
            }
        } finally {
            withContext(Dispatchers.Main.immediate) {
                runCatching {
                    locationManager.removeUpdates(listener)
                }
            }
            nearbyRefreshScope.cancel()
        }
    }

    private fun distanceMeters(
        lat1: Double,
        lon1: Double,
        lat2: Double,
        lon2: Double
    ): Double {
        val earth = 6_371_000.0
        val dLat = Math.toRadians(lat2 - lat1)
        val dLon = Math.toRadians(lon2 - lon1)

        val a =
            kotlin.math.sin(dLat / 2) *
                    kotlin.math.sin(dLat / 2) +
                    kotlin.math.cos(Math.toRadians(lat1)) *
                    kotlin.math.cos(Math.toRadians(lat2)) *
                    kotlin.math.sin(dLon / 2) *
                    kotlin.math.sin(dLon / 2)

        return earth * 2.0 *
                kotlin.math.atan2(
                    kotlin.math.sqrt(a),
                    kotlin.math.sqrt(
                        max(
                            0.0,
                            1.0 - a
                        )
                    )
                )
    }

    private fun totalPathLength(
        path: List<GlobalSubwayDataManager.RoutePoint>
    ): Double {
        if (path.size < 2) return 0.0
        var total = 0.0
        for (index in 1 until path.size) {
            total += distanceMeters(
                path[index - 1].latitude,
                path[index - 1].longitude,
                path[index].latitude,
                path[index].longitude
            )
        }
        return total
    }

    private fun projectDistanceOnPath(
        latitude: Double,
        longitude: Double,
        path: List<GlobalSubwayDataManager.RoutePoint>
    ): Double {
        if (path.isEmpty()) return 0.0
        if (path.size == 1) {
            return distanceMeters(
                latitude,
                longitude,
                path[0].latitude,
                path[0].longitude
            )
        }

        var accumulated = 0.0
        var bestDistance = Double.MAX_VALUE
        var bestAlong = 0.0

        for (index in 1 until path.size) {
            val start = path[index - 1]
            val end = path[index]
            val segmentLength = distanceMeters(
                start.latitude,
                start.longitude,
                end.latitude,
                end.longitude
            )
            if (segmentLength <= 0.5) continue

            val latitudeScale = 111_320.0
            val longitudeScale =
                111_320.0 * kotlin.math.cos(
                    Math.toRadians(start.latitude)
                )

            val px = (longitude - start.longitude) *
                    longitudeScale
            val py = (latitude - start.latitude) *
                    latitudeScale
            val ex = (end.longitude - start.longitude) *
                    longitudeScale
            val ey = (end.latitude - start.latitude) *
                    latitudeScale

            val denominator = ex * ex + ey * ey
            val t = if (denominator <= 0.001) {
                0.0
            } else {
                ((px * ex + py * ey) / denominator)
                    .coerceIn(0.0, 1.0)
            }

            val projectedLat =
                start.latitude +
                        (end.latitude - start.latitude) *
                        t
            val projectedLon =
                start.longitude +
                        (end.longitude - start.longitude) *
                        t

            val distance = distanceMeters(
                latitude,
                longitude,
                projectedLat,
                projectedLon
            )

            if (distance < bestDistance) {
                bestDistance = distance
                bestAlong = accumulated +
                        segmentLength * t
            }

            accumulated += segmentLength
        }

        return bestAlong
    }

    private fun nearestDistanceToPath(
        latitude: Double,
        longitude: Double,
        path: List<GlobalSubwayDataManager.RoutePoint>
    ): Double {
        val projected = projectDistanceOnPath(
            latitude,
            longitude,
            path
        )

        if (path.size < 2) {
            return path.firstOrNull()?.let {
                distanceMeters(
                    latitude,
                    longitude,
                    it.latitude,
                    it.longitude
                )
            } ?: Double.MAX_VALUE
        }

        var accumulated = 0.0
        var best = Double.MAX_VALUE

        for (index in 1 until path.size) {
            val start = path[index - 1]
            val end = path[index]
            val segmentLength = distanceMeters(
                start.latitude,
                start.longitude,
                end.latitude,
                end.longitude
            )
            if (segmentLength <= 0.5) continue

            val latitudeScale = 111_320.0
            val longitudeScale =
                111_320.0 * kotlin.math.cos(
                    Math.toRadians(start.latitude)
                )

            val px = (longitude - start.longitude) *
                    longitudeScale
            val py = (latitude - start.latitude) *
                    latitudeScale
            val ex = (end.longitude - start.longitude) *
                    longitudeScale
            val ey = (end.latitude - start.latitude) *
                    latitudeScale

            val denominator = ex * ex + ey * ey
            val t = if (denominator <= 0.001) {
                0.0
            } else {
                ((px * ex + py * ey) / denominator)
                    .coerceIn(0.0, 1.0)
            }

            val projectedLat =
                start.latitude +
                        (end.latitude - start.latitude) *
                        t
            val projectedLon =
                start.longitude +
                        (end.longitude - start.longitude) *
                        t

            best = min(
                best,
                distanceMeters(
                    latitude,
                    longitude,
                    projectedLat,
                    projectedLon
                )
            )

            accumulated += segmentLength
            if (accumulated > projected + 2_500.0) {
                // 仅用于避免极端长路线的无意义继续计算；
                // 仍然返回已经找到的最小距离。
            }
        }

        return best
    }

    private fun projectToSegment(
        pointLat: Double,
        pointLon: Double,
        startLat: Double,
        startLon: Double,
        endLat: Double,
        endLon: Double
    ): Float {
        val latitudeScale = 111_320.0
        val longitudeScale =
            111_320.0 * kotlin.math.cos(
                Math.toRadians(startLat)
            )

        val px = (pointLon - startLon) * longitudeScale
        val py = (pointLat - startLat) * latitudeScale
        val ex = (endLon - startLon) * longitudeScale
        val ey = (endLat - startLat) * latitudeScale
        val denominator = ex * ex + ey * ey

        if (denominator <= 0.001) return 0f

        return (
                (px * ex + py * ey) /
                        denominator
                )
            .coerceIn(0.0, 1.0)
            .toFloat()
    }
}

@Composable
fun GlobalSubwayStationField(
    cityId: String,
    title: String,
    value: String,
    placeholder: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    var focused by remember { mutableStateOf(false) }
    var loading by remember { mutableStateOf(false) }
    var results by remember {
        mutableStateOf<List<GlobalSubwayDataManager.SubwayStationOption>>(emptyList())
    }

    LaunchedEffect(cityId, value, focused) {
        if (!focused) return@LaunchedEffect
        loading = true
        results = try {
            GlobalSubwayDataManager.searchStations(
                context = context,
                cityId = cityId,
                query = value,
                limit = 8
            )
        } catch (_: Throwable) {
            emptyList()
        }
        loading = false
    }

    Column(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .background(Color(0xFF242426))
            .border(
                width = 1.dp,
                color = if (focused) Color.White.copy(alpha = 0.14f) else Color.Transparent,
                shape = RoundedCornerShape(16.dp)
            )
            .padding(horizontal = 12.dp, vertical = 9.dp)
    ) {
        androidx.compose.material3.Text(
            text = title,
            color = Color(0xFF8E8E93),
            fontSize = 10.sp
        )
        Spacer(Modifier.height(3.dp))

        BasicTextField(
            value = value,
            onValueChange = onValueChange,
            singleLine = true,
            textStyle = TextStyle(color = Color.White, fontSize = 15.sp),
            cursorBrush = SolidColor(Color.White),
            modifier = Modifier
                .fillMaxWidth()
                .onFocusChanged { focused = it.isFocused },
            decorationBox = { innerTextField ->
                Box(modifier = Modifier.fillMaxWidth()) {
                    if (value.isBlank()) {
                        androidx.compose.material3.Text(
                            text = placeholder,
                            color = Color(0xFF66676C),
                            fontSize = 15.sp
                        )
                    }
                    innerTextField()
                }
            }
        )

        if (focused) {
            Spacer(Modifier.height(8.dp))
            when {
                loading -> androidx.compose.material3.Text(
                    text = "正在搜索…",
                    color = Color(0xFF77787D),
                    fontSize = 12.sp
                )

                results.isEmpty() -> androidx.compose.material3.Text(
                    text = if (value.isBlank()) "输入站点名称开始搜索" else "没有找到匹配站点",
                    color = Color(0xFF77787D),
                    fontSize = 12.sp
                )

                else -> LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    items(results) { station ->
                        GlobalSubwayStationResultChip(
                            cityId = cityId,
                            station = station,
                            onClick = {
                                onValueChange(station.name)
                                focused = false
                            }
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun GlobalSubwayStationResultChip(
    cityId: String,
    station: GlobalSubwayDataManager.SubwayStationOption,
    onClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .width(180.dp)
            .clip(RoundedCornerShape(14.dp))
            .background(Color.White.copy(alpha = 0.05f))
            .clickable(onClick = onClick)
            .padding(horizontal = 10.dp, vertical = 8.dp)
    ) {
        androidx.compose.material3.Text(
            text = station.name,
            color = Color.White,
            fontSize = 13.sp,
            fontWeight = FontWeight.Medium,
            maxLines = 2
        )
        Spacer(Modifier.height(5.dp))
        Row(
            horizontalArrangement = Arrangement.spacedBy(4.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            station.routes.take(8).forEach { route ->
                Box(
                    modifier = Modifier
                        .size(22.dp)
                        .clip(RoundedCornerShape(7.dp))
                        .background(Color(route.color)),
                    contentAlignment = Alignment.Center
                ) {
                    androidx.compose.material3.Text(
                        text = GlobalSubwayDataManager.displayLineBadgeName(
                            cityId = cityId,
                            shortName = route.shortName,
                            routeId = route.routeId
                        ),
                        color = routeBadgeTextColor(route.color),
                        fontSize = if (route.shortName.length <= 1) 10.sp else 7.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    }
}

private fun routeBadgeTextColor(color: Int): Color {
    val r = (color shr 16) and 0xFF
    val g = (color shr 8) and 0xFF
    val b = color and 0xFF
    val luminance = (0.299 * r + 0.587 * g + 0.114 * b) / 255.0
    return if (luminance > 0.62) Color.Black else Color.White
}