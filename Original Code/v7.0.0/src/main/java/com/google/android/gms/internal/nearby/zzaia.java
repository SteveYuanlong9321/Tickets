package com.google.android.gms.internal.nearby;

import androidx.compose.foundation.style.StylePropertiesKt;
import java.io.IOException;
import kotlin.UByte;
import kotlin.jvm.internal.ByteCompanionObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzaia {
    public static final /* synthetic */ int zza = 0;
    private static volatile int zzb = 100;

    static int zza(byte[] bArr, int i, zzahz zzahzVar) {
        int i2 = i + 1;
        byte b = bArr[i];
        if (b < 0) {
            return zzb(b, bArr, i2, zzahzVar);
        }
        zzahzVar.zza = b;
        return i2;
    }

    static int zzb(int i, byte[] bArr, int i2, zzahz zzahzVar) {
        byte b = bArr[i2];
        int i3 = i2 + 1;
        int i4 = i & 127;
        if (b >= 0) {
            zzahzVar.zza = i4 | (b << 7);
            return i3;
        }
        int i5 = i4 | ((b & ByteCompanionObject.MAX_VALUE) << 7);
        int i6 = i2 + 2;
        byte b2 = bArr[i3];
        if (b2 >= 0) {
            zzahzVar.zza = i5 | (b2 << StylePropertiesKt.TopId);
            return i6;
        }
        int i7 = i5 | ((b2 & ByteCompanionObject.MAX_VALUE) << 14);
        int i8 = i2 + 3;
        byte b3 = bArr[i6];
        if (b3 >= 0) {
            zzahzVar.zza = i7 | (b3 << StylePropertiesKt.AlphaId);
            return i8;
        }
        int i9 = i7 | ((b3 & ByteCompanionObject.MAX_VALUE) << 21);
        int i10 = i2 + 4;
        byte b4 = bArr[i8];
        if (b4 >= 0) {
            zzahzVar.zza = i9 | (b4 << StylePropertiesKt.RotationZId);
            return i10;
        }
        int i11 = i9 | ((b4 & ByteCompanionObject.MAX_VALUE) << 28);
        while (true) {
            int i12 = i10 + 1;
            if (bArr[i10] >= 0) {
                zzahzVar.zza = i11;
                return i12;
            }
            i10 = i12;
        }
    }

    static int zzc(byte[] bArr, int i, int i2, zzahz zzahzVar) throws zzakf {
        int iZza = zza(bArr, i, zzahzVar);
        int i3 = zzahzVar.zza;
        if (i3 < 0) {
            throw new zzakf("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        if (i3 <= i2 - iZza) {
            return iZza;
        }
        throw new zzakf("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    static int zzd(byte[] bArr, int i, zzahz zzahzVar) {
        long j = bArr[i];
        int i2 = i + 1;
        if (j >= 0) {
            zzahzVar.zzb = j;
            return i2;
        }
        int i3 = i + 2;
        byte b = bArr[i2];
        long j2 = (j & 127) | (((long) (b & ByteCompanionObject.MAX_VALUE)) << 7);
        int i4 = 7;
        while (b < 0) {
            int i5 = i3 + 1;
            byte b2 = bArr[i3];
            i4 += 7;
            j2 |= ((long) (b2 & ByteCompanionObject.MAX_VALUE)) << i4;
            b = b2;
            i3 = i5;
        }
        zzahzVar.zzb = j2;
        return i3;
    }

    static int zze(byte[] bArr, int i) {
        int i2 = bArr[i] & UByte.MAX_VALUE;
        int i3 = bArr[i + 1] & UByte.MAX_VALUE;
        int i4 = bArr[i + 2] & UByte.MAX_VALUE;
        return ((bArr[i + 3] & UByte.MAX_VALUE) << 24) | (i3 << 8) | i2 | (i4 << 16);
    }

    static long zzf(byte[] bArr, int i) {
        return (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48) | ((((long) bArr[i + 7]) & 255) << 56);
    }

    static int zzg(byte[] bArr, int i, zzahz zzahzVar) throws zzakf {
        int iZzc = zzc(bArr, i, bArr.length, zzahzVar);
        int i2 = zzahzVar.zza;
        if (i2 == 0) {
            zzahzVar.zzc = "";
            return iZzc;
        }
        zzahzVar.zzc = zzaly.zzd(bArr, iZzc, i2);
        return iZzc + i2;
    }

    static int zzh(byte[] bArr, int i, zzahz zzahzVar) throws zzakf {
        int iZzc = zzc(bArr, i, bArr.length, zzahzVar);
        int i2 = zzahzVar.zza;
        if (i2 == 0) {
            zzahzVar.zzc = zzaik.zza;
            return iZzc;
        }
        zzahzVar.zzc = zzaik.zzj(bArr, iZzc, i2);
        return iZzc + i2;
    }

    static int zzi(zzald zzaldVar, byte[] bArr, int i, int i2, zzahz zzahzVar) throws IOException {
        Object objZza = zzaldVar.zza();
        int iZzk = zzk(objZza, zzaldVar, bArr, i, i2, zzahzVar);
        zzaldVar.zzk(objZza);
        zzahzVar.zzc = objZza;
        return iZzk;
    }

    static int zzj(zzald zzaldVar, byte[] bArr, int i, int i2, int i3, zzahz zzahzVar) throws IOException {
        Object objZza = zzaldVar.zza();
        int iZzl = zzl(objZza, zzaldVar, bArr, i, i2, i3, zzahzVar);
        zzaldVar.zzk(objZza);
        zzahzVar.zzc = objZza;
        return iZzl;
    }

    static int zzk(Object obj, zzald zzaldVar, byte[] bArr, int i, int i2, zzahz zzahzVar) throws IOException {
        int iZzc = zzc(bArr, i, i2, zzahzVar);
        int i3 = zzahzVar.zza;
        int i4 = zzahzVar.zze + 1;
        zzahzVar.zze = i4;
        zzr(i4);
        int i5 = i3 + iZzc;
        zzaldVar.zzj(obj, bArr, iZzc, i5, zzahzVar);
        zzahzVar.zze--;
        zzahzVar.zzc = obj;
        return i5;
    }

    static int zzl(Object obj, zzald zzaldVar, byte[] bArr, int i, int i2, int i3, zzahz zzahzVar) throws IOException {
        int i4 = zzahzVar.zze + 1;
        zzahzVar.zze = i4;
        zzr(i4);
        int iZzi = ((zzakv) zzaldVar).zzi(obj, bArr, i, i2, i3, zzahzVar);
        zzahzVar.zze--;
        zzahzVar.zzc = obj;
        return iZzi;
    }

    static int zzm(int i, byte[] bArr, int i2, int i3, zzajz zzajzVar, zzahz zzahzVar) {
        zzajp zzajpVar = (zzajp) zzajzVar;
        int iZza = zza(bArr, i2, zzahzVar);
        zzajpVar.zzh(zzahzVar.zza);
        while (iZza < i3) {
            int iZza2 = zza(bArr, iZza, zzahzVar);
            if (i != zzahzVar.zza) {
                break;
            }
            iZza = zza(bArr, iZza2, zzahzVar);
            zzajpVar.zzh(zzahzVar.zza);
        }
        return iZza;
    }

    static int zzn(byte[] bArr, int i, zzajz zzajzVar, zzahz zzahzVar) throws IOException {
        zzajp zzajpVar = (zzajp) zzajzVar;
        int iZzc = zzc(bArr, i, bArr.length, zzahzVar);
        int i2 = zzahzVar.zza + iZzc;
        while (iZzc < i2) {
            iZzc = zza(bArr, iZzc, zzahzVar);
            zzajpVar.zzh(zzahzVar.zza);
        }
        if (iZzc == i2) {
            return iZzc;
        }
        throw new zzakf("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    static int zzo(zzald zzaldVar, int i, byte[] bArr, int i2, int i3, zzajz zzajzVar, zzahz zzahzVar) throws IOException {
        int iZzi = zzi(zzaldVar, bArr, i2, i3, zzahzVar);
        zzajzVar.add(zzahzVar.zzc);
        while (iZzi < i3) {
            int iZza = zza(bArr, iZzi, zzahzVar);
            if (i != zzahzVar.zza) {
                break;
            }
            iZzi = zzi(zzaldVar, bArr, iZza, i3, zzahzVar);
            zzajzVar.add(zzahzVar.zzc);
        }
        return iZzi;
    }

    static int zzp(int i, byte[] bArr, int i2, int i3, zzaln zzalnVar, zzahz zzahzVar) throws zzakf {
        if ((i >>> 3) == 0) {
            throw new zzakf("Protocol message contained an invalid tag (zero).");
        }
        int i4 = i & 7;
        if (i4 == 0) {
            int iZzd = zzd(bArr, i2, zzahzVar);
            zzalnVar.zzk(i, Long.valueOf(zzahzVar.zzb));
            return iZzd;
        }
        if (i4 == 1) {
            zzalnVar.zzk(i, Long.valueOf(zzf(bArr, i2)));
            return i2 + 8;
        }
        if (i4 == 2) {
            int iZzc = zzc(bArr, i2, bArr.length, zzahzVar);
            int i5 = zzahzVar.zza;
            if (i5 == 0) {
                zzalnVar.zzk(i, zzaik.zza);
            } else {
                zzalnVar.zzk(i, zzaik.zzj(bArr, iZzc, i5));
            }
            return iZzc + i5;
        }
        if (i4 != 3) {
            if (i4 != 5) {
                throw new zzakf("Protocol message contained an invalid tag (zero).");
            }
            zzalnVar.zzk(i, Integer.valueOf(zze(bArr, i2)));
            return i2 + 4;
        }
        int i6 = (i & (-8)) | 4;
        zzaln zzalnVarZzb = zzaln.zzb();
        int i7 = zzahzVar.zze + 1;
        zzahzVar.zze = i7;
        zzr(i7);
        int i8 = 0;
        while (i2 < i3) {
            int iZza = zza(bArr, i2, zzahzVar);
            int i9 = zzahzVar.zza;
            if (i9 == i6) {
                i8 = i9;
                i2 = iZza;
                break;
            }
            i2 = zzp(i9, bArr, iZza, i3, zzalnVarZzb, zzahzVar);
            i8 = i9;
        }
        zzahzVar.zze--;
        if (i2 > i3 || i8 != i6) {
            throw new zzakf("Failed to parse the message.");
        }
        zzalnVar.zzk(i, zzalnVarZzb);
        return i2;
    }

    static int zzq(int i, byte[] bArr, int i2, int i3, zzahz zzahzVar) throws zzakf {
        if ((i >>> 3) == 0) {
            throw new zzakf("Protocol message contained an invalid tag (zero).");
        }
        int i4 = i & 7;
        if (i4 == 0) {
            return zzd(bArr, i2, zzahzVar);
        }
        if (i4 == 1) {
            return i2 + 8;
        }
        if (i4 == 2) {
            return zzc(bArr, i2, bArr.length, zzahzVar) + zzahzVar.zza;
        }
        if (i4 != 3) {
            if (i4 == 5) {
                return i2 + 4;
            }
            throw new zzakf("Protocol message contained an invalid tag (zero).");
        }
        int i5 = (i & (-8)) | 4;
        int i6 = zzahzVar.zze + 1;
        zzahzVar.zze = i6;
        zzr(i6);
        int i7 = 0;
        while (i2 < i3) {
            i2 = zza(bArr, i2, zzahzVar);
            i7 = zzahzVar.zza;
            if (i7 == i5) {
                break;
            }
            i2 = zzq(i7, bArr, i2, i3, zzahzVar);
        }
        zzahzVar.zze--;
        if (i2 > i3 || i7 != i5) {
            throw new zzakf("Failed to parse the message.");
        }
        return i2;
    }

    private static void zzr(int i) throws zzakf {
        if (i >= zzb) {
            throw new zzakf("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");
        }
    }
}
