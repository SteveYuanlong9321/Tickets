package com.google.android.gms.internal.nearby;

import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
abstract class zzafh extends zzage implements Runnable {
    public static final /* synthetic */ int zzc = 0;
    zzagx zza;
    Object zzb;

    @Override // java.lang.Runnable
    public final void run() {
        zzagx zzagxVar = this.zza;
        Object obj = this.zzb;
        if ((isCancelled() | (zzagxVar == null)) || (obj == null)) {
            return;
        }
        this.zza = null;
        if (zzagxVar.isCancelled()) {
            zze(zzagxVar);
            return;
        }
        try {
            try {
                Object objZzg = zzg(obj, zzagn.zzn(zzagxVar));
                this.zzb = null;
                zzf(objZzg);
            } catch (Throwable th) {
                try {
                    zzahh.zza(th);
                    zzb(th);
                } finally {
                    this.zzb = null;
                }
            }
        } catch (Error e) {
            zzb(e);
        } catch (CancellationException unused) {
            cancel(false);
        } catch (ExecutionException e2) {
            zzb(e2.getCause());
        } catch (Exception e3) {
            zzb(e3);
        }
    }

    @Override // com.google.android.gms.internal.nearby.zzafb
    protected final void zzc() {
        zzn(this.zza);
        this.zza = null;
        this.zzb = null;
    }

    @Override // com.google.android.gms.internal.nearby.zzafb
    protected final String zzd() {
        String string;
        zzagx zzagxVar = this.zza;
        Object obj = this.zzb;
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
        if (obj == null) {
            if (strZzd != null) {
                return string.concat(strZzd);
            }
            return null;
        }
        int length = string.length();
        String string3 = obj.toString();
        StringBuilder sb2 = new StringBuilder(length + 10 + string3.length() + 1);
        sb2.append(string);
        sb2.append("function=[");
        sb2.append(string3);
        sb2.append("]");
        return sb2.toString();
    }

    abstract void zzf(Object obj);

    abstract Object zzg(Object obj, Object obj2) throws Exception;

    zzafh(zzagx zzagxVar, Object obj) {
        zzagxVar.getClass();
        this.zza = zzagxVar;
        this.zzb = obj;
    }
}
