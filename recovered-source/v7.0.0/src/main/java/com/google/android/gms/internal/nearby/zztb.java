package com.google.android.gms.internal.nearby;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zztb implements zzafp {
    final /* synthetic */ zztj zza;
    private List zzb;

    /* synthetic */ zztb(zztj zztjVar, byte[] bArr) {
        Objects.requireNonNull(zztjVar);
        this.zza = zztjVar;
    }

    @Override // com.google.android.gms.internal.nearby.zzafp
    public final zzagx zza() throws Exception {
        zztj zztjVar = this.zza;
        String strZze = zztjVar.zze();
        String.valueOf(strZze);
        zzuz zzuzVarZza = zztjVar.zzi().zza("Initialize ".concat(String.valueOf(strZze)), 1);
        try {
            synchronized (zztjVar.zzh()) {
                if (this.zzb == null) {
                    this.zzb = zztjVar.zzj();
                    zztjVar.zzk(Collections.EMPTY_LIST);
                }
            }
            ArrayList arrayList = new ArrayList(this.zzb.size());
            zzti zztiVar = new zzti(this.zza, null);
            Iterator it = this.zzb.iterator();
            while (it.hasNext()) {
                try {
                    arrayList.add(((zzafq) it.next()).zza(zztiVar));
                } catch (Exception e) {
                    arrayList.add(zzagn.zzc(e));
                }
            }
            zzagx zzagxVarZzb = zzagn.zzl(arrayList).zzb(new Callable() { // from class: com.google.android.gms.internal.nearby.zzta
                @Override // java.util.concurrent.Callable
                public final /* synthetic */ Object call() {
                    this.zza.zzb();
                    return null;
                }
            }, zzahg.zza());
            zzuzVarZza.zza(zzagxVarZzb);
            zzuzVarZza.close();
            return zzagxVarZzb;
        } catch (Throwable th) {
            try {
                zzuzVarZza.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    final /* synthetic */ Object zzb() {
        synchronized (this.zza.zzh()) {
            this.zzb = null;
        }
        return null;
    }
}
