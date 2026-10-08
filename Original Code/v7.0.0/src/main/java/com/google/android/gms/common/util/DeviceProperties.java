package com.google.android.gms.common.util;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.internal.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.9.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class DeviceProperties {
    private static Boolean zza;
    private static Boolean zzb;
    private static Boolean zzc;
    private static Boolean zzd;
    private static Boolean zze;
    private static Boolean zzf;
    private static Boolean zzg;
    private static Boolean zzh;
    private static Boolean zzi;
    private static Boolean zzj;
    private static Boolean zzk;
    private static Boolean zzl;
    private static Boolean zzm;
    private static Boolean zzn;
    private static Boolean zzo;
    private static Boolean zzp;
    private static Boolean zzq;

    private DeviceProperties() {
    }

    public static boolean isAuto(Context context) {
        return zze(context.getPackageManager());
    }

    public static boolean isBstar(Context context) {
        Boolean boolValueOf = zzo;
        if (boolValueOf == null) {
            boolean z = false;
            if (PlatformVersion.isAtLeastR() && context.getPackageManager().hasSystemFeature("com.google.android.play.feature.HPE_EXPERIENCE")) {
                z = true;
            }
            boolValueOf = Boolean.valueOf(z);
            zzo = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    public static boolean isFoldable(Context context) {
        Boolean boolValueOf = zzd;
        if (boolValueOf == null) {
            boolean z = false;
            if (PlatformVersion.isAtLeastR() && context.getPackageManager().hasSystemFeature("android.hardware.sensor.hinge_angle")) {
                z = true;
            }
            boolValueOf = Boolean.valueOf(z);
            zzd = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    public static boolean isLatchsky(Context context) {
        Boolean boolValueOf = zzh;
        if (boolValueOf == null) {
            PackageManager packageManager = context.getPackageManager();
            boolean z = false;
            if (packageManager.hasSystemFeature("com.google.android.feature.services_updater") && packageManager.hasSystemFeature("cn.google.services")) {
                z = true;
            }
            boolValueOf = Boolean.valueOf(z);
            zzh = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    /* JADX WARN: Code duplicated, block: B:36:0x0085  */
    public static boolean isPhone(Context context) {
        Boolean boolValueOf = zza;
        if (boolValueOf == null) {
            boolean z = true;
            if (!isFoldable(context)) {
                if (isTablet(context) || isWearable(context) || zzd(context)) {
                    z = false;
                } else {
                    Boolean boolValueOf2 = zzk;
                    if (boolValueOf2 == null) {
                        boolValueOf2 = Boolean.valueOf(context.getPackageManager().hasSystemFeature("org.chromium.arc"));
                        zzk = boolValueOf2;
                    }
                    if (boolValueOf2.booleanValue() || isAuto(context) || isTv(context)) {
                        z = false;
                    } else {
                        Boolean boolValueOf3 = zzn;
                        if (boolValueOf3 == null) {
                            boolValueOf3 = Boolean.valueOf(context.getPackageManager().hasSystemFeature("com.google.android.feature.AMATI_EXPERIENCE"));
                            zzn = boolValueOf3;
                        }
                        if (boolValueOf3.booleanValue() || isBstar(context) || isXr(context)) {
                            z = false;
                        } else {
                            Boolean boolValueOf4 = zzq;
                            if (boolValueOf4 == null) {
                                boolValueOf4 = Boolean.valueOf(context.getPackageManager().hasSystemFeature("com.google.desktop.gms"));
                                zzq = boolValueOf4;
                            }
                            if (boolValueOf4.booleanValue()) {
                                z = false;
                            }
                        }
                    }
                }
            }
            boolValueOf = Boolean.valueOf(z);
            zza = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    public static boolean isPhoneGo(Context context) {
        ActivityManager activityManager;
        boolean z = false;
        if (context == null) {
            return false;
        }
        Boolean boolValueOf = zzb;
        if (boolValueOf == null) {
            if (isPhone(context)) {
                if (zzi == null && (activityManager = (ActivityManager) context.getSystemService("activity")) != null) {
                    zzi = Boolean.valueOf(activityManager.isLowRamDevice());
                }
                if (Objects.equal(zzi, true) && Build.VERSION.SDK_INT >= 27) {
                    z = true;
                }
            }
            boolValueOf = Boolean.valueOf(z);
            zzb = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    public static boolean isSevenInchTablet(Context context) {
        return zza(context.getResources());
    }

    public static boolean isSidewinder(Context context) {
        return zzc(context);
    }

    public static boolean isTablet(Context context) {
        return isTablet(context.getResources());
    }

    public static boolean isTv(Context context) {
        return zzf(context.getPackageManager());
    }

    public static boolean isUserBuild() {
        int i = GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE;
        return "user".equals(Build.TYPE);
    }

    public static boolean isWearable(Context context) {
        return zzb(context.getPackageManager());
    }

    public static boolean isWearableWithoutPlayStore(Context context) {
        if (isWearable(context) && !PlatformVersion.isAtLeastN()) {
            return true;
        }
        if (zzc(context)) {
            return !PlatformVersion.isAtLeastO() || PlatformVersion.isAtLeastR();
        }
        return false;
    }

    public static boolean isXr(Context context) {
        return zzg(context.getPackageManager());
    }

    public static boolean zza(Resources resources) {
        boolean z = false;
        if (resources == null) {
            return false;
        }
        Boolean boolValueOf = zze;
        if (boolValueOf == null) {
            Configuration configuration = resources.getConfiguration();
            if ((configuration.screenLayout & 15) <= 3 && configuration.smallestScreenWidthDp >= 600) {
                z = true;
            }
            boolValueOf = Boolean.valueOf(z);
            zze = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    public static boolean zzb(PackageManager packageManager) {
        Boolean boolValueOf = zzf;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(packageManager.hasSystemFeature("android.hardware.type.watch"));
            zzf = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    public static boolean zzc(Context context) {
        Boolean boolValueOf = zzg;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(context.getPackageManager().hasSystemFeature("cn.google"));
            zzg = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    public static boolean zzd(Context context) {
        Boolean boolValueOf = zzj;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(PlatformVersion.isAtLeastO() ? context.getPackageManager().hasSystemFeature("android.hardware.type.embedded") : context.getPackageManager().hasSystemFeature("android.hardware.type.iot"));
            zzj = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    public static boolean zze(PackageManager packageManager) {
        Boolean boolValueOf = zzl;
        if (boolValueOf == null) {
            boolean z = false;
            if (PlatformVersion.isAtLeastO() && packageManager.hasSystemFeature("android.hardware.type.automotive")) {
                z = true;
            }
            boolValueOf = Boolean.valueOf(z);
            zzl = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    public static boolean zzf(PackageManager packageManager) {
        Boolean boolValueOf = zzm;
        if (boolValueOf == null) {
            boolean z = true;
            if (!packageManager.hasSystemFeature("com.google.android.tv") && !packageManager.hasSystemFeature("android.hardware.type.television") && !packageManager.hasSystemFeature("android.software.leanback") && !packageManager.hasSystemFeature("com.google.android.feature.AMATI_EXPERIENCE")) {
                z = false;
            }
            boolValueOf = Boolean.valueOf(z);
            zzm = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    public static boolean zzg(PackageManager packageManager) {
        Boolean boolValueOf = zzp;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(packageManager.hasSystemFeature("android.software.xr.api.spatial"));
            zzp = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    public static boolean isTablet(Resources resources) {
        if (resources == null) {
            return false;
        }
        Boolean boolValueOf = zzc;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf((resources.getConfiguration().screenLayout & 15) > 3 || zza(resources));
            zzc = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }
}
