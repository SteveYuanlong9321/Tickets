package com.google.android.gms.nearby.internal.connection;

import android.util.Log;
import androidx.collection.SimpleArrayMap;
import com.google.android.gms.common.util.IOUtils;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzgc {
    private final ExecutorService zza = com.google.android.gms.internal.nearby.zzv.zza().zza(6, 2);
    private final SimpleArrayMap zzb = new SimpleArrayMap();
    private volatile boolean zzc = false;
    private final SimpleArrayMap zzd = new SimpleArrayMap();
    private final SimpleArrayMap zze = new SimpleArrayMap();

    static final /* synthetic */ void zze(OutputStream outputStream, boolean z, long j) {
        try {
            try {
                outputStream.write(z ? 1 : 0);
            } catch (IOException e) {
                Log.w("NearbyConnections", String.format("Unable to deliver status for Payload %d", Long.valueOf(j)), e);
            }
        } finally {
            IOUtils.closeQuietly(outputStream);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [java.io.InputStream, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v2 */
    final synchronized void zza(InputStream inputStream, OutputStream outputStream, OutputStream outputStream2, zzgq zzgqVar, long j) throws Throwable {
        try {
            try {
                SimpleArrayMap simpleArrayMap = this.zzb;
                Long lValueOf = Long.valueOf(j);
                simpleArrayMap.put(lValueOf, inputStream);
                this.zzd.put(lValueOf, outputStream);
                this.zze.put(lValueOf, zzgqVar);
                this.zza.execute(new zzgb(this, inputStream, outputStream, j, outputStream2));
            } catch (Throwable th) {
                th = th;
                inputStream = this;
                Throwable th2 = th;
                throw th2;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    final synchronized void zzb(long j) {
        SimpleArrayMap simpleArrayMap = this.zzb;
        Long lValueOf = Long.valueOf(j);
        IOUtils.closeQuietly((Closeable) simpleArrayMap.get(lValueOf));
        simpleArrayMap.remove(lValueOf);
        SimpleArrayMap simpleArrayMap2 = this.zzd;
        IOUtils.closeQuietly((Closeable) simpleArrayMap2.get(lValueOf));
        simpleArrayMap2.remove(lValueOf);
        zzgq zzgqVar = (zzgq) this.zze.remove(lValueOf);
        if (zzgqVar != null) {
            IOUtils.closeQuietly(zzgqVar.zzd());
            IOUtils.closeQuietly(zzgqVar.zzg());
        }
    }

    final synchronized void zzc() {
        SimpleArrayMap simpleArrayMap;
        SimpleArrayMap simpleArrayMap2;
        this.zzc = true;
        this.zza.shutdownNow();
        int i = 0;
        int i2 = 0;
        while (true) {
            simpleArrayMap = this.zzb;
            if (i2 >= simpleArrayMap.getSize()) {
                break;
            }
            IOUtils.closeQuietly((Closeable) simpleArrayMap.valueAt(i2));
            i2++;
        }
        simpleArrayMap.clear();
        int i3 = 0;
        while (true) {
            simpleArrayMap2 = this.zzd;
            if (i3 >= simpleArrayMap2.getSize()) {
                break;
            }
            IOUtils.closeQuietly((Closeable) simpleArrayMap2.valueAt(i3));
            i3++;
        }
        simpleArrayMap2.clear();
        while (true) {
            SimpleArrayMap simpleArrayMap3 = this.zze;
            if (i < simpleArrayMap3.getSize()) {
                zzgq zzgqVar = (zzgq) simpleArrayMap3.valueAt(i);
                IOUtils.closeQuietly(zzgqVar.zzd());
                IOUtils.closeQuietly(zzgqVar.zzg());
                i++;
            } else {
                simpleArrayMap3.clear();
            }
        }
    }

    final /* synthetic */ boolean zzd() {
        return this.zzc;
    }
}
