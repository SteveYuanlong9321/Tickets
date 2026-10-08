package com.google.android.gms.nearby.internal.connection;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.nearby.connection.PayloadTransferUpdate;
import com.google.android.gms.nearby.connection.v3.dct.DctDevice;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzfu implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iValidateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        String strCreateString = null;
        PayloadTransferUpdate payloadTransferUpdate = null;
        com.google.android.gms.internal.nearby.zzbz zzbzVar = null;
        com.google.android.gms.nearby.connection.zzo zzoVar = null;
        DctDevice dctDevice = null;
        int i = 0;
        while (parcel.dataPosition() < iValidateObjectHeader) {
            int header = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(header)) {
                case 1:
                    strCreateString = SafeParcelReader.createString(parcel, header);
                    break;
                case 2:
                    payloadTransferUpdate = (PayloadTransferUpdate) SafeParcelReader.createParcelable(parcel, header, PayloadTransferUpdate.CREATOR);
                    break;
                case 3:
                    i = SafeParcelReader.readInt(parcel, header);
                    break;
                case 4:
                    zzbzVar = (com.google.android.gms.internal.nearby.zzbz) SafeParcelReader.createParcelable(parcel, header, com.google.android.gms.internal.nearby.zzbz.CREATOR);
                    break;
                case 5:
                    zzoVar = (com.google.android.gms.nearby.connection.zzo) SafeParcelReader.createParcelable(parcel, header, com.google.android.gms.nearby.connection.zzo.CREATOR);
                    break;
                case 6:
                    dctDevice = (DctDevice) SafeParcelReader.createParcelable(parcel, header, DctDevice.CREATOR);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, header);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, iValidateObjectHeader);
        return new zzft(strCreateString, payloadTransferUpdate, i, zzbzVar, zzoVar, dctDevice);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new zzft[i];
    }
}
