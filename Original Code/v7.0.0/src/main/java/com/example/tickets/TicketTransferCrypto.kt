package com.example.tickets;

import android.util.Base64;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.util.List;
import javax.crypto.Cipher;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: TicketTransferCrypto.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0013\u001a\u00020\u0014H\u0002J\u000e\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0005J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0018\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\r\u001a\u00020\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0019"}, d2 = {"Lcom/example/tickets/TicketTransferCrypto;", "", "<init>", "()V", "FIXED_AES_KEY", "", "TRANSFORM", "IV_LENGTH", "", "TAG_LENGTH_BITS", "ENVELOPE_PREFIX", "secureRandom", "Ljava/security/SecureRandom;", "keyBytes", "", "getKeyBytes", "()[B", "keyBytes$delegate", "Lkotlin/Lazy;", "keySpec", "Ljavax/crypto/spec/SecretKeySpec;", "encryptToEnvelope", "plainText", "decryptEnvelope", "envelope", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class TicketTransferCrypto {
    private static final String ENVELOPE_PREFIX = "TKT_AES_GCM_V1|";
    private static final String FIXED_AES_KEY = "SteveYuanlong309";
    private static final int IV_LENGTH = 12;
    private static final int TAG_LENGTH_BITS = 128;
    private static final String TRANSFORM = "AES/GCM/NoPadding";
    public static final TicketTransferCrypto INSTANCE = new TicketTransferCrypto();
    private static final SecureRandom secureRandom = new SecureRandom();

    /* JADX INFO: renamed from: keyBytes$delegate, reason: from kotlin metadata */
    private static final Lazy keyBytes = LazyKt.lazy(new Function0() { // from class: com.example.tickets.TicketTransferCrypto$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return TicketTransferCrypto.keyBytes_delegate$lambda$2();
        }
    });
    public static final int $stable = 8;

    private TicketTransferCrypto() {
    }

    private final byte[] getKeyBytes() {
        return (byte[]) keyBytes.getValue();
    }

    static final byte[] keyBytes_delegate$lambda$2() {
        Charset UTF_8 = StandardCharsets.UTF_8;
        Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
        byte[] bytes = FIXED_AES_KEY.getBytes(UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        if (bytes.length == 16) {
            return bytes;
        }
        throw new IllegalArgumentException("FIXED_AES_KEY must be exactly 16 UTF-8 bytes for AES-128".toString());
    }

    private final SecretKeySpec keySpec() {
        return new SecretKeySpec(getKeyBytes(), "AES");
    }

    public final String encryptToEnvelope(String plainText) {
        Intrinsics.checkNotNullParameter(plainText, "plainText");
        byte[] bArr = new byte[12];
        secureRandom.nextBytes(bArr);
        Cipher cipher = Cipher.getInstance(TRANSFORM);
        cipher.init(1, keySpec(), new GCMParameterSpec(128, bArr));
        Charset UTF_8 = StandardCharsets.UTF_8;
        Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
        byte[] bytes = plainText.getBytes(UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        byte[] bArrDoFinal = cipher.doFinal(bytes);
        return ENVELOPE_PREFIX + Base64.encodeToString(bArr, 10) + "|" + Base64.encodeToString(bArrDoFinal, 10);
    }

    public final String decryptEnvelope(String envelope) {
        Object objM9536constructorimpl;
        Intrinsics.checkNotNullParameter(envelope, "envelope");
        if (!StringsKt.startsWith$default(envelope, ENVELOPE_PREFIX, false, 2, (Object) null)) {
            return null;
        }
        List listSplit$default = StringsKt.split$default((CharSequence) StringsKt.removePrefix(envelope, (CharSequence) ENVELOPE_PREFIX), new char[]{'|'}, false, 2, 2, (Object) null);
        if (listSplit$default.size() != 2) {
            return null;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            TicketTransferCrypto ticketTransferCrypto = this;
            byte[] bArrDecode = Base64.decode((String) listSplit$default.get(0), 10);
            byte[] bArrDecode2 = Base64.decode((String) listSplit$default.get(1), 10);
            if (bArrDecode.length == 12) {
                Intrinsics.checkNotNull(bArrDecode2);
                if (bArrDecode2.length != 0) {
                    Cipher cipher = Cipher.getInstance(TRANSFORM);
                    cipher.init(2, keySpec(), new GCMParameterSpec(128, bArrDecode));
                    byte[] bArrDoFinal = cipher.doFinal(bArrDecode2);
                    Intrinsics.checkNotNullExpressionValue(bArrDoFinal, "doFinal(...)");
                    Charset UTF_8 = StandardCharsets.UTF_8;
                    Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
                    objM9536constructorimpl = Result.m9536constructorimpl(new String(bArrDoFinal, UTF_8));
                }
                return (String) (Result.m9542isFailureimpl(objM9536constructorimpl) ? null : objM9536constructorimpl);
            }
            return null;
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM9536constructorimpl = Result.m9536constructorimpl(ResultKt.createFailure(th));
        }
    }
}
