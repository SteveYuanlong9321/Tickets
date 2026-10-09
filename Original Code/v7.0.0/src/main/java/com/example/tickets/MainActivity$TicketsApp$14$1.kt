package com.example.tickets;

import android.os.Build;
import androidx.activity.compose.ManagedActivityResultLauncher;
import androidx.compose.runtime.MutableState;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: compiled from: MainActivity.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.example.tickets.MainActivity$TicketsApp$14$1", f = "MainActivity.kt", i = {0}, l = {2527}, m = "invokeSuspend", n = {"granted"}, s = {"I$0"})
final class MainActivity$TicketsApp$14$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableState<AppSettings> $appSettings$delegate;
    final /* synthetic */ ManagedActivityResultLauncher<String, Boolean> $notificationLauncher;
    final /* synthetic */ MutableState<List<TicketData>> $tickets$delegate;
    int I$0;
    int label;
    final /* synthetic */ MainActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    MainActivity$TicketsApp$14$1(MainActivity mainActivity, ManagedActivityResultLauncher<String, Boolean> managedActivityResultLauncher, MutableState<AppSettings> mutableState, MutableState<List<TicketData>> mutableState2, Continuation<? super MainActivity$TicketsApp$14$1> continuation) {
        super(2, continuation);
        this.this$0 = mainActivity;
        this.$notificationLauncher = managedActivityResultLauncher;
        this.$appSettings$delegate = mutableState;
        this.$tickets$delegate = mutableState2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MainActivity$TicketsApp$14$1(this.this$0, this.$notificationLauncher, this.$appSettings$delegate, this.$tickets$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((MainActivity$TicketsApp$14$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0062  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            LiveUpdateManager.INSTANCE.createNotificationChannel(this.this$0);
            if (Build.VERSION.SDK_INT >= 33) {
                int i2 = this.this$0.checkSelfPermission("android.permission.POST_NOTIFICATIONS") == 0 ? 1 : 0;
                if (i2 == 0) {
                    this.I$0 = i2;
                    this.label = 1;
                    if (DelayKt.delay(500L, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
            }
            ReminderManager.INSTANCE.createNotificationChannel$app(this.this$0);
            if (MainActivity.TicketsApp$lambda$48(this.$appSettings$delegate).getReminderEnabled()) {
                ReminderManager.INSTANCE.scheduleAll$app(this.this$0, MainActivity.TicketsApp$lambda$31(this.$tickets$delegate), MainActivity.TicketsApp$lambda$48(this.$appSettings$delegate));
            }
            return Unit.INSTANCE;
        }
        if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        this.$notificationLauncher.launch("android.permission.POST_NOTIFICATIONS");
        ReminderManager.INSTANCE.createNotificationChannel$app(this.this$0);
        if (MainActivity.TicketsApp$lambda$48(this.$appSettings$delegate).getReminderEnabled()) {
            ReminderManager.INSTANCE.scheduleAll$app(this.this$0, MainActivity.TicketsApp$lambda$31(this.$tickets$delegate), MainActivity.TicketsApp$lambda$48(this.$appSettings$delegate));
        }
        return Unit.INSTANCE;
    }
}
