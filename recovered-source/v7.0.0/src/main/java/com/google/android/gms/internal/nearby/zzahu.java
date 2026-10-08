package com.google.android.gms.internal.nearby;

import com.google.android.gms.internal.nearby.zzaht;
import com.google.android.gms.internal.nearby.zzahu;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class zzahu<MessageType extends zzahu<MessageType, BuilderType>, BuilderType extends zzaht<MessageType, BuilderType>> implements zzaks {
    protected transient int zza = 0;

    private final String zzc(String str) {
        String name = getClass().getName();
        StringBuilder sb = new StringBuilder(String.valueOf(name).length() + 72);
        sb.append("Serializing ");
        sb.append(name);
        sb.append(" to a ");
        sb.append(str);
        sb.append(" threw an IOException (should never happen).");
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.nearby.zzaks
    public final zzaik zzu() {
        try {
            int iZzJ = zzJ();
            zzaik zzaikVar = zzaik.zza;
            byte[] bArr = new byte[iZzJ];
            zzaiq zzaiqVar = new zzaiq(bArr, 0, iZzJ, null);
            zzbd(zzaiqVar);
            return zzaih.zza(zzaiqVar, bArr);
        } catch (IOException e) {
            throw new RuntimeException(zzc("ByteString"), e);
        }
    }

    public final byte[] zzv() {
        try {
            int iZzJ = zzJ();
            byte[] bArr = new byte[iZzJ];
            zzaiq zzaiqVar = new zzaiq(bArr, 0, iZzJ, null);
            zzbd(zzaiqVar);
            zzaiqVar.zzF();
            return bArr;
        } catch (IOException e) {
            throw new RuntimeException(zzc("byte array"), e);
        }
    }

    @Override // com.google.android.gms.internal.nearby.zzaks
    public final void zzw(OutputStream outputStream) throws IOException {
        int iZzJ = zzJ();
        if (iZzJ > 4096) {
            iZzJ = 4096;
        }
        zzait zzaitVar = new zzait(outputStream, iZzJ);
        zzbd(zzaitVar);
        zzaitVar.zzx();
    }

    int zzx(zzald zzaldVar) {
        throw null;
    }
}
