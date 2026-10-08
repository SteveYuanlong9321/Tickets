package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

import java.io.IOException;

/* JADX INFO: compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* JADX INFO: loaded from: classes4.dex */
class zbtb extends zbta {
    protected final byte[] zba;

    zbtb(byte[] bArr) {
        super(null);
        bArr.getClass();
        this.zba = bArr;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbtc
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zbtc) || zbd() != ((zbtc) obj).zbd()) {
            return false;
        }
        if (zbd() == 0) {
            return true;
        }
        if (!(obj instanceof zbtb)) {
            return obj.equals(this);
        }
        zbtb zbtbVar = (zbtb) obj;
        int iZbi = zbi();
        int iZbi2 = zbtbVar.zbi();
        if (iZbi != 0 && iZbi2 != 0 && iZbi != iZbi2) {
            return false;
        }
        int iZbd = zbd();
        if (iZbd > zbtbVar.zbd()) {
            throw new IllegalArgumentException("Length too large: " + iZbd + zbd());
        }
        if (iZbd > zbtbVar.zbd()) {
            throw new IllegalArgumentException("Ran off end of other: 0, " + iZbd + ", " + zbtbVar.zbd());
        }
        if (!(zbtbVar instanceof zbtb)) {
            return zbtbVar.zbf(0, iZbd).equals(zbf(0, iZbd));
        }
        byte[] bArr = this.zba;
        byte[] bArr2 = zbtbVar.zba;
        zbtbVar.zbc();
        int i = 0;
        int i2 = 0;
        while (i < iZbd) {
            if (bArr[i] != bArr2[i2]) {
                return false;
            }
            i++;
            i2++;
        }
        return true;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbtc
    public byte zba(int i) {
        return this.zba[i];
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbtc
    byte zbb(int i) {
        return this.zba[i];
    }

    protected int zbc() {
        return 0;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbtc
    public int zbd() {
        return this.zba.length;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbtc
    protected final int zbe(int i, int i2, int i3) {
        return zbuo.zbb(i, this.zba, 0, i3);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbtc
    public final zbtc zbf(int i, int i2) {
        int iZbh = zbh(0, i2, zbd());
        return iZbh == 0 ? zbtc.zbb : new zbsw(this.zba, 0, iZbh);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbtc
    final void zbg(zbst zbstVar) throws IOException {
        ((zbth) zbstVar).zbc(this.zba, 0, zbd());
    }
}
