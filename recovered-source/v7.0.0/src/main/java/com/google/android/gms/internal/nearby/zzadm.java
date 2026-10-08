package com.google.android.gms.internal.nearby;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzadm extends zzadn {
    private final zzadl zza;

    private zzadm(zzabg zzabgVar, int i, zzadl zzadlVar) {
        super(zzabgVar, i);
        this.zza = zzadlVar;
        StringBuilder sb = new StringBuilder("%");
        zzabgVar.zzl(sb);
        sb.append(true != zzabgVar.zzk() ? 't' : 'T');
        sb.append(zzadlVar.zzb());
    }

    public static zzadn zza(zzadl zzadlVar, zzabg zzabgVar, int i) {
        return new zzadm(zzabgVar, i, zzadlVar);
    }

    @Override // com.google.android.gms.internal.nearby.zzadn
    protected final void zzb(zzado zzadoVar, Object obj) {
        zzadoVar.zzd(obj, this.zza, zzd());
    }
}
