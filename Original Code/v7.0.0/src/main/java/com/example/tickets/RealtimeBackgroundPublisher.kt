package com.example.tickets;

import android.content.Context;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import org.json.JSONException;

/* JADX INFO: compiled from: RealtimeBackgroundPublisher.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002J \u0010\f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\tH\u0002¨\u0006\u0010"}, d2 = {"Lcom/example/tickets/RealtimeBackgroundPublisher;", "", "<init>", "()V", "refresh", "", "context", "Landroid/content/Context;", "realtimeTicketTypeName", "", ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "Lcom/example/tickets/TicketType;", "publishTicket", "ticket", "Lcom/example/tickets/TicketData;", "mode", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class RealtimeBackgroundPublisher {
    public static final int $stable = 0;
    public static final RealtimeBackgroundPublisher INSTANCE = new RealtimeBackgroundPublisher();

    /* JADX INFO: compiled from: RealtimeBackgroundPublisher.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[TicketType.values().length];
            try {
                iArr[TicketType.Movie.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[TicketType.Train.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[TicketType.Airplane.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[TicketType.Event.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[TicketType.Admission.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[TicketType.TakeoutCode.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[TicketType.PickupCode.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private RealtimeBackgroundPublisher() {
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0053  */
    public final void refresh(final Context context) throws JSONException {
        Intrinsics.checkNotNullParameter(context, "context");
        RealtimeTicketLifecycle.ReconcileResult reconcileResultReconcile = RealtimeTicketLifecycle.INSTANCE.reconcile(context, System.currentTimeMillis());
        RealtimeTicketLifecycle.INSTANCE.cancelExpiredRealtimeNotifications(context, reconcileResultReconcile.getDestroyTicketIds());
        String str = "Live Update";
        String string = StringsKt.trim((CharSequence) OnlineRecognitionStore.INSTANCE.loadString$app(context, "integration_mode", "Live Update")).toString();
        switch (string.hashCode()) {
            case -309140867:
                string.equals("Live Update");
                break;
            case 23379839:
                if (string.equals("实时窗")) {
                    str = "实时窗";
                }
                break;
            case 35844889:
                if (string.equals("超级岛")) {
                    str = "超级岛";
                }
                break;
            case 232937119:
                if (string.equals("三星 Now Bar")) {
                    str = "实时窗";
                }
                break;
        }
        RealtimeNotificationVisibilityController.INSTANCE.setAppForeground(false);
        Iterator<T> it = RealtimeTicketLifecycle.INSTANCE.loadActiveTickets$app(context).iterator();
        while (it.hasNext()) {
            INSTANCE.publishTicket(context, (TicketData) it.next(), str);
        }
        if (reconcileResultReconcile.getAutoUsedTicketIds().isEmpty()) {
            return;
        }
        Iterator it2 = SequencesKt.mapNotNull(CollectionsKt.asSequence(reconcileResultReconcile.getAutoUsedTicketIds()), new Function1() { // from class: com.example.tickets.RealtimeBackgroundPublisher$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return RealtimeTicketLifecycle.INSTANCE.loadTicketIncludingUsed$app(context, ((Integer) obj).intValue());
            }
        }).iterator();
        while (it2.hasNext()) {
            INSTANCE.publishTicket(context, TicketData.copy$default((TicketData) it2.next(), 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, false, false, null, 1006632959, null), str);
        }
    }

    private final String realtimeTicketTypeName(TicketType type) {
        switch (WhenMappings.$EnumSwitchMapping$0[type.ordinal()]) {
            case 1:
                return "电影票";
            case 2:
                return "车票";
            case 3:
                return "机票";
            case 4:
                return "演出";
            case 5:
                return "门票";
            case 6:
                return "取餐码";
            case 7:
                return "取件码";
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    private static final void publishTicket$fallback(Context context, TicketData ticketData) {
        try {
            Result.Companion companion = Result.INSTANCE;
            RealtimeOngoingNotificationManager.INSTANCE.showTicket$app(context, ticketData);
            Result.m9536constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m9536constructorimpl(ResultKt.createFailure(th));
        }
    }

    private final void publishTicket(Context context, TicketData ticket, String mode) {
        Object objM9536constructorimpl;
        Object objM9536constructorimpl2;
        Object objM9536constructorimpl3;
        if (Intrinsics.areEqual(mode, "超级岛")) {
            try {
                Result.Companion companion = Result.INSTANCE;
                RealtimeBackgroundPublisher realtimeBackgroundPublisher = this;
                XiaomiSuperIslandManager.INSTANCE.showTicket$app(context, ticket);
                objM9536constructorimpl = Result.m9536constructorimpl(Unit.INSTANCE);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objM9536constructorimpl = Result.m9536constructorimpl(ResultKt.createFailure(th));
            }
            if (Result.m9539exceptionOrNullimpl(objM9536constructorimpl) != null) {
                publishTicket$fallback(context, ticket);
                return;
            }
            return;
        }
        if (Intrinsics.areEqual(mode, "实时窗")) {
            try {
                Result.Companion companion3 = Result.INSTANCE;
                RealtimeBackgroundPublisher realtimeBackgroundPublisher2 = this;
                SamsungNowBarManager.INSTANCE.showTicket$app(context, ticket);
                objM9536constructorimpl2 = Result.m9536constructorimpl(Unit.INSTANCE);
            } catch (Throwable th2) {
                Result.Companion companion4 = Result.INSTANCE;
                objM9536constructorimpl2 = Result.m9536constructorimpl(ResultKt.createFailure(th2));
            }
            if (Result.m9539exceptionOrNullimpl(objM9536constructorimpl2) != null) {
                publishTicket$fallback(context, ticket);
                return;
            }
            return;
        }
        try {
            Result.Companion companion5 = Result.INSTANCE;
            RealtimeBackgroundPublisher realtimeBackgroundPublisher3 = this;
            LiveUpdateManager liveUpdateManager = LiveUpdateManager.INSTANCE;
            int id = ticket.getId();
            String strRealtimeTicketTypeName = realtimeTicketTypeName(ticket.getType());
            String title = ticket.getTitle();
            String code = ticket.getCode();
            String date = ticket.getDate();
            String time = ticket.getTime();
            String departureDate = ticket.getDepartureDate();
            String arrivalDate = ticket.getArrivalDate();
            liveUpdateManager.showTicketLiveUpdate(context, id, strRealtimeTicketTypeName, title, code, date, time, (196992 & 128) != 0 ? "" : departureDate, (196992 & 256) != 0 ? "" : arrivalDate, ticket.getFrom(), ticket.getTo(), (196992 & 2048) != 0 ? "" : ticket.getDeparturePlatform(), (196992 & 4096) != 0 ? "" : ticket.getArrivalPlatform(), ticket.getHall(), ticket.getSeat(), ticket.getVenue(), (65536 & 196992) != 0 ? "" : null, (131072 & 196992) != 0 ? "" : null, (262144 & 196992) != 0 ? "" : ticket.getStartTime(), (524288 & 196992) != 0 ? "" : ticket.getEndTime(), (1048576 & 196992) != 0 ? "" : ticket.getTakeoffTime(), (2097152 & 196992) != 0 ? "" : ticket.getLandingTime(), (196992 & 4194304) != 0 ? "" : ticket.getBrand());
            objM9536constructorimpl3 = Result.m9536constructorimpl(Unit.INSTANCE);
        } catch (Throwable th3) {
            Result.Companion companion6 = Result.INSTANCE;
            objM9536constructorimpl3 = Result.m9536constructorimpl(ResultKt.createFailure(th3));
        }
        if (Result.m9539exceptionOrNullimpl(objM9536constructorimpl3) != null) {
            publishTicket$fallback(context, ticket);
        }
    }
}
