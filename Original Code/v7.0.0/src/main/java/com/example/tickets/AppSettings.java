package com.example.tickets;

import androidx.compose.runtime.composer.linkbuffer.GroupFlagsKt;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MainActivity.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\"\n\u0002\bI\n\u0002\u0010\b\n\u0002\b\u0002\b\u0081\b\u0018\u00002\u00020\u0001B¯\u0002\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\r\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00050\u001b\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0003\u0012\b\b\u0002\u0010 \u001a\u00020\u0003\u0012\b\b\u0002\u0010!\u001a\u00020\u0003¢\u0006\u0004\b\"\u0010#J\t\u0010D\u001a\u00020\u0003HÆ\u0003J\t\u0010E\u001a\u00020\u0005HÆ\u0003J\t\u0010F\u001a\u00020\u0005HÆ\u0003J\t\u0010G\u001a\u00020\u0005HÆ\u0003J\t\u0010H\u001a\u00020\u0005HÆ\u0003J\t\u0010I\u001a\u00020\u0005HÆ\u0003J\t\u0010J\u001a\u00020\u0005HÆ\u0003J\t\u0010K\u001a\u00020\u0005HÆ\u0003J\t\u0010L\u001a\u00020\u0005HÆ\u0003J\t\u0010M\u001a\u00020\u0005HÆ\u0003J\t\u0010N\u001a\u00020\u0003HÆ\u0003J\t\u0010O\u001a\u00020\u0005HÆ\u0003J\t\u0010P\u001a\u00020\u0005HÆ\u0003J\t\u0010Q\u001a\u00020\u0005HÆ\u0003J\t\u0010R\u001a\u00020\u0005HÆ\u0003J\t\u0010S\u001a\u00020\u0003HÆ\u0003J\t\u0010T\u001a\u00020\u0005HÆ\u0003J\t\u0010U\u001a\u00020\u0005HÆ\u0003J\t\u0010V\u001a\u00020\u0005HÆ\u0003J\t\u0010W\u001a\u00020\u0005HÆ\u0003J\t\u0010X\u001a\u00020\u0005HÆ\u0003J\t\u0010Y\u001a\u00020\u0005HÆ\u0003J\u000f\u0010Z\u001a\b\u0012\u0004\u0012\u00020\u00050\u001bHÆ\u0003J\t\u0010[\u001a\u00020\u0005HÆ\u0003J\t\u0010\\\u001a\u00020\u0003HÆ\u0003J\t\u0010]\u001a\u00020\u0003HÆ\u0003J\t\u0010^\u001a\u00020\u0003HÆ\u0003J\t\u0010_\u001a\u00020\u0003HÆ\u0003J\t\u0010`\u001a\u00020\u0003HÆ\u0003J±\u0002\u0010a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00052\b\b\u0002\u0010\u0010\u001a\u00020\u00052\b\b\u0002\u0010\u0011\u001a\u00020\u00052\b\b\u0002\u0010\u0012\u001a\u00020\u00052\b\b\u0002\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u00052\b\b\u0002\u0010\u0015\u001a\u00020\u00052\b\b\u0002\u0010\u0016\u001a\u00020\u00052\b\b\u0002\u0010\u0017\u001a\u00020\u00052\b\b\u0002\u0010\u0018\u001a\u00020\u00052\b\b\u0002\u0010\u0019\u001a\u00020\u00052\u000e\b\u0002\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00050\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u00052\b\b\u0002\u0010\u001d\u001a\u00020\u00032\b\b\u0002\u0010\u001e\u001a\u00020\u00032\b\b\u0002\u0010\u001f\u001a\u00020\u00032\b\b\u0002\u0010 \u001a\u00020\u00032\b\b\u0002\u0010!\u001a\u00020\u0003HÆ\u0001J\u0013\u0010b\u001a\u00020\u00032\b\u0010c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010d\u001a\u00020eHÖ\u0001J\t\u0010f\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b(\u0010'R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b)\u0010'R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b*\u0010'R\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b+\u0010'R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b,\u0010'R\u0011\u0010\u000b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b-\u0010'R\u0011\u0010\f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b.\u0010'R\u0011\u0010\r\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b/\u0010'R\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b0\u0010%R\u0011\u0010\u000f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b1\u0010'R\u0011\u0010\u0010\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b2\u0010'R\u0011\u0010\u0011\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b3\u0010'R\u0011\u0010\u0012\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b4\u0010'R\u0011\u0010\u0013\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b5\u0010%R\u0011\u0010\u0014\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b6\u0010'R\u0011\u0010\u0015\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b7\u0010'R\u0011\u0010\u0016\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b8\u0010'R\u0011\u0010\u0017\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b9\u0010'R\u0011\u0010\u0018\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b:\u0010'R\u0011\u0010\u0019\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b;\u0010'R\u0017\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00050\u001b¢\u0006\b\n\u0000\u001a\u0004\b<\u0010=R\u0011\u0010\u001c\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b>\u0010'R\u0011\u0010\u001d\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b?\u0010%R\u0011\u0010\u001e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b@\u0010%R\u0011\u0010\u001f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bA\u0010%R\u0011\u0010 \u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bB\u0010%R\u0011\u0010!\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bC\u0010%¨\u0006g"}, d2 = {"Lcom/example/tickets/AppSettings;", "", "darkTheme", "", "fontSize", "", "ticketCardStyle", "walletName", "sortRule", "expiredTicketsInWallet", "autoArchivePolicy", "viewMode", "density", "smartSubwayRecentTrips", "reminderEnabled", "defaultReminder", "flightReminder", "trainReminder", "eventReminder", "ocrEnabled", "recognitionMode", "onlineProvider", "onlineModel", "onlineApiKey", "onlinePrompt", "ocrAccuracy", "ocrFields", "", "integrationMode", "liveUpdate", "superIsland", "samsungNowBar", "fcmReminderEnabled", "fcmIntegrationEnabled", "<init>", "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Set;Ljava/lang/String;ZZZZZ)V", "getDarkTheme", "()Z", "getFontSize", "()Ljava/lang/String;", "getTicketCardStyle", "getWalletName", "getSortRule", "getExpiredTicketsInWallet", "getAutoArchivePolicy", "getViewMode", "getDensity", "getSmartSubwayRecentTrips", "getReminderEnabled", "getDefaultReminder", "getFlightReminder", "getTrainReminder", "getEventReminder", "getOcrEnabled", "getRecognitionMode", "getOnlineProvider", "getOnlineModel", "getOnlineApiKey", "getOnlinePrompt", "getOcrAccuracy", "getOcrFields", "()Ljava/util/Set;", "getIntegrationMode", "getLiveUpdate", "getSuperIsland", "getSamsungNowBar", "getFcmReminderEnabled", "getFcmIntegrationEnabled", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "copy", "equals", "other", "hashCode", "", "toString", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class AppSettings {
    public static final int $stable = 8;
    private final String autoArchivePolicy;
    private final boolean darkTheme;
    private final String defaultReminder;
    private final String density;
    private final String eventReminder;
    private final String expiredTicketsInWallet;
    private final boolean fcmIntegrationEnabled;
    private final boolean fcmReminderEnabled;
    private final String flightReminder;
    private final String fontSize;
    private final String integrationMode;
    private final boolean liveUpdate;
    private final String ocrAccuracy;
    private final boolean ocrEnabled;
    private final Set<String> ocrFields;
    private final String onlineApiKey;
    private final String onlineModel;
    private final String onlinePrompt;
    private final String onlineProvider;
    private final String recognitionMode;
    private final boolean reminderEnabled;
    private final boolean samsungNowBar;
    private final String smartSubwayRecentTrips;
    private final String sortRule;
    private final boolean superIsland;
    private final String ticketCardStyle;
    private final String trainReminder;
    private final String viewMode;
    private final String walletName;

    public AppSettings() {
        this(false, null, null, null, null, null, null, null, null, null, false, null, null, null, null, false, null, null, null, null, null, null, null, null, false, false, false, false, false, 536870911, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AppSettings copy$default(AppSettings appSettings, boolean z, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, boolean z2, String str10, String str11, String str12, String str13, boolean z3, String str14, String str15, String str16, String str17, String str18, String str19, Set set, String str20, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, int i, Object obj) {
        boolean z9;
        boolean z10;
        boolean z11 = (i & 1) != 0 ? appSettings.darkTheme : z;
        String str21 = (i & 2) != 0 ? appSettings.fontSize : str;
        String str22 = (i & 4) != 0 ? appSettings.ticketCardStyle : str2;
        String str23 = (i & 8) != 0 ? appSettings.walletName : str3;
        String str24 = (i & 16) != 0 ? appSettings.sortRule : str4;
        String str25 = (i & 32) != 0 ? appSettings.expiredTicketsInWallet : str5;
        String str26 = (i & 64) != 0 ? appSettings.autoArchivePolicy : str6;
        String str27 = (i & 128) != 0 ? appSettings.viewMode : str7;
        String str28 = (i & 256) != 0 ? appSettings.density : str8;
        String str29 = (i & 512) != 0 ? appSettings.smartSubwayRecentTrips : str9;
        boolean z12 = (i & 1024) != 0 ? appSettings.reminderEnabled : z2;
        String str30 = (i & 2048) != 0 ? appSettings.defaultReminder : str10;
        String str31 = (i & 4096) != 0 ? appSettings.flightReminder : str11;
        String str32 = (i & 8192) != 0 ? appSettings.trainReminder : str12;
        boolean z13 = z11;
        String str33 = (i & 16384) != 0 ? appSettings.eventReminder : str13;
        boolean z14 = (i & 32768) != 0 ? appSettings.ocrEnabled : z3;
        String str34 = (i & 65536) != 0 ? appSettings.recognitionMode : str14;
        String str35 = (i & 131072) != 0 ? appSettings.onlineProvider : str15;
        String str36 = (i & 262144) != 0 ? appSettings.onlineModel : str16;
        String str37 = (i & 524288) != 0 ? appSettings.onlineApiKey : str17;
        String str38 = (i & 1048576) != 0 ? appSettings.onlinePrompt : str18;
        String str39 = (i & 2097152) != 0 ? appSettings.ocrAccuracy : str19;
        Set set2 = (i & 4194304) != 0 ? appSettings.ocrFields : set;
        String str40 = (i & 8388608) != 0 ? appSettings.integrationMode : str20;
        boolean z15 = (i & 16777216) != 0 ? appSettings.liveUpdate : z4;
        boolean z16 = (i & GroupFlagsKt.HasAuxSlotFlag) != 0 ? appSettings.superIsland : z5;
        boolean z17 = (i & 67108864) != 0 ? appSettings.samsungNowBar : z6;
        boolean z18 = (i & GroupFlagsKt.HasRecompositionRequiredFlag) != 0 ? appSettings.fcmReminderEnabled : z7;
        if ((i & GroupFlagsKt.IsMovableContentFlag) != 0) {
            z10 = z18;
            z9 = appSettings.fcmIntegrationEnabled;
        } else {
            z9 = z8;
            z10 = z18;
        }
        return appSettings.copy(z13, str21, str22, str23, str24, str25, str26, str27, str28, str29, z12, str30, str31, str32, str33, z14, str34, str35, str36, str37, str38, str39, set2, str40, z15, z16, z17, z10, z9);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getDarkTheme() {
        return this.darkTheme;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final String getSmartSubwayRecentTrips() {
        return this.smartSubwayRecentTrips;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final boolean getReminderEnabled() {
        return this.reminderEnabled;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final String getDefaultReminder() {
        return this.defaultReminder;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final String getFlightReminder() {
        return this.flightReminder;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final String getTrainReminder() {
        return this.trainReminder;
    }

    /* JADX INFO: renamed from: component15, reason: from getter */
    public final String getEventReminder() {
        return this.eventReminder;
    }

    /* JADX INFO: renamed from: component16, reason: from getter */
    public final boolean getOcrEnabled() {
        return this.ocrEnabled;
    }

    /* JADX INFO: renamed from: component17, reason: from getter */
    public final String getRecognitionMode() {
        return this.recognitionMode;
    }

    /* JADX INFO: renamed from: component18, reason: from getter */
    public final String getOnlineProvider() {
        return this.onlineProvider;
    }

    /* JADX INFO: renamed from: component19, reason: from getter */
    public final String getOnlineModel() {
        return this.onlineModel;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getFontSize() {
        return this.fontSize;
    }

    /* JADX INFO: renamed from: component20, reason: from getter */
    public final String getOnlineApiKey() {
        return this.onlineApiKey;
    }

    /* JADX INFO: renamed from: component21, reason: from getter */
    public final String getOnlinePrompt() {
        return this.onlinePrompt;
    }

    /* JADX INFO: renamed from: component22, reason: from getter */
    public final String getOcrAccuracy() {
        return this.ocrAccuracy;
    }

    public final Set<String> component23() {
        return this.ocrFields;
    }

    /* JADX INFO: renamed from: component24, reason: from getter */
    public final String getIntegrationMode() {
        return this.integrationMode;
    }

    /* JADX INFO: renamed from: component25, reason: from getter */
    public final boolean getLiveUpdate() {
        return this.liveUpdate;
    }

    /* JADX INFO: renamed from: component26, reason: from getter */
    public final boolean getSuperIsland() {
        return this.superIsland;
    }

    /* JADX INFO: renamed from: component27, reason: from getter */
    public final boolean getSamsungNowBar() {
        return this.samsungNowBar;
    }

    /* JADX INFO: renamed from: component28, reason: from getter */
    public final boolean getFcmReminderEnabled() {
        return this.fcmReminderEnabled;
    }

    /* JADX INFO: renamed from: component29, reason: from getter */
    public final boolean getFcmIntegrationEnabled() {
        return this.fcmIntegrationEnabled;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getTicketCardStyle() {
        return this.ticketCardStyle;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getWalletName() {
        return this.walletName;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getSortRule() {
        return this.sortRule;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getExpiredTicketsInWallet() {
        return this.expiredTicketsInWallet;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getAutoArchivePolicy() {
        return this.autoArchivePolicy;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getViewMode() {
        return this.viewMode;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getDensity() {
        return this.density;
    }

    public final AppSettings copy(boolean darkTheme, String fontSize, String ticketCardStyle, String walletName, String sortRule, String expiredTicketsInWallet, String autoArchivePolicy, String viewMode, String density, String smartSubwayRecentTrips, boolean reminderEnabled, String defaultReminder, String flightReminder, String trainReminder, String eventReminder, boolean ocrEnabled, String recognitionMode, String onlineProvider, String onlineModel, String onlineApiKey, String onlinePrompt, String ocrAccuracy, Set<String> ocrFields, String integrationMode, boolean liveUpdate, boolean superIsland, boolean samsungNowBar, boolean fcmReminderEnabled, boolean fcmIntegrationEnabled) {
        Intrinsics.checkNotNullParameter(fontSize, "fontSize");
        Intrinsics.checkNotNullParameter(ticketCardStyle, "ticketCardStyle");
        Intrinsics.checkNotNullParameter(walletName, "walletName");
        Intrinsics.checkNotNullParameter(sortRule, "sortRule");
        Intrinsics.checkNotNullParameter(expiredTicketsInWallet, "expiredTicketsInWallet");
        Intrinsics.checkNotNullParameter(autoArchivePolicy, "autoArchivePolicy");
        Intrinsics.checkNotNullParameter(viewMode, "viewMode");
        Intrinsics.checkNotNullParameter(density, "density");
        Intrinsics.checkNotNullParameter(smartSubwayRecentTrips, "smartSubwayRecentTrips");
        Intrinsics.checkNotNullParameter(defaultReminder, "defaultReminder");
        Intrinsics.checkNotNullParameter(flightReminder, "flightReminder");
        Intrinsics.checkNotNullParameter(trainReminder, "trainReminder");
        Intrinsics.checkNotNullParameter(eventReminder, "eventReminder");
        Intrinsics.checkNotNullParameter(recognitionMode, "recognitionMode");
        Intrinsics.checkNotNullParameter(onlineProvider, "onlineProvider");
        Intrinsics.checkNotNullParameter(onlineModel, "onlineModel");
        Intrinsics.checkNotNullParameter(onlineApiKey, "onlineApiKey");
        Intrinsics.checkNotNullParameter(onlinePrompt, "onlinePrompt");
        Intrinsics.checkNotNullParameter(ocrAccuracy, "ocrAccuracy");
        Intrinsics.checkNotNullParameter(ocrFields, "ocrFields");
        Intrinsics.checkNotNullParameter(integrationMode, "integrationMode");
        return new AppSettings(darkTheme, fontSize, ticketCardStyle, walletName, sortRule, expiredTicketsInWallet, autoArchivePolicy, viewMode, density, smartSubwayRecentTrips, reminderEnabled, defaultReminder, flightReminder, trainReminder, eventReminder, ocrEnabled, recognitionMode, onlineProvider, onlineModel, onlineApiKey, onlinePrompt, ocrAccuracy, ocrFields, integrationMode, liveUpdate, superIsland, samsungNowBar, fcmReminderEnabled, fcmIntegrationEnabled);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AppSettings)) {
            return false;
        }
        AppSettings appSettings = (AppSettings) other;
        return this.darkTheme == appSettings.darkTheme && Intrinsics.areEqual(this.fontSize, appSettings.fontSize) && Intrinsics.areEqual(this.ticketCardStyle, appSettings.ticketCardStyle) && Intrinsics.areEqual(this.walletName, appSettings.walletName) && Intrinsics.areEqual(this.sortRule, appSettings.sortRule) && Intrinsics.areEqual(this.expiredTicketsInWallet, appSettings.expiredTicketsInWallet) && Intrinsics.areEqual(this.autoArchivePolicy, appSettings.autoArchivePolicy) && Intrinsics.areEqual(this.viewMode, appSettings.viewMode) && Intrinsics.areEqual(this.density, appSettings.density) && Intrinsics.areEqual(this.smartSubwayRecentTrips, appSettings.smartSubwayRecentTrips) && this.reminderEnabled == appSettings.reminderEnabled && Intrinsics.areEqual(this.defaultReminder, appSettings.defaultReminder) && Intrinsics.areEqual(this.flightReminder, appSettings.flightReminder) && Intrinsics.areEqual(this.trainReminder, appSettings.trainReminder) && Intrinsics.areEqual(this.eventReminder, appSettings.eventReminder) && this.ocrEnabled == appSettings.ocrEnabled && Intrinsics.areEqual(this.recognitionMode, appSettings.recognitionMode) && Intrinsics.areEqual(this.onlineProvider, appSettings.onlineProvider) && Intrinsics.areEqual(this.onlineModel, appSettings.onlineModel) && Intrinsics.areEqual(this.onlineApiKey, appSettings.onlineApiKey) && Intrinsics.areEqual(this.onlinePrompt, appSettings.onlinePrompt) && Intrinsics.areEqual(this.ocrAccuracy, appSettings.ocrAccuracy) && Intrinsics.areEqual(this.ocrFields, appSettings.ocrFields) && Intrinsics.areEqual(this.integrationMode, appSettings.integrationMode) && this.liveUpdate == appSettings.liveUpdate && this.superIsland == appSettings.superIsland && this.samsungNowBar == appSettings.samsungNowBar && this.fcmReminderEnabled == appSettings.fcmReminderEnabled && this.fcmIntegrationEnabled == appSettings.fcmIntegrationEnabled;
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((((((((((((((((((((((((((((Boolean.hashCode(this.darkTheme) * 31) + this.fontSize.hashCode()) * 31) + this.ticketCardStyle.hashCode()) * 31) + this.walletName.hashCode()) * 31) + this.sortRule.hashCode()) * 31) + this.expiredTicketsInWallet.hashCode()) * 31) + this.autoArchivePolicy.hashCode()) * 31) + this.viewMode.hashCode()) * 31) + this.density.hashCode()) * 31) + this.smartSubwayRecentTrips.hashCode()) * 31) + Boolean.hashCode(this.reminderEnabled)) * 31) + this.defaultReminder.hashCode()) * 31) + this.flightReminder.hashCode()) * 31) + this.trainReminder.hashCode()) * 31) + this.eventReminder.hashCode()) * 31) + Boolean.hashCode(this.ocrEnabled)) * 31) + this.recognitionMode.hashCode()) * 31) + this.onlineProvider.hashCode()) * 31) + this.onlineModel.hashCode()) * 31) + this.onlineApiKey.hashCode()) * 31) + this.onlinePrompt.hashCode()) * 31) + this.ocrAccuracy.hashCode()) * 31) + this.ocrFields.hashCode()) * 31) + this.integrationMode.hashCode()) * 31) + Boolean.hashCode(this.liveUpdate)) * 31) + Boolean.hashCode(this.superIsland)) * 31) + Boolean.hashCode(this.samsungNowBar)) * 31) + Boolean.hashCode(this.fcmReminderEnabled)) * 31) + Boolean.hashCode(this.fcmIntegrationEnabled);
    }

    public String toString() {
        return "AppSettings(darkTheme=" + this.darkTheme + ", fontSize=" + this.fontSize + ", ticketCardStyle=" + this.ticketCardStyle + ", walletName=" + this.walletName + ", sortRule=" + this.sortRule + ", expiredTicketsInWallet=" + this.expiredTicketsInWallet + ", autoArchivePolicy=" + this.autoArchivePolicy + ", viewMode=" + this.viewMode + ", density=" + this.density + ", smartSubwayRecentTrips=" + this.smartSubwayRecentTrips + ", reminderEnabled=" + this.reminderEnabled + ", defaultReminder=" + this.defaultReminder + ", flightReminder=" + this.flightReminder + ", trainReminder=" + this.trainReminder + ", eventReminder=" + this.eventReminder + ", ocrEnabled=" + this.ocrEnabled + ", recognitionMode=" + this.recognitionMode + ", onlineProvider=" + this.onlineProvider + ", onlineModel=" + this.onlineModel + ", onlineApiKey=" + this.onlineApiKey + ", onlinePrompt=" + this.onlinePrompt + ", ocrAccuracy=" + this.ocrAccuracy + ", ocrFields=" + this.ocrFields + ", integrationMode=" + this.integrationMode + ", liveUpdate=" + this.liveUpdate + ", superIsland=" + this.superIsland + ", samsungNowBar=" + this.samsungNowBar + ", fcmReminderEnabled=" + this.fcmReminderEnabled + ", fcmIntegrationEnabled=" + this.fcmIntegrationEnabled + ")";
    }

    public AppSettings(boolean z, String fontSize, String ticketCardStyle, String walletName, String sortRule, String expiredTicketsInWallet, String autoArchivePolicy, String viewMode, String density, String smartSubwayRecentTrips, boolean z2, String defaultReminder, String flightReminder, String trainReminder, String eventReminder, boolean z3, String recognitionMode, String onlineProvider, String onlineModel, String onlineApiKey, String onlinePrompt, String ocrAccuracy, Set<String> ocrFields, String integrationMode, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8) {
        Intrinsics.checkNotNullParameter(fontSize, "fontSize");
        Intrinsics.checkNotNullParameter(ticketCardStyle, "ticketCardStyle");
        Intrinsics.checkNotNullParameter(walletName, "walletName");
        Intrinsics.checkNotNullParameter(sortRule, "sortRule");
        Intrinsics.checkNotNullParameter(expiredTicketsInWallet, "expiredTicketsInWallet");
        Intrinsics.checkNotNullParameter(autoArchivePolicy, "autoArchivePolicy");
        Intrinsics.checkNotNullParameter(viewMode, "viewMode");
        Intrinsics.checkNotNullParameter(density, "density");
        Intrinsics.checkNotNullParameter(smartSubwayRecentTrips, "smartSubwayRecentTrips");
        Intrinsics.checkNotNullParameter(defaultReminder, "defaultReminder");
        Intrinsics.checkNotNullParameter(flightReminder, "flightReminder");
        Intrinsics.checkNotNullParameter(trainReminder, "trainReminder");
        Intrinsics.checkNotNullParameter(eventReminder, "eventReminder");
        Intrinsics.checkNotNullParameter(recognitionMode, "recognitionMode");
        Intrinsics.checkNotNullParameter(onlineProvider, "onlineProvider");
        Intrinsics.checkNotNullParameter(onlineModel, "onlineModel");
        Intrinsics.checkNotNullParameter(onlineApiKey, "onlineApiKey");
        Intrinsics.checkNotNullParameter(onlinePrompt, "onlinePrompt");
        Intrinsics.checkNotNullParameter(ocrAccuracy, "ocrAccuracy");
        Intrinsics.checkNotNullParameter(ocrFields, "ocrFields");
        Intrinsics.checkNotNullParameter(integrationMode, "integrationMode");
        this.darkTheme = z;
        this.fontSize = fontSize;
        this.ticketCardStyle = ticketCardStyle;
        this.walletName = walletName;
        this.sortRule = sortRule;
        this.expiredTicketsInWallet = expiredTicketsInWallet;
        this.autoArchivePolicy = autoArchivePolicy;
        this.viewMode = viewMode;
        this.density = density;
        this.smartSubwayRecentTrips = smartSubwayRecentTrips;
        this.reminderEnabled = z2;
        this.defaultReminder = defaultReminder;
        this.flightReminder = flightReminder;
        this.trainReminder = trainReminder;
        this.eventReminder = eventReminder;
        this.ocrEnabled = z3;
        this.recognitionMode = recognitionMode;
        this.onlineProvider = onlineProvider;
        this.onlineModel = onlineModel;
        this.onlineApiKey = onlineApiKey;
        this.onlinePrompt = onlinePrompt;
        this.ocrAccuracy = ocrAccuracy;
        this.ocrFields = ocrFields;
        this.integrationMode = integrationMode;
        this.liveUpdate = z4;
        this.superIsland = z5;
        this.samsungNowBar = z6;
        this.fcmReminderEnabled = z7;
        this.fcmIntegrationEnabled = z8;
    }

    public final boolean getDarkTheme() {
        return this.darkTheme;
    }

    public /* synthetic */ AppSettings(boolean z, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, boolean z2, String str10, String str11, String str12, String str13, boolean z3, String str14, String str15, String str16, String str17, String str18, String str19, Set set, String str20, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? true : z, (i & 2) != 0 ? "中" : str, (i & 4) != 0 ? "详细版" : str2, (i & 8) != 0 ? "我的票夹" : str3, (i & 16) != 0 ? "智能" : str4, (i & 32) != 0 ? "仍然显示" : str5, (i & 64) != 0 ? "关闭" : str6, (i & 128) != 0 ? "列表" : str7, (i & 256) != 0 ? "紧凑" : str8, (i & 512) != 0 ? "显示" : str9, (i & 1024) != 0 ? true : z2, (i & 2048) != 0 ? "2小时" : str10, (i & 4096) != 0 ? "2小时" : str11, (i & 8192) != 0 ? "2小时" : str12, (i & 16384) == 0 ? str13 : "2小时", (32768 & i) != 0 ? false : z3, (i & 65536) != 0 ? "在线识别" : str14, (i & 131072) != 0 ? "智谱开放平台" : str15, (i & 262144) != 0 ? "GLM-4.6V-Flash" : str16, (i & 524288) != 0 ? "" : str17, (i & 1048576) != 0 ? "你是“票据”App 的智能票据录入助手。请识别图片中的所有独立票据，并只返回 JSON，不要 Markdown、解释或额外文字。\n\n根格式必须是 {\"orders\":[...]}。每张独立票据对应一个 orders 对象。type 只能是：电影票、车票、机票、演出、门票、取餐码、取件码。\n\n输入可能是普通照片、截图或 PDF 页面。看不清、无法确认或图片中没有的信息返回 null，不要猜测。对于票面中清晰可见的二维码或条形码，尝试读取真实编码内容并返回 barcodeValue，同时返回 barcodeFormat（只能是“二维码”或“条形码”）；无法可靠读取时 barcodeValue 返回 null，不要把附近文字猜成码。日期优先输出 YYYY年M月D日，时间优先输出 HH:mm。只返回 App 当前存在的字段，不要增加价格、订单号等字段。\n\n允许字段：\n- 二维码 / 条形码：barcodeValue, barcodeFormat\n  barcodeValue 是票据图片或 PDF 页面中实际读取到的编码内容；barcodeFormat 只能是“二维码”或“条形码”。\n- 电影票：type, title, date, startTime, endTime, venue, hall, seat\n- 车票：type, code, date, departureDate, arrivalDate, startTime, endTime, from, to, departurePlatform, arrivalPlatform, seat\n- 机票：type, code, date, departureDate, arrivalDate, startTime, endTime, from, to, departureGate, arrivalGate, takeoffTime, landingTime, seat\n- 演出：type, title, date, startTime, endTime, venue, area, seat\n- 门票：type, title, venue, date, time, entry, seat\n- 取餐码：type, title, code, brand, venue, date, time\n- 取件码：type, title, code, brand, venue, date\n- 二维码 / 条形码：barcodeValue, barcodeFormat\n\n一张图片包含多张独立票据时，必须分别输出多个 orders 对象，不能合并。" : str18, (i & 2097152) != 0 ? "快速" : str19, (i & 4194304) != 0 ? SetsKt.setOf((Object[]) new String[]{"票据类型", "车次 / 航班号", "站点 / 地点", "日期", "时间", "座位 / 区域", "取餐码 / 取件码"}) : set, (i & 8388608) != 0 ? "Live Update" : str20, (i & 16777216) != 0 ? true : z4, (i & GroupFlagsKt.HasAuxSlotFlag) != 0 ? false : z5, (i & 67108864) != 0 ? false : z6, (i & GroupFlagsKt.HasRecompositionRequiredFlag) != 0 ? false : z7, (i & GroupFlagsKt.IsMovableContentFlag) != 0 ? false : z8);
    }

    public final String getFontSize() {
        return this.fontSize;
    }

    public final String getTicketCardStyle() {
        return this.ticketCardStyle;
    }

    public final String getWalletName() {
        return this.walletName;
    }

    public final String getSortRule() {
        return this.sortRule;
    }

    public final String getExpiredTicketsInWallet() {
        return this.expiredTicketsInWallet;
    }

    public final String getAutoArchivePolicy() {
        return this.autoArchivePolicy;
    }

    public final String getViewMode() {
        return this.viewMode;
    }

    public final String getDensity() {
        return this.density;
    }

    public final String getSmartSubwayRecentTrips() {
        return this.smartSubwayRecentTrips;
    }

    public final boolean getReminderEnabled() {
        return this.reminderEnabled;
    }

    public final String getDefaultReminder() {
        return this.defaultReminder;
    }

    public final String getFlightReminder() {
        return this.flightReminder;
    }

    public final String getTrainReminder() {
        return this.trainReminder;
    }

    public final String getEventReminder() {
        return this.eventReminder;
    }

    public final boolean getOcrEnabled() {
        return this.ocrEnabled;
    }

    public final String getRecognitionMode() {
        return this.recognitionMode;
    }

    public final String getOnlineProvider() {
        return this.onlineProvider;
    }

    public final String getOnlineModel() {
        return this.onlineModel;
    }

    public final String getOnlineApiKey() {
        return this.onlineApiKey;
    }

    public final String getOnlinePrompt() {
        return this.onlinePrompt;
    }

    public final String getOcrAccuracy() {
        return this.ocrAccuracy;
    }

    public final Set<String> getOcrFields() {
        return this.ocrFields;
    }

    public final String getIntegrationMode() {
        return this.integrationMode;
    }

    public final boolean getLiveUpdate() {
        return this.liveUpdate;
    }

    public final boolean getSuperIsland() {
        return this.superIsland;
    }

    public final boolean getSamsungNowBar() {
        return this.samsungNowBar;
    }

    public final boolean getFcmReminderEnabled() {
        return this.fcmReminderEnabled;
    }

    public final boolean getFcmIntegrationEnabled() {
        return this.fcmIntegrationEnabled;
    }
}
