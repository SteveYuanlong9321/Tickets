package com.google.android.gms.internal.nearby;

import android.net.Uri;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzqm {
    private final zzro zza;
    private final List zzb;
    private final List zzc;
    private final Uri zzd;
    private final Uri zze;

    zzqm(zzql zzqlVar) {
        this.zza = zzqlVar.zzf();
        this.zzb = zzqlVar.zzg();
        this.zzc = zzqlVar.zzh();
        this.zzd = zzqlVar.zzi();
        this.zze = zzqlVar.zzj();
    }

    public final zzro zza() {
        return this.zza;
    }

    public final Uri zzb() {
        return this.zze;
    }

    public final List zzc(InputStream inputStream) throws IOException {
        zzqj zzqjVarZza;
        ArrayList arrayList = new ArrayList();
        arrayList.add(inputStream);
        List list = this.zzc;
        if (!list.isEmpty() && (zzqjVarZza = zzqj.zza(list, this.zzd, inputStream)) != null) {
            arrayList.add(zzqjVarZza);
        }
        Iterator it = this.zzb.iterator();
        while (it.hasNext()) {
            arrayList.add(((zzrt) it.next()).zzb(this.zzd, (InputStream) zzyo.zzb(arrayList)));
        }
        Collections.reverse(arrayList);
        return arrayList;
    }

    public final List zzd(OutputStream outputStream) throws IOException {
        zzqk zzqkVarZza;
        ArrayList arrayList = new ArrayList();
        arrayList.add(outputStream);
        List list = this.zzc;
        if (!list.isEmpty() && (zzqkVarZza = zzqk.zza(list, this.zzd, outputStream)) != null) {
            arrayList.add(zzqkVarZza);
        }
        Iterator it = this.zzb.iterator();
        while (it.hasNext()) {
            arrayList.add(((zzrt) it.next()).zzc(this.zzd, (OutputStream) zzyo.zzb(arrayList)));
        }
        Collections.reverse(arrayList);
        return arrayList;
    }

    public final boolean zze() {
        return !this.zzb.isEmpty();
    }
}
