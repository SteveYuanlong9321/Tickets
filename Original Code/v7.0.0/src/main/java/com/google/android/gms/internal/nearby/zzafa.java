package com.google.android.gms.internal.nearby;

import java.util.concurrent.ExecutionException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
abstract class zzafa extends zzage implements Runnable {
    public static final /* synthetic */ int zzd = 0;
    zzagx zza;
    Class zzb;
    Object zzc;

    zzafa(zzagx zzagxVar, Class cls, Object obj) {
        this.zza = zzagxVar;
        this.zzb = cls;
        this.zzc = obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.lang.Runnable
    public final void run() {
        Object objZzn;
        zzagx zzagxVar = this.zza;
        Class cls = this.zzb;
        Object obj = this.zzc;
        if (((obj == null) || ((zzagxVar == 0) | (cls == null))) || isCancelled()) {
            return;
        }
        this.zza = null;
        try {
            th = zzagxVar instanceof zzahq ? ((zzahq) zzagxVar).zzm() : null;
            objZzn = th == null ? zzagn.zzn(zzagxVar) : null;
        } catch (ExecutionException e) {
            Throwable cause = e.getCause();
            if (cause == null) {
                String strValueOf = String.valueOf(zzagxVar.getClass());
                String strValueOf2 = String.valueOf(e.getClass());
                StringBuilder sb = new StringBuilder(String.valueOf(strValueOf).length() + 19 + String.valueOf(strValueOf2).length() + 16);
                sb.append("Future type ");
                sb.append(strValueOf);
                sb.append(" threw ");
                sb.append(strValueOf2);
                sb.append(" without a cause");
                cause = new NullPointerException(sb.toString());
            }
            th = cause;
        } catch (Throwable th) {
            th = th;
        }
        if (th == null) {
            zza(objZzn);
            return;
        }
        if (!cls.isInstance(th)) {
            zze(zzagxVar);
            return;
        }
        try {
            Object objZzg = zzg(obj, th);
            this.zzb = null;
            this.zzc = null;
            zzf(objZzg);
        } catch (Throwable th2) {
            try {
                zzahh.zza(th2);
                zzb(th2);
            } finally {
                this.zzb = null;
                this.zzc = null;
            }
        }
    }

    @Override // com.google.android.gms.internal.nearby.zzafb
    protected final void zzc() {
        zzn(this.zza);
        this.zza = null;
        this.zzb = null;
        this.zzc = null;
    }

    @Override // com.google.android.gms.internal.nearby.zzafb
    protected final String zzd() {
        String string;
        zzagx zzagxVar = this.zza;
        Class cls = this.zzb;
        Object obj = this.zzc;
        String strZzd = super.zzd();
        if (zzagxVar != null) {
            String string2 = zzagxVar.toString();
            StringBuilder sb = new StringBuilder(string2.length() + 16);
            sb.append("inputFuture=[");
            sb.append(string2);
            sb.append("], ");
            string = sb.toString();
        } else {
            string = "";
        }
        if (cls == null || obj == null) {
            if (strZzd != null) {
                return string.concat(strZzd);
            }
            return null;
        }
        int length = string.length();
        String string3 = cls.toString();
        int length2 = string3.length();
        String string4 = obj.toString();
        StringBuilder sb2 = new StringBuilder(length + 15 + length2 + 13 + string4.length() + 1);
        sb2.append(string);
        sb2.append("exceptionType=[");
        sb2.append(string3);
        sb2.append("], fallback=[");
        sb2.append(string4);
        sb2.append("]");
        return sb2.toString();
    }

    abstract void zzf(Object obj);

    abstract Object zzg(Object obj, Throwable th) throws Exception;
}
