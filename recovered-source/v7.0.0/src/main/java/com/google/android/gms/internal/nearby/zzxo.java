package com.google.android.gms.internal.nearby;

import java.io.Serializable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzxo implements Serializable, zzxn {
    final zzxn zza;
    volatile transient boolean zzb;
    transient Object zzc;
    private final transient zzxu zzd = new zzxu();

    zzxo(zzxn zzxnVar) {
        this.zza = zzxnVar;
    }

    public final String toString() {
        Object string;
        if (this.zzb) {
            String strValueOf = String.valueOf(this.zzc);
            StringBuilder sb = new StringBuilder(String.valueOf(strValueOf).length() + 25);
            sb.append("<supplier that returned ");
            sb.append(strValueOf);
            sb.append(">");
            string = sb.toString();
        } else {
            string = this.zza;
        }
        String string2 = string.toString();
        StringBuilder sb2 = new StringBuilder(string2.length() + 19);
        sb2.append("Suppliers.memoize(");
        sb2.append(string2);
        sb2.append(")");
        return sb2.toString();
    }

    @Override // com.google.android.gms.internal.nearby.zzxn
    public final Object zzbh() {
        if (!this.zzb) {
            synchronized (this.zzd) {
                if (!this.zzb) {
                    Object objZzbh = this.zza.zzbh();
                    this.zzc = objZzbh;
                    this.zzb = true;
                    return objZzbh;
                }
            }
        }
        return this.zzc;
    }
}
