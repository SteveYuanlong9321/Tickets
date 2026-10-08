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
public final class zzgq extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzgq> CREATOR = new zzgr();
    private long zza;
    private int zzb;
    private byte[] zzc;
    private ParcelFileDescriptor zzd;
    private String zze;
    private long zzf;
    private ParcelFileDescriptor zzg;
    private Uri zzh;
    private long zzi;
    private boolean zzj;
    private ParcelByteArray zzk;
    private long zzl;
    private String zzm;
    private String zzn;
    private zzgt zzo;
    private zzgw zzp;
    private zzgn zzq;
    private int zzr;

    private zzgq() {
        this.zzf = -1L;
        this.zzi = 0L;
        this.zzj = false;
        this.zzl = 0L;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzgq) {
            zzgq zzgqVar = (zzgq) obj;
            if (Objects.equal(Long.valueOf(this.zza), Long.valueOf(zzgqVar.zza)) && Objects.equal(Integer.valueOf(this.zzb), Integer.valueOf(zzgqVar.zzb)) && Arrays.equals(this.zzc, zzgqVar.zzc) && Objects.equal(this.zzd, zzgqVar.zzd) && Objects.equal(this.zze, zzgqVar.zze) && Objects.equal(Long.valueOf(this.zzf), Long.valueOf(zzgqVar.zzf)) && Objects.equal(this.zzg, zzgqVar.zzg) && Objects.equal(this.zzh, zzgqVar.zzh) && Objects.equal(Long.valueOf(this.zzi), Long.valueOf(zzgqVar.zzi)) && Objects.equal(Boolean.valueOf(this.zzj), Boolean.valueOf(zzgqVar.zzj)) && Objects.equal(this.zzk, zzgqVar.zzk) && Objects.equal(Long.valueOf(this.zzl), Long.valueOf(zzgqVar.zzl)) && Objects.equal(this.zzm, zzgqVar.zzm) && Objects.equal(this.zzn, zzgqVar.zzn) && Objects.equal(this.zzo, zzgqVar.zzo) && Objects.equal(this.zzp, zzgqVar.zzp) && Objects.equal(this.zzq, zzgqVar.zzq) && Objects.equal(Integer.valueOf(this.zzr), Integer.valueOf(zzgqVar.zzr))) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(Long.valueOf(this.zza), Integer.valueOf(this.zzb), Integer.valueOf(Arrays.hashCode(this.zzc)), this.zzd, this.zze, Long.valueOf(this.zzf), this.zzg, this.zzh, Long.valueOf(this.zzi), Boolean.valueOf(this.zzj), this.zzk, Long.valueOf(this.zzl), this.zzm, this.zzn, this.zzo, this.zzp, this.zzq, Integer.valueOf(this.zzr));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeLong(parcel, 1, this.zza);
        SafeParcelWriter.writeInt(parcel, 2, this.zzb);
        SafeParcelWriter.writeByteArray(parcel, 3, this.zzc, false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.zzd, i, false);
        SafeParcelWriter.writeString(parcel, 5, this.zze, false);
        SafeParcelWriter.writeLong(parcel, 6, this.zzf);
        SafeParcelWriter.writeParcelable(parcel, 7, this.zzg, i, false);
        SafeParcelWriter.writeParcelable(parcel, 8, this.zzh, i, false);
        SafeParcelWriter.writeLong(parcel, 9, this.zzi);
        SafeParcelWriter.writeBoolean(parcel, 10, this.zzj);
        SafeParcelWriter.writeParcelable(parcel, 11, this.zzk, i, false);
        SafeParcelWriter.writeLong(parcel, 12, this.zzl);
        SafeParcelWriter.writeString(parcel, 13, this.zzm, false);
        SafeParcelWriter.writeString(parcel, 14, this.zzn, false);
        SafeParcelWriter.writeParcelable(parcel, 15, this.zzo, i, false);
        SafeParcelWriter.writeParcelable(parcel, 16, this.zzp, i, false);
        SafeParcelWriter.writeInt(parcel, 17, this.zzr);
        SafeParcelWriter.writeParcelable(parcel, 18, this.zzq, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    final /* synthetic */ void zzA(ParcelByteArray parcelByteArray) {
        this.zzk = parcelByteArray;
    }

    final /* synthetic */ void zzB(long j) {
        this.zzl = j;
    }

    final /* synthetic */ void zzC(String str) {
        this.zzm = str;
    }

    final /* synthetic */ void zzD(String str) {
        this.zzn = str;
    }

    final /* synthetic */ void zzE(zzgt zzgtVar) {
        this.zzo = zzgtVar;
    }

    final /* synthetic */ void zzF(zzgw zzgwVar) {
        this.zzp = zzgwVar;
    }

    final /* synthetic */ void zzG(zzgn zzgnVar) {
        this.zzq = zzgnVar;
    }

    final /* synthetic */ void zzH(int i) {
        this.zzr = i;
    }

    public final long zza() {
        return this.zza;
    }

    public final int zzb() {
        return this.zzb;
    }

    public final byte[] zzc() {
        return this.zzc;
    }

    public final ParcelFileDescriptor zzd() {
        return this.zzd;
    }

    public final String zze() {
        return this.zze;
    }

    public final long zzf() {
        return this.zzf;
    }

    public final ParcelFileDescriptor zzg() {
        return this.zzg;
    }

    public final Uri zzh() {
        return this.zzh;
    }

    public final ParcelByteArray zzi() {
        return this.zzk;
    }

    public final long zzj() {
        return this.zzl;
    }

    public final String zzk() {
        return this.zzm;
    }

    public final String zzl() {
        return this.zzn;
    }

    public final zzgt zzm() {
        return this.zzo;
    }

    public final zzgw zzn() {
        return this.zzp;
    }

    public final zzgn zzo() {
        return this.zzq;
    }

    public final int zzp() {
        return this.zzr;
    }

    final /* synthetic */ void zzq(long j) {
        this.zza = j;
    }

    final /* synthetic */ void zzr(int i) {
        this.zzb = i;
    }

    final /* synthetic */ void zzs(byte[] bArr) {
        this.zzc = bArr;
    }

    final /* synthetic */ void zzt(ParcelFileDescriptor parcelFileDescriptor) {
        this.zzd = parcelFileDescriptor;
    }

    final /* synthetic */ void zzu(String str) {
        this.zze = str;
    }

    final /* synthetic */ void zzv(long j) {
        this.zzf = j;
    }

    final /* synthetic */ void zzw(ParcelFileDescriptor parcelFileDescriptor) {
        this.zzg = parcelFileDescriptor;
    }

    final /* synthetic */ void zzx(Uri uri) {
        this.zzh = uri;
    }

    final /* synthetic */ void zzy(long j) {
        this.zzi = j;
    }

    final /* synthetic */ void zzz(boolean z) {
        this.zzj = z;
    }

    zzgq(long j, int i, byte[] bArr, ParcelFileDescriptor parcelFileDescriptor, String str, long j2, ParcelFileDescriptor parcelFileDescriptor2, Uri uri, long j3, boolean z, ParcelByteArray parcelByteArray, long j4, String str2, String str3, zzgt zzgtVar, zzgw zzgwVar, zzgn zzgnVar, int i2) {
        this.zza = j;
        this.zzb = i;
        this.zzc = bArr;
        this.zzd = parcelFileDescriptor;
        this.zze = str;
        this.zzf = j2;
        this.zzg = parcelFileDescriptor2;
        this.zzh = uri;
        this.zzi = j3;
        this.zzj = z;
        this.zzk = parcelByteArray;
        this.zzl = j4;
        this.zzm = str2;
        this.zzn = str3;
        this.zzo = zzgtVar;
        this.zzp = zzgwVar;
        this.zzq = zzgnVar;
        this.zzr = i2;
    }

    /* synthetic */ zzgq(byte[] bArr) {
        this.zzf = -1L;
        this.zzi = 0L;
        this.zzj = false;
        this.zzl = 0L;
    }
}
