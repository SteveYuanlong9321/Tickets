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
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: MainActivity.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.example.tickets.MainActivityKt$TicketEditorScreen$1$1", f = "MainActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class MainActivityKt$TicketEditorScreen$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableState<String> $areaValue$delegate;
    final /* synthetic */ MutableState<String> $arrivalDateValue$delegate;
    final /* synthetic */ MutableState<String> $arrivalGateValue$delegate;
    final /* synthetic */ MutableState<String> $arrivalPlatformValue$delegate;
    final /* synthetic */ MutableState<String> $barcodeValue$delegate;
    final /* synthetic */ MutableState<String> $brandValue$delegate;
    final /* synthetic */ MutableState<String> $codeValue$delegate;
    final /* synthetic */ MutableState<String> $dateValue$delegate;
    final /* synthetic */ MutableState<String> $departureDateValue$delegate;
    final /* synthetic */ MutableState<String> $departureGateValue$delegate;
    final /* synthetic */ MutableState<String> $departurePlatformValue$delegate;
    final /* synthetic */ Context $editorContext;
    final /* synthetic */ MutableState<String> $endTimeValue$delegate;
    final /* synthetic */ MutableState<String> $entryValue$delegate;
    final /* synthetic */ MutableState<String> $fromValue$delegate;
    final /* synthetic */ MutableState<String> $hallValue$delegate;
    final /* synthetic */ MutableState<String> $landingTimeValue$delegate;
    final /* synthetic */ MutableState<Boolean> $ocrRecognizing$delegate;
    final /* synthetic */ CoroutineScope $ocrScope;
    final /* synthetic */ MutableState<String> $ocrStatus$delegate;
    final /* synthetic */ String $onlineApiKey;
    final /* synthetic */ String $onlineModel;
    final /* synthetic */ String $onlinePrompt;
    final /* synthetic */ String $onlineProvider;
    final /* synthetic */ MutableState<String> $seatValue$delegate;
    final /* synthetic */ MutableState<Uri> $selectedImageUri$delegate;
    final /* synthetic */ MutableState<TicketType> $selectedType$delegate;
    final /* synthetic */ Uri $sharedImageUri;
    final /* synthetic */ MutableState<String> $startTimeValue$delegate;
    final /* synthetic */ MutableState<String> $takeoffTimeValue$delegate;
    final /* synthetic */ MutableState<String> $timeValue$delegate;
    final /* synthetic */ MutableState<String> $titleValue$delegate;
    final /* synthetic */ MutableState<String> $toValue$delegate;
    final /* synthetic */ MutableState<String> $venueValue$delegate;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    MainActivityKt$TicketEditorScreen$1$1(Uri uri, String str, CoroutineScope coroutineScope, MutableState<Uri> mutableState, MutableState<Boolean> mutableState2, MutableState<String> mutableState3, Context context, String str2, String str3, String str4, MutableState<TicketType> mutableState4, MutableState<String> mutableState5, MutableState<String> mutableState6, MutableState<String> mutableState7, MutableState<String> mutableState8, MutableState<String> mutableState9, MutableState<String> mutableState10, MutableState<String> mutableState11, MutableState<String> mutableState12, MutableState<String> mutableState13, MutableState<String> mutableState14, MutableState<String> mutableState15, MutableState<String> mutableState16, MutableState<String> mutableState17, MutableState<String> mutableState18, MutableState<String> mutableState19, MutableState<String> mutableState20, MutableState<String> mutableState21, MutableState<String> mutableState22, MutableState<String> mutableState23, MutableState<String> mutableState24, MutableState<String> mutableState25, MutableState<String> mutableState26, MutableState<String> mutableState27, Continuation<? super MainActivityKt$TicketEditorScreen$1$1> continuation) {
        super(2, continuation);
        this.$sharedImageUri = uri;
        this.$onlineApiKey = str;
        this.$ocrScope = coroutineScope;
        this.$selectedImageUri$delegate = mutableState;
        this.$ocrRecognizing$delegate = mutableState2;
        this.$ocrStatus$delegate = mutableState3;
        this.$editorContext = context;
        this.$onlineProvider = str2;
        this.$onlineModel = str3;
        this.$onlinePrompt = str4;
        this.$selectedType$delegate = mutableState4;
        this.$titleValue$delegate = mutableState5;
        this.$codeValue$delegate = mutableState6;
        this.$dateValue$delegate = mutableState7;
        this.$departureDateValue$delegate = mutableState8;
        this.$arrivalDateValue$delegate = mutableState9;
        this.$timeValue$delegate = mutableState10;
        this.$fromValue$delegate = mutableState11;
        this.$toValue$delegate = mutableState12;
        this.$departurePlatformValue$delegate = mutableState13;
        this.$arrivalPlatformValue$delegate = mutableState14;
        this.$departureGateValue$delegate = mutableState15;
        this.$arrivalGateValue$delegate = mutableState16;
        this.$venueValue$delegate = mutableState17;
        this.$hallValue$delegate = mutableState18;
        this.$seatValue$delegate = mutableState19;
        this.$areaValue$delegate = mutableState20;
        this.$entryValue$delegate = mutableState21;
        this.$startTimeValue$delegate = mutableState22;
        this.$endTimeValue$delegate = mutableState23;
        this.$takeoffTimeValue$delegate = mutableState24;
        this.$landingTimeValue$delegate = mutableState25;
        this.$brandValue$delegate = mutableState26;
        this.$barcodeValue$delegate = mutableState27;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MainActivityKt$TicketEditorScreen$1$1(this.$sharedImageUri, this.$onlineApiKey, this.$ocrScope, this.$selectedImageUri$delegate, this.$ocrRecognizing$delegate, this.$ocrStatus$delegate, this.$editorContext, this.$onlineProvider, this.$onlineModel, this.$onlinePrompt, this.$selectedType$delegate, this.$titleValue$delegate, this.$codeValue$delegate, this.$dateValue$delegate, this.$departureDateValue$delegate, this.$arrivalDateValue$delegate, this.$timeValue$delegate, this.$fromValue$delegate, this.$toValue$delegate, this.$departurePlatformValue$delegate, this.$arrivalPlatformValue$delegate, this.$departureGateValue$delegate, this.$arrivalGateValue$delegate, this.$venueValue$delegate, this.$hallValue$delegate, this.$seatValue$delegate, this.$areaValue$delegate, this.$entryValue$delegate, this.$startTimeValue$delegate, this.$endTimeValue$delegate, this.$takeoffTimeValue$delegate, this.$landingTimeValue$delegate, this.$brandValue$delegate, this.$barcodeValue$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((MainActivityKt$TicketEditorScreen$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        Uri uri = this.$sharedImageUri;
        if (uri == null) {
            return Unit.INSTANCE;
        }
        this.$selectedImageUri$delegate.setValue(uri);
        if (!StringsKt.isBlank(this.$onlineApiKey) && !MainActivityKt.TicketEditorScreen$lambda$461(this.$ocrRecognizing$delegate)) {
            MainActivityKt.TicketEditorScreen$lambda$462(this.$ocrRecognizing$delegate, true);
            this.$ocrStatus$delegate.setValue("正在使用在线识别处理分享图片…");
            BuildersKt__Builders_commonKt.launch$default(this.$ocrScope, null, null, new AnonymousClass1(this.$editorContext, uri, this.$onlineProvider, this.$onlineApiKey, this.$onlineModel, this.$onlinePrompt, this.$selectedType$delegate, this.$titleValue$delegate, this.$codeValue$delegate, this.$dateValue$delegate, this.$departureDateValue$delegate, this.$arrivalDateValue$delegate, this.$timeValue$delegate, this.$fromValue$delegate, this.$toValue$delegate, this.$departurePlatformValue$delegate, this.$arrivalPlatformValue$delegate, this.$departureGateValue$delegate, this.$arrivalGateValue$delegate, this.$venueValue$delegate, this.$hallValue$delegate, this.$seatValue$delegate, this.$areaValue$delegate, this.$entryValue$delegate, this.$startTimeValue$delegate, this.$endTimeValue$delegate, this.$takeoffTimeValue$delegate, this.$landingTimeValue$delegate, this.$brandValue$delegate, this.$barcodeValue$delegate, this.$ocrStatus$delegate, this.$ocrRecognizing$delegate, null), 3, null);
            return Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.example.tickets.MainActivityKt$TicketEditorScreen$1$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: MainActivity.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.tickets.MainActivityKt$TicketEditorScreen$1$1$1", f = "MainActivity.kt", i = {0, 1}, l = {9890, 9896}, m = "invokeSuspend", n = {"result", "result"}, s = {"L$0", "L$0"})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ MutableState<String> $areaValue$delegate;
        final /* synthetic */ MutableState<String> $arrivalDateValue$delegate;
        final /* synthetic */ MutableState<String> $arrivalGateValue$delegate;
        final /* synthetic */ MutableState<String> $arrivalPlatformValue$delegate;
        final /* synthetic */ MutableState<String> $barcodeValue$delegate;
        final /* synthetic */ MutableState<String> $brandValue$delegate;
        final /* synthetic */ MutableState<String> $codeValue$delegate;
        final /* synthetic */ MutableState<String> $dateValue$delegate;
        final /* synthetic */ MutableState<String> $departureDateValue$delegate;
        final /* synthetic */ MutableState<String> $departureGateValue$delegate;
        final /* synthetic */ MutableState<String> $departurePlatformValue$delegate;
        final /* synthetic */ Context $editorContext;
        final /* synthetic */ MutableState<String> $endTimeValue$delegate;
        final /* synthetic */ MutableState<String> $entryValue$delegate;
        final /* synthetic */ MutableState<String> $fromValue$delegate;
        final /* synthetic */ MutableState<String> $hallValue$delegate;
        final /* synthetic */ MutableState<String> $landingTimeValue$delegate;
        final /* synthetic */ MutableState<Boolean> $ocrRecognizing$delegate;
        final /* synthetic */ MutableState<String> $ocrStatus$delegate;
        final /* synthetic */ String $onlineApiKey;
        final /* synthetic */ String $onlineModel;
        final /* synthetic */ String $onlinePrompt;
        final /* synthetic */ String $onlineProvider;
        final /* synthetic */ MutableState<String> $seatValue$delegate;
        final /* synthetic */ MutableState<TicketType> $selectedType$delegate;
        final /* synthetic */ MutableState<String> $startTimeValue$delegate;
        final /* synthetic */ MutableState<String> $takeoffTimeValue$delegate;
        final /* synthetic */ MutableState<String> $timeValue$delegate;
        final /* synthetic */ MutableState<String> $titleValue$delegate;
        final /* synthetic */ MutableState<String> $toValue$delegate;
        final /* synthetic */ Uri $uri;
        final /* synthetic */ MutableState<String> $venueValue$delegate;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Context context, Uri uri, String str, String str2, String str3, String str4, MutableState<TicketType> mutableState, MutableState<String> mutableState2, MutableState<String> mutableState3, MutableState<String> mutableState4, MutableState<String> mutableState5, MutableState<String> mutableState6, MutableState<String> mutableState7, MutableState<String> mutableState8, MutableState<String> mutableState9, MutableState<String> mutableState10, MutableState<String> mutableState11, MutableState<String> mutableState12, MutableState<String> mutableState13, MutableState<String> mutableState14, MutableState<String> mutableState15, MutableState<String> mutableState16, MutableState<String> mutableState17, MutableState<String> mutableState18, MutableState<String> mutableState19, MutableState<String> mutableState20, MutableState<String> mutableState21, MutableState<String> mutableState22, MutableState<String> mutableState23, MutableState<String> mutableState24, MutableState<String> mutableState25, MutableState<Boolean> mutableState26, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$editorContext = context;
            this.$uri = uri;
            this.$onlineProvider = str;
            this.$onlineApiKey = str2;
            this.$onlineModel = str3;
            this.$onlinePrompt = str4;
            this.$selectedType$delegate = mutableState;
            this.$titleValue$delegate = mutableState2;
            this.$codeValue$delegate = mutableState3;
            this.$dateValue$delegate = mutableState4;
            this.$departureDateValue$delegate = mutableState5;
            this.$arrivalDateValue$delegate = mutableState6;
            this.$timeValue$delegate = mutableState7;
            this.$fromValue$delegate = mutableState8;
            this.$toValue$delegate = mutableState9;
            this.$departurePlatformValue$delegate = mutableState10;
            this.$arrivalPlatformValue$delegate = mutableState11;
            this.$departureGateValue$delegate = mutableState12;
            this.$arrivalGateValue$delegate = mutableState13;
            this.$venueValue$delegate = mutableState14;
            this.$hallValue$delegate = mutableState15;
            this.$seatValue$delegate = mutableState16;
            this.$areaValue$delegate = mutableState17;
            this.$entryValue$delegate = mutableState18;
            this.$startTimeValue$delegate = mutableState19;
            this.$endTimeValue$delegate = mutableState20;
            this.$takeoffTimeValue$delegate = mutableState21;
            this.$landingTimeValue$delegate = mutableState22;
            this.$brandValue$delegate = mutableState23;
            this.$barcodeValue$delegate = mutableState24;
            this.$ocrStatus$delegate = mutableState25;
            this.$ocrRecognizing$delegate = mutableState26;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$editorContext, this.$uri, this.$onlineProvider, this.$onlineApiKey, this.$onlineModel, this.$onlinePrompt, this.$selectedType$delegate, this.$titleValue$delegate, this.$codeValue$delegate, this.$dateValue$delegate, this.$departureDateValue$delegate, this.$arrivalDateValue$delegate, this.$timeValue$delegate, this.$fromValue$delegate, this.$toValue$delegate, this.$departurePlatformValue$delegate, this.$arrivalPlatformValue$delegate, this.$departureGateValue$delegate, this.$arrivalGateValue$delegate, this.$venueValue$delegate, this.$hallValue$delegate, this.$seatValue$delegate, this.$areaValue$delegate, this.$entryValue$delegate, this.$startTimeValue$delegate, this.$endTimeValue$delegate, this.$takeoffTimeValue$delegate, this.$landingTimeValue$delegate, this.$brandValue$delegate, this.$barcodeValue$delegate, this.$ocrStatus$delegate, this.$ocrRecognizing$delegate, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:25:0x0151 A[Catch: all -> 0x018f, Exception -> 0x0192, Merged into TryCatch #1 {all -> 0x018f, Exception -> 0x0192, blocks: (B:7:0x0013, B:28:0x0169, B:30:0x016d, B:31:0x0179, B:33:0x0187, B:39:0x0194, B:42:0x019e, B:12:0x0024, B:20:0x0133, B:22:0x0137, B:23:0x0143, B:25:0x0151, B:15:0x002c, B:17:0x011b), top: B:47:0x0009 }] */
        /* JADX WARN: Code duplicated, block: B:31:0x0179 A[Catch: all -> 0x018f, Exception -> 0x0192, Merged into TryCatch #1 {all -> 0x018f, Exception -> 0x0192, blocks: (B:7:0x0013, B:28:0x0169, B:30:0x016d, B:31:0x0179, B:33:0x0187, B:39:0x0194, B:42:0x019e, B:12:0x0024, B:20:0x0133, B:22:0x0137, B:23:0x0143, B:25:0x0151, B:15:0x002c, B:17:0x011b), top: B:47:0x0009 }] */
        /* JADX WARN: Code duplicated, block: B:33:0x0187 A[Catch: all -> 0x018f, Exception -> 0x0192, Merged into TryCatch #1 {all -> 0x018f, Exception -> 0x0192, blocks: (B:7:0x0013, B:28:0x0169, B:30:0x016d, B:31:0x0179, B:33:0x0187, B:39:0x0194, B:42:0x019e, B:12:0x0024, B:20:0x0133, B:22:0x0137, B:23:0x0143, B:25:0x0151, B:15:0x002c, B:17:0x011b), top: B:47:0x0009 }, TRY_LEAVE] */
        /* JADX WARN: Code restructure failed: missing block: B:26:0x0166, code lost:
        
            if (r13 == r0) goto L27;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            OnlineRecognitionResult onlineRecognitionResultRecognizeTicket$app;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i != 0) {
                    if (i == 1) {
                        onlineRecognitionResultRecognizeTicket$app = (OnlineRecognitionResult) this.L$0;
                        ResultKt.throwOnFailure(obj);
                    } else {
                        if (i != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    String str = (String) obj;
                    if (str != null) {
                        MutableState<String> mutableState = this.$codeValue$delegate;
                        MutableState<String> mutableState2 = this.$ocrStatus$delegate;
                        mutableState.setValue(str);
                        mutableState2.setValue("已读取二维码 / 条形码，并自动填入票号");
                    }
                    if (StringsKt.isBlank(MainActivityKt.TicketEditorScreen$lambda$464(this.$ocrStatus$delegate))) {
                        this.$ocrStatus$delegate.setValue("在线识别完成，已自动填写可识别字段");
                    }
                    return Unit.INSTANCE;
                }
                ResultKt.throwOnFailure(obj);
                onlineRecognitionResultRecognizeTicket$app = OnlineRecognitionClient.INSTANCE.recognizeTicket$app(this.$editorContext, this.$uri, this.$onlineProvider, this.$onlineApiKey, this.$onlineModel, this.$onlinePrompt);
                this.$selectedType$delegate.setValue(onlineRecognitionResultRecognizeTicket$app.getType());
                this.$titleValue$delegate.setValue(onlineRecognitionResultRecognizeTicket$app.getTitle());
                this.$codeValue$delegate.setValue(onlineRecognitionResultRecognizeTicket$app.getCode());
                this.$dateValue$delegate.setValue(onlineRecognitionResultRecognizeTicket$app.getDate());
                this.$departureDateValue$delegate.setValue(onlineRecognitionResultRecognizeTicket$app.getDepartureDate());
                this.$arrivalDateValue$delegate.setValue(onlineRecognitionResultRecognizeTicket$app.getArrivalDate());
                this.$timeValue$delegate.setValue(onlineRecognitionResultRecognizeTicket$app.getTime());
                this.$fromValue$delegate.setValue(onlineRecognitionResultRecognizeTicket$app.getFrom());
                this.$toValue$delegate.setValue(onlineRecognitionResultRecognizeTicket$app.getTo());
                this.$departurePlatformValue$delegate.setValue(onlineRecognitionResultRecognizeTicket$app.getDeparturePlatform());
                this.$arrivalPlatformValue$delegate.setValue(onlineRecognitionResultRecognizeTicket$app.getArrivalPlatform());
                this.$departureGateValue$delegate.setValue(onlineRecognitionResultRecognizeTicket$app.getDepartureGate());
                this.$arrivalGateValue$delegate.setValue(onlineRecognitionResultRecognizeTicket$app.getArrivalGate());
                this.$venueValue$delegate.setValue(onlineRecognitionResultRecognizeTicket$app.getVenue());
                this.$hallValue$delegate.setValue(onlineRecognitionResultRecognizeTicket$app.getHall());
                this.$seatValue$delegate.setValue(onlineRecognitionResultRecognizeTicket$app.getSeat());
                this.$areaValue$delegate.setValue(onlineRecognitionResultRecognizeTicket$app.getArea());
                this.$entryValue$delegate.setValue(onlineRecognitionResultRecognizeTicket$app.getEntry());
                this.$startTimeValue$delegate.setValue(onlineRecognitionResultRecognizeTicket$app.getStartTime());
                this.$endTimeValue$delegate.setValue(onlineRecognitionResultRecognizeTicket$app.getEndTime());
                this.$takeoffTimeValue$delegate.setValue(onlineRecognitionResultRecognizeTicket$app.getTakeoffTime());
                this.$landingTimeValue$delegate.setValue(onlineRecognitionResultRecognizeTicket$app.getLandingTime());
                this.$brandValue$delegate.setValue(onlineRecognitionResultRecognizeTicket$app.getBrand());
                if (!StringsKt.isBlank(MainActivityKt.TicketEditorScreen$lambda$385(this.$barcodeValue$delegate))) {
                    if (StringsKt.isBlank(MainActivityKt.TicketEditorScreen$lambda$382(this.$codeValue$delegate))) {
                        if (StringsKt.isBlank(MainActivityKt.TicketEditorScreen$lambda$464(this.$ocrStatus$delegate))) {
                            this.$ocrStatus$delegate.setValue("在线识别完成，已自动填写可识别字段");
                        }
                    } else {
                        this.L$0 = SpillingKt.nullOutSpilledVariable(onlineRecognitionResultRecognizeTicket$app);
                        this.label = 2;
                        obj = TicketBarcodeScanner.INSTANCE.scanFirst(this.$editorContext, this.$uri, this);
                    }
                    return Unit.INSTANCE;
                }
                this.L$0 = SpillingKt.nullOutSpilledVariable(onlineRecognitionResultRecognizeTicket$app);
                this.label = 1;
                obj = TicketBarcodeScanner.INSTANCE.scanFirst(this.$editorContext, this.$uri, this);
                if (obj == coroutine_suspended) {
                }
                return coroutine_suspended;
                String str2 = (String) obj;
                if (str2 != null) {
                    MutableState<String> mutableState3 = this.$barcodeValue$delegate;
                    MutableState<String> mutableState4 = this.$ocrStatus$delegate;
                    mutableState3.setValue(str2);
                    mutableState4.setValue("已读取二维码 / 条形码");
                }
                if (StringsKt.isBlank(MainActivityKt.TicketEditorScreen$lambda$382(this.$codeValue$delegate))) {
                    if (StringsKt.isBlank(MainActivityKt.TicketEditorScreen$lambda$464(this.$ocrStatus$delegate))) {
                        this.$ocrStatus$delegate.setValue("在线识别完成，已自动填写可识别字段");
                    }
                } else {
                    this.L$0 = SpillingKt.nullOutSpilledVariable(onlineRecognitionResultRecognizeTicket$app);
                    this.label = 2;
                    obj = TicketBarcodeScanner.INSTANCE.scanFirst(this.$editorContext, this.$uri, this);
                }
            } catch (Exception e) {
                MutableState<String> mutableState5 = this.$ocrStatus$delegate;
                String message = e.getMessage();
                if (message == null) {
                    message = "在线识别失败";
                }
                mutableState5.setValue(message);
            } finally {
                MainActivityKt.TicketEditorScreen$lambda$462(this.$ocrRecognizing$delegate, false);
            }
            return Unit.INSTANCE;
        }
    }
}
