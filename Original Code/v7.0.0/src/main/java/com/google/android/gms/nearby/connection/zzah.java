package com.google.android.gms.nearby.connection;

import androidx.compose.foundation.style.StylePropertiesKt;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzah {
    private byte[] zza;
    private byte[] zzb;
    private byte[] zzc;
    private byte[] zzd;

    public final zzah zza(byte[] bArr) {
        this.zza = bArr;
        return this;
    }

    public final zzah zzb(byte[] bArr) {
        int length = bArr.length;
        if (length != 4 && length != 16) {
            throw new IllegalArgumentException(String.format("The IP address length must be %d or %d bytes", (byte) 4, Byte.valueOf(StylePropertiesKt.BottomId)));
        }
        this.zzb = bArr;
        return this;
    }

    public final zzah zzc(byte[] bArr) {
        this.zzc = bArr;
        return this;
    }

    public final zzah zzd(byte[] bArr) {
        if (bArr.length == 0) {
            throw new IllegalArgumentException("Actions length is 0.");
        }
        this.zzd = bArr;
        return this;
    }

    public final zzai zze() {
        return new zzai(this.zza, this.zzb, this.zzc, this.zzd);
    }
}
