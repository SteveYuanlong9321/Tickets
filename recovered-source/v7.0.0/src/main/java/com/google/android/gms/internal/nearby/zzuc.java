package com.google.android.gms.internal.nearby;

import androidx.camera.view.PreviewView$1$$ExternalSyntheticBackportWithForwarding0;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzuc {
    private final zztw zza;
    private final AtomicLong zzb = new AtomicLong(zzi(Integer.MIN_VALUE, Integer.MIN_VALUE));
    private final AtomicReference zzc = new AtomicReference(null);
    private final AtomicReference zzd = new AtomicReference(null);
    private final Executor zze = zzahg.zzb(zzahg.zza());
    private final zzahl zzf;

    public zzuc(zzafp zzafpVar, Executor executor) {
        zzahl zzahlVarZzf = zzahl.zzf();
        this.zzf = zzahlVarZzf;
        zztw zztwVar = new zztw(zzafpVar, executor);
        this.zza = zztwVar;
        zzahlVarZzf.zzl(zztwVar, zzahg.zza());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzh, reason: merged with bridge method [inline-methods] */
    public final zzagx zzd(int i) {
        AtomicReference atomicReference;
        zzub zzubVar;
        Executor executorZzb;
        AtomicLong atomicLong = this.zzb;
        if (((int) (atomicLong.get() >>> 32)) > i) {
            return zzagn.zzd();
        }
        zzub zzubVar2 = new zzub(i);
        do {
            atomicReference = this.zzc;
            zzubVar = (zzub) atomicReference.get();
            if (zzubVar != null && zzubVar.zzf() > i) {
                return zzagn.zzd();
            }
        } while (!PreviewView$1$$ExternalSyntheticBackportWithForwarding0.m(atomicReference, zzubVar, zzubVar2));
        if (((int) (atomicLong.get() >>> 32)) > i) {
            zzubVar2.cancel(true);
            PreviewView$1$$ExternalSyntheticBackportWithForwarding0.m(atomicReference, zzubVar2, null);
            return zzubVar2;
        }
        zztw zztwVar = this.zza;
        zzafp zzafpVarZza = zztwVar.zza();
        if (zzafpVarZza == null || (executorZzb = zztwVar.zzb()) == null) {
            zzubVar2.zze(this.zzf);
            return zzubVar2;
        }
        zzubVar2.zze(zzagn.zzf(zzvr.zzb(zzafpVarZza), executorZzb));
        return zzubVar2;
    }

    private static long zzi(int i, int i2) {
        return (((long) i2) & 4294967295L) | (i << 32);
    }

    public final zzagx zza() {
        AtomicLong atomicLong;
        long j;
        final int i;
        zzahl zzahlVar = this.zzf;
        if (zzahlVar.isDone()) {
            return zzahlVar;
        }
        do {
            atomicLong = this.zzb;
            j = atomicLong.get();
            i = (int) (j >>> 32);
        } while (!atomicLong.compareAndSet(j, zzi(i, ((int) j) + 1)));
        AtomicReference atomicReference = this.zzd;
        final zzahl zzahlVarZzf = zzahl.zzf();
        zzagx zzagxVar = (zzagx) atomicReference.getAndSet(zzahlVarZzf);
        zzahlVarZzf.zze(zzagxVar == null ? zzagn.zzf(zzvr.zzb(new zzafp() { // from class: com.google.android.gms.internal.nearby.zzty
            @Override // com.google.android.gms.internal.nearby.zzafp
            public final /* synthetic */ zzagx zza() {
                return this.zza.zzd(i);
            }
        }), zzahg.zza()) : zzagn.zzh(zzagxVar, Throwable.class, zzvr.zzc(new zzafq() { // from class: com.google.android.gms.internal.nearby.zztx
            @Override // com.google.android.gms.internal.nearby.zzafq
            public final /* synthetic */ zzagx zza(Object obj) {
                return this.zza.zzc(i, (Throwable) obj);
            }
        }), this.zze));
        final zzua zzuaVar = new zzua(this, i, null);
        zzahlVarZzf.zzl(new Runnable() { // from class: com.google.android.gms.internal.nearby.zztz
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.zza.zzb(zzahlVarZzf, zzuaVar);
            }
        }, zzahg.zza());
        return zzuaVar;
    }

    final /* synthetic */ void zzb(zzahl zzahlVar, zzua zzuaVar) {
        try {
            Object objZzn = zzagn.zzn(zzahlVar);
            zzahl zzahlVar2 = this.zzf;
            zzahlVar2.zza(objZzn);
            zzuaVar.zze(zzahlVar2);
        } catch (Throwable unused) {
            zzuaVar.zze(zzahlVar);
        }
    }

    final /* synthetic */ zzagx zzc(int i, Throwable th) {
        return zzd(i);
    }

    final /* synthetic */ boolean zze() {
        AtomicLong atomicLong;
        long j;
        int i;
        int i2;
        boolean z;
        do {
            atomicLong = this.zzb;
            j = atomicLong.get();
            i = (int) j;
            long j2 = j >>> 32;
            if (i == Integer.MIN_VALUE) {
                StringBuilder sb = new StringBuilder(String.valueOf(j).length() + 13);
                sb.append("Refcount is: ");
                sb.append(j);
                throw new AssertionError(sb.toString());
            }
            i2 = (int) j2;
            z = i == -2147483647;
            if (z) {
                i2++;
            }
        } while (!atomicLong.compareAndSet(j, zzi(i2, i - 1)));
        return z;
    }

    final /* synthetic */ zztw zzf() {
        return this.zza;
    }

    final /* synthetic */ AtomicReference zzg() {
        return this.zzc;
    }
}
