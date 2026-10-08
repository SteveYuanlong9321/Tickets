package com.google.android.gms.internal.nearby;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzse implements zzafq {
    private final List zza;
    private final Executor zzb;

    private zzse(List list, Executor executor) {
        this.zza = list;
        this.zzb = executor;
    }

    public static zzse zzb(List list, Executor executor) {
        return new zzse(list, executor);
    }

    @Override // com.google.android.gms.internal.nearby.zzafq
    public final /* bridge */ /* synthetic */ zzagx zza(Object obj) throws Exception {
        zzry zzryVar = (zzry) obj;
        List list = this.zza;
        final int size = list.size();
        final ArrayList arrayList = new ArrayList(size);
        zzzm zzzmVarListIterator = ((zzyg) list).listIterator(0);
        while (zzzmVarListIterator.hasNext()) {
            arrayList.add(((zzrz) zzzmVarListIterator.next()).zza());
        }
        return zzagn.zzi(zzryVar.zza(zzvr.zzc(new zzafq() { // from class: com.google.android.gms.internal.nearby.zzsd
            @Override // com.google.android.gms.internal.nearby.zzafq
            public final /* synthetic */ zzagx zza(Object obj2) {
                return this.zza.zzc(arrayList, size, (zzaks) obj2);
            }
        }), zzahg.zza()), zzvr.zzc(new zzafq() { // from class: com.google.android.gms.internal.nearby.zzsa
            @Override // com.google.android.gms.internal.nearby.zzafq
            public final /* synthetic */ zzagx zza(Object obj2) {
                return this.zza.zzd(size, arrayList, obj2);
            }
        }), zzahg.zza());
    }

    final /* synthetic */ zzagx zzc(final List list, final int i, final zzaks zzaksVar) {
        return zzagn.zzk(list).zza(zzvr.zzb(new zzafp() { // from class: com.google.android.gms.internal.nearby.zzsb
            @Override // com.google.android.gms.internal.nearby.zzafp
            public final /* synthetic */ zzagx zza() {
                return this.zza.zze(zzaksVar, i, list);
            }
        }), this.zzb);
    }

    final /* synthetic */ zzagx zzd(int i, List list, Object obj) {
        ArrayList arrayList = new ArrayList(i);
        for (int i2 = 0; i2 < i; i2++) {
            if (((Boolean) zzagn.zzn((Future) list.get(i2))).booleanValue()) {
                arrayList.add(((zzrz) this.zza.get(i2)).zzb());
            }
        }
        return zzagn.zzl(arrayList).zzb(zzafs.zza(null), zzahg.zza());
    }

    final /* synthetic */ zzagx zze(zzaks zzaksVar, int i, List list) {
        zzagx zzagxVarZza = zzagn.zza(zzaksVar);
        for (int i2 = 0; i2 < i; i2++) {
            if (((Boolean) zzagn.zzn((Future) list.get(i2))).booleanValue()) {
                final zzrz zzrzVar = (zzrz) this.zza.get(i2);
                zzagxVarZza = zzagn.zzi(zzagxVarZza, zzvr.zzc(new zzafq() { // from class: com.google.android.gms.internal.nearby.zzsc
                    @Override // com.google.android.gms.internal.nearby.zzafq
                    public final /* synthetic */ zzagx zza(Object obj) {
                        return zzrzVar.zzc();
                    }
                }), zzahg.zza());
            }
        }
        return zzagxVarZza;
    }
}
