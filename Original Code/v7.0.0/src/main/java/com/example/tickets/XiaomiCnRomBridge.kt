package com.example.tickets;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import androidx.compose.runtime.composer.linkbuffer.GroupFlagsKt;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: XiaomiCnRomBridge.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001#B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u0011J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\u000fJ\u0006\u0010\u0014\u001a\u00020\u0015J\u0006\u0010\u0016\u001a\u00020\u0015J\u000e\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u000e\u001a\u00020\u000fJ\u0006\u0010\u001a\u001a\u00020\u0015J\u0006\u0010\u001b\u001a\u00020\u0015J\u000e\u0010\u001c\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0010\u0010\u001d\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\b\u0010\u001e\u001a\u00020\u0015H\u0002J\b\u0010\u001f\u001a\u00020\u0015H\u0002J\u0010\u0010 \u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0010\u0010!\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/example/tickets/XiaomiCnRomBridge;", "", "<init>", "()V", "TAG", "", "SHIZUKU_PERMISSION_REQUEST_CODE", "", "PREFS_NAME", "KEY_SETUP_PROMPTED", "SHIZUKU_PACKAGE", "SHIZUKU_CLASS", "ensureReady", "", "context", "Landroid/content/Context;", "onReady", "Lkotlin/Function0;", "detect", "Lcom/example/tickets/XiaomiCnRomBridge$Capability;", "isXiaomiFamily", "", "isCnRom", "hasFocusPermission", "focusProtocol", "islandSupported", "shizukuAvailable", "shizukuPermissionGranted", "openShizuku", "requestOrOpenShizuku", "shizukuAvailableInternal", "shizukuPermissionGrantedInternal", "readFocusProtocol", "readSystemProperty", "key", "Capability", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class XiaomiCnRomBridge {
    public static final int $stable = 0;
    public static final XiaomiCnRomBridge INSTANCE = new XiaomiCnRomBridge();
    private static final String KEY_SETUP_PROMPTED = "setup_prompted";
    private static final String PREFS_NAME = "tickets_xiaomi_cn_bridge";
    private static final String SHIZUKU_CLASS = "rikka.shizuku.Shizuku";
    private static final String SHIZUKU_PACKAGE = "moe.shizuku.privileged.api";
    private static final int SHIZUKU_PERMISSION_REQUEST_CODE = 51001;
    private static final String TAG = "TicketsXiaomiBridge";

    private XiaomiCnRomBridge() {
    }

    /* JADX INFO: compiled from: XiaomiCnRomBridge.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u001d\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003JO\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u0003HÆ\u0001J\u0013\u0010 \u001a\u00020\u00032\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020\u0006HÖ\u0001J\t\u0010#\u001a\u00020$HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\rR\u0011\u0010\u0014\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\rR\u0011\u0010\u0016\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\r¨\u0006%"}, d2 = {"Lcom/example/tickets/XiaomiCnRomBridge$Capability;", "", "isXiaomiFamily", "", "isCnRom", "focusProtocol", "", "islandPropertyAvailable", "focusPermission", "shizukuAvailable", "shizukuPermissionGranted", "<init>", "(ZZIZZZZ)V", "()Z", "getFocusProtocol", "()I", "getIslandPropertyAvailable", "getFocusPermission", "getShizukuAvailable", "getShizukuPermissionGranted", "focusSupported", "getFocusSupported", "islandSupported", "getIslandSupported", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "toString", "", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Capability {
        public static final int $stable = 0;
        private final boolean focusPermission;
        private final int focusProtocol;
        private final boolean isCnRom;
        private final boolean isXiaomiFamily;
        private final boolean islandPropertyAvailable;
        private final boolean shizukuAvailable;
        private final boolean shizukuPermissionGranted;

        public static /* synthetic */ Capability copy$default(Capability capability, boolean z, boolean z2, int i, boolean z3, boolean z4, boolean z5, boolean z6, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                z = capability.isXiaomiFamily;
            }
            if ((i2 & 2) != 0) {
                z2 = capability.isCnRom;
            }
            if ((i2 & 4) != 0) {
                i = capability.focusProtocol;
            }
            if ((i2 & 8) != 0) {
                z3 = capability.islandPropertyAvailable;
            }
            if ((i2 & 16) != 0) {
                z4 = capability.focusPermission;
            }
            if ((i2 & 32) != 0) {
                z5 = capability.shizukuAvailable;
            }
            if ((i2 & 64) != 0) {
                z6 = capability.shizukuPermissionGranted;
            }
            boolean z7 = z5;
            boolean z8 = z6;
            boolean z9 = z4;
            int i3 = i;
            return capability.copy(z, z2, i3, z3, z9, z7, z8);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final boolean getIsXiaomiFamily() {
            return this.isXiaomiFamily;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final boolean getIsCnRom() {
            return this.isCnRom;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final int getFocusProtocol() {
            return this.focusProtocol;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final boolean getIslandPropertyAvailable() {
            return this.islandPropertyAvailable;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final boolean getFocusPermission() {
            return this.focusPermission;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final boolean getShizukuAvailable() {
            return this.shizukuAvailable;
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        public final boolean getShizukuPermissionGranted() {
            return this.shizukuPermissionGranted;
        }

        public final Capability copy(boolean isXiaomiFamily, boolean isCnRom, int focusProtocol, boolean islandPropertyAvailable, boolean focusPermission, boolean shizukuAvailable, boolean shizukuPermissionGranted) {
            return new Capability(isXiaomiFamily, isCnRom, focusProtocol, islandPropertyAvailable, focusPermission, shizukuAvailable, shizukuPermissionGranted);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Capability)) {
                return false;
            }
            Capability capability = (Capability) other;
            return this.isXiaomiFamily == capability.isXiaomiFamily && this.isCnRom == capability.isCnRom && this.focusProtocol == capability.focusProtocol && this.islandPropertyAvailable == capability.islandPropertyAvailable && this.focusPermission == capability.focusPermission && this.shizukuAvailable == capability.shizukuAvailable && this.shizukuPermissionGranted == capability.shizukuPermissionGranted;
        }

        public int hashCode() {
            return (((((((((((Boolean.hashCode(this.isXiaomiFamily) * 31) + Boolean.hashCode(this.isCnRom)) * 31) + Integer.hashCode(this.focusProtocol)) * 31) + Boolean.hashCode(this.islandPropertyAvailable)) * 31) + Boolean.hashCode(this.focusPermission)) * 31) + Boolean.hashCode(this.shizukuAvailable)) * 31) + Boolean.hashCode(this.shizukuPermissionGranted);
        }

        public String toString() {
            return "Capability(isXiaomiFamily=" + this.isXiaomiFamily + ", isCnRom=" + this.isCnRom + ", focusProtocol=" + this.focusProtocol + ", islandPropertyAvailable=" + this.islandPropertyAvailable + ", focusPermission=" + this.focusPermission + ", shizukuAvailable=" + this.shizukuAvailable + ", shizukuPermissionGranted=" + this.shizukuPermissionGranted + ")";
        }

        public Capability(boolean z, boolean z2, int i, boolean z3, boolean z4, boolean z5, boolean z6) {
            this.isXiaomiFamily = z;
            this.isCnRom = z2;
            this.focusProtocol = i;
            this.islandPropertyAvailable = z3;
            this.focusPermission = z4;
            this.shizukuAvailable = z5;
            this.shizukuPermissionGranted = z6;
        }

        public final boolean isXiaomiFamily() {
            return this.isXiaomiFamily;
        }

        public final boolean isCnRom() {
            return this.isCnRom;
        }

        public final int getFocusProtocol() {
            return this.focusProtocol;
        }

        public final boolean getIslandPropertyAvailable() {
            return this.islandPropertyAvailable;
        }

        public final boolean getFocusPermission() {
            return this.focusPermission;
        }

        public final boolean getShizukuAvailable() {
            return this.shizukuAvailable;
        }

        public final boolean getShizukuPermissionGranted() {
            return this.shizukuPermissionGranted;
        }

        public final boolean getFocusSupported() {
            return this.isXiaomiFamily && this.focusPermission;
        }

        public final boolean getIslandSupported() {
            return this.isXiaomiFamily && this.islandPropertyAvailable && this.focusPermission;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void ensureReady$default(XiaomiCnRomBridge xiaomiCnRomBridge, Context context, Function0 function0, int i, Object obj) {
        if ((i & 2) != 0) {
            function0 = null;
        }
        xiaomiCnRomBridge.ensureReady(context, function0);
    }

    public final void ensureReady(Context context, Function0<Unit> onReady) {
        Intrinsics.checkNotNullParameter(context, "context");
        Context applicationContext = context.getApplicationContext();
        if (!isXiaomiFamily()) {
            if (onReady != null) {
                onReady.invoke();
                return;
            }
            return;
        }
        Intrinsics.checkNotNull(applicationContext);
        Capability capabilityDetect = detect(applicationContext);
        if (!capabilityDetect.isCnRom() || capabilityDetect.getFocusPermission()) {
            if (onReady != null) {
                onReady.invoke();
                return;
            }
            return;
        }
        SharedPreferences sharedPreferences = applicationContext.getSharedPreferences(PREFS_NAME, 0);
        if (!sharedPreferences.getBoolean(KEY_SETUP_PROMPTED, false)) {
            sharedPreferences.edit().putBoolean(KEY_SETUP_PROMPTED, true).apply();
            requestOrOpenShizuku(applicationContext);
        }
        if (onReady != null) {
            onReady.invoke();
        }
    }

    public final Capability detect(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        boolean zIsXiaomiFamily = isXiaomiFamily();
        boolean z = zIsXiaomiFamily && isCnRom();
        int focusProtocol = readFocusProtocol(context);
        String systemProperty = readSystemProperty("persist.sys.feature.island");
        boolean z2 = (StringsKt.isBlank(systemProperty) || Intrinsics.areEqual(systemProperty, "0") || StringsKt.equals(systemProperty, "false", true)) ? false : true;
        boolean z3 = zIsXiaomiFamily && hasFocusPermission(context);
        boolean zShizukuAvailableInternal = shizukuAvailableInternal();
        return new Capability(zIsXiaomiFamily, z, focusProtocol, z2, z3, zShizukuAvailableInternal, zShizukuAvailableInternal && shizukuPermissionGrantedInternal());
    }

    public final boolean isXiaomiFamily() {
        String str = Build.MANUFACTURER;
        if (str == null) {
            str = "";
        }
        Locale US = Locale.US;
        Intrinsics.checkNotNullExpressionValue(US, "US");
        String lowerCase = str.toLowerCase(US);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        String str2 = Build.BRAND;
        String str3 = str2 != null ? str2 : "";
        Locale US2 = Locale.US;
        Intrinsics.checkNotNullExpressionValue(US2, "US");
        String lowerCase2 = str3.toLowerCase(US2);
        Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
        String str4 = lowerCase;
        if (StringsKt.contains$default((CharSequence) str4, (CharSequence) "xiaomi", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) str4, (CharSequence) "redmi", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) str4, (CharSequence) "poco", false, 2, (Object) null)) {
            return true;
        }
        String str5 = lowerCase2;
        return StringsKt.contains$default((CharSequence) str5, (CharSequence) "xiaomi", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) str5, (CharSequence) "redmi", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) str5, (CharSequence) "poco", false, 2, (Object) null);
    }

    public final boolean isCnRom() {
        String systemProperty = readSystemProperty("ro.miui.region");
        Locale US = Locale.US;
        Intrinsics.checkNotNullExpressionValue(US, "US");
        String upperCase = systemProperty.toUpperCase(US);
        Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
        if (!Intrinsics.areEqual(upperCase, "CN") && !Intrinsics.areEqual(upperCase, "CHINA")) {
            String systemProperty2 = readSystemProperty("ro.product.mod_device");
            Locale US2 = Locale.US;
            Intrinsics.checkNotNullExpressionValue(US2, "US");
            String lowerCase = systemProperty2.toLowerCase(US2);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            if (!StringsKt.endsWith$default(lowerCase, "_cn", false, 2, (Object) null) && !StringsKt.contains$default((CharSequence) lowerCase, (CharSequence) "_cn_", false, 2, (Object) null)) {
                String str = Build.FINGERPRINT;
                if (str == null) {
                    str = "";
                }
                Locale US3 = Locale.US;
                Intrinsics.checkNotNullExpressionValue(US3, "US");
                String lowerCase2 = str.toLowerCase(US3);
                Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
                String str2 = lowerCase2;
                if (!StringsKt.contains$default((CharSequence) str2, (CharSequence) "/cn/", false, 2, (Object) null) && !StringsKt.contains$default((CharSequence) str2, (CharSequence) ":cn/", false, 2, (Object) null)) {
                    return false;
                }
            }
        }
        return true;
    }

    public final boolean hasFocusPermission(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            Uri uri = Uri.parse("content://miui.statusbar.notification.public");
            Bundle bundle = new Bundle();
            bundle.putString("package", context.getPackageName());
            Bundle bundleCall = context.getContentResolver().call(uri, "canShowFocus", (String) null, bundle);
            return bundleCall != null && bundleCall.getBoolean("canShowFocus", false);
        } catch (Throwable unused) {
        }
    }

    public final int focusProtocol(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return readFocusProtocol(context);
    }

    public final boolean islandSupported(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return detect(context).getIslandSupported();
    }

    public final boolean shizukuAvailable() {
        return shizukuAvailableInternal();
    }

    public final boolean shizukuPermissionGranted() {
        return shizukuAvailableInternal() && shizukuPermissionGrantedInternal();
    }

    public final void openShizuku(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(SHIZUKU_PACKAGE);
            Intent intentAddFlags = launchIntentForPackage != null ? launchIntentForPackage.addFlags(GroupFlagsKt.IsMovableContentFlag) : null;
            if (intentAddFlags != null) {
                context.startActivity(intentAddFlags);
                return;
            }
            Intent intentAddFlags2 = new Intent("moe.shizuku.manager.settings").addFlags(GroupFlagsKt.IsMovableContentFlag);
            Intrinsics.checkNotNullExpressionValue(intentAddFlags2, "addFlags(...)");
            context.startActivity(intentAddFlags2);
        } catch (Throwable th) {
            Log.w(TAG, "Unable to open Shizuku", th);
        }
    }

    private final void requestOrOpenShizuku(Context context) {
        if (!shizukuAvailableInternal()) {
            openShizuku(context);
            return;
        }
        if (shizukuPermissionGrantedInternal()) {
            return;
        }
        try {
            Class.forName(SHIZUKU_CLASS).getMethod("requestPermission", Integer.TYPE).invoke(null, Integer.valueOf(SHIZUKU_PERMISSION_REQUEST_CODE));
        } catch (Throwable th) {
            Log.w(TAG, "Unable to request Shizuku permission, opening Shizuku instead", th);
            openShizuku(context);
        }
    }

    private final boolean shizukuAvailableInternal() {
        try {
            Object objInvoke = Class.forName(SHIZUKU_CLASS).getMethod("pingBinder", null).invoke(null, null);
            Boolean bool = objInvoke instanceof Boolean ? (Boolean) objInvoke : null;
            if (bool != null) {
                return bool.booleanValue();
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    private final boolean shizukuPermissionGrantedInternal() {
        try {
            Object objInvoke = Class.forName(SHIZUKU_CLASS).getMethod("checkSelfPermission", null).invoke(null, null);
            Integer num = objInvoke instanceof Integer ? (Integer) objInvoke : null;
            return num != null && num.intValue() == 0;
        } catch (Throwable unused) {
            return false;
        }
    }

    private final int readFocusProtocol(Context context) {
        try {
            return Settings.System.getInt(context.getContentResolver(), "notification_focus_protocol", 0);
        } catch (Throwable unused) {
            return 0;
        }
    }

    private final String readSystemProperty(String key) {
        try {
            Object objInvoke = Class.forName("android.os.SystemProperties").getMethod("get", String.class, String.class).invoke(null, key, "");
            String string = objInvoke != null ? objInvoke.toString() : null;
            return string == null ? "" : string;
        } catch (Throwable unused) {
            return "";
        }
    }
}
