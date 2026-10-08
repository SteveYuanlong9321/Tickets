package com.google.android.gms.internal.nearby;

import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzadp extends zzadn {
    private static final Map zza;
    private final zzabf zzb;

    static {
        EnumMap enumMap = new EnumMap(zzabf.class);
        for (zzabf zzabfVar : zzabf.values()) {
            zzadp[] zzadpVarArr = new zzadp[10];
            for (int i = 0; i < 10; i++) {
                zzadpVarArr[i] = new zzadp(i, zzabfVar, zzabg.zza());
            }
            enumMap.put(zzabfVar, zzadpVarArr);
        }
        zza = Collections.unmodifiableMap(enumMap);
    }

    private zzadp(int i, zzabf zzabfVar, zzabg zzabgVar) {
        super(zzabgVar, i);
        zzadx.zza(zzabfVar, "format char");
        this.zzb = zzabfVar;
        if (zzabgVar.zze()) {
            zzabfVar.zze();
            return;
        }
        int iZzb = zzabfVar.zzb();
        iZzb = zzabgVar.zzk() ? iZzb & 65503 : iZzb;
        StringBuilder sb = new StringBuilder("%");
        zzabgVar.zzl(sb);
        sb.append((char) iZzb);
    }

    public static zzadp zza(int i, zzabf zzabfVar, zzabg zzabgVar) {
        if (i >= 10 || !zzabgVar.zze()) {
            return new zzadp(i, zzabfVar, zzabgVar);
        }
        zzadp[] zzadpVarArr = (zzadp[]) zza.get(zzabfVar);
        zzadx.zza(zzadpVarArr, "default parameter");
        return zzadpVarArr[i];
    }

    @Override // com.google.android.gms.internal.nearby.zzadn
    protected final void zzb(zzado zzadoVar, Object obj) {
        zzadoVar.zzc(obj, this.zzb, zzd());
    }
}
