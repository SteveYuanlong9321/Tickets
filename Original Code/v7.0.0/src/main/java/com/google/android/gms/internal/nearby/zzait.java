package com.google.android.gms.internal.nearby;

import com.google.android.gms.nearby.uwb.RangingPosition;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzait extends zzaiu {
    private final byte[] zzb;
    private final int zzc;
    private int zzd;
    private int zze;
    private final OutputStream zzf;

    zzait(OutputStream outputStream, int i) {
        super(null);
        if (outputStream == null) {
            throw new NullPointerException("out");
        }
        this.zzf = outputStream;
        if (i < 0) {
            throw new IllegalArgumentException("bufferSize must be >= 0");
        }
        byte[] bArr = new byte[Math.max(i, 20)];
        this.zzb = bArr;
        this.zzc = bArr.length;
    }

    private final void zzG(int i) throws IOException {
        if (this.zzc - this.zzd < i) {
            zzH();
        }
    }

    private final void zzH() throws IOException {
        this.zzf.write(this.zzb, 0, this.zzd);
        this.zzd = 0;
    }

    final void zzA(long j) {
        int i = this.zzd;
        int i2 = i + 1;
        long j2 = j & (-128);
        int i3 = (int) j;
        int i4 = this.zze;
        byte[] bArr = this.zzb;
        if (j2 == 0) {
            bArr[i] = (byte) i3;
            this.zzd = i2;
            this.zze = i4 + 1;
            return;
        }
        int i5 = i + 2;
        bArr[i] = (byte) (i3 | 128);
        long j3 = j >>> 7;
        long j4 = j3 & (-128);
        int i6 = (int) j3;
        if (j4 == 0) {
            bArr[i2] = (byte) i6;
            this.zzd = i5;
            this.zze = i4 + 2;
            return;
        }
        int i7 = i + 3;
        bArr[i2] = (byte) (i6 | 128);
        long j5 = j >>> 14;
        long j6 = j5 & (-128);
        int i8 = (int) j5;
        if (j6 == 0) {
            bArr[i5] = (byte) i8;
            this.zzd = i7;
            this.zze = i4 + 3;
            return;
        }
        int i9 = i + 4;
        bArr[i5] = (byte) (i8 | 128);
        long j7 = j >>> 21;
        long j8 = j7 & (-128);
        int i10 = (int) j7;
        if (j8 == 0) {
            bArr[i7] = (byte) i10;
            this.zzd = i9;
            this.zze = i4 + 4;
            return;
        }
        int i11 = i + 5;
        bArr[i7] = (byte) (i10 | 128);
        long j9 = j >>> 28;
        int i12 = (int) j9;
        if ((j9 & (-128)) == 0) {
            bArr[i9] = (byte) i12;
            this.zzd = i11;
            this.zze = i4 + 5;
            return;
        }
        int i13 = i + 6;
        bArr[i9] = (byte) (i12 | 128);
        long j10 = j >>> 35;
        int i14 = (int) j10;
        if ((j10 & (-128)) == 0) {
            bArr[i11] = (byte) i14;
            this.zzd = i13;
            this.zze = i4 + 6;
            return;
        }
        int i15 = i + 7;
        bArr[i11] = (byte) (i14 | 128);
        long j11 = j >>> 42;
        long j12 = j11 & (-128);
        int i16 = (int) j11;
        if (j12 == 0) {
            bArr[i13] = (byte) i16;
            this.zzd = i15;
            this.zze = i4 + 7;
            return;
        }
        int i17 = i + 8;
        bArr[i13] = (byte) (i16 | 128);
        long j13 = j >>> 49;
        long j14 = j13 & (-128);
        int i18 = (int) j13;
        if (j14 == 0) {
            bArr[i15] = (byte) i18;
            this.zzd = i17;
            this.zze = i4 + 8;
            return;
        }
        int i19 = i + 9;
        bArr[i15] = (byte) (i18 | 128);
        long j15 = j >>> 56;
        long j16 = j15 & (-128);
        int i20 = (int) j15;
        if (j16 == 0) {
            bArr[i17] = (byte) i20;
            this.zzd = i19;
            this.zze = i4 + 9;
        } else {
            bArr[i17] = (byte) (i20 | 128);
            bArr[i19] = (byte) (j >>> 63);
            this.zzd = i + 10;
            this.zze = i4 + 10;
        }
    }

    final void zzB(int i) {
        int i2 = this.zzd;
        byte[] bArr = this.zzb;
        bArr[i2] = (byte) i;
        bArr[i2 + 1] = (byte) (i >> 8);
        bArr[i2 + 2] = (byte) (i >> 16);
        bArr[i2 + 3] = (byte) (i >> 24);
        this.zzd = i2 + 4;
        this.zze += 4;
    }

    final void zzC(long j) {
        int i = this.zzd;
        byte[] bArr = this.zzb;
        bArr[i] = (byte) j;
        bArr[i + 1] = (byte) (j >> 8);
        bArr[i + 2] = (byte) (j >> 16);
        bArr[i + 3] = (byte) (j >> 24);
        bArr[i + 4] = (byte) (j >> 32);
        bArr[i + 5] = (byte) (j >> 40);
        bArr[i + 6] = (byte) (j >> 48);
        bArr[i + 7] = (byte) (j >> 56);
        this.zzd = i + 8;
        this.zze += 8;
    }

    public final void zzD(byte[] bArr, int i, int i2) throws IOException {
        int i3 = this.zzc;
        int i4 = this.zzd;
        int i5 = i3 - i4;
        byte[] bArr2 = this.zzb;
        if (i5 >= i2) {
            System.arraycopy(bArr, i, bArr2, i4, i2);
            this.zzd += i2;
            this.zze += i2;
            return;
        }
        System.arraycopy(bArr, i, bArr2, i4, i5);
        int i6 = i + i5;
        this.zzd = i3;
        this.zze += i5;
        zzH();
        int i7 = i2 - i5;
        if (i7 <= i3) {
            System.arraycopy(bArr, i6, bArr2, 0, i7);
            this.zzd = i7;
        } else {
            this.zzf.write(bArr, i6, i7);
        }
        this.zze += i7;
    }

    @Override // com.google.android.gms.internal.nearby.zzaic
    public final void zza(byte[] bArr, int i, int i2) throws IOException {
        zzD(bArr, i, i2);
    }

    @Override // com.google.android.gms.internal.nearby.zzaiu
    public final void zzb(int i, int i2) throws IOException {
        zzr((i << 3) | i2);
    }

    @Override // com.google.android.gms.internal.nearby.zzaiu
    public final void zzc(int i, int i2) throws IOException {
        zzG(20);
        zzz(i << 3);
        if (i2 >= 0) {
            zzz(i2);
        } else {
            zzA(i2);
        }
    }

    @Override // com.google.android.gms.internal.nearby.zzaiu
    public final void zzd(int i, int i2) throws IOException {
        zzG(20);
        zzz(i << 3);
        zzz(i2);
    }

    @Override // com.google.android.gms.internal.nearby.zzaiu
    public final void zze(int i, int i2) throws IOException {
        zzG(14);
        zzz((i << 3) | 5);
        zzB(i2);
    }

    @Override // com.google.android.gms.internal.nearby.zzaiu
    public final void zzf(int i, long j) throws IOException {
        zzG(20);
        zzz(i << 3);
        zzA(j);
    }

    @Override // com.google.android.gms.internal.nearby.zzaiu
    public final void zzg(int i, long j) throws IOException {
        zzG(18);
        zzz((i << 3) | 1);
        zzC(j);
    }

    @Override // com.google.android.gms.internal.nearby.zzaiu
    public final void zzh(int i, boolean z) throws IOException {
        zzG(11);
        zzz(i << 3);
        zzv(z ? (byte) 1 : (byte) 0);
    }

    @Override // com.google.android.gms.internal.nearby.zzaiu
    public final void zzi(int i, String str) throws IOException {
        zzr((i << 3) | 2);
        zzw(str);
    }

    @Override // com.google.android.gms.internal.nearby.zzaiu
    public final void zzj(int i, zzaik zzaikVar) throws IOException {
        zzr((i << 3) | 2);
        zzk(zzaikVar);
    }

    @Override // com.google.android.gms.internal.nearby.zzaiu
    public final void zzk(zzaik zzaikVar) throws IOException {
        zzr(zzaikVar.zzb());
        zzaikVar.zze(this);
    }

    @Override // com.google.android.gms.internal.nearby.zzaiu
    public final void zzl(byte[] bArr, int i, int i2) throws IOException {
        zzr(i2);
        zzD(bArr, 0, i2);
    }

    @Override // com.google.android.gms.internal.nearby.zzaiu
    public final void zzm(int i, zzaks zzaksVar) throws IOException {
        zzr(11);
        zzd(2, i);
        zzr(26);
        zzo(zzaksVar);
        zzr(12);
    }

    @Override // com.google.android.gms.internal.nearby.zzaiu
    public final void zzn(int i, zzaik zzaikVar) throws IOException {
        zzr(11);
        zzd(2, i);
        zzj(3, zzaikVar);
        zzr(12);
    }

    @Override // com.google.android.gms.internal.nearby.zzaiu
    public final void zzo(zzaks zzaksVar) throws IOException {
        zzr(zzaksVar.zzJ());
        zzaksVar.zzbd(this);
    }

    @Override // com.google.android.gms.internal.nearby.zzaiu
    public final void zzp(byte b) throws IOException {
        if (this.zzd == this.zzc) {
            zzH();
        }
        zzv(b);
    }

    @Override // com.google.android.gms.internal.nearby.zzaiu
    public final void zzq(int i) throws IOException {
        if (i >= 0) {
            zzr(i);
        } else {
            zzt(i);
        }
    }

    @Override // com.google.android.gms.internal.nearby.zzaiu
    public final void zzr(int i) throws IOException {
        zzG(5);
        zzz(i);
    }

    @Override // com.google.android.gms.internal.nearby.zzaiu
    public final void zzs(int i) throws IOException {
        zzG(4);
        zzB(i);
    }

    @Override // com.google.android.gms.internal.nearby.zzaiu
    public final void zzt(long j) throws IOException {
        zzG(10);
        zzA(j);
    }

    @Override // com.google.android.gms.internal.nearby.zzaiu
    public final void zzu(long j) throws IOException {
        zzG(8);
        zzC(j);
    }

    final void zzv(byte b) {
        byte[] bArr = this.zzb;
        int i = this.zzd;
        bArr[i] = b;
        this.zzd = i + 1;
        this.zze++;
    }

    @Override // com.google.android.gms.internal.nearby.zzaiu
    public final void zzw(String str) throws IOException {
        int iZzb;
        int length = str.length() * 3;
        int iNumberOfLeadingZeros = (352 - (Integer.numberOfLeadingZeros(length) * 9)) >>> 6;
        int i = iNumberOfLeadingZeros + length;
        int i2 = this.zzc;
        if (i > i2) {
            byte[] bArr = new byte[length];
            int iZzc = zzaly.zzc(str, bArr, 0, length);
            zzr(iZzc);
            zzD(bArr, 0, iZzc);
            return;
        }
        if (i > i2 - this.zzd) {
            zzH();
        }
        int iNumberOfLeadingZeros2 = Integer.numberOfLeadingZeros(str.length()) * 9;
        int i3 = this.zzd;
        int i4 = (352 - iNumberOfLeadingZeros2) >>> 6;
        try {
            if (i4 == iNumberOfLeadingZeros) {
                int i5 = i3 + i4;
                this.zzd = i5;
                int iZzc2 = zzaly.zzc(str, this.zzb, i5, i2 - i5);
                this.zzd = i3;
                iZzb = (iZzc2 - i3) - i4;
                zzz(iZzb);
                this.zzd = iZzc2;
            } else {
                iZzb = zzaly.zzb(str);
                zzz(iZzb);
                this.zzd = zzaly.zzc(str, this.zzb, this.zzd, iZzb);
            }
            this.zze += iZzb;
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new zzais(e);
        }
    }

    @Override // com.google.android.gms.internal.nearby.zzaiu
    public final void zzx() throws IOException {
        if (this.zzd > 0) {
            zzH();
        }
    }

    @Override // com.google.android.gms.internal.nearby.zzaiu
    public final int zzy() {
        throw new UnsupportedOperationException("spaceLeft() can only be called on CodedOutputStreams that are writing to a flat array or ByteBuffer.");
    }

    final void zzz(int i) {
        int i2 = this.zzd;
        int i3 = i2 + 1;
        int i4 = i & RangingPosition.RSSI_UNKNOWN;
        int i5 = this.zze;
        byte[] bArr = this.zzb;
        if (i4 == 0) {
            bArr[i2] = (byte) i;
            this.zzd = i3;
            this.zze = i5 + 1;
            return;
        }
        int i6 = i2 + 2;
        bArr[i2] = (byte) (i | 128);
        int i7 = i >>> 7;
        if ((i7 & RangingPosition.RSSI_UNKNOWN) == 0) {
            bArr[i3] = (byte) i7;
            this.zzd = i6;
            this.zze = i5 + 2;
            return;
        }
        int i8 = i2 + 3;
        bArr[i3] = (byte) (i7 | 128);
        int i9 = i >>> 14;
        if ((i9 & RangingPosition.RSSI_UNKNOWN) == 0) {
            bArr[i6] = (byte) i9;
            this.zzd = i8;
            this.zze = i5 + 3;
            return;
        }
        int i10 = i2 + 4;
        bArr[i6] = (byte) (i9 | 128);
        int i11 = i >>> 21;
        if ((i11 & RangingPosition.RSSI_UNKNOWN) == 0) {
            bArr[i8] = (byte) i11;
            this.zzd = i10;
            this.zze = i5 + 4;
        } else {
            bArr[i8] = (byte) (i11 | 128);
            bArr[i10] = (byte) (i >>> 28);
            this.zzd = i2 + 5;
            this.zze = i5 + 5;
        }
    }
}
