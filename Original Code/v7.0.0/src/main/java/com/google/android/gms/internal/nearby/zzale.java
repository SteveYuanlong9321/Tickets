package com.google.android.gms.internal.nearby;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzale {
    public static final /* synthetic */ int zza = 0;
    private static final zzalm zzb = new zzalo();

    static void zzA(zzaja zzajaVar, Object obj, Object obj2) {
        if (((zzajl) obj2).zzb.zza.isEmpty()) {
            return;
        }
        throw null;
    }

    static void zzB(zzalm zzalmVar, Object obj, Object obj2) {
        zzajo zzajoVar = (zzajo) obj;
        zzaln zzalnVarZzc = zzajoVar.zzc;
        zzaln zzalnVar = ((zzajo) obj2).zzc;
        if (!zzaln.zza().equals(zzalnVar)) {
            if (zzaln.zza().equals(zzalnVarZzc)) {
                zzalnVarZzc = zzaln.zzc(zzalnVarZzc, zzalnVar);
            } else {
                zzalnVarZzc.zzl(zzalnVar);
            }
        }
        zzajoVar.zzc = zzalnVarZzc;
    }

    static Object zzC(Object obj, int i, List list, zzajt zzajtVar, Object obj2, zzalm zzalmVar) {
        if (zzajtVar == null) {
            return obj2;
        }
        if (!(list instanceof RandomAccess)) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                int iIntValue = ((Integer) it.next()).intValue();
                if (!zzajtVar.zza(iIntValue)) {
                    obj2 = zzD(obj, i, iIntValue, obj2, zzalmVar);
                    it.remove();
                }
            }
            return obj2;
        }
        int size = list.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            Integer num = (Integer) list.get(i3);
            int iIntValue2 = num.intValue();
            if (zzajtVar.zza(iIntValue2)) {
                if (i3 != i2) {
                    list.set(i2, num);
                }
                i2++;
            } else {
                obj2 = zzD(obj, i, iIntValue2, obj2, zzalmVar);
            }
        }
        if (i2 != size) {
            list.subList(i2, size).clear();
        }
        return obj2;
    }

    static Object zzD(Object obj, int i, int i2, Object obj2, zzalm zzalmVar) {
        if (obj2 == null) {
            obj2 = zzalo.zzj(obj);
        }
        zzalo.zzi((zzaln) obj2, i, i2);
        return obj2;
    }

    public static void zza(int i, List list, zzaiv zzaivVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzaivVar.zzC(i, list, z);
    }

    public static void zzb(int i, List list, zzaiv zzaivVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzaivVar.zzB(i, list, z);
    }

    public static void zzc(int i, List list, zzaiv zzaivVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzaivVar.zzy(i, list, z);
    }

    public static void zzd(int i, List list, zzaiv zzaivVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzaivVar.zzz(i, list, z);
    }

    public static void zze(int i, List list, zzaiv zzaivVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzaivVar.zzL(i, list, z);
    }

    public static void zzf(int i, List list, zzaiv zzaivVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzaivVar.zzA(i, list, z);
    }

    public static void zzg(int i, List list, zzaiv zzaivVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzaivVar.zzJ(i, list, z);
    }

    public static void zzh(int i, List list, zzaiv zzaivVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzaivVar.zzw(i, list, z);
    }

    public static void zzi(int i, List list, zzaiv zzaivVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzaivVar.zzH(i, list, z);
    }

    public static void zzj(int i, List list, zzaiv zzaivVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzaivVar.zzK(i, list, z);
    }

    public static void zzk(int i, List list, zzaiv zzaivVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzaivVar.zzx(i, list, z);
    }

    public static void zzl(int i, List list, zzaiv zzaivVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzaivVar.zzI(i, list, z);
    }

    public static void zzm(int i, List list, zzaiv zzaivVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzaivVar.zzD(i, list, z);
    }

    public static void zzn(int i, List list, zzaiv zzaivVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzaivVar.zzE(i, list, z);
    }

    static int zzo(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzakk)) {
            int iNumberOfLeadingZeros = 0;
            while (i < size) {
                iNumberOfLeadingZeros += (640 - (Long.numberOfLeadingZeros(((Long) list.get(i)).longValue()) * 9)) >>> 6;
                i++;
            }
            return iNumberOfLeadingZeros;
        }
        zzakk zzakkVar = (zzakk) list;
        int iNumberOfLeadingZeros2 = 0;
        while (i < size) {
            iNumberOfLeadingZeros2 += (640 - (Long.numberOfLeadingZeros(zzakkVar.zzd(i)) * 9)) >>> 6;
            i++;
        }
        return iNumberOfLeadingZeros2;
    }

    static int zzp(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzakk)) {
            int iNumberOfLeadingZeros = 0;
            while (i < size) {
                iNumberOfLeadingZeros += (640 - (Long.numberOfLeadingZeros(((Long) list.get(i)).longValue()) * 9)) >>> 6;
                i++;
            }
            return iNumberOfLeadingZeros;
        }
        zzakk zzakkVar = (zzakk) list;
        int iNumberOfLeadingZeros2 = 0;
        while (i < size) {
            iNumberOfLeadingZeros2 += (640 - (Long.numberOfLeadingZeros(zzakkVar.zzd(i)) * 9)) >>> 6;
            i++;
        }
        return iNumberOfLeadingZeros2;
    }

    static int zzq(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzakk)) {
            int iNumberOfLeadingZeros = 0;
            while (i < size) {
                long jLongValue = ((Long) list.get(i)).longValue();
                iNumberOfLeadingZeros += (640 - (Long.numberOfLeadingZeros((jLongValue >> 63) ^ (jLongValue + jLongValue)) * 9)) >>> 6;
                i++;
            }
            return iNumberOfLeadingZeros;
        }
        zzakk zzakkVar = (zzakk) list;
        int iNumberOfLeadingZeros2 = 0;
        while (i < size) {
            long jZzd = zzakkVar.zzd(i);
            iNumberOfLeadingZeros2 += (640 - (Long.numberOfLeadingZeros((jZzd >> 63) ^ (jZzd + jZzd)) * 9)) >>> 6;
            i++;
        }
        return iNumberOfLeadingZeros2;
    }

    static int zzr(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzajp)) {
            int iNumberOfLeadingZeros = 0;
            while (i < size) {
                iNumberOfLeadingZeros += (640 - (Long.numberOfLeadingZeros(((Integer) list.get(i)).intValue()) * 9)) >>> 6;
                i++;
            }
            return iNumberOfLeadingZeros;
        }
        zzajp zzajpVar = (zzajp) list;
        int iNumberOfLeadingZeros2 = 0;
        while (i < size) {
            iNumberOfLeadingZeros2 += (640 - (Long.numberOfLeadingZeros(zzajpVar.zzf(i)) * 9)) >>> 6;
            i++;
        }
        return iNumberOfLeadingZeros2;
    }

    static int zzs(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzajp)) {
            int iNumberOfLeadingZeros = 0;
            while (i < size) {
                iNumberOfLeadingZeros += (640 - (Long.numberOfLeadingZeros(((Integer) list.get(i)).intValue()) * 9)) >>> 6;
                i++;
            }
            return iNumberOfLeadingZeros;
        }
        zzajp zzajpVar = (zzajp) list;
        int iNumberOfLeadingZeros2 = 0;
        while (i < size) {
            iNumberOfLeadingZeros2 += (640 - (Long.numberOfLeadingZeros(zzajpVar.zzf(i)) * 9)) >>> 6;
            i++;
        }
        return iNumberOfLeadingZeros2;
    }

    static int zzt(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzajp)) {
            int iNumberOfLeadingZeros = 0;
            while (i < size) {
                iNumberOfLeadingZeros += (352 - (Integer.numberOfLeadingZeros(((Integer) list.get(i)).intValue()) * 9)) >>> 6;
                i++;
            }
            return iNumberOfLeadingZeros;
        }
        zzajp zzajpVar = (zzajp) list;
        int iNumberOfLeadingZeros2 = 0;
        while (i < size) {
            iNumberOfLeadingZeros2 += (352 - (Integer.numberOfLeadingZeros(zzajpVar.zzf(i)) * 9)) >>> 6;
            i++;
        }
        return iNumberOfLeadingZeros2;
    }

    static int zzu(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzajp)) {
            int iNumberOfLeadingZeros = 0;
            while (i < size) {
                int iIntValue = ((Integer) list.get(i)).intValue();
                iNumberOfLeadingZeros += (352 - (Integer.numberOfLeadingZeros((iIntValue >> 31) ^ (iIntValue + iIntValue)) * 9)) >>> 6;
                i++;
            }
            return iNumberOfLeadingZeros;
        }
        zzajp zzajpVar = (zzajp) list;
        int iNumberOfLeadingZeros2 = 0;
        while (i < size) {
            int iZzf = zzajpVar.zzf(i);
            iNumberOfLeadingZeros2 += (352 - (Integer.numberOfLeadingZeros((iZzf >> 31) ^ (iZzf + iZzf)) * 9)) >>> 6;
            i++;
        }
        return iNumberOfLeadingZeros2;
    }

    static int zzv(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (((352 - (Integer.numberOfLeadingZeros(i << 3) * 9)) >>> 6) + 4);
    }

    static int zzw(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (((352 - (Integer.numberOfLeadingZeros(i << 3) * 9)) >>> 6) + 8);
    }

    @Deprecated
    static int zzx(int i, zzaks zzaksVar, zzald zzaldVar) {
        int iNumberOfLeadingZeros = (352 - (Integer.numberOfLeadingZeros(i << 3) * 9)) >>> 6;
        return iNumberOfLeadingZeros + iNumberOfLeadingZeros + ((zzahu) zzaksVar).zzx(zzaldVar);
    }

    public static zzalm zzy() {
        return zzb;
    }

    static boolean zzz(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }
}
