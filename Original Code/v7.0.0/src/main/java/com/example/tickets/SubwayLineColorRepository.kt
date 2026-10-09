package com.example.tickets;

import android.content.Context;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.io.CloseableKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlin.text.Charsets;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: SubwayLineColorRepository.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0010\u0011\n\u0002\b\b\bÇ\u0002\u0018\u00002\u00020\u0001:\u00010B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J1\u0010\u0011\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00052\b\b\u0002\u0010\u0014\u001a\u00020\u00052\b\b\u0002\u0010\u0015\u001a\u00020\u0005¢\u0006\u0002\u0010\u0016J*\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00052\b\b\u0002\u0010\u0014\u001a\u00020\u00052\b\b\u0002\u0010\u0015\u001a\u00020\u0005J\u000e\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0005J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u001a\u0010\u001d\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0005H\u0002J\u001e\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00050\u001f2\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0005H\u0002J&\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00050\u001f2\u0006\u0010!\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0005H\u0002J\u0010\u0010\"\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\u0005H\u0002J\u0010\u0010$\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\u0005H\u0002J\u0010\u0010%\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\u0005H\u0002J\u0012\u0010&\u001a\u0004\u0018\u00010\u00052\u0006\u0010#\u001a\u00020\u0005H\u0002J!\u0010'\u001a\u00020\u00052\u0012\u0010(\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050)\"\u00020\u0005H\u0002¢\u0006\u0002\u0010*J\u0017\u0010+\u001a\u0004\u0018\u00010\n2\u0006\u0010,\u001a\u00020\u0005H\u0002¢\u0006\u0002\u0010-R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R&\u0010\b\u001a\u001a\u0012\u0004\u0012\u00020\u0005\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\n0\t0\tX\u0082\u000e¢\u0006\u0002\n\u0000R&\u0010\u000b\u001a\u001a\u0012\u0004\u0012\u00020\u0005\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\t0\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R&\u0010.\u001a\u001a\u0012\u0004\u0012\u00020\u0005\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\t0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010/\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u00061"}, d2 = {"Lcom/example/tickets/SubwayLineColorRepository;", "", "<init>", "()V", "ASSET_NAME", "", "loaded", "", "colorsByCity", "", "", "aliasesByCity", "loadLock", "ensureInitialized", "", "context", "Landroid/content/Context;", "colorFor", "cityId", "shortName", "routeId", "cityNameZh", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Integer;", "requireColorFor", "hasCity", "parseCities", "Lcom/example/tickets/SubwayLineColorRepository$ParsedColors;", "root", "Lorg/json/JSONObject;", "resolveCityKey", "buildLineCandidates", "", "specialAliasCandidates", "cityKey", "normalizeAliasKey", "value", "normalizeLineKey", "normalizeCityKey", "extractPureNumericLine", "firstNonBlank", "values", "", "([Ljava/lang/String;)Ljava/lang/String;", "parseHexColor", "raw", "(Ljava/lang/String;)Ljava/lang/Integer;", "SPECIAL_LINE_ALIASES", "CITY_ID_TO_NAME", "ParsedColors", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class SubwayLineColorRepository {
    private static final String ASSET_NAME = "subway_line_colors.json";
    private static volatile boolean loaded;
    public static final SubwayLineColorRepository INSTANCE = new SubwayLineColorRepository();
    private static volatile Map<String, ? extends Map<String, Integer>> colorsByCity = MapsKt.emptyMap();
    private static volatile Map<String, ? extends Map<String, String>> aliasesByCity = MapsKt.emptyMap();
    private static final Object loadLock = new Object();
    private static final Map<String, Map<String, String>> SPECIAL_LINE_ALIASES = MapsKt.mapOf(TuplesKt.to("香港", MapsKt.mapOf(TuplesKt.to("东铁线", "EA"), TuplesKt.to("東鐵線", "EA"), TuplesKt.to("EastRailLine", "EA"), TuplesKt.to("EastRail", "EA"), TuplesKt.to("EAL", "EA"), TuplesKt.to("EA", "EA"), TuplesKt.to("港岛线", "IS"), TuplesKt.to("港島線", "IS"), TuplesKt.to("IslandLine", "IS"), TuplesKt.to("ISL", "IS"), TuplesKt.to("IS", "IS"), TuplesKt.to("观塘线", "KT"), TuplesKt.to("觀塘線", "KT"), TuplesKt.to("KwunTongLine", "KT"), TuplesKt.to("KTL", "KT"), TuplesKt.to("KT", "KT"), TuplesKt.to("南港岛线", "SI"), TuplesKt.to("南港島線", "SI"), TuplesKt.to("SouthIslandLine", "SI"), TuplesKt.to("SIL", "SI"), TuplesKt.to("SI", "SI"), TuplesKt.to("将军澳线", "TK"), TuplesKt.to("將軍澳線", "TK"), TuplesKt.to("TseungKwanOLine", "TK"), TuplesKt.to("TKL", "TK"), TuplesKt.to("TK", "TK"), TuplesKt.to("荃湾线", "TW"), TuplesKt.to("荃灣線", "TW"), TuplesKt.to("TsuenWanLine", "TW"), TuplesKt.to("TWL", "TW"), TuplesKt.to("TW", "TW"), TuplesKt.to("屯马线", "MO"), TuplesKt.to("屯馬線", "MO"), TuplesKt.to("TuenMaLine", "MO"), TuplesKt.to("TML", "MO"), TuplesKt.to("MO", "MO"), TuplesKt.to("东涌线", "TC"), TuplesKt.to("東涌線", "TC"), TuplesKt.to("TungChungLine", "TC"), TuplesKt.to("TCL", "TC"), TuplesKt.to("TC", "TC"), TuplesKt.to("机场快线", "AE"), TuplesKt.to("機場快線", "AE"), TuplesKt.to("AirportExpress", "AE"), TuplesKt.to("AEL", "AE"), TuplesKt.to("AE", "AE"), TuplesKt.to("迪士尼线", "DR"), TuplesKt.to("迪士尼線", "DR"), TuplesKt.to("DisneylandResortLine", "DR"), TuplesKt.to("DRL", "DR"), TuplesKt.to("DR", "DR"))), TuplesKt.to("上海", MapsKt.mapOf(TuplesKt.to("磁浮", "ML"), TuplesKt.to("磁浮线", "ML"), TuplesKt.to("磁浮線", "ML"), TuplesKt.to("上海磁浮", "ML"), TuplesKt.to("上海磁浮线", "ML"), TuplesKt.to("ShanghaiMaglev", "ML"), TuplesKt.to("Maglev", "ML"), TuplesKt.to("MaglevLine", "ML"), TuplesKt.to("MaglevTrain", "ML"), TuplesKt.to("ML", "ML"), TuplesKt.to("浦江线", "PJ"), TuplesKt.to("浦江線", "PJ"), TuplesKt.to("PujiangLine", "PJ"), TuplesKt.to("Pujiang", "PJ"), TuplesKt.to("PJ", "PJ"))), TuplesKt.to("深圳", MapsKt.mapOf(TuplesKt.to("6号线支线", "6B"), TuplesKt.to("6号綫支綫", "6B"), TuplesKt.to("6B线", "6B"), TuplesKt.to("6B綫", "6B"), TuplesKt.to("Line6Branch", "6B"), TuplesKt.to("6B", "6B"))), TuplesKt.to("广州", MapsKt.mapOf(TuplesKt.to("APM", "APM"), TuplesKt.to("APM线", "APM"), TuplesKt.to("APM綫", "APM"), TuplesKt.to("APMLine", "APM"))), TuplesKt.to("佛山", MapsKt.mapOf(TuplesKt.to("广佛线", "GF"), TuplesKt.to("廣佛線", "GF"), TuplesKt.to("广佛地铁", "GF"), TuplesKt.to("GuangfoLine", "GF"), TuplesKt.to("GF", "GF"))), TuplesKt.to("武汉", MapsKt.mapOf(TuplesKt.to("阳逻线", "YL"), TuplesKt.to("陽邏線", "YL"), TuplesKt.to("阳逻", "YL"), TuplesKt.to("YangluoLine", "YL"), TuplesKt.to("YL", "YL"))), TuplesKt.to("青岛", MapsKt.mapOf(TuplesKt.to("蓝谷快线", "LG"), TuplesKt.to("藍谷快線", "LG"), TuplesKt.to("BlueValleyExpress", "LG"), TuplesKt.to("11号线", "LG"), TuplesKt.to("11号綫", "LG"), TuplesKt.to("LG", "LG"), TuplesKt.to("西海岸快线", "XHA"), TuplesKt.to("西海岸快線", "XHA"), TuplesKt.to("WestCoastExpress", "XHA"), TuplesKt.to("13号线", "XHA"), TuplesKt.to("13号綫", "XHA"), TuplesKt.to("XHA", "XHA"))), TuplesKt.to("北京", MapsKt.mapOf(TuplesKt.to("亦庄线", "YZ"), TuplesKt.to("亦莊線", "YZ"), TuplesKt.to("YizhuangLine", "YZ"), TuplesKt.to("YZ", "YZ"), TuplesKt.to("房山线", "FS"), TuplesKt.to("房山線", "FS"), TuplesKt.to("FangshanLine", "FS"), TuplesKt.to("FS", "FS"), TuplesKt.to("昌平线", "CP"), TuplesKt.to("昌平線", "CP"), TuplesKt.to("ChangpingLine", "CP"), TuplesKt.to("CP", "CP"), TuplesKt.to("首都机场线", "CAE"), TuplesKt.to("首都機場線", "CAE"), TuplesKt.to("CapitalAirportExpress", "CAE"), TuplesKt.to("AirportExpress", "CAE"), TuplesKt.to("CAE", "CAE"), TuplesKt.to("大兴机场线", "DAE"), TuplesKt.to("大興機場線", "DAE"), TuplesKt.to("DaxingAirportExpress", "DAE"), TuplesKt.to("DAE", "DAE"), TuplesKt.to("M101", "M101"))));
    private static final Map<String, String> CITY_ID_TO_NAME = MapsKt.mapOf(TuplesKt.to("beijing", "北京"), TuplesKt.to("shanghai", "上海"), TuplesKt.to("guangzhou", "广州"), TuplesKt.to("shenzhen", "深圳"), TuplesKt.to("chengdu", "成都"), TuplesKt.to("hangzhou", "杭州"), TuplesKt.to("wuhan", "武汉"), TuplesKt.to("chongqing", "重庆"), TuplesKt.to("nanjing", "南京"), TuplesKt.to("xian", "西安"), TuplesKt.to("tianjin", "天津"), TuplesKt.to("zhengzhou", "郑州"), TuplesKt.to("suzhou", "苏州"), TuplesKt.to("ningbo", "宁波"), TuplesKt.to("hefei", "合肥"), TuplesKt.to("changsha", "长沙"), TuplesKt.to("qingdao", "青岛"), TuplesKt.to("jinan", "济南"), TuplesKt.to("kunming", "昆明"), TuplesKt.to("nanning", "南宁"), TuplesKt.to("shenyang", "沈阳"), TuplesKt.to("changchun", "长春"), TuplesKt.to("dalian", "大连"), TuplesKt.to("wuxi", "无锡"), TuplesKt.to("xuzhou", "徐州"), TuplesKt.to("nanchang", "南昌"), TuplesKt.to("hong_kong", "香港"), TuplesKt.to("hongkong", "香港"), TuplesKt.to("guiyang", "贵阳"), TuplesKt.to("foshan", "佛山"), TuplesKt.to("fuzhou", "福州"), TuplesKt.to("xiamen", "厦门"), TuplesKt.to("shijiazhuang", "石家庄"), TuplesKt.to("harbin", "哈尔滨"), TuplesKt.to("dongguan", "东莞"), TuplesKt.to("urumqi", "乌鲁木齐"), TuplesKt.to("wulumuqi", "乌鲁木齐"), TuplesKt.to("huhehaote", "呼和浩特"), TuplesKt.to("wenzhou", "温州"), TuplesKt.to("lanzhou", "兰州"), TuplesKt.to("changzhou", "常州"));
    public static final int $stable = 8;

    private SubwayLineColorRepository() {
    }

    public final void ensureInitialized(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (loaded) {
            return;
        }
        synchronized (loadLock) {
            if (loaded) {
                return;
            }
            try {
                InputStream inputStreamOpen = context.getApplicationContext().getAssets().open(ASSET_NAME);
                Intrinsics.checkNotNullExpressionValue(inputStreamOpen, "open(...)");
                Reader inputStreamReader = new InputStreamReader(inputStreamOpen, Charsets.UTF_8);
                BufferedReader bufferedReader = inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, 8192);
                try {
                    ParsedColors cities = INSTANCE.parseCities(new JSONObject(TextStreamsKt.readText(bufferedReader)));
                    CloseableKt.closeFinally(bufferedReader, null);
                    if (cities.getColorsByCity().isEmpty()) {
                        throw new IllegalStateException("subway_line_colors.json 没有任何城市线路颜色数据。");
                    }
                    colorsByCity = cities.getColorsByCity();
                    aliasesByCity = cities.getAliasesByCity();
                    loaded = true;
                    Unit unit = Unit.INSTANCE;
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        CloseableKt.closeFinally(bufferedReader, th);
                        throw th2;
                    }
                }
            } catch (Throwable th3) {
                throw new IllegalStateException("subway_line_colors.json 读取/解析失败；为了保证线路颜色与用户提供的23张图片一致，拒绝继续使用错误颜色。", th3);
            }
        }
    }

    public static /* synthetic */ Integer colorFor$default(SubwayLineColorRepository subwayLineColorRepository, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 4) != 0) {
            str3 = "";
        }
        if ((i & 8) != 0) {
            str4 = "";
        }
        return subwayLineColorRepository.colorFor(str, str2, str3, str4);
    }

    public final Integer colorFor(String cityId, String shortName, String routeId, String cityNameZh) {
        Map<String, Integer> map;
        Integer num;
        Intrinsics.checkNotNullParameter(cityId, "cityId");
        Intrinsics.checkNotNullParameter(shortName, "shortName");
        Intrinsics.checkNotNullParameter(routeId, "routeId");
        Intrinsics.checkNotNullParameter(cityNameZh, "cityNameZh");
        String strResolveCityKey = resolveCityKey(cityId, cityNameZh);
        if (strResolveCityKey == null || (map = colorsByCity.get(strResolveCityKey)) == null) {
            return null;
        }
        Map<String, String> mapEmptyMap = aliasesByCity.get(strResolveCityKey);
        if (mapEmptyMap == null) {
            mapEmptyMap = MapsKt.emptyMap();
        }
        List listPlus = CollectionsKt.plus((Collection) buildLineCandidates(shortName, routeId), (Iterable) specialAliasCandidates(strResolveCityKey, shortName, routeId));
        Iterator it = SequencesKt.distinct(SequencesKt.filter(SequencesKt.map(CollectionsKt.asSequence(listPlus), new AnonymousClass1(this)), new Function1() { // from class: com.example.tickets.SubwayLineColorRepository$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(SubwayLineColorRepository.colorFor$lambda$2((String) obj));
            }
        })).iterator();
        while (it.hasNext()) {
            Integer num2 = map.get((String) it.next());
            if (num2 != null) {
                return Integer.valueOf(num2.intValue());
            }
        }
        Iterator it2 = SequencesKt.distinct(SequencesKt.filter(SequencesKt.map(CollectionsKt.asSequence(listPlus), new AnonymousClass4(this)), new Function1() { // from class: com.example.tickets.SubwayLineColorRepository$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(SubwayLineColorRepository.colorFor$lambda$5((String) obj));
            }
        })).iterator();
        while (it2.hasNext()) {
            String str = mapEmptyMap.get((String) it2.next());
            if (str != null && (num = map.get(INSTANCE.normalizeLineKey(str))) != null) {
                return Integer.valueOf(num.intValue());
            }
        }
        Iterator it3 = SequencesKt.distinct(SequencesKt.mapNotNull(CollectionsKt.asSequence(listPlus), new AnonymousClass7(this))).iterator();
        while (it3.hasNext()) {
            Integer num3 = map.get((String) it3.next());
            if (num3 != null) {
                return Integer.valueOf(num3.intValue());
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: com.example.tickets.SubwayLineColorRepository$colorFor$1, reason: invalid class name */
    /* JADX INFO: compiled from: SubwayLineColorRepository.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<String, String> {
        AnonymousClass1(Object obj) {
            super(1, obj, SubwayLineColorRepository.class, "normalizeLineKey", "normalizeLineKey(Ljava/lang/String;)Ljava/lang/String;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public final String invoke(String p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return ((SubwayLineColorRepository) this.receiver).normalizeLineKey(p0);
        }
    }

    static final boolean colorFor$lambda$2(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return !StringsKt.isBlank(it);
    }

    /* JADX INFO: renamed from: com.example.tickets.SubwayLineColorRepository$colorFor$4, reason: invalid class name */
    /* JADX INFO: compiled from: SubwayLineColorRepository.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    static final /* synthetic */ class AnonymousClass4 extends FunctionReferenceImpl implements Function1<String, String> {
        AnonymousClass4(Object obj) {
            super(1, obj, SubwayLineColorRepository.class, "normalizeAliasKey", "normalizeAliasKey(Ljava/lang/String;)Ljava/lang/String;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public final String invoke(String p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return ((SubwayLineColorRepository) this.receiver).normalizeAliasKey(p0);
        }
    }

    static final boolean colorFor$lambda$5(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return !StringsKt.isBlank(it);
    }

    /* JADX INFO: renamed from: com.example.tickets.SubwayLineColorRepository$colorFor$7, reason: invalid class name */
    /* JADX INFO: compiled from: SubwayLineColorRepository.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    static final /* synthetic */ class AnonymousClass7 extends FunctionReferenceImpl implements Function1<String, String> {
        AnonymousClass7(Object obj) {
            super(1, obj, SubwayLineColorRepository.class, "extractPureNumericLine", "extractPureNumericLine(Ljava/lang/String;)Ljava/lang/String;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public final String invoke(String p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return ((SubwayLineColorRepository) this.receiver).extractPureNumericLine(p0);
        }
    }

    public static /* synthetic */ int requireColorFor$default(SubwayLineColorRepository subwayLineColorRepository, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 4) != 0) {
            str3 = "";
        }
        if ((i & 8) != 0) {
            str4 = "";
        }
        return subwayLineColorRepository.requireColorFor(str, str2, str3, str4);
    }

    public final int requireColorFor(String cityId, String shortName, String routeId, String cityNameZh) {
        Intrinsics.checkNotNullParameter(cityId, "cityId");
        Intrinsics.checkNotNullParameter(shortName, "shortName");
        Intrinsics.checkNotNullParameter(routeId, "routeId");
        Intrinsics.checkNotNullParameter(cityNameZh, "cityNameZh");
        Integer numColorFor = colorFor(cityId, shortName, routeId, cityNameZh);
        if (numColorFor != null) {
            return numColorFor.intValue();
        }
        throw new IllegalStateException("颜色库缺少线路：cityId=" + cityId + ", cityName=" + cityNameZh + ", shortName=" + shortName + ", routeId=" + routeId);
    }

    public final boolean hasCity(String cityNameZh) {
        Intrinsics.checkNotNullParameter(cityNameZh, "cityNameZh");
        return colorsByCity.containsKey(StringsKt.trim((CharSequence) cityNameZh).toString());
    }

    /* JADX INFO: compiled from: SubwayLineColorRepository.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0082\b\u0018\u00002\u00020\u0001BG\u0012\u001e\u0010\u0002\u001a\u001a\u0012\u0004\u0012\u00020\u0004\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00030\u0003\u0012\u001e\u0010\u0006\u001a\u001a\u0012\u0004\u0012\u00020\u0004\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00030\u0003¢\u0006\u0004\b\u0007\u0010\bJ!\u0010\f\u001a\u001a\u0012\u0004\u0012\u00020\u0004\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00030\u0003HÆ\u0003J!\u0010\r\u001a\u001a\u0012\u0004\u0012\u00020\u0004\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00030\u0003HÆ\u0003JM\u0010\u000e\u001a\u00020\u00002 \b\u0002\u0010\u0002\u001a\u001a\u0012\u0004\u0012\u00020\u0004\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00030\u00032 \b\u0002\u0010\u0006\u001a\u001a\u0012\u0004\u0012\u00020\u0004\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00030\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0004HÖ\u0001R)\u0010\u0002\u001a\u001a\u0012\u0004\u0012\u00020\u0004\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00030\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR)\u0010\u0006\u001a\u001a\u0012\u0004\u0012\u00020\u0004\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00030\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/example/tickets/SubwayLineColorRepository$ParsedColors;", "", "colorsByCity", "", "", "", "aliasesByCity", "<init>", "(Ljava/util/Map;Ljava/util/Map;)V", "getColorsByCity", "()Ljava/util/Map;", "getAliasesByCity", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
    private static final /* data */ class ParsedColors {
        private final Map<String, Map<String, String>> aliasesByCity;
        private final Map<String, Map<String, Integer>> colorsByCity;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ParsedColors copy$default(ParsedColors parsedColors, Map map, Map map2, int i, Object obj) {
            if ((i & 1) != 0) {
                map = parsedColors.colorsByCity;
            }
            if ((i & 2) != 0) {
                map2 = parsedColors.aliasesByCity;
            }
            return parsedColors.copy(map, map2);
        }

        public final Map<String, Map<String, Integer>> component1() {
            return this.colorsByCity;
        }

        public final Map<String, Map<String, String>> component2() {
            return this.aliasesByCity;
        }

        public final ParsedColors copy(Map<String, ? extends Map<String, Integer>> colorsByCity, Map<String, ? extends Map<String, String>> aliasesByCity) {
            Intrinsics.checkNotNullParameter(colorsByCity, "colorsByCity");
            Intrinsics.checkNotNullParameter(aliasesByCity, "aliasesByCity");
            return new ParsedColors(colorsByCity, aliasesByCity);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ParsedColors)) {
                return false;
            }
            ParsedColors parsedColors = (ParsedColors) other;
            return Intrinsics.areEqual(this.colorsByCity, parsedColors.colorsByCity) && Intrinsics.areEqual(this.aliasesByCity, parsedColors.aliasesByCity);
        }

        public int hashCode() {
            return (this.colorsByCity.hashCode() * 31) + this.aliasesByCity.hashCode();
        }

        public String toString() {
            return "ParsedColors(colorsByCity=" + this.colorsByCity + ", aliasesByCity=" + this.aliasesByCity + ")";
        }

        /* JADX WARN: Multi-variable type inference failed */
        public ParsedColors(Map<String, ? extends Map<String, Integer>> colorsByCity, Map<String, ? extends Map<String, String>> aliasesByCity) {
            Intrinsics.checkNotNullParameter(colorsByCity, "colorsByCity");
            Intrinsics.checkNotNullParameter(aliasesByCity, "aliasesByCity");
            this.colorsByCity = colorsByCity;
            this.aliasesByCity = aliasesByCity;
        }

        public final Map<String, Map<String, Integer>> getColorsByCity() {
            return this.colorsByCity;
        }

        public final Map<String, Map<String, String>> getAliasesByCity() {
            return this.aliasesByCity;
        }
    }

    private final ParsedColors parseCities(JSONObject root) {
        JSONObject jSONObjectOptJSONObject = root.optJSONObject("cities");
        if (jSONObjectOptJSONObject == null) {
            return new ParsedColors(MapsKt.emptyMap(), MapsKt.emptyMap());
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        Iterator<String> itKeys = jSONObjectOptJSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray(next);
            if (jSONArrayOptJSONArray == null) {
                jSONArrayOptJSONArray = new JSONArray();
            }
            LinkedHashMap linkedHashMap3 = new LinkedHashMap();
            LinkedHashMap linkedHashMap4 = new LinkedHashMap();
            int length = jSONArrayOptJSONArray.length();
            int i = 0;
            while (i < length) {
                JSONObject jSONObjectOptJSONObject2 = jSONArrayOptJSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject2 != null) {
                    String strOptString = jSONObjectOptJSONObject2.optString("line_id");
                    Intrinsics.checkNotNullExpressionValue(strOptString, "optString(...)");
                    String string = StringsKt.trim((CharSequence) strOptString).toString();
                    String strOptString2 = jSONObjectOptJSONObject2.optString("verified_hex");
                    Intrinsics.checkNotNullExpressionValue(strOptString2, "optString(...)");
                    String strOptString3 = jSONObjectOptJSONObject2.optString("image_hex");
                    Intrinsics.checkNotNullExpressionValue(strOptString3, "optString(...)");
                    String string2 = StringsKt.trim((CharSequence) firstNonBlank(strOptString2, strOptString3)).toString();
                    if (!StringsKt.isBlank(string) && !StringsKt.isBlank(string2)) {
                        String strNormalizeLineKey = normalizeLineKey(string);
                        Integer hexColor = parseHexColor(string2);
                        if (hexColor != null) {
                            linkedHashMap3.put(strNormalizeLineKey, Integer.valueOf(hexColor.intValue()));
                        }
                        JSONArray jSONArrayOptJSONArray2 = jSONObjectOptJSONObject2.optJSONArray("aliases");
                        if (jSONArrayOptJSONArray2 == null) {
                            jSONArrayOptJSONArray2 = new JSONArray();
                        }
                        int length2 = jSONArrayOptJSONArray2.length();
                        int i2 = 0;
                        while (i2 < length2) {
                            JSONObject jSONObject = jSONObjectOptJSONObject;
                            String strOptString4 = jSONArrayOptJSONArray2.optString(i2);
                            Intrinsics.checkNotNullExpressionValue(strOptString4, "optString(...)");
                            String string3 = StringsKt.trim((CharSequence) strOptString4).toString();
                            if (!StringsKt.isBlank(string3)) {
                                linkedHashMap4.put(normalizeAliasKey(string3), strNormalizeLineKey);
                            }
                            i2++;
                            jSONObjectOptJSONObject = jSONObject;
                            linkedHashMap = linkedHashMap;
                        }
                    }
                }
                i++;
                jSONObjectOptJSONObject = jSONObjectOptJSONObject;
                linkedHashMap = linkedHashMap;
            }
            LinkedHashMap linkedHashMap5 = linkedHashMap;
            linkedHashMap5.put(next, linkedHashMap3);
            linkedHashMap2.put(next, linkedHashMap4);
            jSONObjectOptJSONObject = jSONObjectOptJSONObject;
            linkedHashMap = linkedHashMap5;
        }
        return new ParsedColors(linkedHashMap, linkedHashMap2);
    }

    private final String resolveCityKey(String cityId, String cityNameZh) {
        String string = StringsKt.trim((CharSequence) cityNameZh).toString();
        if (!StringsKt.isBlank(string) && colorsByCity.containsKey(string)) {
            return string;
        }
        String string2 = StringsKt.trim((CharSequence) cityId).toString();
        Locale ROOT = Locale.ROOT;
        Intrinsics.checkNotNullExpressionValue(ROOT, "ROOT");
        String lowerCase = string2.toLowerCase(ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        String str = CITY_ID_TO_NAME.get(lowerCase);
        Object obj = null;
        if (str != null) {
            if (!colorsByCity.containsKey(str)) {
                str = null;
            }
            if (str != null) {
                return str;
            }
        }
        for (Object obj2 : colorsByCity.keySet()) {
            SubwayLineColorRepository subwayLineColorRepository = INSTANCE;
            if (Intrinsics.areEqual(subwayLineColorRepository.normalizeCityKey((String) obj2), subwayLineColorRepository.normalizeCityKey(cityId))) {
                obj = obj2;
                break;
            }
        }
        return (String) obj;
    }

    private final List<String> buildLineCandidates(String shortName, String routeId) {
        List listCreateListBuilder = CollectionsKt.createListBuilder();
        if (!StringsKt.isBlank(shortName)) {
            listCreateListBuilder.add(shortName);
        }
        String str = routeId;
        if (!StringsKt.isBlank(str)) {
            listCreateListBuilder.add(routeId);
        }
        if (StringsKt.contains$default((CharSequence) str, ':', false, 2, (Object) null)) {
            listCreateListBuilder.add(StringsKt.substringAfterLast$default(routeId, ':', (String) null, 2, (Object) null));
        }
        if (StringsKt.contains$default((CharSequence) str, '/', false, 2, (Object) null)) {
            listCreateListBuilder.add(StringsKt.substringAfterLast$default(routeId, '/', (String) null, 2, (Object) null));
        }
        List<String> listBuild = CollectionsKt.build(listCreateListBuilder);
        ArrayList arrayList = new ArrayList();
        for (String str2 : listBuild) {
            CollectionsKt.addAll(arrayList, CollectionsKt.listOf((Object[]) new String[]{str2, StringsKt.removeSuffix(str2, (CharSequence) "号线"), StringsKt.removeSuffix(str2, (CharSequence) "号綫"), StringsKt.removeSuffix(str2, (CharSequence) "线"), StringsKt.removeSuffix(str2, (CharSequence) "綫"), StringsKt.removePrefix(str2, (CharSequence) "Line "), StringsKt.removePrefix(str2, (CharSequence) "line ")}));
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            if (!StringsKt.isBlank((String) obj)) {
                arrayList2.add(obj);
            }
        }
        return CollectionsKt.distinct(arrayList2);
    }

    private final List<String> specialAliasCandidates(String cityKey, String shortName, String routeId) {
        List<String> listListOf;
        Object next;
        String str;
        List<String> listBuildLineCandidates = buildLineCandidates(shortName, routeId);
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listBuildLineCandidates, 10));
        Iterator<T> it = listBuildLineCandidates.iterator();
        while (it.hasNext()) {
            arrayList.add(normalizeAliasKey((String) it.next()));
        }
        ArrayList arrayList2 = arrayList;
        Map<String, String> mapEmptyMap = SPECIAL_LINE_ALIASES.get(cityKey);
        if (mapEmptyMap == null) {
            mapEmptyMap = MapsKt.emptyMap();
        }
        Iterator<T> it2 = mapEmptyMap.entrySet().iterator();
        while (it2.hasNext()) {
            Map.Entry entry = (Map.Entry) it2.next();
            String str2 = (String) entry.getKey();
            String str3 = (String) entry.getValue();
            String strNormalizeAliasKey = INSTANCE.normalizeAliasKey(str2);
            ArrayList arrayList3 = arrayList2;
            if (!(arrayList3 instanceof Collection) || !arrayList3.isEmpty()) {
                Iterator it3 = arrayList3.iterator();
                while (it3.hasNext()) {
                    if (Intrinsics.areEqual((String) it3.next(), strNormalizeAliasKey)) {
                        return CollectionsKt.listOf(str3);
                    }
                }
            }
        }
        if (Intrinsics.areEqual(cityKey, "香港")) {
            return CollectionsKt.emptyList();
        }
        Iterator it4 = CollectionsKt.sortedWith(mapEmptyMap.entrySet(), new Comparator() { // from class: com.example.tickets.SubwayLineColorRepository$specialAliasCandidates$$inlined$sortedByDescending$1
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(Integer.valueOf(((String) ((Map.Entry) t2).getKey()).length()), Integer.valueOf(((String) ((Map.Entry) t).getKey()).length()));
            }
        }).iterator();
        loop3: while (true) {
            listListOf = null;
            if (!it4.hasNext()) {
                next = null;
                break;
            }
            next = it4.next();
            String strNormalizeAliasKey2 = INSTANCE.normalizeAliasKey((String) ((Map.Entry) next).getKey());
            ArrayList<String> arrayList4 = arrayList2;
            if (!(arrayList4 instanceof Collection) || !arrayList4.isEmpty()) {
                for (String str4 : arrayList4) {
                    String str5 = strNormalizeAliasKey2;
                    if (StringsKt.contains$default((CharSequence) str4, (CharSequence) str5, false, 2, (Object) null) || StringsKt.contains$default((CharSequence) str5, (CharSequence) str4, false, 2, (Object) null)) {
                        break loop3;
                    }
                }
            }
        }
        Map.Entry entry2 = (Map.Entry) next;
        if (entry2 != null && (str = (String) entry2.getValue()) != null) {
            listListOf = CollectionsKt.listOf(str);
        }
        return listListOf == null ? CollectionsKt.emptyList() : listListOf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String normalizeAliasKey(String value) {
        String string = StringsKt.trim((CharSequence) value).toString();
        Locale ROOT = Locale.ROOT;
        Intrinsics.checkNotNullExpressionValue(ROOT, "ROOT");
        String lowerCase = string.toLowerCase(ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        return new Regex("[\\s_\\-–—:/·•()（）]+").replace(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(lowerCase, (char) 32171, (char) 32447, false, 4, (Object) null), (char) 32218, (char) 32447, false, 4, (Object) null), "地铁", "", false, 4, (Object) null), "港鐵", "", false, 4, (Object) null), AccessibilityNodeInfoCompat.MathInfoCompat.MATH_TAG_TABLE_ROW, "", false, 4, (Object) null), "metro", "", false, 4, (Object) null), "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String normalizeLineKey(String value) {
        String string = StringsKt.trim((CharSequence) value).toString();
        Locale ROOT = Locale.ROOT;
        Intrinsics.checkNotNullExpressionValue(ROOT, "ROOT");
        String lowerCase = string.toLowerCase(ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        return new Regex("[\\s\\-–—_:/·•]+").replace(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(lowerCase, "号线", "", false, 4, (Object) null), "号綫", "", false, 4, (Object) null), "线", "", false, 4, (Object) null), "綫", "", false, 4, (Object) null), "line", "", false, 4, (Object) null), "");
    }

    private final String normalizeCityKey(String value) {
        String string = StringsKt.trim((CharSequence) value).toString();
        Locale ROOT = Locale.ROOT;
        Intrinsics.checkNotNullExpressionValue(ROOT, "ROOT");
        String lowerCase = string.toLowerCase(ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        return new Regex("[\\s_\\-]+").replace(lowerCase, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String extractPureNumericLine(String value) {
        String string = StringsKt.trim((CharSequence) value).toString();
        Locale ROOT = Locale.ROOT;
        Intrinsics.checkNotNullExpressionValue(ROOT, "ROOT");
        String lowerCase = string.toLowerCase(ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        String strReplace = new Regex("[\\s\\-–—_:/·•]+").replace(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(lowerCase, "号线", "", false, 4, (Object) null), "号綫", "", false, 4, (Object) null), "line", "", false, 4, (Object) null), "线", "", false, 4, (Object) null), "綫", "", false, 4, (Object) null), "");
        if (new Regex("\\d{1,3}").matches(strReplace)) {
            return strReplace;
        }
        return null;
    }

    private final Integer parseHexColor(String raw) {
        Long longOrNull;
        String strRemovePrefix = StringsKt.removePrefix(StringsKt.trim((CharSequence) raw).toString(), (CharSequence) "#");
        int length = strRemovePrefix.length();
        if (length != 6) {
            if (length == 8 && (longOrNull = StringsKt.toLongOrNull(strRemovePrefix, 16)) != null) {
                return Integer.valueOf((int) longOrNull.longValue());
            }
            return null;
        }
        Long longOrNull2 = StringsKt.toLongOrNull(strRemovePrefix, 16);
        if (longOrNull2 != null) {
            return Integer.valueOf((int) (longOrNull2.longValue() | 4278190080L));
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0016 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:12:0x0019 A[RETURN] */
    private final String firstNonBlank(String... values) {
        for (String str : values) {
            if (!StringsKt.isBlank(str)) {
                if (str == null) {
                    return "";
                }
                return str;
            }
        }
        str = null;
        if (str == null) {
            return "";
        }
        return str;
    }
}
