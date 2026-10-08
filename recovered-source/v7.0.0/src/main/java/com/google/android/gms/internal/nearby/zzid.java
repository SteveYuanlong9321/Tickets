package com.google.android.gms.internal.nearby;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Base64;
import androidx.camera.video.AudioStats;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.Arrays;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzid extends AbstractSafeParcelable implements Comparable<zzid> {
    public static final Parcelable.Creator<zzid> CREATOR = new zzie();
    public final String zza;
    final long zzb;
    final boolean zzc;
    final double zzd;

    @Nullable
    final String zze;

    @Nullable
    final byte[] zzf;
    public final int zzg;
    public final int zzh;
    private final int zzi;

    zzid(String str, long j, boolean z, double d, @Nullable String str2, @Nullable byte[] bArr, int i, int i2, int i3) {
        this.zza = str;
        this.zzb = j;
        this.zzc = z;
        this.zzd = d;
        this.zze = str2;
        this.zzf = bArr;
        this.zzg = i;
        this.zzh = i2;
        this.zzi = i3;
    }

    private static int zzg(int i, int i2) {
        if (i < i2) {
            return -1;
        }
        return i != i2 ? 1 : 0;
    }

    @Override // java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(zzid zzidVar) {
        zzid zzidVar2 = zzidVar;
        int iCompareTo = this.zza.compareTo(zzidVar2.zza);
        if (iCompareTo != 0) {
            return iCompareTo;
        }
        int i = this.zzg;
        int iZzg = zzg(i, zzidVar2.zzg);
        if (iZzg != 0) {
            return iZzg;
        }
        int i2 = 0;
        if (i == 1) {
            long j = this.zzb;
            long j2 = zzidVar2.zzb;
            if (j < j2) {
                return -1;
            }
            return j == j2 ? 0 : 1;
        }
        if (i == 2) {
            boolean z = this.zzc;
            if (z == zzidVar2.zzc) {
                return 0;
            }
            return z ? 1 : -1;
        }
        if (i == 3) {
            return Double.compare(this.zzd, zzidVar2.zzd);
        }
        if (i == 4) {
            String str = this.zze;
            String str2 = zzidVar2.zze;
            if (str == str2) {
                return 0;
            }
            if (str == null) {
                return -1;
            }
            if (str2 == null) {
                return 1;
            }
            return str.compareTo(str2);
        }
        if (i != 5) {
            StringBuilder sb = new StringBuilder(String.valueOf(i).length() + 20);
            sb.append("Invalid enum value: ");
            sb.append(i);
            throw new AssertionError(sb.toString());
        }
        byte[] bArr = this.zzf;
        byte[] bArr2 = zzidVar2.zzf;
        if (bArr == bArr2) {
            return 0;
        }
        if (bArr == null) {
            return -1;
        }
        if (bArr2 == null) {
            return 1;
        }
        while (true) {
            int length = bArr2.length;
            int length2 = bArr.length;
            if (i2 >= Math.min(length2, length)) {
                return zzg(length2, length);
            }
            int i3 = bArr[i2] - bArr2[i2];
            if (i3 != 0) {
                return i3;
            }
            i2++;
        }
    }

    public final boolean equals(@Nullable Object obj) {
        int i;
        if (obj instanceof zzid) {
            zzid zzidVar = (zzid) obj;
            if (zziz.zza(this.zza, zzidVar.zza) && (i = this.zzg) == zzidVar.zzg && this.zzh == zzidVar.zzh && this.zzi == zzidVar.zzi) {
                if (i == 1) {
                    return this.zzb == zzidVar.zzb;
                }
                if (i == 2) {
                    return this.zzc == zzidVar.zzc;
                }
                if (i == 3) {
                    return this.zzd == zzidVar.zzd;
                }
                if (i == 4) {
                    return zziz.zza(this.zze, zzidVar.zze);
                }
                if (i == 5) {
                    return Arrays.equals(this.zzf, zzidVar.zzf);
                }
                StringBuilder sb = new StringBuilder(String.valueOf(i).length() + 20);
                sb.append("Invalid enum value: ");
                sb.append(i);
                throw new AssertionError(sb.toString());
            }
        }
        return false;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        zzf(sb);
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        String str = this.zza;
        boolean zZzb = zzie.zzb(str);
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        if (!zZzb) {
            SafeParcelWriter.writeString(parcel, 2, str, false);
        }
        long j = this.zzb;
        if (j != 0) {
            SafeParcelWriter.writeLong(parcel, 3, j);
        }
        if (this.zzc) {
            SafeParcelWriter.writeBoolean(parcel, 4, true);
        }
        double d = this.zzd;
        if (d != AudioStats.AUDIO_AMPLITUDE_NONE) {
            SafeParcelWriter.writeDouble(parcel, 5, d);
        }
        String str2 = this.zze;
        if (!zzie.zzb(str2)) {
            SafeParcelWriter.writeString(parcel, 6, str2, false);
        }
        byte[] bArr = this.zzf;
        if (!zzie.zzb(bArr)) {
            SafeParcelWriter.writeByteArray(parcel, 7, bArr, false);
        }
        int i2 = this.zzg;
        if (!zzie.zza(i2)) {
            SafeParcelWriter.writeInt(parcel, 8, i2);
        }
        int i3 = this.zzh;
        if (!zzie.zza(i3)) {
            SafeParcelWriter.writeInt(parcel, 9, i3);
        }
        int i4 = this.zzi;
        if (!zzie.zza(i4)) {
            SafeParcelWriter.writeInt(parcel, 10, i4);
        }
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public final long zza() {
        if (this.zzg == 1) {
            return this.zzb;
        }
        throw new IllegalArgumentException("Not a long type");
    }

    public final boolean zzb() {
        if (this.zzg == 2) {
            return this.zzc;
        }
        throw new IllegalArgumentException("Not a boolean type");
    }

    public final double zzc() {
        if (this.zzg == 3) {
            return this.zzd;
        }
        throw new IllegalArgumentException("Not a double type");
    }

    public final String zzd() {
        if (this.zzg == 4) {
            return (String) Preconditions.checkNotNull(this.zze);
        }
        throw new IllegalArgumentException("Not a String type");
    }

    public final byte[] zze() {
        if (this.zzg == 5) {
            return (byte[]) Preconditions.checkNotNull(this.zzf);
        }
        throw new IllegalArgumentException("Not a bytes type");
    }

    final void zzf(StringBuilder sb) {
        sb.append("Flag(");
        String str = this.zza;
        sb.append(str);
        sb.append(", ");
        int i = this.zzg;
        if (i == 1) {
            sb.append(this.zzb);
        } else if (i == 2) {
            sb.append(this.zzc);
        } else if (i == 3) {
            sb.append(this.zzd);
        } else if (i == 4) {
            sb.append("'");
            sb.append((String) Preconditions.checkNotNull(this.zze));
            sb.append("'");
        } else {
            if (i != 5) {
                StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 16 + String.valueOf(i).length());
                sb2.append("Invalid type: ");
                sb2.append(str);
                sb2.append(", ");
                sb2.append(i);
                throw new AssertionError(sb2.toString());
            }
            sb.append("'");
            sb.append(Base64.encodeToString((byte[]) Preconditions.checkNotNull(this.zzf), 3));
            sb.append("'");
        }
        sb.append(", ");
        sb.append(i);
        sb.append(", ");
        sb.append(this.zzh);
        sb.append(", ");
        sb.append(this.zzi);
        sb.append(")");
    }
}
