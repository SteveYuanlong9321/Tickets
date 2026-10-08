package com.google.android.gms.internal.nearby;

import com.google.android.gms.internal.nearby.zzajj;
import com.google.android.gms.internal.nearby.zzajo;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public class zzajj<MessageT extends zzajo<MessageT, BuilderT>, BuilderT extends zzajj<MessageT, BuilderT>> extends zzaht<MessageT, BuilderT> {
    protected zzajo zza;
    private final zzajo zzb;

    protected zzajj(MessageT messaget) {
        this.zzb = messaget;
        if (messaget.zzy()) {
            throw new IllegalArgumentException("Default instance must be immutable.");
        }
        this.zza = messaget.zzD();
    }

    private static void zza(zzajo zzajoVar, zzajo zzajoVar2) {
        zzala.zza().zzb(zzajoVar.getClass()).zzd(zzajoVar, zzajoVar2);
    }

    @Override // com.google.android.gms.internal.nearby.zzakt
    public final boolean zzbf() {
        return zzajo.zze(this.zza, false);
    }

    @Override // com.google.android.gms.internal.nearby.zzakt
    public final /* bridge */ /* synthetic */ zzaks zzbg() {
        throw null;
    }

    protected final void zzi() {
        if (this.zza.zzy()) {
            return;
        }
        zzj();
    }

    protected void zzj() {
        zzajo zzajoVarZzD = this.zzb.zzD();
        zza(zzajoVarZzD, this.zza);
        this.zza = zzajoVarZzD;
    }

    @Override // com.google.android.gms.internal.nearby.zzaht
    /* JADX INFO: renamed from: zzl, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public final zzajj zzh() {
        zzajj zzajjVarZzbe = this.zzb.zzbe();
        zzajjVarZzbe.zza = zzp();
        return zzajjVarZzbe;
    }

    @Override // com.google.android.gms.internal.nearby.zzakr
    /* JADX INFO: renamed from: zzm, reason: merged with bridge method [inline-methods] */
    public MessageT zzp() {
        boolean zZzy = this.zza.zzy();
        MessageT messaget = (MessageT) this.zza;
        if (!zZzy) {
            return messaget;
        }
        messaget.zzF();
        return (MessageT) this.zza;
    }

    public final MessageT zzn() {
        MessageT messaget = (MessageT) zzp();
        if (messaget.zzbf()) {
            return messaget;
        }
        throw new zzall(messaget);
    }

    public final zzajj zzo(zzajo zzajoVar) {
        zzajo zzajoVar2 = this.zzb;
        if (!zzajoVar2.getClass().isInstance(zzajoVar)) {
            throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
        }
        if (zzajoVar2.equals(zzajoVar)) {
            return this;
        }
        zzi();
        zza(this.zza, zzajoVar);
        return this;
    }
}
