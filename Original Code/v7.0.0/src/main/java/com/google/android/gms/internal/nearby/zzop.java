package com.google.android.gms.internal.nearby;

import java.util.concurrent.ExecutionException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzop {
    static void zza(final zzagx zzagxVar) {
        zzagxVar.zzl(new Runnable() { // from class: com.google.android.gms.internal.nearby.zzoo
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                try {
                    zzagn.zzn(zzagxVar);
                } catch (ExecutionException e) {
                    zzqh.zzb().post(new Runnable() { // from class: com.google.android.gms.internal.nearby.zzon
                        @Override // java.lang.Runnable
                        public final /* synthetic */ void run() {
                            throw new RuntimeException(e.getCause());
                        }
                    });
                }
            }
        }, zzahg.zza());
    }
}
