package com.google.android.gms.nearby.connection;

import android.os.Parcel;
import android.os.ParcelUuid;
import android.os.Parcelable;
import android.util.Log;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.Arrays;
import java.util.Locale;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class DiscoveryOptions extends AbstractSafeParcelable {
    public static final Parcelable.Creator<DiscoveryOptions> CREATOR = new zzu();
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
    private boolean zzu;

    /* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
    public static final class Builder {
        private final DiscoveryOptions zza;

        public Builder() {
            this.zza = new DiscoveryOptions((byte[]) null);
        }

        public DiscoveryOptions build() {
            DiscoveryOptions discoveryOptions = this.zza;
            int[] iArrZzV = discoveryOptions.zzV();
            if (iArrZzV != null && iArrZzV.length > 0) {
                discoveryOptions.zzA(false);
                discoveryOptions.zzy(false);
                discoveryOptions.zzI(false);
                discoveryOptions.zzK(false);
                discoveryOptions.zzG(false);
                for (int i : iArrZzV) {
                    if (i == 2) {
                        discoveryOptions.zzy(true);
                    } else if (i != 11) {
                        if (i == 4) {
                            discoveryOptions.zzA(true);
                        } else if (i == 5) {
                            discoveryOptions.zzG(true);
                        } else if (i == 6) {
                            discoveryOptions.zzK(true);
                        } else if (i != 7) {
                            StringBuilder sb = new StringBuilder(String.valueOf(i).length() + 25);
                            sb.append("Illegal discovery medium ");
                            sb.append(i);
                            Log.d("NearbyConnections", sb.toString());
                        } else {
                            discoveryOptions.zzI(true);
                        }
                    }
                }
            }
            if (discoveryOptions.zzaf() == 0) {
                discoveryOptions.zzag(true != discoveryOptions.zzB() ? 3 : 1);
                return discoveryOptions;
            }
            discoveryOptions.zzC(discoveryOptions.zzaf() != 3);
            return discoveryOptions;
        }

        public Builder setLowPower(boolean z) {
            this.zza.zzC(z);
            return this;
        }

        public Builder setStrategy(Strategy strategy) {
            this.zza.zzu(strategy);
            return this;
        }

        public Builder(DiscoveryOptions discoveryOptions) {
            DiscoveryOptions discoveryOptions2 = new DiscoveryOptions((byte[]) null);
            this.zza = discoveryOptions2;
            discoveryOptions2.zzu(discoveryOptions.zzt());
            discoveryOptions2.zzw(discoveryOptions.zzv());
            discoveryOptions2.zzy(discoveryOptions.zzx());
            discoveryOptions2.zzA(discoveryOptions.zzz());
            discoveryOptions2.zzC(discoveryOptions.zzB());
            discoveryOptions2.zzE(discoveryOptions.zzD());
            discoveryOptions2.zzG(discoveryOptions.zzF());
            discoveryOptions2.zzI(discoveryOptions.zzH());
            discoveryOptions2.zzK(discoveryOptions.zzJ());
            discoveryOptions2.zzM(discoveryOptions.zzL());
            discoveryOptions2.zzO(discoveryOptions.zzN());
            discoveryOptions2.zzQ(discoveryOptions.zzP());
            discoveryOptions2.zzS(discoveryOptions.zzR());
            discoveryOptions2.zzU(discoveryOptions.zzT());
            discoveryOptions2.zzW(discoveryOptions.zzV());
            discoveryOptions2.zzY(discoveryOptions.zzX());
            discoveryOptions2.zzaa(discoveryOptions.zzZ());
            discoveryOptions2.zzac(discoveryOptions.zzab());
            discoveryOptions2.zzae(discoveryOptions.zzad());
            discoveryOptions2.zzag(discoveryOptions.zzaf());
            discoveryOptions2.zzai(discoveryOptions.zzah());
        }
    }

    private DiscoveryOptions() {
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
        this.zzu = true;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DiscoveryOptions) {
            DiscoveryOptions discoveryOptions = (DiscoveryOptions) obj;
            if (Objects.equal(this.zza, discoveryOptions.zza) && Objects.equal(Boolean.valueOf(this.zzb), Boolean.valueOf(discoveryOptions.zzb)) && Objects.equal(Boolean.valueOf(this.zzc), Boolean.valueOf(discoveryOptions.zzc)) && Objects.equal(Boolean.valueOf(this.zzd), Boolean.valueOf(discoveryOptions.zzd)) && Objects.equal(Boolean.valueOf(this.zze), Boolean.valueOf(discoveryOptions.zze)) && Objects.equal(this.zzf, discoveryOptions.zzf) && Objects.equal(Boolean.valueOf(this.zzg), Boolean.valueOf(discoveryOptions.zzg)) && Objects.equal(Boolean.valueOf(this.zzh), Boolean.valueOf(discoveryOptions.zzh)) && Objects.equal(Boolean.valueOf(this.zzi), Boolean.valueOf(discoveryOptions.zzi)) && Objects.equal(Boolean.valueOf(this.zzj), Boolean.valueOf(discoveryOptions.zzj)) && Objects.equal(Integer.valueOf(this.zzk), Integer.valueOf(discoveryOptions.zzk)) && Objects.equal(Integer.valueOf(this.zzl), Integer.valueOf(discoveryOptions.zzl)) && Arrays.equals(this.zzm, discoveryOptions.zzm) && Objects.equal(Long.valueOf(this.zzn), Long.valueOf(discoveryOptions.zzn)) && Arrays.equals(this.zzo, discoveryOptions.zzo) && Objects.equal(Boolean.valueOf(this.zzp), Boolean.valueOf(discoveryOptions.zzp)) && Objects.equal(Boolean.valueOf(this.zzq), Boolean.valueOf(discoveryOptions.zzq)) && Objects.equal(Boolean.valueOf(this.zzr), Boolean.valueOf(discoveryOptions.zzr)) && Objects.equal(Boolean.valueOf(this.zzs), Boolean.valueOf(discoveryOptions.zzs)) && Objects.equal(Integer.valueOf(this.zzt), Integer.valueOf(discoveryOptions.zzt)) && Objects.equal(Boolean.valueOf(this.zzu), Boolean.valueOf(discoveryOptions.zzu))) {
                return true;
            }
        }
        return false;
    }

    public boolean getLowPower() {
        return this.zze;
    }

    public Strategy getStrategy() {
        return this.zza;
    }

    public int hashCode() {
        return Objects.hashCode(this.zza, Boolean.valueOf(this.zzb), Boolean.valueOf(this.zzc), Boolean.valueOf(this.zzd), Boolean.valueOf(this.zze), this.zzf, Boolean.valueOf(this.zzg), Boolean.valueOf(this.zzh), Boolean.valueOf(this.zzi), Boolean.valueOf(this.zzj), Integer.valueOf(this.zzk), Integer.valueOf(this.zzl), Integer.valueOf(Arrays.hashCode(this.zzm)), Long.valueOf(this.zzn), Integer.valueOf(Arrays.hashCode(this.zzo)), Boolean.valueOf(this.zzp), Boolean.valueOf(this.zzq), Boolean.valueOf(this.zzr), Boolean.valueOf(this.zzs), Integer.valueOf(this.zzt), Boolean.valueOf(this.zzu));
    }

    public String toString() {
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
        return String.format(locale, "DiscoveryOptions{strategy: %s, forwardUnrecognizedBluetoothDevices: %s, enableBluetooth: %s, enableBle: %s, lowPower: %s, fastAdvertisementServiceUuid: %s, enableWifiLan: %s, enableNfc: %s, enableWifiAware: %s, enableUwbRanging: %s, uwbChannel: %d, uwbPreambleIndex: %d, uwbAddress: %s, flowId: %d, discoveryMediums: %s, allowGattConnections: %s, enableV3Options: %s, allowBluetoothRadioToggling: %s, allowWifiRadioToggling: %s, powerLevel : %d,allowWifiLanBlockList: %s}", strategy, boolValueOf, boolValueOf2, boolValueOf3, boolValueOf4, parcelUuid, boolValueOf5, boolValueOf6, boolValueOf7, boolValueOf8, numValueOf, numValueOf2, bArr == null ? "null" : com.google.android.gms.nearby.messages.internal.zzc.zza(bArr), Long.valueOf(this.zzn), Arrays.toString(this.zzo), Boolean.valueOf(this.zzp), Boolean.valueOf(this.zzq), Boolean.valueOf(this.zzr), Boolean.valueOf(this.zzs), Integer.valueOf(this.zzt), Boolean.valueOf(this.zzu));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, getStrategy(), i, false);
        SafeParcelWriter.writeBoolean(parcel, 2, this.zzb);
        SafeParcelWriter.writeBoolean(parcel, 3, this.zzc);
        SafeParcelWriter.writeBoolean(parcel, 4, this.zzd);
        SafeParcelWriter.writeBoolean(parcel, 5, getLowPower());
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
        SafeParcelWriter.writeBoolean(parcel, 22, this.zzu);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    final /* synthetic */ void zzA(boolean z) {
        this.zzd = z;
    }

    final /* synthetic */ boolean zzB() {
        return this.zze;
    }

    final /* synthetic */ void zzC(boolean z) {
        this.zze = z;
    }

    final /* synthetic */ ParcelUuid zzD() {
        return this.zzf;
    }

    final /* synthetic */ void zzE(ParcelUuid parcelUuid) {
        this.zzf = parcelUuid;
    }

    final /* synthetic */ boolean zzF() {
        return this.zzg;
    }

    final /* synthetic */ void zzG(boolean z) {
        this.zzg = z;
    }

    final /* synthetic */ boolean zzH() {
        return this.zzh;
    }

    final /* synthetic */ void zzI(boolean z) {
        this.zzh = z;
    }

    final /* synthetic */ boolean zzJ() {
        return this.zzi;
    }

    final /* synthetic */ void zzK(boolean z) {
        this.zzi = z;
    }

    final /* synthetic */ boolean zzL() {
        return this.zzj;
    }

    final /* synthetic */ void zzM(boolean z) {
        this.zzj = z;
    }

    final /* synthetic */ int zzN() {
        return this.zzk;
    }

    final /* synthetic */ void zzO(int i) {
        this.zzk = i;
    }

    final /* synthetic */ int zzP() {
        return this.zzl;
    }

    final /* synthetic */ void zzQ(int i) {
        this.zzl = i;
    }

    final /* synthetic */ byte[] zzR() {
        return this.zzm;
    }

    final /* synthetic */ void zzS(byte[] bArr) {
        this.zzm = bArr;
    }

    final /* synthetic */ long zzT() {
        return this.zzn;
    }

    final /* synthetic */ void zzU(long j) {
        this.zzn = j;
    }

    final /* synthetic */ int[] zzV() {
        return this.zzo;
    }

    final /* synthetic */ void zzW(int[] iArr) {
        this.zzo = iArr;
    }

    final /* synthetic */ boolean zzX() {
        return this.zzp;
    }

    final /* synthetic */ void zzY(boolean z) {
        this.zzp = z;
    }

    final /* synthetic */ boolean zzZ() {
        return this.zzq;
    }

    public final boolean zza() {
        return this.zzb;
    }

    final /* synthetic */ void zzaa(boolean z) {
        this.zzq = z;
    }

    final /* synthetic */ boolean zzab() {
        return this.zzr;
    }

    final /* synthetic */ void zzac(boolean z) {
        this.zzr = z;
    }

    final /* synthetic */ boolean zzad() {
        return this.zzs;
    }

    final /* synthetic */ void zzae(boolean z) {
        this.zzs = z;
    }

    final /* synthetic */ int zzaf() {
        return this.zzt;
    }

    final /* synthetic */ void zzag(int i) {
        this.zzt = i;
    }

    final /* synthetic */ boolean zzah() {
        return this.zzu;
    }

    final /* synthetic */ void zzai(boolean z) {
        this.zzu = z;
    }

    public final boolean zzb() {
        return this.zzc;
    }

    public final boolean zzc() {
        return this.zzd;
    }

    public final ParcelUuid zzd() {
        return this.zzf;
    }

    public final boolean zze() {
        return this.zzg;
    }

    public final boolean zzf() {
        return this.zzh;
    }

    public final boolean zzg() {
        return this.zzi;
    }

    public final boolean zzh() {
        return this.zzj;
    }

    public final int zzi() {
        return this.zzk;
    }

    public final int zzj() {
        return this.zzl;
    }

    public final byte[] zzk() {
        return this.zzm;
    }

    public final long zzl() {
        return this.zzn;
    }

    public final int[] zzm() {
        return this.zzo;
    }

    public final boolean zzn() {
        return this.zzp;
    }

    @Deprecated
    public final boolean zzo() {
        return this.zzq;
    }

    public final boolean zzp() {
        return this.zzr;
    }

    public final boolean zzq() {
        return this.zzs;
    }

    public final int zzr() {
        return this.zzt;
    }

    public final boolean zzs() {
        return this.zzu;
    }

    final /* synthetic */ Strategy zzt() {
        return this.zza;
    }

    final /* synthetic */ void zzu(Strategy strategy) {
        this.zza = strategy;
    }

    final /* synthetic */ boolean zzv() {
        return this.zzb;
    }

    final /* synthetic */ void zzw(boolean z) {
        this.zzb = z;
    }

    final /* synthetic */ boolean zzx() {
        return this.zzc;
    }

    final /* synthetic */ void zzy(boolean z) {
        this.zzc = z;
    }

    final /* synthetic */ boolean zzz() {
        return this.zzd;
    }

    @Deprecated
    public DiscoveryOptions(Strategy strategy) {
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
        this.zzu = true;
        this.zza = strategy;
    }

    DiscoveryOptions(Strategy strategy, boolean z, boolean z2, boolean z3, boolean z4, ParcelUuid parcelUuid, boolean z5, boolean z6, boolean z7, boolean z8, int i, int i2, byte[] bArr, long j, int[] iArr, boolean z9, boolean z10, boolean z11, boolean z12, int i3, boolean z13) {
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
        this.zzu = z13;
    }

    /* synthetic */ DiscoveryOptions(byte[] bArr) {
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
        this.zzu = true;
    }
}
