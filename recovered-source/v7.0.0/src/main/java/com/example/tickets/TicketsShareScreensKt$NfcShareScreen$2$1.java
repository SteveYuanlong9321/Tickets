package com.example.tickets;

import android.app.Activity;
import android.content.Context;
import androidx.compose.runtime.MutableState;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: compiled from: TicketsShareScreens.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.example.tickets.TicketsShareScreensKt$NfcShareScreen$2$1", f = "TicketsShareScreens.kt", i = {}, l = {870}, m = "invokeSuspend", n = {}, s = {})
final class TicketsShareScreensKt$NfcShareScreen$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ MutableState<Boolean> $hasPermissions$delegate;
    final /* synthetic */ MutableState<Boolean> $receiverMode$delegate;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    TicketsShareScreensKt$NfcShareScreen$2$1(Context context, MutableState<Boolean> mutableState, MutableState<Boolean> mutableState2, Continuation<? super TicketsShareScreensKt$NfcShareScreen$2$1> continuation) {
        super(2, continuation);
        this.$context = context;
        this.$hasPermissions$delegate = mutableState;
        this.$receiverMode$delegate = mutableState2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TicketsShareScreensKt$NfcShareScreen$2$1(this.$context, this.$hasPermissions$delegate, this.$receiverMode$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((TicketsShareScreensKt$NfcShareScreen$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            if (!TicketsShareScreensKt.NfcShareScreen$lambda$65(this.$hasPermissions$delegate) || TicketNfcCompatibility.INSTANCE.preferredMode(this.$context) != TicketNfcCompatibility.Mode.HCE) {
                return Unit.INSTANCE;
            }
            this.label = 1;
            if (DelayKt.delay(3000L, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        if (TicketsShareScreensKt.NfcShareScreen$lambda$60(this.$receiverMode$delegate)) {
            TicketShareManager.UiState uiState = TicketShareManager.INSTANCE.getUiState();
            if ((uiState.getRole() != TicketShareManager.Role.RECEIVER || uiState.getTransport() != TicketShareManager.Transport.NFC || StringsKt.isBlank(uiState.getSessionId()) || StringsKt.isBlank(uiState.getToken())) && uiState.getState() != TicketShareManager.State.SCANNED && uiState.getState() != TicketShareManager.State.WAITING_RECEIVER_CONFIRM && uiState.getState() != TicketShareManager.State.SUCCESS) {
                NfcReaderBridge nfcReaderBridge = NfcReaderBridge.INSTANCE;
                Context context = this.$context;
                nfcReaderBridge.disable(context instanceof Activity ? (Activity) context : null);
                TicketShareManager.INSTANCE.startNfcCompatibilityReceiver(this.$context);
            }
        } else {
            TicketShareManager.UiState uiState2 = TicketShareManager.INSTANCE.getUiState();
            if (uiState2.getRole() == TicketShareManager.Role.SENDER && uiState2.getState() != TicketShareManager.State.SCANNED && uiState2.getState() != TicketShareManager.State.WAITING_RECEIVER_CONFIRM && uiState2.getState() != TicketShareManager.State.SUCCESS) {
                TicketShareManager.INSTANCE.activateLegacyNfcFallback(this.$context);
                TicketNfcCompatibility ticketNfcCompatibility = TicketNfcCompatibility.INSTANCE;
                Context context2 = this.$context;
                ticketNfcCompatibility.startLegacySender(context2 instanceof Activity ? (Activity) context2 : null, uiState2.getSessionId(), uiState2.getToken());
            }
        }
        return Unit.INSTANCE;
    }
}
