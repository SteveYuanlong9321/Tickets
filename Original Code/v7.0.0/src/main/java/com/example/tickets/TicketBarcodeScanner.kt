package com.example.tickets;

import android.content.Context;
import android.net.Uri;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.mlkit.vision.barcode.BarcodeScanner;
import com.google.mlkit.vision.barcode.BarcodeScannerOptions;
import com.google.mlkit.vision.barcode.BarcodeScanning;
import com.google.mlkit.vision.barcode.common.Barcode;
import com.google.mlkit.vision.common.InputImage;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;

/* JADX INFO: compiled from: TicketBarcodeScanner.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0086@¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/example/tickets/TicketBarcodeScanner;", "", "<init>", "()V", "scanFirst", "", "context", "Landroid/content/Context;", "uri", "Landroid/net/Uri;", "(Landroid/content/Context;Landroid/net/Uri;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class TicketBarcodeScanner {
    public static final int $stable = 0;
    public static final TicketBarcodeScanner INSTANCE = new TicketBarcodeScanner();

    private TicketBarcodeScanner() {
    }

    public final Object scanFirst(Context context, Uri uri, Continuation<? super String> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        final CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
        try {
            InputImage inputImageFromFilePath = InputImage.fromFilePath(context, uri);
            Intrinsics.checkNotNullExpressionValue(inputImageFromFilePath, "fromFilePath(...)");
            BarcodeScannerOptions barcodeScannerOptionsBuild = new BarcodeScannerOptions.Builder().setBarcodeFormats(256, 1, 2, 4, 8, 16, 32, 64, 128, 512, 1024, 2048, 4096).build();
            Intrinsics.checkNotNullExpressionValue(barcodeScannerOptionsBuild, "build(...)");
            final BarcodeScanner client = BarcodeScanning.getClient(barcodeScannerOptionsBuild);
            Intrinsics.checkNotNullExpressionValue(client, "getClient(...)");
            Task<List<Barcode>> taskProcess = client.process(inputImageFromFilePath);
            final Function1<List<Barcode>, Unit> function1 = new Function1<List<Barcode>, Unit>() { // from class: com.example.tickets.TicketBarcodeScanner$scanFirst$2$1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(List<Barcode> list) {
                    invoke2(list);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(List<Barcode> list) {
                    String str;
                    String string;
                    Intrinsics.checkNotNull(list);
                    Iterator<T> it = list.iterator();
                    do {
                        str = null;
                        if (!it.hasNext()) {
                            break;
                        }
                        String rawValue = ((Barcode) it.next()).getRawValue();
                        if (rawValue != null && (string = StringsKt.trim((CharSequence) rawValue).toString()) != null && !StringsKt.isBlank(string)) {
                            str = string;
                        }
                    } while (str == null);
                    CancellableContinuation<String> cancellableContinuation = cancellableContinuationImpl2;
                    Result.Companion companion = Result.INSTANCE;
                    cancellableContinuation.resumeWith(Result.m9536constructorimpl(str));
                }
            };
            Intrinsics.checkNotNull(taskProcess.addOnSuccessListener(new OnSuccessListener(function1) { // from class: com.example.tickets.TicketBarcodeScanner$sam$com_google_android_gms_tasks_OnSuccessListener$0
                private final /* synthetic */ Function1 function;

                {
                    Intrinsics.checkNotNullParameter(function1, "function");
                    this.function = function1;
                }

                @Override // com.google.android.gms.tasks.OnSuccessListener
                public final /* synthetic */ void onSuccess(Object obj) {
                    this.function.invoke(obj);
                }
            }).addOnFailureListener(new OnFailureListener() { // from class: com.example.tickets.TicketBarcodeScanner$scanFirst$2$2
                @Override // com.google.android.gms.tasks.OnFailureListener
                public final void onFailure(Exception it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    CancellableContinuation<String> cancellableContinuation = cancellableContinuationImpl2;
                    Result.Companion companion = Result.INSTANCE;
                    cancellableContinuation.resumeWith(Result.m9536constructorimpl(null));
                }
            }).addOnCompleteListener(new OnCompleteListener() { // from class: com.example.tickets.TicketBarcodeScanner$scanFirst$2$3
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task<List<Barcode>> it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    client.close();
                }
            }));
        } catch (Exception unused) {
            Result.Companion companion = Result.INSTANCE;
            cancellableContinuationImpl2.resumeWith(Result.m9536constructorimpl(null));
        }
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }
}
