package com.example.tickets;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.autofill.HintConstants;
import androidx.camera.video.AudioStats;
import androidx.compose.foundation.style.StylePropertiesKt;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import com.google.android.gms.actions.SearchIntents;
import com.google.android.gms.nearby.connection.ConnectionsStatusCodes;
import com.google.firebase.messaging.Constants;
import com.google.mlkit.common.MlKitException;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import java.util.zip.ZipFile;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.io.CloseableKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequenceScope;
import kotlin.sequences.SequencesKt;
import kotlin.text.CharsKt;
import kotlin.text.Charsets;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlin.text.Typography;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: GlobalSubwayData.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000ê\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0017\n\u0002\u0010\u0011\n\u0002\b\u0017\bÇ\u0002\u0018\u00002\u00020\u0001:\u001eð\u0001ñ\u0001ò\u0001ó\u0001ô\u0001õ\u0001ö\u0001÷\u0001ø\u0001ù\u0001ú\u0001û\u0001ü\u0001ý\u0001þ\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JZ\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\u00052\u0006\u0010$\u001a\u00020\u00052\u0006\u0010%\u001a\u00020\u00052\b\b\u0002\u0010&\u001a\u00020\u00052\b\b\u0002\u0010'\u001a\u00020\u00052\b\b\u0002\u0010(\u001a\u00020)2\b\b\u0002\u0010*\u001a\u00020\u00052\b\b\u0002\u0010+\u001a\u00020\u0005H\u0002J>\u0010,\u001a\u00020 2\u0006\u0010\"\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\u00052\u0006\u0010$\u001a\u00020\u00052\u0006\u0010-\u001a\u00020\u00052\u0006\u0010.\u001a\u00020\u00052\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\f0\u0017H\u0002J\f\u00100\u001a\b\u0012\u0004\u0012\u00020 0\u001fJ\f\u00101\u001a\b\u0012\u0004\u0012\u00020 0\u001fJ\f\u00102\u001a\b\u0012\u0004\u0012\u00020 0\u001fJ\u0010\u00103\u001a\u0004\u0018\u00010 2\u0006\u00104\u001a\u00020\u0005J\u000e\u00105\u001a\u00020\u00052\u0006\u00104\u001a\u00020\u0005J6\u00106\u001a\b\u0012\u0004\u0012\u0002070\u001f2\u0006\u00108\u001a\u0002092\u0006\u00104\u001a\u00020\u00052\u0006\u0010:\u001a\u00020\u00052\b\b\u0002\u0010;\u001a\u00020\fH\u0086@¢\u0006\u0002\u0010<J'\u0010=\u001a\u00020\u00052\u0006\u00104\u001a\u00020\u00052\u0006\u0010>\u001a\u00020\u00052\b\b\u0002\u0010?\u001a\u00020\u0005H\u0000¢\u0006\u0002\b@J\u0010\u0010A\u001a\u00020\u00052\u0006\u0010B\u001a\u00020\u0005H\u0002J/\u0010C\u001a\u00020\u00052\u0006\u0010D\u001a\u00020\u001b2\u0006\u0010E\u001a\u00020\u00052\u0006\u0010F\u001a\u00020\u00052\b\u0010G\u001a\u0004\u0018\u00010\u0005H\u0000¢\u0006\u0002\bHJ8\u0010I\u001a\u00020\u00052\u0006\u00108\u001a\u0002092\u0006\u00104\u001a\u00020\u00052\u0006\u0010E\u001a\u00020\u00052\u0006\u0010J\u001a\u00020\u00052\u0006\u0010K\u001a\u00020\u0005H\u0080@¢\u0006\u0004\bL\u0010MJ+\u0010N\u001a\b\u0012\u0004\u0012\u00020\u00050\u001f2\u0006\u0010D\u001a\u00020\u001b2\u0006\u0010O\u001a\u00020\u00052\u0006\u0010P\u001a\u00020\u0005H\u0000¢\u0006\u0002\bQJ \u0010R\u001a\u00020S2\u0006\u00108\u001a\u0002092\u0006\u0010T\u001a\u00020SH\u0080@¢\u0006\u0004\bU\u0010VJ0\u0010W\u001a\u0004\u0018\u00010X2\u0006\u00108\u001a\u0002092\u0006\u00104\u001a\u00020\u00052\u0006\u0010Y\u001a\u00020\u00052\u0006\u0010Z\u001a\u00020\u0005H\u0086@¢\u0006\u0002\u0010[J \u0010\\\u001a\u0004\u0018\u00010\u001b2\u0006\u00108\u001a\u0002092\u0006\u00104\u001a\u00020\u0005H\u0082@¢\u0006\u0002\u0010]J>\u0010^\u001a\b\u0012\u0004\u0012\u00020_0\u001f2\u0006\u00108\u001a\u0002092\u000e\b\u0002\u0010`\u001a\b\u0012\u0004\u0012\u00020\u00050\u00172\u000e\b\u0002\u0010a\u001a\b\u0012\u0004\u0012\u00020\u00050\u0017H\u0080@¢\u0006\u0004\bb\u0010cJ\u0010\u0010g\u001a\u00020\u00052\u0006\u00108\u001a\u000209H\u0002J.\u0010h\u001a\b\u0012\u0004\u0012\u0002070\u001f2\u0006\u00108\u001a\u0002092\u0006\u0010!\u001a\u00020 2\u0006\u0010:\u001a\u00020\u00052\u0006\u0010;\u001a\u00020\fH\u0002J4\u0010i\u001a\b\u0012\u0004\u0012\u0002070\u001f2\u0006\u00108\u001a\u0002092\u0006\u0010!\u001a\u00020 2\u0006\u0010:\u001a\u00020\u00052\u0006\u0010;\u001a\u00020\fH\u0082@¢\u0006\u0002\u0010jJ>\u0010k\u001a\b\u0012\u0004\u0012\u0002070\u001f2\u0006\u00108\u001a\u0002092\u0006\u0010!\u001a\u00020 2\u0006\u0010l\u001a\u00020m2\u0006\u0010n\u001a\u00020m2\b\b\u0002\u0010o\u001a\u00020mH\u0082@¢\u0006\u0002\u0010pJ\u001e\u0010q\u001a\b\u0012\u0004\u0012\u0002070\u001f2\u0006\u0010!\u001a\u00020 2\u0006\u0010r\u001a\u00020sH\u0002J*\u0010t\u001a\u0004\u0018\u00010X2\u0006\u00108\u001a\u0002092\u0006\u0010!\u001a\u00020 2\u0006\u0010u\u001a\u00020\u00052\u0006\u0010v\u001a\u00020\u0005H\u0002J0\u0010w\u001a\u0004\u0018\u00010X2\u0006\u00108\u001a\u0002092\u0006\u0010!\u001a\u00020 2\u0006\u0010u\u001a\u00020\u00052\u0006\u0010v\u001a\u00020\u0005H\u0082@¢\u0006\u0002\u0010xJ\"\u0010y\u001a\u0004\u0018\u0001072\u0006\u00108\u001a\u0002092\u0006\u0010!\u001a\u00020 2\u0006\u0010z\u001a\u00020\u0005H\u0002J \u0010{\u001a\u00020|2\u0006\u0010!\u001a\u00020 2\u0006\u0010}\u001a\u00020s2\u0006\u0010~\u001a\u00020\u007fH\u0002J\u001f\u0010\u0080\u0001\u001a\u000f\u0012\u0004\u0012\u00020m\u0012\u0004\u0012\u00020m0\u0081\u00012\u0007\u0010\u0082\u0001\u001a\u00020sH\u0002J#\u0010\u0083\u0001\u001a\u00030\u0084\u00012\u000e\u0010\u0085\u0001\u001a\t\u0012\u0004\u0012\u00020|0\u0086\u00012\u0007\u0010\u0087\u0001\u001a\u00020|H\u0002J8\u0010\u0088\u0001\u001a\u00020s2\u0007\u0010\u0089\u0001\u001a\u00020\u00052\u0007\u0010\u008a\u0001\u001a\u00020\u00052\u0007\u0010\u008b\u0001\u001a\u00020\u00052\u0007\u0010\u008c\u0001\u001a\u00020s2\t\b\u0002\u0010\u008d\u0001\u001a\u00020\u0005H\u0002J\u001a\u0010\u008e\u0001\u001a\u0004\u0018\u00010\f2\u0007\u0010\u008f\u0001\u001a\u00020\u0005H\u0002¢\u0006\u0003\u0010\u0090\u0001J\u0019\u0010\u0091\u0001\u001a\t\u0012\u0005\u0012\u00030\u0092\u00010\u001f2\u0007\u0010\u0093\u0001\u001a\u00020\u0005H\u0002J)\u0010\u0094\u0001\u001a\u00020m2\u0006\u0010l\u001a\u00020m2\u0006\u0010n\u001a\u00020m2\u000e\u0010\u0095\u0001\u001a\t\u0012\u0005\u0012\u00030\u0092\u00010\u001fH\u0002J@\u0010\u0096\u0001\u001a\b\u0012\u0004\u0012\u0002070\u001f2\u0006\u00108\u001a\u0002092\u0006\u0010!\u001a\u00020 2\u0006\u0010l\u001a\u00020m2\u0006\u0010n\u001a\u00020m2\u0006\u0010o\u001a\u00020mH\u0080@¢\u0006\u0005\b\u0097\u0001\u0010pJ\u0010\u0010\u0098\u0001\u001a\u00030\u0084\u00012\u0006\u00108\u001a\u000209J\u001f\u0010\u0099\u0001\u001a\u00020\u001b2\u0006\u00108\u001a\u0002092\u0006\u00104\u001a\u00020\u0005H\u0000¢\u0006\u0003\b\u009a\u0001J\u0019\u0010\u009b\u0001\u001a\u00020\u001b2\u0006\u00108\u001a\u0002092\u0006\u0010!\u001a\u00020 H\u0002J\u0019\u0010\u009c\u0001\u001a\u00020\u001b2\u0006\u00108\u001a\u0002092\u0006\u0010!\u001a\u00020 H\u0002J\u0013\u0010\u009d\u0001\u001a\u00020s2\b\u0010\u009e\u0001\u001a\u00030\u009f\u0001H\u0002J\u001d\u0010 \u0001\u001a\u00030\u0084\u00012\b\u0010\u009e\u0001\u001a\u00030\u009f\u00012\u0007\u0010¡\u0001\u001a\u00020sH\u0002J\u0019\u0010¢\u0001\u001a\u00020\u001b2\u0006\u00108\u001a\u0002092\u0006\u0010!\u001a\u00020 H\u0002J\u0019\u0010£\u0001\u001a\u00020\u001b2\u0006\u00104\u001a\u00020\u00052\u0006\u0010D\u001a\u00020\u001bH\u0002J\u0019\u0010¤\u0001\u001a\u0004\u0018\u00010\f2\u0006\u0010>\u001a\u00020\u0005H\u0002¢\u0006\u0003\u0010\u0090\u0001J\u001d\u0010¥\u0001\u001a\u00030\u0084\u00012\u0007\u0010\u0089\u0001\u001a\u00020\u00052\b\u0010¦\u0001\u001a\u00030\u009f\u0001H\u0002J\u001b\u0010§\u0001\u001a\u00020\u001b2\u0006\u0010!\u001a\u00020 2\b\u0010¨\u0001\u001a\u00030\u009f\u0001H\u0002JA\u0010©\u0001\u001a\u0017\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010ª\u00012\u0006\u00104\u001a\u00020\u00052\u0007\u0010«\u0001\u001a\u00020\u00052\u0007\u0010¬\u0001\u001a\u00020\u00052\u0007\u0010\u00ad\u0001\u001a\u00020\u0005H\u0002J0\u0010®\u0001\u001a\u0016\u0012\u0011\u0012\u000f\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050°\u00010¯\u00012\b\u0010±\u0001\u001a\u00030²\u00012\u0007\u0010³\u0001\u001a\u00020\u0005H\u0002J\u0018\u0010´\u0001\u001a\b\u0012\u0004\u0012\u00020\u00050\u001f2\u0007\u0010µ\u0001\u001a\u00020\u0005H\u0002J\u001a\u0010¶\u0001\u001a\u0004\u0018\u00010\f2\u0007\u0010\u008f\u0001\u001a\u00020\u0005H\u0002¢\u0006\u0003\u0010\u0090\u0001J\u0011\u0010·\u0001\u001a\u00020\u001b2\u0006\u0010!\u001a\u00020 H\u0002J\u001a\u0010¸\u0001\u001a\u00020\u001b2\u0006\u0010!\u001a\u00020 2\u0007\u0010¹\u0001\u001a\u00020\u0005H\u0002J+\u0010»\u0001\u001a\u0004\u0018\u00010X2\u0006\u0010D\u001a\u00020\u001b2\u0006\u00104\u001a\u00020\u00052\u0006\u0010Y\u001a\u00020\u00052\u0006\u0010Z\u001a\u00020\u0005H\u0002J,\u0010¼\u0001\u001a\u000b\u0012\u0005\u0012\u00030½\u0001\u0018\u00010\u001f2\u0006\u0010D\u001a\u00020\u001b2\u0007\u0010¾\u0001\u001a\u00020\u00052\u0007\u0010¿\u0001\u001a\u00020\u0005H\u0002J5\u0010À\u0001\u001a\u0004\u0018\u00010X2\u0006\u0010D\u001a\u00020\u001b2\u0006\u00104\u001a\u00020\u00052\u0006\u0010?\u001a\u00020\u00052\u0007\u0010Á\u0001\u001a\u00020\u00052\u0007\u0010Â\u0001\u001a\u00020\u0005H\u0002J-\u0010Ã\u0001\u001a\u0004\u0018\u00010\u00052\u0006\u0010D\u001a\u00020\u001b2\u0006\u00104\u001a\u00020\u00052\u0007\u0010Ä\u0001\u001a\u00020\u00052\u0007\u0010Å\u0001\u001a\u00020\u0005H\u0002J7\u0010Æ\u0001\u001a\u0004\u0018\u00010\u00052\u0006\u0010D\u001a\u00020\u001b2\u0007\u0010Ä\u0001\u001a\u00020\u00052\u0007\u0010Å\u0001\u001a\u00020\u00052\u0007\u0010Á\u0001\u001a\u00020\u00052\u0007\u0010Â\u0001\u001a\u00020\u0005H\u0002J(\u0010Ç\u0001\u001a\b\u0012\u0004\u0012\u00020\u00050\u00172\u0006\u0010D\u001a\u00020\u001b2\u0006\u0010?\u001a\u00020\u00052\u0007\u0010È\u0001\u001a\u00020\u0005H\u0002J3\u0010É\u0001\u001a\u0004\u0018\u00010\f2\u0006\u0010D\u001a\u00020\u001b2\u0006\u0010?\u001a\u00020\u00052\u0007\u0010È\u0001\u001a\u00020\u00052\u0007\u0010Ê\u0001\u001a\u00020\u0005H\u0002¢\u0006\u0003\u0010Ë\u0001J1\u0010Ì\u0001\u001a\b\u0012\u0004\u0012\u00020|0\u001f2\u0006\u0010D\u001a\u00020\u001b2\u0006\u0010?\u001a\u00020\u00052\u0007\u0010Á\u0001\u001a\u00020\u00052\u0007\u0010Â\u0001\u001a\u00020\u0005H\u0002J#\u0010Í\u0001\u001a\u0004\u0018\u00010|2\u0006\u0010D\u001a\u00020\u001b2\u0006\u0010O\u001a\u00020\u00052\u0006\u0010?\u001a\u00020\u0005H\u0002J\u001b\u0010Î\u0001\u001a\u0004\u0018\u00010\u00052\u0006\u0010D\u001a\u00020\u001b2\u0006\u0010z\u001a\u00020\u0005H\u0002J\u001c\u0010Ï\u0001\u001a\u00030Ð\u00012\u0007\u0010\u0087\u0001\u001a\u0002072\u0007\u0010Ñ\u0001\u001a\u00020\u0005H\u0002J\u0011\u0010Ò\u0001\u001a\u00020\u00052\u0006\u0010B\u001a\u00020\u0005H\u0002J\u0013\u0010Ó\u0001\u001a\u00020\u001b2\b\u0010\u009e\u0001\u001a\u00030\u009f\u0001H\u0002J\u001c\u0010Ô\u0001\u001a\u00030\u0084\u00012\b\u0010\u009e\u0001\u001a\u00030\u009f\u00012\u0006\u0010D\u001a\u00020\u001bH\u0002J\u0011\u0010Õ\u0001\u001a\u00020s2\u0006\u0010D\u001a\u00020\u001bH\u0002J\u0011\u0010Ö\u0001\u001a\u00020\u001b2\u0006\u0010r\u001a\u00020sH\u0002J\u0012\u0010×\u0001\u001a\u00020\u00052\u0007\u0010\u0089\u0001\u001a\u00020\u0005H\u0002J>\u0010Ø\u0001\u001a\u00020\f2\u0006\u00104\u001a\u00020\u00052\u0006\u0010>\u001a\u00020\u00052\u0007\u0010Ù\u0001\u001a\u00020\u00052\u0007\u0010Ú\u0001\u001a\u00020\f2\u000b\b\u0002\u0010Û\u0001\u001a\u0004\u0018\u00010\fH\u0002¢\u0006\u0003\u0010Ü\u0001J*\u0010Ý\u0001\u001a\u00020\f2\u0006\u00104\u001a\u00020\u00052\u0006\u0010>\u001a\u00020\u00052\u0006\u0010?\u001a\u00020\u00052\u0007\u0010Û\u0001\u001a\u00020\fH\u0002J\u0019\u0010Þ\u0001\u001a\u00020\u001b2\u0006\u00104\u001a\u00020\u00052\u0006\u0010D\u001a\u00020\u001bH\u0002J\u0011\u0010ß\u0001\u001a\u00020\u001b2\u0006\u0010D\u001a\u00020\u001bH\u0002J\u0019\u0010à\u0001\u001a\u00020\u001b2\u0006\u00104\u001a\u00020\u00052\u0006\u0010D\u001a\u00020\u001bH\u0002J\u0011\u0010á\u0001\u001a\u00020\u00052\u0006\u0010B\u001a\u00020\u0005H\u0002J\u0011\u0010â\u0001\u001a\u00020\f2\u0006\u0010B\u001a\u00020\u0005H\u0002J\r\u0010ã\u0001\u001a\u00020\f*\u00020\fH\u0002J\u0011\u0010ä\u0001\u001a\u00020\u00052\u0006\u0010B\u001a\u00020\u0005H\u0002J\u0011\u0010å\u0001\u001a\u00020\u00052\u0006\u0010B\u001a\u00020\u0005H\u0002J%\u0010æ\u0001\u001a\u00020\u00052\u0014\u0010ç\u0001\u001a\u000b\u0012\u0006\b\u0001\u0012\u00020\u00050è\u0001\"\u00020\u0005H\u0002¢\u0006\u0003\u0010é\u0001J!\u0010ê\u0001\u001a\u0011\u0012\u0004\u0012\u00020m\u0012\u0004\u0012\u00020m\u0018\u00010\u0081\u00012\u0007\u0010\u008f\u0001\u001a\u00020\u0005H\u0002J-\u0010ë\u0001\u001a\u00020m2\u0007\u0010ì\u0001\u001a\u00020m2\u0007\u0010í\u0001\u001a\u00020m2\u0007\u0010î\u0001\u001a\u00020m2\u0007\u0010ï\u0001\u001a\u00020mH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00050\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u001b0\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u001d0\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010d\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010e\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000f\u0010º\u0001\u001a\u00020\fX\u0082T¢\u0006\u0002\n\u0000¨\u0006ÿ\u0001"}, d2 = {"Lcom/example/tickets/GlobalSubwayDataManager;", "", "<init>", "()V", "PREFS_NAME", "", "PREF_ACTIVE_CITY", "PREF_LAST_BUILD", "CACHE_FILE_NAME", "STATIC_REFRESH_MS", "", "FALLBACK_ROUTE_COLOR", "", "MAX_SEARCH_RESULTS", "LOCAL_US_ASSET_PREFIX", "LOCAL_US_FILE_DIR", "LOCAL_US_REFRESH_MS", "US_TRANSIT_SERVER_BASE_URL", "US_SERVER_PATTERN_CACHE_MS", "TAIWAN_TRANSIT_WORKER_BASE_URL", "TAIWAN_CACHE_DIR", "TAIWAN_REFRESH_MS", "SERVER_PATTERN_US_CITY_IDS", "", "cacheLock", "memoryIndexes", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/example/tickets/GlobalSubwayDataManager$StaticIndex;", "usServerPatternCaches", "Lcom/example/tickets/GlobalSubwayDataManager$UsServerPatternCache;", "cityCatalog", "", "Lcom/example/tickets/GlobalSubwayDataManager$SubwayCity;", "city", "id", "nameZh", "nameEn", "country", "code", "slug", "sourceType", "Lcom/example/tickets/GlobalSubwayDataManager$SourceType;", "sourceUrl", "localAssetPath", "localUsCity", "assetPath", "staticGtfsUrl", "gtfsRouteTypes", "allCities", "chinaCities", "americanCities", "cityOrNull", "cityId", "cityName", "searchStations", "Lcom/example/tickets/GlobalSubwayDataManager$SubwayStationOption;", "context", "Landroid/content/Context;", SearchIntents.EXTRA_QUERY, "limit", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "displayLineBadgeName", "shortName", "routeId", "displayLineBadgeName$app", "normalizedRouteToken", "value", "previousPhysicalStationFromIndex", "index", "lineName", "currentKey", "nextKey", "previousPhysicalStationFromIndex$app", "previousPhysicalStationForRoute", "currentStation", "nextStation", "previousPhysicalStationForRoute$app", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "currentStationTransferOptions", "stationKey", "activeRouteId", "currentStationTransferOptions$app", "prepareTrip", "Lcom/example/tickets/SmartSubwayTrip;", "trip", "prepareTrip$app", "(Landroid/content/Context;Lcom/example/tickets/SmartSubwayTrip;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resolveRoutePlan", "Lcom/example/tickets/GlobalSubwayDataManager$SubwayRoutePlan;", "origin", "destination", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadUsServerRoutingIndex", "(Landroid/content/Context;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchNycRealtimeOverlay", "Lcom/example/tickets/GlobalSubwayDataManager$NycRealtimeOverlay;", "routeIds", "stationKeys", "fetchNycRealtimeOverlay$app", "(Landroid/content/Context;Ljava/util/Set;Ljava/util/Set;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "GOOGLE_PLACES_SEARCH_URL", "GOOGLE_PLACES_NEARBY_URL", "GOOGLE_ROUTES_URL", "requireGoogleApiKey", "googleSearchStationsBlocking", "googleSearchStations", "(Landroid/content/Context;Lcom/example/tickets/GlobalSubwayDataManager$SubwayCity;Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "googleNearbyStations", "latitude", "", "longitude", "radiusMeters", "(Landroid/content/Context;Lcom/example/tickets/GlobalSubwayDataManager$SubwayCity;DDDLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "parseGooglePlacesStations", "root", "Lorg/json/JSONObject;", "googleResolvePlanBlocking", "originName", "destinationName", "googleResolvePlan", "(Landroid/content/Context;Lcom/example/tickets/GlobalSubwayDataManager$SubwayCity;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "googleFindStationBlocking", "input", "googleTransitStopToStation", "Lcom/example/tickets/GlobalSubwayDataManager$SubwayRouteStation;", "stop", "routeInfo", "Lcom/example/tickets/GlobalSubwayDataManager$SubwayRouteInfo;", "googleRouteLocation", "Lkotlin/Pair;", "stopOrLocation", "addUniqueRouteStation", "", "list", "", "station", "googlePostJson", "urlString", "apiKey", "fieldMask", "body", "apiKeyHeader", "parseHexColor", "raw", "(Ljava/lang/String;)Ljava/lang/Integer;", "decodeEncodedPolyline", "Lcom/example/tickets/GlobalSubwayDataManager$RoutePoint;", "encoded", "nearestDistanceToRoute", "path", "searchNearbyGoogleStations", "searchNearbyGoogleStations$app", "clearCurrentCache", "loadOrBuildIndex", "loadOrBuildIndex$app", "buildIndexForCity", "loadTaiwanRemoteIndex", "loadGzipJson", "file", "Ljava/io/File;", "saveJsonGzip", "json", "loadLocalUsIndex", "normalizeLocalUsIndex", "nycSubwayRouteColor", "downloadBinary", "target", "parseGtfsStaticZip", "zipFile", "canonicalUsRouteIdentity", "Lkotlin/Triple;", "rawRouteId", "rawShortName", "rawLongName", "readGtfsRows", "Lkotlin/sequences/Sequence;", "", "zip", "Ljava/util/zip/ZipFile;", "fileName", "parseCsvLine", "line", "parseGtfsRouteColor", "buildAmapIndex", "parseAmapJson", "text", "MAX_ROUTE_TRANSFERS", "resolvePlan", "findBestRoutePath", "Lcom/example/tickets/GlobalSubwayDataManager$RouteSearchState;", "originKey", "destinationKey", "routeForPair", Constants.MessagePayloadKeys.FROM, "to", "preferredTransferStationKey", "primaryId", "secondaryId", "findTransferStation", "reachableAlongRoute", "anchor", "stationDistanceAlongRoute", "candidate", "(Lcom/example/tickets/GlobalSubwayDataManager$StaticIndex;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Integer;", "stationsForRouteRange", "routeStation", "resolveStationKey", "stationNameMatchesSearch", "", "normalizedQuery", "normalizeStationSearch", "loadIndex", "saveIndex", "toJson", "fromJson", "downloadText", "routeColor", "routeCode", "seed", "sourceColor", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/Integer;)I", "canonicalLineColor", "applyCanonicalLineColors", "normalizeStaticIndexTopology", "sanitizeWuhanRouteTopology", "extractNumericLine", "stableHash", "absoluteValue", "normalizeLineName", "normalizeSearch", "firstNonBlank", "values", "", "([Ljava/lang/String;)Ljava/lang/String;", "parseCoordinatePair", "distanceMeters", "lat1", "lon1", "lat2", "lon2", "SourceType", "SubwayCity", "SubwayRouteInfo", "SubwayStationOption", "SubwayRouteStation", "SubwayRoutePlan", "RoutePoint", "NycRealtimeOverlay", "UsServerPatternCache", "StaticIndex", "LocalUsDataConfig", "GoogleMapsConfig", "RouteSearchState", "RouteSearchScore", "RouteQueueNode", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class GlobalSubwayDataManager {
    public static final int $stable;
    private static final String CACHE_FILE_NAME = "global_subway_current_v2.bin.gz";
    private static final int FALLBACK_ROUTE_COLOR = -10841643;
    private static final String GOOGLE_PLACES_NEARBY_URL = "https://places.googleapis.com/v1/places:searchNearby";
    private static final String GOOGLE_PLACES_SEARCH_URL = "https://places.googleapis.com/v1/places:searchText";
    private static final String GOOGLE_ROUTES_URL = "https://routes.googleapis.com/directions/v2:computeRoutes";
    public static final GlobalSubwayDataManager INSTANCE;
    private static final String LOCAL_US_ASSET_PREFIX = "subway/us/";
    private static final String LOCAL_US_FILE_DIR = "subway/us";
    private static final long LOCAL_US_REFRESH_MS = 604800000;
    private static final int MAX_ROUTE_TRANSFERS = 6;
    private static final int MAX_SEARCH_RESULTS = 12;
    private static final String PREFS_NAME = "global_subway_data";
    private static final String PREF_ACTIVE_CITY = "active_city_id";
    private static final String PREF_LAST_BUILD = "last_build_time";
    private static final Set<String> SERVER_PATTERN_US_CITY_IDS;
    private static final long STATIC_REFRESH_MS = 604800000;
    private static final String TAIWAN_CACHE_DIR = "subway/taiwan";
    private static final long TAIWAN_REFRESH_MS = 604800000;
    private static final String TAIWAN_TRANSIT_WORKER_BASE_URL = "https://tickets-us-transit.hyl120309.workers.dev";
    private static final long US_SERVER_PATTERN_CACHE_MS = 600000;
    private static final String US_TRANSIT_SERVER_BASE_URL = "https://tickets-us-transit.hyl120309.workers.dev";
    private static final Object cacheLock;
    private static final List<SubwayCity> cityCatalog;
    private static final ConcurrentHashMap<String, StaticIndex> memoryIndexes;
    private static final ConcurrentHashMap<String, UsServerPatternCache> usServerPatternCaches;

    /* JADX INFO: compiled from: GlobalSubwayData.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/example/tickets/GlobalSubwayDataManager$SourceType;", "", "<init>", "(Ljava/lang/String;I)V", "AMAP", "GOOGLE", "LOCAL_US", "TAIWAN_TDX", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public enum SourceType {
        AMAP,
        GOOGLE,
        LOCAL_US,
        TAIWAN_TDX;

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

        public static EnumEntries<SourceType> getEntries() {
            return $ENTRIES;
        }
    }

    /* JADX INFO: compiled from: GlobalSubwayData.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SourceType.values().length];
            try {
                iArr[SourceType.AMAP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SourceType.GOOGLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[SourceType.LOCAL_US.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[SourceType.TAIWAN_TDX.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private GlobalSubwayDataManager() {
    }

    /* JADX INFO: compiled from: GlobalSubwayData.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\"\n\u0002\u0010\b\n\u0002\b\u001d\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001Bq\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\bHÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\u000f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fHÆ\u0003J}\u0010,\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fHÆ\u0001J\u0013\u0010-\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00100\u001a\u00020\u0010HÖ\u0001J\t\u00101\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0014R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0014R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0014R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0014R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0014R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 ¨\u00062"}, d2 = {"Lcom/example/tickets/GlobalSubwayDataManager$SubwayCity;", "", "id", "", "nameZh", "nameEn", "country", "sourceType", "Lcom/example/tickets/GlobalSubwayDataManager$SourceType;", "sourceUrl", "amapCode", "amapSlug", "localAssetPath", "staticGtfsUrl", "gtfsRouteTypes", "", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/example/tickets/GlobalSubwayDataManager$SourceType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Set;)V", "getId", "()Ljava/lang/String;", "getNameZh", "getNameEn", "getCountry", "getSourceType", "()Lcom/example/tickets/GlobalSubwayDataManager$SourceType;", "getSourceUrl", "getAmapCode", "getAmapSlug", "getLocalAssetPath", "getStaticGtfsUrl", "getGtfsRouteTypes", "()Ljava/util/Set;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "copy", "equals", "", "other", "hashCode", "toString", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class SubwayCity {
        public static final int $stable = 8;
        private final String amapCode;
        private final String amapSlug;
        private final String country;
        private final Set<Integer> gtfsRouteTypes;
        private final String id;
        private final String localAssetPath;
        private final String nameEn;
        private final String nameZh;
        private final SourceType sourceType;
        private final String sourceUrl;
        private final String staticGtfsUrl;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ SubwayCity copy$default(SubwayCity subwayCity, String str, String str2, String str3, String str4, SourceType sourceType, String str5, String str6, String str7, String str8, String str9, Set set, int i, Object obj) {
            if ((i & 1) != 0) {
                str = subwayCity.id;
            }
            if ((i & 2) != 0) {
                str2 = subwayCity.nameZh;
            }
            if ((i & 4) != 0) {
                str3 = subwayCity.nameEn;
            }
            if ((i & 8) != 0) {
                str4 = subwayCity.country;
            }
            if ((i & 16) != 0) {
                sourceType = subwayCity.sourceType;
            }
            if ((i & 32) != 0) {
                str5 = subwayCity.sourceUrl;
            }
            if ((i & 64) != 0) {
                str6 = subwayCity.amapCode;
            }
            if ((i & 128) != 0) {
                str7 = subwayCity.amapSlug;
            }
            if ((i & 256) != 0) {
                str8 = subwayCity.localAssetPath;
            }
            if ((i & 512) != 0) {
                str9 = subwayCity.staticGtfsUrl;
            }
            if ((i & 1024) != 0) {
                set = subwayCity.gtfsRouteTypes;
            }
            String str10 = str9;
            Set set2 = set;
            String str11 = str7;
            String str12 = str8;
            String str13 = str5;
            String str14 = str6;
            SourceType sourceType2 = sourceType;
            String str15 = str3;
            return subwayCity.copy(str, str2, str15, str4, sourceType2, str13, str14, str11, str12, str10, set2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getId() {
            return this.id;
        }

        /* JADX INFO: renamed from: component10, reason: from getter */
        public final String getStaticGtfsUrl() {
            return this.staticGtfsUrl;
        }

        public final Set<Integer> component11() {
            return this.gtfsRouteTypes;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getNameZh() {
            return this.nameZh;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getNameEn() {
            return this.nameEn;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getCountry() {
            return this.country;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final SourceType getSourceType() {
            return this.sourceType;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final String getSourceUrl() {
            return this.sourceUrl;
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        public final String getAmapCode() {
            return this.amapCode;
        }

        /* JADX INFO: renamed from: component8, reason: from getter */
        public final String getAmapSlug() {
            return this.amapSlug;
        }

        /* JADX INFO: renamed from: component9, reason: from getter */
        public final String getLocalAssetPath() {
            return this.localAssetPath;
        }

        public final SubwayCity copy(String id, String nameZh, String nameEn, String country, SourceType sourceType, String sourceUrl, String amapCode, String amapSlug, String localAssetPath, String staticGtfsUrl, Set<Integer> gtfsRouteTypes) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(nameZh, "nameZh");
            Intrinsics.checkNotNullParameter(nameEn, "nameEn");
            Intrinsics.checkNotNullParameter(country, "country");
            Intrinsics.checkNotNullParameter(sourceType, "sourceType");
            Intrinsics.checkNotNullParameter(sourceUrl, "sourceUrl");
            Intrinsics.checkNotNullParameter(amapCode, "amapCode");
            Intrinsics.checkNotNullParameter(amapSlug, "amapSlug");
            Intrinsics.checkNotNullParameter(localAssetPath, "localAssetPath");
            Intrinsics.checkNotNullParameter(staticGtfsUrl, "staticGtfsUrl");
            Intrinsics.checkNotNullParameter(gtfsRouteTypes, "gtfsRouteTypes");
            return new SubwayCity(id, nameZh, nameEn, country, sourceType, sourceUrl, amapCode, amapSlug, localAssetPath, staticGtfsUrl, gtfsRouteTypes);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SubwayCity)) {
                return false;
            }
            SubwayCity subwayCity = (SubwayCity) other;
            return Intrinsics.areEqual(this.id, subwayCity.id) && Intrinsics.areEqual(this.nameZh, subwayCity.nameZh) && Intrinsics.areEqual(this.nameEn, subwayCity.nameEn) && Intrinsics.areEqual(this.country, subwayCity.country) && this.sourceType == subwayCity.sourceType && Intrinsics.areEqual(this.sourceUrl, subwayCity.sourceUrl) && Intrinsics.areEqual(this.amapCode, subwayCity.amapCode) && Intrinsics.areEqual(this.amapSlug, subwayCity.amapSlug) && Intrinsics.areEqual(this.localAssetPath, subwayCity.localAssetPath) && Intrinsics.areEqual(this.staticGtfsUrl, subwayCity.staticGtfsUrl) && Intrinsics.areEqual(this.gtfsRouteTypes, subwayCity.gtfsRouteTypes);
        }

        public int hashCode() {
            return (((((((((((((((((((this.id.hashCode() * 31) + this.nameZh.hashCode()) * 31) + this.nameEn.hashCode()) * 31) + this.country.hashCode()) * 31) + this.sourceType.hashCode()) * 31) + this.sourceUrl.hashCode()) * 31) + this.amapCode.hashCode()) * 31) + this.amapSlug.hashCode()) * 31) + this.localAssetPath.hashCode()) * 31) + this.staticGtfsUrl.hashCode()) * 31) + this.gtfsRouteTypes.hashCode();
        }

        public String toString() {
            return "SubwayCity(id=" + this.id + ", nameZh=" + this.nameZh + ", nameEn=" + this.nameEn + ", country=" + this.country + ", sourceType=" + this.sourceType + ", sourceUrl=" + this.sourceUrl + ", amapCode=" + this.amapCode + ", amapSlug=" + this.amapSlug + ", localAssetPath=" + this.localAssetPath + ", staticGtfsUrl=" + this.staticGtfsUrl + ", gtfsRouteTypes=" + this.gtfsRouteTypes + ")";
        }

        public SubwayCity(String id, String nameZh, String nameEn, String country, SourceType sourceType, String sourceUrl, String amapCode, String amapSlug, String localAssetPath, String staticGtfsUrl, Set<Integer> gtfsRouteTypes) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(nameZh, "nameZh");
            Intrinsics.checkNotNullParameter(nameEn, "nameEn");
            Intrinsics.checkNotNullParameter(country, "country");
            Intrinsics.checkNotNullParameter(sourceType, "sourceType");
            Intrinsics.checkNotNullParameter(sourceUrl, "sourceUrl");
            Intrinsics.checkNotNullParameter(amapCode, "amapCode");
            Intrinsics.checkNotNullParameter(amapSlug, "amapSlug");
            Intrinsics.checkNotNullParameter(localAssetPath, "localAssetPath");
            Intrinsics.checkNotNullParameter(staticGtfsUrl, "staticGtfsUrl");
            Intrinsics.checkNotNullParameter(gtfsRouteTypes, "gtfsRouteTypes");
            this.id = id;
            this.nameZh = nameZh;
            this.nameEn = nameEn;
            this.country = country;
            this.sourceType = sourceType;
            this.sourceUrl = sourceUrl;
            this.amapCode = amapCode;
            this.amapSlug = amapSlug;
            this.localAssetPath = localAssetPath;
            this.staticGtfsUrl = staticGtfsUrl;
            this.gtfsRouteTypes = gtfsRouteTypes;
        }

        public /* synthetic */ SubwayCity(String str, String str2, String str3, String str4, SourceType sourceType, String str5, String str6, String str7, String str8, String str9, Set set, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2, str3, str4, sourceType, (i & 32) != 0 ? "" : str5, (i & 64) != 0 ? "" : str6, (i & 128) != 0 ? "" : str7, (i & 256) != 0 ? "" : str8, (i & 512) != 0 ? "" : str9, (i & 1024) != 0 ? SetsKt.emptySet() : set);
        }

        public final String getId() {
            return this.id;
        }

        public final String getNameZh() {
            return this.nameZh;
        }

        public final String getNameEn() {
            return this.nameEn;
        }

        public final String getCountry() {
            return this.country;
        }

        public final SourceType getSourceType() {
            return this.sourceType;
        }

        public final String getSourceUrl() {
            return this.sourceUrl;
        }

        public final String getAmapCode() {
            return this.amapCode;
        }

        public final String getAmapSlug() {
            return this.amapSlug;
        }

        public final String getLocalAssetPath() {
            return this.localAssetPath;
        }

        public final String getStaticGtfsUrl() {
            return this.staticGtfsUrl;
        }

        public final Set<Integer> getGtfsRouteTypes() {
            return this.gtfsRouteTypes;
        }
    }

    /* JADX INFO: compiled from: GlobalSubwayData.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0007HÆ\u0003J1\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0007HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/example/tickets/GlobalSubwayDataManager$SubwayRouteInfo;", "", "routeId", "", "shortName", "longName", "color", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "getRouteId", "()Ljava/lang/String;", "getShortName", "getLongName", "getColor", "()I", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class SubwayRouteInfo {
        public static final int $stable = 0;
        private final int color;
        private final String longName;
        private final String routeId;
        private final String shortName;

        public static /* synthetic */ SubwayRouteInfo copy$default(SubwayRouteInfo subwayRouteInfo, String str, String str2, String str3, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = subwayRouteInfo.routeId;
            }
            if ((i2 & 2) != 0) {
                str2 = subwayRouteInfo.shortName;
            }
            if ((i2 & 4) != 0) {
                str3 = subwayRouteInfo.longName;
            }
            if ((i2 & 8) != 0) {
                i = subwayRouteInfo.color;
            }
            return subwayRouteInfo.copy(str, str2, str3, i);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getRouteId() {
            return this.routeId;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getShortName() {
            return this.shortName;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getLongName() {
            return this.longName;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final int getColor() {
            return this.color;
        }

        public final SubwayRouteInfo copy(String routeId, String shortName, String longName, int color) {
            Intrinsics.checkNotNullParameter(routeId, "routeId");
            Intrinsics.checkNotNullParameter(shortName, "shortName");
            Intrinsics.checkNotNullParameter(longName, "longName");
            return new SubwayRouteInfo(routeId, shortName, longName, color);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SubwayRouteInfo)) {
                return false;
            }
            SubwayRouteInfo subwayRouteInfo = (SubwayRouteInfo) other;
            return Intrinsics.areEqual(this.routeId, subwayRouteInfo.routeId) && Intrinsics.areEqual(this.shortName, subwayRouteInfo.shortName) && Intrinsics.areEqual(this.longName, subwayRouteInfo.longName) && this.color == subwayRouteInfo.color;
        }

        public int hashCode() {
            return (((((this.routeId.hashCode() * 31) + this.shortName.hashCode()) * 31) + this.longName.hashCode()) * 31) + Integer.hashCode(this.color);
        }

        public String toString() {
            return "SubwayRouteInfo(routeId=" + this.routeId + ", shortName=" + this.shortName + ", longName=" + this.longName + ", color=" + this.color + ")";
        }

        public SubwayRouteInfo(String routeId, String shortName, String longName, int i) {
            Intrinsics.checkNotNullParameter(routeId, "routeId");
            Intrinsics.checkNotNullParameter(shortName, "shortName");
            Intrinsics.checkNotNullParameter(longName, "longName");
            this.routeId = routeId;
            this.shortName = shortName;
            this.longName = longName;
            this.color = i;
        }

        public final String getRouteId() {
            return this.routeId;
        }

        public final String getShortName() {
            return this.shortName;
        }

        public final String getLongName() {
            return this.longName;
        }

        public final int getColor() {
            return this.color;
        }
    }

    /* JADX INFO: compiled from: GlobalSubwayData.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\t¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0006HÆ\u0003J\u000f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0003J\u000f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00030\tHÆ\u0003JQ\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\tHÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\"HÖ\u0001J\t\u0010#\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\t¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015¨\u0006$"}, d2 = {"Lcom/example/tickets/GlobalSubwayDataManager$SubwayStationOption;", "", "key", "", HintConstants.AUTOFILL_HINT_NAME, "latitude", "", "longitude", "routes", "", "Lcom/example/tickets/GlobalSubwayDataManager$SubwayRouteInfo;", "searchNames", "<init>", "(Ljava/lang/String;Ljava/lang/String;DDLjava/util/List;Ljava/util/List;)V", "getKey", "()Ljava/lang/String;", "getName", "getLatitude", "()D", "getLongitude", "getRoutes", "()Ljava/util/List;", "getSearchNames", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class SubwayStationOption {
        public static final int $stable = 8;
        private final String key;
        private final double latitude;
        private final double longitude;
        private final String name;
        private final List<SubwayRouteInfo> routes;
        private final List<String> searchNames;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ SubwayStationOption copy$default(SubwayStationOption subwayStationOption, String str, String str2, double d, double d2, List list, List list2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = subwayStationOption.key;
            }
            if ((i & 2) != 0) {
                str2 = subwayStationOption.name;
            }
            if ((i & 4) != 0) {
                d = subwayStationOption.latitude;
            }
            if ((i & 8) != 0) {
                d2 = subwayStationOption.longitude;
            }
            if ((i & 16) != 0) {
                list = subwayStationOption.routes;
            }
            if ((i & 32) != 0) {
                list2 = subwayStationOption.searchNames;
            }
            double d3 = d2;
            double d4 = d;
            return subwayStationOption.copy(str, str2, d4, d3, list, list2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getKey() {
            return this.key;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getName() {
            return this.name;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final double getLatitude() {
            return this.latitude;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final double getLongitude() {
            return this.longitude;
        }

        public final List<SubwayRouteInfo> component5() {
            return this.routes;
        }

        public final List<String> component6() {
            return this.searchNames;
        }

        public final SubwayStationOption copy(String key, String name, double latitude, double longitude, List<SubwayRouteInfo> routes, List<String> searchNames) {
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(routes, "routes");
            Intrinsics.checkNotNullParameter(searchNames, "searchNames");
            return new SubwayStationOption(key, name, latitude, longitude, routes, searchNames);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SubwayStationOption)) {
                return false;
            }
            SubwayStationOption subwayStationOption = (SubwayStationOption) other;
            return Intrinsics.areEqual(this.key, subwayStationOption.key) && Intrinsics.areEqual(this.name, subwayStationOption.name) && Double.compare(this.latitude, subwayStationOption.latitude) == 0 && Double.compare(this.longitude, subwayStationOption.longitude) == 0 && Intrinsics.areEqual(this.routes, subwayStationOption.routes) && Intrinsics.areEqual(this.searchNames, subwayStationOption.searchNames);
        }

        public int hashCode() {
            return (((((((((this.key.hashCode() * 31) + this.name.hashCode()) * 31) + Double.hashCode(this.latitude)) * 31) + Double.hashCode(this.longitude)) * 31) + this.routes.hashCode()) * 31) + this.searchNames.hashCode();
        }

        public String toString() {
            return "SubwayStationOption(key=" + this.key + ", name=" + this.name + ", latitude=" + this.latitude + ", longitude=" + this.longitude + ", routes=" + this.routes + ", searchNames=" + this.searchNames + ")";
        }

        public SubwayStationOption(String key, String name, double d, double d2, List<SubwayRouteInfo> routes, List<String> searchNames) {
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(routes, "routes");
            Intrinsics.checkNotNullParameter(searchNames, "searchNames");
            this.key = key;
            this.name = name;
            this.latitude = d;
            this.longitude = d2;
            this.routes = routes;
            this.searchNames = searchNames;
        }

        public final String getKey() {
            return this.key;
        }

        public final String getName() {
            return this.name;
        }

        public final double getLatitude() {
            return this.latitude;
        }

        public final double getLongitude() {
            return this.longitude;
        }

        public final List<SubwayRouteInfo> getRoutes() {
            return this.routes;
        }

        public /* synthetic */ SubwayStationOption(String str, String str2, double d, double d2, List list, List list2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2, d, d2, list, (i & 32) != 0 ? CollectionsKt.emptyList() : list2);
        }

        public final List<String> getSearchNames() {
            return this.searchNames;
        }
    }

    /* JADX INFO: compiled from: GlobalSubwayData.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J;\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\f¨\u0006\u001e"}, d2 = {"Lcom/example/tickets/GlobalSubwayDataManager$SubwayRouteStation;", "", "stationKey", "", HintConstants.AUTOFILL_HINT_NAME, "latitude", "", "longitude", "routeId", "<init>", "(Ljava/lang/String;Ljava/lang/String;DDLjava/lang/String;)V", "getStationKey", "()Ljava/lang/String;", "getName", "getLatitude", "()D", "getLongitude", "getRouteId", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class SubwayRouteStation {
        public static final int $stable = 0;
        private final double latitude;
        private final double longitude;
        private final String name;
        private final String routeId;
        private final String stationKey;

        public static /* synthetic */ SubwayRouteStation copy$default(SubwayRouteStation subwayRouteStation, String str, String str2, double d, double d2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = subwayRouteStation.stationKey;
            }
            if ((i & 2) != 0) {
                str2 = subwayRouteStation.name;
            }
            if ((i & 4) != 0) {
                d = subwayRouteStation.latitude;
            }
            if ((i & 8) != 0) {
                d2 = subwayRouteStation.longitude;
            }
            if ((i & 16) != 0) {
                str3 = subwayRouteStation.routeId;
            }
            String str4 = str3;
            double d3 = d2;
            return subwayRouteStation.copy(str, str2, d, d3, str4);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getStationKey() {
            return this.stationKey;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getName() {
            return this.name;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final double getLatitude() {
            return this.latitude;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final double getLongitude() {
            return this.longitude;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final String getRouteId() {
            return this.routeId;
        }

        public final SubwayRouteStation copy(String stationKey, String name, double latitude, double longitude, String routeId) {
            Intrinsics.checkNotNullParameter(stationKey, "stationKey");
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(routeId, "routeId");
            return new SubwayRouteStation(stationKey, name, latitude, longitude, routeId);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SubwayRouteStation)) {
                return false;
            }
            SubwayRouteStation subwayRouteStation = (SubwayRouteStation) other;
            return Intrinsics.areEqual(this.stationKey, subwayRouteStation.stationKey) && Intrinsics.areEqual(this.name, subwayRouteStation.name) && Double.compare(this.latitude, subwayRouteStation.latitude) == 0 && Double.compare(this.longitude, subwayRouteStation.longitude) == 0 && Intrinsics.areEqual(this.routeId, subwayRouteStation.routeId);
        }

        public int hashCode() {
            return (((((((this.stationKey.hashCode() * 31) + this.name.hashCode()) * 31) + Double.hashCode(this.latitude)) * 31) + Double.hashCode(this.longitude)) * 31) + this.routeId.hashCode();
        }

        public String toString() {
            return "SubwayRouteStation(stationKey=" + this.stationKey + ", name=" + this.name + ", latitude=" + this.latitude + ", longitude=" + this.longitude + ", routeId=" + this.routeId + ")";
        }

        public SubwayRouteStation(String stationKey, String name, double d, double d2, String routeId) {
            Intrinsics.checkNotNullParameter(stationKey, "stationKey");
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(routeId, "routeId");
            this.stationKey = stationKey;
            this.name = name;
            this.latitude = d;
            this.longitude = d2;
            this.routeId = routeId;
        }

        public final String getStationKey() {
            return this.stationKey;
        }

        public final String getName() {
            return this.name;
        }

        public final double getLatitude() {
            return this.latitude;
        }

        public final double getLongitude() {
            return this.longitude;
        }

        public final String getRouteId() {
            return this.routeId;
        }
    }

    /* JADX INFO: compiled from: GlobalSubwayData.kt */
    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001Bg\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u000b\u0012\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\u000b¢\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\bHÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\u000f\u0010#\u001a\b\u0012\u0004\u0012\u00020\f0\u000bHÆ\u0003J\u000f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u000e0\u000bHÆ\u0003J\u000f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00050\u000bHÆ\u0003Jo\u0010&\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\u00032\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u000b2\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\u000bHÆ\u0001J\u0013\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010*\u001a\u00020+HÖ\u0001J\t\u0010,\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0013R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001bR\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001b¨\u0006-"}, d2 = {"Lcom/example/tickets/GlobalSubwayDataManager$SubwayRoutePlan;", "", "cityId", "", "primaryRoute", "Lcom/example/tickets/GlobalSubwayDataManager$SubwayRouteInfo;", "secondaryRoute", "transferStation", "Lcom/example/tickets/GlobalSubwayDataManager$SubwayStationOption;", "transferStationKey", "stations", "", "Lcom/example/tickets/GlobalSubwayDataManager$SubwayRouteStation;", "routePath", "Lcom/example/tickets/GlobalSubwayDataManager$RoutePoint;", "routeInfos", "<init>", "(Ljava/lang/String;Lcom/example/tickets/GlobalSubwayDataManager$SubwayRouteInfo;Lcom/example/tickets/GlobalSubwayDataManager$SubwayRouteInfo;Lcom/example/tickets/GlobalSubwayDataManager$SubwayStationOption;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "getCityId", "()Ljava/lang/String;", "getPrimaryRoute", "()Lcom/example/tickets/GlobalSubwayDataManager$SubwayRouteInfo;", "getSecondaryRoute", "getTransferStation", "()Lcom/example/tickets/GlobalSubwayDataManager$SubwayStationOption;", "getTransferStationKey", "getStations", "()Ljava/util/List;", "getRoutePath", "getRouteInfos", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "", "toString", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class SubwayRoutePlan {
        public static final int $stable = 8;
        private final String cityId;
        private final SubwayRouteInfo primaryRoute;
        private final List<SubwayRouteInfo> routeInfos;
        private final List<RoutePoint> routePath;
        private final SubwayRouteInfo secondaryRoute;
        private final List<SubwayRouteStation> stations;
        private final SubwayStationOption transferStation;
        private final String transferStationKey;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ SubwayRoutePlan copy$default(SubwayRoutePlan subwayRoutePlan, String str, SubwayRouteInfo subwayRouteInfo, SubwayRouteInfo subwayRouteInfo2, SubwayStationOption subwayStationOption, String str2, List list, List list2, List list3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = subwayRoutePlan.cityId;
            }
            if ((i & 2) != 0) {
                subwayRouteInfo = subwayRoutePlan.primaryRoute;
            }
            if ((i & 4) != 0) {
                subwayRouteInfo2 = subwayRoutePlan.secondaryRoute;
            }
            if ((i & 8) != 0) {
                subwayStationOption = subwayRoutePlan.transferStation;
            }
            if ((i & 16) != 0) {
                str2 = subwayRoutePlan.transferStationKey;
            }
            if ((i & 32) != 0) {
                list = subwayRoutePlan.stations;
            }
            if ((i & 64) != 0) {
                list2 = subwayRoutePlan.routePath;
            }
            if ((i & 128) != 0) {
                list3 = subwayRoutePlan.routeInfos;
            }
            List list4 = list2;
            List list5 = list3;
            String str3 = str2;
            List list6 = list;
            return subwayRoutePlan.copy(str, subwayRouteInfo, subwayRouteInfo2, subwayStationOption, str3, list6, list4, list5);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getCityId() {
            return this.cityId;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final SubwayRouteInfo getPrimaryRoute() {
            return this.primaryRoute;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final SubwayRouteInfo getSecondaryRoute() {
            return this.secondaryRoute;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final SubwayStationOption getTransferStation() {
            return this.transferStation;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final String getTransferStationKey() {
            return this.transferStationKey;
        }

        public final List<SubwayRouteStation> component6() {
            return this.stations;
        }

        public final List<RoutePoint> component7() {
            return this.routePath;
        }

        public final List<SubwayRouteInfo> component8() {
            return this.routeInfos;
        }

        public final SubwayRoutePlan copy(String cityId, SubwayRouteInfo primaryRoute, SubwayRouteInfo secondaryRoute, SubwayStationOption transferStation, String transferStationKey, List<SubwayRouteStation> stations, List<RoutePoint> routePath, List<SubwayRouteInfo> routeInfos) {
            Intrinsics.checkNotNullParameter(cityId, "cityId");
            Intrinsics.checkNotNullParameter(primaryRoute, "primaryRoute");
            Intrinsics.checkNotNullParameter(transferStationKey, "transferStationKey");
            Intrinsics.checkNotNullParameter(stations, "stations");
            Intrinsics.checkNotNullParameter(routePath, "routePath");
            Intrinsics.checkNotNullParameter(routeInfos, "routeInfos");
            return new SubwayRoutePlan(cityId, primaryRoute, secondaryRoute, transferStation, transferStationKey, stations, routePath, routeInfos);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SubwayRoutePlan)) {
                return false;
            }
            SubwayRoutePlan subwayRoutePlan = (SubwayRoutePlan) other;
            return Intrinsics.areEqual(this.cityId, subwayRoutePlan.cityId) && Intrinsics.areEqual(this.primaryRoute, subwayRoutePlan.primaryRoute) && Intrinsics.areEqual(this.secondaryRoute, subwayRoutePlan.secondaryRoute) && Intrinsics.areEqual(this.transferStation, subwayRoutePlan.transferStation) && Intrinsics.areEqual(this.transferStationKey, subwayRoutePlan.transferStationKey) && Intrinsics.areEqual(this.stations, subwayRoutePlan.stations) && Intrinsics.areEqual(this.routePath, subwayRoutePlan.routePath) && Intrinsics.areEqual(this.routeInfos, subwayRoutePlan.routeInfos);
        }

        public int hashCode() {
            int iHashCode = ((this.cityId.hashCode() * 31) + this.primaryRoute.hashCode()) * 31;
            SubwayRouteInfo subwayRouteInfo = this.secondaryRoute;
            int iHashCode2 = (iHashCode + (subwayRouteInfo == null ? 0 : subwayRouteInfo.hashCode())) * 31;
            SubwayStationOption subwayStationOption = this.transferStation;
            return ((((((((iHashCode2 + (subwayStationOption != null ? subwayStationOption.hashCode() : 0)) * 31) + this.transferStationKey.hashCode()) * 31) + this.stations.hashCode()) * 31) + this.routePath.hashCode()) * 31) + this.routeInfos.hashCode();
        }

        public String toString() {
            return "SubwayRoutePlan(cityId=" + this.cityId + ", primaryRoute=" + this.primaryRoute + ", secondaryRoute=" + this.secondaryRoute + ", transferStation=" + this.transferStation + ", transferStationKey=" + this.transferStationKey + ", stations=" + this.stations + ", routePath=" + this.routePath + ", routeInfos=" + this.routeInfos + ")";
        }

        public SubwayRoutePlan(String cityId, SubwayRouteInfo primaryRoute, SubwayRouteInfo subwayRouteInfo, SubwayStationOption subwayStationOption, String transferStationKey, List<SubwayRouteStation> stations, List<RoutePoint> routePath, List<SubwayRouteInfo> routeInfos) {
            Intrinsics.checkNotNullParameter(cityId, "cityId");
            Intrinsics.checkNotNullParameter(primaryRoute, "primaryRoute");
            Intrinsics.checkNotNullParameter(transferStationKey, "transferStationKey");
            Intrinsics.checkNotNullParameter(stations, "stations");
            Intrinsics.checkNotNullParameter(routePath, "routePath");
            Intrinsics.checkNotNullParameter(routeInfos, "routeInfos");
            this.cityId = cityId;
            this.primaryRoute = primaryRoute;
            this.secondaryRoute = subwayRouteInfo;
            this.transferStation = subwayStationOption;
            this.transferStationKey = transferStationKey;
            this.stations = stations;
            this.routePath = routePath;
            this.routeInfos = routeInfos;
        }

        public final String getCityId() {
            return this.cityId;
        }

        public final SubwayRouteInfo getPrimaryRoute() {
            return this.primaryRoute;
        }

        public final SubwayRouteInfo getSecondaryRoute() {
            return this.secondaryRoute;
        }

        public final SubwayStationOption getTransferStation() {
            return this.transferStation;
        }

        public /* synthetic */ SubwayRoutePlan(String str, SubwayRouteInfo subwayRouteInfo, SubwayRouteInfo subwayRouteInfo2, SubwayStationOption subwayStationOption, String str2, List list, List list2, List list3, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, subwayRouteInfo, (i & 4) != 0 ? null : subwayRouteInfo2, (i & 8) != 0 ? null : subwayStationOption, (i & 16) != 0 ? "" : str2, list, (i & 64) != 0 ? CollectionsKt.emptyList() : list2, (i & 128) != 0 ? CollectionsKt.emptyList() : list3);
        }

        public final String getTransferStationKey() {
            return this.transferStationKey;
        }

        public final List<SubwayRouteStation> getStations() {
            return this.stations;
        }

        public final List<RoutePoint> getRoutePath() {
            return this.routePath;
        }

        public final List<SubwayRouteInfo> getRouteInfos() {
            return this.routeInfos;
        }
    }

    /* JADX INFO: compiled from: GlobalSubwayData.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/example/tickets/GlobalSubwayDataManager$RoutePoint;", "", "latitude", "", "longitude", "<init>", "(DD)V", "getLatitude", "()D", "getLongitude", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class RoutePoint {
        public static final int $stable = 0;
        private final double latitude;
        private final double longitude;

        public static /* synthetic */ RoutePoint copy$default(RoutePoint routePoint, double d, double d2, int i, Object obj) {
            if ((i & 1) != 0) {
                d = routePoint.latitude;
            }
            if ((i & 2) != 0) {
                d2 = routePoint.longitude;
            }
            return routePoint.copy(d, d2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final double getLatitude() {
            return this.latitude;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final double getLongitude() {
            return this.longitude;
        }

        public final RoutePoint copy(double latitude, double longitude) {
            return new RoutePoint(latitude, longitude);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof RoutePoint)) {
                return false;
            }
            RoutePoint routePoint = (RoutePoint) other;
            return Double.compare(this.latitude, routePoint.latitude) == 0 && Double.compare(this.longitude, routePoint.longitude) == 0;
        }

        public int hashCode() {
            return (Double.hashCode(this.latitude) * 31) + Double.hashCode(this.longitude);
        }

        public String toString() {
            return "RoutePoint(latitude=" + this.latitude + ", longitude=" + this.longitude + ")";
        }

        public RoutePoint(double d, double d2) {
            this.latitude = d;
            this.longitude = d2;
        }

        public final double getLatitude() {
            return this.latitude;
        }

        public final double getLongitude() {
            return this.longitude;
        }
    }

    /* JADX INFO: compiled from: GlobalSubwayData.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b.\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B\u008d\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\u0006\u0010\u0012\u001a\u00020\u0003\u0012\u0006\u0010\u0013\u001a\u00020\u000e¢\u0006\u0004\b\u0014\u0010\u0015J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\t\u0010-\u001a\u00020\u0003HÆ\u0003J\t\u0010.\u001a\u00020\u0003HÆ\u0003J\t\u0010/\u001a\u00020\u0003HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u00102\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\u001fJ\u0010\u00103\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\u001fJ\u0010\u00104\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u0010#J\u0010\u00105\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u0010#J\u0010\u00106\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\u001fJ\t\u00107\u001a\u00020\u0003HÆ\u0003J\t\u00108\u001a\u00020\u0003HÆ\u0003J\t\u00109\u001a\u00020\u000eHÆ\u0003J²\u0001\u0010:\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u000eHÆ\u0001¢\u0006\u0002\u0010;J\u0013\u0010<\u001a\u00020=2\b\u0010>\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010?\u001a\u00020\u000bHÖ\u0001J\t\u0010@\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0017R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0017R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0017R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0017R\u0015\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010 \u001a\u0004\b\u001e\u0010\u001fR\u0015\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010 \u001a\u0004\b!\u0010\u001fR\u0015\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\n\n\u0002\u0010$\u001a\u0004\b\"\u0010#R\u0015\u0010\u000f\u001a\u0004\u0018\u00010\u000e¢\u0006\n\n\u0002\u0010$\u001a\u0004\b%\u0010#R\u0015\u0010\u0010\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010 \u001a\u0004\b&\u0010\u001fR\u0011\u0010\u0011\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0017R\u0011\u0010\u0012\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u0017R\u0011\u0010\u0013\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*¨\u0006A"}, d2 = {"Lcom/example/tickets/GlobalSubwayDataManager$NycRealtimeOverlay;", "", "tripId", "", "routeId", "directionId", "startDate", "headsign", "currentStationKey", "nextStationKey", "currentStopSequence", "", "nextStopSequence", "nextArrivalEpochSec", "", "nextDepartureEpochSec", "delaySec", "scheduleRelationship", "sourceFeed", "updatedAt", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;J)V", "getTripId", "()Ljava/lang/String;", "getRouteId", "getDirectionId", "getStartDate", "getHeadsign", "getCurrentStationKey", "getNextStationKey", "getCurrentStopSequence", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getNextStopSequence", "getNextArrivalEpochSec", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getNextDepartureEpochSec", "getDelaySec", "getScheduleRelationship", "getSourceFeed", "getUpdatedAt", "()J", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;J)Lcom/example/tickets/GlobalSubwayDataManager$NycRealtimeOverlay;", "equals", "", "other", "hashCode", "toString", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class NycRealtimeOverlay {
        public static final int $stable = 0;
        private final String currentStationKey;
        private final Integer currentStopSequence;
        private final Integer delaySec;
        private final String directionId;
        private final String headsign;
        private final Long nextArrivalEpochSec;
        private final Long nextDepartureEpochSec;
        private final String nextStationKey;
        private final Integer nextStopSequence;
        private final String routeId;
        private final String scheduleRelationship;
        private final String sourceFeed;
        private final String startDate;
        private final String tripId;
        private final long updatedAt;

        public static /* synthetic */ NycRealtimeOverlay copy$default(NycRealtimeOverlay nycRealtimeOverlay, String str, String str2, String str3, String str4, String str5, String str6, String str7, Integer num, Integer num2, Long l, Long l2, Integer num3, String str8, String str9, long j, int i, Object obj) {
            long j2;
            String str10;
            String str11 = (i & 1) != 0 ? nycRealtimeOverlay.tripId : str;
            String str12 = (i & 2) != 0 ? nycRealtimeOverlay.routeId : str2;
            String str13 = (i & 4) != 0 ? nycRealtimeOverlay.directionId : str3;
            String str14 = (i & 8) != 0 ? nycRealtimeOverlay.startDate : str4;
            String str15 = (i & 16) != 0 ? nycRealtimeOverlay.headsign : str5;
            String str16 = (i & 32) != 0 ? nycRealtimeOverlay.currentStationKey : str6;
            String str17 = (i & 64) != 0 ? nycRealtimeOverlay.nextStationKey : str7;
            Integer num4 = (i & 128) != 0 ? nycRealtimeOverlay.currentStopSequence : num;
            Integer num5 = (i & 256) != 0 ? nycRealtimeOverlay.nextStopSequence : num2;
            Long l3 = (i & 512) != 0 ? nycRealtimeOverlay.nextArrivalEpochSec : l;
            Long l4 = (i & 1024) != 0 ? nycRealtimeOverlay.nextDepartureEpochSec : l2;
            Integer num6 = (i & 2048) != 0 ? nycRealtimeOverlay.delaySec : num3;
            String str18 = (i & 4096) != 0 ? nycRealtimeOverlay.scheduleRelationship : str8;
            String str19 = (i & 8192) != 0 ? nycRealtimeOverlay.sourceFeed : str9;
            if ((i & 16384) != 0) {
                str10 = str11;
                j2 = nycRealtimeOverlay.updatedAt;
            } else {
                j2 = j;
                str10 = str11;
            }
            return nycRealtimeOverlay.copy(str10, str12, str13, str14, str15, str16, str17, num4, num5, l3, l4, num6, str18, str19, j2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getTripId() {
            return this.tripId;
        }

        /* JADX INFO: renamed from: component10, reason: from getter */
        public final Long getNextArrivalEpochSec() {
            return this.nextArrivalEpochSec;
        }

        /* JADX INFO: renamed from: component11, reason: from getter */
        public final Long getNextDepartureEpochSec() {
            return this.nextDepartureEpochSec;
        }

        /* JADX INFO: renamed from: component12, reason: from getter */
        public final Integer getDelaySec() {
            return this.delaySec;
        }

        /* JADX INFO: renamed from: component13, reason: from getter */
        public final String getScheduleRelationship() {
            return this.scheduleRelationship;
        }

        /* JADX INFO: renamed from: component14, reason: from getter */
        public final String getSourceFeed() {
            return this.sourceFeed;
        }

        /* JADX INFO: renamed from: component15, reason: from getter */
        public final long getUpdatedAt() {
            return this.updatedAt;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getRouteId() {
            return this.routeId;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getDirectionId() {
            return this.directionId;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getStartDate() {
            return this.startDate;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final String getHeadsign() {
            return this.headsign;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final String getCurrentStationKey() {
            return this.currentStationKey;
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        public final String getNextStationKey() {
            return this.nextStationKey;
        }

        /* JADX INFO: renamed from: component8, reason: from getter */
        public final Integer getCurrentStopSequence() {
            return this.currentStopSequence;
        }

        /* JADX INFO: renamed from: component9, reason: from getter */
        public final Integer getNextStopSequence() {
            return this.nextStopSequence;
        }

        public final NycRealtimeOverlay copy(String tripId, String routeId, String directionId, String startDate, String headsign, String currentStationKey, String nextStationKey, Integer currentStopSequence, Integer nextStopSequence, Long nextArrivalEpochSec, Long nextDepartureEpochSec, Integer delaySec, String scheduleRelationship, String sourceFeed, long updatedAt) {
            Intrinsics.checkNotNullParameter(tripId, "tripId");
            Intrinsics.checkNotNullParameter(routeId, "routeId");
            Intrinsics.checkNotNullParameter(directionId, "directionId");
            Intrinsics.checkNotNullParameter(startDate, "startDate");
            Intrinsics.checkNotNullParameter(headsign, "headsign");
            Intrinsics.checkNotNullParameter(scheduleRelationship, "scheduleRelationship");
            Intrinsics.checkNotNullParameter(sourceFeed, "sourceFeed");
            return new NycRealtimeOverlay(tripId, routeId, directionId, startDate, headsign, currentStationKey, nextStationKey, currentStopSequence, nextStopSequence, nextArrivalEpochSec, nextDepartureEpochSec, delaySec, scheduleRelationship, sourceFeed, updatedAt);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof NycRealtimeOverlay)) {
                return false;
            }
            NycRealtimeOverlay nycRealtimeOverlay = (NycRealtimeOverlay) other;
            return Intrinsics.areEqual(this.tripId, nycRealtimeOverlay.tripId) && Intrinsics.areEqual(this.routeId, nycRealtimeOverlay.routeId) && Intrinsics.areEqual(this.directionId, nycRealtimeOverlay.directionId) && Intrinsics.areEqual(this.startDate, nycRealtimeOverlay.startDate) && Intrinsics.areEqual(this.headsign, nycRealtimeOverlay.headsign) && Intrinsics.areEqual(this.currentStationKey, nycRealtimeOverlay.currentStationKey) && Intrinsics.areEqual(this.nextStationKey, nycRealtimeOverlay.nextStationKey) && Intrinsics.areEqual(this.currentStopSequence, nycRealtimeOverlay.currentStopSequence) && Intrinsics.areEqual(this.nextStopSequence, nycRealtimeOverlay.nextStopSequence) && Intrinsics.areEqual(this.nextArrivalEpochSec, nycRealtimeOverlay.nextArrivalEpochSec) && Intrinsics.areEqual(this.nextDepartureEpochSec, nycRealtimeOverlay.nextDepartureEpochSec) && Intrinsics.areEqual(this.delaySec, nycRealtimeOverlay.delaySec) && Intrinsics.areEqual(this.scheduleRelationship, nycRealtimeOverlay.scheduleRelationship) && Intrinsics.areEqual(this.sourceFeed, nycRealtimeOverlay.sourceFeed) && this.updatedAt == nycRealtimeOverlay.updatedAt;
        }

        public int hashCode() {
            int iHashCode = ((((((((this.tripId.hashCode() * 31) + this.routeId.hashCode()) * 31) + this.directionId.hashCode()) * 31) + this.startDate.hashCode()) * 31) + this.headsign.hashCode()) * 31;
            String str = this.currentStationKey;
            int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.nextStationKey;
            int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
            Integer num = this.currentStopSequence;
            int iHashCode4 = (iHashCode3 + (num == null ? 0 : num.hashCode())) * 31;
            Integer num2 = this.nextStopSequence;
            int iHashCode5 = (iHashCode4 + (num2 == null ? 0 : num2.hashCode())) * 31;
            Long l = this.nextArrivalEpochSec;
            int iHashCode6 = (iHashCode5 + (l == null ? 0 : l.hashCode())) * 31;
            Long l2 = this.nextDepartureEpochSec;
            int iHashCode7 = (iHashCode6 + (l2 == null ? 0 : l2.hashCode())) * 31;
            Integer num3 = this.delaySec;
            return ((((((iHashCode7 + (num3 != null ? num3.hashCode() : 0)) * 31) + this.scheduleRelationship.hashCode()) * 31) + this.sourceFeed.hashCode()) * 31) + Long.hashCode(this.updatedAt);
        }

        public String toString() {
            return "NycRealtimeOverlay(tripId=" + this.tripId + ", routeId=" + this.routeId + ", directionId=" + this.directionId + ", startDate=" + this.startDate + ", headsign=" + this.headsign + ", currentStationKey=" + this.currentStationKey + ", nextStationKey=" + this.nextStationKey + ", currentStopSequence=" + this.currentStopSequence + ", nextStopSequence=" + this.nextStopSequence + ", nextArrivalEpochSec=" + this.nextArrivalEpochSec + ", nextDepartureEpochSec=" + this.nextDepartureEpochSec + ", delaySec=" + this.delaySec + ", scheduleRelationship=" + this.scheduleRelationship + ", sourceFeed=" + this.sourceFeed + ", updatedAt=" + this.updatedAt + ")";
        }

        public NycRealtimeOverlay(String tripId, String routeId, String directionId, String startDate, String headsign, String str, String str2, Integer num, Integer num2, Long l, Long l2, Integer num3, String scheduleRelationship, String sourceFeed, long j) {
            Intrinsics.checkNotNullParameter(tripId, "tripId");
            Intrinsics.checkNotNullParameter(routeId, "routeId");
            Intrinsics.checkNotNullParameter(directionId, "directionId");
            Intrinsics.checkNotNullParameter(startDate, "startDate");
            Intrinsics.checkNotNullParameter(headsign, "headsign");
            Intrinsics.checkNotNullParameter(scheduleRelationship, "scheduleRelationship");
            Intrinsics.checkNotNullParameter(sourceFeed, "sourceFeed");
            this.tripId = tripId;
            this.routeId = routeId;
            this.directionId = directionId;
            this.startDate = startDate;
            this.headsign = headsign;
            this.currentStationKey = str;
            this.nextStationKey = str2;
            this.currentStopSequence = num;
            this.nextStopSequence = num2;
            this.nextArrivalEpochSec = l;
            this.nextDepartureEpochSec = l2;
            this.delaySec = num3;
            this.scheduleRelationship = scheduleRelationship;
            this.sourceFeed = sourceFeed;
            this.updatedAt = j;
        }

        public final String getTripId() {
            return this.tripId;
        }

        public final String getRouteId() {
            return this.routeId;
        }

        public final String getDirectionId() {
            return this.directionId;
        }

        public final String getStartDate() {
            return this.startDate;
        }

        public final String getHeadsign() {
            return this.headsign;
        }

        public final String getCurrentStationKey() {
            return this.currentStationKey;
        }

        public final String getNextStationKey() {
            return this.nextStationKey;
        }

        public final Integer getCurrentStopSequence() {
            return this.currentStopSequence;
        }

        public final Integer getNextStopSequence() {
            return this.nextStopSequence;
        }

        public final Long getNextArrivalEpochSec() {
            return this.nextArrivalEpochSec;
        }

        public final Long getNextDepartureEpochSec() {
            return this.nextDepartureEpochSec;
        }

        public final Integer getDelaySec() {
            return this.delaySec;
        }

        public final String getScheduleRelationship() {
            return this.scheduleRelationship;
        }

        public final String getSourceFeed() {
            return this.sourceFeed;
        }

        public final long getUpdatedAt() {
            return this.updatedAt;
        }
    }

    /* JADX INFO: compiled from: GlobalSubwayData.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/example/tickets/GlobalSubwayDataManager$UsServerPatternCache;", "", "fetchedAt", "", "index", "Lcom/example/tickets/GlobalSubwayDataManager$StaticIndex;", "<init>", "(JLcom/example/tickets/GlobalSubwayDataManager$StaticIndex;)V", "getFetchedAt", "()J", "getIndex", "()Lcom/example/tickets/GlobalSubwayDataManager$StaticIndex;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
    private static final /* data */ class UsServerPatternCache {
        private final long fetchedAt;
        private final StaticIndex index;

        public static /* synthetic */ UsServerPatternCache copy$default(UsServerPatternCache usServerPatternCache, long j, StaticIndex staticIndex, int i, Object obj) {
            if ((i & 1) != 0) {
                j = usServerPatternCache.fetchedAt;
            }
            if ((i & 2) != 0) {
                staticIndex = usServerPatternCache.index;
            }
            return usServerPatternCache.copy(j, staticIndex);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final long getFetchedAt() {
            return this.fetchedAt;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final StaticIndex getIndex() {
            return this.index;
        }

        public final UsServerPatternCache copy(long fetchedAt, StaticIndex index) {
            Intrinsics.checkNotNullParameter(index, "index");
            return new UsServerPatternCache(fetchedAt, index);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof UsServerPatternCache)) {
                return false;
            }
            UsServerPatternCache usServerPatternCache = (UsServerPatternCache) other;
            return this.fetchedAt == usServerPatternCache.fetchedAt && Intrinsics.areEqual(this.index, usServerPatternCache.index);
        }

        public int hashCode() {
            return (Long.hashCode(this.fetchedAt) * 31) + this.index.hashCode();
        }

        public String toString() {
            return "UsServerPatternCache(fetchedAt=" + this.fetchedAt + ", index=" + this.index + ")";
        }

        public UsServerPatternCache(long j, StaticIndex index) {
            Intrinsics.checkNotNullParameter(index, "index");
            this.fetchedAt = j;
            this.index = index;
        }

        public final long getFetchedAt() {
            return this.fetchedAt;
        }

        public final StaticIndex getIndex() {
            return this.index;
        }
    }

    /* JADX INFO: compiled from: GlobalSubwayData.kt */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0081\b\u0018\u00002\u00020\u0001Bi\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0012\u0018\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00070\u0003\u0012\u001e\u0010\b\u001a\u001a\u0012\u0004\u0012\u00020\u0004\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\t0\t0\u0003\u0012\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000b0\u0003¢\u0006\u0004\b\f\u0010\rJ\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00040\u00072\u0006\u0010\u0014\u001a\u00020\u0004J\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0014\u001a\u00020\u0004J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u0004J\u0015\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003HÆ\u0003J\u001b\u0010\u0018\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00070\u0003HÆ\u0003J!\u0010\u0019\u001a\u001a\u0012\u0004\u0012\u00020\u0004\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\t0\t0\u0003HÆ\u0003J\u0015\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000b0\u0003HÆ\u0003Js\u0010\u001b\u001a\u00020\u00002\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\u001a\b\u0002\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00070\u00032 \b\u0002\u0010\b\u001a\u001a\u0012\u0004\u0012\u00020\u0004\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\t0\t0\u00032\u0014\b\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000b0\u0003HÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\u0004HÖ\u0001R\u001d\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR#\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00070\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR)\u0010\b\u001a\u001a\u0012\u0004\u0012\u00020\u0004\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\t0\t0\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u001d\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000b0\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000f¨\u0006\""}, d2 = {"Lcom/example/tickets/GlobalSubwayDataManager$StaticIndex;", "", "stationsByKey", "", "", "Lcom/example/tickets/GlobalSubwayDataManager$SubwayStationOption;", "routeByStation", "", "routePatterns", "", "routeInfo", "Lcom/example/tickets/GlobalSubwayDataManager$SubwayRouteInfo;", "<init>", "(Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;)V", "getStationsByKey", "()Ljava/util/Map;", "getRouteByStation", "getRoutePatterns", "getRouteInfo", "routesForStation", "key", "stationOption", "routeId", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class StaticIndex {
        public static final int $stable = 8;
        private final Map<String, Set<String>> routeByStation;
        private final Map<String, SubwayRouteInfo> routeInfo;
        private final Map<String, List<List<String>>> routePatterns;
        private final Map<String, SubwayStationOption> stationsByKey;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ StaticIndex copy$default(StaticIndex staticIndex, Map map, Map map2, Map map3, Map map4, int i, Object obj) {
            if ((i & 1) != 0) {
                map = staticIndex.stationsByKey;
            }
            if ((i & 2) != 0) {
                map2 = staticIndex.routeByStation;
            }
            if ((i & 4) != 0) {
                map3 = staticIndex.routePatterns;
            }
            if ((i & 8) != 0) {
                map4 = staticIndex.routeInfo;
            }
            return staticIndex.copy(map, map2, map3, map4);
        }

        public final Map<String, SubwayStationOption> component1() {
            return this.stationsByKey;
        }

        public final Map<String, Set<String>> component2() {
            return this.routeByStation;
        }

        public final Map<String, List<List<String>>> component3() {
            return this.routePatterns;
        }

        public final Map<String, SubwayRouteInfo> component4() {
            return this.routeInfo;
        }

        public final StaticIndex copy(Map<String, SubwayStationOption> stationsByKey, Map<String, ? extends Set<String>> routeByStation, Map<String, ? extends List<? extends List<String>>> routePatterns, Map<String, SubwayRouteInfo> routeInfo) {
            Intrinsics.checkNotNullParameter(stationsByKey, "stationsByKey");
            Intrinsics.checkNotNullParameter(routeByStation, "routeByStation");
            Intrinsics.checkNotNullParameter(routePatterns, "routePatterns");
            Intrinsics.checkNotNullParameter(routeInfo, "routeInfo");
            return new StaticIndex(stationsByKey, routeByStation, routePatterns, routeInfo);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StaticIndex)) {
                return false;
            }
            StaticIndex staticIndex = (StaticIndex) other;
            return Intrinsics.areEqual(this.stationsByKey, staticIndex.stationsByKey) && Intrinsics.areEqual(this.routeByStation, staticIndex.routeByStation) && Intrinsics.areEqual(this.routePatterns, staticIndex.routePatterns) && Intrinsics.areEqual(this.routeInfo, staticIndex.routeInfo);
        }

        public int hashCode() {
            return (((((this.stationsByKey.hashCode() * 31) + this.routeByStation.hashCode()) * 31) + this.routePatterns.hashCode()) * 31) + this.routeInfo.hashCode();
        }

        public String toString() {
            return "StaticIndex(stationsByKey=" + this.stationsByKey + ", routeByStation=" + this.routeByStation + ", routePatterns=" + this.routePatterns + ", routeInfo=" + this.routeInfo + ")";
        }

        /* JADX WARN: Multi-variable type inference failed */
        public StaticIndex(Map<String, SubwayStationOption> stationsByKey, Map<String, ? extends Set<String>> routeByStation, Map<String, ? extends List<? extends List<String>>> routePatterns, Map<String, SubwayRouteInfo> routeInfo) {
            Intrinsics.checkNotNullParameter(stationsByKey, "stationsByKey");
            Intrinsics.checkNotNullParameter(routeByStation, "routeByStation");
            Intrinsics.checkNotNullParameter(routePatterns, "routePatterns");
            Intrinsics.checkNotNullParameter(routeInfo, "routeInfo");
            this.stationsByKey = stationsByKey;
            this.routeByStation = routeByStation;
            this.routePatterns = routePatterns;
            this.routeInfo = routeInfo;
        }

        public final Map<String, SubwayStationOption> getStationsByKey() {
            return this.stationsByKey;
        }

        public final Map<String, Set<String>> getRouteByStation() {
            return this.routeByStation;
        }

        public final Map<String, List<List<String>>> getRoutePatterns() {
            return this.routePatterns;
        }

        public final Map<String, SubwayRouteInfo> getRouteInfo() {
            return this.routeInfo;
        }

        public final Set<String> routesForStation(String key) {
            Intrinsics.checkNotNullParameter(key, "key");
            Set<String> set = this.routeByStation.get(key);
            return set == null ? SetsKt.emptySet() : set;
        }

        public final SubwayStationOption stationOption(String key) {
            Intrinsics.checkNotNullParameter(key, "key");
            return this.stationsByKey.get(key);
        }

        public final SubwayRouteInfo routeInfo(String routeId) {
            Intrinsics.checkNotNullParameter(routeId, "routeId");
            SubwayRouteInfo subwayRouteInfo = this.routeInfo.get(routeId);
            return subwayRouteInfo == null ? new SubwayRouteInfo(routeId, StringsKt.substringAfterLast$default(routeId, ':', (String) null, 2, (Object) null), "", GlobalSubwayDataManager.FALLBACK_ROUTE_COLOR) : subwayRouteInfo;
        }
    }

    static {
        GlobalSubwayDataManager globalSubwayDataManager = new GlobalSubwayDataManager();
        INSTANCE = globalSubwayDataManager;
        SERVER_PATTERN_US_CITY_IDS = SetsKt.setOf((Object[]) new String[]{"nyc", "washington_dc", "boston", "philadelphia", "chicago", "san_francisco_bay", "los_angeles"});
        cacheLock = new Object();
        memoryIndexes = new ConcurrentHashMap<>();
        usServerPatternCaches = new ConcurrentHashMap<>();
        cityCatalog = CollectionsKt.listOf((Object[]) new SubwayCity[]{city$default(globalSubwayDataManager, "wuhan", "武汉", "Wuhan", "中国", "4201", "wuhan", null, null, null, 448, null), city$default(globalSubwayDataManager, "shenzhen", "深圳", "Shenzhen", "中国", "4403", "shenzhen", null, null, null, 448, null), city$default(globalSubwayDataManager, "guangzhou", "广州", "Guangzhou", "中国", "4401", "guangzhou", null, null, null, 448, null), city$default(globalSubwayDataManager, "shanghai", "上海", "Shanghai", "中国", "3100", "shanghai", null, null, null, 448, null), city$default(globalSubwayDataManager, "beijing", "北京", "Beijing", "中国", "1100", "beijing", null, null, null, 448, null), city$default(globalSubwayDataManager, "tianjin", "天津", "Tianjin", "中国", "1200", "tianjin", null, null, null, 448, null), city$default(globalSubwayDataManager, "nanjing", "南京", "Nanjing", "中国", "3201", "nanjing", null, null, null, 448, null), city$default(globalSubwayDataManager, "chongqing", "重庆", "Chongqing", "中国", "5000", "chongqing", null, null, null, 448, null), city$default(globalSubwayDataManager, "hangzhou", "杭州", "Hangzhou", "中国", "3301", "hangzhou", null, null, null, 448, null), city$default(globalSubwayDataManager, "chengdu", "成都", "Chengdu", "中国", "5101", "chengdu", null, null, null, 448, null), city$default(globalSubwayDataManager, "shenyang", "沈阳", "Shenyang", "中国", "2101", "shenyang", null, null, null, 448, null), city$default(globalSubwayDataManager, "dalian", "大连", "Dalian", "中国", "2102", "dalian", null, null, null, 448, null), city$default(globalSubwayDataManager, "changchun", "长春", "Changchun", "中国", "2201", "changchun", null, null, null, 448, null), city$default(globalSubwayDataManager, "suzhou", "苏州", "Suzhou", "中国", "3205", "suzhou", null, null, null, 448, null), city$default(globalSubwayDataManager, "foshan", "佛山", "Foshan", "中国", "4406", "foshan", null, null, null, 448, null), city$default(globalSubwayDataManager, "kunming", "昆明", "Kunming", "中国", "5301", "kunming", null, null, null, 448, null), city$default(globalSubwayDataManager, "xian", "西安", "Xi'an", "中国", "6101", "xian", null, null, null, 448, null), city$default(globalSubwayDataManager, "zhengzhou", "郑州", "Zhengzhou", "中国", "4101", "zhengzhou", null, null, null, 448, null), city$default(globalSubwayDataManager, "changsha", "长沙", "Changsha", "中国", "4301", "changsha", null, null, null, 448, null), city$default(globalSubwayDataManager, "ningbo", "宁波", "Ningbo", "中国", "3302", "ningbo", null, null, null, 448, null), city$default(globalSubwayDataManager, "wuxi", "无锡", "Wuxi", "中国", "3202", "wuxi", null, null, null, 448, null), city$default(globalSubwayDataManager, "qingdao", "青岛", "Qingdao", "中国", "3702", "qingdao", null, null, null, 448, null), city$default(globalSubwayDataManager, "nanchang", "南昌", "Nanchang", "中国", "3601", "nanchang", null, null, null, 448, null), city$default(globalSubwayDataManager, "fuzhou", "福州", "Fuzhou", "中国", "3501", "fuzhou", null, null, null, 448, null), city$default(globalSubwayDataManager, "dongguan", "东莞", "Dongguan", "中国", "4419", "dongguan", null, null, null, 448, null), city$default(globalSubwayDataManager, "nanning", "南宁", "Nanning", "中国", "4501", "nanning", null, null, null, 448, null), city$default(globalSubwayDataManager, "hefei", "合肥", "Hefei", "中国", "3401", "hefei", null, null, null, 448, null), city$default(globalSubwayDataManager, "guiyang", "贵阳", "Guiyang", "中国", "5201", "guiyang", null, null, null, 448, null), city$default(globalSubwayDataManager, "xiamen", "厦门", "Xiamen", "中国", "3502", "xiamen", null, null, null, 448, null), city$default(globalSubwayDataManager, "harbin", "哈尔滨", "Harbin", "中国", "2301", "haerbin", null, null, null, 448, null), city$default(globalSubwayDataManager, "shijiazhuang", "石家庄", "Shijiazhuang", "中国", "1301", "shijiazhuang", null, null, null, 448, null), city$default(globalSubwayDataManager, "urumqi", "乌鲁木齐", "Urumqi", "中国", "6501", "wulumuqi", null, null, null, 448, null), city$default(globalSubwayDataManager, "wenzhou", "温州", "Wenzhou", "中国", "3303", "wenzhou", null, null, null, 448, null), city$default(globalSubwayDataManager, "jinan", "济南", "Jinan", "中国", "3701", "jinan", null, null, null, 448, null), city$default(globalSubwayDataManager, "lanzhou", "兰州", "Lanzhou", "中国", "6201", "lanzhou", null, null, null, 448, null), city$default(globalSubwayDataManager, "changzhou", "常州", "Changzhou", "中国", "3204", "changzhou", null, null, null, 448, null), city$default(globalSubwayDataManager, "xuzhou", "徐州", "Xuzhou", "中国", "3203", "xuzhou", null, null, null, 448, null), city$default(globalSubwayDataManager, "huhehaote", "呼和浩特", "Hohhot", "中国", "1501", "huhehaote", null, null, null, 448, null), city$default(globalSubwayDataManager, "hong_kong", "香港", "Hong Kong", "中国香港", "8100", "xianggang", SourceType.AMAP, null, null, 384, null), city$default(globalSubwayDataManager, "taipei", "台北", "Taipei", "中国台湾", null, null, SourceType.TAIWAN_TDX, null, null, 432, null), globalSubwayDataManager.localUsCity("nyc", "纽约", "New York", "subway/us/nyc.json.gz", "", SetsKt.setOf(1)), globalSubwayDataManager.localUsCity("washington_dc", "华盛顿", "Washington, DC", "subway/us/washington_dc.json.gz", "", SetsKt.setOf(1)), globalSubwayDataManager.localUsCity("boston", "波士顿", "Boston", "subway/us/boston.json.gz", "", SetsKt.setOf((Object[]) new Integer[]{0, 1})), globalSubwayDataManager.localUsCity("philadelphia", "费城", "Philadelphia", "subway/us/philadelphia.json.gz", "", SetsKt.setOf((Object[]) new Integer[]{0, 1})), globalSubwayDataManager.localUsCity("chicago", "芝加哥", "Chicago", "subway/us/chicago.json.gz", "", SetsKt.setOf(1)), globalSubwayDataManager.localUsCity("san_francisco_bay", "旧金山湾区", "San Francisco Bay Area", "subway/us/san_francisco_bay.json.gz", "", SetsKt.setOf(1)), globalSubwayDataManager.localUsCity("los_angeles", "洛杉矶", "Los Angeles", "subway/us/los_angeles.json.gz", "", SetsKt.setOf((Object[]) new Integer[]{0, 1}))});
        $stable = 8;
    }

    static /* synthetic */ SubwayCity city$default(GlobalSubwayDataManager globalSubwayDataManager, String str, String str2, String str3, String str4, String str5, String str6, SourceType sourceType, String str7, String str8, int i, Object obj) {
        if ((i & 16) != 0) {
            str5 = "";
        }
        if ((i & 32) != 0) {
            str6 = "";
        }
        if ((i & 64) != 0) {
            sourceType = SourceType.AMAP;
        }
        if ((i & 128) != 0) {
            str7 = "";
        }
        if ((i & 256) != 0) {
            str8 = "";
        }
        return globalSubwayDataManager.city(str, str2, str3, str4, str5, str6, sourceType, str7, str8);
    }

    private final SubwayCity city(String id, String nameZh, String nameEn, String country, String code, String slug, SourceType sourceType, String sourceUrl, String localAssetPath) {
        return new SubwayCity(id, nameZh, nameEn, country, sourceType, sourceUrl, code, slug, localAssetPath, null, null, 1536, null);
    }

    private final SubwayCity localUsCity(String id, String nameZh, String nameEn, String assetPath, String staticGtfsUrl, Set<Integer> gtfsRouteTypes) {
        return new SubwayCity(id, nameZh, nameEn, "美国", SourceType.LOCAL_US, null, null, null, assetPath, staticGtfsUrl, gtfsRouteTypes, 224, null);
    }

    public final List<SubwayCity> allCities() {
        return cityCatalog;
    }

    public final List<SubwayCity> chinaCities() {
        List<SubwayCity> list = cityCatalog;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (StringsKt.startsWith$default(((SubwayCity) obj).getCountry(), "中国", false, 2, (Object) null)) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public final List<SubwayCity> americanCities() {
        List<SubwayCity> list = cityCatalog;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (Intrinsics.areEqual(((SubwayCity) obj).getCountry(), "美国")) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public final SubwayCity cityOrNull(String cityId) {
        Object next;
        Intrinsics.checkNotNullParameter(cityId, "cityId");
        Iterator<T> it = cityCatalog.iterator();
        while (it.hasNext()) {
            next = it.next();
            if (Intrinsics.areEqual(((SubwayCity) next).getId(), cityId)) {
                return (SubwayCity) next;
            }
        }
        next = null;
        return (SubwayCity) next;
    }

    public final String cityName(String cityId) {
        String nameZh;
        Intrinsics.checkNotNullParameter(cityId, "cityId");
        SubwayCity subwayCityCityOrNull = cityOrNull(cityId);
        return (subwayCityCityOrNull == null || (nameZh = subwayCityCityOrNull.getNameZh()) == null) ? cityId : nameZh;
    }

    public static /* synthetic */ Object searchStations$default(GlobalSubwayDataManager globalSubwayDataManager, Context context, String str, String str2, int i, Continuation continuation, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            i = 12;
        }
        return globalSubwayDataManager.searchStations(context, str, str2, i, continuation);
    }

    /* JADX INFO: renamed from: com.example.tickets.GlobalSubwayDataManager$searchStations$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: GlobalSubwayData.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "Lcom/example/tickets/GlobalSubwayDataManager$SubwayStationOption;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.tickets.GlobalSubwayDataManager$searchStations$2", f = "GlobalSubwayData.kt", i = {0, 1}, l = {366, 375}, m = "invokeSuspend", n = {"city", "city"}, s = {"L$0", "L$0"})
    static final class C03392 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends SubwayStationOption>>, Object> {
        final /* synthetic */ String $cityId;
        final /* synthetic */ Context $context;
        final /* synthetic */ int $limit;
        final /* synthetic */ String $query;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C03392(String str, Context context, String str2, int i, Continuation<? super C03392> continuation) {
            super(2, continuation);
            this.$cityId = str;
            this.$context = context;
            this.$query = str2;
            this.$limit = i;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C03392(this.$cityId, this.$context, this.$query, this.$limit, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends SubwayStationOption>> continuation) {
            return invoke2(coroutineScope, (Continuation<? super List<SubwayStationOption>>) continuation);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super List<SubwayStationOption>> continuation) {
            return ((C03392) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:24:0x0082, code lost:
        
            if (r11 == r0) goto L25;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) throws Throwable {
            StaticIndex staticIndexLoadOrBuildIndex$app;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                SubwayCity subwayCityCityOrNull = GlobalSubwayDataManager.INSTANCE.cityOrNull(this.$cityId);
                if (subwayCityCityOrNull == null) {
                    return CollectionsKt.emptyList();
                }
                if (subwayCityCityOrNull.getSourceType() != SourceType.GOOGLE) {
                    if (GlobalSubwayDataManager.SERVER_PATTERN_US_CITY_IDS.contains(this.$cityId)) {
                        this.L$0 = SpillingKt.nullOutSpilledVariable(subwayCityCityOrNull);
                        this.label = 2;
                        obj = GlobalSubwayDataManager.INSTANCE.loadUsServerRoutingIndex(this.$context, this.$cityId, this);
                    } else {
                        staticIndexLoadOrBuildIndex$app = GlobalSubwayDataManager.INSTANCE.loadOrBuildIndex$app(this.$context, this.$cityId);
                    }
                    final String strNormalizeStationSearch = GlobalSubwayDataManager.INSTANCE.normalizeStationSearch(this.$query);
                    Sequence sequenceAsSequence = CollectionsKt.asSequence(staticIndexLoadOrBuildIndex$app.getStationsByKey().values());
                    final String str = this.$query;
                    Sequence sequenceFilter = SequencesKt.filter(sequenceAsSequence, new Function1() { // from class: com.example.tickets.GlobalSubwayDataManager$searchStations$2$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return Boolean.valueOf(GlobalSubwayDataManager.C03392.invokeSuspend$lambda$1(strNormalizeStationSearch, str, (GlobalSubwayDataManager.SubwayStationOption) obj2));
                        }
                    });
                    final Comparator comparator = new Comparator() { // from class: com.example.tickets.GlobalSubwayDataManager$searchStations$2$invokeSuspend$$inlined$compareBy$1
                        /* JADX WARN: Code duplicated, block: B:21:0x0080  */
                        /* JADX WARN: Code duplicated, block: B:22:0x0084  */
                        /* JADX WARN: Code duplicated, block: B:27:0x0098  */
                        /* JADX WARN: Code duplicated, block: B:30:0x00a2  */
                        /* JADX WARN: Code duplicated, block: B:53:0x012c  */
                        /* JADX WARN: Code duplicated, block: B:54:0x0130  */
                        /* JADX WARN: Code duplicated, block: B:59:0x0144  */
                        /* JADX WARN: Code duplicated, block: B:62:0x014e  */
                        /* JADX WARN: Code duplicated, block: B:69:0x0162 A[SYNTHETIC] */
                        /* JADX WARN: Code duplicated, block: B:70:? A[LOOP:0: B:60:0x0148->B:70:?, LOOP_END, SYNTHETIC] */
                        /* JADX WARN: Code duplicated, block: B:74:0x00ba A[SYNTHETIC] */
                        /* JADX WARN: Code duplicated, block: B:75:0x00b6 A[SYNTHETIC] */
                        /* JADX WARN: Code duplicated, block: B:76:? A[LOOP:2: B:28:0x009c->B:76:?, LOOP_END, SYNTHETIC] */
                        /* JADX WARN: Multi-variable type inference failed */
                        @Override // java.util.Comparator
                        public final int compare(T t, T t2) {
                            Integer num;
                            List<String> searchNames;
                            Iterator<T> it;
                            Integer num2;
                            List<String> searchNames2;
                            Iterator<T> it2;
                            GlobalSubwayDataManager.SubwayStationOption subwayStationOption = (GlobalSubwayDataManager.SubwayStationOption) t;
                            if (!StringsKt.isBlank(strNormalizeStationSearch)) {
                                if (Intrinsics.areEqual(GlobalSubwayDataManager.INSTANCE.normalizeStationSearch(subwayStationOption.getName()), strNormalizeStationSearch)) {
                                    num = (Comparable) 0;
                                } else {
                                    List<String> searchNames3 = subwayStationOption.getSearchNames();
                                    if ((searchNames3 instanceof Collection) && searchNames3.isEmpty()) {
                                        if (StringsKt.startsWith$default(GlobalSubwayDataManager.INSTANCE.normalizeStationSearch(subwayStationOption.getName()), strNormalizeStationSearch, false, 2, (Object) null)) {
                                            num = (Comparable) 1;
                                        } else {
                                            searchNames = subwayStationOption.getSearchNames();
                                            if (searchNames instanceof Collection) {
                                                it = searchNames.iterator();
                                                while (true) {
                                                    if (it.hasNext()) {
                                                        if (StringsKt.startsWith$default(GlobalSubwayDataManager.INSTANCE.normalizeStationSearch((String) it.next()), strNormalizeStationSearch, false, 2, (Object) null)) {
                                                            num = (Comparable) 1;
                                                            break;
                                                        }
                                                    } else {
                                                        num = (Comparable) 2;
                                                        break;
                                                    }
                                                }
                                            } else {
                                                it = searchNames.iterator();
                                                while (true) {
                                                    if (it.hasNext()) {
                                                        if (StringsKt.startsWith$default(GlobalSubwayDataManager.INSTANCE.normalizeStationSearch((String) it.next()), strNormalizeStationSearch, false, 2, (Object) null)) {
                                                            num = (Comparable) 1;
                                                            break;
                                                        }
                                                    } else {
                                                        num = (Comparable) 2;
                                                        break;
                                                    }
                                                }
                                            }
                                        }
                                    } else {
                                        Iterator<T> it3 = searchNames3.iterator();
                                        while (true) {
                                            if (it3.hasNext()) {
                                                if (Intrinsics.areEqual(GlobalSubwayDataManager.INSTANCE.normalizeStationSearch((String) it3.next()), strNormalizeStationSearch)) {
                                                    num = (Comparable) 0;
                                                }
                                            } else if (StringsKt.startsWith$default(GlobalSubwayDataManager.INSTANCE.normalizeStationSearch(subwayStationOption.getName()), strNormalizeStationSearch, false, 2, (Object) null)) {
                                                num = (Comparable) 1;
                                            } else {
                                                searchNames = subwayStationOption.getSearchNames();
                                                if ((searchNames instanceof Collection) || !searchNames.isEmpty()) {
                                                    it = searchNames.iterator();
                                                    while (true) {
                                                        if (it.hasNext()) {
                                                            if (StringsKt.startsWith$default(GlobalSubwayDataManager.INSTANCE.normalizeStationSearch((String) it.next()), strNormalizeStationSearch, false, 2, (Object) null)) {
                                                                num = (Comparable) 1;
                                                                break;
                                                            }
                                                        } else {
                                                            num = (Comparable) 2;
                                                            break;
                                                        }
                                                    }
                                                } else {
                                                    num = (Comparable) 2;
                                                    break;
                                                }
                                            }
                                        }
                                    }
                                }
                            } else {
                                num = (Comparable) 2;
                            }
                            GlobalSubwayDataManager.SubwayStationOption subwayStationOption2 = (GlobalSubwayDataManager.SubwayStationOption) t2;
                            if (!StringsKt.isBlank(strNormalizeStationSearch)) {
                                if (Intrinsics.areEqual(GlobalSubwayDataManager.INSTANCE.normalizeStationSearch(subwayStationOption2.getName()), strNormalizeStationSearch)) {
                                    num2 = (Comparable) 0;
                                } else {
                                    List<String> searchNames4 = subwayStationOption2.getSearchNames();
                                    if ((searchNames4 instanceof Collection) && searchNames4.isEmpty()) {
                                        if (StringsKt.startsWith$default(GlobalSubwayDataManager.INSTANCE.normalizeStationSearch(subwayStationOption2.getName()), strNormalizeStationSearch, false, 2, (Object) null)) {
                                            num2 = (Comparable) 1;
                                        } else {
                                            searchNames2 = subwayStationOption2.getSearchNames();
                                            if (searchNames2 instanceof Collection) {
                                                it2 = searchNames2.iterator();
                                                while (it2.hasNext()) {
                                                    if (StringsKt.startsWith$default(GlobalSubwayDataManager.INSTANCE.normalizeStationSearch((String) it2.next()), strNormalizeStationSearch, false, 2, (Object) null)) {
                                                        num2 = (Comparable) 1;
                                                    }
                                                }
                                                num2 = (Comparable) 2;
                                            } else {
                                                it2 = searchNames2.iterator();
                                                while (it2.hasNext()) {
                                                    if (StringsKt.startsWith$default(GlobalSubwayDataManager.INSTANCE.normalizeStationSearch((String) it2.next()), strNormalizeStationSearch, false, 2, (Object) null)) {
                                                        num2 = (Comparable) 1;
                                                    }
                                                }
                                                num2 = (Comparable) 2;
                                            }
                                        }
                                    } else {
                                        Iterator<T> it4 = searchNames4.iterator();
                                        while (it4.hasNext()) {
                                            if (Intrinsics.areEqual(GlobalSubwayDataManager.INSTANCE.normalizeStationSearch((String) it4.next()), strNormalizeStationSearch)) {
                                                num2 = (Comparable) 0;
                                            }
                                        }
                                        if (StringsKt.startsWith$default(GlobalSubwayDataManager.INSTANCE.normalizeStationSearch(subwayStationOption2.getName()), strNormalizeStationSearch, false, 2, (Object) null)) {
                                            num2 = (Comparable) 1;
                                        } else {
                                            searchNames2 = subwayStationOption2.getSearchNames();
                                            if ((searchNames2 instanceof Collection) || !searchNames2.isEmpty()) {
                                                it2 = searchNames2.iterator();
                                                while (it2.hasNext()) {
                                                    if (StringsKt.startsWith$default(GlobalSubwayDataManager.INSTANCE.normalizeStationSearch((String) it2.next()), strNormalizeStationSearch, false, 2, (Object) null)) {
                                                        num2 = (Comparable) 1;
                                                    }
                                                }
                                                num2 = (Comparable) 2;
                                            } else {
                                                num2 = (Comparable) 2;
                                            }
                                        }
                                    }
                                }
                            } else {
                                num2 = (Comparable) 2;
                            }
                            return ComparisonsKt.compareValues(num, num2);
                        }
                    };
                    return SequencesKt.toList(SequencesKt.take(SequencesKt.sortedWith(sequenceFilter, new Comparator() { // from class: com.example.tickets.GlobalSubwayDataManager$searchStations$2$invokeSuspend$$inlined$thenBy$1
                        /* JADX WARN: Multi-variable type inference failed */
                        @Override // java.util.Comparator
                        public final int compare(T t, T t2) {
                            int iCompare = comparator.compare(t, t2);
                            return iCompare != 0 ? iCompare : ComparisonsKt.compareValues(((GlobalSubwayDataManager.SubwayStationOption) t).getName(), ((GlobalSubwayDataManager.SubwayStationOption) t2).getName());
                        }
                    }), RangesKt.coerceIn(this.$limit, 1, 50)));
                }
                this.L$0 = SpillingKt.nullOutSpilledVariable(subwayCityCityOrNull);
                this.label = 1;
                Object objGoogleSearchStations = GlobalSubwayDataManager.INSTANCE.googleSearchStations(this.$context, subwayCityCityOrNull, this.$query, RangesKt.coerceIn(this.$limit, 1, 20), this);
                if (objGoogleSearchStations != coroutine_suspended) {
                    return objGoogleSearchStations;
                }
                return coroutine_suspended;
            }
            if (i == 1) {
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            staticIndexLoadOrBuildIndex$app = (StaticIndex) obj;
            if (staticIndexLoadOrBuildIndex$app == null) {
                staticIndexLoadOrBuildIndex$app = GlobalSubwayDataManager.INSTANCE.loadOrBuildIndex$app(this.$context, this.$cityId);
            }
            final String strNormalizeStationSearch2 = GlobalSubwayDataManager.INSTANCE.normalizeStationSearch(this.$query);
            Sequence sequenceAsSequence2 = CollectionsKt.asSequence(staticIndexLoadOrBuildIndex$app.getStationsByKey().values());
            final String str2 = this.$query;
            Sequence sequenceFilter2 = SequencesKt.filter(sequenceAsSequence2, new Function1() { // from class: com.example.tickets.GlobalSubwayDataManager$searchStations$2$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return Boolean.valueOf(GlobalSubwayDataManager.C03392.invokeSuspend$lambda$1(strNormalizeStationSearch2, str2, (GlobalSubwayDataManager.SubwayStationOption) obj2));
                }
            });
            final Comparator comparator2 = new Comparator() { // from class: com.example.tickets.GlobalSubwayDataManager$searchStations$2$invokeSuspend$$inlined$compareBy$1
                /* JADX WARN: Code duplicated, block: B:21:0x0080  */
                /* JADX WARN: Code duplicated, block: B:22:0x0084  */
                /* JADX WARN: Code duplicated, block: B:27:0x0098  */
                /* JADX WARN: Code duplicated, block: B:30:0x00a2  */
                /* JADX WARN: Code duplicated, block: B:53:0x012c  */
                /* JADX WARN: Code duplicated, block: B:54:0x0130  */
                /* JADX WARN: Code duplicated, block: B:59:0x0144  */
                /* JADX WARN: Code duplicated, block: B:62:0x014e  */
                /* JADX WARN: Code duplicated, block: B:69:0x0162 A[SYNTHETIC] */
                /* JADX WARN: Code duplicated, block: B:70:? A[LOOP:0: B:60:0x0148->B:70:?, LOOP_END, SYNTHETIC] */
                /* JADX WARN: Code duplicated, block: B:74:0x00ba A[SYNTHETIC] */
                /* JADX WARN: Code duplicated, block: B:75:0x00b6 A[SYNTHETIC] */
                /* JADX WARN: Code duplicated, block: B:76:? A[LOOP:2: B:28:0x009c->B:76:?, LOOP_END, SYNTHETIC] */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    Integer num;
                    List<String> searchNames;
                    Iterator<T> it;
                    Integer num2;
                    List<String> searchNames2;
                    Iterator<T> it2;
                    GlobalSubwayDataManager.SubwayStationOption subwayStationOption = (GlobalSubwayDataManager.SubwayStationOption) t;
                    if (!StringsKt.isBlank(strNormalizeStationSearch2)) {
                        if (Intrinsics.areEqual(GlobalSubwayDataManager.INSTANCE.normalizeStationSearch(subwayStationOption.getName()), strNormalizeStationSearch2)) {
                            num = (Comparable) 0;
                        } else {
                            List<String> searchNames3 = subwayStationOption.getSearchNames();
                            if ((searchNames3 instanceof Collection) && searchNames3.isEmpty()) {
                                if (StringsKt.startsWith$default(GlobalSubwayDataManager.INSTANCE.normalizeStationSearch(subwayStationOption.getName()), strNormalizeStationSearch2, false, 2, (Object) null)) {
                                    num = (Comparable) 1;
                                } else {
                                    searchNames = subwayStationOption.getSearchNames();
                                    if (searchNames instanceof Collection) {
                                        it = searchNames.iterator();
                                        while (true) {
                                            if (it.hasNext()) {
                                                if (StringsKt.startsWith$default(GlobalSubwayDataManager.INSTANCE.normalizeStationSearch((String) it.next()), strNormalizeStationSearch2, false, 2, (Object) null)) {
                                                    num = (Comparable) 1;
                                                    break;
                                                }
                                            } else {
                                                num = (Comparable) 2;
                                                break;
                                            }
                                        }
                                    } else {
                                        it = searchNames.iterator();
                                        while (true) {
                                            if (it.hasNext()) {
                                                if (StringsKt.startsWith$default(GlobalSubwayDataManager.INSTANCE.normalizeStationSearch((String) it.next()), strNormalizeStationSearch2, false, 2, (Object) null)) {
                                                    num = (Comparable) 1;
                                                    break;
                                                }
                                            } else {
                                                num = (Comparable) 2;
                                                break;
                                            }
                                        }
                                    }
                                }
                            } else {
                                Iterator<T> it3 = searchNames3.iterator();
                                while (true) {
                                    if (it3.hasNext()) {
                                        if (Intrinsics.areEqual(GlobalSubwayDataManager.INSTANCE.normalizeStationSearch((String) it3.next()), strNormalizeStationSearch2)) {
                                            num = (Comparable) 0;
                                        }
                                    } else if (StringsKt.startsWith$default(GlobalSubwayDataManager.INSTANCE.normalizeStationSearch(subwayStationOption.getName()), strNormalizeStationSearch2, false, 2, (Object) null)) {
                                        num = (Comparable) 1;
                                    } else {
                                        searchNames = subwayStationOption.getSearchNames();
                                        if ((searchNames instanceof Collection) || !searchNames.isEmpty()) {
                                            it = searchNames.iterator();
                                            while (true) {
                                                if (it.hasNext()) {
                                                    if (StringsKt.startsWith$default(GlobalSubwayDataManager.INSTANCE.normalizeStationSearch((String) it.next()), strNormalizeStationSearch2, false, 2, (Object) null)) {
                                                        num = (Comparable) 1;
                                                        break;
                                                    }
                                                } else {
                                                    num = (Comparable) 2;
                                                    break;
                                                }
                                            }
                                        } else {
                                            num = (Comparable) 2;
                                            break;
                                        }
                                    }
                                }
                            }
                        }
                    } else {
                        num = (Comparable) 2;
                    }
                    GlobalSubwayDataManager.SubwayStationOption subwayStationOption2 = (GlobalSubwayDataManager.SubwayStationOption) t2;
                    if (!StringsKt.isBlank(strNormalizeStationSearch2)) {
                        if (Intrinsics.areEqual(GlobalSubwayDataManager.INSTANCE.normalizeStationSearch(subwayStationOption2.getName()), strNormalizeStationSearch2)) {
                            num2 = (Comparable) 0;
                        } else {
                            List<String> searchNames4 = subwayStationOption2.getSearchNames();
                            if ((searchNames4 instanceof Collection) && searchNames4.isEmpty()) {
                                if (StringsKt.startsWith$default(GlobalSubwayDataManager.INSTANCE.normalizeStationSearch(subwayStationOption2.getName()), strNormalizeStationSearch2, false, 2, (Object) null)) {
                                    num2 = (Comparable) 1;
                                } else {
                                    searchNames2 = subwayStationOption2.getSearchNames();
                                    if (searchNames2 instanceof Collection) {
                                        it2 = searchNames2.iterator();
                                        while (it2.hasNext()) {
                                            if (StringsKt.startsWith$default(GlobalSubwayDataManager.INSTANCE.normalizeStationSearch((String) it2.next()), strNormalizeStationSearch2, false, 2, (Object) null)) {
                                                num2 = (Comparable) 1;
                                            }
                                        }
                                        num2 = (Comparable) 2;
                                    } else {
                                        it2 = searchNames2.iterator();
                                        while (it2.hasNext()) {
                                            if (StringsKt.startsWith$default(GlobalSubwayDataManager.INSTANCE.normalizeStationSearch((String) it2.next()), strNormalizeStationSearch2, false, 2, (Object) null)) {
                                                num2 = (Comparable) 1;
                                            }
                                        }
                                        num2 = (Comparable) 2;
                                    }
                                }
                            } else {
                                Iterator<T> it4 = searchNames4.iterator();
                                while (it4.hasNext()) {
                                    if (Intrinsics.areEqual(GlobalSubwayDataManager.INSTANCE.normalizeStationSearch((String) it4.next()), strNormalizeStationSearch2)) {
                                        num2 = (Comparable) 0;
                                    }
                                }
                                if (StringsKt.startsWith$default(GlobalSubwayDataManager.INSTANCE.normalizeStationSearch(subwayStationOption2.getName()), strNormalizeStationSearch2, false, 2, (Object) null)) {
                                    num2 = (Comparable) 1;
                                } else {
                                    searchNames2 = subwayStationOption2.getSearchNames();
                                    if ((searchNames2 instanceof Collection) || !searchNames2.isEmpty()) {
                                        it2 = searchNames2.iterator();
                                        while (it2.hasNext()) {
                                            if (StringsKt.startsWith$default(GlobalSubwayDataManager.INSTANCE.normalizeStationSearch((String) it2.next()), strNormalizeStationSearch2, false, 2, (Object) null)) {
                                                num2 = (Comparable) 1;
                                            }
                                        }
                                        num2 = (Comparable) 2;
                                    } else {
                                        num2 = (Comparable) 2;
                                    }
                                }
                            }
                        }
                    } else {
                        num2 = (Comparable) 2;
                    }
                    return ComparisonsKt.compareValues(num, num2);
                }
            };
            return SequencesKt.toList(SequencesKt.take(SequencesKt.sortedWith(sequenceFilter2, new Comparator() { // from class: com.example.tickets.GlobalSubwayDataManager$searchStations$2$invokeSuspend$$inlined$thenBy$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    int iCompare = comparator2.compare(t, t2);
                    return iCompare != 0 ? iCompare : ComparisonsKt.compareValues(((GlobalSubwayDataManager.SubwayStationOption) t).getName(), ((GlobalSubwayDataManager.SubwayStationOption) t2).getName());
                }
            }), RangesKt.coerceIn(this.$limit, 1, 50)));
        }

        static final boolean invokeSuspend$lambda$1(String str, String str2, SubwayStationOption subwayStationOption) {
            if (StringsKt.isBlank(str) || GlobalSubwayDataManager.INSTANCE.stationNameMatchesSearch(subwayStationOption, str)) {
                return true;
            }
            List<SubwayRouteInfo> routes = subwayStationOption.getRoutes();
            if (!(routes instanceof Collection) || !routes.isEmpty()) {
                Iterator<T> it = routes.iterator();
                while (it.hasNext()) {
                    if (StringsKt.contains$default((CharSequence) GlobalSubwayDataManager.INSTANCE.normalizeSearch(((SubwayRouteInfo) it.next()).getShortName()), (CharSequence) GlobalSubwayDataManager.INSTANCE.normalizeSearch(str2), false, 2, (Object) null)) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    public final Object searchStations(Context context, String str, String str2, int i, Continuation<? super List<SubwayStationOption>> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new C03392(str, context, str2, i, null), continuation);
    }

    public static /* synthetic */ String displayLineBadgeName$app$default(GlobalSubwayDataManager globalSubwayDataManager, String str, String str2, String str3, int i, Object obj) {
        if ((i & 4) != 0) {
            str3 = "";
        }
        return globalSubwayDataManager.displayLineBadgeName$app(str, str2, str3);
    }

    public final String displayLineBadgeName$app(String cityId, String shortName, String routeId) {
        Intrinsics.checkNotNullParameter(cityId, "cityId");
        Intrinsics.checkNotNullParameter(shortName, "shortName");
        Intrinsics.checkNotNullParameter(routeId, "routeId");
        if (Intrinsics.areEqual(cityId, "hong_kong")) {
            String string = StringsKt.trim((CharSequence) shortName).toString();
            Locale ROOT = Locale.ROOT;
            Intrinsics.checkNotNullExpressionValue(ROOT, "ROOT");
            String lowerCase = string.toLowerCase(ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            String strReplace = new Regex("[\\s_\\-–—:/·•()（）]+").replace(StringsKt.replace$default(StringsKt.replace$default(lowerCase, (char) 32171, (char) 32447, false, 4, (Object) null), (char) 32218, (char) 32447, false, 4, (Object) null), "");
            String string2 = StringsKt.trim((CharSequence) routeId).toString();
            Locale ROOT2 = Locale.ROOT;
            Intrinsics.checkNotNullExpressionValue(ROOT2, "ROOT");
            String lowerCase2 = string2.toLowerCase(ROOT2);
            Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
            String strReplace2 = new Regex("[\\s_\\-–—:/·•()（）]+").replace(StringsKt.replace$default(StringsKt.replace$default(lowerCase2, (char) 32171, (char) 32447, false, 4, (Object) null), (char) 32218, (char) 32447, false, 4, (Object) null), "");
            if (Intrinsics.areEqual(strReplace, "机场快线") || Intrinsics.areEqual(strReplace, "airportexpress") || Intrinsics.areEqual(strReplace, "airportexpressline") || Intrinsics.areEqual(strReplace, "ael") || StringsKt.endsWith$default(strReplace2, ":ae", false, 2, (Object) null) || StringsKt.endsWith$default(strReplace2, "ael", false, 2, (Object) null)) {
                return "机场线";
            }
        }
        return shortName;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String normalizedRouteToken(String value) {
        String lowerCase = new Regex("\\s+").replace(StringsKt.replace(StringsKt.removeSuffix(StringsKt.trim((CharSequence) value).toString(), (CharSequence) "号线"), "Line", "", true), "").toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        return lowerCase;
    }

    public final String previousPhysicalStationFromIndex$app(final StaticIndex index, String lineName, String currentKey, String nextKey) {
        int i;
        int i2;
        Intrinsics.checkNotNullParameter(index, "index");
        Intrinsics.checkNotNullParameter(lineName, "lineName");
        Intrinsics.checkNotNullParameter(currentKey, "currentKey");
        final String strNormalizedRouteToken = normalizedRouteToken(lineName);
        List list = CollectionsKt.toList(index.routesForStation(currentKey));
        final Comparator comparator = new Comparator() { // from class: com.example.tickets.GlobalSubwayDataManager$previousPhysicalStationFromIndex$$inlined$compareByDescending$1
            /* JADX WARN: Code duplicated, block: B:11:0x0040  */
            /* JADX WARN: Code duplicated, block: B:21:0x0082  */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                boolean z;
                String strNormalizedRouteToken2 = GlobalSubwayDataManager.INSTANCE.normalizedRouteToken(index.routeInfo((String) t2).getShortName());
                boolean z2 = true;
                if (StringsKt.isBlank(strNormalizedRouteToken)) {
                    z = false;
                } else {
                    if (!Intrinsics.areEqual(strNormalizedRouteToken2, strNormalizedRouteToken)) {
                        String str = strNormalizedRouteToken2;
                        if (!StringsKt.contains$default((CharSequence) str, (CharSequence) strNormalizedRouteToken, false, 2, (Object) null) && !StringsKt.contains$default((CharSequence) strNormalizedRouteToken, (CharSequence) str, false, 2, (Object) null)) {
                            z = false;
                        }
                    }
                    z = true;
                }
                Boolean boolValueOf = Boolean.valueOf(z);
                String strNormalizedRouteToken3 = GlobalSubwayDataManager.INSTANCE.normalizedRouteToken(index.routeInfo((String) t).getShortName());
                if (StringsKt.isBlank(strNormalizedRouteToken)) {
                    z2 = false;
                } else if (!Intrinsics.areEqual(strNormalizedRouteToken3, strNormalizedRouteToken)) {
                    String str2 = strNormalizedRouteToken3;
                    if (!StringsKt.contains$default((CharSequence) str2, (CharSequence) strNormalizedRouteToken, false, 2, (Object) null) && !StringsKt.contains$default((CharSequence) strNormalizedRouteToken, (CharSequence) str2, false, 2, (Object) null)) {
                        z2 = false;
                    }
                }
                return ComparisonsKt.compareValues(boolValueOf, Boolean.valueOf(z2));
            }
        };
        List listSortedWith = CollectionsKt.sortedWith(list, new Comparator() { // from class: com.example.tickets.GlobalSubwayDataManager$previousPhysicalStationFromIndex$$inlined$thenBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                int iCompare = comparator.compare(t, t2);
                return iCompare != 0 ? iCompare : ComparisonsKt.compareValues((String) t, (String) t2);
            }
        });
        Iterator it = listSortedWith.iterator();
        while (it.hasNext()) {
            List<List<String>> listEmptyList = index.getRoutePatterns().get((String) it.next());
            if (listEmptyList == null) {
                listEmptyList = CollectionsKt.emptyList();
            }
            for (List<String> list2 : listEmptyList) {
                int size = list2.size();
                for (int i3 = 0; i3 < size; i3++) {
                    if (Intrinsics.areEqual(list2.get(i3), currentKey)) {
                        if (nextKey != null && (i2 = i3 + 1) < list2.size() && Intrinsics.areEqual(list2.get(i2), nextKey) && i3 > 0) {
                            SubwayStationOption subwayStationOptionStationOption = index.stationOption(list2.get(i3 - 1));
                            String name = subwayStationOptionStationOption != null ? subwayStationOptionStationOption.getName() : null;
                            if (name == null) {
                                name = "";
                            }
                            if (!StringsKt.isBlank(name)) {
                                return name;
                            }
                        }
                        if (nextKey != null && i3 > 0 && Intrinsics.areEqual(list2.get(i3 - 1), nextKey) && (i = i3 + 1) < list2.size()) {
                            SubwayStationOption subwayStationOptionStationOption2 = index.stationOption(list2.get(i));
                            String name2 = subwayStationOptionStationOption2 != null ? subwayStationOptionStationOption2.getName() : null;
                            if (name2 == null) {
                                name2 = "";
                            }
                            if (!StringsKt.isBlank(name2)) {
                                return name2;
                            }
                        }
                    }
                }
            }
        }
        Iterator it2 = listSortedWith.iterator();
        while (it2.hasNext()) {
            List<List<String>> listEmptyList2 = index.getRoutePatterns().get((String) it2.next());
            if (listEmptyList2 == null) {
                listEmptyList2 = CollectionsKt.emptyList();
            }
            for (List<String> list3 : listEmptyList2) {
                int iIndexOf = list3.indexOf(currentKey);
                if (iIndexOf > 0) {
                    SubwayStationOption subwayStationOptionStationOption3 = index.stationOption(list3.get(iIndexOf - 1));
                    String name3 = subwayStationOptionStationOption3 != null ? subwayStationOptionStationOption3.getName() : null;
                    if (name3 == null) {
                        name3 = "";
                    }
                    if (!StringsKt.isBlank(name3)) {
                        return name3;
                    }
                }
            }
        }
        return "";
    }

    public final Object previousPhysicalStationForRoute$app(Context context, String str, String str2, String str3, String str4, Continuation<? super String> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new GlobalSubwayDataManager$previousPhysicalStationForRoute$2(str, context, str3, str4, str2, null), continuation);
    }

    public final List<String> currentStationTransferOptions$app(StaticIndex index, String stationKey, String activeRouteId) {
        List<String> listDistinct;
        List<SubwayRouteInfo> routes;
        Intrinsics.checkNotNullParameter(index, "index");
        Intrinsics.checkNotNullParameter(stationKey, "stationKey");
        Intrinsics.checkNotNullParameter(activeRouteId, "activeRouteId");
        SubwayStationOption subwayStationOptionStationOption = index.stationOption(stationKey);
        if (subwayStationOptionStationOption == null || (routes = subwayStationOptionStationOption.getRoutes()) == null) {
            listDistinct = null;
        } else {
            ArrayList arrayList = new ArrayList();
            for (Object obj : routes) {
                if (!Intrinsics.areEqual(((SubwayRouteInfo) obj).getRouteId(), activeRouteId)) {
                    arrayList.add(obj);
                }
            }
            ArrayList arrayList2 = arrayList;
            ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                arrayList3.add(((SubwayRouteInfo) it.next()).getShortName());
            }
            ArrayList arrayList4 = new ArrayList();
            for (Object obj2 : arrayList3) {
                if (!StringsKt.isBlank((String) obj2)) {
                    arrayList4.add(obj2);
                }
            }
            listDistinct = CollectionsKt.distinct(arrayList4);
        }
        return listDistinct == null ? CollectionsKt.emptyList() : listDistinct;
    }

    public final Object prepareTrip$app(Context context, SmartSubwayTrip smartSubwayTrip, Continuation<? super SmartSubwayTrip> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new GlobalSubwayDataManager$prepareTrip$2(smartSubwayTrip, context, null), continuation);
    }

    /* JADX INFO: renamed from: com.example.tickets.GlobalSubwayDataManager$resolveRoutePlan$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: GlobalSubwayData.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/example/tickets/GlobalSubwayDataManager$SubwayRoutePlan;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.tickets.GlobalSubwayDataManager$resolveRoutePlan$2", f = "GlobalSubwayData.kt", i = {0, 1}, l = {661, 664}, m = "invokeSuspend", n = {"city", "city"}, s = {"L$0", "L$0"})
    static final class C03382 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super SubwayRoutePlan>, Object> {
        final /* synthetic */ String $cityId;
        final /* synthetic */ Context $context;
        final /* synthetic */ String $destination;
        final /* synthetic */ String $origin;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C03382(String str, Context context, String str2, String str3, Continuation<? super C03382> continuation) {
            super(2, continuation);
            this.$cityId = str;
            this.$context = context;
            this.$origin = str2;
            this.$destination = str3;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C03382(this.$cityId, this.$context, this.$origin, this.$destination, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super SubwayRoutePlan> continuation) {
            return ((C03382) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:17:0x0054, code lost:
        
            if (r11 == r0) goto L25;
         */
        /* JADX WARN: Code restructure failed: missing block: B:24:0x007b, code lost:
        
            if (r11 == r0) goto L25;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) throws Throwable {
            StaticIndex staticIndexLoadOrBuildIndex$app;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                SubwayCity subwayCityCityOrNull = GlobalSubwayDataManager.INSTANCE.cityOrNull(this.$cityId);
                if (subwayCityCityOrNull == null) {
                    return null;
                }
                if (subwayCityCityOrNull.getSourceType() == SourceType.GOOGLE) {
                    this.L$0 = SpillingKt.nullOutSpilledVariable(subwayCityCityOrNull);
                    this.label = 1;
                    obj = GlobalSubwayDataManager.INSTANCE.googleResolvePlan(this.$context, subwayCityCityOrNull, this.$origin, this.$destination, this);
                } else if (GlobalSubwayDataManager.SERVER_PATTERN_US_CITY_IDS.contains(this.$cityId)) {
                    this.L$0 = SpillingKt.nullOutSpilledVariable(subwayCityCityOrNull);
                    this.label = 2;
                    obj = GlobalSubwayDataManager.INSTANCE.loadUsServerRoutingIndex(this.$context, this.$cityId, this);
                } else {
                    staticIndexLoadOrBuildIndex$app = GlobalSubwayDataManager.INSTANCE.loadOrBuildIndex$app(this.$context, this.$cityId);
                }
                return coroutine_suspended;
            }
            if (i == 1) {
                ResultKt.throwOnFailure(obj);
                return (SubwayRoutePlan) obj;
            }
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            staticIndexLoadOrBuildIndex$app = (StaticIndex) obj;
            if (staticIndexLoadOrBuildIndex$app == null) {
                staticIndexLoadOrBuildIndex$app = GlobalSubwayDataManager.INSTANCE.loadOrBuildIndex$app(this.$context, this.$cityId);
            }
            return GlobalSubwayDataManager.INSTANCE.resolvePlan(staticIndexLoadOrBuildIndex$app, this.$cityId, this.$origin, this.$destination);
        }
    }

    public final Object resolveRoutePlan(Context context, String str, String str2, String str3, Continuation<? super SubwayRoutePlan> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new C03382(str, context, str2, str3, null), continuation);
    }

    /* JADX INFO: renamed from: com.example.tickets.GlobalSubwayDataManager$loadUsServerRoutingIndex$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: GlobalSubwayData.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/example/tickets/GlobalSubwayDataManager$StaticIndex;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.tickets.GlobalSubwayDataManager$loadUsServerRoutingIndex$2", f = "GlobalSubwayData.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C03372 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super StaticIndex>, Object> {
        final /* synthetic */ String $cityId;
        final /* synthetic */ Context $context;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C03372(String str, Context context, Continuation<? super C03372> continuation) {
            super(2, continuation);
            this.$cityId = str;
            this.$context = context;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C03372 c03372 = new C03372(this.$cityId, this.$context, continuation);
            c03372.L$0 = obj;
            return c03372;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super StaticIndex> continuation) {
            return ((C03372) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws UnsupportedEncodingException {
            Object objM9536constructorimpl;
            Object objM9536constructorimpl2;
            String str;
            Object objM9536constructorimpl3;
            Object objM9536constructorimpl4;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                if (!GlobalSubwayDataManager.SERVER_PATTERN_US_CITY_IDS.contains(this.$cityId) || StringsKt.contains$default((CharSequence) "https://tickets-us-transit.hyl120309.workers.dev", (CharSequence) "YOUR-US-TRANSIT-WORKER", false, 2, (Object) null)) {
                    return null;
                }
                long jCurrentTimeMillis = System.currentTimeMillis();
                UsServerPatternCache usServerPatternCache = (UsServerPatternCache) GlobalSubwayDataManager.usServerPatternCaches.get(this.$cityId);
                if (usServerPatternCache != null && jCurrentTimeMillis - usServerPatternCache.getFetchedAt() <= GlobalSubwayDataManager.US_SERVER_PATTERN_CACHE_MS) {
                    return usServerPatternCache.getIndex();
                }
                String str2 = "optString(...)";
                if (Intrinsics.areEqual(this.$cityId, "nyc")) {
                    String str3 = StringsKt.trimEnd("https://tickets-us-transit.hyl120309.workers.dev", '/') + "/api/v1/us/nyc/index";
                    try {
                        Result.Companion companion = Result.INSTANCE;
                        URLConnection uRLConnectionOpenConnection = new URL(str3).openConnection();
                        Intrinsics.checkNotNull(uRLConnectionOpenConnection, "null cannot be cast to non-null type java.net.HttpURLConnection");
                        HttpURLConnection httpURLConnection = (HttpURLConnection) uRLConnectionOpenConnection;
                        httpURLConnection.setRequestMethod("GET");
                        httpURLConnection.setConnectTimeout(ConnectionsStatusCodes.STATUS_NETWORK_NOT_CONNECTED);
                        httpURLConnection.setReadTimeout(15000);
                        httpURLConnection.setInstanceFollowRedirects(true);
                        httpURLConnection.setRequestProperty("Accept", "application/json");
                        httpURLConnection.setRequestProperty("User-Agent", "Tickets/6.0 USSubway");
                        try {
                            int responseCode = httpURLConnection.getResponseCode();
                            if (200 > responseCode || responseCode >= 300) {
                                throw new IllegalStateException("US Transit Worker NYC index HTTP " + httpURLConnection.getResponseCode());
                            }
                            InputStream inputStream = httpURLConnection.getInputStream();
                            Intrinsics.checkNotNullExpressionValue(inputStream, "getInputStream(...)");
                            Reader inputStreamReader = new InputStreamReader(inputStream, Charsets.UTF_8);
                            BufferedReader bufferedReader = inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, 8192);
                            try {
                                String text = TextStreamsKt.readText(bufferedReader);
                                CloseableKt.closeFinally(bufferedReader, null);
                                JSONObject jSONObject = new JSONObject(text);
                                if (Intrinsics.areEqual(jSONObject.optString("cityId"), "nyc")) {
                                    StaticIndex staticIndexNormalizeLocalUsIndex = GlobalSubwayDataManager.INSTANCE.normalizeLocalUsIndex("nyc", GlobalSubwayDataManager.INSTANCE.fromJson(jSONObject));
                                    if (staticIndexNormalizeLocalUsIndex.getStationsByKey().isEmpty()) {
                                        throw new IllegalStateException("US Transit Worker NYC index has no stations");
                                    }
                                    if (staticIndexNormalizeLocalUsIndex.getRoutePatterns().isEmpty()) {
                                        throw new IllegalStateException("US Transit Worker NYC index has no patterns");
                                    }
                                    if (staticIndexNormalizeLocalUsIndex.getRouteInfo().isEmpty()) {
                                        throw new IllegalStateException("US Transit Worker NYC index has no routes");
                                    }
                                    UsServerPatternCache usServerPatternCache2 = new UsServerPatternCache(jCurrentTimeMillis, staticIndexNormalizeLocalUsIndex);
                                    httpURLConnection.disconnect();
                                    objM9536constructorimpl3 = Result.m9536constructorimpl(usServerPatternCache2);
                                    if (Result.m9542isFailureimpl(objM9536constructorimpl3)) {
                                        objM9536constructorimpl3 = null;
                                    }
                                    UsServerPatternCache usServerPatternCache3 = (UsServerPatternCache) objM9536constructorimpl3;
                                    if (usServerPatternCache3 != null) {
                                        GlobalSubwayDataManager.usServerPatternCaches.put(this.$cityId, usServerPatternCache3);
                                        return usServerPatternCache3.getIndex();
                                    }
                                    Context context = this.$context;
                                    String str4 = this.$cityId;
                                    try {
                                        Result.Companion companion2 = Result.INSTANCE;
                                        objM9536constructorimpl4 = Result.m9536constructorimpl(GlobalSubwayDataManager.INSTANCE.loadOrBuildIndex$app(context, str4));
                                    } catch (Throwable th) {
                                        Result.Companion companion3 = Result.INSTANCE;
                                        objM9536constructorimpl4 = Result.m9536constructorimpl(ResultKt.createFailure(th));
                                    }
                                    if (Result.m9542isFailureimpl(objM9536constructorimpl4)) {
                                        return null;
                                    }
                                    return objM9536constructorimpl4;
                                }
                                String strOptString = jSONObject.optString("cityId");
                                throw new IllegalStateException("US Transit Worker NYC index returned wrong cityId: " + (strOptString == null ? "" : strOptString));
                            } catch (Throwable th2) {
                                try {
                                    throw th2;
                                } catch (Throwable th3) {
                                    CloseableKt.closeFinally(bufferedReader, th2);
                                    throw th3;
                                }
                            }
                        } catch (Throwable th4) {
                            httpURLConnection.disconnect();
                            throw th4;
                        }
                    } catch (Throwable th5) {
                        Result.Companion companion4 = Result.INSTANCE;
                        objM9536constructorimpl3 = Result.m9536constructorimpl(ResultKt.createFailure(th5));
                    }
                } else {
                    Context context2 = this.$context;
                    String str5 = this.$cityId;
                    try {
                        Result.Companion companion5 = Result.INSTANCE;
                        objM9536constructorimpl = Result.m9536constructorimpl(GlobalSubwayDataManager.INSTANCE.loadOrBuildIndex$app(context2, str5));
                    } catch (Throwable th6) {
                        Result.Companion companion6 = Result.INSTANCE;
                        objM9536constructorimpl = Result.m9536constructorimpl(ResultKt.createFailure(th6));
                    }
                    if (Result.m9542isFailureimpl(objM9536constructorimpl)) {
                        objM9536constructorimpl = null;
                    }
                    StaticIndex staticIndex = (StaticIndex) objM9536constructorimpl;
                    if (staticIndex == null) {
                        return null;
                    }
                    String string = ZonedDateTime.now(ZoneId.of("America/New_York")).toLocalDate().toString();
                    Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                    String str6 = StringsKt.trimEnd("https://tickets-us-transit.hyl120309.workers.dev", '/') + "/api/v1/us/" + URLEncoder.encode(this.$cityId, "UTF-8") + "/schedule?date=" + URLEncoder.encode(string, "UTF-8");
                    String str7 = this.$cityId;
                    try {
                        Result.Companion companion7 = Result.INSTANCE;
                        URLConnection uRLConnectionOpenConnection2 = new URL(str6).openConnection();
                        Intrinsics.checkNotNull(uRLConnectionOpenConnection2, "null cannot be cast to non-null type java.net.HttpURLConnection");
                        HttpURLConnection httpURLConnection2 = (HttpURLConnection) uRLConnectionOpenConnection2;
                        httpURLConnection2.setRequestMethod("GET");
                        httpURLConnection2.setConnectTimeout(ConnectionsStatusCodes.STATUS_NETWORK_NOT_CONNECTED);
                        httpURLConnection2.setReadTimeout(12000);
                        httpURLConnection2.setInstanceFollowRedirects(true);
                        httpURLConnection2.setRequestProperty("Accept", "application/json");
                        httpURLConnection2.setRequestProperty("User-Agent", "Tickets/6.0 USSubway");
                        try {
                            int responseCode2 = httpURLConnection2.getResponseCode();
                            try {
                                if (200 > responseCode2 || responseCode2 >= 300) {
                                    throw new IllegalStateException("US Transit Worker HTTP " + httpURLConnection2.getResponseCode());
                                }
                                InputStream inputStream2 = httpURLConnection2.getInputStream();
                                Intrinsics.checkNotNullExpressionValue(inputStream2, "getInputStream(...)");
                                Reader inputStreamReader2 = new InputStreamReader(inputStream2, Charsets.UTF_8);
                                BufferedReader bufferedReader2 = inputStreamReader2 instanceof BufferedReader ? (BufferedReader) inputStreamReader2 : new BufferedReader(inputStreamReader2, 8192);
                                try {
                                    String text2 = TextStreamsKt.readText(bufferedReader2);
                                    CloseableKt.closeFinally(bufferedReader2, null);
                                    JSONObject jSONObject2 = new JSONObject(text2);
                                    if (!Intrinsics.areEqual(jSONObject2.optString("cityId"), str7)) {
                                        String strOptString2 = jSONObject2.optString("cityId");
                                        throw new IllegalStateException("US Transit Worker returned wrong cityId: " + (strOptString2 == null ? "" : strOptString2));
                                    }
                                    JSONArray jSONArrayOptJSONArray = jSONObject2.optJSONArray("patterns");
                                    if (jSONArrayOptJSONArray == null) {
                                        throw new IllegalStateException("US Transit Worker missing patterns");
                                    }
                                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                                    int length = jSONArrayOptJSONArray.length();
                                    int i = 0;
                                    while (i < length) {
                                        JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
                                        if (jSONObjectOptJSONObject == null) {
                                            str = str2;
                                        } else {
                                            String strOptString3 = jSONObjectOptJSONObject.optString("routeId");
                                            str = str2;
                                            Intrinsics.checkNotNullExpressionValue(strOptString3, str);
                                            String string2 = StringsKt.trim((CharSequence) strOptString3).toString();
                                            JSONArray jSONArrayOptJSONArray2 = jSONObjectOptJSONObject.optJSONArray("stationKeys");
                                            if (jSONArrayOptJSONArray2 != null && !StringsKt.isBlank(string2)) {
                                                ArrayList arrayList = new ArrayList(jSONArrayOptJSONArray2.length());
                                                int length2 = jSONArrayOptJSONArray2.length();
                                                int i2 = 0;
                                                while (i2 < length2) {
                                                    HttpURLConnection httpURLConnection3 = httpURLConnection2;
                                                    String strOptString4 = jSONArrayOptJSONArray2.optString(i2);
                                                    Intrinsics.checkNotNullExpressionValue(strOptString4, str);
                                                    String string3 = StringsKt.trim((CharSequence) strOptString4).toString();
                                                    if (!StringsKt.isBlank(string3)) {
                                                        arrayList.add(string3);
                                                    }
                                                    i2++;
                                                    httpURLConnection2 = httpURLConnection3;
                                                    jSONArrayOptJSONArray = jSONArrayOptJSONArray;
                                                }
                                                httpURLConnection2 = httpURLConnection2;
                                                jSONArrayOptJSONArray = jSONArrayOptJSONArray;
                                                if (arrayList.size() >= 2) {
                                                    ArrayList arrayList2 = arrayList;
                                                    if (!(arrayList2 instanceof Collection) || !arrayList2.isEmpty()) {
                                                        Iterator it = arrayList2.iterator();
                                                        while (true) {
                                                            if (it.hasNext()) {
                                                                if (staticIndex.stationOption((String) it.next()) == null) {
                                                                }
                                                            }
                                                        }
                                                    }
                                                    LinkedHashMap linkedHashMap2 = linkedHashMap;
                                                    Object obj2 = linkedHashMap2.get(string2);
                                                    if (obj2 == null) {
                                                        obj2 = (List) new ArrayList();
                                                        linkedHashMap2.put(string2, obj2);
                                                    }
                                                    List list = (List) obj2;
                                                    List list2 = list;
                                                    if (!(list2 instanceof Collection) || !list2.isEmpty()) {
                                                        Iterator it2 = list2.iterator();
                                                        do {
                                                            if (it2.hasNext()) {
                                                            }
                                                        } while (!Intrinsics.areEqual((List) it2.next(), arrayList));
                                                    }
                                                    list.add(arrayList);
                                                    break;
                                                }
                                            }
                                            i++;
                                            str2 = str;
                                            httpURLConnection2 = httpURLConnection2;
                                            jSONArrayOptJSONArray = jSONArrayOptJSONArray;
                                        }
                                        i++;
                                        str2 = str;
                                        httpURLConnection2 = httpURLConnection2;
                                        jSONArrayOptJSONArray = jSONArrayOptJSONArray;
                                    }
                                    HttpURLConnection httpURLConnection4 = httpURLConnection2;
                                    if (linkedHashMap.isEmpty()) {
                                        throw new IllegalStateException("US Transit Worker returned no active patterns for " + str7);
                                    }
                                    LinkedHashMap linkedHashMap3 = linkedHashMap;
                                    LinkedHashMap linkedHashMap4 = new LinkedHashMap(MapsKt.mapCapacity(linkedHashMap3.size()));
                                    for (Object obj3 : linkedHashMap3.entrySet()) {
                                        linkedHashMap4.put(((Map.Entry) obj3).getKey(), CollectionsKt.toList((Iterable) ((Map.Entry) obj3).getValue()));
                                    }
                                    UsServerPatternCache usServerPatternCache4 = new UsServerPatternCache(jCurrentTimeMillis, StaticIndex.copy$default(staticIndex, null, null, linkedHashMap4, null, 11, null));
                                    httpURLConnection4.disconnect();
                                    objM9536constructorimpl2 = Result.m9536constructorimpl(usServerPatternCache4);
                                    Object obj4 = objM9536constructorimpl2;
                                    if (Result.m9542isFailureimpl(obj4)) {
                                        obj4 = null;
                                    }
                                    UsServerPatternCache usServerPatternCache5 = (UsServerPatternCache) obj4;
                                    if (usServerPatternCache5 == null) {
                                        return null;
                                    }
                                    GlobalSubwayDataManager.usServerPatternCaches.put(this.$cityId, usServerPatternCache5);
                                    return usServerPatternCache5.getIndex();
                                } catch (Throwable th7) {
                                    try {
                                        throw th7;
                                    } catch (Throwable th8) {
                                        CloseableKt.closeFinally(bufferedReader2, th7);
                                        throw th8;
                                    }
                                }
                            } catch (Throwable th9) {
                                th = th9;
                                httpURLConnection2.disconnect();
                                throw th;
                            }
                        } catch (Throwable th10) {
                            th = th10;
                        }
                    } catch (Throwable th11) {
                        Result.Companion companion8 = Result.INSTANCE;
                        objM9536constructorimpl2 = Result.m9536constructorimpl(ResultKt.createFailure(th11));
                    }
                }
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object loadUsServerRoutingIndex(Context context, String str, Continuation<? super StaticIndex> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new C03372(str, context, null), continuation);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object fetchNycRealtimeOverlay$app$default(GlobalSubwayDataManager globalSubwayDataManager, Context context, Set set, Set set2, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            set = SetsKt.emptySet();
        }
        if ((i & 4) != 0) {
            set2 = SetsKt.emptySet();
        }
        return globalSubwayDataManager.fetchNycRealtimeOverlay$app(context, set, set2, continuation);
    }

    public final Object fetchNycRealtimeOverlay$app(Context context, Set<String> set, Set<String> set2, Continuation<? super List<NycRealtimeOverlay>> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new GlobalSubwayDataManager$fetchNycRealtimeOverlay$2(set, set2, null), continuation);
    }

    /* JADX INFO: compiled from: GlobalSubwayData.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005¨\u0006\u0007"}, d2 = {"Lcom/example/tickets/GlobalSubwayDataManager$LocalUsDataConfig;", "", "<init>", "()V", "assetPath", "", "cityId", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class LocalUsDataConfig {
        public static final int $stable = 0;
        public static final LocalUsDataConfig INSTANCE = new LocalUsDataConfig();

        private LocalUsDataConfig() {
        }

        public final String assetPath(String cityId) {
            Intrinsics.checkNotNullParameter(cityId, "cityId");
            return GlobalSubwayDataManager.LOCAL_US_ASSET_PREFIX + cityId + ".json.gz";
        }
    }

    /* JADX INFO: compiled from: GlobalSubwayData.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/example/tickets/GlobalSubwayDataManager$GoogleMapsConfig;", "", "<init>", "()V", "API_KEY", "", "getApiKey", "context", "Landroid/content/Context;", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class GoogleMapsConfig {
        public static final int $stable = 0;
        public static final String API_KEY = "PASTE_YOUR_GOOGLE_MAPS_PLATFORM_API_KEY_HERE";
        public static final GoogleMapsConfig INSTANCE = new GoogleMapsConfig();

        private GoogleMapsConfig() {
        }

        public final String getApiKey(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            String string = context.getSharedPreferences(GlobalSubwayDataManager.PREFS_NAME, 0).getString("google_maps_api_key", "");
            String str = string != null ? string : "";
            if (StringsKt.isBlank(str)) {
                str = API_KEY;
            }
            return str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String requireGoogleApiKey(Context context) {
        String apiKey = GoogleMapsConfig.INSTANCE.getApiKey(context);
        if (StringsKt.isBlank(apiKey) || Intrinsics.areEqual(apiKey, GoogleMapsConfig.API_KEY)) {
            throw new IllegalArgumentException("请在 GlobalSubwayDataManager.GoogleMapsConfig.API_KEY 填入 Google Maps Platform API Key。".toString());
        }
        return apiKey;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<SubwayStationOption> googleSearchStationsBlocking(Context context, SubwayCity city, String query, int limit) throws JSONException {
        String strRequireGoogleApiKey = requireGoogleApiKey(context);
        String string = StringsKt.trim((CharSequence) query).toString();
        if (StringsKt.isBlank(string)) {
            string = "subway station";
        }
        String str = string + " in " + city.getNameEn();
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("textQuery", str);
        jSONObject.put("includedType", "transit_station");
        jSONObject.put("strictTypeFiltering", true);
        jSONObject.put("pageSize", RangesKt.coerceIn(limit, 1, 20));
        jSONObject.put("languageCode", Intrinsics.areEqual(city.getId(), "hong_kong") ? "zh-HK" : "en");
        return parseGooglePlacesStations(city, googlePostJson$default(this, GOOGLE_PLACES_SEARCH_URL, strRequireGoogleApiKey, "places.id,places.displayName,places.location,places.transitStation", jSONObject, null, 16, null));
    }

    /* JADX INFO: renamed from: com.example.tickets.GlobalSubwayDataManager$googleSearchStations$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: GlobalSubwayData.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "Lcom/example/tickets/GlobalSubwayDataManager$SubwayStationOption;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.tickets.GlobalSubwayDataManager$googleSearchStations$2", f = "GlobalSubwayData.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C03362 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends SubwayStationOption>>, Object> {
        final /* synthetic */ SubwayCity $city;
        final /* synthetic */ Context $context;
        final /* synthetic */ int $limit;
        final /* synthetic */ String $query;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C03362(Context context, SubwayCity subwayCity, String str, int i, Continuation<? super C03362> continuation) {
            super(2, continuation);
            this.$context = context;
            this.$city = subwayCity;
            this.$query = str;
            this.$limit = i;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C03362 c03362 = new C03362(this.$context, this.$city, this.$query, this.$limit, continuation);
            c03362.L$0 = obj;
            return c03362;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends SubwayStationOption>> continuation) {
            return invoke2(coroutineScope, (Continuation<? super List<SubwayStationOption>>) continuation);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super List<SubwayStationOption>> continuation) {
            return ((C03362) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object objM9536constructorimpl;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            Context context = this.$context;
            SubwayCity subwayCity = this.$city;
            String str = this.$query;
            int i = this.$limit;
            try {
                Result.Companion companion = Result.INSTANCE;
                objM9536constructorimpl = Result.m9536constructorimpl(GlobalSubwayDataManager.INSTANCE.googleSearchStationsBlocking(context, subwayCity, str, i));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objM9536constructorimpl = Result.m9536constructorimpl(ResultKt.createFailure(th));
            }
            return Result.m9539exceptionOrNullimpl(objM9536constructorimpl) == null ? objM9536constructorimpl : CollectionsKt.emptyList();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object googleSearchStations(Context context, SubwayCity subwayCity, String str, int i, Continuation<? super List<SubwayStationOption>> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new C03362(context, subwayCity, str, i, null), continuation);
    }

    /* JADX INFO: renamed from: com.example.tickets.GlobalSubwayDataManager$googleNearbyStations$2, reason: invalid class name */
    /* JADX INFO: compiled from: GlobalSubwayData.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "Lcom/example/tickets/GlobalSubwayDataManager$SubwayStationOption;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.tickets.GlobalSubwayDataManager$googleNearbyStations$2", f = "GlobalSubwayData.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends SubwayStationOption>>, Object> {
        final /* synthetic */ SubwayCity $city;
        final /* synthetic */ Context $context;
        final /* synthetic */ double $latitude;
        final /* synthetic */ double $longitude;
        final /* synthetic */ double $radiusMeters;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(Context context, SubwayCity subwayCity, double d, double d2, double d3, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$context = context;
            this.$city = subwayCity;
            this.$latitude = d;
            this.$longitude = d2;
            this.$radiusMeters = d3;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$context, this.$city, this.$latitude, this.$longitude, this.$radiusMeters, continuation);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends SubwayStationOption>> continuation) {
            return invoke2(coroutineScope, (Continuation<? super List<SubwayStationOption>>) continuation);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super List<SubwayStationOption>> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object objM9536constructorimpl;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            Context context = this.$context;
            SubwayCity subwayCity = this.$city;
            double d = this.$latitude;
            double d2 = this.$longitude;
            double d3 = this.$radiusMeters;
            try {
                Result.Companion companion = Result.INSTANCE;
                String strRequireGoogleApiKey = GlobalSubwayDataManager.INSTANCE.requireGoogleApiKey(context);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("includedTypes", new JSONArray().put("transit_station"));
                jSONObject.put("maxResultCount", 20);
                jSONObject.put("locationRestriction", new JSONObject().put("circle", new JSONObject().put("center", new JSONObject().put("latitude", d).put("longitude", d2)).put("radius", RangesKt.coerceIn(d3, 1.0d, 50000.0d))));
                jSONObject.put("languageCode", "en");
                objM9536constructorimpl = Result.m9536constructorimpl(GlobalSubwayDataManager.INSTANCE.parseGooglePlacesStations(subwayCity, GlobalSubwayDataManager.googlePostJson$default(GlobalSubwayDataManager.INSTANCE, GlobalSubwayDataManager.GOOGLE_PLACES_NEARBY_URL, strRequireGoogleApiKey, "places.id,places.displayName,places.location,places.transitStation", jSONObject, null, 16, null)));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objM9536constructorimpl = Result.m9536constructorimpl(ResultKt.createFailure(th));
            }
            return Result.m9539exceptionOrNullimpl(objM9536constructorimpl) == null ? objM9536constructorimpl : CollectionsKt.emptyList();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object googleNearbyStations(Context context, SubwayCity subwayCity, double d, double d2, double d3, Continuation<? super List<SubwayStationOption>> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new AnonymousClass2(context, subwayCity, d, d2, d3, null), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:9:0x0024  */
    public final List<SubwayStationOption> parseGooglePlacesStations(SubwayCity city, JSONObject root) {
        int i;
        JSONArray jSONArray;
        JSONArray jSONArray2;
        ArrayList arrayListListOf;
        int i2;
        int i3;
        JSONArray jSONArray3;
        int i4;
        String str;
        int i5;
        JSONObject jSONObjectOptJSONObject;
        JSONArray jSONArrayOptJSONArray = root.optJSONArray("places");
        if (jSONArrayOptJSONArray == null) {
            jSONArrayOptJSONArray = new JSONArray();
        }
        JSONArray jSONArray4 = jSONArrayOptJSONArray;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int length = jSONArray4.length();
        int i6 = 0;
        while (i6 < length) {
            JSONObject jSONObjectOptJSONObject2 = jSONArray4.optJSONObject(i6);
            if (jSONObjectOptJSONObject2 == null) {
                jSONArray = jSONArray4;
                i = i6;
            } else {
                String strOptString = jSONObjectOptJSONObject2.optString("id");
                if (StringsKt.isBlank(strOptString)) {
                    String strOptString2 = jSONObjectOptJSONObject2.optString(HintConstants.AUTOFILL_HINT_NAME);
                    Intrinsics.checkNotNullExpressionValue(strOptString2, "optString(...)");
                    strOptString = StringsKt.removePrefix(strOptString2, (CharSequence) "places/");
                }
                String str2 = strOptString;
                JSONObject jSONObjectOptJSONObject3 = jSONObjectOptJSONObject2.optJSONObject("transitStation");
                String str3 = "displayName";
                String strOptString3 = (jSONObjectOptJSONObject3 == null || (jSONObjectOptJSONObject = jSONObjectOptJSONObject3.optJSONObject("displayName")) == null) ? null : jSONObjectOptJSONObject.optString("text");
                if (strOptString3 == null) {
                    strOptString3 = "";
                }
                JSONObject jSONObjectOptJSONObject4 = jSONObjectOptJSONObject2.optJSONObject("displayName");
                String strOptString4 = jSONObjectOptJSONObject4 != null ? jSONObjectOptJSONObject4.optString("text") : null;
                if (strOptString4 == null) {
                    strOptString4 = "";
                }
                String strFirstNonBlank = firstNonBlank(strOptString3, strOptString4);
                JSONObject jSONObjectOptJSONObject5 = jSONObjectOptJSONObject2.optJSONObject("location");
                if (jSONObjectOptJSONObject5 == null) {
                    jSONArray = jSONArray4;
                    i = i6;
                } else {
                    i = i6;
                    double dOptDouble = jSONObjectOptJSONObject5.optDouble("latitude", Double.NaN);
                    double dOptDouble2 = jSONObjectOptJSONObject5.optDouble("longitude", Double.NaN);
                    if (StringsKt.isBlank(strFirstNonBlank) || Math.abs(dOptDouble) > Double.MAX_VALUE || Math.abs(dOptDouble2) > Double.MAX_VALUE) {
                        jSONArray = jSONArray4;
                    } else {
                        ArrayList arrayList = new ArrayList();
                        JSONObject jSONObjectOptJSONObject6 = jSONObjectOptJSONObject2.optJSONObject("transitStation");
                        if (jSONObjectOptJSONObject6 == null || (jSONArray2 = jSONObjectOptJSONObject6.optJSONArray("agencies")) == null) {
                            jSONArray2 = new JSONArray();
                        }
                        JSONArray jSONArray5 = jSONArray2;
                        int length2 = jSONArray5.length();
                        int i7 = 0;
                        while (i7 < length2) {
                            JSONObject jSONObjectOptJSONObject7 = jSONArray5.optJSONObject(i7);
                            if (jSONObjectOptJSONObject7 != null) {
                                JSONArray jSONArrayOptJSONArray2 = jSONObjectOptJSONObject7.optJSONArray("lines");
                                if (jSONArrayOptJSONArray2 == null) {
                                    jSONArrayOptJSONArray2 = new JSONArray();
                                }
                                int length3 = jSONArrayOptJSONArray2.length();
                                int i8 = 0;
                                while (true) {
                                    i2 = length2;
                                    if (i8 >= length3) {
                                        break;
                                    }
                                    JSONObject jSONObjectOptJSONObject8 = jSONArrayOptJSONArray2.optJSONObject(i8);
                                    if (jSONObjectOptJSONObject8 == null) {
                                        i3 = i7;
                                        jSONArray3 = jSONArrayOptJSONArray2;
                                        str = str3;
                                        i5 = length3;
                                        i4 = i8;
                                    } else {
                                        i3 = i7;
                                        JSONObject jSONObjectOptJSONObject9 = jSONObjectOptJSONObject8.optJSONObject(str3);
                                        String strOptString5 = jSONObjectOptJSONObject9 != null ? jSONObjectOptJSONObject9.optString("text") : null;
                                        if (strOptString5 == null) {
                                            strOptString5 = "";
                                        }
                                        jSONArray3 = jSONArrayOptJSONArray2;
                                        String strOptString6 = jSONObjectOptJSONObject8.optString(HintConstants.AUTOFILL_HINT_NAME);
                                        Intrinsics.checkNotNullExpressionValue(strOptString6, "optString(...)");
                                        String str4 = str3;
                                        String strOptString7 = jSONObjectOptJSONObject8.optString("id");
                                        Intrinsics.checkNotNullExpressionValue(strOptString7, "optString(...)");
                                        String strFirstNonBlank2 = this.firstNonBlank(strOptString5, strOptString6, strOptString7);
                                        if (!StringsKt.isBlank(strFirstNonBlank2)) {
                                            String strOptString8 = jSONObjectOptJSONObject8.optString("shortName");
                                            Intrinsics.checkNotNullExpressionValue(strOptString8, "optString(...)");
                                            String strFirstNonBlank3 = this.firstNonBlank(strOptString8, strFirstNonBlank2);
                                            String id = city.getId();
                                            String strOptString9 = jSONObjectOptJSONObject8.optString("id");
                                            if (!StringsKt.isBlank(strOptString9)) {
                                                strFirstNonBlank2 = strOptString9;
                                            }
                                            String str5 = id + ":google:" + ((Object) strFirstNonBlank2);
                                            String id2 = city.getId();
                                            int size = arrayList.size();
                                            String strOptString10 = jSONObjectOptJSONObject8.optString("backgroundColor");
                                            Intrinsics.checkNotNullExpressionValue(strOptString10, "optString(...)");
                                            String strOptString11 = jSONObjectOptJSONObject8.optString("color");
                                            Intrinsics.checkNotNullExpressionValue(strOptString11, "optString(...)");
                                            i4 = i8;
                                            str = str4;
                                            i5 = length3;
                                            int iRouteColor = this.routeColor(id2, strFirstNonBlank3, str5, size, this.parseHexColor(this.firstNonBlank(strOptString10, strOptString11)));
                                            ArrayList arrayList2 = arrayList;
                                            if ((arrayList2 instanceof Collection) && arrayList2.isEmpty()) {
                                                arrayList.add(new SubwayRouteInfo(str5, strFirstNonBlank3, strFirstNonBlank2, iRouteColor));
                                                break;
                                                break;
                                            }
                                            Iterator it = arrayList2.iterator();
                                            do {
                                                if (!it.hasNext()) {
                                                    arrayList.add(new SubwayRouteInfo(str5, strFirstNonBlank3, strFirstNonBlank2, iRouteColor));
                                                    break;
                                                }
                                            } while (!Intrinsics.areEqual(((SubwayRouteInfo) it.next()).getRouteId(), str5));
                                        } else {
                                            i4 = i8;
                                            str = str4;
                                            i5 = length3;
                                        }
                                    }
                                    i8 = i4 + 1;
                                    this = this;
                                    length2 = i2;
                                    i7 = i3;
                                    jSONArrayOptJSONArray2 = jSONArray3;
                                    length3 = i5;
                                    str3 = str;
                                }
                            } else {
                                i2 = length2;
                            }
                            i7++;
                            this = this;
                            length2 = i2;
                            str3 = str3;
                            jSONArray4 = jSONArray4;
                        }
                        jSONArray = jSONArray4;
                        if (arrayList.isEmpty()) {
                            arrayListListOf = CollectionsKt.listOf(new SubwayRouteInfo(city.getId() + ":google:transit", "地铁", "Transit", FALLBACK_ROUTE_COLOR));
                        } else {
                            arrayListListOf = arrayList;
                        }
                        linkedHashMap.put(str2, new SubwayStationOption(city.getId() + ":google:place:" + str2, strFirstNonBlank, dOptDouble, dOptDouble2, CollectionsKt.sortedWith(arrayListListOf, new Comparator() { // from class: com.example.tickets.GlobalSubwayDataManager$parseGooglePlacesStations$$inlined$sortedBy$1
                            /* JADX WARN: Multi-variable type inference failed */
                            @Override // java.util.Comparator
                            public final int compare(T t, T t2) {
                                return ComparisonsKt.compareValues(((GlobalSubwayDataManager.SubwayRouteInfo) t).getShortName(), ((GlobalSubwayDataManager.SubwayRouteInfo) t2).getShortName());
                            }
                        }), null, 32, null));
                    }
                }
            }
            i6 = i + 1;
            jSONArray4 = jSONArray;
        }
        Collection collectionValues = linkedHashMap.values();
        Intrinsics.checkNotNullExpressionValue(collectionValues, "<get-values>(...)");
        return CollectionsKt.toList(collectionValues);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:148:0x03e0  */
    /* JADX WARN: Code duplicated, block: B:58:0x01d8  */
    /* JADX WARN: Code duplicated, block: B:96:0x0261  */
    /* JADX WARN: Code duplicated, block: B:97:0x0263  */
    public final SubwayRoutePlan googleResolvePlanBlocking(Context context, SubwayCity city, String originName, String destinationName) throws JSONException {
        SubwayStationOption subwayStationOptionGoogleFindStationBlocking;
        JSONObject jSONObjectOptJSONObject;
        JSONArray jSONArrayOptJSONArray;
        String routeId;
        String routeId2;
        SubwayStationOption subwayStationOption;
        ArrayList arrayListListOf;
        String str;
        String str2;
        SubwayStationOption subwayStationOption2;
        ArrayList arrayList;
        SubwayStationOption subwayStationOption3;
        int i;
        int i2;
        int i3;
        String str3;
        JSONObject jSONObjectOptJSONObject2;
        boolean z;
        SubwayStationOption subwayStationOption4;
        ArrayList arrayList2;
        String str4;
        String str5;
        SubwayStationOption subwayStationOption5;
        String str6;
        JSONObject jSONObjectOptJSONObject3;
        SubwayStationOption subwayStationOptionGoogleFindStationBlocking2 = googleFindStationBlocking(context, city, originName);
        if (subwayStationOptionGoogleFindStationBlocking2 == null || (subwayStationOptionGoogleFindStationBlocking = googleFindStationBlocking(context, city, destinationName)) == null || Intrinsics.areEqual(subwayStationOptionGoogleFindStationBlocking2.getKey(), subwayStationOptionGoogleFindStationBlocking.getKey())) {
            return null;
        }
        String strRequireGoogleApiKey = requireGoogleApiKey(context);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("origin", new JSONObject().put("location", new JSONObject().put("latLng", new JSONObject().put("latitude", subwayStationOptionGoogleFindStationBlocking2.getLatitude()).put("longitude", subwayStationOptionGoogleFindStationBlocking2.getLongitude()))));
        jSONObject.put("destination", new JSONObject().put("location", new JSONObject().put("latLng", new JSONObject().put("latitude", subwayStationOptionGoogleFindStationBlocking.getLatitude()).put("longitude", subwayStationOptionGoogleFindStationBlocking.getLongitude()))));
        jSONObject.put("travelMode", "TRANSIT");
        jSONObject.put("languageCode", "en");
        String str7 = "SUBWAY";
        String str8 = "TRAIN";
        String str9 = "LIGHT_RAIL";
        jSONObject.put("transitPreferences", new JSONObject().put("allowedTravelModes", new JSONArray().put("SUBWAY").put("TRAIN").put("LIGHT_RAIL").put("RAIL")).put("routingPreference", "FEWER_TRANSFERS"));
        jSONObject.put("computeAlternativeRoutes", false);
        JSONArray jSONArrayOptJSONArray2 = googlePostJson(GOOGLE_ROUTES_URL, strRequireGoogleApiKey, "routes.legs.steps.transitDetails,routes.legs.steps.polyline.encodedPolyline", jSONObject, "X-Goog-Api-Key").optJSONArray("routes");
        if (jSONArrayOptJSONArray2 == null || (jSONObjectOptJSONObject = jSONArrayOptJSONArray2.optJSONObject(0)) == null || (jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("legs")) == null) {
            return null;
        }
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        ArrayList arrayList5 = new ArrayList();
        int length = jSONArrayOptJSONArray.length();
        SubwayStationOption subwayStationOption6 = null;
        String str10 = null;
        int i4 = 0;
        while (i4 < length) {
            JSONObject jSONObjectOptJSONObject4 = jSONArrayOptJSONArray.optJSONObject(i4);
            if (jSONObjectOptJSONObject4 == null) {
                subwayStationOption3 = subwayStationOptionGoogleFindStationBlocking2;
                subwayStationOption2 = subwayStationOptionGoogleFindStationBlocking;
                arrayList = arrayList3;
            } else {
                ArrayList arrayList6 = arrayList3;
                JSONArray jSONArrayOptJSONArray3 = jSONObjectOptJSONObject4.optJSONArray("steps");
                if (jSONArrayOptJSONArray3 == null) {
                    jSONArrayOptJSONArray3 = new JSONArray();
                }
                JSONArray jSONArray = jSONArrayOptJSONArray3;
                int length2 = jSONArray.length();
                SubwayStationOption subwayStationOption7 = subwayStationOption6;
                int i5 = 0;
                while (i5 < length2) {
                    int i6 = length2;
                    JSONObject jSONObjectOptJSONObject5 = jSONArray.optJSONObject(i5);
                    if (jSONObjectOptJSONObject5 == null) {
                        i = length;
                        i2 = i4;
                        i3 = i5;
                        str3 = str10;
                    } else {
                        i = length;
                        JSONObject jSONObjectOptJSONObject6 = jSONObjectOptJSONObject5.optJSONObject("polyline");
                        i2 = i4;
                        String strOptString = jSONObjectOptJSONObject6 != null ? jSONObjectOptJSONObject6.optString("encodedPolyline") : null;
                        if (strOptString == null) {
                            strOptString = "";
                        }
                        if (!StringsKt.isBlank(strOptString)) {
                            Iterator it = decodeEncodedPolyline(strOptString).iterator();
                            while (it.hasNext()) {
                                RoutePoint routePoint = (RoutePoint) it.next();
                                ArrayList arrayList7 = arrayList5;
                                RoutePoint routePoint2 = (RoutePoint) CollectionsKt.lastOrNull((List) arrayList7);
                                int i7 = i5;
                                String str11 = str10;
                                if (Intrinsics.areEqual(routePoint2 != null ? Double.valueOf(routePoint2.getLatitude()) : null, routePoint.getLatitude())) {
                                    RoutePoint routePoint3 = (RoutePoint) CollectionsKt.lastOrNull((List) arrayList7);
                                    if (!Intrinsics.areEqual(routePoint3 != null ? Double.valueOf(routePoint3.getLongitude()) : null, routePoint.getLongitude())) {
                                        arrayList5.add(routePoint);
                                    }
                                } else {
                                    arrayList5.add(routePoint);
                                }
                                it = it;
                                i5 = i7;
                                str10 = str11;
                            }
                        }
                        i3 = i5;
                        str3 = str10;
                        JSONObject jSONObjectOptJSONObject7 = jSONObjectOptJSONObject5.optJSONObject("transitDetails");
                        if (jSONObjectOptJSONObject7 != null && (jSONObjectOptJSONObject2 = jSONObjectOptJSONObject7.optJSONObject("transitLine")) != null) {
                            JSONObject jSONObjectOptJSONObject8 = jSONObjectOptJSONObject2.optJSONObject("vehicle");
                            String strOptString2 = jSONObjectOptJSONObject8 != null ? jSONObjectOptJSONObject8.optString(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY) : null;
                            if (strOptString2 == null) {
                                strOptString2 = "";
                            }
                            Locale ROOT = Locale.ROOT;
                            Intrinsics.checkNotNullExpressionValue(ROOT, "ROOT");
                            String upperCase = strOptString2.toUpperCase(ROOT);
                            Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
                            switch (upperCase.hashCode()) {
                                case -1838196561:
                                    if (!upperCase.equals(str7)) {
                                        z = false;
                                    } else {
                                        z = true;
                                    }
                                    break;
                                case 2507666:
                                    if (!upperCase.equals("RAIL")) {
                                        z = false;
                                    } else {
                                        z = true;
                                    }
                                    break;
                                case 73038616:
                                    if (!upperCase.equals("METRO_RAIL")) {
                                        z = false;
                                    } else {
                                        z = true;
                                    }
                                    break;
                                case 80083432:
                                    if (!upperCase.equals(str8)) {
                                        z = false;
                                    } else {
                                        z = true;
                                    }
                                    break;
                                case 306014523:
                                    if (!upperCase.equals(str9)) {
                                        z = false;
                                    } else {
                                        z = true;
                                    }
                                    break;
                                case 735884161:
                                    if (!upperCase.equals("COMMUTER_TRAIN")) {
                                        z = false;
                                    } else {
                                        z = true;
                                    }
                                    break;
                                case 1843287082:
                                    if (!upperCase.equals("HEAVY_RAIL")) {
                                        z = false;
                                    } else {
                                        z = true;
                                    }
                                    break;
                                default:
                                    z = false;
                                    break;
                            }
                            if (StringsKt.isBlank(upperCase) || z) {
                                String strOptString3 = jSONObjectOptJSONObject2.optString("nameShort");
                                Intrinsics.checkNotNullExpressionValue(strOptString3, "optString(...)");
                                String strOptString4 = jSONObjectOptJSONObject2.optString(HintConstants.AUTOFILL_HINT_NAME);
                                Intrinsics.checkNotNullExpressionValue(strOptString4, "optString(...)");
                                String strFirstNonBlank = firstNonBlank(strOptString3, strOptString4, "地铁");
                                String strOptString5 = jSONObjectOptJSONObject2.optString(HintConstants.AUTOFILL_HINT_NAME);
                                Intrinsics.checkNotNullExpressionValue(strOptString5, "optString(...)");
                                String strFirstNonBlank2 = firstNonBlank(strOptString5, strFirstNonBlank);
                                String str12 = city.getId() + ":google:line:" + strFirstNonBlank;
                                String id = city.getId();
                                int size = arrayList4.size();
                                String strOptString6 = jSONObjectOptJSONObject2.optString("color");
                                Intrinsics.checkNotNullExpressionValue(strOptString6, "optString(...)");
                                Integer hexColor = parseHexColor(strOptString6);
                                if (hexColor == null) {
                                    String strOptString7 = jSONObjectOptJSONObject2.optString("backgroundColor");
                                    Intrinsics.checkNotNullExpressionValue(strOptString7, "optString(...)");
                                    hexColor = parseHexColor(strOptString7);
                                }
                                ArrayList arrayList8 = arrayList6;
                                subwayStationOption4 = subwayStationOptionGoogleFindStationBlocking;
                                arrayList2 = arrayList8;
                                str4 = str7;
                                str5 = str8;
                                subwayStationOption5 = subwayStationOptionGoogleFindStationBlocking2;
                                str6 = str9;
                                SubwayRouteInfo subwayRouteInfo = new SubwayRouteInfo(str12, strFirstNonBlank, strFirstNonBlank2, routeColor(id, strFirstNonBlank, str12, size, hexColor));
                                ArrayList arrayList9 = arrayList4;
                                if ((arrayList9 instanceof Collection) && arrayList9.isEmpty()) {
                                    arrayList4.add(subwayRouteInfo);
                                } else {
                                    Iterator it2 = arrayList9.iterator();
                                    do {
                                        if (!it2.hasNext()) {
                                            arrayList4.add(subwayRouteInfo);
                                        }
                                    } while (!Intrinsics.areEqual(((SubwayRouteInfo) it2.next()).getRouteId(), str12));
                                }
                                if (str3 != null && !Intrinsics.areEqual(str3, str12) && subwayStationOption7 == null) {
                                    JSONObject jSONObjectOptJSONObject9 = jSONObjectOptJSONObject7.optJSONObject("stopDetails");
                                    String strOptString8 = (jSONObjectOptJSONObject9 == null || (jSONObjectOptJSONObject3 = jSONObjectOptJSONObject9.optJSONObject("departureStop")) == null) ? null : jSONObjectOptJSONObject3.optString(HintConstants.AUTOFILL_HINT_NAME);
                                    if (strOptString8 == null) {
                                        strOptString8 = "";
                                    }
                                    if (!StringsKt.isBlank(strOptString8)) {
                                        JSONObject jSONObjectOptJSONObject10 = jSONObjectOptJSONObject7.optJSONObject("stopDetails");
                                        JSONObject jSONObjectOptJSONObject11 = jSONObjectOptJSONObject10 != null ? jSONObjectOptJSONObject10.optJSONObject("departureStop") : null;
                                        Pair<Double, Double> pairGoogleRouteLocation = jSONObjectOptJSONObject11 != null ? INSTANCE.googleRouteLocation(jSONObjectOptJSONObject11) : null;
                                        subwayStationOption7 = new SubwayStationOption(city.getId() + ":google:transfer:" + strOptString8, strOptString8, pairGoogleRouteLocation != null ? pairGoogleRouteLocation.getFirst().doubleValue() : subwayStationOption5.getLatitude(), pairGoogleRouteLocation != null ? pairGoogleRouteLocation.getSecond().doubleValue() : subwayStationOption5.getLongitude(), CollectionsKt.listOf(subwayRouteInfo), null, 32, null);
                                    }
                                }
                                JSONObject jSONObjectOptJSONObject12 = jSONObjectOptJSONObject7.optJSONObject("stopDetails");
                                if (jSONObjectOptJSONObject12 == null) {
                                    str10 = str3;
                                } else {
                                    JSONObject jSONObjectOptJSONObject13 = jSONObjectOptJSONObject12.optJSONObject("departureStop");
                                    JSONObject jSONObjectOptJSONObject14 = jSONObjectOptJSONObject12.optJSONObject("arrivalStop");
                                    if (jSONObjectOptJSONObject13 != null) {
                                        addUniqueRouteStation(arrayList2, googleTransitStopToStation(city, jSONObjectOptJSONObject13, subwayRouteInfo));
                                    }
                                    if (jSONObjectOptJSONObject14 != null) {
                                        addUniqueRouteStation(arrayList2, googleTransitStopToStation(city, jSONObjectOptJSONObject14, subwayRouteInfo));
                                    }
                                    str10 = str12;
                                }
                            }
                        }
                        i5 = i3 + 1;
                        SubwayStationOption subwayStationOption8 = subwayStationOption4;
                        arrayList6 = arrayList2;
                        subwayStationOptionGoogleFindStationBlocking = subwayStationOption8;
                        length2 = i6;
                        length = i;
                        i4 = i2;
                        str7 = str4;
                        str8 = str5;
                        str9 = str6;
                        subwayStationOptionGoogleFindStationBlocking2 = subwayStationOption5;
                    }
                    ArrayList arrayList10 = arrayList6;
                    subwayStationOption4 = subwayStationOptionGoogleFindStationBlocking;
                    arrayList2 = arrayList10;
                    subwayStationOption5 = subwayStationOptionGoogleFindStationBlocking2;
                    str4 = str7;
                    str5 = str8;
                    str10 = str3;
                    str6 = str9;
                    i5 = i3 + 1;
                    SubwayStationOption subwayStationOption9 = subwayStationOption4;
                    arrayList6 = arrayList2;
                    subwayStationOptionGoogleFindStationBlocking = subwayStationOption9;
                    length2 = i6;
                    length = i;
                    i4 = i2;
                    str7 = str4;
                    str8 = str5;
                    str9 = str6;
                    subwayStationOptionGoogleFindStationBlocking2 = subwayStationOption5;
                }
                ArrayList arrayList11 = arrayList6;
                subwayStationOption2 = subwayStationOptionGoogleFindStationBlocking;
                arrayList = arrayList11;
                subwayStationOption3 = subwayStationOptionGoogleFindStationBlocking2;
                subwayStationOption6 = subwayStationOption7;
            }
            i4++;
            arrayList3 = arrayList;
            subwayStationOptionGoogleFindStationBlocking = subwayStationOption2;
            length = length;
            str7 = str7;
            str8 = str8;
            str9 = str9;
            subwayStationOptionGoogleFindStationBlocking2 = subwayStationOption3;
        }
        SubwayStationOption subwayStationOption10 = subwayStationOptionGoogleFindStationBlocking2;
        SubwayStationOption subwayStationOption11 = subwayStationOptionGoogleFindStationBlocking;
        ArrayList arrayList12 = arrayList3;
        if (arrayList12.isEmpty()) {
            ArrayList arrayList13 = arrayList12;
            String key = subwayStationOption10.getKey();
            String name = subwayStationOption10.getName();
            double latitude = subwayStationOption10.getLatitude();
            double longitude = subwayStationOption10.getLongitude();
            ArrayList arrayList14 = arrayList4;
            SubwayRouteInfo subwayRouteInfo2 = (SubwayRouteInfo) CollectionsKt.firstOrNull((List) arrayList14);
            if (subwayRouteInfo2 == null || (routeId = subwayRouteInfo2.getRouteId()) == null) {
                SubwayRouteInfo subwayRouteInfo3 = (SubwayRouteInfo) CollectionsKt.firstOrNull((List) subwayStationOption10.getRoutes());
                if (subwayRouteInfo3 != null) {
                    String routeId3 = subwayRouteInfo3.getRouteId();
                    str = routeId3;
                } else {
                    str = "";
                }
            } else {
                str = routeId3;
            }
            arrayList13.add(new SubwayRouteStation(key, name, latitude, longitude, str));
            String key2 = subwayStationOption11.getKey();
            String name2 = subwayStationOption11.getName();
            double latitude2 = subwayStationOption11.getLatitude();
            double longitude2 = subwayStationOption11.getLongitude();
            SubwayRouteInfo subwayRouteInfo4 = (SubwayRouteInfo) CollectionsKt.lastOrNull((List) arrayList14);
            if (subwayRouteInfo4 == null || (routeId = subwayRouteInfo4.getRouteId()) == null) {
                SubwayRouteInfo subwayRouteInfo5 = (SubwayRouteInfo) CollectionsKt.firstOrNull((List) subwayStationOption11.getRoutes());
                if (subwayRouteInfo5 != null) {
                    String routeId4 = subwayRouteInfo5.getRouteId();
                    str2 = routeId4;
                } else {
                    str2 = "";
                }
            } else {
                str2 = routeId4;
            }
            arrayList13.add(new SubwayRouteStation(key2, name2, latitude2, longitude2, str2));
        } else {
            ArrayList arrayList15 = arrayList12;
            if (!Intrinsics.areEqual(((SubwayRouteStation) CollectionsKt.first((List) arrayList15)).getName(), subwayStationOption10.getName())) {
                String key3 = subwayStationOption10.getKey();
                String name3 = subwayStationOption10.getName();
                double latitude3 = subwayStationOption10.getLatitude();
                double longitude3 = subwayStationOption10.getLongitude();
                SubwayRouteInfo subwayRouteInfo6 = (SubwayRouteInfo) CollectionsKt.firstOrNull((List) arrayList4);
                arrayList12.add(0, new SubwayRouteStation(key3, name3, latitude3, longitude3, (subwayRouteInfo6 == null || (routeId2 = subwayRouteInfo6.getRouteId()) == null) ? "" : routeId2));
            }
            if (!Intrinsics.areEqual(((SubwayRouteStation) CollectionsKt.last((List) arrayList15)).getName(), subwayStationOption11.getName())) {
                ArrayList arrayList16 = arrayList12;
                String key4 = subwayStationOption11.getKey();
                String name4 = subwayStationOption11.getName();
                double latitude4 = subwayStationOption11.getLatitude();
                double longitude4 = subwayStationOption11.getLongitude();
                SubwayRouteInfo subwayRouteInfo7 = (SubwayRouteInfo) CollectionsKt.lastOrNull((List) arrayList4);
                arrayList16.add(new SubwayRouteStation(key4, name4, latitude4, longitude4, (subwayRouteInfo7 == null || (routeId = subwayRouteInfo7.getRouteId()) == null) ? "" : routeId));
            }
        }
        SubwayRouteInfo subwayRouteInfo8 = (SubwayRouteInfo) CollectionsKt.firstOrNull((List) arrayList4);
        if (subwayRouteInfo8 == null && (subwayRouteInfo8 = (SubwayRouteInfo) CollectionsKt.firstOrNull((List) subwayStationOption10.getRoutes())) == null) {
            subwayRouteInfo8 = new SubwayRouteInfo(city.getId() + ":google:transit", "地铁", "Transit", FALLBACK_ROUTE_COLOR);
        }
        SubwayRouteInfo subwayRouteInfo9 = subwayRouteInfo8;
        ArrayList arrayList17 = arrayList4;
        SubwayRouteInfo subwayRouteInfo10 = (SubwayRouteInfo) CollectionsKt.firstOrNull(CollectionsKt.drop(arrayList17, 1));
        if (subwayStationOption6 != null) {
            subwayStationOption = subwayStationOption6;
        } else if (subwayRouteInfo10 != null) {
            ArrayList arrayList18 = arrayList12;
            Iterator it3 = arrayList18.iterator();
            int i8 = 0;
            while (true) {
                if (!it3.hasNext()) {
                    i8 = -1;
                } else if (!Intrinsics.areEqual(((SubwayRouteStation) it3.next()).getRouteId(), subwayRouteInfo10.getRouteId())) {
                    i8++;
                }
            }
            SubwayRouteStation subwayRouteStation = (SubwayRouteStation) CollectionsKt.getOrNull(arrayList18, i8);
            subwayStationOption6 = subwayRouteStation != null ? new SubwayStationOption(subwayRouteStation.getStationKey(), subwayRouteStation.getName(), subwayRouteStation.getLatitude(), subwayRouteStation.getLongitude(), CollectionsKt.listOf(subwayRouteInfo10), null, 32, null) : null;
            subwayStationOption = subwayStationOption6;
        } else {
            subwayStationOption = null;
        }
        if (arrayList5.size() >= 2) {
            arrayListListOf = arrayList5;
        } else {
            arrayListListOf = CollectionsKt.listOf((Object[]) new RoutePoint[]{new RoutePoint(subwayStationOption10.getLatitude(), subwayStationOption10.getLongitude()), new RoutePoint(subwayStationOption11.getLatitude(), subwayStationOption11.getLongitude())});
        }
        List list = arrayListListOf;
        String id2 = city.getId();
        String key5 = subwayStationOption != null ? subwayStationOption.getKey() : null;
        return new SubwayRoutePlan(id2, subwayRouteInfo9, subwayRouteInfo10, subwayStationOption, key5 == null ? "" : key5, arrayList12, list, CollectionsKt.toList(arrayList17));
    }

    /* JADX INFO: renamed from: com.example.tickets.GlobalSubwayDataManager$googleResolvePlan$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: GlobalSubwayData.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/example/tickets/GlobalSubwayDataManager$SubwayRoutePlan;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.tickets.GlobalSubwayDataManager$googleResolvePlan$2", f = "GlobalSubwayData.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C03352 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super SubwayRoutePlan>, Object> {
        final /* synthetic */ SubwayCity $city;
        final /* synthetic */ Context $context;
        final /* synthetic */ String $destinationName;
        final /* synthetic */ String $originName;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C03352(Context context, SubwayCity subwayCity, String str, String str2, Continuation<? super C03352> continuation) {
            super(2, continuation);
            this.$context = context;
            this.$city = subwayCity;
            this.$originName = str;
            this.$destinationName = str2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C03352 c03352 = new C03352(this.$context, this.$city, this.$originName, this.$destinationName, continuation);
            c03352.L$0 = obj;
            return c03352;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super SubwayRoutePlan> continuation) {
            return ((C03352) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object objM9536constructorimpl;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            Context context = this.$context;
            SubwayCity subwayCity = this.$city;
            String str = this.$originName;
            String str2 = this.$destinationName;
            try {
                Result.Companion companion = Result.INSTANCE;
                objM9536constructorimpl = Result.m9536constructorimpl(GlobalSubwayDataManager.INSTANCE.googleResolvePlanBlocking(context, subwayCity, str, str2));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objM9536constructorimpl = Result.m9536constructorimpl(ResultKt.createFailure(th));
            }
            if (Result.m9542isFailureimpl(objM9536constructorimpl)) {
                return null;
            }
            return objM9536constructorimpl;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object googleResolvePlan(Context context, SubwayCity subwayCity, String str, String str2, Continuation<? super SubwayRoutePlan> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new C03352(context, subwayCity, str, str2, null), continuation);
    }

    private final SubwayStationOption googleFindStationBlocking(Context context, SubwayCity city, String input) throws JSONException {
        Object next;
        List<SubwayStationOption> listGoogleSearchStationsBlocking = googleSearchStationsBlocking(context, city, input, 8);
        String strNormalizeSearch = normalizeSearch(input);
        Iterator<T> it = listGoogleSearchStationsBlocking.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!Intrinsics.areEqual(INSTANCE.normalizeSearch(((SubwayStationOption) next).getName()), strNormalizeSearch));
        SubwayStationOption subwayStationOption = (SubwayStationOption) next;
        return subwayStationOption == null ? (SubwayStationOption) CollectionsKt.firstOrNull((List) listGoogleSearchStationsBlocking) : subwayStationOption;
    }

    private final SubwayRouteStation googleTransitStopToStation(SubwayCity city, JSONObject stop, SubwayRouteInfo routeInfo) {
        String strOptString = stop.optString(HintConstants.AUTOFILL_HINT_NAME);
        if (StringsKt.isBlank(strOptString)) {
            strOptString = "站点";
        }
        String str = strOptString;
        Pair<Double, Double> pairGoogleRouteLocation = googleRouteLocation(stop);
        double dDoubleValue = pairGoogleRouteLocation.component1().doubleValue();
        double dDoubleValue2 = pairGoogleRouteLocation.component2().doubleValue();
        String id = city.getId();
        Intrinsics.checkNotNull(str);
        return new SubwayRouteStation(id + ":google:route:" + normalizeSearch(str), str, dDoubleValue, dDoubleValue2, routeInfo.getRouteId());
    }

    private final Pair<Double, Double> googleRouteLocation(JSONObject stopOrLocation) {
        double dOptDouble = stopOrLocation.optDouble("latitude", Double.NaN);
        double dOptDouble2 = stopOrLocation.optDouble("longitude", Double.NaN);
        if (Math.abs(dOptDouble) <= Double.MAX_VALUE && Math.abs(dOptDouble2) <= Double.MAX_VALUE) {
            return TuplesKt.to(Double.valueOf(dOptDouble), Double.valueOf(dOptDouble2));
        }
        JSONObject jSONObjectOptJSONObject = stopOrLocation.optJSONObject("location");
        JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject != null ? jSONObjectOptJSONObject.optJSONObject("latLng") : null;
        double dOptDouble3 = jSONObjectOptJSONObject2 != null ? jSONObjectOptJSONObject2.optDouble("latitude", Double.NaN) : Double.NaN;
        double dOptDouble4 = jSONObjectOptJSONObject2 != null ? jSONObjectOptJSONObject2.optDouble("longitude", Double.NaN) : Double.NaN;
        if (Math.abs(dOptDouble3) <= Double.MAX_VALUE && Math.abs(dOptDouble4) <= Double.MAX_VALUE) {
            return TuplesKt.to(Double.valueOf(dOptDouble3), Double.valueOf(dOptDouble4));
        }
        return TuplesKt.to(Double.valueOf(AudioStats.AUDIO_AMPLITUDE_NONE), Double.valueOf(AudioStats.AUDIO_AMPLITUDE_NONE));
    }

    static /* synthetic */ JSONObject googlePostJson$default(GlobalSubwayDataManager globalSubwayDataManager, String str, String str2, String str3, JSONObject jSONObject, String str4, int i, Object obj) {
        if ((i & 16) != 0) {
            str4 = "X-Goog-Api-Key";
        }
        return globalSubwayDataManager.googlePostJson(str, str2, str3, jSONObject, str4);
    }

    private final JSONObject googlePostJson(String urlString, String apiKey, String fieldMask, JSONObject body, String apiKeyHeader) throws IOException {
        InputStream errorStream;
        URLConnection uRLConnectionOpenConnection = new URL(urlString).openConnection();
        Intrinsics.checkNotNull(uRLConnectionOpenConnection, "null cannot be cast to non-null type java.net.HttpURLConnection");
        HttpURLConnection httpURLConnection = (HttpURLConnection) uRLConnectionOpenConnection;
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setConnectTimeout(AccessibilityNodeInfoCompat.EXTRA_DATA_TEXT_CHARACTER_LOCATION_ARG_MAX_LENGTH);
        httpURLConnection.setReadTimeout(30000);
        httpURLConnection.setInstanceFollowRedirects(true);
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setRequestProperty("Content-Type", "application/json");
        httpURLConnection.setRequestProperty(apiKeyHeader, apiKey);
        httpURLConnection.setRequestProperty("X-Goog-FieldMask", fieldMask);
        httpURLConnection.setRequestProperty("User-Agent", "Tickets/6.0 SubwayData");
        try {
            OutputStream outputStream = httpURLConnection.getOutputStream();
            Intrinsics.checkNotNullExpressionValue(outputStream, "getOutputStream(...)");
            Writer outputStreamWriter = new OutputStreamWriter(outputStream, Charsets.UTF_8);
            BufferedWriter bufferedWriter = outputStreamWriter instanceof BufferedWriter ? (BufferedWriter) outputStreamWriter : new BufferedWriter(outputStreamWriter, 8192);
            try {
                bufferedWriter.write(body.toString());
                Unit unit = Unit.INSTANCE;
                String str = null;
                CloseableKt.closeFinally(bufferedWriter, null);
                int responseCode = httpURLConnection.getResponseCode();
                if (200 <= responseCode && responseCode < 300) {
                    errorStream = httpURLConnection.getInputStream();
                } else {
                    errorStream = httpURLConnection.getErrorStream();
                }
                if (errorStream != null) {
                    Reader inputStreamReader = new InputStreamReader(errorStream, Charsets.UTF_8);
                    BufferedReader bufferedReader = inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, 8192);
                    try {
                        String text = TextStreamsKt.readText(bufferedReader);
                        CloseableKt.closeFinally(bufferedReader, null);
                        str = text;
                    } catch (Throwable th) {
                        try {
                            throw th;
                        } catch (Throwable th2) {
                            CloseableKt.closeFinally(bufferedReader, th);
                            throw th2;
                        }
                    }
                }
                if (str == null) {
                    str = "";
                }
                if (200 > responseCode || responseCode >= 300) {
                    throw new IllegalStateException("Google Maps API HTTP " + responseCode + ": " + str);
                }
                JSONObject jSONObject = new JSONObject(str);
                httpURLConnection.disconnect();
                return jSONObject;
            } catch (Throwable th3) {
                try {
                    throw th3;
                } catch (Throwable th4) {
                    CloseableKt.closeFinally(bufferedWriter, th3);
                    throw th4;
                }
            }
        } catch (Throwable th5) {
            httpURLConnection.disconnect();
            throw th5;
        }
    }

    private final Integer parseHexColor(String raw) {
        Object objM9536constructorimpl;
        String strRemovePrefix = StringsKt.removePrefix(StringsKt.trim((CharSequence) raw).toString(), (CharSequence) "#");
        if (strRemovePrefix.length() != 6) {
            return null;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            GlobalSubwayDataManager globalSubwayDataManager = this;
            objM9536constructorimpl = Result.m9536constructorimpl(Integer.valueOf((int) (Long.parseLong(strRemovePrefix, CharsKt.checkRadix(16)) | 4278190080L)));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM9536constructorimpl = Result.m9536constructorimpl(ResultKt.createFailure(th));
        }
        return (Integer) (Result.m9542isFailureimpl(objM9536constructorimpl) ? null : objM9536constructorimpl);
    }

    private final List<RoutePoint> decodeEncodedPolyline(String encoded) {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (i < encoded.length()) {
            int i4 = 0;
            int i5 = 0;
            while (i < encoded.length()) {
                int i6 = i + 1;
                int iCharAt = encoded.charAt(i) - '?';
                i4 |= (iCharAt & 31) << i5;
                i5 += 5;
                if (iCharAt < 32) {
                    i = i6;
                    break;
                }
                i = i6;
            }
            i2 += (i4 & 1) != 0 ? ~(i4 >>> 1) : i4 >>> 1;
            int i7 = 0;
            int i8 = 0;
            while (i < encoded.length()) {
                int i9 = i + 1;
                int iCharAt2 = encoded.charAt(i) - '?';
                i7 |= (iCharAt2 & 31) << i8;
                i8 += 5;
                if (iCharAt2 < 32) {
                    i = i9;
                    break;
                }
                i = i9;
            }
            i3 += (i7 & 1) != 0 ? ~(i7 >>> 1) : i7 >>> 1;
            arrayList.add(new RoutePoint(((double) i2) / 100000.0d, ((double) i3) / 100000.0d));
        }
        return arrayList;
    }

    private final double nearestDistanceToRoute(double latitude, double longitude, List<RoutePoint> path) {
        double dMin = Double.MAX_VALUE;
        if (path.isEmpty()) {
            return Double.MAX_VALUE;
        }
        for (RoutePoint routePoint : path) {
            dMin = Math.min(dMin, distanceMeters(latitude, longitude, routePoint.getLatitude(), routePoint.getLongitude()));
        }
        return dMin;
    }

    public final Object searchNearbyGoogleStations$app(Context context, SubwayCity subwayCity, double d, double d2, double d3, Continuation<? super List<SubwayStationOption>> continuation) {
        return googleNearbyStations(context, subwayCity, d, d2, d3, continuation);
    }

    public final void clearCurrentCache(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        synchronized (cacheLock) {
            memoryIndexes.clear();
            try {
                Result.Companion companion = Result.INSTANCE;
                Result.m9536constructorimpl(Boolean.valueOf(new File(context.getCacheDir(), CACHE_FILE_NAME).delete()));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                Result.m9536constructorimpl(ResultKt.createFailure(th));
            }
            try {
                Result.Companion companion3 = Result.INSTANCE;
                context.getSharedPreferences(PREFS_NAME, 0).edit().remove(PREF_ACTIVE_CITY).remove(PREF_LAST_BUILD).apply();
                Result.m9536constructorimpl(Unit.INSTANCE);
            } catch (Throwable th2) {
                Result.Companion companion4 = Result.INSTANCE;
                Result.m9536constructorimpl(ResultKt.createFailure(th2));
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:124:0x0233  */
    /* JADX WARN: Code duplicated, block: B:125:0x0234  */
    /* JADX WARN: Code duplicated, block: B:133:0x0259  */
    /* JADX WARN: Code duplicated, block: B:134:0x025a  */
    /* JADX WARN: Code duplicated, block: B:142:0x027b  */
    /* JADX WARN: Code duplicated, block: B:143:0x027c  */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final StaticIndex loadOrBuildIndex$app(Context context, String cityId) throws Throwable {
        StaticIndex staticIndexBuildIndexForCity;
        Object objM9536constructorimpl;
        Object obj;
        StaticIndex staticIndex;
        Object objM9536constructorimpl2;
        Object obj2;
        StaticIndex staticIndex2;
        Object objM9536constructorimpl3;
        Object obj3;
        Object objM9536constructorimpl4;
        Object objM9536constructorimpl5;
        Object objM9536constructorimpl6;
        Object objM9536constructorimpl7;
        Object objM9536constructorimpl8;
        Object objM9536constructorimpl9;
        Object objM9536constructorimpl10;
        Object objM9536constructorimpl11;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(cityId, "cityId");
        SubwayLineColorRepository.INSTANCE.ensureInitialized(context);
        StaticIndex staticIndex3 = memoryIndexes.get(cityId);
        if (staticIndex3 != null) {
            return staticIndex3;
        }
        SubwayCity subwayCityCityOrNull = cityOrNull(cityId);
        if (subwayCityCityOrNull == null && (subwayCityCityOrNull = cityOrNull("nyc")) == null) {
            throw new IllegalStateException("No subway city configured");
        }
        if (subwayCityCityOrNull.getSourceType() == SourceType.TAIWAN_TDX) {
            StaticIndex staticIndexLoadTaiwanRemoteIndex = loadTaiwanRemoteIndex(context, subwayCityCityOrNull);
            try {
                Result.Companion companion = Result.INSTANCE;
                GlobalSubwayDataManager globalSubwayDataManager = this;
                objM9536constructorimpl10 = Result.m9536constructorimpl(applyCanonicalLineColors(subwayCityCityOrNull.getId(), staticIndexLoadTaiwanRemoteIndex));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objM9536constructorimpl10 = Result.m9536constructorimpl(ResultKt.createFailure(th));
            }
            Object obj4 = staticIndexLoadTaiwanRemoteIndex;
            if (!Result.m9542isFailureimpl(objM9536constructorimpl10)) {
                obj4 = objM9536constructorimpl10;
            }
            StaticIndex staticIndex4 = (StaticIndex) obj4;
            try {
                Result.Companion companion3 = Result.INSTANCE;
                GlobalSubwayDataManager globalSubwayDataManager2 = this;
                objM9536constructorimpl11 = Result.m9536constructorimpl(normalizeStaticIndexTopology(staticIndex4));
            } catch (Throwable th2) {
                Result.Companion companion4 = Result.INSTANCE;
                objM9536constructorimpl11 = Result.m9536constructorimpl(ResultKt.createFailure(th2));
            }
            Object obj5 = staticIndex4;
            if (!Result.m9542isFailureimpl(objM9536constructorimpl11)) {
                obj5 = objM9536constructorimpl11;
            }
            StaticIndex staticIndex5 = (StaticIndex) obj5;
            memoryIndexes.put(cityId, staticIndex5);
            return staticIndex5;
        }
        if (subwayCityCityOrNull.getSourceType() == SourceType.LOCAL_US) {
            StaticIndex staticIndexLoadLocalUsIndex = loadLocalUsIndex(context, subwayCityCityOrNull);
            try {
                Result.Companion companion5 = Result.INSTANCE;
                GlobalSubwayDataManager globalSubwayDataManager3 = this;
                objM9536constructorimpl7 = Result.m9536constructorimpl(applyCanonicalLineColors(subwayCityCityOrNull.getId(), staticIndexLoadLocalUsIndex));
            } catch (Throwable th3) {
                Result.Companion companion6 = Result.INSTANCE;
                objM9536constructorimpl7 = Result.m9536constructorimpl(ResultKt.createFailure(th3));
            }
            Object obj6 = staticIndexLoadLocalUsIndex;
            if (!Result.m9542isFailureimpl(objM9536constructorimpl7)) {
                obj6 = objM9536constructorimpl7;
            }
            StaticIndex staticIndex6 = (StaticIndex) obj6;
            try {
                Result.Companion companion7 = Result.INSTANCE;
                GlobalSubwayDataManager globalSubwayDataManager4 = this;
                objM9536constructorimpl8 = Result.m9536constructorimpl(sanitizeWuhanRouteTopology(subwayCityCityOrNull.getId(), staticIndex6));
            } catch (Throwable th4) {
                Result.Companion companion8 = Result.INSTANCE;
                objM9536constructorimpl8 = Result.m9536constructorimpl(ResultKt.createFailure(th4));
            }
            Object obj7 = staticIndex6;
            if (!Result.m9542isFailureimpl(objM9536constructorimpl8)) {
                obj7 = objM9536constructorimpl8;
            }
            StaticIndex staticIndex7 = (StaticIndex) obj7;
            try {
                Result.Companion companion9 = Result.INSTANCE;
                GlobalSubwayDataManager globalSubwayDataManager5 = this;
                objM9536constructorimpl9 = Result.m9536constructorimpl(normalizeStaticIndexTopology(staticIndex7));
            } catch (Throwable th5) {
                Result.Companion companion10 = Result.INSTANCE;
                objM9536constructorimpl9 = Result.m9536constructorimpl(ResultKt.createFailure(th5));
            }
            Object obj8 = staticIndex7;
            if (!Result.m9542isFailureimpl(objM9536constructorimpl9)) {
                obj8 = objM9536constructorimpl9;
            }
            StaticIndex staticIndex8 = (StaticIndex) obj8;
            memoryIndexes.put(cityId, staticIndex8);
            return staticIndex8;
        }
        File file = new File(context.getCacheDir(), CACHE_FILE_NAME);
        synchronized (cacheLock) {
            SharedPreferences sharedPreferences = context.getSharedPreferences(PREFS_NAME, 0);
            String string = sharedPreferences.getString(PREF_ACTIVE_CITY, "");
            if (string == null) {
                string = "";
            }
            long jCurrentTimeMillis = System.currentTimeMillis() - sharedPreferences.getLong(PREF_LAST_BUILD, 0L);
            if (Intrinsics.areEqual(string, subwayCityCityOrNull.getId()) && file.exists() && jCurrentTimeMillis < 604800000) {
                GlobalSubwayDataManager globalSubwayDataManager6 = INSTANCE;
                try {
                    Result.Companion companion11 = Result.INSTANCE;
                    StaticIndex staticIndexLoadIndex = globalSubwayDataManager6.loadIndex(file);
                    try {
                        Result.Companion companion12 = Result.INSTANCE;
                        objM9536constructorimpl4 = Result.m9536constructorimpl(globalSubwayDataManager6.applyCanonicalLineColors(subwayCityCityOrNull.getId(), staticIndexLoadIndex));
                    } catch (Throwable th6) {
                        Result.Companion companion13 = Result.INSTANCE;
                        objM9536constructorimpl4 = Result.m9536constructorimpl(ResultKt.createFailure(th6));
                    }
                    StaticIndex staticIndex9 = (StaticIndex) (Result.m9542isFailureimpl(objM9536constructorimpl4) ? staticIndexLoadIndex : objM9536constructorimpl4);
                    try {
                        Result.Companion companion14 = Result.INSTANCE;
                        objM9536constructorimpl5 = Result.m9536constructorimpl(globalSubwayDataManager6.sanitizeWuhanRouteTopology(subwayCityCityOrNull.getId(), staticIndex9));
                    } catch (Throwable th7) {
                        Result.Companion companion15 = Result.INSTANCE;
                        objM9536constructorimpl5 = Result.m9536constructorimpl(ResultKt.createFailure(th7));
                    }
                    StaticIndex staticIndex10 = (StaticIndex) (Result.m9542isFailureimpl(objM9536constructorimpl5) ? staticIndex9 : objM9536constructorimpl5);
                    try {
                        Result.Companion companion16 = Result.INSTANCE;
                        objM9536constructorimpl6 = Result.m9536constructorimpl(globalSubwayDataManager6.normalizeStaticIndexTopology(staticIndex10));
                    } catch (Throwable th8) {
                        Result.Companion companion17 = Result.INSTANCE;
                        objM9536constructorimpl6 = Result.m9536constructorimpl(ResultKt.createFailure(th8));
                    }
                    StaticIndex staticIndex11 = (StaticIndex) (Result.m9542isFailureimpl(objM9536constructorimpl6) ? staticIndex10 : objM9536constructorimpl6);
                    memoryIndexes.put(subwayCityCityOrNull.getId(), staticIndex11);
                    try {
                        Result.Companion companion18 = Result.INSTANCE;
                        globalSubwayDataManager6.saveIndex(file, staticIndex11);
                        Result.m9536constructorimpl(Unit.INSTANCE);
                    } catch (Throwable th9) {
                        Result.Companion companion19 = Result.INSTANCE;
                        Result.m9536constructorimpl(ResultKt.createFailure(th9));
                    }
                    return staticIndex11;
                } catch (Throwable th10) {
                    Result.Companion companion20 = Result.INSTANCE;
                    Result.m9536constructorimpl(ResultKt.createFailure(th10));
                    Result.Companion companion21 = Result.INSTANCE;
                    Result.m9536constructorimpl(Boolean.valueOf(file.delete()));
                    GlobalSubwayDataManager globalSubwayDataManager7 = INSTANCE;
                    staticIndexBuildIndexForCity = globalSubwayDataManager7.buildIndexForCity(context, subwayCityCityOrNull);
                    Result.Companion companion22 = Result.INSTANCE;
                    objM9536constructorimpl = Result.m9536constructorimpl(globalSubwayDataManager7.applyCanonicalLineColors(subwayCityCityOrNull.getId(), staticIndexBuildIndexForCity));
                    if (Result.m9542isFailureimpl(objM9536constructorimpl)) {
                        obj = staticIndexBuildIndexForCity;
                    } else {
                        obj = objM9536constructorimpl;
                    }
                    staticIndex = (StaticIndex) obj;
                    GlobalSubwayDataManager globalSubwayDataManager8 = INSTANCE;
                    Result.Companion companion23 = Result.INSTANCE;
                    objM9536constructorimpl2 = Result.m9536constructorimpl(globalSubwayDataManager8.sanitizeWuhanRouteTopology(subwayCityCityOrNull.getId(), staticIndex));
                    if (Result.m9542isFailureimpl(objM9536constructorimpl2)) {
                        obj2 = staticIndex;
                    } else {
                        obj2 = objM9536constructorimpl2;
                    }
                    staticIndex2 = (StaticIndex) obj2;
                    GlobalSubwayDataManager globalSubwayDataManager9 = INSTANCE;
                    Result.Companion companion24 = Result.INSTANCE;
                    objM9536constructorimpl3 = Result.m9536constructorimpl(globalSubwayDataManager9.normalizeStaticIndexTopology(staticIndex2));
                    if (Result.m9542isFailureimpl(objM9536constructorimpl3)) {
                        obj3 = staticIndex2;
                    } else {
                        obj3 = objM9536constructorimpl3;
                    }
                    StaticIndex staticIndex12 = (StaticIndex) obj3;
                    memoryIndexes.put(subwayCityCityOrNull.getId(), staticIndex12);
                    GlobalSubwayDataManager globalSubwayDataManager10 = INSTANCE;
                    Result.Companion companion25 = Result.INSTANCE;
                    globalSubwayDataManager10.saveIndex(file, staticIndex12);
                    Result.m9536constructorimpl(Unit.INSTANCE);
                    sharedPreferences.edit().putString(PREF_ACTIVE_CITY, subwayCityCityOrNull.getId()).putLong(PREF_LAST_BUILD, System.currentTimeMillis()).apply();
                    return staticIndex12;
                }
            }
            try {
                Result.Companion companion26 = Result.INSTANCE;
                Result.m9536constructorimpl(Boolean.valueOf(file.delete()));
            } catch (Throwable th11) {
                Result.Companion companion27 = Result.INSTANCE;
                Result.m9536constructorimpl(ResultKt.createFailure(th11));
            }
            GlobalSubwayDataManager globalSubwayDataManager11 = INSTANCE;
            staticIndexBuildIndexForCity = globalSubwayDataManager11.buildIndexForCity(context, subwayCityCityOrNull);
            try {
                Result.Companion companion28 = Result.INSTANCE;
                objM9536constructorimpl = Result.m9536constructorimpl(globalSubwayDataManager11.applyCanonicalLineColors(subwayCityCityOrNull.getId(), staticIndexBuildIndexForCity));
            } catch (Throwable th12) {
                Result.Companion companion29 = Result.INSTANCE;
                objM9536constructorimpl = Result.m9536constructorimpl(ResultKt.createFailure(th12));
            }
            if (Result.m9542isFailureimpl(objM9536constructorimpl)) {
                obj = staticIndexBuildIndexForCity;
            } else {
                obj = objM9536constructorimpl;
            }
            staticIndex = (StaticIndex) obj;
            GlobalSubwayDataManager globalSubwayDataManager12 = INSTANCE;
            try {
                Result.Companion companion210 = Result.INSTANCE;
                objM9536constructorimpl2 = Result.m9536constructorimpl(globalSubwayDataManager12.sanitizeWuhanRouteTopology(subwayCityCityOrNull.getId(), staticIndex));
            } catch (Throwable th13) {
                Result.Companion companion30 = Result.INSTANCE;
                objM9536constructorimpl2 = Result.m9536constructorimpl(ResultKt.createFailure(th13));
            }
            if (Result.m9542isFailureimpl(objM9536constructorimpl2)) {
                obj2 = staticIndex;
            } else {
                obj2 = objM9536constructorimpl2;
            }
            staticIndex2 = (StaticIndex) obj2;
            GlobalSubwayDataManager globalSubwayDataManager13 = INSTANCE;
            try {
                Result.Companion companion211 = Result.INSTANCE;
                objM9536constructorimpl3 = Result.m9536constructorimpl(globalSubwayDataManager13.normalizeStaticIndexTopology(staticIndex2));
            } catch (Throwable th14) {
                Result.Companion companion31 = Result.INSTANCE;
                objM9536constructorimpl3 = Result.m9536constructorimpl(ResultKt.createFailure(th14));
            }
            if (Result.m9542isFailureimpl(objM9536constructorimpl3)) {
                obj3 = staticIndex2;
            } else {
                obj3 = objM9536constructorimpl3;
            }
            StaticIndex staticIndex13 = (StaticIndex) obj3;
            memoryIndexes.put(subwayCityCityOrNull.getId(), staticIndex13);
            GlobalSubwayDataManager globalSubwayDataManager14 = INSTANCE;
            try {
                Result.Companion companion212 = Result.INSTANCE;
                globalSubwayDataManager14.saveIndex(file, staticIndex13);
                Result.m9536constructorimpl(Unit.INSTANCE);
            } catch (Throwable th15) {
                Result.Companion companion32 = Result.INSTANCE;
                Result.m9536constructorimpl(ResultKt.createFailure(th15));
            }
            sharedPreferences.edit().putString(PREF_ACTIVE_CITY, subwayCityCityOrNull.getId()).putLong(PREF_LAST_BUILD, System.currentTimeMillis()).apply();
            return staticIndex13;
            throw th;
        }
    }

    private final StaticIndex buildIndexForCity(Context context, SubwayCity city) {
        int i = WhenMappings.$EnumSwitchMapping$0[city.getSourceType().ordinal()];
        if (i == 1) {
            return buildAmapIndex(city);
        }
        if (i == 2) {
            throw new IllegalStateException("Google 城市不建立静态索引".toString());
        }
        if (i == 3) {
            return loadLocalUsIndex(context, city);
        }
        if (i != 4) {
            throw new NoWhenBranchMatchedException();
        }
        throw new IllegalStateException("Taiwan TDX 城市通过 Worker 加载静态索引".toString());
    }

    private final StaticIndex loadTaiwanRemoteIndex(Context context, SubwayCity city) throws Throwable {
        Object objM9536constructorimpl;
        Object objM9536constructorimpl2;
        if (city.getSourceType() != SourceType.TAIWAN_TDX) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        File file = new File(context.getFilesDir(), TAIWAN_CACHE_DIR);
        File file2 = new File(file, city.getId() + ".json.gz");
        if (file2.exists() && System.currentTimeMillis() - file2.lastModified() <= 604800000) {
            try {
                Result.Companion companion = Result.INSTANCE;
                GlobalSubwayDataManager globalSubwayDataManager = this;
                StaticIndex staticIndexFromJson = fromJson(loadGzipJson(file2));
                if (!staticIndexFromJson.getStationsByKey().isEmpty() && !staticIndexFromJson.getRoutePatterns().isEmpty()) {
                    return staticIndexFromJson;
                }
                Result.m9536constructorimpl(Unit.INSTANCE);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                Result.m9536constructorimpl(ResultKt.createFailure(th));
            }
        }
        String str = StringsKt.trimEnd("https://tickets-us-transit.hyl120309.workers.dev", '/') + "/api/v1/tw/" + URLEncoder.encode(city.getId(), "UTF-8") + "/index";
        try {
            Result.Companion companion3 = Result.INSTANCE;
            GlobalSubwayDataManager globalSubwayDataManager2 = this;
            URLConnection uRLConnectionOpenConnection = new URL(str).openConnection();
            Intrinsics.checkNotNull(uRLConnectionOpenConnection, "null cannot be cast to non-null type java.net.HttpURLConnection");
            HttpURLConnection httpURLConnection = (HttpURLConnection) uRLConnectionOpenConnection;
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setConnectTimeout(ConnectionsStatusCodes.STATUS_NETWORK_NOT_CONNECTED);
            httpURLConnection.setReadTimeout(15000);
            httpURLConnection.setInstanceFollowRedirects(true);
            httpURLConnection.setRequestProperty("Accept", "application/json");
            httpURLConnection.setRequestProperty("User-Agent", "Tickets/7.0 TaiwanMetro");
            try {
                int responseCode = httpURLConnection.getResponseCode();
                if (200 > responseCode || responseCode >= 300) {
                    throw new IllegalStateException("Taiwan Transit Worker HTTP " + httpURLConnection.getResponseCode());
                }
                InputStream inputStream = httpURLConnection.getInputStream();
                Intrinsics.checkNotNullExpressionValue(inputStream, "getInputStream(...)");
                Reader inputStreamReader = new InputStreamReader(inputStream, Charsets.UTF_8);
                BufferedReader bufferedReader = inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, 8192);
                try {
                    String text = TextStreamsKt.readText(bufferedReader);
                    CloseableKt.closeFinally(bufferedReader, null);
                    JSONObject jSONObject = new JSONObject(text);
                    if (!Intrinsics.areEqual(jSONObject.optString("cityId"), city.getId())) {
                        String strOptString = jSONObject.optString("cityId");
                        if (strOptString == null) {
                            strOptString = "";
                        }
                        throw new IllegalStateException("Taiwan Transit Worker returned wrong cityId: " + strOptString);
                    }
                    StaticIndex staticIndexFromJson2 = fromJson(jSONObject);
                    if (staticIndexFromJson2.getStationsByKey().isEmpty() || staticIndexFromJson2.getRoutePatterns().isEmpty()) {
                        throw new IllegalStateException("Taipei transit index is empty");
                    }
                    file.mkdirs();
                    saveJsonGzip(file2, jSONObject);
                    httpURLConnection.disconnect();
                    objM9536constructorimpl = Result.m9536constructorimpl(staticIndexFromJson2);
                    Throwable thM9539exceptionOrNullimpl = Result.m9539exceptionOrNullimpl(objM9536constructorimpl);
                    if (thM9539exceptionOrNullimpl != null) {
                        if (!file2.exists()) {
                            throw thM9539exceptionOrNullimpl;
                        }
                        GlobalSubwayDataManager globalSubwayDataManager3 = INSTANCE;
                        try {
                            Result.Companion companion4 = Result.INSTANCE;
                            objM9536constructorimpl2 = Result.m9536constructorimpl(globalSubwayDataManager3.fromJson(globalSubwayDataManager3.loadGzipJson(file2)));
                        } catch (Throwable th2) {
                            Result.Companion companion5 = Result.INSTANCE;
                            objM9536constructorimpl2 = Result.m9536constructorimpl(ResultKt.createFailure(th2));
                        }
                        Throwable thM9539exceptionOrNullimpl2 = Result.m9539exceptionOrNullimpl(objM9536constructorimpl2);
                        if (thM9539exceptionOrNullimpl2 != null) {
                            throw thM9539exceptionOrNullimpl2;
                        }
                        objM9536constructorimpl = (StaticIndex) objM9536constructorimpl2;
                    }
                    return (StaticIndex) objM9536constructorimpl;
                } catch (Throwable th3) {
                    try {
                        throw th3;
                    } catch (Throwable th4) {
                        CloseableKt.closeFinally(bufferedReader, th3);
                        throw th4;
                    }
                }
            } catch (Throwable th5) {
                httpURLConnection.disconnect();
                throw th5;
            }
        } catch (Throwable th6) {
            Result.Companion companion6 = Result.INSTANCE;
            objM9536constructorimpl = Result.m9536constructorimpl(ResultKt.createFailure(th6));
        }
    }

    private final JSONObject loadGzipJson(File file) throws IOException {
        GZIPInputStream gZIPInputStream = new GZIPInputStream(new FileInputStream(file));
        try {
            InputStreamReader inputStreamReader = new InputStreamReader(gZIPInputStream, Charsets.UTF_8);
            try {
                JSONObject jSONObject = new JSONObject(TextStreamsKt.readText(inputStreamReader));
                CloseableKt.closeFinally(inputStreamReader, null);
                CloseableKt.closeFinally(gZIPInputStream, null);
                return jSONObject;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    CloseableKt.closeFinally(inputStreamReader, th);
                    throw th2;
                }
            }
        } catch (Throwable th3) {
            try {
                throw th3;
            } catch (Throwable th4) {
                CloseableKt.closeFinally(gZIPInputStream, th3);
                throw th4;
            }
        }
    }

    private final void saveJsonGzip(File file, JSONObject json) throws IOException {
        File file2 = new File(file.getParentFile(), file.getName() + ".tmp");
        OutputStream fileOutputStream = new FileOutputStream(file2);
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(fileOutputStream instanceof BufferedOutputStream ? (BufferedOutputStream) fileOutputStream : new BufferedOutputStream(fileOutputStream, 8192));
        try {
            String string = json.toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            byte[] bytes = string.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
            gZIPOutputStream.write(bytes);
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(gZIPOutputStream, null);
            if (file.exists()) {
                file.delete();
            }
            file2.renameTo(file);
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                CloseableKt.closeFinally(gZIPOutputStream, th);
                throw th2;
            }
        }
    }

    private final StaticIndex loadLocalUsIndex(Context context, SubwayCity city) {
        Object objM9536constructorimpl;
        Object objM9536constructorimpl2;
        StaticIndex staticIndex;
        Object objM9536constructorimpl3;
        Object objM9536constructorimpl4;
        if (city.getSourceType() != SourceType.LOCAL_US) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        String localAssetPath = city.getLocalAssetPath();
        if (StringsKt.isBlank(localAssetPath)) {
            localAssetPath = LOCAL_US_ASSET_PREFIX + city.getId() + ".json.gz";
        }
        String str = localAssetPath;
        try {
            Result.Companion companion = Result.INSTANCE;
            GlobalSubwayDataManager globalSubwayDataManager = this;
            InputStream inputStreamOpen = context.getAssets().open(str);
            try {
                Reader inputStreamReader = new InputStreamReader(new GZIPInputStream(inputStreamOpen), Charsets.UTF_8);
                BufferedReader bufferedReader = inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, 8192);
                try {
                    StaticIndex staticIndexNormalizeLocalUsIndex = normalizeLocalUsIndex(city.getId(), fromJson(new JSONObject(TextStreamsKt.readText(bufferedReader))));
                    if (!staticIndexNormalizeLocalUsIndex.getStationsByKey().isEmpty()) {
                        CloseableKt.closeFinally(bufferedReader, null);
                        CloseableKt.closeFinally(inputStreamOpen, null);
                        return staticIndexNormalizeLocalUsIndex;
                    }
                    Unit unit = Unit.INSTANCE;
                    CloseableKt.closeFinally(bufferedReader, null);
                    Unit unit2 = Unit.INSTANCE;
                    CloseableKt.closeFinally(inputStreamOpen, null);
                    Result.m9536constructorimpl(Unit.INSTANCE);
                    File file = new File(context.getFilesDir(), LOCAL_US_FILE_DIR);
                    File file2 = new File(file, city.getId() + ".json.gz");
                    if (file2.exists() && System.currentTimeMillis() - file2.lastModified() <= 604800000) {
                        try {
                            Result.Companion companion2 = Result.INSTANCE;
                            GlobalSubwayDataManager globalSubwayDataManager2 = this;
                            StaticIndex staticIndexNormalizeLocalUsIndex2 = normalizeLocalUsIndex(city.getId(), loadIndex(file2));
                            if (!staticIndexNormalizeLocalUsIndex2.getStationsByKey().isEmpty()) {
                                return staticIndexNormalizeLocalUsIndex2;
                            }
                            Result.m9536constructorimpl(Unit.INSTANCE);
                        } catch (Throwable th) {
                            Result.Companion companion3 = Result.INSTANCE;
                            Result.m9536constructorimpl(ResultKt.createFailure(th));
                        }
                    }
                    if (SERVER_PATTERN_US_CITY_IDS.contains(city.getId())) {
                        if (!file2.exists()) {
                            file2 = null;
                        }
                        if (file2 != null) {
                            GlobalSubwayDataManager globalSubwayDataManager3 = INSTANCE;
                            try {
                                Result.Companion companion4 = Result.INSTANCE;
                                objM9536constructorimpl4 = Result.m9536constructorimpl(globalSubwayDataManager3.normalizeLocalUsIndex(city.getId(), globalSubwayDataManager3.loadIndex(file2)));
                            } catch (Throwable th2) {
                                Result.Companion companion5 = Result.INSTANCE;
                                objM9536constructorimpl4 = Result.m9536constructorimpl(ResultKt.createFailure(th2));
                            }
                            StaticIndex staticIndex2 = (StaticIndex) (Result.m9542isFailureimpl(objM9536constructorimpl4) ? null : objM9536constructorimpl4);
                            if (staticIndex2 != null) {
                                return staticIndex2;
                            }
                        }
                        return new StaticIndex(MapsKt.emptyMap(), MapsKt.emptyMap(), MapsKt.emptyMap(), MapsKt.emptyMap());
                    }
                    if (StringsKt.isBlank(city.getStaticGtfsUrl())) {
                        if (!file2.exists()) {
                            file2 = null;
                        }
                        if (file2 != null) {
                            GlobalSubwayDataManager globalSubwayDataManager4 = INSTANCE;
                            try {
                                Result.Companion companion6 = Result.INSTANCE;
                                objM9536constructorimpl3 = Result.m9536constructorimpl(globalSubwayDataManager4.normalizeLocalUsIndex(city.getId(), globalSubwayDataManager4.loadIndex(file2)));
                            } catch (Throwable th3) {
                                Result.Companion companion7 = Result.INSTANCE;
                                objM9536constructorimpl3 = Result.m9536constructorimpl(ResultKt.createFailure(th3));
                            }
                            StaticIndex staticIndex3 = (StaticIndex) (Result.m9542isFailureimpl(objM9536constructorimpl3) ? null : objM9536constructorimpl3);
                            if (staticIndex3 != null) {
                                return staticIndex3;
                            }
                        }
                        return new StaticIndex(MapsKt.emptyMap(), MapsKt.emptyMap(), MapsKt.emptyMap(), MapsKt.emptyMap());
                    }
                    try {
                        Result.Companion companion8 = Result.INSTANCE;
                        GlobalSubwayDataManager globalSubwayDataManager5 = this;
                        file.mkdirs();
                        File file3 = new File(file, city.getId() + ".gtfs.zip");
                        File file4 = new File(file, city.getId() + ".gtfs.zip.tmp");
                        downloadBinary(city.getStaticGtfsUrl(), file4);
                        if (file3.exists()) {
                            file3.delete();
                        }
                        file4.renameTo(file3);
                        StaticIndex staticIndexNormalizeLocalUsIndex3 = normalizeLocalUsIndex(city.getId(), parseGtfsStaticZip(city, file3));
                        saveIndex(file2, staticIndexNormalizeLocalUsIndex3);
                        try {
                            Result.Companion companion9 = Result.INSTANCE;
                            Result.m9536constructorimpl(Boolean.valueOf(file3.delete()));
                        } catch (Throwable th4) {
                            Result.Companion companion10 = Result.INSTANCE;
                            Result.m9536constructorimpl(ResultKt.createFailure(th4));
                        }
                        objM9536constructorimpl = Result.m9536constructorimpl(staticIndexNormalizeLocalUsIndex3);
                    } catch (Throwable th5) {
                        Result.Companion companion11 = Result.INSTANCE;
                        objM9536constructorimpl = Result.m9536constructorimpl(ResultKt.createFailure(th5));
                    }
                    if (Result.m9539exceptionOrNullimpl(objM9536constructorimpl) != null) {
                        GlobalSubwayDataManager globalSubwayDataManager6 = INSTANCE;
                        try {
                            Result.Companion companion12 = Result.INSTANCE;
                            if (file2.exists()) {
                                staticIndex = globalSubwayDataManager6.normalizeLocalUsIndex(city.getId(), globalSubwayDataManager6.loadIndex(file2));
                            } else {
                                staticIndex = new StaticIndex(MapsKt.emptyMap(), MapsKt.emptyMap(), MapsKt.emptyMap(), MapsKt.emptyMap());
                            }
                            objM9536constructorimpl2 = Result.m9536constructorimpl(staticIndex);
                        } catch (Throwable th6) {
                            Result.Companion companion13 = Result.INSTANCE;
                            objM9536constructorimpl2 = Result.m9536constructorimpl(ResultKt.createFailure(th6));
                        }
                        StaticIndex staticIndex4 = new StaticIndex(MapsKt.emptyMap(), MapsKt.emptyMap(), MapsKt.emptyMap(), MapsKt.emptyMap());
                        if (Result.m9542isFailureimpl(objM9536constructorimpl2)) {
                            objM9536constructorimpl2 = staticIndex4;
                        }
                        objM9536constructorimpl = (StaticIndex) objM9536constructorimpl2;
                    }
                    return (StaticIndex) objM9536constructorimpl;
                } catch (Throwable th7) {
                    try {
                        throw th7;
                    } catch (Throwable th8) {
                        CloseableKt.closeFinally(bufferedReader, th7);
                        throw th8;
                    }
                }
            } catch (Throwable th9) {
                throw th9;
            }
            try {
                throw th9;
            } catch (Throwable th10) {
                CloseableKt.closeFinally(inputStreamOpen, th9);
                throw th10;
            }
        } catch (Throwable th11) {
            Result.Companion companion14 = Result.INSTANCE;
            Result.m9536constructorimpl(ResultKt.createFailure(th11));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final StaticIndex normalizeLocalUsIndex(String cityId, StaticIndex index) {
        Map<String, SubwayRouteInfo> routeInfo = index.getRouteInfo();
        LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(routeInfo.size()));
        Iterator<T> it = routeInfo.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Object key = entry.getKey();
            SubwayRouteInfo subwayRouteInfo = (SubwayRouteInfo) entry.getValue();
            linkedHashMap.put(key, SubwayRouteInfo.copy$default(subwayRouteInfo, null, null, null, INSTANCE.canonicalLineColor(cityId, subwayRouteInfo.getShortName(), subwayRouteInfo.getRouteId(), subwayRouteInfo.getColor()), 7, null));
        }
        Map<String, SubwayStationOption> stationsByKey = index.getStationsByKey();
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(MapsKt.mapCapacity(stationsByKey.size()));
        Iterator<T> it2 = stationsByKey.entrySet().iterator();
        while (it2.hasNext()) {
            Map.Entry entry2 = (Map.Entry) it2.next();
            Object key2 = entry2.getKey();
            SubwayStationOption subwayStationOption = (SubwayStationOption) entry2.getValue();
            List<SubwayRouteInfo> routes = subwayStationOption.getRoutes();
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(routes, 10));
            for (SubwayRouteInfo subwayRouteInfo2 : routes) {
                SubwayRouteInfo subwayRouteInfo3 = (SubwayRouteInfo) linkedHashMap.get(subwayRouteInfo2.getRouteId());
                if (subwayRouteInfo3 != null) {
                    subwayRouteInfo2 = subwayRouteInfo3;
                }
                arrayList.add(subwayRouteInfo2);
            }
            linkedHashMap2.put(key2, SubwayStationOption.copy$default(subwayStationOption, null, null, AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, arrayList, null, 47, null));
        }
        return sanitizeWuhanRouteTopology(cityId, StaticIndex.copy$default(index, linkedHashMap2, null, null, linkedHashMap, 6, null));
    }

    private final Integer nycSubwayRouteColor(String shortName) {
        String strNormalizeSearch = normalizeSearch(shortName);
        int iHashCode = strNormalizeSearch.hashCode();
        if (iHashCode != 106) {
            if (iHashCode != 119) {
                if (iHashCode != 122) {
                    switch (iHashCode) {
                        case 49:
                            if (!strNormalizeSearch.equals("1")) {
                                return null;
                            }
                            return -1166034;
                        case 50:
                            if (!strNormalizeSearch.equals(ExifInterface.GPS_MEASUREMENT_2D)) {
                                return null;
                            }
                            return -1166034;
                        case StylePropertiesKt.BackgroundBrushId /* 51 */:
                            if (!strNormalizeSearch.equals(ExifInterface.GPS_MEASUREMENT_3D)) {
                                return null;
                            }
                            return -1166034;
                        case StylePropertiesKt.ForegroundBrushId /* 52 */:
                            if (!strNormalizeSearch.equals("4")) {
                                return null;
                            }
                            return -16739524;
                        case StylePropertiesKt.ShapeId /* 53 */:
                            if (!strNormalizeSearch.equals("5")) {
                                return null;
                            }
                            return -16739524;
                        case StylePropertiesKt.ColorFilterId /* 54 */:
                            if (!strNormalizeSearch.equals("6")) {
                                return null;
                            }
                            return -16739524;
                        case StylePropertiesKt.DropShadowId /* 55 */:
                            return !strNormalizeSearch.equals("7") ? null : -4639827;
                        default:
                            switch (iHashCode) {
                                case 97:
                                    if (!strNormalizeSearch.equals("a")) {
                                        return null;
                                    }
                                    return -16762458;
                                case 98:
                                    if (!strNormalizeSearch.equals("b")) {
                                        return null;
                                    }
                                    return -40167;
                                case 99:
                                    if (!strNormalizeSearch.equals("c")) {
                                        return null;
                                    }
                                    return -16762458;
                                case 100:
                                    if (!strNormalizeSearch.equals("d")) {
                                        return null;
                                    }
                                    return -40167;
                                case MlKitException.NOT_ENOUGH_SPACE /* 101 */:
                                    if (!strNormalizeSearch.equals("e")) {
                                        return null;
                                    }
                                    return -16762458;
                                case 102:
                                    if (!strNormalizeSearch.equals("f")) {
                                        return null;
                                    }
                                    return -40167;
                                case 103:
                                    return !strNormalizeSearch.equals("g") ? null : -9650619;
                                default:
                                    switch (iHashCode) {
                                        case AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR /* 108 */:
                                            return !strNormalizeSearch.equals("l") ? null : -5789268;
                                        case AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY /* 109 */:
                                            if (!strNormalizeSearch.equals("m")) {
                                                return null;
                                            }
                                            return -40167;
                                        case 110:
                                            if (!strNormalizeSearch.equals("n")) {
                                                return null;
                                            }
                                            break;
                                        default:
                                            switch (iHashCode) {
                                                case 113:
                                                    if (!strNormalizeSearch.equals("q")) {
                                                        return null;
                                                    }
                                                    break;
                                                case 114:
                                                    if (!strNormalizeSearch.equals("r")) {
                                                        return null;
                                                    }
                                                    break;
                                                case 115:
                                                    return !strNormalizeSearch.equals("s") ? null : -8355453;
                                                default:
                                                    return null;
                                            }
                                            break;
                                    }
                                    break;
                            }
                            break;
                    }
                } else if (!strNormalizeSearch.equals("z")) {
                    return null;
                }
            } else if (!strNormalizeSearch.equals("w")) {
                return null;
            }
            return -209910;
        }
        if (!strNormalizeSearch.equals("j")) {
            return null;
        }
        return -6724045;
    }

    private final void downloadBinary(String urlString, File target) throws IOException {
        URLConnection uRLConnectionOpenConnection = new URL(urlString).openConnection();
        Intrinsics.checkNotNull(uRLConnectionOpenConnection, "null cannot be cast to non-null type java.net.HttpURLConnection");
        HttpURLConnection httpURLConnection = (HttpURLConnection) uRLConnectionOpenConnection;
        httpURLConnection.setRequestMethod("GET");
        httpURLConnection.setConnectTimeout(30000);
        httpURLConnection.setReadTimeout(120000);
        httpURLConnection.setInstanceFollowRedirects(true);
        httpURLConnection.setRequestProperty("User-Agent", "Tickets/6.0 SubwayData");
        try {
            int responseCode = httpURLConnection.getResponseCode();
            if (200 > responseCode || responseCode >= 300) {
                throw new IllegalStateException("HTTP " + httpURLConnection.getResponseCode() + ": " + urlString);
            }
            InputStream inputStream = httpURLConnection.getInputStream();
            try {
                InputStream inputStream2 = inputStream;
                FileOutputStream fileOutputStream = new FileOutputStream(target);
                try {
                    FileOutputStream fileOutputStream2 = fileOutputStream;
                    byte[] bArr = new byte[65536];
                    while (true) {
                        int i = inputStream2.read(bArr);
                        if (i > 0) {
                            fileOutputStream2.write(bArr, 0, i);
                        } else {
                            fileOutputStream2.getFD().sync();
                            Unit unit = Unit.INSTANCE;
                            CloseableKt.closeFinally(fileOutputStream, null);
                            Unit unit2 = Unit.INSTANCE;
                            CloseableKt.closeFinally(inputStream, null);
                            httpURLConnection.disconnect();
                            return;
                        }
                        try {
                            throw th;
                        } catch (Throwable th) {
                            CloseableKt.closeFinally(inputStream, th);
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    try {
                        throw th2;
                    } catch (Throwable th3) {
                        CloseableKt.closeFinally(fileOutputStream, th2);
                        throw th3;
                    }
                }
            } catch (Throwable th4) {
                throw th4;
            }
        } catch (Throwable th5) {
            httpURLConnection.disconnect();
            throw th5;
        }
    }

    /* JADX INFO: compiled from: GlobalSubwayData.kt */
    @Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0004*\u0001\u0000\b\u008a\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\u0003¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\nHÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003JT\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u0003HÆ\u0001¢\u0006\u0002\u0010 J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020\nHÖ\u0001J\t\u0010%\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000fR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000f¨\u0006&"}, d2 = {"com/example/tickets/GlobalSubwayDataManager$parseGtfsStaticZip$GtfsStop", "", "id", "", HintConstants.AUTOFILL_HINT_NAME, "lat", "", "lon", "parentId", "locationType", "", "platformCode", "<init>", "(Ljava/lang/String;Ljava/lang/String;DDLjava/lang/String;ILjava/lang/String;)V", "getId", "()Ljava/lang/String;", "getName", "getLat", "()D", "getLon", "getParentId", "getLocationType", "()I", "getPlatformCode", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/String;Ljava/lang/String;DDLjava/lang/String;ILjava/lang/String;)Lcom/example/tickets/GlobalSubwayDataManager$parseGtfsStaticZip$GtfsStop;", "equals", "", "other", "hashCode", "toString", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class GtfsStop {
        private final String id;
        private final double lat;
        private final int locationType;
        private final double lon;
        private final String name;
        private final String parentId;
        private final String platformCode;

        public static /* synthetic */ GtfsStop copy$default(GtfsStop gtfsStop, String str, String str2, double d, double d2, String str3, int i, String str4, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = gtfsStop.id;
            }
            if ((i2 & 2) != 0) {
                str2 = gtfsStop.name;
            }
            if ((i2 & 4) != 0) {
                d = gtfsStop.lat;
            }
            if ((i2 & 8) != 0) {
                d2 = gtfsStop.lon;
            }
            if ((i2 & 16) != 0) {
                str3 = gtfsStop.parentId;
            }
            if ((i2 & 32) != 0) {
                i = gtfsStop.locationType;
            }
            if ((i2 & 64) != 0) {
                str4 = gtfsStop.platformCode;
            }
            String str5 = str4;
            String str6 = str3;
            double d3 = d2;
            double d4 = d;
            return gtfsStop.copy(str, str2, d4, d3, str6, i, str5);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getId() {
            return this.id;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getName() {
            return this.name;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final double getLat() {
            return this.lat;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final double getLon() {
            return this.lon;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final String getParentId() {
            return this.parentId;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final int getLocationType() {
            return this.locationType;
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        public final String getPlatformCode() {
            return this.platformCode;
        }

        public final GtfsStop copy(String id, String name, double lat, double lon, String parentId, int locationType, String platformCode) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(parentId, "parentId");
            Intrinsics.checkNotNullParameter(platformCode, "platformCode");
            return new GtfsStop(id, name, lat, lon, parentId, locationType, platformCode);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof GtfsStop)) {
                return false;
            }
            GtfsStop gtfsStop = (GtfsStop) other;
            return Intrinsics.areEqual(this.id, gtfsStop.id) && Intrinsics.areEqual(this.name, gtfsStop.name) && Double.compare(this.lat, gtfsStop.lat) == 0 && Double.compare(this.lon, gtfsStop.lon) == 0 && Intrinsics.areEqual(this.parentId, gtfsStop.parentId) && this.locationType == gtfsStop.locationType && Intrinsics.areEqual(this.platformCode, gtfsStop.platformCode);
        }

        public int hashCode() {
            return (((((((((((this.id.hashCode() * 31) + this.name.hashCode()) * 31) + Double.hashCode(this.lat)) * 31) + Double.hashCode(this.lon)) * 31) + this.parentId.hashCode()) * 31) + Integer.hashCode(this.locationType)) * 31) + this.platformCode.hashCode();
        }

        public String toString() {
            return "GtfsStop(id=" + this.id + ", name=" + this.name + ", lat=" + this.lat + ", lon=" + this.lon + ", parentId=" + this.parentId + ", locationType=" + this.locationType + ", platformCode=" + this.platformCode + ")";
        }

        public GtfsStop(String id, String name, double d, double d2, String parentId, int i, String platformCode) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(parentId, "parentId");
            Intrinsics.checkNotNullParameter(platformCode, "platformCode");
            this.id = id;
            this.name = name;
            this.lat = d;
            this.lon = d2;
            this.parentId = parentId;
            this.locationType = i;
            this.platformCode = platformCode;
        }

        public final String getId() {
            return this.id;
        }

        public final String getName() {
            return this.name;
        }

        public final double getLat() {
            return this.lat;
        }

        public final double getLon() {
            return this.lon;
        }

        public final String getParentId() {
            return this.parentId;
        }

        public final int getLocationType() {
            return this.locationType;
        }

        public final String getPlatformCode() {
            return this.platformCode;
        }
    }

    /* JADX INFO: compiled from: GlobalSubwayData.kt */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0004*\u0001\u0000\b\u008a\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J@\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0007HÆ\u0001¢\u0006\u0002\u0010\u0018J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u0007HÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010¨\u0006\u001e"}, d2 = {"com/example/tickets/GlobalSubwayDataManager$parseGtfsStaticZip$GtfsRoute", "", "id", "", "shortName", "longName", "color", "", ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;II)V", "getId", "()Ljava/lang/String;", "getShortName", "getLongName", "getColor", "()I", "getType", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;II)Lcom/example/tickets/GlobalSubwayDataManager$parseGtfsStaticZip$GtfsRoute;", "equals", "", "other", "hashCode", "toString", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class GtfsRoute {
        private final int color;
        private final String id;
        private final String longName;
        private final String shortName;
        private final int type;

        public static /* synthetic */ GtfsRoute copy$default(GtfsRoute gtfsRoute, String str, String str2, String str3, int i, int i2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = gtfsRoute.id;
            }
            if ((i3 & 2) != 0) {
                str2 = gtfsRoute.shortName;
            }
            if ((i3 & 4) != 0) {
                str3 = gtfsRoute.longName;
            }
            if ((i3 & 8) != 0) {
                i = gtfsRoute.color;
            }
            if ((i3 & 16) != 0) {
                i2 = gtfsRoute.type;
            }
            int i4 = i2;
            String str4 = str3;
            return gtfsRoute.copy(str, str2, str4, i, i4);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getId() {
            return this.id;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getShortName() {
            return this.shortName;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getLongName() {
            return this.longName;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final int getColor() {
            return this.color;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final int getType() {
            return this.type;
        }

        public final GtfsRoute copy(String id, String shortName, String longName, int color, int type) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(shortName, "shortName");
            Intrinsics.checkNotNullParameter(longName, "longName");
            return new GtfsRoute(id, shortName, longName, color, type);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof GtfsRoute)) {
                return false;
            }
            GtfsRoute gtfsRoute = (GtfsRoute) other;
            return Intrinsics.areEqual(this.id, gtfsRoute.id) && Intrinsics.areEqual(this.shortName, gtfsRoute.shortName) && Intrinsics.areEqual(this.longName, gtfsRoute.longName) && this.color == gtfsRoute.color && this.type == gtfsRoute.type;
        }

        public int hashCode() {
            return (((((((this.id.hashCode() * 31) + this.shortName.hashCode()) * 31) + this.longName.hashCode()) * 31) + Integer.hashCode(this.color)) * 31) + Integer.hashCode(this.type);
        }

        public String toString() {
            return "GtfsRoute(id=" + this.id + ", shortName=" + this.shortName + ", longName=" + this.longName + ", color=" + this.color + ", type=" + this.type + ")";
        }

        public GtfsRoute(String id, String shortName, String longName, int i, int i2) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(shortName, "shortName");
            Intrinsics.checkNotNullParameter(longName, "longName");
            this.id = id;
            this.shortName = shortName;
            this.longName = longName;
            this.color = i;
            this.type = i2;
        }

        public final String getId() {
            return this.id;
        }

        public final String getShortName() {
            return this.shortName;
        }

        public final String getLongName() {
            return this.longName;
        }

        public final int getColor() {
            return this.color;
        }

        public final int getType() {
            return this.type;
        }
    }

    /* JADX WARN: Code duplicated, block: B:101:0x0218  */
    /* JADX WARN: Code duplicated, block: B:207:0x048a A[Catch: all -> 0x06bb, TryCatch #0 {all -> 0x06bb, blocks: (B:3:0x0021, B:4:0x0030, B:7:0x003a, B:9:0x004a, B:11:0x0050, B:13:0x0060, B:15:0x006a, B:18:0x0073, B:20:0x007c, B:23:0x0089, B:26:0x0092, B:29:0x00a3, B:32:0x00b7, B:36:0x00d7, B:38:0x00dd, B:40:0x00e5, B:42:0x00f4, B:48:0x011d, B:43:0x00fa, B:47:0x0109, B:49:0x0128, B:50:0x0134, B:53:0x013c, B:57:0x014d, B:60:0x015a, B:63:0x0165, B:66:0x0170, B:68:0x0181, B:71:0x018c, B:73:0x0198, B:75:0x019e, B:77:0x01a5, B:79:0x01af, B:81:0x01b5, B:82:0x01b9, B:84:0x01c3, B:86:0x01c9, B:88:0x01cf, B:90:0x01de, B:92:0x01e6, B:96:0x01fc, B:100:0x020b, B:103:0x021e, B:104:0x022a, B:107:0x0232, B:110:0x0241, B:113:0x024a, B:117:0x0254, B:119:0x025d, B:121:0x0263, B:122:0x026a, B:123:0x027b, B:125:0x0281, B:128:0x0290, B:131:0x0299, B:134:0x02a2, B:136:0x02a8, B:138:0x02b2, B:140:0x02b8, B:142:0x02c4, B:143:0x02ce, B:144:0x02d8, B:145:0x02ed, B:147:0x02f3, B:148:0x0306, B:149:0x031a, B:151:0x0320, B:152:0x034a, B:153:0x0367, B:155:0x036d, B:158:0x0388, B:161:0x0391, B:162:0x03ab, B:164:0x03b1, B:166:0x03d5, B:168:0x03e0, B:170:0x03eb, B:171:0x03fb, B:173:0x0401, B:174:0x040f, B:176:0x0415, B:181:0x0439, B:183:0x043d, B:186:0x0447, B:189:0x0451, B:194:0x0465, B:200:0x0476, B:202:0x047c, B:205:0x0486, B:208:0x048e, B:210:0x049e, B:213:0x04a7, B:214:0x04ab, B:216:0x04c2, B:218:0x04c8, B:219:0x04d3, B:224:0x04e4, B:226:0x050c, B:228:0x0511, B:238:0x059b, B:240:0x05a7, B:241:0x05b1, B:230:0x0533, B:231:0x054d, B:233:0x0553, B:235:0x0569, B:237:0x0571, B:207:0x048a, B:244:0x05c9, B:246:0x05f2, B:247:0x05fc, B:249:0x0604, B:251:0x060e, B:252:0x0618, B:255:0x0631, B:256:0x0650, B:258:0x0656, B:259:0x0671, B:260:0x068e, B:262:0x0694, B:263:0x06af), top: B:272:0x0021 }] */
    private final StaticIndex parseGtfsStaticZip(SubwayCity city, File zipFile) throws IOException {
        Iterator it;
        Object next;
        SubwayRouteInfo subwayRouteInfo;
        GtfsStop gtfsStop;
        String name;
        SubwayStationOption subwayStationOptionCopy$default;
        String name2;
        String name3;
        String str;
        Integer intOrNull;
        Integer intOrNull2;
        Double doubleOrNull;
        Double doubleOrNull2;
        Integer intOrNull3;
        GtfsRoute gtfsRouteCopy$default;
        SubwayCity subwayCity = city;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        ZipFile zipFile2 = new ZipFile(zipFile);
        try {
            ZipFile zipFile3 = zipFile2;
            Iterator<Map<String, String>> it2 = INSTANCE.readGtfsRows(zipFile3, "routes.txt").iterator();
            while (true) {
                String str2 = "";
                if (!it2.hasNext()) {
                    break;
                }
                Map<String, String> next2 = it2.next();
                String str3 = next2.get("route_type");
                if (str3 != null && (intOrNull3 = StringsKt.toIntOrNull(str3)) != null) {
                    int iIntValue = intOrNull3.intValue();
                    if (subwayCity.getGtfsRouteTypes().isEmpty() || subwayCity.getGtfsRouteTypes().contains(intOrNull3)) {
                        String str4 = next2.get("route_id");
                        if (str4 == null) {
                            str4 = "";
                        }
                        if (!StringsKt.isBlank(str4)) {
                            GlobalSubwayDataManager globalSubwayDataManager = INSTANCE;
                            String str5 = next2.get("route_short_name");
                            if (str5 == null) {
                                str5 = "";
                            }
                            String str6 = next2.get("route_long_name");
                            if (str6 == null) {
                                str6 = "";
                            }
                            String strFirstNonBlank = globalSubwayDataManager.firstNonBlank(str5, str6, str4);
                            String str7 = next2.get("route_long_name");
                            if (str7 == null) {
                                str7 = "";
                            }
                            Triple<String, String, String> tripleCanonicalUsRouteIdentity = globalSubwayDataManager.canonicalUsRouteIdentity(subwayCity.getId(), str4, strFirstNonBlank, globalSubwayDataManager.firstNonBlank(str7, strFirstNonBlank));
                            if (tripleCanonicalUsRouteIdentity != null) {
                                String first = tripleCanonicalUsRouteIdentity.getFirst();
                                String second = tripleCanonicalUsRouteIdentity.getSecond();
                                String third = tripleCanonicalUsRouteIdentity.getThird();
                                String str8 = next2.get("route_color");
                                if (str8 != null) {
                                    str2 = str8;
                                }
                                Integer gtfsRouteColor = globalSubwayDataManager.parseGtfsRouteColor(str2);
                                int iIntValue2 = gtfsRouteColor != null ? gtfsRouteColor.intValue() : FALLBACK_ROUTE_COLOR;
                                GtfsRoute gtfsRoute = (GtfsRoute) linkedHashMap2.get(first);
                                LinkedHashMap linkedHashMap3 = linkedHashMap2;
                                if (gtfsRoute == null) {
                                    gtfsRouteCopy$default = new GtfsRoute(first, second, third, iIntValue2, iIntValue);
                                } else {
                                    String longName = gtfsRoute.getLongName();
                                    if (!StringsKt.isBlank(longName)) {
                                        third = longName;
                                    }
                                    gtfsRouteCopy$default = GtfsRoute.copy$default(gtfsRoute, null, null, third, 0, 0, 27, null);
                                }
                                linkedHashMap3.put(first, gtfsRouteCopy$default);
                                map.put(str4, first);
                            }
                        }
                    }
                }
            }
            for (Iterator<Map<String, String>> it3 = INSTANCE.readGtfsRows(zipFile3, "stops.txt").iterator(); it3.hasNext(); it3 = it3) {
                Map<String, String> next3 = it3.next();
                String str9 = next3.get("stop_id");
                String str10 = str9 == null ? "" : str9;
                GlobalSubwayDataManager globalSubwayDataManager2 = INSTANCE;
                String str11 = next3.get("stop_name");
                if (str11 == null) {
                    str11 = "";
                }
                String str12 = next3.get("tts_stop_name");
                if (str12 == null) {
                    str12 = "";
                }
                String str13 = next3.get("stop_code");
                if (str13 == null) {
                    str13 = "";
                }
                String strFirstNonBlank2 = globalSubwayDataManager2.firstNonBlank(str11, str12, str13);
                if (!StringsKt.isBlank(str10) && !StringsKt.isBlank(strFirstNonBlank2)) {
                    String str14 = next3.get("stop_lat");
                    double dDoubleValue = Double.NaN;
                    double dDoubleValue2 = (str14 == null || (doubleOrNull2 = StringsKt.toDoubleOrNull(str14)) == null) ? Double.NaN : doubleOrNull2.doubleValue();
                    String str15 = next3.get("stop_lon");
                    if (str15 != null && (doubleOrNull = StringsKt.toDoubleOrNull(str15)) != null) {
                        dDoubleValue = doubleOrNull.doubleValue();
                    }
                    String str16 = next3.get("location_type");
                    int iIntValue3 = (str16 == null || (intOrNull2 = StringsKt.toIntOrNull(str16)) == null) ? 0 : intOrNull2.intValue();
                    if (Math.abs(dDoubleValue2) <= Double.MAX_VALUE && Math.abs(dDoubleValue) <= Double.MAX_VALUE) {
                        LinkedHashMap linkedHashMap4 = linkedHashMap;
                        String str17 = next3.get("parent_station");
                        String str18 = str17 == null ? "" : str17;
                        String str19 = next3.get("platform_code");
                        linkedHashMap4.put(str10, new GtfsStop(str10, strFirstNonBlank2, dDoubleValue2, dDoubleValue, str18, iIntValue3, str19 == null ? "" : str19));
                    }
                }
            }
            for (Map<String, String> map3 : INSTANCE.readGtfsRows(zipFile3, "trips.txt")) {
                String str20 = map3.get("trip_id");
                if (str20 == null) {
                    str20 = "";
                }
                String str21 = map3.get("route_id");
                if (str21 == null) {
                    str21 = "";
                }
                String str22 = (String) map.get(str21);
                if (str22 != null) {
                    str21 = str22;
                }
                if (!StringsKt.isBlank(str20) && linkedHashMap2.containsKey(str21)) {
                    map2.put(str20, str21);
                }
            }
            HashMap map4 = new HashMap();
            for (Map<String, String> map5 : INSTANCE.readGtfsRows(zipFile3, "stop_times.txt")) {
                String str23 = map5.get("trip_id");
                if (str23 == null) {
                    str23 = "";
                }
                if (((String) map2.get(str23)) != null) {
                    String str24 = map5.get("stop_id");
                    if (str24 == null) {
                        str24 = "";
                    }
                    if (linkedHashMap.containsKey(str24) && (str = map5.get("stop_sequence")) != null && (intOrNull = StringsKt.toIntOrNull(str)) != null) {
                        intOrNull.intValue();
                        HashMap map6 = map4;
                        Object obj = map6.get(str23);
                        if (obj == null) {
                            obj = (List) new ArrayList();
                            map6.put(str23, obj);
                        }
                        ((List) obj).add(TuplesKt.to(intOrNull, str24));
                    }
                }
            }
            HashMap map7 = new HashMap();
            LinkedHashMap linkedHashMap5 = new LinkedHashMap();
            for (Map.Entry entry : linkedHashMap2.entrySet()) {
            }
            HashMap map8 = new HashMap();
            Collection<GtfsRoute> collectionValues = linkedHashMap2.values();
            Intrinsics.checkNotNullExpressionValue(collectionValues, "<get-values>(...)");
            for (GtfsRoute gtfsRoute2 : collectionValues) {
                map8.put(gtfsRoute2.getId(), new SubwayRouteInfo(gtfsRoute2.getId(), gtfsRoute2.getShortName(), gtfsRoute2.getLongName(), gtfsRoute2.getColor()));
                map4 = map4;
            }
            HashMap map9 = map4;
            HashMap map10 = new HashMap();
            HashMap map11 = new HashMap();
            HashMap map12 = new HashMap();
            for (Map.Entry entry2 : map9.entrySet()) {
                String str25 = (String) entry2.getKey();
                List list = (List) entry2.getValue();
                String str26 = (String) map2.get(str25);
                if (str26 != null && ((GtfsRoute) linkedHashMap2.get(str26)) != null) {
                    List listSortedWith = CollectionsKt.sortedWith(list, new Comparator() { // from class: com.example.tickets.GlobalSubwayDataManager$parseGtfsStaticZip$lambda$106$$inlined$sortedBy$1
                        /* JADX WARN: Multi-variable type inference failed */
                        @Override // java.util.Comparator
                        public final int compare(T t, T t2) {
                            return ComparisonsKt.compareValues((Integer) ((Pair) t).getFirst(), (Integer) ((Pair) t2).getFirst());
                        }
                    });
                    ArrayList arrayList = new ArrayList(listSortedWith.size());
                    Iterator it4 = listSortedWith.iterator();
                    while (it4.hasNext()) {
                        HashMap map13 = map10;
                        String gtfsStaticZip$lambda$106$stationKeyFor = parseGtfsStaticZip$lambda$106$stationKeyFor(map7, linkedHashMap, subwayCity, (String) ((Pair) it4.next()).component2());
                        LinkedHashMap linkedHashMap6 = linkedHashMap2;
                        if (!Intrinsics.areEqual(CollectionsKt.lastOrNull((List) arrayList), gtfsStaticZip$lambda$106$stationKeyFor)) {
                            arrayList.add(gtfsStaticZip$lambda$106$stationKeyFor);
                        }
                        map10 = map13;
                        linkedHashMap2 = linkedHashMap6;
                    }
                    HashMap map14 = map10;
                    LinkedHashMap linkedHashMap7 = linkedHashMap2;
                    if (arrayList.size() >= 2) {
                        SubwayRouteInfo subwayRouteInfo2 = (SubwayRouteInfo) MapsKt.getValue(map8, str26);
                        Iterator it5 = arrayList.iterator();
                        while (it5.hasNext()) {
                            String str27 = (String) it5.next();
                            Iterator it6 = listSortedWith.iterator();
                            while (true) {
                                if (!it6.hasNext()) {
                                    it = it5;
                                    next = null;
                                    break;
                                }
                                next = it6.next();
                                it = it5;
                                if (Intrinsics.areEqual(parseGtfsStaticZip$lambda$106$stationKeyFor(map7, linkedHashMap, subwayCity, (String) ((Pair) next).getSecond()), str27)) {
                                    break;
                                }
                                it5 = it;
                            }
                            Pair pair = (Pair) next;
                            String str28 = pair != null ? (String) pair.getSecond() : null;
                            if (str28 == null || (gtfsStop = (GtfsStop) linkedHashMap.get(str28)) == null) {
                                subwayRouteInfo = subwayRouteInfo2;
                                map7 = map7;
                            } else {
                                String parentId = gtfsStop.getParentId();
                                String str29 = !StringsKt.isBlank(parentId) ? parentId : null;
                                GtfsStop gtfsStop2 = str29 != null ? (GtfsStop) linkedHashMap.get(str29) : null;
                                GtfsStop gtfsStop3 = gtfsStop2 == null ? gtfsStop : gtfsStop2;
                                if (gtfsStop2 == null || (name3 = gtfsStop2.getName()) == null) {
                                    name = gtfsStop.getName();
                                } else {
                                    String str30 = name3;
                                    if (StringsKt.isBlank(str30)) {
                                        str30 = null;
                                    }
                                    name = str30;
                                    if (name == null) {
                                        name = gtfsStop.getName();
                                    }
                                }
                                String str31 = name;
                                SubwayStationOption subwayStationOption = (SubwayStationOption) linkedHashMap5.get(str27);
                                GtfsStop gtfsStop4 = gtfsStop2;
                                List<String> searchNames = subwayStationOption != null ? subwayStationOption.getSearchNames() : null;
                                if (searchNames == null) {
                                    searchNames = CollectionsKt.emptyList();
                                }
                                LinkedHashSet linkedHashSet = new LinkedHashSet(searchNames);
                                linkedHashSet.add(gtfsStop.getName());
                                if (gtfsStop4 != null && (name2 = gtfsStop4.getName()) != null) {
                                    linkedHashSet.add(name2);
                                    Unit unit = Unit.INSTANCE;
                                    Unit unit2 = Unit.INSTANCE;
                                }
                                String platformCode = gtfsStop.getPlatformCode();
                                if (StringsKt.isBlank(platformCode)) {
                                    platformCode = null;
                                }
                                if (platformCode != null) {
                                    linkedHashSet.add(gtfsStop.getName() + " " + platformCode);
                                    Unit unit3 = Unit.INSTANCE;
                                    Unit unit4 = Unit.INSTANCE;
                                }
                                LinkedHashMap linkedHashMap8 = linkedHashMap5;
                                if (subwayStationOption == null) {
                                    subwayStationOptionCopy$default = new SubwayStationOption(str27, str31, gtfsStop3.getLat(), gtfsStop3.getLon(), CollectionsKt.listOf(subwayRouteInfo2), CollectionsKt.toList(linkedHashSet));
                                    str27 = str27;
                                    subwayRouteInfo = subwayRouteInfo2;
                                } else {
                                    List listPlus = CollectionsKt.plus((Collection<? extends SubwayRouteInfo>) subwayStationOption.getRoutes(), subwayRouteInfo2);
                                    HashSet hashSet = new HashSet();
                                    ArrayList arrayList2 = new ArrayList();
                                    Iterator it7 = listPlus.iterator();
                                    while (it7.hasNext()) {
                                        SubwayRouteInfo subwayRouteInfo3 = subwayRouteInfo2;
                                        Object next4 = it7.next();
                                        Iterator it8 = it7;
                                        if (hashSet.add(((SubwayRouteInfo) next4).getRouteId())) {
                                            arrayList2.add(next4);
                                        }
                                        subwayRouteInfo2 = subwayRouteInfo3;
                                        it7 = it8;
                                    }
                                    subwayRouteInfo = subwayRouteInfo2;
                                    subwayStationOptionCopy$default = SubwayStationOption.copy$default(subwayStationOption, null, null, AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, CollectionsKt.sortedWith(arrayList2, new Comparator() { // from class: com.example.tickets.GlobalSubwayDataManager$parseGtfsStaticZip$lambda$106$$inlined$sortedBy$2
                                        /* JADX WARN: Multi-variable type inference failed */
                                        @Override // java.util.Comparator
                                        public final int compare(T t, T t2) {
                                            return ComparisonsKt.compareValues(((GlobalSubwayDataManager.SubwayRouteInfo) t).getShortName(), ((GlobalSubwayDataManager.SubwayRouteInfo) t2).getShortName());
                                        }
                                    }), CollectionsKt.toList(linkedHashSet), 15, null);
                                }
                                linkedHashMap8.put(str27, subwayStationOptionCopy$default);
                                HashMap map15 = map12;
                                Object obj2 = map15.get(str27);
                                if (obj2 == null) {
                                    obj2 = (Set) new LinkedHashSet();
                                    map15.put(str27, obj2);
                                }
                                ((Set) obj2).add(str26);
                            }
                            subwayCity = city;
                            subwayRouteInfo2 = subwayRouteInfo;
                            it5 = it;
                            linkedHashMap = linkedHashMap;
                            map7 = map7;
                        }
                        LinkedHashMap linkedHashMap9 = linkedHashMap;
                        HashMap map16 = map7;
                        String strJoinToString$default = CollectionsKt.joinToString$default(arrayList, "|", null, null, 0, null, null, 62, null);
                        HashMap map17 = map11;
                        Object obj3 = map17.get(str26);
                        if (obj3 == null) {
                            obj3 = (Set) new LinkedHashSet();
                            map17.put(str26, obj3);
                        }
                        if (((Set) obj3).add(strJoinToString$default)) {
                            HashMap map18 = map14;
                            Object obj4 = map18.get(str26);
                            if (obj4 == null) {
                                obj4 = (List) new ArrayList();
                                map18.put(str26, obj4);
                            }
                            ((List) obj4).add(arrayList);
                        }
                        subwayCity = city;
                        map10 = map14;
                        linkedHashMap2 = linkedHashMap7;
                        linkedHashMap = linkedHashMap9;
                        map7 = map16;
                    } else {
                        subwayCity = city;
                        map10 = map14;
                        linkedHashMap2 = linkedHashMap7;
                    }
                }
            }
            HashMap map19 = map10;
            LinkedHashMap linkedHashMap10 = linkedHashMap5;
            HashMap map20 = map12;
            LinkedHashMap linkedHashMap11 = new LinkedHashMap(MapsKt.mapCapacity(map20.size()));
            for (Object obj5 : map20.entrySet()) {
                linkedHashMap11.put(((Map.Entry) obj5).getKey(), CollectionsKt.toSet((Iterable) ((Map.Entry) obj5).getValue()));
            }
            HashMap map21 = map19;
            LinkedHashMap linkedHashMap12 = new LinkedHashMap(MapsKt.mapCapacity(map21.size()));
            for (Object obj6 : map21.entrySet()) {
                linkedHashMap12.put(((Map.Entry) obj6).getKey(), CollectionsKt.toList((Iterable) ((Map.Entry) obj6).getValue()));
            }
            StaticIndex staticIndex = new StaticIndex(linkedHashMap10, linkedHashMap11, linkedHashMap12, map8);
            CloseableKt.closeFinally(zipFile2, null);
            return staticIndex;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                CloseableKt.closeFinally(zipFile2, th);
                throw th2;
            }
        }
    }

    private static final String parseGtfsStaticZip$lambda$106$stationKeyFor(HashMap<String, String> map, LinkedHashMap<String, GtfsStop> linkedHashMap, SubwayCity subwayCity, String str) {
        String str2 = map.get(str);
        if (str2 != null) {
            return str2;
        }
        GtfsStop gtfsStop = (GtfsStop) MapsKt.getValue(linkedHashMap, str);
        String parentId = gtfsStop.getParentId();
        if (StringsKt.isBlank(parentId) || !linkedHashMap.containsKey(parentId)) {
            parentId = null;
        }
        String id = subwayCity.getId();
        if (parentId == null) {
            parentId = gtfsStop.getId();
        }
        String str3 = id + ":gtfs:" + parentId;
        map.put(str, str3);
        return str3;
    }

    private static final String parseGtfsStaticZip$lambda$106$stationNameFor(LinkedHashMap<String, GtfsStop> linkedHashMap, String str, String str2) {
        String name;
        GtfsStop gtfsStop = linkedHashMap.get(str2);
        String parentId = gtfsStop != null ? gtfsStop.getParentId() : null;
        if (parentId == null) {
            parentId = "";
        }
        GtfsStop gtfsStop2 = linkedHashMap.get(parentId);
        if (gtfsStop2 != null && (name = gtfsStop2.getName()) != null) {
            if (StringsKt.isBlank(name)) {
                name = null;
            }
            if (name != null) {
                return name;
            }
        }
        GtfsStop gtfsStop3 = linkedHashMap.get(str2);
        return gtfsStop3 != null ? gtfsStop3.getName() : StringsKt.substringAfterLast$default(str, ':', (String) null, 2, (Object) null);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:38:0x00c6  */
    /* JADX WARN: Code duplicated, block: B:45:0x00dc  */
    /* JADX WARN: Code duplicated, block: B:52:0x00f1  */
    /* JADX WARN: Code duplicated, block: B:59:0x0106  */
    /* JADX WARN: Code duplicated, block: B:63:0x0112  */
    /* JADX WARN: Code duplicated, block: B:70:0x0125  */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private final Triple<String, String, String> canonicalUsRouteIdentity(String cityId, String rawRouteId, String rawShortName, String rawLongName) {
        String str;
        String str2;
        String strReplace$default = StringsKt.replace$default(StringsKt.replace$default(normalizeSearch(rawShortName), "-", "", false, 4, (Object) null), "_", "", false, 4, (Object) null);
        Locale US = Locale.US;
        Intrinsics.checkNotNullExpressionValue(US, "US");
        String lowerCase = strReplace$default.toLowerCase(US);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        String str3 = "G";
        switch (cityId.hashCode()) {
            case -1383258675:
                if (cityId.equals("boston")) {
                    if (Intrinsics.areEqual(lowerCase, "red") || StringsKt.startsWith$default(lowerCase, "red", false, 2, (Object) null)) {
                        str = "Red Line";
                    } else if (Intrinsics.areEqual(lowerCase, "orange") || StringsKt.startsWith$default(lowerCase, "orange", false, 2, (Object) null)) {
                        str = "Orange Line";
                    } else if (Intrinsics.areEqual(lowerCase, "blue") || StringsKt.startsWith$default(lowerCase, "blue", false, 2, (Object) null)) {
                        str = "Blue Line";
                    } else {
                        if (!Intrinsics.areEqual(lowerCase, "green") && !StringsKt.startsWith$default(lowerCase, "green", false, 2, (Object) null)) {
                            return null;
                        }
                        str = "Green Line";
                    }
                    Locale US2 = Locale.US;
                    Intrinsics.checkNotNullExpressionValue(US2, "US");
                    String lowerCase2 = str.toLowerCase(US2);
                    Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
                    return new Triple<>("us:boston:" + new Regex("\\s+").replace(lowerCase2, "_"), str, str);
                }
                return null;
            case -1335000448:
                if (cityId.equals("los_angeles")) {
                    String strRemoveSuffix = StringsKt.removeSuffix(normalizeSearch(rawShortName), (CharSequence) "line");
                    Locale US3 = Locale.US;
                    Intrinsics.checkNotNullExpressionValue(US3, "US");
                    String upperCase = strRemoveSuffix.toUpperCase(US3);
                    Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
                    String string = StringsKt.trim((CharSequence) upperCase).toString();
                    if (Intrinsics.areEqual(string, "G") || Intrinsics.areEqual(string, "J") || !SetsKt.setOf((Object[]) new String[]{ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", "C", "D", ExifInterface.LONGITUDE_EAST, "K"}).contains(string)) {
                        return null;
                    }
                    return new Triple<>("us:los_angeles:" + string, string, rawLongName);
                }
                return null;
            case 109560:
                if (cityId.equals("nyc")) {
                    int iHashCode = lowerCase.hashCode();
                    if (iHashCode != 115) {
                        return iHashCode != 3670 ? new Triple<>("us:nyc:sir", "SIR", "Staten Island Railway") : new Triple<>("us:nyc:sir", "SIR", "Staten Island Railway");
                    }
                    if (lowerCase.equals("s")) {
                        Locale US4 = Locale.US;
                        Intrinsics.checkNotNullExpressionValue(US4, "US");
                        String lowerCase3 = rawRouteId.toLowerCase(US4);
                        Intrinsics.checkNotNullExpressionValue(lowerCase3, "toLowerCase(...)");
                        return new Triple<>("us:nyc:s:" + lowerCase3, ExifInterface.LATITUDE_SOUTH, rawLongName);
                    }
                    String lowerCase4 = lowerCase;
                    if (StringsKt.isBlank(lowerCase4)) {
                        Locale US5 = Locale.US;
                        Intrinsics.checkNotNullExpressionValue(US5, "US");
                        lowerCase4 = rawRouteId.toLowerCase(US5);
                        Intrinsics.checkNotNullExpressionValue(lowerCase4, "toLowerCase(...)");
                    }
                    return new Triple<>("us:nyc:" + ((Object) lowerCase4), rawShortName, rawLongName);
                }
                return null;
            case 745998442:
                if (cityId.equals("chicago")) {
                    String string2 = StringsKt.trim((CharSequence) rawShortName).toString();
                    String strNormalizeSearch = normalizeSearch(string2);
                    Locale US6 = Locale.US;
                    Intrinsics.checkNotNullExpressionValue(US6, "US");
                    String lowerCase5 = strNormalizeSearch.toLowerCase(US6);
                    Intrinsics.checkNotNullExpressionValue(lowerCase5, "toLowerCase(...)");
                    if (StringsKt.isBlank(lowerCase5)) {
                        return null;
                    }
                    return new Triple<>("us:chicago:" + lowerCase5, string2, rawLongName);
                }
                return null;
            case 1382037045:
                if (cityId.equals("philadelphia")) {
                    if (Intrinsics.areEqual(lowerCase, "l1") || Intrinsics.areEqual(lowerCase, "mfl") || Intrinsics.areEqual(lowerCase, "l")) {
                        str3 = "L";
                    } else if (Intrinsics.areEqual(lowerCase, "b1") || Intrinsics.areEqual(lowerCase, "b2") || Intrinsics.areEqual(lowerCase, "b3") || Intrinsics.areEqual(lowerCase, "bsl") || Intrinsics.areEqual(lowerCase, "b")) {
                        str3 = "B";
                    } else if (StringsKt.startsWith$default(lowerCase, "t", false, 2, (Object) null)) {
                        str3 = ExifInterface.GPS_DIRECTION_TRUE;
                    } else if (!Intrinsics.areEqual(lowerCase, "g1") && !Intrinsics.areEqual(lowerCase, "g")) {
                        if (StringsKt.startsWith$default(lowerCase, "d", false, 2, (Object) null)) {
                            str3 = "D";
                        } else {
                            if (!StringsKt.startsWith$default(lowerCase, "m", false, 2, (Object) null)) {
                                return null;
                            }
                            str3 = "M";
                        }
                    }
                    return new Triple<>("us:philadelphia:".concat(str3), str3, rawLongName);
                }
                return null;
            case 1579642076:
                if (!cityId.equals("san_francisco_bay") || Intrinsics.areEqual(lowerCase, "oak") || StringsKt.contains((CharSequence) rawLongName, (CharSequence) "Oakland Airport", true)) {
                    return null;
                }
                String string3 = StringsKt.trim((CharSequence) rawShortName).toString();
                String lowerCase6 = lowerCase;
                if (StringsKt.isBlank(lowerCase6)) {
                    Locale US7 = Locale.US;
                    Intrinsics.checkNotNullExpressionValue(US7, "US");
                    lowerCase6 = rawRouteId.toLowerCase(US7);
                    Intrinsics.checkNotNullExpressionValue(lowerCase6, "toLowerCase(...)");
                }
                return new Triple<>("us:san_francisco_bay:" + ((Object) lowerCase6), string3, rawLongName);
            case 1904238990:
                if (cityId.equals("washington_dc")) {
                    switch (lowerCase) {
                        case "orangeline":
                        case "orange":
                            str2 = "Orange Line";
                            break;
                        case "silver":
                            str2 = "Silver Line";
                            break;
                        case "yellow":
                        case "yellowline":
                            str2 = "Yellow Line";
                            break;
                        case "blueline":
                        case "bl":
                            str2 = "Blue Line";
                            break;
                        case "gr":
                            str2 = "Green Line";
                            break;
                        case "or":
                            str2 = "Orange Line";
                            break;
                        case "rd":
                            str2 = "Red Line";
                            break;
                        case "sv":
                            str2 = "Silver Line";
                            break;
                        case "yl":
                            str2 = "Yellow Line";
                            break;
                        case "red":
                            str2 = "Red Line";
                            break;
                        case "blue":
                            str2 = "Blue Line";
                            break;
                        case "green":
                            str2 = "Green Line";
                            break;
                        case "redline":
                            str2 = "Red Line";
                            break;
                        case "silverline":
                            str2 = "Silver Line";
                            break;
                        case "greenline":
                            str2 = "Green Line";
                            break;
                        default:
                            str2 = null;
                            break;
                    }
                    if (str2 == null) {
                        return null;
                    }
                    Locale US8 = Locale.US;
                    Intrinsics.checkNotNullExpressionValue(US8, "US");
                    String lowerCase7 = str2.toLowerCase(US8);
                    Intrinsics.checkNotNullExpressionValue(lowerCase7, "toLowerCase(...)");
                    return new Triple<>("us:washington_dc:" + new Regex("\\s+").replace(lowerCase7, "_"), str2, str2);
                }
                return null;
            default:
                return null;
        }
    }

    /* JADX INFO: renamed from: com.example.tickets.GlobalSubwayDataManager$readGtfsRows$1, reason: invalid class name */
    /* JADX INFO: compiled from: GlobalSubwayData.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u0001*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlin/sequences/SequenceScope;", "", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.tickets.GlobalSubwayDataManager$readGtfsRows$1", f = "GlobalSubwayData.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0}, l = {2402}, m = "invokeSuspend", n = {"$this$sequence", "entry", "input", "reader", "headerLine", "headers", "raw", "values", "row"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8"})
    static final class AnonymousClass1 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super Map<String, ? extends String>>, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $fileName;
        final /* synthetic */ ZipFile $zip;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(ZipFile zipFile, String str, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$zip = zipFile;
            this.$fileName = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$zip, this.$fileName, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(SequenceScope<? super Map<String, ? extends String>> sequenceScope, Continuation<? super Unit> continuation) {
            return invoke2((SequenceScope<? super Map<String, String>>) sequenceScope, continuation);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(SequenceScope<? super Map<String, String>> sequenceScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(sequenceScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:37:0x00c4 A[Catch: all -> 0x003b, TRY_ENTER, TryCatch #3 {all -> 0x003b, blocks: (B:6:0x0031, B:29:0x00a6, B:37:0x00c4, B:39:0x00cd, B:40:0x00e4, B:42:0x00ea, B:44:0x00f2, B:45:0x00f5, B:48:0x011a, B:49:0x0122, B:20:0x0078, B:22:0x007e, B:28:0x0096), top: B:66:0x000d }] */
        /* JADX WARN: Code duplicated, block: B:42:0x00ea A[Catch: all -> 0x003b, TryCatch #3 {all -> 0x003b, blocks: (B:6:0x0031, B:29:0x00a6, B:37:0x00c4, B:39:0x00cd, B:40:0x00e4, B:42:0x00ea, B:44:0x00f2, B:45:0x00f5, B:48:0x011a, B:49:0x0122, B:20:0x0078, B:22:0x007e, B:28:0x0096), top: B:66:0x000d }] */
        /* JADX WARN: Code duplicated, block: B:44:0x00f2 A[Catch: all -> 0x003b, TryCatch #3 {all -> 0x003b, blocks: (B:6:0x0031, B:29:0x00a6, B:37:0x00c4, B:39:0x00cd, B:40:0x00e4, B:42:0x00ea, B:44:0x00f2, B:45:0x00f5, B:48:0x011a, B:49:0x0122, B:20:0x0078, B:22:0x007e, B:28:0x0096), top: B:66:0x000d }] */
        /* JADX WARN: Code duplicated, block: B:47:0x0118  */
        /* JADX WARN: Code duplicated, block: B:51:0x015a A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:52:0x015b  */
        /* JADX WARN: Code duplicated, block: B:62:0x00ac A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:71:0x011a A[SYNTHETIC] */
        /* JADX WARN: Not initialized variable reg: 6, insn: 0x016a: INVOKE (r6 I:java.io.BufferedReader) VIRTUAL call: java.io.BufferedReader.close():void A[Catch: all -> 0x0173, MD:():void throws java.io.IOException (c)], block:B:55:0x0168 */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:52:0x015b -> B:53:0x015d). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final java.lang.Object invokeSuspend(java.lang.Object r19) {
            /*
                Method dump skipped, instruction units count: 382
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.example.tickets.GlobalSubwayDataManager.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    private final Sequence<Map<String, String>> readGtfsRows(ZipFile zip, String fileName) {
        return SequencesKt.sequence(new AnonymousClass1(zip, fileName, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<String> parseCsvLine(String line) {
        int i;
        ArrayList arrayList = new ArrayList();
        StringBuilder sb = new StringBuilder();
        int i2 = 0;
        boolean z = false;
        while (i2 < line.length()) {
            char cCharAt = line.charAt(i2);
            if (cCharAt == '\"') {
                if (z && (i = i2 + 1) < line.length() && line.charAt(i) == '\"') {
                    sb.append(Typography.quote);
                    i2 = i;
                } else {
                    z = !z;
                }
            } else if (cCharAt == ',' && !z) {
                arrayList.add(sb.toString());
                sb.setLength(0);
            } else {
                sb.append(cCharAt);
            }
            i2++;
        }
        arrayList.add(sb.toString());
        return arrayList;
    }

    private final Integer parseGtfsRouteColor(String raw) {
        Object objM9536constructorimpl;
        String strRemovePrefix = StringsKt.removePrefix(StringsKt.trim((CharSequence) raw).toString(), (CharSequence) "#");
        if (strRemovePrefix.length() != 6) {
            return null;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            GlobalSubwayDataManager globalSubwayDataManager = this;
            objM9536constructorimpl = Result.m9536constructorimpl(Integer.valueOf((int) (Long.parseLong(strRemovePrefix, CharsKt.checkRadix(16)) | 4278190080L)));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM9536constructorimpl = Result.m9536constructorimpl(ResultKt.createFailure(th));
        }
        return (Integer) (Result.m9542isFailureimpl(objM9536constructorimpl) ? null : objM9536constructorimpl);
    }

    private final StaticIndex buildAmapIndex(SubwayCity city) {
        if (StringsKt.isBlank(city.getAmapCode()) || StringsKt.isBlank(city.getAmapSlug())) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        return parseAmapJson(city, downloadText("https://map.amap.com/service/subway?_1555502190153&srhdata=" + city.getAmapCode() + "_drw_" + city.getAmapSlug() + ".json"));
    }

    /* JADX WARN: Code duplicated, block: B:66:0x0320  */
    private final StaticIndex parseAmapJson(SubwayCity city, String text) {
        int i;
        JSONArray jSONArray;
        HashMap map;
        HashMap map2;
        HashMap map3;
        JSONArray jSONArray2;
        int i2;
        int i3;
        JSONObject jSONObject = new JSONObject(text);
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("l");
        if (jSONArrayOptJSONArray == null && (jSONArrayOptJSONArray = jSONObject.optJSONArray("lines")) == null) {
            jSONArrayOptJSONArray = new JSONArray();
        }
        JSONArray jSONArray3 = jSONArrayOptJSONArray;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        HashMap map4 = new HashMap();
        HashMap map5 = new HashMap();
        HashMap map6 = new HashMap();
        int length = jSONArray3.length();
        int i4 = 0;
        while (i4 < length) {
            JSONObject jSONObjectOptJSONObject = jSONArray3.optJSONObject(i4);
            if (jSONObjectOptJSONObject == null) {
                i = i4;
                jSONArray = jSONArray3;
                map = map4;
                map2 = map5;
                map3 = map6;
            } else {
                String strOptString = jSONObjectOptJSONObject.optString("ln");
                Intrinsics.checkNotNullExpressionValue(strOptString, "optString(...)");
                String strOptString2 = jSONObjectOptJSONObject.optString(HintConstants.AUTOFILL_HINT_NAME);
                Intrinsics.checkNotNullExpressionValue(strOptString2, "optString(...)");
                String strOptString3 = jSONObjectOptJSONObject.optString("la");
                Intrinsics.checkNotNullExpressionValue(strOptString3, "optString(...)");
                String strOptString4 = jSONObjectOptJSONObject.optString("ls");
                Intrinsics.checkNotNullExpressionValue(strOptString4, "optString(...)");
                String strFirstNonBlank = firstNonBlank(strOptString, strOptString2, strOptString3, strOptString4);
                if (StringsKt.isBlank(strFirstNonBlank)) {
                    i = i4;
                    jSONArray = jSONArray3;
                    map = map4;
                    map2 = map5;
                    map3 = map6;
                } else {
                    String strOptString5 = jSONObjectOptJSONObject.optString("ls");
                    Intrinsics.checkNotNullExpressionValue(strOptString5, "optString(...)");
                    String strOptString6 = jSONObjectOptJSONObject.optString("lineId");
                    Intrinsics.checkNotNullExpressionValue(strOptString6, "optString(...)");
                    String strFirstNonBlank2 = firstNonBlank(strOptString5, strOptString6, normalizeLineName(strFirstNonBlank));
                    String str = city.getId() + ":" + strFirstNonBlank2;
                    String strNormalizeLineName = normalizeLineName(strFirstNonBlank);
                    if (StringsKt.isBlank(strNormalizeLineName)) {
                        strNormalizeLineName = strFirstNonBlank;
                    }
                    String str2 = strNormalizeLineName;
                    map = map4;
                    map3 = map6;
                    jSONArray = jSONArray3;
                    map2 = map5;
                    HashMap map7 = map3;
                    map7.put(str, new SubwayRouteInfo(str, str2, strFirstNonBlank, routeColor$default(this, city.getId(), str2, strFirstNonBlank2, i4, null, 16, null)));
                    JSONArray jSONArrayOptJSONArray2 = jSONObjectOptJSONObject.optJSONArray("st");
                    if (jSONArrayOptJSONArray2 == null && (jSONArrayOptJSONArray2 = jSONObjectOptJSONObject.optJSONArray("stations")) == null) {
                        i = i4;
                    } else {
                        ArrayList arrayList = new ArrayList(jSONArrayOptJSONArray2.length());
                        int length2 = jSONArrayOptJSONArray2.length();
                        int i5 = 0;
                        while (i5 < length2) {
                            JSONObject jSONObjectOptJSONObject2 = jSONArrayOptJSONArray2.optJSONObject(i5);
                            if (jSONObjectOptJSONObject2 == null) {
                                jSONArray2 = jSONArrayOptJSONArray2;
                                i2 = i4;
                                i3 = length2;
                            } else {
                                String strOptString7 = jSONObjectOptJSONObject2.optString("sid");
                                Intrinsics.checkNotNullExpressionValue(strOptString7, "optString(...)");
                                String strOptString8 = jSONObjectOptJSONObject2.optString("id");
                                Intrinsics.checkNotNullExpressionValue(strOptString8, "optString(...)");
                                jSONArray2 = jSONArrayOptJSONArray2;
                                String strOptString9 = jSONObjectOptJSONObject2.optString("si");
                                Intrinsics.checkNotNullExpressionValue(strOptString9, "optString(...)");
                                String strFirstNonBlank3 = firstNonBlank(strOptString7, strOptString8, strOptString9);
                                String strOptString10 = jSONObjectOptJSONObject2.optString("n");
                                Intrinsics.checkNotNullExpressionValue(strOptString10, "optString(...)");
                                String strOptString11 = jSONObjectOptJSONObject2.optString(HintConstants.AUTOFILL_HINT_NAME);
                                Intrinsics.checkNotNullExpressionValue(strOptString11, "optString(...)");
                                i2 = i4;
                                String strOptString12 = jSONObjectOptJSONObject2.optString("sn");
                                Intrinsics.checkNotNullExpressionValue(strOptString12, "optString(...)");
                                String strFirstNonBlank4 = firstNonBlank(strOptString10, strOptString11, strOptString12);
                                String strOptString13 = jSONObjectOptJSONObject2.optString("sl");
                                Intrinsics.checkNotNullExpressionValue(strOptString13, "optString(...)");
                                String strOptString14 = jSONObjectOptJSONObject2.optString("location");
                                Intrinsics.checkNotNullExpressionValue(strOptString14, "optString(...)");
                                i3 = length2;
                                String strOptString15 = jSONObjectOptJSONObject2.optString("coord");
                                Intrinsics.checkNotNullExpressionValue(strOptString15, "optString(...)");
                                Pair<Double, Double> coordinatePair = parseCoordinatePair(firstNonBlank(strOptString13, strOptString14, strOptString15));
                                if (coordinatePair != null && !StringsKt.isBlank(strFirstNonBlank4)) {
                                    String str3 = city.getId() + ":" + strFirstNonBlank3 + ":" + normalizeSearch(strFirstNonBlank4);
                                    SubwayStationOption subwayStationOption = (SubwayStationOption) linkedHashMap.get(str3);
                                    if (subwayStationOption == null) {
                                        linkedHashMap.put(str3, new SubwayStationOption(str3, strFirstNonBlank4, coordinatePair.getFirst().doubleValue(), coordinatePair.getSecond().doubleValue(), CollectionsKt.listOf(MapsKt.getValue(map7, str)), null, 32, null));
                                    } else {
                                        List<SubwayRouteInfo> routes = subwayStationOption.getRoutes();
                                        if ((routes instanceof Collection) && routes.isEmpty()) {
                                            linkedHashMap.put(str3, SubwayStationOption.copy$default(subwayStationOption, null, null, AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, CollectionsKt.sortedWith(CollectionsKt.plus((Collection<? extends Object>) subwayStationOption.getRoutes(), MapsKt.getValue(map7, str)), new Comparator() { // from class: com.example.tickets.GlobalSubwayDataManager$parseAmapJson$$inlined$sortedBy$1
                                                /* JADX WARN: Multi-variable type inference failed */
                                                @Override // java.util.Comparator
                                                public final int compare(T t, T t2) {
                                                    return ComparisonsKt.compareValues(((GlobalSubwayDataManager.SubwayRouteInfo) t).getShortName(), ((GlobalSubwayDataManager.SubwayRouteInfo) t2).getShortName());
                                                }
                                            }), null, 47, null));
                                            break;
                                        }
                                        Iterator<T> it = routes.iterator();
                                        do {
                                            if (!it.hasNext()) {
                                                linkedHashMap.put(str3, SubwayStationOption.copy$default(subwayStationOption, null, null, AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, CollectionsKt.sortedWith(CollectionsKt.plus((Collection<? extends Object>) subwayStationOption.getRoutes(), MapsKt.getValue(map7, str)), new Comparator() { // from class: com.example.tickets.GlobalSubwayDataManager$parseAmapJson$$inlined$sortedBy$1
                                                    /* JADX WARN: Multi-variable type inference failed */
                                                    @Override // java.util.Comparator
                                                    public final int compare(T t, T t2) {
                                                        return ComparisonsKt.compareValues(((GlobalSubwayDataManager.SubwayRouteInfo) t).getShortName(), ((GlobalSubwayDataManager.SubwayRouteInfo) t2).getShortName());
                                                    }
                                                }), null, 47, null));
                                                break;
                                            }
                                        } while (!Intrinsics.areEqual(((SubwayRouteInfo) it.next()).getRouteId(), str));
                                    }
                                    HashMap map8 = map;
                                    Object obj = map8.get(str3);
                                    if (obj == null) {
                                        obj = (Set) new LinkedHashSet();
                                        map8.put(str3, obj);
                                    }
                                    ((Set) obj).add(str);
                                    if (!Intrinsics.areEqual(CollectionsKt.lastOrNull((List) arrayList), str3)) {
                                        arrayList.add(str3);
                                    }
                                }
                            }
                            i5++;
                            jSONArrayOptJSONArray2 = jSONArray2;
                            i4 = i2;
                            length2 = i3;
                        }
                        i = i4;
                        if (arrayList.size() >= 2) {
                            String strJoinToString$default = CollectionsKt.joinToString$default(arrayList, "|", null, null, 0, null, null, 62, null);
                            HashMap map9 = map2;
                            Object obj2 = map9.get(str);
                            if (obj2 == null) {
                                obj2 = (List) new ArrayList();
                                map9.put(str, obj2);
                            }
                            Iterable iterable = (Iterable) obj2;
                            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
                            Iterator it2 = iterable.iterator();
                            while (it2.hasNext()) {
                                arrayList2.add(CollectionsKt.joinToString$default((List) it2.next(), "|", null, null, 0, null, null, 62, null));
                            }
                            if (!arrayList2.contains(strJoinToString$default)) {
                                ((List) MapsKt.getValue(map9, str)).add(arrayList);
                            }
                        }
                    }
                }
            }
            i4 = i + 1;
            map4 = map;
            map5 = map2;
            map6 = map3;
            jSONArray3 = jSONArray;
        }
        HashMap map10 = map5;
        HashMap map11 = map6;
        LinkedHashMap linkedHashMap2 = linkedHashMap;
        HashMap map12 = map4;
        LinkedHashMap linkedHashMap3 = new LinkedHashMap(MapsKt.mapCapacity(map12.size()));
        for (Map.Entry entry : map12.entrySet()) {
            linkedHashMap3.put(entry.getKey(), CollectionsKt.toSet((Iterable) entry.getValue()));
        }
        HashMap map13 = map10;
        LinkedHashMap linkedHashMap4 = new LinkedHashMap(MapsKt.mapCapacity(map13.size()));
        for (Map.Entry entry2 : map13.entrySet()) {
            linkedHashMap4.put(entry2.getKey(), CollectionsKt.toList((Iterable) entry2.getValue()));
        }
        return new StaticIndex(linkedHashMap2, linkedHashMap3, linkedHashMap4, map11);
    }

    /* JADX INFO: compiled from: GlobalSubwayData.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/example/tickets/GlobalSubwayDataManager$RouteSearchState;", "", "stationKey", "", "routeId", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getStationKey", "()Ljava/lang/String;", "getRouteId", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
    private static final /* data */ class RouteSearchState {
        private final String routeId;
        private final String stationKey;

        public static /* synthetic */ RouteSearchState copy$default(RouteSearchState routeSearchState, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = routeSearchState.stationKey;
            }
            if ((i & 2) != 0) {
                str2 = routeSearchState.routeId;
            }
            return routeSearchState.copy(str, str2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getStationKey() {
            return this.stationKey;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getRouteId() {
            return this.routeId;
        }

        public final RouteSearchState copy(String stationKey, String routeId) {
            Intrinsics.checkNotNullParameter(stationKey, "stationKey");
            Intrinsics.checkNotNullParameter(routeId, "routeId");
            return new RouteSearchState(stationKey, routeId);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof RouteSearchState)) {
                return false;
            }
            RouteSearchState routeSearchState = (RouteSearchState) other;
            return Intrinsics.areEqual(this.stationKey, routeSearchState.stationKey) && Intrinsics.areEqual(this.routeId, routeSearchState.routeId);
        }

        public int hashCode() {
            return (this.stationKey.hashCode() * 31) + this.routeId.hashCode();
        }

        public String toString() {
            return "RouteSearchState(stationKey=" + this.stationKey + ", routeId=" + this.routeId + ")";
        }

        public RouteSearchState(String stationKey, String routeId) {
            Intrinsics.checkNotNullParameter(stationKey, "stationKey");
            Intrinsics.checkNotNullParameter(routeId, "routeId");
            this.stationKey = stationKey;
            this.routeId = routeId;
        }

        public final String getStationKey() {
            return this.stationKey;
        }

        public final String getRouteId() {
            return this.routeId;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: GlobalSubwayData.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0011\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0000H\u0096\u0002J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u000b\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/example/tickets/GlobalSubwayDataManager$RouteSearchScore;", "", "transfers", "", "stops", "<init>", "(II)V", "getTransfers", "()I", "getStops", "compareTo", "other", "component1", "component2", "copy", "equals", "", "", "hashCode", "toString", "", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
    static final /* data */ class RouteSearchScore implements Comparable<RouteSearchScore> {
        private final int stops;
        private final int transfers;

        public static /* synthetic */ RouteSearchScore copy$default(RouteSearchScore routeSearchScore, int i, int i2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                i = routeSearchScore.transfers;
            }
            if ((i3 & 2) != 0) {
                i2 = routeSearchScore.stops;
            }
            return routeSearchScore.copy(i, i2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getTransfers() {
            return this.transfers;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final int getStops() {
            return this.stops;
        }

        public final RouteSearchScore copy(int transfers, int stops) {
            return new RouteSearchScore(transfers, stops);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof RouteSearchScore)) {
                return false;
            }
            RouteSearchScore routeSearchScore = (RouteSearchScore) other;
            return this.transfers == routeSearchScore.transfers && this.stops == routeSearchScore.stops;
        }

        public int hashCode() {
            return (Integer.hashCode(this.transfers) * 31) + Integer.hashCode(this.stops);
        }

        public String toString() {
            return "RouteSearchScore(transfers=" + this.transfers + ", stops=" + this.stops + ")";
        }

        public RouteSearchScore(int i, int i2) {
            this.transfers = i;
            this.stops = i2;
        }

        public final int getTransfers() {
            return this.transfers;
        }

        public final int getStops() {
            return this.stops;
        }

        @Override // java.lang.Comparable
        public int compareTo(RouteSearchScore other) {
            Intrinsics.checkNotNullParameter(other, "other");
            int iCompare = Intrinsics.compare(this.transfers, other.transfers);
            return iCompare != 0 ? iCompare : Intrinsics.compare(this.stops, other.stops);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: GlobalSubwayData.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/example/tickets/GlobalSubwayDataManager$RouteQueueNode;", "", "state", "Lcom/example/tickets/GlobalSubwayDataManager$RouteSearchState;", "score", "Lcom/example/tickets/GlobalSubwayDataManager$RouteSearchScore;", "<init>", "(Lcom/example/tickets/GlobalSubwayDataManager$RouteSearchState;Lcom/example/tickets/GlobalSubwayDataManager$RouteSearchScore;)V", "getState", "()Lcom/example/tickets/GlobalSubwayDataManager$RouteSearchState;", "getScore", "()Lcom/example/tickets/GlobalSubwayDataManager$RouteSearchScore;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
    static final /* data */ class RouteQueueNode {
        private final RouteSearchScore score;
        private final RouteSearchState state;

        public static /* synthetic */ RouteQueueNode copy$default(RouteQueueNode routeQueueNode, RouteSearchState routeSearchState, RouteSearchScore routeSearchScore, int i, Object obj) {
            if ((i & 1) != 0) {
                routeSearchState = routeQueueNode.state;
            }
            if ((i & 2) != 0) {
                routeSearchScore = routeQueueNode.score;
            }
            return routeQueueNode.copy(routeSearchState, routeSearchScore);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final RouteSearchState getState() {
            return this.state;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final RouteSearchScore getScore() {
            return this.score;
        }

        public final RouteQueueNode copy(RouteSearchState state, RouteSearchScore score) {
            Intrinsics.checkNotNullParameter(state, "state");
            Intrinsics.checkNotNullParameter(score, "score");
            return new RouteQueueNode(state, score);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof RouteQueueNode)) {
                return false;
            }
            RouteQueueNode routeQueueNode = (RouteQueueNode) other;
            return Intrinsics.areEqual(this.state, routeQueueNode.state) && Intrinsics.areEqual(this.score, routeQueueNode.score);
        }

        public int hashCode() {
            return (this.state.hashCode() * 31) + this.score.hashCode();
        }

        public String toString() {
            return "RouteQueueNode(state=" + this.state + ", score=" + this.score + ")";
        }

        public RouteQueueNode(RouteSearchState state, RouteSearchScore score) {
            Intrinsics.checkNotNullParameter(state, "state");
            Intrinsics.checkNotNullParameter(score, "score");
            this.state = state;
            this.score = score;
        }

        public final RouteSearchState getState() {
            return this.state;
        }

        public final RouteSearchScore getScore() {
            return this.score;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SubwayRoutePlan resolvePlan(StaticIndex index, String cityId, String origin, String destination) {
        String strResolveStationKey;
        SubwayRouteStation subwayRouteStationRouteStation;
        String strResolveStationKey2 = resolveStationKey(index, origin);
        if (strResolveStationKey2 == null || (strResolveStationKey = resolveStationKey(index, destination)) == null) {
            return null;
        }
        if (Intrinsics.areEqual(strResolveStationKey2, strResolveStationKey)) {
            String str = (String) CollectionsKt.firstOrNull(CollectionsKt.sorted(index.routesForStation(strResolveStationKey2)));
            if (str == null) {
                return null;
            }
            SubwayRouteInfo subwayRouteInfoRouteInfo = index.routeInfo(str);
            SubwayRouteStation subwayRouteStationRouteStation2 = routeStation(index, strResolveStationKey2, str);
            if (subwayRouteStationRouteStation2 == null) {
                return null;
            }
            return new SubwayRoutePlan(cityId, subwayRouteInfoRouteInfo, null, null, null, CollectionsKt.listOf(subwayRouteStationRouteStation2), CollectionsKt.listOf(new RoutePoint(subwayRouteStationRouteStation2.getLatitude(), subwayRouteStationRouteStation2.getLongitude())), CollectionsKt.listOf(subwayRouteInfoRouteInfo), 28, null);
        }
        List<RouteSearchState> listFindBestRoutePath = findBestRoutePath(index, strResolveStationKey2, strResolveStationKey);
        if (listFindBestRoutePath == null) {
            return null;
        }
        if (Intrinsics.areEqual(cityId, "wuhan")) {
            List<RouteSearchState> list = listFindBestRoutePath;
            if (!(list instanceof Collection) || !list.isEmpty()) {
                for (RouteSearchState routeSearchState : list) {
                    SubwayStationOption subwayStationOptionStationOption = index.stationOption(routeSearchState.getStationKey());
                    if (subwayStationOptionStationOption != null) {
                        GlobalSubwayDataManager globalSubwayDataManager = INSTANCE;
                        if (Intrinsics.areEqual(globalSubwayDataManager.normalizeLineName(index.routeInfo(routeSearchState.getRouteId()).getShortName()), "12") && Intrinsics.areEqual(globalSubwayDataManager.normalizeSearch(subwayStationOptionStationOption.getName()), globalSubwayDataManager.normalizeSearch("宏图大道"))) {
                            return null;
                        }
                    }
                }
            }
        }
        ArrayList arrayList = new ArrayList();
        String stationKey = "";
        for (RouteSearchState routeSearchState2 : listFindBestRoutePath) {
            if (!Intrinsics.areEqual(routeSearchState2.getStationKey(), stationKey) && (subwayRouteStationRouteStation = INSTANCE.routeStation(index, routeSearchState2.getStationKey(), routeSearchState2.getRouteId())) != null) {
                arrayList.add(subwayRouteStationRouteStation);
                stationKey = routeSearchState2.getStationKey();
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        ArrayList<SubwayRouteStation> arrayList2 = arrayList;
        ArrayList<String> arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            arrayList3.add(((SubwayRouteStation) it.next()).getRouteId());
        }
        ArrayList arrayList4 = new ArrayList();
        for (String str2 : arrayList3) {
            if (!Intrinsics.areEqual(CollectionsKt.lastOrNull((List) arrayList4), str2)) {
                arrayList4.add(str2);
            }
        }
        ArrayList arrayList5 = arrayList4;
        ArrayList arrayList6 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList5, 10));
        Iterator it2 = arrayList5.iterator();
        while (it2.hasNext()) {
            arrayList6.add(index.routeInfo((String) it2.next()));
        }
        ArrayList arrayList7 = arrayList6;
        SubwayRouteInfo subwayRouteInfo = (SubwayRouteInfo) CollectionsKt.firstOrNull((List) arrayList7);
        if (subwayRouteInfo == null) {
            return null;
        }
        SubwayRouteInfo subwayRouteInfo2 = (SubwayRouteInfo) CollectionsKt.getOrNull(arrayList7, 1);
        ArrayList arrayList8 = arrayList;
        int lastIndex = CollectionsKt.getLastIndex(arrayList8);
        int i = 0;
        while (true) {
            if (i >= lastIndex) {
                i = -1;
                break;
            }
            int i2 = i + 1;
            if (!Intrinsics.areEqual(((SubwayRouteStation) arrayList.get(i)).getRouteId(), ((SubwayRouteStation) arrayList.get(i2)).getRouteId())) {
                break;
            }
            i = i2;
        }
        SubwayStationOption subwayStationOptionStationOption2 = i >= 0 ? index.stationOption(((SubwayRouteStation) arrayList.get(i)).getStationKey()) : null;
        String key = subwayStationOptionStationOption2 != null ? subwayStationOptionStationOption2.getKey() : null;
        String str3 = key == null ? "" : key;
        ArrayList arrayList9 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
        for (SubwayRouteStation subwayRouteStation : arrayList2) {
            arrayList9.add(new RoutePoint(subwayRouteStation.getLatitude(), subwayRouteStation.getLongitude()));
        }
        return new SubwayRoutePlan(cityId, subwayRouteInfo, subwayRouteInfo2, subwayStationOptionStationOption2, str3, arrayList8, arrayList9, arrayList7);
    }

    private final List<RouteSearchState> findBestRoutePath(StaticIndex index, String originKey, String destinationKey) {
        HashMap map = new HashMap();
        for (Map.Entry<String, List<List<String>>> entry : index.getRoutePatterns().entrySet()) {
            String key = entry.getKey();
            Iterator<T> it = entry.getValue().iterator();
            while (it.hasNext()) {
                List list = (List) it.next();
                int lastIndex = CollectionsKt.getLastIndex(list);
                int i = 0;
                while (i < lastIndex) {
                    RouteSearchState routeSearchState = new RouteSearchState((String) list.get(i), key);
                    i++;
                    RouteSearchState routeSearchState2 = new RouteSearchState((String) list.get(i), key);
                    findBestRoutePath$addEdge(map, routeSearchState, routeSearchState2);
                    findBestRoutePath$addEdge(map, routeSearchState2, routeSearchState);
                }
            }
        }
        HashMap map2 = new HashMap();
        for (Map.Entry<String, List<List<String>>> entry2 : index.getRoutePatterns().entrySet()) {
            String key2 = entry2.getKey();
            Iterator<T> it2 = entry2.getValue().iterator();
            while (it2.hasNext()) {
                for (String str : (List) it2.next()) {
                    HashMap map3 = map2;
                    Object obj = map3.get(str);
                    if (obj == null) {
                        obj = (Set) new LinkedHashSet();
                        map3.put(str, obj);
                    }
                    ((Set) obj).add(key2);
                }
            }
        }
        for (Map.Entry entry3 : map2.entrySet()) {
            String str2 = (String) entry3.getKey();
            List listSorted = CollectionsKt.sorted((Set) entry3.getValue());
            int lastIndex2 = CollectionsKt.getLastIndex(listSorted);
            int i2 = 0;
            while (i2 < lastIndex2) {
                int i3 = i2 + 1;
                int size = listSorted.size();
                for (int i4 = i3; i4 < size; i4++) {
                    RouteSearchState routeSearchState3 = new RouteSearchState(str2, (String) listSorted.get(i2));
                    RouteSearchState routeSearchState4 = new RouteSearchState(str2, (String) listSorted.get(i4));
                    findBestRoutePath$addEdge(map, routeSearchState3, routeSearchState4);
                    findBestRoutePath$addEdge(map, routeSearchState4, routeSearchState3);
                }
                i2 = i3;
            }
        }
        HashMap map4 = new HashMap();
        HashMap map5 = new HashMap();
        final Function2 function2 = new Function2() { // from class: com.example.tickets.GlobalSubwayDataManager$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj2, Object obj3) {
                return Integer.valueOf(((GlobalSubwayDataManager.RouteQueueNode) obj2).getScore().compareTo(((GlobalSubwayDataManager.RouteQueueNode) obj3).getScore()));
            }
        };
        PriorityQueue priorityQueue = new PriorityQueue(new Comparator() { // from class: com.example.tickets.GlobalSubwayDataManager$$ExternalSyntheticLambda4
            @Override // java.util.Comparator
            public final int compare(Object obj2, Object obj3) {
                return ((Number) function2.invoke(obj2, obj3)).intValue();
            }
        });
        Set setEmptySet = (Set) map2.get(originKey);
        if (setEmptySet == null) {
            setEmptySet = SetsKt.emptySet();
        }
        Iterator it3 = CollectionsKt.sorted(setEmptySet).iterator();
        while (it3.hasNext()) {
            RouteSearchState routeSearchState5 = new RouteSearchState(originKey, (String) it3.next());
            RouteSearchScore routeSearchScore = new RouteSearchScore(0, 0);
            map4.put(routeSearchState5, routeSearchScore);
            priorityQueue.add(new RouteQueueNode(routeSearchState5, routeSearchScore));
        }
        RouteSearchState state = null;
        RouteSearchScore score = null;
        while (true) {
            PriorityQueue priorityQueue2 = priorityQueue;
            if (priorityQueue2.isEmpty()) {
                break;
            }
            RouteQueueNode routeQueueNode = (RouteQueueNode) priorityQueue.poll();
            RouteSearchScore routeSearchScore2 = (RouteSearchScore) map4.get(routeQueueNode.getState());
            if (routeSearchScore2 != null && Intrinsics.areEqual(routeSearchScore2, routeQueueNode.getScore())) {
                if (Intrinsics.areEqual(routeQueueNode.getState().getStationKey(), destinationKey)) {
                    if (score == null || routeQueueNode.getScore().compareTo(score) < 0) {
                        state = routeQueueNode.getState();
                        score = routeQueueNode.getScore();
                    }
                } else {
                    Set<RouteSearchState> setEmptySet2 = (Set) map.get(routeQueueNode.getState());
                    if (setEmptySet2 == null) {
                        setEmptySet2 = SetsKt.emptySet();
                    }
                    for (RouteSearchState routeSearchState6 : setEmptySet2) {
                        int i5 = (!Intrinsics.areEqual(routeSearchState6.getStationKey(), routeQueueNode.getState().getStationKey()) || Intrinsics.areEqual(routeSearchState6.getRouteId(), routeQueueNode.getState().getRouteId())) ? 0 : 1;
                        int transfers = routeQueueNode.getScore().getTransfers() + i5;
                        if (transfers <= 6) {
                            RouteSearchScore routeSearchScore3 = new RouteSearchScore(transfers, routeQueueNode.getScore().getStops() + (i5 ^ 1));
                            RouteSearchScore routeSearchScore4 = (RouteSearchScore) map4.get(routeSearchState6);
                            if (routeSearchScore4 == null || routeSearchScore3.compareTo(routeSearchScore4) < 0) {
                                map4.put(routeSearchState6, routeSearchScore3);
                                map5.put(routeSearchState6, routeQueueNode.getState());
                                priorityQueue2.add(new RouteQueueNode(routeSearchState6, routeSearchScore3));
                            }
                        }
                    }
                }
            }
        }
        if (state == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        while (state != null) {
            arrayList.add(state);
            state = (RouteSearchState) map5.get(state);
        }
        ArrayList arrayList2 = arrayList;
        CollectionsKt.reverse(arrayList2);
        return arrayList2;
    }

    private static final void findBestRoutePath$addEdge(HashMap<RouteSearchState, Set<RouteSearchState>> map, RouteSearchState routeSearchState, RouteSearchState routeSearchState2) {
        HashMap<RouteSearchState, Set<RouteSearchState>> map2 = map;
        LinkedHashSet linkedHashSet = map2.get(routeSearchState);
        if (linkedHashSet == null) {
            linkedHashSet = new LinkedHashSet();
            map2.put(routeSearchState, linkedHashSet);
        }
        linkedHashSet.add(routeSearchState2);
    }

    private final SubwayRoutePlan routeForPair(StaticIndex index, String cityId, String routeId, String from, String to) {
        SubwayRouteInfo subwayRouteInfoRouteInfo = index.routeInfo(routeId);
        List<SubwayRouteStation> listStationsForRouteRange = stationsForRouteRange(index, routeId, from, to);
        if (listStationsForRouteRange.isEmpty()) {
            return null;
        }
        List<SubwayRouteStation> list = listStationsForRouteRange;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (SubwayRouteStation subwayRouteStation : list) {
            arrayList.add(new RoutePoint(subwayRouteStation.getLatitude(), subwayRouteStation.getLongitude()));
        }
        return new SubwayRoutePlan(cityId, subwayRouteInfoRouteInfo, null, null, null, listStationsForRouteRange, arrayList, null, 156, null);
    }

    /* JADX WARN: Code duplicated, block: B:28:0x00c2  */
    private final String preferredTransferStationKey(StaticIndex index, String cityId, String primaryId, String secondaryId) {
        String str;
        Object next;
        if (!Intrinsics.areEqual(cityId, "wuhan")) {
            return null;
        }
        Set of = SetsKt.setOf((Object[]) new String[]{normalizeLineName(index.routeInfo(primaryId).getShortName()), normalizeLineName(index.routeInfo(secondaryId).getShortName())});
        if (Intrinsics.areEqual(of, SetsKt.setOf((Object[]) new String[]{ExifInterface.GPS_MEASUREMENT_2D, "5"}))) {
            str = "积玉桥";
        } else if (Intrinsics.areEqual(of, SetsKt.setOf((Object[]) new String[]{"4", "5"}))) {
            str = "复兴路";
        } else if (Intrinsics.areEqual(of, SetsKt.setOf((Object[]) new String[]{"5", "7"})) || Intrinsics.areEqual(of, SetsKt.setOf((Object[]) new String[]{"5", "8"}))) {
            str = "徐家棚";
        } else if (Intrinsics.areEqual(of, SetsKt.setOf((Object[]) new String[]{"5", "12"}))) {
            str = "光霞";
        } else if (Intrinsics.areEqual(of, SetsKt.setOf((Object[]) new String[]{"4", "12"}))) {
            str = "园林路";
        } else {
            if (!Intrinsics.areEqual(of, SetsKt.setOf((Object[]) new String[]{"8", "12"}))) {
                if (Intrinsics.areEqual(of, SetsKt.setOf((Object[]) new String[]{"6", "12"}))) {
                    str = "国博中心南";
                } else if (Intrinsics.areEqual(of, SetsKt.setOf((Object[]) new String[]{"11", "12"}))) {
                    str = "武昌站东广场";
                } else if (Intrinsics.areEqual(of, SetsKt.setOf((Object[]) new String[]{"12", "16"}))) {
                    str = "国博中心南";
                } else if (Intrinsics.areEqual(of, SetsKt.setOf((Object[]) new String[]{"5", "19"}))) {
                    str = "武汉站东广场";
                }
                return null;
            }
            str = "汪家墩";
        }
        String strNormalizeSearch = normalizeSearch(str);
        Iterator<T> it = index.getStationsByKey().values().iterator();
        loop0: while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            SubwayStationOption subwayStationOption = (SubwayStationOption) next;
            if (Intrinsics.areEqual(INSTANCE.normalizeSearch(subwayStationOption.getName()), strNormalizeSearch)) {
                List<SubwayRouteInfo> routes = subwayStationOption.getRoutes();
                if (!(routes instanceof Collection) || !routes.isEmpty()) {
                    Iterator<T> it2 = routes.iterator();
                    while (it2.hasNext()) {
                        if (Intrinsics.areEqual(((SubwayRouteInfo) it2.next()).getRouteId(), primaryId)) {
                            List<SubwayRouteInfo> routes2 = subwayStationOption.getRoutes();
                            if (!(routes2 instanceof Collection) || !routes2.isEmpty()) {
                                Iterator<T> it3 = routes2.iterator();
                                while (it3.hasNext()) {
                                    if (Intrinsics.areEqual(((SubwayRouteInfo) it3.next()).getRouteId(), secondaryId)) {
                                        break loop0;
                                    }
                                }
                                break;
                            }
                            break;
                        }
                    }
                }
            }
        }
        SubwayStationOption subwayStationOption2 = (SubwayStationOption) next;
        if (subwayStationOption2 != null) {
            return subwayStationOption2.getKey();
        }
        return null;
    }

    private final String findTransferStation(final StaticIndex index, final String primaryId, final String secondaryId, final String from, final String to) {
        Sequence sequenceMapNotNull = SequencesKt.mapNotNull(CollectionsKt.asSequence(CollectionsKt.intersect(reachableAlongRoute(index, primaryId, from), reachableAlongRoute(index, secondaryId, to))), new Function1() { // from class: com.example.tickets.GlobalSubwayDataManager$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return GlobalSubwayDataManager.findTransferStation$lambda$141(index, primaryId, from, secondaryId, to, (String) obj);
            }
        });
        final Comparator comparator = new Comparator() { // from class: com.example.tickets.GlobalSubwayDataManager$findTransferStation$$inlined$compareBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues((Comparable) ((Triple) t).getSecond(), (Comparable) ((Triple) t2).getSecond());
            }
        };
        Triple triple = (Triple) SequencesKt.firstOrNull(SequencesKt.sortedWith(sequenceMapNotNull, new Comparator() { // from class: com.example.tickets.GlobalSubwayDataManager$findTransferStation$$inlined$thenBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                int iCompare = comparator.compare(t, t2);
                return iCompare != 0 ? iCompare : ComparisonsKt.compareValues((Comparable) ((Triple) t).getThird(), (Comparable) ((Triple) t2).getThird());
            }
        }));
        if (triple != null) {
            return (String) triple.getFirst();
        }
        return null;
    }

    static final Triple findTransferStation$lambda$141(StaticIndex staticIndex, String str, String str2, String str3, String str4, String key) {
        GlobalSubwayDataManager globalSubwayDataManager;
        Integer numStationDistanceAlongRoute;
        Intrinsics.checkNotNullParameter(key, "key");
        SubwayStationOption subwayStationOptionStationOption = staticIndex.stationOption(key);
        if (subwayStationOptionStationOption != null && (numStationDistanceAlongRoute = (globalSubwayDataManager = INSTANCE).stationDistanceAlongRoute(staticIndex, str, str2, key)) != null) {
            int iIntValue = numStationDistanceAlongRoute.intValue();
            Integer numStationDistanceAlongRoute2 = globalSubwayDataManager.stationDistanceAlongRoute(staticIndex, str3, str4, key);
            if (numStationDistanceAlongRoute2 != null) {
                return new Triple(key, Integer.valueOf(iIntValue + numStationDistanceAlongRoute2.intValue()), subwayStationOptionStationOption.getName());
            }
        }
        return null;
    }

    private final Set<String> reachableAlongRoute(StaticIndex index, String routeId, final String anchor) {
        List<List<String>> listEmptyList = index.getRoutePatterns().get(routeId);
        if (listEmptyList == null) {
            listEmptyList = CollectionsKt.emptyList();
        }
        return SequencesKt.toSet(SequencesKt.flatMap(SequencesKt.filter(CollectionsKt.asSequence(listEmptyList), new Function1() { // from class: com.example.tickets.GlobalSubwayDataManager$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(GlobalSubwayDataManager.reachableAlongRoute$lambda$144(anchor, (List) obj));
            }
        }), new Function1() { // from class: com.example.tickets.GlobalSubwayDataManager$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return GlobalSubwayDataManager.reachableAlongRoute$lambda$145((List) obj);
            }
        }));
    }

    static final boolean reachableAlongRoute$lambda$144(String str, List it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.contains(str);
    }

    static final Sequence reachableAlongRoute$lambda$145(List it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return CollectionsKt.asSequence(it);
    }

    private final Integer stationDistanceAlongRoute(StaticIndex index, String routeId, String anchor, String candidate) {
        List<List<String>> listEmptyList = index.getRoutePatterns().get(routeId);
        if (listEmptyList == null) {
            listEmptyList = CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = listEmptyList.iterator();
        while (it.hasNext()) {
            List list = (List) it.next();
            int iIndexOf = list.indexOf(anchor);
            int iIndexOf2 = list.indexOf(candidate);
            Integer numValueOf = (iIndexOf < 0 || iIndexOf2 < 0) ? null : Integer.valueOf(Math.abs(iIndexOf - iIndexOf2));
            if (numValueOf != null) {
                arrayList.add(numValueOf);
            }
        }
        return (Integer) CollectionsKt.minOrNull((Iterable) arrayList);
    }

    private final List<SubwayRouteStation> stationsForRouteRange(StaticIndex index, String routeId, String from, String to) {
        Object next;
        Triple triple;
        List listReversed;
        List<List<String>> listEmptyList = index.getRoutePatterns().get(routeId);
        if (listEmptyList == null) {
            listEmptyList = CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = listEmptyList.iterator();
        while (true) {
            next = null;
            if (!it.hasNext()) {
                break;
            }
            List list = (List) it.next();
            int iIndexOf = list.indexOf(from);
            int iIndexOf2 = list.indexOf(to);
            if (iIndexOf >= 0 && iIndexOf2 >= 0 && iIndexOf != iIndexOf2) {
                next = TuplesKt.to(new Triple(list, Integer.valueOf(iIndexOf), Integer.valueOf(iIndexOf2)), Integer.valueOf(Math.abs(iIndexOf2 - iIndexOf)));
            }
            if (next != null) {
                arrayList.add(next);
            }
        }
        Iterator it2 = arrayList.iterator();
        if (it2.hasNext()) {
            next = it2.next();
            if (it2.hasNext()) {
                int iIntValue = ((Number) ((Pair) next).getSecond()).intValue();
                do {
                    Object next2 = it2.next();
                    int iIntValue2 = ((Number) ((Pair) next2).getSecond()).intValue();
                    if (iIntValue < iIntValue2) {
                        next = next2;
                        iIntValue = iIntValue2;
                    }
                } while (it2.hasNext());
            }
        }
        Pair pair = (Pair) next;
        if (pair == null || (triple = (Triple) pair.getFirst()) == null) {
            return CollectionsKt.emptyList();
        }
        int iIntValue3 = ((Number) triple.getSecond()).intValue();
        int iIntValue4 = ((Number) triple.getThird()).intValue();
        List list2 = (List) triple.getFirst();
        if (iIntValue3 <= iIntValue4) {
            listReversed = list2.subList(iIntValue3, iIntValue4 + 1);
        } else {
            listReversed = CollectionsKt.reversed(list2.subList(iIntValue4, iIntValue3 + 1));
        }
        List listDistinct = CollectionsKt.distinct(listReversed);
        ArrayList arrayList2 = new ArrayList();
        Iterator it3 = listDistinct.iterator();
        while (it3.hasNext()) {
            SubwayRouteStation subwayRouteStationRouteStation = INSTANCE.routeStation(index, (String) it3.next(), routeId);
            if (subwayRouteStationRouteStation != null) {
                arrayList2.add(subwayRouteStationRouteStation);
            }
        }
        return arrayList2;
    }

    private final SubwayRouteStation routeStation(StaticIndex index, String stationKey, String routeId) {
        SubwayStationOption subwayStationOptionStationOption = index.stationOption(stationKey);
        if (subwayStationOptionStationOption == null) {
            return null;
        }
        return new SubwayRouteStation(stationKey, subwayStationOptionStationOption.getName(), subwayStationOptionStationOption.getLatitude(), subwayStationOptionStationOption.getLongitude(), routeId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String resolveStationKey(StaticIndex index, String input) {
        Object next;
        Object next2;
        Object next3;
        String key;
        String key2;
        String strNormalizeStationSearch = normalizeStationSearch(input);
        if (StringsKt.isBlank(strNormalizeStationSearch)) {
            return null;
        }
        Collection<SubwayStationOption> collectionValues = index.getStationsByKey().values();
        Iterator<T> it = collectionValues.iterator();
        loop0: while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            SubwayStationOption subwayStationOption = (SubwayStationOption) next;
            Iterator it2 = SequencesKt.plus(SequencesKt.sequenceOf(subwayStationOption.getName()), CollectionsKt.asSequence(subwayStationOption.getSearchNames())).iterator();
            while (it2.hasNext()) {
                if (Intrinsics.areEqual(INSTANCE.normalizeStationSearch((String) it2.next()), strNormalizeStationSearch)) {
                    break loop0;
                }
            }
        }
        SubwayStationOption subwayStationOption2 = (SubwayStationOption) next;
        if (subwayStationOption2 != null && (key2 = subwayStationOption2.getKey()) != null) {
            return key2;
        }
        Iterator<T> it3 = collectionValues.iterator();
        loop2: while (true) {
            if (!it3.hasNext()) {
                next2 = null;
                break;
            }
            next2 = it3.next();
            SubwayStationOption subwayStationOption3 = (SubwayStationOption) next2;
            Iterator it4 = SequencesKt.plus(SequencesKt.sequenceOf(subwayStationOption3.getName()), CollectionsKt.asSequence(subwayStationOption3.getSearchNames())).iterator();
            while (it4.hasNext()) {
                if (StringsKt.startsWith$default(INSTANCE.normalizeStationSearch((String) it4.next()), strNormalizeStationSearch, false, 2, (Object) null)) {
                    break loop2;
                }
            }
        }
        SubwayStationOption subwayStationOption4 = (SubwayStationOption) next2;
        if (subwayStationOption4 != null && (key = subwayStationOption4.getKey()) != null) {
            return key;
        }
        Iterator<T> it5 = collectionValues.iterator();
        do {
            if (!it5.hasNext()) {
                next3 = null;
                break;
            }
            next3 = it5.next();
        } while (!INSTANCE.stationNameMatchesSearch((SubwayStationOption) next3, strNormalizeStationSearch));
        SubwayStationOption subwayStationOption5 = (SubwayStationOption) next3;
        if (subwayStationOption5 != null) {
            return subwayStationOption5.getKey();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean stationNameMatchesSearch(SubwayStationOption station, String normalizedQuery) {
        String str = normalizedQuery;
        if (StringsKt.isBlank(str)) {
            return false;
        }
        Iterator it = SequencesKt.plus(SequencesKt.sequenceOf(station.getName()), CollectionsKt.asSequence(station.getSearchNames())).iterator();
        while (it.hasNext()) {
            String strNormalizeStationSearch = INSTANCE.normalizeStationSearch((String) it.next());
            if (Intrinsics.areEqual(strNormalizeStationSearch, normalizedQuery)) {
                return true;
            }
            String str2 = strNormalizeStationSearch;
            if (StringsKt.contains$default((CharSequence) str2, (CharSequence) str, false, 2, (Object) null) || StringsKt.contains$default((CharSequence) str, (CharSequence) str2, false, 2, (Object) null)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String normalizeStationSearch(String value) {
        Locale ROOT = Locale.ROOT;
        Intrinsics.checkNotNullExpressionValue(ROOT, "ROOT");
        String lowerCase = value.toLowerCase(ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        for (Pair pair : CollectionsKt.listOf((Object[]) new Pair[]{TuplesKt.to("street", "st"), TuplesKt.to("avenue", "av"), TuplesKt.to("square", "sq"), TuplesKt.to("center", "ctr"), TuplesKt.to("road", "rd"), TuplesKt.to("boulevard", "blvd"), TuplesKt.to("parkway", "pkwy"), TuplesKt.to("highway", "hwy"), TuplesKt.to("junction", "jct"), TuplesKt.to("terminal", ""), TuplesKt.to("station", "")})) {
            String str = (String) pair.component1();
            lowerCase = new Regex("\\b" + Regex.INSTANCE.escape(str) + "\\b").replace(lowerCase, (String) pair.component2());
        }
        return normalizeSearch(lowerCase);
    }

    private final StaticIndex loadIndex(File file) throws IOException {
        GZIPInputStream gZIPInputStream = new GZIPInputStream(new FileInputStream(file));
        try {
            InputStreamReader inputStreamReader = new InputStreamReader(gZIPInputStream, Charsets.UTF_8);
            try {
                String text = TextStreamsKt.readText(inputStreamReader);
                CloseableKt.closeFinally(inputStreamReader, null);
                CloseableKt.closeFinally(gZIPInputStream, null);
                return fromJson(new JSONObject(text));
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    CloseableKt.closeFinally(inputStreamReader, th);
                    throw th2;
                }
            }
        } catch (Throwable th3) {
            try {
                throw th3;
            } catch (Throwable th4) {
                CloseableKt.closeFinally(gZIPInputStream, th3);
                throw th4;
            }
        }
    }

    private final void saveIndex(File file, StaticIndex index) throws IOException {
        File file2 = new File(file.getParentFile(), file.getName() + ".tmp");
        String string = toJson(index).toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        OutputStream fileOutputStream = new FileOutputStream(file2);
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(fileOutputStream instanceof BufferedOutputStream ? (BufferedOutputStream) fileOutputStream : new BufferedOutputStream(fileOutputStream, 8192));
        try {
            byte[] bytes = string.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
            gZIPOutputStream.write(bytes);
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(gZIPOutputStream, null);
            if (file.exists()) {
                file.delete();
            }
            file2.renameTo(file);
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                CloseableKt.closeFinally(gZIPOutputStream, th);
                throw th2;
            }
        }
    }

    private final JSONObject toJson(StaticIndex index) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        for (SubwayRouteInfo subwayRouteInfo : CollectionsKt.sortedWith(index.getRouteInfo().values(), new Comparator() { // from class: com.example.tickets.GlobalSubwayDataManager$toJson$$inlined$sortedBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(((GlobalSubwayDataManager.SubwayRouteInfo) t).getRouteId(), ((GlobalSubwayDataManager.SubwayRouteInfo) t2).getRouteId());
            }
        })) {
            jSONArray.put(new JSONObject().put("id", subwayRouteInfo.getRouteId()).put("short", subwayRouteInfo.getShortName()).put("long", subwayRouteInfo.getLongName()).put("color", subwayRouteInfo.getColor()));
        }
        jSONObject.put("routes", jSONArray);
        JSONArray jSONArray2 = new JSONArray();
        for (SubwayStationOption subwayStationOption : index.getStationsByKey().values()) {
            JSONObject jSONObjectPut = new JSONObject().put("key", subwayStationOption.getKey()).put(HintConstants.AUTOFILL_HINT_NAME, subwayStationOption.getName()).put("lat", subwayStationOption.getLatitude()).put("lon", subwayStationOption.getLongitude());
            List<SubwayRouteInfo> routes = subwayStationOption.getRoutes();
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(routes, 10));
            Iterator<T> it = routes.iterator();
            while (it.hasNext()) {
                arrayList.add(((SubwayRouteInfo) it.next()).getRouteId());
            }
            jSONArray2.put(jSONObjectPut.put("routes", new JSONArray((Collection) arrayList)).put("searchNames", new JSONArray((Collection) subwayStationOption.getSearchNames())));
        }
        jSONObject.put("stations", jSONArray2);
        JSONObject jSONObject2 = new JSONObject();
        for (Map.Entry<String, List<List<String>>> entry : index.getRoutePatterns().entrySet()) {
            String key = entry.getKey();
            List<List<String>> value = entry.getValue();
            JSONArray jSONArray3 = new JSONArray();
            Iterator it2 = CollectionsKt.take(value, 24).iterator();
            while (it2.hasNext()) {
                jSONArray3.put(new JSONArray((Collection) CollectionsKt.take((List) it2.next(), 220)));
            }
            jSONObject2.put(key, jSONArray3);
        }
        jSONObject.put("patterns", jSONObject2);
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:12:0x0068  */
    public final StaticIndex fromJson(JSONObject root) {
        String str;
        HashMap map;
        HashMap map2 = new HashMap();
        String str2 = "routes";
        JSONArray jSONArrayOptJSONArray = root.optJSONArray("routes");
        if (jSONArrayOptJSONArray != null) {
            int length = jSONArrayOptJSONArray.length();
            int i = 0;
            while (i < length) {
                JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject != null) {
                    String strOptString = jSONObjectOptJSONObject.optString("id");
                    Intrinsics.checkNotNullExpressionValue(strOptString, "optString(...)");
                    String string = StringsKt.trim((CharSequence) strOptString).toString();
                    if (!StringsKt.isBlank(string)) {
                        String strOptString2 = jSONObjectOptJSONObject.optString("short");
                        Intrinsics.checkNotNullExpressionValue(strOptString2, "optString(...)");
                        String strOptString3 = jSONObjectOptJSONObject.optString("long");
                        Intrinsics.checkNotNullExpressionValue(strOptString3, "optString(...)");
                        SubwayRouteInfo subwayRouteInfo = new SubwayRouteInfo(string, strOptString2, strOptString3, jSONObjectOptJSONObject.optInt("color", FALLBACK_ROUTE_COLOR));
                        map2.put(subwayRouteInfo.getRouteId(), subwayRouteInfo);
                    }
                }
                i++;
                jSONArrayOptJSONArray = jSONArrayOptJSONArray;
            }
        } else {
            JSONObject jSONObjectOptJSONObject2 = root.optJSONObject("routes");
            if (jSONObjectOptJSONObject2 != null) {
                Iterator<String> itKeys = jSONObjectOptJSONObject2.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    JSONObject jSONObjectOptJSONObject3 = jSONObjectOptJSONObject2.optJSONObject(next);
                    if (jSONObjectOptJSONObject3 != null) {
                        String strOptString4 = jSONObjectOptJSONObject3.optString("id");
                        Intrinsics.checkNotNullExpressionValue(strOptString4, "optString(...)");
                        String string2 = StringsKt.trim((CharSequence) strOptString4).toString();
                        if (StringsKt.isBlank(string2)) {
                            Intrinsics.checkNotNull(next);
                            string2 = StringsKt.trim((CharSequence) next).toString();
                        }
                        String str3 = string2;
                        if (!StringsKt.isBlank(str3)) {
                            String strOptString5 = jSONObjectOptJSONObject3.optString("short");
                            Intrinsics.checkNotNullExpressionValue(strOptString5, "optString(...)");
                            String strOptString6 = jSONObjectOptJSONObject3.optString("long");
                            Intrinsics.checkNotNullExpressionValue(strOptString6, "optString(...)");
                            SubwayRouteInfo subwayRouteInfo2 = new SubwayRouteInfo(str3, strOptString5, strOptString6, jSONObjectOptJSONObject3.optInt("color", FALLBACK_ROUTE_COLOR));
                            map2.put(subwayRouteInfo2.getRouteId(), subwayRouteInfo2);
                        }
                    }
                }
            }
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        HashMap map3 = new HashMap();
        JSONArray jSONArrayOptJSONArray2 = root.optJSONArray("stations");
        if (jSONArrayOptJSONArray2 == null) {
            jSONArrayOptJSONArray2 = new JSONArray();
        }
        int length2 = jSONArrayOptJSONArray2.length();
        int i2 = 0;
        while (i2 < length2) {
            JSONObject jSONObjectOptJSONObject4 = jSONArrayOptJSONArray2.optJSONObject(i2);
            if (jSONObjectOptJSONObject4 == null) {
                map = map2;
                str = str2;
            } else {
                String strOptString7 = jSONObjectOptJSONObject4.optString("key");
                JSONArray jSONArrayOptJSONArray3 = jSONObjectOptJSONObject4.optJSONArray(str2);
                if (jSONArrayOptJSONArray3 == null) {
                    jSONArrayOptJSONArray3 = new JSONArray();
                }
                List listCreateListBuilder = CollectionsKt.createListBuilder();
                JSONArray jSONArrayOptJSONArray4 = jSONObjectOptJSONObject4.optJSONArray("searchNames");
                if (jSONArrayOptJSONArray4 == null) {
                    jSONArrayOptJSONArray4 = new JSONArray();
                }
                int length3 = jSONArrayOptJSONArray4.length();
                int i3 = 0;
                while (i3 < length3) {
                    String strOptString8 = jSONArrayOptJSONArray4.optString(i3);
                    Intrinsics.checkNotNull(strOptString8);
                    if (StringsKt.isBlank(strOptString8)) {
                        strOptString8 = null;
                    }
                    String str4 = str2;
                    String str5 = strOptString8;
                    if (str5 != null) {
                        listCreateListBuilder.add(str5);
                    }
                    i3++;
                    str2 = str4;
                }
                str = str2;
                List listBuild = CollectionsKt.build(listCreateListBuilder);
                List listCreateListBuilder2 = CollectionsKt.createListBuilder();
                int length4 = jSONArrayOptJSONArray3.length();
                int i4 = 0;
                while (i4 < length4) {
                    SubwayRouteInfo subwayRouteInfo3 = (SubwayRouteInfo) map2.get(jSONArrayOptJSONArray3.optString(i4));
                    if (subwayRouteInfo3 == null) {
                        map2 = map2;
                    } else {
                        listCreateListBuilder2.add(subwayRouteInfo3);
                        HashMap map4 = map3;
                        Object obj = map4.get(strOptString7);
                        if (obj == null) {
                            LinkedHashSet linkedHashSet = new LinkedHashSet();
                            map4.put(strOptString7, linkedHashSet);
                            obj = linkedHashSet;
                        }
                        ((Set) obj).add(subwayRouteInfo3.getRouteId());
                    }
                    i4++;
                    map2 = map2;
                }
                map = map2;
                List listBuild2 = CollectionsKt.build(listCreateListBuilder2);
                Intrinsics.checkNotNull(strOptString7);
                String strOptString9 = jSONObjectOptJSONObject4.optString(HintConstants.AUTOFILL_HINT_NAME);
                Intrinsics.checkNotNullExpressionValue(strOptString9, "optString(...)");
                linkedHashMap.put(strOptString7, new SubwayStationOption(strOptString7, strOptString9, jSONObjectOptJSONObject4.optDouble("lat"), jSONObjectOptJSONObject4.optDouble("lon"), CollectionsKt.sortedWith(listBuild2, new Comparator() { // from class: com.example.tickets.GlobalSubwayDataManager$fromJson$$inlined$sortedBy$1
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // java.util.Comparator
                    public final int compare(T t, T t2) {
                        return ComparisonsKt.compareValues(((GlobalSubwayDataManager.SubwayRouteInfo) t).getShortName(), ((GlobalSubwayDataManager.SubwayRouteInfo) t2).getShortName());
                    }
                }), listBuild));
            }
            i2++;
            str2 = str;
            map2 = map;
        }
        HashMap map5 = map2;
        HashMap map6 = new HashMap();
        JSONObject jSONObjectOptJSONObject5 = root.optJSONObject("patterns");
        if (jSONObjectOptJSONObject5 == null) {
            jSONObjectOptJSONObject5 = new JSONObject();
        }
        Iterator<String> itKeys2 = jSONObjectOptJSONObject5.keys();
        while (itKeys2.hasNext()) {
            String next2 = itKeys2.next();
            JSONArray jSONArrayOptJSONArray5 = jSONObjectOptJSONObject5.optJSONArray(next2);
            if (jSONArrayOptJSONArray5 != null) {
                ArrayList arrayList = new ArrayList(jSONArrayOptJSONArray5.length());
                int length5 = jSONArrayOptJSONArray5.length();
                for (int i5 = 0; i5 < length5; i5++) {
                    JSONArray jSONArrayOptJSONArray6 = jSONArrayOptJSONArray5.optJSONArray(i5);
                    if (jSONArrayOptJSONArray6 != null) {
                        ArrayList arrayList2 = new ArrayList(jSONArrayOptJSONArray6.length());
                        int length6 = jSONArrayOptJSONArray6.length();
                        for (int i6 = 0; i6 < length6; i6++) {
                            arrayList2.add(jSONArrayOptJSONArray6.optString(i6));
                        }
                        if (arrayList2.size() >= 2) {
                            arrayList.add(arrayList2);
                        }
                    }
                }
                map6.put(next2, arrayList);
            }
        }
        LinkedHashMap linkedHashMap2 = linkedHashMap;
        HashMap map7 = map3;
        LinkedHashMap linkedHashMap3 = new LinkedHashMap(MapsKt.mapCapacity(map7.size()));
        for (Map.Entry entry : map7.entrySet()) {
            linkedHashMap3.put(entry.getKey(), CollectionsKt.toSet((Iterable) entry.getValue()));
        }
        return new StaticIndex(linkedHashMap2, linkedHashMap3, map6, map5);
    }

    private final String downloadText(String urlString) throws IOException {
        URLConnection uRLConnectionOpenConnection = new URL(urlString).openConnection();
        Intrinsics.checkNotNull(uRLConnectionOpenConnection, "null cannot be cast to non-null type java.net.HttpURLConnection");
        HttpURLConnection httpURLConnection = (HttpURLConnection) uRLConnectionOpenConnection;
        httpURLConnection.setRequestMethod("GET");
        httpURLConnection.setConnectTimeout(AccessibilityNodeInfoCompat.EXTRA_DATA_TEXT_CHARACTER_LOCATION_ARG_MAX_LENGTH);
        httpURLConnection.setReadTimeout(40000);
        httpURLConnection.setInstanceFollowRedirects(true);
        httpURLConnection.setRequestProperty("User-Agent", "Tickets/6.0 SubwayData");
        try {
            int responseCode = httpURLConnection.getResponseCode();
            if (200 > responseCode || responseCode >= 300) {
                throw new IllegalStateException("HTTP " + httpURLConnection.getResponseCode() + ": " + urlString);
            }
            InputStream inputStream = httpURLConnection.getInputStream();
            Intrinsics.checkNotNullExpressionValue(inputStream, "getInputStream(...)");
            Reader inputStreamReader = new InputStreamReader(inputStream, Charsets.UTF_8);
            BufferedReader bufferedReader = inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, 8192);
            try {
                String text = TextStreamsKt.readText(bufferedReader);
                CloseableKt.closeFinally(bufferedReader, null);
                httpURLConnection.disconnect();
                return text;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    CloseableKt.closeFinally(bufferedReader, th);
                    throw th2;
                }
            }
        } catch (Throwable th3) {
            httpURLConnection.disconnect();
            throw th3;
        }
    }

    static /* synthetic */ int routeColor$default(GlobalSubwayDataManager globalSubwayDataManager, String str, String str2, String str3, int i, Integer num, int i2, Object obj) {
        if ((i2 & 16) != 0) {
            num = null;
        }
        return globalSubwayDataManager.routeColor(str, str2, str3, i, num);
    }

    private final int routeColor(String cityId, String shortName, String routeCode, int seed, Integer sourceColor) {
        Integer numColorFor = SubwayLineColorRepository.INSTANCE.colorFor(cityId, shortName, routeCode, cityName(cityId));
        if (numColorFor != null) {
            return numColorFor.intValue();
        }
        Integer numColorFor2 = OfficialSubwayLineColorRepository.INSTANCE.colorFor(cityId, shortName, routeCode);
        if (numColorFor2 != null) {
            return numColorFor2.intValue();
        }
        return sourceColor != null ? sourceColor.intValue() : FALLBACK_ROUTE_COLOR;
    }

    private final int canonicalLineColor(String cityId, String shortName, String routeId, int sourceColor) {
        return routeColor(cityId, shortName, routeId, 0, Integer.valueOf(sourceColor));
    }

    private final StaticIndex applyCanonicalLineColors(String cityId, StaticIndex index) {
        Map<String, SubwayRouteInfo> routeInfo = index.getRouteInfo();
        LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(routeInfo.size()));
        Iterator<T> it = routeInfo.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Object key = entry.getKey();
            SubwayRouteInfo subwayRouteInfo = (SubwayRouteInfo) entry.getValue();
            linkedHashMap.put(key, SubwayRouteInfo.copy$default(subwayRouteInfo, null, null, null, INSTANCE.canonicalLineColor(cityId, subwayRouteInfo.getShortName(), subwayRouteInfo.getRouteId(), subwayRouteInfo.getColor()), 7, null));
        }
        Map<String, SubwayStationOption> stationsByKey = index.getStationsByKey();
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(MapsKt.mapCapacity(stationsByKey.size()));
        Iterator<T> it2 = stationsByKey.entrySet().iterator();
        while (it2.hasNext()) {
            Map.Entry entry2 = (Map.Entry) it2.next();
            Object key2 = entry2.getKey();
            SubwayStationOption subwayStationOption = (SubwayStationOption) entry2.getValue();
            List<SubwayRouteInfo> routes = subwayStationOption.getRoutes();
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(routes, 10));
            for (SubwayRouteInfo subwayRouteInfo2 : routes) {
                SubwayRouteInfo subwayRouteInfo3 = (SubwayRouteInfo) linkedHashMap.get(subwayRouteInfo2.getRouteId());
                if (subwayRouteInfo3 != null) {
                    subwayRouteInfo2 = subwayRouteInfo3;
                }
                arrayList.add(subwayRouteInfo2);
            }
            linkedHashMap2.put(key2, SubwayStationOption.copy$default(subwayStationOption, null, null, AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, arrayList, null, 47, null));
        }
        return StaticIndex.copy$default(index, linkedHashMap2, null, null, linkedHashMap, 6, null);
    }

    private final StaticIndex normalizeStaticIndexTopology(StaticIndex index) {
        Set<String> setKeySet = index.getRouteInfo().keySet();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        for (Map.Entry<String, List<List<String>>> entry : index.getRoutePatterns().entrySet()) {
            String key = entry.getKey();
            List<List<String>> value = entry.getValue();
            if (setKeySet.contains(key)) {
                ArrayList arrayList = new ArrayList();
                Iterator<T> it = value.iterator();
                while (it.hasNext()) {
                    List list = (List) it.next();
                    ArrayList<String> arrayList2 = new ArrayList();
                    for (Object obj : list) {
                        if (index.getStationsByKey().containsKey((String) obj)) {
                            arrayList2.add(obj);
                        }
                    }
                    ArrayList arrayList3 = new ArrayList();
                    for (String str : arrayList2) {
                        if (!Intrinsics.areEqual(CollectionsKt.lastOrNull((List) arrayList3), str)) {
                            arrayList3.add(str);
                        }
                    }
                    if (arrayList3.size() < 2) {
                        arrayList3 = null;
                    }
                    if (arrayList3 != null) {
                        arrayList.add(arrayList3);
                    }
                }
                List listDistinct = CollectionsKt.distinct(arrayList);
                if (!listDistinct.isEmpty()) {
                    linkedHashMap.put(key, listDistinct);
                    Iterator it2 = listDistinct.iterator();
                    while (it2.hasNext()) {
                        for (String str2 : (ArrayList) it2.next()) {
                            LinkedHashMap linkedHashMap3 = linkedHashMap2;
                            Object obj2 = linkedHashMap3.get(str2);
                            if (obj2 == null) {
                                obj2 = (Set) new LinkedHashSet();
                                linkedHashMap3.put(str2, obj2);
                            }
                            ((Set) obj2).add(key);
                        }
                    }
                }
            }
        }
        LinkedHashMap linkedHashMap4 = linkedHashMap2;
        LinkedHashMap linkedHashMap5 = new LinkedHashMap(MapsKt.mapCapacity(linkedHashMap4.size()));
        for (Map.Entry entry2 : linkedHashMap4.entrySet()) {
            linkedHashMap5.put(entry2.getKey(), CollectionsKt.toSet((Set) entry2.getValue()));
        }
        Map<String, SubwayStationOption> stationsByKey = index.getStationsByKey();
        LinkedHashMap linkedHashMap6 = new LinkedHashMap(MapsKt.mapCapacity(stationsByKey.size()));
        Iterator<T> it3 = stationsByKey.entrySet().iterator();
        while (it3.hasNext()) {
            Map.Entry entry3 = (Map.Entry) it3.next();
            Object key2 = entry3.getKey();
            String str3 = (String) entry3.getKey();
            SubwayStationOption subwayStationOption = (SubwayStationOption) entry3.getValue();
            Set setEmptySet = (Set) linkedHashMap5.get(str3);
            if (setEmptySet == null) {
                setEmptySet = SetsKt.emptySet();
            }
            ArrayList arrayList4 = new ArrayList();
            Iterator it4 = setEmptySet.iterator();
            while (it4.hasNext()) {
                SubwayRouteInfo subwayRouteInfo = index.getRouteInfo().get((String) it4.next());
                if (subwayRouteInfo != null) {
                    arrayList4.add(subwayRouteInfo);
                }
            }
            HashSet hashSet = new HashSet();
            ArrayList arrayList5 = new ArrayList();
            for (Object obj3 : arrayList4) {
                if (hashSet.add(((SubwayRouteInfo) obj3).getRouteId())) {
                    arrayList5.add(obj3);
                }
            }
            linkedHashMap6.put(key2, SubwayStationOption.copy$default(subwayStationOption, null, null, AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, CollectionsKt.sortedWith(arrayList5, new Comparator() { // from class: com.example.tickets.GlobalSubwayDataManager$normalizeStaticIndexTopology$lambda$195$$inlined$sortedBy$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    return ComparisonsKt.compareValues(((GlobalSubwayDataManager.SubwayRouteInfo) t).getShortName(), ((GlobalSubwayDataManager.SubwayRouteInfo) t2).getShortName());
                }
            }), null, 47, null));
        }
        return StaticIndex.copy$default(index, linkedHashMap6, linkedHashMap5, linkedHashMap, null, 8, null);
    }

    private final StaticIndex sanitizeWuhanRouteTopology(String cityId, StaticIndex index) {
        Set set;
        LinkedHashMap linkedHashMap;
        String str;
        Object next;
        String str2;
        StaticIndex staticIndex = index;
        if (Intrinsics.areEqual(cityId, "wuhan")) {
            Collection<SubwayRouteInfo> collectionValues = staticIndex.getRouteInfo().values();
            ArrayList arrayList = new ArrayList();
            for (Object obj : collectionValues) {
                if (Intrinsics.areEqual(INSTANCE.normalizeLineName(((SubwayRouteInfo) obj).getShortName()), "12")) {
                    arrayList.add(obj);
                }
            }
            ArrayList arrayList2 = arrayList;
            ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                arrayList3.add(((SubwayRouteInfo) it.next()).getRouteId());
            }
            Set set2 = CollectionsKt.toSet(arrayList3);
            if (!set2.isEmpty()) {
                Collection<SubwayRouteInfo> collectionValues2 = staticIndex.getRouteInfo().values();
                LinkedHashMap linkedHashMap2 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(collectionValues2, 10)), 16));
                for (SubwayRouteInfo subwayRouteInfo : collectionValues2) {
                    linkedHashMap2.put(INSTANCE.normalizeLineName(subwayRouteInfo.getShortName()), subwayRouteInfo.getRouteId());
                }
                String str3 = (String) linkedHashMap2.get(ExifInterface.GPS_MEASUREMENT_2D);
                String str4 = (String) linkedHashMap2.get(ExifInterface.GPS_MEASUREMENT_3D);
                String str5 = (String) linkedHashMap2.get("8");
                Set of = SetsKt.setOf((Object[]) new String[]{"钢都花园", "园林路", "团结大道", "汪家墩", "秦园中路", "公正路", "何家垅", "十五中", "武昌站东广场", "瑞安街东", "富安街", "楚祥大道", "省农科院南", "光霞", "市农科院", "夹套河", "国博中心南", "国博新城", "四新南路", "四新中路", "芳草路", "港口村", "墨水湖公园"});
                ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(of, 10));
                Iterator it2 = of.iterator();
                while (it2.hasNext()) {
                    arrayList4.add(sanitizeWuhanRouteTopology$normalizeWuhanStation((String) it2.next()));
                }
                Set set3 = CollectionsKt.toSet(arrayList4);
                Collection<SubwayStationOption> collectionValues3 = staticIndex.getStationsByKey().values();
                ArrayList arrayList5 = new ArrayList();
                for (Object obj2 : collectionValues3) {
                    if (set3.contains(sanitizeWuhanRouteTopology$normalizeWuhanStation(((SubwayStationOption) obj2).getName()))) {
                        arrayList5.add(obj2);
                    }
                }
                ArrayList arrayList6 = arrayList5;
                ArrayList arrayList7 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList6, 10));
                Iterator it3 = arrayList6.iterator();
                while (it3.hasNext()) {
                    arrayList7.add(((SubwayStationOption) it3.next()).getKey());
                }
                Set set4 = CollectionsKt.toSet(arrayList7);
                Collection<SubwayStationOption> collectionValues4 = staticIndex.getStationsByKey().values();
                ArrayList arrayList8 = new ArrayList();
                for (Object obj3 : collectionValues4) {
                    if (Intrinsics.areEqual(sanitizeWuhanRouteTopology$normalizeWuhanStation(((SubwayStationOption) obj3).getName()), sanitizeWuhanRouteTopology$normalizeWuhanStation("宏图大道"))) {
                        arrayList8.add(obj3);
                    }
                }
                ArrayList arrayList9 = arrayList8;
                ArrayList arrayList10 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList9, 10));
                Iterator it4 = arrayList9.iterator();
                while (it4.hasNext()) {
                    arrayList10.add(((SubwayStationOption) it4.next()).getKey());
                }
                Set set5 = CollectionsKt.toSet(arrayList10);
                Map<String, SubwayStationOption> stationsByKey = staticIndex.getStationsByKey();
                LinkedHashMap linkedHashMap3 = new LinkedHashMap(MapsKt.mapCapacity(stationsByKey.size()));
                Iterator<T> it5 = stationsByKey.entrySet().iterator();
                while (it5.hasNext()) {
                    Map.Entry entry = (Map.Entry) it5.next();
                    Object key = entry.getKey();
                    String str6 = (String) entry.getKey();
                    SubwayStationOption subwayStationOptionCopy$default = (SubwayStationOption) entry.getValue();
                    if (set5.contains(str6)) {
                        SubwayRouteInfo[] subwayRouteInfoArr = new SubwayRouteInfo[3];
                        subwayRouteInfoArr[0] = str3 != null ? staticIndex.getRouteInfo().get(str3) : null;
                        subwayRouteInfoArr[1] = str4 != null ? staticIndex.getRouteInfo().get(str4) : null;
                        subwayRouteInfoArr[2] = str5 != null ? staticIndex.getRouteInfo().get(str5) : null;
                        List listListOfNotNull = CollectionsKt.listOfNotNull((Object[]) subwayRouteInfoArr);
                        HashSet hashSet = new HashSet();
                        ArrayList arrayList11 = new ArrayList();
                        for (Object obj4 : listListOfNotNull) {
                            if (hashSet.add(((SubwayRouteInfo) obj4).getRouteId())) {
                                arrayList11.add(obj4);
                            }
                        }
                        subwayStationOptionCopy$default = SubwayStationOption.copy$default(subwayStationOptionCopy$default, null, null, AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, arrayList11, null, 47, null);
                    } else {
                        List<SubwayRouteInfo> routes = subwayStationOptionCopy$default.getRoutes();
                        if (!(routes instanceof Collection) || !routes.isEmpty()) {
                            Iterator<T> it6 = routes.iterator();
                            while (it6.hasNext()) {
                                if (set2.contains(((SubwayRouteInfo) it6.next()).getRouteId())) {
                                    if (!set3.contains(sanitizeWuhanRouteTopology$normalizeWuhanStation(subwayStationOptionCopy$default.getName()))) {
                                        List<SubwayRouteInfo> routes2 = subwayStationOptionCopy$default.getRoutes();
                                        ArrayList arrayList12 = new ArrayList();
                                        for (Object obj5 : routes2) {
                                            if (!set2.contains(((SubwayRouteInfo) obj5).getRouteId())) {
                                                arrayList12.add(obj5);
                                            }
                                        }
                                        subwayStationOptionCopy$default = SubwayStationOption.copy$default(subwayStationOptionCopy$default, null, null, AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, CollectionsKt.sortedWith(arrayList12, new Comparator() { // from class: com.example.tickets.GlobalSubwayDataManager$sanitizeWuhanRouteTopology$lambda$211$$inlined$sortedBy$1
                                            /* JADX WARN: Multi-variable type inference failed */
                                            @Override // java.util.Comparator
                                            public final int compare(T t, T t2) {
                                                return ComparisonsKt.compareValues(((GlobalSubwayDataManager.SubwayRouteInfo) t).getShortName(), ((GlobalSubwayDataManager.SubwayRouteInfo) t2).getShortName());
                                            }
                                        }), null, 47, null);
                                        break;
                                    }
                                    break;
                                }
                            }
                        }
                    }
                    linkedHashMap3.put(key, subwayStationOptionCopy$default);
                }
                Map<String, Set<String>> routeByStation = staticIndex.getRouteByStation();
                LinkedHashMap linkedHashMap4 = new LinkedHashMap(MapsKt.mapCapacity(routeByStation.size()));
                Iterator<T> it7 = routeByStation.entrySet().iterator();
                while (it7.hasNext()) {
                    Map.Entry entry2 = (Map.Entry) it7.next();
                    Object key2 = entry2.getKey();
                    String str7 = (String) entry2.getKey();
                    Set set6 = (Set) entry2.getValue();
                    if (set5.contains(str7)) {
                        set6 = SetsKt.setOfNotNull((Object[]) new String[]{str3, str4, str5});
                    } else if (!set4.contains(str7)) {
                        ArrayList arrayList13 = new ArrayList();
                        for (Object obj6 : set6) {
                            if (!set2.contains((String) obj6)) {
                                arrayList13.add(obj6);
                            }
                        }
                        set6 = CollectionsKt.toSet(arrayList13);
                    }
                    linkedHashMap4.put(key2, set6);
                }
                LinkedHashMap linkedHashMap5 = new LinkedHashMap();
                for (Map.Entry<String, List<List<String>>> entry3 : staticIndex.getRoutePatterns().entrySet()) {
                    String key3 = entry3.getKey();
                    List<List<String>> value = entry3.getValue();
                    if (!set2.contains(key3)) {
                        set = set2;
                        linkedHashMap = linkedHashMap5;
                        if (Intrinsics.areEqual(key3, str3) && !set5.isEmpty()) {
                            Set set7 = set5;
                            Iterator it8 = set7.iterator();
                            while (true) {
                                if (!it8.hasNext()) {
                                    next = null;
                                    break;
                                }
                                next = it8.next();
                                Set<String> setEmptySet = staticIndex.getRouteByStation().get((String) next);
                                if (setEmptySet == null) {
                                    setEmptySet = SetsKt.emptySet();
                                }
                                Set<String> set8 = setEmptySet;
                                if (!(set8 instanceof Collection) || !set8.isEmpty()) {
                                    for (String str8 : set8) {
                                        if (Intrinsics.areEqual(str8, str4) || Intrinsics.areEqual(str8, str5)) {
                                            break;
                                        }
                                    }
                                }
                            }
                            String str9 = (String) next;
                            if (str9 == null) {
                                str9 = (String) CollectionsKt.first(set7);
                            }
                            List<List<String>> list = value;
                            ArrayList arrayList14 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                            Iterator<T> it9 = list.iterator();
                            while (it9.hasNext()) {
                                List mutableList = (List) it9.next();
                                if (mutableList.contains(str9)) {
                                    str2 = str3;
                                } else {
                                    mutableList = CollectionsKt.toMutableList((Collection) mutableList);
                                    Iterator it10 = mutableList.iterator();
                                    int i = 0;
                                    while (true) {
                                        if (!it10.hasNext()) {
                                            str2 = str3;
                                            i = -1;
                                            break;
                                        }
                                        SubwayStationOption subwayStationOptionStationOption = staticIndex.stationOption((String) it10.next());
                                        String name = subwayStationOptionStationOption != null ? subwayStationOptionStationOption.getName() : null;
                                        if (name == null) {
                                            name = "";
                                        }
                                        str2 = str3;
                                        if (Intrinsics.areEqual(sanitizeWuhanRouteTopology$normalizeWuhanStation(name), sanitizeWuhanRouteTopology$normalizeWuhanStation("常青花园"))) {
                                            break;
                                        }
                                        i++;
                                        str3 = str2;
                                    }
                                    Iterator it11 = mutableList.iterator();
                                    int i2 = 0;
                                    while (true) {
                                        if (!it11.hasNext()) {
                                            i2 = -1;
                                            break;
                                        }
                                        SubwayStationOption subwayStationOptionStationOption2 = staticIndex.stationOption((String) it11.next());
                                        String name2 = subwayStationOptionStationOption2 != null ? subwayStationOptionStationOption2.getName() : null;
                                        if (name2 == null) {
                                            name2 = "";
                                        }
                                        if (Intrinsics.areEqual(sanitizeWuhanRouteTopology$normalizeWuhanStation(name2), sanitizeWuhanRouteTopology$normalizeWuhanStation("巨龙大道"))) {
                                            break;
                                        }
                                        i2++;
                                        staticIndex = index;
                                    }
                                    if (i >= 0) {
                                        mutableList.add(i + 1, str9);
                                        Unit unit = Unit.INSTANCE;
                                    } else if (i2 > 0) {
                                        mutableList.add(i2, str9);
                                        Unit unit2 = Unit.INSTANCE;
                                    }
                                }
                                arrayList14.add(mutableList);
                                staticIndex = index;
                                str3 = str2;
                            }
                            str = str3;
                            linkedHashMap.put(key3, CollectionsKt.distinct(arrayList14));
                        } else {
                            str = str3;
                            linkedHashMap.put(key3, value);
                        }
                    } else {
                        ArrayList arrayList15 = new ArrayList();
                        Iterator<T> it12 = value.iterator();
                        while (it12.hasNext()) {
                            List list2 = (List) it12.next();
                            ArrayList<String> arrayList16 = new ArrayList();
                            for (Object obj7 : list2) {
                                Set set9 = set2;
                                LinkedHashMap linkedHashMap6 = linkedHashMap5;
                                if (set4.contains((String) obj7)) {
                                    arrayList16.add(obj7);
                                }
                                set2 = set9;
                                linkedHashMap5 = linkedHashMap6;
                            }
                            Set set10 = set2;
                            LinkedHashMap linkedHashMap7 = linkedHashMap5;
                            ArrayList arrayList17 = new ArrayList();
                            for (String str10 : arrayList16) {
                                if (!Intrinsics.areEqual(CollectionsKt.lastOrNull((List) arrayList17), str10)) {
                                    arrayList17.add(str10);
                                }
                            }
                            if (arrayList17.size() < 2) {
                                arrayList17 = null;
                            }
                            if (arrayList17 != null) {
                                arrayList15.add(arrayList17);
                            }
                            set2 = set10;
                            linkedHashMap5 = linkedHashMap7;
                        }
                        set = set2;
                        linkedHashMap = linkedHashMap5;
                        List listDistinct = CollectionsKt.distinct(arrayList15);
                        if (!listDistinct.isEmpty()) {
                            linkedHashMap.put(key3, listDistinct);
                        }
                        str = str3;
                    }
                    staticIndex = index;
                    set2 = set;
                    linkedHashMap5 = linkedHashMap;
                    str3 = str;
                }
                return normalizeStaticIndexTopology(StaticIndex.copy$default(index, linkedHashMap3, linkedHashMap4, linkedHashMap5, null, 8, null));
            }
        }
        return staticIndex;
    }

    private static final String sanitizeWuhanRouteTopology$normalizeWuhanStation(String str) {
        return StringsKt.removeSuffix(StringsKt.removeSuffix(StringsKt.removePrefix(INSTANCE.normalizeSearch(str), (CharSequence) "武汉"), (CharSequence) "地铁站"), (CharSequence) "站");
    }

    private final String extractNumericLine(String value) {
        List<String> groupValues;
        String str = null;
        MatchResult matchResultFind$default = Regex.find$default(new Regex("(\\d{1,2})"), value, 0, 2, null);
        if (matchResultFind$default != null && (groupValues = matchResultFind$default.getGroupValues()) != null) {
            str = (String) CollectionsKt.getOrNull(groupValues, 1);
        }
        return str == null ? "" : str;
    }

    private final int stableHash(String value) {
        String str = value;
        int iCharAt = 7;
        for (int i = 0; i < str.length(); i++) {
            iCharAt = (iCharAt * 31) + str.charAt(i);
        }
        return absoluteValue(iCharAt);
    }

    private final int absoluteValue(int i) {
        if (i == Integer.MIN_VALUE) {
            return Integer.MAX_VALUE;
        }
        return Math.abs(i);
    }

    private final String normalizeLineName(String value) {
        String string = StringsKt.trim((CharSequence) StringsKt.replace(StringsKt.replace(StringsKt.replace(StringsKt.replace(StringsKt.replace(value, "地铁", "", true), "号线", "", true), "线路", "", true), "Line", "", true), "LINE", "", true)).toString();
        return StringsKt.isBlank(string) ? StringsKt.trim((CharSequence) value).toString() : string;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String normalizeSearch(String value) {
        Locale ROOT = Locale.ROOT;
        Intrinsics.checkNotNullExpressionValue(ROOT, "ROOT");
        String lowerCase = value.toLowerCase(ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        return new Regex("[\\s\\p{Punct}·•]+").replace(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(lowerCase, "–", "-", false, 4, (Object) null), "—", "-", false, 4, (Object) null), "－", "-", false, 4, (Object) null), "");
    }

    private final Pair<Double, Double> parseCoordinatePair(String raw) {
        Double doubleOrNull;
        List listSplit$default = StringsKt.split$default((CharSequence) raw, new char[]{','}, false, 0, 6, (Object) null);
        if (listSplit$default.size() >= 2 && (doubleOrNull = StringsKt.toDoubleOrNull(StringsKt.trim((CharSequence) listSplit$default.get(0)).toString())) != null) {
            double dDoubleValue = doubleOrNull.doubleValue();
            Double doubleOrNull2 = StringsKt.toDoubleOrNull(StringsKt.trim((CharSequence) listSplit$default.get(1)).toString());
            if (doubleOrNull2 != null) {
                double dDoubleValue2 = doubleOrNull2.doubleValue();
                if (-180.0d <= dDoubleValue && dDoubleValue <= 180.0d && -90.0d <= dDoubleValue2 && dDoubleValue2 <= 90.0d) {
                    return new Pair<>(doubleOrNull2, doubleOrNull);
                }
                if (-90.0d <= dDoubleValue && dDoubleValue <= 90.0d && -180.0d <= dDoubleValue2 && dDoubleValue2 <= 180.0d) {
                    return new Pair<>(doubleOrNull, doubleOrNull2);
                }
            }
        }
        return null;
    }

    private final double distanceMeters(double lat1, double lon1, double lat2, double lon2) {
        double radians = Math.toRadians(lat2 - lat1);
        double d = radians / 2.0d;
        double radians2 = Math.toRadians(lon2 - lon1) / 2.0d;
        double dSin = (Math.sin(d) * Math.sin(d)) + (Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) * Math.sin(radians2) * Math.sin(radians2));
        return 1.2742E7d * Math.atan2(Math.sqrt(dSin), Math.sqrt(Math.max(AudioStats.AUDIO_AMPLITUDE_NONE, 1.0d - dSin)));
    }

    private final void addUniqueRouteStation(List<SubwayRouteStation> list, SubwayRouteStation station) {
        SubwayRouteStation subwayRouteStationPrevious;
        GlobalSubwayDataManager globalSubwayDataManager;
        ListIterator<SubwayRouteStation> listIterator = list.listIterator(list.size());
        do {
            if (!listIterator.hasPrevious()) {
                subwayRouteStationPrevious = null;
                break;
            } else {
                subwayRouteStationPrevious = listIterator.previous();
                globalSubwayDataManager = INSTANCE;
            }
        } while (!Intrinsics.areEqual(globalSubwayDataManager.normalizeSearch(subwayRouteStationPrevious.getName()), globalSubwayDataManager.normalizeSearch(station.getName())));
        if (subwayRouteStationPrevious == null) {
            list.add(station);
        }
    }

    private final String firstNonBlank(String... values) {
        String str;
        int length = values.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                str = null;
                break;
            }
            str = values[i];
            if (!StringsKt.isBlank(str)) {
                break;
            }
            i++;
        }
        String string = str != null ? StringsKt.trim((CharSequence) str).toString() : null;
        return string == null ? "" : string;
    }
}
