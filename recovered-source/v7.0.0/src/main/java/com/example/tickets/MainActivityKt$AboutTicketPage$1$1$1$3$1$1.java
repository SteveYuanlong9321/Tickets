package com.example.tickets;

import android.content.Context;
import android.widget.Toast;
import androidx.compose.runtime.MutableState;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: MainActivity.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.example.tickets.MainActivityKt$AboutTicketPage$1$1$1$3$1$1", f = "MainActivity.kt", i = {}, l = {17684}, m = "invokeSuspend", n = {}, s = {})
final class MainActivityKt$AboutTicketPage$1$1$1$3$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ MutableState<AppUpdateInfo> $pendingUpdateInfo$delegate;
    final /* synthetic */ MutableState<Boolean> $updateChecking$delegate;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    MainActivityKt$AboutTicketPage$1$1$1$3$1$1(MutableState<Boolean> mutableState, Context context, MutableState<AppUpdateInfo> mutableState2, Continuation<? super MainActivityKt$AboutTicketPage$1$1$1$3$1$1> continuation) {
        super(2, continuation);
        this.$updateChecking$delegate = mutableState;
        this.$context = context;
        this.$pendingUpdateInfo$delegate = mutableState2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MainActivityKt$AboutTicketPage$1$1$1$3$1$1(this.$updateChecking$delegate, this.$context, this.$pendingUpdateInfo$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((MainActivityKt$AboutTicketPage$1$1$1$3$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object objCheckForAppUpdate;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            objCheckForAppUpdate = MainActivityKt.checkForAppUpdate(this);
            if (objCheckForAppUpdate == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            objCheckForAppUpdate = ((Result) obj).getValue();
        }
        MainActivityKt.AboutTicketPage$lambda$991(this.$updateChecking$delegate, false);
        Context context = this.$context;
        MutableState<AppUpdateInfo> mutableState = this.$pendingUpdateInfo$delegate;
        if (Result.m9543isSuccessimpl(objCheckForAppUpdate)) {
            AppUpdateInfo appUpdateInfo = (AppUpdateInfo) objCheckForAppUpdate;
            if (appUpdateInfo == null) {
                Toast.makeText(context, "无更新", 0).show();
            } else {
                mutableState.setValue(appUpdateInfo);
            }
        }
        Context context2 = this.$context;
        if (Result.m9539exceptionOrNullimpl(objCheckForAppUpdate) != null) {
            Toast.makeText(context2, "检查更新失败，请检查网络连接", 0).show();
        }
        return Unit.INSTANCE;
    }
}
