package com.google.android.gms.internal.nearby;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzxp implements zzxn {
    private final zzxu zza = new zzxu();
    private volatile zzxn zzb;
    private Object zzc;

    zzxp(zzxn zzxnVar) {
        this.zzb = zzxnVar;
    }

    public final String toString() {
        Object string = this.zzb;
        if (string == null) {
            String strValueOf = String.valueOf(this.zzc);
            StringBuilder sb = new StringBuilder(String.valueOf(strValueOf).length() + 25);
            sb.append("<supplier that returned ");
            sb.append(strValueOf);
            sb.append(">");
            string = sb.toString();
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
        if (this.zzb != null) {
            synchronized (this.zza) {
                if (this.zzb != null) {
                    Object objZzbh = this.zzb.zzbh();
                    this.zzc = objZzbh;
                    this.zzb = null;
                    return objZzbh;
                }
            }
        }
        return this.zzc;
    }
}
