package com.example.tickets;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.KeyframesSpec;
import androidx.vectordrawable.graphics.drawable.PathInterpolatorCompat;
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

/* JADX INFO: compiled from: TicketTransferBeamEffect.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.example.tickets.TicketTransferBeamEffectKt$TicketTransferBeamEffect$2$1", f = "TicketTransferBeamEffect.kt", i = {}, l = {121, 123, 124}, m = "invokeSuspend", n = {}, s = {})
final class TicketTransferBeamEffectKt$TicketTransferBeamEffect$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ TicketBeamMode $mode;
    final /* synthetic */ Animatable<Float, AnimationVector1D> $spread;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    TicketTransferBeamEffectKt$TicketTransferBeamEffect$2$1(TicketBeamMode ticketBeamMode, Animatable<Float, AnimationVector1D> animatable, Continuation<? super TicketTransferBeamEffectKt$TicketTransferBeamEffect$2$1> continuation) {
        super(2, continuation);
        this.$mode = ticketBeamMode;
        this.$spread = animatable;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TicketTransferBeamEffectKt$TicketTransferBeamEffect$2$1(this.$mode, this.$spread, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((TicketTransferBeamEffectKt$TicketTransferBeamEffect$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x003e, code lost:
    
        if (r5.snapTo(kotlin.coroutines.jvm.internal.Boxing.boxFloat(0.0f), r11) == r0) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0076, code lost:
    
        if (androidx.compose.animation.core.Animatable.animateTo$default(r11.$spread, kotlin.coroutines.jvm.internal.Boxing.boxFloat(1.0f), androidx.compose.animation.core.AnimationSpecKt.keyframes(new com.example.tickets.TicketTransferBeamEffectKt$TicketTransferBeamEffect$2$1$$ExternalSyntheticLambda0()), null, null, r11, 12, null) == r0) goto L23;
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
            TicketBeamMode ticketBeamMode = this.$mode;
            TicketBeamMode ticketBeamMode2 = TicketBeamMode.NONE;
            Animatable<Float, AnimationVector1D> animatable = this.$spread;
            if (ticketBeamMode == ticketBeamMode2) {
                this.label = 1;
            } else {
                this.label = 2;
                if (animatable.snapTo(Boxing.boxFloat(0.0f), this) != coroutine_suspended) {
                    this.label = 3;
                }
            }
            return coroutine_suspended;
        }
        if (i == 1) {
            ResultKt.throwOnFailure(obj);
            Unit unit = Unit.INSTANCE;
        } else if (i == 2) {
            ResultKt.throwOnFailure(obj);
            this.label = 3;
        } else {
            if (i != 3) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }

    static final Unit invokeSuspend$lambda$0(KeyframesSpec.KeyframesSpecConfig keyframesSpecConfig) {
        keyframesSpecConfig.setDurationMillis(PathInterpolatorCompat.MAX_NUM_POINTS);
        keyframesSpecConfig.at(Float.valueOf(0.0f), 0);
        keyframesSpecConfig.at(Float.valueOf(0.1f), 220);
        keyframesSpecConfig.at(Float.valueOf(0.34f), 760);
        keyframesSpecConfig.using(keyframesSpecConfig.at(Float.valueOf(0.68f), 1500), EasingKt.getFastOutSlowInEasing());
        keyframesSpecConfig.at(Float.valueOf(0.9f), 2250);
        keyframesSpecConfig.using(keyframesSpecConfig.at(Float.valueOf(1.0f), keyframesSpecConfig.getDurationMillis()), EasingKt.getFastOutSlowInEasing());
        return Unit.INSTANCE;
    }
}
