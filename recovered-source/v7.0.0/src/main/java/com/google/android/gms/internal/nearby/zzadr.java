package com.google.android.gms.internal.nearby;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzadr extends zzadv {
    private static final zzadv zza = new zzadr();

    private zzadr() {
    }

    public static zzadv zza() {
        return zza;
    }

    @Override // com.google.android.gms.internal.nearby.zzadv
    public final int zzb(zzads zzadsVar, int i, String str, int i2, int i3, int i4) throws zzadu {
        zzadn zzadnVarZza;
        char cCharAt = str.charAt(i4);
        zzabg zzabgVarZzb = zzabg.zzb(str, i3, i4, (cCharAt & ' ') == 0);
        zzabf zzabfVarZza = zzabf.zza(cCharAt);
        int i5 = i4 + 1;
        if (zzabfVarZza != null) {
            if (!zzabgVarZzb.zzi(zzabfVarZza)) {
                throw zzadu.zza("invalid format specifier", str, i2, i5);
            }
            zzadnVarZza = zzadp.zza(i, zzabfVarZza, zzabgVarZzb);
        } else if (cCharAt == 't' || cCharAt == 'T') {
            if (!zzabgVarZzb.zzh(160, false)) {
                throw zzadu.zza("invalid format specification", str, i2, i5);
            }
            int i6 = i4 + 2;
            if (i6 > str.length()) {
                throw zzadu.zzb("truncated format specifier", str, i2);
            }
            zzadl zzadlVarZza = zzadl.zza(str.charAt(i5));
            if (zzadlVarZza == null) {
                throw zzadu.zzb("illegal date/time conversion", str, i5);
            }
            zzadnVarZza = zzadm.zza(zzadlVarZza, zzabgVarZzb, i);
            i5 = i6;
        } else {
            if (cCharAt != 'h' && cCharAt != 'H') {
                throw zzadu.zza("invalid format specification", str, i2, i5);
            }
            if (!zzabgVarZzb.zzh(160, false)) {
                throw zzadu.zza("invalid format specification", str, i2, i5);
            }
            zzadnVarZza = new zzadq(zzabgVarZzb, i, zzabgVarZzb);
        }
        zzadsVar.zzk(i2, i5, zzadnVarZza);
        return i5;
    }
}
