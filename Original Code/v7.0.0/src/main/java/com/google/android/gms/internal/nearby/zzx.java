package com.google.android.gms.internal.nearby;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzx {
    public static Object zza(Class cls, String str, zzw... zzwVarArr) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        int length = zzwVarArr.length;
        Class<?>[] clsArr = new Class[length];
        Object[] objArr = new Object[length];
        for (int i = 0; i < zzwVarArr.length; i++) {
            zzw zzwVar = zzwVarArr[i];
            zzwVar.getClass();
            clsArr[i] = zzwVar.zzb();
            objArr[i] = zzwVarArr[i].zzc();
        }
        Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
        declaredMethod.setAccessible(true);
        return declaredMethod.invoke(null, objArr);
    }
}
