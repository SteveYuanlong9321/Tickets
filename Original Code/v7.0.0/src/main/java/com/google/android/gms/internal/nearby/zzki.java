package com.google.android.gms.internal.nearby;

import com.google.android.gms.tasks.CancellationTokenSource;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzki {
    public static zzagx zza(Task task, CancellationTokenSource cancellationTokenSource) {
        final zzkg zzkgVar = new zzkg(task, null);
        task.addOnCompleteListener(zzahg.zza(), new OnCompleteListener() { // from class: com.google.android.gms.internal.nearby.zzkh
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final /* synthetic */ void onComplete(Task task2) {
                zzkg zzkgVar2 = zzkgVar;
                if (task2.isCanceled()) {
                    zzkgVar2.cancel(false);
                    return;
                }
                if (task2.isSuccessful()) {
                    zzkgVar2.zza(task2.getResult());
                    return;
                }
                Exception exception = task2.getException();
                if (exception == null) {
                    throw new IllegalStateException();
                }
                zzkgVar2.zzb(exception);
            }
        });
        return zzkgVar;
    }
}
