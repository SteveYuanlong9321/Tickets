package com.example.tickets;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothServerSocket;
import android.bluetooth.BluetoothSocket;
import android.content.Context;
import android.os.Build;
import androidx.core.content.ContextCompat;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TicketBluetoothTransport.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0001\u0018\u0000 !2\u00020\u0001:\u0001!B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0017J\u0018\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u000e\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0018J&\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u001b2\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u001cH\u0016J\b\u0010\u001e\u001a\u00020\u0014H\u0016J\u0010\u0010\u001f\u001a\u00020\u00142\u0006\u0010 \u001a\u00020\rH\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n \u0010*\u0004\u0018\u00010\u000f0\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/example/tickets/TicketBluetoothTransport;", "Lcom/example/tickets/TicketTransport;", "<init>", "()V", "context", "Landroid/content/Context;", "callback", "Lcom/example/tickets/TicketTransport$Callback;", "adapter", "Landroid/bluetooth/BluetoothAdapter;", "serverSocket", "Landroid/bluetooth/BluetoothServerSocket;", "socket", "Landroid/bluetooth/BluetoothSocket;", "executor", "Ljava/util/concurrent/ExecutorService;", "kotlin.jvm.PlatformType", "running", "Ljava/util/concurrent/atomic/AtomicBoolean;", "startServer", "", "startClient", "connectToDevice", "device", "Landroid/bluetooth/BluetoothDevice;", "send", "bytes", "", "Lkotlin/Function1;", "", "stop", "readLoop", "s", "Companion", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class TicketBluetoothTransport implements TicketTransport {
    private static final int MAGIC = 1414222931;
    private static final int MAX_PACKET_SIZE = 2097152;
    private static final String SERVICE_NAME = "TicketsShare";
    private static final UUID SERVICE_UUID;
    private BluetoothAdapter adapter;
    private TicketTransport.Callback callback;
    private Context context;
    private final ExecutorService executor = Executors.newSingleThreadExecutor();
    private final AtomicBoolean running = new AtomicBoolean(false);
    private BluetoothServerSocket serverSocket;
    private BluetoothSocket socket;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    /* JADX INFO: compiled from: TicketBluetoothTransport.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u000f\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/example/tickets/TicketBluetoothTransport$Companion;", "", "<init>", "()V", "SERVICE_NAME", "", "MAGIC", "", "MAX_PACKET_SIZE", "SERVICE_UUID", "Ljava/util/UUID;", "isAvailable", "", "context", "Landroid/content/Context;", "hasRequiredPermission", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final boolean isAvailable(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return BluetoothAdapter.getDefaultAdapter() != null;
        }

        public final boolean hasRequiredPermission(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            if (Build.VERSION.SDK_INT >= 31) {
                return ContextCompat.checkSelfPermission(context, "android.permission.BLUETOOTH_CONNECT") == 0 && ContextCompat.checkSelfPermission(context, "android.permission.BLUETOOTH_SCAN") == 0;
            }
            return true;
        }
    }

    static {
        UUID uuidFromString = UUID.fromString("8D8A4B18-0D59-4BCE-9F89-9E2B7E62A7C1");
        Intrinsics.checkNotNullExpressionValue(uuidFromString, "fromString(...)");
        SERVICE_UUID = uuidFromString;
    }

    @Override // com.example.tickets.TicketTransport
    public void startServer(Context context, final TicketTransport.Callback callback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(callback, "callback");
        stop();
        if (!INSTANCE.hasRequiredPermission(context)) {
            callback.onError(TicketTransport.Kind.BLUETOOTH, "Bluetooth 缺少附近设备权限");
            return;
        }
        final BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        if (defaultAdapter == null) {
            callback.onError(TicketTransport.Kind.BLUETOOTH, "设备不支持 Bluetooth");
            return;
        }
        if (!defaultAdapter.isEnabled()) {
            callback.onError(TicketTransport.Kind.BLUETOOTH, "Bluetooth 当前未开启");
            return;
        }
        this.context = context.getApplicationContext();
        this.callback = callback;
        this.adapter = defaultAdapter;
        this.running.set(true);
        this.executor.execute(new Runnable() { // from class: com.example.tickets.TicketBluetoothTransport$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                TicketBluetoothTransport.startServer$lambda$2(this.f$0, defaultAdapter, callback);
            }
        });
    }

    static final void startServer$lambda$2(TicketBluetoothTransport ticketBluetoothTransport, BluetoothAdapter bluetoothAdapter, TicketTransport.Callback callback) {
        Object objM9536constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            BluetoothServerSocket bluetoothServerSocketListenUsingRfcommWithServiceRecord = bluetoothAdapter.listenUsingRfcommWithServiceRecord(SERVICE_NAME, SERVICE_UUID);
            ticketBluetoothTransport.serverSocket = bluetoothServerSocketListenUsingRfcommWithServiceRecord;
            callback.onReady(TicketTransport.Kind.BLUETOOTH);
            if (ticketBluetoothTransport.running.get()) {
                BluetoothSocket bluetoothSocketAccept = bluetoothServerSocketListenUsingRfcommWithServiceRecord.accept();
                ticketBluetoothTransport.socket = bluetoothSocketAccept;
                callback.onConnected(TicketTransport.Kind.BLUETOOTH);
                Intrinsics.checkNotNull(bluetoothSocketAccept);
                ticketBluetoothTransport.readLoop(bluetoothSocketAccept);
            }
            objM9536constructorimpl = Result.m9536constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM9536constructorimpl = Result.m9536constructorimpl(ResultKt.createFailure(th));
        }
        Throwable thM9539exceptionOrNullimpl = Result.m9539exceptionOrNullimpl(objM9536constructorimpl);
        if (thM9539exceptionOrNullimpl == null || !ticketBluetoothTransport.running.get()) {
            return;
        }
        TicketTransport.Kind kind = TicketTransport.Kind.BLUETOOTH;
        String message = thM9539exceptionOrNullimpl.getMessage();
        if (message == null) {
            message = "Bluetooth 服务启动失败";
        }
        callback.onError(kind, message);
    }

    @Override // com.example.tickets.TicketTransport
    public void startClient(Context context, TicketTransport.Callback callback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(callback, "callback");
        stop();
        if (!INSTANCE.hasRequiredPermission(context)) {
            callback.onError(TicketTransport.Kind.BLUETOOTH, "Bluetooth 缺少附近设备权限");
            return;
        }
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        if (defaultAdapter == null) {
            callback.onError(TicketTransport.Kind.BLUETOOTH, "设备不支持 Bluetooth");
            return;
        }
        if (!defaultAdapter.isEnabled()) {
            callback.onError(TicketTransport.Kind.BLUETOOTH, "Bluetooth 当前未开启");
            return;
        }
        this.context = context.getApplicationContext();
        this.callback = callback;
        this.adapter = defaultAdapter;
        this.running.set(true);
        callback.onReady(TicketTransport.Kind.BLUETOOTH);
    }

    public final void connectToDevice(final BluetoothDevice device) {
        Intrinsics.checkNotNullParameter(device, "device");
        if (this.running.get()) {
            this.executor.execute(new Runnable() { // from class: com.example.tickets.TicketBluetoothTransport$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    TicketBluetoothTransport.connectToDevice$lambda$6(this.f$0, device);
                }
            });
        }
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0041 A[Catch: all -> 0x0053, TryCatch #0 {all -> 0x0053, blocks: (B:2:0x0000, B:17:0x004c, B:5:0x0007, B:7:0x000d, B:13:0x0032, B:15:0x0041, B:16:0x0046, B:12:0x0029, B:9:0x001a), top: B:30:0x0000, inners: #1 }] */
    /* JADX WARN: Code duplicated, block: B:32:0x001a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    static final void connectToDevice$lambda$6(TicketBluetoothTransport ticketBluetoothTransport, BluetoothDevice bluetoothDevice) {
        Object objM9536constructorimpl;
        Throwable thM9539exceptionOrNullimpl;
        TicketTransport.Callback callback;
        TicketTransport.Callback callback2;
        try {
            Result.Companion companion = Result.INSTANCE;
            BluetoothAdapter bluetoothAdapter = ticketBluetoothTransport.adapter;
            if (bluetoothAdapter != null) {
                if (Build.VERSION.SDK_INT >= 31) {
                    Context context = ticketBluetoothTransport.context;
                    Intrinsics.checkNotNull(context);
                    if (ContextCompat.checkSelfPermission(context, "android.permission.BLUETOOTH_CONNECT") == 0) {
                        try {
                            Result.Companion companion2 = Result.INSTANCE;
                            Result.m9536constructorimpl(Boolean.valueOf(bluetoothAdapter.cancelDiscovery()));
                        } catch (Throwable th) {
                            Result.Companion companion3 = Result.INSTANCE;
                            Result.m9536constructorimpl(ResultKt.createFailure(th));
                        }
                    }
                    BluetoothSocket bluetoothSocketCreateRfcommSocketToServiceRecord = bluetoothDevice.createRfcommSocketToServiceRecord(SERVICE_UUID);
                    bluetoothSocketCreateRfcommSocketToServiceRecord.connect();
                    ticketBluetoothTransport.socket = bluetoothSocketCreateRfcommSocketToServiceRecord;
                    callback2 = ticketBluetoothTransport.callback;
                    if (callback2 != null) {
                        callback2.onConnected(TicketTransport.Kind.BLUETOOTH);
                    }
                    Intrinsics.checkNotNull(bluetoothSocketCreateRfcommSocketToServiceRecord);
                    ticketBluetoothTransport.readLoop(bluetoothSocketCreateRfcommSocketToServiceRecord);
                } else {
                    Result.Companion companion4 = Result.INSTANCE;
                    Result.m9536constructorimpl(Boolean.valueOf(bluetoothAdapter.cancelDiscovery()));
                    BluetoothSocket bluetoothSocketCreateRfcommSocketToServiceRecord2 = bluetoothDevice.createRfcommSocketToServiceRecord(SERVICE_UUID);
                    bluetoothSocketCreateRfcommSocketToServiceRecord2.connect();
                    ticketBluetoothTransport.socket = bluetoothSocketCreateRfcommSocketToServiceRecord2;
                    callback2 = ticketBluetoothTransport.callback;
                    if (callback2 != null) {
                        callback2.onConnected(TicketTransport.Kind.BLUETOOTH);
                    }
                    Intrinsics.checkNotNull(bluetoothSocketCreateRfcommSocketToServiceRecord2);
                    ticketBluetoothTransport.readLoop(bluetoothSocketCreateRfcommSocketToServiceRecord2);
                }
                thM9539exceptionOrNullimpl = Result.m9539exceptionOrNullimpl(objM9536constructorimpl);
                if (thM9539exceptionOrNullimpl != null || (callback = ticketBluetoothTransport.callback) == null) {
                }
                TicketTransport.Kind kind = TicketTransport.Kind.BLUETOOTH;
                String message = thM9539exceptionOrNullimpl.getMessage();
                if (message == null) {
                    message = "Bluetooth 连接失败";
                }
                callback.onError(kind, message);
                return;
            }
            objM9536constructorimpl = Result.m9536constructorimpl(Unit.INSTANCE);
        } catch (Throwable th2) {
            Result.Companion companion5 = Result.INSTANCE;
            objM9536constructorimpl = Result.m9536constructorimpl(ResultKt.createFailure(th2));
        }
        thM9539exceptionOrNullimpl = Result.m9539exceptionOrNullimpl(objM9536constructorimpl);
        if (thM9539exceptionOrNullimpl != null) {
        }
    }

    @Override // com.example.tickets.TicketTransport
    public void send(final byte[] bytes, final Function1<? super Boolean, Unit> callback) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        final BluetoothSocket bluetoothSocket = this.socket;
        if (bluetoothSocket != null && bluetoothSocket.isConnected()) {
            this.executor.execute(new Runnable() { // from class: com.example.tickets.TicketBluetoothTransport$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    TicketBluetoothTransport.send$lambda$8(this.f$0, callback, bluetoothSocket, bytes);
                }
            });
        } else if (callback != null) {
            callback.invoke(false);
        }
    }

    static final void send$lambda$8(TicketBluetoothTransport ticketBluetoothTransport, Function1 function1, BluetoothSocket bluetoothSocket, byte[] bArr) {
        Object objM9536constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            DataOutputStream dataOutputStream = new DataOutputStream(new BufferedOutputStream(bluetoothSocket.getOutputStream()));
            dataOutputStream.writeInt(MAGIC);
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

    @Override // com.example.tickets.TicketTransport
    public void stop() {
        Unit unit;
        Unit unit2;
        this.running.set(false);
        try {
            Result.Companion companion = Result.INSTANCE;
            TicketBluetoothTransport ticketBluetoothTransport = this;
            BluetoothSocket bluetoothSocket = this.socket;
            if (bluetoothSocket != null) {
                bluetoothSocket.close();
                unit2 = Unit.INSTANCE;
            } else {
                unit2 = null;
            }
            Result.m9536constructorimpl(unit2);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m9536constructorimpl(ResultKt.createFailure(th));
        }
        try {
            Result.Companion companion3 = Result.INSTANCE;
            TicketBluetoothTransport ticketBluetoothTransport2 = this;
            BluetoothServerSocket bluetoothServerSocket = this.serverSocket;
            if (bluetoothServerSocket != null) {
                bluetoothServerSocket.close();
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            Result.m9536constructorimpl(unit);
        } catch (Throwable th2) {
            Result.Companion companion4 = Result.INSTANCE;
            Result.m9536constructorimpl(ResultKt.createFailure(th2));
        }
        this.socket = null;
        this.serverSocket = null;
        this.adapter = null;
        this.callback = null;
        this.context = null;
    }

    private final void readLoop(BluetoothSocket s) {
        Object objM9536constructorimpl;
        TicketTransport.Callback callback;
        try {
            Result.Companion companion = Result.INSTANCE;
            TicketBluetoothTransport ticketBluetoothTransport = this;
            DataInputStream dataInputStream = new DataInputStream(new BufferedInputStream(s.getInputStream()));
            while (this.running.get() && s.isConnected()) {
                if (dataInputStream.readInt() != MAGIC) {
                    throw new IllegalStateException("Bluetooth 数据头无效");
                }
                int i = dataInputStream.readInt();
                if (i <= 0 || i > 2097152) {
                    throw new IllegalStateException("Bluetooth 数据长度无效");
                }
                byte[] bArr = new byte[i];
                dataInputStream.readFully(bArr);
                TicketTransport.Callback callback2 = this.callback;
                if (callback2 != null) {
                    callback2.onBytesReceived(TicketTransport.Kind.BLUETOOTH, bArr);
                }
            }
            objM9536constructorimpl = Result.m9536constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM9536constructorimpl = Result.m9536constructorimpl(ResultKt.createFailure(th));
        }
        Throwable thM9539exceptionOrNullimpl = Result.m9539exceptionOrNullimpl(objM9536constructorimpl);
        if (thM9539exceptionOrNullimpl == null || !this.running.get() || (callback = this.callback) == null) {
            return;
        }
        TicketTransport.Kind kind = TicketTransport.Kind.BLUETOOTH;
        String message = thM9539exceptionOrNullimpl.getMessage();
        if (message == null) {
            message = "Bluetooth 接收失败";
        }
        callback.onError(kind, message);
    }
}
