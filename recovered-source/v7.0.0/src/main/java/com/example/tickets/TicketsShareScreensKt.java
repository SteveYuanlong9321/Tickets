package com.example.tickets;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.media.Image;
import android.os.Build;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.os.VibratorManager;
import androidx.activity.ComponentActivity;
import androidx.activity.compose.ActivityResultRegistryKt;
import androidx.activity.compose.ManagedActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.ImageAnalysis;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.Preview;
import androidx.camera.lifecycle.ProcessCameraProvider;
import androidx.camera.view.PreviewView;
import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.InfiniteRepeatableSpec;
import androidx.compose.animation.core.InfiniteTransition;
import androidx.compose.animation.core.InfiniteTransitionKt;
import androidx.compose.animation.core.RepeatMode;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.style.StylePropertiesKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.geometry.CornerRadius;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.AndroidImageBitmap_androidKt;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.compose.ui.viewinterop.AndroidView_androidKt;
import androidx.compose.ui.window.AndroidDialog_androidKt;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import androidx.core.location.LocationRequestCompat;
import androidx.profileinstaller.ProfileVerifier;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import androidx.window.core.layout.WindowSizeClass;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.mlkit.vision.barcode.BarcodeScanner;
import com.google.mlkit.vision.barcode.BarcodeScannerOptions;
import com.google.mlkit.vision.barcode.BarcodeScanning;
import com.google.mlkit.vision.barcode.common.Barcode;
import com.google.mlkit.vision.common.InputImage;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: TicketsShareScreens.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0016\u001a\u0012\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0002\u001a\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0002\u001a\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0002\u001a\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0002\u001a\u0015\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0003¢\u0006\u0002\u0010\u0010\u001ac\u0010\u0011\u001a\u00020\r2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00052\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\r0\u00192\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\r0\u00192\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\r0\u00192\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\r0\u0019H\u0001¢\u0006\u0002\u0010\u001d\u001a\u001b\u0010\u001e\u001a\u00020\r2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H\u0003¢\u0006\u0002\u0010\u001f\u001a\u0010\u0010 \u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0002\u001a\u0015\u0010!\u001a\u00020\r2\u0006\u0010\"\u001a\u00020\u0014H\u0003¢\u0006\u0002\u0010#\u001a>\u0010$\u001a\u00020\r2\u0006\u0010%\u001a\u00020\u00052\u0006\u0010&\u001a\u00020\u00052\u0011\u0010'\u001a\r\u0012\u0004\u0012\u00020\r0\u0019¢\u0006\u0002\b(2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\r0\u0019H\u0003¢\u0006\u0002\u0010*\u001a-\u0010+\u001a\u00020\r2\u0006\u0010,\u001a\u00020\u00052\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\r0\u00192\b\b\u0002\u0010-\u001a\u00020.H\u0003¢\u0006\u0002\u0010/\u001a\r\u00100\u001a\u00020\rH\u0003¢\u0006\u0002\u00101\u001a\r\u00102\u001a\u00020\rH\u0003¢\u0006\u0002\u00101\u001a\r\u00103\u001a\u00020\rH\u0003¢\u0006\u0002\u00101\u001a\r\u00104\u001a\u00020\rH\u0003¢\u0006\u0002\u00101\u001a7\u00105\u001a\u00020\r2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\r0\u00192\f\u00106\u001a\b\u0012\u0004\u0012\u00020\r0\u00192\f\u00107\u001a\b\u0012\u0004\u0012\u00020\r0\u0019H\u0001¢\u0006\u0002\u00108\u001a?\u00109\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u00162\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\r0\u00192\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\r0\u00192\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\r0\u0019H\u0001¢\u0006\u0002\u0010:\u001aM\u0010;\u001a\u00020\r2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\b\b\u0002\u0010<\u001a\u00020\u00162\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\r0\u00192\u0018\u0010=\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u0013\u0012\u0004\u0012\u00020\r0>H\u0001¢\u0006\u0002\u0010?\u001aM\u0010@\u001a\u00020\r2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\b\b\u0002\u0010<\u001a\u00020\u00162\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\r0\u00192\u0018\u0010=\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u0013\u0012\u0004\u0012\u00020\r0>H\u0001¢\u0006\u0002\u0010?\u001a7\u0010A\u001a\u00020\r2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\f\u0010B\u001a\b\u0012\u0004\u0012\u00020\r0\u00192\f\u0010C\u001a\b\u0012\u0004\u0012\u00020\r0\u0019H\u0003¢\u0006\u0002\u0010D\u001a7\u0010E\u001a\u00020\r2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\f\u0010F\u001a\b\u0012\u0004\u0012\u00020\r0\u00192\f\u0010G\u001a\b\u0012\u0004\u0012\u00020\r0\u0019H\u0003¢\u0006\u0002\u0010D\u001a/\u0010H\u001a\u00020\r*\u00020I2\u0006\u0010,\u001a\u00020\u00052\u0006\u0010J\u001a\u00020\u00162\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\r0\u0019H\u0003¢\u0006\u0002\u0010K\u001a7\u0010L\u001a\u00020\r2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\f\u00106\u001a\b\u0012\u0004\u0012\u00020\r0\u00192\f\u0010C\u001a\b\u0012\u0004\u0012\u00020\r0\u0019H\u0003¢\u0006\u0002\u0010D\u001a7\u0010M\u001a\u00020\r2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\f\u0010F\u001a\b\u0012\u0004\u0012\u00020\r0\u00192\f\u0010G\u001a\b\u0012\u0004\u0012\u00020\r0\u0019H\u0003¢\u0006\u0002\u0010D\u001a4\u0010N\u001a\u00020\r2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\r0\u00192\u0017\u0010O\u001a\u0013\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020\r0>¢\u0006\u0002\b(H\u0003¢\u0006\u0002\u0010P\u001a\u001f\u0010Q\u001a\u00020\r2\u0006\u0010R\u001a\u00020S2\b\b\u0002\u0010-\u001a\u00020.H\u0003¢\u0006\u0002\u0010T\u001a]\u0010U\u001a\u00020\r2\u0006\u0010V\u001a\u00020\u00162\u0006\u0010W\u001a\u00020\u00162\u0006\u0010X\u001a\u00020\u00162\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\f\u0010Y\u001a\b\u0012\u0004\u0012\u00020\r0\u00192\f\u0010Z\u001a\b\u0012\u0004\u0012\u00020\r0\u00192\f\u0010[\u001a\b\u0012\u0004\u0012\u00020\r0\u0019H\u0003¢\u0006\u0002\u0010\\\u001a)\u0010]\u001a\u00020\r2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\f\u0010^\u001a\b\u0012\u0004\u0012\u00020\r0\u0019H\u0003¢\u0006\u0002\u0010_\u001a \u0010`\u001a\u00020S2\u0006\u0010a\u001a\u00020S2\u0006\u0010b\u001a\u00020S2\u0006\u0010c\u001a\u00020SH\u0002\u001a\u0010\u0010d\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0003\u001a\r\u0010e\u001a\u00020\rH\u0003¢\u0006\u0002\u00101\u001a7\u0010f\u001a\u00020\r2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\f\u0010F\u001a\b\u0012\u0004\u0012\u00020\r0\u00192\f\u0010G\u001a\b\u0012\u0004\u0012\u00020\r0\u0019H\u0003¢\u0006\u0002\u0010D\u001a'\u0010g\u001a\u00020\r2\u0006\u0010R\u001a\u00020S2\u0006\u0010h\u001a\u00020\u00162\b\b\u0002\u0010-\u001a\u00020.H\u0003¢\u0006\u0002\u0010i\u001aY\u0010j\u001a\u00020\r2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u0010k\u001a\u00020l2\b\b\u0002\u0010-\u001a\u00020.2\b\b\u0002\u0010m\u001a\u00020\u00162\u000e\b\u0002\u0010F\u001a\b\u0012\u0004\u0012\u00020\r0\u00192\u000e\b\u0002\u0010G\u001a\b\u0012\u0004\u0012\u00020\r0\u0019H\u0003¢\u0006\u0004\bn\u0010o\u001a\u0015\u0010p\u001a\u00020\r2\u0006\u0010q\u001a\u00020\u0016H\u0003¢\u0006\u0002\u0010r\u001a9\u0010s\u001a\u00020\r2\u0006\u0010%\u001a\u00020\u00052\u0006\u0010t\u001a\u00020\u00052\f\u0010u\u001a\b\u0012\u0004\u0012\u00020\r0\u00192\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\r0\u0019H\u0003¢\u0006\u0002\u0010v\u001a/\u0010w\u001a\u00020\r2\u0012\u0010x\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\r0>2\f\u0010y\u001a\b\u0012\u0004\u0012\u00020\r0\u0019H\u0003¢\u0006\u0002\u0010z\u001a\u0012\u0010{\u001a\u0004\u0018\u00010|2\u0006\u0010}\u001a\u00020\u0005H\u0002¨\u0006~²\u0006\n\u0010\u007f\u001a\u00020\u0016X\u008a\u008e\u0002²\u0006\u000b\u0010\u0080\u0001\u001a\u00020\nX\u008a\u008e\u0002²\u0006\n\u0010X\u001a\u00020\u0016X\u008a\u008e\u0002²\u0006\u000b\u0010\u0081\u0001\u001a\u00020\u0016X\u008a\u008e\u0002²\u0006\n\u0010X\u001a\u00020\u0016X\u008a\u008e\u0002²\u0006\u000b\u0010\u0082\u0001\u001a\u00020\u0016X\u008a\u008e\u0002²\u0006\u000b\u0010\u0081\u0001\u001a\u00020\u0016X\u008a\u008e\u0002²\u0006\u000b\u0010\u0083\u0001\u001a\u00020SX\u008a\u008e\u0002²\u0006\n\u0010h\u001a\u00020\u0016X\u008a\u008e\u0002²\u0006\u000b\u0010\u0084\u0001\u001a\u00020SX\u008a\u008e\u0002²\u0006\u000b\u0010\u0085\u0001\u001a\u00020\u0016X\u008a\u008e\u0002²\u0006\u000b\u0010\u0086\u0001\u001a\u00020\u0016X\u008a\u008e\u0002²\u0006\u000b\u0010\u0087\u0001\u001a\u00020SX\u008a\u008e\u0002²\u0006\u000b\u0010\u0088\u0001\u001a\u00020SX\u008a\u0084\u0002²\u0006\u000b\u0010\u0089\u0001\u001a\u00020\u0016X\u008a\u008e\u0002²\u0006\n\u0010h\u001a\u00020\u0016X\u008a\u008e\u0002²\u0006\u000b\u0010\u0083\u0001\u001a\u00020SX\u008a\u008e\u0002²\u0006\u000b\u0010\u008a\u0001\u001a\u00020\u0016X\u008a\u008e\u0002²\u0006\u000b\u0010\u008b\u0001\u001a\u00020SX\u008a\u0084\u0002²\u0006\u000b\u0010\u008c\u0001\u001a\u00020SX\u008a\u0084\u0002²\u0006\u000b\u0010\u008d\u0001\u001a\u00020SX\u008a\u0084\u0002²\u0006\u000b\u0010\u008e\u0001\u001a\u00020SX\u008a\u0084\u0002²\u0006\u000b\u0010\u0085\u0001\u001a\u00020\u0016X\u008a\u008e\u0002²\u0006\u000b\u0010\u008f\u0001\u001a\u00020\u0016X\u008a\u008e\u0002²\u0006\u000b\u0010\u0090\u0001\u001a\u00020SX\u008a\u0084\u0002²\u0006\u000b\u0010\u0091\u0001\u001a\u00020\u0016X\u008a\u008e\u0002²\u0006\u000b\u0010\u0092\u0001\u001a\u00020\u0016X\u008a\u008e\u0002"}, d2 = {"getAnalyzerImage", "Landroid/media/Image;", "imageProxy", "Landroidx/camera/core/ImageProxy;", "ticketShareTypeName", "", ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "Lcom/example/tickets/TicketType;", "dataChannelTitle", "channel", "Lcom/example/tickets/TicketShareManager$DataChannel;", "dataChannelSubtitle", "TransferChannelPicker", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;Landroidx/compose/runtime/Composer;I)V", "TicketShareMenuScreen", "tickets", "", "Lcom/example/tickets/TicketData;", "nfcAvailable", "", "systemShareText", "onBack", "Lkotlin/Function0;", "onNfc", "onQr", "onSystemShare", "(Ljava/util/List;ZLjava/lang/String;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "ShareMultiPreviewCard", "(Ljava/util/List;Landroidx/compose/runtime/Composer;I)V", "ticketTypeShareName", "SharePreviewCard", "ticket", "(Lcom/example/tickets/TicketData;Landroidx/compose/runtime/Composer;I)V", "ShareActionButton", "title", "subtitle", "icon", "Landroidx/compose/runtime/Composable;", "onClick", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "ShareOutlinedButton", "text", "modifier", "Landroidx/compose/ui/Modifier;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "ShareNfcTagIcon", "(Landroidx/compose/runtime/Composer;I)V", "ShareQrScanIcon", "ShareReceiveIcon", "ShareSendIcon", "TicketTransferDirectionScreen", "onSend", "onReceive", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "TicketReceiveMenuScreen", "(ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "NfcShareScreen", "receiverModeInitially", "onAcceptedTickets", "Lkotlin/Function1;", "(Ljava/util/List;ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "QrShareScreen", "SenderConfirmationCard", "onConfirm", "onCancel", "(Ljava/util/List;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "ReceiverConfirmCard", "onAccept", "onReject", "ConfirmButton", "Landroidx/compose/foundation/layout/RowScope;", "primary", "(Landroidx/compose/foundation/layout/RowScope;Ljava/lang/String;ZLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "NfcSwipeSendCard", "QrReceivePopCard", "ShareFullScreenPage", "content", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;I)V", "TicketNfcContactRippleEffectLocal", NotificationCompat.CATEGORY_PROGRESS, "", "(FLandroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "NfcShareAnimatedArtwork", "connected", "contactDetected", "receiverMode", "onSenderTransferComplete", "onReceiverAccept", "onReceiverReject", "(ZZZLjava/util/List;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "ColorOsSendTicketFlight", "onComplete", "(Ljava/util/List;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "launchSmoothStep", "edge0", "edge1", "value", "performNativeSendHaptic", "WaitingReceiveTicketCard", "ColorOsReceiveTicketArrival", "LiquidFusionTransferGlow", "sending", "(FZLandroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "TicketTransferTicketCard", "cornerRadius", "Landroidx/compose/ui/unit/Dp;", "showButtons", "TicketTransferTicketCard-RfXq3Jk", "(Ljava/util/List;FLandroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "NfcMiniArtwork", "topTouch", "(ZLandroidx/compose/runtime/Composer;I)V", "PermissionPanel", "message", "onGrant", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "QrScannerPanel", "onResult", "onClose", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "generateShareQrBitmap", "Landroid/graphics/Bitmap;", "payload", "app", "expanded", "selected", "hasPermissions", "scannerVisible", "dragY", "sendStartProgress", "exiting", "exitAccept", "connectionPulseTarget", "connectionPulse", "dragging", "completed", "appearance", "launchPhase", "entry", "settle", "accepted", "shimmer", "handled", "hasCamera"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class TicketsShareScreensKt {

    /* JADX INFO: compiled from: TicketsShareScreens.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;

        static {
            int[] iArr = new int[TicketType.values().length];
            try {
                iArr[TicketType.Movie.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[TicketType.Train.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[TicketType.Airplane.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[TicketType.Event.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[TicketType.Admission.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[TicketType.TakeoutCode.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[TicketType.PickupCode.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[TicketShareManager.DataChannel.values().length];
            try {
                iArr2[TicketShareManager.DataChannel.NEARBY.ordinal()] = 1;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr2[TicketShareManager.DataChannel.WIFI_DIRECT.ordinal()] = 2;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr2[TicketShareManager.DataChannel.BLUETOOTH.ordinal()] = 3;
            } catch (NoSuchFieldError unused10) {
            }
            $EnumSwitchMapping$1 = iArr2;
            int[] iArr3 = new int[TicketShareManager.State.values().length];
            try {
                iArr3[TicketShareManager.State.WAITING_RECEIVER_CONFIRM.ordinal()] = 1;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr3[TicketShareManager.State.SUCCESS.ordinal()] = 2;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr3[TicketShareManager.State.REJECTED.ordinal()] = 3;
            } catch (NoSuchFieldError unused13) {
            }
            $EnumSwitchMapping$2 = iArr3;
        }
    }

    static final Unit ColorOsReceiveTicketArrival$lambda$274(List list, Function0 function0, Function0 function1, int i, Composer composer, int i2) {
        ColorOsReceiveTicketArrival(list, function0, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    static final Unit ColorOsSendTicketFlight$lambda$251(List list, Function0 function0, int i, Composer composer, int i2) {
        ColorOsSendTicketFlight(list, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    static final Unit ConfirmButton$lambda$157(RowScope rowScope, String str, boolean z, Function0 function0, int i, Composer composer, int i2) {
        ConfirmButton(rowScope, str, z, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    static final Unit LiquidFusionTransferGlow$lambda$278(float f, boolean z, Modifier modifier, int i, int i2, Composer composer, int i3) {
        LiquidFusionTransferGlow(f, z, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    static final Unit NfcMiniArtwork$lambda$293(boolean z, int i, Composer composer, int i2) {
        NfcMiniArtwork(z, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    static final Unit NfcShareAnimatedArtwork$lambda$229(boolean z, boolean z2, boolean z3, List list, Function0 function0, Function0 function1, Function0 function2, int i, Composer composer, int i2) {
        NfcShareAnimatedArtwork(z, z2, z3, list, function0, function1, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    static final Unit NfcShareScreen$lambda$79(List list, boolean z, Function0 function0, Function1 function1, int i, int i2, Composer composer, int i3) {
        NfcShareScreen(list, z, function0, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    static final Unit NfcShareScreen$lambda$91(List list, boolean z, Function0 function0, Function1 function1, int i, int i2, Composer composer, int i3) {
        NfcShareScreen(list, z, function0, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    static final Unit NfcSwipeSendCard$lambda$182(List list, Function0 function0, Function0 function1, int i, Composer composer, int i2) {
        NfcSwipeSendCard(list, function0, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    static final Unit PermissionPanel$lambda$296(String str, String str2, Function0 function0, Function0 function1, int i, Composer composer, int i2) {
        PermissionPanel(str, str2, function0, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    static final Unit QrReceivePopCard$lambda$206(List list, Function0 function0, Function0 function1, int i, Composer composer, int i2) {
        QrReceivePopCard(list, function0, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    static final PreviewView QrScannerPanel$lambda$322$lambda$321$lambda$320(PreviewView previewView, Context it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return previewView;
    }

    static final Unit QrScannerPanel$lambda$323(Function1 function1, Function0 function0, int i, Composer composer, int i2) {
        QrScannerPanel(function1, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    static final Unit QrShareScreen$lambda$114(List list, boolean z, Function0 function0, Function1 function1, int i, int i2, Composer composer, int i3) {
        QrShareScreen(list, z, function0, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    static final Unit QrShareScreen$lambda$141(List list, boolean z, Function0 function0, Function1 function1, int i, int i2, Composer composer, int i3) {
        QrShareScreen(list, z, function0, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    static final Unit ReceiverConfirmCard$lambda$155(List list, Function0 function0, Function0 function1, int i, Composer composer, int i2) {
        ReceiverConfirmCard(list, function0, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    static final Unit SenderConfirmationCard$lambda$148(List list, Function0 function0, Function0 function1, int i, Composer composer, int i2) {
        SenderConfirmationCard(list, function0, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    static final Unit ShareActionButton$lambda$40(String str, String str2, Function2 function2, Function0 function0, int i, Composer composer, int i2) {
        ShareActionButton(str, str2, function2, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    static final Unit ShareFullScreenPage$lambda$208(Function0 function0, Function3 function3, int i, Composer composer, int i2) {
        ShareFullScreenPage(function0, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    static final Unit ShareMultiPreviewCard$lambda$30(List list, int i, Composer composer, int i2) {
        ShareMultiPreviewCard(list, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    static final Unit ShareNfcTagIcon$lambda$43(int i, Composer composer, int i2) {
        ShareNfcTagIcon(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    static final Unit ShareOutlinedButton$lambda$42(String str, Function0 function0, Modifier modifier, int i, int i2, Composer composer, int i3) {
        ShareOutlinedButton(str, function0, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    static final Unit SharePreviewCard$lambda$36(TicketData ticketData, int i, Composer composer, int i2) {
        SharePreviewCard(ticketData, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    static final Unit ShareQrScanIcon$lambda$46(int i, Composer composer, int i2) {
        ShareQrScanIcon(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    static final Unit ShareReceiveIcon$lambda$49(int i, Composer composer, int i2) {
        ShareReceiveIcon(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    static final Unit ShareSendIcon$lambda$52(int i, Composer composer, int i2) {
        ShareSendIcon(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    static final Unit TicketNfcContactRippleEffectLocal$lambda$211(float f, Modifier modifier, int i, int i2, Composer composer, int i3) {
        TicketNfcContactRippleEffectLocal(f, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    static final Unit TicketReceiveMenuScreen$lambda$58(boolean z, Function0 function0, Function0 function1, Function0 function2, int i, Composer composer, int i2) {
        TicketReceiveMenuScreen(z, function0, function1, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    static final Unit TicketShareMenuScreen$lambda$23(List list, boolean z, String str, Function0 function0, Function0 function1, Function0 function2, Function0 function3, int i, Composer composer, int i2) {
        TicketShareMenuScreen(list, z, str, function0, function1, function2, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    static final Unit TicketTransferDirectionScreen$lambda$55(Function0 function0, Function0 function1, Function0 function2, int i, Composer composer, int i2) {
        TicketTransferDirectionScreen(function0, function1, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    static final Unit TicketTransferTicketCard_RfXq3Jk$lambda$289(List list, float f, Modifier modifier, boolean z, Function0 function0, Function0 function1, int i, int i2, Composer composer, int i3) {
        m9318TicketTransferTicketCardRfXq3Jk(list, f, modifier, z, function0, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    static final Unit TransferChannelPicker$lambda$21(Context context, int i, Composer composer, int i2) {
        TransferChannelPicker(context, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    static final Unit WaitingReceiveTicketCard$lambda$253(int i, Composer composer, int i2) {
        WaitingReceiveTicketCard(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    private static final Image getAnalyzerImage(ImageProxy imageProxy) {
        Object objM9536constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            Object objInvoke = ImageProxy.class.getMethod("getImage", null).invoke(imageProxy, null);
            objM9536constructorimpl = Result.m9536constructorimpl(objInvoke instanceof Image ? (Image) objInvoke : null);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM9536constructorimpl = Result.m9536constructorimpl(ResultKt.createFailure(th));
        }
        return (Image) (Result.m9542isFailureimpl(objM9536constructorimpl) ? null : objM9536constructorimpl);
    }

    private static final String ticketShareTypeName(TicketType ticketType) {
        switch (WhenMappings.$EnumSwitchMapping$0[ticketType.ordinal()]) {
            case 1:
                return "电影票";
            case 2:
                return "车票";
            case 3:
                return "机票";
            case 4:
                return "演出";
            case 5:
                return "门票";
            case 6:
                return "取餐码";
            case 7:
                return "取件码";
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    private static final String dataChannelTitle(TicketShareManager.DataChannel dataChannel) {
        int i = WhenMappings.$EnumSwitchMapping$1[dataChannel.ordinal()];
        if (i == 1) {
            return "Nearby";
        }
        if (i == 2) {
            return "Wi-Fi Direct";
        }
        if (i != 3) {
            throw new NoWhenBranchMatchedException();
        }
        return "Bluetooth";
    }

    private static final String dataChannelSubtitle(TicketShareManager.DataChannel dataChannel) {
        int i = WhenMappings.$EnumSwitchMapping$1[dataChannel.ordinal()];
        if (i == 1) {
            return "Nearby";
        }
        if (i == 2) {
            return "Wi-Fi P2P 直连";
        }
        if (i != 3) {
            throw new NoWhenBranchMatchedException();
        }
        return "Bluetooth RFCOMM";
    }

    private static final void TransferChannelPicker(final Context context, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1343715618);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(TransferChannelPicker)N(context)132@5753L34,133@5808L71,141@6146L19,135@5885L913:TicketsShareScreens.kt#n9ob9m");
        if ((i & 6) == 0) {
            i2 = i | (composerStartRestartGroup.changedInstance(context) ? 4 : 2);
        } else {
            i2 = i;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1343715618, i2, -1, "com.example.tickets.TransferChannelPicker (TicketsShareScreens.kt:131)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1474449984, "CC(remember):TicketsShareScreens.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            final MutableState mutableState = (MutableState) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1474451781, "CC(remember):TicketsShareScreens.kt#9igjgp");
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(TicketShareManager.INSTANCE.getDataChannel(context), null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            final MutableState mutableState2 = (MutableState) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierM659borderxT4_qwU = BorderKt.m659borderxT4_qwU(BackgroundKt.m648backgroundbw27NRU$default(ClipKt.clip(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), RoundedCornerShapeKt.m1756RoundedCornerShape0680j_4(Dp.m8748constructorimpl(18.0f))), ColorKt.Color(4279571736L), null, 2, null), Dp.m8748constructorimpl(1.0f), Color.m5837copywmQWz5c$default(Color.INSTANCE.m5875getWhite0d7_KjU(), 0.14f, 0.0f, 0.0f, 0.0f, 14, null), RoundedCornerShapeKt.m1756RoundedCornerShape0680j_4(Dp.m8748constructorimpl(18.0f)));
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1474462545, "CC(remember):TicketsShareScreens.kt#9igjgp");
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = new Function0() { // from class: com.example.tickets.TicketsShareScreensKt$$ExternalSyntheticLambda33
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return TicketsShareScreensKt.TransferChannelPicker$lambda$8$lambda$7(mutableState);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierM1424paddingVpY3zN4 = PaddingKt.m1424paddingVpY3zN4(ClickableKt.m683clickableoSLSa3U$default(modifierM659borderxT4_qwU, false, null, null, null, (Function0) objRememberedValue3, 15, null), Dp.m8748constructorimpl(16.0f), Dp.m8748constructorimpl(13.0f));
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1424paddingVpY3zN4);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)410@16216L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM4937constructorimpl = Updater.m4937constructorimpl(composerStartRestartGroup);
            Updater.m4945setimpl(composerM4937constructorimpl, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m4945setimpl(composerM4937constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m4945setimpl(composerM4937constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m4943reconcileimpl(composerM4937constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m4945setimpl(composerM4937constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1038543956, "C144@6241L551:TicketsShareScreens.kt#n9ob9m");
            Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, composerStartRestartGroup, 48);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
            int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxWidth$default);
            Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)410@16216L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor2);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM4937constructorimpl2 = Updater.m4937constructorimpl(composerStartRestartGroup);
            Updater.m4945setimpl(composerM4937constructorimpl2, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m4945setimpl(composerM4937constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m4945setimpl(composerM4937constructorimpl2, Integer.valueOf(iHashCode2), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m4943reconcileimpl(composerM4937constructorimpl2, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m4945setimpl(composerM4937constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 895253160, "C145@6343L371,154@6727L55:TicketsShareScreens.kt#n9ob9m");
            Modifier modifierWeight$default = RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
            int iHashCode3 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierWeight$default);
            Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)410@16216L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor3);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM4937constructorimpl3 = Updater.m4937constructorimpl(composerStartRestartGroup);
            Updater.m4945setimpl(composerM4937constructorimpl3, measurePolicyColumnMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m4945setimpl(composerM4937constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m4945setimpl(composerM4937constructorimpl3, Integer.valueOf(iHashCode3), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m4943reconcileimpl(composerM4937constructorimpl3, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m4945setimpl(composerM4937constructorimpl3, modifierMaterializeModifier3, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -582317154, "C146@6389L85,147@6491L29,148@6537L163:TicketsShareScreens.kt#n9ob9m");
            TextKt.m3661TextNvy7gAk("数据传输通道", null, Color.INSTANCE.m5875getWhite0d7_KjU(), null, TextUnitKt.getSp(15), null, FontWeight.INSTANCE.getMedium(), null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composerStartRestartGroup, 1597830, 0, 262058);
            SpacerKt.Spacer(SizeKt.m1476height3ABfNKs(Modifier.INSTANCE, Dp.m8748constructorimpl(3.0f)), composerStartRestartGroup, 6);
            TextKt.m3661TextNvy7gAk("当前：" + dataChannelTitle(TransferChannelPicker$lambda$5(mutableState2)), null, ColorKt.Color(4287598486L), null, TextUnitKt.getSp(12), null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composerStartRestartGroup, 24960, 0, 262122);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            TextKt.m3661TextNvy7gAk("更改", null, ColorKt.Color(4292335580L), null, TextUnitKt.getSp(13), null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composerStartRestartGroup, 24966, 0, 262122);
            composerStartRestartGroup = composerStartRestartGroup;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (!TransferChannelPicker$lambda$2(mutableState)) {
                composerStartRestartGroup.startReplaceGroup(-1542399772);
            } else {
                composerStartRestartGroup.startReplaceGroup(-1535556677);
                ComposerKt.sourceInformation(composerStartRestartGroup, "159@6881L20,159@6903L2446,159@6855L2494");
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1474486066, "CC(remember):TicketsShareScreens.kt#9igjgp");
                Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue4 = new Function0() { // from class: com.example.tickets.TicketsShareScreensKt$$ExternalSyntheticLambda44
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return TicketsShareScreensKt.TransferChannelPicker$lambda$13$lambda$12(mutableState);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                AndroidDialog_androidKt.Dialog((Function0) objRememberedValue4, null, ComposableLambdaKt.rememberComposableLambda(872268012, true, new Function2() { // from class: com.example.tickets.TicketsShareScreensKt$$ExternalSyntheticLambda55
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return TicketsShareScreensKt.TransferChannelPicker$lambda$20(context, mutableState2, mutableState, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, 390, 2);
            }
            composerStartRestartGroup.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.tickets.TicketsShareScreensKt$$ExternalSyntheticLambda66
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TicketsShareScreensKt.TransferChannelPicker$lambda$21(context, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final boolean TransferChannelPicker$lambda$2(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void TransferChannelPicker$lambda$3(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final TicketShareManager.DataChannel TransferChannelPicker$lambda$5(MutableState<TicketShareManager.DataChannel> mutableState) {
        return mutableState.getValue();
    }

    static final Unit TransferChannelPicker$lambda$8$lambda$7(MutableState mutableState) {
        TransferChannelPicker$lambda$3(mutableState, true);
        return Unit.INSTANCE;
    }

    static final Unit TransferChannelPicker$lambda$13$lambda$12(MutableState mutableState) {
        TransferChannelPicker$lambda$3(mutableState, false);
        return Unit.INSTANCE;
    }

    static final Unit TransferChannelPicker$lambda$20(final Context context, final MutableState mutableState, final MutableState mutableState2, Composer composer, int i) {
        char c;
        ComposerKt.sourceInformation(composer, "C160@6917L2422:TicketsShareScreens.kt#n9ob9m");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(872268012, i, -1, "com.example.tickets.TransferChannelPicker.<anonymous> (TicketsShareScreens.kt:160)");
            }
            Modifier modifierM1423padding3ABfNKs = PaddingKt.m1423padding3ABfNKs(BackgroundKt.m648backgroundbw27NRU$default(ClipKt.clip(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), RoundedCornerShapeKt.m1756RoundedCornerShape0680j_4(Dp.m8748constructorimpl(22.0f))), ColorKt.Color(4279769115L), null, 2, null), Dp.m8748constructorimpl(18.0f));
            ComposerKt.sourceInformationMarkerStart(composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer, 0);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierM1423padding3ABfNKs);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)410@16216L9:Composables.kt#9igjgp");
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor);
            } else {
                composer.useNode();
            }
            Composer composerM4937constructorimpl = Updater.m4937constructorimpl(composer);
            Updater.m4945setimpl(composerM4937constructorimpl, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m4945setimpl(composerM4937constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m4945setimpl(composerM4937constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m4943reconcileimpl(composerM4937constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m4945setimpl(composerM4937constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, 675473249, "C167@7169L87,168@7273L29,169@7319L174,174@7510L30:TicketsShareScreens.kt#n9ob9m");
            String str = "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh";
            String str2 = "CC(ReusableComposeNode)N(factory,update,content)410@16216L9:Composables.kt#9igjgp";
            String str3 = "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo";
            String str4 = "C89@4557L9:Column.kt#2w3rfo";
            TextKt.m3661TextNvy7gAk("选择数据传输通道", null, Color.INSTANCE.m5875getWhite0d7_KjU(), null, TextUnitKt.getSp(20), null, FontWeight.INSTANCE.getMedium(), null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer, 1597830, 0, 262058);
            SpacerKt.Spacer(SizeKt.m1476height3ABfNKs(Modifier.INSTANCE, Dp.m8748constructorimpl(6.0f)), composer, 6);
            TextKt.m3661TextNvy7gAk("NFC / 二维码只负责建立会话；票据数据使用这里选择的通道。不会自动切换到其他通道。", null, ColorKt.Color(4288059037L), null, TextUnitKt.getSp(13), null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer, 24966, 0, 262122);
            Composer composer2 = composer;
            SpacerKt.Spacer(SizeKt.m1476height3ABfNKs(Modifier.INSTANCE, Dp.m8748constructorimpl(14.0f)), composer2, 6);
            composer2.startReplaceGroup(-1640765258);
            ComposerKt.sourceInformation(composer2, "*187@8281L215,177@7709L1485");
            TicketShareManager.DataChannel[] dataChannelArrValues = TicketShareManager.DataChannel.values();
            int length = dataChannelArrValues.length;
            int i2 = 0;
            int i3 = 0;
            while (i2 < length) {
                final TicketShareManager.DataChannel dataChannel = dataChannelArrValues[i2];
                int i4 = i3 + 1;
                boolean z = TransferChannelPicker$lambda$5(mutableState) == dataChannel;
                Modifier modifierClip = ClipKt.clip(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), RoundedCornerShapeKt.m1756RoundedCornerShape0680j_4(Dp.m8748constructorimpl(14.0f)));
                Color.Companion companion = Color.INSTANCE;
                Modifier modifierM648backgroundbw27NRU$default = BackgroundKt.m648backgroundbw27NRU$default(modifierClip, z ? Color.m5837copywmQWz5c$default(companion.m5875getWhite0d7_KjU(), 0.1f, 0.0f, 0.0f, 0.0f, 14, null) : companion.m5873getTransparent0d7_KjU(), null, 2, null);
                float fM8748constructorimpl = Dp.m8748constructorimpl(1.0f);
                Color.Companion companion2 = Color.INSTANCE;
                Modifier modifierM659borderxT4_qwU = BorderKt.m659borderxT4_qwU(modifierM648backgroundbw27NRU$default, fM8748constructorimpl, z ? Color.m5837copywmQWz5c$default(companion2.m5875getWhite0d7_KjU(), 0.24f, 0.0f, 0.0f, 0.0f, 14, null) : companion2.m5873getTransparent0d7_KjU(), RoundedCornerShapeKt.m1756RoundedCornerShape0680j_4(Dp.m8748constructorimpl(14.0f)));
                ComposerKt.sourceInformationMarkerStart(composer2, -1279127553, "CC(remember):TicketsShareScreens.kt#9igjgp");
                boolean zChanged = composer2.changed(dataChannel.ordinal()) | composer2.changedInstance(context);
                Object objRememberedValue = composer2.rememberedValue();
                if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function0() { // from class: com.example.tickets.TicketsShareScreensKt$$ExternalSyntheticLambda58
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return TicketsShareScreensKt.TransferChannelPicker$lambda$20$lambda$19$lambda$18$lambda$15$lambda$14(dataChannel, context, mutableState, mutableState2);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                Modifier modifierM1424paddingVpY3zN4 = PaddingKt.m1424paddingVpY3zN4(ClickableKt.m683clickableoSLSa3U$default(modifierM659borderxT4_qwU, false, null, null, null, (Function0) objRememberedValue, 15, null), Dp.m8748constructorimpl(14.0f), Dp.m8748constructorimpl(13.0f));
                Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                ComposerKt.sourceInformationMarkerStart(composer2, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, composer2, 48);
                String str5 = str;
                ComposerKt.sourceInformationMarkerStart(composer2, -1159599143, str5);
                int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer2, 0));
                CompositionLocalMap currentCompositionLocalMap2 = composer2.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer2, modifierM1424paddingVpY3zN4);
                Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                TicketShareManager.DataChannel[] dataChannelArr = dataChannelArrValues;
                String str6 = str2;
                ComposerKt.sourceInformationMarkerStart(composer2, -553112988, str6);
                if (!(composer2.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composer2.startReusableNode();
                if (composer2.getInserting()) {
                    composer2.createNode(constructor2);
                } else {
                    composer2.useNode();
                }
                Composer composerM4937constructorimpl2 = Updater.m4937constructorimpl(composer2);
                Updater.m4945setimpl(composerM4937constructorimpl2, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m4945setimpl(composerM4937constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Updater.m4945setimpl(composerM4937constructorimpl2, Integer.valueOf(iHashCode2), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                Updater.m4943reconcileimpl(composerM4937constructorimpl2, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                Updater.m4945setimpl(composerM4937constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composer2, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composer2, -1796191113, "C195@8692L391:TicketsShareScreens.kt#n9ob9m");
                Modifier modifierWeight$default = RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null);
                String str7 = str3;
                ComposerKt.sourceInformationMarkerStart(composer2, 1341605231, str7);
                MeasurePolicy measurePolicyColumnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer2, 0);
                ComposerKt.sourceInformationMarkerStart(composer2, -1159599143, str5);
                int iHashCode3 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer2, 0));
                CompositionLocalMap currentCompositionLocalMap3 = composer2.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composer2, modifierWeight$default);
                Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composer2, -553112988, str6);
                if (!(composer2.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composer2.startReusableNode();
                if (composer2.getInserting()) {
                    composer2.createNode(constructor3);
                } else {
                    composer2.useNode();
                }
                Composer composerM4937constructorimpl3 = Updater.m4937constructorimpl(composer2);
                Updater.m4945setimpl(composerM4937constructorimpl3, measurePolicyColumnMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m4945setimpl(composerM4937constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Updater.m4945setimpl(composerM4937constructorimpl3, Integer.valueOf(iHashCode3), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                Updater.m4943reconcileimpl(composerM4937constructorimpl3, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                Updater.m4945setimpl(composerM4937constructorimpl3, modifierMaterializeModifier3, ComposeUiNode.INSTANCE.getSetModifier());
                String str8 = str4;
                ComposerKt.sourceInformationMarkerStart(composer2, 2093002350, str8);
                ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composer2, -1774810930, "C196@8750L141,197@8920L29,198@8978L79:TicketsShareScreens.kt#n9ob9m");
                String strDataChannelTitle = dataChannelTitle(dataChannel);
                long jM5875getWhite0d7_KjU = Color.INSTANCE.m5875getWhite0d7_KjU();
                long sp = TextUnitKt.getSp(15);
                FontWeight.Companion companion3 = FontWeight.INSTANCE;
                str2 = str6;
                int i5 = i2;
                int i6 = length;
                str = str5;
                int i7 = i3;
                str4 = str8;
                TextKt.m3661TextNvy7gAk(strDataChannelTitle, null, jM5875getWhite0d7_KjU, null, sp, null, z ? companion3.getMedium() : companion3.getNormal(), null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer, 24960, 0, 262058);
                SpacerKt.Spacer(SizeKt.m1476height3ABfNKs(Modifier.INSTANCE, Dp.m8748constructorimpl(3.0f)), composer, 6);
                TextKt.m3661TextNvy7gAk(dataChannelSubtitle(dataChannel), null, ColorKt.Color(4287598486L), null, TextUnitKt.getSp(12), null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer, 24960, 0, 262122);
                composer2 = composer;
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                if (z) {
                    composer2.startReplaceGroup(911903068);
                    ComposerKt.sourceInformation(composer2, "200@9124L48");
                    TextKt.m3661TextNvy7gAk("✓", null, Color.INSTANCE.m5875getWhite0d7_KjU(), null, TextUnitKt.getSp(17), null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer, 24966, 0, 262122);
                    composer2 = composer;
                } else {
                    composer2.startReplaceGroup(-1804829450);
                }
                composer2.endReplaceGroup();
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                if (i7 < ArraysKt.getLastIndex(TicketShareManager.DataChannel.values())) {
                    composer2.startReplaceGroup(-1279095835);
                    ComposerKt.sourceInformation(composer2, "202@9278L29");
                    c = 6;
                    SpacerKt.Spacer(SizeKt.m1476height3ABfNKs(Modifier.INSTANCE, Dp.m8748constructorimpl(8.0f)), composer2, 6);
                } else {
                    c = 6;
                    composer2.startReplaceGroup(-1006470886);
                }
                composer2.endReplaceGroup();
                i2 = i5 + 1;
                i3 = i4;
                length = i6;
                dataChannelArrValues = dataChannelArr;
                str3 = str7;
            }
            composer2.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    static final Unit TransferChannelPicker$lambda$20$lambda$19$lambda$18$lambda$15$lambda$14(TicketShareManager.DataChannel dataChannel, Context context, MutableState mutableState, MutableState mutableState2) {
        mutableState.setValue(dataChannel);
        TicketShareManager.INSTANCE.setDataChannel(context, dataChannel);
        TransferChannelPicker$lambda$3(mutableState2, false);
        return Unit.INSTANCE;
    }

    public static final void TicketShareMenuScreen(final List<TicketData> tickets, final boolean z, final String systemShareText, final Function0<Unit> onBack, final Function0<Unit> onNfc, final Function0<Unit> onQr, final Function0<Unit> onSystemShare, Composer composer, final int i) {
        int i2;
        int i3;
        Composer composer2;
        int i4;
        float f;
        String str;
        Intrinsics.checkNotNullParameter(tickets, "tickets");
        Intrinsics.checkNotNullParameter(systemShareText, "systemShareText");
        Intrinsics.checkNotNullParameter(onBack, "onBack");
        Intrinsics.checkNotNullParameter(onNfc, "onNfc");
        Intrinsics.checkNotNullParameter(onQr, "onQr");
        Intrinsics.checkNotNullParameter(onSystemShare, "onSystemShare");
        Composer composerStartRestartGroup = composer.startRestartGroup(1721054146);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(TicketShareMenuScreen)N(tickets,nfcAvailable,systemShareText,onBack,onNfc,onQr,onSystemShare)219@9601L2025:TicketsShareScreens.kt#n9ob9m");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(tickets) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(z) ? 32 : 16;
        }
        if ((i & 3072) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(onBack) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(onNfc) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(onQr) ? 131072 : 65536;
        }
        if ((1572864 & i) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(onSystemShare) ? 1048576 : 524288;
        }
        if (!composerStartRestartGroup.shouldExecute((599059 & i2) != 599058, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1721054146, i2, -1, "com.example.tickets.TicketShareMenuScreen (TicketsShareScreens.kt:218)");
            }
            Modifier modifierM1425paddingVpY3zN4$default = PaddingKt.m1425paddingVpY3zN4$default(BackgroundKt.m648backgroundbw27NRU$default(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), Color.INSTANCE.m5864getBlack0d7_KjU(), null, 2, null), Dp.m8748constructorimpl(20.0f), 0.0f, 2, null);
            Alignment.Horizontal centerHorizontally = Alignment.INSTANCE.getCenterHorizontally();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), centerHorizontally, composerStartRestartGroup, 48);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1425paddingVpY3zN4$default);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)410@16216L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM4937constructorimpl = Updater.m4937constructorimpl(composerStartRestartGroup);
            Updater.m4945setimpl(composerM4937constructorimpl, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m4945setimpl(composerM4937constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m4945setimpl(composerM4937constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m4943reconcileimpl(composerM4937constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m4945setimpl(composerM4937constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -741487251, "C226@9818L30,227@9857L143,233@10009L29,234@10047L111,239@10167L30,241@10242L7,241@10207L43,243@10260L30,245@10300L30,246@10339L30,258@10668L169,265@10847L30,267@10887L176,274@11073L30,275@11112L286,286@11408L30,288@11448L132,294@11590L30:TicketsShareScreens.kt#n9ob9m");
            SpacerKt.Spacer(SizeKt.m1476height3ABfNKs(Modifier.INSTANCE, Dp.m8748constructorimpl(34.0f)), composerStartRestartGroup, 6);
            TextKt.m3661TextNvy7gAk("选择传输方式", null, Color.INSTANCE.m5875getWhite0d7_KjU(), null, TextUnitKt.getSp(23), null, FontWeight.INSTANCE.getMedium(), null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composerStartRestartGroup, 1597830, 0, 262058);
            SpacerKt.Spacer(SizeKt.m1476height3ABfNKs(Modifier.INSTANCE, Dp.m8748constructorimpl(8.0f)), composerStartRestartGroup, 6);
            TextKt.m3661TextNvy7gAk("选择一种方式传输这组票据", null, ColorKt.Color(4287598486L), null, TextUnitKt.getSp(14), null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composerStartRestartGroup, 24966, 0, 262122);
            SpacerKt.Spacer(SizeKt.m1476height3ABfNKs(Modifier.INSTANCE, Dp.m8748constructorimpl(22.0f)), composerStartRestartGroup, 6);
            ProvidableCompositionLocal<Context> localContext = AndroidCompositionLocals_androidKt.getLocalContext();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composerStartRestartGroup.consume(localContext);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            TransferChannelPicker((Context) objConsume, composerStartRestartGroup, 0);
            SpacerKt.Spacer(SizeKt.m1476height3ABfNKs(Modifier.INSTANCE, Dp.m8748constructorimpl(16.0f)), composerStartRestartGroup, 6);
            ShareMultiPreviewCard(tickets, composerStartRestartGroup, i2 & 14);
            SpacerKt.Spacer(SizeKt.m1476height3ABfNKs(Modifier.INSTANCE, Dp.m8748constructorimpl(22.0f)), composerStartRestartGroup, 6);
            if (z) {
                composerStartRestartGroup.startReplaceGroup(-740960655);
                ComposerKt.sourceInformation(composerStartRestartGroup, "249@10411L194,255@10618L30");
                composer2 = composerStartRestartGroup;
                i3 = 6;
                i4 = 1;
                f = 0.0f;
                ShareActionButton("NFC一碰分享", "两部手机靠近后，快速建立安全分享连接", ComposableSingletons$TicketsShareScreensKt.INSTANCE.m9295getLambda$423040585$app(), onNfc, composer2, ((i2 >> 3) & 7168) | 438);
                SpacerKt.Spacer(SizeKt.m1476height3ABfNKs(Modifier.INSTANCE, Dp.m8748constructorimpl(10.0f)), composer2, 6);
            } else {
                i3 = 6;
                composer2 = composerStartRestartGroup;
                i4 = 1;
                f = 0.0f;
                composer2.startReplaceGroup(-751283562);
            }
            composer2.endReplaceGroup();
            int i5 = i2 >> 6;
            ShareActionButton("二维码分享", "扫码建立分享连接，双方确认后接收", ComposableSingletons$TicketsShareScreensKt.INSTANCE.m9296getLambda$780411470$app(), onQr, composer2, (i5 & 7168) | 438);
            SpacerKt.Spacer(SizeKt.m1476height3ABfNKs(Modifier.INSTANCE, Dp.m8748constructorimpl(10.0f)), composer2, i3);
            ShareActionButton("系统分享", "使用 Android 原生分享面板", ComposableSingletons$TicketsShareScreensKt.INSTANCE.getLambda$1054715227$app(), onSystemShare, composer2, ((i2 >> 9) & 7168) | 438);
            SpacerKt.Spacer(SizeKt.m1476height3ABfNKs(Modifier.INSTANCE, Dp.m8748constructorimpl(18.0f)), composer2, i3);
            if (z) {
                str = "NFC和二维码传输需双方应用版本均为5.5.0及以上";
            } else {
                str = "二维码传输需双方应用版本均为5.5.0及以上";
            }
            Composer composer3 = composer2;
            TextKt.m3661TextNvy7gAk(str, null, ColorKt.Color(4286085247L), null, TextUnitKt.getSp(12), null, null, null, 0L, null, TextAlign.m8619boximpl(TextAlign.INSTANCE.m8626getCentere0LSkKk()), 0L, 0, false, 0, 0, null, null, composer3, 24960, 0, 261098);
            SpacerKt.Spacer(SizeKt.m1476height3ABfNKs(Modifier.INSTANCE, Dp.m8748constructorimpl(18.0f)), composer3, i3);
            ShareOutlinedButton("返回", onBack, SizeKt.fillMaxWidth$default(Modifier.INSTANCE, f, i4, null), composer3, (i5 & StylePropertiesKt.TextDirectionMask) | 390, 0);
            composerStartRestartGroup = composer3;
            SpacerKt.Spacer(SizeKt.m1476height3ABfNKs(Modifier.INSTANCE, Dp.m8748constructorimpl(24.0f)), composerStartRestartGroup, i3);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.tickets.TicketsShareScreensKt$$ExternalSyntheticLambda17
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TicketsShareScreensKt.TicketShareMenuScreen$lambda$23(tickets, z, systemShareText, onBack, onNfc, onQr, onSystemShare, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final void ShareMultiPreviewCard(final List<TicketData> list, Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(2004580263);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ShareMultiPreviewCard)N(tickets)301@11743L2007:TicketsShareScreens.kt#n9ob9m");
        int i2 = (i & 6) == 0 ? i | (composerStartRestartGroup.changedInstance(list) ? 4 : 2) : i;
        if (!composerStartRestartGroup.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2004580263, i2, -1, "com.example.tickets.ShareMultiPreviewCard (TicketsShareScreens.kt:299)");
            }
            List listTake = CollectionsKt.take(list, 4);
            Modifier modifierM1423padding3ABfNKs = PaddingKt.m1423padding3ABfNKs(BorderKt.m659borderxT4_qwU(BackgroundKt.m647backgroundbw27NRU(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), ColorKt.Color(4279505942L), RoundedCornerShapeKt.m1756RoundedCornerShape0680j_4(Dp.m8748constructorimpl(18.0f))), Dp.m8748constructorimpl(1.0f), Color.m5837copywmQWz5c$default(Color.INSTANCE.m5875getWhite0d7_KjU(), 0.13f, 0.0f, 0.0f, 0.0f, 14, null), RoundedCornerShapeKt.m1756RoundedCornerShape0680j_4(Dp.m8748constructorimpl(18.0f))), Dp.m8748constructorimpl(16.0f));
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1423padding3ABfNKs);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)410@16216L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM4937constructorimpl = Updater.m4937constructorimpl(composerStartRestartGroup);
            Updater.m4945setimpl(composerM4937constructorimpl, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m4945setimpl(composerM4937constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m4945setimpl(composerM4937constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m4943reconcileimpl(composerM4937constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m4945setimpl(composerM4937constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -540169765, "C312@12069L459,329@12538L30:TicketsShareScreens.kt#n9ob9m");
            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Modifier.Companion companion = Modifier.INSTANCE;
            String str = "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo";
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, composerStartRestartGroup, 48);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
            int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion);
            Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)410@16216L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor2);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM4937constructorimpl2 = Updater.m4937constructorimpl(composerStartRestartGroup);
            Updater.m4945setimpl(composerM4937constructorimpl2, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m4945setimpl(composerM4937constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m4945setimpl(composerM4937constructorimpl2, Integer.valueOf(iHashCode2), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m4943reconcileimpl(composerM4937constructorimpl2, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m4945setimpl(composerM4937constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1399162969, "C315@12157L216,322@12386L132:TicketsShareScreens.kt#n9ob9m");
            float f = 0.0f;
            Object obj = null;
            String str2 = "CC(ReusableComposeNode)N(factory,update,content)410@16216L9:Composables.kt#9igjgp";
            int i3 = 1;
            String str3 = "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh";
            TextKt.m3661TextNvy7gAk("待分享票据", RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null), ColorKt.Color(4294046195L), null, TextUnitKt.getSp(15), null, FontWeight.INSTANCE.getMedium(), null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composerStartRestartGroup, 1597830, 0, 262056);
            TextKt.m3661TextNvy7gAk(list.size() + " 张", null, ColorKt.Color(4290295998L), null, TextUnitKt.getSp(13), null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composerStartRestartGroup, 24960, 0, 262122);
            composerStartRestartGroup = composerStartRestartGroup;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            int i4 = 6;
            SpacerKt.Spacer(SizeKt.m1476height3ABfNKs(Modifier.INSTANCE, Dp.m8748constructorimpl(10.0f)), composerStartRestartGroup, 6);
            composerStartRestartGroup.startReplaceGroup(-848693058);
            ComposerKt.sourceInformation(composerStartRestartGroup, "*332@12632L841");
            int i5 = 0;
            for (Object obj2 : listTake) {
                int i6 = i5 + 1;
                if (i5 < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                TicketData ticketData = (TicketData) obj2;
                Modifier modifierM1425paddingVpY3zN4$default = PaddingKt.m1425paddingVpY3zN4$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, f, i3, obj), f, Dp.m8748constructorimpl(4.0f), i3, obj);
                Alignment.Vertical centerVertically2 = Alignment.INSTANCE.getCenterVertically();
                String str4 = str;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, str4);
                MeasurePolicy measurePolicyRowMeasurePolicy2 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically2, composerStartRestartGroup, 48);
                String str5 = str3;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, str5);
                int iHashCode3 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1425paddingVpY3zN4$default);
                Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                String str6 = str2;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, str6);
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor3);
                } else {
                    composerStartRestartGroup.useNode();
                }
                Composer composerM4937constructorimpl3 = Updater.m4937constructorimpl(composerStartRestartGroup);
                Updater.m4945setimpl(composerM4937constructorimpl3, measurePolicyRowMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m4945setimpl(composerM4937constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Updater.m4945setimpl(composerM4937constructorimpl3, Integer.valueOf(iHashCode3), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                Updater.m4943reconcileimpl(composerM4937constructorimpl3, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                Updater.m4945setimpl(composerM4937constructorimpl3, modifierMaterializeModifier3, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1517255903, "C338@12851L197,344@13065L394:TicketsShareScreens.kt#n9ob9m");
                Composer composer2 = composerStartRestartGroup;
                int i7 = i4;
                str3 = str5;
                TextKt.m3661TextNvy7gAk(String.valueOf(i6), SizeKt.m1495width3ABfNKs(Modifier.INSTANCE, Dp.m8748constructorimpl(20.0f)), ColorKt.Color(4286019453L), null, TextUnitKt.getSp(12), null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer2, 25008, 0, 262120);
                String title = ticketData.getTitle();
                if (StringsKt.isBlank(title)) {
                    String code = ticketData.getCode();
                    if (StringsKt.isBlank(code)) {
                        code = ticketShareTypeName(ticketData.getType());
                    }
                    title = code;
                }
                TextKt.m3661TextNvy7gAk(title, RowScope.weight$default(rowScopeInstance2, Modifier.INSTANCE, 1.0f, false, 2, null), ColorKt.Color(4292532959L), null, TextUnitKt.getSp(13), null, null, null, 0L, null, null, 0L, TextOverflow.INSTANCE.m8684getEllipsisgIe3tQ8(), false, 1, 0, null, null, composer2, 24960, 24960, 241640);
                composerStartRestartGroup = composer2;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                i4 = i7;
                str = str4;
                str2 = str6;
                i5 = i6;
                obj = null;
                f = 0.0f;
                i3 = 1;
            }
            int i8 = i4;
            composerStartRestartGroup.endReplaceGroup();
            if (list.size() <= listTake.size()) {
                composerStartRestartGroup.startReplaceGroup(-552195131);
            } else {
                composerStartRestartGroup.startReplaceGroup(-538769589);
                ComposerKt.sourceInformation(composerStartRestartGroup, "358@13540L29,359@13582L152");
                SpacerKt.Spacer(SizeKt.m1476height3ABfNKs(Modifier.INSTANCE, Dp.m8748constructorimpl(4.0f)), composerStartRestartGroup, i8);
                Composer composer3 = composerStartRestartGroup;
                TextKt.m3661TextNvy7gAk("还有 " + (list.size() - listTake.size()) + " 张票据", null, ColorKt.Color(4286019453L), null, TextUnitKt.getSp(12), null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer3, 24960, 0, 262122);
                composerStartRestartGroup = composer3;
            }
            composerStartRestartGroup.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.tickets.TicketsShareScreensKt$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj3, Object obj4) {
                    return TicketsShareScreensKt.ShareMultiPreviewCard$lambda$30(list, i, (Composer) obj3, ((Integer) obj4).intValue());
                }
            });
        }
    }

    private static final String ticketTypeShareName(TicketType ticketType) {
        switch (WhenMappings.$EnumSwitchMapping$0[ticketType.ordinal()]) {
            case 1:
                return "电影票";
            case 2:
                return "车票";
            case 3:
                return "机票";
            case 4:
                return "演出";
            case 5:
                return "门票";
            case 6:
                return "取餐码";
            case 7:
                return "取件码";
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    private static final void SharePreviewCard(final TicketData ticketData, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1564995290);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(SharePreviewCard)N(ticket)381@14158L1349:TicketsShareScreens.kt#n9ob9m");
        int i3 = (i & 6) == 0 ? (composerStartRestartGroup.changed(ticketData) ? 4 : 2) | i : i;
        if (!composerStartRestartGroup.shouldExecute((i3 & 3) != 2, i3 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1564995290, i3, -1, "com.example.tickets.SharePreviewCard (TicketsShareScreens.kt:380)");
            }
            Modifier modifierM1423padding3ABfNKs = PaddingKt.m1423padding3ABfNKs(BorderKt.m659borderxT4_qwU(BackgroundKt.m647backgroundbw27NRU(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), ColorKt.Color(4279571736L), RoundedCornerShapeKt.m1756RoundedCornerShape0680j_4(Dp.m8748constructorimpl(22.0f))), Dp.m8748constructorimpl(1.0f), Color.m5837copywmQWz5c$default(Color.INSTANCE.m5875getWhite0d7_KjU(), 0.08f, 0.0f, 0.0f, 0.0f, 14, null), RoundedCornerShapeKt.m1756RoundedCornerShape0680j_4(Dp.m8748constructorimpl(22.0f))), Dp.m8748constructorimpl(18.0f));
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1423padding3ABfNKs);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)410@16216L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM4937constructorimpl = Updater.m4937constructorimpl(composerStartRestartGroup);
            Updater.m4945setimpl(composerM4937constructorimpl, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m4945setimpl(composerM4937constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m4945setimpl(composerM4937constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m4943reconcileimpl(composerM4937constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m4945setimpl(composerM4937constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 197476988, "C388@14422L83,389@14514L29,390@14552L188:TicketsShareScreens.kt#n9ob9m");
            TextKt.m3661TextNvy7gAk(ticketShareTypeName(ticketData.getType()), null, ColorKt.Color(4288322210L), null, TextUnitKt.getSp(13), null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composerStartRestartGroup, 24960, 0, 262122);
            SpacerKt.Spacer(SizeKt.m1476height3ABfNKs(Modifier.INSTANCE, Dp.m8748constructorimpl(6.0f)), composerStartRestartGroup, 6);
            String title = ticketData.getTitle();
            if (StringsKt.isBlank(title)) {
                String code = ticketData.getCode();
                if (StringsKt.isBlank(code)) {
                    code = "票据";
                }
                title = code;
            }
            TextKt.m3661TextNvy7gAk(title, null, Color.INSTANCE.m5875getWhite0d7_KjU(), null, TextUnitKt.getSp(21), null, FontWeight.INSTANCE.getMedium(), null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composerStartRestartGroup, 1597824, 0, 262058);
            composerStartRestartGroup = composerStartRestartGroup;
            List listListOf = CollectionsKt.listOf((Object[]) new String[]{ticketData.getFrom(), ticketData.getTo()});
            ArrayList arrayList = new ArrayList();
            for (Object obj : listListOf) {
                if (!StringsKt.isBlank((String) obj)) {
                    arrayList.add(obj);
                }
            }
            String strJoinToString$default = CollectionsKt.joinToString$default(arrayList, " → ", null, null, 0, null, null, 62, null);
            if (StringsKt.isBlank(strJoinToString$default)) {
                i2 = 183135922;
                composerStartRestartGroup.startReplaceGroup(183135922);
            } else {
                composerStartRestartGroup.startReplaceGroup(197893162);
                ComposerKt.sourceInformation(composerStartRestartGroup, "398@14885L29,399@14927L70");
                SpacerKt.Spacer(SizeKt.m1476height3ABfNKs(Modifier.INSTANCE, Dp.m8748constructorimpl(6.0f)), composerStartRestartGroup, 6);
                i2 = 183135922;
                TextKt.m3661TextNvy7gAk(strJoinToString$default, null, Color.m5837copywmQWz5c$default(Color.INSTANCE.m5875getWhite0d7_KjU(), 0.88f, 0.0f, 0.0f, 0.0f, 14, null), null, TextUnitKt.getSp(15), null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composerStartRestartGroup, 24960, 0, 262122);
                composerStartRestartGroup = composerStartRestartGroup;
            }
            composerStartRestartGroup.endReplaceGroup();
            if (StringsKt.isBlank(ticketData.getDate()) && StringsKt.isBlank(ticketData.getTime())) {
                composerStartRestartGroup.startReplaceGroup(i2);
            } else {
                composerStartRestartGroup.startReplaceGroup(198098320);
                ComposerKt.sourceInformation(composerStartRestartGroup, "402@15088L29,403@15130L192");
                SpacerKt.Spacer(SizeKt.m1476height3ABfNKs(Modifier.INSTANCE, Dp.m8748constructorimpl(8.0f)), composerStartRestartGroup, 6);
                List listListOf2 = CollectionsKt.listOf((Object[]) new String[]{ticketData.getDate(), ticketData.getTime()});
                ArrayList arrayList2 = new ArrayList();
                for (Object obj2 : listListOf2) {
                    if (!StringsKt.isBlank((String) obj2)) {
                        arrayList2.add(obj2);
                    }
                }
                Composer composer2 = composerStartRestartGroup;
                TextKt.m3661TextNvy7gAk(CollectionsKt.joinToString$default(arrayList2, " · ", null, null, 0, null, null, 62, null), null, ColorKt.Color(4289769655L), null, TextUnitKt.getSp(13), null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer2, 24960, 0, 262122);
                composerStartRestartGroup = composer2;
            }
            composerStartRestartGroup.endReplaceGroup();
            if (StringsKt.isBlank(ticketData.getVenue())) {
                composerStartRestartGroup.startReplaceGroup(i2);
            } else {
                composerStartRestartGroup.startReplaceGroup(198389937);
                ComposerKt.sourceInformation(composerStartRestartGroup, "410@15386L29,411@15428L63");
                SpacerKt.Spacer(SizeKt.m1476height3ABfNKs(Modifier.INSTANCE, Dp.m8748constructorimpl(4.0f)), composerStartRestartGroup, 6);
                Composer composer3 = composerStartRestartGroup;
                TextKt.m3661TextNvy7gAk(ticketData.getVenue(), null, ColorKt.Color(4287466900L), null, TextUnitKt.getSp(13), null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer3, 24960, 0, 262122);
                composerStartRestartGroup = composer3;
            }
            composerStartRestartGroup.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.tickets.TicketsShareScreensKt$$ExternalSyntheticLambda73
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj3, Object obj4) {
                    return TicketsShareScreensKt.SharePreviewCard$lambda$36(ticketData, i, (Composer) obj3, ((Integer) obj4).intValue());
                }
            });
        }
    }

    private static final void ShareActionButton(final String str, final String str2, final Function2<? super Composer, ? super Integer, Unit> function2, final Function0<Unit> function0, Composer composer, final int i) {
        int i2;
        Composer composer2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1555916811);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ShareActionButton)N(title,subtitle,icon,onClick)423@15661L1506:TicketsShareScreens.kt#n9ob9m");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(str) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(str2) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function2) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function0) ? 2048 : 1024;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 1171) != 1170, i2 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1555916811, i2, -1, "com.example.tickets.ShareActionButton (TicketsShareScreens.kt:422)");
            }
            Modifier modifierM1425paddingVpY3zN4$default = PaddingKt.m1425paddingVpY3zN4$default(ClickableKt.m683clickableoSLSa3U$default(BorderKt.m659borderxT4_qwU(BackgroundKt.m648backgroundbw27NRU$default(ClipKt.clip(SizeKt.m1476height3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m8748constructorimpl(76.0f)), RoundedCornerShapeKt.m1756RoundedCornerShape0680j_4(Dp.m8748constructorimpl(18.0f))), ColorKt.Color(4279571736L), null, 2, null), Dp.m8748constructorimpl(1.0f), Color.m5837copywmQWz5c$default(Color.INSTANCE.m5875getWhite0d7_KjU(), 0.18f, 0.0f, 0.0f, 0.0f, 14, null), RoundedCornerShapeKt.m1756RoundedCornerShape0680j_4(Dp.m8748constructorimpl(18.0f))), false, null, null, null, function0, 15, null), Dp.m8748constructorimpl(16.0f), 0.0f, 2, null);
            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, composerStartRestartGroup, 48);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1425paddingVpY3zN4$default);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)410@16216L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM4937constructorimpl = Updater.m4937constructorimpl(composerStartRestartGroup);
            Updater.m4945setimpl(composerM4937constructorimpl, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m4945setimpl(composerM4937constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m4945setimpl(composerM4937constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m4943reconcileimpl(composerM4937constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m4945setimpl(composerM4937constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 152481229, "C438@16164L433,453@16607L29,455@16646L405,470@17061L100:TicketsShareScreens.kt#n9ob9m");
            Modifier modifierM659borderxT4_qwU = BorderKt.m659borderxT4_qwU(BackgroundKt.m648backgroundbw27NRU$default(ClipKt.clip(SizeKt.m1490size3ABfNKs(Modifier.INSTANCE, Dp.m8748constructorimpl(44.0f)), RoundedCornerShapeKt.m1756RoundedCornerShape0680j_4(Dp.m8748constructorimpl(13.0f))), Color.m5837copywmQWz5c$default(Color.INSTANCE.m5875getWhite0d7_KjU(), 0.08f, 0.0f, 0.0f, 0.0f, 14, null), null, 2, null), Dp.m8748constructorimpl(1.0f), Color.m5837copywmQWz5c$default(Color.INSTANCE.m5875getWhite0d7_KjU(), 0.13f, 0.0f, 0.0f, 0.0f, 14, null), RoundedCornerShapeKt.m1756RoundedCornerShape0680j_4(Dp.m8748constructorimpl(13.0f)));
            Alignment center = Alignment.INSTANCE.getCenter();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
            int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM659borderxT4_qwU);
            Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)410@16216L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor2);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM4937constructorimpl2 = Updater.m4937constructorimpl(composerStartRestartGroup);
            Updater.m4945setimpl(composerM4937constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m4945setimpl(composerM4937constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m4945setimpl(composerM4937constructorimpl2, Integer.valueOf(iHashCode2), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m4943reconcileimpl(composerM4937constructorimpl2, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m4945setimpl(composerM4937constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1238459182, "C450@16581L6:TicketsShareScreens.kt#n9ob9m");
            function2.invoke(composerStartRestartGroup, Integer.valueOf((i2 >> 6) & 14));
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            SpacerKt.Spacer(SizeKt.m1495width3ABfNKs(Modifier.INSTANCE, Dp.m8748constructorimpl(14.0f)), composerStartRestartGroup, 6);
            Modifier modifierWeight$default = RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
            int iHashCode3 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierWeight$default);
            Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)410@16216L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor3);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM4937constructorimpl3 = Updater.m4937constructorimpl(composerStartRestartGroup);
            Updater.m4945setimpl(composerM4937constructorimpl3, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m4945setimpl(composerM4937constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m4945setimpl(composerM4937constructorimpl3, Integer.valueOf(iHashCode3), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m4943reconcileimpl(composerM4937constructorimpl3, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m4945setimpl(composerM4937constructorimpl3, modifierMaterializeModifier3, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -513665550, "C456@16699L166,462@16878L29,463@16920L121:TicketsShareScreens.kt#n9ob9m");
            composer2 = composerStartRestartGroup;
            TextKt.m3661TextNvy7gAk(str, null, ColorKt.Color(4294046195L), null, TextUnitKt.getSp(16), null, FontWeight.INSTANCE.getMedium(), null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer2, (i2 & 14) | 1597824, 0, 262058);
            SpacerKt.Spacer(SizeKt.m1476height3ABfNKs(Modifier.INSTANCE, Dp.m8748constructorimpl(3.0f)), composer2, 6);
            TextKt.m3661TextNvy7gAk(str2, null, ColorKt.Color(4288059037L), null, TextUnitKt.getSp(12), null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer2, ((i2 >> 3) & 14) | 24960, 0, 262122);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            TextKt.m3661TextNvy7gAk("›", null, ColorKt.Color(4290361790L), null, TextUnitKt.getSp(25), null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer2, 24966, 0, 262122);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.tickets.TicketsShareScreensKt$$ExternalSyntheticLambda24
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TicketsShareScreensKt.ShareActionButton$lambda$40(str, str2, function2, function0, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX WARN: Code duplicated, block: B:30:0x0057  */
    /* JADX WARN: Code duplicated, block: B:31:0x0059  */
    /* JADX WARN: Code duplicated, block: B:34:0x0062 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:35:0x0064  */
    /* JADX WARN: Code duplicated, block: B:36:0x0069  */
    /* JADX WARN: Code duplicated, block: B:39:0x0070  */
    /* JADX WARN: Code duplicated, block: B:42:0x0119  */
    /* JADX WARN: Code duplicated, block: B:45:0x0125  */
    /* JADX WARN: Code duplicated, block: B:46:0x0129  */
    /* JADX WARN: Code duplicated, block: B:49:0x01cb  */
    /* JADX WARN: Code duplicated, block: B:50:0x01cf  */
    /* JADX WARN: Code duplicated, block: B:53:0x01db  */
    /* JADX WARN: Code duplicated, block: B:55:? A[RETURN, SYNTHETIC] */
    private static final void ShareOutlinedButton(final String str, final Function0<Unit> function0, Modifier modifier, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        boolean z;
        Composer composer2;
        final Modifier.Companion companion;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Function0<ComposeUiNode> constructor;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1052881990);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ShareOutlinedButton)N(text,onClick,modifier)484@17301L550:TicketsShareScreens.kt#n9ob9m");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(str) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function0) ? 32 : 16;
        }
        int i4 = i2 & 4;
        if (i4 == 0) {
            if ((i & 384) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            if ((i3 & 147) != 146) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                companion = modifier2;
            } else {
                if (i4 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1052881990, i3, -1, "com.example.tickets.ShareOutlinedButton (TicketsShareScreens.kt:483)");
                }
                Modifier modifierM683clickableoSLSa3U$default = ClickableKt.m683clickableoSLSa3U$default(BorderKt.m659borderxT4_qwU(BackgroundKt.m648backgroundbw27NRU$default(ClipKt.clip(SizeKt.m1476height3ABfNKs(companion, Dp.m8748constructorimpl(50.0f)), RoundedCornerShapeKt.m1756RoundedCornerShape0680j_4(Dp.m8748constructorimpl(16.0f))), ColorKt.Color(4280756010L), null, 2, null), Dp.m8748constructorimpl(1.0f), Color.m5837copywmQWz5c$default(Color.INSTANCE.m5875getWhite0d7_KjU(), 0.24f, 0.0f, 0.0f, 0.0f, 14, null), RoundedCornerShapeKt.m1756RoundedCornerShape0680j_4(Dp.m8748constructorimpl(16.0f))), false, null, null, null, function0, 15, null);
                Alignment center = Alignment.INSTANCE.getCenter();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
                int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM683clickableoSLSa3U$default);
                constructor = ComposeUiNode.INSTANCE.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)410@16216L9:Composables.kt#9igjgp");
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor);
                } else {
                    composerStartRestartGroup.useNode();
                }
                Composer composerM4937constructorimpl = Updater.m4937constructorimpl(composerStartRestartGroup);
                Updater.m4945setimpl(composerM4937constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m4945setimpl(composerM4937constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Updater.m4945setimpl(composerM4937constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                Updater.m4943reconcileimpl(composerM4937constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                Updater.m4945setimpl(composerM4937constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -482191266, "C497@17700L145:TicketsShareScreens.kt#n9ob9m");
                composer2 = composerStartRestartGroup;
                TextKt.m3661TextNvy7gAk(str, null, ColorKt.Color(4293980402L), null, TextUnitKt.getSp(15), null, FontWeight.INSTANCE.getMedium(), null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer2, (i3 & 14) | 1597824, 0, 262058);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.tickets.TicketsShareScreensKt$$ExternalSyntheticLambda91
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return TicketsShareScreensKt.ShareOutlinedButton$lambda$42(str, function0, companion, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 384;
        modifier2 = modifier;
        if ((i3 & 147) != 146) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            companion = modifier2;
        } else {
            if (i4 != 0) {
                companion = Modifier.INSTANCE;
            } else {
                companion = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1052881990, i3, -1, "com.example.tickets.ShareOutlinedButton (TicketsShareScreens.kt:483)");
            }
            Modifier modifierM683clickableoSLSa3U$default2 = ClickableKt.m683clickableoSLSa3U$default(BorderKt.m659borderxT4_qwU(BackgroundKt.m648backgroundbw27NRU$default(ClipKt.clip(SizeKt.m1476height3ABfNKs(companion, Dp.m8748constructorimpl(50.0f)), RoundedCornerShapeKt.m1756RoundedCornerShape0680j_4(Dp.m8748constructorimpl(16.0f))), ColorKt.Color(4280756010L), null, 2, null), Dp.m8748constructorimpl(1.0f), Color.m5837copywmQWz5c$default(Color.INSTANCE.m5875getWhite0d7_KjU(), 0.24f, 0.0f, 0.0f, 0.0f, 14, null), RoundedCornerShapeKt.m1756RoundedCornerShape0680j_4(Dp.m8748constructorimpl(16.0f))), false, null, null, null, function0, 15, null);
            Alignment center2 = Alignment.INSTANCE.getCenter();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(center2, false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
            int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM683clickableoSLSa3U$default2);
            constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)410@16216L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM4937constructorimpl2 = Updater.m4937constructorimpl(composerStartRestartGroup);
            Updater.m4945setimpl(composerM4937constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m4945setimpl(composerM4937constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m4945setimpl(composerM4937constructorimpl2, Integer.valueOf(iHashCode2), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m4943reconcileimpl(composerM4937constructorimpl2, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m4945setimpl(composerM4937constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -482191266, "C497@17700L145:TicketsShareScreens.kt#n9ob9m");
            composer2 = composerStartRestartGroup;
            TextKt.m3661TextNvy7gAk(str, null, ColorKt.Color(4293980402L), null, TextUnitKt.getSp(15), null, FontWeight.INSTANCE.getMedium(), null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer2, (i3 & 14) | 1597824, 0, 262058);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.tickets.TicketsShareScreensKt$$ExternalSyntheticLambda91
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TicketsShareScreensKt.ShareOutlinedButton$lambda$42(str, function0, companion, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ShareNfcTagIcon(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(1254551854);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ShareNfcTagIcon)514@18025L45,513@18000L194:TicketsShareScreens.kt#n9ob9m");
        if (!composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1254551854, i, -1, "com.example.tickets.ShareNfcTagIcon (TicketsShareScreens.kt:507)");
            }
            ImageKt.Image(PainterResources_androidKt.painterResource(R.drawable.ic_share_nfc, composerStartRestartGroup, 0), "NFC", SizeKt.m1490size3ABfNKs(Modifier.INSTANCE, Dp.m8748constructorimpl(27.0f)), (Alignment) null, ContentScale.INSTANCE.getFit(), 0.0f, (ColorFilter) null, composerStartRestartGroup, Painter.$stable | 25008, LocationRequestCompat.QUALITY_LOW_POWER);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.tickets.TicketsShareScreensKt$$ExternalSyntheticLambda76
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TicketsShareScreensKt.ShareNfcTagIcon$lambda$43(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ShareQrScanIcon(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(21944125);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ShareQrScanIcon)529@18387L2254,527@18333L2308:TicketsShareScreens.kt#n9ob9m");
        if (!composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(21944125, i, -1, "com.example.tickets.ShareQrScanIcon (TicketsShareScreens.kt:522)");
            }
            Modifier modifierM1490size3ABfNKs = SizeKt.m1490size3ABfNKs(Modifier.INSTANCE, Dp.m8748constructorimpl(27.0f));
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -386524053, "CC(remember):TicketsShareScreens.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: com.example.tickets.TicketsShareScreensKt$$ExternalSyntheticLambda83
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return TicketsShareScreensKt.ShareQrScanIcon$lambda$45$lambda$44((DrawScope) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            CanvasKt.Canvas(modifierM1490size3ABfNKs, (Function1) objRememberedValue, composerStartRestartGroup, 54);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.tickets.TicketsShareScreensKt$$ExternalSyntheticLambda84
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TicketsShareScreensKt.ShareQrScanIcon$lambda$46(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ShareReceiveIcon(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-2143582688);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ShareReceiveIcon)603@20760L805,603@20731L834:TicketsShareScreens.kt#n9ob9m");
        if (!composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2143582688, i, -1, "com.example.tickets.ShareReceiveIcon (TicketsShareScreens.kt:601)");
            }
            Modifier modifierM1490size3ABfNKs = SizeKt.m1490size3ABfNKs(Modifier.INSTANCE, Dp.m8748constructorimpl(25.0f));
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1601343397, "CC(remember):TicketsShareScreens.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: com.example.tickets.TicketsShareScreensKt$$ExternalSyntheticLambda81
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return TicketsShareScreensKt.ShareReceiveIcon$lambda$48$lambda$47((DrawScope) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            CanvasKt.Canvas(modifierM1490size3ABfNKs, (Function1) objRememberedValue, composerStartRestartGroup, 54);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.tickets.TicketsShareScreensKt$$ExternalSyntheticLambda82
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TicketsShareScreensKt.ShareReceiveIcon$lambda$49(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    static final Unit ShareReceiveIcon$lambda$48$lambda$47(DrawScope Canvas) {
        Intrinsics.checkNotNullParameter(Canvas, "$this$Canvas");
        long jColor = ColorKt.Color(4294046195L);
        float f = Canvas.mo803toPx0680j_4(Dp.m8748constructorimpl(2.2f));
        float f2 = Canvas.mo803toPx0680j_4(Dp.m8748constructorimpl(12.5f));
        long jM5559constructorimpl = Offset.m5559constructorimpl((((long) Float.floatToRawIntBits(Canvas.mo803toPx0680j_4(Dp.m8748constructorimpl(5.0f)))) & 4294967295L) | (Float.floatToRawIntBits(f2) << 32));
        float f3 = Canvas.mo803toPx0680j_4(Dp.m8748constructorimpl(12.5f));
        DrawScope.m6423drawLineNGM6Ib0$default(Canvas, jColor, jM5559constructorimpl, Offset.m5559constructorimpl((((long) Float.floatToRawIntBits(Canvas.mo803toPx0680j_4(Dp.m8748constructorimpl(20.0f)))) & 4294967295L) | (Float.floatToRawIntBits(f3) << 32)), f, StrokeCap.INSTANCE.m6236getRoundKaPHkGw(), null, 0.0f, null, 0, WindowSizeClass.HEIGHT_DP_MEDIUM_LOWER_BOUND, null);
        float f4 = Canvas.mo803toPx0680j_4(Dp.m8748constructorimpl(12.5f));
        long jM5559constructorimpl2 = Offset.m5559constructorimpl((((long) Float.floatToRawIntBits(Canvas.mo803toPx0680j_4(Dp.m8748constructorimpl(20.0f)))) & 4294967295L) | (Float.floatToRawIntBits(f4) << 32));
        float f5 = Canvas.mo803toPx0680j_4(Dp.m8748constructorimpl(7.5f));
        DrawScope.m6423drawLineNGM6Ib0$default(Canvas, jColor, jM5559constructorimpl2, Offset.m5559constructorimpl((((long) Float.floatToRawIntBits(Canvas.mo803toPx0680j_4(Dp.m8748constructorimpl(15.0f)))) & 4294967295L) | (Float.floatToRawIntBits(f5) << 32)), f, StrokeCap.INSTANCE.m6236getRoundKaPHkGw(), null, 0.0f, null, 0, WindowSizeClass.HEIGHT_DP_MEDIUM_LOWER_BOUND, null);
        float f6 = Canvas.mo803toPx0680j_4(Dp.m8748constructorimpl(12.5f));
        long jM5559constructorimpl3 = Offset.m5559constructorimpl((((long) Float.floatToRawIntBits(Canvas.mo803toPx0680j_4(Dp.m8748constructorimpl(20.0f)))) & 4294967295L) | (Float.floatToRawIntBits(f6) << 32));
        float f7 = Canvas.mo803toPx0680j_4(Dp.m8748constructorimpl(17.5f));
        DrawScope.m6423drawLineNGM6Ib0$default(Canvas, jColor, jM5559constructorimpl3, Offset.m5559constructorimpl((((long) Float.floatToRawIntBits(Canvas.mo803toPx0680j_4(Dp.m8748constructorimpl(15.0f)))) & 4294967295L) | (Float.floatToRawIntBits(f7) << 32)), f, StrokeCap.INSTANCE.m6236getRoundKaPHkGw(), null, 0.0f, null, 0, WindowSizeClass.HEIGHT_DP_MEDIUM_LOWER_BOUND, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ShareSendIcon(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(1569489223);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ShareSendIcon)633@21679L803,633@21650L832:TicketsShareScreens.kt#n9ob9m");
        if (!composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1569489223, i, -1, "com.example.tickets.ShareSendIcon (TicketsShareScreens.kt:631)");
            }
            Modifier modifierM1490size3ABfNKs = SizeKt.m1490size3ABfNKs(Modifier.INSTANCE, Dp.m8748constructorimpl(25.0f));
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 745626730, "CC(remember):TicketsShareScreens.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: com.example.tickets.TicketsShareScreensKt$$ExternalSyntheticLambda48
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return TicketsShareScreensKt.ShareSendIcon$lambda$51$lambda$50((DrawScope) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            CanvasKt.Canvas(modifierM1490size3ABfNKs, (Function1) objRememberedValue, composerStartRestartGroup, 54);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.tickets.TicketsShareScreensKt$$ExternalSyntheticLambda49
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TicketsShareScreensKt.ShareSendIcon$lambda$52(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    static final Unit ShareSendIcon$lambda$51$lambda$50(DrawScope Canvas) {
        Intrinsics.checkNotNullParameter(Canvas, "$this$Canvas");
        long jColor = ColorKt.Color(4294046195L);
        float f = Canvas.mo803toPx0680j_4(Dp.m8748constructorimpl(2.2f));
        float f2 = Canvas.mo803toPx0680j_4(Dp.m8748constructorimpl(12.5f));
        long jM5559constructorimpl = Offset.m5559constructorimpl((((long) Float.floatToRawIntBits(Canvas.mo803toPx0680j_4(Dp.m8748constructorimpl(20.0f)))) & 4294967295L) | (Float.floatToRawIntBits(f2) << 32));
        float f3 = Canvas.mo803toPx0680j_4(Dp.m8748constructorimpl(12.5f));
        DrawScope.m6423drawLineNGM6Ib0$default(Canvas, jColor, jM5559constructorimpl, Offset.m5559constructorimpl((((long) Float.floatToRawIntBits(Canvas.mo803toPx0680j_4(Dp.m8748constructorimpl(5.0f)))) & 4294967295L) | (Float.floatToRawIntBits(f3) << 32)), f, StrokeCap.INSTANCE.m6236getRoundKaPHkGw(), null, 0.0f, null, 0, WindowSizeClass.HEIGHT_DP_MEDIUM_LOWER_BOUND, null);
        float f4 = Canvas.mo803toPx0680j_4(Dp.m8748constructorimpl(12.5f));
        long jM5559constructorimpl2 = Offset.m5559constructorimpl((((long) Float.floatToRawIntBits(Canvas.mo803toPx0680j_4(Dp.m8748constructorimpl(5.0f)))) & 4294967295L) | (Float.floatToRawIntBits(f4) << 32));
        float f5 = Canvas.mo803toPx0680j_4(Dp.m8748constructorimpl(7.5f));
        DrawScope.m6423drawLineNGM6Ib0$default(Canvas, jColor, jM5559constructorimpl2, Offset.m5559constructorimpl((((long) Float.floatToRawIntBits(Canvas.mo803toPx0680j_4(Dp.m8748constructorimpl(10.0f)))) & 4294967295L) | (Float.floatToRawIntBits(f5) << 32)), f, StrokeCap.INSTANCE.m6236getRoundKaPHkGw(), null, 0.0f, null, 0, WindowSizeClass.HEIGHT_DP_MEDIUM_LOWER_BOUND, null);
        float f6 = Canvas.mo803toPx0680j_4(Dp.m8748constructorimpl(12.5f));
        long jM5559constructorimpl3 = Offset.m5559constructorimpl((((long) Float.floatToRawIntBits(Canvas.mo803toPx0680j_4(Dp.m8748constructorimpl(5.0f)))) & 4294967295L) | (Float.floatToRawIntBits(f6) << 32));
        float f7 = Canvas.mo803toPx0680j_4(Dp.m8748constructorimpl(17.5f));
        DrawScope.m6423drawLineNGM6Ib0$default(Canvas, jColor, jM5559constructorimpl3, Offset.m5559constructorimpl((((long) Float.floatToRawIntBits(Canvas.mo803toPx0680j_4(Dp.m8748constructorimpl(10.0f)))) & 4294967295L) | (Float.floatToRawIntBits(f7) << 32)), f, StrokeCap.INSTANCE.m6236getRoundKaPHkGw(), null, 0.0f, null, 0, WindowSizeClass.HEIGHT_DP_MEDIUM_LOWER_BOUND, null);
        return Unit.INSTANCE;
    }

    public static final void TicketTransferDirectionScreen(final Function0<Unit> onBack, final Function0<Unit> onSend, final Function0<Unit> onReceive, Composer composer, final int i) {
        int i2;
        Intrinsics.checkNotNullParameter(onBack, "onBack");
        Intrinsics.checkNotNullParameter(onSend, "onSend");
        Intrinsics.checkNotNullParameter(onReceive, "onReceive");
        Composer composerStartRestartGroup = composer.startRestartGroup(-330404593);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(TicketTransferDirectionScreen)N(onBack,onSend,onReceive)668@22675L1497,666@22624L1548:TicketsShareScreens.kt#n9ob9m");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(onBack) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(onSend) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(onReceive) ? 256 : 128;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 147) != 146, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-330404593, i2, -1, "com.example.tickets.TicketTransferDirectionScreen (TicketsShareScreens.kt:665)");
            }
            ShareFullScreenPage(onBack, ComposableLambdaKt.rememberComposableLambda(-2062944677, true, new Function3() { // from class: com.example.tickets.TicketsShareScreensKt$$ExternalSyntheticLambda67
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return TicketsShareScreensKt.TicketTransferDirectionScreen$lambda$54(onSend, onReceive, onBack, (Modifier) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, (i2 & 14) | 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.tickets.TicketsShareScreensKt$$ExternalSyntheticLambda68
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TicketsShareScreensKt.TicketTransferDirectionScreen$lambda$55(onBack, onSend, onReceive, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final void TicketReceiveMenuScreen(final boolean z, final Function0<Unit> onBack, final Function0<Unit> onNfc, final Function0<Unit> onQr, Composer composer, final int i) {
        int i2;
        Intrinsics.checkNotNullParameter(onBack, "onBack");
        Intrinsics.checkNotNullParameter(onNfc, "onNfc");
        Intrinsics.checkNotNullParameter(onQr, "onQr");
        Composer composerStartRestartGroup = composer.startRestartGroup(1508275813);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(TicketReceiveMenuScreen)N(nfcAvailable,onBack,onNfc,onQr)735@24380L1944,733@24329L1995:TicketsShareScreens.kt#n9ob9m");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(onBack) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(onNfc) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(onQr) ? 2048 : 1024;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 1171) != 1170, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1508275813, i2, -1, "com.example.tickets.TicketReceiveMenuScreen (TicketsShareScreens.kt:732)");
            }
            ShareFullScreenPage(onBack, ComposableLambdaKt.rememberComposableLambda(-1310401359, true, new Function3() { // from class: com.example.tickets.TicketsShareScreensKt$$ExternalSyntheticLambda25
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return TicketsShareScreensKt.TicketReceiveMenuScreen$lambda$57(z, onNfc, onQr, onBack, (Modifier) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i2 >> 3) & 14) | 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.tickets.TicketsShareScreensKt$$ExternalSyntheticLambda26
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TicketsShareScreensKt.TicketReceiveMenuScreen$lambda$58(z, onBack, onNfc, onQr, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX WARN: Code duplicated, block: B:100:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:23:0x0056  */
    /* JADX WARN: Code duplicated, block: B:25:0x005c  */
    /* JADX WARN: Code duplicated, block: B:26:0x005f  */
    /* JADX WARN: Code duplicated, block: B:30:0x0066  */
    /* JADX WARN: Code duplicated, block: B:32:0x006c  */
    /* JADX WARN: Code duplicated, block: B:33:0x006f  */
    /* JADX WARN: Code duplicated, block: B:37:0x0079  */
    /* JADX WARN: Code duplicated, block: B:38:0x007b  */
    /* JADX WARN: Code duplicated, block: B:41:0x0084 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:42:0x0086  */
    /* JADX WARN: Code duplicated, block: B:45:0x008d  */
    /* JADX WARN: Code duplicated, block: B:48:0x00bf  */
    /* JADX WARN: Code duplicated, block: B:51:0x00ed  */
    /* JADX WARN: Code duplicated, block: B:54:0x010d  */
    /* JADX WARN: Code duplicated, block: B:56:0x0111  */
    /* JADX WARN: Code duplicated, block: B:58:0x0119 A[LOOP:0: B:55:0x010f->B:58:0x0119, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:64:0x014b  */
    /* JADX WARN: Code duplicated, block: B:69:0x018e  */
    /* JADX WARN: Code duplicated, block: B:74:0x01c7  */
    /* JADX WARN: Code duplicated, block: B:77:0x01e4  */
    /* JADX WARN: Code duplicated, block: B:81:0x020c  */
    /* JADX WARN: Code duplicated, block: B:84:0x0233  */
    /* JADX WARN: Code duplicated, block: B:87:0x023c  */
    /* JADX WARN: Code duplicated, block: B:90:0x024e  */
    /* JADX WARN: Code duplicated, block: B:92:0x0282  */
    /* JADX WARN: Code duplicated, block: B:93:0x0286  */
    /* JADX WARN: Code duplicated, block: B:96:0x0291  */
    /* JADX WARN: Code duplicated, block: B:97:0x029f A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Code duplicated, block: B:98:0x011f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:99:0x011d A[SYNTHETIC] */
    public static final void NfcShareScreen(final List<TicketData> tickets, boolean z, final Function0<Unit> function0, final Function1<? super List<TicketData>, Unit> onAcceptedTickets, Composer composer, final int i, final int i2) {
        int i3;
        boolean z2;
        int i4;
        boolean z3;
        Composer composer2;
        final boolean z4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Function2<? super Composer, ? super Integer, Unit> function2;
        final Context context;
        Object objRememberedValue;
        final MutableState mutableState;
        final TicketShareManager.UiState uiState;
        final List<TicketData> pendingIncomingTickets;
        Object objRememberedValue2;
        final String[] strArr;
        Object objRememberedValue3;
        final MutableState mutableState2;
        Object objRememberedValue4;
        final ManagedActivityResultLauncher managedActivityResultLauncherRememberLauncherForActivityResult;
        boolean zChangedInstance;
        Object objRememberedValue5;
        boolean zChangedInstance2;
        TicketsShareScreensKt$NfcShareScreen$2$1 ticketsShareScreensKt$NfcShareScreen$2$1RememberedValue;
        boolean zChangedInstance3;
        Object objRememberedValue6;
        int length;
        int i5;
        boolean z5;
        int i6;
        int i7;
        final Function0<Unit> onBack = function0;
        Intrinsics.checkNotNullParameter(tickets, "tickets");
        Intrinsics.checkNotNullParameter(onBack, "onBack");
        Intrinsics.checkNotNullParameter(onAcceptedTickets, "onAcceptedTickets");
        Composer composerStartRestartGroup = composer.startRestartGroup(1338578672);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(NfcShareScreen)N(tickets,receiverModeInitially,onBack,onAcceptedTickets)812@26553L7,813@26585L50,817@26771L57,818@26855L172,825@27159L67,823@27057L169,829@27279L1193,829@27232L1240,867@28681L1699,867@28636L1744,913@30706L3337,911@30655L3388:TicketsShareScreens.kt#n9ob9m");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(tickets) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i8 = i2 & 2;
        if (i8 == 0) {
            if ((i & 48) == 0) {
                z2 = z;
                i3 |= composerStartRestartGroup.changed(z2) ? 32 : 16;
            }
            if ((i & 384) == 0) {
                if (composerStartRestartGroup.changedInstance(onBack)) {
                    i7 = 256;
                } else {
                    i7 = 128;
                }
                i3 |= i7;
            }
            if ((i & 3072) == 0) {
                if (composerStartRestartGroup.changedInstance(onAcceptedTickets)) {
                    i6 = 2048;
                } else {
                    i6 = 1024;
                }
                i3 |= i6;
            }
            i4 = i3;
            if ((i4 & 1171) != 1170) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i4 & 1)) {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
            } else {
                if (i8 != 0) {
                    z2 = false;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1338578672, i4, -1, "com.example.tickets.NfcShareScreen (TicketsShareScreens.kt:811)");
                }
                ProvidableCompositionLocal<Context> localContext = AndroidCompositionLocals_androidKt.getLocalContext();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume = composerStartRestartGroup.consume(localContext);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                context = (Context) objConsume;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2116076734, "CC(remember):TicketsShareScreens.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(z2), null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                mutableState = (MutableState) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                uiState = TicketShareManager.INSTANCE.getUiState();
                pendingIncomingTickets = TicketShareManager.INSTANCE.getPendingIncomingTickets();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2116070775, "CC(remember):TicketsShareScreens.kt#9igjgp");
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = TicketSharePermissions.INSTANCE.requiredPermissions();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                strArr = (String[]) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2116067972, "CC(remember):TicketsShareScreens.kt#9igjgp");
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    length = strArr.length;
                    i5 = 0;
                    while (true) {
                        if (i5 < length) {
                            z5 = true;
                            break;
                        } else {
                            if (ContextCompat.checkSelfPermission(context, strArr[i5]) == 0) {
                                z5 = false;
                                break;
                            }
                            i5++;
                        }
                    }
                    objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(z5), null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                mutableState2 = (MutableState) objRememberedValue3;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ActivityResultContracts.RequestMultiplePermissions requestMultiplePermissions = new ActivityResultContracts.RequestMultiplePermissions();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2116058349, "CC(remember):TicketsShareScreens.kt#9igjgp");
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue4 = new Function1() { // from class: com.example.tickets.TicketsShareScreensKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return TicketsShareScreensKt.NfcShareScreen$lambda$69$lambda$68(mutableState2, (Map) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                managedActivityResultLauncherRememberLauncherForActivityResult = ActivityResultRegistryKt.rememberLauncherForActivityResult(requestMultiplePermissions, (Function1) objRememberedValue4, composerStartRestartGroup, 48);
                Boolean boolValueOf = Boolean.valueOf(NfcShareScreen$lambda$60(mutableState));
                Boolean boolValueOf2 = Boolean.valueOf(NfcShareScreen$lambda$65(mutableState2));
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2116053383, "CC(remember):TicketsShareScreens.kt#9igjgp");
                zChangedInstance = composerStartRestartGroup.changedInstance(context) | composerStartRestartGroup.changedInstance(tickets);
                objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                if (!zChangedInstance || objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue5 = new Function1() { // from class: com.example.tickets.TicketsShareScreensKt$$ExternalSyntheticLambda7
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return TicketsShareScreensKt.NfcShareScreen$lambda$75$lambda$74(context, tickets, mutableState2, mutableState, (DisposableEffectScope) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                EffectsKt.DisposableEffect(boolValueOf, boolValueOf2, (Function1) objRememberedValue5, composerStartRestartGroup, 0);
                Boolean boolValueOf3 = Boolean.valueOf(NfcShareScreen$lambda$60(mutableState));
                Boolean boolValueOf4 = Boolean.valueOf(NfcShareScreen$lambda$65(mutableState2));
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2116008013, "CC(remember):TicketsShareScreens.kt#9igjgp");
                zChangedInstance2 = composerStartRestartGroup.changedInstance(context);
                ticketsShareScreensKt$NfcShareScreen$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (!zChangedInstance2 || ticketsShareScreensKt$NfcShareScreen$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                    ticketsShareScreensKt$NfcShareScreen$2$1RememberedValue = new TicketsShareScreensKt$NfcShareScreen$2$1(context, mutableState2, mutableState, null);
                    composerStartRestartGroup.updateRememberedValue(ticketsShareScreensKt$NfcShareScreen$2$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                EffectsKt.LaunchedEffect(boolValueOf3, boolValueOf4, (Function2) ticketsShareScreensKt$NfcShareScreen$2$1RememberedValue, composerStartRestartGroup, 0);
                if (!NfcShareScreen$lambda$65(mutableState2)) {
                    composerStartRestartGroup.startReplaceGroup(-1170071936);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "905@30539L50,902@30417L211");
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2115950206, "CC(remember):TicketsShareScreens.kt#9igjgp");
                    zChangedInstance3 = composerStartRestartGroup.changedInstance(managedActivityResultLauncherRememberLauncherForActivityResult) | composerStartRestartGroup.changedInstance(strArr);
                    objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                    if (!zChangedInstance3 || objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue6 = new Function0() { // from class: com.example.tickets.TicketsShareScreensKt$$ExternalSyntheticLambda8
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return TicketsShareScreensKt.NfcShareScreen$lambda$78$lambda$77(managedActivityResultLauncherRememberLauncherForActivityResult, strArr);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    PermissionPanel("需要附近设备权限", "NFC 页面会使用附近设备通道完成确认和票据传输。", (Function0) objRememberedValue6, function0, composerStartRestartGroup, ((i4 << 3) & 7168) | 54);
                    composerStartRestartGroup.endReplaceGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        return;
                    }
                    final boolean z6 = z2;
                    function2 = new Function2() { // from class: com.example.tickets.TicketsShareScreensKt$$ExternalSyntheticLambda9
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return TicketsShareScreensKt.NfcShareScreen$lambda$79(tickets, z6, function0, onAcceptedTickets, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    };
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.startReplaceGroup(-1200244174);
                    composer2.endReplaceGroup();
                    onBack = function0;
                    ShareFullScreenPage(onBack, ComposableLambdaKt.rememberComposableLambda(-789630404, true, new Function3() { // from class: com.example.tickets.TicketsShareScreensKt$$ExternalSyntheticLambda10
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return TicketsShareScreensKt.NfcShareScreen$lambda$90(uiState, pendingIncomingTickets, tickets, onAcceptedTickets, function0, mutableState, (Modifier) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composer2, 54), composer2, ((i4 >> 6) & 14) | 48);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                scopeUpdateScopeEndRestartGroup.updateScope(function2);
            }
            z4 = z2;
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                function2 = new Function2() { // from class: com.example.tickets.TicketsShareScreensKt$$ExternalSyntheticLambda11
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return TicketsShareScreensKt.NfcShareScreen$lambda$91(tickets, z4, onBack, onAcceptedTickets, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                };
                scopeUpdateScopeEndRestartGroup.updateScope(function2);
            }
        }
        i3 |= 48;
        z2 = z;
        if ((i & 384) == 0) {
            if (composerStartRestartGroup.changedInstance(onBack)) {
                i7 = 256;
            } else {
                i7 = 128;
            }
            i3 |= i7;
        }
        if ((i & 3072) == 0) {
            if (composerStartRestartGroup.changedInstance(onAcceptedTickets)) {
                i6 = 2048;
            } else {
                i6 = 1024;
            }
            i3 |= i6;
        }
        i4 = i3;
        if ((i4 & 1171) != 1170) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z3, i4 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (i8 != 0) {
                z2 = false;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1338578672, i4, -1, "com.example.tickets.NfcShareScreen (TicketsShareScreens.kt:811)");
            }
            ProvidableCompositionLocal<Context> localContext2 = AndroidCompositionLocals_androidKt.getLocalContext();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume2 = composerStartRestartGroup.consume(localContext2);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            context = (Context) objConsume2;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2116076734, "CC(remember):TicketsShareScreens.kt#9igjgp");
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(z2), null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            mutableState = (MutableState) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            uiState = TicketShareManager.INSTANCE.getUiState();
            pendingIncomingTickets = TicketShareManager.INSTANCE.getPendingIncomingTickets();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2116070775, "CC(remember):TicketsShareScreens.kt#9igjgp");
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = TicketSharePermissions.INSTANCE.requiredPermissions();
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            strArr = (String[]) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2116067972, "CC(remember):TicketsShareScreens.kt#9igjgp");
            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                length = strArr.length;
                i5 = 0;
                while (true) {
                    if (i5 < length) {
                        z5 = true;
                        break;
                    } else {
                        if (ContextCompat.checkSelfPermission(context, strArr[i5]) == 0) {
                            z5 = false;
                            break;
                        }
                        i5++;
                    }
                }
                objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(z5), null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            mutableState2 = (MutableState) objRememberedValue3;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ActivityResultContracts.RequestMultiplePermissions requestMultiplePermissions2 = new ActivityResultContracts.RequestMultiplePermissions();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2116058349, "CC(remember):TicketsShareScreens.kt#9igjgp");
            objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue4 = new Function1() { // from class: com.example.tickets.TicketsShareScreensKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return TicketsShareScreensKt.NfcShareScreen$lambda$69$lambda$68(mutableState2, (Map) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            managedActivityResultLauncherRememberLauncherForActivityResult = ActivityResultRegistryKt.rememberLauncherForActivityResult(requestMultiplePermissions2, (Function1) objRememberedValue4, composerStartRestartGroup, 48);
            Boolean boolValueOf5 = Boolean.valueOf(NfcShareScreen$lambda$60(mutableState));
            Boolean boolValueOf6 = Boolean.valueOf(NfcShareScreen$lambda$65(mutableState2));
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2116053383, "CC(remember):TicketsShareScreens.kt#9igjgp");
            zChangedInstance = composerStartRestartGroup.changedInstance(context) | composerStartRestartGroup.changedInstance(tickets);
            objRememberedValue5 = composerStartRestartGroup.rememberedValue();
            if (!zChangedInstance) {
                objRememberedValue5 = new Function1() { // from class: com.example.tickets.TicketsShareScreensKt$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return TicketsShareScreensKt.NfcShareScreen$lambda$75$lambda$74(context, tickets, mutableState2, mutableState, (DisposableEffectScope) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
            } else {
                objRememberedValue5 = new Function1() { // from class: com.example.tickets.TicketsShareScreensKt$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return TicketsShareScreensKt.NfcShareScreen$lambda$75$lambda$74(context, tickets, mutableState2, mutableState, (DisposableEffectScope) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.DisposableEffect(boolValueOf5, boolValueOf6, (Function1) objRememberedValue5, composerStartRestartGroup, 0);
            Boolean boolValueOf7 = Boolean.valueOf(NfcShareScreen$lambda$60(mutableState));
            Boolean boolValueOf8 = Boolean.valueOf(NfcShareScreen$lambda$65(mutableState2));
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2116008013, "CC(remember):TicketsShareScreens.kt#9igjgp");
            zChangedInstance2 = composerStartRestartGroup.changedInstance(context);
            ticketsShareScreensKt$NfcShareScreen$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (!zChangedInstance2) {
                ticketsShareScreensKt$NfcShareScreen$2$1RememberedValue = new TicketsShareScreensKt$NfcShareScreen$2$1(context, mutableState2, mutableState, null);
                composerStartRestartGroup.updateRememberedValue(ticketsShareScreensKt$NfcShareScreen$2$1RememberedValue);
            } else {
                ticketsShareScreensKt$NfcShareScreen$2$1RememberedValue = new TicketsShareScreensKt$NfcShareScreen$2$1(context, mutableState2, mutableState, null);
                composerStartRestartGroup.updateRememberedValue(ticketsShareScreensKt$NfcShareScreen$2$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.LaunchedEffect(boolValueOf7, boolValueOf8, (Function2) ticketsShareScreensKt$NfcShareScreen$2$1RememberedValue, composerStartRestartGroup, 0);
            if (!NfcShareScreen$lambda$65(mutableState2)) {
                composerStartRestartGroup.startReplaceGroup(-1170071936);
                ComposerKt.sourceInformation(composerStartRestartGroup, "905@30539L50,902@30417L211");
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2115950206, "CC(remember):TicketsShareScreens.kt#9igjgp");
                zChangedInstance3 = composerStartRestartGroup.changedInstance(managedActivityResultLauncherRememberLauncherForActivityResult) | composerStartRestartGroup.changedInstance(strArr);
                objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                if (!zChangedInstance3) {
                    objRememberedValue6 = new Function0() { // from class: com.example.tickets.TicketsShareScreensKt$$ExternalSyntheticLambda8
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return TicketsShareScreensKt.NfcShareScreen$lambda$78$lambda$77(managedActivityResultLauncherRememberLauncherForActivityResult, strArr);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                } else {
                    objRememberedValue6 = new Function0() { // from class: com.example.tickets.TicketsShareScreensKt$$ExternalSyntheticLambda8
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return TicketsShareScreensKt.NfcShareScreen$lambda$78$lambda$77(managedActivityResultLauncherRememberLauncherForActivityResult, strArr);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                PermissionPanel("需要附近设备权限", "NFC 页面会使用附近设备通道完成确认和票据传输。", (Function0) objRememberedValue6, function0, composerStartRestartGroup, ((i4 << 3) & 7168) | 54);
                composerStartRestartGroup.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    return;
                }
                final boolean z7 = z2;
                function2 = new Function2() { // from class: com.example.tickets.TicketsShareScreensKt$$ExternalSyntheticLambda9
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return TicketsShareScreensKt.NfcShareScreen$lambda$79(tickets, z7, function0, onAcceptedTickets, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                };
            } else {
                composer2 = composerStartRestartGroup;
                composer2.startReplaceGroup(-1200244174);
                composer2.endReplaceGroup();
                onBack = function0;
                ShareFullScreenPage(onBack, ComposableLambdaKt.rememberComposableLambda(-789630404, true, new Function3() { // from class: com.example.tickets.TicketsShareScreensKt$$ExternalSyntheticLambda10
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return TicketsShareScreensKt.NfcShareScreen$lambda$90(uiState, pendingIncomingTickets, tickets, onAcceptedTickets, function0, mutableState, (Modifier) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composer2, 54), composer2, ((i4 >> 6) & 14) | 48);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            scopeUpdateScopeEndRestartGroup.updateScope(function2);
        }
        z4 = z2;
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            function2 = new Function2() { // from class: com.example.tickets.TicketsShareScreensKt$$ExternalSyntheticLambda11
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TicketsShareScreensKt.NfcShareScreen$lambda$91(tickets, z4, onBack, onAcceptedTickets, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            };
            scopeUpdateScopeEndRestartGroup.updateScope(function2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean NfcShareScreen$lambda$60(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void NfcShareScreen$lambda$61(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean NfcShareScreen$lambda$65(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void NfcShareScreen$lambda$66(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    static final Unit NfcShareScreen$lambda$69$lambda$68(MutableState mutableState, Map result) {
        Intrinsics.checkNotNullParameter(result, "result");
        Collection collectionValues = result.values();
        boolean z = true;
        if (!(collectionValues instanceof Collection) || !collectionValues.isEmpty()) {
            Iterator it = collectionValues.iterator();
            while (it.hasNext()) {
                if (!((Boolean) it.next()).booleanValue()) {
                    z = false;
                    break;
                }
            }
        }
        NfcShareScreen$lambda$66(mutableState, z);
        return Unit.INSTANCE;
    }

    static final DisposableEffectResult NfcShareScreen$lambda$75$lambda$74(final Context context, List list, MutableState mutableState, MutableState mutableState2, DisposableEffectScope DisposableEffect) {
        Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
        if (NfcShareScreen$lambda$65(mutableState)) {
            if (NfcShareScreen$lambda$60(mutableState2)) {
                TicketShareManager.stop$default(TicketShareManager.INSTANCE, context, false, 2, null);
                NfcReaderBridge.INSTANCE.enable(context instanceof Activity ? (Activity) context : null, new Function2() { // from class: com.example.tickets.TicketsShareScreensKt$$ExternalSyntheticLambda16
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return TicketsShareScreensKt.NfcShareScreen$lambda$75$lambda$74$lambda$71(context, (String) obj, (String) obj2);
                    }
                });
                return new DisposableEffectResult() { // from class: com.example.tickets.TicketsShareScreensKt$NfcShareScreen$lambda$75$lambda$74$$inlined$onDispose$2
                    @Override // androidx.compose.runtime.DisposableEffectResult
                    public void dispose() {
                        NfcReaderBridge nfcReaderBridge = NfcReaderBridge.INSTANCE;
                        Context context2 = context;
                        nfcReaderBridge.disable(context2 instanceof Activity ? (Activity) context2 : null);
                        TicketNfcCompatibility ticketNfcCompatibility = TicketNfcCompatibility.INSTANCE;
                        Context context3 = context;
                        ticketNfcCompatibility.stopLegacySender(context3 instanceof Activity ? (Activity) context3 : null);
                        TicketShareManager.stop$default(TicketShareManager.INSTANCE, context, false, 2, null);
                    }
                };
            }
            if (!list.isEmpty()) {
                TicketShareManager.INSTANCE.startSender(context, (List<TicketData>) list, TicketShareManager.Transport.NFC);
            }
            return new DisposableEffectResult() { // from class: com.example.tickets.TicketsShareScreensKt$NfcShareScreen$lambda$75$lambda$74$$inlined$onDispose$3
                @Override // androidx.compose.runtime.DisposableEffectResult
                public void dispose() {
                    TicketNfcCompatibility ticketNfcCompatibility = TicketNfcCompatibility.INSTANCE;
                    Context context2 = context;
                    ticketNfcCompatibility.stopLegacySender(context2 instanceof Activity ? (Activity) context2 : null);
                    TicketShareManager.stop$default(TicketShareManager.INSTANCE, context, false, 2, null);
                }
            };
        }
        return new DisposableEffectResult() { // from class: com.example.tickets.TicketsShareScreensKt$NfcShareScreen$lambda$75$lambda$74$$inlined$onDispose$1
            @Override // androidx.compose.runtime.DisposableEffectResult
            public void dispose() {
            }
        };
    }

    static final Unit NfcShareScreen$lambda$75$lambda$74$lambda$71(Context context, String sessionId, String token) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(token, "token");
        TicketShareManager.INSTANCE.startReceiver(context, TicketShareManager.Transport.NFC, sessionId, token);
        return Unit.INSTANCE;
    }

    static final Unit NfcShareScreen$lambda$78$lambda$77(ManagedActivityResultLauncher managedActivityResultLauncher, String[] strArr) {
        managedActivityResultLauncher.launch(strArr);
        return Unit.INSTANCE;
    }

    static final Unit NfcShareScreen$lambda$90$lambda$89$lambda$81$lambda$80(MutableState mutableState) {
        if (!NfcShareScreen$lambda$60(mutableState) && TicketShareManager.INSTANCE.getUiState().getState() == TicketShareManager.State.SCANNED) {
            TicketShareManager.INSTANCE.confirmSenderShare();
        }
        return Unit.INSTANCE;
    }

    static final Unit NfcShareScreen$lambda$90$lambda$89$lambda$83$lambda$82(List list, Function1 function1) {
        if (!list.isEmpty()) {
            TicketShareManager.INSTANCE.acceptIncoming();
            function1.invoke(list);
        }
        return Unit.INSTANCE;
    }

    static final Unit NfcShareScreen$lambda$90$lambda$89$lambda$85$lambda$84(Function0 function0) {
        TicketShareManager.INSTANCE.rejectIncoming();
        function0.invoke();
        return Unit.INSTANCE;
    }

    static final Unit NfcShareScreen$lambda$90$lambda$89$lambda$88$lambda$87(MutableState mutableState) {
        NfcShareScreen$lambda$61(mutableState, !NfcShareScreen$lambda$60(mutableState));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:102:0x02b0  */
    /* JADX WARN: Code duplicated, block: B:104:0x02b6  */
    /* JADX WARN: Code duplicated, block: B:107:0x02c1  */
    /* JADX WARN: Code duplicated, block: B:108:0x02cf A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Code duplicated, block: B:109:0x0165 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:110:0x0163 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:111:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:23:0x0056  */
    /* JADX WARN: Code duplicated, block: B:25:0x005c  */
    /* JADX WARN: Code duplicated, block: B:26:0x005f  */
    /* JADX WARN: Code duplicated, block: B:30:0x0066  */
    /* JADX WARN: Code duplicated, block: B:32:0x006c  */
    /* JADX WARN: Code duplicated, block: B:33:0x006f  */
    /* JADX WARN: Code duplicated, block: B:37:0x007a  */
    /* JADX WARN: Code duplicated, block: B:38:0x007c  */
    /* JADX WARN: Code duplicated, block: B:41:0x0085 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:42:0x0087  */
    /* JADX WARN: Code duplicated, block: B:45:0x008e  */
    /* JADX WARN: Code duplicated, block: B:48:0x00c0  */
    /* JADX WARN: Code duplicated, block: B:51:0x00e2  */
    /* JADX WARN: Code duplicated, block: B:54:0x0112  */
    /* JADX WARN: Code duplicated, block: B:57:0x0130  */
    /* JADX WARN: Code duplicated, block: B:60:0x0150  */
    /* JADX WARN: Code duplicated, block: B:62:0x0154  */
    /* JADX WARN: Code duplicated, block: B:64:0x015e A[LOOP:0: B:61:0x0152->B:64:0x015e, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:68:0x0176  */
    /* JADX WARN: Code duplicated, block: B:71:0x0197  */
    /* JADX WARN: Code duplicated, block: B:74:0x01d2  */
    /* JADX WARN: Code duplicated, block: B:77:0x01dd  */
    /* JADX WARN: Code duplicated, block: B:81:0x01f8  */
    /* JADX WARN: Code duplicated, block: B:83:0x0218  */
    /* JADX WARN: Code duplicated, block: B:85:0x0220  */
    /* JADX WARN: Code duplicated, block: B:88:0x0247  */
    /* JADX WARN: Code duplicated, block: B:91:0x0250  */
    /* JADX WARN: Code duplicated, block: B:94:0x0263  */
    /* JADX WARN: Code duplicated, block: B:97:0x027a  */
    /* JADX WARN: Code duplicated, block: B:99:0x027d  */
    public static final void QrShareScreen(final List<TicketData> tickets, boolean z, final Function0<Unit> function0, final Function1<? super List<TicketData>, Unit> onAcceptedTickets, Composer composer, final int i, final int i2) {
        int i3;
        boolean z2;
        int i4;
        boolean z3;
        Composer composer2;
        final boolean z4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Function2<? super Composer, ? super Integer, Unit> function2;
        final Context context;
        Object objRememberedValue;
        final MutableState mutableState;
        Object objRememberedValue2;
        final MutableState mutableState2;
        final TicketShareManager.UiState uiState;
        final List<TicketData> pendingIncomingTickets;
        Object objRememberedValue3;
        String str;
        final MutableState mutableState3;
        Object objRememberedValue4;
        final String[] strArr;
        Object objRememberedValue5;
        String str2;
        final MutableState mutableState4;
        Object objRememberedValue6;
        final ManagedActivityResultLauncher managedActivityResultLauncherRememberLauncherForActivityResult;
        boolean zChangedInstance;
        Object objRememberedValue7;
        boolean z5;
        String strBuildQrPayload;
        boolean zChangedInstance2;
        Object objRememberedValue8;
        int length;
        int i5;
        boolean z6;
        int i6;
        int i7;
        final Function0<Unit> onBack = function0;
        Intrinsics.checkNotNullParameter(tickets, "tickets");
        Intrinsics.checkNotNullParameter(onBack, "onBack");
        Intrinsics.checkNotNullParameter(onAcceptedTickets, "onAcceptedTickets");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1097898722);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(QrShareScreen)N(tickets,receiverModeInitially,onBack,onAcceptedTickets)1002@34271L7,1003@34303L50,1004@34380L34,1007@34539L31,1009@34602L57,1010@34686L172,1017@34990L67,1015@34888L169,1021@35110L547,1021@35063L594,1055@36076L6275,1053@36025L6326:TicketsShareScreens.kt#n9ob9m");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(tickets) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i8 = i2 & 2;
        if (i8 == 0) {
            if ((i & 48) == 0) {
                z2 = z;
                i3 |= composerStartRestartGroup.changed(z2) ? 32 : 16;
            }
            if ((i & 384) == 0) {
                if (composerStartRestartGroup.changedInstance(onBack)) {
                    i7 = 256;
                } else {
                    i7 = 128;
                }
                i3 |= i7;
            }
            if ((i & 3072) == 0) {
                if (composerStartRestartGroup.changedInstance(onAcceptedTickets)) {
                    i6 = 2048;
                } else {
                    i6 = 1024;
                }
                i3 |= i6;
            }
            i4 = i3;
            if ((i4 & 1171) != 1170) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i4 & 1)) {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                z4 = z2;
            } else {
                if (i8 != 0) {
                    z2 = false;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1097898722, i4, -1, "com.example.tickets.QrShareScreen (TicketsShareScreens.kt:1001)");
                }
                ProvidableCompositionLocal<Context> localContext = AndroidCompositionLocals_androidKt.getLocalContext();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume = composerStartRestartGroup.consume(localContext);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                context = (Context) objConsume;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1481291216, "CC(remember):TicketsShareScreens.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(z2), null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                mutableState = (MutableState) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1481293664, "CC(remember):TicketsShareScreens.kt#9igjgp");
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                mutableState2 = (MutableState) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                uiState = TicketShareManager.INSTANCE.getUiState();
                pendingIncomingTickets = TicketShareManager.INSTANCE.getPendingIncomingTickets();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1481298749, "CC(remember):TicketsShareScreens.kt#9igjgp");
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                str = "";
                if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("", null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                mutableState3 = (MutableState) objRememberedValue3;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1481300791, "CC(remember):TicketsShareScreens.kt#9igjgp");
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue4 = TicketSharePermissions.INSTANCE.requiredPermissions();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                strArr = (String[]) objRememberedValue4;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1481303594, "CC(remember):TicketsShareScreens.kt#9igjgp");
                objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                    length = strArr.length;
                    i5 = 0;
                    while (true) {
                        if (i5 < length) {
                            str2 = str;
                            z6 = true;
                            break;
                        }
                        str2 = str;
                        if (ContextCompat.checkSelfPermission(context, strArr[i5]) == 0) {
                            z6 = false;
                            break;
                        } else {
                            i5++;
                            str = str2;
                        }
                    }
                    objRememberedValue5 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(z6), null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                } else {
                    str2 = "";
                }
                mutableState4 = (MutableState) objRememberedValue5;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ActivityResultContracts.RequestMultiplePermissions requestMultiplePermissions = new ActivityResultContracts.RequestMultiplePermissions();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1481313217, "CC(remember):TicketsShareScreens.kt#9igjgp");
                objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue6 = new Function1() { // from class: com.example.tickets.TicketsShareScreensKt$$ExternalSyntheticLambda51
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return TicketsShareScreensKt.QrShareScreen$lambda$106$lambda$105(mutableState4, (Map) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                managedActivityResultLauncherRememberLauncherForActivityResult = ActivityResultRegistryKt.rememberLauncherForActivityResult(requestMultiplePermissions, (Function1) objRememberedValue6, composerStartRestartGroup, 48);
                Boolean boolValueOf = Boolean.valueOf(QrShareScreen$lambda$93(mutableState));
                Boolean boolValueOf2 = Boolean.valueOf(QrShareScreen$lambda$102(mutableState4));
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1481317537, "CC(remember):TicketsShareScreens.kt#9igjgp");
                zChangedInstance = composerStartRestartGroup.changedInstance(context) | composerStartRestartGroup.changedInstance(tickets);
                objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                if (!zChangedInstance) {
                    z5 = z2;
                    if (objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    EffectsKt.DisposableEffect(boolValueOf, boolValueOf2, (Function1) objRememberedValue7, composerStartRestartGroup, 0);
                    if (!QrShareScreen$lambda$102(mutableState4)) {
                        composerStartRestartGroup.startReplaceGroup(-1323236561);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "1045@35819L50,1042@35694L214");
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1481339728, "CC(remember):TicketsShareScreens.kt#9igjgp");
                        zChangedInstance2 = composerStartRestartGroup.changedInstance(managedActivityResultLauncherRememberLauncherForActivityResult) | composerStartRestartGroup.changedInstance(strArr);
                        objRememberedValue8 = composerStartRestartGroup.rememberedValue();
                        if (!zChangedInstance2 || objRememberedValue8 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue8 = new Function0() { // from class: com.example.tickets.TicketsShareScreensKt$$ExternalSyntheticLambda53
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return TicketsShareScreensKt.QrShareScreen$lambda$113$lambda$112(managedActivityResultLauncherRememberLauncherForActivityResult, strArr);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        PermissionPanel("需要附近设备权限", "二维码分享使用附近设备建立双向确认连接，不要求双方联网。", (Function0) objRememberedValue8, function0, composerStartRestartGroup, ((i4 << 3) & 7168) | 54);
                        composerStartRestartGroup.endReplaceGroup();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            return;
                        }
                        final boolean z7 = z5;
                        function2 = new Function2() { // from class: com.example.tickets.TicketsShareScreensKt$$ExternalSyntheticLambda54
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return TicketsShareScreensKt.QrShareScreen$lambda$114(tickets, z7, function0, onAcceptedTickets, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        };
                    } else {
                        composer2 = composerStartRestartGroup;
                        composer2.startReplaceGroup(-1358643676);
                        composer2.endReplaceGroup();
                        strBuildQrPayload = TicketShareManager.INSTANCE.buildQrPayload();
                        if (QrShareScreen$lambda$93(mutableState)) {
                            strBuildQrPayload = null;
                        }
                        if (strBuildQrPayload == null) {
                            strBuildQrPayload = str2;
                        }
                        mutableState3.setValue(strBuildQrPayload);
                        onBack = function0;
                        ShareFullScreenPage(onBack, ComposableLambdaKt.rememberComposableLambda(634564690, true, new Function3() { // from class: com.example.tickets.TicketsShareScreensKt$$ExternalSyntheticLambda56
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return TicketsShareScreensKt.QrShareScreen$lambda$140(uiState, tickets, mutableState3, pendingIncomingTickets, context, function0, mutableState, onAcceptedTickets, mutableState2, (Modifier) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composer2, 54), composer2, ((i4 >> 6) & 14) | 48);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        z4 = z5;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(function2);
                }
                z5 = z2;
                objRememberedValue7 = new Function1() { // from class: com.example.tickets.TicketsShareScreensKt$$ExternalSyntheticLambda52
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return TicketsShareScreensKt.QrShareScreen$lambda$111$lambda$110(context, tickets, mutableState4, mutableState, (DisposableEffectScope) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                EffectsKt.DisposableEffect(boolValueOf, boolValueOf2, (Function1) objRememberedValue7, composerStartRestartGroup, 0);
                if (!QrShareScreen$lambda$102(mutableState4)) {
                    composerStartRestartGroup.startReplaceGroup(-1323236561);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "1045@35819L50,1042@35694L214");
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1481339728, "CC(remember):TicketsShareScreens.kt#9igjgp");
                    zChangedInstance2 = composerStartRestartGroup.changedInstance(managedActivityResultLauncherRememberLauncherForActivityResult) | composerStartRestartGroup.changedInstance(strArr);
                    objRememberedValue8 = composerStartRestartGroup.rememberedValue();
                    if (!zChangedInstance2) {
                        objRememberedValue8 = new Function0() { // from class: com.example.tickets.TicketsShareScreensKt$$ExternalSyntheticLambda53
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return TicketsShareScreensKt.QrShareScreen$lambda$113$lambda$112(managedActivityResultLauncherRememberLauncherForActivityResult, strArr);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                    } else {
                        objRememberedValue8 = new Function0() { // from class: com.example.tickets.TicketsShareScreensKt$$ExternalSyntheticLambda53
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return TicketsShareScreensKt.QrShareScreen$lambda$113$lambda$112(managedActivityResultLauncherRememberLauncherForActivityResult, strArr);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    PermissionPanel("需要附近设备权限", "二维码分享使用附近设备建立双向确认连接，不要求双方联网。", (Function0) objRememberedValue8, function0, composerStartRestartGroup, ((i4 << 3) & 7168) | 54);
                    composerStartRestartGroup.endReplaceGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        return;
                    }
                    final boolean z8 = z5;
                    function2 = new Function2() { // from class: com.example.tickets.TicketsShareScreensKt$$ExternalSyntheticLambda54
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return TicketsShareScreensKt.QrShareScreen$lambda$114(tickets, z8, function0, onAcceptedTickets, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    };
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.startReplaceGroup(-1358643676);
                    composer2.endReplaceGroup();
                    strBuildQrPayload = TicketShareManager.INSTANCE.buildQrPayload();
                    if (QrShareScreen$lambda$93(mutableState)) {
                        strBuildQrPayload = null;
                    }
                    if (strBuildQrPayload == null) {
                        strBuildQrPayload = str2;
                    }
                    mutableState3.setValue(strBuildQrPayload);
                    onBack = function0;
                    ShareFullScreenPage(onBack, ComposableLambdaKt.rememberComposableLambda(634564690, true, new Function3() { // from class: com.example.tickets.TicketsShareScreensKt$$ExternalSyntheticLambda56
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return TicketsShareScreensKt.QrShareScreen$lambda$140(uiState, tickets, mutableState3, pendingIncomingTickets, context, function0, mutableState, onAcceptedTickets, mutableState2, (Modifier) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composer2, 54), composer2, ((i4 >> 6) & 14) | 48);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z4 = z5;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(function2);
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                function2 = new Function2() { // from class: com.example.tickets.TicketsShareScreensKt$$ExternalSyntheticLambda57
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return TicketsShareScreensKt.QrShareScreen$lambda$141(tickets, z4, onBack, onAcceptedTickets, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                };
                scopeUpdateScopeEndRestartGroup.updateScope(function2);
            }
        }
        i3 |= 48;
        z2 = z;
        if ((i & 384) == 0) {
            if (composerStartRestartGroup.changedInstance(onBack)) {
                i7 = 256;
            } else {
                i7 = 128;
            }
            i3 |= i7;
        }
        if ((i & 3072) == 0) {
            if (composerStartRestartGroup.changedInstance(onAcceptedTickets)) {
                i6 = 2048;
            } else {
                i6 = 1024;
            }
            i3 |= i6;
        }
        i4 = i3;
        if ((i4 & 1171) != 1170) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z3, i4 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            z4 = z2;
        } else {
            if (i8 != 0) {
                z2 = false;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1097898722, i4, -1, "com.example.tickets.QrShareScreen (TicketsShareScreens.kt:1001)");
            }
            ProvidableCompositionLocal<Context> localContext2 = AndroidCompositionLocals_androidKt.getLocalContext();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume2 = composerStartRestartGroup.consume(localContext2);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            context = (Context) objConsume2;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1481291216, "CC(remember):TicketsShareScreens.kt#9igjgp");
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(z2), null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            mutableState = (MutableState) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1481293664, "CC(remember):TicketsShareScreens.kt#9igjgp");
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            mutableState2 = (MutableState) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            uiState = TicketShareManager.INSTANCE.getUiState();
            pendingIncomingTickets = TicketShareManager.INSTANCE.getPendingIncomingTickets();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1481298749, "CC(remember):TicketsShareScreens.kt#9igjgp");
            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            str = "";
            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("", null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            mutableState3 = (MutableState) objRememberedValue3;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1481300791, "CC(remember):TicketsShareScreens.kt#9igjgp");
            objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue4 = TicketSharePermissions.INSTANCE.requiredPermissions();
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            strArr = (String[]) objRememberedValue4;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1481303594, "CC(remember):TicketsShareScreens.kt#9igjgp");
            objRememberedValue5 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                length = strArr.length;
                i5 = 0;
                while (true) {
                    if (i5 < length) {
                        str2 = str;
                        z6 = true;
                        break;
                    }
                    str2 = str;
                    if (ContextCompat.checkSelfPermission(context, strArr[i5]) == 0) {
                        z6 = false;
                        break;
                    } else {
                        i5++;
                        str = str2;
                    }
                }
                objRememberedValue5 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(z6), null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
            } else {
                str2 = "";
            }
            mutableState4 = (MutableState) objRememberedValue5;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ActivityResultContracts.RequestMultiplePermissions requestMultiplePermissions2 = new ActivityResultContracts.RequestMultiplePermissions();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1481313217, "CC(remember):TicketsShareScreens.kt#9igjgp");
            objRememberedValue6 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue6 = new Function1() { // from class: com.example.tickets.TicketsShareScreensKt$$ExternalSyntheticLambda51
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return TicketsShareScreensKt.QrShareScreen$lambda$106$lambda$105(mutableState4, (Map) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            managedActivityResultLauncherRememberLauncherForActivityResult = ActivityResultRegistryKt.rememberLauncherForActivityResult(requestMultiplePermissions2, (Function1) objRememberedValue6, composerStartRestartGroup, 48);
            Boolean boolValueOf3 = Boolean.valueOf(QrShareScreen$lambda$93(mutableState));
            Boolean boolValueOf4 = Boolean.valueOf(QrShareScreen$lambda$102(mutableState4));
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1481317537, "CC(remember):TicketsShareScreens.kt#9igjgp");
            zChangedInstance = composerStartRestartGroup.changedInstance(context) | composerStartRestartGroup.changedInstance(tickets);
            objRememberedValue7 = composerStartRestartGroup.rememberedValue();
            if (!zChangedInstance) {
                z5 = z2;
                if (objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                EffectsKt.DisposableEffect(boolValueOf3, boolValueOf4, (Function1) objRememberedValue7, composerStartRestartGroup, 0);
                if (!QrShareScreen$lambda$102(mutableState4)) {
                    composerStartRestartGroup.startReplaceGroup(-1323236561);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "1045@35819L50,1042@35694L214");
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1481339728, "CC(remember):TicketsShareScreens.kt#9igjgp");
                    zChangedInstance2 = composerStartRestartGroup.changedInstance(managedActivityResultLauncherRememberLauncherForActivityResult) | composerStartRestartGroup.changedInstance(strArr);
                    objRememberedValue8 = composerStartRestartGroup.rememberedValue();
                    if (!zChangedInstance2) {
                        objRememberedValue8 = new Function0() { // from class: com.example.tickets.TicketsShareScreensKt$$ExternalSyntheticLambda53
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return TicketsShareScreensKt.QrShareScreen$lambda$113$lambda$112(managedActivityResultLauncherRememberLauncherForActivityResult, strArr);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                    } else {
                        objRememberedValue8 = new Function0() { // from class: com.example.tickets.TicketsShareScreensKt$$ExternalSyntheticLambda53
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return TicketsShareScreensKt.QrShareScreen$lambda$113$lambda$112(managedActivityResultLauncherRememberLauncherForActivityResult, strArr);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    PermissionPanel("需要附近设备权限", "二维码分享使用附近设备建立双向确认连接，不要求双方联网。", (Function0) objRememberedValue8, function0, composerStartRestartGroup, ((i4 << 3) & 7168) | 54);
                    composerStartRestartGroup.endReplaceGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        return;
                    }
                    final boolean z9 = z5;
                    function2 = new Function2() { // from class: com.example.tickets.TicketsShareScreensKt$$ExternalSyntheticLambda54
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return TicketsShareScreensKt.QrShareScreen$lambda$114(tickets, z9, function0, onAcceptedTickets, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    };
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.startReplaceGroup(-1358643676);
                    composer2.endReplaceGroup();
                    strBuildQrPayload = TicketShareManager.INSTANCE.buildQrPayload();
                    if (QrShareScreen$lambda$93(mutableState)) {
                        strBuildQrPayload = null;
                    }
                    if (strBuildQrPayload == null) {
                        strBuildQrPayload = str2;
                    }
                    mutableState3.setValue(strBuildQrPayload);
                    onBack = function0;
                    ShareFullScreenPage(onBack, ComposableLambdaKt.rememberComposableLambda(634564690, true, new Function3() { // from class: com.example.tickets.TicketsShareScreensKt$$ExternalSyntheticLambda56
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return TicketsShareScreensKt.QrShareScreen$lambda$140(uiState, tickets, mutableState3, pendingIncomingTickets, context, function0, mutableState, onAcceptedTickets, mutableState2, (Modifier) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composer2, 54), composer2, ((i4 >> 6) & 14) | 48);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z4 = z5;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(function2);
            }
            z5 = z2;
            objRememberedValue7 = new Function1() { // from class: com.example.tickets.TicketsShareScreensKt$$ExternalSyntheticLambda52
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return TicketsShareScreensKt.QrShareScreen$lambda$111$lambda$110(context, tickets, mutableState4, mutableState, (DisposableEffectScope) obj);
                }
            };
            composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.DisposableEffect(boolValueOf3, boolValueOf4, (Function1) objRememberedValue7, composerStartRestartGroup, 0);
            if (!QrShareScreen$lambda$102(mutableState4)) {
                composerStartRestartGroup.startReplaceGroup(-1323236561);
                ComposerKt.sourceInformation(composerStartRestartGroup, "1045@35819L50,1042@35694L214");
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1481339728, "CC(remember):TicketsShareScreens.kt#9igjgp");
                zChangedInstance2 = composerStartRestartGroup.changedInstance(managedActivityResultLauncherRememberLauncherForActivityResult) | composerStartRestartGroup.changedInstance(strArr);
                objRememberedValue8 = composerStartRestartGroup.rememberedValue();
                if (!zChangedInstance2) {
                    objRememberedValue8 = new Function0() { // from class: com.example.tickets.TicketsShareScreensKt$$ExternalSyntheticLambda53
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return TicketsShareScreensKt.QrShareScreen$lambda$113$lambda$112(managedActivityResultLauncherRememberLauncherForActivityResult, strArr);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                } else {
                    objRememberedValue8 = new Function0() { // from class: com.example.tickets.TicketsShareScreensKt$$ExternalSyntheticLambda53
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return TicketsShareScreensKt.QrShareScreen$lambda$113$lambda$112(managedActivityResultLauncherRememberLauncherForActivityResult, strArr);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                PermissionPanel("需要附近设备权限", "二维码分享使用附近设备建立双向确认连接，不要求双方联网。", (Function0) objRememberedValue8, function0, composerStartRestartGroup, ((i4 << 3) & 7168) | 54);
                composerStartRestartGroup.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    return;
                }
                final boolean z10 = z5;
                function2 = new Function2() { // from class: com.example.tickets.TicketsShareScreensKt$$ExternalSyntheticLambda54
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return TicketsShareScreensKt.QrShareScreen$lambda$114(tickets, z10, function0, onAcceptedTickets, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                };
            } else {
                composer2 = composerStartRestartGroup;
                composer2.startReplaceGroup(-1358643676);
                composer2.endReplaceGroup();
                strBuildQrPayload = TicketShareManager.INSTANCE.buildQrPayload();
                if (QrShareScreen$lambda$93(mutableState)) {
                    strBuildQrPayload = null;
                }
                if (strBuildQrPayload == null) {
                    strBuildQrPayload = str2;
                }
                mutableState3.setValue(strBuildQrPayload);
                onBack = function0;
                ShareFullScreenPage(onBack, ComposableLambdaKt.rememberComposableLambda(634564690, true, new Function3() { // from class: com.example.tickets.TicketsShareScreensKt$$ExternalSyntheticLambda56
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return TicketsShareScreensKt.QrShareScreen$lambda$140(uiState, tickets, mutableState3, pendingIncomingTickets, context, function0, mutableState, onAcceptedTickets, mutableState2, (Modifier) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composer2, 54), composer2, ((i4 >> 6) & 14) | 48);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z4 = z5;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(function2);
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            function2 = new Function2() { // from class: com.example.tickets.TicketsShareScreensKt$$ExternalSyntheticLambda57
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TicketsShareScreensKt.QrShareScreen$lambda$141(tickets, z4, onBack, onAcceptedTickets, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            };
            scopeUpdateScopeEndRestartGroup.updateScope(function2);
        }
    }

    private static final boolean QrShareScreen$lambda$93(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void QrShareScreen$lambda$94(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final boolean QrShareScreen$lambda$96(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void QrShareScreen$lambda$97(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final boolean QrShareScreen$lambda$102(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void QrShareScreen$lambda$103(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    static final Unit QrShareScreen$lambda$106$lambda$105(MutableState mutableState, Map result) {
        Intrinsics.checkNotNullParameter(result, "result");
        Collection collectionValues = result.values();
        boolean z = true;
        if (!(collectionValues instanceof Collection) || !collectionValues.isEmpty()) {
            Iterator it = collectionValues.iterator();
            while (it.hasNext()) {
                if (!((Boolean) it.next()).booleanValue()) {
                    z = false;
                    break;
                }
            }
        }
        QrShareScreen$lambda$103(mutableState, z);
        return Unit.INSTANCE;
    }

    static final DisposableEffectResult QrShareScreen$lambda$111$lambda$110(final Context context, List list, MutableState mutableState, MutableState mutableState2, DisposableEffectScope DisposableEffect) {
        Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
        if (QrShareScreen$lambda$102(mutableState)) {
            if (QrShareScreen$lambda$93(mutableState2)) {
                TicketShareManager.stop$default(TicketShareManager.INSTANCE, context, false, 2, null);
                return new DisposableEffectResult() { // from class: com.example.tickets.TicketsShareScreensKt$QrShareScreen$lambda$111$lambda$110$$inlined$onDispose$2
                    @Override // androidx.compose.runtime.DisposableEffectResult
                    public void dispose() {
                        TicketShareManager.stop$default(TicketShareManager.INSTANCE, context, false, 2, null);
                    }
                };
            }
            if (!list.isEmpty()) {
                TicketShareManager.INSTANCE.startSender(context, (List<TicketData>) list, TicketShareManager.Transport.QR);
            }
            return new DisposableEffectResult() { // from class: com.example.tickets.TicketsShareScreensKt$QrShareScreen$lambda$111$lambda$110$$inlined$onDispose$3
                @Override // androidx.compose.runtime.DisposableEffectResult
                public void dispose() {
                    TicketShareManager.stop$default(TicketShareManager.INSTANCE, context, false, 2, null);
                }
            };
        }
        return new DisposableEffectResult() { // from class: com.example.tickets.TicketsShareScreensKt$QrShareScreen$lambda$111$lambda$110$$inlined$onDispose$1
            @Override // androidx.compose.runtime.DisposableEffectResult
            public void dispose() {
            }
        };
    }

    static final Unit QrShareScreen$lambda$113$lambda$112(ManagedActivityResultLauncher managedActivityResultLauncher, String[] strArr) {
        managedActivityResultLauncher.launch(strArr);
        return Unit.INSTANCE;
    }

    static final Unit QrShareScreen$lambda$140$lambda$139$lambda$120$lambda$117$lambda$116() {
        TicketShareManager.INSTANCE.confirmSenderShare();
        return Unit.INSTANCE;
    }

    static final Unit QrShareScreen$lambda$140$lambda$139$lambda$120$lambda$119$lambda$118() {
        TicketShareManager.INSTANCE.rejectSenderShare();
        return Unit.INSTANCE;
    }

    static final Unit QrShareScreen$lambda$140$lambda$139$lambda$127$lambda$124$lambda$123(Function1 function1, List list) {
        TicketShareManager.INSTANCE.acceptIncoming();
        function1.invoke(list);
        return Unit.INSTANCE;
    }

    static final Unit QrShareScreen$lambda$140$lambda$139$lambda$127$lambda$126$lambda$125(Function0 function0) {
        TicketShareManager.INSTANCE.rejectIncoming();
        function0.invoke();
        return Unit.INSTANCE;
    }

    static final Unit QrShareScreen$lambda$140$lambda$139$lambda$129$lambda$128(Context context, MutableState mutableState, String payload) {
        Intrinsics.checkNotNullParameter(payload, "payload");
        QrShareScreen$lambda$97(mutableState, false);
        Pair<String, String> qrPayload = TicketShareManager.INSTANCE.parseQrPayload(payload);
        if (qrPayload == null) {
            TicketShareManager.stop$default(TicketShareManager.INSTANCE, context, false, 2, null);
        } else {
            TicketShareManager.INSTANCE.startReceiver(context, TicketShareManager.Transport.QR, qrPayload.getFirst(), qrPayload.getSecond());
        }
        return Unit.INSTANCE;
    }

    static final Unit QrShareScreen$lambda$140$lambda$139$lambda$131$lambda$130(MutableState mutableState) {
        QrShareScreen$lambda$97(mutableState, false);
        return Unit.INSTANCE;
    }

    static final Unit QrShareScreen$lambda$140$lambda$139$lambda$136$lambda$135$lambda$134(MutableState mutableState) {
        QrShareScreen$lambda$97(mutableState, true);
        return Unit.INSTANCE;
    }

    static final Unit QrShareScreen$lambda$140$lambda$139$lambda$138$lambda$137(MutableState mutableState) {
        QrShareScreen$lambda$94(mutableState, !QrShareScreen$lambda$93(mutableState));
        return Unit.INSTANCE;
    }

    private static final void SenderConfirmationCard(final List<TicketData> list, final Function0<Unit> function0, final Function0<Unit> function1, Composer composer, final int i) {
        int i2;
        Composer composer2;
        String str;
        Composer composerStartRestartGroup = composer.startRestartGroup(752046823);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(SenderConfirmationCard)N(tickets,onConfirm,onCancel)1201@42480L1191:TicketsShareScreens.kt#n9ob9m");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(list) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function0) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function1) ? 256 : 128;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 147) != 146, i2 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(752046823, i2, -1, "com.example.tickets.SenderConfirmationCard (TicketsShareScreens.kt:1200)");
            }
            Modifier modifierM1423padding3ABfNKs = PaddingKt.m1423padding3ABfNKs(BorderKt.m659borderxT4_qwU(BackgroundKt.m647backgroundbw27NRU(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), ColorKt.Color(4279571736L), RoundedCornerShapeKt.m1756RoundedCornerShape0680j_4(Dp.m8748constructorimpl(20.0f))), Dp.m8748constructorimpl(1.0f), Color.m5837copywmQWz5c$default(Color.INSTANCE.m5875getWhite0d7_KjU(), 0.08f, 0.0f, 0.0f, 0.0f, 14, null), RoundedCornerShapeKt.m1756RoundedCornerShape0680j_4(Dp.m8748constructorimpl(20.0f))), Dp.m8748constructorimpl(18.0f));
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1423padding3ABfNKs);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)410@16216L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM4937constructorimpl = Updater.m4937constructorimpl(composerStartRestartGroup);
            Updater.m4945setimpl(composerM4937constructorimpl, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m4945setimpl(composerM4937constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m4945setimpl(composerM4937constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m4943reconcileimpl(composerM4937constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m4945setimpl(composerM4937constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -922062087, "C1208@42744L84,1209@42837L29,1210@42875L181,1216@43065L30,1218@43156L77,1217@43104L311,1226@43424L30,1227@43463L202:TicketsShareScreens.kt#n9ob9m");
            TextKt.m3661TextNvy7gAk("对方已扫描", null, Color.INSTANCE.m5875getWhite0d7_KjU(), null, TextUnitKt.getSp(16), null, FontWeight.INSTANCE.getMedium(), null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composerStartRestartGroup, 1597830, 0, 262058);
            SpacerKt.Spacer(SizeKt.m1476height3ABfNKs(Modifier.INSTANCE, Dp.m8748constructorimpl(5.0f)), composerStartRestartGroup, 6);
            if (list.size() == 1) {
                str = "是否确认分享这张票据？";
            } else {
                str = "是否确认分享这 " + list.size() + " 张票据？";
            }
            TextKt.m3661TextNvy7gAk(str, null, ColorKt.Color(4287598486L), null, TextUnitKt.getSp(13), null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composerStartRestartGroup, 24960, 0, 262122);
            SpacerKt.Spacer(SizeKt.m1476height3ABfNKs(Modifier.INSTANCE, Dp.m8748constructorimpl(14.0f)), composerStartRestartGroup, 6);
            List listTake = CollectionsKt.take(list, 3);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 385910398, "CC(remember):TicketsShareScreens.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: com.example.tickets.TicketsShareScreensKt$$ExternalSyntheticLambda38
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return TicketsShareScreensKt.SenderConfirmationCard$lambda$147$lambda$145$lambda$144((TicketData) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            TextKt.m3661TextNvy7gAk(CollectionsKt.joinToString$default(listTake, str, null, null, 0, null, (Function1) objRememberedValue, 30, null) + (list.size() > 3 ? " 等" : ""), null, Color.INSTANCE.m5875getWhite0d7_KjU(), null, TextUnitKt.getSp(18), null, null, null, 0L, null, null, 0L, TextOverflow.INSTANCE.m8684getEllipsisgIe3tQ8(), false, 2, 0, null, null, composerStartRestartGroup, 24960, 24960, 241642);
            SpacerKt.Spacer(SizeKt.m1476height3ABfNKs(Modifier.INSTANCE, Dp.m8748constructorimpl(14.0f)), composerStartRestartGroup, 6);
            Arrangement.HorizontalOrVertical horizontalOrVerticalM1115spacedBy0680j_4 = Arrangement.INSTANCE.m1115spacedBy0680j_4(Dp.m8748constructorimpl(10.0f));
            Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(horizontalOrVerticalM1115spacedBy0680j_4, Alignment.INSTANCE.getTop(), composerStartRestartGroup, 6);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
            int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxWidth$default);
            Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)410@16216L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor2);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM4937constructorimpl2 = Updater.m4937constructorimpl(composerStartRestartGroup);
            Updater.m4945setimpl(composerM4937constructorimpl2, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m4945setimpl(composerM4937constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m4945setimpl(composerM4937constructorimpl2, Integer.valueOf(iHashCode2), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m4943reconcileimpl(composerM4937constructorimpl2, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m4945setimpl(composerM4937constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 826464417, "C1228@43570L36,1229@43619L36:TicketsShareScreens.kt#n9ob9m");
            ConfirmButton(rowScopeInstance, "取消", false, function1, composerStartRestartGroup, 438 | ((i2 << 3) & 7168));
            composer2 = composerStartRestartGroup;
            ConfirmButton(rowScopeInstance, "确认", true, function0, composer2, 438 | ((i2 << 6) & 7168));
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.tickets.TicketsShareScreensKt$$ExternalSyntheticLambda39
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TicketsShareScreensKt.SenderConfirmationCard$lambda$148(list, function0, function1, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    static final CharSequence SenderConfirmationCard$lambda$147$lambda$145$lambda$144(TicketData it) {
        Intrinsics.checkNotNullParameter(it, "it");
        String title = it.getTitle();
        if (StringsKt.isBlank(title)) {
            String code = it.getCode();
            if (StringsKt.isBlank(code)) {
                code = "票据";
            }
            title = code;
        }
        return title;
    }

    private static final void ReceiverConfirmCard(final List<TicketData> list, final Function0<Unit> function0, final Function0<Unit> function1, Composer composer, final int i) {
        int i2;
        Composer composer2;
        String strTicketShareTypeName;
        Composer composerStartRestartGroup = composer.startRestartGroup(124571602);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ReceiverConfirmCard)N(tickets,onAccept,onReject)1236@43796L1258:TicketsShareScreens.kt#n9ob9m");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(list) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function0) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function1) ? 256 : 128;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 147) != 146, i2 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(124571602, i2, -1, "com.example.tickets.ReceiverConfirmCard (TicketsShareScreens.kt:1235)");
            }
            Modifier modifierM1423padding3ABfNKs = PaddingKt.m1423padding3ABfNKs(BorderKt.m659borderxT4_qwU(BackgroundKt.m647backgroundbw27NRU(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), ColorKt.Color(4279571736L), RoundedCornerShapeKt.m1756RoundedCornerShape0680j_4(Dp.m8748constructorimpl(20.0f))), Dp.m8748constructorimpl(1.0f), Color.m5837copywmQWz5c$default(Color.INSTANCE.m5875getWhite0d7_KjU(), 0.08f, 0.0f, 0.0f, 0.0f, 14, null), RoundedCornerShapeKt.m1756RoundedCornerShape0680j_4(Dp.m8748constructorimpl(20.0f))), Dp.m8748constructorimpl(18.0f));
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1423padding3ABfNKs);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)410@16216L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM4937constructorimpl = Updater.m4937constructorimpl(composerStartRestartGroup);
            Updater.m4945setimpl(composerM4937constructorimpl, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m4945setimpl(composerM4937constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m4945setimpl(composerM4937constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m4943reconcileimpl(composerM4937constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m4945setimpl(composerM4937constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -539915233, "C1243@44060L83,1244@44152L29,1245@44190L251,1254@44450L29,1256@44540L77,1255@44488L311,1264@44808L30,1265@44847L201:TicketsShareScreens.kt#n9ob9m");
            TextKt.m3661TextNvy7gAk("收到票据", null, Color.INSTANCE.m5875getWhite0d7_KjU(), null, TextUnitKt.getSp(16), null, FontWeight.INSTANCE.getMedium(), null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composerStartRestartGroup, 1597830, 0, 262058);
            SpacerKt.Spacer(SizeKt.m1476height3ABfNKs(Modifier.INSTANCE, Dp.m8748constructorimpl(6.0f)), composerStartRestartGroup, 6);
            if (list.size() == 1) {
                strTicketShareTypeName = ticketShareTypeName(((TicketData) CollectionsKt.first((List) list)).getType());
            } else {
                strTicketShareTypeName = list.size() + "张票据";
            }
            TextKt.m3661TextNvy7gAk(strTicketShareTypeName, null, ColorKt.Color(4287598486L), null, TextUnitKt.getSp(12), null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composerStartRestartGroup, 24960, 0, 262122);
            SpacerKt.Spacer(SizeKt.m1476height3ABfNKs(Modifier.INSTANCE, Dp.m8748constructorimpl(6.0f)), composerStartRestartGroup, 6);
            List listTake = CollectionsKt.take(list, 3);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 536787157, "CC(remember):TicketsShareScreens.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: com.example.tickets.TicketsShareScreensKt$$ExternalSyntheticLambda74
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return TicketsShareScreensKt.ReceiverConfirmCard$lambda$154$lambda$152$lambda$151((TicketData) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            TextKt.m3661TextNvy7gAk(CollectionsKt.joinToString$default(listTake, str, null, null, 0, null, (Function1) objRememberedValue, 30, null) + (list.size() > 3 ? " 等" : ""), null, Color.INSTANCE.m5875getWhite0d7_KjU(), null, TextUnitKt.getSp(19), null, null, null, 0L, null, null, 0L, TextOverflow.INSTANCE.m8684getEllipsisgIe3tQ8(), false, 2, 0, null, null, composerStartRestartGroup, 24960, 24960, 241642);
            SpacerKt.Spacer(SizeKt.m1476height3ABfNKs(Modifier.INSTANCE, Dp.m8748constructorimpl(14.0f)), composerStartRestartGroup, 6);
            Arrangement.HorizontalOrVertical horizontalOrVerticalM1115spacedBy0680j_4 = Arrangement.INSTANCE.m1115spacedBy0680j_4(Dp.m8748constructorimpl(10.0f));
            Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(horizontalOrVerticalM1115spacedBy0680j_4, Alignment.INSTANCE.getTop(), composerStartRestartGroup, 6);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
            int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxWidth$default);
            Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)410@16216L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor2);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM4937constructorimpl2 = Updater.m4937constructorimpl(composerStartRestartGroup);
            Updater.m4945setimpl(composerM4937constructorimpl2, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m4945setimpl(composerM4937constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m4945setimpl(composerM4937constructorimpl2, Integer.valueOf(iHashCode2), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m4943reconcileimpl(composerM4937constructorimpl2, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m4945setimpl(composerM4937constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1376570691, "C1266@44954L36,1267@45003L35:TicketsShareScreens.kt#n9ob9m");
            ConfirmButton(rowScopeInstance, "拒绝", false, function1, composerStartRestartGroup, 438 | ((i2 << 3) & 7168));
            composer2 = composerStartRestartGroup;
            ConfirmButton(rowScopeInstance, "接受", true, function0, composer2, 438 | ((i2 << 6) & 7168));
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.tickets.TicketsShareScreensKt$$ExternalSyntheticLambda75
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TicketsShareScreensKt.ReceiverConfirmCard$lambda$155(list, function0, function1, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    static final CharSequence ReceiverConfirmCard$lambda$154$lambda$152$lambda$151(TicketData it) {
        Intrinsics.checkNotNullParameter(it, "it");
        String title = it.getTitle();
        if (StringsKt.isBlank(title)) {
            String code = it.getCode();
            if (StringsKt.isBlank(code)) {
                code = "票据";
            }
            title = code;
        }
        return title;
    }

    private static final void ConfirmButton(final RowScope rowScope, final String str, final boolean z, final Function0<Unit> function0, Composer composer, final int i) {
        int i2;
        String str2;
        Composer composer2;
        Composer composerStartRestartGroup = composer.startRestartGroup(2049073064);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ConfirmButton)N(text,primary,onClick)1278@45213L660:TicketsShareScreens.kt#n9ob9m");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(rowScope) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            str2 = str;
            i2 |= composerStartRestartGroup.changed(str2) ? 32 : 16;
        } else {
            str2 = str;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changed(z) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function0) ? 2048 : 1024;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 1171) != 1170, i2 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2049073064, i2, -1, "com.example.tickets.ConfirmButton (TicketsShareScreens.kt:1277)");
            }
            Modifier modifierM683clickableoSLSa3U$default = ClickableKt.m683clickableoSLSa3U$default(BorderKt.m659borderxT4_qwU(BackgroundKt.m648backgroundbw27NRU$default(ClipKt.clip(SizeKt.m1476height3ABfNKs(RowScope.weight$default(rowScope, Modifier.INSTANCE, 1.0f, false, 2, null), Dp.m8748constructorimpl(48.0f)), RoundedCornerShapeKt.m1756RoundedCornerShape0680j_4(Dp.m8748constructorimpl(14.0f))), ColorKt.Color(z ? 4281348147L : 4280558631L), null, 2, null), Dp.m8748constructorimpl(1.0f), Color.m5837copywmQWz5c$default(Color.INSTANCE.m5875getWhite0d7_KjU(), z ? 0.3f : 0.18f, 0.0f, 0.0f, 0.0f, 14, null), RoundedCornerShapeKt.m1756RoundedCornerShape0680j_4(Dp.m8748constructorimpl(14.0f))), false, null, null, null, function0, 15, null);
            Alignment center = Alignment.INSTANCE.getCenter();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM683clickableoSLSa3U$default);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)410@16216L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM4937constructorimpl = Updater.m4937constructorimpl(composerStartRestartGroup);
            Updater.m4945setimpl(composerM4937constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m4945setimpl(composerM4937constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m4945setimpl(composerM4937constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m4943reconcileimpl(composerM4937constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m4945setimpl(composerM4937constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1928735792, "C1292@45722L145:TicketsShareScreens.kt#n9ob9m");
            composer2 = composerStartRestartGroup;
            TextKt.m3661TextNvy7gAk(str2, null, ColorKt.Color(4293980402L), null, TextUnitKt.getSp(15), null, FontWeight.INSTANCE.getMedium(), null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer2, ((i2 >> 3) & 14) | 1597824, 0, 262058);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.tickets.TicketsShareScreensKt$$ExternalSyntheticLambda40
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TicketsShareScreensKt.ConfirmButton$lambda$157(rowScope, str, z, function0, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final void NfcSwipeSendCard(final List<TicketData> list, Function0<Unit> function0, Function0<Unit> function1, Composer composer, final int i) {
        int i2;
        final Function0<Unit> function2;
        final Function0<Unit> function3;
        MutableState mutableState;
        MutableFloatState mutableFloatState;
        Animatable animatable;
        Object obj;
        TicketsShareScreensKt$NfcSwipeSendCard$1$1 ticketsShareScreensKt$NfcSwipeSendCard$1$1;
        String strTicketShareTypeName;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1946833132);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(NfcSwipeSendCard)N(tickets,onSend,onCancel)1307@46020L36,1308@46076L34,1309@46140L36,1310@46208L7,1311@46239L27,1319@46438L314,1319@46414L338,1336@46896L4491:TicketsShareScreens.kt#n9ob9m");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(list) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function0) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function1) ? 256 : 128;
        }
        int i3 = i2;
        if (!composerStartRestartGroup.shouldExecute((i3 & 147) != 146, i3 & 1)) {
            function2 = function0;
            function3 = function1;
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1946833132, i3, -1, "com.example.tickets.NfcSwipeSendCard (TicketsShareScreens.kt:1306)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1699105816, "CC(remember):TicketsShareScreens.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = PrimitiveSnapshotStateKt.mutableFloatStateOf(0.0f);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            MutableFloatState mutableFloatState2 = (MutableFloatState) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1699107606, "CC(remember):TicketsShareScreens.kt#9igjgp");
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            MutableState mutableState2 = (MutableState) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1699109656, "CC(remember):TicketsShareScreens.kt#9igjgp");
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = PrimitiveSnapshotStateKt.mutableFloatStateOf(0.0f);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            MutableFloatState mutableFloatState3 = (MutableFloatState) objRememberedValue3;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ProvidableCompositionLocal<Context> localContext = AndroidCompositionLocals_androidKt.getLocalContext();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composerStartRestartGroup.consume(localContext);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Context context = (Context) objConsume;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1699112815, "CC(remember):TicketsShareScreens.kt#9igjgp");
            Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue4 = AnimatableKt.Animatable$default(0.0f, 0.0f, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            Animatable animatable2 = (Animatable) objRememberedValue4;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Boolean boolValueOf = Boolean.valueOf(NfcSwipeSendCard$lambda$162(mutableState2));
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1699119470, "CC(remember):TicketsShareScreens.kt#9igjgp");
            boolean zChangedInstance = composerStartRestartGroup.changedInstance(animatable2) | ((i3 & StylePropertiesKt.TextDirectionMask) == 32);
            Object objRememberedValue5 = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                mutableState = mutableState2;
                mutableFloatState = mutableFloatState3;
                animatable = animatable2;
                obj = null;
                ticketsShareScreensKt$NfcSwipeSendCard$1$1 = new TicketsShareScreensKt$NfcSwipeSendCard$1$1(animatable, function0, mutableState, mutableFloatState, null);
                composerStartRestartGroup.updateRememberedValue(ticketsShareScreensKt$NfcSwipeSendCard$1$1);
            } else {
                mutableState = mutableState2;
                ticketsShareScreensKt$NfcSwipeSendCard$1$1 = objRememberedValue5;
                obj = null;
                mutableFloatState = mutableFloatState3;
                animatable = animatable2;
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.LaunchedEffect(boolValueOf, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) ticketsShareScreensKt$NfcSwipeSendCard$1$1, composerStartRestartGroup, 0);
            float fCoerceIn = RangesKt.coerceIn((-NfcSwipeSendCard$lambda$159(mutableFloatState2)) / 150.0f, 0.0f, 1.0f);
            if (NfcSwipeSendCard$lambda$162(mutableState)) {
                fCoerceIn = RangesKt.coerceIn(((Number) animatable.getValue()).floatValue(), 0.0f, 1.0f);
            }
            final float f = fCoerceIn;
            Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, obj);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxSize$default);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)410@16216L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM4937constructorimpl = Updater.m4937constructorimpl(composerStartRestartGroup);
            Updater.m4945setimpl(composerM4937constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m4945setimpl(composerM4937constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m4945setimpl(composerM4937constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m4943reconcileimpl(composerM4937constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m4945setimpl(composerM4937constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1866660534, "C1337@46934L147,1347@47238L312,1343@47091L4290:TicketsShareScreens.kt#n9ob9m");
            TicketTransferBeamEffectKt.TicketTransferBeamEffect(TicketBeamMode.SEND, f, SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), composerStartRestartGroup, 390, 0);
            Modifier modifierM1383offsetVpY3zN4$default = OffsetKt.m1383offsetVpY3zN4$default(boxScopeInstance.align(Modifier.INSTANCE, Alignment.INSTANCE.getCenter()), 0.0f, Dp.m8748constructorimpl(88.0f), 1, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1307146438, "CC(remember):TicketsShareScreens.kt#9igjgp");
            boolean zChanged = composerStartRestartGroup.changed(f);
            Object objRememberedValue6 = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue6 = new Function1() { // from class: com.example.tickets.TicketsShareScreensKt$$ExternalSyntheticLambda12
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return TicketsShareScreensKt.NfcSwipeSendCard$lambda$181$lambda$170$lambda$169(f, (GraphicsLayerScope) obj2);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierGraphicsLayer = GraphicsLayerModifierKt.graphicsLayer(modifierM1383offsetVpY3zN4$default, (Function1) objRememberedValue6);
            Alignment.Horizontal centerHorizontally = Alignment.INSTANCE.getCenterHorizontally();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), centerHorizontally, composerStartRestartGroup, 48);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
            int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierGraphicsLayer);
            Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)410@16216L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor2);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM4937constructorimpl2 = Updater.m4937constructorimpl(composerStartRestartGroup);
            Updater.m4945setimpl(composerM4937constructorimpl2, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m4945setimpl(composerM4937constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m4945setimpl(composerM4937constructorimpl2, Integer.valueOf(iHashCode2), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m4943reconcileimpl(composerM4937constructorimpl2, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m4945setimpl(composerM4937constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1218612585, "C1360@47786L328,1374@48450L893,1356@47639L3315,1432@50968L29,1433@51010L156,1438@51179L30,1439@51222L149:TicketsShareScreens.kt#n9ob9m");
            Modifier modifierM1476height3ABfNKs = SizeKt.m1476height3ABfNKs(SizeKt.m1495width3ABfNKs(Modifier.INSTANCE, Dp.m8748constructorimpl(380.0f)), Dp.m8748constructorimpl(270.0f));
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -593498112, "CC(remember):TicketsShareScreens.kt#9igjgp");
            boolean zChanged2 = composerStartRestartGroup.changed(f);
            Object objRememberedValue7 = composerStartRestartGroup.rememberedValue();
            if (zChanged2 || objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue7 = new Function1() { // from class: com.example.tickets.TicketsShareScreensKt$$ExternalSyntheticLambda13
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return TicketsShareScreensKt.NfcSwipeSendCard$lambda$181$lambda$180$lambda$172$lambda$171(f, (GraphicsLayerScope) obj2);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierM659borderxT4_qwU = BorderKt.m659borderxT4_qwU(BackgroundKt.m648backgroundbw27NRU$default(ClipKt.clip(GraphicsLayerModifierKt.graphicsLayer(modifierM1476height3ABfNKs, (Function1) objRememberedValue7), RoundedCornerShapeKt.m1756RoundedCornerShape0680j_4(Dp.m8748constructorimpl(20.0f))), ColorKt.Color(4279703322L), null, 2, null), Dp.m8748constructorimpl(1.0f), Color.m5837copywmQWz5c$default(Color.INSTANCE.m5875getWhite0d7_KjU(), 0.16f, 0.0f, 0.0f, 0.0f, 14, null), RoundedCornerShapeKt.m1756RoundedCornerShape0680j_4(Dp.m8748constructorimpl(20.0f)));
            Boolean boolValueOf2 = Boolean.valueOf(NfcSwipeSendCard$lambda$162(mutableState));
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -593476299, "CC(remember):TicketsShareScreens.kt#9igjgp");
            boolean zChangedInstance2 = composerStartRestartGroup.changedInstance(context);
            TicketsShareScreensKt$NfcSwipeSendCard$2$2$2$1 ticketsShareScreensKt$NfcSwipeSendCard$2$2$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance2 || ticketsShareScreensKt$NfcSwipeSendCard$2$2$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                ticketsShareScreensKt$NfcSwipeSendCard$2$2$2$1RememberedValue = new TicketsShareScreensKt$NfcSwipeSendCard$2$2$2$1(mutableState, context, mutableFloatState2, mutableFloatState);
                composerStartRestartGroup.updateRememberedValue(ticketsShareScreensKt$NfcSwipeSendCard$2$2$2$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierPointerInput = SuspendingPointerInputFilterKt.pointerInput(modifierM659borderxT4_qwU, boolValueOf2, (PointerInputEventHandler) ticketsShareScreensKt$NfcSwipeSendCard$2$2$2$1RememberedValue);
            Alignment center = Alignment.INSTANCE.getCenter();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
            int iHashCode3 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierPointerInput);
            Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)410@16216L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor3);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM4937constructorimpl3 = Updater.m4937constructorimpl(composerStartRestartGroup);
            Updater.m4945setimpl(composerM4937constructorimpl3, measurePolicyMaybeCachedBoxMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m4945setimpl(composerM4937constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m4945setimpl(composerM4937constructorimpl3, Integer.valueOf(iHashCode3), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m4943reconcileimpl(composerM4937constructorimpl3, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m4945setimpl(composerM4937constructorimpl3, modifierMaterializeModifier3, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 876950698, "C1395@49429L1511:TicketsShareScreens.kt#n9ob9m");
            Modifier modifierM1424paddingVpY3zN4 = PaddingKt.m1424paddingVpY3zN4(Modifier.INSTANCE, Dp.m8748constructorimpl(18.0f), Dp.m8748constructorimpl(15.0f));
            Alignment.Horizontal centerHorizontally2 = Alignment.INSTANCE.getCenterHorizontally();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), centerHorizontally2, composerStartRestartGroup, 48);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
            int iHashCode4 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap4 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1424paddingVpY3zN4);
            Function0<ComposeUiNode> constructor4 = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)410@16216L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor4);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM4937constructorimpl4 = Updater.m4937constructorimpl(composerStartRestartGroup);
            Updater.m4945setimpl(composerM4937constructorimpl4, measurePolicyColumnMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m4945setimpl(composerM4937constructorimpl4, currentCompositionLocalMap4, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m4945setimpl(composerM4937constructorimpl4, Integer.valueOf(iHashCode4), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m4943reconcileimpl(composerM4937constructorimpl4, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m4945setimpl(composerM4937constructorimpl4, modifierMaterializeModifier4, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -500041088, "C1399@49635L347,1408@50003L29,1411@50146L177,1409@50053L622,1423@50696L30,1424@50747L175:TicketsShareScreens.kt#n9ob9m");
            if (list.size() == 1) {
                strTicketShareTypeName = ticketShareTypeName(((TicketData) CollectionsKt.first((List) list)).getType());
            } else {
                strTicketShareTypeName = list.size() + "张票据";
            }
            TextKt.m3661TextNvy7gAk(strTicketShareTypeName, null, ColorKt.Color(4287598486L), null, TextUnitKt.getSp(12), null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composerStartRestartGroup, 24960, 0, 262122);
            SpacerKt.Spacer(SizeKt.m1476height3ABfNKs(Modifier.INSTANCE, Dp.m8748constructorimpl(4.0f)), composerStartRestartGroup, 6);
            List listTake = CollectionsKt.take(list, 3);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 815168877, "CC(remember):TicketsShareScreens.kt#9igjgp");
            Object objRememberedValue8 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue8 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue8 = new Function1() { // from class: com.example.tickets.TicketsShareScreensKt$$ExternalSyntheticLambda14
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return TicketsShareScreensKt.NfcSwipeSendCard$lambda$181$lambda$180$lambda$179$lambda$178$lambda$177$lambda$176((TicketData) obj2);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            TextKt.m3661TextNvy7gAk(CollectionsKt.joinToString$default(listTake, str, null, null, 0, null, (Function1) objRememberedValue8, 30, null) + (list.size() > 3 ? " 等" : ""), null, Color.INSTANCE.m5875getWhite0d7_KjU(), null, TextUnitKt.getSp(19), null, FontWeight.INSTANCE.getMedium(), null, 0L, null, TextAlign.m8619boximpl(TextAlign.INSTANCE.m8626getCentere0LSkKk()), 0L, TextOverflow.INSTANCE.m8684getEllipsisgIe3tQ8(), false, 2, 0, null, null, composerStartRestartGroup, 1597824, 24960, 240554);
            SpacerKt.Spacer(SizeKt.m1476height3ABfNKs(Modifier.INSTANCE, Dp.m8748constructorimpl(14.0f)), composerStartRestartGroup, 6);
            TextKt.m3661TextNvy7gAk(NfcSwipeSendCard$lambda$162(mutableState) ? "正在传送…" : "↑ 上滑发送票据", null, Color.INSTANCE.m5875getWhite0d7_KjU(), null, TextUnitKt.getSp(16), null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composerStartRestartGroup, 24960, 0, 262122);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            SpacerKt.Spacer(SizeKt.m1476height3ABfNKs(Modifier.INSTANCE, Dp.m8748constructorimpl(8.0f)), composerStartRestartGroup, 6);
            TextKt.m3661TextNvy7gAk(NfcSwipeSendCard$lambda$162(mutableState) ? "正在建立设备间高速传输" : "上滑确认后开始传送", null, ColorKt.Color(4286019454L), null, TextUnitKt.getSp(12), null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composerStartRestartGroup, 24960, 0, 262122);
            composerStartRestartGroup = composerStartRestartGroup;
            SpacerKt.Spacer(SizeKt.m1476height3ABfNKs(Modifier.INSTANCE, Dp.m8748constructorimpl(12.0f)), composerStartRestartGroup, 6);
            function2 = function0;
            function3 = function1;
            ShareOutlinedButton("取消", function3, SizeKt.m1495width3ABfNKs(Modifier.INSTANCE, Dp.m8748constructorimpl(380.0f)), composerStartRestartGroup, ((i3 >> 3) & StylePropertiesKt.TextDirectionMask) | 390, 0);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.tickets.TicketsShareScreensKt$$ExternalSyntheticLambda15
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    return TicketsShareScreensKt.NfcSwipeSendCard$lambda$182(list, function2, function3, i, (Composer) obj2, ((Integer) obj3).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float NfcSwipeSendCard$lambda$159(MutableFloatState mutableFloatState) {
        return mutableFloatState.getFloatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean NfcSwipeSendCard$lambda$162(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void NfcSwipeSendCard$lambda$163(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float NfcSwipeSendCard$lambda$165(MutableFloatState mutableFloatState) {
        return mutableFloatState.getFloatValue();
    }

    static final Unit NfcSwipeSendCard$lambda$181$lambda$180$lambda$172$lambda$171(float f, GraphicsLayerScope graphicsLayer) {
        Intrinsics.checkNotNullParameter(graphicsLayer, "$this$graphicsLayer");
        float fCoerceIn = RangesKt.coerceIn((f - 0.35f) / 0.65f, 0.0f, 1.0f);
        float f2 = 1.0f - (0.1f * fCoerceIn);
        graphicsLayer.setScaleX(f2);
        graphicsLayer.setScaleY(f2);
        graphicsLayer.setAlpha(RangesKt.coerceIn(1.0f - (fCoerceIn * 0.72f), 0.0f, 1.0f));
        return Unit.INSTANCE;
    }

    static final CharSequence NfcSwipeSendCard$lambda$181$lambda$180$lambda$179$lambda$178$lambda$177$lambda$176(TicketData it) {
        Intrinsics.checkNotNullParameter(it, "it");
        String title = it.getTitle();
        if (StringsKt.isBlank(title)) {
            String code = it.getCode();
            if (StringsKt.isBlank(code)) {
                code = "票据";
            }
            title = code;
        }
        return title;
    }

    /* JADX WARN: Code duplicated, block: B:65:0x0151  */
    /* JADX WARN: Code duplicated, block: B:70:0x015a  */
    private static final void QrReceivePopCard(final List<TicketData> list, Function0<Unit> function0, final Function0<Unit> function1, Composer composer, final int i) {
        final Function0<Unit> function2;
        Composer composer2;
        String str;
        String strJoinToString$default;
        Animatable animatable;
        Animatable animatable2;
        String strTicketShareTypeName;
        int i2;
        String title;
        String code;
        Composer composerStartRestartGroup = composer.startRestartGroup(-914614772);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(QrReceivePopCard)N(tickets,onAccept,onReject)1454@51543L27,1455@51594L27,1456@51641L34,1457@51698L33,1459@51761L311,1459@51737L335,1490@52554L318,1490@52518L354,1508@52983L3284:TicketsShareScreens.kt#n9ob9m");
        int i3 = (i & 6) == 0 ? (composerStartRestartGroup.changedInstance(list) ? 4 : 2) | i : i;
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function0) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function1) ? 256 : 128;
        }
        if (!composerStartRestartGroup.shouldExecute((i3 & 147) != 146, i3 & 1)) {
            function2 = function0;
            function1 = function1;
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-914614772, i3, -1, "com.example.tickets.QrReceivePopCard (TicketsShareScreens.kt:1453)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1523504679, "CC(remember):TicketsShareScreens.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = AnimatableKt.Animatable$default(0.0f, 0.0f, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            Animatable animatable3 = (Animatable) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1523506311, "CC(remember):TicketsShareScreens.kt#9igjgp");
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = AnimatableKt.Animatable$default(0.0f, 0.0f, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            Animatable animatable4 = (Animatable) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1523507822, "CC(remember):TicketsShareScreens.kt#9igjgp");
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            final MutableState mutableState = (MutableState) objRememberedValue3;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1523509645, "CC(remember):TicketsShareScreens.kt#9igjgp");
            Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(true, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            final MutableState mutableState2 = (MutableState) objRememberedValue4;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1523511939, "CC(remember):TicketsShareScreens.kt#9igjgp");
            boolean zChangedInstance = composerStartRestartGroup.changedInstance(animatable4) | composerStartRestartGroup.changedInstance(animatable3);
            TicketsShareScreensKt$QrReceivePopCard$1$1 ticketsShareScreensKt$QrReceivePopCard$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || ticketsShareScreensKt$QrReceivePopCard$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                ticketsShareScreensKt$QrReceivePopCard$1$1RememberedValue = new TicketsShareScreensKt$QrReceivePopCard$1$1(animatable4, animatable3, mutableState, null);
                composerStartRestartGroup.updateRememberedValue(ticketsShareScreensKt$QrReceivePopCard$1$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.LaunchedEffect(list, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) ticketsShareScreensKt$QrReceivePopCard$1$1RememberedValue, composerStartRestartGroup, i3 & 14);
            TicketData ticketData = (TicketData) CollectionsKt.firstOrNull((List) list);
            if (ticketData == null || (title = ticketData.getTitle()) == null) {
                str = "票据";
            } else {
                String str2 = title;
                if (StringsKt.isBlank(str2)) {
                    TicketData ticketData2 = (TicketData) CollectionsKt.firstOrNull((List) list);
                    if (ticketData2 == null || (code = ticketData2.getCode()) == null) {
                        str2 = "票据";
                    } else {
                        String str3 = code;
                        if (StringsKt.isBlank(str3)) {
                            str3 = "票据";
                        }
                        str2 = str3;
                        if (str2 == null) {
                            str2 = "票据";
                        }
                    }
                }
                String str4 = str2;
                if (str4 == null) {
                    str = "票据";
                } else {
                    str = str4;
                }
            }
            TicketData ticketData3 = (TicketData) CollectionsKt.firstOrNull((List) list);
            if (ticketData3 != null) {
                List listListOf = CollectionsKt.listOf((Object[]) new String[]{ticketData3.getFrom(), ticketData3.getTo()});
                ArrayList arrayList = new ArrayList();
                for (Object obj : listListOf) {
                    if (!StringsKt.isBlank((String) obj)) {
                        arrayList.add(obj);
                    }
                }
                strJoinToString$default = CollectionsKt.joinToString$default(arrayList, " → ", null, null, 0, null, null, 62, null);
            } else {
                strJoinToString$default = null;
            }
            if (strJoinToString$default == null) {
                strJoinToString$default = "";
            }
            String str5 = strJoinToString$default;
            Boolean boolValueOf = Boolean.valueOf(QrReceivePopCard$lambda$186(mutableState));
            Boolean boolValueOf2 = Boolean.valueOf(QrReceivePopCard$lambda$189(mutableState2));
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1523537322, "CC(remember):TicketsShareScreens.kt#9igjgp");
            boolean zChangedInstance2 = ((i3 & 896) == 256) | composerStartRestartGroup.changedInstance(animatable4) | ((i3 & StylePropertiesKt.TextDirectionMask) == 32);
            TicketsShareScreensKt$QrReceivePopCard$2$1 ticketsShareScreensKt$QrReceivePopCard$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance2 || ticketsShareScreensKt$QrReceivePopCard$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                animatable = animatable3;
                animatable2 = animatable4;
                TicketsShareScreensKt$QrReceivePopCard$2$1 ticketsShareScreensKt$QrReceivePopCard$2$1 = new TicketsShareScreensKt$QrReceivePopCard$2$1(animatable2, function0, function1, mutableState, mutableState2, null);
                function2 = function0;
                mutableState = mutableState;
                ticketsShareScreensKt$QrReceivePopCard$2$1RememberedValue = ticketsShareScreensKt$QrReceivePopCard$2$1;
                composerStartRestartGroup.updateRememberedValue(ticketsShareScreensKt$QrReceivePopCard$2$1RememberedValue);
            } else {
                animatable = animatable3;
                function2 = function0;
                animatable2 = animatable4;
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.LaunchedEffect(boolValueOf, boolValueOf2, (Function2) ticketsShareScreensKt$QrReceivePopCard$2$1RememberedValue, composerStartRestartGroup, 0);
            final float fCoerceIn = RangesKt.coerceIn(((Number) animatable.getValue()).floatValue(), 0.0f, 1.0f);
            final float fCoerceIn2 = RangesKt.coerceIn(((Number) animatable2.getValue()).floatValue(), 0.0f, 1.0f);
            Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
            Alignment center = Alignment.INSTANCE.getCenter();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxSize$default);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)410@16216L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM4937constructorimpl = Updater.m4937constructorimpl(composerStartRestartGroup);
            Updater.m4945setimpl(composerM4937constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m4945setimpl(composerM4937constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m4945setimpl(composerM4937constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m4943reconcileimpl(composerM4937constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m4945setimpl(composerM4937constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 717944347, "C1512@53091L154,1522@53389L793,1518@53255L3006:TicketsShareScreens.kt#n9ob9m");
            TicketTransferBeamEffectKt.TicketTransferBeamEffect(TicketBeamMode.RECEIVE, fCoerceIn, SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), composerStartRestartGroup, 390, 0);
            Modifier modifierM1476height3ABfNKs = SizeKt.m1476height3ABfNKs(SizeKt.m1495width3ABfNKs(Modifier.INSTANCE, Dp.m8748constructorimpl(380.0f)), Dp.m8748constructorimpl(270.0f));
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1131545311, "CC(remember):TicketsShareScreens.kt#9igjgp");
            boolean zChanged = composerStartRestartGroup.changed(fCoerceIn) | composerStartRestartGroup.changed(fCoerceIn2);
            Object objRememberedValue5 = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue5 = new Function1() { // from class: com.example.tickets.TicketsShareScreensKt$$ExternalSyntheticLambda85
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return TicketsShareScreensKt.QrReceivePopCard$lambda$205$lambda$198$lambda$197(fCoerceIn, fCoerceIn2, mutableState, mutableState2, (GraphicsLayerScope) obj2);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierM1424paddingVpY3zN4 = PaddingKt.m1424paddingVpY3zN4(BorderKt.m659borderxT4_qwU(BackgroundKt.m648backgroundbw27NRU$default(ClipKt.clip(GraphicsLayerModifierKt.graphicsLayer(modifierM1476height3ABfNKs, (Function1) objRememberedValue5), RoundedCornerShapeKt.m1756RoundedCornerShape0680j_4(Dp.m8748constructorimpl(20.0f))), ColorKt.Color(4279703322L), null, 2, null), Dp.m8748constructorimpl(1.0f), Color.m5837copywmQWz5c$default(Color.INSTANCE.m5875getWhite0d7_KjU(), 0.16f, 0.0f, 0.0f, 0.0f, 14, null), RoundedCornerShapeKt.m1756RoundedCornerShape0680j_4(Dp.m8748constructorimpl(20.0f))), Dp.m8748constructorimpl(18.0f), Dp.m8748constructorimpl(15.0f));
            Alignment.Horizontal centerHorizontally = Alignment.INSTANCE.getCenterHorizontally();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), centerHorizontally, composerStartRestartGroup, 48);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
            int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1424paddingVpY3zN4);
            Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)410@16216L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor2);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM4937constructorimpl2 = Updater.m4937constructorimpl(composerStartRestartGroup);
            Updater.m4945setimpl(composerM4937constructorimpl2, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m4945setimpl(composerM4937constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m4945setimpl(composerM4937constructorimpl2, Integer.valueOf(iHashCode2), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m4943reconcileimpl(composerM4937constructorimpl2, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m4945setimpl(composerM4937constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1927613662, "C1550@54598L283,1559@54894L29,1560@54936L286:TicketsShareScreens.kt#n9ob9m");
            if (list.size() == 1) {
                strTicketShareTypeName = ticketShareTypeName(((TicketData) CollectionsKt.first((List) list)).getType());
            } else {
                strTicketShareTypeName = list.size() + "张票据";
            }
            final MutableState mutableState3 = mutableState;
            TextKt.m3661TextNvy7gAk(strTicketShareTypeName, null, ColorKt.Color(4287598486L), null, TextUnitKt.getSp(12), null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composerStartRestartGroup, 24960, 0, 262122);
            SpacerKt.Spacer(SizeKt.m1476height3ABfNKs(Modifier.INSTANCE, Dp.m8748constructorimpl(4.0f)), composerStartRestartGroup, 6);
            TextKt.m3661TextNvy7gAk(str, null, Color.INSTANCE.m5875getWhite0d7_KjU(), null, TextUnitKt.getSp(18), null, FontWeight.INSTANCE.getMedium(), null, 0L, null, TextAlign.m8619boximpl(TextAlign.INSTANCE.m8626getCentere0LSkKk()), 0L, TextOverflow.INSTANCE.m8684getEllipsisgIe3tQ8(), false, 2, 0, null, null, composerStartRestartGroup, 1597824, 24960, 240554);
            Composer composer3 = composerStartRestartGroup;
            if (StringsKt.isBlank(str5)) {
                i2 = 1873400210;
                composer3.startReplaceGroup(1873400210);
            } else {
                composer3.startReplaceGroup(1928229972);
                ComposerKt.sourceInformation(composer3, "1571@55278L29,1572@55324L272");
                SpacerKt.Spacer(SizeKt.m1476height3ABfNKs(Modifier.INSTANCE, Dp.m8748constructorimpl(4.0f)), composer3, 6);
                i2 = 1873400210;
                TextKt.m3661TextNvy7gAk(str5, null, ColorKt.Color(4289967034L), null, TextUnitKt.getSp(12), null, null, null, 0L, null, TextAlign.m8619boximpl(TextAlign.INSTANCE.m8626getCentere0LSkKk()), 0L, TextOverflow.INSTANCE.m8684getEllipsisgIe3tQ8(), false, 1, 0, null, null, composer3, 24960, 24960, 240618);
                composer3 = composer3;
            }
            composer3.endReplaceGroup();
            if (fCoerceIn < 0.98f || QrReceivePopCard$lambda$186(mutableState3)) {
                composer2 = composer3;
                composer2.startReplaceGroup(i2);
            } else {
                composer3.startReplaceGroup(1928630399);
                ComposerKt.sourceInformation(composer3, "1583@55674L30,1584@55721L516");
                SpacerKt.Spacer(SizeKt.m1476height3ABfNKs(Modifier.INSTANCE, Dp.m8748constructorimpl(14.0f)), composer3, 6);
                Arrangement.HorizontalOrVertical horizontalOrVerticalM1115spacedBy0680j_4 = Arrangement.INSTANCE.m1115spacedBy0680j_4(Dp.m8748constructorimpl(10.0f));
                Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                ComposerKt.sourceInformationMarkerStart(composer3, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(horizontalOrVerticalM1115spacedBy0680j_4, Alignment.INSTANCE.getTop(), composer3, 6);
                ComposerKt.sourceInformationMarkerStart(composer3, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
                int iHashCode3 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer3, 0));
                CompositionLocalMap currentCompositionLocalMap3 = composer3.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composer3, modifierFillMaxWidth$default);
                Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)410@16216L9:Composables.kt#9igjgp");
                if (!(composer3.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composer3.startReusableNode();
                if (composer3.getInserting()) {
                    composer3.createNode(constructor3);
                } else {
                    composer3.useNode();
                }
                Composer composerM4937constructorimpl3 = Updater.m4937constructorimpl(composer3);
                Updater.m4945setimpl(composerM4937constructorimpl3, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m4945setimpl(composerM4937constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Updater.m4945setimpl(composerM4937constructorimpl3, Integer.valueOf(iHashCode3), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                Updater.m4943reconcileimpl(composerM4937constructorimpl3, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                Updater.m4945setimpl(composerM4937constructorimpl3, modifierMaterializeModifier3, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composer3, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composer3, -1629331260, "C1591@56004L20,1588@55894L152,1596@56178L19,1593@56067L152:TicketsShareScreens.kt#n9ob9m");
                ComposerKt.sourceInformationMarkerStart(composer3, -52555858, "CC(remember):TicketsShareScreens.kt#9igjgp");
                Object objRememberedValue6 = composer3.rememberedValue();
                if (objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue6 = new Function0() { // from class: com.example.tickets.TicketsShareScreensKt$$ExternalSyntheticLambda86
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return TicketsShareScreensKt.QrReceivePopCard$lambda$205$lambda$204$lambda$203$lambda$200$lambda$199(mutableState3, mutableState2);
                        }
                    };
                    composer3.updateRememberedValue(objRememberedValue6);
                }
                ComposerKt.sourceInformationMarkerEnd(composer3);
                composer2 = composer3;
                ConfirmButton(rowScopeInstance, "拒绝", false, (Function0) objRememberedValue6, composer2, 3510);
                ComposerKt.sourceInformationMarkerStart(composer2, -52550291, "CC(remember):TicketsShareScreens.kt#9igjgp");
                Object objRememberedValue7 = composer2.rememberedValue();
                if (objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue7 = new Function0() { // from class: com.example.tickets.TicketsShareScreensKt$$ExternalSyntheticLambda87
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return TicketsShareScreensKt.QrReceivePopCard$lambda$205$lambda$204$lambda$203$lambda$202$lambda$201(mutableState3, mutableState2);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue7);
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ConfirmButton(rowScopeInstance, "完成接收", true, (Function0) objRememberedValue7, composer2, 3510);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
            }
            composer2.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.tickets.TicketsShareScreensKt$$ExternalSyntheticLambda89
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    return TicketsShareScreensKt.QrReceivePopCard$lambda$206(list, function2, function1, i, (Composer) obj2, ((Integer) obj3).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean QrReceivePopCard$lambda$186(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void QrReceivePopCard$lambda$187(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean QrReceivePopCard$lambda$189(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void QrReceivePopCard$lambda$190(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final void QrReceivePopCard$startExit(MutableState<Boolean> mutableState, MutableState<Boolean> mutableState2, boolean z) {
        if (QrReceivePopCard$lambda$186(mutableState)) {
            return;
        }
        QrReceivePopCard$lambda$187(mutableState, true);
        QrReceivePopCard$lambda$190(mutableState2, z);
    }

    static final Unit QrReceivePopCard$lambda$205$lambda$204$lambda$203$lambda$200$lambda$199(MutableState mutableState, MutableState mutableState2) {
        QrReceivePopCard$startExit(mutableState, mutableState2, false);
        return Unit.INSTANCE;
    }

    static final Unit QrReceivePopCard$lambda$205$lambda$204$lambda$203$lambda$202$lambda$201(MutableState mutableState, MutableState mutableState2) {
        QrReceivePopCard$startExit(mutableState, mutableState2, true);
        return Unit.INSTANCE;
    }

    private static final void ShareFullScreenPage(final Function0<Unit> function0, final Function3<? super Modifier, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(561269490);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ShareFullScreenPage)N(onBack,content)1609@56392L150:TicketsShareScreens.kt#n9ob9m");
        if ((i & 48) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(function3) ? 32 : 16) | i;
        } else {
            i2 = i;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 17) != 16, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(561269490, i2, -1, "com.example.tickets.ShareFullScreenPage (TicketsShareScreens.kt:1608)");
            }
            Modifier modifierM648backgroundbw27NRU$default = BackgroundKt.m648backgroundbw27NRU$default(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), Color.INSTANCE.m5864getBlack0d7_KjU(), null, 2, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM648backgroundbw27NRU$default);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)410@16216L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM4937constructorimpl = Updater.m4937constructorimpl(composerStartRestartGroup);
            Updater.m4945setimpl(composerM4937constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m4945setimpl(composerM4937constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m4945setimpl(composerM4937constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m4943reconcileimpl(composerM4937constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m4945setimpl(composerM4937constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -482939560, "C1614@56505L31:TicketsShareScreens.kt#n9ob9m");
            function3.invoke(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), composerStartRestartGroup, Integer.valueOf((i2 & StylePropertiesKt.TextDirectionMask) | 6));
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.tickets.TicketsShareScreensKt$$ExternalSyntheticLambda50
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TicketsShareScreensKt.ShareFullScreenPage$lambda$208(function0, function3, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final void TicketNfcContactRippleEffectLocal(final float f, final Modifier modifier, Composer composer, final int i, final int i2) {
        int i3;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1573660663);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(TicketNfcContactRippleEffectLocal)N(progress,modifier)1625@56724L1495,1625@56707L1512:TicketsShareScreens.kt#n9ob9m");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(f) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i4 = i2 & 2;
        if (i4 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changed(modifier) ? 32 : 16;
        }
        if (!composerStartRestartGroup.shouldExecute((i3 & 19) != 18, i3 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (i4 != 0) {
                modifier = Modifier.INSTANCE;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1573660663, i3, -1, "com.example.tickets.TicketNfcContactRippleEffectLocal (TicketsShareScreens.kt:1622)");
            }
            final float fCoerceIn = RangesKt.coerceIn(f, 0.0f, 1.0f);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -459401760, "CC(remember):TicketsShareScreens.kt#9igjgp");
            boolean zChanged = composerStartRestartGroup.changed(fCoerceIn);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: com.example.tickets.TicketsShareScreensKt$$ExternalSyntheticLambda78
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return TicketsShareScreensKt.TicketNfcContactRippleEffectLocal$lambda$210$lambda$209(fCoerceIn, (DrawScope) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            CanvasKt.Canvas(modifier, (Function1) objRememberedValue, composerStartRestartGroup, (i3 >> 3) & 14);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.tickets.TicketsShareScreensKt$$ExternalSyntheticLambda79
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TicketsShareScreensKt.TicketNfcContactRippleEffectLocal$lambda$211(f, modifier, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    static final Unit TicketNfcContactRippleEffectLocal$lambda$210$lambda$209(float f, DrawScope Canvas) {
        int i;
        Intrinsics.checkNotNullParameter(Canvas, "$this$Canvas");
        if (f <= 0.0f) {
            return Unit.INSTANCE;
        }
        float fIntBitsToFloat = Float.intBitsToFloat((int) (Canvas.mo6437getSizeNHjbRc() >> 32)) / 2.0f;
        float f2 = Canvas.mo803toPx0680j_4(Dp.m8748constructorimpl(165.0f));
        float f3 = 1.0f - f;
        DrawScope.m6418drawCircleVaOC9Bg$default(Canvas, Color.m5837copywmQWz5c$default(Color.INSTANCE.m5875getWhite0d7_KjU(), f3 * 0.16f, 0.0f, 0.0f, 0.0f, 14, null), (Canvas.mo803toPx0680j_4(Dp.m8748constructorimpl(7.0f)) + (Canvas.mo803toPx0680j_4(Dp.m8748constructorimpl(10.0f)) * f3)) * 2.2f, Offset.m5559constructorimpl((((long) Float.floatToRawIntBits(fIntBitsToFloat)) << 32) | (((long) Float.floatToRawIntBits(f2)) & 4294967295L)), 0.0f, null, null, 0, 120, null);
        int i2 = 0;
        while (i2 < 4) {
            float f4 = i2;
            float f5 = 0.22f * f4;
            float fCoerceIn = RangesKt.coerceIn((1.22f * f) - f5, 0.0f, 1.0f);
            if (fCoerceIn > 0.0f) {
                i = i2;
                DrawScope.m6418drawCircleVaOC9Bg$default(Canvas, Color.m5837copywmQWz5c$default(Color.INSTANCE.m5875getWhite0d7_KjU(), RangesKt.coerceAtLeast((1.0f - fCoerceIn) * (0.62f - (f4 * 0.1f)), 0.0f), 0.0f, 0.0f, 0.0f, 14, null), Canvas.mo803toPx0680j_4(Dp.m8748constructorimpl(10.0f)) + ((Canvas.mo803toPx0680j_4(Dp.m8748constructorimpl(34.0f)) + (Canvas.mo803toPx0680j_4(Dp.m8748constructorimpl(12.0f)) * f4)) * fCoerceIn), Offset.m5559constructorimpl((((long) Float.floatToRawIntBits(fIntBitsToFloat)) << 32) | (((long) Float.floatToRawIntBits(f2)) & 4294967295L)), 0.0f, new Stroke(Canvas.mo803toPx0680j_4(Dp.m8748constructorimpl(1.8f - f5)), 0.0f, 0, 0, null, 30, null), null, 0, LocationRequestCompat.QUALITY_LOW_POWER, null);
            } else {
                i = i2;
            }
            i2 = i + 1;
        }
        DrawScope.m6418drawCircleVaOC9Bg$default(Canvas, Color.m5837copywmQWz5c$default(Color.INSTANCE.m5875getWhite0d7_KjU(), RangesKt.coerceIn(0.72f * f3, 0.0f, 1.0f), 0.0f, 0.0f, 0.0f, 14, null), Canvas.mo803toPx0680j_4(Dp.m8748constructorimpl(2.2f)) + (Canvas.mo803toPx0680j_4(Dp.m8748constructorimpl(2.8f)) * f3), Offset.m5559constructorimpl((((long) Float.floatToRawIntBits(fIntBitsToFloat)) << 32) | (((long) Float.floatToRawIntBits(f2)) & 4294967295L)), 0.0f, null, null, 0, 120, null);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:149:0x068d A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:150:0x068f  */
    /* JADX WARN: Code duplicated, block: B:151:0x06db  */
    /* JADX WARN: Code duplicated, block: B:153:0x06e8  */
    /* JADX WARN: Code duplicated, block: B:156:0x06f1  */
    /* JADX WARN: Code duplicated, block: B:160:0x0748  */
    private static final void NfcShareAnimatedArtwork(final boolean z, final boolean z2, final boolean z3, final List<TicketData> list, final Function0<Unit> function0, Function0<Unit> function1, Function0<Unit> function2, Composer composer, final int i) {
        int i2;
        Composer composer2;
        final Function0<Unit> function3;
        Animatable animatable;
        String str;
        Animatable animatable2;
        Continuation continuation;
        Animatable animatable3;
        TicketsShareScreensKt$NfcShareAnimatedArtwork$1$1 ticketsShareScreensKt$NfcShareAnimatedArtwork$1$1;
        String str2;
        Function0<Unit> function4 = function1;
        Composer composerStartRestartGroup = composer.startRestartGroup(-226996138);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(NfcShareAnimatedArtwork)N(connected,contactDetected,receiverMode,tickets,onSenderTransferComplete,onReceiverAccept,onReceiverReject)1679@58524L27,1680@58587L27,1681@58647L27,1682@58708L36,1683@58772L216,1692@59026L1155,1692@58994L1187,1728@60300L65,1728@60274L91,1736@60568L5607:TicketsShareScreens.kt#n9ob9m");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(z2) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changed(z3) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(list) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function0) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function4) ? 131072 : 65536;
        }
        if ((1572864 & i) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function2) ? 1048576 : 524288;
        }
        if (!composerStartRestartGroup.shouldExecute((599187 & i2) != 599186, i2 & 1)) {
            composer2 = composerStartRestartGroup;
            function3 = function2;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-226996138, i2, -1, "com.example.tickets.NfcShareAnimatedArtwork (TicketsShareScreens.kt:1678)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 900053137, "CC(remember):TicketsShareScreens.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = AnimatableKt.Animatable$default(0.0f, 0.0f, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            Animatable animatable4 = (Animatable) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 900055153, "CC(remember):TicketsShareScreens.kt#9igjgp");
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = AnimatableKt.Animatable$default(0.0f, 0.0f, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            Animatable animatable5 = (Animatable) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 900057073, "CC(remember):TicketsShareScreens.kt#9igjgp");
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = AnimatableKt.Animatable$default(0.0f, 0.0f, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            Animatable animatable6 = (Animatable) objRememberedValue3;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 900059034, "CC(remember):TicketsShareScreens.kt#9igjgp");
            Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue4 = PrimitiveSnapshotStateKt.mutableFloatStateOf(0.0f);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            MutableFloatState mutableFloatState = (MutableFloatState) objRememberedValue4;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            State<Float> stateAnimateFloatAsState = AnimateAsStateKt.animateFloatAsState(NfcShareAnimatedArtwork$lambda$216(mutableFloatState), AnimationSpecKt.spring$default(0.78f, 820.0f, null, 4, null), 0.0f, "nfc-connection-pulse", null, composerStartRestartGroup, 3120, 20);
            Composer composer3 = composerStartRestartGroup;
            Boolean boolValueOf = Boolean.valueOf(z2);
            ComposerKt.sourceInformationMarkerStart(composer3, 900070329, "CC(remember):TicketsShareScreens.kt#9igjgp");
            int i3 = i2;
            boolean zChangedInstance = ((i2 & StylePropertiesKt.TextDirectionMask) == 32) | composer3.changedInstance(animatable4) | composer3.changedInstance(animatable5) | composer3.changedInstance(animatable6);
            Object objRememberedValue5 = composer3.rememberedValue();
            if (zChangedInstance || objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                animatable = animatable6;
                str = "CC(remember):TicketsShareScreens.kt#9igjgp";
                animatable2 = animatable5;
                continuation = null;
                animatable3 = animatable4;
                ticketsShareScreensKt$NfcShareAnimatedArtwork$1$1 = new TicketsShareScreensKt$NfcShareAnimatedArtwork$1$1(z2, animatable3, animatable2, animatable, null);
                composer3.updateRememberedValue(ticketsShareScreensKt$NfcShareAnimatedArtwork$1$1);
            } else {
                animatable = animatable6;
                animatable3 = animatable4;
                ticketsShareScreensKt$NfcShareAnimatedArtwork$1$1 = objRememberedValue5;
                animatable2 = animatable5;
                str = "CC(remember):TicketsShareScreens.kt#9igjgp";
                continuation = null;
            }
            ComposerKt.sourceInformationMarkerEnd(composer3);
            EffectsKt.LaunchedEffect(boolValueOf, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) ticketsShareScreensKt$NfcShareAnimatedArtwork$1$1, composer3, (i3 >> 3) & 14);
            Boolean boolValueOf2 = Boolean.valueOf(z);
            ComposerKt.sourceInformationMarkerStart(composer3, 900110007, str);
            int i4 = i3 & 14;
            boolean z4 = i4 == 4;
            TicketsShareScreensKt$NfcShareAnimatedArtwork$2$1 ticketsShareScreensKt$NfcShareAnimatedArtwork$2$1RememberedValue = composer3.rememberedValue();
            if (z4 || ticketsShareScreensKt$NfcShareAnimatedArtwork$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                ticketsShareScreensKt$NfcShareAnimatedArtwork$2$1RememberedValue = new TicketsShareScreensKt$NfcShareAnimatedArtwork$2$1(z, mutableFloatState, continuation);
                composer3.updateRememberedValue(ticketsShareScreensKt$NfcShareAnimatedArtwork$2$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer3);
            EffectsKt.LaunchedEffect(boolValueOf2, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) ticketsShareScreensKt$NfcShareAnimatedArtwork$2$1RememberedValue, composer3, i4);
            final float fCoerceIn = RangesKt.coerceIn(((Number) animatable3.getValue()).floatValue(), 0.0f, 1.0f);
            final float fCoerceIn2 = RangesKt.coerceIn(((Number) animatable2.getValue()).floatValue(), 0.0f, 1.0f);
            float fCoerceIn3 = RangesKt.coerceIn(((Number) animatable.getValue()).floatValue(), 0.0f, 1.0f);
            Modifier.Companion companionFillMaxSize$default = z ? SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, continuation) : Modifier.INSTANCE;
            Alignment.Horizontal centerHorizontally = Alignment.INSTANCE.getCenterHorizontally();
            ComposerKt.sourceInformationMarkerStart(composer3, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), centerHorizontally, composer3, 48);
            ComposerKt.sourceInformationMarkerStart(composer3, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer3, 0));
            CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer3, companionFillMaxSize$default);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)410@16216L9:Composables.kt#9igjgp");
            if (!(composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer3.startReusableNode();
            if (composer3.getInserting()) {
                composer3.createNode(constructor);
            } else {
                composer3.useNode();
            }
            Composer composerM4937constructorimpl = Updater.m4937constructorimpl(composer3);
            Updater.m4945setimpl(composerM4937constructorimpl, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m4945setimpl(composerM4937constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m4945setimpl(composerM4937constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m4943reconcileimpl(composerM4937constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m4945setimpl(composerM4937constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer3, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer3, 929743217, "C:TicketsShareScreens.kt#n9ob9m");
            if (z || z2) {
                if (!z) {
                    composer3.startReplaceGroup(932925738);
                    ComposerKt.sourceInformation(composer3, "1798@64111L72,1799@64196L31");
                    TicketNfcContactRippleEffectLocal(fCoerceIn3, SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), composer3, 48, 0);
                    SpacerKt.Spacer(SizeKt.m1476height3ABfNKs(Modifier.INSTANCE, Dp.m8748constructorimpl(330.0f)), composer3, 6);
                    composer3.endReplaceGroup();
                } else {
                    composer3.startReplaceGroup(933100702);
                    ComposerKt.sourceInformation(composer3, "1802@64307L1038");
                    Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                    ComposerKt.sourceInformationMarkerStart(composer3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                    ComposerKt.sourceInformationMarkerStart(composer3, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
                    int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer3, 0));
                    CompositionLocalMap currentCompositionLocalMap2 = composer3.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer3, modifierFillMaxSize$default);
                    Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                    ComposerKt.sourceInformationMarkerStart(composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)410@16216L9:Composables.kt#9igjgp");
                    if (!(composer3.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composer3.startReusableNode();
                    if (composer3.getInserting()) {
                        composer3.createNode(constructor2);
                    } else {
                        composer3.useNode();
                    }
                    Composer composerM4937constructorimpl2 = Updater.m4937constructorimpl(composer3);
                    Updater.m4945setimpl(composerM4937constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m4945setimpl(composerM4937constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Updater.m4945setimpl(composerM4937constructorimpl2, Integer.valueOf(iHashCode2), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                    Updater.m4943reconcileimpl(composerM4937constructorimpl2, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                    Updater.m4945setimpl(composerM4937constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composer3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composer3, 1533220347, "C1803@64353L193,1809@64564L767:TicketsShareScreens.kt#n9ob9m");
                    TicketTransferBeamEffectKt.TicketTransferBeamEffect(TicketBeamMode.SEND, NfcShareAnimatedArtwork$lambda$218(stateAnimateFloatAsState), SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), composer3, 390, 0);
                    composer3 = composer3;
                    Modifier modifierFillMaxSize$default2 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                    Alignment center = Alignment.INSTANCE.getCenter();
                    ComposerKt.sourceInformationMarkerStart(composer3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
                    ComposerKt.sourceInformationMarkerStart(composer3, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
                    int iHashCode3 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer3, 0));
                    CompositionLocalMap currentCompositionLocalMap3 = composer3.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composer3, modifierFillMaxSize$default2);
                    Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                    ComposerKt.sourceInformationMarkerStart(composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)410@16216L9:Composables.kt#9igjgp");
                    if (!(composer3.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composer3.startReusableNode();
                    if (composer3.getInserting()) {
                        composer3.createNode(constructor3);
                    } else {
                        composer3.useNode();
                    }
                    Composer composerM4937constructorimpl3 = Updater.m4937constructorimpl(composer3);
                    Updater.m4945setimpl(composerM4937constructorimpl3, measurePolicyMaybeCachedBoxMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m4945setimpl(composerM4937constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Updater.m4945setimpl(composerM4937constructorimpl3, Integer.valueOf(iHashCode3), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                    Updater.m4943reconcileimpl(composerM4937constructorimpl3, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                    Updater.m4945setimpl(composerM4937constructorimpl3, modifierMaterializeModifier3, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composer3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composer3, -46592661, "C:TicketsShareScreens.kt#n9ob9m");
                    if (!z3) {
                        composer3.startReplaceGroup(-46585997);
                        ComposerKt.sourceInformation(composer3, "1814@64754L163");
                        ColorOsSendTicketFlight(list, function0, composer3, (i3 >> 9) & 126);
                        composer3.endReplaceGroup();
                        function4 = function1;
                        function3 = function2;
                    } else if (!list.isEmpty()) {
                        composer3.startReplaceGroup(-46343360);
                        ComposerKt.sourceInformation(composer3, "1819@64997L214");
                        int i5 = i3 >> 12;
                        function4 = function1;
                        function3 = function2;
                        ColorOsReceiveTicketArrival(list, function4, function3, composer3, ((i3 >> 9) & 14) | (i5 & StylePropertiesKt.TextDirectionMask) | (i5 & 896));
                        composer3.endReplaceGroup();
                    } else {
                        function4 = function1;
                        function3 = function2;
                        composer3.startReplaceGroup(-46083332);
                        ComposerKt.sourceInformation(composer3, "1825@65265L26");
                        WaitingReceiveTicketCard(composer3, 0);
                        composer3.endReplaceGroup();
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    composer3.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    composer3.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    composer3.endReplaceGroup();
                }
                if (z && !z2) {
                    composer3.startReplaceGroup(934240758);
                    ComposerKt.sourceInformation(composer3, "1833@65436L93,1834@65546L29,1835@65592L100");
                    composer2 = composer3;
                    TextKt.m3661TextNvy7gAk("请将两部手机贴近彼此", null, ColorKt.Color(4293585647L), null, TextUnitKt.getSp(14), null, null, null, 0L, null, TextAlign.m8619boximpl(TextAlign.INSTANCE.m8626getCentere0LSkKk()), 0L, 0, false, 0, 0, null, null, composer2, 24966, 0, 261098);
                    SpacerKt.Spacer(SizeKt.m1476height3ABfNKs(Modifier.INSTANCE, Dp.m8748constructorimpl(8.0f)), composer2, 6);
                    TextKt.m3661TextNvy7gAk("手机顶部轻触即可建立 NFC 连接", null, ColorKt.Color(4285756282L), null, TextUnitKt.getSp(11), null, null, null, 0L, null, TextAlign.m8619boximpl(TextAlign.INSTANCE.m8626getCentere0LSkKk()), 0L, 0, false, 0, 0, null, null, composer2, 24966, 0, 261098);
                    composer2.endReplaceGroup();
                } else if (!z) {
                    composer3.startReplaceGroup(934548402);
                    ComposerKt.sourceInformation(composer3, "1838@65751L100");
                    composer2 = composer3;
                    TextKt.m3661TextNvy7gAk("NFC 已感应，正在建立安全传输…", null, ColorKt.Color(4293585647L), null, TextUnitKt.getSp(14), null, null, null, 0L, null, TextAlign.m8619boximpl(TextAlign.INSTANCE.m8626getCentere0LSkKk()), 0L, 0, false, 0, 0, null, null, composer2, 24966, 0, 261098);
                    composer2.endReplaceGroup();
                } else {
                    composer3.startReplaceGroup(934704549);
                    ComposerKt.sourceInformation(composer3, "1841@65904L241");
                    if (z3 || !list.isEmpty()) {
                        str2 = "票据传输";
                    } else {
                        str2 = "等待对方发送票据…";
                    }
                    composer2 = composer3;
                    TextKt.m3661TextNvy7gAk(str2, null, ColorKt.Color(4293585647L), null, TextUnitKt.getSp(14), null, null, null, 0L, null, TextAlign.m8619boximpl(TextAlign.INSTANCE.m8626getCentere0LSkKk()), 0L, 0, false, 0, 0, null, null, composer2, 24960, 0, 261098);
                    composer2.endReplaceGroup();
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                composer3.startReplaceGroup(929712898);
                ComposerKt.sourceInformation(composer3, "1741@60773L3292");
                Modifier modifierM1476height3ABfNKs = SizeKt.m1476height3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m8748constructorimpl(330.0f));
                Alignment topCenter = Alignment.INSTANCE.getTopCenter();
                ComposerKt.sourceInformationMarkerStart(composer3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(topCenter, false);
                ComposerKt.sourceInformationMarkerStart(composer3, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
                int iHashCode4 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer3, 0));
                CompositionLocalMap currentCompositionLocalMap4 = composer3.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composer3, modifierM1476height3ABfNKs);
                Function0<ComposeUiNode> constructor4 = ComposeUiNode.INSTANCE.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)410@16216L9:Composables.kt#9igjgp");
                if (!(composer3.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composer3.startReusableNode();
                if (composer3.getInserting()) {
                    composer3.createNode(constructor4);
                } else {
                    composer3.useNode();
                }
                Composer composerM4937constructorimpl4 = Updater.m4937constructorimpl(composer3);
                Updater.m4945setimpl(composerM4937constructorimpl4, measurePolicyMaybeCachedBoxMeasurePolicy3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m4945setimpl(composerM4937constructorimpl4, currentCompositionLocalMap4, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Updater.m4945setimpl(composerM4937constructorimpl4, Integer.valueOf(iHashCode4), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                Updater.m4943reconcileimpl(composerM4937constructorimpl4, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                Updater.m4945setimpl(composerM4937constructorimpl4, modifierMaterializeModifier4, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composer3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance3 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composer3, -172892122, "C1747@60994L3057,1747@60963L3088:TicketsShareScreens.kt#n9ob9m");
                Modifier modifierFillMaxSize$default3 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                ComposerKt.sourceInformationMarkerStart(composer3, -1806691522, str);
                boolean zChanged = composer3.changed(fCoerceIn) | composer3.changed(fCoerceIn2);
                Object objRememberedValue6 = composer3.rememberedValue();
                if (zChanged || objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue6 = new Function1() { // from class: com.example.tickets.TicketsShareScreensKt$$ExternalSyntheticLambda46
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return TicketsShareScreensKt.NfcShareAnimatedArtwork$lambda$228$lambda$225$lambda$224$lambda$223(fCoerceIn, fCoerceIn2, (DrawScope) obj);
                        }
                    };
                    composer3.updateRememberedValue(objRememberedValue6);
                }
                ComposerKt.sourceInformationMarkerEnd(composer3);
                CanvasKt.Canvas(modifierFillMaxSize$default3, (Function1) objRememberedValue6, composer3, 6);
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerEnd(composer3);
                composer3.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerEnd(composer3);
                composer3.endReplaceGroup();
            }
            function4 = function1;
            function3 = function2;
            if (z) {
                if (!z) {
                    composer3.startReplaceGroup(934548402);
                    ComposerKt.sourceInformation(composer3, "1838@65751L100");
                    composer2 = composer3;
                    TextKt.m3661TextNvy7gAk("NFC 已感应，正在建立安全传输…", null, ColorKt.Color(4293585647L), null, TextUnitKt.getSp(14), null, null, null, 0L, null, TextAlign.m8619boximpl(TextAlign.INSTANCE.m8626getCentere0LSkKk()), 0L, 0, false, 0, 0, null, null, composer2, 24966, 0, 261098);
                    composer2.endReplaceGroup();
                } else {
                    composer3.startReplaceGroup(934704549);
                    ComposerKt.sourceInformation(composer3, "1841@65904L241");
                    if (z3) {
                        str2 = "票据传输";
                    } else {
                        str2 = "票据传输";
                    }
                    composer2 = composer3;
                    TextKt.m3661TextNvy7gAk(str2, null, ColorKt.Color(4293585647L), null, TextUnitKt.getSp(14), null, null, null, 0L, null, TextAlign.m8619boximpl(TextAlign.INSTANCE.m8626getCentere0LSkKk()), 0L, 0, false, 0, 0, null, null, composer2, 24960, 0, 261098);
                    composer2.endReplaceGroup();
                }
            } else if (!z) {
                composer3.startReplaceGroup(934548402);
                ComposerKt.sourceInformation(composer3, "1838@65751L100");
                composer2 = composer3;
                TextKt.m3661TextNvy7gAk("NFC 已感应，正在建立安全传输…", null, ColorKt.Color(4293585647L), null, TextUnitKt.getSp(14), null, null, null, 0L, null, TextAlign.m8619boximpl(TextAlign.INSTANCE.m8626getCentere0LSkKk()), 0L, 0, false, 0, 0, null, null, composer2, 24966, 0, 261098);
                composer2.endReplaceGroup();
            } else {
                composer3.startReplaceGroup(934704549);
                ComposerKt.sourceInformation(composer3, "1841@65904L241");
                if (z3) {
                    str2 = "票据传输";
                } else {
                    str2 = "票据传输";
                }
                composer2 = composer3;
                TextKt.m3661TextNvy7gAk(str2, null, ColorKt.Color(4293585647L), null, TextUnitKt.getSp(14), null, null, null, 0L, null, TextAlign.m8619boximpl(TextAlign.INSTANCE.m8626getCentere0LSkKk()), 0L, 0, false, 0, 0, null, null, composer2, 24960, 0, 261098);
                composer2.endReplaceGroup();
            }
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Function0<Unit> function5 = function4;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.tickets.TicketsShareScreensKt$$ExternalSyntheticLambda47
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TicketsShareScreensKt.NfcShareAnimatedArtwork$lambda$229(z, z2, z3, list, function0, function5, function3, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final float NfcShareAnimatedArtwork$lambda$216(MutableFloatState mutableFloatState) {
        return mutableFloatState.getFloatValue();
    }

    private static final void ColorOsSendTicketFlight(List<TicketData> list, final Function0<Unit> function0, Composer composer, final int i) {
        int i2;
        MutableState mutableState;
        MutableState mutableState2;
        State<Float> state;
        TicketsShareScreensKt$ColorOsSendTicketFlight$2$1 ticketsShareScreensKt$ColorOsSendTicketFlight$2$1;
        final List<TicketData> list2 = list;
        function0 = function0;
        Composer composerStartRestartGroup = composer.startRestartGroup(-269944408);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ColorOsSendTicketFlight)N(tickets,onComplete)1857@66310L34,1858@66364L34,1859@66416L36,1860@66474L34,1861@66540L7,1863@66576L36,1864@66635L217,1875@66978L216,1884@67221L48,1884@67200L69,1889@67360L133,1889@67312L181,1941@69083L2138:TicketsShareScreens.kt#n9ob9m");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(list2) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function0) ? 32 : 16;
        }
        int i3 = i2;
        if (!composerStartRestartGroup.shouldExecute((i3 & 19) != 18, i3 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-269944408, i3, -1, "com.example.tickets.ColorOsSendTicketFlight (TicketsShareScreens.kt:1856)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1718534102, "CC(remember):TicketsShareScreens.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            MutableState mutableState3 = (MutableState) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1718532374, "CC(remember):TicketsShareScreens.kt#9igjgp");
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            MutableState mutableState4 = (MutableState) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1718530708, "CC(remember):TicketsShareScreens.kt#9igjgp");
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = PrimitiveSnapshotStateKt.mutableFloatStateOf(0.0f);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            MutableFloatState mutableFloatState = (MutableFloatState) objRememberedValue3;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1718528854, "CC(remember):TicketsShareScreens.kt#9igjgp");
            Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            MutableState mutableState5 = (MutableState) objRememberedValue4;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ProvidableCompositionLocal<Context> localContext = AndroidCompositionLocals_androidKt.getLocalContext();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composerStartRestartGroup.consume(localContext);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Context context = (Context) objConsume;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1718525588, "CC(remember):TicketsShareScreens.kt#9igjgp");
            Object objRememberedValue5 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue5 = PrimitiveSnapshotStateKt.mutableFloatStateOf(0.0f);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
            }
            MutableFloatState mutableFloatState2 = (MutableFloatState) objRememberedValue5;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            State<Float> stateAnimateFloatAsState = AnimateAsStateKt.animateFloatAsState(mutableFloatState2.getFloatValue(), AnimationSpecKt.spring$default(0.64f, 560.0f, null, 4, null), 0.0f, "send-card-duang", null, composerStartRestartGroup, 3120, 20);
            State<Float> stateAnimateFloatAsState2 = AnimateAsStateKt.animateFloatAsState(ColorOsSendTicketFlight$lambda$234(mutableState4) ? 1.0f : 0.0f, AnimationSpecKt.spring$default(0.7f, 420.0f, null, 4, null), 0.0f, "send-launch-spring", null, composerStartRestartGroup, 3120, 20);
            Unit unit = Unit.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1718504936, "CC(remember):TicketsShareScreens.kt#9igjgp");
            TicketsShareScreensKt$ColorOsSendTicketFlight$1$1 ticketsShareScreensKt$ColorOsSendTicketFlight$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (ticketsShareScreensKt$ColorOsSendTicketFlight$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                ticketsShareScreensKt$ColorOsSendTicketFlight$1$1RememberedValue = new TicketsShareScreensKt$ColorOsSendTicketFlight$1$1(mutableFloatState2, null);
                composerStartRestartGroup.updateRememberedValue(ticketsShareScreensKt$ColorOsSendTicketFlight$1$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.LaunchedEffect(unit, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) ticketsShareScreensKt$ColorOsSendTicketFlight$1$1RememberedValue, composerStartRestartGroup, 6);
            Boolean boolValueOf = Boolean.valueOf(ColorOsSendTicketFlight$lambda$234(mutableState4));
            Float fValueOf = Float.valueOf(ColorOsSendTicketFlight$lambda$244(stateAnimateFloatAsState2));
            Boolean boolValueOf2 = Boolean.valueOf(ColorOsSendTicketFlight$lambda$240(mutableState5));
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1718500403, "CC(remember):TicketsShareScreens.kt#9igjgp");
            boolean zChanged = ((i3 & StylePropertiesKt.TextDirectionMask) == 32) | composerStartRestartGroup.changed(stateAnimateFloatAsState2);
            Object objRememberedValue6 = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                mutableState = mutableState3;
                mutableState2 = mutableState4;
                state = stateAnimateFloatAsState2;
                ticketsShareScreensKt$ColorOsSendTicketFlight$2$1 = new TicketsShareScreensKt$ColorOsSendTicketFlight$2$1(function0, mutableState4, mutableState5, stateAnimateFloatAsState2, null);
                composerStartRestartGroup.updateRememberedValue(ticketsShareScreensKt$ColorOsSendTicketFlight$2$1);
            } else {
                state = stateAnimateFloatAsState2;
                ticketsShareScreensKt$ColorOsSendTicketFlight$2$1 = objRememberedValue6;
                mutableState = mutableState3;
                mutableState2 = mutableState4;
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.LaunchedEffect(boolValueOf, fValueOf, boolValueOf2, (Function2) ticketsShareScreensKt$ColorOsSendTicketFlight$2$1, composerStartRestartGroup, 0);
            float fCoerceIn = RangesKt.coerceIn((-ColorOsSendTicketFlight$lambda$237(mutableFloatState)) / 190.0f, r18, 0.82f);
            float fCoerceIn2 = RangesKt.coerceIn(ColorOsSendTicketFlight$lambda$244(state), r18, 1.0f);
            if (!ColorOsSendTicketFlight$lambda$231(mutableState)) {
                fCoerceIn = ColorOsSendTicketFlight$lambda$234(mutableState2) ? fCoerceIn2 : 0.0f;
            }
            float fLaunchSmoothStep = launchSmoothStep(r18, 0.16f, fCoerceIn2);
            float fLaunchSmoothStep2 = launchSmoothStep(0.16f, 0.3f, fCoerceIn2);
            float fLaunchSmoothStep3 = launchSmoothStep(0.12f, 1.0f, fCoerceIn2);
            final float fCoerceIn3 = RangesKt.coerceIn(fLaunchSmoothStep * (1.0f - fLaunchSmoothStep2), r18, 1.0f);
            float fCoerceIn4 = RangesKt.coerceIn(((((float) Math.sin(((double) ColorOsSendTicketFlight$lambda$243(stateAnimateFloatAsState)) * 3.141592653589793d)) * 0.02f) + 1.0f) - (fCoerceIn3 * 0.012f), 0.975f, 1.025f);
            if (ColorOsSendTicketFlight$lambda$234(mutableState2)) {
                fCoerceIn4 = RangesKt.coerceAtLeast(fCoerceIn4 * (((1.0f - (fCoerceIn3 * 0.04f)) - (0.1f * fLaunchSmoothStep3)) - ((0.21f * fLaunchSmoothStep3) * fLaunchSmoothStep3)), 0.24f);
            }
            final float f = fCoerceIn4;
            float f2 = 130.0f;
            if (ColorOsSendTicketFlight$lambda$234(mutableState2)) {
                f2 = ((fCoerceIn3 * 14.0f) + 130.0f) - ((((620.0f * fLaunchSmoothStep3) * fLaunchSmoothStep3) * fLaunchSmoothStep3) * 0.92f);
            }
            final float f3 = f2;
            final float f4 = ColorOsSendTicketFlight$lambda$234(mutableState2) ? (-7.5f) * fLaunchSmoothStep3 : r18;
            float fSin = ColorOsSendTicketFlight$lambda$234(mutableState2) ? ((float) Math.sin(((double) fLaunchSmoothStep3) * 3.141592653589793d)) * 3.2f : r18;
            float fCoerceIn5 = ColorOsSendTicketFlight$lambda$234(mutableState2) ? RangesKt.coerceIn(1.0f - RangesKt.coerceIn((fLaunchSmoothStep3 - 0.68f) / 0.32f, r18, 1.0f), r18, 1.0f) : 1.0f;
            Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.INSTANCE, r18, 1, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxSize$default);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)410@16216L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM4937constructorimpl = Updater.m4937constructorimpl(composerStartRestartGroup);
            Updater.m4945setimpl(composerM4937constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m4945setimpl(composerM4937constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m4945setimpl(composerM4937constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m4943reconcileimpl(composerM4937constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m4945setimpl(composerM4937constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1516419481, "C1942@69121L135,1952@69420L349,1961@69809L1030,1948@69266L1616:TicketsShareScreens.kt#n9ob9m");
            final float f5 = fCoerceIn5;
            final float f6 = fSin;
            LiquidFusionTransferGlow(fCoerceIn, true, SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), composerStartRestartGroup, 432, 0);
            float fM8748constructorimpl = Dp.m8748constructorimpl(22.0f);
            Modifier.Companion companion = Modifier.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1613659051, "CC(remember):TicketsShareScreens.kt#9igjgp");
            boolean zChanged2 = composerStartRestartGroup.changed(f5) | composerStartRestartGroup.changed(f3) | composerStartRestartGroup.changed(f) | composerStartRestartGroup.changed(fCoerceIn3) | composerStartRestartGroup.changed(f4) | composerStartRestartGroup.changed(f6);
            Object objRememberedValue7 = composerStartRestartGroup.rememberedValue();
            if (zChanged2 || objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue7 = new Function1() { // from class: com.example.tickets.TicketsShareScreensKt$$ExternalSyntheticLambda36
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return TicketsShareScreensKt.ColorOsSendTicketFlight$lambda$250$lambda$248$lambda$247(f5, f3, f, fCoerceIn3, f4, f6, (GraphicsLayerScope) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierGraphicsLayer = GraphicsLayerModifierKt.graphicsLayer(companion, (Function1) objRememberedValue7);
            Boolean boolValueOf3 = Boolean.valueOf(ColorOsSendTicketFlight$lambda$234(mutableState2));
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1613672180, "CC(remember):TicketsShareScreens.kt#9igjgp");
            boolean zChangedInstance = composerStartRestartGroup.changedInstance(r21);
            TicketsShareScreensKt$ColorOsSendTicketFlight$3$2$1 ticketsShareScreensKt$ColorOsSendTicketFlight$3$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || ticketsShareScreensKt$ColorOsSendTicketFlight$3$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                ticketsShareScreensKt$ColorOsSendTicketFlight$3$2$1RememberedValue = new TicketsShareScreensKt$ColorOsSendTicketFlight$3$2$1(mutableState2, context, mutableState, mutableFloatState);
                composerStartRestartGroup.updateRememberedValue(ticketsShareScreensKt$ColorOsSendTicketFlight$3$2$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            list2 = list;
            m9318TicketTransferTicketCardRfXq3Jk(list2, fM8748constructorimpl, SuspendingPointerInputFilterKt.pointerInput(modifierGraphicsLayer, boolValueOf3, (PointerInputEventHandler) ticketsShareScreensKt$ColorOsSendTicketFlight$3$2$1RememberedValue), false, null, null, composerStartRestartGroup, (i3 & 14) | 3120, 48);
            composerStartRestartGroup = composerStartRestartGroup;
            if (ColorOsSendTicketFlight$lambda$234(mutableState2)) {
                composerStartRestartGroup.startReplaceGroup(-1585053420);
            } else {
                composerStartRestartGroup.startReplaceGroup(-1514704097);
                ComposerKt.sourceInformation(composerStartRestartGroup, "1989@70920L285");
                String str = ColorOsSendTicketFlight$lambda$231(mutableState) ? "继续上滑发送" : "↑ 上滑发送票据";
                TextKt.m3661TextNvy7gAk(str, PaddingKt.m1427paddingqDBjuR0$default(boxScopeInstance.align(Modifier.INSTANCE, Alignment.INSTANCE.getBottomCenter()), 0.0f, 0.0f, 0.0f, Dp.m8748constructorimpl(75.0f), 7, null), Color.INSTANCE.m5875getWhite0d7_KjU(), null, TextUnitKt.getSp(15), null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composerStartRestartGroup, 24960, 0, 262120);
                composerStartRestartGroup = composerStartRestartGroup;
            }
            composerStartRestartGroup.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.tickets.TicketsShareScreensKt$$ExternalSyntheticLambda37
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TicketsShareScreensKt.ColorOsSendTicketFlight$lambda$251(list2, function0, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final boolean ColorOsSendTicketFlight$lambda$231(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ColorOsSendTicketFlight$lambda$232(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean ColorOsSendTicketFlight$lambda$234(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ColorOsSendTicketFlight$lambda$235(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float ColorOsSendTicketFlight$lambda$237(MutableFloatState mutableFloatState) {
        return mutableFloatState.getFloatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean ColorOsSendTicketFlight$lambda$240(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ColorOsSendTicketFlight$lambda$241(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    static final Unit ColorOsSendTicketFlight$lambda$250$lambda$248$lambda$247(float f, float f2, float f3, float f4, float f5, float f6, GraphicsLayerScope graphicsLayer) {
        Intrinsics.checkNotNullParameter(graphicsLayer, "$this$graphicsLayer");
        graphicsLayer.setAlpha(f);
        graphicsLayer.setTranslationY(graphicsLayer.mo803toPx0680j_4(Dp.m8748constructorimpl(f2)));
        graphicsLayer.setScaleX(f3);
        graphicsLayer.setScaleY(f3 * ((f4 * 0.02f) + 1.0f));
        graphicsLayer.setRotationX(f5);
        graphicsLayer.setRotationY(f6);
        graphicsLayer.setCameraDistance(graphicsLayer.get_density() * 38.0f);
        return Unit.INSTANCE;
    }

    private static final float launchSmoothStep(float f, float f2, float f3) {
        float fCoerceIn = RangesKt.coerceIn((f3 - f) / (f2 - f), 0.0f, 1.0f);
        return fCoerceIn * fCoerceIn * (3.0f - (fCoerceIn * 2.0f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void performNativeSendHaptic(Context context) {
        Vibrator defaultVibrator;
        try {
            if (Build.VERSION.SDK_INT >= 31) {
                VibratorManager vibratorManagerM9298m = MainActivity$$ExternalSyntheticApiModelOutline0.m9298m(context.getSystemService(MainActivity$$ExternalSyntheticApiModelOutline0.m()));
                if (vibratorManagerM9298m == null || (defaultVibrator = vibratorManagerM9298m.getDefaultVibrator()) == null) {
                    return;
                }
                defaultVibrator.vibrate(VibrationEffect.createOneShot(24L, -1));
                return;
            }
            Object systemService = context.getSystemService("vibrator");
            Vibrator vibrator = systemService instanceof Vibrator ? (Vibrator) systemService : null;
            if (vibrator == null || !vibrator.hasVibrator()) {
                return;
            }
            vibrator.vibrate(24L);
        } catch (Throwable unused) {
        }
    }

    private static final void WaitingReceiveTicketCard(Composer composer, final int i) {
        Composer composer2;
        Composer composerStartRestartGroup = composer.startRestartGroup(1841296373);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(WaitingReceiveTicketCard)2034@72368L870:TicketsShareScreens.kt#n9ob9m");
        if (!composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1841296373, i, -1, "com.example.tickets.WaitingReceiveTicketCard (TicketsShareScreens.kt:2033)");
            }
            Modifier modifierM1424paddingVpY3zN4 = PaddingKt.m1424paddingVpY3zN4(BorderKt.m659borderxT4_qwU(BackgroundKt.m648backgroundbw27NRU$default(ClipKt.clip(SizeKt.m1476height3ABfNKs(SizeKt.m1495width3ABfNKs(Modifier.INSTANCE, Dp.m8748constructorimpl(380.0f)), Dp.m8748constructorimpl(270.0f)), RoundedCornerShapeKt.m1756RoundedCornerShape0680j_4(Dp.m8748constructorimpl(30.0f))), ColorKt.Color(4279505942L), null, 2, null), Dp.m8748constructorimpl(1.0f), Color.m5837copywmQWz5c$default(Color.INSTANCE.m5875getWhite0d7_KjU(), 0.1f, 0.0f, 0.0f, 0.0f, 14, null), RoundedCornerShapeKt.m1756RoundedCornerShape0680j_4(Dp.m8748constructorimpl(30.0f))), Dp.m8748constructorimpl(24.0f), Dp.m8748constructorimpl(22.0f));
            Alignment.Horizontal centerHorizontally = Alignment.INSTANCE.getCenterHorizontally();
            Arrangement.HorizontalOrVertical center = Arrangement.INSTANCE.getCenter();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(center, centerHorizontally, composerStartRestartGroup, 54);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1424paddingVpY3zN4);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)410@16216L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM4937constructorimpl = Updater.m4937constructorimpl(composerStartRestartGroup);
            Updater.m4945setimpl(composerM4937constructorimpl, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m4945setimpl(composerM4937constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m4945setimpl(composerM4937constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m4943reconcileimpl(composerM4937constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m4945setimpl(composerM4937constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -72063292, "C2049@72880L141,2055@73030L30,2056@73069L163:TicketsShareScreens.kt#n9ob9m");
            composer2 = composerStartRestartGroup;
            TextKt.m3661TextNvy7gAk("等待票据", null, Color.INSTANCE.m5875getWhite0d7_KjU(), null, TextUnitKt.getSp(22), null, FontWeight.INSTANCE.getMedium(), null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer2, 1597830, 0, 262058);
            SpacerKt.Spacer(SizeKt.m1476height3ABfNKs(Modifier.INSTANCE, Dp.m8748constructorimpl(10.0f)), composer2, 6);
            TextKt.m3661TextNvy7gAk("发送方上滑票据后，票据会从顶部摄像头区域飞入", null, ColorKt.Color(4286940556L), null, TextUnitKt.getSp(13), null, null, null, 0L, null, TextAlign.m8619boximpl(TextAlign.INSTANCE.m8626getCentere0LSkKk()), 0L, 0, false, 0, 0, null, null, composer2, 24966, 0, 261098);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.tickets.TicketsShareScreensKt$$ExternalSyntheticLambda69
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TicketsShareScreensKt.WaitingReceiveTicketCard$lambda$253(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final void ColorOsReceiveTicketArrival(List<TicketData> list, Function0<Unit> function0, Function0<Unit> function1, Composer composer, final int i) {
        int i2;
        final Function0<Unit> function2;
        final Function0<Unit> function3;
        String str;
        Animatable animatable;
        Object obj;
        final MutableState mutableState;
        TicketsShareScreensKt$ColorOsReceiveTicketArrival$2$1 ticketsShareScreensKt$ColorOsReceiveTicketArrival$2$1;
        final List<TicketData> list2 = list;
        Composer composerStartRestartGroup = composer.startRestartGroup(-411901502);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ColorOsReceiveTicketArrival)N(tickets,onAccept,onReject)2071@73403L36,2076@73574L155,2081@73753L36,2086@73926L155,2091@74101L34,2092@74156L33,2093@74205L27,2095@74262L343,2095@74238L367,2108@74635L193,2108@74611L217,2123@75153L1194:TicketsShareScreens.kt#n9ob9m");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(list2) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function0) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function1) ? 256 : 128;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 147) != 146, i2 & 1)) {
            function2 = function0;
            function3 = function1;
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-411901502, i2, -1, "com.example.tickets.ColorOsReceiveTicketArrival (TicketsShareScreens.kt:2070)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -700347002, "CC(remember):TicketsShareScreens.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = PrimitiveSnapshotStateKt.mutableFloatStateOf(0.0f);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            MutableFloatState mutableFloatState = (MutableFloatState) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            State<Float> stateAnimateFloatAsState = AnimateAsStateKt.animateFloatAsState(mutableFloatState.getFloatValue(), AnimationSpecKt.spring$default(0.74f, 520.0f, null, 4, null), 0.0f, "receive-card-arrival", null, composerStartRestartGroup, 3120, 20);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -700335802, "CC(remember):TicketsShareScreens.kt#9igjgp");
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = PrimitiveSnapshotStateKt.mutableFloatStateOf(0.0f);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            MutableFloatState mutableFloatState2 = (MutableFloatState) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            State<Float> stateAnimateFloatAsState2 = AnimateAsStateKt.animateFloatAsState(mutableFloatState2.getFloatValue(), AnimationSpecKt.spring$default(0.8f, 620.0f, null, 4, null), 0.0f, "receive-card-duang", null, composerStartRestartGroup, 3120, 20);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -700324668, "CC(remember):TicketsShareScreens.kt#9igjgp");
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            final MutableState mutableState2 = (MutableState) objRememberedValue3;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -700322909, "CC(remember):TicketsShareScreens.kt#9igjgp");
            Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(true, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            MutableState mutableState3 = (MutableState) objRememberedValue4;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -700321347, "CC(remember):TicketsShareScreens.kt#9igjgp");
            Object objRememberedValue5 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue5 = AnimatableKt.Animatable$default(0.0f, 0.0f, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
            }
            Animatable animatable2 = (Animatable) objRememberedValue5;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -700319207, "CC(remember):TicketsShareScreens.kt#9igjgp");
            boolean zChangedInstance = composerStartRestartGroup.changedInstance(list2);
            TicketsShareScreensKt$ColorOsReceiveTicketArrival$1$1 ticketsShareScreensKt$ColorOsReceiveTicketArrival$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || ticketsShareScreensKt$ColorOsReceiveTicketArrival$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                ticketsShareScreensKt$ColorOsReceiveTicketArrival$1$1RememberedValue = new TicketsShareScreensKt$ColorOsReceiveTicketArrival$1$1(list2, mutableFloatState, mutableFloatState2, null);
                composerStartRestartGroup.updateRememberedValue(ticketsShareScreensKt$ColorOsReceiveTicketArrival$1$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            int i3 = i2 & 14;
            EffectsKt.LaunchedEffect(list2, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) ticketsShareScreensKt$ColorOsReceiveTicketArrival$1$1RememberedValue, composerStartRestartGroup, i3);
            Boolean boolValueOf = Boolean.valueOf(ColorOsReceiveTicketArrival$lambda$259(mutableState2));
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -700307421, "CC(remember):TicketsShareScreens.kt#9igjgp");
            boolean zChangedInstance2 = composerStartRestartGroup.changedInstance(animatable2) | ((i2 & StylePropertiesKt.TextDirectionMask) == 32) | ((i2 & 896) == 256);
            Object objRememberedValue6 = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance2 || objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                str = "CC(remember):TicketsShareScreens.kt#9igjgp";
                animatable = animatable2;
                obj = null;
                function2 = function0;
                mutableState = mutableState3;
                ticketsShareScreensKt$ColorOsReceiveTicketArrival$2$1 = new TicketsShareScreensKt$ColorOsReceiveTicketArrival$2$1(animatable, function0, function1, mutableState2, mutableState3, null);
                composerStartRestartGroup.updateRememberedValue(ticketsShareScreensKt$ColorOsReceiveTicketArrival$2$1);
            } else {
                ticketsShareScreensKt$ColorOsReceiveTicketArrival$2$1 = objRememberedValue6;
                animatable = animatable2;
                function2 = function0;
                str = "CC(remember):TicketsShareScreens.kt#9igjgp";
                mutableState = mutableState3;
                obj = null;
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.LaunchedEffect(boolValueOf, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) ticketsShareScreensKt$ColorOsReceiveTicketArrival$2$1, composerStartRestartGroup, 0);
            final float fCoerceIn = RangesKt.coerceIn(ColorOsReceiveTicketArrival$lambda$255(stateAnimateFloatAsState), 0.0f, 1.0f);
            final float f = (fCoerceIn * 520.0f) - 520.0f;
            final float f2 = (0.58f * fCoerceIn) + 0.42f;
            final float fColorOsReceiveTicketArrival$lambda$257 = (ColorOsReceiveTicketArrival$lambda$257(stateAnimateFloatAsState2) * 0.1f) + 1.0f;
            float f3 = 1.0f - fCoerceIn;
            final float f4 = f3 * 18.0f;
            final float f5 = f3 * (-10.0f);
            final float fCoerceIn2 = RangesKt.coerceIn(((Number) animatable.getValue()).floatValue(), 0.0f, 1.0f);
            Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, obj);
            Alignment center = Alignment.INSTANCE.getCenter();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxSize$default);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)410@16216L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM4937constructorimpl = Updater.m4937constructorimpl(composerStartRestartGroup);
            Updater.m4945setimpl(composerM4937constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m4945setimpl(composerM4937constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m4945setimpl(composerM4937constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m4943reconcileimpl(composerM4937constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m4945setimpl(composerM4937constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1246751682, "C2124@75228L145,2133@75542L434,2144@76033L136,2150@76194L137,2130@75383L958:TicketsShareScreens.kt#n9ob9m");
            LiquidFusionTransferGlow(fCoerceIn, false, SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), composerStartRestartGroup, 432, 0);
            float fM8748constructorimpl = Dp.m8748constructorimpl((fCoerceIn * 18.0f) + 22.0f);
            Modifier.Companion companion = Modifier.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1010058490, str);
            boolean zChanged = composerStartRestartGroup.changed(f) | composerStartRestartGroup.changed(fCoerceIn) | composerStartRestartGroup.changed(f2) | composerStartRestartGroup.changed(fColorOsReceiveTicketArrival$lambda$257) | composerStartRestartGroup.changed(f4) | composerStartRestartGroup.changed(f5) | composerStartRestartGroup.changed(fCoerceIn2);
            Object objRememberedValue7 = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue7 = new Function1() { // from class: com.example.tickets.TicketsShareScreensKt$$ExternalSyntheticLambda41
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return TicketsShareScreensKt.ColorOsReceiveTicketArrival$lambda$273$lambda$268$lambda$267(f, fCoerceIn, f2, fColorOsReceiveTicketArrival$lambda$257, f4, f5, fCoerceIn2, mutableState2, (GraphicsLayerScope) obj2);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierGraphicsLayer = GraphicsLayerModifierKt.graphicsLayer(companion, (Function1) objRememberedValue7);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1010073904, str);
            Object objRememberedValue8 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue8 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue8 = new Function0() { // from class: com.example.tickets.TicketsShareScreensKt$$ExternalSyntheticLambda42
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return TicketsShareScreensKt.ColorOsReceiveTicketArrival$lambda$273$lambda$270$lambda$269(mutableState2, mutableState);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
            }
            Function0 function4 = (Function0) objRememberedValue8;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1010079057, str);
            Object objRememberedValue9 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue9 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue9 = new Function0() { // from class: com.example.tickets.TicketsShareScreensKt$$ExternalSyntheticLambda43
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return TicketsShareScreensKt.ColorOsReceiveTicketArrival$lambda$273$lambda$272$lambda$271(mutableState2, mutableState);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue9);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            function3 = function1;
            list2 = list;
            m9318TicketTransferTicketCardRfXq3Jk(list2, fM8748constructorimpl, modifierGraphicsLayer, true, function4, (Function0) objRememberedValue9, composerStartRestartGroup, i3 | 224256, 0);
            composerStartRestartGroup = composerStartRestartGroup;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.tickets.TicketsShareScreensKt$$ExternalSyntheticLambda45
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    return TicketsShareScreensKt.ColorOsReceiveTicketArrival$lambda$274(list2, function2, function3, i, (Composer) obj2, ((Integer) obj3).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean ColorOsReceiveTicketArrival$lambda$259(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void ColorOsReceiveTicketArrival$lambda$260(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean ColorOsReceiveTicketArrival$lambda$262(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void ColorOsReceiveTicketArrival$lambda$263(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    static final Unit ColorOsReceiveTicketArrival$lambda$273$lambda$270$lambda$269(MutableState mutableState, MutableState mutableState2) {
        if (!ColorOsReceiveTicketArrival$lambda$259(mutableState)) {
            ColorOsReceiveTicketArrival$lambda$263(mutableState2, true);
            ColorOsReceiveTicketArrival$lambda$260(mutableState, true);
        }
        return Unit.INSTANCE;
    }

    static final Unit ColorOsReceiveTicketArrival$lambda$273$lambda$272$lambda$271(MutableState mutableState, MutableState mutableState2) {
        if (!ColorOsReceiveTicketArrival$lambda$259(mutableState)) {
            ColorOsReceiveTicketArrival$lambda$263(mutableState2, false);
            ColorOsReceiveTicketArrival$lambda$260(mutableState, true);
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:30:0x005b  */
    /* JADX WARN: Code duplicated, block: B:31:0x005d  */
    /* JADX WARN: Code duplicated, block: B:34:0x0066 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:35:0x0068  */
    /* JADX WARN: Code duplicated, block: B:36:0x006d  */
    /* JADX WARN: Code duplicated, block: B:39:0x0074  */
    /* JADX WARN: Code duplicated, block: B:42:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:43:0x00c6  */
    /* JADX WARN: Code duplicated, block: B:47:0x00cc  */
    /* JADX WARN: Code duplicated, block: B:52:0x00e2  */
    /* JADX WARN: Code duplicated, block: B:55:0x00fc  */
    /* JADX WARN: Code duplicated, block: B:57:0x0101  */
    /* JADX WARN: Code duplicated, block: B:60:0x010b  */
    /* JADX WARN: Code duplicated, block: B:62:? A[RETURN, SYNTHETIC] */
    private static final void LiquidFusionTransferGlow(final float f, final boolean z, Modifier modifier, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        boolean z2;
        final Modifier modifier3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier.Companion companion;
        final State<Float> stateAnimateFloat;
        boolean z3;
        boolean zChanged;
        Object objRememberedValue;
        Composer composerStartRestartGroup = composer.startRestartGroup(127771312);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(LiquidFusionTransferGlow)N(progress,sending,modifier)2167@76502L51,2168@76582L270,2178@76875L2966,2178@76858L2983:TicketsShareScreens.kt#n9ob9m");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(f) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changed(z) ? 32 : 16;
        }
        int i4 = i2 & 4;
        if (i4 == 0) {
            if ((i & 384) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            if ((i3 & 147) != 146) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z2, i3 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
            } else {
                if (i4 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(127771312, i3, -1, "com.example.tickets.LiquidFusionTransferGlow (TicketsShareScreens.kt:2166)");
                }
                Modifier modifier4 = companion;
                stateAnimateFloat = InfiniteTransitionKt.animateFloat(InfiniteTransitionKt.rememberInfiniteTransition("liquid-fusion", composerStartRestartGroup, 6, 0), 0.0f, 1.0f, AnimationSpecKt.m555infiniteRepeatable9IiC70o$default(AnimationSpecKt.tween$default(920, 0, EasingKt.getLinearEasing(), 2, null), RepeatMode.Reverse, 0L, 4, null), "liquid-fusion-shimmer", composerStartRestartGroup, InfiniteTransition.$stable | 25008 | (InfiniteRepeatableSpec.$stable << 9), 0);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1765801050, "CC(remember):TicketsShareScreens.kt#9igjgp");
                if ((i3 & 14) == 4) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                zChanged = z3 | ((i3 & StylePropertiesKt.TextDirectionMask) == 32) | composerStartRestartGroup.changed(stateAnimateFloat);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function1() { // from class: com.example.tickets.TicketsShareScreensKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return TicketsShareScreensKt.LiquidFusionTransferGlow$lambda$277$lambda$276(f, z, stateAnimateFloat, (DrawScope) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                CanvasKt.Canvas(modifier4, (Function1) objRememberedValue, composerStartRestartGroup, (i3 >> 6) & 14);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier4;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.tickets.TicketsShareScreensKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return TicketsShareScreensKt.LiquidFusionTransferGlow$lambda$278(f, z, modifier3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 384;
        modifier2 = modifier;
        if ((i3 & 147) != 146) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z2, i3 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
        } else {
            if (i4 != 0) {
                companion = Modifier.INSTANCE;
            } else {
                companion = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(127771312, i3, -1, "com.example.tickets.LiquidFusionTransferGlow (TicketsShareScreens.kt:2166)");
            }
            Modifier modifier5 = companion;
            stateAnimateFloat = InfiniteTransitionKt.animateFloat(InfiniteTransitionKt.rememberInfiniteTransition("liquid-fusion", composerStartRestartGroup, 6, 0), 0.0f, 1.0f, AnimationSpecKt.m555infiniteRepeatable9IiC70o$default(AnimationSpecKt.tween$default(920, 0, EasingKt.getLinearEasing(), 2, null), RepeatMode.Reverse, 0L, 4, null), "liquid-fusion-shimmer", composerStartRestartGroup, InfiniteTransition.$stable | 25008 | (InfiniteRepeatableSpec.$stable << 9), 0);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1765801050, "CC(remember):TicketsShareScreens.kt#9igjgp");
            if ((i3 & 14) == 4) {
                z3 = true;
            } else {
                z3 = false;
            }
            zChanged = z3 | ((i3 & StylePropertiesKt.TextDirectionMask) == 32) | composerStartRestartGroup.changed(stateAnimateFloat);
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (!zChanged) {
                objRememberedValue = new Function1() { // from class: com.example.tickets.TicketsShareScreensKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return TicketsShareScreensKt.LiquidFusionTransferGlow$lambda$277$lambda$276(f, z, stateAnimateFloat, (DrawScope) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            } else {
                objRememberedValue = new Function1() { // from class: com.example.tickets.TicketsShareScreensKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return TicketsShareScreensKt.LiquidFusionTransferGlow$lambda$277$lambda$276(f, z, stateAnimateFloat, (DrawScope) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            CanvasKt.Canvas(modifier5, (Function1) objRememberedValue, composerStartRestartGroup, (i3 >> 6) & 14);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier5;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.tickets.TicketsShareScreensKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TicketsShareScreensKt.LiquidFusionTransferGlow$lambda$278(f, z, modifier3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    static final Unit LiquidFusionTransferGlow$lambda$277$lambda$276(float f, boolean z, State state, DrawScope Canvas) {
        long jM5559constructorimpl;
        Intrinsics.checkNotNullParameter(Canvas, "$this$Canvas");
        if (f <= 0.005f) {
            return Unit.INSTANCE;
        }
        float fIntBitsToFloat = Float.intBitsToFloat((int) (Canvas.mo6437getSizeNHjbRc() >> 32)) * 0.5f;
        float f2 = Canvas.mo803toPx0680j_4(Dp.m8748constructorimpl(44.0f));
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (Canvas.mo6437getSizeNHjbRc() & 4294967295L)) * 0.5f;
        float f3 = 1.0f;
        float fCoerceIn = RangesKt.coerceIn(f, 0.0f, 1.0f);
        float f4 = (z ? (fIntBitsToFloat2 - f2) * (1.0f - fCoerceIn) : (fIntBitsToFloat2 - f2) * fCoerceIn) + f2;
        float f5 = Canvas.mo803toPx0680j_4(Dp.m8748constructorimpl((32.0f * fCoerceIn) + 24.0f + (LiquidFusionTransferGlow$lambda$275(state) * 5.0f)));
        float f6 = 0.3f;
        float fCoerceIn2 = RangesKt.coerceIn((fCoerceIn * 0.18f) + 0.1f, 0.0f, 0.3f);
        int i = 0;
        while (i < 7) {
            float f7 = i / 6.0f;
            float f8 = f5 * (((f3 - f7) * 0.18f) + 0.32f);
            DrawScope.m6417drawCircleV9BoPsw$default(Canvas, Brush.Companion.m5765radialGradientP_VxKs$default(Brush.INSTANCE, CollectionsKt.listOf((Object[]) new Color[]{Color.m5828boximpl(Color.m5837copywmQWz5c$default(Color.INSTANCE.m5875getWhite0d7_KjU(), fCoerceIn2, 0.0f, 0.0f, 0.0f, 14, null)), Color.m5828boximpl(Color.m5837copywmQWz5c$default(Color.INSTANCE.m5875getWhite0d7_KjU(), fCoerceIn2 * f6, 0.0f, 0.0f, 0.0f, 14, null)), Color.m5828boximpl(Color.INSTANCE.m5873getTransparent0d7_KjU())}), 0L, f8, 0, 10, (Object) null), f8, Offset.m5559constructorimpl((((long) Float.floatToRawIntBits(((((float) Math.sin(((double) (f7 + f)) * 3.141592653589793d)) * 9.0f) * (f3 - f)) + fIntBitsToFloat)) << 32) | (((long) Float.floatToRawIntBits(z ? f4 + ((fIntBitsToFloat2 - f4) * f7) : ((f4 - f2) * f7) + f2)) & 4294967295L)), 0.0f, null, null, 0, 120, null);
            i++;
            f6 = f6;
            f3 = f3;
        }
        float f9 = f3;
        if (z) {
            jM5559constructorimpl = Offset.m5559constructorimpl((((long) Float.floatToRawIntBits(fIntBitsToFloat)) << 32) | (((long) Float.floatToRawIntBits(fIntBitsToFloat2 - (Canvas.mo803toPx0680j_4(Dp.m8748constructorimpl(135.0f)) * fCoerceIn))) & 4294967295L));
        } else {
            jM5559constructorimpl = Offset.m5559constructorimpl((((long) Float.floatToRawIntBits(fIntBitsToFloat)) << 32) | (((long) Float.floatToRawIntBits(fIntBitsToFloat2 + (Canvas.mo803toPx0680j_4(Dp.m8748constructorimpl(135.0f)) * (f9 - fCoerceIn)))) & 4294967295L));
        }
        DrawScope.m6424drawOvalAsUm42w$default(Canvas, Brush.Companion.m5765radialGradientP_VxKs$default(Brush.INSTANCE, CollectionsKt.listOf((Object[]) new Color[]{Color.m5828boximpl(Color.m5837copywmQWz5c$default(Color.INSTANCE.m5875getWhite0d7_KjU(), fCoerceIn * 0.16f, 0.0f, 0.0f, 0.0f, 14, null)), Color.m5828boximpl(Color.m5837copywmQWz5c$default(Color.INSTANCE.m5875getWhite0d7_KjU(), fCoerceIn * 0.045f, 0.0f, 0.0f, 0.0f, 14, null)), Color.m5828boximpl(Color.INSTANCE.m5873getTransparent0d7_KjU())}), 0L, Canvas.mo803toPx0680j_4(Dp.m8748constructorimpl(150.0f)), 0, 10, (Object) null), Offset.m5559constructorimpl((((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (jM5559constructorimpl >> 32)) - Canvas.mo803toPx0680j_4(Dp.m8748constructorimpl(150.0f)))) << 32) | (((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (jM5559constructorimpl & 4294967295L)) - Canvas.mo803toPx0680j_4(Dp.m8748constructorimpl(34.0f)))) & 4294967295L)), Size.m5627constructorimpl((((long) Float.floatToRawIntBits(Canvas.mo803toPx0680j_4(Dp.m8748constructorimpl(300.0f)))) << 32) | (((long) Float.floatToRawIntBits(Canvas.mo803toPx0680j_4(Dp.m8748constructorimpl(68.0f)))) & 4294967295L)), 0.0f, null, null, 0, 120, null);
        DrawScope drawScope = Canvas;
        if (fCoerceIn > 0.1f) {
            int i2 = 0;
            while (i2 < 14) {
                float f10 = ((i2 * 0.73f) + (1.7f * fCoerceIn)) % f9;
                DrawScope.m6418drawCircleVaOC9Bg$default(Canvas, Color.m5837copywmQWz5c$default(Color.INSTANCE.m5875getWhite0d7_KjU(), ((0.07f * fCoerceIn) + 0.025f) * (f9 - (f10 * 0.4f)), 0.0f, 0.0f, 0.0f, 14, null), drawScope.mo803toPx0680j_4(Dp.m8748constructorimpl(((i2 % 3) * 0.55f) + 0.7f)), Offset.m5559constructorimpl((((long) Float.floatToRawIntBits((((float) Math.sin(((double) (LiquidFusionTransferGlow$lambda$275(state) + f10)) * 3.141592653589793d)) * drawScope.mo803toPx0680j_4(Dp.m8748constructorimpl(((20.0f * fCoerceIn) + 8.0f) + ((i2 % 4) * 3.0f)))) + fIntBitsToFloat)) << 32) | (((long) Float.floatToRawIntBits((z ? (fIntBitsToFloat2 - f2) * f10 : (fIntBitsToFloat2 - f2) * (f9 - f10)) + f2)) & 4294967295L)), 0.0f, null, null, 0, 120, null);
                i2++;
                drawScope = Canvas;
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:105:0x0159  */
    /* JADX WARN: Code duplicated, block: B:108:0x015e  */
    /* JADX WARN: Code duplicated, block: B:111:0x0167  */
    /* JADX WARN: Code duplicated, block: B:119:0x0229  */
    /* JADX WARN: Code duplicated, block: B:122:0x0235  */
    /* JADX WARN: Code duplicated, block: B:123:0x0239  */
    /* JADX WARN: Code duplicated, block: B:127:0x028d  */
    /* JADX WARN: Code duplicated, block: B:130:0x0398  */
    /* JADX WARN: Code duplicated, block: B:133:0x03bb  */
    /* JADX WARN: Code duplicated, block: B:137:0x03e9  */
    /* JADX WARN: Code duplicated, block: B:139:0x03ec  */
    /* JADX WARN: Code duplicated, block: B:142:0x03f8  */
    /* JADX WARN: Code duplicated, block: B:143:0x045d  */
    /* JADX WARN: Code duplicated, block: B:146:0x0472  */
    /* JADX WARN: Code duplicated, block: B:147:0x0477  */
    /* JADX WARN: Code duplicated, block: B:150:0x0489  */
    /* JADX WARN: Code duplicated, block: B:152:0x0529  */
    /* JADX WARN: Code duplicated, block: B:155:0x0535  */
    /* JADX WARN: Code duplicated, block: B:156:0x0539  */
    /* JADX WARN: Code duplicated, block: B:158:0x05dc  */
    /* JADX WARN: Code duplicated, block: B:161:0x0639  */
    /* JADX WARN: Code duplicated, block: B:163:0x0644  */
    /* JADX WARN: Code duplicated, block: B:166:0x0654  */
    /* JADX WARN: Code duplicated, block: B:169:0x03ca A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:171:0x03b5 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:173:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:31:0x0059  */
    /* JADX WARN: Code duplicated, block: B:32:0x005c  */
    /* JADX WARN: Code duplicated, block: B:34:0x0060  */
    /* JADX WARN: Code duplicated, block: B:36:0x0068  */
    /* JADX WARN: Code duplicated, block: B:37:0x006b  */
    /* JADX WARN: Code duplicated, block: B:42:0x0075  */
    /* JADX WARN: Code duplicated, block: B:43:0x0078  */
    /* JADX WARN: Code duplicated, block: B:45:0x007c  */
    /* JADX WARN: Code duplicated, block: B:47:0x0084  */
    /* JADX WARN: Code duplicated, block: B:48:0x0087  */
    /* JADX WARN: Code duplicated, block: B:53:0x0093  */
    /* JADX WARN: Code duplicated, block: B:54:0x0095  */
    /* JADX WARN: Code duplicated, block: B:56:0x0098  */
    /* JADX WARN: Code duplicated, block: B:58:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:59:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:64:0x00b5  */
    /* JADX WARN: Code duplicated, block: B:65:0x00b7  */
    /* JADX WARN: Code duplicated, block: B:68:0x00c0 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:69:0x00c2  */
    /* JADX WARN: Code duplicated, block: B:70:0x00c7  */
    /* JADX WARN: Code duplicated, block: B:72:0x00ca  */
    /* JADX WARN: Code duplicated, block: B:73:0x00cd  */
    /* JADX WARN: Code duplicated, block: B:76:0x00d3  */
    /* JADX WARN: Code duplicated, block: B:78:0x00e5  */
    /* JADX WARN: Code duplicated, block: B:80:0x00f5  */
    /* JADX WARN: Code duplicated, block: B:82:0x00f9  */
    /* JADX WARN: Code duplicated, block: B:84:0x010b  */
    /* JADX WARN: Code duplicated, block: B:86:0x0119  */
    /* JADX WARN: Code duplicated, block: B:89:0x0120  */
    /* JADX WARN: Code duplicated, block: B:92:0x0130  */
    /* JADX WARN: Instruction removed from duplicated block: B:127:0x028d, please report this as an issue */
    /* JADX INFO: renamed from: TicketTransferTicketCard-RfXq3Jk, reason: not valid java name */
    private static final void m9318TicketTransferTicketCardRfXq3Jk(final List<TicketData> list, final float f, Modifier modifier, boolean z, Function0<Unit> function0, Function0<Unit> function1, Composer composer, final int i, final int i2) {
        List<TicketData> list2;
        int i3;
        float f2;
        Modifier modifier2;
        int i4;
        int i5;
        int i6;
        Function0<Unit> function2;
        int i7;
        int i8;
        Function0<Unit> function3;
        int i9;
        boolean z2;
        Composer composer2;
        final boolean z3;
        final Modifier modifier3;
        final Function0<Unit> function4;
        final Function0<Unit> function5;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier.Companion companion;
        boolean z4;
        Function0<Unit> function6;
        Function0<Unit> function7;
        TicketData ticketData;
        String str;
        String str2;
        TicketData ticketData2;
        Function0<ComposeUiNode> constructor;
        Function0<Unit> function8;
        Composer composer3;
        TicketData ticketData3;
        String strJoinToString$default;
        String str3;
        float fM8748constructorimpl;
        Function0<Unit> function9;
        Modifier modifier4;
        Function0<Unit> function10;
        Composer composer4;
        Function0<ComposeUiNode> constructor2;
        ArrayList arrayList;
        TicketType type;
        String strTicketShareTypeName;
        String title;
        String code;
        Object objRememberedValue;
        Object objRememberedValue2;
        Composer composerStartRestartGroup = composer.startRestartGroup(391212249);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(TicketTransferTicketCard)N(tickets,cornerRadius:c#ui.unit.Dp,modifier,showButtons,onAccept,onReject)2265@80069L2,2266@80100L2,2270@80315L1655:TicketsShareScreens.kt#n9ob9m");
        if ((i & 6) == 0) {
            list2 = list;
            i3 = (composerStartRestartGroup.changedInstance(list2) ? 4 : 2) | i;
        } else {
            list2 = list;
            i3 = i;
        }
        if ((i & 48) == 0) {
            f2 = f;
            i3 |= composerStartRestartGroup.changed(f2) ? 32 : 16;
        } else {
            f2 = f;
        }
        int i10 = i2 & 4;
        if (i10 == 0) {
            if ((i & 384) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            i4 = i2 & 8;
            if (i4 != 0) {
                if ((i & 3072) == 0) {
                    if (composerStartRestartGroup.changed(z)) {
                        i5 = 2048;
                    } else {
                        i5 = 1024;
                    }
                    i3 |= i5;
                }
                i6 = i2 & 16;
                if (i6 != 0) {
                    if ((i & 24576) == 0) {
                        function2 = function0;
                        if (composerStartRestartGroup.changedInstance(function2)) {
                            i7 = 16384;
                        } else {
                            i7 = 8192;
                        }
                        i3 |= i7;
                    }
                    i8 = i2 & 32;
                    if (i8 != 0) {
                        if ((196608 & i) == 0) {
                            function3 = function1;
                            if (composerStartRestartGroup.changedInstance(function3)) {
                                i9 = 131072;
                            } else {
                                i9 = 65536;
                            }
                            i3 |= i9;
                        }
                        if ((74899 & i3) != 74898) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        if (composerStartRestartGroup.shouldExecute(z2, i3 & 1)) {
                            composer2 = composerStartRestartGroup;
                            composer2.skipToGroupEnd();
                            z3 = z;
                            modifier3 = modifier2;
                            function4 = function2;
                            function5 = function3;
                        } else {
                            if (i10 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier2;
                            }
                            if (i4 != 0) {
                                z4 = false;
                            } else {
                                z4 = z;
                            }
                            if (i6 != 0) {
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2002143589, "CC(remember):TicketsShareScreens.kt#9igjgp");
                                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue2 = new Function0() { // from class: com.example.tickets.TicketsShareScreensKt$$ExternalSyntheticLambda70
                                        @Override // kotlin.jvm.functions.Function0
                                        public final Object invoke() {
                                            return Unit.INSTANCE;
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                function6 = (Function0) objRememberedValue2;
                            } else {
                                function6 = function2;
                            }
                            if (i8 != 0) {
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2002142597, "CC(remember):TicketsShareScreens.kt#9igjgp");
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue = new Function0() { // from class: com.example.tickets.TicketsShareScreensKt$$ExternalSyntheticLambda71
                                        @Override // kotlin.jvm.functions.Function0
                                        public final Object invoke() {
                                            return Unit.INSTANCE;
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                function7 = (Function0) objRememberedValue;
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            } else {
                                function7 = function3;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(391212249, i3, -1, "com.example.tickets.TicketTransferTicketCard (TicketsShareScreens.kt:2267)");
                            }
                            ticketData = (TicketData) CollectionsKt.firstOrNull((List) list2);
                            str = "票据";
                            if (ticketData != null || (title = ticketData.getTitle()) == null) {
                                str2 = "票据";
                            } else {
                                String str4 = title;
                                if (StringsKt.isBlank(str4)) {
                                    TicketData ticketData4 = (TicketData) CollectionsKt.firstOrNull((List) list2);
                                    if (ticketData4 == null || (code = ticketData4.getCode()) == null) {
                                        str4 = "票据";
                                    } else {
                                        String str5 = code;
                                        if (StringsKt.isBlank(str5)) {
                                            str5 = "票据";
                                        }
                                        str4 = str5;
                                        if (str4 == null) {
                                            str4 = "票据";
                                        }
                                    }
                                }
                                str2 = str4;
                                if (str2 == null) {
                                    str2 = "票据";
                                }
                            }
                            ticketData2 = (TicketData) CollectionsKt.firstOrNull((List) list2);
                            if (ticketData2 != null && (type = ticketData2.getType()) != null && (strTicketShareTypeName = ticketShareTypeName(type)) != null) {
                                str = strTicketShareTypeName;
                            }
                            Modifier modifierM1424paddingVpY3zN4 = PaddingKt.m1424paddingVpY3zN4(BorderKt.m659borderxT4_qwU(BackgroundKt.m648backgroundbw27NRU$default(ClipKt.clip(SizeKt.m1476height3ABfNKs(SizeKt.m1495width3ABfNKs(companion, Dp.m8748constructorimpl(380.0f)), Dp.m8748constructorimpl(270.0f)), RoundedCornerShapeKt.m1756RoundedCornerShape0680j_4(f2)), ColorKt.Color(4279703322L), null, 2, null), Dp.m8748constructorimpl(1.0f), Color.m5837copywmQWz5c$default(Color.INSTANCE.m5875getWhite0d7_KjU(), 0.18f, 0.0f, 0.0f, 0.0f, 14, null), RoundedCornerShapeKt.m1756RoundedCornerShape0680j_4(f2)), Dp.m8748constructorimpl(20.0f), Dp.m8748constructorimpl(18.0f));
                            Alignment.Horizontal centerHorizontally = Alignment.INSTANCE.getCenterHorizontally();
                            Arrangement.HorizontalOrVertical center = Arrangement.INSTANCE.getCenter();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(center, centerHorizontally, composerStartRestartGroup, 54);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
                            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1424paddingVpY3zN4);
                            constructor = ComposeUiNode.INSTANCE.getConstructor();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)410@16216L9:Composables.kt#9igjgp");
                            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            composerStartRestartGroup.startReusableNode();
                            if (composerStartRestartGroup.getInserting()) {
                                composerStartRestartGroup.createNode(constructor);
                            } else {
                                composerStartRestartGroup.useNode();
                            }
                            Composer composerM4937constructorimpl = Updater.m4937constructorimpl(composerStartRestartGroup);
                            Updater.m4945setimpl(composerM4937constructorimpl, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                            Updater.m4945setimpl(composerM4937constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                            Updater.m4945setimpl(composerM4937constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                            Updater.m4943reconcileimpl(composerM4937constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                            Updater.m4945setimpl(composerM4937constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 841490239, "C2281@80779L104,2282@80892L29,2283@80930L160,2284@81099L30,2287@81406L62:TicketsShareScreens.kt#n9ob9m");
                            if (list2.size() != 1) {
                                str = list2.size() + "张票据";
                            }
                            TextKt.m3661TextNvy7gAk(str, null, ColorKt.Color(4287795865L), null, TextUnitKt.getSp(12), null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composerStartRestartGroup, 24960, 0, 262122);
                            SpacerKt.Spacer(SizeKt.m1476height3ABfNKs(Modifier.INSTANCE, Dp.m8748constructorimpl(7.0f)), composerStartRestartGroup, 6);
                            function8 = function7;
                            TextKt.m3661TextNvy7gAk(str2, null, Color.INSTANCE.m5875getWhite0d7_KjU(), null, TextUnitKt.getSp(21), null, FontWeight.INSTANCE.getMedium(), null, 0L, null, TextAlign.m8619boximpl(TextAlign.INSTANCE.m8626getCentere0LSkKk()), 0L, TextOverflow.INSTANCE.m8684getEllipsisgIe3tQ8(), false, 2, 0, null, null, composerStartRestartGroup, 1597824, 24960, 240554);
                            composer3 = composerStartRestartGroup;
                            SpacerKt.Spacer(SizeKt.m1476height3ABfNKs(Modifier.INSTANCE, Dp.m8748constructorimpl(10.0f)), composer3, 6);
                            ticketData3 = (TicketData) CollectionsKt.firstOrNull((List) list);
                            if (ticketData3 != null) {
                                List listListOf = CollectionsKt.listOf((Object[]) new String[]{ticketData3.getFrom(), ticketData3.getTo()});
                                arrayList = new ArrayList();
                                for (Object obj : listListOf) {
                                    if (!StringsKt.isBlank((String) obj)) {
                                        arrayList.add(obj);
                                    }
                                }
                                strJoinToString$default = CollectionsKt.joinToString$default(arrayList, " → ", null, null, 0, null, null, 62, null);
                            } else {
                                strJoinToString$default = null;
                            }
                            if (strJoinToString$default == null) {
                                strJoinToString$default = "";
                            }
                            str3 = strJoinToString$default;
                            if (StringsKt.isBlank(str3)) {
                                composer3.startReplaceGroup(761319743);
                            } else {
                                composer3.startReplaceGroup(841966615);
                                ComposerKt.sourceInformation(composer3, "2286@81293L104");
                                TextKt.m3661TextNvy7gAk(strJoinToString$default, null, ColorKt.Color(4289374895L), null, TextUnitKt.getSp(13), null, null, null, 0L, null, null, 0L, TextOverflow.INSTANCE.m8684getEllipsisgIe3tQ8(), false, 1, 0, null, null, composer3, 24960, 24960, 241642);
                                composer3 = composer3;
                            }
                            composer3.endReplaceGroup();
                            Modifier.Companion companion2 = Modifier.INSTANCE;
                            if (StringsKt.isBlank(str3)) {
                                fM8748constructorimpl = Dp.m8748constructorimpl(20.0f);
                            } else {
                                fM8748constructorimpl = Dp.m8748constructorimpl(14.0f);
                            }
                            SpacerKt.Spacer(SizeKt.m1476height3ABfNKs(companion2, fM8748constructorimpl), composer3, 0);
                            if (z4) {
                                composer3.startReplaceGroup(842174563);
                                ComposerKt.sourceInformation(composer3, "2289@81508L57,2290@81578L30,2291@81621L243");
                                composer4 = composer3;
                                TextKt.m3661TextNvy7gAk("收到票据", null, ColorKt.Color(4287598486L), null, TextUnitKt.getSp(12), null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer4, 24966, 0, 262122);
                                SpacerKt.Spacer(SizeKt.m1476height3ABfNKs(Modifier.INSTANCE, Dp.m8748constructorimpl(14.0f)), composer4, 6);
                                Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                                Arrangement.HorizontalOrVertical horizontalOrVerticalM1115spacedBy0680j_4 = Arrangement.INSTANCE.m1115spacedBy0680j_4(Dp.m8748constructorimpl(10.0f));
                                ComposerKt.sourceInformationMarkerStart(composer4, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                                MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(horizontalOrVerticalM1115spacedBy0680j_4, Alignment.INSTANCE.getTop(), composer4, 6);
                                ComposerKt.sourceInformationMarkerStart(composer4, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
                                int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer4, 0));
                                CompositionLocalMap currentCompositionLocalMap2 = composer4.getCurrentCompositionLocalMap();
                                Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer4, modifierFillMaxWidth$default);
                                constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                                ComposerKt.sourceInformationMarkerStart(composer4, -553112988, "CC(ReusableComposeNode)N(factory,update,content)410@16216L9:Composables.kt#9igjgp");
                                if (!(composer4.getApplier() instanceof Applier)) {
                                    ComposablesKt.invalidApplier();
                                }
                                composer4.startReusableNode();
                                if (composer4.getInserting()) {
                                    composer4.createNode(constructor2);
                                } else {
                                    composer4.useNode();
                                }
                                Composer composerM4937constructorimpl2 = Updater.m4937constructorimpl(composer4);
                                Updater.m4945setimpl(composerM4937constructorimpl2, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                Updater.m4945setimpl(composerM4937constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                Updater.m4945setimpl(composerM4937constructorimpl2, Integer.valueOf(iHashCode2), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                                Updater.m4943reconcileimpl(composerM4937constructorimpl2, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                                Updater.m4945setimpl(composerM4937constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
                                ComposerKt.sourceInformationMarkerStart(composer4, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                                RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                                ComposerKt.sourceInformationMarkerStart(composer4, -823872107, "C2292@81721L56,2293@81794L56:TicketsShareScreens.kt#n9ob9m");
                                modifier4 = companion;
                                ShareOutlinedButton("拒绝", function8, RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null), composer4, ((i3 >> 12) & StylePropertiesKt.TextDirectionMask) | 6, 0);
                                function9 = function8;
                                Modifier modifierWeight$default = RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null);
                                int i11 = ((i3 >> 9) & StylePropertiesKt.TextDirectionMask) | 6;
                                function10 = function6;
                                ShareOutlinedButton("接受", function10, modifierWeight$default, composer4, i11, 0);
                                ComposerKt.sourceInformationMarkerEnd(composer4);
                                ComposerKt.sourceInformationMarkerEnd(composer4);
                                composer4.endNode();
                                ComposerKt.sourceInformationMarkerEnd(composer4);
                                ComposerKt.sourceInformationMarkerEnd(composer4);
                                ComposerKt.sourceInformationMarkerEnd(composer4);
                                composer4.endReplaceGroup();
                                composer2 = composer4;
                            } else {
                                function9 = function8;
                                modifier4 = companion;
                                function10 = function6;
                                composer3.startReplaceGroup(842548299);
                                ComposerKt.sourceInformation(composer3, "2296@81894L60");
                                composer2 = composer3;
                                TextKt.m3661TextNvy7gAk("票据正在传输…", null, ColorKt.Color(4287598486L), null, TextUnitKt.getSp(12), null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer2, 24966, 0, 262122);
                                composer2.endReplaceGroup();
                            }
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            composer2.endNode();
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            function4 = function10;
                            z3 = z4;
                            modifier3 = modifier4;
                            function5 = function9;
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.tickets.TicketsShareScreensKt$$ExternalSyntheticLambda72
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj2, Object obj3) {
                                    return TicketsShareScreensKt.TicketTransferTicketCard_RfXq3Jk$lambda$289(list, f, modifier3, z3, function4, function5, i, i2, (Composer) obj2, ((Integer) obj3).intValue());
                                }
                            });
                        }
                    }
                    i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    function3 = function1;
                    if ((74899 & i3) != 74898) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z2, i3 & 1)) {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        z3 = z;
                        modifier3 = modifier2;
                        function4 = function2;
                        function5 = function3;
                    } else {
                        if (i10 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i4 != 0) {
                            z4 = false;
                        } else {
                            z4 = z;
                        }
                        if (i6 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2002143589, "CC(remember):TicketsShareScreens.kt#9igjgp");
                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue2 = new Function0() { // from class: com.example.tickets.TicketsShareScreensKt$$ExternalSyntheticLambda70
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return Unit.INSTANCE;
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            function6 = (Function0) objRememberedValue2;
                        } else {
                            function6 = function2;
                        }
                        if (i8 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2002142597, "CC(remember):TicketsShareScreens.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = new Function0() { // from class: com.example.tickets.TicketsShareScreensKt$$ExternalSyntheticLambda71
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return Unit.INSTANCE;
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            function7 = (Function0) objRememberedValue;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        } else {
                            function7 = function3;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(391212249, i3, -1, "com.example.tickets.TicketTransferTicketCard (TicketsShareScreens.kt:2267)");
                        }
                        ticketData = (TicketData) CollectionsKt.firstOrNull((List) list2);
                        str = "票据";
                        if (ticketData != null) {
                            str2 = "票据";
                        } else {
                            str2 = "票据";
                        }
                        ticketData2 = (TicketData) CollectionsKt.firstOrNull((List) list2);
                        if (ticketData2 != null) {
                            str = strTicketShareTypeName;
                        }
                        Modifier modifierM1424paddingVpY3zN5 = PaddingKt.m1424paddingVpY3zN4(BorderKt.m659borderxT4_qwU(BackgroundKt.m648backgroundbw27NRU$default(ClipKt.clip(SizeKt.m1476height3ABfNKs(SizeKt.m1495width3ABfNKs(companion, Dp.m8748constructorimpl(380.0f)), Dp.m8748constructorimpl(270.0f)), RoundedCornerShapeKt.m1756RoundedCornerShape0680j_4(f2)), ColorKt.Color(4279703322L), null, 2, null), Dp.m8748constructorimpl(1.0f), Color.m5837copywmQWz5c$default(Color.INSTANCE.m5875getWhite0d7_KjU(), 0.18f, 0.0f, 0.0f, 0.0f, 14, null), RoundedCornerShapeKt.m1756RoundedCornerShape0680j_4(f2)), Dp.m8748constructorimpl(20.0f), Dp.m8748constructorimpl(18.0f));
                        Alignment.Horizontal centerHorizontally2 = Alignment.INSTANCE.getCenterHorizontally();
                        Arrangement.HorizontalOrVertical center2 = Arrangement.INSTANCE.getCenter();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                        MeasurePolicy measurePolicyColumnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(center2, centerHorizontally2, composerStartRestartGroup, 54);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
                        int iHashCode3 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                        CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1424paddingVpY3zN5);
                        constructor = ComposeUiNode.INSTANCE.getConstructor();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)410@16216L9:Composables.kt#9igjgp");
                        if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composerStartRestartGroup.startReusableNode();
                        if (composerStartRestartGroup.getInserting()) {
                            composerStartRestartGroup.createNode(constructor);
                        } else {
                            composerStartRestartGroup.useNode();
                        }
                        Composer composerM4937constructorimpl3 = Updater.m4937constructorimpl(composerStartRestartGroup);
                        Updater.m4945setimpl(composerM4937constructorimpl3, measurePolicyColumnMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m4945setimpl(composerM4937constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Updater.m4945setimpl(composerM4937constructorimpl3, Integer.valueOf(iHashCode3), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                        Updater.m4943reconcileimpl(composerM4937constructorimpl3, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                        Updater.m4945setimpl(composerM4937constructorimpl3, modifierMaterializeModifier3, ComposeUiNode.INSTANCE.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                        ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 841490239, "C2281@80779L104,2282@80892L29,2283@80930L160,2284@81099L30,2287@81406L62:TicketsShareScreens.kt#n9ob9m");
                        if (list2.size() != 1) {
                            str = list2.size() + "张票据";
                        }
                        TextKt.m3661TextNvy7gAk(str, null, ColorKt.Color(4287795865L), null, TextUnitKt.getSp(12), null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composerStartRestartGroup, 24960, 0, 262122);
                        SpacerKt.Spacer(SizeKt.m1476height3ABfNKs(Modifier.INSTANCE, Dp.m8748constructorimpl(7.0f)), composerStartRestartGroup, 6);
                        function8 = function7;
                        TextKt.m3661TextNvy7gAk(str2, null, Color.INSTANCE.m5875getWhite0d7_KjU(), null, TextUnitKt.getSp(21), null, FontWeight.INSTANCE.getMedium(), null, 0L, null, TextAlign.m8619boximpl(TextAlign.INSTANCE.m8626getCentere0LSkKk()), 0L, TextOverflow.INSTANCE.m8684getEllipsisgIe3tQ8(), false, 2, 0, null, null, composerStartRestartGroup, 1597824, 24960, 240554);
                        composer3 = composerStartRestartGroup;
                        SpacerKt.Spacer(SizeKt.m1476height3ABfNKs(Modifier.INSTANCE, Dp.m8748constructorimpl(10.0f)), composer3, 6);
                        ticketData3 = (TicketData) CollectionsKt.firstOrNull((List) list);
                        if (ticketData3 != null) {
                            List listListOf2 = CollectionsKt.listOf((Object[]) new String[]{ticketData3.getFrom(), ticketData3.getTo()});
                            arrayList = new ArrayList();
                            while (r9.hasNext()) {
                                if (!StringsKt.isBlank((String) obj)) {
                                    arrayList.add(obj);
                                }
                            }
                            strJoinToString$default = CollectionsKt.joinToString$default(arrayList, " → ", null, null, 0, null, null, 62, null);
                        } else {
                            strJoinToString$default = null;
                        }
                        if (strJoinToString$default == null) {
                            strJoinToString$default = "";
                        }
                        str3 = strJoinToString$default;
                        if (StringsKt.isBlank(str3)) {
                            composer3.startReplaceGroup(841966615);
                            ComposerKt.sourceInformation(composer3, "2286@81293L104");
                            TextKt.m3661TextNvy7gAk(strJoinToString$default, null, ColorKt.Color(4289374895L), null, TextUnitKt.getSp(13), null, null, null, 0L, null, null, 0L, TextOverflow.INSTANCE.m8684getEllipsisgIe3tQ8(), false, 1, 0, null, null, composer3, 24960, 24960, 241642);
                            composer3 = composer3;
                        } else {
                            composer3.startReplaceGroup(761319743);
                        }
                        composer3.endReplaceGroup();
                        Modifier.Companion companion3 = Modifier.INSTANCE;
                        if (StringsKt.isBlank(str3)) {
                            fM8748constructorimpl = Dp.m8748constructorimpl(20.0f);
                        } else {
                            fM8748constructorimpl = Dp.m8748constructorimpl(14.0f);
                        }
                        SpacerKt.Spacer(SizeKt.m1476height3ABfNKs(companion3, fM8748constructorimpl), composer3, 0);
                        if (z4) {
                            composer3.startReplaceGroup(842174563);
                            ComposerKt.sourceInformation(composer3, "2289@81508L57,2290@81578L30,2291@81621L243");
                            composer4 = composer3;
                            TextKt.m3661TextNvy7gAk("收到票据", null, ColorKt.Color(4287598486L), null, TextUnitKt.getSp(12), null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer4, 24966, 0, 262122);
                            SpacerKt.Spacer(SizeKt.m1476height3ABfNKs(Modifier.INSTANCE, Dp.m8748constructorimpl(14.0f)), composer4, 6);
                            Modifier modifierFillMaxWidth$default2 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                            Arrangement.HorizontalOrVertical horizontalOrVerticalM1115spacedBy0680j_5 = Arrangement.INSTANCE.m1115spacedBy0680j_4(Dp.m8748constructorimpl(10.0f));
                            ComposerKt.sourceInformationMarkerStart(composer4, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                            MeasurePolicy measurePolicyRowMeasurePolicy2 = RowKt.rowMeasurePolicy(horizontalOrVerticalM1115spacedBy0680j_5, Alignment.INSTANCE.getTop(), composer4, 6);
                            ComposerKt.sourceInformationMarkerStart(composer4, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
                            int iHashCode4 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer4, 0));
                            CompositionLocalMap currentCompositionLocalMap4 = composer4.getCurrentCompositionLocalMap();
                            Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composer4, modifierFillMaxWidth$default2);
                            constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                            ComposerKt.sourceInformationMarkerStart(composer4, -553112988, "CC(ReusableComposeNode)N(factory,update,content)410@16216L9:Composables.kt#9igjgp");
                            if (!(composer4.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            composer4.startReusableNode();
                            if (composer4.getInserting()) {
                                composer4.createNode(constructor2);
                            } else {
                                composer4.useNode();
                            }
                            Composer composerM4937constructorimpl4 = Updater.m4937constructorimpl(composer4);
                            Updater.m4945setimpl(composerM4937constructorimpl4, measurePolicyRowMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                            Updater.m4945setimpl(composerM4937constructorimpl4, currentCompositionLocalMap4, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                            Updater.m4945setimpl(composerM4937constructorimpl4, Integer.valueOf(iHashCode4), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                            Updater.m4943reconcileimpl(composerM4937constructorimpl4, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                            Updater.m4945setimpl(composerM4937constructorimpl4, modifierMaterializeModifier4, ComposeUiNode.INSTANCE.getSetModifier());
                            ComposerKt.sourceInformationMarkerStart(composer4, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                            RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
                            ComposerKt.sourceInformationMarkerStart(composer4, -823872107, "C2292@81721L56,2293@81794L56:TicketsShareScreens.kt#n9ob9m");
                            modifier4 = companion;
                            ShareOutlinedButton("拒绝", function8, RowScope.weight$default(rowScopeInstance2, Modifier.INSTANCE, 1.0f, false, 2, null), composer4, ((i3 >> 12) & StylePropertiesKt.TextDirectionMask) | 6, 0);
                            function9 = function8;
                            Modifier modifierWeight$default2 = RowScope.weight$default(rowScopeInstance2, Modifier.INSTANCE, 1.0f, false, 2, null);
                            int i12 = ((i3 >> 9) & StylePropertiesKt.TextDirectionMask) | 6;
                            function10 = function6;
                            ShareOutlinedButton("接受", function10, modifierWeight$default2, composer4, i12, 0);
                            ComposerKt.sourceInformationMarkerEnd(composer4);
                            ComposerKt.sourceInformationMarkerEnd(composer4);
                            composer4.endNode();
                            ComposerKt.sourceInformationMarkerEnd(composer4);
                            ComposerKt.sourceInformationMarkerEnd(composer4);
                            ComposerKt.sourceInformationMarkerEnd(composer4);
                            composer4.endReplaceGroup();
                            composer2 = composer4;
                        } else {
                            function9 = function8;
                            modifier4 = companion;
                            function10 = function6;
                            composer3.startReplaceGroup(842548299);
                            ComposerKt.sourceInformation(composer3, "2296@81894L60");
                            composer2 = composer3;
                            TextKt.m3661TextNvy7gAk("票据正在传输…", null, ColorKt.Color(4287598486L), null, TextUnitKt.getSp(12), null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer2, 24966, 0, 262122);
                            composer2.endReplaceGroup();
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        composer2.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        function4 = function10;
                        z3 = z4;
                        modifier3 = modifier4;
                        function5 = function9;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.tickets.TicketsShareScreensKt$$ExternalSyntheticLambda72
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj2, Object obj3) {
                                return TicketsShareScreensKt.TicketTransferTicketCard_RfXq3Jk$lambda$289(list, f, modifier3, z3, function4, function5, i, i2, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        });
                    }
                }
                i3 |= 24576;
                function2 = function0;
                i8 = i2 & 32;
                if (i8 != 0) {
                    if ((196608 & i) == 0) {
                        function3 = function1;
                        if (composerStartRestartGroup.changedInstance(function3)) {
                            i9 = 131072;
                        } else {
                            i9 = 65536;
                        }
                        i3 |= i9;
                    }
                    if ((74899 & i3) != 74898) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z2, i3 & 1)) {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        z3 = z;
                        modifier3 = modifier2;
                        function4 = function2;
                        function5 = function3;
                    } else {
                        if (i10 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i4 != 0) {
                            z4 = false;
                        } else {
                            z4 = z;
                        }
                        if (i6 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2002143589, "CC(remember):TicketsShareScreens.kt#9igjgp");
                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue2 = new Function0() { // from class: com.example.tickets.TicketsShareScreensKt$$ExternalSyntheticLambda70
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return Unit.INSTANCE;
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            function6 = (Function0) objRememberedValue2;
                        } else {
                            function6 = function2;
                        }
                        if (i8 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2002142597, "CC(remember):TicketsShareScreens.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = new Function0() { // from class: com.example.tickets.TicketsShareScreensKt$$ExternalSyntheticLambda71
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return Unit.INSTANCE;
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            function7 = (Function0) objRememberedValue;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        } else {
                            function7 = function3;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(391212249, i3, -1, "com.example.tickets.TicketTransferTicketCard (TicketsShareScreens.kt:2267)");
                        }
                        ticketData = (TicketData) CollectionsKt.firstOrNull((List) list2);
                        str = "票据";
                        if (ticketData != null) {
                            str2 = "票据";
                        } else {
                            str2 = "票据";
                        }
                        ticketData2 = (TicketData) CollectionsKt.firstOrNull((List) list2);
                        if (ticketData2 != null) {
                            str = strTicketShareTypeName;
                        }
                        Modifier modifierM1424paddingVpY3zN6 = PaddingKt.m1424paddingVpY3zN4(BorderKt.m659borderxT4_qwU(BackgroundKt.m648backgroundbw27NRU$default(ClipKt.clip(SizeKt.m1476height3ABfNKs(SizeKt.m1495width3ABfNKs(companion, Dp.m8748constructorimpl(380.0f)), Dp.m8748constructorimpl(270.0f)), RoundedCornerShapeKt.m1756RoundedCornerShape0680j_4(f2)), ColorKt.Color(4279703322L), null, 2, null), Dp.m8748constructorimpl(1.0f), Color.m5837copywmQWz5c$default(Color.INSTANCE.m5875getWhite0d7_KjU(), 0.18f, 0.0f, 0.0f, 0.0f, 14, null), RoundedCornerShapeKt.m1756RoundedCornerShape0680j_4(f2)), Dp.m8748constructorimpl(20.0f), Dp.m8748constructorimpl(18.0f));
                        Alignment.Horizontal centerHorizontally3 = Alignment.INSTANCE.getCenterHorizontally();
                        Arrangement.HorizontalOrVertical center3 = Arrangement.INSTANCE.getCenter();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                        MeasurePolicy measurePolicyColumnMeasurePolicy3 = ColumnKt.columnMeasurePolicy(center3, centerHorizontally3, composerStartRestartGroup, 54);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
                        int iHashCode5 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                        CompositionLocalMap currentCompositionLocalMap5 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier5 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1424paddingVpY3zN6);
                        constructor = ComposeUiNode.INSTANCE.getConstructor();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)410@16216L9:Composables.kt#9igjgp");
                        if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composerStartRestartGroup.startReusableNode();
                        if (composerStartRestartGroup.getInserting()) {
                            composerStartRestartGroup.createNode(constructor);
                        } else {
                            composerStartRestartGroup.useNode();
                        }
                        Composer composerM4937constructorimpl5 = Updater.m4937constructorimpl(composerStartRestartGroup);
                        Updater.m4945setimpl(composerM4937constructorimpl5, measurePolicyColumnMeasurePolicy3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m4945setimpl(composerM4937constructorimpl5, currentCompositionLocalMap5, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Updater.m4945setimpl(composerM4937constructorimpl5, Integer.valueOf(iHashCode5), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                        Updater.m4943reconcileimpl(composerM4937constructorimpl5, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                        Updater.m4945setimpl(composerM4937constructorimpl5, modifierMaterializeModifier5, ComposeUiNode.INSTANCE.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                        ColumnScopeInstance columnScopeInstance3 = ColumnScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 841490239, "C2281@80779L104,2282@80892L29,2283@80930L160,2284@81099L30,2287@81406L62:TicketsShareScreens.kt#n9ob9m");
                        if (list2.size() != 1) {
                            str = list2.size() + "张票据";
                        }
                        TextKt.m3661TextNvy7gAk(str, null, ColorKt.Color(4287795865L), null, TextUnitKt.getSp(12), null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composerStartRestartGroup, 24960, 0, 262122);
                        SpacerKt.Spacer(SizeKt.m1476height3ABfNKs(Modifier.INSTANCE, Dp.m8748constructorimpl(7.0f)), composerStartRestartGroup, 6);
                        function8 = function7;
                        TextKt.m3661TextNvy7gAk(str2, null, Color.INSTANCE.m5875getWhite0d7_KjU(), null, TextUnitKt.getSp(21), null, FontWeight.INSTANCE.getMedium(), null, 0L, null, TextAlign.m8619boximpl(TextAlign.INSTANCE.m8626getCentere0LSkKk()), 0L, TextOverflow.INSTANCE.m8684getEllipsisgIe3tQ8(), false, 2, 0, null, null, composerStartRestartGroup, 1597824, 24960, 240554);
                        composer3 = composerStartRestartGroup;
                        SpacerKt.Spacer(SizeKt.m1476height3ABfNKs(Modifier.INSTANCE, Dp.m8748constructorimpl(10.0f)), composer3, 6);
                        ticketData3 = (TicketData) CollectionsKt.firstOrNull((List) list);
                        if (ticketData3 != null) {
                            List listListOf3 = CollectionsKt.listOf((Object[]) new String[]{ticketData3.getFrom(), ticketData3.getTo()});
                            arrayList = new ArrayList();
                            while (r9.hasNext()) {
                                if (!StringsKt.isBlank((String) obj)) {
                                    arrayList.add(obj);
                                }
                            }
                            strJoinToString$default = CollectionsKt.joinToString$default(arrayList, " → ", null, null, 0, null, null, 62, null);
                        } else {
                            strJoinToString$default = null;
                        }
                        if (strJoinToString$default == null) {
                            strJoinToString$default = "";
                        }
                        str3 = strJoinToString$default;
                        if (StringsKt.isBlank(str3)) {
                            composer3.startReplaceGroup(841966615);
                            ComposerKt.sourceInformation(composer3, "2286@81293L104");
                            TextKt.m3661TextNvy7gAk(strJoinToString$default, null, ColorKt.Color(4289374895L), null, TextUnitKt.getSp(13), null, null, null, 0L, null, null, 0L, TextOverflow.INSTANCE.m8684getEllipsisgIe3tQ8(), false, 1, 0, null, null, composer3, 24960, 24960, 241642);
                            composer3 = composer3;
                        } else {
                            composer3.startReplaceGroup(761319743);
                        }
                        composer3.endReplaceGroup();
                        Modifier.Companion companion4 = Modifier.INSTANCE;
                        if (StringsKt.isBlank(str3)) {
                            fM8748constructorimpl = Dp.m8748constructorimpl(20.0f);
                        } else {
                            fM8748constructorimpl = Dp.m8748constructorimpl(14.0f);
                        }
                        SpacerKt.Spacer(SizeKt.m1476height3ABfNKs(companion4, fM8748constructorimpl), composer3, 0);
                        if (z4) {
                            composer3.startReplaceGroup(842174563);
                            ComposerKt.sourceInformation(composer3, "2289@81508L57,2290@81578L30,2291@81621L243");
                            composer4 = composer3;
                            TextKt.m3661TextNvy7gAk("收到票据", null, ColorKt.Color(4287598486L), null, TextUnitKt.getSp(12), null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer4, 24966, 0, 262122);
                            SpacerKt.Spacer(SizeKt.m1476height3ABfNKs(Modifier.INSTANCE, Dp.m8748constructorimpl(14.0f)), composer4, 6);
                            Modifier modifierFillMaxWidth$default3 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                            Arrangement.HorizontalOrVertical horizontalOrVerticalM1115spacedBy0680j_6 = Arrangement.INSTANCE.m1115spacedBy0680j_4(Dp.m8748constructorimpl(10.0f));
                            ComposerKt.sourceInformationMarkerStart(composer4, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                            MeasurePolicy measurePolicyRowMeasurePolicy3 = RowKt.rowMeasurePolicy(horizontalOrVerticalM1115spacedBy0680j_6, Alignment.INSTANCE.getTop(), composer4, 6);
                            ComposerKt.sourceInformationMarkerStart(composer4, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
                            int iHashCode6 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer4, 0));
                            CompositionLocalMap currentCompositionLocalMap6 = composer4.getCurrentCompositionLocalMap();
                            Modifier modifierMaterializeModifier6 = ComposedModifierKt.materializeModifier(composer4, modifierFillMaxWidth$default3);
                            constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                            ComposerKt.sourceInformationMarkerStart(composer4, -553112988, "CC(ReusableComposeNode)N(factory,update,content)410@16216L9:Composables.kt#9igjgp");
                            if (!(composer4.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            composer4.startReusableNode();
                            if (composer4.getInserting()) {
                                composer4.createNode(constructor2);
                            } else {
                                composer4.useNode();
                            }
                            Composer composerM4937constructorimpl6 = Updater.m4937constructorimpl(composer4);
                            Updater.m4945setimpl(composerM4937constructorimpl6, measurePolicyRowMeasurePolicy3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                            Updater.m4945setimpl(composerM4937constructorimpl6, currentCompositionLocalMap6, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                            Updater.m4945setimpl(composerM4937constructorimpl6, Integer.valueOf(iHashCode6), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                            Updater.m4943reconcileimpl(composerM4937constructorimpl6, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                            Updater.m4945setimpl(composerM4937constructorimpl6, modifierMaterializeModifier6, ComposeUiNode.INSTANCE.getSetModifier());
                            ComposerKt.sourceInformationMarkerStart(composer4, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                            RowScopeInstance rowScopeInstance3 = RowScopeInstance.INSTANCE;
                            ComposerKt.sourceInformationMarkerStart(composer4, -823872107, "C2292@81721L56,2293@81794L56:TicketsShareScreens.kt#n9ob9m");
                            modifier4 = companion;
                            ShareOutlinedButton("拒绝", function8, RowScope.weight$default(rowScopeInstance3, Modifier.INSTANCE, 1.0f, false, 2, null), composer4, ((i3 >> 12) & StylePropertiesKt.TextDirectionMask) | 6, 0);
                            function9 = function8;
                            Modifier modifierWeight$default3 = RowScope.weight$default(rowScopeInstance3, Modifier.INSTANCE, 1.0f, false, 2, null);
                            int i13 = ((i3 >> 9) & StylePropertiesKt.TextDirectionMask) | 6;
                            function10 = function6;
                            ShareOutlinedButton("接受", function10, modifierWeight$default3, composer4, i13, 0);
                            ComposerKt.sourceInformationMarkerEnd(composer4);
                            ComposerKt.sourceInformationMarkerEnd(composer4);
                            composer4.endNode();
                            ComposerKt.sourceInformationMarkerEnd(composer4);
                            ComposerKt.sourceInformationMarkerEnd(composer4);
                            ComposerKt.sourceInformationMarkerEnd(composer4);
                            composer4.endReplaceGroup();
                            composer2 = composer4;
                        } else {
                            function9 = function8;
                            modifier4 = companion;
                            function10 = function6;
                            composer3.startReplaceGroup(842548299);
                            ComposerKt.sourceInformation(composer3, "2296@81894L60");
                            composer2 = composer3;
                            TextKt.m3661TextNvy7gAk("票据正在传输…", null, ColorKt.Color(4287598486L), null, TextUnitKt.getSp(12), null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer2, 24966, 0, 262122);
                            composer2.endReplaceGroup();
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        composer2.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        function4 = function10;
                        z3 = z4;
                        modifier3 = modifier4;
                        function5 = function9;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.tickets.TicketsShareScreensKt$$ExternalSyntheticLambda72
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj2, Object obj3) {
                                return TicketsShareScreensKt.TicketTransferTicketCard_RfXq3Jk$lambda$289(list, f, modifier3, z3, function4, function5, i, i2, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        });
                    }
                }
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                function3 = function1;
                if ((74899 & i3) != 74898) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z2, i3 & 1)) {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    z3 = z;
                    modifier3 = modifier2;
                    function4 = function2;
                    function5 = function3;
                } else {
                    if (i10 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i4 != 0) {
                        z4 = false;
                    } else {
                        z4 = z;
                    }
                    if (i6 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2002143589, "CC(remember):TicketsShareScreens.kt#9igjgp");
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue2 = new Function0() { // from class: com.example.tickets.TicketsShareScreensKt$$ExternalSyntheticLambda70
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return Unit.INSTANCE;
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        function6 = (Function0) objRememberedValue2;
                    } else {
                        function6 = function2;
                    }
                    if (i8 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2002142597, "CC(remember):TicketsShareScreens.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new Function0() { // from class: com.example.tickets.TicketsShareScreensKt$$ExternalSyntheticLambda71
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return Unit.INSTANCE;
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        function7 = (Function0) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    } else {
                        function7 = function3;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(391212249, i3, -1, "com.example.tickets.TicketTransferTicketCard (TicketsShareScreens.kt:2267)");
                    }
                    ticketData = (TicketData) CollectionsKt.firstOrNull((List) list2);
                    str = "票据";
                    if (ticketData != null) {
                        str2 = "票据";
                    } else {
                        str2 = "票据";
                    }
                    ticketData2 = (TicketData) CollectionsKt.firstOrNull((List) list2);
                    if (ticketData2 != null) {
                        str = strTicketShareTypeName;
                    }
                    Modifier modifierM1424paddingVpY3zN7 = PaddingKt.m1424paddingVpY3zN4(BorderKt.m659borderxT4_qwU(BackgroundKt.m648backgroundbw27NRU$default(ClipKt.clip(SizeKt.m1476height3ABfNKs(SizeKt.m1495width3ABfNKs(companion, Dp.m8748constructorimpl(380.0f)), Dp.m8748constructorimpl(270.0f)), RoundedCornerShapeKt.m1756RoundedCornerShape0680j_4(f2)), ColorKt.Color(4279703322L), null, 2, null), Dp.m8748constructorimpl(1.0f), Color.m5837copywmQWz5c$default(Color.INSTANCE.m5875getWhite0d7_KjU(), 0.18f, 0.0f, 0.0f, 0.0f, 14, null), RoundedCornerShapeKt.m1756RoundedCornerShape0680j_4(f2)), Dp.m8748constructorimpl(20.0f), Dp.m8748constructorimpl(18.0f));
                    Alignment.Horizontal centerHorizontally4 = Alignment.INSTANCE.getCenterHorizontally();
                    Arrangement.HorizontalOrVertical center4 = Arrangement.INSTANCE.getCenter();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                    MeasurePolicy measurePolicyColumnMeasurePolicy4 = ColumnKt.columnMeasurePolicy(center4, centerHorizontally4, composerStartRestartGroup, 54);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
                    int iHashCode7 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap7 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier7 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1424paddingVpY3zN7);
                    constructor = ComposeUiNode.INSTANCE.getConstructor();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)410@16216L9:Composables.kt#9igjgp");
                    if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(constructor);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    Composer composerM4937constructorimpl7 = Updater.m4937constructorimpl(composerStartRestartGroup);
                    Updater.m4945setimpl(composerM4937constructorimpl7, measurePolicyColumnMeasurePolicy4, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m4945setimpl(composerM4937constructorimpl7, currentCompositionLocalMap7, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Updater.m4945setimpl(composerM4937constructorimpl7, Integer.valueOf(iHashCode7), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                    Updater.m4943reconcileimpl(composerM4937constructorimpl7, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                    Updater.m4945setimpl(composerM4937constructorimpl7, modifierMaterializeModifier7, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                    ColumnScopeInstance columnScopeInstance4 = ColumnScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 841490239, "C2281@80779L104,2282@80892L29,2283@80930L160,2284@81099L30,2287@81406L62:TicketsShareScreens.kt#n9ob9m");
                    if (list2.size() != 1) {
                        str = list2.size() + "张票据";
                    }
                    TextKt.m3661TextNvy7gAk(str, null, ColorKt.Color(4287795865L), null, TextUnitKt.getSp(12), null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composerStartRestartGroup, 24960, 0, 262122);
                    SpacerKt.Spacer(SizeKt.m1476height3ABfNKs(Modifier.INSTANCE, Dp.m8748constructorimpl(7.0f)), composerStartRestartGroup, 6);
                    function8 = function7;
                    TextKt.m3661TextNvy7gAk(str2, null, Color.INSTANCE.m5875getWhite0d7_KjU(), null, TextUnitKt.getSp(21), null, FontWeight.INSTANCE.getMedium(), null, 0L, null, TextAlign.m8619boximpl(TextAlign.INSTANCE.m8626getCentere0LSkKk()), 0L, TextOverflow.INSTANCE.m8684getEllipsisgIe3tQ8(), false, 2, 0, null, null, composerStartRestartGroup, 1597824, 24960, 240554);
                    composer3 = composerStartRestartGroup;
                    SpacerKt.Spacer(SizeKt.m1476height3ABfNKs(Modifier.INSTANCE, Dp.m8748constructorimpl(10.0f)), composer3, 6);
                    ticketData3 = (TicketData) CollectionsKt.firstOrNull((List) list);
                    if (ticketData3 != null) {
                        List listListOf4 = CollectionsKt.listOf((Object[]) new String[]{ticketData3.getFrom(), ticketData3.getTo()});
                        arrayList = new ArrayList();
                        while (r9.hasNext()) {
                            if (!StringsKt.isBlank((String) obj)) {
                                arrayList.add(obj);
                            }
                        }
                        strJoinToString$default = CollectionsKt.joinToString$default(arrayList, " → ", null, null, 0, null, null, 62, null);
                    } else {
                        strJoinToString$default = null;
                    }
                    if (strJoinToString$default == null) {
                        strJoinToString$default = "";
                    }
                    str3 = strJoinToString$default;
                    if (StringsKt.isBlank(str3)) {
                        composer3.startReplaceGroup(841966615);
                        ComposerKt.sourceInformation(composer3, "2286@81293L104");
                        TextKt.m3661TextNvy7gAk(strJoinToString$default, null, ColorKt.Color(4289374895L), null, TextUnitKt.getSp(13), null, null, null, 0L, null, null, 0L, TextOverflow.INSTANCE.m8684getEllipsisgIe3tQ8(), false, 1, 0, null, null, composer3, 24960, 24960, 241642);
                        composer3 = composer3;
                    } else {
                        composer3.startReplaceGroup(761319743);
                    }
                    composer3.endReplaceGroup();
                    Modifier.Companion companion5 = Modifier.INSTANCE;
                    if (StringsKt.isBlank(str3)) {
                        fM8748constructorimpl = Dp.m8748constructorimpl(20.0f);
                    } else {
                        fM8748constructorimpl = Dp.m8748constructorimpl(14.0f);
                    }
                    SpacerKt.Spacer(SizeKt.m1476height3ABfNKs(companion5, fM8748constructorimpl), composer3, 0);
                    if (z4) {
                        composer3.startReplaceGroup(842174563);
                        ComposerKt.sourceInformation(composer3, "2289@81508L57,2290@81578L30,2291@81621L243");
                        composer4 = composer3;
                        TextKt.m3661TextNvy7gAk("收到票据", null, ColorKt.Color(4287598486L), null, TextUnitKt.getSp(12), null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer4, 24966, 0, 262122);
                        SpacerKt.Spacer(SizeKt.m1476height3ABfNKs(Modifier.INSTANCE, Dp.m8748constructorimpl(14.0f)), composer4, 6);
                        Modifier modifierFillMaxWidth$default4 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                        Arrangement.HorizontalOrVertical horizontalOrVerticalM1115spacedBy0680j_7 = Arrangement.INSTANCE.m1115spacedBy0680j_4(Dp.m8748constructorimpl(10.0f));
                        ComposerKt.sourceInformationMarkerStart(composer4, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                        MeasurePolicy measurePolicyRowMeasurePolicy4 = RowKt.rowMeasurePolicy(horizontalOrVerticalM1115spacedBy0680j_7, Alignment.INSTANCE.getTop(), composer4, 6);
                        ComposerKt.sourceInformationMarkerStart(composer4, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
                        int iHashCode8 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer4, 0));
                        CompositionLocalMap currentCompositionLocalMap8 = composer4.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier8 = ComposedModifierKt.materializeModifier(composer4, modifierFillMaxWidth$default4);
                        constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                        ComposerKt.sourceInformationMarkerStart(composer4, -553112988, "CC(ReusableComposeNode)N(factory,update,content)410@16216L9:Composables.kt#9igjgp");
                        if (!(composer4.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composer4.startReusableNode();
                        if (composer4.getInserting()) {
                            composer4.createNode(constructor2);
                        } else {
                            composer4.useNode();
                        }
                        Composer composerM4937constructorimpl8 = Updater.m4937constructorimpl(composer4);
                        Updater.m4945setimpl(composerM4937constructorimpl8, measurePolicyRowMeasurePolicy4, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m4945setimpl(composerM4937constructorimpl8, currentCompositionLocalMap8, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Updater.m4945setimpl(composerM4937constructorimpl8, Integer.valueOf(iHashCode8), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                        Updater.m4943reconcileimpl(composerM4937constructorimpl8, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                        Updater.m4945setimpl(composerM4937constructorimpl8, modifierMaterializeModifier8, ComposeUiNode.INSTANCE.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(composer4, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                        RowScopeInstance rowScopeInstance4 = RowScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composer4, -823872107, "C2292@81721L56,2293@81794L56:TicketsShareScreens.kt#n9ob9m");
                        modifier4 = companion;
                        ShareOutlinedButton("拒绝", function8, RowScope.weight$default(rowScopeInstance4, Modifier.INSTANCE, 1.0f, false, 2, null), composer4, ((i3 >> 12) & StylePropertiesKt.TextDirectionMask) | 6, 0);
                        function9 = function8;
                        Modifier modifierWeight$default4 = RowScope.weight$default(rowScopeInstance4, Modifier.INSTANCE, 1.0f, false, 2, null);
                        int i14 = ((i3 >> 9) & StylePropertiesKt.TextDirectionMask) | 6;
                        function10 = function6;
                        ShareOutlinedButton("接受", function10, modifierWeight$default4, composer4, i14, 0);
                        ComposerKt.sourceInformationMarkerEnd(composer4);
                        ComposerKt.sourceInformationMarkerEnd(composer4);
                        composer4.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composer4);
                        ComposerKt.sourceInformationMarkerEnd(composer4);
                        ComposerKt.sourceInformationMarkerEnd(composer4);
                        composer4.endReplaceGroup();
                        composer2 = composer4;
                    } else {
                        function9 = function8;
                        modifier4 = companion;
                        function10 = function6;
                        composer3.startReplaceGroup(842548299);
                        ComposerKt.sourceInformation(composer3, "2296@81894L60");
                        composer2 = composer3;
                        TextKt.m3661TextNvy7gAk("票据正在传输…", null, ColorKt.Color(4287598486L), null, TextUnitKt.getSp(12), null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer2, 24966, 0, 262122);
                        composer2.endReplaceGroup();
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    composer2.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    function4 = function10;
                    z3 = z4;
                    modifier3 = modifier4;
                    function5 = function9;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.tickets.TicketsShareScreensKt$$ExternalSyntheticLambda72
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj2, Object obj3) {
                            return TicketsShareScreensKt.TicketTransferTicketCard_RfXq3Jk$lambda$289(list, f, modifier3, z3, function4, function5, i, i2, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    });
                }
            }
            i3 |= 3072;
            i6 = i2 & 16;
            if (i6 != 0) {
                if ((i & 24576) == 0) {
                    function2 = function0;
                    if (composerStartRestartGroup.changedInstance(function2)) {
                        i7 = 16384;
                    } else {
                        i7 = 8192;
                    }
                    i3 |= i7;
                }
                i8 = i2 & 32;
                if (i8 != 0) {
                    if ((196608 & i) == 0) {
                        function3 = function1;
                        if (composerStartRestartGroup.changedInstance(function3)) {
                            i9 = 131072;
                        } else {
                            i9 = 65536;
                        }
                        i3 |= i9;
                    }
                    if ((74899 & i3) != 74898) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z2, i3 & 1)) {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        z3 = z;
                        modifier3 = modifier2;
                        function4 = function2;
                        function5 = function3;
                    } else {
                        if (i10 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i4 != 0) {
                            z4 = false;
                        } else {
                            z4 = z;
                        }
                        if (i6 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2002143589, "CC(remember):TicketsShareScreens.kt#9igjgp");
                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue2 = new Function0() { // from class: com.example.tickets.TicketsShareScreensKt$$ExternalSyntheticLambda70
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return Unit.INSTANCE;
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            function6 = (Function0) objRememberedValue2;
                        } else {
                            function6 = function2;
                        }
                        if (i8 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2002142597, "CC(remember):TicketsShareScreens.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = new Function0() { // from class: com.example.tickets.TicketsShareScreensKt$$ExternalSyntheticLambda71
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return Unit.INSTANCE;
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            function7 = (Function0) objRememberedValue;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        } else {
                            function7 = function3;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(391212249, i3, -1, "com.example.tickets.TicketTransferTicketCard (TicketsShareScreens.kt:2267)");
                        }
                        ticketData = (TicketData) CollectionsKt.firstOrNull((List) list2);
                        str = "票据";
                        if (ticketData != null) {
                            str2 = "票据";
                        } else {
                            str2 = "票据";
                        }
                        ticketData2 = (TicketData) CollectionsKt.firstOrNull((List) list2);
                        if (ticketData2 != null) {
                            str = strTicketShareTypeName;
                        }
                        Modifier modifierM1424paddingVpY3zN8 = PaddingKt.m1424paddingVpY3zN4(BorderKt.m659borderxT4_qwU(BackgroundKt.m648backgroundbw27NRU$default(ClipKt.clip(SizeKt.m1476height3ABfNKs(SizeKt.m1495width3ABfNKs(companion, Dp.m8748constructorimpl(380.0f)), Dp.m8748constructorimpl(270.0f)), RoundedCornerShapeKt.m1756RoundedCornerShape0680j_4(f2)), ColorKt.Color(4279703322L), null, 2, null), Dp.m8748constructorimpl(1.0f), Color.m5837copywmQWz5c$default(Color.INSTANCE.m5875getWhite0d7_KjU(), 0.18f, 0.0f, 0.0f, 0.0f, 14, null), RoundedCornerShapeKt.m1756RoundedCornerShape0680j_4(f2)), Dp.m8748constructorimpl(20.0f), Dp.m8748constructorimpl(18.0f));
                        Alignment.Horizontal centerHorizontally5 = Alignment.INSTANCE.getCenterHorizontally();
                        Arrangement.HorizontalOrVertical center5 = Arrangement.INSTANCE.getCenter();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                        MeasurePolicy measurePolicyColumnMeasurePolicy5 = ColumnKt.columnMeasurePolicy(center5, centerHorizontally5, composerStartRestartGroup, 54);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
                        int iHashCode9 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                        CompositionLocalMap currentCompositionLocalMap9 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier9 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1424paddingVpY3zN8);
                        constructor = ComposeUiNode.INSTANCE.getConstructor();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)410@16216L9:Composables.kt#9igjgp");
                        if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composerStartRestartGroup.startReusableNode();
                        if (composerStartRestartGroup.getInserting()) {
                            composerStartRestartGroup.createNode(constructor);
                        } else {
                            composerStartRestartGroup.useNode();
                        }
                        Composer composerM4937constructorimpl9 = Updater.m4937constructorimpl(composerStartRestartGroup);
                        Updater.m4945setimpl(composerM4937constructorimpl9, measurePolicyColumnMeasurePolicy5, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m4945setimpl(composerM4937constructorimpl9, currentCompositionLocalMap9, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Updater.m4945setimpl(composerM4937constructorimpl9, Integer.valueOf(iHashCode9), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                        Updater.m4943reconcileimpl(composerM4937constructorimpl9, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                        Updater.m4945setimpl(composerM4937constructorimpl9, modifierMaterializeModifier9, ComposeUiNode.INSTANCE.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                        ColumnScopeInstance columnScopeInstance5 = ColumnScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 841490239, "C2281@80779L104,2282@80892L29,2283@80930L160,2284@81099L30,2287@81406L62:TicketsShareScreens.kt#n9ob9m");
                        if (list2.size() != 1) {
                            str = list2.size() + "张票据";
                        }
                        TextKt.m3661TextNvy7gAk(str, null, ColorKt.Color(4287795865L), null, TextUnitKt.getSp(12), null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composerStartRestartGroup, 24960, 0, 262122);
                        SpacerKt.Spacer(SizeKt.m1476height3ABfNKs(Modifier.INSTANCE, Dp.m8748constructorimpl(7.0f)), composerStartRestartGroup, 6);
                        function8 = function7;
                        TextKt.m3661TextNvy7gAk(str2, null, Color.INSTANCE.m5875getWhite0d7_KjU(), null, TextUnitKt.getSp(21), null, FontWeight.INSTANCE.getMedium(), null, 0L, null, TextAlign.m8619boximpl(TextAlign.INSTANCE.m8626getCentere0LSkKk()), 0L, TextOverflow.INSTANCE.m8684getEllipsisgIe3tQ8(), false, 2, 0, null, null, composerStartRestartGroup, 1597824, 24960, 240554);
                        composer3 = composerStartRestartGroup;
                        SpacerKt.Spacer(SizeKt.m1476height3ABfNKs(Modifier.INSTANCE, Dp.m8748constructorimpl(10.0f)), composer3, 6);
                        ticketData3 = (TicketData) CollectionsKt.firstOrNull((List) list);
                        if (ticketData3 != null) {
                            List listListOf5 = CollectionsKt.listOf((Object[]) new String[]{ticketData3.getFrom(), ticketData3.getTo()});
                            arrayList = new ArrayList();
                            while (r9.hasNext()) {
                                if (!StringsKt.isBlank((String) obj)) {
                                    arrayList.add(obj);
                                }
                            }
                            strJoinToString$default = CollectionsKt.joinToString$default(arrayList, " → ", null, null, 0, null, null, 62, null);
                        } else {
                            strJoinToString$default = null;
                        }
                        if (strJoinToString$default == null) {
                            strJoinToString$default = "";
                        }
                        str3 = strJoinToString$default;
                        if (StringsKt.isBlank(str3)) {
                            composer3.startReplaceGroup(841966615);
                            ComposerKt.sourceInformation(composer3, "2286@81293L104");
                            TextKt.m3661TextNvy7gAk(strJoinToString$default, null, ColorKt.Color(4289374895L), null, TextUnitKt.getSp(13), null, null, null, 0L, null, null, 0L, TextOverflow.INSTANCE.m8684getEllipsisgIe3tQ8(), false, 1, 0, null, null, composer3, 24960, 24960, 241642);
                            composer3 = composer3;
                        } else {
                            composer3.startReplaceGroup(761319743);
                        }
                        composer3.endReplaceGroup();
                        Modifier.Companion companion6 = Modifier.INSTANCE;
                        if (StringsKt.isBlank(str3)) {
                            fM8748constructorimpl = Dp.m8748constructorimpl(20.0f);
                        } else {
                            fM8748constructorimpl = Dp.m8748constructorimpl(14.0f);
                        }
                        SpacerKt.Spacer(SizeKt.m1476height3ABfNKs(companion6, fM8748constructorimpl), composer3, 0);
                        if (z4) {
                            composer3.startReplaceGroup(842174563);
                            ComposerKt.sourceInformation(composer3, "2289@81508L57,2290@81578L30,2291@81621L243");
                            composer4 = composer3;
                            TextKt.m3661TextNvy7gAk("收到票据", null, ColorKt.Color(4287598486L), null, TextUnitKt.getSp(12), null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer4, 24966, 0, 262122);
                            SpacerKt.Spacer(SizeKt.m1476height3ABfNKs(Modifier.INSTANCE, Dp.m8748constructorimpl(14.0f)), composer4, 6);
                            Modifier modifierFillMaxWidth$default5 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                            Arrangement.HorizontalOrVertical horizontalOrVerticalM1115spacedBy0680j_8 = Arrangement.INSTANCE.m1115spacedBy0680j_4(Dp.m8748constructorimpl(10.0f));
                            ComposerKt.sourceInformationMarkerStart(composer4, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                            MeasurePolicy measurePolicyRowMeasurePolicy5 = RowKt.rowMeasurePolicy(horizontalOrVerticalM1115spacedBy0680j_8, Alignment.INSTANCE.getTop(), composer4, 6);
                            ComposerKt.sourceInformationMarkerStart(composer4, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
                            int iHashCode10 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer4, 0));
                            CompositionLocalMap currentCompositionLocalMap10 = composer4.getCurrentCompositionLocalMap();
                            Modifier modifierMaterializeModifier10 = ComposedModifierKt.materializeModifier(composer4, modifierFillMaxWidth$default5);
                            constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                            ComposerKt.sourceInformationMarkerStart(composer4, -553112988, "CC(ReusableComposeNode)N(factory,update,content)410@16216L9:Composables.kt#9igjgp");
                            if (!(composer4.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            composer4.startReusableNode();
                            if (composer4.getInserting()) {
                                composer4.createNode(constructor2);
                            } else {
                                composer4.useNode();
                            }
                            Composer composerM4937constructorimpl10 = Updater.m4937constructorimpl(composer4);
                            Updater.m4945setimpl(composerM4937constructorimpl10, measurePolicyRowMeasurePolicy5, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                            Updater.m4945setimpl(composerM4937constructorimpl10, currentCompositionLocalMap10, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                            Updater.m4945setimpl(composerM4937constructorimpl10, Integer.valueOf(iHashCode10), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                            Updater.m4943reconcileimpl(composerM4937constructorimpl10, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                            Updater.m4945setimpl(composerM4937constructorimpl10, modifierMaterializeModifier10, ComposeUiNode.INSTANCE.getSetModifier());
                            ComposerKt.sourceInformationMarkerStart(composer4, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                            RowScopeInstance rowScopeInstance5 = RowScopeInstance.INSTANCE;
                            ComposerKt.sourceInformationMarkerStart(composer4, -823872107, "C2292@81721L56,2293@81794L56:TicketsShareScreens.kt#n9ob9m");
                            modifier4 = companion;
                            ShareOutlinedButton("拒绝", function8, RowScope.weight$default(rowScopeInstance5, Modifier.INSTANCE, 1.0f, false, 2, null), composer4, ((i3 >> 12) & StylePropertiesKt.TextDirectionMask) | 6, 0);
                            function9 = function8;
                            Modifier modifierWeight$default5 = RowScope.weight$default(rowScopeInstance5, Modifier.INSTANCE, 1.0f, false, 2, null);
                            int i15 = ((i3 >> 9) & StylePropertiesKt.TextDirectionMask) | 6;
                            function10 = function6;
                            ShareOutlinedButton("接受", function10, modifierWeight$default5, composer4, i15, 0);
                            ComposerKt.sourceInformationMarkerEnd(composer4);
                            ComposerKt.sourceInformationMarkerEnd(composer4);
                            composer4.endNode();
                            ComposerKt.sourceInformationMarkerEnd(composer4);
                            ComposerKt.sourceInformationMarkerEnd(composer4);
                            ComposerKt.sourceInformationMarkerEnd(composer4);
                            composer4.endReplaceGroup();
                            composer2 = composer4;
                        } else {
                            function9 = function8;
                            modifier4 = companion;
                            function10 = function6;
                            composer3.startReplaceGroup(842548299);
                            ComposerKt.sourceInformation(composer3, "2296@81894L60");
                            composer2 = composer3;
                            TextKt.m3661TextNvy7gAk("票据正在传输…", null, ColorKt.Color(4287598486L), null, TextUnitKt.getSp(12), null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer2, 24966, 0, 262122);
                            composer2.endReplaceGroup();
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        composer2.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        function4 = function10;
                        z3 = z4;
                        modifier3 = modifier4;
                        function5 = function9;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.tickets.TicketsShareScreensKt$$ExternalSyntheticLambda72
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj2, Object obj3) {
                                return TicketsShareScreensKt.TicketTransferTicketCard_RfXq3Jk$lambda$289(list, f, modifier3, z3, function4, function5, i, i2, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        });
                    }
                }
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                function3 = function1;
                if ((74899 & i3) != 74898) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z2, i3 & 1)) {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    z3 = z;
                    modifier3 = modifier2;
                    function4 = function2;
                    function5 = function3;
                } else {
                    if (i10 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i4 != 0) {
                        z4 = false;
                    } else {
                        z4 = z;
                    }
                    if (i6 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2002143589, "CC(remember):TicketsShareScreens.kt#9igjgp");
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue2 = new Function0() { // from class: com.example.tickets.TicketsShareScreensKt$$ExternalSyntheticLambda70
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return Unit.INSTANCE;
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        function6 = (Function0) objRememberedValue2;
                    } else {
                        function6 = function2;
                    }
                    if (i8 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2002142597, "CC(remember):TicketsShareScreens.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new Function0() { // from class: com.example.tickets.TicketsShareScreensKt$$ExternalSyntheticLambda71
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return Unit.INSTANCE;
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        function7 = (Function0) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    } else {
                        function7 = function3;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(391212249, i3, -1, "com.example.tickets.TicketTransferTicketCard (TicketsShareScreens.kt:2267)");
                    }
                    ticketData = (TicketData) CollectionsKt.firstOrNull((List) list2);
                    str = "票据";
                    if (ticketData != null) {
                        str2 = "票据";
                    } else {
                        str2 = "票据";
                    }
                    ticketData2 = (TicketData) CollectionsKt.firstOrNull((List) list2);
                    if (ticketData2 != null) {
                        str = strTicketShareTypeName;
                    }
                    Modifier modifierM1424paddingVpY3zN9 = PaddingKt.m1424paddingVpY3zN4(BorderKt.m659borderxT4_qwU(BackgroundKt.m648backgroundbw27NRU$default(ClipKt.clip(SizeKt.m1476height3ABfNKs(SizeKt.m1495width3ABfNKs(companion, Dp.m8748constructorimpl(380.0f)), Dp.m8748constructorimpl(270.0f)), RoundedCornerShapeKt.m1756RoundedCornerShape0680j_4(f2)), ColorKt.Color(4279703322L), null, 2, null), Dp.m8748constructorimpl(1.0f), Color.m5837copywmQWz5c$default(Color.INSTANCE.m5875getWhite0d7_KjU(), 0.18f, 0.0f, 0.0f, 0.0f, 14, null), RoundedCornerShapeKt.m1756RoundedCornerShape0680j_4(f2)), Dp.m8748constructorimpl(20.0f), Dp.m8748constructorimpl(18.0f));
                    Alignment.Horizontal centerHorizontally6 = Alignment.INSTANCE.getCenterHorizontally();
                    Arrangement.HorizontalOrVertical center6 = Arrangement.INSTANCE.getCenter();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                    MeasurePolicy measurePolicyColumnMeasurePolicy6 = ColumnKt.columnMeasurePolicy(center6, centerHorizontally6, composerStartRestartGroup, 54);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
                    int iHashCode11 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap11 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier11 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1424paddingVpY3zN9);
                    constructor = ComposeUiNode.INSTANCE.getConstructor();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)410@16216L9:Composables.kt#9igjgp");
                    if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(constructor);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    Composer composerM4937constructorimpl11 = Updater.m4937constructorimpl(composerStartRestartGroup);
                    Updater.m4945setimpl(composerM4937constructorimpl11, measurePolicyColumnMeasurePolicy6, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m4945setimpl(composerM4937constructorimpl11, currentCompositionLocalMap11, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Updater.m4945setimpl(composerM4937constructorimpl11, Integer.valueOf(iHashCode11), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                    Updater.m4943reconcileimpl(composerM4937constructorimpl11, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                    Updater.m4945setimpl(composerM4937constructorimpl11, modifierMaterializeModifier11, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                    ColumnScopeInstance columnScopeInstance6 = ColumnScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 841490239, "C2281@80779L104,2282@80892L29,2283@80930L160,2284@81099L30,2287@81406L62:TicketsShareScreens.kt#n9ob9m");
                    if (list2.size() != 1) {
                        str = list2.size() + "张票据";
                    }
                    TextKt.m3661TextNvy7gAk(str, null, ColorKt.Color(4287795865L), null, TextUnitKt.getSp(12), null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composerStartRestartGroup, 24960, 0, 262122);
                    SpacerKt.Spacer(SizeKt.m1476height3ABfNKs(Modifier.INSTANCE, Dp.m8748constructorimpl(7.0f)), composerStartRestartGroup, 6);
                    function8 = function7;
                    TextKt.m3661TextNvy7gAk(str2, null, Color.INSTANCE.m5875getWhite0d7_KjU(), null, TextUnitKt.getSp(21), null, FontWeight.INSTANCE.getMedium(), null, 0L, null, TextAlign.m8619boximpl(TextAlign.INSTANCE.m8626getCentere0LSkKk()), 0L, TextOverflow.INSTANCE.m8684getEllipsisgIe3tQ8(), false, 2, 0, null, null, composerStartRestartGroup, 1597824, 24960, 240554);
                    composer3 = composerStartRestartGroup;
                    SpacerKt.Spacer(SizeKt.m1476height3ABfNKs(Modifier.INSTANCE, Dp.m8748constructorimpl(10.0f)), composer3, 6);
                    ticketData3 = (TicketData) CollectionsKt.firstOrNull((List) list);
                    if (ticketData3 != null) {
                        List listListOf6 = CollectionsKt.listOf((Object[]) new String[]{ticketData3.getFrom(), ticketData3.getTo()});
                        arrayList = new ArrayList();
                        while (r9.hasNext()) {
                            if (!StringsKt.isBlank((String) obj)) {
                                arrayList.add(obj);
                            }
                        }
                        strJoinToString$default = CollectionsKt.joinToString$default(arrayList, " → ", null, null, 0, null, null, 62, null);
                    } else {
                        strJoinToString$default = null;
                    }
                    if (strJoinToString$default == null) {
                        strJoinToString$default = "";
                    }
                    str3 = strJoinToString$default;
                    if (StringsKt.isBlank(str3)) {
                        composer3.startReplaceGroup(841966615);
                        ComposerKt.sourceInformation(composer3, "2286@81293L104");
                        TextKt.m3661TextNvy7gAk(strJoinToString$default, null, ColorKt.Color(4289374895L), null, TextUnitKt.getSp(13), null, null, null, 0L, null, null, 0L, TextOverflow.INSTANCE.m8684getEllipsisgIe3tQ8(), false, 1, 0, null, null, composer3, 24960, 24960, 241642);
                        composer3 = composer3;
                    } else {
                        composer3.startReplaceGroup(761319743);
                    }
                    composer3.endReplaceGroup();
                    Modifier.Companion companion7 = Modifier.INSTANCE;
                    if (StringsKt.isBlank(str3)) {
                        fM8748constructorimpl = Dp.m8748constructorimpl(20.0f);
                    } else {
                        fM8748constructorimpl = Dp.m8748constructorimpl(14.0f);
                    }
                    SpacerKt.Spacer(SizeKt.m1476height3ABfNKs(companion7, fM8748constructorimpl), composer3, 0);
                    if (z4) {
                        composer3.startReplaceGroup(842174563);
                        ComposerKt.sourceInformation(composer3, "2289@81508L57,2290@81578L30,2291@81621L243");
                        composer4 = composer3;
                        TextKt.m3661TextNvy7gAk("收到票据", null, ColorKt.Color(4287598486L), null, TextUnitKt.getSp(12), null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer4, 24966, 0, 262122);
                        SpacerKt.Spacer(SizeKt.m1476height3ABfNKs(Modifier.INSTANCE, Dp.m8748constructorimpl(14.0f)), composer4, 6);
                        Modifier modifierFillMaxWidth$default6 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                        Arrangement.HorizontalOrVertical horizontalOrVerticalM1115spacedBy0680j_9 = Arrangement.INSTANCE.m1115spacedBy0680j_4(Dp.m8748constructorimpl(10.0f));
                        ComposerKt.sourceInformationMarkerStart(composer4, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                        MeasurePolicy measurePolicyRowMeasurePolicy6 = RowKt.rowMeasurePolicy(horizontalOrVerticalM1115spacedBy0680j_9, Alignment.INSTANCE.getTop(), composer4, 6);
                        ComposerKt.sourceInformationMarkerStart(composer4, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
                        int iHashCode12 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer4, 0));
                        CompositionLocalMap currentCompositionLocalMap12 = composer4.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier12 = ComposedModifierKt.materializeModifier(composer4, modifierFillMaxWidth$default6);
                        constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                        ComposerKt.sourceInformationMarkerStart(composer4, -553112988, "CC(ReusableComposeNode)N(factory,update,content)410@16216L9:Composables.kt#9igjgp");
                        if (!(composer4.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composer4.startReusableNode();
                        if (composer4.getInserting()) {
                            composer4.createNode(constructor2);
                        } else {
                            composer4.useNode();
                        }
                        Composer composerM4937constructorimpl12 = Updater.m4937constructorimpl(composer4);
                        Updater.m4945setimpl(composerM4937constructorimpl12, measurePolicyRowMeasurePolicy6, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m4945setimpl(composerM4937constructorimpl12, currentCompositionLocalMap12, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Updater.m4945setimpl(composerM4937constructorimpl12, Integer.valueOf(iHashCode12), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                        Updater.m4943reconcileimpl(composerM4937constructorimpl12, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                        Updater.m4945setimpl(composerM4937constructorimpl12, modifierMaterializeModifier12, ComposeUiNode.INSTANCE.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(composer4, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                        RowScopeInstance rowScopeInstance6 = RowScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composer4, -823872107, "C2292@81721L56,2293@81794L56:TicketsShareScreens.kt#n9ob9m");
                        modifier4 = companion;
                        ShareOutlinedButton("拒绝", function8, RowScope.weight$default(rowScopeInstance6, Modifier.INSTANCE, 1.0f, false, 2, null), composer4, ((i3 >> 12) & StylePropertiesKt.TextDirectionMask) | 6, 0);
                        function9 = function8;
                        Modifier modifierWeight$default6 = RowScope.weight$default(rowScopeInstance6, Modifier.INSTANCE, 1.0f, false, 2, null);
                        int i16 = ((i3 >> 9) & StylePropertiesKt.TextDirectionMask) | 6;
                        function10 = function6;
                        ShareOutlinedButton("接受", function10, modifierWeight$default6, composer4, i16, 0);
                        ComposerKt.sourceInformationMarkerEnd(composer4);
                        ComposerKt.sourceInformationMarkerEnd(composer4);
                        composer4.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composer4);
                        ComposerKt.sourceInformationMarkerEnd(composer4);
                        ComposerKt.sourceInformationMarkerEnd(composer4);
                        composer4.endReplaceGroup();
                        composer2 = composer4;
                    } else {
                        function9 = function8;
                        modifier4 = companion;
                        function10 = function6;
                        composer3.startReplaceGroup(842548299);
                        ComposerKt.sourceInformation(composer3, "2296@81894L60");
                        composer2 = composer3;
                        TextKt.m3661TextNvy7gAk("票据正在传输…", null, ColorKt.Color(4287598486L), null, TextUnitKt.getSp(12), null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer2, 24966, 0, 262122);
                        composer2.endReplaceGroup();
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    composer2.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    function4 = function10;
                    z3 = z4;
                    modifier3 = modifier4;
                    function5 = function9;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.tickets.TicketsShareScreensKt$$ExternalSyntheticLambda72
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj2, Object obj3) {
                            return TicketsShareScreensKt.TicketTransferTicketCard_RfXq3Jk$lambda$289(list, f, modifier3, z3, function4, function5, i, i2, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    });
                }
            }
            i3 |= 24576;
            function2 = function0;
            i8 = i2 & 32;
            if (i8 != 0) {
                if ((196608 & i) == 0) {
                    function3 = function1;
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i9 = 131072;
                    } else {
                        i9 = 65536;
                    }
                    i3 |= i9;
                }
                if ((74899 & i3) != 74898) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z2, i3 & 1)) {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    z3 = z;
                    modifier3 = modifier2;
                    function4 = function2;
                    function5 = function3;
                } else {
                    if (i10 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i4 != 0) {
                        z4 = false;
                    } else {
                        z4 = z;
                    }
                    if (i6 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2002143589, "CC(remember):TicketsShareScreens.kt#9igjgp");
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue2 = new Function0() { // from class: com.example.tickets.TicketsShareScreensKt$$ExternalSyntheticLambda70
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return Unit.INSTANCE;
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        function6 = (Function0) objRememberedValue2;
                    } else {
                        function6 = function2;
                    }
                    if (i8 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2002142597, "CC(remember):TicketsShareScreens.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new Function0() { // from class: com.example.tickets.TicketsShareScreensKt$$ExternalSyntheticLambda71
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return Unit.INSTANCE;
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        function7 = (Function0) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    } else {
                        function7 = function3;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(391212249, i3, -1, "com.example.tickets.TicketTransferTicketCard (TicketsShareScreens.kt:2267)");
                    }
                    ticketData = (TicketData) CollectionsKt.firstOrNull((List) list2);
                    str = "票据";
                    if (ticketData != null) {
                        str2 = "票据";
                    } else {
                        str2 = "票据";
                    }
                    ticketData2 = (TicketData) CollectionsKt.firstOrNull((List) list2);
                    if (ticketData2 != null) {
                        str = strTicketShareTypeName;
                    }
                    Modifier modifierM1424paddingVpY3zN10 = PaddingKt.m1424paddingVpY3zN4(BorderKt.m659borderxT4_qwU(BackgroundKt.m648backgroundbw27NRU$default(ClipKt.clip(SizeKt.m1476height3ABfNKs(SizeKt.m1495width3ABfNKs(companion, Dp.m8748constructorimpl(380.0f)), Dp.m8748constructorimpl(270.0f)), RoundedCornerShapeKt.m1756RoundedCornerShape0680j_4(f2)), ColorKt.Color(4279703322L), null, 2, null), Dp.m8748constructorimpl(1.0f), Color.m5837copywmQWz5c$default(Color.INSTANCE.m5875getWhite0d7_KjU(), 0.18f, 0.0f, 0.0f, 0.0f, 14, null), RoundedCornerShapeKt.m1756RoundedCornerShape0680j_4(f2)), Dp.m8748constructorimpl(20.0f), Dp.m8748constructorimpl(18.0f));
                    Alignment.Horizontal centerHorizontally7 = Alignment.INSTANCE.getCenterHorizontally();
                    Arrangement.HorizontalOrVertical center7 = Arrangement.INSTANCE.getCenter();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                    MeasurePolicy measurePolicyColumnMeasurePolicy7 = ColumnKt.columnMeasurePolicy(center7, centerHorizontally7, composerStartRestartGroup, 54);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
                    int iHashCode13 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap13 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier13 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1424paddingVpY3zN10);
                    constructor = ComposeUiNode.INSTANCE.getConstructor();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)410@16216L9:Composables.kt#9igjgp");
                    if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(constructor);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    Composer composerM4937constructorimpl13 = Updater.m4937constructorimpl(composerStartRestartGroup);
                    Updater.m4945setimpl(composerM4937constructorimpl13, measurePolicyColumnMeasurePolicy7, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m4945setimpl(composerM4937constructorimpl13, currentCompositionLocalMap13, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Updater.m4945setimpl(composerM4937constructorimpl13, Integer.valueOf(iHashCode13), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                    Updater.m4943reconcileimpl(composerM4937constructorimpl13, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                    Updater.m4945setimpl(composerM4937constructorimpl13, modifierMaterializeModifier13, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                    ColumnScopeInstance columnScopeInstance7 = ColumnScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 841490239, "C2281@80779L104,2282@80892L29,2283@80930L160,2284@81099L30,2287@81406L62:TicketsShareScreens.kt#n9ob9m");
                    if (list2.size() != 1) {
                        str = list2.size() + "张票据";
                    }
                    TextKt.m3661TextNvy7gAk(str, null, ColorKt.Color(4287795865L), null, TextUnitKt.getSp(12), null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composerStartRestartGroup, 24960, 0, 262122);
                    SpacerKt.Spacer(SizeKt.m1476height3ABfNKs(Modifier.INSTANCE, Dp.m8748constructorimpl(7.0f)), composerStartRestartGroup, 6);
                    function8 = function7;
                    TextKt.m3661TextNvy7gAk(str2, null, Color.INSTANCE.m5875getWhite0d7_KjU(), null, TextUnitKt.getSp(21), null, FontWeight.INSTANCE.getMedium(), null, 0L, null, TextAlign.m8619boximpl(TextAlign.INSTANCE.m8626getCentere0LSkKk()), 0L, TextOverflow.INSTANCE.m8684getEllipsisgIe3tQ8(), false, 2, 0, null, null, composerStartRestartGroup, 1597824, 24960, 240554);
                    composer3 = composerStartRestartGroup;
                    SpacerKt.Spacer(SizeKt.m1476height3ABfNKs(Modifier.INSTANCE, Dp.m8748constructorimpl(10.0f)), composer3, 6);
                    ticketData3 = (TicketData) CollectionsKt.firstOrNull((List) list);
                    if (ticketData3 != null) {
                        List listListOf7 = CollectionsKt.listOf((Object[]) new String[]{ticketData3.getFrom(), ticketData3.getTo()});
                        arrayList = new ArrayList();
                        while (r9.hasNext()) {
                            if (!StringsKt.isBlank((String) obj)) {
                                arrayList.add(obj);
                            }
                        }
                        strJoinToString$default = CollectionsKt.joinToString$default(arrayList, " → ", null, null, 0, null, null, 62, null);
                    } else {
                        strJoinToString$default = null;
                    }
                    if (strJoinToString$default == null) {
                        strJoinToString$default = "";
                    }
                    str3 = strJoinToString$default;
                    if (StringsKt.isBlank(str3)) {
                        composer3.startReplaceGroup(841966615);
                        ComposerKt.sourceInformation(composer3, "2286@81293L104");
                        TextKt.m3661TextNvy7gAk(strJoinToString$default, null, ColorKt.Color(4289374895L), null, TextUnitKt.getSp(13), null, null, null, 0L, null, null, 0L, TextOverflow.INSTANCE.m8684getEllipsisgIe3tQ8(), false, 1, 0, null, null, composer3, 24960, 24960, 241642);
                        composer3 = composer3;
                    } else {
                        composer3.startReplaceGroup(761319743);
                    }
                    composer3.endReplaceGroup();
                    Modifier.Companion companion8 = Modifier.INSTANCE;
                    if (StringsKt.isBlank(str3)) {
                        fM8748constructorimpl = Dp.m8748constructorimpl(20.0f);
                    } else {
                        fM8748constructorimpl = Dp.m8748constructorimpl(14.0f);
                    }
                    SpacerKt.Spacer(SizeKt.m1476height3ABfNKs(companion8, fM8748constructorimpl), composer3, 0);
                    if (z4) {
                        composer3.startReplaceGroup(842174563);
                        ComposerKt.sourceInformation(composer3, "2289@81508L57,2290@81578L30,2291@81621L243");
                        composer4 = composer3;
                        TextKt.m3661TextNvy7gAk("收到票据", null, ColorKt.Color(4287598486L), null, TextUnitKt.getSp(12), null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer4, 24966, 0, 262122);
                        SpacerKt.Spacer(SizeKt.m1476height3ABfNKs(Modifier.INSTANCE, Dp.m8748constructorimpl(14.0f)), composer4, 6);
                        Modifier modifierFillMaxWidth$default7 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                        Arrangement.HorizontalOrVertical horizontalOrVerticalM1115spacedBy0680j_10 = Arrangement.INSTANCE.m1115spacedBy0680j_4(Dp.m8748constructorimpl(10.0f));
                        ComposerKt.sourceInformationMarkerStart(composer4, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                        MeasurePolicy measurePolicyRowMeasurePolicy7 = RowKt.rowMeasurePolicy(horizontalOrVerticalM1115spacedBy0680j_10, Alignment.INSTANCE.getTop(), composer4, 6);
                        ComposerKt.sourceInformationMarkerStart(composer4, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
                        int iHashCode14 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer4, 0));
                        CompositionLocalMap currentCompositionLocalMap14 = composer4.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier14 = ComposedModifierKt.materializeModifier(composer4, modifierFillMaxWidth$default7);
                        constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                        ComposerKt.sourceInformationMarkerStart(composer4, -553112988, "CC(ReusableComposeNode)N(factory,update,content)410@16216L9:Composables.kt#9igjgp");
                        if (!(composer4.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composer4.startReusableNode();
                        if (composer4.getInserting()) {
                            composer4.createNode(constructor2);
                        } else {
                            composer4.useNode();
                        }
                        Composer composerM4937constructorimpl14 = Updater.m4937constructorimpl(composer4);
                        Updater.m4945setimpl(composerM4937constructorimpl14, measurePolicyRowMeasurePolicy7, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m4945setimpl(composerM4937constructorimpl14, currentCompositionLocalMap14, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Updater.m4945setimpl(composerM4937constructorimpl14, Integer.valueOf(iHashCode14), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                        Updater.m4943reconcileimpl(composerM4937constructorimpl14, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                        Updater.m4945setimpl(composerM4937constructorimpl14, modifierMaterializeModifier14, ComposeUiNode.INSTANCE.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(composer4, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                        RowScopeInstance rowScopeInstance7 = RowScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composer4, -823872107, "C2292@81721L56,2293@81794L56:TicketsShareScreens.kt#n9ob9m");
                        modifier4 = companion;
                        ShareOutlinedButton("拒绝", function8, RowScope.weight$default(rowScopeInstance7, Modifier.INSTANCE, 1.0f, false, 2, null), composer4, ((i3 >> 12) & StylePropertiesKt.TextDirectionMask) | 6, 0);
                        function9 = function8;
                        Modifier modifierWeight$default7 = RowScope.weight$default(rowScopeInstance7, Modifier.INSTANCE, 1.0f, false, 2, null);
                        int i17 = ((i3 >> 9) & StylePropertiesKt.TextDirectionMask) | 6;
                        function10 = function6;
                        ShareOutlinedButton("接受", function10, modifierWeight$default7, composer4, i17, 0);
                        ComposerKt.sourceInformationMarkerEnd(composer4);
                        ComposerKt.sourceInformationMarkerEnd(composer4);
                        composer4.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composer4);
                        ComposerKt.sourceInformationMarkerEnd(composer4);
                        ComposerKt.sourceInformationMarkerEnd(composer4);
                        composer4.endReplaceGroup();
                        composer2 = composer4;
                    } else {
                        function9 = function8;
                        modifier4 = companion;
                        function10 = function6;
                        composer3.startReplaceGroup(842548299);
                        ComposerKt.sourceInformation(composer3, "2296@81894L60");
                        composer2 = composer3;
                        TextKt.m3661TextNvy7gAk("票据正在传输…", null, ColorKt.Color(4287598486L), null, TextUnitKt.getSp(12), null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer2, 24966, 0, 262122);
                        composer2.endReplaceGroup();
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    composer2.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    function4 = function10;
                    z3 = z4;
                    modifier3 = modifier4;
                    function5 = function9;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.tickets.TicketsShareScreensKt$$ExternalSyntheticLambda72
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj2, Object obj3) {
                            return TicketsShareScreensKt.TicketTransferTicketCard_RfXq3Jk$lambda$289(list, f, modifier3, z3, function4, function5, i, i2, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    });
                }
            }
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            function3 = function1;
            if ((74899 & i3) != 74898) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z2, i3 & 1)) {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                z3 = z;
                modifier3 = modifier2;
                function4 = function2;
                function5 = function3;
            } else {
                if (i10 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i4 != 0) {
                    z4 = false;
                } else {
                    z4 = z;
                }
                if (i6 != 0) {
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2002143589, "CC(remember):TicketsShareScreens.kt#9igjgp");
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = new Function0() { // from class: com.example.tickets.TicketsShareScreensKt$$ExternalSyntheticLambda70
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Unit.INSTANCE;
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    function6 = (Function0) objRememberedValue2;
                } else {
                    function6 = function2;
                }
                if (i8 != 0) {
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2002142597, "CC(remember):TicketsShareScreens.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new Function0() { // from class: com.example.tickets.TicketsShareScreensKt$$ExternalSyntheticLambda71
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Unit.INSTANCE;
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    function7 = (Function0) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                } else {
                    function7 = function3;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(391212249, i3, -1, "com.example.tickets.TicketTransferTicketCard (TicketsShareScreens.kt:2267)");
                }
                ticketData = (TicketData) CollectionsKt.firstOrNull((List) list2);
                str = "票据";
                if (ticketData != null) {
                    str2 = "票据";
                } else {
                    str2 = "票据";
                }
                ticketData2 = (TicketData) CollectionsKt.firstOrNull((List) list2);
                if (ticketData2 != null) {
                    str = strTicketShareTypeName;
                }
                Modifier modifierM1424paddingVpY3zN11 = PaddingKt.m1424paddingVpY3zN4(BorderKt.m659borderxT4_qwU(BackgroundKt.m648backgroundbw27NRU$default(ClipKt.clip(SizeKt.m1476height3ABfNKs(SizeKt.m1495width3ABfNKs(companion, Dp.m8748constructorimpl(380.0f)), Dp.m8748constructorimpl(270.0f)), RoundedCornerShapeKt.m1756RoundedCornerShape0680j_4(f2)), ColorKt.Color(4279703322L), null, 2, null), Dp.m8748constructorimpl(1.0f), Color.m5837copywmQWz5c$default(Color.INSTANCE.m5875getWhite0d7_KjU(), 0.18f, 0.0f, 0.0f, 0.0f, 14, null), RoundedCornerShapeKt.m1756RoundedCornerShape0680j_4(f2)), Dp.m8748constructorimpl(20.0f), Dp.m8748constructorimpl(18.0f));
                Alignment.Horizontal centerHorizontally8 = Alignment.INSTANCE.getCenterHorizontally();
                Arrangement.HorizontalOrVertical center8 = Arrangement.INSTANCE.getCenter();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                MeasurePolicy measurePolicyColumnMeasurePolicy8 = ColumnKt.columnMeasurePolicy(center8, centerHorizontally8, composerStartRestartGroup, 54);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
                int iHashCode15 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap15 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier15 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1424paddingVpY3zN11);
                constructor = ComposeUiNode.INSTANCE.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)410@16216L9:Composables.kt#9igjgp");
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor);
                } else {
                    composerStartRestartGroup.useNode();
                }
                Composer composerM4937constructorimpl15 = Updater.m4937constructorimpl(composerStartRestartGroup);
                Updater.m4945setimpl(composerM4937constructorimpl15, measurePolicyColumnMeasurePolicy8, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m4945setimpl(composerM4937constructorimpl15, currentCompositionLocalMap15, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Updater.m4945setimpl(composerM4937constructorimpl15, Integer.valueOf(iHashCode15), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                Updater.m4943reconcileimpl(composerM4937constructorimpl15, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                Updater.m4945setimpl(composerM4937constructorimpl15, modifierMaterializeModifier15, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                ColumnScopeInstance columnScopeInstance8 = ColumnScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 841490239, "C2281@80779L104,2282@80892L29,2283@80930L160,2284@81099L30,2287@81406L62:TicketsShareScreens.kt#n9ob9m");
                if (list2.size() != 1) {
                    str = list2.size() + "张票据";
                }
                TextKt.m3661TextNvy7gAk(str, null, ColorKt.Color(4287795865L), null, TextUnitKt.getSp(12), null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composerStartRestartGroup, 24960, 0, 262122);
                SpacerKt.Spacer(SizeKt.m1476height3ABfNKs(Modifier.INSTANCE, Dp.m8748constructorimpl(7.0f)), composerStartRestartGroup, 6);
                function8 = function7;
                TextKt.m3661TextNvy7gAk(str2, null, Color.INSTANCE.m5875getWhite0d7_KjU(), null, TextUnitKt.getSp(21), null, FontWeight.INSTANCE.getMedium(), null, 0L, null, TextAlign.m8619boximpl(TextAlign.INSTANCE.m8626getCentere0LSkKk()), 0L, TextOverflow.INSTANCE.m8684getEllipsisgIe3tQ8(), false, 2, 0, null, null, composerStartRestartGroup, 1597824, 24960, 240554);
                composer3 = composerStartRestartGroup;
                SpacerKt.Spacer(SizeKt.m1476height3ABfNKs(Modifier.INSTANCE, Dp.m8748constructorimpl(10.0f)), composer3, 6);
                ticketData3 = (TicketData) CollectionsKt.firstOrNull((List) list);
                if (ticketData3 != null) {
                    List listListOf8 = CollectionsKt.listOf((Object[]) new String[]{ticketData3.getFrom(), ticketData3.getTo()});
                    arrayList = new ArrayList();
                    while (r9.hasNext()) {
                        if (!StringsKt.isBlank((String) obj)) {
                            arrayList.add(obj);
                        }
                    }
                    strJoinToString$default = CollectionsKt.joinToString$default(arrayList, " → ", null, null, 0, null, null, 62, null);
                } else {
                    strJoinToString$default = null;
                }
                if (strJoinToString$default == null) {
                    strJoinToString$default = "";
                }
                str3 = strJoinToString$default;
                if (StringsKt.isBlank(str3)) {
                    composer3.startReplaceGroup(841966615);
                    ComposerKt.sourceInformation(composer3, "2286@81293L104");
                    TextKt.m3661TextNvy7gAk(strJoinToString$default, null, ColorKt.Color(4289374895L), null, TextUnitKt.getSp(13), null, null, null, 0L, null, null, 0L, TextOverflow.INSTANCE.m8684getEllipsisgIe3tQ8(), false, 1, 0, null, null, composer3, 24960, 24960, 241642);
                    composer3 = composer3;
                } else {
                    composer3.startReplaceGroup(761319743);
                }
                composer3.endReplaceGroup();
                Modifier.Companion companion9 = Modifier.INSTANCE;
                if (StringsKt.isBlank(str3)) {
                    fM8748constructorimpl = Dp.m8748constructorimpl(20.0f);
                } else {
                    fM8748constructorimpl = Dp.m8748constructorimpl(14.0f);
                }
                SpacerKt.Spacer(SizeKt.m1476height3ABfNKs(companion9, fM8748constructorimpl), composer3, 0);
                if (z4) {
                    composer3.startReplaceGroup(842174563);
                    ComposerKt.sourceInformation(composer3, "2289@81508L57,2290@81578L30,2291@81621L243");
                    composer4 = composer3;
                    TextKt.m3661TextNvy7gAk("收到票据", null, ColorKt.Color(4287598486L), null, TextUnitKt.getSp(12), null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer4, 24966, 0, 262122);
                    SpacerKt.Spacer(SizeKt.m1476height3ABfNKs(Modifier.INSTANCE, Dp.m8748constructorimpl(14.0f)), composer4, 6);
                    Modifier modifierFillMaxWidth$default8 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                    Arrangement.HorizontalOrVertical horizontalOrVerticalM1115spacedBy0680j_11 = Arrangement.INSTANCE.m1115spacedBy0680j_4(Dp.m8748constructorimpl(10.0f));
                    ComposerKt.sourceInformationMarkerStart(composer4, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                    MeasurePolicy measurePolicyRowMeasurePolicy8 = RowKt.rowMeasurePolicy(horizontalOrVerticalM1115spacedBy0680j_11, Alignment.INSTANCE.getTop(), composer4, 6);
                    ComposerKt.sourceInformationMarkerStart(composer4, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
                    int iHashCode16 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer4, 0));
                    CompositionLocalMap currentCompositionLocalMap16 = composer4.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier16 = ComposedModifierKt.materializeModifier(composer4, modifierFillMaxWidth$default8);
                    constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                    ComposerKt.sourceInformationMarkerStart(composer4, -553112988, "CC(ReusableComposeNode)N(factory,update,content)410@16216L9:Composables.kt#9igjgp");
                    if (!(composer4.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composer4.startReusableNode();
                    if (composer4.getInserting()) {
                        composer4.createNode(constructor2);
                    } else {
                        composer4.useNode();
                    }
                    Composer composerM4937constructorimpl16 = Updater.m4937constructorimpl(composer4);
                    Updater.m4945setimpl(composerM4937constructorimpl16, measurePolicyRowMeasurePolicy8, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m4945setimpl(composerM4937constructorimpl16, currentCompositionLocalMap16, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Updater.m4945setimpl(composerM4937constructorimpl16, Integer.valueOf(iHashCode16), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                    Updater.m4943reconcileimpl(composerM4937constructorimpl16, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                    Updater.m4945setimpl(composerM4937constructorimpl16, modifierMaterializeModifier16, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composer4, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                    RowScopeInstance rowScopeInstance8 = RowScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composer4, -823872107, "C2292@81721L56,2293@81794L56:TicketsShareScreens.kt#n9ob9m");
                    modifier4 = companion;
                    ShareOutlinedButton("拒绝", function8, RowScope.weight$default(rowScopeInstance8, Modifier.INSTANCE, 1.0f, false, 2, null), composer4, ((i3 >> 12) & StylePropertiesKt.TextDirectionMask) | 6, 0);
                    function9 = function8;
                    Modifier modifierWeight$default8 = RowScope.weight$default(rowScopeInstance8, Modifier.INSTANCE, 1.0f, false, 2, null);
                    int i18 = ((i3 >> 9) & StylePropertiesKt.TextDirectionMask) | 6;
                    function10 = function6;
                    ShareOutlinedButton("接受", function10, modifierWeight$default8, composer4, i18, 0);
                    ComposerKt.sourceInformationMarkerEnd(composer4);
                    ComposerKt.sourceInformationMarkerEnd(composer4);
                    composer4.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer4);
                    ComposerKt.sourceInformationMarkerEnd(composer4);
                    ComposerKt.sourceInformationMarkerEnd(composer4);
                    composer4.endReplaceGroup();
                    composer2 = composer4;
                } else {
                    function9 = function8;
                    modifier4 = companion;
                    function10 = function6;
                    composer3.startReplaceGroup(842548299);
                    ComposerKt.sourceInformation(composer3, "2296@81894L60");
                    composer2 = composer3;
                    TextKt.m3661TextNvy7gAk("票据正在传输…", null, ColorKt.Color(4287598486L), null, TextUnitKt.getSp(12), null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer2, 24966, 0, 262122);
                    composer2.endReplaceGroup();
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                function4 = function10;
                z3 = z4;
                modifier3 = modifier4;
                function5 = function9;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.tickets.TicketsShareScreensKt$$ExternalSyntheticLambda72
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj2, Object obj3) {
                        return TicketsShareScreensKt.TicketTransferTicketCard_RfXq3Jk$lambda$289(list, f, modifier3, z3, function4, function5, i, i2, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                });
            }
        }
        i3 |= 384;
        modifier2 = modifier;
        i4 = i2 & 8;
        if (i4 != 0) {
            if ((i & 3072) == 0) {
                if (composerStartRestartGroup.changed(z)) {
                    i5 = 2048;
                } else {
                    i5 = 1024;
                }
                i3 |= i5;
            }
            i6 = i2 & 16;
            if (i6 != 0) {
                if ((i & 24576) == 0) {
                    function2 = function0;
                    if (composerStartRestartGroup.changedInstance(function2)) {
                        i7 = 16384;
                    } else {
                        i7 = 8192;
                    }
                    i3 |= i7;
                }
                i8 = i2 & 32;
                if (i8 != 0) {
                    if ((196608 & i) == 0) {
                        function3 = function1;
                        if (composerStartRestartGroup.changedInstance(function3)) {
                            i9 = 131072;
                        } else {
                            i9 = 65536;
                        }
                        i3 |= i9;
                    }
                    if ((74899 & i3) != 74898) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z2, i3 & 1)) {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        z3 = z;
                        modifier3 = modifier2;
                        function4 = function2;
                        function5 = function3;
                    } else {
                        if (i10 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i4 != 0) {
                            z4 = false;
                        } else {
                            z4 = z;
                        }
                        if (i6 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2002143589, "CC(remember):TicketsShareScreens.kt#9igjgp");
                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue2 = new Function0() { // from class: com.example.tickets.TicketsShareScreensKt$$ExternalSyntheticLambda70
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return Unit.INSTANCE;
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            function6 = (Function0) objRememberedValue2;
                        } else {
                            function6 = function2;
                        }
                        if (i8 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2002142597, "CC(remember):TicketsShareScreens.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = new Function0() { // from class: com.example.tickets.TicketsShareScreensKt$$ExternalSyntheticLambda71
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return Unit.INSTANCE;
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            function7 = (Function0) objRememberedValue;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        } else {
                            function7 = function3;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(391212249, i3, -1, "com.example.tickets.TicketTransferTicketCard (TicketsShareScreens.kt:2267)");
                        }
                        ticketData = (TicketData) CollectionsKt.firstOrNull((List) list2);
                        str = "票据";
                        if (ticketData != null) {
                            str2 = "票据";
                        } else {
                            str2 = "票据";
                        }
                        ticketData2 = (TicketData) CollectionsKt.firstOrNull((List) list2);
                        if (ticketData2 != null) {
                            str = strTicketShareTypeName;
                        }
                        Modifier modifierM1424paddingVpY3zN12 = PaddingKt.m1424paddingVpY3zN4(BorderKt.m659borderxT4_qwU(BackgroundKt.m648backgroundbw27NRU$default(ClipKt.clip(SizeKt.m1476height3ABfNKs(SizeKt.m1495width3ABfNKs(companion, Dp.m8748constructorimpl(380.0f)), Dp.m8748constructorimpl(270.0f)), RoundedCornerShapeKt.m1756RoundedCornerShape0680j_4(f2)), ColorKt.Color(4279703322L), null, 2, null), Dp.m8748constructorimpl(1.0f), Color.m5837copywmQWz5c$default(Color.INSTANCE.m5875getWhite0d7_KjU(), 0.18f, 0.0f, 0.0f, 0.0f, 14, null), RoundedCornerShapeKt.m1756RoundedCornerShape0680j_4(f2)), Dp.m8748constructorimpl(20.0f), Dp.m8748constructorimpl(18.0f));
                        Alignment.Horizontal centerHorizontally9 = Alignment.INSTANCE.getCenterHorizontally();
                        Arrangement.HorizontalOrVertical center9 = Arrangement.INSTANCE.getCenter();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                        MeasurePolicy measurePolicyColumnMeasurePolicy9 = ColumnKt.columnMeasurePolicy(center9, centerHorizontally9, composerStartRestartGroup, 54);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
                        int iHashCode17 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                        CompositionLocalMap currentCompositionLocalMap17 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier17 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1424paddingVpY3zN12);
                        constructor = ComposeUiNode.INSTANCE.getConstructor();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)410@16216L9:Composables.kt#9igjgp");
                        if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composerStartRestartGroup.startReusableNode();
                        if (composerStartRestartGroup.getInserting()) {
                            composerStartRestartGroup.createNode(constructor);
                        } else {
                            composerStartRestartGroup.useNode();
                        }
                        Composer composerM4937constructorimpl17 = Updater.m4937constructorimpl(composerStartRestartGroup);
                        Updater.m4945setimpl(composerM4937constructorimpl17, measurePolicyColumnMeasurePolicy9, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m4945setimpl(composerM4937constructorimpl17, currentCompositionLocalMap17, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Updater.m4945setimpl(composerM4937constructorimpl17, Integer.valueOf(iHashCode17), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                        Updater.m4943reconcileimpl(composerM4937constructorimpl17, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                        Updater.m4945setimpl(composerM4937constructorimpl17, modifierMaterializeModifier17, ComposeUiNode.INSTANCE.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                        ColumnScopeInstance columnScopeInstance9 = ColumnScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 841490239, "C2281@80779L104,2282@80892L29,2283@80930L160,2284@81099L30,2287@81406L62:TicketsShareScreens.kt#n9ob9m");
                        if (list2.size() != 1) {
                            str = list2.size() + "张票据";
                        }
                        TextKt.m3661TextNvy7gAk(str, null, ColorKt.Color(4287795865L), null, TextUnitKt.getSp(12), null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composerStartRestartGroup, 24960, 0, 262122);
                        SpacerKt.Spacer(SizeKt.m1476height3ABfNKs(Modifier.INSTANCE, Dp.m8748constructorimpl(7.0f)), composerStartRestartGroup, 6);
                        function8 = function7;
                        TextKt.m3661TextNvy7gAk(str2, null, Color.INSTANCE.m5875getWhite0d7_KjU(), null, TextUnitKt.getSp(21), null, FontWeight.INSTANCE.getMedium(), null, 0L, null, TextAlign.m8619boximpl(TextAlign.INSTANCE.m8626getCentere0LSkKk()), 0L, TextOverflow.INSTANCE.m8684getEllipsisgIe3tQ8(), false, 2, 0, null, null, composerStartRestartGroup, 1597824, 24960, 240554);
                        composer3 = composerStartRestartGroup;
                        SpacerKt.Spacer(SizeKt.m1476height3ABfNKs(Modifier.INSTANCE, Dp.m8748constructorimpl(10.0f)), composer3, 6);
                        ticketData3 = (TicketData) CollectionsKt.firstOrNull((List) list);
                        if (ticketData3 != null) {
                            List listListOf9 = CollectionsKt.listOf((Object[]) new String[]{ticketData3.getFrom(), ticketData3.getTo()});
                            arrayList = new ArrayList();
                            while (r9.hasNext()) {
                                if (!StringsKt.isBlank((String) obj)) {
                                    arrayList.add(obj);
                                }
                            }
                            strJoinToString$default = CollectionsKt.joinToString$default(arrayList, " → ", null, null, 0, null, null, 62, null);
                        } else {
                            strJoinToString$default = null;
                        }
                        if (strJoinToString$default == null) {
                            strJoinToString$default = "";
                        }
                        str3 = strJoinToString$default;
                        if (StringsKt.isBlank(str3)) {
                            composer3.startReplaceGroup(841966615);
                            ComposerKt.sourceInformation(composer3, "2286@81293L104");
                            TextKt.m3661TextNvy7gAk(strJoinToString$default, null, ColorKt.Color(4289374895L), null, TextUnitKt.getSp(13), null, null, null, 0L, null, null, 0L, TextOverflow.INSTANCE.m8684getEllipsisgIe3tQ8(), false, 1, 0, null, null, composer3, 24960, 24960, 241642);
                            composer3 = composer3;
                        } else {
                            composer3.startReplaceGroup(761319743);
                        }
                        composer3.endReplaceGroup();
                        Modifier.Companion companion10 = Modifier.INSTANCE;
                        if (StringsKt.isBlank(str3)) {
                            fM8748constructorimpl = Dp.m8748constructorimpl(20.0f);
                        } else {
                            fM8748constructorimpl = Dp.m8748constructorimpl(14.0f);
                        }
                        SpacerKt.Spacer(SizeKt.m1476height3ABfNKs(companion10, fM8748constructorimpl), composer3, 0);
                        if (z4) {
                            composer3.startReplaceGroup(842174563);
                            ComposerKt.sourceInformation(composer3, "2289@81508L57,2290@81578L30,2291@81621L243");
                            composer4 = composer3;
                            TextKt.m3661TextNvy7gAk("收到票据", null, ColorKt.Color(4287598486L), null, TextUnitKt.getSp(12), null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer4, 24966, 0, 262122);
                            SpacerKt.Spacer(SizeKt.m1476height3ABfNKs(Modifier.INSTANCE, Dp.m8748constructorimpl(14.0f)), composer4, 6);
                            Modifier modifierFillMaxWidth$default9 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                            Arrangement.HorizontalOrVertical horizontalOrVerticalM1115spacedBy0680j_12 = Arrangement.INSTANCE.m1115spacedBy0680j_4(Dp.m8748constructorimpl(10.0f));
                            ComposerKt.sourceInformationMarkerStart(composer4, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                            MeasurePolicy measurePolicyRowMeasurePolicy9 = RowKt.rowMeasurePolicy(horizontalOrVerticalM1115spacedBy0680j_12, Alignment.INSTANCE.getTop(), composer4, 6);
                            ComposerKt.sourceInformationMarkerStart(composer4, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
                            int iHashCode18 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer4, 0));
                            CompositionLocalMap currentCompositionLocalMap18 = composer4.getCurrentCompositionLocalMap();
                            Modifier modifierMaterializeModifier18 = ComposedModifierKt.materializeModifier(composer4, modifierFillMaxWidth$default9);
                            constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                            ComposerKt.sourceInformationMarkerStart(composer4, -553112988, "CC(ReusableComposeNode)N(factory,update,content)410@16216L9:Composables.kt#9igjgp");
                            if (!(composer4.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            composer4.startReusableNode();
                            if (composer4.getInserting()) {
                                composer4.createNode(constructor2);
                            } else {
                                composer4.useNode();
                            }
                            Composer composerM4937constructorimpl18 = Updater.m4937constructorimpl(composer4);
                            Updater.m4945setimpl(composerM4937constructorimpl18, measurePolicyRowMeasurePolicy9, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                            Updater.m4945setimpl(composerM4937constructorimpl18, currentCompositionLocalMap18, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                            Updater.m4945setimpl(composerM4937constructorimpl18, Integer.valueOf(iHashCode18), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                            Updater.m4943reconcileimpl(composerM4937constructorimpl18, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                            Updater.m4945setimpl(composerM4937constructorimpl18, modifierMaterializeModifier18, ComposeUiNode.INSTANCE.getSetModifier());
                            ComposerKt.sourceInformationMarkerStart(composer4, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                            RowScopeInstance rowScopeInstance9 = RowScopeInstance.INSTANCE;
                            ComposerKt.sourceInformationMarkerStart(composer4, -823872107, "C2292@81721L56,2293@81794L56:TicketsShareScreens.kt#n9ob9m");
                            modifier4 = companion;
                            ShareOutlinedButton("拒绝", function8, RowScope.weight$default(rowScopeInstance9, Modifier.INSTANCE, 1.0f, false, 2, null), composer4, ((i3 >> 12) & StylePropertiesKt.TextDirectionMask) | 6, 0);
                            function9 = function8;
                            Modifier modifierWeight$default9 = RowScope.weight$default(rowScopeInstance9, Modifier.INSTANCE, 1.0f, false, 2, null);
                            int i19 = ((i3 >> 9) & StylePropertiesKt.TextDirectionMask) | 6;
                            function10 = function6;
                            ShareOutlinedButton("接受", function10, modifierWeight$default9, composer4, i19, 0);
                            ComposerKt.sourceInformationMarkerEnd(composer4);
                            ComposerKt.sourceInformationMarkerEnd(composer4);
                            composer4.endNode();
                            ComposerKt.sourceInformationMarkerEnd(composer4);
                            ComposerKt.sourceInformationMarkerEnd(composer4);
                            ComposerKt.sourceInformationMarkerEnd(composer4);
                            composer4.endReplaceGroup();
                            composer2 = composer4;
                        } else {
                            function9 = function8;
                            modifier4 = companion;
                            function10 = function6;
                            composer3.startReplaceGroup(842548299);
                            ComposerKt.sourceInformation(composer3, "2296@81894L60");
                            composer2 = composer3;
                            TextKt.m3661TextNvy7gAk("票据正在传输…", null, ColorKt.Color(4287598486L), null, TextUnitKt.getSp(12), null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer2, 24966, 0, 262122);
                            composer2.endReplaceGroup();
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        composer2.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        function4 = function10;
                        z3 = z4;
                        modifier3 = modifier4;
                        function5 = function9;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.tickets.TicketsShareScreensKt$$ExternalSyntheticLambda72
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj2, Object obj3) {
                                return TicketsShareScreensKt.TicketTransferTicketCard_RfXq3Jk$lambda$289(list, f, modifier3, z3, function4, function5, i, i2, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        });
                    }
                }
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                function3 = function1;
                if ((74899 & i3) != 74898) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z2, i3 & 1)) {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    z3 = z;
                    modifier3 = modifier2;
                    function4 = function2;
                    function5 = function3;
                } else {
                    if (i10 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i4 != 0) {
                        z4 = false;
                    } else {
                        z4 = z;
                    }
                    if (i6 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2002143589, "CC(remember):TicketsShareScreens.kt#9igjgp");
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue2 = new Function0() { // from class: com.example.tickets.TicketsShareScreensKt$$ExternalSyntheticLambda70
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return Unit.INSTANCE;
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        function6 = (Function0) objRememberedValue2;
                    } else {
                        function6 = function2;
                    }
                    if (i8 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2002142597, "CC(remember):TicketsShareScreens.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new Function0() { // from class: com.example.tickets.TicketsShareScreensKt$$ExternalSyntheticLambda71
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return Unit.INSTANCE;
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        function7 = (Function0) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    } else {
                        function7 = function3;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(391212249, i3, -1, "com.example.tickets.TicketTransferTicketCard (TicketsShareScreens.kt:2267)");
                    }
                    ticketData = (TicketData) CollectionsKt.firstOrNull((List) list2);
                    str = "票据";
                    if (ticketData != null) {
                        str2 = "票据";
                    } else {
                        str2 = "票据";
                    }
                    ticketData2 = (TicketData) CollectionsKt.firstOrNull((List) list2);
                    if (ticketData2 != null) {
                        str = strTicketShareTypeName;
                    }
                    Modifier modifierM1424paddingVpY3zN13 = PaddingKt.m1424paddingVpY3zN4(BorderKt.m659borderxT4_qwU(BackgroundKt.m648backgroundbw27NRU$default(ClipKt.clip(SizeKt.m1476height3ABfNKs(SizeKt.m1495width3ABfNKs(companion, Dp.m8748constructorimpl(380.0f)), Dp.m8748constructorimpl(270.0f)), RoundedCornerShapeKt.m1756RoundedCornerShape0680j_4(f2)), ColorKt.Color(4279703322L), null, 2, null), Dp.m8748constructorimpl(1.0f), Color.m5837copywmQWz5c$default(Color.INSTANCE.m5875getWhite0d7_KjU(), 0.18f, 0.0f, 0.0f, 0.0f, 14, null), RoundedCornerShapeKt.m1756RoundedCornerShape0680j_4(f2)), Dp.m8748constructorimpl(20.0f), Dp.m8748constructorimpl(18.0f));
                    Alignment.Horizontal centerHorizontally10 = Alignment.INSTANCE.getCenterHorizontally();
                    Arrangement.HorizontalOrVertical center10 = Arrangement.INSTANCE.getCenter();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                    MeasurePolicy measurePolicyColumnMeasurePolicy10 = ColumnKt.columnMeasurePolicy(center10, centerHorizontally10, composerStartRestartGroup, 54);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
                    int iHashCode19 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap19 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier19 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1424paddingVpY3zN13);
                    constructor = ComposeUiNode.INSTANCE.getConstructor();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)410@16216L9:Composables.kt#9igjgp");
                    if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(constructor);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    Composer composerM4937constructorimpl19 = Updater.m4937constructorimpl(composerStartRestartGroup);
                    Updater.m4945setimpl(composerM4937constructorimpl19, measurePolicyColumnMeasurePolicy10, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m4945setimpl(composerM4937constructorimpl19, currentCompositionLocalMap19, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Updater.m4945setimpl(composerM4937constructorimpl19, Integer.valueOf(iHashCode19), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                    Updater.m4943reconcileimpl(composerM4937constructorimpl19, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                    Updater.m4945setimpl(composerM4937constructorimpl19, modifierMaterializeModifier19, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                    ColumnScopeInstance columnScopeInstance10 = ColumnScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 841490239, "C2281@80779L104,2282@80892L29,2283@80930L160,2284@81099L30,2287@81406L62:TicketsShareScreens.kt#n9ob9m");
                    if (list2.size() != 1) {
                        str = list2.size() + "张票据";
                    }
                    TextKt.m3661TextNvy7gAk(str, null, ColorKt.Color(4287795865L), null, TextUnitKt.getSp(12), null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composerStartRestartGroup, 24960, 0, 262122);
                    SpacerKt.Spacer(SizeKt.m1476height3ABfNKs(Modifier.INSTANCE, Dp.m8748constructorimpl(7.0f)), composerStartRestartGroup, 6);
                    function8 = function7;
                    TextKt.m3661TextNvy7gAk(str2, null, Color.INSTANCE.m5875getWhite0d7_KjU(), null, TextUnitKt.getSp(21), null, FontWeight.INSTANCE.getMedium(), null, 0L, null, TextAlign.m8619boximpl(TextAlign.INSTANCE.m8626getCentere0LSkKk()), 0L, TextOverflow.INSTANCE.m8684getEllipsisgIe3tQ8(), false, 2, 0, null, null, composerStartRestartGroup, 1597824, 24960, 240554);
                    composer3 = composerStartRestartGroup;
                    SpacerKt.Spacer(SizeKt.m1476height3ABfNKs(Modifier.INSTANCE, Dp.m8748constructorimpl(10.0f)), composer3, 6);
                    ticketData3 = (TicketData) CollectionsKt.firstOrNull((List) list);
                    if (ticketData3 != null) {
                        List listListOf10 = CollectionsKt.listOf((Object[]) new String[]{ticketData3.getFrom(), ticketData3.getTo()});
                        arrayList = new ArrayList();
                        while (r9.hasNext()) {
                            if (!StringsKt.isBlank((String) obj)) {
                                arrayList.add(obj);
                            }
                        }
                        strJoinToString$default = CollectionsKt.joinToString$default(arrayList, " → ", null, null, 0, null, null, 62, null);
                    } else {
                        strJoinToString$default = null;
                    }
                    if (strJoinToString$default == null) {
                        strJoinToString$default = "";
                    }
                    str3 = strJoinToString$default;
                    if (StringsKt.isBlank(str3)) {
                        composer3.startReplaceGroup(841966615);
                        ComposerKt.sourceInformation(composer3, "2286@81293L104");
                        TextKt.m3661TextNvy7gAk(strJoinToString$default, null, ColorKt.Color(4289374895L), null, TextUnitKt.getSp(13), null, null, null, 0L, null, null, 0L, TextOverflow.INSTANCE.m8684getEllipsisgIe3tQ8(), false, 1, 0, null, null, composer3, 24960, 24960, 241642);
                        composer3 = composer3;
                    } else {
                        composer3.startReplaceGroup(761319743);
                    }
                    composer3.endReplaceGroup();
                    Modifier.Companion companion11 = Modifier.INSTANCE;
                    if (StringsKt.isBlank(str3)) {
                        fM8748constructorimpl = Dp.m8748constructorimpl(20.0f);
                    } else {
                        fM8748constructorimpl = Dp.m8748constructorimpl(14.0f);
                    }
                    SpacerKt.Spacer(SizeKt.m1476height3ABfNKs(companion11, fM8748constructorimpl), composer3, 0);
                    if (z4) {
                        composer3.startReplaceGroup(842174563);
                        ComposerKt.sourceInformation(composer3, "2289@81508L57,2290@81578L30,2291@81621L243");
                        composer4 = composer3;
                        TextKt.m3661TextNvy7gAk("收到票据", null, ColorKt.Color(4287598486L), null, TextUnitKt.getSp(12), null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer4, 24966, 0, 262122);
                        SpacerKt.Spacer(SizeKt.m1476height3ABfNKs(Modifier.INSTANCE, Dp.m8748constructorimpl(14.0f)), composer4, 6);
                        Modifier modifierFillMaxWidth$default10 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                        Arrangement.HorizontalOrVertical horizontalOrVerticalM1115spacedBy0680j_13 = Arrangement.INSTANCE.m1115spacedBy0680j_4(Dp.m8748constructorimpl(10.0f));
                        ComposerKt.sourceInformationMarkerStart(composer4, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                        MeasurePolicy measurePolicyRowMeasurePolicy10 = RowKt.rowMeasurePolicy(horizontalOrVerticalM1115spacedBy0680j_13, Alignment.INSTANCE.getTop(), composer4, 6);
                        ComposerKt.sourceInformationMarkerStart(composer4, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
                        int iHashCode110 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer4, 0));
                        CompositionLocalMap currentCompositionLocalMap110 = composer4.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier110 = ComposedModifierKt.materializeModifier(composer4, modifierFillMaxWidth$default10);
                        constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                        ComposerKt.sourceInformationMarkerStart(composer4, -553112988, "CC(ReusableComposeNode)N(factory,update,content)410@16216L9:Composables.kt#9igjgp");
                        if (!(composer4.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composer4.startReusableNode();
                        if (composer4.getInserting()) {
                            composer4.createNode(constructor2);
                        } else {
                            composer4.useNode();
                        }
                        Composer composerM4937constructorimpl110 = Updater.m4937constructorimpl(composer4);
                        Updater.m4945setimpl(composerM4937constructorimpl110, measurePolicyRowMeasurePolicy10, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m4945setimpl(composerM4937constructorimpl110, currentCompositionLocalMap110, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Updater.m4945setimpl(composerM4937constructorimpl110, Integer.valueOf(iHashCode110), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                        Updater.m4943reconcileimpl(composerM4937constructorimpl110, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                        Updater.m4945setimpl(composerM4937constructorimpl110, modifierMaterializeModifier110, ComposeUiNode.INSTANCE.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(composer4, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                        RowScopeInstance rowScopeInstance10 = RowScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composer4, -823872107, "C2292@81721L56,2293@81794L56:TicketsShareScreens.kt#n9ob9m");
                        modifier4 = companion;
                        ShareOutlinedButton("拒绝", function8, RowScope.weight$default(rowScopeInstance10, Modifier.INSTANCE, 1.0f, false, 2, null), composer4, ((i3 >> 12) & StylePropertiesKt.TextDirectionMask) | 6, 0);
                        function9 = function8;
                        Modifier modifierWeight$default10 = RowScope.weight$default(rowScopeInstance10, Modifier.INSTANCE, 1.0f, false, 2, null);
                        int i110 = ((i3 >> 9) & StylePropertiesKt.TextDirectionMask) | 6;
                        function10 = function6;
                        ShareOutlinedButton("接受", function10, modifierWeight$default10, composer4, i110, 0);
                        ComposerKt.sourceInformationMarkerEnd(composer4);
                        ComposerKt.sourceInformationMarkerEnd(composer4);
                        composer4.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composer4);
                        ComposerKt.sourceInformationMarkerEnd(composer4);
                        ComposerKt.sourceInformationMarkerEnd(composer4);
                        composer4.endReplaceGroup();
                        composer2 = composer4;
                    } else {
                        function9 = function8;
                        modifier4 = companion;
                        function10 = function6;
                        composer3.startReplaceGroup(842548299);
                        ComposerKt.sourceInformation(composer3, "2296@81894L60");
                        composer2 = composer3;
                        TextKt.m3661TextNvy7gAk("票据正在传输…", null, ColorKt.Color(4287598486L), null, TextUnitKt.getSp(12), null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer2, 24966, 0, 262122);
                        composer2.endReplaceGroup();
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    composer2.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    function4 = function10;
                    z3 = z4;
                    modifier3 = modifier4;
                    function5 = function9;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.tickets.TicketsShareScreensKt$$ExternalSyntheticLambda72
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj2, Object obj3) {
                            return TicketsShareScreensKt.TicketTransferTicketCard_RfXq3Jk$lambda$289(list, f, modifier3, z3, function4, function5, i, i2, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    });
                }
            }
            i3 |= 24576;
            function2 = function0;
            i8 = i2 & 32;
            if (i8 != 0) {
                if ((196608 & i) == 0) {
                    function3 = function1;
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i9 = 131072;
                    } else {
                        i9 = 65536;
                    }
                    i3 |= i9;
                }
                if ((74899 & i3) != 74898) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z2, i3 & 1)) {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    z3 = z;
                    modifier3 = modifier2;
                    function4 = function2;
                    function5 = function3;
                } else {
                    if (i10 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i4 != 0) {
                        z4 = false;
                    } else {
                        z4 = z;
                    }
                    if (i6 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2002143589, "CC(remember):TicketsShareScreens.kt#9igjgp");
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue2 = new Function0() { // from class: com.example.tickets.TicketsShareScreensKt$$ExternalSyntheticLambda70
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return Unit.INSTANCE;
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        function6 = (Function0) objRememberedValue2;
                    } else {
                        function6 = function2;
                    }
                    if (i8 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2002142597, "CC(remember):TicketsShareScreens.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new Function0() { // from class: com.example.tickets.TicketsShareScreensKt$$ExternalSyntheticLambda71
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return Unit.INSTANCE;
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        function7 = (Function0) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    } else {
                        function7 = function3;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(391212249, i3, -1, "com.example.tickets.TicketTransferTicketCard (TicketsShareScreens.kt:2267)");
                    }
                    ticketData = (TicketData) CollectionsKt.firstOrNull((List) list2);
                    str = "票据";
                    if (ticketData != null) {
                        str2 = "票据";
                    } else {
                        str2 = "票据";
                    }
                    ticketData2 = (TicketData) CollectionsKt.firstOrNull((List) list2);
                    if (ticketData2 != null) {
                        str = strTicketShareTypeName;
                    }
                    Modifier modifierM1424paddingVpY3zN14 = PaddingKt.m1424paddingVpY3zN4(BorderKt.m659borderxT4_qwU(BackgroundKt.m648backgroundbw27NRU$default(ClipKt.clip(SizeKt.m1476height3ABfNKs(SizeKt.m1495width3ABfNKs(companion, Dp.m8748constructorimpl(380.0f)), Dp.m8748constructorimpl(270.0f)), RoundedCornerShapeKt.m1756RoundedCornerShape0680j_4(f2)), ColorKt.Color(4279703322L), null, 2, null), Dp.m8748constructorimpl(1.0f), Color.m5837copywmQWz5c$default(Color.INSTANCE.m5875getWhite0d7_KjU(), 0.18f, 0.0f, 0.0f, 0.0f, 14, null), RoundedCornerShapeKt.m1756RoundedCornerShape0680j_4(f2)), Dp.m8748constructorimpl(20.0f), Dp.m8748constructorimpl(18.0f));
                    Alignment.Horizontal centerHorizontally11 = Alignment.INSTANCE.getCenterHorizontally();
                    Arrangement.HorizontalOrVertical center11 = Arrangement.INSTANCE.getCenter();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                    MeasurePolicy measurePolicyColumnMeasurePolicy11 = ColumnKt.columnMeasurePolicy(center11, centerHorizontally11, composerStartRestartGroup, 54);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
                    int iHashCode111 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap111 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier111 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1424paddingVpY3zN14);
                    constructor = ComposeUiNode.INSTANCE.getConstructor();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)410@16216L9:Composables.kt#9igjgp");
                    if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(constructor);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    Composer composerM4937constructorimpl111 = Updater.m4937constructorimpl(composerStartRestartGroup);
                    Updater.m4945setimpl(composerM4937constructorimpl111, measurePolicyColumnMeasurePolicy11, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m4945setimpl(composerM4937constructorimpl111, currentCompositionLocalMap111, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Updater.m4945setimpl(composerM4937constructorimpl111, Integer.valueOf(iHashCode111), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                    Updater.m4943reconcileimpl(composerM4937constructorimpl111, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                    Updater.m4945setimpl(composerM4937constructorimpl111, modifierMaterializeModifier111, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                    ColumnScopeInstance columnScopeInstance11 = ColumnScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 841490239, "C2281@80779L104,2282@80892L29,2283@80930L160,2284@81099L30,2287@81406L62:TicketsShareScreens.kt#n9ob9m");
                    if (list2.size() != 1) {
                        str = list2.size() + "张票据";
                    }
                    TextKt.m3661TextNvy7gAk(str, null, ColorKt.Color(4287795865L), null, TextUnitKt.getSp(12), null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composerStartRestartGroup, 24960, 0, 262122);
                    SpacerKt.Spacer(SizeKt.m1476height3ABfNKs(Modifier.INSTANCE, Dp.m8748constructorimpl(7.0f)), composerStartRestartGroup, 6);
                    function8 = function7;
                    TextKt.m3661TextNvy7gAk(str2, null, Color.INSTANCE.m5875getWhite0d7_KjU(), null, TextUnitKt.getSp(21), null, FontWeight.INSTANCE.getMedium(), null, 0L, null, TextAlign.m8619boximpl(TextAlign.INSTANCE.m8626getCentere0LSkKk()), 0L, TextOverflow.INSTANCE.m8684getEllipsisgIe3tQ8(), false, 2, 0, null, null, composerStartRestartGroup, 1597824, 24960, 240554);
                    composer3 = composerStartRestartGroup;
                    SpacerKt.Spacer(SizeKt.m1476height3ABfNKs(Modifier.INSTANCE, Dp.m8748constructorimpl(10.0f)), composer3, 6);
                    ticketData3 = (TicketData) CollectionsKt.firstOrNull((List) list);
                    if (ticketData3 != null) {
                        List listListOf11 = CollectionsKt.listOf((Object[]) new String[]{ticketData3.getFrom(), ticketData3.getTo()});
                        arrayList = new ArrayList();
                        while (r9.hasNext()) {
                            if (!StringsKt.isBlank((String) obj)) {
                                arrayList.add(obj);
                            }
                        }
                        strJoinToString$default = CollectionsKt.joinToString$default(arrayList, " → ", null, null, 0, null, null, 62, null);
                    } else {
                        strJoinToString$default = null;
                    }
                    if (strJoinToString$default == null) {
                        strJoinToString$default = "";
                    }
                    str3 = strJoinToString$default;
                    if (StringsKt.isBlank(str3)) {
                        composer3.startReplaceGroup(841966615);
                        ComposerKt.sourceInformation(composer3, "2286@81293L104");
                        TextKt.m3661TextNvy7gAk(strJoinToString$default, null, ColorKt.Color(4289374895L), null, TextUnitKt.getSp(13), null, null, null, 0L, null, null, 0L, TextOverflow.INSTANCE.m8684getEllipsisgIe3tQ8(), false, 1, 0, null, null, composer3, 24960, 24960, 241642);
                        composer3 = composer3;
                    } else {
                        composer3.startReplaceGroup(761319743);
                    }
                    composer3.endReplaceGroup();
                    Modifier.Companion companion12 = Modifier.INSTANCE;
                    if (StringsKt.isBlank(str3)) {
                        fM8748constructorimpl = Dp.m8748constructorimpl(20.0f);
                    } else {
                        fM8748constructorimpl = Dp.m8748constructorimpl(14.0f);
                    }
                    SpacerKt.Spacer(SizeKt.m1476height3ABfNKs(companion12, fM8748constructorimpl), composer3, 0);
                    if (z4) {
                        composer3.startReplaceGroup(842174563);
                        ComposerKt.sourceInformation(composer3, "2289@81508L57,2290@81578L30,2291@81621L243");
                        composer4 = composer3;
                        TextKt.m3661TextNvy7gAk("收到票据", null, ColorKt.Color(4287598486L), null, TextUnitKt.getSp(12), null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer4, 24966, 0, 262122);
                        SpacerKt.Spacer(SizeKt.m1476height3ABfNKs(Modifier.INSTANCE, Dp.m8748constructorimpl(14.0f)), composer4, 6);
                        Modifier modifierFillMaxWidth$default11 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                        Arrangement.HorizontalOrVertical horizontalOrVerticalM1115spacedBy0680j_14 = Arrangement.INSTANCE.m1115spacedBy0680j_4(Dp.m8748constructorimpl(10.0f));
                        ComposerKt.sourceInformationMarkerStart(composer4, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                        MeasurePolicy measurePolicyRowMeasurePolicy11 = RowKt.rowMeasurePolicy(horizontalOrVerticalM1115spacedBy0680j_14, Alignment.INSTANCE.getTop(), composer4, 6);
                        ComposerKt.sourceInformationMarkerStart(composer4, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
                        int iHashCode112 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer4, 0));
                        CompositionLocalMap currentCompositionLocalMap112 = composer4.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier112 = ComposedModifierKt.materializeModifier(composer4, modifierFillMaxWidth$default11);
                        constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                        ComposerKt.sourceInformationMarkerStart(composer4, -553112988, "CC(ReusableComposeNode)N(factory,update,content)410@16216L9:Composables.kt#9igjgp");
                        if (!(composer4.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composer4.startReusableNode();
                        if (composer4.getInserting()) {
                            composer4.createNode(constructor2);
                        } else {
                            composer4.useNode();
                        }
                        Composer composerM4937constructorimpl112 = Updater.m4937constructorimpl(composer4);
                        Updater.m4945setimpl(composerM4937constructorimpl112, measurePolicyRowMeasurePolicy11, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m4945setimpl(composerM4937constructorimpl112, currentCompositionLocalMap112, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Updater.m4945setimpl(composerM4937constructorimpl112, Integer.valueOf(iHashCode112), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                        Updater.m4943reconcileimpl(composerM4937constructorimpl112, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                        Updater.m4945setimpl(composerM4937constructorimpl112, modifierMaterializeModifier112, ComposeUiNode.INSTANCE.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(composer4, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                        RowScopeInstance rowScopeInstance11 = RowScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composer4, -823872107, "C2292@81721L56,2293@81794L56:TicketsShareScreens.kt#n9ob9m");
                        modifier4 = companion;
                        ShareOutlinedButton("拒绝", function8, RowScope.weight$default(rowScopeInstance11, Modifier.INSTANCE, 1.0f, false, 2, null), composer4, ((i3 >> 12) & StylePropertiesKt.TextDirectionMask) | 6, 0);
                        function9 = function8;
                        Modifier modifierWeight$default11 = RowScope.weight$default(rowScopeInstance11, Modifier.INSTANCE, 1.0f, false, 2, null);
                        int i111 = ((i3 >> 9) & StylePropertiesKt.TextDirectionMask) | 6;
                        function10 = function6;
                        ShareOutlinedButton("接受", function10, modifierWeight$default11, composer4, i111, 0);
                        ComposerKt.sourceInformationMarkerEnd(composer4);
                        ComposerKt.sourceInformationMarkerEnd(composer4);
                        composer4.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composer4);
                        ComposerKt.sourceInformationMarkerEnd(composer4);
                        ComposerKt.sourceInformationMarkerEnd(composer4);
                        composer4.endReplaceGroup();
                        composer2 = composer4;
                    } else {
                        function9 = function8;
                        modifier4 = companion;
                        function10 = function6;
                        composer3.startReplaceGroup(842548299);
                        ComposerKt.sourceInformation(composer3, "2296@81894L60");
                        composer2 = composer3;
                        TextKt.m3661TextNvy7gAk("票据正在传输…", null, ColorKt.Color(4287598486L), null, TextUnitKt.getSp(12), null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer2, 24966, 0, 262122);
                        composer2.endReplaceGroup();
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    composer2.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    function4 = function10;
                    z3 = z4;
                    modifier3 = modifier4;
                    function5 = function9;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.tickets.TicketsShareScreensKt$$ExternalSyntheticLambda72
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj2, Object obj3) {
                            return TicketsShareScreensKt.TicketTransferTicketCard_RfXq3Jk$lambda$289(list, f, modifier3, z3, function4, function5, i, i2, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    });
                }
            }
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            function3 = function1;
            if ((74899 & i3) != 74898) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z2, i3 & 1)) {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                z3 = z;
                modifier3 = modifier2;
                function4 = function2;
                function5 = function3;
            } else {
                if (i10 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i4 != 0) {
                    z4 = false;
                } else {
                    z4 = z;
                }
                if (i6 != 0) {
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2002143589, "CC(remember):TicketsShareScreens.kt#9igjgp");
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = new Function0() { // from class: com.example.tickets.TicketsShareScreensKt$$ExternalSyntheticLambda70
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Unit.INSTANCE;
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    function6 = (Function0) objRememberedValue2;
                } else {
                    function6 = function2;
                }
                if (i8 != 0) {
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2002142597, "CC(remember):TicketsShareScreens.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new Function0() { // from class: com.example.tickets.TicketsShareScreensKt$$ExternalSyntheticLambda71
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Unit.INSTANCE;
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    function7 = (Function0) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                } else {
                    function7 = function3;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(391212249, i3, -1, "com.example.tickets.TicketTransferTicketCard (TicketsShareScreens.kt:2267)");
                }
                ticketData = (TicketData) CollectionsKt.firstOrNull((List) list2);
                str = "票据";
                if (ticketData != null) {
                    str2 = "票据";
                } else {
                    str2 = "票据";
                }
                ticketData2 = (TicketData) CollectionsKt.firstOrNull((List) list2);
                if (ticketData2 != null) {
                    str = strTicketShareTypeName;
                }
                Modifier modifierM1424paddingVpY3zN15 = PaddingKt.m1424paddingVpY3zN4(BorderKt.m659borderxT4_qwU(BackgroundKt.m648backgroundbw27NRU$default(ClipKt.clip(SizeKt.m1476height3ABfNKs(SizeKt.m1495width3ABfNKs(companion, Dp.m8748constructorimpl(380.0f)), Dp.m8748constructorimpl(270.0f)), RoundedCornerShapeKt.m1756RoundedCornerShape0680j_4(f2)), ColorKt.Color(4279703322L), null, 2, null), Dp.m8748constructorimpl(1.0f), Color.m5837copywmQWz5c$default(Color.INSTANCE.m5875getWhite0d7_KjU(), 0.18f, 0.0f, 0.0f, 0.0f, 14, null), RoundedCornerShapeKt.m1756RoundedCornerShape0680j_4(f2)), Dp.m8748constructorimpl(20.0f), Dp.m8748constructorimpl(18.0f));
                Alignment.Horizontal centerHorizontally12 = Alignment.INSTANCE.getCenterHorizontally();
                Arrangement.HorizontalOrVertical center12 = Arrangement.INSTANCE.getCenter();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                MeasurePolicy measurePolicyColumnMeasurePolicy12 = ColumnKt.columnMeasurePolicy(center12, centerHorizontally12, composerStartRestartGroup, 54);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
                int iHashCode113 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap113 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier113 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1424paddingVpY3zN15);
                constructor = ComposeUiNode.INSTANCE.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)410@16216L9:Composables.kt#9igjgp");
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor);
                } else {
                    composerStartRestartGroup.useNode();
                }
                Composer composerM4937constructorimpl113 = Updater.m4937constructorimpl(composerStartRestartGroup);
                Updater.m4945setimpl(composerM4937constructorimpl113, measurePolicyColumnMeasurePolicy12, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m4945setimpl(composerM4937constructorimpl113, currentCompositionLocalMap113, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Updater.m4945setimpl(composerM4937constructorimpl113, Integer.valueOf(iHashCode113), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                Updater.m4943reconcileimpl(composerM4937constructorimpl113, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                Updater.m4945setimpl(composerM4937constructorimpl113, modifierMaterializeModifier113, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                ColumnScopeInstance columnScopeInstance12 = ColumnScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 841490239, "C2281@80779L104,2282@80892L29,2283@80930L160,2284@81099L30,2287@81406L62:TicketsShareScreens.kt#n9ob9m");
                if (list2.size() != 1) {
                    str = list2.size() + "张票据";
                }
                TextKt.m3661TextNvy7gAk(str, null, ColorKt.Color(4287795865L), null, TextUnitKt.getSp(12), null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composerStartRestartGroup, 24960, 0, 262122);
                SpacerKt.Spacer(SizeKt.m1476height3ABfNKs(Modifier.INSTANCE, Dp.m8748constructorimpl(7.0f)), composerStartRestartGroup, 6);
                function8 = function7;
                TextKt.m3661TextNvy7gAk(str2, null, Color.INSTANCE.m5875getWhite0d7_KjU(), null, TextUnitKt.getSp(21), null, FontWeight.INSTANCE.getMedium(), null, 0L, null, TextAlign.m8619boximpl(TextAlign.INSTANCE.m8626getCentere0LSkKk()), 0L, TextOverflow.INSTANCE.m8684getEllipsisgIe3tQ8(), false, 2, 0, null, null, composerStartRestartGroup, 1597824, 24960, 240554);
                composer3 = composerStartRestartGroup;
                SpacerKt.Spacer(SizeKt.m1476height3ABfNKs(Modifier.INSTANCE, Dp.m8748constructorimpl(10.0f)), composer3, 6);
                ticketData3 = (TicketData) CollectionsKt.firstOrNull((List) list);
                if (ticketData3 != null) {
                    List listListOf12 = CollectionsKt.listOf((Object[]) new String[]{ticketData3.getFrom(), ticketData3.getTo()});
                    arrayList = new ArrayList();
                    while (r9.hasNext()) {
                        if (!StringsKt.isBlank((String) obj)) {
                            arrayList.add(obj);
                        }
                    }
                    strJoinToString$default = CollectionsKt.joinToString$default(arrayList, " → ", null, null, 0, null, null, 62, null);
                } else {
                    strJoinToString$default = null;
                }
                if (strJoinToString$default == null) {
                    strJoinToString$default = "";
                }
                str3 = strJoinToString$default;
                if (StringsKt.isBlank(str3)) {
                    composer3.startReplaceGroup(841966615);
                    ComposerKt.sourceInformation(composer3, "2286@81293L104");
                    TextKt.m3661TextNvy7gAk(strJoinToString$default, null, ColorKt.Color(4289374895L), null, TextUnitKt.getSp(13), null, null, null, 0L, null, null, 0L, TextOverflow.INSTANCE.m8684getEllipsisgIe3tQ8(), false, 1, 0, null, null, composer3, 24960, 24960, 241642);
                    composer3 = composer3;
                } else {
                    composer3.startReplaceGroup(761319743);
                }
                composer3.endReplaceGroup();
                Modifier.Companion companion13 = Modifier.INSTANCE;
                if (StringsKt.isBlank(str3)) {
                    fM8748constructorimpl = Dp.m8748constructorimpl(20.0f);
                } else {
                    fM8748constructorimpl = Dp.m8748constructorimpl(14.0f);
                }
                SpacerKt.Spacer(SizeKt.m1476height3ABfNKs(companion13, fM8748constructorimpl), composer3, 0);
                if (z4) {
                    composer3.startReplaceGroup(842174563);
                    ComposerKt.sourceInformation(composer3, "2289@81508L57,2290@81578L30,2291@81621L243");
                    composer4 = composer3;
                    TextKt.m3661TextNvy7gAk("收到票据", null, ColorKt.Color(4287598486L), null, TextUnitKt.getSp(12), null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer4, 24966, 0, 262122);
                    SpacerKt.Spacer(SizeKt.m1476height3ABfNKs(Modifier.INSTANCE, Dp.m8748constructorimpl(14.0f)), composer4, 6);
                    Modifier modifierFillMaxWidth$default12 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                    Arrangement.HorizontalOrVertical horizontalOrVerticalM1115spacedBy0680j_15 = Arrangement.INSTANCE.m1115spacedBy0680j_4(Dp.m8748constructorimpl(10.0f));
                    ComposerKt.sourceInformationMarkerStart(composer4, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                    MeasurePolicy measurePolicyRowMeasurePolicy12 = RowKt.rowMeasurePolicy(horizontalOrVerticalM1115spacedBy0680j_15, Alignment.INSTANCE.getTop(), composer4, 6);
                    ComposerKt.sourceInformationMarkerStart(composer4, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
                    int iHashCode114 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer4, 0));
                    CompositionLocalMap currentCompositionLocalMap114 = composer4.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier114 = ComposedModifierKt.materializeModifier(composer4, modifierFillMaxWidth$default12);
                    constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                    ComposerKt.sourceInformationMarkerStart(composer4, -553112988, "CC(ReusableComposeNode)N(factory,update,content)410@16216L9:Composables.kt#9igjgp");
                    if (!(composer4.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composer4.startReusableNode();
                    if (composer4.getInserting()) {
                        composer4.createNode(constructor2);
                    } else {
                        composer4.useNode();
                    }
                    Composer composerM4937constructorimpl114 = Updater.m4937constructorimpl(composer4);
                    Updater.m4945setimpl(composerM4937constructorimpl114, measurePolicyRowMeasurePolicy12, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m4945setimpl(composerM4937constructorimpl114, currentCompositionLocalMap114, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Updater.m4945setimpl(composerM4937constructorimpl114, Integer.valueOf(iHashCode114), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                    Updater.m4943reconcileimpl(composerM4937constructorimpl114, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                    Updater.m4945setimpl(composerM4937constructorimpl114, modifierMaterializeModifier114, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composer4, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                    RowScopeInstance rowScopeInstance12 = RowScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composer4, -823872107, "C2292@81721L56,2293@81794L56:TicketsShareScreens.kt#n9ob9m");
                    modifier4 = companion;
                    ShareOutlinedButton("拒绝", function8, RowScope.weight$default(rowScopeInstance12, Modifier.INSTANCE, 1.0f, false, 2, null), composer4, ((i3 >> 12) & StylePropertiesKt.TextDirectionMask) | 6, 0);
                    function9 = function8;
                    Modifier modifierWeight$default12 = RowScope.weight$default(rowScopeInstance12, Modifier.INSTANCE, 1.0f, false, 2, null);
                    int i112 = ((i3 >> 9) & StylePropertiesKt.TextDirectionMask) | 6;
                    function10 = function6;
                    ShareOutlinedButton("接受", function10, modifierWeight$default12, composer4, i112, 0);
                    ComposerKt.sourceInformationMarkerEnd(composer4);
                    ComposerKt.sourceInformationMarkerEnd(composer4);
                    composer4.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer4);
                    ComposerKt.sourceInformationMarkerEnd(composer4);
                    ComposerKt.sourceInformationMarkerEnd(composer4);
                    composer4.endReplaceGroup();
                    composer2 = composer4;
                } else {
                    function9 = function8;
                    modifier4 = companion;
                    function10 = function6;
                    composer3.startReplaceGroup(842548299);
                    ComposerKt.sourceInformation(composer3, "2296@81894L60");
                    composer2 = composer3;
                    TextKt.m3661TextNvy7gAk("票据正在传输…", null, ColorKt.Color(4287598486L), null, TextUnitKt.getSp(12), null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer2, 24966, 0, 262122);
                    composer2.endReplaceGroup();
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                function4 = function10;
                z3 = z4;
                modifier3 = modifier4;
                function5 = function9;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.tickets.TicketsShareScreensKt$$ExternalSyntheticLambda72
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj2, Object obj3) {
                        return TicketsShareScreensKt.TicketTransferTicketCard_RfXq3Jk$lambda$289(list, f, modifier3, z3, function4, function5, i, i2, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                });
            }
        }
        i3 |= 3072;
        i6 = i2 & 16;
        if (i6 != 0) {
            if ((i & 24576) == 0) {
                function2 = function0;
                if (composerStartRestartGroup.changedInstance(function2)) {
                    i7 = 16384;
                } else {
                    i7 = 8192;
                }
                i3 |= i7;
            }
            i8 = i2 & 32;
            if (i8 != 0) {
                if ((196608 & i) == 0) {
                    function3 = function1;
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i9 = 131072;
                    } else {
                        i9 = 65536;
                    }
                    i3 |= i9;
                }
                if ((74899 & i3) != 74898) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z2, i3 & 1)) {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    z3 = z;
                    modifier3 = modifier2;
                    function4 = function2;
                    function5 = function3;
                } else {
                    if (i10 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i4 != 0) {
                        z4 = false;
                    } else {
                        z4 = z;
                    }
                    if (i6 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2002143589, "CC(remember):TicketsShareScreens.kt#9igjgp");
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue2 = new Function0() { // from class: com.example.tickets.TicketsShareScreensKt$$ExternalSyntheticLambda70
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return Unit.INSTANCE;
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        function6 = (Function0) objRememberedValue2;
                    } else {
                        function6 = function2;
                    }
                    if (i8 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2002142597, "CC(remember):TicketsShareScreens.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new Function0() { // from class: com.example.tickets.TicketsShareScreensKt$$ExternalSyntheticLambda71
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return Unit.INSTANCE;
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        function7 = (Function0) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    } else {
                        function7 = function3;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(391212249, i3, -1, "com.example.tickets.TicketTransferTicketCard (TicketsShareScreens.kt:2267)");
                    }
                    ticketData = (TicketData) CollectionsKt.firstOrNull((List) list2);
                    str = "票据";
                    if (ticketData != null) {
                        str2 = "票据";
                    } else {
                        str2 = "票据";
                    }
                    ticketData2 = (TicketData) CollectionsKt.firstOrNull((List) list2);
                    if (ticketData2 != null) {
                        str = strTicketShareTypeName;
                    }
                    Modifier modifierM1424paddingVpY3zN16 = PaddingKt.m1424paddingVpY3zN4(BorderKt.m659borderxT4_qwU(BackgroundKt.m648backgroundbw27NRU$default(ClipKt.clip(SizeKt.m1476height3ABfNKs(SizeKt.m1495width3ABfNKs(companion, Dp.m8748constructorimpl(380.0f)), Dp.m8748constructorimpl(270.0f)), RoundedCornerShapeKt.m1756RoundedCornerShape0680j_4(f2)), ColorKt.Color(4279703322L), null, 2, null), Dp.m8748constructorimpl(1.0f), Color.m5837copywmQWz5c$default(Color.INSTANCE.m5875getWhite0d7_KjU(), 0.18f, 0.0f, 0.0f, 0.0f, 14, null), RoundedCornerShapeKt.m1756RoundedCornerShape0680j_4(f2)), Dp.m8748constructorimpl(20.0f), Dp.m8748constructorimpl(18.0f));
                    Alignment.Horizontal centerHorizontally13 = Alignment.INSTANCE.getCenterHorizontally();
                    Arrangement.HorizontalOrVertical center13 = Arrangement.INSTANCE.getCenter();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                    MeasurePolicy measurePolicyColumnMeasurePolicy13 = ColumnKt.columnMeasurePolicy(center13, centerHorizontally13, composerStartRestartGroup, 54);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
                    int iHashCode115 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap115 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier115 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1424paddingVpY3zN16);
                    constructor = ComposeUiNode.INSTANCE.getConstructor();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)410@16216L9:Composables.kt#9igjgp");
                    if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(constructor);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    Composer composerM4937constructorimpl115 = Updater.m4937constructorimpl(composerStartRestartGroup);
                    Updater.m4945setimpl(composerM4937constructorimpl115, measurePolicyColumnMeasurePolicy13, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m4945setimpl(composerM4937constructorimpl115, currentCompositionLocalMap115, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Updater.m4945setimpl(composerM4937constructorimpl115, Integer.valueOf(iHashCode115), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                    Updater.m4943reconcileimpl(composerM4937constructorimpl115, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                    Updater.m4945setimpl(composerM4937constructorimpl115, modifierMaterializeModifier115, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                    ColumnScopeInstance columnScopeInstance13 = ColumnScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 841490239, "C2281@80779L104,2282@80892L29,2283@80930L160,2284@81099L30,2287@81406L62:TicketsShareScreens.kt#n9ob9m");
                    if (list2.size() != 1) {
                        str = list2.size() + "张票据";
                    }
                    TextKt.m3661TextNvy7gAk(str, null, ColorKt.Color(4287795865L), null, TextUnitKt.getSp(12), null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composerStartRestartGroup, 24960, 0, 262122);
                    SpacerKt.Spacer(SizeKt.m1476height3ABfNKs(Modifier.INSTANCE, Dp.m8748constructorimpl(7.0f)), composerStartRestartGroup, 6);
                    function8 = function7;
                    TextKt.m3661TextNvy7gAk(str2, null, Color.INSTANCE.m5875getWhite0d7_KjU(), null, TextUnitKt.getSp(21), null, FontWeight.INSTANCE.getMedium(), null, 0L, null, TextAlign.m8619boximpl(TextAlign.INSTANCE.m8626getCentere0LSkKk()), 0L, TextOverflow.INSTANCE.m8684getEllipsisgIe3tQ8(), false, 2, 0, null, null, composerStartRestartGroup, 1597824, 24960, 240554);
                    composer3 = composerStartRestartGroup;
                    SpacerKt.Spacer(SizeKt.m1476height3ABfNKs(Modifier.INSTANCE, Dp.m8748constructorimpl(10.0f)), composer3, 6);
                    ticketData3 = (TicketData) CollectionsKt.firstOrNull((List) list);
                    if (ticketData3 != null) {
                        List listListOf13 = CollectionsKt.listOf((Object[]) new String[]{ticketData3.getFrom(), ticketData3.getTo()});
                        arrayList = new ArrayList();
                        while (r9.hasNext()) {
                            if (!StringsKt.isBlank((String) obj)) {
                                arrayList.add(obj);
                            }
                        }
                        strJoinToString$default = CollectionsKt.joinToString$default(arrayList, " → ", null, null, 0, null, null, 62, null);
                    } else {
                        strJoinToString$default = null;
                    }
                    if (strJoinToString$default == null) {
                        strJoinToString$default = "";
                    }
                    str3 = strJoinToString$default;
                    if (StringsKt.isBlank(str3)) {
                        composer3.startReplaceGroup(841966615);
                        ComposerKt.sourceInformation(composer3, "2286@81293L104");
                        TextKt.m3661TextNvy7gAk(strJoinToString$default, null, ColorKt.Color(4289374895L), null, TextUnitKt.getSp(13), null, null, null, 0L, null, null, 0L, TextOverflow.INSTANCE.m8684getEllipsisgIe3tQ8(), false, 1, 0, null, null, composer3, 24960, 24960, 241642);
                        composer3 = composer3;
                    } else {
                        composer3.startReplaceGroup(761319743);
                    }
                    composer3.endReplaceGroup();
                    Modifier.Companion companion14 = Modifier.INSTANCE;
                    if (StringsKt.isBlank(str3)) {
                        fM8748constructorimpl = Dp.m8748constructorimpl(20.0f);
                    } else {
                        fM8748constructorimpl = Dp.m8748constructorimpl(14.0f);
                    }
                    SpacerKt.Spacer(SizeKt.m1476height3ABfNKs(companion14, fM8748constructorimpl), composer3, 0);
                    if (z4) {
                        composer3.startReplaceGroup(842174563);
                        ComposerKt.sourceInformation(composer3, "2289@81508L57,2290@81578L30,2291@81621L243");
                        composer4 = composer3;
                        TextKt.m3661TextNvy7gAk("收到票据", null, ColorKt.Color(4287598486L), null, TextUnitKt.getSp(12), null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer4, 24966, 0, 262122);
                        SpacerKt.Spacer(SizeKt.m1476height3ABfNKs(Modifier.INSTANCE, Dp.m8748constructorimpl(14.0f)), composer4, 6);
                        Modifier modifierFillMaxWidth$default13 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                        Arrangement.HorizontalOrVertical horizontalOrVerticalM1115spacedBy0680j_16 = Arrangement.INSTANCE.m1115spacedBy0680j_4(Dp.m8748constructorimpl(10.0f));
                        ComposerKt.sourceInformationMarkerStart(composer4, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                        MeasurePolicy measurePolicyRowMeasurePolicy13 = RowKt.rowMeasurePolicy(horizontalOrVerticalM1115spacedBy0680j_16, Alignment.INSTANCE.getTop(), composer4, 6);
                        ComposerKt.sourceInformationMarkerStart(composer4, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
                        int iHashCode116 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer4, 0));
                        CompositionLocalMap currentCompositionLocalMap116 = composer4.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier116 = ComposedModifierKt.materializeModifier(composer4, modifierFillMaxWidth$default13);
                        constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                        ComposerKt.sourceInformationMarkerStart(composer4, -553112988, "CC(ReusableComposeNode)N(factory,update,content)410@16216L9:Composables.kt#9igjgp");
                        if (!(composer4.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composer4.startReusableNode();
                        if (composer4.getInserting()) {
                            composer4.createNode(constructor2);
                        } else {
                            composer4.useNode();
                        }
                        Composer composerM4937constructorimpl116 = Updater.m4937constructorimpl(composer4);
                        Updater.m4945setimpl(composerM4937constructorimpl116, measurePolicyRowMeasurePolicy13, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m4945setimpl(composerM4937constructorimpl116, currentCompositionLocalMap116, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Updater.m4945setimpl(composerM4937constructorimpl116, Integer.valueOf(iHashCode116), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                        Updater.m4943reconcileimpl(composerM4937constructorimpl116, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                        Updater.m4945setimpl(composerM4937constructorimpl116, modifierMaterializeModifier116, ComposeUiNode.INSTANCE.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(composer4, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                        RowScopeInstance rowScopeInstance13 = RowScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composer4, -823872107, "C2292@81721L56,2293@81794L56:TicketsShareScreens.kt#n9ob9m");
                        modifier4 = companion;
                        ShareOutlinedButton("拒绝", function8, RowScope.weight$default(rowScopeInstance13, Modifier.INSTANCE, 1.0f, false, 2, null), composer4, ((i3 >> 12) & StylePropertiesKt.TextDirectionMask) | 6, 0);
                        function9 = function8;
                        Modifier modifierWeight$default13 = RowScope.weight$default(rowScopeInstance13, Modifier.INSTANCE, 1.0f, false, 2, null);
                        int i113 = ((i3 >> 9) & StylePropertiesKt.TextDirectionMask) | 6;
                        function10 = function6;
                        ShareOutlinedButton("接受", function10, modifierWeight$default13, composer4, i113, 0);
                        ComposerKt.sourceInformationMarkerEnd(composer4);
                        ComposerKt.sourceInformationMarkerEnd(composer4);
                        composer4.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composer4);
                        ComposerKt.sourceInformationMarkerEnd(composer4);
                        ComposerKt.sourceInformationMarkerEnd(composer4);
                        composer4.endReplaceGroup();
                        composer2 = composer4;
                    } else {
                        function9 = function8;
                        modifier4 = companion;
                        function10 = function6;
                        composer3.startReplaceGroup(842548299);
                        ComposerKt.sourceInformation(composer3, "2296@81894L60");
                        composer2 = composer3;
                        TextKt.m3661TextNvy7gAk("票据正在传输…", null, ColorKt.Color(4287598486L), null, TextUnitKt.getSp(12), null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer2, 24966, 0, 262122);
                        composer2.endReplaceGroup();
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    composer2.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    function4 = function10;
                    z3 = z4;
                    modifier3 = modifier4;
                    function5 = function9;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.tickets.TicketsShareScreensKt$$ExternalSyntheticLambda72
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj2, Object obj3) {
                            return TicketsShareScreensKt.TicketTransferTicketCard_RfXq3Jk$lambda$289(list, f, modifier3, z3, function4, function5, i, i2, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    });
                }
            }
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            function3 = function1;
            if ((74899 & i3) != 74898) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z2, i3 & 1)) {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                z3 = z;
                modifier3 = modifier2;
                function4 = function2;
                function5 = function3;
            } else {
                if (i10 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i4 != 0) {
                    z4 = false;
                } else {
                    z4 = z;
                }
                if (i6 != 0) {
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2002143589, "CC(remember):TicketsShareScreens.kt#9igjgp");
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = new Function0() { // from class: com.example.tickets.TicketsShareScreensKt$$ExternalSyntheticLambda70
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Unit.INSTANCE;
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    function6 = (Function0) objRememberedValue2;
                } else {
                    function6 = function2;
                }
                if (i8 != 0) {
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2002142597, "CC(remember):TicketsShareScreens.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new Function0() { // from class: com.example.tickets.TicketsShareScreensKt$$ExternalSyntheticLambda71
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Unit.INSTANCE;
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    function7 = (Function0) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                } else {
                    function7 = function3;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(391212249, i3, -1, "com.example.tickets.TicketTransferTicketCard (TicketsShareScreens.kt:2267)");
                }
                ticketData = (TicketData) CollectionsKt.firstOrNull((List) list2);
                str = "票据";
                if (ticketData != null) {
                    str2 = "票据";
                } else {
                    str2 = "票据";
                }
                ticketData2 = (TicketData) CollectionsKt.firstOrNull((List) list2);
                if (ticketData2 != null) {
                    str = strTicketShareTypeName;
                }
                Modifier modifierM1424paddingVpY3zN17 = PaddingKt.m1424paddingVpY3zN4(BorderKt.m659borderxT4_qwU(BackgroundKt.m648backgroundbw27NRU$default(ClipKt.clip(SizeKt.m1476height3ABfNKs(SizeKt.m1495width3ABfNKs(companion, Dp.m8748constructorimpl(380.0f)), Dp.m8748constructorimpl(270.0f)), RoundedCornerShapeKt.m1756RoundedCornerShape0680j_4(f2)), ColorKt.Color(4279703322L), null, 2, null), Dp.m8748constructorimpl(1.0f), Color.m5837copywmQWz5c$default(Color.INSTANCE.m5875getWhite0d7_KjU(), 0.18f, 0.0f, 0.0f, 0.0f, 14, null), RoundedCornerShapeKt.m1756RoundedCornerShape0680j_4(f2)), Dp.m8748constructorimpl(20.0f), Dp.m8748constructorimpl(18.0f));
                Alignment.Horizontal centerHorizontally14 = Alignment.INSTANCE.getCenterHorizontally();
                Arrangement.HorizontalOrVertical center14 = Arrangement.INSTANCE.getCenter();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                MeasurePolicy measurePolicyColumnMeasurePolicy14 = ColumnKt.columnMeasurePolicy(center14, centerHorizontally14, composerStartRestartGroup, 54);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
                int iHashCode117 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap117 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier117 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1424paddingVpY3zN17);
                constructor = ComposeUiNode.INSTANCE.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)410@16216L9:Composables.kt#9igjgp");
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor);
                } else {
                    composerStartRestartGroup.useNode();
                }
                Composer composerM4937constructorimpl117 = Updater.m4937constructorimpl(composerStartRestartGroup);
                Updater.m4945setimpl(composerM4937constructorimpl117, measurePolicyColumnMeasurePolicy14, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m4945setimpl(composerM4937constructorimpl117, currentCompositionLocalMap117, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Updater.m4945setimpl(composerM4937constructorimpl117, Integer.valueOf(iHashCode117), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                Updater.m4943reconcileimpl(composerM4937constructorimpl117, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                Updater.m4945setimpl(composerM4937constructorimpl117, modifierMaterializeModifier117, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                ColumnScopeInstance columnScopeInstance14 = ColumnScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 841490239, "C2281@80779L104,2282@80892L29,2283@80930L160,2284@81099L30,2287@81406L62:TicketsShareScreens.kt#n9ob9m");
                if (list2.size() != 1) {
                    str = list2.size() + "张票据";
                }
                TextKt.m3661TextNvy7gAk(str, null, ColorKt.Color(4287795865L), null, TextUnitKt.getSp(12), null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composerStartRestartGroup, 24960, 0, 262122);
                SpacerKt.Spacer(SizeKt.m1476height3ABfNKs(Modifier.INSTANCE, Dp.m8748constructorimpl(7.0f)), composerStartRestartGroup, 6);
                function8 = function7;
                TextKt.m3661TextNvy7gAk(str2, null, Color.INSTANCE.m5875getWhite0d7_KjU(), null, TextUnitKt.getSp(21), null, FontWeight.INSTANCE.getMedium(), null, 0L, null, TextAlign.m8619boximpl(TextAlign.INSTANCE.m8626getCentere0LSkKk()), 0L, TextOverflow.INSTANCE.m8684getEllipsisgIe3tQ8(), false, 2, 0, null, null, composerStartRestartGroup, 1597824, 24960, 240554);
                composer3 = composerStartRestartGroup;
                SpacerKt.Spacer(SizeKt.m1476height3ABfNKs(Modifier.INSTANCE, Dp.m8748constructorimpl(10.0f)), composer3, 6);
                ticketData3 = (TicketData) CollectionsKt.firstOrNull((List) list);
                if (ticketData3 != null) {
                    List listListOf14 = CollectionsKt.listOf((Object[]) new String[]{ticketData3.getFrom(), ticketData3.getTo()});
                    arrayList = new ArrayList();
                    while (r9.hasNext()) {
                        if (!StringsKt.isBlank((String) obj)) {
                            arrayList.add(obj);
                        }
                    }
                    strJoinToString$default = CollectionsKt.joinToString$default(arrayList, " → ", null, null, 0, null, null, 62, null);
                } else {
                    strJoinToString$default = null;
                }
                if (strJoinToString$default == null) {
                    strJoinToString$default = "";
                }
                str3 = strJoinToString$default;
                if (StringsKt.isBlank(str3)) {
                    composer3.startReplaceGroup(841966615);
                    ComposerKt.sourceInformation(composer3, "2286@81293L104");
                    TextKt.m3661TextNvy7gAk(strJoinToString$default, null, ColorKt.Color(4289374895L), null, TextUnitKt.getSp(13), null, null, null, 0L, null, null, 0L, TextOverflow.INSTANCE.m8684getEllipsisgIe3tQ8(), false, 1, 0, null, null, composer3, 24960, 24960, 241642);
                    composer3 = composer3;
                } else {
                    composer3.startReplaceGroup(761319743);
                }
                composer3.endReplaceGroup();
                Modifier.Companion companion15 = Modifier.INSTANCE;
                if (StringsKt.isBlank(str3)) {
                    fM8748constructorimpl = Dp.m8748constructorimpl(20.0f);
                } else {
                    fM8748constructorimpl = Dp.m8748constructorimpl(14.0f);
                }
                SpacerKt.Spacer(SizeKt.m1476height3ABfNKs(companion15, fM8748constructorimpl), composer3, 0);
                if (z4) {
                    composer3.startReplaceGroup(842174563);
                    ComposerKt.sourceInformation(composer3, "2289@81508L57,2290@81578L30,2291@81621L243");
                    composer4 = composer3;
                    TextKt.m3661TextNvy7gAk("收到票据", null, ColorKt.Color(4287598486L), null, TextUnitKt.getSp(12), null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer4, 24966, 0, 262122);
                    SpacerKt.Spacer(SizeKt.m1476height3ABfNKs(Modifier.INSTANCE, Dp.m8748constructorimpl(14.0f)), composer4, 6);
                    Modifier modifierFillMaxWidth$default14 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                    Arrangement.HorizontalOrVertical horizontalOrVerticalM1115spacedBy0680j_17 = Arrangement.INSTANCE.m1115spacedBy0680j_4(Dp.m8748constructorimpl(10.0f));
                    ComposerKt.sourceInformationMarkerStart(composer4, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                    MeasurePolicy measurePolicyRowMeasurePolicy14 = RowKt.rowMeasurePolicy(horizontalOrVerticalM1115spacedBy0680j_17, Alignment.INSTANCE.getTop(), composer4, 6);
                    ComposerKt.sourceInformationMarkerStart(composer4, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
                    int iHashCode118 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer4, 0));
                    CompositionLocalMap currentCompositionLocalMap118 = composer4.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier118 = ComposedModifierKt.materializeModifier(composer4, modifierFillMaxWidth$default14);
                    constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                    ComposerKt.sourceInformationMarkerStart(composer4, -553112988, "CC(ReusableComposeNode)N(factory,update,content)410@16216L9:Composables.kt#9igjgp");
                    if (!(composer4.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composer4.startReusableNode();
                    if (composer4.getInserting()) {
                        composer4.createNode(constructor2);
                    } else {
                        composer4.useNode();
                    }
                    Composer composerM4937constructorimpl118 = Updater.m4937constructorimpl(composer4);
                    Updater.m4945setimpl(composerM4937constructorimpl118, measurePolicyRowMeasurePolicy14, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m4945setimpl(composerM4937constructorimpl118, currentCompositionLocalMap118, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Updater.m4945setimpl(composerM4937constructorimpl118, Integer.valueOf(iHashCode118), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                    Updater.m4943reconcileimpl(composerM4937constructorimpl118, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                    Updater.m4945setimpl(composerM4937constructorimpl118, modifierMaterializeModifier118, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composer4, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                    RowScopeInstance rowScopeInstance14 = RowScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composer4, -823872107, "C2292@81721L56,2293@81794L56:TicketsShareScreens.kt#n9ob9m");
                    modifier4 = companion;
                    ShareOutlinedButton("拒绝", function8, RowScope.weight$default(rowScopeInstance14, Modifier.INSTANCE, 1.0f, false, 2, null), composer4, ((i3 >> 12) & StylePropertiesKt.TextDirectionMask) | 6, 0);
                    function9 = function8;
                    Modifier modifierWeight$default14 = RowScope.weight$default(rowScopeInstance14, Modifier.INSTANCE, 1.0f, false, 2, null);
                    int i114 = ((i3 >> 9) & StylePropertiesKt.TextDirectionMask) | 6;
                    function10 = function6;
                    ShareOutlinedButton("接受", function10, modifierWeight$default14, composer4, i114, 0);
                    ComposerKt.sourceInformationMarkerEnd(composer4);
                    ComposerKt.sourceInformationMarkerEnd(composer4);
                    composer4.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer4);
                    ComposerKt.sourceInformationMarkerEnd(composer4);
                    ComposerKt.sourceInformationMarkerEnd(composer4);
                    composer4.endReplaceGroup();
                    composer2 = composer4;
                } else {
                    function9 = function8;
                    modifier4 = companion;
                    function10 = function6;
                    composer3.startReplaceGroup(842548299);
                    ComposerKt.sourceInformation(composer3, "2296@81894L60");
                    composer2 = composer3;
                    TextKt.m3661TextNvy7gAk("票据正在传输…", null, ColorKt.Color(4287598486L), null, TextUnitKt.getSp(12), null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer2, 24966, 0, 262122);
                    composer2.endReplaceGroup();
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                function4 = function10;
                z3 = z4;
                modifier3 = modifier4;
                function5 = function9;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.tickets.TicketsShareScreensKt$$ExternalSyntheticLambda72
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj2, Object obj3) {
                        return TicketsShareScreensKt.TicketTransferTicketCard_RfXq3Jk$lambda$289(list, f, modifier3, z3, function4, function5, i, i2, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                });
            }
        }
        i3 |= 24576;
        function2 = function0;
        i8 = i2 & 32;
        if (i8 != 0) {
            if ((196608 & i) == 0) {
                function3 = function1;
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i9 = 131072;
                } else {
                    i9 = 65536;
                }
                i3 |= i9;
            }
            if ((74899 & i3) != 74898) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z2, i3 & 1)) {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                z3 = z;
                modifier3 = modifier2;
                function4 = function2;
                function5 = function3;
            } else {
                if (i10 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i4 != 0) {
                    z4 = false;
                } else {
                    z4 = z;
                }
                if (i6 != 0) {
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2002143589, "CC(remember):TicketsShareScreens.kt#9igjgp");
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = new Function0() { // from class: com.example.tickets.TicketsShareScreensKt$$ExternalSyntheticLambda70
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Unit.INSTANCE;
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    function6 = (Function0) objRememberedValue2;
                } else {
                    function6 = function2;
                }
                if (i8 != 0) {
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2002142597, "CC(remember):TicketsShareScreens.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new Function0() { // from class: com.example.tickets.TicketsShareScreensKt$$ExternalSyntheticLambda71
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Unit.INSTANCE;
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    function7 = (Function0) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                } else {
                    function7 = function3;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(391212249, i3, -1, "com.example.tickets.TicketTransferTicketCard (TicketsShareScreens.kt:2267)");
                }
                ticketData = (TicketData) CollectionsKt.firstOrNull((List) list2);
                str = "票据";
                if (ticketData != null) {
                    str2 = "票据";
                } else {
                    str2 = "票据";
                }
                ticketData2 = (TicketData) CollectionsKt.firstOrNull((List) list2);
                if (ticketData2 != null) {
                    str = strTicketShareTypeName;
                }
                Modifier modifierM1424paddingVpY3zN18 = PaddingKt.m1424paddingVpY3zN4(BorderKt.m659borderxT4_qwU(BackgroundKt.m648backgroundbw27NRU$default(ClipKt.clip(SizeKt.m1476height3ABfNKs(SizeKt.m1495width3ABfNKs(companion, Dp.m8748constructorimpl(380.0f)), Dp.m8748constructorimpl(270.0f)), RoundedCornerShapeKt.m1756RoundedCornerShape0680j_4(f2)), ColorKt.Color(4279703322L), null, 2, null), Dp.m8748constructorimpl(1.0f), Color.m5837copywmQWz5c$default(Color.INSTANCE.m5875getWhite0d7_KjU(), 0.18f, 0.0f, 0.0f, 0.0f, 14, null), RoundedCornerShapeKt.m1756RoundedCornerShape0680j_4(f2)), Dp.m8748constructorimpl(20.0f), Dp.m8748constructorimpl(18.0f));
                Alignment.Horizontal centerHorizontally15 = Alignment.INSTANCE.getCenterHorizontally();
                Arrangement.HorizontalOrVertical center15 = Arrangement.INSTANCE.getCenter();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                MeasurePolicy measurePolicyColumnMeasurePolicy15 = ColumnKt.columnMeasurePolicy(center15, centerHorizontally15, composerStartRestartGroup, 54);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
                int iHashCode119 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap119 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier119 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1424paddingVpY3zN18);
                constructor = ComposeUiNode.INSTANCE.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)410@16216L9:Composables.kt#9igjgp");
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor);
                } else {
                    composerStartRestartGroup.useNode();
                }
                Composer composerM4937constructorimpl119 = Updater.m4937constructorimpl(composerStartRestartGroup);
                Updater.m4945setimpl(composerM4937constructorimpl119, measurePolicyColumnMeasurePolicy15, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m4945setimpl(composerM4937constructorimpl119, currentCompositionLocalMap119, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Updater.m4945setimpl(composerM4937constructorimpl119, Integer.valueOf(iHashCode119), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                Updater.m4943reconcileimpl(composerM4937constructorimpl119, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                Updater.m4945setimpl(composerM4937constructorimpl119, modifierMaterializeModifier119, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                ColumnScopeInstance columnScopeInstance15 = ColumnScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 841490239, "C2281@80779L104,2282@80892L29,2283@80930L160,2284@81099L30,2287@81406L62:TicketsShareScreens.kt#n9ob9m");
                if (list2.size() != 1) {
                    str = list2.size() + "张票据";
                }
                TextKt.m3661TextNvy7gAk(str, null, ColorKt.Color(4287795865L), null, TextUnitKt.getSp(12), null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composerStartRestartGroup, 24960, 0, 262122);
                SpacerKt.Spacer(SizeKt.m1476height3ABfNKs(Modifier.INSTANCE, Dp.m8748constructorimpl(7.0f)), composerStartRestartGroup, 6);
                function8 = function7;
                TextKt.m3661TextNvy7gAk(str2, null, Color.INSTANCE.m5875getWhite0d7_KjU(), null, TextUnitKt.getSp(21), null, FontWeight.INSTANCE.getMedium(), null, 0L, null, TextAlign.m8619boximpl(TextAlign.INSTANCE.m8626getCentere0LSkKk()), 0L, TextOverflow.INSTANCE.m8684getEllipsisgIe3tQ8(), false, 2, 0, null, null, composerStartRestartGroup, 1597824, 24960, 240554);
                composer3 = composerStartRestartGroup;
                SpacerKt.Spacer(SizeKt.m1476height3ABfNKs(Modifier.INSTANCE, Dp.m8748constructorimpl(10.0f)), composer3, 6);
                ticketData3 = (TicketData) CollectionsKt.firstOrNull((List) list);
                if (ticketData3 != null) {
                    List listListOf15 = CollectionsKt.listOf((Object[]) new String[]{ticketData3.getFrom(), ticketData3.getTo()});
                    arrayList = new ArrayList();
                    while (r9.hasNext()) {
                        if (!StringsKt.isBlank((String) obj)) {
                            arrayList.add(obj);
                        }
                    }
                    strJoinToString$default = CollectionsKt.joinToString$default(arrayList, " → ", null, null, 0, null, null, 62, null);
                } else {
                    strJoinToString$default = null;
                }
                if (strJoinToString$default == null) {
                    strJoinToString$default = "";
                }
                str3 = strJoinToString$default;
                if (StringsKt.isBlank(str3)) {
                    composer3.startReplaceGroup(841966615);
                    ComposerKt.sourceInformation(composer3, "2286@81293L104");
                    TextKt.m3661TextNvy7gAk(strJoinToString$default, null, ColorKt.Color(4289374895L), null, TextUnitKt.getSp(13), null, null, null, 0L, null, null, 0L, TextOverflow.INSTANCE.m8684getEllipsisgIe3tQ8(), false, 1, 0, null, null, composer3, 24960, 24960, 241642);
                    composer3 = composer3;
                } else {
                    composer3.startReplaceGroup(761319743);
                }
                composer3.endReplaceGroup();
                Modifier.Companion companion16 = Modifier.INSTANCE;
                if (StringsKt.isBlank(str3)) {
                    fM8748constructorimpl = Dp.m8748constructorimpl(20.0f);
                } else {
                    fM8748constructorimpl = Dp.m8748constructorimpl(14.0f);
                }
                SpacerKt.Spacer(SizeKt.m1476height3ABfNKs(companion16, fM8748constructorimpl), composer3, 0);
                if (z4) {
                    composer3.startReplaceGroup(842174563);
                    ComposerKt.sourceInformation(composer3, "2289@81508L57,2290@81578L30,2291@81621L243");
                    composer4 = composer3;
                    TextKt.m3661TextNvy7gAk("收到票据", null, ColorKt.Color(4287598486L), null, TextUnitKt.getSp(12), null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer4, 24966, 0, 262122);
                    SpacerKt.Spacer(SizeKt.m1476height3ABfNKs(Modifier.INSTANCE, Dp.m8748constructorimpl(14.0f)), composer4, 6);
                    Modifier modifierFillMaxWidth$default15 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                    Arrangement.HorizontalOrVertical horizontalOrVerticalM1115spacedBy0680j_18 = Arrangement.INSTANCE.m1115spacedBy0680j_4(Dp.m8748constructorimpl(10.0f));
                    ComposerKt.sourceInformationMarkerStart(composer4, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                    MeasurePolicy measurePolicyRowMeasurePolicy15 = RowKt.rowMeasurePolicy(horizontalOrVerticalM1115spacedBy0680j_18, Alignment.INSTANCE.getTop(), composer4, 6);
                    ComposerKt.sourceInformationMarkerStart(composer4, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
                    int iHashCode1110 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer4, 0));
                    CompositionLocalMap currentCompositionLocalMap1110 = composer4.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier1110 = ComposedModifierKt.materializeModifier(composer4, modifierFillMaxWidth$default15);
                    constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                    ComposerKt.sourceInformationMarkerStart(composer4, -553112988, "CC(ReusableComposeNode)N(factory,update,content)410@16216L9:Composables.kt#9igjgp");
                    if (!(composer4.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composer4.startReusableNode();
                    if (composer4.getInserting()) {
                        composer4.createNode(constructor2);
                    } else {
                        composer4.useNode();
                    }
                    Composer composerM4937constructorimpl1110 = Updater.m4937constructorimpl(composer4);
                    Updater.m4945setimpl(composerM4937constructorimpl1110, measurePolicyRowMeasurePolicy15, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m4945setimpl(composerM4937constructorimpl1110, currentCompositionLocalMap1110, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Updater.m4945setimpl(composerM4937constructorimpl1110, Integer.valueOf(iHashCode1110), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                    Updater.m4943reconcileimpl(composerM4937constructorimpl1110, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                    Updater.m4945setimpl(composerM4937constructorimpl1110, modifierMaterializeModifier1110, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composer4, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                    RowScopeInstance rowScopeInstance15 = RowScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composer4, -823872107, "C2292@81721L56,2293@81794L56:TicketsShareScreens.kt#n9ob9m");
                    modifier4 = companion;
                    ShareOutlinedButton("拒绝", function8, RowScope.weight$default(rowScopeInstance15, Modifier.INSTANCE, 1.0f, false, 2, null), composer4, ((i3 >> 12) & StylePropertiesKt.TextDirectionMask) | 6, 0);
                    function9 = function8;
                    Modifier modifierWeight$default15 = RowScope.weight$default(rowScopeInstance15, Modifier.INSTANCE, 1.0f, false, 2, null);
                    int i115 = ((i3 >> 9) & StylePropertiesKt.TextDirectionMask) | 6;
                    function10 = function6;
                    ShareOutlinedButton("接受", function10, modifierWeight$default15, composer4, i115, 0);
                    ComposerKt.sourceInformationMarkerEnd(composer4);
                    ComposerKt.sourceInformationMarkerEnd(composer4);
                    composer4.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer4);
                    ComposerKt.sourceInformationMarkerEnd(composer4);
                    ComposerKt.sourceInformationMarkerEnd(composer4);
                    composer4.endReplaceGroup();
                    composer2 = composer4;
                } else {
                    function9 = function8;
                    modifier4 = companion;
                    function10 = function6;
                    composer3.startReplaceGroup(842548299);
                    ComposerKt.sourceInformation(composer3, "2296@81894L60");
                    composer2 = composer3;
                    TextKt.m3661TextNvy7gAk("票据正在传输…", null, ColorKt.Color(4287598486L), null, TextUnitKt.getSp(12), null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer2, 24966, 0, 262122);
                    composer2.endReplaceGroup();
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                function4 = function10;
                z3 = z4;
                modifier3 = modifier4;
                function5 = function9;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.tickets.TicketsShareScreensKt$$ExternalSyntheticLambda72
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj2, Object obj3) {
                        return TicketsShareScreensKt.TicketTransferTicketCard_RfXq3Jk$lambda$289(list, f, modifier3, z3, function4, function5, i, i2, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                });
            }
        }
        i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        function3 = function1;
        if ((74899 & i3) != 74898) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z2, i3 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            z3 = z;
            modifier3 = modifier2;
            function4 = function2;
            function5 = function3;
        } else {
            if (i10 != 0) {
                companion = Modifier.INSTANCE;
            } else {
                companion = modifier2;
            }
            if (i4 != 0) {
                z4 = false;
            } else {
                z4 = z;
            }
            if (i6 != 0) {
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2002143589, "CC(remember):TicketsShareScreens.kt#9igjgp");
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = new Function0() { // from class: com.example.tickets.TicketsShareScreensKt$$ExternalSyntheticLambda70
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return Unit.INSTANCE;
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                function6 = (Function0) objRememberedValue2;
            } else {
                function6 = function2;
            }
            if (i8 != 0) {
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2002142597, "CC(remember):TicketsShareScreens.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function0() { // from class: com.example.tickets.TicketsShareScreensKt$$ExternalSyntheticLambda71
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return Unit.INSTANCE;
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                function7 = (Function0) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            } else {
                function7 = function3;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(391212249, i3, -1, "com.example.tickets.TicketTransferTicketCard (TicketsShareScreens.kt:2267)");
            }
            ticketData = (TicketData) CollectionsKt.firstOrNull((List) list2);
            str = "票据";
            if (ticketData != null) {
                str2 = "票据";
            } else {
                str2 = "票据";
            }
            ticketData2 = (TicketData) CollectionsKt.firstOrNull((List) list2);
            if (ticketData2 != null) {
                str = strTicketShareTypeName;
            }
            Modifier modifierM1424paddingVpY3zN19 = PaddingKt.m1424paddingVpY3zN4(BorderKt.m659borderxT4_qwU(BackgroundKt.m648backgroundbw27NRU$default(ClipKt.clip(SizeKt.m1476height3ABfNKs(SizeKt.m1495width3ABfNKs(companion, Dp.m8748constructorimpl(380.0f)), Dp.m8748constructorimpl(270.0f)), RoundedCornerShapeKt.m1756RoundedCornerShape0680j_4(f2)), ColorKt.Color(4279703322L), null, 2, null), Dp.m8748constructorimpl(1.0f), Color.m5837copywmQWz5c$default(Color.INSTANCE.m5875getWhite0d7_KjU(), 0.18f, 0.0f, 0.0f, 0.0f, 14, null), RoundedCornerShapeKt.m1756RoundedCornerShape0680j_4(f2)), Dp.m8748constructorimpl(20.0f), Dp.m8748constructorimpl(18.0f));
            Alignment.Horizontal centerHorizontally16 = Alignment.INSTANCE.getCenterHorizontally();
            Arrangement.HorizontalOrVertical center16 = Arrangement.INSTANCE.getCenter();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy16 = ColumnKt.columnMeasurePolicy(center16, centerHorizontally16, composerStartRestartGroup, 54);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
            int iHashCode1111 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap1111 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier1111 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1424paddingVpY3zN19);
            constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)410@16216L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM4937constructorimpl1111 = Updater.m4937constructorimpl(composerStartRestartGroup);
            Updater.m4945setimpl(composerM4937constructorimpl1111, measurePolicyColumnMeasurePolicy16, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m4945setimpl(composerM4937constructorimpl1111, currentCompositionLocalMap1111, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m4945setimpl(composerM4937constructorimpl1111, Integer.valueOf(iHashCode1111), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m4943reconcileimpl(composerM4937constructorimpl1111, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m4945setimpl(composerM4937constructorimpl1111, modifierMaterializeModifier1111, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance16 = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 841490239, "C2281@80779L104,2282@80892L29,2283@80930L160,2284@81099L30,2287@81406L62:TicketsShareScreens.kt#n9ob9m");
            if (list2.size() != 1) {
                str = list2.size() + "张票据";
            }
            TextKt.m3661TextNvy7gAk(str, null, ColorKt.Color(4287795865L), null, TextUnitKt.getSp(12), null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composerStartRestartGroup, 24960, 0, 262122);
            SpacerKt.Spacer(SizeKt.m1476height3ABfNKs(Modifier.INSTANCE, Dp.m8748constructorimpl(7.0f)), composerStartRestartGroup, 6);
            function8 = function7;
            TextKt.m3661TextNvy7gAk(str2, null, Color.INSTANCE.m5875getWhite0d7_KjU(), null, TextUnitKt.getSp(21), null, FontWeight.INSTANCE.getMedium(), null, 0L, null, TextAlign.m8619boximpl(TextAlign.INSTANCE.m8626getCentere0LSkKk()), 0L, TextOverflow.INSTANCE.m8684getEllipsisgIe3tQ8(), false, 2, 0, null, null, composerStartRestartGroup, 1597824, 24960, 240554);
            composer3 = composerStartRestartGroup;
            SpacerKt.Spacer(SizeKt.m1476height3ABfNKs(Modifier.INSTANCE, Dp.m8748constructorimpl(10.0f)), composer3, 6);
            ticketData3 = (TicketData) CollectionsKt.firstOrNull((List) list);
            if (ticketData3 != null) {
                List listListOf16 = CollectionsKt.listOf((Object[]) new String[]{ticketData3.getFrom(), ticketData3.getTo()});
                arrayList = new ArrayList();
                while (r9.hasNext()) {
                    if (!StringsKt.isBlank((String) obj)) {
                        arrayList.add(obj);
                    }
                }
                strJoinToString$default = CollectionsKt.joinToString$default(arrayList, " → ", null, null, 0, null, null, 62, null);
            } else {
                strJoinToString$default = null;
            }
            if (strJoinToString$default == null) {
                strJoinToString$default = "";
            }
            str3 = strJoinToString$default;
            if (StringsKt.isBlank(str3)) {
                composer3.startReplaceGroup(841966615);
                ComposerKt.sourceInformation(composer3, "2286@81293L104");
                TextKt.m3661TextNvy7gAk(strJoinToString$default, null, ColorKt.Color(4289374895L), null, TextUnitKt.getSp(13), null, null, null, 0L, null, null, 0L, TextOverflow.INSTANCE.m8684getEllipsisgIe3tQ8(), false, 1, 0, null, null, composer3, 24960, 24960, 241642);
                composer3 = composer3;
            } else {
                composer3.startReplaceGroup(761319743);
            }
            composer3.endReplaceGroup();
            Modifier.Companion companion17 = Modifier.INSTANCE;
            if (StringsKt.isBlank(str3)) {
                fM8748constructorimpl = Dp.m8748constructorimpl(20.0f);
            } else {
                fM8748constructorimpl = Dp.m8748constructorimpl(14.0f);
            }
            SpacerKt.Spacer(SizeKt.m1476height3ABfNKs(companion17, fM8748constructorimpl), composer3, 0);
            if (z4) {
                composer3.startReplaceGroup(842174563);
                ComposerKt.sourceInformation(composer3, "2289@81508L57,2290@81578L30,2291@81621L243");
                composer4 = composer3;
                TextKt.m3661TextNvy7gAk("收到票据", null, ColorKt.Color(4287598486L), null, TextUnitKt.getSp(12), null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer4, 24966, 0, 262122);
                SpacerKt.Spacer(SizeKt.m1476height3ABfNKs(Modifier.INSTANCE, Dp.m8748constructorimpl(14.0f)), composer4, 6);
                Modifier modifierFillMaxWidth$default16 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                Arrangement.HorizontalOrVertical horizontalOrVerticalM1115spacedBy0680j_19 = Arrangement.INSTANCE.m1115spacedBy0680j_4(Dp.m8748constructorimpl(10.0f));
                ComposerKt.sourceInformationMarkerStart(composer4, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                MeasurePolicy measurePolicyRowMeasurePolicy16 = RowKt.rowMeasurePolicy(horizontalOrVerticalM1115spacedBy0680j_19, Alignment.INSTANCE.getTop(), composer4, 6);
                ComposerKt.sourceInformationMarkerStart(composer4, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
                int iHashCode1112 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer4, 0));
                CompositionLocalMap currentCompositionLocalMap1112 = composer4.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier1112 = ComposedModifierKt.materializeModifier(composer4, modifierFillMaxWidth$default16);
                constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composer4, -553112988, "CC(ReusableComposeNode)N(factory,update,content)410@16216L9:Composables.kt#9igjgp");
                if (!(composer4.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composer4.startReusableNode();
                if (composer4.getInserting()) {
                    composer4.createNode(constructor2);
                } else {
                    composer4.useNode();
                }
                Composer composerM4937constructorimpl1112 = Updater.m4937constructorimpl(composer4);
                Updater.m4945setimpl(composerM4937constructorimpl1112, measurePolicyRowMeasurePolicy16, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m4945setimpl(composerM4937constructorimpl1112, currentCompositionLocalMap1112, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Updater.m4945setimpl(composerM4937constructorimpl1112, Integer.valueOf(iHashCode1112), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                Updater.m4943reconcileimpl(composerM4937constructorimpl1112, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                Updater.m4945setimpl(composerM4937constructorimpl1112, modifierMaterializeModifier1112, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composer4, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                RowScopeInstance rowScopeInstance16 = RowScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composer4, -823872107, "C2292@81721L56,2293@81794L56:TicketsShareScreens.kt#n9ob9m");
                modifier4 = companion;
                ShareOutlinedButton("拒绝", function8, RowScope.weight$default(rowScopeInstance16, Modifier.INSTANCE, 1.0f, false, 2, null), composer4, ((i3 >> 12) & StylePropertiesKt.TextDirectionMask) | 6, 0);
                function9 = function8;
                Modifier modifierWeight$default16 = RowScope.weight$default(rowScopeInstance16, Modifier.INSTANCE, 1.0f, false, 2, null);
                int i116 = ((i3 >> 9) & StylePropertiesKt.TextDirectionMask) | 6;
                function10 = function6;
                ShareOutlinedButton("接受", function10, modifierWeight$default16, composer4, i116, 0);
                ComposerKt.sourceInformationMarkerEnd(composer4);
                ComposerKt.sourceInformationMarkerEnd(composer4);
                composer4.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer4);
                ComposerKt.sourceInformationMarkerEnd(composer4);
                ComposerKt.sourceInformationMarkerEnd(composer4);
                composer4.endReplaceGroup();
                composer2 = composer4;
            } else {
                function9 = function8;
                modifier4 = companion;
                function10 = function6;
                composer3.startReplaceGroup(842548299);
                ComposerKt.sourceInformation(composer3, "2296@81894L60");
                composer2 = composer3;
                TextKt.m3661TextNvy7gAk("票据正在传输…", null, ColorKt.Color(4287598486L), null, TextUnitKt.getSp(12), null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer2, 24966, 0, 262122);
                composer2.endReplaceGroup();
            }
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            function4 = function10;
            z3 = z4;
            modifier3 = modifier4;
            function5 = function9;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.tickets.TicketsShareScreensKt$$ExternalSyntheticLambda72
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    return TicketsShareScreensKt.TicketTransferTicketCard_RfXq3Jk$lambda$289(list, f, modifier3, z3, function4, function5, i, i2, (Composer) obj2, ((Integer) obj3).intValue());
                }
            });
        }
    }

    private static final void NfcMiniArtwork(final boolean z, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-691258435);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(NfcMiniArtwork)N(topTouch)2303@82038L2684:TicketsShareScreens.kt#n9ob9m");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-691258435, i2, -1, "com.example.tickets.NfcMiniArtwork (TicketsShareScreens.kt:2302)");
            }
            Modifier modifierM659borderxT4_qwU = BorderKt.m659borderxT4_qwU(BackgroundKt.m648backgroundbw27NRU$default(ClipKt.clip(SizeKt.m1492sizeVpY3zN4(Modifier.INSTANCE, Dp.m8748constructorimpl(126.0f), Dp.m8748constructorimpl(74.0f)), RoundedCornerShapeKt.m1756RoundedCornerShape0680j_4(Dp.m8748constructorimpl(18.0f))), ColorKt.Color(4279308563L), null, 2, null), Dp.m8748constructorimpl(1.0f), Color.m5837copywmQWz5c$default(Color.INSTANCE.m5875getWhite0d7_KjU(), 0.1f, 0.0f, 0.0f, 0.0f, 14, null), RoundedCornerShapeKt.m1756RoundedCornerShape0680j_4(Dp.m8748constructorimpl(18.0f)));
            Alignment center = Alignment.INSTANCE.getCenter();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM659borderxT4_qwU);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)410@16216L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM4937constructorimpl = Updater.m4937constructorimpl(composerStartRestartGroup);
            Updater.m4945setimpl(composerM4937constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m4945setimpl(composerM4937constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m4945setimpl(composerM4937constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m4943reconcileimpl(composerM4937constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m4945setimpl(composerM4937constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 211361525, "C2315@82432L2284,2315@82401L2315:TicketsShareScreens.kt#n9ob9m");
            Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 422461071, "CC(remember):TicketsShareScreens.kt#9igjgp");
            boolean z2 = (i2 & 14) == 4;
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z2 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: com.example.tickets.TicketsShareScreensKt$$ExternalSyntheticLambda77
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return TicketsShareScreensKt.NfcMiniArtwork$lambda$292$lambda$291$lambda$290(z, (DrawScope) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            CanvasKt.Canvas(modifierFillMaxSize$default, (Function1) objRememberedValue, composerStartRestartGroup, 6);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.tickets.TicketsShareScreensKt$$ExternalSyntheticLambda88
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TicketsShareScreensKt.NfcMiniArtwork$lambda$293(z, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final void PermissionPanel(final String str, final String str2, final Function0<Unit> function0, final Function0<Unit> function1, Composer composer, final int i) {
        String str3;
        int i2;
        Composer composer2;
        Composer composerStartRestartGroup = composer.startRestartGroup(921963738);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(PermissionPanel)N(title,message,onGrant,onBack)2368@84845L1038:TicketsShareScreens.kt#n9ob9m");
        if ((i & 6) == 0) {
            str3 = str;
            i2 = (composerStartRestartGroup.changed(str3) ? 4 : 2) | i;
        } else {
            str3 = str;
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(str2) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function0) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function1) ? 2048 : 1024;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 1171) != 1170, i2 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(921963738, i2, -1, "com.example.tickets.PermissionPanel (TicketsShareScreens.kt:2367)");
            }
            Modifier modifierM1423padding3ABfNKs = PaddingKt.m1423padding3ABfNKs(BackgroundKt.m648backgroundbw27NRU$default(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), Color.INSTANCE.m5864getBlack0d7_KjU(), null, 2, null), Dp.m8748constructorimpl(28.0f));
            Alignment.Horizontal centerHorizontally = Alignment.INSTANCE.getCenterHorizontally();
            Arrangement.HorizontalOrVertical center = Arrangement.INSTANCE.getCenter();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(center, centerHorizontally, composerStartRestartGroup, 54);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1423padding3ABfNKs);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)410@16216L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM4937constructorimpl = Updater.m4937constructorimpl(composerStartRestartGroup);
            Updater.m4945setimpl(composerM4937constructorimpl, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m4945setimpl(composerM4937constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m4945setimpl(composerM4937constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m4943reconcileimpl(composerM4937constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m4945setimpl(composerM4937constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1372199253, "C2376@85099L82,2377@85190L30,2378@85229L88,2379@85326L30,2380@85365L332,2388@85706L30,2389@85745L132:TicketsShareScreens.kt#n9ob9m");
            int i3 = i2;
            TextKt.m3661TextNvy7gAk(str3, null, Color.INSTANCE.m5875getWhite0d7_KjU(), null, TextUnitKt.getSp(22), null, FontWeight.INSTANCE.getMedium(), null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composerStartRestartGroup, (i2 & 14) | 1597824, 0, 262058);
            SpacerKt.Spacer(SizeKt.m1476height3ABfNKs(Modifier.INSTANCE, Dp.m8748constructorimpl(12.0f)), composerStartRestartGroup, 6);
            TextKt.m3661TextNvy7gAk(str2, null, ColorKt.Color(4287598486L), null, TextUnitKt.getSp(14), null, null, null, 0L, null, TextAlign.m8619boximpl(TextAlign.INSTANCE.m8626getCentere0LSkKk()), 0L, 0, false, 0, 0, null, null, composerStartRestartGroup, (14 & (i3 >> 3)) | 24960, 0, 261098);
            SpacerKt.Spacer(SizeKt.m1476height3ABfNKs(Modifier.INSTANCE, Dp.m8748constructorimpl(24.0f)), composerStartRestartGroup, 6);
            Modifier modifierM683clickableoSLSa3U$default = ClickableKt.m683clickableoSLSa3U$default(BackgroundKt.m647backgroundbw27NRU(SizeKt.m1476height3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m8748constructorimpl(52.0f)), ColorKt.Color(4281303295L), RoundedCornerShapeKt.m1756RoundedCornerShape0680j_4(Dp.m8748constructorimpl(16.0f))), false, null, null, null, function0, 15, null);
            Alignment center2 = Alignment.INSTANCE.getCenter();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center2, false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
            int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM683clickableoSLSa3U$default);
            Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)410@16216L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor2);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM4937constructorimpl2 = Updater.m4937constructorimpl(composerStartRestartGroup);
            Updater.m4945setimpl(composerM4937constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m4945setimpl(composerM4937constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m4945setimpl(composerM4937constructorimpl2, Integer.valueOf(iHashCode2), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m4943reconcileimpl(composerM4937constructorimpl2, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m4945setimpl(composerM4937constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1875088916, "C2387@85646L49:TicketsShareScreens.kt#n9ob9m");
            composer2 = composerStartRestartGroup;
            TextKt.m3661TextNvy7gAk("允许", null, Color.INSTANCE.m5875getWhite0d7_KjU(), null, TextUnitKt.getSp(16), null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer2, 24966, 0, 262122);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            SpacerKt.Spacer(SizeKt.m1476height3ABfNKs(Modifier.INSTANCE, Dp.m8748constructorimpl(12.0f)), composer2, 6);
            ShareOutlinedButton("返回", function1, SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), composer2, ((i3 >> 6) & StylePropertiesKt.TextDirectionMask) | 390, 0);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.tickets.TicketsShareScreensKt$$ExternalSyntheticLambda18
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TicketsShareScreensKt.PermissionPanel$lambda$296(str, str2, function0, function1, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final void QrScannerPanel(final Function1<? super String, Unit> function1, Function0<Unit> function0, Composer composer, final int i) {
        int i2;
        final Function0<Unit> function2;
        Composer composer2;
        float f;
        int i3;
        int i4;
        Object obj;
        Composer composer3;
        Composer composerStartRestartGroup = composer.startRestartGroup(1132459403);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(QrScannerPanel)N(onResult,onClose)2471@89120L7,2472@89150L33,2474@89270L34,2476@89380L138,2481@89637L34,2479@89544L127,2483@89715L2486,2483@89677L2524,2536@92207L865:TicketsShareScreens.kt#n9ob9m");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(function1) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function0) ? 32 : 16;
        }
        int i5 = i2;
        if (!composerStartRestartGroup.shouldExecute((i5 & 19) != 18, i5 & 1)) {
            function2 = function0;
            composer2 = composerStartRestartGroup;
            function1 = function1;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1132459403, i5, -1, "com.example.tickets.QrScannerPanel (TicketsShareScreens.kt:2470)");
            }
            ProvidableCompositionLocal<Context> localContext = AndroidCompositionLocals_androidKt.getLocalContext();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composerStartRestartGroup.consume(localContext);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            final Context context = (Context) objConsume;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1666766412, "CC(remember):TicketsShareScreens.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new PreviewView(context);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            final PreviewView previewView = (PreviewView) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            final ComponentActivity componentActivity = context instanceof ComponentActivity ? (ComponentActivity) context : null;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1666770253, "CC(remember):TicketsShareScreens.kt#9igjgp");
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            final MutableState mutableState = (MutableState) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1666773877, "CC(remember):TicketsShareScreens.kt#9igjgp");
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            final String str = "android.permission.CAMERA";
            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(ContextCompat.checkSelfPermission(context, "android.permission.CAMERA") == 0), null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            final MutableState mutableState2 = (MutableState) objRememberedValue3;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ActivityResultContracts.RequestPermission requestPermission = new ActivityResultContracts.RequestPermission();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1666781997, "CC(remember):TicketsShareScreens.kt#9igjgp");
            Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue4 = new Function1() { // from class: com.example.tickets.TicketsShareScreensKt$$ExternalSyntheticLambda19
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return TicketsShareScreensKt.QrScannerPanel$lambda$305$lambda$304(mutableState2, ((Boolean) obj2).booleanValue());
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            final ManagedActivityResultLauncher managedActivityResultLauncherRememberLauncherForActivityResult = ActivityResultRegistryKt.rememberLauncherForActivityResult(requestPermission, (Function1) objRememberedValue4, composerStartRestartGroup, 48);
            Boolean boolValueOf = Boolean.valueOf(QrScannerPanel$lambda$302(mutableState2));
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1666786945, "CC(remember):TicketsShareScreens.kt#9igjgp");
            boolean zChangedInstance = ((i5 & 14) == 4) | composerStartRestartGroup.changedInstance(componentActivity) | composerStartRestartGroup.changedInstance(context) | composerStartRestartGroup.changedInstance(previewView);
            Object objRememberedValue5 = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                Function1 function3 = new Function1() { // from class: com.example.tickets.TicketsShareScreensKt$$ExternalSyntheticLambda20
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return TicketsShareScreensKt.QrScannerPanel$lambda$317$lambda$316(componentActivity, context, mutableState2, previewView, mutableState, function1, (DisposableEffectScope) obj2);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(function3);
                objRememberedValue5 = function3;
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.DisposableEffect(boolValueOf, componentActivity, (Function1) objRememberedValue5, composerStartRestartGroup, 0);
            Modifier modifierM1476height3ABfNKs = SizeKt.m1476height3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m8748constructorimpl(430.0f));
            Alignment.Horizontal centerHorizontally = Alignment.INSTANCE.getCenterHorizontally();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), centerHorizontally, composerStartRestartGroup, 48);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1476height3ABfNKs);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)410@16216L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM4937constructorimpl = Updater.m4937constructorimpl(composerStartRestartGroup);
            Updater.m4945setimpl(composerM4937constructorimpl, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m4945setimpl(composerM4937constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m4945setimpl(composerM4937constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m4943reconcileimpl(composerM4937constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m4945setimpl(composerM4937constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 584471413, "C2554@92894L30,2555@92933L133:TicketsShareScreens.kt#n9ob9m");
            if (!QrScannerPanel$lambda$302(mutableState2)) {
                composerStartRestartGroup.startReplaceGroup(584475194);
                ComposerKt.sourceInformation(composerStartRestartGroup, "2541@92379L60,2542@92452L30,2545@92573L43,2543@92495L187");
                i3 = i5;
                TextKt.m3661TextNvy7gAk("需要相机权限才能扫描二维码", null, Color.INSTANCE.m5875getWhite0d7_KjU(), null, TextUnitKt.getSp(14), null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composerStartRestartGroup, 24966, 0, 262122);
                SpacerKt.Spacer(SizeKt.m1476height3ABfNKs(Modifier.INSTANCE, Dp.m8748constructorimpl(14.0f)), composerStartRestartGroup, 6);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1681428396, "CC(remember):TicketsShareScreens.kt#9igjgp");
                boolean zChangedInstance2 = composerStartRestartGroup.changedInstance(managedActivityResultLauncherRememberLauncherForActivityResult);
                Object objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                if (zChangedInstance2 || objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue6 = new Function0() { // from class: com.example.tickets.TicketsShareScreensKt$$ExternalSyntheticLambda21
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return TicketsShareScreensKt.QrScannerPanel$lambda$322$lambda$319$lambda$318(managedActivityResultLauncherRememberLauncherForActivityResult, str);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                f = 0.0f;
                obj = null;
                i4 = 1;
                ShareOutlinedButton("允许相机", (Function0) objRememberedValue6, SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), composerStartRestartGroup, 390, 0);
                composer3 = composerStartRestartGroup;
                composer3.endReplaceGroup();
            } else {
                f = 0.0f;
                i3 = i5;
                i4 = 1;
                obj = null;
                composerStartRestartGroup.startReplaceGroup(584801190);
                ComposerKt.sourceInformation(composerStartRestartGroup, "2550@92751L15,2549@92712L163");
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1681434064, "CC(remember):TicketsShareScreens.kt#9igjgp");
                boolean zChangedInstance3 = composerStartRestartGroup.changedInstance(previewView);
                Object objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                if (zChangedInstance3 || objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue7 = new Function1() { // from class: com.example.tickets.TicketsShareScreensKt$$ExternalSyntheticLambda22
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return TicketsShareScreensKt.QrScannerPanel$lambda$322$lambda$321$lambda$320(previewView, (Context) obj2);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                AndroidView_androidKt.AndroidView((Function1) objRememberedValue7, ClipKt.clip(ColumnScope.weight$default(columnScopeInstance, SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), 1.0f, false, 2, null), RoundedCornerShapeKt.m1756RoundedCornerShape0680j_4(Dp.m8748constructorimpl(24.0f))), null, composerStartRestartGroup, 0, 4);
                composer3 = composerStartRestartGroup;
                composer3.endReplaceGroup();
            }
            SpacerKt.Spacer(SizeKt.m1476height3ABfNKs(Modifier.INSTANCE, Dp.m8748constructorimpl(12.0f)), composer3, 6);
            function2 = function0;
            ShareOutlinedButton("关闭", function2, SizeKt.fillMaxWidth$default(Modifier.INSTANCE, f, i4, obj), composer3, (i3 & StylePropertiesKt.TextDirectionMask) | 390, 0);
            composer2 = composer3;
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.tickets.TicketsShareScreensKt$$ExternalSyntheticLambda23
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    return TicketsShareScreensKt.QrScannerPanel$lambda$323(function1, function2, i, (Composer) obj2, ((Integer) obj3).intValue());
                }
            });
        }
    }

    private static final boolean QrScannerPanel$lambda$299(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void QrScannerPanel$lambda$300(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final boolean QrScannerPanel$lambda$302(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void QrScannerPanel$lambda$303(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    static final Unit QrScannerPanel$lambda$305$lambda$304(MutableState mutableState, boolean z) {
        QrScannerPanel$lambda$303(mutableState, z);
        return Unit.INSTANCE;
    }

    static final DisposableEffectResult QrScannerPanel$lambda$317$lambda$316(final ComponentActivity componentActivity, final Context context, MutableState mutableState, final PreviewView previewView, final MutableState mutableState2, final Function1 function1, final DisposableEffectScope DisposableEffect) {
        Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
        if (QrScannerPanel$lambda$302(mutableState) && componentActivity != null) {
            final ListenableFuture<ProcessCameraProvider> companion = ProcessCameraProvider.INSTANCE.getInstance(context);
            final Executor mainExecutor = ContextCompat.getMainExecutor(context);
            Intrinsics.checkNotNullExpressionValue(mainExecutor, "getMainExecutor(...)");
            final BarcodeScanner client = BarcodeScanning.getClient(new BarcodeScannerOptions.Builder().setBarcodeFormats(256, new int[0]).build());
            Intrinsics.checkNotNullExpressionValue(client, "getClient(...)");
            companion.addListener(new Runnable() { // from class: com.example.tickets.TicketsShareScreensKt$$ExternalSyntheticLambda80
                @Override // java.lang.Runnable
                public final void run() {
                    TicketsShareScreensKt.QrScannerPanel$lambda$317$lambda$316$lambda$313(DisposableEffect, companion, mainExecutor, componentActivity, previewView, client, mutableState2, function1);
                }
            }, mainExecutor);
            return new DisposableEffectResult() { // from class: com.example.tickets.TicketsShareScreensKt$QrScannerPanel$lambda$317$lambda$316$$inlined$onDispose$2
                @Override // androidx.compose.runtime.DisposableEffectResult
                public void dispose() {
                    try {
                        Result.Companion companion2 = Result.INSTANCE;
                        ProcessCameraProvider.INSTANCE.getInstance(context).get().unbindAll();
                        Result.m9536constructorimpl(Unit.INSTANCE);
                    } catch (Throwable th) {
                        Result.Companion companion3 = Result.INSTANCE;
                        Result.m9536constructorimpl(ResultKt.createFailure(th));
                    }
                    client.close();
                }
            };
        }
        return new DisposableEffectResult() { // from class: com.example.tickets.TicketsShareScreensKt$QrScannerPanel$lambda$317$lambda$316$$inlined$onDispose$1
            @Override // androidx.compose.runtime.DisposableEffectResult
            public void dispose() {
            }
        };
    }

    /* JADX WARN: Multi-variable type inference failed */
    static final void QrScannerPanel$lambda$317$lambda$316$lambda$313(DisposableEffectScope disposableEffectScope, ListenableFuture listenableFuture, Executor executor, ComponentActivity componentActivity, PreviewView previewView, final BarcodeScanner barcodeScanner, final MutableState mutableState, final Function1 function1) {
        try {
            Result.Companion companion = Result.INSTANCE;
            ProcessCameraProvider processCameraProvider = (ProcessCameraProvider) listenableFuture.get();
            Preview previewBuild = new Preview.Builder().build();
            previewBuild.setSurfaceProvider(previewView.getSurfaceProvider());
            Intrinsics.checkNotNullExpressionValue(previewBuild, "also(...)");
            ImageAnalysis imageAnalysisBuild = new ImageAnalysis.Builder().setBackpressureStrategy(0).build();
            Intrinsics.checkNotNullExpressionValue(imageAnalysisBuild, "build(...)");
            imageAnalysisBuild.setAnalyzer(executor, new ImageAnalysis.Analyzer() { // from class: com.example.tickets.TicketsShareScreensKt$$ExternalSyntheticLambda90
                @Override // androidx.camera.core.ImageAnalysis.Analyzer
                public final void analyze(ImageProxy imageProxy) {
                    TicketsShareScreensKt.QrScannerPanel$lambda$317$lambda$316$lambda$313$lambda$312$lambda$311(barcodeScanner, mutableState, function1, imageProxy);
                }
            });
            processCameraProvider.unbindAll();
            CameraSelector DEFAULT_BACK_CAMERA = CameraSelector.DEFAULT_BACK_CAMERA;
            Intrinsics.checkNotNullExpressionValue(DEFAULT_BACK_CAMERA, "DEFAULT_BACK_CAMERA");
            Result.m9536constructorimpl(processCameraProvider.bindToLifecycle(componentActivity, DEFAULT_BACK_CAMERA, previewBuild, imageAnalysisBuild));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m9536constructorimpl(ResultKt.createFailure(th));
        }
    }

    static final void QrScannerPanel$lambda$317$lambda$316$lambda$313$lambda$312$lambda$311(BarcodeScanner barcodeScanner, final MutableState mutableState, final Function1 function1, final ImageProxy imageProxy) {
        Intrinsics.checkNotNullParameter(imageProxy, "imageProxy");
        if (QrScannerPanel$lambda$299(mutableState)) {
            imageProxy.close();
            return;
        }
        Image analyzerImage = getAnalyzerImage(imageProxy);
        if (analyzerImage == null) {
            imageProxy.close();
            return;
        }
        Task<List<Barcode>> taskProcess = barcodeScanner.process(InputImage.fromMediaImage(analyzerImage, imageProxy.getImageInfo().getRotationDegrees()));
        final Function1 function2 = new Function1() { // from class: com.example.tickets.TicketsShareScreensKt$$ExternalSyntheticLambda59
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return TicketsShareScreensKt.QrScannerPanel$lambda$317$lambda$316$lambda$313$lambda$312$lambda$311$lambda$308(function1, mutableState, (List) obj);
            }
        };
        taskProcess.addOnSuccessListener(new OnSuccessListener() { // from class: com.example.tickets.TicketsShareScreensKt$$ExternalSyntheticLambda60
            @Override // com.google.android.gms.tasks.OnSuccessListener
            public final void onSuccess(Object obj) {
                function2.invoke(obj);
            }
        }).addOnCompleteListener(new OnCompleteListener() { // from class: com.example.tickets.TicketsShareScreensKt$$ExternalSyntheticLambda61
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                TicketsShareScreensKt.QrScannerPanel$lambda$317$lambda$316$lambda$313$lambda$312$lambda$311$lambda$310(imageProxy, task);
            }
        });
    }

    static final Unit QrScannerPanel$lambda$317$lambda$316$lambda$313$lambda$312$lambda$311$lambda$308(Function1 function1, MutableState mutableState, List list) {
        String rawValue;
        Intrinsics.checkNotNull(list);
        Barcode barcode = (Barcode) CollectionsKt.firstOrNull(list);
        String string = (barcode == null || (rawValue = barcode.getRawValue()) == null) ? null : StringsKt.trim((CharSequence) rawValue).toString();
        if (string == null) {
            string = "";
        }
        if (!StringsKt.isBlank(string) && !QrScannerPanel$lambda$299(mutableState)) {
            QrScannerPanel$lambda$300(mutableState, true);
            function1.invoke(string);
        }
        return Unit.INSTANCE;
    }

    static final void QrScannerPanel$lambda$317$lambda$316$lambda$313$lambda$312$lambda$311$lambda$310(ImageProxy imageProxy, Task it) {
        Intrinsics.checkNotNullParameter(it, "it");
        imageProxy.close();
    }

    static final Unit QrScannerPanel$lambda$322$lambda$319$lambda$318(ManagedActivityResultLauncher managedActivityResultLauncher, String str) {
        managedActivityResultLauncher.launch(str);
        return Unit.INSTANCE;
    }

    private static final Bitmap generateShareQrBitmap(String str) {
        Object objM9536constructorimpl;
        if (StringsKt.isBlank(str)) {
            return null;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            BitMatrix bitMatrixEncode = new MultiFormatWriter().encode(str, BarcodeFormat.QR_CODE, 720, 720);
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(720, 720, Bitmap.Config.ARGB_8888);
            Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(...)");
            for (int i = 0; i < 720; i++) {
                for (int i2 = 0; i2 < 720; i2++) {
                    bitmapCreateBitmap.setPixel(i, i2, bitMatrixEncode.get(i, i2) ? -16777216 : -1);
                }
            }
            objM9536constructorimpl = Result.m9536constructorimpl(bitmapCreateBitmap);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM9536constructorimpl = Result.m9536constructorimpl(ResultKt.createFailure(th));
        }
        return (Bitmap) (Result.m9542isFailureimpl(objM9536constructorimpl) ? null : objM9536constructorimpl);
    }

    static final Unit ShareQrScanIcon$lambda$45$lambda$44(DrawScope Canvas) {
        Intrinsics.checkNotNullParameter(Canvas, "$this$Canvas");
        float f = Canvas.mo803toPx0680j_4(Dp.m8748constructorimpl(1.8f));
        float f2 = Canvas.mo803toPx0680j_4(Dp.m8748constructorimpl(6.0f));
        float f3 = Canvas.mo803toPx0680j_4(Dp.m8748constructorimpl(4.0f));
        float f4 = Canvas.mo803toPx0680j_4(Dp.m8748constructorimpl(2.0f));
        float f5 = Canvas.mo803toPx0680j_4(Dp.m8748constructorimpl(2.0f));
        float fIntBitsToFloat = Float.intBitsToFloat((int) (Canvas.mo6437getSizeNHjbRc() >> 32)) - Canvas.mo803toPx0680j_4(Dp.m8748constructorimpl(2.0f));
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (Canvas.mo6437getSizeNHjbRc() & 4294967295L)) - Canvas.mo803toPx0680j_4(Dp.m8748constructorimpl(2.0f));
        float f6 = f5 + f2;
        DrawScope.m6423drawLineNGM6Ib0$default(Canvas, Color.INSTANCE.m5875getWhite0d7_KjU(), Offset.m5559constructorimpl((((long) Float.floatToRawIntBits(f4)) << 32) | (((long) Float.floatToRawIntBits(f6)) & 4294967295L)), Offset.m5559constructorimpl((((long) Float.floatToRawIntBits(f4)) << 32) | (((long) Float.floatToRawIntBits(f5)) & 4294967295L)), f, 0, null, 0.0f, null, 0, 496, null);
        float f7 = f4 + f2;
        DrawScope.m6423drawLineNGM6Ib0$default(Canvas, Color.INSTANCE.m5875getWhite0d7_KjU(), Offset.m5559constructorimpl((((long) Float.floatToRawIntBits(f4)) << 32) | (((long) Float.floatToRawIntBits(f5)) & 4294967295L)), Offset.m5559constructorimpl((((long) Float.floatToRawIntBits(f7)) << 32) | (((long) Float.floatToRawIntBits(f5)) & 4294967295L)), f, 0, null, 0.0f, null, 0, 496, null);
        float f8 = fIntBitsToFloat - f2;
        DrawScope.m6423drawLineNGM6Ib0$default(Canvas, Color.INSTANCE.m5875getWhite0d7_KjU(), Offset.m5559constructorimpl((((long) Float.floatToRawIntBits(f8)) << 32) | (((long) Float.floatToRawIntBits(f5)) & 4294967295L)), Offset.m5559constructorimpl((((long) Float.floatToRawIntBits(fIntBitsToFloat)) << 32) | (((long) Float.floatToRawIntBits(f5)) & 4294967295L)), f, 0, null, 0.0f, null, 0, 496, null);
        DrawScope.m6423drawLineNGM6Ib0$default(Canvas, Color.INSTANCE.m5875getWhite0d7_KjU(), Offset.m5559constructorimpl((((long) Float.floatToRawIntBits(fIntBitsToFloat)) << 32) | (((long) Float.floatToRawIntBits(f5)) & 4294967295L)), Offset.m5559constructorimpl((((long) Float.floatToRawIntBits(fIntBitsToFloat)) << 32) | (((long) Float.floatToRawIntBits(f6)) & 4294967295L)), f, 0, null, 0.0f, null, 0, 496, null);
        float f9 = fIntBitsToFloat2 - f2;
        DrawScope.m6423drawLineNGM6Ib0$default(Canvas, Color.INSTANCE.m5875getWhite0d7_KjU(), Offset.m5559constructorimpl((((long) Float.floatToRawIntBits(f4)) << 32) | (((long) Float.floatToRawIntBits(f9)) & 4294967295L)), Offset.m5559constructorimpl((((long) Float.floatToRawIntBits(f4)) << 32) | (((long) Float.floatToRawIntBits(fIntBitsToFloat2)) & 4294967295L)), f, 0, null, 0.0f, null, 0, 496, null);
        DrawScope.m6423drawLineNGM6Ib0$default(Canvas, Color.INSTANCE.m5875getWhite0d7_KjU(), Offset.m5559constructorimpl((((long) Float.floatToRawIntBits(f4)) << 32) | (((long) Float.floatToRawIntBits(fIntBitsToFloat2)) & 4294967295L)), Offset.m5559constructorimpl((((long) Float.floatToRawIntBits(f7)) << 32) | (((long) Float.floatToRawIntBits(fIntBitsToFloat2)) & 4294967295L)), f, 0, null, 0.0f, null, 0, 496, null);
        DrawScope.m6423drawLineNGM6Ib0$default(Canvas, Color.INSTANCE.m5875getWhite0d7_KjU(), Offset.m5559constructorimpl((((long) Float.floatToRawIntBits(f8)) << 32) | (((long) Float.floatToRawIntBits(fIntBitsToFloat2)) & 4294967295L)), Offset.m5559constructorimpl((((long) Float.floatToRawIntBits(fIntBitsToFloat)) << 32) | (((long) Float.floatToRawIntBits(fIntBitsToFloat2)) & 4294967295L)), f, 0, null, 0.0f, null, 0, 496, null);
        DrawScope.m6423drawLineNGM6Ib0$default(Canvas, Color.INSTANCE.m5875getWhite0d7_KjU(), Offset.m5559constructorimpl((((long) Float.floatToRawIntBits(fIntBitsToFloat)) << 32) | (((long) Float.floatToRawIntBits(f9)) & 4294967295L)), Offset.m5559constructorimpl((((long) Float.floatToRawIntBits(fIntBitsToFloat)) << 32) | (((long) Float.floatToRawIntBits(fIntBitsToFloat2)) & 4294967295L)), f, 0, null, 0.0f, null, 0, 496, null);
        float fIntBitsToFloat3 = Float.intBitsToFloat((int) (Canvas.mo6437getSizeNHjbRc() & 4294967295L)) / 2.0f;
        DrawScope.m6423drawLineNGM6Ib0$default(Canvas, Color.INSTANCE.m5875getWhite0d7_KjU(), Offset.m5559constructorimpl((((long) Float.floatToRawIntBits(f4 + f3)) << 32) | (((long) Float.floatToRawIntBits(fIntBitsToFloat3)) & 4294967295L)), Offset.m5559constructorimpl((((long) Float.floatToRawIntBits(fIntBitsToFloat - f3)) << 32) | (((long) Float.floatToRawIntBits(fIntBitsToFloat3)) & 4294967295L)), f, 0, null, 0.0f, null, 0, 496, null);
        return Unit.INSTANCE;
    }

    static final Unit TicketTransferDirectionScreen$lambda$54(Function0 function0, Function0 function1, Function0 function2, Modifier pageModifier, Composer composer, int i) {
        int i2;
        Intrinsics.checkNotNullParameter(pageModifier, "pageModifier");
        ComposerKt.sourceInformation(composer, "CN(pageModifier)669@22701L1465:TicketsShareScreens.kt#n9ob9m");
        if ((i & 6) == 0) {
            i2 = i | (composer.changed(pageModifier) ? 4 : 2);
        } else {
            i2 = i;
        }
        if (!composer.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2062944677, i2, -1, "com.example.tickets.TicketTransferDirectionScreen.<anonymous> (TicketsShareScreens.kt:669)");
            }
            Modifier modifierM1425paddingVpY3zN4$default = PaddingKt.m1425paddingVpY3zN4$default(pageModifier, Dp.m8748constructorimpl(20.0f), 0.0f, 2, null);
            Alignment.Horizontal centerHorizontally = Alignment.INSTANCE.getCenterHorizontally();
            ComposerKt.sourceInformationMarkerStart(composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), centerHorizontally, composer, 48);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierM1425paddingVpY3zN4$default);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)410@16216L9:Composables.kt#9igjgp");
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor);
            } else {
                composer.useNode();
            }
            Composer composerM4937constructorimpl = Updater.m4937constructorimpl(composer);
            Updater.m4945setimpl(composerM4937constructorimpl, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m4945setimpl(composerM4937constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m4945setimpl(composerM4937constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m4943reconcileimpl(composerM4937constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m4945setimpl(composerM4937constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, -711986525, "C673@22861L30,675@22905L161,682@23080L29,684@23123L171,691@23308L30,693@23387L7,693@23352L43,695@23409L30,697@23453L197,704@23664L30,706@23708L201,713@23923L27,715@23964L148,721@24126L30:TicketsShareScreens.kt#n9ob9m");
            SpacerKt.Spacer(SizeKt.m1476height3ABfNKs(Modifier.INSTANCE, Dp.m8748constructorimpl(30.0f)), composer, 6);
            TextKt.m3661TextNvy7gAk("票据传输", null, Color.INSTANCE.m5875getWhite0d7_KjU(), null, TextUnitKt.getSp(24), null, FontWeight.INSTANCE.getMedium(), null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer, 1597830, 0, 262058);
            SpacerKt.Spacer(SizeKt.m1476height3ABfNKs(Modifier.INSTANCE, Dp.m8748constructorimpl(8.0f)), composer, 6);
            TextKt.m3661TextNvy7gAk("请选择你要进行的操作", null, ColorKt.Color(4288059037L), null, TextUnitKt.getSp(14), null, null, null, 0L, null, TextAlign.m8619boximpl(TextAlign.INSTANCE.m8626getCentere0LSkKk()), 0L, 0, false, 0, 0, null, null, composer, 24966, 0, 261098);
            SpacerKt.Spacer(SizeKt.m1476height3ABfNKs(Modifier.INSTANCE, Dp.m8748constructorimpl(22.0f)), composer, 6);
            ProvidableCompositionLocal<Context> localContext = AndroidCompositionLocals_androidKt.getLocalContext();
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composer.consume(localContext);
            ComposerKt.sourceInformationMarkerEnd(composer);
            TransferChannelPicker((Context) objConsume, composer, 0);
            SpacerKt.Spacer(SizeKt.m1476height3ABfNKs(Modifier.INSTANCE, Dp.m8748constructorimpl(16.0f)), composer, 6);
            ShareActionButton("发送票据", "选择票据后，通过 NFC 或二维码发送给另一台设备", ComposableSingletons$TicketsShareScreensKt.INSTANCE.m9293getLambda$1283916181$app(), function0, composer, 438);
            SpacerKt.Spacer(SizeKt.m1476height3ABfNKs(Modifier.INSTANCE, Dp.m8748constructorimpl(10.0f)), composer, 6);
            ShareActionButton("接收票据", "通过 NFC 或二维码接收另一台设备分享的票据", ComposableSingletons$TicketsShareScreensKt.INSTANCE.m9294getLambda$1551871326$app(), function1, composer, 438);
            SpacerKt.Spacer(ColumnScope.weight$default(columnScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null), composer, 0);
            ShareOutlinedButton("返回", function2, SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), composer, 390, 0);
            SpacerKt.Spacer(SizeKt.m1476height3ABfNKs(Modifier.INSTANCE, Dp.m8748constructorimpl(24.0f)), composer, 6);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    static final Unit TicketReceiveMenuScreen$lambda$57(boolean z, Function0 function0, Function0 function1, Function0 function2, Modifier pageModifier, Composer composer, int i) {
        int i2;
        String str;
        Intrinsics.checkNotNullParameter(pageModifier, "pageModifier");
        ComposerKt.sourceInformation(composer, "CN(pageModifier)736@24406L1912:TicketsShareScreens.kt#n9ob9m");
        if ((i & 6) == 0) {
            i2 = i | (composer.changed(pageModifier) ? 4 : 2);
        } else {
            i2 = i;
        }
        if (!composer.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1310401359, i2, -1, "com.example.tickets.TicketReceiveMenuScreen.<anonymous> (TicketsShareScreens.kt:736)");
            }
            Modifier modifierM1425paddingVpY3zN4$default = PaddingKt.m1425paddingVpY3zN4$default(pageModifier, Dp.m8748constructorimpl(20.0f), 0.0f, 2, null);
            Alignment.Horizontal centerHorizontally = Alignment.INSTANCE.getCenterHorizontally();
            ComposerKt.sourceInformationMarkerStart(composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), centerHorizontally, composer, 48);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierM1425paddingVpY3zN4$default);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)410@16216L9:Composables.kt#9igjgp");
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor);
            } else {
                composer.useNode();
            }
            Composer composerM4937constructorimpl = Updater.m4937constructorimpl(composer);
            Updater.m4945setimpl(composerM4937constructorimpl, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m4945setimpl(composerM4937constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m4945setimpl(composerM4937constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m4943reconcileimpl(composerM4937constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m4945setimpl(composerM4937constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, -903098322, "C740@24566L30,742@24610L163,748@24786L29,749@24828L176,756@25018L30,758@25097L7,758@25062L43,760@25119L30,772@25491L190,779@25695L30,781@25739L322,792@26075L27,794@26116L148,800@26278L30:TicketsShareScreens.kt#n9ob9m");
            SpacerKt.Spacer(SizeKt.m1476height3ABfNKs(Modifier.INSTANCE, Dp.m8748constructorimpl(30.0f)), composer, 6);
            TextKt.m3661TextNvy7gAk("选择传输方式", null, Color.INSTANCE.m5875getWhite0d7_KjU(), null, TextUnitKt.getSp(24), null, FontWeight.INSTANCE.getMedium(), null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer, 1597830, 0, 262058);
            SpacerKt.Spacer(SizeKt.m1476height3ABfNKs(Modifier.INSTANCE, Dp.m8748constructorimpl(8.0f)), composer, 6);
            TextKt.m3661TextNvy7gAk("选择一种方式接收对方传输的票据", null, ColorKt.Color(4288059037L), null, TextUnitKt.getSp(14), null, null, null, 0L, null, TextAlign.m8619boximpl(TextAlign.INSTANCE.m8626getCentere0LSkKk()), 0L, 0, false, 0, 0, null, null, composer, 24966, 0, 261098);
            SpacerKt.Spacer(SizeKt.m1476height3ABfNKs(Modifier.INSTANCE, Dp.m8748constructorimpl(22.0f)), composer, 6);
            ProvidableCompositionLocal<Context> localContext = AndroidCompositionLocals_androidKt.getLocalContext();
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composer.consume(localContext);
            ComposerKt.sourceInformationMarkerEnd(composer);
            TransferChannelPicker((Context) objConsume, composer, 0);
            SpacerKt.Spacer(SizeKt.m1476height3ABfNKs(Modifier.INSTANCE, Dp.m8748constructorimpl(16.0f)), composer, 6);
            if (z) {
                composer.startReplaceGroup(-902533069);
                ComposerKt.sourceInformation(composer, "763@25199L217,769@25433L30");
                ShareActionButton("NFC一碰接收", "将手机靠近发送方，完成 NFC 握手后接收", ComposableSingletons$TicketsShareScreensKt.INSTANCE.getLambda$1769774684$app(), function0, composer, 438);
                SpacerKt.Spacer(SizeKt.m1476height3ABfNKs(Modifier.INSTANCE, Dp.m8748constructorimpl(10.0f)), composer, 6);
            } else {
                composer.startReplaceGroup(-927522789);
            }
            composer.endReplaceGroup();
            ShareActionButton("二维码接收", "扫描发送方二维码，建立安全分享连接", ComposableSingletons$TicketsShareScreensKt.INSTANCE.getLambda$11673793$app(), function1, composer, 438);
            SpacerKt.Spacer(SizeKt.m1476height3ABfNKs(Modifier.INSTANCE, Dp.m8748constructorimpl(20.0f)), composer, 6);
            if (z) {
                str = "NFC和二维码传输需双方应用版本均为5.5.0及以上";
            } else {
                str = "二维码传输需双方应用版本均为5.5.0及以上";
            }
            TextKt.m3661TextNvy7gAk(str, null, ColorKt.Color(4286085247L), null, TextUnitKt.getSp(12), null, null, null, 0L, null, TextAlign.m8619boximpl(TextAlign.INSTANCE.m8626getCentere0LSkKk()), 0L, 0, false, 0, 0, null, null, composer, 24960, 0, 261098);
            SpacerKt.Spacer(ColumnScope.weight$default(columnScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null), composer, 0);
            ShareOutlinedButton("返回", function2, SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), composer, 390, 0);
            SpacerKt.Spacer(SizeKt.m1476height3ABfNKs(Modifier.INSTANCE, Dp.m8748constructorimpl(24.0f)), composer, 6);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    static final Unit NfcShareScreen$lambda$90(TicketShareManager.UiState uiState, final List list, List list2, final Function1 function1, final Function0 function0, final MutableState mutableState, Modifier pageModifier, Composer composer, int i) {
        int i2;
        int i3;
        String str;
        Composer composer2 = composer;
        Intrinsics.checkNotNullParameter(pageModifier, "pageModifier");
        ComposerKt.sourceInformation(composer2, "CN(pageModifier)914@30732L3305:TicketsShareScreens.kt#n9ob9m");
        if ((i & 6) == 0) {
            i2 = i | (composer2.changed(pageModifier) ? 4 : 2);
        } else {
            i2 = i;
        }
        if (!composer2.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-789630404, i2, -1, "com.example.tickets.NfcShareScreen.<anonymous> (TicketsShareScreens.kt:914)");
            }
            Modifier modifierM1425paddingVpY3zN4$default = PaddingKt.m1425paddingVpY3zN4$default(pageModifier, Dp.m8748constructorimpl(22.0f), 0.0f, 2, null);
            Alignment.Horizontal centerHorizontally = Alignment.INSTANCE.getCenterHorizontally();
            ComposerKt.sourceInformationMarkerStart(composer2, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), centerHorizontally, composer2, 48);
            ComposerKt.sourceInformationMarkerStart(composer2, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer2, 0));
            CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer2, modifierM1425paddingVpY3zN4$default);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)410@16216L9:Composables.kt#9igjgp");
            if (!(composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer2.startReusableNode();
            if (composer2.getInserting()) {
                composer2.createNode(constructor);
            } else {
                composer2.useNode();
            }
            Composer composerM4937constructorimpl = Updater.m4937constructorimpl(composer2);
            Updater.m4945setimpl(composerM4937constructorimpl, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m4945setimpl(composerM4937constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m4945setimpl(composerM4937constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m4943reconcileimpl(composerM4937constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m4945setimpl(composerM4937constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer2, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer2, 481547690, "C957@32594L218,962@32849L202,968@33088L104,952@32313L893:TicketsShareScreens.kt#n9ob9m");
            boolean z = uiState.getState() == TicketShareManager.State.SCANNED || uiState.getState() == TicketShareManager.State.WAITING_SENDER_CONFIRM || uiState.getState() == TicketShareManager.State.WAITING_RECEIVER_CONFIRM || (NfcShareScreen$lambda$60(mutableState) && !list.isEmpty());
            boolean nfcContactDetected = uiState.getNfcContactDetected();
            if (!z) {
                composer2.startReplaceGroup(481914078);
                ComposerKt.sourceInformation(composer2, "931@31499L30,932@31546L217,938@31780L29,939@31826L412,949@32255L30");
                SpacerKt.Spacer(SizeKt.m1476height3ABfNKs(Modifier.INSTANCE, Dp.m8748constructorimpl(26.0f)), composer2, 6);
                i3 = 6;
                TextKt.m3661TextNvy7gAk(NfcShareScreen$lambda$60(mutableState) ? "NFC一碰接收" : "NFC一碰分享", null, Color.INSTANCE.m5875getWhite0d7_KjU(), null, TextUnitKt.getSp(24), null, FontWeight.INSTANCE.getMedium(), null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer, 1597824, 0, 262058);
                SpacerKt.Spacer(SizeKt.m1476height3ABfNKs(Modifier.INSTANCE, Dp.m8748constructorimpl(8.0f)), composer, 6);
                if (NfcShareScreen$lambda$60(mutableState)) {
                    str = "请将手机靠近发送方手机顶部的 NFC 感应区域";
                } else {
                    str = uiState.getState() == TicketShareManager.State.SCANNED ? "已感应到另一台设备" : "将两台手机靠近，完成 NFC 握手";
                }
                TextKt.m3661TextNvy7gAk(str, null, ColorKt.Color(4288059037L), null, TextUnitKt.getSp(14), null, null, null, 0L, null, TextAlign.m8619boximpl(TextAlign.INSTANCE.m8626getCentere0LSkKk()), 0L, 0, false, 0, 0, null, null, composer, 24960, 0, 261098);
                composer2 = composer;
                SpacerKt.Spacer(SizeKt.m1476height3ABfNKs(Modifier.INSTANCE, Dp.m8748constructorimpl(18.0f)), composer2, 6);
            } else {
                i3 = 6;
                composer2.startReplaceGroup(450658576);
            }
            composer2.endReplaceGroup();
            boolean zNfcShareScreen$lambda$60 = NfcShareScreen$lambda$60(mutableState);
            List list3 = NfcShareScreen$lambda$60(mutableState) ? list : list2;
            ComposerKt.sourceInformationMarkerStart(composer2, 708317292, "CC(remember):TicketsShareScreens.kt#9igjgp");
            Object objRememberedValue = composer2.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.example.tickets.TicketsShareScreensKt$$ExternalSyntheticLambda62
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return TicketsShareScreensKt.NfcShareScreen$lambda$90$lambda$89$lambda$81$lambda$80(mutableState);
                    }
                };
                composer2.updateRememberedValue(objRememberedValue);
            }
            Function0 function2 = (Function0) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerStart(composer2, 708325436, "CC(remember):TicketsShareScreens.kt#9igjgp");
            boolean zChangedInstance = composer2.changedInstance(list) | composer2.changed(function1);
            Object objRememberedValue2 = composer2.rememberedValue();
            if (zChangedInstance || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function0() { // from class: com.example.tickets.TicketsShareScreensKt$$ExternalSyntheticLambda63
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return TicketsShareScreensKt.NfcShareScreen$lambda$90$lambda$89$lambda$83$lambda$82(list, function1);
                    }
                };
                composer2.updateRememberedValue(objRememberedValue2);
            }
            Function0 function3 = (Function0) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerStart(composer2, 708332986, "CC(remember):TicketsShareScreens.kt#9igjgp");
            boolean zChanged = composer2.changed(function0);
            Object objRememberedValue3 = composer2.rememberedValue();
            if (zChanged || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = new Function0() { // from class: com.example.tickets.TicketsShareScreensKt$$ExternalSyntheticLambda64
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return TicketsShareScreensKt.NfcShareScreen$lambda$90$lambda$89$lambda$85$lambda$84(function0);
                    }
                };
                composer2.updateRememberedValue(objRememberedValue3);
            }
            Function0 function4 = (Function0) objRememberedValue3;
            ComposerKt.sourceInformationMarkerEnd(composer2);
            boolean z2 = z;
            NfcShareAnimatedArtwork(z2, nfcContactDetected, zNfcShareScreen$lambda$60, list3, function2, function3, function4, composer2, 24576);
            if (!z2) {
                composer2.startReplaceGroup(483661889);
                ComposerKt.sourceInformation(composer2, "975@33262L30,976@33309L143,977@33469L27,980@33632L32,978@33513L225,983@33755L30,984@33802L164,989@33983L30");
                SpacerKt.Spacer(SizeKt.m1476height3ABfNKs(Modifier.INSTANCE, Dp.m8748constructorimpl(20.0f)), composer2, i3);
                String message = uiState.getMessage();
                if (StringsKt.isBlank(message)) {
                    message = "等待设备";
                }
                TextKt.m3661TextNvy7gAk(message, SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Color.INSTANCE.m5875getWhite0d7_KjU(), null, TextUnitKt.getSp(15), null, null, null, 0L, null, TextAlign.m8619boximpl(TextAlign.INSTANCE.m8626getCentere0LSkKk()), 0L, 0, false, 0, 0, null, null, composer, 25008, 0, 261096);
                SpacerKt.Spacer(ColumnScope.weight$default(columnScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null), composer, 0);
                String str2 = NfcShareScreen$lambda$60(mutableState) ? "切换为发送方" : "我是接收方";
                ComposerKt.sourceInformationMarkerStart(composer, 708350322, "CC(remember):TicketsShareScreens.kt#9igjgp");
                Object objRememberedValue4 = composer.rememberedValue();
                if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue4 = new Function0() { // from class: com.example.tickets.TicketsShareScreensKt$$ExternalSyntheticLambda65
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return TicketsShareScreensKt.NfcShareScreen$lambda$90$lambda$89$lambda$88$lambda$87(mutableState);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue4);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                ShareOutlinedButton(str2, (Function0) objRememberedValue4, SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), composer, 432, 0);
                composer2 = composer;
                SpacerKt.Spacer(SizeKt.m1476height3ABfNKs(Modifier.INSTANCE, Dp.m8748constructorimpl(10.0f)), composer2, 6);
                ShareOutlinedButton("返回", function0, SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), composer2, 390, 0);
                SpacerKt.Spacer(SizeKt.m1476height3ABfNKs(Modifier.INSTANCE, Dp.m8748constructorimpl(24.0f)), composer2, 6);
            } else {
                composer2.startReplaceGroup(450658576);
            }
            composer2.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    static final Unit QrShareScreen$lambda$140(TicketShareManager.UiState uiState, List list, MutableState mutableState, final List list2, final Context context, final Function0 function0, final MutableState mutableState2, final Function1 function1, final MutableState mutableState3, Modifier pageModifier, Composer composer, int i) {
        int i2;
        int i3;
        final MutableState mutableState4;
        int i4;
        int i5;
        Intrinsics.checkNotNullParameter(pageModifier, "pageModifier");
        ComposerKt.sourceInformation(composer, "CN(pageModifier)1056@36102L6243:TicketsShareScreens.kt#n9ob9m");
        if ((i & 6) == 0) {
            i2 = i | (composer.changed(pageModifier) ? 4 : 2);
        } else {
            i2 = i;
        }
        if (!composer.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(634564690, i2, -1, "com.example.tickets.QrShareScreen.<anonymous> (TicketsShareScreens.kt:1056)");
            }
            Modifier modifierM1425paddingVpY3zN4$default = PaddingKt.m1425paddingVpY3zN4$default(pageModifier, Dp.m8748constructorimpl(22.0f), 0.0f, 2, null);
            Alignment.Horizontal centerHorizontally = Alignment.INSTANCE.getCenterHorizontally();
            ComposerKt.sourceInformationMarkerStart(composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), centerHorizontally, composer, 48);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierM1425paddingVpY3zN4$default);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)410@16216L9:Composables.kt#9igjgp");
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor);
            } else {
                composer.useNode();
            }
            Composer composerM4937constructorimpl = Updater.m4937constructorimpl(composer);
            Updater.m4945setimpl(composerM4937constructorimpl, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m4945setimpl(composerM4937constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m4945setimpl(composerM4937constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m4943reconcileimpl(composerM4937constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m4945setimpl(composerM4937constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, 1499681279, "C1061@36279L30,1062@36322L193,1068@36528L29,1069@36570L222,1075@36805L30,1182@41833L27,1185@41990L32,1183@41873L215,1188@42101L30,1189@42144L148,1194@42305L30:TicketsShareScreens.kt#n9ob9m");
            SpacerKt.Spacer(SizeKt.m1476height3ABfNKs(Modifier.INSTANCE, Dp.m8748constructorimpl(26.0f)), composer, 6);
            TextKt.m3661TextNvy7gAk(QrShareScreen$lambda$93(mutableState2) ? "二维码接收" : "二维码分享", null, Color.INSTANCE.m5875getWhite0d7_KjU(), null, TextUnitKt.getSp(24), null, FontWeight.INSTANCE.getMedium(), null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer, 1597824, 0, 262058);
            SpacerKt.Spacer(SizeKt.m1476height3ABfNKs(Modifier.INSTANCE, Dp.m8748constructorimpl(8.0f)), composer, 6);
            TextKt.m3661TextNvy7gAk(QrShareScreen$lambda$93(mutableState2) ? "扫描发送方的 Tickets 二维码" : "让对方扫描二维码，随后由你确认发送", null, ColorKt.Color(4287664279L), null, TextUnitKt.getSp(14), null, null, null, 0L, null, TextAlign.m8619boximpl(TextAlign.INSTANCE.m8626getCentere0LSkKk()), 0L, 0, false, 0, 0, null, null, composer, 24960, 0, 261098);
            Composer composer2 = composer;
            SpacerKt.Spacer(SizeKt.m1476height3ABfNKs(Modifier.INSTANCE, Dp.m8748constructorimpl(26.0f)), composer2, 6);
            String str = "CC(remember):TicketsShareScreens.kt#9igjgp";
            if (!QrShareScreen$lambda$93(mutableState2)) {
                composer2.startReplaceGroup(1500136172);
                ComposerKt.sourceInformation(composer2, "");
                if (uiState.getState() == TicketShareManager.State.SCANNED && !list.isEmpty()) {
                    composer2.startReplaceGroup(1500187198);
                    ComposerKt.sourceInformation(composer2, "1079@36985L448");
                    Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                    Alignment center = Alignment.INSTANCE.getCenter();
                    ComposerKt.sourceInformationMarkerStart(composer2, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
                    ComposerKt.sourceInformationMarkerStart(composer2, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
                    int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer2, 0));
                    CompositionLocalMap currentCompositionLocalMap2 = composer2.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer2, modifierFillMaxSize$default);
                    Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                    ComposerKt.sourceInformationMarkerStart(composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)410@16216L9:Composables.kt#9igjgp");
                    if (!(composer2.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composer2.startReusableNode();
                    if (composer2.getInserting()) {
                        composer2.createNode(constructor2);
                    } else {
                        composer2.useNode();
                    }
                    Composer composerM4937constructorimpl2 = Updater.m4937constructorimpl(composer2);
                    Updater.m4945setimpl(composerM4937constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m4945setimpl(composerM4937constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Updater.m4945setimpl(composerM4937constructorimpl2, Integer.valueOf(iHashCode2), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                    Updater.m4943reconcileimpl(composerM4937constructorimpl2, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                    Updater.m4945setimpl(composerM4937constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composer2, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composer2, 1518275301, "C1085@37259L43,1086@37343L42,1083@37157L254:TicketsShareScreens.kt#n9ob9m");
                    ComposerKt.sourceInformationMarkerStart(composer2, -505209653, "CC(remember):TicketsShareScreens.kt#9igjgp");
                    Object objRememberedValue = composer2.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new Function0() { // from class: com.example.tickets.TicketsShareScreensKt$$ExternalSyntheticLambda27
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return TicketsShareScreensKt.QrShareScreen$lambda$140$lambda$139$lambda$120$lambda$117$lambda$116();
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue);
                    }
                    Function0 function2 = (Function0) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerStart(composer2, -505206966, "CC(remember):TicketsShareScreens.kt#9igjgp");
                    Object objRememberedValue2 = composer2.rememberedValue();
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = new Function0() { // from class: com.example.tickets.TicketsShareScreensKt$$ExternalSyntheticLambda28
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return TicketsShareScreensKt.QrShareScreen$lambda$140$lambda$139$lambda$120$lambda$119$lambda$118();
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue2);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    NfcSwipeSendCard(list, function2, (Function0) objRememberedValue2, composer2, 432);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    composer2.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    composer2.endReplaceGroup();
                    i4 = 0;
                    str = "CC(remember):TicketsShareScreens.kt#9igjgp";
                } else {
                    i4 = 0;
                    composer2.startReplaceGroup(1500701767);
                    ComposerKt.sourceInformation(composer2, "1090@37492L68,1102@38117L30");
                    String str2 = (String) mutableState.getValue();
                    ComposerKt.sourceInformationMarkerStart(composer2, 741146304, "CC(remember):TicketsShareScreens.kt#9igjgp");
                    boolean zChanged = composer2.changed(str2);
                    Object objRememberedValue3 = composer2.rememberedValue();
                    if (zChanged || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue3 = generateShareQrBitmap((String) mutableState.getValue());
                        composer2.updateRememberedValue(objRememberedValue3);
                    }
                    Bitmap bitmap = (Bitmap) objRememberedValue3;
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    if (bitmap != null) {
                        composer2.startReplaceGroup(1500820311);
                        ComposerKt.sourceInformation(composer2, "1092@37627L447");
                        i5 = 1;
                        ImageKt.m714Image5hnEew(AndroidImageBitmap_androidKt.asImageBitmap(bitmap), "票据分享二维码", PaddingKt.m1423padding3ABfNKs(BackgroundKt.m647backgroundbw27NRU(SizeKt.m1490size3ABfNKs(Modifier.INSTANCE, Dp.m8748constructorimpl(270.0f)), Color.INSTANCE.m5875getWhite0d7_KjU(), RoundedCornerShapeKt.m1756RoundedCornerShape0680j_4(Dp.m8748constructorimpl(20.0f))), Dp.m8748constructorimpl(18.0f)), null, ContentScale.INSTANCE.getFillBounds(), 0.0f, null, 0, composer, 24624, 232);
                        composer2 = composer;
                    } else {
                        i5 = 1;
                        composer2.startReplaceGroup(1463503782);
                    }
                    composer2.endReplaceGroup();
                    SpacerKt.Spacer(SizeKt.m1476height3ABfNKs(Modifier.INSTANCE, Dp.m8748constructorimpl(22.0f)), composer2, 6);
                    int i6 = WhenMappings.$EnumSwitchMapping$2[uiState.getState().ordinal()];
                    if (i6 == i5 || i6 == 2 || i6 == 3) {
                        composer2.startReplaceGroup(1501585174);
                        ComposerKt.sourceInformation(composer2, "1107@38413L88");
                        TextKt.m3661TextNvy7gAk(uiState.getMessage(), null, Color.INSTANCE.m5875getWhite0d7_KjU(), null, TextUnitKt.getSp(15), null, null, null, 0L, null, TextAlign.m8619boximpl(TextAlign.INSTANCE.m8626getCentere0LSkKk()), 0L, 0, false, 0, 0, null, null, composer, 24960, 0, 261098);
                        composer2 = composer;
                        composer2.endReplaceGroup();
                        Unit unit = Unit.INSTANCE;
                    } else {
                        composer2.startReplaceGroup(1501760510);
                        ComposerKt.sourceInformation(composer2, "1110@38590L80");
                        String message = uiState.getMessage();
                        if (StringsKt.isBlank(message)) {
                            message = "等待对方扫描…";
                        }
                        TextKt.m3661TextNvy7gAk(message, null, Color.INSTANCE.m5875getWhite0d7_KjU(), null, TextUnitKt.getSp(15), null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer, 24960, 0, 262122);
                        composer2 = composer;
                        composer2.endReplaceGroup();
                        Unit unit2 = Unit.INSTANCE;
                    }
                    composer2.endReplaceGroup();
                }
                composer2.endReplaceGroup();
                i3 = i4;
            } else {
                str = "CC(remember):TicketsShareScreens.kt#9igjgp";
                composer2.startReplaceGroup(1502045679);
                ComposerKt.sourceInformation(composer2, "");
                if (!list2.isEmpty()) {
                    composer2.startReplaceGroup(1502085855);
                    ComposerKt.sourceInformation(composer2, "1119@38943L744");
                    Modifier modifierM1383offsetVpY3zN4$default = OffsetKt.m1383offsetVpY3zN4$default(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), 0.0f, Dp.m8748constructorimpl(-80.0f), 1, null);
                    Alignment center2 = Alignment.INSTANCE.getCenter();
                    ComposerKt.sourceInformationMarkerStart(composer2, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(center2, false);
                    ComposerKt.sourceInformationMarkerStart(composer2, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
                    int iHashCode3 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer2, 0));
                    CompositionLocalMap currentCompositionLocalMap3 = composer2.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composer2, modifierM1383offsetVpY3zN4$default);
                    Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                    ComposerKt.sourceInformationMarkerStart(composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)410@16216L9:Composables.kt#9igjgp");
                    if (!(composer2.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composer2.startReusableNode();
                    if (composer2.getInserting()) {
                        composer2.createNode(constructor3);
                    } else {
                        composer2.useNode();
                    }
                    Composer composerM4937constructorimpl3 = Updater.m4937constructorimpl(composer2);
                    Updater.m4945setimpl(composerM4937constructorimpl3, measurePolicyMaybeCachedBoxMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m4945setimpl(composerM4937constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Updater.m4945setimpl(composerM4937constructorimpl3, Integer.valueOf(iHashCode3), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                    Updater.m4943reconcileimpl(composerM4937constructorimpl3, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                    Updater.m4945setimpl(composerM4937constructorimpl3, modifierMaterializeModifier3, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composer2, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composer2, 1999137397, "C1127@39299L159,1131@39499L140,1125@39194L471:TicketsShareScreens.kt#n9ob9m");
                    ComposerKt.sourceInformationMarkerStart(composer2, -1043887306, str);
                    boolean zChanged2 = composer2.changed(function1) | composer2.changedInstance(list2);
                    Object objRememberedValue4 = composer2.rememberedValue();
                    if (zChanged2 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue4 = new Function0() { // from class: com.example.tickets.TicketsShareScreensKt$$ExternalSyntheticLambda29
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return TicketsShareScreensKt.QrShareScreen$lambda$140$lambda$139$lambda$127$lambda$124$lambda$123(function1, list2);
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue4);
                    }
                    Function0 function3 = (Function0) objRememberedValue4;
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerStart(composer2, -1043880925, str);
                    boolean zChanged3 = composer2.changed(function0);
                    Object objRememberedValue5 = composer2.rememberedValue();
                    if (zChanged3 || objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue5 = new Function0() { // from class: com.example.tickets.TicketsShareScreensKt$$ExternalSyntheticLambda30
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return TicketsShareScreensKt.QrShareScreen$lambda$140$lambda$139$lambda$127$lambda$126$lambda$125(function0);
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue5);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    QrReceivePopCard(list2, function3, (Function0) objRememberedValue5, composer2, 0);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    composer2.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    composer2.endReplaceGroup();
                } else {
                    if (QrShareScreen$lambda$96(mutableState3)) {
                        composer2.startReplaceGroup(1502944090);
                        ComposerKt.sourceInformation(composer2, "1139@39804L669,1153@40509L26,1138@39753L804");
                        ComposerKt.sourceInformationMarkerStart(composer2, 741220889, str);
                        boolean zChangedInstance = composer2.changedInstance(context);
                        Object objRememberedValue6 = composer2.rememberedValue();
                        if (zChangedInstance || objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                            mutableState4 = mutableState3;
                            objRememberedValue6 = new Function1() { // from class: com.example.tickets.TicketsShareScreensKt$$ExternalSyntheticLambda31
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return TicketsShareScreensKt.QrShareScreen$lambda$140$lambda$139$lambda$129$lambda$128(context, mutableState4, (String) obj);
                                }
                            };
                            composer2.updateRememberedValue(objRememberedValue6);
                        } else {
                            mutableState4 = mutableState3;
                        }
                        Function1 function4 = (Function1) objRememberedValue6;
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerStart(composer2, 741242806, str);
                        Object objRememberedValue7 = composer2.rememberedValue();
                        if (objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue7 = new Function0() { // from class: com.example.tickets.TicketsShareScreensKt$$ExternalSyntheticLambda32
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return TicketsShareScreensKt.QrShareScreen$lambda$140$lambda$139$lambda$131$lambda$130(mutableState4);
                                }
                            };
                            composer2.updateRememberedValue(objRememberedValue7);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        QrScannerPanel(function4, (Function0) objRememberedValue7, composer2, 48);
                        composer2.endReplaceGroup();
                    } else {
                        composer2.startReplaceGroup(1503799070);
                        ComposerKt.sourceInformation(composer2, "1156@40603L1184");
                        Alignment.Horizontal centerHorizontally2 = Alignment.INSTANCE.getCenterHorizontally();
                        ComposerKt.sourceInformationMarkerStart(composer2, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                        Modifier.Companion companion = Modifier.INSTANCE;
                        MeasurePolicy measurePolicyColumnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), centerHorizontally2, composer2, 48);
                        ComposerKt.sourceInformationMarkerStart(composer2, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
                        int iHashCode4 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer2, 0));
                        CompositionLocalMap currentCompositionLocalMap4 = composer2.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composer2, companion);
                        Function0<ComposeUiNode> constructor4 = ComposeUiNode.INSTANCE.getConstructor();
                        ComposerKt.sourceInformationMarkerStart(composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)410@16216L9:Composables.kt#9igjgp");
                        if (!(composer2.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composer2.startReusableNode();
                        if (composer2.getInserting()) {
                            composer2.createNode(constructor4);
                        } else {
                            composer2.useNode();
                        }
                        Composer composerM4937constructorimpl4 = Updater.m4937constructorimpl(composer2);
                        Updater.m4945setimpl(composerM4937constructorimpl4, measurePolicyColumnMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m4945setimpl(composerM4937constructorimpl4, currentCompositionLocalMap4, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Updater.m4945setimpl(composerM4937constructorimpl4, Integer.valueOf(iHashCode4), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                        Updater.m4943reconcileimpl(composerM4937constructorimpl4, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                        Updater.m4945setimpl(composerM4937constructorimpl4, modifierMaterializeModifier4, ComposeUiNode.INSTANCE.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(composer2, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                        ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composer2, -1151935024, "C1157@40688L493,1166@41206L30,1167@41261L206,1172@41492L30,1175@41650L25,1173@41547L218:TicketsShareScreens.kt#n9ob9m");
                        Modifier modifierM647backgroundbw27NRU = BackgroundKt.m647backgroundbw27NRU(BorderKt.m659borderxT4_qwU(SizeKt.m1490size3ABfNKs(Modifier.INSTANCE, Dp.m8748constructorimpl(270.0f)), Dp.m8748constructorimpl(1.0f), Color.m5837copywmQWz5c$default(Color.INSTANCE.m5875getWhite0d7_KjU(), 0.08f, 0.0f, 0.0f, 0.0f, 14, null), RoundedCornerShapeKt.m1756RoundedCornerShape0680j_4(Dp.m8748constructorimpl(24.0f))), ColorKt.Color(4279374356L), RoundedCornerShapeKt.m1756RoundedCornerShape0680j_4(Dp.m8748constructorimpl(24.0f)));
                        Alignment center3 = Alignment.INSTANCE.getCenter();
                        ComposerKt.sourceInformationMarkerStart(composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(center3, false);
                        ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
                        int iHashCode5 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
                        CompositionLocalMap currentCompositionLocalMap5 = composer.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier5 = ComposedModifierKt.materializeModifier(composer, modifierM647backgroundbw27NRU);
                        Function0<ComposeUiNode> constructor5 = ComposeUiNode.INSTANCE.getConstructor();
                        ComposerKt.sourceInformationMarkerStart(composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)410@16216L9:Composables.kt#9igjgp");
                        if (!(composer.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composer.startReusableNode();
                        if (composer.getInserting()) {
                            composer.createNode(constructor5);
                        } else {
                            composer.useNode();
                        }
                        Composer composerM4937constructorimpl5 = Updater.m4937constructorimpl(composer);
                        Updater.m4945setimpl(composerM4937constructorimpl5, measurePolicyMaybeCachedBoxMeasurePolicy3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m4945setimpl(composerM4937constructorimpl5, currentCompositionLocalMap5, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Updater.m4945setimpl(composerM4937constructorimpl5, Integer.valueOf(iHashCode5), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                        Updater.m4943reconcileimpl(composerM4937constructorimpl5, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                        Updater.m4945setimpl(composerM4937constructorimpl5, modifierMaterializeModifier5, ComposeUiNode.INSTANCE.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(composer, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                        BoxScopeInstance boxScopeInstance3 = BoxScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composer, -2041885032, "C1164@41104L51:TicketsShareScreens.kt#n9ob9m");
                        i3 = 0;
                        TextKt.m3661TextNvy7gAk("扫码接收", null, Color.INSTANCE.m5875getWhite0d7_KjU(), null, TextUnitKt.getSp(20), null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer, 24966, 0, 262122);
                        ComposerKt.sourceInformationMarkerEnd(composer);
                        ComposerKt.sourceInformationMarkerEnd(composer);
                        composer.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composer);
                        ComposerKt.sourceInformationMarkerEnd(composer);
                        ComposerKt.sourceInformationMarkerEnd(composer);
                        SpacerKt.Spacer(SizeKt.m1476height3ABfNKs(Modifier.INSTANCE, Dp.m8748constructorimpl(20.0f)), composer, 6);
                        String message2 = uiState.getMessage();
                        if (StringsKt.isBlank(message2)) {
                            message2 = "点击下面按钮开始扫描";
                        }
                        TextKt.m3661TextNvy7gAk(message2, null, ColorKt.Color(4287401107L), null, TextUnitKt.getSp(14), null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer, 24960, 0, 262122);
                        composer2 = composer;
                        SpacerKt.Spacer(SizeKt.m1476height3ABfNKs(Modifier.INSTANCE, Dp.m8748constructorimpl(20.0f)), composer2, 6);
                        ComposerKt.sourceInformationMarkerStart(composer2, 1486891191, str);
                        Object objRememberedValue8 = composer2.rememberedValue();
                        if (objRememberedValue8 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue8 = new Function0() { // from class: com.example.tickets.TicketsShareScreensKt$$ExternalSyntheticLambda34
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return TicketsShareScreensKt.QrShareScreen$lambda$140$lambda$139$lambda$136$lambda$135$lambda$134(mutableState3);
                                }
                            };
                            composer2.updateRememberedValue(objRememberedValue8);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ShareOutlinedButton("扫描二维码", (Function0) objRememberedValue8, SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), composer2, 438, 0);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        composer2.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        composer2.endReplaceGroup();
                    }
                    composer2.endReplaceGroup();
                }
                i3 = 0;
                composer2.endReplaceGroup();
            }
            SpacerKt.Spacer(ColumnScope.weight$default(columnScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null), composer2, i3);
            String str3 = QrShareScreen$lambda$93(mutableState2) ? "切换为发送方" : "我是接收方，扫描二维码";
            ComposerKt.sourceInformationMarkerStart(composer2, 741290204, str);
            Object objRememberedValue9 = composer2.rememberedValue();
            if (objRememberedValue9 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue9 = new Function0() { // from class: com.example.tickets.TicketsShareScreensKt$$ExternalSyntheticLambda35
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return TicketsShareScreensKt.QrShareScreen$lambda$140$lambda$139$lambda$138$lambda$137(mutableState2);
                    }
                };
                composer2.updateRememberedValue(objRememberedValue9);
            }
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ShareOutlinedButton(str3, (Function0) objRememberedValue9, SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), composer2, 432, 0);
            SpacerKt.Spacer(SizeKt.m1476height3ABfNKs(Modifier.INSTANCE, Dp.m8748constructorimpl(10.0f)), composer2, 6);
            ShareOutlinedButton("返回", function0, SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), composer2, 390, 0);
            SpacerKt.Spacer(SizeKt.m1476height3ABfNKs(Modifier.INSTANCE, Dp.m8748constructorimpl(24.0f)), composer2, 6);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    static final Unit NfcSwipeSendCard$lambda$181$lambda$170$lambda$169(float f, GraphicsLayerScope graphicsLayer) {
        Intrinsics.checkNotNullParameter(graphicsLayer, "$this$graphicsLayer");
        graphicsLayer.setTranslationY(graphicsLayer.mo803toPx0680j_4(Dp.m8748constructorimpl(((-170.0f) * f) - ((85.0f * f) * f))));
        float f2 = 1.0f - (0.38f * f);
        graphicsLayer.setScaleX(f2);
        graphicsLayer.setScaleY(f2);
        graphicsLayer.setAlpha(1.0f - (RangesKt.coerceIn((f - 0.58f) / 0.42f, 0.0f, 1.0f) * 0.95f));
        return Unit.INSTANCE;
    }

    static final Unit QrReceivePopCard$lambda$205$lambda$198$lambda$197(float f, float f2, MutableState mutableState, MutableState mutableState2, GraphicsLayerScope graphicsLayer) {
        float f3;
        Intrinsics.checkNotNullParameter(graphicsLayer, "$this$graphicsLayer");
        graphicsLayer.setTranslationY(graphicsLayer.mo803toPx0680j_4(Dp.m8748constructorimpl(((235.0f * f) - 235.0f) + (10.0f * f * f))));
        float f4 = (0.66f * f) + 0.34f;
        graphicsLayer.setScaleX(f4);
        graphicsLayer.setScaleY(f4);
        graphicsLayer.setAlpha(f);
        if (QrReceivePopCard$lambda$186(mutableState)) {
            float f5 = 1.0f - (0.45f * f2);
            graphicsLayer.setScaleX(graphicsLayer.getScaleX() * f5);
            graphicsLayer.setScaleY(graphicsLayer.getScaleY() * f5);
            graphicsLayer.setAlpha(graphicsLayer.getAlpha() * (1.0f - f2));
            float translationY = graphicsLayer.getTranslationY();
            if (QrReceivePopCard$lambda$189(mutableState2)) {
                f3 = graphicsLayer.mo803toPx0680j_4(Dp.m8748constructorimpl(f2 * (-180.0f)));
            } else {
                f3 = graphicsLayer.mo803toPx0680j_4(Dp.m8748constructorimpl(f2 * 65.0f));
            }
            graphicsLayer.setTranslationY(translationY + f3);
        }
        return Unit.INSTANCE;
    }

    private static final float NfcShareAnimatedArtwork$lambda$218(State<Float> state) {
        return state.getValue().floatValue();
    }

    static final Unit NfcShareAnimatedArtwork$lambda$228$lambda$225$lambda$224$lambda$223(float f, float f2, DrawScope Canvas) {
        long j;
        long j2;
        int i;
        Intrinsics.checkNotNullParameter(Canvas, "$this$Canvas");
        float f3 = Canvas.mo803toPx0680j_4(Dp.m8748constructorimpl(112.0f));
        float f4 = Canvas.mo803toPx0680j_4(Dp.m8748constructorimpl(128.0f));
        float f5 = Canvas.mo803toPx0680j_4(Dp.m8748constructorimpl(22.0f));
        float f6 = Canvas.mo803toPx0680j_4(Dp.m8748constructorimpl(3.0f));
        float fIntBitsToFloat = Float.intBitsToFloat((int) (Canvas.mo6437getSizeNHjbRc() >> 32)) / 2.0f;
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (Canvas.mo6437getSizeNHjbRc() & 4294967295L)) / 2.0f;
        float f7 = (fIntBitsToFloat2 - f4) - (Canvas.mo803toPx0680j_4(Dp.m8748constructorimpl(28.0f)) * (1.0f - f));
        float f8 = fIntBitsToFloat - (f3 / 2.0f);
        Stroke stroke = new Stroke(f6, 0.0f, 0, 0, null, 30, null);
        Path Path = AndroidPath_androidKt.Path();
        Path.moveTo(f8, f7);
        float f9 = f7 + f4;
        float f10 = f9 - f5;
        Path.lineTo(f8, f10);
        float f11 = f8 + f5;
        Path.quadraticTo(f8, f9, f11, f9);
        float f12 = f3 + f8;
        float f13 = f12 - f5;
        Path.lineTo(f13, f9);
        Path.quadraticTo(f12, f9, f12, f10);
        Path.lineTo(f12, f7);
        Path Path2 = AndroidPath_androidKt.Path();
        float f14 = f4 + fIntBitsToFloat2;
        Path2.moveTo(f8, f14);
        float f15 = f5 + fIntBitsToFloat2;
        Path2.lineTo(f8, f15);
        Path2.quadraticTo(f8, fIntBitsToFloat2, f11, fIntBitsToFloat2);
        Path2.lineTo(f13, fIntBitsToFloat2);
        Path2.quadraticTo(f12, fIntBitsToFloat2, f12, f15);
        Path2.lineTo(f12, f14);
        Stroke stroke2 = stroke;
        DrawScope.m6427drawPathLG529CI$default(Canvas, Path, Color.m5837copywmQWz5c$default(Color.INSTANCE.m5875getWhite0d7_KjU(), 0.92f, 0.0f, 0.0f, 0.0f, 14, null), 0.0f, stroke2, null, 0, 52, null);
        DrawScope drawScope = Canvas;
        DrawScope.m6427drawPathLG529CI$default(drawScope, Path2, Color.m5837copywmQWz5c$default(Color.INSTANCE.m5875getWhite0d7_KjU(), 0.92f, 0.0f, 0.0f, 0.0f, 14, null), 0.0f, stroke2, null, 0, 52, null);
        long jM5559constructorimpl = Offset.m5559constructorimpl((((long) Float.floatToRawIntBits(fIntBitsToFloat)) << 32) | (((long) Float.floatToRawIntBits(f9 - drawScope.mo803toPx0680j_4(Dp.m8748constructorimpl(15.0f)))) & 4294967295L));
        long jM5559constructorimpl2 = Offset.m5559constructorimpl((((long) Float.floatToRawIntBits(fIntBitsToFloat)) << 32) | (((long) Float.floatToRawIntBits(drawScope.mo803toPx0680j_4(Dp.m8748constructorimpl(15.0f)) + fIntBitsToFloat2)) & 4294967295L));
        DrawScope.m6418drawCircleVaOC9Bg$default(drawScope, Color.m5837copywmQWz5c$default(Color.INSTANCE.m5875getWhite0d7_KjU(), 0.96f, 0.0f, 0.0f, 0.0f, 14, null), drawScope.mo803toPx0680j_4(Dp.m8748constructorimpl(3.6f)), jM5559constructorimpl, 0.0f, null, null, 0, 120, null);
        long j3 = jM5559constructorimpl;
        DrawScope.m6418drawCircleVaOC9Bg$default(drawScope, Color.m5837copywmQWz5c$default(Color.INSTANCE.m5875getWhite0d7_KjU(), 0.96f, 0.0f, 0.0f, 0.0f, 14, null), drawScope.mo803toPx0680j_4(Dp.m8748constructorimpl(3.6f)), jM5559constructorimpl2, 0.0f, null, null, 0, 120, null);
        if (f > 0.98f && f2 > 0.0f) {
            int i2 = 0;
            while (i2 < 4) {
                float f16 = i2;
                float fCoerceIn = RangesKt.coerceIn((1.18f * f2) - (0.22f * f16), 0.0f, 1.0f);
                if (fCoerceIn > 0.0f) {
                    float f17 = drawScope.mo803toPx0680j_4(Dp.m8748constructorimpl((((8.0f * f16) + 24.0f) * fCoerceIn) + 7.0f));
                    float fCoerceAtLeast = RangesKt.coerceAtLeast((1.0f - fCoerceIn) * (0.46f - (0.075f * f16)), 0.0f);
                    float f18 = 1.7f - (f16 * 0.18f);
                    long j4 = j3;
                    i = i2;
                    DrawScope.m6418drawCircleVaOC9Bg$default(drawScope, Color.m5837copywmQWz5c$default(Color.INSTANCE.m5875getWhite0d7_KjU(), fCoerceAtLeast, 0.0f, 0.0f, 0.0f, 14, null), f17, j4, 0.0f, new Stroke(drawScope.mo803toPx0680j_4(Dp.m8748constructorimpl(f18)), 0.0f, 0, 0, null, 30, null), null, 0, LocationRequestCompat.QUALITY_LOW_POWER, null);
                    j2 = j4;
                    j = jM5559constructorimpl2;
                    DrawScope.m6418drawCircleVaOC9Bg$default(drawScope, Color.m5837copywmQWz5c$default(Color.INSTANCE.m5875getWhite0d7_KjU(), fCoerceAtLeast, 0.0f, 0.0f, 0.0f, 14, null), f17, j, 0.0f, new Stroke(drawScope.mo803toPx0680j_4(Dp.m8748constructorimpl(f18)), 0.0f, 0, 0, null, 30, null), null, 0, LocationRequestCompat.QUALITY_LOW_POWER, null);
                } else {
                    j = jM5559constructorimpl2;
                    j2 = j3;
                    i = i2;
                }
                i2 = i + 1;
                drawScope = Canvas;
                jM5559constructorimpl2 = j;
                j3 = j2;
            }
        }
        return Unit.INSTANCE;
    }

    private static final float ColorOsSendTicketFlight$lambda$243(State<Float> state) {
        return state.getValue().floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float ColorOsSendTicketFlight$lambda$244(State<Float> state) {
        return state.getValue().floatValue();
    }

    private static final float ColorOsReceiveTicketArrival$lambda$255(State<Float> state) {
        return state.getValue().floatValue();
    }

    private static final float ColorOsReceiveTicketArrival$lambda$257(State<Float> state) {
        return state.getValue().floatValue();
    }

    static final Unit ColorOsReceiveTicketArrival$lambda$273$lambda$268$lambda$267(float f, float f2, float f3, float f4, float f5, float f6, float f7, MutableState mutableState, GraphicsLayerScope graphicsLayer) {
        Intrinsics.checkNotNullParameter(graphicsLayer, "$this$graphicsLayer");
        graphicsLayer.setTranslationY(graphicsLayer.mo803toPx0680j_4(Dp.m8748constructorimpl(f)) - (graphicsLayer.mo803toPx0680j_4(Dp.m8748constructorimpl(25.0f)) * (1.0f - f2)));
        float f8 = f3 * f4;
        graphicsLayer.setScaleX(f8);
        graphicsLayer.setScaleY(f8);
        graphicsLayer.setRotationX(f5);
        graphicsLayer.setRotationY(f6);
        graphicsLayer.setCameraDistance(graphicsLayer.get_density() * 38.0f);
        graphicsLayer.setAlpha(1.0f - f7);
        if (ColorOsReceiveTicketArrival$lambda$259(mutableState)) {
            graphicsLayer.setTranslationY(graphicsLayer.getTranslationY() + (graphicsLayer.mo803toPx0680j_4(Dp.m8748constructorimpl(110.0f)) * f7));
        }
        return Unit.INSTANCE;
    }

    private static final float LiquidFusionTransferGlow$lambda$275(State<Float> state) {
        return state.getValue().floatValue();
    }

    static final Unit NfcMiniArtwork$lambda$292$lambda$291$lambda$290(boolean z, DrawScope Canvas) {
        Intrinsics.checkNotNullParameter(Canvas, "$this$Canvas");
        float f = Canvas.mo803toPx0680j_4(Dp.m8748constructorimpl(26.0f));
        float f2 = Canvas.mo803toPx0680j_4(Dp.m8748constructorimpl(50.0f));
        float f3 = Canvas.mo803toPx0680j_4(Dp.m8748constructorimpl(9.0f));
        float fIntBitsToFloat = (Float.intBitsToFloat((int) (Canvas.mo6437getSizeNHjbRc() >> 32)) - ((f * 2.0f) + f3)) / 2.0f;
        float fIntBitsToFloat2 = (Float.intBitsToFloat((int) (Canvas.mo6437getSizeNHjbRc() & 4294967295L)) - f2) / 2.0f;
        Stroke stroke = new Stroke(Canvas.mo803toPx0680j_4(Dp.m8748constructorimpl(2.2f)), 0.0f, 0, 0, null, 30, null);
        if (z) {
            long jM5837copywmQWz5c$default = Color.m5837copywmQWz5c$default(Color.INSTANCE.m5875getWhite0d7_KjU(), 0.85f, 0.0f, 0.0f, 0.0f, 14, null);
            long jM5559constructorimpl = Offset.m5559constructorimpl((((long) Float.floatToRawIntBits(fIntBitsToFloat)) << 32) | (((long) Float.floatToRawIntBits(fIntBitsToFloat2)) & 4294967295L));
            long jM5627constructorimpl = Size.m5627constructorimpl((((long) Float.floatToRawIntBits(f)) << 32) | (((long) Float.floatToRawIntBits(f2)) & 4294967295L));
            float f4 = Canvas.mo803toPx0680j_4(Dp.m8748constructorimpl(8.0f));
            Stroke stroke2 = stroke;
            DrawScope.m6433drawRoundRectuAw5IA$default(Canvas, jM5837copywmQWz5c$default, jM5559constructorimpl, jM5627constructorimpl, CornerRadius.m5521constructorimpl((((long) Float.floatToRawIntBits(Canvas.mo803toPx0680j_4(Dp.m8748constructorimpl(8.0f)))) & 4294967295L) | (Float.floatToRawIntBits(f4) << 32)), stroke2, 0.0f, null, 0, 224, null);
            long jM5837copywmQWz5c$default2 = Color.m5837copywmQWz5c$default(Color.INSTANCE.m5875getWhite0d7_KjU(), 0.85f, 0.0f, 0.0f, 0.0f, 14, null);
            long jM5559constructorimpl2 = Offset.m5559constructorimpl((((long) Float.floatToRawIntBits((fIntBitsToFloat + f) + f3)) << 32) | (((long) Float.floatToRawIntBits(fIntBitsToFloat2)) & 4294967295L));
            long jM5627constructorimpl2 = Size.m5627constructorimpl((((long) Float.floatToRawIntBits(f)) << 32) | (((long) Float.floatToRawIntBits(f2)) & 4294967295L));
            float f5 = Canvas.mo803toPx0680j_4(Dp.m8748constructorimpl(8.0f));
            DrawScope.m6433drawRoundRectuAw5IA$default(Canvas, jM5837copywmQWz5c$default2, jM5559constructorimpl2, jM5627constructorimpl2, CornerRadius.m5521constructorimpl((((long) Float.floatToRawIntBits(Canvas.mo803toPx0680j_4(Dp.m8748constructorimpl(8.0f)))) & 4294967295L) | (Float.floatToRawIntBits(f5) << 32)), stroke2, 0.0f, null, 0, 224, null);
        } else {
            long jM5837copywmQWz5c$default3 = Color.m5837copywmQWz5c$default(Color.INSTANCE.m5875getWhite0d7_KjU(), 0.85f, 0.0f, 0.0f, 0.0f, 14, null);
            long jM5559constructorimpl3 = Offset.m5559constructorimpl((((long) Float.floatToRawIntBits(fIntBitsToFloat + Canvas.mo803toPx0680j_4(Dp.m8748constructorimpl(3.0f)))) << 32) | (((long) Float.floatToRawIntBits(fIntBitsToFloat2)) & 4294967295L));
            long jM5627constructorimpl3 = Size.m5627constructorimpl((((long) Float.floatToRawIntBits(f)) << 32) | (((long) Float.floatToRawIntBits(f2)) & 4294967295L));
            float f6 = Canvas.mo803toPx0680j_4(Dp.m8748constructorimpl(8.0f));
            Stroke stroke3 = stroke;
            DrawScope.m6433drawRoundRectuAw5IA$default(Canvas, jM5837copywmQWz5c$default3, jM5559constructorimpl3, jM5627constructorimpl3, CornerRadius.m5521constructorimpl((((long) Float.floatToRawIntBits(Canvas.mo803toPx0680j_4(Dp.m8748constructorimpl(8.0f)))) & 4294967295L) | (Float.floatToRawIntBits(f6) << 32)), stroke3, 0.0f, null, 0, 224, null);
            long jM5837copywmQWz5c$default4 = Color.m5837copywmQWz5c$default(Color.INSTANCE.m5875getWhite0d7_KjU(), 0.85f, 0.0f, 0.0f, 0.0f, 14, null);
            long jM5559constructorimpl4 = Offset.m5559constructorimpl((((long) Float.floatToRawIntBits(((fIntBitsToFloat + f) + f3) - Canvas.mo803toPx0680j_4(Dp.m8748constructorimpl(3.0f)))) << 32) | (((long) Float.floatToRawIntBits(fIntBitsToFloat2)) & 4294967295L));
            long jM5627constructorimpl4 = Size.m5627constructorimpl((((long) Float.floatToRawIntBits(f)) << 32) | (((long) Float.floatToRawIntBits(f2)) & 4294967295L));
            float f7 = Canvas.mo803toPx0680j_4(Dp.m8748constructorimpl(8.0f));
            DrawScope.m6433drawRoundRectuAw5IA$default(Canvas, jM5837copywmQWz5c$default4, jM5559constructorimpl4, jM5627constructorimpl4, CornerRadius.m5521constructorimpl((((long) Float.floatToRawIntBits(Canvas.mo803toPx0680j_4(Dp.m8748constructorimpl(8.0f)))) & 4294967295L) | (Float.floatToRawIntBits(f7) << 32)), stroke3, 0.0f, null, 0, 224, null);
            long jM5837copywmQWz5c$default5 = Color.m5837copywmQWz5c$default(Color.INSTANCE.m5875getWhite0d7_KjU(), 0.55f, 0.0f, 0.0f, 0.0f, 14, null);
            float fIntBitsToFloat3 = Float.intBitsToFloat((int) (Canvas.mo6437getSizeNHjbRc() >> 32)) * 0.44f;
            DrawScope.m6423drawLineNGM6Ib0$default(Canvas, jM5837copywmQWz5c$default5, Offset.m5559constructorimpl((((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (Canvas.mo6437getSizeNHjbRc() & 4294967295L)) * 0.48f)) & 4294967295L) | (Float.floatToRawIntBits(fIntBitsToFloat3) << 32)), Offset.m5559constructorimpl((((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (Canvas.mo6437getSizeNHjbRc() >> 32)) * 0.56f)) << 32) | (((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (Canvas.mo6437getSizeNHjbRc() & 4294967295L)) * 0.48f)) & 4294967295L)), Canvas.mo803toPx0680j_4(Dp.m8748constructorimpl(2.0f)), StrokeCap.INSTANCE.m6236getRoundKaPHkGw(), null, 0.0f, null, 0, WindowSizeClass.HEIGHT_DP_MEDIUM_LOWER_BOUND, null);
        }
        return Unit.INSTANCE;
    }
}
