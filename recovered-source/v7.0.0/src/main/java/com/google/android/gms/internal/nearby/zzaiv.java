package com.google.android.gms.internal.nearby;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzaiv {
    private final zzaiu zza;

    private zzaiv(zzaiu zzaiuVar) {
        this.zza = zzaiuVar;
        zzaiuVar.zza = this;
    }

    public static zzaiv zza(zzaiu zzaiuVar) {
        Object obj = zzaiuVar.zza;
        return obj != null ? (zzaiv) obj : new zzaiv(zzaiuVar);
    }

    public final void zzG(int i, List list) throws IOException {
        for (int i2 = 0; i2 < list.size(); i2++) {
            this.zza.zzj(i, (zzaik) list.get(i2));
        }
    }

    public final void zzM(int i, zzakl zzaklVar, Map map) throws IOException {
        for (Map.Entry entry : map.entrySet()) {
            zzaiu zzaiuVar = this.zza;
            zzaiuVar.zzb(i, 2);
            zzaiuVar.zzr(zzakm.zzc(zzaklVar, entry.getKey(), entry.getValue()));
            zzakm.zzb(zzaiuVar, zzaklVar, entry.getKey(), entry.getValue());
        }
    }

    public final void zzb(int i, int i2) throws IOException {
        this.zza.zze(i, i2);
    }

    public final void zzc(int i, long j) throws IOException {
        this.zza.zzf(i, j);
    }

    public final void zzd(int i, long j) throws IOException {
        this.zza.zzg(i, j);
    }

    public final void zze(int i, float f) throws IOException {
        this.zza.zze(i, Float.floatToRawIntBits(f));
    }

    public final void zzf(int i, double d) throws IOException {
        this.zza.zzg(i, Double.doubleToRawLongBits(d));
    }

    public final void zzg(int i, int i2) throws IOException {
        this.zza.zzc(i, i2);
    }

    public final void zzh(int i, long j) throws IOException {
        this.zza.zzf(i, j);
    }

    public final void zzi(int i, int i2) throws IOException {
        this.zza.zzc(i, i2);
    }

    public final void zzj(int i, long j) throws IOException {
        this.zza.zzg(i, j);
    }

    public final void zzk(int i, int i2) throws IOException {
        this.zza.zze(i, i2);
    }

    public final void zzl(int i, boolean z) throws IOException {
        this.zza.zzh(i, z);
    }

    public final void zzm(int i, String str) throws IOException {
        this.zza.zzi(i, str);
    }

    public final void zzn(int i, zzaik zzaikVar) throws IOException {
        this.zza.zzj(i, zzaikVar);
    }

    public final void zzo(int i, int i2) throws IOException {
        this.zza.zzd(i, i2);
    }

    public final void zzp(int i, int i2) throws IOException {
        zzaiu zzaiuVar = this.zza;
        zzaiuVar.zzd(i, (i2 >> 31) ^ (i2 + i2));
    }

    public final void zzq(int i, long j) throws IOException {
        zzaiu zzaiuVar = this.zza;
        zzaiuVar.zzf(i, (j >> 63) ^ (j + j));
    }

    public final void zzr(int i, Object obj, zzald zzaldVar) throws IOException {
        zzaiu zzaiuVar = this.zza;
        zzahu zzahuVar = (zzahu) obj;
        zzaiuVar.zzb(i, 2);
        zzaiuVar.zzr(zzahuVar.zzx(zzaldVar));
        zzaldVar.zzf(zzahuVar, this);
    }

    public final void zzs(int i, Object obj, zzald zzaldVar) throws IOException {
        zzaiu zzaiuVar = this.zza;
        zzaiuVar.zzb(i, 3);
        zzaldVar.zzf((zzahu) obj, this);
        zzaiuVar.zzb(i, 4);
    }

    @Deprecated
    public final void zzt(int i) throws IOException {
        this.zza.zzb(i, 3);
    }

    @Deprecated
    public final void zzu(int i) throws IOException {
        this.zza.zzb(i, 4);
    }

    public final void zzv(int i, Object obj) throws IOException {
        boolean z = obj instanceof zzaik;
        zzaiu zzaiuVar = this.zza;
        if (z) {
            zzaiuVar.zzn(i, (zzaik) obj);
        } else {
            zzaiuVar.zzm(i, (zzaks) obj);
        }
    }

    public final void zzF(int i, List list) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzakh)) {
            while (i2 < list.size()) {
                this.zza.zzi(i, (String) list.get(i2));
                i2++;
            }
            return;
        }
        zzakh zzakhVar = (zzakh) list;
        while (i2 < list.size()) {
            Object objZzb = zzakhVar.zzb();
            boolean z = objZzb instanceof String;
            zzaiu zzaiuVar = this.zza;
            if (z) {
                zzaiuVar.zzi(i, (String) objZzb);
            } else {
                zzaiuVar.zzj(i, (zzaik) objZzb);
            }
            i2++;
        }
    }

    public final void zzA(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzakk)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zzg(i, ((Long) list.get(i2)).longValue());
                    i2++;
                }
                return;
            }
            zzaiu zzaiuVar = this.zza;
            zzaiuVar.zzb(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                ((Long) list.get(i4)).longValue();
                i3 += 8;
            }
            zzaiuVar.zzr(i3);
            while (i2 < list.size()) {
                zzaiuVar.zzu(((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        zzakk zzakkVar = (zzakk) list;
        if (!z) {
            while (i2 < zzakkVar.size()) {
                this.zza.zzg(i, zzakkVar.zzd(i2));
                i2++;
            }
            return;
        }
        zzaiu zzaiuVar2 = this.zza;
        zzaiuVar2.zzb(i, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < zzakkVar.size(); i6++) {
            zzakkVar.zzd(i6);
            i5 += 8;
        }
        zzaiuVar2.zzr(i5);
        while (i2 < zzakkVar.size()) {
            zzaiuVar2.zzu(zzakkVar.zzd(i2));
            i2++;
        }
    }

    public final void zzx(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzajp)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zze(i, ((Integer) list.get(i2)).intValue());
                    i2++;
                }
                return;
            }
            zzaiu zzaiuVar = this.zza;
            zzaiuVar.zzb(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                ((Integer) list.get(i4)).intValue();
                i3 += 4;
            }
            zzaiuVar.zzr(i3);
            while (i2 < list.size()) {
                zzaiuVar.zzs(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        zzajp zzajpVar = (zzajp) list;
        if (!z) {
            while (i2 < zzajpVar.size()) {
                this.zza.zze(i, zzajpVar.zzf(i2));
                i2++;
            }
            return;
        }
        zzaiu zzaiuVar2 = this.zza;
        zzaiuVar2.zzb(i, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < zzajpVar.size(); i6++) {
            zzajpVar.zzf(i6);
            i5 += 4;
        }
        zzaiuVar2.zzr(i5);
        while (i2 < zzajpVar.size()) {
            zzaiuVar2.zzs(zzajpVar.zzf(i2));
            i2++;
        }
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void zzE(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzaib)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zzh(i, ((Boolean) list.get(i2)).booleanValue());
                    i2++;
                }
                return;
            }
            zzaiu zzaiuVar = this.zza;
            zzaiuVar.zzb(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                ((Boolean) list.get(i4)).booleanValue();
                i3++;
            }
            zzaiuVar.zzr(i3);
            while (i2 < list.size()) {
                zzaiuVar.zzp(((Boolean) list.get(i2)).booleanValue() ? (byte) 1 : (byte) 0);
                i2++;
            }
            return;
        }
        zzaib zzaibVar = (zzaib) list;
        if (!z) {
            while (i2 < zzaibVar.size()) {
                this.zza.zzh(i, zzaibVar.zze(i2));
                i2++;
            }
            return;
        }
        zzaiu zzaiuVar2 = this.zza;
        zzaiuVar2.zzb(i, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < zzaibVar.size(); i6++) {
            zzaibVar.zze(i6);
            i5++;
        }
        zzaiuVar2.zzr(i5);
        while (i2 < zzaibVar.size()) {
            zzaiuVar2.zzp(zzaibVar.zze(i2) ? (byte) 1 : (byte) 0);
            i2++;
        }
    }

    public final void zzH(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzajp)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zzd(i, ((Integer) list.get(i2)).intValue());
                    i2++;
                }
                return;
            }
            zzaiu zzaiuVar = this.zza;
            zzaiuVar.zzb(i, 2);
            int iNumberOfLeadingZeros = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                iNumberOfLeadingZeros += (352 - (Integer.numberOfLeadingZeros(((Integer) list.get(i3)).intValue()) * 9)) >>> 6;
            }
            zzaiuVar.zzr(iNumberOfLeadingZeros);
            while (i2 < list.size()) {
                zzaiuVar.zzr(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        zzajp zzajpVar = (zzajp) list;
        if (!z) {
            while (i2 < zzajpVar.size()) {
                this.zza.zzd(i, zzajpVar.zzf(i2));
                i2++;
            }
            return;
        }
        zzaiu zzaiuVar2 = this.zza;
        zzaiuVar2.zzb(i, 2);
        int iNumberOfLeadingZeros2 = 0;
        for (int i4 = 0; i4 < zzajpVar.size(); i4++) {
            iNumberOfLeadingZeros2 += (352 - (Integer.numberOfLeadingZeros(zzajpVar.zzf(i4)) * 9)) >>> 6;
        }
        zzaiuVar2.zzr(iNumberOfLeadingZeros2);
        while (i2 < zzajpVar.size()) {
            zzaiuVar2.zzr(zzajpVar.zzf(i2));
            i2++;
        }
    }

    public final void zzw(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzajp)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zzc(i, ((Integer) list.get(i2)).intValue());
                    i2++;
                }
                return;
            }
            zzaiu zzaiuVar = this.zza;
            zzaiuVar.zzb(i, 2);
            int iNumberOfLeadingZeros = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                iNumberOfLeadingZeros += (640 - (Long.numberOfLeadingZeros(((Integer) list.get(i3)).intValue()) * 9)) >>> 6;
            }
            zzaiuVar.zzr(iNumberOfLeadingZeros);
            while (i2 < list.size()) {
                zzaiuVar.zzq(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        zzajp zzajpVar = (zzajp) list;
        if (!z) {
            while (i2 < zzajpVar.size()) {
                this.zza.zzc(i, zzajpVar.zzf(i2));
                i2++;
            }
            return;
        }
        zzaiu zzaiuVar2 = this.zza;
        zzaiuVar2.zzb(i, 2);
        int iNumberOfLeadingZeros2 = 0;
        for (int i4 = 0; i4 < zzajpVar.size(); i4++) {
            iNumberOfLeadingZeros2 += (640 - (Long.numberOfLeadingZeros(zzajpVar.zzf(i4)) * 9)) >>> 6;
        }
        zzaiuVar2.zzr(iNumberOfLeadingZeros2);
        while (i2 < zzajpVar.size()) {
            zzaiuVar2.zzq(zzajpVar.zzf(i2));
            i2++;
        }
    }

    public final void zzz(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzakk)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zzf(i, ((Long) list.get(i2)).longValue());
                    i2++;
                }
                return;
            }
            zzaiu zzaiuVar = this.zza;
            zzaiuVar.zzb(i, 2);
            int iNumberOfLeadingZeros = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                iNumberOfLeadingZeros += (640 - (Long.numberOfLeadingZeros(((Long) list.get(i3)).longValue()) * 9)) >>> 6;
            }
            zzaiuVar.zzr(iNumberOfLeadingZeros);
            while (i2 < list.size()) {
                zzaiuVar.zzt(((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        zzakk zzakkVar = (zzakk) list;
        if (!z) {
            while (i2 < zzakkVar.size()) {
                this.zza.zzf(i, zzakkVar.zzd(i2));
                i2++;
            }
            return;
        }
        zzaiu zzaiuVar2 = this.zza;
        zzaiuVar2.zzb(i, 2);
        int iNumberOfLeadingZeros2 = 0;
        for (int i4 = 0; i4 < zzakkVar.size(); i4++) {
            iNumberOfLeadingZeros2 += (640 - (Long.numberOfLeadingZeros(zzakkVar.zzd(i4)) * 9)) >>> 6;
        }
        zzaiuVar2.zzr(iNumberOfLeadingZeros2);
        while (i2 < zzakkVar.size()) {
            zzaiuVar2.zzt(zzakkVar.zzd(i2));
            i2++;
        }
    }

    public final void zzB(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzajg)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zze(i, Float.floatToRawIntBits(((Float) list.get(i2)).floatValue()));
                    i2++;
                }
                return;
            }
            zzaiu zzaiuVar = this.zza;
            zzaiuVar.zzb(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                ((Float) list.get(i4)).floatValue();
                i3 += 4;
            }
            zzaiuVar.zzr(i3);
            while (i2 < list.size()) {
                zzaiuVar.zzs(Float.floatToRawIntBits(((Float) list.get(i2)).floatValue()));
                i2++;
            }
            return;
        }
        zzajg zzajgVar = (zzajg) list;
        if (!z) {
            while (i2 < zzajgVar.size()) {
                this.zza.zze(i, Float.floatToRawIntBits(zzajgVar.zze(i2)));
                i2++;
            }
            return;
        }
        zzaiu zzaiuVar2 = this.zza;
        zzaiuVar2.zzb(i, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < zzajgVar.size(); i6++) {
            zzajgVar.zze(i6);
            i5 += 4;
        }
        zzaiuVar2.zzr(i5);
        while (i2 < zzajgVar.size()) {
            zzaiuVar2.zzs(Float.floatToRawIntBits(zzajgVar.zze(i2)));
            i2++;
        }
    }

    public final void zzC(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzaiw)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zzg(i, Double.doubleToRawLongBits(((Double) list.get(i2)).doubleValue()));
                    i2++;
                }
                return;
            }
            zzaiu zzaiuVar = this.zza;
            zzaiuVar.zzb(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                ((Double) list.get(i4)).doubleValue();
                i3 += 8;
            }
            zzaiuVar.zzr(i3);
            while (i2 < list.size()) {
                zzaiuVar.zzu(Double.doubleToRawLongBits(((Double) list.get(i2)).doubleValue()));
                i2++;
            }
            return;
        }
        zzaiw zzaiwVar = (zzaiw) list;
        if (!z) {
            while (i2 < zzaiwVar.size()) {
                this.zza.zzg(i, Double.doubleToRawLongBits(zzaiwVar.zze(i2)));
                i2++;
            }
            return;
        }
        zzaiu zzaiuVar2 = this.zza;
        zzaiuVar2.zzb(i, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < zzaiwVar.size(); i6++) {
            zzaiwVar.zze(i6);
            i5 += 8;
        }
        zzaiuVar2.zzr(i5);
        while (i2 < zzaiwVar.size()) {
            zzaiuVar2.zzu(Double.doubleToRawLongBits(zzaiwVar.zze(i2)));
            i2++;
        }
    }

    public final void zzI(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzajp)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zze(i, ((Integer) list.get(i2)).intValue());
                    i2++;
                }
                return;
            }
            zzaiu zzaiuVar = this.zza;
            zzaiuVar.zzb(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                ((Integer) list.get(i4)).intValue();
                i3 += 4;
            }
            zzaiuVar.zzr(i3);
            while (i2 < list.size()) {
                zzaiuVar.zzs(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        zzajp zzajpVar = (zzajp) list;
        if (!z) {
            while (i2 < zzajpVar.size()) {
                this.zza.zze(i, zzajpVar.zzf(i2));
                i2++;
            }
            return;
        }
        zzaiu zzaiuVar2 = this.zza;
        zzaiuVar2.zzb(i, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < zzajpVar.size(); i6++) {
            zzajpVar.zzf(i6);
            i5 += 4;
        }
        zzaiuVar2.zzr(i5);
        while (i2 < zzajpVar.size()) {
            zzaiuVar2.zzs(zzajpVar.zzf(i2));
            i2++;
        }
    }

    public final void zzJ(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzakk)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zzg(i, ((Long) list.get(i2)).longValue());
                    i2++;
                }
                return;
            }
            zzaiu zzaiuVar = this.zza;
            zzaiuVar.zzb(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                ((Long) list.get(i4)).longValue();
                i3 += 8;
            }
            zzaiuVar.zzr(i3);
            while (i2 < list.size()) {
                zzaiuVar.zzu(((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        zzakk zzakkVar = (zzakk) list;
        if (!z) {
            while (i2 < zzakkVar.size()) {
                this.zza.zzg(i, zzakkVar.zzd(i2));
                i2++;
            }
            return;
        }
        zzaiu zzaiuVar2 = this.zza;
        zzaiuVar2.zzb(i, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < zzakkVar.size(); i6++) {
            zzakkVar.zzd(i6);
            i5 += 8;
        }
        zzaiuVar2.zzr(i5);
        while (i2 < zzakkVar.size()) {
            zzaiuVar2.zzu(zzakkVar.zzd(i2));
            i2++;
        }
    }

    public final void zzD(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzajp)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zzc(i, ((Integer) list.get(i2)).intValue());
                    i2++;
                }
                return;
            }
            zzaiu zzaiuVar = this.zza;
            zzaiuVar.zzb(i, 2);
            int iNumberOfLeadingZeros = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                iNumberOfLeadingZeros += (640 - (Long.numberOfLeadingZeros(((Integer) list.get(i3)).intValue()) * 9)) >>> 6;
            }
            zzaiuVar.zzr(iNumberOfLeadingZeros);
            while (i2 < list.size()) {
                zzaiuVar.zzq(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        zzajp zzajpVar = (zzajp) list;
        if (!z) {
            while (i2 < zzajpVar.size()) {
                this.zza.zzc(i, zzajpVar.zzf(i2));
                i2++;
            }
            return;
        }
        zzaiu zzaiuVar2 = this.zza;
        zzaiuVar2.zzb(i, 2);
        int iNumberOfLeadingZeros2 = 0;
        for (int i4 = 0; i4 < zzajpVar.size(); i4++) {
            iNumberOfLeadingZeros2 += (640 - (Long.numberOfLeadingZeros(zzajpVar.zzf(i4)) * 9)) >>> 6;
        }
        zzaiuVar2.zzr(iNumberOfLeadingZeros2);
        while (i2 < zzajpVar.size()) {
            zzaiuVar2.zzq(zzajpVar.zzf(i2));
            i2++;
        }
    }

    public final void zzK(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzajp)) {
            if (!z) {
                while (i2 < list.size()) {
                    zzaiu zzaiuVar = this.zza;
                    int iIntValue = ((Integer) list.get(i2)).intValue();
                    zzaiuVar.zzd(i, (iIntValue >> 31) ^ (iIntValue + iIntValue));
                    i2++;
                }
                return;
            }
            zzaiu zzaiuVar2 = this.zza;
            zzaiuVar2.zzb(i, 2);
            int iNumberOfLeadingZeros = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                int iIntValue2 = ((Integer) list.get(i3)).intValue();
                iNumberOfLeadingZeros += (352 - (Integer.numberOfLeadingZeros((iIntValue2 >> 31) ^ (iIntValue2 + iIntValue2)) * 9)) >>> 6;
            }
            zzaiuVar2.zzr(iNumberOfLeadingZeros);
            while (i2 < list.size()) {
                int iIntValue3 = ((Integer) list.get(i2)).intValue();
                zzaiuVar2.zzr((iIntValue3 >> 31) ^ (iIntValue3 + iIntValue3));
                i2++;
            }
            return;
        }
        zzajp zzajpVar = (zzajp) list;
        if (!z) {
            while (i2 < zzajpVar.size()) {
                zzaiu zzaiuVar3 = this.zza;
                int iZzf = zzajpVar.zzf(i2);
                zzaiuVar3.zzd(i, (iZzf >> 31) ^ (iZzf + iZzf));
                i2++;
            }
            return;
        }
        zzaiu zzaiuVar4 = this.zza;
        zzaiuVar4.zzb(i, 2);
        int iNumberOfLeadingZeros2 = 0;
        for (int i4 = 0; i4 < zzajpVar.size(); i4++) {
            int iZzf2 = zzajpVar.zzf(i4);
            iNumberOfLeadingZeros2 += (352 - (Integer.numberOfLeadingZeros((iZzf2 >> 31) ^ (iZzf2 + iZzf2)) * 9)) >>> 6;
        }
        zzaiuVar4.zzr(iNumberOfLeadingZeros2);
        while (i2 < zzajpVar.size()) {
            int iZzf3 = zzajpVar.zzf(i2);
            zzaiuVar4.zzr((iZzf3 >> 31) ^ (iZzf3 + iZzf3));
            i2++;
        }
    }

    public final void zzL(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzakk)) {
            if (!z) {
                while (i2 < list.size()) {
                    zzaiu zzaiuVar = this.zza;
                    long jLongValue = ((Long) list.get(i2)).longValue();
                    zzaiuVar.zzf(i, (jLongValue >> 63) ^ (jLongValue + jLongValue));
                    i2++;
                }
                return;
            }
            zzaiu zzaiuVar2 = this.zza;
            zzaiuVar2.zzb(i, 2);
            int iNumberOfLeadingZeros = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                long jLongValue2 = ((Long) list.get(i3)).longValue();
                iNumberOfLeadingZeros += (640 - (Long.numberOfLeadingZeros((jLongValue2 >> 63) ^ (jLongValue2 + jLongValue2)) * 9)) >>> 6;
            }
            zzaiuVar2.zzr(iNumberOfLeadingZeros);
            while (i2 < list.size()) {
                long jLongValue3 = ((Long) list.get(i2)).longValue();
                zzaiuVar2.zzt((jLongValue3 >> 63) ^ (jLongValue3 + jLongValue3));
                i2++;
            }
            return;
        }
        zzakk zzakkVar = (zzakk) list;
        if (!z) {
            while (i2 < zzakkVar.size()) {
                zzaiu zzaiuVar3 = this.zza;
                long jZzd = zzakkVar.zzd(i2);
                zzaiuVar3.zzf(i, (jZzd >> 63) ^ (jZzd + jZzd));
                i2++;
            }
            return;
        }
        zzaiu zzaiuVar4 = this.zza;
        zzaiuVar4.zzb(i, 2);
        int iNumberOfLeadingZeros2 = 0;
        for (int i4 = 0; i4 < zzakkVar.size(); i4++) {
            long jZzd2 = zzakkVar.zzd(i4);
            iNumberOfLeadingZeros2 += (640 - (Long.numberOfLeadingZeros((jZzd2 >> 63) ^ (jZzd2 + jZzd2)) * 9)) >>> 6;
        }
        zzaiuVar4.zzr(iNumberOfLeadingZeros2);
        while (i2 < zzakkVar.size()) {
            long jZzd3 = zzakkVar.zzd(i2);
            zzaiuVar4.zzt((jZzd3 >> 63) ^ (jZzd3 + jZzd3));
            i2++;
        }
    }

    public final void zzy(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!(list instanceof zzakk)) {
            if (!z) {
                while (i2 < list.size()) {
                    this.zza.zzf(i, ((Long) list.get(i2)).longValue());
                    i2++;
                }
                return;
            }
            zzaiu zzaiuVar = this.zza;
            zzaiuVar.zzb(i, 2);
            int iNumberOfLeadingZeros = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                iNumberOfLeadingZeros += (640 - (Long.numberOfLeadingZeros(((Long) list.get(i3)).longValue()) * 9)) >>> 6;
            }
            zzaiuVar.zzr(iNumberOfLeadingZeros);
            while (i2 < list.size()) {
                zzaiuVar.zzt(((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        zzakk zzakkVar = (zzakk) list;
        if (!z) {
            while (i2 < zzakkVar.size()) {
                this.zza.zzf(i, zzakkVar.zzd(i2));
                i2++;
            }
            return;
        }
        zzaiu zzaiuVar2 = this.zza;
        zzaiuVar2.zzb(i, 2);
        int iNumberOfLeadingZeros2 = 0;
        for (int i4 = 0; i4 < zzakkVar.size(); i4++) {
            iNumberOfLeadingZeros2 += (640 - (Long.numberOfLeadingZeros(zzakkVar.zzd(i4)) * 9)) >>> 6;
        }
        zzaiuVar2.zzr(iNumberOfLeadingZeros2);
        while (i2 < zzakkVar.size()) {
            zzaiuVar2.zzt(zzakkVar.zzd(i2));
            i2++;
        }
    }
}
