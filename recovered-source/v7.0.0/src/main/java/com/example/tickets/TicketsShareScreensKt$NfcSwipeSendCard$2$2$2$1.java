package com.example.tickets;

import android.content.Context;
import androidx.compose.foundation.gestures.DragGestureDetectorKt;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.PointerInputScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: TicketsShareScreens.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final class TicketsShareScreensKt$NfcSwipeSendCard$2$2$2$1 implements PointerInputEventHandler {
    final /* synthetic */ Context $context;
    final /* synthetic */ MutableFloatState $dragY$delegate;
    final /* synthetic */ MutableFloatState $sendStartProgress$delegate;
    final /* synthetic */ MutableState<Boolean> $sending$delegate;

    TicketsShareScreensKt$NfcSwipeSendCard$2$2$2$1(MutableState<Boolean> mutableState, Context context, MutableFloatState mutableFloatState, MutableFloatState mutableFloatState2) {
        this.$sending$delegate = mutableState;
        this.$context = context;
        this.$dragY$delegate = mutableFloatState;
        this.$sendStartProgress$delegate = mutableFloatState2;
    }

    @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
    public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
        if (!TicketsShareScreensKt.NfcSwipeSendCard$lambda$162(this.$sending$delegate)) {
            final Context context = this.$context;
            final MutableFloatState mutableFloatState = this.$dragY$delegate;
            final MutableFloatState mutableFloatState2 = this.$sendStartProgress$delegate;
            final MutableState<Boolean> mutableState = this.$sending$delegate;
            Function0 function0 = new Function0() { // from class: com.example.tickets.TicketsShareScreensKt$NfcSwipeSendCard$2$2$2$1$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return TicketsShareScreensKt$NfcSwipeSendCard$2$2$2$1.invoke$lambda$0(context, mutableFloatState, mutableFloatState2, mutableState);
                }
            };
            final MutableFloatState mutableFloatState3 = this.$dragY$delegate;
            Object objDetectVerticalDragGestures$default = DragGestureDetectorKt.detectVerticalDragGestures$default(pointerInputScope, null, function0, null, new Function2() { // from class: com.example.tickets.TicketsShareScreensKt$NfcSwipeSendCard$2$2$2$1$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TicketsShareScreensKt$NfcSwipeSendCard$2$2$2$1.invoke$lambda$1(mutableFloatState3, (PointerInputChange) obj, ((Float) obj2).floatValue());
                }
            }, continuation, 5, null);
            return objDetectVerticalDragGestures$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objDetectVerticalDragGestures$default : Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }

    static final Unit invoke$lambda$1(MutableFloatState mutableFloatState, PointerInputChange pointerInputChange, float f) {
        Intrinsics.checkNotNullParameter(pointerInputChange, "<unused var>");
        mutableFloatState.setFloatValue(RangesKt.coerceIn(TicketsShareScreensKt.NfcSwipeSendCard$lambda$159(mutableFloatState) + f, -150.0f, 0.0f));
        return Unit.INSTANCE;
    }

    static final Unit invoke$lambda$0(Context context, MutableFloatState mutableFloatState, MutableFloatState mutableFloatState2, MutableState mutableState) {
        if (TicketsShareScreensKt.NfcSwipeSendCard$lambda$159(mutableFloatState) > -68.0f) {
            mutableFloatState.setFloatValue(0.0f);
        } else {
            mutableFloatState2.setFloatValue(RangesKt.coerceIn((-TicketsShareScreensKt.NfcSwipeSendCard$lambda$159(mutableFloatState)) / 150.0f, 0.0f, 1.0f));
            TicketsShareScreensKt.performNativeSendHaptic(context);
            TicketsShareScreensKt.NfcSwipeSendCard$lambda$163(mutableState, true);
        }
        return Unit.INSTANCE;
    }
}
