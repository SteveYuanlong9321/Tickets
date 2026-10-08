package com.google.android.gms.internal.nearby;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Calendar;
import java.util.Date;
import java.util.Formattable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzabe extends zzads implements zzado {
    protected final Object[] zza;
    protected final StringBuilder zzb;
    private int zzc;

    protected zzabe(zzacl zzaclVar, Object[] objArr, StringBuilder sb) {
        super(zzaclVar);
        this.zzc = 0;
        this.zza = objArr;
        this.zzb = sb;
    }

    public static StringBuilder zza(zzabj zzabjVar, StringBuilder sb) {
        if (zzabjVar.zzh() == null) {
            sb.append(zzabn.zza(zzabjVar.zzj()));
            return sb;
        }
        zzabe zzabeVar = new zzabe(zzabjVar.zzh(), zzabjVar.zzi(), sb);
        StringBuilder sb2 = (StringBuilder) zzabeVar.zzl();
        if (zzabjVar.zzi().length > zzabeVar.zzj()) {
            sb2.append(" [ERROR: UNUSED LOG ARGUMENTS]");
        }
        return sb2;
    }

    private static void zzm(StringBuilder sb, Object obj, String str) {
        sb.append("[INVALID: format=");
        sb.append(str);
        sb.append(", type=");
        sb.append(obj.getClass().getCanonicalName());
        sb.append(", value=");
        sb.append(zzabn.zza(obj));
        sb.append("]");
    }

    @Override // com.google.android.gms.internal.nearby.zzads
    public final void zzb(int i, int i2, zzadn zzadnVar) {
        zzh().zzd(this.zzb, zzi(), this.zzc, i);
        zzadnVar.zze(this, this.zza);
        this.zzc = i2;
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0024  */
    /* JADX WARN: Code duplicated, block: B:32:0x0041  */
    /* JADX WARN: Code duplicated, block: B:69:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:71:0x00b9  */
    @Override // com.google.android.gms.internal.nearby.zzado
    public final void zzc(Object obj, zzabf zzabfVar, zzabg zzabgVar) {
        boolean zIsValidCodePoint;
        int iOrdinal = zzabfVar.zzc().ordinal();
        if (iOrdinal != 0) {
            if (iOrdinal == 1) {
                zIsValidCodePoint = obj instanceof Boolean;
            } else if (iOrdinal != 2) {
                if (iOrdinal != 3) {
                    if (iOrdinal != 4) {
                        throw null;
                    }
                    if ((obj instanceof Double) || (obj instanceof Float) || (obj instanceof BigDecimal)) {
                        zIsValidCodePoint = true;
                    } else {
                        zIsValidCodePoint = false;
                    }
                } else if ((obj instanceof Integer) || (obj instanceof Long) || (obj instanceof Byte) || (obj instanceof Short) || (obj instanceof BigInteger)) {
                    zIsValidCodePoint = true;
                } else {
                    zIsValidCodePoint = false;
                }
            } else if (obj instanceof Character) {
                zIsValidCodePoint = true;
            } else if ((obj instanceof Integer) || (obj instanceof Byte) || (obj instanceof Short)) {
                zIsValidCodePoint = Character.isValidCodePoint(((Number) obj).intValue());
            } else {
                zIsValidCodePoint = false;
            }
            if (!zIsValidCodePoint) {
                zzm(this.zzb, obj, zzabfVar.zze());
                return;
            }
        }
        StringBuilder sb = this.zzb;
        int iOrdinal2 = zzabfVar.ordinal();
        if (iOrdinal2 != 0) {
            if (iOrdinal2 == 1) {
                if (zzabgVar.zze()) {
                    sb.append(obj);
                    return;
                }
            } else if (iOrdinal2 != 2) {
                if (iOrdinal2 != 3) {
                    if (iOrdinal2 == 5 && zzabgVar.zzd(128, false, false).equals(zzabgVar)) {
                        zzabn.zzc(sb, (Number) obj, zzabgVar);
                        return;
                    }
                } else if (zzabgVar.zze()) {
                    sb.append(obj);
                    return;
                }
            } else if (zzabgVar.zze()) {
                if (obj instanceof Character) {
                    sb.append(obj);
                    return;
                }
                int iIntValue = ((Number) obj).intValue();
                if ((iIntValue >>> 16) == 0) {
                    sb.append((char) iIntValue);
                    return;
                } else {
                    sb.append(Character.toChars(iIntValue));
                    return;
                }
            }
        } else if (obj instanceof Formattable) {
            zzabn.zzb((Formattable) obj, sb, zzabgVar);
            return;
        } else if (zzabgVar.zze()) {
            sb.append(zzabn.zza(obj));
            return;
        }
        String strZze = zzabfVar.zze();
        if (!zzabgVar.zze()) {
            int iZzb = zzabfVar.zzb();
            if (zzabgVar.zzk()) {
                iZzb &= 65503;
            }
            StringBuilder sb2 = new StringBuilder("%");
            zzabgVar.zzl(sb2);
            sb2.append((char) iZzb);
            strZze = sb2.toString();
        }
        sb.append(String.format(zzabn.zza, strZze, obj));
    }

    @Override // com.google.android.gms.internal.nearby.zzado
    public final void zzd(Object obj, zzadl zzadlVar, zzabg zzabgVar) {
        if ((obj instanceof Date) || (obj instanceof Calendar) || (obj instanceof Long)) {
            StringBuilder sb = new StringBuilder("%");
            zzabgVar.zzl(sb);
            sb.append(true != zzabgVar.zzk() ? 't' : 'T');
            sb.append(zzadlVar.zzb());
            this.zzb.append(String.format(zzabn.zza, sb.toString(), obj));
            return;
        }
        StringBuilder sb2 = this.zzb;
        char cZzb = zzadlVar.zzb();
        StringBuilder sb3 = new StringBuilder(String.valueOf(cZzb).length() + 2);
        sb3.append("%t");
        sb3.append(cZzb);
        zzm(sb2, obj, sb3.toString());
    }

    @Override // com.google.android.gms.internal.nearby.zzado
    public final void zze() {
        this.zzb.append("[ERROR: MISSING LOG ARGUMENT]");
    }

    @Override // com.google.android.gms.internal.nearby.zzado
    public final void zzf() {
        this.zzb.append("null");
    }

    @Override // com.google.android.gms.internal.nearby.zzads
    public final /* bridge */ /* synthetic */ Object zzg() {
        zzadt zzadtVarZzh = zzh();
        String strZzi = zzi();
        int i = this.zzc;
        int length = zzi().length();
        StringBuilder sb = this.zzb;
        zzadtVarZzh.zzd(sb, strZzi, i, length);
        return sb;
    }
}
