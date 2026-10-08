package com.google.android.gms.internal.nearby;

import android.os.SystemClock;
import androidx.camera.view.PreviewView$1$$ExternalSyntheticBackportWithForwarding0;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzwo {
    public static zzagx zza(Runnable runnable, long j, long j2, TimeUnit timeUnit, zzkb zzkbVar, zzaha zzahaVar) {
        long jElapsedRealtime = SystemClock.elapsedRealtime() + TimeUnit.MILLISECONDS.convert(0L, timeUnit);
        long jConvert = TimeUnit.MILLISECONDS.convert(j2, timeUnit);
        zzahl zzahlVarZzf = zzahl.zzf();
        final AtomicReference atomicReference = new AtomicReference(null);
        PreviewView$1$$ExternalSyntheticBackportWithForwarding0.m(atomicReference, null, zzahaVar.schedule(new zzwm(zzahlVarZzf, runnable, atomicReference, zzahaVar, jElapsedRealtime, jConvert, zzkbVar), 0L, timeUnit));
        zzahlVarZzf.zzl(new Runnable() { // from class: com.google.android.gms.internal.nearby.zzwn
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                ((Future) atomicReference.get()).cancel(false);
            }
        }, zzahg.zza());
        return zzahlVarZzf;
    }
}
