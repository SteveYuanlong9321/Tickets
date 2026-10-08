package com.google.android.gms.nearby.messages;

import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class SubscribeOptions {
    public static final SubscribeOptions DEFAULT = new Builder().build();
    public final boolean zza = false;
    public final int zzb = 0;
    private final Strategy zzc;
    private final MessageFilter zzd;
    private final SubscribeCallback zze;

    /* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
    public static class Builder {
        private Strategy zza = Strategy.DEFAULT;
        private MessageFilter zzb = MessageFilter.INCLUDE_ALL_MY_TYPES;
        private SubscribeCallback zzc;

        public SubscribeOptions build() {
            return new SubscribeOptions(this.zza, this.zzb, this.zzc, false, 0, null);
        }

        public Builder setCallback(SubscribeCallback subscribeCallback) {
            this.zzc = (SubscribeCallback) Preconditions.checkNotNull(subscribeCallback);
            return this;
        }

        public Builder setFilter(MessageFilter messageFilter) {
            this.zzb = messageFilter;
            return this;
        }

        public Builder setStrategy(Strategy strategy) {
            this.zza = strategy;
            return this;
        }
    }

    /* synthetic */ SubscribeOptions(Strategy strategy, MessageFilter messageFilter, SubscribeCallback subscribeCallback, boolean z, int i, byte[] bArr) {
        this.zzc = strategy;
        this.zzd = messageFilter;
        this.zze = subscribeCallback;
    }

    public SubscribeCallback getCallback() {
        return this.zze;
    }

    public MessageFilter getFilter() {
        return this.zzd;
    }

    public Strategy getStrategy() {
        return this.zzc;
    }

    public String toString() {
        MessageFilter messageFilter = this.zzd;
        String strValueOf = String.valueOf(this.zzc);
        String strValueOf2 = String.valueOf(messageFilter);
        StringBuilder sb = new StringBuilder(String.valueOf(strValueOf).length() + 35 + String.valueOf(strValueOf2).length() + 1);
        sb.append("SubscribeOptions{strategy=");
        sb.append(strValueOf);
        sb.append(", filter=");
        sb.append(strValueOf2);
        sb.append("}");
        return sb.toString();
    }
}
