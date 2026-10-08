package com.google.android.gms.internal.nearby;

import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.function.Function;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zznw {
    private final ConcurrentMap zza = new ConcurrentHashMap();

    private zznw() {
    }

    final /* synthetic */ void zza(String str) {
        zzng zzngVar = (zzng) this.zza.get(str);
        if (zzngVar != null) {
            zzngVar.zzc(zznv.zza);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ boolean zzb(Collection collection) {
        boolean zZzb = false;
        if (collection != null) {
            if (collection.isEmpty()) {
                return false;
            }
            Iterator it = collection.iterator();
            while (it.hasNext()) {
                zzng zzngVar = (zzng) this.zza.get((String) it.next());
                if (zzngVar != null) {
                    zZzb |= zzngVar.zzb();
                }
            }
        }
        return zZzb;
    }

    public final zzng zzc(final zzkp zzkpVar, final zznf zznfVar, String str) {
        final boolean[] zArr = new boolean[1];
        final String str2 = "";
        zzng zzngVar = (zzng) this.zza.computeIfAbsent(zznfVar.zza(zzkpVar.zzb()), new Function(zznfVar, str2, zArr) { // from class: com.google.android.gms.internal.nearby.zznu
            private final /* synthetic */ zznf zzb;
            private final /* synthetic */ boolean[] zzc;

            {
                this.zzc = zArr;
            }

            @Override // java.util.function.Function
            public final /* synthetic */ Object apply(Object obj) {
                zzng zzngVar2 = new zzng(new zzny(this.zza, this.zzb, "", null), null);
                this.zzc[0] = true;
                return zzngVar2;
            }
        });
        if (zArr[0]) {
            if (zzkpVar.zzc().zzd(false, zzahs.FILE)) {
                zzpd.zza(zzkpVar.zzb(), new zzpc() { // from class: com.google.android.gms.internal.nearby.zzns
                    @Override // com.google.android.gms.internal.nearby.zzpc
                    public final /* synthetic */ void zza(String str3) {
                        this.zza.zza(str3);
                    }
                }, new zzpb(this) { // from class: com.google.android.gms.internal.nearby.zznt
                });
                return zzngVar;
            }
            zzpd.zza(zzkpVar.zzb(), null, new zzpb(this) { // from class: com.google.android.gms.internal.nearby.zznr
            });
        }
        return zzngVar;
    }

    /* synthetic */ zznw(byte[] bArr) {
    }
}
