package com.example.tickets;

import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.CloseableKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: GlobalSubwayData.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "Lcom/example/tickets/GlobalSubwayDataManager$NycRealtimeOverlay;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.example.tickets.GlobalSubwayDataManager$fetchNycRealtimeOverlay$2", f = "GlobalSubwayData.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class GlobalSubwayDataManager$fetchNycRealtimeOverlay$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends GlobalSubwayDataManager.NycRealtimeOverlay>>, Object> {
    final /* synthetic */ Set<String> $routeIds;
    final /* synthetic */ Set<String> $stationKeys;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    GlobalSubwayDataManager$fetchNycRealtimeOverlay$2(Set<String> set, Set<String> set2, Continuation<? super GlobalSubwayDataManager$fetchNycRealtimeOverlay$2> continuation) {
        super(2, continuation);
        this.$routeIds = set;
        this.$stationKeys = set2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        GlobalSubwayDataManager$fetchNycRealtimeOverlay$2 globalSubwayDataManager$fetchNycRealtimeOverlay$2 = new GlobalSubwayDataManager$fetchNycRealtimeOverlay$2(this.$routeIds, this.$stationKeys, continuation);
        globalSubwayDataManager$fetchNycRealtimeOverlay$2.L$0 = obj;
        return globalSubwayDataManager$fetchNycRealtimeOverlay$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends GlobalSubwayDataManager.NycRealtimeOverlay>> continuation) {
        return invoke2(coroutineScope, (Continuation<? super List<GlobalSubwayDataManager.NycRealtimeOverlay>>) continuation);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super List<GlobalSubwayDataManager.NycRealtimeOverlay>> continuation) {
        return ((GlobalSubwayDataManager$fetchNycRealtimeOverlay$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object objM9536constructorimpl;
        String str = "nextDepartureEpochSec";
        String str2 = "nextArrivalEpochSec";
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        int i = 0;
        String str3 = null;
        if (StringsKt.contains$default((CharSequence) "https://tickets-us-transit.hyl120309.workers.dev", (CharSequence) "YOUR-US-TRANSIT-WORKER", false, 2, (Object) null)) {
            return CollectionsKt.emptyList();
        }
        Set<String> set = this.$routeIds;
        StringBuilder sb = new StringBuilder();
        sb.append(StringsKt.trimEnd("https://tickets-us-transit.hyl120309.workers.dev", '/'));
        sb.append("/api/v1/nyc/realtime");
        if (!set.isEmpty()) {
            sb.append("?routes=");
            sb.append(URLEncoder.encode(CollectionsKt.joinToString$default(CollectionsKt.sorted(set), ",", null, null, 0, null, null, 62, null), "UTF-8"));
        }
        String string = sb.toString();
        Set<String> set2 = this.$stationKeys;
        try {
            Result.Companion companion = Result.INSTANCE;
            URLConnection uRLConnectionOpenConnection = new URL(string).openConnection();
            Intrinsics.checkNotNull(uRLConnectionOpenConnection, "null cannot be cast to non-null type java.net.HttpURLConnection");
            HttpURLConnection httpURLConnection = (HttpURLConnection) uRLConnectionOpenConnection;
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setConnectTimeout(12000);
            httpURLConnection.setReadTimeout(AccessibilityNodeInfoCompat.EXTRA_DATA_TEXT_CHARACTER_LOCATION_ARG_MAX_LENGTH);
            httpURLConnection.setInstanceFollowRedirects(true);
            httpURLConnection.setRequestProperty("Accept", "application/json");
            httpURLConnection.setRequestProperty("User-Agent", "Tickets/6.0 NYCTransit");
            try {
                int responseCode = httpURLConnection.getResponseCode();
                if (200 > responseCode || responseCode >= 300) {
                    throw new IllegalStateException("US Transit Worker realtime HTTP " + httpURLConnection.getResponseCode());
                }
                InputStream inputStream = httpURLConnection.getInputStream();
                Intrinsics.checkNotNullExpressionValue(inputStream, "getInputStream(...)");
                Reader inputStreamReader = new InputStreamReader(inputStream, Charsets.UTF_8);
                BufferedReader bufferedReader = inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, 8192);
                try {
                    String text = TextStreamsKt.readText(bufferedReader);
                    CloseableKt.closeFinally(bufferedReader, null);
                    JSONArray jSONArrayOptJSONArray = new JSONObject(text).optJSONArray("overlays");
                    if (jSONArrayOptJSONArray == null) {
                        jSONArrayOptJSONArray = new JSONArray();
                    }
                    ArrayList arrayList = new ArrayList(jSONArrayOptJSONArray.length());
                    int length = jSONArrayOptJSONArray.length();
                    while (i < length) {
                        JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
                        if (jSONObjectOptJSONObject != null) {
                            String strOptString = jSONObjectOptJSONObject.optString("currentStationKey");
                            Intrinsics.checkNotNull(strOptString);
                            if (StringsKt.isBlank(strOptString)) {
                                strOptString = str3;
                            }
                            String strOptString2 = jSONObjectOptJSONObject.optString("nextStationKey");
                            Intrinsics.checkNotNull(strOptString2);
                            if (StringsKt.isBlank(strOptString2)) {
                                strOptString2 = str3;
                            }
                            if (set2.isEmpty() || CollectionsKt.contains(set2, strOptString) || CollectionsKt.contains(set2, strOptString2)) {
                                ArrayList arrayList2 = arrayList;
                                String strOptString3 = jSONObjectOptJSONObject.optString("tripId");
                                Intrinsics.checkNotNullExpressionValue(strOptString3, "optString(...)");
                                String strOptString4 = jSONObjectOptJSONObject.optString("routeId");
                                Intrinsics.checkNotNullExpressionValue(strOptString4, "optString(...)");
                                String strOptString5 = jSONObjectOptJSONObject.optString("directionId");
                                Intrinsics.checkNotNullExpressionValue(strOptString5, "optString(...)");
                                String strOptString6 = jSONObjectOptJSONObject.optString("startDate");
                                Intrinsics.checkNotNullExpressionValue(strOptString6, "optString(...)");
                                String strOptString7 = jSONObjectOptJSONObject.optString("headsign");
                                Intrinsics.checkNotNullExpressionValue(strOptString7, "optString(...)");
                                Integer numBoxInt = jSONObjectOptJSONObject.has("currentStopSequence") ? Boxing.boxInt(jSONObjectOptJSONObject.optInt("currentStopSequence")) : null;
                                Integer numBoxInt2 = jSONObjectOptJSONObject.has("nextStopSequence") ? Boxing.boxInt(jSONObjectOptJSONObject.optInt("nextStopSequence")) : null;
                                Long lBoxLong = jSONObjectOptJSONObject.has(str2) ? Boxing.boxLong(jSONObjectOptJSONObject.optLong(str2)) : null;
                                Long lBoxLong2 = jSONObjectOptJSONObject.has(str) ? Boxing.boxLong(jSONObjectOptJSONObject.optLong(str)) : null;
                                Integer numBoxInt3 = (!jSONObjectOptJSONObject.has("delaySec") || jSONObjectOptJSONObject.isNull("delaySec")) ? null : Boxing.boxInt(jSONObjectOptJSONObject.optInt("delaySec"));
                                String strOptString8 = jSONObjectOptJSONObject.optString("scheduleRelationship", "UNKNOWN");
                                Intrinsics.checkNotNullExpressionValue(strOptString8, "optString(...)");
                                String strOptString9 = jSONObjectOptJSONObject.optString("sourceFeed");
                                Intrinsics.checkNotNullExpressionValue(strOptString9, "optString(...)");
                                arrayList2.add(new GlobalSubwayDataManager.NycRealtimeOverlay(strOptString3, strOptString4, strOptString5, strOptString6, strOptString7, strOptString, strOptString2, numBoxInt, numBoxInt2, lBoxLong, lBoxLong2, numBoxInt3, strOptString8, strOptString9, jSONObjectOptJSONObject.optLong("updatedAt", 0L)));
                            }
                        }
                        i++;
                        set2 = set2;
                        str = str;
                        str2 = str2;
                        str3 = null;
                    }
                    httpURLConnection.disconnect();
                    objM9536constructorimpl = Result.m9536constructorimpl(arrayList);
                    return Result.m9542isFailureimpl(objM9536constructorimpl) ? CollectionsKt.emptyList() : objM9536constructorimpl;
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        CloseableKt.closeFinally(bufferedReader, th);
                        throw th2;
                    }
                }
            } catch (Throwable th3) {
                httpURLConnection.disconnect();
                throw th3;
            }
        } catch (Throwable th4) {
            Result.Companion companion2 = Result.INSTANCE;
            objM9536constructorimpl = Result.m9536constructorimpl(ResultKt.createFailure(th4));
        }
    }
}
