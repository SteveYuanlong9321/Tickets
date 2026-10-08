package com.google.android.gms.internal.nearby;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzbp extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbp> CREATOR = new zzbq();
    private final zzcd zza;
    private final zzbm zzb;
    private final byte[] zzc;
    private final boolean zzd;
    private final List zze;
    private final List zzf;
    private final List zzg;
    private final zzcf zzh;
    private final zzbt zzi;
    private final byte[] zzj;
    private final List zzk;
    private final List zzl;
    private final zzbv zzm;

    zzbp(zzcd zzcdVar, zzbm zzbmVar, byte[] bArr, boolean z, List list, List list2, List list3, zzcf zzcfVar, zzbt zzbtVar, byte[] bArr2, List list4, List list5, zzbv zzbvVar) {
        this.zza = zzcdVar;
        this.zzb = zzbmVar;
        this.zzc = bArr;
        this.zzd = z;
        this.zze = list;
        this.zzf = list2;
        this.zzg = list3;
        this.zzh = zzcfVar;
        this.zzi = zzbtVar;
        this.zzj = bArr2;
        this.zzk = list4;
        this.zzl = list5;
        this.zzm = zzbvVar;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzbp) {
            zzbp zzbpVar = (zzbp) obj;
            if (Objects.equals(this.zza, zzbpVar.zza) && Objects.equals(this.zzb, zzbpVar.zzb) && Arrays.equals(this.zzc, zzbpVar.zzc) && this.zzd == zzbpVar.zzd && Objects.equals(this.zze, zzbpVar.zze) && Objects.equals(this.zzf, zzbpVar.zzf) && Objects.equals(this.zzg, zzbpVar.zzg) && Objects.equals(this.zzh, zzbpVar.zzh) && Objects.equals(this.zzi, zzbpVar.zzi) && Arrays.equals(this.zzj, zzbpVar.zzj) && Objects.equals(this.zzk, zzbpVar.zzk) && Objects.equals(this.zzl, zzbpVar.zzl) && Objects.equals(this.zzm, zzbpVar.zzm)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hash(this.zza, this.zzb, Integer.valueOf(Arrays.hashCode(this.zzc)), Boolean.valueOf(this.zzd), this.zze, this.zzf, this.zzg, this.zzh, this.zzi, Integer.valueOf(Arrays.hashCode(this.zzj)), this.zzk, this.zzl, this.zzm);
    }

    public final String toString() {
        return String.format(Locale.US, "<DataElementCollection: sequenceNumber=%s, castId=%s, deduplicationHint=%s, deduplicationHintEnabled=%s, bleGattConnectivityInfo = %s, wifiLanConnectivityInfoList = %s, bluetoothConnectivityInfoList = %s, connectivityCapability = %s, deviceType = %s, mediaDeduplicationId = %s, requirements = %s, capabilities = %s, discoveryType = %s>", this.zza, this.zzb, Arrays.toString(this.zzc), Boolean.valueOf(this.zzd), this.zze, this.zzf, this.zzg, this.zzh, this.zzi, Arrays.toString(this.zzj), this.zzk, this.zzl, this.zzm);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        zzcd zzcdVar = this.zza;
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, zzcdVar, i, false);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzb, i, false);
        SafeParcelWriter.writeByteArray(parcel, 3, this.zzc, false);
        SafeParcelWriter.writeBoolean(parcel, 4, this.zzd);
        SafeParcelWriter.writeTypedList(parcel, 5, this.zze, false);
        SafeParcelWriter.writeTypedList(parcel, 6, this.zzf, false);
        SafeParcelWriter.writeTypedList(parcel, 7, this.zzg, false);
        SafeParcelWriter.writeParcelable(parcel, 8, this.zzh, i, false);
        SafeParcelWriter.writeParcelable(parcel, 9, this.zzi, i, false);
        SafeParcelWriter.writeByteArray(parcel, 10, this.zzj, false);
        SafeParcelWriter.writeTypedList(parcel, 11, this.zzk, false);
        SafeParcelWriter.writeTypedList(parcel, 12, this.zzl, false);
        SafeParcelWriter.writeParcelable(parcel, 13, this.zzm, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
