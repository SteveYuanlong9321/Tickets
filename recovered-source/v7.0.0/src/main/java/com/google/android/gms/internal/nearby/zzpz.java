package com.google.android.gms.internal.nearby;

import android.content.Context;
import android.os.Build;
import android.os.StrictMode;
import android.util.Log;
import androidx.compose.material3.internal.CalendarModelKt;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzpz {
    private static final Object zza = new Object();
    private static final Object zzb = new Object();
    private final Context zzc;
    private final zzxn zzd;
    private final zzxn zze;
    private final zzxn zzf = zzxr.zza(new zzxn() { // from class: com.google.android.gms.internal.nearby.zzpr
        @Override // com.google.android.gms.internal.nearby.zzxn
        public final /* synthetic */ Object zzbh() {
            return this.zza.zzf();
        }
    });
    private final zzxn zzg;
    private final zzxn zzh;
    private volatile zzmh zzi;
    private final zzxn zzj;
    private volatile zzmj zzk;

    public zzpz(Context context, final zzxn zzxnVar, zzxn zzxnVar2) {
        this.zzc = context;
        this.zze = zzxnVar;
        this.zzd = zzxnVar2;
        this.zzh = zzi(context, "storage-info.pb");
        this.zzj = zzi(zzkf.zzd(context), "device-encrypted-storage-info.pb");
        this.zzg = zzxr.zza(new zzxn() { // from class: com.google.android.gms.internal.nearby.zzps
            @Override // com.google.android.gms.internal.nearby.zzxn
            public final /* synthetic */ Object zzbh() {
                zzaha zzahaVar = (zzaha) zzxnVar.zzbh();
                zzahaVar.getClass();
                return zzahaVar.schedule(zzpx.zza, 10000L, TimeUnit.MILLISECONDS);
            }
        });
    }

    private static zzxn zzi(final Context context, final String str) {
        return zzxr.zza(new zzxn() { // from class: com.google.android.gms.internal.nearby.zzpy
            @Override // com.google.android.gms.internal.nearby.zzxn
            public final /* synthetic */ Object zzbh() {
                String strValueOf = String.valueOf(zzkl.zza(context));
                String str2 = File.separator;
                String str3 = File.separator;
                String str4 = File.separator;
                int length = String.valueOf(strValueOf).length();
                int length2 = String.valueOf(str2).length();
                int length3 = String.valueOf(str3).length();
                int length4 = String.valueOf(str4).length();
                String str5 = str;
                StringBuilder sb = new StringBuilder(length + length2 + 22 + length3 + 6 + length4 + str5.length());
                sb.append(strValueOf);
                sb.append(str2);
                sb.append("phenotype_storage_info");
                sb.append(str3);
                sb.append("shared");
                sb.append(str4);
                sb.append(str5);
                return sb.toString();
            }
        });
    }

    private static void zzj(String str, zzaks zzaksVar, String str2) throws IOException {
        File file = new File(str);
        zzaeu.zza(file);
        File fileCreateTempFile = File.createTempFile(str2, ".pb", file.getParentFile());
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(fileCreateTempFile);
            try {
                zzaksVar.zzw(fileOutputStream);
                fileOutputStream.flush();
                fileOutputStream.getFD().sync();
                fileOutputStream.close();
                if (fileCreateTempFile.renameTo(file)) {
                    return;
                }
                String strValueOf = String.valueOf(fileCreateTempFile);
                String string = file.toString();
                StringBuilder sb = new StringBuilder(String.valueOf(strValueOf).length() + 25 + string.length());
                sb.append(strValueOf);
                sb.append(" could not be renamed to ");
                sb.append(string);
                throw new IOException(sb.toString());
            } catch (Throwable th) {
                try {
                    fileOutputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (IOException e) {
            fileCreateTempFile.delete();
            throw e;
        }
    }

    private final zzmh zzk() {
        zzmh zzmhVarZzr;
        zzmh zzmhVarZzr2;
        zzmh zzmhVar = this.zzi;
        if (zzmhVar != null) {
            return zzmhVar;
        }
        synchronized (zza) {
            zzmhVarZzr = this.zzi;
            if (zzmhVarZzr == null) {
                if (zzkf.zzb(this.zzc)) {
                    StrictMode.ThreadPolicy threadPolicyAllowThreadDiskWrites = StrictMode.allowThreadDiskWrites();
                    try {
                        try {
                            FileInputStream fileInputStream = new FileInputStream((String) this.zzh.zzbh());
                            try {
                                zzmhVarZzr2 = zzmh.zzp(fileInputStream, zzaiz.zzb());
                                fileInputStream.close();
                            } catch (Throwable th) {
                                try {
                                    fileInputStream.close();
                                } catch (Throwable th2) {
                                    th.addSuppressed(th2);
                                }
                                throw th;
                            }
                        } catch (IOException | IllegalStateException unused) {
                            zzmhVarZzr2 = zzmh.zzr();
                        }
                        StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskWrites);
                        zzmhVarZzr = zzmhVarZzr2;
                        this.zzi = zzmhVarZzr;
                    } catch (Throwable th3) {
                        StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskWrites);
                        throw th3;
                    }
                } else {
                    zzmhVarZzr = zzmh.zzr();
                }
            }
        }
        return zzmhVarZzr;
    }

    public final zzagx zza() {
        if (!zzkf.zza(this.zzc)) {
            long jZzf = zzk().zzf();
            TimeUnit timeUnit = TimeUnit.HOURS;
            if (jZzf + CalendarModelKt.MillisecondsIn24Hours < System.currentTimeMillis()) {
                zzaha zzahaVar = (zzaha) this.zze.zzbh();
                zzahaVar.getClass();
                return (zzagf) zzagn.zzi(zzagf.zzx(zzagn.zzm((zzagx) this.zzg.zzbh())), new zzafq() { // from class: com.google.android.gms.internal.nearby.zzpw
                    @Override // com.google.android.gms.internal.nearby.zzafq
                    public final /* synthetic */ zzagx zza(Object obj) {
                        return this.zza.zzh((Void) obj);
                    }
                }, zzahaVar);
            }
        }
        return zzagn.zzb();
    }

    public final boolean zzb(boolean z, zzahs zzahsVar) {
        zzmh zzmhVarZzk = zzk();
        return zzmhVarZzk.zzd() && zzmhVarZzk.zzi().contains(zzahsVar);
    }

    public final boolean zzc(boolean z, zzahs zzahsVar) {
        zzmh zzmhVarZzk = zzk();
        return zzmhVarZzk.zzd() && zzmhVarZzk.zzi().contains(zzahsVar) && !zzmhVarZzk.zzo();
    }

    public final boolean zzd(boolean z, zzahs zzahsVar) {
        if (zzkl.zzb()) {
            return false;
        }
        zzmh zzmhVarZzk = zzk();
        return (zzmhVarZzk.zzd() && zzmhVarZzk.zzi().contains(zzahsVar) && zzmhVarZzk.zzo()) ? false : true;
    }

    public final zzpf zze(boolean z) {
        zzmh zzmhVarZzk = zzk();
        return new zzpf(zzmhVarZzk.zzd(), zzyg.zzs(zzmhVarZzk.zzi()), zzmhVarZzk.zzb(), zzmhVarZzk.zze(), (zzmhVarZzk.zzj() && zzmhVarZzk.zzk().zzb() == ((long) Build.VERSION.SDK_INT)) ? zzmhVarZzk.zzk().zza() : "", zzyg.zzs(zzmhVarZzk.zzg()), zzyg.zzs(zzmhVarZzk.zzh()), zzmhVarZzk.zza(), zzmhVarZzk.zzm(), zzmhVarZzk.zzl(), zzmhVarZzk.zzn());
    }

    final /* synthetic */ zzagx zzf() {
        zzaha zzahaVar = (zzaha) this.zze.zzbh();
        zzahaVar.getClass();
        zzlj zzljVar = (zzlj) this.zzd.zzbh();
        zzljVar.getClass();
        final zzagf zzagfVar = (zzagf) zzagn.zzj((zzagf) zzagn.zzg(zzagf.zzx(zzljVar.zzd()), zzlk.class, zzpt.zza, zzahaVar), new zzwx() { // from class: com.google.android.gms.internal.nearby.zzpu
            @Override // com.google.android.gms.internal.nearby.zzwx
            public final /* synthetic */ Object zza(Object obj) {
                this.zza.zzg((zzmn) obj);
                return null;
            }
        }, zzahaVar);
        zzagfVar.zzl(new Runnable() { // from class: com.google.android.gms.internal.nearby.zzpv
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                try {
                    zzagn.zzn(zzagfVar);
                } catch (Exception e) {
                    if (Log.isLoggable("StorageInfoHandler", 3)) {
                        Log.d("StorageInfoHandler", "Failed to get storage info from GMS", e);
                    }
                }
            }
        }, zzahaVar);
        return zzagfVar;
    }

    final /* synthetic */ Void zzg(zzmn zzmnVar) {
        StrictMode.ThreadPolicy threadPolicyAllowThreadDiskWrites = StrictMode.allowThreadDiskWrites();
        try {
            try {
                synchronized (zza) {
                    zzj((String) this.zzh.zzbh(), zzmnVar.zza(), "ce-tmp");
                    this.zzi = zzmnVar.zza();
                }
                synchronized (zzb) {
                    zzj((String) this.zzj.zzbh(), zzmnVar.zzb(), "de-tmp");
                    this.zzk = zzmnVar.zzb();
                }
                StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskWrites);
                return null;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (Throwable th) {
            StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskWrites);
            throw th;
        }
    }

    final /* synthetic */ zzagx zzh(Void r1) {
        return zzagn.zzm((zzagx) this.zzf.zzbh());
    }
}
