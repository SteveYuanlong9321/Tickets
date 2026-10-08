package com.example.tickets;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.net.Uri;
import androidx.compose.runtime.GapComposerKt;
import androidx.core.text.util.LocalePreferences;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.Constants;
import com.google.mlkit.vision.common.InputImage;
import com.google.mlkit.vision.text.Text;
import com.google.mlkit.vision.text.TextRecognition;
import com.google.mlkit.vision.text.TextRecognizer;
import com.google.mlkit.vision.text.chinese.ChineseTextRecognizerOptions;
import com.google.mlkit.vision.text.latin.TextRecognizerOptions;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;

/* JADX INFO: compiled from: OcrManager.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\bH\u0086@¢\u0006\u0002\u0010\u000eJ(\u0010\u000f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\r\u001a\u00020\bH\u0082@¢\u0006\u0002\u0010\u0012J&\u0010\u0013\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\bH\u0082@¢\u0006\u0002\u0010\u000eJ&\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\bH\u0082@¢\u0006\u0002\u0010\u0017J\u001a\u0010\u0018\u001a\u0004\u0018\u00010\u00112\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0018\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u0010\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u0011H\u0002J\u001e\u0010\u001f\u001a\u00020\b2\u0006\u0010 \u001a\u00020\u00052\u0006\u0010!\u001a\u00020\"H\u0082@¢\u0006\u0002\u0010#J\u001e\u0010$\u001a\u00020\b2\u0006\u0010 \u001a\u00020\u00052\u0006\u0010!\u001a\u00020\"H\u0082@¢\u0006\u0002\u0010#J!\u0010%\u001a\u00020\b2\u0012\u0010&\u001a\n\u0012\u0006\b\u0001\u0012\u00020\b0'\"\u00020\bH\u0002¢\u0006\u0002\u0010(R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/example/tickets/OcrManager;", "", "<init>", "()V", "chineseRecognizer", "Lcom/google/mlkit/vision/text/TextRecognizer;", "latinRecognizer", "recognizeText", "", "context", "Landroid/content/Context;", "uri", "Landroid/net/Uri;", "accuracy", "(Landroid/content/Context;Landroid/net/Uri;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "recognizeBitmap", "sourceBitmap", "Landroid/graphics/Bitmap;", "(Landroid/content/Context;Landroid/graphics/Bitmap;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "recognizePdf", "recognizeBitmapInternal", "normalized", "enhanced", "(Landroid/graphics/Bitmap;Landroid/graphics/Bitmap;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadBitmap", "scaleDown", "bitmap", "maxSide", "", "enhanceForOcr", Constants.ScionAnalytics.PARAM_SOURCE, "safeRecognize", "recognizer", "image", "Lcom/google/mlkit/vision/common/InputImage;", "(Lcom/google/mlkit/vision/text/TextRecognizer;Lcom/google/mlkit/vision/common/InputImage;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "recognizeWith", "mergeResults", "values", "", "([Ljava/lang/String;)Ljava/lang/String;", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class OcrManager {
    public static final int $stable;
    public static final OcrManager INSTANCE = new OcrManager();
    private static final TextRecognizer chineseRecognizer;
    private static final TextRecognizer latinRecognizer;

    /* JADX INFO: renamed from: com.example.tickets.OcrManager$recognizeBitmap$1, reason: invalid class name */
    /* JADX INFO: compiled from: OcrManager.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.tickets.OcrManager", f = "OcrManager.kt", i = {0, 0, 0, 0, 0, 0}, l = {74}, m = "recognizeBitmap", n = {"context", "sourceBitmap", "accuracy", Constants.ScionAnalytics.PARAM_SOURCE, "normalized", "enhanced"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5"})
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return OcrManager.this.recognizeBitmap(null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.example.tickets.OcrManager$recognizeBitmapInternal$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: OcrManager.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.tickets.OcrManager", f = "OcrManager.kt", i = {0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 4, 4, 4, 5, 5, 5, 5}, l = {154, 158, 162, 166, 177, 181}, m = "recognizeBitmapInternal", n = {"normalized", "enhanced", "accuracy", "normalized", "enhanced", "accuracy", "chineseOriginal", "normalized", "enhanced", "accuracy", "chineseOriginal", "latinOriginal", "normalized", "enhanced", "accuracy", "chineseOriginal", "latinOriginal", "chineseEnhanced", "normalized", "enhanced", "accuracy", "normalized", "enhanced", "accuracy", LocalePreferences.CalendarType.CHINESE}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3"})
    static final class C03431 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        /* synthetic */ Object result;

        C03431(Continuation<? super C03431> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return OcrManager.this.recognizeBitmapInternal(null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.example.tickets.OcrManager$recognizePdf$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: OcrManager.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.tickets.OcrManager", f = "OcrManager.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, l = {GapComposerKt.nodeKey}, m = "recognizePdf", n = {"context", "uri", "accuracy", "descriptor", "pfd", "renderer", "pdf", "results", "page", "bitmap", "$i$a$-use-OcrManager$recognizePdf$2", "$i$a$-use-OcrManager$recognizePdf$2$1", "pageCount", "index", "width", "height"}, s = {"L$0", "L$1", "L$2", "L$3", "L$5", "L$6", "L$8", "L$9", "L$10", "L$11", "I$0", "I$1", "I$2", "I$3", "I$4", "I$5"})
    static final class C03441 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        int I$4;
        int I$5;
        Object L$0;
        Object L$1;
        Object L$10;
        Object L$11;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        int label;
        /* synthetic */ Object result;

        C03441(Continuation<? super C03441> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return OcrManager.this.recognizePdf(null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.example.tickets.OcrManager$safeRecognize$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: OcrManager.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.tickets.OcrManager", f = "OcrManager.kt", i = {0, 0}, l = {241}, m = "safeRecognize", n = {"recognizer", "image"}, s = {"L$0", "L$1"})
    static final class C03451 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C03451(Continuation<? super C03451> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return OcrManager.this.safeRecognize(null, null, this);
        }
    }

    private OcrManager() {
    }

    static {
        TextRecognizer client = TextRecognition.getClient(new ChineseTextRecognizerOptions.Builder().build());
        Intrinsics.checkNotNullExpressionValue(client, "getClient(...)");
        chineseRecognizer = client;
        TextRecognizer client2 = TextRecognition.getClient(TextRecognizerOptions.DEFAULT_OPTIONS);
        Intrinsics.checkNotNullExpressionValue(client2, "getClient(...)");
        latinRecognizer = client2;
        $stable = 8;
    }

    public final Object recognizeText(Context context, Uri uri, String str, Continuation<? super String> continuation) {
        String type = context.getContentResolver().getType(uri);
        if (type == null || !StringsKt.equals(type, "application/pdf", true)) {
            String string = uri.toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            String lowerCase = string.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            if (!StringsKt.contains$default((CharSequence) lowerCase, (CharSequence) ".pdf", false, 2, (Object) null)) {
                return recognizeBitmap(context, loadBitmap(context, uri), str, continuation);
            }
        }
        return recognizePdf(context, uri, str, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:40:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:43:0x00af  */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object recognizeBitmap(Context context, Bitmap bitmap, String str, Continuation<? super String> continuation) throws Throwable {
        AnonymousClass1 anonymousClass1;
        Bitmap bitmap2;
        Bitmap bitmap3;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuation);
        }
        Object obj = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            if (bitmap == null) {
                throw new IllegalArgumentException("无法读取这张图片，请重新选择图片或 PDF。");
            }
            Bitmap bitmapScaleDown = scaleDown(bitmap, 2048);
            if (bitmapScaleDown != bitmap) {
                bitmap.recycle();
            }
            Bitmap bitmapEnhanceForOcr = enhanceForOcr(bitmapScaleDown);
            try {
                anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(context);
                anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(bitmap);
                anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(str);
                anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(bitmap);
                anonymousClass1.L$4 = bitmapScaleDown;
                anonymousClass1.L$5 = bitmapEnhanceForOcr;
                anonymousClass1.label = 1;
                Object objRecognizeBitmapInternal = recognizeBitmapInternal(bitmapScaleDown, bitmapEnhanceForOcr, str, anonymousClass1);
                if (objRecognizeBitmapInternal == coroutine_suspended) {
                    return coroutine_suspended;
                }
                bitmap2 = bitmapScaleDown;
                obj = objRecognizeBitmapInternal;
                bitmap3 = bitmapEnhanceForOcr;
            } catch (Throwable th) {
                th = th;
                bitmap2 = bitmapScaleDown;
                bitmap3 = bitmapEnhanceForOcr;
                if (!bitmap2.isRecycled()) {
                    bitmap2.recycle();
                }
                if (!bitmap3.isRecycled()) {
                    bitmap3.recycle();
                }
                throw th;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            bitmap3 = (Bitmap) anonymousClass1.L$5;
            bitmap2 = (Bitmap) anonymousClass1.L$4;
            try {
                ResultKt.throwOnFailure(obj);
            } catch (Throwable th2) {
                th = th2;
                if (!bitmap2.isRecycled()) {
                    bitmap2.recycle();
                }
                if (!bitmap3.isRecycled()) {
                    bitmap3.recycle();
                }
                throw th;
            }
        }
        String str2 = (String) obj;
        if (!bitmap2.isRecycled()) {
            bitmap2.recycle();
        }
        if (!bitmap3.isRecycled()) {
            bitmap3.recycle();
        }
        return str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:29:0x00e4  */
    /* JADX WARN: Code duplicated, block: B:34:0x0177 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:35:0x0178  */
    /* JADX WARN: Code duplicated, block: B:38:0x019a A[Catch: all -> 0x01f1, TRY_LEAVE, TryCatch #0 {all -> 0x01f1, blocks: (B:36:0x018c, B:38:0x019a), top: B:85:0x018c }] */
    /* JADX WARN: Code duplicated, block: B:40:0x01c4  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:35:0x0178 -> B:14:0x0083). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object recognizePdf(android.content.Context r22, android.net.Uri r23, java.lang.String r24, kotlin.coroutines.Continuation<? super java.lang.String> r25) {
        /*
            Method dump skipped, instruction units count: 605
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.tickets.OcrManager.recognizePdf(android.content.Context, android.net.Uri, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:26:0x0108  */
    /* JADX WARN: Code duplicated, block: B:30:0x0134  */
    /* JADX WARN: Code duplicated, block: B:34:0x0164  */
    /* JADX WARN: Code duplicated, block: B:43:0x01bd  */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object recognizeBitmapInternal(Bitmap bitmap, Bitmap bitmap2, String str, Continuation<? super String> continuation) {
        C03431 c03431;
        String str2;
        Object objSafeRecognize;
        Bitmap bitmap3;
        String str3;
        Bitmap bitmap4;
        String str4;
        Object objSafeRecognize2;
        String str5;
        String str6;
        Object objSafeRecognize3;
        String str7;
        String str8;
        String str9;
        Object objSafeRecognize4;
        String str10;
        if (continuation instanceof C03431) {
            c03431 = (C03431) continuation;
            if ((c03431.label & Integer.MIN_VALUE) != 0) {
                c03431.label -= Integer.MIN_VALUE;
            } else {
                c03431 = new C03431(continuation);
            }
        } else {
            c03431 = new C03431(continuation);
        }
        Object objSafeRecognize5 = c03431.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c03431.label) {
            case 0:
                ResultKt.throwOnFailure(objSafeRecognize5);
                if (Intrinsics.areEqual(str, "精准")) {
                    TextRecognizer textRecognizer = chineseRecognizer;
                    InputImage inputImageFromBitmap = InputImage.fromBitmap(bitmap, 0);
                    Intrinsics.checkNotNullExpressionValue(inputImageFromBitmap, "fromBitmap(...)");
                    c03431.L$0 = bitmap;
                    c03431.L$1 = bitmap2;
                    c03431.L$2 = SpillingKt.nullOutSpilledVariable(str);
                    c03431.label = 1;
                    objSafeRecognize5 = safeRecognize(textRecognizer, inputImageFromBitmap, c03431);
                    if (objSafeRecognize5 != coroutine_suspended) {
                        str2 = (String) objSafeRecognize5;
                        TextRecognizer textRecognizer2 = latinRecognizer;
                        InputImage inputImageFromBitmap2 = InputImage.fromBitmap(bitmap, 0);
                        Intrinsics.checkNotNullExpressionValue(inputImageFromBitmap2, "fromBitmap(...)");
                        c03431.L$0 = SpillingKt.nullOutSpilledVariable(bitmap);
                        c03431.L$1 = bitmap2;
                        c03431.L$2 = SpillingKt.nullOutSpilledVariable(str);
                        c03431.L$3 = str2;
                        c03431.label = 2;
                        objSafeRecognize = safeRecognize(textRecognizer2, inputImageFromBitmap2, c03431);
                        if (objSafeRecognize != coroutine_suspended) {
                            bitmap3 = bitmap;
                            str3 = str2;
                            objSafeRecognize5 = objSafeRecognize;
                            bitmap4 = bitmap2;
                            str4 = (String) objSafeRecognize5;
                            TextRecognizer textRecognizer3 = chineseRecognizer;
                            InputImage inputImageFromBitmap3 = InputImage.fromBitmap(bitmap4, 0);
                            Intrinsics.checkNotNullExpressionValue(inputImageFromBitmap3, "fromBitmap(...)");
                            c03431.L$0 = SpillingKt.nullOutSpilledVariable(bitmap3);
                            c03431.L$1 = bitmap4;
                            c03431.L$2 = SpillingKt.nullOutSpilledVariable(str);
                            c03431.L$3 = str3;
                            c03431.L$4 = str4;
                            c03431.label = 3;
                            objSafeRecognize2 = safeRecognize(textRecognizer3, inputImageFromBitmap3, c03431);
                            if (objSafeRecognize2 != coroutine_suspended) {
                                objSafeRecognize5 = objSafeRecognize2;
                                str5 = str4;
                                str6 = (String) objSafeRecognize5;
                                TextRecognizer textRecognizer4 = latinRecognizer;
                                InputImage inputImageFromBitmap4 = InputImage.fromBitmap(bitmap4, 0);
                                Intrinsics.checkNotNullExpressionValue(inputImageFromBitmap4, "fromBitmap(...)");
                                c03431.L$0 = SpillingKt.nullOutSpilledVariable(bitmap3);
                                c03431.L$1 = SpillingKt.nullOutSpilledVariable(bitmap4);
                                c03431.L$2 = SpillingKt.nullOutSpilledVariable(str);
                                c03431.L$3 = str3;
                                c03431.L$4 = str5;
                                c03431.L$5 = str6;
                                c03431.label = 4;
                                objSafeRecognize3 = safeRecognize(textRecognizer4, inputImageFromBitmap4, c03431);
                                if (objSafeRecognize3 != coroutine_suspended) {
                                    str7 = str3;
                                    str8 = str6;
                                    objSafeRecognize5 = objSafeRecognize3;
                                    return mergeResults(str7, str5, str8, (String) objSafeRecognize5);
                                }
                            }
                        }
                    }
                } else {
                    TextRecognizer textRecognizer5 = chineseRecognizer;
                    InputImage inputImageFromBitmap5 = InputImage.fromBitmap(bitmap2, 0);
                    Intrinsics.checkNotNullExpressionValue(inputImageFromBitmap5, "fromBitmap(...)");
                    c03431.L$0 = SpillingKt.nullOutSpilledVariable(bitmap);
                    c03431.L$1 = bitmap2;
                    c03431.L$2 = SpillingKt.nullOutSpilledVariable(str);
                    c03431.label = 5;
                    objSafeRecognize5 = safeRecognize(textRecognizer5, inputImageFromBitmap5, c03431);
                    if (objSafeRecognize5 != coroutine_suspended) {
                        str9 = (String) objSafeRecognize5;
                        TextRecognizer textRecognizer6 = latinRecognizer;
                        InputImage inputImageFromBitmap6 = InputImage.fromBitmap(bitmap2, 0);
                        Intrinsics.checkNotNullExpressionValue(inputImageFromBitmap6, "fromBitmap(...)");
                        c03431.L$0 = SpillingKt.nullOutSpilledVariable(bitmap);
                        c03431.L$1 = SpillingKt.nullOutSpilledVariable(bitmap2);
                        c03431.L$2 = SpillingKt.nullOutSpilledVariable(str);
                        c03431.L$3 = str9;
                        c03431.label = 6;
                        objSafeRecognize4 = safeRecognize(textRecognizer6, inputImageFromBitmap6, c03431);
                        if (objSafeRecognize4 != coroutine_suspended) {
                            objSafeRecognize5 = objSafeRecognize4;
                            str10 = str9;
                            return mergeResults(str10, (String) objSafeRecognize5);
                        }
                    }
                }
                return coroutine_suspended;
            case 1:
                str = (String) c03431.L$2;
                bitmap2 = (Bitmap) c03431.L$1;
                bitmap = (Bitmap) c03431.L$0;
                ResultKt.throwOnFailure(objSafeRecognize5);
                str2 = (String) objSafeRecognize5;
                TextRecognizer textRecognizer7 = latinRecognizer;
                InputImage inputImageFromBitmap7 = InputImage.fromBitmap(bitmap, 0);
                Intrinsics.checkNotNullExpressionValue(inputImageFromBitmap7, "fromBitmap(...)");
                c03431.L$0 = SpillingKt.nullOutSpilledVariable(bitmap);
                c03431.L$1 = bitmap2;
                c03431.L$2 = SpillingKt.nullOutSpilledVariable(str);
                c03431.L$3 = str2;
                c03431.label = 2;
                objSafeRecognize = safeRecognize(textRecognizer7, inputImageFromBitmap7, c03431);
                if (objSafeRecognize != coroutine_suspended) {
                    bitmap3 = bitmap;
                    str3 = str2;
                    objSafeRecognize5 = objSafeRecognize;
                    bitmap4 = bitmap2;
                    str4 = (String) objSafeRecognize5;
                    TextRecognizer textRecognizer8 = chineseRecognizer;
                    InputImage inputImageFromBitmap8 = InputImage.fromBitmap(bitmap4, 0);
                    Intrinsics.checkNotNullExpressionValue(inputImageFromBitmap8, "fromBitmap(...)");
                    c03431.L$0 = SpillingKt.nullOutSpilledVariable(bitmap3);
                    c03431.L$1 = bitmap4;
                    c03431.L$2 = SpillingKt.nullOutSpilledVariable(str);
                    c03431.L$3 = str3;
                    c03431.L$4 = str4;
                    c03431.label = 3;
                    objSafeRecognize2 = safeRecognize(textRecognizer8, inputImageFromBitmap8, c03431);
                    if (objSafeRecognize2 != coroutine_suspended) {
                        objSafeRecognize5 = objSafeRecognize2;
                        str5 = str4;
                        str6 = (String) objSafeRecognize5;
                        TextRecognizer textRecognizer9 = latinRecognizer;
                        InputImage inputImageFromBitmap9 = InputImage.fromBitmap(bitmap4, 0);
                        Intrinsics.checkNotNullExpressionValue(inputImageFromBitmap9, "fromBitmap(...)");
                        c03431.L$0 = SpillingKt.nullOutSpilledVariable(bitmap3);
                        c03431.L$1 = SpillingKt.nullOutSpilledVariable(bitmap4);
                        c03431.L$2 = SpillingKt.nullOutSpilledVariable(str);
                        c03431.L$3 = str3;
                        c03431.L$4 = str5;
                        c03431.L$5 = str6;
                        c03431.label = 4;
                        objSafeRecognize3 = safeRecognize(textRecognizer9, inputImageFromBitmap9, c03431);
                        if (objSafeRecognize3 != coroutine_suspended) {
                            str7 = str3;
                            str8 = str6;
                            objSafeRecognize5 = objSafeRecognize3;
                            return mergeResults(str7, str5, str8, (String) objSafeRecognize5);
                        }
                    }
                }
                return coroutine_suspended;
            case 2:
                str3 = (String) c03431.L$3;
                String str11 = (String) c03431.L$2;
                Bitmap bitmap5 = (Bitmap) c03431.L$1;
                Bitmap bitmap6 = (Bitmap) c03431.L$0;
                ResultKt.throwOnFailure(objSafeRecognize5);
                bitmap3 = bitmap6;
                bitmap4 = bitmap5;
                str = str11;
                str4 = (String) objSafeRecognize5;
                TextRecognizer textRecognizer10 = chineseRecognizer;
                InputImage inputImageFromBitmap10 = InputImage.fromBitmap(bitmap4, 0);
                Intrinsics.checkNotNullExpressionValue(inputImageFromBitmap10, "fromBitmap(...)");
                c03431.L$0 = SpillingKt.nullOutSpilledVariable(bitmap3);
                c03431.L$1 = bitmap4;
                c03431.L$2 = SpillingKt.nullOutSpilledVariable(str);
                c03431.L$3 = str3;
                c03431.L$4 = str4;
                c03431.label = 3;
                objSafeRecognize2 = safeRecognize(textRecognizer10, inputImageFromBitmap10, c03431);
                if (objSafeRecognize2 != coroutine_suspended) {
                    objSafeRecognize5 = objSafeRecognize2;
                    str5 = str4;
                    str6 = (String) objSafeRecognize5;
                    TextRecognizer textRecognizer11 = latinRecognizer;
                    InputImage inputImageFromBitmap11 = InputImage.fromBitmap(bitmap4, 0);
                    Intrinsics.checkNotNullExpressionValue(inputImageFromBitmap11, "fromBitmap(...)");
                    c03431.L$0 = SpillingKt.nullOutSpilledVariable(bitmap3);
                    c03431.L$1 = SpillingKt.nullOutSpilledVariable(bitmap4);
                    c03431.L$2 = SpillingKt.nullOutSpilledVariable(str);
                    c03431.L$3 = str3;
                    c03431.L$4 = str5;
                    c03431.L$5 = str6;
                    c03431.label = 4;
                    objSafeRecognize3 = safeRecognize(textRecognizer11, inputImageFromBitmap11, c03431);
                    if (objSafeRecognize3 != coroutine_suspended) {
                        str7 = str3;
                        str8 = str6;
                        objSafeRecognize5 = objSafeRecognize3;
                        return mergeResults(str7, str5, str8, (String) objSafeRecognize5);
                    }
                }
                return coroutine_suspended;
            case 3:
                String str12 = (String) c03431.L$4;
                String str13 = (String) c03431.L$3;
                str = (String) c03431.L$2;
                bitmap4 = (Bitmap) c03431.L$1;
                bitmap3 = (Bitmap) c03431.L$0;
                ResultKt.throwOnFailure(objSafeRecognize5);
                str5 = str12;
                str3 = str13;
                str6 = (String) objSafeRecognize5;
                TextRecognizer textRecognizer12 = latinRecognizer;
                InputImage inputImageFromBitmap12 = InputImage.fromBitmap(bitmap4, 0);
                Intrinsics.checkNotNullExpressionValue(inputImageFromBitmap12, "fromBitmap(...)");
                c03431.L$0 = SpillingKt.nullOutSpilledVariable(bitmap3);
                c03431.L$1 = SpillingKt.nullOutSpilledVariable(bitmap4);
                c03431.L$2 = SpillingKt.nullOutSpilledVariable(str);
                c03431.L$3 = str3;
                c03431.L$4 = str5;
                c03431.L$5 = str6;
                c03431.label = 4;
                objSafeRecognize3 = safeRecognize(textRecognizer12, inputImageFromBitmap12, c03431);
                if (objSafeRecognize3 != coroutine_suspended) {
                    str7 = str3;
                    str8 = str6;
                    objSafeRecognize5 = objSafeRecognize3;
                    return mergeResults(str7, str5, str8, (String) objSafeRecognize5);
                }
                return coroutine_suspended;
            case 4:
                str8 = (String) c03431.L$5;
                str5 = (String) c03431.L$4;
                str7 = (String) c03431.L$3;
                ResultKt.throwOnFailure(objSafeRecognize5);
                return mergeResults(str7, str5, str8, (String) objSafeRecognize5);
            case 5:
                str = (String) c03431.L$2;
                bitmap2 = (Bitmap) c03431.L$1;
                bitmap = (Bitmap) c03431.L$0;
                ResultKt.throwOnFailure(objSafeRecognize5);
                str9 = (String) objSafeRecognize5;
                TextRecognizer textRecognizer13 = latinRecognizer;
                InputImage inputImageFromBitmap13 = InputImage.fromBitmap(bitmap2, 0);
                Intrinsics.checkNotNullExpressionValue(inputImageFromBitmap13, "fromBitmap(...)");
                c03431.L$0 = SpillingKt.nullOutSpilledVariable(bitmap);
                c03431.L$1 = SpillingKt.nullOutSpilledVariable(bitmap2);
                c03431.L$2 = SpillingKt.nullOutSpilledVariable(str);
                c03431.L$3 = str9;
                c03431.label = 6;
                objSafeRecognize4 = safeRecognize(textRecognizer13, inputImageFromBitmap13, c03431);
                if (objSafeRecognize4 != coroutine_suspended) {
                    objSafeRecognize5 = objSafeRecognize4;
                    str10 = str9;
                    return mergeResults(str10, (String) objSafeRecognize5);
                }
                return coroutine_suspended;
            case 6:
                str10 = (String) c03431.L$3;
                ResultKt.throwOnFailure(objSafeRecognize5);
                return mergeResults(str10, (String) objSafeRecognize5);
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    private final Bitmap loadBitmap(Context context, Uri uri) throws IOException {
        InputStream inputStreamOpenInputStream = context.getContentResolver().openInputStream(uri);
        if (inputStreamOpenInputStream == null) {
            return null;
        }
        InputStream inputStream = inputStreamOpenInputStream;
        try {
            Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(inputStream);
            CloseableKt.closeFinally(inputStream, null);
            return bitmapDecodeStream;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                CloseableKt.closeFinally(inputStream, th);
                throw th2;
            }
        }
    }

    private final Bitmap scaleDown(Bitmap bitmap, int maxSide) {
        int iMax = Math.max(bitmap.getWidth(), bitmap.getHeight());
        if (iMax <= maxSide) {
            return bitmap;
        }
        float f = maxSide / iMax;
        Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmap, RangesKt.coerceAtLeast((int) (bitmap.getWidth() * f), 1), RangesKt.coerceAtLeast((int) (bitmap.getHeight() * f), 1), true);
        Intrinsics.checkNotNullExpressionValue(bitmapCreateScaledBitmap, "createScaledBitmap(...)");
        return bitmapCreateScaledBitmap;
    }

    private final Bitmap enhanceForOcr(Bitmap source) {
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(source.getWidth(), source.getHeight(), Bitmap.Config.ARGB_8888);
        Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(...)");
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        Paint paint = new Paint(3);
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setSaturation(0.0f);
        colorMatrix.postConcat(new ColorMatrix(new float[]{1.22f, 0.0f, 0.0f, 0.0f, -28.050003f, 0.0f, 1.22f, 0.0f, 0.0f, -28.050003f, 0.0f, 0.0f, 1.22f, 0.0f, -28.050003f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f}));
        paint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
        canvas.drawBitmap(source, 0.0f, 0.0f, paint);
        return bitmapCreateBitmap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object safeRecognize(TextRecognizer textRecognizer, InputImage inputImage, Continuation<? super String> continuation) {
        C03451 c03451;
        if (continuation instanceof C03451) {
            c03451 = (C03451) continuation;
            if ((c03451.label & Integer.MIN_VALUE) != 0) {
                c03451.label -= Integer.MIN_VALUE;
            } else {
                c03451 = new C03451(continuation);
            }
        } else {
            c03451 = new C03451(continuation);
        }
        Object objRecognizeWith = c03451.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c03451.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(objRecognizeWith);
                c03451.L$0 = SpillingKt.nullOutSpilledVariable(textRecognizer);
                c03451.L$1 = SpillingKt.nullOutSpilledVariable(inputImage);
                c03451.label = 1;
                objRecognizeWith = recognizeWith(textRecognizer, inputImage, c03451);
                if (objRecognizeWith == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(objRecognizeWith);
            }
            return (String) objRecognizeWith;
        } catch (Exception unused) {
            return "";
        }
    }

    private final String mergeResults(String... values) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator it = SequencesKt.filter(SequencesKt.map(SequencesKt.flatMap(ArraysKt.asSequence(values), new Function1() { // from class: com.example.tickets.OcrManager$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return OcrManager.mergeResults$lambda$5((String) obj);
            }
        }), new Function1() { // from class: com.example.tickets.OcrManager$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return OcrManager.mergeResults$lambda$6((String) obj);
            }
        }), new Function1() { // from class: com.example.tickets.OcrManager$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(OcrManager.mergeResults$lambda$7((String) obj));
            }
        }).iterator();
        while (it.hasNext()) {
            linkedHashSet.add((String) it.next());
        }
        return CollectionsKt.joinToString$default(linkedHashSet, "\n", null, null, 0, null, null, 62, null);
    }

    static final Sequence mergeResults$lambda$5(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return StringsKt.lineSequence(it);
    }

    static final String mergeResults$lambda$6(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return StringsKt.trim((CharSequence) it).toString();
    }

    static final boolean mergeResults$lambda$7(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return !StringsKt.isBlank(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object recognizeWith(TextRecognizer textRecognizer, InputImage inputImage, Continuation<? super String> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        final CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
        Task<Text> taskProcess = textRecognizer.process(inputImage);
        Intrinsics.checkNotNullExpressionValue(taskProcess, "process(...)");
        final Function1<Text, Unit> function1 = new Function1<Text, Unit>() { // from class: com.example.tickets.OcrManager$recognizeWith$2$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Text text) {
                invoke2(text);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Text text) {
                if (cancellableContinuationImpl2.isActive()) {
                    CancellableContinuation<String> cancellableContinuation = cancellableContinuationImpl2;
                    String text2 = text.getText();
                    Intrinsics.checkNotNullExpressionValue(text2, "getText(...)");
                    String string = StringsKt.trim((CharSequence) text2).toString();
                    Result.Companion companion = Result.INSTANCE;
                    cancellableContinuation.resumeWith(Result.m9536constructorimpl(string));
                }
            }
        };
        taskProcess.addOnSuccessListener(new OnSuccessListener(function1) { // from class: com.example.tickets.OcrManager$sam$com_google_android_gms_tasks_OnSuccessListener$0
            private final /* synthetic */ Function1 function;

            {
                Intrinsics.checkNotNullParameter(function1, "function");
                this.function = function1;
            }

            @Override // com.google.android.gms.tasks.OnSuccessListener
            public final /* synthetic */ void onSuccess(Object obj) {
                this.function.invoke(obj);
            }
        });
        taskProcess.addOnFailureListener(new OnFailureListener() { // from class: com.example.tickets.OcrManager$recognizeWith$2$2
            @Override // com.google.android.gms.tasks.OnFailureListener
            public final void onFailure(Exception error) {
                Intrinsics.checkNotNullParameter(error, "error");
                if (cancellableContinuationImpl2.isActive()) {
                    CancellableContinuation<String> cancellableContinuation = cancellableContinuationImpl2;
                    Result.Companion companion = Result.INSTANCE;
                    cancellableContinuation.resumeWith(Result.m9536constructorimpl(ResultKt.createFailure(error)));
                }
            }
        });
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }
}
