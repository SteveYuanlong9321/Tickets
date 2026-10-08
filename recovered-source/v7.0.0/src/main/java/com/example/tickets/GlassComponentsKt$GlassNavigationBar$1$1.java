package com.example.tickets;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationSpecKt;
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
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: GlassComponents.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.example.tickets.GlassComponentsKt$GlassNavigationBar$1$1", f = "GlassComponents.kt", i = {}, l = {232}, m = "invokeSuspend", n = {}, s = {})
final class GlassComponentsKt$GlassNavigationBar$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Animatable<Float, AnimationVector1D> $bubblePosition;
    final /* synthetic */ MutableState<Boolean> $isDragging$delegate;
    final /* synthetic */ float $targetPosition;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    GlassComponentsKt$GlassNavigationBar$1$1(Animatable<Float, AnimationVector1D> animatable, float f, MutableState<Boolean> mutableState, Continuation<? super GlassComponentsKt$GlassNavigationBar$1$1> continuation) {
        super(2, continuation);
        this.$bubblePosition = animatable;
        this.$targetPosition = f;
        this.$isDragging$delegate = mutableState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new GlassComponentsKt$GlassNavigationBar$1$1(this.$bubblePosition, this.$targetPosition, this.$isDragging$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((GlassComponentsKt$GlassNavigationBar$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            if (!GlassComponentsKt.GlassNavigationBar$lambda$7(this.$isDragging$delegate)) {
                this.label = 1;
                if (Animatable.animateTo$default(this.$bubblePosition, Boxing.boxFloat(this.$targetPosition), AnimationSpecKt.spring$default(0.82f, 520.0f, null, 4, null), null, null, this, 12, null) == coroutine_suspended) {
                    return coroutine_suspended;
                }
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
