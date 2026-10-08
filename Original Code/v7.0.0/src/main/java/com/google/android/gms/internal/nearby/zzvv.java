package com.google.android.gms.internal.nearby;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzvv extends LinkedHashMap {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzvv(zzvw zzvwVar, int i, float f, boolean z) {
        super(1, 0.75f, true);
        Objects.requireNonNull(zzvwVar);
    }

    @Override // java.util.LinkedHashMap
    protected final boolean removeEldestEntry(Map.Entry entry) {
        return size() > 10;
    }
}
