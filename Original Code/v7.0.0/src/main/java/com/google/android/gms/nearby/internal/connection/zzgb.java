package com.google.android.gms.nearby.internal.connection;

import android.util.Log;
import com.google.android.gms.common.util.IOUtils;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzgb implements Runnable {
    final /* synthetic */ InputStream zza;
    final /* synthetic */ OutputStream zzb;
    final /* synthetic */ long zzc;
    final /* synthetic */ OutputStream zzd;
    final /* synthetic */ zzgc zze;

    zzgb(zzgc zzgcVar, InputStream inputStream, OutputStream outputStream, long j, OutputStream outputStream2) {
        this.zza = inputStream;
        this.zzb = outputStream;
        this.zzc = j;
        this.zzd = outputStream2;
        Objects.requireNonNull(zzgcVar);
        this.zze = zzgcVar;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        boolean z = false;
        try {
            IOUtils.copyStream(this.zza, this.zzb, false, 65536);
            IOUtils.closeQuietly(this.zza);
            zzgc.zze(this.zzd, false, this.zzc);
        } catch (IOException e) {
            try {
                if (this.zze.zzd()) {
                    Log.d("NearbyConnections", String.format("Terminating copying stream for Payload %d due to shutdown of OutgoingPayloadStreamer.", Long.valueOf(this.zzc)));
                } else {
                    Log.w("NearbyConnections", String.format("Exception copying stream for Payload %d", Long.valueOf(this.zzc)), e);
                }
                IOUtils.closeQuietly(this.zza);
                zzgc.zze(this.zzd, true, this.zzc);
            } catch (Throwable th) {
                th = th;
                z = true;
                IOUtils.closeQuietly(this.zza);
                zzgc.zze(this.zzd, z, this.zzc);
                IOUtils.closeQuietly(this.zzb);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            IOUtils.closeQuietly(this.zza);
            zzgc.zze(this.zzd, z, this.zzc);
            IOUtils.closeQuietly(this.zzb);
            throw th;
        }
        IOUtils.closeQuietly(this.zzb);
    }
}
