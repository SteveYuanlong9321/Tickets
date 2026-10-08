package com.example.tickets;

import android.app.Activity;
import android.content.Context;
import android.nfc.NdefMessage;
import android.nfc.NdefRecord;
import android.nfc.NfcAdapter;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: TicketNfcCompatibility.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÁ\u0002\u0018\u00002\u00020\u0001:\u0001\u0016B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ \u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0005J\u0010\u0010\u0011\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eJ\u001e\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/example/tickets/TicketNfcCompatibility;", "", "<init>", "()V", "MIME_TYPE", "", "LEGACY_PREFIX", "preferredMode", "Lcom/example/tickets/TicketNfcCompatibility$Mode;", "context", "Landroid/content/Context;", "startLegacySender", "", "activity", "Landroid/app/Activity;", "sessionId", "token", "stopLegacySender", "parseLegacyNdef", "Lkotlin/Pair;", "message", "Landroid/nfc/NdefMessage;", "Mode", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class TicketNfcCompatibility {
    public static final int $stable = 0;
    public static final TicketNfcCompatibility INSTANCE = new TicketNfcCompatibility();
    private static final String LEGACY_PREFIX = "TicketsNfcSession:v1:";
    private static final String MIME_TYPE = "application/vnd.com.example.tickets.session";

    /* JADX INFO: compiled from: TicketNfcCompatibility.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/example/tickets/TicketNfcCompatibility$Mode;", "", "<init>", "(Ljava/lang/String;I)V", "HCE", "LEGACY_NDEF_OR_NEARBY", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public enum Mode {
        HCE,
        LEGACY_NDEF_OR_NEARBY;

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

        public static EnumEntries<Mode> getEntries() {
            return $ENTRIES;
        }
    }

    private TicketNfcCompatibility() {
    }

    public final Mode preferredMode(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        NfcAdapter defaultAdapter = NfcAdapter.getDefaultAdapter(context);
        if (defaultAdapter == null) {
            return Mode.HCE;
        }
        if (context.getPackageManager().hasSystemFeature("android.hardware.nfc") && defaultAdapter.isEnabled()) {
            return context.getPackageManager().hasSystemFeature("android.hardware.nfc.hce") ? Mode.HCE : Mode.LEGACY_NDEF_OR_NEARBY;
        }
        return Mode.HCE;
    }

    public final void startLegacySender(Activity activity, String sessionId, String token) {
        NfcAdapter defaultAdapter;
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(token, "token");
        if (activity == null || StringsKt.isBlank(sessionId) || StringsKt.isBlank(token) || (defaultAdapter = NfcAdapter.getDefaultAdapter(activity)) == null) {
            return;
        }
        String strEncryptToEnvelope = TicketTransferCrypto.INSTANCE.encryptToEnvelope(sessionId + "|" + token);
        StringBuilder sb = new StringBuilder(LEGACY_PREFIX);
        sb.append(strEncryptToEnvelope);
        String string = sb.toString();
        Charset UTF_8 = StandardCharsets.UTF_8;
        Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
        byte[] bytes = string.getBytes(UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        final NdefMessage ndefMessage = new NdefMessage(new NdefRecord[]{NdefRecord.createMime(MIME_TYPE, bytes)});
        try {
            Result.Companion companion = Result.INSTANCE;
            TicketNfcCompatibility ticketNfcCompatibility = this;
            Class<?> cls = Class.forName("android.nfc.NfcAdapter$CreateNdefMessageCallback");
            Result.m9536constructorimpl(NfcAdapter.class.getMethod("setNdefPushMessageCallback", cls, Activity.class).invoke(defaultAdapter, Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new InvocationHandler() { // from class: com.example.tickets.TicketNfcCompatibility$$ExternalSyntheticLambda0
                @Override // java.lang.reflect.InvocationHandler
                public final Object invoke(Object obj, Method method, Object[] objArr) {
                    return TicketNfcCompatibility.startLegacySender$lambda$1$lambda$0(ndefMessage, obj, method, objArr);
                }
            }), activity));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m9536constructorimpl(ResultKt.createFailure(th));
        }
    }

    static final Object startLegacySender$lambda$1$lambda$0(NdefMessage ndefMessage, Object obj, Method method, Object[] objArr) {
        if (Intrinsics.areEqual(method.getName(), "createNdefMessage")) {
            return ndefMessage;
        }
        return null;
    }

    public final void stopLegacySender(Activity activity) {
        NfcAdapter defaultAdapter;
        if (activity == null || (defaultAdapter = NfcAdapter.getDefaultAdapter(activity)) == null) {
            return;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            TicketNfcCompatibility ticketNfcCompatibility = this;
            Result.m9536constructorimpl(NfcAdapter.class.getMethod("setNdefPushMessageCallback", Class.forName("android.nfc.NfcAdapter$CreateNdefMessageCallback"), Activity.class).invoke(defaultAdapter, null, activity));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m9536constructorimpl(ResultKt.createFailure(th));
        }
    }

    public final Pair<String, String> parseLegacyNdef(NdefMessage message) {
        NdefRecord[] records;
        NdefRecord ndefRecord;
        String strDecryptEnvelope;
        if (message == null || (records = message.getRecords()) == null) {
            return null;
        }
        int length = records.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                ndefRecord = null;
                break;
            }
            ndefRecord = records[i];
            byte[] type = ndefRecord.getType();
            Charset US_ASCII = StandardCharsets.US_ASCII;
            Intrinsics.checkNotNullExpressionValue(US_ASCII, "US_ASCII");
            byte[] bytes = MIME_TYPE.getBytes(US_ASCII);
            Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
            if (Arrays.equals(type, bytes)) {
                break;
            }
            i++;
        }
        if (ndefRecord == null) {
            return null;
        }
        byte[] payload = ndefRecord.getPayload();
        Intrinsics.checkNotNullExpressionValue(payload, "getPayload(...)");
        Charset UTF_8 = StandardCharsets.UTF_8;
        Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
        String str = new String(payload, UTF_8);
        if (!StringsKt.startsWith$default(str, LEGACY_PREFIX, false, 2, (Object) null) || (strDecryptEnvelope = TicketTransferCrypto.INSTANCE.decryptEnvelope(StringsKt.removePrefix(str, (CharSequence) LEGACY_PREFIX))) == null) {
            return null;
        }
        List listSplit$default = StringsKt.split$default((CharSequence) strDecryptEnvelope, new String[]{"|"}, false, 2, 2, (Object) null);
        if (listSplit$default.size() != 2 || StringsKt.isBlank((CharSequence) listSplit$default.get(0)) || StringsKt.isBlank((CharSequence) listSplit$default.get(1))) {
            return null;
        }
        return TuplesKt.to(listSplit$default.get(0), listSplit$default.get(1));
    }
}
