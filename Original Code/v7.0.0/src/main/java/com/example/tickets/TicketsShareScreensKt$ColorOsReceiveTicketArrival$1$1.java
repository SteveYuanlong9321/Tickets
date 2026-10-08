package com.example.tickets;

import androidx.compose.runtime.MutableFloatState;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: compiled from: TicketsShareScreens.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.example.tickets.TicketsShareScreensKt$ColorOsReceiveTicketArrival$1$1", f = "TicketsShareScreens.kt", i = {}, l = {2100, 2103, 2105}, m = "invokeSuspend", n = {}, s = {})
final class TicketsShareScreensKt$ColorOsReceiveTicketArrival$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableFloatState $entryTarget;
    final /* synthetic */ MutableFloatState $settleTarget;
    final /* synthetic */ List<TicketData> $tickets;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    TicketsShareScreensKt$ColorOsReceiveTicketArrival$1$1(List<TicketData> list, MutableFloatState mutableFloatState, MutableFloatState mutableFloatState2, Continuation<? super TicketsShareScreensKt$ColorOsReceiveTicketArrival$1$1> continuation) {
        super(2, continuation);
        this.$tickets = list;
        this.$entryTarget = mutableFloatState;
        this.$settleTarget = mutableFloatState2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TicketsShareScreensKt$ColorOsReceiveTicketArrival$1$1(this.$tickets, this.$entryTarget, this.$settleTarget, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((TicketsShareScreensKt$ColorOsReceiveTicketArrival$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0074, code lost:
    
        if (kotlinx.coroutines.DelayKt.delay(80, r7) == r0) goto L24;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            if (this.$tickets.isEmpty()) {
                return Unit.INSTANCE;
            }
            this.$entryTarget.setFloatValue(0.0f);
            this.$settleTarget.setFloatValue(0.0f);
            this.label = 1;
            if (DelayKt.delay(26L, this) != coroutine_suspended) {
            }
            return coroutine_suspended;
        }
        if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else if (i == 2) {
            ResultKt.throwOnFailure(obj);
            this.$entryTarget.setFloatValue(1.0f);
            this.label = 3;
        } else {
            if (i != 3) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        this.$settleTarget.setFloatValue(1.0f);
        return Unit.INSTANCE;
        this.$entryTarget.setFloatValue(0.72f);
        this.label = 2;
        if (DelayKt.delay(150L, this) != coroutine_suspended) {
            this.$entryTarget.setFloatValue(1.0f);
            this.label = 3;
        }
        return coroutine_suspended;
    }
}
