package com.google.android.gms.internal.nearby;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Process;
import android.os.UserManager;
import android.util.Log;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzkf {
    public static final /* synthetic */ int zza = 0;
    private static UserManager zzb = null;
    private static volatile boolean zzc = false;

    private zzkf() {
    }

    public static boolean zza(Context context) {
        return !zzh(context);
    }

    public static boolean zzb(Context context) {
        return zzh(context);
    }

    public static zzagx zzc(final Context context, final Callable callable, Executor executor) {
        zzafp zzafpVar = new zzafp() { // from class: com.google.android.gms.internal.nearby.zzke
            @Override // com.google.android.gms.internal.nearby.zzafp
            public final /* synthetic */ zzagx zza() {
                int i = zzkf.zza;
                return zzagn.zze(callable, zzahg.zza());
            }
        };
        if (zzb(context)) {
            return zzagn.zzf(zzafpVar, executor);
        }
        final zzahl zzahlVarZzf = zzahl.zzf();
        final AtomicBoolean atomicBoolean = new AtomicBoolean();
        final zzkc zzkcVar = new zzkc(atomicBoolean, context, zzahlVarZzf, zzafpVar, executor);
        context.registerReceiver(zzkcVar, new IntentFilter("android.intent.action.USER_UNLOCKED"));
        if (!zzb(context) || !atomicBoolean.compareAndSet(false, true)) {
            zzahlVarZzf.zzl(new Runnable() { // from class: com.google.android.gms.internal.nearby.zzkd
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    zzkf.zze(zzahlVarZzf, atomicBoolean, context, zzkcVar);
                }
            }, zzahg.zza());
            return zzahlVarZzf;
        }
        zzg(context, zzkcVar);
        zzahlVarZzf.zze(zzagn.zzf(zzafpVar, executor));
        return zzahlVarZzf;
    }

    public static Context zzd(Context context) {
        return context.isDeviceProtectedStorage() ? context : context.createDeviceProtectedStorageContext();
    }

    static /* synthetic */ void zze(zzahl zzahlVar, AtomicBoolean atomicBoolean, Context context, BroadcastReceiver broadcastReceiver) {
        if (zzahlVar.isCancelled() && atomicBoolean.compareAndSet(false, true)) {
            zzg(context, broadcastReceiver);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zzg(Context context, BroadcastReceiver broadcastReceiver) {
        try {
            context.unregisterReceiver(broadcastReceiver);
        } catch (IllegalArgumentException e) {
            Log.w("DirectBootUtils", "Failed to unregister receiver", e);
        }
    }

    /* JADX WARN: Code duplicated, block: B:29:0x004c A[Catch: all -> 0x0050, TryCatch #0 {, blocks: (B:7:0x0009, B:9:0x000d, B:14:0x0015, B:16:0x0019, B:29:0x004c, B:30:0x004e, B:19:0x0027, B:21:0x002d, B:25:0x003a, B:27:0x0048), top: B:35:0x0009, inners: #1 }] */
    private static boolean zzh(Context context) {
        if (zzc) {
            return true;
        }
        synchronized (zzkf.class) {
            if (zzc) {
                return true;
            }
            int i = 1;
            while (true) {
                boolean z = false;
                if (i <= 2) {
                    UserManager userManager = zzb;
                    if (userManager == null) {
                        userManager = (UserManager) context.getSystemService(UserManager.class);
                        zzb = userManager;
                    }
                    if (userManager == null) {
                        z = true;
                    } else {
                        try {
                            if (userManager.isUserUnlocked() || !userManager.isUserRunning(Process.myUserHandle())) {
                                z = true;
                            }
                        } catch (NullPointerException e) {
                            Log.w("DirectBootUtils", "Failed to check if user is unlocked.", e);
                            zzb = null;
                            i++;
                        }
                    }
                    if (z) {
                        zzc = true;
                    }
                    return z;
                }
                if (z) {
                    zzb = null;
                }
                if (z) {
                    zzc = true;
                }
                return z;
            }
        }
    }
}
