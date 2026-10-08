package com.google.android.gms.nearby.connection;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class PayloadTransferUpdate extends AbstractSafeParcelable {
    public static final Parcelable.Creator<PayloadTransferUpdate> CREATOR = new zzv();
    private long zza;
    private int zzb;
    private long zzc;
    private long zzd;

    /* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
    public static final class Builder {
        private final PayloadTransferUpdate zza;

        public Builder() {
            this.zza = new PayloadTransferUpdate(null);
        }

        public PayloadTransferUpdate build() {
            return this.zza;
        }

        public Builder setBytesTransferred(long j) {
            this.zza.zzh(j);
            return this;
        }

        public Builder setPayloadId(long j) {
            this.zza.zzb(j);
            return this;
        }

        public Builder setStatus(int i) {
            this.zza.zzd(i);
            return this;
        }

        public Builder setTotalBytes(long j) {
            this.zza.zzf(j);
            return this;
        }

        public Builder(PayloadTransferUpdate payloadTransferUpdate) {
            PayloadTransferUpdate payloadTransferUpdate2 = new PayloadTransferUpdate(null);
            this.zza = payloadTransferUpdate2;
            payloadTransferUpdate2.zzb(payloadTransferUpdate.zza());
            payloadTransferUpdate2.zzd(payloadTransferUpdate.zzc());
            payloadTransferUpdate2.zzf(payloadTransferUpdate.zze());
            payloadTransferUpdate2.zzh(payloadTransferUpdate.zzg());
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface Status {
        public static final int CANCELED = 4;
        public static final int FAILURE = 2;
        public static final int IN_PROGRESS = 3;
        public static final int SUCCESS = 1;
    }

    private PayloadTransferUpdate() {
        throw null;
    }

    PayloadTransferUpdate(long j, int i, long j2, long j3) {
        this.zza = j;
        this.zzb = i;
        this.zzc = j2;
        this.zzd = j3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof PayloadTransferUpdate) {
            PayloadTransferUpdate payloadTransferUpdate = (PayloadTransferUpdate) obj;
            if (Objects.equal(Long.valueOf(this.zza), Long.valueOf(payloadTransferUpdate.zza)) && Objects.equal(Integer.valueOf(this.zzb), Integer.valueOf(payloadTransferUpdate.zzb)) && Objects.equal(Long.valueOf(this.zzc), Long.valueOf(payloadTransferUpdate.zzc)) && Objects.equal(Long.valueOf(this.zzd), Long.valueOf(payloadTransferUpdate.zzd))) {
                return true;
            }
        }
        return false;
    }

    public long getBytesTransferred() {
        return this.zzd;
    }

    public long getPayloadId() {
        return this.zza;
    }

    public int getStatus() {
        return this.zzb;
    }

    public long getTotalBytes() {
        return this.zzc;
    }

    public int hashCode() {
        return Objects.hashCode(Long.valueOf(this.zza), Integer.valueOf(this.zzb), Long.valueOf(this.zzc), Long.valueOf(this.zzd));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeLong(parcel, 1, getPayloadId());
        SafeParcelWriter.writeInt(parcel, 2, getStatus());
        SafeParcelWriter.writeLong(parcel, 3, getTotalBytes());
        SafeParcelWriter.writeLong(parcel, 4, getBytesTransferred());
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    final /* synthetic */ long zza() {
        return this.zza;
    }

    final /* synthetic */ void zzb(long j) {
        this.zza = j;
    }

    final /* synthetic */ int zzc() {
        return this.zzb;
    }

    final /* synthetic */ void zzd(int i) {
        this.zzb = i;
    }

    final /* synthetic */ long zze() {
        return this.zzc;
    }

    final /* synthetic */ void zzf(long j) {
        this.zzc = j;
    }

    final /* synthetic */ long zzg() {
        return this.zzd;
    }

    final /* synthetic */ void zzh(long j) {
        this.zzd = j;
    }

    /* synthetic */ PayloadTransferUpdate(byte[] bArr) {
    }
}
