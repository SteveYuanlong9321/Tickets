package com.example.tickets;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: SmartSubwayManualAdvance.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¨\u0006\n"}, d2 = {"Lcom/example/tickets/SmartSubwayManualAdvanceReceiver;", "Landroid/content/BroadcastReceiver;", "<init>", "()V", "onReceive", "", "context", "Landroid/content/Context;", AccessibilityNodeInfoCompat.MathInfoCompat.MATH_ATTRIBUTE_INTENT, "Landroid/content/Intent;", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class SmartSubwayManualAdvanceReceiver extends BroadcastReceiver {
    public static final int $stable = 8;

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (Intrinsics.areEqual(intent != null ? intent.getAction() : null, SmartSubwayManualAdvance.ACTION) && SmartSubwayManualAdvance.INSTANCE.getAdvancing$app().compareAndSet(false, true)) {
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new AnonymousClass1(context, goAsync(), null), 3, null);
        }
    }

    /* JADX INFO: renamed from: com.example.tickets.SmartSubwayManualAdvanceReceiver$onReceive$1, reason: invalid class name */
    /* JADX INFO: compiled from: SmartSubwayManualAdvance.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.tickets.SmartSubwayManualAdvanceReceiver$onReceive$1", f = "SmartSubwayManualAdvance.kt", i = {0}, l = {159}, m = "invokeSuspend", n = {"trip"}, s = {"L$0"})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Context $context;
        final /* synthetic */ BroadcastReceiver.PendingResult $pendingResult;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Context context, BroadcastReceiver.PendingResult pendingResult, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$context = context;
            this.$pendingResult = pendingResult;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$context, this.$pendingResult, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Unit unit;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    SmartSubwayTrip smartSubwayTripLoadSmartSubwayTripLocal = MainActivityKt.loadSmartSubwayTripLocal(this.$context);
                    if (smartSubwayTripLoadSmartSubwayTripLocal == null) {
                        unit = Unit.INSTANCE;
                    } else {
                        this.L$0 = SpillingKt.nullOutSpilledVariable(smartSubwayTripLoadSmartSubwayTripLocal);
                        this.label = 1;
                        obj = SmartSubwayManualAdvance.INSTANCE.advance(this.$context, smartSubwayTripLoadSmartSubwayTripLocal, this);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                    SmartSubwayManualAdvance.INSTANCE.getAdvancing$app().set(false);
                    this.$pendingResult.finish();
                    return unit;
                }
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                SmartSubwayTrip smartSubwayTrip = (SmartSubwayTrip) obj;
                if (smartSubwayTrip == null) {
                    unit = Unit.INSTANCE;
                    SmartSubwayManualAdvance.INSTANCE.getAdvancing$app().set(false);
                    this.$pendingResult.finish();
                    return unit;
                }
                MainActivityKt.saveSmartSubwayTripLocal(this.$context, smartSubwayTrip);
                Context context = this.$context;
                Intent intent = new Intent();
                Context context2 = this.$context;
                intent.setAction(SmartSubwayManualAdvance.ACTION_UPDATED);
                intent.setPackage(context2.getPackageName());
                context.sendBroadcast(intent);
                if (!RealtimeNotificationVisibilityController.INSTANCE.isAppForeground()) {
                    SmartSubwayRealtimeRouter.INSTANCE.publish(this.$context, StringsKt.trim((CharSequence) OnlineRecognitionStore.INSTANCE.loadString$app(this.$context, "integration_mode", "Live Update")).toString(), SmartSubwayRealtimeKt.toRealtimeState(smartSubwayTrip));
                }
                SmartSubwayManualAdvance.INSTANCE.getAdvancing$app().set(false);
                this.$pendingResult.finish();
                return Unit.INSTANCE;
            } catch (Throwable th) {
                SmartSubwayManualAdvance.INSTANCE.getAdvancing$app().set(false);
                this.$pendingResult.finish();
                throw th;
            }
        }
    }
}
