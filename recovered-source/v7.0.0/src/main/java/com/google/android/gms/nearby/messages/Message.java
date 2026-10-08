package com.google.android.gms.nearby.messages;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.internal.nearby.zzba;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public class Message extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final int MAX_CONTENT_SIZE_BYTES = 102400;
    public static final int MAX_TYPE_LENGTH = 32;
    public static final String MESSAGE_NAMESPACE_RESERVED = "__reserved_namespace";

    @Deprecated
    public static final String MESSAGE_TYPE_AUDIO_BYTES = "__audio_bytes";
    public static final String MESSAGE_TYPE_EDDYSTONE_UID = "__eddystone_uid";
    public static final String MESSAGE_TYPE_I_BEACON_ID = "__i_beacon_id";
    final int zza;

    @Deprecated
    final zzba[] zzb;
    private final byte[] zzd;
    private final String zze;
    private final String zzf;
    private final long zzg;
    public static final Parcelable.Creator<Message> CREATOR = new zza();
    private static final zzba[] zzc = {zzba.zza};

    Message(int i, byte[] bArr, String str, String str2, zzba[] zzbaVarArr, long j) {
        this.zza = i;
        this.zze = (String) Preconditions.checkNotNull(str2);
        this.zzf = str == null ? "" : str;
        this.zzg = j;
        Preconditions.checkNotNull(bArr);
        int length = bArr.length;
        Preconditions.checkArgument(length <= 102400, "Content length(%d) must not exceed MAX_CONTENT_SIZE_BYTES(%d)", Integer.valueOf(length), Integer.valueOf(MAX_CONTENT_SIZE_BYTES));
        this.zzd = bArr;
        this.zzb = (zzbaVarArr == null || zzbaVarArr.length == 0) ? zzc : zzbaVarArr;
        Preconditions.checkArgument(str2.length() <= 32, "Type length(%d) must not exceed MAX_TYPE_LENGTH(%d)", Integer.valueOf(str2.length()), 32);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Message)) {
            return false;
        }
        Message message = (Message) obj;
        return TextUtils.equals(this.zzf, message.zzf) && TextUtils.equals(this.zze, message.zze) && Arrays.equals(this.zzd, message.zzd) && this.zzg == message.zzg;
    }

    public byte[] getContent() {
        return this.zzd;
    }

    public String getNamespace() {
        return this.zzf;
    }

    public String getType() {
        return this.zze;
    }

    public int hashCode() {
        return Objects.hash(this.zzf, this.zze, Integer.valueOf(Arrays.hashCode(this.zzd)), Long.valueOf(this.zzg));
    }

    public String toString() {
        byte[] bArr = this.zzd;
        int length = bArr == null ? 0 : bArr.length;
        String str = this.zze;
        String str2 = this.zzf;
        StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 28 + String.valueOf(str).length() + 12 + String.valueOf(length).length() + 8);
        sb.append("Message{namespace='");
        sb.append(str2);
        sb.append("', type='");
        sb.append(str);
        sb.append("', content=[");
        sb.append(length);
        sb.append(" bytes]}");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeByteArray(parcel, 1, getContent(), false);
        SafeParcelWriter.writeString(parcel, 2, getType(), false);
        SafeParcelWriter.writeString(parcel, 3, getNamespace(), false);
        SafeParcelWriter.writeTypedArray(parcel, 4, this.zzb, i, false);
        SafeParcelWriter.writeLong(parcel, 5, this.zzg);
        SafeParcelWriter.writeInt(parcel, 1000, this.zza);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public final boolean zza(String str) {
        return MESSAGE_NAMESPACE_RESERVED.equals(getNamespace()) && str.equals(getType());
    }

    public Message(byte[] bArr) {
        this(2, bArr, "", "", zzc, 0L);
    }

    public Message(byte[] bArr, String str) {
        this(2, bArr, "", str, zzc, 0L);
    }

    public Message(byte[] bArr, String str, String str2) {
        this(2, bArr, MESSAGE_NAMESPACE_RESERVED, MESSAGE_TYPE_AUDIO_BYTES, zzc, 0L);
    }
}
