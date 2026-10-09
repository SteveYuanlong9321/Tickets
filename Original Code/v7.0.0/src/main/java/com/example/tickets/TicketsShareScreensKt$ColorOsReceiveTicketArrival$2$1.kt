package com.example.tickets;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.runtime.MutableState;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: TicketsShareScreens.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.example.tickets.TicketsShareScreensKt$ColorOsReceiveTicketArrival$2$1", f = "TicketsShareScreens.kt", i = {}, l = {2111, 2112}, m = "invokeSuspend", n = {}, s = {})
final class TicketsShareScreensKt$ColorOsReceiveTicketArrival$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableState<Boolean> $accepted$delegate;
    final /* synthetic */ Animatable<Float, AnimationVector1D> $exit;
    final /* synthetic */ MutableState<Boolean> $exiting$delegate;
    final /* synthetic */ Function0<Unit> $onAccept;
    final /* synthetic */ Function0<Unit> $onReject;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    TicketsShareScreensKt$ColorOsReceiveTicketArrival$2$1(Animatable<Float, AnimationVector1D> animatable, Function0<Unit> function0, Function0<Unit> function1, MutableState<Boolean> mutableState, MutableState<Boolean> mutableState2, Continuation<? super TicketsShareScreensKt$ColorOsReceiveTicketArrival$2$1> continuation) {
        super(2, continuation);
        this.$exit = animatable;
        this.$onAccept = function0;
        this.$onReject = function1;
        this.$exiting$delegate = mutableState;
        this.$accepted$delegate = mutableState2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TicketsShareScreensKt$ColorOsReceiveTicketArrival$2$1(this.$exit, this.$onAccept, this.$onReject, this.$exiting$delegate, this.$accepted$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((TicketsShareScreensKt$ColorOsReceiveTicketArrival$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0064, code lost:
    
        if (androidx.compose.animation.core.Animatable.animateTo$default(r12.$exit, kotlin.coroutines.jvm.internal.Boxing.boxFloat(1.0f), androidx.compose.animation.core.AnimationSpecKt.tween$default(360, 0, androidx.compose.animation.core.EasingKt.getFastOutSlowInEasing(), 2, null), null, null, r12, 12, null) == r0) goto L19;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i != 0) {
            if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            (TicketsShareScreensKt.ColorOsReceiveTicketArrival$lambda$262(this.$accepted$delegate) ? this.$onAccept : this.$onReject).invoke();
            return Unit.INSTANCE;
        }
        ResultKt.throwOnFailure(obj);
        if (!TicketsShareScreensKt.ColorOsReceiveTicketArrival$lambda$259(this.$exiting$delegate)) {
            return Unit.INSTANCE;
        }
        this.label = 1;
        if (this.$exit.snapTo(Boxing.boxFloat(0.0f), this) != coroutine_suspended) {
        }
        return coroutine_suspended;
        this.label = 2;
    }
}
