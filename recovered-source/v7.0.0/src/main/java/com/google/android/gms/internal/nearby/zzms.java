package com.google.android.gms.internal.nearby;

import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzms extends zzajo implements zzakt {
    private static final zzms zzd;
    private zzakn zzb = zzakn.zza();

    static {
        zzms zzmsVar = new zzms();
        zzd = zzmsVar;
        zzajo.zzM(zzms.class, zzmsVar);
    }

    private zzms() {
    }

    public static zzms zzb() {
        return zzd;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final zzmq zza(String str, zzmq zzmqVar) {
        Objects.requireNonNull(str);
        zzmq zzmqVar2 = (zzmq) this.zzb.get(str);
        return zzmqVar2 != null ? zzmqVar2 : zzmqVar;
    }

    @Override // com.google.android.gms.internal.nearby.zzajo
    protected final Object zzc(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 2) {
            return zzN(zzd, "\u0004\u0001\u0000\u0000\u0002\u0002\u0001\u0001\u0000\u0000\u00022", new Object[]{"zzb", zzakm.zza(zzalz.STRING, "", zzalz.MESSAGE, zzmq.zzb())});
        }
        if (i2 == 3) {
            return new zzms();
        }
        byte[] bArr = null;
        if (i2 == 4) {
            return new zzmr(bArr);
        }
        if (i2 == 5) {
            return zzd;
        }
        if (i2 != 6) {
            return null;
        }
        return zzajo.zzK(zzms.class);
    }

    final /* synthetic */ Map zzd() {
        if (!this.zzb.zze()) {
            this.zzb = this.zzb.zzc();
        }
        return this.zzb;
    }
}
