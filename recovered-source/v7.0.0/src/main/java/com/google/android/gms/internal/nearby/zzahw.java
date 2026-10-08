package com.google.android.gms.internal.nearby;

import java.io.InputStream;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class zzahw implements zzakz {
    static {
        int i = zzaiz.zzb;
        int i2 = zzahy.zza;
    }

    @Override // com.google.android.gms.internal.nearby.zzakz
    public final /* synthetic */ Object zza(InputStream inputStream, zzaiz zzaizVar) throws zzakf {
        zzall zzallVar;
        zzaio zzaioVarZzL = zzaio.zzL(inputStream, 4096);
        zzaks zzaksVar = (zzaks) zzb(zzaioVarZzL, zzaizVar);
        zzaioVarZzL.zzb(0);
        if (zzaksVar == null || zzaksVar.zzbf()) {
            return zzaksVar;
        }
        if (zzaksVar instanceof zzahu) {
            zzallVar = new zzall((zzahu) zzaksVar);
        } else {
            if (zzaksVar instanceof zzahv) {
                throw null;
            }
            zzallVar = new zzall(zzaksVar);
        }
        throw zzallVar.zza();
    }
}
