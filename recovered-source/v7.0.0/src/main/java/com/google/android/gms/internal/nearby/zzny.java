package com.google.android.gms.internal.nearby;

import android.os.StrictMode;
import android.util.Log;
import java.util.Objects;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzny {
    public static final /* synthetic */ int zzb = 0;
    private volatile zzpl zzd;
    private final zzkp zze;
    private final String zzf;
    private final String zzg;
    private final boolean zzh;
    private final zzyl zzi;
    private final zzok zzj;
    private final zzpm zzk;
    private static final zznw zzc = new zznw(null);
    static final zznf zza = new zznf(zznp.zza, false, false, false, false, zzyl.zzh());

    /* synthetic */ zzny(zzkp zzkpVar, zznf zznfVar, String str, byte[] bArr) {
        this.zze = zzkpVar;
        String strZza = zznfVar.zza(zzkpVar.zzb());
        this.zzf = strZza;
        this.zzg = "";
        this.zzh = zznfVar.zzb();
        this.zzi = zznfVar.zzc();
        this.zzd = null;
        this.zzj = new zzok();
        this.zzk = new zzpm(zzkpVar, strZza, "", false);
    }

    public static zznw zzd() {
        return zzc;
    }

    /* JADX WARN: Code duplicated, block: B:28:0x009b A[Catch: all -> 0x00a5, TryCatch #0 {, blocks: (B:5:0x0005, B:7:0x0009, B:9:0x0013, B:24:0x0091, B:26:0x0095, B:28:0x009b, B:12:0x001d, B:14:0x002c, B:16:0x0036, B:17:0x004b, B:19:0x0070, B:20:0x007c, B:22:0x0084, B:30:0x009f, B:31:0x00a2, B:32:0x00a3, B:8:0x000d), top: B:38:0x0005, inners: #1 }] */
    private final zzpl zzp() {
        zzpl zzplVarZzb;
        zzpl zzplVar = this.zzd;
        if (zzplVar != null) {
            return zzplVar;
        }
        synchronized (this) {
            zzplVarZzb = this.zzd;
            if (zzplVarZzb == null) {
                StrictMode.ThreadPolicy threadPolicyAllowThreadDiskWrites = StrictMode.allowThreadDiskWrites();
                try {
                    zzpl zzplVarZza = this.zzk.zza();
                    StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskWrites);
                    if (!zzplVarZza.zzk()) {
                        zzkp zzkpVar = this.zze;
                        zzkpVar.zzc().zza();
                        if (zzplVarZza.zzl() && zzplVarZza.zzd().isEmpty()) {
                            zzkpVar.zzf().execute(new Runnable() { // from class: com.google.android.gms.internal.nearby.zznh
                                @Override // java.lang.Runnable
                                public final /* synthetic */ void run() {
                                    this.zza.zzf();
                                }
                            });
                            zzplVarZzb = zzpl.zzb(zzpo.zzj(), zzplVarZza);
                        } else {
                            zzkpVar.zzf().execute(new Runnable() { // from class: com.google.android.gms.internal.nearby.zznq
                                @Override // java.lang.Runnable
                                public final /* synthetic */ void run() {
                                    this.zza.zze();
                                }
                            });
                            zzkpVar.zzj().zza(zzplVarZza.zze(), this.zzi, this.zzf);
                            if (!this.zzg.equals("")) {
                                zzkpVar.zzf().execute(new Runnable() { // from class: com.google.android.gms.internal.nearby.zzni
                                    @Override // java.lang.Runnable
                                    public final /* synthetic */ void run() {
                                        this.zza.zzg();
                                    }
                                });
                            }
                            if (this.zzk.zzc()) {
                                zzkpVar.zzf().execute(new Runnable() { // from class: com.google.android.gms.internal.nearby.zznj
                                    @Override // java.lang.Runnable
                                    public final /* synthetic */ void run() {
                                        this.zza.zzh();
                                    }
                                });
                            }
                        }
                        if (this.zzh || !zzplVarZzb.zzj()) {
                            this.zzd = zzplVarZzb;
                        }
                    }
                    zzplVarZzb = zzplVarZza;
                    if (this.zzh) {
                        this.zzd = zzplVarZzb;
                    } else {
                        this.zzd = zzplVarZzb;
                    }
                } catch (Throwable th) {
                    StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskWrites);
                    throw th;
                }
            }
        }
        return zzplVarZzb;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzq, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public final void zzn() {
        final zzpm zzpmVar = this.zzk;
        final zzagx zzagxVarZze = zzpmVar.zze(this.zzg);
        Objects.requireNonNull(zzpmVar);
        zzafq zzafqVar = new zzafq() { // from class: com.google.android.gms.internal.nearby.zznx
            @Override // com.google.android.gms.internal.nearby.zzafq
            public final /* synthetic */ zzagx zza(Object obj) {
                return zzpmVar.zzd((zzpo) obj);
            }
        };
        zzkp zzkpVar = this.zze;
        zzagn.zzi(zzagxVarZze, zzafqVar, zzkpVar.zzf()).zzl(new Runnable() { // from class: com.google.android.gms.internal.nearby.zznn
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.zza.zzl(zzagxVarZze);
            }
        }, zzkpVar.zzf());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:14:0x0031 A[Catch: CancellationException -> 0x0069, CancellationException | ExecutionException -> 0x006b, TryCatch #3 {CancellationException | ExecutionException -> 0x006b, blocks: (B:2:0x0000, B:4:0x0016, B:12:0x0023, B:14:0x0031, B:16:0x0039, B:20:0x0045, B:22:0x0049, B:6:0x001a, B:26:0x0068), top: B:35:0x0000 }] */
    /* JADX WARN: Code duplicated, block: B:16:0x0039 A[Catch: CancellationException -> 0x0069, CancellationException | ExecutionException -> 0x006b, TRY_LEAVE, TryCatch #3 {CancellationException | ExecutionException -> 0x006b, blocks: (B:2:0x0000, B:4:0x0016, B:12:0x0023, B:14:0x0031, B:16:0x0039, B:20:0x0045, B:22:0x0049, B:6:0x001a, B:26:0x0068), top: B:35:0x0000 }] */
    /* JADX WARN: Code duplicated, block: B:36:? A[RETURN, SYNTHETIC] */
    /* JADX INFO: renamed from: zzr, reason: merged with bridge method [inline-methods] */
    public final /* synthetic */ void zzl(zzagx zzagxVar) {
        zzpl zzplVar;
        zzpe zzpeVarZzi;
        try {
            zzpo zzpoVar = (zzpo) zzagn.zzn(zzagxVar);
            zzpl zzplVarZza = zzpl.zza(zzpoVar, new zzpk(6, 2, false));
            boolean z = this.zzh;
            if (z || (zzplVar = this.zzd) == null) {
                synchronized (this) {
                    if (!z) {
                        zzplVar = this.zzd;
                        if (zzplVar != null) {
                            if (!zzplVar.zzf().equals(zzplVarZza.zzf())) {
                                zzpeVarZzi = this.zze.zzi();
                                if (zzpeVarZzi != null) {
                                    zzpeVarZzi.zza();
                                    return;
                                }
                                return;
                            }
                        }
                    }
                    this.zzd = zzplVarZza;
                    this.zzj.zzb();
                }
            } else if (!zzplVar.zzf().equals(zzplVarZza.zzf())) {
                zzpeVarZzi = this.zze.zzi();
                if (zzpeVarZzi != null) {
                    zzpeVarZzi.zza();
                    return;
                }
                return;
            }
            if (this.zzh) {
                zzkp zzkpVar = this.zze;
                zzagn.zzg(zzkpVar.zzg().zzb(zzpoVar.zza()), Throwable.class, new zzwx() { // from class: com.google.android.gms.internal.nearby.zzno
                    @Override // com.google.android.gms.internal.nearby.zzwx
                    public final /* synthetic */ Object zza(Object obj) {
                        this.zza.zzm((Throwable) obj);
                        return null;
                    }
                }, zzkpVar.zzf());
            }
        } catch (CancellationException | ExecutionException e) {
            if (e.getCause() instanceof SecurityException) {
                return;
            }
            String str = this.zzf;
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 64);
            sb.append("Unable to update local snapshot for ");
            sb.append(str);
            sb.append(", may result in stale flags.");
            Log.w("FlagStore", sb.toString(), e);
        }
    }

    final Object zza(String str, boolean z) {
        return zzp().zzf().get("connections_enable_wifi_lan_connectivity_info_v2");
    }

    final String zzb() {
        return this.zzf;
    }

    final zzok zzc() {
        return this.zzj;
    }

    final /* synthetic */ zzagx zze() {
        zzagx zzagxVarZzb;
        final zzpl zzplVarZzp = zzp();
        String strZzd = zzplVarZzp.zzd();
        zzkp zzkpVar = this.zze;
        zzpf zzpfVarZze = zzkpVar.zzc().zze(false);
        if (zzpfVarZze.zze()) {
            if (zzxm.zzc(strZzd) && !zzpfVarZze.zzd()) {
                return zzagn.zzb();
            }
            zzlb zzlbVarZzb = zzle.zzb();
            zzlbVarZzb.zzb(zzplVarZzp.zzi());
            if (!zzxm.zzc(strZzd)) {
                zzlbVarZzb.zza(strZzd);
            }
            if (zzpfVarZze.zzd()) {
                zzlbVarZzb.zzc(this.zzf);
            }
            zzagxVarZzb = zzkpVar.zzg().zzc((zzle) zzlbVarZzb.zzn());
        } else {
            if (zzxm.zzc(strZzd)) {
                return zzagn.zzb();
            }
            zzagxVarZzb = zzkpVar.zzg().zzb(strZzd);
        }
        return zzagn.zzh(zzagxVarZzb, zzlk.class, new zzafq() { // from class: com.google.android.gms.internal.nearby.zznk
            @Override // com.google.android.gms.internal.nearby.zzafq
            public final /* synthetic */ zzagx zza(Object obj) {
                return this.zza.zzi(zzplVarZzp, (zzlk) obj);
            }
        }, zzkpVar.zzf());
    }

    final /* synthetic */ void zzg() {
        zzkp zzkpVar = this.zze;
        final zzagx zzagxVarZza = zzom.zza(zzkpVar, this.zzf, this.zzg);
        zzagxVarZza.zzl(new Runnable() { // from class: com.google.android.gms.internal.nearby.zznl
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.zza.zzj(zzagxVarZza);
            }
        }, zzkpVar.zzf());
    }

    final /* synthetic */ void zzh() {
        this.zze.zze().zza(zzahs.FILE, this.zzh, zznm.zza);
    }

    final /* synthetic */ zzagx zzi(zzpl zzplVar, zzlk zzlkVar) {
        int iZza = zzlkVar.zza();
        if ((iZza == 29501 || iZza == 29537 || iZza == 29538 || iZza == 29539 || iZza == 29540 || iZza == 29541 || iZza == 29542 || iZza == 29543 || iZza == 29544 || iZza == 29547) && zzplVar.zzl()) {
            zzn();
        }
        return zzagn.zzb();
    }

    final /* synthetic */ void zzj(zzagx zzagxVar) {
        try {
            zzagn.zzn(zzagxVar);
        } catch (Exception e) {
            String str = this.zzf;
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 73);
            sb.append("Failed to store account on flag read for: ");
            sb.append(str);
            sb.append(" which may lead to stale flags.");
            Log.w("FlagStore", sb.toString(), e);
        }
    }

    final /* synthetic */ Void zzm(Throwable th) {
        String str = this.zzf;
        String.valueOf(str);
        Log.w("FlagStore", "Failed to commit to updated flags for ".concat(String.valueOf(str)), th);
        return null;
    }

    final /* synthetic */ boolean zzo() {
        if (!this.zzh) {
            return true;
        }
        zzpl zzplVar = this.zzd;
        if (zzplVar == null) {
            return false;
        }
        if (!zzplVar.zzh() && !zzplVar.zzg() && !this.zzk.zzb()) {
            return false;
        }
        synchronized (this) {
            zzpl zzplVar2 = this.zzd;
            if (zzplVar2 != null && (zzplVar2.zzh() || zzplVar2.zzg() || this.zzk.zzb())) {
                this.zzd = null;
                this.zzj.zzb();
            }
        }
        return false;
    }
}
