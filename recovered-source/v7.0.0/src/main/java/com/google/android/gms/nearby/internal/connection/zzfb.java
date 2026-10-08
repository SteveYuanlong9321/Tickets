package com.google.android.gms.nearby.internal.connection;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzfb extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzfb> CREATOR = new zzfc();
    private final List zza;

    private zzfb() {
        this.zza = new ArrayList();
    }

    public final boolean equals(Object obj) {
        List list;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzfb)) {
            return false;
        }
        zzfb zzfbVar = (zzfb) obj;
        List list2 = this.zza;
        if (list2 == null && zzfbVar.zza == null) {
            return true;
        }
        if (list2 == null || (list = zzfbVar.zza) == null || list2.size() != list.size()) {
            return false;
        }
        for (int i = 0; i < list2.size(); i++) {
            Bundle bundle = (Bundle) list2.get(i);
            Bundle bundle2 = (Bundle) list.get(i);
            if (!Arrays.equals(bundle != null ? bundle.getByteArray("bytes") : null, bundle2 != null ? bundle2.getByteArray("bytes") : null)) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        return Objects.hash(this.zza);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        List list = this.zza;
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeTypedList(parcel, 1, list, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public final List zza() {
        com.google.android.gms.nearby.connection.zzq zzqVarZza;
        List list = this.zza;
        ArrayList arrayList = new ArrayList(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            byte[] byteArray = ((Bundle) it.next()).getByteArray("bytes");
            if (byteArray != null && (zzqVarZza = com.google.android.gms.nearby.connection.zzq.zza(byteArray)) != null) {
                arrayList.add(zzqVarZza);
            }
        }
        return arrayList;
    }

    zzfb(List list) {
        this.zza = list;
    }
}
