package com.example.tickets;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.nfc.NdefMessage;
import android.os.Bundle;
import android.os.Parcelable;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TicketNfcNdefReceiverActivity.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0014J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0014J\u0012\u0010\u000b\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0002¨\u0006\f"}, d2 = {"Lcom/example/tickets/TicketNfcNdefReceiverActivity;", "Landroid/app/Activity;", "<init>", "()V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onNewIntent", AccessibilityNodeInfoCompat.MathInfoCompat.MATH_ATTRIBUTE_INTENT, "Landroid/content/Intent;", "handleIntent", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class TicketNfcNdefReceiverActivity extends Activity {
    public static final int $stable = 8;

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        handleIntent(getIntent());
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        super.onNewIntent(intent);
        handleIntent(intent);
    }

    private final void handleIntent(Intent intent) {
        Parcelable parcelable;
        NdefMessage ndefMessage = null;
        Parcelable[] parcelableArrayExtra = intent != null ? intent.getParcelableArrayExtra("android.nfc.extra.NDEF_MESSAGES") : null;
        if (parcelableArrayExtra != null && (parcelable = (Parcelable) ArraysKt.firstOrNull(parcelableArrayExtra)) != null && (parcelable instanceof NdefMessage)) {
            ndefMessage = (NdefMessage) parcelable;
        }
        Pair<String, String> legacyNdef = TicketNfcCompatibility.INSTANCE.parseLegacyNdef(ndefMessage);
        if (legacyNdef != null) {
            TicketShareManager ticketShareManager = TicketShareManager.INSTANCE;
            Context applicationContext = getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
            ticketShareManager.startReceiver(applicationContext, TicketShareManager.Transport.NFC, legacyNdef.getFirst(), legacyNdef.getSecond());
        }
        finish();
    }
}
