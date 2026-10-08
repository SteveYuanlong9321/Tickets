package com.google.android.gms.internal.nearby;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.ServiceConfigurationError;
import java.util.ServiceLoader;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class zzajh {
    static zzaiz zzb(Class cls) {
        ClassLoader classLoader = zzajh.class.getClassLoader();
        if (cls.equals(zzaiz.class)) {
            try {
                try {
                    return (zzaiz) cls.cast(((zzajh) Class.forName("com.google.protobuf.BlazeGeneratedExtensionRegistryLiteLoader", true, classLoader).getConstructor(null).newInstance(null)).zza());
                } catch (ReflectiveOperationException e) {
                    throw new IllegalStateException(e);
                }
            } catch (ClassNotFoundException unused) {
            }
        }
        Iterator it = ServiceLoader.load(zzajh.class, classLoader).iterator();
        ArrayList arrayList = new ArrayList();
        while (it.hasNext()) {
            try {
                arrayList.add((zzaiz) cls.cast(((zzajh) it.next()).zza()));
            } catch (ServiceConfigurationError e2) {
                Logger logger = Logger.getLogger(zzaiu.class.getName());
                Level level = Level.SEVERE;
                String simpleName = cls.getSimpleName();
                String.valueOf(simpleName);
                logger.logp(level, "com.google.protobuf.GeneratedExtensionRegistryLoader", "load", "Unable to load ".concat(String.valueOf(simpleName)), (Throwable) e2);
            }
        }
        if (arrayList.size() == 1) {
            return (zzaiz) arrayList.get(0);
        }
        if (arrayList.size() == 0) {
            return null;
        }
        try {
            return (zzaiz) cls.getMethod("combine", Collection.class).invoke(null, arrayList);
        } catch (ReflectiveOperationException e3) {
            throw new IllegalStateException(e3);
        }
    }

    protected abstract zzaiz zza();
}
