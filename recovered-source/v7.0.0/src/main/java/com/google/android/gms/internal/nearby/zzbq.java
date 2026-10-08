package com.google.android.gms.internal.nearby;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzbq implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iValidateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        zzcd zzcdVar = null;
        zzbm zzbmVar = null;
        byte[] bArrCreateByteArray = null;
        ArrayList arrayListCreateTypedList = null;
        ArrayList arrayListCreateTypedList2 = null;
        ArrayList arrayListCreateTypedList3 = null;
        zzcf zzcfVar = null;
        zzbt zzbtVar = null;
        byte[] bArrCreateByteArray2 = null;
        ArrayList arrayListCreateTypedList4 = null;
        ArrayList arrayListCreateTypedList5 = null;
        zzbv zzbvVar = null;
        boolean z = false;
        while (parcel.dataPosition() < iValidateObjectHeader) {
            int header = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(header)) {
                case 1:
                    zzcdVar = (zzcd) SafeParcelReader.createParcelable(parcel, header, zzcd.CREATOR);
                    break;
                case 2:
                    zzbmVar = (zzbm) SafeParcelReader.createParcelable(parcel, header, zzbm.CREATOR);
                    break;
                case 3:
                    bArrCreateByteArray = SafeParcelReader.createByteArray(parcel, header);
                    break;
                case 4:
                    z = SafeParcelReader.readBoolean(parcel, header);
                    break;
                case 5:
                    arrayListCreateTypedList = SafeParcelReader.createTypedList(parcel, header, com.google.android.gms.nearby.connection.zzg.CREATOR);
                    break;
                case 6:
                    arrayListCreateTypedList2 = SafeParcelReader.createTypedList(parcel, header, com.google.android.gms.nearby.connection.zzaf.CREATOR);
                    break;
                case 7:
                    arrayListCreateTypedList3 = SafeParcelReader.createTypedList(parcel, header, com.google.android.gms.nearby.connection.zzj.CREATOR);
                    break;
                case 8:
                    zzcfVar = (zzcf) SafeParcelReader.createParcelable(parcel, header, zzcf.CREATOR);
                    break;
                case 9:
                    zzbtVar = (zzbt) SafeParcelReader.createParcelable(parcel, header, zzbt.CREATOR);
                    break;
                case 10:
                    bArrCreateByteArray2 = SafeParcelReader.createByteArray(parcel, header);
                    break;
                case 11:
                    arrayListCreateTypedList4 = SafeParcelReader.createTypedList(parcel, header, zzbr.CREATOR);
                    break;
                case 12:
                    arrayListCreateTypedList5 = SafeParcelReader.createTypedList(parcel, header, zzbr.CREATOR);
                    break;
                case 13:
                    zzbvVar = (zzbv) SafeParcelReader.createParcelable(parcel, header, zzbv.CREATOR);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, header);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, iValidateObjectHeader);
        return new zzbp(zzcdVar, zzbmVar, bArrCreateByteArray, z, arrayListCreateTypedList, arrayListCreateTypedList2, arrayListCreateTypedList3, zzcfVar, zzbtVar, bArrCreateByteArray2, arrayListCreateTypedList4, arrayListCreateTypedList5, zzbvVar);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new zzbp[i];
    }
}
