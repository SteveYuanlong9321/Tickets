package com.google.android.gms.internal.nearby;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzlu implements Comparable {
    final long zza;
    final String zzb;
    final int zzc;
    final long zzd;
    final Object zze;
    private final RuntimeException zzf;

    zzlu(long j, String str, int i, long j2, Object obj) {
        zzxd.zza(((j > 0L ? 1 : (j == 0L ? 0 : -1)) == 0) == (str != null));
        this.zza = j;
        this.zzb = str;
        this.zzc = i;
        this.zzd = j2;
        this.zze = obj;
        if (i != 5) {
            this.zzf = null;
            return;
        }
        if (obj == null) {
            this.zzf = new NullPointerException("Null stringOrBytes");
            return;
        }
        if ((obj instanceof byte[]) || (obj instanceof zzaik)) {
            this.zzf = null;
            return;
        }
        String strValueOf = String.valueOf(obj.getClass());
        String.valueOf(strValueOf);
        this.zzf = new RuntimeException("Wrong stringOrBytes type: ".concat(String.valueOf(strValueOf)));
    }

    @Override // java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        String str;
        zzlu zzluVar = (zzlu) obj;
        long j = zzluVar.zza;
        long j2 = this.zza;
        int iCompare = Long.compare(j2, j);
        if (iCompare != 0) {
            return iCompare;
        }
        if (j2 != 0) {
            return 0;
        }
        String str2 = this.zzb;
        if (str2 == null || (str = zzluVar.zzb) == null) {
            throw null;
        }
        return str2.compareTo(str);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzlu)) {
            return false;
        }
        zzlu zzluVar = (zzlu) obj;
        return this.zza == zzluVar.zza && Objects.equals(this.zzb, zzluVar.zzb);
    }

    public final int hashCode() {
        return Objects.hash(Long.valueOf(this.zza), this.zzb);
    }

    public final String toString() {
        String strZza = zza();
        String string = zzb().toString();
        StringBuilder sb = new StringBuilder(String.valueOf(strZza).length() + 1 + string.length());
        sb.append(strZza);
        sb.append(":");
        sb.append(string);
        return sb.toString();
    }

    public final String zza() {
        String str = this.zzb;
        return str != null ? str : Long.toString(this.zza);
    }

    public final Object zzb() {
        int i = this.zzc;
        if (i == 0) {
            return false;
        }
        if (i == 1) {
            return true;
        }
        if (i == 2) {
            return Long.valueOf(this.zzd);
        }
        if (i == 3) {
            return Double.valueOf(Double.longBitsToDouble(this.zzd));
        }
        if (i == 4) {
            Object obj = this.zze;
            obj.getClass();
            return obj;
        }
        if (i != 5) {
            throw new AssertionError("Impossible, this was validated when parsed or created");
        }
        Object obj2 = this.zze;
        obj2.getClass();
        try {
            return obj2 instanceof byte[] ? (byte[]) obj2 : ((zzaik) obj2).zzm();
        } catch (Throwable th) {
            RuntimeException runtimeException = this.zzf;
            if (runtimeException != null) {
                th.addSuppressed(runtimeException);
            }
            throw th;
        }
    }
}
