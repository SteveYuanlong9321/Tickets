package com.example.tickets;

import androidx.compose.runtime.MutableState;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: MainActivity.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.example.tickets.MainActivity$TicketsApp$5$1", f = "MainActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class MainActivity$TicketsApp$5$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableState<List<TicketData>> $tickets$delegate;
    int label;
    final /* synthetic */ MainActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    MainActivity$TicketsApp$5$1(MainActivity mainActivity, MutableState<List<TicketData>> mutableState, Continuation<? super MainActivity$TicketsApp$5$1> continuation) {
        super(2, continuation);
        this.this$0 = mainActivity;
        this.$tickets$delegate = mutableState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MainActivity$TicketsApp$5$1(this.this$0, this.$tickets$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((MainActivity$TicketsApp$5$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object next;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            Integer pendingMarkUsedTicketId = this.this$0.getPendingMarkUsedTicketId();
            if (pendingMarkUsedTicketId == null) {
                return Unit.INSTANCE;
            }
            int iIntValue = pendingMarkUsedTicketId.intValue();
            Iterator it = MainActivity.TicketsApp$lambda$31(this.$tickets$delegate).iterator();
            do {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
            } while (((TicketData) next).getId() != iIntValue);
            TicketData ticketData = (TicketData) next;
            if (ticketData != null && !ticketData.getManuallyUsed()) {
                MutableState<List<TicketData>> mutableState = this.$tickets$delegate;
                List<TicketData> listTicketsApp$lambda$31 = MainActivity.TicketsApp$lambda$31(mutableState);
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listTicketsApp$lambda$31, 10));
                for (TicketData ticketDataCopy$default : listTicketsApp$lambda$31) {
                    if (ticketDataCopy$default.getId() == iIntValue) {
                        ticketDataCopy$default = TicketData.copy$default(ticketDataCopy$default, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, true, false, false, null, 1006632959, null);
                    }
                    arrayList.add(ticketDataCopy$default);
                }
                mutableState.setValue(arrayList);
            }
            this.this$0.setPendingMarkUsedTicketId(null);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
