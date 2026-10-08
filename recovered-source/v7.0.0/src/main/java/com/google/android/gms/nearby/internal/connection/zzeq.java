package com.google.android.gms.nearby.internal.connection;

import android.app.Activity;
import android.app.BroadcastOptions;
import android.content.Context;
import android.content.Intent;
import android.nfc.NfcAdapter;
import android.nfc.Tag;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import androidx.core.content.ContextCompat;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: com.google.android.gms:play-services-nearby@@19.4.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzeq {
    private static final WeakHashMap zza = new WeakHashMap();
    private final Context zzb;
    private final WeakReference zzc;
    private final NfcAdapter zzd;
    private boolean zze = true;
    private boolean zzf;
    private boolean zzg;

    private zzeq(Activity activity) {
        Context applicationContext = activity.getApplicationContext();
        this.zzb = applicationContext;
        WeakReference weakReference = new WeakReference(activity);
        this.zzc = weakReference;
        this.zzd = NfcAdapter.getDefaultAdapter(applicationContext);
        activity.getApplication().registerActivityLifecycleCallbacks(new zzeo(this, weakReference));
        Log.d("NearbyConnections", "NfcDispatcher created.");
    }

    public static synchronized zzeq zza(Activity activity) {
        WeakHashMap weakHashMap;
        weakHashMap = zza;
        if (!weakHashMap.containsKey(activity)) {
            weakHashMap.put(activity, new zzeq(activity));
        }
        return (zzeq) weakHashMap.get(activity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzg, reason: merged with bridge method [inline-methods] */
    public final void zze() {
        NfcAdapter nfcAdapter;
        Log.d("NearbyConnections", "Invalidating dispatch state.");
        if (!this.zze || !this.zzf) {
            Log.d("NearbyConnections", "Stopping NFC dispatching.");
            if (!this.zzg) {
                Log.d("NearbyConnections", "Can't stop NFC dispatching. Not dispatching.");
                return;
            }
            Activity activity = (Activity) this.zzc.get();
            if (activity != null) {
                this.zzd.disableReaderMode(activity);
            }
            this.zzg = false;
            Log.d("NearbyConnections", "No longer dispatching NFC events");
            return;
        }
        Log.d("NearbyConnections", "Starting NFC dispatching.");
        if (this.zzg) {
            Log.d("NearbyConnections", "Can't start NFC dispatching. Already dispatching.");
            return;
        }
        Context context = this.zzb;
        if (!context.getPackageManager().hasSystemFeature("android.hardware.nfc") || ContextCompat.checkSelfPermission(context, "android.permission.NFC") != 0 || (nfcAdapter = this.zzd) == null || !nfcAdapter.isEnabled()) {
            Log.d("NearbyConnections", "Cannot dispatch NFC events. NFC is not supported.");
            return;
        }
        Activity activity2 = (Activity) this.zzc.get();
        if (activity2 == null) {
            Log.d("NearbyConnections", "Cannot dispatch NFC events. Activity is gone.");
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("presence", 100);
        nfcAdapter.enableReaderMode(activity2, new NfcAdapter.ReaderCallback() { // from class: com.google.android.gms.nearby.internal.connection.zzep
            @Override // android.nfc.NfcAdapter.ReaderCallback
            public final /* synthetic */ void onTagDiscovered(Tag tag) {
                this.zza.zzd(tag);
            }
        }, 385, bundle);
        this.zzg = true;
        Log.d("NearbyConnections", "Dispatching NFC events");
    }

    public final void zzb() {
        this.zzf = true;
        Log.d("NearbyConnections", "NFC discovery started.");
        zze();
    }

    public final void zzc() {
        this.zzf = false;
        Log.d("NearbyConnections", "NFC discovery stopped.");
        zze();
    }

    final /* synthetic */ void zzd(Tag tag) {
        Intent intent = new Intent("android.nfc.action.TAG_DISCOVERED");
        intent.setPackage("com.google.android.gms");
        intent.putExtra("android.nfc.extra.TAG", tag);
        int i = Build.VERSION.SDK_INT;
        Context context = this.zzb;
        if (i < 34) {
            context.sendBroadcast(intent);
        } else {
            context.sendBroadcast(intent, null, BroadcastOptions.makeBasic().setShareIdentityEnabled(true).toBundle());
        }
        Log.d("NearbyConnections", "Dispatching discovered NFC tag");
    }

    final /* synthetic */ void zzf(boolean z) {
        this.zze = z;
    }
}
