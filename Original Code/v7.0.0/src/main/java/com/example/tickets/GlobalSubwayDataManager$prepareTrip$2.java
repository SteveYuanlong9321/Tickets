package com.example.tickets;

import android.content.Context;
import androidx.compose.ui.graphics.ColorKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: GlobalSubwayData.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/example/tickets/SmartSubwayTrip;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.example.tickets.GlobalSubwayDataManager$prepareTrip$2", f = "GlobalSubwayData.kt", i = {0, 1, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3}, l = {567, 570, 592, 615}, m = "invokeSuspend", n = {"city", "city", "city", "plan", "firstNext", "initialCurrent", "initialNext", "transferName", "transferRequired", "city", "plan", "firstNext", "initialCurrent", "initialNext", "transferName", "previousPhysical", "transferRequired"}, s = {"L$0", "L$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "I$0"})
final class GlobalSubwayDataManager$prepareTrip$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super SmartSubwayTrip>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ SmartSubwayTrip $trip;
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    GlobalSubwayDataManager$prepareTrip$2(SmartSubwayTrip smartSubwayTrip, Context context, Continuation<? super GlobalSubwayDataManager$prepareTrip$2> continuation) {
        super(2, continuation);
        this.$trip = smartSubwayTrip;
        this.$context = context;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new GlobalSubwayDataManager$prepareTrip$2(this.$trip, this.$context, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super SmartSubwayTrip> continuation) {
        return ((GlobalSubwayDataManager$prepareTrip$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:101:0x02c5  */
    /* JADX WARN: Code duplicated, block: B:104:0x02db  */
    /* JADX WARN: Code duplicated, block: B:105:0x02ea  */
    /* JADX WARN: Code duplicated, block: B:107:0x02f9  */
    /* JADX WARN: Code duplicated, block: B:36:0x0123  */
    /* JADX WARN: Code duplicated, block: B:38:0x015e  */
    /* JADX WARN: Code duplicated, block: B:40:0x017b  */
    /* JADX WARN: Code duplicated, block: B:42:0x0181  */
    /* JADX WARN: Code duplicated, block: B:45:0x018a  */
    /* JADX WARN: Code duplicated, block: B:47:0x0190  */
    /* JADX WARN: Code duplicated, block: B:50:0x019d  */
    /* JADX WARN: Code duplicated, block: B:51:0x01a2  */
    /* JADX WARN: Code duplicated, block: B:53:0x01a5  */
    /* JADX WARN: Code duplicated, block: B:56:0x01ac  */
    /* JADX WARN: Code duplicated, block: B:59:0x01b7  */
    /* JADX WARN: Code duplicated, block: B:62:0x01c0  */
    /* JADX WARN: Code duplicated, block: B:64:0x01d0  */
    /* JADX WARN: Code duplicated, block: B:67:0x01f5  */
    /* JADX WARN: Code duplicated, block: B:70:0x01fb  */
    /* JADX WARN: Code duplicated, block: B:72:0x020c  */
    /* JADX WARN: Code duplicated, block: B:75:0x0226  */
    /* JADX WARN: Code duplicated, block: B:76:0x022b  */
    /* JADX WARN: Code duplicated, block: B:78:0x022e  */
    /* JADX WARN: Code duplicated, block: B:80:0x0231  */
    /* JADX WARN: Code duplicated, block: B:81:0x0236  */
    /* JADX WARN: Code duplicated, block: B:84:0x0240  */
    /* JADX WARN: Code duplicated, block: B:86:0x0252  */
    /* JADX WARN: Code duplicated, block: B:88:0x0265 A[PHI: r2 r6 r10 r11 r12 r13 r14
      0x0265: PHI (r2v45 java.lang.String) = (r2v31 java.lang.String), (r2v48 java.lang.String) binds: [B:61:0x01be, B:83:0x023e] A[DONT_GENERATE, DONT_INLINE]
      0x0265: PHI (r6v5 java.lang.String) = (r6v2 java.lang.String), (r6v7 java.lang.String) binds: [B:61:0x01be, B:83:0x023e] A[DONT_GENERATE, DONT_INLINE]
      0x0265: PHI (r10v13 java.lang.String) = (r10v8 java.lang.String), (r10v16 java.lang.String) binds: [B:61:0x01be, B:83:0x023e] A[DONT_GENERATE, DONT_INLINE]
      0x0265: PHI (r11v7 com.example.tickets.GlobalSubwayDataManager$SubwayRouteStation) = 
      (r11v4 com.example.tickets.GlobalSubwayDataManager$SubwayRouteStation)
      (r11v10 com.example.tickets.GlobalSubwayDataManager$SubwayRouteStation)
     binds: [B:61:0x01be, B:83:0x023e] A[DONT_GENERATE, DONT_INLINE]
      0x0265: PHI (r12v6 com.example.tickets.GlobalSubwayDataManager$SubwayRoutePlan) = 
      (r12v3 com.example.tickets.GlobalSubwayDataManager$SubwayRoutePlan)
      (r12v10 com.example.tickets.GlobalSubwayDataManager$SubwayRoutePlan)
     binds: [B:61:0x01be, B:83:0x023e] A[DONT_GENERATE, DONT_INLINE]
      0x0265: PHI (r13v5 com.example.tickets.GlobalSubwayDataManager$SubwayCity) = 
      (r13v2 com.example.tickets.GlobalSubwayDataManager$SubwayCity)
      (r13v8 com.example.tickets.GlobalSubwayDataManager$SubwayCity)
     binds: [B:61:0x01be, B:83:0x023e] A[DONT_GENERATE, DONT_INLINE]
      0x0265: PHI (r14v9 int) = (r14v3 int), (r14v11 int) binds: [B:61:0x01be, B:83:0x023e] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:91:0x0272  */
    /* JADX WARN: Code duplicated, block: B:93:0x0282  */
    /* JADX WARN: Code duplicated, block: B:96:0x02b0  */
    /* JADX WARN: Code duplicated, block: B:99:0x02b5  */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x00b6, code lost:
    
        if (r2 == r1) goto L95;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00e3, code lost:
    
        if (r2 == r1) goto L95;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) throws Throwable {
        GlobalSubwayDataManager.SubwayCity subwayCityCityOrNull;
        GlobalSubwayDataManager.StaticIndex staticIndexLoadOrBuildIndex$app;
        Object objLoadUsServerRoutingIndex;
        Object objGoogleResolvePlan;
        GlobalSubwayDataManager.SubwayRoutePlan subwayRoutePlanResolvePlan;
        GlobalSubwayDataManager.SubwayRoutePlan subwayRoutePlan;
        GlobalSubwayDataManager.SubwayRouteStation subwayRouteStation;
        GlobalSubwayDataManager.SubwayRouteStation subwayRouteStation2;
        String origin;
        String str;
        String destination;
        String str2;
        GlobalSubwayDataManager.SubwayStationOption transferStation;
        String name;
        int i;
        GlobalSubwayDataManager.StaticIndex staticIndexLoadOrBuildIndex$app2;
        Object objLoadUsServerRoutingIndex2;
        String str3;
        int i2;
        String str4;
        String str5;
        String str6;
        String str7;
        GlobalSubwayDataManager.SubwayRoutePlan subwayRoutePlan2;
        List<String> listEmptyList;
        GlobalSubwayDataManager.StaticIndex staticIndexLoadOrBuildIndex$app3;
        Object objLoadUsServerRoutingIndex3;
        int i3;
        GlobalSubwayDataManager.SubwayRouteStation subwayRouteStation3;
        String stationKey;
        String stationKey2;
        String shortName;
        String strResolveStationKey;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i4 = this.label;
        if (i4 != 0) {
            if (i4 == 1) {
                GlobalSubwayDataManager.SubwayCity subwayCity = (GlobalSubwayDataManager.SubwayCity) this.L$0;
                ResultKt.throwOnFailure(obj);
                subwayCityCityOrNull = subwayCity;
                objGoogleResolvePlan = obj;
                subwayRoutePlanResolvePlan = (GlobalSubwayDataManager.SubwayRoutePlan) objGoogleResolvePlan;
                subwayRoutePlan = subwayRoutePlanResolvePlan;
                if (subwayRoutePlan == null) {
                    return SmartSubwayTrip.m9308copydOtcBKo$default(this.$trip, null, GlobalSubwayDataManager.INSTANCE.cityName(this.$trip.getCityId()), 0L, null, null, null, this.$trip.getDestination(), null, false, false, 0L, 0L, null, null, 0.0f, null, null, 131005, null);
                }
                subwayRouteStation = (GlobalSubwayDataManager.SubwayRouteStation) CollectionsKt.firstOrNull(CollectionsKt.drop(subwayRoutePlan.getStations(), 1));
                subwayRouteStation2 = (GlobalSubwayDataManager.SubwayRouteStation) CollectionsKt.firstOrNull((List) subwayRoutePlan.getStations());
                if (subwayRouteStation2 != null) {
                    origin = this.$trip.getOrigin();
                } else {
                    origin = this.$trip.getOrigin();
                }
                str = origin;
                if (subwayRouteStation != null) {
                    destination = this.$trip.getDestination();
                } else {
                    destination = this.$trip.getDestination();
                }
                str2 = destination;
                transferStation = subwayRoutePlan.getTransferStation();
                if (transferStation != null) {
                    name = transferStation.getName();
                } else {
                    name = null;
                }
                if (name == null) {
                    name = "";
                }
                if (subwayRoutePlan.getSecondaryRoute() != null) {
                    i = 0;
                } else {
                    i = 0;
                }
                if (subwayCityCityOrNull.getSourceType() != GlobalSubwayDataManager.SourceType.GOOGLE) {
                    if (GlobalSubwayDataManager.SERVER_PATTERN_US_CITY_IDS.contains(this.$trip.getCityId())) {
                        this.L$0 = subwayCityCityOrNull;
                        this.L$1 = subwayRoutePlan;
                        this.L$2 = subwayRouteStation;
                        this.L$3 = str;
                        this.L$4 = str2;
                        this.L$5 = name;
                        this.I$0 = i;
                        this.label = 3;
                        objLoadUsServerRoutingIndex2 = GlobalSubwayDataManager.INSTANCE.loadUsServerRoutingIndex(this.$context, this.$trip.getCityId(), this);
                        if (objLoadUsServerRoutingIndex2 != coroutine_suspended) {
                            str3 = name;
                            i2 = i;
                            staticIndexLoadOrBuildIndex$app2 = (GlobalSubwayDataManager.StaticIndex) objLoadUsServerRoutingIndex2;
                            if (staticIndexLoadOrBuildIndex$app2 == null) {
                                staticIndexLoadOrBuildIndex$app2 = GlobalSubwayDataManager.INSTANCE.loadOrBuildIndex$app(this.$context, this.$trip.getCityId());
                            }
                            i = i2;
                            name = str3;
                            subwayRouteStation3 = (GlobalSubwayDataManager.SubwayRouteStation) CollectionsKt.firstOrNull((List) subwayRoutePlan.getStations());
                            if (subwayRouteStation3 != null) {
                                stationKey = subwayRouteStation3.getStationKey();
                            } else {
                                stationKey = null;
                            }
                            if (stationKey == null) {
                                stationKey = "";
                            }
                            if (subwayRouteStation != null) {
                                stationKey2 = subwayRouteStation.getStationKey();
                            } else {
                                stationKey2 = null;
                            }
                            if (StringsKt.isBlank(stationKey)) {
                                str4 = name;
                                str5 = str2;
                                str6 = "";
                            } else {
                                GlobalSubwayDataManager globalSubwayDataManager = GlobalSubwayDataManager.INSTANCE;
                                shortName = subwayRoutePlan.getPrimaryRoute().getShortName();
                                if (StringsKt.isBlank(shortName)) {
                                    shortName = subwayRoutePlan.getPrimaryRoute().getRouteId();
                                }
                                String strPreviousPhysicalStationFromIndex$app = globalSubwayDataManager.previousPhysicalStationFromIndex$app(staticIndexLoadOrBuildIndex$app2, shortName, stationKey, stationKey2);
                                str4 = name;
                                str6 = strPreviousPhysicalStationFromIndex$app;
                                str5 = str2;
                            }
                            str7 = str;
                            subwayRoutePlan2 = subwayRoutePlan;
                            if (subwayCityCityOrNull.getSourceType() != GlobalSubwayDataManager.SourceType.GOOGLE) {
                                if (GlobalSubwayDataManager.SERVER_PATTERN_US_CITY_IDS.contains(this.$trip.getCityId())) {
                                    this.L$0 = SpillingKt.nullOutSpilledVariable(subwayCityCityOrNull);
                                    this.L$1 = subwayRoutePlan2;
                                    this.L$2 = SpillingKt.nullOutSpilledVariable(subwayRouteStation);
                                    this.L$3 = str7;
                                    this.L$4 = str5;
                                    this.L$5 = str4;
                                    this.L$6 = str6;
                                    this.I$0 = i;
                                    this.label = 4;
                                    objLoadUsServerRoutingIndex3 = GlobalSubwayDataManager.INSTANCE.loadUsServerRoutingIndex(this.$context, this.$trip.getCityId(), this);
                                    if (objLoadUsServerRoutingIndex3 != coroutine_suspended) {
                                        i3 = i;
                                    }
                                } else {
                                    staticIndexLoadOrBuildIndex$app3 = GlobalSubwayDataManager.INSTANCE.loadOrBuildIndex$app(this.$context, this.$trip.getCityId());
                                }
                                strResolveStationKey = GlobalSubwayDataManager.INSTANCE.resolveStationKey(staticIndexLoadOrBuildIndex$app3, str7);
                                if (strResolveStationKey != null) {
                                    listEmptyList = GlobalSubwayDataManager.INSTANCE.currentStationTransferOptions$app(staticIndexLoadOrBuildIndex$app3, strResolveStationKey, subwayRoutePlan2.getPrimaryRoute().getRouteId());
                                } else {
                                    listEmptyList = CollectionsKt.emptyList();
                                }
                            } else {
                                listEmptyList = CollectionsKt.emptyList();
                            }
                        }
                    } else {
                        staticIndexLoadOrBuildIndex$app2 = GlobalSubwayDataManager.INSTANCE.loadOrBuildIndex$app(this.$context, this.$trip.getCityId());
                        subwayRouteStation3 = (GlobalSubwayDataManager.SubwayRouteStation) CollectionsKt.firstOrNull((List) subwayRoutePlan.getStations());
                        if (subwayRouteStation3 != null) {
                            stationKey = subwayRouteStation3.getStationKey();
                        } else {
                            stationKey = null;
                        }
                        if (stationKey == null) {
                            stationKey = "";
                        }
                        if (subwayRouteStation != null) {
                            stationKey2 = subwayRouteStation.getStationKey();
                        } else {
                            stationKey2 = null;
                        }
                        if (StringsKt.isBlank(stationKey)) {
                            GlobalSubwayDataManager globalSubwayDataManager2 = GlobalSubwayDataManager.INSTANCE;
                            shortName = subwayRoutePlan.getPrimaryRoute().getShortName();
                            if (StringsKt.isBlank(shortName)) {
                                shortName = subwayRoutePlan.getPrimaryRoute().getRouteId();
                            }
                            String strPreviousPhysicalStationFromIndex$app2 = globalSubwayDataManager2.previousPhysicalStationFromIndex$app(staticIndexLoadOrBuildIndex$app2, shortName, stationKey, stationKey2);
                            str4 = name;
                            str6 = strPreviousPhysicalStationFromIndex$app2;
                            str5 = str2;
                        } else {
                            str4 = name;
                            str5 = str2;
                            str6 = "";
                        }
                        str7 = str;
                        subwayRoutePlan2 = subwayRoutePlan;
                        if (subwayCityCityOrNull.getSourceType() != GlobalSubwayDataManager.SourceType.GOOGLE) {
                            if (GlobalSubwayDataManager.SERVER_PATTERN_US_CITY_IDS.contains(this.$trip.getCityId())) {
                                this.L$0 = SpillingKt.nullOutSpilledVariable(subwayCityCityOrNull);
                                this.L$1 = subwayRoutePlan2;
                                this.L$2 = SpillingKt.nullOutSpilledVariable(subwayRouteStation);
                                this.L$3 = str7;
                                this.L$4 = str5;
                                this.L$5 = str4;
                                this.L$6 = str6;
                                this.I$0 = i;
                                this.label = 4;
                                objLoadUsServerRoutingIndex3 = GlobalSubwayDataManager.INSTANCE.loadUsServerRoutingIndex(this.$context, this.$trip.getCityId(), this);
                                if (objLoadUsServerRoutingIndex3 != coroutine_suspended) {
                                    i3 = i;
                                }
                            } else {
                                staticIndexLoadOrBuildIndex$app3 = GlobalSubwayDataManager.INSTANCE.loadOrBuildIndex$app(this.$context, this.$trip.getCityId());
                            }
                            strResolveStationKey = GlobalSubwayDataManager.INSTANCE.resolveStationKey(staticIndexLoadOrBuildIndex$app3, str7);
                            if (strResolveStationKey != null) {
                                listEmptyList = GlobalSubwayDataManager.INSTANCE.currentStationTransferOptions$app(staticIndexLoadOrBuildIndex$app3, strResolveStationKey, subwayRoutePlan2.getPrimaryRoute().getRouteId());
                            } else {
                                listEmptyList = CollectionsKt.emptyList();
                            }
                        } else {
                            listEmptyList = CollectionsKt.emptyList();
                        }
                    }
                } else {
                    str4 = name;
                    str5 = str2;
                    str6 = "";
                    str7 = str;
                    subwayRoutePlan2 = subwayRoutePlan;
                    if (subwayCityCityOrNull.getSourceType() != GlobalSubwayDataManager.SourceType.GOOGLE) {
                        if (GlobalSubwayDataManager.SERVER_PATTERN_US_CITY_IDS.contains(this.$trip.getCityId())) {
                            this.L$0 = SpillingKt.nullOutSpilledVariable(subwayCityCityOrNull);
                            this.L$1 = subwayRoutePlan2;
                            this.L$2 = SpillingKt.nullOutSpilledVariable(subwayRouteStation);
                            this.L$3 = str7;
                            this.L$4 = str5;
                            this.L$5 = str4;
                            this.L$6 = str6;
                            this.I$0 = i;
                            this.label = 4;
                            objLoadUsServerRoutingIndex3 = GlobalSubwayDataManager.INSTANCE.loadUsServerRoutingIndex(this.$context, this.$trip.getCityId(), this);
                            if (objLoadUsServerRoutingIndex3 != coroutine_suspended) {
                                i3 = i;
                            }
                        } else {
                            staticIndexLoadOrBuildIndex$app3 = GlobalSubwayDataManager.INSTANCE.loadOrBuildIndex$app(this.$context, this.$trip.getCityId());
                        }
                        strResolveStationKey = GlobalSubwayDataManager.INSTANCE.resolveStationKey(staticIndexLoadOrBuildIndex$app3, str7);
                        if (strResolveStationKey != null) {
                            listEmptyList = GlobalSubwayDataManager.INSTANCE.currentStationTransferOptions$app(staticIndexLoadOrBuildIndex$app3, strResolveStationKey, subwayRoutePlan2.getPrimaryRoute().getRouteId());
                        } else {
                            listEmptyList = CollectionsKt.emptyList();
                        }
                    } else {
                        listEmptyList = CollectionsKt.emptyList();
                    }
                }
                return coroutine_suspended;
            }
            if (i4 == 2) {
                GlobalSubwayDataManager.SubwayCity subwayCity2 = (GlobalSubwayDataManager.SubwayCity) this.L$0;
                ResultKt.throwOnFailure(obj);
                subwayCityCityOrNull = subwayCity2;
                objLoadUsServerRoutingIndex = obj;
                staticIndexLoadOrBuildIndex$app = (GlobalSubwayDataManager.StaticIndex) objLoadUsServerRoutingIndex;
                if (staticIndexLoadOrBuildIndex$app == null) {
                    staticIndexLoadOrBuildIndex$app = GlobalSubwayDataManager.INSTANCE.loadOrBuildIndex$app(this.$context, this.$trip.getCityId());
                }
                subwayRoutePlanResolvePlan = GlobalSubwayDataManager.INSTANCE.resolvePlan(staticIndexLoadOrBuildIndex$app, this.$trip.getCityId(), this.$trip.getOrigin(), this.$trip.getDestination());
                subwayRoutePlan = subwayRoutePlanResolvePlan;
                if (subwayRoutePlan == null) {
                    return SmartSubwayTrip.m9308copydOtcBKo$default(this.$trip, null, GlobalSubwayDataManager.INSTANCE.cityName(this.$trip.getCityId()), 0L, null, null, null, this.$trip.getDestination(), null, false, false, 0L, 0L, null, null, 0.0f, null, null, 131005, null);
                }
                subwayRouteStation = (GlobalSubwayDataManager.SubwayRouteStation) CollectionsKt.firstOrNull(CollectionsKt.drop(subwayRoutePlan.getStations(), 1));
                subwayRouteStation2 = (GlobalSubwayDataManager.SubwayRouteStation) CollectionsKt.firstOrNull((List) subwayRoutePlan.getStations());
                if (subwayRouteStation2 != null || (origin = subwayRouteStation2.getName()) == null) {
                    origin = this.$trip.getOrigin();
                }
                str = origin;
                if (subwayRouteStation != null || (destination = subwayRouteStation.getName()) == null) {
                    destination = this.$trip.getDestination();
                }
                str2 = destination;
                transferStation = subwayRoutePlan.getTransferStation();
                if (transferStation != null) {
                    name = transferStation.getName();
                } else {
                    name = null;
                }
                if (name == null) {
                    name = "";
                }
                if (subwayRoutePlan.getSecondaryRoute() != null || StringsKt.isBlank(name)) {
                    i = 0;
                } else {
                    i = 1;
                }
                if (subwayCityCityOrNull.getSourceType() != GlobalSubwayDataManager.SourceType.GOOGLE) {
                    if (GlobalSubwayDataManager.SERVER_PATTERN_US_CITY_IDS.contains(this.$trip.getCityId())) {
                        this.L$0 = subwayCityCityOrNull;
                        this.L$1 = subwayRoutePlan;
                        this.L$2 = subwayRouteStation;
                        this.L$3 = str;
                        this.L$4 = str2;
                        this.L$5 = name;
                        this.I$0 = i;
                        this.label = 3;
                        objLoadUsServerRoutingIndex2 = GlobalSubwayDataManager.INSTANCE.loadUsServerRoutingIndex(this.$context, this.$trip.getCityId(), this);
                        if (objLoadUsServerRoutingIndex2 != coroutine_suspended) {
                            str3 = name;
                            i2 = i;
                            staticIndexLoadOrBuildIndex$app2 = (GlobalSubwayDataManager.StaticIndex) objLoadUsServerRoutingIndex2;
                            if (staticIndexLoadOrBuildIndex$app2 == null) {
                                staticIndexLoadOrBuildIndex$app2 = GlobalSubwayDataManager.INSTANCE.loadOrBuildIndex$app(this.$context, this.$trip.getCityId());
                            }
                            i = i2;
                            name = str3;
                            subwayRouteStation3 = (GlobalSubwayDataManager.SubwayRouteStation) CollectionsKt.firstOrNull((List) subwayRoutePlan.getStations());
                            if (subwayRouteStation3 != null) {
                                stationKey = subwayRouteStation3.getStationKey();
                            } else {
                                stationKey = null;
                            }
                            if (stationKey == null) {
                                stationKey = "";
                            }
                            if (subwayRouteStation != null) {
                                stationKey2 = subwayRouteStation.getStationKey();
                            } else {
                                stationKey2 = null;
                            }
                            if (StringsKt.isBlank(stationKey)) {
                                GlobalSubwayDataManager globalSubwayDataManager3 = GlobalSubwayDataManager.INSTANCE;
                                shortName = subwayRoutePlan.getPrimaryRoute().getShortName();
                                if (StringsKt.isBlank(shortName)) {
                                    shortName = subwayRoutePlan.getPrimaryRoute().getRouteId();
                                }
                                String strPreviousPhysicalStationFromIndex$app3 = globalSubwayDataManager3.previousPhysicalStationFromIndex$app(staticIndexLoadOrBuildIndex$app2, shortName, stationKey, stationKey2);
                                str4 = name;
                                str6 = strPreviousPhysicalStationFromIndex$app3;
                                str5 = str2;
                            } else {
                                str4 = name;
                                str5 = str2;
                                str6 = "";
                            }
                            str7 = str;
                            subwayRoutePlan2 = subwayRoutePlan;
                            if (subwayCityCityOrNull.getSourceType() != GlobalSubwayDataManager.SourceType.GOOGLE) {
                                if (GlobalSubwayDataManager.SERVER_PATTERN_US_CITY_IDS.contains(this.$trip.getCityId())) {
                                    this.L$0 = SpillingKt.nullOutSpilledVariable(subwayCityCityOrNull);
                                    this.L$1 = subwayRoutePlan2;
                                    this.L$2 = SpillingKt.nullOutSpilledVariable(subwayRouteStation);
                                    this.L$3 = str7;
                                    this.L$4 = str5;
                                    this.L$5 = str4;
                                    this.L$6 = str6;
                                    this.I$0 = i;
                                    this.label = 4;
                                    objLoadUsServerRoutingIndex3 = GlobalSubwayDataManager.INSTANCE.loadUsServerRoutingIndex(this.$context, this.$trip.getCityId(), this);
                                    if (objLoadUsServerRoutingIndex3 != coroutine_suspended) {
                                        i3 = i;
                                    }
                                } else {
                                    staticIndexLoadOrBuildIndex$app3 = GlobalSubwayDataManager.INSTANCE.loadOrBuildIndex$app(this.$context, this.$trip.getCityId());
                                }
                                strResolveStationKey = GlobalSubwayDataManager.INSTANCE.resolveStationKey(staticIndexLoadOrBuildIndex$app3, str7);
                                if (strResolveStationKey != null) {
                                    listEmptyList = GlobalSubwayDataManager.INSTANCE.currentStationTransferOptions$app(staticIndexLoadOrBuildIndex$app3, strResolveStationKey, subwayRoutePlan2.getPrimaryRoute().getRouteId());
                                } else {
                                    listEmptyList = CollectionsKt.emptyList();
                                }
                            } else {
                                listEmptyList = CollectionsKt.emptyList();
                            }
                        }
                    } else {
                        staticIndexLoadOrBuildIndex$app2 = GlobalSubwayDataManager.INSTANCE.loadOrBuildIndex$app(this.$context, this.$trip.getCityId());
                        subwayRouteStation3 = (GlobalSubwayDataManager.SubwayRouteStation) CollectionsKt.firstOrNull((List) subwayRoutePlan.getStations());
                        if (subwayRouteStation3 != null) {
                            stationKey = subwayRouteStation3.getStationKey();
                        } else {
                            stationKey = null;
                        }
                        if (stationKey == null) {
                            stationKey = "";
                        }
                        if (subwayRouteStation != null) {
                            stationKey2 = subwayRouteStation.getStationKey();
                        } else {
                            stationKey2 = null;
                        }
                        if (StringsKt.isBlank(stationKey)) {
                            GlobalSubwayDataManager globalSubwayDataManager4 = GlobalSubwayDataManager.INSTANCE;
                            shortName = subwayRoutePlan.getPrimaryRoute().getShortName();
                            if (StringsKt.isBlank(shortName)) {
                                shortName = subwayRoutePlan.getPrimaryRoute().getRouteId();
                            }
                            String strPreviousPhysicalStationFromIndex$app4 = globalSubwayDataManager4.previousPhysicalStationFromIndex$app(staticIndexLoadOrBuildIndex$app2, shortName, stationKey, stationKey2);
                            str4 = name;
                            str6 = strPreviousPhysicalStationFromIndex$app4;
                            str5 = str2;
                        } else {
                            str4 = name;
                            str5 = str2;
                            str6 = "";
                        }
                        str7 = str;
                        subwayRoutePlan2 = subwayRoutePlan;
                        if (subwayCityCityOrNull.getSourceType() != GlobalSubwayDataManager.SourceType.GOOGLE) {
                            if (GlobalSubwayDataManager.SERVER_PATTERN_US_CITY_IDS.contains(this.$trip.getCityId())) {
                                this.L$0 = SpillingKt.nullOutSpilledVariable(subwayCityCityOrNull);
                                this.L$1 = subwayRoutePlan2;
                                this.L$2 = SpillingKt.nullOutSpilledVariable(subwayRouteStation);
                                this.L$3 = str7;
                                this.L$4 = str5;
                                this.L$5 = str4;
                                this.L$6 = str6;
                                this.I$0 = i;
                                this.label = 4;
                                objLoadUsServerRoutingIndex3 = GlobalSubwayDataManager.INSTANCE.loadUsServerRoutingIndex(this.$context, this.$trip.getCityId(), this);
                                if (objLoadUsServerRoutingIndex3 != coroutine_suspended) {
                                    i3 = i;
                                }
                            } else {
                                staticIndexLoadOrBuildIndex$app3 = GlobalSubwayDataManager.INSTANCE.loadOrBuildIndex$app(this.$context, this.$trip.getCityId());
                            }
                            strResolveStationKey = GlobalSubwayDataManager.INSTANCE.resolveStationKey(staticIndexLoadOrBuildIndex$app3, str7);
                            if (strResolveStationKey != null) {
                                listEmptyList = GlobalSubwayDataManager.INSTANCE.currentStationTransferOptions$app(staticIndexLoadOrBuildIndex$app3, strResolveStationKey, subwayRoutePlan2.getPrimaryRoute().getRouteId());
                            } else {
                                listEmptyList = CollectionsKt.emptyList();
                            }
                        } else {
                            listEmptyList = CollectionsKt.emptyList();
                        }
                    }
                } else {
                    str4 = name;
                    str5 = str2;
                    str6 = "";
                    str7 = str;
                    subwayRoutePlan2 = subwayRoutePlan;
                    if (subwayCityCityOrNull.getSourceType() != GlobalSubwayDataManager.SourceType.GOOGLE) {
                        if (GlobalSubwayDataManager.SERVER_PATTERN_US_CITY_IDS.contains(this.$trip.getCityId())) {
                            this.L$0 = SpillingKt.nullOutSpilledVariable(subwayCityCityOrNull);
                            this.L$1 = subwayRoutePlan2;
                            this.L$2 = SpillingKt.nullOutSpilledVariable(subwayRouteStation);
                            this.L$3 = str7;
                            this.L$4 = str5;
                            this.L$5 = str4;
                            this.L$6 = str6;
                            this.I$0 = i;
                            this.label = 4;
                            objLoadUsServerRoutingIndex3 = GlobalSubwayDataManager.INSTANCE.loadUsServerRoutingIndex(this.$context, this.$trip.getCityId(), this);
                            if (objLoadUsServerRoutingIndex3 != coroutine_suspended) {
                                i3 = i;
                            }
                        } else {
                            staticIndexLoadOrBuildIndex$app3 = GlobalSubwayDataManager.INSTANCE.loadOrBuildIndex$app(this.$context, this.$trip.getCityId());
                        }
                        strResolveStationKey = GlobalSubwayDataManager.INSTANCE.resolveStationKey(staticIndexLoadOrBuildIndex$app3, str7);
                        if (strResolveStationKey != null) {
                            listEmptyList = GlobalSubwayDataManager.INSTANCE.currentStationTransferOptions$app(staticIndexLoadOrBuildIndex$app3, strResolveStationKey, subwayRoutePlan2.getPrimaryRoute().getRouteId());
                        } else {
                            listEmptyList = CollectionsKt.emptyList();
                        }
                    } else {
                        listEmptyList = CollectionsKt.emptyList();
                    }
                }
                return coroutine_suspended;
            }
            if (i4 == 3) {
                i2 = this.I$0;
                str3 = (String) this.L$5;
                str2 = (String) this.L$4;
                str = (String) this.L$3;
                subwayRouteStation = (GlobalSubwayDataManager.SubwayRouteStation) this.L$2;
                subwayRoutePlan = (GlobalSubwayDataManager.SubwayRoutePlan) this.L$1;
                subwayCityCityOrNull = (GlobalSubwayDataManager.SubwayCity) this.L$0;
                ResultKt.throwOnFailure(obj);
                objLoadUsServerRoutingIndex2 = obj;
                staticIndexLoadOrBuildIndex$app2 = (GlobalSubwayDataManager.StaticIndex) objLoadUsServerRoutingIndex2;
                if (staticIndexLoadOrBuildIndex$app2 == null) {
                    staticIndexLoadOrBuildIndex$app2 = GlobalSubwayDataManager.INSTANCE.loadOrBuildIndex$app(this.$context, this.$trip.getCityId());
                }
                i = i2;
                name = str3;
                subwayRouteStation3 = (GlobalSubwayDataManager.SubwayRouteStation) CollectionsKt.firstOrNull((List) subwayRoutePlan.getStations());
                if (subwayRouteStation3 != null) {
                    stationKey = subwayRouteStation3.getStationKey();
                } else {
                    stationKey = null;
                }
                if (stationKey == null) {
                    stationKey = "";
                }
                if (subwayRouteStation != null) {
                    stationKey2 = subwayRouteStation.getStationKey();
                } else {
                    stationKey2 = null;
                }
                if (StringsKt.isBlank(stationKey)) {
                    GlobalSubwayDataManager globalSubwayDataManager5 = GlobalSubwayDataManager.INSTANCE;
                    shortName = subwayRoutePlan.getPrimaryRoute().getShortName();
                    if (StringsKt.isBlank(shortName)) {
                        shortName = subwayRoutePlan.getPrimaryRoute().getRouteId();
                    }
                    String strPreviousPhysicalStationFromIndex$app5 = globalSubwayDataManager5.previousPhysicalStationFromIndex$app(staticIndexLoadOrBuildIndex$app2, shortName, stationKey, stationKey2);
                    str4 = name;
                    str6 = strPreviousPhysicalStationFromIndex$app5;
                    str5 = str2;
                } else {
                    str4 = name;
                    str5 = str2;
                    str6 = "";
                }
                str7 = str;
                subwayRoutePlan2 = subwayRoutePlan;
                if (subwayCityCityOrNull.getSourceType() != GlobalSubwayDataManager.SourceType.GOOGLE) {
                    if (GlobalSubwayDataManager.SERVER_PATTERN_US_CITY_IDS.contains(this.$trip.getCityId())) {
                        this.L$0 = SpillingKt.nullOutSpilledVariable(subwayCityCityOrNull);
                        this.L$1 = subwayRoutePlan2;
                        this.L$2 = SpillingKt.nullOutSpilledVariable(subwayRouteStation);
                        this.L$3 = str7;
                        this.L$4 = str5;
                        this.L$5 = str4;
                        this.L$6 = str6;
                        this.I$0 = i;
                        this.label = 4;
                        objLoadUsServerRoutingIndex3 = GlobalSubwayDataManager.INSTANCE.loadUsServerRoutingIndex(this.$context, this.$trip.getCityId(), this);
                        if (objLoadUsServerRoutingIndex3 != coroutine_suspended) {
                            i3 = i;
                        }
                        return coroutine_suspended;
                    }
                    staticIndexLoadOrBuildIndex$app3 = GlobalSubwayDataManager.INSTANCE.loadOrBuildIndex$app(this.$context, this.$trip.getCityId());
                    strResolveStationKey = GlobalSubwayDataManager.INSTANCE.resolveStationKey(staticIndexLoadOrBuildIndex$app3, str7);
                    if (strResolveStationKey != null) {
                        listEmptyList = GlobalSubwayDataManager.INSTANCE.currentStationTransferOptions$app(staticIndexLoadOrBuildIndex$app3, strResolveStationKey, subwayRoutePlan2.getPrimaryRoute().getRouteId());
                    } else {
                        listEmptyList = CollectionsKt.emptyList();
                    }
                } else {
                    listEmptyList = CollectionsKt.emptyList();
                }
            } else {
                if (i4 != 4) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                i3 = this.I$0;
                str6 = (String) this.L$6;
                String str8 = (String) this.L$5;
                str5 = (String) this.L$4;
                str7 = (String) this.L$3;
                subwayRoutePlan2 = (GlobalSubwayDataManager.SubwayRoutePlan) this.L$1;
                ResultKt.throwOnFailure(obj);
                str4 = str8;
                objLoadUsServerRoutingIndex3 = obj;
            }
            staticIndexLoadOrBuildIndex$app3 = (GlobalSubwayDataManager.StaticIndex) objLoadUsServerRoutingIndex3;
            if (staticIndexLoadOrBuildIndex$app3 == null) {
                staticIndexLoadOrBuildIndex$app3 = GlobalSubwayDataManager.INSTANCE.loadOrBuildIndex$app(this.$context, this.$trip.getCityId());
            }
            i = i3;
            strResolveStationKey = GlobalSubwayDataManager.INSTANCE.resolveStationKey(staticIndexLoadOrBuildIndex$app3, str7);
            if (strResolveStationKey != null) {
                listEmptyList = GlobalSubwayDataManager.INSTANCE.currentStationTransferOptions$app(staticIndexLoadOrBuildIndex$app3, strResolveStationKey, subwayRoutePlan2.getPrimaryRoute().getRouteId());
            } else {
                listEmptyList = CollectionsKt.emptyList();
            }
        } else {
            ResultKt.throwOnFailure(obj);
            subwayCityCityOrNull = GlobalSubwayDataManager.INSTANCE.cityOrNull(this.$trip.getCityId());
            if (subwayCityCityOrNull == null) {
                return this.$trip;
            }
            if (subwayCityCityOrNull.getSourceType() == GlobalSubwayDataManager.SourceType.GOOGLE) {
                this.L$0 = subwayCityCityOrNull;
                this.label = 1;
                objGoogleResolvePlan = GlobalSubwayDataManager.INSTANCE.googleResolvePlan(this.$context, subwayCityCityOrNull, this.$trip.getOrigin(), this.$trip.getDestination(), this);
            } else if (GlobalSubwayDataManager.SERVER_PATTERN_US_CITY_IDS.contains(this.$trip.getCityId())) {
                this.L$0 = subwayCityCityOrNull;
                this.label = 2;
                objLoadUsServerRoutingIndex = GlobalSubwayDataManager.INSTANCE.loadUsServerRoutingIndex(this.$context, this.$trip.getCityId(), this);
            } else {
                staticIndexLoadOrBuildIndex$app = GlobalSubwayDataManager.INSTANCE.loadOrBuildIndex$app(this.$context, this.$trip.getCityId());
                subwayRoutePlanResolvePlan = GlobalSubwayDataManager.INSTANCE.resolvePlan(staticIndexLoadOrBuildIndex$app, this.$trip.getCityId(), this.$trip.getOrigin(), this.$trip.getDestination());
                subwayRoutePlan = subwayRoutePlanResolvePlan;
                if (subwayRoutePlan == null) {
                    return SmartSubwayTrip.m9308copydOtcBKo$default(this.$trip, null, GlobalSubwayDataManager.INSTANCE.cityName(this.$trip.getCityId()), 0L, null, null, null, this.$trip.getDestination(), null, false, false, 0L, 0L, null, null, 0.0f, null, null, 131005, null);
                }
                subwayRouteStation = (GlobalSubwayDataManager.SubwayRouteStation) CollectionsKt.firstOrNull(CollectionsKt.drop(subwayRoutePlan.getStations(), 1));
                subwayRouteStation2 = (GlobalSubwayDataManager.SubwayRouteStation) CollectionsKt.firstOrNull((List) subwayRoutePlan.getStations());
                if (subwayRouteStation2 != null) {
                    origin = this.$trip.getOrigin();
                } else {
                    origin = this.$trip.getOrigin();
                }
                str = origin;
                if (subwayRouteStation != null) {
                    destination = this.$trip.getDestination();
                } else {
                    destination = this.$trip.getDestination();
                }
                str2 = destination;
                transferStation = subwayRoutePlan.getTransferStation();
                if (transferStation != null) {
                    name = transferStation.getName();
                } else {
                    name = null;
                }
                if (name == null) {
                    name = "";
                }
                if (subwayRoutePlan.getSecondaryRoute() != null) {
                    i = 0;
                } else {
                    i = 0;
                }
                if (subwayCityCityOrNull.getSourceType() != GlobalSubwayDataManager.SourceType.GOOGLE) {
                    if (GlobalSubwayDataManager.SERVER_PATTERN_US_CITY_IDS.contains(this.$trip.getCityId())) {
                        this.L$0 = subwayCityCityOrNull;
                        this.L$1 = subwayRoutePlan;
                        this.L$2 = subwayRouteStation;
                        this.L$3 = str;
                        this.L$4 = str2;
                        this.L$5 = name;
                        this.I$0 = i;
                        this.label = 3;
                        objLoadUsServerRoutingIndex2 = GlobalSubwayDataManager.INSTANCE.loadUsServerRoutingIndex(this.$context, this.$trip.getCityId(), this);
                        if (objLoadUsServerRoutingIndex2 != coroutine_suspended) {
                            str3 = name;
                            i2 = i;
                            staticIndexLoadOrBuildIndex$app2 = (GlobalSubwayDataManager.StaticIndex) objLoadUsServerRoutingIndex2;
                            if (staticIndexLoadOrBuildIndex$app2 == null) {
                                staticIndexLoadOrBuildIndex$app2 = GlobalSubwayDataManager.INSTANCE.loadOrBuildIndex$app(this.$context, this.$trip.getCityId());
                            }
                            i = i2;
                            name = str3;
                            subwayRouteStation3 = (GlobalSubwayDataManager.SubwayRouteStation) CollectionsKt.firstOrNull((List) subwayRoutePlan.getStations());
                            if (subwayRouteStation3 != null) {
                                stationKey = subwayRouteStation3.getStationKey();
                            } else {
                                stationKey = null;
                            }
                            if (stationKey == null) {
                                stationKey = "";
                            }
                            if (subwayRouteStation != null) {
                                stationKey2 = subwayRouteStation.getStationKey();
                            } else {
                                stationKey2 = null;
                            }
                            if (StringsKt.isBlank(stationKey)) {
                                GlobalSubwayDataManager globalSubwayDataManager6 = GlobalSubwayDataManager.INSTANCE;
                                shortName = subwayRoutePlan.getPrimaryRoute().getShortName();
                                if (StringsKt.isBlank(shortName)) {
                                    shortName = subwayRoutePlan.getPrimaryRoute().getRouteId();
                                }
                                String strPreviousPhysicalStationFromIndex$app6 = globalSubwayDataManager6.previousPhysicalStationFromIndex$app(staticIndexLoadOrBuildIndex$app2, shortName, stationKey, stationKey2);
                                str4 = name;
                                str6 = strPreviousPhysicalStationFromIndex$app6;
                                str5 = str2;
                            } else {
                                str4 = name;
                                str5 = str2;
                                str6 = "";
                            }
                            str7 = str;
                            subwayRoutePlan2 = subwayRoutePlan;
                            if (subwayCityCityOrNull.getSourceType() != GlobalSubwayDataManager.SourceType.GOOGLE) {
                                if (GlobalSubwayDataManager.SERVER_PATTERN_US_CITY_IDS.contains(this.$trip.getCityId())) {
                                    this.L$0 = SpillingKt.nullOutSpilledVariable(subwayCityCityOrNull);
                                    this.L$1 = subwayRoutePlan2;
                                    this.L$2 = SpillingKt.nullOutSpilledVariable(subwayRouteStation);
                                    this.L$3 = str7;
                                    this.L$4 = str5;
                                    this.L$5 = str4;
                                    this.L$6 = str6;
                                    this.I$0 = i;
                                    this.label = 4;
                                    objLoadUsServerRoutingIndex3 = GlobalSubwayDataManager.INSTANCE.loadUsServerRoutingIndex(this.$context, this.$trip.getCityId(), this);
                                    if (objLoadUsServerRoutingIndex3 != coroutine_suspended) {
                                        i3 = i;
                                        staticIndexLoadOrBuildIndex$app3 = (GlobalSubwayDataManager.StaticIndex) objLoadUsServerRoutingIndex3;
                                        if (staticIndexLoadOrBuildIndex$app3 == null) {
                                            staticIndexLoadOrBuildIndex$app3 = GlobalSubwayDataManager.INSTANCE.loadOrBuildIndex$app(this.$context, this.$trip.getCityId());
                                        }
                                        i = i3;
                                    }
                                } else {
                                    staticIndexLoadOrBuildIndex$app3 = GlobalSubwayDataManager.INSTANCE.loadOrBuildIndex$app(this.$context, this.$trip.getCityId());
                                }
                                strResolveStationKey = GlobalSubwayDataManager.INSTANCE.resolveStationKey(staticIndexLoadOrBuildIndex$app3, str7);
                                if (strResolveStationKey != null) {
                                    listEmptyList = GlobalSubwayDataManager.INSTANCE.currentStationTransferOptions$app(staticIndexLoadOrBuildIndex$app3, strResolveStationKey, subwayRoutePlan2.getPrimaryRoute().getRouteId());
                                } else {
                                    listEmptyList = CollectionsKt.emptyList();
                                }
                            } else {
                                listEmptyList = CollectionsKt.emptyList();
                            }
                        }
                    } else {
                        staticIndexLoadOrBuildIndex$app2 = GlobalSubwayDataManager.INSTANCE.loadOrBuildIndex$app(this.$context, this.$trip.getCityId());
                        subwayRouteStation3 = (GlobalSubwayDataManager.SubwayRouteStation) CollectionsKt.firstOrNull((List) subwayRoutePlan.getStations());
                        if (subwayRouteStation3 != null) {
                            stationKey = subwayRouteStation3.getStationKey();
                        } else {
                            stationKey = null;
                        }
                        if (stationKey == null) {
                            stationKey = "";
                        }
                        if (subwayRouteStation != null) {
                            stationKey2 = subwayRouteStation.getStationKey();
                        } else {
                            stationKey2 = null;
                        }
                        if (StringsKt.isBlank(stationKey)) {
                            GlobalSubwayDataManager globalSubwayDataManager7 = GlobalSubwayDataManager.INSTANCE;
                            shortName = subwayRoutePlan.getPrimaryRoute().getShortName();
                            if (StringsKt.isBlank(shortName)) {
                                shortName = subwayRoutePlan.getPrimaryRoute().getRouteId();
                            }
                            String strPreviousPhysicalStationFromIndex$app7 = globalSubwayDataManager7.previousPhysicalStationFromIndex$app(staticIndexLoadOrBuildIndex$app2, shortName, stationKey, stationKey2);
                            str4 = name;
                            str6 = strPreviousPhysicalStationFromIndex$app7;
                            str5 = str2;
                        } else {
                            str4 = name;
                            str5 = str2;
                            str6 = "";
                        }
                        str7 = str;
                        subwayRoutePlan2 = subwayRoutePlan;
                        if (subwayCityCityOrNull.getSourceType() != GlobalSubwayDataManager.SourceType.GOOGLE) {
                            if (GlobalSubwayDataManager.SERVER_PATTERN_US_CITY_IDS.contains(this.$trip.getCityId())) {
                                this.L$0 = SpillingKt.nullOutSpilledVariable(subwayCityCityOrNull);
                                this.L$1 = subwayRoutePlan2;
                                this.L$2 = SpillingKt.nullOutSpilledVariable(subwayRouteStation);
                                this.L$3 = str7;
                                this.L$4 = str5;
                                this.L$5 = str4;
                                this.L$6 = str6;
                                this.I$0 = i;
                                this.label = 4;
                                objLoadUsServerRoutingIndex3 = GlobalSubwayDataManager.INSTANCE.loadUsServerRoutingIndex(this.$context, this.$trip.getCityId(), this);
                                if (objLoadUsServerRoutingIndex3 != coroutine_suspended) {
                                    i3 = i;
                                    staticIndexLoadOrBuildIndex$app3 = (GlobalSubwayDataManager.StaticIndex) objLoadUsServerRoutingIndex3;
                                    if (staticIndexLoadOrBuildIndex$app3 == null) {
                                        staticIndexLoadOrBuildIndex$app3 = GlobalSubwayDataManager.INSTANCE.loadOrBuildIndex$app(this.$context, this.$trip.getCityId());
                                    }
                                    i = i3;
                                }
                            } else {
                                staticIndexLoadOrBuildIndex$app3 = GlobalSubwayDataManager.INSTANCE.loadOrBuildIndex$app(this.$context, this.$trip.getCityId());
                            }
                            strResolveStationKey = GlobalSubwayDataManager.INSTANCE.resolveStationKey(staticIndexLoadOrBuildIndex$app3, str7);
                            if (strResolveStationKey != null) {
                                listEmptyList = GlobalSubwayDataManager.INSTANCE.currentStationTransferOptions$app(staticIndexLoadOrBuildIndex$app3, strResolveStationKey, subwayRoutePlan2.getPrimaryRoute().getRouteId());
                            } else {
                                listEmptyList = CollectionsKt.emptyList();
                            }
                        } else {
                            listEmptyList = CollectionsKt.emptyList();
                        }
                    }
                } else {
                    str4 = name;
                    str5 = str2;
                    str6 = "";
                    str7 = str;
                    subwayRoutePlan2 = subwayRoutePlan;
                    if (subwayCityCityOrNull.getSourceType() != GlobalSubwayDataManager.SourceType.GOOGLE) {
                        if (GlobalSubwayDataManager.SERVER_PATTERN_US_CITY_IDS.contains(this.$trip.getCityId())) {
                            this.L$0 = SpillingKt.nullOutSpilledVariable(subwayCityCityOrNull);
                            this.L$1 = subwayRoutePlan2;
                            this.L$2 = SpillingKt.nullOutSpilledVariable(subwayRouteStation);
                            this.L$3 = str7;
                            this.L$4 = str5;
                            this.L$5 = str4;
                            this.L$6 = str6;
                            this.I$0 = i;
                            this.label = 4;
                            objLoadUsServerRoutingIndex3 = GlobalSubwayDataManager.INSTANCE.loadUsServerRoutingIndex(this.$context, this.$trip.getCityId(), this);
                            if (objLoadUsServerRoutingIndex3 != coroutine_suspended) {
                                i3 = i;
                                staticIndexLoadOrBuildIndex$app3 = (GlobalSubwayDataManager.StaticIndex) objLoadUsServerRoutingIndex3;
                                if (staticIndexLoadOrBuildIndex$app3 == null) {
                                    staticIndexLoadOrBuildIndex$app3 = GlobalSubwayDataManager.INSTANCE.loadOrBuildIndex$app(this.$context, this.$trip.getCityId());
                                }
                                i = i3;
                            }
                        } else {
                            staticIndexLoadOrBuildIndex$app3 = GlobalSubwayDataManager.INSTANCE.loadOrBuildIndex$app(this.$context, this.$trip.getCityId());
                        }
                        strResolveStationKey = GlobalSubwayDataManager.INSTANCE.resolveStationKey(staticIndexLoadOrBuildIndex$app3, str7);
                        if (strResolveStationKey != null) {
                            listEmptyList = GlobalSubwayDataManager.INSTANCE.currentStationTransferOptions$app(staticIndexLoadOrBuildIndex$app3, strResolveStationKey, subwayRoutePlan2.getPrimaryRoute().getRouteId());
                        } else {
                            listEmptyList = CollectionsKt.emptyList();
                        }
                    } else {
                        listEmptyList = CollectionsKt.emptyList();
                    }
                }
            }
            return coroutine_suspended;
        }
        List<String> list = listEmptyList;
        String str9 = str6;
        String str10 = str4;
        String str11 = str5;
        String str12 = str7;
        String strCityName = GlobalSubwayDataManager.INSTANCE.cityName(this.$trip.getCityId());
        String shortName2 = subwayRoutePlan2.getPrimaryRoute().getShortName();
        if (StringsKt.isBlank(shortName2)) {
            shortName2 = subwayRoutePlan2.getPrimaryRoute().getRouteId();
        }
        String str13 = shortName2;
        long jColor = ColorKt.Color(subwayRoutePlan2.getPrimaryRoute().getColor());
        GlobalSubwayDataManager.SubwayRouteInfo secondaryRoute = subwayRoutePlan2.getSecondaryRoute();
        if (secondaryRoute == null) {
            secondaryRoute = subwayRoutePlan2.getPrimaryRoute();
        }
        long jColor2 = ColorKt.Color(secondaryRoute.getColor());
        GlobalSubwayDataManager.SubwayRouteInfo secondaryRoute2 = subwayRoutePlan2.getSecondaryRoute();
        String shortName3 = secondaryRoute2 != null ? secondaryRoute2.getShortName() : null;
        return SmartSubwayTrip.m9308copydOtcBKo$default(this.$trip, null, strCityName, 0L, null, null, str12, str11, str13, i != 0, false, jColor, jColor2, str10, str9, 0.0f, shortName3 == null ? "" : shortName3, list, 16413, null);
    }
}
