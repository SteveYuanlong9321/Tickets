package com.google.android.gms.internal.nearby;

import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzaij extends zzaii {
    private final byte[] zzb;

    zzaij(byte[] bArr) {
        super(null);
        bArr.getClass();
        this.zzb = bArr;
    }

    @Override // com.google.android.gms.internal.nearby.zzaik
    final byte zza(int i) {
        return this.zzb[i];
    }

    @Override // com.google.android.gms.internal.nearby.zzaik
    public final int zzb() {
        return this.zzb.length;
    }

    @Override // com.google.android.gms.internal.nearby.zzaik
    public final zzaik zzc(int i, int i2) {
        byte[] bArr = this.zzb;
        int iZzn = zzn(0, i2, bArr.length);
        return iZzn == 0 ? zzaik.zza : new zzaif(bArr, 0, iZzn);
    }

    @Override // com.google.android.gms.internal.nearby.zzaik
    protected final void zzd(byte[] bArr, int i, int i2, int i3) {
        System.arraycopy(this.zzb, 0, bArr, 0, i3);
    }

    @Override // com.google.android.gms.internal.nearby.zzaik
    final void zze(zzaic zzaicVar) throws IOException {
        byte[] bArr = this.zzb;
        zzaicVar.zza(bArr, 0, bArr.length);
    }

    @Override // com.google.android.gms.internal.nearby.zzaik
    protected final boolean zzf(zzaik zzaikVar) {
        boolean z = zzaikVar instanceof zzaij;
        if (z) {
            return Arrays.equals(this.zzb, ((zzaij) zzaikVar).zzb);
        }
        boolean z2 = zzaikVar instanceof zzaif;
        if (!z2) {
            return zzaikVar.zzf(this);
        }
        byte[] bArr = this.zzb;
        int iZzb = zzaikVar.zzb();
        int length = bArr.length;
        if (length > iZzb) {
            StringBuilder sb = new StringBuilder(String.valueOf(length).length() + 18 + String.valueOf(length).length());
            sb.append("Length too large: ");
            sb.append(length);
            sb.append(length);
            throw new IllegalArgumentException(sb.toString());
        }
        if (length <= zzaikVar.zzb()) {
            if (z) {
                return zzaik.zzo(bArr, 0, ((zzaij) zzaikVar).zzb, 0, length);
            }
            if (!z2) {
                return zzaikVar.zzc(0, length).equals(zzc(0, length));
            }
            zzaif zzaifVar = (zzaif) zzaikVar;
            return zzaik.zzo(bArr, 0, zzaifVar.zzh(), zzaifVar.zzi(), length);
        }
        int iZzb2 = zzaikVar.zzb();
        StringBuilder sb2 = new StringBuilder(String.valueOf(length).length() + 27 + String.valueOf(iZzb2).length());
        sb2.append("Ran off end of other: 0, ");
        sb2.append(length);
        sb2.append(", ");
        sb2.append(iZzb2);
        throw new IllegalArgumentException(sb2.toString());
    }

    @Override // com.google.android.gms.internal.nearby.zzaik
    protected final int zzg(int i, int i2, int i3) {
        return zzaka.zzc(i, this.zzb, 0, i3);
    }

    final /* synthetic */ byte[] zzh() {
        return this.zzb;
    }
}
