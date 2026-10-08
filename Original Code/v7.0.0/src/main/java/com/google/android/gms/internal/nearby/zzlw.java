package com.google.android.gms.internal.nearby;

import java.io.IOException;
import java.util.HashMap;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzlw {
    private static final zzlw zza = new zzlw(zzyn.zzr());
    private final zzyn zzb;

    zzlw(zzyn zzynVar) {
        this.zzb = zzynVar;
    }

    /* JADX WARN: Code duplicated, block: B:60:0x015a  */
    public static zzlw zza(zzlw zzlwVar, zzyj zzyjVar) {
        long j;
        if (zzyjVar.isEmpty()) {
            return zzlwVar;
        }
        HashMap map = new HashMap(zzyjVar);
        zzym zzymVar = new zzym(zzyy.zza());
        zzzl it = zzlwVar.zzb.iterator();
        while (it.hasNext()) {
            zzlu zzluVar = (zzlu) it.next();
            Object objRemove = map.remove(zzluVar.zza());
            if (objRemove == null) {
                zzymVar.zzd(zzluVar);
            } else if (objRemove instanceof String) {
                zzymVar.zzd(new zzlu(zzluVar.zza, zzluVar.zzb, 4, 0L, objRemove));
            } else if (objRemove instanceof byte[]) {
                zzymVar.zzd(new zzlu(zzluVar.zza, zzluVar.zzb, 5, 0L, objRemove));
            } else if (objRemove instanceof Boolean) {
                zzymVar.zzd(new zzlu(zzluVar.zza, zzluVar.zzb, ((Boolean) objRemove).booleanValue() ? 1 : 0, 0L, null));
            } else if (objRemove instanceof Long) {
                zzymVar.zzd(new zzlu(zzluVar.zza, zzluVar.zzb, 2, ((Long) objRemove).longValue(), null));
            } else {
                if (!(objRemove instanceof Double)) {
                    String strZza = zzluVar.zza();
                    String string = objRemove.toString();
                    StringBuilder sb = new StringBuilder(String.valueOf(strZza).length() + 46 + string.length());
                    sb.append("Cannot serialize override for existing flag ");
                    sb.append(strZza);
                    sb.append(": ");
                    sb.append(string);
                    throw new IllegalStateException(sb.toString());
                }
                zzymVar.zzd(new zzlu(zzluVar.zza, zzluVar.zzb, 3, Double.doubleToRawLongBits(((Double) objRemove).doubleValue()), null));
            }
        }
        for (String str : map.keySet()) {
            Object obj = map.get(str);
            int length = str.length();
            if (length > 19 || length == 0) {
                j = 0;
                break;
            }
            boolean z = false;
            long jCharAt = str.charAt(0) - '0';
            if (jCharAt < 1 || jCharAt > 9) {
                j = 0;
                break;
            }
            int i = 1;
            while (true) {
                if (i >= length) {
                    if (jCharAt >= 0 && jCharAt <= 2305843009213693951L) {
                        j = jCharAt;
                        break;
                    }
                    break;
                }
                int iCharAt = str.charAt(i) - '0';
                if (!((iCharAt > 9) | (iCharAt < 0 ? true : z))) {
                    jCharAt = (jCharAt * 10) + ((long) iCharAt);
                    i++;
                    z = false;
                }
                j = 0;
                break;
            }
            String str2 = j == 0 ? str : null;
            if (obj instanceof String) {
                zzymVar.zzd(new zzlu(j, str2, 4, 0L, obj));
            } else if (obj instanceof byte[]) {
                zzymVar.zzd(new zzlu(j, str2, 5, 0L, obj));
            } else if (obj instanceof Boolean) {
                zzymVar.zzd(new zzlu(j, str2, ((Boolean) obj).booleanValue() ? 1 : 0, 0L, null));
            } else if (obj instanceof Long) {
                zzymVar.zzd(new zzlu(j, str2, 2, ((Long) obj).longValue(), null));
            } else {
                if (!(obj instanceof Double)) {
                    String strValueOf = String.valueOf(obj);
                    StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 28 + String.valueOf(strValueOf).length());
                    sb2.append("Cannot serialize override ");
                    sb2.append(str);
                    sb2.append(": ");
                    sb2.append(strValueOf);
                    throw new IllegalStateException(sb2.toString());
                }
                zzymVar.zzd(new zzlu(j, str2, 3, Double.doubleToRawLongBits(((Double) obj).doubleValue()), null));
            }
        }
        return new zzlw(zzymVar.zze());
    }

    public static zzlw zzb() {
        return zza;
    }

    public static zzlw zzd(zzaio zzaioVar, zzwx zzwxVar, zzlv zzlvVar) throws IOException {
        long j;
        String strZzl;
        zzlu zzluVar;
        int iZzx = zzaioVar.zzx();
        if (iZzx < 0) {
            throw new zzakf("Negative number of flags");
        }
        zzym zzymVar = new zzym(zzyy.zza());
        long j2 = 0;
        for (int i = 0; i < iZzx; i++) {
            long jZzz = zzaioVar.zzz();
            int i2 = (int) jZzz;
            long j3 = jZzz >>> 3;
            if (j3 == 0) {
                j = 0;
                strZzl = zzaioVar.zzl();
            } else {
                long j4 = j3 + j2;
                if (j4 > 2305843009213693951L) {
                    throw new zzakf("Flag name larger than max size");
                }
                j = j4;
                strZzl = null;
            }
            int i3 = i2 & 7;
            if (i3 == 0 || i3 == 1) {
                zzluVar = new zzlu(j, strZzl, i3, 0L, null);
            } else if (i3 == 2) {
                zzluVar = new zzlu(j, strZzl, i3, zzaioVar.zzz(), null);
            } else if (i3 == 3) {
                zzluVar = new zzlu(j, strZzl, i3, Double.doubleToRawLongBits(zzaioVar.zzd()), null);
            } else if (i3 == 4) {
                zzluVar = new zzlu(j, strZzl, i3, 0L, zzaioVar.zzl());
            } else {
                if (i3 != 5) {
                    StringBuilder sb = new StringBuilder(String.valueOf(i3).length() + 23);
                    sb.append("Unrecognized flag type ");
                    sb.append(i3);
                    throw new zzakf(sb.toString());
                }
                zzluVar = new zzlu(j, strZzl, i3, 0L, zzaioVar.zzo());
            }
            long j5 = zzluVar.zza;
            if (j5 != 0) {
                j2 = j5;
            }
            zzymVar.zzd(zzluVar);
        }
        return new zzlw(zzymVar.zze());
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzlw) {
            return this.zzb.equals(((zzlw) obj).zzb);
        }
        return false;
    }

    public final int hashCode() {
        return this.zzb.hashCode();
    }

    public final void zzc(zzyi zzyiVar) {
        zzzl it = this.zzb.iterator();
        while (it.hasNext()) {
            zzlu zzluVar = (zzlu) it.next();
            zzyiVar.zza(zzluVar.zza(), zzluVar.zzb());
        }
    }

    public final zzyn zze() {
        return this.zzb;
    }

    public final int zzf() {
        return this.zzb.size();
    }
}
