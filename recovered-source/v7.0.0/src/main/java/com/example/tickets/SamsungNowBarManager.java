package com.example.tickets;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.RemoteViews;
import androidx.compose.material3.internal.CalendarModelKt;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.IconCompat;
import androidx.core.location.LocationRequestCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.CoroutineLiveDataKt;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import com.google.android.gms.common.internal.BaseGmsClient;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: SamsungNowBarManager.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000®\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u000200H\u0002J\u0006\u0010K\u001a\u00020.J\u000e\u0010L\u001a\u00020\b2\u0006\u0010M\u001a\u00020\bJ\u0010\u0010N\u001a\u00020.2\u0006\u0010O\u001a\u00020PH\u0002J\u000e\u0010Q\u001a\u00020R2\u0006\u0010O\u001a\u00020PJ\u000e\u0010S\u001a\u00020.2\u0006\u0010O\u001a\u00020PJ\u0010\u0010T\u001a\u00020R2\u0006\u0010O\u001a\u00020PH\u0002J\u001d\u0010U\u001a\u00020R2\u0006\u0010O\u001a\u00020P2\u0006\u0010V\u001a\u00020WH\u0000¢\u0006\u0002\bXJ\u0010\u0010Y\u001a\u00020.2\u0006\u0010/\u001a\u000200H\u0002J\u0018\u0010Z\u001a\u00020R2\u0006\u0010O\u001a\u00020P2\u0006\u0010V\u001a\u00020WH\u0002J\u0010\u0010[\u001a\u00020R2\u0006\u0010M\u001a\u00020\bH\u0002J\u0018\u0010\\\u001a\u00020R2\u0006\u0010O\u001a\u00020P2\u0006\u0010M\u001a\u00020\bH\u0002J*\u0010]\u001a\u00020^2\u0006\u0010O\u001a\u00020P2\u0006\u0010M\u001a\u00020\b2\u0006\u0010_\u001a\u00020\b2\b\u0010`\u001a\u0004\u0018\u00010aH\u0002J \u0010b\u001a\u00020R2\u0006\u0010O\u001a\u00020P2\u0006\u0010c\u001a\u00020d2\u0006\u0010e\u001a\u00020^H\u0002J(\u0010f\u001a\u00020R2\u0006\u0010O\u001a\u00020P2\u0006\u0010V\u001a\u00020W2\u0006\u0010_\u001a\u00020\b2\u0006\u0010c\u001a\u00020dH\u0002J\u0018\u0010g\u001a\u00020R2\u0006\u0010O\u001a\u00020P2\u0006\u0010V\u001a\u00020WH\u0002J\u001d\u0010h\u001a\u00020R2\u0006\u0010O\u001a\u00020P2\u0006\u0010V\u001a\u00020WH\u0000¢\u0006\u0002\biJ*\u0010j\u001a\u00020k2\u0006\u0010O\u001a\u00020P2\u0006\u0010l\u001a\u00020m2\u0006\u0010V\u001a\u00020W2\b\b\u0002\u0010n\u001a\u00020.H\u0002J \u0010o\u001a\u00020\u00052\u0006\u0010p\u001a\u00020k2\u0006\u0010l\u001a\u00020m2\u0006\u0010V\u001a\u00020WH\u0002J.\u0010q\u001a\b\u0012\u0004\u0012\u00020\u00050r2\u0006\u0010O\u001a\u00020P2\u0006\u0010l\u001a\u00020m2\u0006\u0010V\u001a\u00020W2\u0006\u0010p\u001a\u00020kH\u0002J\u0010\u0010s\u001a\u00020\b2\u0006\u0010l\u001a\u00020mH\u0002J\u001c\u0010t\u001a\u000e\u0012\u0004\u0012\u00020d\u0012\u0004\u0012\u00020d0u2\u0006\u0010l\u001a\u00020mH\u0002J\u0010\u0010v\u001a\u00020\b2\u0006\u0010w\u001a\u00020\u0005H\u0002J*\u0010x\u001a\u00020y2\u0006\u0010O\u001a\u00020P2\u0006\u0010l\u001a\u00020m2\u0006\u0010z\u001a\u00020\b2\b\b\u0002\u0010{\u001a\u00020.H\u0002J\u0018\u0010|\u001a\u00020\b2\u0006\u0010O\u001a\u00020P2\u0006\u0010l\u001a\u00020mH\u0002J \u0010}\u001a\u00020\b2\u0006\u0010O\u001a\u00020P2\u0006\u0010l\u001a\u00020m2\u0006\u0010~\u001a\u00020\bH\u0002J\u0019\u0010\u007f\u001a\u00030\u0080\u00012\u0006\u0010O\u001a\u00020P2\u0006\u0010z\u001a\u00020\bH\u0002J\u0011\u0010\u0081\u0001\u001a\u00020\b2\u0006\u0010l\u001a\u00020mH\u0002J\u0019\u0010\u0082\u0001\u001a\u00020^2\u0006\u0010O\u001a\u00020P2\u0006\u0010M\u001a\u00020\bH\u0002J\u0011\u0010\u0083\u0001\u001a\u00020\u00052\u0006\u0010/\u001a\u000200H\u0002J\"\u0010\u0084\u0001\u001a\u00020R2\u0006\u0010O\u001a\u00020P2\t\u0010\u0085\u0001\u001a\u0004\u0018\u00010aH\u0000¢\u0006\u0003\b\u0086\u0001J \u0010\u0087\u0001\u001a\u00020R2\u0006\u0010O\u001a\u00020P2\u0007\u0010\u0085\u0001\u001a\u00020aH\u0000¢\u0006\u0003\b\u0088\u0001J\u0017\u0010\u0089\u0001\u001a\u00020R2\u0006\u0010O\u001a\u00020P2\u0006\u0010M\u001a\u00020\bJ&\u0010\u008a\u0001\u001a\u00020R2\u0006\u0010O\u001a\u00020P2\r\u0010\u008b\u0001\u001a\b\u0012\u0004\u0012\u00020W0rH\u0000¢\u0006\u0003\b\u008c\u0001J\u0013\u0010\u008d\u0001\u001a\u00020.2\b\u0010\u008e\u0001\u001a\u00030\u008f\u0001H\u0002J\u0013\u0010\u0090\u0001\u001a\u00020\u00052\b\u0010\u008e\u0001\u001a\u00030\u008f\u0001H\u0002J\u0013\u0010\u0091\u0001\u001a\u00020\b2\b\u0010\u008e\u0001\u001a\u00030\u008f\u0001H\u0002J\u001b\u0010\u0092\u0001\u001a\u00020.2\u0007\u0010\u0093\u0001\u001a\u00020\u00052\u0007\u0010\u0094\u0001\u001a\u00020\u0005H\u0002J\u0013\u0010\u0095\u0001\u001a\u00020.2\b\u0010\u008e\u0001\u001a\u00030\u008f\u0001H\u0002J\u0013\u0010\u0096\u0001\u001a\u00020\u00052\b\u0010\u008e\u0001\u001a\u00030\u008f\u0001H\u0002J\u0013\u0010\u0097\u0001\u001a\u00020\u00052\b\u0010\u008e\u0001\u001a\u00030\u008f\u0001H\u0002J\u0013\u0010\u0098\u0001\u001a\u00020\u00052\b\u0010\u008e\u0001\u001a\u00030\u008f\u0001H\u0002J\u0012\u0010\u0099\u0001\u001a\u00020\u00052\u0007\u0010\u009a\u0001\u001a\u00020\u0005H\u0002J\u0012\u0010\u009b\u0001\u001a\u00020\u00052\u0007\u0010\u009a\u0001\u001a\u00020\u0005H\u0002J\u0012\u0010\u009c\u0001\u001a\u00020\b2\u0007\u0010\u009d\u0001\u001a\u00020\bH\u0002J\u001f\u0010\u009e\u0001\u001a\u00030\u009f\u00012\b\u0010\u008e\u0001\u001a\u00030\u008f\u00012\t\b\u0002\u0010 \u0001\u001a\u00020\bH\u0002J*\u0010¡\u0001\u001a\u00030\u009f\u00012\b\u0010\u008e\u0001\u001a\u00030\u008f\u00012\t\b\u0002\u0010¢\u0001\u001a\u00020\b2\t\b\u0002\u0010£\u0001\u001a\u00020\bH\u0002J!\u0010¤\u0001\u001a\u00020.2\u0006\u0010O\u001a\u00020P2\b\u0010\u008e\u0001\u001a\u00030\u008f\u0001H\u0000¢\u0006\u0003\b¥\u0001J\u0012\u0010¦\u0001\u001a\u00020\u00052\u0007\u0010§\u0001\u001a\u00020\u0005H\u0002J\u0012\u0010¨\u0001\u001a\u00020\u00052\u0007\u0010©\u0001\u001a\u00020\u0005H\u0002J\u001c\u0010ª\u0001\u001a\u00030«\u00012\u0007\u0010©\u0001\u001a\u00020\u00052\u0007\u0010¬\u0001\u001a\u00020.H\u0002J\u0017\u0010\u00ad\u0001\u001a\u00020R2\u0006\u0010O\u001a\u00020PH\u0000¢\u0006\u0003\b®\u0001R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020)X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010*\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020,0+X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010@\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010A\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010B\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010C\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010D\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010E\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010F\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010G\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010H\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010I\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010J\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006¯\u0001"}, d2 = {"Lcom/example/tickets/SamsungNowBarManager;", "", "<init>", "()V", "CHANNEL_BASE_ID", "", "CHANNEL_NAME", "BASE_NOTIFICATION_ID", "", "NOWBAR_ALARM_ACTION", "EXTRA_ALARM_STAGE", "EXTRA_ALARM_TICKET_ID", "EXTRA_ALARM_TICKET_TYPE", "EXTRA_ALARM_TITLE", "EXTRA_ALARM_CODE", "EXTRA_ALARM_DATE", "EXTRA_ALARM_TIME", "EXTRA_ALARM_DEPARTURE_DATE", "EXTRA_ALARM_ARRIVAL_DATE", "EXTRA_ALARM_FROM", "EXTRA_ALARM_TO", "EXTRA_ALARM_DEPARTURE_PLATFORM", "EXTRA_ALARM_ARRIVAL_PLATFORM", "EXTRA_ALARM_HALL", "EXTRA_ALARM_SEAT", "EXTRA_ALARM_VENUE", "EXTRA_ALARM_START_TIME", "EXTRA_ALARM_END_TIME", "EXTRA_ALARM_TAKEOFF_TIME", "EXTRA_ALARM_LANDING_TIME", "EXTRA_ALARM_BRAND", "ALARM_STAGE_DISPLAY_START", "ALARM_STAGE_START", "ALARM_STAGE_PRE_ARRIVAL", "ALARM_STAGE_LANDING_PREPARE", "ALARM_STAGE_TAKEOFF", "ALARM_STAGE_LANDING", "ALARM_STAGE_END", "ALARM_STAGE_DESTROY", "ALARM_REQUEST_BASE", "progressHandler", "Landroid/os/Handler;", "progressRunnables", "", "Ljava/lang/Runnable;", "isDynamicNowBarTicket", "", ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "Lcom/example/tickets/TicketType;", "EXTRA_NOWBAR_ICON", "EXTRA_NOWBAR_PRIMARY_INFO", "EXTRA_NOWBAR_SECONDARY_INFO", "EXTRA_NOWBAR_CHRONOMETER_POSITION", "EXTRA_CHIP_ICON", "EXTRA_CHIP_BG_COLOR", "EXTRA_ACTION_TYPE", "EXTRA_ACTION_BG_COLOR", "EXTRA_FIRST_ICON", "EXTRA_SECOND_ICON", "EXTRA_PRIMARY_INFO", "EXTRA_SECONDARY_INFO", "EXTRA_SECONDARY_INFO_ICON", "EXTRA_PROGRESS", "EXTRA_PROGRESS_MAX", "EXTRA_STYLE", "EXTRA_CHIP_EXPANDED_TEXT", "EXTRA_ACTION_PRIMARY_SET", "EXTRA_REMOTE_VIEW_POSITION", "EXTRA_REMOTE_VIEW_TAG", "EXTRA_SHOW_SMALL_ICON", "EXTRA_AOD_REMOTE_APP_NAME", "EXTRA_AOD_REMOTE_APP_ICON", "EXTRA_AOD_REMOTE_APP_PENDING_INTENT", "EXTRA_SUBSCREEN_PENDING_INTENT", "EXTRA_SUBST_NAME", "isSamsungDevice", "notificationId", "ticketId", "hasNotificationPermission", "context", "Landroid/content/Context;", "openLiveUpdateSettings", "", "canPostLiveUpdates", "createNotificationChannel", "showTicket", "ticket", "Lcom/example/tickets/TicketData;", "showTicket$app", "isDayCountdownTicket", "startDynamicNowBarTimer", "stopDynamicNowBarTimer", "cancelSystemNowBarAlarms", "createSystemNowBarAlarmPendingIntent", "Landroid/app/PendingIntent;", "stage", "extras", "Landroid/content/Intent;", "scheduleExactOrAllowWhileIdle", "triggerAt", "", BaseGmsClient.KEY_PENDING_INTENT, "scheduleSystemNowBarAlarm", "scheduleSystemNowBarAlarms", "showFallbackOngoing", "showFallbackOngoing$app", "buildNowBarNotification", "Landroid/app/Notification;", "payload", "Lcom/example/tickets/LiveUpdatePayload;", "includeSamsungExtras", "buildExpandedFallbackText", "notification", "buildSamsungRemoteDetailLines", "", "codeTicketProgress", "resolveWindow", "Lkotlin/Pair;", "notificationAccentColor", "ticketType", "createSamsungCardIcon", "Landroid/graphics/drawable/Icon;", "iconRes", "useRoundedSquare", "selectSmallIconRes", "selectExpandedNotificationIconRes", "originalIconRes", "createTakeoutNotificationIcon", "Landroidx/core/graphics/drawable/IconCompat;", "selectAirplaneIcon", "createNowBarContentPendingIntent", "ticketTypeName", "onSystemAlarm", AccessibilityNodeInfoCompat.MathInfoCompat.MATH_ATTRIBUTE_INTENT, "onSystemAlarm$app", "refreshFromSystemAlarm", "refreshFromSystemAlarm$app", "cancelTicket", "cancelAll", "tickets", "cancelAll$app", "isSmartSubwayAfterTransfer", "state", "Lcom/example/tickets/SmartSubwayRealtimeState;", "activeSmartSubwayLineName", "activeSmartSubwayLineColor", "smartSubwaySameStation", "first", "second", "isSmartSubwayAtRequiredTransferStation", "smartSubwayStatusText", "smartSubwayLineSummary", "smartSubwayLineSummaryWithStatus", "smartSubwayServiceBadgeLabel", "lineName", "smartSubwayPatternBadge", "smartSubwayIconTextColor", "backgroundColor", "renderSmartSubwayServiceIcon", "Landroid/graphics/Bitmap;", "sizePx", "renderSmartSubwaySamsungProgressBitmap", "widthPx", "heightPx", "showSmartSubway", "showSmartSubway$app", "compactSmartSubwayNotificationStatus", NotificationCompat.CATEGORY_STATUS, "formatSmartSubwayStationNameForDisplay", "value", "smartSubwayStationTextSizeSp", "", "active", "cancelSmartSubway", "cancelSmartSubway$app", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class SamsungNowBarManager {
    private static final int ALARM_REQUEST_BASE = 94000;
    private static final int ALARM_STAGE_DESTROY = 8;
    private static final int ALARM_STAGE_DISPLAY_START = 1;
    private static final int ALARM_STAGE_END = 7;
    private static final int ALARM_STAGE_LANDING = 6;
    private static final int ALARM_STAGE_LANDING_PREPARE = 4;
    private static final int ALARM_STAGE_PRE_ARRIVAL = 3;
    private static final int ALARM_STAGE_START = 2;
    private static final int ALARM_STAGE_TAKEOFF = 5;
    private static final int BASE_NOTIFICATION_ID = 61000;
    private static final String CHANNEL_BASE_ID = "ticket_samsung_now_bar";
    private static final String CHANNEL_NAME = "票据 · 实时窗";
    private static final String EXTRA_ACTION_BG_COLOR = "android.ongoingActivityNoti.actionBgColor";
    private static final String EXTRA_ACTION_PRIMARY_SET = "android.ongoingActivityNoti.actionPrimarySet";
    private static final String EXTRA_ACTION_TYPE = "android.ongoingActivityNoti.actionType";
    private static final String EXTRA_ALARM_ARRIVAL_DATE = "samsung_nowbar_arrival_date";
    private static final String EXTRA_ALARM_ARRIVAL_PLATFORM = "samsung_nowbar_arrival_platform";
    private static final String EXTRA_ALARM_BRAND = "samsung_nowbar_brand";
    private static final String EXTRA_ALARM_CODE = "samsung_nowbar_code";
    private static final String EXTRA_ALARM_DATE = "samsung_nowbar_date";
    private static final String EXTRA_ALARM_DEPARTURE_DATE = "samsung_nowbar_departure_date";
    private static final String EXTRA_ALARM_DEPARTURE_PLATFORM = "samsung_nowbar_departure_platform";
    private static final String EXTRA_ALARM_END_TIME = "samsung_nowbar_end_time";
    private static final String EXTRA_ALARM_FROM = "samsung_nowbar_from";
    private static final String EXTRA_ALARM_HALL = "samsung_nowbar_hall";
    private static final String EXTRA_ALARM_LANDING_TIME = "samsung_nowbar_landing_time";
    private static final String EXTRA_ALARM_SEAT = "samsung_nowbar_seat";
    private static final String EXTRA_ALARM_STAGE = "samsung_nowbar_alarm_stage";
    private static final String EXTRA_ALARM_START_TIME = "samsung_nowbar_start_time";
    private static final String EXTRA_ALARM_TAKEOFF_TIME = "samsung_nowbar_takeoff_time";
    private static final String EXTRA_ALARM_TICKET_ID = "samsung_nowbar_ticket_id";
    private static final String EXTRA_ALARM_TICKET_TYPE = "samsung_nowbar_ticket_type";
    private static final String EXTRA_ALARM_TIME = "samsung_nowbar_time";
    private static final String EXTRA_ALARM_TITLE = "samsung_nowbar_title";
    private static final String EXTRA_ALARM_TO = "samsung_nowbar_to";
    private static final String EXTRA_ALARM_VENUE = "samsung_nowbar_venue";
    private static final String EXTRA_AOD_REMOTE_APP_ICON = "android.ongoingActivityNoti.aodRemoteAppIcon";
    private static final String EXTRA_AOD_REMOTE_APP_NAME = "android.ongoingActivityNoti.aodRemoteAppName";
    private static final String EXTRA_AOD_REMOTE_APP_PENDING_INTENT = "android.ongoingActivityNoti.aodRemoteAppPendingIntent";
    private static final String EXTRA_CHIP_BG_COLOR = "android.ongoingActivityNoti.chipBgColor";
    private static final String EXTRA_CHIP_EXPANDED_TEXT = "android.ongoingActivityNoti.chipExpandedText";
    private static final String EXTRA_CHIP_ICON = "android.ongoingActivityNoti.chipIcon";
    private static final String EXTRA_FIRST_ICON = "android.ongoingActivityNoti.firstIcon";
    private static final String EXTRA_NOWBAR_CHRONOMETER_POSITION = "android.ongoingActivityNoti.nowbarChronometerPosition";
    private static final String EXTRA_NOWBAR_ICON = "android.ongoingActivityNoti.nowbarIcon";
    private static final String EXTRA_NOWBAR_PRIMARY_INFO = "android.ongoingActivityNoti.nowbarPrimaryInfo";
    private static final String EXTRA_NOWBAR_SECONDARY_INFO = "android.ongoingActivityNoti.nowbarSecondaryInfo";
    private static final String EXTRA_PRIMARY_INFO = "android.ongoingActivityNoti.primaryInfo";
    private static final String EXTRA_PROGRESS = "android.ongoingActivityNoti.progress";
    private static final String EXTRA_PROGRESS_MAX = "android.ongoingActivityNoti.progressMax";
    private static final String EXTRA_REMOTE_VIEW_POSITION = "android.ongoingActivityNoti.chronometerRemoteViewPosition";
    private static final String EXTRA_REMOTE_VIEW_TAG = "android.ongoingActivityNoti.chronometerRemoteViewTag";
    private static final String EXTRA_SECONDARY_INFO = "android.ongoingActivityNoti.secondaryInfo";
    private static final String EXTRA_SECONDARY_INFO_ICON = "android.ongoingActivityNoti.secondaryInfoIcon";
    private static final String EXTRA_SECOND_ICON = "android.ongoingActivityNoti.secondIcon";
    private static final String EXTRA_SHOW_SMALL_ICON = "android.showSmallIcon";
    private static final String EXTRA_STYLE = "android.ongoingActivityNoti.style";
    private static final String EXTRA_SUBSCREEN_PENDING_INTENT = "android.ongoingActivityNoti.nowbarPendingIntentOnSubScreen";
    private static final String EXTRA_SUBST_NAME = "android.substName";
    private static final String NOWBAR_ALARM_ACTION = "com.example.tickets.action.SAMSUNG_NOWBAR_ALARM";
    public static final SamsungNowBarManager INSTANCE = new SamsungNowBarManager();
    private static final Handler progressHandler = new Handler(Looper.getMainLooper());
    private static final Map<Integer, Runnable> progressRunnables = new LinkedHashMap();
    public static final int $stable = 8;

    /* JADX INFO: compiled from: SamsungNowBarManager.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[TicketType.values().length];
            try {
                iArr[TicketType.Train.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[TicketType.Airplane.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[TicketType.TakeoutCode.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[TicketType.PickupCode.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[TicketType.Movie.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[TicketType.Event.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[TicketType.Admission.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public final int notificationId(int ticketId) {
        return ticketId + BASE_NOTIFICATION_ID;
    }

    private SamsungNowBarManager() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isDynamicNowBarTicket(TicketType type) {
        return type == TicketType.TakeoutCode || type == TicketType.PickupCode || type == TicketType.Train || type == TicketType.Airplane || type == TicketType.Movie || type == TicketType.Event || type == TicketType.Admission;
    }

    public final boolean isSamsungDevice() {
        String str = Build.MANUFACTURER;
        if (str == null) {
            str = "";
        }
        String lowerCase = str.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        String str2 = Build.BRAND;
        String lowerCase2 = (str2 != null ? str2 : "").toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
        return StringsKt.contains$default((CharSequence) lowerCase, (CharSequence) "samsung", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) lowerCase2, (CharSequence) "samsung", false, 2, (Object) null);
    }

    private final boolean hasNotificationPermission(Context context) {
        return Build.VERSION.SDK_INT < 33 || ContextCompat.checkSelfPermission(context, "android.permission.POST_NOTIFICATIONS") == 0;
    }

    public final void openLiveUpdateSettings(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (Build.VERSION.SDK_INT >= 36) {
            try {
                Intent intent = new Intent("android.settings.APP_NOTIFICATION_PROMOTION_SETTINGS");
                intent.putExtra("android.provider.extra.APP_PACKAGE", context.getPackageName());
                context.startActivity(intent);
                return;
            } catch (Throwable unused) {
            }
        }
        try {
            Intent intent2 = new Intent("android.settings.APP_NOTIFICATION_SETTINGS");
            intent2.putExtra("android.provider.extra.APP_PACKAGE", context.getPackageName());
            context.startActivity(intent2);
        } catch (Throwable unused2) {
        }
    }

    public final boolean canPostLiveUpdates(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (Build.VERSION.SDK_INT < 36) {
            return false;
        }
        Object systemService = context.getSystemService("notification");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
        return ((NotificationManager) systemService).canPostPromotedNotifications();
    }

    private final void createNotificationChannel(Context context) {
        Object systemService = context.getSystemService("notification");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
        RealtimeNotificationVisibilityController.INSTANCE.createVisibilityChannels((NotificationManager) systemService, CHANNEL_BASE_ID, CHANNEL_NAME, "三星设备上的独立实时窗 / Now Bar 实验通知", false);
    }

    public final void showTicket$app(Context context, TicketData ticket) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(ticket, "ticket");
        if (hasNotificationPermission(context)) {
            if (!isSamsungDevice()) {
                showFallbackOngoing$app(context, ticket);
                return;
            }
            createNotificationChannel(context);
            try {
                NotificationManagerCompat.from(context).notify(notificationId(ticket.getId()), buildNowBarNotification$default(this, context, new LiveUpdatePayload(ticket.getId(), ticketTypeName(ticket.getType()), ticket.getTitle(), ticket.getCode(), ticket.getDate(), ticket.getTime(), ticket.getDepartureDate(), ticket.getArrivalDate(), ticket.getFrom(), ticket.getTo(), ticket.getDeparturePlatform(), ticket.getArrivalPlatform(), ticket.getHall(), ticket.getSeat(), ticket.getVenue(), null, null, ticket.getStartTime(), ticket.getEndTime(), ticket.getTakeoffTime(), ticket.getLandingTime(), ticket.getBrand(), 98304, null), ticket, false, 8, null));
            } catch (SecurityException unused) {
            }
            if (isDynamicNowBarTicket(ticket.getType())) {
                Context applicationContext = context.getApplicationContext();
                Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
                startDynamicNowBarTimer(applicationContext, ticket);
                return;
            }
            stopDynamicNowBarTimer(ticket.getId());
        }
    }

    private final boolean isDayCountdownTicket(TicketType type) {
        return type == TicketType.TakeoutCode || type == TicketType.PickupCode || type == TicketType.Event || type == TicketType.Admission;
    }

    private final void startDynamicNowBarTimer(final Context context, final TicketData ticket) {
        final int iNotificationId = notificationId(ticket.getId());
        Map<Integer, Runnable> map = progressRunnables;
        Runnable runnable = map.get(Integer.valueOf(iNotificationId));
        if (runnable != null) {
            progressHandler.removeCallbacks(runnable);
        }
        Runnable runnable2 = new Runnable() { // from class: com.example.tickets.SamsungNowBarManager$startDynamicNowBarTimer$runnable$1
            @Override // java.lang.Runnable
            public void run() {
                if (!SamsungNowBarManager.INSTANCE.isDynamicNowBarTicket(ticket.getType())) {
                    SamsungNowBarManager.progressRunnables.remove(Integer.valueOf(iNotificationId));
                    return;
                }
                LiveUpdatePayload liveUpdatePayload = new LiveUpdatePayload(ticket.getId(), SamsungNowBarManager.INSTANCE.ticketTypeName(ticket.getType()), ticket.getTitle(), ticket.getCode(), ticket.getDate(), ticket.getTime(), ticket.getDepartureDate(), ticket.getArrivalDate(), ticket.getFrom(), ticket.getTo(), ticket.getDeparturePlatform(), ticket.getArrivalPlatform(), ticket.getHall(), ticket.getSeat(), ticket.getVenue(), null, null, ticket.getStartTime(), ticket.getEndTime(), ticket.getTakeoffTime(), ticket.getLandingTime(), ticket.getBrand(), 98304, null);
                Pair pairResolveWindow = SamsungNowBarManager.INSTANCE.resolveWindow(liveUpdatePayload);
                long jLongValue = ((Number) pairResolveWindow.component1()).longValue();
                long jLongValue2 = ((Number) pairResolveWindow.component2()).longValue();
                long jCurrentTimeMillis = System.currentTimeMillis();
                long j = (jLongValue == Long.MAX_VALUE || jLongValue2 <= jLongValue) ? Long.MAX_VALUE : jLongValue2 + 300000;
                if (j != Long.MAX_VALUE && jCurrentTimeMillis >= j) {
                    NotificationManagerCompat.from(context).cancel(iNotificationId);
                    SamsungNowBarManager.progressRunnables.remove(Integer.valueOf(iNotificationId));
                    return;
                }
                try {
                    NotificationManagerCompat.from(context).notify(iNotificationId, SamsungNowBarManager.buildNowBarNotification$default(SamsungNowBarManager.INSTANCE, context, liveUpdatePayload, ticket, false, 8, null));
                    long jCoerceAtLeast = CoroutineLiveDataKt.DEFAULT_TIMEOUT;
                    if (j != Long.MAX_VALUE) {
                        jCoerceAtLeast = RangesKt.coerceAtLeast(RangesKt.coerceAtMost(j - jCurrentTimeMillis, CoroutineLiveDataKt.DEFAULT_TIMEOUT), 1000L);
                    }
                    SamsungNowBarManager.progressHandler.postDelayed(this, jCoerceAtLeast);
                } catch (SecurityException unused) {
                    SamsungNowBarManager.progressRunnables.remove(Integer.valueOf(iNotificationId));
                }
            }
        };
        map.put(Integer.valueOf(iNotificationId), runnable2);
        progressHandler.post(runnable2);
        scheduleSystemNowBarAlarms(context, ticket);
    }

    private final void stopDynamicNowBarTimer(int ticketId) {
        Runnable runnableRemove = progressRunnables.remove(Integer.valueOf(notificationId(ticketId)));
        if (runnableRemove != null) {
            progressHandler.removeCallbacks(runnableRemove);
        }
    }

    private final void cancelSystemNowBarAlarms(Context context, int ticketId) {
        Object systemService = context.getSystemService(NotificationCompat.CATEGORY_ALARM);
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.AlarmManager");
        AlarmManager alarmManager = (AlarmManager) systemService;
        for (int i = 1; i < 9; i++) {
            PendingIntent pendingIntentCreateSystemNowBarAlarmPendingIntent = createSystemNowBarAlarmPendingIntent(context, ticketId, i, null);
            alarmManager.cancel(pendingIntentCreateSystemNowBarAlarmPendingIntent);
            pendingIntentCreateSystemNowBarAlarmPendingIntent.cancel();
        }
    }

    private final PendingIntent createSystemNowBarAlarmPendingIntent(Context context, int ticketId, int stage, Intent extras) {
        Intent intent = new Intent(context, (Class<?>) SamsungNowBarAlarmReceiver.class);
        intent.setAction(NOWBAR_ALARM_ACTION);
        intent.putExtra(EXTRA_ALARM_TICKET_ID, ticketId);
        intent.putExtra(EXTRA_ALARM_STAGE, stage);
        if (extras != null) {
            intent.putExtras(extras);
        }
        PendingIntent broadcast = PendingIntent.getBroadcast(context, (ticketId * 10) + ALARM_REQUEST_BASE + stage, intent, 201326592);
        Intrinsics.checkNotNullExpressionValue(broadcast, "getBroadcast(...)");
        return broadcast;
    }

    private final void scheduleExactOrAllowWhileIdle(Context context, long triggerAt, PendingIntent pendingIntent) {
        if (triggerAt <= System.currentTimeMillis()) {
            return;
        }
        Object systemService = context.getSystemService(NotificationCompat.CATEGORY_ALARM);
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.AlarmManager");
        AlarmManager alarmManager = (AlarmManager) systemService;
        if (Build.VERSION.SDK_INT < 31 || alarmManager.canScheduleExactAlarms()) {
            alarmManager.setExactAndAllowWhileIdle(0, triggerAt, pendingIntent);
        } else {
            alarmManager.setAndAllowWhileIdle(0, triggerAt, pendingIntent);
        }
    }

    private final void scheduleSystemNowBarAlarm(Context context, TicketData ticket, int stage, long triggerAt) {
        if (triggerAt <= System.currentTimeMillis()) {
            return;
        }
        Intent intent = new Intent(context, (Class<?>) SamsungNowBarAlarmReceiver.class);
        intent.setAction(NOWBAR_ALARM_ACTION);
        intent.putExtra(EXTRA_ALARM_STAGE, stage);
        intent.putExtra(EXTRA_ALARM_TICKET_ID, ticket.getId());
        intent.putExtra(EXTRA_ALARM_TICKET_TYPE, INSTANCE.ticketTypeName(ticket.getType()));
        intent.putExtra(EXTRA_ALARM_TITLE, ticket.getTitle());
        intent.putExtra(EXTRA_ALARM_CODE, ticket.getCode());
        intent.putExtra(EXTRA_ALARM_DATE, ticket.getDate());
        intent.putExtra(EXTRA_ALARM_TIME, ticket.getTime());
        intent.putExtra(EXTRA_ALARM_DEPARTURE_DATE, ticket.getDepartureDate());
        intent.putExtra(EXTRA_ALARM_ARRIVAL_DATE, ticket.getArrivalDate());
        intent.putExtra(EXTRA_ALARM_FROM, ticket.getFrom());
        intent.putExtra(EXTRA_ALARM_TO, ticket.getTo());
        intent.putExtra(EXTRA_ALARM_DEPARTURE_PLATFORM, ticket.getDeparturePlatform());
        intent.putExtra(EXTRA_ALARM_ARRIVAL_PLATFORM, ticket.getArrivalPlatform());
        intent.putExtra(EXTRA_ALARM_HALL, ticket.getHall());
        intent.putExtra(EXTRA_ALARM_SEAT, ticket.getSeat());
        intent.putExtra(EXTRA_ALARM_VENUE, ticket.getVenue());
        intent.putExtra(EXTRA_ALARM_START_TIME, ticket.getStartTime());
        intent.putExtra(EXTRA_ALARM_END_TIME, ticket.getEndTime());
        intent.putExtra(EXTRA_ALARM_TAKEOFF_TIME, ticket.getTakeoffTime());
        intent.putExtra(EXTRA_ALARM_LANDING_TIME, ticket.getLandingTime());
        intent.putExtra(EXTRA_ALARM_BRAND, ticket.getBrand());
        scheduleExactOrAllowWhileIdle(context, triggerAt, createSystemNowBarAlarmPendingIntent(context, ticket.getId(), stage, intent));
    }

    /* JADX WARN: Code duplicated, block: B:32:0x011e  */
    private final void scheduleSystemNowBarAlarms(Context context, TicketData ticket) {
        long jLongValue;
        cancelSystemNowBarAlarms(context, ticket.getId());
        Pair<Long, Long> pairResolveWindow = resolveWindow(new LiveUpdatePayload(ticket.getId(), ticketTypeName(ticket.getType()), ticket.getTitle(), ticket.getCode(), ticket.getDate(), ticket.getTime(), ticket.getDepartureDate(), ticket.getArrivalDate(), ticket.getFrom(), ticket.getTo(), ticket.getDeparturePlatform(), ticket.getArrivalPlatform(), ticket.getHall(), ticket.getSeat(), ticket.getVenue(), null, null, ticket.getStartTime(), ticket.getEndTime(), ticket.getTakeoffTime(), ticket.getLandingTime(), ticket.getBrand(), 98304, null));
        long jLongValue2 = pairResolveWindow.component1().longValue();
        long jLongValue3 = pairResolveWindow.component2().longValue();
        if (jLongValue2 == Long.MAX_VALUE || jLongValue3 <= jLongValue2) {
            return;
        }
        scheduleSystemNowBarAlarm(context, ticket, 1, (ticket.getType() == TicketType.Train || ticket.getType() == TicketType.Airplane || ticket.getType() == TicketType.Movie) ? jLongValue2 - 1200000 : jLongValue2);
        scheduleSystemNowBarAlarm(context, ticket, 2, jLongValue2);
        if (ticket.getType() == TicketType.Train) {
            scheduleSystemNowBarAlarm(context, ticket, 3, jLongValue3 - 300000);
        }
        if (ticket.getType() == TicketType.Airplane) {
            Long dateTime = LiveUpdateManager.INSTANCE.parseDateTime(ticket.getDate(), ticket.getTakeoffTime());
            if (dateTime != null) {
                jLongValue2 = dateTime.longValue();
            }
            long j = jLongValue2;
            Long dateTime2 = LiveUpdateManager.INSTANCE.parseDateTime(ticket.getDate(), ticket.getLandingTime());
            if (dateTime2 == null) {
                jLongValue = jLongValue3;
            } else {
                if (dateTime2.longValue() <= j) {
                    dateTime2 = null;
                }
                if (dateTime2 != null) {
                    jLongValue = dateTime2.longValue();
                } else {
                    jLongValue = jLongValue3;
                }
            }
            scheduleSystemNowBarAlarm(context, ticket, 5, j);
            scheduleSystemNowBarAlarm(context, ticket, 4, RangesKt.coerceAtLeast(jLongValue - 600000, j));
            scheduleSystemNowBarAlarm(context, ticket, 6, jLongValue);
        }
        scheduleSystemNowBarAlarm(context, ticket, 7, jLongValue3);
        scheduleSystemNowBarAlarm(context, ticket, 8, jLongValue3 + 300000);
    }

    public final void showFallbackOngoing$app(Context context, TicketData ticket) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(ticket, "ticket");
        if (hasNotificationPermission(context)) {
            createNotificationChannel(context);
            try {
                NotificationManagerCompat.from(context).notify(notificationId(ticket.getId()), buildNowBarNotification(context, new LiveUpdatePayload(ticket.getId(), ticketTypeName(ticket.getType()), ticket.getTitle(), ticket.getCode(), ticket.getDate(), ticket.getTime(), ticket.getDepartureDate(), ticket.getArrivalDate(), ticket.getFrom(), ticket.getTo(), ticket.getDeparturePlatform(), ticket.getArrivalPlatform(), ticket.getHall(), ticket.getSeat(), ticket.getVenue(), null, null, ticket.getStartTime(), ticket.getEndTime(), ticket.getTakeoffTime(), ticket.getLandingTime(), ticket.getBrand(), 98304, null), ticket, false));
            } catch (SecurityException unused) {
            }
        }
    }

    static /* synthetic */ Notification buildNowBarNotification$default(SamsungNowBarManager samsungNowBarManager, Context context, LiveUpdatePayload liveUpdatePayload, TicketData ticketData, boolean z, int i, Object obj) {
        if ((i & 8) != 0) {
            z = true;
        }
        return samsungNowBarManager.buildNowBarNotification(context, liveUpdatePayload, ticketData, z);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:113:0x02ff  */
    /* JADX WARN: Code duplicated, block: B:122:0x032c  */
    /* JADX WARN: Code duplicated, block: B:124:0x032f A[Catch: all -> 0x047c, TryCatch #3 {all -> 0x047c, blocks: (B:116:0x0315, B:118:0x031f, B:124:0x032f, B:126:0x0334, B:128:0x033f, B:133:0x034e, B:134:0x035a, B:167:0x03c0, B:168:0x03c4, B:171:0x03ce, B:136:0x035f, B:139:0x0368, B:141:0x0374, B:143:0x037e, B:147:0x0387, B:148:0x038a, B:163:0x03ad, B:165:0x03b9, B:166:0x03bd, B:151:0x0391, B:154:0x0398, B:157:0x039f, B:160:0x03a6, B:125:0x0332), top: B:232:0x0315 }] */
    /* JADX WARN: Code duplicated, block: B:125:0x0332 A[Catch: all -> 0x047c, TryCatch #3 {all -> 0x047c, blocks: (B:116:0x0315, B:118:0x031f, B:124:0x032f, B:126:0x0334, B:128:0x033f, B:133:0x034e, B:134:0x035a, B:167:0x03c0, B:168:0x03c4, B:171:0x03ce, B:136:0x035f, B:139:0x0368, B:141:0x0374, B:143:0x037e, B:147:0x0387, B:148:0x038a, B:163:0x03ad, B:165:0x03b9, B:166:0x03bd, B:151:0x0391, B:154:0x0398, B:157:0x039f, B:160:0x03a6, B:125:0x0332), top: B:232:0x0315 }] */
    /* JADX WARN: Code duplicated, block: B:128:0x033f A[Catch: all -> 0x047c, TRY_LEAVE, TryCatch #3 {all -> 0x047c, blocks: (B:116:0x0315, B:118:0x031f, B:124:0x032f, B:126:0x0334, B:128:0x033f, B:133:0x034e, B:134:0x035a, B:167:0x03c0, B:168:0x03c4, B:171:0x03ce, B:136:0x035f, B:139:0x0368, B:141:0x0374, B:143:0x037e, B:147:0x0387, B:148:0x038a, B:163:0x03ad, B:165:0x03b9, B:166:0x03bd, B:151:0x0391, B:154:0x0398, B:157:0x039f, B:160:0x03a6, B:125:0x0332), top: B:232:0x0315 }] */
    /* JADX WARN: Code duplicated, block: B:135:0x035d  */
    /* JADX WARN: Code duplicated, block: B:136:0x035f A[Catch: all -> 0x047c, TryCatch #3 {all -> 0x047c, blocks: (B:116:0x0315, B:118:0x031f, B:124:0x032f, B:126:0x0334, B:128:0x033f, B:133:0x034e, B:134:0x035a, B:167:0x03c0, B:168:0x03c4, B:171:0x03ce, B:136:0x035f, B:139:0x0368, B:141:0x0374, B:143:0x037e, B:147:0x0387, B:148:0x038a, B:163:0x03ad, B:165:0x03b9, B:166:0x03bd, B:151:0x0391, B:154:0x0398, B:157:0x039f, B:160:0x03a6, B:125:0x0332), top: B:232:0x0315 }] */
    /* JADX WARN: Code duplicated, block: B:138:0x0367  */
    /* JADX WARN: Code duplicated, block: B:139:0x0368 A[Catch: all -> 0x047c, TryCatch #3 {all -> 0x047c, blocks: (B:116:0x0315, B:118:0x031f, B:124:0x032f, B:126:0x0334, B:128:0x033f, B:133:0x034e, B:134:0x035a, B:167:0x03c0, B:168:0x03c4, B:171:0x03ce, B:136:0x035f, B:139:0x0368, B:141:0x0374, B:143:0x037e, B:147:0x0387, B:148:0x038a, B:163:0x03ad, B:165:0x03b9, B:166:0x03bd, B:151:0x0391, B:154:0x0398, B:157:0x039f, B:160:0x03a6, B:125:0x0332), top: B:232:0x0315 }] */
    /* JADX WARN: Code duplicated, block: B:141:0x0374 A[Catch: all -> 0x047c, TryCatch #3 {all -> 0x047c, blocks: (B:116:0x0315, B:118:0x031f, B:124:0x032f, B:126:0x0334, B:128:0x033f, B:133:0x034e, B:134:0x035a, B:167:0x03c0, B:168:0x03c4, B:171:0x03ce, B:136:0x035f, B:139:0x0368, B:141:0x0374, B:143:0x037e, B:147:0x0387, B:148:0x038a, B:163:0x03ad, B:165:0x03b9, B:166:0x03bd, B:151:0x0391, B:154:0x0398, B:157:0x039f, B:160:0x03a6, B:125:0x0332), top: B:232:0x0315 }] */
    /* JADX WARN: Code duplicated, block: B:143:0x037e A[Catch: all -> 0x047c, TryCatch #3 {all -> 0x047c, blocks: (B:116:0x0315, B:118:0x031f, B:124:0x032f, B:126:0x0334, B:128:0x033f, B:133:0x034e, B:134:0x035a, B:167:0x03c0, B:168:0x03c4, B:171:0x03ce, B:136:0x035f, B:139:0x0368, B:141:0x0374, B:143:0x037e, B:147:0x0387, B:148:0x038a, B:163:0x03ad, B:165:0x03b9, B:166:0x03bd, B:151:0x0391, B:154:0x0398, B:157:0x039f, B:160:0x03a6, B:125:0x0332), top: B:232:0x0315 }] */
    /* JADX WARN: Code duplicated, block: B:144:0x0383  */
    /* JADX WARN: Code duplicated, block: B:146:0x0386  */
    /* JADX WARN: Code duplicated, block: B:148:0x038a A[Catch: all -> 0x047c, TryCatch #3 {all -> 0x047c, blocks: (B:116:0x0315, B:118:0x031f, B:124:0x032f, B:126:0x0334, B:128:0x033f, B:133:0x034e, B:134:0x035a, B:167:0x03c0, B:168:0x03c4, B:171:0x03ce, B:136:0x035f, B:139:0x0368, B:141:0x0374, B:143:0x037e, B:147:0x0387, B:148:0x038a, B:163:0x03ad, B:165:0x03b9, B:166:0x03bd, B:151:0x0391, B:154:0x0398, B:157:0x039f, B:160:0x03a6, B:125:0x0332), top: B:232:0x0315 }] */
    /* JADX WARN: Code duplicated, block: B:150:0x0390  */
    /* JADX WARN: Code duplicated, block: B:151:0x0391 A[Catch: all -> 0x047c, TryCatch #3 {all -> 0x047c, blocks: (B:116:0x0315, B:118:0x031f, B:124:0x032f, B:126:0x0334, B:128:0x033f, B:133:0x034e, B:134:0x035a, B:167:0x03c0, B:168:0x03c4, B:171:0x03ce, B:136:0x035f, B:139:0x0368, B:141:0x0374, B:143:0x037e, B:147:0x0387, B:148:0x038a, B:163:0x03ad, B:165:0x03b9, B:166:0x03bd, B:151:0x0391, B:154:0x0398, B:157:0x039f, B:160:0x03a6, B:125:0x0332), top: B:232:0x0315 }] */
    /* JADX WARN: Code duplicated, block: B:153:0x0397  */
    /* JADX WARN: Code duplicated, block: B:154:0x0398 A[Catch: all -> 0x047c, TryCatch #3 {all -> 0x047c, blocks: (B:116:0x0315, B:118:0x031f, B:124:0x032f, B:126:0x0334, B:128:0x033f, B:133:0x034e, B:134:0x035a, B:167:0x03c0, B:168:0x03c4, B:171:0x03ce, B:136:0x035f, B:139:0x0368, B:141:0x0374, B:143:0x037e, B:147:0x0387, B:148:0x038a, B:163:0x03ad, B:165:0x03b9, B:166:0x03bd, B:151:0x0391, B:154:0x0398, B:157:0x039f, B:160:0x03a6, B:125:0x0332), top: B:232:0x0315 }] */
    /* JADX WARN: Code duplicated, block: B:156:0x039e  */
    /* JADX WARN: Code duplicated, block: B:157:0x039f A[Catch: all -> 0x047c, TryCatch #3 {all -> 0x047c, blocks: (B:116:0x0315, B:118:0x031f, B:124:0x032f, B:126:0x0334, B:128:0x033f, B:133:0x034e, B:134:0x035a, B:167:0x03c0, B:168:0x03c4, B:171:0x03ce, B:136:0x035f, B:139:0x0368, B:141:0x0374, B:143:0x037e, B:147:0x0387, B:148:0x038a, B:163:0x03ad, B:165:0x03b9, B:166:0x03bd, B:151:0x0391, B:154:0x0398, B:157:0x039f, B:160:0x03a6, B:125:0x0332), top: B:232:0x0315 }] */
    /* JADX WARN: Code duplicated, block: B:159:0x03a5  */
    /* JADX WARN: Code duplicated, block: B:160:0x03a6 A[Catch: all -> 0x047c, TryCatch #3 {all -> 0x047c, blocks: (B:116:0x0315, B:118:0x031f, B:124:0x032f, B:126:0x0334, B:128:0x033f, B:133:0x034e, B:134:0x035a, B:167:0x03c0, B:168:0x03c4, B:171:0x03ce, B:136:0x035f, B:139:0x0368, B:141:0x0374, B:143:0x037e, B:147:0x0387, B:148:0x038a, B:163:0x03ad, B:165:0x03b9, B:166:0x03bd, B:151:0x0391, B:154:0x0398, B:157:0x039f, B:160:0x03a6, B:125:0x0332), top: B:232:0x0315 }] */
    /* JADX WARN: Code duplicated, block: B:162:0x03ac  */
    /* JADX WARN: Code duplicated, block: B:163:0x03ad A[Catch: all -> 0x047c, TryCatch #3 {all -> 0x047c, blocks: (B:116:0x0315, B:118:0x031f, B:124:0x032f, B:126:0x0334, B:128:0x033f, B:133:0x034e, B:134:0x035a, B:167:0x03c0, B:168:0x03c4, B:171:0x03ce, B:136:0x035f, B:139:0x0368, B:141:0x0374, B:143:0x037e, B:147:0x0387, B:148:0x038a, B:163:0x03ad, B:165:0x03b9, B:166:0x03bd, B:151:0x0391, B:154:0x0398, B:157:0x039f, B:160:0x03a6, B:125:0x0332), top: B:232:0x0315 }] */
    /* JADX WARN: Code duplicated, block: B:165:0x03b9 A[Catch: all -> 0x047c, TryCatch #3 {all -> 0x047c, blocks: (B:116:0x0315, B:118:0x031f, B:124:0x032f, B:126:0x0334, B:128:0x033f, B:133:0x034e, B:134:0x035a, B:167:0x03c0, B:168:0x03c4, B:171:0x03ce, B:136:0x035f, B:139:0x0368, B:141:0x0374, B:143:0x037e, B:147:0x0387, B:148:0x038a, B:163:0x03ad, B:165:0x03b9, B:166:0x03bd, B:151:0x0391, B:154:0x0398, B:157:0x039f, B:160:0x03a6, B:125:0x0332), top: B:232:0x0315 }] */
    /* JADX WARN: Code duplicated, block: B:167:0x03c0 A[Catch: all -> 0x047c, TryCatch #3 {all -> 0x047c, blocks: (B:116:0x0315, B:118:0x031f, B:124:0x032f, B:126:0x0334, B:128:0x033f, B:133:0x034e, B:134:0x035a, B:167:0x03c0, B:168:0x03c4, B:171:0x03ce, B:136:0x035f, B:139:0x0368, B:141:0x0374, B:143:0x037e, B:147:0x0387, B:148:0x038a, B:163:0x03ad, B:165:0x03b9, B:166:0x03bd, B:151:0x0391, B:154:0x0398, B:157:0x039f, B:160:0x03a6, B:125:0x0332), top: B:232:0x0315 }] */
    /* JADX WARN: Code duplicated, block: B:170:0x03cc  */
    /* JADX WARN: Code duplicated, block: B:176:0x03fb A[Catch: all -> 0x0480, TryCatch #0 {all -> 0x0480, blocks: (B:173:0x03e2, B:174:0x03f5, B:176:0x03fb, B:178:0x040a, B:179:0x040e), top: B:226:0x03e2 }] */
    /* JADX WARN: Code duplicated, block: B:184:0x048a  */
    /* JADX WARN: Code duplicated, block: B:192:0x04c3  */
    /* JADX WARN: Code duplicated, block: B:193:0x04c4  */
    /* JADX WARN: Code duplicated, block: B:197:0x04da A[Catch: all -> 0x04ff, TryCatch #5 {all -> 0x04ff, blocks: (B:186:0x049d, B:188:0x04b5, B:190:0x04bb, B:194:0x04c6, B:195:0x04c8, B:197:0x04da, B:198:0x04eb), top: B:236:0x049d }] */
    /* JADX WARN: Code duplicated, block: B:201:0x050b  */
    /* JADX WARN: Code duplicated, block: B:209:0x054b  */
    /* JADX WARN: Code duplicated, block: B:212:0x0557  */
    /* JADX WARN: Code duplicated, block: B:217:0x057c  */
    /* JADX WARN: Code duplicated, block: B:220:0x0582  */
    /* JADX WARN: Code duplicated, block: B:232:0x0315 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:238:0x040a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:241:0x03f5 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:243:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:244:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:35:0x00da  */
    /* JADX WARN: Code duplicated, block: B:37:0x00e6  */
    /* JADX WARN: Code duplicated, block: B:39:0x00ed  */
    /* JADX WARN: Code duplicated, block: B:53:0x011d  */
    /* JADX WARN: Code duplicated, block: B:72:0x01b7  */
    /* JADX WARN: Code duplicated, block: B:86:0x0210  */
    /* JADX WARN: Code duplicated, block: B:88:0x022c  */
    /* JADX WARN: Code duplicated, block: B:91:0x024e  */
    /* JADX WARN: Code duplicated, block: B:94:0x0289  */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private final Notification buildNowBarNotification(Context context, LiveUpdatePayload payload, TicketData ticket, boolean includeSamsungExtras) {
        String title;
        String strBuildExpandedFallbackText;
        String str;
        boolean z;
        CharSequence charSequence;
        String str2;
        long jLongValue;
        int iCoerceIn;
        boolean z2;
        String str3;
        Context context2;
        TicketData ticketData;
        int i;
        boolean z3;
        int i2;
        RemoteViews remoteViews;
        String ticketType;
        String code;
        String title2;
        String title3;
        CharSequence charSequence2;
        String str4;
        ArrayList arrayList;
        String str5;
        long jLongValue2;
        long j;
        long jLongValue3;
        CharSequence charSequenceLoadLabel;
        String string;
        String str6;
        String string2;
        Notification notificationBuildNotification = LiveUpdateManager.INSTANCE.buildNotification(context, payload);
        if (!includeSamsungExtras) {
            return notificationBuildNotification;
        }
        int iSelectSmallIconRes = selectSmallIconRes(context, payload);
        int iSelectExpandedNotificationIconRes = selectExpandedNotificationIconRes(context, payload, iSelectSmallIconRes);
        if (iSelectExpandedNotificationIconRes != 0) {
            notificationBuildNotification = Notification.Builder.recoverBuilder(context, notificationBuildNotification).setSmallIcon(iSelectExpandedNotificationIconRes).build();
            Intrinsics.checkNotNullExpressionValue(notificationBuildNotification, "build(...)");
            if (Intrinsics.areEqual(payload.getTicketType(), "取餐码") || Intrinsics.areEqual(payload.getTicketType(), "取件码")) {
                Pair<Long, Long> pairResolveWindow = resolveWindow(payload);
                long jLongValue4 = pairResolveWindow.component1().longValue();
                long jLongValue5 = pairResolveWindow.component2().longValue();
                if (jLongValue4 != Long.MAX_VALUE && jLongValue5 > jLongValue4) {
                    long j2 = jLongValue5 - jLongValue4;
                    notificationBuildNotification = Notification.Builder.recoverBuilder(context, notificationBuildNotification).setProgress(1000, RangesKt.coerceIn((int) ((RangesKt.coerceIn(System.currentTimeMillis() - jLongValue4, 0L, j2) * 1000) / j2), 0, 1000), false).build();
                    Intrinsics.checkNotNullExpressionValue(notificationBuildNotification, "build(...)");
                }
            }
            notificationBuildNotification.icon = iSelectExpandedNotificationIconRes;
            notificationBuildNotification.iconLevel = 0;
            notificationBuildNotification.extras.putParcelable(EXTRA_CHIP_ICON, Icon.createWithResource(context, iSelectSmallIconRes));
        }
        switch (payload.getTicketType()) {
            case "机票":
            case "车票":
            case "取件码":
            case "取餐码":
            case "火车票":
                String code2 = payload.getCode();
                if (StringsKt.isBlank(code2)) {
                    code2 = payload.getTitle();
                }
                title = code2;
                break;
            default:
                title = payload.getTitle();
                break;
        }
        String str7 = title;
        String str8 = "票据";
        if (StringsKt.isBlank(str7)) {
            str7 = "票据";
        }
        String str9 = str7;
        CharSequence charSequence3 = notificationBuildNotification.extras.getCharSequence(NotificationCompat.EXTRA_BIG_TEXT);
        if (charSequence3 != null && (strBuildExpandedFallbackText = charSequence3.toString()) != null) {
            if (StringsKt.isBlank(strBuildExpandedFallbackText)) {
                strBuildExpandedFallbackText = null;
            }
            if (strBuildExpandedFallbackText == null) {
                strBuildExpandedFallbackText = buildExpandedFallbackText(notificationBuildNotification, payload, ticket);
            }
        } else {
            strBuildExpandedFallbackText = buildExpandedFallbackText(notificationBuildNotification, payload, ticket);
        }
        String str10 = strBuildExpandedFallbackText;
        int iCoerceIn2 = RangesKt.coerceIn(notificationBuildNotification.extras.getInt(NotificationCompat.EXTRA_PROGRESS, 0), 0, 1000);
        int iCoerceAtLeast = RangesKt.coerceAtLeast(notificationBuildNotification.extras.getInt(NotificationCompat.EXTRA_PROGRESS_MAX, 1000), 1);
        Bundle bundle = notificationBuildNotification.extras;
        bundle.putInt(EXTRA_NOWBAR_ICON, iSelectSmallIconRes);
        bundle.putString(EXTRA_NOWBAR_PRIMARY_INFO, "");
        bundle.putCharSequence(EXTRA_NOWBAR_SECONDARY_INFO, "");
        bundle.putInt(EXTRA_NOWBAR_CHRONOMETER_POSITION, 0);
        bundle.putParcelable(EXTRA_CHIP_ICON, Icon.createWithResource(context, iSelectSmallIconRes));
        SamsungNowBarManager samsungNowBarManager = INSTANCE;
        try {
            if (!Intrinsics.areEqual(payload.getTicketType(), "演出")) {
                str = "";
                if (!Intrinsics.areEqual(payload.getTicketType(), "门票")) {
                    z = false;
                }
                bundle.putParcelable(EXTRA_FIRST_ICON, samsungNowBarManager.createSamsungCardIcon(context, payload, iSelectSmallIconRes, z));
                charSequence = notificationBuildNotification.extras.getCharSequence(NotificationCompat.EXTRA_TITLE);
                if (charSequence != null || (string2 = charSequence.toString()) == null) {
                    str2 = str9;
                } else {
                    String str11 = string2;
                    if (StringsKt.isBlank(str11)) {
                        str11 = str9;
                    }
                    str2 = str11;
                    if (str2 == null) {
                        str2 = str9;
                    }
                }
                bundle.putString(EXTRA_PRIMARY_INFO, str2);
                bundle.putCharSequence(EXTRA_SECONDARY_INFO, str10);
                if (!Intrinsics.areEqual(payload.getTicketType(), "取餐码") || Intrinsics.areEqual(payload.getTicketType(), "取件码") || Intrinsics.areEqual(payload.getTicketType(), "演出") || Intrinsics.areEqual(payload.getTicketType(), "门票")) {
                    Pair<Long, Long> pairResolveWindow2 = samsungNowBarManager.resolveWindow(payload);
                    jLongValue = pairResolveWindow2.component1().longValue();
                    long jLongValue6 = pairResolveWindow2.component2().longValue();
                    if (jLongValue != Long.MAX_VALUE || jLongValue6 <= jLongValue) {
                        iCoerceIn = 0;
                    } else {
                        long j3 = jLongValue6 - jLongValue;
                        iCoerceIn = RangesKt.coerceIn((int) ((RangesKt.coerceIn(System.currentTimeMillis() - jLongValue, 0L, j3) * 100) / j3), 0, 100);
                    }
                } else if (iCoerceAtLeast == 1000) {
                    iCoerceIn = RangesKt.coerceIn(iCoerceIn2 / 10, 0, 100);
                } else {
                    iCoerceIn = RangesKt.coerceIn((iCoerceIn2 * 100) / iCoerceAtLeast, 0, 100);
                }
                bundle.putInt(EXTRA_PROGRESS, iCoerceIn);
                bundle.putInt(EXTRA_PROGRESS_MAX, 100);
                bundle.putInt(EXTRA_STYLE, 1);
                bundle.putString(EXTRA_CHIP_EXPANDED_TEXT, str9);
                bundle.putInt(EXTRA_ACTION_TYPE, 0);
                bundle.putInt(EXTRA_ACTION_BG_COLOR, 0);
                bundle.putInt(EXTRA_CHIP_BG_COLOR, samsungNowBarManager.notificationAccentColor(payload.getTicketType()));
                if (!Intrinsics.areEqual(payload.getTicketType(), "取餐码")) {
                    Intrinsics.areEqual(payload.getTicketType(), "取件码");
                }
                bundle.putInt(EXTRA_ACTION_TYPE, 1);
                bundle.putInt(EXTRA_ACTION_BG_COLOR, samsungNowBarManager.notificationAccentColor(payload.getTicketType()));
                bundle.putInt(EXTRA_ACTION_PRIMARY_SET, 0);
                if (!Intrinsics.areEqual(payload.getTicketType(), "取餐码") || Intrinsics.areEqual(payload.getTicketType(), "取件码") || Intrinsics.areEqual(payload.getTicketType(), "车票") || Intrinsics.areEqual(payload.getTicketType(), "火车票") || Intrinsics.areEqual(payload.getTicketType(), "机票") || Intrinsics.areEqual(payload.getTicketType(), "电影票") || Intrinsics.areEqual(payload.getTicketType(), "演出") || Intrinsics.areEqual(payload.getTicketType(), "门票")) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                str3 = str;
                bundle.putString(EXTRA_PRIMARY_INFO, str3);
                bundle.putCharSequence(EXTRA_SECONDARY_INFO, str3);
                if (z2) {
                    try {
                        if (!Intrinsics.areEqual(payload.getTicketType(), "取餐码") || Intrinsics.areEqual(payload.getTicketType(), "取件码")) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        if (z3) {
                            i2 = R.layout.ticket_samsung_nowbar_remote;
                        } else {
                            i2 = R.layout.ticket_samsung_nowbar_remote;
                        }
                        remoteViews = new RemoteViews(context.getPackageName(), i2);
                        if (z3) {
                            i = 0;
                            try {
                                remoteViews.setInt(R.id.ticket_nowbar_root, "setMinimumHeight", 0);
                            } catch (Throwable unused) {
                                context2 = context;
                                ticketData = ticket;
                                bundle.putInt(EXTRA_REMOTE_VIEW_POSITION, i);
                                bundle.putString(EXTRA_REMOTE_VIEW_TAG, "tickets_nowbar_screenshot_text_fallback");
                            }
                        }
                        String ticketType2 = payload.getTicketType();
                        ticketType = payload.getTicketType();
                        switch (ticketType.hashCode()) {
                            case 850286:
                                if (!ticketType.equals("机票")) {
                                    code = payload.getCode();
                                    if (StringsKt.isBlank(code)) {
                                        code = payload.getTitle();
                                    }
                                    title2 = code;
                                } else {
                                    title2 = payload.getTitle();
                                }
                                break;
                            case 1169090:
                                if (!ticketType.equals("车票")) {
                                    code = payload.getCode();
                                    if (StringsKt.isBlank(code)) {
                                        code = payload.getTitle();
                                    }
                                    title2 = code;
                                } else {
                                    title2 = payload.getTitle();
                                }
                                break;
                            case 21282337:
                                if (!ticketType.equals("取件码")) {
                                    code = payload.getCode();
                                    if (StringsKt.isBlank(code)) {
                                        code = payload.getTitle();
                                    }
                                    title2 = code;
                                } else {
                                    title2 = payload.getTitle();
                                }
                                break;
                            case 21870407:
                                if (!ticketType.equals("取餐码")) {
                                    code = payload.getCode();
                                    if (StringsKt.isBlank(code)) {
                                        code = payload.getTitle();
                                    }
                                    title2 = code;
                                } else {
                                    title2 = payload.getTitle();
                                }
                                break;
                            case 28825709:
                                if (ticketType.equals("火车票")) {
                                    code = payload.getCode();
                                    if (StringsKt.isBlank(code)) {
                                        code = payload.getTitle();
                                    }
                                    title2 = code;
                                } else {
                                    title2 = payload.getTitle();
                                }
                                break;
                            case 29623308:
                                if (!ticketType.equals("电影票")) {
                                    title3 = payload.getTitle();
                                    if (StringsKt.isBlank(title3)) {
                                        charSequence2 = notificationBuildNotification.extras.getCharSequence(NotificationCompat.EXTRA_TITLE);
                                        if (charSequence2 != null) {
                                            title3 = charSequence2.toString();
                                        } else {
                                            title3 = null;
                                        }
                                        if (title3 == null) {
                                            title3 = str3;
                                        }
                                    }
                                    title2 = title3;
                                } else {
                                    title2 = payload.getTitle();
                                }
                                break;
                            default:
                                title2 = payload.getTitle();
                                break;
                        }
                        str4 = title2;
                        if (StringsKt.isBlank(str4)) {
                            str4 = "票据";
                        }
                        remoteViews.setTextViewText(R.id.ticket_nowbar_header, ticketType2);
                        remoteViews.setTextViewText(R.id.ticket_nowbar_primary, str4);
                        context2 = context;
                        ticketData = ticket;
                        try {
                            List<String> listBuildSamsungRemoteDetailLines = samsungNowBarManager.buildSamsungRemoteDetailLines(context2, payload, ticketData, notificationBuildNotification);
                            int i3 = R.id.ticket_nowbar_details;
                            arrayList = new ArrayList();
                            for (Object obj : listBuildSamsungRemoteDetailLines) {
                                if (!StringsKt.isBlank((String) obj)) {
                                    arrayList.add(obj);
                                }
                            }
                            remoteViews.setTextViewText(i3, CollectionsKt.joinToString$default(arrayList, "\n", null, null, 0, null, null, 62, null));
                            remoteViews.setTextViewTextSize(R.id.ticket_nowbar_header, 2, 14.0f);
                            remoteViews.setTextViewTextSize(R.id.ticket_nowbar_primary, 2, 17.0f);
                            remoteViews.setTextViewTextSize(R.id.ticket_nowbar_details, 2, 13.0f);
                            remoteViews.setTextViewText(R.id.ticket_nowbar_secondary, str3);
                            remoteViews.setTextViewText(R.id.ticket_nowbar_expanded, str3);
                            remoteViews.setViewVisibility(R.id.ticket_nowbar_secondary, 8);
                            remoteViews.setViewVisibility(R.id.ticket_nowbar_expanded, 8);
                            notificationBuildNotification.extras.putParcelable("android.ongoingActivityNoti.chronometerRemoteView", remoteViews);
                            bundle.putInt(EXTRA_REMOTE_VIEW_POSITION, 1);
                            bundle.putString(EXTRA_REMOTE_VIEW_TAG, "tickets_nowbar_screenshot_text");
                            bundle.putInt(EXTRA_NOWBAR_CHRONOMETER_POSITION, 1);
                        } catch (Throwable unused2) {
                            i = 0;
                            bundle.putInt(EXTRA_REMOTE_VIEW_POSITION, i);
                            bundle.putString(EXTRA_REMOTE_VIEW_TAG, "tickets_nowbar_screenshot_text_fallback");
                        }
                    } catch (Throwable unused3) {
                        context2 = context;
                        ticketData = ticket;
                    }
                } else {
                    context2 = context;
                    ticketData = ticket;
                    bundle.putInt(EXTRA_REMOTE_VIEW_POSITION, 0);
                    bundle.putString(EXTRA_REMOTE_VIEW_TAG, "tickets_nowbar_liveupdate");
                }
                bundle.putBoolean(EXTRA_SHOW_SMALL_ICON, true);
                PendingIntent pendingIntentCreateNowBarContentPendingIntent = INSTANCE.createNowBarContentPendingIntent(context2, ticketData.getId());
                charSequenceLoadLabel = context2.getApplicationInfo().loadLabel(context2.getPackageManager());
                if (charSequenceLoadLabel != null && (string = charSequenceLoadLabel.toString()) != null) {
                    str6 = string;
                    if (StringsKt.isBlank(str6)) {
                        str8 = str6;
                    }
                    str8 = str8;
                }
                String str12 = str8;
                bundle.putCharSequence(EXTRA_AOD_REMOTE_APP_NAME, str12);
                if (context2.getApplicationInfo().icon != 0) {
                    bundle.putParcelable(EXTRA_AOD_REMOTE_APP_ICON, Icon.createWithResource(context2, context2.getApplicationInfo().icon));
                }
                bundle.putParcelable(EXTRA_AOD_REMOTE_APP_PENDING_INTENT, pendingIntentCreateNowBarContentPendingIntent);
                bundle.putParcelable(EXTRA_SUBSCREEN_PENDING_INTENT, pendingIntentCreateNowBarContentPendingIntent);
                bundle.putString(EXTRA_SUBST_NAME, str12);
                if (isDynamicNowBarTicket(ticketData.getType())) {
                    Pair<Long, Long> pairResolveWindow3 = resolveWindow(payload);
                    jLongValue3 = pairResolveWindow3.component1().longValue();
                    long jLongValue7 = pairResolveWindow3.component2().longValue();
                    if (jLongValue3 != Long.MAX_VALUE || jLongValue7 <= jLongValue3) {
                        str5 = "build(...)";
                    } else {
                        try {
                            Notification notificationBuild = Notification.Builder.recoverBuilder(context2, notificationBuildNotification).setWhen(jLongValue7).setShowWhen(true).setUsesChronometer(true).setChronometerCountDown(true).build();
                            str5 = "build(...)";
                            try {
                                Intrinsics.checkNotNullExpressionValue(notificationBuild, str5);
                                notificationBuildNotification = notificationBuild;
                            } catch (Throwable unused4) {
                            }
                        } catch (Throwable unused5) {
                            str5 = "build(...)";
                        }
                    }
                } else {
                    str5 = "build(...)";
                }
                if (isDynamicNowBarTicket(ticketData.getType())) {
                    return notificationBuildNotification;
                }
                Pair<Long, Long> pairResolveWindow4 = resolveWindow(payload);
                jLongValue2 = pairResolveWindow4.component1().longValue();
                long jLongValue8 = pairResolveWindow4.component2().longValue();
                if (jLongValue2 != Long.MAX_VALUE || jLongValue8 <= jLongValue2) {
                    j = Long.MAX_VALUE;
                } else {
                    j = jLongValue8 + 300000;
                }
                if (j != Long.MAX_VALUE) {
                    return notificationBuildNotification;
                }
                Notification notificationBuild2 = Notification.Builder.recoverBuilder(context2, notificationBuildNotification).setTimeoutAfter(RangesKt.coerceAtLeast(j - System.currentTimeMillis(), 1000L)).build();
                Intrinsics.checkNotNullExpressionValue(notificationBuild2, str5);
                return notificationBuild2;
            }
            str = "";
            PendingIntent pendingIntentCreateNowBarContentPendingIntent2 = INSTANCE.createNowBarContentPendingIntent(context2, ticketData.getId());
            charSequenceLoadLabel = context2.getApplicationInfo().loadLabel(context2.getPackageManager());
            if (charSequenceLoadLabel != null) {
                str6 = string;
                if (StringsKt.isBlank(str6)) {
                    str8 = str6;
                }
                str8 = str8;
            }
            String str13 = str8;
            bundle.putCharSequence(EXTRA_AOD_REMOTE_APP_NAME, str13);
            if (context2.getApplicationInfo().icon != 0) {
                bundle.putParcelable(EXTRA_AOD_REMOTE_APP_ICON, Icon.createWithResource(context2, context2.getApplicationInfo().icon));
            }
            bundle.putParcelable(EXTRA_AOD_REMOTE_APP_PENDING_INTENT, pendingIntentCreateNowBarContentPendingIntent2);
            bundle.putParcelable(EXTRA_SUBSCREEN_PENDING_INTENT, pendingIntentCreateNowBarContentPendingIntent2);
            bundle.putString(EXTRA_SUBST_NAME, str13);
        } catch (Throwable unused6) {
        }
        z = true;
        bundle.putParcelable(EXTRA_FIRST_ICON, samsungNowBarManager.createSamsungCardIcon(context, payload, iSelectSmallIconRes, z));
        charSequence = notificationBuildNotification.extras.getCharSequence(NotificationCompat.EXTRA_TITLE);
        if (charSequence != null) {
            str2 = str9;
        } else {
            str2 = str9;
        }
        bundle.putString(EXTRA_PRIMARY_INFO, str2);
        bundle.putCharSequence(EXTRA_SECONDARY_INFO, str10);
        if (Intrinsics.areEqual(payload.getTicketType(), "取餐码")) {
            Pair<Long, Long> pairResolveWindow5 = samsungNowBarManager.resolveWindow(payload);
            jLongValue = pairResolveWindow5.component1().longValue();
            long jLongValue9 = pairResolveWindow5.component2().longValue();
            if (jLongValue != Long.MAX_VALUE) {
                iCoerceIn = 0;
            } else {
                iCoerceIn = 0;
            }
        } else {
            Pair<Long, Long> pairResolveWindow6 = samsungNowBarManager.resolveWindow(payload);
            jLongValue = pairResolveWindow6.component1().longValue();
            long jLongValue10 = pairResolveWindow6.component2().longValue();
            if (jLongValue != Long.MAX_VALUE) {
                iCoerceIn = 0;
            } else {
                iCoerceIn = 0;
            }
        }
        bundle.putInt(EXTRA_PROGRESS, iCoerceIn);
        bundle.putInt(EXTRA_PROGRESS_MAX, 100);
        bundle.putInt(EXTRA_STYLE, 1);
        bundle.putString(EXTRA_CHIP_EXPANDED_TEXT, str9);
        bundle.putInt(EXTRA_ACTION_TYPE, 0);
        bundle.putInt(EXTRA_ACTION_BG_COLOR, 0);
        bundle.putInt(EXTRA_CHIP_BG_COLOR, samsungNowBarManager.notificationAccentColor(payload.getTicketType()));
        if (!Intrinsics.areEqual(payload.getTicketType(), "取餐码")) {
            Intrinsics.areEqual(payload.getTicketType(), "取件码");
        }
        bundle.putInt(EXTRA_ACTION_TYPE, 1);
        bundle.putInt(EXTRA_ACTION_BG_COLOR, samsungNowBarManager.notificationAccentColor(payload.getTicketType()));
        bundle.putInt(EXTRA_ACTION_PRIMARY_SET, 0);
        if (Intrinsics.areEqual(payload.getTicketType(), "取餐码")) {
            z2 = true;
        } else {
            z2 = true;
        }
        str3 = str;
        bundle.putString(EXTRA_PRIMARY_INFO, str3);
        bundle.putCharSequence(EXTRA_SECONDARY_INFO, str3);
        if (z2) {
            if (Intrinsics.areEqual(payload.getTicketType(), "取餐码")) {
                z3 = true;
            } else {
                z3 = true;
            }
            if (z3) {
                i2 = R.layout.ticket_samsung_nowbar_remote;
            } else {
                i2 = R.layout.ticket_samsung_nowbar_remote;
            }
            remoteViews = new RemoteViews(context.getPackageName(), i2);
            if (z3) {
                i = 0;
                remoteViews.setInt(R.id.ticket_nowbar_root, "setMinimumHeight", 0);
            }
            String ticketType3 = payload.getTicketType();
            ticketType = payload.getTicketType();
            switch (ticketType.hashCode()) {
                case 850286:
                    if (!ticketType.equals("机票")) {
                        code = payload.getCode();
                        if (StringsKt.isBlank(code)) {
                            code = payload.getTitle();
                        }
                        title2 = code;
                    } else {
                        title2 = payload.getTitle();
                    }
                    break;
                case 1169090:
                    if (!ticketType.equals("车票")) {
                        code = payload.getCode();
                        if (StringsKt.isBlank(code)) {
                            code = payload.getTitle();
                        }
                        title2 = code;
                    } else {
                        title2 = payload.getTitle();
                    }
                    break;
                case 21282337:
                    if (!ticketType.equals("取件码")) {
                        code = payload.getCode();
                        if (StringsKt.isBlank(code)) {
                            code = payload.getTitle();
                        }
                        title2 = code;
                    } else {
                        title2 = payload.getTitle();
                    }
                    break;
                case 21870407:
                    if (!ticketType.equals("取餐码")) {
                        code = payload.getCode();
                        if (StringsKt.isBlank(code)) {
                            code = payload.getTitle();
                        }
                        title2 = code;
                    } else {
                        title2 = payload.getTitle();
                    }
                    break;
                case 28825709:
                    if (ticketType.equals("火车票")) {
                        code = payload.getCode();
                        if (StringsKt.isBlank(code)) {
                            code = payload.getTitle();
                        }
                        title2 = code;
                    } else {
                        title2 = payload.getTitle();
                    }
                    break;
                case 29623308:
                    if (!ticketType.equals("电影票")) {
                        title3 = payload.getTitle();
                        if (StringsKt.isBlank(title3)) {
                            charSequence2 = notificationBuildNotification.extras.getCharSequence(NotificationCompat.EXTRA_TITLE);
                            if (charSequence2 != null) {
                                title3 = charSequence2.toString();
                            } else {
                                title3 = null;
                            }
                            if (title3 == null) {
                                title3 = str3;
                            }
                        }
                        title2 = title3;
                    } else {
                        title2 = payload.getTitle();
                    }
                    break;
                default:
                    title2 = payload.getTitle();
                    break;
            }
            str4 = title2;
            if (StringsKt.isBlank(str4)) {
                str4 = "票据";
            }
            remoteViews.setTextViewText(R.id.ticket_nowbar_header, ticketType3);
            remoteViews.setTextViewText(R.id.ticket_nowbar_primary, str4);
            context2 = context;
            ticketData = ticket;
            List<String> listBuildSamsungRemoteDetailLines2 = samsungNowBarManager.buildSamsungRemoteDetailLines(context2, payload, ticketData, notificationBuildNotification);
            int i4 = R.id.ticket_nowbar_details;
            arrayList = new ArrayList();
            while (r8.hasNext()) {
                if (!StringsKt.isBlank((String) obj)) {
                    arrayList.add(obj);
                }
            }
            remoteViews.setTextViewText(i4, CollectionsKt.joinToString$default(arrayList, "\n", null, null, 0, null, null, 62, null));
            remoteViews.setTextViewTextSize(R.id.ticket_nowbar_header, 2, 14.0f);
            remoteViews.setTextViewTextSize(R.id.ticket_nowbar_primary, 2, 17.0f);
            remoteViews.setTextViewTextSize(R.id.ticket_nowbar_details, 2, 13.0f);
            remoteViews.setTextViewText(R.id.ticket_nowbar_secondary, str3);
            remoteViews.setTextViewText(R.id.ticket_nowbar_expanded, str3);
            remoteViews.setViewVisibility(R.id.ticket_nowbar_secondary, 8);
            remoteViews.setViewVisibility(R.id.ticket_nowbar_expanded, 8);
            notificationBuildNotification.extras.putParcelable("android.ongoingActivityNoti.chronometerRemoteView", remoteViews);
            bundle.putInt(EXTRA_REMOTE_VIEW_POSITION, 1);
            bundle.putString(EXTRA_REMOTE_VIEW_TAG, "tickets_nowbar_screenshot_text");
            bundle.putInt(EXTRA_NOWBAR_CHRONOMETER_POSITION, 1);
        } else {
            context2 = context;
            ticketData = ticket;
            bundle.putInt(EXTRA_REMOTE_VIEW_POSITION, 0);
            bundle.putString(EXTRA_REMOTE_VIEW_TAG, "tickets_nowbar_liveupdate");
        }
        bundle.putBoolean(EXTRA_SHOW_SMALL_ICON, true);
        if (isDynamicNowBarTicket(ticketData.getType())) {
            Pair<Long, Long> pairResolveWindow7 = resolveWindow(payload);
            jLongValue3 = pairResolveWindow7.component1().longValue();
            long jLongValue11 = pairResolveWindow7.component2().longValue();
            if (jLongValue3 != Long.MAX_VALUE) {
                str5 = "build(...)";
            } else {
                str5 = "build(...)";
            }
        } else {
            str5 = "build(...)";
        }
        if (isDynamicNowBarTicket(ticketData.getType())) {
            return notificationBuildNotification;
        }
        Pair<Long, Long> pairResolveWindow8 = resolveWindow(payload);
        jLongValue2 = pairResolveWindow8.component1().longValue();
        long jLongValue12 = pairResolveWindow8.component2().longValue();
        if (jLongValue2 != Long.MAX_VALUE) {
            j = Long.MAX_VALUE;
        } else {
            j = Long.MAX_VALUE;
        }
        if (j != Long.MAX_VALUE) {
            return notificationBuildNotification;
        }
        Notification notificationBuild3 = Notification.Builder.recoverBuilder(context2, notificationBuildNotification).setTimeoutAfter(RangesKt.coerceAtLeast(j - System.currentTimeMillis(), 1000L)).build();
        Intrinsics.checkNotNullExpressionValue(notificationBuild3, str5);
        return notificationBuild3;
    }

    private final String buildExpandedFallbackText(Notification notification, LiveUpdatePayload payload, TicketData ticket) {
        List listListOf;
        CharSequence charSequence = notification.extras.getCharSequence(NotificationCompat.EXTRA_TITLE);
        String string = charSequence != null ? charSequence.toString() : null;
        if (string == null) {
            string = "";
        }
        String title = string;
        if (StringsKt.isBlank(title)) {
            int i = WhenMappings.$EnumSwitchMapping$0[ticket.getType().ordinal()];
            if (i == 1 || i == 2 || i == 3 || i == 4) {
                String code = ticket.getCode();
                if (StringsKt.isBlank(code)) {
                    code = ticket.getTitle();
                }
                title = code;
            } else {
                title = ticket.getTitle();
            }
        }
        String str = title;
        CharSequence charSequence2 = notification.extras.getCharSequence(NotificationCompat.EXTRA_TEXT);
        String string2 = charSequence2 != null ? charSequence2.toString() : null;
        String str2 = string2 != null ? string2 : "";
        List listListOf2 = CollectionsKt.listOf((Object[]) new String[]{payload.getFrom(), payload.getTo()});
        ArrayList arrayList = new ArrayList();
        for (Object obj : listListOf2) {
            if (!StringsKt.isBlank((String) obj)) {
                arrayList.add(obj);
            }
        }
        String strJoinToString$default = CollectionsKt.joinToString$default(arrayList, " → ", null, null, 0, null, null, 62, null);
        switch (WhenMappings.$EnumSwitchMapping$0[ticket.getType().ordinal()]) {
            case 1:
                String str3 = !StringsKt.isBlank(strJoinToString$default) ? strJoinToString$default : null;
                String departureDate = ticket.getDepartureDate();
                if (StringsKt.isBlank(departureDate)) {
                    departureDate = ticket.getDate();
                }
                if (StringsKt.isBlank(departureDate)) {
                    departureDate = null;
                }
                String str4 = departureDate;
                String str5 = str4 != null ? "出发日期 " + str4 : null;
                String startTime = ticket.getStartTime();
                if (StringsKt.isBlank(startTime)) {
                    startTime = ticket.getTime();
                }
                if (StringsKt.isBlank(startTime)) {
                    startTime = null;
                }
                String str6 = startTime;
                String str7 = str6 != null ? "出发 " + str6 : null;
                String departurePlatform = ticket.getDeparturePlatform();
                if (StringsKt.isBlank(departurePlatform)) {
                    departurePlatform = null;
                }
                String str8 = departurePlatform != null ? "出发站台 " + departurePlatform : null;
                String departureGate = ticket.getDepartureGate();
                if (StringsKt.isBlank(departureGate)) {
                    departureGate = null;
                }
                String str9 = departureGate != null ? "出发口 " + departureGate : null;
                String arrivalDate = ticket.getArrivalDate();
                if (StringsKt.isBlank(arrivalDate)) {
                    String departureDate2 = ticket.getDepartureDate();
                    if (StringsKt.isBlank(departureDate2)) {
                        departureDate2 = ticket.getDate();
                    }
                    arrivalDate = departureDate2;
                }
                if (StringsKt.isBlank(arrivalDate)) {
                    arrivalDate = null;
                }
                String str10 = arrivalDate;
                String str11 = str10 != null ? "到达日期 " + str10 : null;
                String endTime = ticket.getEndTime();
                if (StringsKt.isBlank(endTime)) {
                    endTime = null;
                }
                String str12 = endTime != null ? "到达 " + endTime : null;
                String arrivalPlatform = ticket.getArrivalPlatform();
                if (StringsKt.isBlank(arrivalPlatform)) {
                    arrivalPlatform = null;
                }
                String str13 = arrivalPlatform != null ? "到达站台 " + arrivalPlatform : null;
                String arrivalGate = ticket.getArrivalGate();
                if (StringsKt.isBlank(arrivalGate)) {
                    arrivalGate = null;
                }
                String str14 = arrivalGate != null ? "到达口 " + arrivalGate : null;
                String area = ticket.getArea();
                if (StringsKt.isBlank(area)) {
                    area = null;
                }
                String str15 = area != null ? "区域 " + area : null;
                String seat = ticket.getSeat();
                if (StringsKt.isBlank(seat)) {
                    seat = null;
                }
                listListOf = CollectionsKt.listOf((Object[]) new String[]{str3, str5, str7, str8, str9, str11, str12, str13, str14, str15, seat != null ? "座位 " + seat : null});
                break;
            case 2:
                String str16 = !StringsKt.isBlank(strJoinToString$default) ? strJoinToString$default : null;
                String departureDate3 = ticket.getDepartureDate();
                if (StringsKt.isBlank(departureDate3)) {
                    departureDate3 = ticket.getDate();
                }
                if (StringsKt.isBlank(departureDate3)) {
                    departureDate3 = null;
                }
                String str17 = departureDate3;
                String str18 = str17 != null ? "出发日期 " + str17 : null;
                String startTime2 = ticket.getStartTime();
                if (StringsKt.isBlank(startTime2)) {
                    startTime2 = ticket.getTime();
                }
                if (StringsKt.isBlank(startTime2)) {
                    startTime2 = null;
                }
                String str19 = startTime2;
                String str20 = str19 != null ? "出发 " + str19 : null;
                String takeoffTime = ticket.getTakeoffTime();
                if (StringsKt.isBlank(takeoffTime)) {
                    takeoffTime = null;
                }
                String str21 = takeoffTime != null ? "起飞 " + takeoffTime : null;
                String departureGate2 = ticket.getDepartureGate();
                if (StringsKt.isBlank(departureGate2)) {
                    departureGate2 = null;
                }
                String str22 = departureGate2 != null ? "登机口 " + departureGate2 : null;
                String arrivalDate2 = ticket.getArrivalDate();
                if (StringsKt.isBlank(arrivalDate2)) {
                    String departureDate4 = ticket.getDepartureDate();
                    if (StringsKt.isBlank(departureDate4)) {
                        departureDate4 = ticket.getDate();
                    }
                    arrivalDate2 = departureDate4;
                }
                if (StringsKt.isBlank(arrivalDate2)) {
                    arrivalDate2 = null;
                }
                String str23 = arrivalDate2;
                String str24 = str23 != null ? "到达日期 " + str23 : null;
                String endTime2 = ticket.getEndTime();
                if (StringsKt.isBlank(endTime2)) {
                    endTime2 = null;
                }
                String str25 = endTime2 != null ? "到达 " + endTime2 : null;
                String landingTime = ticket.getLandingTime();
                if (StringsKt.isBlank(landingTime)) {
                    landingTime = null;
                }
                String str26 = landingTime != null ? "降落 " + landingTime : null;
                String arrivalGate2 = ticket.getArrivalGate();
                if (StringsKt.isBlank(arrivalGate2)) {
                    arrivalGate2 = null;
                }
                String str27 = arrivalGate2 != null ? "到达口 " + arrivalGate2 : null;
                String area2 = ticket.getArea();
                if (StringsKt.isBlank(area2)) {
                    area2 = null;
                }
                String str28 = area2 != null ? "区域 " + area2 : null;
                String seat2 = ticket.getSeat();
                if (StringsKt.isBlank(seat2)) {
                    seat2 = null;
                }
                listListOf = CollectionsKt.listOf((Object[]) new String[]{str16, str18, str20, str21, str22, str24, str25, str26, str27, str28, seat2 != null ? "座位 " + seat2 : null});
                break;
            case 3:
                String code2 = ticket.getCode();
                if (StringsKt.isBlank(code2)) {
                    code2 = null;
                }
                String str29 = code2 != null ? "取餐码 " + code2 : null;
                String brand = ticket.getBrand();
                if (StringsKt.isBlank(brand)) {
                    brand = null;
                }
                String str30 = brand != null ? "品牌 " + brand : null;
                String title2 = ticket.getTitle();
                if (StringsKt.isBlank(title2)) {
                    title2 = null;
                }
                String str31 = title2 != null ? "名称 " + title2 : null;
                String venue = ticket.getVenue();
                if (StringsKt.isBlank(venue)) {
                    venue = null;
                }
                String str32 = venue != null ? "门店 " + venue : null;
                String date = ticket.getDate();
                if (StringsKt.isBlank(date)) {
                    date = null;
                }
                String str33 = date != null ? "日期 " + date : null;
                String time = ticket.getTime();
                if (StringsKt.isBlank(time)) {
                    time = null;
                }
                String str34 = time != null ? "时间 " + time : null;
                String area3 = ticket.getArea();
                if (StringsKt.isBlank(area3)) {
                    area3 = null;
                }
                String str35 = area3 != null ? "区域 " + area3 : null;
                String entry = ticket.getEntry();
                if (StringsKt.isBlank(entry)) {
                    entry = null;
                }
                listListOf = CollectionsKt.listOf((Object[]) new String[]{str29, str30, str31, str32, str33, str34, str35, entry != null ? "入口 " + entry : null});
                break;
            case 4:
                String code3 = ticket.getCode();
                if (StringsKt.isBlank(code3)) {
                    code3 = null;
                }
                String str36 = code3 != null ? "取件码 " + code3 : null;
                String brand2 = ticket.getBrand();
                if (StringsKt.isBlank(brand2)) {
                    brand2 = null;
                }
                String str37 = brand2 != null ? "品牌 " + brand2 : null;
                String title3 = ticket.getTitle();
                if (StringsKt.isBlank(title3)) {
                    title3 = null;
                }
                String str38 = title3 != null ? "名称 " + title3 : null;
                String venue2 = ticket.getVenue();
                if (StringsKt.isBlank(venue2)) {
                    venue2 = null;
                }
                String str39 = venue2 != null ? "地点 " + venue2 : null;
                String date2 = ticket.getDate();
                if (StringsKt.isBlank(date2)) {
                    date2 = null;
                }
                String str40 = date2 != null ? "日期 " + date2 : null;
                String time2 = ticket.getTime();
                if (StringsKt.isBlank(time2)) {
                    time2 = null;
                }
                String str41 = time2 != null ? "时间 " + time2 : null;
                String area4 = ticket.getArea();
                if (StringsKt.isBlank(area4)) {
                    area4 = null;
                }
                String str42 = area4 != null ? "区域 " + area4 : null;
                String entry2 = ticket.getEntry();
                if (StringsKt.isBlank(entry2)) {
                    entry2 = null;
                }
                listListOf = CollectionsKt.listOf((Object[]) new String[]{str36, str37, str38, str39, str40, str41, str42, entry2 != null ? "入口 " + entry2 : null});
                break;
            case 5:
                String venue3 = ticket.getVenue();
                if (StringsKt.isBlank(venue3)) {
                    venue3 = null;
                }
                String str43 = venue3 != null ? "影院 " + venue3 : null;
                String date3 = ticket.getDate();
                if (StringsKt.isBlank(date3)) {
                    date3 = null;
                }
                String str44 = date3 != null ? "日期 " + date3 : null;
                String startTime3 = ticket.getStartTime();
                if (StringsKt.isBlank(startTime3)) {
                    startTime3 = ticket.getTime();
                }
                if (StringsKt.isBlank(startTime3)) {
                    startTime3 = null;
                }
                String str45 = startTime3;
                String str46 = str45 != null ? "开始 " + str45 : null;
                String endTime3 = ticket.getEndTime();
                if (StringsKt.isBlank(endTime3)) {
                    endTime3 = null;
                }
                String str47 = endTime3 != null ? "结束 " + endTime3 : null;
                String hall = ticket.getHall();
                if (StringsKt.isBlank(hall)) {
                    hall = null;
                }
                String str48 = hall != null ? "影厅 " + hall : null;
                String area5 = ticket.getArea();
                if (StringsKt.isBlank(area5)) {
                    area5 = null;
                }
                String str49 = area5 != null ? "区域 " + area5 : null;
                String seat3 = ticket.getSeat();
                if (StringsKt.isBlank(seat3)) {
                    seat3 = null;
                }
                listListOf = CollectionsKt.listOf((Object[]) new String[]{str43, str44, str46, str47, str48, str49, seat3 != null ? "座位 " + seat3 : null});
                break;
            case 6:
                String venue4 = ticket.getVenue();
                if (StringsKt.isBlank(venue4)) {
                    venue4 = null;
                }
                String str50 = venue4 != null ? "地点 " + venue4 : null;
                String date4 = ticket.getDate();
                if (StringsKt.isBlank(date4)) {
                    date4 = null;
                }
                String str51 = date4 != null ? "日期 " + date4 : null;
                String startTime4 = ticket.getStartTime();
                if (StringsKt.isBlank(startTime4)) {
                    startTime4 = null;
                }
                String str52 = startTime4 != null ? "开始 " + startTime4 : null;
                String endTime4 = ticket.getEndTime();
                if (StringsKt.isBlank(endTime4)) {
                    endTime4 = null;
                }
                String str53 = endTime4 != null ? "结束 " + endTime4 : null;
                String area6 = ticket.getArea();
                if (StringsKt.isBlank(area6)) {
                    area6 = null;
                }
                String str54 = area6 != null ? "区域 " + area6 : null;
                String entry3 = ticket.getEntry();
                if (StringsKt.isBlank(entry3)) {
                    entry3 = null;
                }
                String str55 = entry3 != null ? "入口 " + entry3 : null;
                String seat4 = ticket.getSeat();
                if (StringsKt.isBlank(seat4)) {
                    seat4 = null;
                }
                listListOf = CollectionsKt.listOf((Object[]) new String[]{str50, str51, str52, str53, str54, str55, seat4 != null ? "座位 " + seat4 : null});
                break;
            case 7:
                String venue5 = ticket.getVenue();
                if (StringsKt.isBlank(venue5)) {
                    venue5 = null;
                }
                String str56 = venue5 != null ? "地点 " + venue5 : null;
                String date5 = ticket.getDate();
                if (StringsKt.isBlank(date5)) {
                    date5 = null;
                }
                String str57 = date5 != null ? "日期 " + date5 : null;
                String time3 = ticket.getTime();
                if (StringsKt.isBlank(time3)) {
                    time3 = null;
                }
                String str58 = time3 != null ? "时间 " + time3 : null;
                String entry4 = ticket.getEntry();
                if (StringsKt.isBlank(entry4)) {
                    entry4 = null;
                }
                String str59 = entry4 != null ? "入口 " + entry4 : null;
                String area7 = ticket.getArea();
                if (StringsKt.isBlank(area7)) {
                    area7 = null;
                }
                String str60 = area7 != null ? "区域 " + area7 : null;
                String seat5 = ticket.getSeat();
                if (StringsKt.isBlank(seat5)) {
                    seat5 = null;
                }
                listListOf = CollectionsKt.listOf((Object[]) new String[]{str56, str57, str58, str59, str60, seat5 != null ? "座位 " + seat5 : null});
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        List listFilterNotNull = CollectionsKt.filterNotNull(listListOf);
        ArrayList arrayList2 = new ArrayList();
        for (Object obj2 : listFilterNotNull) {
            if (!StringsKt.isBlank((String) obj2)) {
                arrayList2.add(obj2);
            }
        }
        List listListOf3 = CollectionsKt.listOf((Object[]) new String[]{str, str2, CollectionsKt.joinToString$default(arrayList2, "  ·  ", null, null, 0, null, null, 62, null)});
        ArrayList arrayList3 = new ArrayList();
        for (Object obj3 : listListOf3) {
            if (!StringsKt.isBlank((String) obj3)) {
                arrayList3.add(obj3);
            }
        }
        return CollectionsKt.joinToString$default(CollectionsKt.distinct(arrayList3), "\n", null, null, 0, null, null, 62, null);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:131:0x031a  */
    /* JADX WARN: Code duplicated, block: B:133:0x0323  */
    /* JADX WARN: Code duplicated, block: B:137:0x0353  */
    /* JADX WARN: Code duplicated, block: B:139:0x0356  */
    /* JADX WARN: Code duplicated, block: B:140:0x0363  */
    /* JADX WARN: Code duplicated, block: B:144:0x036e  */
    /* JADX WARN: Code duplicated, block: B:146:0x0371  */
    /* JADX WARN: Code duplicated, block: B:147:0x037e  */
    /* JADX WARN: Code duplicated, block: B:156:0x03c4  */
    /* JADX WARN: Code duplicated, block: B:159:0x03d6  */
    /* JADX WARN: Code duplicated, block: B:163:0x03e6  */
    /* JADX WARN: Code duplicated, block: B:167:0x03f5  */
    /* JADX WARN: Code duplicated, block: B:169:0x03f8  */
    /* JADX WARN: Code duplicated, block: B:170:0x0405  */
    /* JADX WARN: Code duplicated, block: B:174:0x0414  */
    /* JADX WARN: Code duplicated, block: B:176:0x0417  */
    /* JADX WARN: Code duplicated, block: B:177:0x0426  */
    /* JADX WARN: Code duplicated, block: B:181:0x0435  */
    /* JADX WARN: Code duplicated, block: B:183:0x0438  */
    /* JADX WARN: Code duplicated, block: B:184:0x0447  */
    /* JADX WARN: Code duplicated, block: B:188:0x0456  */
    /* JADX WARN: Code duplicated, block: B:190:0x0459  */
    /* JADX WARN: Code duplicated, block: B:193:0x0488  */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Instruction removed from duplicated block: B:139:0x0356, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:146:0x0371, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:169:0x03f8, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:176:0x0417, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:183:0x0438, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:190:0x0459, please report this as an issue */
    private final List<String> buildSamsungRemoteDetailLines(Context context, LiveUpdatePayload payload, TicketData ticket, Notification notification) {
        LiveUpdatePayload liveUpdatePayload;
        String string;
        String strBuildSamsungRemoteDetailLines$dateOrFallback;
        String strBuildSamsungRemoteDetailLines$dateOrFallback2;
        String str;
        String str2;
        String strJoinToString$default;
        String startTime;
        String str3;
        String endTime;
        String str4;
        String departurePlatform;
        String str5;
        String arrivalPlatform;
        String str6;
        String seat;
        String strJoinToString$default2;
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (Intrinsics.areEqual(payload.getTicketType(), "取餐码") || Intrinsics.areEqual(payload.getTicketType(), "取件码") || Intrinsics.areEqual(payload.getTicketType(), "演出") || Intrinsics.areEqual(payload.getTicketType(), "门票")) {
            liveUpdatePayload = payload;
            long jCoerceAtLeast = RangesKt.coerceAtLeast(resolveWindow(liveUpdatePayload).component2().longValue() - jCurrentTimeMillis, 0L) / 60000;
            long j = jCoerceAtLeast / 60;
            long j2 = jCoerceAtLeast % 60;
            string = j > 0 ? "今日有效 · 距今天结束还有 " + j + "小时" + j2 + "分" : "今日有效 · 距今天结束还有 " + j2 + "分";
        } else {
            CharSequence charSequence = notification.extras.getCharSequence(NotificationCompat.EXTRA_TEXT);
            string = charSequence != null ? charSequence.toString() : null;
            if (string == null) {
                string = "";
            }
            liveUpdatePayload = payload;
        }
        List listListOf = CollectionsKt.listOf((Object[]) new String[]{liveUpdatePayload.getFrom(), liveUpdatePayload.getTo()});
        ArrayList arrayList = new ArrayList();
        for (Object obj : listListOf) {
            if (!StringsKt.isBlank((String) obj)) {
                arrayList.add(obj);
            }
        }
        String strJoinToString$default3 = CollectionsKt.joinToString$default(arrayList, " → ", null, null, 0, null, null, 62, null);
        ArrayList arrayList2 = new ArrayList();
        if (!StringsKt.isBlank(string)) {
            arrayList2.add(string);
        }
        String ticketType = liveUpdatePayload.getTicketType();
        String str7 = "出发";
        switch (ticketType.hashCode()) {
            case 850286:
                if (ticketType.equals("机票")) {
                    if (!StringsKt.isBlank(strJoinToString$default3)) {
                        arrayList2.add(strJoinToString$default3);
                    }
                    String strBuildSamsungRemoteDetailLines$dateOrFallback3 = buildSamsungRemoteDetailLines$dateOrFallback(liveUpdatePayload.getDepartureDate(), liveUpdatePayload.getDate());
                    String strBuildSamsungRemoteDetailLines$dateOrFallback4 = buildSamsungRemoteDetailLines$dateOrFallback(liveUpdatePayload.getArrivalDate(), buildSamsungRemoteDetailLines$dateOrFallback(liveUpdatePayload.getDepartureDate(), liveUpdatePayload.getDate()));
                    if (StringsKt.isBlank(strBuildSamsungRemoteDetailLines$dateOrFallback3)) {
                        strBuildSamsungRemoteDetailLines$dateOrFallback3 = null;
                    }
                    String str8 = strBuildSamsungRemoteDetailLines$dateOrFallback3 != null ? "出发日期 " + strBuildSamsungRemoteDetailLines$dateOrFallback3 : null;
                    if (StringsKt.isBlank(strBuildSamsungRemoteDetailLines$dateOrFallback4)) {
                        strBuildSamsungRemoteDetailLines$dateOrFallback4 = null;
                    }
                    String str9 = strBuildSamsungRemoteDetailLines$dateOrFallback4 != null ? "到达日期 " + strBuildSamsungRemoteDetailLines$dateOrFallback4 : null;
                    if (StringsKt.isBlank(liveUpdatePayload.getStartTime()) && StringsKt.isBlank(liveUpdatePayload.getTime())) {
                        str7 = null;
                    }
                    String strJoinToString$default4 = CollectionsKt.joinToString$default(CollectionsKt.listOfNotNull((Object[]) new String[]{str8, str9, str7}), " · ", null, null, 0, null, null, 62, null);
                    if (!StringsKt.isBlank(strJoinToString$default4)) {
                        arrayList2.add(strJoinToString$default4);
                    }
                    String startTime2 = liveUpdatePayload.getStartTime();
                    if (StringsKt.isBlank(startTime2)) {
                        startTime2 = liveUpdatePayload.getTime();
                    }
                    String str10 = startTime2;
                    if (StringsKt.isBlank(str10)) {
                        str10 = null;
                    }
                    String endTime2 = liveUpdatePayload.getEndTime();
                    if (StringsKt.isBlank(endTime2)) {
                        endTime2 = null;
                    }
                    String str11 = endTime2 != null ? "到达 " + endTime2 : null;
                    String seat2 = liveUpdatePayload.getSeat();
                    if (StringsKt.isBlank(seat2)) {
                        seat2 = null;
                    }
                    String strJoinToString$default5 = CollectionsKt.joinToString$default(CollectionsKt.listOfNotNull((Object[]) new String[]{str10, str11, seat2 != null ? "座位 " + seat2 : null}), " · ", null, null, 0, null, null, 62, null);
                    if (!StringsKt.isBlank(strJoinToString$default5)) {
                        arrayList2.add(strJoinToString$default5);
                    }
                }
                break;
            case 1169090:
                if (ticketType.equals("车票")) {
                    if (!StringsKt.isBlank(strJoinToString$default3)) {
                        arrayList2.add(strJoinToString$default3);
                    }
                    strBuildSamsungRemoteDetailLines$dateOrFallback = buildSamsungRemoteDetailLines$dateOrFallback(liveUpdatePayload.getDepartureDate(), liveUpdatePayload.getDate());
                    strBuildSamsungRemoteDetailLines$dateOrFallback2 = buildSamsungRemoteDetailLines$dateOrFallback(liveUpdatePayload.getArrivalDate(), buildSamsungRemoteDetailLines$dateOrFallback(liveUpdatePayload.getDepartureDate(), liveUpdatePayload.getDate()));
                    if (StringsKt.isBlank(strBuildSamsungRemoteDetailLines$dateOrFallback)) {
                        strBuildSamsungRemoteDetailLines$dateOrFallback = null;
                    }
                    if (strBuildSamsungRemoteDetailLines$dateOrFallback != null) {
                        str = "出发日期 " + strBuildSamsungRemoteDetailLines$dateOrFallback;
                    } else {
                        str = null;
                    }
                    if (StringsKt.isBlank(strBuildSamsungRemoteDetailLines$dateOrFallback2)) {
                        strBuildSamsungRemoteDetailLines$dateOrFallback2 = null;
                    }
                    if (strBuildSamsungRemoteDetailLines$dateOrFallback2 != null) {
                        str2 = "到达日期 " + strBuildSamsungRemoteDetailLines$dateOrFallback2;
                    } else {
                        str2 = null;
                    }
                    if (StringsKt.isBlank(liveUpdatePayload.getStartTime()) && StringsKt.isBlank(liveUpdatePayload.getTime())) {
                        str7 = null;
                    }
                    strJoinToString$default = CollectionsKt.joinToString$default(CollectionsKt.listOfNotNull((Object[]) new String[]{str, str2, str7}), " · ", null, null, 0, null, null, 62, null);
                    if (!StringsKt.isBlank(strJoinToString$default)) {
                        arrayList2.add(strJoinToString$default);
                    }
                    startTime = liveUpdatePayload.getStartTime();
                    if (StringsKt.isBlank(startTime)) {
                        startTime = liveUpdatePayload.getTime();
                    }
                    str3 = startTime;
                    if (StringsKt.isBlank(str3)) {
                        str3 = null;
                    }
                    endTime = liveUpdatePayload.getEndTime();
                    if (StringsKt.isBlank(endTime)) {
                        endTime = null;
                    }
                    if (endTime != null) {
                        str4 = "到达 " + endTime;
                    } else {
                        str4 = null;
                    }
                    departurePlatform = liveUpdatePayload.getDeparturePlatform();
                    if (StringsKt.isBlank(departurePlatform)) {
                        departurePlatform = null;
                    }
                    if (departurePlatform != null) {
                        str5 = "出发站台 " + departurePlatform;
                    } else {
                        str5 = null;
                    }
                    arrivalPlatform = liveUpdatePayload.getArrivalPlatform();
                    if (StringsKt.isBlank(arrivalPlatform)) {
                        arrivalPlatform = null;
                    }
                    if (arrivalPlatform != null) {
                        str6 = "到达站台 " + arrivalPlatform;
                    } else {
                        str6 = null;
                    }
                    seat = liveUpdatePayload.getSeat();
                    if (StringsKt.isBlank(seat)) {
                        seat = null;
                    }
                    strJoinToString$default2 = CollectionsKt.joinToString$default(CollectionsKt.listOfNotNull((Object[]) new String[]{str3, str4, str5, str6, seat != null ? "座位 " + seat : null}), " · ", null, null, 0, null, null, 62, null);
                    if (!StringsKt.isBlank(strJoinToString$default2)) {
                        arrayList2.add(strJoinToString$default2);
                    }
                }
                break;
            case 21282337:
                if (ticketType.equals("取件码")) {
                    String title = liveUpdatePayload.getTitle();
                    if (StringsKt.isBlank(title)) {
                        title = null;
                    }
                    String date = liveUpdatePayload.getDate();
                    if (StringsKt.isBlank(date)) {
                        date = null;
                    }
                    if (title != null || date != null) {
                        arrayList2.add(CollectionsKt.joinToString$default(CollectionsKt.listOfNotNull((Object[]) new String[]{title != null ? "名称 " + title : null, date != null ? "日期 " + date : null}), " · ", null, null, 0, null, null, 62, null));
                    }
                }
                break;
            case 21870407:
                if (ticketType.equals("取餐码")) {
                    String title2 = liveUpdatePayload.getTitle();
                    if (StringsKt.isBlank(title2)) {
                        title2 = null;
                    }
                    String date2 = liveUpdatePayload.getDate();
                    if (StringsKt.isBlank(date2)) {
                        date2 = null;
                    }
                    if (title2 != null || date2 != null) {
                        arrayList2.add(CollectionsKt.joinToString$default(CollectionsKt.listOfNotNull((Object[]) new String[]{title2 != null ? "名称 " + title2 : null, date2 != null ? "日期 " + date2 : null}), " · ", null, null, 0, null, null, 62, null));
                    }
                }
                break;
            case 28825709:
                if (ticketType.equals("火车票")) {
                    if (!StringsKt.isBlank(strJoinToString$default3)) {
                        arrayList2.add(strJoinToString$default3);
                    }
                    strBuildSamsungRemoteDetailLines$dateOrFallback = buildSamsungRemoteDetailLines$dateOrFallback(liveUpdatePayload.getDepartureDate(), liveUpdatePayload.getDate());
                    strBuildSamsungRemoteDetailLines$dateOrFallback2 = buildSamsungRemoteDetailLines$dateOrFallback(liveUpdatePayload.getArrivalDate(), buildSamsungRemoteDetailLines$dateOrFallback(liveUpdatePayload.getDepartureDate(), liveUpdatePayload.getDate()));
                    if (StringsKt.isBlank(strBuildSamsungRemoteDetailLines$dateOrFallback)) {
                        strBuildSamsungRemoteDetailLines$dateOrFallback = null;
                    }
                    if (strBuildSamsungRemoteDetailLines$dateOrFallback != null) {
                        str = "出发日期 " + strBuildSamsungRemoteDetailLines$dateOrFallback;
                    } else {
                        str = null;
                    }
                    if (StringsKt.isBlank(strBuildSamsungRemoteDetailLines$dateOrFallback2)) {
                        strBuildSamsungRemoteDetailLines$dateOrFallback2 = null;
                    }
                    if (strBuildSamsungRemoteDetailLines$dateOrFallback2 != null) {
                        str2 = "到达日期 " + strBuildSamsungRemoteDetailLines$dateOrFallback2;
                    } else {
                        str2 = null;
                    }
                    if (StringsKt.isBlank(liveUpdatePayload.getStartTime())) {
                        str7 = null;
                    }
                    strJoinToString$default = CollectionsKt.joinToString$default(CollectionsKt.listOfNotNull((Object[]) new String[]{str, str2, str7}), " · ", null, null, 0, null, null, 62, null);
                    if (!StringsKt.isBlank(strJoinToString$default)) {
                        arrayList2.add(strJoinToString$default);
                    }
                    startTime = liveUpdatePayload.getStartTime();
                    if (StringsKt.isBlank(startTime)) {
                        startTime = liveUpdatePayload.getTime();
                    }
                    str3 = startTime;
                    if (StringsKt.isBlank(str3)) {
                        str3 = null;
                    }
                    endTime = liveUpdatePayload.getEndTime();
                    if (StringsKt.isBlank(endTime)) {
                        endTime = null;
                    }
                    if (endTime != null) {
                        str4 = "到达 " + endTime;
                    } else {
                        str4 = null;
                    }
                    departurePlatform = liveUpdatePayload.getDeparturePlatform();
                    if (StringsKt.isBlank(departurePlatform)) {
                        departurePlatform = null;
                    }
                    if (departurePlatform != null) {
                        str5 = "出发站台 " + departurePlatform;
                    } else {
                        str5 = null;
                    }
                    arrivalPlatform = liveUpdatePayload.getArrivalPlatform();
                    if (StringsKt.isBlank(arrivalPlatform)) {
                        arrivalPlatform = null;
                    }
                    if (arrivalPlatform != null) {
                        str6 = "到达站台 " + arrivalPlatform;
                    } else {
                        str6 = null;
                    }
                    seat = liveUpdatePayload.getSeat();
                    if (StringsKt.isBlank(seat)) {
                        seat = null;
                    }
                    if (seat != null) {
                    }
                    strJoinToString$default2 = CollectionsKt.joinToString$default(CollectionsKt.listOfNotNull((Object[]) new String[]{str3, str4, str5, str6, seat != null ? "座位 " + seat : null}), " · ", null, null, 0, null, null, 62, null);
                    if (!StringsKt.isBlank(strJoinToString$default2)) {
                        arrayList2.add(strJoinToString$default2);
                    }
                }
                break;
            case 29623308:
                if (ticketType.equals("电影票")) {
                    String date3 = liveUpdatePayload.getDate();
                    if (StringsKt.isBlank(date3)) {
                        date3 = null;
                    }
                    String str12 = date3 != null ? "日期 " + date3 : null;
                    String startTime3 = liveUpdatePayload.getStartTime();
                    if (StringsKt.isBlank(startTime3)) {
                        startTime3 = liveUpdatePayload.getTime();
                    }
                    if (StringsKt.isBlank(startTime3)) {
                        startTime3 = null;
                    }
                    String str13 = startTime3;
                    String str14 = str13 != null ? "开始 " + str13 : null;
                    String endTime3 = liveUpdatePayload.getEndTime();
                    if (StringsKt.isBlank(endTime3)) {
                        endTime3 = null;
                    }
                    String strJoinToString$default6 = CollectionsKt.joinToString$default(CollectionsKt.listOfNotNull((Object[]) new String[]{str12, str14, endTime3 != null ? "结束 " + endTime3 : null}), " · ", null, null, 0, null, null, 62, null);
                    if (!StringsKt.isBlank(strJoinToString$default6)) {
                        arrayList2.add(strJoinToString$default6);
                    }
                    String hall = liveUpdatePayload.getHall();
                    if (StringsKt.isBlank(hall)) {
                        hall = null;
                    }
                    String str15 = hall != null ? "影厅 " + hall : null;
                    String seat3 = liveUpdatePayload.getSeat();
                    if (StringsKt.isBlank(seat3)) {
                        seat3 = null;
                    }
                    String strJoinToString$default7 = CollectionsKt.joinToString$default(CollectionsKt.listOfNotNull((Object[]) new String[]{str15, seat3 != null ? "座位 " + seat3 : null}), " · ", null, null, 0, null, null, 62, null);
                    if (!StringsKt.isBlank(strJoinToString$default7)) {
                        arrayList2.add(strJoinToString$default7);
                    }
                }
                break;
        }
        return arrayList2;
    }

    private static final String buildSamsungRemoteDetailLines$dateOrFallback(String str, String str2) {
        String str3 = str;
        if (!StringsKt.isBlank(str3)) {
            str2 = str3;
        }
        return str2;
    }

    private final int codeTicketProgress(LiveUpdatePayload payload) {
        Long dateTime = LiveUpdateManager.INSTANCE.parseDateTime(payload.getDate(), "00:00");
        if (dateTime == null) {
            return 0;
        }
        long jLongValue = dateTime.longValue();
        return RangesKt.coerceIn((int) ((RangesKt.coerceAtLeast(System.currentTimeMillis() - jLongValue, 0L) * 100) / RangesKt.coerceAtLeast((CalendarModelKt.MillisecondsIn24Hours + jLongValue) - jLongValue, 1L)), 0, 100);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Pair<Long, Long> resolveWindow(LiveUpdatePayload payload) {
        if (Intrinsics.areEqual(payload.getTicketType(), "取餐码") || Intrinsics.areEqual(payload.getTicketType(), "取件码")) {
            Long dateTime = LiveUpdateManager.INSTANCE.parseDateTime(payload.getDate(), "00:00");
            if (dateTime == null) {
                return new Pair<>(Long.MAX_VALUE, Long.MAX_VALUE);
            }
            return new Pair<>(dateTime, Long.valueOf(dateTime.longValue() + CalendarModelKt.MillisecondsIn24Hours));
        }
        return LiveUpdateManager.INSTANCE.resolveWindow(payload);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0026, code lost:
    
        if (r3.equals("火车票") == false) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0062, code lost:
    
        if (r3.equals("车票") == false) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x006f, code lost:
    
        return android.graphics.Color.rgb(90, 145, 213);
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final int notificationAccentColor(String ticketType) {
        switch (ticketType.hashCode()) {
            case 850286:
                if (ticketType.equals("机票")) {
                    return Color.rgb(67, 184, 162);
                }
                return Color.rgb(74, 140, 255);
            case 902502:
                if (ticketType.equals("演出")) {
                    return Color.rgb(161, 129, 215);
                }
                return Color.rgb(74, 140, 255);
            case 1169090:
                break;
            case 1220736:
                if (ticketType.equals("门票")) {
                    return Color.rgb(211, 154, 84);
                }
                return Color.rgb(74, 140, 255);
            case 21282337:
                if (ticketType.equals("取件码")) {
                    return Color.rgb(154, 154, 154);
                }
                return Color.rgb(74, 140, 255);
            case 21870407:
                if (ticketType.equals("取餐码")) {
                    return Color.rgb(123, 183, 232);
                }
                return Color.rgb(74, 140, 255);
            case 28825709:
                break;
            case 29623308:
                if (ticketType.equals("电影票")) {
                    return Color.rgb(232, 120, LocationRequestCompat.QUALITY_LOW_POWER);
                }
                return Color.rgb(74, 140, 255);
            default:
                return Color.rgb(74, 140, 255);
        }
    }

    static /* synthetic */ Icon createSamsungCardIcon$default(SamsungNowBarManager samsungNowBarManager, Context context, LiveUpdatePayload liveUpdatePayload, int i, boolean z, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            z = false;
        }
        return samsungNowBarManager.createSamsungCardIcon(context, liveUpdatePayload, i, z);
    }

    private final Icon createSamsungCardIcon(Context context, LiveUpdatePayload payload, int iconRes, boolean useRoundedSquare) {
        boolean z = Intrinsics.areEqual(payload.getTicketType(), "取餐码") && iconRes == R.drawable.ic_live_takeout;
        if (Intrinsics.areEqual(payload.getTicketType(), "取餐码") && !z) {
            Icon iconCreateWithResource = Icon.createWithResource(context, iconRes);
            Intrinsics.checkNotNullExpressionValue(iconCreateWithResource, "createWithResource(...)");
            return iconCreateWithResource;
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(96, 96, Bitmap.Config.ARGB_8888);
        Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(...)");
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        int iNotificationAccentColor = notificationAccentColor(payload.getTicketType());
        Paint paint = new Paint(1);
        paint.setColor(iNotificationAccentColor);
        paint.setStyle(Paint.Style.FILL);
        if (useRoundedSquare) {
            canvas.drawRoundRect(1.92f, 1.92f, 94.08f, 94.08f, 23.039999f, 23.039999f, paint);
        } else {
            canvas.drawCircle(48.0f, 48.0f, 46.079998f, paint);
        }
        Drawable drawable = ContextCompat.getDrawable(context, iconRes);
        Drawable drawableMutate = drawable != null ? drawable.mutate() : null;
        if (drawableMutate != null) {
            drawableMutate.setTint(-1);
            drawableMutate.setBounds(20, 20, 75, 75);
            drawableMutate.draw(canvas);
        }
        Icon iconCreateWithBitmap = Icon.createWithBitmap(bitmapCreateBitmap);
        Intrinsics.checkNotNullExpressionValue(iconCreateWithBitmap, "createWithBitmap(...)");
        return iconCreateWithBitmap;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x001e, code lost:
    
        if (r0.equals("火车票") == false) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0050, code lost:
    
        if (r0.equals("车票") == false) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0055, code lost:
    
        return com.example.tickets.R.drawable.ic_live_train;
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final int selectSmallIconRes(Context context, LiveUpdatePayload payload) {
        String ticketType = payload.getTicketType();
        switch (ticketType.hashCode()) {
            case 850286:
                if (ticketType.equals("机票")) {
                    return selectAirplaneIcon(payload);
                }
                return R.drawable.ic_live_movie;
            case 1169090:
                break;
            case 21282337:
                if (ticketType.equals("取件码")) {
                    return R.drawable.ic_live_pickup;
                }
                return R.drawable.ic_live_movie;
            case 21870407:
                if (ticketType.equals("取餐码")) {
                    Integer numResolveBrandNotificationRes = TicketBrandIconResolver.INSTANCE.resolveBrandNotificationRes(context, payload.getBrand());
                    return numResolveBrandNotificationRes != null ? numResolveBrandNotificationRes.intValue() : R.drawable.ic_live_takeout;
                }
                return R.drawable.ic_live_movie;
            case 28825709:
                break;
            case 29623308:
                if (ticketType.equals("电影票")) {
                    return R.drawable.ic_live_movie;
                }
                return R.drawable.ic_live_movie;
            default:
                return R.drawable.ic_live_movie;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0020, code lost:
    
        if (r0.equals("火车票") == false) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0051, code lost:
    
        if (r0.equals("车票") == false) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0056, code lost:
    
        return com.example.tickets.R.drawable.ic_nowbar_train;
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final int selectExpandedNotificationIconRes(Context context, LiveUpdatePayload payload, int originalIconRes) {
        String ticketType = payload.getTicketType();
        switch (ticketType.hashCode()) {
            case 850286:
                if (ticketType.equals("机票")) {
                    if (originalIconRes == R.drawable.ic_live_plane_arrival) {
                        return R.drawable.ic_nowbar_plane_arrival;
                    }
                    return originalIconRes == R.drawable.ic_live_plane_airborne ? R.drawable.ic_nowbar_plane_airborne : R.drawable.ic_nowbar_plane_departure;
                }
                return originalIconRes;
            case 902502:
                if (ticketType.equals("演出")) {
                    return R.drawable.ic_nowbar_event;
                }
                return originalIconRes;
            case 1169090:
                break;
            case 1220736:
                if (ticketType.equals("门票")) {
                    return R.drawable.ic_nowbar_admission;
                }
                return originalIconRes;
            case 21282337:
                if (ticketType.equals("取件码")) {
                    return R.drawable.ic_nowbar_pickup;
                }
                return originalIconRes;
            case 21870407:
                if (ticketType.equals("取餐码") && originalIconRes == R.drawable.ic_live_takeout) {
                    return R.drawable.ic_nowbar_takeout;
                }
                return originalIconRes;
            case 28825709:
                break;
            case 29623308:
                if (ticketType.equals("电影票")) {
                    return R.drawable.ic_nowbar_movie;
                }
                return originalIconRes;
            default:
                return originalIconRes;
        }
    }

    private final IconCompat createTakeoutNotificationIcon(Context context, int iconRes) {
        Drawable drawable = ContextCompat.getDrawable(context, iconRes);
        if (drawable == null) {
            IconCompat iconCompatCreateWithResource = IconCompat.createWithResource(context, R.drawable.ic_live_takeout);
            Intrinsics.checkNotNullExpressionValue(iconCompatCreateWithResource, "createWithResource(...)");
            return iconCompatCreateWithResource;
        }
        Integer numValueOf = Integer.valueOf(drawable.getIntrinsicWidth());
        if (numValueOf.intValue() <= 0) {
            numValueOf = null;
        }
        int iIntValue = numValueOf != null ? numValueOf.intValue() : 64;
        Integer numValueOf2 = Integer.valueOf(drawable.getIntrinsicHeight());
        Integer num = numValueOf2.intValue() > 0 ? numValueOf2 : null;
        int iIntValue2 = num != null ? num.intValue() : 64;
        int iMax = Math.max(iIntValue, Math.max(iIntValue2, 64));
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iMax, iMax, Bitmap.Config.ARGB_8888);
        Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(...)");
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        float f = iMax;
        float f2 = iIntValue;
        float f3 = iIntValue2;
        float fMin = Math.min(f / f2, f / f3) * 0.88f;
        int i = (int) (f2 * fMin);
        int i2 = (int) (f3 * fMin);
        int i3 = (iMax - i) / 2;
        int i4 = (iMax - i2) / 2;
        drawable.setBounds(i3, i4, i + i3, i2 + i4);
        drawable.draw(canvas);
        IconCompat iconCompatCreateWithBitmap = IconCompat.createWithBitmap(bitmapCreateBitmap);
        Intrinsics.checkNotNullExpressionValue(iconCompatCreateWithBitmap, "createWithBitmap(...)");
        return iconCompatCreateWithBitmap;
    }

    private final int selectAirplaneIcon(LiveUpdatePayload payload) {
        Pair<Long, Long> pairResolveWindow = LiveUpdateManager.INSTANCE.resolveWindow(payload);
        long jLongValue = pairResolveWindow.component1().longValue();
        long jLongValue2 = pairResolveWindow.component2().longValue();
        if (jLongValue == Long.MAX_VALUE) {
            return R.drawable.ic_live_plane_departure;
        }
        Long dateTime = LiveUpdateManager.INSTANCE.parseDateTime(payload.getDate(), payload.getTakeoffTime());
        Long dateTime2 = LiveUpdateManager.INSTANCE.parseDateTime(payload.getDate(), payload.getLandingTime());
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (dateTime == null && dateTime2 == null) {
            long jMin = Math.min(jLongValue + 1200000, jLongValue2);
            long jMax = Math.max(jLongValue, jLongValue2 - 1200000);
            if (jCurrentTimeMillis < jMin) {
                return R.drawable.ic_live_plane_departure;
            }
            if (jCurrentTimeMillis >= jMax) {
                return R.drawable.ic_live_plane_arrival;
            }
            return R.drawable.ic_live_plane_airborne;
        }
        if (dateTime != null) {
            jLongValue = dateTime.longValue();
        }
        if (dateTime2 != null) {
            if (dateTime2.longValue() <= jLongValue) {
                dateTime2 = null;
            }
            if (dateTime2 != null) {
                jLongValue2 = dateTime2.longValue();
            }
        }
        if (jCurrentTimeMillis < jLongValue) {
            return R.drawable.ic_live_plane_departure;
        }
        if (jCurrentTimeMillis >= jLongValue2) {
            return R.drawable.ic_live_plane_arrival;
        }
        return R.drawable.ic_live_plane_airborne;
    }

    private final PendingIntent createNowBarContentPendingIntent(Context context, int ticketId) {
        Intent intent = new Intent(context, (Class<?>) MainActivity.class);
        intent.setAction("com.example.tickets.OPEN_TICKET_FROM_NOWBAR");
        intent.putExtra("ticket_id", ticketId);
        intent.addFlags(603979776);
        PendingIntent activity = PendingIntent.getActivity(context, ticketId + 72000, intent, 201326592);
        Intrinsics.checkNotNullExpressionValue(activity, "getActivity(...)");
        return activity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String ticketTypeName(TicketType type) {
        switch (WhenMappings.$EnumSwitchMapping$0[type.ordinal()]) {
            case 1:
                return "车票";
            case 2:
                return "机票";
            case 3:
                return "取餐码";
            case 4:
                return "取件码";
            case 5:
                return "电影票";
            case 6:
                return "演出";
            case 7:
                return "门票";
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public final void onSystemAlarm$app(Context context, Intent intent) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (Intrinsics.areEqual(intent != null ? intent.getAction() : null, NOWBAR_ALARM_ACTION)) {
            int intExtra = intent.getIntExtra(EXTRA_ALARM_STAGE, 0);
            int intExtra2 = intent.getIntExtra(EXTRA_ALARM_TICKET_ID, 0);
            if (intExtra2 == 0 || intExtra == 0) {
                return;
            }
            if (intExtra == 8) {
                cancelTicket(context, intExtra2);
            } else {
                refreshFromSystemAlarm$app(context, intent);
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:39:0x0087  */
    /* JADX WARN: Code duplicated, block: B:48:0x00a2  */
    public final void refreshFromSystemAlarm$app(Context context, Intent intent) {
        int intExtra;
        TicketType ticketType;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (Intrinsics.areEqual(intent.getAction(), NOWBAR_ALARM_ACTION) && hasNotificationPermission(context) && (intExtra = intent.getIntExtra(EXTRA_ALARM_TICKET_ID, 0)) != 0) {
            String stringExtra = intent.getStringExtra(EXTRA_ALARM_TICKET_TYPE);
            if (stringExtra == null) {
                stringExtra = "";
            }
            switch (stringExtra) {
                case "机票":
                    ticketType = TicketType.Airplane;
                    break;
                case "演出":
                    ticketType = TicketType.Event;
                    break;
                case "车票":
                    ticketType = TicketType.Train;
                    break;
                case "门票":
                    ticketType = TicketType.Admission;
                    break;
                case "取件码":
                    ticketType = TicketType.PickupCode;
                    break;
                case "取餐码":
                    ticketType = TicketType.TakeoutCode;
                    break;
                case "火车票":
                    ticketType = TicketType.Train;
                    break;
                case "电影票":
                    ticketType = TicketType.Movie;
                    break;
                default:
                    ticketType = null;
                    break;
            }
            TicketType ticketType2 = ticketType;
            if (ticketType2 == null) {
                return;
            }
            String stringExtra2 = intent.getStringExtra(EXTRA_ALARM_TITLE);
            String str = stringExtra2 == null ? "" : stringExtra2;
            String stringExtra3 = intent.getStringExtra(EXTRA_ALARM_CODE);
            String str2 = stringExtra3 == null ? "" : stringExtra3;
            String stringExtra4 = intent.getStringExtra(EXTRA_ALARM_DATE);
            String str3 = stringExtra4 == null ? "" : stringExtra4;
            String stringExtra5 = intent.getStringExtra(EXTRA_ALARM_TIME);
            String str4 = stringExtra5 == null ? "" : stringExtra5;
            String stringExtra6 = intent.getStringExtra(EXTRA_ALARM_DEPARTURE_DATE);
            String str5 = stringExtra6 == null ? "" : stringExtra6;
            String stringExtra7 = intent.getStringExtra(EXTRA_ALARM_ARRIVAL_DATE);
            String str6 = stringExtra7 == null ? "" : stringExtra7;
            String stringExtra8 = intent.getStringExtra(EXTRA_ALARM_FROM);
            String str7 = stringExtra8 == null ? "" : stringExtra8;
            String stringExtra9 = intent.getStringExtra(EXTRA_ALARM_TO);
            String str8 = stringExtra9 == null ? "" : stringExtra9;
            String stringExtra10 = intent.getStringExtra(EXTRA_ALARM_DEPARTURE_PLATFORM);
            String str9 = stringExtra10 == null ? "" : stringExtra10;
            String stringExtra11 = intent.getStringExtra(EXTRA_ALARM_ARRIVAL_PLATFORM);
            String str10 = stringExtra11 == null ? "" : stringExtra11;
            String stringExtra12 = intent.getStringExtra(EXTRA_ALARM_HALL);
            String str11 = stringExtra12 == null ? "" : stringExtra12;
            String stringExtra13 = intent.getStringExtra(EXTRA_ALARM_SEAT);
            String str12 = stringExtra13 == null ? "" : stringExtra13;
            String stringExtra14 = intent.getStringExtra(EXTRA_ALARM_VENUE);
            String str13 = stringExtra14 == null ? "" : stringExtra14;
            String stringExtra15 = intent.getStringExtra(EXTRA_ALARM_START_TIME);
            String str14 = stringExtra15 == null ? "" : stringExtra15;
            String stringExtra16 = intent.getStringExtra(EXTRA_ALARM_END_TIME);
            String str15 = stringExtra16 == null ? "" : stringExtra16;
            String stringExtra17 = intent.getStringExtra(EXTRA_ALARM_TAKEOFF_TIME);
            String str16 = stringExtra17 == null ? "" : stringExtra17;
            String stringExtra18 = intent.getStringExtra(EXTRA_ALARM_LANDING_TIME);
            String str17 = stringExtra18 == null ? "" : stringExtra18;
            String stringExtra19 = intent.getStringExtra(EXTRA_ALARM_BRAND);
            TicketData ticketData = new TicketData(intExtra, ticketType2, str, str2, null, null, str3, str4, str5, str6, str7, str8, str9, str10, null, null, str11, str12, null, null, str13, str14, str15, str16, str17, stringExtra19 == null ? "" : stringExtra19, false, false, false, null, 1007468592, null);
            if (isDynamicNowBarTicket(ticketData.getType())) {
                Notification notificationBuildNowBarNotification$default = buildNowBarNotification$default(this, context, new LiveUpdatePayload(ticketData.getId(), ticketTypeName(ticketData.getType()), ticketData.getTitle(), ticketData.getCode(), ticketData.getDate(), ticketData.getTime(), ticketData.getDepartureDate(), ticketData.getArrivalDate(), ticketData.getFrom(), ticketData.getTo(), ticketData.getDeparturePlatform(), ticketData.getArrivalPlatform(), ticketData.getHall(), ticketData.getSeat(), ticketData.getVenue(), null, null, ticketData.getStartTime(), ticketData.getEndTime(), ticketData.getTakeoffTime(), ticketData.getLandingTime(), ticketData.getBrand(), 98304, null), ticketData, false, 8, null);
                if (Build.VERSION.SDK_INT < 33 || ContextCompat.checkSelfPermission(context, "android.permission.POST_NOTIFICATIONS") == 0) {
                    try {
                        NotificationManagerCompat.from(context).notify(notificationId(ticketData.getId()), notificationBuildNowBarNotification$default);
                    } catch (SecurityException unused) {
                    }
                }
            }
        }
    }

    public final void cancelTicket(Context context, int ticketId) {
        Intrinsics.checkNotNullParameter(context, "context");
        stopDynamicNowBarTimer(ticketId);
        cancelSystemNowBarAlarms(context, ticketId);
        try {
            NotificationManagerCompat.from(context).cancel(notificationId(ticketId));
        } catch (Throwable unused) {
        }
    }

    public final void cancelAll$app(Context context, List<TicketData> tickets) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(tickets, "tickets");
        Iterator<T> it = tickets.iterator();
        while (it.hasNext()) {
            INSTANCE.cancelTicket(context, ((TicketData) it.next()).getId());
        }
    }

    private final boolean isSmartSubwayAfterTransfer(SmartSubwayRealtimeState state) {
        String string = StringsKt.trim((CharSequence) StringsKt.replace(StringsKt.removeSuffix(StringsKt.trim((CharSequence) state.getLineName()).toString(), (CharSequence) "号线"), "Line", "", true)).toString();
        String string2 = StringsKt.trim((CharSequence) StringsKt.replace(StringsKt.removeSuffix(StringsKt.trim((CharSequence) state.getTransferLineName()).toString(), (CharSequence) "号线"), "Line", "", true)).toString();
        return (StringsKt.isBlank(string2) || !StringsKt.equals(string, string2, true) || Intrinsics.areEqual(state.getCurrentStation(), state.getTransferStation())) ? false : true;
    }

    private final String activeSmartSubwayLineName(SmartSubwayRealtimeState state) {
        String lineName;
        if (isSmartSubwayAfterTransfer(state) && !StringsKt.isBlank(state.getTransferLineName())) {
            lineName = state.getTransferLineName();
        } else {
            lineName = state.getLineName();
        }
        String str = lineName;
        if (StringsKt.isBlank(str)) {
            str = "地铁";
        }
        return str;
    }

    private final int activeSmartSubwayLineColor(SmartSubwayRealtimeState state) {
        if (isSmartSubwayAfterTransfer(state)) {
            return state.getSecondaryLineColor();
        }
        return state.getPrimaryLineColor();
    }

    private final boolean smartSubwaySameStation(String first, String second) {
        String strReplace = new Regex("\\s+").replace(StringsKt.trim((CharSequence) first).toString(), "");
        String strReplace2 = new Regex("\\s+").replace(StringsKt.trim((CharSequence) second).toString(), "");
        return (StringsKt.isBlank(strReplace) || StringsKt.isBlank(strReplace2) || !Intrinsics.areEqual(strReplace, strReplace2)) ? false : true;
    }

    private final boolean isSmartSubwayAtRequiredTransferStation(SmartSubwayRealtimeState state) {
        return state.isTransferRequired() && !StringsKt.isBlank(state.getTransferStation()) && smartSubwaySameStation(state.getCurrentStation(), state.getTransferStation());
    }

    private final String smartSubwayStatusText(SmartSubwayRealtimeState state) {
        return SmartSubwayRealtimeKt.buildSmartSubwayHorizontalCardContent(state).getStatusText();
    }

    private final String smartSubwayLineSummary(SmartSubwayRealtimeState state) {
        return SmartSubwayRealtimeKt.buildSmartSubwayHorizontalCardContent(state).getLineSummary();
    }

    private final String smartSubwayLineSummaryWithStatus(SmartSubwayRealtimeState state) {
        SmartSubwayHorizontalCardContent smartSubwayHorizontalCardContentBuildSmartSubwayHorizontalCardContent = SmartSubwayRealtimeKt.buildSmartSubwayHorizontalCardContent(state);
        if (StringsKt.isBlank(smartSubwayHorizontalCardContentBuildSmartSubwayHorizontalCardContent.getStatusText())) {
            return smartSubwayHorizontalCardContentBuildSmartSubwayHorizontalCardContent.getLineSummary();
        }
        return smartSubwayHorizontalCardContentBuildSmartSubwayHorizontalCardContent.getLineSummary() + "  ·  " + smartSubwayHorizontalCardContentBuildSmartSubwayHorizontalCardContent.getStatusText();
    }

    private final String smartSubwayServiceBadgeLabel(String lineName) {
        String string = StringsKt.trim((CharSequence) new Regex("(?i)\\bline\\b").replace(StringsKt.removeSuffix(StringsKt.trim((CharSequence) lineName).toString(), (CharSequence) "号线"), "")).toString();
        if (StringsKt.isBlank(string)) {
            string = "M";
        }
        String str = string;
        String str2 = (String) CollectionsKt.firstOrNull((List) new Regex("\\s+").split(str, 0));
        String str3 = str2 != null ? str2 : "";
        if (!StringsKt.isBlank(str3) && (StringsKt.contains((CharSequence) str, (CharSequence) "Local", true) || StringsKt.contains((CharSequence) str, (CharSequence) "Express", true))) {
            string = str3;
        }
        return StringsKt.take(string, 3);
    }

    private final String smartSubwayPatternBadge(String lineName) {
        String str = lineName;
        if (StringsKt.contains((CharSequence) str, (CharSequence) "Express", true)) {
            return ExifInterface.LONGITUDE_EAST;
        }
        return StringsKt.contains((CharSequence) str, (CharSequence) "Local", true) ? "L" : "";
    }

    private final int smartSubwayIconTextColor(int backgroundColor) {
        return (((((float) Color.red(backgroundColor)) / 255.0f) * 0.2126f) + ((((float) Color.green(backgroundColor)) / 255.0f) * 0.7152f)) + ((((float) Color.blue(backgroundColor)) / 255.0f) * 0.0722f) > 0.6f ? -16777216 : -1;
    }

    static /* synthetic */ Bitmap renderSmartSubwayServiceIcon$default(SamsungNowBarManager samsungNowBarManager, SmartSubwayRealtimeState smartSubwayRealtimeState, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 96;
        }
        return samsungNowBarManager.renderSmartSubwayServiceIcon(smartSubwayRealtimeState, i);
    }

    private final Bitmap renderSmartSubwayServiceIcon(SmartSubwayRealtimeState state, int sizePx) {
        float f;
        int iCoerceAtLeast = RangesKt.coerceAtLeast(sizePx, 64);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iCoerceAtLeast, iCoerceAtLeast, Bitmap.Config.ARGB_8888);
        Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(...)");
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        canvas.drawColor(0);
        int iActiveSmartSubwayLineColor = activeSmartSubwayLineColor(state);
        String strSmartSubwayServiceBadgeLabel = smartSubwayServiceBadgeLabel(activeSmartSubwayLineName(state));
        String strSmartSubwayPatternBadge = smartSubwayPatternBadge(activeSmartSubwayLineName(state));
        float f2 = iCoerceAtLeast;
        float f3 = 0.07f * f2;
        float f4 = f2 - f3;
        RectF rectF = new RectF(f3, f3, f4, f4);
        Paint paint = new Paint(1);
        paint.setColor(iActiveSmartSubwayLineColor);
        paint.setStyle(Paint.Style.FILL);
        Paint paint2 = new Paint(1);
        paint2.setColor(-1);
        paint2.setAlpha(95);
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setStrokeWidth(0.025f * f2);
        Paint paint3 = new Paint(1);
        paint3.setColor(INSTANCE.smartSubwayIconTextColor(iActiveSmartSubwayLineColor));
        paint3.setTextAlign(Paint.Align.CENTER);
        if (strSmartSubwayServiceBadgeLabel.length() == 1) {
            f = 0.4f;
        } else {
            f = strSmartSubwayServiceBadgeLabel.length() == 2 ? 0.31f : 0.25f;
        }
        paint3.setTextSize(f * f2);
        paint3.setTypeface(Typeface.create("sans-serif", 1));
        float f5 = 0.24f * f2;
        canvas.drawRoundRect(rectF, f5, f5, paint);
        canvas.drawRoundRect(rectF, f5, f5, paint2);
        float f6 = f2 / 2.0f;
        Paint.FontMetrics fontMetrics = paint3.getFontMetrics();
        canvas.drawText(strSmartSubwayServiceBadgeLabel, f6, (f6 - ((fontMetrics.ascent + fontMetrics.descent) / 2.0f)) - (0.015f * f2), paint3);
        if (!StringsKt.isBlank(strSmartSubwayPatternBadge)) {
            Paint paint4 = new Paint(1);
            paint4.setColor(paint3.getColor());
            paint4.setTextAlign(Paint.Align.CENTER);
            paint4.setTextSize(0.15f * f2);
            paint4.setTypeface(Typeface.create("sans-serif", 1));
            canvas.drawText(strSmartSubwayPatternBadge, 0.79f * f2, f2 * 0.81f, paint4);
        }
        return bitmapCreateBitmap;
    }

    static /* synthetic */ Bitmap renderSmartSubwaySamsungProgressBitmap$default(SamsungNowBarManager samsungNowBarManager, SmartSubwayRealtimeState smartSubwayRealtimeState, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 980;
        }
        if ((i3 & 4) != 0) {
            i2 = 110;
        }
        return samsungNowBarManager.renderSmartSubwaySamsungProgressBitmap(smartSubwayRealtimeState, i, i2);
    }

    private final Bitmap renderSmartSubwaySamsungProgressBitmap(SmartSubwayRealtimeState state, int widthPx, int heightPx) {
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(RangesKt.coerceAtLeast(widthPx, 700), RangesKt.coerceAtLeast(heightPx, 90), Bitmap.Config.ARGB_8888);
        Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(...)");
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        canvas.drawColor(0);
        float width = bitmapCreateBitmap.getWidth();
        float height = bitmapCreateBitmap.getHeight() * 0.5f;
        float[] fArr = {0.12f * width, 0.5f * width, width * 0.88f};
        int iActiveSmartSubwayLineColor = activeSmartSubwayLineColor(state);
        Paint paint = new Paint(1);
        paint.setColor(Color.rgb(67, 70, 76));
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(24.0f);
        paint.setStrokeCap(Paint.Cap.ROUND);
        Paint paint2 = new Paint(1);
        paint2.setColor(iActiveSmartSubwayLineColor);
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setStrokeWidth(24.0f);
        paint2.setStrokeCap(Paint.Cap.ROUND);
        Paint paint3 = new Paint(1);
        paint3.setColor(-1);
        paint3.setStyle(Paint.Style.FILL);
        Paint paint4 = new Paint(1);
        paint4.setColor(iActiveSmartSubwayLineColor);
        paint4.setStyle(Paint.Style.FILL);
        Paint paint5 = new Paint(1);
        paint5.setColor(Color.rgb(154, 157, 164));
        paint5.setStyle(Paint.Style.FILL);
        canvas.drawLine(fArr[0] + 18.0f, height, fArr[1] - 18.0f, height, paint2);
        canvas.drawLine(fArr[1] + 18.0f, height, fArr[2] - 18.0f, height, paint);
        canvas.drawCircle(fArr[0], height, 11.0f, paint5);
        canvas.drawCircle(fArr[2], height, 11.0f, paint5);
        canvas.drawCircle(fArr[1], height, 21.0f, paint3);
        canvas.drawCircle(fArr[1], height, 11.0f, paint4);
        return bitmapCreateBitmap;
    }

    public final boolean showSmartSubway$app(Context context, SmartSubwayRealtimeState state) {
        Object objM9536constructorimpl;
        String strReplace$default;
        int i;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(state, "state");
        if (!hasNotificationPermission(context) || !isSamsungDevice()) {
            return false;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            SamsungNowBarManager samsungNowBarManager = this;
            createNotificationChannel(context);
            Intent intent = new Intent(context, (Class<?>) MainActivity.class);
            intent.setAction("com.example.tickets.OPEN_SMART_SUBWAY_FROM_NOWBAR");
            intent.setFlags(603979776);
            intent.putExtra("smart_subway_route_id", state.getRouteId());
            Unit unit = Unit.INSTANCE;
            PendingIntent activity = PendingIntent.getActivity(context, 88002, intent, 201326592);
            String currentStation = state.getCurrentStation();
            if (StringsKt.isBlank(currentStation)) {
                currentStation = "等待定位";
            }
            String str = currentStation;
            boolean zIsUsSmartSubwayCity = SmartSubwayRealtimeKt.isUsSmartSubwayCity(state.getCityId());
            int iActiveSmartSubwayLineColor = activeSmartSubwayLineColor(state);
            String strSmartSubwayLineSummary = smartSubwayLineSummary(state);
            String strCompactSmartSubwayNotificationStatus = compactSmartSubwayNotificationStatus(SmartSubwayRealtimeKt.buildSmartSubwayHorizontalCardContent(state).getStatusText());
            if (StringsKt.isBlank(strCompactSmartSubwayNotificationStatus)) {
                strReplace$default = StringsKt.replace$default(strSmartSubwayLineSummary, "  ·  → ", " → ", false, 4, (Object) null);
            } else {
                strReplace$default = StringsKt.replace$default(strSmartSubwayLineSummary, "  ·  → ", " → ", false, 4, (Object) null) + "  ·  " + strCompactSmartSubwayNotificationStatus;
            }
            String strReplace$default2 = zIsUsSmartSubwayCity ? StringsKt.replace$default(strSmartSubwayLineSummary, "  ·  → ", " → ", false, 4, (Object) null) : strReplace$default;
            String str2 = strReplace$default;
            Bitmap bitmapRenderSmartSubwayServiceIcon$default = renderSmartSubwayServiceIcon$default(this, state, 0, 2, null);
            Icon iconCreateWithBitmap = Icon.createWithBitmap(bitmapRenderSmartSubwayServiceIcon$default);
            Intrinsics.checkNotNullExpressionValue(iconCreateWithBitmap, "createWithBitmap(...)");
            IconCompat iconCompatCreateWithBitmap = IconCompat.createWithBitmap(bitmapRenderSmartSubwayServiceIcon$default);
            Intrinsics.checkNotNullExpressionValue(iconCompatCreateWithBitmap, "createWithBitmap(...)");
            SmartSubwayHorizontalCardContent smartSubwayHorizontalCardContentBuildSmartSubwayHorizontalCardContent = SmartSubwayRealtimeKt.buildSmartSubwayHorizontalCardContent(state);
            String previousStation = smartSubwayHorizontalCardContentBuildSmartSubwayHorizontalCardContent.getPreviousStation();
            String nextStation = smartSubwayHorizontalCardContentBuildSmartSubwayHorizontalCardContent.getNextStation();
            String packageName = context.getPackageName();
            if (zIsUsSmartSubwayCity) {
                i = R.layout.notification_smart_subway_samsung_remote_us;
            } else {
                i = R.layout.notification_smart_subway_samsung_remote;
            }
            RemoteViews remoteViews = new RemoteViews(packageName, i);
            remoteViews.setViewVisibility(R.id.smart_subway_samsung_header, 0);
            remoteViews.setTextViewText(R.id.smart_subway_samsung_header, "当前站");
            if (zIsUsSmartSubwayCity) {
                remoteViews.setTextViewTextSize(R.id.smart_subway_samsung_header, 2, 20.0f);
            }
            remoteViews.setTextViewText(R.id.smart_subway_samsung_direction, strReplace$default2);
            if (zIsUsSmartSubwayCity) {
                remoteViews.setTextViewText(R.id.smart_subway_samsung_previous, formatSmartSubwayStationNameForDisplay(previousStation));
                remoteViews.setTextViewTextSize(R.id.smart_subway_samsung_previous, 2, smartSubwayStationTextSizeSp(previousStation, false));
                remoteViews.setTextViewText(R.id.smart_subway_samsung_current, formatSmartSubwayStationNameForDisplay(smartSubwayHorizontalCardContentBuildSmartSubwayHorizontalCardContent.getCurrentStation()));
                remoteViews.setTextViewTextSize(R.id.smart_subway_samsung_current, 2, smartSubwayStationTextSizeSp(smartSubwayHorizontalCardContentBuildSmartSubwayHorizontalCardContent.getCurrentStation(), true));
                remoteViews.setTextViewText(R.id.smart_subway_samsung_next, formatSmartSubwayStationNameForDisplay(nextStation));
                remoteViews.setTextViewTextSize(R.id.smart_subway_samsung_next, 2, smartSubwayStationTextSizeSp(nextStation, false));
            } else {
                remoteViews.setTextViewText(R.id.smart_subway_samsung_previous, previousStation);
                remoteViews.setTextViewText(R.id.smart_subway_samsung_current, smartSubwayHorizontalCardContentBuildSmartSubwayHorizontalCardContent.getCurrentStation());
                remoteViews.setTextViewText(R.id.smart_subway_samsung_next, nextStation);
            }
            remoteViews.setTextViewText(R.id.smart_subway_samsung_previous_caption, "上一站");
            remoteViews.setTextViewText(R.id.smart_subway_samsung_current_caption, "当前站");
            remoteViews.setTextViewText(R.id.smart_subway_samsung_next_caption, "下一站");
            int i2 = 8;
            if (zIsUsSmartSubwayCity) {
                remoteViews.setViewVisibility(R.id.smart_subway_samsung_manual_advance, 8);
                remoteViews.setTextViewText(R.id.smart_subway_samsung_action, strCompactSmartSubwayNotificationStatus);
                int i3 = R.id.smart_subway_samsung_action;
                if (!StringsKt.isBlank(strCompactSmartSubwayNotificationStatus)) {
                    i2 = 0;
                }
                remoteViews.setViewVisibility(i3, i2);
            } else {
                remoteViews.setViewVisibility(R.id.smart_subway_samsung_action, 8);
            }
            remoteViews.setImageViewBitmap(R.id.smart_subway_samsung_route, renderSmartSubwaySamsungProgressBitmap$default(this, state, 0, 0, 6, null));
            remoteViews.setTextColor(R.id.smart_subway_samsung_direction, iActiveSmartSubwayLineColor);
            remoteViews.setTextColor(R.id.smart_subway_samsung_action, iActiveSmartSubwayLineColor);
            remoteViews.setTextColor(R.id.smart_subway_samsung_current, -1);
            NotificationCompat.Builder showWhen = new NotificationCompat.Builder(context, RealtimeNotificationVisibilityController.channelId$default(RealtimeNotificationVisibilityController.INSTANCE, CHANNEL_BASE_ID, null, null, 6, null)).setSmallIcon(iconCompatCreateWithBitmap).setColor(iActiveSmartSubwayLineColor).setColorized(false).setContentTitle(str).setContentText(strSmartSubwayLineSummary).setContentIntent(activity).setPriority(-1).setOngoing(true).setOnlyAlertOnce(true).setAutoCancel(false).setLocalOnly(true).setVisibility(1).setShowWhen(false);
            if (!state.isDestination() && !StringsKt.isBlank(nextStation) && !Intrinsics.areEqual(nextStation, smartSubwayHorizontalCardContentBuildSmartSubwayHorizontalCardContent.getCurrentStation())) {
                showWhen.addAction(0, "我已到达下一站", SmartSubwayManualAdvance.INSTANCE.createPendingIntent(context));
            }
            Intrinsics.checkNotNullExpressionValue(showWhen, "apply(...)");
            if (Build.VERSION.SDK_INT >= 36 && !RealtimeNotificationVisibilityController.INSTANCE.isAppForeground()) {
                showWhen.setRequestPromotedOngoing(true);
            }
            Notification notificationBuild = showWhen.build();
            Intrinsics.checkNotNullExpressionValue(notificationBuild, "build(...)");
            Bundle bundle = notificationBuild.extras;
            bundle.putBoolean(EXTRA_SHOW_SMALL_ICON, true);
            bundle.putString(EXTRA_NOWBAR_PRIMARY_INFO, zIsUsSmartSubwayCity ? "当前站" : str);
            bundle.putString(EXTRA_NOWBAR_SECONDARY_INFO, "");
            bundle.putParcelable(EXTRA_CHIP_ICON, iconCreateWithBitmap);
            bundle.putInt(EXTRA_CHIP_BG_COLOR, iActiveSmartSubwayLineColor);
            bundle.putString(EXTRA_CHIP_EXPANDED_TEXT, str + "  ·  " + str2);
            bundle.putString(EXTRA_PRIMARY_INFO, "");
            bundle.putCharSequence(EXTRA_SECONDARY_INFO, "");
            bundle.putParcelable(EXTRA_FIRST_ICON, iconCreateWithBitmap);
            bundle.putInt(EXTRA_STYLE, 1);
            bundle.putInt(EXTRA_ACTION_TYPE, (state.isDestination() || Intrinsics.areEqual(nextStation, smartSubwayHorizontalCardContentBuildSmartSubwayHorizontalCardContent.getCurrentStation())) ? 0 : 1);
            if (state.isDestination() || Intrinsics.areEqual(nextStation, smartSubwayHorizontalCardContentBuildSmartSubwayHorizontalCardContent.getCurrentStation())) {
                iActiveSmartSubwayLineColor = 0;
            }
            bundle.putInt(EXTRA_ACTION_BG_COLOR, iActiveSmartSubwayLineColor);
            bundle.putInt(EXTRA_ACTION_PRIMARY_SET, 0);
            bundle.putParcelable("android.ongoingActivityNoti.chronometerRemoteView", remoteViews);
            bundle.putInt(EXTRA_REMOTE_VIEW_POSITION, 1);
            bundle.putString(EXTRA_REMOTE_VIEW_TAG, "smart_subway_three_station_remote");
            bundle.putString(EXTRA_AOD_REMOTE_APP_NAME, "票据 · 智能地铁");
            bundle.putParcelable(EXTRA_AOD_REMOTE_APP_ICON, Icon.createWithResource(context, R.mipmap.ic_launcher));
            bundle.putParcelable(EXTRA_AOD_REMOTE_APP_PENDING_INTENT, activity);
            bundle.putParcelable(EXTRA_SUBSCREEN_PENDING_INTENT, activity);
            bundle.putString(EXTRA_SUBST_NAME, "智能地铁");
            try {
                NotificationManagerCompat.from(context).notify(SmartSubwayNotificationSpec.NOTIFICATION_ID, notificationBuild);
            } catch (SecurityException unused) {
            }
            objM9536constructorimpl = Result.m9536constructorimpl(true);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM9536constructorimpl = Result.m9536constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m9542isFailureimpl(objM9536constructorimpl)) {
            objM9536constructorimpl = false;
        }
        return ((Boolean) objM9536constructorimpl).booleanValue();
    }

    private final String compactSmartSubwayNotificationStatus(String status) {
        String string = StringsKt.trim((CharSequence) status).toString();
        if (StringsKt.isBlank(string)) {
            return "";
        }
        if (!StringsKt.startsWith$default(string, "可换乘", false, 2, (Object) null)) {
            return StringsKt.startsWith$default(string, "准备换乘", false, 2, (Object) null) ? StringsKt.replace$default(string, "准备换乘", "换乘 ", false, 4, (Object) null) : string;
        }
        return "换乘 " + StringsKt.replace$default(StringsKt.replace$default(StringsKt.removePrefix(string, (CharSequence) "可换乘"), (char) 12289, '/', false, 4, (Object) null), ',', '/', false, 4, (Object) null);
    }

    private final String formatSmartSubwayStationNameForDisplay(String value) {
        String strReplace = new Regex("\\s+").replace(StringsKt.trim((CharSequence) value).toString(), " ");
        String str = strReplace;
        if (!StringsKt.isBlank(str)) {
            Object next = null;
            if (!StringsKt.contains$default((CharSequence) str, '\n', false, 2, (Object) null)) {
                String lowerCase = strReplace.toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                if (Intrinsics.areEqual(lowerCase, "grand central-42 st")) {
                    strReplace = "Grand Central";
                } else if (Intrinsics.areEqual(lowerCase, "34 st-hudson yards")) {
                    strReplace = "Hudson-Yards";
                }
                String str2 = strReplace;
                if (str2.length() > 13) {
                    String str3 = str2;
                    IntRange indices = StringsKt.getIndices(str3);
                    ArrayList arrayList = new ArrayList();
                    for (Integer num : indices) {
                        int iIntValue = num.intValue();
                        if (str2.charAt(iIntValue) == '-' || str2.charAt(iIntValue) == ' ') {
                            if (iIntValue > 2 && iIntValue < StringsKt.getLastIndex(str3) - 2) {
                                arrayList.add(num);
                            }
                        }
                    }
                    Iterator it = arrayList.iterator();
                    if (it.hasNext()) {
                        next = it.next();
                        if (it.hasNext()) {
                            int iIntValue2 = ((Number) next).intValue();
                            int i = (str2.charAt(iIntValue2) == '-' ? 1 : 0) + iIntValue2;
                            int length = (str2.length() - iIntValue2) - 1;
                            int iMax = (Math.max(i, length) * 100) + Math.abs(i - length);
                            do {
                                Object next2 = it.next();
                                int iIntValue3 = ((Number) next2).intValue();
                                int i2 = (str2.charAt(iIntValue3) == '-' ? 1 : 0) + iIntValue3;
                                int length2 = (str2.length() - iIntValue3) - 1;
                                int iMax2 = (Math.max(i2, length2) * 100) + Math.abs(i2 - length2);
                                if (iMax > iMax2) {
                                    next = next2;
                                    iMax = iMax2;
                                }
                            } while (it.hasNext());
                        }
                    }
                    Integer num2 = (Integer) next;
                    if (num2 != null) {
                        String strSubstring = str2.substring(0, num2.intValue() + (str2.charAt(num2.intValue()) == '-' ? 1 : 0));
                        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                        String string = StringsKt.trimEnd((CharSequence) strSubstring).toString();
                        String strSubstring2 = str2.substring(num2.intValue() + 1);
                        Intrinsics.checkNotNullExpressionValue(strSubstring2, "substring(...)");
                        return string + "\n" + StringsKt.trimStart((CharSequence) strSubstring2).toString();
                    }
                }
                return str2;
            }
        }
        return strReplace;
    }

    private final float smartSubwayStationTextSizeSp(String value, boolean active) {
        int length = new Regex("\\s+").replace(StringsKt.trim((CharSequence) value).toString(), " ").length();
        float f = active ? 21.0f : 17.0f;
        if (length >= 24) {
            return RangesKt.coerceAtLeast(f - 4.0f, active ? 13.0f : 11.0f);
        }
        if (length >= 18) {
            return RangesKt.coerceAtLeast(f - 3.0f, active ? 14.0f : 12.0f);
        }
        if (length >= 14) {
            return RangesKt.coerceAtLeast(f - 2.0f, active ? 14.0f : 12.0f);
        }
        return f;
    }

    public final void cancelSmartSubway$app(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            Result.Companion companion = Result.INSTANCE;
            SamsungNowBarManager samsungNowBarManager = this;
            NotificationManagerCompat.from(context).cancel(SmartSubwayNotificationSpec.NOTIFICATION_ID);
            Result.m9536constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m9536constructorimpl(ResultKt.createFailure(th));
        }
    }
}
