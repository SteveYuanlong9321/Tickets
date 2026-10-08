package com.example.tickets;

import android.os.Build;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: compiled from: TicketsShareScreens.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0011\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/example/tickets/TicketSharePermissions;", "", "<init>", "()V", "requiredPermissions", "", "", "()[Ljava/lang/String;", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
final class TicketSharePermissions {
    public static final TicketSharePermissions INSTANCE = new TicketSharePermissions();

    private TicketSharePermissions() {
    }

    public final String[] requiredPermissions() {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = arrayList;
        arrayList2.add("android.permission.ACCESS_COARSE_LOCATION");
        arrayList2.add("android.permission.ACCESS_FINE_LOCATION");
        if (Build.VERSION.SDK_INT >= 31) {
            arrayList2.add("android.permission.BLUETOOTH_SCAN");
            arrayList2.add("android.permission.BLUETOOTH_CONNECT");
            arrayList2.add("android.permission.BLUETOOTH_ADVERTISE");
        }
        if (Build.VERSION.SDK_INT >= 33) {
            arrayList2.add("android.permission.NEARBY_WIFI_DEVICES");
        }
        return (String[]) CollectionsKt.distinct(arrayList).toArray(new String[0]);
    }
}
