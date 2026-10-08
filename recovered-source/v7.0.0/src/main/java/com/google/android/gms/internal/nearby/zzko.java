package com.google.android.gms.internal.nearby;

import android.content.Context;
import android.content.pm.PackageManager;
import java.util.ArrayList;
import java.util.Collections;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzko {
    private Context zza;
    private zzxn zzb;
    private zzxn zzc;
    private zzxn zzd;
    private zzxn zze;
    private zzxn zzf;

    private zzko() {
        throw null;
    }

    /* synthetic */ zzko(byte[] bArr) {
    }

    public final zzko zza(Context context) {
        this.zza = context;
        return this;
    }

    public final zzkp zzb() {
        this.zza.getClass();
        if (this.zzb == null) {
            this.zzb = zzkp.zzf;
        }
        if (this.zzc == null) {
            final Context context = this.zza;
            int i = zzkp.zza;
            this.zzc = zzxr.zza(new zzxn() { // from class: com.google.android.gms.internal.nearby.zzks
                @Override // com.google.android.gms.internal.nearby.zzxn
                public final /* synthetic */ Object zzbh() {
                    int i2 = zzkp.zza;
                    return new zzln(zzim.zza(context));
                }
            });
        }
        if (this.zzd == null) {
            this.zzd = new zzxn() { // from class: com.google.android.gms.internal.nearby.zzkn
                @Override // com.google.android.gms.internal.nearby.zzxn
                public final /* synthetic */ Object zzbh() {
                    return this.zza.zzc();
                }
            };
        }
        if (this.zze == null) {
            Context context2 = this.zza;
            int i2 = zzkp.zza;
            final ArrayList arrayList = new ArrayList();
            Collections.addAll(arrayList, zzqr.zza(context2).zza(), new zzqx());
            this.zze = zzxr.zza(new zzxn() { // from class: com.google.android.gms.internal.nearby.zzkr
                @Override // com.google.android.gms.internal.nearby.zzxn
                public final /* synthetic */ Object zzbh() {
                    int i3 = zzkp.zza;
                    return new zzqo(arrayList);
                }
            });
        }
        if (this.zzf == null) {
            this.zzf = new zzxn() { // from class: com.google.android.gms.internal.nearby.zzkm
                @Override // com.google.android.gms.internal.nearby.zzxn
                public final /* synthetic */ Object zzbh() {
                    return this.zza.zzd();
                }
            };
        }
        return new zzkp(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzf, null);
    }

    final /* synthetic */ zzxb zzc() {
        return zzxb.zzf(new zzpa(this.zzb, 10));
    }

    final /* synthetic */ zzxb zzd() {
        Context context = this.zza;
        int i = zzkp.zza;
        try {
            return zzxb.zzf(context.getPackageManager().getApplicationInfo("com.google.android.gms", 0));
        } catch (PackageManager.NameNotFoundException unused) {
            return zzxb.zze();
        }
    }
}
