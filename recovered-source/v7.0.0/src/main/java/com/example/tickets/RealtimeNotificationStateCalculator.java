package com.example.tickets;

import com.google.firebase.messaging.Constants;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.ranges.RangesKt;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: RealtimeNotificationState.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000f\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tJ \u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\tH\u0002J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000bH\u0002J \u0010\u0011\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u000fH\u0002J(\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\tH\u0002J0\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\tH\u0002J(\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\tH\u0002J\u001f\u0010\u0016\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u000fH\u0002¢\u0006\u0002\u0010\u0019J\u000e\u0010\u001a\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\u001b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0007J\u0010\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\tH\u0002¨\u0006\u001e"}, d2 = {"Lcom/example/tickets/RealtimeNotificationStateCalculator;", "", "<init>", "()V", "calculate", "Lcom/example/tickets/RealtimeNotificationState;", "payload", "Lcom/example/tickets/LiveUpdatePayload;", "now", "", "calculateProgressPermille", "", "start", "end", "formatPercent", "", "progressPermille", "formatRemaining", Constants.ScionAnalytics.PARAM_LABEL, "trainStatusText", "airplaneStatusText", "movieStatusText", "parsePhaseDateTime", "date", "time", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Long;", "displayStartAt", "destroyAt", "formatClock", "millis", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class RealtimeNotificationStateCalculator {
    public static final int $stable = 0;
    public static final RealtimeNotificationStateCalculator INSTANCE = new RealtimeNotificationStateCalculator();

    private RealtimeNotificationStateCalculator() {
    }

    public static /* synthetic */ RealtimeNotificationState calculate$default(RealtimeNotificationStateCalculator realtimeNotificationStateCalculator, LiveUpdatePayload liveUpdatePayload, long j, int i, Object obj) {
        if ((i & 2) != 0) {
            j = System.currentTimeMillis();
        }
        return realtimeNotificationStateCalculator.calculate(liveUpdatePayload, j);
    }

    public final RealtimeNotificationState calculate(LiveUpdatePayload payload, long now) {
        RealtimeNotificationStatus realtimeNotificationStatus;
        String strTrainStatusText;
        String strAirplaneStatusText;
        String title;
        String str;
        Intrinsics.checkNotNullParameter(payload, "payload");
        Pair<Long, Long> pairResolveWindow = LiveUpdateManager.INSTANCE.resolveWindow(payload);
        long jLongValue = pairResolveWindow.getFirst().longValue();
        long jLongValue2 = pairResolveWindow.getSecond().longValue();
        int iCalculateProgressPermille = calculateProgressPermille(jLongValue, jLongValue2, now);
        int iCoerceIn = RangesKt.coerceIn(iCalculateProgressPermille / 10, 0, 100);
        if (jLongValue == Long.MAX_VALUE || now < jLongValue) {
            realtimeNotificationStatus = RealtimeNotificationStatus.UPCOMING;
        } else {
            realtimeNotificationStatus = RealtimeNotificationStatus.RUNNING;
        }
        RealtimeNotificationStatus realtimeNotificationStatus2 = realtimeNotificationStatus;
        String str2 = "火车票";
        String str3 = "车票";
        if (jLongValue == Long.MAX_VALUE) {
            strAirplaneStatusText = "时间待确认";
            str2 = "火车票";
            str3 = "车票";
            iCalculateProgressPermille = iCalculateProgressPermille;
        } else if (!Intrinsics.areEqual(payload.getTicketType(), "车票") && !Intrinsics.areEqual(payload.getTicketType(), "火车票")) {
            if (Intrinsics.areEqual(payload.getTicketType(), "机票")) {
                strAirplaneStatusText = airplaneStatusText(payload, jLongValue, jLongValue2, iCalculateProgressPermille, now);
                iCalculateProgressPermille = iCalculateProgressPermille;
                str2 = "火车票";
                str3 = "车票";
                jLongValue2 = jLongValue2;
                jLongValue = jLongValue;
            } else {
                iCalculateProgressPermille = iCalculateProgressPermille;
                if (Intrinsics.areEqual(payload.getTicketType(), "电影票")) {
                    str2 = "火车票";
                    str3 = "车票";
                    strTrainStatusText = movieStatusText(jLongValue, jLongValue2, iCalculateProgressPermille, now);
                } else {
                    str2 = "火车票";
                    str3 = "车票";
                    if (now >= jLongValue2) {
                        strTrainStatusText = "已结束";
                    } else {
                        strTrainStatusText = "进行中 · " + formatPercent(iCalculateProgressPermille);
                    }
                }
                strAirplaneStatusText = strTrainStatusText;
            }
        } else {
            strTrainStatusText = trainStatusText(jLongValue, jLongValue2, iCalculateProgressPermille, now);
            strAirplaneStatusText = strTrainStatusText;
        }
        if (Intrinsics.areEqual(payload.getTicketType(), str3) || Intrinsics.areEqual(payload.getTicketType(), str2) || Intrinsics.areEqual(payload.getTicketType(), "机票")) {
            String code = payload.getCode();
            if (StringsKt.isBlank(code)) {
                code = payload.getTitle();
            }
            title = code;
        } else {
            title = payload.getTitle();
        }
        String str4 = title;
        if (StringsKt.isBlank(str4)) {
            str4 = "票据";
        }
        String str5 = str4;
        if (!StringsKt.isBlank(payload.getFrom()) && !StringsKt.isBlank(payload.getTo())) {
            str = payload.getFrom() + " → " + payload.getTo();
        } else {
            str = "";
        }
        String str6 = str;
        String[] strArr = new String[3];
        strArr[0] = payload.getDate();
        String startTime = payload.getStartTime();
        if (StringsKt.isBlank(startTime)) {
            startTime = payload.getTime();
        }
        strArr[1] = startTime;
        strArr[2] = payload.getEndTime();
        List listListOf = CollectionsKt.listOf((Object[]) strArr);
        ArrayList arrayList = new ArrayList();
        for (Object obj : listListOf) {
            if (!StringsKt.isBlank((String) obj)) {
                arrayList.add(obj);
            }
        }
        return new RealtimeNotificationState(payload.getTicketId(), payload.getTicketType(), str5, payload.getCode(), payload.getDate(), jLongValue, jLongValue2, iCoerceIn, iCalculateProgressPermille, realtimeNotificationStatus2, strAirplaneStatusText, str6, CollectionsKt.joinToString$default(arrayList, "  ·  ", null, null, 0, null, null, 62, null), payload.getSeat());
    }

    private final int calculateProgressPermille(long start, long end, long now) {
        if (start == Long.MAX_VALUE) {
            return 0;
        }
        if (end <= start) {
            return 1000;
        }
        if (now <= start) {
            return 0;
        }
        if (now >= end) {
            return 1000;
        }
        return RangesKt.coerceIn((int) (((now - start) / (end - start)) * 1000.0d), 0, 1000);
    }

    private final String formatPercent(int progressPermille) {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format(Locale.getDefault(), "%.1f%%", Arrays.copyOf(new Object[]{Double.valueOf(((double) progressPermille) / 10.0d)}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        return str;
    }

    private final String formatRemaining(long end, long now, String label) {
        long jCoerceAtLeast = RangesKt.coerceAtLeast(end - now, 0L) / 60000;
        return label + (jCoerceAtLeast / 60) + "时" + (jCoerceAtLeast % 60) + "分钟";
    }

    private final String trainStatusText(long start, long end, int progressPermille, long now) {
        String percent = formatPercent(progressPermille);
        if (now < start - 1200000) {
            return "即将开始";
        }
        if (now < start) {
            return "即将发车";
        }
        if (now >= end) {
            return "已到达";
        }
        String remaining = formatRemaining(end, now, "行程剩余");
        if (now >= end - 300000) {
            return "即将到达 · " + percent + " · " + remaining;
        }
        return "行程中 · " + percent + " · " + remaining;
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0038  */
    private final String airplaneStatusText(LiveUpdatePayload payload, long start, long end, int progressPermille, long now) {
        long jLongValue;
        String percent = formatPercent(progressPermille);
        Long phaseDateTime = parsePhaseDateTime(payload.getDate(), payload.getTakeoffTime());
        Long phaseDateTime2 = parsePhaseDateTime(payload.getDate(), payload.getLandingTime());
        if (phaseDateTime != null) {
            start = phaseDateTime.longValue();
        }
        if (phaseDateTime2 == null) {
            jLongValue = end;
        } else {
            if (phaseDateTime2.longValue() <= start) {
                phaseDateTime2 = null;
            }
            if (phaseDateTime2 != null) {
                jLongValue = phaseDateTime2.longValue();
            } else {
                jLongValue = end;
            }
        }
        String remaining = formatRemaining(end, now, "行程剩余");
        if (now >= end) {
            return "已降落";
        }
        if (now >= start - 1200000 && now < start) {
            return "即将起飞 · " + percent;
        }
        if (now >= start && now < Math.min(start + 1200000, jLongValue)) {
            return "起飞 · " + percent + " · " + remaining;
        }
        if (now >= jLongValue - 600000) {
            return "降落 · " + percent + " · " + remaining;
        }
        if (now < start) {
            return "即将开始 · " + percent;
        }
        return "行程中 · " + percent + " · " + remaining;
    }

    private final String movieStatusText(long start, long end, int progressPermille, long now) {
        String percent = formatPercent(progressPermille);
        if (now < start) {
            return "即将开始";
        }
        String remaining = formatRemaining(end, now, "影片剩余");
        if (now >= end) {
            return "已结束";
        }
        if (now >= end - 600000) {
            return "接近尾声 · " + percent + " · " + remaining;
        }
        return "放映中 · " + percent + " · " + remaining;
    }

    private final Long parsePhaseDateTime(String date, String time) {
        List listListOf;
        String str = date;
        if (!StringsKt.isBlank(str)) {
            String str2 = time;
            if (!StringsKt.isBlank(str2)) {
                String strReplace$default = StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.trim((CharSequence) str).toString(), "年", "-", false, 4, (Object) null), "月", "-", false, 4, (Object) null), "日", "", false, 4, (Object) null), "/", "-", false, 4, (Object) null), ".", "-", false, 4, (Object) null);
                String strReplace = new Regex("\\s+").replace(new Regex("(?i)(\\d)\\s*(AM|PM)\\b").replace(StringsKt.replace(StringsKt.replace(StringsKt.replace(StringsKt.replace(StringsKt.replace$default(StringsKt.trim((CharSequence) str2).toString(), "：", ":", false, 4, (Object) null), "上午", "AM", true), "下午", "PM", true), "am", "AM", true), "pm", "PM", true), "$1 $2"), " ");
                if (new Regex("(?i).*\\b(?:AM|PM)\\b.*").matches(strReplace)) {
                    listListOf = CollectionsKt.listOf((Object[]) new String[]{"yyyy-MM-dd h:mm a", "yyyy-M-d h:mm a", "yyyy-MM-dd hh:mm a", "yyyy-M-d hh:mm a"});
                } else {
                    listListOf = CollectionsKt.listOf((Object[]) new String[]{"yyyy-MM-dd H:mm", "yyyy-M-d H:mm", "yyyy-MM-dd HH:mm", "yyyy-M-d HH:mm"});
                }
                Iterator it = listListOf.iterator();
                while (it.hasNext()) {
                    try {
                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat((String) it.next(), Locale.getDefault());
                        simpleDateFormat.setLenient(false);
                        Date date2 = simpleDateFormat.parse(strReplace$default + " " + strReplace);
                        if (date2 != null) {
                            return Long.valueOf(date2.getTime());
                        }
                        continue;
                    } catch (Exception unused) {
                    }
                }
            }
        }
        return null;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public final long displayStartAt(LiveUpdatePayload payload) {
        Intrinsics.checkNotNullParameter(payload, "payload");
        long jLongValue = LiveUpdateManager.INSTANCE.resolveWindow(payload).getFirst().longValue();
        if (jLongValue == Long.MAX_VALUE) {
            return Long.MAX_VALUE;
        }
        String ticketType = payload.getTicketType();
        switch (ticketType.hashCode()) {
            case 850286:
                if (!ticketType.equals("机票")) {
                    return jLongValue;
                }
                Long phaseDateTime = parsePhaseDateTime(payload.getDate(), payload.getTakeoffTime());
                if (phaseDateTime != null) {
                    jLongValue = phaseDateTime.longValue();
                }
                return jLongValue - 1200000;
            case 1169090:
                if (!ticketType.equals("车票")) {
                    return jLongValue;
                }
                break;
            case 28825709:
                if (!ticketType.equals("火车票")) {
                    return jLongValue;
                }
                break;
            case 29623308:
                if (!ticketType.equals("电影票")) {
                    return jLongValue;
                }
                break;
            default:
                return jLongValue;
        }
        return jLongValue - 1200000;
    }

    public final long destroyAt(LiveUpdatePayload payload) {
        Intrinsics.checkNotNullParameter(payload, "payload");
        long jLongValue = LiveUpdateManager.INSTANCE.resolveWindow(payload).getSecond().longValue();
        if (jLongValue == Long.MAX_VALUE) {
            return Long.MAX_VALUE;
        }
        String ticketType = payload.getTicketType();
        int iHashCode = ticketType.hashCode();
        return (iHashCode == 850286 ? ticketType.equals("机票") : iHashCode == 1169090 ? ticketType.equals("车票") : iHashCode == 28825709 && ticketType.equals("火车票")) ? jLongValue + 300000 : jLongValue;
    }

    private final String formatClock(long millis) {
        String str = new SimpleDateFormat("HH:mm", Locale.getDefault()).format(new Date(millis));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        return str;
    }
}
