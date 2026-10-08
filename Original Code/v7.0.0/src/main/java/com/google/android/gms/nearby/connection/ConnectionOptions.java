package com.google.android.gms.nearby.connection;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.util.PlatformVersion;
import java.util.Arrays;
import java.util.Locale;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class ConnectionOptions extends AbstractSafeParcelable {
    public static final Parcelable.Creator<ConnectionOptions> CREATOR = new zzn();
    private boolean zza;
    private boolean zzb;
    private boolean zzc;
    private boolean zzd;
    private boolean zze;
    private boolean zzf;
    private boolean zzg;
    private boolean zzh;
    private byte[] zzi;
    private boolean zzj;
    private boolean zzk;

    @Deprecated
    private boolean zzl;
    private int zzm;
    private int zzn;
    private int[] zzo;
    private int[] zzp;
    private byte[] zzq;
    private Strategy zzr;
    private int zzs;
    private long zzt;

    @Deprecated
    private boolean zzu;
    private boolean zzv;
    private boolean zzw;
    private boolean zzx;
    private boolean zzy;

    /* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
    public static final class Builder {
        private final ConnectionOptions zza;

        public Builder() {
            this.zza = new ConnectionOptions(null);
        }

        public ConnectionOptions build() {
            ConnectionOptions connectionOptions = this.zza;
            ConnectionOptions.zzw(connectionOptions);
            if (connectionOptions.zzah() != 0) {
                connectionOptions.zzU(connectionOptions.zzah() == 1);
                return connectionOptions;
            }
            if (!connectionOptions.zzT()) {
                connectionOptions.zzai(2);
            }
            return connectionOptions;
        }

        public Builder setConnectionType(int i) {
            this.zza.zzai(i);
            return this;
        }

        @Deprecated
        public Builder setDisruptiveUpgrade(boolean z) {
            this.zza.zzU(z);
            return this;
        }

        public Builder setLowPower(boolean z) {
            this.zza.zzy(z);
            return this;
        }

        public Builder(ConnectionOptions connectionOptions) {
            ConnectionOptions connectionOptions2 = new ConnectionOptions(null);
            this.zza = connectionOptions2;
            connectionOptions2.zzy(connectionOptions.zzx());
            connectionOptions2.zzA(connectionOptions.zzz());
            connectionOptions2.zzC(connectionOptions.zzB());
            connectionOptions2.zzE(connectionOptions.zzD());
            connectionOptions2.zzG(connectionOptions.zzF());
            connectionOptions2.zzI(connectionOptions.zzH());
            connectionOptions2.zzK(connectionOptions.zzJ());
            connectionOptions2.zzM(connectionOptions.zzL());
            connectionOptions2.zzO(connectionOptions.zzN());
            connectionOptions2.zzQ(connectionOptions.zzP());
            connectionOptions2.zzS(connectionOptions.zzR());
            connectionOptions2.zzU(connectionOptions.zzT());
            connectionOptions2.zzW(connectionOptions.zzV());
            connectionOptions2.zzY(connectionOptions.zzX());
            connectionOptions2.zzaa(connectionOptions.zzZ());
            connectionOptions2.zzac(connectionOptions.zzab());
            connectionOptions2.zzae(connectionOptions.zzad());
            connectionOptions2.zzag(connectionOptions.zzaf());
            connectionOptions2.zzai(connectionOptions.zzah());
            connectionOptions2.zzak(connectionOptions.zzaj());
            connectionOptions2.zzam(connectionOptions.zzal());
            connectionOptions2.zzao(connectionOptions.zzan());
            connectionOptions2.zzaq(connectionOptions.zzap());
            connectionOptions2.zzas(connectionOptions.zzar());
            connectionOptions2.zzau(connectionOptions.zzat());
        }
    }

    private ConnectionOptions() {
        this.zza = false;
        this.zzb = true;
        this.zzc = true;
        this.zzd = true;
        this.zze = true;
        this.zzf = true;
        this.zzg = true;
        this.zzh = true;
        this.zzj = false;
        this.zzk = true;
        this.zzl = true;
        this.zzm = 0;
        this.zzn = 0;
        this.zzs = 0;
        this.zzt = 0L;
        this.zzu = false;
        this.zzv = true;
        this.zzw = true;
        this.zzx = false;
        this.zzy = true;
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

    private static void zzav(int i, ConnectionOptions connectionOptions) {
        switch (i) {
            case 2:
                connectionOptions.zzb = true;
                break;
            case 3:
                connectionOptions.zzg = true;
                break;
            case 4:
                connectionOptions.zzc = true;
                break;
            case 5:
                connectionOptions.zzd = true;
                break;
            case 6:
                connectionOptions.zzf = true;
                break;
            case 7:
                connectionOptions.zze = true;
                break;
            case 8:
                connectionOptions.zzh = true;
                break;
            case 9:
            case 12:
                connectionOptions.zzj = true;
                break;
            case 10:
            case 11:
                break;
            default:
                StringBuilder sb = new StringBuilder(String.valueOf(i).length() + 26);
                sb.append("Illegal connection medium ");
                sb.append(i);
                Log.d("NearbyConnections", sb.toString());
                break;
        }
    }

    static /* synthetic */ void zzw(ConnectionOptions connectionOptions) {
        int[] iArr = connectionOptions.zzp;
        int[] iArr2 = connectionOptions.zzo;
        if (iArr != null && iArr.length > 0) {
            connectionOptions.zzc = false;
            connectionOptions.zzb = false;
            connectionOptions.zze = false;
            if (PlatformVersion.isAtLeastP()) {
                connectionOptions.zzd = false;
            }
        }
        if (iArr2 != null) {
            connectionOptions.zzg = false;
            connectionOptions.zzf = false;
            connectionOptions.zzh = false;
            if (!PlatformVersion.isAtLeastP()) {
                connectionOptions.zzd = false;
            }
        }
        if (iArr != null) {
            for (int i : iArr) {
                zzav(i, connectionOptions);
            }
        }
        if (iArr2 != null) {
            for (int i2 : iArr2) {
                zzav(i2, connectionOptions);
            }
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ConnectionOptions) {
            ConnectionOptions connectionOptions = (ConnectionOptions) obj;
            if (Objects.equal(Boolean.valueOf(this.zza), Boolean.valueOf(connectionOptions.zza)) && Objects.equal(Boolean.valueOf(this.zzb), Boolean.valueOf(connectionOptions.zzb)) && Objects.equal(Boolean.valueOf(this.zzc), Boolean.valueOf(connectionOptions.zzc)) && Objects.equal(Boolean.valueOf(this.zzd), Boolean.valueOf(connectionOptions.zzd)) && Objects.equal(Boolean.valueOf(this.zze), Boolean.valueOf(connectionOptions.zze)) && Objects.equal(Boolean.valueOf(this.zzf), Boolean.valueOf(connectionOptions.zzf)) && Objects.equal(Boolean.valueOf(this.zzg), Boolean.valueOf(connectionOptions.zzg)) && Objects.equal(Boolean.valueOf(this.zzh), Boolean.valueOf(connectionOptions.zzh)) && Arrays.equals(this.zzi, connectionOptions.zzi) && Objects.equal(Boolean.valueOf(this.zzj), Boolean.valueOf(connectionOptions.zzj)) && Objects.equal(Boolean.valueOf(this.zzk), Boolean.valueOf(connectionOptions.zzk)) && Objects.equal(Boolean.valueOf(this.zzl), Boolean.valueOf(connectionOptions.zzl)) && Objects.equal(Integer.valueOf(this.zzm), Integer.valueOf(connectionOptions.zzm)) && Objects.equal(Integer.valueOf(this.zzn), Integer.valueOf(connectionOptions.zzn)) && Arrays.equals(this.zzo, connectionOptions.zzo) && Arrays.equals(this.zzp, connectionOptions.zzp) && Arrays.equals(this.zzq, connectionOptions.zzq) && Objects.equal(this.zzr, connectionOptions.zzr) && Objects.equal(Integer.valueOf(this.zzs), Integer.valueOf(connectionOptions.zzs)) && Objects.equal(Long.valueOf(this.zzt), Long.valueOf(connectionOptions.zzt)) && Objects.equal(Boolean.valueOf(this.zzu), Boolean.valueOf(connectionOptions.zzu)) && Objects.equal(Boolean.valueOf(this.zzv), Boolean.valueOf(connectionOptions.zzv)) && Objects.equal(Boolean.valueOf(this.zzw), Boolean.valueOf(connectionOptions.zzw)) && Objects.equal(Boolean.valueOf(this.zzx), Boolean.valueOf(connectionOptions.zzx)) && Objects.equal(Boolean.valueOf(this.zzy), Boolean.valueOf(connectionOptions.zzy))) {
                return true;
            }
        }
        return false;
    }

    public int getConnectionType() {
        return this.zzs;
    }

    @Deprecated
    public boolean getDisruptiveUpgrade() {
        return this.zzl;
    }

    public boolean getLowPower() {
        return this.zza;
    }

    public int hashCode() {
        return Objects.hashCode(Boolean.valueOf(this.zza), Boolean.valueOf(this.zzb), Boolean.valueOf(this.zzc), Boolean.valueOf(this.zzd), Boolean.valueOf(this.zze), Boolean.valueOf(this.zzf), Boolean.valueOf(this.zzg), Boolean.valueOf(this.zzh), Integer.valueOf(Arrays.hashCode(this.zzi)), Boolean.valueOf(this.zzj), Boolean.valueOf(this.zzk), Boolean.valueOf(this.zzl), Integer.valueOf(this.zzm), Integer.valueOf(this.zzn), Integer.valueOf(Arrays.hashCode(this.zzo)), Integer.valueOf(Arrays.hashCode(this.zzp)), Integer.valueOf(Arrays.hashCode(this.zzq)), this.zzr, Integer.valueOf(this.zzs), Long.valueOf(this.zzt), Boolean.valueOf(this.zzu), Boolean.valueOf(this.zzv), Boolean.valueOf(this.zzw), Boolean.valueOf(this.zzx), Boolean.valueOf(this.zzy));
    }

    public String toString() {
        Locale locale = Locale.US;
        Boolean boolValueOf = Boolean.valueOf(this.zza);
        Boolean boolValueOf2 = Boolean.valueOf(this.zzb);
        Boolean boolValueOf3 = Boolean.valueOf(this.zzc);
        Boolean boolValueOf4 = Boolean.valueOf(this.zzd);
        Boolean boolValueOf5 = Boolean.valueOf(this.zze);
        Boolean boolValueOf6 = Boolean.valueOf(this.zzf);
        Boolean boolValueOf7 = Boolean.valueOf(this.zzg);
        Boolean boolValueOf8 = Boolean.valueOf(this.zzh);
        byte[] bArr = this.zzi;
        String strZza = bArr == null ? null : com.google.android.gms.nearby.messages.internal.zzc.zza(bArr);
        Boolean boolValueOf9 = Boolean.valueOf(this.zzj);
        Boolean boolValueOf10 = Boolean.valueOf(this.zzk);
        Boolean boolValueOf11 = Boolean.valueOf(this.zzl);
        byte[] bArr2 = this.zzq;
        return String.format(locale, "ConnectionOptions{lowPower: %s, enableBluetooth: %s, enableBle: %s, enableWifiLan: %s, enableNfc: %s, enableWifiAware: %s, enableWifiHotspot: %s, enableWifiDirect: %s, remoteBluetoothMacAddress: %s, enableWebRtc: %s, enforceTopologyConstraints: %s, disruptiveUpgrade: %s, deviceInfo: %s, strategy: %s, connectionType: %d, flowId: %d, connection mediums %s, upgrade mediums %s,allowWifiLanBlockList: %s}", boolValueOf, boolValueOf2, boolValueOf3, boolValueOf4, boolValueOf5, boolValueOf6, boolValueOf7, boolValueOf8, strZza, boolValueOf9, boolValueOf10, boolValueOf11, bArr2 != null ? com.google.android.gms.nearby.messages.internal.zzc.zza(bArr2) : null, this.zzr, Integer.valueOf(this.zzs), Long.valueOf(this.zzt), Arrays.toString(this.zzp), Arrays.toString(this.zzo), Boolean.valueOf(this.zzy));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBoolean(parcel, 1, getLowPower());
        SafeParcelWriter.writeBoolean(parcel, 2, this.zzb);
        SafeParcelWriter.writeBoolean(parcel, 3, this.zzc);
        SafeParcelWriter.writeBoolean(parcel, 4, this.zzd);
        SafeParcelWriter.writeBoolean(parcel, 5, this.zze);
        SafeParcelWriter.writeBoolean(parcel, 6, this.zzf);
        SafeParcelWriter.writeBoolean(parcel, 7, this.zzg);
        SafeParcelWriter.writeBoolean(parcel, 8, this.zzh);
        SafeParcelWriter.writeByteArray(parcel, 9, this.zzi, false);
        SafeParcelWriter.writeBoolean(parcel, 10, this.zzj);
        SafeParcelWriter.writeBoolean(parcel, 11, this.zzk);
        SafeParcelWriter.writeBoolean(parcel, 12, getDisruptiveUpgrade());
        SafeParcelWriter.writeInt(parcel, 13, this.zzm);
        SafeParcelWriter.writeInt(parcel, 14, this.zzn);
        SafeParcelWriter.writeIntArray(parcel, 15, this.zzo, false);
        SafeParcelWriter.writeIntArray(parcel, 16, this.zzp, false);
        SafeParcelWriter.writeByteArray(parcel, 17, this.zzq, false);
        SafeParcelWriter.writeParcelable(parcel, 18, this.zzr, i, false);
        SafeParcelWriter.writeInt(parcel, 19, getConnectionType());
        SafeParcelWriter.writeLong(parcel, 20, this.zzt);
        SafeParcelWriter.writeBoolean(parcel, 21, this.zzu);
        SafeParcelWriter.writeBoolean(parcel, 22, this.zzv);
        SafeParcelWriter.writeBoolean(parcel, 23, this.zzw);
        SafeParcelWriter.writeBoolean(parcel, 24, this.zzx);
        SafeParcelWriter.writeBoolean(parcel, 25, this.zzy);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    final /* synthetic */ void zzA(boolean z) {
        this.zzb = z;
    }

    final /* synthetic */ boolean zzB() {
        return this.zzc;
    }

    final /* synthetic */ void zzC(boolean z) {
        this.zzc = z;
    }

    final /* synthetic */ boolean zzD() {
        return this.zzd;
    }

    final /* synthetic */ void zzE(boolean z) {
        this.zzd = z;
    }

    final /* synthetic */ boolean zzF() {
        return this.zze;
    }

    final /* synthetic */ void zzG(boolean z) {
        this.zze = z;
    }

    final /* synthetic */ boolean zzH() {
        return this.zzf;
    }

    final /* synthetic */ void zzI(boolean z) {
        this.zzf = z;
    }

    final /* synthetic */ boolean zzJ() {
        return this.zzg;
    }

    final /* synthetic */ void zzK(boolean z) {
        this.zzg = z;
    }

    final /* synthetic */ boolean zzL() {
        return this.zzh;
    }

    final /* synthetic */ void zzM(boolean z) {
        this.zzh = z;
    }

    final /* synthetic */ byte[] zzN() {
        return this.zzi;
    }

    final /* synthetic */ void zzO(byte[] bArr) {
        this.zzi = bArr;
    }

    final /* synthetic */ boolean zzP() {
        return this.zzj;
    }

    final /* synthetic */ void zzQ(boolean z) {
        this.zzj = z;
    }

    final /* synthetic */ boolean zzR() {
        return this.zzk;
    }

    final /* synthetic */ void zzS(boolean z) {
        this.zzk = z;
    }

    final /* synthetic */ boolean zzT() {
        return this.zzl;
    }

    final /* synthetic */ void zzU(boolean z) {
        this.zzl = z;
    }

    final /* synthetic */ int zzV() {
        return this.zzm;
    }

    final /* synthetic */ void zzW(int i) {
        this.zzm = i;
    }

    final /* synthetic */ int zzX() {
        return this.zzn;
    }

    final /* synthetic */ void zzY(int i) {
        this.zzn = i;
    }

    final /* synthetic */ int[] zzZ() {
        return this.zzo;
    }

    public final boolean zza() {
        return this.zzb;
    }

    final /* synthetic */ void zzaa(int[] iArr) {
        this.zzo = iArr;
    }

    final /* synthetic */ int[] zzab() {
        return this.zzp;
    }

    final /* synthetic */ void zzac(int[] iArr) {
        this.zzp = iArr;
    }

    final /* synthetic */ byte[] zzad() {
        return this.zzq;
    }

    final /* synthetic */ void zzae(byte[] bArr) {
        this.zzq = bArr;
    }

    final /* synthetic */ Strategy zzaf() {
        return this.zzr;
    }

    final /* synthetic */ void zzag(Strategy strategy) {
        this.zzr = strategy;
    }

    final /* synthetic */ int zzah() {
        return this.zzs;
    }

    final /* synthetic */ void zzai(int i) {
        this.zzs = i;
    }

    final /* synthetic */ long zzaj() {
        return this.zzt;
    }

    final /* synthetic */ void zzak(long j) {
        this.zzt = j;
    }

    final /* synthetic */ boolean zzal() {
        return this.zzu;
    }

    final /* synthetic */ void zzam(boolean z) {
        this.zzu = z;
    }

    final /* synthetic */ boolean zzan() {
        return this.zzv;
    }

    final /* synthetic */ void zzao(boolean z) {
        this.zzv = z;
    }

    final /* synthetic */ boolean zzap() {
        return this.zzw;
    }

    final /* synthetic */ void zzaq(boolean z) {
        this.zzw = z;
    }

    final /* synthetic */ boolean zzar() {
        return this.zzx;
    }

    final /* synthetic */ void zzas(boolean z) {
        this.zzx = z;
    }

    final /* synthetic */ boolean zzat() {
        return this.zzy;
    }

    final /* synthetic */ void zzau(boolean z) {
        this.zzy = z;
    }

    public final boolean zzb() {
        return this.zzc;
    }

    public final boolean zzc() {
        return this.zzd;
    }

    public final boolean zzd() {
        return this.zze;
    }

    public final boolean zze() {
        return this.zzf;
    }

    public final boolean zzf() {
        return this.zzg;
    }

    public final boolean zzg() {
        return this.zzh;
    }

    public final byte[] zzh() {
        return this.zzi;
    }

    public final boolean zzi() {
        return this.zzj;
    }

    public final boolean zzj() {
        return this.zzk;
    }

    public final int zzk() {
        return this.zzm;
    }

    public final int zzl() {
        return this.zzn;
    }

    public final int[] zzm() {
        return this.zzo;
    }

    public final int[] zzn() {
        return this.zzp;
    }

    public final byte[] zzo() {
        return this.zzq;
    }

    public final Strategy zzp() {
        return this.zzr;
    }

    public final long zzq() {
        return this.zzt;
    }

    @Deprecated
    public final boolean zzr() {
        return this.zzu;
    }

    public final boolean zzs() {
        return this.zzv;
    }

    public final boolean zzt() {
        return this.zzw;
    }

    public final boolean zzu() {
        return this.zzx;
    }

    public final boolean zzv() {
        return this.zzy;
    }

    final /* synthetic */ boolean zzx() {
        return this.zza;
    }

    final /* synthetic */ void zzy(boolean z) {
        this.zza = z;
    }

    final /* synthetic */ boolean zzz() {
        return this.zzb;
    }

    ConnectionOptions(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, byte[] bArr, boolean z9, boolean z10, boolean z11, int i, int i2, int[] iArr, int[] iArr2, byte[] bArr2, Strategy strategy, int i3, long j, boolean z12, boolean z13, boolean z14, boolean z15, boolean z16) {
        this.zza = z;
        this.zzb = z2;
        this.zzc = z3;
        this.zzd = z4;
        this.zze = z5;
        this.zzf = z6;
        this.zzg = z7;
        this.zzh = z8;
        this.zzi = bArr;
        this.zzj = z9;
        this.zzk = z10;
        this.zzl = z11;
        this.zzm = i;
        this.zzn = i2;
        this.zzo = iArr;
        this.zzp = iArr2;
        this.zzq = bArr2;
        this.zzr = strategy;
        this.zzs = i3;
        this.zzt = j;
        this.zzu = z12;
        this.zzv = z13;
        this.zzw = z14;
        this.zzx = z15;
        this.zzy = z16;
    }

    /* synthetic */ ConnectionOptions(byte[] bArr) {
        this.zza = false;
        this.zzb = true;
        this.zzc = true;
        this.zzd = true;
        this.zze = true;
        this.zzf = true;
        this.zzg = true;
        this.zzh = true;
        this.zzj = false;
        this.zzk = true;
        this.zzl = true;
        this.zzm = 0;
        this.zzn = 0;
        this.zzs = 0;
        this.zzt = 0L;
        this.zzu = false;
        this.zzv = true;
        this.zzw = true;
        this.zzx = false;
        this.zzy = true;
    }
}
