package com.google.android.gms.internal.nearby;

import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
abstract class zzafk extends zzafo {
    private static final zzagw zza = new zzagw(zzafk.class);
    private zzyb zzb;
    private final boolean zzc;

    zzafk(zzyb zzybVar, boolean z, boolean z2) {
        super(zzybVar.size());
        zzybVar.getClass();
        this.zzb = zzybVar;
        this.zzc = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzD, reason: merged with bridge method [inline-methods] */
    public final void zzy(int i, zzagx zzagxVar) {
        try {
            if (zzagxVar.isCancelled()) {
                this.zzb = null;
                cancel(false);
            } else {
                try {
                    zzahp.zza(zzagxVar);
                } catch (ExecutionException e) {
                    zzE(e.getCause());
                } catch (Throwable th) {
                    zzE(th);
                }
            }
        } finally {
            zzG(null);
        }
    }

    private static void zzF(Throwable th) {
        zza.zza().logp(Level.SEVERE, "com.google.common.util.concurrent.AggregateFuture", "log", true != (th instanceof Error) ? "Got more than one input Future failure. Logging failures after the first" : "Input Future failed with Error", th);
    }

    private final void zzG(zzyb zzybVar) {
        int iZzC = zzC();
        zzxd.zzf(iZzC >= 0, "Less than 0 remaining futures");
        if (iZzC == 0) {
            this.seenExceptionsField = null;
            zzx();
            zzA(2);
        }
    }

    private static boolean zzH(Set set, Throwable th) {
        while (th != null) {
            if (!set.add(th)) {
                return false;
            }
            th = th.getCause();
        }
        return true;
    }

    void zzA(int i) {
        this.zzb = null;
    }

    @Override // com.google.android.gms.internal.nearby.zzafb
    protected final void zzc() {
        zzyb zzybVar = this.zzb;
        zzA(1);
        if ((zzybVar != null) && isCancelled()) {
            boolean zZzk = zzk();
            zzzl it = zzybVar.iterator();
            while (it.hasNext()) {
                ((zzagx) it.next()).cancel(zZzk);
            }
        }
    }

    @Override // com.google.android.gms.internal.nearby.zzafb
    protected final String zzd() {
        zzyb zzybVar = this.zzb;
        return zzybVar != null ? "futures=".concat(zzybVar.toString()) : super.zzd();
    }

    final void zzf() {
        Objects.requireNonNull(this.zzb);
        if (this.zzb.isEmpty()) {
            zzx();
            return;
        }
        boolean z = this.zzc;
        zzyb zzybVar = this.zzb;
        if (!z) {
            final zzyb zzybVar2 = null;
            Runnable runnable = new Runnable(zzybVar2) { // from class: com.google.android.gms.internal.nearby.zzafi
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.zza.zzz(null);
                }
            };
            zzzl it = zzybVar.iterator();
            while (it.hasNext()) {
                zzagx zzagxVar = (zzagx) it.next();
                if (zzagxVar.isDone()) {
                    zzG(null);
                } else {
                    zzagxVar.zzl(runnable, zzafx.INSTANCE);
                }
            }
            return;
        }
        zzzl it2 = zzybVar.iterator();
        final int i = 0;
        while (it2.hasNext()) {
            final zzagx zzagxVar2 = (zzagx) it2.next();
            int i2 = i + 1;
            if (zzagxVar2.isDone()) {
                zzy(i, zzagxVar2);
            } else {
                zzagxVar2.zzl(new Runnable() { // from class: com.google.android.gms.internal.nearby.zzafj
                    @Override // java.lang.Runnable
                    public final /* synthetic */ void run() {
                        this.zza.zzy(i, zzagxVar2);
                    }
                }, zzafx.INSTANCE);
            }
            i = i2;
        }
    }

    abstract void zzx();

    final /* synthetic */ void zzz(zzyb zzybVar) {
        zzG(null);
    }

    @Override // com.google.android.gms.internal.nearby.zzafo
    final void zzg(Set set) {
        set.getClass();
        if (isCancelled()) {
            return;
        }
        zzH(set, (Throwable) Objects.requireNonNull(zzm()));
    }

    private final void zzE(Throwable th) {
        th.getClass();
        if (this.zzc && !zzb(th) && zzH(zzB(), th)) {
            zzF(th);
        } else if (th instanceof Error) {
            zzF(th);
        }
    }
}
