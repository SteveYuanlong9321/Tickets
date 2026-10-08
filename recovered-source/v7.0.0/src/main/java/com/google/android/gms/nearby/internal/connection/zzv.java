package com.google.android.gms.nearby.internal.connection;

import androidx.collection.ArraySet;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzv extends zzdu implements zzaj {
    private final ListenerHolder zza;
    private final Set zzb = new ArraySet();
    private final Set zzc = new ArraySet();

    zzv(ListenerHolder listenerHolder) {
        this.zza = (ListenerHolder) Preconditions.checkNotNull(listenerHolder);
    }

    @Override // com.google.android.gms.nearby.internal.connection.zzdv
    public final synchronized void zzb(zzet zzetVar) {
        this.zzb.add(zzetVar.zza());
        this.zza.notifyListener(new zzo(this, zzetVar));
    }

    @Override // com.google.android.gms.nearby.internal.connection.zzdv
    public final synchronized void zzc(zzez zzezVar) {
        this.zzb.remove(zzezVar.zza());
        Status statusZzK = zzaw.zzK(zzezVar.zzb());
        if (statusZzK.isSuccess()) {
            this.zzc.add(zzezVar.zza());
        }
        this.zza.notifyListener(new zzp(this, zzezVar, statusZzK));
    }

    @Override // com.google.android.gms.nearby.internal.connection.zzdv
    public final synchronized void zzd(zzfd zzfdVar) {
        this.zzc.remove(zzfdVar.zza());
        this.zza.notifyListener(new zzq(this, zzfdVar));
    }

    @Override // com.google.android.gms.nearby.internal.connection.zzdv
    public final void zze(zzer zzerVar) {
        this.zza.notifyListener(new zzr(this, zzerVar));
    }

    @Override // com.google.android.gms.nearby.internal.connection.zzdv
    public final void zzf(zzfb zzfbVar) {
        this.zza.notifyListener(new zzs(this, zzfbVar));
    }

    @Override // com.google.android.gms.nearby.internal.connection.zzaj
    public final synchronized void zzg() {
        Set set = this.zzb;
        Iterator it = set.iterator();
        while (it.hasNext()) {
            this.zza.notifyListener(new zzt(this, (String) it.next()));
        }
        set.clear();
        Set set2 = this.zzc;
        Iterator it2 = set2.iterator();
        while (it2.hasNext()) {
            this.zza.notifyListener(new zzu(this, (String) it2.next()));
        }
        set2.clear();
    }
}
