package com.google.android.gms.internal.nearby;

import androidx.compose.foundation.style.StylePropertiesKt;
import com.google.android.gms.nearby.uwb.RangingPosition;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.UByte;
import kotlin.jvm.internal.ByteCompanionObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzain extends zzaio {
    private final InputStream zzf;
    private final byte[] zzg;
    private int zzh;
    private int zzi;
    private int zzj;
    private int zzk;
    private int zzl;
    private int zzm;

    /* synthetic */ zzain(InputStream inputStream, int i, byte[] bArr) {
        super(null);
        this.zzm = Integer.MAX_VALUE;
        this.zzf = inputStream;
        this.zzg = new byte[4096];
        this.zzh = 0;
        this.zzj = 0;
        this.zzl = 0;
    }

    private final void zzB() {
        int i = this.zzh + this.zzi;
        this.zzh = i;
        int i2 = this.zzl + i;
        int i3 = this.zzm;
        if (i2 <= i3) {
            this.zzi = 0;
            return;
        }
        int i4 = i2 - i3;
        this.zzi = i4;
        this.zzh = i - i4;
    }

    private final void zzH(int i) throws IOException {
        if (zzI(i)) {
            return;
        }
        if (i <= (Integer.MAX_VALUE - this.zzl) - this.zzj) {
            throw new zzakf("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        throw new zzakf("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit. If reading multiple messages, consider resetting the counter between each message using CodedInputStream.resetSizeCounter().");
    }

    private final boolean zzI(int i) throws IOException {
        int i2 = this.zzj;
        int i3 = i2 + i;
        int i4 = this.zzh;
        if (i3 <= i4) {
            StringBuilder sb = new StringBuilder(String.valueOf(i).length() + 66);
            sb.append("refillBuffer() called when ");
            sb.append(i);
            sb.append(" bytes were already available in buffer");
            throw new IllegalStateException(sb.toString());
        }
        int i5 = this.zzl;
        int i6 = i5 + i2;
        if (zzU(i6, i, Integer.MAX_VALUE) || zzU(i6, i, this.zzm)) {
            return false;
        }
        if (i2 > 0) {
            if (i4 > i2) {
                byte[] bArr = this.zzg;
                System.arraycopy(bArr, i2, bArr, 0, i4 - i2);
            }
            i5 = this.zzl + i2;
            this.zzl = i5;
            i4 = this.zzh - i2;
            this.zzh = i4;
            this.zzj = 0;
        }
        try {
            int i7 = this.zzf.read(this.zzg, i4, Math.min(4096 - i4, (Integer.MAX_VALUE - i5) - i4));
            if (i7 != 0 && i7 >= -1 && i7 <= 4096) {
                if (i7 <= 0) {
                    return false;
                }
                this.zzh += i7;
                zzB();
                return this.zzh >= i || zzI(i);
            }
            String strValueOf = String.valueOf(this.zzf.getClass());
            StringBuilder sb2 = new StringBuilder(String.valueOf(strValueOf).length() + 39 + String.valueOf(i7).length() + 41);
            sb2.append(strValueOf);
            sb2.append("#read(byte[]) returned invalid result: ");
            sb2.append(i7);
            sb2.append("\nThe InputStream implementation is buggy.");
            throw new IllegalStateException(sb2.toString());
        } catch (zzakf e) {
            e.zza();
            throw e;
        }
    }

    private final byte[] zzR(int i, boolean z) throws IOException {
        byte[] bArrZzS = zzS(i);
        if (bArrZzS != null) {
            return bArrZzS;
        }
        int i2 = this.zzj;
        int i3 = this.zzh;
        int i4 = i3 - i2;
        this.zzl += i3;
        this.zzj = 0;
        this.zzh = 0;
        List<byte[]> listZzT = zzT(i - i4);
        byte[] bArr = new byte[i];
        System.arraycopy(this.zzg, i2, bArr, 0, i4);
        for (byte[] bArr2 : listZzT) {
            int length = bArr2.length;
            System.arraycopy(bArr2, 0, bArr, i4, length);
            i4 += length;
        }
        return bArr;
    }

    private final byte[] zzS(int i) throws IOException {
        if (i == 0) {
            return zzaka.zza;
        }
        int i2 = this.zzl;
        int i3 = this.zzj;
        int i4 = i2 + i3;
        if (zzU(i4, i, Integer.MAX_VALUE)) {
            throw new zzakf("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit. If reading multiple messages, consider resetting the counter between each message using CodedInputStream.resetSizeCounter().");
        }
        int i5 = this.zzm;
        if (zzU(i4, i, i5)) {
            if (i5 >= i4) {
                zzK(i5 - i4);
            }
            throw new zzakf("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        int i6 = this.zzh - i3;
        int i7 = i - i6;
        if (i7 >= 4096) {
            try {
                if (i7 > this.zzf.available()) {
                    return null;
                }
            } catch (zzakf e) {
                e.zza();
                throw e;
            }
        }
        byte[] bArr = new byte[i];
        System.arraycopy(this.zzg, this.zzj, bArr, 0, i6);
        this.zzl += this.zzh;
        this.zzj = 0;
        this.zzh = 0;
        while (i6 < i) {
            try {
                int i8 = this.zzf.read(bArr, i6, i - i6);
                if (i8 == -1) {
                    throw new zzakf("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                }
                this.zzl += i8;
                i6 += i8;
            } catch (zzakf e2) {
                e2.zza();
                throw e2;
            }
        }
        return bArr;
    }

    private final List zzT(int i) throws IOException {
        ArrayList arrayList = new ArrayList();
        while (i > 0) {
            int iMin = Math.min(i, 4096);
            byte[] bArr = new byte[iMin];
            int i2 = 0;
            while (i2 < iMin) {
                try {
                    int i3 = this.zzf.read(bArr, i2, iMin - i2);
                    if (i3 == -1) {
                        throw new zzakf("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                    }
                    this.zzl += i3;
                    i2 += i3;
                } catch (zzakf e) {
                    e.zza();
                    throw e;
                }
            }
            i -= iMin;
            arrayList.add(bArr);
        }
        return arrayList;
    }

    private static boolean zzU(int i, int i2, int i3) {
        return i3 < i || i2 > i3 - i;
    }

    public final byte zzA() throws IOException {
        if (this.zzj == this.zzh) {
            zzH(1);
        }
        byte[] bArr = this.zzg;
        int i = this.zzj;
        this.zzj = i + 1;
        return bArr[i];
    }

    @Override // com.google.android.gms.internal.nearby.zzaio
    public final void zzD(int i) {
        this.zzm = i;
        zzB();
    }

    @Override // com.google.android.gms.internal.nearby.zzaio
    public final int zzE() {
        int i = this.zzm;
        if (i == Integer.MAX_VALUE) {
            return -1;
        }
        return i - (this.zzl + this.zzj);
    }

    @Override // com.google.android.gms.internal.nearby.zzaio
    public final boolean zzF() throws IOException {
        return this.zzj == this.zzh && !zzI(1);
    }

    @Override // com.google.android.gms.internal.nearby.zzaio
    public final int zzG() {
        return this.zzl + this.zzj;
    }

    @Override // com.google.android.gms.internal.nearby.zzaio
    public final int zzJ(byte[] bArr, int i, int i2) throws IOException {
        zzaio.zzQ(bArr, i, i2);
        if (i2 == 0) {
            return 0;
        }
        int i3 = this.zzh;
        int i4 = this.zzj;
        int i5 = i3 - i4;
        if (i5 > 0) {
            int iMin = Math.min(i2, i5);
            System.arraycopy(this.zzg, this.zzj, bArr, i, iMin);
            this.zzj += iMin;
            return iMin;
        }
        int iMin2 = Math.min(i2, (this.zzm - this.zzl) - i4);
        if (iMin2 <= 0) {
            return -1;
        }
        try {
            int i6 = this.zzf.read(bArr, i, iMin2);
            if (i6 != -1) {
                this.zzl += i6;
            }
            return i6;
        } catch (zzakf e) {
            e.zza();
            throw e;
        }
    }

    @Override // com.google.android.gms.internal.nearby.zzaio
    public final void zzK(int i) throws IOException {
        int i2 = this.zzh;
        int i3 = this.zzj;
        int i4 = i2 - i3;
        if (i <= i4 && i >= 0) {
            this.zzj = i3 + i;
            return;
        }
        if (i < 0) {
            throw new zzakf("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        int i5 = this.zzl + i3;
        if (zzU(i5, i, Integer.MAX_VALUE)) {
            throw new zzakf("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit. If reading multiple messages, consider resetting the counter between each message using CodedInputStream.resetSizeCounter().");
        }
        int i6 = this.zzm;
        if (zzU(i5, i, i6)) {
            if (i6 >= i5) {
                zzK(i6 - i5);
            }
            throw new zzakf("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        this.zzl = i5;
        this.zzh = 0;
        this.zzj = 0;
        while (i4 < i) {
            try {
                long j = i - i4;
                try {
                    long jSkip = this.zzf.skip(j);
                    if (jSkip < 0 || jSkip > j) {
                        String strValueOf = String.valueOf(this.zzf.getClass());
                        StringBuilder sb = new StringBuilder(String.valueOf(strValueOf).length() + 31 + String.valueOf(jSkip).length() + 41);
                        sb.append(strValueOf);
                        sb.append("#skip returned invalid result: ");
                        sb.append(jSkip);
                        sb.append("\nThe InputStream implementation is buggy.");
                        throw new IllegalStateException(sb.toString());
                    }
                    if (jSkip == 0) {
                        break;
                    } else {
                        i4 += (int) jSkip;
                    }
                } catch (zzakf e) {
                    e.zza();
                    throw e;
                }
            } catch (Throwable th) {
                this.zzl += i4;
                zzB();
                throw th;
            }
        }
        this.zzl += i4;
        zzB();
        if (i4 >= i) {
            return;
        }
        int i7 = this.zzh;
        int i8 = i7 - this.zzj;
        this.zzj = i7;
        zzH(1);
        while (true) {
            int i9 = i - i8;
            int i10 = this.zzh;
            if (i9 <= i10) {
                this.zzj = i9;
                return;
            } else {
                i8 += i10;
                this.zzj = i10;
                zzH(1);
            }
        }
    }

    @Override // com.google.android.gms.internal.nearby.zzaio
    public final int zza() throws IOException {
        if (zzF()) {
            this.zzk = 0;
            return 0;
        }
        int iZzx = zzx();
        this.zzk = iZzx;
        if ((iZzx >>> 3) != 0) {
            return iZzx;
        }
        throw new zzakf("Protocol message contained an invalid tag (zero).");
    }

    @Override // com.google.android.gms.internal.nearby.zzaio
    public final void zzb(int i) throws zzakf {
        if (this.zzk != i) {
            throw new zzakf("Protocol message end-group tag did not match expected tag.");
        }
    }

    @Override // com.google.android.gms.internal.nearby.zzaio
    public final double zzd() throws IOException {
        return Double.longBitsToDouble(zzy());
    }

    @Override // com.google.android.gms.internal.nearby.zzaio
    public final float zze() throws IOException {
        return Float.intBitsToFloat(zzw());
    }

    @Override // com.google.android.gms.internal.nearby.zzaio
    public final long zzf() throws IOException {
        return zzz();
    }

    @Override // com.google.android.gms.internal.nearby.zzaio
    public final long zzg() throws IOException {
        return zzz();
    }

    @Override // com.google.android.gms.internal.nearby.zzaio
    public final int zzh() throws IOException {
        return zzx();
    }

    @Override // com.google.android.gms.internal.nearby.zzaio
    public final long zzi() throws IOException {
        return zzy();
    }

    @Override // com.google.android.gms.internal.nearby.zzaio
    public final int zzj() throws IOException {
        return zzw();
    }

    @Override // com.google.android.gms.internal.nearby.zzaio
    public final boolean zzk() throws IOException {
        return zzz() != 0;
    }

    @Override // com.google.android.gms.internal.nearby.zzaio
    public final String zzl() throws IOException {
        int iZzx = zzx();
        if (iZzx > 0) {
            int i = this.zzh;
            int i2 = this.zzj;
            if (iZzx <= i - i2) {
                String str = new String(this.zzg, i2, iZzx, StandardCharsets.UTF_8);
                this.zzj += iZzx;
                return str;
            }
        }
        if (iZzx == 0) {
            return "";
        }
        if (iZzx < 0) {
            throw new zzakf("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        if (iZzx > this.zzh) {
            return new String(zzR(iZzx, false), StandardCharsets.UTF_8);
        }
        zzH(iZzx);
        String str2 = new String(this.zzg, this.zzj, iZzx, StandardCharsets.UTF_8);
        this.zzj += iZzx;
        return str2;
    }

    @Override // com.google.android.gms.internal.nearby.zzaio
    public final String zzm() throws IOException {
        byte[] bArrZzR;
        int iZzx = zzx();
        int i = this.zzj;
        int i2 = this.zzh;
        if (iZzx <= i2 - i && iZzx > 0) {
            bArrZzR = this.zzg;
            this.zzj = i + iZzx;
        } else {
            if (iZzx == 0) {
                return "";
            }
            if (iZzx < 0) {
                throw new zzakf("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
            }
            i = 0;
            if (iZzx <= i2) {
                zzH(iZzx);
                bArrZzR = this.zzg;
                this.zzj = iZzx;
            } else {
                bArrZzR = zzR(iZzx, false);
            }
        }
        return zzaly.zzd(bArrZzR, i, iZzx);
    }

    @Override // com.google.android.gms.internal.nearby.zzaio
    public final zzaik zzn() throws IOException {
        int iZzx = zzx();
        int i = this.zzh;
        int i2 = this.zzj;
        if (iZzx <= i - i2 && iZzx > 0) {
            zzaik zzaikVarZzk = zzaik.zzk(this.zzg, i2, iZzx, false);
            this.zzj += iZzx;
            return zzaikVarZzk;
        }
        if (iZzx == 0) {
            return zzaik.zza;
        }
        if (iZzx < 0) {
            throw new zzakf("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        byte[] bArrZzS = zzS(iZzx);
        if (bArrZzS != null) {
            return zzaik.zzk(bArrZzS, 0, bArrZzS.length, false);
        }
        int i3 = this.zzj;
        int i4 = this.zzh;
        int i5 = i4 - i3;
        this.zzl += i4;
        this.zzj = 0;
        this.zzh = 0;
        List<byte[]> listZzT = zzT(iZzx - i5);
        byte[] bArr = new byte[iZzx];
        System.arraycopy(this.zzg, i3, bArr, 0, i5);
        for (byte[] bArr2 : listZzT) {
            int length = bArr2.length;
            System.arraycopy(bArr2, 0, bArr, i5, length);
            i5 += length;
        }
        zzaik zzaikVar = zzaik.zza;
        try {
            return zzaik.zzl(bArr, false);
        } catch (zzakf e) {
            throw new AssertionError("Expected no InvalidProtocolBufferException as data UTF8 validity is not checked.", e);
        }
    }

    @Override // com.google.android.gms.internal.nearby.zzaio
    public final byte[] zzo() throws IOException {
        int iZzx = zzx();
        int i = this.zzh;
        int i2 = this.zzj;
        if (iZzx > i - i2 || iZzx <= 0) {
            if (iZzx >= 0) {
                return zzR(iZzx, false);
            }
            throw new zzakf("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        byte[] bArrCopyOfRange = Arrays.copyOfRange(this.zzg, i2, i2 + iZzx);
        this.zzj += iZzx;
        return bArrCopyOfRange;
    }

    @Override // com.google.android.gms.internal.nearby.zzaio
    public final int zzp() throws IOException {
        return zzx();
    }

    @Override // com.google.android.gms.internal.nearby.zzaio
    public final int zzq() throws IOException {
        return zzx();
    }

    @Override // com.google.android.gms.internal.nearby.zzaio
    public final int zzr() throws IOException {
        return zzw();
    }

    @Override // com.google.android.gms.internal.nearby.zzaio
    public final long zzs() throws IOException {
        return zzy();
    }

    @Override // com.google.android.gms.internal.nearby.zzaio
    public final int zzt() throws IOException {
        int iZzx = zzx();
        return (-(iZzx & 1)) ^ (iZzx >>> 1);
    }

    @Override // com.google.android.gms.internal.nearby.zzaio
    public final long zzu() throws IOException {
        long jZzz = zzz();
        return (-(jZzz & 1)) ^ (jZzz >>> 1);
    }

    final long zzv() throws IOException {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            byte bZzA = zzA();
            j |= ((long) (bZzA & ByteCompanionObject.MAX_VALUE)) << i;
            if ((bZzA & ByteCompanionObject.MIN_VALUE) == 0) {
                return j;
            }
        }
        throw new zzakf("CodedInputStream encountered a malformed varint.");
    }

    public final int zzw() throws IOException {
        int i = this.zzj;
        if (this.zzh - i < 4) {
            zzH(4);
            i = this.zzj;
        }
        byte[] bArr = this.zzg;
        this.zzj = i + 4;
        return (bArr[i] & UByte.MAX_VALUE) | ((bArr[i + 1] & UByte.MAX_VALUE) << 8) | ((bArr[i + 2] & UByte.MAX_VALUE) << 16) | ((bArr[i + 3] & UByte.MAX_VALUE) << 24);
    }

    public final long zzy() throws IOException {
        int i = this.zzj;
        if (this.zzh - i < 8) {
            zzH(8);
            i = this.zzj;
        }
        byte[] bArr = this.zzg;
        this.zzj = i + 8;
        long j = bArr[i];
        long j2 = (((long) bArr[i + 1]) & 255) << 8;
        long j3 = bArr[i + 2];
        long j4 = bArr[i + 3];
        return ((((long) bArr[i + 6]) & 255) << 48) | (j & 255) | j2 | ((j3 & 255) << 16) | ((j4 & 255) << 24) | ((bArr[i + 4] & 255) << 32) | ((bArr[i + 5] & 255) << 40) | ((((long) bArr[i + 7]) & 255) << 56);
    }

    @Override // com.google.android.gms.internal.nearby.zzaio
    public final int zzC(int i) throws zzakf {
        if (i < 0) {
            throw new zzakf("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        int i2 = this.zzl + this.zzj;
        if (i > Integer.MAX_VALUE - i2) {
            throw new zzakf("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit. If reading multiple messages, consider resetting the counter between each message using CodedInputStream.resetSizeCounter().");
        }
        int i3 = this.zzm;
        if (zzU(i2, i, i3)) {
            throw new zzakf("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        this.zzm = i2 + i;
        zzB();
        return i3;
    }

    @Override // com.google.android.gms.internal.nearby.zzaio
    public final int zzx() throws IOException {
        int i;
        int i2 = this.zzj;
        int i3 = this.zzh;
        if (i3 != i2) {
            byte[] bArr = this.zzg;
            int i4 = i2 + 1;
            byte b = bArr[i2];
            if (b >= 0) {
                this.zzj = i4;
                return b;
            }
            if (i3 - i4 >= 9) {
                int i5 = i2 + 2;
                int i6 = (bArr[i4] << 7) ^ b;
                if (i6 < 0) {
                    i = i6 ^ RangingPosition.RSSI_UNKNOWN;
                } else {
                    int i7 = i2 + 3;
                    int i8 = (bArr[i5] << StylePropertiesKt.TopId) ^ i6;
                    if (i8 >= 0) {
                        i = i8 ^ 16256;
                    } else {
                        int i9 = i2 + 4;
                        int i10 = i8 ^ (bArr[i7] << StylePropertiesKt.AlphaId);
                        if (i10 < 0) {
                            i = (-2080896) ^ i10;
                        } else {
                            i7 = i2 + 5;
                            byte b2 = bArr[i9];
                            int i11 = (i10 ^ (b2 << StylePropertiesKt.RotationZId)) ^ 266354560;
                            if (b2 < 0) {
                                i9 = i2 + 6;
                                if (bArr[i7] < 0) {
                                    i7 = i2 + 7;
                                    if (bArr[i9] < 0) {
                                        i9 = i2 + 8;
                                        if (bArr[i7] < 0) {
                                            i7 = i2 + 9;
                                            if (bArr[i9] < 0) {
                                                int i12 = i2 + 10;
                                                if (bArr[i7] >= 0) {
                                                    i5 = i12;
                                                    i = i11;
                                                }
                                            }
                                        }
                                    }
                                }
                                i = i11;
                            }
                            i = i11;
                        }
                        i5 = i9;
                    }
                    i5 = i7;
                }
                this.zzj = i5;
                return i;
            }
        }
        return (int) zzv();
    }

    @Override // com.google.android.gms.internal.nearby.zzaio
    public final boolean zzc(int i) throws IOException {
        int i2 = i & 7;
        int i3 = 0;
        if (i2 == 0) {
            if (this.zzh - this.zzj < 10) {
                while (i3 < 10) {
                    if (zzA() < 0) {
                        i3++;
                    }
                }
                throw new zzakf("CodedInputStream encountered a malformed varint.");
            }
            while (i3 < 10) {
                byte[] bArr = this.zzg;
                int i4 = this.zzj;
                this.zzj = i4 + 1;
                if (bArr[i4] < 0) {
                    i3++;
                }
            }
            throw new zzakf("CodedInputStream encountered a malformed varint.");
            return true;
        }
        if (i2 == 1) {
            zzK(8);
            return true;
        }
        if (i2 == 2) {
            zzK(zzx());
            return true;
        }
        if (i2 == 3) {
            zzP();
            zzb(((i >>> 3) << 3) | 4);
            return true;
        }
        if (i2 == 4) {
            zzO();
            return false;
        }
        if (i2 != 5) {
            throw new zzake("Protocol message tag had invalid wire type.");
        }
        zzK(4);
        return true;
    }

    @Override // com.google.android.gms.internal.nearby.zzaio
    public final long zzz() throws IOException {
        long j;
        long j2;
        long j3;
        int i = this.zzj;
        int i2 = this.zzh;
        if (i2 != i) {
            byte[] bArr = this.zzg;
            int i3 = i + 1;
            byte b = bArr[i];
            if (b >= 0) {
                this.zzj = i3;
                return b;
            }
            if (i2 - i3 >= 9) {
                int i4 = i + 2;
                int i5 = (bArr[i3] << 7) ^ b;
                if (i5 < 0) {
                    j = i5 ^ RangingPosition.RSSI_UNKNOWN;
                } else {
                    int i6 = i + 3;
                    int i7 = (bArr[i4] << StylePropertiesKt.TopId) ^ i5;
                    if (i7 >= 0) {
                        j = i7 ^ 16256;
                    } else {
                        int i8 = i + 4;
                        int i9 = i7 ^ (bArr[i6] << StylePropertiesKt.AlphaId);
                        if (i9 < 0) {
                            long j4 = (-2080896) ^ i9;
                            i4 = i8;
                            j = j4;
                        } else {
                            i6 = i + 5;
                            long j5 = (((long) bArr[i8]) << 28) ^ ((long) i9);
                            if (j5 >= 0) {
                                j = j5 ^ 266354560;
                            } else {
                                i4 = i + 6;
                                long j6 = (((long) bArr[i6]) << 35) ^ j5;
                                if (j6 < 0) {
                                    j3 = -34093383808L;
                                } else {
                                    int i10 = i + 7;
                                    long j7 = j6 ^ (((long) bArr[i4]) << 42);
                                    if (j7 >= 0) {
                                        j2 = 4363953127296L;
                                    } else {
                                        i4 = i + 8;
                                        j6 = j7 ^ (((long) bArr[i10]) << 49);
                                        if (j6 < 0) {
                                            j3 = -558586000294016L;
                                        } else {
                                            i10 = i + 9;
                                            j7 = j6 ^ (((long) bArr[i4]) << 56);
                                            if (j7 >= 0) {
                                                j2 = 71499008037633920L;
                                            } else {
                                                i4 = i + 10;
                                                long j8 = j7 ^ (((long) bArr[i10]) << 63);
                                                if (j8 >= 0) {
                                                    j = j8 ^ (-9151873028817141888L);
                                                }
                                            }
                                        }
                                    }
                                    j = j7 ^ j2;
                                    i4 = i10;
                                }
                                j = j6 ^ j3;
                            }
                        }
                    }
                    i4 = i6;
                }
                this.zzj = i4;
                return j;
            }
        }
        return zzv();
    }
}
