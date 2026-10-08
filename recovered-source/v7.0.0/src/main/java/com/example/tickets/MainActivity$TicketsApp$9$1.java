package com.example.tickets;

import androidx.compose.runtime.MutableState;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: compiled from: MainActivity.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.example.tickets.MainActivity$TicketsApp$9$1", f = "MainActivity.kt", i = {0, 0}, l = {2361}, m = "invokeSuspend", n = {"normalizedTickets", "now"}, s = {"L$0", "J$0"})
final class MainActivity$TicketsApp$9$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableState<AppSettings> $appSettings$delegate;
    final /* synthetic */ MutableState<List<TicketData>> $tickets$delegate;
    long J$0;
    Object L$0;
    int label;
    final /* synthetic */ MainActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    MainActivity$TicketsApp$9$1(MainActivity mainActivity, MutableState<List<TicketData>> mutableState, MutableState<AppSettings> mutableState2, Continuation<? super MainActivity$TicketsApp$9$1> continuation) {
        super(2, continuation);
        this.this$0 = mainActivity;
        this.$tickets$delegate = mutableState;
        this.$appSettings$delegate = mutableState2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MainActivity$TicketsApp$9$1(this.this$0, this.$tickets$delegate, this.$appSettings$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((MainActivity$TicketsApp$9$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            long jCurrentTimeMillis = System.currentTimeMillis();
            List<TicketData> listTicketsApp$lambda$31 = MainActivity.TicketsApp$lambda$31(this.$tickets$delegate);
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listTicketsApp$lambda$31, 10));
            for (TicketData ticketDataCopy$default : listTicketsApp$lambda$31) {
                long jTicketArchiveEndTime = MainActivityKt.ticketArchiveEndTime(ticketDataCopy$default);
                if (!ticketDataCopy$default.getManuallyUsed() && !ticketDataCopy$default.getArchived() && jTicketArchiveEndTime != Long.MAX_VALUE && jCurrentTimeMillis >= jTicketArchiveEndTime) {
                    ticketDataCopy$default = TicketData.copy$default(ticketDataCopy$default, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, true, false, false, null, 1006632959, null);
                }
                arrayList.add(ticketDataCopy$default);
            }
            ArrayList arrayList2 = arrayList;
            if (!Intrinsics.areEqual(arrayList2, MainActivity.TicketsApp$lambda$31(this.$tickets$delegate))) {
                this.$tickets$delegate.setValue(arrayList2);
            }
            ArrayList arrayList3 = arrayList2;
            ArrayList<TicketData> arrayList4 = new ArrayList();
            for (Object obj2 : arrayList3) {
                TicketData ticketData = (TicketData) obj2;
                if (!ticketData.getArchived() && !ticketData.getManuallyUsed()) {
                    arrayList4.add(obj2);
                }
            }
            MainActivity mainActivity = this.this$0;
            MutableState<AppSettings> mutableState = this.$appSettings$delegate;
            for (TicketData ticketData2 : arrayList4) {
                long jTicketArchiveEndTime2 = MainActivityKt.ticketArchiveEndTime(ticketData2);
                if (jTicketArchiveEndTime2 == Long.MAX_VALUE || jCurrentTimeMillis < jTicketArchiveEndTime2 + 300000) {
                    MainActivityKt.showIntegrationTicketSafely(mainActivity, ticketData2, MainActivity.TicketsApp$lambda$48(mutableState).getIntegrationMode());
                }
            }
            MainActivity mainActivity2 = this.this$0;
            ArrayList arrayList5 = new ArrayList();
            for (Object obj3 : arrayList3) {
                long jTicketArchiveEndTime3 = MainActivityKt.ticketArchiveEndTime((TicketData) obj3);
                if (jTicketArchiveEndTime3 != Long.MAX_VALUE && jCurrentTimeMillis >= jTicketArchiveEndTime3 + 300000) {
                    arrayList5.add(obj3);
                }
            }
            MainActivityKt.cancelIntegrationNotifications(mainActivity2, arrayList5);
            this.L$0 = SpillingKt.nullOutSpilledVariable(arrayList2);
            this.J$0 = jCurrentTimeMillis;
            this.label = 1;
            if (DelayKt.delay(200L, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }
}
