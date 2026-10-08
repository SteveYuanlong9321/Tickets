package com.example.tickets;

import androidx.compose.runtime.MutableState;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: MainActivity.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.example.tickets.MainActivity$TicketsApp$3$1", f = "MainActivity.kt", i = {0}, l = {2001}, m = "invokeSuspend", n = {"trip"}, s = {"L$0"})
final class MainActivity$TicketsApp$3$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableState<SmartSubwayTrip> $smartSubwayTrip$delegate;
    Object L$0;
    int label;
    final /* synthetic */ MainActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    MainActivity$TicketsApp$3$1(MainActivity mainActivity, MutableState<SmartSubwayTrip> mutableState, Continuation<? super MainActivity$TicketsApp$3$1> continuation) {
        super(2, continuation);
        this.this$0 = mainActivity;
        this.$smartSubwayTrip$delegate = mutableState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MainActivity$TicketsApp$3$1(this.this$0, this.$smartSubwayTrip$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((MainActivity$TicketsApp$3$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        SmartSubwayTrip smartSubwayTrip;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            SmartSubwayTrip smartSubwayTripTicketsApp$lambda$9 = MainActivity.TicketsApp$lambda$9(this.$smartSubwayTrip$delegate);
            if (smartSubwayTripTicketsApp$lambda$9 == null) {
                return Unit.INSTANCE;
            }
            this.L$0 = smartSubwayTripTicketsApp$lambda$9;
            this.label = 1;
            Object objNormalizeSmartSubwayRouteState = MainActivityKt.normalizeSmartSubwayRouteState(this.this$0, smartSubwayTripTicketsApp$lambda$9, this);
            if (objNormalizeSmartSubwayRouteState == coroutine_suspended) {
                return coroutine_suspended;
            }
            smartSubwayTrip = smartSubwayTripTicketsApp$lambda$9;
            obj = objNormalizeSmartSubwayRouteState;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            smartSubwayTrip = (SmartSubwayTrip) this.L$0;
            ResultKt.throwOnFailure(obj);
        }
        SmartSubwayTrip smartSubwayTrip2 = (SmartSubwayTrip) obj;
        if (!Intrinsics.areEqual(smartSubwayTrip2, smartSubwayTrip)) {
            this.$smartSubwayTrip$delegate.setValue(smartSubwayTrip2);
        }
        return Unit.INSTANCE;
    }
}
