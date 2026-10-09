package com.example.tickets;

import android.content.Context;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: GlobalSubwayData.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.example.tickets.GlobalSubwayDataManager$previousPhysicalStationForRoute$2", f = "GlobalSubwayData.kt", i = {0}, l = {528}, m = "invokeSuspend", n = {"city"}, s = {"L$0"})
final class GlobalSubwayDataManager$previousPhysicalStationForRoute$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
    final /* synthetic */ String $cityId;
    final /* synthetic */ Context $context;
    final /* synthetic */ String $currentStation;
    final /* synthetic */ String $lineName;
    final /* synthetic */ String $nextStation;
    Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    GlobalSubwayDataManager$previousPhysicalStationForRoute$2(String str, Context context, String str2, String str3, String str4, Continuation<? super GlobalSubwayDataManager$previousPhysicalStationForRoute$2> continuation) {
        super(2, continuation);
        this.$cityId = str;
        this.$context = context;
        this.$currentStation = str2;
        this.$nextStation = str3;
        this.$lineName = str4;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new GlobalSubwayDataManager$previousPhysicalStationForRoute$2(this.$cityId, this.$context, this.$currentStation, this.$nextStation, this.$lineName, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super String> continuation) {
        return ((GlobalSubwayDataManager$previousPhysicalStationForRoute$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:25:0x007b A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:26:0x007c  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        GlobalSubwayDataManager.StaticIndex staticIndexLoadOrBuildIndex$app;
        String strResolveStationKey;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            GlobalSubwayDataManager.SubwayCity subwayCityCityOrNull = GlobalSubwayDataManager.INSTANCE.cityOrNull(this.$cityId);
            if (subwayCityCityOrNull == null || subwayCityCityOrNull.getSourceType() == GlobalSubwayDataManager.SourceType.GOOGLE) {
                return "";
            }
            if (GlobalSubwayDataManager.SERVER_PATTERN_US_CITY_IDS.contains(this.$cityId)) {
                this.L$0 = SpillingKt.nullOutSpilledVariable(subwayCityCityOrNull);
                this.label = 1;
                obj = GlobalSubwayDataManager.INSTANCE.loadUsServerRoutingIndex(this.$context, this.$cityId, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                staticIndexLoadOrBuildIndex$app = GlobalSubwayDataManager.INSTANCE.loadOrBuildIndex$app(this.$context, this.$cityId);
            }
            strResolveStationKey = GlobalSubwayDataManager.INSTANCE.resolveStationKey(staticIndexLoadOrBuildIndex$app, this.$currentStation);
            if (strResolveStationKey == null) {
                return "";
            }
            return GlobalSubwayDataManager.INSTANCE.previousPhysicalStationFromIndex$app(staticIndexLoadOrBuildIndex$app, this.$lineName, strResolveStationKey, GlobalSubwayDataManager.INSTANCE.resolveStationKey(staticIndexLoadOrBuildIndex$app, this.$nextStation));
        }
        if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        staticIndexLoadOrBuildIndex$app = (GlobalSubwayDataManager.StaticIndex) obj;
        if (staticIndexLoadOrBuildIndex$app == null) {
            staticIndexLoadOrBuildIndex$app = GlobalSubwayDataManager.INSTANCE.loadOrBuildIndex$app(this.$context, this.$cityId);
        }
        strResolveStationKey = GlobalSubwayDataManager.INSTANCE.resolveStationKey(staticIndexLoadOrBuildIndex$app, this.$currentStation);
        if (strResolveStationKey == null) {
            return "";
        }
        return GlobalSubwayDataManager.INSTANCE.previousPhysicalStationFromIndex$app(staticIndexLoadOrBuildIndex$app, this.$lineName, strResolveStationKey, GlobalSubwayDataManager.INSTANCE.resolveStationKey(staticIndexLoadOrBuildIndex$app, this.$nextStation));
    }
}
