package com.google.android.gms.nearby.messages;

import com.google.android.gms.nearby.messages.internal.zze;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public interface Distance extends Comparable<Distance> {
    public static final Distance UNKNOWN = new zze(1, Double.NaN);

    /* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface Accuracy {
        public static final int LOW = 1;
    }

    @Override // java.lang.Comparable
    int compareTo(Distance distance);

    int getAccuracy();

    double getMeters();
}
