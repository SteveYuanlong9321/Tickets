package com.google.android.gms.internal.nearby;

import android.accounts.Account;
import android.content.Context;
import android.net.Uri;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzqt {
    private final String zza;
    private final String zzb = "files";
    private String zzc = "common";
    private final Account zzd = zzqu.zza;
    private String zze = "";
    private final zzyc zzf;

    /* synthetic */ zzqt(Context context, byte[] bArr) {
        int i = zzyg.zzd;
        this.zzf = new zzyc();
        this.zza = context.getPackageName();
    }

    public final zzqt zza(String str) {
        zzqu.zzb("phenotype");
        this.zzc = "phenotype";
        return this;
    }

    public final zzqt zzb(String str) {
        int i = zzqu.zzb;
        this.zze = "all_accounts.pb";
        return this;
    }

    public final Uri zzc() {
        String string;
        String str = this.zzc;
        Account account = zzqp.zza;
        Account account2 = this.zzd;
        zzrk.zza(account2.type.indexOf(58) == -1, "Account type contains ':'.", new Object[0]);
        zzrk.zza(account2.type.indexOf(47) == -1, "Account type contains '/'.", new Object[0]);
        zzrk.zza(account2.name.indexOf(47) == -1, "Account name contains '/'.", new Object[0]);
        if (zzqp.zza.equals(account2)) {
            string = "shared";
        } else {
            String str2 = account2.type;
            String str3 = account2.name;
            StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 1 + String.valueOf(str3).length());
            sb.append(str2);
            sb.append(":");
            sb.append(str3);
            string = sb.toString();
        }
        String str4 = this.zzb;
        String str5 = this.zze;
        StringBuilder sb2 = new StringBuilder(str4.length() + 2 + String.valueOf(str).length() + 1 + string.length() + 1 + String.valueOf(str5).length());
        sb2.append("/");
        sb2.append(str4);
        sb2.append("/");
        sb2.append(str);
        sb2.append("/");
        sb2.append(string);
        sb2.append("/");
        sb2.append(str5);
        return new Uri.Builder().scheme("android").authority(this.zza).path(sb2.toString()).encodedFragment(zzrj.zzb(this.zzf.zze())).build();
    }
}
