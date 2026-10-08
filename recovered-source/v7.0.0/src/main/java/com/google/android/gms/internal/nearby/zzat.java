package com.google.android.gms.internal.nearby;

import androidx.collection.ArrayMap;
import androidx.collection.ArraySet;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.ListenerHolders;
import com.google.android.gms.common.api.internal.RegistrationMethods;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzat {
    private static final Map zza = new ArrayMap();
    private final Map zzb = new ArrayMap();
    private final Set zzc = new ArraySet();
    private final Map zzd = new ArrayMap();

    private zzat() {
    }

    public static synchronized zzat zza(GoogleApi googleApi, Api.ApiOptions apiOptions) {
        zzas zzasVar;
        Map map;
        zzasVar = new zzas(googleApi, null);
        map = zza;
        if (!map.containsKey(zzasVar)) {
            map.put(zzasVar, new zzat());
        }
        return (zzat) map.get(zzasVar);
    }

    private final Object zzi(String str) {
        Map map = this.zzd;
        if (!map.containsKey(str)) {
            map.put(str, new Object());
        }
        return map.get(str);
    }

    public final synchronized ListenerHolder zzb(GoogleApi googleApi, Object obj, String str) {
        ListenerHolder listenerHolderRegisterListener;
        Preconditions.checkNotNull(obj);
        listenerHolderRegisterListener = googleApi.registerListener(obj, str);
        ListenerHolder.ListenerKey listenerKey = (ListenerHolder.ListenerKey) Preconditions.checkNotNull(listenerHolderRegisterListener.getListenerKey(), "Key must not be null");
        Map map = this.zzb;
        Set arraySet = (Set) map.get(str);
        if (arraySet == null) {
            arraySet = new ArraySet();
            map.put(str, arraySet);
        }
        arraySet.add(listenerKey);
        return listenerHolderRegisterListener;
    }

    public final synchronized ListenerHolder zzc(GoogleApi googleApi, String str, String str2) {
        return zzb(googleApi, zzi(str), "connection");
    }

    public final synchronized ListenerHolder.ListenerKey zzd(String str, String str2) {
        return ListenerHolders.createListenerKey(zzi(str), "connection");
    }

    public final synchronized Task zze(GoogleApi googleApi, RegistrationMethods registrationMethods) {
        ListenerHolder.ListenerKey listenerKey;
        listenerKey = (ListenerHolder.ListenerKey) Preconditions.checkNotNull(registrationMethods.register.getListenerKey(), "Key must not be null");
        return googleApi.doRegisterEventListener(registrationMethods).addOnFailureListener(new zzar(this, googleApi, listenerKey, this.zzc.add(listenerKey)));
    }

    public final synchronized Task zzf(GoogleApi googleApi, ListenerHolder.ListenerKey listenerKey) {
        String str;
        this.zzc.remove(listenerKey);
        Map map = this.zzb;
        Iterator it = map.keySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                str = null;
                break;
            }
            str = (String) it.next();
            Set set = (Set) map.get(str);
            if (set.contains(listenerKey)) {
                set.remove(listenerKey);
                break;
            }
        }
        if (str != null) {
            Map map2 = this.zzd;
            for (Map.Entry entry : map2.entrySet()) {
                if (ListenerHolders.createListenerKey(entry.getValue(), str).equals(listenerKey)) {
                    map2.remove(entry.getKey());
                    break;
                }
            }
        }
        return googleApi.doUnregisterEventListener(listenerKey);
    }

    public final synchronized Task zzg(GoogleApi googleApi, String str) {
        ArraySet arraySet = new ArraySet();
        Map map = this.zzb;
        Set set = (Set) map.get(str);
        if (set == null) {
            return Tasks.whenAll(arraySet);
        }
        for (ListenerHolder.ListenerKey listenerKey : new ArraySet(set)) {
            if (this.zzc.contains(listenerKey)) {
                arraySet.add(zzf(googleApi, listenerKey));
            }
        }
        map.remove(str);
        return Tasks.whenAll(arraySet);
    }

    final /* synthetic */ Set zzh() {
        return this.zzc;
    }
}
