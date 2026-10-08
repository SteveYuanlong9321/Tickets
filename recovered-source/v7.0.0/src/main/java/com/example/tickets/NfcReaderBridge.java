package com.example.tickets;

import android.app.Activity;
import android.nfc.NfcAdapter;
import android.nfc.Tag;
import android.nfc.tech.IsoDep;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: TicketsShareScreens.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J*\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0018\u0010\f\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\t0\rJ\u0010\u0010\u000e\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/example/tickets/NfcReaderBridge;", "", "<init>", "()V", "AID", "", "SELECT_APDU", "", "enable", "", "activity", "Landroid/app/Activity;", "onPayload", "Lkotlin/Function2;", "disable", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
final class NfcReaderBridge {
    private static final String AID = "F0010203040506";
    public static final NfcReaderBridge INSTANCE = new NfcReaderBridge();
    private static final byte[] SELECT_APDU = {0, -92, 4, 0, 7, -16, 1, 2, 3, 4, 5, 6, 0};

    private NfcReaderBridge() {
    }

    public final void enable(final Activity activity, final Function2<? super String, ? super String, Unit> onPayload) {
        NfcAdapter defaultAdapter;
        Intrinsics.checkNotNullParameter(onPayload, "onPayload");
        if (activity == null || (defaultAdapter = NfcAdapter.getDefaultAdapter(activity)) == null) {
            return;
        }
        defaultAdapter.enableReaderMode(activity, new NfcAdapter.ReaderCallback() { // from class: com.example.tickets.NfcReaderBridge$$ExternalSyntheticLambda1
            @Override // android.nfc.NfcAdapter.ReaderCallback
            public final void onTagDiscovered(Tag tag) {
                NfcReaderBridge.enable$lambda$2(activity, onPayload, tag);
            }
        }, 129, null);
    }

    static final void enable$lambda$2(Activity activity, final Function2 function2, Tag tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        IsoDep isoDep = IsoDep.get(tag);
        if (isoDep == null) {
            return;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            isoDep.connect();
            byte[] bArrTransceive = isoDep.transceive(SELECT_APDU);
            isoDep.close();
            if (bArrTransceive.length >= 2) {
                Intrinsics.checkNotNull(bArrTransceive);
                byte[] bArrCopyOf = Arrays.copyOf(bArrTransceive, bArrTransceive.length - 2);
                Intrinsics.checkNotNullExpressionValue(bArrCopyOf, "copyOf(...)");
                String str = new String(bArrCopyOf, Charsets.UTF_8);
                if (StringsKt.startsWith$default(str, "TICKETS_NFC_V1|", false, 2, (Object) null)) {
                    final List listSplit$default = StringsKt.split$default((CharSequence) StringsKt.removePrefix(str, (CharSequence) "TICKETS_NFC_V1|"), new String[]{"|"}, false, 2, 2, (Object) null);
                    if (listSplit$default.size() == 2 && !StringsKt.isBlank((CharSequence) listSplit$default.get(0)) && !StringsKt.isBlank((CharSequence) listSplit$default.get(1))) {
                        activity.runOnUiThread(new Runnable() { // from class: com.example.tickets.NfcReaderBridge$$ExternalSyntheticLambda0
                            @Override // java.lang.Runnable
                            public final void run() {
                                Function2 function3 = function2;
                                List list = listSplit$default;
                                function3.invoke(list.get(0), list.get(1));
                            }
                        });
                    }
                }
            }
            Result.m9536constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m9536constructorimpl(ResultKt.createFailure(th));
        }
    }

    public final void disable(Activity activity) {
        NfcAdapter defaultAdapter;
        if (activity == null || (defaultAdapter = NfcAdapter.getDefaultAdapter(activity)) == null) {
            return;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            NfcReaderBridge nfcReaderBridge = this;
            defaultAdapter.disableReaderMode(activity);
            Result.m9536constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m9536constructorimpl(ResultKt.createFailure(th));
        }
    }
}
