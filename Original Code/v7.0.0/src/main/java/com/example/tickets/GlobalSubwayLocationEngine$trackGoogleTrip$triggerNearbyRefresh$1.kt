package com.example.tickets;

import android.content.Context;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: GlobalSubwayData.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.example.tickets.GlobalSubwayLocationEngine$trackGoogleTrip$triggerNearbyRefresh$1", f = "GlobalSubwayData.kt", i = {0}, l = {4245}, m = "invokeSuspend", n = {"city"}, s = {"L$0"})
final class GlobalSubwayLocationEngine$trackGoogleTrip$triggerNearbyRefresh$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ Ref.ObjectRef<SmartSubwayTrip> $current;
    final /* synthetic */ LinkedHashMap<String, GlobalSubwayDataManager.SubwayStationOption> $knownStops;
    final /* synthetic */ double $latitude;
    final /* synthetic */ double $longitude;
    final /* synthetic */ Object $nearbyLock;
    final /* synthetic */ List<GlobalSubwayDataManager.RoutePoint> $routePath;
    final /* synthetic */ LinkedHashMap<String, Double> $stopPositions;
    Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    GlobalSubwayLocationEngine$trackGoogleTrip$triggerNearbyRefresh$1(Ref.ObjectRef<SmartSubwayTrip> objectRef, Context context, double d, double d2, Object obj, List<GlobalSubwayDataManager.RoutePoint> list, LinkedHashMap<String, GlobalSubwayDataManager.SubwayStationOption> linkedHashMap, LinkedHashMap<String, Double> linkedHashMap2, Continuation<? super GlobalSubwayLocationEngine$trackGoogleTrip$triggerNearbyRefresh$1> continuation) {
        super(2, continuation);
        this.$current = objectRef;
        this.$context = context;
        this.$latitude = d;
        this.$longitude = d2;
        this.$nearbyLock = obj;
        this.$routePath = list;
        this.$knownStops = linkedHashMap;
        this.$stopPositions = linkedHashMap2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new GlobalSubwayLocationEngine$trackGoogleTrip$triggerNearbyRefresh$1(this.$current, this.$context, this.$latitude, this.$longitude, this.$nearbyLock, this.$routePath, this.$knownStops, this.$stopPositions, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((GlobalSubwayLocationEngine$trackGoogleTrip$triggerNearbyRefresh$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            GlobalSubwayDataManager.SubwayCity subwayCityCityOrNull = GlobalSubwayDataManager.INSTANCE.cityOrNull(this.$current.element.getCityId());
            if (subwayCityCityOrNull == null) {
                return Unit.INSTANCE;
            }
            this.L$0 = SpillingKt.nullOutSpilledVariable(subwayCityCityOrNull);
            this.label = 1;
            obj = GlobalSubwayDataManager.INSTANCE.searchNearbyGoogleStations$app(this.$context, subwayCityCityOrNull, this.$latitude, this.$longitude, 2500.0d, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        List list = (List) obj;
        if (!list.isEmpty()) {
            GlobalSubwayLocationEngine.trackGoogleTrip$mergeNearby(this.$nearbyLock, this.$routePath, this.$knownStops, this.$stopPositions, list);
        }
        return Unit.INSTANCE;
    }
}
