package com.google.android.gms.nearby.messages.internal;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.ArrayUtils;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzg extends zzc {
    public zzg(String str, String str2) {
        byte[] bArrZzb = zzb(str);
        int length = bArrZzb.length;
        byte[] bArrZzb2 = zzb(str2);
        StringBuilder sb = new StringBuilder(String.valueOf(length).length() + 42);
        sb.append("Namespace length(");
        sb.append(length);
        sb.append(" bytes) must be 10 bytes.");
        Preconditions.checkArgument(length == 10, sb.toString());
        int length2 = bArrZzb2.length;
        StringBuilder sb2 = new StringBuilder(String.valueOf(length2).length() + 40);
        sb2.append("Instance length(");
        sb2.append(length2);
        sb2.append(" bytes) must be 6 bytes.");
        Preconditions.checkArgument(length2 == 6, sb2.toString());
        byte[] bArrConcatByteArrays = ArrayUtils.concatByteArrays(bArrZzb, bArrZzb2);
        zze(bArrConcatByteArrays);
        super(bArrConcatByteArrays);
    }

    private static byte[] zze(byte[] bArr) {
        int length = bArr.length;
        boolean z = true;
        if (length != 10 && length != 16) {
            z = false;
        }
        Preconditions.checkArgument(z, "Bytes must be a namespace (10 bytes), or a namespace plus instance (16 bytes).");
        return bArr;
    }

    @Override // com.google.android.gms.nearby.messages.internal.zzc
    public final String toString() {
        String strZzd = zzd();
        StringBuilder sb = new StringBuilder(strZzd.length() + 26);
        sb.append("EddystoneUidPrefix{bytes=");
        sb.append(strZzd);
        sb.append("}");
        return sb.toString();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzg(byte[] bArr) {
        super(bArr);
        zze(bArr);
    }
}
