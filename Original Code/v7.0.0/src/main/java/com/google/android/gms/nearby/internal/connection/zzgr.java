package com.google.android.gms.nearby.internal.connection;

import android.net.Uri;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzgr implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iValidateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        int i = 0;
        boolean z = false;
        int i2 = 0;
        byte[] bArrCreateByteArray = null;
        ParcelFileDescriptor parcelFileDescriptor = null;
        String strCreateString = null;
        ParcelFileDescriptor parcelFileDescriptor2 = null;
        Uri uri = null;
        ParcelByteArray parcelByteArray = null;
        String strCreateString2 = null;
        String strCreateString3 = null;
        zzgt zzgtVar = null;
        zzgw zzgwVar = null;
        zzgn zzgnVar = null;
        long j = 0;
        long j2 = 0;
        long j3 = 0;
        long j4 = -1;
        while (parcel.dataPosition() < iValidateObjectHeader) {
            int header = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(header)) {
                case 1:
                    j = SafeParcelReader.readLong(parcel, header);
                    break;
                case 2:
                    i = SafeParcelReader.readInt(parcel, header);
                    break;
                case 3:
                    bArrCreateByteArray = SafeParcelReader.createByteArray(parcel, header);
                    break;
                case 4:
                    parcelFileDescriptor = (ParcelFileDescriptor) SafeParcelReader.createParcelable(parcel, header, ParcelFileDescriptor.CREATOR);
                    break;
                case 5:
                    strCreateString = SafeParcelReader.createString(parcel, header);
                    break;
                case 6:
                    j4 = SafeParcelReader.readLong(parcel, header);
                    break;
                case 7:
                    parcelFileDescriptor2 = (ParcelFileDescriptor) SafeParcelReader.createParcelable(parcel, header, ParcelFileDescriptor.CREATOR);
                    break;
                case 8:
                    uri = (Uri) SafeParcelReader.createParcelable(parcel, header, Uri.CREATOR);
                    break;
                case 9:
                    j2 = SafeParcelReader.readLong(parcel, header);
                    break;
                case 10:
                    z = SafeParcelReader.readBoolean(parcel, header);
                    break;
                case 11:
                    parcelByteArray = (ParcelByteArray) SafeParcelReader.createParcelable(parcel, header, ParcelByteArray.CREATOR);
                    break;
                case 12:
                    j3 = SafeParcelReader.readLong(parcel, header);
                    break;
                case 13:
                    strCreateString2 = SafeParcelReader.createString(parcel, header);
                    break;
                case 14:
                    strCreateString3 = SafeParcelReader.createString(parcel, header);
                    break;
                case 15:
                    zzgtVar = (zzgt) SafeParcelReader.createParcelable(parcel, header, zzgt.CREATOR);
                    break;
                case 16:
                    zzgwVar = (zzgw) SafeParcelReader.createParcelable(parcel, header, zzgw.CREATOR);
                    break;
                case 17:
                    i2 = SafeParcelReader.readInt(parcel, header);
                    break;
                case 18:
                    zzgnVar = (zzgn) SafeParcelReader.createParcelable(parcel, header, zzgn.CREATOR);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, header);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, iValidateObjectHeader);
        return new zzgq(j, i, bArrCreateByteArray, parcelFileDescriptor, strCreateString, j4, parcelFileDescriptor2, uri, j2, z, parcelByteArray, j3, strCreateString2, strCreateString3, zzgtVar, zzgwVar, zzgnVar, i2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new zzgq[i];
    }
}
