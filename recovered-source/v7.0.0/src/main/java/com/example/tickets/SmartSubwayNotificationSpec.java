package com.example.tickets;

import android.graphics.Color;
import kotlin.Metadata;

/* JADX INFO: compiled from: SmartSubwayRealtime.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u000e\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0011\u0010\u0010\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000b¨\u0006\u0012"}, d2 = {"Lcom/example/tickets/SmartSubwayNotificationSpec;", "", "<init>", "()V", "NOTIFICATION_ID", "", "CHANNEL_ID", "", "CHANNEL_NAME", "background", "getBackground", "()I", "foreground", "getForeground", "secondaryText", "getSecondaryText", "statusGreen", "getStatusGreen", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class SmartSubwayNotificationSpec {
    public static final int $stable = 0;
    public static final String CHANNEL_ID = "smart_subway_realtime";
    public static final String CHANNEL_NAME = "智能地铁 · 实时行程";
    public static final int NOTIFICATION_ID = 88001;
    public static final SmartSubwayNotificationSpec INSTANCE = new SmartSubwayNotificationSpec();
    private static final int background = Color.rgb(31, 34, 38);
    private static final int foreground = -1;
    private static final int secondaryText = Color.rgb(176, 178, 184);
    private static final int statusGreen = Color.rgb(27, 228, 188);

    private SmartSubwayNotificationSpec() {
    }

    public final int getBackground() {
        return background;
    }

    public final int getForeground() {
        return foreground;
    }

    public final int getSecondaryText() {
        return secondaryText;
    }

    public final int getStatusGreen() {
        return statusGreen;
    }
}
