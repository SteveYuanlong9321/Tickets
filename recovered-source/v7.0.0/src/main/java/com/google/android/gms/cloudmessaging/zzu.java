package com.google.android.gms.cloudmessaging;

import android.os.Bundle;
import com.google.firebase.messaging.Constants;

/* JADX INFO: compiled from: com.google.android.gms:play-services-cloud-messaging@@17.4.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzu extends zzs {
    zzu(int i, int i2, Bundle bundle) {
        super(i, i2, bundle);
    }

    @Override // com.google.android.gms.cloudmessaging.zzs
    final boolean zza() {
        return false;
    }

    @Override // com.google.android.gms.cloudmessaging.zzs
    final void zzb(Bundle bundle) {
        Bundle bundle2 = bundle.getBundle(Constants.ScionAnalytics.MessageType.DATA_MESSAGE);
        if (bundle2 == null) {
            bundle2 = Bundle.EMPTY;
        }
        zzc(bundle2);
    }
}
