package com.example.tickets;

import androidx.activity.compose.ManagedActivityResultLauncher;
import androidx.compose.runtime.MutableState;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: MainActivity.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.example.tickets.MainActivity$TicketsApp$2$1", f = "MainActivity.kt", i = {0, 0}, l = {1961}, m = "invokeSuspend", n = {"trip", "sessionId"}, s = {"L$0", "J$0"})
final class MainActivity$TicketsApp$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableState<Boolean> $smartSubwayLocationPermissionGranted$delegate;
    final /* synthetic */ ManagedActivityResultLauncher<String[], Map<String, Boolean>> $smartSubwayLocationPermissionLauncher;
    final /* synthetic */ MutableState<Boolean> $smartSubwayLocationPermissionRequested$delegate;
    final /* synthetic */ MutableState<SmartSubwayTrip> $smartSubwayTrip$delegate;
    long J$0;
    Object L$0;
    int label;
    final /* synthetic */ MainActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    MainActivity$TicketsApp$2$1(ManagedActivityResultLauncher<String[], Map<String, Boolean>> managedActivityResultLauncher, MainActivity mainActivity, MutableState<SmartSubwayTrip> mutableState, MutableState<Boolean> mutableState2, MutableState<Boolean> mutableState3, Continuation<? super MainActivity$TicketsApp$2$1> continuation) {
        super(2, continuation);
        this.$smartSubwayLocationPermissionLauncher = managedActivityResultLauncher;
        this.this$0 = mainActivity;
        this.$smartSubwayTrip$delegate = mutableState;
        this.$smartSubwayLocationPermissionGranted$delegate = mutableState2;
        this.$smartSubwayLocationPermissionRequested$delegate = mutableState3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MainActivity$TicketsApp$2$1(this.$smartSubwayLocationPermissionLauncher, this.this$0, this.$smartSubwayTrip$delegate, this.$smartSubwayLocationPermissionGranted$delegate, this.$smartSubwayLocationPermissionRequested$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((MainActivity$TicketsApp$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            SmartSubwayTrip smartSubwayTripTicketsApp$lambda$9 = MainActivity.TicketsApp$lambda$9(this.$smartSubwayTrip$delegate);
            if (smartSubwayTripTicketsApp$lambda$9 == null) {
                return Unit.INSTANCE;
            }
            final long tripSessionId = smartSubwayTripTicketsApp$lambda$9.getTripSessionId();
            if (!MainActivity.TicketsApp$lambda$15(this.$smartSubwayLocationPermissionGranted$delegate)) {
                if (!MainActivity.TicketsApp$lambda$18(this.$smartSubwayLocationPermissionRequested$delegate)) {
                    MainActivity.TicketsApp$lambda$19(this.$smartSubwayLocationPermissionRequested$delegate, true);
                    this.$smartSubwayLocationPermissionLauncher.launch(new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"});
                }
                return Unit.INSTANCE;
            }
            GlobalSubwayLocationEngine globalSubwayLocationEngine = GlobalSubwayLocationEngine.INSTANCE;
            final MainActivity mainActivity = this.this$0;
            final MutableState<SmartSubwayTrip> mutableState = this.$smartSubwayTrip$delegate;
            this.L$0 = SpillingKt.nullOutSpilledVariable(smartSubwayTripTicketsApp$lambda$9);
            this.J$0 = tripSessionId;
            this.label = 1;
            if (globalSubwayLocationEngine.trackTrip$app(mainActivity, smartSubwayTripTicketsApp$lambda$9, new Function1() { // from class: com.example.tickets.MainActivity$TicketsApp$2$1$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return MainActivity$TicketsApp$2$1.invokeSuspend$lambda$0(tripSessionId, mutableState, mainActivity, (SmartSubwayTrip) obj2);
                }
            }, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }

    static final Unit invokeSuspend$lambda$0(long j, MutableState mutableState, MainActivity mainActivity, SmartSubwayTrip smartSubwayTrip) {
        SmartSubwayTrip smartSubwayTripTicketsApp$lambda$9;
        if (smartSubwayTrip.getTripSessionId() == j && (smartSubwayTripTicketsApp$lambda$9 = MainActivity.TicketsApp$lambda$9(mutableState)) != null && smartSubwayTripTicketsApp$lambda$9.getTripSessionId() == j) {
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().getImmediate()), null, null, new MainActivity$TicketsApp$2$1$1$1(j, mainActivity, smartSubwayTrip, mutableState, null), 3, null);
            return Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }
}
