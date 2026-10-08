package com.example.tickets;

import android.content.Context;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: SmartSubwayManualAdvance.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/example/tickets/GlobalSubwayDataManager$SubwayRoutePlan;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.example.tickets.SmartSubwayManualAdvance$advance$plan$1", f = "SmartSubwayManualAdvance.kt", i = {0, 0, 0}, l = {67}, m = "invokeSuspend", n = {"$this$withTimeoutOrNull", "$this$invokeSuspend_u24lambda_u240", "$i$a$-runCatching-SmartSubwayManualAdvance$advance$plan$1$1"}, s = {"L$0", "L$1", "I$0"})
final class SmartSubwayManualAdvance$advance$plan$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super GlobalSubwayDataManager.SubwayRoutePlan>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ SmartSubwayTrip $trip;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SmartSubwayManualAdvance$advance$plan$1(Context context, SmartSubwayTrip smartSubwayTrip, Continuation<? super SmartSubwayManualAdvance$advance$plan$1> continuation) {
        super(2, continuation);
        this.$context = context;
        this.$trip = smartSubwayTrip;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        SmartSubwayManualAdvance$advance$plan$1 smartSubwayManualAdvance$advance$plan$1 = new SmartSubwayManualAdvance$advance$plan$1(this.$context, this.$trip, continuation);
        smartSubwayManualAdvance$advance$plan$1.L$0 = obj;
        return smartSubwayManualAdvance$advance$plan$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super GlobalSubwayDataManager.SubwayRoutePlan> continuation) {
        return ((SmartSubwayManualAdvance$advance$plan$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object objM9536constructorimpl;
        CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Context context = this.$context;
                SmartSubwayTrip smartSubwayTrip = this.$trip;
                Result.Companion companion = Result.INSTANCE;
                GlobalSubwayDataManager globalSubwayDataManager = GlobalSubwayDataManager.INSTANCE;
                String cityId = smartSubwayTrip.getCityId();
                String origin = smartSubwayTrip.getOrigin();
                String destination = smartSubwayTrip.getDestination();
                this.L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope);
                this.L$1 = SpillingKt.nullOutSpilledVariable(coroutineScope);
                this.I$0 = 0;
                this.label = 1;
                obj = globalSubwayDataManager.resolveRoutePlan(context, cityId, origin, destination, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            objM9536constructorimpl = Result.m9536constructorimpl((GlobalSubwayDataManager.SubwayRoutePlan) obj);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM9536constructorimpl = Result.m9536constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m9542isFailureimpl(objM9536constructorimpl)) {
            return null;
        }
        return objM9536constructorimpl;
    }
}
