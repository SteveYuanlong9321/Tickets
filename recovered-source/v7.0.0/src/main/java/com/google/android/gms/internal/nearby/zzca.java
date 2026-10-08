package com.google.android.gms.internal.nearby;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzca implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iValidateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        String strCreateString = null;
        String strCreateString2 = null;
        String strCreateString3 = null;
        byte[] bArrCreateByteArray = null;
        byte[] bArrCreateByteArray2 = null;
        ArrayList arrayListCreateTypedList = null;
        zzcb zzcbVar = null;
        byte[] bArrCreateByteArray3 = null;
        zzbp zzbpVar = null;
        String strCreateString4 = null;
        ArrayList<Integer> arrayListCreateIntegerList = null;
        String strCreateString5 = "";
        String strCreateString6 = strCreateString5;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        long j = 0;
        long j2 = 0;
        while (parcel.dataPosition() < iValidateObjectHeader) {
            int header = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(header)) {
                case 1:
                    j = SafeParcelReader.readLong(parcel, header);
                    break;
                case 2:
                    strCreateString = SafeParcelReader.createString(parcel, header);
                    break;
                case 3:
                    i = SafeParcelReader.readInt(parcel, header);
                    break;
                case 4:
                    strCreateString2 = SafeParcelReader.createString(parcel, header);
                    break;
                case 5:
                    j2 = SafeParcelReader.readLong(parcel, header);
                    break;
                case 6:
                    strCreateString3 = SafeParcelReader.createString(parcel, header);
                    break;
                case 7:
                    bArrCreateByteArray = SafeParcelReader.createByteArray(parcel, header);
                    break;
                case 8:
                    bArrCreateByteArray2 = SafeParcelReader.createByteArray(parcel, header);
                    break;
                case 9:
                    arrayListCreateTypedList = SafeParcelReader.createTypedList(parcel, header, zzbx.CREATOR);
                    break;
                case 10:
                    zzcbVar = (zzcb) SafeParcelReader.createParcelable(parcel, header, zzcb.CREATOR);
                    break;
                case 11:
                    bArrCreateByteArray3 = SafeParcelReader.createByteArray(parcel, header);
                    break;
                case 12:
                    zzbpVar = (zzbp) SafeParcelReader.createParcelable(parcel, header, zzbp.CREATOR);
                    break;
                case 13:
                    i2 = SafeParcelReader.readInt(parcel, header);
                    break;
                case 14:
                    i3 = SafeParcelReader.readInt(parcel, header);
                    break;
                case 15:
                    strCreateString4 = SafeParcelReader.createString(parcel, header);
                    break;
                case 16:
                    strCreateString5 = SafeParcelReader.createString(parcel, header);
                    break;
                case 17:
                    strCreateString6 = SafeParcelReader.createString(parcel, header);
                    break;
                case 18:
                    arrayListCreateIntegerList = SafeParcelReader.createIntegerList(parcel, header);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, header);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, iValidateObjectHeader);
        return new zzbz(j, strCreateString, i, strCreateString2, j2, strCreateString3, bArrCreateByteArray, bArrCreateByteArray2, arrayListCreateTypedList, zzcbVar, bArrCreateByteArray3, zzbpVar, i2, i3, strCreateString4, strCreateString5, strCreateString6, arrayListCreateIntegerList);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new zzbz[i];
    }
}
