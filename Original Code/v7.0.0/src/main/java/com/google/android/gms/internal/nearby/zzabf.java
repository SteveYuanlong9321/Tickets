package com.google.android.gms.internal.nearby;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public enum zzabf {
    STRING('s', zzabh.GENERAL, "-#", true),
    BOOLEAN('b', zzabh.BOOLEAN, "-", true),
    CHAR('c', zzabh.CHARACTER, "-", true),
    DECIMAL('d', zzabh.INTEGRAL, "-0+ ,(", false),
    OCTAL('o', zzabh.INTEGRAL, "-#0(", false),
    HEX('x', zzabh.INTEGRAL, "-#0(", true),
    FLOAT('f', zzabh.FLOAT, "-#0+ ,(", false),
    EXPONENT('e', zzabh.FLOAT, "-#0+ (", true),
    GENERAL('g', zzabh.FLOAT, "-0+ ,(", true),
    EXPONENT_HEX('a', zzabh.FLOAT, "-#0+ ", true);

    private static final zzabf[] zzk = new zzabf[26];
    private final char zzl;
    private final zzabh zzm;
    private final int zzn;
    private final String zzo;

    static {
        for (zzabf zzabfVar : values()) {
            zzk[(zzabfVar.zzl | ' ') - 97] = zzabfVar;
        }
    }

    zzabf(char c, zzabh zzabhVar, String str, boolean z) {
        this.zzl = c;
        this.zzm = zzabhVar;
        this.zzn = zzabg.zzc(str, z);
        StringBuilder sb = new StringBuilder(String.valueOf(c).length() + 1);
        sb.append("%");
        sb.append(c);
        this.zzo = sb.toString();
    }

    public static zzabf zza(char c) {
        zzabf zzabfVar = zzk[(c | ' ') - 97];
        if ((c & ' ') == 0 && (zzabfVar == null || (zzabfVar.zzn & 128) == 0)) {
            return null;
        }
        return zzabfVar;
    }

    public final char zzb() {
        return this.zzl;
    }

    public final zzabh zzc() {
        return this.zzm;
    }

    final int zzd() {
        return this.zzn;
    }

    public final String zze() {
        return this.zzo;
    }
}
