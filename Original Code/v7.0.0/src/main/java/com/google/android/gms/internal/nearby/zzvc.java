package com.google.android.gms.internal.nearby;

import androidx.collection.SimpleArrayMap;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public class zzvc {
    private static final zzva zza = zzva.zza(Boolean.class);

    @Nullable
    private final zzvc zzb;
    private final SimpleArrayMap zzc;
    private boolean zzd = false;

    /* synthetic */ zzvc(zzvc zzvcVar, SimpleArrayMap simpleArrayMap, byte[] bArr) {
        if (zzvcVar != null) {
            zzxd.zza(zzvcVar.zzd);
        }
        this.zzb = zzvcVar;
        this.zzc = simpleArrayMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    static zzvc zza(zzvc zzvcVar, zzvc zzvcVar2) {
        if (zzvcVar.zzc()) {
            return zzvcVar2;
        }
        if (zzvcVar2.zzc()) {
            return zzvcVar;
        }
        zzyl<zzvc> zzylVarZzi = zzyl.zzi(zzvcVar, zzvcVar2);
        if (zzylVarZzi.isEmpty()) {
            return zzvb.zza;
        }
        if (zzylVarZzi.size() == 1) {
            return (zzvc) zzylVarZzi.iterator().next();
        }
        int size = 0;
        for (zzvc zzvcVar3 : zzylVarZzi) {
            do {
                size += zzvcVar3.zzc.getSize();
                zzvcVar3 = zzvcVar3.zzb;
            } while (zzvcVar3 != null);
        }
        if (size == 0) {
            return zzvb.zza;
        }
        SimpleArrayMap simpleArrayMap = new SimpleArrayMap(size);
        for (zzvc zzvcVar4 : zzylVarZzi) {
            do {
                int i = 0;
                while (true) {
                    SimpleArrayMap simpleArrayMap2 = zzvcVar4.zzc;
                    if (i >= simpleArrayMap2.getSize()) {
                        break;
                    }
                    zzxd.zzd(simpleArrayMap.put((zzva) simpleArrayMap2.keyAt(i), simpleArrayMap2.valueAt(i)) == null, "Duplicate bindings: %s", simpleArrayMap2.keyAt(i));
                    i++;
                }
                zzvcVar4 = zzvcVar4.zzb;
            } while (zzvcVar4 != null);
        }
        return new zzvb(null, simpleArrayMap, 0 == true ? 1 : 0).zzb();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("SpanExtras<");
        for (zzvc zzvcVar = this; zzvcVar != null; zzvcVar = zzvcVar.zzb) {
            for (int i = 0; i < zzvcVar.zzc.getSize(); i++) {
                sb.append("[");
                sb.append(this.zzc.valueAt(i));
                sb.append("], ");
            }
        }
        sb.append(">");
        return sb.toString();
    }

    final zzvc zzb() {
        if (this.zzd) {
            throw new IllegalStateException("Already frozen");
        }
        this.zzd = true;
        zzvc zzvcVar = this.zzb;
        return (zzvcVar == null || !this.zzc.isEmpty()) ? this : zzvcVar;
    }

    public final boolean zzc() {
        return this == zzvb.zza;
    }

    final boolean zzd(zzva zzvaVar) {
        if (this.zzc.containsKey(zzvaVar)) {
            return true;
        }
        zzvc zzvcVar = this.zzb;
        return zzvcVar != null && zzvcVar.zzd(zzvaVar);
    }

    final boolean zze() {
        return this.zzd;
    }

    final /* synthetic */ SimpleArrayMap zzg() {
        return this.zzc;
    }

    final /* synthetic */ boolean zzh() {
        return this.zzd;
    }
}
