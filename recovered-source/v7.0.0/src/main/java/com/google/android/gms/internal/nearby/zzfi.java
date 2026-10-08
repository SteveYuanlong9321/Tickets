package com.google.android.gms.internal.nearby;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzfi implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iValidateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        zzfc zzfcVar = null;
        zzfc zzfcVar2 = null;
        zzfc zzfcVar3 = null;
        zzcu zzcuVar = null;
        zzep zzepVar = null;
        int i = -128;
        long j = 0;
        while (parcel.dataPosition() < iValidateObjectHeader) {
            int header = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(header)) {
                case 1:
                    zzfcVar = (zzfc) SafeParcelReader.createParcelable(parcel, header, zzfc.CREATOR);
                    break;
                case 2:
                    zzfcVar2 = (zzfc) SafeParcelReader.createParcelable(parcel, header, zzfc.CREATOR);
                    break;
                case 3:
                    zzfcVar3 = (zzfc) SafeParcelReader.createParcelable(parcel, header, zzfc.CREATOR);
                    break;
                case 4:
                    j = SafeParcelReader.readLong(parcel, header);
                    break;
                case 5:
                    i = SafeParcelReader.readInt(parcel, header);
                    break;
                case 6:
                    zzcuVar = (zzcu) SafeParcelReader.createParcelable(parcel, header, zzcu.CREATOR);
                    break;
                case 7:
                    zzepVar = (zzep) SafeParcelReader.createParcelable(parcel, header, zzep.CREATOR);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, header);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, iValidateObjectHeader);
        return new zzfh(zzfcVar, zzfcVar2, zzfcVar3, j, i, zzcuVar, zzepVar);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new zzfh[i];
    }
}
