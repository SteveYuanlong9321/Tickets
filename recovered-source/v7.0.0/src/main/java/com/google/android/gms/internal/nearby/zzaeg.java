package com.google.android.gms.internal.nearby;

import androidx.compose.foundation.style.StylePropertiesKt;
import kotlin.UByte;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class zzaeg {
    private static final char[] zza = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    public static final /* synthetic */ int zzb = 0;

    zzaeg() {
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzaeg) {
            zzaeg zzaegVar = (zzaeg) obj;
            if (zza() == zzaegVar.zza() && zze(zzaegVar)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        if (zza() >= 32) {
            return zzc();
        }
        byte[] bArrZzd = zzd();
        int i = bArrZzd[0] & UByte.MAX_VALUE;
        for (int i2 = 1; i2 < bArrZzd.length; i2++) {
            i |= (bArrZzd[i2] & UByte.MAX_VALUE) << (i2 * 8);
        }
        return i;
    }

    public final String toString() {
        byte[] bArrZzd = zzd();
        int length = bArrZzd.length;
        StringBuilder sb = new StringBuilder(length + length);
        for (byte b : bArrZzd) {
            char[] cArr = zza;
            sb.append(cArr[(b >> 4) & 15]);
            sb.append(cArr[b & StylePropertiesKt.RightId]);
        }
        return sb.toString();
    }

    public abstract int zza();

    public abstract byte[] zzb();

    public abstract int zzc();

    byte[] zzd() {
        throw null;
    }

    abstract boolean zze(zzaeg zzaegVar);
}
