package com.google.android.gms.nearby.connection;

import java.util.Locale;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class ConnectionInfo {
    private final String zza;
    private final String zzb;
    private final byte[] zzc;
    private final boolean zzd;
    private final boolean zze;
    private final byte[] zzf;
    private final int zzg;

    @Deprecated
    public ConnectionInfo(String str, String str2, boolean z) {
        this(str, str2, str2.getBytes(), z, false, str.getBytes(), 0);
    }

    private ConnectionInfo(String str, String str2, byte[] bArr, boolean z, boolean z2, byte[] bArr2, int i) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = bArr;
        this.zzd = z;
        this.zze = z2;
        this.zzf = bArr2;
        this.zzg = i;
    }

    /* synthetic */ ConnectionInfo(String str, String str2, byte[] bArr, boolean z, boolean z2, byte[] bArr2, int i, byte[] bArr3) {
        this(str, str2, bArr, z, z2, bArr2, i);
    }

    public String getAuthenticationDigits() {
        int i = zzl.zzb;
        int i2 = 1;
        int i3 = 0;
        for (byte b : this.zzc) {
            int i4 = i3 + (b * i2);
            i2 = (i2 * 31) % 9973;
            i3 = i4 % 9973;
        }
        return String.format(Locale.US, "%04d", Integer.valueOf(Math.abs(i3)));
    }

    public int getAuthenticationStatus() {
        return this.zzg;
    }

    @Deprecated
    public String getAuthenticationToken() {
        return this.zzb;
    }

    public byte[] getEndpointInfo() {
        return this.zzf;
    }

    public String getEndpointName() {
        return this.zza;
    }

    public byte[] getRawAuthenticationToken() {
        return this.zzc;
    }

    @Deprecated
    public boolean isConnectionVerified() {
        return this.zze;
    }

    public boolean isIncomingConnection() {
        return this.zzd;
    }
}
