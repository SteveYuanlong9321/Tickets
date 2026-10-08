package com.google.android.gms.internal.nearby;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
class zztj {
    private final String zza;
    private final zzagx zzb;
    private final zztl zzc;
    private final zzuc zze;
    private final zzuc zzf = new zzuc(new zztb(this, null), zzahg.zza());
    private final Object zzg = new Object();
    private List zzi = new ArrayList();
    private final zzagd zzd = zzagd.zza();
    private final zzus zzh = zzus.zzb();

    zztj(zztl zztlVar, zzts zztsVar, zzagx zzagxVar, boolean z, String str) {
        this.zzc = zztlVar;
        this.zzb = zzagxVar;
        this.zza = zztlVar.zzc();
        final zzsy zzsyVar = (zzsy) zztlVar;
        this.zze = new zzuc(new zzafp() { // from class: com.google.android.gms.internal.nearby.zzsx
            @Override // com.google.android.gms.internal.nearby.zzafp
            public final /* synthetic */ zzagx zza() {
                return zzsyVar.zzd();
            }
        }, zzahg.zza());
        zza(new zzafq() { // from class: com.google.android.gms.internal.nearby.zztg
            @Override // com.google.android.gms.internal.nearby.zzafq
            public final /* synthetic */ zzagx zza(Object obj) {
                return this.zza.zzc((zzry) obj);
            }
        });
    }

    public final void zza(zzafq zzafqVar) {
        synchronized (this.zzg) {
            this.zzi.add(zzafqVar);
        }
    }

    public final zzagx zzb(final zzwx zzwxVar, final Executor executor) {
        final zzafq zzafqVarZzc = zzvr.zzc(new zzafq() { // from class: com.google.android.gms.internal.nearby.zzte
            @Override // com.google.android.gms.internal.nearby.zzafq
            public final /* synthetic */ zzagx zza(Object obj) {
                return zzagn.zza(zzwxVar.zza(obj));
            }
        });
        zzxl.zza(zzwl.zza());
        String str = this.zza;
        String.valueOf(str);
        zzuz zzuzVarZza = this.zzh.zza("Update ".concat(String.valueOf(str)), 1);
        try {
            final zzagx zzagxVarZza = this.zzf.zza();
            zzagd zzagdVar = this.zzd;
            zzagdVar.zzb(new zzafp() { // from class: com.google.android.gms.internal.nearby.zztc
                @Override // com.google.android.gms.internal.nearby.zzafp
                public final /* synthetic */ zzagx zza() {
                    return zzagxVarZza;
                }
            }, zzahg.zza());
            zzagx zzagxVarZzb = zzagdVar.zzb(zzvr.zzb(new zzafp() { // from class: com.google.android.gms.internal.nearby.zztd
                @Override // com.google.android.gms.internal.nearby.zzafp
                public final /* synthetic */ zzagx zza() {
                    final zztj zztjVar = this.zza;
                    final zzafq zzafqVar = zzafqVarZzc;
                    final Executor executor2 = executor;
                    return zzagn.zzi(zzagxVarZza, zzvr.zzc(new zzafq() { // from class: com.google.android.gms.internal.nearby.zztf
                        @Override // com.google.android.gms.internal.nearby.zzafq
                        public final /* synthetic */ zzagx zza(Object obj) {
                            return zztjVar.zzd(zzafqVar, executor2, obj);
                        }
                    }), zzahg.zza());
                }
            }), zzahg.zza());
            zzagn.zzo(zzagxVarZzb, zzagxVarZza);
            zzagn.zzm(this.zzb);
            zzagx zzagxVarZza2 = zzto.zza(zzagxVarZzb);
            zzuzVarZza.zza(zzagxVarZza2);
            zzuzVarZza.close();
            return zzagxVarZza2;
        } catch (Throwable th) {
            try {
                zzuzVarZza.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    final /* synthetic */ zzagx zzc(zzry zzryVar) {
        return this.zze.zza();
    }

    final /* synthetic */ zzagx zzd(zzafq zzafqVar, Executor executor, Object obj) {
        return this.zzc.zzb(zzafqVar, executor, null);
    }

    final /* synthetic */ String zze() {
        return this.zza;
    }

    final /* synthetic */ zztl zzf() {
        return this.zzc;
    }

    final /* synthetic */ zzuc zzg() {
        return this.zze;
    }

    final /* synthetic */ Object zzh() {
        return this.zzg;
    }

    final /* synthetic */ zzus zzi() {
        return this.zzh;
    }

    final /* synthetic */ List zzj() {
        return this.zzi;
    }

    final /* synthetic */ void zzk(List list) {
        this.zzi = list;
    }
}
