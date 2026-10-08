package com.google.android.gms.nearby.internal.connection;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.nearby.connection.ConnectionOptions;
import com.google.android.gms.nearby.connection.Strategy;
import java.util.Arrays;
import java.util.Locale;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzm extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzm> CREATOR = new zzn();
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
    private String zzx;
    private boolean zzy;
    private boolean zzz;

    private zzm() {
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
        this.zzy = false;
        this.zzz = true;
    }

    private static void zzD(int i, zzm zzmVar) {
        switch (i) {
            case 2:
                zzmVar.zzb = true;
                break;
            case 3:
                zzmVar.zzg = true;
                break;
            case 4:
                zzmVar.zzc = true;
                break;
            case 5:
                zzmVar.zzd = true;
                break;
            case 6:
                zzmVar.zzf = true;
                break;
            case 7:
                zzmVar.zze = true;
                break;
            case 8:
                zzmVar.zzh = true;
                break;
            case 9:
            case 12:
                zzmVar.zzj = true;
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

    public static zzm zza(ConnectionOptions connectionOptions) {
        zzl zzlVar = new zzl();
        zzlVar.zza(connectionOptions.getLowPower());
        zzlVar.zzb(connectionOptions.zza());
        zzlVar.zzc(connectionOptions.zzb());
        zzlVar.zzd(connectionOptions.zzc());
        zzlVar.zze(connectionOptions.zzd());
        zzlVar.zzf(connectionOptions.zze());
        zzlVar.zzg(connectionOptions.zzf());
        zzlVar.zzh(connectionOptions.zzg());
        zzlVar.zzi(connectionOptions.zzh());
        zzlVar.zzj(connectionOptions.zzi());
        zzlVar.zzk(connectionOptions.zzj());
        zzlVar.zzl(connectionOptions.getDisruptiveUpgrade());
        zzlVar.zzm(connectionOptions.zzk());
        zzlVar.zzn(connectionOptions.zzl());
        zzlVar.zzq(connectionOptions.zzo());
        zzlVar.zzs(connectionOptions.zzp());
        zzlVar.zzr(connectionOptions.getConnectionType());
        zzlVar.zzt(connectionOptions.zzq());
        zzlVar.zzu(connectionOptions.zzr());
        zzlVar.zzv(connectionOptions.zzs());
        zzlVar.zzw(connectionOptions.zzt());
        zzlVar.zzy(connectionOptions.zzu());
        zzlVar.zzx(connectionOptions.zzv());
        if (connectionOptions.zzn() != null) {
            zzlVar.zzp((int[]) Preconditions.checkNotNull(connectionOptions.zzn()));
        }
        if (connectionOptions.zzm() != null) {
            zzlVar.zzo((int[]) Preconditions.checkNotNull(connectionOptions.zzm()));
        }
        return zzlVar.zzz();
    }

    static /* synthetic */ void zzb(zzm zzmVar) {
        int[] iArr = zzmVar.zzp;
        int[] iArr2 = zzmVar.zzo;
        if (iArr != null && iArr.length > 0) {
            zzmVar.zzc = false;
            zzmVar.zzb = false;
            zzmVar.zze = false;
            if (PlatformVersion.isAtLeastP()) {
                zzmVar.zzd = false;
            }
        }
        if (iArr2 != null) {
            zzmVar.zzg = false;
            zzmVar.zzf = false;
            zzmVar.zzh = false;
            if (!PlatformVersion.isAtLeastP()) {
                zzmVar.zzd = false;
            }
        }
        if (iArr != null) {
            for (int i : iArr) {
                zzD(i, zzmVar);
            }
        }
        if (iArr2 != null) {
            for (int i2 : iArr2) {
                zzD(i2, zzmVar);
            }
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzm) {
            zzm zzmVar = (zzm) obj;
            if (Objects.equals(Boolean.valueOf(this.zza), Boolean.valueOf(zzmVar.zza)) && Objects.equals(Boolean.valueOf(this.zzb), Boolean.valueOf(zzmVar.zzb)) && Objects.equals(Boolean.valueOf(this.zzc), Boolean.valueOf(zzmVar.zzc)) && Objects.equals(Boolean.valueOf(this.zzd), Boolean.valueOf(zzmVar.zzd)) && Objects.equals(Boolean.valueOf(this.zze), Boolean.valueOf(zzmVar.zze)) && Objects.equals(Boolean.valueOf(this.zzf), Boolean.valueOf(zzmVar.zzf)) && Objects.equals(Boolean.valueOf(this.zzg), Boolean.valueOf(zzmVar.zzg)) && Objects.equals(Boolean.valueOf(this.zzh), Boolean.valueOf(zzmVar.zzh)) && Arrays.equals(this.zzi, zzmVar.zzi) && Objects.equals(Boolean.valueOf(this.zzj), Boolean.valueOf(zzmVar.zzj)) && Objects.equals(Boolean.valueOf(this.zzk), Boolean.valueOf(zzmVar.zzk)) && Objects.equals(Boolean.valueOf(this.zzl), Boolean.valueOf(zzmVar.zzl)) && Objects.equals(Integer.valueOf(this.zzm), Integer.valueOf(zzmVar.zzm)) && Objects.equals(Integer.valueOf(this.zzn), Integer.valueOf(zzmVar.zzn)) && Arrays.equals(this.zzo, zzmVar.zzo) && Arrays.equals(this.zzp, zzmVar.zzp) && Arrays.equals(this.zzq, zzmVar.zzq) && Objects.equals(this.zzr, zzmVar.zzr) && Objects.equals(Integer.valueOf(this.zzs), Integer.valueOf(zzmVar.zzs)) && Objects.equals(Long.valueOf(this.zzt), Long.valueOf(zzmVar.zzt)) && Objects.equals(Boolean.valueOf(this.zzu), Boolean.valueOf(zzmVar.zzu)) && Objects.equals(Boolean.valueOf(this.zzv), Boolean.valueOf(zzmVar.zzv)) && Objects.equals(Boolean.valueOf(this.zzw), Boolean.valueOf(zzmVar.zzw)) && Objects.equals(this.zzx, zzmVar.zzx) && Objects.equals(Boolean.valueOf(this.zzy), Boolean.valueOf(zzmVar.zzy)) && Objects.equals(Boolean.valueOf(this.zzz), Boolean.valueOf(zzmVar.zzz))) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hash(Boolean.valueOf(this.zza), Boolean.valueOf(this.zzb), Boolean.valueOf(this.zzc), Boolean.valueOf(this.zzd), Boolean.valueOf(this.zze), Boolean.valueOf(this.zzf), Boolean.valueOf(this.zzg), Boolean.valueOf(this.zzh), Integer.valueOf(Arrays.hashCode(this.zzi)), Boolean.valueOf(this.zzj), Boolean.valueOf(this.zzk), Boolean.valueOf(this.zzl), Integer.valueOf(this.zzm), Integer.valueOf(this.zzn), Integer.valueOf(Arrays.hashCode(this.zzo)), Integer.valueOf(Arrays.hashCode(this.zzp)), Integer.valueOf(Arrays.hashCode(this.zzq)), this.zzr, Integer.valueOf(this.zzs), Long.valueOf(this.zzt), Boolean.valueOf(this.zzu), Boolean.valueOf(this.zzv), Boolean.valueOf(this.zzw), this.zzx, Boolean.valueOf(this.zzy), Boolean.valueOf(this.zzz));
    }

    public final String toString() {
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
        return String.format(locale, "ConnectionOptions{lowPower: %s, enableBluetooth: %s, enableBle: %s, enableWifiLan: %s, enableNfc: %s, enableWifiAware: %s, enableWifiHotspot: %s, enableWifiDirect: %s, remoteBluetoothMacAddress: %s, enableWebRtc: %s, enforceTopologyConstraints: %s, disruptiveUpgrade: %s, deviceInfo: %s, strategy: %s, connectionType: %d, flowId: %d, connection mediums %s, upgrade mediums %s, skipPayloadInProgressUpdate: %s,allowWifiLanBlockList: %s}", boolValueOf, boolValueOf2, boolValueOf3, boolValueOf4, boolValueOf5, boolValueOf6, boolValueOf7, boolValueOf8, strZza, boolValueOf9, boolValueOf10, boolValueOf11, bArr2 != null ? com.google.android.gms.nearby.messages.internal.zzc.zza(bArr2) : null, this.zzr, Integer.valueOf(this.zzs), Long.valueOf(this.zzt), Arrays.toString(this.zzp), Arrays.toString(this.zzo), Boolean.valueOf(this.zzy), Boolean.valueOf(this.zzz));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBoolean(parcel, 1, this.zza);
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
        SafeParcelWriter.writeBoolean(parcel, 12, this.zzl);
        SafeParcelWriter.writeInt(parcel, 13, this.zzm);
        SafeParcelWriter.writeInt(parcel, 14, this.zzn);
        SafeParcelWriter.writeIntArray(parcel, 15, this.zzo, false);
        SafeParcelWriter.writeIntArray(parcel, 16, this.zzp, false);
        SafeParcelWriter.writeByteArray(parcel, 17, this.zzq, false);
        SafeParcelWriter.writeParcelable(parcel, 18, this.zzr, i, false);
        SafeParcelWriter.writeInt(parcel, 19, this.zzs);
        SafeParcelWriter.writeLong(parcel, 20, this.zzt);
        SafeParcelWriter.writeBoolean(parcel, 21, this.zzu);
        SafeParcelWriter.writeBoolean(parcel, 22, this.zzv);
        SafeParcelWriter.writeBoolean(parcel, 23, this.zzw);
        SafeParcelWriter.writeString(parcel, 24, this.zzx, false);
        SafeParcelWriter.writeBoolean(parcel, 25, this.zzy);
        SafeParcelWriter.writeBoolean(parcel, 26, this.zzz);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    final /* synthetic */ void zzA(boolean z) {
        this.zzw = z;
    }

    final /* synthetic */ void zzB(boolean z) {
        this.zzy = z;
    }

    final /* synthetic */ void zzC(boolean z) {
        this.zzz = z;
    }

    final /* synthetic */ void zzc(boolean z) {
        this.zza = z;
    }

    final /* synthetic */ void zzd(boolean z) {
        this.zzb = z;
    }

    final /* synthetic */ void zze(boolean z) {
        this.zzc = z;
    }

    final /* synthetic */ void zzf(boolean z) {
        this.zzd = z;
    }

    final /* synthetic */ void zzg(boolean z) {
        this.zze = z;
    }

    final /* synthetic */ void zzh(boolean z) {
        this.zzf = z;
    }

    final /* synthetic */ void zzi(boolean z) {
        this.zzg = z;
    }

    final /* synthetic */ void zzj(boolean z) {
        this.zzh = z;
    }

    final /* synthetic */ void zzk(byte[] bArr) {
        this.zzi = bArr;
    }

    final /* synthetic */ void zzl(boolean z) {
        this.zzj = z;
    }

    final /* synthetic */ void zzm(boolean z) {
        this.zzk = z;
    }

    final /* synthetic */ boolean zzn() {
        return this.zzl;
    }

    final /* synthetic */ void zzo(boolean z) {
        this.zzl = z;
    }

    final /* synthetic */ void zzp(int i) {
        this.zzm = i;
    }

    final /* synthetic */ void zzq(int i) {
        this.zzn = i;
    }

    final /* synthetic */ void zzr(int[] iArr) {
        this.zzo = iArr;
    }

    final /* synthetic */ void zzs(int[] iArr) {
        this.zzp = iArr;
    }

    final /* synthetic */ void zzt(byte[] bArr) {
        this.zzq = bArr;
    }

    final /* synthetic */ void zzu(Strategy strategy) {
        this.zzr = strategy;
    }

    final /* synthetic */ int zzv() {
        return this.zzs;
    }

    final /* synthetic */ void zzw(int i) {
        this.zzs = i;
    }

    final /* synthetic */ void zzx(long j) {
        this.zzt = j;
    }

    final /* synthetic */ void zzy(boolean z) {
        this.zzu = z;
    }

    final /* synthetic */ void zzz(boolean z) {
        this.zzv = z;
    }

    zzm(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, byte[] bArr, boolean z9, boolean z10, boolean z11, int i, int i2, int[] iArr, int[] iArr2, byte[] bArr2, Strategy strategy, int i3, long j, boolean z12, boolean z13, boolean z14, String str, boolean z15, boolean z16) {
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
        this.zzx = str;
        this.zzy = z15;
        this.zzz = z16;
    }

    /* synthetic */ zzm(byte[] bArr) {
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
        this.zzy = false;
        this.zzz = true;
    }
}
