package com.google.android.gms.internal.nearby;

import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzaif extends zzaii {
    private final byte[] zzb;
    private final int zzc;
    private final int zzd;

    zzaif(byte[] bArr, int i, int i2) {
        super(null);
        zzn(i, i + i2, bArr.length);
        this.zzb = bArr;
        this.zzc = i;
        this.zzd = i2;
    }

    @Override // com.google.android.gms.internal.nearby.zzaik
    final byte zza(int i) {
        return this.zzb[this.zzc + i];
    }

    @Override // com.google.android.gms.internal.nearby.zzaik
    public final int zzb() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.nearby.zzaik
    public final zzaik zzc(int i, int i2) {
        int iZzn = zzn(i, i2, this.zzd);
        return iZzn == 0 ? zzaik.zza : new zzaif(this.zzb, this.zzc + i, iZzn);
    }

    @Override // com.google.android.gms.internal.nearby.zzaik
    protected final void zzd(byte[] bArr, int i, int i2, int i3) {
        System.arraycopy(this.zzb, this.zzc, bArr, 0, i3);
    }

    @Override // com.google.android.gms.internal.nearby.zzaik
    final void zze(zzaic zzaicVar) throws IOException {
        zzaicVar.zza(this.zzb, this.zzc, this.zzd);
    }

    @Override // com.google.android.gms.internal.nearby.zzaik
    protected final boolean zzf(zzaik zzaikVar) {
        boolean z = zzaikVar instanceof zzaij;
        if (!z && !(zzaikVar instanceof zzaif)) {
            return zzaikVar.zzf(this);
        }
        int i = this.zzd;
        if (i > zzaikVar.zzb()) {
            StringBuilder sb = new StringBuilder(String.valueOf(i).length() + 18 + String.valueOf(i).length());
            sb.append("Length too large: ");
            sb.append(i);
            sb.append(i);
            throw new IllegalArgumentException(sb.toString());
        }
        if (i <= zzaikVar.zzb()) {
            if (z) {
                return zzaik.zzo(this.zzb, this.zzc, ((zzaij) zzaikVar).zzh(), 0, i);
            }
            if (zzaikVar instanceof zzaif) {
                zzaif zzaifVar = (zzaif) zzaikVar;
                return zzaik.zzo(this.zzb, this.zzc, zzaifVar.zzb, zzaifVar.zzc, i);
            }
            zzaik zzaikVarZzc = zzaikVar.zzc(0, i);
            int i2 = this.zzc;
            return zzaikVarZzc.equals(zzc(i2, i + i2));
        }
        int iZzb = zzaikVar.zzb();
        StringBuilder sb2 = new StringBuilder(String.valueOf(i).length() + 27 + String.valueOf(iZzb).length());
        sb2.append("Ran off end of other: 0, ");
        sb2.append(i);
        sb2.append(", ");
        sb2.append(iZzb);
        throw new IllegalArgumentException(sb2.toString());
    }

    @Override // com.google.android.gms.internal.nearby.zzaik
    protected final int zzg(int i, int i2, int i3) {
        return zzaka.zzc(i, this.zzb, this.zzc, i3);
    }

    final /* synthetic */ byte[] zzh() {
        return this.zzb;
    }

    final /* synthetic */ int zzi() {
        return this.zzc;
    }
}
