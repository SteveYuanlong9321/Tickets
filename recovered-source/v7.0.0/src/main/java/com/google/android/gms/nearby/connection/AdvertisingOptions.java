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
public final class AdvertisingOptions extends AbstractSafeParcelable {
    public static final Parcelable.Creator<AdvertisingOptions> CREATOR = new zzb();
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
    private boolean zzJ;
    private boolean zzK;
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
    private zzz[] zzs;
    private boolean zzt;

    @Deprecated
    private boolean zzu;
    private boolean zzv;
    private boolean zzw;
    private int[] zzx;
    private int[] zzy;
    private boolean zzz;

    /* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
    public static final class Builder {
        private final AdvertisingOptions zza;

        public Builder() {
            this.zza = new AdvertisingOptions((byte[]) null);
        }

        /* JADX WARN: Code duplicated, block: B:28:0x0071  */
        public AdvertisingOptions build() {
            AdvertisingOptions advertisingOptions = this.zza;
            int[] iArrZzaB = advertisingOptions.zzaB();
            if (iArrZzaB != null && iArrZzaB.length > 0) {
                advertisingOptions.zzQ(false);
                advertisingOptions.zzO(false);
                advertisingOptions.zzaa(false);
                advertisingOptions.zzac(false);
                advertisingOptions.zzY(false);
                advertisingOptions.zzag(false);
                for (int i : iArrZzaB) {
                    if (i == 2) {
                        advertisingOptions.zzO(true);
                    } else if (i == 9) {
                        advertisingOptions.zzag(true);
                    } else if (i == 4) {
                        advertisingOptions.zzQ(true);
                    } else if (i == 5) {
                        advertisingOptions.zzY(true);
                    } else if (i == 6) {
                        advertisingOptions.zzac(true);
                    } else if (i == 7) {
                        advertisingOptions.zzaa(true);
                    } else if (i != 11) {
                        if (i != 12) {
                            StringBuilder sb = new StringBuilder(String.valueOf(i).length() + 27);
                            sb.append("Illegal advertising medium ");
                            sb.append(i);
                            Log.d("NearbyConnections", sb.toString());
                        } else {
                            advertisingOptions.zzag(true);
                        }
                    }
                }
            }
            if (advertisingOptions.zzaD() != null && advertisingOptions.zzaD().length > 0) {
                advertisingOptions.zzay(false);
                for (int i2 = 0; i2 < advertisingOptions.zzaD().length; i2++) {
                    if (advertisingOptions.zzaD()[i2] == 9 || advertisingOptions.zzaD()[i2] == 12) {
                        advertisingOptions.zzay(true);
                        break;
                    }
                }
            }
            if (advertisingOptions.zzaH() == 0) {
                advertisingOptions.zzaI(true == advertisingOptions.zzT() ? 1 : 3);
            } else {
                advertisingOptions.zzU(advertisingOptions.zzaH() != 3);
            }
            if (advertisingOptions.zzaN() != 0) {
                advertisingOptions.zzaw(advertisingOptions.zzaN() == 1);
                return advertisingOptions;
            }
            if (!advertisingOptions.zzav()) {
                advertisingOptions.zzaO(2);
            }
            return advertisingOptions;
        }

        public Builder setConnectionType(int i) {
            this.zza.zzaO(i);
            return this;
        }

        @Deprecated
        public Builder setDisruptiveUpgrade(boolean z) {
            this.zza.zzaw(z);
            return this;
        }

        public Builder setLowPower(boolean z) {
            this.zza.zzU(z);
            return this;
        }

        public Builder setStrategy(Strategy strategy) {
            this.zza.zzI(strategy);
            return this;
        }

        public Builder(AdvertisingOptions advertisingOptions) {
            AdvertisingOptions advertisingOptions2 = new AdvertisingOptions((byte[]) null);
            this.zza = advertisingOptions2;
            advertisingOptions2.zzI(advertisingOptions.zzH());
            advertisingOptions2.zzK(advertisingOptions.zzJ());
            advertisingOptions2.zzM(advertisingOptions.zzL());
            advertisingOptions2.zzO(advertisingOptions.zzN());
            advertisingOptions2.zzQ(advertisingOptions.zzP());
            advertisingOptions2.zzS(advertisingOptions.zzR());
            advertisingOptions2.zzU(advertisingOptions.zzT());
            advertisingOptions2.zzW(advertisingOptions.zzV());
            advertisingOptions2.zzY(advertisingOptions.zzX());
            advertisingOptions2.zzaa(advertisingOptions.zzZ());
            advertisingOptions2.zzac(advertisingOptions.zzab());
            advertisingOptions2.zzae(advertisingOptions.zzad());
            advertisingOptions2.zzag(advertisingOptions.zzaf());
            advertisingOptions2.zzai(advertisingOptions.zzah());
            advertisingOptions2.zzak(advertisingOptions.zzaj());
            advertisingOptions2.zzam(advertisingOptions.zzal());
            advertisingOptions2.zzao(advertisingOptions.zzan());
            advertisingOptions2.zzaq(advertisingOptions.zzap());
            advertisingOptions2.zzas(advertisingOptions.zzar());
            advertisingOptions2.zzau(advertisingOptions.zzat());
            advertisingOptions2.zzaw(advertisingOptions.zzav());
            advertisingOptions2.zzay(advertisingOptions.zzax());
            advertisingOptions2.zzaA(advertisingOptions.zzaz());
            advertisingOptions2.zzaC(advertisingOptions.zzaB());
            advertisingOptions2.zzaE(advertisingOptions.zzaD());
            advertisingOptions2.zzaG(advertisingOptions.zzaF());
            advertisingOptions2.zzaI(advertisingOptions.zzaH());
            advertisingOptions2.zzaK(advertisingOptions.zzaJ());
            advertisingOptions2.zzaM(advertisingOptions.zzaL());
            advertisingOptions2.zzaO(advertisingOptions.zzaN());
            advertisingOptions2.zzaQ(advertisingOptions.zzaP());
            advertisingOptions2.zzaS(advertisingOptions.zzaR());
            advertisingOptions2.zzaU(advertisingOptions.zzaT());
            advertisingOptions2.zzaW(advertisingOptions.zzaV());
            advertisingOptions2.zzaY(advertisingOptions.zzaX());
            advertisingOptions2.zzba(advertisingOptions.zzaZ());
            advertisingOptions2.zzbc(advertisingOptions.zzbb());
        }
    }

    private AdvertisingOptions() {
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
        this.zzJ = false;
        this.zzK = true;
    }

    public static String convertConnectionTypeToString(int i) {
        if (i == 0) {
            return "BALANCED";
        }
        if (i == 1) {
            return "DISRUPTIVE";
        }
        if (i == 2) {
            return "NON_DISRUPTIVE";
        }
        StringBuilder sb = new StringBuilder(String.valueOf(i).length() + 25);
        sb.append("UNKNOWN_CONNECTION_TYPE(");
        sb.append(i);
        sb.append(")");
        return sb.toString();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AdvertisingOptions) {
            AdvertisingOptions advertisingOptions = (AdvertisingOptions) obj;
            if (Objects.equal(this.zza, advertisingOptions.zza) && Objects.equal(Boolean.valueOf(this.zzb), Boolean.valueOf(advertisingOptions.zzb)) && Objects.equal(Boolean.valueOf(this.zzc), Boolean.valueOf(advertisingOptions.zzc)) && Objects.equal(Boolean.valueOf(this.zzd), Boolean.valueOf(advertisingOptions.zzd)) && Objects.equal(Boolean.valueOf(this.zze), Boolean.valueOf(advertisingOptions.zze)) && Arrays.equals(this.zzf, advertisingOptions.zzf) && Objects.equal(Boolean.valueOf(this.zzg), Boolean.valueOf(advertisingOptions.zzg)) && Objects.equal(this.zzh, advertisingOptions.zzh) && Objects.equal(Boolean.valueOf(this.zzi), Boolean.valueOf(advertisingOptions.zzi)) && Objects.equal(Boolean.valueOf(this.zzj), Boolean.valueOf(advertisingOptions.zzj)) && Objects.equal(Boolean.valueOf(this.zzk), Boolean.valueOf(advertisingOptions.zzk)) && Objects.equal(Boolean.valueOf(this.zzl), Boolean.valueOf(advertisingOptions.zzl)) && Objects.equal(Boolean.valueOf(this.zzm), Boolean.valueOf(advertisingOptions.zzm)) && Objects.equal(Boolean.valueOf(this.zzn), Boolean.valueOf(advertisingOptions.zzn)) && Objects.equal(Integer.valueOf(this.zzo), Integer.valueOf(advertisingOptions.zzo)) && Objects.equal(Integer.valueOf(this.zzp), Integer.valueOf(advertisingOptions.zzp)) && Arrays.equals(this.zzq, advertisingOptions.zzq) && Objects.equal(Long.valueOf(this.zzr), Long.valueOf(advertisingOptions.zzr)) && Arrays.equals(this.zzs, advertisingOptions.zzs) && Objects.equal(Boolean.valueOf(this.zzt), Boolean.valueOf(advertisingOptions.zzt)) && Objects.equal(Boolean.valueOf(this.zzu), Boolean.valueOf(advertisingOptions.zzu)) && Objects.equal(Boolean.valueOf(this.zzv), Boolean.valueOf(advertisingOptions.zzv)) && Objects.equal(Boolean.valueOf(this.zzw), Boolean.valueOf(advertisingOptions.zzw)) && Arrays.equals(this.zzx, advertisingOptions.zzx) && Arrays.equals(this.zzy, advertisingOptions.zzy) && Objects.equal(Boolean.valueOf(this.zzz), Boolean.valueOf(advertisingOptions.zzz)) && Objects.equal(Integer.valueOf(this.zzA), Integer.valueOf(advertisingOptions.zzA)) && Arrays.equals(this.zzB, advertisingOptions.zzB) && Objects.equal(Boolean.valueOf(this.zzC), Boolean.valueOf(advertisingOptions.zzC)) && Objects.equal(Integer.valueOf(this.zzD), Integer.valueOf(advertisingOptions.zzD)) && Objects.equal(Boolean.valueOf(this.zzE), Boolean.valueOf(advertisingOptions.zzE)) && Objects.equal(Boolean.valueOf(this.zzF), Boolean.valueOf(advertisingOptions.zzF)) && Objects.equal(Boolean.valueOf(this.zzG), Boolean.valueOf(advertisingOptions.zzG)) && Objects.equal(Boolean.valueOf(this.zzH), Boolean.valueOf(advertisingOptions.zzH)) && Objects.equal(Long.valueOf(this.zzI), Long.valueOf(advertisingOptions.zzI)) && Objects.equal(Boolean.valueOf(this.zzJ), Boolean.valueOf(advertisingOptions.zzJ)) && Objects.equal(Boolean.valueOf(this.zzK), Boolean.valueOf(advertisingOptions.zzK))) {
                return true;
            }
        }
        return false;
    }

    public int getConnectionType() {
        return this.zzD;
    }

    @Deprecated
    public boolean getDisruptiveUpgrade() {
        return this.zzu;
    }

    public boolean getLowPower() {
        return this.zzg;
    }

    public Strategy getStrategy() {
        return this.zza;
    }

    public int hashCode() {
        return Objects.hashCode(this.zza, Boolean.valueOf(this.zzb), Boolean.valueOf(this.zzc), Boolean.valueOf(this.zzd), Boolean.valueOf(this.zze), Integer.valueOf(Arrays.hashCode(this.zzf)), Boolean.valueOf(this.zzg), this.zzh, Boolean.valueOf(this.zzi), Boolean.valueOf(this.zzj), Boolean.valueOf(this.zzk), Boolean.valueOf(this.zzl), Boolean.valueOf(this.zzm), Boolean.valueOf(this.zzn), Integer.valueOf(this.zzo), Integer.valueOf(this.zzp), Integer.valueOf(Arrays.hashCode(this.zzq)), Long.valueOf(this.zzr), Integer.valueOf(Arrays.hashCode(this.zzs)), Boolean.valueOf(this.zzt), Boolean.valueOf(this.zzu), Boolean.valueOf(this.zzv), Boolean.valueOf(this.zzw), Integer.valueOf(Arrays.hashCode(this.zzx)), Integer.valueOf(Arrays.hashCode(this.zzy)), Boolean.valueOf(this.zzz), Integer.valueOf(this.zzA), Integer.valueOf(Arrays.hashCode(this.zzB)), Boolean.valueOf(this.zzC), Integer.valueOf(this.zzD), Boolean.valueOf(this.zzE), Boolean.valueOf(this.zzF), Boolean.valueOf(this.zzG), Boolean.valueOf(this.zzH), Long.valueOf(this.zzI), Boolean.valueOf(this.zzJ), Boolean.valueOf(this.zzK));
    }

    public String toString() {
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
        return String.format(locale, "AdvertisingOptions{strategy: %s, autoUpgradeBandwidth: %s, enforceTopologyConstraints: %s, enableBluetooth: %s, enableBle: %s, nearbyNotificationsBeaconData: %s, lowPower: %s, fastAdvertisementServiceUuid: %s, enableWifiLan: %s, enableNfc: %s, enableWifiAware: %s, enableBluetoothListening: %s, enableWebRtcListening: %s, enableUwbRanging: %s, uwbChannel: %d, uwbPreambleIndex: %d, remoteUwbAddress: %s, flowId: %d, uwbSenderInfo: %s, enableOutOfBandConnection: %s, disruptiveUpgrade: %s, useStableIdentifiers: %s, deviceInfo: %s,allowGattConnections: %s, connectionType: %d, enableBleL2capListening: %s, upgradeBandwidthTimeoutMillis: %d,skipPayloadInProgressUpdate: %s,allowWifiLanBlockList: %s}", strategy, boolValueOf, boolValueOf2, boolValueOf3, boolValueOf4, strZza, boolValueOf5, parcelUuid, boolValueOf6, boolValueOf7, boolValueOf8, boolValueOf9, boolValueOf10, boolValueOf11, numValueOf, numValueOf2, strZza2, lValueOf, string, boolValueOf12, boolValueOf13, boolValueOf14, bArr3 == null ? null : com.google.android.gms.nearby.messages.internal.zzc.zza(bArr3), Boolean.valueOf(this.zzC), Integer.valueOf(this.zzD), Boolean.valueOf(this.zzH), Long.valueOf(this.zzI), Boolean.valueOf(this.zzJ), Boolean.valueOf(this.zzK));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, getStrategy(), i, false);
        SafeParcelWriter.writeBoolean(parcel, 2, this.zzb);
        SafeParcelWriter.writeBoolean(parcel, 3, this.zzc);
        SafeParcelWriter.writeBoolean(parcel, 4, this.zzd);
        SafeParcelWriter.writeBoolean(parcel, 5, this.zze);
        SafeParcelWriter.writeByteArray(parcel, 6, this.zzf, false);
        SafeParcelWriter.writeBoolean(parcel, 7, getLowPower());
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
        SafeParcelWriter.writeBoolean(parcel, 21, getDisruptiveUpgrade());
        SafeParcelWriter.writeBoolean(parcel, 22, this.zzv);
        SafeParcelWriter.writeBoolean(parcel, 23, this.zzw);
        SafeParcelWriter.writeIntArray(parcel, 24, this.zzx, false);
        SafeParcelWriter.writeIntArray(parcel, 25, this.zzy, false);
        SafeParcelWriter.writeBoolean(parcel, 26, this.zzz);
        SafeParcelWriter.writeInt(parcel, 27, this.zzA);
        SafeParcelWriter.writeByteArray(parcel, 28, this.zzB, false);
        SafeParcelWriter.writeBoolean(parcel, 29, this.zzC);
        SafeParcelWriter.writeInt(parcel, 30, getConnectionType());
        SafeParcelWriter.writeBoolean(parcel, 31, this.zzE);
        SafeParcelWriter.writeBoolean(parcel, 32, this.zzF);
        SafeParcelWriter.writeBoolean(parcel, 33, this.zzG);
        SafeParcelWriter.writeBoolean(parcel, 34, this.zzH);
        SafeParcelWriter.writeLong(parcel, 35, this.zzI);
        SafeParcelWriter.writeBoolean(parcel, 36, this.zzJ);
        SafeParcelWriter.writeBoolean(parcel, 37, this.zzK);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    @Deprecated
    public final boolean zzA() {
        return this.zzE;
    }

    public final boolean zzB() {
        return this.zzF;
    }

    public final boolean zzC() {
        return this.zzG;
    }

    public final boolean zzD() {
        return this.zzH;
    }

    public final long zzE() {
        return this.zzI;
    }

    public final boolean zzF() {
        return this.zzJ;
    }

    public final boolean zzG() {
        return this.zzK;
    }

    final /* synthetic */ Strategy zzH() {
        return this.zza;
    }

    final /* synthetic */ void zzI(Strategy strategy) {
        this.zza = strategy;
    }

    final /* synthetic */ boolean zzJ() {
        return this.zzb;
    }

    final /* synthetic */ void zzK(boolean z) {
        this.zzb = z;
    }

    final /* synthetic */ boolean zzL() {
        return this.zzc;
    }

    final /* synthetic */ void zzM(boolean z) {
        this.zzc = z;
    }

    final /* synthetic */ boolean zzN() {
        return this.zzd;
    }

    final /* synthetic */ void zzO(boolean z) {
        this.zzd = z;
    }

    final /* synthetic */ boolean zzP() {
        return this.zze;
    }

    final /* synthetic */ void zzQ(boolean z) {
        this.zze = z;
    }

    final /* synthetic */ byte[] zzR() {
        return this.zzf;
    }

    final /* synthetic */ void zzS(byte[] bArr) {
        this.zzf = bArr;
    }

    final /* synthetic */ boolean zzT() {
        return this.zzg;
    }

    final /* synthetic */ void zzU(boolean z) {
        this.zzg = z;
    }

    final /* synthetic */ ParcelUuid zzV() {
        return this.zzh;
    }

    final /* synthetic */ void zzW(ParcelUuid parcelUuid) {
        this.zzh = parcelUuid;
    }

    final /* synthetic */ boolean zzX() {
        return this.zzi;
    }

    final /* synthetic */ void zzY(boolean z) {
        this.zzi = z;
    }

    final /* synthetic */ boolean zzZ() {
        return this.zzj;
    }

    public final boolean zza() {
        return this.zzb;
    }

    final /* synthetic */ void zzaA(boolean z) {
        this.zzw = z;
    }

    final /* synthetic */ int[] zzaB() {
        return this.zzx;
    }

    final /* synthetic */ void zzaC(int[] iArr) {
        this.zzx = iArr;
    }

    final /* synthetic */ int[] zzaD() {
        return this.zzy;
    }

    final /* synthetic */ void zzaE(int[] iArr) {
        this.zzy = iArr;
    }

    final /* synthetic */ boolean zzaF() {
        return this.zzz;
    }

    final /* synthetic */ void zzaG(boolean z) {
        this.zzz = z;
    }

    final /* synthetic */ int zzaH() {
        return this.zzA;
    }

    final /* synthetic */ void zzaI(int i) {
        this.zzA = i;
    }

    final /* synthetic */ byte[] zzaJ() {
        return this.zzB;
    }

    final /* synthetic */ void zzaK(byte[] bArr) {
        this.zzB = bArr;
    }

    final /* synthetic */ boolean zzaL() {
        return this.zzC;
    }

    final /* synthetic */ void zzaM(boolean z) {
        this.zzC = z;
    }

    final /* synthetic */ int zzaN() {
        return this.zzD;
    }

    final /* synthetic */ void zzaO(int i) {
        this.zzD = i;
    }

    final /* synthetic */ boolean zzaP() {
        return this.zzE;
    }

    final /* synthetic */ void zzaQ(boolean z) {
        this.zzE = z;
    }

    final /* synthetic */ boolean zzaR() {
        return this.zzF;
    }

    final /* synthetic */ void zzaS(boolean z) {
        this.zzF = z;
    }

    final /* synthetic */ boolean zzaT() {
        return this.zzG;
    }

    final /* synthetic */ void zzaU(boolean z) {
        this.zzG = z;
    }

    final /* synthetic */ boolean zzaV() {
        return this.zzH;
    }

    final /* synthetic */ void zzaW(boolean z) {
        this.zzH = z;
    }

    final /* synthetic */ long zzaX() {
        return this.zzI;
    }

    final /* synthetic */ void zzaY(long j) {
        this.zzI = j;
    }

    final /* synthetic */ boolean zzaZ() {
        return this.zzJ;
    }

    final /* synthetic */ void zzaa(boolean z) {
        this.zzj = z;
    }

    final /* synthetic */ boolean zzab() {
        return this.zzk;
    }

    final /* synthetic */ void zzac(boolean z) {
        this.zzk = z;
    }

    final /* synthetic */ boolean zzad() {
        return this.zzl;
    }

    final /* synthetic */ void zzae(boolean z) {
        this.zzl = z;
    }

    final /* synthetic */ boolean zzaf() {
        return this.zzm;
    }

    final /* synthetic */ void zzag(boolean z) {
        this.zzm = z;
    }

    final /* synthetic */ boolean zzah() {
        return this.zzn;
    }

    final /* synthetic */ void zzai(boolean z) {
        this.zzn = z;
    }

    final /* synthetic */ int zzaj() {
        return this.zzo;
    }

    final /* synthetic */ void zzak(int i) {
        this.zzo = i;
    }

    final /* synthetic */ int zzal() {
        return this.zzp;
    }

    final /* synthetic */ void zzam(int i) {
        this.zzp = i;
    }

    final /* synthetic */ byte[] zzan() {
        return this.zzq;
    }

    final /* synthetic */ void zzao(byte[] bArr) {
        this.zzq = bArr;
    }

    final /* synthetic */ long zzap() {
        return this.zzr;
    }

    final /* synthetic */ void zzaq(long j) {
        this.zzr = j;
    }

    final /* synthetic */ zzz[] zzar() {
        return this.zzs;
    }

    final /* synthetic */ void zzas(zzz[] zzzVarArr) {
        this.zzs = zzzVarArr;
    }

    final /* synthetic */ boolean zzat() {
        return this.zzt;
    }

    final /* synthetic */ void zzau(boolean z) {
        this.zzt = z;
    }

    final /* synthetic */ boolean zzav() {
        return this.zzu;
    }

    final /* synthetic */ void zzaw(boolean z) {
        this.zzu = z;
    }

    final /* synthetic */ boolean zzax() {
        return this.zzv;
    }

    final /* synthetic */ void zzay(boolean z) {
        this.zzv = z;
    }

    final /* synthetic */ boolean zzaz() {
        return this.zzw;
    }

    public final boolean zzb() {
        return this.zzc;
    }

    final /* synthetic */ void zzba(boolean z) {
        this.zzJ = z;
    }

    final /* synthetic */ boolean zzbb() {
        return this.zzK;
    }

    final /* synthetic */ void zzbc(boolean z) {
        this.zzK = z;
    }

    public final boolean zzc() {
        return this.zzd;
    }

    public final boolean zzd() {
        return this.zze;
    }

    public final byte[] zze() {
        return this.zzf;
    }

    public final ParcelUuid zzf() {
        return this.zzh;
    }

    public final boolean zzg() {
        return this.zzi;
    }

    public final boolean zzh() {
        return this.zzj;
    }

    public final boolean zzi() {
        return this.zzk;
    }

    public final boolean zzj() {
        return this.zzl;
    }

    public final boolean zzk() {
        return this.zzm;
    }

    public final boolean zzl() {
        return this.zzn;
    }

    public final int zzm() {
        return this.zzo;
    }

    public final int zzn() {
        return this.zzp;
    }

    public final byte[] zzo() {
        return this.zzq;
    }

    public final long zzp() {
        return this.zzr;
    }

    public final zzz[] zzq() {
        return this.zzs;
    }

    public final boolean zzr() {
        return this.zzt;
    }

    public final boolean zzs() {
        return this.zzv;
    }

    public final boolean zzt() {
        return this.zzw;
    }

    public final int[] zzu() {
        return this.zzx;
    }

    public final int[] zzv() {
        return this.zzy;
    }

    public final boolean zzw() {
        return this.zzz;
    }

    public final int zzx() {
        return this.zzA;
    }

    public final byte[] zzy() {
        return this.zzB;
    }

    public final boolean zzz() {
        return this.zzC;
    }

    @Deprecated
    public AdvertisingOptions(Strategy strategy) {
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
        this.zzJ = false;
        this.zzK = true;
        this.zza = strategy;
    }

    AdvertisingOptions(Strategy strategy, boolean z, boolean z2, boolean z3, boolean z4, byte[] bArr, boolean z5, ParcelUuid parcelUuid, boolean z6, boolean z7, boolean z8, boolean z9, boolean z10, boolean z11, int i, int i2, byte[] bArr2, long j, zzz[] zzzVarArr, boolean z12, boolean z13, boolean z14, boolean z15, int[] iArr, int[] iArr2, boolean z16, int i3, byte[] bArr3, boolean z17, int i4, boolean z18, boolean z19, boolean z20, boolean z21, long j2, boolean z22, boolean z23) {
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
        this.zzJ = z22;
        this.zzK = z23;
    }

    /* synthetic */ AdvertisingOptions(byte[] bArr) {
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
        this.zzJ = false;
        this.zzK = true;
    }
}
