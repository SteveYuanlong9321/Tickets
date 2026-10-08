package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

import java.io.IOException;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zbtu {
    private static final zbtu zbb = new zbtu(true);
    final zbwh zba = new zbwa();
    private boolean zbc;
    private boolean zbd;

    private zbtu() {
    }

    static int zba(zbww zbwwVar, int i, Object obj) {
        int iZbd;
        int iZbD;
        int iZbD2 = zbtk.zbD(i << 3);
        if (zbwwVar == zbww.GROUP) {
            zbuo.zbd((zbvm) obj);
            iZbD2 += iZbD2;
        }
        zbwx zbwxVar = zbwx.INT;
        int iZbE = 4;
        switch (zbwwVar) {
            case DOUBLE:
                ((Double) obj).doubleValue();
                iZbE = 8;
                return iZbD2 + iZbE;
            case FLOAT:
                ((Float) obj).floatValue();
                return iZbD2 + iZbE;
            case INT64:
                iZbE = zbtk.zbE(((Long) obj).longValue());
                return iZbD2 + iZbE;
            case UINT64:
                iZbE = zbtk.zbE(((Long) obj).longValue());
                return iZbD2 + iZbE;
            case INT32:
                iZbE = zbtk.zbE(((Integer) obj).intValue());
                return iZbD2 + iZbE;
            case FIXED64:
                ((Long) obj).longValue();
                iZbE = 8;
                return iZbD2 + iZbE;
            case FIXED32:
                ((Integer) obj).intValue();
                return iZbD2 + iZbE;
            case BOOL:
                ((Boolean) obj).booleanValue();
                iZbE = 1;
                return iZbD2 + iZbE;
            case STRING:
                if (obj instanceof zbtc) {
                    iZbd = ((zbtc) obj).zbd();
                    iZbD = zbtk.zbD(iZbd);
                    iZbE = iZbD + iZbd;
                } else {
                    iZbE = zbtk.zbC((String) obj);
                }
                return iZbD2 + iZbE;
            case GROUP:
                iZbE = ((zbvm) obj).zbo();
                return iZbD2 + iZbE;
            case MESSAGE:
                if (obj instanceof zbuv) {
                    iZbd = ((zbuv) obj).zba();
                    iZbD = zbtk.zbD(iZbd);
                    iZbE = iZbD + iZbd;
                } else {
                    iZbE = zbtk.zbA((zbvm) obj);
                }
                return iZbD2 + iZbE;
            case BYTES:
                if (obj instanceof zbtc) {
                    iZbd = ((zbtc) obj).zbd();
                    iZbD = zbtk.zbD(iZbd);
                } else {
                    iZbd = ((byte[]) obj).length;
                    iZbD = zbtk.zbD(iZbd);
                }
                iZbE = iZbD + iZbd;
                return iZbD2 + iZbE;
            case UINT32:
                iZbE = zbtk.zbD(((Integer) obj).intValue());
                return iZbD2 + iZbE;
            case ENUM:
                iZbE = obj instanceof zbuh ? zbtk.zbE(((zbuh) obj).zba()) : zbtk.zbE(((Integer) obj).intValue());
                return iZbD2 + iZbE;
            case SFIXED32:
                ((Integer) obj).intValue();
                return iZbD2 + iZbE;
            case SFIXED64:
                ((Long) obj).longValue();
                iZbE = 8;
                return iZbD2 + iZbE;
            case SINT32:
                int iIntValue = ((Integer) obj).intValue();
                iZbE = zbtk.zbD((iIntValue >> 31) ^ (iIntValue + iIntValue));
                return iZbD2 + iZbE;
            case SINT64:
                long jLongValue = ((Long) obj).longValue();
                iZbE = zbtk.zbE((jLongValue >> 63) ^ (jLongValue + jLongValue));
                return iZbD2 + iZbE;
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    public static int zbb(zbtt zbttVar, Object obj) {
        zbww zbwwVarZbd = zbttVar.zbd();
        zbttVar.zba();
        zbttVar.zbg();
        return zba(zbwwVarZbd, 32149011, obj);
    }

    public static zbtu zbe() {
        return zbb;
    }

    static void zbk(zbtk zbtkVar, zbww zbwwVar, int i, Object obj) throws IOException {
        if (zbwwVar == zbww.GROUP) {
            zbvm zbvmVar = (zbvm) obj;
            zbuo.zbd(zbvmVar);
            zbtkVar.zbu(i, 3);
            zbvmVar.zbL(zbtkVar);
            zbtkVar.zbu(i, 4);
            return;
        }
        zbtkVar.zbu(i, zbwwVar.zba());
        zbwx zbwxVar = zbwx.INT;
        switch (zbwwVar) {
            case DOUBLE:
                zbtkVar.zbk(Double.doubleToRawLongBits(((Double) obj).doubleValue()));
                break;
            case FLOAT:
                zbtkVar.zbi(Float.floatToRawIntBits(((Float) obj).floatValue()));
                break;
            case INT64:
                zbtkVar.zby(((Long) obj).longValue());
                break;
            case UINT64:
                zbtkVar.zby(((Long) obj).longValue());
                break;
            case INT32:
                zbtkVar.zbm(((Integer) obj).intValue());
                break;
            case FIXED64:
                zbtkVar.zbk(((Long) obj).longValue());
                break;
            case FIXED32:
                zbtkVar.zbi(((Integer) obj).intValue());
                break;
            case BOOL:
                zbtkVar.zbb(((Boolean) obj).booleanValue() ? (byte) 1 : (byte) 0);
                break;
            case STRING:
                if (!(obj instanceof zbtc)) {
                    zbtkVar.zbt((String) obj);
                } else {
                    zbtkVar.zbg((zbtc) obj);
                }
                break;
            case GROUP:
                ((zbvm) obj).zbL(zbtkVar);
                break;
            case MESSAGE:
                zbtkVar.zbp((zbvm) obj);
                break;
            case BYTES:
                if (!(obj instanceof zbtc)) {
                    byte[] bArr = (byte[]) obj;
                    zbtkVar.zbe(bArr, 0, bArr.length);
                } else {
                    zbtkVar.zbg((zbtc) obj);
                }
                break;
            case UINT32:
                zbtkVar.zbw(((Integer) obj).intValue());
                break;
            case ENUM:
                if (!(obj instanceof zbuh)) {
                    zbtkVar.zbm(((Integer) obj).intValue());
                } else {
                    zbtkVar.zbm(((zbuh) obj).zba());
                }
                break;
            case SFIXED32:
                zbtkVar.zbi(((Integer) obj).intValue());
                break;
            case SFIXED64:
                zbtkVar.zbk(((Long) obj).longValue());
                break;
            case SINT32:
                int iIntValue = ((Integer) obj).intValue();
                zbtkVar.zbw((iIntValue >> 31) ^ (iIntValue + iIntValue));
                break;
            case SINT64:
                long jLongValue = ((Long) obj).longValue();
                zbtkVar.zby((jLongValue >> 63) ^ (jLongValue + jLongValue));
                break;
        }
    }

    private static Object zbn(Object obj) {
        if (obj instanceof zbvr) {
            return ((zbvr) obj).zbc();
        }
        if (!(obj instanceof byte[])) {
            return obj;
        }
        byte[] bArr = (byte[]) obj;
        int length = bArr.length;
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, 0, bArr2, 0, length);
        return bArr2;
    }

    private final void zbo(Map.Entry entry) {
        zbtt zbttVar = (zbtt) entry.getKey();
        Object value = entry.getValue();
        boolean z = value instanceof zbuv;
        zbttVar.zbg();
        if (zbttVar.zbe() != zbwx.MESSAGE) {
            if (z) {
                throw new IllegalStateException("Lazy fields must be message-valued");
            }
            this.zba.put(zbttVar, zbn(value));
            return;
        }
        Object objZbf = zbf(zbttVar);
        if (objZbf == null) {
            this.zba.put(zbttVar, zbn(value));
            if (z) {
                this.zbd = true;
                return;
            }
            return;
        }
        if (z) {
            throw null;
        }
        this.zba.put(zbttVar, objZbf instanceof zbvr ? zbttVar.zbc((zbvr) objZbf, (zbvr) value) : zbttVar.zbb(((zbvm) objZbf).zbK(), (zbvm) value).zbk());
    }

    private static boolean zbp(Map.Entry entry) {
        zbtt zbttVar = (zbtt) entry.getKey();
        if (zbttVar.zbe() != zbwx.MESSAGE) {
            return true;
        }
        zbttVar.zbg();
        Object value = entry.getValue();
        if (value instanceof zbvn) {
            return ((zbvn) value).zbp();
        }
        if (value instanceof zbuv) {
            return true;
        }
        throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
    }

    private static final int zbq(Map.Entry entry) {
        int i;
        int iZbD;
        int iZbD2;
        zbtt zbttVar = (zbtt) entry.getKey();
        Object value = entry.getValue();
        if (zbttVar.zbe() != zbwx.MESSAGE) {
            return zbb(zbttVar, value);
        }
        zbttVar.zbg();
        zbttVar.zbf();
        if (value instanceof zbuv) {
            ((zbtt) entry.getKey()).zba();
            int iZbD3 = zbtk.zbD(8);
            i = iZbD3 + iZbD3;
            iZbD = zbtk.zbD(16) + zbtk.zbD(32149011);
            int iZbD4 = zbtk.zbD(24);
            int iZba = ((zbuv) value).zba();
            iZbD2 = iZbD4 + zbtk.zbD(iZba) + iZba;
        } else {
            ((zbtt) entry.getKey()).zba();
            int iZbD5 = zbtk.zbD(8);
            i = iZbD5 + iZbD5;
            iZbD = zbtk.zbD(16) + zbtk.zbD(32149011);
            iZbD2 = zbtk.zbD(24) + zbtk.zbA((zbvm) value);
        }
        return i + iZbD + iZbD2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zbtu) {
            return this.zba.equals(((zbtu) obj).zba);
        }
        return false;
    }

    public final int hashCode() {
        return this.zba.hashCode();
    }

    public final int zbc() {
        zbwh zbwhVar;
        int iZbc = this.zba.zbc();
        int i = 0;
        int iZbq = 0;
        while (true) {
            zbwhVar = this.zba;
            if (i >= iZbc) {
                break;
            }
            iZbq += zbq(zbwhVar.zbg(i));
            i++;
        }
        Iterator it = zbwhVar.zbd().iterator();
        while (it.hasNext()) {
            iZbq += zbq((Map.Entry) it.next());
        }
        return iZbq;
    }

    /* JADX INFO: renamed from: zbd, reason: merged with bridge method [inline-methods] */
    public final zbtu clone() {
        zbwh zbwhVar;
        zbtu zbtuVar = new zbtu();
        int iZbc = this.zba.zbc();
        int i = 0;
        while (true) {
            zbwhVar = this.zba;
            if (i >= iZbc) {
                break;
            }
            Map.Entry entryZbg = zbwhVar.zbg(i);
            zbtuVar.zbj((zbtt) ((zbwb) entryZbg).zba(), entryZbg.getValue());
            i++;
        }
        for (Map.Entry entry : zbwhVar.zbd()) {
            zbtuVar.zbj((zbtt) entry.getKey(), entry.getValue());
        }
        zbtuVar.zbd = this.zbd;
        return zbtuVar;
    }

    public final Object zbf(zbtt zbttVar) {
        Object obj = this.zba.get(zbttVar);
        if (!(obj instanceof zbuv)) {
            return obj;
        }
        throw null;
    }

    public final Iterator zbg() {
        if (this.zba.isEmpty()) {
            return Collections.emptyIterator();
        }
        boolean z = this.zbd;
        zbwh zbwhVar = this.zba;
        return z ? new zbuu(zbwhVar.entrySet().iterator()) : zbwhVar.entrySet().iterator();
    }

    public final void zbh() {
        if (this.zbc) {
            return;
        }
        int iZbc = this.zba.zbc();
        int i = 0;
        while (true) {
            zbwh zbwhVar = this.zba;
            if (i >= iZbc) {
                zbwhVar.zba();
                this.zbc = true;
                return;
            } else {
                Map.Entry entryZbg = zbwhVar.zbg(i);
                if (entryZbg.getValue() instanceof zbuf) {
                    ((zbuf) entryZbg.getValue()).zbB();
                }
                i++;
            }
        }
    }

    public final void zbi(zbtu zbtuVar) {
        int iZbc = zbtuVar.zba.zbc();
        for (int i = 0; i < iZbc; i++) {
            zbo(zbtuVar.zba.zbg(i));
        }
        Iterator it = zbtuVar.zba.zbd().iterator();
        while (it.hasNext()) {
            zbo((Map.Entry) it.next());
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:29:0x004e  */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x002b, code lost:
    
        if ((r4 instanceof com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuh) == false) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0034, code lost:
    
        if ((r4 instanceof byte[]) == false) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0048, code lost:
    
        if (r0 != false) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0022, code lost:
    
        if ((r4 instanceof com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuv) == false) goto L32;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zbj(zbtt zbttVar, Object obj) {
        boolean z;
        zbttVar.zbg();
        zbttVar.zbd();
        byte[] bArr = zbuo.zbb;
        obj.getClass();
        zbww zbwwVar = zbww.DOUBLE;
        zbwx zbwxVar = zbwx.INT;
        switch (r0.zbb()) {
            case INT:
                z = obj instanceof Integer;
                break;
            case LONG:
                z = obj instanceof Long;
                break;
            case FLOAT:
                z = obj instanceof Float;
                break;
            case DOUBLE:
                z = obj instanceof Double;
                break;
            case BOOLEAN:
                z = obj instanceof Boolean;
                break;
            case STRING:
                z = obj instanceof String;
                break;
            case BYTE_STRING:
                if (!(obj instanceof zbtc)) {
                    break;
                }
                if (obj instanceof zbuv) {
                    this.zbd = true;
                }
                this.zba.put(zbttVar, obj);
                return;
            case ENUM:
                if (!(obj instanceof Integer)) {
                    break;
                }
                if (obj instanceof zbuv) {
                    this.zbd = true;
                }
                this.zba.put(zbttVar, obj);
                return;
            case MESSAGE:
                if (!(obj instanceof zbvm)) {
                    break;
                }
                if (obj instanceof zbuv) {
                    this.zbd = true;
                }
                this.zba.put(zbttVar, obj);
                return;
            default:
                zbttVar.zba();
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", 32149011, zbttVar.zbd().zbb(), obj.getClass().getName()));
        }
    }

    public final boolean zbl() {
        return this.zbc;
    }

    public final boolean zbm() {
        int iZbc = this.zba.zbc();
        int i = 0;
        while (true) {
            zbwh zbwhVar = this.zba;
            if (i >= iZbc) {
                Iterator it = zbwhVar.zbd().iterator();
                while (it.hasNext()) {
                    if (!zbp((Map.Entry) it.next())) {
                        return false;
                    }
                }
                return true;
            }
            if (!zbp(zbwhVar.zbg(i))) {
                return false;
            }
            i++;
        }
    }

    private zbtu(boolean z) {
        zbh();
        zbh();
    }
}
