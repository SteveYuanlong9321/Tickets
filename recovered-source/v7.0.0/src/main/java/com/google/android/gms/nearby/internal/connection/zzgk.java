package com.google.android.gms.nearby.internal.connection;

import android.net.Uri;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.Arrays;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzgk extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzgk> CREATOR = new zzgl();
    private byte[] zza;
    private ParcelFileDescriptor zzb;
    private long zzc;
    private Uri zzd;

    private zzgk() {
        throw null;
    }

    /* synthetic */ zzgk(byte[] bArr) {
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzgk) {
            zzgk zzgkVar = (zzgk) obj;
            if (Arrays.equals(this.zza, zzgkVar.zza) && Objects.equal(this.zzb, zzgkVar.zzb) && Objects.equal(Long.valueOf(this.zzc), Long.valueOf(zzgkVar.zzc)) && Objects.equal(this.zzd, zzgkVar.zzd)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(Integer.valueOf(Arrays.hashCode(this.zza)), this.zzb, Long.valueOf(this.zzc), this.zzd);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeByteArray(parcel, 1, this.zza, false);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzb, i, false);
        SafeParcelWriter.writeLong(parcel, 3, this.zzc);
        SafeParcelWriter.writeParcelable(parcel, 4, this.zzd, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public final byte[] zza() {
        return this.zza;
    }

    public final ParcelFileDescriptor zzb() {
        return this.zzb;
    }

    public final long zzc() {
        return this.zzc;
    }

    public final Uri zzd() {
        return this.zzd;
    }

    final /* synthetic */ void zze(byte[] bArr) {
        this.zza = bArr;
    }

    final /* synthetic */ void zzf(ParcelFileDescriptor parcelFileDescriptor) {
        this.zzb = parcelFileDescriptor;
    }

    final /* synthetic */ void zzg(long j) {
        this.zzc = j;
    }

    final /* synthetic */ void zzh(Uri uri) {
        this.zzd = uri;
    }

    zzgk(byte[] bArr, ParcelFileDescriptor parcelFileDescriptor, long j, Uri uri) {
        this.zza = bArr;
        this.zzb = parcelFileDescriptor;
        this.zzc = j;
        this.zzd = uri;
    }
}
