package com.example.tickets;

import android.content.Context;
import android.content.SharedPreferences;
import android.security.keystore.KeyGenParameterSpec;
import android.util.Base64;
import com.google.android.gms.stats.CodePackage;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.Key;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: OnlineRecognitionStore.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\n\u001a\n \f*\u0004\u0018\u00010\u000b0\u000b2\u0006\u0010\r\u001a\u00020\u000eH\u0002J%\u0010\u000f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0005H\u0000¢\u0006\u0002\b\u0012J%\u0010\u0013\u001a\u00020\u00142\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0005H\u0000¢\u0006\u0002\b\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0002J\u001d\u0010\u0019\u001a\u00020\u00142\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u0005H\u0000¢\u0006\u0002\b\u001bJ\u0015\u0010\u001c\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000eH\u0000¢\u0006\u0002\b\u001dR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/example/tickets/OnlineRecognitionStore;", "", "<init>", "()V", "PREFS", "", "KEY_API_CIPHERTEXT", "KEY_API_IV", "KEYSTORE", "KEY_ALIAS", "getPrefs", "Landroid/content/SharedPreferences;", "kotlin.jvm.PlatformType", "context", "Landroid/content/Context;", "loadString", "key", "defaultValue", "loadString$app", "saveString", "", "value", "saveString$app", "getOrCreateKey", "Ljavax/crypto/SecretKey;", "saveApiKey", "apiKey", "saveApiKey$app", "loadApiKey", "loadApiKey$app", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class OnlineRecognitionStore {
    public static final int $stable = 0;
    public static final OnlineRecognitionStore INSTANCE = new OnlineRecognitionStore();
    private static final String KEYSTORE = "AndroidKeyStore";
    private static final String KEY_ALIAS = "ticket_online_recognition_api_key";
    private static final String KEY_API_CIPHERTEXT = "api_key_ciphertext";
    private static final String KEY_API_IV = "api_key_iv";
    private static final String PREFS = "online_recognition_settings";

    private OnlineRecognitionStore() {
    }

    private final SharedPreferences getPrefs(Context context) {
        return context.getSharedPreferences(PREFS, 0);
    }

    public final String loadString$app(Context context, String key, String defaultValue) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        String string = getPrefs(context).getString(key, defaultValue);
        return string == null ? defaultValue : string;
    }

    public final void saveString$app(Context context, String key, String value) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        getPrefs(context).edit().putString(key, value).apply();
    }

    private final SecretKey getOrCreateKey() throws NoSuchAlgorithmException, UnrecoverableKeyException, IOException, KeyStoreException, CertificateException, NoSuchProviderException, InvalidAlgorithmParameterException {
        KeyStore keyStore = KeyStore.getInstance(KEYSTORE);
        keyStore.load(null);
        Key key = keyStore.getKey(KEY_ALIAS, null);
        if (key instanceof SecretKey) {
            return (SecretKey) key;
        }
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES", KEYSTORE);
        keyGenerator.init(new KeyGenParameterSpec.Builder(KEY_ALIAS, 3).setBlockModes(CodePackage.GCM).setEncryptionPaddings("NoPadding").setUserAuthenticationRequired(false).build());
        SecretKey secretKeyGenerateKey = keyGenerator.generateKey();
        Intrinsics.checkNotNullExpressionValue(secretKeyGenerateKey, "generateKey(...)");
        return secretKeyGenerateKey;
    }

    public final void saveApiKey$app(Context context, String apiKey) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(apiKey, "apiKey");
        SharedPreferences prefs = getPrefs(context);
        if (StringsKt.isBlank(apiKey)) {
            prefs.edit().remove(KEY_API_CIPHERTEXT).remove(KEY_API_IV).apply();
            return;
        }
        try {
            Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
            cipher.init(1, getOrCreateKey());
            byte[] bytes = apiKey.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
            prefs.edit().putString(KEY_API_CIPHERTEXT, Base64.encodeToString(cipher.doFinal(bytes), 2)).putString(KEY_API_IV, Base64.encodeToString(cipher.getIV(), 2)).apply();
        } catch (Exception unused) {
        }
    }

    public final String loadApiKey$app(Context context) {
        String string;
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            SharedPreferences prefs = getPrefs(context);
            String string2 = prefs.getString(KEY_API_CIPHERTEXT, null);
            if (string2 == null || (string = prefs.getString(KEY_API_IV, null)) == null) {
                return "";
            }
            Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
            cipher.init(2, getOrCreateKey(), new GCMParameterSpec(128, Base64.decode(string, 2)));
            byte[] bArrDoFinal = cipher.doFinal(Base64.decode(string2, 2));
            Intrinsics.checkNotNull(bArrDoFinal);
            return new String(bArrDoFinal, Charsets.UTF_8);
        } catch (Exception unused) {
            return "";
        }
    }
}
