package com.google.android.gms.internal.nearby;

import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzali extends AbstractMap {
    private volatile zzalh zzd;
    private boolean zzc = false;
    private Object[] zza = null;
    private int zzb = 0;
    private volatile boolean zze = true;

    zzali() {
    }

    private final void zzh(int i) {
        int length;
        Object[] objArr = this.zza;
        if (objArr == null || (length = objArr.length) == 0) {
            this.zza = new Object[Math.max(16, i)];
            return;
        }
        if (i > length) {
            if (!this.zze) {
                zzd();
                if (i <= this.zza.length) {
                    return;
                }
            }
            Object[] objArr2 = this.zza;
            int length2 = objArr2.length;
            int i2 = length2 + (length2 >> 1);
            if (i2 - i >= 0) {
                i = i2;
            }
            if ((-2147483639) + i > 0) {
                i = 2147483639;
            }
            this.zza = Arrays.copyOf(objArr2, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:24:0x0043 A[Catch: all -> 0x005b, TryCatch #0 {, blocks: (B:8:0x000a, B:10:0x000e, B:12:0x0010, B:14:0x0015, B:16:0x0017, B:17:0x001e, B:19:0x0022, B:21:0x002a, B:23:0x003e, B:25:0x0049, B:24:0x0043, B:27:0x004e, B:28:0x0057, B:29:0x0059), top: B:35:0x000a }] */
    /* JADX INFO: renamed from: zzi, reason: merged with bridge method [inline-methods] */
    public final void zzd() {
        int i;
        if (this.zzc || this.zze) {
            return;
        }
        synchronized (this) {
            if (this.zze) {
                return;
            }
            int i2 = this.zzb;
            if (i2 <= 1) {
                return;
            }
            int i3 = 0;
            Arrays.sort(this.zza, 0, i2);
            int i4 = 0;
            while (true) {
                i = this.zzb;
                if (i3 >= i) {
                    break;
                }
                Object[] objArr = this.zza;
                zzalf zzalfVar = (zzalf) objArr[i3];
                if (i4 > 0) {
                    int i5 = i4 - 1;
                    if (((zzalf) objArr[i5]).zza().equals(zzalfVar.zza())) {
                        this.zza[i5] = zzalfVar;
                    } else {
                        this.zza[i4] = zzalfVar;
                        i4++;
                    }
                } else {
                    this.zza[i4] = zzalfVar;
                    i4++;
                }
                i3++;
            }
            if (i4 < i) {
                this.zzb = i4;
                Object[] objArr2 = this.zza;
                Arrays.fill(objArr2, i4, objArr2.length, (Object) null);
            }
            this.zze = true;
        }
    }

    private final int zzj(zzajd zzajdVar) {
        int i = this.zzb - 1;
        int i2 = 0;
        while (i2 <= i) {
            int i3 = (i2 + i) >>> 1;
            int iCompareTo = ((zzalf) this.zza[i3]).zza().compareTo(zzajdVar);
            if (iCompareTo < 0) {
                i2 = i3 + 1;
            } else {
                if (iCompareTo <= 0) {
                    return i3;
                }
                i = i3 - 1;
            }
        }
        return -(i2 + 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzk, reason: merged with bridge method [inline-methods] */
    public final void zze() {
        if (this.zzc) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void clear() {
        zze();
        if (this.zzb != 0) {
            this.zza = null;
            this.zzb = 0;
            this.zze = true;
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsKey(Object obj) {
        zzd();
        return zzj((zzajd) obj) >= 0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set entrySet() {
        zzd();
        if (this.zzd == null) {
            this.zzd = new zzalh(this, null);
        }
        return this.zzd;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzali)) {
            return super.equals(obj);
        }
        zzali zzaliVar = (zzali) obj;
        zzd();
        int i = this.zzb;
        zzaliVar.zzd();
        if (i != zzaliVar.zzb) {
            return false;
        }
        Object[] objArr = this.zza;
        Object[] objArr2 = zzaliVar.zza;
        for (int i2 = 0; i2 < i; i2++) {
            if (!objArr[i2].equals(objArr2[i2])) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object get(Object obj) {
        zzd();
        int iZzj = zzj((zzajd) obj);
        if (iZzj >= 0) {
            return ((zzalf) this.zza[iZzj]).getValue();
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int hashCode() {
        zzd();
        int i = this.zzb;
        int iHashCode = 0;
        for (int i2 = 0; i2 < i; i2++) {
            iHashCode += this.zza[i2].hashCode();
        }
        return iHashCode;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean isEmpty() {
        return this.zzb == 0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final /* bridge */ /* synthetic */ Object put(Object obj, Object obj2) {
        zzc((zzajd) obj, obj2);
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void putAll(Map map) {
        zze();
        if (!(map instanceof zzali)) {
            zzh(this.zzb + map.size());
            for (Map.Entry entry : map.entrySet()) {
                zzc((zzajd) entry.getKey(), entry.getValue());
            }
            return;
        }
        zzali zzaliVar = (zzali) map;
        zzh(this.zzb + zzaliVar.zzb);
        int i = this.zzb;
        int i2 = zzaliVar.zzb + i;
        for (int i3 = i; i3 < i2; i3++) {
            zzalf zzalfVar = (zzalf) zzaliVar.zza[i3 - i];
            zzc(zzalfVar.zza(), zzalfVar.getValue());
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object remove(Object obj) {
        zze();
        zzd();
        int iZzj = zzj((zzajd) obj);
        if (iZzj < 0) {
            return null;
        }
        Object value = ((zzalf) this.zza[iZzj]).getValue();
        Object[] objArr = this.zza;
        System.arraycopy(objArr, iZzj + 1, objArr, iZzj, (this.zzb - iZzj) - 1);
        Object[] objArr2 = this.zza;
        int i = this.zzb - 1;
        this.zzb = i;
        objArr2[i] = null;
        return value;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int size() {
        zzd();
        return this.zzb;
    }

    public final void zza() {
        if (this.zzc) {
            return;
        }
        zzd();
        if (this.zza != null) {
            for (int i = 0; i < this.zzb; i++) {
                zzalf zzalfVar = (zzalf) this.zza[i];
                if (zzalfVar.zza().zzd()) {
                    zzalfVar.setValue(Collections.unmodifiableList((List) zzalfVar.getValue()));
                }
            }
        }
        this.zzc = true;
    }

    public final Map.Entry zzb(int i) {
        zzd();
        if (i < this.zzb) {
            return (zzalf) this.zza[i];
        }
        throw new ArrayIndexOutOfBoundsException(i);
    }

    public final Object zzc(zzajd zzajdVar, Object obj) {
        zze();
        Objects.requireNonNull(zzajdVar);
        boolean z = this.zze;
        int i = this.zzb;
        if (i > 0) {
            int iCompareTo = zzajdVar.compareTo(((zzalf) this.zza[i - 1]).zza());
            if (iCompareTo < 0) {
                z = false;
            } else if (iCompareTo == 0) {
                ((zzalf) this.zza[this.zzb - 1]).setValue(obj);
                return null;
            }
        }
        zzh(this.zzb + 1);
        Object[] objArr = this.zza;
        int i2 = this.zzb;
        this.zzb = i2 + 1;
        objArr[i2] = new zzalf(this, zzajdVar, obj);
        this.zze = z;
        return null;
    }

    final /* synthetic */ Object[] zzf() {
        return this.zza;
    }

    final /* synthetic */ int zzg() {
        return this.zzb;
    }
}
