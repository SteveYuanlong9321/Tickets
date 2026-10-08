package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

import androidx.compose.foundation.style.StylePropertiesKt;
import java.io.IOException;
import kotlin.UByte;
import kotlin.jvm.internal.ByteCompanionObject;

/* JADX INFO: compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zbsr {
    public static final /* synthetic */ int zba = 0;
    private static volatile int zbb = 100;

    static int zba(byte[] bArr, int i, zbsq zbsqVar) throws zbuq {
        int iZbk = zbk(bArr, i, zbsqVar);
        int i2 = zbsqVar.zba;
        if (i2 < 0) {
            throw new zbuq("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        if (i2 > bArr.length - iZbk) {
            throw new zbuq("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        if (i2 == 0) {
            zbsqVar.zbc = zbtc.zbb;
            return iZbk;
        }
        zbsqVar.zbc = zbtc.zbj(bArr, iZbk, i2);
        return iZbk + i2;
    }

    static int zbb(int i, byte[] bArr, int i2, int i3, zbub zbubVar, zbud zbudVar, zbwl zbwlVar, zbsq zbsqVar) throws IOException {
        zbtu zbtuVar = zbubVar.zbb;
        zbww zbwwVar = zbudVar.zbb.zbb;
        Object objValueOf = null;
        if (zbwwVar == zbww.ENUM) {
            zbk(bArr, i2, zbsqVar);
            throw null;
        }
        switch (zbwwVar) {
            case DOUBLE:
                i2 += 8;
                objValueOf = Double.valueOf(Double.longBitsToDouble(zbr(bArr, i2)));
                break;
            case FLOAT:
                i2 += 4;
                objValueOf = Float.valueOf(Float.intBitsToFloat(zbc(bArr, i2)));
                break;
            case INT64:
            case UINT64:
                i2 = zbn(bArr, i2, zbsqVar);
                objValueOf = Long.valueOf(zbsqVar.zbb);
                break;
            case INT32:
            case UINT32:
                i2 = zbk(bArr, i2, zbsqVar);
                objValueOf = Integer.valueOf(zbsqVar.zba);
                break;
            case FIXED64:
            case SFIXED64:
                i2 += 8;
                objValueOf = Long.valueOf(zbr(bArr, i2));
                break;
            case FIXED32:
            case SFIXED32:
                i2 += 4;
                objValueOf = Integer.valueOf(zbc(bArr, i2));
                break;
            case BOOL:
                i2 = zbn(bArr, i2, zbsqVar);
                objValueOf = Boolean.valueOf(zbsqVar.zbb != 0);
                break;
            case STRING:
                i2 = zbh(bArr, i2, zbsqVar);
                objValueOf = zbsqVar.zbc;
                break;
            case GROUP:
                int i4 = ((i >>> 3) << 3) | 4;
                zbvx zbvxVarZbb = zbvu.zba().zbb(zbudVar.zba.getClass());
                Object objZbf = zbtuVar.zbf(zbudVar.zbb);
                if (objZbf == null) {
                    objZbf = zbvxVarZbb.zbe();
                    zbtuVar.zbj(zbudVar.zbb, objZbf);
                }
                return zbo(objZbf, zbvxVarZbb, bArr, i2, i3, i4, zbsqVar);
            case MESSAGE:
                zbvx zbvxVarZbb2 = zbvu.zba().zbb(zbudVar.zba.getClass());
                Object objZbf2 = zbtuVar.zbf(zbudVar.zbb);
                if (objZbf2 == null) {
                    objZbf2 = zbvxVarZbb2.zbe();
                    zbtuVar.zbj(zbudVar.zbb, objZbf2);
                }
                return zbp(objZbf2, zbvxVarZbb2, bArr, i2, i3, zbsqVar);
            case BYTES:
                i2 = zba(bArr, i2, zbsqVar);
                objValueOf = zbsqVar.zbc;
                break;
            case ENUM:
                throw new IllegalStateException("Shouldn't reach here.");
            case SINT32:
                i2 = zbk(bArr, i2, zbsqVar);
                objValueOf = Integer.valueOf(zbtg.zbb(zbsqVar.zba));
                break;
            case SINT64:
                i2 = zbn(bArr, i2, zbsqVar);
                objValueOf = Long.valueOf(zbtg.zbc(zbsqVar.zbb));
                break;
        }
        zbtuVar.zbj(zbudVar.zbb, objValueOf);
        return i2;
    }

    static int zbc(byte[] bArr, int i) {
        int i2 = bArr[i] & UByte.MAX_VALUE;
        int i3 = bArr[i + 1] & UByte.MAX_VALUE;
        int i4 = bArr[i + 2] & UByte.MAX_VALUE;
        return ((bArr[i + 3] & UByte.MAX_VALUE) << 24) | (i3 << 8) | i2 | (i4 << 16);
    }

    static int zbd(zbvx zbvxVar, byte[] bArr, int i, int i2, int i3, zbsq zbsqVar) throws IOException {
        Object objZbe = zbvxVar.zbe();
        int iZbo = zbo(objZbe, zbvxVar, bArr, i, i2, i3, zbsqVar);
        zbvxVar.zbf(objZbe);
        zbsqVar.zbc = objZbe;
        return iZbo;
    }

    static int zbe(zbvx zbvxVar, byte[] bArr, int i, int i2, zbsq zbsqVar) throws IOException {
        Object objZbe = zbvxVar.zbe();
        int iZbp = zbp(objZbe, zbvxVar, bArr, i, i2, zbsqVar);
        zbvxVar.zbf(objZbe);
        zbsqVar.zbc = objZbe;
        return iZbp;
    }

    static int zbf(zbvx zbvxVar, int i, byte[] bArr, int i2, int i3, zbun zbunVar, zbsq zbsqVar) throws IOException {
        int iZbe = zbe(zbvxVar, bArr, i2, i3, zbsqVar);
        zbunVar.add(zbsqVar.zbc);
        while (iZbe < i3) {
            int iZbk = zbk(bArr, iZbe, zbsqVar);
            if (i != zbsqVar.zba) {
                break;
            }
            iZbe = zbe(zbvxVar, bArr, iZbk, i3, zbsqVar);
            zbunVar.add(zbsqVar.zbc);
        }
        return iZbe;
    }

    static int zbg(byte[] bArr, int i, zbun zbunVar, zbsq zbsqVar) throws IOException {
        zbug zbugVar = (zbug) zbunVar;
        int iZbk = zbk(bArr, i, zbsqVar);
        int i2 = zbsqVar.zba + iZbk;
        while (iZbk < i2) {
            iZbk = zbk(bArr, iZbk, zbsqVar);
            zbugVar.zbg(zbsqVar.zba);
        }
        if (iZbk == i2) {
            return iZbk;
        }
        throw new zbuq("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    static int zbh(byte[] bArr, int i, zbsq zbsqVar) throws zbuq {
        int iZbk = zbk(bArr, i, zbsqVar);
        int i2 = zbsqVar.zba;
        if (i2 < 0) {
            throw new zbuq("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        if (i2 == 0) {
            zbsqVar.zbc = "";
            return iZbk;
        }
        zbsqVar.zbc = new String(bArr, iZbk, i2, zbuo.zba);
        return iZbk + i2;
    }

    static int zbi(byte[] bArr, int i, zbsq zbsqVar) throws zbuq {
        int i2;
        int iZbk = zbk(bArr, i, zbsqVar);
        int i3 = zbsqVar.zba;
        if (i3 < 0) {
            throw new zbuq("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        if (i3 == 0) {
            zbsqVar.zbc = "";
            return iZbk;
        }
        int i4 = zbwv.zba;
        int length = bArr.length;
        if ((((length - iZbk) - i3) | iZbk | i3) < 0) {
            throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", Integer.valueOf(length), Integer.valueOf(iZbk), Integer.valueOf(i3)));
        }
        int i5 = iZbk + i3;
        char[] cArr = new char[i3];
        int i6 = 0;
        while (iZbk < i5) {
            byte b = bArr[iZbk];
            if (!zbwt.zbd(b)) {
                break;
            }
            iZbk++;
            cArr[i6] = (char) b;
            i6++;
        }
        int i7 = i6;
        while (iZbk < i5) {
            int i8 = iZbk + 1;
            byte b2 = bArr[iZbk];
            if (zbwt.zbd(b2)) {
                cArr[i7] = (char) b2;
                i7++;
                iZbk = i8;
                while (iZbk < i5) {
                    byte b3 = bArr[iZbk];
                    if (!zbwt.zbd(b3)) {
                        break;
                    }
                    iZbk++;
                    cArr[i7] = (char) b3;
                    i7++;
                }
            } else {
                if (b2 < -32) {
                    if (i8 >= i5) {
                        throw new zbuq("Protocol message had invalid UTF-8.");
                    }
                    i2 = i7 + 1;
                    iZbk += 2;
                    zbwt.zbc(b2, bArr[i8], cArr, i7);
                } else if (b2 < -16) {
                    if (i8 >= i5 - 1) {
                        throw new zbuq("Protocol message had invalid UTF-8.");
                    }
                    i2 = i7 + 1;
                    int i9 = iZbk + 2;
                    iZbk += 3;
                    zbwt.zbb(b2, bArr[i8], bArr[i9], cArr, i7);
                } else {
                    if (i8 >= i5 - 2) {
                        throw new zbuq("Protocol message had invalid UTF-8.");
                    }
                    byte b4 = bArr[i8];
                    int i10 = iZbk + 3;
                    byte b5 = bArr[iZbk + 2];
                    iZbk += 4;
                    zbwt.zba(b2, b4, b5, bArr[i10], cArr, i7);
                    i7 += 2;
                }
                i7 = i2;
            }
        }
        zbsqVar.zbc = new String(cArr, 0, i7);
        return i5;
    }

    static int zbj(int i, byte[] bArr, int i2, int i3, zbwm zbwmVar, zbsq zbsqVar) throws zbuq {
        if ((i >>> 3) == 0) {
            throw new zbuq("Protocol message contained an invalid tag (zero).");
        }
        int i4 = i & 7;
        if (i4 == 0) {
            int iZbn = zbn(bArr, i2, zbsqVar);
            zbwmVar.zbj(i, Long.valueOf(zbsqVar.zbb));
            return iZbn;
        }
        if (i4 == 1) {
            zbwmVar.zbj(i, Long.valueOf(zbr(bArr, i2)));
            return i2 + 8;
        }
        if (i4 == 2) {
            int iZbk = zbk(bArr, i2, zbsqVar);
            int i5 = zbsqVar.zba;
            if (i5 < 0) {
                throw new zbuq("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
            }
            if (i5 > bArr.length - iZbk) {
                throw new zbuq("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
            }
            if (i5 == 0) {
                zbwmVar.zbj(i, zbtc.zbb);
            } else {
                zbwmVar.zbj(i, zbtc.zbj(bArr, iZbk, i5));
            }
            return iZbk + i5;
        }
        if (i4 != 3) {
            if (i4 != 5) {
                throw new zbuq("Protocol message contained an invalid tag (zero).");
            }
            zbwmVar.zbj(i, Integer.valueOf(zbc(bArr, i2)));
            return i2 + 4;
        }
        int i6 = (i & (-8)) | 4;
        zbwm zbwmVarZbf = zbwm.zbf();
        int i7 = zbsqVar.zbe + 1;
        zbsqVar.zbe = i7;
        zbs(i7);
        int i8 = 0;
        while (i2 < i3) {
            int iZbk2 = zbk(bArr, i2, zbsqVar);
            int i9 = zbsqVar.zba;
            if (i9 == i6) {
                i8 = i9;
                i2 = iZbk2;
                break;
            }
            i2 = zbj(i9, bArr, iZbk2, i3, zbwmVarZbf, zbsqVar);
            i8 = i9;
        }
        zbsqVar.zbe--;
        if (i2 > i3 || i8 != i6) {
            throw new zbuq("Failed to parse the message.");
        }
        zbwmVar.zbj(i, zbwmVarZbf);
        return i2;
    }

    static int zbk(byte[] bArr, int i, zbsq zbsqVar) {
        int i2 = i + 1;
        byte b = bArr[i];
        if (b < 0) {
            return zbl(b, bArr, i2, zbsqVar);
        }
        zbsqVar.zba = b;
        return i2;
    }

    static int zbl(int i, byte[] bArr, int i2, zbsq zbsqVar) {
        byte b = bArr[i2];
        int i3 = i2 + 1;
        int i4 = i & 127;
        if (b >= 0) {
            zbsqVar.zba = i4 | (b << 7);
            return i3;
        }
        int i5 = i4 | ((b & ByteCompanionObject.MAX_VALUE) << 7);
        int i6 = i2 + 2;
        byte b2 = bArr[i3];
        if (b2 >= 0) {
            zbsqVar.zba = i5 | (b2 << StylePropertiesKt.TopId);
            return i6;
        }
        int i7 = i5 | ((b2 & ByteCompanionObject.MAX_VALUE) << 14);
        int i8 = i2 + 3;
        byte b3 = bArr[i6];
        if (b3 >= 0) {
            zbsqVar.zba = i7 | (b3 << StylePropertiesKt.AlphaId);
            return i8;
        }
        int i9 = i7 | ((b3 & ByteCompanionObject.MAX_VALUE) << 21);
        int i10 = i2 + 4;
        byte b4 = bArr[i8];
        if (b4 >= 0) {
            zbsqVar.zba = i9 | (b4 << StylePropertiesKt.RotationZId);
            return i10;
        }
        int i11 = i9 | ((b4 & ByteCompanionObject.MAX_VALUE) << 28);
        while (true) {
            int i12 = i10 + 1;
            if (bArr[i10] >= 0) {
                zbsqVar.zba = i11;
                return i12;
            }
            i10 = i12;
        }
    }

    static int zbm(int i, byte[] bArr, int i2, int i3, zbun zbunVar, zbsq zbsqVar) {
        zbug zbugVar = (zbug) zbunVar;
        int iZbk = zbk(bArr, i2, zbsqVar);
        zbugVar.zbg(zbsqVar.zba);
        while (iZbk < i3) {
            int iZbk2 = zbk(bArr, iZbk, zbsqVar);
            if (i != zbsqVar.zba) {
                break;
            }
            iZbk = zbk(bArr, iZbk2, zbsqVar);
            zbugVar.zbg(zbsqVar.zba);
        }
        return iZbk;
    }

    static int zbn(byte[] bArr, int i, zbsq zbsqVar) {
        long j = bArr[i];
        int i2 = i + 1;
        if (j >= 0) {
            zbsqVar.zbb = j;
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
        zbsqVar.zbb = j2;
        return i3;
    }

    static int zbo(Object obj, zbvx zbvxVar, byte[] bArr, int i, int i2, int i3, zbsq zbsqVar) throws IOException {
        int i4 = zbsqVar.zbe + 1;
        zbsqVar.zbe = i4;
        zbs(i4);
        int iZbc = ((zbvp) zbvxVar).zbc(obj, bArr, i, i2, i3, zbsqVar);
        zbsqVar.zbe--;
        zbsqVar.zbc = obj;
        return iZbc;
    }

    static int zbp(Object obj, zbvx zbvxVar, byte[] bArr, int i, int i2, zbsq zbsqVar) throws IOException {
        int iZbl = i + 1;
        int i3 = bArr[i];
        if (i3 < 0) {
            iZbl = zbl(i3, bArr, iZbl, zbsqVar);
            i3 = zbsqVar.zba;
        }
        int i4 = iZbl;
        if (i3 < 0 || i3 > i2 - i4) {
            throw new zbuq("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        int i5 = zbsqVar.zbe + 1;
        zbsqVar.zbe = i5;
        zbs(i5);
        int i6 = i4 + i3;
        zbvxVar.zbh(obj, bArr, i4, i6, zbsqVar);
        zbsqVar.zbe--;
        zbsqVar.zbc = obj;
        return i6;
    }

    static int zbq(int i, byte[] bArr, int i2, int i3, zbsq zbsqVar) throws zbuq {
        if ((i >>> 3) == 0) {
            throw new zbuq("Protocol message contained an invalid tag (zero).");
        }
        int i4 = i & 7;
        if (i4 == 0) {
            return zbn(bArr, i2, zbsqVar);
        }
        if (i4 == 1) {
            return i2 + 8;
        }
        if (i4 == 2) {
            return zbk(bArr, i2, zbsqVar) + zbsqVar.zba;
        }
        if (i4 != 3) {
            if (i4 == 5) {
                return i2 + 4;
            }
            throw new zbuq("Protocol message contained an invalid tag (zero).");
        }
        int i5 = (i & (-8)) | 4;
        int i6 = 0;
        while (i2 < i3) {
            i2 = zbk(bArr, i2, zbsqVar);
            i6 = zbsqVar.zba;
            if (i6 == i5) {
                break;
            }
            i2 = zbq(i6, bArr, i2, i3, zbsqVar);
        }
        if (i2 > i3 || i6 != i5) {
            throw new zbuq("Failed to parse the message.");
        }
        return i2;
    }

    static long zbr(byte[] bArr, int i) {
        return (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48) | ((((long) bArr[i + 7]) & 255) << 56);
    }

    private static void zbs(int i) throws zbuq {
        if (i >= zbb) {
            throw new zbuq("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");
        }
    }
}
