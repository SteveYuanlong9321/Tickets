package com.google.android.gms.internal.nearby;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.TaskUtil;
import com.google.android.gms.tasks.TaskCompletionSource;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzix extends zzjf {
    private final TaskCompletionSource zza;

    /* synthetic */ zzix(TaskCompletionSource taskCompletionSource, byte[] bArr) {
        this.zza = taskCompletionSource;
    }

    @Override // com.google.android.gms.internal.nearby.zzjg
    public final void zzb(Status status) {
        TaskUtil.setResultOrApiException(status, this.zza);
    }

    @Override // com.google.android.gms.internal.nearby.zzjg
    public final void zzc(Status status) {
        TaskUtil.setResultOrApiException(status, this.zza);
    }

    @Override // com.google.android.gms.internal.nearby.zzjg
    public final void zzd(Status status) {
        TaskUtil.setResultOrApiException(status, this.zza);
    }

    @Override // com.google.android.gms.internal.nearby.zzjg
    public final void zze(Status status) {
        TaskUtil.setResultOrApiException(status, this.zza);
    }

    @Override // com.google.android.gms.internal.nearby.zzjg
    public final void zzf(Status status, @Nullable zzhw zzhwVar) {
        TaskUtil.setResultOrApiException(status, zzhwVar, (TaskCompletionSource<zzhw>) this.zza);
    }

    @Override // com.google.android.gms.internal.nearby.zzjg
    public final void zzg(Status status) {
        TaskUtil.setResultOrApiException(status, this.zza);
    }

    @Override // com.google.android.gms.internal.nearby.zzjg
    public final void zzh(Status status, @Nullable zzia zziaVar) {
        TaskUtil.setResultOrApiException(status, zziaVar, (TaskCompletionSource<zzia>) this.zza);
    }

    @Override // com.google.android.gms.internal.nearby.zzjg
    public final void zzi(Status status, @Nullable zzhy zzhyVar) {
        TaskUtil.setResultOrApiException(status, zzhyVar, (TaskCompletionSource<zzhy>) this.zza);
    }

    @Override // com.google.android.gms.internal.nearby.zzjg
    public final void zzj(Status status) {
        TaskUtil.setResultOrApiException(status, this.zza);
    }

    @Override // com.google.android.gms.internal.nearby.zzjg
    public final void zzk(Status status, @Nullable zzid zzidVar) {
        TaskUtil.setResultOrApiException(status, zzidVar, (TaskCompletionSource<zzid>) this.zza);
    }

    @Override // com.google.android.gms.internal.nearby.zzjg
    public final void zzl(Status status, @Nullable zzhw zzhwVar) {
        TaskUtil.setResultOrApiException(status, zzhwVar, (TaskCompletionSource<zzhw>) this.zza);
    }

    @Override // com.google.android.gms.internal.nearby.zzjg
    public final void zzm(Status status, long j) {
        TaskUtil.setResultOrApiException(status, (Object) null, (TaskCompletionSource<Object>) this.zza);
    }

    @Override // com.google.android.gms.internal.nearby.zzjg
    public final void zzn(Status status) {
        TaskUtil.setResultOrApiException(status, this.zza);
    }

    @Override // com.google.android.gms.internal.nearby.zzjg
    public final void zzo(Status status, @Nullable zzih zzihVar) {
        TaskUtil.setResultOrApiException(status, zzihVar, (TaskCompletionSource<zzih>) this.zza);
    }

    @Override // com.google.android.gms.internal.nearby.zzjg
    public final void zzp(Status status) {
        TaskUtil.setResultOrApiException(status, this.zza);
    }

    @Override // com.google.android.gms.internal.nearby.zzjg
    public final void zzq(Status status, long j) {
        TaskUtil.setResultOrApiException(status, Long.valueOf(j), (TaskCompletionSource<Long>) this.zza);
    }
}
