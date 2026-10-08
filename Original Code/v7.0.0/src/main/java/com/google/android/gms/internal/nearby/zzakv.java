package com.google.android.gms.internal.nearby;

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

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzakv<T> implements zzald<T> {
    private static final int[] zza = new int[0];
    private static final Unsafe zzb = zzalt.zzn();
    private final int[] zzc;
    private final Object[] zzd;
    private final int zze;
    private final int zzf;
    private final zzaks zzg;
    private final boolean zzh;
    private final boolean zzi;
    private final int[] zzj;
    private final int zzk;
    private final int zzl;
    private final zzalm zzm;
    private final zzaja zzn;

    private zzakv(int[] iArr, Object[] objArr, int i, int i2, zzaks zzaksVar, boolean z, int[] iArr2, int i3, int i4, zzakx zzakxVar, zzaki zzakiVar, zzalm zzalmVar, zzaja zzajaVar, zzako zzakoVar) {
        this.zzc = iArr;
        this.zzd = objArr;
        this.zze = i;
        this.zzf = i2;
        this.zzi = zzaksVar instanceof zzajo;
        boolean z2 = false;
        if (zzajaVar != null && (zzaksVar instanceof zzajl)) {
            z2 = true;
        }
        this.zzh = z2;
        this.zzj = iArr2;
        this.zzk = i3;
        this.zzl = i4;
        this.zzm = zzalmVar;
        this.zzn = zzajaVar;
        this.zzg = zzaksVar;
    }

    private final int zzA(int i) {
        return this.zzc[i + 1];
    }

    private final int zzB(int i) {
        return this.zzc[i + 2];
    }

    private static boolean zzC(int i) {
        return (i & GroupFlagsKt.HasMovableContentFlag) != 0;
    }

    private static boolean zzD(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof zzajo) {
            return ((zzajo) obj).zzy();
        }
        return true;
    }

    private static void zzE(Object obj) {
        if (zzD(obj)) {
            return;
        }
        String strValueOf = String.valueOf(obj);
        String.valueOf(strValueOf);
        throw new IllegalArgumentException("Mutating immutable message: ".concat(String.valueOf(strValueOf)));
    }

    private static int zzF(Object obj, long j) {
        return ((Integer) zzalt.zzl(obj, j)).intValue();
    }

    private static long zzG(Object obj, long j) {
        return ((Long) zzalt.zzl(obj, j)).longValue();
    }

    private final boolean zzH(Object obj, Object obj2, int i) {
        return zzJ(obj, i) == zzJ(obj2, i);
    }

    private final boolean zzI(Object obj, int i, int i2, int i3, int i4) {
        if (i2 == 1048575) {
            return zzJ(obj, i);
        }
        return (i3 & i4) != 0;
    }

    private final boolean zzJ(Object obj, int i) {
        int iZzB = zzB(i);
        long j = iZzB & 1048575;
        if (j != 1048575) {
            return ((1 << (iZzB >>> 20)) & zzalt.zzb(obj, j)) != 0;
        }
        int iZzA = zzA(i);
        long j2 = iZzA & 1048575;
        switch ((iZzA >>> 20) & 255) {
            case 0:
                return Double.doubleToRawLongBits(zzalt.zzj(obj, j2)) != 0;
            case 1:
                return Float.floatToRawIntBits(zzalt.zzh(obj, j2)) != 0;
            case 2:
                return zzalt.zzd(obj, j2) != 0;
            case 3:
                return zzalt.zzd(obj, j2) != 0;
            case 4:
                return zzalt.zzb(obj, j2) != 0;
            case 5:
                return zzalt.zzd(obj, j2) != 0;
            case 6:
                return zzalt.zzb(obj, j2) != 0;
            case 7:
                return zzalt.zzf(obj, j2);
            case 8:
                Object objZzl = zzalt.zzl(obj, j2);
                if (objZzl instanceof String) {
                    return !((String) objZzl).isEmpty();
                }
                if (objZzl instanceof zzaik) {
                    return !zzaik.zza.equals(objZzl);
                }
                return zzQ();
            case 9:
                return zzalt.zzl(obj, j2) != null;
            case 10:
                return !zzaik.zza.equals(zzalt.zzl(obj, j2));
            case 11:
                return zzalt.zzb(obj, j2) != 0;
            case 12:
                return zzalt.zzb(obj, j2) != 0;
            case 13:
                return zzalt.zzb(obj, j2) != 0;
            case 14:
                return zzalt.zzd(obj, j2) != 0;
            case 15:
                return zzalt.zzb(obj, j2) != 0;
            case 16:
                return zzalt.zzd(obj, j2) != 0;
            case 17:
                return zzalt.zzl(obj, j2) != null;
            default:
                return zzQ();
        }
    }

    private final void zzK(Object obj, int i) {
        int iZzB = zzB(i);
        long j = 1048575 & iZzB;
        if (j == 1048575) {
            return;
        }
        zzalt.zzc(obj, j, (1 << (iZzB >>> 20)) | zzalt.zzb(obj, j));
    }

    private final boolean zzL(Object obj, int i, int i2) {
        return zzalt.zzb(obj, (long) (zzB(i2) & 1048575)) == i;
    }

    private final boolean zzM(Object obj, Object obj2, int i) {
        long jZzB = zzB(i) & 1048575;
        return zzalt.zzb(obj, jZzB) == zzalt.zzb(obj2, jZzB);
    }

    private final void zzN(Object obj, int i, int i2) {
        zzalt.zzc(obj, zzB(i2) & 1048575, i);
    }

    private final int zzO(int i) {
        if (i < this.zze || i > this.zzf) {
            return -1;
        }
        return zzP(i, 0);
    }

    private final int zzP(int i, int i2) {
        int[] iArr = this.zzc;
        int length = (iArr.length / 3) - 1;
        while (i2 <= length) {
            int i3 = (length + i2) >>> 1;
            int i4 = i3 * 3;
            int i5 = iArr[i4];
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

    private boolean zzQ() {
        throw new IllegalArgumentException();
    }

    private static final int zzR(byte[] bArr, int i, int i2, zzalz zzalzVar, Class cls, zzahz zzahzVar) throws IOException {
        zzalz zzalzVar2 = zzalz.DOUBLE;
        switch (zzalzVar) {
            case DOUBLE:
                int i3 = i + 8;
                zzahzVar.zzc = Double.valueOf(Double.longBitsToDouble(zzaia.zzf(bArr, i)));
                return i3;
            case FLOAT:
                int i4 = i + 4;
                zzahzVar.zzc = Float.valueOf(Float.intBitsToFloat(zzaia.zze(bArr, i)));
                return i4;
            case INT64:
            case UINT64:
                int iZzd = zzaia.zzd(bArr, i, zzahzVar);
                zzahzVar.zzc = Long.valueOf(zzahzVar.zzb);
                return iZzd;
            case INT32:
            case UINT32:
            case ENUM:
                int iZza = zzaia.zza(bArr, i, zzahzVar);
                zzahzVar.zzc = Integer.valueOf(zzahzVar.zza);
                return iZza;
            case FIXED64:
            case SFIXED64:
                int i5 = i + 8;
                zzahzVar.zzc = Long.valueOf(zzaia.zzf(bArr, i));
                return i5;
            case FIXED32:
            case SFIXED32:
                int i6 = i + 4;
                zzahzVar.zzc = Integer.valueOf(zzaia.zze(bArr, i));
                return i6;
            case BOOL:
                int iZzd2 = zzaia.zzd(bArr, i, zzahzVar);
                zzahzVar.zzc = Boolean.valueOf(zzahzVar.zzb != 0);
                return iZzd2;
            case STRING:
                return zzaia.zzg(bArr, i, zzahzVar);
            case GROUP:
            default:
                throw new RuntimeException("unsupported field type.");
            case MESSAGE:
                return zzaia.zzi(zzala.zza().zzb(cls), bArr, i, i2, zzahzVar);
            case BYTES:
                return zzaia.zzh(bArr, i, zzahzVar);
            case SINT32:
                int iZza2 = zzaia.zza(bArr, i, zzahzVar);
                int i7 = zzahzVar.zza;
                int i8 = zzaio.zze;
                zzahzVar.zzc = Integer.valueOf((-(i7 & 1)) ^ (i7 >>> 1));
                return iZza2;
            case SINT64:
                int iZzd3 = zzaia.zzd(bArr, i, zzahzVar);
                long j = zzahzVar.zzb;
                int i9 = zzaio.zze;
                zzahzVar.zzc = Long.valueOf((-(j & 1)) ^ (j >>> 1));
                return iZzd3;
        }
    }

    private static final void zzS(int i, Object obj, zzaiv zzaivVar) throws IOException {
        if (obj instanceof String) {
            zzaivVar.zzm(i, (String) obj);
        } else {
            zzaivVar.zzn(i, (zzaik) obj);
        }
    }

    static zzaln zzh(Object obj) {
        zzajo zzajoVar = (zzajo) obj;
        zzaln zzalnVar = zzajoVar.zzc;
        if (zzalnVar != zzaln.zza()) {
            return zzalnVar;
        }
        zzaln zzalnVarZzb = zzaln.zzb();
        zzajoVar.zzc = zzalnVarZzb;
        return zzalnVarZzb;
    }

    /* JADX WARN: Code duplicated, block: B:127:0x025f  */
    /* JADX WARN: Code duplicated, block: B:128:0x0262  */
    /* JADX WARN: Code duplicated, block: B:131:0x0280  */
    /* JADX WARN: Code duplicated, block: B:132:0x0283  */
    static zzakv zzm(Class cls, zzakq zzakqVar, zzakx zzakxVar, zzaki zzakiVar, zzalm zzalmVar, zzaja zzajaVar, zzako zzakoVar) {
        int i;
        int iCharAt;
        int i2;
        int[] iArr;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        char cCharAt;
        int i8;
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
        int i16;
        int i17;
        int i18;
        int i19;
        int iObjectFieldOffset;
        int iObjectFieldOffset2;
        int i20;
        int i21;
        Field fieldZzn;
        int i22;
        char cCharAt8;
        int i23;
        int i24;
        int i25;
        int i26;
        int i27;
        int i28;
        Object obj;
        Field fieldZzn2;
        int i29;
        Object obj2;
        Field fieldZzn3;
        int i30;
        char cCharAt9;
        int i31;
        char cCharAt10;
        int i32;
        char cCharAt11;
        int i33;
        char cCharAt12;
        Unsafe unsafe = zzb;
        if (unsafe == null) {
            throw new RuntimeException("Lite gencode is primarily intended for Android use and uses sun.misc.Unsafe which is not available in the current environment. To run in this environment, you may need to switch to standard gencode.");
        }
        if (!(zzakqVar instanceof zzalc)) {
            throw null;
        }
        zzalc zzalcVar = (zzalc) zzakqVar;
        String strZzd = zzalcVar.zzd();
        int length = strZzd.length();
        int i34 = 0;
        char c = 55296;
        if (strZzd.charAt(0) >= 55296) {
            int i35 = 1;
            while (true) {
                i = i35 + 1;
                if (strZzd.charAt(i35) < 55296) {
                    break;
                }
                i35 = i;
            }
        } else {
            i = 1;
        }
        int i36 = i + 1;
        int iCharAt2 = strZzd.charAt(i);
        if (iCharAt2 >= 55296) {
            int i37 = iCharAt2 & 8191;
            int i38 = 13;
            while (true) {
                i33 = i36 + 1;
                cCharAt12 = strZzd.charAt(i36);
                if (cCharAt12 < 55296) {
                    break;
                }
                i37 |= (cCharAt12 & 8191) << i38;
                i38 += 13;
                i36 = i33;
            }
            iCharAt2 = i37 | (cCharAt12 << i38);
            i36 = i33;
        }
        if (iCharAt2 == 0) {
            iCharAt = 0;
            i5 = 0;
            i6 = 0;
            i2 = 0;
            i4 = 0;
            iArr = zza;
            i3 = 0;
        } else {
            int i39 = i36 + 1;
            int iCharAt3 = strZzd.charAt(i36);
            if (iCharAt3 >= 55296) {
                int i40 = iCharAt3 & 8191;
                int i41 = 13;
                while (true) {
                    i14 = i39 + 1;
                    cCharAt7 = strZzd.charAt(i39);
                    if (cCharAt7 < 55296) {
                        break;
                    }
                    i40 |= (cCharAt7 & 8191) << i41;
                    i41 += 13;
                    i39 = i14;
                }
                iCharAt3 = i40 | (cCharAt7 << i41);
                i39 = i14;
            }
            int i42 = i39 + 1;
            int iCharAt4 = strZzd.charAt(i39);
            if (iCharAt4 >= 55296) {
                int i43 = iCharAt4 & 8191;
                int i44 = 13;
                while (true) {
                    i13 = i42 + 1;
                    cCharAt6 = strZzd.charAt(i42);
                    if (cCharAt6 < 55296) {
                        break;
                    }
                    i43 |= (cCharAt6 & 8191) << i44;
                    i44 += 13;
                    i42 = i13;
                }
                iCharAt4 = i43 | (cCharAt6 << i44);
                i42 = i13;
            }
            int i45 = i42 + 1;
            int iCharAt5 = strZzd.charAt(i42);
            if (iCharAt5 >= 55296) {
                int i46 = iCharAt5 & 8191;
                int i47 = 13;
                while (true) {
                    i12 = i45 + 1;
                    cCharAt5 = strZzd.charAt(i45);
                    if (cCharAt5 < 55296) {
                        break;
                    }
                    i46 |= (cCharAt5 & 8191) << i47;
                    i47 += 13;
                    i45 = i12;
                }
                iCharAt5 = i46 | (cCharAt5 << i47);
                i45 = i12;
            }
            int i48 = i45 + 1;
            int iCharAt6 = strZzd.charAt(i45);
            if (iCharAt6 >= 55296) {
                int i49 = iCharAt6 & 8191;
                int i50 = 13;
                while (true) {
                    i11 = i48 + 1;
                    cCharAt4 = strZzd.charAt(i48);
                    if (cCharAt4 < 55296) {
                        break;
                    }
                    i49 |= (cCharAt4 & 8191) << i50;
                    i50 += 13;
                    i48 = i11;
                }
                iCharAt6 = i49 | (cCharAt4 << i50);
                i48 = i11;
            }
            int i51 = i48 + 1;
            iCharAt = strZzd.charAt(i48);
            if (iCharAt >= 55296) {
                int i52 = iCharAt & 8191;
                int i53 = 13;
                while (true) {
                    i10 = i51 + 1;
                    cCharAt3 = strZzd.charAt(i51);
                    if (cCharAt3 < 55296) {
                        break;
                    }
                    i52 |= (cCharAt3 & 8191) << i53;
                    i53 += 13;
                    i51 = i10;
                }
                iCharAt = i52 | (cCharAt3 << i53);
                i51 = i10;
            }
            int i54 = i51 + 1;
            int iCharAt7 = strZzd.charAt(i51);
            if (iCharAt7 >= 55296) {
                int i55 = iCharAt7 & 8191;
                int i56 = 13;
                while (true) {
                    i9 = i54 + 1;
                    cCharAt2 = strZzd.charAt(i54);
                    if (cCharAt2 < 55296) {
                        break;
                    }
                    i55 |= (cCharAt2 & 8191) << i56;
                    i56 += 13;
                    i54 = i9;
                }
                iCharAt7 = i55 | (cCharAt2 << i56);
                i54 = i9;
            }
            int i57 = i54 + 1;
            if (strZzd.charAt(i54) >= 55296) {
                while (true) {
                    i8 = i57 + 1;
                    if (strZzd.charAt(i57) < 55296) {
                        break;
                    }
                    i57 = i8;
                }
                i57 = i8;
            }
            int i58 = i57 + 1;
            int iCharAt8 = strZzd.charAt(i57);
            if (iCharAt8 >= 55296) {
                int i59 = iCharAt8 & 8191;
                int i60 = 13;
                while (true) {
                    i7 = i58 + 1;
                    cCharAt = strZzd.charAt(i58);
                    if (cCharAt < 55296) {
                        break;
                    }
                    i59 |= (cCharAt & 8191) << i60;
                    i60 += 13;
                    i58 = i7;
                }
                iCharAt8 = i59 | (cCharAt << i60);
                i58 = i7;
            }
            i2 = iCharAt3 + iCharAt3 + iCharAt4;
            i34 = iCharAt3;
            iArr = new int[iCharAt8 + iCharAt7 + iCharAt3];
            i3 = iCharAt7;
            i36 = i58;
            i4 = iCharAt8;
            i5 = iCharAt5;
            i6 = iCharAt6;
        }
        Object[] objArrZze = zzalcVar.zze();
        Class<?> cls2 = zzalcVar.zzb().getClass();
        int i61 = i4 + i3;
        int i62 = iCharAt + iCharAt;
        int[] iArr2 = new int[iCharAt * 3];
        Object[] objArr = new Object[i62];
        int i63 = i4;
        int i64 = i61;
        int i65 = 0;
        int i66 = 0;
        while (i36 < length) {
            int i67 = i36 + 1;
            int iCharAt9 = strZzd.charAt(i36);
            if (iCharAt9 >= c) {
                int i68 = iCharAt9 & 8191;
                int i69 = i67;
                int i70 = 13;
                while (true) {
                    i32 = i69 + 1;
                    cCharAt11 = strZzd.charAt(i69);
                    if (cCharAt11 < c) {
                        break;
                    }
                    i68 |= (cCharAt11 & 8191) << i70;
                    i70 += 13;
                    i69 = i32;
                }
                iCharAt9 = i68 | (cCharAt11 << i70);
                i15 = i32;
            } else {
                i15 = i67;
            }
            int i71 = i15 + 1;
            int iCharAt10 = strZzd.charAt(i15);
            if (iCharAt10 >= c) {
                int i72 = iCharAt10 & 8191;
                int i73 = i71;
                int i74 = 13;
                while (true) {
                    i31 = i73 + 1;
                    cCharAt10 = strZzd.charAt(i73);
                    if (cCharAt10 < c) {
                        break;
                    }
                    i72 |= (cCharAt10 & 8191) << i74;
                    i74 += 13;
                    i73 = i31;
                }
                iCharAt10 = i72 | (cCharAt10 << i74);
                i16 = i31;
            } else {
                i16 = i71;
            }
            if ((iCharAt10 & 1024) != 0) {
                iArr[i65] = i66;
                i65++;
            }
            int i75 = iCharAt10 & 255;
            zzalc zzalcVar2 = zzalcVar;
            int i76 = iCharAt10 & 2048;
            if (i75 >= 51) {
                int i77 = i16 + 1;
                int iCharAt11 = strZzd.charAt(i16);
                char c2 = 55296;
                if (iCharAt11 >= 55296) {
                    int i78 = iCharAt11 & 8191;
                    int i79 = i77;
                    int i80 = 13;
                    while (true) {
                        i30 = i79 + 1;
                        cCharAt9 = strZzd.charAt(i79);
                        if (cCharAt9 < c2) {
                            break;
                        }
                        i78 |= (cCharAt9 & 8191) << i80;
                        i80 += 13;
                        i79 = i30;
                        c2 = 55296;
                    }
                    iCharAt11 = i78 | (cCharAt9 << i80);
                    i25 = i30;
                } else {
                    i25 = i77;
                }
                int i81 = i25;
                int i82 = i75 - 51;
                i17 = length;
                if (i82 == 9 || i82 == 17) {
                    i26 = i2 + 1;
                    int i83 = i66 / 3;
                    objArr[i83 + i83 + 1] = objArrZze[i2];
                } else {
                    if (i82 != 12) {
                        i27 = i76;
                    } else if (zzalcVar2.zzc() == 1 || i76 != 0) {
                        i26 = i2 + 1;
                        int i84 = i66 / 3;
                        objArr[i84 + i84 + 1] = objArrZze[i2];
                    } else {
                        i27 = 0;
                    }
                    i28 = iCharAt11 + iCharAt11;
                    obj = objArrZze[i28];
                    int i85 = i27;
                    if (obj instanceof Field) {
                        fieldZzn2 = (Field) obj;
                    } else {
                        fieldZzn2 = zzn(cls2, (String) obj);
                        objArrZze[i28] = fieldZzn2;
                        iArr[i64] = i66;
                        i64++;
                    }
                    int i86 = i34;
                    int iObjectFieldOffset3 = (int) unsafe.objectFieldOffset(fieldZzn2);
                    i29 = i28 + 1;
                    obj2 = objArrZze[i29];
                    i18 = i86;
                    if (obj2 instanceof Field) {
                        fieldZzn3 = (Field) obj2;
                    } else {
                        fieldZzn3 = zzn(cls2, (String) obj2);
                        objArrZze[i29] = fieldZzn3;
                    }
                    i16 = i81;
                    i21 = 0;
                    i19 = i2;
                    iObjectFieldOffset2 = (int) unsafe.objectFieldOffset(fieldZzn3);
                    iObjectFieldOffset = iObjectFieldOffset3;
                    i20 = i85;
                }
                i2 = i26;
                i27 = i76;
                i28 = iCharAt11 + iCharAt11;
                obj = objArrZze[i28];
                int i87 = i27;
                if (obj instanceof Field) {
                    fieldZzn2 = (Field) obj;
                } else {
                    fieldZzn2 = zzn(cls2, (String) obj);
                    objArrZze[i28] = fieldZzn2;
                    iArr[i64] = i66;
                    i64++;
                }
                int i88 = i34;
                int iObjectFieldOffset4 = (int) unsafe.objectFieldOffset(fieldZzn2);
                i29 = i28 + 1;
                obj2 = objArrZze[i29];
                i18 = i88;
                if (obj2 instanceof Field) {
                    fieldZzn3 = (Field) obj2;
                } else {
                    fieldZzn3 = zzn(cls2, (String) obj2);
                    objArrZze[i29] = fieldZzn3;
                }
                i16 = i81;
                i21 = 0;
                i19 = i2;
                iObjectFieldOffset2 = (int) unsafe.objectFieldOffset(fieldZzn3);
                iObjectFieldOffset = iObjectFieldOffset4;
                i20 = i87;
            } else {
                i17 = length;
                i18 = i34;
                int i89 = i2 + 1;
                Field fieldZzn4 = zzn(cls2, (String) objArrZze[i2]);
                if (i75 == 9 || i75 == 17) {
                    i19 = i89;
                    int i90 = i66 / 3;
                    objArr[i90 + i90 + 1] = fieldZzn4.getType();
                } else {
                    if (i75 == 27) {
                        i23 = 1;
                        i24 = i2 + 2;
                    } else if (i75 == 49) {
                        i24 = i2 + 2;
                        i23 = 1;
                    } else if (i75 == 12 || i75 == 30 || i75 == 44) {
                        i19 = i89;
                        if (zzalcVar2.zzc() == 1 || i76 != 0) {
                            i24 = i2 + 2;
                            int i91 = i66 / 3;
                            objArr[i91 + i91 + 1] = objArrZze[i19];
                            i19 = i24;
                        } else {
                            i76 = 0;
                        }
                    } else if (i75 == 50) {
                        int i92 = i2 + 2;
                        int i93 = i63 + 1;
                        iArr[i63] = i66;
                        int i94 = i66 / 3;
                        int i95 = i94 + i94;
                        objArr[i95] = objArrZze[i89];
                        if (i76 != 0) {
                            i89 = i2 + 3;
                            objArr[i95 + 1] = objArrZze[i92];
                            i63 = i93;
                            i19 = i89;
                        } else {
                            i63 = i93;
                            i76 = 0;
                            i19 = i92;
                        }
                    } else {
                        i19 = i89;
                    }
                    int i96 = i66 / 3;
                    objArr[i96 + i96 + i23] = objArrZze[i89];
                    i19 = i24;
                }
                iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldZzn4);
                iObjectFieldOffset2 = 1048575;
                if ((iCharAt10 & 4096) == 0 || i75 > 17) {
                    i20 = i76;
                    i21 = 0;
                } else {
                    int i97 = i16 + 1;
                    int iCharAt12 = strZzd.charAt(i16);
                    if (iCharAt12 >= 55296) {
                        int i98 = iCharAt12 & 8191;
                        int i99 = 13;
                        while (true) {
                            i22 = i97 + 1;
                            cCharAt8 = strZzd.charAt(i97);
                            if (cCharAt8 < 55296) {
                                break;
                            }
                            i98 |= (cCharAt8 & 8191) << i99;
                            i99 += 13;
                            i97 = i22;
                        }
                        iCharAt12 = i98 | (cCharAt8 << i99);
                        i97 = i22;
                    }
                    int i100 = i18 + i18 + (iCharAt12 / 32);
                    Object obj3 = objArrZze[i100];
                    if (obj3 instanceof Field) {
                        fieldZzn = (Field) obj3;
                    } else {
                        fieldZzn = zzn(cls2, (String) obj3);
                        objArrZze[i100] = fieldZzn;
                    }
                    iObjectFieldOffset2 = (int) unsafe.objectFieldOffset(fieldZzn);
                    i21 = iCharAt12 % 32;
                    i20 = i76;
                    iObjectFieldOffset = iObjectFieldOffset;
                    i16 = i97;
                }
            }
            int i101 = i66 + 1;
            iArr2[i66] = iCharAt9;
            int i102 = i66 + 2;
            iArr2[i101] = ((iCharAt10 & 512) != 0 ? GroupFlagsKt.HasMovableContentFlag : 0) | ((iCharAt10 & 256) != 0 ? GroupFlagsKt.IsMovableContentFlag : 0) | (i20 != 0 ? Integer.MIN_VALUE : 0) | (i75 << 20) | iObjectFieldOffset;
            i66 += 3;
            iArr2[i102] = (i21 << 20) | iObjectFieldOffset2;
            i36 = i16;
            zzalcVar = zzalcVar2;
            i2 = i19;
            strZzd = strZzd;
            length = i17;
            i34 = i18;
            c = 55296;
        }
        return new zzakv(iArr2, objArr, i5, i6, zzalcVar.zzb(), false, iArr, i4, i61, zzakxVar, zzakiVar, zzalmVar, zzajaVar, zzakoVar);
    }

    private static Field zzn(Class cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException e) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            String name = cls.getName();
            String string = Arrays.toString(declaredFields);
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 11 + String.valueOf(name).length() + 29 + String.valueOf(string).length());
            sb.append("Field ");
            sb.append(str);
            sb.append(" for ");
            sb.append(name);
            sb.append(" not found. Known fields are ");
            sb.append(string);
            throw new RuntimeException(sb.toString(), e);
        }
    }

    private final void zzo(Object obj, Object obj2, int i) {
        if (zzJ(obj2, i)) {
            int iZzA = zzA(i) & 1048575;
            Unsafe unsafe = zzb;
            long j = iZzA;
            Object object = unsafe.getObject(obj2, j);
            if (object == null) {
                int i2 = this.zzc[i];
                String string = obj2.toString();
                StringBuilder sb = new StringBuilder(String.valueOf(i2).length() + 38 + string.length());
                sb.append("Source subfield ");
                sb.append(i2);
                sb.append(" is present but null: ");
                sb.append(string);
                throw new IllegalStateException(sb.toString());
            }
            zzald zzaldVarZzq = zzq(i);
            if (!zzJ(obj, i)) {
                if (zzD(object)) {
                    Object objZza = zzaldVarZzq.zza();
                    zzaldVarZzq.zzd(objZza, object);
                    unsafe.putObject(obj, j, objZza);
                } else {
                    unsafe.putObject(obj, j, object);
                }
                zzK(obj, i);
                return;
            }
            Object object2 = unsafe.getObject(obj, j);
            if (!zzD(object2)) {
                Object objZza2 = zzaldVarZzq.zza();
                zzaldVarZzq.zzd(objZza2, object2);
                unsafe.putObject(obj, j, objZza2);
                object2 = objZza2;
            }
            zzaldVarZzq.zzd(object2, object);
        }
    }

    private final void zzp(Object obj, Object obj2, int i) {
        int[] iArr = this.zzc;
        int i2 = iArr[i];
        if (zzL(obj2, i2, i)) {
            int iZzA = zzA(i) & 1048575;
            Unsafe unsafe = zzb;
            long j = iZzA;
            Object object = unsafe.getObject(obj2, j);
            if (object == null) {
                int i3 = iArr[i];
                String string = obj2.toString();
                StringBuilder sb = new StringBuilder(String.valueOf(i3).length() + 38 + string.length());
                sb.append("Source subfield ");
                sb.append(i3);
                sb.append(" is present but null: ");
                sb.append(string);
                throw new IllegalStateException(sb.toString());
            }
            zzald zzaldVarZzq = zzq(i);
            if (!zzL(obj, i2, i)) {
                if (zzD(object)) {
                    Object objZza = zzaldVarZzq.zza();
                    zzaldVarZzq.zzd(objZza, object);
                    unsafe.putObject(obj, j, objZza);
                } else {
                    unsafe.putObject(obj, j, object);
                }
                zzN(obj, i2, i);
                return;
            }
            Object object2 = unsafe.getObject(obj, j);
            if (!zzD(object2)) {
                Object objZza2 = zzaldVarZzq.zza();
                zzaldVarZzq.zzd(objZza2, object2);
                unsafe.putObject(obj, j, objZza2);
                object2 = objZza2;
            }
            zzaldVarZzq.zzd(object2, object);
        }
    }

    private final zzald zzq(int i) {
        Object[] objArr = this.zzd;
        int i2 = i / 3;
        int i3 = i2 + i2;
        zzald zzaldVar = (zzald) objArr[i3];
        if (zzaldVar != null) {
            return zzaldVar;
        }
        zzald zzaldVarZzb = zzala.zza().zzb((Class) objArr[i3 + 1]);
        objArr[i3] = zzaldVarZzb;
        return zzaldVarZzb;
    }

    private final Object zzr(int i) {
        int i2 = i / 3;
        return this.zzd[i2 + i2];
    }

    private final zzajt zzs(int i) {
        int i2 = i / 3;
        return (zzajt) this.zzd[i2 + i2 + 1];
    }

    private final Object zzt(Object obj, int i) {
        zzald zzaldVarZzq = zzq(i);
        int iZzA = zzA(i) & 1048575;
        if (!zzJ(obj, i)) {
            return zzaldVarZzq.zza();
        }
        Object object = zzb.getObject(obj, iZzA);
        if (zzD(object)) {
            return object;
        }
        Object objZza = zzaldVarZzq.zza();
        if (object != null) {
            zzaldVarZzq.zzd(objZza, object);
        }
        return objZza;
    }

    private final void zzu(Object obj, int i, Object obj2) {
        zzb.putObject(obj, zzA(i) & 1048575, obj2);
        zzK(obj, i);
    }

    private final Object zzv(Object obj, int i, int i2) {
        zzald zzaldVarZzq = zzq(i2);
        if (!zzL(obj, i, i2)) {
            return zzaldVarZzq.zza();
        }
        Object object = zzb.getObject(obj, zzA(i2) & 1048575);
        if (zzD(object)) {
            return object;
        }
        Object objZza = zzaldVarZzq.zza();
        if (object != null) {
            zzaldVarZzq.zzd(objZza, object);
        }
        return objZza;
    }

    private final void zzw(Object obj, int i, int i2, Object obj2) {
        zzb.putObject(obj, zzA(i2) & 1048575, obj2);
        zzN(obj, i, i2);
    }

    private final Object zzx(Object obj, int i, Object obj2, zzalm zzalmVar, Object obj3) {
        zzajt zzajtVarZzs;
        int i2 = this.zzc[i];
        Object objZzl = zzalt.zzl(obj, zzA(i) & 1048575);
        if (objZzl == null || (zzajtVarZzs = zzs(i)) == null) {
            return obj2;
        }
        zzakl zzaklVarZze = ((zzakm) zzr(i)).zze();
        Iterator it = ((zzakn) objZzl).entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            if (!zzajtVarZzs.zza(((Integer) entry.getValue()).intValue())) {
                if (obj2 == null) {
                    obj2 = zzalo.zzj(obj3);
                }
                int iZzc = zzakm.zzc(zzaklVarZze, entry.getKey(), entry.getValue());
                zzaik zzaikVar = zzaik.zza;
                byte[] bArr = new byte[iZzc];
                zzaiq zzaiqVar = new zzaiq(bArr, 0, iZzc, null);
                try {
                    zzakm.zzb(zzaiqVar, zzaklVarZze, entry.getKey(), entry.getValue());
                    ((zzaln) obj2).zzk((i2 << 3) | 2, zzaih.zza(zzaiqVar, bArr));
                    it.remove();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return obj2;
    }

    private static boolean zzy(Object obj, int i, zzald zzaldVar) {
        return zzaldVar.zzl(zzalt.zzl(obj, i & 1048575));
    }

    private final void zzz(Object obj, int i, zzaip zzaipVar) throws IOException {
        long j = i & 1048575;
        if (zzC(i)) {
            zzalt.zzm(obj, j, zzaipVar.zzn());
        } else if (this.zzi) {
            zzalt.zzm(obj, j, zzaipVar.zzm());
        } else {
            zzalt.zzm(obj, j, zzaipVar.zzq());
        }
    }

    @Override // com.google.android.gms.internal.nearby.zzald
    public final Object zza() {
        return ((zzajo) this.zzg).zzD();
    }

    @Override // com.google.android.gms.internal.nearby.zzald
    public final boolean zzb(Object obj, Object obj2) {
        boolean zZzz;
        for (int i = 0; i < this.zzc.length; i += 3) {
            int iZzA = zzA(i);
            int i2 = (iZzA >>> 20) & 255;
            if (i2 <= 50 || i2 >= 69) {
                long j = iZzA & 1048575;
                switch (i2) {
                    case 0:
                        if (!zzH(obj, obj2, i) || Double.doubleToLongBits(zzalt.zzj(obj, j)) != Double.doubleToLongBits(zzalt.zzj(obj2, j))) {
                            return false;
                        }
                        continue;
                        break;
                    case 1:
                        if (!zzH(obj, obj2, i) || Float.floatToIntBits(zzalt.zzh(obj, j)) != Float.floatToIntBits(zzalt.zzh(obj2, j))) {
                            return false;
                        }
                        continue;
                        break;
                    case 2:
                        if (!zzH(obj, obj2, i) || zzalt.zzd(obj, j) != zzalt.zzd(obj2, j)) {
                            return false;
                        }
                        continue;
                        break;
                    case 3:
                        if (!zzH(obj, obj2, i) || zzalt.zzd(obj, j) != zzalt.zzd(obj2, j)) {
                            return false;
                        }
                        continue;
                        break;
                    case 4:
                        if (!zzH(obj, obj2, i) || zzalt.zzb(obj, j) != zzalt.zzb(obj2, j)) {
                            return false;
                        }
                        continue;
                        break;
                    case 5:
                        if (!zzH(obj, obj2, i) || zzalt.zzd(obj, j) != zzalt.zzd(obj2, j)) {
                            return false;
                        }
                        continue;
                        break;
                    case 6:
                        if (!zzH(obj, obj2, i) || zzalt.zzb(obj, j) != zzalt.zzb(obj2, j)) {
                            return false;
                        }
                        continue;
                        break;
                    case 7:
                        if (!zzH(obj, obj2, i) || zzalt.zzf(obj, j) != zzalt.zzf(obj2, j)) {
                            return false;
                        }
                        continue;
                        break;
                    case 8:
                        if (!zzH(obj, obj2, i) || !zzale.zzz(zzalt.zzl(obj, j), zzalt.zzl(obj2, j))) {
                            return false;
                        }
                        continue;
                        break;
                    case 9:
                        if (!zzH(obj, obj2, i) || !zzale.zzz(zzalt.zzl(obj, j), zzalt.zzl(obj2, j))) {
                            return false;
                        }
                        continue;
                        break;
                    case 10:
                        if (!zzH(obj, obj2, i) || !zzale.zzz(zzalt.zzl(obj, j), zzalt.zzl(obj2, j))) {
                            return false;
                        }
                        continue;
                        break;
                    case 11:
                        if (!zzH(obj, obj2, i) || zzalt.zzb(obj, j) != zzalt.zzb(obj2, j)) {
                            return false;
                        }
                        continue;
                        break;
                    case 12:
                        if (!zzH(obj, obj2, i) || zzalt.zzb(obj, j) != zzalt.zzb(obj2, j)) {
                            return false;
                        }
                        continue;
                        break;
                    case 13:
                        if (!zzH(obj, obj2, i) || zzalt.zzb(obj, j) != zzalt.zzb(obj2, j)) {
                            return false;
                        }
                        continue;
                        break;
                    case 14:
                        if (!zzH(obj, obj2, i) || zzalt.zzd(obj, j) != zzalt.zzd(obj2, j)) {
                            return false;
                        }
                        continue;
                        break;
                    case 15:
                        if (!zzH(obj, obj2, i) || zzalt.zzb(obj, j) != zzalt.zzb(obj2, j)) {
                            return false;
                        }
                        continue;
                        break;
                    case 16:
                        if (!zzH(obj, obj2, i) || zzalt.zzd(obj, j) != zzalt.zzd(obj2, j)) {
                            return false;
                        }
                        continue;
                        break;
                    case 17:
                        if (!zzH(obj, obj2, i) || !zzale.zzz(zzalt.zzl(obj, j), zzalt.zzl(obj2, j))) {
                            return false;
                        }
                        continue;
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
                        zZzz = zzale.zzz(zzalt.zzl(obj, j), zzalt.zzl(obj2, j));
                        break;
                    case 50:
                        zZzz = zzale.zzz(zzalt.zzl(obj, j), zzalt.zzl(obj2, j));
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
                        if (!zzM(obj, obj2, i) || !zzale.zzz(zzalt.zzl(obj, j), zzalt.zzl(obj2, j))) {
                            return false;
                        }
                        continue;
                        break;
                    default:
                        continue;
                }
                if (!zZzz) {
                    return false;
                }
            }
        }
        int i3 = this.zzl;
        while (true) {
            int[] iArr = this.zzj;
            if (i3 >= iArr.length) {
                if (!((zzajo) obj).zzc.equals(((zzajo) obj2).zzc)) {
                    return false;
                }
                if (this.zzh) {
                    return ((zzajl) obj).zzb.equals(((zzajl) obj2).zzb);
                }
                return true;
            }
            int i4 = iArr[i3];
            if (!zzM(obj, obj2, i4)) {
                return false;
            }
            if (!zzL(obj, 0, i4)) {
                long jZzA = zzA(i4) & 1048575;
                if (!zzale.zzz(zzalt.zzl(obj, jZzA), zzalt.zzl(obj2, jZzA))) {
                    return false;
                }
            }
            i3++;
        }
    }

    @Override // com.google.android.gms.internal.nearby.zzald
    public final int zzc(Object obj) {
        int i;
        long jDoubleToLongBits;
        int iFloatToIntBits;
        int i2;
        int iHashCode = 0;
        for (int i3 = 0; i3 < this.zzc.length; i3 += 3) {
            int iZzA = zzA(i3);
            int i4 = (iZzA >>> 20) & 255;
            if (i4 <= 50 || i4 >= 69) {
                long j = iZzA & 1048575;
                int iHashCode2 = 37;
                switch (i4) {
                    case 0:
                        i = iHashCode * 53;
                        jDoubleToLongBits = Double.doubleToLongBits(zzalt.zzj(obj, j));
                        byte[] bArr = zzaka.zza;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        iHashCode = i + iFloatToIntBits;
                        break;
                    case 1:
                        i = iHashCode * 53;
                        iFloatToIntBits = Float.floatToIntBits(zzalt.zzh(obj, j));
                        iHashCode = i + iFloatToIntBits;
                        break;
                    case 2:
                        i = iHashCode * 53;
                        jDoubleToLongBits = zzalt.zzd(obj, j);
                        byte[] bArr2 = zzaka.zza;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        iHashCode = i + iFloatToIntBits;
                        break;
                    case 3:
                        i = iHashCode * 53;
                        jDoubleToLongBits = zzalt.zzd(obj, j);
                        byte[] bArr3 = zzaka.zza;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        iHashCode = i + iFloatToIntBits;
                        break;
                    case 4:
                        i = iHashCode * 53;
                        iFloatToIntBits = zzalt.zzb(obj, j);
                        iHashCode = i + iFloatToIntBits;
                        break;
                    case 5:
                        i = iHashCode * 53;
                        jDoubleToLongBits = zzalt.zzd(obj, j);
                        byte[] bArr4 = zzaka.zza;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        iHashCode = i + iFloatToIntBits;
                        break;
                    case 6:
                        i = iHashCode * 53;
                        iFloatToIntBits = zzalt.zzb(obj, j);
                        iHashCode = i + iFloatToIntBits;
                        break;
                    case 7:
                        i = iHashCode * 53;
                        iFloatToIntBits = zzaka.zzb(zzalt.zzf(obj, j));
                        iHashCode = i + iFloatToIntBits;
                        break;
                    case 8:
                        i = iHashCode * 53;
                        iFloatToIntBits = ((String) zzalt.zzl(obj, j)).hashCode();
                        iHashCode = i + iFloatToIntBits;
                        break;
                    case 9:
                        i2 = iHashCode * 53;
                        Object objZzl = zzalt.zzl(obj, j);
                        if (objZzl != null) {
                            iHashCode2 = objZzl.hashCode();
                        }
                        iHashCode = i2 + iHashCode2;
                        break;
                    case 10:
                        i = iHashCode * 53;
                        iFloatToIntBits = zzalt.zzl(obj, j).hashCode();
                        iHashCode = i + iFloatToIntBits;
                        break;
                    case 11:
                        i = iHashCode * 53;
                        iFloatToIntBits = zzalt.zzb(obj, j);
                        iHashCode = i + iFloatToIntBits;
                        break;
                    case 12:
                        i = iHashCode * 53;
                        iFloatToIntBits = zzalt.zzb(obj, j);
                        iHashCode = i + iFloatToIntBits;
                        break;
                    case 13:
                        i = iHashCode * 53;
                        iFloatToIntBits = zzalt.zzb(obj, j);
                        iHashCode = i + iFloatToIntBits;
                        break;
                    case 14:
                        i = iHashCode * 53;
                        jDoubleToLongBits = zzalt.zzd(obj, j);
                        byte[] bArr5 = zzaka.zza;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        iHashCode = i + iFloatToIntBits;
                        break;
                    case 15:
                        i = iHashCode * 53;
                        iFloatToIntBits = zzalt.zzb(obj, j);
                        iHashCode = i + iFloatToIntBits;
                        break;
                    case 16:
                        i = iHashCode * 53;
                        jDoubleToLongBits = zzalt.zzd(obj, j);
                        byte[] bArr6 = zzaka.zza;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        iHashCode = i + iFloatToIntBits;
                        break;
                    case 17:
                        i2 = iHashCode * 53;
                        Object objZzl2 = zzalt.zzl(obj, j);
                        if (objZzl2 != null) {
                            iHashCode2 = objZzl2.hashCode();
                        }
                        iHashCode = i2 + iHashCode2;
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
                        i = iHashCode * 53;
                        iFloatToIntBits = zzalt.zzl(obj, j).hashCode();
                        iHashCode = i + iFloatToIntBits;
                        break;
                    case 50:
                        i = iHashCode * 53;
                        iFloatToIntBits = zzalt.zzl(obj, j).hashCode();
                        iHashCode = i + iFloatToIntBits;
                        break;
                }
            }
        }
        int i5 = this.zzl;
        while (true) {
            int[] iArr = this.zzj;
            if (i5 >= iArr.length) {
                int iHashCode3 = (iHashCode * 53) + ((zzajo) obj).zzc.hashCode();
                return this.zzh ? (iHashCode3 * 53) + ((zzajl) obj).zzb.zza.hashCode() : iHashCode3;
            }
            int i6 = iArr[i5];
            if (!zzL(obj, 0, i6)) {
                iHashCode = (iHashCode * 53) + zzalt.zzl(obj, zzA(i6) & 1048575).hashCode();
            }
            i5++;
        }
    }

    @Override // com.google.android.gms.internal.nearby.zzald
    public final void zzd(Object obj, Object obj2) {
        zzE(obj);
        obj2.getClass();
        int i = 0;
        while (true) {
            int[] iArr = this.zzc;
            if (i >= iArr.length) {
                zzale.zzB(this.zzm, obj, obj2);
                if (this.zzh) {
                    zzale.zzA(this.zzn, obj, obj2);
                    return;
                }
                return;
            }
            int iZzA = zzA(i);
            int i2 = iArr[i];
            long j = 1048575 & iZzA;
            switch ((iZzA >>> 20) & 255) {
                case 0:
                    if (zzJ(obj2, i)) {
                        zzalt.zzk(obj, j, zzalt.zzj(obj2, j));
                        zzK(obj, i);
                    }
                    break;
                case 1:
                    if (zzJ(obj2, i)) {
                        zzalt.zzi(obj, j, zzalt.zzh(obj2, j));
                        zzK(obj, i);
                    }
                    break;
                case 2:
                    if (zzJ(obj2, i)) {
                        zzalt.zze(obj, j, zzalt.zzd(obj2, j));
                        zzK(obj, i);
                    }
                    break;
                case 3:
                    if (zzJ(obj2, i)) {
                        zzalt.zze(obj, j, zzalt.zzd(obj2, j));
                        zzK(obj, i);
                    }
                    break;
                case 4:
                    if (zzJ(obj2, i)) {
                        zzalt.zzc(obj, j, zzalt.zzb(obj2, j));
                        zzK(obj, i);
                    }
                    break;
                case 5:
                    if (zzJ(obj2, i)) {
                        zzalt.zze(obj, j, zzalt.zzd(obj2, j));
                        zzK(obj, i);
                    }
                    break;
                case 6:
                    if (zzJ(obj2, i)) {
                        zzalt.zzc(obj, j, zzalt.zzb(obj2, j));
                        zzK(obj, i);
                    }
                    break;
                case 7:
                    if (zzJ(obj2, i)) {
                        zzalt.zzg(obj, j, zzalt.zzf(obj2, j));
                        zzK(obj, i);
                    }
                    break;
                case 8:
                    if (zzJ(obj2, i)) {
                        zzalt.zzm(obj, j, zzalt.zzl(obj2, j));
                        zzK(obj, i);
                    }
                    break;
                case 9:
                    zzo(obj, obj2, i);
                    break;
                case 10:
                    if (zzJ(obj2, i)) {
                        zzalt.zzm(obj, j, zzalt.zzl(obj2, j));
                        zzK(obj, i);
                    }
                    break;
                case 11:
                    if (zzJ(obj2, i)) {
                        zzalt.zzc(obj, j, zzalt.zzb(obj2, j));
                        zzK(obj, i);
                    }
                    break;
                case 12:
                    if (zzJ(obj2, i)) {
                        zzalt.zzc(obj, j, zzalt.zzb(obj2, j));
                        zzK(obj, i);
                    }
                    break;
                case 13:
                    if (zzJ(obj2, i)) {
                        zzalt.zzc(obj, j, zzalt.zzb(obj2, j));
                        zzK(obj, i);
                    }
                    break;
                case 14:
                    if (zzJ(obj2, i)) {
                        zzalt.zze(obj, j, zzalt.zzd(obj2, j));
                        zzK(obj, i);
                    }
                    break;
                case 15:
                    if (zzJ(obj2, i)) {
                        zzalt.zzc(obj, j, zzalt.zzb(obj2, j));
                        zzK(obj, i);
                    }
                    break;
                case 16:
                    if (zzJ(obj2, i)) {
                        zzalt.zze(obj, j, zzalt.zzd(obj2, j));
                        zzK(obj, i);
                    }
                    break;
                case 17:
                    zzo(obj, obj2, i);
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
                    zzajz zzajzVarZzg = (zzajz) zzalt.zzl(obj, j);
                    zzajz zzajzVar = (zzajz) zzalt.zzl(obj2, j);
                    int size = zzajzVarZzg.size();
                    int size2 = zzajzVar.size();
                    if (size > 0 && size2 > 0) {
                        if (!zzajzVarZzg.zza()) {
                            zzajzVarZzg = zzajzVarZzg.zzg(size2 + size);
                        }
                        zzajzVarZzg.addAll(zzajzVar);
                    }
                    if (size > 0) {
                        zzajzVar = zzajzVarZzg;
                    }
                    zzalt.zzm(obj, j, zzajzVar);
                    break;
                case 50:
                    int i3 = zzale.zza;
                    zzalt.zzm(obj, j, zzako.zzb(zzalt.zzl(obj, j), zzalt.zzl(obj2, j)));
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
                    if (zzL(obj2, i2, i)) {
                        zzalt.zzm(obj, j, zzalt.zzl(obj2, j));
                        zzN(obj, i2, i);
                    }
                    break;
                case 60:
                    zzp(obj, obj2, i);
                    break;
                case 61:
                case RectListKt.BitOffsetForGesturable /* 62 */:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                    if (zzL(obj2, i2, i)) {
                        zzalt.zzm(obj, j, zzalt.zzl(obj2, j));
                        zzN(obj, i2, i);
                    }
                    break;
                case 68:
                    zzp(obj, obj2, i);
                    break;
            }
            i += 3;
        }
    }

    /* JADX WARN: Code duplicated, block: B:143:0x0416  */
    /* JADX WARN: Code duplicated, block: B:209:0x0607  */
    @Override // com.google.android.gms.internal.nearby.zzald
    public final int zze(Object obj) {
        int i;
        int iNumberOfLeadingZeros;
        int iNumberOfLeadingZeros2;
        int iNumberOfLeadingZeros3;
        int iNumberOfLeadingZeros4;
        int iNumberOfLeadingZeros5;
        int iNumberOfLeadingZeros6;
        int iZzb;
        int iNumberOfLeadingZeros7;
        int iNumberOfLeadingZeros8;
        int iZzx;
        int iNumberOfLeadingZeros9;
        int iNumberOfLeadingZeros10;
        int iNumberOfLeadingZeros11;
        int i2;
        int i3;
        int iZzx2;
        int iZzo;
        int size;
        int iZzp;
        int iNumberOfLeadingZeros12;
        int iZzb2;
        int iNumberOfLeadingZeros13;
        int iZzb3;
        int iNumberOfLeadingZeros14;
        int iNumberOfLeadingZeros15;
        int iNumberOfLeadingZeros16;
        int i4;
        int size2;
        int iNumberOfLeadingZeros17;
        int iNumberOfLeadingZeros18;
        int iZzx3;
        int iNumberOfLeadingZeros19;
        int iNumberOfLeadingZeros20;
        int iNumberOfLeadingZeros21;
        int iNumberOfLeadingZeros22;
        int iNumberOfLeadingZeros23;
        int iNumberOfLeadingZeros24;
        int i5;
        zzakv<T> zzakvVar = this;
        Unsafe unsafe = zzb;
        int i6 = 0;
        int i7 = 0;
        int iNumberOfLeadingZeros25 = 0;
        int i8 = 1048575;
        while (true) {
            int[] iArr = zzakvVar.zzc;
            if (i6 >= iArr.length) {
                int iZzi = iNumberOfLeadingZeros25 + ((zzajo) obj).zzc.zzi();
                if (!zzakvVar.zzh) {
                    return iZzi;
                }
                zzali zzaliVar = ((zzajl) obj).zzb.zza;
                int size3 = zzaliVar.size();
                int iZzh = 0;
                for (int i9 = 0; i9 < size3; i9++) {
                    Map.Entry entryZzb = zzaliVar.zzb(i9);
                    iZzh += zzaje.zzh(((zzalf) entryZzb).zza(), entryZzb.getValue());
                }
                return iZzi + iZzh;
            }
            int iZzA = zzakvVar.zzA(i6);
            int i10 = iArr[i6];
            int i11 = iArr[i6 + 2];
            int i12 = i11 & 1048575;
            int i13 = (iZzA >>> 20) & 255;
            if (i13 <= 17) {
                if (i12 != i8) {
                    i7 = i12 == 1048575 ? 0 : unsafe.getInt(obj, i12);
                    i8 = i12;
                }
                i = 1 << (i11 >>> 20);
            } else {
                i = 0;
            }
            int i14 = iZzA & 1048575;
            if (i13 >= zzajf.DOUBLE_LIST_PACKED.zza()) {
                zzajf.SINT64_LIST_PACKED.zza();
            }
            long j = i14;
            switch (i13) {
                case 0:
                    if (zzakvVar.zzI(obj, i6, i8, i7, i)) {
                        iNumberOfLeadingZeros25 += ((352 - (Integer.numberOfLeadingZeros(i10 << 3) * 9)) >>> 6) + 8;
                    }
                    break;
                case 1:
                    if (zzakvVar.zzI(obj, i6, i8, i7, i)) {
                        iNumberOfLeadingZeros = Integer.numberOfLeadingZeros(i10 << 3);
                        iNumberOfLeadingZeros5 = ((352 - (iNumberOfLeadingZeros * 9)) >>> 6) + 4;
                        iNumberOfLeadingZeros25 += iNumberOfLeadingZeros5;
                    }
                    zzakvVar = this;
                    break;
                case 2:
                    if (zzakvVar.zzI(obj, i6, i8, i7, i)) {
                        long j2 = unsafe.getLong(obj, j);
                        iNumberOfLeadingZeros2 = Integer.numberOfLeadingZeros(i10 << 3) * 9;
                        iNumberOfLeadingZeros3 = Long.numberOfLeadingZeros(j2);
                        i2 = (352 - iNumberOfLeadingZeros2) >>> 6;
                        i3 = 640 - (iNumberOfLeadingZeros3 * 9);
                        iNumberOfLeadingZeros5 = i2 + (i3 >>> 6);
                        iNumberOfLeadingZeros25 += iNumberOfLeadingZeros5;
                    }
                    zzakvVar = this;
                    break;
                case 3:
                    if (zzakvVar.zzI(obj, i6, i8, i7, i)) {
                        long j3 = unsafe.getLong(obj, j);
                        iNumberOfLeadingZeros2 = Integer.numberOfLeadingZeros(i10 << 3) * 9;
                        iNumberOfLeadingZeros3 = Long.numberOfLeadingZeros(j3);
                        i2 = (352 - iNumberOfLeadingZeros2) >>> 6;
                        i3 = 640 - (iNumberOfLeadingZeros3 * 9);
                        iNumberOfLeadingZeros5 = i2 + (i3 >>> 6);
                        iNumberOfLeadingZeros25 += iNumberOfLeadingZeros5;
                    }
                    zzakvVar = this;
                    break;
                case 4:
                    if (zzakvVar.zzI(obj, i6, i8, i7, i)) {
                        int i15 = unsafe.getInt(obj, j);
                        iNumberOfLeadingZeros2 = Integer.numberOfLeadingZeros(i10 << 3) * 9;
                        iNumberOfLeadingZeros3 = Long.numberOfLeadingZeros(i15);
                        i2 = (352 - iNumberOfLeadingZeros2) >>> 6;
                        i3 = 640 - (iNumberOfLeadingZeros3 * 9);
                        iNumberOfLeadingZeros5 = i2 + (i3 >>> 6);
                        iNumberOfLeadingZeros25 += iNumberOfLeadingZeros5;
                    }
                    zzakvVar = this;
                    break;
                case 5:
                    if (zzakvVar.zzI(obj, i6, i8, i7, i)) {
                        iNumberOfLeadingZeros4 = Integer.numberOfLeadingZeros(i10 << 3);
                        iNumberOfLeadingZeros5 = ((352 - (iNumberOfLeadingZeros4 * 9)) >>> 6) + 8;
                        iNumberOfLeadingZeros25 += iNumberOfLeadingZeros5;
                    }
                    zzakvVar = this;
                    break;
                case 6:
                    if (zzakvVar.zzI(obj, i6, i8, i7, i)) {
                        iNumberOfLeadingZeros = Integer.numberOfLeadingZeros(i10 << 3);
                        iNumberOfLeadingZeros5 = ((352 - (iNumberOfLeadingZeros * 9)) >>> 6) + 4;
                        iNumberOfLeadingZeros25 += iNumberOfLeadingZeros5;
                    }
                    zzakvVar = this;
                    break;
                case 7:
                    if (zzakvVar.zzI(obj, i6, i8, i7, i)) {
                        iNumberOfLeadingZeros5 = ((352 - (Integer.numberOfLeadingZeros(i10 << 3) * 9)) >>> 6) + 1;
                        iNumberOfLeadingZeros25 += iNumberOfLeadingZeros5;
                    }
                    zzakvVar = this;
                    break;
                case 8:
                    if (zzakvVar.zzI(obj, i6, i8, i7, i)) {
                        int i16 = i10 << 3;
                        Object object = unsafe.getObject(obj, j);
                        if (object instanceof zzaik) {
                            iNumberOfLeadingZeros6 = Integer.numberOfLeadingZeros(i16) * 9;
                            iZzb = ((zzaik) object).zzb();
                            iNumberOfLeadingZeros7 = Integer.numberOfLeadingZeros(iZzb);
                        } else {
                            iNumberOfLeadingZeros6 = Integer.numberOfLeadingZeros(i16) * 9;
                            iZzb = zzaly.zzb((String) object);
                            iNumberOfLeadingZeros7 = Integer.numberOfLeadingZeros(iZzb);
                        }
                        iNumberOfLeadingZeros5 = ((352 - iNumberOfLeadingZeros6) >>> 6) + ((352 - (iNumberOfLeadingZeros7 * 9)) >>> 6) + iZzb;
                        iNumberOfLeadingZeros25 += iNumberOfLeadingZeros5;
                    }
                    zzakvVar = this;
                    break;
                case 9:
                    if (zzakvVar.zzI(obj, i6, i8, i7, i)) {
                        int i17 = i10 << 3;
                        Object object2 = unsafe.getObject(obj, j);
                        zzald zzaldVarZzq = zzakvVar.zzq(i6);
                        int i18 = zzale.zza;
                        iNumberOfLeadingZeros8 = Integer.numberOfLeadingZeros(i17) * 9;
                        iZzx = ((zzahu) object2).zzx(zzaldVarZzq);
                        iNumberOfLeadingZeros9 = Integer.numberOfLeadingZeros(iZzx);
                        iZzx2 = ((352 - iNumberOfLeadingZeros8) >>> 6) + ((352 - (iNumberOfLeadingZeros9 * 9)) >>> 6) + iZzx;
                        iNumberOfLeadingZeros25 += iZzx2;
                    }
                    break;
                case 10:
                    if (zzakvVar.zzI(obj, i6, i8, i7, i)) {
                        zzaik zzaikVar = (zzaik) unsafe.getObject(obj, j);
                        iNumberOfLeadingZeros6 = Integer.numberOfLeadingZeros(i10 << 3) * 9;
                        iZzb = zzaikVar.zzb();
                        iNumberOfLeadingZeros7 = Integer.numberOfLeadingZeros(iZzb);
                        iNumberOfLeadingZeros5 = ((352 - iNumberOfLeadingZeros6) >>> 6) + ((352 - (iNumberOfLeadingZeros7 * 9)) >>> 6) + iZzb;
                        iNumberOfLeadingZeros25 += iNumberOfLeadingZeros5;
                    }
                    zzakvVar = this;
                    break;
                case 11:
                    if (zzakvVar.zzI(obj, i6, i8, i7, i)) {
                        int i19 = unsafe.getInt(obj, j);
                        iNumberOfLeadingZeros10 = Integer.numberOfLeadingZeros(i10 << 3) * 9;
                        iNumberOfLeadingZeros11 = Integer.numberOfLeadingZeros(i19);
                        i2 = (352 - iNumberOfLeadingZeros10) >>> 6;
                        i3 = 352 - (iNumberOfLeadingZeros11 * 9);
                        iNumberOfLeadingZeros5 = i2 + (i3 >>> 6);
                        iNumberOfLeadingZeros25 += iNumberOfLeadingZeros5;
                    }
                    zzakvVar = this;
                    break;
                case 12:
                    if (zzakvVar.zzI(obj, i6, i8, i7, i)) {
                        int i20 = unsafe.getInt(obj, j);
                        iNumberOfLeadingZeros2 = Integer.numberOfLeadingZeros(i10 << 3) * 9;
                        iNumberOfLeadingZeros3 = Long.numberOfLeadingZeros(i20);
                        i2 = (352 - iNumberOfLeadingZeros2) >>> 6;
                        i3 = 640 - (iNumberOfLeadingZeros3 * 9);
                        iNumberOfLeadingZeros5 = i2 + (i3 >>> 6);
                        iNumberOfLeadingZeros25 += iNumberOfLeadingZeros5;
                    }
                    zzakvVar = this;
                    break;
                case 13:
                    if (zzakvVar.zzI(obj, i6, i8, i7, i)) {
                        iNumberOfLeadingZeros = Integer.numberOfLeadingZeros(i10 << 3);
                        iNumberOfLeadingZeros5 = ((352 - (iNumberOfLeadingZeros * 9)) >>> 6) + 4;
                        iNumberOfLeadingZeros25 += iNumberOfLeadingZeros5;
                    }
                    zzakvVar = this;
                    break;
                case 14:
                    if (zzakvVar.zzI(obj, i6, i8, i7, i)) {
                        iNumberOfLeadingZeros4 = Integer.numberOfLeadingZeros(i10 << 3);
                        iNumberOfLeadingZeros5 = ((352 - (iNumberOfLeadingZeros4 * 9)) >>> 6) + 8;
                        iNumberOfLeadingZeros25 += iNumberOfLeadingZeros5;
                    }
                    zzakvVar = this;
                    break;
                case 15:
                    if (zzakvVar.zzI(obj, i6, i8, i7, i)) {
                        int i21 = unsafe.getInt(obj, j);
                        iNumberOfLeadingZeros10 = Integer.numberOfLeadingZeros(i10 << 3) * 9;
                        iNumberOfLeadingZeros11 = Integer.numberOfLeadingZeros((i21 >> 31) ^ (i21 + i21));
                        i2 = (352 - iNumberOfLeadingZeros10) >>> 6;
                        i3 = 352 - (iNumberOfLeadingZeros11 * 9);
                        iNumberOfLeadingZeros5 = i2 + (i3 >>> 6);
                        iNumberOfLeadingZeros25 += iNumberOfLeadingZeros5;
                    }
                    zzakvVar = this;
                    break;
                case 16:
                    if (zzakvVar.zzI(obj, i6, i8, i7, i)) {
                        long j4 = unsafe.getLong(obj, j);
                        iNumberOfLeadingZeros2 = Integer.numberOfLeadingZeros(i10 << 3) * 9;
                        iNumberOfLeadingZeros3 = Long.numberOfLeadingZeros((j4 >> 63) ^ (j4 + j4));
                        i2 = (352 - iNumberOfLeadingZeros2) >>> 6;
                        i3 = 640 - (iNumberOfLeadingZeros3 * 9);
                        iNumberOfLeadingZeros5 = i2 + (i3 >>> 6);
                        iNumberOfLeadingZeros25 += iNumberOfLeadingZeros5;
                    }
                    zzakvVar = this;
                    break;
                case 17:
                    if (zzakvVar.zzI(obj, i6, i8, i7, i)) {
                        iZzx2 = zzale.zzx(i10, (zzaks) unsafe.getObject(obj, j), zzakvVar.zzq(i6));
                        iNumberOfLeadingZeros25 += iZzx2;
                    }
                    break;
                case 18:
                    iZzx2 = zzale.zzw(i10, (List) unsafe.getObject(obj, j), false);
                    iNumberOfLeadingZeros25 += iZzx2;
                    break;
                case 19:
                    iZzx2 = zzale.zzv(i10, (List) unsafe.getObject(obj, j), false);
                    iNumberOfLeadingZeros25 += iZzx2;
                    break;
                case 20:
                    List list = (List) unsafe.getObject(obj, j);
                    int i22 = zzale.zza;
                    if (list.size() == 0) {
                        iZzo = 0;
                    } else {
                        iZzo = zzale.zzo(list) + (list.size() * ((352 - (Integer.numberOfLeadingZeros(i10 << 3) * 9)) >>> 6));
                    }
                    iNumberOfLeadingZeros25 += iZzo;
                    break;
                case 21:
                    List list2 = (List) unsafe.getObject(obj, j);
                    int i23 = zzale.zza;
                    size = list2.size();
                    if (size == 0) {
                        iZzx2 = 0;
                    } else {
                        iZzp = zzale.zzp(list2);
                        iNumberOfLeadingZeros12 = Integer.numberOfLeadingZeros(i10 << 3);
                        i4 = size * ((352 - (iNumberOfLeadingZeros12 * 9)) >>> 6);
                        iZzx2 = iZzp + i4;
                    }
                    iNumberOfLeadingZeros25 += iZzx2;
                    break;
                case 22:
                    List list3 = (List) unsafe.getObject(obj, j);
                    int i24 = zzale.zza;
                    size = list3.size();
                    if (size == 0) {
                        iZzx2 = 0;
                    } else {
                        iZzp = zzale.zzs(list3);
                        iNumberOfLeadingZeros12 = Integer.numberOfLeadingZeros(i10 << 3);
                        i4 = size * ((352 - (iNumberOfLeadingZeros12 * 9)) >>> 6);
                        iZzx2 = iZzp + i4;
                    }
                    iNumberOfLeadingZeros25 += iZzx2;
                    break;
                case 23:
                    iZzx2 = zzale.zzw(i10, (List) unsafe.getObject(obj, j), false);
                    iNumberOfLeadingZeros25 += iZzx2;
                    break;
                case 24:
                    iZzx2 = zzale.zzv(i10, (List) unsafe.getObject(obj, j), false);
                    iNumberOfLeadingZeros25 += iZzx2;
                    break;
                case 25:
                    List list4 = (List) unsafe.getObject(obj, j);
                    int i25 = zzale.zza;
                    int size4 = list4.size();
                    if (size4 == 0) {
                        iZzx2 = 0;
                    } else {
                        iZzx2 = size4 * (((352 - (Integer.numberOfLeadingZeros(i10 << 3) * 9)) >>> 6) + 1);
                    }
                    iNumberOfLeadingZeros25 += iZzx2;
                    break;
                case 26:
                    List list5 = (List) unsafe.getObject(obj, j);
                    int i26 = zzale.zza;
                    int size5 = list5.size();
                    if (size5 == 0) {
                        iZzo = 0;
                    } else {
                        iZzo = ((352 - (Integer.numberOfLeadingZeros(i10 << 3) * 9)) >>> 6) * size5;
                        if (list5 instanceof zzakh) {
                            zzakh zzakhVar = (zzakh) list5;
                            for (int i27 = 0; i27 < size5; i27++) {
                                Object objZzb = zzakhVar.zzb();
                                if (objZzb instanceof zzaik) {
                                    iZzb3 = ((zzaik) objZzb).zzb();
                                    iNumberOfLeadingZeros14 = Integer.numberOfLeadingZeros(iZzb3);
                                } else {
                                    iZzb3 = zzaly.zzb((String) objZzb);
                                    iNumberOfLeadingZeros14 = Integer.numberOfLeadingZeros(iZzb3);
                                }
                                iZzo += ((352 - (iNumberOfLeadingZeros14 * 9)) >>> 6) + iZzb3;
                            }
                        } else {
                            for (int i28 = 0; i28 < size5; i28++) {
                                Object obj2 = list5.get(i28);
                                if (obj2 instanceof zzaik) {
                                    iZzb2 = ((zzaik) obj2).zzb();
                                    iNumberOfLeadingZeros13 = Integer.numberOfLeadingZeros(iZzb2);
                                } else {
                                    iZzb2 = zzaly.zzb((String) obj2);
                                    iNumberOfLeadingZeros13 = Integer.numberOfLeadingZeros(iZzb2);
                                }
                                iZzo += ((352 - (iNumberOfLeadingZeros13 * 9)) >>> 6) + iZzb2;
                            }
                        }
                    }
                    iNumberOfLeadingZeros25 += iZzo;
                    break;
                case 27:
                    List list6 = (List) unsafe.getObject(obj, j);
                    zzald zzaldVarZzq2 = zzakvVar.zzq(i6);
                    int i29 = zzale.zza;
                    int size6 = list6.size();
                    if (size6 == 0) {
                        iNumberOfLeadingZeros15 = 0;
                    } else {
                        iNumberOfLeadingZeros15 = ((352 - (Integer.numberOfLeadingZeros(i10 << 3) * 9)) >>> 6) * size6;
                        for (int i30 = 0; i30 < size6; i30++) {
                            int iZzx4 = ((zzahu) list6.get(i30)).zzx(zzaldVarZzq2);
                            iNumberOfLeadingZeros15 += ((352 - (Integer.numberOfLeadingZeros(iZzx4) * 9)) >>> 6) + iZzx4;
                        }
                    }
                    iNumberOfLeadingZeros25 += iNumberOfLeadingZeros15;
                    break;
                case 28:
                    List list7 = (List) unsafe.getObject(obj, j);
                    int i31 = zzale.zza;
                    int size7 = list7.size();
                    if (size7 == 0) {
                        iNumberOfLeadingZeros16 = 0;
                    } else {
                        iNumberOfLeadingZeros16 = size7 * ((352 - (Integer.numberOfLeadingZeros(i10 << 3) * 9)) >>> 6);
                        for (int i32 = 0; i32 < list7.size(); i32++) {
                            int iZzb4 = ((zzaik) list7.get(i32)).zzb();
                            iNumberOfLeadingZeros16 += ((352 - (Integer.numberOfLeadingZeros(iZzb4) * 9)) >>> 6) + iZzb4;
                        }
                    }
                    iNumberOfLeadingZeros25 += iNumberOfLeadingZeros16;
                    break;
                case 29:
                    List list8 = (List) unsafe.getObject(obj, j);
                    int i33 = zzale.zza;
                    size = list8.size();
                    if (size == 0) {
                        iZzx2 = 0;
                    } else {
                        iZzp = zzale.zzt(list8);
                        iNumberOfLeadingZeros12 = Integer.numberOfLeadingZeros(i10 << 3);
                        i4 = size * ((352 - (iNumberOfLeadingZeros12 * 9)) >>> 6);
                        iZzx2 = iZzp + i4;
                    }
                    iNumberOfLeadingZeros25 += iZzx2;
                    break;
                case 30:
                    List list9 = (List) unsafe.getObject(obj, j);
                    int i34 = zzale.zza;
                    size = list9.size();
                    if (size == 0) {
                        iZzx2 = 0;
                    } else {
                        iZzp = zzale.zzr(list9);
                        iNumberOfLeadingZeros12 = Integer.numberOfLeadingZeros(i10 << 3);
                        i4 = size * ((352 - (iNumberOfLeadingZeros12 * 9)) >>> 6);
                        iZzx2 = iZzp + i4;
                    }
                    iNumberOfLeadingZeros25 += iZzx2;
                    break;
                case 31:
                    iZzx2 = zzale.zzv(i10, (List) unsafe.getObject(obj, j), false);
                    iNumberOfLeadingZeros25 += iZzx2;
                    break;
                case 32:
                    iZzx2 = zzale.zzw(i10, (List) unsafe.getObject(obj, j), false);
                    iNumberOfLeadingZeros25 += iZzx2;
                    break;
                case 33:
                    List list10 = (List) unsafe.getObject(obj, j);
                    int i35 = zzale.zza;
                    size = list10.size();
                    if (size == 0) {
                        iZzx2 = 0;
                    } else {
                        iZzp = zzale.zzu(list10);
                        iNumberOfLeadingZeros12 = Integer.numberOfLeadingZeros(i10 << 3);
                        i4 = size * ((352 - (iNumberOfLeadingZeros12 * 9)) >>> 6);
                        iZzx2 = iZzp + i4;
                    }
                    iNumberOfLeadingZeros25 += iZzx2;
                    break;
                case 34:
                    List list11 = (List) unsafe.getObject(obj, j);
                    int i36 = zzale.zza;
                    size = list11.size();
                    if (size == 0) {
                        iZzx2 = 0;
                    } else {
                        iZzp = zzale.zzq(list11);
                        iNumberOfLeadingZeros12 = Integer.numberOfLeadingZeros(i10 << 3);
                        i4 = size * ((352 - (iNumberOfLeadingZeros12 * 9)) >>> 6);
                        iZzx2 = iZzp + i4;
                    }
                    iNumberOfLeadingZeros25 += iZzx2;
                    break;
                case 35:
                    List list12 = (List) unsafe.getObject(obj, j);
                    int i37 = zzale.zza;
                    size2 = list12.size() * 8;
                    if (size2 > 0) {
                        iNumberOfLeadingZeros17 = Integer.numberOfLeadingZeros(i10 << 3) * 9;
                        iNumberOfLeadingZeros18 = Integer.numberOfLeadingZeros(size2);
                        iNumberOfLeadingZeros16 = ((352 - iNumberOfLeadingZeros17) >>> 6) + ((352 - (iNumberOfLeadingZeros18 * 9)) >>> 6) + size2;
                        iNumberOfLeadingZeros25 += iNumberOfLeadingZeros16;
                    }
                    break;
                case 36:
                    List list13 = (List) unsafe.getObject(obj, j);
                    int i38 = zzale.zza;
                    size2 = list13.size() * 4;
                    if (size2 > 0) {
                        iNumberOfLeadingZeros17 = Integer.numberOfLeadingZeros(i10 << 3) * 9;
                        iNumberOfLeadingZeros18 = Integer.numberOfLeadingZeros(size2);
                        iNumberOfLeadingZeros16 = ((352 - iNumberOfLeadingZeros17) >>> 6) + ((352 - (iNumberOfLeadingZeros18 * 9)) >>> 6) + size2;
                        iNumberOfLeadingZeros25 += iNumberOfLeadingZeros16;
                    }
                    break;
                case 37:
                    size2 = zzale.zzo((List) unsafe.getObject(obj, j));
                    if (size2 > 0) {
                        iNumberOfLeadingZeros17 = Integer.numberOfLeadingZeros(i10 << 3) * 9;
                        iNumberOfLeadingZeros18 = Integer.numberOfLeadingZeros(size2);
                        iNumberOfLeadingZeros16 = ((352 - iNumberOfLeadingZeros17) >>> 6) + ((352 - (iNumberOfLeadingZeros18 * 9)) >>> 6) + size2;
                        iNumberOfLeadingZeros25 += iNumberOfLeadingZeros16;
                    }
                    break;
                case MotionEventCompat.AXIS_GENERIC_7 /* 38 */:
                    size2 = zzale.zzp((List) unsafe.getObject(obj, j));
                    if (size2 > 0) {
                        iNumberOfLeadingZeros17 = Integer.numberOfLeadingZeros(i10 << 3) * 9;
                        iNumberOfLeadingZeros18 = Integer.numberOfLeadingZeros(size2);
                        iNumberOfLeadingZeros16 = ((352 - iNumberOfLeadingZeros17) >>> 6) + ((352 - (iNumberOfLeadingZeros18 * 9)) >>> 6) + size2;
                        iNumberOfLeadingZeros25 += iNumberOfLeadingZeros16;
                    }
                    break;
                case 39:
                    size2 = zzale.zzs((List) unsafe.getObject(obj, j));
                    if (size2 > 0) {
                        iNumberOfLeadingZeros17 = Integer.numberOfLeadingZeros(i10 << 3) * 9;
                        iNumberOfLeadingZeros18 = Integer.numberOfLeadingZeros(size2);
                        iNumberOfLeadingZeros16 = ((352 - iNumberOfLeadingZeros17) >>> 6) + ((352 - (iNumberOfLeadingZeros18 * 9)) >>> 6) + size2;
                        iNumberOfLeadingZeros25 += iNumberOfLeadingZeros16;
                    }
                    break;
                case 40:
                    List list14 = (List) unsafe.getObject(obj, j);
                    int i39 = zzale.zza;
                    size2 = list14.size() * 8;
                    if (size2 > 0) {
                        iNumberOfLeadingZeros17 = Integer.numberOfLeadingZeros(i10 << 3) * 9;
                        iNumberOfLeadingZeros18 = Integer.numberOfLeadingZeros(size2);
                        iNumberOfLeadingZeros16 = ((352 - iNumberOfLeadingZeros17) >>> 6) + ((352 - (iNumberOfLeadingZeros18 * 9)) >>> 6) + size2;
                        iNumberOfLeadingZeros25 += iNumberOfLeadingZeros16;
                    }
                    break;
                case 41:
                    List list15 = (List) unsafe.getObject(obj, j);
                    int i40 = zzale.zza;
                    size2 = list15.size() * 4;
                    if (size2 > 0) {
                        iNumberOfLeadingZeros17 = Integer.numberOfLeadingZeros(i10 << 3) * 9;
                        iNumberOfLeadingZeros18 = Integer.numberOfLeadingZeros(size2);
                        iNumberOfLeadingZeros16 = ((352 - iNumberOfLeadingZeros17) >>> 6) + ((352 - (iNumberOfLeadingZeros18 * 9)) >>> 6) + size2;
                        iNumberOfLeadingZeros25 += iNumberOfLeadingZeros16;
                    }
                    break;
                case MotionEventCompat.AXIS_GENERIC_11 /* 42 */:
                    List list16 = (List) unsafe.getObject(obj, j);
                    int i41 = zzale.zza;
                    size2 = list16.size();
                    if (size2 > 0) {
                        iNumberOfLeadingZeros17 = Integer.numberOfLeadingZeros(i10 << 3) * 9;
                        iNumberOfLeadingZeros18 = Integer.numberOfLeadingZeros(size2);
                        iNumberOfLeadingZeros16 = ((352 - iNumberOfLeadingZeros17) >>> 6) + ((352 - (iNumberOfLeadingZeros18 * 9)) >>> 6) + size2;
                        iNumberOfLeadingZeros25 += iNumberOfLeadingZeros16;
                    }
                    break;
                case MotionEventCompat.AXIS_GENERIC_12 /* 43 */:
                    size2 = zzale.zzt((List) unsafe.getObject(obj, j));
                    if (size2 > 0) {
                        iNumberOfLeadingZeros17 = Integer.numberOfLeadingZeros(i10 << 3) * 9;
                        iNumberOfLeadingZeros18 = Integer.numberOfLeadingZeros(size2);
                        iNumberOfLeadingZeros16 = ((352 - iNumberOfLeadingZeros17) >>> 6) + ((352 - (iNumberOfLeadingZeros18 * 9)) >>> 6) + size2;
                        iNumberOfLeadingZeros25 += iNumberOfLeadingZeros16;
                    }
                    break;
                case 44:
                    size2 = zzale.zzr((List) unsafe.getObject(obj, j));
                    if (size2 > 0) {
                        iNumberOfLeadingZeros17 = Integer.numberOfLeadingZeros(i10 << 3) * 9;
                        iNumberOfLeadingZeros18 = Integer.numberOfLeadingZeros(size2);
                        iNumberOfLeadingZeros16 = ((352 - iNumberOfLeadingZeros17) >>> 6) + ((352 - (iNumberOfLeadingZeros18 * 9)) >>> 6) + size2;
                        iNumberOfLeadingZeros25 += iNumberOfLeadingZeros16;
                    }
                    break;
                case 45:
                    List list17 = (List) unsafe.getObject(obj, j);
                    int i42 = zzale.zza;
                    size2 = list17.size() * 4;
                    if (size2 > 0) {
                        iNumberOfLeadingZeros17 = Integer.numberOfLeadingZeros(i10 << 3) * 9;
                        iNumberOfLeadingZeros18 = Integer.numberOfLeadingZeros(size2);
                        iNumberOfLeadingZeros16 = ((352 - iNumberOfLeadingZeros17) >>> 6) + ((352 - (iNumberOfLeadingZeros18 * 9)) >>> 6) + size2;
                        iNumberOfLeadingZeros25 += iNumberOfLeadingZeros16;
                    }
                    break;
                case MotionEventCompat.AXIS_GENERIC_15 /* 46 */:
                    List list18 = (List) unsafe.getObject(obj, j);
                    int i43 = zzale.zza;
                    size2 = list18.size() * 8;
                    if (size2 > 0) {
                        iNumberOfLeadingZeros17 = Integer.numberOfLeadingZeros(i10 << 3) * 9;
                        iNumberOfLeadingZeros18 = Integer.numberOfLeadingZeros(size2);
                        iNumberOfLeadingZeros16 = ((352 - iNumberOfLeadingZeros17) >>> 6) + ((352 - (iNumberOfLeadingZeros18 * 9)) >>> 6) + size2;
                        iNumberOfLeadingZeros25 += iNumberOfLeadingZeros16;
                    }
                    break;
                case MotionEventCompat.AXIS_GENERIC_16 /* 47 */:
                    size2 = zzale.zzu((List) unsafe.getObject(obj, j));
                    if (size2 > 0) {
                        iNumberOfLeadingZeros17 = Integer.numberOfLeadingZeros(i10 << 3) * 9;
                        iNumberOfLeadingZeros18 = Integer.numberOfLeadingZeros(size2);
                        iNumberOfLeadingZeros16 = ((352 - iNumberOfLeadingZeros17) >>> 6) + ((352 - (iNumberOfLeadingZeros18 * 9)) >>> 6) + size2;
                        iNumberOfLeadingZeros25 += iNumberOfLeadingZeros16;
                    }
                    break;
                case 48:
                    size2 = zzale.zzq((List) unsafe.getObject(obj, j));
                    if (size2 > 0) {
                        iNumberOfLeadingZeros17 = Integer.numberOfLeadingZeros(i10 << 3) * 9;
                        iNumberOfLeadingZeros18 = Integer.numberOfLeadingZeros(size2);
                        iNumberOfLeadingZeros16 = ((352 - iNumberOfLeadingZeros17) >>> 6) + ((352 - (iNumberOfLeadingZeros18 * 9)) >>> 6) + size2;
                        iNumberOfLeadingZeros25 += iNumberOfLeadingZeros16;
                    }
                    break;
                case 49:
                    List list19 = (List) unsafe.getObject(obj, j);
                    zzald zzaldVarZzq3 = zzakvVar.zzq(i6);
                    int i44 = zzale.zza;
                    int size8 = list19.size();
                    if (size8 == 0) {
                        iZzx3 = 0;
                    } else {
                        iZzx3 = 0;
                        for (int i45 = 0; i45 < size8; i45++) {
                            iZzx3 += zzale.zzx(i10, (zzaks) list19.get(i45), zzaldVarZzq3);
                        }
                    }
                    iNumberOfLeadingZeros25 += iZzx3;
                    break;
                case 50:
                    zzakn zzaknVar = (zzakn) unsafe.getObject(obj, j);
                    zzakm zzakmVar = (zzakm) zzakvVar.zzr(i6);
                    if (zzaknVar.isEmpty()) {
                        iZzo = 0;
                    } else {
                        iZzo = 0;
                        for (Map.Entry entry : zzaknVar.entrySet()) {
                            iZzo += zzakmVar.zzd(i10, entry.getKey(), entry.getValue());
                        }
                    }
                    iNumberOfLeadingZeros25 += iZzo;
                    break;
                case StylePropertiesKt.BackgroundBrushId /* 51 */:
                    if (zzakvVar.zzL(obj, i10, i6)) {
                        iNumberOfLeadingZeros19 = Integer.numberOfLeadingZeros(i10 << 3);
                        iZzx2 = ((352 - (iNumberOfLeadingZeros19 * 9)) >>> 6) + 8;
                        iNumberOfLeadingZeros25 += iZzx2;
                    }
                    break;
                case StylePropertiesKt.ForegroundBrushId /* 52 */:
                    if (zzakvVar.zzL(obj, i10, i6)) {
                        iNumberOfLeadingZeros20 = Integer.numberOfLeadingZeros(i10 << 3);
                        iZzx2 = ((352 - (iNumberOfLeadingZeros20 * 9)) >>> 6) + 4;
                        iNumberOfLeadingZeros25 += iZzx2;
                    }
                    break;
                case StylePropertiesKt.ShapeId /* 53 */:
                    if (zzakvVar.zzL(obj, i10, i6)) {
                        long jZzG = zzG(obj, j);
                        iNumberOfLeadingZeros21 = Integer.numberOfLeadingZeros(i10 << 3) * 9;
                        iNumberOfLeadingZeros22 = Long.numberOfLeadingZeros(jZzG);
                        iZzp = (352 - iNumberOfLeadingZeros21) >>> 6;
                        i5 = 640 - (iNumberOfLeadingZeros22 * 9);
                        i4 = i5 >>> 6;
                        iZzx2 = iZzp + i4;
                        iNumberOfLeadingZeros25 += iZzx2;
                    }
                    break;
                case StylePropertiesKt.ColorFilterId /* 54 */:
                    if (zzakvVar.zzL(obj, i10, i6)) {
                        long jZzG2 = zzG(obj, j);
                        iNumberOfLeadingZeros21 = Integer.numberOfLeadingZeros(i10 << 3) * 9;
                        iNumberOfLeadingZeros22 = Long.numberOfLeadingZeros(jZzG2);
                        iZzp = (352 - iNumberOfLeadingZeros21) >>> 6;
                        i5 = 640 - (iNumberOfLeadingZeros22 * 9);
                        i4 = i5 >>> 6;
                        iZzx2 = iZzp + i4;
                        iNumberOfLeadingZeros25 += iZzx2;
                    }
                    break;
                case StylePropertiesKt.DropShadowId /* 55 */:
                    if (zzakvVar.zzL(obj, i10, i6)) {
                        int iZzF = zzF(obj, j);
                        iNumberOfLeadingZeros21 = Integer.numberOfLeadingZeros(i10 << 3) * 9;
                        iNumberOfLeadingZeros22 = Long.numberOfLeadingZeros(iZzF);
                        iZzp = (352 - iNumberOfLeadingZeros21) >>> 6;
                        i5 = 640 - (iNumberOfLeadingZeros22 * 9);
                        i4 = i5 >>> 6;
                        iZzx2 = iZzp + i4;
                        iNumberOfLeadingZeros25 += iZzx2;
                    }
                    break;
                case StylePropertiesKt.InnerShadowId /* 56 */:
                    if (zzakvVar.zzL(obj, i10, i6)) {
                        iNumberOfLeadingZeros19 = Integer.numberOfLeadingZeros(i10 << 3);
                        iZzx2 = ((352 - (iNumberOfLeadingZeros19 * 9)) >>> 6) + 8;
                        iNumberOfLeadingZeros25 += iZzx2;
                    }
                    break;
                case StylePropertiesKt.ContentBrushId /* 57 */:
                    if (zzakvVar.zzL(obj, i10, i6)) {
                        iNumberOfLeadingZeros20 = Integer.numberOfLeadingZeros(i10 << 3);
                        iZzx2 = ((352 - (iNumberOfLeadingZeros20 * 9)) >>> 6) + 4;
                        iNumberOfLeadingZeros25 += iZzx2;
                    }
                    break;
                case StylePropertiesKt.FontFamilyId /* 58 */:
                    if (zzakvVar.zzL(obj, i10, i6)) {
                        iZzx2 = ((352 - (Integer.numberOfLeadingZeros(i10 << 3) * 9)) >>> 6) + 1;
                        iNumberOfLeadingZeros25 += iZzx2;
                    }
                    break;
                case StylePropertiesKt.TextMotionId /* 59 */:
                    if (zzakvVar.zzL(obj, i10, i6)) {
                        int i46 = i10 << 3;
                        Object object3 = unsafe.getObject(obj, j);
                        if (object3 instanceof zzaik) {
                            iNumberOfLeadingZeros8 = Integer.numberOfLeadingZeros(i46) * 9;
                            iZzx = ((zzaik) object3).zzb();
                            iNumberOfLeadingZeros9 = Integer.numberOfLeadingZeros(iZzx);
                        } else {
                            iNumberOfLeadingZeros8 = Integer.numberOfLeadingZeros(i46) * 9;
                            iZzx = zzaly.zzb((String) object3);
                            iNumberOfLeadingZeros9 = Integer.numberOfLeadingZeros(iZzx);
                        }
                        iZzx2 = ((352 - iNumberOfLeadingZeros8) >>> 6) + ((352 - (iNumberOfLeadingZeros9 * 9)) >>> 6) + iZzx;
                        iNumberOfLeadingZeros25 += iZzx2;
                    }
                    break;
                case 60:
                    if (zzakvVar.zzL(obj, i10, i6)) {
                        int i47 = i10 << 3;
                        Object object4 = unsafe.getObject(obj, j);
                        zzald zzaldVarZzq4 = zzakvVar.zzq(i6);
                        int i48 = zzale.zza;
                        iNumberOfLeadingZeros8 = Integer.numberOfLeadingZeros(i47) * 9;
                        iZzx = ((zzahu) object4).zzx(zzaldVarZzq4);
                        iNumberOfLeadingZeros9 = Integer.numberOfLeadingZeros(iZzx);
                        iZzx2 = ((352 - iNumberOfLeadingZeros8) >>> 6) + ((352 - (iNumberOfLeadingZeros9 * 9)) >>> 6) + iZzx;
                        iNumberOfLeadingZeros25 += iZzx2;
                    }
                    break;
                case 61:
                    if (zzakvVar.zzL(obj, i10, i6)) {
                        zzaik zzaikVar2 = (zzaik) unsafe.getObject(obj, j);
                        iNumberOfLeadingZeros8 = Integer.numberOfLeadingZeros(i10 << 3) * 9;
                        iZzx = zzaikVar2.zzb();
                        iNumberOfLeadingZeros9 = Integer.numberOfLeadingZeros(iZzx);
                        iZzx2 = ((352 - iNumberOfLeadingZeros8) >>> 6) + ((352 - (iNumberOfLeadingZeros9 * 9)) >>> 6) + iZzx;
                        iNumberOfLeadingZeros25 += iZzx2;
                    }
                    break;
                case RectListKt.BitOffsetForGesturable /* 62 */:
                    if (zzakvVar.zzL(obj, i10, i6)) {
                        int iZzF2 = zzF(obj, j);
                        iNumberOfLeadingZeros23 = Integer.numberOfLeadingZeros(i10 << 3) * 9;
                        iNumberOfLeadingZeros24 = Integer.numberOfLeadingZeros(iZzF2);
                        iZzp = (352 - iNumberOfLeadingZeros23) >>> 6;
                        i5 = 352 - (iNumberOfLeadingZeros24 * 9);
                        i4 = i5 >>> 6;
                        iZzx2 = iZzp + i4;
                        iNumberOfLeadingZeros25 += iZzx2;
                    }
                    break;
                case 63:
                    if (zzakvVar.zzL(obj, i10, i6)) {
                        int iZzF3 = zzF(obj, j);
                        iNumberOfLeadingZeros21 = Integer.numberOfLeadingZeros(i10 << 3) * 9;
                        iNumberOfLeadingZeros22 = Long.numberOfLeadingZeros(iZzF3);
                        iZzp = (352 - iNumberOfLeadingZeros21) >>> 6;
                        i5 = 640 - (iNumberOfLeadingZeros22 * 9);
                        i4 = i5 >>> 6;
                        iZzx2 = iZzp + i4;
                        iNumberOfLeadingZeros25 += iZzx2;
                    }
                    break;
                case 64:
                    if (zzakvVar.zzL(obj, i10, i6)) {
                        iNumberOfLeadingZeros20 = Integer.numberOfLeadingZeros(i10 << 3);
                        iZzx2 = ((352 - (iNumberOfLeadingZeros20 * 9)) >>> 6) + 4;
                        iNumberOfLeadingZeros25 += iZzx2;
                    }
                    break;
                case 65:
                    if (zzakvVar.zzL(obj, i10, i6)) {
                        iNumberOfLeadingZeros19 = Integer.numberOfLeadingZeros(i10 << 3);
                        iZzx2 = ((352 - (iNumberOfLeadingZeros19 * 9)) >>> 6) + 8;
                        iNumberOfLeadingZeros25 += iZzx2;
                    }
                    break;
                case 66:
                    if (zzakvVar.zzL(obj, i10, i6)) {
                        int iZzF4 = zzF(obj, j);
                        iNumberOfLeadingZeros23 = Integer.numberOfLeadingZeros(i10 << 3) * 9;
                        iNumberOfLeadingZeros24 = Integer.numberOfLeadingZeros((iZzF4 >> 31) ^ (iZzF4 + iZzF4));
                        iZzp = (352 - iNumberOfLeadingZeros23) >>> 6;
                        i5 = 352 - (iNumberOfLeadingZeros24 * 9);
                        i4 = i5 >>> 6;
                        iZzx2 = iZzp + i4;
                        iNumberOfLeadingZeros25 += iZzx2;
                    }
                    break;
                case 67:
                    if (zzakvVar.zzL(obj, i10, i6)) {
                        long jZzG3 = zzG(obj, j);
                        iNumberOfLeadingZeros21 = Integer.numberOfLeadingZeros(i10 << 3) * 9;
                        iNumberOfLeadingZeros22 = Long.numberOfLeadingZeros((jZzG3 >> 63) ^ (jZzG3 + jZzG3));
                        iZzp = (352 - iNumberOfLeadingZeros21) >>> 6;
                        i5 = 640 - (iNumberOfLeadingZeros22 * 9);
                        i4 = i5 >>> 6;
                        iZzx2 = iZzp + i4;
                        iNumberOfLeadingZeros25 += iZzx2;
                    }
                    break;
                case 68:
                    if (zzakvVar.zzL(obj, i10, i6)) {
                        iZzx2 = zzale.zzx(i10, (zzaks) unsafe.getObject(obj, j), zzakvVar.zzq(i6));
                        iNumberOfLeadingZeros25 += iZzx2;
                    }
                    break;
            }
            i6 += 3;
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0023  */
    @Override // com.google.android.gms.internal.nearby.zzald
    public final void zzf(Object obj, zzaiv zzaivVar) throws IOException {
        Map.Entry entry;
        int i;
        zzakv<T> zzakvVar = this;
        if (zzakvVar.zzh) {
            zzaje zzajeVar = ((zzajl) obj).zzb;
            if (zzajeVar.zza.isEmpty()) {
                entry = null;
            } else {
                entry = (Map.Entry) zzajeVar.zzc().next();
            }
        } else {
            entry = null;
        }
        int[] iArr = zzakvVar.zzc;
        Unsafe unsafe = zzb;
        int i2 = 1048575;
        int i3 = 1048575;
        int i4 = 0;
        int i5 = 0;
        while (i4 < iArr.length) {
            int iZzA = zzakvVar.zzA(i4);
            int i6 = iArr[i4];
            int i7 = (iZzA >>> 20) & 255;
            if (i7 <= 17) {
                int i8 = iArr[i4 + 2];
                int i9 = i8 & i2;
                if (i9 != i3) {
                    i5 = i9 == i2 ? 0 : unsafe.getInt(obj, i9);
                    i3 = i9;
                }
                i = 1 << (i8 >>> 20);
            } else {
                i = 0;
            }
            if (entry != null) {
                throw null;
            }
            long j = iZzA & i2;
            switch (i7) {
                case 0:
                    if (zzakvVar.zzI(obj, i4, i3, i5, i)) {
                        zzaivVar.zzf(i6, zzalt.zzj(obj, j));
                        continue;
                    }
                    i4 += 3;
                    i2 = 1048575;
                    zzakvVar = this;
                    break;
                case 1:
                    if (zzakvVar.zzI(obj, i4, i3, i5, i)) {
                        zzaivVar.zze(i6, zzalt.zzh(obj, j));
                    } else {
                        continue;
                    }
                    i4 += 3;
                    i2 = 1048575;
                    zzakvVar = this;
                    break;
                case 2:
                    if (zzakvVar.zzI(obj, i4, i3, i5, i)) {
                        zzaivVar.zzc(i6, unsafe.getLong(obj, j));
                    } else {
                        continue;
                    }
                    i4 += 3;
                    i2 = 1048575;
                    zzakvVar = this;
                    break;
                case 3:
                    if (zzakvVar.zzI(obj, i4, i3, i5, i)) {
                        zzaivVar.zzh(i6, unsafe.getLong(obj, j));
                    } else {
                        continue;
                    }
                    i4 += 3;
                    i2 = 1048575;
                    zzakvVar = this;
                    break;
                case 4:
                    if (zzakvVar.zzI(obj, i4, i3, i5, i)) {
                        zzaivVar.zzi(i6, unsafe.getInt(obj, j));
                    } else {
                        continue;
                    }
                    i4 += 3;
                    i2 = 1048575;
                    zzakvVar = this;
                    break;
                case 5:
                    if (zzakvVar.zzI(obj, i4, i3, i5, i)) {
                        zzaivVar.zzj(i6, unsafe.getLong(obj, j));
                    } else {
                        continue;
                    }
                    i4 += 3;
                    i2 = 1048575;
                    zzakvVar = this;
                    break;
                case 6:
                    if (zzakvVar.zzI(obj, i4, i3, i5, i)) {
                        zzaivVar.zzk(i6, unsafe.getInt(obj, j));
                    } else {
                        continue;
                    }
                    i4 += 3;
                    i2 = 1048575;
                    zzakvVar = this;
                    break;
                case 7:
                    if (zzakvVar.zzI(obj, i4, i3, i5, i)) {
                        zzaivVar.zzl(i6, zzalt.zzf(obj, j));
                    } else {
                        continue;
                    }
                    i4 += 3;
                    i2 = 1048575;
                    zzakvVar = this;
                    break;
                case 8:
                    if (zzakvVar.zzI(obj, i4, i3, i5, i)) {
                        zzS(i6, unsafe.getObject(obj, j), zzaivVar);
                    } else {
                        continue;
                    }
                    i4 += 3;
                    i2 = 1048575;
                    zzakvVar = this;
                    break;
                case 9:
                    if (zzakvVar.zzI(obj, i4, i3, i5, i)) {
                        zzaivVar.zzr(i6, unsafe.getObject(obj, j), zzakvVar.zzq(i4));
                    } else {
                        continue;
                    }
                    i4 += 3;
                    i2 = 1048575;
                    zzakvVar = this;
                    break;
                case 10:
                    if (zzakvVar.zzI(obj, i4, i3, i5, i)) {
                        zzaivVar.zzn(i6, (zzaik) unsafe.getObject(obj, j));
                    } else {
                        continue;
                    }
                    i4 += 3;
                    i2 = 1048575;
                    zzakvVar = this;
                    break;
                case 11:
                    if (zzakvVar.zzI(obj, i4, i3, i5, i)) {
                        zzaivVar.zzo(i6, unsafe.getInt(obj, j));
                    } else {
                        continue;
                    }
                    i4 += 3;
                    i2 = 1048575;
                    zzakvVar = this;
                    break;
                case 12:
                    if (zzakvVar.zzI(obj, i4, i3, i5, i)) {
                        zzaivVar.zzg(i6, unsafe.getInt(obj, j));
                    } else {
                        continue;
                    }
                    i4 += 3;
                    i2 = 1048575;
                    zzakvVar = this;
                    break;
                case 13:
                    if (zzakvVar.zzI(obj, i4, i3, i5, i)) {
                        zzaivVar.zzb(i6, unsafe.getInt(obj, j));
                    } else {
                        continue;
                    }
                    i4 += 3;
                    i2 = 1048575;
                    zzakvVar = this;
                    break;
                case 14:
                    if (zzakvVar.zzI(obj, i4, i3, i5, i)) {
                        zzaivVar.zzd(i6, unsafe.getLong(obj, j));
                    } else {
                        continue;
                    }
                    i4 += 3;
                    i2 = 1048575;
                    zzakvVar = this;
                    break;
                case 15:
                    if (zzakvVar.zzI(obj, i4, i3, i5, i)) {
                        zzaivVar.zzp(i6, unsafe.getInt(obj, j));
                    } else {
                        continue;
                    }
                    i4 += 3;
                    i2 = 1048575;
                    zzakvVar = this;
                    break;
                case 16:
                    if (zzakvVar.zzI(obj, i4, i3, i5, i)) {
                        zzaivVar.zzq(i6, unsafe.getLong(obj, j));
                    } else {
                        continue;
                    }
                    i4 += 3;
                    i2 = 1048575;
                    zzakvVar = this;
                    break;
                case 17:
                    if (zzakvVar.zzI(obj, i4, i3, i5, i)) {
                        zzaivVar.zzs(i6, unsafe.getObject(obj, j), zzakvVar.zzq(i4));
                    } else {
                        continue;
                    }
                    i4 += 3;
                    i2 = 1048575;
                    zzakvVar = this;
                    break;
                case 18:
                    zzale.zza(iArr[i4], (List) unsafe.getObject(obj, j), zzaivVar, false);
                    continue;
                    i4 += 3;
                    i2 = 1048575;
                    zzakvVar = this;
                    break;
                case 19:
                    zzale.zzb(iArr[i4], (List) unsafe.getObject(obj, j), zzaivVar, false);
                    continue;
                    i4 += 3;
                    i2 = 1048575;
                    zzakvVar = this;
                    break;
                case 20:
                    zzale.zzc(iArr[i4], (List) unsafe.getObject(obj, j), zzaivVar, false);
                    continue;
                    i4 += 3;
                    i2 = 1048575;
                    zzakvVar = this;
                    break;
                case 21:
                    zzale.zzd(iArr[i4], (List) unsafe.getObject(obj, j), zzaivVar, false);
                    continue;
                    i4 += 3;
                    i2 = 1048575;
                    zzakvVar = this;
                    break;
                case 22:
                    zzale.zzh(iArr[i4], (List) unsafe.getObject(obj, j), zzaivVar, false);
                    continue;
                    i4 += 3;
                    i2 = 1048575;
                    zzakvVar = this;
                    break;
                case 23:
                    zzale.zzf(iArr[i4], (List) unsafe.getObject(obj, j), zzaivVar, false);
                    continue;
                    i4 += 3;
                    i2 = 1048575;
                    zzakvVar = this;
                    break;
                case 24:
                    zzale.zzk(iArr[i4], (List) unsafe.getObject(obj, j), zzaivVar, false);
                    continue;
                    i4 += 3;
                    i2 = 1048575;
                    zzakvVar = this;
                    break;
                case 25:
                    zzale.zzn(iArr[i4], (List) unsafe.getObject(obj, j), zzaivVar, false);
                    continue;
                    i4 += 3;
                    i2 = 1048575;
                    zzakvVar = this;
                    break;
                case 26:
                    int i10 = iArr[i4];
                    List list = (List) unsafe.getObject(obj, j);
                    int i11 = zzale.zza;
                    if (list != null && !list.isEmpty()) {
                        zzaivVar.zzF(i10, list);
                    }
                    break;
                case 27:
                    int i12 = iArr[i4];
                    List list2 = (List) unsafe.getObject(obj, j);
                    zzald zzaldVarZzq = zzakvVar.zzq(i4);
                    int i13 = zzale.zza;
                    if (list2 != null && !list2.isEmpty()) {
                        for (int i14 = 0; i14 < list2.size(); i14++) {
                            zzaivVar.zzr(i12, list2.get(i14), zzaldVarZzq);
                        }
                    }
                    break;
                case 28:
                    int i15 = iArr[i4];
                    List list3 = (List) unsafe.getObject(obj, j);
                    int i16 = zzale.zza;
                    if (list3 != null && !list3.isEmpty()) {
                        zzaivVar.zzG(i15, list3);
                    }
                    break;
                case 29:
                    zzale.zzi(iArr[i4], (List) unsafe.getObject(obj, j), zzaivVar, false);
                    continue;
                    i4 += 3;
                    i2 = 1048575;
                    zzakvVar = this;
                    break;
                case 30:
                    zzale.zzm(iArr[i4], (List) unsafe.getObject(obj, j), zzaivVar, false);
                    continue;
                    i4 += 3;
                    i2 = 1048575;
                    zzakvVar = this;
                    break;
                case 31:
                    zzale.zzl(iArr[i4], (List) unsafe.getObject(obj, j), zzaivVar, false);
                    continue;
                    i4 += 3;
                    i2 = 1048575;
                    zzakvVar = this;
                    break;
                case 32:
                    zzale.zzg(iArr[i4], (List) unsafe.getObject(obj, j), zzaivVar, false);
                    continue;
                    i4 += 3;
                    i2 = 1048575;
                    zzakvVar = this;
                    break;
                case 33:
                    zzale.zzj(iArr[i4], (List) unsafe.getObject(obj, j), zzaivVar, false);
                    continue;
                    i4 += 3;
                    i2 = 1048575;
                    zzakvVar = this;
                    break;
                case 34:
                    zzale.zze(iArr[i4], (List) unsafe.getObject(obj, j), zzaivVar, false);
                    continue;
                    i4 += 3;
                    i2 = 1048575;
                    zzakvVar = this;
                    break;
                case 35:
                    zzale.zza(iArr[i4], (List) unsafe.getObject(obj, j), zzaivVar, true);
                    break;
                case 36:
                    zzale.zzb(iArr[i4], (List) unsafe.getObject(obj, j), zzaivVar, true);
                    break;
                case 37:
                    zzale.zzc(iArr[i4], (List) unsafe.getObject(obj, j), zzaivVar, true);
                    break;
                case MotionEventCompat.AXIS_GENERIC_7 /* 38 */:
                    zzale.zzd(iArr[i4], (List) unsafe.getObject(obj, j), zzaivVar, true);
                    break;
                case 39:
                    zzale.zzh(iArr[i4], (List) unsafe.getObject(obj, j), zzaivVar, true);
                    break;
                case 40:
                    zzale.zzf(iArr[i4], (List) unsafe.getObject(obj, j), zzaivVar, true);
                    break;
                case 41:
                    zzale.zzk(iArr[i4], (List) unsafe.getObject(obj, j), zzaivVar, true);
                    break;
                case MotionEventCompat.AXIS_GENERIC_11 /* 42 */:
                    zzale.zzn(iArr[i4], (List) unsafe.getObject(obj, j), zzaivVar, true);
                    break;
                case MotionEventCompat.AXIS_GENERIC_12 /* 43 */:
                    zzale.zzi(iArr[i4], (List) unsafe.getObject(obj, j), zzaivVar, true);
                    break;
                case 44:
                    zzale.zzm(iArr[i4], (List) unsafe.getObject(obj, j), zzaivVar, true);
                    break;
                case 45:
                    zzale.zzl(iArr[i4], (List) unsafe.getObject(obj, j), zzaivVar, true);
                    break;
                case MotionEventCompat.AXIS_GENERIC_15 /* 46 */:
                    zzale.zzg(iArr[i4], (List) unsafe.getObject(obj, j), zzaivVar, true);
                    break;
                case MotionEventCompat.AXIS_GENERIC_16 /* 47 */:
                    zzale.zzj(iArr[i4], (List) unsafe.getObject(obj, j), zzaivVar, true);
                    break;
                case 48:
                    zzale.zze(iArr[i4], (List) unsafe.getObject(obj, j), zzaivVar, true);
                    break;
                case 49:
                    int i17 = iArr[i4];
                    List list4 = (List) unsafe.getObject(obj, j);
                    zzald zzaldVarZzq2 = zzakvVar.zzq(i4);
                    int i18 = zzale.zza;
                    if (list4 != null && !list4.isEmpty()) {
                        for (int i19 = 0; i19 < list4.size(); i19++) {
                            zzaivVar.zzs(i17, list4.get(i19), zzaldVarZzq2);
                        }
                    }
                    break;
                case 50:
                    Object object = unsafe.getObject(obj, j);
                    if (object != null) {
                        zzaivVar.zzM(i6, ((zzakm) zzakvVar.zzr(i4)).zze(), (zzakn) object);
                    }
                    break;
                case StylePropertiesKt.BackgroundBrushId /* 51 */:
                    if (zzakvVar.zzL(obj, i6, i4)) {
                        zzaivVar.zzf(i6, ((Double) zzalt.zzl(obj, j)).doubleValue());
                    }
                    break;
                case StylePropertiesKt.ForegroundBrushId /* 52 */:
                    if (zzakvVar.zzL(obj, i6, i4)) {
                        zzaivVar.zze(i6, ((Float) zzalt.zzl(obj, j)).floatValue());
                    }
                    break;
                case StylePropertiesKt.ShapeId /* 53 */:
                    if (zzakvVar.zzL(obj, i6, i4)) {
                        zzaivVar.zzc(i6, zzG(obj, j));
                    }
                    break;
                case StylePropertiesKt.ColorFilterId /* 54 */:
                    if (zzakvVar.zzL(obj, i6, i4)) {
                        zzaivVar.zzh(i6, zzG(obj, j));
                    }
                    break;
                case StylePropertiesKt.DropShadowId /* 55 */:
                    if (zzakvVar.zzL(obj, i6, i4)) {
                        zzaivVar.zzi(i6, zzF(obj, j));
                    }
                    break;
                case StylePropertiesKt.InnerShadowId /* 56 */:
                    if (zzakvVar.zzL(obj, i6, i4)) {
                        zzaivVar.zzj(i6, zzG(obj, j));
                    }
                    break;
                case StylePropertiesKt.ContentBrushId /* 57 */:
                    if (zzakvVar.zzL(obj, i6, i4)) {
                        zzaivVar.zzk(i6, zzF(obj, j));
                    }
                    break;
                case StylePropertiesKt.FontFamilyId /* 58 */:
                    if (zzakvVar.zzL(obj, i6, i4)) {
                        zzaivVar.zzl(i6, ((Boolean) zzalt.zzl(obj, j)).booleanValue());
                    }
                    break;
                case StylePropertiesKt.TextMotionId /* 59 */:
                    if (zzakvVar.zzL(obj, i6, i4)) {
                        zzS(i6, unsafe.getObject(obj, j), zzaivVar);
                    }
                    break;
                case 60:
                    if (zzakvVar.zzL(obj, i6, i4)) {
                        zzaivVar.zzr(i6, unsafe.getObject(obj, j), zzakvVar.zzq(i4));
                    }
                    break;
                case 61:
                    if (zzakvVar.zzL(obj, i6, i4)) {
                        zzaivVar.zzn(i6, (zzaik) unsafe.getObject(obj, j));
                    }
                    break;
                case RectListKt.BitOffsetForGesturable /* 62 */:
                    if (zzakvVar.zzL(obj, i6, i4)) {
                        zzaivVar.zzo(i6, zzF(obj, j));
                    }
                    break;
                case 63:
                    if (zzakvVar.zzL(obj, i6, i4)) {
                        zzaivVar.zzg(i6, zzF(obj, j));
                    }
                    break;
                case 64:
                    if (zzakvVar.zzL(obj, i6, i4)) {
                        zzaivVar.zzb(i6, zzF(obj, j));
                    }
                    break;
                case 65:
                    if (zzakvVar.zzL(obj, i6, i4)) {
                        zzaivVar.zzd(i6, zzG(obj, j));
                    }
                    break;
                case 66:
                    if (zzakvVar.zzL(obj, i6, i4)) {
                        zzaivVar.zzp(i6, zzF(obj, j));
                    }
                    break;
                case 67:
                    if (zzakvVar.zzL(obj, i6, i4)) {
                        zzaivVar.zzq(i6, zzG(obj, j));
                    }
                    break;
                case 68:
                    if (zzakvVar.zzL(obj, i6, i4)) {
                        zzaivVar.zzs(i6, unsafe.getObject(obj, j), zzakvVar.zzq(i4));
                    }
                    break;
            }
            i4 += 3;
            i2 = 1048575;
            zzakvVar = this;
        }
        if (entry != null) {
            throw null;
        }
        ((zzajo) obj).zzc.zzg(zzaivVar);
    }

    /* JADX WARN: Code duplicated, block: B:178:0x0530 A[LOOP:1: B:176:0x052c->B:178:0x0530, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:180:0x0540  */
    /* JADX WARN: Code duplicated, block: B:182:0x0548  */
    /* JADX WARN: Code duplicated, block: B:192:0x055b A[LOOP:2: B:190:0x0557->B:192:0x055b, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:194:0x056b  */
    /* JADX WARN: Code duplicated, block: B:201:0x051e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:294:0x0529 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:303:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:304:? A[SYNTHETIC] */
    @Override // com.google.android.gms.internal.nearby.zzald
    public final void zzg(Object obj, zzaip zzaipVar, zzaiz zzaizVar) throws Throwable {
        zzakv<T> zzakvVar;
        Object obj2;
        Throwable th;
        int i;
        Object objZzx;
        Object objZzx2;
        Object obj3;
        int i2;
        zzaizVar.getClass();
        zzE(obj);
        zzalm zzalmVar = this.zzm;
        Object objZzj = null;
        while (true) {
            try {
                int iZzb = zzaipVar.zzb();
                int iZzO = this.zzO(iZzb);
                if (iZzO >= 0) {
                    obj3 = obj;
                    try {
                        int iZzA = this.zzA(iZzO);
                        switch ((iZzA >>> 20) & 255) {
                            case 0:
                                obj2 = obj3;
                                zzalt.zzk(obj2, iZzA & 1048575, zzaipVar.zze());
                                this.zzK(obj2, iZzO);
                                obj = obj2;
                                break;
                            case 1:
                                obj2 = obj3;
                                zzalt.zzi(obj2, iZzA & 1048575, zzaipVar.zzf());
                                this.zzK(obj2, iZzO);
                                obj = obj2;
                                break;
                            case 2:
                                obj2 = obj3;
                                zzalt.zze(obj2, iZzA & 1048575, zzaipVar.zzh());
                                this.zzK(obj2, iZzO);
                                obj = obj2;
                                break;
                            case 3:
                                obj2 = obj3;
                                zzalt.zze(obj2, iZzA & 1048575, zzaipVar.zzg());
                                this.zzK(obj2, iZzO);
                                obj = obj2;
                                break;
                            case 4:
                                obj2 = obj3;
                                zzalt.zzc(obj2, iZzA & 1048575, zzaipVar.zzi());
                                this.zzK(obj2, iZzO);
                                obj = obj2;
                                break;
                            case 5:
                                obj2 = obj3;
                                zzalt.zze(obj2, iZzA & 1048575, zzaipVar.zzj());
                                this.zzK(obj2, iZzO);
                                obj = obj2;
                                break;
                            case 6:
                                obj2 = obj3;
                                zzalt.zzc(obj2, iZzA & 1048575, zzaipVar.zzk());
                                this.zzK(obj2, iZzO);
                                obj = obj2;
                                break;
                            case 7:
                                obj2 = obj3;
                                zzalt.zzg(obj2, iZzA & 1048575, zzaipVar.zzl());
                                this.zzK(obj2, iZzO);
                                obj = obj2;
                                break;
                            case 8:
                                obj2 = obj3;
                                this.zzz(obj2, iZzA, zzaipVar);
                                this.zzK(obj2, iZzO);
                                obj = obj2;
                                break;
                            case 9:
                                obj2 = obj3;
                                zzaks zzaksVar = (zzaks) this.zzt(obj2, iZzO);
                                zzaipVar.zzo(zzaksVar, this.zzq(iZzO), zzaizVar);
                                this.zzu(obj2, iZzO, zzaksVar);
                                obj = obj2;
                                break;
                            case 10:
                                obj2 = obj3;
                                zzalt.zzm(obj2, iZzA & 1048575, zzaipVar.zzq());
                                this.zzK(obj2, iZzO);
                                obj = obj2;
                                break;
                            case 11:
                                obj2 = obj3;
                                zzalt.zzc(obj2, iZzA & 1048575, zzaipVar.zzr());
                                this.zzK(obj2, iZzO);
                                obj = obj2;
                                break;
                            case 12:
                                obj2 = obj3;
                                int iZzs = zzaipVar.zzs();
                                zzajt zzajtVarZzs = this.zzs(iZzO);
                                if (zzajtVarZzs == null || zzajtVarZzs.zza(iZzs)) {
                                    zzalt.zzc(obj2, iZzA & 1048575, iZzs);
                                    this.zzK(obj2, iZzO);
                                } else {
                                    objZzj = zzale.zzD(obj2, iZzb, iZzs, objZzj, zzalmVar);
                                }
                                obj = obj2;
                                break;
                            case 13:
                                obj2 = obj3;
                                zzalt.zzc(obj2, iZzA & 1048575, zzaipVar.zzt());
                                this.zzK(obj2, iZzO);
                                obj = obj2;
                                break;
                            case 14:
                                obj2 = obj3;
                                zzalt.zze(obj2, iZzA & 1048575, zzaipVar.zzu());
                                this.zzK(obj2, iZzO);
                                obj = obj2;
                                break;
                            case 15:
                                obj2 = obj3;
                                zzalt.zzc(obj2, iZzA & 1048575, zzaipVar.zzv());
                                this.zzK(obj2, iZzO);
                                obj = obj2;
                                break;
                            case 16:
                                obj2 = obj3;
                                zzalt.zze(obj2, iZzA & 1048575, zzaipVar.zzw());
                                this.zzK(obj2, iZzO);
                                obj = obj2;
                                break;
                            case 17:
                                obj2 = obj3;
                                zzaks zzaksVar2 = (zzaks) this.zzt(obj2, iZzO);
                                zzaipVar.zzp(zzaksVar2, this.zzq(iZzO), zzaizVar);
                                this.zzu(obj2, iZzO, zzaksVar2);
                                obj = obj2;
                                break;
                            case 18:
                                obj2 = obj3;
                                zzaipVar.zzx(zzaki.zza(obj2, iZzA & 1048575));
                                obj = obj2;
                                break;
                            case 19:
                                obj2 = obj3;
                                zzaipVar.zzy(zzaki.zza(obj2, iZzA & 1048575));
                                obj = obj2;
                                break;
                            case 20:
                                obj2 = obj3;
                                zzaipVar.zzA(zzaki.zza(obj2, iZzA & 1048575));
                                obj = obj2;
                                break;
                            case 21:
                                obj2 = obj3;
                                zzaipVar.zzz(zzaki.zza(obj2, iZzA & 1048575));
                                obj = obj2;
                                break;
                            case 22:
                                obj2 = obj3;
                                zzaipVar.zzB(zzaki.zza(obj2, iZzA & 1048575));
                                obj = obj2;
                                break;
                            case 23:
                                obj2 = obj3;
                                zzaipVar.zzC(zzaki.zza(obj2, iZzA & 1048575));
                                obj = obj2;
                                break;
                            case 24:
                                obj2 = obj3;
                                zzaipVar.zzD(zzaki.zza(obj2, iZzA & 1048575));
                                obj = obj2;
                                break;
                            case 25:
                                obj2 = obj3;
                                zzaipVar.zzE(zzaki.zza(obj2, iZzA & 1048575));
                                obj = obj2;
                                break;
                            case 26:
                                obj2 = obj3;
                                if (zzC(iZzA)) {
                                    zzaipVar.zzF(zzaki.zza(obj2, iZzA & 1048575), true);
                                } else {
                                    zzaipVar.zzF(zzaki.zza(obj2, iZzA & 1048575), false);
                                }
                                obj = obj2;
                                break;
                            case 27:
                                obj2 = obj3;
                                zzaipVar.zzG(zzaki.zza(obj2, iZzA & 1048575), this.zzq(iZzO), zzaizVar);
                                obj = obj2;
                                break;
                            case 28:
                                obj2 = obj3;
                                zzaipVar.zzI(zzaki.zza(obj2, iZzA & 1048575));
                                obj = obj2;
                                break;
                            case 29:
                                obj2 = obj3;
                                zzaipVar.zzJ(zzaki.zza(obj2, iZzA & 1048575));
                                obj = obj2;
                                break;
                            case 30:
                                List listZza = zzaki.zza(obj3, iZzA & 1048575);
                                zzaipVar.zzK(listZza);
                                objZzj = zzale.zzC(obj3, iZzb, listZza, this.zzs(iZzO), objZzj, zzalmVar);
                                obj2 = obj3;
                                obj = obj2;
                                break;
                            case 31:
                                obj2 = obj3;
                                zzaipVar.zzL(zzaki.zza(obj2, iZzA & 1048575));
                                obj = obj2;
                                break;
                            case 32:
                                obj2 = obj3;
                                zzaipVar.zzM(zzaki.zza(obj2, iZzA & 1048575));
                                obj = obj2;
                                break;
                            case 33:
                                obj2 = obj3;
                                zzaipVar.zzN(zzaki.zza(obj2, iZzA & 1048575));
                                obj = obj2;
                                break;
                            case 34:
                                obj2 = obj3;
                                zzaipVar.zzO(zzaki.zza(obj2, iZzA & 1048575));
                                obj = obj2;
                                break;
                            case 35:
                                obj2 = obj3;
                                zzaipVar.zzx(zzaki.zza(obj2, iZzA & 1048575));
                                obj = obj2;
                                break;
                            case 36:
                                obj2 = obj3;
                                zzaipVar.zzy(zzaki.zza(obj2, iZzA & 1048575));
                                obj = obj2;
                                break;
                            case 37:
                                obj2 = obj3;
                                zzaipVar.zzA(zzaki.zza(obj2, iZzA & 1048575));
                                obj = obj2;
                                break;
                            case MotionEventCompat.AXIS_GENERIC_7 /* 38 */:
                                obj2 = obj3;
                                zzaipVar.zzz(zzaki.zza(obj2, iZzA & 1048575));
                                obj = obj2;
                                break;
                            case 39:
                                obj2 = obj3;
                                zzaipVar.zzB(zzaki.zza(obj2, iZzA & 1048575));
                                obj = obj2;
                                break;
                            case 40:
                                obj2 = obj3;
                                zzaipVar.zzC(zzaki.zza(obj2, iZzA & 1048575));
                                obj = obj2;
                                break;
                            case 41:
                                obj2 = obj3;
                                zzaipVar.zzD(zzaki.zza(obj2, iZzA & 1048575));
                                obj = obj2;
                                break;
                            case MotionEventCompat.AXIS_GENERIC_11 /* 42 */:
                                obj2 = obj3;
                                zzaipVar.zzE(zzaki.zza(obj2, iZzA & 1048575));
                                obj = obj2;
                                break;
                            case MotionEventCompat.AXIS_GENERIC_12 /* 43 */:
                                obj2 = obj3;
                                zzaipVar.zzJ(zzaki.zza(obj2, iZzA & 1048575));
                                obj = obj2;
                                break;
                            case 44:
                                try {
                                    List listZza2 = zzaki.zza(obj3, iZzA & 1048575);
                                    zzaipVar.zzK(listZza2);
                                    try {
                                        objZzj = zzale.zzC(obj3, iZzb, listZza2, this.zzs(iZzO), objZzj, zzalmVar);
                                        obj2 = obj3;
                                    } catch (zzake unused) {
                                        obj2 = obj3;
                                        zzakvVar = this;
                                        if (objZzj == null) {
                                            try {
                                                objZzj = zzalo.zzj(obj2);
                                            } catch (Throwable th2) {
                                                th = th2;
                                                th = th;
                                                i = zzakvVar.zzk;
                                                objZzx = objZzj;
                                                while (i < zzakvVar.zzl) {
                                                    zzalm zzalmVar2 = zzalmVar;
                                                    objZzx = zzakvVar.zzx(obj2, zzakvVar.zzj[i], objZzx, zzalmVar2, obj2);
                                                    i++;
                                                    zzalmVar = zzalmVar2;
                                                }
                                                if (objZzx == null) {
                                                    throw th;
                                                }
                                                ((zzajo) obj2).zzc = (zzaln) objZzx;
                                                throw th;
                                            }
                                        }
                                        if (!zzalmVar.zzh(objZzj, zzaipVar, 0)) {
                                            objZzx2 = objZzj;
                                            for (i2 = zzakvVar.zzk; i2 < zzakvVar.zzl; i2++) {
                                                zzalm zzalmVar3 = zzalmVar;
                                                objZzx2 = zzakvVar.zzx(obj2, zzakvVar.zzj[i2], objZzx2, zzalmVar3, obj2);
                                                zzalmVar = zzalmVar3;
                                            }
                                            if (objZzx2 != null) {
                                                ((zzajo) obj2).zzc = (zzaln) objZzx2;
                                            }
                                        }
                                        this = zzakvVar;
                                    } catch (Throwable th3) {
                                        th = th3;
                                        obj2 = obj3;
                                        th = th;
                                        zzakvVar = this;
                                        i = zzakvVar.zzk;
                                        objZzx = objZzj;
                                        while (i < zzakvVar.zzl) {
                                            zzalm zzalmVar4 = zzalmVar;
                                            objZzx = zzakvVar.zzx(obj2, zzakvVar.zzj[i], objZzx, zzalmVar4, obj2);
                                            i++;
                                            zzalmVar = zzalmVar4;
                                        }
                                        if (objZzx == null) {
                                            throw th;
                                        }
                                        ((zzajo) obj2).zzc = (zzaln) objZzx;
                                        throw th;
                                    }
                                    obj = obj2;
                                } catch (Throwable th4) {
                                    th = th4;
                                    obj2 = obj3;
                                }
                                break;
                            case 45:
                                zzaipVar.zzL(zzaki.zza(obj3, iZzA & 1048575));
                                obj2 = obj3;
                                obj = obj2;
                                break;
                            case MotionEventCompat.AXIS_GENERIC_15 /* 46 */:
                                zzaipVar.zzM(zzaki.zza(obj3, iZzA & 1048575));
                                obj2 = obj3;
                                obj = obj2;
                                break;
                            case MotionEventCompat.AXIS_GENERIC_16 /* 47 */:
                                zzaipVar.zzN(zzaki.zza(obj3, iZzA & 1048575));
                                obj2 = obj3;
                                obj = obj2;
                                break;
                            case 48:
                                zzaipVar.zzO(zzaki.zza(obj3, iZzA & 1048575));
                                obj2 = obj3;
                                obj = obj2;
                                break;
                            case 49:
                                zzaipVar.zzH(zzaki.zza(obj3, iZzA & 1048575), this.zzq(iZzO), zzaizVar);
                                obj2 = obj3;
                                obj = obj2;
                                break;
                            case 50:
                                Object objZzr = this.zzr(iZzO);
                                long jZzA = this.zzA(iZzO) & 1048575;
                                Object objZzl = zzalt.zzl(obj3, jZzA);
                                if (objZzl == null) {
                                    objZzl = zzakn.zza().zzc();
                                    zzalt.zzm(obj3, jZzA, objZzl);
                                } else if (zzako.zza(objZzl)) {
                                    Object objZzc = zzakn.zza().zzc();
                                    zzako.zzb(objZzc, objZzl);
                                    zzalt.zzm(obj3, jZzA, objZzc);
                                    objZzl = objZzc;
                                }
                                zzaipVar.zzP((zzakn) objZzl, ((zzakm) objZzr).zze(), zzaizVar);
                                obj2 = obj3;
                                obj = obj2;
                                break;
                            case StylePropertiesKt.BackgroundBrushId /* 51 */:
                                zzalt.zzm(obj3, iZzA & 1048575, Double.valueOf(zzaipVar.zze()));
                                this.zzN(obj3, iZzb, iZzO);
                                obj2 = obj3;
                                obj = obj2;
                                break;
                            case StylePropertiesKt.ForegroundBrushId /* 52 */:
                                zzalt.zzm(obj3, iZzA & 1048575, Float.valueOf(zzaipVar.zzf()));
                                this.zzN(obj3, iZzb, iZzO);
                                obj2 = obj3;
                                obj = obj2;
                                break;
                            case StylePropertiesKt.ShapeId /* 53 */:
                                zzalt.zzm(obj3, iZzA & 1048575, Long.valueOf(zzaipVar.zzh()));
                                this.zzN(obj3, iZzb, iZzO);
                                obj2 = obj3;
                                obj = obj2;
                                break;
                            case StylePropertiesKt.ColorFilterId /* 54 */:
                                zzalt.zzm(obj3, iZzA & 1048575, Long.valueOf(zzaipVar.zzg()));
                                this.zzN(obj3, iZzb, iZzO);
                                obj2 = obj3;
                                obj = obj2;
                                break;
                            case StylePropertiesKt.DropShadowId /* 55 */:
                                zzalt.zzm(obj3, iZzA & 1048575, Integer.valueOf(zzaipVar.zzi()));
                                this.zzN(obj3, iZzb, iZzO);
                                obj2 = obj3;
                                obj = obj2;
                                break;
                            case StylePropertiesKt.InnerShadowId /* 56 */:
                                zzalt.zzm(obj3, iZzA & 1048575, Long.valueOf(zzaipVar.zzj()));
                                this.zzN(obj3, iZzb, iZzO);
                                obj2 = obj3;
                                obj = obj2;
                                break;
                            case StylePropertiesKt.ContentBrushId /* 57 */:
                                zzalt.zzm(obj3, iZzA & 1048575, Integer.valueOf(zzaipVar.zzk()));
                                this.zzN(obj3, iZzb, iZzO);
                                obj2 = obj3;
                                obj = obj2;
                                break;
                            case StylePropertiesKt.FontFamilyId /* 58 */:
                                zzalt.zzm(obj3, iZzA & 1048575, Boolean.valueOf(zzaipVar.zzl()));
                                this.zzN(obj3, iZzb, iZzO);
                                obj2 = obj3;
                                obj = obj2;
                                break;
                            case StylePropertiesKt.TextMotionId /* 59 */:
                                this.zzz(obj3, iZzA, zzaipVar);
                                this.zzN(obj3, iZzb, iZzO);
                                obj2 = obj3;
                                obj = obj2;
                                break;
                            case 60:
                                zzaks zzaksVar3 = (zzaks) this.zzv(obj3, iZzb, iZzO);
                                zzaipVar.zzo(zzaksVar3, this.zzq(iZzO), zzaizVar);
                                this.zzw(obj3, iZzb, iZzO, zzaksVar3);
                                obj2 = obj3;
                                obj = obj2;
                                break;
                            case 61:
                                zzalt.zzm(obj3, iZzA & 1048575, zzaipVar.zzq());
                                this.zzN(obj3, iZzb, iZzO);
                                obj2 = obj3;
                                obj = obj2;
                                break;
                            case RectListKt.BitOffsetForGesturable /* 62 */:
                                zzalt.zzm(obj3, iZzA & 1048575, Integer.valueOf(zzaipVar.zzr()));
                                this.zzN(obj3, iZzb, iZzO);
                                obj2 = obj3;
                                obj = obj2;
                                break;
                            case 63:
                                int iZzs2 = zzaipVar.zzs();
                                zzajt zzajtVarZzs2 = this.zzs(iZzO);
                                if (zzajtVarZzs2 != null && !zzajtVarZzs2.zza(iZzs2)) {
                                    objZzj = zzale.zzD(obj3, iZzb, iZzs2, objZzj, zzalmVar);
                                    obj = obj3;
                                }
                                zzalt.zzm(obj3, iZzA & 1048575, Integer.valueOf(iZzs2));
                                this.zzN(obj3, iZzb, iZzO);
                                obj2 = obj3;
                                obj = obj2;
                                break;
                            case 64:
                                zzalt.zzm(obj3, iZzA & 1048575, Integer.valueOf(zzaipVar.zzt()));
                                this.zzN(obj3, iZzb, iZzO);
                                obj2 = obj3;
                                obj = obj2;
                                break;
                            case 65:
                                zzalt.zzm(obj3, iZzA & 1048575, Long.valueOf(zzaipVar.zzu()));
                                this.zzN(obj3, iZzb, iZzO);
                                obj2 = obj3;
                                obj = obj2;
                                break;
                            case 66:
                                zzalt.zzm(obj3, iZzA & 1048575, Integer.valueOf(zzaipVar.zzv()));
                                this.zzN(obj3, iZzb, iZzO);
                                obj2 = obj3;
                                obj = obj2;
                                break;
                            case 67:
                                zzalt.zzm(obj3, iZzA & 1048575, Long.valueOf(zzaipVar.zzw()));
                                this.zzN(obj3, iZzb, iZzO);
                                obj2 = obj3;
                                obj = obj2;
                                break;
                            case 68:
                                try {
                                    try {
                                        zzaks zzaksVar4 = (zzaks) this.zzv(obj3, iZzb, iZzO);
                                        zzaipVar.zzp(zzaksVar4, this.zzq(iZzO), zzaizVar);
                                        this.zzw(obj3, iZzb, iZzO, zzaksVar4);
                                        obj2 = obj3;
                                    } catch (zzake unused2) {
                                        obj2 = obj3;
                                        zzakvVar = this;
                                        if (objZzj == null) {
                                            objZzj = zzalo.zzj(obj2);
                                        }
                                        if (!zzalmVar.zzh(objZzj, zzaipVar, 0)) {
                                            objZzx2 = objZzj;
                                            while (i2 < zzakvVar.zzl) {
                                                zzalm zzalmVar5 = zzalmVar;
                                                objZzx2 = zzakvVar.zzx(obj2, zzakvVar.zzj[i2], objZzx2, zzalmVar5, obj2);
                                                zzalmVar = zzalmVar5;
                                            }
                                            if (objZzx2 != null) {
                                                ((zzajo) obj2).zzc = (zzaln) objZzx2;
                                            }
                                        }
                                        this = zzakvVar;
                                    }
                                    obj = obj2;
                                } catch (Throwable th5) {
                                    th = th5;
                                    zzakvVar = this;
                                    obj2 = obj3;
                                    i = zzakvVar.zzk;
                                    objZzx = objZzj;
                                    while (i < zzakvVar.zzl) {
                                        zzalm zzalmVar6 = zzalmVar;
                                        objZzx = zzakvVar.zzx(obj2, zzakvVar.zzj[i], objZzx, zzalmVar6, obj2);
                                        i++;
                                        zzalmVar = zzalmVar6;
                                    }
                                    if (objZzx == null) {
                                        throw th;
                                    }
                                    ((zzajo) obj2).zzc = (zzaln) objZzx;
                                    throw th;
                                }
                                break;
                            default:
                                obj2 = obj3;
                                if (objZzj == null) {
                                    try {
                                        try {
                                            objZzj = zzalo.zzj(obj2);
                                        } catch (Throwable th6) {
                                            th = th6;
                                            th = th;
                                            zzakvVar = this;
                                            i = zzakvVar.zzk;
                                            objZzx = objZzj;
                                            while (i < zzakvVar.zzl) {
                                                zzalm zzalmVar7 = zzalmVar;
                                                objZzx = zzakvVar.zzx(obj2, zzakvVar.zzj[i], objZzx, zzalmVar7, obj2);
                                                i++;
                                                zzalmVar = zzalmVar7;
                                            }
                                            if (objZzx == null) {
                                                throw th;
                                            }
                                            ((zzajo) obj2).zzc = (zzaln) objZzx;
                                            throw th;
                                        }
                                    } catch (zzake unused3) {
                                        zzakvVar = this;
                                        if (objZzj == null) {
                                            objZzj = zzalo.zzj(obj2);
                                        }
                                        if (!zzalmVar.zzh(objZzj, zzaipVar, 0)) {
                                            objZzx2 = objZzj;
                                            while (i2 < zzakvVar.zzl) {
                                                zzalm zzalmVar8 = zzalmVar;
                                                objZzx2 = zzakvVar.zzx(obj2, zzakvVar.zzj[i2], objZzx2, zzalmVar8, obj2);
                                                zzalmVar = zzalmVar8;
                                            }
                                            if (objZzx2 != null) {
                                                ((zzajo) obj2).zzc = (zzaln) objZzx2;
                                            }
                                        }
                                        this = zzakvVar;
                                    }
                                }
                                try {
                                    if (!zzalmVar.zzh(objZzj, zzaipVar, 0)) {
                                        objZzx2 = objZzj;
                                        for (int i3 = this.zzk; i3 < this.zzl; i3++) {
                                            zzalm zzalmVar9 = zzalmVar;
                                            objZzx2 = this.zzx(obj2, this.zzj[i3], objZzx2, zzalmVar9, obj2);
                                            zzalmVar = zzalmVar9;
                                        }
                                    }
                                    obj = obj2;
                                } catch (Throwable th7) {
                                    th = th7;
                                    zzakvVar = this;
                                    th = th;
                                    i = zzakvVar.zzk;
                                    objZzx = objZzj;
                                    while (i < zzakvVar.zzl) {
                                        zzalm zzalmVar10 = zzalmVar;
                                        objZzx = zzakvVar.zzx(obj2, zzakvVar.zzj[i], objZzx, zzalmVar10, obj2);
                                        i++;
                                        zzalmVar = zzalmVar10;
                                    }
                                    if (objZzx == null) {
                                        throw th;
                                    }
                                    ((zzajo) obj2).zzc = (zzaln) objZzx;
                                    throw th;
                                }
                                break;
                        }
                    } catch (Throwable th8) {
                        th = th8;
                        zzakvVar = this;
                        obj2 = obj3;
                    }
                } else if (iZzb == Integer.MAX_VALUE) {
                    int i4 = this.zzk;
                    objZzx2 = objZzj;
                    while (i4 < this.zzl) {
                        zzalm zzalmVar11 = zzalmVar;
                        zzakv<T> zzakvVar2 = this;
                        Object obj4 = obj;
                        objZzx2 = zzakvVar2.zzx(obj4, this.zzj[i4], objZzx2, zzalmVar11, obj);
                        zzalmVar = zzalmVar11;
                        i4++;
                        obj = obj4;
                        this = zzakvVar2;
                    }
                    obj2 = obj;
                } else {
                    zzakvVar = this;
                    Object obj5 = obj;
                    try {
                        if ((!zzakvVar.zzh ? null : zzaizVar.zzd(zzakvVar.zzg, iZzb)) != null) {
                            obj3 = obj5;
                            this = zzakvVar;
                            throw null;
                        }
                        if (objZzj == null) {
                            try {
                                objZzj = zzalo.zzj(obj5);
                            } catch (Throwable th9) {
                                th = th9;
                                obj2 = obj5;
                                i = zzakvVar.zzk;
                                objZzx = objZzj;
                                while (i < zzakvVar.zzl) {
                                    zzalm zzalmVar12 = zzalmVar;
                                    objZzx = zzakvVar.zzx(obj2, zzakvVar.zzj[i], objZzx, zzalmVar12, obj2);
                                    i++;
                                    zzalmVar = zzalmVar12;
                                }
                                if (objZzx == null) {
                                    throw th;
                                }
                                ((zzajo) obj2).zzc = (zzaln) objZzx;
                                throw th;
                            }
                        }
                        if (zzalmVar.zzh(objZzj, zzaipVar, 0)) {
                            obj3 = obj5;
                            this = zzakvVar;
                            obj = obj3;
                        } else {
                            int i5 = zzakvVar.zzk;
                            objZzx2 = objZzj;
                            while (i5 < zzakvVar.zzl) {
                                zzalm zzalmVar13 = zzalmVar;
                                Object obj6 = obj5;
                                objZzx2 = zzakvVar.zzx(obj6, zzakvVar.zzj[i5], objZzx2, zzalmVar13, obj5);
                                zzalmVar = zzalmVar13;
                                i5++;
                                obj5 = obj6;
                            }
                            obj2 = obj5;
                        }
                    } catch (Throwable th10) {
                        obj3 = obj5;
                        th = th10;
                        obj2 = obj3;
                        i = zzakvVar.zzk;
                        objZzx = objZzj;
                        while (i < zzakvVar.zzl) {
                            zzalm zzalmVar14 = zzalmVar;
                            objZzx = zzakvVar.zzx(obj2, zzakvVar.zzj[i], objZzx, zzalmVar14, obj2);
                            i++;
                            zzalmVar = zzalmVar14;
                        }
                        if (objZzx == null) {
                            throw th;
                        }
                        ((zzajo) obj2).zzc = (zzaln) objZzx;
                        throw th;
                    }
                }
            } catch (Throwable th11) {
                th = th11;
                zzakvVar = this;
                obj2 = obj;
            }
        }
        if (objZzx2 != null) {
            ((zzajo) obj2).zzc = (zzaln) objZzx2;
        }
    }

    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached with updateSeq = 37081. Try increasing type updates limit count.
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:79)
        */
    final int zzi(java.lang.Object r36, byte[] r37, int r38, int r39, int r40, com.google.android.gms.internal.nearby.zzahz r41) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 3708
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.nearby.zzakv.zzi(java.lang.Object, byte[], int, int, int, com.google.android.gms.internal.nearby.zzahz):int");
    }

    @Override // com.google.android.gms.internal.nearby.zzald
    public final void zzj(Object obj, byte[] bArr, int i, int i2, zzahz zzahzVar) throws IOException {
        zzi(obj, bArr, i, i2, 0, zzahzVar);
    }

    /* JADX WARN: Code duplicated, block: B:26:0x006f  */
    /* JADX WARN: Code duplicated, block: B:28:0x0075  */
    /* JADX WARN: Code duplicated, block: B:41:0x0082 A[SYNTHETIC] */
    @Override // com.google.android.gms.internal.nearby.zzald
    public final void zzk(Object obj) {
        if (zzD(obj)) {
            if (obj instanceof zzajo) {
                zzajo zzajoVar = (zzajo) obj;
                zzajoVar.zzI(Integer.MAX_VALUE);
                zzajoVar.zza = 0;
                zzajoVar.zzz();
            }
            int[] iArr = this.zzc;
            for (int i = 0; i < iArr.length; i += 3) {
                int iZzA = zzA(i);
                int i2 = 1048575 & iZzA;
                int i3 = (iZzA >>> 20) & 255;
                long j = i2;
                if (i3 != 9) {
                    if (i3 != 60 && i3 != 68) {
                        switch (i3) {
                            case 17:
                                if (zzJ(obj, i)) {
                                    zzq(i).zzk(zzb.getObject(obj, j));
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
                                ((zzajz) zzalt.zzl(obj, j)).zzb();
                                break;
                            case 50:
                                Unsafe unsafe = zzb;
                                Object object = unsafe.getObject(obj, j);
                                if (object != null) {
                                    ((zzakn) object).zzd();
                                    unsafe.putObject(obj, j, object);
                                }
                                break;
                        }
                    } else if (zzL(obj, iArr[i], i)) {
                        zzq(i).zzk(zzb.getObject(obj, j));
                    }
                } else if (zzJ(obj, i)) {
                    zzq(i).zzk(zzb.getObject(obj, j));
                }
            }
            ((zzajo) obj).zzc.zzd();
            if (this.zzh) {
                ((zzajl) obj).zzb.zzb();
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:50:0x00c2  */
    /* JADX WARN: Code duplicated, block: B:52:0x00d1  */
    /* JADX WARN: Code duplicated, block: B:55:0x00dc  */
    /* JADX WARN: Code duplicated, block: B:58:0x00e7 A[LOOP:2: B:53:0x00d6->B:58:0x00e7, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:75:0x00e6 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:82:0x00fb A[SYNTHETIC] */
    @Override // com.google.android.gms.internal.nearby.zzald
    public final boolean zzl(Object obj) {
        int i;
        int i2;
        List list;
        zzald zzaldVarZzq;
        int i3;
        int i4 = 0;
        int i5 = 0;
        int i6 = 1048575;
        while (i4 < this.zzk) {
            int i7 = this.zzj[i4];
            int iZzA = this.zzA(i7);
            int[] iArr = this.zzc;
            int i8 = iArr[i7 + 2];
            int i9 = i8 & 1048575;
            int i10 = 1 << (i8 >>> 20);
            if (i9 != i6) {
                if (i9 != 1048575) {
                    i5 = zzb.getInt(obj, i9);
                }
                i2 = i5;
                i = i9;
            } else {
                i = i6;
                i2 = i5;
            }
            zzakv<T> zzakvVar = this;
            Object obj2 = obj;
            if ((268435456 & iZzA) != 0 && !zzakvVar.zzI(obj2, i7, i, i2, i10)) {
                return false;
            }
            int i11 = (iZzA >>> 20) & 255;
            if (i11 == 9 || i11 == 17) {
                if (zzakvVar.zzI(obj2, i7, i, i2, i10) && !zzy(obj2, iZzA, zzakvVar.zzq(i7))) {
                    return false;
                }
            } else if (i11 == 27) {
                list = (List) zzalt.zzl(obj2, iZzA & 1048575);
                if (list.isEmpty()) {
                    continue;
                } else {
                    zzaldVarZzq = zzakvVar.zzq(i7);
                    for (i3 = 0; i3 < list.size(); i3++) {
                        if (!zzaldVarZzq.zzl(list.get(i3))) {
                            return false;
                        }
                    }
                }
            } else if (i11 == 60 || i11 == 68) {
                if (zzakvVar.zzL(obj2, iArr[i7], i7) && !zzy(obj2, iZzA, zzakvVar.zzq(i7))) {
                    return false;
                }
            } else if (i11 == 49) {
                list = (List) zzalt.zzl(obj2, iZzA & 1048575);
                if (list.isEmpty()) {
                    zzaldVarZzq = zzakvVar.zzq(i7);
                    while (i3 < list.size()) {
                        if (!zzaldVarZzq.zzl(list.get(i3))) {
                            return false;
                        }
                    }
                } else {
                    continue;
                }
            } else if (i11 != 50) {
                continue;
            } else {
                zzakn zzaknVar = (zzakn) zzalt.zzl(obj2, iZzA & 1048575);
                if (!zzaknVar.isEmpty() && ((zzakm) zzakvVar.zzr(i7)).zze().zzc.zza() == zzama.MESSAGE) {
                    zzald zzaldVarZzb = null;
                    for (Object obj3 : zzaknVar.values()) {
                        if (zzaldVarZzb == null) {
                            zzaldVarZzb = zzala.zza().zzb(((zzajo) obj3).getClass());
                        }
                        if (!zzaldVarZzb.zzl(obj3)) {
                            return false;
                        }
                    }
                }
            }
            i4++;
            this = zzakvVar;
            obj = obj2;
            i6 = i;
            i5 = i2;
        }
        return !this.zzh || ((zzajl) obj).zzb.zzd();
    }
}
