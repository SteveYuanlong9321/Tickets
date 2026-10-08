package com.google.android.gms.internal.nearby;

import androidx.camera.view.PreviewView$1$$ExternalSyntheticBackportWithForwarding0;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.BiFunction;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zznd implements zzmz {
    private final AtomicBoolean zza = new AtomicBoolean(false);
    private final ConcurrentMap zzb;
    private final ConcurrentMap zzc;

    public zznd() {
        new ConcurrentHashMap();
        this.zzb = new ConcurrentHashMap();
        new ConcurrentHashMap();
        this.zzc = new ConcurrentHashMap();
    }

    @Override // com.google.android.gms.internal.nearby.zzmz
    public final void zza(zzaik zzaikVar, Set set, String str) {
        Object obj;
        zznc[] zzncVarArr;
        if (!set.isEmpty() && !this.zza.getAndSet(true)) {
            zzg.zza().zzb(new zznb(this, null));
        }
        final byte[] bArrZzm = zzaikVar.zzm();
        this.zzb.compute(str, new BiFunction() { // from class: com.google.android.gms.internal.nearby.zzna
            @Override // java.util.function.BiFunction
            public final /* synthetic */ Object apply(Object obj2, Object obj3) {
                byte[] bArr = (byte[]) obj3;
                byte[] bArr2 = bArrZzm;
                return Arrays.equals(bArr, bArr2) ? bArr : bArr2;
            }
        });
        Iterator it = set.iterator();
        while (it.hasNext()) {
            AtomicReference atomicReference = (AtomicReference) this.zzc.putIfAbsent((String) it.next(), new AtomicReference(new zznc(str, bArrZzm, null)));
            if (atomicReference != null) {
                do {
                    obj = atomicReference.get();
                    if (obj instanceof zznc) {
                        zznc zzncVar = (zznc) obj;
                        if (str.equals(zzncVar.zza())) {
                            zzncVar.zzb(bArrZzm, false);
                            break;
                        } else {
                            zznc zzncVar2 = new zznc(str, bArrZzm, null);
                            zzncVarArr = str.compareTo(zzncVar.zza()) < 0 ? new zznc[]{zzncVar2, zzncVar} : new zznc[]{zzncVar, zzncVar2};
                        }
                    } else {
                        zznc[] zzncVarArr2 = (zznc[]) obj;
                        int iBinarySearch = Arrays.binarySearch(zzncVarArr2, str);
                        if (iBinarySearch >= 0) {
                            zzncVarArr2[iBinarySearch].zzb(bArrZzm, false);
                            break;
                        }
                        int i = ~iBinarySearch;
                        int length = zzncVarArr2.length;
                        int i2 = length + 1;
                        int i3 = length - i;
                        if (i3 == 0) {
                            zzncVarArr = (zznc[]) Arrays.copyOf(zzncVarArr2, i2);
                        } else {
                            zznc[] zzncVarArr3 = new zznc[i2];
                            System.arraycopy(zzncVarArr2, 0, zzncVarArr3, 0, i);
                            System.arraycopy(zzncVarArr2, i, zzncVarArr3, i + 1, i3);
                            zzncVarArr = zzncVarArr3;
                        }
                        zzncVarArr[i] = new zznc(str, bArrZzm, null);
                    }
                } while (!PreviewView$1$$ExternalSyntheticBackportWithForwarding0.m(atomicReference, obj, zzncVarArr));
            }
        }
    }
}
