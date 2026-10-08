package com.google.android.gms.internal.nearby;

import java.io.Serializable;
import kotlin.UByte;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzaef extends zzaeg implements Serializable {
    final byte[] zza;

    @Override // com.google.android.gms.internal.nearby.zzaeg
    public final int zza() {
        return this.zza.length * 8;
    }

    @Override // com.google.android.gms.internal.nearby.zzaeg
    public final byte[] zzb() {
        return (byte[]) this.zza.clone();
    }

    @Override // com.google.android.gms.internal.nearby.zzaeg
    final byte[] zzd() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.nearby.zzaeg
    final boolean zze(zzaeg zzaegVar) {
        int length = zzaegVar.zzd().length;
        byte[] bArr = this.zza;
        if (bArr.length != length) {
            return false;
        }
        boolean z = true;
        for (int i = 0; i < bArr.length; i++) {
            z &= bArr[i] == zzaegVar.zzd()[i];
        }
        return z;
    }

    zzaef(byte[] bArr) {
        bArr.getClass();
        this.zza = bArr;
    }

    @Override // com.google.android.gms.internal.nearby.zzaeg
    public final int zzc() {
        byte[] bArr = this.zza;
        int length = bArr.length;
        if (length < 4) {
            throw new IllegalStateException(zzxm.zzd("HashCode#asInt() requires >= 4 bytes (it only has %s bytes).", Integer.valueOf(length)));
        }
        int i = bArr[0] & UByte.MAX_VALUE;
        int i2 = bArr[1] & UByte.MAX_VALUE;
        int i3 = bArr[2] & UByte.MAX_VALUE;
        return ((bArr[3] & UByte.MAX_VALUE) << 24) | i | (i2 << 8) | (i3 << 16);
    }
}
