package com.google.android.gms.internal.nearby;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.os.EnvironmentCompat;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzcb extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzcb> CREATOR = new zzcc();
    private final int zza;
    private final String zzb;

    static {
        new zzcb(2, "");
        new zzcb(0, "");
        new zzcb(1, "");
        new zzcb(-1, "");
    }

    zzcb(int i, String str) {
        this.zza = i;
        this.zzb = str;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzcb) {
            zzcb zzcbVar = (zzcb) obj;
            String str = this.zzb;
            if (str != null && !str.isEmpty()) {
                return this.zza == zzcbVar.zza && str.equals(zzcbVar.zzb);
            }
            if (this.zza == zzcbVar.zza) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        String str = this.zzb;
        if (str == null || str.isEmpty()) {
            return Objects.hash(Integer.valueOf(this.zza));
        }
        int i = this.zza;
        StringBuilder sb = new StringBuilder(String.valueOf(i).length() + str.length());
        sb.append(i);
        sb.append(str);
        return Objects.hash(sb.toString());
    }

    public final String toString() {
        String str;
        StringBuilder sb = new StringBuilder("Identity[type=");
        int i = this.zza;
        if (i == -1) {
            str = EnvironmentCompat.MEDIA_UNKNOWN;
        } else if (i == 0) {
            str = "private group";
        } else if (i != 1) {
            str = i != 2 ? "not recognizable" : "public";
        } else {
            str = "contacts group";
        }
        sb.append(str);
        sb.append(", provider name =");
        sb.append(this.zzb);
        sb.append(']');
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int i2 = this.zza;
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, i2);
        SafeParcelWriter.writeString(parcel, 2, this.zzb, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
