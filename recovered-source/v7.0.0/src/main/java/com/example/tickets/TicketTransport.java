package com.example.tickets;

import android.content.Context;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TicketTransport.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\b`\u0018\u00002\u00020\u0001:\u0004\u000f\u0010\u0011\u0012J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J(\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0003\u0018\u00010\fH&J\b\u0010\u000e\u001a\u00020\u0003H&¨\u0006\u0013À\u0006\u0003"}, d2 = {"Lcom/example/tickets/TicketTransport;", "", "startServer", "", "context", "Landroid/content/Context;", "callback", "Lcom/example/tickets/TicketTransport$Callback;", "startClient", "send", "bytes", "", "Lkotlin/Function1;", "", "stop", "Kind", "Role", "Result", "Callback", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface TicketTransport {

    /* JADX INFO: compiled from: TicketTransport.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH&J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fH&J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u000eÀ\u0006\u0003"}, d2 = {"Lcom/example/tickets/TicketTransport$Callback;", "", "onReady", "", "kind", "Lcom/example/tickets/TicketTransport$Kind;", "onConnected", "onBytesReceived", "bytes", "", "onError", "message", "", "onDisconnected", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public interface Callback {
        void onBytesReceived(Kind kind, byte[] bytes);

        void onConnected(Kind kind);

        void onDisconnected(Kind kind);

        void onError(Kind kind, String message);

        void onReady(Kind kind);
    }

    /* JADX INFO: compiled from: TicketTransport.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/example/tickets/TicketTransport$Kind;", "", "<init>", "(Ljava/lang/String;I)V", "NEARBY", "WIFI_DIRECT", "BLUETOOTH", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public enum Kind {
        NEARBY,
        WIFI_DIRECT,
        BLUETOOTH;

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

        public static EnumEntries<Kind> getEntries() {
            return $ENTRIES;
        }
    }

    /* JADX INFO: compiled from: TicketTransport.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/example/tickets/TicketTransport$Role;", "", "<init>", "(Ljava/lang/String;I)V", "SERVER", "CLIENT", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public enum Role {
        SERVER,
        CLIENT;

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

        public static EnumEntries<Role> getEntries() {
            return $ENTRIES;
        }
    }

    void send(byte[] bytes, Function1<? super Boolean, Unit> callback);

    void startClient(Context context, Callback callback);

    void startServer(Context context, Callback callback);

    void stop();

    /* JADX INFO: compiled from: TicketTransport.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0019"}, d2 = {"Lcom/example/tickets/TicketTransport$Result;", "", "kind", "Lcom/example/tickets/TicketTransport$Kind;", "success", "", "message", "", "<init>", "(Lcom/example/tickets/TicketTransport$Kind;ZLjava/lang/String;)V", "getKind", "()Lcom/example/tickets/TicketTransport$Kind;", "getSuccess", "()Z", "getMessage", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Result {
        public static final int $stable = 0;
        private final Kind kind;
        private final String message;
        private final boolean success;

        public static /* synthetic */ Result copy$default(Result result, Kind kind, boolean z, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                kind = result.kind;
            }
            if ((i & 2) != 0) {
                z = result.success;
            }
            if ((i & 4) != 0) {
                str = result.message;
            }
            return result.copy(kind, z, str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Kind getKind() {
            return this.kind;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final boolean getSuccess() {
            return this.success;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getMessage() {
            return this.message;
        }

        public final Result copy(Kind kind, boolean success, String message) {
            Intrinsics.checkNotNullParameter(kind, "kind");
            Intrinsics.checkNotNullParameter(message, "message");
            return new Result(kind, success, message);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Result)) {
                return false;
            }
            Result result = (Result) other;
            return this.kind == result.kind && this.success == result.success && Intrinsics.areEqual(this.message, result.message);
        }

        public int hashCode() {
            return (((this.kind.hashCode() * 31) + Boolean.hashCode(this.success)) * 31) + this.message.hashCode();
        }

        public String toString() {
            return "Result(kind=" + this.kind + ", success=" + this.success + ", message=" + this.message + ")";
        }

        public Result(Kind kind, boolean z, String message) {
            Intrinsics.checkNotNullParameter(kind, "kind");
            Intrinsics.checkNotNullParameter(message, "message");
            this.kind = kind;
            this.success = z;
            this.message = message;
        }

        public final Kind getKind() {
            return this.kind;
        }

        public final boolean getSuccess() {
            return this.success;
        }

        public /* synthetic */ Result(Kind kind, boolean z, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(kind, z, (i & 4) != 0 ? "" : str);
        }

        public final String getMessage() {
            return this.message;
        }
    }

    /* JADX INFO: compiled from: TicketTransport.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class DefaultImpls {
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void send$default(TicketTransport ticketTransport, byte[] bArr, Function1 function1, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: send");
        }
        if ((i & 2) != 0) {
            function1 = null;
        }
        ticketTransport.send(bArr, function1);
    }
}
