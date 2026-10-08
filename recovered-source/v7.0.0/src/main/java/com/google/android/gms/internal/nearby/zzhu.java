package com.google.android.gms.internal.nearby;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzhu extends AbstractSafeParcelable implements Comparable<zzhu> {
    public static final Parcelable.Creator<zzhu> CREATOR = new zzhv();
    public final int zza;
    public final zzid[] zzb;
    public final String[] zzc;
    public final Map zzd = new TreeMap();

    public zzhu(int i, zzid[] zzidVarArr, String[] strArr) {
        this.zza = i;
        this.zzb = zzidVarArr;
        for (zzid zzidVar : zzidVarArr) {
            this.zzd.put(zzidVar.zza, zzidVar);
        }
        this.zzc = strArr;
        if (strArr != null) {
            Arrays.sort(strArr);
        }
    }

    @Override // java.lang.Comparable
    public final /* synthetic */ int compareTo(zzhu zzhuVar) {
        return this.zza - zzhuVar.zza;
    }

    public final boolean equals(@Nullable Object obj) {
        if (obj instanceof zzhu) {
            zzhu zzhuVar = (zzhu) obj;
            if (this.zza == zzhuVar.zza && zziz.zza(this.zzd, zzhuVar.zzd) && Arrays.equals(this.zzc, zzhuVar.zzc)) {
                return true;
            }
        }
        return false;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Configuration(");
        sb.append(this.zza);
        sb.append(", (");
        Iterator it = this.zzd.values().iterator();
        while (it.hasNext()) {
            sb.append((zzid) it.next());
            sb.append(", ");
        }
        sb.append("), (");
        String[] strArr = this.zzc;
        if (strArr != null) {
            for (String str : strArr) {
                sb.append(str);
                sb.append(", ");
            }
        } else {
            sb.append("null");
        }
        sb.append("))");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int i2 = this.zza;
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 2, i2);
        SafeParcelWriter.writeTypedArray(parcel, 3, this.zzb, i, false);
        SafeParcelWriter.writeStringArray(parcel, 4, this.zzc, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
