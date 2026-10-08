package com.google.android.gms.internal.nearby;

import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzaem implements Appendable {
    int zza = 2;
    final /* synthetic */ Appendable zzb;
    final /* synthetic */ String zzc;

    zzaem(int i, Appendable appendable, String str) {
        this.zzb = appendable;
        this.zzc = str;
    }

    @Override // java.lang.Appendable
    public final Appendable append(char c) throws IOException {
        if (this.zza == 0) {
            this.zzb.append(this.zzc);
            this.zza = 2;
        }
        this.zzb.append(c);
        this.zza--;
        return this;
    }

    @Override // java.lang.Appendable
    public final Appendable append(CharSequence charSequence) {
        throw new UnsupportedOperationException();
    }

    @Override // java.lang.Appendable
    public final Appendable append(CharSequence charSequence, int i, int i2) {
        throw new UnsupportedOperationException();
    }
}
