package com.google.android.gms.nearby.internal.connection;

import android.os.Parcel;
import android.os.ParcelUuid;
import android.os.Parcelable;
import androidx.core.view.MotionEventCompat;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.nearby.connection.Strategy;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzf implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iValidateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = false;
        int i = 0;
        int i2 = 0;
        boolean z5 = false;
        boolean z6 = false;
        int i3 = 0;
        int i4 = 0;
        boolean z7 = false;
        boolean z8 = false;
        boolean z9 = false;
        boolean z10 = true;
        boolean z11 = true;
        boolean z12 = true;
        boolean z13 = true;
        boolean z14 = true;
        boolean z15 = true;
        boolean z16 = true;
        boolean z17 = true;
        boolean z18 = true;
        boolean z19 = true;
        boolean z20 = true;
        boolean z21 = true;
        boolean z22 = true;
        boolean z23 = true;
        boolean z24 = true;
        Strategy strategy = null;
        byte[] bArrCreateByteArray = null;
        ParcelUuid parcelUuid = null;
        byte[] bArrCreateByteArray2 = null;
        com.google.android.gms.nearby.connection.zzz[] zzzVarArr = null;
        int[] iArrCreateIntArray = null;
        int[] iArrCreateIntArray2 = null;
        byte[] bArrCreateByteArray3 = null;
        String strCreateString = null;
        com.google.android.gms.internal.nearby.zzy zzyVar = null;
        long j = 0;
        long j2 = 0;
        while (parcel.dataPosition() < iValidateObjectHeader) {
            int header = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(header)) {
                case 1:
                    strategy = (Strategy) SafeParcelReader.createParcelable(parcel, header, Strategy.CREATOR);
                    break;
                case 2:
                    z10 = SafeParcelReader.readBoolean(parcel, header);
                    break;
                case 3:
                    z11 = SafeParcelReader.readBoolean(parcel, header);
                    break;
                case 4:
                    z12 = SafeParcelReader.readBoolean(parcel, header);
                    break;
                case 5:
                    z13 = SafeParcelReader.readBoolean(parcel, header);
                    break;
                case 6:
                    bArrCreateByteArray = SafeParcelReader.createByteArray(parcel, header);
                    break;
                case 7:
                    z = SafeParcelReader.readBoolean(parcel, header);
                    break;
                case 8:
                    parcelUuid = (ParcelUuid) SafeParcelReader.createParcelable(parcel, header, ParcelUuid.CREATOR);
                    break;
                case 9:
                    z14 = SafeParcelReader.readBoolean(parcel, header);
                    break;
                case 10:
                    z15 = SafeParcelReader.readBoolean(parcel, header);
                    break;
                case 11:
                    z16 = SafeParcelReader.readBoolean(parcel, header);
                    break;
                case 12:
                    z2 = SafeParcelReader.readBoolean(parcel, header);
                    break;
                case 13:
                    z3 = SafeParcelReader.readBoolean(parcel, header);
                    break;
                case 14:
                    z4 = SafeParcelReader.readBoolean(parcel, header);
                    break;
                case 15:
                    i = SafeParcelReader.readInt(parcel, header);
                    break;
                case 16:
                    i2 = SafeParcelReader.readInt(parcel, header);
                    break;
                case 17:
                    bArrCreateByteArray2 = SafeParcelReader.createByteArray(parcel, header);
                    break;
                case 18:
                    j = SafeParcelReader.readLong(parcel, header);
                    break;
                case 19:
                    zzzVarArr = (com.google.android.gms.nearby.connection.zzz[]) SafeParcelReader.createTypedArray(parcel, header, com.google.android.gms.nearby.connection.zzz.CREATOR);
                    break;
                case 20:
                    z5 = SafeParcelReader.readBoolean(parcel, header);
                    break;
                case 21:
                    z17 = SafeParcelReader.readBoolean(parcel, header);
                    break;
                case 22:
                    z6 = SafeParcelReader.readBoolean(parcel, header);
                    break;
                case 23:
                    z18 = SafeParcelReader.readBoolean(parcel, header);
                    break;
                case 24:
                    iArrCreateIntArray = SafeParcelReader.createIntArray(parcel, header);
                    break;
                case 25:
                    iArrCreateIntArray2 = SafeParcelReader.createIntArray(parcel, header);
                    break;
                case 26:
                    z19 = SafeParcelReader.readBoolean(parcel, header);
                    break;
                case 27:
                    i3 = SafeParcelReader.readInt(parcel, header);
                    break;
                case 28:
                    bArrCreateByteArray3 = SafeParcelReader.createByteArray(parcel, header);
                    break;
                case 29:
                    z20 = SafeParcelReader.readBoolean(parcel, header);
                    break;
                case 30:
                    i4 = SafeParcelReader.readInt(parcel, header);
                    break;
                case 31:
                    z7 = SafeParcelReader.readBoolean(parcel, header);
                    break;
                case 32:
                    z21 = SafeParcelReader.readBoolean(parcel, header);
                    break;
                case 33:
                    z22 = SafeParcelReader.readBoolean(parcel, header);
                    break;
                case 34:
                    z23 = SafeParcelReader.readBoolean(parcel, header);
                    break;
                case 35:
                    j2 = SafeParcelReader.readLong(parcel, header);
                    break;
                case 36:
                    strCreateString = SafeParcelReader.createString(parcel, header);
                    break;
                case 37:
                    zzyVar = (com.google.android.gms.internal.nearby.zzy) SafeParcelReader.createParcelable(parcel, header, com.google.android.gms.internal.nearby.zzy.CREATOR);
                    break;
                case MotionEventCompat.AXIS_GENERIC_7 /* 38 */:
                    z8 = SafeParcelReader.readBoolean(parcel, header);
                    break;
                case 39:
                    z24 = SafeParcelReader.readBoolean(parcel, header);
                    break;
                case 40:
                    z9 = SafeParcelReader.readBoolean(parcel, header);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, header);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, iValidateObjectHeader);
        return new zze(strategy, z10, z11, z12, z13, bArrCreateByteArray, z, parcelUuid, z14, z15, z16, z2, z3, z4, i, i2, bArrCreateByteArray2, j, zzzVarArr, z5, z17, z6, z18, iArrCreateIntArray, iArrCreateIntArray2, z19, i3, bArrCreateByteArray3, z20, i4, z7, z21, z22, z23, j2, strCreateString, zzyVar, z8, z24, z9);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new zze[i];
    }
}
