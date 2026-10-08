package com.google.android.gms.internal.nearby;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zztt extends zztu {
    private final zzaks zza;
    private final zzaiz zzb;

    zztt(zzaks zzaksVar, zzaiz zzaizVar) {
        this.zza = zzaksVar;
        if (zzaizVar == null) {
            throw new NullPointerException("Null extensionRegistryLite");
        }
        this.zzb = zzaizVar;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zztu) {
            zztu zztuVar = (zztu) obj;
            if (this.zza.equals(zztuVar.zzb()) && this.zzb.equals(zztuVar.zzc())) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = this.zza.hashCode() ^ 1000003;
        return this.zzb.hashCode() ^ (iHashCode * 1000003);
    }

    public final String toString() {
        String string = this.zza.toString();
        int length = string.length();
        String string2 = this.zzb.toString();
        StringBuilder sb = new StringBuilder(length + 53 + string2.length() + 1);
        sb.append("ProtoSerializer{defaultValue=");
        sb.append(string);
        sb.append(", extensionRegistryLite=");
        sb.append(string2);
        sb.append("}");
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.nearby.zztu, com.google.android.gms.internal.nearby.zzsl
    public final /* synthetic */ Object zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.nearby.zztu
    public final zzaks zzb() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.nearby.zztu
    public final zzaiz zzc() {
        return this.zzb;
    }
}
