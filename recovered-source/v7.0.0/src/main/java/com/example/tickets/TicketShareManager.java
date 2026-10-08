package com.example.tickets;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.Base64;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import com.google.android.gms.nearby.Nearby;
import com.google.android.gms.nearby.connection.AdvertisingOptions;
import com.google.android.gms.nearby.connection.ConnectionsClient;
import com.google.android.gms.nearby.connection.DiscoveryOptions;
import com.google.android.gms.nearby.connection.Payload;
import com.google.android.gms.nearby.connection.PayloadCallback;
import com.google.android.gms.nearby.connection.PayloadTransferUpdate;
import com.google.android.gms.nearby.connection.Strategy;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.Constants;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: TicketShareManager.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000¯\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u001c\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t*\u0003cfi\bÁ\u0002\u0018\u00002\u00020\u0001:\u0005z{|}~B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u00108\u001a\u00020\"2\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u0010;\u001a\u00020<2\u0006\u0010\u0010\u001a\u00020\u0011J\u0016\u0010=\u001a\u00020>2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010?\u001a\u00020<J\u000e\u0010@\u001a\u00020\"2\u0006\u0010\u0010\u001a\u00020\u0011J\u0006\u0010A\u001a\u00020\u0005J\u001c\u0010B\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010C2\u0006\u0010D\u001a\u00020\u0005J\b\u0010E\u001a\u0004\u0018\u00010FJ\u0006\u0010G\u001a\u00020>J\u001e\u0010H\u001a\u00020>2\u0006\u0010I\u001a\u00020\u00112\u0006\u0010J\u001a\u00020\u001e2\u0006\u0010K\u001a\u00020\u0019J$\u0010H\u001a\u00020>2\u0006\u0010I\u001a\u00020\u00112\f\u0010L\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d2\u0006\u0010K\u001a\u00020\u0019J\u000e\u0010M\u001a\u00020>2\u0006\u0010I\u001a\u00020\u0011J\u000e\u0010N\u001a\u00020>2\u0006\u0010I\u001a\u00020\u0011J&\u0010O\u001a\u00020>2\u0006\u0010I\u001a\u00020\u00112\u0006\u0010K\u001a\u00020\u00192\u0006\u0010P\u001a\u00020\u00052\u0006\u0010Q\u001a\u00020\u0005J\u0006\u0010R\u001a\u00020>J\u0006\u0010S\u001a\u00020>J\u0006\u0010T\u001a\u00020>J\u0006\u0010U\u001a\u00020>J\u0006\u0010V\u001a\u00020>J\u001c\u0010W\u001a\u00020>2\n\b\u0002\u0010I\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010X\u001a\u00020\"J\u0010\u0010Y\u001a\u00020>2\u0006\u0010I\u001a\u00020\u0011H\u0002J\u0010\u0010Z\u001a\u00020>2\u0006\u0010I\u001a\u00020\u0011H\u0002J\b\u0010[\u001a\u00020>H\u0003J\b\u0010\\\u001a\u00020>H\u0002J\b\u0010]\u001a\u00020>H\u0002J\u0010\u0010^\u001a\u00020>2\u0006\u0010I\u001a\u00020\u0011H\u0002J\u0010\u0010_\u001a\u00020>2\u0006\u0010I\u001a\u00020\u0011H\u0002J\u0010\u0010`\u001a\u00020>2\u0006\u0010I\u001a\u00020\u0011H\u0002J\u0010\u0010a\u001a\u00020>2\u0006\u0010I\u001a\u00020\u0011H\u0002J\u0018\u0010k\u001a\u00020>2\u0006\u0010l\u001a\u00020\u00052\u0006\u0010m\u001a\u00020\u0005H\u0002J\u0010\u0010n\u001a\u00020>2\u0006\u0010I\u001a\u00020\u0011H\u0002J\u0010\u0010o\u001a\u00020>2\u0006\u0010I\u001a\u00020\u0011H\u0003J \u0010p\u001a\u00020>2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010l\u001a\u00020\u00052\u0006\u0010m\u001a\u00020\u0005H\u0002J\u0018\u0010q\u001a\u00020>2\u0006\u0010r\u001a\u00020s2\u0006\u0010m\u001a\u00020\u0005H\u0002J\u0018\u0010t\u001a\u00020>2\u0006\u0010r\u001a\u00020s2\u0006\u0010m\u001a\u00020\u0005H\u0002J\u0010\u0010u\u001a\u00020v2\u0006\u0010w\u001a\u00020\u001eH\u0002J\u0010\u0010x\u001a\u00020\u001e2\u0006\u0010y\u001a\u00020vH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010(X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u0004\u0018\u00010*X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010,\u001a\b\u0012\u0004\u0012\u00020.0-X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010/\u001a\u00020.8F¢\u0006\u0006\u001a\u0004\b0\u00101R\u0017\u00102\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d8F¢\u0006\u0006\u001a\u0004\b3\u00104R\u0013\u00105\u001a\u0004\u0018\u00010\u001e8F¢\u0006\u0006\u001a\u0004\b6\u00107R\u000e\u00109\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010b\u001a\u00020cX\u0082\u0004¢\u0006\u0004\n\u0002\u0010dR\u0010\u0010e\u001a\u00020fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010gR\u0010\u0010h\u001a\u00020iX\u0082\u0004¢\u0006\u0004\n\u0002\u0010j¨\u0006\u007f"}, d2 = {"Lcom/example/tickets/TicketShareManager;", "", "<init>", "()V", "SERVICE_ID", "", "ENDPOINT_PREFIX", "SCANNED_PREFIX", "TICKETS_PREFIX", "ACCEPT_PREFIX", "REJECT_PREFIX", "APDU_SESSION_PREFIX", "NFC_COMPAT_ENDPOINT_PREFIX", "NFC_COMPAT_HELLO_PREFIX", "mainHandler", "Landroid/os/Handler;", "context", "Landroid/content/Context;", "advertisingGeneration", "", "listenerInstalled", "Ljava/util/concurrent/atomic/AtomicBoolean;", "role", "Lcom/example/tickets/TicketShareManager$Role;", NotificationCompat.CATEGORY_TRANSPORT, "Lcom/example/tickets/TicketShareManager$Transport;", "sessionId", "sessionToken", "tickets", "", "Lcom/example/tickets/TicketData;", "connectedEndpointId", "incomingTickets", "nfcCompatibilityMode", "", "nfcContactDetected", "wifiDirectTransport", "Lcom/example/tickets/TicketWifiDirectTransport;", "wifiFallbackStarted", "bluetoothTransport", "Lcom/example/tickets/TicketBluetoothTransport;", "bluetoothDiscoveryReceiver", "Landroid/content/BroadcastReceiver;", "bluetoothDiscoveryStarted", "stateStore", "Landroidx/compose/runtime/MutableState;", "Lcom/example/tickets/TicketShareManager$UiState;", "uiState", "getUiState", "()Lcom/example/tickets/TicketShareManager$UiState;", "pendingIncomingTickets", "getPendingIncomingTickets", "()Ljava/util/List;", "pendingIncomingTicket", "getPendingIncomingTicket", "()Lcom/example/tickets/TicketData;", "isNfcShareSupported", "PREFS_NAME", "PREF_CHANNEL", "getDataChannel", "Lcom/example/tickets/TicketShareManager$DataChannel;", "setDataChannel", "", "channel", "usesHceHandshake", "buildQrPayload", "parseQrPayload", "Lkotlin/Pair;", "value", "nfcApduPayload", "", "markNfcContactDetected", "startSender", "appContext", "shareTicket", "shareTransport", "shareTickets", "activateLegacyNfcFallback", "startNfcCompatibilityReceiver", "startReceiver", "incomingSessionId", "incomingToken", "confirmSenderShare", "rejectSenderShare", "acceptIncoming", "rejectIncoming", "clearIncomingTicket", "stop", "preserveUi", "startSelectedSenderTransport", "startSelectedReceiverTransport", "stopAllBluetooth", "startAdvertising", "startDiscovery", "scheduleWifiFallbackServer", "scheduleWifiFallbackClient", "startWifiDirectFallbackServer", "startWifiDirectFallbackClient", "endpointDiscoveryCallback", "com/example/tickets/TicketShareManager$endpointDiscoveryCallback$1", "Lcom/example/tickets/TicketShareManager$endpointDiscoveryCallback$1;", "connectionLifecycleCallback", "com/example/tickets/TicketShareManager$connectionLifecycleCallback$1", "Lcom/example/tickets/TicketShareManager$connectionLifecycleCallback$1;", "payloadCallback", "com/example/tickets/TicketShareManager$payloadCallback$1", "Lcom/example/tickets/TicketShareManager$payloadCallback$1;", "handleMessage", "endpointId", "message", "startBluetoothServer", "startBluetoothClient", "sendBytes", "updateState", "state", "Lcom/example/tickets/TicketShareManager$State;", "postState", "ticketToJson", "Lorg/json/JSONObject;", "ticket", "ticketFromJson", "o", "Transport", "DataChannel", "Role", "State", "UiState", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class TicketShareManager {
    private static final String ACCEPT_PREFIX = "ACCEPT|";
    private static final String APDU_SESSION_PREFIX = "TICKETS_NFC_V1|";
    private static final String ENDPOINT_PREFIX = "TICKETS_SHARE_V1|";
    private static final String NFC_COMPAT_ENDPOINT_PREFIX = "TICKETS_NFC_COMPAT_V1|";
    private static final String NFC_COMPAT_HELLO_PREFIX = "NFC_COMPAT_HELLO|";
    private static final String PREFS_NAME = "tickets_transfer_preferences";
    private static final String PREF_CHANNEL = "data_channel";
    private static final String REJECT_PREFIX = "REJECT|";
    private static final String SCANNED_PREFIX = "SCANNED|";
    private static final String SERVICE_ID = "com.example.tickets.share.v1";
    private static final String TICKETS_PREFIX = "TICKETS|";
    private static long advertisingGeneration;
    private static BroadcastReceiver bluetoothDiscoveryReceiver;
    private static boolean bluetoothDiscoveryStarted;
    private static TicketBluetoothTransport bluetoothTransport;
    private static String connectedEndpointId;
    private static Context context;
    private static boolean nfcCompatibilityMode;
    private static boolean nfcContactDetected;
    private static Role role;
    private static Transport transport;
    private static TicketWifiDirectTransport wifiDirectTransport;
    private static boolean wifiFallbackStarted;
    public static final TicketShareManager INSTANCE = new TicketShareManager();
    private static final Handler mainHandler = new Handler(Looper.getMainLooper());
    private static AtomicBoolean listenerInstalled = new AtomicBoolean(false);
    private static String sessionId = "";
    private static String sessionToken = "";
    private static List<TicketData> tickets = CollectionsKt.emptyList();
    private static List<TicketData> incomingTickets = CollectionsKt.emptyList();
    private static final MutableState<UiState> stateStore = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new UiState(null, null, null, null, null, null, null, false, 255, null), null, 2, null);
    private static final TicketShareManager$endpointDiscoveryCallback$1 endpointDiscoveryCallback = new TicketShareManager$endpointDiscoveryCallback$1();
    private static final TicketShareManager$connectionLifecycleCallback$1 connectionLifecycleCallback = new TicketShareManager$connectionLifecycleCallback$1();
    private static final TicketShareManager$payloadCallback$1 payloadCallback = new PayloadCallback() { // from class: com.example.tickets.TicketShareManager$payloadCallback$1
        @Override // com.google.android.gms.nearby.connection.PayloadCallback
        public void onPayloadTransferUpdate(String endpointId, PayloadTransferUpdate update) {
            Intrinsics.checkNotNullParameter(endpointId, "endpointId");
            Intrinsics.checkNotNullParameter(update, "update");
        }

        @Override // com.google.android.gms.nearby.connection.PayloadCallback
        public void onPayloadReceived(String endpointId, Payload payload) {
            Object objM9536constructorimpl;
            Intrinsics.checkNotNullParameter(endpointId, "endpointId");
            Intrinsics.checkNotNullParameter(payload, "payload");
            byte[] bArrAsBytes = payload.asBytes();
            if (bArrAsBytes == null) {
                return;
            }
            try {
                Result.Companion companion = Result.INSTANCE;
                TicketShareManager$payloadCallback$1 ticketShareManager$payloadCallback$1 = this;
                Charset UTF_8 = StandardCharsets.UTF_8;
                Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
                objM9536constructorimpl = Result.m9536constructorimpl(new String(bArrAsBytes, UTF_8));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objM9536constructorimpl = Result.m9536constructorimpl(ResultKt.createFailure(th));
            }
            if (Result.m9542isFailureimpl(objM9536constructorimpl)) {
                objM9536constructorimpl = "";
            }
            String strDecryptEnvelope = TicketTransferCrypto.INSTANCE.decryptEnvelope((String) objM9536constructorimpl);
            if (strDecryptEnvelope == null) {
                return;
            }
            TicketShareManager.INSTANCE.handleMessage(endpointId, strDecryptEnvelope);
        }
    };
    public static final int $stable = 8;

    /* JADX INFO: compiled from: TicketShareManager.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/example/tickets/TicketShareManager$DataChannel;", "", "<init>", "(Ljava/lang/String;I)V", "NEARBY", "WIFI_DIRECT", "BLUETOOTH", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public enum DataChannel {
        NEARBY,
        WIFI_DIRECT,
        BLUETOOTH;

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

        public static EnumEntries<DataChannel> getEntries() {
            return $ENTRIES;
        }
    }

    /* JADX INFO: compiled from: TicketShareManager.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/example/tickets/TicketShareManager$Role;", "", "<init>", "(Ljava/lang/String;I)V", "SENDER", "RECEIVER", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public enum Role {
        SENDER,
        RECEIVER;

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

        public static EnumEntries<Role> getEntries() {
            return $ENTRIES;
        }
    }

    /* JADX INFO: compiled from: TicketShareManager.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\r\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/example/tickets/TicketShareManager$State;", "", "<init>", "(Ljava/lang/String;I)V", "IDLE", "STARTING", "WAITING_FOR_PEER", "CONNECTING", "SCANNED", "WAITING_SENDER_CONFIRM", "WAITING_RECEIVER_CONFIRM", "SUCCESS", "REJECTED", "ERROR", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public enum State {
        IDLE,
        STARTING,
        WAITING_FOR_PEER,
        CONNECTING,
        SCANNED,
        WAITING_SENDER_CONFIRM,
        WAITING_RECEIVER_CONFIRM,
        SUCCESS,
        REJECTED,
        ERROR;

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

        public static EnumEntries<State> getEntries() {
            return $ENTRIES;
        }
    }

    /* JADX INFO: compiled from: TicketShareManager.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/example/tickets/TicketShareManager$Transport;", "", "<init>", "(Ljava/lang/String;I)V", "NFC", "QR", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public enum Transport {
        NFC,
        QR;

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

        public static EnumEntries<Transport> getEntries() {
            return $ENTRIES;
        }
    }

    /* JADX INFO: compiled from: TicketShareManager.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[DataChannel.values().length];
            try {
                iArr[DataChannel.NEARBY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[DataChannel.WIFI_DIRECT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[DataChannel.BLUETOOTH.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private TicketShareManager() {
    }

    /* JADX INFO: compiled from: TicketShareManager.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u001b\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B[\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\t\u0012\b\b\u0002\u0010\f\u001a\u00020\t\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010 \u001a\u00020\u0007HÆ\u0003J\t\u0010!\u001a\u00020\tHÆ\u0003J\t\u0010\"\u001a\u00020\tHÆ\u0003J\t\u0010#\u001a\u00020\tHÆ\u0003J\t\u0010$\u001a\u00020\tHÆ\u0003J\t\u0010%\u001a\u00020\u000eHÆ\u0003J]\u0010&\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\t2\b\b\u0002\u0010\r\u001a\u00020\u000eHÆ\u0001J\u0013\u0010'\u001a\u00020\u000e2\b\u0010(\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010)\u001a\u00020*HÖ\u0001J\t\u0010+\u001a\u00020\tHÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\n\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u0011\u0010\u000b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0018R\u0011\u0010\f\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0018R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001d¨\u0006,"}, d2 = {"Lcom/example/tickets/TicketShareManager$UiState;", "", "role", "Lcom/example/tickets/TicketShareManager$Role;", NotificationCompat.CATEGORY_TRANSPORT, "Lcom/example/tickets/TicketShareManager$Transport;", "state", "Lcom/example/tickets/TicketShareManager$State;", "sessionId", "", "token", "message", "peerName", "nfcContactDetected", "", "<init>", "(Lcom/example/tickets/TicketShareManager$Role;Lcom/example/tickets/TicketShareManager$Transport;Lcom/example/tickets/TicketShareManager$State;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "getRole", "()Lcom/example/tickets/TicketShareManager$Role;", "getTransport", "()Lcom/example/tickets/TicketShareManager$Transport;", "getState", "()Lcom/example/tickets/TicketShareManager$State;", "getSessionId", "()Ljava/lang/String;", "getToken", "getMessage", "getPeerName", "getNfcContactDetected", "()Z", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "hashCode", "", "toString", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class UiState {
        public static final int $stable = 0;
        private final String message;
        private final boolean nfcContactDetected;
        private final String peerName;
        private final Role role;
        private final String sessionId;
        private final State state;
        private final String token;
        private final Transport transport;

        public UiState() {
            this(null, null, null, null, null, null, null, false, 255, null);
        }

        public static /* synthetic */ UiState copy$default(UiState uiState, Role role, Transport transport, State state, String str, String str2, String str3, String str4, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                role = uiState.role;
            }
            if ((i & 2) != 0) {
                transport = uiState.transport;
            }
            if ((i & 4) != 0) {
                state = uiState.state;
            }
            if ((i & 8) != 0) {
                str = uiState.sessionId;
            }
            if ((i & 16) != 0) {
                str2 = uiState.token;
            }
            if ((i & 32) != 0) {
                str3 = uiState.message;
            }
            if ((i & 64) != 0) {
                str4 = uiState.peerName;
            }
            if ((i & 128) != 0) {
                z = uiState.nfcContactDetected;
            }
            String str5 = str4;
            boolean z2 = z;
            String str6 = str2;
            String str7 = str3;
            return uiState.copy(role, transport, state, str, str6, str7, str5, z2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Role getRole() {
            return this.role;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Transport getTransport() {
            return this.transport;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final State getState() {
            return this.state;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getSessionId() {
            return this.sessionId;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final String getToken() {
            return this.token;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final String getMessage() {
            return this.message;
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        public final String getPeerName() {
            return this.peerName;
        }

        /* JADX INFO: renamed from: component8, reason: from getter */
        public final boolean getNfcContactDetected() {
            return this.nfcContactDetected;
        }

        public final UiState copy(Role role, Transport transport, State state, String sessionId, String token, String message, String peerName, boolean nfcContactDetected) {
            Intrinsics.checkNotNullParameter(state, "state");
            Intrinsics.checkNotNullParameter(sessionId, "sessionId");
            Intrinsics.checkNotNullParameter(token, "token");
            Intrinsics.checkNotNullParameter(message, "message");
            Intrinsics.checkNotNullParameter(peerName, "peerName");
            return new UiState(role, transport, state, sessionId, token, message, peerName, nfcContactDetected);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof UiState)) {
                return false;
            }
            UiState uiState = (UiState) other;
            return this.role == uiState.role && this.transport == uiState.transport && this.state == uiState.state && Intrinsics.areEqual(this.sessionId, uiState.sessionId) && Intrinsics.areEqual(this.token, uiState.token) && Intrinsics.areEqual(this.message, uiState.message) && Intrinsics.areEqual(this.peerName, uiState.peerName) && this.nfcContactDetected == uiState.nfcContactDetected;
        }

        public int hashCode() {
            Role role = this.role;
            int iHashCode = (role == null ? 0 : role.hashCode()) * 31;
            Transport transport = this.transport;
            return ((((((((((((iHashCode + (transport != null ? transport.hashCode() : 0)) * 31) + this.state.hashCode()) * 31) + this.sessionId.hashCode()) * 31) + this.token.hashCode()) * 31) + this.message.hashCode()) * 31) + this.peerName.hashCode()) * 31) + Boolean.hashCode(this.nfcContactDetected);
        }

        public String toString() {
            return "UiState(role=" + this.role + ", transport=" + this.transport + ", state=" + this.state + ", sessionId=" + this.sessionId + ", token=" + this.token + ", message=" + this.message + ", peerName=" + this.peerName + ", nfcContactDetected=" + this.nfcContactDetected + ")";
        }

        public UiState(Role role, Transport transport, State state, String sessionId, String token, String message, String peerName, boolean z) {
            Intrinsics.checkNotNullParameter(state, "state");
            Intrinsics.checkNotNullParameter(sessionId, "sessionId");
            Intrinsics.checkNotNullParameter(token, "token");
            Intrinsics.checkNotNullParameter(message, "message");
            Intrinsics.checkNotNullParameter(peerName, "peerName");
            this.role = role;
            this.transport = transport;
            this.state = state;
            this.sessionId = sessionId;
            this.token = token;
            this.message = message;
            this.peerName = peerName;
            this.nfcContactDetected = z;
        }

        public final Role getRole() {
            return this.role;
        }

        public final Transport getTransport() {
            return this.transport;
        }

        public /* synthetic */ UiState(Role role, Transport transport, State state, String str, String str2, String str3, String str4, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : role, (i & 2) != 0 ? null : transport, (i & 4) != 0 ? State.IDLE : state, (i & 8) != 0 ? "" : str, (i & 16) != 0 ? "" : str2, (i & 32) != 0 ? "" : str3, (i & 64) != 0 ? "" : str4, (i & 128) != 0 ? false : z);
        }

        public final State getState() {
            return this.state;
        }

        public final String getSessionId() {
            return this.sessionId;
        }

        public final String getToken() {
            return this.token;
        }

        public final String getMessage() {
            return this.message;
        }

        public final String getPeerName() {
            return this.peerName;
        }

        public final boolean getNfcContactDetected() {
            return this.nfcContactDetected;
        }
    }

    public final UiState getUiState() {
        return stateStore.getValue();
    }

    public final List<TicketData> getPendingIncomingTickets() {
        return incomingTickets;
    }

    public final TicketData getPendingIncomingTicket() {
        return (TicketData) CollectionsKt.firstOrNull((List) incomingTickets);
    }

    public final boolean isNfcShareSupported(Context context2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        return context2.getPackageManager().hasSystemFeature("android.hardware.nfc");
    }

    public final DataChannel getDataChannel(Context context2) {
        Object objM9536constructorimpl;
        Intrinsics.checkNotNullParameter(context2, "context");
        String string = context2.getSharedPreferences(PREFS_NAME, 0).getString(PREF_CHANNEL, "NEARBY");
        if (string == null) {
            string = "";
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            TicketShareManager ticketShareManager = this;
            objM9536constructorimpl = Result.m9536constructorimpl(DataChannel.valueOf(string));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM9536constructorimpl = Result.m9536constructorimpl(ResultKt.createFailure(th));
        }
        DataChannel dataChannel = DataChannel.NEARBY;
        if (Result.m9542isFailureimpl(objM9536constructorimpl)) {
            objM9536constructorimpl = dataChannel;
        }
        return (DataChannel) objM9536constructorimpl;
    }

    public final void setDataChannel(Context context2, DataChannel channel) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(channel, "channel");
        context2.getSharedPreferences(PREFS_NAME, 0).edit().putString(PREF_CHANNEL, channel.name()).apply();
    }

    public final boolean usesHceHandshake(Context context2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        return TicketNfcCompatibility.INSTANCE.preferredMode(context2) == TicketNfcCompatibility.Mode.HCE;
    }

    public final String buildQrPayload() {
        return "TicketsShare:secure:v1:" + TicketTransferCrypto.INSTANCE.encryptToEnvelope(sessionId + "|" + sessionToken);
    }

    public final Pair<String, String> parseQrPayload(String value) {
        String strDecryptEnvelope;
        Intrinsics.checkNotNullParameter(value, "value");
        List listSplit$default = StringsKt.split$default((CharSequence) StringsKt.trim((CharSequence) value).toString(), new String[]{":"}, false, 4, 2, (Object) null);
        if (listSplit$default.size() != 4 || !Intrinsics.areEqual(listSplit$default.get(0), "TicketsShare") || !Intrinsics.areEqual(listSplit$default.get(1), "secure") || !Intrinsics.areEqual(listSplit$default.get(2), "v1") || (strDecryptEnvelope = TicketTransferCrypto.INSTANCE.decryptEnvelope((String) listSplit$default.get(3))) == null) {
            return null;
        }
        List listSplit$default2 = StringsKt.split$default((CharSequence) strDecryptEnvelope, new String[]{"|"}, false, 2, 2, (Object) null);
        if (listSplit$default2.size() == 2 && !StringsKt.isBlank((CharSequence) listSplit$default2.get(0)) && !StringsKt.isBlank((CharSequence) listSplit$default2.get(1))) {
            return TuplesKt.to(listSplit$default2.get(0), listSplit$default2.get(1));
        }
        return null;
    }

    public final byte[] nfcApduPayload() {
        if (role != Role.SENDER || StringsKt.isBlank(sessionId) || StringsKt.isBlank(sessionToken)) {
            return null;
        }
        markNfcContactDetected();
        String strEncryptToEnvelope = TicketTransferCrypto.INSTANCE.encryptToEnvelope(sessionId + "|" + sessionToken);
        StringBuilder sb = new StringBuilder(APDU_SESSION_PREFIX);
        sb.append(strEncryptToEnvelope);
        String string = sb.toString();
        Charset UTF_8 = StandardCharsets.UTF_8;
        Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
        byte[] bytes = string.getBytes(UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        return bytes;
    }

    public final void markNfcContactDetected() {
        if (transport != Transport.NFC) {
            return;
        }
        nfcContactDetected = true;
        updateState(getUiState().getState(), getUiState().getMessage());
    }

    public final void startSender(Context appContext, TicketData shareTicket, Transport shareTransport) {
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        Intrinsics.checkNotNullParameter(shareTicket, "shareTicket");
        Intrinsics.checkNotNullParameter(shareTransport, "shareTransport");
        startSender(appContext, CollectionsKt.listOf(shareTicket), shareTransport);
    }

    public final void startSender(Context appContext, List<TicketData> shareTickets, Transport shareTransport) {
        String str;
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        Intrinsics.checkNotNullParameter(shareTickets, "shareTickets");
        Intrinsics.checkNotNullParameter(shareTransport, "shareTransport");
        ArrayList arrayList = new ArrayList();
        for (Object obj : shareTickets) {
            if (((TicketData) obj).getId() != Integer.MIN_VALUE) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = arrayList;
        if (arrayList2.isEmpty()) {
            return;
        }
        stop(appContext, false);
        context = appContext.getApplicationContext();
        role = Role.SENDER;
        transport = shareTransport;
        String string = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        sessionId = StringsKt.replace$default(string, "-", "", false, 4, (Object) null);
        String string2 = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(string2, "toString(...)");
        sessionToken = StringsKt.replace$default(string2, "-", "", false, 4, (Object) null);
        tickets = arrayList2;
        incomingTickets = CollectionsKt.emptyList();
        connectedEndpointId = null;
        nfcCompatibilityMode = false;
        nfcContactDetected = false;
        State state = State.STARTING;
        if (arrayList2.size() == 1) {
            str = "正在准备分享…";
        } else {
            str = "正在准备分享 " + arrayList2.size() + " 张票据…";
        }
        updateState(state, str);
        startSelectedSenderTransport(appContext);
    }

    public final void activateLegacyNfcFallback(Context appContext) {
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        if (role == Role.SENDER && transport == Transport.NFC) {
            context = appContext.getApplicationContext();
            nfcCompatibilityMode = true;
            startSelectedSenderTransport(appContext);
        }
    }

    public final void startNfcCompatibilityReceiver(Context appContext) {
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        stop(appContext, false);
        context = appContext.getApplicationContext();
        role = Role.RECEIVER;
        transport = Transport.NFC;
        sessionId = "";
        sessionToken = "";
        tickets = CollectionsKt.emptyList();
        incomingTickets = CollectionsKt.emptyList();
        connectedEndpointId = null;
        nfcCompatibilityMode = true;
        updateState(State.STARTING, "正在寻找 NFC 兼容设备…");
        startSelectedReceiverTransport(appContext);
    }

    public final void startReceiver(Context appContext, Transport shareTransport, String incomingSessionId, String incomingToken) {
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        Intrinsics.checkNotNullParameter(shareTransport, "shareTransport");
        Intrinsics.checkNotNullParameter(incomingSessionId, "incomingSessionId");
        Intrinsics.checkNotNullParameter(incomingToken, "incomingToken");
        stop(appContext, false);
        context = appContext.getApplicationContext();
        role = Role.RECEIVER;
        transport = shareTransport;
        nfcCompatibilityMode = false;
        sessionId = incomingSessionId;
        sessionToken = incomingToken;
        tickets = CollectionsKt.emptyList();
        incomingTickets = CollectionsKt.emptyList();
        connectedEndpointId = null;
        nfcContactDetected = shareTransport == Transport.NFC;
        updateState(State.STARTING, "正在寻找发送设备…");
        startSelectedReceiverTransport(appContext);
    }

    public final void confirmSenderShare() {
        String str;
        Context context2;
        String str2;
        if (role != Role.SENDER || getUiState().getState() != State.SCANNED || (str = connectedEndpointId) == null || tickets.isEmpty() || (context2 = context) == null) {
            return;
        }
        JSONArray jSONArray = new JSONArray();
        Iterator<T> it = tickets.iterator();
        while (it.hasNext()) {
            jSONArray.put(INSTANCE.ticketToJson((TicketData) it.next()));
        }
        String string = jSONArray.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        Charset UTF_8 = StandardCharsets.UTF_8;
        Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
        byte[] bytes = string.getBytes(UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        String strEncodeToString = Base64.encodeToString(bytes, 10);
        sendBytes(context2, str, TICKETS_PREFIX + sessionId + "|" + sessionToken + "|" + strEncodeToString);
        State state = State.WAITING_RECEIVER_CONFIRM;
        if (tickets.size() == 1) {
            str2 = "已发送票据，等待对方确认…";
        } else {
            str2 = "已发送 " + tickets.size() + " 张票据，等待对方确认…";
        }
        updateState(state, str2);
    }

    public final void rejectSenderShare() {
        Context context2 = context;
        if (context2 == null) {
            return;
        }
        String str = connectedEndpointId;
        if (str != null) {
            INSTANCE.sendBytes(context2, str, REJECT_PREFIX + sessionId + "|" + sessionToken + "|sender_cancelled");
        }
        updateState(State.REJECTED, "已取消分享");
    }

    public final void acceptIncoming() {
        Context context2;
        String str;
        if (role != Role.RECEIVER || incomingTickets.isEmpty() || (context2 = context) == null || (str = connectedEndpointId) == null) {
            return;
        }
        sendBytes(context2, str, ACCEPT_PREFIX + sessionId + "|" + sessionToken);
        updateState(State.SUCCESS, "票据已接受");
    }

    public final void rejectIncoming() {
        Context context2;
        if (role == Role.RECEIVER && (context2 = context) != null) {
            String str = connectedEndpointId;
            if (str != null) {
                sendBytes(context2, str, REJECT_PREFIX + sessionId + "|" + sessionToken + "|receiver_rejected");
            }
            updateState(State.REJECTED, "已拒绝这张票据");
        }
    }

    public final void clearIncomingTicket() {
        incomingTickets = CollectionsKt.emptyList();
    }

    public static /* synthetic */ void stop$default(TicketShareManager ticketShareManager, Context context2, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            context2 = context;
        }
        if ((i & 2) != 0) {
            z = false;
        }
        ticketShareManager.stop(context2, z);
    }

    public final void stop(Context appContext, boolean preserveUi) {
        Unit unit;
        stopAllBluetooth();
        advertisingGeneration++;
        Context applicationContext = appContext != null ? appContext.getApplicationContext() : null;
        if (applicationContext != null) {
            try {
                Result.Companion companion = Result.INSTANCE;
                TicketShareManager ticketShareManager = this;
                Nearby.getConnectionsClient(applicationContext).stopAdvertising();
                Result.m9536constructorimpl(Unit.INSTANCE);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                Result.m9536constructorimpl(ResultKt.createFailure(th));
            }
            try {
                Result.Companion companion3 = Result.INSTANCE;
                TicketShareManager ticketShareManager2 = this;
                Nearby.getConnectionsClient(applicationContext).stopDiscovery();
                Result.m9536constructorimpl(Unit.INSTANCE);
            } catch (Throwable th2) {
                Result.Companion companion4 = Result.INSTANCE;
                Result.m9536constructorimpl(ResultKt.createFailure(th2));
            }
            try {
                Result.Companion companion5 = Result.INSTANCE;
                TicketShareManager ticketShareManager3 = this;
                Nearby.getConnectionsClient(applicationContext).stopAllEndpoints();
                Result.m9536constructorimpl(Unit.INSTANCE);
            } catch (Throwable th3) {
                Result.Companion companion6 = Result.INSTANCE;
                Result.m9536constructorimpl(ResultKt.createFailure(th3));
            }
        }
        wifiFallbackStarted = false;
        try {
            Result.Companion companion7 = Result.INSTANCE;
            TicketShareManager ticketShareManager4 = this;
            TicketWifiDirectTransport ticketWifiDirectTransport = wifiDirectTransport;
            if (ticketWifiDirectTransport != null) {
                ticketWifiDirectTransport.stop();
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            Result.m9536constructorimpl(unit);
        } catch (Throwable th4) {
            Result.Companion companion8 = Result.INSTANCE;
            Result.m9536constructorimpl(ResultKt.createFailure(th4));
        }
        wifiDirectTransport = null;
        context = null;
        role = null;
        transport = null;
        tickets = CollectionsKt.emptyList();
        incomingTickets = CollectionsKt.emptyList();
        connectedEndpointId = null;
        sessionId = "";
        sessionToken = "";
        nfcCompatibilityMode = false;
        nfcContactDetected = false;
        if (preserveUi) {
            return;
        }
        stateStore.setValue(new UiState(null, null, null, null, null, null, null, false, 255, null));
    }

    private final void startSelectedSenderTransport(Context appContext) {
        int i = WhenMappings.$EnumSwitchMapping$0[getDataChannel(appContext).ordinal()];
        if (i == 1) {
            startAdvertising();
        } else if (i == 2) {
            startWifiDirectFallbackServer(appContext);
        } else {
            if (i != 3) {
                throw new NoWhenBranchMatchedException();
            }
            startBluetoothServer(appContext);
        }
    }

    private final void startSelectedReceiverTransport(Context appContext) {
        int i = WhenMappings.$EnumSwitchMapping$0[getDataChannel(appContext).ordinal()];
        if (i == 1) {
            startDiscovery();
        } else if (i == 2) {
            startWifiDirectFallbackClient(appContext);
        } else {
            if (i != 3) {
                throw new NoWhenBranchMatchedException();
            }
            startBluetoothClient(appContext);
        }
    }

    private final void stopAllBluetooth() {
        Unit unit;
        Unit unit2;
        Context context2;
        bluetoothDiscoveryStarted = false;
        try {
            Result.Companion companion = Result.INSTANCE;
            TicketShareManager ticketShareManager = this;
            BroadcastReceiver broadcastReceiver = bluetoothDiscoveryReceiver;
            if (broadcastReceiver == null || (context2 = context) == null) {
                unit2 = null;
            } else {
                context2.unregisterReceiver(broadcastReceiver);
                unit2 = Unit.INSTANCE;
            }
            Result.m9536constructorimpl(unit2);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m9536constructorimpl(ResultKt.createFailure(th));
        }
        bluetoothDiscoveryReceiver = null;
        try {
            Result.Companion companion3 = Result.INSTANCE;
            TicketShareManager ticketShareManager2 = this;
            BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
            Result.m9536constructorimpl(defaultAdapter != null ? Boolean.valueOf(defaultAdapter.cancelDiscovery()) : null);
        } catch (Throwable th2) {
            Result.Companion companion4 = Result.INSTANCE;
            Result.m9536constructorimpl(ResultKt.createFailure(th2));
        }
        try {
            Result.Companion companion5 = Result.INSTANCE;
            TicketShareManager ticketShareManager3 = this;
            TicketBluetoothTransport ticketBluetoothTransport = bluetoothTransport;
            if (ticketBluetoothTransport != null) {
                ticketBluetoothTransport.stop();
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            Result.m9536constructorimpl(unit);
        } catch (Throwable th3) {
            Result.Companion companion6 = Result.INSTANCE;
            Result.m9536constructorimpl(ResultKt.createFailure(th3));
        }
        bluetoothTransport = null;
    }

    private final void startAdvertising() {
        String str;
        Context context2 = context;
        if (context2 == null) {
            return;
        }
        if (ContextCompat.checkSelfPermission(context2, "android.permission.ACCESS_COARSE_LOCATION") != 0) {
            postState(State.ERROR, "无法广播附近设备：请允许大致位置权限后重试");
            return;
        }
        if (nfcCompatibilityMode) {
            str = NFC_COMPAT_ENDPOINT_PREFIX + sessionId + "|" + sessionToken;
        } else {
            str = ENDPOINT_PREFIX + sessionId + "|" + sessionToken;
        }
        Charset UTF_8 = StandardCharsets.UTF_8;
        Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
        final byte[] bytes = str.getBytes(UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        final AdvertisingOptions advertisingOptionsBuild = new AdvertisingOptions.Builder().setStrategy(Strategy.P2P_POINT_TO_POINT).build();
        Intrinsics.checkNotNullExpressionValue(advertisingOptionsBuild, "build(...)");
        final ConnectionsClient connectionsClient = Nearby.getConnectionsClient(context2);
        Intrinsics.checkNotNullExpressionValue(connectionsClient, "getConnectionsClient(...)");
        final long j = advertisingGeneration + 1;
        advertisingGeneration = j;
        try {
            Result.Companion companion = Result.INSTANCE;
            TicketShareManager ticketShareManager = this;
            connectionsClient.stopAdvertising();
            Result.m9536constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m9536constructorimpl(ResultKt.createFailure(th));
        }
        mainHandler.postDelayed(new Runnable() { // from class: com.example.tickets.TicketShareManager$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                TicketShareManager.startAdvertising$lambda$20(j, connectionsClient, bytes, advertisingOptionsBuild);
            }
        }, 350L);
    }

    static final void startAdvertising$lambda$20(final long j, final ConnectionsClient connectionsClient, byte[] bArr, AdvertisingOptions advertisingOptions) {
        Object objM9536constructorimpl;
        if (j != advertisingGeneration || context == null) {
            return;
        }
        final TicketShareManager ticketShareManager = INSTANCE;
        try {
            Result.Companion companion = Result.INSTANCE;
            Task<Void> taskStartAdvertising = connectionsClient.startAdvertising(bArr, SERVICE_ID, connectionLifecycleCallback, advertisingOptions);
            final Function1 function1 = new Function1() { // from class: com.example.tickets.TicketShareManager$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return TicketShareManager.startAdvertising$lambda$20$lambda$18$lambda$15(j, ticketShareManager, connectionsClient, (Void) obj);
                }
            };
            objM9536constructorimpl = Result.m9536constructorimpl(taskStartAdvertising.addOnSuccessListener(new OnSuccessListener() { // from class: com.example.tickets.TicketShareManager$$ExternalSyntheticLambda6
                @Override // com.google.android.gms.tasks.OnSuccessListener
                public final void onSuccess(Object obj) {
                    function1.invoke(obj);
                }
            }).addOnFailureListener(new OnFailureListener() { // from class: com.example.tickets.TicketShareManager$$ExternalSyntheticLambda7
                @Override // com.google.android.gms.tasks.OnFailureListener
                public final void onFailure(Exception exc) {
                    TicketShareManager.startAdvertising$lambda$20$lambda$18$lambda$17(this.f$0, exc);
                }
            }));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM9536constructorimpl = Result.m9536constructorimpl(ResultKt.createFailure(th));
        }
        Throwable thM9539exceptionOrNullimpl = Result.m9539exceptionOrNullimpl(objM9536constructorimpl);
        if (thM9539exceptionOrNullimpl != null) {
            TicketShareManager ticketShareManager2 = INSTANCE;
            State state = State.ERROR;
            String message = thM9539exceptionOrNullimpl.getMessage();
            if (message == null) {
                message = "未知错误";
            }
            ticketShareManager2.postState(state, "Nearby 广播启动失败：" + message);
        }
    }

    static final Unit startAdvertising$lambda$20$lambda$18$lambda$15(long j, TicketShareManager ticketShareManager, ConnectionsClient connectionsClient, Void r6) {
        String str;
        if (j != advertisingGeneration || context == null) {
            try {
                Result.Companion companion = Result.INSTANCE;
                connectionsClient.stopAdvertising();
                Result.m9536constructorimpl(Unit.INSTANCE);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                Result.m9536constructorimpl(ResultKt.createFailure(th));
            }
            return Unit.INSTANCE;
        }
        State state = State.WAITING_FOR_PEER;
        if (transport == Transport.NFC) {
            str = "请将两部手机靠近 NFC 感应区域";
        } else {
            str = "等待对方扫描二维码…";
        }
        ticketShareManager.postState(state, str);
        return Unit.INSTANCE;
    }

    static final void startAdvertising$lambda$20$lambda$18$lambda$17(TicketShareManager ticketShareManager, Exception it) {
        Intrinsics.checkNotNullParameter(it, "it");
        State state = State.ERROR;
        String message = it.getMessage();
        if (message == null) {
            message = "未知错误";
        }
        ticketShareManager.postState(state, "Nearby 广播启动失败：" + message);
    }

    private final void startDiscovery() {
        Object objM9536constructorimpl;
        Context context2 = context;
        if (context2 == null) {
            return;
        }
        boolean z = ContextCompat.checkSelfPermission(context2, "android.permission.ACCESS_COARSE_LOCATION") == 0;
        ContextCompat.checkSelfPermission(context2, "android.permission.ACCESS_FINE_LOCATION");
        if (!z) {
            postState(State.ERROR, "无法搜索附近设备：请允许大致位置权限后重试");
            return;
        }
        DiscoveryOptions discoveryOptionsBuild = new DiscoveryOptions.Builder().setStrategy(Strategy.P2P_POINT_TO_POINT).build();
        Intrinsics.checkNotNullExpressionValue(discoveryOptionsBuild, "build(...)");
        try {
            Result.Companion companion = Result.INSTANCE;
            TicketShareManager ticketShareManager = this;
            Task<Void> taskStartDiscovery = Nearby.getConnectionsClient(context2).startDiscovery(SERVICE_ID, endpointDiscoveryCallback, discoveryOptionsBuild);
            final Function1 function1 = new Function1() { // from class: com.example.tickets.TicketShareManager$$ExternalSyntheticLambda10
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return TicketShareManager.startDiscovery$lambda$24$lambda$21(this.f$0, (Void) obj);
                }
            };
            objM9536constructorimpl = Result.m9536constructorimpl(taskStartDiscovery.addOnSuccessListener(new OnSuccessListener() { // from class: com.example.tickets.TicketShareManager$$ExternalSyntheticLambda11
                @Override // com.google.android.gms.tasks.OnSuccessListener
                public final void onSuccess(Object obj) {
                    function1.invoke(obj);
                }
            }).addOnFailureListener(new OnFailureListener() { // from class: com.example.tickets.TicketShareManager$$ExternalSyntheticLambda1
                @Override // com.google.android.gms.tasks.OnFailureListener
                public final void onFailure(Exception exc) {
                    TicketShareManager.startDiscovery$lambda$24$lambda$23(this.f$0, exc);
                }
            }));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM9536constructorimpl = Result.m9536constructorimpl(ResultKt.createFailure(th));
        }
        Throwable thM9539exceptionOrNullimpl = Result.m9539exceptionOrNullimpl(objM9536constructorimpl);
        if (thM9539exceptionOrNullimpl != null) {
            TicketShareManager ticketShareManager2 = INSTANCE;
            State state = State.ERROR;
            String message = thM9539exceptionOrNullimpl.getMessage();
            if (message == null) {
                message = "未知错误";
            }
            ticketShareManager2.postState(state, "Nearby 搜索启动失败：" + message);
        }
    }

    static final Unit startDiscovery$lambda$24$lambda$21(TicketShareManager ticketShareManager, Void r3) {
        String str;
        State state = State.WAITING_FOR_PEER;
        if (transport == Transport.NFC) {
            str = "已准备接收，请靠近发送手机";
        } else {
            str = "正在连接发送设备…";
        }
        ticketShareManager.postState(state, str);
        return Unit.INSTANCE;
    }

    static final void startDiscovery$lambda$24$lambda$23(TicketShareManager ticketShareManager, Exception it) {
        Intrinsics.checkNotNullParameter(it, "it");
        State state = State.ERROR;
        String message = it.getMessage();
        if (message == null) {
            message = "未知错误";
        }
        ticketShareManager.postState(state, "Nearby 搜索启动失败：" + message);
    }

    private final void scheduleWifiFallbackServer(final Context appContext) {
        if (wifiFallbackStarted) {
            return;
        }
        mainHandler.postDelayed(new Runnable() { // from class: com.example.tickets.TicketShareManager$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                TicketShareManager.scheduleWifiFallbackServer$lambda$26(appContext);
            }
        }, 2200L);
    }

    static final void scheduleWifiFallbackServer$lambda$26(Context context2) {
        if (wifiFallbackStarted || role != Role.SENDER) {
            return;
        }
        TicketShareManager ticketShareManager = INSTANCE;
        if (ticketShareManager.getUiState().getState() == State.SCANNED || ticketShareManager.getUiState().getState() == State.WAITING_RECEIVER_CONFIRM || ticketShareManager.getUiState().getState() == State.SUCCESS) {
            return;
        }
        ticketShareManager.startWifiDirectFallbackServer(context2);
    }

    private final void scheduleWifiFallbackClient(final Context appContext) {
        mainHandler.postDelayed(new Runnable() { // from class: com.example.tickets.TicketShareManager$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                TicketShareManager.scheduleWifiFallbackClient$lambda$27(appContext);
            }
        }, 1800L);
    }

    static final void scheduleWifiFallbackClient$lambda$27(Context context2) {
        if (wifiFallbackStarted || role != Role.RECEIVER) {
            return;
        }
        TicketShareManager ticketShareManager = INSTANCE;
        if (ticketShareManager.getUiState().getState() == State.SCANNED || ticketShareManager.getUiState().getState() == State.WAITING_RECEIVER_CONFIRM || ticketShareManager.getUiState().getState() == State.SUCCESS) {
            return;
        }
        ticketShareManager.startWifiDirectFallbackClient(context2);
    }

    private final void startWifiDirectFallbackServer(Context appContext) {
        if (!wifiFallbackStarted && role == Role.SENDER && TicketWifiDirectTransport.INSTANCE.isSupported(appContext) && TicketWifiDirectTransport.INSTANCE.hasRequiredPermission(appContext)) {
            wifiFallbackStarted = true;
            TicketWifiDirectTransport ticketWifiDirectTransport = new TicketWifiDirectTransport();
            wifiDirectTransport = ticketWifiDirectTransport;
            ticketWifiDirectTransport.startServer(appContext, sessionId, sessionToken, new TicketWifiDirectTransport.Callback() { // from class: com.example.tickets.TicketShareManager.startWifiDirectFallbackServer.1
                @Override // com.example.tickets.TicketWifiDirectTransport.Callback
                public void onReady() {
                    TicketShareManager.INSTANCE.postState(State.WAITING_FOR_PEER, "正在等待附近设备连接…");
                }

                @Override // com.example.tickets.TicketWifiDirectTransport.Callback
                public void onConnected(String sid, String token) {
                    Intrinsics.checkNotNullParameter(sid, "sid");
                    Intrinsics.checkNotNullParameter(token, "token");
                    if (TicketShareManager.role != Role.SENDER) {
                        return;
                    }
                    TicketShareManager ticketShareManager = TicketShareManager.INSTANCE;
                    TicketShareManager.connectedEndpointId = "wifi-direct";
                    TicketShareManager.INSTANCE.postState(State.SCANNED, "对方已连接");
                }

                @Override // com.example.tickets.TicketWifiDirectTransport.Callback
                public void onBytesReceived(byte[] bytes) {
                    Object objM9536constructorimpl;
                    Intrinsics.checkNotNullParameter(bytes, "bytes");
                    try {
                        Result.Companion companion = Result.INSTANCE;
                        C03481 c03481 = this;
                        Charset UTF_8 = StandardCharsets.UTF_8;
                        Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
                        objM9536constructorimpl = Result.m9536constructorimpl(new String(bytes, UTF_8));
                    } catch (Throwable th) {
                        Result.Companion companion2 = Result.INSTANCE;
                        objM9536constructorimpl = Result.m9536constructorimpl(ResultKt.createFailure(th));
                    }
                    if (Result.m9542isFailureimpl(objM9536constructorimpl)) {
                        objM9536constructorimpl = "";
                    }
                    String strDecryptEnvelope = TicketTransferCrypto.INSTANCE.decryptEnvelope((String) objM9536constructorimpl);
                    if (strDecryptEnvelope == null) {
                        return;
                    }
                    TicketShareManager.INSTANCE.handleMessage("wifi-direct", strDecryptEnvelope);
                }

                @Override // com.example.tickets.TicketWifiDirectTransport.Callback
                public void onError(String message) {
                    Intrinsics.checkNotNullParameter(message, "message");
                    if (!TicketShareManager.wifiFallbackStarted || TicketShareManager.INSTANCE.getUiState().getState() == State.SCANNED || TicketShareManager.INSTANCE.getUiState().getState() == State.WAITING_RECEIVER_CONFIRM || TicketShareManager.INSTANCE.getUiState().getState() == State.SUCCESS) {
                        return;
                    }
                    TicketShareManager.INSTANCE.postState(State.WAITING_FOR_PEER, "等待附近设备连接…");
                }

                @Override // com.example.tickets.TicketWifiDirectTransport.Callback
                public void onDisconnected() {
                    if (TicketShareManager.INSTANCE.getUiState().getState() == State.SUCCESS || TicketShareManager.INSTANCE.getUiState().getState() == State.REJECTED) {
                        return;
                    }
                    TicketShareManager.INSTANCE.postState(State.ERROR, "附近设备连接已断开");
                }
            });
        }
    }

    private final void startWifiDirectFallbackClient(final Context appContext) {
        if (!wifiFallbackStarted && role == Role.RECEIVER && TicketWifiDirectTransport.INSTANCE.isSupported(appContext) && TicketWifiDirectTransport.INSTANCE.hasRequiredPermission(appContext)) {
            wifiFallbackStarted = true;
            TicketWifiDirectTransport ticketWifiDirectTransport = new TicketWifiDirectTransport();
            wifiDirectTransport = ticketWifiDirectTransport;
            ticketWifiDirectTransport.startClient(appContext, sessionId, sessionToken, new TicketWifiDirectTransport.Callback() { // from class: com.example.tickets.TicketShareManager.startWifiDirectFallbackClient.1
                @Override // com.example.tickets.TicketWifiDirectTransport.Callback
                public void onReady() {
                    TicketShareManager.INSTANCE.postState(State.WAITING_FOR_PEER, "正在通过 Wi-Fi Direct 寻找发送设备…");
                }

                @Override // com.example.tickets.TicketWifiDirectTransport.Callback
                public void onConnected(String sid, String token) {
                    Intrinsics.checkNotNullParameter(sid, "sid");
                    Intrinsics.checkNotNullParameter(token, "token");
                    if (TicketShareManager.role != Role.RECEIVER) {
                        return;
                    }
                    if (StringsKt.isBlank(TicketShareManager.sessionId)) {
                        TicketShareManager ticketShareManager = TicketShareManager.INSTANCE;
                        TicketShareManager.sessionId = sid;
                    }
                    if (StringsKt.isBlank(TicketShareManager.sessionToken)) {
                        TicketShareManager ticketShareManager2 = TicketShareManager.INSTANCE;
                        TicketShareManager.sessionToken = token;
                    }
                    TicketShareManager ticketShareManager3 = TicketShareManager.INSTANCE;
                    TicketShareManager.connectedEndpointId = "wifi-direct";
                    TicketShareManager ticketShareManager4 = TicketShareManager.INSTANCE;
                    Context applicationContext = appContext.getApplicationContext();
                    Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
                    ticketShareManager4.sendBytes(applicationContext, "wifi-direct", TicketShareManager.SCANNED_PREFIX + TicketShareManager.sessionId + "|" + TicketShareManager.sessionToken);
                    TicketShareManager.INSTANCE.postState(State.WAITING_SENDER_CONFIRM, "对方已连接，等待发送方确认…");
                }

                @Override // com.example.tickets.TicketWifiDirectTransport.Callback
                public void onBytesReceived(byte[] bytes) {
                    Object objM9536constructorimpl;
                    Intrinsics.checkNotNullParameter(bytes, "bytes");
                    try {
                        Result.Companion companion = Result.INSTANCE;
                        C03471 c03471 = this;
                        Charset UTF_8 = StandardCharsets.UTF_8;
                        Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
                        objM9536constructorimpl = Result.m9536constructorimpl(new String(bytes, UTF_8));
                    } catch (Throwable th) {
                        Result.Companion companion2 = Result.INSTANCE;
                        objM9536constructorimpl = Result.m9536constructorimpl(ResultKt.createFailure(th));
                    }
                    if (Result.m9542isFailureimpl(objM9536constructorimpl)) {
                        objM9536constructorimpl = "";
                    }
                    String strDecryptEnvelope = TicketTransferCrypto.INSTANCE.decryptEnvelope((String) objM9536constructorimpl);
                    if (strDecryptEnvelope == null) {
                        return;
                    }
                    TicketShareManager.INSTANCE.handleMessage("wifi-direct", strDecryptEnvelope);
                }

                @Override // com.example.tickets.TicketWifiDirectTransport.Callback
                public void onError(String message) {
                    Intrinsics.checkNotNullParameter(message, "message");
                    if (TicketShareManager.INSTANCE.getUiState().getState() == State.SCANNED || TicketShareManager.INSTANCE.getUiState().getState() == State.WAITING_RECEIVER_CONFIRM || TicketShareManager.INSTANCE.getUiState().getState() == State.SUCCESS) {
                        return;
                    }
                    TicketShareManager.INSTANCE.postState(State.WAITING_FOR_PEER, "正在等待附近设备连接…");
                }

                @Override // com.example.tickets.TicketWifiDirectTransport.Callback
                public void onDisconnected() {
                    if (TicketShareManager.INSTANCE.getUiState().getState() == State.SUCCESS || TicketShareManager.INSTANCE.getUiState().getState() == State.REJECTED) {
                        return;
                    }
                    TicketShareManager.INSTANCE.postState(State.ERROR, "附近设备连接已断开");
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleMessage(String endpointId, String message) {
        String str;
        Object objM9536constructorimpl;
        Object objM9536constructorimpl2;
        String str2;
        List listSplit$default = StringsKt.split$default((CharSequence) message, new String[]{"|"}, false, 4, 2, (Object) null);
        if (StringsKt.startsWith$default(message, NFC_COMPAT_HELLO_PREFIX, false, 2, (Object) null) && listSplit$default.size() >= 3) {
            markNfcContactDetected();
            if (role != Role.RECEIVER || StringsKt.isBlank((CharSequence) listSplit$default.get(1)) || StringsKt.isBlank((CharSequence) listSplit$default.get(2))) {
                return;
            }
            sessionId = (String) listSplit$default.get(1);
            String str3 = (String) listSplit$default.get(2);
            sessionToken = str3;
            connectedEndpointId = endpointId;
            Context context2 = context;
            if (context2 == null) {
                return;
            }
            sendBytes(context2, endpointId, SCANNED_PREFIX + sessionId + "|" + str3);
            postState(State.WAITING_SENDER_CONFIRM, "对方已连接，等待发送方确认…");
            return;
        }
        if (StringsKt.startsWith$default(message, SCANNED_PREFIX, false, 2, (Object) null) && listSplit$default.size() >= 3) {
            if (role == Role.SENDER && Intrinsics.areEqual(listSplit$default.get(1), sessionId) && Intrinsics.areEqual(listSplit$default.get(2), sessionToken)) {
                connectedEndpointId = endpointId;
                postState(State.SCANNED, "对方已扫描 / 感应成功");
                return;
            }
            return;
        }
        if (StringsKt.startsWith$default(message, TICKETS_PREFIX, false, 2, (Object) null) && listSplit$default.size() == 4) {
            if (role == Role.RECEIVER && Intrinsics.areEqual(listSplit$default.get(1), sessionId) && Intrinsics.areEqual(listSplit$default.get(2), sessionToken)) {
                try {
                    Result.Companion companion = Result.INSTANCE;
                    TicketShareManager ticketShareManager = this;
                    byte[] bArrDecode = Base64.decode((String) listSplit$default.get(3), 10);
                    Intrinsics.checkNotNullExpressionValue(bArrDecode, "decode(...)");
                    Charset UTF_8 = StandardCharsets.UTF_8;
                    Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
                    objM9536constructorimpl = Result.m9536constructorimpl(new String(bArrDecode, UTF_8));
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.INSTANCE;
                    objM9536constructorimpl = Result.m9536constructorimpl(ResultKt.createFailure(th));
                }
                if (Result.m9542isFailureimpl(objM9536constructorimpl)) {
                    objM9536constructorimpl = null;
                }
                String str4 = (String) objM9536constructorimpl;
                if (str4 == null) {
                    return;
                }
                try {
                    Result.Companion companion3 = Result.INSTANCE;
                    TicketShareManager ticketShareManager2 = this;
                    JSONArray jSONArray = new JSONArray(str4);
                    List listCreateListBuilder = CollectionsKt.createListBuilder();
                    int length = jSONArray.length();
                    for (int i = 0; i < length; i++) {
                        JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                        if (jSONObjectOptJSONObject != null) {
                            listCreateListBuilder.add(ticketFromJson(jSONObjectOptJSONObject));
                        }
                    }
                    objM9536constructorimpl2 = Result.m9536constructorimpl(CollectionsKt.build(listCreateListBuilder));
                } catch (Throwable th2) {
                    Result.Companion companion4 = Result.INSTANCE;
                    objM9536constructorimpl2 = Result.m9536constructorimpl(ResultKt.createFailure(th2));
                }
                List<TicketData> listEmptyList = (List) (Result.m9542isFailureimpl(objM9536constructorimpl2) ? null : objM9536constructorimpl2);
                if (listEmptyList == null) {
                    listEmptyList = CollectionsKt.emptyList();
                }
                if (listEmptyList.isEmpty()) {
                    return;
                }
                incomingTickets = listEmptyList;
                connectedEndpointId = endpointId;
                State state = State.WAITING_RECEIVER_CONFIRM;
                if (listEmptyList.size() == 1) {
                    str2 = "已收到 1 张票据，请确认是否接受";
                } else {
                    str2 = "已收到 " + listEmptyList.size() + " 张票据，请确认是否接受";
                }
                postState(state, str2);
                return;
            }
            return;
        }
        if (StringsKt.startsWith$default(message, ACCEPT_PREFIX, false, 2, (Object) null) && listSplit$default.size() >= 3) {
            if (role == Role.SENDER && Intrinsics.areEqual(listSplit$default.get(1), sessionId) && Intrinsics.areEqual(listSplit$default.get(2), sessionToken)) {
                postState(State.SUCCESS, "对方已接受票据");
                return;
            }
            return;
        }
        if (StringsKt.startsWith$default(message, REJECT_PREFIX, false, 2, (Object) null) && listSplit$default.size() >= 4 && Intrinsics.areEqual(listSplit$default.get(1), sessionId) && Intrinsics.areEqual(listSplit$default.get(2), sessionToken)) {
            State state2 = State.REJECTED;
            if (role == Role.SENDER) {
                str = "对方拒绝了这张票据";
            } else {
                str = "发送方取消了分享";
            }
            postState(state2, str);
        }
    }

    private final void startBluetoothServer(Context appContext) {
        if (role != Role.SENDER) {
            return;
        }
        stopAllBluetooth();
        if (!TicketBluetoothTransport.INSTANCE.isAvailable(appContext)) {
            postState(State.ERROR, "当前设备不支持 Bluetooth。");
            return;
        }
        if (!TicketBluetoothTransport.INSTANCE.hasRequiredPermission(appContext)) {
            postState(State.ERROR, "Bluetooth 缺少附近设备权限。");
            return;
        }
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        if (defaultAdapter == null || !defaultAdapter.isEnabled()) {
            postState(State.ERROR, "请先开启 Bluetooth。");
            return;
        }
        TicketBluetoothTransport ticketBluetoothTransport = new TicketBluetoothTransport();
        bluetoothTransport = ticketBluetoothTransport;
        ticketBluetoothTransport.startServer(appContext, new TicketTransport.Callback() { // from class: com.example.tickets.TicketShareManager.startBluetoothServer.1
            @Override // com.example.tickets.TicketTransport.Callback
            public void onReady(TicketTransport.Kind kind) {
                Intrinsics.checkNotNullParameter(kind, "kind");
                TicketShareManager.INSTANCE.postState(State.WAITING_FOR_PEER, "Bluetooth 已准备，等待另一台设备连接…");
            }

            @Override // com.example.tickets.TicketTransport.Callback
            public void onConnected(TicketTransport.Kind kind) {
                Intrinsics.checkNotNullParameter(kind, "kind");
                TicketShareManager ticketShareManager = TicketShareManager.INSTANCE;
                TicketShareManager.connectedEndpointId = "bluetooth";
                TicketShareManager.INSTANCE.postState(State.SCANNED, "对方已连接");
            }

            @Override // com.example.tickets.TicketTransport.Callback
            public void onBytesReceived(TicketTransport.Kind kind, byte[] bytes) {
                Object objM9536constructorimpl;
                Intrinsics.checkNotNullParameter(kind, "kind");
                Intrinsics.checkNotNullParameter(bytes, "bytes");
                try {
                    Result.Companion companion = Result.INSTANCE;
                    C03461 c03461 = this;
                    Charset UTF_8 = StandardCharsets.UTF_8;
                    Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
                    objM9536constructorimpl = Result.m9536constructorimpl(new String(bytes, UTF_8));
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.INSTANCE;
                    objM9536constructorimpl = Result.m9536constructorimpl(ResultKt.createFailure(th));
                }
                if (Result.m9542isFailureimpl(objM9536constructorimpl)) {
                    objM9536constructorimpl = "";
                }
                String strDecryptEnvelope = TicketTransferCrypto.INSTANCE.decryptEnvelope((String) objM9536constructorimpl);
                if (strDecryptEnvelope == null) {
                    return;
                }
                TicketShareManager.INSTANCE.handleMessage("bluetooth", strDecryptEnvelope);
            }

            @Override // com.example.tickets.TicketTransport.Callback
            public void onError(TicketTransport.Kind kind, String message) {
                Intrinsics.checkNotNullParameter(kind, "kind");
                Intrinsics.checkNotNullParameter(message, "message");
                TicketShareManager.INSTANCE.postState(State.ERROR, message);
            }

            @Override // com.example.tickets.TicketTransport.Callback
            public void onDisconnected(TicketTransport.Kind kind) {
                Intrinsics.checkNotNullParameter(kind, "kind");
                if (TicketShareManager.INSTANCE.getUiState().getState() == State.SUCCESS || TicketShareManager.INSTANCE.getUiState().getState() == State.REJECTED) {
                    return;
                }
                TicketShareManager.INSTANCE.postState(State.ERROR, "Bluetooth 连接已断开");
            }
        });
    }

    private final void startBluetoothClient(final Context appContext) {
        Object objM9536constructorimpl;
        if (role != Role.RECEIVER) {
            return;
        }
        stopAllBluetooth();
        if (!TicketBluetoothTransport.INSTANCE.isAvailable(appContext)) {
            postState(State.ERROR, "当前设备不支持 Bluetooth。");
            return;
        }
        if (!TicketBluetoothTransport.INSTANCE.hasRequiredPermission(appContext)) {
            postState(State.ERROR, "Bluetooth 缺少附近设备权限。");
            return;
        }
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        if (defaultAdapter == null || !defaultAdapter.isEnabled()) {
            postState(State.ERROR, "请先开启 Bluetooth。");
            return;
        }
        TicketBluetoothTransport ticketBluetoothTransport = new TicketBluetoothTransport();
        bluetoothTransport = ticketBluetoothTransport;
        ticketBluetoothTransport.startClient(appContext, new TicketTransport.Callback() { // from class: com.example.tickets.TicketShareManager.startBluetoothClient.1
            @Override // com.example.tickets.TicketTransport.Callback
            public void onReady(TicketTransport.Kind kind) {
                Intrinsics.checkNotNullParameter(kind, "kind");
                TicketShareManager.INSTANCE.postState(State.WAITING_FOR_PEER, "正在搜索 Bluetooth 设备…");
            }

            @Override // com.example.tickets.TicketTransport.Callback
            public void onConnected(TicketTransport.Kind kind) {
                Intrinsics.checkNotNullParameter(kind, "kind");
                TicketShareManager ticketShareManager = TicketShareManager.INSTANCE;
                TicketShareManager.connectedEndpointId = "bluetooth";
                TicketShareManager.INSTANCE.sendBytes(appContext, "bluetooth", TicketShareManager.SCANNED_PREFIX + TicketShareManager.sessionId + "|" + TicketShareManager.sessionToken);
                TicketShareManager.INSTANCE.postState(State.WAITING_SENDER_CONFIRM, "对方已连接，等待发送方确认…");
            }

            @Override // com.example.tickets.TicketTransport.Callback
            public void onBytesReceived(TicketTransport.Kind kind, byte[] bytes) {
                Object objM9536constructorimpl2;
                Intrinsics.checkNotNullParameter(kind, "kind");
                Intrinsics.checkNotNullParameter(bytes, "bytes");
                try {
                    Result.Companion companion = Result.INSTANCE;
                    AnonymousClass1 anonymousClass1 = this;
                    Charset UTF_8 = StandardCharsets.UTF_8;
                    Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
                    objM9536constructorimpl2 = Result.m9536constructorimpl(new String(bytes, UTF_8));
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.INSTANCE;
                    objM9536constructorimpl2 = Result.m9536constructorimpl(ResultKt.createFailure(th));
                }
                if (Result.m9542isFailureimpl(objM9536constructorimpl2)) {
                    objM9536constructorimpl2 = "";
                }
                String strDecryptEnvelope = TicketTransferCrypto.INSTANCE.decryptEnvelope((String) objM9536constructorimpl2);
                if (strDecryptEnvelope == null) {
                    return;
                }
                TicketShareManager.INSTANCE.handleMessage("bluetooth", strDecryptEnvelope);
            }

            @Override // com.example.tickets.TicketTransport.Callback
            public void onError(TicketTransport.Kind kind, String message) {
                Intrinsics.checkNotNullParameter(kind, "kind");
                Intrinsics.checkNotNullParameter(message, "message");
                TicketShareManager.INSTANCE.postState(State.ERROR, message);
            }

            @Override // com.example.tickets.TicketTransport.Callback
            public void onDisconnected(TicketTransport.Kind kind) {
                Intrinsics.checkNotNullParameter(kind, "kind");
                if (TicketShareManager.INSTANCE.getUiState().getState() == State.SUCCESS || TicketShareManager.INSTANCE.getUiState().getState() == State.REJECTED) {
                    return;
                }
                TicketShareManager.INSTANCE.postState(State.ERROR, "Bluetooth 连接已断开");
            }
        });
        BroadcastReceiver broadcastReceiver = new BroadcastReceiver() { // from class: com.example.tickets.TicketShareManager$startBluetoothClient$receiver$1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context2, Intent intent) {
                BluetoothDevice bluetoothDevice;
                Intrinsics.checkNotNullParameter(context2, "context");
                Intrinsics.checkNotNullParameter(intent, "intent");
                if (Intrinsics.areEqual(intent.getAction(), "android.bluetooth.device.action.FOUND") && TicketShareManager.bluetoothDiscoveryStarted) {
                    if (Build.VERSION.SDK_INT >= 33) {
                        bluetoothDevice = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE", BluetoothDevice.class);
                        if (bluetoothDevice == null) {
                            return;
                        }
                    } else {
                        bluetoothDevice = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
                        if (bluetoothDevice == null) {
                            return;
                        }
                    }
                    TicketShareManager ticketShareManager = TicketShareManager.INSTANCE;
                    TicketShareManager.bluetoothDiscoveryStarted = false;
                    try {
                        Result.Companion companion = Result.INSTANCE;
                        TicketShareManager$startBluetoothClient$receiver$1 ticketShareManager$startBluetoothClient$receiver$1 = this;
                        BluetoothAdapter defaultAdapter2 = BluetoothAdapter.getDefaultAdapter();
                        Result.m9536constructorimpl(defaultAdapter2 != null ? Boolean.valueOf(defaultAdapter2.cancelDiscovery()) : null);
                    } catch (Throwable th) {
                        Result.Companion companion2 = Result.INSTANCE;
                        Result.m9536constructorimpl(ResultKt.createFailure(th));
                    }
                    Context context3 = appContext;
                    try {
                        Result.Companion companion3 = Result.INSTANCE;
                        TicketShareManager$startBluetoothClient$receiver$1 ticketShareManager$startBluetoothClient$receiver$2 = this;
                        context3.unregisterReceiver(this);
                        Result.m9536constructorimpl(Unit.INSTANCE);
                    } catch (Throwable th2) {
                        Result.Companion companion4 = Result.INSTANCE;
                        Result.m9536constructorimpl(ResultKt.createFailure(th2));
                    }
                    TicketShareManager ticketShareManager2 = TicketShareManager.INSTANCE;
                    TicketShareManager.bluetoothDiscoveryReceiver = null;
                    TicketBluetoothTransport ticketBluetoothTransport2 = TicketShareManager.bluetoothTransport;
                    if (ticketBluetoothTransport2 != null) {
                        ticketBluetoothTransport2.connectToDevice(bluetoothDevice);
                    }
                }
            }
        };
        BroadcastReceiver broadcastReceiver2 = broadcastReceiver;
        bluetoothDiscoveryReceiver = broadcastReceiver2;
        IntentFilter intentFilter = new IntentFilter("android.bluetooth.device.action.FOUND");
        if (Build.VERSION.SDK_INT >= 33) {
            appContext.registerReceiver(broadcastReceiver2, intentFilter, 4);
        } else {
            appContext.registerReceiver(broadcastReceiver2, intentFilter);
        }
        bluetoothDiscoveryStarted = true;
        try {
            Result.Companion companion = Result.INSTANCE;
            TicketShareManager ticketShareManager = this;
            objM9536constructorimpl = Result.m9536constructorimpl(Boolean.valueOf(defaultAdapter.startDiscovery()));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM9536constructorimpl = Result.m9536constructorimpl(ResultKt.createFailure(th));
        }
        Throwable thM9539exceptionOrNullimpl = Result.m9539exceptionOrNullimpl(objM9536constructorimpl);
        if (thM9539exceptionOrNullimpl != null) {
            bluetoothDiscoveryStarted = false;
            try {
                Result.Companion companion3 = Result.INSTANCE;
                appContext.unregisterReceiver(broadcastReceiver);
                Result.m9536constructorimpl(Unit.INSTANCE);
            } catch (Throwable th2) {
                Result.Companion companion4 = Result.INSTANCE;
                Result.m9536constructorimpl(ResultKt.createFailure(th2));
            }
            TicketShareManager ticketShareManager2 = INSTANCE;
            bluetoothDiscoveryReceiver = null;
            State state = State.ERROR;
            String message = thM9539exceptionOrNullimpl.getMessage();
            if (message == null) {
                message = "未知错误";
            }
            ticketShareManager2.postState(state, "Bluetooth 搜索设备失败：" + message);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void sendBytes(Context context2, String endpointId, String message) {
        Object objM9536constructorimpl;
        Object objM9536constructorimpl2;
        try {
            Result.Companion companion = Result.INSTANCE;
            TicketShareManager ticketShareManager = this;
            objM9536constructorimpl = Result.m9536constructorimpl(TicketTransferCrypto.INSTANCE.encryptToEnvelope(message));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM9536constructorimpl = Result.m9536constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m9542isFailureimpl(objM9536constructorimpl)) {
            objM9536constructorimpl = null;
        }
        String str = (String) objM9536constructorimpl;
        if (str == null) {
            postState(State.ERROR, "数据加密失败，请重新尝试。");
            return;
        }
        if (Intrinsics.areEqual(endpointId, "wifi-direct")) {
            TicketWifiDirectTransport ticketWifiDirectTransport = wifiDirectTransport;
            if (ticketWifiDirectTransport == null) {
                postState(State.ERROR, "Wi-Fi Direct 数据通道尚未建立。");
                return;
            }
            Charset UTF_8 = StandardCharsets.UTF_8;
            Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
            byte[] bytes = str.getBytes(UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
            ticketWifiDirectTransport.send(bytes, new Function1() { // from class: com.example.tickets.TicketShareManager$$ExternalSyntheticLambda8
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return TicketShareManager.sendBytes$lambda$37(((Boolean) obj).booleanValue());
                }
            });
            return;
        }
        if (Intrinsics.areEqual(endpointId, "bluetooth")) {
            TicketBluetoothTransport ticketBluetoothTransport = bluetoothTransport;
            if (ticketBluetoothTransport == null) {
                postState(State.ERROR, "Bluetooth 数据通道尚未建立。");
                return;
            }
            Charset UTF_9 = StandardCharsets.UTF_8;
            Intrinsics.checkNotNullExpressionValue(UTF_9, "UTF_8");
            byte[] bytes2 = str.getBytes(UTF_9);
            Intrinsics.checkNotNullExpressionValue(bytes2, "getBytes(...)");
            ticketBluetoothTransport.send(bytes2, new Function1() { // from class: com.example.tickets.TicketShareManager$$ExternalSyntheticLambda9
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return TicketShareManager.sendBytes$lambda$38(((Boolean) obj).booleanValue());
                }
            });
            return;
        }
        try {
            Result.Companion companion3 = Result.INSTANCE;
            TicketShareManager ticketShareManager2 = this;
            ConnectionsClient connectionsClient = Nearby.getConnectionsClient(context2);
            Charset UTF_10 = StandardCharsets.UTF_8;
            Intrinsics.checkNotNullExpressionValue(UTF_10, "UTF_8");
            byte[] bytes3 = str.getBytes(UTF_10);
            Intrinsics.checkNotNullExpressionValue(bytes3, "getBytes(...)");
            objM9536constructorimpl2 = Result.m9536constructorimpl(connectionsClient.sendPayload(endpointId, Payload.fromBytes(bytes3)));
        } catch (Throwable th2) {
            Result.Companion companion4 = Result.INSTANCE;
            objM9536constructorimpl2 = Result.m9536constructorimpl(ResultKt.createFailure(th2));
        }
        if (Result.m9539exceptionOrNullimpl(objM9536constructorimpl2) != null) {
            INSTANCE.postState(State.ERROR, "数据发送失败，请重新尝试。");
        }
    }

    static final Unit sendBytes$lambda$37(boolean z) {
        if (!z) {
            INSTANCE.postState(State.ERROR, "Wi-Fi Direct 数据发送失败，请重新尝试。");
        }
        return Unit.INSTANCE;
    }

    static final Unit sendBytes$lambda$38(boolean z) {
        if (!z) {
            INSTANCE.postState(State.ERROR, "Bluetooth 数据发送失败，请重新尝试。");
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateState(State state, String message) {
        stateStore.setValue(new UiState(role, transport, state, sessionId, sessionToken, message, null, false, 192, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void postState(final State state, final String message) {
        mainHandler.post(new Runnable() { // from class: com.example.tickets.TicketShareManager$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                TicketShareManager.INSTANCE.updateState(state, message);
            }
        });
    }

    private final JSONObject ticketToJson(TicketData ticket) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, ticket.getType().name());
        jSONObject.put("title", ticket.getTitle());
        jSONObject.put("code", ticket.getCode());
        jSONObject.put("barcodeValue", ticket.getBarcodeValue());
        jSONObject.put("barcodeFormat", ticket.getBarcodeFormat());
        jSONObject.put("date", ticket.getDate());
        jSONObject.put("time", ticket.getTime());
        jSONObject.put("departureDate", ticket.getDepartureDate());
        jSONObject.put("arrivalDate", ticket.getArrivalDate());
        jSONObject.put(Constants.MessagePayloadKeys.FROM, ticket.getFrom());
        jSONObject.put("to", ticket.getTo());
        jSONObject.put("departurePlatform", ticket.getDeparturePlatform());
        jSONObject.put("arrivalPlatform", ticket.getArrivalPlatform());
        jSONObject.put("departureGate", ticket.getDepartureGate());
        jSONObject.put("arrivalGate", ticket.getArrivalGate());
        jSONObject.put("hall", ticket.getHall());
        jSONObject.put("seat", ticket.getSeat());
        jSONObject.put("area", ticket.getArea());
        jSONObject.put("entry", ticket.getEntry());
        jSONObject.put("venue", ticket.getVenue());
        jSONObject.put("startTime", ticket.getStartTime());
        jSONObject.put("endTime", ticket.getEndTime());
        jSONObject.put("takeoffTime", ticket.getTakeoffTime());
        jSONObject.put("landingTime", ticket.getLandingTime());
        jSONObject.put("brand", ticket.getBrand());
        return jSONObject;
    }

    private final TicketData ticketFromJson(JSONObject o) {
        Object objM9536constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            TicketShareManager ticketShareManager = this;
            String strOptString = o.optString(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "Movie");
            Intrinsics.checkNotNullExpressionValue(strOptString, "optString(...)");
            objM9536constructorimpl = Result.m9536constructorimpl(TicketType.valueOf(strOptString));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM9536constructorimpl = Result.m9536constructorimpl(ResultKt.createFailure(th));
        }
        TicketType ticketType = TicketType.Movie;
        if (Result.m9542isFailureimpl(objM9536constructorimpl)) {
            objM9536constructorimpl = ticketType;
        }
        TicketType ticketType2 = (TicketType) objM9536constructorimpl;
        String strOptString2 = o.optString("title");
        Intrinsics.checkNotNullExpressionValue(strOptString2, "optString(...)");
        String strOptString3 = o.optString("code");
        Intrinsics.checkNotNullExpressionValue(strOptString3, "optString(...)");
        String strOptString4 = o.optString("barcodeValue");
        Intrinsics.checkNotNullExpressionValue(strOptString4, "optString(...)");
        String strOptString5 = o.optString("barcodeFormat", "二维码");
        Intrinsics.checkNotNullExpressionValue(strOptString5, "optString(...)");
        String strOptString6 = o.optString("date");
        Intrinsics.checkNotNullExpressionValue(strOptString6, "optString(...)");
        String strOptString7 = o.optString("time");
        Intrinsics.checkNotNullExpressionValue(strOptString7, "optString(...)");
        String strOptString8 = o.optString("departureDate");
        Intrinsics.checkNotNullExpressionValue(strOptString8, "optString(...)");
        String strOptString9 = o.optString("arrivalDate");
        Intrinsics.checkNotNullExpressionValue(strOptString9, "optString(...)");
        String strOptString10 = o.optString(Constants.MessagePayloadKeys.FROM);
        Intrinsics.checkNotNullExpressionValue(strOptString10, "optString(...)");
        String strOptString11 = o.optString("to");
        Intrinsics.checkNotNullExpressionValue(strOptString11, "optString(...)");
        String strOptString12 = o.optString("departurePlatform");
        Intrinsics.checkNotNullExpressionValue(strOptString12, "optString(...)");
        String strOptString13 = o.optString("arrivalPlatform");
        Intrinsics.checkNotNullExpressionValue(strOptString13, "optString(...)");
        String strOptString14 = o.optString("departureGate");
        Intrinsics.checkNotNullExpressionValue(strOptString14, "optString(...)");
        String strOptString15 = o.optString("arrivalGate");
        Intrinsics.checkNotNullExpressionValue(strOptString15, "optString(...)");
        String strOptString16 = o.optString("hall");
        Intrinsics.checkNotNullExpressionValue(strOptString16, "optString(...)");
        String strOptString17 = o.optString("seat");
        Intrinsics.checkNotNullExpressionValue(strOptString17, "optString(...)");
        String strOptString18 = o.optString("area");
        Intrinsics.checkNotNullExpressionValue(strOptString18, "optString(...)");
        String strOptString19 = o.optString("entry");
        Intrinsics.checkNotNullExpressionValue(strOptString19, "optString(...)");
        String strOptString20 = o.optString("venue");
        Intrinsics.checkNotNullExpressionValue(strOptString20, "optString(...)");
        String strOptString21 = o.optString("startTime");
        Intrinsics.checkNotNullExpressionValue(strOptString21, "optString(...)");
        String strOptString22 = o.optString("endTime");
        Intrinsics.checkNotNullExpressionValue(strOptString22, "optString(...)");
        String strOptString23 = o.optString("takeoffTime");
        Intrinsics.checkNotNullExpressionValue(strOptString23, "optString(...)");
        String strOptString24 = o.optString("landingTime");
        Intrinsics.checkNotNullExpressionValue(strOptString24, "optString(...)");
        String strOptString25 = o.optString("brand");
        Intrinsics.checkNotNullExpressionValue(strOptString25, "optString(...)");
        return new TicketData(0, ticketType2, strOptString2, strOptString3, strOptString4, strOptString5, strOptString6, strOptString7, strOptString8, strOptString9, strOptString10, strOptString11, strOptString12, strOptString13, strOptString14, strOptString15, strOptString16, strOptString17, strOptString18, strOptString19, strOptString20, strOptString21, strOptString22, strOptString23, strOptString24, strOptString25, false, false, false, null);
    }
}
