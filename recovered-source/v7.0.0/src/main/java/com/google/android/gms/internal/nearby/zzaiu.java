package com.google.android.gms.internal.nearby;

import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class zzaiu extends zzaic {
    Object zza;

    private zzaiu() {
        throw null;
    }

    /* synthetic */ zzaiu(byte[] bArr) {
    }

    public static int zzE(zzaks zzaksVar) {
        int iZzJ = zzaksVar.zzJ();
        return ((352 - (Integer.numberOfLeadingZeros(iZzJ) * 9)) >>> 6) + iZzJ;
    }

    public final void zzF() {
        if (zzy() > 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
        if (zzy() < 0) {
            throw new IllegalStateException("Wrote more data than expected.");
        }
    }

    public abstract void zzb(int i, int i2) throws IOException;

    public abstract void zzc(int i, int i2) throws IOException;

    public abstract void zzd(int i, int i2) throws IOException;

    public abstract void zze(int i, int i2) throws IOException;

    public abstract void zzf(int i, long j) throws IOException;

    public abstract void zzg(int i, long j) throws IOException;

    public abstract void zzh(int i, boolean z) throws IOException;

    public abstract void zzi(int i, String str) throws IOException;

    public abstract void zzj(int i, zzaik zzaikVar) throws IOException;

    public abstract void zzk(zzaik zzaikVar) throws IOException;

    abstract void zzl(byte[] bArr, int i, int i2) throws IOException;

    public abstract void zzm(int i, zzaks zzaksVar) throws IOException;

    public abstract void zzn(int i, zzaik zzaikVar) throws IOException;

    public abstract void zzo(zzaks zzaksVar) throws IOException;

    public abstract void zzp(byte b) throws IOException;

    public abstract void zzq(int i) throws IOException;

    public abstract void zzr(int i) throws IOException;

    public abstract void zzs(int i) throws IOException;

    public abstract void zzt(long j) throws IOException;

    public abstract void zzu(long j) throws IOException;

    public abstract void zzw(String str) throws IOException;

    public abstract void zzx() throws IOException;

    public abstract int zzy();
}
