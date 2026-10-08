package com.google.android.gms.nearby.uwb;

import android.content.Context;
import com.google.android.gms.internal.nearby.zzjt;
import com.google.android.gms.internal.nearby.zzvz;
import com.google.android.gms.internal.nearby.zzwe;
import com.google.android.gms.internal.nearby.zzwf;
import com.google.android.gms.internal.nearby.zzwg;
import com.google.android.gms.internal.nearby.zzwi;
import java.util.Objects;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class ArOdometryProvider {
    private final Executor zza;
    private final zzvz zzb;

    /* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
    public static final class Builder {
        private final Context zza;
        private Executor zzb;

        public Builder(Context context) {
            this.zza = context;
        }

        public ArOdometryProvider build() throws zzwe, zzwf, zzwg, zzwi {
            return new ArOdometryProvider(this, null);
        }

        public Builder setGlContextThreadExecutor(Executor executor) {
            this.zzb = executor;
            return this;
        }

        final /* synthetic */ Context zza() {
            return this.zza;
        }

        final /* synthetic */ Executor zzb() {
            return this.zzb;
        }
    }

    /* synthetic */ ArOdometryProvider(Builder builder, byte[] bArr) {
        this.zza = builder.zzb();
        this.zzb = zzjt.zza(builder.zza());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ArOdometryProvider) {
            ArOdometryProvider arOdometryProvider = (ArOdometryProvider) obj;
            if (Objects.equals(this.zza, arOdometryProvider.zza) && Objects.equals(this.zzb, arOdometryProvider.zzb)) {
                return true;
            }
        }
        return false;
    }

    public Executor getGlContextThreadExecutor() {
        return this.zza;
    }

    public zzvz getSession() {
        return this.zzb;
    }

    public int hashCode() {
        return Objects.hash(this.zza, this.zzb);
    }
}
