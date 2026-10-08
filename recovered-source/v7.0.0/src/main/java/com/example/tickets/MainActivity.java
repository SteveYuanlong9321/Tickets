package com.example.tickets;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import androidx.activity.ComponentActivity;
import androidx.activity.EdgeToEdge;
import androidx.activity.OnBackPressedCallback;
import androidx.activity.compose.ComponentActivityKt;
import androidx.compose.animation.AnimatedContentKt;
import androidx.compose.animation.AnimatedContentScope;
import androidx.compose.animation.AnimatedContentTransitionScope;
import androidx.compose.animation.ContentTransform;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.core.content.ContextCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.example.tickets.ui.theme.ThemeKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: MainActivity.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\b\u0007\u0018\u0000 <2\u00020\u0001:\u0001<B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010*\u001a\u00020\u0018H\u0002J\b\u0010+\u001a\u00020\u0018H\u0002J\b\u00101\u001a\u00020.H\u0014J\b\u00102\u001a\u00020.H\u0014J\u0012\u00103\u001a\u00020.2\b\u00104\u001a\u0004\u0018\u000105H\u0002J\u0012\u00106\u001a\u00020.2\b\u00107\u001a\u0004\u0018\u000108H\u0015J\u0010\u00109\u001a\u00020.2\u0006\u00104\u001a\u000205H\u0014J\r\u0010:\u001a\u00020.H\u0003¢\u0006\u0002\u0010;R/\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u00058B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR/\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u0004\u001a\u0004\u0018\u00010\r8B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\u0013\u0010\f\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R/\u0010\u0014\u001a\u0004\u0018\u00010\r2\b\u0010\u0004\u001a\u0004\u0018\u00010\r8B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\u0017\u0010\f\u001a\u0004\b\u0015\u0010\u0010\"\u0004\b\u0016\u0010\u0012R+\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0004\u001a\u00020\u00188B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\u001e\u0010\f\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR+\u0010 \u001a\u00020\u001f2\u0006\u0010\u0004\u001a\u00020\u001f8B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b%\u0010\f\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R+\u0010&\u001a\u00020\u00182\u0006\u0010\u0004\u001a\u00020\u00188B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b)\u0010\f\u001a\u0004\b'\u0010\u001b\"\u0004\b(\u0010\u001dR\u0016\u0010,\u001a\n\u0012\u0004\u0012\u00020.\u0018\u00010-X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010/\u001a\u0010\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020.\u0018\u000100X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006=²\u0006\n\u0010>\u001a\u00020\rX\u008a\u008e\u0002²\u0006\n\u0010?\u001a\u00020\u0018X\u008a\u008e\u0002²\u0006\f\u0010@\u001a\u0004\u0018\u00010AX\u008a\u008e\u0002²\u0006\f\u0010B\u001a\u0004\u0018\u00010CX\u008a\u008e\u0002²\u0006\n\u0010D\u001a\u00020\u0018X\u008a\u008e\u0002²\u0006\n\u0010E\u001a\u00020\u0018X\u008a\u008e\u0002²\u0006\u0010\u0010F\u001a\b\u0012\u0004\u0012\u00020H0GX\u008a\u008e\u0002²\u0006\f\u0010I\u001a\u0004\u0018\u00010\rX\u008a\u008e\u0002²\u0006\u0010\u0010J\u001a\b\u0012\u0004\u0012\u00020\r0KX\u008a\u008e\u0002²\u0006\n\u0010L\u001a\u00020\rX\u008a\u008e\u0002²\u0006\n\u0010M\u001a\u00020NX\u008a\u008e\u0002²\u0006\n\u0010O\u001a\u00020PX\u008a\u008e\u0002"}, d2 = {"Lcom/example/tickets/MainActivity;", "Landroidx/activity/ComponentActivity;", "<init>", "()V", "<set-?>", "Landroid/net/Uri;", "sharedImageUri", "getSharedImageUri", "()Landroid/net/Uri;", "setSharedImageUri", "(Landroid/net/Uri;)V", "sharedImageUri$delegate", "Landroidx/compose/runtime/MutableState;", "", "pendingMarkUsedTicketId", "getPendingMarkUsedTicketId", "()Ljava/lang/Integer;", "setPendingMarkUsedTicketId", "(Ljava/lang/Integer;)V", "pendingMarkUsedTicketId$delegate", "pendingOpenTicketId", "getPendingOpenTicketId", "setPendingOpenTicketId", "pendingOpenTicketId$delegate", "", "shareReceiverMode", "getShareReceiverMode", "()Z", "setShareReceiverMode", "(Z)V", "shareReceiverMode$delegate", "Lcom/example/tickets/AppScreen;", "currentScreen", "getCurrentScreen", "()Lcom/example/tickets/AppScreen;", "setCurrentScreen", "(Lcom/example/tickets/AppScreen;)V", "currentScreen$delegate", "transferOverlayActive", "getTransferOverlayActive", "setTransferOverlayActive", "transferOverlayActive$delegate", "isTransferScreenForNavigation", "isTransferOverlayActiveForNavigation", "settingsSystemBackHandler", "Lkotlin/Function0;", "", "onRealtimeVisibilityChanged", "Lkotlin/Function1;", "onStart", "onStop", "handleWidgetIntent", AccessibilityNodeInfoCompat.MathInfoCompat.MATH_ATTRIBUTE_INTENT, "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onNewIntent", "TicketsApp", "(Landroidx/compose/runtime/Composer;I)V", "Companion", "app", "selectedTab", "smartSubwayAddTripScreen", "smartSubwayTrip", "Lcom/example/tickets/SmartSubwayTrip;", "publishedSmartSubwayMode", "", "smartSubwayLocationPermissionGranted", "smartSubwayLocationPermissionRequested", "tickets", "", "Lcom/example/tickets/TicketData;", "selectedTicketId", "selectedShareTicketIds", "", "nextTicketId", "appSettings", "Lcom/example/tickets/AppSettings;", "settingsPage", "Lcom/example/tickets/SettingsPage;"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class MainActivity extends ComponentActivity {
    public static final String ACTION_MARK_TICKET_USED = "com.example.tickets.action.MARK_TICKET_USED";
    public static final String ACTION_SHARE_IMAGE = "com.example.tickets.action.SHARE_IMAGE";
    private Function1<? super Boolean, Unit> onRealtimeVisibilityChanged;
    private Function0<Unit> settingsSystemBackHandler;
    public static final int $stable = 8;

    /* JADX INFO: renamed from: sharedImageUri$delegate, reason: from kotlin metadata */
    private final MutableState sharedImageUri = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);

    /* JADX INFO: renamed from: pendingMarkUsedTicketId$delegate, reason: from kotlin metadata */
    private final MutableState pendingMarkUsedTicketId = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);

    /* JADX INFO: renamed from: pendingOpenTicketId$delegate, reason: from kotlin metadata */
    private final MutableState pendingOpenTicketId = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);

    /* JADX INFO: renamed from: shareReceiverMode$delegate, reason: from kotlin metadata */
    private final MutableState shareReceiverMode = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);

    /* JADX INFO: renamed from: currentScreen$delegate, reason: from kotlin metadata */
    private final MutableState currentScreen = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(AppScreen.MAIN, null, 2, null);

    /* JADX INFO: renamed from: transferOverlayActive$delegate, reason: from kotlin metadata */
    private final MutableState transferOverlayActive = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);

    /* JADX INFO: compiled from: MainActivity.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[AppScreen.values().length];
            try {
                iArr[AppScreen.SHARE_MENU.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AppScreen.RECEIVE_MENU.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[AppScreen.NFC_SHARE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[AppScreen.QR_SHARE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[AppScreen.MAIN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[AppScreen.ADD.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[AppScreen.DETAIL.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[AppScreen.EDIT.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[SettingsPage.values().length];
            try {
                iArr2[SettingsPage.OCR_PROMPT.ordinal()] = 1;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr2[SettingsPage.CHANGELOG.ordinal()] = 2;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr2[SettingsPage.HOME.ordinal()] = 3;
            } catch (NoSuchFieldError unused11) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    static final Unit TicketsApp$lambda$174(MainActivity mainActivity, int i, Composer composer, int i2) {
        mainActivity.TicketsApp(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    static final int TicketsApp$lambda$88$lambda$87$lambda$79(int i) {
        return i;
    }

    static final int TicketsApp$lambda$88$lambda$87$lambda$81(int i) {
        return -i;
    }

    static final int TicketsApp$lambda$88$lambda$87$lambda$83(int i) {
        return i;
    }

    static final int TicketsApp$lambda$88$lambda$87$lambda$85(int i) {
        return -i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final Uri getSharedImageUri() {
        return (Uri) this.sharedImageUri.getValue();
    }

    private final void setSharedImageUri(Uri uri) {
        this.sharedImageUri.setValue(uri);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final Integer getPendingMarkUsedTicketId() {
        return (Integer) this.pendingMarkUsedTicketId.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setPendingMarkUsedTicketId(Integer num) {
        this.pendingMarkUsedTicketId.setValue(num);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final Integer getPendingOpenTicketId() {
        return (Integer) this.pendingOpenTicketId.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setPendingOpenTicketId(Integer num) {
        this.pendingOpenTicketId.setValue(num);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final boolean getShareReceiverMode() {
        return ((Boolean) this.shareReceiverMode.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setShareReceiverMode(boolean z) {
        this.shareReceiverMode.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final AppScreen getCurrentScreen() {
        return (AppScreen) this.currentScreen.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setCurrentScreen(AppScreen appScreen) {
        this.currentScreen.setValue(appScreen);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean getTransferOverlayActive() {
        return ((Boolean) this.transferOverlayActive.getValue()).booleanValue();
    }

    private final void setTransferOverlayActive(boolean z) {
        this.transferOverlayActive.setValue(Boolean.valueOf(z));
    }

    private final boolean isTransferScreenForNavigation() {
        int i = WhenMappings.$EnumSwitchMapping$0[getCurrentScreen().ordinal()];
        return i == 1 || i == 2 || i == 3 || i == 4;
    }

    private final boolean isTransferOverlayActiveForNavigation() {
        return getTransferOverlayActive();
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        RealtimeNotificationVisibilityController.INSTANCE.setAppForeground(true);
        Function1<? super Boolean, Unit> function1 = this.onRealtimeVisibilityChanged;
        if (function1 != null) {
            function1.invoke(true);
        }
    }

    @Override // android.app.Activity
    protected void onStop() {
        RealtimeNotificationVisibilityController.INSTANCE.setAppForeground(false);
        Function1<? super Boolean, Unit> function1 = this.onRealtimeVisibilityChanged;
        if (function1 != null) {
            function1.invoke(false);
        }
        super.onStop();
    }

    private final void handleWidgetIntent(Intent intent) {
        Uri uri;
        if (!Intrinsics.areEqual(intent != null ? intent.getAction() : null, LiveUpdateManager.ACTION_OPEN_TICKET)) {
            if (!Intrinsics.areEqual(intent != null ? intent.getAction() : null, LiveUpdateManager.ACTION_OPEN_TICKET_V2)) {
                if (Intrinsics.areEqual(intent != null ? intent.getAction() : null, "com.example.tickets.action.MARK_TICKET_USED")) {
                    int intExtra = intent.getIntExtra("ticket_id", -1);
                    if (intExtra >= 0) {
                        setPendingMarkUsedTicketId(Integer.valueOf(intExtra));
                        MainActivity mainActivity = this;
                        LiveUpdateManager.INSTANCE.cancelTicketLiveUpdate(mainActivity, intExtra);
                        ReminderManager.INSTANCE.cancelTicketReminder$app(mainActivity, intExtra);
                        XiaomiSuperIslandManager.INSTANCE.cancelTicket$app(mainActivity, intExtra);
                        SamsungNowBarManager.INSTANCE.cancelTicket(mainActivity, intExtra);
                    }
                    setCurrentScreen(AppScreen.MAIN);
                    return;
                }
                if (!Intrinsics.areEqual(intent != null ? intent.getAction() : null, ACTION_SHARE_IMAGE)) {
                    if (!Intrinsics.areEqual(intent != null ? intent.getAction() : null, "android.intent.action.SEND")) {
                        String action = intent != null ? intent.getAction() : null;
                        if (action != null) {
                            int iHashCode = action.hashCode();
                            if (iHashCode == -2102947876) {
                                if (action.equals(TicketWidgetProvider.ACTION_OPEN_WALLET)) {
                                    setCurrentScreen(AppScreen.MAIN);
                                    return;
                                }
                                return;
                            } else {
                                if (iHashCode == 1921649276 && action.equals(TicketWidgetProvider.ACTION_ADD_TICKET)) {
                                    setSharedImageUri(null);
                                    setCurrentScreen(AppScreen.ADD);
                                    return;
                                }
                                return;
                            }
                        }
                        return;
                    }
                }
                if (Build.VERSION.SDK_INT >= 33) {
                    uri = (Uri) intent.getParcelableExtra("android.intent.extra.STREAM", Uri.class);
                } else {
                    uri = (Uri) intent.getParcelableExtra("android.intent.extra.STREAM");
                }
                setSharedImageUri(uri);
                setCurrentScreen(AppScreen.ADD);
                return;
            }
        }
        int intExtra2 = intent.getIntExtra("ticket_id", -1);
        if (intExtra2 >= 0) {
            setPendingOpenTicketId(Integer.valueOf(intExtra2));
        }
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        handleWidgetIntent(getIntent());
        getWindow().setBackgroundDrawable(new ColorDrawable(-16777216));
        getWindow().setSoftInputMode(16);
        MainActivity mainActivity = this;
        EdgeToEdge.enable$default(mainActivity, null, null, 3, null);
        getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback() { // from class: com.example.tickets.MainActivity.onCreate.1

            /* JADX INFO: renamed from: com.example.tickets.MainActivity$onCreate$1$WhenMappings */
            /* JADX INFO: compiled from: MainActivity.kt */
            @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
            public static final /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[AppScreen.values().length];
                    try {
                        iArr[AppScreen.MAIN.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[AppScreen.ADD.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        iArr[AppScreen.DETAIL.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    try {
                        iArr[AppScreen.EDIT.ordinal()] = 4;
                    } catch (NoSuchFieldError unused4) {
                    }
                    try {
                        iArr[AppScreen.SHARE_MENU.ordinal()] = 5;
                    } catch (NoSuchFieldError unused5) {
                    }
                    try {
                        iArr[AppScreen.NFC_SHARE.ordinal()] = 6;
                    } catch (NoSuchFieldError unused6) {
                    }
                    try {
                        iArr[AppScreen.QR_SHARE.ordinal()] = 7;
                    } catch (NoSuchFieldError unused7) {
                    }
                    try {
                        iArr[AppScreen.RECEIVE_MENU.ordinal()] = 8;
                    } catch (NoSuchFieldError unused8) {
                    }
                    $EnumSwitchMapping$0 = iArr;
                }
            }

            {
                super(true);
            }

            @Override // androidx.activity.OnBackPressedCallback
            public void handleOnBackPressed() {
                AppScreen appScreen;
                if (MainActivity.this.getCurrentScreen() != AppScreen.MAIN || MainActivity.this.settingsSystemBackHandler == null) {
                    switch (WhenMappings.$EnumSwitchMapping$0[MainActivity.this.getCurrentScreen().ordinal()]) {
                        case 1:
                            MainActivity.this.finish();
                            return;
                        case 2:
                            MainActivity.this.setCurrentScreen(AppScreen.MAIN);
                            return;
                        case 3:
                            MainActivity.this.setCurrentScreen(AppScreen.MAIN);
                            return;
                        case 4:
                            MainActivity.this.setCurrentScreen(AppScreen.DETAIL);
                            return;
                        case 5:
                            boolean shareReceiverMode = MainActivity.this.getShareReceiverMode();
                            MainActivity mainActivity2 = MainActivity.this;
                            if (shareReceiverMode) {
                                mainActivity2.setShareReceiverMode(false);
                                MainActivity.this.setCurrentScreen(AppScreen.RECEIVE_MENU);
                                return;
                            } else {
                                mainActivity2.setCurrentScreen(AppScreen.DETAIL);
                                return;
                            }
                        case 6:
                        case 7:
                            MainActivity mainActivity3 = MainActivity.this;
                            if (mainActivity3.getShareReceiverMode()) {
                                MainActivity.this.setShareReceiverMode(false);
                                appScreen = AppScreen.RECEIVE_MENU;
                            } else {
                                appScreen = AppScreen.SHARE_MENU;
                            }
                            mainActivity3.setCurrentScreen(appScreen);
                            return;
                        case 8:
                            MainActivity.this.setCurrentScreen(AppScreen.MAIN);
                            return;
                        default:
                            throw new NoWhenBranchMatchedException();
                    }
                }
                Function0 function0 = MainActivity.this.settingsSystemBackHandler;
                if (function0 != null) {
                    function0.invoke();
                }
            }
        });
        ComponentActivityKt.setContent$default(mainActivity, null, ComposableLambdaKt.composableLambdaInstance(1915295138, true, new Function2() { // from class: com.example.tickets.MainActivity$$ExternalSyntheticLambda44
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return MainActivity.onCreate$lambda$1(this.f$0, (Composer) obj, ((Integer) obj2).intValue());
            }
        }), 1, null);
    }

    static final Unit onCreate$lambda$1(final MainActivity mainActivity, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C1822@49828L45,1822@49815L58:MainActivity.kt#n9ob9m");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1915295138, i, -1, "com.example.tickets.MainActivity.onCreate.<anonymous> (MainActivity.kt:1822)");
            }
            ThemeKt.TicketsTheme(false, false, ComposableLambdaKt.rememberComposableLambda(834421777, true, new Function2() { // from class: com.example.tickets.MainActivity$$ExternalSyntheticLambda11
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return MainActivity.onCreate$lambda$1$lambda$0(this.f$0, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), composer, 384, 3);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    static final Unit onCreate$lambda$1$lambda$0(MainActivity mainActivity, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C1824@49847L12:MainActivity.kt#n9ob9m");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(834421777, i, -1, "com.example.tickets.MainActivity.onCreate.<anonymous>.<anonymous> (MainActivity.kt:1824)");
            }
            mainActivity.TicketsApp(composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    protected void onNewIntent(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        super.onNewIntent(intent);
        setIntent(intent);
        handleWidgetIntent(intent);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:178:0x051b  */
    /* JADX WARN: Code duplicated, block: B:185:0x052b  */
    /* JADX WARN: Code duplicated, block: B:186:0x052d A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:187:0x052f  */
    /* JADX WARN: Code duplicated, block: B:188:0x0531 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:200:0x0559  */
    /* JADX WARN: Code duplicated, block: B:204:0x057a  */
    /* JADX WARN: Code duplicated, block: B:207:0x057f  */
    /* JADX WARN: Failed to find 'out' block for switch in B:170:0x0507. Please report as an issue. */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /*  JADX ERROR: UnsupportedOperationException in pass: SwitchBreakVisitor
        java.lang.UnsupportedOperationException
        	at java.base/java.util.Collections$UnmodifiableCollection.add(Collections.java:1068)
        	at jadx.core.dex.visitors.regions.SwitchBreakVisitor$BaseSwitchRegionVisitor.leaveRegion(SwitchBreakVisitor.java:210)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:91)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:31)
        	at jadx.core.dex.visitors.regions.SwitchBreakVisitor$IterativeSwitchRegionVisitor.leaveRegion(SwitchBreakVisitor.java:177)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:91)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:27)
        	at jadx.core.dex.visitors.regions.SwitchBreakVisitor.runSwitchTraverse(SwitchBreakVisitor.java:52)
        	at jadx.core.dex.visitors.regions.SwitchBreakVisitor.visit(SwitchBreakVisitor.java:45)
        */
    private final void TicketsApp(androidx.compose.runtime.Composer r62, final int r63) {
        /*
            Method dump skipped, instruction units count: 2510
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.tickets.MainActivity.TicketsApp(androidx.compose.runtime.Composer, int):void");
    }

    private static final int TicketsApp$lambda$3(MutableIntState mutableIntState) {
        return mutableIntState.getIntValue();
    }

    private static final boolean TicketsApp$lambda$6(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void TicketsApp$lambda$7(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SmartSubwayTrip TicketsApp$lambda$9(MutableState<SmartSubwayTrip> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String TicketsApp$lambda$12(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean TicketsApp$lambda$15(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void TicketsApp$lambda$16(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean TicketsApp$lambda$18(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void TicketsApp$lambda$19(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.example.tickets.MainActivity$TicketsApp$1$1$receiver$1] */
    static final DisposableEffectResult TicketsApp$lambda$23$lambda$22(final MainActivity mainActivity, final MutableState mutableState, final DisposableEffectScope DisposableEffect) {
        Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
        final ?? r0 = new BroadcastReceiver() { // from class: com.example.tickets.MainActivity$TicketsApp$1$1$receiver$1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                SmartSubwayTrip smartSubwayTripLoadSmartSubwayTripLocal;
                Intrinsics.checkNotNullParameter(context, "context");
                if (Intrinsics.areEqual(intent != null ? intent.getAction() : null, SmartSubwayManualAdvance.ACTION_UPDATED) && (smartSubwayTripLoadSmartSubwayTripLocal = MainActivityKt.loadSmartSubwayTripLocal(context)) != null) {
                    mutableState.setValue(smartSubwayTripLoadSmartSubwayTripLocal);
                }
            }
        };
        ContextCompat.registerReceiver(mainActivity, (BroadcastReceiver) r0, new IntentFilter(SmartSubwayManualAdvance.ACTION), 4);
        return new DisposableEffectResult() { // from class: com.example.tickets.MainActivity$TicketsApp$lambda$23$lambda$22$$inlined$onDispose$1
            @Override // androidx.compose.runtime.DisposableEffectResult
            public void dispose() {
                try {
                    Result.Companion companion = Result.INSTANCE;
                    mainActivity.unregisterReceiver(r0);
                    Result.m9536constructorimpl(Unit.INSTANCE);
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.INSTANCE;
                    Result.m9536constructorimpl(ResultKt.createFailure(th));
                }
            }
        };
    }

    static final Unit TicketsApp$lambda$25$lambda$24(MainActivity mainActivity, MutableState mutableState, Map result) {
        Intrinsics.checkNotNullParameter(result, "result");
        boolean z = true;
        if (!Intrinsics.areEqual(result.get("android.permission.ACCESS_FINE_LOCATION"), (Object) true) && !Intrinsics.areEqual(result.get("android.permission.ACCESS_COARSE_LOCATION"), (Object) true) && !GlobalSubwayLocationEngine.INSTANCE.hasLocationPermission(mainActivity)) {
            z = false;
        }
        TicketsApp$lambda$16(mutableState, z);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List<TicketData> TicketsApp$lambda$31(MutableState<List<TicketData>> mutableState) {
        return mutableState.getValue();
    }

    private static final Integer TicketsApp$lambda$35(MutableState<Integer> mutableState) {
        return mutableState.getValue();
    }

    private static final Set<Integer> TicketsApp$lambda$38(MutableState<Set<Integer>> mutableState) {
        return mutableState.getValue();
    }

    private static final int TicketsApp$lambda$42(MutableIntState mutableIntState) {
        return mutableIntState.getIntValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AppSettings TicketsApp$lambda$48(MutableState<AppSettings> mutableState) {
        return mutableState.getValue();
    }

    static final DisposableEffectResult TicketsApp$lambda$58$lambda$57(final MainActivity mainActivity, final MutableState mutableState, final MutableState mutableState2, final DisposableEffectScope DisposableEffect) {
        Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
        mainActivity.onRealtimeVisibilityChanged = new Function1() { // from class: com.example.tickets.MainActivity$$ExternalSyntheticLambda16
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MainActivity.TicketsApp$lambda$58$lambda$57$lambda$55(DisposableEffect, mainActivity, mutableState, mutableState2, ((Boolean) obj).booleanValue());
            }
        };
        return new DisposableEffectResult() { // from class: com.example.tickets.MainActivity$TicketsApp$lambda$58$lambda$57$$inlined$onDispose$1
            @Override // androidx.compose.runtime.DisposableEffectResult
            public void dispose() {
                this.this$0.onRealtimeVisibilityChanged = null;
            }
        };
    }

    static final Unit TicketsApp$lambda$58$lambda$57$lambda$55(DisposableEffectScope disposableEffectScope, MainActivity mainActivity, MutableState mutableState, MutableState mutableState2, boolean z) {
        RealtimeNotificationVisibilityController.INSTANCE.setAppForeground(z);
        if (z) {
            try {
                Result.Companion companion = Result.INSTANCE;
                Result.m9536constructorimpl(Boolean.valueOf(mainActivity.stopService(new Intent(mainActivity, (Class<?>) LiveUpdateService.class))));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                Result.m9536constructorimpl(ResultKt.createFailure(th));
            }
        }
        List<TicketData> listTicketsApp$lambda$31 = TicketsApp$lambda$31(mutableState);
        ArrayList arrayList = new ArrayList();
        for (Object obj : listTicketsApp$lambda$31) {
            TicketData ticketData = (TicketData) obj;
            if (!ticketData.getArchived() && !ticketData.getManuallyUsed()) {
                arrayList.add(obj);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            MainActivityKt.showIntegrationTicketSafely(mainActivity, (TicketData) it.next(), TicketsApp$lambda$48(mutableState2).getIntegrationMode());
        }
        return Unit.INSTANCE;
    }

    static final Unit TicketsApp$lambda$63$lambda$62(MainActivity mainActivity, MutableState mutableState, MutableState mutableState2, boolean z) {
        if (z) {
            MainActivity mainActivity2 = mainActivity;
            ReminderManager.INSTANCE.createNotificationChannel$app(mainActivity2);
            ReminderManager.INSTANCE.scheduleAll$app(mainActivity2, TicketsApp$lambda$31(mutableState), TicketsApp$lambda$48(mutableState2));
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SettingsPage TicketsApp$lambda$66(MutableState<SettingsPage> mutableState) {
        return mutableState.getValue();
    }

    static final DisposableEffectResult TicketsApp$lambda$71$lambda$70(final MainActivity mainActivity, final MutableIntState mutableIntState, final MutableState mutableState, DisposableEffectScope DisposableEffect) {
        Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
        mainActivity.settingsSystemBackHandler = TicketsApp$lambda$3(mutableIntState) == 2 ? new Function0() { // from class: com.example.tickets.MainActivity$$ExternalSyntheticLambda33
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return MainActivity.TicketsApp$lambda$71$lambda$70$lambda$68(mutableState, mutableIntState);
            }
        } : null;
        return new DisposableEffectResult() { // from class: com.example.tickets.MainActivity$TicketsApp$lambda$71$lambda$70$$inlined$onDispose$1
            @Override // androidx.compose.runtime.DisposableEffectResult
            public void dispose() {
                this.this$0.settingsSystemBackHandler = null;
            }
        };
    }

    static final Unit TicketsApp$lambda$71$lambda$70$lambda$68(MutableState mutableState, MutableIntState mutableIntState) {
        int i = WhenMappings.$EnumSwitchMapping$1[TicketsApp$lambda$66(mutableState).ordinal()];
        if (i == 1) {
            mutableState.setValue(SettingsPage.OCR);
        } else if (i == 2) {
            mutableState.setValue(SettingsPage.ABOUT);
        } else if (i == 3) {
            mutableIntState.setIntValue(0);
        } else {
            mutableState.setValue(SettingsPage.HOME);
        }
        return Unit.INSTANCE;
    }

    static final Unit TicketsApp$lambda$74$lambda$73(MutableState mutableState, MutableIntState mutableIntState, SettingsPage page) {
        Intrinsics.checkNotNullParameter(page, "page");
        mutableState.setValue(page);
        mutableIntState.setIntValue(2);
        return Unit.INSTANCE;
    }

    static final Unit TicketsApp$lambda$76$lambda$75(MutableState mutableState, MutableIntState mutableIntState) {
        mutableState.setValue(SettingsPage.HOME);
        mutableIntState.setIntValue(2);
        return Unit.INSTANCE;
    }

    static final Unit TicketsApp$lambda$78$lambda$77(MainActivity mainActivity, MutableState mutableState, MutableState mutableState2, AppSettings newSettings) {
        String str;
        Intrinsics.checkNotNullParameter(newSettings, "newSettings");
        if (newSettings.getSamsungNowBar() || Intrinsics.areEqual(newSettings.getIntegrationMode(), "实时窗") || Intrinsics.areEqual(newSettings.getIntegrationMode(), "三星 Now Bar")) {
            str = "实时窗";
        } else {
            str = (newSettings.getSuperIsland() || Intrinsics.areEqual(newSettings.getIntegrationMode(), "超级岛")) ? "超级岛" : "Live Update";
        }
        AppSettings appSettingsCopy$default = AppSettings.copy$default(newSettings, false, null, null, null, null, null, null, null, null, null, false, null, null, null, null, false, null, null, null, null, null, null, null, str, Intrinsics.areEqual(str, "Live Update"), Intrinsics.areEqual(str, "超级岛"), Intrinsics.areEqual(str, "实时窗"), false, false, 411041791, null);
        mutableState.setValue(appSettingsCopy$default);
        MainActivity mainActivity2 = mainActivity;
        OnlineRecognitionStore.INSTANCE.saveString$app(mainActivity2, "recognition_mode", newSettings.getRecognitionMode());
        OnlineRecognitionStore.INSTANCE.saveString$app(mainActivity2, "online_provider", newSettings.getOnlineProvider());
        OnlineRecognitionStore.INSTANCE.saveString$app(mainActivity2, "online_model", newSettings.getOnlineModel());
        OnlineRecognitionStore.INSTANCE.saveString$app(mainActivity2, "online_prompt", newSettings.getOnlinePrompt());
        OnlineRecognitionStore.INSTANCE.saveString$app(mainActivity2, "expired_tickets_in_wallet", newSettings.getExpiredTicketsInWallet());
        OnlineRecognitionStore.INSTANCE.saveString$app(mainActivity2, "auto_archive_policy", newSettings.getAutoArchivePolicy());
        OnlineRecognitionStore.INSTANCE.saveString$app(mainActivity2, "smart_subway_recent_trips", newSettings.getSmartSubwayRecentTrips());
        MainActivityKt.saveReminderSettings(mainActivity2, newSettings);
        OnlineRecognitionStore.INSTANCE.saveString$app(mainActivity2, "fcm_reminder_enabled", String.valueOf(newSettings.getFcmReminderEnabled()));
        OnlineRecognitionStore.INSTANCE.saveString$app(mainActivity2, "fcm_integration_enabled", String.valueOf(appSettingsCopy$default.getFcmIntegrationEnabled()));
        OnlineRecognitionStore.INSTANCE.saveString$app(mainActivity2, "integration_mode", appSettingsCopy$default.getIntegrationMode());
        OnlineRecognitionStore.INSTANCE.saveString$app(mainActivity2, "integration_live_update", String.valueOf(appSettingsCopy$default.getLiveUpdate()));
        OnlineRecognitionStore.INSTANCE.saveString$app(mainActivity2, "integration_super_island", String.valueOf(appSettingsCopy$default.getSuperIsland()));
        OnlineRecognitionStore.INSTANCE.saveString$app(mainActivity2, "integration_samsung_now_bar", String.valueOf(appSettingsCopy$default.getSamsungNowBar()));
        OnlineRecognitionStore.INSTANCE.saveApiKey$app(mainActivity2, appSettingsCopy$default.getOnlineApiKey());
        if (newSettings.getReminderEnabled()) {
            ReminderManager.INSTANCE.scheduleAll$app(mainActivity2, TicketsApp$lambda$31(mutableState2), newSettings);
        } else {
            ReminderManager.INSTANCE.cancelAll$app(mainActivity2, TicketsApp$lambda$31(mutableState2));
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    static final ContentTransform TicketsApp$lambda$88$lambda$87(AnimatedContentTransitionScope AnimatedContent) {
        Intrinsics.checkNotNullParameter(AnimatedContent, "$this$AnimatedContent");
        if (AnimatedContent.getInitialState() == AppScreen.MAIN && AnimatedContent.getTargetState() != AppScreen.MAIN) {
            return AnimatedContentKt.togetherWith(EnterExitTransitionKt.slideInHorizontally(AnimationSpecKt.tween$default(180, 0, EasingKt.getFastOutSlowInEasing(), 2, null), new Function1() { // from class: com.example.tickets.MainActivity$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return Integer.valueOf(MainActivity.TicketsApp$lambda$88$lambda$87$lambda$79(((Integer) obj).intValue()));
                }
            }).plus(EnterExitTransitionKt.fadeIn$default(AnimationSpecKt.tween$default(165, 0, EasingKt.getFastOutSlowInEasing(), 2, null), 0.0f, 2, null)), EnterExitTransitionKt.slideOutHorizontally(AnimationSpecKt.tween$default(180, 0, EasingKt.getFastOutSlowInEasing(), 2, null), new Function1() { // from class: com.example.tickets.MainActivity$$ExternalSyntheticLambda8
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return Integer.valueOf(MainActivity.TicketsApp$lambda$88$lambda$87$lambda$80(((Integer) obj).intValue()));
                }
            }).plus(EnterExitTransitionKt.fadeOut$default(AnimationSpecKt.tween$default(145, 0, EasingKt.getFastOutSlowInEasing(), 2, null), 0.0f, 2, null)));
        }
        if (AnimatedContent.getInitialState() != AppScreen.MAIN && AnimatedContent.getTargetState() == AppScreen.MAIN) {
            return AnimatedContentKt.togetherWith(EnterExitTransitionKt.slideInHorizontally$default(null, new Function1() { // from class: com.example.tickets.MainActivity$$ExternalSyntheticLambda9
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return Integer.valueOf(MainActivity.TicketsApp$lambda$88$lambda$87$lambda$81(((Integer) obj).intValue()));
                }
            }, 1, null).plus(EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null)), EnterExitTransitionKt.slideOutHorizontally$default(null, new Function1() { // from class: com.example.tickets.MainActivity$$ExternalSyntheticLambda10
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return Integer.valueOf(MainActivity.TicketsApp$lambda$88$lambda$87$lambda$82(((Integer) obj).intValue()));
                }
            }, 1, null).plus(EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null)));
        }
        if (((AppScreen) AnimatedContent.getTargetState()).ordinal() > ((AppScreen) AnimatedContent.getInitialState()).ordinal()) {
            return AnimatedContentKt.togetherWith(EnterExitTransitionKt.slideInHorizontally$default(null, new Function1() { // from class: com.example.tickets.MainActivity$$ExternalSyntheticLambda12
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return Integer.valueOf(MainActivity.TicketsApp$lambda$88$lambda$87$lambda$83(((Integer) obj).intValue()));
                }
            }, 1, null).plus(EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null)), EnterExitTransitionKt.slideOutHorizontally$default(null, new Function1() { // from class: com.example.tickets.MainActivity$$ExternalSyntheticLambda13
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return Integer.valueOf(MainActivity.TicketsApp$lambda$88$lambda$87$lambda$84(((Integer) obj).intValue()));
                }
            }, 1, null).plus(EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null)));
        }
        return AnimatedContentKt.togetherWith(EnterExitTransitionKt.slideInHorizontally$default(null, new Function1() { // from class: com.example.tickets.MainActivity$$ExternalSyntheticLambda14
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Integer.valueOf(MainActivity.TicketsApp$lambda$88$lambda$87$lambda$85(((Integer) obj).intValue()));
            }
        }, 1, null).plus(EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null)), EnterExitTransitionKt.slideOutHorizontally$default(null, new Function1() { // from class: com.example.tickets.MainActivity$$ExternalSyntheticLambda15
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Integer.valueOf(MainActivity.TicketsApp$lambda$88$lambda$87$lambda$86(((Integer) obj).intValue()));
            }
        }, 1, null).plus(EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null)));
    }

    static final int TicketsApp$lambda$88$lambda$87$lambda$80(int i) {
        return (-i) / 5;
    }

    static final int TicketsApp$lambda$88$lambda$87$lambda$82(int i) {
        return i / 5;
    }

    static final int TicketsApp$lambda$88$lambda$87$lambda$84(int i) {
        return (-i) / 5;
    }

    static final int TicketsApp$lambda$88$lambda$87$lambda$86(int i) {
        return i / 5;
    }

    /* JADX WARN: Code duplicated, block: B:20:0x0085  */
    /* JADX WARN: Code duplicated, block: B:24:0x00b8  */
    /* JADX WARN: Code duplicated, block: B:271:0x05b9 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:274:0x0586 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:279:0x06a5 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:282:0x0672 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:287:0x0827 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:290:0x07f4 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:29:0x00e2  */
    /* JADX WARN: Code duplicated, block: B:31:0x0122  */
    /* JADX WARN: Code duplicated, block: B:44:0x016d  */
    /* JADX WARN: Code duplicated, block: B:48:0x0190  */
    /* JADX WARN: Code duplicated, block: B:53:0x01ba  */
    /* JADX WARN: Code duplicated, block: B:58:0x01e4  */
    /* JADX WARN: Code duplicated, block: B:63:0x020f  */
    /* JADX WARN: Code duplicated, block: B:68:0x0235  */
    /* JADX WARN: Code duplicated, block: B:73:0x025b  */
    /* JADX WARN: Code duplicated, block: B:80:0x028f  */
    /* JADX WARN: Code duplicated, block: B:82:0x02bb  */
    /*  JADX ERROR: JadxRuntimeException in pass: IfRegionVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r7v17 java.lang.Object, still in use, count: 2, list:
          (r7v17 java.lang.Object) from 0x0823: PHI (r7 I:??) = (r7v14 java.lang.Object), (r7v17 java.lang.Object) binds: [B:222:0x0822, B:293:0x0823] A[DONT_GENERATE, DONT_INLINE]
          (r7v17 java.lang.Object) from 0x0819: CHECK_CAST (com.example.tickets.TicketData) (r7v17 java.lang.Object)
        	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:164)
        	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:129)
        	at jadx.core.utils.InsnRemover.unbindInsn(InsnRemover.java:93)
        	at jadx.core.dex.visitors.regions.TernaryMod.makeTernaryInsn(TernaryMod.java:132)
        	at jadx.core.dex.visitors.regions.TernaryMod.processRegion(TernaryMod.java:67)
        	at jadx.core.dex.visitors.regions.TernaryMod.enterRegion(TernaryMod.java:50)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:96)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:27)
        	at jadx.core.dex.visitors.regions.TernaryMod.process(TernaryMod.java:36)
        	at jadx.core.dex.visitors.regions.IfRegionVisitor.process(IfRegionVisitor.java:44)
        	at jadx.core.dex.visitors.regions.IfRegionVisitor.visit(IfRegionVisitor.java:30)
        */
    static final kotlin.Unit TicketsApp$lambda$173(androidx.compose.foundation.lazy.LazyListState r25, final com.example.tickets.MainActivity r26, kotlin.jvm.functions.Function1 r27, kotlin.jvm.functions.Function0 r28, kotlin.jvm.functions.Function1 r29, final kotlinx.coroutines.CoroutineScope r30, final androidx.compose.runtime.MutableIntState r31, final androidx.compose.runtime.MutableState r32, final androidx.compose.runtime.MutableState r33, androidx.compose.runtime.MutableState r34, final androidx.compose.runtime.MutableIntState r35, final androidx.compose.runtime.MutableState r36, final androidx.compose.runtime.MutableState r37, final androidx.compose.runtime.MutableState r38, final androidx.compose.runtime.MutableState r39, final androidx.compose.runtime.MutableState r40, final androidx.compose.animation.AnimatedContentScope r41, com.example.tickets.AppScreen r42, androidx.compose.runtime.Composer r43, int r44) {
        /*
            Method dump skipped, instruction units count: 2420
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.tickets.MainActivity.TicketsApp$lambda$173(androidx.compose.foundation.lazy.LazyListState, com.example.tickets.MainActivity, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function1, kotlinx.coroutines.CoroutineScope, androidx.compose.runtime.MutableIntState, androidx.compose.runtime.MutableState, androidx.compose.runtime.MutableState, androidx.compose.runtime.MutableState, androidx.compose.runtime.MutableIntState, androidx.compose.runtime.MutableState, androidx.compose.runtime.MutableState, androidx.compose.runtime.MutableState, androidx.compose.runtime.MutableState, androidx.compose.runtime.MutableState, androidx.compose.animation.AnimatedContentScope, com.example.tickets.AppScreen, androidx.compose.runtime.Composer, int):kotlin.Unit");
    }

    static final Unit TicketsApp$lambda$173$lambda$90$lambda$89(MutableIntState mutableIntState, int i) {
        mutableIntState.setIntValue(i);
        return Unit.INSTANCE;
    }

    static final Unit TicketsApp$lambda$173$lambda$92$lambda$91(MutableState mutableState, MutableIntState mutableIntState, List imported) {
        Intrinsics.checkNotNullParameter(imported, "imported");
        mutableState.setValue(imported);
        mutableIntState.setIntValue(MainActivityKt.nextTicketIdFor(imported));
        return Unit.INSTANCE;
    }

    static final Unit TicketsApp$lambda$173$lambda$94$lambda$93(MainActivity mainActivity) {
        mainActivity.setShareReceiverMode(false);
        mainActivity.setCurrentScreen(AppScreen.RECEIVE_MENU);
        return Unit.INSTANCE;
    }

    static final Unit TicketsApp$lambda$173$lambda$97$lambda$96(MainActivity mainActivity, MutableState mutableState, List chosen) {
        Intrinsics.checkNotNullParameter(chosen, "chosen");
        List list = chosen;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(Integer.valueOf(((TicketData) it.next()).getId()));
        }
        mutableState.setValue(CollectionsKt.toSet(arrayList));
        mainActivity.setCurrentScreen(AppScreen.SHARE_MENU);
        return Unit.INSTANCE;
    }

    static final Unit TicketsApp$lambda$173$lambda$99$lambda$98(MainActivity mainActivity, boolean z) {
        mainActivity.setTransferOverlayActive(z);
        return Unit.INSTANCE;
    }

    static final Unit TicketsApp$lambda$173$lambda$101$lambda$100(MainActivity mainActivity, MutableState mutableState, TicketData ticket) {
        Intrinsics.checkNotNullParameter(ticket, "ticket");
        mutableState.setValue(Integer.valueOf(ticket.getId()));
        mainActivity.setCurrentScreen(AppScreen.DETAIL);
        return Unit.INSTANCE;
    }

    static final Unit TicketsApp$lambda$173$lambda$103$lambda$102(MainActivity mainActivity) {
        mainActivity.setCurrentScreen(AppScreen.ADD);
        return Unit.INSTANCE;
    }

    static final Unit TicketsApp$lambda$173$lambda$105$lambda$104(MutableState mutableState, boolean z) {
        TicketsApp$lambda$7(mutableState, z);
        return Unit.INSTANCE;
    }

    static final Unit TicketsApp$lambda$173$lambda$110$lambda$109(AnimatedContentScope animatedContentScope, MutableState mutableState, MutableState mutableState2, MainActivity mainActivity, MutableState mutableState3, SmartSubwayTrip smartSubwayTrip) {
        if (smartSubwayTrip == null) {
            String strTicketsApp$lambda$12 = TicketsApp$lambda$12(mutableState);
            if (strTicketsApp$lambda$12 == null) {
                strTicketsApp$lambda$12 = TicketsApp$lambda$48(mutableState2).getIntegrationMode();
            }
            try {
                Result.Companion companion = Result.INSTANCE;
                SmartSubwayRealtimeRouter.INSTANCE.cancel(mainActivity, strTicketsApp$lambda$12);
                Result.m9536constructorimpl(Unit.INSTANCE);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                Result.m9536constructorimpl(ResultKt.createFailure(th));
            }
            try {
                Result.Companion companion3 = Result.INSTANCE;
                LiveUpdateManager.INSTANCE.cancelSmartSubway(mainActivity);
                Result.m9536constructorimpl(Unit.INSTANCE);
            } catch (Throwable th2) {
                Result.Companion companion4 = Result.INSTANCE;
                Result.m9536constructorimpl(ResultKt.createFailure(th2));
            }
            try {
                Result.Companion companion5 = Result.INSTANCE;
                SamsungNowBarManager.INSTANCE.cancelSmartSubway$app(mainActivity);
                Result.m9536constructorimpl(Unit.INSTANCE);
            } catch (Throwable th3) {
                Result.Companion companion6 = Result.INSTANCE;
                Result.m9536constructorimpl(ResultKt.createFailure(th3));
            }
            mutableState.setValue(null);
        }
        mutableState3.setValue(smartSubwayTrip);
        return Unit.INSTANCE;
    }

    static final Unit TicketsApp$lambda$173$lambda$112$lambda$111(MainActivity mainActivity) {
        mainActivity.setCurrentScreen(AppScreen.MAIN);
        return Unit.INSTANCE;
    }

    static final Unit TicketsApp$lambda$173$lambda$114$lambda$113(MainActivity mainActivity, CoroutineScope coroutineScope, MutableIntState mutableIntState, MutableState mutableState, MutableState mutableState2, TicketData newTicket) {
        Intrinsics.checkNotNullParameter(newTicket, "newTicket");
        TicketData ticketDataCopy$default = TicketData.copy$default(newTicket, TicketsApp$lambda$42(mutableIntState), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, false, false, null, 1073741822, null);
        mutableState.setValue(CollectionsKt.plus((Collection) CollectionsKt.listOf(ticketDataCopy$default), (Iterable) TicketsApp$lambda$31(mutableState)));
        mutableIntState.setIntValue(TicketsApp$lambda$42(mutableIntState) + 1);
        mainActivity.setSharedImageUri(null);
        mainActivity.setCurrentScreen(AppScreen.MAIN);
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, Dispatchers.getDefault(), null, new MainActivity$TicketsApp$18$11$1$1(TicketsApp$lambda$48(mutableState2), mainActivity, ticketDataCopy$default, null), 2, null);
        return Unit.INSTANCE;
    }

    static final Unit TicketsApp$lambda$173$lambda$116$lambda$115(MainActivity mainActivity) {
        mainActivity.setCurrentScreen(AppScreen.MAIN);
        return Unit.INSTANCE;
    }

    static final Unit TicketsApp$lambda$173$lambda$118$lambda$117(MainActivity mainActivity) {
        mainActivity.setShareReceiverMode(true);
        mainActivity.setCurrentScreen(AppScreen.NFC_SHARE);
        return Unit.INSTANCE;
    }

    static final Unit TicketsApp$lambda$173$lambda$120$lambda$119(MainActivity mainActivity) {
        mainActivity.setShareReceiverMode(true);
        mainActivity.setCurrentScreen(AppScreen.QR_SHARE);
        return Unit.INSTANCE;
    }

    static final CharSequence TicketsApp$lambda$173$lambda$124$lambda$123(TicketData it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return MainActivityKt.buildTicketShareText(it);
    }

    static final Unit TicketsApp$lambda$173$lambda$126$lambda$125(MainActivity mainActivity) {
        mainActivity.setCurrentScreen(AppScreen.DETAIL);
        return Unit.INSTANCE;
    }

    static final Unit TicketsApp$lambda$173$lambda$128$lambda$127(MainActivity mainActivity) {
        mainActivity.setCurrentScreen(AppScreen.NFC_SHARE);
        return Unit.INSTANCE;
    }

    static final Unit TicketsApp$lambda$173$lambda$130$lambda$129(MainActivity mainActivity) {
        mainActivity.setCurrentScreen(AppScreen.QR_SHARE);
        return Unit.INSTANCE;
    }

    static final Unit TicketsApp$lambda$173$lambda$134$lambda$133(MainActivity mainActivity, List list) {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("text/plain");
        intent.putExtra("android.intent.extra.TEXT", CollectionsKt.joinToString$default(list, "\n\n", null, null, 0, null, new Function1() { // from class: com.example.tickets.MainActivity$$ExternalSyntheticLambda22
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MainActivity.TicketsApp$lambda$173$lambda$134$lambda$133$lambda$132$lambda$131((TicketData) obj);
            }
        }, 30, null));
        mainActivity.startActivity(Intent.createChooser(intent, "分享票据"));
        return Unit.INSTANCE;
    }

    static final CharSequence TicketsApp$lambda$173$lambda$134$lambda$133$lambda$132$lambda$131(TicketData it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return MainActivityKt.buildTicketShareText(it);
    }

    static final Unit TicketsApp$lambda$173$lambda$138$lambda$137(MainActivity mainActivity) {
        if (mainActivity.getShareReceiverMode()) {
            mainActivity.setShareReceiverMode(false);
            mainActivity.setCurrentScreen(AppScreen.RECEIVE_MENU);
        } else {
            mainActivity.setCurrentScreen(AppScreen.SHARE_MENU);
        }
        return Unit.INSTANCE;
    }

    static final Unit TicketsApp$lambda$173$lambda$141$lambda$140(MainActivity mainActivity, MutableIntState mutableIntState, MutableState mutableState, MutableState mutableState2, List incomingList) {
        Intrinsics.checkNotNullParameter(incomingList, "incomingList");
        List<TicketData> list = incomingList;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (TicketData ticketData : list) {
            int iTicketsApp$lambda$42 = TicketsApp$lambda$42(mutableIntState);
            mutableIntState.setIntValue(iTicketsApp$lambda$42 + 1);
            arrayList.add(TicketData.copy$default(ticketData, iTicketsApp$lambda$42, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, false, false, null, 67108862, null));
        }
        ArrayList arrayList2 = arrayList;
        mutableState.setValue(CollectionsKt.plus((Collection) TicketsApp$lambda$31(mutableState), (Iterable) arrayList2));
        TicketData ticketData2 = (TicketData) CollectionsKt.firstOrNull((List) arrayList2);
        mutableState2.setValue(ticketData2 != null ? Integer.valueOf(ticketData2.getId()) : TicketsApp$lambda$35(mutableState2));
        mainActivity.setCurrentScreen(arrayList2.size() == 1 ? AppScreen.DETAIL : AppScreen.MAIN);
        return Unit.INSTANCE;
    }

    static final Unit TicketsApp$lambda$173$lambda$145$lambda$144(MainActivity mainActivity) {
        if (mainActivity.getShareReceiverMode()) {
            mainActivity.setShareReceiverMode(false);
            mainActivity.setCurrentScreen(AppScreen.RECEIVE_MENU);
        } else {
            mainActivity.setCurrentScreen(AppScreen.SHARE_MENU);
        }
        return Unit.INSTANCE;
    }

    static final Unit TicketsApp$lambda$173$lambda$148$lambda$147(MainActivity mainActivity, MutableIntState mutableIntState, MutableState mutableState, MutableState mutableState2, List incomingList) {
        Intrinsics.checkNotNullParameter(incomingList, "incomingList");
        List<TicketData> list = incomingList;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (TicketData ticketData : list) {
            int iTicketsApp$lambda$42 = TicketsApp$lambda$42(mutableIntState);
            mutableIntState.setIntValue(iTicketsApp$lambda$42 + 1);
            arrayList.add(TicketData.copy$default(ticketData, iTicketsApp$lambda$42, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, false, false, null, 67108862, null));
        }
        ArrayList arrayList2 = arrayList;
        mutableState.setValue(CollectionsKt.plus((Collection) TicketsApp$lambda$31(mutableState), (Iterable) arrayList2));
        TicketData ticketData2 = (TicketData) CollectionsKt.firstOrNull((List) arrayList2);
        mutableState2.setValue(ticketData2 != null ? Integer.valueOf(ticketData2.getId()) : TicketsApp$lambda$35(mutableState2));
        mainActivity.setCurrentScreen(arrayList2.size() == 1 ? AppScreen.DETAIL : AppScreen.MAIN);
        return Unit.INSTANCE;
    }

    static final Unit TicketsApp$lambda$173$lambda$151$lambda$150(MainActivity mainActivity) {
        mainActivity.setCurrentScreen(AppScreen.MAIN);
        return Unit.INSTANCE;
    }

    static final Unit TicketsApp$lambda$173$lambda$153$lambda$152(TicketData ticketData, MainActivity mainActivity, MutableState mutableState) {
        mutableState.setValue(SetsKt.setOf(Integer.valueOf(ticketData.getId())));
        mainActivity.setShareReceiverMode(false);
        mainActivity.setCurrentScreen(AppScreen.SHARE_MENU);
        return Unit.INSTANCE;
    }

    static final Unit TicketsApp$lambda$173$lambda$155$lambda$154(TicketData ticketData, MainActivity mainActivity, MutableState mutableState) {
        if (!ticketData.getManuallyUsed()) {
            MainActivityKt.showIntegrationTicketSafely(mainActivity, ticketData, TicketsApp$lambda$48(mutableState).getIntegrationMode());
            return Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }

    static final Unit TicketsApp$lambda$173$lambda$158$lambda$157(TicketData ticketData, MainActivity mainActivity, MutableState mutableState, MutableState mutableState2) {
        ArrayList arrayList;
        boolean manuallyUsed = ticketData.getManuallyUsed();
        boolean z = !manuallyUsed;
        List<TicketData> listTicketsApp$lambda$31 = TicketsApp$lambda$31(mutableState);
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(listTicketsApp$lambda$31, 10));
        for (TicketData ticketDataCopy$default : listTicketsApp$lambda$31) {
            if (ticketDataCopy$default.getId() == ticketData.getId()) {
                arrayList = arrayList2;
                ticketDataCopy$default = TicketData.copy$default(ticketDataCopy$default, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, z, false, false, null, 1006632959, null);
            } else {
                arrayList = arrayList2;
            }
            arrayList.add(ticketDataCopy$default);
            arrayList2 = arrayList;
            manuallyUsed = manuallyUsed;
        }
        boolean z2 = manuallyUsed;
        mutableState.setValue(arrayList2);
        if (!z2) {
            MainActivity mainActivity2 = mainActivity;
            LiveUpdateManager.INSTANCE.cancelTicketLiveUpdate(mainActivity2, ticketData.getId());
            ReminderManager.INSTANCE.cancelTicketReminder$app(mainActivity2, ticketData.getId());
            XiaomiSuperIslandManager.INSTANCE.cancelTicket$app(mainActivity2, ticketData.getId());
        } else {
            if (TicketsApp$lambda$48(mutableState2).getReminderEnabled()) {
                ReminderManager.INSTANCE.scheduleTicketReminder$app(mainActivity, TicketData.copy$default(ticketData, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, false, false, null, 1006632959, null), TicketsApp$lambda$48(mutableState2));
            }
            if (TicketsApp$lambda$48(mutableState2).getLiveUpdate()) {
                MainActivity mainActivity3 = mainActivity;
                LiveUpdateManager.INSTANCE.showTicketLiveUpdate(mainActivity3, ticketData.getId(), MainActivityKt.ticketTypeName(ticketData.getType()), ticketData.getTitle(), ticketData.getCode(), ticketData.getDate(), ticketData.getTime(), (196992 & 128) != 0 ? "" : ticketData.getDepartureDate(), (196992 & 256) != 0 ? "" : ticketData.getArrivalDate(), ticketData.getFrom(), ticketData.getTo(), (196992 & 2048) != 0 ? "" : MainActivityKt.liveUpdateDeparturePlatform(ticketData), (196992 & 4096) != 0 ? "" : MainActivityKt.liveUpdateArrivalPlatform(ticketData), ticketData.getHall(), ticketData.getSeat(), ticketData.getVenue(), (65536 & 196992) != 0 ? "" : null, (131072 & 196992) != 0 ? "" : null, (262144 & 196992) != 0 ? "" : ticketData.getStartTime(), (524288 & 196992) != 0 ? "" : ticketData.getEndTime(), (1048576 & 196992) != 0 ? "" : ticketData.getTakeoffTime(), (2097152 & 196992) != 0 ? "" : ticketData.getLandingTime(), (196992 & 4194304) != 0 ? "" : ticketData.getBrand());
            } else if (TicketsApp$lambda$48(mutableState2).getSuperIsland()) {
                XiaomiSuperIslandManager.INSTANCE.showTicket$app(mainActivity, TicketData.copy$default(ticketData, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, false, false, null, 1006632959, null));
            } else if (TicketsApp$lambda$48(mutableState2).getSamsungNowBar()) {
                SamsungNowBarManager.INSTANCE.showTicket$app(mainActivity, TicketData.copy$default(ticketData, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, false, false, null, 1006632959, null));
            }
        }
        return Unit.INSTANCE;
    }

    static final Unit TicketsApp$lambda$173$lambda$161$lambda$160(MutableState mutableState, TicketData ticketData) {
        List<TicketData> listTicketsApp$lambda$31 = TicketsApp$lambda$31(mutableState);
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listTicketsApp$lambda$31, 10));
        for (TicketData ticketDataCopy$default : listTicketsApp$lambda$31) {
            if (ticketDataCopy$default.getId() == ticketData.getId()) {
                ticketDataCopy$default = TicketData.copy$default(ticketDataCopy$default, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, !ticketDataCopy$default.getFavorite(), false, null, 939524095, null);
            }
            arrayList.add(ticketDataCopy$default);
        }
        mutableState.setValue(arrayList);
        return Unit.INSTANCE;
    }

    static final Unit TicketsApp$lambda$173$lambda$163$lambda$162(MainActivity mainActivity) {
        mainActivity.setCurrentScreen(AppScreen.EDIT);
        return Unit.INSTANCE;
    }

    static final Unit TicketsApp$lambda$173$lambda$166$lambda$165(MainActivity mainActivity, CoroutineScope coroutineScope, MutableState mutableState, TicketData ticketData, MutableState mutableState2) {
        List<TicketData> listTicketsApp$lambda$31 = TicketsApp$lambda$31(mutableState);
        ArrayList arrayList = new ArrayList();
        for (Object obj : listTicketsApp$lambda$31) {
            if (((TicketData) obj).getId() != ticketData.getId()) {
                arrayList.add(obj);
            }
        }
        mutableState.setValue(arrayList);
        mutableState2.setValue(null);
        mainActivity.setCurrentScreen(AppScreen.MAIN);
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, Dispatchers.getDefault(), null, new MainActivity$TicketsApp$18$30$1$2(mainActivity, ticketData, null), 2, null);
        return Unit.INSTANCE;
    }

    static final Unit TicketsApp$lambda$173$lambda$169$lambda$168(MainActivity mainActivity) {
        mainActivity.setCurrentScreen(AppScreen.DETAIL);
        return Unit.INSTANCE;
    }

    static final Unit TicketsApp$lambda$173$lambda$172$lambda$171(TicketData ticketData, MainActivity mainActivity, MutableState mutableState, MutableState mutableState2, TicketData updatedTicket) {
        Intrinsics.checkNotNullParameter(updatedTicket, "updatedTicket");
        TicketData ticketDataCopy$default = TicketData.copy$default(updatedTicket, ticketData.getId(), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, ticketData.getManuallyUsed(), false, false, null, 1006632958, null);
        List<TicketData> listTicketsApp$lambda$31 = TicketsApp$lambda$31(mutableState);
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listTicketsApp$lambda$31, 10));
        for (TicketData ticketData2 : listTicketsApp$lambda$31) {
            if (ticketData2.getId() == ticketData.getId()) {
                ticketData2 = ticketDataCopy$default;
            }
            arrayList.add(ticketData2);
        }
        mutableState.setValue(arrayList);
        if (TicketsApp$lambda$48(mutableState2).getReminderEnabled() && !ticketDataCopy$default.getManuallyUsed()) {
            ReminderManager.INSTANCE.scheduleTicketReminder$app(mainActivity, ticketDataCopy$default, TicketsApp$lambda$48(mutableState2));
        } else {
            ReminderManager.INSTANCE.cancelTicketReminder$app(mainActivity, ticketDataCopy$default.getId());
        }
        if (TicketsApp$lambda$48(mutableState2).getLiveUpdate() && !ticketDataCopy$default.getManuallyUsed()) {
            MainActivity mainActivity2 = mainActivity;
            LiveUpdateManager.INSTANCE.showTicketLiveUpdate(mainActivity2, ticketDataCopy$default.getId(), MainActivityKt.ticketTypeName(ticketDataCopy$default.getType()), ticketDataCopy$default.getTitle(), ticketDataCopy$default.getCode(), ticketDataCopy$default.getDate(), ticketDataCopy$default.getTime(), (196992 & 128) != 0 ? "" : ticketDataCopy$default.getDepartureDate(), (196992 & 256) != 0 ? "" : ticketDataCopy$default.getArrivalDate(), ticketDataCopy$default.getFrom(), ticketDataCopy$default.getTo(), (196992 & 2048) != 0 ? "" : null, (196992 & 4096) != 0 ? "" : null, ticketDataCopy$default.getHall(), ticketDataCopy$default.getSeat(), ticketDataCopy$default.getVenue(), (65536 & 196992) != 0 ? "" : null, (131072 & 196992) != 0 ? "" : null, (262144 & 196992) != 0 ? "" : ticketDataCopy$default.getStartTime(), (524288 & 196992) != 0 ? "" : ticketDataCopy$default.getEndTime(), (1048576 & 196992) != 0 ? "" : null, (2097152 & 196992) != 0 ? "" : null, (196992 & 4194304) != 0 ? "" : ticketDataCopy$default.getBrand());
        } else if (TicketsApp$lambda$48(mutableState2).getSuperIsland() && !ticketDataCopy$default.getManuallyUsed()) {
            XiaomiSuperIslandManager.INSTANCE.showTicket$app(mainActivity, ticketDataCopy$default);
        } else if (TicketsApp$lambda$48(mutableState2).getSamsungNowBar() && !ticketDataCopy$default.getManuallyUsed()) {
            SamsungNowBarManager.INSTANCE.showTicket$app(mainActivity, ticketDataCopy$default);
        } else {
            MainActivity mainActivity3 = mainActivity;
            LiveUpdateManager.INSTANCE.cancelTicketLiveUpdate(mainActivity3, ticketDataCopy$default.getId());
            XiaomiSuperIslandManager.INSTANCE.cancelTicket$app(mainActivity3, ticketDataCopy$default.getId());
        }
        mainActivity.setCurrentScreen(AppScreen.DETAIL);
        return Unit.INSTANCE;
    }
}
