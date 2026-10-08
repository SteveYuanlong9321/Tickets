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
@DebugMetadata(c = "com.example.tickets.MainActivity$TicketsApp$8$1", f = "MainActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class MainActivity$TicketsApp$8$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableState<AppSettings> $appSettings$delegate;
    final /* synthetic */ MutableState<String> $publishedSmartSubwayMode$delegate;
    final /* synthetic */ MutableState<SmartSubwayTrip> $smartSubwayTrip$delegate;
    int label;
    final /* synthetic */ MainActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    MainActivity$TicketsApp$8$1(MainActivity mainActivity, MutableState<AppSettings> mutableState, MutableState<String> mutableState2, MutableState<SmartSubwayTrip> mutableState3, Continuation<? super MainActivity$TicketsApp$8$1> continuation) {
        super(2, continuation);
        this.this$0 = mainActivity;
        this.$appSettings$delegate = mutableState;
        this.$publishedSmartSubwayMode$delegate = mutableState2;
        this.$smartSubwayTrip$delegate = mutableState3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MainActivity$TicketsApp$8$1(this.this$0, this.$appSettings$delegate, this.$publishedSmartSubwayMode$delegate, this.$smartSubwayTrip$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((MainActivity$TicketsApp$8$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            String integrationMode = MainActivity.TicketsApp$lambda$48(this.$appSettings$delegate).getIntegrationMode();
            String strTicketsApp$lambda$12 = MainActivity.TicketsApp$lambda$12(this.$publishedSmartSubwayMode$delegate);
            if (strTicketsApp$lambda$12 != null && !Intrinsics.areEqual(strTicketsApp$lambda$12, integrationMode)) {
                SmartSubwayRealtimeRouter.INSTANCE.cancel(this.this$0, strTicketsApp$lambda$12);
            }
            if (MainActivity.TicketsApp$lambda$9(this.$smartSubwayTrip$delegate) != null) {
                SmartSubwayRealtimeRouter smartSubwayRealtimeRouter = SmartSubwayRealtimeRouter.INSTANCE;
                MainActivity mainActivity = this.this$0;
                SmartSubwayTrip smartSubwayTripTicketsApp$lambda$9 = MainActivity.TicketsApp$lambda$9(this.$smartSubwayTrip$delegate);
                Intrinsics.checkNotNull(smartSubwayTripTicketsApp$lambda$9);
                smartSubwayRealtimeRouter.publish(mainActivity, integrationMode, SmartSubwayRealtimeKt.toRealtimeState(smartSubwayTripTicketsApp$lambda$9));
                this.$publishedSmartSubwayMode$delegate.setValue(integrationMode);
            } else {
                if (strTicketsApp$lambda$12 != null) {
                    SmartSubwayRealtimeRouter.INSTANCE.cancel(this.this$0, strTicketsApp$lambda$12);
                } else {
                    SmartSubwayRealtimeRouter.INSTANCE.cancel(this.this$0, integrationMode);
                }
                this.$publishedSmartSubwayMode$delegate.setValue(null);
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
