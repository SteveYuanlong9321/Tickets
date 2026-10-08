package com.google.android.gms.internal.nearby;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Base64;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzia extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzia> CREATOR = new zzib();
    public static final byte[][] zza;
    public final String zzb;
    public final byte[] zzc;
    public final byte[][] zzd;
    public final byte[][] zze;
    public final byte[][] zzf;
    public final byte[][] zzg;
    public final int[] zzh;
    public final byte[][] zzi;
    public final int[] zzj;
    final byte[][] zzk;

    static {
        byte[][] bArr = new byte[0][];
        zza = bArr;
        new zzia("", null, bArr, bArr, bArr, bArr, null, null, null, null);
    }

    public zzia(String str, byte[] bArr, byte[][] bArr2, byte[][] bArr3, byte[][] bArr4, byte[][] bArr5, int[] iArr, byte[][] bArr6, int[] iArr2, byte[][] bArr7) {
        this.zzb = str;
        this.zzc = bArr;
        this.zzd = bArr2;
        this.zze = bArr3;
        this.zzf = bArr4;
        this.zzg = bArr5;
        this.zzh = iArr;
        this.zzi = bArr6;
        this.zzj = iArr2;
        this.zzk = bArr7;
    }

    private static void zza(StringBuilder sb, String str, byte[][] bArr) {
        sb.append(str);
        sb.append("=");
        if (bArr == null) {
            sb.append("null");
            return;
        }
        sb.append("(");
        boolean z = true;
        int i = 0;
        while (i < bArr.length) {
            byte[] bArr2 = bArr[i];
            if (!z) {
                sb.append(", ");
            }
            sb.append("'");
            Preconditions.checkNotNull(bArr2);
            sb.append(Base64.encodeToString(bArr2, 3));
            sb.append("'");
            i++;
            z = false;
        }
        sb.append(")");
    }

    private final Set zzb() {
        ArrayList arrayList = new ArrayList();
        byte[][] bArr = this.zzi;
        if (bArr != null) {
            Collections.addAll(arrayList, bArr);
        }
        byte[] bArr2 = this.zzc;
        if (bArr2 != null) {
            arrayList.add(bArr2);
        }
        return zzc((byte[][]) arrayList.toArray(new byte[0][]));
    }

    private static List zze(int[] iArr) {
        if (iArr == null) {
            return Collections.EMPTY_LIST;
        }
        ArrayList arrayList = new ArrayList(iArr.length >> 1);
        for (int i = 0; i < iArr.length; i += 2) {
            arrayList.add(new zzij(iArr[i], iArr[i + 1]));
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzia) {
            zzia zziaVar = (zzia) obj;
            if (zziz.zza(this.zzb, zziaVar.zzb) && zziz.zza(zzb(), zziaVar.zzb()) && zziz.zza(zzc(this.zzd), zzc(zziaVar.zzd)) && zziz.zza(zzc(this.zze), zzc(zziaVar.zze)) && zziz.zza(zzc(this.zzf), zzc(zziaVar.zzf)) && zziz.zza(zzc(this.zzg), zzc(zziaVar.zzg)) && zziz.zza(zzd(this.zzh), zzd(zziaVar.zzh)) && zziz.zza(zze(this.zzj), zze(zziaVar.zzj)) && zziz.zza(zzc(this.zzk), zzc(zziaVar.zzk))) {
                return true;
            }
        }
        return false;
    }

    public final String toString() {
        String string;
        StringBuilder sb = new StringBuilder("ExperimentTokens");
        sb.append("(");
        String str = this.zzb;
        if (str == null) {
            string = "null";
        } else {
            StringBuilder sb2 = new StringBuilder(str.length() + 2);
            sb2.append("'");
            sb2.append(str);
            sb2.append("'");
            string = sb2.toString();
        }
        sb.append(string);
        byte[] bArr = this.zzc;
        sb.append(", direct==");
        if (bArr == null) {
            sb.append("null");
        } else {
            sb.append("'");
            sb.append(Base64.encodeToString(bArr, 3));
            sb.append("'");
        }
        sb.append(", ");
        zza(sb, "GAIA=", this.zzd);
        sb.append(", ");
        zza(sb, "PSEUDO=", this.zze);
        sb.append(", ");
        zza(sb, "ALWAYS=", this.zzf);
        sb.append(", ");
        zza(sb, "OTHER=", this.zzg);
        sb.append(", weak=");
        sb.append(Arrays.toString(this.zzh));
        sb.append(", ");
        zza(sb, "directs=", this.zzi);
        sb.append(", genDims=");
        sb.append(Arrays.toString(zze(this.zzj).toArray()));
        sb.append(", ");
        zza(sb, "external=", this.zzk);
        sb.append(")");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        String str = this.zzb;
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, str, false);
        SafeParcelWriter.writeByteArray(parcel, 3, this.zzc, false);
        SafeParcelWriter.writeByteArrayArray(parcel, 4, this.zzd, false);
        SafeParcelWriter.writeByteArrayArray(parcel, 5, this.zze, false);
        SafeParcelWriter.writeByteArrayArray(parcel, 6, this.zzf, false);
        SafeParcelWriter.writeByteArrayArray(parcel, 7, this.zzg, false);
        SafeParcelWriter.writeIntArray(parcel, 8, this.zzh, false);
        SafeParcelWriter.writeByteArrayArray(parcel, 9, this.zzi, false);
        SafeParcelWriter.writeIntArray(parcel, 10, this.zzj, false);
        SafeParcelWriter.writeByteArrayArray(parcel, 11, this.zzk, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    private static Set zzc(byte[][] bArr) {
        int length;
        if (bArr == null || (length = bArr.length) == 0) {
            return Collections.EMPTY_SET;
        }
        HashSet hashSetZza = zzzh.zza(length);
        for (byte[] bArr2 : bArr) {
            Preconditions.checkNotNull(bArr2);
            hashSetZza.add(Base64.encodeToString(bArr2, 3));
        }
        return hashSetZza;
    }

    private static Set zzd(int[] iArr) {
        int length;
        if (iArr == null || (length = iArr.length) == 0) {
            return Collections.EMPTY_SET;
        }
        HashSet hashSetZza = zzzh.zza(length);
        for (int i : iArr) {
            hashSetZza.add(Integer.valueOf(i));
        }
        return hashSetZza;
    }
}
