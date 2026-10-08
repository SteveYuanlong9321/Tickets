package com.google.android.gms.nearby.internal.connection;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.nearby.connection.v3.dct.DctDevice;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzes implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iValidateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        String strCreateString = null;
        com.google.android.gms.internal.nearby.zzbz zzbzVar = null;
        com.google.android.gms.nearby.connection.zzo zzoVar = null;
        DctDevice dctDevice = null;
        String strCreateString2 = null;
        String strCreateString3 = null;
        int i11 = -1;
        while (parcel.dataPosition() < iValidateObjectHeader) {
            int header = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(header)) {
                case 1:
                    strCreateString = SafeParcelReader.createString(parcel, header);
                    break;
                case 2:
                    i = SafeParcelReader.readInt(parcel, header);
                    break;
                case 3:
                    i2 = SafeParcelReader.readInt(parcel, header);
                    break;
                case 4:
                    i3 = SafeParcelReader.readInt(parcel, header);
                    break;
                case 5:
                    zzbzVar = (com.google.android.gms.internal.nearby.zzbz) SafeParcelReader.createParcelable(parcel, header, com.google.android.gms.internal.nearby.zzbz.CREATOR);
                    break;
                case 6:
                    zzoVar = (com.google.android.gms.nearby.connection.zzo) SafeParcelReader.createParcelable(parcel, header, com.google.android.gms.nearby.connection.zzo.CREATOR);
                    break;
                case 7:
                    i11 = SafeParcelReader.readInt(parcel, header);
                    break;
                case 8:
                    i4 = SafeParcelReader.readInt(parcel, header);
                    break;
                case 9:
                    i5 = SafeParcelReader.readInt(parcel, header);
                    break;
                case 10:
                    i6 = SafeParcelReader.readInt(parcel, header);
                    break;
                case 11:
                    dctDevice = (DctDevice) SafeParcelReader.createParcelable(parcel, header, DctDevice.CREATOR);
                    break;
                case 12:
                    i7 = SafeParcelReader.readInt(parcel, header);
                    break;
                case 13:
                    i8 = SafeParcelReader.readInt(parcel, header);
                    break;
                case 14:
                    strCreateString2 = SafeParcelReader.createString(parcel, header);
                    break;
                case 15:
                    strCreateString3 = SafeParcelReader.createString(parcel, header);
                    break;
                case 16:
                    i9 = SafeParcelReader.readInt(parcel, header);
                    break;
                case 17:
                    i10 = SafeParcelReader.readInt(parcel, header);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, header);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, iValidateObjectHeader);
        return new zzer(strCreateString, i, i2, i3, zzbzVar, zzoVar, dctDevice, i11, i4, i5, i6, i7, i8, strCreateString2, strCreateString3, i9, i10);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new zzer[i];
    }
}
