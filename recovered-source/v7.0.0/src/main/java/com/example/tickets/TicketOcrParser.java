package com.example.tickets;

import androidx.autofill.HintConstants;
import androidx.core.app.NotificationCompat;
import com.google.firebase.messaging.Constants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.RegexOption;
import kotlin.text.StringsKt;
import kotlin.text.Typography;

/* JADX INFO: compiled from: TicketOcrParser.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b\u000b\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0007H\u0002J\u001e\u0010\f\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\u00072\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00070\u000fH\u0002J\u0010\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0007H\u0002J\u001c\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00070\u000f2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00070\u000fH\u0002J\u0010\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0007H\u0002J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0016\u001a\u00020\u0007H\u0002J\u0010\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u0007H\u0002J\u0016\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00070\u000f2\u0006\u0010\u0016\u001a\u00020\u0007H\u0002J\u0010\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u0007H\u0002J\u001c\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00070\u000f2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00070\u000fH\u0002J \u0010\u001d\u001a\u0004\u0018\u00010\u00072\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00070\u000f2\u0006\u0010\u001e\u001a\u00020\u0007H\u0002J\u0010\u0010\u001f\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u0007H\u0002J\u0018\u0010 \u001a\u0004\u0018\u00010\u00072\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00070\u000fH\u0002J\u0018\u0010!\u001a\u0004\u0018\u00010\u00072\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00070\u000fH\u0002J\u0010\u0010\"\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u0007H\u0002J\u0012\u0010#\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000b\u001a\u00020\u0007H\u0002J\u0012\u0010$\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000b\u001a\u00020\u0007H\u0002J\u0010\u0010%\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0007H\u0002J\u0010\u0010&\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0007H\u0002J\u0010\u0010'\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0007H\u0002J\u0010\u0010(\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0007H\u0002J\u0010\u0010)\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0007H\u0002J\u0012\u0010*\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000b\u001a\u00020\u0007H\u0002J\u0010\u0010+\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0007H\u0002J\u001e\u0010,\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010-2\u0006\u0010\u000b\u001a\u00020\u0007H\u0002J\u0012\u0010.\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000b\u001a\u00020\u0007H\u0002J\u0012\u0010/\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000b\u001a\u00020\u0007H\u0002J\u0012\u00100\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000b\u001a\u00020\u0007H\u0002J\u0012\u00101\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000b\u001a\u00020\u0007H\u0002J\u001c\u00102\u001a\b\u0012\u0004\u0012\u00020\u00070\u000f2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00070\u000fH\u0002J\u0010\u00103\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u0007H\u0002J\u0016\u00104\u001a\b\u0012\u0004\u0012\u00020\u00070\u000f2\u0006\u0010\u0016\u001a\u00020\u0007H\u0002J\u0010\u00105\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u0007H\u0002J \u00106\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000b\u001a\u00020\u00072\f\u00107\u001a\b\u0012\u0004\u0012\u00020\u00070\u000fH\u0002¨\u00068"}, d2 = {"Lcom/example/tickets/TicketOcrParser;", "", "<init>", "()V", "parse", "Lcom/example/tickets/OcrTicketDraft;", "rawText", "", "normalize", "detectType", "Lcom/example/tickets/OcrTicketType;", "text", "containsAny", "", "signals", "", "parseTrain", "findTrainRouteStations", "lines", "cleanOcrLine", "value", "extractStationAfterTime", "line", "isTimeOnlyLine", "splitTrainRouteLine", "normalizeStationCandidate", "raw", "distinctStations", "stations", "findOriginNearDestination", "destination", "looksLikeNonRouteText", "findFirstTimedStation", "findExplicitDestination", "isLikelyStationName", "findExplicitTrainNumber", "findExplicitSeat", "parseAirplane", "parseMovie", "parseEvent", "parseTakeout", "parsePickup", "findStandaloneTime", "parseAdmission", "findTimeRange", "Lkotlin/Pair;", "findDate", "findSeat", "findTrainNumber", "findFlightNumber", "findRouteStations", "cleanStationName", "splitRouteLine", "containsPossiblePlace", "findLabeledValue", "labels", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class TicketOcrParser {
    public static final int $stable = 0;
    public static final TicketOcrParser INSTANCE = new TicketOcrParser();

    /* JADX INFO: compiled from: TicketOcrParser.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[OcrTicketType.values().length];
            try {
                iArr[OcrTicketType.Train.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[OcrTicketType.Airplane.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[OcrTicketType.Movie.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[OcrTicketType.Event.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[OcrTicketType.Admission.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[OcrTicketType.Takeout.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[OcrTicketType.Pickup.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[OcrTicketType.Unknown.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private TicketOcrParser() {
    }

    public final OcrTicketDraft parse(String rawText) {
        Intrinsics.checkNotNullParameter(rawText, "rawText");
        String strNormalize = normalize(rawText);
        if (StringsKt.isBlank(strNormalize)) {
            return new OcrTicketDraft(OcrTicketType.Unknown, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 131070, null);
        }
        switch (WhenMappings.$EnumSwitchMapping$0[detectType(strNormalize).ordinal()]) {
            case 1:
                return parseTrain(strNormalize);
            case 2:
                return parseAirplane(strNormalize);
            case 3:
                return parseMovie(strNormalize);
            case 4:
                return parseEvent(strNormalize);
            case 5:
                return parseAdmission(strNormalize);
            case 6:
                return parseTakeout(strNormalize);
            case 7:
                return parsePickup(strNormalize);
            case 8:
                return new OcrTicketDraft(OcrTicketType.Unknown, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 131070, null);
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    private final String normalize(String rawText) {
        return SequencesKt.joinToString$default(SequencesKt.filter(SequencesKt.map(StringsKt.lineSequence(StringsKt.replace$default(rawText, Typography.nbsp, ' ', false, 4, (Object) null)), new Function1() { // from class: com.example.tickets.TicketOcrParser$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return TicketOcrParser.normalize$lambda$0((String) obj);
            }
        }), new Function1() { // from class: com.example.tickets.TicketOcrParser$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(TicketOcrParser.normalize$lambda$1((String) obj));
            }
        }), "\n", null, null, 0, null, null, 62, null);
    }

    static final String normalize$lambda$0(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return StringsKt.trim((CharSequence) it).toString();
    }

    static final boolean normalize$lambda$1(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return !StringsKt.isBlank(it);
    }

    private final OcrTicketType detectType(String text) {
        String lowerCase = text.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        List<String> listListOf = CollectionsKt.listOf((Object[]) new String[]{"boarding", "boarding pass", "gate", "flight", "departure", "arrival", "航空", "航班", "登机口", "登机牌"});
        List<String> listListOf2 = CollectionsKt.listOf((Object[]) new String[]{"车次", "火车", "铁路", "高铁", "动车", "轨道", "platform", "train", "途经"});
        List<String> listListOf3 = CollectionsKt.listOf((Object[]) new String[]{"影院", "影厅", "电影", "cinema", "movie", "auditorium", "screen"});
        List<String> listListOf4 = CollectionsKt.listOf((Object[]) new String[]{"演出", "演唱会", "音乐会", "剧场", "剧院", "concert", "theater", "theatre"});
        List<String> listListOf5 = CollectionsKt.listOf((Object[]) new String[]{"门票", "入场", "入口", "entry", "admission", "ticket"});
        List<String> listListOf6 = CollectionsKt.listOf((Object[]) new String[]{"取餐", "取餐码", "取餐号", "餐品", "pickup code", "pick up code", "order ready", "food pickup", "takeout", "外卖取餐"});
        List<String> listListOf7 = CollectionsKt.listOf((Object[]) new String[]{"取件", "取件码", "取货", "驿站", "快递柜", "快递", "包裹", "parcel", "package", "courier", "pickup point", "collect parcel"});
        if (containsAny(lowerCase, listListOf6)) {
            return OcrTicketType.Takeout;
        }
        if (containsAny(lowerCase, listListOf7)) {
            return OcrTicketType.Pickup;
        }
        if (containsAny(lowerCase, listListOf)) {
            return OcrTicketType.Airplane;
        }
        if (containsAny(lowerCase, listListOf3)) {
            return OcrTicketType.Movie;
        }
        if (containsAny(lowerCase, listListOf4)) {
            return OcrTicketType.Event;
        }
        if (containsAny(lowerCase, listListOf2)) {
            return OcrTicketType.Train;
        }
        if (containsAny(lowerCase, listListOf5)) {
            return OcrTicketType.Admission;
        }
        return OcrTicketType.Unknown;
    }

    private final boolean containsAny(String text, List<String> signals) {
        List<String> list = signals;
        if ((list instanceof Collection) && list.isEmpty()) {
            return false;
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            if (StringsKt.contains$default((CharSequence) text, (CharSequence) it.next(), false, 2, (Object) null)) {
                return true;
            }
        }
        return false;
    }

    private final OcrTicketDraft parseTrain(String text) {
        List<String> listLines = StringsKt.lines(text);
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listLines, 10));
        Iterator<T> it = listLines.iterator();
        while (it.hasNext()) {
            arrayList.add(StringsKt.trim((CharSequence) it.next()).toString());
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            if (!StringsKt.isBlank((String) obj)) {
                arrayList2.add(obj);
            }
        }
        Pair<String, String> pairFindTimeRange = findTimeRange(text);
        List<String> listFindTrainRouteStations = findTrainRouteStations(arrayList2);
        return new OcrTicketDraft(OcrTicketType.Train, findExplicitTrainNumber(text), findExplicitTrainNumber(text), null, findDate(text), pairFindTimeRange != null ? pairFindTimeRange.getFirst() : null, (String) CollectionsKt.firstOrNull((List) listFindTrainRouteStations), (String) CollectionsKt.lastOrNull((List) listFindTrainRouteStations), null, findExplicitSeat(text), null, null, null, pairFindTimeRange != null ? pairFindTimeRange.getFirst() : null, pairFindTimeRange != null ? pairFindTimeRange.getSecond() : null, null, null, 101640, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final List<String> findTrainRouteStations(List<String> lines) {
        TicketOcrParser ticketOcrParser;
        String strNormalizeStationCandidate;
        List<String> list = lines;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(INSTANCE.cleanOcrLine((String) it.next()));
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            if (!StringsKt.isBlank((String) obj)) {
                arrayList2.add(obj);
            }
        }
        ArrayList arrayList3 = arrayList2;
        ArrayList arrayList4 = new ArrayList();
        int i = 0;
        while (i < arrayList3.size()) {
            String str = arrayList3.get(i);
            String strExtractStationAfterTime = extractStationAfterTime(str);
            if (strExtractStationAfterTime != null) {
                arrayList4.add(strExtractStationAfterTime);
            } else if (isTimeOnlyLine(str)) {
                String str2 = (String) CollectionsKt.getOrNull(arrayList3, i + 1);
                String str3 = null;
                if (str2 != null && (strNormalizeStationCandidate = (ticketOcrParser = INSTANCE).normalizeStationCandidate(str2)) != null && ticketOcrParser.isLikelyStationName(strNormalizeStationCandidate)) {
                    str3 = strNormalizeStationCandidate;
                }
                if (str3 != null) {
                    arrayList4.add(str3);
                    i += 2;
                }
            }
            i++;
        }
        List<String> listDistinctStations = distinctStations(arrayList4);
        if (listDistinctStations.size() >= 2) {
            return CollectionsKt.listOf((Object[]) new String[]{CollectionsKt.first((List) listDistinctStations), CollectionsKt.last((List) listDistinctStations)});
        }
        ArrayList arrayList5 = arrayList3;
        ArrayList arrayList6 = new ArrayList();
        Iterator it2 = arrayList5.iterator();
        while (it2.hasNext()) {
            CollectionsKt.addAll(arrayList6, INSTANCE.splitTrainRouteLine((String) it2.next()));
        }
        ArrayList arrayList7 = arrayList6;
        ArrayList arrayList8 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList7, 10));
        Iterator it3 = arrayList7.iterator();
        while (it3.hasNext()) {
            arrayList8.add(INSTANCE.normalizeStationCandidate((String) it3.next()));
        }
        ArrayList arrayList9 = new ArrayList();
        for (Object obj2 : arrayList8) {
            if (INSTANCE.isLikelyStationName((String) obj2)) {
                arrayList9.add(obj2);
            }
        }
        List<String> listDistinctStations2 = distinctStations(arrayList9);
        if (listDistinctStations2.size() >= 2) {
            return CollectionsKt.listOf((Object[]) new String[]{CollectionsKt.first((List) listDistinctStations2), CollectionsKt.last((List) listDistinctStations2)});
        }
        String strFindExplicitDestination = findExplicitDestination(arrayList3);
        if (strFindExplicitDestination != null) {
            String strFindOriginNearDestination = findOriginNearDestination(arrayList3, strFindExplicitDestination);
            if (strFindOriginNearDestination != null && !StringsKt.equals(strFindOriginNearDestination, strFindExplicitDestination, true)) {
                return CollectionsKt.listOf((Object[]) new String[]{strFindOriginNearDestination, strFindExplicitDestination});
            }
            return CollectionsKt.listOf(strFindExplicitDestination);
        }
        ArrayList arrayList10 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList5, 10));
        Iterator it4 = arrayList5.iterator();
        while (it4.hasNext()) {
            arrayList10.add(INSTANCE.normalizeStationCandidate((String) it4.next()));
        }
        ArrayList arrayList11 = new ArrayList();
        for (Object obj3 : arrayList10) {
            if (INSTANCE.isLikelyStationName((String) obj3)) {
                arrayList11.add(obj3);
            }
        }
        ArrayList arrayList12 = new ArrayList();
        for (Object obj4 : arrayList11) {
            if (!INSTANCE.looksLikeNonRouteText((String) obj4)) {
                arrayList12.add(obj4);
            }
        }
        List<String> listDistinctStations3 = distinctStations(arrayList12);
        if (listDistinctStations3.size() >= 2) {
            return CollectionsKt.listOf((Object[]) new String[]{CollectionsKt.first((List) listDistinctStations3), CollectionsKt.last((List) listDistinctStations3)});
        }
        if (listDistinctStations3.size() == 1) {
            return CollectionsKt.listOf(CollectionsKt.first((List) listDistinctStations3));
        }
        return CollectionsKt.emptyList();
    }

    private final String cleanOcrLine(String value) {
        return StringsKt.trim((CharSequence) new Regex("\\s+").replace(new Regex("[|｜]").replace(StringsKt.replace$default(value, Typography.nbsp, ' ', false, 4, (Object) null), " "), " ")).toString();
    }

    private final String extractStationAfterTime(String line) {
        Iterator it = CollectionsKt.listOf((Object[]) new Regex[]{new Regex("^\\s*(\\d{1,2}:\\d{2})(?:\\s*[AP]M)?\\s+(.+?)\\s*$", RegexOption.IGNORE_CASE), new Regex("^\\s*(\\d{1,2}:\\d{2})\\s*[-–—]\\s*\\d{1,2}:\\d{2}\\s+(.+?)\\s*$", RegexOption.IGNORE_CASE)}).iterator();
        while (it.hasNext()) {
            MatchResult matchResultFind$default = Regex.find$default((Regex) it.next(), line, 0, 2, null);
            if (matchResultFind$default != null) {
                String strNormalizeStationCandidate = normalizeStationCandidate((String) CollectionsKt.last((List) matchResultFind$default.getGroupValues()));
                if (isLikelyStationName(strNormalizeStationCandidate)) {
                    return strNormalizeStationCandidate;
                }
            }
        }
        return null;
    }

    private final boolean isTimeOnlyLine(String line) {
        return new Regex("^\\s*\\d{1,2}:\\d{2}(?:\\s*[AP]M)?\\s*$", RegexOption.IGNORE_CASE).matches(line);
    }

    private final List<String> splitTrainRouteLine(String line) {
        String strReplace$default = StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(line, "→", ">", false, 4, (Object) null), "➜", ">", false, 4, (Object) null), "➝", ">", false, 4, (Object) null), "->", ">", false, 4, (Object) null), "—", ">", false, 4, (Object) null), "–", ">", false, 4, (Object) null), " 至 ", ">", false, 4, (Object) null), "前往", ">", false, 4, (Object) null), "开往", ">", false, 4, (Object) null), "驶往", ">", false, 4, (Object) null);
        if (Intrinsics.areEqual(strReplace$default, StringsKt.trim((CharSequence) line).toString())) {
            return CollectionsKt.emptyList();
        }
        List listSplit$default = StringsKt.split$default((CharSequence) strReplace$default, new char[]{Typography.greater}, false, 0, 6, (Object) null);
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listSplit$default, 10));
        Iterator it = listSplit$default.iterator();
        while (it.hasNext()) {
            arrayList.add(StringsKt.trim((CharSequence) it.next()).toString());
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            if (!StringsKt.isBlank((String) obj)) {
                arrayList2.add(obj);
            }
        }
        return arrayList2;
    }

    private final String normalizeStationCandidate(String raw) {
        return StringsKt.trim((CharSequence) new Regex("\\s+\\d{1,2}:\\d{2}\\s*$").replace(new Regex("\\s+(?:mins?|minutes?)\\s*$", RegexOption.IGNORE_CASE).replace(new Regex("^\\s*(?:轨道|站台|Track|Platform)\\s*\\d+\\s*", RegexOption.IGNORE_CASE).replace(new Regex("\\s*(?:轨道|站台|Track|Platform)\\s*\\d+\\s*$", RegexOption.IGNORE_CASE).replace(StringsKt.trim(StringsKt.trim((CharSequence) raw).toString(), ' ', ':', 65306, '-', Typography.ndash, Typography.mdash, Typography.greater, 8594, '.', ',', 65292, 12290), ""), ""), ""), "")).toString();
    }

    private final List<String> distinctStations(List<String> stations) {
        ArrayList arrayList = new ArrayList();
        for (String str : stations) {
            ArrayList arrayList2 = arrayList;
            if (!(arrayList2 instanceof Collection) || !arrayList2.isEmpty()) {
                Iterator it = arrayList2.iterator();
                do {
                    if (it.hasNext()) {
                    }
                } while (!StringsKt.equals((String) it.next(), str, true));
            }
            arrayList.add(str);
        }
        return arrayList;
    }

    private final boolean looksLikeNonRouteText(String value) {
        String lowerCase = value.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        List listListOf = CollectionsKt.listOf((Object[]) new String[]{"www.", "http://", "https://", "copyright", "customer service", "客服电话", "扫码", "订单", "order", "fare", "price", "价格", "费用", "total", "总计", "更多出发时间", "upcoming", "schedule", "departure time", "arrival time"});
        if ((listListOf instanceof Collection) && listListOf.isEmpty()) {
            return false;
        }
        Iterator it = listListOf.iterator();
        while (it.hasNext()) {
            if (StringsKt.contains$default((CharSequence) lowerCase, (CharSequence) it.next(), false, 2, (Object) null)) {
                return true;
            }
        }
        return false;
    }

    private final String findFirstTimedStation(List<String> lines) {
        return (String) CollectionsKt.firstOrNull((List) findTrainRouteStations(lines));
    }

    private final String findExplicitDestination(List<String> lines) {
        List listListOf = CollectionsKt.listOf((Object[]) new Regex[]{new Regex("(?:前往|开往|驶往|终点|到达)\\s*[:：]?\\s*(.+)$"), new Regex("^\\s*(?:to|toward|destination)\\s+(.+)$", RegexOption.IGNORE_CASE)});
        for (String str : lines) {
            Iterator it = listListOf.iterator();
            while (it.hasNext()) {
                MatchResult matchResultFind$default = Regex.find$default((Regex) it.next(), str, 0, 2, null);
                if (matchResultFind$default != null) {
                    String strNormalizeStationCandidate = normalizeStationCandidate(matchResultFind$default.getGroupValues().get(1));
                    if (isLikelyStationName(strNormalizeStationCandidate)) {
                        return strNormalizeStationCandidate;
                    }
                }
            }
        }
        return null;
    }

    private final boolean isLikelyStationName(String line) {
        String strNormalizeStationCandidate = normalizeStationCandidate(line);
        if (strNormalizeStationCandidate.length() >= 2 && strNormalizeStationCandidate.length() <= 50) {
            String lowerCase = strNormalizeStationCandidate.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            List listListOf = CollectionsKt.listOf((Object[]) new String[]{"车票", "火车票", "机票", "电影", "演出", "门票", "轨道", "track", "platform", "gate", "seat", "座位", "预计", "行程", "分钟", "minutes", "mins", "off peak", "peak", "前往", "开往", "驶往", "更多出发时间", "转乘", "换乘", "列车可能", "火车", "列车", "train", NotificationCompat.CATEGORY_SERVICE, "departure", "arrival", Constants.MessagePayloadKeys.FROM, "to", "站台"});
            if (!(listListOf instanceof Collection) || !listListOf.isEmpty()) {
                Iterator it = listListOf.iterator();
                while (it.hasNext()) {
                    if (StringsKt.contains$default((CharSequence) lowerCase, (CharSequence) it.next(), false, 2, (Object) null)) {
                        return false;
                    }
                }
            }
            if (looksLikeNonRouteText(strNormalizeStationCandidate)) {
                return false;
            }
            String str = strNormalizeStationCandidate;
            if (new Regex("\\d{1,2}:\\d{2}\\s*[-–—]\\s*\\d{1,2}:\\d{2}").containsMatchIn(str) || new Regex("^\\d{1,2}:\\d{2}(?:\\s*[AP]M)?$", RegexOption.IGNORE_CASE).matches(str) || new Regex("^\\d+$").matches(str) || new Regex("(?i).*[A-Z]{1,3}\\d{1,5}.*\\d{1,2}:\\d{2}.*").matches(str) || new Regex("(?i)^[A-Z]{1,3}\\d{1,5}$").matches(str)) {
                return false;
            }
            int i = 0;
            for (int i2 = 0; i2 < str.length(); i2++) {
                if (Character.isDigit(str.charAt(i2))) {
                    i++;
                }
            }
            if (i >= 4) {
                return false;
            }
            for (int i3 = 0; i3 < str.length(); i3++) {
                if (Character.isLetter(str.charAt(i3))) {
                    return true;
                }
            }
        }
        return false;
    }

    private final String findExplicitTrainNumber(String text) {
        Iterator it = CollectionsKt.listOf((Object[]) new Regex[]{new Regex("(?:车次|列车|train(?:\\s*number|\\s*no\\.?)?)\\s*[:：]?\\s*([A-Z]?\\d{1,5})", RegexOption.IGNORE_CASE), new Regex("(?:train|service)\\s+([A-Z]?\\d{1,5})", RegexOption.IGNORE_CASE)}).iterator();
        while (it.hasNext()) {
            MatchResult matchResultFind$default = Regex.find$default((Regex) it.next(), text, 0, 2, null);
            if (matchResultFind$default != null) {
                return matchResultFind$default.getGroupValues().get(1);
            }
        }
        return null;
    }

    private final String findExplicitSeat(String text) {
        Iterator it = CollectionsKt.listOf(new Regex("(?i)(?:seat|座位|座)\\s*[:：]?\\s*([A-Z]?\\d{1,4}[A-Z]?)")).iterator();
        while (it.hasNext()) {
            MatchResult matchResultFind$default = Regex.find$default((Regex) it.next(), text, 0, 2, null);
            if (matchResultFind$default != null) {
                return matchResultFind$default.getGroupValues().get(1);
            }
        }
        return null;
    }

    private final OcrTicketDraft parseAirplane(String text) {
        Pair<String, String> pairFindTimeRange = findTimeRange(text);
        String strFindFlightNumber = findFlightNumber(text);
        List<String> listFindRouteStations = findRouteStations(StringsKt.lines(text));
        return new OcrTicketDraft(OcrTicketType.Airplane, strFindFlightNumber, strFindFlightNumber, null, findDate(text), pairFindTimeRange != null ? pairFindTimeRange.getFirst() : null, (String) CollectionsKt.firstOrNull((List) listFindRouteStations), (String) CollectionsKt.lastOrNull((List) listFindRouteStations), null, findSeat(text), null, null, null, pairFindTimeRange != null ? pairFindTimeRange.getFirst() : null, pairFindTimeRange != null ? pairFindTimeRange.getSecond() : null, pairFindTimeRange != null ? pairFindTimeRange.getFirst() : null, pairFindTimeRange != null ? pairFindTimeRange.getSecond() : null, 7432, null);
    }

    private final OcrTicketDraft parseMovie(String text) {
        OcrTicketType ocrTicketType = OcrTicketType.Movie;
        String strFindLabeledValue = findLabeledValue(text, CollectionsKt.listOf((Object[]) new String[]{"电影", "影片", "movie"}));
        String strFindDate = findDate(text);
        Pair<String, String> pairFindTimeRange = findTimeRange(text);
        String first = pairFindTimeRange != null ? pairFindTimeRange.getFirst() : null;
        Pair<String, String> pairFindTimeRange2 = findTimeRange(text);
        String first2 = pairFindTimeRange2 != null ? pairFindTimeRange2.getFirst() : null;
        Pair<String, String> pairFindTimeRange3 = findTimeRange(text);
        return new OcrTicketDraft(ocrTicketType, strFindLabeledValue, null, null, strFindDate, first, null, null, findLabeledValue(text, CollectionsKt.listOf((Object[]) new String[]{"影厅", "hall", "auditorium"})), findSeat(text), null, null, findLabeledValue(text, CollectionsKt.listOf((Object[]) new String[]{"影院", "cinema"})), first2, pairFindTimeRange3 != null ? pairFindTimeRange3.getSecond() : null, null, null, 101580, null);
    }

    private final OcrTicketDraft parseEvent(String text) {
        OcrTicketType ocrTicketType = OcrTicketType.Event;
        String strFindLabeledValue = findLabeledValue(text, CollectionsKt.listOf((Object[]) new String[]{"演出", "活动", "concert"}));
        String strFindDate = findDate(text);
        Pair<String, String> pairFindTimeRange = findTimeRange(text);
        return new OcrTicketDraft(ocrTicketType, strFindLabeledValue, null, null, strFindDate, pairFindTimeRange != null ? pairFindTimeRange.getFirst() : null, null, null, null, findSeat(text), findLabeledValue(text, CollectionsKt.listOf((Object[]) new String[]{"区域", "section", "zone"})), null, findLabeledValue(text, CollectionsKt.listOf((Object[]) new String[]{"地点", "场馆", "剧场", "venue"})), null, null, null, null, 125388, null);
    }

    private final OcrTicketDraft parseTakeout(String text) {
        String strFindStandaloneTime;
        Pair<String, String> pairFindTimeRange = findTimeRange(text);
        if (pairFindTimeRange == null || (strFindStandaloneTime = pairFindTimeRange.getFirst()) == null) {
            strFindStandaloneTime = findStandaloneTime(text);
        }
        return new OcrTicketDraft(OcrTicketType.Takeout, findLabeledValue(text, CollectionsKt.listOf((Object[]) new String[]{"名称", "餐品", "商品", "菜品", "品名", "food", "item"})), findLabeledValue(text, CollectionsKt.listOf((Object[]) new String[]{"取餐码", "取餐号", "取货码", "pickup code", "pickup number"})), findLabeledValue(text, CollectionsKt.listOf((Object[]) new String[]{"品牌", "商家", "店名", "餐厅", "门店", "brand", "restaurant", "store"})), findDate(text), strFindStandaloneTime, null, null, null, null, null, null, findLabeledValue(text, CollectionsKt.listOf((Object[]) new String[]{"地点", "地址", "门店", "取餐点", "store", "location", "address"})), null, null, null, null, 126912, null);
    }

    private final OcrTicketDraft parsePickup(String text) {
        return new OcrTicketDraft(OcrTicketType.Pickup, findLabeledValue(text, CollectionsKt.listOf((Object[]) new String[]{"名称", "包裹", "商品", "货物", "品名", HintConstants.AUTOFILL_HINT_NAME, "package", "parcel"})), findLabeledValue(text, CollectionsKt.listOf((Object[]) new String[]{"取件码", "取货码", "取件号", "pickup code", "pickup number", "取件凭证"})), findLabeledValue(text, CollectionsKt.listOf((Object[]) new String[]{"品牌", "快递", "快递公司", "平台", "商家", "carrier", "courier", "brand", "store"})), findDate(text), null, null, null, null, null, null, null, findLabeledValue(text, CollectionsKt.listOf((Object[]) new String[]{"地点", "地址", "取件点", "门店", "驿站", "快递柜", "location", "address", "pickup point"})), null, null, null, null, 126944, null);
    }

    private final String findStandaloneTime(String text) {
        List<String> groupValues;
        MatchResult matchResultFind$default = Regex.find$default(new Regex("(?<!\\d)(\\d{1,2}:\\d{2})(?:\\s*[AP]M)?(?!\\d)", RegexOption.IGNORE_CASE), text, 0, 2, null);
        if (matchResultFind$default == null || (groupValues = matchResultFind$default.getGroupValues()) == null) {
            return null;
        }
        return (String) CollectionsKt.getOrNull(groupValues, 1);
    }

    private final OcrTicketDraft parseAdmission(String text) {
        OcrTicketType ocrTicketType = OcrTicketType.Admission;
        String strFindLabeledValue = findLabeledValue(text, CollectionsKt.listOf((Object[]) new String[]{"活动", "门票", "admission"}));
        String strFindDate = findDate(text);
        Pair<String, String> pairFindTimeRange = findTimeRange(text);
        return new OcrTicketDraft(ocrTicketType, strFindLabeledValue, null, null, strFindDate, pairFindTimeRange != null ? pairFindTimeRange.getFirst() : null, null, null, null, findSeat(text), null, findLabeledValue(text, CollectionsKt.listOf((Object[]) new String[]{"入口", "入场口", "entry"})), findLabeledValue(text, CollectionsKt.listOf((Object[]) new String[]{"地点", "场馆", "venue"})), null, null, null, null, 124364, null);
    }

    private final Pair<String, String> findTimeRange(String text) {
        List list = SequencesKt.toList(Regex.findAll$default(new Regex("(?<!\\d)(\\d{1,2}:\\d{2})(?:\\s*[-–—]\\s*)(\\d{1,2}:\\d{2})(?!\\d)"), text, 0, 2, null));
        if (list.isEmpty()) {
            return null;
        }
        MatchResult matchResult = (MatchResult) CollectionsKt.first(list);
        return new Pair<>(matchResult.getGroupValues().get(1), matchResult.getGroupValues().get(2));
    }

    private final String findDate(String text) {
        Iterator it = CollectionsKt.listOf((Object[]) new Regex[]{new Regex("(?<!\\d)(20\\d{2})[/-](\\d{1,2})[/-](\\d{1,2})(?!\\d)"), new Regex("(?<!\\d)(20\\d{2})年(\\d{1,2})月(\\d{1,2})日"), new Regex("(?<!\\d)(\\d{1,2})[/-](\\d{1,2})(?!\\d)")}).iterator();
        while (it.hasNext()) {
            MatchResult matchResultFind$default = Regex.find$default((Regex) it.next(), text, 0, 2, null);
            if (matchResultFind$default != null) {
                List<String> groupValues = matchResultFind$default.getGroupValues();
                if (groupValues.size() != 4) {
                    break;
                }
                if (groupValues.get(1).length() == 4) {
                    String str = String.format("%s/%02d/%02d", Arrays.copyOf(new Object[]{groupValues.get(1), Integer.valueOf(Integer.parseInt(groupValues.get(2))), Integer.valueOf(Integer.parseInt(groupValues.get(3)))}, 3));
                    Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                    return str;
                }
                String str2 = String.format("%02d/%02d", Arrays.copyOf(new Object[]{Integer.valueOf(Integer.parseInt(groupValues.get(1))), Integer.valueOf(Integer.parseInt(groupValues.get(2)))}, 2));
                Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
                return str2;
            }
        }
        return null;
    }

    private final String findSeat(String text) {
        Iterator it = CollectionsKt.listOf((Object[]) new Regex[]{new Regex("(?i)(?:seat|座位|座)\\s*[:：]?\\s*([A-Z]?\\d{1,4}[A-Z]?)"), new Regex("\\b([A-Z]?\\d{1,3}[A-Z])\\b")}).iterator();
        while (it.hasNext()) {
            MatchResult matchResultFind$default = Regex.find$default((Regex) it.next(), text, 0, 2, null);
            if (matchResultFind$default != null) {
                return matchResultFind$default.getGroupValues().get(1);
            }
        }
        return null;
    }

    private final String findTrainNumber(String text) {
        Iterator it = CollectionsKt.listOf((Object[]) new Regex[]{new Regex("(?<![A-Za-z0-9])([GCDKZT]\\d{1,5})(?![A-Za-z0-9])", RegexOption.IGNORE_CASE), new Regex("(?<![A-Za-z0-9])([A-Z]{1,3}\\d{2,5})(?![A-Za-z0-9])")}).iterator();
        while (it.hasNext()) {
            MatchResult matchResultFind$default = Regex.find$default((Regex) it.next(), text, 0, 2, null);
            if (matchResultFind$default != null) {
                return matchResultFind$default.getGroupValues().get(1);
            }
        }
        return null;
    }

    private final String findFlightNumber(String text) {
        Iterator it = CollectionsKt.listOf((Object[]) new Regex[]{new Regex("(?<![A-Za-z0-9])([A-Z]{2,3}\\d{2,4})(?![A-Za-z0-9])"), new Regex("(?i)(?:flight|航班)\\s*(?:no\\.?|number|号)?\\s*[:：]?\\s*([A-Z]{2,3}\\d{2,4})")}).iterator();
        while (it.hasNext()) {
            MatchResult matchResultFind$default = Regex.find$default((Regex) it.next(), text, 0, 2, null);
            if (matchResultFind$default != null) {
                return matchResultFind$default.getGroupValues().get(1);
            }
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:81:0x0240  */
    /* JADX WARN: Multi-variable type inference failed */
    private final List<String> findRouteStations(List<String> lines) {
        Object objCleanStationName;
        String strCleanStationName;
        List<String> list = lines;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(StringsKt.trim((CharSequence) it.next()).toString());
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            if (!StringsKt.isBlank((String) obj)) {
                arrayList2.add(obj);
            }
        }
        ArrayList arrayList3 = arrayList2;
        ArrayList arrayList4 = new ArrayList();
        Iterator it2 = arrayList3.iterator();
        while (true) {
            objCleanStationName = null;
            if (!it2.hasNext()) {
                break;
            }
            MatchResult matchResultFind$default = Regex.find$default(new Regex("^\\s*\\d{1,2}:\\d{2}\\s+(.+?)\\s*$"), (String) it2.next(), 0, 2, null);
            objCleanStationName = matchResultFind$default != null ? INSTANCE.cleanStationName(matchResultFind$default.getGroupValues().get(1)) : null;
            if (objCleanStationName != null) {
                arrayList4.add(objCleanStationName);
            }
        }
        ArrayList arrayList5 = new ArrayList();
        for (Object obj2 : arrayList4) {
            if (!StringsKt.isBlank((String) obj2)) {
                arrayList5.add(obj2);
            }
        }
        ArrayList arrayList6 = new ArrayList();
        for (Object obj3 : arrayList5) {
            if (INSTANCE.containsPossiblePlace((String) obj3)) {
                arrayList6.add(obj3);
            }
        }
        ArrayList arrayList7 = arrayList6;
        if (arrayList7.size() >= 2) {
            return CollectionsKt.listOf((Object[]) new String[]{CollectionsKt.first((List) arrayList7), CollectionsKt.last((List) arrayList7)});
        }
        ArrayList arrayList8 = new ArrayList();
        for (Object obj4 : arrayList3) {
            String str = (String) obj4;
            if (StringsKt.contains$default((CharSequence) str, (CharSequence) "→", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) str, (CharSequence) "->", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) str, (CharSequence) "至", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) str, (CharSequence) "前往", false, 2, (Object) null)) {
                arrayList8.add(obj4);
            }
        }
        ArrayList arrayList9 = new ArrayList();
        Iterator it3 = arrayList8.iterator();
        while (it3.hasNext()) {
            CollectionsKt.addAll(arrayList9, INSTANCE.splitRouteLine((String) it3.next()));
        }
        ArrayList arrayList10 = arrayList9;
        ArrayList arrayList11 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList10, 10));
        Iterator it4 = arrayList10.iterator();
        while (it4.hasNext()) {
            arrayList11.add(INSTANCE.cleanStationName((String) it4.next()));
        }
        ArrayList arrayList12 = new ArrayList();
        for (Object obj5 : arrayList11) {
            if (!StringsKt.isBlank((String) obj5)) {
                arrayList12.add(obj5);
            }
        }
        ArrayList arrayList13 = new ArrayList();
        for (Object obj6 : arrayList12) {
            if (INSTANCE.containsPossiblePlace((String) obj6)) {
                arrayList13.add(obj6);
            }
        }
        ArrayList arrayList14 = arrayList13;
        if (arrayList14.size() >= 2) {
            return CollectionsKt.listOf((Object[]) new String[]{CollectionsKt.first((List) arrayList14), CollectionsKt.last((List) arrayList14)});
        }
        Iterator it5 = arrayList3.iterator();
        do {
            if (!it5.hasNext()) {
                strCleanStationName = null;
                break;
            }
            String str2 = (String) it5.next();
            if (StringsKt.contains$default((CharSequence) str2, (CharSequence) "前往", false, 2, (Object) null)) {
                strCleanStationName = INSTANCE.cleanStationName(StringsKt.trim((CharSequence) StringsKt.substringAfter$default(str2, "前往", (String) null, 2, (Object) null)).toString());
                if (StringsKt.isBlank(strCleanStationName)) {
                    strCleanStationName = null;
                }
            } else {
                strCleanStationName = null;
            }
        } while (strCleanStationName == null);
        ArrayList arrayList15 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList3, 10));
        Iterator it6 = arrayList3.iterator();
        while (it6.hasNext()) {
            arrayList15.add(INSTANCE.cleanStationName((String) it6.next()));
        }
        ArrayList arrayList16 = new ArrayList();
        for (Object obj7 : arrayList15) {
            if (INSTANCE.containsPossiblePlace((String) obj7)) {
                arrayList16.add(obj7);
            }
        }
        ArrayList arrayList17 = arrayList16;
        if (strCleanStationName == null) {
            return CollectionsKt.take(arrayList17, 2);
        }
        for (Object obj8 : arrayList17) {
            if (!StringsKt.equals((String) obj8, strCleanStationName, true)) {
                objCleanStationName = obj8;
                break;
            }
        }
        String str3 = (String) objCleanStationName;
        if (str3 != null) {
            return CollectionsKt.listOf((Object[]) new String[]{str3, strCleanStationName});
        }
        return CollectionsKt.listOf(strCleanStationName);
    }

    private final String cleanStationName(final String raw) {
        return StringsKt.trim(new Regex("\\s*\\d+\\s*$").replace(new Regex("\\s*(?:轨道|Track|platform|站台)\\s*\\d+\\s*$").replace(raw, ""), new Function1() { // from class: com.example.tickets.TicketOcrParser$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return TicketOcrParser.cleanStationName$lambda$46(raw, (MatchResult) obj);
            }
        }), ' ', '-', Typography.ndash, Typography.mdash, Typography.greater);
    }

    static final CharSequence cleanStationName$lambda$46(String str, MatchResult match) {
        Intrinsics.checkNotNullParameter(match, "match");
        String str2 = str;
        if (StringsKt.contains((CharSequence) str2, (CharSequence) "轨道", true) || StringsKt.contains((CharSequence) str2, (CharSequence) "track", true) || StringsKt.contains((CharSequence) str2, (CharSequence) "platform", true) || StringsKt.contains((CharSequence) str2, (CharSequence) "站台", true)) {
            return "";
        }
        return match.getValue();
    }

    private final List<String> splitRouteLine(String line) {
        List listSplit$default = StringsKt.split$default((CharSequence) StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(line, "→", ">", false, 4, (Object) null), "->", ">", false, 4, (Object) null), "至", ">", false, 4, (Object) null), "前往", ">", false, 4, (Object) null), new char[]{Typography.greater}, false, 0, 6, (Object) null);
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listSplit$default, 10));
        Iterator it = listSplit$default.iterator();
        while (it.hasNext()) {
            arrayList.add(StringsKt.trim((CharSequence) it.next()).toString());
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            if (!StringsKt.isBlank((String) obj)) {
                arrayList2.add(obj);
            }
        }
        return arrayList2;
    }

    private final boolean containsPossiblePlace(String line) {
        if (line.length() < 2 || line.length() > 40) {
            return false;
        }
        String lowerCase = line.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        List listListOf = CollectionsKt.listOf((Object[]) new String[]{"轨道", "track", "platform", "gate", "seat", "车票", "机票", "电影", "时间", "预计", "行程", "minutes", "min"});
        if ((listListOf instanceof Collection) && listListOf.isEmpty()) {
            return true;
        }
        Iterator it = listListOf.iterator();
        while (it.hasNext()) {
            if (StringsKt.contains$default((CharSequence) lowerCase, (CharSequence) it.next(), false, 2, (Object) null)) {
                return false;
            }
        }
        return true;
    }

    private final String findLabeledValue(String text, List<String> labels) {
        List<String> listLines = StringsKt.lines(text);
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listLines, 10));
        Iterator<T> it = listLines.iterator();
        while (it.hasNext()) {
            arrayList.add(StringsKt.trim((CharSequence) it.next()).toString());
        }
        ArrayList<String> arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            if (!StringsKt.isBlank((String) obj)) {
                arrayList2.add(obj);
            }
        }
        for (String str : arrayList2) {
            for (String str2 : labels) {
                if (str.length() > str2.length()) {
                    String lowerCase = str.toLowerCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                    String lowerCase2 = str2.toLowerCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
                    int iIndexOf$default = StringsKt.indexOf$default((CharSequence) lowerCase, lowerCase2, 0, false, 6, (Object) null);
                    if (iIndexOf$default >= 0) {
                        String strSubstring = str.substring(iIndexOf$default + str2.length());
                        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                        String strTrim = StringsKt.trim(strSubstring, ' ', ':', 65306, '-');
                        if (!StringsKt.isBlank(strTrim)) {
                            return strTrim;
                        }
                    } else {
                        continue;
                    }
                }
            }
        }
        return null;
    }

    private final String findOriginNearDestination(List<String> lines, String destination) {
        Object next;
        Iterator<String> it = lines.iterator();
        int i = 0;
        while (true) {
            if (!it.hasNext()) {
                i = -1;
                break;
            }
            String next2 = it.next();
            if (StringsKt.contains((CharSequence) next2, (CharSequence) destination, true) || StringsKt.contains$default((CharSequence) next2, (CharSequence) "前往", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) next2, (CharSequence) "开往", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) next2, (CharSequence) "驶往", false, 2, (Object) null)) {
                break;
            }
            i++;
        }
        if (i < 0) {
            return null;
        }
        for (int i2 = i - 1; -1 < i2; i2--) {
            List<String> listSplitTrainRouteLine = splitTrainRouteLine(lines.get(i2));
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listSplitTrainRouteLine, 10));
            Iterator<T> it2 = listSplitTrainRouteLine.iterator();
            while (it2.hasNext()) {
                arrayList.add(INSTANCE.normalizeStationCandidate((String) it2.next()));
            }
            Iterator it3 = arrayList.iterator();
            while (true) {
                if (!it3.hasNext()) {
                    next = null;
                    break;
                }
                next = it3.next();
                String str = (String) next;
                if (INSTANCE.isLikelyStationName(str) && !StringsKt.equals(str, destination, true)) {
                    break;
                }
            }
            String str2 = (String) next;
            if (str2 != null) {
                return str2;
            }
            String strNormalizeStationCandidate = normalizeStationCandidate(lines.get(i2));
            if (isLikelyStationName(strNormalizeStationCandidate) && !StringsKt.equals(strNormalizeStationCandidate, destination, true)) {
                return strNormalizeStationCandidate;
            }
        }
        return null;
    }
}
