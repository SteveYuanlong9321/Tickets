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
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: MainActivity.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.example.tickets.MainActivity$TicketsApp$2$1$1$1", f = "MainActivity.kt", i = {}, l = {1978}, m = "invokeSuspend", n = {}, s = {})
final class MainActivity$TicketsApp$2$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $sessionId;
    final /* synthetic */ MutableState<SmartSubwayTrip> $smartSubwayTrip$delegate;
    final /* synthetic */ SmartSubwayTrip $updated;
    int label;
    final /* synthetic */ MainActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    MainActivity$TicketsApp$2$1$1$1(long j, MainActivity mainActivity, SmartSubwayTrip smartSubwayTrip, MutableState<SmartSubwayTrip> mutableState, Continuation<? super MainActivity$TicketsApp$2$1$1$1> continuation) {
        super(2, continuation);
        this.$sessionId = j;
        this.this$0 = mainActivity;
        this.$updated = smartSubwayTrip;
        this.$smartSubwayTrip$delegate = mutableState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MainActivity$TicketsApp$2$1$1$1(this.$sessionId, this.this$0, this.$updated, this.$smartSubwayTrip$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((MainActivity$TicketsApp$2$1$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object objNormalizeSmartSubwayRouteState;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            SmartSubwayTrip smartSubwayTripTicketsApp$lambda$9 = MainActivity.TicketsApp$lambda$9(this.$smartSubwayTrip$delegate);
            if (smartSubwayTripTicketsApp$lambda$9 == null || smartSubwayTripTicketsApp$lambda$9.getTripSessionId() != this.$sessionId) {
                return Unit.INSTANCE;
            }
            this.label = 1;
            objNormalizeSmartSubwayRouteState = MainActivityKt.normalizeSmartSubwayRouteState(this.this$0, this.$updated, this);
            if (objNormalizeSmartSubwayRouteState == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            objNormalizeSmartSubwayRouteState = obj;
        }
        SmartSubwayTrip smartSubwayTrip = (SmartSubwayTrip) objNormalizeSmartSubwayRouteState;
        SmartSubwayTrip smartSubwayTripTicketsApp$lambda$10 = MainActivity.TicketsApp$lambda$9(this.$smartSubwayTrip$delegate);
        if (smartSubwayTripTicketsApp$lambda$10 != null) {
            long tripSessionId = smartSubwayTripTicketsApp$lambda$10.getTripSessionId();
            long j = this.$sessionId;
            if (tripSessionId == j) {
                this.$smartSubwayTrip$delegate.setValue(SmartSubwayTrip.m9308copydOtcBKo$default(smartSubwayTrip, null, null, j, null, null, null, null, null, false, false, 0L, 0L, null, null, 0.0f, null, null, 131067, null));
            }
        }
        return Unit.INSTANCE;
    }
}
