package com.example.tickets;

import android.content.Context;
import androidx.compose.foundation.style.StylePropertiesKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.graphics.ColorKt;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: MainActivity.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.example.tickets.MainActivityKt$SmartSubwayTripDetail$1$1", f = "MainActivity.kt", i = {0, 0, 0}, l = {5736}, m = "invokeSuspend", n = {"$this$LaunchedEffect", "$this$invokeSuspend_u24lambda_u240", "$i$a$-runCatching-MainActivityKt$SmartSubwayTripDetail$1$1$resolved$1"}, s = {"L$0", "L$1", "I$0"})
final class MainActivityKt$SmartSubwayTripDetail$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ MutableState<List<SmartSubwayTimelineStop>> $fullRouteStops$delegate;
    final /* synthetic */ SmartSubwayTrip $trip;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    MainActivityKt$SmartSubwayTripDetail$1$1(SmartSubwayTrip smartSubwayTrip, MutableState<List<SmartSubwayTimelineStop>> mutableState, Context context, Continuation<? super MainActivityKt$SmartSubwayTripDetail$1$1> continuation) {
        super(2, continuation);
        this.$trip = smartSubwayTrip;
        this.$fullRouteStops$delegate = mutableState;
        this.$context = context;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        MainActivityKt$SmartSubwayTripDetail$1$1 mainActivityKt$SmartSubwayTripDetail$1$1 = new MainActivityKt$SmartSubwayTripDetail$1$1(this.$trip, this.$fullRouteStops$delegate, this.$context, continuation);
        mainActivityKt$SmartSubwayTripDetail$1$1.L$0 = obj;
        return mainActivityKt$SmartSubwayTripDetail$1$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((MainActivityKt$SmartSubwayTripDetail$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r16v0 */
    /* JADX WARN: Type inference failed for: r16v1 */
    /* JADX WARN: Type inference failed for: r16v2 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object objM9536constructorimpl;
        ?? r16;
        ArrayList arrayListEmptyList;
        String lineName;
        String lineName2;
        List<GlobalSubwayDataManager.SubwayRouteStation> stations;
        boolean z;
        boolean z2;
        String str;
        GlobalSubwayDataManager.SubwayRouteInfo secondaryRoute;
        GlobalSubwayDataManager.SubwayRouteInfo primaryRoute;
        List<GlobalSubwayDataManager.SubwayRouteInfo> routeInfos;
        Object objResolveRoutePlan;
        CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        boolean z3 = false;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.$fullRouteStops$delegate.setValue(CollectionsKt.emptyList());
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
                objResolveRoutePlan = globalSubwayDataManager.resolveRoutePlan(context, cityId, origin, destination, this);
                if (objResolveRoutePlan == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                objResolveRoutePlan = obj;
            }
            objM9536constructorimpl = Result.m9536constructorimpl((GlobalSubwayDataManager.SubwayRoutePlan) objResolveRoutePlan);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM9536constructorimpl = Result.m9536constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m9542isFailureimpl(objM9536constructorimpl)) {
            objM9536constructorimpl = null;
        }
        GlobalSubwayDataManager.SubwayRoutePlan subwayRoutePlan = (GlobalSubwayDataManager.SubwayRoutePlan) objM9536constructorimpl;
        Map mapCreateMapBuilder = MapsKt.createMapBuilder();
        if (subwayRoutePlan != null && (routeInfos = subwayRoutePlan.getRouteInfos()) != null) {
            for (GlobalSubwayDataManager.SubwayRouteInfo subwayRouteInfo : routeInfos) {
                if (!StringsKt.isBlank(subwayRouteInfo.getRouteId())) {
                    mapCreateMapBuilder.put(subwayRouteInfo.getRouteId(), subwayRouteInfo);
                }
            }
        }
        if (subwayRoutePlan != null && (primaryRoute = subwayRoutePlan.getPrimaryRoute()) != null && !StringsKt.isBlank(primaryRoute.getRouteId())) {
            mapCreateMapBuilder.put(primaryRoute.getRouteId(), primaryRoute);
        }
        if (subwayRoutePlan != null && (secondaryRoute = subwayRoutePlan.getSecondaryRoute()) != null && !StringsKt.isBlank(secondaryRoute.getRouteId())) {
            mapCreateMapBuilder.put(secondaryRoute.getRouteId(), secondaryRoute);
        }
        Map mapBuild = MapsKt.build(mapCreateMapBuilder);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry entry : mapBuild.entrySet()) {
            if (!StringsKt.isBlank((String) entry.getKey())) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        LinkedHashMap linkedHashMap2 = linkedHashMap;
        MutableState<List<SmartSubwayTimelineStop>> mutableState = this.$fullRouteStops$delegate;
        if (subwayRoutePlan == null || (stations = subwayRoutePlan.getStations()) == null) {
            r16 = 0;
            arrayListEmptyList = null;
        } else {
            List<GlobalSubwayDataManager.SubwayRouteStation> list = stations;
            SmartSubwayTrip smartSubwayTrip2 = this.$trip;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            int i2 = 0;
            for (Object obj2 : list) {
                int i3 = i2 + 1;
                if (i2 < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                GlobalSubwayDataManager.SubwayRouteStation subwayRouteStation = (GlobalSubwayDataManager.SubwayRouteStation) obj2;
                GlobalSubwayDataManager.SubwayRouteInfo primaryRoute2 = (GlobalSubwayDataManager.SubwayRouteInfo) linkedHashMap2.get(subwayRouteStation.getRouteId());
                if (primaryRoute2 == null) {
                    primaryRoute2 = subwayRoutePlan.getPrimaryRoute();
                }
                GlobalSubwayDataManager.SubwayRouteStation subwayRouteStation2 = (GlobalSubwayDataManager.SubwayRouteStation) CollectionsKt.getOrNull(subwayRoutePlan.getStations(), i2 - 1);
                String routeId = subwayRouteStation2 != null ? subwayRouteStation2.getRouteId() : null;
                String str2 = "";
                if (routeId == null) {
                    routeId = "";
                }
                if (i2 <= 0 || StringsKt.isBlank(routeId) || Intrinsics.areEqual(routeId, subwayRouteStation.getRouteId())) {
                    z = z3;
                    z2 = z;
                } else {
                    z2 = z3;
                    z = true;
                }
                GlobalSubwayDataManager.SubwayRoutePlan subwayRoutePlan2 = subwayRoutePlan;
                boolean zEquals = StringsKt.equals(subwayRouteStation.getName(), smartSubwayTrip2.getCurrentStation(), true);
                String name = subwayRouteStation.getName();
                if (z && zEquals) {
                    str = "当前站 · 换乘";
                } else if (zEquals) {
                    str = "当前站";
                } else if (z) {
                    str = "换乘站";
                } else if (i2 == 0) {
                    str = "出发站";
                } else {
                    str = i2 == CollectionsKt.getLastIndex(subwayRoutePlan2.getStations()) ? "终点站" : "途径站";
                }
                String str3 = str;
                String shortName = primaryRoute2.getShortName();
                if (StringsKt.isBlank(shortName)) {
                    shortName = primaryRoute2.getRouteId();
                }
                String str4 = shortName;
                int color = primaryRoute2.getColor();
                GlobalSubwayDataManager.SubwayRouteInfo subwayRouteInfo2 = (GlobalSubwayDataManager.SubwayRouteInfo) linkedHashMap2.get(routeId);
                String shortName2 = subwayRouteInfo2 != null ? subwayRouteInfo2.getShortName() : null;
                String str5 = shortName2 == null ? "" : shortName2;
                if (z) {
                    String shortName3 = primaryRoute2.getShortName();
                    if (StringsKt.isBlank(shortName3)) {
                        shortName3 = primaryRoute2.getRouteId();
                    }
                    str2 = shortName3;
                }
                arrayList.add(new SmartSubwayTimelineStop(name, str3, str4, color, zEquals, str5, str2));
                i2 = i3;
                z3 = z2;
                subwayRoutePlan = subwayRoutePlan2;
            }
            r16 = z3;
            arrayListEmptyList = arrayList;
        }
        if (arrayListEmptyList == null) {
            arrayListEmptyList = CollectionsKt.emptyList();
        }
        mutableState.setValue(arrayListEmptyList);
        if (MainActivityKt.SmartSubwayTripDetail$lambda$212(this.$fullRouteStops$delegate).isEmpty()) {
            int iM5892toArgb8_81llA = ColorKt.m5892toArgb8_81llA(this.$trip.m9312getPrimaryLineColor0d7_KjU());
            int iM5892toArgb8_81llA2 = ColorKt.m5892toArgb8_81llA(this.$trip.m9313getSecondaryLineColor0d7_KjU());
            MutableState<List<SmartSubwayTimelineStop>> mutableState2 = this.$fullRouteStops$delegate;
            SmartSubwayTimelineStop[] smartSubwayTimelineStopArr = new SmartSubwayTimelineStop[4];
            smartSubwayTimelineStopArr[r16] = new SmartSubwayTimelineStop(this.$trip.getOrigin(), "出发站", this.$trip.getLineName(), iM5892toArgb8_81llA, false, null, null, StylePropertiesKt.TextDirectionMask, null);
            smartSubwayTimelineStopArr[1] = new SmartSubwayTimelineStop(this.$trip.getCurrentStation(), "当前站", this.$trip.getLineName(), iM5892toArgb8_81llA, true, null, null, 96, null);
            String nextStation = this.$trip.getNextStation();
            boolean zIsAfterTransferUi = MainActivityKt.isAfterTransferUi(this.$trip);
            SmartSubwayTrip smartSubwayTrip3 = this.$trip;
            if (zIsAfterTransferUi) {
                String transferLineName = smartSubwayTrip3.getTransferLineName();
                SmartSubwayTrip smartSubwayTrip4 = this.$trip;
                if (StringsKt.isBlank(transferLineName)) {
                    transferLineName = smartSubwayTrip4.getLineName();
                }
                lineName = transferLineName;
            } else {
                lineName = smartSubwayTrip3.getLineName();
            }
            smartSubwayTimelineStopArr[2] = new SmartSubwayTimelineStop(nextStation, "下一站", lineName, MainActivityKt.isAfterTransferUi(this.$trip) ? iM5892toArgb8_81llA2 : iM5892toArgb8_81llA, false, null, null, StylePropertiesKt.TextDirectionMask, null);
            String destination2 = this.$trip.getDestination();
            boolean zIsAfterTransferUi2 = MainActivityKt.isAfterTransferUi(this.$trip);
            SmartSubwayTrip smartSubwayTrip5 = this.$trip;
            if (zIsAfterTransferUi2) {
                String transferLineName2 = smartSubwayTrip5.getTransferLineName();
                SmartSubwayTrip smartSubwayTrip6 = this.$trip;
                if (StringsKt.isBlank(transferLineName2)) {
                    transferLineName2 = smartSubwayTrip6.getLineName();
                }
                lineName2 = transferLineName2;
            } else {
                lineName2 = smartSubwayTrip5.getLineName();
            }
            smartSubwayTimelineStopArr[3] = new SmartSubwayTimelineStop(destination2, "终点站", lineName2, MainActivityKt.isAfterTransferUi(this.$trip) ? iM5892toArgb8_81llA2 : iM5892toArgb8_81llA, false, null, null, StylePropertiesKt.TextDirectionMask, null);
            mutableState2.setValue(CollectionsKt.listOf((Object[]) smartSubwayTimelineStopArr));
        }
        return Unit.INSTANCE;
    }
}
