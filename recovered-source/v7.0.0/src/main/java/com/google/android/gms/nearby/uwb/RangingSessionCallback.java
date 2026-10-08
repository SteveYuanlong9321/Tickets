package com.google.android.gms.nearby.uwb;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public interface RangingSessionCallback {

    /* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
    public @interface PeerDisconnectedReason {
        public static final int SYSTEM_POLICY = 1;
        public static final int UNKNOWN = 0;
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
    public @interface RangingSuspendedReason {
        public static final int FAILED_TO_START = 2;
        public static final int MAX_RANGING_ROUND_RETRY_REACHED = 5;
        public static final int STOPPED_BY_PEER = 3;
        public static final int STOP_RANGING_CALLED = 4;
        public static final int SYSTEM_POLICY = 6;
        public static final int UNKNOWN = 0;
        public static final int WRONG_PARAMETERS = 1;
    }

    void onRangingInitialized(UwbDevice uwbDevice);

    void onRangingResult(UwbDevice uwbDevice, RangingPosition rangingPosition);

    void onRangingSuspended(UwbDevice uwbDevice, int i);
}
