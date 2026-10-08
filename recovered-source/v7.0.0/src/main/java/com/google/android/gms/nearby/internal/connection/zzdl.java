package com.google.android.gms.nearby.internal.connection;

import android.os.Parcel;
import android.os.ParcelUuid;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.nearby.connection.DiscoveryOptions;
import com.google.android.gms.nearby.connection.Strategy;
import java.util.Arrays;
import java.util.Locale;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzdl extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzdl> CREATOR = new zzdm();
    private Strategy zza;
    private boolean zzb;
    private boolean zzc;
    private boolean zzd;
    private boolean zze;
    private ParcelUuid zzf;
    private boolean zzg;
    private boolean zzh;
    private boolean zzi;
    private boolean zzj;
    private int zzk;
    private int zzl;
    private byte[] zzm;
    private long zzn;
    private int[] zzo;
    private boolean zzp;

    @Deprecated
    private boolean zzq;
    private boolean zzr;
    private boolean zzs;
    private int zzt;
    private com.google.android.gms.internal.nearby.zzy zzu;
    private boolean zzv;

    private zzdl() {
        this.zzb = false;
        this.zzc = true;
        this.zzd = true;
        this.zze = false;
        this.zzg = true;
        this.zzh = true;
        this.zzi = true;
        this.zzj = false;
        this.zzk = 0;
        this.zzl = 0;
        this.zzn = 0L;
        this.zzp = true;
        this.zzq = false;
        this.zzr = true;
        this.zzs = true;
        this.zzt = 0;
        this.zzv = true;
    }

    public static zzdl zza(DiscoveryOptions discoveryOptions) {
        zzdk zzdkVar = new zzdk();
        zzdkVar.zza(discoveryOptions.getStrategy());
        zzdkVar.zzb(discoveryOptions.zza());
        zzdkVar.zzc(discoveryOptions.zzb());
        zzdkVar.zzd(discoveryOptions.zzc());
        zzdkVar.zze(discoveryOptions.getLowPower());
        zzdkVar.zzf(discoveryOptions.zzd());
        zzdkVar.zzg(discoveryOptions.zze());
        zzdkVar.zzh(discoveryOptions.zzf());
        zzdkVar.zzi(discoveryOptions.zzg());
        zzdkVar.zzj(discoveryOptions.zzh());
        zzdkVar.zzk(discoveryOptions.zzi());
        zzdkVar.zzl(discoveryOptions.zzj());
        zzdkVar.zzm(discoveryOptions.zzk());
        zzdkVar.zzn(discoveryOptions.zzl());
        zzdkVar.zzp(discoveryOptions.zzn());
        zzdkVar.zzq(discoveryOptions.zzo());
        zzdkVar.zzr(discoveryOptions.zzp());
        zzdkVar.zzs(discoveryOptions.zzq());
        zzdkVar.zzt(discoveryOptions.zzr());
        zzdkVar.zzu(discoveryOptions.zzs());
        if (discoveryOptions.zzm() != null) {
            zzdkVar.zzo((int[]) Preconditions.checkNotNull(discoveryOptions.zzm()));
        }
        return zzdkVar.zzv();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzdl) {
            zzdl zzdlVar = (zzdl) obj;
            if (Objects.equals(this.zza, zzdlVar.zza) && Objects.equals(Boolean.valueOf(this.zzb), Boolean.valueOf(zzdlVar.zzb)) && Objects.equals(Boolean.valueOf(this.zzc), Boolean.valueOf(zzdlVar.zzc)) && Objects.equals(Boolean.valueOf(this.zzd), Boolean.valueOf(zzdlVar.zzd)) && Objects.equals(Boolean.valueOf(this.zze), Boolean.valueOf(zzdlVar.zze)) && Objects.equals(this.zzf, zzdlVar.zzf) && Objects.equals(Boolean.valueOf(this.zzg), Boolean.valueOf(zzdlVar.zzg)) && Objects.equals(Boolean.valueOf(this.zzh), Boolean.valueOf(zzdlVar.zzh)) && Objects.equals(Boolean.valueOf(this.zzi), Boolean.valueOf(zzdlVar.zzi)) && Objects.equals(Boolean.valueOf(this.zzj), Boolean.valueOf(zzdlVar.zzj)) && Objects.equals(Integer.valueOf(this.zzk), Integer.valueOf(zzdlVar.zzk)) && Objects.equals(Integer.valueOf(this.zzl), Integer.valueOf(zzdlVar.zzl)) && Arrays.equals(this.zzm, zzdlVar.zzm) && Objects.equals(Long.valueOf(this.zzn), Long.valueOf(zzdlVar.zzn)) && Arrays.equals(this.zzo, zzdlVar.zzo) && Objects.equals(Boolean.valueOf(this.zzp), Boolean.valueOf(zzdlVar.zzp)) && Objects.equals(Boolean.valueOf(this.zzq), Boolean.valueOf(zzdlVar.zzq)) && Objects.equals(Boolean.valueOf(this.zzr), Boolean.valueOf(zzdlVar.zzr)) && Objects.equals(Boolean.valueOf(this.zzs), Boolean.valueOf(zzdlVar.zzs)) && Objects.equals(Integer.valueOf(this.zzt), Integer.valueOf(zzdlVar.zzt)) && Objects.equals(this.zzu, zzdlVar.zzu) && Objects.equals(Boolean.valueOf(this.zzv), Boolean.valueOf(zzdlVar.zzv))) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hash(this.zza, Boolean.valueOf(this.zzb), Boolean.valueOf(this.zzc), Boolean.valueOf(this.zzd), Boolean.valueOf(this.zze), this.zzf, Boolean.valueOf(this.zzg), Boolean.valueOf(this.zzh), Boolean.valueOf(this.zzi), Boolean.valueOf(this.zzj), Integer.valueOf(this.zzk), Integer.valueOf(this.zzl), Integer.valueOf(Arrays.hashCode(this.zzm)), Long.valueOf(this.zzn), Integer.valueOf(Arrays.hashCode(this.zzo)), Boolean.valueOf(this.zzp), Boolean.valueOf(this.zzq), Boolean.valueOf(this.zzr), Boolean.valueOf(this.zzs), Integer.valueOf(this.zzt), this.zzu, Boolean.valueOf(this.zzv));
    }

    public final String toString() {
        Locale locale = Locale.US;
        Strategy strategy = this.zza;
        Boolean boolValueOf = Boolean.valueOf(this.zzb);
        Boolean boolValueOf2 = Boolean.valueOf(this.zzc);
        Boolean boolValueOf3 = Boolean.valueOf(this.zzd);
        Boolean boolValueOf4 = Boolean.valueOf(this.zze);
        ParcelUuid parcelUuid = this.zzf;
        Boolean boolValueOf5 = Boolean.valueOf(this.zzg);
        Boolean boolValueOf6 = Boolean.valueOf(this.zzh);
        Boolean boolValueOf7 = Boolean.valueOf(this.zzi);
        Boolean boolValueOf8 = Boolean.valueOf(this.zzj);
        Integer numValueOf = Integer.valueOf(this.zzk);
        Integer numValueOf2 = Integer.valueOf(this.zzl);
        byte[] bArr = this.zzm;
        return String.format(locale, "DiscoveryOptions{strategy: %s, forwardUnrecognizedBluetoothDevices: %s, enableBluetooth: %s, enableBle: %s, lowPower: %s, fastAdvertisementServiceUuid: %s, enableWifiLan: %s, enableNfc: %s, enableWifiAware: %s, enableUwbRanging: %s, uwbChannel: %d, uwbPreambleIndex: %d, uwbAddress: %s, flowId: %d, discoveryMediums: %s, allowGattConnections: %s, enableV3Options: %s, allowBluetoothRadioToggling: %s, allowWifiRadioToggling: %s, powerLevel : %d, dataElementsFilters: %s,allowWifiLanBlockList: %s}", strategy, boolValueOf, boolValueOf2, boolValueOf3, boolValueOf4, parcelUuid, boolValueOf5, boolValueOf6, boolValueOf7, boolValueOf8, numValueOf, numValueOf2, bArr == null ? "null" : com.google.android.gms.nearby.messages.internal.zzc.zza(bArr), Long.valueOf(this.zzn), Arrays.toString(this.zzo), Boolean.valueOf(this.zzp), Boolean.valueOf(this.zzq), Boolean.valueOf(this.zzr), Boolean.valueOf(this.zzs), Integer.valueOf(this.zzt), String.valueOf(this.zzu), Boolean.valueOf(this.zzv));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, this.zza, i, false);
        SafeParcelWriter.writeBoolean(parcel, 2, this.zzb);
        SafeParcelWriter.writeBoolean(parcel, 3, this.zzc);
        SafeParcelWriter.writeBoolean(parcel, 4, this.zzd);
        SafeParcelWriter.writeBoolean(parcel, 5, this.zze);
        SafeParcelWriter.writeParcelable(parcel, 6, this.zzf, i, false);
        SafeParcelWriter.writeBoolean(parcel, 8, this.zzg);
        SafeParcelWriter.writeBoolean(parcel, 9, this.zzh);
        SafeParcelWriter.writeBoolean(parcel, 10, this.zzi);
        SafeParcelWriter.writeBoolean(parcel, 11, this.zzj);
        SafeParcelWriter.writeInt(parcel, 12, this.zzk);
        SafeParcelWriter.writeInt(parcel, 13, this.zzl);
        SafeParcelWriter.writeByteArray(parcel, 14, this.zzm, false);
        SafeParcelWriter.writeLong(parcel, 15, this.zzn);
        SafeParcelWriter.writeIntArray(parcel, 16, this.zzo, false);
        SafeParcelWriter.writeBoolean(parcel, 17, this.zzp);
        SafeParcelWriter.writeBoolean(parcel, 18, this.zzq);
        SafeParcelWriter.writeBoolean(parcel, 19, this.zzr);
        SafeParcelWriter.writeBoolean(parcel, 20, this.zzs);
        SafeParcelWriter.writeInt(parcel, 21, this.zzt);
        SafeParcelWriter.writeParcelable(parcel, 22, this.zzu, i, false);
        SafeParcelWriter.writeBoolean(parcel, 23, this.zzv);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    final /* synthetic */ void zzb(Strategy strategy) {
        this.zza = strategy;
    }

    final /* synthetic */ void zzc(boolean z) {
        this.zzb = z;
    }

    final /* synthetic */ void zzd(boolean z) {
        this.zzc = z;
    }

    final /* synthetic */ void zze(boolean z) {
        this.zzd = z;
    }

    final /* synthetic */ boolean zzf() {
        return this.zze;
    }

    final /* synthetic */ void zzg(boolean z) {
        this.zze = z;
    }

    final /* synthetic */ void zzh(ParcelUuid parcelUuid) {
        this.zzf = parcelUuid;
    }

    final /* synthetic */ void zzi(boolean z) {
        this.zzg = z;
    }

    final /* synthetic */ void zzj(boolean z) {
        this.zzh = z;
    }

    final /* synthetic */ void zzk(boolean z) {
        this.zzi = z;
    }

    final /* synthetic */ void zzl(boolean z) {
        this.zzj = z;
    }

    final /* synthetic */ void zzm(int i) {
        this.zzk = i;
    }

    final /* synthetic */ void zzn(int i) {
        this.zzl = i;
    }

    final /* synthetic */ void zzo(byte[] bArr) {
        this.zzm = bArr;
    }

    final /* synthetic */ void zzp(long j) {
        this.zzn = j;
    }

    final /* synthetic */ int[] zzq() {
        return this.zzo;
    }

    final /* synthetic */ void zzr(int[] iArr) {
        this.zzo = iArr;
    }

    final /* synthetic */ void zzs(boolean z) {
        this.zzp = z;
    }

    final /* synthetic */ void zzt(boolean z) {
        this.zzq = z;
    }

    final /* synthetic */ void zzu(boolean z) {
        this.zzr = z;
    }

    final /* synthetic */ void zzv(boolean z) {
        this.zzs = z;
    }

    final /* synthetic */ int zzw() {
        return this.zzt;
    }

    final /* synthetic */ void zzx(int i) {
        this.zzt = i;
    }

    final /* synthetic */ void zzy(boolean z) {
        this.zzv = z;
    }

    zzdl(Strategy strategy, boolean z, boolean z2, boolean z3, boolean z4, ParcelUuid parcelUuid, boolean z5, boolean z6, boolean z7, boolean z8, int i, int i2, byte[] bArr, long j, int[] iArr, boolean z9, boolean z10, boolean z11, boolean z12, int i3, com.google.android.gms.internal.nearby.zzy zzyVar, boolean z13) {
        this.zza = strategy;
        this.zzb = z;
        this.zzc = z2;
        this.zzd = z3;
        this.zze = z4;
        this.zzf = parcelUuid;
        this.zzg = z5;
        this.zzh = z6;
        this.zzi = z7;
        this.zzj = z8;
        this.zzk = i;
        this.zzl = i2;
        this.zzm = bArr;
        this.zzn = j;
        this.zzo = iArr;
        this.zzp = z9;
        this.zzq = z10;
        this.zzr = z11;
        this.zzs = z12;
        this.zzt = i3;
        this.zzu = zzyVar;
        this.zzv = z13;
    }

    /* synthetic */ zzdl(byte[] bArr) {
        this.zzb = false;
        this.zzc = true;
        this.zzd = true;
        this.zze = false;
        this.zzg = true;
        this.zzh = true;
        this.zzi = true;
        this.zzj = false;
        this.zzk = 0;
        this.zzl = 0;
        this.zzn = 0L;
        this.zzp = true;
        this.zzq = false;
        this.zzr = true;
        this.zzs = true;
        this.zzt = 0;
        this.zzv = true;
    }
}
