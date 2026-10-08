package com.google.android.gms.internal.nearby;

import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Level;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzkp {
    public static final /* synthetic */ int zza = 0;
    private static final Object zzb = new Object();
    private static final AtomicReference zzc = new AtomicReference();
    private static volatile zzkp zzd = null;
    private static volatile zzkp zze = null;
    private static final zzxn zzf = zzxr.zza(zzku.zza);
    private final zzmz zzg = new zznd();
    private final Context zzh;
    private final zzxn zzi;
    private final zzxn zzj;
    private final zzxn zzk;
    private final zzxn zzl;
    private final zzpz zzm;
    private final zzxn zzn;
    private final zzow zzo;

    /* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
    public interface zza {
        zzxb zza();
    }

    /* synthetic */ zzkp(Context context, zzxn zzxnVar, zzxn zzxnVar2, final zzxn zzxnVar3, zzxn zzxnVar4, zzxn zzxnVar5, byte[] bArr) {
        Context applicationContext = context.getApplicationContext();
        applicationContext.getClass();
        zzxnVar.getClass();
        zzxnVar2.getClass();
        zzxnVar3.getClass();
        zzxnVar4.getClass();
        zzxnVar5.getClass();
        zzxn zzxnVarZza = zzxr.zza(zzxnVar);
        zzxn zzxnVarZza2 = zzxr.zza(zzxnVar2);
        zzxn zzxnVarZza3 = zzxr.zza(new zzxn() { // from class: com.google.android.gms.internal.nearby.zzkv
            @Override // com.google.android.gms.internal.nearby.zzxn
            public final /* synthetic */ Object zzbh() {
                int i = zzkp.zza;
                return (zzpe) ((zzxb) zzxnVar3.zzbh()).zzd();
            }
        });
        zzxn zzxnVarZza4 = zzxr.zza(zzxnVar4);
        zzxn zzxnVarZza5 = zzxr.zza(zzxnVar5);
        this.zzh = applicationContext;
        this.zzi = zzxnVarZza;
        this.zzj = zzxnVarZza2;
        this.zzk = zzxnVarZza3;
        this.zzl = zzxnVarZza4;
        this.zzm = new zzpz(applicationContext, zzxnVarZza, zzxnVarZza2);
        this.zzn = zzxnVarZza5;
        this.zzo = new zzow(applicationContext, zzxnVarZza, zzxnVarZza3, zzxnVarZza2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static zzkp zza() {
        boolean z;
        zzkp zzkpVar;
        Application application;
        zzkx.zza();
        zzkx.zzc();
        Context context = (Context) zzc.get();
        if (context == null) {
            zzkx.zzb();
            throw new IllegalStateException("Must call PhenotypeContext.setContext() first");
        }
        zzkp zzkpVar2 = zzd;
        if (zzkpVar2 != null) {
            return zzkpVar2;
        }
        final Context context2 = context.getApplicationContext();
        try {
            Intrinsics.checkNotNullParameter(context2, "context");
            Intrinsics.checkNotNullParameter(zza.class, "singletonEntryPoint");
            Context applicationContext = context2.getApplicationContext();
            if (applicationContext instanceof Application) {
                application = (Application) applicationContext;
            } else {
                Context baseContext = applicationContext;
                do {
                    if (!(baseContext instanceof ContextWrapper)) {
                        String strValueOf = String.valueOf(applicationContext);
                        String.valueOf(strValueOf);
                        throw new IllegalStateException("Could not find an Application in the given context: ".concat(String.valueOf(strValueOf)));
                    }
                    baseContext = ((ContextWrapper) baseContext).getBaseContext();
                } while (!(baseContext instanceof Application));
                application = (Application) baseContext;
            }
            Intrinsics.checkNotNullExpressionValue(application, "getApplication(...)");
            Application application2 = application;
            if (!(application2 instanceof zzamb)) {
                Class<?> cls = application2.getClass();
                new StringBuilder(String.valueOf(cls).length() + 72);
                Objects.toString(cls);
                throw new IllegalStateException("Given application context does not implement GeneratedComponentManager: ".concat(String.valueOf(cls)));
            }
            try {
                Object objCast = zza.class.cast(((zzamb) application2).zza());
                Intrinsics.checkNotNull(objCast);
                zzxb zzxbVarZza = ((zza) objCast).zza();
                z = true;
                try {
                    if (zzxbVarZza.zza()) {
                        return (zzkp) zzxbVarZza.zzb();
                    }
                } catch (IllegalStateException unused) {
                }
            } catch (ClassCastException e) {
                throw new IllegalStateException("Failed to get an entry point. Did you mark your interface with @SingletonEntryPoint?", e);
            }
        } catch (IllegalStateException unused2) {
            z = false;
        }
        synchronized (zzb) {
            if (zzd != null) {
                zzkpVar = zzd;
            } else {
                zzxb zzxbVarZze = zzxb.zze();
                boolean z2 = context2 instanceof zza;
                if (z2) {
                    zzxbVarZze = ((zza) context2).zza();
                }
                zzkpVar = (zzkp) zzxbVarZze.zzc(new zzxn() { // from class: com.google.android.gms.internal.nearby.zzkq
                    @Override // com.google.android.gms.internal.nearby.zzxn
                    public final /* synthetic */ Object zzbh() {
                        int i = zzkp.zza;
                        zzko zzkoVar = new zzko(null);
                        zzkoVar.zza(context2);
                        return zzkoVar.zzb();
                    }
                });
                zzd = zzkpVar;
                if (!z && !z2) {
                    zzla.zza(Level.CONFIG, zzkpVar.zzf(), "Application doesn't implement PhenotypeApplication interface, falling back to globally set context. See go/phenotype-flag#process-stable-init for more info.", new Object[0]);
                }
            }
        }
        return zzkpVar;
    }

    public static boolean zzk() {
        zzkx.zzb();
        if (zzc.get() == null) {
            zzkx.zzd();
        }
        return false;
    }

    public final Context zzb() {
        return this.zzh;
    }

    public final zzpz zzc() {
        return this.zzm;
    }

    public final zzxb zzd() {
        return (zzxb) this.zzn.zzbh();
    }

    public final zzow zze() {
        return this.zzo;
    }

    public final zzaha zzf() {
        return (zzaha) this.zzi.zzbh();
    }

    public final zzlj zzg() {
        return (zzlj) this.zzj.zzbh();
    }

    public final zzqo zzh() {
        return (zzqo) this.zzl.zzbh();
    }

    public final zzpe zzi() {
        return (zzpe) this.zzk.zzbh();
    }

    public final zzmz zzj() {
        return this.zzg;
    }
}
