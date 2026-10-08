package com.example.tickets;

import android.nfc.cardemulation.HostApduService;
import android.os.Bundle;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TicketsNfcHostApduService.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0007\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\u000e"}, d2 = {"Lcom/example/tickets/TicketsNfcHostApduService;", "Landroid/nfc/cardemulation/HostApduService;", "<init>", "()V", "processCommandApdu", "", "commandApdu", "extras", "Landroid/os/Bundle;", "onDeactivated", "", "reason", "", "Companion", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class TicketsNfcHostApduService extends HostApduService {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;
    private static final byte[] SELECT_AID_APDU = {0, -92, 4, 0, 7, -16, 1, 2, 3, 4, 5, 6, 0};
    private static final byte[] SUCCESS = {-112, 0};
    private static final byte[] NOT_FOUND = {106, -126};

    @Override // android.nfc.cardemulation.HostApduService
    public void onDeactivated(int reason) {
    }

    /* JADX INFO: compiled from: TicketsNfcHostApduService.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/example/tickets/TicketsNfcHostApduService$Companion;", "", "<init>", "()V", "SELECT_AID_APDU", "", "SUCCESS", "NOT_FOUND", "isSelectAid", "", "commandApdu", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean isSelectAid(byte[] commandApdu) {
            if (commandApdu.length < TicketsNfcHostApduService.SELECT_AID_APDU.length) {
                return false;
            }
            byte[] bArrCopyOf = Arrays.copyOf(commandApdu, TicketsNfcHostApduService.SELECT_AID_APDU.length);
            Intrinsics.checkNotNullExpressionValue(bArrCopyOf, "copyOf(...)");
            return Arrays.equals(bArrCopyOf, TicketsNfcHostApduService.SELECT_AID_APDU);
        }
    }

    @Override // android.nfc.cardemulation.HostApduService
    public byte[] processCommandApdu(byte[] commandApdu, Bundle extras) {
        Intrinsics.checkNotNullParameter(commandApdu, "commandApdu");
        if (!INSTANCE.isSelectAid(commandApdu)) {
            return NOT_FOUND;
        }
        byte[] bArrNfcApduPayload = TicketShareManager.INSTANCE.nfcApduPayload();
        if (bArrNfcApduPayload == null) {
            return NOT_FOUND;
        }
        return ArraysKt.plus(bArrNfcApduPayload, SUCCESS);
    }
}
