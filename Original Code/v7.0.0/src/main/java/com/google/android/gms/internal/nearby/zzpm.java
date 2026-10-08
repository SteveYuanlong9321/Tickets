package com.google.android.gms.internal.nearby;

import android.content.pm.ApplicationInfo;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.logging.Level;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzpm {
    private final zzkp zza;
    private final zzxn zzb;
    private final String zzc;
    private final String zzd = "";

    public zzpm(final zzkp zzkpVar, final String str, String str2, boolean z) {
        this.zza = zzkpVar;
        this.zzc = str;
        final String str3 = "";
        final boolean z2 = false;
        this.zzb = zzxr.zza(new zzxn(z2, zzkpVar, str3, str) { // from class: com.google.android.gms.internal.nearby.zzpj
            private final /* synthetic */ zzkp zza;
            private final /* synthetic */ String zzb;

            {
                this.zza = zzkpVar;
                this.zzb = str;
            }

            @Override // com.google.android.gms.internal.nearby.zzxn
            public final /* synthetic */ Object zzbh() {
                String strValueOf = String.valueOf(zzkl.zza(this.zza.zzb()));
                String str4 = File.separator;
                String str5 = File.separator;
                String str6 = File.separator;
                int length = String.valueOf(strValueOf).length();
                int length2 = String.valueOf(str4).length();
                int length3 = String.valueOf(str5).length();
                int length4 = String.valueOf(str6).length();
                String str7 = this.zzb;
                StringBuilder sb = new StringBuilder(length + length2 + 9 + length3 + 6 + length4 + String.valueOf(str7).length() + 3);
                sb.append(strValueOf);
                sb.append(str4);
                sb.append("phenotype");
                sb.append(str5);
                sb.append("shared");
                sb.append(str6);
                sb.append("");
                sb.append(str7);
                sb.append(".pb");
                return sb.toString();
            }
        });
    }

    final zzpl zza() {
        String strSubstring;
        zzmt zzmtVar;
        zzmt zzmtVar2;
        zzkp zzkpVar = this.zza;
        if (zzkf.zza(zzkpVar.zzb())) {
            return zzpl.zza(zzpo.zzj(), new zzpk(3, 17, false));
        }
        if (zzkl.zzb()) {
            return zzpl.zza(zzpo.zzj(), new zzpk(3, 18, false));
        }
        zzpf zzpfVarZze = zzkpVar.zzc().zze(false);
        String str = this.zzc;
        zzahs zzahsVar = zzahs.FILE;
        int iIndexOf = str.indexOf("#");
        if (iIndexOf >= 0) {
            strSubstring = str.substring(0, iIndexOf);
        } else {
            if (str.contains("@")) {
                String.valueOf(str);
                throw new IllegalArgumentException("Invalid package name: ".concat(String.valueOf(str)));
            }
            strSubstring = str;
        }
        int iZzg = zzpfVarZze.zzg(zzahsVar, strSubstring);
        if (iZzg != 0) {
            zzmtVar2 = new zzmt(null, new zzpk(iZzg, true));
        } else {
            try {
                String strZzc = zzpfVarZze.zzc();
                if (strZzc.isEmpty()) {
                    zzxb zzxbVarZzd = zzkpVar.zzd();
                    if (zzxbVarZzd.zza()) {
                        strZzc = ((ApplicationInfo) zzxbVarZzd.zzb()).dataDir;
                    } else {
                        zzla.zza(Level.WARNING, zzkpVar.zzf(), "Unable to get GMS application info, using defaults.", new Object[0]);
                        zzmtVar = new zzmt(zzmc.zza(), new zzpk(3, 7, false));
                        zzmtVar2 = zzmtVar;
                    }
                }
                zzlz zzlzVar = new zzlz(zzpfVarZze.zza(), str, this.zzd);
                String str2 = File.separator;
                String strZzb = zzpfVarZze.zzb();
                String str3 = File.separator;
                String string = zzlzVar.zza().toString();
                StringBuilder sb = new StringBuilder(String.valueOf(strZzc).length() + String.valueOf(str2).length() + String.valueOf(strZzb).length() + String.valueOf(str3).length() + string.length());
                sb.append(strZzc);
                sb.append(str2);
                sb.append(strZzb);
                sb.append(str3);
                sb.append(string);
                File file = new File(sb.toString());
                try {
                    try {
                        FileInputStream fileInputStream = new FileInputStream(file);
                        try {
                            zzmt zzmtVar3 = new zzmt((!zzpfVarZze.zzf().zza() || file.length() <= 12288) ? zzmc.zzb(zzaio.zzL(fileInputStream, 4096), false) : zzmc.zzb(zzaio.zzL(fileInputStream, 4096), true), new zzpk(5, 2, false));
                            fileInputStream.close();
                            zzmtVar2 = zzmtVar3;
                        } catch (Throwable th) {
                            try {
                                fileInputStream.close();
                            } catch (Throwable th2) {
                                th.addSuppressed(th2);
                            }
                            throw th;
                        }
                    } catch (FileNotFoundException unused) {
                        zzla.zza(Level.INFO, this.zza.zzf(), "Shared storage file not found for %s", this.zzc);
                        zzmtVar2 = new zzmt(null, new zzpk(8, false));
                    }
                } catch (zzakf e) {
                    zzla.zzb(Level.SEVERE, this.zza.zzf(), e, "Failed to parse snapshot from shared storage for %s", this.zzc);
                    zzmtVar2 = new zzmt(null, new zzpk(9, false));
                }
            } catch (Exception e2) {
                zzla.zzb(Level.WARNING, this.zza.zzf(), e2, "Failed to read shared file for %s", this.zzc);
                zzmtVar = new zzmt(zzmc.zza(), new zzpk(3, 10, false));
            }
        }
        if (zzmtVar2.zza() != null) {
            zzmc zzmcVarZza = zzmtVar2.zza();
            zzmcVarZza.getClass();
            return zzpl.zzc(zzmcVarZza, zzmtVar2.zzb());
        }
        zzpk zzpkVarZzb = zzmtVar2.zzb();
        try {
            FileInputStream fileInputStream2 = new FileInputStream((String) this.zzb.zzbh());
            try {
                zzpl zzplVarZza = zzpl.zza(zzpo.zzh(fileInputStream2, zzaiz.zzb()), new zzpk(4, zzpkVarZzb.zzc(), zzpkVarZzb.zza()));
                fileInputStream2.close();
                return zzplVarZza;
            } catch (Throwable th3) {
                try {
                    fileInputStream2.close();
                } catch (Throwable th4) {
                    th3.addSuppressed(th4);
                }
                throw th3;
            }
        } catch (IOException | RuntimeException unused2) {
            zzla.zza(Level.INFO, this.zza.zzf(), "Unable to retrieve flag snapshot for %s, using defaults.", this.zzc);
            return zzpkVarZzb.zza() ? zzpl.zza(zzpo.zzj(), new zzpk(3, 11, true)) : zzpl.zzc(zzmc.zza(), new zzpk(3, 16, false));
        }
    }

    final boolean zzb() {
        return this.zza.zzc().zzb(false, zzahs.FILE);
    }

    final boolean zzc() {
        return this.zza.zzc().zzc(false, zzahs.FILE);
    }

    public final zzagx zzd(final zzpo zzpoVar) {
        return zzagn.zze(new Callable() { // from class: com.google.android.gms.internal.nearby.zzph
            @Override // java.util.concurrent.Callable
            public final /* synthetic */ Object call() {
                this.zza.zzf(zzpoVar);
                return null;
            }
        }, this.zza.zzf());
    }

    final zzagx zze(String str) {
        zzkp zzkpVar = this.zza;
        return zzagn.zzj(zzkpVar.zzg().zza(this.zzc, ""), zzpi.zza, zzkpVar.zzf());
    }

    /* JADX WARN: Code duplicated, block: B:32:0x007e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    final /* synthetic */ Void zzf(zzpo zzpoVar) {
        File fileCreateTempFile;
        try {
            File file = new File((String) this.zzb.zzbh());
            zzaeu.zza(file);
            fileCreateTempFile = File.createTempFile("snapshot", ".pb", file.getParentFile());
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(fileCreateTempFile);
                try {
                    zzpoVar.zzw(fileOutputStream);
                    fileOutputStream.flush();
                    fileOutputStream.getFD().sync();
                    fileOutputStream.close();
                    if (fileCreateTempFile.renameTo(file)) {
                        return null;
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
                e = e;
                if (fileCreateTempFile != null) {
                    try {
                        fileCreateTempFile.delete();
                    } catch (SecurityException e2) {
                        e.addSuppressed(e2);
                    }
                }
                zzla.zzb(Level.WARNING, this.zza.zzf(), e, "Failed to update snapshot for %s flags may be stale.", this.zzc);
            } catch (RuntimeException e3) {
                e = e3;
                if (fileCreateTempFile != null) {
                    fileCreateTempFile.delete();
                }
                zzla.zzb(Level.WARNING, this.zza.zzf(), e, "Failed to update snapshot for %s flags may be stale.", this.zzc);
            }
        } catch (IOException | RuntimeException e4) {
            e = e4;
            fileCreateTempFile = null;
        }
    }
}
