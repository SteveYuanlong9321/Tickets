package com.google.android.gms.nearby.connection;

import com.google.android.gms.common.api.Api;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public class ConnectionsOptions implements Api.ApiOptions.Optional {
    private final String zza = null;

    /* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
    public static class Builder {
        public ConnectionsOptions build() {
            return new ConnectionsOptions(this, null);
        }
    }

    /* synthetic */ ConnectionsOptions(Builder builder, byte[] bArr) {
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ConnectionsOptions)) {
            return false;
        }
        String str = ((ConnectionsOptions) obj).zza;
        return true;
    }

    public final int hashCode() {
        return Objects.hash(null);
    }
}
