package com.google.android.gms.internal.nearby;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.Arrays;
import java.util.Locale;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzjo extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzjo> CREATOR = new zzjp();
    private final float[] zza;
    private final float[] zzb;

    public zzjo(float[] fArr, float[] fArr2) {
        zzxd.zzg(fArr, "Translation cannot be null");
        zzxd.zzb(fArr.length == 3, "Translation must have 3 elements");
        zzxd.zzg(fArr2, "Rotation cannot be null");
        zzxd.zzb(fArr2.length == 4, "Rotation must have 4 elements");
        this.zza = fArr;
        this.zzb = fArr2;
    }

    public final String toString() {
        return String.format(Locale.US, "Pose<translation=%s, rotation=%s>", Arrays.toString(this.zza), Arrays.toString(this.zzb));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        float[] fArr = this.zza;
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeFloatArray(parcel, 1, fArr, false);
        SafeParcelWriter.writeFloatArray(parcel, 2, this.zzb, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
