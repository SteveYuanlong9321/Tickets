package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zbwm {
    private static final zbwm zba = new zbwm(0, new int[0], new Object[0], false);
    private int zbb;
    private int[] zbc;
    private Object[] zbd;
    private int zbe;
    private boolean zbf;

    private zbwm() {
        this(0, new int[8], new Object[8], true);
    }

    private zbwm(int i, int[] iArr, Object[] objArr, boolean z) {
        this.zbe = -1;
        this.zbb = i;
        this.zbc = iArr;
        this.zbd = objArr;
        this.zbf = z;
    }

    public static zbwm zbc() {
        return zba;
    }

    static zbwm zbe(zbwm zbwmVar, zbwm zbwmVar2) {
        int i = zbwmVar.zbb + zbwmVar2.zbb;
        int[] iArrCopyOf = Arrays.copyOf(zbwmVar.zbc, i);
        System.arraycopy(zbwmVar2.zbc, 0, iArrCopyOf, zbwmVar.zbb, zbwmVar2.zbb);
        Object[] objArrCopyOf = Arrays.copyOf(zbwmVar.zbd, i);
        System.arraycopy(zbwmVar2.zbd, 0, objArrCopyOf, zbwmVar.zbb, zbwmVar2.zbb);
        return new zbwm(i, iArrCopyOf, objArrCopyOf, true);
    }

    static zbwm zbf() {
        return new zbwm(0, new int[8], new Object[8], true);
    }

    private final void zbm(int i) {
        int[] iArr = this.zbc;
        if (i > iArr.length) {
            int i2 = this.zbb;
            int i3 = i2 + (i2 / 2);
            if (i3 >= i) {
                i = i3;
            }
            if (i < 8) {
                i = 8;
            }
            this.zbc = Arrays.copyOf(iArr, i);
            this.zbd = Arrays.copyOf(this.zbd, i);
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof zbwm)) {
            return false;
        }
        zbwm zbwmVar = (zbwm) obj;
        int i = this.zbb;
        if (i == zbwmVar.zbb) {
            int[] iArr = this.zbc;
            int[] iArr2 = zbwmVar.zbc;
            for (int i2 = 0; i2 < i; i2++) {
                if (iArr[i2] == iArr2[i2]) {
                }
            }
            Object[] objArr = this.zbd;
            Object[] objArr2 = zbwmVar.zbd;
            int i3 = this.zbb;
            for (int i4 = 0; i4 < i3; i4++) {
                if (objArr[i4].equals(objArr2[i4])) {
                }
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i = this.zbb;
        int i2 = i + 527;
        int[] iArr = this.zbc;
        int iHashCode = 17;
        int i3 = 17;
        for (int i4 = 0; i4 < i; i4++) {
            i3 = (i3 * 31) + iArr[i4];
        }
        int i5 = ((i2 * 31) + i3) * 31;
        Object[] objArr = this.zbd;
        int i6 = this.zbb;
        for (int i7 = 0; i7 < i6; i7++) {
            iHashCode = (iHashCode * 31) + objArr[i7].hashCode();
        }
        return i5 + iHashCode;
    }

    public final int zba() {
        int iZbD;
        int iZbE;
        int iZbD2;
        int i = this.zbe;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.zbb; i3++) {
            int i4 = this.zbc[i3];
            int i5 = i4 >>> 3;
            int i6 = i4 & 7;
            if (i6 != 0) {
                if (i6 == 1) {
                    ((Long) this.zbd[i3]).longValue();
                    iZbD2 = zbtk.zbD(i5 << 3) + 8;
                } else if (i6 == 2) {
                    int i7 = i5 << 3;
                    zbtc zbtcVar = (zbtc) this.zbd[i3];
                    int iZbD3 = zbtk.zbD(i7);
                    int iZbd = zbtcVar.zbd();
                    iZbD2 = iZbD3 + zbtk.zbD(iZbd) + iZbd;
                } else if (i6 == 3) {
                    int iZbD4 = zbtk.zbD(i5 << 3);
                    iZbD = iZbD4 + iZbD4;
                    iZbE = ((zbwm) this.zbd[i3]).zba();
                } else {
                    if (i6 != 5) {
                        throw new IllegalStateException(new zbup("Protocol message tag had invalid wire type."));
                    }
                    ((Integer) this.zbd[i3]).intValue();
                    iZbD2 = zbtk.zbD(i5 << 3) + 4;
                }
                i2 += iZbD2;
            } else {
                int i8 = i5 << 3;
                long jLongValue = ((Long) this.zbd[i3]).longValue();
                iZbD = zbtk.zbD(i8);
                iZbE = zbtk.zbE(jLongValue);
            }
            iZbD2 = iZbD + iZbE;
            i2 += iZbD2;
        }
        this.zbe = i2;
        return i2;
    }

    public final int zbb() {
        int i = this.zbe;
        if (i != -1) {
            return i;
        }
        int iZbD = 0;
        for (int i2 = 0; i2 < this.zbb; i2++) {
            int i3 = this.zbc[i2] >>> 3;
            zbtc zbtcVar = (zbtc) this.zbd[i2];
            int iZbD2 = zbtk.zbD(8);
            int iZbD3 = zbtk.zbD(16) + zbtk.zbD(i3);
            int iZbD4 = zbtk.zbD(24);
            int iZbd = zbtcVar.zbd();
            iZbD += iZbD2 + iZbD2 + iZbD3 + iZbD4 + zbtk.zbD(iZbd) + iZbd;
        }
        this.zbe = iZbD;
        return iZbD;
    }

    final zbwm zbd(zbwm zbwmVar) {
        if (zbwmVar.equals(zba)) {
            return this;
        }
        zbg();
        int i = this.zbb + zbwmVar.zbb;
        zbm(i);
        System.arraycopy(zbwmVar.zbc, 0, this.zbc, this.zbb, zbwmVar.zbb);
        System.arraycopy(zbwmVar.zbd, 0, this.zbd, this.zbb, zbwmVar.zbb);
        this.zbb = i;
        return this;
    }

    final void zbg() {
        if (!this.zbf) {
            throw new UnsupportedOperationException();
        }
    }

    public final void zbh() {
        if (this.zbf) {
            this.zbf = false;
        }
    }

    final void zbi(StringBuilder sb, int i) {
        for (int i2 = 0; i2 < this.zbb; i2++) {
            zbvo.zbb(sb, i, String.valueOf(this.zbc[i2] >>> 3), this.zbd[i2]);
        }
    }

    final void zbj(int i, Object obj) {
        zbg();
        zbm(this.zbb + 1);
        int[] iArr = this.zbc;
        int i2 = this.zbb;
        iArr[i2] = i;
        this.zbd[i2] = obj;
        this.zbb = i2 + 1;
    }

    final void zbk(zbwy zbwyVar) throws IOException {
        for (int i = 0; i < this.zbb; i++) {
            zbwyVar.zbx(this.zbc[i] >>> 3, this.zbd[i]);
        }
    }

    public final void zbl(zbwy zbwyVar) throws IOException {
        if (this.zbb != 0) {
            for (int i = 0; i < this.zbb; i++) {
                int i2 = this.zbc[i];
                Object obj = this.zbd[i];
                int i3 = i2 & 7;
                int i4 = i2 >>> 3;
                if (i3 == 0) {
                    zbwyVar.zbt(i4, ((Long) obj).longValue());
                } else if (i3 == 1) {
                    zbwyVar.zbm(i4, ((Long) obj).longValue());
                } else if (i3 == 2) {
                    zbwyVar.zbd(i4, (zbtc) obj);
                } else if (i3 == 3) {
                    zbwyVar.zbG(i4);
                    ((zbwm) obj).zbl(zbwyVar);
                    zbwyVar.zbh(i4);
                } else {
                    if (i3 != 5) {
                        throw new RuntimeException(new zbup("Protocol message tag had invalid wire type."));
                    }
                    zbwyVar.zbk(i4, ((Integer) obj).intValue());
                }
            }
        }
    }
}
