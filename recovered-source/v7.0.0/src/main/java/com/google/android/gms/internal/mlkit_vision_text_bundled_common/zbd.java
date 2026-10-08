package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* JADX INFO: compiled from: com.google.mlkit:text-recognition-bundled-common@@17.0.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zbd extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zbd> CREATOR = new zbe();
    public final int zba;
    public final int zbb;
    public final int zbc;
    public final int zbd;
    public final float zbe;

    public zbd(int i, int i2, int i3, int i4, float f) {
        this.zba = i;
        this.zbb = i2;
        this.zbc = i3;
        this.zbd = i4;
        this.zbe = f;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int i2 = this.zba;
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 2, i2);
        SafeParcelWriter.writeInt(parcel, 3, this.zbb);
        SafeParcelWriter.writeInt(parcel, 4, this.zbc);
        SafeParcelWriter.writeInt(parcel, 5, this.zbd);
        SafeParcelWriter.writeFloat(parcel, 6, this.zbe);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
