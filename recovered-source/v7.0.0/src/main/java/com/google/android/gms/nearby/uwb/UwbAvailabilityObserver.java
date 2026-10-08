package com.google.android.gms.nearby.uwb;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public interface UwbAvailabilityObserver {

    /* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
    public @interface UwbStateChangeReason {
        public static final int REASON_COUNTRY_CODE_ERROR = 2;
        public static final int REASON_SYSTEM_POLICY = 1;
        public static final int REASON_UNKNOWN = 0;
    }

    void onUwbStateChanged(boolean z, int i);
}
