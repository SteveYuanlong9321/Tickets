package com.example.tickets;

import android.content.Context;
import android.util.Log;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import kotlin.text.Typography;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: FcmTicketManager.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0011\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0016\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\rJ\u000e\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000fJ\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0005H\u0086@¢\u0006\u0002\u0010\u0015J\u0016\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u0005J\u000e\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0019\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u001a\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u001e\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\rJ&\u0010\u001e\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\rH\u0086@¢\u0006\u0002\u0010\u001fJ\u0010\u0010 \u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/example/tickets/FcmTicketManager;", "", "<init>", "()V", "TAG", "", "PREFS", "KEY_ENABLED", "KEY_TOKEN", "KEY_REMINDER_ENABLED", "KEY_INTEGRATION_ENABLED", "REGISTER_ENDPOINT", "isEnabled", "", "context", "Landroid/content/Context;", "setEnabled", "", FcmTicketManager.KEY_ENABLED, "cachedToken", "getToken", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cacheToken", FcmTicketManager.KEY_TOKEN, "clearToken", "savedReminderEnabled", "savedIntegrationEnabled", "saveEnabledSettings", "reminderEnabled", "integrationEnabled", "registerCurrentSettings", "(Landroid/content/Context;ZZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "jsonString", "value", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class FcmTicketManager {
    public static final int $stable = 0;
    public static final FcmTicketManager INSTANCE = new FcmTicketManager();
    private static final String KEY_ENABLED = "enabled";
    private static final String KEY_INTEGRATION_ENABLED = "integration_enabled";
    private static final String KEY_REMINDER_ENABLED = "reminder_enabled";
    private static final String KEY_TOKEN = "token";
    private static final String PREFS = "fcm_prefs";
    private static final String REGISTER_ENDPOINT = "https://tickets-fcm.hyl120309.workers.dev/register";
    private static final String TAG = "FcmTicketManager";

    private FcmTicketManager() {
    }

    public final boolean isEnabled(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return context.getSharedPreferences(PREFS, 0).getBoolean(KEY_ENABLED, false);
    }

    public final void setEnabled(Context context, boolean enabled) {
        Intrinsics.checkNotNullParameter(context, "context");
        context.getSharedPreferences(PREFS, 0).edit().putBoolean(KEY_ENABLED, enabled).apply();
    }

    public final String cachedToken(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        String string = context.getSharedPreferences(PREFS, 0).getString(KEY_TOKEN, "");
        return string == null ? "" : string;
    }

    public final void cacheToken(Context context, String token) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(token, "token");
        context.getSharedPreferences(PREFS, 0).edit().putString(KEY_TOKEN, token).apply();
    }

    public final void clearToken(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        context.getSharedPreferences(PREFS, 0).edit().remove(KEY_TOKEN).apply();
    }

    public final boolean savedReminderEnabled(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return context.getSharedPreferences(PREFS, 0).getBoolean(KEY_REMINDER_ENABLED, false);
    }

    public final boolean savedIntegrationEnabled(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return context.getSharedPreferences(PREFS, 0).getBoolean(KEY_INTEGRATION_ENABLED, false);
    }

    public final void saveEnabledSettings(Context context, boolean reminderEnabled, boolean integrationEnabled) {
        Intrinsics.checkNotNullParameter(context, "context");
        context.getSharedPreferences(PREFS, 0).edit().putBoolean(KEY_REMINDER_ENABLED, reminderEnabled).putBoolean(KEY_INTEGRATION_ENABLED, integrationEnabled).apply();
    }

    /* JADX INFO: renamed from: com.example.tickets.FcmTicketManager$registerCurrentSettings$2, reason: invalid class name */
    /* JADX INFO: compiled from: FcmTicketManager.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.tickets.FcmTicketManager$registerCurrentSettings$2", f = "FcmTicketManager.kt", i = {}, l = {93}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
        final /* synthetic */ Context $context;
        final /* synthetic */ boolean $integrationEnabled;
        final /* synthetic */ boolean $reminderEnabled;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(Context context, boolean z, boolean z2, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$context = context;
            this.$reminderEnabled = z;
            this.$integrationEnabled = z2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.$context, this.$reminderEnabled, this.$integrationEnabled, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Boolean> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            boolean z = true;
            boolean z2 = false;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                if (StringsKt.isBlank(FcmTicketManager.REGISTER_ENDPOINT)) {
                    return Boxing.boxBoolean(false);
                }
                this.label = 1;
                obj = FcmTicketManager.INSTANCE.getToken(this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            String str = (String) obj;
            HttpURLConnection httpURLConnection = null;
            String string = str != null ? StringsKt.trim((CharSequence) str).toString() : null;
            if (string == null) {
                string = "";
            }
            if (StringsKt.isBlank(string)) {
                return Boxing.boxBoolean(false);
            }
            this.$context.getSharedPreferences(FcmTicketManager.PREFS, 0).edit().putString(FcmTicketManager.KEY_TOKEN, string).putBoolean(FcmTicketManager.KEY_REMINDER_ENABLED, this.$reminderEnabled).putBoolean(FcmTicketManager.KEY_INTEGRATION_ENABLED, this.$integrationEnabled).apply();
            try {
                try {
                    URLConnection uRLConnectionOpenConnection = new URL(FcmTicketManager.REGISTER_ENDPOINT).openConnection();
                    Intrinsics.checkNotNull(uRLConnectionOpenConnection, "null cannot be cast to non-null type java.net.HttpURLConnection");
                    HttpURLConnection httpURLConnection2 = (HttpURLConnection) uRLConnectionOpenConnection;
                    httpURLConnection2.setRequestMethod("POST");
                    httpURLConnection2.setConnectTimeout(10000);
                    httpURLConnection2.setReadTimeout(10000);
                    httpURLConnection2.setDoOutput(true);
                    httpURLConnection2.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
                    try {
                        String strJsonString = FcmTicketManager.INSTANCE.jsonString(string);
                        FcmTicketManager fcmTicketManager = FcmTicketManager.INSTANCE;
                        String packageName = this.$context.getPackageName();
                        Intrinsics.checkNotNullExpressionValue(packageName, "getPackageName(...)");
                        String strTrimIndent = StringsKt.trimIndent("\n                {\n                  \"token\": " + strJsonString + ",\n                  \"packageName\": " + fcmTicketManager.jsonString(packageName) + ",\n                  \"reminderEnabled\": " + this.$reminderEnabled + ",\n                  \"integrationEnabled\": " + this.$integrationEnabled + "\n                }\n            ");
                        OutputStream outputStream = httpURLConnection2.getOutputStream();
                        try {
                            byte[] bytes = strTrimIndent.getBytes(Charsets.UTF_8);
                            Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
                            outputStream.write(bytes);
                            Unit unit = Unit.INSTANCE;
                            CloseableKt.closeFinally(outputStream, null);
                            int responseCode = httpURLConnection2.getResponseCode();
                            if (200 <= responseCode && responseCode < 300) {
                                Log.d(FcmTicketManager.TAG, "FCM token registered successfully");
                            } else {
                                Log.w(FcmTicketManager.TAG, "FCM registration failed: HTTP " + responseCode);
                                z = false;
                            }
                            httpURLConnection2.disconnect();
                            z2 = z;
                        } catch (Throwable th) {
                            try {
                                throw th;
                            } catch (Throwable th2) {
                                CloseableKt.closeFinally(outputStream, th);
                                throw th2;
                            }
                        }
                    } catch (Exception e) {
                        e = e;
                        httpURLConnection = httpURLConnection2;
                        Log.w(FcmTicketManager.TAG, "FCM registration request failed", e);
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        httpURLConnection = httpURLConnection2;
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        throw th;
                    }
                } catch (Throwable th4) {
                    th = th4;
                }
            } catch (Exception e2) {
                e = e2;
            }
            return Boxing.boxBoolean(z2);
        }
    }

    public final Object registerCurrentSettings(Context context, boolean z, boolean z2, Continuation<? super Boolean> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new AnonymousClass2(context, z, z2, null), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String jsonString(String value) {
        StringBuilder sb = new StringBuilder("\"");
        String str = value;
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt == '\f') {
                sb.append("\\f");
            } else if (cCharAt == '\r') {
                sb.append("\\r");
            } else if (cCharAt == '\"') {
                sb.append("\\\"");
            } else if (cCharAt == '\\') {
                sb.append("\\\\");
            } else {
                switch (cCharAt) {
                    case '\b':
                        sb.append("\\b");
                        break;
                    case '\t':
                        sb.append("\\t");
                        break;
                    case '\n':
                        sb.append("\\n");
                        break;
                    default:
                        if (cCharAt < ' ') {
                            sb.append("\\u");
                            String string = Integer.toString(cCharAt, CharsKt.checkRadix(16));
                            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                            sb.append(StringsKt.padStart(string, 4, '0'));
                        } else {
                            sb.append(cCharAt);
                        }
                        break;
                }
            }
        }
        sb.append(Typography.quote);
        return sb.toString();
    }

    public final Object getToken(Continuation<? super String> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        final CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
        Task<String> token = FirebaseMessaging.getInstance().getToken();
        final Function1<String, Unit> function1 = new Function1<String, Unit>() { // from class: com.example.tickets.FcmTicketManager$getToken$2$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String str) {
                CancellableContinuation<String> cancellableContinuation = cancellableContinuationImpl2;
                Result.Companion companion = Result.INSTANCE;
                cancellableContinuation.resumeWith(Result.m9536constructorimpl(str));
            }
        };
        token.addOnSuccessListener(new OnSuccessListener(function1) { // from class: com.example.tickets.FcmTicketManager$sam$com_google_android_gms_tasks_OnSuccessListener$0
            private final /* synthetic */ Function1 function;

            {
                Intrinsics.checkNotNullParameter(function1, "function");
                this.function = function1;
            }

            @Override // com.google.android.gms.tasks.OnSuccessListener
            public final /* synthetic */ void onSuccess(Object obj) {
                this.function.invoke(obj);
            }
        }).addOnFailureListener(new OnFailureListener() { // from class: com.example.tickets.FcmTicketManager$getToken$2$2
            @Override // com.google.android.gms.tasks.OnFailureListener
            public final void onFailure(Exception error) {
                Intrinsics.checkNotNullParameter(error, "error");
                Log.w("FcmTicketManager", "Unable to get FCM token", error);
                CancellableContinuation<String> cancellableContinuation = cancellableContinuationImpl2;
                Result.Companion companion = Result.INSTANCE;
                cancellableContinuation.resumeWith(Result.m9536constructorimpl(null));
            }
        });
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }
}
