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
final class TicketsShareScreensKt$ColorOsSendTicketFlight$3$2$1 implements PointerInputEventHandler {
    final /* synthetic */ Context $context;
    final /* synthetic */ MutableFloatState $dragY$delegate;
    final /* synthetic */ MutableState<Boolean> $dragging$delegate;
    final /* synthetic */ MutableState<Boolean> $sending$delegate;

    TicketsShareScreensKt$ColorOsSendTicketFlight$3$2$1(MutableState<Boolean> mutableState, Context context, MutableState<Boolean> mutableState2, MutableFloatState mutableFloatState) {
        this.$sending$delegate = mutableState;
        this.$context = context;
        this.$dragging$delegate = mutableState2;
        this.$dragY$delegate = mutableFloatState;
    }

    @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
    public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
        if (!TicketsShareScreensKt.ColorOsSendTicketFlight$lambda$234(this.$sending$delegate)) {
            final Context context = this.$context;
            final MutableState<Boolean> mutableState = this.$dragging$delegate;
            final MutableFloatState mutableFloatState = this.$dragY$delegate;
            final MutableState<Boolean> mutableState2 = this.$sending$delegate;
            Function0 function0 = new Function0() { // from class: com.example.tickets.TicketsShareScreensKt$ColorOsSendTicketFlight$3$2$1$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return TicketsShareScreensKt$ColorOsSendTicketFlight$3$2$1.invoke$lambda$0(context, mutableState, mutableFloatState, mutableState2);
                }
            };
            final MutableState<Boolean> mutableState3 = this.$dragging$delegate;
            final MutableFloatState mutableFloatState2 = this.$dragY$delegate;
            Function0 function1 = new Function0() { // from class: com.example.tickets.TicketsShareScreensKt$ColorOsSendTicketFlight$3$2$1$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return TicketsShareScreensKt$ColorOsSendTicketFlight$3$2$1.invoke$lambda$1(mutableState3, mutableFloatState2);
                }
            };
            final MutableState<Boolean> mutableState4 = this.$dragging$delegate;
            final MutableFloatState mutableFloatState3 = this.$dragY$delegate;
            Object objDetectVerticalDragGestures$default = DragGestureDetectorKt.detectVerticalDragGestures$default(pointerInputScope, null, function0, function1, new Function2() { // from class: com.example.tickets.TicketsShareScreensKt$ColorOsSendTicketFlight$3$2$1$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TicketsShareScreensKt$ColorOsSendTicketFlight$3$2$1.invoke$lambda$2(mutableState4, mutableFloatState3, (PointerInputChange) obj, ((Float) obj2).floatValue());
                }
            }, continuation, 1, null);
            return objDetectVerticalDragGestures$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objDetectVerticalDragGestures$default : Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }

    static final Unit invoke$lambda$2(MutableState mutableState, MutableFloatState mutableFloatState, PointerInputChange pointerInputChange, float f) {
        Intrinsics.checkNotNullParameter(pointerInputChange, "<unused var>");
        TicketsShareScreensKt.ColorOsSendTicketFlight$lambda$232(mutableState, true);
        mutableFloatState.setFloatValue(RangesKt.coerceIn(TicketsShareScreensKt.ColorOsSendTicketFlight$lambda$237(mutableFloatState) + f, -190.0f, 0.0f));
        return Unit.INSTANCE;
    }

    static final Unit invoke$lambda$0(Context context, MutableState mutableState, MutableFloatState mutableFloatState, MutableState mutableState2) {
        TicketsShareScreensKt.ColorOsSendTicketFlight$lambda$232(mutableState, false);
        if (TicketsShareScreensKt.ColorOsSendTicketFlight$lambda$237(mutableFloatState) <= -42.0f) {
            TicketsShareScreensKt.performNativeSendHaptic(context);
            TicketsShareScreensKt.ColorOsSendTicketFlight$lambda$235(mutableState2, true);
        } else {
            mutableFloatState.setFloatValue(0.0f);
        }
        return Unit.INSTANCE;
    }

    static final Unit invoke$lambda$1(MutableState mutableState, MutableFloatState mutableFloatState) {
        TicketsShareScreensKt.ColorOsSendTicketFlight$lambda$232(mutableState, false);
        mutableFloatState.setFloatValue(0.0f);
        return Unit.INSTANCE;
    }
}
