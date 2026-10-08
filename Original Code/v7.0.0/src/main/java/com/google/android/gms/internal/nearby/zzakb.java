package com.google.android.gms.internal.nearby;

import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzakb implements Map.Entry {
    private final Map.Entry zza;

    @Override // java.util.Map.Entry
    public final Object getKey() {
        return this.zza.getKey();
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        zzakd zzakdVar = (zzakd) this.zza.getValue();
        if (zzakdVar == null) {
            return null;
        }
        return zzakdVar.zza();
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        if (!(obj instanceof zzaks)) {
            throw new IllegalArgumentException("Lazy field only supports MessageLite values.");
        }
        Map.Entry entry = this.zza;
        zzaks zzaksVar = ((zzakd) entry.getValue()).zza;
        entry.setValue(new zzakd((zzaks) obj));
        return zzaksVar;
    }

    public final zzakd zza() {
        return (zzakd) this.zza.getValue();
    }
}
