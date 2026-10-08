package com.example.tickets;

import android.content.Context;
import android.net.Uri;
import androidx.compose.runtime.MutableState;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: MainActivity.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.example.tickets.MainActivityKt$SmartRecognitionPage$imagePicker$1$1$2", f = "MainActivity.kt", i = {}, l = {16534}, m = "invokeSuspend", n = {}, s = {})
final class MainActivityKt$SmartRecognitionPage$imagePicker$1$1$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ MutableState<String> $recognitionError$delegate;
    final /* synthetic */ MutableState<String> $recognizedText$delegate;
    final /* synthetic */ MutableState<Boolean> $recognizing$delegate;
    final /* synthetic */ AppSettings $settings;
    final /* synthetic */ Uri $uri;
    Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    MainActivityKt$SmartRecognitionPage$imagePicker$1$1$2(AppSettings appSettings, Context context, Uri uri, MutableState<String> mutableState, MutableState<String> mutableState2, MutableState<Boolean> mutableState3, Continuation<? super MainActivityKt$SmartRecognitionPage$imagePicker$1$1$2> continuation) {
        super(2, continuation);
        this.$settings = appSettings;
        this.$context = context;
        this.$uri = uri;
        this.$recognizedText$delegate = mutableState;
        this.$recognitionError$delegate = mutableState2;
        this.$recognizing$delegate = mutableState3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MainActivityKt$SmartRecognitionPage$imagePicker$1$1$2(this.$settings, this.$context, this.$uri, this.$recognizedText$delegate, this.$recognitionError$delegate, this.$recognizing$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((MainActivityKt$SmartRecognitionPage$imagePicker$1$1$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        MutableState<String> mutableState;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                if (Intrinsics.areEqual(this.$settings.getRecognitionMode(), "在线识别")) {
                    if (StringsKt.isBlank(this.$settings.getOnlineApiKey())) {
                        throw new IllegalStateException("请先填写 API Key。");
                    }
                    this.$recognizedText$delegate.setValue(OnlineRecognitionClient.INSTANCE.recognizeTicket$app(this.$context, this.$uri, this.$settings.getOnlineProvider(), this.$settings.getOnlineApiKey(), this.$settings.getOnlineModel(), this.$settings.getOnlinePrompt()).getRawResponse());
                } else {
                    MutableState<String> mutableState2 = this.$recognizedText$delegate;
                    this.L$0 = mutableState2;
                    this.label = 1;
                    Object objRecognizeText = OcrManager.INSTANCE.recognizeText(this.$context, this.$uri, this.$settings.getOcrAccuracy(), this);
                    if (objRecognizeText == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    mutableState = mutableState2;
                    obj = objRecognizeText;
                }
                return Unit.INSTANCE;
            }
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            mutableState = (MutableState) this.L$0;
            ResultKt.throwOnFailure(obj);
            mutableState.setValue((String) obj);
        } catch (Exception e) {
            MutableState<String> mutableState3 = this.$recognitionError$delegate;
            String message = e.getMessage();
            if (message == null) {
                message = "识别失败，请重试。";
            }
            mutableState3.setValue(message);
        } finally {
            MainActivityKt.SmartRecognitionPage$lambda$941(this.$recognizing$delegate, false);
        }
        return Unit.INSTANCE;
    }
}
