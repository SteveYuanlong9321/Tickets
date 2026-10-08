package com.example.tickets;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import androidx.compose.runtime.composer.linkbuffer.GroupFlagsKt;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.coroutines.TimeoutKt;

/* JADX INFO: compiled from: SmartSubwayManualAdvance.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012J \u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0014H\u0086@¢\u0006\u0002\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u00020\fX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/example/tickets/SmartSubwayManualAdvance;", "", "<init>", "()V", "ACTION", "", "ACTION_UPDATED", "REQUEST_CODE", "", "ROUTE_RESOLVE_TIMEOUT_MS", "", "advancing", "Ljava/util/concurrent/atomic/AtomicBoolean;", "getAdvancing$app", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "createPendingIntent", "Landroid/app/PendingIntent;", "context", "Landroid/content/Context;", "advance", "Lcom/example/tickets/SmartSubwayTrip;", "trip", "(Landroid/content/Context;Lcom/example/tickets/SmartSubwayTrip;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "normalize", "value", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class SmartSubwayManualAdvance {
    public static final String ACTION = "com.example.tickets.SMART_SUBWAY_MANUAL_ADVANCE";
    public static final String ACTION_UPDATED = "com.example.tickets.SMART_SUBWAY_MANUAL_ADVANCE_UPDATED";
    private static final int REQUEST_CODE = 88771;
    private static final long ROUTE_RESOLVE_TIMEOUT_MS = 900;
    public static final SmartSubwayManualAdvance INSTANCE = new SmartSubwayManualAdvance();
    private static final AtomicBoolean advancing = new AtomicBoolean(false);
    public static final int $stable = 8;

    /* JADX INFO: renamed from: com.example.tickets.SmartSubwayManualAdvance$advance$1, reason: invalid class name */
    /* JADX INFO: compiled from: SmartSubwayManualAdvance.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.tickets.SmartSubwayManualAdvance", f = "SmartSubwayManualAdvance.kt", i = {0, 0, 0, 0}, l = {65}, m = "advance", n = {"context", "trip", "currentName", "nextName"}, s = {"L$0", "L$1", "L$2", "L$3"})
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SmartSubwayManualAdvance.this.advance(null, null, this);
        }
    }

    private SmartSubwayManualAdvance() {
    }

    public final AtomicBoolean getAdvancing$app() {
        return advancing;
    }

    public final PendingIntent createPendingIntent(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intent intent = new Intent(context, (Class<?>) SmartSubwayManualAdvanceReceiver.class);
        intent.setAction(ACTION);
        intent.addFlags(GroupFlagsKt.IsMovableContentFlag);
        PendingIntent broadcast = PendingIntent.getBroadcast(context, REQUEST_CODE, intent, 201326592);
        Intrinsics.checkNotNullExpressionValue(broadcast, "getBroadcast(...)");
        return broadcast;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    public final Object advance(Context context, SmartSubwayTrip smartSubwayTrip, Continuation<? super SmartSubwayTrip> continuation) {
        AnonymousClass1 anonymousClass1;
        SmartSubwayTrip smartSubwayTrip2;
        String str;
        String str2;
        int i;
        int i2;
        String lineName;
        String destination;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuation);
        }
        Object obj = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = anonymousClass1.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            if (smartSubwayTrip.isDestination()) {
                return null;
            }
            String string = StringsKt.trim((CharSequence) smartSubwayTrip.getCurrentStation()).toString();
            String string2 = StringsKt.trim((CharSequence) smartSubwayTrip.getNextStation()).toString();
            if (StringsKt.isBlank(string2) || StringsKt.equals(string2, string, true)) {
                return null;
            }
            SmartSubwayManualAdvance$advance$plan$1 smartSubwayManualAdvance$advance$plan$1 = new SmartSubwayManualAdvance$advance$plan$1(context, smartSubwayTrip, null);
            anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(context);
            anonymousClass1.L$1 = smartSubwayTrip;
            anonymousClass1.L$2 = string;
            anonymousClass1.L$3 = string2;
            anonymousClass1.label = 1;
            Object objWithTimeoutOrNull = TimeoutKt.withTimeoutOrNull(ROUTE_RESOLVE_TIMEOUT_MS, smartSubwayManualAdvance$advance$plan$1, anonymousClass1);
            if (objWithTimeoutOrNull == coroutine_suspended) {
                return coroutine_suspended;
            }
            smartSubwayTrip2 = smartSubwayTrip;
            str = string;
            obj = objWithTimeoutOrNull;
            str2 = string2;
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            String str3 = (String) anonymousClass1.L$3;
            str = (String) anonymousClass1.L$2;
            SmartSubwayTrip smartSubwayTrip3 = (SmartSubwayTrip) anonymousClass1.L$1;
            ResultKt.throwOnFailure(obj);
            str2 = str3;
            smartSubwayTrip2 = smartSubwayTrip3;
        }
        GlobalSubwayDataManager.SubwayRoutePlan subwayRoutePlan = (GlobalSubwayDataManager.SubwayRoutePlan) obj;
        List<GlobalSubwayDataManager.SubwayRouteStation> stations = subwayRoutePlan != null ? subwayRoutePlan.getStations() : null;
        if (stations == null) {
            stations = CollectionsKt.emptyList();
        }
        Iterator<GlobalSubwayDataManager.SubwayRouteStation> it = stations.iterator();
        int i4 = 0;
        while (true) {
            i = -1;
            if (!it.hasNext()) {
                i4 = -1;
                break;
            }
            GlobalSubwayDataManager.SubwayRouteStation next = it.next();
            SmartSubwayManualAdvance smartSubwayManualAdvance = INSTANCE;
            if (Intrinsics.areEqual(smartSubwayManualAdvance.normalize(next.getName()), smartSubwayManualAdvance.normalize(str))) {
                break;
            }
            i4++;
        }
        if (i4 >= 0 && (i2 = i4 + 1) < stations.size()) {
            GlobalSubwayDataManager.SubwayRouteStation subwayRouteStation = stations.get(i2);
            GlobalSubwayDataManager.SubwayRouteStation subwayRouteStation2 = (GlobalSubwayDataManager.SubwayRouteStation) CollectionsKt.getOrNull(stations, i4 + 2);
            boolean z = Intrinsics.areEqual(normalize(subwayRouteStation.getName()), normalize(smartSubwayTrip2.getDestination())) || StringsKt.equals(subwayRouteStation.getName(), smartSubwayTrip2.getDestination(), true) || i2 >= CollectionsKt.getLastIndex(stations);
            int i5 = 0;
            for (GlobalSubwayDataManager.SubwayRouteStation subwayRouteStation3 : stations) {
                if (!StringsKt.isBlank(smartSubwayTrip2.getTransferStation())) {
                    SmartSubwayManualAdvance smartSubwayManualAdvance2 = INSTANCE;
                    if (Intrinsics.areEqual(smartSubwayManualAdvance2.normalize(subwayRouteStation3.getName()), smartSubwayManualAdvance2.normalize(smartSubwayTrip2.getTransferStation()))) {
                        i = i5;
                        break;
                    }
                }
                i5++;
            }
            boolean z2 = i >= 0 && i2 > i;
            if (z2 && !StringsKt.isBlank(smartSubwayTrip2.getTransferLineName())) {
                lineName = smartSubwayTrip2.getTransferLineName();
            } else {
                lineName = smartSubwayTrip2.getLineName();
            }
            String str4 = lineName;
            long jM9313getSecondaryLineColor0d7_KjU = z2 ? smartSubwayTrip2.m9313getSecondaryLineColor0d7_KjU() : smartSubwayTrip2.m9312getPrimaryLineColor0d7_KjU();
            String name = subwayRouteStation.getName();
            if (z) {
                destination = subwayRouteStation.getName();
            } else if (subwayRouteStation2 == null || (destination = subwayRouteStation2.getName()) == null) {
                destination = smartSubwayTrip2.getDestination();
            }
            return SmartSubwayTrip.m9308copydOtcBKo$default(smartSubwayTrip2, null, null, System.currentTimeMillis(), null, null, name, destination, str4, smartSubwayTrip2.isTransferRequired() && !z2, z, jM9313getSecondaryLineColor0d7_KjU, 0L, null, str, 0.0f, null, null, 104475, null);
        }
        String str5 = str;
        boolean zEquals = StringsKt.equals(str2, StringsKt.trim((CharSequence) smartSubwayTrip2.getDestination()).toString(), true);
        return SmartSubwayTrip.m9308copydOtcBKo$default(smartSubwayTrip2, null, null, System.currentTimeMillis(), null, null, str2, zEquals ? str2 : smartSubwayTrip2.getDestination(), null, false, zEquals, 0L, 0L, null, str5, 0.0f, null, null, 105883, null);
    }

    private final String normalize(String value) {
        String strReplace = new Regex("\\s+").replace(StringsKt.trim((CharSequence) value).toString(), "");
        Locale ROOT = Locale.ROOT;
        Intrinsics.checkNotNullExpressionValue(ROOT, "ROOT");
        String lowerCase = strReplace.toLowerCase(ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        return lowerCase;
    }
}
