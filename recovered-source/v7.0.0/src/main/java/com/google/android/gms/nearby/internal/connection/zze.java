package com.google.android.gms.nearby.internal.connection;

import android.os.Parcel;
import android.os.ParcelUuid;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.nearby.connection.AdvertisingOptions;
import com.google.android.gms.nearby.connection.Strategy;
import java.util.Arrays;
import java.util.Locale;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zze extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zze> CREATOR = new zzf();
    private int zzA;
    private byte[] zzB;
    private boolean zzC;
    private int zzD;

    @Deprecated
    private boolean zzE;
    private boolean zzF;
    private boolean zzG;
    private boolean zzH;
    private long zzI;
    private String zzJ;
    private com.google.android.gms.internal.nearby.zzy zzK;
    private boolean zzL;
    private boolean zzM;
    private final boolean zzN;
    private Strategy zza;
    private boolean zzb;
    private boolean zzc;
    private boolean zzd;
    private boolean zze;
    private byte[] zzf;
    private boolean zzg;
    private ParcelUuid zzh;
    private boolean zzi;
    private boolean zzj;
    private boolean zzk;
    private boolean zzl;
    private boolean zzm;
    private boolean zzn;
    private int zzo;
    private int zzp;
    private byte[] zzq;
    private long zzr;
    private com.google.android.gms.nearby.connection.zzz[] zzs;
    private boolean zzt;

    @Deprecated
    private boolean zzu;
    private boolean zzv;
    private boolean zzw;
    private int[] zzx;
    private int[] zzy;
    private boolean zzz;

    private zze() {
        this.zzb = true;
        this.zzc = true;
        this.zzd = true;
        this.zze = true;
        this.zzg = false;
        this.zzi = true;
        this.zzj = true;
        this.zzk = true;
        this.zzl = false;
        this.zzm = false;
        this.zzn = false;
        this.zzo = 0;
        this.zzp = 0;
        this.zzr = 0L;
        this.zzt = false;
        this.zzu = true;
        this.zzv = false;
        this.zzw = true;
        this.zzz = true;
        this.zzA = 0;
        this.zzC = true;
        this.zzD = 0;
        this.zzE = false;
        this.zzF = true;
        this.zzG = true;
        this.zzH = true;
        this.zzI = 0L;
        this.zzL = false;
        this.zzM = true;
        this.zzN = false;
    }

    public static zze zza(AdvertisingOptions advertisingOptions) {
        zzd zzdVar = new zzd();
        zzdVar.zza(advertisingOptions.getStrategy());
        zzdVar.zzb(advertisingOptions.zza());
        zzdVar.zzc(advertisingOptions.zzb());
        zzdVar.zzd(advertisingOptions.zzc());
        zzdVar.zze(advertisingOptions.zzd());
        zzdVar.zzf(advertisingOptions.zze());
        zzdVar.zzg(advertisingOptions.getLowPower());
        zzdVar.zzh(advertisingOptions.zzf());
        zzdVar.zzi(advertisingOptions.zzg());
        zzdVar.zzj(advertisingOptions.zzh());
        zzdVar.zzk(advertisingOptions.zzi());
        zzdVar.zzl(advertisingOptions.zzj());
        zzdVar.zzm(advertisingOptions.zzk());
        zzdVar.zzn(advertisingOptions.zzl());
        zzdVar.zzo(advertisingOptions.zzm());
        zzdVar.zzp(advertisingOptions.zzn());
        zzdVar.zzq(advertisingOptions.zzo());
        zzdVar.zzr(advertisingOptions.zzp());
        zzdVar.zzs(advertisingOptions.zzq());
        zzdVar.zzt(advertisingOptions.zzr());
        zzdVar.zzu(advertisingOptions.getDisruptiveUpgrade());
        zzdVar.zzv(advertisingOptions.zzs());
        zzdVar.zzw(advertisingOptions.zzt());
        zzdVar.zzz(advertisingOptions.zzw());
        zzdVar.zzA(advertisingOptions.zzx());
        zzdVar.zzB(advertisingOptions.zzy());
        zzdVar.zzC(advertisingOptions.zzz());
        zzdVar.zzD(advertisingOptions.getConnectionType());
        zzdVar.zzE(advertisingOptions.zzA());
        zzdVar.zzF(advertisingOptions.zzB());
        zzdVar.zzG(advertisingOptions.zzC());
        zzdVar.zzH(advertisingOptions.zzD());
        zzdVar.zzI(advertisingOptions.zzE());
        zzdVar.zzJ(advertisingOptions.zzF());
        zzdVar.zzK(advertisingOptions.zzG());
        if (advertisingOptions.zzu() != null) {
            zzdVar.zzx((int[]) Preconditions.checkNotNull(advertisingOptions.zzu()));
        }
        if (advertisingOptions.zzv() != null) {
            zzdVar.zzy((int[]) Preconditions.checkNotNull(advertisingOptions.zzv()));
        }
        return zzdVar.zzL();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zze) {
            zze zzeVar = (zze) obj;
            if (Objects.equals(this.zza, zzeVar.zza) && Objects.equals(Boolean.valueOf(this.zzb), Boolean.valueOf(zzeVar.zzb)) && Objects.equals(Boolean.valueOf(this.zzc), Boolean.valueOf(zzeVar.zzc)) && Objects.equals(Boolean.valueOf(this.zzd), Boolean.valueOf(zzeVar.zzd)) && Objects.equals(Boolean.valueOf(this.zze), Boolean.valueOf(zzeVar.zze)) && Arrays.equals(this.zzf, zzeVar.zzf) && Objects.equals(Boolean.valueOf(this.zzg), Boolean.valueOf(zzeVar.zzg)) && Objects.equals(this.zzh, zzeVar.zzh) && Objects.equals(Boolean.valueOf(this.zzi), Boolean.valueOf(zzeVar.zzi)) && Objects.equals(Boolean.valueOf(this.zzj), Boolean.valueOf(zzeVar.zzj)) && Objects.equals(Boolean.valueOf(this.zzk), Boolean.valueOf(zzeVar.zzk)) && Objects.equals(Boolean.valueOf(this.zzl), Boolean.valueOf(zzeVar.zzl)) && Objects.equals(Boolean.valueOf(this.zzm), Boolean.valueOf(zzeVar.zzm)) && Objects.equals(Boolean.valueOf(this.zzn), Boolean.valueOf(zzeVar.zzn)) && Objects.equals(Integer.valueOf(this.zzo), Integer.valueOf(zzeVar.zzo)) && Objects.equals(Integer.valueOf(this.zzp), Integer.valueOf(zzeVar.zzp)) && Arrays.equals(this.zzq, zzeVar.zzq) && Objects.equals(Long.valueOf(this.zzr), Long.valueOf(zzeVar.zzr)) && Arrays.equals(this.zzs, zzeVar.zzs) && Objects.equals(Boolean.valueOf(this.zzt), Boolean.valueOf(zzeVar.zzt)) && Objects.equals(Boolean.valueOf(this.zzu), Boolean.valueOf(zzeVar.zzu)) && Objects.equals(Boolean.valueOf(this.zzv), Boolean.valueOf(zzeVar.zzv)) && Objects.equals(Boolean.valueOf(this.zzw), Boolean.valueOf(zzeVar.zzw)) && Arrays.equals(this.zzx, zzeVar.zzx) && Arrays.equals(this.zzy, zzeVar.zzy) && Objects.equals(Boolean.valueOf(this.zzz), Boolean.valueOf(zzeVar.zzz)) && Objects.equals(Integer.valueOf(this.zzA), Integer.valueOf(zzeVar.zzA)) && Arrays.equals(this.zzB, zzeVar.zzB) && Objects.equals(Boolean.valueOf(this.zzC), Boolean.valueOf(zzeVar.zzC)) && Objects.equals(Integer.valueOf(this.zzD), Integer.valueOf(zzeVar.zzD)) && Objects.equals(Boolean.valueOf(this.zzE), Boolean.valueOf(zzeVar.zzE)) && Objects.equals(Boolean.valueOf(this.zzF), Boolean.valueOf(zzeVar.zzF)) && Objects.equals(Boolean.valueOf(this.zzG), Boolean.valueOf(zzeVar.zzG)) && Objects.equals(Boolean.valueOf(this.zzH), Boolean.valueOf(zzeVar.zzH)) && Objects.equals(Long.valueOf(this.zzI), Long.valueOf(zzeVar.zzI)) && Objects.equals(this.zzJ, zzeVar.zzJ) && Objects.equals(this.zzK, zzeVar.zzK) && Objects.equals(Boolean.valueOf(this.zzL), Boolean.valueOf(zzeVar.zzL)) && Objects.equals(Boolean.valueOf(this.zzM), Boolean.valueOf(zzeVar.zzM)) && Objects.equals(Boolean.valueOf(this.zzN), Boolean.valueOf(zzeVar.zzN))) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hash(this.zza, Boolean.valueOf(this.zzb), Boolean.valueOf(this.zzc), Boolean.valueOf(this.zzd), Boolean.valueOf(this.zze), Integer.valueOf(Arrays.hashCode(this.zzf)), Boolean.valueOf(this.zzg), this.zzh, Boolean.valueOf(this.zzi), Boolean.valueOf(this.zzj), Boolean.valueOf(this.zzk), Boolean.valueOf(this.zzl), Boolean.valueOf(this.zzm), Boolean.valueOf(this.zzn), Integer.valueOf(this.zzo), Integer.valueOf(this.zzp), Integer.valueOf(Arrays.hashCode(this.zzq)), Long.valueOf(this.zzr), Integer.valueOf(Arrays.hashCode(this.zzs)), Boolean.valueOf(this.zzt), Boolean.valueOf(this.zzu), Boolean.valueOf(this.zzv), Boolean.valueOf(this.zzw), Integer.valueOf(Arrays.hashCode(this.zzx)), Integer.valueOf(Arrays.hashCode(this.zzy)), Boolean.valueOf(this.zzz), Integer.valueOf(this.zzA), Integer.valueOf(Arrays.hashCode(this.zzB)), Boolean.valueOf(this.zzC), Integer.valueOf(this.zzD), Boolean.valueOf(this.zzE), Boolean.valueOf(this.zzF), Boolean.valueOf(this.zzG), Boolean.valueOf(this.zzH), Long.valueOf(this.zzI), this.zzJ, this.zzK, Boolean.valueOf(this.zzL), Boolean.valueOf(this.zzM), Boolean.valueOf(this.zzN));
    }

    public final String toString() {
        Locale locale = Locale.US;
        Strategy strategy = this.zza;
        Boolean boolValueOf = Boolean.valueOf(this.zzb);
        Boolean boolValueOf2 = Boolean.valueOf(this.zzc);
        Boolean boolValueOf3 = Boolean.valueOf(this.zzd);
        Boolean boolValueOf4 = Boolean.valueOf(this.zze);
        byte[] bArr = this.zzf;
        String strZza = bArr == null ? null : com.google.android.gms.nearby.messages.internal.zzc.zza(bArr);
        Boolean boolValueOf5 = Boolean.valueOf(this.zzg);
        ParcelUuid parcelUuid = this.zzh;
        Boolean boolValueOf6 = Boolean.valueOf(this.zzi);
        Boolean boolValueOf7 = Boolean.valueOf(this.zzj);
        Boolean boolValueOf8 = Boolean.valueOf(this.zzk);
        Boolean boolValueOf9 = Boolean.valueOf(this.zzl);
        Boolean boolValueOf10 = Boolean.valueOf(this.zzm);
        Boolean boolValueOf11 = Boolean.valueOf(this.zzn);
        Integer numValueOf = Integer.valueOf(this.zzo);
        Integer numValueOf2 = Integer.valueOf(this.zzp);
        byte[] bArr2 = this.zzq;
        String strZza2 = bArr2 == null ? "null" : com.google.android.gms.nearby.messages.internal.zzc.zza(bArr2);
        Long lValueOf = Long.valueOf(this.zzr);
        String string = Arrays.toString(this.zzs);
        Boolean boolValueOf12 = Boolean.valueOf(this.zzt);
        Boolean boolValueOf13 = Boolean.valueOf(this.zzu);
        Boolean boolValueOf14 = Boolean.valueOf(this.zzw);
        byte[] bArr3 = this.zzB;
        return String.format(locale, "AdvertisingOptions{strategy: %s, autoUpgradeBandwidth: %s, enforceTopologyConstraints: %s, enableBluetooth: %s, enableBle: %s, nearbyNotificationsBeaconData: %s, lowPower: %s, fastAdvertisementServiceUuid: %s, enableWifiLan: %s, enableNfc: %s, enableWifiAware: %s, enableBluetoothListening: %s, enableWebRtcListening: %s, enableUwbRanging: %s, uwbChannel: %d, uwbPreambleIndex: %d, remoteUwbAddress: %s, flowId: %d, uwbSenderInfo: %s, enableOutOfBandConnection: %s, disruptiveUpgrade: %s, useStableIdentifiers: %s, deviceInfo: %s,allowGattConnections: %s, connectionType: %d, enableBleL2capListening: %s, upgradeBandwidthTimeoutMillis: %d, authenticationPassword: %s, customDataElements: %s,skipPayloadInProgressUpdate: %s,allowWifiLanBlockList: %s,isUsbForced: %b}", strategy, boolValueOf, boolValueOf2, boolValueOf3, boolValueOf4, strZza, boolValueOf5, parcelUuid, boolValueOf6, boolValueOf7, boolValueOf8, boolValueOf9, boolValueOf10, boolValueOf11, numValueOf, numValueOf2, strZza2, lValueOf, string, boolValueOf12, boolValueOf13, boolValueOf14, bArr3 == null ? null : com.google.android.gms.nearby.messages.internal.zzc.zza(bArr3), Boolean.valueOf(this.zzC), Integer.valueOf(this.zzD), Boolean.valueOf(this.zzH), Long.valueOf(this.zzI), this.zzJ, this.zzK, Boolean.valueOf(this.zzL), Boolean.valueOf(this.zzM), Boolean.valueOf(this.zzN));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, this.zza, i, false);
        SafeParcelWriter.writeBoolean(parcel, 2, this.zzb);
        SafeParcelWriter.writeBoolean(parcel, 3, this.zzc);
        SafeParcelWriter.writeBoolean(parcel, 4, this.zzd);
        SafeParcelWriter.writeBoolean(parcel, 5, this.zze);
        SafeParcelWriter.writeByteArray(parcel, 6, this.zzf, false);
        SafeParcelWriter.writeBoolean(parcel, 7, this.zzg);
        SafeParcelWriter.writeParcelable(parcel, 8, this.zzh, i, false);
        SafeParcelWriter.writeBoolean(parcel, 9, this.zzi);
        SafeParcelWriter.writeBoolean(parcel, 10, this.zzj);
        SafeParcelWriter.writeBoolean(parcel, 11, this.zzk);
        SafeParcelWriter.writeBoolean(parcel, 12, this.zzl);
        SafeParcelWriter.writeBoolean(parcel, 13, this.zzm);
        SafeParcelWriter.writeBoolean(parcel, 14, this.zzn);
        SafeParcelWriter.writeInt(parcel, 15, this.zzo);
        SafeParcelWriter.writeInt(parcel, 16, this.zzp);
        SafeParcelWriter.writeByteArray(parcel, 17, this.zzq, false);
        SafeParcelWriter.writeLong(parcel, 18, this.zzr);
        SafeParcelWriter.writeTypedArray(parcel, 19, this.zzs, i, false);
        SafeParcelWriter.writeBoolean(parcel, 20, this.zzt);
        SafeParcelWriter.writeBoolean(parcel, 21, this.zzu);
        SafeParcelWriter.writeBoolean(parcel, 22, this.zzv);
        SafeParcelWriter.writeBoolean(parcel, 23, this.zzw);
        SafeParcelWriter.writeIntArray(parcel, 24, this.zzx, false);
        SafeParcelWriter.writeIntArray(parcel, 25, this.zzy, false);
        SafeParcelWriter.writeBoolean(parcel, 26, this.zzz);
        SafeParcelWriter.writeInt(parcel, 27, this.zzA);
        SafeParcelWriter.writeByteArray(parcel, 28, this.zzB, false);
        SafeParcelWriter.writeBoolean(parcel, 29, this.zzC);
        SafeParcelWriter.writeInt(parcel, 30, this.zzD);
        SafeParcelWriter.writeBoolean(parcel, 31, this.zzE);
        SafeParcelWriter.writeBoolean(parcel, 32, this.zzF);
        SafeParcelWriter.writeBoolean(parcel, 33, this.zzG);
        SafeParcelWriter.writeBoolean(parcel, 34, this.zzH);
        SafeParcelWriter.writeLong(parcel, 35, this.zzI);
        SafeParcelWriter.writeString(parcel, 36, this.zzJ, false);
        SafeParcelWriter.writeParcelable(parcel, 37, this.zzK, i, false);
        SafeParcelWriter.writeBoolean(parcel, 38, this.zzL);
        SafeParcelWriter.writeBoolean(parcel, 39, this.zzM);
        SafeParcelWriter.writeBoolean(parcel, 40, this.zzN);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    final /* synthetic */ int[] zzA() {
        return this.zzx;
    }

    final /* synthetic */ void zzB(int[] iArr) {
        this.zzx = iArr;
    }

    final /* synthetic */ int[] zzC() {
        return this.zzy;
    }

    final /* synthetic */ void zzD(int[] iArr) {
        this.zzy = iArr;
    }

    final /* synthetic */ void zzE(boolean z) {
        this.zzz = z;
    }

    final /* synthetic */ int zzF() {
        return this.zzA;
    }

    final /* synthetic */ void zzG(int i) {
        this.zzA = i;
    }

    final /* synthetic */ void zzH(byte[] bArr) {
        this.zzB = bArr;
    }

    final /* synthetic */ void zzI(boolean z) {
        this.zzC = z;
    }

    final /* synthetic */ int zzJ() {
        return this.zzD;
    }

    final /* synthetic */ void zzK(int i) {
        this.zzD = i;
    }

    final /* synthetic */ void zzL(boolean z) {
        this.zzE = z;
    }

    final /* synthetic */ void zzM(boolean z) {
        this.zzF = z;
    }

    final /* synthetic */ void zzN(boolean z) {
        this.zzG = z;
    }

    final /* synthetic */ void zzO(boolean z) {
        this.zzH = z;
    }

    final /* synthetic */ void zzP(long j) {
        this.zzI = j;
    }

    final /* synthetic */ void zzQ(boolean z) {
        this.zzL = z;
    }

    final /* synthetic */ void zzR(boolean z) {
        this.zzM = z;
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

    final /* synthetic */ void zzf(boolean z) {
        this.zze = z;
    }

    final /* synthetic */ void zzg(byte[] bArr) {
        this.zzf = bArr;
    }

    final /* synthetic */ boolean zzh() {
        return this.zzg;
    }

    final /* synthetic */ void zzi(boolean z) {
        this.zzg = z;
    }

    final /* synthetic */ void zzj(ParcelUuid parcelUuid) {
        this.zzh = parcelUuid;
    }

    final /* synthetic */ void zzk(boolean z) {
        this.zzi = z;
    }

    final /* synthetic */ void zzl(boolean z) {
        this.zzj = z;
    }

    final /* synthetic */ void zzm(boolean z) {
        this.zzk = z;
    }

    final /* synthetic */ void zzn(boolean z) {
        this.zzl = z;
    }

    final /* synthetic */ void zzo(boolean z) {
        this.zzm = z;
    }

    final /* synthetic */ void zzp(boolean z) {
        this.zzn = z;
    }

    final /* synthetic */ void zzq(int i) {
        this.zzo = i;
    }

    final /* synthetic */ void zzr(int i) {
        this.zzp = i;
    }

    final /* synthetic */ void zzs(byte[] bArr) {
        this.zzq = bArr;
    }

    final /* synthetic */ void zzt(long j) {
        this.zzr = j;
    }

    final /* synthetic */ void zzu(com.google.android.gms.nearby.connection.zzz[] zzzVarArr) {
        this.zzs = zzzVarArr;
    }

    final /* synthetic */ void zzv(boolean z) {
        this.zzt = z;
    }

    final /* synthetic */ boolean zzw() {
        return this.zzu;
    }

    final /* synthetic */ void zzx(boolean z) {
        this.zzu = z;
    }

    final /* synthetic */ void zzy(boolean z) {
        this.zzv = z;
    }

    final /* synthetic */ void zzz(boolean z) {
        this.zzw = z;
    }

    zze(Strategy strategy, boolean z, boolean z2, boolean z3, boolean z4, byte[] bArr, boolean z5, ParcelUuid parcelUuid, boolean z6, boolean z7, boolean z8, boolean z9, boolean z10, boolean z11, int i, int i2, byte[] bArr2, long j, com.google.android.gms.nearby.connection.zzz[] zzzVarArr, boolean z12, boolean z13, boolean z14, boolean z15, int[] iArr, int[] iArr2, boolean z16, int i3, byte[] bArr3, boolean z17, int i4, boolean z18, boolean z19, boolean z20, boolean z21, long j2, String str, com.google.android.gms.internal.nearby.zzy zzyVar, boolean z22, boolean z23, boolean z24) {
        this.zza = strategy;
        this.zzb = z;
        this.zzc = z2;
        this.zzd = z3;
        this.zze = z4;
        this.zzf = bArr;
        this.zzg = z5;
        this.zzh = parcelUuid;
        this.zzi = z6;
        this.zzj = z7;
        this.zzk = z8;
        this.zzl = z9;
        this.zzm = z10;
        this.zzn = z11;
        this.zzo = i;
        this.zzp = i2;
        this.zzq = bArr2;
        this.zzr = j;
        this.zzs = zzzVarArr;
        this.zzt = z12;
        this.zzu = z13;
        this.zzv = z14;
        this.zzw = z15;
        this.zzx = iArr;
        this.zzy = iArr2;
        this.zzz = z16;
        this.zzA = i3;
        this.zzB = bArr3;
        this.zzC = z17;
        this.zzD = i4;
        this.zzE = z18;
        this.zzF = z19;
        this.zzG = z20;
        this.zzH = z21;
        this.zzI = j2;
        this.zzJ = str;
        this.zzK = zzyVar;
        this.zzL = z22;
        this.zzM = z23;
        this.zzN = z24;
    }

    /* synthetic */ zze(byte[] bArr) {
        this.zzb = true;
        this.zzc = true;
        this.zzd = true;
        this.zze = true;
        this.zzg = false;
        this.zzi = true;
        this.zzj = true;
        this.zzk = true;
        this.zzl = false;
        this.zzm = false;
        this.zzn = false;
        this.zzo = 0;
        this.zzp = 0;
        this.zzr = 0L;
        this.zzt = false;
        this.zzu = true;
        this.zzv = false;
        this.zzw = true;
        this.zzz = true;
        this.zzA = 0;
        this.zzC = true;
        this.zzD = 0;
        this.zzE = false;
        this.zzF = true;
        this.zzG = true;
        this.zzH = true;
        this.zzI = 0L;
        this.zzL = false;
        this.zzM = true;
        this.zzN = false;
    }
}
