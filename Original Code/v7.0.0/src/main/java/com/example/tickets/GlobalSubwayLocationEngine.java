package com.example.tickets;

import android.content.Context;
import android.location.LocationManager;
import android.os.Looper;
import androidx.camera.video.AudioStats;
import androidx.core.content.ContextCompat;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: GlobalSubwayData.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\f\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011J4\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00152\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00130\u0017H\u0081@¢\u0006\u0004\b\u0018\u0010\u0019J2\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00152\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00130\u0017H\u0083@¢\u0006\u0002\u0010\u0019J2\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00152\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00130\u0017H\u0083@¢\u0006\u0002\u0010\u0019J(\u0010\u001c\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020\t2\u0006\u0010 \u001a\u00020\tH\u0002J\u0016\u0010!\u001a\u00020\t2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020$0#H\u0002J&\u0010%\u001a\u00020\t2\u0006\u0010&\u001a\u00020\t2\u0006\u0010'\u001a\u00020\t2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020$0#H\u0002J&\u0010(\u001a\u00020\t2\u0006\u0010&\u001a\u00020\t2\u0006\u0010'\u001a\u00020\t2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020$0#H\u0002J8\u0010)\u001a\u00020\u00072\u0006\u0010*\u001a\u00020\t2\u0006\u0010+\u001a\u00020\t2\u0006\u0010,\u001a\u00020\t2\u0006\u0010-\u001a\u00020\t2\u0006\u0010.\u001a\u00020\t2\u0006\u0010/\u001a\u00020\tH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000¨\u00060"}, d2 = {"Lcom/example/tickets/GlobalSubwayLocationEngine;", "", "<init>", "()V", "UPDATE_INTERVAL_MS", "", "MIN_DISTANCE_M", "", "STATION_REACHED_RADIUS_M", "", "MAX_ACCURACY_FOR_STATION_JUMP_M", "GOOGLE_NEARBY_REFRESH_MS", "GOOGLE_NEARBY_RADIUS_M", "GOOGLE_ROUTE_CORRIDOR_M", "hasLocationPermission", "", "context", "Landroid/content/Context;", "trackTrip", "", "initialTrip", "Lcom/example/tickets/SmartSubwayTrip;", "onUpdate", "Lkotlin/Function1;", "trackTrip$app", "(Landroid/content/Context;Lcom/example/tickets/SmartSubwayTrip;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "trackStaticTrip", "trackGoogleTrip", "distanceMeters", "lat1", "lon1", "lat2", "lon2", "totalPathLength", "path", "", "Lcom/example/tickets/GlobalSubwayDataManager$RoutePoint;", "projectDistanceOnPath", "latitude", "longitude", "nearestDistanceToPath", "projectToSegment", "pointLat", "pointLon", "startLat", "startLon", "endLat", "endLon", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class GlobalSubwayLocationEngine {
    public static final int $stable = 0;
    private static final double GOOGLE_NEARBY_RADIUS_M = 2500.0d;
    private static final long GOOGLE_NEARBY_REFRESH_MS = 15000;
    private static final double GOOGLE_ROUTE_CORRIDOR_M = 180.0d;
    public static final GlobalSubwayLocationEngine INSTANCE = new GlobalSubwayLocationEngine();
    private static final double MAX_ACCURACY_FOR_STATION_JUMP_M = 120.0d;
    private static final float MIN_DISTANCE_M = 4.0f;
    private static final double STATION_REACHED_RADIUS_M = 65.0d;
    private static final long UPDATE_INTERVAL_MS = 1000;

    /* JADX INFO: renamed from: com.example.tickets.GlobalSubwayLocationEngine$trackGoogleTrip$1, reason: invalid class name */
    /* JADX INFO: compiled from: GlobalSubwayData.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.tickets.GlobalSubwayLocationEngine", f = "GlobalSubwayData.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4}, l = {4116, 4559, 4574, 4578, 4578}, m = "trackGoogleTrip", n = {"context", "initialTrip", "onUpdate", "locationManager", "providers", "context", "initialTrip", "onUpdate", "locationManager", "providers", "plan", "routePath", "planStops", "stopPositions", "knownStops", "nearbyLock", "lastNearbyRefresh", "nearbyRefreshScope", "current", "currentPosition", "previousStation", "lastLocation", "lastTimeMs", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "requestedProviders", "routeLengthMeters", "startsAtPlanOrigin", "context", "initialTrip", "onUpdate", "locationManager", "providers", "plan", "routePath", "planStops", "stopPositions", "knownStops", "nearbyLock", "lastNearbyRefresh", "nearbyRefreshScope", "current", "currentPosition", "previousStation", "lastLocation", "lastTimeMs", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "requestedProviders", "routeLengthMeters", "startsAtPlanOrigin", "context", "initialTrip", "onUpdate", "locationManager", "providers", "plan", "routePath", "planStops", "stopPositions", "knownStops", "nearbyLock", "lastNearbyRefresh", "nearbyRefreshScope", "current", "currentPosition", "previousStation", "lastLocation", "lastTimeMs", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "requestedProviders", "routeLengthMeters", "startsAtPlanOrigin", "context", "initialTrip", "onUpdate", "locationManager", "providers", "plan", "routePath", "planStops", "stopPositions", "knownStops", "nearbyLock", "lastNearbyRefresh", "nearbyRefreshScope", "current", "currentPosition", "previousStation", "lastLocation", "lastTimeMs", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "requestedProviders", "routeLengthMeters", "startsAtPlanOrigin"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "D$0", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "D$0", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "D$0", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "D$0", "I$0"})
    static final class AnonymousClass1 extends ContinuationImpl {
        double D$0;
        int I$0;
        Object L$0;
        Object L$1;
        Object L$10;
        Object L$11;
        Object L$12;
        Object L$13;
        Object L$14;
        Object L$15;
        Object L$16;
        Object L$17;
        Object L$18;
        Object L$19;
        Object L$2;
        Object L$20;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return GlobalSubwayLocationEngine.this.trackGoogleTrip(null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.example.tickets.GlobalSubwayLocationEngine$trackStaticTrip$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: GlobalSubwayData.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.tickets.GlobalSubwayLocationEngine", f = "GlobalSubwayData.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4}, l = {3801, 4070, 4085, 4089, 4089}, m = "trackStaticTrip", n = {"context", "initialTrip", "onUpdate", "locationManager", "providers", "current", "lastLocation", "lastTimeMs", "context", "initialTrip", "onUpdate", "locationManager", "providers", "current", "lastLocation", "lastTimeMs", "activePlan", "currentIndex", "routeInfoById", "staticIndex", "segmentProgress", "previousStation", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "requestedProviders", "context", "initialTrip", "onUpdate", "locationManager", "providers", "current", "lastLocation", "lastTimeMs", "activePlan", "currentIndex", "routeInfoById", "staticIndex", "segmentProgress", "previousStation", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "requestedProviders", "context", "initialTrip", "onUpdate", "locationManager", "providers", "current", "lastLocation", "lastTimeMs", "activePlan", "currentIndex", "routeInfoById", "staticIndex", "segmentProgress", "previousStation", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "requestedProviders", "context", "initialTrip", "onUpdate", "locationManager", "providers", "current", "lastLocation", "lastTimeMs", "activePlan", "currentIndex", "routeInfoById", "staticIndex", "segmentProgress", "previousStation", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "requestedProviders"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15"})
    static final class C03401 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$10;
        Object L$11;
        Object L$12;
        Object L$13;
        Object L$14;
        Object L$15;
        Object L$16;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        int label;
        /* synthetic */ Object result;

        C03401(Continuation<? super C03401> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return GlobalSubwayLocationEngine.this.trackStaticTrip(null, null, null, this);
        }
    }

    private GlobalSubwayLocationEngine() {
    }

    public final boolean hasLocationPermission(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return (ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_FINE_LOCATION") == 0) || (ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_COARSE_LOCATION") == 0);
    }

    /* JADX WARN: Code duplicated, block: B:43:0x00f3  */
    /* JADX WARN: Code duplicated, block: B:45:0x00f6  */
    /* JADX WARN: Code duplicated, block: B:47:0x00fe  */
    /* JADX WARN: Code duplicated, block: B:52:0x012a  */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0124, code lost:
    
        if (trackGoogleTrip(r10, r11, r13, r0) == r1) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0150, code lost:
    
        if (trackStaticTrip(r10, r11, r13, r0) == r1) goto L54;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object trackTrip$app(Context context, SmartSubwayTrip smartSubwayTrip, Function1<? super SmartSubwayTrip, Unit> function1, Continuation<? super Unit> continuation) {
        GlobalSubwayLocationEngine$trackTrip$1 globalSubwayLocationEngine$trackTrip$1;
        GlobalSubwayDataManager.SubwayCity subwayCityCityOrNull;
        int i;
        Object objPrepareTrip$app;
        SmartSubwayTrip smartSubwayTrip2;
        GlobalSubwayDataManager.SubwayCity subwayCity;
        Function1<? super SmartSubwayTrip, Unit> function2;
        int i2;
        GlobalSubwayDataManager.SubwayCity subwayCity2;
        if (continuation instanceof GlobalSubwayLocationEngine$trackTrip$1) {
            globalSubwayLocationEngine$trackTrip$1 = (GlobalSubwayLocationEngine$trackTrip$1) continuation;
            if ((globalSubwayLocationEngine$trackTrip$1.label & Integer.MIN_VALUE) != 0) {
                globalSubwayLocationEngine$trackTrip$1.label -= Integer.MIN_VALUE;
            } else {
                globalSubwayLocationEngine$trackTrip$1 = new GlobalSubwayLocationEngine$trackTrip$1(this, continuation);
            }
        } else {
            globalSubwayLocationEngine$trackTrip$1 = new GlobalSubwayLocationEngine$trackTrip$1(this, continuation);
        }
        Object obj = globalSubwayLocationEngine$trackTrip$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = globalSubwayLocationEngine$trackTrip$1.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            subwayCityCityOrNull = GlobalSubwayDataManager.INSTANCE.cityOrNull(smartSubwayTrip.getCityId());
            if (subwayCityCityOrNull == null) {
                function1.invoke(smartSubwayTrip);
                return Unit.INSTANCE;
            }
            i = (Intrinsics.areEqual(smartSubwayTrip.getNextStation(), "正在加载路线…") || Intrinsics.areEqual(smartSubwayTrip.getNextStation(), "正在加载路线...")) ? 1 : 0;
            if (i != 0) {
                try {
                    GlobalSubwayDataManager globalSubwayDataManager = GlobalSubwayDataManager.INSTANCE;
                    globalSubwayLocationEngine$trackTrip$1.L$0 = context;
                    globalSubwayLocationEngine$trackTrip$1.L$1 = smartSubwayTrip;
                    globalSubwayLocationEngine$trackTrip$1.L$2 = function1;
                    globalSubwayLocationEngine$trackTrip$1.L$3 = subwayCityCityOrNull;
                    globalSubwayLocationEngine$trackTrip$1.I$0 = i;
                    globalSubwayLocationEngine$trackTrip$1.label = 1;
                    objPrepareTrip$app = globalSubwayDataManager.prepareTrip$app(context, smartSubwayTrip, globalSubwayLocationEngine$trackTrip$1);
                    if (objPrepareTrip$app != coroutine_suspended) {
                        smartSubwayTrip2 = smartSubwayTrip;
                        subwayCity = subwayCityCityOrNull;
                        function2 = function1;
                        int i4 = i;
                        subwayCity2 = subwayCity;
                        smartSubwayTrip = (SmartSubwayTrip) objPrepareTrip$app;
                        i2 = i4;
                        function2.invoke(smartSubwayTrip);
                        if (!hasLocationPermission(context)) {
                            return Unit.INSTANCE;
                        }
                        if (subwayCity2.getSourceType() == GlobalSubwayDataManager.SourceType.GOOGLE) {
                            globalSubwayLocationEngine$trackTrip$1.L$0 = SpillingKt.nullOutSpilledVariable(context);
                            globalSubwayLocationEngine$trackTrip$1.L$1 = SpillingKt.nullOutSpilledVariable(smartSubwayTrip2);
                            globalSubwayLocationEngine$trackTrip$1.L$2 = SpillingKt.nullOutSpilledVariable(function2);
                            globalSubwayLocationEngine$trackTrip$1.L$3 = SpillingKt.nullOutSpilledVariable(subwayCity2);
                            globalSubwayLocationEngine$trackTrip$1.L$4 = SpillingKt.nullOutSpilledVariable(smartSubwayTrip);
                            globalSubwayLocationEngine$trackTrip$1.I$0 = i2;
                            globalSubwayLocationEngine$trackTrip$1.label = 2;
                        } else {
                            globalSubwayLocationEngine$trackTrip$1.L$0 = SpillingKt.nullOutSpilledVariable(context);
                            globalSubwayLocationEngine$trackTrip$1.L$1 = SpillingKt.nullOutSpilledVariable(smartSubwayTrip2);
                            globalSubwayLocationEngine$trackTrip$1.L$2 = SpillingKt.nullOutSpilledVariable(function2);
                            globalSubwayLocationEngine$trackTrip$1.L$3 = SpillingKt.nullOutSpilledVariable(subwayCity2);
                            globalSubwayLocationEngine$trackTrip$1.L$4 = SpillingKt.nullOutSpilledVariable(smartSubwayTrip);
                            globalSubwayLocationEngine$trackTrip$1.I$0 = i2;
                            globalSubwayLocationEngine$trackTrip$1.label = 3;
                        }
                    }
                } catch (Throwable unused) {
                }
                return coroutine_suspended;
            }
            i2 = i;
            subwayCity2 = subwayCityCityOrNull;
            function2 = function1;
            smartSubwayTrip2 = smartSubwayTrip;
            function2.invoke(smartSubwayTrip);
            if (!hasLocationPermission(context)) {
                return Unit.INSTANCE;
            }
            if (subwayCity2.getSourceType() == GlobalSubwayDataManager.SourceType.GOOGLE) {
                globalSubwayLocationEngine$trackTrip$1.L$0 = SpillingKt.nullOutSpilledVariable(context);
                globalSubwayLocationEngine$trackTrip$1.L$1 = SpillingKt.nullOutSpilledVariable(smartSubwayTrip2);
                globalSubwayLocationEngine$trackTrip$1.L$2 = SpillingKt.nullOutSpilledVariable(function2);
                globalSubwayLocationEngine$trackTrip$1.L$3 = SpillingKt.nullOutSpilledVariable(subwayCity2);
                globalSubwayLocationEngine$trackTrip$1.L$4 = SpillingKt.nullOutSpilledVariable(smartSubwayTrip);
                globalSubwayLocationEngine$trackTrip$1.I$0 = i2;
                globalSubwayLocationEngine$trackTrip$1.label = 2;
            } else {
                globalSubwayLocationEngine$trackTrip$1.L$0 = SpillingKt.nullOutSpilledVariable(context);
                globalSubwayLocationEngine$trackTrip$1.L$1 = SpillingKt.nullOutSpilledVariable(smartSubwayTrip2);
                globalSubwayLocationEngine$trackTrip$1.L$2 = SpillingKt.nullOutSpilledVariable(function2);
                globalSubwayLocationEngine$trackTrip$1.L$3 = SpillingKt.nullOutSpilledVariable(subwayCity2);
                globalSubwayLocationEngine$trackTrip$1.L$4 = SpillingKt.nullOutSpilledVariable(smartSubwayTrip);
                globalSubwayLocationEngine$trackTrip$1.I$0 = i2;
                globalSubwayLocationEngine$trackTrip$1.label = 3;
            }
            return coroutine_suspended;
        }
        if (i3 != 1) {
            if (i3 == 2) {
                int i5 = globalSubwayLocationEngine$trackTrip$1.I$0;
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            }
            if (i3 != 3) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i6 = globalSubwayLocationEngine$trackTrip$1.I$0;
            ResultKt.throwOnFailure(obj);
            return Unit.INSTANCE;
        }
        int i7 = globalSubwayLocationEngine$trackTrip$1.I$0;
        subwayCity = (GlobalSubwayDataManager.SubwayCity) globalSubwayLocationEngine$trackTrip$1.L$3;
        function1 = (Function1) globalSubwayLocationEngine$trackTrip$1.L$2;
        SmartSubwayTrip smartSubwayTrip3 = (SmartSubwayTrip) globalSubwayLocationEngine$trackTrip$1.L$1;
        Context context2 = (Context) globalSubwayLocationEngine$trackTrip$1.L$0;
        try {
            ResultKt.throwOnFailure(obj);
            i = i7;
            context = context2;
            objPrepareTrip$app = obj;
            function2 = function1;
            smartSubwayTrip2 = smartSubwayTrip3;
            try {
                int i8 = i;
                subwayCity2 = subwayCity;
                smartSubwayTrip = (SmartSubwayTrip) objPrepareTrip$app;
                i2 = i8;
            } catch (Throwable unused2) {
                Function1<? super SmartSubwayTrip, Unit> function3 = function2;
                subwayCityCityOrNull = subwayCity;
                smartSubwayTrip = smartSubwayTrip2;
                function1 = function3;
                i2 = i;
                subwayCity2 = subwayCityCityOrNull;
                function2 = function1;
                smartSubwayTrip2 = smartSubwayTrip;
            }
        } catch (Throwable unused3) {
            subwayCityCityOrNull = subwayCity;
            smartSubwayTrip = smartSubwayTrip3;
            i = i7;
            context = context2;
        }
        function2.invoke(smartSubwayTrip);
        if (!hasLocationPermission(context)) {
            return Unit.INSTANCE;
        }
        if (subwayCity2.getSourceType() == GlobalSubwayDataManager.SourceType.GOOGLE) {
            globalSubwayLocationEngine$trackTrip$1.L$0 = SpillingKt.nullOutSpilledVariable(context);
            globalSubwayLocationEngine$trackTrip$1.L$1 = SpillingKt.nullOutSpilledVariable(smartSubwayTrip2);
            globalSubwayLocationEngine$trackTrip$1.L$2 = SpillingKt.nullOutSpilledVariable(function2);
            globalSubwayLocationEngine$trackTrip$1.L$3 = SpillingKt.nullOutSpilledVariable(subwayCity2);
            globalSubwayLocationEngine$trackTrip$1.L$4 = SpillingKt.nullOutSpilledVariable(smartSubwayTrip);
            globalSubwayLocationEngine$trackTrip$1.I$0 = i2;
            globalSubwayLocationEngine$trackTrip$1.label = 2;
        } else {
            globalSubwayLocationEngine$trackTrip$1.L$0 = SpillingKt.nullOutSpilledVariable(context);
            globalSubwayLocationEngine$trackTrip$1.L$1 = SpillingKt.nullOutSpilledVariable(smartSubwayTrip2);
            globalSubwayLocationEngine$trackTrip$1.L$2 = SpillingKt.nullOutSpilledVariable(function2);
            globalSubwayLocationEngine$trackTrip$1.L$3 = SpillingKt.nullOutSpilledVariable(subwayCity2);
            globalSubwayLocationEngine$trackTrip$1.L$4 = SpillingKt.nullOutSpilledVariable(smartSubwayTrip);
            globalSubwayLocationEngine$trackTrip$1.I$0 = i2;
            globalSubwayLocationEngine$trackTrip$1.label = 3;
        }
        return coroutine_suspended;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:115:0x0476 A[Catch: all -> 0x0577, TRY_LEAVE, TryCatch #5 {all -> 0x0577, blocks: (B:113:0x046c, B:115:0x0476), top: B:156:0x046c }] */
    /* JADX WARN: Code duplicated, block: B:120:0x04d9  */
    /* JADX WARN: Code duplicated, block: B:130:0x04f7 A[PHI: r1 r2 r3 r4 r5 r8 r9 r11 r12 r14 r15 r21 r22 r23 r29 r30
      0x04f7: PHI (r1v17 kotlin.jvm.internal.Ref$ObjectRef) = (r1v30 kotlin.jvm.internal.Ref$ObjectRef), (r1v31 kotlin.jvm.internal.Ref$ObjectRef) binds: [B:122:0x04e3, B:129:0x04f5] A[DONT_GENERATE, DONT_INLINE]
      0x04f7: PHI (r2v9 java.util.Set) = (r2v72 java.util.Set), (r2v73 java.util.Set) binds: [B:122:0x04e3, B:129:0x04f5] A[DONT_GENERATE, DONT_INLINE]
      0x04f7: PHI (r3v15 ??) = (r3v45 ??), (r3v46 ??) binds: [B:122:0x04e3, B:129:0x04f5] A[DONT_GENERATE, DONT_INLINE]
      0x04f7: PHI (r4v14 kotlin.jvm.internal.Ref$ObjectRef) = (r4v35 kotlin.jvm.internal.Ref$ObjectRef), (r4v36 kotlin.jvm.internal.Ref$ObjectRef) binds: [B:122:0x04e3, B:129:0x04f5] A[DONT_GENERATE, DONT_INLINE]
      0x04f7: PHI (r5v14 kotlin.jvm.internal.Ref$FloatRef) = (r5v34 kotlin.jvm.internal.Ref$FloatRef), (r5v35 kotlin.jvm.internal.Ref$FloatRef) binds: [B:122:0x04e3, B:129:0x04f5] A[DONT_GENERATE, DONT_INLINE]
      0x04f7: PHI (r8v14 java.util.List) = (r8v16 java.util.List), (r8v17 java.util.List) binds: [B:122:0x04e3, B:129:0x04f5] A[DONT_GENERATE, DONT_INLINE]
      0x04f7: PHI (r9v9 android.location.LocationManager) = (r9v11 android.location.LocationManager), (r9v12 android.location.LocationManager) binds: [B:122:0x04e3, B:129:0x04f5] A[DONT_GENERATE, DONT_INLINE]
      0x04f7: PHI (r11v10 com.example.tickets.GlobalSubwayDataManager$StaticIndex) = 
      (r11v35 com.example.tickets.GlobalSubwayDataManager$StaticIndex)
      (r11v36 com.example.tickets.GlobalSubwayDataManager$StaticIndex)
     binds: [B:122:0x04e3, B:129:0x04f5] A[DONT_GENERATE, DONT_INLINE]
      0x04f7: PHI (r12v4 java.util.Map) = (r12v27 java.util.Map), (r12v28 java.util.Map) binds: [B:122:0x04e3, B:129:0x04f5] A[DONT_GENERATE, DONT_INLINE]
      0x04f7: PHI (r14v6 kotlin.jvm.internal.Ref$IntRef) = (r14v7 kotlin.jvm.internal.Ref$IntRef), (r14v8 kotlin.jvm.internal.Ref$IntRef) binds: [B:122:0x04e3, B:129:0x04f5] A[DONT_GENERATE, DONT_INLINE]
      0x04f7: PHI (r15v5 com.example.tickets.GlobalSubwayDataManager$SubwayRoutePlan) = 
      (r15v6 com.example.tickets.GlobalSubwayDataManager$SubwayRoutePlan)
      (r15v7 com.example.tickets.GlobalSubwayDataManager$SubwayRoutePlan)
     binds: [B:122:0x04e3, B:129:0x04f5] A[DONT_GENERATE, DONT_INLINE]
      0x04f7: PHI (r21v3 kotlin.jvm.internal.Ref$ObjectRef) = (r21v4 kotlin.jvm.internal.Ref$ObjectRef), (r21v5 kotlin.jvm.internal.Ref$ObjectRef) binds: [B:122:0x04e3, B:129:0x04f5] A[DONT_GENERATE, DONT_INLINE]
      0x04f7: PHI (r22v4 ??) = (r22v21 ??), (r22v22 ??) binds: [B:122:0x04e3, B:129:0x04f5] A[DONT_GENERATE, DONT_INLINE]
      0x04f7: PHI (r23v3 android.content.Context) = (r23v4 android.content.Context), (r23v5 android.content.Context) binds: [B:122:0x04e3, B:129:0x04f5] A[DONT_GENERATE, DONT_INLINE]
      0x04f7: PHI (r29v2 kotlin.jvm.functions.Function1<? super com.example.tickets.SmartSubwayTrip, kotlin.Unit>) = 
      (r29v3 kotlin.jvm.functions.Function1<? super com.example.tickets.SmartSubwayTrip, kotlin.Unit>)
      (r29v4 kotlin.jvm.functions.Function1<? super com.example.tickets.SmartSubwayTrip, kotlin.Unit>)
     binds: [B:122:0x04e3, B:129:0x04f5] A[DONT_GENERATE, DONT_INLINE]
      0x04f7: PHI (r30v2 kotlin.jvm.internal.Ref$LongRef) = (r30v3 kotlin.jvm.internal.Ref$LongRef), (r30v4 kotlin.jvm.internal.Ref$LongRef) binds: [B:122:0x04e3, B:129:0x04f5] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:156:0x046c A[EXC_TOP_SPLITTER, PHI: r1 r2 r3 r4 r5 r8 r9 r11 r12 r14 r15 r21 r22 r23 r29 r30
      0x046c: PHI (r1v31 kotlin.jvm.internal.Ref$ObjectRef) = (r1v30 kotlin.jvm.internal.Ref$ObjectRef), (r1v32 kotlin.jvm.internal.Ref$ObjectRef) binds: [B:122:0x04e3, B:112:0x0467] A[DONT_GENERATE, DONT_INLINE]
      0x046c: PHI (r2v11 java.util.Set) = (r2v68 java.util.Set), (r2v69 java.util.Set) binds: [B:122:0x04e3, B:112:0x0467] A[DONT_GENERATE, DONT_INLINE]
      0x046c: PHI (r3v17 ??) = (r3v41 ??), (r3v42 ??) binds: [B:122:0x04e3, B:112:0x0467] A[DONT_GENERATE, DONT_INLINE]
      0x046c: PHI (r4v16 kotlin.jvm.internal.Ref$ObjectRef) = (r4v31 kotlin.jvm.internal.Ref$ObjectRef), (r4v32 kotlin.jvm.internal.Ref$ObjectRef) binds: [B:122:0x04e3, B:112:0x0467] A[DONT_GENERATE, DONT_INLINE]
      0x046c: PHI (r5v16 kotlin.jvm.internal.Ref$FloatRef) = (r5v30 kotlin.jvm.internal.Ref$FloatRef), (r5v31 kotlin.jvm.internal.Ref$FloatRef) binds: [B:122:0x04e3, B:112:0x0467] A[DONT_GENERATE, DONT_INLINE]
      0x046c: PHI (r8v17 java.util.List) = (r8v16 java.util.List), (r8v18 java.util.List) binds: [B:122:0x04e3, B:112:0x0467] A[DONT_GENERATE, DONT_INLINE]
      0x046c: PHI (r9v12 android.location.LocationManager) = (r9v11 android.location.LocationManager), (r9v13 android.location.LocationManager) binds: [B:122:0x04e3, B:112:0x0467] A[DONT_GENERATE, DONT_INLINE]
      0x046c: PHI (r11v12 com.example.tickets.GlobalSubwayDataManager$StaticIndex) = 
      (r11v32 com.example.tickets.GlobalSubwayDataManager$StaticIndex)
      (r11v33 com.example.tickets.GlobalSubwayDataManager$StaticIndex)
     binds: [B:122:0x04e3, B:112:0x0467] A[DONT_GENERATE, DONT_INLINE]
      0x046c: PHI (r12v6 java.util.Map) = (r12v23 java.util.Map), (r12v24 java.util.Map) binds: [B:122:0x04e3, B:112:0x0467] A[DONT_GENERATE, DONT_INLINE]
      0x046c: PHI (r14v8 kotlin.jvm.internal.Ref$IntRef) = (r14v7 kotlin.jvm.internal.Ref$IntRef), (r14v9 kotlin.jvm.internal.Ref$IntRef) binds: [B:122:0x04e3, B:112:0x0467] A[DONT_GENERATE, DONT_INLINE]
      0x046c: PHI (r15v7 com.example.tickets.GlobalSubwayDataManager$SubwayRoutePlan) = 
      (r15v6 com.example.tickets.GlobalSubwayDataManager$SubwayRoutePlan)
      (r15v8 com.example.tickets.GlobalSubwayDataManager$SubwayRoutePlan)
     binds: [B:122:0x04e3, B:112:0x0467] A[DONT_GENERATE, DONT_INLINE]
      0x046c: PHI (r21v5 kotlin.jvm.internal.Ref$ObjectRef) = (r21v4 kotlin.jvm.internal.Ref$ObjectRef), (r21v6 kotlin.jvm.internal.Ref$ObjectRef) binds: [B:122:0x04e3, B:112:0x0467] A[DONT_GENERATE, DONT_INLINE]
      0x046c: PHI (r22v6 ??) = (r22v17 ??), (r22v18 ??) binds: [B:122:0x04e3, B:112:0x0467] A[DONT_GENERATE, DONT_INLINE]
      0x046c: PHI (r23v5 android.content.Context) = (r23v4 android.content.Context), (r23v6 android.content.Context) binds: [B:122:0x04e3, B:112:0x0467] A[DONT_GENERATE, DONT_INLINE]
      0x046c: PHI (r29v4 kotlin.jvm.functions.Function1<? super com.example.tickets.SmartSubwayTrip, kotlin.Unit>) = 
      (r29v3 kotlin.jvm.functions.Function1<? super com.example.tickets.SmartSubwayTrip, kotlin.Unit>)
      (r29v5 kotlin.jvm.functions.Function1<? super com.example.tickets.SmartSubwayTrip, kotlin.Unit>)
     binds: [B:122:0x04e3, B:112:0x0467] A[DONT_GENERATE, DONT_INLINE]
      0x046c: PHI (r30v4 kotlin.jvm.internal.Ref$LongRef) = (r30v3 kotlin.jvm.internal.Ref$LongRef), (r30v5 kotlin.jvm.internal.Ref$LongRef) binds: [B:122:0x04e3, B:112:0x0467] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 19, insn: 0x019e: MOVE (r8 I:??[OBJECT, ARRAY]) = (r19 I:??[OBJECT, ARRAY]), block:B:26:0x019e */
    /* JADX WARN: Not initialized variable reg: 20, insn: 0x01a0: MOVE (r9 I:??[OBJECT, ARRAY]) = (r20 I:??[OBJECT, ARRAY]), block:B:26:0x019e */
    /* JADX WARN: Path cross not found for [B:10:0x002f, B:31:0x01cf], limit reached: 164 */
    /* JADX WARN: Type inference failed for: r0v143 */
    /* JADX WARN: Type inference failed for: r0v144 */
    /* JADX WARN: Type inference failed for: r0v145 */
    /* JADX WARN: Type inference failed for: r0v45, types: [T] */
    /* JADX WARN: Type inference failed for: r11v0 */
    /* JADX WARN: Type inference failed for: r11v38 */
    /* JADX WARN: Type inference failed for: r11v7, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r12v0 */
    /* JADX WARN: Type inference failed for: r12v1, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r12v30 */
    /* JADX WARN: Type inference failed for: r15v0, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r15v1 */
    /* JADX WARN: Type inference failed for: r15v12 */
    /* JADX WARN: Type inference failed for: r15v19 */
    /* JADX WARN: Type inference failed for: r15v20 */
    /* JADX WARN: Type inference failed for: r15v21 */
    /* JADX WARN: Type inference failed for: r15v22 */
    /* JADX WARN: Type inference failed for: r15v23 */
    /* JADX WARN: Type inference failed for: r15v9, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r22v10 */
    /* JADX WARN: Type inference failed for: r22v16 */
    /* JADX WARN: Type inference failed for: r22v17 */
    /* JADX WARN: Type inference failed for: r22v18 */
    /* JADX WARN: Type inference failed for: r22v19 */
    /* JADX WARN: Type inference failed for: r22v2, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r22v20 */
    /* JADX WARN: Type inference failed for: r22v21 */
    /* JADX WARN: Type inference failed for: r22v22 */
    /* JADX WARN: Type inference failed for: r22v23 */
    /* JADX WARN: Type inference failed for: r22v3 */
    /* JADX WARN: Type inference failed for: r22v4, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r22v5 */
    /* JADX WARN: Type inference failed for: r22v6, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r22v7 */
    /* JADX WARN: Type inference failed for: r22v9 */
    /* JADX WARN: Type inference failed for: r3v11, types: [com.example.tickets.GlobalSubwayLocationEngine$trackStaticTrip$listener$1, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v14 */
    /* JADX WARN: Type inference failed for: r3v15, types: [com.example.tickets.GlobalSubwayLocationEngine$trackStaticTrip$listener$1, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v16 */
    /* JADX WARN: Type inference failed for: r3v17, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v18 */
    /* JADX WARN: Type inference failed for: r3v28, types: [com.example.tickets.GlobalSubwayLocationEngine$trackStaticTrip$listener$1, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v39 */
    /* JADX WARN: Type inference failed for: r3v40 */
    /* JADX WARN: Type inference failed for: r3v41 */
    /* JADX WARN: Type inference failed for: r3v42 */
    /* JADX WARN: Type inference failed for: r3v43 */
    /* JADX WARN: Type inference failed for: r3v44 */
    /* JADX WARN: Type inference failed for: r3v45 */
    /* JADX WARN: Type inference failed for: r3v46 */
    /* JADX WARN: Type inference failed for: r3v47 */
    /* JADX WARN: Type inference failed for: r3v48 */
    /* JADX WARN: Type inference failed for: r3v49 */
    /* JADX WARN: Type inference failed for: r3v50 */
    /* JADX WARN: Type inference failed for: r4v10, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v38 */
    /* JADX WARN: Type inference failed for: r4v39 */
    /* JADX WARN: Type inference failed for: r5v10, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v28 */
    /* JADX WARN: Type inference failed for: r5v37 */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:122:0x04e3 -> B:156:0x046c). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object trackStaticTrip(android.content.Context r33, com.example.tickets.SmartSubwayTrip r34, kotlin.jvm.functions.Function1<? super com.example.tickets.SmartSubwayTrip, kotlin.Unit> r35, kotlin.coroutines.Continuation<? super kotlin.Unit> r36) {
        /*
            Method dump skipped, instruction units count: 1558
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.tickets.GlobalSubwayLocationEngine.trackStaticTrip(android.content.Context, com.example.tickets.SmartSubwayTrip, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: renamed from: com.example.tickets.GlobalSubwayLocationEngine$trackStaticTrip$2, reason: invalid class name */
    /* JADX INFO: compiled from: GlobalSubwayData.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.tickets.GlobalSubwayLocationEngine$trackStaticTrip$2", f = "GlobalSubwayData.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ GlobalSubwayLocationEngine$trackStaticTrip$listener$1 $listener;
        final /* synthetic */ LocationManager $locationManager;
        final /* synthetic */ Set<String> $requestedProviders;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(Set<String> set, LocationManager locationManager, GlobalSubwayLocationEngine$trackStaticTrip$listener$1 globalSubwayLocationEngine$trackStaticTrip$listener$1, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$requestedProviders = set;
            this.$locationManager = locationManager;
            this.$listener = globalSubwayLocationEngine$trackStaticTrip$listener$1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$requestedProviders, this.$locationManager, this.$listener, continuation);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            Set<String> set = this.$requestedProviders;
            LocationManager locationManager = this.$locationManager;
            GlobalSubwayLocationEngine$trackStaticTrip$listener$1 globalSubwayLocationEngine$trackStaticTrip$listener$1 = this.$listener;
            for (String str : set) {
                try {
                    Result.Companion companion = Result.INSTANCE;
                    locationManager.requestLocationUpdates(str, 1000L, 4.0f, globalSubwayLocationEngine$trackStaticTrip$listener$1, Looper.getMainLooper());
                    Result.m9536constructorimpl(Unit.INSTANCE);
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.INSTANCE;
                    Result.m9536constructorimpl(ResultKt.createFailure(th));
                }
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.example.tickets.GlobalSubwayLocationEngine$trackStaticTrip$3, reason: invalid class name */
    /* JADX INFO: compiled from: GlobalSubwayData.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lkotlin/Result;", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.tickets.GlobalSubwayLocationEngine$trackStaticTrip$3", f = "GlobalSubwayData.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends Unit>>, Object> {
        final /* synthetic */ GlobalSubwayLocationEngine$trackStaticTrip$listener$1 $listener;
        final /* synthetic */ LocationManager $locationManager;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(LocationManager locationManager, GlobalSubwayLocationEngine$trackStaticTrip$listener$1 globalSubwayLocationEngine$trackStaticTrip$listener$1, Continuation<? super AnonymousClass3> continuation) {
            super(2, continuation);
            this.$locationManager = locationManager;
            this.$listener = globalSubwayLocationEngine$trackStaticTrip$listener$1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass3 anonymousClass3 = new AnonymousClass3(this.$locationManager, this.$listener, continuation);
            anonymousClass3.L$0 = obj;
            return anonymousClass3;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super Result<? extends Unit>> continuation) {
            return invoke2(coroutineScope, (Continuation<? super Result<Unit>>) continuation);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super Result<Unit>> continuation) {
            return ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object objM9536constructorimpl;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            LocationManager locationManager = this.$locationManager;
            GlobalSubwayLocationEngine$trackStaticTrip$listener$1 globalSubwayLocationEngine$trackStaticTrip$listener$1 = this.$listener;
            try {
                Result.Companion companion = Result.INSTANCE;
                locationManager.removeUpdates(globalSubwayLocationEngine$trackStaticTrip$listener$1);
                objM9536constructorimpl = Result.m9536constructorimpl(Unit.INSTANCE);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objM9536constructorimpl = Result.m9536constructorimpl(ResultKt.createFailure(th));
            }
            return Result.m9535boximpl(objM9536constructorimpl);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:123:0x052f A[Catch: all -> 0x0666, TRY_LEAVE, TryCatch #3 {all -> 0x0666, blocks: (B:121:0x0525, B:123:0x052f), top: B:162:0x0525 }] */
    /* JADX WARN: Code duplicated, block: B:128:0x05aa  */
    /* JADX WARN: Code duplicated, block: B:137:0x05c7 A[PHI: r1 r2 r3 r5 r8 r9 r10 r11 r12 r14 r15 r17 r20 r21 r22 r23 r24 r25 r26 r28 r29 r30
      0x05c7: PHI (r1v67 kotlin.jvm.internal.Ref$ObjectRef) = (r1v64 kotlin.jvm.internal.Ref$ObjectRef), (r1v72 kotlin.jvm.internal.Ref$ObjectRef) binds: [B:136:0x05c5, B:130:0x05b4] A[DONT_GENERATE, DONT_INLINE]
      0x05c7: PHI (r2v13 int) = (r2v12 int), (r2v16 int) binds: [B:136:0x05c5, B:130:0x05b4] A[DONT_GENERATE, DONT_INLINE]
      0x05c7: PHI (r3v19 double) = (r3v18 double), (r3v20 double) binds: [B:136:0x05c5, B:130:0x05b4] A[DONT_GENERATE, DONT_INLINE]
      0x05c7: PHI (r5v23 java.util.Set) = (r5v22 java.util.Set), (r5v25 java.util.Set) binds: [B:136:0x05c5, B:130:0x05b4] A[DONT_GENERATE, DONT_INLINE]
      0x05c7: PHI (r8v26 java.lang.Object) = (r8v25 java.lang.Object), (r8v35 java.lang.Object) binds: [B:136:0x05c5, B:130:0x05b4] A[DONT_GENERATE, DONT_INLINE]
      0x05c7: PHI (r9v11 kotlinx.coroutines.CoroutineScope) = (r9v10 kotlinx.coroutines.CoroutineScope), (r9v15 kotlinx.coroutines.CoroutineScope) binds: [B:136:0x05c5, B:130:0x05b4] A[DONT_GENERATE, DONT_INLINE]
      0x05c7: PHI (r10v28 java.util.List) = (r10v27 java.util.List), (r10v35 java.util.List) binds: [B:136:0x05c5, B:130:0x05b4] A[DONT_GENERATE, DONT_INLINE]
      0x05c7: PHI (r11v8 ??) = (r11v16 ??), (r11v17 ??) binds: [B:136:0x05c5, B:130:0x05b4] A[DONT_GENERATE, DONT_INLINE]
      0x05c7: PHI (r12v6 android.location.LocationManager) = (r12v5 android.location.LocationManager), (r12v8 android.location.LocationManager) binds: [B:136:0x05c5, B:130:0x05b4] A[DONT_GENERATE, DONT_INLINE]
      0x05c7: PHI (r14v15 kotlin.jvm.internal.Ref$LongRef) = (r14v14 kotlin.jvm.internal.Ref$LongRef), (r14v16 kotlin.jvm.internal.Ref$LongRef) binds: [B:136:0x05c5, B:130:0x05b4] A[DONT_GENERATE, DONT_INLINE]
      0x05c7: PHI (r15v37 kotlin.jvm.internal.Ref$ObjectRef) = (r15v36 kotlin.jvm.internal.Ref$ObjectRef), (r15v38 kotlin.jvm.internal.Ref$ObjectRef) binds: [B:136:0x05c5, B:130:0x05b4] A[DONT_GENERATE, DONT_INLINE]
      0x05c7: PHI (r17v7 kotlin.jvm.internal.Ref$DoubleRef) = (r17v6 kotlin.jvm.internal.Ref$DoubleRef), (r17v8 kotlin.jvm.internal.Ref$DoubleRef) binds: [B:136:0x05c5, B:130:0x05b4] A[DONT_GENERATE, DONT_INLINE]
      0x05c7: PHI (r20v8 kotlin.jvm.internal.Ref$LongRef) = (r20v7 kotlin.jvm.internal.Ref$LongRef), (r20v9 kotlin.jvm.internal.Ref$LongRef) binds: [B:136:0x05c5, B:130:0x05b4] A[DONT_GENERATE, DONT_INLINE]
      0x05c7: PHI (r21v8 java.util.LinkedHashMap) = (r21v7 java.util.LinkedHashMap), (r21v9 java.util.LinkedHashMap) binds: [B:136:0x05c5, B:130:0x05b4] A[DONT_GENERATE, DONT_INLINE]
      0x05c7: PHI (r22v8 java.util.LinkedHashMap) = (r22v7 java.util.LinkedHashMap), (r22v9 java.util.LinkedHashMap) binds: [B:136:0x05c5, B:130:0x05b4] A[DONT_GENERATE, DONT_INLINE]
      0x05c7: PHI (r23v8 java.util.List<com.example.tickets.GlobalSubwayDataManager$SubwayRouteStation>) = 
      (r23v7 java.util.List<com.example.tickets.GlobalSubwayDataManager$SubwayRouteStation>)
      (r23v9 java.util.List<com.example.tickets.GlobalSubwayDataManager$SubwayRouteStation>)
     binds: [B:136:0x05c5, B:130:0x05b4] A[DONT_GENERATE, DONT_INLINE]
      0x05c7: PHI (r24v7 java.util.List<com.example.tickets.GlobalSubwayDataManager$RoutePoint>) = 
      (r24v6 java.util.List<com.example.tickets.GlobalSubwayDataManager$RoutePoint>)
      (r24v8 java.util.List<com.example.tickets.GlobalSubwayDataManager$RoutePoint>)
     binds: [B:136:0x05c5, B:130:0x05b4] A[DONT_GENERATE, DONT_INLINE]
      0x05c7: PHI (r25v7 com.example.tickets.GlobalSubwayDataManager$SubwayRoutePlan) = 
      (r25v6 com.example.tickets.GlobalSubwayDataManager$SubwayRoutePlan)
      (r25v8 com.example.tickets.GlobalSubwayDataManager$SubwayRoutePlan)
     binds: [B:136:0x05c5, B:130:0x05b4] A[DONT_GENERATE, DONT_INLINE]
      0x05c7: PHI (r26v7 kotlin.jvm.internal.Ref$ObjectRef) = (r26v6 kotlin.jvm.internal.Ref$ObjectRef), (r26v8 kotlin.jvm.internal.Ref$ObjectRef) binds: [B:136:0x05c5, B:130:0x05b4] A[DONT_GENERATE, DONT_INLINE]
      0x05c7: PHI (r28v7 kotlin.jvm.functions.Function1<? super com.example.tickets.SmartSubwayTrip, kotlin.Unit>) = 
      (r28v6 kotlin.jvm.functions.Function1<? super com.example.tickets.SmartSubwayTrip, kotlin.Unit>)
      (r28v8 kotlin.jvm.functions.Function1<? super com.example.tickets.SmartSubwayTrip, kotlin.Unit>)
     binds: [B:136:0x05c5, B:130:0x05b4] A[DONT_GENERATE, DONT_INLINE]
      0x05c7: PHI (r29v7 ??) = (r29v15 ??), (r29v16 ??) binds: [B:136:0x05c5, B:130:0x05b4] A[DONT_GENERATE, DONT_INLINE]
      0x05c7: PHI (r30v7 android.content.Context) = (r30v6 android.content.Context), (r30v8 android.content.Context) binds: [B:136:0x05c5, B:130:0x05b4] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:140:0x065e  */
    /* JADX WARN: Code duplicated, block: B:162:0x0525 A[EXC_TOP_SPLITTER, PHI: r1 r2 r3 r5 r8 r9 r10 r11 r12 r14 r15 r17 r20 r21 r22 r23 r24 r25 r26 r28 r29 r30
      0x0525: PHI (r1v64 kotlin.jvm.internal.Ref$ObjectRef) = (r1v38 kotlin.jvm.internal.Ref$ObjectRef), (r1v72 kotlin.jvm.internal.Ref$ObjectRef) binds: [B:120:0x051d, B:130:0x05b4] A[DONT_GENERATE, DONT_INLINE]
      0x0525: PHI (r2v12 int) = (r2v8 int), (r2v16 int) binds: [B:120:0x051d, B:130:0x05b4] A[DONT_GENERATE, DONT_INLINE]
      0x0525: PHI (r3v18 double) = (r3v14 double), (r3v20 double) binds: [B:120:0x051d, B:130:0x05b4] A[DONT_GENERATE, DONT_INLINE]
      0x0525: PHI (r5v22 java.util.Set) = (r5v18 java.util.Set), (r5v25 java.util.Set) binds: [B:120:0x051d, B:130:0x05b4] A[DONT_GENERATE, DONT_INLINE]
      0x0525: PHI (r8v25 java.lang.Object) = (r8v22 java.lang.Object), (r8v35 java.lang.Object) binds: [B:120:0x051d, B:130:0x05b4] A[DONT_GENERATE, DONT_INLINE]
      0x0525: PHI (r9v10 kotlinx.coroutines.CoroutineScope) = (r9v5 kotlinx.coroutines.CoroutineScope), (r9v15 kotlinx.coroutines.CoroutineScope) binds: [B:120:0x051d, B:130:0x05b4] A[DONT_GENERATE, DONT_INLINE]
      0x0525: PHI (r10v27 java.util.List) = (r10v23 java.util.List), (r10v35 java.util.List) binds: [B:120:0x051d, B:130:0x05b4] A[DONT_GENERATE, DONT_INLINE]
      0x0525: PHI (r11v7 ??) = (r11v18 ??), (r11v19 ??) binds: [B:120:0x051d, B:130:0x05b4] A[DONT_GENERATE, DONT_INLINE]
      0x0525: PHI (r12v5 android.location.LocationManager) = (r12v2 android.location.LocationManager), (r12v8 android.location.LocationManager) binds: [B:120:0x051d, B:130:0x05b4] A[DONT_GENERATE, DONT_INLINE]
      0x0525: PHI (r14v14 kotlin.jvm.internal.Ref$LongRef) = (r14v11 kotlin.jvm.internal.Ref$LongRef), (r14v16 kotlin.jvm.internal.Ref$LongRef) binds: [B:120:0x051d, B:130:0x05b4] A[DONT_GENERATE, DONT_INLINE]
      0x0525: PHI (r15v36 kotlin.jvm.internal.Ref$ObjectRef) = (r15v33 kotlin.jvm.internal.Ref$ObjectRef), (r15v38 kotlin.jvm.internal.Ref$ObjectRef) binds: [B:120:0x051d, B:130:0x05b4] A[DONT_GENERATE, DONT_INLINE]
      0x0525: PHI (r17v6 kotlin.jvm.internal.Ref$DoubleRef) = (r17v3 kotlin.jvm.internal.Ref$DoubleRef), (r17v8 kotlin.jvm.internal.Ref$DoubleRef) binds: [B:120:0x051d, B:130:0x05b4] A[DONT_GENERATE, DONT_INLINE]
      0x0525: PHI (r20v7 kotlin.jvm.internal.Ref$LongRef) = (r20v4 kotlin.jvm.internal.Ref$LongRef), (r20v9 kotlin.jvm.internal.Ref$LongRef) binds: [B:120:0x051d, B:130:0x05b4] A[DONT_GENERATE, DONT_INLINE]
      0x0525: PHI (r21v7 java.util.LinkedHashMap) = (r21v4 java.util.LinkedHashMap), (r21v9 java.util.LinkedHashMap) binds: [B:120:0x051d, B:130:0x05b4] A[DONT_GENERATE, DONT_INLINE]
      0x0525: PHI (r22v7 java.util.LinkedHashMap) = (r22v4 java.util.LinkedHashMap), (r22v9 java.util.LinkedHashMap) binds: [B:120:0x051d, B:130:0x05b4] A[DONT_GENERATE, DONT_INLINE]
      0x0525: PHI (r23v7 java.util.List<com.example.tickets.GlobalSubwayDataManager$SubwayRouteStation>) = 
      (r23v4 java.util.List<com.example.tickets.GlobalSubwayDataManager$SubwayRouteStation>)
      (r23v9 java.util.List<com.example.tickets.GlobalSubwayDataManager$SubwayRouteStation>)
     binds: [B:120:0x051d, B:130:0x05b4] A[DONT_GENERATE, DONT_INLINE]
      0x0525: PHI (r24v6 java.util.List<com.example.tickets.GlobalSubwayDataManager$RoutePoint>) = 
      (r24v3 java.util.List<com.example.tickets.GlobalSubwayDataManager$RoutePoint>)
      (r24v8 java.util.List<com.example.tickets.GlobalSubwayDataManager$RoutePoint>)
     binds: [B:120:0x051d, B:130:0x05b4] A[DONT_GENERATE, DONT_INLINE]
      0x0525: PHI (r25v6 com.example.tickets.GlobalSubwayDataManager$SubwayRoutePlan) = 
      (r25v3 com.example.tickets.GlobalSubwayDataManager$SubwayRoutePlan)
      (r25v8 com.example.tickets.GlobalSubwayDataManager$SubwayRoutePlan)
     binds: [B:120:0x051d, B:130:0x05b4] A[DONT_GENERATE, DONT_INLINE]
      0x0525: PHI (r26v6 kotlin.jvm.internal.Ref$ObjectRef) = (r26v2 kotlin.jvm.internal.Ref$ObjectRef), (r26v8 kotlin.jvm.internal.Ref$ObjectRef) binds: [B:120:0x051d, B:130:0x05b4] A[DONT_GENERATE, DONT_INLINE]
      0x0525: PHI (r28v6 kotlin.jvm.functions.Function1<? super com.example.tickets.SmartSubwayTrip, kotlin.Unit>) = 
      (r28v3 kotlin.jvm.functions.Function1<? super com.example.tickets.SmartSubwayTrip, kotlin.Unit>)
      (r28v8 kotlin.jvm.functions.Function1<? super com.example.tickets.SmartSubwayTrip, kotlin.Unit>)
     binds: [B:120:0x051d, B:130:0x05b4] A[DONT_GENERATE, DONT_INLINE]
      0x0525: PHI (r29v6 ??) = (r29v17 ??), (r29v18 ??) binds: [B:120:0x051d, B:130:0x05b4] A[DONT_GENERATE, DONT_INLINE]
      0x0525: PHI (r30v6 android.content.Context) = (r30v3 android.content.Context), (r30v8 android.content.Context) binds: [B:120:0x051d, B:130:0x05b4] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Path cross not found for [B:10:0x0030, B:33:0x022c], limit reached: 177 */
    /* JADX WARN: Type inference failed for: r0v14, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r11v1, types: [com.example.tickets.GlobalSubwayLocationEngine$trackGoogleTrip$listener$1, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r11v14 */
    /* JADX WARN: Type inference failed for: r11v15 */
    /* JADX WARN: Type inference failed for: r11v16 */
    /* JADX WARN: Type inference failed for: r11v17 */
    /* JADX WARN: Type inference failed for: r11v18 */
    /* JADX WARN: Type inference failed for: r11v19 */
    /* JADX WARN: Type inference failed for: r11v20 */
    /* JADX WARN: Type inference failed for: r11v21 */
    /* JADX WARN: Type inference failed for: r11v22 */
    /* JADX WARN: Type inference failed for: r11v23 */
    /* JADX WARN: Type inference failed for: r11v24 */
    /* JADX WARN: Type inference failed for: r11v25 */
    /* JADX WARN: Type inference failed for: r11v4 */
    /* JADX WARN: Type inference failed for: r11v5, types: [com.example.tickets.GlobalSubwayLocationEngine$trackGoogleTrip$listener$1, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r11v6 */
    /* JADX WARN: Type inference failed for: r11v7, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r11v8, types: [com.example.tickets.GlobalSubwayLocationEngine$trackGoogleTrip$listener$1, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r11v9 */
    /* JADX WARN: Type inference failed for: r14v24 */
    /* JADX WARN: Type inference failed for: r14v25 */
    /* JADX WARN: Type inference failed for: r14v5, types: [T] */
    /* JADX WARN: Type inference failed for: r29v1 */
    /* JADX WARN: Type inference failed for: r29v13 */
    /* JADX WARN: Type inference failed for: r29v14 */
    /* JADX WARN: Type inference failed for: r29v15 */
    /* JADX WARN: Type inference failed for: r29v16 */
    /* JADX WARN: Type inference failed for: r29v17 */
    /* JADX WARN: Type inference failed for: r29v18 */
    /* JADX WARN: Type inference failed for: r29v19 */
    /* JADX WARN: Type inference failed for: r29v2 */
    /* JADX WARN: Type inference failed for: r29v20 */
    /* JADX WARN: Type inference failed for: r29v21 */
    /* JADX WARN: Type inference failed for: r29v22 */
    /* JADX WARN: Type inference failed for: r29v3 */
    /* JADX WARN: Type inference failed for: r29v4, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r29v5 */
    /* JADX WARN: Type inference failed for: r29v6, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r29v7, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r29v8 */
    /* JADX WARN: Type inference failed for: r30v0, types: [com.example.tickets.SmartSubwayTrip, java.lang.Object] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:128:0x05aa -> B:164:0x05ac). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object trackGoogleTrip(android.content.Context r51, com.example.tickets.SmartSubwayTrip r52, kotlin.jvm.functions.Function1<? super com.example.tickets.SmartSubwayTrip, kotlin.Unit> r53, kotlin.coroutines.Continuation<? super kotlin.Unit> r54) {
        /*
            Method dump skipped, instruction units count: 1836
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.tickets.GlobalSubwayLocationEngine.trackGoogleTrip(android.content.Context, com.example.tickets.SmartSubwayTrip, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List<GlobalSubwayDataManager.SubwayStationOption> trackGoogleTrip$snapshotKnownStops(Object obj, LinkedHashMap<String, GlobalSubwayDataManager.SubwayStationOption> linkedHashMap) {
        List<GlobalSubwayDataManager.SubwayStationOption> list;
        synchronized (obj) {
            Collection<GlobalSubwayDataManager.SubwayStationOption> collectionValues = linkedHashMap.values();
            Intrinsics.checkNotNullExpressionValue(collectionValues, "<get-values>(...)");
            list = CollectionsKt.toList(collectionValues);
        }
        return list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void trackGoogleTrip$mergeNearby(Object obj, List<GlobalSubwayDataManager.RoutePoint> list, LinkedHashMap<String, GlobalSubwayDataManager.SubwayStationOption> linkedHashMap, LinkedHashMap<String, Double> linkedHashMap2, List<GlobalSubwayDataManager.SubwayStationOption> list2) {
        synchronized (obj) {
            for (GlobalSubwayDataManager.SubwayStationOption subwayStationOption : list2) {
                GlobalSubwayLocationEngine globalSubwayLocationEngine = INSTANCE;
                List<GlobalSubwayDataManager.RoutePoint> list3 = list;
                if (globalSubwayLocationEngine.nearestDistanceToPath(subwayStationOption.getLatitude(), subwayStationOption.getLongitude(), list3) <= GOOGLE_ROUTE_CORRIDOR_M) {
                    linkedHashMap.put(subwayStationOption.getKey(), subwayStationOption);
                    linkedHashMap2.put(subwayStationOption.getKey(), Double.valueOf(globalSubwayLocationEngine.projectDistanceOnPath(subwayStationOption.getLatitude(), subwayStationOption.getLongitude(), list3)));
                }
                list = list3;
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void trackGoogleTrip$triggerNearbyRefresh(Ref.LongRef longRef, CoroutineScope coroutineScope, Ref.ObjectRef<SmartSubwayTrip> objectRef, Context context, Object obj, List<GlobalSubwayDataManager.RoutePoint> list, LinkedHashMap<String, GlobalSubwayDataManager.SubwayStationOption> linkedHashMap, LinkedHashMap<String, Double> linkedHashMap2, double d, double d2, long j) {
        if (j - longRef.element < 15000) {
            return;
        }
        longRef.element = j;
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new GlobalSubwayLocationEngine$trackGoogleTrip$triggerNearbyRefresh$1(objectRef, context, d, d2, obj, list, linkedHashMap, linkedHashMap2, null), 3, null);
    }

    /* JADX INFO: renamed from: com.example.tickets.GlobalSubwayLocationEngine$trackGoogleTrip$4, reason: invalid class name */
    /* JADX INFO: compiled from: GlobalSubwayData.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.tickets.GlobalSubwayLocationEngine$trackGoogleTrip$4", f = "GlobalSubwayData.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ GlobalSubwayLocationEngine$trackGoogleTrip$listener$1 $listener;
        final /* synthetic */ LocationManager $locationManager;
        final /* synthetic */ Set<String> $requestedProviders;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass4(Set<String> set, LocationManager locationManager, GlobalSubwayLocationEngine$trackGoogleTrip$listener$1 globalSubwayLocationEngine$trackGoogleTrip$listener$1, Continuation<? super AnonymousClass4> continuation) {
            super(2, continuation);
            this.$requestedProviders = set;
            this.$locationManager = locationManager;
            this.$listener = globalSubwayLocationEngine$trackGoogleTrip$listener$1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass4 anonymousClass4 = new AnonymousClass4(this.$requestedProviders, this.$locationManager, this.$listener, continuation);
            anonymousClass4.L$0 = obj;
            return anonymousClass4;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass4) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            Set<String> set = this.$requestedProviders;
            LocationManager locationManager = this.$locationManager;
            GlobalSubwayLocationEngine$trackGoogleTrip$listener$1 globalSubwayLocationEngine$trackGoogleTrip$listener$1 = this.$listener;
            for (String str : set) {
                try {
                    Result.Companion companion = Result.INSTANCE;
                    locationManager.requestLocationUpdates(str, 1000L, 4.0f, globalSubwayLocationEngine$trackGoogleTrip$listener$1, Looper.getMainLooper());
                    Result.m9536constructorimpl(Unit.INSTANCE);
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.INSTANCE;
                    Result.m9536constructorimpl(ResultKt.createFailure(th));
                }
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.example.tickets.GlobalSubwayLocationEngine$trackGoogleTrip$5, reason: invalid class name */
    /* JADX INFO: compiled from: GlobalSubwayData.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lkotlin/Result;", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.tickets.GlobalSubwayLocationEngine$trackGoogleTrip$5", f = "GlobalSubwayData.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass5 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends Unit>>, Object> {
        final /* synthetic */ GlobalSubwayLocationEngine$trackGoogleTrip$listener$1 $listener;
        final /* synthetic */ LocationManager $locationManager;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass5(LocationManager locationManager, GlobalSubwayLocationEngine$trackGoogleTrip$listener$1 globalSubwayLocationEngine$trackGoogleTrip$listener$1, Continuation<? super AnonymousClass5> continuation) {
            super(2, continuation);
            this.$locationManager = locationManager;
            this.$listener = globalSubwayLocationEngine$trackGoogleTrip$listener$1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass5 anonymousClass5 = new AnonymousClass5(this.$locationManager, this.$listener, continuation);
            anonymousClass5.L$0 = obj;
            return anonymousClass5;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super Result<? extends Unit>> continuation) {
            return invoke2(coroutineScope, (Continuation<? super Result<Unit>>) continuation);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super Result<Unit>> continuation) {
            return ((AnonymousClass5) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object objM9536constructorimpl;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            LocationManager locationManager = this.$locationManager;
            GlobalSubwayLocationEngine$trackGoogleTrip$listener$1 globalSubwayLocationEngine$trackGoogleTrip$listener$1 = this.$listener;
            try {
                Result.Companion companion = Result.INSTANCE;
                locationManager.removeUpdates(globalSubwayLocationEngine$trackGoogleTrip$listener$1);
                objM9536constructorimpl = Result.m9536constructorimpl(Unit.INSTANCE);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objM9536constructorimpl = Result.m9536constructorimpl(ResultKt.createFailure(th));
            }
            return Result.m9535boximpl(objM9536constructorimpl);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final double distanceMeters(double lat1, double lon1, double lat2, double lon2) {
        double radians = Math.toRadians(lat2 - lat1);
        double d = radians / 2.0d;
        double radians2 = Math.toRadians(lon2 - lon1) / 2.0d;
        double dSin = (Math.sin(d) * Math.sin(d)) + (Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) * Math.sin(radians2) * Math.sin(radians2));
        return 1.2742E7d * Math.atan2(Math.sqrt(dSin), Math.sqrt(Math.max(AudioStats.AUDIO_AMPLITUDE_NONE, 1.0d - dSin)));
    }

    private final double totalPathLength(List<GlobalSubwayDataManager.RoutePoint> path) {
        int size = path.size();
        double dDistanceMeters = AudioStats.AUDIO_AMPLITUDE_NONE;
        if (size < 2) {
            return AudioStats.AUDIO_AMPLITUDE_NONE;
        }
        int size2 = path.size();
        for (int i = 1; i < size2; i++) {
            int i2 = i - 1;
            dDistanceMeters += distanceMeters(path.get(i2).getLatitude(), path.get(i2).getLongitude(), path.get(i).getLatitude(), path.get(i).getLongitude());
        }
        return dDistanceMeters;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final double projectDistanceOnPath(double latitude, double longitude, List<GlobalSubwayDataManager.RoutePoint> path) {
        if (path.isEmpty()) {
            return AudioStats.AUDIO_AMPLITUDE_NONE;
        }
        if (path.size() == 1) {
            return distanceMeters(latitude, longitude, path.get(0).getLatitude(), path.get(0).getLongitude());
        }
        int size = path.size();
        double d = 0.0d;
        double d2 = 0.0d;
        double d3 = Double.MAX_VALUE;
        for (int i = 1; i < size; i++) {
            GlobalSubwayDataManager.RoutePoint routePoint = path.get(i - 1);
            GlobalSubwayDataManager.RoutePoint routePoint2 = path.get(i);
            double dDistanceMeters = distanceMeters(routePoint.getLatitude(), routePoint.getLongitude(), routePoint2.getLatitude(), routePoint2.getLongitude());
            if (dDistanceMeters > 0.5d) {
                double dCos = Math.cos(Math.toRadians(routePoint.getLatitude())) * 111320.0d;
                double longitude2 = (longitude - routePoint.getLongitude()) * dCos;
                double latitude2 = (latitude - routePoint.getLatitude()) * 111320.0d;
                double longitude3 = (routePoint2.getLongitude() - routePoint.getLongitude()) * dCos;
                double latitude3 = (routePoint2.getLatitude() - routePoint.getLatitude()) * 111320.0d;
                double d4 = (longitude3 * longitude3) + (latitude3 * latitude3);
                double dCoerceIn = d4 <= 0.001d ? 0.0d : RangesKt.coerceIn(((longitude2 * longitude3) + (latitude2 * latitude3)) / d4, AudioStats.AUDIO_AMPLITUDE_NONE, 1.0d);
                double dDistanceMeters2 = distanceMeters(latitude, longitude, routePoint.getLatitude() + ((routePoint2.getLatitude() - routePoint.getLatitude()) * dCoerceIn), routePoint.getLongitude() + ((routePoint2.getLongitude() - routePoint.getLongitude()) * dCoerceIn));
                if (dDistanceMeters2 < d3) {
                    d3 = dDistanceMeters2;
                    d = d2 + (dCoerceIn * dDistanceMeters);
                }
                d2 += dDistanceMeters;
            }
        }
        return d;
    }

    private final double nearestDistanceToPath(double latitude, double longitude, List<GlobalSubwayDataManager.RoutePoint> path) {
        projectDistanceOnPath(latitude, longitude, path);
        if (path.size() < 2) {
            GlobalSubwayDataManager.RoutePoint routePoint = (GlobalSubwayDataManager.RoutePoint) CollectionsKt.firstOrNull((List) path);
            if (routePoint != null) {
                return INSTANCE.distanceMeters(latitude, longitude, routePoint.getLatitude(), routePoint.getLongitude());
            }
            return Double.MAX_VALUE;
        }
        int size = path.size();
        double dMin = Double.MAX_VALUE;
        for (int i = 1; i < size; i++) {
            GlobalSubwayDataManager.RoutePoint routePoint2 = path.get(i - 1);
            GlobalSubwayDataManager.RoutePoint routePoint3 = path.get(i);
            if (distanceMeters(routePoint2.getLatitude(), routePoint2.getLongitude(), routePoint3.getLatitude(), routePoint3.getLongitude()) > 0.5d) {
                double dCos = Math.cos(Math.toRadians(routePoint2.getLatitude())) * 111320.0d;
                double longitude2 = (longitude - routePoint2.getLongitude()) * dCos;
                double latitude2 = (latitude - routePoint2.getLatitude()) * 111320.0d;
                double longitude3 = (routePoint3.getLongitude() - routePoint2.getLongitude()) * dCos;
                double latitude3 = (routePoint3.getLatitude() - routePoint2.getLatitude()) * 111320.0d;
                double d = (longitude3 * longitude3) + (latitude3 * latitude3);
                double dCoerceIn = d <= 0.001d ? AudioStats.AUDIO_AMPLITUDE_NONE : RangesKt.coerceIn(((longitude2 * longitude3) + (latitude2 * latitude3)) / d, AudioStats.AUDIO_AMPLITUDE_NONE, 1.0d);
                dMin = Math.min(dMin, distanceMeters(latitude, longitude, routePoint2.getLatitude() + ((routePoint3.getLatitude() - routePoint2.getLatitude()) * dCoerceIn), routePoint2.getLongitude() + ((routePoint3.getLongitude() - routePoint2.getLongitude()) * dCoerceIn)));
            }
        }
        return dMin;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final float projectToSegment(double pointLat, double pointLon, double startLat, double startLon, double endLat, double endLon) {
        double dCos = Math.cos(Math.toRadians(startLat)) * 111320.0d;
        double d = (pointLon - startLon) * dCos;
        double d2 = (pointLat - startLat) * 111320.0d;
        double d3 = (endLon - startLon) * dCos;
        double d4 = (endLat - startLat) * 111320.0d;
        double d5 = (d3 * d3) + (d4 * d4);
        if (d5 <= 0.001d) {
            return 0.0f;
        }
        return (float) RangesKt.coerceIn(((d * d3) + (d2 * d4)) / d5, AudioStats.AUDIO_AMPLITUDE_NONE, 1.0d);
    }
}
