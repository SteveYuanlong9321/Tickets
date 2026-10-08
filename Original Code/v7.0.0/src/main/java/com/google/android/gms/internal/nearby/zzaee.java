package com.google.android.gms.internal.nearby;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
abstract class zzaee extends zzaed {
    private final ByteBuffer zza = ByteBuffer.allocate(23).order(ByteOrder.LITTLE_ENDIAN);

    protected zzaee(int i, int i2) {
    }

    private final void zzh() {
        if (this.zza.remaining() < 8) {
            zzi();
        }
    }

    private final void zzi() {
        ByteBuffer byteBuffer = this.zza;
        byteBuffer.flip();
        while (byteBuffer.remaining() >= 16) {
            zzc(byteBuffer);
        }
        byteBuffer.compact();
    }

    @Override // com.google.android.gms.internal.nearby.zzaed
    public final zzaei zzb(byte[] bArr, int i, int i2) {
        ByteBuffer byteBufferOrder = ByteBuffer.wrap(bArr, 0, i2).order(ByteOrder.LITTLE_ENDIAN);
        int iRemaining = byteBufferOrder.remaining();
        ByteBuffer byteBuffer = this.zza;
        if (iRemaining <= byteBuffer.remaining()) {
            byteBuffer.put(byteBufferOrder);
            zzh();
            return this;
        }
        int iPosition = 16 - byteBuffer.position();
        for (int i3 = 0; i3 < iPosition; i3++) {
            byteBuffer.put(byteBufferOrder.get());
        }
        zzi();
        while (byteBufferOrder.remaining() >= 16) {
            zzc(byteBufferOrder);
        }
        byteBuffer.put(byteBufferOrder);
        return this;
    }

    protected abstract void zzc(ByteBuffer byteBuffer);

    protected void zzd(ByteBuffer byteBuffer) {
        throw null;
    }

    @Override // com.google.android.gms.internal.nearby.zzaei
    public final zzaei zze(byte b) {
        this.zza.put((byte) 0);
        zzh();
        return this;
    }

    @Override // com.google.android.gms.internal.nearby.zzaei
    public final zzaeg zzf() {
        zzi();
        ByteBuffer byteBuffer = this.zza;
        byteBuffer.flip();
        if (byteBuffer.remaining() > 0) {
            zzd(byteBuffer);
            byteBuffer.position(byteBuffer.limit());
        }
        return zzg();
    }

    protected abstract zzaeg zzg();
}
