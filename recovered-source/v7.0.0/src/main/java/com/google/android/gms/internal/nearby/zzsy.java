package com.google.android.gms.internal.nearby;

import android.net.Uri;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzsy implements zztl {
    private final String zza;
    private final zzagx zzb;
    private final zzsl zzc;
    private final Executor zzd;
    private final zzqo zze;
    private final zzxb zzf;
    private final zzus zzg;
    private final Object zzh = new Object();
    private final zzagd zzi = zzagd.zza();
    private zzagx zzj = null;

    zzsy(String str, zzagx zzagxVar, zzsl zzslVar, Executor executor, zzqo zzqoVar, zzxb zzxbVar, zzus zzusVar) {
        this.zza = str;
        this.zzb = zzagn.zzm(zzagxVar);
        this.zzc = zzslVar;
        this.zzd = zzahg.zzb(executor);
        this.zze = zzqoVar;
        this.zzf = zzxbVar;
        this.zzg = zzusVar;
    }

    public static zztm zza() {
        return zzsn.zza;
    }

    private final Object zzm(Uri uri) throws IOException {
        try {
            try {
                zzus zzusVar = this.zzg;
                String str = this.zza;
                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 5);
                sb.append("Read ");
                sb.append(str);
                zzuz zzuzVarZza = zzusVar.zza(sb.toString(), 1);
                try {
                    InputStream inputStream = (InputStream) this.zze.zza(uri, zzrm.zzb());
                    try {
                        zzsl zzslVar = this.zzc;
                        zzaks zzaksVar = (zzaks) ((zztu) zzslVar).zzb().zzA().zza(inputStream, ((zztu) zzslVar).zzc());
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        zzuzVarZza.close();
                        return zzaksVar;
                    } catch (Throwable th) {
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Throwable th2) {
                                th.addSuppressed(th2);
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    try {
                        zzuzVarZza.close();
                    } catch (Throwable th4) {
                        th3.addSuppressed(th4);
                    }
                    throw th3;
                }
            } catch (IOException e) {
                throw zztn.zza(this.zze, uri, e, this.zza);
            }
        } catch (FileNotFoundException e2) {
            if (this.zze.zzc(uri)) {
                throw e2;
            }
            return this.zzc.zza();
        }
    }

    private final void zzn(Uri uri, Object obj) throws IOException {
        Uri uriZza = zztp.zza(uri, ".tmp");
        try {
            zzus zzusVar = this.zzg;
            String str = this.zza;
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 6);
            sb.append("Write ");
            sb.append(str);
            zzuz zzuzVarZza = zzusVar.zza(sb.toString(), 1);
            try {
                zzqy zzqyVar = new zzqy();
                try {
                    zzqo zzqoVar = this.zze;
                    zzrn zzrnVarZzb = zzrn.zzb();
                    zzrnVarZzb.zzc(zzqyVar);
                    OutputStream outputStream = (OutputStream) zzqoVar.zza(uriZza, zzrnVarZzb);
                    try {
                        ((zzaks) obj).zzw(outputStream);
                        zzqyVar.zzb();
                        if (outputStream != null) {
                            outputStream.close();
                        }
                        zzuzVarZza.close();
                        this.zze.zzd(uriZza, uri);
                    } catch (Throwable th) {
                        if (outputStream != null) {
                            try {
                                outputStream.close();
                            } catch (Throwable th2) {
                                th.addSuppressed(th2);
                            }
                        }
                        throw th;
                    }
                } catch (IOException e) {
                    throw zztn.zza(this.zze, uri, e, this.zza);
                }
            } catch (Throwable th3) {
                try {
                    zzuzVarZza.close();
                } catch (Throwable th4) {
                    th3.addSuppressed(th4);
                }
                throw th3;
            }
        } catch (IOException e2) {
            zzqo zzqoVar2 = this.zze;
            if (zzqoVar2.zzc(uriZza)) {
                try {
                    zzqoVar2.zzb(uriZza);
                } catch (IOException e3) {
                    e2.addSuppressed(e3);
                }
            }
            throw e2;
        }
    }

    /* JADX WARN: Code duplicated, block: B:14:0x001a A[Catch: all -> 0x0046, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x0007, B:8:0x000d, B:11:0x0014, B:12:0x0016, B:14:0x001a, B:15:0x0031), top: B:21:0x0003, inners: #1 }] */
    @Override // com.google.android.gms.internal.nearby.zztl
    public final zzagx zzb(final zzafq zzafqVar, final Executor executor, zztk zztkVar) {
        final zzagx zzagxVarZzm;
        synchronized (this.zzh) {
            zzagx zzagxVar = this.zzj;
            if (zzagxVar == null || !zzagxVar.isDone()) {
                zzagxVarZzm = this.zzj;
                if (zzagxVarZzm == null) {
                    zzagxVarZzm = zzagn.zzm(this.zzi.zzb(zzvr.zzb(new zzafp() { // from class: com.google.android.gms.internal.nearby.zzsr
                        @Override // com.google.android.gms.internal.nearby.zzafp
                        public final /* synthetic */ zzagx zza() {
                            return this.zza.zzf();
                        }
                    }), this.zzd));
                    this.zzj = zzagxVarZzm;
                }
            } else {
                try {
                    zzagn.zzn(this.zzj);
                } catch (ExecutionException unused) {
                    this.zzj = null;
                }
                zzagxVarZzm = this.zzj;
                if (zzagxVarZzm == null) {
                    zzagxVarZzm = zzagn.zzm(this.zzi.zzb(zzvr.zzb(new zzafp() { // from class: com.google.android.gms.internal.nearby.zzsr
                        @Override // com.google.android.gms.internal.nearby.zzafp
                        public final /* synthetic */ zzagx zza() {
                            return this.zza.zzf();
                        }
                    }), this.zzd));
                    this.zzj = zzagxVarZzm;
                }
            }
            throw th;
        }
        return this.zzi.zzb(zzvr.zzb(new zzafp() { // from class: com.google.android.gms.internal.nearby.zzsp
            @Override // com.google.android.gms.internal.nearby.zzafp
            public final /* synthetic */ zzagx zza() {
                final zzsy zzsyVar = this.zza;
                final zzagx zzagxVarZzi = zzagn.zzi(zzagxVarZzm, new zzafq() { // from class: com.google.android.gms.internal.nearby.zzsq
                    @Override // com.google.android.gms.internal.nearby.zzafq
                    public final /* synthetic */ zzagx zza(Object obj) {
                        return zzsyVar.zze(obj);
                    }
                }, zzahg.zza());
                final zzagx zzagxVarZzi2 = zzagn.zzi(zzagxVarZzi, zzafqVar, executor);
                return zzagn.zzi(zzagxVarZzi2, zzvr.zzc(new zzafq() { // from class: com.google.android.gms.internal.nearby.zzss
                    @Override // com.google.android.gms.internal.nearby.zzafq
                    public final /* synthetic */ zzagx zza(Object obj) {
                        return zzsyVar.zzg(zzagxVarZzi, zzagxVarZzi2, obj);
                    }
                }), zzahg.zza());
            }
        }), zzahg.zza());
    }

    @Override // com.google.android.gms.internal.nearby.zztl
    public final String zzc() {
        return this.zza;
    }

    final /* synthetic */ zzagx zzd() {
        return zzagn.zzm(zzagn.zzi(this.zzb, zzvr.zzc(new zzafq() { // from class: com.google.android.gms.internal.nearby.zzsw
            @Override // com.google.android.gms.internal.nearby.zzafq
            public final /* synthetic */ zzagx zza(Object obj) {
                return this.zza.zzk((Uri) obj);
            }
        }), this.zzd));
    }

    final /* synthetic */ zzagx zze(Object obj) {
        zzagx zzagxVar;
        synchronized (this.zzh) {
            zzagxVar = this.zzj;
        }
        return zzagxVar;
    }

    final /* synthetic */ zzagx zzf() {
        try {
            return zzagn.zza(zzm((Uri) zzagn.zzn(this.zzb)));
        } catch (IOException e) {
            zzso zzsoVar = new zzso(this, null);
            zzxb zzxbVar = this.zzf;
            if (zzxbVar.zza()) {
                return ((e instanceof zzra) || (e.getCause() instanceof zzra)) ? zzagn.zzc(e) : zzagn.zzi(((zzrw) zzxbVar.zzb()).zza(e, zzsoVar), zzvr.zzc(new zzafq() { // from class: com.google.android.gms.internal.nearby.zzsu
                    @Override // com.google.android.gms.internal.nearby.zzafq
                    public final /* synthetic */ zzagx zza(Object obj) {
                        return this.zza.zzi((Void) obj);
                    }
                }), this.zzd);
            }
            return zzagn.zzc(e);
        }
    }

    final /* synthetic */ zzagx zzg(zzagx zzagxVar, final zzagx zzagxVar2, Object obj) {
        if (zzagn.zzn(zzagxVar).equals(zzagn.zzn(zzagxVar2))) {
            return zzagn.zza(obj);
        }
        zzagx zzagxVarZzi = zzagn.zzi(zzagxVar2, zzvr.zzc(new zzafq() { // from class: com.google.android.gms.internal.nearby.zzst
            @Override // com.google.android.gms.internal.nearby.zzafq
            public final /* synthetic */ zzagx zza(Object obj2) {
                return this.zza.zzh(zzagxVar2, obj2);
            }
        }), this.zzd);
        synchronized (this.zzh) {
        }
        return zzagxVarZzi;
    }

    final /* synthetic */ zzagx zzh(zzagx zzagxVar, Object obj) throws IOException {
        zzn((Uri) zzagn.zzn(this.zzb), obj);
        synchronized (this.zzh) {
            this.zzj = zzagxVar;
        }
        return zzagn.zza(obj);
    }

    final /* synthetic */ zzagx zzi(Void r1) {
        return zzagn.zza(zzm((Uri) zzagn.zzn(this.zzb)));
    }

    final /* synthetic */ zzagx zzj(Object obj) throws IOException {
        zzn((Uri) zzagn.zzn(this.zzb), obj);
        return zzagn.zzb();
    }

    final /* synthetic */ zzagx zzk(Uri uri) {
        Uri uriZza = zztp.zza(uri, ".bak");
        try {
            zzqo zzqoVar = this.zze;
            if (zzqoVar.zzc(uriZza)) {
                zzqoVar.zzd(uriZza, uri);
            }
            return zzagn.zzb();
        } catch (IOException e) {
            return zzagn.zzc(e);
        }
    }

    final /* synthetic */ zzagx zzl(zzagx zzagxVar) {
        return zzagn.zzi(zzagxVar, zzvr.zzc(new zzafq() { // from class: com.google.android.gms.internal.nearby.zzsv
            @Override // com.google.android.gms.internal.nearby.zzafq
            public final /* synthetic */ zzagx zza(Object obj) {
                return this.zza.zzj(obj);
            }
        }), this.zzd);
    }
}
