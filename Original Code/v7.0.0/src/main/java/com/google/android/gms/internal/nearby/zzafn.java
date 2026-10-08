package com.google.android.gms.internal.nearby;

import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzafn extends zzafl {
    private zzafn() {
        throw null;
    }

    /* synthetic */ zzafn(byte[] bArr) {
        super(null);
    }

    @Override // com.google.android.gms.internal.nearby.zzafl
    final void zza(zzafo zzafoVar, Set set, Set set2) {
        synchronized (zzafoVar) {
            if (zzafoVar.seenExceptionsField == null) {
                zzafoVar.seenExceptionsField = set2;
            }
        }
    }

    @Override // com.google.android.gms.internal.nearby.zzafl
    final int zzb(zzafo zzafoVar) {
        int i;
        synchronized (zzafoVar) {
            i = zzafoVar.remainingField - 1;
            zzafoVar.remainingField = i;
        }
        return i;
    }
}
