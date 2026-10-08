package com.google.android.gms.nearby.internal.connection;

import android.os.Parcel;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzgd extends zzgf {
    zzgd() {
    }

    @Override // com.google.android.gms.nearby.internal.connection.zzgf, android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        return createFromParcel(parcel);
    }

    @Override // com.google.android.gms.nearby.internal.connection.zzgf
    /* JADX INFO: renamed from: zza */
    public final ParcelByteArray createFromParcel(Parcel parcel) {
        ParcelByteArray parcelByteArrayZza = super.createFromParcel(parcel);
        if (parcelByteArrayZza.zzd() != null) {
            parcelByteArrayZza.zzc(ParcelByteArray.zzb(parcelByteArrayZza.zzd()));
        }
        return parcelByteArrayZza;
    }
}
