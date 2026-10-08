package com.example.tickets;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import com.google.firebase.messaging.Constants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: RealtimeTicketLifecycle.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001\"B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\bJ\u001f\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0000¢\u0006\u0002\b\u0012J\u001b\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00142\u0006\u0010\u000b\u001a\u00020\fH\u0000¢\u0006\u0002\b\u0015J\u0010\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u0018\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u0011H\u0002J\u001c\u0010\u001f\u001a\u00020 2\u0006\u0010\u000b\u001a\u00020\f2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00110\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/example/tickets/RealtimeTicketLifecycle;", "", "<init>", "()V", "TICKET_PREFS_NAME", "", "TICKET_PREFS_KEY", "DESTROY_GRACE_MS", "", "reconcile", "Lcom/example/tickets/RealtimeTicketLifecycle$ReconcileResult;", "context", "Landroid/content/Context;", "now", "loadTicketIncludingUsed", "Lcom/example/tickets/TicketData;", "ticketId", "", "loadTicketIncludingUsed$app", "loadActiveTickets", "", "loadActiveTickets$app", "realtimeTicketTypeName", ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "Lcom/example/tickets/TicketType;", "payloadFromJson", "Lcom/example/tickets/LiveUpdatePayload;", "item", "Lorg/json/JSONObject;", "ticketFromJson", "fallbackId", "cancelExpiredRealtimeNotifications", "", "ticketIds", "ReconcileResult", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class RealtimeTicketLifecycle {
    public static final int $stable = 0;
    private static final long DESTROY_GRACE_MS = 300000;
    public static final RealtimeTicketLifecycle INSTANCE = new RealtimeTicketLifecycle();
    private static final String TICKET_PREFS_KEY = "tickets_json";
    private static final String TICKET_PREFS_NAME = "ticket_wallet_storage";

    /* JADX INFO: compiled from: RealtimeTicketLifecycle.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[TicketType.values().length];
            try {
                iArr[TicketType.Movie.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[TicketType.Train.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[TicketType.Airplane.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[TicketType.Event.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[TicketType.Admission.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[TicketType.TakeoutCode.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[TicketType.PickupCode.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private RealtimeTicketLifecycle() {
    }

    /* JADX INFO: compiled from: RealtimeTicketLifecycle.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B#\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J)\u0010\r\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0004HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\t¨\u0006\u0014"}, d2 = {"Lcom/example/tickets/RealtimeTicketLifecycle$ReconcileResult;", "", "autoUsedTicketIds", "", "", "destroyTicketIds", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "getAutoUsedTicketIds", "()Ljava/util/List;", "getDestroyTicketIds", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class ReconcileResult {
        public static final int $stable = 8;
        private final List<Integer> autoUsedTicketIds;
        private final List<Integer> destroyTicketIds;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ReconcileResult copy$default(ReconcileResult reconcileResult, List list, List list2, int i, Object obj) {
            if ((i & 1) != 0) {
                list = reconcileResult.autoUsedTicketIds;
            }
            if ((i & 2) != 0) {
                list2 = reconcileResult.destroyTicketIds;
            }
            return reconcileResult.copy(list, list2);
        }

        public final List<Integer> component1() {
            return this.autoUsedTicketIds;
        }

        public final List<Integer> component2() {
            return this.destroyTicketIds;
        }

        public final ReconcileResult copy(List<Integer> autoUsedTicketIds, List<Integer> destroyTicketIds) {
            Intrinsics.checkNotNullParameter(autoUsedTicketIds, "autoUsedTicketIds");
            Intrinsics.checkNotNullParameter(destroyTicketIds, "destroyTicketIds");
            return new ReconcileResult(autoUsedTicketIds, destroyTicketIds);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ReconcileResult)) {
                return false;
            }
            ReconcileResult reconcileResult = (ReconcileResult) other;
            return Intrinsics.areEqual(this.autoUsedTicketIds, reconcileResult.autoUsedTicketIds) && Intrinsics.areEqual(this.destroyTicketIds, reconcileResult.destroyTicketIds);
        }

        public int hashCode() {
            return (this.autoUsedTicketIds.hashCode() * 31) + this.destroyTicketIds.hashCode();
        }

        public String toString() {
            return "ReconcileResult(autoUsedTicketIds=" + this.autoUsedTicketIds + ", destroyTicketIds=" + this.destroyTicketIds + ")";
        }

        public ReconcileResult(List<Integer> autoUsedTicketIds, List<Integer> destroyTicketIds) {
            Intrinsics.checkNotNullParameter(autoUsedTicketIds, "autoUsedTicketIds");
            Intrinsics.checkNotNullParameter(destroyTicketIds, "destroyTicketIds");
            this.autoUsedTicketIds = autoUsedTicketIds;
            this.destroyTicketIds = destroyTicketIds;
        }

        public final List<Integer> getAutoUsedTicketIds() {
            return this.autoUsedTicketIds;
        }

        public final List<Integer> getDestroyTicketIds() {
            return this.destroyTicketIds;
        }
    }

    public static /* synthetic */ ReconcileResult reconcile$default(RealtimeTicketLifecycle realtimeTicketLifecycle, Context context, long j, int i, Object obj) {
        if ((i & 2) != 0) {
            j = System.currentTimeMillis();
        }
        return realtimeTicketLifecycle.reconcile(context, j);
    }

    public final ReconcileResult reconcile(Context context, long now) throws JSONException {
        Object objM9536constructorimpl;
        int iOptInt;
        Intrinsics.checkNotNullParameter(context, "context");
        SharedPreferences sharedPreferences = context.getSharedPreferences(TICKET_PREFS_NAME, 0);
        String string = sharedPreferences.getString(TICKET_PREFS_KEY, null);
        if (string == null) {
            return new ReconcileResult(CollectionsKt.emptyList(), CollectionsKt.emptyList());
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            RealtimeTicketLifecycle realtimeTicketLifecycle = this;
            objM9536constructorimpl = Result.m9536constructorimpl(new JSONArray(string));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM9536constructorimpl = Result.m9536constructorimpl(ResultKt.createFailure(th));
        }
        JSONArray jSONArray = (JSONArray) (Result.m9542isFailureimpl(objM9536constructorimpl) ? null : objM9536constructorimpl);
        if (jSONArray == null) {
            return new ReconcileResult(CollectionsKt.emptyList(), CollectionsKt.emptyList());
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int length = jSONArray.length();
        boolean z = false;
        for (int i = 0; i < length; i++) {
            JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
            if (jSONObjectOptJSONObject != null && (iOptInt = jSONObjectOptJSONObject.optInt("id", 0)) != 0) {
                long jLongValue = LiveUpdateManager.INSTANCE.resolveWindow(payloadFromJson(jSONObjectOptJSONObject)).getSecond().longValue();
                if (!jSONObjectOptJSONObject.optBoolean("archived", false) && !jSONObjectOptJSONObject.optBoolean("manuallyUsed", false) && jLongValue != Long.MAX_VALUE && now >= jLongValue) {
                    z = true;
                    jSONObjectOptJSONObject.put("manuallyUsed", true);
                    arrayList.add(Integer.valueOf(iOptInt));
                }
                if (jLongValue != Long.MAX_VALUE && now >= jLongValue + DESTROY_GRACE_MS) {
                    arrayList2.add(Integer.valueOf(iOptInt));
                }
            }
        }
        if (z) {
            sharedPreferences.edit().putString(TICKET_PREFS_KEY, jSONArray.toString()).apply();
        }
        return new ReconcileResult(CollectionsKt.distinct(arrayList), CollectionsKt.distinct(arrayList2));
    }

    public final TicketData loadTicketIncludingUsed$app(Context context, int ticketId) {
        Object objM9536constructorimpl;
        Object objM9536constructorimpl2;
        Intrinsics.checkNotNullParameter(context, "context");
        String string = context.getSharedPreferences(TICKET_PREFS_NAME, 0).getString(TICKET_PREFS_KEY, null);
        if (string == null) {
            return null;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            RealtimeTicketLifecycle realtimeTicketLifecycle = this;
            objM9536constructorimpl = Result.m9536constructorimpl(new JSONArray(string));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM9536constructorimpl = Result.m9536constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m9542isFailureimpl(objM9536constructorimpl)) {
            objM9536constructorimpl = null;
        }
        JSONArray jSONArray = (JSONArray) objM9536constructorimpl;
        if (jSONArray == null) {
            return null;
        }
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
            if (jSONObjectOptJSONObject != null && jSONObjectOptJSONObject.optInt("id", 0) == ticketId) {
                try {
                    Result.Companion companion3 = Result.INSTANCE;
                    RealtimeTicketLifecycle realtimeTicketLifecycle2 = this;
                    objM9536constructorimpl2 = Result.m9536constructorimpl(ticketFromJson(jSONObjectOptJSONObject, i + 1));
                } catch (Throwable th2) {
                    Result.Companion companion4 = Result.INSTANCE;
                    objM9536constructorimpl2 = Result.m9536constructorimpl(ResultKt.createFailure(th2));
                }
                return (TicketData) (Result.m9542isFailureimpl(objM9536constructorimpl2) ? null : objM9536constructorimpl2);
            }
        }
        return null;
    }

    public final List<TicketData> loadActiveTickets$app(Context context) {
        Object objM9536constructorimpl;
        Intrinsics.checkNotNullParameter(context, "context");
        String string = context.getSharedPreferences(TICKET_PREFS_NAME, 0).getString(TICKET_PREFS_KEY, null);
        if (string == null) {
            return CollectionsKt.emptyList();
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            RealtimeTicketLifecycle realtimeTicketLifecycle = this;
            objM9536constructorimpl = Result.m9536constructorimpl(new JSONArray(string));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM9536constructorimpl = Result.m9536constructorimpl(ResultKt.createFailure(th));
        }
        JSONArray jSONArray = (JSONArray) (Result.m9542isFailureimpl(objM9536constructorimpl) ? null : objM9536constructorimpl);
        if (jSONArray == null) {
            return CollectionsKt.emptyList();
        }
        List listCreateListBuilder = CollectionsKt.createListBuilder();
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
            if (jSONObjectOptJSONObject != null) {
                try {
                    Result.Companion companion3 = Result.INSTANCE;
                    TicketData ticketDataTicketFromJson = INSTANCE.ticketFromJson(jSONObjectOptJSONObject, i + 1);
                    if (!ticketDataTicketFromJson.getManuallyUsed() && !ticketDataTicketFromJson.getArchived()) {
                        listCreateListBuilder.add(ticketDataTicketFromJson);
                    }
                    Result.m9536constructorimpl(Unit.INSTANCE);
                } catch (Throwable th2) {
                    Result.Companion companion4 = Result.INSTANCE;
                    Result.m9536constructorimpl(ResultKt.createFailure(th2));
                }
            }
        }
        return CollectionsKt.build(listCreateListBuilder);
    }

    private final String realtimeTicketTypeName(TicketType type) {
        switch (WhenMappings.$EnumSwitchMapping$0[type.ordinal()]) {
            case 1:
                return "电影票";
            case 2:
                return "车票";
            case 3:
                return "机票";
            case 4:
                return "演出";
            case 5:
                return "门票";
            case 6:
                return "取餐码";
            case 7:
                return "取件码";
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    private final LiveUpdatePayload payloadFromJson(JSONObject item) {
        Object objM9536constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            RealtimeTicketLifecycle realtimeTicketLifecycle = this;
            String strOptString = item.optString(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "Movie");
            Intrinsics.checkNotNullExpressionValue(strOptString, "optString(...)");
            objM9536constructorimpl = Result.m9536constructorimpl(TicketType.valueOf(strOptString));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM9536constructorimpl = Result.m9536constructorimpl(ResultKt.createFailure(th));
        }
        TicketType ticketType = TicketType.Movie;
        if (Result.m9542isFailureimpl(objM9536constructorimpl)) {
            objM9536constructorimpl = ticketType;
        }
        int iOptInt = item.optInt("id", 0);
        String strRealtimeTicketTypeName = realtimeTicketTypeName((TicketType) objM9536constructorimpl);
        String strOptString2 = item.optString("title");
        Intrinsics.checkNotNullExpressionValue(strOptString2, "optString(...)");
        String strOptString3 = item.optString("code");
        Intrinsics.checkNotNullExpressionValue(strOptString3, "optString(...)");
        String strOptString4 = item.optString("date");
        Intrinsics.checkNotNullExpressionValue(strOptString4, "optString(...)");
        String strOptString5 = item.optString("time");
        Intrinsics.checkNotNullExpressionValue(strOptString5, "optString(...)");
        String strOptString6 = item.optString("departureDate");
        Intrinsics.checkNotNullExpressionValue(strOptString6, "optString(...)");
        String strOptString7 = item.optString("arrivalDate");
        Intrinsics.checkNotNullExpressionValue(strOptString7, "optString(...)");
        String strOptString8 = item.optString(Constants.MessagePayloadKeys.FROM);
        Intrinsics.checkNotNullExpressionValue(strOptString8, "optString(...)");
        String strOptString9 = item.optString("to");
        Intrinsics.checkNotNullExpressionValue(strOptString9, "optString(...)");
        String strOptString10 = item.optString("departurePlatform");
        Intrinsics.checkNotNullExpressionValue(strOptString10, "optString(...)");
        String strOptString11 = item.optString("arrivalPlatform");
        Intrinsics.checkNotNullExpressionValue(strOptString11, "optString(...)");
        String strOptString12 = item.optString("hall");
        Intrinsics.checkNotNullExpressionValue(strOptString12, "optString(...)");
        String strOptString13 = item.optString("seat");
        Intrinsics.checkNotNullExpressionValue(strOptString13, "optString(...)");
        String strOptString14 = item.optString("area");
        Intrinsics.checkNotNullExpressionValue(strOptString14, "optString(...)");
        String strOptString15 = item.optString("entry");
        Intrinsics.checkNotNullExpressionValue(strOptString15, "optString(...)");
        String strOptString16 = item.optString("venue");
        Intrinsics.checkNotNullExpressionValue(strOptString16, "optString(...)");
        String strOptString17 = item.optString("startTime");
        Intrinsics.checkNotNullExpressionValue(strOptString17, "optString(...)");
        String strOptString18 = item.optString("endTime");
        Intrinsics.checkNotNullExpressionValue(strOptString18, "optString(...)");
        String strOptString19 = item.optString("takeoffTime");
        Intrinsics.checkNotNullExpressionValue(strOptString19, "optString(...)");
        String strOptString20 = item.optString("landingTime");
        Intrinsics.checkNotNullExpressionValue(strOptString20, "optString(...)");
        String strOptString21 = item.optString("brand");
        Intrinsics.checkNotNullExpressionValue(strOptString21, "optString(...)");
        return new LiveUpdatePayload(iOptInt, strRealtimeTicketTypeName, strOptString2, strOptString3, strOptString4, strOptString5, strOptString6, strOptString7, strOptString8, strOptString9, strOptString10, strOptString11, strOptString12, strOptString13, strOptString16, strOptString14, strOptString15, strOptString17, strOptString18, strOptString19, strOptString20, strOptString21);
    }

    private final TicketData ticketFromJson(JSONObject item, int fallbackId) {
        Object objM9536constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            RealtimeTicketLifecycle realtimeTicketLifecycle = this;
            String strOptString = item.optString(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "Movie");
            Intrinsics.checkNotNullExpressionValue(strOptString, "optString(...)");
            objM9536constructorimpl = Result.m9536constructorimpl(TicketType.valueOf(strOptString));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM9536constructorimpl = Result.m9536constructorimpl(ResultKt.createFailure(th));
        }
        TicketType ticketType = TicketType.Movie;
        if (Result.m9542isFailureimpl(objM9536constructorimpl)) {
            objM9536constructorimpl = ticketType;
        }
        TicketType ticketType2 = (TicketType) objM9536constructorimpl;
        String strOptString2 = item.optString("imageUri");
        Intrinsics.checkNotNull(strOptString2);
        if (StringsKt.isBlank(strOptString2)) {
            strOptString2 = null;
        }
        String str = strOptString2;
        int iOptInt = item.optInt("id", fallbackId);
        String strOptString3 = item.optString("title");
        Intrinsics.checkNotNullExpressionValue(strOptString3, "optString(...)");
        String strOptString4 = item.optString("code");
        Intrinsics.checkNotNullExpressionValue(strOptString4, "optString(...)");
        String strOptString5 = item.optString("barcodeValue");
        Intrinsics.checkNotNullExpressionValue(strOptString5, "optString(...)");
        String strOptString6 = item.optString("barcodeFormat", "二维码");
        Intrinsics.checkNotNullExpressionValue(strOptString6, "optString(...)");
        String strOptString7 = item.optString("date");
        Intrinsics.checkNotNullExpressionValue(strOptString7, "optString(...)");
        String strOptString8 = item.optString("time");
        Intrinsics.checkNotNullExpressionValue(strOptString8, "optString(...)");
        String strOptString9 = item.optString("departureDate");
        Intrinsics.checkNotNullExpressionValue(strOptString9, "optString(...)");
        String strOptString10 = item.optString("arrivalDate");
        Intrinsics.checkNotNullExpressionValue(strOptString10, "optString(...)");
        String strOptString11 = item.optString(Constants.MessagePayloadKeys.FROM);
        Intrinsics.checkNotNullExpressionValue(strOptString11, "optString(...)");
        String strOptString12 = item.optString("to");
        Intrinsics.checkNotNullExpressionValue(strOptString12, "optString(...)");
        String strOptString13 = item.optString("departurePlatform");
        Intrinsics.checkNotNullExpressionValue(strOptString13, "optString(...)");
        String strOptString14 = item.optString("arrivalPlatform");
        Intrinsics.checkNotNullExpressionValue(strOptString14, "optString(...)");
        String strOptString15 = item.optString("hall");
        Intrinsics.checkNotNullExpressionValue(strOptString15, "optString(...)");
        String strOptString16 = item.optString("seat");
        Intrinsics.checkNotNullExpressionValue(strOptString16, "optString(...)");
        String strOptString17 = item.optString("area");
        Intrinsics.checkNotNullExpressionValue(strOptString17, "optString(...)");
        String strOptString18 = item.optString("entry");
        Intrinsics.checkNotNullExpressionValue(strOptString18, "optString(...)");
        String strOptString19 = item.optString("venue");
        Intrinsics.checkNotNullExpressionValue(strOptString19, "optString(...)");
        String strOptString20 = item.optString("startTime");
        Intrinsics.checkNotNullExpressionValue(strOptString20, "optString(...)");
        String strOptString21 = item.optString("endTime");
        Intrinsics.checkNotNullExpressionValue(strOptString21, "optString(...)");
        String strOptString22 = item.optString("takeoffTime");
        Intrinsics.checkNotNullExpressionValue(strOptString22, "optString(...)");
        String strOptString23 = item.optString("landingTime");
        Intrinsics.checkNotNullExpressionValue(strOptString23, "optString(...)");
        String strOptString24 = item.optString("brand");
        Intrinsics.checkNotNullExpressionValue(strOptString24, "optString(...)");
        return new TicketData(iOptInt, ticketType2, strOptString3, strOptString4, strOptString5, strOptString6, strOptString7, strOptString8, strOptString9, strOptString10, strOptString11, strOptString12, strOptString13, strOptString14, null, null, strOptString15, strOptString16, strOptString17, strOptString18, strOptString19, strOptString20, strOptString21, strOptString22, strOptString23, strOptString24, item.optBoolean("manuallyUsed", false), item.optBoolean("favorite", false), item.optBoolean("archived", false), str, 49152, null);
    }

    public final void cancelExpiredRealtimeNotifications(Context context, List<Integer> ticketIds) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(ticketIds, "ticketIds");
        Iterator it = CollectionsKt.distinct(ticketIds).iterator();
        while (it.hasNext()) {
            int iIntValue = ((Number) it.next()).intValue();
            try {
                Result.Companion companion = Result.INSTANCE;
                LiveUpdateManager.INSTANCE.cancelTicketLiveUpdate(context, iIntValue);
                Result.m9536constructorimpl(Unit.INSTANCE);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                Result.m9536constructorimpl(ResultKt.createFailure(th));
            }
            try {
                Result.Companion companion3 = Result.INSTANCE;
                XiaomiSuperIslandManager.INSTANCE.cancelTicket$app(context, iIntValue);
                Result.m9536constructorimpl(Unit.INSTANCE);
            } catch (Throwable th2) {
                Result.Companion companion4 = Result.INSTANCE;
                Result.m9536constructorimpl(ResultKt.createFailure(th2));
            }
            try {
                Result.Companion companion5 = Result.INSTANCE;
                SamsungNowBarManager.INSTANCE.cancelTicket(context, iIntValue);
                Result.m9536constructorimpl(Unit.INSTANCE);
            } catch (Throwable th3) {
                Result.Companion companion6 = Result.INSTANCE;
                Result.m9536constructorimpl(ResultKt.createFailure(th3));
            }
            try {
                Result.Companion companion7 = Result.INSTANCE;
                RealtimeOngoingNotificationManager.INSTANCE.cancelTicket(context, iIntValue);
                Result.m9536constructorimpl(Unit.INSTANCE);
            } catch (Throwable th4) {
                Result.Companion companion8 = Result.INSTANCE;
                Result.m9536constructorimpl(ResultKt.createFailure(th4));
            }
        }
    }
}
