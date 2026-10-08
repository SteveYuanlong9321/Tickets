package com.google.android.gms.nearby.messages;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.nearby.messages.internal.zzg;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public class EddystoneUid {
    public static final int INSTANCE_LENGTH = 6;
    public static final int LENGTH = 16;
    public static final int NAMESPACE_LENGTH = 10;
    private final zzg zza;

    public EddystoneUid(String str) {
        this(com.google.android.gms.nearby.messages.internal.zzc.zzb(str));
    }

    public static EddystoneUid from(Message message) {
        boolean zZza = message.zza(Message.MESSAGE_TYPE_EDDYSTONE_UID);
        String type = message.getType();
        StringBuilder sb = new StringBuilder(String.valueOf(type).length() + 58);
        sb.append("Message type '");
        sb.append(type);
        sb.append("' is not Message.MESSAGE_TYPE_EDDYSTONE_UID.");
        Preconditions.checkArgument(zZza, sb.toString());
        return new EddystoneUid(message.getContent());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof EddystoneUid) {
            return Objects.equals(this.zza, ((EddystoneUid) obj).zza);
        }
        return false;
    }

    public String getHex() {
        return this.zza.zzd();
    }

    public String getInstance() {
        byte[] bArrZzc = this.zza.zzc();
        if (bArrZzc.length < 16) {
            return null;
        }
        return com.google.android.gms.nearby.messages.internal.zzc.zza(Arrays.copyOfRange(bArrZzc, 10, 16));
    }

    public String getNamespace() {
        return com.google.android.gms.nearby.messages.internal.zzc.zza(Arrays.copyOfRange(this.zza.zzc(), 0, 10));
    }

    public int hashCode() {
        return Objects.hash(this.zza);
    }

    public String toString() {
        String hex = getHex();
        StringBuilder sb = new StringBuilder(String.valueOf(hex).length() + 17);
        sb.append("EddystoneUid{id=");
        sb.append(hex);
        sb.append("}");
        return sb.toString();
    }

    public EddystoneUid(String str, String str2) {
        this.zza = new zzg(str, str2);
    }

    public EddystoneUid(byte[] bArr) {
        Preconditions.checkArgument(bArr.length == 16, "Bytes must be a namespace plus instance (16 bytes).");
        this.zza = new zzg(bArr);
    }
}
