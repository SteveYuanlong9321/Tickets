package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

import androidx.compose.foundation.style.StylePropertiesKt;
import androidx.compose.runtime.composer.linkbuffer.GroupFlagsKt;
import androidx.compose.ui.spatial.RectListKt;
import androidx.core.view.MotionEventCompat;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zbvp<T> implements zbvx<T> {
    private static final int[] zba = new int[0];
    private static final Unsafe zbb = zbws.zbg();
    private final int[] zbc;
    private final Object[] zbd;
    private final int zbe;
    private final int zbf;
    private final zbvm zbg;
    private final boolean zbh;
    private final int[] zbi;
    private final int zbj;
    private final int zbk;
    private final zbwl zbl;
    private final zbtq zbm;

    private zbvp(int[] iArr, Object[] objArr, int i, int i2, zbvm zbvmVar, boolean z, int[] iArr2, int i3, int i4, zbvs zbvsVar, zbuy zbuyVar, zbwl zbwlVar, zbtq zbtqVar, zbvh zbvhVar) {
        this.zbc = iArr;
        this.zbd = objArr;
        this.zbe = i;
        this.zbf = i2;
        boolean z2 = false;
        if (zbtqVar != null && (zbvmVar instanceof zbub)) {
            z2 = true;
        }
        this.zbh = z2;
        this.zbi = iArr2;
        this.zbj = i3;
        this.zbk = i4;
        this.zbl = zbwlVar;
        this.zbm = zbtqVar;
        this.zbg = zbvmVar;
    }

    private static void zbA(Object obj) {
        if (!zbL(obj)) {
            throw new IllegalArgumentException("Mutating immutable message: ".concat(String.valueOf(String.valueOf(obj))));
        }
    }

    private final void zbB(Object obj, Object obj2, int i) {
        if (zbI(obj2, i)) {
            int iZbs = zbs(i) & 1048575;
            Unsafe unsafe = zbb;
            long j = iZbs;
            Object object = unsafe.getObject(obj2, j);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + this.zbc[i] + " is present but null: " + obj2.toString());
            }
            zbvx zbvxVarZbv = zbv(i);
            if (!zbI(obj, i)) {
                if (zbL(object)) {
                    Object objZbe = zbvxVarZbv.zbe();
                    zbvxVarZbv.zbg(objZbe, object);
                    unsafe.putObject(obj, j, objZbe);
                } else {
                    unsafe.putObject(obj, j, object);
                }
                zbD(obj, i);
                return;
            }
            Object object2 = unsafe.getObject(obj, j);
            if (!zbL(object2)) {
                Object objZbe2 = zbvxVarZbv.zbe();
                zbvxVarZbv.zbg(objZbe2, object2);
                unsafe.putObject(obj, j, objZbe2);
                object2 = objZbe2;
            }
            zbvxVarZbv.zbg(object2, object);
        }
    }

    private final void zbC(Object obj, Object obj2, int i) {
        int i2 = this.zbc[i];
        if (zbM(obj2, i2, i)) {
            int iZbs = zbs(i) & 1048575;
            Unsafe unsafe = zbb;
            long j = iZbs;
            Object object = unsafe.getObject(obj2, j);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + this.zbc[i] + " is present but null: " + obj2.toString());
            }
            zbvx zbvxVarZbv = zbv(i);
            if (!zbM(obj, i2, i)) {
                if (zbL(object)) {
                    Object objZbe = zbvxVarZbv.zbe();
                    zbvxVarZbv.zbg(objZbe, object);
                    unsafe.putObject(obj, j, objZbe);
                } else {
                    unsafe.putObject(obj, j, object);
                }
                zbE(obj, i2, i);
                return;
            }
            Object object2 = unsafe.getObject(obj, j);
            if (!zbL(object2)) {
                Object objZbe2 = zbvxVarZbv.zbe();
                zbvxVarZbv.zbg(objZbe2, object2);
                unsafe.putObject(obj, j, objZbe2);
                object2 = objZbe2;
            }
            zbvxVarZbv.zbg(object2, object);
        }
    }

    private final void zbD(Object obj, int i) {
        int iZbp = zbp(i);
        long j = 1048575 & iZbp;
        if (j == 1048575) {
            return;
        }
        zbws.zbq(obj, j, (1 << (iZbp >>> 20)) | zbws.zbc(obj, j));
    }

    private final void zbE(Object obj, int i, int i2) {
        zbws.zbq(obj, zbp(i2) & 1048575, i);
    }

    private final void zbF(Object obj, int i, Object obj2) {
        zbb.putObject(obj, zbs(i) & 1048575, obj2);
        zbD(obj, i);
    }

    private final void zbG(Object obj, int i, int i2, Object obj2) {
        zbb.putObject(obj, zbs(i2) & 1048575, obj2);
        zbE(obj, i, i2);
    }

    private final boolean zbH(Object obj, Object obj2, int i) {
        return zbI(obj, i) == zbI(obj2, i);
    }

    private final boolean zbI(Object obj, int i) {
        int iZbp = zbp(i);
        long j = iZbp & 1048575;
        if (j != 1048575) {
            return ((1 << (iZbp >>> 20)) & zbws.zbc(obj, j)) != 0;
        }
        int iZbs = zbs(i);
        long j2 = iZbs & 1048575;
        switch (zbr(iZbs)) {
            case 0:
                return Double.doubleToRawLongBits(zbws.zba(obj, j2)) != 0;
            case 1:
                return Float.floatToRawIntBits(zbws.zbb(obj, j2)) != 0;
            case 2:
                return zbws.zbd(obj, j2) != 0;
            case 3:
                return zbws.zbd(obj, j2) != 0;
            case 4:
                return zbws.zbc(obj, j2) != 0;
            case 5:
                return zbws.zbd(obj, j2) != 0;
            case 6:
                return zbws.zbc(obj, j2) != 0;
            case 7:
                return zbws.zbw(obj, j2);
            case 8:
                Object objZbf = zbws.zbf(obj, j2);
                if (objZbf instanceof String) {
                    return !((String) objZbf).isEmpty();
                }
                if (objZbf instanceof zbtc) {
                    return !zbtc.zbb.equals(objZbf);
                }
                throw new IllegalArgumentException();
            case 9:
                return zbws.zbf(obj, j2) != null;
            case 10:
                return !zbtc.zbb.equals(zbws.zbf(obj, j2));
            case 11:
                return zbws.zbc(obj, j2) != 0;
            case 12:
                return zbws.zbc(obj, j2) != 0;
            case 13:
                return zbws.zbc(obj, j2) != 0;
            case 14:
                return zbws.zbd(obj, j2) != 0;
            case 15:
                return zbws.zbc(obj, j2) != 0;
            case 16:
                return zbws.zbd(obj, j2) != 0;
            case 17:
                return zbws.zbf(obj, j2) != null;
            default:
                throw new IllegalArgumentException();
        }
    }

    private final boolean zbJ(Object obj, int i, int i2, int i3, int i4) {
        if (i2 == 1048575) {
            return zbI(obj, i);
        }
        return (i3 & i4) != 0;
    }

    private static boolean zbK(Object obj, int i, zbvx zbvxVar) {
        return zbvxVar.zbk(zbws.zbf(obj, i & 1048575));
    }

    private static boolean zbL(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof zbuf) {
            return ((zbuf) obj).zbG();
        }
        return true;
    }

    private final boolean zbM(Object obj, int i, int i2) {
        return zbws.zbc(obj, (long) (zbp(i2) & 1048575)) == i;
    }

    private static boolean zbN(Object obj, long j) {
        return ((Boolean) zbws.zbf(obj, j)).booleanValue();
    }

    private static final int zbO(byte[] bArr, int i, int i2, zbww zbwwVar, Class cls, zbsq zbsqVar) throws IOException {
        zbww zbwwVar2 = zbww.DOUBLE;
        switch (zbwwVar) {
            case DOUBLE:
                int i3 = i + 8;
                zbsqVar.zbc = Double.valueOf(Double.longBitsToDouble(zbsr.zbr(bArr, i)));
                return i3;
            case FLOAT:
                int i4 = i + 4;
                zbsqVar.zbc = Float.valueOf(Float.intBitsToFloat(zbsr.zbc(bArr, i)));
                return i4;
            case INT64:
            case UINT64:
                int iZbn = zbsr.zbn(bArr, i, zbsqVar);
                zbsqVar.zbc = Long.valueOf(zbsqVar.zbb);
                return iZbn;
            case INT32:
            case UINT32:
            case ENUM:
                int iZbk = zbsr.zbk(bArr, i, zbsqVar);
                zbsqVar.zbc = Integer.valueOf(zbsqVar.zba);
                return iZbk;
            case FIXED64:
            case SFIXED64:
                int i5 = i + 8;
                zbsqVar.zbc = Long.valueOf(zbsr.zbr(bArr, i));
                return i5;
            case FIXED32:
            case SFIXED32:
                int i6 = i + 4;
                zbsqVar.zbc = Integer.valueOf(zbsr.zbc(bArr, i));
                return i6;
            case BOOL:
                int iZbn2 = zbsr.zbn(bArr, i, zbsqVar);
                zbsqVar.zbc = Boolean.valueOf(zbsqVar.zbb != 0);
                return iZbn2;
            case STRING:
                return zbsr.zbi(bArr, i, zbsqVar);
            case GROUP:
            default:
                throw new RuntimeException("unsupported field type.");
            case MESSAGE:
                return zbsr.zbe(zbvu.zba().zbb(cls), bArr, i, i2, zbsqVar);
            case BYTES:
                return zbsr.zba(bArr, i, zbsqVar);
            case SINT32:
                int iZbk2 = zbsr.zbk(bArr, i, zbsqVar);
                zbsqVar.zbc = Integer.valueOf(zbtg.zbb(zbsqVar.zba));
                return iZbk2;
            case SINT64:
                int iZbn3 = zbsr.zbn(bArr, i, zbsqVar);
                zbsqVar.zbc = Long.valueOf(zbtg.zbc(zbsqVar.zbb));
                return iZbn3;
        }
    }

    private static final void zbP(int i, Object obj, zbwy zbwyVar) throws IOException {
        if (obj instanceof String) {
            zbwyVar.zbH(i, (String) obj);
        } else {
            zbwyVar.zbd(i, (zbtc) obj);
        }
    }

    static zbwm zbd(Object obj) {
        zbuf zbufVar = (zbuf) obj;
        zbwm zbwmVar = zbufVar.zbc;
        if (zbwmVar != zbwm.zbc()) {
            return zbwmVar;
        }
        zbwm zbwmVarZbf = zbwm.zbf();
        zbufVar.zbc = zbwmVarZbf;
        return zbwmVarZbf;
    }

    /* JADX WARN: Code duplicated, block: B:126:0x026d  */
    /* JADX WARN: Code duplicated, block: B:127:0x0270  */
    /* JADX WARN: Code duplicated, block: B:130:0x028a  */
    /* JADX WARN: Code duplicated, block: B:131:0x028d  */
    /* JADX WARN: Code duplicated, block: B:170:0x034e  */
    /* JADX WARN: Code duplicated, block: B:185:0x03a3  */
    /* JADX WARN: Code duplicated, block: B:188:0x03ad  */
    static zbvp zbl(Class cls, zbvj zbvjVar, zbvs zbvsVar, zbuy zbuyVar, zbwl zbwlVar, zbtq zbtqVar, zbvh zbvhVar) {
        int i;
        int iCharAt;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int[] iArr;
        int i7;
        int i8;
        char cCharAt;
        int i9;
        char cCharAt2;
        int i10;
        char cCharAt3;
        int i11;
        char cCharAt4;
        int i12;
        char cCharAt5;
        int i13;
        char cCharAt6;
        int i14;
        char cCharAt7;
        int i15;
        char cCharAt8;
        int i16;
        int i17;
        int i18;
        int iObjectFieldOffset;
        char c;
        int iObjectFieldOffset2;
        int i19;
        int i20;
        int i21;
        Field fieldZbz;
        char cCharAt9;
        int i22;
        int i23;
        int i24;
        int i25;
        int i26;
        Object obj;
        Field fieldZbz2;
        int i27;
        Object obj2;
        Field fieldZbz3;
        int i28;
        char cCharAt10;
        int i29;
        char cCharAt11;
        int i30;
        char cCharAt12;
        int i31;
        char cCharAt13;
        if (!(zbvjVar instanceof zbvw)) {
            throw null;
        }
        zbvw zbvwVar = (zbvw) zbvjVar;
        String strZbd = zbvwVar.zbd();
        int length = strZbd.length();
        char c2 = 55296;
        if (strZbd.charAt(0) >= 55296) {
            int i32 = 1;
            while (true) {
                i = i32 + 1;
                if (strZbd.charAt(i32) < 55296) {
                    break;
                }
                i32 = i;
            }
        } else {
            i = 1;
        }
        int i33 = i + 1;
        int iCharAt2 = strZbd.charAt(i);
        if (iCharAt2 >= 55296) {
            int i34 = iCharAt2 & 8191;
            int i35 = 13;
            while (true) {
                i31 = i33 + 1;
                cCharAt13 = strZbd.charAt(i33);
                if (cCharAt13 < 55296) {
                    break;
                }
                i34 |= (cCharAt13 & 8191) << i35;
                i35 += 13;
                i33 = i31;
            }
            iCharAt2 = i34 | (cCharAt13 << i35);
            i33 = i31;
        }
        if (iCharAt2 == 0) {
            i3 = 0;
            i6 = 0;
            iCharAt = 0;
            i2 = 0;
            i4 = 0;
            i5 = 0;
            iArr = zba;
            i7 = 0;
        } else {
            int i36 = i33 + 1;
            int iCharAt3 = strZbd.charAt(i33);
            if (iCharAt3 >= 55296) {
                int i37 = iCharAt3 & 8191;
                int i38 = 13;
                while (true) {
                    i15 = i36 + 1;
                    cCharAt8 = strZbd.charAt(i36);
                    if (cCharAt8 < 55296) {
                        break;
                    }
                    i37 |= (cCharAt8 & 8191) << i38;
                    i38 += 13;
                    i36 = i15;
                }
                iCharAt3 = i37 | (cCharAt8 << i38);
                i36 = i15;
            }
            int i39 = i36 + 1;
            int iCharAt4 = strZbd.charAt(i36);
            if (iCharAt4 >= 55296) {
                int i40 = iCharAt4 & 8191;
                int i41 = 13;
                while (true) {
                    i14 = i39 + 1;
                    cCharAt7 = strZbd.charAt(i39);
                    if (cCharAt7 < 55296) {
                        break;
                    }
                    i40 |= (cCharAt7 & 8191) << i41;
                    i41 += 13;
                    i39 = i14;
                }
                iCharAt4 = i40 | (cCharAt7 << i41);
                i39 = i14;
            }
            int i42 = i39 + 1;
            int iCharAt5 = strZbd.charAt(i39);
            if (iCharAt5 >= 55296) {
                int i43 = iCharAt5 & 8191;
                int i44 = 13;
                while (true) {
                    i13 = i42 + 1;
                    cCharAt6 = strZbd.charAt(i42);
                    if (cCharAt6 < 55296) {
                        break;
                    }
                    i43 |= (cCharAt6 & 8191) << i44;
                    i44 += 13;
                    i42 = i13;
                }
                iCharAt5 = i43 | (cCharAt6 << i44);
                i42 = i13;
            }
            int i45 = i42 + 1;
            int iCharAt6 = strZbd.charAt(i42);
            if (iCharAt6 >= 55296) {
                int i46 = iCharAt6 & 8191;
                int i47 = 13;
                while (true) {
                    i12 = i45 + 1;
                    cCharAt5 = strZbd.charAt(i45);
                    if (cCharAt5 < 55296) {
                        break;
                    }
                    i46 |= (cCharAt5 & 8191) << i47;
                    i47 += 13;
                    i45 = i12;
                }
                iCharAt6 = i46 | (cCharAt5 << i47);
                i45 = i12;
            }
            int i48 = i45 + 1;
            iCharAt = strZbd.charAt(i45);
            if (iCharAt >= 55296) {
                int i49 = iCharAt & 8191;
                int i50 = 13;
                while (true) {
                    i11 = i48 + 1;
                    cCharAt4 = strZbd.charAt(i48);
                    if (cCharAt4 < 55296) {
                        break;
                    }
                    i49 |= (cCharAt4 & 8191) << i50;
                    i50 += 13;
                    i48 = i11;
                }
                iCharAt = i49 | (cCharAt4 << i50);
                i48 = i11;
            }
            int i51 = i48 + 1;
            int iCharAt7 = strZbd.charAt(i48);
            if (iCharAt7 >= 55296) {
                int i52 = iCharAt7 & 8191;
                int i53 = 13;
                while (true) {
                    i10 = i51 + 1;
                    cCharAt3 = strZbd.charAt(i51);
                    if (cCharAt3 < 55296) {
                        break;
                    }
                    i52 |= (cCharAt3 & 8191) << i53;
                    i53 += 13;
                    i51 = i10;
                }
                iCharAt7 = i52 | (cCharAt3 << i53);
                i51 = i10;
            }
            int i54 = i51 + 1;
            int iCharAt8 = strZbd.charAt(i51);
            if (iCharAt8 >= 55296) {
                int i55 = iCharAt8 & 8191;
                int i56 = 13;
                while (true) {
                    i9 = i54 + 1;
                    cCharAt2 = strZbd.charAt(i54);
                    if (cCharAt2 < 55296) {
                        break;
                    }
                    i55 |= (cCharAt2 & 8191) << i56;
                    i56 += 13;
                    i54 = i9;
                }
                iCharAt8 = i55 | (cCharAt2 << i56);
                i54 = i9;
            }
            int i57 = i54 + 1;
            int iCharAt9 = strZbd.charAt(i54);
            if (iCharAt9 >= 55296) {
                int i58 = iCharAt9 & 8191;
                int i59 = 13;
                while (true) {
                    i8 = i57 + 1;
                    cCharAt = strZbd.charAt(i57);
                    if (cCharAt < 55296) {
                        break;
                    }
                    i58 |= (cCharAt & 8191) << i59;
                    i59 += 13;
                    i57 = i8;
                }
                iCharAt9 = i58 | (cCharAt << i59);
                i57 = i8;
            }
            int i60 = iCharAt3 + iCharAt3 + iCharAt4;
            int[] iArr2 = new int[iCharAt9 + iCharAt7 + iCharAt8];
            int i61 = iCharAt7;
            i2 = iCharAt5;
            i3 = i61;
            i4 = iCharAt6;
            i5 = iCharAt9;
            i6 = i60;
            iArr = iArr2;
            i7 = iCharAt3;
            i33 = i57;
        }
        Unsafe unsafe = zbb;
        Object[] objArrZbe = zbvwVar.zbe();
        Class<?> cls2 = zbvwVar.zba().getClass();
        int i62 = i5 + i3;
        int i63 = iCharAt + iCharAt;
        int[] iArr3 = new int[iCharAt * 3];
        Object[] objArr = new Object[i63];
        int i64 = i5;
        int i65 = i62;
        int i66 = 0;
        int i67 = 0;
        while (i33 < length) {
            int i68 = i33 + 1;
            int iCharAt10 = strZbd.charAt(i33);
            if (iCharAt10 >= c2) {
                int i69 = iCharAt10 & 8191;
                int i70 = i68;
                int i71 = 13;
                while (true) {
                    i30 = i70 + 1;
                    cCharAt12 = strZbd.charAt(i70);
                    if (cCharAt12 < c2) {
                        break;
                    }
                    i69 |= (cCharAt12 & 8191) << i71;
                    i71 += 13;
                    i70 = i30;
                }
                iCharAt10 = i69 | (cCharAt12 << i71);
                i16 = i30;
            } else {
                i16 = i68;
            }
            int i72 = i16 + 1;
            int iCharAt11 = strZbd.charAt(i16);
            if (iCharAt11 >= c2) {
                int i73 = iCharAt11 & 8191;
                int i74 = i72;
                int i75 = 13;
                while (true) {
                    i29 = i74 + 1;
                    cCharAt11 = strZbd.charAt(i74);
                    if (cCharAt11 < c2) {
                        break;
                    }
                    i73 |= (cCharAt11 & 8191) << i75;
                    i75 += 13;
                    i74 = i29;
                }
                iCharAt11 = i73 | (cCharAt11 << i75);
                i17 = i29;
            } else {
                i17 = i72;
            }
            if ((iCharAt11 & 1024) != 0) {
                iArr[i66] = i67;
                i66++;
            }
            int i76 = iCharAt11 & 255;
            zbvw zbvwVar2 = zbvwVar;
            int i77 = iCharAt11 & 2048;
            if (i76 >= 51) {
                int i78 = i17 + 1;
                int iCharAt12 = strZbd.charAt(i17);
                char c3 = 55296;
                if (iCharAt12 >= 55296) {
                    int i79 = iCharAt12 & 8191;
                    int i80 = i78;
                    int i81 = 13;
                    while (true) {
                        i28 = i80 + 1;
                        cCharAt10 = strZbd.charAt(i80);
                        if (cCharAt10 < c3) {
                            break;
                        }
                        i79 |= (cCharAt10 & 8191) << i81;
                        i81 += 13;
                        i80 = i28;
                        c3 = 55296;
                    }
                    iCharAt12 = i79 | (cCharAt10 << i81);
                    i23 = i28;
                } else {
                    i23 = i78;
                }
                int i82 = i23;
                int i83 = i76 - 51;
                if (i83 == 9 || i83 == 17) {
                    i24 = i6 + 1;
                    int i84 = i67 / 3;
                    objArr[i84 + i84 + 1] = objArrZbe[i6];
                } else {
                    if (i83 != 12) {
                        i25 = i77;
                    } else if (zbvwVar2.zbc() == 1 || i77 != 0) {
                        i24 = i6 + 1;
                        int i85 = i67 / 3;
                        objArr[i85 + i85 + 1] = objArrZbe[i6];
                    } else {
                        i25 = 0;
                    }
                    i26 = iCharAt12 + iCharAt12;
                    obj = objArrZbe[i26];
                    int i86 = i25;
                    if (obj instanceof Field) {
                        fieldZbz2 = (Field) obj;
                    } else {
                        fieldZbz2 = zbz(cls2, (String) obj);
                        objArrZbe[i26] = fieldZbz2;
                    }
                    int i87 = i7;
                    iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldZbz2);
                    i27 = i26 + 1;
                    obj2 = objArrZbe[i27];
                    i18 = i87;
                    if (obj2 instanceof Field) {
                        fieldZbz3 = (Field) obj2;
                    } else {
                        fieldZbz3 = zbz(cls2, (String) obj2);
                        objArrZbe[i27] = fieldZbz3;
                    }
                    iObjectFieldOffset2 = (int) unsafe.objectFieldOffset(fieldZbz3);
                    strZbd = strZbd;
                    i20 = i86;
                    i17 = i82;
                    i19 = 0;
                    c = 55296;
                }
                i6 = i24;
                i25 = i77;
                i26 = iCharAt12 + iCharAt12;
                obj = objArrZbe[i26];
                int i88 = i25;
                if (obj instanceof Field) {
                    fieldZbz2 = (Field) obj;
                } else {
                    fieldZbz2 = zbz(cls2, (String) obj);
                    objArrZbe[i26] = fieldZbz2;
                }
                int i89 = i7;
                iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldZbz2);
                i27 = i26 + 1;
                obj2 = objArrZbe[i27];
                i18 = i89;
                if (obj2 instanceof Field) {
                    fieldZbz3 = (Field) obj2;
                } else {
                    fieldZbz3 = zbz(cls2, (String) obj2);
                    objArrZbe[i27] = fieldZbz3;
                }
                iObjectFieldOffset2 = (int) unsafe.objectFieldOffset(fieldZbz3);
                strZbd = strZbd;
                i20 = i88;
                i17 = i82;
                i19 = 0;
                c = 55296;
            } else {
                i18 = i7;
                int i90 = i6 + 1;
                Field fieldZbz4 = zbz(cls2, (String) objArrZbe[i6]);
                if (i76 == 9 || i76 == 17) {
                    int i91 = i67 / 3;
                    objArr[i91 + i91 + 1] = fieldZbz4.getType();
                } else {
                    if (i76 != 27) {
                        if (i76 == 49) {
                            i6 += 2;
                            i22 = 1;
                        } else if (i76 == 12 || i76 == 30 || i76 == 44) {
                            if (zbvwVar2.zbc() == 1 || i77 != 0) {
                                i6 += 2;
                                int i92 = i67 / 3;
                                objArr[i92 + i92 + 1] = objArrZbe[i90];
                            } else {
                                i6 = i90;
                                i77 = 0;
                            }
                        } else if (i76 == 50) {
                            int i93 = i6 + 2;
                            int i94 = i64 + 1;
                            iArr[i64] = i67;
                            int i95 = i67 / 3;
                            int i96 = i95 + i95;
                            objArr[i96] = objArrZbe[i90];
                            if (i77 != 0) {
                                objArr[i96 + 1] = objArrZbe[i93];
                                i6 += 3;
                                i64 = i94;
                            } else {
                                i6 = i93;
                                i64 = i94;
                                i77 = 0;
                            }
                        }
                        iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldZbz4);
                        if ((iCharAt11 & 4096) != 0 || i76 > 17) {
                            c = 55296;
                            iObjectFieldOffset2 = 1048575;
                            i19 = 0;
                        } else {
                            int i97 = i17 + 1;
                            int iCharAt13 = strZbd.charAt(i17);
                            if (iCharAt13 >= 55296) {
                                int i98 = iCharAt13 & 8191;
                                int i99 = 13;
                                while (true) {
                                    i21 = i97 + 1;
                                    cCharAt9 = strZbd.charAt(i97);
                                    if (cCharAt9 < 55296) {
                                        break;
                                    }
                                    i98 |= (cCharAt9 & 8191) << i99;
                                    i99 += 13;
                                    i97 = i21;
                                }
                                iCharAt13 = i98 | (cCharAt9 << i99);
                            } else {
                                i21 = i97;
                            }
                            int i100 = i18 + i18 + (iCharAt13 / 32);
                            Object obj3 = objArrZbe[i100];
                            if (obj3 instanceof Field) {
                                fieldZbz = (Field) obj3;
                            } else {
                                fieldZbz = zbz(cls2, (String) obj3);
                                objArrZbe[i100] = fieldZbz;
                            }
                            int iObjectFieldOffset3 = (int) unsafe.objectFieldOffset(fieldZbz);
                            i19 = iCharAt13 % 32;
                            i17 = i21;
                            c = 55296;
                            iObjectFieldOffset2 = iObjectFieldOffset3;
                        }
                        if (i76 >= 18 && i76 <= 49) {
                            iArr[i65] = iObjectFieldOffset;
                            i65++;
                        }
                        i20 = i77;
                    } else {
                        i22 = 1;
                        i6 += 2;
                    }
                    int i101 = i67 / 3;
                    objArr[i101 + i101 + i22] = objArrZbe[i90];
                    iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldZbz4);
                    if ((iCharAt11 & 4096) != 0) {
                        c = 55296;
                        iObjectFieldOffset2 = 1048575;
                        i19 = 0;
                    } else {
                        c = 55296;
                        iObjectFieldOffset2 = 1048575;
                        i19 = 0;
                    }
                    if (i76 >= 18) {
                        iArr[i65] = iObjectFieldOffset;
                        i65++;
                    }
                    i20 = i77;
                }
                i6 = i90;
                iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldZbz4);
                if ((iCharAt11 & 4096) != 0) {
                    c = 55296;
                    iObjectFieldOffset2 = 1048575;
                    i19 = 0;
                } else {
                    c = 55296;
                    iObjectFieldOffset2 = 1048575;
                    i19 = 0;
                }
                if (i76 >= 18) {
                    iArr[i65] = iObjectFieldOffset;
                    i65++;
                }
                i20 = i77;
            }
            int i102 = i67 + 1;
            iArr3[i67] = iCharAt10;
            int i103 = i67 + 2;
            iArr3[i102] = ((iCharAt11 & 512) != 0 ? GroupFlagsKt.HasMovableContentFlag : 0) | ((iCharAt11 & 256) != 0 ? GroupFlagsKt.IsMovableContentFlag : 0) | (i20 != 0 ? Integer.MIN_VALUE : 0) | (i76 << 20) | iObjectFieldOffset;
            i67 += 3;
            iArr3[i103] = (i19 << 20) | iObjectFieldOffset2;
            i33 = i17;
            strZbd = strZbd;
            c2 = c;
            zbvwVar = zbvwVar2;
            length = length;
            i7 = i18;
        }
        return new zbvp(iArr3, objArr, i2, i4, zbvwVar.zba(), false, iArr, i5, i62, zbvsVar, zbuyVar, zbwlVar, zbtqVar, zbvhVar);
    }

    private static double zbm(Object obj, long j) {
        return ((Double) zbws.zbf(obj, j)).doubleValue();
    }

    private static float zbn(Object obj, long j) {
        return ((Float) zbws.zbf(obj, j)).floatValue();
    }

    private static int zbo(Object obj, long j) {
        return ((Integer) zbws.zbf(obj, j)).intValue();
    }

    private final int zbp(int i) {
        return this.zbc[i + 2];
    }

    private final int zbq(int i, int i2) {
        int length = (this.zbc.length / 3) - 1;
        while (i2 <= length) {
            int i3 = (length + i2) >>> 1;
            int i4 = i3 * 3;
            int i5 = this.zbc[i4];
            if (i == i5) {
                return i4;
            }
            if (i < i5) {
                length = i3 - 1;
            } else {
                i2 = i3 + 1;
            }
        }
        return -1;
    }

    private static int zbr(int i) {
        return (i >>> 20) & 255;
    }

    private final int zbs(int i) {
        return this.zbc[i + 1];
    }

    private static long zbt(Object obj, long j) {
        return ((Long) zbws.zbf(obj, j)).longValue();
    }

    private final zbuj zbu(int i) {
        int i2 = i / 3;
        return (zbuj) this.zbd[i2 + i2 + 1];
    }

    private final zbvx zbv(int i) {
        Object[] objArr = this.zbd;
        int i2 = i / 3;
        int i3 = i2 + i2;
        zbvx zbvxVar = (zbvx) objArr[i3];
        if (zbvxVar != null) {
            return zbvxVar;
        }
        zbvx zbvxVarZbb = zbvu.zba().zbb((Class) objArr[i3 + 1]);
        this.zbd[i3] = zbvxVarZbb;
        return zbvxVarZbb;
    }

    private final Object zbw(int i) {
        int i2 = i / 3;
        return this.zbd[i2 + i2];
    }

    private final Object zbx(Object obj, int i) {
        zbvx zbvxVarZbv = zbv(i);
        int iZbs = zbs(i) & 1048575;
        if (!zbI(obj, i)) {
            return zbvxVarZbv.zbe();
        }
        Object object = zbb.getObject(obj, iZbs);
        if (zbL(object)) {
            return object;
        }
        Object objZbe = zbvxVarZbv.zbe();
        if (object != null) {
            zbvxVarZbv.zbg(objZbe, object);
        }
        return objZbe;
    }

    private final Object zby(Object obj, int i, int i2) {
        zbvx zbvxVarZbv = zbv(i2);
        if (!zbM(obj, i, i2)) {
            return zbvxVarZbv.zbe();
        }
        Object object = zbb.getObject(obj, zbs(i2) & 1048575);
        if (zbL(object)) {
            return object;
        }
        Object objZbe = zbvxVarZbv.zbe();
        if (object != null) {
            zbvxVarZbv.zbg(objZbe, object);
        }
        return objZbe;
    }

    private static Field zbz(Class cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            throw new RuntimeException("Field " + str + " for " + cls.getName() + " not found. Known fields are " + Arrays.toString(declaredFields));
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:141:0x0391  */
    /* JADX WARN: Code duplicated, block: B:211:0x0553  */
    /* JADX WARN: Code duplicated, block: B:280:0x0717 A[PHI: r0
      0x0717: PHI (r0v9 com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbvp<T>) = 
      (r0v1 com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbvp<T>)
      (r0v1 com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbvp<T>)
      (r0v1 com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbvp<T>)
      (r0v46 com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbvp<T>)
      (r0v1 com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbvp<T>)
      (r0v1 com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbvp<T>)
      (r0v1 com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbvp<T>)
      (r0v1 com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbvp<T>)
      (r0v1 com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbvp<T>)
      (r0v1 com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbvp<T>)
      (r0v1 com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbvp<T>)
      (r0v1 com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbvp<T>)
      (r0v1 com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbvp<T>)
      (r0v1 com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbvp<T>)
      (r0v1 com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbvp<T>)
      (r0v1 com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbvp<T>)
      (r0v1 com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbvp<T>)
      (r0v1 com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbvp<T>)
      (r0v1 com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbvp<T>)
      (r0v1 com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbvp<T>)
      (r0v1 com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbvp<T>)
      (r0v1 com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbvp<T>)
      (r0v1 com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbvp<T>)
      (r0v1 com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbvp<T>)
      (r0v1 com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbvp<T>)
      (r0v1 com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbvp<T>)
      (r0v1 com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbvp<T>)
      (r0v1 com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbvp<T>)
      (r0v1 com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbvp<T>)
      (r0v1 com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbvp<T>)
      (r0v1 com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbvp<T>)
      (r0v1 com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbvp<T>)
      (r0v1 com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbvp<T>)
      (r0v1 com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbvp<T>)
      (r0v1 com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbvp<T>)
      (r0v1 com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbvp<T>)
      (r0v1 com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbvp<T>)
     binds: [B:18:0x004f, B:278:0x070a, B:243:0x0640, B:276:0x0702, B:218:0x0586, B:135:0x0371, B:132:0x035a, B:129:0x0343, B:126:0x032c, B:123:0x0315, B:120:0x02fd, B:117:0x02e5, B:114:0x02cd, B:111:0x02b3, B:108:0x029b, B:105:0x0283, B:102:0x026b, B:99:0x0253, B:96:0x023b, B:78:0x01c4, B:74:0x01b4, B:70:0x019d, B:67:0x0188, B:64:0x0172, B:61:0x0165, B:58:0x0158, B:55:0x0149, B:49:0x011f, B:46:0x010b, B:42:0x00ed, B:39:0x00d7, B:36:0x00c0, B:33:0x00b2, B:30:0x00a4, B:27:0x0089, B:24:0x006e, B:21:0x0058] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbvx
    public final int zba(Object obj) {
        int i;
        int iZbD;
        int iZbD2;
        int iZbE;
        int iZbD3;
        int iZbD4;
        int iZbD5;
        int iZbd;
        int iZbD6;
        int iZbh;
        int iZbg;
        int size;
        int iZbl;
        int iZbD7;
        int iZbD8;
        int iZbD9;
        int iZbE2;
        int iZbe;
        int iZbD10;
        int iZbD11;
        int iZbz;
        int iZbD12;
        int iZbD13;
        int iZbD14;
        int iZbd2;
        int iZbD15;
        zbvp<T> zbvpVar = this;
        Unsafe unsafe = zbb;
        int i2 = 1048575;
        int i3 = 0;
        int i4 = 0;
        int iZbD16 = 0;
        int i5 = 1048575;
        while (i3 < zbvpVar.zbc.length) {
            int iZbs = zbvpVar.zbs(i3);
            int iZbr = zbr(iZbs);
            int[] iArr = zbvpVar.zbc;
            int i6 = iArr[i3];
            int i7 = iArr[i3 + 2];
            int i8 = i7 & i2;
            if (iZbr <= 17) {
                if (i8 != i5) {
                    i4 = i8 == i2 ? 0 : unsafe.getInt(obj, i8);
                    i5 = i8;
                }
                i = 1 << (i7 >>> 20);
            } else {
                i = 0;
            }
            int i9 = iZbs & i2;
            if (iZbr >= zbtv.DOUBLE_LIST_PACKED.zba()) {
                zbtv.SINT64_LIST_PACKED.zba();
            }
            int i10 = iZbD16;
            long j = i9;
            switch (iZbr) {
                case 0:
                    if (zbvpVar.zbJ(obj, i3, i5, i4, i)) {
                        iZbD16 = i10 + zbtk.zbD(i6 << 3) + 8;
                    } else {
                        iZbD16 = i10;
                    }
                    break;
                case 1:
                    if (zbvpVar.zbJ(obj, i3, i5, i4, i)) {
                        iZbD = zbtk.zbD(i6 << 3);
                        iZbD4 = iZbD + 4;
                        iZbD16 = i10 + iZbD4;
                        zbvpVar = this;
                    }
                    zbvpVar = this;
                    iZbD16 = i10;
                    break;
                case 2:
                    if (zbvpVar.zbJ(obj, i3, i5, i4, i)) {
                        long j2 = unsafe.getLong(obj, j);
                        iZbD2 = zbtk.zbD(i6 << 3);
                        iZbE = zbtk.zbE(j2);
                        iZbD4 = iZbD2 + iZbE;
                        iZbD16 = i10 + iZbD4;
                        zbvpVar = this;
                    }
                    zbvpVar = this;
                    iZbD16 = i10;
                    break;
                case 3:
                    if (zbvpVar.zbJ(obj, i3, i5, i4, i)) {
                        long j3 = unsafe.getLong(obj, j);
                        iZbD2 = zbtk.zbD(i6 << 3);
                        iZbE = zbtk.zbE(j3);
                        iZbD4 = iZbD2 + iZbE;
                        iZbD16 = i10 + iZbD4;
                        zbvpVar = this;
                    }
                    zbvpVar = this;
                    iZbD16 = i10;
                    break;
                case 4:
                    if (zbvpVar.zbJ(obj, i3, i5, i4, i)) {
                        long j4 = unsafe.getInt(obj, j);
                        iZbD2 = zbtk.zbD(i6 << 3);
                        iZbE = zbtk.zbE(j4);
                        iZbD4 = iZbD2 + iZbE;
                        iZbD16 = i10 + iZbD4;
                        zbvpVar = this;
                    }
                    zbvpVar = this;
                    iZbD16 = i10;
                    break;
                case 5:
                    if (zbvpVar.zbJ(obj, i3, i5, i4, i)) {
                        iZbD3 = zbtk.zbD(i6 << 3);
                        iZbD4 = iZbD3 + 8;
                        iZbD16 = i10 + iZbD4;
                        zbvpVar = this;
                    }
                    zbvpVar = this;
                    iZbD16 = i10;
                    break;
                case 6:
                    if (zbvpVar.zbJ(obj, i3, i5, i4, i)) {
                        iZbD = zbtk.zbD(i6 << 3);
                        iZbD4 = iZbD + 4;
                        iZbD16 = i10 + iZbD4;
                        zbvpVar = this;
                    }
                    zbvpVar = this;
                    iZbD16 = i10;
                    break;
                case 7:
                    if (zbvpVar.zbJ(obj, i3, i5, i4, i)) {
                        iZbD4 = zbtk.zbD(i6 << 3) + 1;
                        iZbD16 = i10 + iZbD4;
                        zbvpVar = this;
                    }
                    zbvpVar = this;
                    iZbD16 = i10;
                    break;
                case 8:
                    if (zbvpVar.zbJ(obj, i3, i5, i4, i)) {
                        int i11 = i6 << 3;
                        Object object = unsafe.getObject(obj, j);
                        if (object instanceof zbtc) {
                            iZbD5 = zbtk.zbD(i11);
                            iZbd = ((zbtc) object).zbd();
                            iZbD6 = zbtk.zbD(iZbd);
                            iZbD4 = iZbD5 + iZbD6 + iZbd;
                            iZbD16 = i10 + iZbD4;
                            zbvpVar = this;
                        } else {
                            iZbD2 = zbtk.zbD(i11);
                            iZbE = zbtk.zbC((String) object);
                            iZbD4 = iZbD2 + iZbE;
                            iZbD16 = i10 + iZbD4;
                            zbvpVar = this;
                        }
                    }
                    zbvpVar = this;
                    iZbD16 = i10;
                    break;
                case 9:
                    if (zbvpVar.zbJ(obj, i3, i5, i4, i)) {
                        iZbh = zbvz.zbh(i6, unsafe.getObject(obj, j), zbvpVar.zbv(i3));
                        iZbD16 = i10 + iZbh;
                    } else {
                        iZbD16 = i10;
                    }
                    break;
                case 10:
                    if (zbvpVar.zbJ(obj, i3, i5, i4, i)) {
                        zbtc zbtcVar = (zbtc) unsafe.getObject(obj, j);
                        iZbD5 = zbtk.zbD(i6 << 3);
                        iZbd = zbtcVar.zbd();
                        iZbD6 = zbtk.zbD(iZbd);
                        iZbD4 = iZbD5 + iZbD6 + iZbd;
                        iZbD16 = i10 + iZbD4;
                        zbvpVar = this;
                    }
                    zbvpVar = this;
                    iZbD16 = i10;
                    break;
                case 11:
                    if (zbvpVar.zbJ(obj, i3, i5, i4, i)) {
                        int i12 = unsafe.getInt(obj, j);
                        iZbD2 = zbtk.zbD(i6 << 3);
                        iZbE = zbtk.zbD(i12);
                        iZbD4 = iZbD2 + iZbE;
                        iZbD16 = i10 + iZbD4;
                        zbvpVar = this;
                    }
                    zbvpVar = this;
                    iZbD16 = i10;
                    break;
                case 12:
                    if (zbvpVar.zbJ(obj, i3, i5, i4, i)) {
                        long j5 = unsafe.getInt(obj, j);
                        iZbD2 = zbtk.zbD(i6 << 3);
                        iZbE = zbtk.zbE(j5);
                        iZbD4 = iZbD2 + iZbE;
                        iZbD16 = i10 + iZbD4;
                        zbvpVar = this;
                    }
                    zbvpVar = this;
                    iZbD16 = i10;
                    break;
                case 13:
                    if (zbvpVar.zbJ(obj, i3, i5, i4, i)) {
                        iZbD = zbtk.zbD(i6 << 3);
                        iZbD4 = iZbD + 4;
                        iZbD16 = i10 + iZbD4;
                        zbvpVar = this;
                    }
                    zbvpVar = this;
                    iZbD16 = i10;
                    break;
                case 14:
                    if (zbvpVar.zbJ(obj, i3, i5, i4, i)) {
                        iZbD3 = zbtk.zbD(i6 << 3);
                        iZbD4 = iZbD3 + 8;
                        iZbD16 = i10 + iZbD4;
                        zbvpVar = this;
                    }
                    zbvpVar = this;
                    iZbD16 = i10;
                    break;
                case 15:
                    if (zbvpVar.zbJ(obj, i3, i5, i4, i)) {
                        int i13 = unsafe.getInt(obj, j);
                        iZbD2 = zbtk.zbD(i6 << 3);
                        iZbE = zbtk.zbD((i13 >> 31) ^ (i13 + i13));
                        iZbD4 = iZbD2 + iZbE;
                        iZbD16 = i10 + iZbD4;
                        zbvpVar = this;
                    }
                    zbvpVar = this;
                    iZbD16 = i10;
                    break;
                case 16:
                    if (zbvpVar.zbJ(obj, i3, i5, i4, i)) {
                        long j6 = unsafe.getLong(obj, j);
                        iZbD2 = zbtk.zbD(i6 << 3);
                        iZbE = zbtk.zbE((j6 >> 63) ^ (j6 + j6));
                        iZbD4 = iZbD2 + iZbE;
                        iZbD16 = i10 + iZbD4;
                        zbvpVar = this;
                    }
                    zbvpVar = this;
                    iZbD16 = i10;
                    break;
                case 17:
                    if (zbvpVar.zbJ(obj, i3, i5, i4, i)) {
                        iZbh = zbtk.zbz(i6, (zbvm) unsafe.getObject(obj, j), zbvpVar.zbv(i3));
                        iZbD16 = i10 + iZbh;
                    } else {
                        iZbD16 = i10;
                    }
                    break;
                case 18:
                    iZbh = zbvz.zbd(i6, (List) unsafe.getObject(obj, j), false);
                    iZbD16 = i10 + iZbh;
                    break;
                case 19:
                    iZbh = zbvz.zbb(i6, (List) unsafe.getObject(obj, j), false);
                    iZbD16 = i10 + iZbh;
                    break;
                case 20:
                    List list = (List) unsafe.getObject(obj, j);
                    int i14 = zbvz.zba;
                    if (list.size() == 0) {
                        iZbg = 0;
                    } else {
                        iZbg = zbvz.zbg(list) + (list.size() * zbtk.zbD(i6 << 3));
                    }
                    iZbD16 = iZbg + i10;
                    break;
                case 21:
                    List list2 = (List) unsafe.getObject(obj, j);
                    int i15 = zbvz.zba;
                    size = list2.size();
                    if (size == 0) {
                        iZbh = 0;
                    } else {
                        iZbl = zbvz.zbl(list2);
                        iZbD7 = zbtk.zbD(i6 << 3);
                        iZbE2 = size * iZbD7;
                        iZbh = iZbl + iZbE2;
                    }
                    iZbD16 = i10 + iZbh;
                    break;
                case 22:
                    List list3 = (List) unsafe.getObject(obj, j);
                    int i16 = zbvz.zba;
                    size = list3.size();
                    if (size == 0) {
                        iZbh = 0;
                    } else {
                        iZbl = zbvz.zbf(list3);
                        iZbD7 = zbtk.zbD(i6 << 3);
                        iZbE2 = size * iZbD7;
                        iZbh = iZbl + iZbE2;
                    }
                    iZbD16 = i10 + iZbh;
                    break;
                case 23:
                    iZbh = zbvz.zbd(i6, (List) unsafe.getObject(obj, j), false);
                    iZbD16 = i10 + iZbh;
                    break;
                case 24:
                    iZbh = zbvz.zbb(i6, (List) unsafe.getObject(obj, j), false);
                    iZbD16 = i10 + iZbh;
                    break;
                case 25:
                    List list4 = (List) unsafe.getObject(obj, j);
                    int i17 = zbvz.zba;
                    int size2 = list4.size();
                    if (size2 == 0) {
                        iZbh = 0;
                    } else {
                        iZbh = size2 * (zbtk.zbD(i6 << 3) + 1);
                    }
                    iZbD16 = i10 + iZbh;
                    break;
                case 26:
                    List list5 = (List) unsafe.getObject(obj, j);
                    int i18 = zbvz.zba;
                    int size3 = list5.size();
                    if (size3 == 0) {
                        iZbg = 0;
                    } else {
                        iZbg = zbtk.zbD(i6 << 3) * size3;
                        if (list5 instanceof zbux) {
                            zbux zbuxVar = (zbux) list5;
                            for (int i19 = 0; i19 < size3; i19++) {
                                Object objZba = zbuxVar.zba();
                                if (objZba instanceof zbtc) {
                                    int iZbd3 = ((zbtc) objZba).zbd();
                                    iZbg += zbtk.zbD(iZbd3) + iZbd3;
                                } else {
                                    iZbg += zbtk.zbC((String) objZba);
                                }
                            }
                        } else {
                            for (int i20 = 0; i20 < size3; i20++) {
                                Object obj2 = list5.get(i20);
                                if (obj2 instanceof zbtc) {
                                    int iZbd4 = ((zbtc) obj2).zbd();
                                    iZbg += zbtk.zbD(iZbd4) + iZbd4;
                                } else {
                                    iZbg += zbtk.zbC((String) obj2);
                                }
                            }
                        }
                    }
                    iZbD16 = iZbg + i10;
                    break;
                case 27:
                    List list6 = (List) unsafe.getObject(obj, j);
                    zbvx zbvxVarZbv = zbvpVar.zbv(i3);
                    int i21 = zbvz.zba;
                    int size4 = list6.size();
                    if (size4 == 0) {
                        iZbD8 = 0;
                    } else {
                        iZbD8 = zbtk.zbD(i6 << 3) * size4;
                        for (int i22 = 0; i22 < size4; i22++) {
                            Object obj3 = list6.get(i22);
                            if (obj3 instanceof zbuw) {
                                int iZba = ((zbuw) obj3).zba();
                                iZbD8 += zbtk.zbD(iZba) + iZba;
                            } else {
                                iZbD8 += zbtk.zbB((zbvm) obj3, zbvxVarZbv);
                            }
                        }
                    }
                    iZbD16 = i10 + iZbD8;
                    break;
                case 28:
                    List list7 = (List) unsafe.getObject(obj, j);
                    int i23 = zbvz.zba;
                    int size5 = list7.size();
                    if (size5 == 0) {
                        iZbD9 = 0;
                    } else {
                        iZbD9 = size5 * zbtk.zbD(i6 << 3);
                        for (int i24 = 0; i24 < list7.size(); i24++) {
                            int iZbd5 = ((zbtc) list7.get(i24)).zbd();
                            iZbD9 += zbtk.zbD(iZbd5) + iZbd5;
                        }
                    }
                    iZbD16 = i10 + iZbD9;
                    break;
                case 29:
                    List list8 = (List) unsafe.getObject(obj, j);
                    int i25 = zbvz.zba;
                    size = list8.size();
                    if (size == 0) {
                        iZbh = 0;
                    } else {
                        iZbl = zbvz.zbk(list8);
                        iZbD7 = zbtk.zbD(i6 << 3);
                        iZbE2 = size * iZbD7;
                        iZbh = iZbl + iZbE2;
                    }
                    iZbD16 = i10 + iZbh;
                    break;
                case 30:
                    List list9 = (List) unsafe.getObject(obj, j);
                    int i26 = zbvz.zba;
                    size = list9.size();
                    if (size == 0) {
                        iZbh = 0;
                    } else {
                        iZbl = zbvz.zba(list9);
                        iZbD7 = zbtk.zbD(i6 << 3);
                        iZbE2 = size * iZbD7;
                        iZbh = iZbl + iZbE2;
                    }
                    iZbD16 = i10 + iZbh;
                    break;
                case 31:
                    iZbh = zbvz.zbb(i6, (List) unsafe.getObject(obj, j), false);
                    iZbD16 = i10 + iZbh;
                    break;
                case 32:
                    iZbh = zbvz.zbd(i6, (List) unsafe.getObject(obj, j), false);
                    iZbD16 = i10 + iZbh;
                    break;
                case 33:
                    List list10 = (List) unsafe.getObject(obj, j);
                    int i27 = zbvz.zba;
                    size = list10.size();
                    if (size == 0) {
                        iZbh = 0;
                    } else {
                        iZbl = zbvz.zbi(list10);
                        iZbD7 = zbtk.zbD(i6 << 3);
                        iZbE2 = size * iZbD7;
                        iZbh = iZbl + iZbE2;
                    }
                    iZbD16 = i10 + iZbh;
                    break;
                case 34:
                    List list11 = (List) unsafe.getObject(obj, j);
                    int i28 = zbvz.zba;
                    size = list11.size();
                    if (size == 0) {
                        iZbh = 0;
                    } else {
                        iZbl = zbvz.zbj(list11);
                        iZbD7 = zbtk.zbD(i6 << 3);
                        iZbE2 = size * iZbD7;
                        iZbh = iZbl + iZbE2;
                    }
                    iZbD16 = i10 + iZbh;
                    break;
                case 35:
                    iZbe = zbvz.zbe((List) unsafe.getObject(obj, j));
                    if (iZbe > 0) {
                        iZbD10 = zbtk.zbD(i6 << 3);
                        iZbD11 = zbtk.zbD(iZbe);
                        iZbD9 = iZbD10 + iZbD11 + iZbe;
                        iZbD16 = i10 + iZbD9;
                    } else {
                        iZbD16 = i10;
                    }
                    break;
                case 36:
                    iZbe = zbvz.zbc((List) unsafe.getObject(obj, j));
                    if (iZbe > 0) {
                        iZbD10 = zbtk.zbD(i6 << 3);
                        iZbD11 = zbtk.zbD(iZbe);
                        iZbD9 = iZbD10 + iZbD11 + iZbe;
                        iZbD16 = i10 + iZbD9;
                    } else {
                        iZbD16 = i10;
                    }
                    break;
                case 37:
                    iZbe = zbvz.zbg((List) unsafe.getObject(obj, j));
                    if (iZbe > 0) {
                        iZbD10 = zbtk.zbD(i6 << 3);
                        iZbD11 = zbtk.zbD(iZbe);
                        iZbD9 = iZbD10 + iZbD11 + iZbe;
                        iZbD16 = i10 + iZbD9;
                    } else {
                        iZbD16 = i10;
                    }
                    break;
                case MotionEventCompat.AXIS_GENERIC_7 /* 38 */:
                    iZbe = zbvz.zbl((List) unsafe.getObject(obj, j));
                    if (iZbe > 0) {
                        iZbD10 = zbtk.zbD(i6 << 3);
                        iZbD11 = zbtk.zbD(iZbe);
                        iZbD9 = iZbD10 + iZbD11 + iZbe;
                        iZbD16 = i10 + iZbD9;
                    } else {
                        iZbD16 = i10;
                    }
                    break;
                case 39:
                    iZbe = zbvz.zbf((List) unsafe.getObject(obj, j));
                    if (iZbe > 0) {
                        iZbD10 = zbtk.zbD(i6 << 3);
                        iZbD11 = zbtk.zbD(iZbe);
                        iZbD9 = iZbD10 + iZbD11 + iZbe;
                        iZbD16 = i10 + iZbD9;
                    } else {
                        iZbD16 = i10;
                    }
                    break;
                case 40:
                    iZbe = zbvz.zbe((List) unsafe.getObject(obj, j));
                    if (iZbe > 0) {
                        iZbD10 = zbtk.zbD(i6 << 3);
                        iZbD11 = zbtk.zbD(iZbe);
                        iZbD9 = iZbD10 + iZbD11 + iZbe;
                        iZbD16 = i10 + iZbD9;
                    } else {
                        iZbD16 = i10;
                    }
                    break;
                case 41:
                    iZbe = zbvz.zbc((List) unsafe.getObject(obj, j));
                    if (iZbe > 0) {
                        iZbD10 = zbtk.zbD(i6 << 3);
                        iZbD11 = zbtk.zbD(iZbe);
                        iZbD9 = iZbD10 + iZbD11 + iZbe;
                        iZbD16 = i10 + iZbD9;
                    } else {
                        iZbD16 = i10;
                    }
                    break;
                case MotionEventCompat.AXIS_GENERIC_11 /* 42 */:
                    List list12 = (List) unsafe.getObject(obj, j);
                    int i29 = zbvz.zba;
                    iZbe = list12.size();
                    if (iZbe > 0) {
                        iZbD10 = zbtk.zbD(i6 << 3);
                        iZbD11 = zbtk.zbD(iZbe);
                        iZbD9 = iZbD10 + iZbD11 + iZbe;
                        iZbD16 = i10 + iZbD9;
                    } else {
                        iZbD16 = i10;
                    }
                    break;
                case MotionEventCompat.AXIS_GENERIC_12 /* 43 */:
                    iZbe = zbvz.zbk((List) unsafe.getObject(obj, j));
                    if (iZbe > 0) {
                        iZbD10 = zbtk.zbD(i6 << 3);
                        iZbD11 = zbtk.zbD(iZbe);
                        iZbD9 = iZbD10 + iZbD11 + iZbe;
                        iZbD16 = i10 + iZbD9;
                    } else {
                        iZbD16 = i10;
                    }
                    break;
                case 44:
                    iZbe = zbvz.zba((List) unsafe.getObject(obj, j));
                    if (iZbe > 0) {
                        iZbD10 = zbtk.zbD(i6 << 3);
                        iZbD11 = zbtk.zbD(iZbe);
                        iZbD9 = iZbD10 + iZbD11 + iZbe;
                        iZbD16 = i10 + iZbD9;
                    } else {
                        iZbD16 = i10;
                    }
                    break;
                case 45:
                    iZbe = zbvz.zbc((List) unsafe.getObject(obj, j));
                    if (iZbe > 0) {
                        iZbD10 = zbtk.zbD(i6 << 3);
                        iZbD11 = zbtk.zbD(iZbe);
                        iZbD9 = iZbD10 + iZbD11 + iZbe;
                        iZbD16 = i10 + iZbD9;
                    } else {
                        iZbD16 = i10;
                    }
                    break;
                case MotionEventCompat.AXIS_GENERIC_15 /* 46 */:
                    iZbe = zbvz.zbe((List) unsafe.getObject(obj, j));
                    if (iZbe > 0) {
                        iZbD10 = zbtk.zbD(i6 << 3);
                        iZbD11 = zbtk.zbD(iZbe);
                        iZbD9 = iZbD10 + iZbD11 + iZbe;
                        iZbD16 = i10 + iZbD9;
                    } else {
                        iZbD16 = i10;
                    }
                    break;
                case MotionEventCompat.AXIS_GENERIC_16 /* 47 */:
                    iZbe = zbvz.zbi((List) unsafe.getObject(obj, j));
                    if (iZbe > 0) {
                        iZbD10 = zbtk.zbD(i6 << 3);
                        iZbD11 = zbtk.zbD(iZbe);
                        iZbD9 = iZbD10 + iZbD11 + iZbe;
                        iZbD16 = i10 + iZbD9;
                    } else {
                        iZbD16 = i10;
                    }
                    break;
                case 48:
                    iZbe = zbvz.zbj((List) unsafe.getObject(obj, j));
                    if (iZbe > 0) {
                        iZbD10 = zbtk.zbD(i6 << 3);
                        iZbD11 = zbtk.zbD(iZbe);
                        iZbD9 = iZbD10 + iZbD11 + iZbe;
                        iZbD16 = i10 + iZbD9;
                    } else {
                        iZbD16 = i10;
                    }
                    break;
                case 49:
                    List list13 = (List) unsafe.getObject(obj, j);
                    zbvx zbvxVarZbv2 = zbvpVar.zbv(i3);
                    int i30 = zbvz.zba;
                    int size6 = list13.size();
                    if (size6 == 0) {
                        iZbz = 0;
                    } else {
                        iZbz = 0;
                        for (int i31 = 0; i31 < size6; i31++) {
                            iZbz += zbtk.zbz(i6, (zbvm) list13.get(i31), zbvxVarZbv2);
                        }
                    }
                    iZbD16 = i10 + iZbz;
                    break;
                case 50:
                    zbvg zbvgVar = (zbvg) unsafe.getObject(obj, j);
                    zbvf zbvfVar = (zbvf) zbvpVar.zbw(i3);
                    if (zbvgVar.isEmpty()) {
                        iZbg = 0;
                    } else {
                        iZbg = 0;
                        for (Map.Entry entry : zbvgVar.entrySet()) {
                            iZbg += zbvfVar.zba(i6, entry.getKey(), entry.getValue());
                        }
                    }
                    iZbD16 = iZbg + i10;
                    break;
                case StylePropertiesKt.BackgroundBrushId /* 51 */:
                    if (zbvpVar.zbM(obj, i6, i3)) {
                        iZbD12 = zbtk.zbD(i6 << 3);
                        iZbh = iZbD12 + 8;
                        iZbD16 = i10 + iZbh;
                    } else {
                        iZbD16 = i10;
                    }
                    break;
                case StylePropertiesKt.ForegroundBrushId /* 52 */:
                    if (zbvpVar.zbM(obj, i6, i3)) {
                        iZbD13 = zbtk.zbD(i6 << 3);
                        iZbh = iZbD13 + 4;
                        iZbD16 = i10 + iZbh;
                    } else {
                        iZbD16 = i10;
                    }
                    break;
                case StylePropertiesKt.ShapeId /* 53 */:
                    if (zbvpVar.zbM(obj, i6, i3)) {
                        long jZbt = zbt(obj, j);
                        iZbl = zbtk.zbD(i6 << 3);
                        iZbE2 = zbtk.zbE(jZbt);
                        iZbh = iZbl + iZbE2;
                        iZbD16 = i10 + iZbh;
                    } else {
                        iZbD16 = i10;
                    }
                    break;
                case StylePropertiesKt.ColorFilterId /* 54 */:
                    if (zbvpVar.zbM(obj, i6, i3)) {
                        long jZbt2 = zbt(obj, j);
                        iZbl = zbtk.zbD(i6 << 3);
                        iZbE2 = zbtk.zbE(jZbt2);
                        iZbh = iZbl + iZbE2;
                        iZbD16 = i10 + iZbh;
                    } else {
                        iZbD16 = i10;
                    }
                    break;
                case StylePropertiesKt.DropShadowId /* 55 */:
                    if (zbvpVar.zbM(obj, i6, i3)) {
                        long jZbo = zbo(obj, j);
                        iZbl = zbtk.zbD(i6 << 3);
                        iZbE2 = zbtk.zbE(jZbo);
                        iZbh = iZbl + iZbE2;
                        iZbD16 = i10 + iZbh;
                    } else {
                        iZbD16 = i10;
                    }
                    break;
                case StylePropertiesKt.InnerShadowId /* 56 */:
                    if (zbvpVar.zbM(obj, i6, i3)) {
                        iZbD12 = zbtk.zbD(i6 << 3);
                        iZbh = iZbD12 + 8;
                        iZbD16 = i10 + iZbh;
                    } else {
                        iZbD16 = i10;
                    }
                    break;
                case StylePropertiesKt.ContentBrushId /* 57 */:
                    if (zbvpVar.zbM(obj, i6, i3)) {
                        iZbD13 = zbtk.zbD(i6 << 3);
                        iZbh = iZbD13 + 4;
                        iZbD16 = i10 + iZbh;
                    } else {
                        iZbD16 = i10;
                    }
                    break;
                case StylePropertiesKt.FontFamilyId /* 58 */:
                    if (zbvpVar.zbM(obj, i6, i3)) {
                        iZbh = zbtk.zbD(i6 << 3) + 1;
                        iZbD16 = i10 + iZbh;
                    } else {
                        iZbD16 = i10;
                    }
                    break;
                case StylePropertiesKt.TextMotionId /* 59 */:
                    if (zbvpVar.zbM(obj, i6, i3)) {
                        int i32 = i6 << 3;
                        Object object2 = unsafe.getObject(obj, j);
                        if (object2 instanceof zbtc) {
                            iZbD14 = zbtk.zbD(i32);
                            iZbd2 = ((zbtc) object2).zbd();
                            iZbD15 = zbtk.zbD(iZbd2);
                            iZbh = iZbD14 + iZbD15 + iZbd2;
                            iZbD16 = i10 + iZbh;
                        } else {
                            iZbl = zbtk.zbD(i32);
                            iZbE2 = zbtk.zbC((String) object2);
                            iZbh = iZbl + iZbE2;
                            iZbD16 = i10 + iZbh;
                        }
                    } else {
                        iZbD16 = i10;
                    }
                    break;
                case 60:
                    if (zbvpVar.zbM(obj, i6, i3)) {
                        iZbh = zbvz.zbh(i6, unsafe.getObject(obj, j), zbvpVar.zbv(i3));
                        iZbD16 = i10 + iZbh;
                    } else {
                        iZbD16 = i10;
                    }
                    break;
                case 61:
                    if (zbvpVar.zbM(obj, i6, i3)) {
                        zbtc zbtcVar2 = (zbtc) unsafe.getObject(obj, j);
                        iZbD14 = zbtk.zbD(i6 << 3);
                        iZbd2 = zbtcVar2.zbd();
                        iZbD15 = zbtk.zbD(iZbd2);
                        iZbh = iZbD14 + iZbD15 + iZbd2;
                        iZbD16 = i10 + iZbh;
                    } else {
                        iZbD16 = i10;
                    }
                    break;
                case RectListKt.BitOffsetForGesturable /* 62 */:
                    if (zbvpVar.zbM(obj, i6, i3)) {
                        int iZbo = zbo(obj, j);
                        iZbl = zbtk.zbD(i6 << 3);
                        iZbE2 = zbtk.zbD(iZbo);
                        iZbh = iZbl + iZbE2;
                        iZbD16 = i10 + iZbh;
                    } else {
                        iZbD16 = i10;
                    }
                    break;
                case 63:
                    if (zbvpVar.zbM(obj, i6, i3)) {
                        long jZbo2 = zbo(obj, j);
                        iZbl = zbtk.zbD(i6 << 3);
                        iZbE2 = zbtk.zbE(jZbo2);
                        iZbh = iZbl + iZbE2;
                        iZbD16 = i10 + iZbh;
                    } else {
                        iZbD16 = i10;
                    }
                    break;
                case 64:
                    if (zbvpVar.zbM(obj, i6, i3)) {
                        iZbD13 = zbtk.zbD(i6 << 3);
                        iZbh = iZbD13 + 4;
                        iZbD16 = i10 + iZbh;
                    } else {
                        iZbD16 = i10;
                    }
                    break;
                case 65:
                    if (zbvpVar.zbM(obj, i6, i3)) {
                        iZbD12 = zbtk.zbD(i6 << 3);
                        iZbh = iZbD12 + 8;
                        iZbD16 = i10 + iZbh;
                    } else {
                        iZbD16 = i10;
                    }
                    break;
                case 66:
                    if (zbvpVar.zbM(obj, i6, i3)) {
                        int iZbo2 = zbo(obj, j);
                        iZbl = zbtk.zbD(i6 << 3);
                        iZbE2 = zbtk.zbD((iZbo2 >> 31) ^ (iZbo2 + iZbo2));
                        iZbh = iZbl + iZbE2;
                        iZbD16 = i10 + iZbh;
                    } else {
                        iZbD16 = i10;
                    }
                    break;
                case 67:
                    if (zbvpVar.zbM(obj, i6, i3)) {
                        long jZbt3 = zbt(obj, j);
                        iZbl = zbtk.zbD(i6 << 3);
                        iZbE2 = zbtk.zbE((jZbt3 >> 63) ^ (jZbt3 + jZbt3));
                        iZbh = iZbl + iZbE2;
                        iZbD16 = i10 + iZbh;
                    } else {
                        iZbD16 = i10;
                    }
                    break;
                case 68:
                    if (zbvpVar.zbM(obj, i6, i3)) {
                        iZbh = zbtk.zbz(i6, (zbvm) unsafe.getObject(obj, j), zbvpVar.zbv(i3));
                        iZbD16 = i10 + iZbh;
                    } else {
                        iZbD16 = i10;
                    }
                    break;
                default:
                    iZbD16 = i10;
                    break;
            }
            i3 += 3;
            i2 = 1048575;
        }
        int iZba2 = iZbD16 + ((zbuf) obj).zbc.zba();
        if (!zbvpVar.zbh) {
            return iZba2;
        }
        zbtu zbtuVar = ((zbub) obj).zbb;
        int iZbc = zbtuVar.zba.zbc();
        int iZbb = 0;
        for (int i33 = 0; i33 < iZbc; i33++) {
            Map.Entry entryZbg = zbtuVar.zba.zbg(i33);
            iZbb += zbtu.zbb((zbtt) ((zbwb) entryZbg).zba(), entryZbg.getValue());
        }
        for (Map.Entry entry2 : zbtuVar.zba.zbd()) {
            iZbb += zbtu.zbb((zbtt) entry2.getKey(), entry2.getValue());
        }
        return iZba2 + iZbb;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbvx
    public final int zbb(Object obj) {
        int i;
        long jDoubleToLongBits;
        int iFloatToIntBits;
        int i2;
        int i3 = 0;
        for (int i4 = 0; i4 < this.zbc.length; i4 += 3) {
            int iZbs = zbs(i4);
            int[] iArr = this.zbc;
            int i5 = 1048575 & iZbs;
            int iZbr = zbr(iZbs);
            int i6 = iArr[i4];
            long j = i5;
            int iHashCode = 37;
            switch (iZbr) {
                case 0:
                    i = i3 * 53;
                    jDoubleToLongBits = Double.doubleToLongBits(zbws.zba(obj, j));
                    byte[] bArr = zbuo.zbb;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i3 = i + iFloatToIntBits;
                    break;
                case 1:
                    i = i3 * 53;
                    iFloatToIntBits = Float.floatToIntBits(zbws.zbb(obj, j));
                    i3 = i + iFloatToIntBits;
                    break;
                case 2:
                    i = i3 * 53;
                    jDoubleToLongBits = zbws.zbd(obj, j);
                    byte[] bArr2 = zbuo.zbb;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i3 = i + iFloatToIntBits;
                    break;
                case 3:
                    i = i3 * 53;
                    jDoubleToLongBits = zbws.zbd(obj, j);
                    byte[] bArr3 = zbuo.zbb;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i3 = i + iFloatToIntBits;
                    break;
                case 4:
                    i = i3 * 53;
                    iFloatToIntBits = zbws.zbc(obj, j);
                    i3 = i + iFloatToIntBits;
                    break;
                case 5:
                    i = i3 * 53;
                    jDoubleToLongBits = zbws.zbd(obj, j);
                    byte[] bArr4 = zbuo.zbb;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i3 = i + iFloatToIntBits;
                    break;
                case 6:
                    i = i3 * 53;
                    iFloatToIntBits = zbws.zbc(obj, j);
                    i3 = i + iFloatToIntBits;
                    break;
                case 7:
                    i = i3 * 53;
                    iFloatToIntBits = zbuo.zba(zbws.zbw(obj, j));
                    i3 = i + iFloatToIntBits;
                    break;
                case 8:
                    i = i3 * 53;
                    iFloatToIntBits = ((String) zbws.zbf(obj, j)).hashCode();
                    i3 = i + iFloatToIntBits;
                    break;
                case 9:
                    i2 = i3 * 53;
                    Object objZbf = zbws.zbf(obj, j);
                    if (objZbf != null) {
                        iHashCode = objZbf.hashCode();
                    }
                    i3 = i2 + iHashCode;
                    break;
                case 10:
                    i = i3 * 53;
                    iFloatToIntBits = zbws.zbf(obj, j).hashCode();
                    i3 = i + iFloatToIntBits;
                    break;
                case 11:
                    i = i3 * 53;
                    iFloatToIntBits = zbws.zbc(obj, j);
                    i3 = i + iFloatToIntBits;
                    break;
                case 12:
                    i = i3 * 53;
                    iFloatToIntBits = zbws.zbc(obj, j);
                    i3 = i + iFloatToIntBits;
                    break;
                case 13:
                    i = i3 * 53;
                    iFloatToIntBits = zbws.zbc(obj, j);
                    i3 = i + iFloatToIntBits;
                    break;
                case 14:
                    i = i3 * 53;
                    jDoubleToLongBits = zbws.zbd(obj, j);
                    byte[] bArr5 = zbuo.zbb;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i3 = i + iFloatToIntBits;
                    break;
                case 15:
                    i = i3 * 53;
                    iFloatToIntBits = zbws.zbc(obj, j);
                    i3 = i + iFloatToIntBits;
                    break;
                case 16:
                    i = i3 * 53;
                    jDoubleToLongBits = zbws.zbd(obj, j);
                    byte[] bArr6 = zbuo.zbb;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i3 = i + iFloatToIntBits;
                    break;
                case 17:
                    i2 = i3 * 53;
                    Object objZbf2 = zbws.zbf(obj, j);
                    if (objZbf2 != null) {
                        iHashCode = objZbf2.hashCode();
                    }
                    i3 = i2 + iHashCode;
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case MotionEventCompat.AXIS_GENERIC_7 /* 38 */:
                case 39:
                case 40:
                case 41:
                case MotionEventCompat.AXIS_GENERIC_11 /* 42 */:
                case MotionEventCompat.AXIS_GENERIC_12 /* 43 */:
                case 44:
                case 45:
                case MotionEventCompat.AXIS_GENERIC_15 /* 46 */:
                case MotionEventCompat.AXIS_GENERIC_16 /* 47 */:
                case 48:
                case 49:
                    i = i3 * 53;
                    iFloatToIntBits = zbws.zbf(obj, j).hashCode();
                    i3 = i + iFloatToIntBits;
                    break;
                case 50:
                    i = i3 * 53;
                    iFloatToIntBits = zbws.zbf(obj, j).hashCode();
                    i3 = i + iFloatToIntBits;
                    break;
                case StylePropertiesKt.BackgroundBrushId /* 51 */:
                    if (zbM(obj, i6, i4)) {
                        i = i3 * 53;
                        jDoubleToLongBits = Double.doubleToLongBits(zbm(obj, j));
                        byte[] bArr7 = zbuo.zbb;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i3 = i + iFloatToIntBits;
                    }
                    break;
                case StylePropertiesKt.ForegroundBrushId /* 52 */:
                    if (zbM(obj, i6, i4)) {
                        i = i3 * 53;
                        iFloatToIntBits = Float.floatToIntBits(zbn(obj, j));
                        i3 = i + iFloatToIntBits;
                    }
                    break;
                case StylePropertiesKt.ShapeId /* 53 */:
                    if (zbM(obj, i6, i4)) {
                        i = i3 * 53;
                        jDoubleToLongBits = zbt(obj, j);
                        byte[] bArr8 = zbuo.zbb;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i3 = i + iFloatToIntBits;
                    }
                    break;
                case StylePropertiesKt.ColorFilterId /* 54 */:
                    if (zbM(obj, i6, i4)) {
                        i = i3 * 53;
                        jDoubleToLongBits = zbt(obj, j);
                        byte[] bArr9 = zbuo.zbb;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i3 = i + iFloatToIntBits;
                    }
                    break;
                case StylePropertiesKt.DropShadowId /* 55 */:
                    if (zbM(obj, i6, i4)) {
                        i = i3 * 53;
                        iFloatToIntBits = zbo(obj, j);
                        i3 = i + iFloatToIntBits;
                    }
                    break;
                case StylePropertiesKt.InnerShadowId /* 56 */:
                    if (zbM(obj, i6, i4)) {
                        i = i3 * 53;
                        jDoubleToLongBits = zbt(obj, j);
                        byte[] bArr10 = zbuo.zbb;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i3 = i + iFloatToIntBits;
                    }
                    break;
                case StylePropertiesKt.ContentBrushId /* 57 */:
                    if (zbM(obj, i6, i4)) {
                        i = i3 * 53;
                        iFloatToIntBits = zbo(obj, j);
                        i3 = i + iFloatToIntBits;
                    }
                    break;
                case StylePropertiesKt.FontFamilyId /* 58 */:
                    if (zbM(obj, i6, i4)) {
                        i = i3 * 53;
                        iFloatToIntBits = zbuo.zba(zbN(obj, j));
                        i3 = i + iFloatToIntBits;
                    }
                    break;
                case StylePropertiesKt.TextMotionId /* 59 */:
                    if (zbM(obj, i6, i4)) {
                        i = i3 * 53;
                        iFloatToIntBits = ((String) zbws.zbf(obj, j)).hashCode();
                        i3 = i + iFloatToIntBits;
                    }
                    break;
                case 60:
                    if (zbM(obj, i6, i4)) {
                        i = i3 * 53;
                        iFloatToIntBits = zbws.zbf(obj, j).hashCode();
                        i3 = i + iFloatToIntBits;
                    }
                    break;
                case 61:
                    if (zbM(obj, i6, i4)) {
                        i = i3 * 53;
                        iFloatToIntBits = zbws.zbf(obj, j).hashCode();
                        i3 = i + iFloatToIntBits;
                    }
                    break;
                case RectListKt.BitOffsetForGesturable /* 62 */:
                    if (zbM(obj, i6, i4)) {
                        i = i3 * 53;
                        iFloatToIntBits = zbo(obj, j);
                        i3 = i + iFloatToIntBits;
                    }
                    break;
                case 63:
                    if (zbM(obj, i6, i4)) {
                        i = i3 * 53;
                        iFloatToIntBits = zbo(obj, j);
                        i3 = i + iFloatToIntBits;
                    }
                    break;
                case 64:
                    if (zbM(obj, i6, i4)) {
                        i = i3 * 53;
                        iFloatToIntBits = zbo(obj, j);
                        i3 = i + iFloatToIntBits;
                    }
                    break;
                case 65:
                    if (zbM(obj, i6, i4)) {
                        i = i3 * 53;
                        jDoubleToLongBits = zbt(obj, j);
                        byte[] bArr11 = zbuo.zbb;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i3 = i + iFloatToIntBits;
                    }
                    break;
                case 66:
                    if (zbM(obj, i6, i4)) {
                        i = i3 * 53;
                        iFloatToIntBits = zbo(obj, j);
                        i3 = i + iFloatToIntBits;
                    }
                    break;
                case 67:
                    if (zbM(obj, i6, i4)) {
                        i = i3 * 53;
                        jDoubleToLongBits = zbt(obj, j);
                        byte[] bArr12 = zbuo.zbb;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i3 = i + iFloatToIntBits;
                    }
                    break;
                case 68:
                    if (zbM(obj, i6, i4)) {
                        i = i3 * 53;
                        iFloatToIntBits = zbws.zbf(obj, j).hashCode();
                        i3 = i + iFloatToIntBits;
                    }
                    break;
            }
        }
        int iHashCode2 = (i3 * 53) + ((zbuf) obj).zbc.hashCode();
        return this.zbh ? (iHashCode2 * 53) + ((zbub) obj).zbb.zba.hashCode() : iHashCode2;
    }

    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached with updateSeq = 39901. Try increasing type updates limit count.
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:79)
        */
    final int zbc(java.lang.Object r37, byte[] r38, int r39, int r40, int r41, com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbsq r42) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 3990
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbvp.zbc(java.lang.Object, byte[], int, int, int, com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbsq):int");
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbvx
    public final Object zbe() {
        return ((zbuf) this.zbg).zbt();
    }

    /* JADX WARN: Code duplicated, block: B:26:0x0071  */
    /* JADX WARN: Code duplicated, block: B:28:0x0077  */
    /* JADX WARN: Code duplicated, block: B:41:0x0084 A[SYNTHETIC] */
    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbvx
    public final void zbf(Object obj) {
        if (zbL(obj)) {
            if (obj instanceof zbuf) {
                zbuf zbufVar = (zbuf) obj;
                zbufVar.zbE(Integer.MAX_VALUE);
                zbufVar.zba = 0;
                zbufVar.zbC();
            }
            int[] iArr = this.zbc;
            for (int i = 0; i < iArr.length; i += 3) {
                int iZbs = zbs(i);
                int i2 = 1048575 & iZbs;
                int iZbr = zbr(iZbs);
                long j = i2;
                if (iZbr != 9) {
                    if (iZbr != 60 && iZbr != 68) {
                        switch (iZbr) {
                            case 17:
                                if (zbI(obj, i)) {
                                    zbv(i).zbf(zbb.getObject(obj, j));
                                }
                                break;
                            case 18:
                            case 19:
                            case 20:
                            case 21:
                            case 22:
                            case 23:
                            case 24:
                            case 25:
                            case 26:
                            case 27:
                            case 28:
                            case 29:
                            case 30:
                            case 31:
                            case 32:
                            case 33:
                            case 34:
                            case 35:
                            case 36:
                            case 37:
                            case MotionEventCompat.AXIS_GENERIC_7 /* 38 */:
                            case 39:
                            case 40:
                            case 41:
                            case MotionEventCompat.AXIS_GENERIC_11 /* 42 */:
                            case MotionEventCompat.AXIS_GENERIC_12 /* 43 */:
                            case 44:
                            case 45:
                            case MotionEventCompat.AXIS_GENERIC_15 /* 46 */:
                            case MotionEventCompat.AXIS_GENERIC_16 /* 47 */:
                            case 48:
                            case 49:
                                ((zbun) zbws.zbf(obj, j)).zbb();
                                break;
                            case 50:
                                Unsafe unsafe = zbb;
                                Object object = unsafe.getObject(obj, j);
                                if (object != null) {
                                    ((zbvg) object).zbc();
                                    unsafe.putObject(obj, j, object);
                                }
                                break;
                        }
                    } else if (zbM(obj, this.zbc[i], i)) {
                        zbv(i).zbf(zbb.getObject(obj, j));
                    }
                } else if (zbI(obj, i)) {
                    zbv(i).zbf(zbb.getObject(obj, j));
                }
            }
            this.zbl.zbb(obj);
            if (this.zbh) {
                this.zbm.zba(obj);
            }
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbvx
    public final void zbg(Object obj, Object obj2) {
        zbA(obj);
        obj2.getClass();
        for (int i = 0; i < this.zbc.length; i += 3) {
            int iZbs = zbs(i);
            int i2 = 1048575 & iZbs;
            int[] iArr = this.zbc;
            int iZbr = zbr(iZbs);
            int i3 = iArr[i];
            long j = i2;
            switch (iZbr) {
                case 0:
                    if (zbI(obj2, i)) {
                        zbws.zbo(obj, j, zbws.zba(obj2, j));
                        zbD(obj, i);
                    }
                    break;
                case 1:
                    if (zbI(obj2, i)) {
                        zbws.zbp(obj, j, zbws.zbb(obj2, j));
                        zbD(obj, i);
                    }
                    break;
                case 2:
                    if (zbI(obj2, i)) {
                        zbws.zbr(obj, j, zbws.zbd(obj2, j));
                        zbD(obj, i);
                    }
                    break;
                case 3:
                    if (zbI(obj2, i)) {
                        zbws.zbr(obj, j, zbws.zbd(obj2, j));
                        zbD(obj, i);
                    }
                    break;
                case 4:
                    if (zbI(obj2, i)) {
                        zbws.zbq(obj, j, zbws.zbc(obj2, j));
                        zbD(obj, i);
                    }
                    break;
                case 5:
                    if (zbI(obj2, i)) {
                        zbws.zbr(obj, j, zbws.zbd(obj2, j));
                        zbD(obj, i);
                    }
                    break;
                case 6:
                    if (zbI(obj2, i)) {
                        zbws.zbq(obj, j, zbws.zbc(obj2, j));
                        zbD(obj, i);
                    }
                    break;
                case 7:
                    if (zbI(obj2, i)) {
                        zbws.zbm(obj, j, zbws.zbw(obj2, j));
                        zbD(obj, i);
                    }
                    break;
                case 8:
                    if (zbI(obj2, i)) {
                        zbws.zbs(obj, j, zbws.zbf(obj2, j));
                        zbD(obj, i);
                    }
                    break;
                case 9:
                    zbB(obj, obj2, i);
                    break;
                case 10:
                    if (zbI(obj2, i)) {
                        zbws.zbs(obj, j, zbws.zbf(obj2, j));
                        zbD(obj, i);
                    }
                    break;
                case 11:
                    if (zbI(obj2, i)) {
                        zbws.zbq(obj, j, zbws.zbc(obj2, j));
                        zbD(obj, i);
                    }
                    break;
                case 12:
                    if (zbI(obj2, i)) {
                        zbws.zbq(obj, j, zbws.zbc(obj2, j));
                        zbD(obj, i);
                    }
                    break;
                case 13:
                    if (zbI(obj2, i)) {
                        zbws.zbq(obj, j, zbws.zbc(obj2, j));
                        zbD(obj, i);
                    }
                    break;
                case 14:
                    if (zbI(obj2, i)) {
                        zbws.zbr(obj, j, zbws.zbd(obj2, j));
                        zbD(obj, i);
                    }
                    break;
                case 15:
                    if (zbI(obj2, i)) {
                        zbws.zbq(obj, j, zbws.zbc(obj2, j));
                        zbD(obj, i);
                    }
                    break;
                case 16:
                    if (zbI(obj2, i)) {
                        zbws.zbr(obj, j, zbws.zbd(obj2, j));
                        zbD(obj, i);
                    }
                    break;
                case 17:
                    zbB(obj, obj2, i);
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case MotionEventCompat.AXIS_GENERIC_7 /* 38 */:
                case 39:
                case 40:
                case 41:
                case MotionEventCompat.AXIS_GENERIC_11 /* 42 */:
                case MotionEventCompat.AXIS_GENERIC_12 /* 43 */:
                case 44:
                case 45:
                case MotionEventCompat.AXIS_GENERIC_15 /* 46 */:
                case MotionEventCompat.AXIS_GENERIC_16 /* 47 */:
                case 48:
                case 49:
                    zbun zbunVarZbd = (zbun) zbws.zbf(obj, j);
                    zbun zbunVar = (zbun) zbws.zbf(obj2, j);
                    int size = zbunVarZbd.size();
                    int size2 = zbunVar.size();
                    if (size > 0 && size2 > 0) {
                        if (!zbunVarZbd.zbc()) {
                            zbunVarZbd = zbunVarZbd.zbd(size2 + size);
                        }
                        zbunVarZbd.addAll(zbunVar);
                    }
                    if (size > 0) {
                        zbunVar = zbunVarZbd;
                    }
                    zbws.zbs(obj, j, zbunVar);
                    break;
                case 50:
                    int i4 = zbvz.zba;
                    zbws.zbs(obj, j, zbvh.zba(zbws.zbf(obj, j), zbws.zbf(obj2, j)));
                    break;
                case StylePropertiesKt.BackgroundBrushId /* 51 */:
                case StylePropertiesKt.ForegroundBrushId /* 52 */:
                case StylePropertiesKt.ShapeId /* 53 */:
                case StylePropertiesKt.ColorFilterId /* 54 */:
                case StylePropertiesKt.DropShadowId /* 55 */:
                case StylePropertiesKt.InnerShadowId /* 56 */:
                case StylePropertiesKt.ContentBrushId /* 57 */:
                case StylePropertiesKt.FontFamilyId /* 58 */:
                case StylePropertiesKt.TextMotionId /* 59 */:
                    if (zbM(obj2, i3, i)) {
                        zbws.zbs(obj, j, zbws.zbf(obj2, j));
                        zbE(obj, i3, i);
                    }
                    break;
                case 60:
                    zbC(obj, obj2, i);
                    break;
                case 61:
                case RectListKt.BitOffsetForGesturable /* 62 */:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                    if (zbM(obj2, i3, i)) {
                        zbws.zbs(obj, j, zbws.zbf(obj2, j));
                        zbE(obj, i3, i);
                    }
                    break;
                case 68:
                    zbC(obj, obj2, i);
                    break;
            }
        }
        zbvz.zbp(this.zbl, obj, obj2);
        if (this.zbh) {
            zbvz.zbo(this.zbm, obj, obj2);
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbvx
    public final void zbh(Object obj, byte[] bArr, int i, int i2, zbsq zbsqVar) throws IOException {
        zbc(obj, bArr, i, i2, 0, zbsqVar);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:100:0x0212  */
    /* JADX WARN: Code duplicated, block: B:101:0x0223  */
    /* JADX WARN: Code duplicated, block: B:102:0x0234  */
    /* JADX WARN: Code duplicated, block: B:103:0x0245  */
    /* JADX WARN: Code duplicated, block: B:104:0x0256  */
    /* JADX WARN: Code duplicated, block: B:105:0x0267  */
    /* JADX WARN: Code duplicated, block: B:106:0x0278  */
    /* JADX WARN: Code duplicated, block: B:107:0x0289  */
    /* JADX WARN: Code duplicated, block: B:108:0x029a  */
    /* JADX WARN: Code duplicated, block: B:109:0x02ab  */
    /* JADX WARN: Code duplicated, block: B:110:0x02bc  */
    /* JADX WARN: Code duplicated, block: B:111:0x02cd  */
    /* JADX WARN: Code duplicated, block: B:112:0x02de  */
    /* JADX WARN: Code duplicated, block: B:113:0x02ee  */
    /* JADX WARN: Code duplicated, block: B:114:0x02fe  */
    /* JADX WARN: Code duplicated, block: B:115:0x030e  */
    /* JADX WARN: Code duplicated, block: B:116:0x031e  */
    /* JADX WARN: Code duplicated, block: B:117:0x032e  */
    /* JADX WARN: Code duplicated, block: B:118:0x033e  */
    /* JADX WARN: Code duplicated, block: B:123:0x0357  */
    /* JADX WARN: Code duplicated, block: B:130:0x0376 A[LOOP:3: B:128:0x0370->B:130:0x0376, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:131:0x0383  */
    /* JADX WARN: Code duplicated, block: B:136:0x039c  */
    /* JADX WARN: Code duplicated, block: B:137:0x03ac  */
    /* JADX WARN: Code duplicated, block: B:138:0x03bc  */
    /* JADX WARN: Code duplicated, block: B:139:0x03cc  */
    /* JADX WARN: Code duplicated, block: B:140:0x03dc  */
    /* JADX WARN: Code duplicated, block: B:141:0x03ec  */
    /* JADX WARN: Code duplicated, block: B:142:0x03fc  */
    /* JADX WARN: Code duplicated, block: B:143:0x040c  */
    /* JADX WARN: Code duplicated, block: B:144:0x041c  */
    /* JADX WARN: Code duplicated, block: B:146:0x0423  */
    /* JADX WARN: Code duplicated, block: B:147:0x0430  */
    /* JADX WARN: Code duplicated, block: B:149:0x0437  */
    /* JADX WARN: Code duplicated, block: B:150:0x0440  */
    /* JADX WARN: Code duplicated, block: B:152:0x0447  */
    /* JADX WARN: Code duplicated, block: B:153:0x0450  */
    /* JADX WARN: Code duplicated, block: B:155:0x0457  */
    /* JADX WARN: Code duplicated, block: B:156:0x0460  */
    /* JADX WARN: Code duplicated, block: B:158:0x0467  */
    /* JADX WARN: Code duplicated, block: B:159:0x0470  */
    /* JADX WARN: Code duplicated, block: B:161:0x0477  */
    /* JADX WARN: Code duplicated, block: B:162:0x0480  */
    /* JADX WARN: Code duplicated, block: B:164:0x0487  */
    /* JADX WARN: Code duplicated, block: B:165:0x0490  */
    /* JADX WARN: Code duplicated, block: B:167:0x0497  */
    /* JADX WARN: Code duplicated, block: B:168:0x04a2  */
    /* JADX WARN: Code duplicated, block: B:170:0x04a9  */
    /* JADX WARN: Code duplicated, block: B:171:0x04b6  */
    /* JADX WARN: Code duplicated, block: B:173:0x04bd  */
    /* JADX WARN: Code duplicated, block: B:174:0x04c5  */
    /* JADX WARN: Code duplicated, block: B:176:0x04cc  */
    /* JADX WARN: Code duplicated, block: B:177:0x04d4  */
    /* JADX WARN: Code duplicated, block: B:179:0x04db  */
    /* JADX WARN: Code duplicated, block: B:180:0x04e3  */
    /* JADX WARN: Code duplicated, block: B:182:0x04ea  */
    /* JADX WARN: Code duplicated, block: B:183:0x04f2  */
    /* JADX WARN: Code duplicated, block: B:185:0x04f9  */
    /* JADX WARN: Code duplicated, block: B:186:0x0501  */
    /* JADX WARN: Code duplicated, block: B:188:0x0508  */
    /* JADX WARN: Code duplicated, block: B:189:0x0510  */
    /* JADX WARN: Code duplicated, block: B:191:0x0517  */
    /* JADX WARN: Code duplicated, block: B:192:0x051f  */
    /* JADX WARN: Code duplicated, block: B:194:0x0526  */
    /* JADX WARN: Code duplicated, block: B:196:0x0530  */
    /* JADX WARN: Code duplicated, block: B:198:0x0537  */
    /* JADX WARN: Code duplicated, block: B:224:0x053e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:226:0x053e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:229:0x053e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:32:0x009a  */
    /* JADX WARN: Code duplicated, block: B:33:0x009d  */
    /* JADX WARN: Code duplicated, block: B:35:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:36:0x00af  */
    /* JADX WARN: Code duplicated, block: B:38:0x00b5  */
    /* JADX WARN: Code duplicated, block: B:39:0x00bd  */
    /* JADX WARN: Code duplicated, block: B:41:0x00c3  */
    /* JADX WARN: Code duplicated, block: B:42:0x00cb  */
    /* JADX WARN: Code duplicated, block: B:44:0x00d1  */
    /* JADX WARN: Code duplicated, block: B:45:0x00d9  */
    /* JADX WARN: Code duplicated, block: B:47:0x00df  */
    /* JADX WARN: Code duplicated, block: B:48:0x00e7  */
    /* JADX WARN: Code duplicated, block: B:50:0x00ed  */
    /* JADX WARN: Code duplicated, block: B:51:0x00f5  */
    /* JADX WARN: Code duplicated, block: B:53:0x00fb  */
    /* JADX WARN: Code duplicated, block: B:54:0x0103  */
    /* JADX WARN: Code duplicated, block: B:56:0x0109  */
    /* JADX WARN: Code duplicated, block: B:57:0x0113  */
    /* JADX WARN: Code duplicated, block: B:59:0x0119  */
    /* JADX WARN: Code duplicated, block: B:60:0x0126  */
    /* JADX WARN: Code duplicated, block: B:62:0x012c  */
    /* JADX WARN: Code duplicated, block: B:63:0x0135  */
    /* JADX WARN: Code duplicated, block: B:65:0x013b  */
    /* JADX WARN: Code duplicated, block: B:66:0x0144  */
    /* JADX WARN: Code duplicated, block: B:68:0x014a  */
    /* JADX WARN: Code duplicated, block: B:69:0x0153  */
    /* JADX WARN: Code duplicated, block: B:71:0x0159  */
    /* JADX WARN: Code duplicated, block: B:72:0x0162  */
    /* JADX WARN: Code duplicated, block: B:74:0x0168  */
    /* JADX WARN: Code duplicated, block: B:75:0x0171  */
    /* JADX WARN: Code duplicated, block: B:77:0x0177  */
    /* JADX WARN: Code duplicated, block: B:78:0x0180  */
    /* JADX WARN: Code duplicated, block: B:7:0x0023  */
    /* JADX WARN: Code duplicated, block: B:80:0x0186  */
    /* JADX WARN: Code duplicated, block: B:81:0x018f  */
    /* JADX WARN: Code duplicated, block: B:83:0x0195  */
    /* JADX WARN: Code duplicated, block: B:84:0x019e  */
    /* JADX WARN: Code duplicated, block: B:86:0x01a4  */
    /* JADX WARN: Code duplicated, block: B:87:0x01ad  */
    /* JADX WARN: Code duplicated, block: B:89:0x01b3  */
    /* JADX WARN: Code duplicated, block: B:90:0x01c4  */
    /* JADX WARN: Code duplicated, block: B:97:0x01e3 A[LOOP:2: B:95:0x01dd->B:97:0x01e3, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:98:0x01f0  */
    /* JADX WARN: Code duplicated, block: B:99:0x0201  */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbvx
    public final void zbi(Object obj, zbwy zbwyVar) throws IOException {
        Map.Entry entry;
        Iterator it;
        int i;
        int i2;
        int i3;
        int i4;
        long j;
        int i5;
        List list;
        int i6;
        List list2;
        zbvx zbvxVarZbv;
        int i7;
        int i8;
        List list3;
        int i9;
        List list4;
        zbvx zbvxVarZbv2;
        int i10;
        Object object;
        zbvp<T> zbvpVar = this;
        if (zbvpVar.zbh) {
            zbtu zbtuVar = ((zbub) obj).zbb;
            if (zbtuVar.zba.isEmpty()) {
                entry = null;
                it = null;
            } else {
                Iterator itZbg = zbtuVar.zbg();
                entry = (Map.Entry) itZbg.next();
                it = itZbg;
            }
        } else {
            entry = null;
            it = null;
        }
        int[] iArr = zbvpVar.zbc;
        Unsafe unsafe = zbb;
        int i11 = 0;
        int i12 = 1048575;
        int i13 = 0;
        while (i11 < iArr.length) {
            int iZbs = zbvpVar.zbs(i11);
            int[] iArr2 = zbvpVar.zbc;
            int iZbr = zbr(iZbs);
            int i14 = iArr2[i11];
            if (iZbr <= 17) {
                int i15 = iArr2[i11 + 2];
                int i16 = i15 & 1048575;
                if (i16 != i12) {
                    i = 1;
                    i13 = i16 == 1048575 ? 0 : unsafe.getInt(obj, i16);
                    i12 = i16;
                } else {
                    i = 1;
                }
                i2 = i12;
                i3 = i13;
                i4 = i << (i15 >>> 20);
            } else {
                i = 1;
                i2 = i12;
                i3 = i13;
                i4 = 0;
            }
            while (entry != null) {
                if (i14 >= 32149011) {
                    zbvpVar.zbm.zbb(zbwyVar, entry);
                    entry = it.hasNext() ? (Map.Entry) it.next() : null;
                } else {
                    j = iZbs & 1048575;
                    switch (iZbr) {
                        case 0:
                            if (zbvpVar.zbJ(obj, i11, i2, i3, i4)) {
                                zbwyVar.zbf(i14, zbws.zba(obj, j));
                            }
                            break;
                        case 1:
                            if (zbvpVar.zbJ(obj, i11, i2, i3, i4)) {
                                zbwyVar.zbo(i14, zbws.zbb(obj, j));
                            }
                            zbvpVar = this;
                            break;
                        case 2:
                            if (zbvpVar.zbJ(obj, i11, i2, i3, i4)) {
                                zbwyVar.zbt(i14, unsafe.getLong(obj, j));
                            }
                            zbvpVar = this;
                            break;
                        case 3:
                            if (zbvpVar.zbJ(obj, i11, i2, i3, i4)) {
                                zbwyVar.zbL(i14, unsafe.getLong(obj, j));
                            }
                            zbvpVar = this;
                            break;
                        case 4:
                            if (zbvpVar.zbJ(obj, i11, i2, i3, i4)) {
                                zbwyVar.zbr(i14, unsafe.getInt(obj, j));
                            }
                            zbvpVar = this;
                            break;
                        case 5:
                            if (zbvpVar.zbJ(obj, i11, i2, i3, i4)) {
                                zbwyVar.zbm(i14, unsafe.getLong(obj, j));
                            }
                            zbvpVar = this;
                            break;
                        case 6:
                            if (zbvpVar.zbJ(obj, i11, i2, i3, i4)) {
                                zbwyVar.zbk(i14, unsafe.getInt(obj, j));
                            }
                            zbvpVar = this;
                            break;
                        case 7:
                            if (zbvpVar.zbJ(obj, i11, i2, i3, i4)) {
                                zbwyVar.zbb(i14, zbws.zbw(obj, j));
                            }
                            zbvpVar = this;
                            break;
                        case 8:
                            if (zbvpVar.zbJ(obj, i11, i2, i3, i4)) {
                                zbP(i14, unsafe.getObject(obj, j), zbwyVar);
                            }
                            zbvpVar = this;
                            break;
                        case 9:
                            if (zbvpVar.zbJ(obj, i11, i2, i3, i4)) {
                                zbwyVar.zbw(i14, unsafe.getObject(obj, j), zbvpVar.zbv(i11));
                            }
                            break;
                        case 10:
                            if (zbvpVar.zbJ(obj, i11, i2, i3, i4)) {
                                zbwyVar.zbd(i14, (zbtc) unsafe.getObject(obj, j));
                            }
                            zbvpVar = this;
                            break;
                        case 11:
                            if (zbvpVar.zbJ(obj, i11, i2, i3, i4)) {
                                zbwyVar.zbJ(i14, unsafe.getInt(obj, j));
                            }
                            zbvpVar = this;
                            break;
                        case 12:
                            if (zbvpVar.zbJ(obj, i11, i2, i3, i4)) {
                                zbwyVar.zbi(i14, unsafe.getInt(obj, j));
                            }
                            zbvpVar = this;
                            break;
                        case 13:
                            if (zbvpVar.zbJ(obj, i11, i2, i3, i4)) {
                                zbwyVar.zby(i14, unsafe.getInt(obj, j));
                            }
                            zbvpVar = this;
                            break;
                        case 14:
                            if (zbvpVar.zbJ(obj, i11, i2, i3, i4)) {
                                zbwyVar.zbA(i14, unsafe.getLong(obj, j));
                            }
                            zbvpVar = this;
                            break;
                        case 15:
                            if (zbvpVar.zbJ(obj, i11, i2, i3, i4)) {
                                zbwyVar.zbC(i14, unsafe.getInt(obj, j));
                            }
                            zbvpVar = this;
                            break;
                        case 16:
                            if (zbvpVar.zbJ(obj, i11, i2, i3, i4)) {
                                zbwyVar.zbE(i14, unsafe.getLong(obj, j));
                            }
                            zbvpVar = this;
                            break;
                        case 17:
                            if (zbvpVar.zbJ(obj, i11, i2, i3, i4)) {
                                zbwyVar.zbq(i14, unsafe.getObject(obj, j), zbvpVar.zbv(i11));
                            }
                            break;
                        case 18:
                            zbvz.zbr(zbvpVar.zbc[i11], (List) unsafe.getObject(obj, j), zbwyVar, false);
                            break;
                        case 19:
                            zbvz.zbv(zbvpVar.zbc[i11], (List) unsafe.getObject(obj, j), zbwyVar, false);
                            break;
                        case 20:
                            zbvz.zbx(zbvpVar.zbc[i11], (List) unsafe.getObject(obj, j), zbwyVar, false);
                            break;
                        case 21:
                            zbvz.zbD(zbvpVar.zbc[i11], (List) unsafe.getObject(obj, j), zbwyVar, false);
                            break;
                        case 22:
                            zbvz.zbw(zbvpVar.zbc[i11], (List) unsafe.getObject(obj, j), zbwyVar, false);
                            break;
                        case 23:
                            zbvz.zbu(zbvpVar.zbc[i11], (List) unsafe.getObject(obj, j), zbwyVar, false);
                            break;
                        case 24:
                            zbvz.zbt(zbvpVar.zbc[i11], (List) unsafe.getObject(obj, j), zbwyVar, false);
                            break;
                        case 25:
                            zbvz.zbq(zbvpVar.zbc[i11], (List) unsafe.getObject(obj, j), zbwyVar, false);
                            break;
                        case 26:
                            i5 = zbvpVar.zbc[i11];
                            list = (List) unsafe.getObject(obj, j);
                            int i17 = zbvz.zba;
                            if (list != null && !list.isEmpty()) {
                                zbwyVar.zbI(i5, list);
                            }
                            break;
                        case 27:
                            i6 = zbvpVar.zbc[i11];
                            list2 = (List) unsafe.getObject(obj, j);
                            zbvxVarZbv = zbvpVar.zbv(i11);
                            int i18 = zbvz.zba;
                            if (list2 != null && !list2.isEmpty()) {
                                for (i7 = 0; i7 < list2.size(); i7++) {
                                    ((zbtl) zbwyVar).zbw(i6, list2.get(i7), zbvxVarZbv);
                                }
                            }
                            break;
                        case 28:
                            i8 = zbvpVar.zbc[i11];
                            list3 = (List) unsafe.getObject(obj, j);
                            int i19 = zbvz.zba;
                            if (list3 != null && !list3.isEmpty()) {
                                zbwyVar.zbe(i8, list3);
                            }
                            break;
                        case 29:
                            zbvz.zbC(zbvpVar.zbc[i11], (List) unsafe.getObject(obj, j), zbwyVar, false);
                            break;
                        case 30:
                            zbvz.zbs(zbvpVar.zbc[i11], (List) unsafe.getObject(obj, j), zbwyVar, false);
                            break;
                        case 31:
                            zbvz.zby(zbvpVar.zbc[i11], (List) unsafe.getObject(obj, j), zbwyVar, false);
                            break;
                        case 32:
                            zbvz.zbz(zbvpVar.zbc[i11], (List) unsafe.getObject(obj, j), zbwyVar, false);
                            break;
                        case 33:
                            zbvz.zbA(zbvpVar.zbc[i11], (List) unsafe.getObject(obj, j), zbwyVar, false);
                            break;
                        case 34:
                            zbvz.zbB(zbvpVar.zbc[i11], (List) unsafe.getObject(obj, j), zbwyVar, false);
                            break;
                        case 35:
                            zbvz.zbr(zbvpVar.zbc[i11], (List) unsafe.getObject(obj, j), zbwyVar, i);
                            break;
                        case 36:
                            zbvz.zbv(zbvpVar.zbc[i11], (List) unsafe.getObject(obj, j), zbwyVar, i);
                            break;
                        case 37:
                            zbvz.zbx(zbvpVar.zbc[i11], (List) unsafe.getObject(obj, j), zbwyVar, i);
                            break;
                        case MotionEventCompat.AXIS_GENERIC_7 /* 38 */:
                            zbvz.zbD(zbvpVar.zbc[i11], (List) unsafe.getObject(obj, j), zbwyVar, i);
                            break;
                        case 39:
                            zbvz.zbw(zbvpVar.zbc[i11], (List) unsafe.getObject(obj, j), zbwyVar, i);
                            break;
                        case 40:
                            zbvz.zbu(zbvpVar.zbc[i11], (List) unsafe.getObject(obj, j), zbwyVar, i);
                            break;
                        case 41:
                            zbvz.zbt(zbvpVar.zbc[i11], (List) unsafe.getObject(obj, j), zbwyVar, i);
                            break;
                        case MotionEventCompat.AXIS_GENERIC_11 /* 42 */:
                            zbvz.zbq(zbvpVar.zbc[i11], (List) unsafe.getObject(obj, j), zbwyVar, i);
                            break;
                        case MotionEventCompat.AXIS_GENERIC_12 /* 43 */:
                            zbvz.zbC(zbvpVar.zbc[i11], (List) unsafe.getObject(obj, j), zbwyVar, i);
                            break;
                        case 44:
                            zbvz.zbs(zbvpVar.zbc[i11], (List) unsafe.getObject(obj, j), zbwyVar, i);
                            break;
                        case 45:
                            zbvz.zby(zbvpVar.zbc[i11], (List) unsafe.getObject(obj, j), zbwyVar, i);
                            break;
                        case MotionEventCompat.AXIS_GENERIC_15 /* 46 */:
                            zbvz.zbz(zbvpVar.zbc[i11], (List) unsafe.getObject(obj, j), zbwyVar, i);
                            break;
                        case MotionEventCompat.AXIS_GENERIC_16 /* 47 */:
                            zbvz.zbA(zbvpVar.zbc[i11], (List) unsafe.getObject(obj, j), zbwyVar, i);
                            break;
                        case 48:
                            zbvz.zbB(zbvpVar.zbc[i11], (List) unsafe.getObject(obj, j), zbwyVar, i);
                            break;
                        case 49:
                            i9 = zbvpVar.zbc[i11];
                            list4 = (List) unsafe.getObject(obj, j);
                            zbvxVarZbv2 = zbvpVar.zbv(i11);
                            int i20 = zbvz.zba;
                            if (list4 != null && !list4.isEmpty()) {
                                for (i10 = 0; i10 < list4.size(); i10++) {
                                    ((zbtl) zbwyVar).zbq(i9, list4.get(i10), zbvxVarZbv2);
                                }
                            }
                            break;
                        case 50:
                            object = unsafe.getObject(obj, j);
                            if (object != null) {
                                zbwyVar.zbv(i14, ((zbvf) zbvpVar.zbw(i11)).zbc(), (zbvg) object);
                            }
                            break;
                        case StylePropertiesKt.BackgroundBrushId /* 51 */:
                            if (zbvpVar.zbM(obj, i14, i11)) {
                                zbwyVar.zbf(i14, zbm(obj, j));
                            }
                            break;
                        case StylePropertiesKt.ForegroundBrushId /* 52 */:
                            if (zbvpVar.zbM(obj, i14, i11)) {
                                zbwyVar.zbo(i14, zbn(obj, j));
                            }
                            break;
                        case StylePropertiesKt.ShapeId /* 53 */:
                            if (zbvpVar.zbM(obj, i14, i11)) {
                                zbwyVar.zbt(i14, zbt(obj, j));
                            }
                            break;
                        case StylePropertiesKt.ColorFilterId /* 54 */:
                            if (zbvpVar.zbM(obj, i14, i11)) {
                                zbwyVar.zbL(i14, zbt(obj, j));
                            }
                            break;
                        case StylePropertiesKt.DropShadowId /* 55 */:
                            if (zbvpVar.zbM(obj, i14, i11)) {
                                zbwyVar.zbr(i14, zbo(obj, j));
                            }
                            break;
                        case StylePropertiesKt.InnerShadowId /* 56 */:
                            if (zbvpVar.zbM(obj, i14, i11)) {
                                zbwyVar.zbm(i14, zbt(obj, j));
                            }
                            break;
                        case StylePropertiesKt.ContentBrushId /* 57 */:
                            if (zbvpVar.zbM(obj, i14, i11)) {
                                zbwyVar.zbk(i14, zbo(obj, j));
                            }
                            break;
                        case StylePropertiesKt.FontFamilyId /* 58 */:
                            if (zbvpVar.zbM(obj, i14, i11)) {
                                zbwyVar.zbb(i14, zbN(obj, j));
                            }
                            break;
                        case StylePropertiesKt.TextMotionId /* 59 */:
                            if (zbvpVar.zbM(obj, i14, i11)) {
                                zbP(i14, unsafe.getObject(obj, j), zbwyVar);
                            }
                            break;
                        case 60:
                            if (zbvpVar.zbM(obj, i14, i11)) {
                                zbwyVar.zbw(i14, unsafe.getObject(obj, j), zbvpVar.zbv(i11));
                            }
                            break;
                        case 61:
                            if (zbvpVar.zbM(obj, i14, i11)) {
                                zbwyVar.zbd(i14, (zbtc) unsafe.getObject(obj, j));
                            }
                            break;
                        case RectListKt.BitOffsetForGesturable /* 62 */:
                            if (zbvpVar.zbM(obj, i14, i11)) {
                                zbwyVar.zbJ(i14, zbo(obj, j));
                            }
                            break;
                        case 63:
                            if (zbvpVar.zbM(obj, i14, i11)) {
                                zbwyVar.zbi(i14, zbo(obj, j));
                            }
                            break;
                        case 64:
                            if (zbvpVar.zbM(obj, i14, i11)) {
                                zbwyVar.zby(i14, zbo(obj, j));
                            }
                            break;
                        case 65:
                            if (zbvpVar.zbM(obj, i14, i11)) {
                                zbwyVar.zbA(i14, zbt(obj, j));
                            }
                            break;
                        case 66:
                            if (zbvpVar.zbM(obj, i14, i11)) {
                                zbwyVar.zbC(i14, zbo(obj, j));
                            }
                            break;
                        case 67:
                            if (zbvpVar.zbM(obj, i14, i11)) {
                                zbwyVar.zbE(i14, zbt(obj, j));
                            }
                            break;
                        case 68:
                            if (zbvpVar.zbM(obj, i14, i11)) {
                                zbwyVar.zbq(i14, unsafe.getObject(obj, j), zbvpVar.zbv(i11));
                            }
                            break;
                        default:
                            break;
                    }
                    i11 += 3;
                    i13 = i3;
                    i12 = i2;
                    entry = entry;
                }
            }
            j = iZbs & 1048575;
            switch (iZbr) {
                case 0:
                    if (zbvpVar.zbJ(obj, i11, i2, i3, i4)) {
                        zbwyVar.zbf(i14, zbws.zba(obj, j));
                    }
                    break;
                case 1:
                    if (zbvpVar.zbJ(obj, i11, i2, i3, i4)) {
                        zbwyVar.zbo(i14, zbws.zbb(obj, j));
                    }
                    zbvpVar = this;
                    break;
                case 2:
                    if (zbvpVar.zbJ(obj, i11, i2, i3, i4)) {
                        zbwyVar.zbt(i14, unsafe.getLong(obj, j));
                    }
                    zbvpVar = this;
                    break;
                case 3:
                    if (zbvpVar.zbJ(obj, i11, i2, i3, i4)) {
                        zbwyVar.zbL(i14, unsafe.getLong(obj, j));
                    }
                    zbvpVar = this;
                    break;
                case 4:
                    if (zbvpVar.zbJ(obj, i11, i2, i3, i4)) {
                        zbwyVar.zbr(i14, unsafe.getInt(obj, j));
                    }
                    zbvpVar = this;
                    break;
                case 5:
                    if (zbvpVar.zbJ(obj, i11, i2, i3, i4)) {
                        zbwyVar.zbm(i14, unsafe.getLong(obj, j));
                    }
                    zbvpVar = this;
                    break;
                case 6:
                    if (zbvpVar.zbJ(obj, i11, i2, i3, i4)) {
                        zbwyVar.zbk(i14, unsafe.getInt(obj, j));
                    }
                    zbvpVar = this;
                    break;
                case 7:
                    if (zbvpVar.zbJ(obj, i11, i2, i3, i4)) {
                        zbwyVar.zbb(i14, zbws.zbw(obj, j));
                    }
                    zbvpVar = this;
                    break;
                case 8:
                    if (zbvpVar.zbJ(obj, i11, i2, i3, i4)) {
                        zbP(i14, unsafe.getObject(obj, j), zbwyVar);
                    }
                    zbvpVar = this;
                    break;
                case 9:
                    if (zbvpVar.zbJ(obj, i11, i2, i3, i4)) {
                        zbwyVar.zbw(i14, unsafe.getObject(obj, j), zbvpVar.zbv(i11));
                    }
                    break;
                case 10:
                    if (zbvpVar.zbJ(obj, i11, i2, i3, i4)) {
                        zbwyVar.zbd(i14, (zbtc) unsafe.getObject(obj, j));
                    }
                    zbvpVar = this;
                    break;
                case 11:
                    if (zbvpVar.zbJ(obj, i11, i2, i3, i4)) {
                        zbwyVar.zbJ(i14, unsafe.getInt(obj, j));
                    }
                    zbvpVar = this;
                    break;
                case 12:
                    if (zbvpVar.zbJ(obj, i11, i2, i3, i4)) {
                        zbwyVar.zbi(i14, unsafe.getInt(obj, j));
                    }
                    zbvpVar = this;
                    break;
                case 13:
                    if (zbvpVar.zbJ(obj, i11, i2, i3, i4)) {
                        zbwyVar.zby(i14, unsafe.getInt(obj, j));
                    }
                    zbvpVar = this;
                    break;
                case 14:
                    if (zbvpVar.zbJ(obj, i11, i2, i3, i4)) {
                        zbwyVar.zbA(i14, unsafe.getLong(obj, j));
                    }
                    zbvpVar = this;
                    break;
                case 15:
                    if (zbvpVar.zbJ(obj, i11, i2, i3, i4)) {
                        zbwyVar.zbC(i14, unsafe.getInt(obj, j));
                    }
                    zbvpVar = this;
                    break;
                case 16:
                    if (zbvpVar.zbJ(obj, i11, i2, i3, i4)) {
                        zbwyVar.zbE(i14, unsafe.getLong(obj, j));
                    }
                    zbvpVar = this;
                    break;
                case 17:
                    if (zbvpVar.zbJ(obj, i11, i2, i3, i4)) {
                        zbwyVar.zbq(i14, unsafe.getObject(obj, j), zbvpVar.zbv(i11));
                    }
                    break;
                case 18:
                    zbvz.zbr(zbvpVar.zbc[i11], (List) unsafe.getObject(obj, j), zbwyVar, false);
                    break;
                case 19:
                    zbvz.zbv(zbvpVar.zbc[i11], (List) unsafe.getObject(obj, j), zbwyVar, false);
                    break;
                case 20:
                    zbvz.zbx(zbvpVar.zbc[i11], (List) unsafe.getObject(obj, j), zbwyVar, false);
                    break;
                case 21:
                    zbvz.zbD(zbvpVar.zbc[i11], (List) unsafe.getObject(obj, j), zbwyVar, false);
                    break;
                case 22:
                    zbvz.zbw(zbvpVar.zbc[i11], (List) unsafe.getObject(obj, j), zbwyVar, false);
                    break;
                case 23:
                    zbvz.zbu(zbvpVar.zbc[i11], (List) unsafe.getObject(obj, j), zbwyVar, false);
                    break;
                case 24:
                    zbvz.zbt(zbvpVar.zbc[i11], (List) unsafe.getObject(obj, j), zbwyVar, false);
                    break;
                case 25:
                    zbvz.zbq(zbvpVar.zbc[i11], (List) unsafe.getObject(obj, j), zbwyVar, false);
                    break;
                case 26:
                    i5 = zbvpVar.zbc[i11];
                    list = (List) unsafe.getObject(obj, j);
                    int i110 = zbvz.zba;
                    if (list != null) {
                        zbwyVar.zbI(i5, list);
                    }
                    break;
                case 27:
                    i6 = zbvpVar.zbc[i11];
                    list2 = (List) unsafe.getObject(obj, j);
                    zbvxVarZbv = zbvpVar.zbv(i11);
                    int i111 = zbvz.zba;
                    if (list2 != null) {
                        while (i7 < list2.size()) {
                            ((zbtl) zbwyVar).zbw(i6, list2.get(i7), zbvxVarZbv);
                        }
                    }
                    break;
                case 28:
                    i8 = zbvpVar.zbc[i11];
                    list3 = (List) unsafe.getObject(obj, j);
                    int i112 = zbvz.zba;
                    if (list3 != null) {
                        zbwyVar.zbe(i8, list3);
                    }
                    break;
                case 29:
                    zbvz.zbC(zbvpVar.zbc[i11], (List) unsafe.getObject(obj, j), zbwyVar, false);
                    break;
                case 30:
                    zbvz.zbs(zbvpVar.zbc[i11], (List) unsafe.getObject(obj, j), zbwyVar, false);
                    break;
                case 31:
                    zbvz.zby(zbvpVar.zbc[i11], (List) unsafe.getObject(obj, j), zbwyVar, false);
                    break;
                case 32:
                    zbvz.zbz(zbvpVar.zbc[i11], (List) unsafe.getObject(obj, j), zbwyVar, false);
                    break;
                case 33:
                    zbvz.zbA(zbvpVar.zbc[i11], (List) unsafe.getObject(obj, j), zbwyVar, false);
                    break;
                case 34:
                    zbvz.zbB(zbvpVar.zbc[i11], (List) unsafe.getObject(obj, j), zbwyVar, false);
                    break;
                case 35:
                    zbvz.zbr(zbvpVar.zbc[i11], (List) unsafe.getObject(obj, j), zbwyVar, i);
                    break;
                case 36:
                    zbvz.zbv(zbvpVar.zbc[i11], (List) unsafe.getObject(obj, j), zbwyVar, i);
                    break;
                case 37:
                    zbvz.zbx(zbvpVar.zbc[i11], (List) unsafe.getObject(obj, j), zbwyVar, i);
                    break;
                case MotionEventCompat.AXIS_GENERIC_7 /* 38 */:
                    zbvz.zbD(zbvpVar.zbc[i11], (List) unsafe.getObject(obj, j), zbwyVar, i);
                    break;
                case 39:
                    zbvz.zbw(zbvpVar.zbc[i11], (List) unsafe.getObject(obj, j), zbwyVar, i);
                    break;
                case 40:
                    zbvz.zbu(zbvpVar.zbc[i11], (List) unsafe.getObject(obj, j), zbwyVar, i);
                    break;
                case 41:
                    zbvz.zbt(zbvpVar.zbc[i11], (List) unsafe.getObject(obj, j), zbwyVar, i);
                    break;
                case MotionEventCompat.AXIS_GENERIC_11 /* 42 */:
                    zbvz.zbq(zbvpVar.zbc[i11], (List) unsafe.getObject(obj, j), zbwyVar, i);
                    break;
                case MotionEventCompat.AXIS_GENERIC_12 /* 43 */:
                    zbvz.zbC(zbvpVar.zbc[i11], (List) unsafe.getObject(obj, j), zbwyVar, i);
                    break;
                case 44:
                    zbvz.zbs(zbvpVar.zbc[i11], (List) unsafe.getObject(obj, j), zbwyVar, i);
                    break;
                case 45:
                    zbvz.zby(zbvpVar.zbc[i11], (List) unsafe.getObject(obj, j), zbwyVar, i);
                    break;
                case MotionEventCompat.AXIS_GENERIC_15 /* 46 */:
                    zbvz.zbz(zbvpVar.zbc[i11], (List) unsafe.getObject(obj, j), zbwyVar, i);
                    break;
                case MotionEventCompat.AXIS_GENERIC_16 /* 47 */:
                    zbvz.zbA(zbvpVar.zbc[i11], (List) unsafe.getObject(obj, j), zbwyVar, i);
                    break;
                case 48:
                    zbvz.zbB(zbvpVar.zbc[i11], (List) unsafe.getObject(obj, j), zbwyVar, i);
                    break;
                case 49:
                    i9 = zbvpVar.zbc[i11];
                    list4 = (List) unsafe.getObject(obj, j);
                    zbvxVarZbv2 = zbvpVar.zbv(i11);
                    int i21 = zbvz.zba;
                    if (list4 != null) {
                        while (i10 < list4.size()) {
                            ((zbtl) zbwyVar).zbq(i9, list4.get(i10), zbvxVarZbv2);
                        }
                    }
                    break;
                case 50:
                    object = unsafe.getObject(obj, j);
                    if (object != null) {
                        zbwyVar.zbv(i14, ((zbvf) zbvpVar.zbw(i11)).zbc(), (zbvg) object);
                    }
                    break;
                case StylePropertiesKt.BackgroundBrushId /* 51 */:
                    if (zbvpVar.zbM(obj, i14, i11)) {
                        zbwyVar.zbf(i14, zbm(obj, j));
                    }
                    break;
                case StylePropertiesKt.ForegroundBrushId /* 52 */:
                    if (zbvpVar.zbM(obj, i14, i11)) {
                        zbwyVar.zbo(i14, zbn(obj, j));
                    }
                    break;
                case StylePropertiesKt.ShapeId /* 53 */:
                    if (zbvpVar.zbM(obj, i14, i11)) {
                        zbwyVar.zbt(i14, zbt(obj, j));
                    }
                    break;
                case StylePropertiesKt.ColorFilterId /* 54 */:
                    if (zbvpVar.zbM(obj, i14, i11)) {
                        zbwyVar.zbL(i14, zbt(obj, j));
                    }
                    break;
                case StylePropertiesKt.DropShadowId /* 55 */:
                    if (zbvpVar.zbM(obj, i14, i11)) {
                        zbwyVar.zbr(i14, zbo(obj, j));
                    }
                    break;
                case StylePropertiesKt.InnerShadowId /* 56 */:
                    if (zbvpVar.zbM(obj, i14, i11)) {
                        zbwyVar.zbm(i14, zbt(obj, j));
                    }
                    break;
                case StylePropertiesKt.ContentBrushId /* 57 */:
                    if (zbvpVar.zbM(obj, i14, i11)) {
                        zbwyVar.zbk(i14, zbo(obj, j));
                    }
                    break;
                case StylePropertiesKt.FontFamilyId /* 58 */:
                    if (zbvpVar.zbM(obj, i14, i11)) {
                        zbwyVar.zbb(i14, zbN(obj, j));
                    }
                    break;
                case StylePropertiesKt.TextMotionId /* 59 */:
                    if (zbvpVar.zbM(obj, i14, i11)) {
                        zbP(i14, unsafe.getObject(obj, j), zbwyVar);
                    }
                    break;
                case 60:
                    if (zbvpVar.zbM(obj, i14, i11)) {
                        zbwyVar.zbw(i14, unsafe.getObject(obj, j), zbvpVar.zbv(i11));
                    }
                    break;
                case 61:
                    if (zbvpVar.zbM(obj, i14, i11)) {
                        zbwyVar.zbd(i14, (zbtc) unsafe.getObject(obj, j));
                    }
                    break;
                case RectListKt.BitOffsetForGesturable /* 62 */:
                    if (zbvpVar.zbM(obj, i14, i11)) {
                        zbwyVar.zbJ(i14, zbo(obj, j));
                    }
                    break;
                case 63:
                    if (zbvpVar.zbM(obj, i14, i11)) {
                        zbwyVar.zbi(i14, zbo(obj, j));
                    }
                    break;
                case 64:
                    if (zbvpVar.zbM(obj, i14, i11)) {
                        zbwyVar.zby(i14, zbo(obj, j));
                    }
                    break;
                case 65:
                    if (zbvpVar.zbM(obj, i14, i11)) {
                        zbwyVar.zbA(i14, zbt(obj, j));
                    }
                    break;
                case 66:
                    if (zbvpVar.zbM(obj, i14, i11)) {
                        zbwyVar.zbC(i14, zbo(obj, j));
                    }
                    break;
                case 67:
                    if (zbvpVar.zbM(obj, i14, i11)) {
                        zbwyVar.zbE(i14, zbt(obj, j));
                    }
                    break;
                case 68:
                    if (zbvpVar.zbM(obj, i14, i11)) {
                        zbwyVar.zbq(i14, unsafe.getObject(obj, j), zbvpVar.zbv(i11));
                    }
                    break;
                default:
                    break;
            }
            i11 += 3;
            i13 = i3;
            i12 = i2;
            entry = entry;
        }
        while (entry != null) {
            zbvpVar.zbm.zbb(zbwyVar, entry);
            entry = it.hasNext() ? (Map.Entry) it.next() : null;
        }
        ((zbuf) obj).zbc.zbl(zbwyVar);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbvx
    public final boolean zbj(Object obj, Object obj2) {
        boolean zZbE;
        for (int i = 0; i < this.zbc.length; i += 3) {
            int iZbs = zbs(i);
            long j = iZbs & 1048575;
            switch (zbr(iZbs)) {
                case 0:
                    if (!zbH(obj, obj2, i) || Double.doubleToLongBits(zbws.zba(obj, j)) != Double.doubleToLongBits(zbws.zba(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 1:
                    if (!zbH(obj, obj2, i) || Float.floatToIntBits(zbws.zbb(obj, j)) != Float.floatToIntBits(zbws.zbb(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 2:
                    if (!zbH(obj, obj2, i) || zbws.zbd(obj, j) != zbws.zbd(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 3:
                    if (!zbH(obj, obj2, i) || zbws.zbd(obj, j) != zbws.zbd(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 4:
                    if (!zbH(obj, obj2, i) || zbws.zbc(obj, j) != zbws.zbc(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 5:
                    if (!zbH(obj, obj2, i) || zbws.zbd(obj, j) != zbws.zbd(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 6:
                    if (!zbH(obj, obj2, i) || zbws.zbc(obj, j) != zbws.zbc(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 7:
                    if (!zbH(obj, obj2, i) || zbws.zbw(obj, j) != zbws.zbw(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 8:
                    if (!zbH(obj, obj2, i) || !zbvz.zbE(zbws.zbf(obj, j), zbws.zbf(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 9:
                    if (!zbH(obj, obj2, i) || !zbvz.zbE(zbws.zbf(obj, j), zbws.zbf(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 10:
                    if (!zbH(obj, obj2, i) || !zbvz.zbE(zbws.zbf(obj, j), zbws.zbf(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 11:
                    if (!zbH(obj, obj2, i) || zbws.zbc(obj, j) != zbws.zbc(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 12:
                    if (!zbH(obj, obj2, i) || zbws.zbc(obj, j) != zbws.zbc(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 13:
                    if (!zbH(obj, obj2, i) || zbws.zbc(obj, j) != zbws.zbc(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 14:
                    if (!zbH(obj, obj2, i) || zbws.zbd(obj, j) != zbws.zbd(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 15:
                    if (!zbH(obj, obj2, i) || zbws.zbc(obj, j) != zbws.zbc(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 16:
                    if (!zbH(obj, obj2, i) || zbws.zbd(obj, j) != zbws.zbd(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 17:
                    if (!zbH(obj, obj2, i) || !zbvz.zbE(zbws.zbf(obj, j), zbws.zbf(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case MotionEventCompat.AXIS_GENERIC_7 /* 38 */:
                case 39:
                case 40:
                case 41:
                case MotionEventCompat.AXIS_GENERIC_11 /* 42 */:
                case MotionEventCompat.AXIS_GENERIC_12 /* 43 */:
                case 44:
                case 45:
                case MotionEventCompat.AXIS_GENERIC_15 /* 46 */:
                case MotionEventCompat.AXIS_GENERIC_16 /* 47 */:
                case 48:
                case 49:
                    zZbE = zbvz.zbE(zbws.zbf(obj, j), zbws.zbf(obj2, j));
                    break;
                case 50:
                    zZbE = zbvz.zbE(zbws.zbf(obj, j), zbws.zbf(obj2, j));
                    break;
                case StylePropertiesKt.BackgroundBrushId /* 51 */:
                case StylePropertiesKt.ForegroundBrushId /* 52 */:
                case StylePropertiesKt.ShapeId /* 53 */:
                case StylePropertiesKt.ColorFilterId /* 54 */:
                case StylePropertiesKt.DropShadowId /* 55 */:
                case StylePropertiesKt.InnerShadowId /* 56 */:
                case StylePropertiesKt.ContentBrushId /* 57 */:
                case StylePropertiesKt.FontFamilyId /* 58 */:
                case StylePropertiesKt.TextMotionId /* 59 */:
                case 60:
                case 61:
                case RectListKt.BitOffsetForGesturable /* 62 */:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                case 68:
                    long jZbp = zbp(i) & 1048575;
                    if (zbws.zbc(obj, jZbp) != zbws.zbc(obj2, jZbp) || !zbvz.zbE(zbws.zbf(obj, j), zbws.zbf(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                default:
                    continue;
                    break;
            }
            if (!zZbE) {
                return false;
            }
        }
        if (!((zbuf) obj).zbc.equals(((zbuf) obj2).zbc)) {
            return false;
        }
        if (this.zbh) {
            return ((zbub) obj).zbb.equals(((zbub) obj2).zbb);
        }
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:50:0x00c1  */
    /* JADX WARN: Code duplicated, block: B:52:0x00d0  */
    /* JADX WARN: Code duplicated, block: B:55:0x00db  */
    /* JADX WARN: Code duplicated, block: B:58:0x00e6 A[LOOP:2: B:53:0x00d5->B:58:0x00e6, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:75:0x00e5 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:82:0x00fa A[SYNTHETIC] */
    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbvx
    public final boolean zbk(Object obj) {
        int i;
        int i2;
        List list;
        zbvx zbvxVarZbv;
        int i3;
        int i4 = 0;
        int i5 = 0;
        int i6 = 1048575;
        while (i4 < this.zbj) {
            int[] iArr = this.zbi;
            int[] iArr2 = this.zbc;
            int i7 = iArr[i4];
            int i8 = iArr2[i7];
            int iZbs = this.zbs(i7);
            int i9 = this.zbc[i7 + 2];
            int i10 = i9 & 1048575;
            int i11 = 1 << (i9 >>> 20);
            if (i10 != i6) {
                if (i10 != 1048575) {
                    i5 = zbb.getInt(obj, i10);
                }
                i2 = i5;
                i = i10;
            } else {
                i = i6;
                i2 = i5;
            }
            zbvp<T> zbvpVar = this;
            Object obj2 = obj;
            if ((268435456 & iZbs) != 0 && !zbvpVar.zbJ(obj2, i7, i, i2, i11)) {
                return false;
            }
            int iZbr = zbr(iZbs);
            if (iZbr == 9 || iZbr == 17) {
                if (zbvpVar.zbJ(obj2, i7, i, i2, i11) && !zbK(obj2, iZbs, zbvpVar.zbv(i7))) {
                    return false;
                }
            } else if (iZbr == 27) {
                list = (List) zbws.zbf(obj2, iZbs & 1048575);
                if (list.isEmpty()) {
                    continue;
                } else {
                    zbvxVarZbv = zbvpVar.zbv(i7);
                    for (i3 = 0; i3 < list.size(); i3++) {
                        if (!zbvxVarZbv.zbk(list.get(i3))) {
                            return false;
                        }
                    }
                }
            } else if (iZbr == 60 || iZbr == 68) {
                if (zbvpVar.zbM(obj2, i8, i7) && !zbK(obj2, iZbs, zbvpVar.zbv(i7))) {
                    return false;
                }
            } else if (iZbr == 49) {
                list = (List) zbws.zbf(obj2, iZbs & 1048575);
                if (list.isEmpty()) {
                    zbvxVarZbv = zbvpVar.zbv(i7);
                    while (i3 < list.size()) {
                        if (!zbvxVarZbv.zbk(list.get(i3))) {
                            return false;
                        }
                    }
                } else {
                    continue;
                }
            } else if (iZbr != 50) {
                continue;
            } else {
                zbvg zbvgVar = (zbvg) zbws.zbf(obj2, iZbs & 1048575);
                if (!zbvgVar.isEmpty() && ((zbvf) zbvpVar.zbw(i7)).zbc().zbc.zbb() == zbwx.MESSAGE) {
                    zbvx zbvxVarZbb = null;
                    for (Object obj3 : zbvgVar.values()) {
                        if (zbvxVarZbb == null) {
                            zbvxVarZbb = zbvu.zba().zbb(obj3.getClass());
                        }
                        if (!zbvxVarZbb.zbk(obj3)) {
                            return false;
                        }
                    }
                }
            }
            i4++;
            this = zbvpVar;
            obj = obj2;
            i6 = i;
            i5 = i2;
        }
        return !this.zbh || ((zbub) obj).zbb.zbm();
    }
}
