package com.google.android.gms.internal.nearby;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzyd extends zzxv {
    private final zzyg zza;

    zzyd(zzyg zzygVar, int i) {
        super(zzygVar.size(), i);
        this.zza = zzygVar;
    }

    @Override // com.google.android.gms.internal.nearby.zzxv
    final Object zza(int i) {
        return this.zza.get(i);
    }
}
