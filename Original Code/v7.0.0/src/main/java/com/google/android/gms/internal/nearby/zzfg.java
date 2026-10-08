package com.google.android.gms.internal.nearby;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.nearby.uwb.PrecisionFindingConfig;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzfg implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iValidateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        byte[] bArrCreateByteArray = null;
        zzgi zzgiVar = null;
        zzhs[] zzhsVarArr = null;
        byte[] bArrCreateByteArray2 = null;
        zzhs zzhsVar = null;
        zzes zzesVar = null;
        zzev zzevVar = null;
        PrecisionFindingConfig precisionFindingConfig = null;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        boolean z = false;
        while (parcel.dataPosition() < iValidateObjectHeader) {
            int header = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(header)) {
                case 1:
                    i = SafeParcelReader.readInt(parcel, header);
                    break;
                case 2:
                    i2 = SafeParcelReader.readInt(parcel, header);
                    break;
                case 3:
                    bArrCreateByteArray = SafeParcelReader.createByteArray(parcel, header);
                    break;
                case 4:
                    zzgiVar = (zzgi) SafeParcelReader.createParcelable(parcel, header, zzgi.CREATOR);
                    break;
                case 5:
                    i3 = SafeParcelReader.readInt(parcel, header);
                    break;
                case 6:
                    zzhsVarArr = (zzhs[]) SafeParcelReader.createTypedArray(parcel, header, zzhs.CREATOR);
                    break;
                case 7:
                    i4 = SafeParcelReader.readInt(parcel, header);
                    break;
                case 8:
                    bArrCreateByteArray2 = SafeParcelReader.createByteArray(parcel, header);
                    break;
                case 9:
                    zzhsVar = (zzhs) SafeParcelReader.createParcelable(parcel, header, zzhs.CREATOR);
                    break;
                case 10:
                    zzesVar = (zzes) SafeParcelReader.createParcelable(parcel, header, zzes.CREATOR);
                    break;
                case 11:
                    i5 = SafeParcelReader.readInt(parcel, header);
                    break;
                case 12:
                    i6 = SafeParcelReader.readInt(parcel, header);
                    break;
                case 13:
                    z = SafeParcelReader.readBoolean(parcel, header);
                    break;
                case 14:
                    zzevVar = (zzev) SafeParcelReader.createParcelable(parcel, header, zzev.CREATOR);
                    break;
                case 15:
                    precisionFindingConfig = (PrecisionFindingConfig) SafeParcelReader.createParcelable(parcel, header, PrecisionFindingConfig.CREATOR);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, header);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, iValidateObjectHeader);
        return new zzff(i, i2, bArrCreateByteArray, zzgiVar, i3, zzhsVarArr, i4, bArrCreateByteArray2, zzhsVar, zzesVar, i5, i6, z, zzevVar, precisionFindingConfig);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new zzff[i];
    }
}
