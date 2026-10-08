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
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: MainActivity.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.example.tickets.MainActivityKt$TicketEditorScreen$imagePicker$1$1$2", f = "MainActivity.kt", i = {0}, l = {9814, 9827, 9836}, m = "invokeSuspend", n = {"result"}, s = {"L$0"})
final class MainActivityKt$TicketEditorScreen$imagePicker$1$1$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
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
    final /* synthetic */ String $ocrAccuracy;
    final /* synthetic */ boolean $ocrEnabled;
    final /* synthetic */ MutableState<Boolean> $ocrRecognizing$delegate;
    final /* synthetic */ MutableState<String> $ocrStatus$delegate;
    final /* synthetic */ String $onlineApiKey;
    final /* synthetic */ String $onlineModel;
    final /* synthetic */ String $onlinePrompt;
    final /* synthetic */ String $onlineProvider;
    final /* synthetic */ String $recognitionMode;
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
    MainActivityKt$TicketEditorScreen$imagePicker$1$1$2(String str, String str2, Context context, Uri uri, String str3, String str4, String str5, boolean z, String str6, MutableState<TicketType> mutableState, MutableState<String> mutableState2, MutableState<String> mutableState3, MutableState<String> mutableState4, MutableState<String> mutableState5, MutableState<String> mutableState6, MutableState<String> mutableState7, MutableState<String> mutableState8, MutableState<String> mutableState9, MutableState<String> mutableState10, MutableState<String> mutableState11, MutableState<String> mutableState12, MutableState<String> mutableState13, MutableState<String> mutableState14, MutableState<String> mutableState15, MutableState<String> mutableState16, MutableState<String> mutableState17, MutableState<String> mutableState18, MutableState<String> mutableState19, MutableState<String> mutableState20, MutableState<String> mutableState21, MutableState<String> mutableState22, MutableState<String> mutableState23, MutableState<String> mutableState24, MutableState<String> mutableState25, MutableState<Boolean> mutableState26, Continuation<? super MainActivityKt$TicketEditorScreen$imagePicker$1$1$2> continuation) {
        super(2, continuation);
        this.$recognitionMode = str;
        this.$onlineApiKey = str2;
        this.$editorContext = context;
        this.$uri = uri;
        this.$onlineProvider = str3;
        this.$onlineModel = str4;
        this.$onlinePrompt = str5;
        this.$ocrEnabled = z;
        this.$ocrAccuracy = str6;
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
        return new MainActivityKt$TicketEditorScreen$imagePicker$1$1$2(this.$recognitionMode, this.$onlineApiKey, this.$editorContext, this.$uri, this.$onlineProvider, this.$onlineModel, this.$onlinePrompt, this.$ocrEnabled, this.$ocrAccuracy, this.$selectedType$delegate, this.$titleValue$delegate, this.$codeValue$delegate, this.$dateValue$delegate, this.$departureDateValue$delegate, this.$arrivalDateValue$delegate, this.$timeValue$delegate, this.$fromValue$delegate, this.$toValue$delegate, this.$departurePlatformValue$delegate, this.$arrivalPlatformValue$delegate, this.$departureGateValue$delegate, this.$arrivalGateValue$delegate, this.$venueValue$delegate, this.$hallValue$delegate, this.$seatValue$delegate, this.$areaValue$delegate, this.$entryValue$delegate, this.$startTimeValue$delegate, this.$endTimeValue$delegate, this.$takeoffTimeValue$delegate, this.$landingTimeValue$delegate, this.$brandValue$delegate, this.$barcodeValue$delegate, this.$ocrStatus$delegate, this.$ocrRecognizing$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((MainActivityKt$TicketEditorScreen$imagePicker$1$1$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:101:0x02da A[Catch: all -> 0x002d, Exception -> 0x0030, TryCatch #0 {Exception -> 0x0030, blocks: (B:7:0x0016, B:11:0x0026, B:112:0x0313, B:116:0x036b, B:117:0x036e, B:119:0x037c, B:18:0x0038, B:96:0x02be, B:98:0x02c2, B:99:0x02cc, B:101:0x02da, B:21:0x0042, B:23:0x004c, B:25:0x0056, B:27:0x0081, B:28:0x0085, B:30:0x009a, B:31:0x009e, B:33:0x00b3, B:34:0x00b7, B:36:0x00cc, B:37:0x00d0, B:39:0x00e5, B:40:0x00e9, B:42:0x00fe, B:43:0x0102, B:45:0x0117, B:46:0x011b, B:48:0x0130, B:49:0x0134, B:51:0x0149, B:52:0x014d, B:54:0x0162, B:55:0x0166, B:57:0x017b, B:58:0x017f, B:60:0x0194, B:61:0x0198, B:63:0x01ad, B:64:0x01b1, B:66:0x01c6, B:67:0x01ca, B:69:0x01df, B:70:0x01e3, B:72:0x01f8, B:73:0x01fc, B:75:0x0211, B:76:0x0215, B:78:0x022a, B:79:0x022e, B:81:0x0243, B:82:0x0247, B:84:0x025c, B:85:0x0260, B:87:0x0275, B:88:0x0279, B:90:0x028e, B:91:0x0292, B:93:0x02a5, B:102:0x02e3, B:103:0x02ea, B:104:0x02eb, B:106:0x02ef, B:109:0x02fe), top: B:145:0x000e }] */
    /* JADX WARN: Code duplicated, block: B:114:0x0366  */
    /* JADX WARN: Code duplicated, block: B:115:0x0369  */
    /* JADX WARN: Code duplicated, block: B:119:0x037c A[Catch: all -> 0x002d, Exception -> 0x0030, TRY_LEAVE, TryCatch #0 {Exception -> 0x0030, blocks: (B:7:0x0016, B:11:0x0026, B:112:0x0313, B:116:0x036b, B:117:0x036e, B:119:0x037c, B:18:0x0038, B:96:0x02be, B:98:0x02c2, B:99:0x02cc, B:101:0x02da, B:21:0x0042, B:23:0x004c, B:25:0x0056, B:27:0x0081, B:28:0x0085, B:30:0x009a, B:31:0x009e, B:33:0x00b3, B:34:0x00b7, B:36:0x00cc, B:37:0x00d0, B:39:0x00e5, B:40:0x00e9, B:42:0x00fe, B:43:0x0102, B:45:0x0117, B:46:0x011b, B:48:0x0130, B:49:0x0134, B:51:0x0149, B:52:0x014d, B:54:0x0162, B:55:0x0166, B:57:0x017b, B:58:0x017f, B:60:0x0194, B:61:0x0198, B:63:0x01ad, B:64:0x01b1, B:66:0x01c6, B:67:0x01ca, B:69:0x01df, B:70:0x01e3, B:72:0x01f8, B:73:0x01fc, B:75:0x0211, B:76:0x0215, B:78:0x022a, B:79:0x022e, B:81:0x0243, B:82:0x0247, B:84:0x025c, B:85:0x0260, B:87:0x0275, B:88:0x0279, B:90:0x028e, B:91:0x0292, B:93:0x02a5, B:102:0x02e3, B:103:0x02ea, B:104:0x02eb, B:106:0x02ef, B:109:0x02fe), top: B:145:0x000e }] */
    /* JADX WARN: Code duplicated, block: B:138:0x03c0  */
    /* JADX WARN: Code duplicated, block: B:98:0x02c2 A[Catch: all -> 0x002d, Exception -> 0x0030, TryCatch #0 {Exception -> 0x0030, blocks: (B:7:0x0016, B:11:0x0026, B:112:0x0313, B:116:0x036b, B:117:0x036e, B:119:0x037c, B:18:0x0038, B:96:0x02be, B:98:0x02c2, B:99:0x02cc, B:101:0x02da, B:21:0x0042, B:23:0x004c, B:25:0x0056, B:27:0x0081, B:28:0x0085, B:30:0x009a, B:31:0x009e, B:33:0x00b3, B:34:0x00b7, B:36:0x00cc, B:37:0x00d0, B:39:0x00e5, B:40:0x00e9, B:42:0x00fe, B:43:0x0102, B:45:0x0117, B:46:0x011b, B:48:0x0130, B:49:0x0134, B:51:0x0149, B:52:0x014d, B:54:0x0162, B:55:0x0166, B:57:0x017b, B:58:0x017f, B:60:0x0194, B:61:0x0198, B:63:0x01ad, B:64:0x01b1, B:66:0x01c6, B:67:0x01ca, B:69:0x01df, B:70:0x01e3, B:72:0x01f8, B:73:0x01fc, B:75:0x0211, B:76:0x0215, B:78:0x022a, B:79:0x022e, B:81:0x0243, B:82:0x0247, B:84:0x025c, B:85:0x0260, B:87:0x0275, B:88:0x0279, B:90:0x028e, B:91:0x0292, B:93:0x02a5, B:102:0x02e3, B:103:0x02ea, B:104:0x02eb, B:106:0x02ef, B:109:0x02fe), top: B:145:0x000e }] */
    /* JADX WARN: Code restructure failed: missing block: B:122:0x038f, code lost:
    
        if (r2 == r0) goto L123;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        String str;
        String str2;
        Object objRecognizeText;
        Object objScanFirst;
        String str3;
        Object objScanFirst2;
        OcrTicketDraft ocrTicketDraft;
        String str4;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    if (Intrinsics.areEqual(this.$recognitionMode, "在线识别")) {
                        if (StringsKt.isBlank(this.$onlineApiKey)) {
                            throw new IllegalStateException("请先在设置 → 智能识别中填写 API Key。");
                        }
                        OnlineRecognitionResult onlineRecognitionResultRecognizeTicket$app = OnlineRecognitionClient.INSTANCE.recognizeTicket$app(this.$editorContext, this.$uri, this.$onlineProvider, this.$onlineApiKey, this.$onlineModel, this.$onlinePrompt);
                        this.$selectedType$delegate.setValue(onlineRecognitionResultRecognizeTicket$app.getType());
                        MutableState<String> mutableState = this.$titleValue$delegate;
                        String title = onlineRecognitionResultRecognizeTicket$app.getTitle();
                        MutableState<String> mutableState2 = this.$titleValue$delegate;
                        if (StringsKt.isBlank(title)) {
                            title = MainActivityKt.TicketEditorScreen$lambda$379(mutableState2);
                        }
                        mutableState.setValue(title);
                        MutableState<String> mutableState3 = this.$codeValue$delegate;
                        String code = onlineRecognitionResultRecognizeTicket$app.getCode();
                        MutableState<String> mutableState4 = this.$codeValue$delegate;
                        if (StringsKt.isBlank(code)) {
                            code = MainActivityKt.TicketEditorScreen$lambda$382(mutableState4);
                        }
                        mutableState3.setValue(code);
                        MutableState<String> mutableState5 = this.$dateValue$delegate;
                        String date = onlineRecognitionResultRecognizeTicket$app.getDate();
                        MutableState<String> mutableState6 = this.$dateValue$delegate;
                        if (StringsKt.isBlank(date)) {
                            date = MainActivityKt.TicketEditorScreen$lambda$394(mutableState6);
                        }
                        mutableState5.setValue(date);
                        MutableState<String> mutableState7 = this.$departureDateValue$delegate;
                        String departureDate = onlineRecognitionResultRecognizeTicket$app.getDepartureDate();
                        MutableState<String> mutableState8 = this.$dateValue$delegate;
                        if (StringsKt.isBlank(departureDate)) {
                            departureDate = MainActivityKt.TicketEditorScreen$lambda$394(mutableState8);
                        }
                        mutableState7.setValue(departureDate);
                        MutableState<String> mutableState9 = this.$arrivalDateValue$delegate;
                        String arrivalDate = onlineRecognitionResultRecognizeTicket$app.getArrivalDate();
                        MutableState<String> mutableState10 = this.$departureDateValue$delegate;
                        if (StringsKt.isBlank(arrivalDate)) {
                            arrivalDate = MainActivityKt.TicketEditorScreen$lambda$398(mutableState10);
                        }
                        mutableState9.setValue(arrivalDate);
                        MutableState<String> mutableState11 = this.$timeValue$delegate;
                        String time = onlineRecognitionResultRecognizeTicket$app.getTime();
                        MutableState<String> mutableState12 = this.$timeValue$delegate;
                        if (StringsKt.isBlank(time)) {
                            time = MainActivityKt.TicketEditorScreen$lambda$405(mutableState12);
                        }
                        mutableState11.setValue(time);
                        MutableState<String> mutableState13 = this.$fromValue$delegate;
                        String from = onlineRecognitionResultRecognizeTicket$app.getFrom();
                        MutableState<String> mutableState14 = this.$fromValue$delegate;
                        if (StringsKt.isBlank(from)) {
                            from = MainActivityKt.TicketEditorScreen$lambda$408(mutableState14);
                        }
                        mutableState13.setValue(from);
                        MutableState<String> mutableState15 = this.$toValue$delegate;
                        String to = onlineRecognitionResultRecognizeTicket$app.getTo();
                        MutableState<String> mutableState16 = this.$toValue$delegate;
                        if (StringsKt.isBlank(to)) {
                            to = MainActivityKt.TicketEditorScreen$lambda$411(mutableState16);
                        }
                        mutableState15.setValue(to);
                        MutableState<String> mutableState17 = this.$departurePlatformValue$delegate;
                        String departurePlatform = onlineRecognitionResultRecognizeTicket$app.getDeparturePlatform();
                        MutableState<String> mutableState18 = this.$departurePlatformValue$delegate;
                        if (StringsKt.isBlank(departurePlatform)) {
                            departurePlatform = MainActivityKt.TicketEditorScreen$lambda$414(mutableState18);
                        }
                        mutableState17.setValue(departurePlatform);
                        MutableState<String> mutableState19 = this.$arrivalPlatformValue$delegate;
                        String arrivalPlatform = onlineRecognitionResultRecognizeTicket$app.getArrivalPlatform();
                        MutableState<String> mutableState20 = this.$arrivalPlatformValue$delegate;
                        if (StringsKt.isBlank(arrivalPlatform)) {
                            arrivalPlatform = MainActivityKt.TicketEditorScreen$lambda$417(mutableState20);
                        }
                        mutableState19.setValue(arrivalPlatform);
                        MutableState<String> mutableState21 = this.$departureGateValue$delegate;
                        String departureGate = onlineRecognitionResultRecognizeTicket$app.getDepartureGate();
                        MutableState<String> mutableState22 = this.$departureGateValue$delegate;
                        if (StringsKt.isBlank(departureGate)) {
                            departureGate = MainActivityKt.TicketEditorScreen$lambda$420(mutableState22);
                        }
                        mutableState21.setValue(departureGate);
                        MutableState<String> mutableState23 = this.$arrivalGateValue$delegate;
                        String arrivalGate = onlineRecognitionResultRecognizeTicket$app.getArrivalGate();
                        MutableState<String> mutableState24 = this.$arrivalGateValue$delegate;
                        if (StringsKt.isBlank(arrivalGate)) {
                            arrivalGate = MainActivityKt.TicketEditorScreen$lambda$423(mutableState24);
                        }
                        mutableState23.setValue(arrivalGate);
                        MutableState<String> mutableState25 = this.$venueValue$delegate;
                        String venue = onlineRecognitionResultRecognizeTicket$app.getVenue();
                        MutableState<String> mutableState26 = this.$venueValue$delegate;
                        if (StringsKt.isBlank(venue)) {
                            venue = MainActivityKt.TicketEditorScreen$lambda$432(mutableState26);
                        }
                        mutableState25.setValue(venue);
                        MutableState<String> mutableState27 = this.$hallValue$delegate;
                        String hall = onlineRecognitionResultRecognizeTicket$app.getHall();
                        MutableState<String> mutableState28 = this.$hallValue$delegate;
                        if (StringsKt.isBlank(hall)) {
                            hall = MainActivityKt.TicketEditorScreen$lambda$426(mutableState28);
                        }
                        mutableState27.setValue(hall);
                        MutableState<String> mutableState29 = this.$seatValue$delegate;
                        String seat = onlineRecognitionResultRecognizeTicket$app.getSeat();
                        MutableState<String> mutableState30 = this.$seatValue$delegate;
                        if (StringsKt.isBlank(seat)) {
                            seat = MainActivityKt.TicketEditorScreen$lambda$429(mutableState30);
                        }
                        mutableState29.setValue(seat);
                        MutableState<String> mutableState31 = this.$areaValue$delegate;
                        String area = onlineRecognitionResultRecognizeTicket$app.getArea();
                        MutableState<String> mutableState32 = this.$areaValue$delegate;
                        if (StringsKt.isBlank(area)) {
                            area = MainActivityKt.TicketEditorScreen$lambda$435(mutableState32);
                        }
                        mutableState31.setValue(area);
                        MutableState<String> mutableState33 = this.$entryValue$delegate;
                        String entry = onlineRecognitionResultRecognizeTicket$app.getEntry();
                        MutableState<String> mutableState34 = this.$entryValue$delegate;
                        if (StringsKt.isBlank(entry)) {
                            entry = MainActivityKt.TicketEditorScreen$lambda$438(mutableState34);
                        }
                        mutableState33.setValue(entry);
                        MutableState<String> mutableState35 = this.$startTimeValue$delegate;
                        String startTime = onlineRecognitionResultRecognizeTicket$app.getStartTime();
                        MutableState<String> mutableState36 = this.$startTimeValue$delegate;
                        if (StringsKt.isBlank(startTime)) {
                            startTime = MainActivityKt.TicketEditorScreen$lambda$442(mutableState36);
                        }
                        mutableState35.setValue(startTime);
                        MutableState<String> mutableState37 = this.$endTimeValue$delegate;
                        String endTime = onlineRecognitionResultRecognizeTicket$app.getEndTime();
                        MutableState<String> mutableState38 = this.$endTimeValue$delegate;
                        if (StringsKt.isBlank(endTime)) {
                            endTime = MainActivityKt.TicketEditorScreen$lambda$445(mutableState38);
                        }
                        mutableState37.setValue(endTime);
                        MutableState<String> mutableState39 = this.$takeoffTimeValue$delegate;
                        String takeoffTime = onlineRecognitionResultRecognizeTicket$app.getTakeoffTime();
                        MutableState<String> mutableState40 = this.$takeoffTimeValue$delegate;
                        if (StringsKt.isBlank(takeoffTime)) {
                            takeoffTime = MainActivityKt.TicketEditorScreen$lambda$448(mutableState40);
                        }
                        mutableState39.setValue(takeoffTime);
                        MutableState<String> mutableState41 = this.$landingTimeValue$delegate;
                        String landingTime = onlineRecognitionResultRecognizeTicket$app.getLandingTime();
                        MutableState<String> mutableState42 = this.$landingTimeValue$delegate;
                        if (StringsKt.isBlank(landingTime)) {
                            landingTime = MainActivityKt.TicketEditorScreen$lambda$451(mutableState42);
                        }
                        mutableState41.setValue(landingTime);
                        MutableState<String> mutableState43 = this.$brandValue$delegate;
                        String brand = onlineRecognitionResultRecognizeTicket$app.getBrand();
                        MutableState<String> mutableState44 = this.$brandValue$delegate;
                        if (StringsKt.isBlank(brand)) {
                            brand = MainActivityKt.TicketEditorScreen$lambda$454(mutableState44);
                        }
                        mutableState43.setValue(brand);
                        if (!StringsKt.isBlank(MainActivityKt.TicketEditorScreen$lambda$385(this.$barcodeValue$delegate))) {
                            if (StringsKt.isBlank(MainActivityKt.TicketEditorScreen$lambda$464(this.$ocrStatus$delegate))) {
                                this.$ocrStatus$delegate.setValue("在线识别完成，已自动填写可识别字段");
                            }
                            if (StringsKt.isBlank(MainActivityKt.TicketEditorScreen$lambda$385(this.$barcodeValue$delegate))) {
                                TicketBarcodeScanner ticketBarcodeScanner = TicketBarcodeScanner.INSTANCE;
                                Context context = this.$editorContext;
                                Uri uri = this.$uri;
                                MainActivityKt$TicketEditorScreen$imagePicker$1$1$2 mainActivityKt$TicketEditorScreen$imagePicker$1$1$2 = this;
                                str = null;
                                this.L$0 = null;
                                this.label = 3;
                                objScanFirst2 = ticketBarcodeScanner.scanFirst(context, uri, mainActivityKt$TicketEditorScreen$imagePicker$1$1$2);
                            }
                        } else {
                            this.L$0 = SpillingKt.nullOutSpilledVariable(onlineRecognitionResultRecognizeTicket$app);
                            this.label = 1;
                            objScanFirst = TicketBarcodeScanner.INSTANCE.scanFirst(this.$editorContext, this.$uri, this);
                            if (objScanFirst != coroutine_suspended) {
                                str3 = (String) objScanFirst;
                                if (str3 != null) {
                                    MutableState<String> mutableState45 = this.$barcodeValue$delegate;
                                    MutableState<String> mutableState46 = this.$ocrStatus$delegate;
                                    mutableState45.setValue(str3);
                                    mutableState46.setValue("已读取二维码 / 条形码");
                                }
                                if (StringsKt.isBlank(MainActivityKt.TicketEditorScreen$lambda$464(this.$ocrStatus$delegate))) {
                                    this.$ocrStatus$delegate.setValue("在线识别完成，已自动填写可识别字段");
                                }
                                if (StringsKt.isBlank(MainActivityKt.TicketEditorScreen$lambda$385(this.$barcodeValue$delegate))) {
                                    TicketBarcodeScanner ticketBarcodeScanner2 = TicketBarcodeScanner.INSTANCE;
                                    Context context2 = this.$editorContext;
                                    Uri uri2 = this.$uri;
                                    MainActivityKt$TicketEditorScreen$imagePicker$1$1$2 mainActivityKt$TicketEditorScreen$imagePicker$1$1$3 = this;
                                    str = null;
                                    this.L$0 = null;
                                    this.label = 3;
                                    objScanFirst2 = ticketBarcodeScanner2.scanFirst(context2, uri2, mainActivityKt$TicketEditorScreen$imagePicker$1$1$3);
                                }
                            }
                        }
                    } else if (this.$ocrEnabled) {
                        this.label = 2;
                        objRecognizeText = OcrManager.INSTANCE.recognizeText(this.$editorContext, this.$uri, this.$ocrAccuracy, this);
                        if (objRecognizeText != coroutine_suspended) {
                            ocrTicketDraft = TicketOcrParser.INSTANCE.parse((String) objRecognizeText);
                            MainActivityKt.TicketEditorScreen$applyOcrDraft(this.$selectedType$delegate, this.$titleValue$delegate, this.$codeValue$delegate, this.$dateValue$delegate, this.$departureDateValue$delegate, this.$arrivalDateValue$delegate, this.$fromValue$delegate, this.$toValue$delegate, this.$venueValue$delegate, this.$brandValue$delegate, this.$hallValue$delegate, this.$seatValue$delegate, this.$areaValue$delegate, this.$entryValue$delegate, this.$timeValue$delegate, this.$startTimeValue$delegate, this.$endTimeValue$delegate, this.$takeoffTimeValue$delegate, this.$landingTimeValue$delegate, ocrTicketDraft);
                            MutableState<String> mutableState47 = this.$ocrStatus$delegate;
                            if (ocrTicketDraft.getType() == OcrTicketType.Unknown) {
                                str4 = "已识别文字，但未能确定票据类型";
                            } else {
                                str4 = "离线识别完成，已自动填写可识别字段";
                            }
                            mutableState47.setValue(str4);
                            if (StringsKt.isBlank(MainActivityKt.TicketEditorScreen$lambda$385(this.$barcodeValue$delegate))) {
                                TicketBarcodeScanner ticketBarcodeScanner3 = TicketBarcodeScanner.INSTANCE;
                                Context context3 = this.$editorContext;
                                Uri uri3 = this.$uri;
                                MainActivityKt$TicketEditorScreen$imagePicker$1$1$2 mainActivityKt$TicketEditorScreen$imagePicker$1$1$4 = this;
                                str = null;
                                this.L$0 = null;
                                this.label = 3;
                                objScanFirst2 = ticketBarcodeScanner3.scanFirst(context3, uri3, mainActivityKt$TicketEditorScreen$imagePicker$1$1$4);
                            }
                        }
                    } else {
                        this.$ocrStatus$delegate.setValue("离线识别未启用");
                        Unit unit = Unit.INSTANCE;
                        MainActivityKt.TicketEditorScreen$lambda$462(this.$ocrRecognizing$delegate, false);
                        return unit;
                    }
                    return coroutine_suspended;
                }
                if (i == 1) {
                    ResultKt.throwOnFailure(obj);
                    objScanFirst = obj;
                    str3 = (String) objScanFirst;
                    if (str3 != null) {
                        MutableState<String> mutableState48 = this.$barcodeValue$delegate;
                        MutableState<String> mutableState49 = this.$ocrStatus$delegate;
                        mutableState48.setValue(str3);
                        mutableState49.setValue("已读取二维码 / 条形码");
                    }
                    if (StringsKt.isBlank(MainActivityKt.TicketEditorScreen$lambda$464(this.$ocrStatus$delegate))) {
                        this.$ocrStatus$delegate.setValue("在线识别完成，已自动填写可识别字段");
                    }
                    if (StringsKt.isBlank(MainActivityKt.TicketEditorScreen$lambda$385(this.$barcodeValue$delegate))) {
                        TicketBarcodeScanner ticketBarcodeScanner4 = TicketBarcodeScanner.INSTANCE;
                        Context context4 = this.$editorContext;
                        Uri uri4 = this.$uri;
                        MainActivityKt$TicketEditorScreen$imagePicker$1$1$2 mainActivityKt$TicketEditorScreen$imagePicker$1$1$5 = this;
                        str = null;
                        this.L$0 = null;
                        this.label = 3;
                        objScanFirst2 = ticketBarcodeScanner4.scanFirst(context4, uri4, mainActivityKt$TicketEditorScreen$imagePicker$1$1$5);
                    }
                } else if (i == 2) {
                    ResultKt.throwOnFailure(obj);
                    objRecognizeText = obj;
                    ocrTicketDraft = TicketOcrParser.INSTANCE.parse((String) objRecognizeText);
                    MainActivityKt.TicketEditorScreen$applyOcrDraft(this.$selectedType$delegate, this.$titleValue$delegate, this.$codeValue$delegate, this.$dateValue$delegate, this.$departureDateValue$delegate, this.$arrivalDateValue$delegate, this.$fromValue$delegate, this.$toValue$delegate, this.$venueValue$delegate, this.$brandValue$delegate, this.$hallValue$delegate, this.$seatValue$delegate, this.$areaValue$delegate, this.$entryValue$delegate, this.$timeValue$delegate, this.$startTimeValue$delegate, this.$endTimeValue$delegate, this.$takeoffTimeValue$delegate, this.$landingTimeValue$delegate, ocrTicketDraft);
                    MutableState<String> mutableState410 = this.$ocrStatus$delegate;
                    if (ocrTicketDraft.getType() == OcrTicketType.Unknown) {
                        str4 = "已识别文字，但未能确定票据类型";
                    } else {
                        str4 = "离线识别完成，已自动填写可识别字段";
                    }
                    mutableState410.setValue(str4);
                    if (StringsKt.isBlank(MainActivityKt.TicketEditorScreen$lambda$385(this.$barcodeValue$delegate))) {
                        TicketBarcodeScanner ticketBarcodeScanner5 = TicketBarcodeScanner.INSTANCE;
                        Context context5 = this.$editorContext;
                        Uri uri5 = this.$uri;
                        MainActivityKt$TicketEditorScreen$imagePicker$1$1$2 mainActivityKt$TicketEditorScreen$imagePicker$1$1$6 = this;
                        str = null;
                        try {
                            this.L$0 = null;
                            this.label = 3;
                            objScanFirst2 = ticketBarcodeScanner5.scanFirst(context5, uri5, mainActivityKt$TicketEditorScreen$imagePicker$1$1$6);
                        } catch (Exception e) {
                            e = e;
                            MutableState<String> mutableState50 = this.$ocrStatus$delegate;
                            String message = e.getMessage();
                            if (message == null) {
                                str2 = "识别失败，请重新选择图片或 PDF。";
                            } else {
                                str2 = !StringsKt.isBlank(message) ? message : str;
                                if (str2 == null) {
                                    str2 = "识别失败，请重新选择图片或 PDF。";
                                }
                            }
                            mutableState50.setValue(str2);
                        }
                    }
                } else {
                    if (i != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    objScanFirst2 = obj;
                    str = null;
                }
                String str5 = (String) objScanFirst2;
                if (str5 != null) {
                    MutableState<String> mutableState51 = this.$barcodeValue$delegate;
                    MutableState<String> mutableState52 = this.$ocrStatus$delegate;
                    mutableState51.setValue(str5);
                    mutableState52.setValue("已读取二维码 / 条形码");
                }
            } catch (Exception e2) {
                e = e2;
                str = null;
            }
            MainActivityKt.TicketEditorScreen$lambda$462(this.$ocrRecognizing$delegate, false);
            return Unit.INSTANCE;
        } catch (Throwable th) {
            MainActivityKt.TicketEditorScreen$lambda$462(this.$ocrRecognizing$delegate, false);
            throw th;
        }
    }
}
