package com.example.tickets;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.p2p.WifiP2pConfig;
import android.net.wifi.p2p.WifiP2pDevice;
import android.net.wifi.p2p.WifiP2pDeviceList;
import android.net.wifi.p2p.WifiP2pInfo;
import android.net.wifi.p2p.WifiP2pManager;
import android.os.Build;
import androidx.compose.ui.autofill.AutofillUtils_androidKt;
import androidx.core.content.ContextCompat;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: TicketWifiDirectTransport.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0001\u0018\u0000 92\u00020\u0001:\u00029:B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J(\u0010\u001f\u001a\u00020 2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u000f2\u0006\u0010\"\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J&\u0010#\u001a\u00020 2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u0007J&\u0010$\u001a\u00020 2\u0006\u0010%\u001a\u00020&2\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020 \u0018\u00010'J\u0006\u0010(\u001a\u00020 J\u0016\u0010)\u001a\u00020 2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020 0+H\u0002J\b\u0010,\u001a\u00020 H\u0003J\u0010\u0010.\u001a\u00020 2\u0006\u0010/\u001a\u000200H\u0003J\b\u00101\u001a\u00020 H\u0002J\b\u00102\u001a\u00020 H\u0003J\u0010\u00103\u001a\u00020 2\u0006\u00104\u001a\u00020\u000fH\u0002J\u0018\u00105\u001a\u00020 2\u0006\u00106\u001a\u00020\u000f2\u0006\u0010\"\u001a\u00020\u000fH\u0002J\u0010\u00107\u001a\u00020 2\u0006\u00108\u001a\u00020\u0018H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0019\u001a\n \u001b*\u0004\u0018\u00010\u001a0\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006;"}, d2 = {"Lcom/example/tickets/TicketWifiDirectTransport;", "", "<init>", "()V", "context", "Landroid/content/Context;", "callback", "Lcom/example/tickets/TicketWifiDirectTransport$Callback;", "manager", "Landroid/net/wifi/p2p/WifiP2pManager;", "channel", "Landroid/net/wifi/p2p/WifiP2pManager$Channel;", "receiver", "Landroid/content/BroadcastReceiver;", "expectedSessionId", "", "expectedToken", "discoveredSessionId", "discoveredToken", "serverMode", "", "serverSocket", "Ljava/net/ServerSocket;", "socket", "Ljava/net/Socket;", "executor", "Ljava/util/concurrent/ExecutorService;", "kotlin.jvm.PlatformType", "running", "Ljava/util/concurrent/atomic/AtomicBoolean;", "connectedNotified", "startServer", "", "sessionId", "token", "startClient", "send", "bytes", "", "Lkotlin/Function1;", "stop", "setupWifiP2p", "onReady", "Lkotlin/Function0;", "startServiceDiscovery", "connecting", "connectToDevice", "device", "Landroid/net/wifi/p2p/WifiP2pDevice;", "startServerSocket", "requestConnectionInfo", "connectSocket", "hostAddress", "notifyConnectedOnce", "sid", "readLoop", "s", "Companion", "Callback", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class TicketWifiDirectTransport {
    private static final int MAX_PACKET_SIZE = 2097152;
    private static final int PORT = 39127;
    private static final String SERVICE_INSTANCE = "TicketsShare";
    private static final String SERVICE_TYPE = "_tickets._tcp";
    private Callback callback;
    private WifiP2pManager.Channel channel;
    private Context context;
    private WifiP2pManager manager;
    private BroadcastReceiver receiver;
    private boolean serverMode;
    private ServerSocket serverSocket;
    private Socket socket;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;
    private String expectedSessionId = "";
    private String expectedToken = "";
    private String discoveredSessionId = "";
    private String discoveredToken = "";
    private final ExecutorService executor = Executors.newCachedThreadPool();
    private final AtomicBoolean running = new AtomicBoolean(false);
    private final AtomicBoolean connectedNotified = new AtomicBoolean(false);
    private final AtomicBoolean connecting = new AtomicBoolean(false);

    /* JADX INFO: compiled from: TicketWifiDirectTransport.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0018\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH&J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0006H&J\b\u0010\r\u001a\u00020\u0003H&¨\u0006\u000eÀ\u0006\u0003"}, d2 = {"Lcom/example/tickets/TicketWifiDirectTransport$Callback;", "", "onReady", "", "onConnected", "sessionId", "", "token", "onBytesReceived", "bytes", "", "onError", "message", "onDisconnected", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public interface Callback {
        void onBytesReceived(byte[] bytes);

        void onConnected(String sessionId, String token);

        void onDisconnected();

        void onError(String message);

        void onReady();
    }

    /* JADX INFO: compiled from: TicketWifiDirectTransport.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/example/tickets/TicketWifiDirectTransport$Companion;", "", "<init>", "()V", "PORT", "", "SERVICE_INSTANCE", "", "SERVICE_TYPE", "MAX_PACKET_SIZE", "hasRequiredPermission", "", "context", "Landroid/content/Context;", "isSupported", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final boolean hasRequiredPermission(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            if (Build.VERSION.SDK_INT >= 33) {
                return ContextCompat.checkSelfPermission(context, "android.permission.NEARBY_WIFI_DEVICES") == 0;
            }
            return ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_FINE_LOCATION") == 0 || ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_COARSE_LOCATION") == 0;
        }

        public final boolean isSupported(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            Object systemService = context.getApplicationContext().getSystemService("wifip2p");
            return (systemService instanceof WifiP2pManager ? (WifiP2pManager) systemService : null) != null;
        }
    }

    public final void startServer(Context context, String sessionId, String token, final Callback callback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(token, "token");
        Intrinsics.checkNotNullParameter(callback, "callback");
        stop();
        Companion companion = INSTANCE;
        if (!companion.isSupported(context)) {
            callback.onError("设备不支持 Wi-Fi Direct");
            return;
        }
        if (!companion.hasRequiredPermission(context)) {
            callback.onError("Wi-Fi Direct 缺少附近 Wi-Fi / 位置权限");
            return;
        }
        this.context = context.getApplicationContext();
        this.callback = callback;
        this.expectedSessionId = sessionId;
        this.expectedToken = token;
        this.serverMode = true;
        this.running.set(true);
        setupWifiP2p(new Function0() { // from class: com.example.tickets.TicketWifiDirectTransport$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return TicketWifiDirectTransport.startServer$lambda$2(this.f$0, callback);
            }
        });
    }

    static final Unit startServer$lambda$2(final TicketWifiDirectTransport ticketWifiDirectTransport, final Callback callback) {
        Object objM9536constructorimpl;
        Unit unit;
        ticketWifiDirectTransport.startServerSocket();
        try {
            Result.Companion companion = Result.INSTANCE;
            WifiP2pManager wifiP2pManager = ticketWifiDirectTransport.manager;
            if (wifiP2pManager != null) {
                wifiP2pManager.createGroup(ticketWifiDirectTransport.channel, new WifiP2pManager.ActionListener() { // from class: com.example.tickets.TicketWifiDirectTransport$startServer$1$1$1
                    @Override // android.net.wifi.p2p.WifiP2pManager.ActionListener
                    public void onSuccess() {
                    }

                    @Override // android.net.wifi.p2p.WifiP2pManager.ActionListener
                    public void onFailure(int reason) {
                        if (this.$this_runCatching.running.get()) {
                            callback.onError("Wi-Fi Direct 建立本地组失败：" + reason);
                        }
                    }
                });
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            objM9536constructorimpl = Result.m9536constructorimpl(unit);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM9536constructorimpl = Result.m9536constructorimpl(ResultKt.createFailure(th));
        }
        Throwable thM9539exceptionOrNullimpl = Result.m9539exceptionOrNullimpl(objM9536constructorimpl);
        if (thM9539exceptionOrNullimpl != null) {
            String message = thM9539exceptionOrNullimpl.getMessage();
            if (message == null) {
                message = "Wi-Fi Direct 建组失败";
            }
            callback.onError(message);
        }
        callback.onReady();
        return Unit.INSTANCE;
    }

    public final void startClient(Context context, String expectedSessionId, String expectedToken, final Callback callback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(expectedSessionId, "expectedSessionId");
        Intrinsics.checkNotNullParameter(expectedToken, "expectedToken");
        Intrinsics.checkNotNullParameter(callback, "callback");
        stop();
        Companion companion = INSTANCE;
        if (!companion.isSupported(context)) {
            callback.onError("设备不支持 Wi-Fi Direct");
            return;
        }
        if (!companion.hasRequiredPermission(context)) {
            callback.onError("Wi-Fi Direct 缺少附近 Wi-Fi / 位置权限");
            return;
        }
        this.context = context.getApplicationContext();
        this.callback = callback;
        this.expectedSessionId = expectedSessionId;
        this.expectedToken = expectedToken;
        this.serverMode = false;
        this.running.set(true);
        setupWifiP2p(new Function0() { // from class: com.example.tickets.TicketWifiDirectTransport$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return TicketWifiDirectTransport.startClient$lambda$3(this.f$0, callback);
            }
        });
    }

    static final Unit startClient$lambda$3(TicketWifiDirectTransport ticketWifiDirectTransport, Callback callback) {
        ticketWifiDirectTransport.startServerSocket();
        ticketWifiDirectTransport.startServiceDiscovery();
        callback.onReady();
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void send$default(TicketWifiDirectTransport ticketWifiDirectTransport, byte[] bArr, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = null;
        }
        ticketWifiDirectTransport.send(bArr, function1);
    }

    public final void send(final byte[] bytes, final Function1<? super Boolean, Unit> callback) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        final Socket socket = this.socket;
        if (socket != null && !socket.isClosed()) {
            this.executor.execute(new Runnable() { // from class: com.example.tickets.TicketWifiDirectTransport$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    TicketWifiDirectTransport.send$lambda$5(this.f$0, callback, socket, bytes);
                }
            });
        } else if (callback != null) {
            callback.invoke(false);
        }
    }

    static final void send$lambda$5(TicketWifiDirectTransport ticketWifiDirectTransport, Function1 function1, Socket socket, byte[] bArr) {
        Object objM9536constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            DataOutputStream dataOutputStream = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
            dataOutputStream.writeInt(bArr.length);
            dataOutputStream.write(bArr);
            dataOutputStream.flush();
            objM9536constructorimpl = Result.m9536constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM9536constructorimpl = Result.m9536constructorimpl(ResultKt.createFailure(th));
        }
        boolean zM9543isSuccessimpl = Result.m9543isSuccessimpl(objM9536constructorimpl);
        if (function1 != null) {
            function1.invoke(Boolean.valueOf(zM9543isSuccessimpl));
        }
    }

    public final void stop() {
        BroadcastReceiver broadcastReceiver;
        Object objM9536constructorimpl;
        Unit unit;
        Unit unit2;
        this.running.set(false);
        this.connectedNotified.set(false);
        Context context = this.context;
        WifiP2pManager wifiP2pManager = this.manager;
        WifiP2pManager.Channel channel = this.channel;
        if (wifiP2pManager != null && channel != null) {
            try {
                Result.Companion companion = Result.INSTANCE;
                TicketWifiDirectTransport ticketWifiDirectTransport = this;
                wifiP2pManager.cancelConnect(channel, null);
                Result.m9536constructorimpl(Unit.INSTANCE);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                Result.m9536constructorimpl(ResultKt.createFailure(th));
            }
            try {
                Result.Companion companion3 = Result.INSTANCE;
                TicketWifiDirectTransport ticketWifiDirectTransport2 = this;
                wifiP2pManager.removeGroup(channel, null);
                Result.m9536constructorimpl(Unit.INSTANCE);
            } catch (Throwable th2) {
                Result.Companion companion4 = Result.INSTANCE;
                Result.m9536constructorimpl(ResultKt.createFailure(th2));
            }
        }
        try {
            Result.Companion companion5 = Result.INSTANCE;
            TicketWifiDirectTransport ticketWifiDirectTransport3 = this;
            Socket socket = this.socket;
            if (socket != null) {
                socket.close();
                unit2 = Unit.INSTANCE;
            } else {
                unit2 = null;
            }
            Result.m9536constructorimpl(unit2);
        } catch (Throwable th3) {
            Result.Companion companion6 = Result.INSTANCE;
            Result.m9536constructorimpl(ResultKt.createFailure(th3));
        }
        try {
            Result.Companion companion7 = Result.INSTANCE;
            TicketWifiDirectTransport ticketWifiDirectTransport4 = this;
            ServerSocket serverSocket = this.serverSocket;
            if (serverSocket != null) {
                serverSocket.close();
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            Result.m9536constructorimpl(unit);
        } catch (Throwable th4) {
            Result.Companion companion8 = Result.INSTANCE;
            Result.m9536constructorimpl(ResultKt.createFailure(th4));
        }
        if (context != null && (broadcastReceiver = this.receiver) != null) {
            try {
                Result.Companion companion9 = Result.INSTANCE;
                TicketWifiDirectTransport ticketWifiDirectTransport5 = this;
                if (Build.VERSION.SDK_INT >= 33) {
                    context.unregisterReceiver(broadcastReceiver);
                } else {
                    context.unregisterReceiver(broadcastReceiver);
                }
                objM9536constructorimpl = Result.m9536constructorimpl(Unit.INSTANCE);
            } catch (Throwable th5) {
                Result.Companion companion10 = Result.INSTANCE;
                objM9536constructorimpl = Result.m9536constructorimpl(ResultKt.createFailure(th5));
            }
            Result.m9535boximpl(objM9536constructorimpl);
        }
        this.socket = null;
        this.serverSocket = null;
        this.receiver = null;
        this.manager = null;
        this.channel = null;
        this.callback = null;
        this.context = null;
        this.expectedSessionId = "";
        this.expectedToken = "";
        this.discoveredSessionId = "";
        this.discoveredToken = "";
    }

    private final void setupWifiP2p(Function0<Unit> onReady) {
        Object objM9536constructorimpl;
        Intent intentRegisterReceiver;
        Context context = this.context;
        if (context == null) {
            return;
        }
        Object systemService = context.getSystemService("wifip2p");
        WifiP2pManager wifiP2pManager = systemService instanceof WifiP2pManager ? (WifiP2pManager) systemService : null;
        if (wifiP2pManager == null) {
            Callback callback = this.callback;
            if (callback != null) {
                callback.onError("Wi-Fi Direct 服务不可用");
                return;
            }
            return;
        }
        this.manager = wifiP2pManager;
        this.channel = wifiP2pManager.initialize(context, context.getMainLooper(), new WifiP2pManager.ChannelListener() { // from class: com.example.tickets.TicketWifiDirectTransport.setupWifiP2p.1
            @Override // android.net.wifi.p2p.WifiP2pManager.ChannelListener
            public void onChannelDisconnected() {
                Callback callback2;
                if (!TicketWifiDirectTransport.this.running.get() || (callback2 = TicketWifiDirectTransport.this.callback) == null) {
                    return;
                }
                callback2.onError("Wi-Fi Direct Channel 已断开");
            }
        });
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.wifi.p2p.STATE_CHANGED");
        intentFilter.addAction("android.net.wifi.p2p.CONNECTION_STATE_CHANGE");
        intentFilter.addAction("android.net.wifi.p2p.THIS_DEVICE_CHANGED");
        intentFilter.addAction("android.net.wifi.p2p.DISCOVERY_STATE_CHANGE");
        this.receiver = new BroadcastReceiver() { // from class: com.example.tickets.TicketWifiDirectTransport.setupWifiP2p.2
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context2, Intent intent) {
                Callback callback2;
                String action = intent != null ? intent.getAction() : null;
                if (action != null) {
                    int iHashCode = action.hashCode();
                    if (iHashCode == -1772632330) {
                        if (action.equals("android.net.wifi.p2p.CONNECTION_STATE_CHANGE")) {
                            TicketWifiDirectTransport.this.requestConnectionInfo();
                        }
                    } else if (iHashCode == 1695662461 && action.equals("android.net.wifi.p2p.STATE_CHANGED") && intent.getIntExtra("wifi_p2p_state", 1) != 2 && TicketWifiDirectTransport.this.running.get() && (callback2 = TicketWifiDirectTransport.this.callback) != null) {
                        callback2.onError("Wi-Fi Direct 当前未开启");
                    }
                }
            }
        };
        try {
            Result.Companion companion = Result.INSTANCE;
            TicketWifiDirectTransport ticketWifiDirectTransport = this;
            int i = Build.VERSION.SDK_INT;
            BroadcastReceiver broadcastReceiver = this.receiver;
            if (i >= 33) {
                intentRegisterReceiver = context.registerReceiver(broadcastReceiver, intentFilter, 4);
            } else {
                intentRegisterReceiver = context.registerReceiver(broadcastReceiver, intentFilter);
            }
            objM9536constructorimpl = Result.m9536constructorimpl(intentRegisterReceiver);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM9536constructorimpl = Result.m9536constructorimpl(ResultKt.createFailure(th));
        }
        Throwable thM9539exceptionOrNullimpl = Result.m9539exceptionOrNullimpl(objM9536constructorimpl);
        if (thM9539exceptionOrNullimpl != null) {
            Callback callback2 = this.callback;
            if (callback2 != null) {
                String message = thM9539exceptionOrNullimpl.getMessage();
                if (message == null) {
                    message = "无法注册 Wi-Fi Direct 状态接收器";
                }
                callback2.onError(message);
                return;
            }
            return;
        }
        onReady.invoke();
    }

    private final void startServiceDiscovery() {
        WifiP2pManager.Channel channel;
        Object objM9536constructorimpl;
        Callback callback;
        WifiP2pManager wifiP2pManager = this.manager;
        if (wifiP2pManager == null || (channel = this.channel) == null) {
            return;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            TicketWifiDirectTransport ticketWifiDirectTransport = this;
            wifiP2pManager.discoverPeers(channel, new WifiP2pManager.ActionListener() { // from class: com.example.tickets.TicketWifiDirectTransport$startServiceDiscovery$1$1
                @Override // android.net.wifi.p2p.WifiP2pManager.ActionListener
                public void onSuccess() {
                }

                @Override // android.net.wifi.p2p.WifiP2pManager.ActionListener
                public void onFailure(int reason) {
                    TicketWifiDirectTransport.Callback callback2;
                    if (!this.$this_runCatching.running.get() || (callback2 = this.$this_runCatching.callback) == null) {
                        return;
                    }
                    callback2.onError("Wi-Fi Direct 搜索附近设备失败：" + reason);
                }
            });
            wifiP2pManager.requestPeers(channel, new WifiP2pManager.PeerListListener() { // from class: com.example.tickets.TicketWifiDirectTransport$startServiceDiscovery$1$2
                @Override // android.net.wifi.p2p.WifiP2pManager.PeerListListener
                public void onPeersAvailable(WifiP2pDeviceList peers) {
                    Intrinsics.checkNotNullParameter(peers, "peers");
                    if (this.$this_runCatching.running.get()) {
                        Collection<WifiP2pDevice> deviceList = peers.getDeviceList();
                        Intrinsics.checkNotNullExpressionValue(deviceList, "getDeviceList(...)");
                        ArrayList<WifiP2pDevice> arrayList = new ArrayList();
                        for (Object obj : deviceList) {
                            WifiP2pDevice wifiP2pDevice = (WifiP2pDevice) obj;
                            if (wifiP2pDevice.status == 3 || wifiP2pDevice.status == 1) {
                                arrayList.add(obj);
                            }
                        }
                        for (WifiP2pDevice wifiP2pDevice2 : arrayList) {
                            TicketWifiDirectTransport ticketWifiDirectTransport2 = this.$this_runCatching;
                            Intrinsics.checkNotNull(wifiP2pDevice2);
                            ticketWifiDirectTransport2.connectToDevice(wifiP2pDevice2);
                            if (this.$this_runCatching.connecting.get()) {
                                return;
                            }
                        }
                    }
                }
            });
            objM9536constructorimpl = Result.m9536constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM9536constructorimpl = Result.m9536constructorimpl(ResultKt.createFailure(th));
        }
        Throwable thM9539exceptionOrNullimpl = Result.m9539exceptionOrNullimpl(objM9536constructorimpl);
        if (thM9539exceptionOrNullimpl == null || (callback = this.callback) == null) {
            return;
        }
        String message = thM9539exceptionOrNullimpl.getMessage();
        if (message == null) {
            message = "Wi-Fi Direct 搜索附近设备失败";
        }
        callback.onError(message);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void connectToDevice(WifiP2pDevice device) {
        Object objM9536constructorimpl;
        if (!this.running.get() || this.connecting.getAndSet(true)) {
            return;
        }
        WifiP2pManager wifiP2pManager = this.manager;
        WifiP2pManager.Channel channel = this.channel;
        if (wifiP2pManager == null || channel == null) {
            this.connecting.set(false);
            return;
        }
        WifiP2pConfig wifiP2pConfig = new WifiP2pConfig();
        wifiP2pConfig.deviceAddress = device.deviceAddress;
        wifiP2pConfig.wps.setup = 0;
        wifiP2pConfig.groupOwnerIntent = this.serverMode ? 15 : 0;
        try {
            Result.Companion companion = Result.INSTANCE;
            TicketWifiDirectTransport ticketWifiDirectTransport = this;
            wifiP2pManager.connect(channel, wifiP2pConfig, new WifiP2pManager.ActionListener() { // from class: com.example.tickets.TicketWifiDirectTransport$connectToDevice$1$1
                @Override // android.net.wifi.p2p.WifiP2pManager.ActionListener
                public void onSuccess() {
                }

                @Override // android.net.wifi.p2p.WifiP2pManager.ActionListener
                public void onFailure(int reason) {
                    TicketWifiDirectTransport.Callback callback;
                    this.$this_runCatching.connecting.set(false);
                    if (!this.$this_runCatching.running.get() || (callback = this.$this_runCatching.callback) == null) {
                        return;
                    }
                    callback.onError("Wi-Fi Direct 建立 P2P 失败：" + reason);
                }
            });
            objM9536constructorimpl = Result.m9536constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM9536constructorimpl = Result.m9536constructorimpl(ResultKt.createFailure(th));
        }
        Throwable thM9539exceptionOrNullimpl = Result.m9539exceptionOrNullimpl(objM9536constructorimpl);
        if (thM9539exceptionOrNullimpl != null) {
            this.connecting.set(false);
            Callback callback = this.callback;
            if (callback != null) {
                String message = thM9539exceptionOrNullimpl.getMessage();
                if (message == null) {
                    message = "Wi-Fi Direct 建立 P2P 失败";
                }
                callback.onError(message);
            }
        }
    }

    private final void startServerSocket() {
        if (this.running.get()) {
            this.executor.execute(new Runnable() { // from class: com.example.tickets.TicketWifiDirectTransport$$ExternalSyntheticLambda4
                @Override // java.lang.Runnable
                public final void run() {
                    TicketWifiDirectTransport.startServerSocket$lambda$24(this.f$0);
                }
            });
        }
    }

    static final void startServerSocket$lambda$24(TicketWifiDirectTransport ticketWifiDirectTransport) {
        Object objM9536constructorimpl;
        Callback callback;
        String str;
        String str2;
        Unit unit;
        try {
            Result.Companion companion = Result.INSTANCE;
            ServerSocket serverSocket = new ServerSocket(PORT);
            ticketWifiDirectTransport.serverSocket = serverSocket;
            while (ticketWifiDirectTransport.running.get()) {
                Socket socketAccept = serverSocket.accept();
                if (!ticketWifiDirectTransport.running.get()) {
                    socketAccept.close();
                    break;
                }
                try {
                    Result.Companion companion2 = Result.INSTANCE;
                    Socket socket = ticketWifiDirectTransport.socket;
                    if (socket != null) {
                        socket.close();
                        unit = Unit.INSTANCE;
                    } else {
                        unit = null;
                    }
                    Result.m9536constructorimpl(unit);
                } catch (Throwable th) {
                    Result.Companion companion3 = Result.INSTANCE;
                    Result.m9536constructorimpl(ResultKt.createFailure(th));
                }
                ticketWifiDirectTransport.socket = socketAccept;
                if (!StringsKt.isBlank(ticketWifiDirectTransport.expectedSessionId)) {
                    str = ticketWifiDirectTransport.expectedSessionId;
                } else {
                    str = ticketWifiDirectTransport.discoveredSessionId;
                }
                if (!StringsKt.isBlank(ticketWifiDirectTransport.expectedToken)) {
                    str2 = ticketWifiDirectTransport.expectedToken;
                } else {
                    str2 = ticketWifiDirectTransport.discoveredToken;
                }
                ticketWifiDirectTransport.notifyConnectedOnce(str, str2);
                Intrinsics.checkNotNull(socketAccept);
                ticketWifiDirectTransport.readLoop(socketAccept);
                if (!ticketWifiDirectTransport.running.get()) {
                    break;
                }
            }
            objM9536constructorimpl = Result.m9536constructorimpl(Unit.INSTANCE);
        } catch (Throwable th2) {
            Result.Companion companion4 = Result.INSTANCE;
            objM9536constructorimpl = Result.m9536constructorimpl(ResultKt.createFailure(th2));
        }
        Throwable thM9539exceptionOrNullimpl = Result.m9539exceptionOrNullimpl(objM9536constructorimpl);
        if (thM9539exceptionOrNullimpl == null || !ticketWifiDirectTransport.running.get() || (callback = ticketWifiDirectTransport.callback) == null) {
            return;
        }
        String message = thM9539exceptionOrNullimpl.getMessage();
        if (message == null) {
            message = "Wi-Fi Direct TCP 服务启动失败";
        }
        callback.onError(message);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void requestConnectionInfo() {
        WifiP2pManager.Channel channel;
        Object objM9536constructorimpl;
        Callback callback;
        WifiP2pManager wifiP2pManager = this.manager;
        if (wifiP2pManager == null || (channel = this.channel) == null) {
            return;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            TicketWifiDirectTransport ticketWifiDirectTransport = this;
            wifiP2pManager.requestConnectionInfo(channel, new WifiP2pManager.ConnectionInfoListener() { // from class: com.example.tickets.TicketWifiDirectTransport$$ExternalSyntheticLambda0
                @Override // android.net.wifi.p2p.WifiP2pManager.ConnectionInfoListener
                public final void onConnectionInfoAvailable(WifiP2pInfo wifiP2pInfo) {
                    TicketWifiDirectTransport.requestConnectionInfo$lambda$27$lambda$26(this.f$0, wifiP2pInfo);
                }
            });
            objM9536constructorimpl = Result.m9536constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM9536constructorimpl = Result.m9536constructorimpl(ResultKt.createFailure(th));
        }
        Throwable thM9539exceptionOrNullimpl = Result.m9539exceptionOrNullimpl(objM9536constructorimpl);
        if (thM9539exceptionOrNullimpl == null || !this.running.get() || (callback = this.callback) == null) {
            return;
        }
        String message = thM9539exceptionOrNullimpl.getMessage();
        if (message == null) {
            message = "无法获取 Wi-Fi Direct 连接信息";
        }
        callback.onError(message);
    }

    static final void requestConnectionInfo$lambda$27$lambda$26(final TicketWifiDirectTransport ticketWifiDirectTransport, WifiP2pInfo wifiP2pInfo) {
        final InetAddress inetAddress;
        if (!ticketWifiDirectTransport.running.get() || !wifiP2pInfo.groupFormed || (inetAddress = wifiP2pInfo.groupOwnerAddress) == null || wifiP2pInfo.isGroupOwner) {
            return;
        }
        ticketWifiDirectTransport.executor.execute(new Runnable() { // from class: com.example.tickets.TicketWifiDirectTransport$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                TicketWifiDirectTransport.requestConnectionInfo$lambda$27$lambda$26$lambda$25(this.f$0, inetAddress);
            }
        });
    }

    static final void requestConnectionInfo$lambda$27$lambda$26$lambda$25(TicketWifiDirectTransport ticketWifiDirectTransport, InetAddress inetAddress) {
        String hostAddress = inetAddress.getHostAddress();
        if (hostAddress == null) {
            return;
        }
        ticketWifiDirectTransport.connectSocket(hostAddress);
    }

    private final void connectSocket(String hostAddress) {
        Object objM9536constructorimpl;
        Callback callback;
        String str;
        String str2;
        Socket socket;
        if (this.running.get()) {
            Socket socket2 = this.socket;
            if (socket2 == null || !socket2.isConnected() || (socket = this.socket) == null || socket.isClosed()) {
                try {
                    Result.Companion companion = Result.INSTANCE;
                    TicketWifiDirectTransport ticketWifiDirectTransport = this;
                    Socket socket3 = new Socket();
                    socket3.connect(new InetSocketAddress(hostAddress, PORT), AutofillUtils_androidKt.MAX_AUTOFILL_TEXT_LENGTH);
                    this.socket = socket3;
                    if (!StringsKt.isBlank(this.expectedSessionId)) {
                        str = this.expectedSessionId;
                    } else {
                        str = this.discoveredSessionId;
                    }
                    if (!StringsKt.isBlank(this.expectedToken)) {
                        str2 = this.expectedToken;
                    } else {
                        str2 = this.discoveredToken;
                    }
                    notifyConnectedOnce(str, str2);
                    readLoop(socket3);
                    objM9536constructorimpl = Result.m9536constructorimpl(Unit.INSTANCE);
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.INSTANCE;
                    objM9536constructorimpl = Result.m9536constructorimpl(ResultKt.createFailure(th));
                }
                Throwable thM9539exceptionOrNullimpl = Result.m9539exceptionOrNullimpl(objM9536constructorimpl);
                if (thM9539exceptionOrNullimpl == null || !this.running.get() || (callback = this.callback) == null) {
                    return;
                }
                String message = thM9539exceptionOrNullimpl.getMessage();
                if (message == null) {
                    message = "Wi-Fi Direct TCP 连接失败";
                }
                callback.onError(message);
            }
        }
    }

    private final void notifyConnectedOnce(String sid, String token) {
        Callback callback;
        if (!this.connectedNotified.compareAndSet(false, true) || (callback = this.callback) == null) {
            return;
        }
        callback.onConnected(sid, token);
    }

    private final void readLoop(Socket s) {
        Object objM9536constructorimpl;
        Callback callback;
        try {
            Result.Companion companion = Result.INSTANCE;
            TicketWifiDirectTransport ticketWifiDirectTransport = this;
            DataInputStream dataInputStream = new DataInputStream(new BufferedInputStream(s.getInputStream()));
            while (this.running.get() && !s.isClosed()) {
                int i = dataInputStream.readInt();
                if (i <= 0 || i > 2097152) {
                    throw new IllegalStateException("Wi-Fi Direct 数据长度无效");
                }
                byte[] bArr = new byte[i];
                dataInputStream.readFully(bArr);
                Callback callback2 = this.callback;
                if (callback2 != null) {
                    callback2.onBytesReceived(bArr);
                }
            }
            objM9536constructorimpl = Result.m9536constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM9536constructorimpl = Result.m9536constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m9539exceptionOrNullimpl(objM9536constructorimpl) == null || !this.running.get() || (callback = this.callback) == null) {
            return;
        }
        callback.onDisconnected();
    }
}
