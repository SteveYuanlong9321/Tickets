package com.example.tickets;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.runtime.MutableFloatState;
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
@DebugMetadata(c = "com.example.tickets.TicketsShareScreensKt$NfcSwipeSendCard$1$1", f = "TicketsShareScreens.kt", i = {}, l = {1322, 1323}, m = "invokeSuspend", n = {}, s = {})
final class TicketsShareScreensKt$NfcSwipeSendCard$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function0<Unit> $onSend;
    final /* synthetic */ Animatable<Float, AnimationVector1D> $sendProgress;
    final /* synthetic */ MutableFloatState $sendStartProgress$delegate;
    final /* synthetic */ MutableState<Boolean> $sending$delegate;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    TicketsShareScreensKt$NfcSwipeSendCard$1$1(Animatable<Float, AnimationVector1D> animatable, Function0<Unit> function0, MutableState<Boolean> mutableState, MutableFloatState mutableFloatState, Continuation<? super TicketsShareScreensKt$NfcSwipeSendCard$1$1> continuation) {
        super(2, continuation);
        this.$sendProgress = animatable;
        this.$onSend = function0;
        this.$sending$delegate = mutableState;
        this.$sendStartProgress$delegate = mutableFloatState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TicketsShareScreensKt$NfcSwipeSendCard$1$1(this.$sendProgress, this.$onSend, this.$sending$delegate, this.$sendStartProgress$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((TicketsShareScreensKt$NfcSwipeSendCard$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0066, code lost:
    
        if (androidx.compose.animation.core.Animatable.animateTo$default(r12.$sendProgress, kotlin.coroutines.jvm.internal.Boxing.boxFloat(1.0f), androidx.compose.animation.core.AnimationSpecKt.tween$default(640, 0, androidx.compose.animation.core.EasingKt.getFastOutSlowInEasing(), 2, null), null, null, r12, 12, null) == r0) goto L17;
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
            if (TicketsShareScreensKt.NfcSwipeSendCard$lambda$162(this.$sending$delegate)) {
                this.label = 1;
                if (this.$sendProgress.snapTo(Boxing.boxFloat(TicketsShareScreensKt.NfcSwipeSendCard$lambda$165(this.$sendStartProgress$delegate)), this) != coroutine_suspended) {
                }
                return coroutine_suspended;
            }
            return Unit.INSTANCE;
        }
        if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        this.$onSend.invoke();
        return Unit.INSTANCE;
        this.label = 2;
    }
}
