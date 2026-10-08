package com.example.tickets;

import androidx.compose.runtime.MutableState;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: MainActivity.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.example.tickets.MainActivity$TicketsApp$6$1", f = "MainActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class MainActivity$TicketsApp$6$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableState<Integer> $selectedTicketId$delegate;
    final /* synthetic */ MutableState<List<TicketData>> $tickets$delegate;
    int label;
    final /* synthetic */ MainActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    MainActivity$TicketsApp$6$1(MainActivity mainActivity, MutableState<List<TicketData>> mutableState, MutableState<Integer> mutableState2, Continuation<? super MainActivity$TicketsApp$6$1> continuation) {
        super(2, continuation);
        this.this$0 = mainActivity;
        this.$tickets$delegate = mutableState;
        this.$selectedTicketId$delegate = mutableState2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MainActivity$TicketsApp$6$1(this.this$0, this.$tickets$delegate, this.$selectedTicketId$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((MainActivity$TicketsApp$6$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            Integer pendingOpenTicketId = this.this$0.getPendingOpenTicketId();
            if (pendingOpenTicketId != null) {
                int iIntValue = pendingOpenTicketId.intValue();
                List listTicketsApp$lambda$31 = MainActivity.TicketsApp$lambda$31(this.$tickets$delegate);
                if (!(listTicketsApp$lambda$31 instanceof Collection) || !listTicketsApp$lambda$31.isEmpty()) {
                    Iterator it = listTicketsApp$lambda$31.iterator();
                    while (it.hasNext()) {
                        if (((TicketData) it.next()).getId() == iIntValue) {
                            this.$selectedTicketId$delegate.setValue(Boxing.boxInt(iIntValue));
                            this.this$0.setCurrentScreen(AppScreen.DETAIL);
                            this.this$0.setPendingOpenTicketId(null);
                            break;
                        }
                    }
                }
                return Unit.INSTANCE;
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
