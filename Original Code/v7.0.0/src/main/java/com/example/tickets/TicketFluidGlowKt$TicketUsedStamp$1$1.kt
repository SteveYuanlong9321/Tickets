package com.example.tickets;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.EasingKt;
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

/* JADX INFO: compiled from: TicketFluidGlow.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.example.tickets.TicketFluidGlowKt$TicketUsedStamp$1$1", f = "TicketFluidGlow.kt", i = {}, l = {211, 219}, m = "invokeSuspend", n = {}, s = {})
final class TicketFluidGlowKt$TicketUsedStamp$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Animatable<Float, AnimationVector1D> $stampAlpha;
    final /* synthetic */ Animatable<Float, AnimationVector1D> $stampScale;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    TicketFluidGlowKt$TicketUsedStamp$1$1(Animatable<Float, AnimationVector1D> animatable, Animatable<Float, AnimationVector1D> animatable2, Continuation<? super TicketFluidGlowKt$TicketUsedStamp$1$1> continuation) {
        super(2, continuation);
        this.$stampAlpha = animatable;
        this.$stampScale = animatable2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TicketFluidGlowKt$TicketUsedStamp$1$1(this.$stampAlpha, this.$stampScale, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((TicketFluidGlowKt$TicketUsedStamp$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x006a, code lost:
    
        if (androidx.compose.animation.core.Animatable.animateTo$default(r14.$stampScale, kotlin.coroutines.jvm.internal.Boxing.boxFloat(1.0f), androidx.compose.animation.core.AnimationSpecKt.spring$default(0.56f, 430.0f, null, 4, null), null, null, r14, 12, null) == r0) goto L15;
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
            this.label = 1;
            if (Animatable.animateTo$default(this.$stampAlpha, Boxing.boxFloat(1.0f), AnimationSpecKt.tween$default(120, 0, EasingKt.getFastOutSlowInEasing(), 2, null), null, null, this, 12, null) != coroutine_suspended) {
            }
            return coroutine_suspended;
        }
        if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
        this.label = 2;
    }
}
