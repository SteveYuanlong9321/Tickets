package com.example.tickets;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.RemoteViews;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import com.google.firebase.messaging.Constants;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: TicketWidgetProvider.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 .2\u00020\u0001:\u0002./B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J(\u0010\f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0018\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bH\u0016J*\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0010H\u0002J\u0018\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u000eH\u0002J\u0018\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u000eH\u0002J \u0010\u001c\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J \u0010\u001f\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020\u000e2\u0006\u0010!\u001a\u00020\"H\u0002J \u0010#\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020\u000e2\u0006\u0010$\u001a\u00020\u000eH\u0002J\u0018\u0010%\u001a\u00020&2\u0006\u0010 \u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u000eH\u0002J\u001f\u0010'\u001a\u00020(2\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010)\u001a\u0004\u0018\u00010\u000eH\u0002¢\u0006\u0002\u0010*J\u0012\u0010+\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\u0010\u0010,\u001a\u00020\u000e2\u0006\u0010-\u001a\u00020\"H\u0002¨\u00060"}, d2 = {"Lcom/example/tickets/TicketWidgetProvider;", "Landroid/appwidget/AppWidgetProvider;", "<init>", "()V", "onUpdate", "", "context", "Landroid/content/Context;", "appWidgetManager", "Landroid/appwidget/AppWidgetManager;", "appWidgetIds", "", "onAppWidgetOptionsChanged", "appWidgetId", "", "newOptions", "Landroid/os/Bundle;", "onDeleted", "updateWidget", "manager", "optionsOverride", "chooseLayout", "width", "height", "bindEmpty", "views", "Landroid/widget/RemoteViews;", "layoutId", "bindTicket", "ticket", "Lcom/example/tickets/TicketWidgetProvider$WidgetTicket;", "setText", "id", "text", "", "setBackgroundTint", "color", "hasView", "", "openTicketPendingIntent", "Landroid/app/PendingIntent;", "ticketId", "(Landroid/content/Context;Ljava/lang/Integer;)Landroid/app/PendingIntent;", "loadNextTicket", "ticketAccent", ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "Companion", "WidgetTicket", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class TicketWidgetProvider extends AppWidgetProvider {
    public static final String ACTION_ADD_TICKET = "com.example.tickets.widget.ADD_TICKET";
    public static final String ACTION_OPEN_WALLET = "com.example.tickets.widget.OPEN_WALLET";
    private static final String EXTRA_WIDGET_ID = "ticket_widget_id";
    private static final int HEIGHT_LARGE = 220;
    private static final int HEIGHT_STANDARD = 110;
    private static final String PREFS_KEY = "tickets_json";
    private static final String PREFS_NAME = "ticket_wallet_storage";
    private static final int WIDTH_WIDE = 250;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    /* JADX INFO: compiled from: TicketWidgetProvider.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0010\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u0011H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/example/tickets/TicketWidgetProvider$Companion;", "", "<init>", "()V", "ACTION_ADD_TICKET", "", "ACTION_OPEN_WALLET", "PREFS_NAME", "PREFS_KEY", "EXTRA_WIDGET_ID", "WIDTH_WIDE", "", "HEIGHT_STANDARD", "HEIGHT_LARGE", "updateAll", "", "context", "Landroid/content/Context;", "openWalletIntent", "Landroid/app/PendingIntent;", "addTicketIntent", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final void updateAll(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            Context applicationContext = context.getApplicationContext();
            AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(applicationContext);
            int[] appWidgetIds = appWidgetManager.getAppWidgetIds(new ComponentName(applicationContext, (Class<?>) TicketWidgetProvider.class));
            Intrinsics.checkNotNull(appWidgetIds);
            if (appWidgetIds.length == 0) {
                return;
            }
            TicketWidgetProvider ticketWidgetProvider = new TicketWidgetProvider();
            Intrinsics.checkNotNull(applicationContext);
            Intrinsics.checkNotNull(appWidgetManager);
            ticketWidgetProvider.onUpdate(applicationContext, appWidgetManager, appWidgetIds);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final PendingIntent openWalletIntent(Context context) {
            Intent intent = new Intent(context, (Class<?>) MainActivity.class);
            intent.setAction(TicketWidgetProvider.ACTION_OPEN_WALLET);
            intent.addFlags(603979776);
            PendingIntent activity = PendingIntent.getActivity(context, 9100, intent, 201326592);
            Intrinsics.checkNotNullExpressionValue(activity, "getActivity(...)");
            return activity;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final PendingIntent addTicketIntent(Context context) {
            Intent intent = new Intent(context, (Class<?>) MainActivity.class);
            intent.setAction(TicketWidgetProvider.ACTION_ADD_TICKET);
            intent.addFlags(603979776);
            PendingIntent activity = PendingIntent.getActivity(context, 9101, intent, 201326592);
            Intrinsics.checkNotNullExpressionValue(activity, "getActivity(...)");
            return activity;
        }
    }

    @Override // android.appwidget.AppWidgetProvider
    public void onAppWidgetOptionsChanged(Context context, AppWidgetManager appWidgetManager, int appWidgetId, Bundle newOptions) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(appWidgetManager, "appWidgetManager");
        Intrinsics.checkNotNullParameter(newOptions, "newOptions");
        super.onAppWidgetOptionsChanged(context, appWidgetManager, appWidgetId, newOptions);
        updateWidget(context, appWidgetManager, appWidgetId, newOptions);
    }

    @Override // android.appwidget.AppWidgetProvider
    public void onDeleted(Context context, int[] appWidgetIds) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(appWidgetIds, "appWidgetIds");
        super.onDeleted(context, appWidgetIds);
    }

    private final void updateWidget(Context context, AppWidgetManager manager, int appWidgetId, Bundle optionsOverride) {
        if (optionsOverride == null) {
            optionsOverride = manager.getAppWidgetOptions(appWidgetId);
        }
        int iChooseLayout = chooseLayout(optionsOverride.getInt("appWidgetMinWidth", 0), optionsOverride.getInt("appWidgetMinHeight", 0));
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), iChooseLayout);
        WidgetTicket widgetTicketLoadNextTicket = loadNextTicket(context);
        remoteViews.setOnClickPendingIntent(R.id.widget_root, openTicketPendingIntent(context, widgetTicketLoadNextTicket != null ? Integer.valueOf(widgetTicketLoadNextTicket.getId()) : null));
        if (hasView(R.id.widget_add, iChooseLayout)) {
            remoteViews.setOnClickPendingIntent(R.id.widget_add, INSTANCE.addTicketIntent(context));
        }
        if (widgetTicketLoadNextTicket == null) {
            bindEmpty(remoteViews, iChooseLayout);
        } else {
            bindTicket(remoteViews, iChooseLayout, widgetTicketLoadNextTicket);
        }
        manager.updateAppWidget(appWidgetId, remoteViews);
    }

    private final int chooseLayout(int width, int height) {
        if (height >= HEIGHT_LARGE) {
            return R.layout.ticket_widget_large;
        }
        if (height >= HEIGHT_STANDARD) {
            return R.layout.ticket_widget_standard;
        }
        if (width >= 250) {
            return R.layout.ticket_widget_wide;
        }
        return R.layout.ticket_widget_compact;
    }

    private final void bindEmpty(RemoteViews views, int layoutId) {
        if (layoutId == R.layout.ticket_widget_compact) {
            setText(views, R.id.widget_type, "下一张");
            setText(views, R.id.widget_title, "还没有待出行票据");
            setText(views, R.id.widget_subtitle, "添加票据后自动显示");
            setText(views, R.id.widget_date, "—");
            setText(views, R.id.widget_time, "—");
            return;
        }
        if (layoutId == R.layout.ticket_widget_wide) {
            setText(views, R.id.widget_type, "票据");
            setText(views, R.id.widget_title, "还没有待出行票据");
            setText(views, R.id.widget_route, "添加票据后自动显示最近的一张");
            setText(views, R.id.widget_date, "—");
            setText(views, R.id.widget_time, "—");
            setText(views, R.id.widget_code, "");
            setText(views, R.id.widget_brand, "票据");
            return;
        }
        if (layoutId == R.layout.ticket_widget_standard) {
            setText(views, R.id.widget_type, "票据");
            setText(views, R.id.widget_title, "还没有待出行票据");
            setText(views, R.id.widget_route, "添加票据后自动显示最近的一张");
            setText(views, R.id.widget_date, "—");
            setText(views, R.id.widget_time, "—");
            setText(views, R.id.widget_code, "");
            setText(views, R.id.widget_subtitle, "添加票据后，这里会自动显示下一张");
            setText(views, R.id.widget_brand, "票据");
            return;
        }
        setText(views, R.id.widget_type, "下一张票据");
        setText(views, R.id.widget_big_title, "暂无待使用票据");
        setText(views, R.id.widget_big_date, "添加票据后自动显示");
        setText(views, R.id.widget_big_route, "最近的一张未使用票据会出现在这里");
        setText(views, R.id.widget_big_time, "");
        setText(views, R.id.widget_big_code, "");
        setText(views, R.id.widget_brand, "票据");
    }

    private final void bindTicket(RemoteViews views, int layoutId, WidgetTicket ticket) {
        String strTypeName = ticket.typeName();
        int iTicketAccent = ticketAccent(ticket.getType());
        String strRouteOrVenue = ticket.routeOrVenue();
        String strDisplayDate = ticket.displayDate();
        String strDisplayTime = ticket.displayTime();
        String code = ticket.getCode();
        if (StringsKt.isBlank(code)) {
            code = ticket.getBrand();
        }
        String str = code;
        if (layoutId == R.layout.ticket_widget_compact) {
            setText(views, R.id.widget_type, strTypeName);
            int i = R.id.widget_title;
            String title = ticket.getTitle();
            if (!StringsKt.isBlank(title)) {
                strTypeName = title;
            }
            setText(views, i, strTypeName);
            setText(views, R.id.widget_subtitle, strRouteOrVenue);
            setText(views, R.id.widget_date, strDisplayDate);
            setText(views, R.id.widget_time, strDisplayTime);
            setBackgroundTint(views, R.id.widget_accent, iTicketAccent);
            return;
        }
        if (layoutId == R.layout.ticket_widget_wide) {
            setText(views, R.id.widget_type, strTypeName);
            int i2 = R.id.widget_title;
            String title2 = ticket.getTitle();
            if (StringsKt.isBlank(title2)) {
                title2 = strTypeName;
            }
            setText(views, i2, title2);
            setText(views, R.id.widget_route, strRouteOrVenue);
            setText(views, R.id.widget_date, strDisplayDate);
            setText(views, R.id.widget_time, strDisplayTime);
            setText(views, R.id.widget_code, str);
            int i3 = R.id.widget_brand;
            String brand = ticket.getBrand();
            if (!StringsKt.isBlank(brand)) {
                strTypeName = brand;
            }
            setText(views, i3, strTypeName);
            setBackgroundTint(views, R.id.widget_accent, iTicketAccent);
            return;
        }
        if (layoutId == R.layout.ticket_widget_standard) {
            setText(views, R.id.widget_type, strTypeName);
            int i4 = R.id.widget_title;
            String title3 = ticket.getTitle();
            if (StringsKt.isBlank(title3)) {
                title3 = strTypeName;
            }
            setText(views, i4, title3);
            setText(views, R.id.widget_route, strRouteOrVenue);
            setText(views, R.id.widget_date, strDisplayDate);
            setText(views, R.id.widget_time, strDisplayTime);
            setText(views, R.id.widget_code, str);
            setText(views, R.id.widget_subtitle, "点击打开票据详情");
            int i5 = R.id.widget_brand;
            String brand2 = ticket.getBrand();
            if (!StringsKt.isBlank(brand2)) {
                strTypeName = brand2;
            }
            setText(views, i5, strTypeName);
            setBackgroundTint(views, R.id.widget_accent, iTicketAccent);
            return;
        }
        setText(views, R.id.widget_type, strTypeName);
        int i6 = R.id.widget_big_title;
        String title4 = ticket.getTitle();
        if (StringsKt.isBlank(title4)) {
            title4 = strTypeName;
        }
        setText(views, i6, title4);
        setText(views, R.id.widget_big_date, strDisplayDate);
        setText(views, R.id.widget_big_route, strRouteOrVenue);
        setText(views, R.id.widget_big_code, str);
        setText(views, R.id.widget_big_time, strDisplayTime);
        int i7 = R.id.widget_brand;
        String brand3 = ticket.getBrand();
        if (!StringsKt.isBlank(brand3)) {
            strTypeName = brand3;
        }
        setText(views, i7, strTypeName);
        setBackgroundTint(views, R.id.widget_big_accent, iTicketAccent);
    }

    private final void setText(RemoteViews views, int id, String text) {
        try {
            views.setTextViewText(id, text);
        } catch (Exception unused) {
        }
    }

    private final void setBackgroundTint(RemoteViews views, int id, int color) {
        try {
            views.setInt(id, "setBackgroundColor", color);
        } catch (Exception unused) {
        }
    }

    private final boolean hasView(int id, int layoutId) {
        return id == R.id.widget_add && layoutId == R.layout.ticket_widget_large;
    }

    private final PendingIntent openTicketPendingIntent(Context context, Integer ticketId) {
        if (ticketId == null || ticketId.intValue() < 0) {
            return INSTANCE.openWalletIntent(context);
        }
        Intent intent = new Intent(context, (Class<?>) MainActivity.class);
        intent.setAction(LiveUpdateManager.ACTION_OPEN_TICKET_V2);
        intent.putExtra("ticket_id", ticketId.intValue());
        intent.addFlags(603979776);
        PendingIntent activity = PendingIntent.getActivity(context, ticketId.intValue() + 9200, intent, 201326592);
        Intrinsics.checkNotNullExpressionValue(activity, "getActivity(...)");
        return activity;
    }

    private final WidgetTicket loadNextTicket(Context context) {
        WidgetTicket widgetTicketFromJson;
        Object next = null;
        String string = context.getSharedPreferences(PREFS_NAME, 0).getString(PREFS_KEY, null);
        if (string == null) {
            return null;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        ArrayList arrayList = new ArrayList();
        try {
            Result.Companion companion = Result.INSTANCE;
            TicketWidgetProvider ticketWidgetProvider = this;
            JSONArray jSONArray = new JSONArray(string);
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject != null && !jSONObjectOptJSONObject.optBoolean("manuallyUsed", false) && !jSONObjectOptJSONObject.optBoolean("archived", false) && (widgetTicketFromJson = WidgetTicket.INSTANCE.fromJson(jSONObjectOptJSONObject)) != null) {
                    long jStartMillis = widgetTicketFromJson.startMillis();
                    if (jStartMillis > jCurrentTimeMillis) {
                        arrayList.add(WidgetTicket.copy$default(widgetTicketFromJson, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, jStartMillis, 65535, null));
                    }
                }
            }
            Result.m9536constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m9536constructorimpl(ResultKt.createFailure(th));
        }
        Iterator it = arrayList.iterator();
        if (it.hasNext()) {
            next = it.next();
            if (it.hasNext()) {
                long sortTime = ((WidgetTicket) next).getSortTime();
                do {
                    Object next2 = it.next();
                    long sortTime2 = ((WidgetTicket) next2).getSortTime();
                    if (sortTime > sortTime2) {
                        next = next2;
                        sortTime = sortTime2;
                    }
                } while (it.hasNext());
            }
        }
        return (WidgetTicket) next;
    }

    private final int ticketAccent(String type) {
        Locale US = Locale.US;
        Intrinsics.checkNotNullExpressionValue(US, "US");
        String upperCase = type.toUpperCase(US);
        Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
        switch (upperCase.hashCode()) {
            case -1480972311:
                return !upperCase.equals("ADMISSION") ? -7697777 : -2909612;
            case -479459735:
                return !upperCase.equals("PICKUPCODE") ? -7697777 : -6645094;
            case 66353786:
                return !upperCase.equals("EVENT") ? -7697777 : -6192681;
            case 73549584:
                return !upperCase.equals("MOVIE") ? -7697777 : -1542040;
            case 80083432:
                return !upperCase.equals("TRAIN") ? -7697777 : -10841643;
            case 105615186:
                return !upperCase.equals("AIRPLANE") ? -7697777 : -12339038;
            case 977637300:
                return !upperCase.equals("TAKEOUTCODE") ? -7697777 : -8669208;
            default:
                return -7697777;
        }
    }

    /* JADX INFO: compiled from: TicketWidgetProvider.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\t\n\u0002\b/\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0082\b\u0018\u0000 I2\u00020\u0001:\u0001IB\u0091\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\u0006\u0010\u000e\u001a\u00020\u0005\u0012\u0006\u0010\u000f\u001a\u00020\u0005\u0012\u0006\u0010\u0010\u001a\u00020\u0005\u0012\u0006\u0010\u0011\u001a\u00020\u0005\u0012\u0006\u0010\u0012\u001a\u00020\u0005\u0012\u0006\u0010\u0013\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0015¢\u0006\u0004\b\u0016\u0010\u0017J\u0006\u0010,\u001a\u00020\u0005J\u0006\u0010-\u001a\u00020\u0005J\u0006\u0010.\u001a\u00020\u0005J\u0006\u0010/\u001a\u00020\u0005J\u0006\u00100\u001a\u00020\u0015J\u0018\u00101\u001a\u00020\u00152\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005H\u0002J\t\u00102\u001a\u00020\u0003HÆ\u0003J\t\u00103\u001a\u00020\u0005HÆ\u0003J\t\u00104\u001a\u00020\u0005HÆ\u0003J\t\u00105\u001a\u00020\u0005HÆ\u0003J\t\u00106\u001a\u00020\u0005HÆ\u0003J\t\u00107\u001a\u00020\u0005HÆ\u0003J\t\u00108\u001a\u00020\u0005HÆ\u0003J\t\u00109\u001a\u00020\u0005HÆ\u0003J\t\u0010:\u001a\u00020\u0005HÆ\u0003J\t\u0010;\u001a\u00020\u0005HÆ\u0003J\t\u0010<\u001a\u00020\u0005HÆ\u0003J\t\u0010=\u001a\u00020\u0005HÆ\u0003J\t\u0010>\u001a\u00020\u0005HÆ\u0003J\t\u0010?\u001a\u00020\u0005HÆ\u0003J\t\u0010@\u001a\u00020\u0005HÆ\u0003J\t\u0010A\u001a\u00020\u0005HÆ\u0003J\t\u0010B\u001a\u00020\u0015HÆ\u0003J³\u0001\u0010C\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u00052\b\b\u0002\u0010\u0010\u001a\u00020\u00052\b\b\u0002\u0010\u0011\u001a\u00020\u00052\b\b\u0002\u0010\u0012\u001a\u00020\u00052\b\b\u0002\u0010\u0013\u001a\u00020\u00052\b\b\u0002\u0010\u0014\u001a\u00020\u0015HÆ\u0001J\u0013\u0010D\u001a\u00020E2\b\u0010F\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010G\u001a\u00020\u0003HÖ\u0001J\t\u0010H\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001bR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001bR\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001bR\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001bR\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001bR\u0011\u0010\u000b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001bR\u0011\u0010\f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001bR\u0011\u0010\r\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001bR\u0011\u0010\u000e\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001bR\u0011\u0010\u000f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001bR\u0011\u0010\u0010\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001bR\u0011\u0010\u0011\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001bR\u0011\u0010\u0012\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001bR\u0011\u0010\u0013\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001bR\u0011\u0010\u0014\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+¨\u0006J"}, d2 = {"Lcom/example/tickets/TicketWidgetProvider$WidgetTicket;", "", "id", "", ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "", "title", "code", "date", "time", "departureDate", "arrivalDate", Constants.MessagePayloadKeys.FROM, "to", "hall", "seat", "venue", "startTime", "takeoffTime", "brand", "sortTime", "", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V", "getId", "()I", "getType", "()Ljava/lang/String;", "getTitle", "getCode", "getDate", "getTime", "getDepartureDate", "getArrivalDate", "getFrom", "getTo", "getHall", "getSeat", "getVenue", "getStartTime", "getTakeoffTime", "getBrand", "getSortTime", "()J", "typeName", "routeOrVenue", "displayDate", "displayTime", "startMillis", "parseWidgetDateTime", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "copy", "equals", "", "other", "hashCode", "toString", "Companion", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
    private static final /* data */ class WidgetTicket {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final String arrivalDate;
        private final String brand;
        private final String code;
        private final String date;
        private final String departureDate;
        private final String from;
        private final String hall;
        private final int id;
        private final String seat;
        private final long sortTime;
        private final String startTime;
        private final String takeoffTime;
        private final String time;
        private final String title;
        private final String to;
        private final String type;
        private final String venue;

        public static /* synthetic */ WidgetTicket copy$default(WidgetTicket widgetTicket, int i, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, long j, int i2, Object obj) {
            long j2;
            String str16;
            String str17;
            int i3 = (i2 & 1) != 0 ? widgetTicket.id : i;
            String str18 = (i2 & 2) != 0 ? widgetTicket.type : str;
            String str19 = (i2 & 4) != 0 ? widgetTicket.title : str2;
            String str20 = (i2 & 8) != 0 ? widgetTicket.code : str3;
            String str21 = (i2 & 16) != 0 ? widgetTicket.date : str4;
            String str22 = (i2 & 32) != 0 ? widgetTicket.time : str5;
            String str23 = (i2 & 64) != 0 ? widgetTicket.departureDate : str6;
            String str24 = (i2 & 128) != 0 ? widgetTicket.arrivalDate : str7;
            String str25 = (i2 & 256) != 0 ? widgetTicket.from : str8;
            String str26 = (i2 & 512) != 0 ? widgetTicket.to : str9;
            String str27 = (i2 & 1024) != 0 ? widgetTicket.hall : str10;
            String str28 = (i2 & 2048) != 0 ? widgetTicket.seat : str11;
            String str29 = (i2 & 4096) != 0 ? widgetTicket.venue : str12;
            String str30 = (i2 & 8192) != 0 ? widgetTicket.startTime : str13;
            int i4 = i3;
            String str31 = (i2 & 16384) != 0 ? widgetTicket.takeoffTime : str14;
            String str32 = (i2 & 32768) != 0 ? widgetTicket.brand : str15;
            if ((i2 & 65536) != 0) {
                str17 = str31;
                str16 = str32;
                j2 = widgetTicket.sortTime;
            } else {
                j2 = j;
                str16 = str32;
                str17 = str31;
            }
            return widgetTicket.copy(i4, str18, str19, str20, str21, str22, str23, str24, str25, str26, str27, str28, str29, str30, str17, str16, j2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getId() {
            return this.id;
        }

        /* JADX INFO: renamed from: component10, reason: from getter */
        public final String getTo() {
            return this.to;
        }

        /* JADX INFO: renamed from: component11, reason: from getter */
        public final String getHall() {
            return this.hall;
        }

        /* JADX INFO: renamed from: component12, reason: from getter */
        public final String getSeat() {
            return this.seat;
        }

        /* JADX INFO: renamed from: component13, reason: from getter */
        public final String getVenue() {
            return this.venue;
        }

        /* JADX INFO: renamed from: component14, reason: from getter */
        public final String getStartTime() {
            return this.startTime;
        }

        /* JADX INFO: renamed from: component15, reason: from getter */
        public final String getTakeoffTime() {
            return this.takeoffTime;
        }

        /* JADX INFO: renamed from: component16, reason: from getter */
        public final String getBrand() {
            return this.brand;
        }

        /* JADX INFO: renamed from: component17, reason: from getter */
        public final long getSortTime() {
            return this.sortTime;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getType() {
            return this.type;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getCode() {
            return this.code;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final String getDate() {
            return this.date;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final String getTime() {
            return this.time;
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        public final String getDepartureDate() {
            return this.departureDate;
        }

        /* JADX INFO: renamed from: component8, reason: from getter */
        public final String getArrivalDate() {
            return this.arrivalDate;
        }

        /* JADX INFO: renamed from: component9, reason: from getter */
        public final String getFrom() {
            return this.from;
        }

        public final WidgetTicket copy(int id, String type, String title, String code, String date, String time, String departureDate, String arrivalDate, String from, String to, String hall, String seat, String venue, String startTime, String takeoffTime, String brand, long sortTime) {
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(code, "code");
            Intrinsics.checkNotNullParameter(date, "date");
            Intrinsics.checkNotNullParameter(time, "time");
            Intrinsics.checkNotNullParameter(departureDate, "departureDate");
            Intrinsics.checkNotNullParameter(arrivalDate, "arrivalDate");
            Intrinsics.checkNotNullParameter(from, "from");
            Intrinsics.checkNotNullParameter(to, "to");
            Intrinsics.checkNotNullParameter(hall, "hall");
            Intrinsics.checkNotNullParameter(seat, "seat");
            Intrinsics.checkNotNullParameter(venue, "venue");
            Intrinsics.checkNotNullParameter(startTime, "startTime");
            Intrinsics.checkNotNullParameter(takeoffTime, "takeoffTime");
            Intrinsics.checkNotNullParameter(brand, "brand");
            return new WidgetTicket(id, type, title, code, date, time, departureDate, arrivalDate, from, to, hall, seat, venue, startTime, takeoffTime, brand, sortTime);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof WidgetTicket)) {
                return false;
            }
            WidgetTicket widgetTicket = (WidgetTicket) other;
            return this.id == widgetTicket.id && Intrinsics.areEqual(this.type, widgetTicket.type) && Intrinsics.areEqual(this.title, widgetTicket.title) && Intrinsics.areEqual(this.code, widgetTicket.code) && Intrinsics.areEqual(this.date, widgetTicket.date) && Intrinsics.areEqual(this.time, widgetTicket.time) && Intrinsics.areEqual(this.departureDate, widgetTicket.departureDate) && Intrinsics.areEqual(this.arrivalDate, widgetTicket.arrivalDate) && Intrinsics.areEqual(this.from, widgetTicket.from) && Intrinsics.areEqual(this.to, widgetTicket.to) && Intrinsics.areEqual(this.hall, widgetTicket.hall) && Intrinsics.areEqual(this.seat, widgetTicket.seat) && Intrinsics.areEqual(this.venue, widgetTicket.venue) && Intrinsics.areEqual(this.startTime, widgetTicket.startTime) && Intrinsics.areEqual(this.takeoffTime, widgetTicket.takeoffTime) && Intrinsics.areEqual(this.brand, widgetTicket.brand) && this.sortTime == widgetTicket.sortTime;
        }

        public int hashCode() {
            return (((((((((((((((((((((((((((((((Integer.hashCode(this.id) * 31) + this.type.hashCode()) * 31) + this.title.hashCode()) * 31) + this.code.hashCode()) * 31) + this.date.hashCode()) * 31) + this.time.hashCode()) * 31) + this.departureDate.hashCode()) * 31) + this.arrivalDate.hashCode()) * 31) + this.from.hashCode()) * 31) + this.to.hashCode()) * 31) + this.hall.hashCode()) * 31) + this.seat.hashCode()) * 31) + this.venue.hashCode()) * 31) + this.startTime.hashCode()) * 31) + this.takeoffTime.hashCode()) * 31) + this.brand.hashCode()) * 31) + Long.hashCode(this.sortTime);
        }

        public String toString() {
            return "WidgetTicket(id=" + this.id + ", type=" + this.type + ", title=" + this.title + ", code=" + this.code + ", date=" + this.date + ", time=" + this.time + ", departureDate=" + this.departureDate + ", arrivalDate=" + this.arrivalDate + ", from=" + this.from + ", to=" + this.to + ", hall=" + this.hall + ", seat=" + this.seat + ", venue=" + this.venue + ", startTime=" + this.startTime + ", takeoffTime=" + this.takeoffTime + ", brand=" + this.brand + ", sortTime=" + this.sortTime + ")";
        }

        public WidgetTicket(int i, String type, String title, String code, String date, String time, String departureDate, String arrivalDate, String from, String to, String hall, String seat, String venue, String startTime, String takeoffTime, String brand, long j) {
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(code, "code");
            Intrinsics.checkNotNullParameter(date, "date");
            Intrinsics.checkNotNullParameter(time, "time");
            Intrinsics.checkNotNullParameter(departureDate, "departureDate");
            Intrinsics.checkNotNullParameter(arrivalDate, "arrivalDate");
            Intrinsics.checkNotNullParameter(from, "from");
            Intrinsics.checkNotNullParameter(to, "to");
            Intrinsics.checkNotNullParameter(hall, "hall");
            Intrinsics.checkNotNullParameter(seat, "seat");
            Intrinsics.checkNotNullParameter(venue, "venue");
            Intrinsics.checkNotNullParameter(startTime, "startTime");
            Intrinsics.checkNotNullParameter(takeoffTime, "takeoffTime");
            Intrinsics.checkNotNullParameter(brand, "brand");
            this.id = i;
            this.type = type;
            this.title = title;
            this.code = code;
            this.date = date;
            this.time = time;
            this.departureDate = departureDate;
            this.arrivalDate = arrivalDate;
            this.from = from;
            this.to = to;
            this.hall = hall;
            this.seat = seat;
            this.venue = venue;
            this.startTime = startTime;
            this.takeoffTime = takeoffTime;
            this.brand = brand;
            this.sortTime = j;
        }

        public /* synthetic */ WidgetTicket(int i, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, long j, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(i, str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13, str14, str15, (i2 & 65536) != 0 ? Long.MAX_VALUE : j);
        }

        public final int getId() {
            return this.id;
        }

        public final String getType() {
            return this.type;
        }

        public final String getTitle() {
            return this.title;
        }

        public final String getCode() {
            return this.code;
        }

        public final String getDate() {
            return this.date;
        }

        public final String getTime() {
            return this.time;
        }

        public final String getDepartureDate() {
            return this.departureDate;
        }

        public final String getArrivalDate() {
            return this.arrivalDate;
        }

        public final String getFrom() {
            return this.from;
        }

        public final String getTo() {
            return this.to;
        }

        public final String getHall() {
            return this.hall;
        }

        public final String getSeat() {
            return this.seat;
        }

        public final String getVenue() {
            return this.venue;
        }

        public final String getStartTime() {
            return this.startTime;
        }

        public final String getTakeoffTime() {
            return this.takeoffTime;
        }

        public final String getBrand() {
            return this.brand;
        }

        public final long getSortTime() {
            return this.sortTime;
        }

        public final String typeName() {
            String str = this.type;
            Locale US = Locale.US;
            Intrinsics.checkNotNullExpressionValue(US, "US");
            String upperCase = str.toUpperCase(US);
            Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
            switch (upperCase.hashCode()) {
                case -1480972311:
                    return !upperCase.equals("ADMISSION") ? "票据" : "门票";
                case -479459735:
                    return !upperCase.equals("PICKUPCODE") ? "票据" : "取件码";
                case 66353786:
                    return !upperCase.equals("EVENT") ? "票据" : "演出";
                case 73549584:
                    return !upperCase.equals("MOVIE") ? "票据" : "电影票";
                case 80083432:
                    return !upperCase.equals("TRAIN") ? "票据" : "车票";
                case 105615186:
                    return !upperCase.equals("AIRPLANE") ? "票据" : "机票";
                case 977637300:
                    return !upperCase.equals("TAKEOUTCODE") ? "票据" : "取餐码";
                default:
                    return "票据";
            }
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Code duplicated, block: B:74:0x0132  */
        /* JADX WARN: Code restructure failed: missing block: B:14:0x003b, code lost:
        
            if (r0.equals("AIRPLANE") == false) goto L72;
         */
        /* JADX WARN: Code restructure failed: missing block: B:17:0x0045, code lost:
        
            if (r0.equals("TRAIN") == false) goto L72;
         */
        /* JADX WARN: Code restructure failed: missing block: B:20:0x0051, code lost:
        
            if (kotlin.text.StringsKt.isBlank(r9.from) == false) goto L29;
         */
        /* JADX WARN: Code restructure failed: missing block: B:22:0x005b, code lost:
        
            if (kotlin.text.StringsKt.isBlank(r9.to) != false) goto L24;
         */
        /* JADX WARN: Code restructure failed: missing block: B:24:0x005e, code lost:
        
            r0 = r9.venue;
         */
        /* JADX WARN: Code restructure failed: missing block: B:25:0x0066, code lost:
        
            if (kotlin.text.StringsKt.isBlank(r0) == false) goto L27;
         */
        /* JADX WARN: Code restructure failed: missing block: B:26:0x0068, code lost:
        
            r0 = r9.code;
         */
        /* JADX WARN: Code restructure failed: missing block: B:28:0x006c, code lost:
        
            return r0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:29:0x006d, code lost:
        
            r0 = r9.from;
         */
        /* JADX WARN: Code restructure failed: missing block: B:30:0x0076, code lost:
        
            if (kotlin.text.StringsKt.isBlank(r0) != false) goto L32;
         */
        /* JADX WARN: Code restructure failed: missing block: B:32:0x0079, code lost:
        
            r0 = null;
         */
        /* JADX WARN: Code restructure failed: missing block: B:33:0x007a, code lost:
        
            r9 = r9.to;
         */
        /* JADX WARN: Code restructure failed: missing block: B:34:0x0083, code lost:
        
            if (kotlin.text.StringsKt.isBlank(r9) != false) goto L36;
         */
        /* JADX WARN: Code restructure failed: missing block: B:35:0x0085, code lost:
        
            r2 = r9;
         */
        /* JADX WARN: Code restructure failed: missing block: B:37:0x00a2, code lost:
        
            return kotlin.collections.CollectionsKt.joinToString$default(kotlin.collections.CollectionsKt.listOfNotNull((java.lang.Object[]) new java.lang.String[]{r0, r2}), " → ", null, null, 0, null, null, 62, null);
         */
        /* JADX WARN: Code restructure failed: missing block: B:54:0x00f5, code lost:
        
            if (r0.equals("EVENT") == false) goto L72;
         */
        /* JADX WARN: Code restructure failed: missing block: B:65:0x0116, code lost:
        
            if (r0.equals("ADMISSION") == false) goto L72;
         */
        /* JADX WARN: Code restructure failed: missing block: B:67:0x0119, code lost:
        
            r0 = r9.venue;
         */
        /* JADX WARN: Code restructure failed: missing block: B:68:0x0121, code lost:
        
            if (kotlin.text.StringsKt.isBlank(r0) == false) goto L70;
         */
        /* JADX WARN: Code restructure failed: missing block: B:69:0x0123, code lost:
        
            r0 = r9.seat;
         */
        /* JADX WARN: Code restructure failed: missing block: B:71:0x0127, code lost:
        
            return r0;
         */
        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final String routeOrVenue() {
            String str;
            String str2 = this.type;
            Locale US = Locale.US;
            Intrinsics.checkNotNullExpressionValue(US, "US");
            String upperCase = str2.toUpperCase(US);
            Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
            String str3 = null;
            switch (upperCase.hashCode()) {
                case -1480972311:
                    break;
                case -479459735:
                    if (upperCase.equals("PICKUPCODE")) {
                        String str4 = this.venue;
                        if (StringsKt.isBlank(str4)) {
                            str4 = "取件";
                        }
                        return str4;
                    }
                    str = this.venue;
                    if (StringsKt.isBlank(str)) {
                        str = "票据";
                    }
                    return str;
                case 66353786:
                    break;
                case 73549584:
                    if (upperCase.equals("MOVIE")) {
                        String str5 = this.venue;
                        if (StringsKt.isBlank(str5)) {
                            str5 = null;
                        }
                        String str6 = this.hall;
                        String strJoinToString$default = CollectionsKt.joinToString$default(CollectionsKt.listOfNotNull((Object[]) new String[]{str5, StringsKt.isBlank(str6) ? null : str6}), " · ", null, null, 0, null, null, 62, null);
                        if (StringsKt.isBlank(strJoinToString$default)) {
                            strJoinToString$default = "电影";
                        }
                        return strJoinToString$default;
                    }
                    str = this.venue;
                    if (StringsKt.isBlank(str)) {
                        str = "票据";
                    }
                    return str;
                case 80083432:
                    break;
                case 105615186:
                    break;
                case 977637300:
                    if (upperCase.equals("TAKEOUTCODE")) {
                        String str7 = this.brand;
                        if (StringsKt.isBlank(str7)) {
                            str7 = "取餐";
                        }
                        return str7;
                    }
                    str = this.venue;
                    if (StringsKt.isBlank(str)) {
                        str = "票据";
                    }
                    return str;
                default:
                    str = this.venue;
                    if (StringsKt.isBlank(str)) {
                        str = "票据";
                    }
                    return str;
            }
        }

        public final String displayDate() {
            String str;
            String str2 = this.type;
            Locale US = Locale.US;
            Intrinsics.checkNotNullExpressionValue(US, "US");
            String upperCase = str2.toUpperCase(US);
            Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
            if (Intrinsics.areEqual(upperCase, "TRAIN") || Intrinsics.areEqual(upperCase, "AIRPLANE")) {
                String str3 = this.departureDate;
                if (StringsKt.isBlank(str3)) {
                    str3 = this.date;
                }
                str = str3;
            } else {
                str = this.date;
            }
            String str4 = str;
            if (StringsKt.isBlank(str4)) {
                str4 = "日期待定";
            }
            return str4;
        }

        public final String displayTime() {
            String str;
            String str2 = this.type;
            Locale US = Locale.US;
            Intrinsics.checkNotNullExpressionValue(US, "US");
            String upperCase = str2.toUpperCase(US);
            Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
            if (Intrinsics.areEqual(upperCase, "AIRPLANE")) {
                String str3 = this.takeoffTime;
                if (StringsKt.isBlank(str3)) {
                    str3 = this.time;
                }
                str = str3;
            } else {
                String str4 = this.time;
                if (StringsKt.isBlank(str4)) {
                    str4 = this.startTime;
                }
                str = str4;
            }
            String str5 = str;
            if (StringsKt.isBlank(str5)) {
                str5 = "时间待定";
            }
            return str5;
        }

        public final long startMillis() {
            String str;
            String str2 = this.type;
            Locale US = Locale.US;
            Intrinsics.checkNotNullExpressionValue(US, "US");
            String upperCase = str2.toUpperCase(US);
            Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
            if (Intrinsics.areEqual(upperCase, "TRAIN") || Intrinsics.areEqual(upperCase, "AIRPLANE")) {
                String str3 = this.departureDate;
                if (StringsKt.isBlank(str3)) {
                    str3 = this.date;
                }
                str = str3;
            } else {
                str = this.date;
            }
            String str4 = this.type;
            Locale US2 = Locale.US;
            Intrinsics.checkNotNullExpressionValue(US2, "US");
            String upperCase2 = str4.toUpperCase(US2);
            Intrinsics.checkNotNullExpressionValue(upperCase2, "toUpperCase(...)");
            String str5 = Intrinsics.areEqual(upperCase2, "AIRPLANE") ? this.takeoffTime : this.startTime;
            if (StringsKt.isBlank(str5)) {
                str5 = this.time;
            }
            return parseWidgetDateTime(str, str5);
        }

        private final long parseWidgetDateTime(String date, String time) {
            List listListOf;
            String strReplace$default = StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.trim((CharSequence) date).toString(), "年", "-", false, 4, (Object) null), "月", "-", false, 4, (Object) null), "日", "", false, 4, (Object) null), "/", "-", false, 4, (Object) null), ".", "-", false, 4, (Object) null);
            String strReplace = new Regex("\\s+").replace(new Regex("(?i)(\\d)\\s*(AM|PM)\\b").replace(StringsKt.replace(StringsKt.replace(StringsKt.replace(StringsKt.replace(StringsKt.replace$default(StringsKt.trim((CharSequence) time).toString(), "：", ":", false, 4, (Object) null), "上午", "AM", true), "下午", "PM", true), "am", "AM", true), "pm", "PM", true), "$1 $2"), " ");
            if (!StringsKt.isBlank(strReplace$default)) {
                String str = strReplace;
                if (!StringsKt.isBlank(str)) {
                    if (new Regex("(?i).*\\b(?:AM|PM)\\b.*").matches(str)) {
                        listListOf = CollectionsKt.listOf((Object[]) new String[]{"yyyy-MM-dd h:mm a", "yyyy-M-d h:mm a", "yyyy-MM-dd hh:mm a", "yyyy-M-d hh:mm a"});
                    } else {
                        listListOf = CollectionsKt.listOf((Object[]) new String[]{"yyyy-MM-dd H:mm", "yyyy-M-d H:mm", "yyyy-MM-dd HH:mm", "yyyy-M-d HH:mm"});
                    }
                    Iterator it = listListOf.iterator();
                    while (it.hasNext()) {
                        try {
                            SimpleDateFormat simpleDateFormat = new SimpleDateFormat((String) it.next(), Locale.getDefault());
                            simpleDateFormat.setLenient(false);
                            Date date2 = simpleDateFormat.parse(strReplace$default + " " + strReplace);
                            if (date2 != null) {
                                return date2.getTime();
                            }
                            continue;
                        } catch (Exception unused) {
                        }
                    }
                }
            }
            return Long.MAX_VALUE;
        }

        /* JADX INFO: compiled from: TicketWidgetProvider.kt */
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/example/tickets/TicketWidgetProvider$WidgetTicket$Companion;", "", "<init>", "()V", "fromJson", "Lcom/example/tickets/TicketWidgetProvider$WidgetTicket;", "obj", "Lorg/json/JSONObject;", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final WidgetTicket fromJson(JSONObject obj) {
                Intrinsics.checkNotNullParameter(obj, "obj");
                int iOptInt = obj.optInt("id", -1);
                if (iOptInt < 0) {
                    return null;
                }
                String strOptString = obj.optString(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY);
                Intrinsics.checkNotNullExpressionValue(strOptString, "optString(...)");
                String strOptString2 = obj.optString("title");
                Intrinsics.checkNotNullExpressionValue(strOptString2, "optString(...)");
                String strOptString3 = obj.optString("code");
                Intrinsics.checkNotNullExpressionValue(strOptString3, "optString(...)");
                String strOptString4 = obj.optString("date");
                Intrinsics.checkNotNullExpressionValue(strOptString4, "optString(...)");
                String strOptString5 = obj.optString("time");
                Intrinsics.checkNotNullExpressionValue(strOptString5, "optString(...)");
                String strOptString6 = obj.optString("departureDate");
                Intrinsics.checkNotNullExpressionValue(strOptString6, "optString(...)");
                String strOptString7 = obj.optString("arrivalDate");
                Intrinsics.checkNotNullExpressionValue(strOptString7, "optString(...)");
                String strOptString8 = obj.optString(Constants.MessagePayloadKeys.FROM);
                Intrinsics.checkNotNullExpressionValue(strOptString8, "optString(...)");
                String strOptString9 = obj.optString("to");
                Intrinsics.checkNotNullExpressionValue(strOptString9, "optString(...)");
                String strOptString10 = obj.optString("hall");
                Intrinsics.checkNotNullExpressionValue(strOptString10, "optString(...)");
                String strOptString11 = obj.optString("seat");
                Intrinsics.checkNotNullExpressionValue(strOptString11, "optString(...)");
                String strOptString12 = obj.optString("venue");
                Intrinsics.checkNotNullExpressionValue(strOptString12, "optString(...)");
                String strOptString13 = obj.optString("startTime");
                Intrinsics.checkNotNullExpressionValue(strOptString13, "optString(...)");
                String strOptString14 = obj.optString("takeoffTime");
                Intrinsics.checkNotNullExpressionValue(strOptString14, "optString(...)");
                String strOptString15 = obj.optString("brand");
                Intrinsics.checkNotNullExpressionValue(strOptString15, "optString(...)");
                return new WidgetTicket(iOptInt, strOptString, strOptString2, strOptString3, strOptString4, strOptString5, strOptString6, strOptString7, strOptString8, strOptString9, strOptString10, strOptString11, strOptString12, strOptString13, strOptString14, strOptString15, 0L, 65536, null);
            }
        }
    }

    @Override // android.appwidget.AppWidgetProvider
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(appWidgetManager, "appWidgetManager");
        Intrinsics.checkNotNullParameter(appWidgetIds, "appWidgetIds");
        for (int i : appWidgetIds) {
            updateWidget(context, appWidgetManager, i, null);
        }
    }
}
