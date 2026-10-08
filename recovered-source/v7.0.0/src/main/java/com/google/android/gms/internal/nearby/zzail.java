package com.google.android.gms.internal.nearby;

import androidx.compose.foundation.style.StylePropertiesKt;
import com.google.android.gms.nearby.uwb.RangingPosition;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import kotlin.UByte;
import kotlin.jvm.internal.ByteCompanionObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
abstract class zzail extends zzaio {
    private final byte[] zzf;
    private int zzg;
    private int zzh;
    private int zzi;
    private int zzj;

    /* synthetic */ zzail(byte[] bArr, int i, int i2, boolean z, byte[] bArr2) {
        super(null);
        this.zzj = Integer.MAX_VALUE;
        this.zzf = bArr;
        this.zzg = 0;
        this.zzh = 0;
    }

    private final void zzR(int i) {
        this.zzj = i;
        if (i > 0) {
            i = 0;
        }
        this.zzg = i;
    }

    public final int zzA() throws IOException {
        int i = this.zzh;
        if (this.zzg - i < 4) {
            throw new zzakf("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        byte[] bArr = this.zzf;
        this.zzh = i + 4;
        return (bArr[i] & UByte.MAX_VALUE) | ((bArr[i + 1] & UByte.MAX_VALUE) << 8) | ((bArr[i + 2] & UByte.MAX_VALUE) << 16) | ((bArr[i + 3] & UByte.MAX_VALUE) << 24);
    }

    public final long zzB() throws IOException {
        int i = this.zzh;
        if (this.zzg - i < 8) {
            throw new zzakf("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        byte[] bArr = this.zzf;
        this.zzh = i + 8;
        long j = bArr[i];
        long j2 = (((long) bArr[i + 1]) & 255) << 8;
        long j3 = bArr[i + 2];
        long j4 = bArr[i + 3];
        return ((((long) bArr[i + 6]) & 255) << 48) | (j & 255) | j2 | ((j3 & 255) << 16) | ((j4 & 255) << 24) | ((bArr[i + 4] & 255) << 32) | ((bArr[i + 5] & 255) << 40) | ((((long) bArr[i + 7]) & 255) << 56);
    }

    @Override // com.google.android.gms.internal.nearby.zzaio
    public final void zzD(int i) {
        zzR(i);
    }

    @Override // com.google.android.gms.internal.nearby.zzaio
    public final int zzE() {
        int i = this.zzj;
        if (i == Integer.MAX_VALUE) {
            return -1;
        }
        return i - this.zzh;
    }

    @Override // com.google.android.gms.internal.nearby.zzaio
    public final boolean zzF() throws IOException {
        return this.zzh == this.zzg;
    }

    @Override // com.google.android.gms.internal.nearby.zzaio
    public final int zzG() {
        return this.zzh;
    }

    public final byte zzH() throws IOException {
        int i = this.zzh;
        if (i == this.zzg) {
            throw new zzakf("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        byte[] bArr = this.zzf;
        this.zzh = i + 1;
        return bArr[i];
    }

    @Override // com.google.android.gms.internal.nearby.zzaio
    public final int zzJ(byte[] bArr, int i, int i2) throws IOException {
        zzaio.zzQ(bArr, i, i2);
        if (i2 == 0) {
            return 0;
        }
        int iMin = Math.min(i2, this.zzg - this.zzh);
        if (iMin == 0) {
            return -1;
        }
        System.arraycopy(this.zzf, this.zzh, bArr, i, iMin);
        this.zzh += iMin;
        return iMin;
    }

    @Override // com.google.android.gms.internal.nearby.zzaio
    public final int zza() throws IOException {
        if (zzF()) {
            this.zzi = 0;
            return 0;
        }
        int iZzv = zzv();
        this.zzi = iZzv;
        if ((iZzv >>> 3) != 0) {
            return iZzv;
        }
        throw new zzakf("Protocol message contained an invalid tag (zero).");
    }

    @Override // com.google.android.gms.internal.nearby.zzaio
    public final void zzb(int i) throws zzakf {
        if (this.zzi != i) {
            throw new zzakf("Protocol message end-group tag did not match expected tag.");
        }
    }

    @Override // com.google.android.gms.internal.nearby.zzaio
    public final double zzd() throws IOException {
        return Double.longBitsToDouble(zzB());
    }

    @Override // com.google.android.gms.internal.nearby.zzaio
    public final float zze() throws IOException {
        return Float.intBitsToFloat(zzA());
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
        return zzw();
    }

    @Override // com.google.android.gms.internal.nearby.zzaio
    public final long zzi() throws IOException {
        return zzB();
    }

    @Override // com.google.android.gms.internal.nearby.zzaio
    public final int zzj() throws IOException {
        return zzA();
    }

    @Override // com.google.android.gms.internal.nearby.zzaio
    public final boolean zzk() throws IOException {
        return zzz() != 0;
    }

    @Override // com.google.android.gms.internal.nearby.zzaio
    public final String zzl() throws IOException {
        int iZzv = zzv();
        if (iZzv > 0) {
            int i = this.zzg;
            int i2 = this.zzh;
            if (iZzv <= i - i2) {
                String str = new String(this.zzf, i2, iZzv, StandardCharsets.UTF_8);
                this.zzh += iZzv;
                return str;
            }
        }
        if (iZzv == 0) {
            return "";
        }
        if (iZzv < 0) {
            throw new zzakf("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        throw new zzakf("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    @Override // com.google.android.gms.internal.nearby.zzaio
    public final String zzm() throws IOException {
        int iZzv = zzv();
        if (iZzv > 0) {
            int i = this.zzg;
            int i2 = this.zzh;
            if (iZzv <= i - i2) {
                String strZzd = zzaly.zzd(this.zzf, i2, iZzv);
                this.zzh += iZzv;
                return strZzd;
            }
        }
        if (iZzv == 0) {
            return "";
        }
        if (iZzv <= 0) {
            throw new zzakf("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        throw new zzakf("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    @Override // com.google.android.gms.internal.nearby.zzaio
    public final zzaik zzn() throws IOException {
        int iZzv = zzv();
        if (iZzv > 0) {
            int i = this.zzg;
            int i2 = this.zzh;
            if (iZzv <= i - i2) {
                zzaik zzaikVarZzk = zzaik.zzk(this.zzf, i2, iZzv, false);
                this.zzh += iZzv;
                return zzaikVarZzk;
            }
        }
        return iZzv == 0 ? zzaik.zza : zzaik.zzl(zzI(iZzv), false);
    }

    @Override // com.google.android.gms.internal.nearby.zzaio
    public final byte[] zzo() throws IOException {
        return zzI(zzv());
    }

    @Override // com.google.android.gms.internal.nearby.zzaio
    public final int zzp() throws IOException {
        return zzv();
    }

    @Override // com.google.android.gms.internal.nearby.zzaio
    public final int zzq() throws IOException {
        return zzw();
    }

    @Override // com.google.android.gms.internal.nearby.zzaio
    public final int zzr() throws IOException {
        return zzA();
    }

    @Override // com.google.android.gms.internal.nearby.zzaio
    public final long zzs() throws IOException {
        return zzB();
    }

    @Override // com.google.android.gms.internal.nearby.zzaio
    public final int zzt() throws IOException {
        int iZzv = zzv();
        return (-(iZzv & 1)) ^ (iZzv >>> 1);
    }

    @Override // com.google.android.gms.internal.nearby.zzaio
    public final long zzu() throws IOException {
        long jZzz = zzz();
        return (-(jZzz & 1)) ^ (jZzz >>> 1);
    }

    protected abstract int zzv() throws IOException;

    protected abstract int zzw() throws IOException;

    @Override // com.google.android.gms.internal.nearby.zzaio
    public final int zzx() throws IOException {
        return zzw();
    }

    /* JADX WARN: Code duplicated, block: B:32:0x0070 A[PHI: r4
      0x0070: PHI (r4v5 int) = (r4v4 int), (r4v9 int), (r4v11 int) binds: [B:17:0x0043, B:21:0x004f, B:25:0x005b] A[DONT_GENERATE, DONT_INLINE]] */
    protected final int zzy() throws IOException {
        try {
            int i = this.zzh;
            byte[] bArr = this.zzf;
            int i2 = i + 1;
            int i3 = bArr[i];
            if (i3 < 0) {
                int i4 = i + 2;
                int i5 = (bArr[i2] << 7) ^ i3;
                if (i5 < 0) {
                    i3 = (i5 == true ? 1 : 0) ^ RangingPosition.RSSI_UNKNOWN;
                } else {
                    int i6 = i + 3;
                    int i7 = (i5 == true ? 1 : 0) ^ (bArr[i4] << 14);
                    if (i7 >= 0) {
                        int i8 = i7 ^ 16256;
                        i2 = i6;
                        i3 = i8;
                    } else {
                        i4 = i + 4;
                        int i9 = i7 ^ (bArr[i6] << 21);
                        if (i9 < 0) {
                            i3 = i9 ^ (-2080896);
                        } else {
                            int i10 = i + 5;
                            int i11 = bArr[i4];
                            int i12 = (i9 ^ (i11 << 28)) ^ 266354560;
                            if (i11 < 0) {
                                i4 = i + 6;
                                if (bArr[i10] < 0) {
                                    i10 = i + 7;
                                    if (bArr[i4] < 0) {
                                        i4 = i + 8;
                                        if (bArr[i10] < 0) {
                                            i10 = i + 9;
                                            if (bArr[i4] < 0) {
                                                int i13 = i + 10;
                                                if (bArr[i10] < 0) {
                                                    throw new zzakf("CodedInputStream encountered a malformed varint.");
                                                }
                                                i3 = i12;
                                                i2 = i13;
                                            } else {
                                                int i14 = i10;
                                                i3 = i12;
                                                i2 = i14;
                                            }
                                        }
                                    } else {
                                        int i15 = i10;
                                        i3 = i12;
                                        i2 = i15;
                                    }
                                }
                                i3 = i12;
                            } else {
                                int i16 = i10;
                                i3 = i12;
                                i2 = i16;
                            }
                        }
                    }
                }
                i2 = i4;
            }
            this.zzh = i2;
            if (i2 <= this.zzg) {
                return i3;
            }
            throw new zzakf("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        } catch (zzakf e) {
            if (this.zzh > this.zzg) {
                throw new zzakf("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
            }
            throw e;
        } catch (IndexOutOfBoundsException unused) {
            throw new zzakf("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
    }

    @Override // com.google.android.gms.internal.nearby.zzaio
    public final int zzC(int i) throws zzakf {
        if (i < 0) {
            throw new zzakf("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        int i2 = this.zzh;
        int i3 = i2 + i;
        if (i3 < 0) {
            i3 = Integer.MAX_VALUE;
            if (i > Integer.MAX_VALUE - i2) {
                throw new zzakf("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit. If reading multiple messages, consider resetting the counter between each message using CodedInputStream.resetSizeCounter().");
            }
        }
        int i4 = this.zzj;
        if (i3 > i4) {
            throw new zzakf("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        zzR(i3);
        return i4;
    }

    @Override // com.google.android.gms.internal.nearby.zzaio
    public final void zzK(int i) throws IOException {
        if (i >= 0) {
            int i2 = this.zzg;
            int i3 = this.zzh;
            if (i <= i2 - i3) {
                this.zzh = i3 + i;
                return;
            }
        }
        if (i >= 0) {
            throw new zzakf("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        throw new zzakf("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    public final byte[] zzI(int i) throws IOException {
        if (i > 0) {
            int i2 = this.zzg;
            int i3 = this.zzh;
            if (i <= i2 - i3) {
                int i4 = i + i3;
                this.zzh = i4;
                return Arrays.copyOfRange(this.zzf, i3, i4);
            }
        }
        if (i > 0) {
            throw new zzakf("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        if (i == 0) {
            return zzaka.zza;
        }
        throw new zzakf("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    @Override // com.google.android.gms.internal.nearby.zzaio
    public final boolean zzc(int i) throws IOException {
        int i2 = i & 7;
        int i3 = 0;
        if (i2 == 0) {
            if (this.zzg - this.zzh < 10) {
                while (i3 < 10) {
                    if (zzH() < 0) {
                        i3++;
                    }
                }
                throw new zzakf("CodedInputStream encountered a malformed varint.");
            }
            while (i3 < 10) {
                byte[] bArr = this.zzf;
                int i4 = this.zzh;
                this.zzh = i4 + 1;
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
            zzK(zzv());
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
        int i = this.zzh;
        int i2 = this.zzg;
        long j4 = 0;
        if (i2 != i) {
            byte[] bArr = this.zzf;
            int i3 = i + 1;
            byte b = bArr[i];
            if (b >= 0) {
                this.zzh = i3;
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
                            j = (-2080896) ^ i9;
                            i4 = i8;
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
                                                    j = (-9151873028817141888L) ^ j8;
                                                }
                                            }
                                        }
                                    }
                                    j = j7 ^ j2;
                                    i4 = i10;
                                }
                                j = j3 ^ j6;
                            }
                        }
                    }
                    i4 = i6;
                }
                this.zzh = i4;
                return j;
            }
        }
        for (int i11 = 0; i11 < 64; i11 += 7) {
            byte bZzH = zzH();
            j4 |= ((long) (bZzH & ByteCompanionObject.MAX_VALUE)) << i11;
            if ((bZzH & ByteCompanionObject.MIN_VALUE) == 0) {
                return j4;
            }
        }
        throw new zzakf("CodedInputStream encountered a malformed varint.");
    }
}
