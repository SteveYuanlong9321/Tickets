package com.google.android.gms.nearby.internal.connection;

import androidx.collection.ArraySet;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzaf extends zzeb {
    private final ListenerHolder zza;
    private final Set zzb = new ArraySet();

    zzaf(ListenerHolder listenerHolder) {
        this.zza = (ListenerHolder) Preconditions.checkNotNull(listenerHolder);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean zzg(zzfh zzfhVar) {
        if (zzfhVar.zzd() != null) {
            return zzfhVar.zza() == null || "__UNRECOGNIZED_BLUETOOTH_DEVICE__".equals(zzfhVar.zza());
        }
        return false;
    }

    @Override // com.google.android.gms.nearby.internal.connection.zzec
    public final synchronized void zzb(zzff zzffVar) {
        this.zza.notifyListener(new zzab(this, zzffVar));
    }

    @Override // com.google.android.gms.nearby.internal.connection.zzec
    public final synchronized void zzc(zzfh zzfhVar) {
        if (!zzg(zzfhVar)) {
            this.zzb.add(zzfhVar.zza());
        }
        this.zza.notifyListener(new zzac(this, zzfhVar));
    }

    @Override // com.google.android.gms.nearby.internal.connection.zzec
    public final synchronized void zzd(zzfn zzfnVar) {
        this.zzb.remove(zzfnVar.zza());
        this.zza.notifyListener(new zzad(this, zzfnVar));
    }

    final synchronized void zze() {
        Set set = this.zzb;
        Iterator it = set.iterator();
        while (it.hasNext()) {
            this.zza.notifyListener(new zzae(this, (String) it.next()));
        }
        set.clear();
    }
}
