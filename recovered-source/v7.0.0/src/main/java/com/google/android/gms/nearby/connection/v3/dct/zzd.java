package com.google.android.gms.nearby.connection.v3.dct;

import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzd extends zzi {
    private final List zza;

    /* synthetic */ zzd(long j, List list, String str, boolean z, boolean z2, byte[] bArr) {
        super(j, str, z, z2, null);
        if (list == null) {
            throw new NullPointerException("Cannot create a DctPayload BytesResponse from null bytes.");
        }
        this.zza = list;
    }

    public final List zza() {
        return this.zza;
    }
}
