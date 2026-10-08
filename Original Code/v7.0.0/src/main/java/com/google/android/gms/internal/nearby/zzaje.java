package com.google.android.gms.internal.nearby;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzaje {
    private static final zzaje zzd = new zzaje(true);
    final zzali zza = new zzali();
    boolean zzb;
    boolean zzc;

    private zzaje() {
    }

    public static zzaje zza() {
        return zzd;
    }

    static void zze(zzaiu zzaiuVar, zzalz zzalzVar, int i, Object obj) throws IOException {
        if (zzalzVar == zzalz.GROUP) {
            zzaiuVar.zzb(i, 3);
            ((zzaks) obj).zzbd(zzaiuVar);
            zzaiuVar.zzb(i, 4);
            return;
        }
        zzaiuVar.zzb(i, zzalzVar.zzb());
        zzama zzamaVar = zzama.INT;
        switch (zzalzVar) {
            case DOUBLE:
                zzaiuVar.zzu(Double.doubleToRawLongBits(((Double) obj).doubleValue()));
                break;
            case FLOAT:
                zzaiuVar.zzs(Float.floatToRawIntBits(((Float) obj).floatValue()));
                break;
            case INT64:
                zzaiuVar.zzt(((Long) obj).longValue());
                break;
            case UINT64:
                zzaiuVar.zzt(((Long) obj).longValue());
                break;
            case INT32:
                zzaiuVar.zzq(((Integer) obj).intValue());
                break;
            case FIXED64:
                zzaiuVar.zzu(((Long) obj).longValue());
                break;
            case FIXED32:
                zzaiuVar.zzs(((Integer) obj).intValue());
                break;
            case BOOL:
                zzaiuVar.zzp(((Boolean) obj).booleanValue() ? (byte) 1 : (byte) 0);
                break;
            case STRING:
                if (!(obj instanceof zzaik)) {
                    zzaiuVar.zzw((String) obj);
                } else {
                    zzaiuVar.zzk((zzaik) obj);
                }
                break;
            case GROUP:
                ((zzaks) obj).zzbd(zzaiuVar);
                break;
            case MESSAGE:
                zzaiuVar.zzo((zzaks) obj);
                break;
            case BYTES:
                if (!(obj instanceof zzaik)) {
                    byte[] bArr = (byte[]) obj;
                    zzaiuVar.zzl(bArr, 0, bArr.length);
                } else {
                    zzaiuVar.zzk((zzaik) obj);
                }
                break;
            case UINT32:
                zzaiuVar.zzr(((Integer) obj).intValue());
                break;
            case ENUM:
                if (!(obj instanceof zzajs)) {
                    zzaiuVar.zzq(((Integer) obj).intValue());
                } else {
                    zzaiuVar.zzq(((zzajs) obj).zza());
                }
                break;
            case SFIXED32:
                zzaiuVar.zzs(((Integer) obj).intValue());
                break;
            case SFIXED64:
                zzaiuVar.zzu(((Long) obj).longValue());
                break;
            case SINT32:
                int iIntValue = ((Integer) obj).intValue();
                zzaiuVar.zzr((iIntValue >> 31) ^ (iIntValue + iIntValue));
                break;
            case SINT64:
                long jLongValue = ((Long) obj).longValue();
                zzaiuVar.zzt((jLongValue >> 63) ^ (jLongValue + jLongValue));
                break;
        }
    }

    static int zzf(zzalz zzalzVar, int i, Object obj) {
        int iNumberOfLeadingZeros = (352 - (Integer.numberOfLeadingZeros(i << 3) * 9)) >>> 6;
        if (zzalzVar == zzalz.GROUP) {
            iNumberOfLeadingZeros += iNumberOfLeadingZeros;
        }
        return iNumberOfLeadingZeros + zzg(zzalzVar, obj);
    }

    static int zzg(zzalz zzalzVar, Object obj) {
        int iZzb;
        int iNumberOfLeadingZeros;
        zzalz zzalzVar2 = zzalz.DOUBLE;
        zzama zzamaVar = zzama.INT;
        switch (zzalzVar) {
            case DOUBLE:
                ((Double) obj).doubleValue();
                return 8;
            case FLOAT:
                ((Float) obj).floatValue();
                return 4;
            case INT64:
                return (640 - (Long.numberOfLeadingZeros(((Long) obj).longValue()) * 9)) >>> 6;
            case UINT64:
                return (640 - (Long.numberOfLeadingZeros(((Long) obj).longValue()) * 9)) >>> 6;
            case INT32:
                return (640 - (Long.numberOfLeadingZeros(((Integer) obj).intValue()) * 9)) >>> 6;
            case FIXED64:
                ((Long) obj).longValue();
                return 8;
            case FIXED32:
                ((Integer) obj).intValue();
                return 4;
            case BOOL:
                ((Boolean) obj).booleanValue();
                return 1;
            case STRING:
                if (!(obj instanceof zzaik)) {
                    iZzb = zzaly.zzb((String) obj);
                    iNumberOfLeadingZeros = Integer.numberOfLeadingZeros(iZzb);
                } else {
                    iZzb = ((zzaik) obj).zzb();
                    iNumberOfLeadingZeros = Integer.numberOfLeadingZeros(iZzb);
                }
                break;
            case GROUP:
                return ((zzaks) obj).zzJ();
            case MESSAGE:
                if (!(obj instanceof zzakd)) {
                    return zzaiu.zzE((zzaks) obj);
                }
                iZzb = ((zzakd) obj).zzb();
                iNumberOfLeadingZeros = Integer.numberOfLeadingZeros(iZzb);
                break;
                break;
            case BYTES:
                if (!(obj instanceof zzaik)) {
                    iZzb = ((byte[]) obj).length;
                    iNumberOfLeadingZeros = Integer.numberOfLeadingZeros(iZzb);
                } else {
                    iZzb = ((zzaik) obj).zzb();
                    iNumberOfLeadingZeros = Integer.numberOfLeadingZeros(iZzb);
                }
                break;
            case UINT32:
                return (352 - (Integer.numberOfLeadingZeros(((Integer) obj).intValue()) * 9)) >>> 6;
            case ENUM:
                return obj instanceof zzajs ? (640 - (Long.numberOfLeadingZeros(((zzajs) obj).zza()) * 9)) >>> 6 : (640 - (Long.numberOfLeadingZeros(((Integer) obj).intValue()) * 9)) >>> 6;
            case SFIXED32:
                ((Integer) obj).intValue();
                return 4;
            case SFIXED64:
                ((Long) obj).longValue();
                return 8;
            case SINT32:
                int iIntValue = ((Integer) obj).intValue();
                return (352 - (Integer.numberOfLeadingZeros((iIntValue >> 31) ^ (iIntValue + iIntValue)) * 9)) >>> 6;
            case SINT64:
                long jLongValue = ((Long) obj).longValue();
                return (640 - (Long.numberOfLeadingZeros((jLongValue >> 63) ^ (jLongValue + jLongValue)) * 9)) >>> 6;
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
        return ((352 - (iNumberOfLeadingZeros * 9)) >>> 6) + iZzb;
    }

    public static int zzh(zzajd zzajdVar, Object obj) {
        zzalz zzalzVarZzb = zzajdVar.zzb();
        int iZza = zzajdVar.zza();
        if (!zzajdVar.zzd()) {
            return zzf(zzalzVarZzb, iZza, obj);
        }
        List list = (List) obj;
        int size = list.size();
        int i = 0;
        if (!zzajdVar.zze()) {
            int iZzf = 0;
            while (i < size) {
                iZzf += zzf(zzalzVarZzb, iZza, list.get(i));
                i++;
            }
            return iZzf;
        }
        if (list.isEmpty()) {
            return 0;
        }
        int iZzg = 0;
        while (i < size) {
            iZzg += zzg(zzalzVarZzb, list.get(i));
            i++;
        }
        return ((352 - (Integer.numberOfLeadingZeros(iZza << 3) * 9)) >>> 6) + iZzg + ((352 - (Integer.numberOfLeadingZeros(iZzg) * 9)) >>> 6);
    }

    private static boolean zzi(Object obj) {
        if (obj instanceof zzakt) {
            return ((zzakt) obj).zzbf();
        }
        if (obj instanceof zzakd) {
            return true;
        }
        throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:32:? A[RETURN, SYNTHETIC] */
    private static final void zzj(zzajd zzajdVar, Object obj) {
        boolean z;
        zzajdVar.zzb();
        obj.getClass();
        zzalz zzalzVar = zzalz.DOUBLE;
        zzama zzamaVar = zzama.INT;
        switch (r0.zza()) {
            case INT:
                z = obj instanceof Integer;
                if (z) {
                    return;
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzajdVar.zza()), zzajdVar.zzb().zza(), obj.getClass().getName()));
            case LONG:
                z = obj instanceof Long;
                if (z) {
                    return;
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzajdVar.zza()), zzajdVar.zzb().zza(), obj.getClass().getName()));
            case FLOAT:
                z = obj instanceof Float;
                if (z) {
                    return;
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzajdVar.zza()), zzajdVar.zzb().zza(), obj.getClass().getName()));
            case DOUBLE:
                z = obj instanceof Double;
                if (z) {
                    return;
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzajdVar.zza()), zzajdVar.zzb().zza(), obj.getClass().getName()));
            case BOOLEAN:
                z = obj instanceof Boolean;
                if (z) {
                    return;
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzajdVar.zza()), zzajdVar.zzb().zza(), obj.getClass().getName()));
            case STRING:
                z = obj instanceof String;
                if (z) {
                    return;
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzajdVar.zza()), zzajdVar.zzb().zza(), obj.getClass().getName()));
            case BYTE_STRING:
                if ((obj instanceof zzaik) || (obj instanceof byte[])) {
                    return;
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzajdVar.zza()), zzajdVar.zzb().zza(), obj.getClass().getName()));
            case ENUM:
                if ((obj instanceof Integer) || (obj instanceof zzajs)) {
                    return;
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzajdVar.zza()), zzajdVar.zzb().zza(), obj.getClass().getName()));
            case MESSAGE:
                if ((obj instanceof zzaks) || (obj instanceof zzakd)) {
                    return;
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzajdVar.zza()), zzajdVar.zzb().zza(), obj.getClass().getName()));
            default:
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzajdVar.zza()), zzajdVar.zzb().zza(), obj.getClass().getName()));
        }
    }

    public final /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException {
        zzaje zzajeVar = new zzaje();
        zzali zzaliVar = this.zza;
        int size = zzaliVar.size();
        for (int i = 0; i < size; i++) {
            Map.Entry entryZzb = zzaliVar.zzb(i);
            zzajd zzajdVarZza = ((zzalf) entryZzb).zza();
            Object value = entryZzb.getValue();
            if (!zzajdVarZza.zzd()) {
                zzj(zzajdVarZza, value);
            } else {
                if (!(value instanceof List)) {
                    throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
                }
                List list = (List) value;
                int size2 = list.size();
                ArrayList arrayList = new ArrayList(size2);
                for (int i2 = 0; i2 < size2; i2++) {
                    Object obj = list.get(i2);
                    zzj(zzajdVarZza, obj);
                    arrayList.add(obj);
                }
                value = arrayList;
            }
            if (value instanceof zzakd) {
                zzajeVar.zzc = true;
            }
            zzajeVar.zza.zzc(zzajdVarZza, value);
        }
        zzajeVar.zzc = this.zzc;
        return zzajeVar;
    }

    public final boolean equals(Object obj) {
        boolean zEquals;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzaje)) {
            return false;
        }
        zzali zzaliVar = this.zza;
        zzali zzaliVar2 = ((zzaje) obj).zza;
        if (zzaliVar.size() != zzaliVar2.size() || !zzaliVar.keySet().equals(zzaliVar2.keySet())) {
            return false;
        }
        for (Map.Entry entry : zzaliVar.entrySet()) {
            Object key = entry.getKey();
            Object value = entry.getValue();
            Object obj2 = zzaliVar2.get(key);
            if (value == obj2) {
                zEquals = true;
            } else if (value == null || obj2 == null) {
                zEquals = false;
            } else if (value instanceof zzakd) {
                zEquals = value.equals(obj2);
            } else {
                zEquals = obj2 instanceof zzakd ? obj2.equals(value) : value.equals(obj2);
            }
            if (!zEquals) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final void zzb() {
        if (this.zzb) {
            return;
        }
        zzali zzaliVar = this.zza;
        int size = zzaliVar.size();
        for (int i = 0; i < size; i++) {
            Object value = zzaliVar.zzb(i).getValue();
            if (value instanceof zzajo) {
                ((zzajo) value).zzF();
            }
        }
        zzaliVar.zza();
        this.zzb = true;
    }

    public final Iterator zzc() {
        zzali zzaliVar = this.zza;
        if (zzaliVar.isEmpty()) {
            return Collections.emptyIterator();
        }
        return this.zzc ? new zzakc(zzaliVar.entrySet().iterator()) : zzaliVar.entrySet().iterator();
    }

    public final boolean zzd() {
        zzali zzaliVar = this.zza;
        int size = zzaliVar.size();
        for (int i = 0; i < size; i++) {
            Map.Entry entryZzb = zzaliVar.zzb(i);
            zzajd zzajdVarZza = ((zzalf) entryZzb).zza();
            if (zzajdVarZza.zzc() == zzama.MESSAGE) {
                if (zzajdVarZza.zzd()) {
                    List list = (List) entryZzb.getValue();
                    int size2 = list.size();
                    for (int i2 = 0; i2 < size2; i2++) {
                        if (!zzi(list.get(i2))) {
                            return false;
                        }
                    }
                } else if (!zzi(entryZzb.getValue())) {
                    return false;
                }
            }
        }
        return true;
    }

    private zzaje(boolean z) {
        zzb();
        zzb();
    }
}
