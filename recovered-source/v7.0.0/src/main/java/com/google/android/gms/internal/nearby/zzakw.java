package com.google.android.gms.internal.nearby;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzakw implements zzald {
    private final zzaks zza;
    private final zzalm zzb;
    private final boolean zzc;
    private final zzaja zzd;

    private zzakw(zzalm zzalmVar, zzaja zzajaVar, zzaks zzaksVar) {
        this.zzb = zzalmVar;
        this.zzc = zzaksVar instanceof zzajl;
        this.zzd = zzajaVar;
        this.zza = zzaksVar;
    }

    static zzakw zzh(zzalm zzalmVar, zzaja zzajaVar, zzaks zzaksVar) {
        return new zzakw(zzalmVar, zzajaVar, zzaksVar);
    }

    @Override // com.google.android.gms.internal.nearby.zzald
    public final Object zza() {
        zzaks zzaksVar = this.zza;
        return zzaksVar instanceof zzajo ? ((zzajo) zzaksVar).zzD() : zzaksVar.zzbe().zzp();
    }

    @Override // com.google.android.gms.internal.nearby.zzald
    public final boolean zzb(Object obj, Object obj2) {
        if (!((zzajo) obj).zzc.equals(((zzajo) obj2).zzc)) {
            return false;
        }
        if (this.zzc) {
            return ((zzajl) obj).zzb.equals(((zzajl) obj2).zzb);
        }
        return true;
    }

    @Override // com.google.android.gms.internal.nearby.zzald
    public final int zzc(Object obj) {
        int iHashCode = ((zzajo) obj).zzc.hashCode();
        return this.zzc ? (iHashCode * 53) + ((zzajl) obj).zzb.zza.hashCode() : iHashCode;
    }

    @Override // com.google.android.gms.internal.nearby.zzald
    public final void zzd(Object obj, Object obj2) {
        zzale.zzB(this.zzb, obj, obj2);
        if (this.zzc) {
            zzale.zzA(this.zzd, obj, obj2);
        }
    }

    @Override // com.google.android.gms.internal.nearby.zzald
    public final int zze(Object obj) {
        int iZzh;
        int iNumberOfLeadingZeros;
        int i;
        int iZzh2 = ((zzajo) obj).zzc.zzh();
        if (!this.zzc) {
            return iZzh2;
        }
        zzali zzaliVar = ((zzajl) obj).zzb.zza;
        int size = zzaliVar.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            Map.Entry entryZzb = zzaliVar.zzb(i3);
            zzalf zzalfVar = (zzalf) entryZzb;
            zzajd zzajdVarZza = zzalfVar.zza();
            Object value = entryZzb.getValue();
            if (zzajdVarZza.zzc() != zzama.MESSAGE || zzajdVarZza.zzd() || zzajdVarZza.zze()) {
                iZzh = zzaje.zzh(zzajdVarZza, value);
            } else {
                if (value instanceof zzakd) {
                    int iZza = zzalfVar.zza().zza();
                    int iNumberOfLeadingZeros2 = Integer.numberOfLeadingZeros(8) * 9;
                    int iNumberOfLeadingZeros3 = Integer.numberOfLeadingZeros(16) * 9;
                    int iNumberOfLeadingZeros4 = (352 - (Integer.numberOfLeadingZeros(iZza) * 9)) >>> 6;
                    int iNumberOfLeadingZeros5 = Integer.numberOfLeadingZeros(24) * 9;
                    int iZzb = ((zzakd) value).zzb();
                    int i4 = (352 - iNumberOfLeadingZeros2) >>> 6;
                    i = i4 + i4 + ((352 - iNumberOfLeadingZeros3) >>> 6) + iNumberOfLeadingZeros4;
                    iNumberOfLeadingZeros = ((352 - iNumberOfLeadingZeros5) >>> 6) + ((352 - (Integer.numberOfLeadingZeros(iZzb) * 9)) >>> 6) + iZzb;
                } else {
                    int iZza2 = zzalfVar.zza().zza();
                    int iNumberOfLeadingZeros6 = Integer.numberOfLeadingZeros(8) * 9;
                    int iNumberOfLeadingZeros7 = Integer.numberOfLeadingZeros(16) * 9;
                    int iNumberOfLeadingZeros8 = (352 - (Integer.numberOfLeadingZeros(iZza2) * 9)) >>> 6;
                    iNumberOfLeadingZeros = ((352 - (Integer.numberOfLeadingZeros(24) * 9)) >>> 6) + zzaiu.zzE((zzaks) value);
                    int i5 = (352 - iNumberOfLeadingZeros6) >>> 6;
                    i = i5 + i5 + ((352 - iNumberOfLeadingZeros7) >>> 6) + iNumberOfLeadingZeros8;
                }
                iZzh = i + iNumberOfLeadingZeros;
            }
            i2 += iZzh;
        }
        return iZzh2 + i2;
    }

    @Override // com.google.android.gms.internal.nearby.zzald
    public final void zzf(Object obj, zzaiv zzaivVar) throws IOException {
        Iterator itZzc = ((zzajl) obj).zzb.zzc();
        while (itZzc.hasNext()) {
            Map.Entry entry = (Map.Entry) itZzc.next();
            zzajd zzajdVar = (zzajd) entry.getKey();
            if (zzajdVar.zzc() != zzama.MESSAGE || zzajdVar.zzd() || zzajdVar.zze()) {
                throw new IllegalStateException("Found invalid MessageSet item.");
            }
            if (entry instanceof zzakb) {
                zzaivVar.zzv(zzajdVar.zza(), ((zzakb) entry).zza().zzc());
            } else {
                zzaivVar.zzv(zzajdVar.zza(), entry.getValue());
            }
        }
        ((zzajo) obj).zzc.zzf(zzaivVar);
    }

    @Override // com.google.android.gms.internal.nearby.zzald
    public final void zzg(Object obj, zzaip zzaipVar, zzaiz zzaizVar) throws IOException {
        zzalo.zzj(obj);
        throw null;
    }

    @Override // com.google.android.gms.internal.nearby.zzald
    public final void zzj(Object obj, byte[] bArr, int i, int i2, zzahz zzahzVar) throws IOException {
        zzajo zzajoVar = (zzajo) obj;
        if (zzajoVar.zzc == zzaln.zza()) {
            zzajoVar.zzc = zzaln.zzb();
        }
        throw null;
    }

    @Override // com.google.android.gms.internal.nearby.zzald
    public final void zzk(Object obj) {
        ((zzajo) obj).zzc.zzd();
        ((zzajl) obj).zzb.zzb();
    }

    @Override // com.google.android.gms.internal.nearby.zzald
    public final boolean zzl(Object obj) {
        return ((zzajl) obj).zzb.zzd();
    }
}
