package com.example.tickets;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.State;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: TicketsShareScreens.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.example.tickets.TicketsShareScreensKt$ColorOsSendTicketFlight$2$1", f = "TicketsShareScreens.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class TicketsShareScreensKt$ColorOsSendTicketFlight$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableState<Boolean> $completed$delegate;
    final /* synthetic */ State<Float> $launchPhase$delegate;
    final /* synthetic */ Function0<Unit> $onComplete;
    final /* synthetic */ MutableState<Boolean> $sending$delegate;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    TicketsShareScreensKt$ColorOsSendTicketFlight$2$1(Function0<Unit> function0, MutableState<Boolean> mutableState, MutableState<Boolean> mutableState2, State<Float> state, Continuation<? super TicketsShareScreensKt$ColorOsSendTicketFlight$2$1> continuation) {
        super(2, continuation);
        this.$onComplete = function0;
        this.$sending$delegate = mutableState;
        this.$completed$delegate = mutableState2;
        this.$launchPhase$delegate = state;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TicketsShareScreensKt$ColorOsSendTicketFlight$2$1(this.$onComplete, this.$sending$delegate, this.$completed$delegate, this.$launchPhase$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((TicketsShareScreensKt$ColorOsSendTicketFlight$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            if (TicketsShareScreensKt.ColorOsSendTicketFlight$lambda$234(this.$sending$delegate) && !TicketsShareScreensKt.ColorOsSendTicketFlight$lambda$240(this.$completed$delegate) && TicketsShareScreensKt.ColorOsSendTicketFlight$lambda$244(this.$launchPhase$delegate) >= 0.998f) {
                TicketsShareScreensKt.ColorOsSendTicketFlight$lambda$241(this.$completed$delegate, true);
                this.$onComplete.invoke();
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
