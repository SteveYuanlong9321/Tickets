package com.google.android.gms.internal.nearby;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzaek extends zzaee {
    private long zza;
    private long zzb;
    private int zzc;

    zzaek(int i) {
        super(16, 16);
        this.zza = 0L;
        this.zzb = 0L;
        this.zzc = 0;
    }

    @Override // com.google.android.gms.internal.nearby.zzaee
    protected final void zzc(ByteBuffer byteBuffer) {
        long j = byteBuffer.getLong() * (-8663945395140668459L);
        long j2 = byteBuffer.getLong();
        long jRotateLeft = (Long.rotateLeft(j, 31) * 5545529020109919103L) ^ this.zza;
        this.zza = jRotateLeft;
        long jRotateLeft2 = Long.rotateLeft(jRotateLeft, 27);
        long j3 = this.zzb;
        this.zza = ((jRotateLeft2 + j3) * 5) + 1390208809;
        long jRotateLeft3 = (Long.rotateLeft(j2 * 5545529020109919103L, 33) * (-8663945395140668459L)) ^ j3;
        this.zzb = jRotateLeft3;
        this.zzb = ((Long.rotateLeft(jRotateLeft3, 31) + this.zza) * 5) + 944331445;
        this.zzc += 16;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.google.android.gms.internal.nearby.zzaee
    protected final void zzd(ByteBuffer byteBuffer) {
        long unsignedInt;
        long unsignedInt2;
        long unsignedInt3;
        long unsignedInt4;
        long unsignedInt5;
        long unsignedInt6;
        long unsignedInt7;
        this.zzc += byteBuffer.remaining();
        long unsignedInt8 = 0;
        switch (byteBuffer.remaining()) {
            case 1:
                unsignedInt = 0;
                unsignedInt7 = unsignedInt ^ ((long) Byte.toUnsignedInt(byteBuffer.get(0)));
                this.zza = (Long.rotateLeft(unsignedInt7 * (-8663945395140668459L), 31) * 5545529020109919103L) ^ this.zza;
                this.zzb ^= Long.rotateLeft(unsignedInt8 * 5545529020109919103L, 33) * (-8663945395140668459L);
                return;
            case 2:
                unsignedInt2 = 0;
                unsignedInt = unsignedInt2 ^ (((long) Byte.toUnsignedInt(byteBuffer.get(1))) << 8);
                unsignedInt7 = unsignedInt ^ ((long) Byte.toUnsignedInt(byteBuffer.get(0)));
                this.zza = (Long.rotateLeft(unsignedInt7 * (-8663945395140668459L), 31) * 5545529020109919103L) ^ this.zza;
                this.zzb ^= Long.rotateLeft(unsignedInt8 * 5545529020109919103L, 33) * (-8663945395140668459L);
                return;
            case 3:
                unsignedInt3 = 0;
                unsignedInt2 = unsignedInt3 ^ (((long) Byte.toUnsignedInt(byteBuffer.get(2))) << 16);
                unsignedInt = unsignedInt2 ^ (((long) Byte.toUnsignedInt(byteBuffer.get(1))) << 8);
                unsignedInt7 = unsignedInt ^ ((long) Byte.toUnsignedInt(byteBuffer.get(0)));
                this.zza = (Long.rotateLeft(unsignedInt7 * (-8663945395140668459L), 31) * 5545529020109919103L) ^ this.zza;
                this.zzb ^= Long.rotateLeft(unsignedInt8 * 5545529020109919103L, 33) * (-8663945395140668459L);
                return;
            case 4:
                unsignedInt4 = 0;
                unsignedInt3 = unsignedInt4 ^ (((long) Byte.toUnsignedInt(byteBuffer.get(3))) << 24);
                unsignedInt2 = unsignedInt3 ^ (((long) Byte.toUnsignedInt(byteBuffer.get(2))) << 16);
                unsignedInt = unsignedInt2 ^ (((long) Byte.toUnsignedInt(byteBuffer.get(1))) << 8);
                unsignedInt7 = unsignedInt ^ ((long) Byte.toUnsignedInt(byteBuffer.get(0)));
                this.zza = (Long.rotateLeft(unsignedInt7 * (-8663945395140668459L), 31) * 5545529020109919103L) ^ this.zza;
                this.zzb ^= Long.rotateLeft(unsignedInt8 * 5545529020109919103L, 33) * (-8663945395140668459L);
                return;
            case 5:
                unsignedInt5 = 0;
                unsignedInt4 = unsignedInt5 ^ (((long) Byte.toUnsignedInt(byteBuffer.get(4))) << 32);
                unsignedInt3 = unsignedInt4 ^ (((long) Byte.toUnsignedInt(byteBuffer.get(3))) << 24);
                unsignedInt2 = unsignedInt3 ^ (((long) Byte.toUnsignedInt(byteBuffer.get(2))) << 16);
                unsignedInt = unsignedInt2 ^ (((long) Byte.toUnsignedInt(byteBuffer.get(1))) << 8);
                unsignedInt7 = unsignedInt ^ ((long) Byte.toUnsignedInt(byteBuffer.get(0)));
                this.zza = (Long.rotateLeft(unsignedInt7 * (-8663945395140668459L), 31) * 5545529020109919103L) ^ this.zza;
                this.zzb ^= Long.rotateLeft(unsignedInt8 * 5545529020109919103L, 33) * (-8663945395140668459L);
                return;
            case 6:
                unsignedInt6 = 0;
                unsignedInt5 = (((long) Byte.toUnsignedInt(byteBuffer.get(5))) << 40) ^ unsignedInt6;
                unsignedInt4 = unsignedInt5 ^ (((long) Byte.toUnsignedInt(byteBuffer.get(4))) << 32);
                unsignedInt3 = unsignedInt4 ^ (((long) Byte.toUnsignedInt(byteBuffer.get(3))) << 24);
                unsignedInt2 = unsignedInt3 ^ (((long) Byte.toUnsignedInt(byteBuffer.get(2))) << 16);
                unsignedInt = unsignedInt2 ^ (((long) Byte.toUnsignedInt(byteBuffer.get(1))) << 8);
                unsignedInt7 = unsignedInt ^ ((long) Byte.toUnsignedInt(byteBuffer.get(0)));
                this.zza = (Long.rotateLeft(unsignedInt7 * (-8663945395140668459L), 31) * 5545529020109919103L) ^ this.zza;
                this.zzb ^= Long.rotateLeft(unsignedInt8 * 5545529020109919103L, 33) * (-8663945395140668459L);
                return;
            case 7:
                unsignedInt6 = ((long) Byte.toUnsignedInt(byteBuffer.get(6))) << 48;
                unsignedInt5 = (((long) Byte.toUnsignedInt(byteBuffer.get(5))) << 40) ^ unsignedInt6;
                unsignedInt4 = unsignedInt5 ^ (((long) Byte.toUnsignedInt(byteBuffer.get(4))) << 32);
                unsignedInt3 = unsignedInt4 ^ (((long) Byte.toUnsignedInt(byteBuffer.get(3))) << 24);
                unsignedInt2 = unsignedInt3 ^ (((long) Byte.toUnsignedInt(byteBuffer.get(2))) << 16);
                unsignedInt = unsignedInt2 ^ (((long) Byte.toUnsignedInt(byteBuffer.get(1))) << 8);
                unsignedInt7 = unsignedInt ^ ((long) Byte.toUnsignedInt(byteBuffer.get(0)));
                this.zza = (Long.rotateLeft(unsignedInt7 * (-8663945395140668459L), 31) * 5545529020109919103L) ^ this.zza;
                this.zzb ^= Long.rotateLeft(unsignedInt8 * 5545529020109919103L, 33) * (-8663945395140668459L);
                return;
            case 8:
                unsignedInt7 = byteBuffer.getLong();
                this.zza = (Long.rotateLeft(unsignedInt7 * (-8663945395140668459L), 31) * 5545529020109919103L) ^ this.zza;
                this.zzb ^= Long.rotateLeft(unsignedInt8 * 5545529020109919103L, 33) * (-8663945395140668459L);
                return;
            case 9:
                unsignedInt8 ^= (long) Byte.toUnsignedInt(byteBuffer.get(8));
                unsignedInt7 = byteBuffer.getLong();
                this.zza = (Long.rotateLeft(unsignedInt7 * (-8663945395140668459L), 31) * 5545529020109919103L) ^ this.zza;
                this.zzb ^= Long.rotateLeft(unsignedInt8 * 5545529020109919103L, 33) * (-8663945395140668459L);
                return;
            case 10:
                unsignedInt8 ^= ((long) Byte.toUnsignedInt(byteBuffer.get(9))) << 8;
                unsignedInt8 ^= (long) Byte.toUnsignedInt(byteBuffer.get(8));
                unsignedInt7 = byteBuffer.getLong();
                this.zza = (Long.rotateLeft(unsignedInt7 * (-8663945395140668459L), 31) * 5545529020109919103L) ^ this.zza;
                this.zzb ^= Long.rotateLeft(unsignedInt8 * 5545529020109919103L, 33) * (-8663945395140668459L);
                return;
            case 11:
                unsignedInt8 ^= ((long) Byte.toUnsignedInt(byteBuffer.get(10))) << 16;
                unsignedInt8 ^= ((long) Byte.toUnsignedInt(byteBuffer.get(9))) << 8;
                unsignedInt8 ^= (long) Byte.toUnsignedInt(byteBuffer.get(8));
                unsignedInt7 = byteBuffer.getLong();
                this.zza = (Long.rotateLeft(unsignedInt7 * (-8663945395140668459L), 31) * 5545529020109919103L) ^ this.zza;
                this.zzb ^= Long.rotateLeft(unsignedInt8 * 5545529020109919103L, 33) * (-8663945395140668459L);
                return;
            case 12:
                unsignedInt8 ^= ((long) Byte.toUnsignedInt(byteBuffer.get(11))) << 24;
                unsignedInt8 ^= ((long) Byte.toUnsignedInt(byteBuffer.get(10))) << 16;
                unsignedInt8 ^= ((long) Byte.toUnsignedInt(byteBuffer.get(9))) << 8;
                unsignedInt8 ^= (long) Byte.toUnsignedInt(byteBuffer.get(8));
                unsignedInt7 = byteBuffer.getLong();
                this.zza = (Long.rotateLeft(unsignedInt7 * (-8663945395140668459L), 31) * 5545529020109919103L) ^ this.zza;
                this.zzb ^= Long.rotateLeft(unsignedInt8 * 5545529020109919103L, 33) * (-8663945395140668459L);
                return;
            case 13:
                unsignedInt8 ^= ((long) Byte.toUnsignedInt(byteBuffer.get(12))) << 32;
                unsignedInt8 ^= ((long) Byte.toUnsignedInt(byteBuffer.get(11))) << 24;
                unsignedInt8 ^= ((long) Byte.toUnsignedInt(byteBuffer.get(10))) << 16;
                unsignedInt8 ^= ((long) Byte.toUnsignedInt(byteBuffer.get(9))) << 8;
                unsignedInt8 ^= (long) Byte.toUnsignedInt(byteBuffer.get(8));
                unsignedInt7 = byteBuffer.getLong();
                this.zza = (Long.rotateLeft(unsignedInt7 * (-8663945395140668459L), 31) * 5545529020109919103L) ^ this.zza;
                this.zzb ^= Long.rotateLeft(unsignedInt8 * 5545529020109919103L, 33) * (-8663945395140668459L);
                return;
            case 14:
                unsignedInt8 ^= ((long) Byte.toUnsignedInt(byteBuffer.get(13))) << 40;
                unsignedInt8 ^= ((long) Byte.toUnsignedInt(byteBuffer.get(12))) << 32;
                unsignedInt8 ^= ((long) Byte.toUnsignedInt(byteBuffer.get(11))) << 24;
                unsignedInt8 ^= ((long) Byte.toUnsignedInt(byteBuffer.get(10))) << 16;
                unsignedInt8 ^= ((long) Byte.toUnsignedInt(byteBuffer.get(9))) << 8;
                unsignedInt8 ^= (long) Byte.toUnsignedInt(byteBuffer.get(8));
                unsignedInt7 = byteBuffer.getLong();
                this.zza = (Long.rotateLeft(unsignedInt7 * (-8663945395140668459L), 31) * 5545529020109919103L) ^ this.zza;
                this.zzb ^= Long.rotateLeft(unsignedInt8 * 5545529020109919103L, 33) * (-8663945395140668459L);
                return;
            case 15:
                unsignedInt8 = ((long) Byte.toUnsignedInt(byteBuffer.get(14))) << 48;
                unsignedInt8 ^= ((long) Byte.toUnsignedInt(byteBuffer.get(13))) << 40;
                unsignedInt8 ^= ((long) Byte.toUnsignedInt(byteBuffer.get(12))) << 32;
                unsignedInt8 ^= ((long) Byte.toUnsignedInt(byteBuffer.get(11))) << 24;
                unsignedInt8 ^= ((long) Byte.toUnsignedInt(byteBuffer.get(10))) << 16;
                unsignedInt8 ^= ((long) Byte.toUnsignedInt(byteBuffer.get(9))) << 8;
                unsignedInt8 ^= (long) Byte.toUnsignedInt(byteBuffer.get(8));
                unsignedInt7 = byteBuffer.getLong();
                this.zza = (Long.rotateLeft(unsignedInt7 * (-8663945395140668459L), 31) * 5545529020109919103L) ^ this.zza;
                this.zzb ^= Long.rotateLeft(unsignedInt8 * 5545529020109919103L, 33) * (-8663945395140668459L);
                return;
            default:
                throw new AssertionError("Should never get here.");
        }
    }

    @Override // com.google.android.gms.internal.nearby.zzaee
    protected final zzaeg zzg() {
        long j = this.zza;
        long j2 = this.zzc;
        long j3 = j ^ j2;
        long j4 = j2 ^ this.zzb;
        long j5 = j3 + j4;
        long j6 = j4 + j5;
        long j7 = (j5 ^ (j5 >>> 33)) * (-49064778989728563L);
        long j8 = (j6 ^ (j6 >>> 33)) * (-49064778989728563L);
        long j9 = (j7 ^ (j7 >>> 33)) * (-4265267296055464877L);
        long j10 = (j8 ^ (j8 >>> 33)) * (-4265267296055464877L);
        long j11 = j10 ^ (j10 >>> 33);
        long j12 = (j9 ^ (j9 >>> 33)) + j11;
        this.zza = j12;
        this.zzb = j11 + j12;
        byte[] bArrArray = ByteBuffer.wrap(new byte[16]).order(ByteOrder.LITTLE_ENDIAN).putLong(this.zza).putLong(this.zzb).array();
        int i = zzaeg.zzb;
        return new zzaef(bArrArray);
    }
}
