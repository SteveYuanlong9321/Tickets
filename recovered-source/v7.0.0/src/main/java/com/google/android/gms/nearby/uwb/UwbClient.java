package com.google.android.gms.nearby.uwb;

import com.google.android.gms.common.api.HasApiKey;
import com.google.android.gms.tasks.Task;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public interface UwbClient extends HasApiKey<zzc> {
    Task<Void> addControlee(UwbAddress uwbAddress);

    Task<Void> addControleeWithSessionParams(RangingControleeParameters rangingControleeParameters);

    Task<UwbComplexChannel> getComplexChannel();

    Task<UwbAddress> getLocalAddress();

    Task<RangingCapabilities> getRangingCapabilities();

    Task<Boolean> isAvailable();

    Task<Void> reconfigureRangeDataNtf(int i, int i2, int i3);

    Task<Void> reconfigureRangingInterval(int i);

    Task<Void> removeControlee(UwbAddress uwbAddress);

    Task<Void> startRanging(RangingParameters rangingParameters, RangingSessionCallback rangingSessionCallback);

    Task<Void> stopRanging(RangingSessionCallback rangingSessionCallback);

    Task<Void> subscribeToUwbAvailability(UwbAvailabilityObserver uwbAvailabilityObserver);

    Task<Void> unsubscribeFromUwbAvailability();
}
