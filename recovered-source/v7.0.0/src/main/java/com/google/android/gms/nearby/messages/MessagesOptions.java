package com.google.android.gms.nearby.messages;

import com.google.android.gms.common.api.Api;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public class MessagesOptions implements Api.ApiOptions.Optional {
    public final int zzc;
    public final String zza = null;
    public final boolean zzb = false;
    public final String zzd = null;
    public final String zze = null;

    /* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
    public static class Builder {
        private int zza = -1;

        public MessagesOptions build() {
            return new MessagesOptions(this, null);
        }

        public Builder setPermissions(int i) {
            this.zza = i;
            return this;
        }

        final /* synthetic */ int zza() {
            return this.zza;
        }
    }

    /* synthetic */ MessagesOptions(Builder builder, byte[] bArr) {
        this.zzc = builder.zza();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MessagesOptions)) {
            return false;
        }
        MessagesOptions messagesOptions = (MessagesOptions) obj;
        String str = messagesOptions.zza;
        boolean z = messagesOptions.zzb;
        String str2 = messagesOptions.zzd;
        String str3 = messagesOptions.zze;
        return this.zzc == messagesOptions.zzc;
    }

    public final int hashCode() {
        return Objects.hash(null, false, null, null, Integer.valueOf(this.zzc));
    }
}
