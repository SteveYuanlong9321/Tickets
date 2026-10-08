package com.google.android.gms.nearby.messages.internal;

import com.google.android.gms.common.internal.Preconditions;
import java.nio.ByteBuffer;
import java.util.UUID;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzl extends zzc {
    /* JADX WARN: Illegal instructions before constructor call */
    public zzl(UUID uuid, Short sh, Short sh2) {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate((sh == null ? 0 : 2) + 16 + (sh2 != null ? 2 : 0));
        byteBufferAllocate.putLong(uuid.getMostSignificantBits()).putLong(uuid.getLeastSignificantBits());
        if (sh != null) {
            byteBufferAllocate.putShort(sh.shortValue());
        }
        if (sh2 != null) {
            byteBufferAllocate.putShort(sh2.shortValue());
        }
        byte[] bArrArray = byteBufferAllocate.array();
        zzh(bArrArray);
        super(bArrArray);
    }

    private static byte[] zzh(byte[] bArr) {
        int length = bArr.length;
        boolean z = true;
        if (length != 16 && length != 18 && length != 20) {
            z = false;
        }
        Preconditions.checkArgument(z, "Prefix must be a UUID, a UUID and a major, or a UUID, a major, and a minor.");
        return bArr;
    }

    @Override // com.google.android.gms.nearby.messages.internal.zzc
    public final String toString() {
        String string = zze().toString();
        int length = string.length();
        Short shZzf = zzf();
        Short shZzg = zzg();
        StringBuilder sb = new StringBuilder(length + 38 + String.valueOf(shZzf).length() + 8 + String.valueOf(shZzg).length() + 1);
        sb.append("IBeaconIdPrefix{proximityUuid=");
        sb.append(string);
        sb.append(", major=");
        sb.append(shZzf);
        sb.append(", minor=");
        sb.append(shZzg);
        sb.append("}");
        return sb.toString();
    }

    public final UUID zze() {
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(zzc());
        return new UUID(byteBufferWrap.getLong(), byteBufferWrap.getLong());
    }

    public final Short zzf() {
        byte[] bArrZzc = zzc();
        if (bArrZzc.length >= 18) {
            return Short.valueOf(ByteBuffer.wrap(bArrZzc).getShort(16));
        }
        return null;
    }

    public final Short zzg() {
        byte[] bArrZzc = zzc();
        if (bArrZzc.length == 20) {
            return Short.valueOf(ByteBuffer.wrap(bArrZzc).getShort(18));
        }
        return null;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzl(byte[] bArr) {
        super(bArr);
        zzh(bArr);
    }
}
