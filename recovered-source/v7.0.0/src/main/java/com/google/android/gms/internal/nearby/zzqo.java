package com.google.android.gms.internal.nearby;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzqo {
    private final Map zza;
    private final Map zzb;
    private final List zzc;

    public zzqo(List list) {
        List<zzrt> list2 = Collections.EMPTY_LIST;
        List list3 = Collections.EMPTY_LIST;
        this.zza = new HashMap();
        this.zzb = new HashMap();
        this.zzc = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            zzro zzroVar = (zzro) it.next();
            if (TextUtils.isEmpty(zzroVar.zzc())) {
                Log.w("MobStore.FileStorage", "Cannot register backend, name empty");
            } else {
                zzro zzroVar2 = (zzro) this.zza.put(zzroVar.zzc(), zzroVar);
                if (zzroVar2 != null) {
                    String canonicalName = zzroVar2.getClass().getCanonicalName();
                    String canonicalName2 = zzroVar.getClass().getCanonicalName();
                    StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 30 + String.valueOf(canonicalName2).length());
                    sb.append("Cannot override Backend ");
                    sb.append(canonicalName);
                    sb.append(" with ");
                    sb.append(canonicalName2);
                    throw new IllegalArgumentException(sb.toString());
                }
            }
        }
        for (zzrt zzrtVar : list2) {
            if (TextUtils.isEmpty(zzrtVar.zza())) {
                Log.w("MobStore.FileStorage", "Cannot register transform, name empty");
            } else {
                zzrt zzrtVar2 = (zzrt) this.zzb.put(zzrtVar.zza(), zzrtVar);
                if (zzrtVar2 != null) {
                    String canonicalName3 = zzrtVar2.getClass().getCanonicalName();
                    String canonicalName4 = zzrtVar.getClass().getCanonicalName();
                    StringBuilder sb2 = new StringBuilder(String.valueOf(canonicalName3).length() + 35 + String.valueOf(canonicalName4).length());
                    sb2.append("Cannot to override Transform ");
                    sb2.append(canonicalName3);
                    sb2.append(" with ");
                    sb2.append(canonicalName4);
                    throw new IllegalArgumentException(sb2.toString());
                }
            }
        }
        this.zzc.addAll(list3);
    }

    private final zzqm zze(Uri uri) throws IOException {
        int i = zzyg.zzd;
        zzyc zzycVar = new zzyc();
        zzyc zzycVar2 = new zzyc();
        String encodedFragment = uri.getEncodedFragment();
        zzyg zzygVarZzj = (TextUtils.isEmpty(encodedFragment) || !encodedFragment.startsWith("transform=")) ? zzyg.zzj() : zzyg.zzr(zzxj.zza("+").zzb().zzc(encodedFragment.substring(10)));
        int size = zzygVarZzj.size();
        for (int i2 = 0; i2 < size; i2++) {
            zzycVar2.zzc(zzrj.zza((String) zzygVarZzj.get(i2)));
        }
        zzyg zzygVarZze = zzycVar2.zze();
        int size2 = zzygVarZze.size();
        for (int i3 = 0; i3 < size2; i3++) {
            String str = (String) zzygVarZze.get(i3);
            zzrt zzrtVar = (zzrt) this.zzb.get(str);
            if (zzrtVar == null) {
                String strValueOf = String.valueOf(uri);
                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 40 + String.valueOf(strValueOf).length());
                sb.append("Requested transform isn't registered: ");
                sb.append(str);
                sb.append(": ");
                sb.append(strValueOf);
                throw new zzre(sb.toString());
            }
            zzycVar.zzc(zzrtVar);
        }
        zzyg zzygVarZzh = zzycVar.zze().zzh();
        zzql zzqlVar = new zzql(null);
        String scheme = uri.getScheme();
        zzro zzroVar = (zzro) this.zza.get(scheme);
        if (zzroVar == null) {
            throw new zzre(String.format("Requested backend isn't registered: %s", scheme));
        }
        zzqlVar.zza(zzroVar);
        zzqlVar.zzc(this.zzc);
        zzqlVar.zzb(zzygVarZzh);
        zzqlVar.zze(uri);
        if (!zzygVarZzh.isEmpty()) {
            ArrayList arrayList = new ArrayList(uri.getPathSegments());
            if (!arrayList.isEmpty() && !uri.getPath().endsWith("/")) {
                String str2 = (String) arrayList.get(arrayList.size() - 1);
                ListIterator listIterator = zzygVarZzh.listIterator(zzygVarZzh.size());
                while (listIterator.hasPrevious()) {
                }
                arrayList.set(arrayList.size() - 1, str2);
                uri = uri.buildUpon().path(TextUtils.join("/", arrayList)).encodedFragment(null).build();
            }
        }
        zzqlVar.zzd(uri);
        return new zzqm(zzqlVar);
    }

    public final Object zza(Uri uri, zzqn zzqnVar) throws IOException {
        return zzqnVar.zza(zze(uri));
    }

    public final void zzb(Uri uri) throws IOException {
        zzqm zzqmVarZze = zze(uri);
        zzqmVarZze.zza().zzk(zzqmVarZze.zzb());
    }

    public final boolean zzc(Uri uri) throws IOException {
        zzqm zzqmVarZze = zze(uri);
        return zzqmVarZze.zza().zze(zzqmVarZze.zzb());
    }

    public final void zzd(Uri uri, Uri uri2) throws IOException {
        zzqm zzqmVarZze = zze(uri);
        zzqm zzqmVarZze2 = zze(uri2);
        if (zzqmVarZze.zza() != zzqmVarZze2.zza()) {
            throw new zzre("Cannot rename file across backends");
        }
        zzqmVarZze.zza().zzl(zzqmVarZze.zzb(), zzqmVarZze2.zzb());
    }
}
