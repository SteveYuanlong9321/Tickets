package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zbvq implements zbvx {
    private final zbvm zba;
    private final zbwl zbb;
    private final boolean zbc;
    private final zbtq zbd;

    private zbvq(zbwl zbwlVar, zbtq zbtqVar, zbvm zbvmVar) {
        this.zbb = zbwlVar;
        this.zbc = zbvmVar instanceof zbub;
        this.zbd = zbtqVar;
        this.zba = zbvmVar;
    }

    static zbvq zbc(zbwl zbwlVar, zbtq zbtqVar, zbvm zbvmVar) {
        return new zbvq(zbwlVar, zbtqVar, zbvmVar);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbvx
    public final int zba(Object obj) {
        int iZbb = ((zbuf) obj).zbc.zbb();
        return this.zbc ? iZbb + ((zbub) obj).zbb.zbc() : iZbb;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbvx
    public final int zbb(Object obj) {
        int iHashCode = ((zbuf) obj).zbc.hashCode();
        return this.zbc ? (iHashCode * 53) + ((zbub) obj).zbb.zba.hashCode() : iHashCode;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbvx
    public final Object zbe() {
        zbvm zbvmVar = this.zba;
        return zbvmVar instanceof zbuf ? ((zbuf) zbvmVar).zbt() : zbvmVar.zbJ().zbl();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbvx
    public final void zbf(Object obj) {
        this.zbb.zbb(obj);
        this.zbd.zba(obj);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbvx
    public final void zbg(Object obj, Object obj2) {
        zbvz.zbp(this.zbb, obj, obj2);
        if (this.zbc) {
            zbvz.zbo(this.zbd, obj, obj2);
        }
    }

    /* JADX WARN: Code duplicated, block: B:31:0x00b8  */
    /* JADX WARN: Code duplicated, block: B:61:0x00be A[EDGE_INSN: B:61:0x00be->B:33:0x00be BREAK  A[LOOP:1: B:17:0x0067->B:64:0x0067], SYNTHETIC] */
    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbvx
    public final void zbh(Object obj, byte[] bArr, int i, int i2, zbsq zbsqVar) throws IOException {
        int iZbk;
        zbuf zbufVar = (zbuf) obj;
        zbwm zbwmVarZbf = zbufVar.zbc;
        if (zbwmVarZbf == zbwm.zbc()) {
            zbwmVarZbf = zbwm.zbf();
            zbufVar.zbc = zbwmVarZbf;
        }
        zbwm zbwmVar = zbwmVarZbf;
        zbtu zbtuVarZbg = ((zbub) obj).zbg();
        zbud zbudVarZbc = null;
        while (i < i2) {
            int iZbk2 = zbsr.zbk(bArr, i, zbsqVar);
            int i3 = zbsqVar.zba;
            if (i3 == 11) {
                int i4 = i2;
                zbsq zbsqVar2 = zbsqVar;
                int i5 = 0;
                zbtc zbtcVar = null;
                while (true) {
                    if (iZbk2 >= i4) {
                        iZbk = iZbk2;
                        break;
                    }
                    iZbk = zbsr.zbk(bArr, iZbk2, zbsqVar2);
                    int i6 = zbsqVar2.zba;
                    int i7 = i6 >>> 3;
                    int i8 = i6 & 7;
                    if (i7 == 2) {
                        if (i8 != 0) {
                            if (i6 != 12) {
                                break;
                                break;
                            }
                            iZbk2 = zbsr.zbq(i6, bArr, iZbk, i4, zbsqVar2);
                        } else {
                            iZbk2 = zbsr.zbk(bArr, iZbk, zbsqVar2);
                            i5 = zbsqVar2.zba;
                            zbudVarZbc = zbsqVar2.zbd.zbc(this.zba, i5);
                        }
                    } else {
                        if (i7 == 3) {
                            if (zbudVarZbc != null) {
                                iZbk2 = zbsr.zbe(zbvu.zba().zbb(zbudVarZbc.zba.getClass()), bArr, iZbk, i4, zbsqVar2);
                                zbtuVarZbg.zbj(zbudVarZbc.zbb, zbsqVar2.zbc);
                            } else if (i8 == 2) {
                                iZbk2 = zbsr.zba(bArr, iZbk, zbsqVar2);
                                zbtcVar = (zbtc) zbsqVar2.zbc;
                            }
                        }
                        if (i6 != 12) {
                            break;
                        } else {
                            iZbk2 = zbsr.zbq(i6, bArr, iZbk, i4, zbsqVar2);
                        }
                    }
                }
                if (zbtcVar != null) {
                    zbwmVar.zbj((i5 << 3) | 2, zbtcVar);
                }
                i = iZbk;
                i2 = i4;
                zbsqVar = zbsqVar2;
            } else if ((i3 & 7) == 2) {
                zbudVarZbc = zbsqVar.zbd.zbc(this.zba, i3 >>> 3);
                if (zbudVarZbc != null) {
                    i = zbsr.zbe(zbvu.zba().zbb(zbudVarZbc.zba.getClass()), bArr, iZbk2, i2, zbsqVar);
                    zbtuVarZbg.zbj(zbudVarZbc.zbb, zbsqVar.zbc);
                } else {
                    i = zbsr.zbj(i3, bArr, iZbk2, i2, zbwmVar, zbsqVar);
                }
            } else {
                i = zbsr.zbq(i3, bArr, iZbk2, i2, zbsqVar);
            }
        }
        if (i != i2) {
            throw new zbuq("Failed to parse the message.");
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbvx
    public final void zbi(Object obj, zbwy zbwyVar) throws IOException {
        Iterator itZbg = ((zbub) obj).zbb.zbg();
        while (itZbg.hasNext()) {
            Map.Entry entry = (Map.Entry) itZbg.next();
            zbtt zbttVar = (zbtt) entry.getKey();
            if (zbttVar.zbe() != zbwx.MESSAGE) {
                throw new IllegalStateException("Found invalid MessageSet item.");
            }
            zbttVar.zbg();
            zbttVar.zbf();
            if (entry instanceof zbut) {
                zbttVar.zba();
                zbwyVar.zbx(32149011, ((zbut) entry).zba().zbb());
            } else {
                zbttVar.zba();
                zbwyVar.zbx(32149011, entry.getValue());
            }
        }
        ((zbuf) obj).zbc.zbk(zbwyVar);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbvx
    public final boolean zbj(Object obj, Object obj2) {
        if (!((zbuf) obj).zbc.equals(((zbuf) obj2).zbc)) {
            return false;
        }
        if (this.zbc) {
            return ((zbub) obj).zbb.equals(((zbub) obj2).zbb);
        }
        return true;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbvx
    public final boolean zbk(Object obj) {
        return ((zbub) obj).zbb.zbm();
    }
}
