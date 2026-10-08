package com.google.android.gms.internal.nearby;

import android.text.TextUtils;
import com.google.mlkit.common.MlKitException;
import java.util.Arrays;
import java.util.Locale;
import java.util.UUID;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
abstract class zzud implements zzvj {
    private final zzvj zza;
    private final UUID zzb;
    private final String zzc;
    private final String zzd;
    private Thread zze;

    zzud(String str, zzvj zzvjVar, zzvh zzvhVar) {
        this.zzd = str;
        this.zza = zzvjVar;
        this.zzb = zzvjVar.zzc();
        this.zzc = zzvjVar.zzd();
        zzug zzugVar = zzvhVar.zzc;
        this.zze = Thread.currentThread();
    }

    public static String zzbj(UUID uuid) {
        String string = Long.toString(uuid.getLeastSignificantBits() >>> 1, 36);
        String.valueOf(string);
        return "tk-trace-id: ".concat(String.valueOf(string));
    }

    @Override // com.google.android.gms.internal.nearby.zzvk, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        zzvh zzvhVarZzd = zzup.zzd();
        zzvj zzvjVar = zzvhVarZzd.zzb;
        if (zzvjVar == null) {
            String strZze = zze();
            StringBuilder sb = new StringBuilder(strZze.length() + MlKitException.NOT_ENOUGH_SPACE);
            sb.append("Tried to end [");
            sb.append(strZze);
            sb.append("], but no trace was active. This is caused by mismatched or missing calls to beginSpan.");
            throw new zzum(sb.toString());
        }
        if (this == zzvjVar) {
            zzup.zzc(zzvhVarZzd, zzvjVar.zzb());
            this.zze = null;
            return;
        }
        String strZze2 = zze();
        String strZze3 = zzvjVar.zze();
        StringBuilder sb2 = new StringBuilder(strZze2.length() + 79 + strZze3.length() + 1);
        sb2.append("Tried to end span ");
        sb2.append(strZze2);
        sb2.append(", but that span is not the current span. The current span is ");
        sb2.append(strZze3);
        sb2.append(".");
        throw new zzun(sb2.toString());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v0, types: [com.google.android.gms.internal.nearby.zzud] */
    /* JADX WARN: Type inference failed for: r11v1, types: [com.google.android.gms.internal.nearby.zzvj] */
    /* JADX WARN: Type inference failed for: r11v3, types: [com.google.android.gms.internal.nearby.zzvj] */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [com.google.android.gms.internal.nearby.zzvj] */
    /* JADX WARN: Type inference failed for: r1v21, types: [com.google.android.gms.internal.nearby.zzvj] */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v1, types: [com.google.android.gms.internal.nearby.zzvj] */
    /* JADX WARN: Type inference failed for: r6v11 */
    public final String toString() {
        String strConcat;
        int i = zzup.zzb;
        ?? Zzb = this;
        int i2 = 0;
        int length = 0;
        while (Zzb != 0) {
            i2++;
            length += Zzb.zze().length();
            Zzb = Zzb.zzb();
            if (Zzb != 0) {
                length += 4;
            }
        }
        if (i2 > 250) {
            int i3 = i2 - 1;
            String[] strArr = new String[i2];
            ?? Zzb2 = this;
            while (i3 >= 0) {
                strArr[i3] = Zzb2.zze();
                i3--;
                Zzb2 = Zzb2.zzb();
            }
            zzyi zzyiVar = new zzyi();
            zzzl it = zzyl.zzn(strArr).iterator();
            int i4 = 0;
            while (it.hasNext()) {
                zzyiVar.zza(it.next(), Integer.valueOf(i4));
                i4++;
            }
            zzyj zzyjVarZzb = zzyiVar.zzb();
            int i5 = i2 >> 2;
            zzvf zzvfVar = null;
            if (zzyjVarZzb.size() <= i5) {
                int[] iArr = new int[i2 + 1];
                for (int i6 = 0; i6 < i2; i6++) {
                    iArr[i6] = ((Integer) zzyjVarZzb.get(strArr[i6])).intValue();
                }
                iArr[i2] = zzyjVarZzb.size();
                zzvf zzvfVarZzd = zzvg.zza(iArr).zzd();
                if (zzvfVarZzd.zzc * (zzvfVarZzd.zzb - zzvfVarZzd.zza) >= i5) {
                    zzvfVar = zzvfVarZzd;
                }
            }
            String strConcat2 = "";
            if (zzvfVar != null) {
                int i7 = zzvfVar.zza;
                if (i7 > 0) {
                    String strJoin = TextUtils.join(" -> ", Arrays.copyOf(strArr, i7));
                    String.valueOf(strJoin);
                    strConcat = String.valueOf(strJoin).concat(" -> ");
                } else {
                    strConcat = "";
                }
                int i8 = zzvfVar.zzb;
                int i9 = zzvfVar.zzc;
                int i10 = ((i8 - i7) * i9) + i7;
                if (i10 < i2) {
                    String strJoin2 = TextUtils.join(" -> ", Arrays.copyOfRange(strArr, i10, i2));
                    String.valueOf(strJoin2);
                    strConcat2 = " -> ".concat(String.valueOf(strJoin2));
                }
                strConcat2 = String.format(Locale.US, "%s{%s}x%d%s", strConcat, TextUtils.join(" -> ", Arrays.copyOfRange(strArr, i7, i8)), Integer.valueOf(i9), strConcat2);
            }
            if (!strConcat2.isEmpty()) {
                return strConcat2;
            }
        }
        char[] cArr = new char[length];
        while (this != 0) {
            String strZze = this.zze();
            length -= strZze.length();
            strZze.getChars(0, strZze.length(), cArr, length);
            this = this.zzb();
            if (this != 0) {
                length -= 4;
                " -> ".getChars(0, 4, cArr, length);
            }
        }
        return new String(cArr);
    }

    @Override // com.google.android.gms.internal.nearby.zzvj
    public final Thread zza() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.nearby.zzvj
    public final zzvj zzb() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.nearby.zzvj
    public final UUID zzc() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.nearby.zzvj
    public final String zzd() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.nearby.zzvj
    public final String zze() {
        return this.zzd;
    }

    zzud(String str, UUID uuid, String str2, zzvh zzvhVar) {
        this.zzd = str;
        this.zza = null;
        this.zzb = uuid;
        this.zzc = str2;
        zzug zzugVar = zzvhVar.zzc;
        this.zze = Thread.currentThread();
    }
}
