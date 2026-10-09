package com.example.tickets;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.foundation.gestures.DragGestureDetectorKt;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.PointerInputScope;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: GlassComponents.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final class GlassComponentsKt$GlassNavigationBar$3$6$1 implements PointerInputEventHandler {
    final /* synthetic */ Animatable<Float, AnimationVector1D> $bubblePosition;
    final /* synthetic */ MutableFloatState $dragDistance$delegate;
    final /* synthetic */ MutableState<Boolean> $isDragging$delegate;
    final /* synthetic */ float $leftPosition;
    final /* synthetic */ float $middlePosition;
    final /* synthetic */ Function1<Integer, Unit> $onSelectedTab;
    final /* synthetic */ float $rightPosition;
    final /* synthetic */ CoroutineScope $scope;
    final /* synthetic */ float $targetPosition;

    /* JADX WARN: Multi-variable type inference failed */
    GlassComponentsKt$GlassNavigationBar$3$6$1(MutableState<Boolean> mutableState, MutableFloatState mutableFloatState, float f, float f2, float f3, CoroutineScope coroutineScope, Animatable<Float, AnimationVector1D> animatable, Function1<? super Integer, Unit> function1, float f4) {
        this.$isDragging$delegate = mutableState;
        this.$dragDistance$delegate = mutableFloatState;
        this.$leftPosition = f;
        this.$middlePosition = f2;
        this.$rightPosition = f3;
        this.$scope = coroutineScope;
        this.$bubblePosition = animatable;
        this.$onSelectedTab = function1;
        this.$targetPosition = f4;
    }

    @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
    public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
        final MutableState<Boolean> mutableState = this.$isDragging$delegate;
        final MutableFloatState mutableFloatState = this.$dragDistance$delegate;
        Function1 function1 = new Function1() { // from class: com.example.tickets.GlassComponentsKt$GlassNavigationBar$3$6$1$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return GlassComponentsKt$GlassNavigationBar$3$6$1.invoke$lambda$0(mutableState, mutableFloatState, (Offset) obj);
            }
        };
        final float f = this.$leftPosition;
        final float f2 = this.$middlePosition;
        final float f3 = this.$rightPosition;
        final CoroutineScope coroutineScope = this.$scope;
        final Animatable<Float, AnimationVector1D> animatable = this.$bubblePosition;
        final Function1<Integer, Unit> function2 = this.$onSelectedTab;
        final MutableFloatState mutableFloatState2 = this.$dragDistance$delegate;
        final MutableState<Boolean> mutableState2 = this.$isDragging$delegate;
        Function0 function0 = new Function0() { // from class: com.example.tickets.GlassComponentsKt$GlassNavigationBar$3$6$1$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return GlassComponentsKt$GlassNavigationBar$3$6$1.invoke$lambda$2(f, f2, f3, coroutineScope, animatable, function2, mutableFloatState2, mutableState2);
            }
        };
        final CoroutineScope coroutineScope2 = this.$scope;
        final Animatable<Float, AnimationVector1D> animatable2 = this.$bubblePosition;
        final float f4 = this.$targetPosition;
        final MutableFloatState mutableFloatState3 = this.$dragDistance$delegate;
        final MutableState<Boolean> mutableState3 = this.$isDragging$delegate;
        Function0 function3 = new Function0() { // from class: com.example.tickets.GlassComponentsKt$GlassNavigationBar$3$6$1$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return GlassComponentsKt$GlassNavigationBar$3$6$1.invoke$lambda$3(coroutineScope2, animatable2, f4, mutableFloatState3, mutableState3);
            }
        };
        final Animatable<Float, AnimationVector1D> animatable3 = this.$bubblePosition;
        final float f5 = this.$leftPosition;
        final float f6 = this.$rightPosition;
        final CoroutineScope coroutineScope3 = this.$scope;
        final MutableFloatState mutableFloatState4 = this.$dragDistance$delegate;
        Object objDetectHorizontalDragGestures = DragGestureDetectorKt.detectHorizontalDragGestures(pointerInputScope, function1, function0, function3, new Function2() { // from class: com.example.tickets.GlassComponentsKt$GlassNavigationBar$3$6$1$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return GlassComponentsKt$GlassNavigationBar$3$6$1.invoke$lambda$4(animatable3, f5, f6, coroutineScope3, mutableFloatState4, (PointerInputChange) obj, ((Float) obj2).floatValue());
            }
        }, continuation);
        return objDetectHorizontalDragGestures == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objDetectHorizontalDragGestures : Unit.INSTANCE;
    }

    static final Unit invoke$lambda$0(MutableState mutableState, MutableFloatState mutableFloatState, Offset offset) {
        GlassComponentsKt.GlassNavigationBar$lambda$8(mutableState, true);
        mutableFloatState.setFloatValue(0.0f);
        return Unit.INSTANCE;
    }

    static final Unit invoke$lambda$4(Animatable animatable, float f, float f2, CoroutineScope coroutineScope, MutableFloatState mutableFloatState, PointerInputChange pointerInputChange, float f3) {
        Intrinsics.checkNotNullParameter(pointerInputChange, "<unused var>");
        mutableFloatState.setFloatValue(GlassComponentsKt.GlassNavigationBar$lambda$4(mutableFloatState) + f3);
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new GlassComponentsKt$GlassNavigationBar$3$6$1$4$1(animatable, RangesKt.coerceIn(((Number) animatable.getValue()).floatValue() + f3, f, f2), null), 3, null);
        return Unit.INSTANCE;
    }

    static final Unit invoke$lambda$2(float f, float f2, float f3, CoroutineScope coroutineScope, Animatable animatable, Function1 function1, MutableFloatState mutableFloatState, MutableState mutableState) {
        Integer num;
        List listListOf = CollectionsKt.listOf((Object[]) new Float[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3)});
        Iterator<Integer> it = CollectionsKt.getIndices(listListOf).iterator();
        if (it.hasNext()) {
            Integer next = it.next();
            if (it.hasNext()) {
                float fAbs = Math.abs(((Number) animatable.getValue()).floatValue() - ((Number) listListOf.get(next.intValue())).floatValue());
                do {
                    Integer next2 = it.next();
                    float fAbs2 = Math.abs(((Number) animatable.getValue()).floatValue() - ((Number) listListOf.get(next2.intValue())).floatValue());
                    if (Float.compare(fAbs, fAbs2) > 0) {
                        next = next2;
                        fAbs = fAbs2;
                    }
                } while (it.hasNext());
            }
            num = next;
        } else {
            num = null;
        }
        Integer num2 = num;
        int iIntValue = num2 != null ? num2.intValue() : 0;
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new GlassComponentsKt$GlassNavigationBar$3$6$1$2$1(animatable, ((Number) listListOf.get(iIntValue)).floatValue(), function1, iIntValue, mutableFloatState, mutableState, null), 3, null);
        return Unit.INSTANCE;
    }

    static final Unit invoke$lambda$3(CoroutineScope coroutineScope, Animatable animatable, float f, MutableFloatState mutableFloatState, MutableState mutableState) {
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new GlassComponentsKt$GlassNavigationBar$3$6$1$3$1(animatable, f, mutableFloatState, mutableState, null), 3, null);
        return Unit.INSTANCE;
    }
}
