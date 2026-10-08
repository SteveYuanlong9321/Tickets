package com.google.android.gms.internal.nearby;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;
import com.google.android.gms.common.util.PlatformVersion;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzpd extends BroadcastReceiver {
    static volatile zzpb zza;
    private static volatile zzpc zzb;

    public static void zza(Context context, zzpc zzpcVar, zzpb zzpbVar) {
        if (zza == null) {
            synchronized (zzpd.class) {
                if (zza == null) {
                    if (zzpcVar != null && !Objects.equals(context.getPackageName(), "com.google.android.gms")) {
                        if (PlatformVersion.isAtLeastT()) {
                            context.registerReceiver(new zzpd(), new IntentFilter("com.google.android.gms.phenotype.UPDATE"), 2);
                        } else {
                            context.registerReceiver(new zzpd(), new IntentFilter("com.google.android.gms.phenotype.UPDATE"));
                        }
                        zzb = zzpcVar;
                    }
                    zza = zzpbVar;
                }
            }
        }
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        String stringExtra = intent.getStringExtra("com.google.android.gms.phenotype.PACKAGE_NAME");
        if (stringExtra == null) {
            return;
        }
        if (stringExtra.contains("../") || stringExtra.contains("/..")) {
            StringBuilder sb = new StringBuilder(stringExtra.length() + 68);
            sb.append("Got an invalid config package for P/H that includes '..': ");
            sb.append(stringExtra);
            sb.append(". Exiting.");
            Log.w("PhUpdateBroadcastRecv", sb.toString());
            return;
        }
        zzpc zzpcVar = zzb;
        if (zzpcVar == null) {
            Log.w("PhUpdateBroadcastRecv", "No callback registered for P/H UPDATE broadcast. Exiting.");
        } else {
            zzpcVar.zza(stringExtra);
        }
    }
}
