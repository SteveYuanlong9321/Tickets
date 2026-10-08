package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zbtl implements zbwy {
    private final zbtk zba;

    private zbtl(zbtk zbtkVar) {
        byte[] bArr = zbuo.zbb;
        this.zba = zbtkVar;
        zbtkVar.zba = this;
    }

    public static zbtl zba(zbtk zbtkVar) {
        zbtl zbtlVar = zbtkVar.zba;
        return zbtlVar != null ? zbtlVar : new zbtl(zbtkVar);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbwy
    public final void zbA(int i, long j) throws IOException {
        this.zba.zbj(i, j);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbwy
    public final void zbC(int i, int i2) throws IOException {
        zbtk zbtkVar = this.zba;
        zbtkVar.zbv(i, (i2 >> 31) ^ (i2 + i2));
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbwy
    public final void zbE(int i, long j) throws IOException {
        zbtk zbtkVar = this.zba;
        zbtkVar.zbx(i, (j >> 63) ^ (j + j));
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbwy
    @Deprecated
    public final void zbG(int i) throws IOException {
        this.zba.zbu(i, 3);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbwy
    public final void zbH(int i, String str) throws IOException {
        this.zba.zbs(i, str);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbwy
    public final void zbJ(int i, int i2) throws IOException {
        this.zba.zbv(i, i2);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbwy
    public final void zbL(int i, long j) throws IOException {
        this.zba.zbx(i, j);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbwy
    public final void zbb(int i, boolean z) throws IOException {
        this.zba.zbd(i, z);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbwy
    public final void zbd(int i, zbtc zbtcVar) throws IOException {
        this.zba.zbf(i, zbtcVar);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbwy
    public final void zbe(int i, List list) throws IOException {
        for (int i2 = 0; i2 < list.size(); i2++) {
            this.zba.zbf(i, (zbtc) list.get(i2));
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbwy
    public final void zbf(int i, double d) throws IOException {
        this.zba.zbj(i, Double.doubleToRawLongBits(d));
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbwy
    @Deprecated
    public final void zbh(int i) throws IOException {
        this.zba.zbu(i, 4);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbwy
    public final void zbi(int i, int i2) throws IOException {
        this.zba.zbl(i, i2);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbwy
    public final void zbk(int i, int i2) throws IOException {
        this.zba.zbh(i, i2);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbwy
    public final void zbm(int i, long j) throws IOException {
        this.zba.zbj(i, j);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbwy
    public final void zbo(int i, float f) throws IOException {
        this.zba.zbh(i, Float.floatToRawIntBits(f));
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbwy
    public final void zbq(int i, Object obj, zbvx zbvxVar) throws IOException {
        zbtk zbtkVar = this.zba;
        zbtkVar.zbu(i, 3);
        zbvxVar.zbi((zbvm) obj, zbtkVar.zba);
        zbtkVar.zbu(i, 4);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbwy
    public final void zbr(int i, int i2) throws IOException {
        this.zba.zbl(i, i2);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbwy
    public final void zbt(int i, long j) throws IOException {
        this.zba.zbx(i, j);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbwy
    public final void zbv(int i, zbve zbveVar, Map map) throws IOException {
        for (Map.Entry entry : map.entrySet()) {
            this.zba.zbu(i, 2);
            this.zba.zbw(zbvf.zbb(zbveVar, entry.getKey(), entry.getValue()));
            zbvf.zbe(this.zba, zbveVar, entry.getKey(), entry.getValue());
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbwy
    public final void zbw(int i, Object obj, zbvx zbvxVar) throws IOException {
        this.zba.zbo(i, (zbvm) obj, zbvxVar);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbwy
    public final void zbx(int i, Object obj) throws IOException {
        boolean z = obj instanceof zbtc;
        zbtk zbtkVar = this.zba;
        if (z) {
            zbtkVar.zbr(i, (zbtc) obj);
        } else {
            zbtkVar.zbq(i, (zbvm) obj);
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbwy
    public final void zby(int i, int i2) throws IOException {
        this.zba.zbh(i, i2);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbwy
    public final void zbI(int i, List list) throws IOException {
        int i2 = 0;
        if (!(list instanceof zbux)) {
            while (i2 < list.size()) {
                this.zba.zbs(i, (String) list.get(i2));
                i2++;
            }
            return;
        }
        zbux zbuxVar = (zbux) list;
        while (i2 < list.size()) {
            Object objZba = zbuxVar.zba();
            boolean z = objZba instanceof String;
            zbtk zbtkVar = this.zba;
            if (z) {
                zbtkVar.zbs(i, (String) objZba);
            } else {
                zbtkVar.zbf(i, (zbtc) objZba);
            }
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbwy
    public final void zbK(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zbug)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zba.zbv(i, ((Integer) list.get(i2)).intValue());
                    i2++;
                }
                return;
            }
            this.zba.zbu(i, 2);
            int iZbD = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                iZbD += zbtk.zbD(((Integer) list.get(i3)).intValue());
            }
            this.zba.zbw(iZbD);
            while (i2 < list.size()) {
                this.zba.zbw(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        zbug zbugVar = (zbug) list;
        if (!z) {
            while (i2 < zbugVar.size()) {
                this.zba.zbv(i, zbugVar.zbe(i2));
                i2++;
            }
            return;
        }
        this.zba.zbu(i, 2);
        int iZbD2 = 0;
        for (int i4 = 0; i4 < zbugVar.size(); i4++) {
            iZbD2 += zbtk.zbD(zbugVar.zbe(i4));
        }
        this.zba.zbw(iZbD2);
        while (i2 < zbugVar.size()) {
            this.zba.zbw(zbugVar.zbe(i2));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbwy
    public final void zbM(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zbva)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zba.zbx(i, ((Long) list.get(i2)).longValue());
                    i2++;
                }
                return;
            }
            this.zba.zbu(i, 2);
            int iZbE = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                iZbE += zbtk.zbE(((Long) list.get(i3)).longValue());
            }
            this.zba.zbw(iZbE);
            while (i2 < list.size()) {
                this.zba.zby(((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        zbva zbvaVar = (zbva) list;
        if (!z) {
            while (i2 < zbvaVar.size()) {
                this.zba.zbx(i, zbvaVar.zbe(i2));
                i2++;
            }
            return;
        }
        this.zba.zbu(i, 2);
        int iZbE2 = 0;
        for (int i4 = 0; i4 < zbvaVar.size(); i4++) {
            iZbE2 += zbtk.zbE(zbvaVar.zbe(i4));
        }
        this.zba.zbw(iZbE2);
        while (i2 < zbvaVar.size()) {
            this.zba.zby(zbvaVar.zbe(i2));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbwy
    public final void zbl(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zbug)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zba.zbh(i, ((Integer) list.get(i2)).intValue());
                    i2++;
                }
                return;
            }
            this.zba.zbu(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                ((Integer) list.get(i4)).intValue();
                i3 += 4;
            }
            this.zba.zbw(i3);
            while (i2 < list.size()) {
                this.zba.zbi(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        zbug zbugVar = (zbug) list;
        if (!z) {
            while (i2 < zbugVar.size()) {
                this.zba.zbh(i, zbugVar.zbe(i2));
                i2++;
            }
            return;
        }
        this.zba.zbu(i, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < zbugVar.size(); i6++) {
            zbugVar.zbe(i6);
            i5 += 4;
        }
        this.zba.zbw(i5);
        while (i2 < zbugVar.size()) {
            this.zba.zbi(zbugVar.zbe(i2));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbwy
    public final void zbn(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zbva)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zba.zbj(i, ((Long) list.get(i2)).longValue());
                    i2++;
                }
                return;
            }
            this.zba.zbu(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                ((Long) list.get(i4)).longValue();
                i3 += 8;
            }
            this.zba.zbw(i3);
            while (i2 < list.size()) {
                this.zba.zbk(((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        zbva zbvaVar = (zbva) list;
        if (!z) {
            while (i2 < zbvaVar.size()) {
                this.zba.zbj(i, zbvaVar.zbe(i2));
                i2++;
            }
            return;
        }
        this.zba.zbu(i, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < zbvaVar.size(); i6++) {
            zbvaVar.zbe(i6);
            i5 += 8;
        }
        this.zba.zbw(i5);
        while (i2 < zbvaVar.size()) {
            this.zba.zbk(zbvaVar.zbe(i2));
            i2++;
        }
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbwy
    public final void zbc(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zbss)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zba.zbd(i, ((Boolean) list.get(i2)).booleanValue());
                    i2++;
                }
                return;
            }
            this.zba.zbu(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                ((Boolean) list.get(i4)).booleanValue();
                i3++;
            }
            this.zba.zbw(i3);
            while (i2 < list.size()) {
                this.zba.zbb(((Boolean) list.get(i2)).booleanValue() ? (byte) 1 : (byte) 0);
                i2++;
            }
            return;
        }
        zbss zbssVar = (zbss) list;
        if (!z) {
            while (i2 < zbssVar.size()) {
                this.zba.zbd(i, zbssVar.zbf(i2));
                i2++;
            }
            return;
        }
        this.zba.zbu(i, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < zbssVar.size(); i6++) {
            zbssVar.zbf(i6);
            i5++;
        }
        this.zba.zbw(i5);
        while (i2 < zbssVar.size()) {
            this.zba.zbb(zbssVar.zbf(i2) ? (byte) 1 : (byte) 0);
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbwy
    public final void zbs(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zbug)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zba.zbl(i, ((Integer) list.get(i2)).intValue());
                    i2++;
                }
                return;
            }
            this.zba.zbu(i, 2);
            int iZbE = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                iZbE += zbtk.zbE(((Integer) list.get(i3)).intValue());
            }
            this.zba.zbw(iZbE);
            while (i2 < list.size()) {
                this.zba.zbm(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        zbug zbugVar = (zbug) list;
        if (!z) {
            while (i2 < zbugVar.size()) {
                this.zba.zbl(i, zbugVar.zbe(i2));
                i2++;
            }
            return;
        }
        this.zba.zbu(i, 2);
        int iZbE2 = 0;
        for (int i4 = 0; i4 < zbugVar.size(); i4++) {
            iZbE2 += zbtk.zbE(zbugVar.zbe(i4));
        }
        this.zba.zbw(iZbE2);
        while (i2 < zbugVar.size()) {
            this.zba.zbm(zbugVar.zbe(i2));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbwy
    public final void zbB(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zbva)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zba.zbj(i, ((Long) list.get(i2)).longValue());
                    i2++;
                }
                return;
            }
            this.zba.zbu(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                ((Long) list.get(i4)).longValue();
                i3 += 8;
            }
            this.zba.zbw(i3);
            while (i2 < list.size()) {
                this.zba.zbk(((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        zbva zbvaVar = (zbva) list;
        if (!z) {
            while (i2 < zbvaVar.size()) {
                this.zba.zbj(i, zbvaVar.zbe(i2));
                i2++;
            }
            return;
        }
        this.zba.zbu(i, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < zbvaVar.size(); i6++) {
            zbvaVar.zbe(i6);
            i5 += 8;
        }
        this.zba.zbw(i5);
        while (i2 < zbvaVar.size()) {
            this.zba.zbk(zbvaVar.zbe(i2));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbwy
    public final void zbg(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zbtm)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zba.zbj(i, Double.doubleToRawLongBits(((Double) list.get(i2)).doubleValue()));
                    i2++;
                }
                return;
            }
            this.zba.zbu(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                ((Double) list.get(i4)).doubleValue();
                i3 += 8;
            }
            this.zba.zbw(i3);
            while (i2 < list.size()) {
                this.zba.zbk(Double.doubleToRawLongBits(((Double) list.get(i2)).doubleValue()));
                i2++;
            }
            return;
        }
        zbtm zbtmVar = (zbtm) list;
        if (!z) {
            while (i2 < zbtmVar.size()) {
                this.zba.zbj(i, Double.doubleToRawLongBits(zbtmVar.zbe(i2)));
                i2++;
            }
            return;
        }
        this.zba.zbu(i, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < zbtmVar.size(); i6++) {
            zbtmVar.zbe(i6);
            i5 += 8;
        }
        this.zba.zbw(i5);
        while (i2 < zbtmVar.size()) {
            this.zba.zbk(Double.doubleToRawLongBits(zbtmVar.zbe(i2)));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbwy
    public final void zbp(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zbtw)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zba.zbh(i, Float.floatToRawIntBits(((Float) list.get(i2)).floatValue()));
                    i2++;
                }
                return;
            }
            this.zba.zbu(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                ((Float) list.get(i4)).floatValue();
                i3 += 4;
            }
            this.zba.zbw(i3);
            while (i2 < list.size()) {
                this.zba.zbi(Float.floatToRawIntBits(((Float) list.get(i2)).floatValue()));
                i2++;
            }
            return;
        }
        zbtw zbtwVar = (zbtw) list;
        if (!z) {
            while (i2 < zbtwVar.size()) {
                this.zba.zbh(i, Float.floatToRawIntBits(zbtwVar.zbe(i2)));
                i2++;
            }
            return;
        }
        this.zba.zbu(i, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < zbtwVar.size(); i6++) {
            zbtwVar.zbe(i6);
            i5 += 4;
        }
        this.zba.zbw(i5);
        while (i2 < zbtwVar.size()) {
            this.zba.zbi(Float.floatToRawIntBits(zbtwVar.zbe(i2)));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbwy
    public final void zbz(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zbug)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zba.zbh(i, ((Integer) list.get(i2)).intValue());
                    i2++;
                }
                return;
            }
            this.zba.zbu(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                ((Integer) list.get(i4)).intValue();
                i3 += 4;
            }
            this.zba.zbw(i3);
            while (i2 < list.size()) {
                this.zba.zbi(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        zbug zbugVar = (zbug) list;
        if (!z) {
            while (i2 < zbugVar.size()) {
                this.zba.zbh(i, zbugVar.zbe(i2));
                i2++;
            }
            return;
        }
        this.zba.zbu(i, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < zbugVar.size(); i6++) {
            zbugVar.zbe(i6);
            i5 += 4;
        }
        this.zba.zbw(i5);
        while (i2 < zbugVar.size()) {
            this.zba.zbi(zbugVar.zbe(i2));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbwy
    public final void zbD(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zbug)) {
            if (!z) {
                while (i2 < list.size()) {
                    zbtk zbtkVar = this.zba;
                    int iIntValue = ((Integer) list.get(i2)).intValue();
                    zbtkVar.zbv(i, (iIntValue >> 31) ^ (iIntValue + iIntValue));
                    i2++;
                }
                return;
            }
            this.zba.zbu(i, 2);
            int iZbD = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                int iIntValue2 = ((Integer) list.get(i3)).intValue();
                iZbD += zbtk.zbD((iIntValue2 >> 31) ^ (iIntValue2 + iIntValue2));
            }
            this.zba.zbw(iZbD);
            while (i2 < list.size()) {
                zbtk zbtkVar2 = this.zba;
                int iIntValue3 = ((Integer) list.get(i2)).intValue();
                zbtkVar2.zbw((iIntValue3 >> 31) ^ (iIntValue3 + iIntValue3));
                i2++;
            }
            return;
        }
        zbug zbugVar = (zbug) list;
        if (!z) {
            while (i2 < zbugVar.size()) {
                zbtk zbtkVar3 = this.zba;
                int iZbe = zbugVar.zbe(i2);
                zbtkVar3.zbv(i, (iZbe >> 31) ^ (iZbe + iZbe));
                i2++;
            }
            return;
        }
        this.zba.zbu(i, 2);
        int iZbD2 = 0;
        for (int i4 = 0; i4 < zbugVar.size(); i4++) {
            int iZbe2 = zbugVar.zbe(i4);
            iZbD2 += zbtk.zbD((iZbe2 >> 31) ^ (iZbe2 + iZbe2));
        }
        this.zba.zbw(iZbD2);
        while (i2 < zbugVar.size()) {
            zbtk zbtkVar4 = this.zba;
            int iZbe3 = zbugVar.zbe(i2);
            zbtkVar4.zbw((iZbe3 >> 31) ^ (iZbe3 + iZbe3));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbwy
    public final void zbF(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zbva)) {
            if (!z) {
                while (i2 < list.size()) {
                    zbtk zbtkVar = this.zba;
                    long jLongValue = ((Long) list.get(i2)).longValue();
                    zbtkVar.zbx(i, (jLongValue >> 63) ^ (jLongValue + jLongValue));
                    i2++;
                }
                return;
            }
            this.zba.zbu(i, 2);
            int iZbE = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                long jLongValue2 = ((Long) list.get(i3)).longValue();
                iZbE += zbtk.zbE((jLongValue2 >> 63) ^ (jLongValue2 + jLongValue2));
            }
            this.zba.zbw(iZbE);
            while (i2 < list.size()) {
                zbtk zbtkVar2 = this.zba;
                long jLongValue3 = ((Long) list.get(i2)).longValue();
                zbtkVar2.zby((jLongValue3 >> 63) ^ (jLongValue3 + jLongValue3));
                i2++;
            }
            return;
        }
        zbva zbvaVar = (zbva) list;
        if (!z) {
            while (i2 < zbvaVar.size()) {
                zbtk zbtkVar3 = this.zba;
                long jZbe = zbvaVar.zbe(i2);
                zbtkVar3.zbx(i, (jZbe >> 63) ^ (jZbe + jZbe));
                i2++;
            }
            return;
        }
        this.zba.zbu(i, 2);
        int iZbE2 = 0;
        for (int i4 = 0; i4 < zbvaVar.size(); i4++) {
            long jZbe2 = zbvaVar.zbe(i4);
            iZbE2 += zbtk.zbE((jZbe2 >> 63) ^ (jZbe2 + jZbe2));
        }
        this.zba.zbw(iZbE2);
        while (i2 < zbvaVar.size()) {
            zbtk zbtkVar4 = this.zba;
            long jZbe3 = zbvaVar.zbe(i2);
            zbtkVar4.zby((jZbe3 >> 63) ^ (jZbe3 + jZbe3));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbwy
    public final void zbj(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zbug)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zba.zbl(i, ((Integer) list.get(i2)).intValue());
                    i2++;
                }
                return;
            }
            this.zba.zbu(i, 2);
            int iZbE = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                iZbE += zbtk.zbE(((Integer) list.get(i3)).intValue());
            }
            this.zba.zbw(iZbE);
            while (i2 < list.size()) {
                this.zba.zbm(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        zbug zbugVar = (zbug) list;
        if (!z) {
            while (i2 < zbugVar.size()) {
                this.zba.zbl(i, zbugVar.zbe(i2));
                i2++;
            }
            return;
        }
        this.zba.zbu(i, 2);
        int iZbE2 = 0;
        for (int i4 = 0; i4 < zbugVar.size(); i4++) {
            iZbE2 += zbtk.zbE(zbugVar.zbe(i4));
        }
        this.zba.zbw(iZbE2);
        while (i2 < zbugVar.size()) {
            this.zba.zbm(zbugVar.zbe(i2));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbwy
    public final void zbu(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zbva)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zba.zbx(i, ((Long) list.get(i2)).longValue());
                    i2++;
                }
                return;
            }
            this.zba.zbu(i, 2);
            int iZbE = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                iZbE += zbtk.zbE(((Long) list.get(i3)).longValue());
            }
            this.zba.zbw(iZbE);
            while (i2 < list.size()) {
                this.zba.zby(((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        zbva zbvaVar = (zbva) list;
        if (!z) {
            while (i2 < zbvaVar.size()) {
                this.zba.zbx(i, zbvaVar.zbe(i2));
                i2++;
            }
            return;
        }
        this.zba.zbu(i, 2);
        int iZbE2 = 0;
        for (int i4 = 0; i4 < zbvaVar.size(); i4++) {
            iZbE2 += zbtk.zbE(zbvaVar.zbe(i4));
        }
        this.zba.zbw(iZbE2);
        while (i2 < zbvaVar.size()) {
            this.zba.zby(zbvaVar.zbe(i2));
            i2++;
        }
    }
}
