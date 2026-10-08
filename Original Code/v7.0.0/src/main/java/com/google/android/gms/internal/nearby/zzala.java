package com.google.android.gms.internal.nearby;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzala {
    private static final zzala zza = new zzala();
    private final ConcurrentMap zzb = new ConcurrentHashMap();

    private zzala() {
        zzaji.zza();
    }

    static zzala zza() {
        return zza;
    }

    private <T extends zzajo> zzald<T> zzc(Class<T> cls) {
        Class<T> cls2;
        zzald<T> zzaldVarZzm;
        int i = zzahy.zza;
        if (!zzajo.class.isAssignableFrom(cls)) {
            String name = cls.getName();
            String.valueOf(name);
            throw new IllegalArgumentException("Unsupported message type: ".concat(String.valueOf(name)));
        }
        try {
            zzakq zzakqVar = (zzakq) zzajo.zzL(cls.asSubclass(zzajo.class)).zzc(3, null, null);
            if (zzakqVar.zza()) {
                zzaldVarZzm = zzakw.zzh(zzale.zzy(), zzajc.zza(), zzakqVar.zzb());
                cls2 = cls;
            } else {
                cls2 = cls;
                zzaldVarZzm = zzakv.zzm(cls2, zzakqVar, zzaky.zza(), zzakj.zza(), zzale.zzy(), zzakqVar.zzc() + (-1) != 1 ? zzajc.zza() : null, zzakp.zza());
            }
            zzald<T> zzaldVar = (zzald) this.zzb.putIfAbsent(cls2, zzaldVarZzm);
            return zzaldVar != null ? zzaldVar : zzaldVarZzm;
        } catch (Exception e) {
            String name2 = cls.getName();
            String.valueOf(name2);
            throw new RuntimeException("Unable to get message info for ".concat(String.valueOf(name2)), e);
        }
    }

    final zzald zzb(Class cls) {
        Object obj = this.zzb.get(cls);
        return obj == null ? zzc(cls) : (zzald) obj;
    }
}
