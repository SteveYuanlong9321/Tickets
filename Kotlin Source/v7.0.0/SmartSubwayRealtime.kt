package com.example.tickets

import android.graphics.Bitmap
import android.graphics.Canvas as AndroidCanvas
import android.graphics.Paint
import android.graphics.RectF
import android.graphics.Typeface
import android.graphics.Color as AndroidColor
import android.view.View
import android.widget.RemoteViews
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.material3.Text
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.app.NotificationCompat
import kotlin.math.max

/**
 * 智能地铁实时状态的统一数据模型。
 *
 * 同一份状态供：
 * - App 内实时行程卡
 * - 行程详情页
 * - Live Update
 * - 小米超级岛
 * - 三星 Now Bar
 * - 小米超级岛
 * 使用。
 */
data class SmartSubwayRealtimeState(
    val routeId: String = "smart_subway",
    val cityId: String = "",
    val cityName: String = "",
    val origin: String,
    val currentStation: String,
    val nextStation: String,
    val destination: String,
    val lineName: String,
    val primaryLineColor: Int,
    val secondaryLineColor: Int = primaryLineColor,
    val isTransferRequired: Boolean = false,
    val isDestination: Boolean = false,
    val transferStation: String = "",
    // 系统实时进度条所需的上一站与当前区间进度。
    // 0f = 刚到当前站，1f = 即将到达下一站。
    val previousStation: String = "",
    val segmentProgress: Float = 0f,
    // 换乘专用文本；未提供时仅显示“准备换乘”。
    val transferLineName: String = "",
    val transferOptions: List<String> = emptyList(),
    val etaText: String = "",
    val statusText: String = "行程进行中",
    val nextActionText: String = "正在前往下一站"
)


/**
 * Smart Subway 三站横向卡片的统一语义模型。
 * Samsung Now Bar、Android Live Update、Xiaomi Super Island 和 App 内智能地铁卡片共同消费。
 */
data class SmartSubwayHorizontalCardContent(
    val lineSummary: String,
    val statusText: String,
    val previousStation: String,
    val currentStation: String,
    val nextStation: String
)

internal fun buildSmartSubwayHorizontalCardContent(
    state: SmartSubwayRealtimeState
): SmartSubwayHorizontalCardContent {
    val current = state.currentStation.ifBlank { "等待定位" }
    val previous = state.previousStation
        .takeIf { it.isNotBlank() && !it.equals(current, ignoreCase = true) }
        ?: "上一站"
    val next = state.nextStation.ifBlank { "等待定位" }

    val line = state.lineName.ifBlank { "地铁" }
    val destination = state.destination.ifBlank { "" }
    val lineSummary = if (destination.isBlank()) line else "$line  ·  → $destination"

    val atRequiredTransfer =
        state.isTransferRequired &&
                state.transferStation.isNotBlank() &&
                normalizeSmartSubwayStationName(current) ==
                normalizeSmartSubwayStationName(state.transferStation)

    val status = when {
        state.isDestination -> "带齐物品准备下车"
        atRequiredTransfer && state.transferLineName.isNotBlank() -> "准备换乘${state.transferLineName}"
        atRequiredTransfer -> "准备换乘"
        state.transferOptions.isNotEmpty() -> "可换乘${state.transferOptions.joinToString("、")}"
        else -> ""
    }

    return SmartSubwayHorizontalCardContent(
        lineSummary = lineSummary,
        statusText = status,
        previousStation = previous,
        currentStation = current,
        nextStation = next
    )
}

private fun normalizeSmartSubwayStationName(value: String): String =
    value.trim().replace(Regex("\\s+"), "")

private fun unifiedSmartSubwayStatusText(state: SmartSubwayRealtimeState): String =
    buildSmartSubwayHorizontalCardContent(state).statusText

internal fun isUsSmartSubwayCity(cityId: String): Boolean = when (cityId) {
    "nyc", "washington_dc", "boston", "philadelphia",
    "chicago", "san_francisco_bay", "los_angeles" -> true
    else -> false
}

internal fun formatSmartSubwayUsStationName(value: String): String {
    val normalized = value.trim().replace(Regex("\\s+"), " ")
    if (normalized.isBlank() || normalized.contains('\n')) return normalized
    if (normalized.length <= 13) return normalized

    val hyphen = normalized.indexOf('-')
    if (hyphen in 4 until normalized.lastIndex) {
        return normalized.substring(0, hyphen + 1) + "\n" + normalized.substring(hyphen + 1).trimStart()
    }

    val middle = normalized.length / 2
    val split = normalized.indices
        .filter { normalized[it] == ' ' && it > 3 && it < normalized.lastIndex - 2 }
        .minByOrNull { kotlin.math.abs(it - middle) }

    return if (split != null) {
        normalized.substring(0, split).trimEnd() + "\n" + normalized.substring(split + 1).trimStart()
    } else {
        normalized
    }
}

internal fun smartSubwayUsStationTextSizeSp(
    value: String,
    active: Boolean,
    compact: Boolean = false
): Float {
    val length = value.trim().replace(Regex("\\s+"), " ").length
    val base = if (active) { if (compact) 16f else 21f } else { if (compact) 13f else 17f }
    return when {
        length >= 24 -> (base - 4f).coerceAtLeast(if (active) 13f else 11f)
        length >= 18 -> (base - 3f).coerceAtLeast(if (active) 14f else 12f)
        length >= 14 -> (base - 2f).coerceAtLeast(if (active) 14f else 12f)
        else -> base
    }
}

internal fun SmartSubwayRealtimeState.isAfterTransfer(): Boolean {
    val currentLine = lineName.trim()
        .removeSuffix("号线")
        .replace("Line", "", ignoreCase = true)
        .trim()
    val transferLine = transferLineName.trim()
        .removeSuffix("号线")
        .replace("Line", "", ignoreCase = true)
        .trim()
    return transferLine.isNotBlank() &&
            currentLine.equals(transferLine, ignoreCase = true) &&
            normalizeSmartSubwayStationName(currentStation) != normalizeSmartSubwayStationName(transferStation)
}

@Composable
fun SmartSubwayHorizontalCard(
    state: SmartSubwayRealtimeState,
    modifier: Modifier = Modifier,
    compact: Boolean = false,
    onClick: (() -> Unit)? = null
) {
    val content = buildSmartSubwayHorizontalCardContent(state)
    val activeColor = if (state.isAfterTransfer()) Color(state.secondaryLineColor) else Color(state.primaryLineColor)

    Column(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(if (compact) 20.dp else 24.dp))
            .background(
                androidx.compose.ui.graphics.Brush.verticalGradient(
                    listOf(Color.White.copy(alpha = 0.095f), Color.White.copy(alpha = 0.042f))
                )
            )
            .let { base -> if (onClick != null) base.clickable(onClick = onClick) else base }
            .padding(horizontal = if (compact) 14.dp else 18.dp, vertical = if (compact) 12.dp else 16.dp)
    ) {
        Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
            SmartSubwayServiceBadge(
                lineName = state.lineName.ifBlank { "地铁" },
                lineColor = activeColor,
                compact = compact
            )
            Spacer(Modifier.width(if (compact) 10.dp else 12.dp))
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = "当前站  ${content.currentStation}",
                    color = Color.White,
                    fontSize = if (compact) 19.sp else 18.sp,
                    fontWeight = FontWeight.Bold,
                    maxLines = 1
                )
                Spacer(Modifier.height(if (compact) 2.dp else 3.dp))
                Text(
                    text = content.lineSummary,
                    color = activeColor,
                    fontSize = if (compact) 13.sp else 13.sp,
                    fontWeight = FontWeight.SemiBold,
                    maxLines = 1
                )
                if (content.statusText.isNotBlank()) {
                    Spacer(Modifier.height(2.dp))
                    Text(
                        text = content.statusText,
                        color = activeColor,
                        fontSize = if (compact) 12.sp else 12.sp,
                        fontWeight = FontWeight.Bold,
                        maxLines = 1
                    )
                }
            }
        }
        Spacer(Modifier.height(if (compact) 7.dp else 10.dp))
        SmartSubwayRouteCanvas(state = state, modifier = Modifier.fillMaxWidth(), compact = compact)
    }
}

@Composable
private fun SmartSubwayServiceBadge(lineName: String, lineColor: Color, compact: Boolean) {
    Box(
        modifier = Modifier
            .size(if (compact) 42.dp else 52.dp)
            .clip(RoundedCornerShape(if (compact) 13.dp else 15.dp))
            .background(Color.White)
            .padding(if (compact) 4.dp else 5.dp),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .clip(RoundedCornerShape(if (compact) 10.dp else 11.dp))
                .background(lineColor),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = lineName,
                color = Color.White,
                fontSize = if (compact) 15.sp else 15.sp,
                fontWeight = FontWeight.Bold,
                maxLines = 1,
                textAlign = TextAlign.Center
            )
        }
    }
}

data class SmartSubwayTimelineStop(
    val stationName: String,
    val caption: String,
    val lineName: String,
    val lineColor: Int,
    val active: Boolean = false,
    val transferFromLine: String = "",
    val transferToLine: String = ""
)

@Composable
fun SmartSubwayGoogleRouteTimeline(stops: List<SmartSubwayTimelineStop>, modifier: Modifier = Modifier) {
    if (stops.isEmpty()) return
    Column(modifier = modifier.fillMaxWidth()) {
        stops.forEachIndexed { index, stop ->
            if (index > 0 && stop.transferToLine.isNotBlank()) {
                Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
                    Spacer(Modifier.width(8.dp))
                    Box(
                        modifier = Modifier.width(6.dp).height(30.dp).clip(RoundedCornerShape(3.dp)).background(Color(stop.lineColor))
                    )
                    Spacer(Modifier.width(14.dp))
                    Box(
                        modifier = Modifier.clip(RoundedCornerShape(11.dp)).background(Color.White.copy(alpha = 0.075f)).padding(horizontal = 10.dp, vertical = 6.dp)
                    ) {
                        Text(
                            text = "换乘 ${stop.transferToLine}",
                            color = Color.White,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                    }
                }
            }
            Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
                Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.width(20.dp)) {
                    Box(
                        modifier = Modifier
                            .size(if (stop.active) 18.dp else 12.dp)
                            .clip(CircleShape)
                            .background(if (stop.active) Color.White else Color(stop.lineColor))
                            .border(if (stop.active) 3.dp else 0.dp, if (stop.active) Color(stop.lineColor) else Color.Transparent, CircleShape)
                    )
                    if (index < stops.lastIndex) {
                        Spacer(Modifier.height(4.dp))
                        Box(
                            modifier = Modifier.width(4.dp).height(34.dp).clip(RoundedCornerShape(2.dp)).background(Color(stop.lineColor).copy(alpha = 0.75f))
                        )
                    }
                }
                Spacer(Modifier.width(14.dp))
                Column(Modifier.weight(1f)) {
                    Text(
                        text = stop.stationName,
                        color = if (stop.active) Color.White else Color(0xFFD0D1D5),
                        fontSize = if (stop.active) 17.sp else 14.sp,
                        fontWeight = if (stop.active) FontWeight.Bold else FontWeight.Normal,
                        maxLines = 1
                    )
                    Spacer(Modifier.height(2.dp))
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(
                            text = stop.caption,
                            color = if (stop.active) Color(stop.lineColor) else Color(0xFF777A80),
                            fontSize = 11.sp,
                            fontWeight = if (stop.active) FontWeight.SemiBold else FontWeight.Normal
                        )
                        if (stop.lineName.isNotBlank()) {
                            Spacer(Modifier.width(7.dp))
                            Box(
                                modifier = Modifier.clip(RoundedCornerShape(6.dp)).background(Color(stop.lineColor).copy(alpha = 0.18f)).padding(horizontal = 6.dp, vertical = 2.dp)
                            ) {
                                Text(text = stop.lineName, color = Color(stop.lineColor), fontSize = 10.sp, fontWeight = FontWeight.Bold)
                            }
                        }
                    }
                }
            }
            if (index < stops.lastIndex) Spacer(Modifier.height(4.dp))
        }
    }
}

/**
 * Android 16 / AndroidX 1.17+ 分段式智能地铁进度条。
 *
 * 三个点严格表示：上一站 -> 当前站 -> 下一站。
 * 前一段固定为已完成；后一段为当前运行区间，segmentProgress 决定
 * tracker 在“当前站 -> 下一站”之间的位置。
 */
internal fun buildSmartSubwayProgressStyle(
    context: android.content.Context,
    state: SmartSubwayRealtimeState
): NotificationCompat.ProgressStyle {
    val previous = state.previousStation
        .takeIf { it.isNotBlank() && !it.equals(state.currentStation, ignoreCase = true) }
        ?: state.origin.ifBlank { "上一站" }
    val current = state.currentStation.ifBlank { "当前站" }
    val next = state.nextStation.ifBlank { "下一站" }

    val firstSegment =
        NotificationCompat.ProgressStyle.Segment(100)
            .setColor(state.primaryLineColor)
            .setId(1)

    val activeLineColor =
        if (state.isAfterTransfer()) state.secondaryLineColor
        else state.primaryLineColor

    val secondSegment =
        NotificationCompat.ProgressStyle.Segment(100)
            .setColor(activeLineColor)
            .setId(2)

    val points = listOf(
        NotificationCompat.ProgressStyle.Point(1)
            .setId(1)
            .setColor(AndroidColor.rgb(142, 145, 151)),
        NotificationCompat.ProgressStyle.Point(100)
            .setId(2)
            .setColor(state.primaryLineColor),
        NotificationCompat.ProgressStyle.Point(200)
            .setId(3)
            .setColor(activeLineColor)
    )

    val progress = if (state.isDestination) {
        200
    } else {
        100 +
                kotlin.math.round(
                    state.segmentProgress.coerceIn(0f, 1f) * 100f
                ).toInt()
    }

    return NotificationCompat.ProgressStyle()
        .setStyledByProgress(true)
        .setProgress(progress.coerceIn(0, 200))
        .setProgressSegments(listOf(firstSegment, secondSegment))
        .setProgressPoints(points)
}

/**
 * 智能地铁通知正文：ProgressStyle 本身只负责进度条和节点，
 * 站名标签通过通知正文提供，保证上一站 / 当前站 / 下一站始终可读。
 */
internal fun buildSmartSubwayProgressText(
    state: SmartSubwayRealtimeState
): String {
    val previous = state.previousStation
        .takeIf { it.isNotBlank() && !it.equals(state.currentStation, ignoreCase = true) }
        ?: state.origin.ifBlank { "上一站" }
    val current = state.currentStation.ifBlank { "当前站" }
    val next = state.nextStation.ifBlank { "下一站" }

    val action = unifiedSmartSubwayStatusText(state).ifBlank { "正在前往下一站" }

    return listOf(
        "上一站：$previous",
        "当前站：$current",
        "下一站：$next",
        action
    ).joinToString("\n")
}

object SmartSubwayNotificationSpec {
    const val NOTIFICATION_ID = 88001
    const val CHANNEL_ID = "smart_subway_realtime"
    const val CHANNEL_NAME = "智能地铁 · 实时行程"

    val background = AndroidColor.rgb(31, 34, 38)
    val foreground = AndroidColor.WHITE
    val secondaryText = AndroidColor.rgb(176, 178, 184)
    val statusGreen = AndroidColor.rgb(27, 228, 188)
}

/**
 * 根据 App 的智能地铁当前行程生成统一状态对象。
 */
internal fun SmartSubwayTrip.toRealtimeState(): SmartSubwayRealtimeState {
    return SmartSubwayRealtimeState(
        cityId = cityId,
        cityName = cityName,
        origin = origin,
        currentStation = currentStation,
        nextStation = nextStation,
        destination = destination,
        lineName = lineName,
        primaryLineColor = primaryLineColor.toArgb(),
        secondaryLineColor = secondaryLineColor.toArgb(),
        isTransferRequired = isTransferRequired,
        isDestination = isDestination,
        transferStation = transferStation,
        // 使用实时行程已经计算出的真实上一站 / 区间进度 / 换乘线路信息。
        // 这里如果清空这些字段，Samsung NowBar 就只能退回到出发站。
        previousStation = previousStation,
        segmentProgress = segmentProgress,
        transferLineName = transferLineName,
        transferOptions = transferOptions,
        etaText = if (isDestination) "已到达" else "",
        statusText = when {
            isDestination -> "已到达目的地"
            isTransferRequired -> "准备换乘"
            else -> "行程进行中"
        },
        nextActionText = when {
            isDestination -> "带齐物品准备下车"
            isTransferRequired && transferLineName.isNotBlank() ->
                "准备换乘$transferLineName"
            isTransferRequired -> "准备换乘"
            else -> "正在前往下一站"
        }
    )
}

@Composable
fun SmartSubwayRouteCanvas(
    state: SmartSubwayRealtimeState,
    modifier: Modifier = Modifier,
    compact: Boolean = false
) {
    val content = buildSmartSubwayHorizontalCardContent(state)
    val isUsCity = isUsSmartSubwayCity(state.cityId)
    val labelTop = if (compact) 48.dp else 58.dp
    val height = if (isUsCity) {
        if (compact) 100.dp else 116.dp
    } else {
        if (compact) 84.dp else 102.dp
    }

    Box(modifier = modifier.height(height)) {
        Canvas(
            modifier = Modifier
                .fillMaxWidth()
                .height(if (compact) 38.dp else 46.dp)
                .align(Alignment.TopCenter)
        ) {
            drawSmartSubwayHorizontalRoute(
                state = state,
                y = size.height * 0.55f,
                compact = compact
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = labelTop),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Top
        ) {
            SmartSubwayThreeStationLabel(content.previousStation, "上一站", false, compact, isUsCity)
            SmartSubwayThreeStationLabel(content.currentStation, "当前站", true, compact, isUsCity)
            SmartSubwayThreeStationLabel(content.nextStation, "下一站", false, compact, isUsCity)
        }
    }
}

@Composable
private fun SmartSubwayThreeStationLabel(
    title: String,
    caption: String,
    active: Boolean,
    compact: Boolean,
    usLongNameLayout: Boolean
) {
    if (!usLongNameLayout) {
        Column(
            Modifier.fillMaxWidth(0.24f),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                Modifier.height(if (compact) 24.dp else 30.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = title,
                    color = if (active) Color.White else Color(0xFFB0B2B8),
                    fontSize = if (active) { if (compact) 16.sp else 21.sp } else { if (compact) 13.sp else 17.sp },
                    fontWeight = if (active) FontWeight.Bold else FontWeight.Medium,
                    maxLines = 1,
                    textAlign = TextAlign.Center
                )
            }
            Text(
                text = caption,
                color = if (active) Color.White else Color(0xFF777A80),
                fontSize = if (compact) 9.sp else 10.sp,
                fontWeight = if (active) FontWeight.SemiBold else FontWeight.Normal,
                maxLines = 1,
                textAlign = TextAlign.Center
            )
        }
        return
    }

    val displayTitle = formatSmartSubwayUsStationName(title)
    val stationTextSize = smartSubwayUsStationTextSizeSp(title, active, compact)

    Column(
        modifier = Modifier.fillMaxWidth(0.24f),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier.height(if (compact) 38.dp else 44.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = displayTitle,
                color = if (active) Color.White else Color(0xFFB0B2B8),
                fontSize = stationTextSize.sp,
                lineHeight = (stationTextSize * 1.05f).sp,
                fontWeight = if (active) FontWeight.Bold else FontWeight.Medium,
                maxLines = 2,
                softWrap = true,
                overflow = TextOverflow.Clip,
                textAlign = TextAlign.Center
            )
        }
        Text(
            text = caption,
            color = if (active) Color.White else Color(0xFF777A80),
            fontSize = if (compact) 9.sp else 10.sp,
            fontWeight = if (active) FontWeight.SemiBold else FontWeight.Normal,
            maxLines = 1,
            textAlign = TextAlign.Center
        )
    }
}

private fun DrawScope.drawSmartSubwayHorizontalRoute(
    state: SmartSubwayRealtimeState,
    y: Float,
    compact: Boolean
) {
    // 与 Samsung Now Bar 中部线路完全一致的三节点比例：12% / 50% / 88%。
    val positions = listOf(0.12f, 0.50f, 0.88f).map { it * size.width }

    // Samsung RemoteViews 的 110px 线路图缩放到约 46dp 后，
    // 线宽 / 节点大小约等价于以下 Compose 尺寸。
    val strokeWidth = if (compact) 8.dp.toPx() else 9.dp.toPx()
    val normalRadius = if (compact) 4.dp.toPx() else 4.5.dp.toPx()
    val activeOuterRadius = if (compact) 8.dp.toPx() else 9.dp.toPx()
    val activeInnerRadius = normalRadius

    val activeLineColor =
        if (state.isAfterTransfer()) Color(state.secondaryLineColor)
        else Color(state.primaryLineColor)
    val nextNodeColor =
        if (state.isTransferRequired) Color(state.secondaryLineColor)
        else Color(state.primaryLineColor)
    val backgroundColor = Color(0xFF43464C)

    // Samsung Now Bar：第一段线路色，第二段深灰底线。
    drawLine(
        color = activeLineColor,
        start = Offset(positions[0] + normalRadius, y),
        end = Offset(positions[1] - activeOuterRadius, y),
        strokeWidth = strokeWidth,
        cap = StrokeCap.Round
    )
    drawLine(
        color = backgroundColor,
        start = Offset(positions[1] + activeOuterRadius, y),
        end = Offset(positions[2] - normalRadius, y),
        strokeWidth = strokeWidth,
        cap = StrokeCap.Round
    )

    val progress =
        if (state.isDestination) 1f
        else state.segmentProgress.coerceIn(0f, 1f)

    val progressStart = positions[1] + activeOuterRadius
    val progressEnd = positions[2] - normalRadius
    val currentProgressEnd =
        progressStart + (progressEnd - progressStart) * progress

    if (progress > 0f && currentProgressEnd > progressStart) {
        drawLine(
            color = activeLineColor,
            start = Offset(progressStart, y),
            end = Offset(currentProgressEnd, y),
            strokeWidth = strokeWidth,
            cap = StrokeCap.Round
        )
    }

    // 上一站 / 下一站：深色外圈 + 内点。
    drawCircle(
        color = Color(0xFF1B1D20),
        radius = normalRadius + 2.dp.toPx(),
        center = Offset(positions[0], y)
    )
    drawCircle(
        color = Color(0xFF9A9DA4),
        radius = normalRadius,
        center = Offset(positions[0], y)
    )
    drawCircle(
        color = Color(0xFF1B1D20),
        radius = normalRadius + 2.dp.toPx(),
        center = Offset(positions[2], y)
    )
    drawCircle(
        color = nextNodeColor,
        radius = normalRadius,
        center = Offset(positions[2], y)
    )

    // 当前站：白色大圆 + 当前线路色内点。
    drawCircle(
        color = Color.White,
        radius = activeOuterRadius,
        center = Offset(positions[1], y)
    )
    drawCircle(
        color = activeLineColor,
        radius = activeInnerRadius,
        center = Offset(positions[1], y)
    )
}


@Composable
fun SmartSubwayRouteTimeline(
    state: SmartSubwayRealtimeState,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        SmartSubwayVerticalNode(
            title = state.origin,
            caption = "出发站",
            active = false,
            lineColor = Color(state.primaryLineColor)
        )
        if (state.isTransferRequired && state.transferStation.isNotBlank()) {
            SmartSubwayVerticalConnector(Color(state.primaryLineColor))
            SmartSubwayVerticalNode(
                title = state.transferStation,
                caption = "换乘站",
                active = state.currentStation == state.transferStation,
                lineColor = Color(state.primaryLineColor)
            )
            SmartSubwayVerticalConnector(Color(state.secondaryLineColor))
        } else {
            SmartSubwayVerticalConnector(Color(state.primaryLineColor))
        }
        SmartSubwayVerticalNode(
            title = state.currentStation,
            caption = "当前站",
            active = true,
            lineColor = Color(state.primaryLineColor)
        )
        val activeLine = if (state.isAfterTransfer()) {
            Color(state.secondaryLineColor)
        } else {
            Color(state.primaryLineColor)
        }
        SmartSubwayVerticalConnector(activeLine)
        SmartSubwayVerticalNode(
            title = state.nextStation,
            caption = "下一站",
            active = false,
            lineColor = activeLine
        )
        SmartSubwayVerticalConnector(activeLine)
        SmartSubwayVerticalNode(
            title = state.destination,
            caption = "终点站",
            active = false,
            lineColor = activeLine
        )
    }
}

@Composable
private fun SmartSubwayVerticalNode(
    title: String,
    caption: String,
    active: Boolean,
    lineColor: Color
) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier.size(if (active) 18.dp else 12.dp),
            contentAlignment = Alignment.Center
        ) {
            if (active) {
                Box(
                    modifier = Modifier
                        .size(18.dp)
                        .clip(CircleShape)
                        .background(Color.White)
                )
            } else {
                Box(
                    modifier = Modifier
                        .size(12.dp)
                        .clip(CircleShape)
                        .background(Color(0xFF24262A))
                )
                Box(
                    modifier = Modifier
                        .size(7.dp)
                        .clip(CircleShape)
                        .background(lineColor)
                )
            }
        }
        Spacer(Modifier.width(12.dp))
        Column {
            Text(
                text = title,
                color = if (active) Color.White else Color(0xFFD0D1D5),
                fontSize = if (active) 15.sp else 14.sp,
                fontWeight = if (active) FontWeight.Medium else FontWeight.Normal
            )
            Spacer(Modifier.height(2.dp))
            Text(
                text = caption,
                color = if (active) Color.White else Color(0xFF777A80),
                fontSize = 11.sp
            )
        }
    }
}

@Composable
private fun SmartSubwayVerticalConnector(color: Color) {
    Box(
        modifier = Modifier
            .padding(start = 8.dp)
            .width(6.dp)
            .height(26.dp)
            .background(color)
    )
}

fun renderSmartSubwayRouteBitmap(
    state: SmartSubwayRealtimeState,
    widthPx: Int = 1000,
    heightPx: Int = 260
): Bitmap {
    val bitmap = Bitmap.createBitmap(widthPx.coerceAtLeast(700), heightPx.coerceAtLeast(240), Bitmap.Config.ARGB_8888)
    val canvas = AndroidCanvas(bitmap)
    canvas.drawColor(AndroidColor.TRANSPARENT)
    val w = bitmap.width.toFloat()
    val h = bitmap.height.toFloat()
    val y = h * 0.30f
    val positions = floatArrayOf(w * 0.10f, w * 0.50f, w * 0.90f)
    val activeColor = if (state.isAfterTransfer()) state.secondaryLineColor else state.primaryLineColor

    val routePaint = Paint(Paint.ANTI_ALIAS_FLAG).apply { strokeWidth = 18f; strokeCap = Paint.Cap.BUTT; style = Paint.Style.STROKE }
    val nodePaint = Paint(Paint.ANTI_ALIAS_FLAG).apply { style = Paint.Style.FILL }
    val ringPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply { color = AndroidColor.WHITE; style = Paint.Style.STROKE; strokeWidth = 7f }
    val titlePaint = Paint(Paint.ANTI_ALIAS_FLAG).apply { color = AndroidColor.WHITE; textSize = 42f; typeface = Typeface.create("sans-serif-medium", Typeface.BOLD); textAlign = Paint.Align.CENTER }
    val activeTitlePaint = Paint(Paint.ANTI_ALIAS_FLAG).apply { color = AndroidColor.WHITE; textSize = 52f; typeface = Typeface.create("sans-serif", Typeface.BOLD); textAlign = Paint.Align.CENTER }
    val captionPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply { color = SmartSubwayNotificationSpec.secondaryText; textSize = 28f; typeface = Typeface.create("sans-serif", Typeface.NORMAL); textAlign = Paint.Align.CENTER }

    fun segment(from: Int, to: Int) {
        val start = positions[from] + if (from == 1) 28f else 25f
        val end = positions[to] - if (to == 1) 28f else 25f
        if (end <= start) return
        routePaint.color = activeColor
        canvas.drawLine(start, y, end, y, routePaint)
    }
    segment(0, 1); segment(1, 2)

    positions.forEachIndexed { index, x ->
        if (index == 1) {
            canvas.drawCircle(x, y, 34f, ringPaint)
            nodePaint.color = AndroidColor.WHITE
            canvas.drawCircle(x, y, 25f, nodePaint)
        } else {
            nodePaint.color = AndroidColor.rgb(30, 33, 37)
            canvas.drawCircle(x, y, 18f, nodePaint)
            nodePaint.color = AndroidColor.rgb(155, 158, 164)
            canvas.drawCircle(x, y, 13f, nodePaint)
        }
    }

    val previous = state.previousStation.takeIf { it.isNotBlank() && !it.equals(state.currentStation, true) } ?: "上一站"
    val current = state.currentStation.ifBlank { "当前站" }
    val next = state.nextStation.ifBlank { "下一站" }
    canvas.drawText(previous, positions[0], h * 0.67f, titlePaint)
    canvas.drawText(current, positions[1], h * 0.67f, activeTitlePaint)
    canvas.drawText(next, positions[2], h * 0.67f, titlePaint)
    canvas.drawText("上一站", positions[0], h * 0.90f, captionPaint)
    canvas.drawText("当前站", positions[1], h * 0.90f, captionPaint)
    canvas.drawText("下一站", positions[2], h * 0.90f, captionPaint)
    return bitmap
}

/**
 * 为 RemoteViews 预留的统一 route image 注入辅助函数。
 */
fun applySmartSubwayRouteBitmap(
    remoteViews: RemoteViews,
    imageViewId: Int,
    state: SmartSubwayRealtimeState
) {
    remoteViews.setImageViewBitmap(
        imageViewId,
        renderSmartSubwayRouteBitmap(state)
    )
    remoteViews.setViewVisibility(imageViewId, View.VISIBLE)
}