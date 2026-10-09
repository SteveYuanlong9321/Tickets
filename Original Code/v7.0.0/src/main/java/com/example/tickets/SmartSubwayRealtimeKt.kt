package com.example.tickets;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.widget.RemoteViews;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.core.app.NotificationCompat;
import androidx.window.core.layout.WindowSizeClass;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: SmartSubwayRealtime.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000\u001a\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0002\u001a\u0010\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u0003H\u0002\u001a\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005H\u0000\u001a\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0000\u001a\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0000\u001a\"\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\t2\b\b\u0002\u0010\u0010\u001a\u00020\tH\u0000\u001a\f\u0010\u0011\u001a\u00020\t*\u00020\u0003H\u0000\u001a;\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0010\u001a\u00020\t2\u0010\b\u0002\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0017H\u0007¢\u0006\u0002\u0010\u0018\u001a'\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0010\u001a\u00020\tH\u0003¢\u0006\u0004\b\u001d\u0010\u001e\u001a%\u0010\u001f\u001a\u00020\u00132\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\"0!2\b\b\u0002\u0010\u0014\u001a\u00020\u0015H\u0007¢\u0006\u0002\u0010#\u001a\u0018\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'2\u0006\u0010\u0002\u001a\u00020\u0003H\u0000\u001a\u0010\u0010(\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u0003H\u0000\u001a\f\u0010)\u001a\u00020\u0003*\u00020*H\u0000\u001a)\u0010+\u001a\u00020\u00132\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0010\u001a\u00020\tH\u0007¢\u0006\u0002\u0010,\u001a?\u0010-\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\u0006\u0010.\u001a\u00020\u00052\u0006\u0010/\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\t2\u0006\u00100\u001a\u00020\tH\u0003¢\u0006\u0002\u00101\u001a$\u00102\u001a\u00020\u0013*\u0002032\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u00104\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\tH\u0002\u001a\u001f\u00105\u001a\u00020\u00132\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u0015H\u0007¢\u0006\u0002\u00106\u001a/\u00107\u001a\u00020\u00132\u0006\u0010.\u001a\u00020\u00052\u0006\u0010/\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\u001cH\u0003¢\u0006\u0004\b8\u00109\u001a\u0017\u0010:\u001a\u00020\u00132\u0006\u0010;\u001a\u00020\u001cH\u0003¢\u0006\u0004\b<\u0010=\u001a\"\u0010>\u001a\u00020?2\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010@\u001a\u00020A2\b\b\u0002\u0010B\u001a\u00020A\u001a\u001e\u0010C\u001a\u00020\u00132\u0006\u0010D\u001a\u00020E2\u0006\u0010F\u001a\u00020A2\u0006\u0010\u0002\u001a\u00020\u0003¨\u0006G"}, d2 = {"buildSmartSubwayHorizontalCardContent", "Lcom/example/tickets/SmartSubwayHorizontalCardContent;", "state", "Lcom/example/tickets/SmartSubwayRealtimeState;", "normalizeSmartSubwayStationName", "", "value", "unifiedSmartSubwayStatusText", "isUsSmartSubwayCity", "", "cityId", "compactSmartSubwayUsStationName", "formatSmartSubwayUsStationName", "smartSubwayUsStationTextSizeSp", "", "active", "compact", "isAfterTransfer", "SmartSubwayHorizontalCard", "", "modifier", "Landroidx/compose/ui/Modifier;", "onClick", "Lkotlin/Function0;", "(Lcom/example/tickets/SmartSubwayRealtimeState;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "SmartSubwayServiceBadge", "lineName", "lineColor", "Landroidx/compose/ui/graphics/Color;", "SmartSubwayServiceBadge-iJQMabo", "(Ljava/lang/String;JZLandroidx/compose/runtime/Composer;I)V", "SmartSubwayGoogleRouteTimeline", "stops", "", "Lcom/example/tickets/SmartSubwayTimelineStop;", "(Ljava/util/List;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "buildSmartSubwayProgressStyle", "Landroidx/core/app/NotificationCompat$ProgressStyle;", "context", "Landroid/content/Context;", "buildSmartSubwayProgressText", "toRealtimeState", "Lcom/example/tickets/SmartSubwayTrip;", "SmartSubwayRouteCanvas", "(Lcom/example/tickets/SmartSubwayRealtimeState;Landroidx/compose/ui/Modifier;ZLandroidx/compose/runtime/Composer;II)V", "SmartSubwayThreeStationLabel", "title", "caption", "usLongNameLayout", "(Landroidx/compose/ui/Modifier;Ljava/lang/String;Ljava/lang/String;ZZZLandroidx/compose/runtime/Composer;II)V", "drawSmartSubwayHorizontalRoute", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "y", "SmartSubwayRouteTimeline", "(Lcom/example/tickets/SmartSubwayRealtimeState;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "SmartSubwayVerticalNode", "SmartSubwayVerticalNode-Bx497Mc", "(Ljava/lang/String;Ljava/lang/String;ZJLandroidx/compose/runtime/Composer;I)V", "SmartSubwayVerticalConnector", "color", "SmartSubwayVerticalConnector-ek8zF_U", "(JLandroidx/compose/runtime/Composer;I)V", "renderSmartSubwayRouteBitmap", "Landroid/graphics/Bitmap;", "widthPx", "", "heightPx", "applySmartSubwayRouteBitmap", "remoteViews", "Landroid/widget/RemoteViews;", "imageViewId", "app"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class SmartSubwayRealtimeKt {
    static final Unit SmartSubwayGoogleRouteTimeline$lambda$16(List list, Modifier modifier, int i, int i2, Composer composer, int i3) {
        SmartSubwayGoogleRouteTimeline(list, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    static final Unit SmartSubwayGoogleRouteTimeline$lambda$26(List list, Modifier modifier, int i, int i2, Composer composer, int i3) {
        SmartSubwayGoogleRouteTimeline(list, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    static final Unit SmartSubwayHorizontalCard$lambda$12(SmartSubwayRealtimeState smartSubwayRealtimeState, Modifier modifier, boolean z, Function0 function0, int i, int i2, Composer composer, int i3) {
        SmartSubwayHorizontalCard(smartSubwayRealtimeState, modifier, z, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    static final Unit SmartSubwayRouteCanvas$lambda$40(SmartSubwayRealtimeState smartSubwayRealtimeState, Modifier modifier, boolean z, int i, int i2, Composer composer, int i3) {
        SmartSubwayRouteCanvas(smartSubwayRealtimeState, modifier, z, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    static final Unit SmartSubwayRouteTimeline$lambda$49(SmartSubwayRealtimeState smartSubwayRealtimeState, Modifier modifier, int i, int i2, Composer composer, int i3) {
        SmartSubwayRouteTimeline(smartSubwayRealtimeState, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    static final Unit SmartSubwayServiceBadge_iJQMabo$lambda$15(String str, long j, boolean z, int i, Composer composer, int i2) {
        m9305SmartSubwayServiceBadgeiJQMabo(str, j, z, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    static final Unit SmartSubwayThreeStationLabel$lambda$43(Modifier modifier, String str, String str2, boolean z, boolean z2, boolean z3, int i, int i2, Composer composer, int i3) {
        SmartSubwayThreeStationLabel(modifier, str, str2, z, z2, z3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    static final Unit SmartSubwayThreeStationLabel$lambda$46(Modifier modifier, String str, String str2, boolean z, boolean z2, boolean z3, int i, int i2, Composer composer, int i3) {
        SmartSubwayThreeStationLabel(modifier, str, str2, z, z2, z3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    static final Unit SmartSubwayVerticalConnector_ek8zF_U$lambda$54(long j, int i, Composer composer, int i2) {
        m9306SmartSubwayVerticalConnectorek8zF_U(j, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    static final Unit SmartSubwayVerticalNode_Bx497Mc$lambda$53(String str, String str2, boolean z, long j, int i, Composer composer, int i2) {
        m9307SmartSubwayVerticalNodeBx497Mc(str, str2, z, j, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final float smartSubwayUsStationTextSizeSp(String value, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(value, "value");
        if (z) {
            return z2 ? 16.0f : 21.0f;
        }
        return z2 ? 13.0f : 17.0f;
    }

    public static final SmartSubwayHorizontalCardContent buildSmartSubwayHorizontalCardContent(SmartSubwayRealtimeState state) {
        String str;
        Intrinsics.checkNotNullParameter(state, "state");
        String currentStation = state.getCurrentStation();
        if (StringsKt.isBlank(currentStation)) {
            currentStation = "等待定位";
        }
        String str2 = currentStation;
        String previousStation = state.getPreviousStation();
        if (StringsKt.isBlank(previousStation) || StringsKt.equals(previousStation, str2, true)) {
            previousStation = null;
        }
        if (previousStation == null) {
            previousStation = "上一站";
        }
        String str3 = previousStation;
        String nextStation = state.getNextStation();
        String str4 = StringsKt.isBlank(nextStation) ? "等待定位" : nextStation;
        String lineName = state.getLineName();
        if (StringsKt.isBlank(lineName)) {
            lineName = "地铁";
        }
        String str5 = lineName;
        String destination = state.getDestination();
        String str6 = "";
        if (StringsKt.isBlank(destination)) {
            destination = "";
        }
        String str7 = destination;
        if (!StringsKt.isBlank(str7)) {
            str5 = str5 + "  ·  → " + str7;
        }
        boolean z = state.isTransferRequired() && !StringsKt.isBlank(state.getTransferStation()) && Intrinsics.areEqual(normalizeSmartSubwayStationName(str2), normalizeSmartSubwayStationName(state.getTransferStation()));
        if (state.isDestination()) {
            str6 = "带齐物品准备下车";
        } else if (z && !StringsKt.isBlank(state.getTransferLineName())) {
            str6 = "准备换乘" + state.getTransferLineName();
        } else {
            if (z) {
                str = "准备换乘";
            } else if (!state.getTransferOptions().isEmpty()) {
                str6 = "可换乘" + CollectionsKt.joinToString$default(state.getTransferOptions(), "、", null, null, 0, null, null, 62, null);
            }
            return new SmartSubwayHorizontalCardContent(str5, str, str3, str2, str4);
        }
        str = str6;
        return new SmartSubwayHorizontalCardContent(str5, str, str3, str2, str4);
    }

    private static final String normalizeSmartSubwayStationName(String str) {
        return new Regex("\\s+").replace(StringsKt.trim((CharSequence) str).toString(), "");
    }

    private static final String unifiedSmartSubwayStatusText(SmartSubwayRealtimeState smartSubwayRealtimeState) {
        return buildSmartSubwayHorizontalCardContent(smartSubwayRealtimeState).getStatusText();
    }

    public static final boolean isUsSmartSubwayCity(String cityId) {
        Intrinsics.checkNotNullParameter(cityId, "cityId");
        switch (cityId.hashCode()) {
            case -1383258675:
                return cityId.equals("boston");
            case -1335000448:
                return cityId.equals("los_angeles");
            case 109560:
                return cityId.equals("nyc");
            case 745998442:
                return cityId.equals("chicago");
            case 1382037045:
                return cityId.equals("philadelphia");
            case 1579642076:
                return cityId.equals("san_francisco_bay");
            case 1904238990:
                return cityId.equals("washington_dc");
            default:
                return false;
        }
    }

    public static final String compactSmartSubwayUsStationName(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        String strReplace = new Regex("\\s+").replace(StringsKt.trim((CharSequence) value).toString(), " ");
        String str = strReplace;
        if (StringsKt.isBlank(str) || StringsKt.contains$default((CharSequence) str, '\n', false, 2, (Object) null)) {
            return strReplace;
        }
        String lowerCase = strReplace.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        if (Intrinsics.areEqual(lowerCase, "grand central-42 st")) {
            return "Grand Central";
        }
        return Intrinsics.areEqual(lowerCase, "34 st-hudson yards") ? "Hudson-Yards" : strReplace;
    }

    public static final String formatSmartSubwayUsStationName(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        String strCompactSmartSubwayUsStationName = compactSmartSubwayUsStationName(value);
        String str = strCompactSmartSubwayUsStationName;
        if (StringsKt.isBlank(str)) {
            return strCompactSmartSubwayUsStationName;
        }
        Object next = null;
        if (StringsKt.contains$default((CharSequence) str, '\n', false, 2, (Object) null) || strCompactSmartSubwayUsStationName.length() <= 13) {
            return strCompactSmartSubwayUsStationName;
        }
        int iIndexOf$default = StringsKt.indexOf$default((CharSequence) str, '-', 0, false, 6, (Object) null);
        if (4 <= iIndexOf$default && iIndexOf$default < StringsKt.getLastIndex(str)) {
            int i = iIndexOf$default + 1;
            String strSubstring = strCompactSmartSubwayUsStationName.substring(0, i);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
            String strSubstring2 = strCompactSmartSubwayUsStationName.substring(i);
            Intrinsics.checkNotNullExpressionValue(strSubstring2, "substring(...)");
            return strSubstring + "\n" + StringsKt.trimStart((CharSequence) strSubstring2).toString();
        }
        int length = strCompactSmartSubwayUsStationName.length() / 2;
        IntRange indices = StringsKt.getIndices(str);
        ArrayList arrayList = new ArrayList();
        for (Integer num : indices) {
            int iIntValue = num.intValue();
            if (strCompactSmartSubwayUsStationName.charAt(iIntValue) == ' ' && iIntValue > 3 && iIntValue < StringsKt.getLastIndex(str) - 2) {
                arrayList.add(num);
            }
        }
        Iterator it = arrayList.iterator();
        if (it.hasNext()) {
            next = it.next();
            if (it.hasNext()) {
                int iAbs = Math.abs(((Number) next).intValue() - length);
                do {
                    Object next2 = it.next();
                    int iAbs2 = Math.abs(((Number) next2).intValue() - length);
                    if (iAbs > iAbs2) {
                        next = next2;
                        iAbs = iAbs2;
                    }
                } while (it.hasNext());
            }
        }
        Integer num2 = (Integer) next;
        if (num2 == null) {
            return strCompactSmartSubwayUsStationName;
        }
        String strSubstring3 = strCompactSmartSubwayUsStationName.substring(0, num2.intValue());
        Intrinsics.checkNotNullExpressionValue(strSubstring3, "substring(...)");
        String string = StringsKt.trimEnd((CharSequence) strSubstring3).toString();
        String strSubstring4 = strCompactSmartSubwayUsStationName.substring(num2.intValue() + 1);
        Intrinsics.checkNotNullExpressionValue(strSubstring4, "substring(...)");
        return string + "\n" + StringsKt.trimStart((CharSequence) strSubstring4).toString();
    }

    public static /* synthetic */ float smartSubwayUsStationTextSizeSp$default(String str, boolean z, boolean z2, int i, Object obj) {
        if ((i & 4) != 0) {
            z2 = false;
        }
        return smartSubwayUsStationTextSizeSp(str, z, z2);
    }

    public static final boolean isAfterTransfer(SmartSubwayRealtimeState smartSubwayRealtimeState) {
        Intrinsics.checkNotNullParameter(smartSubwayRealtimeState, "<this>");
        String string = StringsKt.trim((CharSequence) StringsKt.replace(StringsKt.removeSuffix(StringsKt.trim((CharSequence) smartSubwayRealtimeState.getLineName()).toString(), (CharSequence) "号线"), "Line", "", true)).toString();
        String string2 = StringsKt.trim((CharSequence) StringsKt.replace(StringsKt.removeSuffix(StringsKt.trim((CharSequence) smartSubwayRealtimeState.getTransferLineName()).toString(), (CharSequence) "号线"), "Line", "", true)).toString();
        return (StringsKt.isBlank(string2) || !StringsKt.equals(string, string2, true) || Intrinsics.areEqual(normalizeSmartSubwayStationName(smartSubwayRealtimeState.getCurrentStation()), normalizeSmartSubwayStationName(smartSubwayRealtimeState.getTransferStation()))) ? false : true;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x02e5  */
    /* JADX WARN: Code duplicated, block: B:101:0x02ea  */
    /* JADX WARN: Code duplicated, block: B:104:0x0343  */
    /* JADX WARN: Code duplicated, block: B:107:0x034f  */
    /* JADX WARN: Code duplicated, block: B:108:0x0353  */
    /* JADX WARN: Code duplicated, block: B:111:0x03b7  */
    /* JADX WARN: Code duplicated, block: B:112:0x03ba  */
    /* JADX WARN: Code duplicated, block: B:115:0x03fc  */
    /* JADX WARN: Code duplicated, block: B:116:0x0401  */
    /* JADX WARN: Code duplicated, block: B:119:0x0454  */
    /* JADX WARN: Code duplicated, block: B:120:0x04a7  */
    /* JADX WARN: Code duplicated, block: B:123:0x04da  */
    /* JADX WARN: Code duplicated, block: B:124:0x04e1  */
    /* JADX WARN: Code duplicated, block: B:127:0x051b  */
    /* JADX WARN: Code duplicated, block: B:129:0x0524  */
    /* JADX WARN: Code duplicated, block: B:132:0x0533  */
    /* JADX WARN: Code duplicated, block: B:134:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:23:0x0048  */
    /* JADX WARN: Code duplicated, block: B:24:0x004b  */
    /* JADX WARN: Code duplicated, block: B:26:0x004f  */
    /* JADX WARN: Code duplicated, block: B:28:0x0057  */
    /* JADX WARN: Code duplicated, block: B:29:0x005a  */
    /* JADX WARN: Code duplicated, block: B:34:0x0064  */
    /* JADX WARN: Code duplicated, block: B:35:0x0067  */
    /* JADX WARN: Code duplicated, block: B:37:0x006b  */
    /* JADX WARN: Code duplicated, block: B:39:0x0073  */
    /* JADX WARN: Code duplicated, block: B:40:0x0076  */
    /* JADX WARN: Code duplicated, block: B:45:0x0084  */
    /* JADX WARN: Code duplicated, block: B:46:0x0086  */
    /* JADX WARN: Code duplicated, block: B:49:0x008f A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:50:0x0091  */
    /* JADX WARN: Code duplicated, block: B:51:0x0096  */
    /* JADX WARN: Code duplicated, block: B:53:0x0099  */
    /* JADX WARN: Code duplicated, block: B:54:0x009b  */
    /* JADX WARN: Code duplicated, block: B:57:0x009f  */
    /* JADX WARN: Code duplicated, block: B:58:0x00a2  */
    /* JADX WARN: Code duplicated, block: B:61:0x00aa  */
    /* JADX WARN: Code duplicated, block: B:64:0x00ba  */
    /* JADX WARN: Code duplicated, block: B:65:0x00bf  */
    /* JADX WARN: Code duplicated, block: B:68:0x00cf  */
    /* JADX WARN: Code duplicated, block: B:69:0x00d2  */
    /* JADX WARN: Code duplicated, block: B:72:0x0134  */
    /* JADX WARN: Code duplicated, block: B:75:0x014a  */
    /* JADX WARN: Code duplicated, block: B:76:0x014d  */
    /* JADX WARN: Code duplicated, block: B:79:0x0157  */
    /* JADX WARN: Code duplicated, block: B:80:0x015c  */
    /* JADX WARN: Code duplicated, block: B:83:0x01ac  */
    /* JADX WARN: Code duplicated, block: B:86:0x01b8  */
    /* JADX WARN: Code duplicated, block: B:87:0x01bc  */
    /* JADX WARN: Code duplicated, block: B:90:0x025c  */
    /* JADX WARN: Code duplicated, block: B:93:0x0268  */
    /* JADX WARN: Code duplicated, block: B:94:0x026c  */
    /* JADX WARN: Code duplicated, block: B:97:0x02c6  */
    public static final void SmartSubwayHorizontalCard(final SmartSubwayRealtimeState state, Modifier modifier, boolean z, Function0<Unit> function0, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        boolean z2;
        int i5;
        int i6;
        int i7;
        boolean z3;
        Composer composer2;
        final Function0<Unit> function1;
        final Modifier modifier3;
        final boolean z4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier.Companion companion;
        boolean z5;
        Function0<Unit> function2;
        SmartSubwayHorizontalCardContent smartSubwayHorizontalCardContentBuildSmartSubwayHorizontalCardContent;
        int primaryLineColor;
        long jColor;
        float f;
        Modifier modifierBackground$default;
        float f2;
        float fM8748constructorimpl;
        Function0<ComposeUiNode> constructor;
        Function0<ComposeUiNode> constructor2;
        String lineName;
        boolean z6;
        float fM8748constructorimpl2;
        Function0<ComposeUiNode> constructor3;
        int i8;
        float fM8748constructorimpl3;
        Composer composer3;
        float fM8748constructorimpl4;
        Intrinsics.checkNotNullParameter(state, "state");
        Composer composerStartRestartGroup = composer.startRestartGroup(-724058698);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(SmartSubwayHorizontalCard)N(state,modifier,compact,onClick)222@7711L2216:SmartSubwayRealtime.kt#n9ob9m");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(state) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i9 = i2 & 2;
        if (i9 == 0) {
            if ((i & 48) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            i4 = i2 & 4;
            if (i4 != 0) {
                if ((i & 384) == 0) {
                    z2 = z;
                    if (composerStartRestartGroup.changed(z2)) {
                        i5 = 256;
                    } else {
                        i5 = 128;
                    }
                    i3 |= i5;
                }
                i6 = i2 & 8;
                if (i6 != 0) {
                    if ((i & 3072) == 0) {
                        if (composerStartRestartGroup.changedInstance(function0)) {
                            i7 = 2048;
                        } else {
                            i7 = 1024;
                        }
                        i3 |= i7;
                    }
                    if ((i3 & 1171) != 1170) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        function1 = function0;
                        modifier3 = modifier2;
                        z4 = z2;
                    } else {
                        if (i9 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i4 != 0) {
                            z5 = false;
                        } else {
                            z5 = z2;
                        }
                        if (i6 != 0) {
                            function2 = null;
                        } else {
                            function2 = function0;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-724058698, i3, -1, "com.example.tickets.SmartSubwayHorizontalCard (SmartSubwayRealtime.kt:218)");
                        }
                        smartSubwayHorizontalCardContentBuildSmartSubwayHorizontalCardContent = buildSmartSubwayHorizontalCardContent(state);
                        if (isAfterTransfer(state)) {
                            primaryLineColor = state.getSecondaryLineColor();
                        } else {
                            primaryLineColor = state.getPrimaryLineColor();
                        }
                        jColor = ColorKt.Color(primaryLineColor);
                        Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null);
                        if (z5) {
                            f = 20.0f;
                        } else {
                            f = 24.0f;
                        }
                        modifierBackground$default = BackgroundKt.background$default(ClipKt.clip(modifierFillMaxWidth$default, RoundedCornerShapeKt.m1756RoundedCornerShape0680j_4(Dp.m8748constructorimpl(f))), Brush.Companion.m5769verticalGradient8A3gB4$default(Brush.INSTANCE, CollectionsKt.listOf((Object[]) new Color[]{Color.m5828boximpl(Color.m5837copywmQWz5c$default(Color.INSTANCE.m5875getWhite0d7_KjU(), 0.095f, 0.0f, 0.0f, 0.0f, 14, null)), Color.m5828boximpl(Color.m5837copywmQWz5c$default(Color.INSTANCE.m5875getWhite0d7_KjU(), 0.042f, 0.0f, 0.0f, 0.0f, 14, null))}), 0.0f, 0.0f, 0, 14, (Object) null), null, 0.0f, 6, null);
                        if (function2 != null) {
                            modifierBackground$default = ClickableKt.m683clickableoSLSa3U$default(modifierBackground$default, false, null, null, null, function2, 15, null);
                        }
                        Function0<Unit> function3 = function2;
                        Modifier modifier4 = modifierBackground$default;
                        if (z5) {
                            f2 = 14.0f;
                        } else {
                            f2 = 18.0f;
                        }
                        float fM8748constructorimpl5 = Dp.m8748constructorimpl(f2);
                        if (z5) {
                            fM8748constructorimpl = Dp.m8748constructorimpl(12.0f);
                        } else {
                            fM8748constructorimpl = Dp.m8748constructorimpl(16.0f);
                        }
                        Modifier modifierM1424paddingVpY3zN4 = PaddingKt.m1424paddingVpY3zN4(modifier4, fM8748constructorimpl5, fM8748constructorimpl);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                        MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
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
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -629168580, "C234@8282L1476,269@9767L53,270@9829L92:SmartSubwayRealtime.kt#n9ob9m");
                        Modifier modifierFillMaxWidth$default2 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                        Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                        MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, composerStartRestartGroup, 48);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
                        int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                        CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxWidth$default2);
                        constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                        Modifier modifier5 = companion;
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
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1173178579, "C235@8384L173,240@8570L53,241@8636L1112:SmartSubwayRealtime.kt#n9ob9m");
                        lineName = state.getLineName();
                        if (StringsKt.isBlank(lineName)) {
                            lineName = "地铁";
                        }
                        int i10 = i3 & 896;
                        m9305SmartSubwayServiceBadgeiJQMabo(lineName, jColor, z5, composerStartRestartGroup, i10);
                        int i11 = i3;
                        z6 = z5;
                        Modifier.Companion companion2 = Modifier.INSTANCE;
                        if (z6) {
                            fM8748constructorimpl2 = Dp.m8748constructorimpl(10.0f);
                        } else {
                            fM8748constructorimpl2 = Dp.m8748constructorimpl(12.0f);
                        }
                        SpacerKt.Spacer(SizeKt.m1495width3ABfNKs(companion2, fM8748constructorimpl2), composerStartRestartGroup, 0);
                        Modifier modifierWeight$default = RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                        MeasurePolicy measurePolicyColumnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
                        int iHashCode3 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                        CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierWeight$default);
                        constructor3 = ComposeUiNode.INSTANCE.getConstructor();
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
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1102396972, "C242@8693L270,249@8980L52,250@9049L261:SmartSubwayRealtime.kt#n9ob9m");
                        String str = "当前站  " + smartSubwayHorizontalCardContentBuildSmartSubwayHorizontalCardContent.getCurrentStation();
                        long jM5875getWhite0d7_KjU = Color.INSTANCE.m5875getWhite0d7_KjU();
                        if (z6) {
                            i8 = 19;
                        } else {
                            i8 = 18;
                        }
                        TextKt.m3661TextNvy7gAk(str, null, jM5875getWhite0d7_KjU, null, TextUnitKt.getSp(i8), null, FontWeight.INSTANCE.getBold(), null, 0L, null, null, 0L, 0, false, 1, 0, null, null, composerStartRestartGroup, 1573248, 24576, 245674);
                        Modifier.Companion companion3 = Modifier.INSTANCE;
                        if (z6) {
                            fM8748constructorimpl3 = Dp.m8748constructorimpl(2.0f);
                        } else {
                            fM8748constructorimpl3 = Dp.m8748constructorimpl(3.0f);
                        }
                        SpacerKt.Spacer(SizeKt.m1476height3ABfNKs(companion3, fM8748constructorimpl3), composerStartRestartGroup, 0);
                        TextKt.m3661TextNvy7gAk(smartSubwayHorizontalCardContentBuildSmartSubwayHorizontalCardContent.getLineSummary(), null, jColor, null, TextUnitKt.getSp(13), null, FontWeight.INSTANCE.getSemiBold(), null, 0L, null, null, 0L, 0, false, 1, 0, null, null, composerStartRestartGroup, 1572864, 24576, 245674);
                        composer3 = composerStartRestartGroup;
                        if (!StringsKt.isBlank(smartSubwayHorizontalCardContentBuildSmartSubwayHorizontalCardContent.getStatusText())) {
                            composer3.startReplaceGroup(1093740252);
                        } else {
                            composer3.startReplaceGroup(1103041802);
                            ComposerKt.sourceInformation(composer3, "258@9386L29,259@9436L280");
                            SpacerKt.Spacer(SizeKt.m1476height3ABfNKs(Modifier.INSTANCE, Dp.m8748constructorimpl(2.0f)), composer3, 6);
                            TextKt.m3661TextNvy7gAk(smartSubwayHorizontalCardContentBuildSmartSubwayHorizontalCardContent.getStatusText(), null, jColor, null, TextUnitKt.getSp(12), null, FontWeight.INSTANCE.getBold(), null, 0L, null, null, 0L, 0, false, 1, 0, null, null, composer3, 1572864, 24576, 245674);
                            composer3 = composer3;
                        }
                        composer3.endReplaceGroup();
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
                        Modifier.Companion companion4 = Modifier.INSTANCE;
                        if (z6) {
                            fM8748constructorimpl4 = Dp.m8748constructorimpl(7.0f);
                        } else {
                            fM8748constructorimpl4 = Dp.m8748constructorimpl(10.0f);
                        }
                        SpacerKt.Spacer(SizeKt.m1476height3ABfNKs(companion4, fM8748constructorimpl4), composer3, 0);
                        Composer composer4 = composer3;
                        SmartSubwayRouteCanvas(state, SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), z6, composer4, (i11 & 14) | 48 | i10, 0);
                        composer2 = composer4;
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        composer2.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        z4 = z6;
                        function1 = function3;
                        modifier3 = modifier5;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.tickets.SmartSubwayRealtimeKt$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return SmartSubwayRealtimeKt.SmartSubwayHorizontalCard$lambda$12(state, modifier3, z4, function1, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= 3072;
                if ((i3 & 1171) != 1170) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    function1 = function0;
                    modifier3 = modifier2;
                    z4 = z2;
                } else {
                    if (i9 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i4 != 0) {
                        z5 = false;
                    } else {
                        z5 = z2;
                    }
                    if (i6 != 0) {
                        function2 = null;
                    } else {
                        function2 = function0;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-724058698, i3, -1, "com.example.tickets.SmartSubwayHorizontalCard (SmartSubwayRealtime.kt:218)");
                    }
                    smartSubwayHorizontalCardContentBuildSmartSubwayHorizontalCardContent = buildSmartSubwayHorizontalCardContent(state);
                    if (isAfterTransfer(state)) {
                        primaryLineColor = state.getSecondaryLineColor();
                    } else {
                        primaryLineColor = state.getPrimaryLineColor();
                    }
                    jColor = ColorKt.Color(primaryLineColor);
                    Modifier modifierFillMaxWidth$default3 = SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null);
                    if (z5) {
                        f = 20.0f;
                    } else {
                        f = 24.0f;
                    }
                    modifierBackground$default = BackgroundKt.background$default(ClipKt.clip(modifierFillMaxWidth$default3, RoundedCornerShapeKt.m1756RoundedCornerShape0680j_4(Dp.m8748constructorimpl(f))), Brush.Companion.m5769verticalGradient8A3gB4$default(Brush.INSTANCE, CollectionsKt.listOf((Object[]) new Color[]{Color.m5828boximpl(Color.m5837copywmQWz5c$default(Color.INSTANCE.m5875getWhite0d7_KjU(), 0.095f, 0.0f, 0.0f, 0.0f, 14, null)), Color.m5828boximpl(Color.m5837copywmQWz5c$default(Color.INSTANCE.m5875getWhite0d7_KjU(), 0.042f, 0.0f, 0.0f, 0.0f, 14, null))}), 0.0f, 0.0f, 0, 14, (Object) null), null, 0.0f, 6, null);
                    if (function2 != null) {
                        modifierBackground$default = ClickableKt.m683clickableoSLSa3U$default(modifierBackground$default, false, null, null, null, function2, 15, null);
                    }
                    Function0<Unit> function4 = function2;
                    Modifier modifier6 = modifierBackground$default;
                    if (z5) {
                        f2 = 14.0f;
                    } else {
                        f2 = 18.0f;
                    }
                    float fM8748constructorimpl6 = Dp.m8748constructorimpl(f2);
                    if (z5) {
                        fM8748constructorimpl = Dp.m8748constructorimpl(12.0f);
                    } else {
                        fM8748constructorimpl = Dp.m8748constructorimpl(16.0f);
                    }
                    Modifier modifierM1424paddingVpY3zN5 = PaddingKt.m1424paddingVpY3zN4(modifier6, fM8748constructorimpl6, fM8748constructorimpl);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                    MeasurePolicy measurePolicyColumnMeasurePolicy3 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
                    int iHashCode4 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap4 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1424paddingVpY3zN5);
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
                    Composer composerM4937constructorimpl4 = Updater.m4937constructorimpl(composerStartRestartGroup);
                    Updater.m4945setimpl(composerM4937constructorimpl4, measurePolicyColumnMeasurePolicy3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m4945setimpl(composerM4937constructorimpl4, currentCompositionLocalMap4, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Updater.m4945setimpl(composerM4937constructorimpl4, Integer.valueOf(iHashCode4), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                    Updater.m4943reconcileimpl(composerM4937constructorimpl4, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                    Updater.m4945setimpl(composerM4937constructorimpl4, modifierMaterializeModifier4, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                    ColumnScopeInstance columnScopeInstance3 = ColumnScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -629168580, "C234@8282L1476,269@9767L53,270@9829L92:SmartSubwayRealtime.kt#n9ob9m");
                    Modifier modifierFillMaxWidth$default4 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                    Alignment.Vertical centerVertically2 = Alignment.INSTANCE.getCenterVertically();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                    MeasurePolicy measurePolicyRowMeasurePolicy2 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically2, composerStartRestartGroup, 48);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
                    int iHashCode5 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap5 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier5 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxWidth$default4);
                    constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                    Modifier modifier7 = companion;
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
                    Composer composerM4937constructorimpl5 = Updater.m4937constructorimpl(composerStartRestartGroup);
                    Updater.m4945setimpl(composerM4937constructorimpl5, measurePolicyRowMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m4945setimpl(composerM4937constructorimpl5, currentCompositionLocalMap5, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Updater.m4945setimpl(composerM4937constructorimpl5, Integer.valueOf(iHashCode5), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                    Updater.m4943reconcileimpl(composerM4937constructorimpl5, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                    Updater.m4945setimpl(composerM4937constructorimpl5, modifierMaterializeModifier5, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                    RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1173178579, "C235@8384L173,240@8570L53,241@8636L1112:SmartSubwayRealtime.kt#n9ob9m");
                    lineName = state.getLineName();
                    if (StringsKt.isBlank(lineName)) {
                        lineName = "地铁";
                    }
                    int i12 = i3 & 896;
                    m9305SmartSubwayServiceBadgeiJQMabo(lineName, jColor, z5, composerStartRestartGroup, i12);
                    int i13 = i3;
                    z6 = z5;
                    Modifier.Companion companion5 = Modifier.INSTANCE;
                    if (z6) {
                        fM8748constructorimpl2 = Dp.m8748constructorimpl(10.0f);
                    } else {
                        fM8748constructorimpl2 = Dp.m8748constructorimpl(12.0f);
                    }
                    SpacerKt.Spacer(SizeKt.m1495width3ABfNKs(companion5, fM8748constructorimpl2), composerStartRestartGroup, 0);
                    Modifier modifierWeight$default2 = RowScope.weight$default(rowScopeInstance2, Modifier.INSTANCE, 1.0f, false, 2, null);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                    MeasurePolicy measurePolicyColumnMeasurePolicy4 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
                    int iHashCode6 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap6 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier6 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierWeight$default2);
                    constructor3 = ComposeUiNode.INSTANCE.getConstructor();
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
                    Composer composerM4937constructorimpl6 = Updater.m4937constructorimpl(composerStartRestartGroup);
                    Updater.m4945setimpl(composerM4937constructorimpl6, measurePolicyColumnMeasurePolicy4, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m4945setimpl(composerM4937constructorimpl6, currentCompositionLocalMap6, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Updater.m4945setimpl(composerM4937constructorimpl6, Integer.valueOf(iHashCode6), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                    Updater.m4943reconcileimpl(composerM4937constructorimpl6, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                    Updater.m4945setimpl(composerM4937constructorimpl6, modifierMaterializeModifier6, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                    ColumnScopeInstance columnScopeInstance4 = ColumnScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1102396972, "C242@8693L270,249@8980L52,250@9049L261:SmartSubwayRealtime.kt#n9ob9m");
                    String str2 = "当前站  " + smartSubwayHorizontalCardContentBuildSmartSubwayHorizontalCardContent.getCurrentStation();
                    long jM5875getWhite0d7_KjU2 = Color.INSTANCE.m5875getWhite0d7_KjU();
                    if (z6) {
                        i8 = 19;
                    } else {
                        i8 = 18;
                    }
                    TextKt.m3661TextNvy7gAk(str2, null, jM5875getWhite0d7_KjU2, null, TextUnitKt.getSp(i8), null, FontWeight.INSTANCE.getBold(), null, 0L, null, null, 0L, 0, false, 1, 0, null, null, composerStartRestartGroup, 1573248, 24576, 245674);
                    Modifier.Companion companion6 = Modifier.INSTANCE;
                    if (z6) {
                        fM8748constructorimpl3 = Dp.m8748constructorimpl(2.0f);
                    } else {
                        fM8748constructorimpl3 = Dp.m8748constructorimpl(3.0f);
                    }
                    SpacerKt.Spacer(SizeKt.m1476height3ABfNKs(companion6, fM8748constructorimpl3), composerStartRestartGroup, 0);
                    TextKt.m3661TextNvy7gAk(smartSubwayHorizontalCardContentBuildSmartSubwayHorizontalCardContent.getLineSummary(), null, jColor, null, TextUnitKt.getSp(13), null, FontWeight.INSTANCE.getSemiBold(), null, 0L, null, null, 0L, 0, false, 1, 0, null, null, composerStartRestartGroup, 1572864, 24576, 245674);
                    composer3 = composerStartRestartGroup;
                    if (!StringsKt.isBlank(smartSubwayHorizontalCardContentBuildSmartSubwayHorizontalCardContent.getStatusText())) {
                        composer3.startReplaceGroup(1093740252);
                    } else {
                        composer3.startReplaceGroup(1103041802);
                        ComposerKt.sourceInformation(composer3, "258@9386L29,259@9436L280");
                        SpacerKt.Spacer(SizeKt.m1476height3ABfNKs(Modifier.INSTANCE, Dp.m8748constructorimpl(2.0f)), composer3, 6);
                        TextKt.m3661TextNvy7gAk(smartSubwayHorizontalCardContentBuildSmartSubwayHorizontalCardContent.getStatusText(), null, jColor, null, TextUnitKt.getSp(12), null, FontWeight.INSTANCE.getBold(), null, 0L, null, null, 0L, 0, false, 1, 0, null, null, composer3, 1572864, 24576, 245674);
                        composer3 = composer3;
                    }
                    composer3.endReplaceGroup();
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
                    Modifier.Companion companion7 = Modifier.INSTANCE;
                    if (z6) {
                        fM8748constructorimpl4 = Dp.m8748constructorimpl(7.0f);
                    } else {
                        fM8748constructorimpl4 = Dp.m8748constructorimpl(10.0f);
                    }
                    SpacerKt.Spacer(SizeKt.m1476height3ABfNKs(companion7, fM8748constructorimpl4), composer3, 0);
                    Composer composer5 = composer3;
                    SmartSubwayRouteCanvas(state, SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), z6, composer5, (i13 & 14) | 48 | i12, 0);
                    composer2 = composer5;
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    composer2.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z4 = z6;
                    function1 = function4;
                    modifier3 = modifier7;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.tickets.SmartSubwayRealtimeKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return SmartSubwayRealtimeKt.SmartSubwayHorizontalCard$lambda$12(state, modifier3, z4, function1, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 384;
            z2 = z;
            i6 = i2 & 8;
            if (i6 != 0) {
                if ((i & 3072) == 0) {
                    if (composerStartRestartGroup.changedInstance(function0)) {
                        i7 = 2048;
                    } else {
                        i7 = 1024;
                    }
                    i3 |= i7;
                }
                if ((i3 & 1171) != 1170) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    function1 = function0;
                    modifier3 = modifier2;
                    z4 = z2;
                } else {
                    if (i9 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i4 != 0) {
                        z5 = false;
                    } else {
                        z5 = z2;
                    }
                    if (i6 != 0) {
                        function2 = null;
                    } else {
                        function2 = function0;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-724058698, i3, -1, "com.example.tickets.SmartSubwayHorizontalCard (SmartSubwayRealtime.kt:218)");
                    }
                    smartSubwayHorizontalCardContentBuildSmartSubwayHorizontalCardContent = buildSmartSubwayHorizontalCardContent(state);
                    if (isAfterTransfer(state)) {
                        primaryLineColor = state.getSecondaryLineColor();
                    } else {
                        primaryLineColor = state.getPrimaryLineColor();
                    }
                    jColor = ColorKt.Color(primaryLineColor);
                    Modifier modifierFillMaxWidth$default5 = SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null);
                    if (z5) {
                        f = 20.0f;
                    } else {
                        f = 24.0f;
                    }
                    modifierBackground$default = BackgroundKt.background$default(ClipKt.clip(modifierFillMaxWidth$default5, RoundedCornerShapeKt.m1756RoundedCornerShape0680j_4(Dp.m8748constructorimpl(f))), Brush.Companion.m5769verticalGradient8A3gB4$default(Brush.INSTANCE, CollectionsKt.listOf((Object[]) new Color[]{Color.m5828boximpl(Color.m5837copywmQWz5c$default(Color.INSTANCE.m5875getWhite0d7_KjU(), 0.095f, 0.0f, 0.0f, 0.0f, 14, null)), Color.m5828boximpl(Color.m5837copywmQWz5c$default(Color.INSTANCE.m5875getWhite0d7_KjU(), 0.042f, 0.0f, 0.0f, 0.0f, 14, null))}), 0.0f, 0.0f, 0, 14, (Object) null), null, 0.0f, 6, null);
                    if (function2 != null) {
                        modifierBackground$default = ClickableKt.m683clickableoSLSa3U$default(modifierBackground$default, false, null, null, null, function2, 15, null);
                    }
                    Function0<Unit> function5 = function2;
                    Modifier modifier8 = modifierBackground$default;
                    if (z5) {
                        f2 = 14.0f;
                    } else {
                        f2 = 18.0f;
                    }
                    float fM8748constructorimpl7 = Dp.m8748constructorimpl(f2);
                    if (z5) {
                        fM8748constructorimpl = Dp.m8748constructorimpl(12.0f);
                    } else {
                        fM8748constructorimpl = Dp.m8748constructorimpl(16.0f);
                    }
                    Modifier modifierM1424paddingVpY3zN6 = PaddingKt.m1424paddingVpY3zN4(modifier8, fM8748constructorimpl7, fM8748constructorimpl);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                    MeasurePolicy measurePolicyColumnMeasurePolicy5 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
                    int iHashCode7 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap7 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier7 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1424paddingVpY3zN6);
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
                    Updater.m4945setimpl(composerM4937constructorimpl7, measurePolicyColumnMeasurePolicy5, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m4945setimpl(composerM4937constructorimpl7, currentCompositionLocalMap7, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Updater.m4945setimpl(composerM4937constructorimpl7, Integer.valueOf(iHashCode7), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                    Updater.m4943reconcileimpl(composerM4937constructorimpl7, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                    Updater.m4945setimpl(composerM4937constructorimpl7, modifierMaterializeModifier7, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                    ColumnScopeInstance columnScopeInstance5 = ColumnScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -629168580, "C234@8282L1476,269@9767L53,270@9829L92:SmartSubwayRealtime.kt#n9ob9m");
                    Modifier modifierFillMaxWidth$default6 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                    Alignment.Vertical centerVertically3 = Alignment.INSTANCE.getCenterVertically();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                    MeasurePolicy measurePolicyRowMeasurePolicy3 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically3, composerStartRestartGroup, 48);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
                    int iHashCode8 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap8 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier8 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxWidth$default6);
                    constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                    Modifier modifier9 = companion;
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
                    Composer composerM4937constructorimpl8 = Updater.m4937constructorimpl(composerStartRestartGroup);
                    Updater.m4945setimpl(composerM4937constructorimpl8, measurePolicyRowMeasurePolicy3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m4945setimpl(composerM4937constructorimpl8, currentCompositionLocalMap8, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Updater.m4945setimpl(composerM4937constructorimpl8, Integer.valueOf(iHashCode8), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                    Updater.m4943reconcileimpl(composerM4937constructorimpl8, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                    Updater.m4945setimpl(composerM4937constructorimpl8, modifierMaterializeModifier8, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                    RowScopeInstance rowScopeInstance3 = RowScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1173178579, "C235@8384L173,240@8570L53,241@8636L1112:SmartSubwayRealtime.kt#n9ob9m");
                    lineName = state.getLineName();
                    if (StringsKt.isBlank(lineName)) {
                        lineName = "地铁";
                    }
                    int i14 = i3 & 896;
                    m9305SmartSubwayServiceBadgeiJQMabo(lineName, jColor, z5, composerStartRestartGroup, i14);
                    int i15 = i3;
                    z6 = z5;
                    Modifier.Companion companion8 = Modifier.INSTANCE;
                    if (z6) {
                        fM8748constructorimpl2 = Dp.m8748constructorimpl(10.0f);
                    } else {
                        fM8748constructorimpl2 = Dp.m8748constructorimpl(12.0f);
                    }
                    SpacerKt.Spacer(SizeKt.m1495width3ABfNKs(companion8, fM8748constructorimpl2), composerStartRestartGroup, 0);
                    Modifier modifierWeight$default3 = RowScope.weight$default(rowScopeInstance3, Modifier.INSTANCE, 1.0f, false, 2, null);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                    MeasurePolicy measurePolicyColumnMeasurePolicy6 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
                    int iHashCode9 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap9 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier9 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierWeight$default3);
                    constructor3 = ComposeUiNode.INSTANCE.getConstructor();
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
                    Composer composerM4937constructorimpl9 = Updater.m4937constructorimpl(composerStartRestartGroup);
                    Updater.m4945setimpl(composerM4937constructorimpl9, measurePolicyColumnMeasurePolicy6, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m4945setimpl(composerM4937constructorimpl9, currentCompositionLocalMap9, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Updater.m4945setimpl(composerM4937constructorimpl9, Integer.valueOf(iHashCode9), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                    Updater.m4943reconcileimpl(composerM4937constructorimpl9, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                    Updater.m4945setimpl(composerM4937constructorimpl9, modifierMaterializeModifier9, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                    ColumnScopeInstance columnScopeInstance6 = ColumnScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1102396972, "C242@8693L270,249@8980L52,250@9049L261:SmartSubwayRealtime.kt#n9ob9m");
                    String str3 = "当前站  " + smartSubwayHorizontalCardContentBuildSmartSubwayHorizontalCardContent.getCurrentStation();
                    long jM5875getWhite0d7_KjU3 = Color.INSTANCE.m5875getWhite0d7_KjU();
                    if (z6) {
                        i8 = 19;
                    } else {
                        i8 = 18;
                    }
                    TextKt.m3661TextNvy7gAk(str3, null, jM5875getWhite0d7_KjU3, null, TextUnitKt.getSp(i8), null, FontWeight.INSTANCE.getBold(), null, 0L, null, null, 0L, 0, false, 1, 0, null, null, composerStartRestartGroup, 1573248, 24576, 245674);
                    Modifier.Companion companion9 = Modifier.INSTANCE;
                    if (z6) {
                        fM8748constructorimpl3 = Dp.m8748constructorimpl(2.0f);
                    } else {
                        fM8748constructorimpl3 = Dp.m8748constructorimpl(3.0f);
                    }
                    SpacerKt.Spacer(SizeKt.m1476height3ABfNKs(companion9, fM8748constructorimpl3), composerStartRestartGroup, 0);
                    TextKt.m3661TextNvy7gAk(smartSubwayHorizontalCardContentBuildSmartSubwayHorizontalCardContent.getLineSummary(), null, jColor, null, TextUnitKt.getSp(13), null, FontWeight.INSTANCE.getSemiBold(), null, 0L, null, null, 0L, 0, false, 1, 0, null, null, composerStartRestartGroup, 1572864, 24576, 245674);
                    composer3 = composerStartRestartGroup;
                    if (!StringsKt.isBlank(smartSubwayHorizontalCardContentBuildSmartSubwayHorizontalCardContent.getStatusText())) {
                        composer3.startReplaceGroup(1093740252);
                    } else {
                        composer3.startReplaceGroup(1103041802);
                        ComposerKt.sourceInformation(composer3, "258@9386L29,259@9436L280");
                        SpacerKt.Spacer(SizeKt.m1476height3ABfNKs(Modifier.INSTANCE, Dp.m8748constructorimpl(2.0f)), composer3, 6);
                        TextKt.m3661TextNvy7gAk(smartSubwayHorizontalCardContentBuildSmartSubwayHorizontalCardContent.getStatusText(), null, jColor, null, TextUnitKt.getSp(12), null, FontWeight.INSTANCE.getBold(), null, 0L, null, null, 0L, 0, false, 1, 0, null, null, composer3, 1572864, 24576, 245674);
                        composer3 = composer3;
                    }
                    composer3.endReplaceGroup();
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
                    Modifier.Companion companion10 = Modifier.INSTANCE;
                    if (z6) {
                        fM8748constructorimpl4 = Dp.m8748constructorimpl(7.0f);
                    } else {
                        fM8748constructorimpl4 = Dp.m8748constructorimpl(10.0f);
                    }
                    SpacerKt.Spacer(SizeKt.m1476height3ABfNKs(companion10, fM8748constructorimpl4), composer3, 0);
                    Composer composer6 = composer3;
                    SmartSubwayRouteCanvas(state, SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), z6, composer6, (i15 & 14) | 48 | i14, 0);
                    composer2 = composer6;
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    composer2.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z4 = z6;
                    function1 = function5;
                    modifier3 = modifier9;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.tickets.SmartSubwayRealtimeKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return SmartSubwayRealtimeKt.SmartSubwayHorizontalCard$lambda$12(state, modifier3, z4, function1, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 3072;
            if ((i3 & 1171) != 1170) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                function1 = function0;
                modifier3 = modifier2;
                z4 = z2;
            } else {
                if (i9 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i4 != 0) {
                    z5 = false;
                } else {
                    z5 = z2;
                }
                if (i6 != 0) {
                    function2 = null;
                } else {
                    function2 = function0;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-724058698, i3, -1, "com.example.tickets.SmartSubwayHorizontalCard (SmartSubwayRealtime.kt:218)");
                }
                smartSubwayHorizontalCardContentBuildSmartSubwayHorizontalCardContent = buildSmartSubwayHorizontalCardContent(state);
                if (isAfterTransfer(state)) {
                    primaryLineColor = state.getSecondaryLineColor();
                } else {
                    primaryLineColor = state.getPrimaryLineColor();
                }
                jColor = ColorKt.Color(primaryLineColor);
                Modifier modifierFillMaxWidth$default7 = SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null);
                if (z5) {
                    f = 20.0f;
                } else {
                    f = 24.0f;
                }
                modifierBackground$default = BackgroundKt.background$default(ClipKt.clip(modifierFillMaxWidth$default7, RoundedCornerShapeKt.m1756RoundedCornerShape0680j_4(Dp.m8748constructorimpl(f))), Brush.Companion.m5769verticalGradient8A3gB4$default(Brush.INSTANCE, CollectionsKt.listOf((Object[]) new Color[]{Color.m5828boximpl(Color.m5837copywmQWz5c$default(Color.INSTANCE.m5875getWhite0d7_KjU(), 0.095f, 0.0f, 0.0f, 0.0f, 14, null)), Color.m5828boximpl(Color.m5837copywmQWz5c$default(Color.INSTANCE.m5875getWhite0d7_KjU(), 0.042f, 0.0f, 0.0f, 0.0f, 14, null))}), 0.0f, 0.0f, 0, 14, (Object) null), null, 0.0f, 6, null);
                if (function2 != null) {
                    modifierBackground$default = ClickableKt.m683clickableoSLSa3U$default(modifierBackground$default, false, null, null, null, function2, 15, null);
                }
                Function0<Unit> function6 = function2;
                Modifier modifier10 = modifierBackground$default;
                if (z5) {
                    f2 = 14.0f;
                } else {
                    f2 = 18.0f;
                }
                float fM8748constructorimpl8 = Dp.m8748constructorimpl(f2);
                if (z5) {
                    fM8748constructorimpl = Dp.m8748constructorimpl(12.0f);
                } else {
                    fM8748constructorimpl = Dp.m8748constructorimpl(16.0f);
                }
                Modifier modifierM1424paddingVpY3zN7 = PaddingKt.m1424paddingVpY3zN4(modifier10, fM8748constructorimpl8, fM8748constructorimpl);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                MeasurePolicy measurePolicyColumnMeasurePolicy7 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
                int iHashCode10 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap10 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier10 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1424paddingVpY3zN7);
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
                Composer composerM4937constructorimpl10 = Updater.m4937constructorimpl(composerStartRestartGroup);
                Updater.m4945setimpl(composerM4937constructorimpl10, measurePolicyColumnMeasurePolicy7, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m4945setimpl(composerM4937constructorimpl10, currentCompositionLocalMap10, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Updater.m4945setimpl(composerM4937constructorimpl10, Integer.valueOf(iHashCode10), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                Updater.m4943reconcileimpl(composerM4937constructorimpl10, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                Updater.m4945setimpl(composerM4937constructorimpl10, modifierMaterializeModifier10, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                ColumnScopeInstance columnScopeInstance7 = ColumnScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -629168580, "C234@8282L1476,269@9767L53,270@9829L92:SmartSubwayRealtime.kt#n9ob9m");
                Modifier modifierFillMaxWidth$default8 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                Alignment.Vertical centerVertically4 = Alignment.INSTANCE.getCenterVertically();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                MeasurePolicy measurePolicyRowMeasurePolicy4 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically4, composerStartRestartGroup, 48);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
                int iHashCode11 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap11 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier11 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxWidth$default8);
                constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                Modifier modifier11 = companion;
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
                Composer composerM4937constructorimpl11 = Updater.m4937constructorimpl(composerStartRestartGroup);
                Updater.m4945setimpl(composerM4937constructorimpl11, measurePolicyRowMeasurePolicy4, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m4945setimpl(composerM4937constructorimpl11, currentCompositionLocalMap11, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Updater.m4945setimpl(composerM4937constructorimpl11, Integer.valueOf(iHashCode11), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                Updater.m4943reconcileimpl(composerM4937constructorimpl11, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                Updater.m4945setimpl(composerM4937constructorimpl11, modifierMaterializeModifier11, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                RowScopeInstance rowScopeInstance4 = RowScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1173178579, "C235@8384L173,240@8570L53,241@8636L1112:SmartSubwayRealtime.kt#n9ob9m");
                lineName = state.getLineName();
                if (StringsKt.isBlank(lineName)) {
                    lineName = "地铁";
                }
                int i16 = i3 & 896;
                m9305SmartSubwayServiceBadgeiJQMabo(lineName, jColor, z5, composerStartRestartGroup, i16);
                int i17 = i3;
                z6 = z5;
                Modifier.Companion companion11 = Modifier.INSTANCE;
                if (z6) {
                    fM8748constructorimpl2 = Dp.m8748constructorimpl(10.0f);
                } else {
                    fM8748constructorimpl2 = Dp.m8748constructorimpl(12.0f);
                }
                SpacerKt.Spacer(SizeKt.m1495width3ABfNKs(companion11, fM8748constructorimpl2), composerStartRestartGroup, 0);
                Modifier modifierWeight$default4 = RowScope.weight$default(rowScopeInstance4, Modifier.INSTANCE, 1.0f, false, 2, null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                MeasurePolicy measurePolicyColumnMeasurePolicy8 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
                int iHashCode12 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap12 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier12 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierWeight$default4);
                constructor3 = ComposeUiNode.INSTANCE.getConstructor();
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
                Composer composerM4937constructorimpl12 = Updater.m4937constructorimpl(composerStartRestartGroup);
                Updater.m4945setimpl(composerM4937constructorimpl12, measurePolicyColumnMeasurePolicy8, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m4945setimpl(composerM4937constructorimpl12, currentCompositionLocalMap12, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Updater.m4945setimpl(composerM4937constructorimpl12, Integer.valueOf(iHashCode12), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                Updater.m4943reconcileimpl(composerM4937constructorimpl12, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                Updater.m4945setimpl(composerM4937constructorimpl12, modifierMaterializeModifier12, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                ColumnScopeInstance columnScopeInstance8 = ColumnScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1102396972, "C242@8693L270,249@8980L52,250@9049L261:SmartSubwayRealtime.kt#n9ob9m");
                String str4 = "当前站  " + smartSubwayHorizontalCardContentBuildSmartSubwayHorizontalCardContent.getCurrentStation();
                long jM5875getWhite0d7_KjU4 = Color.INSTANCE.m5875getWhite0d7_KjU();
                if (z6) {
                    i8 = 19;
                } else {
                    i8 = 18;
                }
                TextKt.m3661TextNvy7gAk(str4, null, jM5875getWhite0d7_KjU4, null, TextUnitKt.getSp(i8), null, FontWeight.INSTANCE.getBold(), null, 0L, null, null, 0L, 0, false, 1, 0, null, null, composerStartRestartGroup, 1573248, 24576, 245674);
                Modifier.Companion companion12 = Modifier.INSTANCE;
                if (z6) {
                    fM8748constructorimpl3 = Dp.m8748constructorimpl(2.0f);
                } else {
                    fM8748constructorimpl3 = Dp.m8748constructorimpl(3.0f);
                }
                SpacerKt.Spacer(SizeKt.m1476height3ABfNKs(companion12, fM8748constructorimpl3), composerStartRestartGroup, 0);
                TextKt.m3661TextNvy7gAk(smartSubwayHorizontalCardContentBuildSmartSubwayHorizontalCardContent.getLineSummary(), null, jColor, null, TextUnitKt.getSp(13), null, FontWeight.INSTANCE.getSemiBold(), null, 0L, null, null, 0L, 0, false, 1, 0, null, null, composerStartRestartGroup, 1572864, 24576, 245674);
                composer3 = composerStartRestartGroup;
                if (!StringsKt.isBlank(smartSubwayHorizontalCardContentBuildSmartSubwayHorizontalCardContent.getStatusText())) {
                    composer3.startReplaceGroup(1093740252);
                } else {
                    composer3.startReplaceGroup(1103041802);
                    ComposerKt.sourceInformation(composer3, "258@9386L29,259@9436L280");
                    SpacerKt.Spacer(SizeKt.m1476height3ABfNKs(Modifier.INSTANCE, Dp.m8748constructorimpl(2.0f)), composer3, 6);
                    TextKt.m3661TextNvy7gAk(smartSubwayHorizontalCardContentBuildSmartSubwayHorizontalCardContent.getStatusText(), null, jColor, null, TextUnitKt.getSp(12), null, FontWeight.INSTANCE.getBold(), null, 0L, null, null, 0L, 0, false, 1, 0, null, null, composer3, 1572864, 24576, 245674);
                    composer3 = composer3;
                }
                composer3.endReplaceGroup();
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
                Modifier.Companion companion13 = Modifier.INSTANCE;
                if (z6) {
                    fM8748constructorimpl4 = Dp.m8748constructorimpl(7.0f);
                } else {
                    fM8748constructorimpl4 = Dp.m8748constructorimpl(10.0f);
                }
                SpacerKt.Spacer(SizeKt.m1476height3ABfNKs(companion13, fM8748constructorimpl4), composer3, 0);
                Composer composer7 = composer3;
                SmartSubwayRouteCanvas(state, SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), z6, composer7, (i17 & 14) | 48 | i16, 0);
                composer2 = composer7;
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z4 = z6;
                function1 = function6;
                modifier3 = modifier11;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.tickets.SmartSubwayRealtimeKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return SmartSubwayRealtimeKt.SmartSubwayHorizontalCard$lambda$12(state, modifier3, z4, function1, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 48;
        modifier2 = modifier;
        i4 = i2 & 4;
        if (i4 != 0) {
            if ((i & 384) == 0) {
                z2 = z;
                if (composerStartRestartGroup.changed(z2)) {
                    i5 = 256;
                } else {
                    i5 = 128;
                }
                i3 |= i5;
            }
            i6 = i2 & 8;
            if (i6 != 0) {
                if ((i & 3072) == 0) {
                    if (composerStartRestartGroup.changedInstance(function0)) {
                        i7 = 2048;
                    } else {
                        i7 = 1024;
                    }
                    i3 |= i7;
                }
                if ((i3 & 1171) != 1170) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    function1 = function0;
                    modifier3 = modifier2;
                    z4 = z2;
                } else {
                    if (i9 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i4 != 0) {
                        z5 = false;
                    } else {
                        z5 = z2;
                    }
                    if (i6 != 0) {
                        function2 = null;
                    } else {
                        function2 = function0;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-724058698, i3, -1, "com.example.tickets.SmartSubwayHorizontalCard (SmartSubwayRealtime.kt:218)");
                    }
                    smartSubwayHorizontalCardContentBuildSmartSubwayHorizontalCardContent = buildSmartSubwayHorizontalCardContent(state);
                    if (isAfterTransfer(state)) {
                        primaryLineColor = state.getSecondaryLineColor();
                    } else {
                        primaryLineColor = state.getPrimaryLineColor();
                    }
                    jColor = ColorKt.Color(primaryLineColor);
                    Modifier modifierFillMaxWidth$default9 = SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null);
                    if (z5) {
                        f = 20.0f;
                    } else {
                        f = 24.0f;
                    }
                    modifierBackground$default = BackgroundKt.background$default(ClipKt.clip(modifierFillMaxWidth$default9, RoundedCornerShapeKt.m1756RoundedCornerShape0680j_4(Dp.m8748constructorimpl(f))), Brush.Companion.m5769verticalGradient8A3gB4$default(Brush.INSTANCE, CollectionsKt.listOf((Object[]) new Color[]{Color.m5828boximpl(Color.m5837copywmQWz5c$default(Color.INSTANCE.m5875getWhite0d7_KjU(), 0.095f, 0.0f, 0.0f, 0.0f, 14, null)), Color.m5828boximpl(Color.m5837copywmQWz5c$default(Color.INSTANCE.m5875getWhite0d7_KjU(), 0.042f, 0.0f, 0.0f, 0.0f, 14, null))}), 0.0f, 0.0f, 0, 14, (Object) null), null, 0.0f, 6, null);
                    if (function2 != null) {
                        modifierBackground$default = ClickableKt.m683clickableoSLSa3U$default(modifierBackground$default, false, null, null, null, function2, 15, null);
                    }
                    Function0<Unit> function7 = function2;
                    Modifier modifier12 = modifierBackground$default;
                    if (z5) {
                        f2 = 14.0f;
                    } else {
                        f2 = 18.0f;
                    }
                    float fM8748constructorimpl9 = Dp.m8748constructorimpl(f2);
                    if (z5) {
                        fM8748constructorimpl = Dp.m8748constructorimpl(12.0f);
                    } else {
                        fM8748constructorimpl = Dp.m8748constructorimpl(16.0f);
                    }
                    Modifier modifierM1424paddingVpY3zN8 = PaddingKt.m1424paddingVpY3zN4(modifier12, fM8748constructorimpl9, fM8748constructorimpl);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                    MeasurePolicy measurePolicyColumnMeasurePolicy9 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
                    int iHashCode13 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap13 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier13 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1424paddingVpY3zN8);
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
                    Updater.m4945setimpl(composerM4937constructorimpl13, measurePolicyColumnMeasurePolicy9, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m4945setimpl(composerM4937constructorimpl13, currentCompositionLocalMap13, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Updater.m4945setimpl(composerM4937constructorimpl13, Integer.valueOf(iHashCode13), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                    Updater.m4943reconcileimpl(composerM4937constructorimpl13, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                    Updater.m4945setimpl(composerM4937constructorimpl13, modifierMaterializeModifier13, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                    ColumnScopeInstance columnScopeInstance9 = ColumnScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -629168580, "C234@8282L1476,269@9767L53,270@9829L92:SmartSubwayRealtime.kt#n9ob9m");
                    Modifier modifierFillMaxWidth$default10 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                    Alignment.Vertical centerVertically5 = Alignment.INSTANCE.getCenterVertically();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                    MeasurePolicy measurePolicyRowMeasurePolicy5 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically5, composerStartRestartGroup, 48);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
                    int iHashCode14 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap14 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier14 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxWidth$default10);
                    constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                    Modifier modifier13 = companion;
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
                    Composer composerM4937constructorimpl14 = Updater.m4937constructorimpl(composerStartRestartGroup);
                    Updater.m4945setimpl(composerM4937constructorimpl14, measurePolicyRowMeasurePolicy5, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m4945setimpl(composerM4937constructorimpl14, currentCompositionLocalMap14, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Updater.m4945setimpl(composerM4937constructorimpl14, Integer.valueOf(iHashCode14), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                    Updater.m4943reconcileimpl(composerM4937constructorimpl14, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                    Updater.m4945setimpl(composerM4937constructorimpl14, modifierMaterializeModifier14, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                    RowScopeInstance rowScopeInstance5 = RowScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1173178579, "C235@8384L173,240@8570L53,241@8636L1112:SmartSubwayRealtime.kt#n9ob9m");
                    lineName = state.getLineName();
                    if (StringsKt.isBlank(lineName)) {
                        lineName = "地铁";
                    }
                    int i18 = i3 & 896;
                    m9305SmartSubwayServiceBadgeiJQMabo(lineName, jColor, z5, composerStartRestartGroup, i18);
                    int i19 = i3;
                    z6 = z5;
                    Modifier.Companion companion14 = Modifier.INSTANCE;
                    if (z6) {
                        fM8748constructorimpl2 = Dp.m8748constructorimpl(10.0f);
                    } else {
                        fM8748constructorimpl2 = Dp.m8748constructorimpl(12.0f);
                    }
                    SpacerKt.Spacer(SizeKt.m1495width3ABfNKs(companion14, fM8748constructorimpl2), composerStartRestartGroup, 0);
                    Modifier modifierWeight$default5 = RowScope.weight$default(rowScopeInstance5, Modifier.INSTANCE, 1.0f, false, 2, null);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                    MeasurePolicy measurePolicyColumnMeasurePolicy10 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
                    int iHashCode15 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap15 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier15 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierWeight$default5);
                    constructor3 = ComposeUiNode.INSTANCE.getConstructor();
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
                    Composer composerM4937constructorimpl15 = Updater.m4937constructorimpl(composerStartRestartGroup);
                    Updater.m4945setimpl(composerM4937constructorimpl15, measurePolicyColumnMeasurePolicy10, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m4945setimpl(composerM4937constructorimpl15, currentCompositionLocalMap15, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Updater.m4945setimpl(composerM4937constructorimpl15, Integer.valueOf(iHashCode15), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                    Updater.m4943reconcileimpl(composerM4937constructorimpl15, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                    Updater.m4945setimpl(composerM4937constructorimpl15, modifierMaterializeModifier15, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                    ColumnScopeInstance columnScopeInstance10 = ColumnScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1102396972, "C242@8693L270,249@8980L52,250@9049L261:SmartSubwayRealtime.kt#n9ob9m");
                    String str5 = "当前站  " + smartSubwayHorizontalCardContentBuildSmartSubwayHorizontalCardContent.getCurrentStation();
                    long jM5875getWhite0d7_KjU5 = Color.INSTANCE.m5875getWhite0d7_KjU();
                    if (z6) {
                        i8 = 19;
                    } else {
                        i8 = 18;
                    }
                    TextKt.m3661TextNvy7gAk(str5, null, jM5875getWhite0d7_KjU5, null, TextUnitKt.getSp(i8), null, FontWeight.INSTANCE.getBold(), null, 0L, null, null, 0L, 0, false, 1, 0, null, null, composerStartRestartGroup, 1573248, 24576, 245674);
                    Modifier.Companion companion15 = Modifier.INSTANCE;
                    if (z6) {
                        fM8748constructorimpl3 = Dp.m8748constructorimpl(2.0f);
                    } else {
                        fM8748constructorimpl3 = Dp.m8748constructorimpl(3.0f);
                    }
                    SpacerKt.Spacer(SizeKt.m1476height3ABfNKs(companion15, fM8748constructorimpl3), composerStartRestartGroup, 0);
                    TextKt.m3661TextNvy7gAk(smartSubwayHorizontalCardContentBuildSmartSubwayHorizontalCardContent.getLineSummary(), null, jColor, null, TextUnitKt.getSp(13), null, FontWeight.INSTANCE.getSemiBold(), null, 0L, null, null, 0L, 0, false, 1, 0, null, null, composerStartRestartGroup, 1572864, 24576, 245674);
                    composer3 = composerStartRestartGroup;
                    if (!StringsKt.isBlank(smartSubwayHorizontalCardContentBuildSmartSubwayHorizontalCardContent.getStatusText())) {
                        composer3.startReplaceGroup(1093740252);
                    } else {
                        composer3.startReplaceGroup(1103041802);
                        ComposerKt.sourceInformation(composer3, "258@9386L29,259@9436L280");
                        SpacerKt.Spacer(SizeKt.m1476height3ABfNKs(Modifier.INSTANCE, Dp.m8748constructorimpl(2.0f)), composer3, 6);
                        TextKt.m3661TextNvy7gAk(smartSubwayHorizontalCardContentBuildSmartSubwayHorizontalCardContent.getStatusText(), null, jColor, null, TextUnitKt.getSp(12), null, FontWeight.INSTANCE.getBold(), null, 0L, null, null, 0L, 0, false, 1, 0, null, null, composer3, 1572864, 24576, 245674);
                        composer3 = composer3;
                    }
                    composer3.endReplaceGroup();
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
                    Modifier.Companion companion16 = Modifier.INSTANCE;
                    if (z6) {
                        fM8748constructorimpl4 = Dp.m8748constructorimpl(7.0f);
                    } else {
                        fM8748constructorimpl4 = Dp.m8748constructorimpl(10.0f);
                    }
                    SpacerKt.Spacer(SizeKt.m1476height3ABfNKs(companion16, fM8748constructorimpl4), composer3, 0);
                    Composer composer8 = composer3;
                    SmartSubwayRouteCanvas(state, SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), z6, composer8, (i19 & 14) | 48 | i18, 0);
                    composer2 = composer8;
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    composer2.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z4 = z6;
                    function1 = function7;
                    modifier3 = modifier13;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.tickets.SmartSubwayRealtimeKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return SmartSubwayRealtimeKt.SmartSubwayHorizontalCard$lambda$12(state, modifier3, z4, function1, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 3072;
            if ((i3 & 1171) != 1170) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                function1 = function0;
                modifier3 = modifier2;
                z4 = z2;
            } else {
                if (i9 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i4 != 0) {
                    z5 = false;
                } else {
                    z5 = z2;
                }
                if (i6 != 0) {
                    function2 = null;
                } else {
                    function2 = function0;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-724058698, i3, -1, "com.example.tickets.SmartSubwayHorizontalCard (SmartSubwayRealtime.kt:218)");
                }
                smartSubwayHorizontalCardContentBuildSmartSubwayHorizontalCardContent = buildSmartSubwayHorizontalCardContent(state);
                if (isAfterTransfer(state)) {
                    primaryLineColor = state.getSecondaryLineColor();
                } else {
                    primaryLineColor = state.getPrimaryLineColor();
                }
                jColor = ColorKt.Color(primaryLineColor);
                Modifier modifierFillMaxWidth$default11 = SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null);
                if (z5) {
                    f = 20.0f;
                } else {
                    f = 24.0f;
                }
                modifierBackground$default = BackgroundKt.background$default(ClipKt.clip(modifierFillMaxWidth$default11, RoundedCornerShapeKt.m1756RoundedCornerShape0680j_4(Dp.m8748constructorimpl(f))), Brush.Companion.m5769verticalGradient8A3gB4$default(Brush.INSTANCE, CollectionsKt.listOf((Object[]) new Color[]{Color.m5828boximpl(Color.m5837copywmQWz5c$default(Color.INSTANCE.m5875getWhite0d7_KjU(), 0.095f, 0.0f, 0.0f, 0.0f, 14, null)), Color.m5828boximpl(Color.m5837copywmQWz5c$default(Color.INSTANCE.m5875getWhite0d7_KjU(), 0.042f, 0.0f, 0.0f, 0.0f, 14, null))}), 0.0f, 0.0f, 0, 14, (Object) null), null, 0.0f, 6, null);
                if (function2 != null) {
                    modifierBackground$default = ClickableKt.m683clickableoSLSa3U$default(modifierBackground$default, false, null, null, null, function2, 15, null);
                }
                Function0<Unit> function8 = function2;
                Modifier modifier14 = modifierBackground$default;
                if (z5) {
                    f2 = 14.0f;
                } else {
                    f2 = 18.0f;
                }
                float fM8748constructorimpl10 = Dp.m8748constructorimpl(f2);
                if (z5) {
                    fM8748constructorimpl = Dp.m8748constructorimpl(12.0f);
                } else {
                    fM8748constructorimpl = Dp.m8748constructorimpl(16.0f);
                }
                Modifier modifierM1424paddingVpY3zN9 = PaddingKt.m1424paddingVpY3zN4(modifier14, fM8748constructorimpl10, fM8748constructorimpl);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                MeasurePolicy measurePolicyColumnMeasurePolicy11 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
                int iHashCode16 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap16 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier16 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1424paddingVpY3zN9);
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
                Composer composerM4937constructorimpl16 = Updater.m4937constructorimpl(composerStartRestartGroup);
                Updater.m4945setimpl(composerM4937constructorimpl16, measurePolicyColumnMeasurePolicy11, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m4945setimpl(composerM4937constructorimpl16, currentCompositionLocalMap16, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Updater.m4945setimpl(composerM4937constructorimpl16, Integer.valueOf(iHashCode16), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                Updater.m4943reconcileimpl(composerM4937constructorimpl16, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                Updater.m4945setimpl(composerM4937constructorimpl16, modifierMaterializeModifier16, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                ColumnScopeInstance columnScopeInstance11 = ColumnScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -629168580, "C234@8282L1476,269@9767L53,270@9829L92:SmartSubwayRealtime.kt#n9ob9m");
                Modifier modifierFillMaxWidth$default12 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                Alignment.Vertical centerVertically6 = Alignment.INSTANCE.getCenterVertically();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                MeasurePolicy measurePolicyRowMeasurePolicy6 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically6, composerStartRestartGroup, 48);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
                int iHashCode17 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap17 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier17 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxWidth$default12);
                constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                Modifier modifier15 = companion;
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
                Composer composerM4937constructorimpl17 = Updater.m4937constructorimpl(composerStartRestartGroup);
                Updater.m4945setimpl(composerM4937constructorimpl17, measurePolicyRowMeasurePolicy6, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m4945setimpl(composerM4937constructorimpl17, currentCompositionLocalMap17, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Updater.m4945setimpl(composerM4937constructorimpl17, Integer.valueOf(iHashCode17), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                Updater.m4943reconcileimpl(composerM4937constructorimpl17, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                Updater.m4945setimpl(composerM4937constructorimpl17, modifierMaterializeModifier17, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                RowScopeInstance rowScopeInstance6 = RowScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1173178579, "C235@8384L173,240@8570L53,241@8636L1112:SmartSubwayRealtime.kt#n9ob9m");
                lineName = state.getLineName();
                if (StringsKt.isBlank(lineName)) {
                    lineName = "地铁";
                }
                int i110 = i3 & 896;
                m9305SmartSubwayServiceBadgeiJQMabo(lineName, jColor, z5, composerStartRestartGroup, i110);
                int i111 = i3;
                z6 = z5;
                Modifier.Companion companion17 = Modifier.INSTANCE;
                if (z6) {
                    fM8748constructorimpl2 = Dp.m8748constructorimpl(10.0f);
                } else {
                    fM8748constructorimpl2 = Dp.m8748constructorimpl(12.0f);
                }
                SpacerKt.Spacer(SizeKt.m1495width3ABfNKs(companion17, fM8748constructorimpl2), composerStartRestartGroup, 0);
                Modifier modifierWeight$default6 = RowScope.weight$default(rowScopeInstance6, Modifier.INSTANCE, 1.0f, false, 2, null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                MeasurePolicy measurePolicyColumnMeasurePolicy12 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
                int iHashCode18 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap18 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier18 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierWeight$default6);
                constructor3 = ComposeUiNode.INSTANCE.getConstructor();
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
                Composer composerM4937constructorimpl18 = Updater.m4937constructorimpl(composerStartRestartGroup);
                Updater.m4945setimpl(composerM4937constructorimpl18, measurePolicyColumnMeasurePolicy12, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m4945setimpl(composerM4937constructorimpl18, currentCompositionLocalMap18, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Updater.m4945setimpl(composerM4937constructorimpl18, Integer.valueOf(iHashCode18), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                Updater.m4943reconcileimpl(composerM4937constructorimpl18, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                Updater.m4945setimpl(composerM4937constructorimpl18, modifierMaterializeModifier18, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                ColumnScopeInstance columnScopeInstance12 = ColumnScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1102396972, "C242@8693L270,249@8980L52,250@9049L261:SmartSubwayRealtime.kt#n9ob9m");
                String str6 = "当前站  " + smartSubwayHorizontalCardContentBuildSmartSubwayHorizontalCardContent.getCurrentStation();
                long jM5875getWhite0d7_KjU6 = Color.INSTANCE.m5875getWhite0d7_KjU();
                if (z6) {
                    i8 = 19;
                } else {
                    i8 = 18;
                }
                TextKt.m3661TextNvy7gAk(str6, null, jM5875getWhite0d7_KjU6, null, TextUnitKt.getSp(i8), null, FontWeight.INSTANCE.getBold(), null, 0L, null, null, 0L, 0, false, 1, 0, null, null, composerStartRestartGroup, 1573248, 24576, 245674);
                Modifier.Companion companion18 = Modifier.INSTANCE;
                if (z6) {
                    fM8748constructorimpl3 = Dp.m8748constructorimpl(2.0f);
                } else {
                    fM8748constructorimpl3 = Dp.m8748constructorimpl(3.0f);
                }
                SpacerKt.Spacer(SizeKt.m1476height3ABfNKs(companion18, fM8748constructorimpl3), composerStartRestartGroup, 0);
                TextKt.m3661TextNvy7gAk(smartSubwayHorizontalCardContentBuildSmartSubwayHorizontalCardContent.getLineSummary(), null, jColor, null, TextUnitKt.getSp(13), null, FontWeight.INSTANCE.getSemiBold(), null, 0L, null, null, 0L, 0, false, 1, 0, null, null, composerStartRestartGroup, 1572864, 24576, 245674);
                composer3 = composerStartRestartGroup;
                if (!StringsKt.isBlank(smartSubwayHorizontalCardContentBuildSmartSubwayHorizontalCardContent.getStatusText())) {
                    composer3.startReplaceGroup(1093740252);
                } else {
                    composer3.startReplaceGroup(1103041802);
                    ComposerKt.sourceInformation(composer3, "258@9386L29,259@9436L280");
                    SpacerKt.Spacer(SizeKt.m1476height3ABfNKs(Modifier.INSTANCE, Dp.m8748constructorimpl(2.0f)), composer3, 6);
                    TextKt.m3661TextNvy7gAk(smartSubwayHorizontalCardContentBuildSmartSubwayHorizontalCardContent.getStatusText(), null, jColor, null, TextUnitKt.getSp(12), null, FontWeight.INSTANCE.getBold(), null, 0L, null, null, 0L, 0, false, 1, 0, null, null, composer3, 1572864, 24576, 245674);
                    composer3 = composer3;
                }
                composer3.endReplaceGroup();
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
                Modifier.Companion companion19 = Modifier.INSTANCE;
                if (z6) {
                    fM8748constructorimpl4 = Dp.m8748constructorimpl(7.0f);
                } else {
                    fM8748constructorimpl4 = Dp.m8748constructorimpl(10.0f);
                }
                SpacerKt.Spacer(SizeKt.m1476height3ABfNKs(companion19, fM8748constructorimpl4), composer3, 0);
                Composer composer9 = composer3;
                SmartSubwayRouteCanvas(state, SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), z6, composer9, (i111 & 14) | 48 | i110, 0);
                composer2 = composer9;
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z4 = z6;
                function1 = function8;
                modifier3 = modifier15;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.tickets.SmartSubwayRealtimeKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return SmartSubwayRealtimeKt.SmartSubwayHorizontalCard$lambda$12(state, modifier3, z4, function1, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 384;
        z2 = z;
        i6 = i2 & 8;
        if (i6 != 0) {
            if ((i & 3072) == 0) {
                if (composerStartRestartGroup.changedInstance(function0)) {
                    i7 = 2048;
                } else {
                    i7 = 1024;
                }
                i3 |= i7;
            }
            if ((i3 & 1171) != 1170) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                function1 = function0;
                modifier3 = modifier2;
                z4 = z2;
            } else {
                if (i9 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i4 != 0) {
                    z5 = false;
                } else {
                    z5 = z2;
                }
                if (i6 != 0) {
                    function2 = null;
                } else {
                    function2 = function0;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-724058698, i3, -1, "com.example.tickets.SmartSubwayHorizontalCard (SmartSubwayRealtime.kt:218)");
                }
                smartSubwayHorizontalCardContentBuildSmartSubwayHorizontalCardContent = buildSmartSubwayHorizontalCardContent(state);
                if (isAfterTransfer(state)) {
                    primaryLineColor = state.getSecondaryLineColor();
                } else {
                    primaryLineColor = state.getPrimaryLineColor();
                }
                jColor = ColorKt.Color(primaryLineColor);
                Modifier modifierFillMaxWidth$default13 = SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null);
                if (z5) {
                    f = 20.0f;
                } else {
                    f = 24.0f;
                }
                modifierBackground$default = BackgroundKt.background$default(ClipKt.clip(modifierFillMaxWidth$default13, RoundedCornerShapeKt.m1756RoundedCornerShape0680j_4(Dp.m8748constructorimpl(f))), Brush.Companion.m5769verticalGradient8A3gB4$default(Brush.INSTANCE, CollectionsKt.listOf((Object[]) new Color[]{Color.m5828boximpl(Color.m5837copywmQWz5c$default(Color.INSTANCE.m5875getWhite0d7_KjU(), 0.095f, 0.0f, 0.0f, 0.0f, 14, null)), Color.m5828boximpl(Color.m5837copywmQWz5c$default(Color.INSTANCE.m5875getWhite0d7_KjU(), 0.042f, 0.0f, 0.0f, 0.0f, 14, null))}), 0.0f, 0.0f, 0, 14, (Object) null), null, 0.0f, 6, null);
                if (function2 != null) {
                    modifierBackground$default = ClickableKt.m683clickableoSLSa3U$default(modifierBackground$default, false, null, null, null, function2, 15, null);
                }
                Function0<Unit> function9 = function2;
                Modifier modifier16 = modifierBackground$default;
                if (z5) {
                    f2 = 14.0f;
                } else {
                    f2 = 18.0f;
                }
                float fM8748constructorimpl11 = Dp.m8748constructorimpl(f2);
                if (z5) {
                    fM8748constructorimpl = Dp.m8748constructorimpl(12.0f);
                } else {
                    fM8748constructorimpl = Dp.m8748constructorimpl(16.0f);
                }
                Modifier modifierM1424paddingVpY3zN10 = PaddingKt.m1424paddingVpY3zN4(modifier16, fM8748constructorimpl11, fM8748constructorimpl);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                MeasurePolicy measurePolicyColumnMeasurePolicy13 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
                int iHashCode19 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap19 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier19 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1424paddingVpY3zN10);
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
                Updater.m4945setimpl(composerM4937constructorimpl19, measurePolicyColumnMeasurePolicy13, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m4945setimpl(composerM4937constructorimpl19, currentCompositionLocalMap19, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Updater.m4945setimpl(composerM4937constructorimpl19, Integer.valueOf(iHashCode19), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                Updater.m4943reconcileimpl(composerM4937constructorimpl19, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                Updater.m4945setimpl(composerM4937constructorimpl19, modifierMaterializeModifier19, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                ColumnScopeInstance columnScopeInstance13 = ColumnScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -629168580, "C234@8282L1476,269@9767L53,270@9829L92:SmartSubwayRealtime.kt#n9ob9m");
                Modifier modifierFillMaxWidth$default14 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                Alignment.Vertical centerVertically7 = Alignment.INSTANCE.getCenterVertically();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                MeasurePolicy measurePolicyRowMeasurePolicy7 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically7, composerStartRestartGroup, 48);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
                int iHashCode110 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap110 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier110 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxWidth$default14);
                constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                Modifier modifier17 = companion;
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
                Composer composerM4937constructorimpl110 = Updater.m4937constructorimpl(composerStartRestartGroup);
                Updater.m4945setimpl(composerM4937constructorimpl110, measurePolicyRowMeasurePolicy7, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m4945setimpl(composerM4937constructorimpl110, currentCompositionLocalMap110, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Updater.m4945setimpl(composerM4937constructorimpl110, Integer.valueOf(iHashCode110), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                Updater.m4943reconcileimpl(composerM4937constructorimpl110, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                Updater.m4945setimpl(composerM4937constructorimpl110, modifierMaterializeModifier110, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                RowScopeInstance rowScopeInstance7 = RowScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1173178579, "C235@8384L173,240@8570L53,241@8636L1112:SmartSubwayRealtime.kt#n9ob9m");
                lineName = state.getLineName();
                if (StringsKt.isBlank(lineName)) {
                    lineName = "地铁";
                }
                int i112 = i3 & 896;
                m9305SmartSubwayServiceBadgeiJQMabo(lineName, jColor, z5, composerStartRestartGroup, i112);
                int i113 = i3;
                z6 = z5;
                Modifier.Companion companion110 = Modifier.INSTANCE;
                if (z6) {
                    fM8748constructorimpl2 = Dp.m8748constructorimpl(10.0f);
                } else {
                    fM8748constructorimpl2 = Dp.m8748constructorimpl(12.0f);
                }
                SpacerKt.Spacer(SizeKt.m1495width3ABfNKs(companion110, fM8748constructorimpl2), composerStartRestartGroup, 0);
                Modifier modifierWeight$default7 = RowScope.weight$default(rowScopeInstance7, Modifier.INSTANCE, 1.0f, false, 2, null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                MeasurePolicy measurePolicyColumnMeasurePolicy14 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
                int iHashCode111 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap111 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier111 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierWeight$default7);
                constructor3 = ComposeUiNode.INSTANCE.getConstructor();
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
                Composer composerM4937constructorimpl111 = Updater.m4937constructorimpl(composerStartRestartGroup);
                Updater.m4945setimpl(composerM4937constructorimpl111, measurePolicyColumnMeasurePolicy14, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m4945setimpl(composerM4937constructorimpl111, currentCompositionLocalMap111, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Updater.m4945setimpl(composerM4937constructorimpl111, Integer.valueOf(iHashCode111), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                Updater.m4943reconcileimpl(composerM4937constructorimpl111, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                Updater.m4945setimpl(composerM4937constructorimpl111, modifierMaterializeModifier111, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                ColumnScopeInstance columnScopeInstance14 = ColumnScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1102396972, "C242@8693L270,249@8980L52,250@9049L261:SmartSubwayRealtime.kt#n9ob9m");
                String str7 = "当前站  " + smartSubwayHorizontalCardContentBuildSmartSubwayHorizontalCardContent.getCurrentStation();
                long jM5875getWhite0d7_KjU7 = Color.INSTANCE.m5875getWhite0d7_KjU();
                if (z6) {
                    i8 = 19;
                } else {
                    i8 = 18;
                }
                TextKt.m3661TextNvy7gAk(str7, null, jM5875getWhite0d7_KjU7, null, TextUnitKt.getSp(i8), null, FontWeight.INSTANCE.getBold(), null, 0L, null, null, 0L, 0, false, 1, 0, null, null, composerStartRestartGroup, 1573248, 24576, 245674);
                Modifier.Companion companion111 = Modifier.INSTANCE;
                if (z6) {
                    fM8748constructorimpl3 = Dp.m8748constructorimpl(2.0f);
                } else {
                    fM8748constructorimpl3 = Dp.m8748constructorimpl(3.0f);
                }
                SpacerKt.Spacer(SizeKt.m1476height3ABfNKs(companion111, fM8748constructorimpl3), composerStartRestartGroup, 0);
                TextKt.m3661TextNvy7gAk(smartSubwayHorizontalCardContentBuildSmartSubwayHorizontalCardContent.getLineSummary(), null, jColor, null, TextUnitKt.getSp(13), null, FontWeight.INSTANCE.getSemiBold(), null, 0L, null, null, 0L, 0, false, 1, 0, null, null, composerStartRestartGroup, 1572864, 24576, 245674);
                composer3 = composerStartRestartGroup;
                if (!StringsKt.isBlank(smartSubwayHorizontalCardContentBuildSmartSubwayHorizontalCardContent.getStatusText())) {
                    composer3.startReplaceGroup(1093740252);
                } else {
                    composer3.startReplaceGroup(1103041802);
                    ComposerKt.sourceInformation(composer3, "258@9386L29,259@9436L280");
                    SpacerKt.Spacer(SizeKt.m1476height3ABfNKs(Modifier.INSTANCE, Dp.m8748constructorimpl(2.0f)), composer3, 6);
                    TextKt.m3661TextNvy7gAk(smartSubwayHorizontalCardContentBuildSmartSubwayHorizontalCardContent.getStatusText(), null, jColor, null, TextUnitKt.getSp(12), null, FontWeight.INSTANCE.getBold(), null, 0L, null, null, 0L, 0, false, 1, 0, null, null, composer3, 1572864, 24576, 245674);
                    composer3 = composer3;
                }
                composer3.endReplaceGroup();
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
                Modifier.Companion companion112 = Modifier.INSTANCE;
                if (z6) {
                    fM8748constructorimpl4 = Dp.m8748constructorimpl(7.0f);
                } else {
                    fM8748constructorimpl4 = Dp.m8748constructorimpl(10.0f);
                }
                SpacerKt.Spacer(SizeKt.m1476height3ABfNKs(companion112, fM8748constructorimpl4), composer3, 0);
                Composer composer10 = composer3;
                SmartSubwayRouteCanvas(state, SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), z6, composer10, (i113 & 14) | 48 | i112, 0);
                composer2 = composer10;
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z4 = z6;
                function1 = function9;
                modifier3 = modifier17;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.tickets.SmartSubwayRealtimeKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return SmartSubwayRealtimeKt.SmartSubwayHorizontalCard$lambda$12(state, modifier3, z4, function1, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 3072;
        if ((i3 & 1171) != 1170) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            function1 = function0;
            modifier3 = modifier2;
            z4 = z2;
        } else {
            if (i9 != 0) {
                companion = Modifier.INSTANCE;
            } else {
                companion = modifier2;
            }
            if (i4 != 0) {
                z5 = false;
            } else {
                z5 = z2;
            }
            if (i6 != 0) {
                function2 = null;
            } else {
                function2 = function0;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-724058698, i3, -1, "com.example.tickets.SmartSubwayHorizontalCard (SmartSubwayRealtime.kt:218)");
            }
            smartSubwayHorizontalCardContentBuildSmartSubwayHorizontalCardContent = buildSmartSubwayHorizontalCardContent(state);
            if (isAfterTransfer(state)) {
                primaryLineColor = state.getSecondaryLineColor();
            } else {
                primaryLineColor = state.getPrimaryLineColor();
            }
            jColor = ColorKt.Color(primaryLineColor);
            Modifier modifierFillMaxWidth$default15 = SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null);
            if (z5) {
                f = 20.0f;
            } else {
                f = 24.0f;
            }
            modifierBackground$default = BackgroundKt.background$default(ClipKt.clip(modifierFillMaxWidth$default15, RoundedCornerShapeKt.m1756RoundedCornerShape0680j_4(Dp.m8748constructorimpl(f))), Brush.Companion.m5769verticalGradient8A3gB4$default(Brush.INSTANCE, CollectionsKt.listOf((Object[]) new Color[]{Color.m5828boximpl(Color.m5837copywmQWz5c$default(Color.INSTANCE.m5875getWhite0d7_KjU(), 0.095f, 0.0f, 0.0f, 0.0f, 14, null)), Color.m5828boximpl(Color.m5837copywmQWz5c$default(Color.INSTANCE.m5875getWhite0d7_KjU(), 0.042f, 0.0f, 0.0f, 0.0f, 14, null))}), 0.0f, 0.0f, 0, 14, (Object) null), null, 0.0f, 6, null);
            if (function2 != null) {
                modifierBackground$default = ClickableKt.m683clickableoSLSa3U$default(modifierBackground$default, false, null, null, null, function2, 15, null);
            }
            Function0<Unit> function10 = function2;
            Modifier modifier18 = modifierBackground$default;
            if (z5) {
                f2 = 14.0f;
            } else {
                f2 = 18.0f;
            }
            float fM8748constructorimpl12 = Dp.m8748constructorimpl(f2);
            if (z5) {
                fM8748constructorimpl = Dp.m8748constructorimpl(12.0f);
            } else {
                fM8748constructorimpl = Dp.m8748constructorimpl(16.0f);
            }
            Modifier modifierM1424paddingVpY3zN11 = PaddingKt.m1424paddingVpY3zN4(modifier18, fM8748constructorimpl12, fM8748constructorimpl);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy15 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
            int iHashCode112 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap112 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier112 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1424paddingVpY3zN11);
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
            Composer composerM4937constructorimpl112 = Updater.m4937constructorimpl(composerStartRestartGroup);
            Updater.m4945setimpl(composerM4937constructorimpl112, measurePolicyColumnMeasurePolicy15, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m4945setimpl(composerM4937constructorimpl112, currentCompositionLocalMap112, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m4945setimpl(composerM4937constructorimpl112, Integer.valueOf(iHashCode112), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m4943reconcileimpl(composerM4937constructorimpl112, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m4945setimpl(composerM4937constructorimpl112, modifierMaterializeModifier112, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance15 = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -629168580, "C234@8282L1476,269@9767L53,270@9829L92:SmartSubwayRealtime.kt#n9ob9m");
            Modifier modifierFillMaxWidth$default16 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
            Alignment.Vertical centerVertically8 = Alignment.INSTANCE.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy8 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically8, composerStartRestartGroup, 48);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
            int iHashCode113 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap113 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier113 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxWidth$default16);
            constructor2 = ComposeUiNode.INSTANCE.getConstructor();
            Modifier modifier19 = companion;
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
            Composer composerM4937constructorimpl113 = Updater.m4937constructorimpl(composerStartRestartGroup);
            Updater.m4945setimpl(composerM4937constructorimpl113, measurePolicyRowMeasurePolicy8, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m4945setimpl(composerM4937constructorimpl113, currentCompositionLocalMap113, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m4945setimpl(composerM4937constructorimpl113, Integer.valueOf(iHashCode113), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m4943reconcileimpl(composerM4937constructorimpl113, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m4945setimpl(composerM4937constructorimpl113, modifierMaterializeModifier113, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance8 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1173178579, "C235@8384L173,240@8570L53,241@8636L1112:SmartSubwayRealtime.kt#n9ob9m");
            lineName = state.getLineName();
            if (StringsKt.isBlank(lineName)) {
                lineName = "地铁";
            }
            int i114 = i3 & 896;
            m9305SmartSubwayServiceBadgeiJQMabo(lineName, jColor, z5, composerStartRestartGroup, i114);
            int i115 = i3;
            z6 = z5;
            Modifier.Companion companion113 = Modifier.INSTANCE;
            if (z6) {
                fM8748constructorimpl2 = Dp.m8748constructorimpl(10.0f);
            } else {
                fM8748constructorimpl2 = Dp.m8748constructorimpl(12.0f);
            }
            SpacerKt.Spacer(SizeKt.m1495width3ABfNKs(companion113, fM8748constructorimpl2), composerStartRestartGroup, 0);
            Modifier modifierWeight$default8 = RowScope.weight$default(rowScopeInstance8, Modifier.INSTANCE, 1.0f, false, 2, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy16 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
            int iHashCode114 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap114 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier114 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierWeight$default8);
            constructor3 = ComposeUiNode.INSTANCE.getConstructor();
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
            Composer composerM4937constructorimpl114 = Updater.m4937constructorimpl(composerStartRestartGroup);
            Updater.m4945setimpl(composerM4937constructorimpl114, measurePolicyColumnMeasurePolicy16, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m4945setimpl(composerM4937constructorimpl114, currentCompositionLocalMap114, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m4945setimpl(composerM4937constructorimpl114, Integer.valueOf(iHashCode114), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m4943reconcileimpl(composerM4937constructorimpl114, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m4945setimpl(composerM4937constructorimpl114, modifierMaterializeModifier114, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance16 = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1102396972, "C242@8693L270,249@8980L52,250@9049L261:SmartSubwayRealtime.kt#n9ob9m");
            String str8 = "当前站  " + smartSubwayHorizontalCardContentBuildSmartSubwayHorizontalCardContent.getCurrentStation();
            long jM5875getWhite0d7_KjU8 = Color.INSTANCE.m5875getWhite0d7_KjU();
            if (z6) {
                i8 = 19;
            } else {
                i8 = 18;
            }
            TextKt.m3661TextNvy7gAk(str8, null, jM5875getWhite0d7_KjU8, null, TextUnitKt.getSp(i8), null, FontWeight.INSTANCE.getBold(), null, 0L, null, null, 0L, 0, false, 1, 0, null, null, composerStartRestartGroup, 1573248, 24576, 245674);
            Modifier.Companion companion114 = Modifier.INSTANCE;
            if (z6) {
                fM8748constructorimpl3 = Dp.m8748constructorimpl(2.0f);
            } else {
                fM8748constructorimpl3 = Dp.m8748constructorimpl(3.0f);
            }
            SpacerKt.Spacer(SizeKt.m1476height3ABfNKs(companion114, fM8748constructorimpl3), composerStartRestartGroup, 0);
            TextKt.m3661TextNvy7gAk(smartSubwayHorizontalCardContentBuildSmartSubwayHorizontalCardContent.getLineSummary(), null, jColor, null, TextUnitKt.getSp(13), null, FontWeight.INSTANCE.getSemiBold(), null, 0L, null, null, 0L, 0, false, 1, 0, null, null, composerStartRestartGroup, 1572864, 24576, 245674);
            composer3 = composerStartRestartGroup;
            if (!StringsKt.isBlank(smartSubwayHorizontalCardContentBuildSmartSubwayHorizontalCardContent.getStatusText())) {
                composer3.startReplaceGroup(1093740252);
            } else {
                composer3.startReplaceGroup(1103041802);
                ComposerKt.sourceInformation(composer3, "258@9386L29,259@9436L280");
                SpacerKt.Spacer(SizeKt.m1476height3ABfNKs(Modifier.INSTANCE, Dp.m8748constructorimpl(2.0f)), composer3, 6);
                TextKt.m3661TextNvy7gAk(smartSubwayHorizontalCardContentBuildSmartSubwayHorizontalCardContent.getStatusText(), null, jColor, null, TextUnitKt.getSp(12), null, FontWeight.INSTANCE.getBold(), null, 0L, null, null, 0L, 0, false, 1, 0, null, null, composer3, 1572864, 24576, 245674);
                composer3 = composer3;
            }
            composer3.endReplaceGroup();
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
            Modifier.Companion companion115 = Modifier.INSTANCE;
            if (z6) {
                fM8748constructorimpl4 = Dp.m8748constructorimpl(7.0f);
            } else {
                fM8748constructorimpl4 = Dp.m8748constructorimpl(10.0f);
            }
            SpacerKt.Spacer(SizeKt.m1476height3ABfNKs(companion115, fM8748constructorimpl4), composer3, 0);
            Composer composer11 = composer3;
            SmartSubwayRouteCanvas(state, SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), z6, composer11, (i115 & 14) | 48 | i114, 0);
            composer2 = composer11;
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            z4 = z6;
            function1 = function10;
            modifier3 = modifier19;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.tickets.SmartSubwayRealtimeKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SmartSubwayRealtimeKt.SmartSubwayHorizontalCard$lambda$12(state, modifier3, z4, function1, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: renamed from: SmartSubwayServiceBadge-iJQMabo, reason: not valid java name */
    private static final void m9305SmartSubwayServiceBadgeiJQMabo(final String str, final long j, final boolean z, Composer composer, final int i) {
        int i2;
        Composer composer2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-631432331);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(SmartSubwayServiceBadge)N(lineName,lineColor:c#ui.graphics.Color,compact)276@10039L870:SmartSubwayRealtime.kt#n9ob9m");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(str) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(j) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changed(z) ? 256 : 128;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 147) != 146, i2 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-631432331, i2, -1, "com.example.tickets.SmartSubwayServiceBadge (SmartSubwayRealtime.kt:275)");
            }
            Modifier modifierM1423padding3ABfNKs = PaddingKt.m1423padding3ABfNKs(BackgroundKt.m648backgroundbw27NRU$default(ClipKt.clip(SizeKt.m1490size3ABfNKs(Modifier.INSTANCE, Dp.m8748constructorimpl(z ? 42.0f : 52.0f)), RoundedCornerShapeKt.m1756RoundedCornerShape0680j_4(Dp.m8748constructorimpl(z ? 13.0f : 15.0f))), Color.INSTANCE.m5875getWhite0d7_KjU(), null, 2, null), Dp.m8748constructorimpl(z ? 4.0f : 5.0f));
            Alignment center = Alignment.INSTANCE.getCenter();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
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
            Updater.m4945setimpl(composerM4937constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m4945setimpl(composerM4937constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m4945setimpl(composerM4937constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m4943reconcileimpl(composerM4937constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m4945setimpl(composerM4937constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1364723923, "C284@10338L565:SmartSubwayRealtime.kt#n9ob9m");
            Modifier modifierM648backgroundbw27NRU$default = BackgroundKt.m648backgroundbw27NRU$default(ClipKt.clip(SizeKt.fillMaxHeight$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), 0.0f, 1, null), RoundedCornerShapeKt.m1756RoundedCornerShape0680j_4(Dp.m8748constructorimpl(z ? 10.0f : 11.0f))), j, null, 2, null);
            Alignment center2 = Alignment.INSTANCE.getCenter();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(center2, false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
            int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM648backgroundbw27NRU$default);
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
            Updater.m4945setimpl(composerM4937constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m4945setimpl(composerM4937constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m4945setimpl(composerM4937constructorimpl2, Integer.valueOf(iHashCode2), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m4943reconcileimpl(composerM4937constructorimpl2, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m4945setimpl(composerM4937constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833846806, "C292@10625L268:SmartSubwayRealtime.kt#n9ob9m");
            composer2 = composerStartRestartGroup;
            TextKt.m3661TextNvy7gAk(str, null, Color.INSTANCE.m5875getWhite0d7_KjU(), null, TextUnitKt.getSp(15), null, FontWeight.INSTANCE.getBold(), null, 0L, null, TextAlign.m8619boximpl(TextAlign.INSTANCE.m8626getCentere0LSkKk()), 0L, 0, false, 1, 0, null, null, composer2, (i2 & 14) | 1573248, 24576, 244650);
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.tickets.SmartSubwayRealtimeKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SmartSubwayRealtimeKt.SmartSubwayServiceBadge_iJQMabo$lambda$15(str, j, z, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX WARN: Code duplicated, block: B:100:0x05d2  */
    /* JADX WARN: Code duplicated, block: B:103:0x05de  */
    /* JADX WARN: Code duplicated, block: B:104:0x05e7  */
    /* JADX WARN: Code duplicated, block: B:107:0x0603  */
    /* JADX WARN: Code duplicated, block: B:108:0x066c  */
    /* JADX WARN: Code duplicated, block: B:111:0x06eb  */
    /* JADX WARN: Code duplicated, block: B:114:0x06f7  */
    /* JADX WARN: Code duplicated, block: B:115:0x06fb  */
    /* JADX WARN: Code duplicated, block: B:118:0x0750  */
    /* JADX WARN: Code duplicated, block: B:119:0x0757  */
    /* JADX WARN: Code duplicated, block: B:122:0x0766  */
    /* JADX WARN: Code duplicated, block: B:123:0x0769  */
    /* JADX WARN: Code duplicated, block: B:126:0x0775  */
    /* JADX WARN: Code duplicated, block: B:127:0x077c  */
    /* JADX WARN: Code duplicated, block: B:130:0x0830  */
    /* JADX WARN: Code duplicated, block: B:133:0x083c  */
    /* JADX WARN: Code duplicated, block: B:134:0x0840  */
    /* JADX WARN: Code duplicated, block: B:137:0x0896  */
    /* JADX WARN: Code duplicated, block: B:138:0x089f  */
    /* JADX WARN: Code duplicated, block: B:141:0x08b4  */
    /* JADX WARN: Code duplicated, block: B:142:0x08bb  */
    /* JADX WARN: Code duplicated, block: B:145:0x08ff  */
    /* JADX WARN: Code duplicated, block: B:147:0x0991  */
    /* JADX WARN: Code duplicated, block: B:150:0x099d  */
    /* JADX WARN: Code duplicated, block: B:151:0x09a1  */
    /* JADX WARN: Code duplicated, block: B:153:0x0a48  */
    /* JADX WARN: Code duplicated, block: B:156:0x0a95  */
    /* JADX WARN: Code duplicated, block: B:157:0x0ab2  */
    /* JADX WARN: Code duplicated, block: B:161:0x0af2  */
    /* JADX WARN: Code duplicated, block: B:163:0x0af8  */
    /* JADX WARN: Code duplicated, block: B:166:0x0b01  */
    /* JADX WARN: Code duplicated, block: B:171:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:172:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:23:0x004d  */
    /* JADX WARN: Code duplicated, block: B:24:0x004f  */
    /* JADX WARN: Code duplicated, block: B:27:0x0058 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:28:0x005a  */
    /* JADX WARN: Code duplicated, block: B:29:0x005f  */
    /* JADX WARN: Code duplicated, block: B:32:0x0066  */
    /* JADX WARN: Code duplicated, block: B:35:0x0072  */
    /* JADX WARN: Code duplicated, block: B:37:0x0078  */
    /* JADX WARN: Code duplicated, block: B:40:0x0081  */
    /* JADX WARN: Code duplicated, block: B:42:0x008a  */
    /* JADX WARN: Code duplicated, block: B:44:0x00d8  */
    /* JADX WARN: Code duplicated, block: B:47:0x00e4  */
    /* JADX WARN: Code duplicated, block: B:48:0x00e8  */
    /* JADX WARN: Code duplicated, block: B:52:0x014d  */
    /* JADX WARN: Code duplicated, block: B:54:0x0155  */
    /* JADX WARN: Code duplicated, block: B:74:0x040e  */
    /* JADX WARN: Code duplicated, block: B:77:0x047d  */
    /* JADX WARN: Code duplicated, block: B:80:0x0489  */
    /* JADX WARN: Code duplicated, block: B:81:0x048d  */
    /* JADX WARN: Code duplicated, block: B:84:0x0525  */
    /* JADX WARN: Code duplicated, block: B:87:0x0531  */
    /* JADX WARN: Code duplicated, block: B:88:0x0535  */
    /* JADX WARN: Code duplicated, block: B:91:0x058b  */
    /* JADX WARN: Code duplicated, block: B:92:0x058e  */
    /* JADX WARN: Code duplicated, block: B:95:0x05a8  */
    /* JADX WARN: Code duplicated, block: B:96:0x05af  */
    /* JADX WARN: Code duplicated, block: B:99:0x05c9  */
    public static final void SmartSubwayGoogleRouteTimeline(final List<SmartSubwayTimelineStop> stops, Modifier modifier, Composer composer, final int i, final int i2) {
        final Modifier modifier2;
        int i3;
        boolean z;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        final Modifier.Companion companion;
        float f;
        Object obj;
        String str;
        String str2;
        Function0<ComposeUiNode> constructor;
        String str3;
        String str4;
        int i4;
        SmartSubwayTimelineStop smartSubwayTimelineStop;
        String str5;
        int i5;
        Modifier modifier3;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        int i6;
        String str11;
        Function0<ComposeUiNode> constructor2;
        String str12;
        Function0<ComposeUiNode> constructor3;
        float f2;
        long jColor;
        float f3;
        float fM8748constructorimpl;
        long jM5873getTransparent0d7_KjU;
        int i7;
        Function0<ComposeUiNode> constructor4;
        Composer composer2;
        long jColor2;
        int i8;
        FontWeight normal;
        int i9;
        Function0<ComposeUiNode> constructor5;
        long jColor3;
        FontWeight normal2;
        Function0<ComposeUiNode> constructor6;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup2;
        Intrinsics.checkNotNullParameter(stops, "stops");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1441224283);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(SmartSubwayGoogleRouteTimeline)N(stops,modifier)317@11318L3754:SmartSubwayRealtime.kt#n9ob9m");
        int i10 = (i & 6) == 0 ? (composerStartRestartGroup.changedInstance(stops) ? 4 : 2) | i : i;
        int i11 = i2 & 2;
        if (i11 == 0) {
            if ((i & 48) == 0) {
                modifier2 = modifier;
                i10 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            i3 = 1;
            if ((i10 & 19) != 18) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i10 & 1)) {
                if (i11 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1441224283, i10, -1, "com.example.tickets.SmartSubwayGoogleRouteTimeline (SmartSubwayRealtime.kt:315)");
                }
                if (stops.isEmpty()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    scopeUpdateScopeEndRestartGroup2 = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup2 != null) {
                        scopeUpdateScopeEndRestartGroup2.updateScope(new Function2() { // from class: com.example.tickets.SmartSubwayRealtimeKt$$ExternalSyntheticLambda9
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj2, Object obj3) {
                                return SmartSubwayRealtimeKt.SmartSubwayGoogleRouteTimeline$lambda$16(stops, companion, i, i2, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        });
                        return;
                    }
                    return;
                }
                f = 0.0f;
                obj = null;
                Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null);
                str = "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo";
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
                str2 = "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh";
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
                int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxWidth$default);
                constructor = ComposeUiNode.INSTANCE.getConstructor();
                str3 = "CC(ReusableComposeNode)N(factory,update,content)410@16216L9:Composables.kt#9igjgp";
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
                str4 = "C89@4557L9:Column.kt#2w3rfo";
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 474760505, "C:SmartSubwayRealtime.kt#n9ob9m");
                composerStartRestartGroup.startReplaceGroup(-954516284);
                ComposerKt.sourceInformation(composerStartRestartGroup, "*338@12418L2567");
                i4 = 0;
                for (Object obj2 : stops) {
                    int i12 = i4 + 1;
                    if (i4 < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    smartSubwayTimelineStop = (SmartSubwayTimelineStop) obj2;
                    str5 = str4;
                    i5 = i4;
                    if (i5 > 0 || StringsKt.isBlank(smartSubwayTimelineStop.getTransferToLine())) {
                        modifier3 = companion;
                        str6 = "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo";
                        str7 = str3;
                        str8 = str2;
                        str9 = "C101@5233L9:Row.kt#2w3rfo";
                        str10 = str5;
                        i6 = i5;
                        composerStartRestartGroup.startReplaceGroup(-1208162597);
                    } else {
                        composerStartRestartGroup.startReplaceGroup(-1196752458);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "320@11490L901");
                        Modifier modifierFillMaxWidth$default2 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, f, i3, obj);
                        Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                        MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, composerStartRestartGroup, 48);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, str2);
                        int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                        CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxWidth$default2);
                        Function0<ComposeUiNode> constructor7 = ComposeUiNode.INSTANCE.getConstructor();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, str3);
                        if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composerStartRestartGroup.startReusableNode();
                        if (composerStartRestartGroup.getInserting()) {
                            composerStartRestartGroup.createNode(constructor7);
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
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1481879062, "C321@11600L28,322@11649L161,325@11831L29,326@11881L492:SmartSubwayRealtime.kt#n9ob9m");
                        SpacerKt.Spacer(SizeKt.m1495width3ABfNKs(Modifier.INSTANCE, Dp.m8748constructorimpl(8.0f)), composerStartRestartGroup, 6);
                        BoxKt.Box(BackgroundKt.m648backgroundbw27NRU$default(ClipKt.clip(SizeKt.m1476height3ABfNKs(SizeKt.m1495width3ABfNKs(Modifier.INSTANCE, Dp.m8748constructorimpl(6.0f)), Dp.m8748constructorimpl(30.0f)), RoundedCornerShapeKt.m1756RoundedCornerShape0680j_4(Dp.m8748constructorimpl(3.0f))), ColorKt.Color(smartSubwayTimelineStop.getLineColor()), null, 2, null), composerStartRestartGroup, 0);
                        SpacerKt.Spacer(SizeKt.m1495width3ABfNKs(Modifier.INSTANCE, Dp.m8748constructorimpl(14.0f)), composerStartRestartGroup, 6);
                        Modifier modifierM1424paddingVpY3zN4 = PaddingKt.m1424paddingVpY3zN4(BackgroundKt.m648backgroundbw27NRU$default(ClipKt.clip(Modifier.INSTANCE, RoundedCornerShapeKt.m1756RoundedCornerShape0680j_4(Dp.m8748constructorimpl(11.0f))), Color.m5837copywmQWz5c$default(Color.INSTANCE.m5875getWhite0d7_KjU(), 0.075f, 0.0f, 0.0f, 0.0f, 14, null), null, 2, null), Dp.m8748constructorimpl(10.0f), Dp.m8748constructorimpl(6.0f));
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, str2);
                        int iHashCode3 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                        CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1424paddingVpY3zN4);
                        Function0<ComposeUiNode> constructor8 = ComposeUiNode.INSTANCE.getConstructor();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, str3);
                        if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composerStartRestartGroup.startReusableNode();
                        if (composerStartRestartGroup.getInserting()) {
                            composerStartRestartGroup.createNode(constructor8);
                        } else {
                            composerStartRestartGroup.useNode();
                        }
                        Composer composerM4937constructorimpl3 = Updater.m4937constructorimpl(composerStartRestartGroup);
                        Updater.m4945setimpl(composerM4937constructorimpl3, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m4945setimpl(composerM4937constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Updater.m4945setimpl(composerM4937constructorimpl3, Integer.valueOf(iHashCode3), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                        Updater.m4943reconcileimpl(composerM4937constructorimpl3, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                        Updater.m4945setimpl(composerM4937constructorimpl3, modifierMaterializeModifier3, ComposeUiNode.INSTANCE.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1147257437, "C329@12100L251:SmartSubwayRealtime.kt#n9ob9m");
                        Composer composer3 = composerStartRestartGroup;
                        modifier3 = companion;
                        str6 = "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo";
                        str7 = str3;
                        str9 = "C101@5233L9:Row.kt#2w3rfo";
                        str8 = str2;
                        str10 = str5;
                        i6 = i5;
                        TextKt.m3661TextNvy7gAk("换乘 " + smartSubwayTimelineStop.getTransferToLine(), null, Color.INSTANCE.m5875getWhite0d7_KjU(), null, TextUnitKt.getSp(12), null, FontWeight.INSTANCE.getSemiBold(), null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer3, 1597824, 0, 262058);
                        composerStartRestartGroup = composer3;
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
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    Modifier modifierFillMaxWidth$default3 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                    Alignment.Vertical centerVertically2 = Alignment.INSTANCE.getCenterVertically();
                    String str13 = str6;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, str13);
                    MeasurePolicy measurePolicyRowMeasurePolicy2 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically2, composerStartRestartGroup, 48);
                    str11 = str8;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, str11);
                    int iHashCode4 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap4 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxWidth$default3);
                    constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                    str12 = str7;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, str12);
                    if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(constructor2);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    Composer composerM4937constructorimpl4 = Updater.m4937constructorimpl(composerStartRestartGroup);
                    Updater.m4945setimpl(composerM4937constructorimpl4, measurePolicyRowMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m4945setimpl(composerM4937constructorimpl4, currentCompositionLocalMap4, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Updater.m4945setimpl(composerM4937constructorimpl4, Integer.valueOf(iHashCode4), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                    Updater.m4943reconcileimpl(composerM4937constructorimpl4, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                    Updater.m4945setimpl(composerM4937constructorimpl4, modifierMaterializeModifier4, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, str9);
                    RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 457621553, "C339@12524L902,354@13443L29,355@13489L1482:SmartSubwayRealtime.kt#n9ob9m");
                    Alignment.Horizontal centerHorizontally = Alignment.INSTANCE.getCenterHorizontally();
                    Modifier modifierM1495width3ABfNKs = SizeKt.m1495width3ABfNKs(Modifier.INSTANCE, Dp.m8748constructorimpl(20.0f));
                    String str14 = str;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, str14);
                    MeasurePolicy measurePolicyColumnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), centerHorizontally, composerStartRestartGroup, 48);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, str11);
                    int iHashCode5 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap5 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier5 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1495width3ABfNKs);
                    constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, str12);
                    if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(constructor3);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    Composer composerM4937constructorimpl5 = Updater.m4937constructorimpl(composerStartRestartGroup);
                    Updater.m4945setimpl(composerM4937constructorimpl5, measurePolicyColumnMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m4945setimpl(composerM4937constructorimpl5, currentCompositionLocalMap5, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Updater.m4945setimpl(composerM4937constructorimpl5, Integer.valueOf(iHashCode5), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                    Updater.m4943reconcileimpl(composerM4937constructorimpl5, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                    Updater.m4945setimpl(composerM4937constructorimpl5, modifierMaterializeModifier5, ComposeUiNode.INSTANCE.getSetModifier());
                    String str15 = str10;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, str15);
                    ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 991919605, "C340@12639L428:SmartSubwayRealtime.kt#n9ob9m");
                    Modifier.Companion companion2 = Modifier.INSTANCE;
                    if (smartSubwayTimelineStop.getActive()) {
                        f2 = 18.0f;
                    } else {
                        f2 = 12.0f;
                    }
                    Modifier modifierClip = ClipKt.clip(SizeKt.m1490size3ABfNKs(companion2, Dp.m8748constructorimpl(f2)), RoundedCornerShapeKt.getCircleShape());
                    if (smartSubwayTimelineStop.getActive()) {
                        jColor = Color.INSTANCE.m5875getWhite0d7_KjU();
                    } else {
                        jColor = ColorKt.Color(smartSubwayTimelineStop.getLineColor());
                    }
                    Modifier modifierM648backgroundbw27NRU$default = BackgroundKt.m648backgroundbw27NRU$default(modifierClip, jColor, null, 2, null);
                    if (smartSubwayTimelineStop.getActive()) {
                        fM8748constructorimpl = Dp.m8748constructorimpl(3.0f);
                        f3 = 0.0f;
                    } else {
                        f3 = 0.0f;
                        fM8748constructorimpl = Dp.m8748constructorimpl(0.0f);
                    }
                    if (smartSubwayTimelineStop.getActive()) {
                        jM5873getTransparent0d7_KjU = ColorKt.Color(smartSubwayTimelineStop.getLineColor());
                    } else {
                        jM5873getTransparent0d7_KjU = Color.INSTANCE.m5873getTransparent0d7_KjU();
                    }
                    BoxKt.Box(BorderKt.m659borderxT4_qwU(modifierM648backgroundbw27NRU$default, fM8748constructorimpl, jM5873getTransparent0d7_KjU, RoundedCornerShapeKt.getCircleShape()), composerStartRestartGroup, 0);
                    if (i6 < CollectionsKt.getLastIndex(stops)) {
                        composerStartRestartGroup.startReplaceGroup(992378962);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "348@13143L29,349@13197L189");
                        i7 = 6;
                        SpacerKt.Spacer(SizeKt.m1476height3ABfNKs(Modifier.INSTANCE, Dp.m8748constructorimpl(4.0f)), composerStartRestartGroup, 6);
                        BoxKt.Box(BackgroundKt.m648backgroundbw27NRU$default(ClipKt.clip(SizeKt.m1476height3ABfNKs(SizeKt.m1495width3ABfNKs(Modifier.INSTANCE, Dp.m8748constructorimpl(4.0f)), Dp.m8748constructorimpl(34.0f)), RoundedCornerShapeKt.m1756RoundedCornerShape0680j_4(Dp.m8748constructorimpl(2.0f))), Color.m5837copywmQWz5c$default(ColorKt.Color(smartSubwayTimelineStop.getLineColor()), 0.75f, 0.0f, 0.0f, 0.0f, 14, null), null, 2, null), composerStartRestartGroup, 0);
                    } else {
                        i7 = 6;
                        composerStartRestartGroup.startReplaceGroup(979356885);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    SpacerKt.Spacer(SizeKt.m1495width3ABfNKs(Modifier.INSTANCE, Dp.m8748constructorimpl(14.0f)), composerStartRestartGroup, i7);
                    Modifier modifierWeight$default = RowScope.weight$default(rowScopeInstance2, Modifier.INSTANCE, 1.0f, false, 2, null);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, str14);
                    MeasurePolicy measurePolicyColumnMeasurePolicy3 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, str11);
                    int iHashCode6 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap6 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier6 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierWeight$default);
                    constructor4 = ComposeUiNode.INSTANCE.getConstructor();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, str12);
                    if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(constructor4);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    Composer composerM4937constructorimpl6 = Updater.m4937constructorimpl(composerStartRestartGroup);
                    Updater.m4945setimpl(composerM4937constructorimpl6, measurePolicyColumnMeasurePolicy3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m4945setimpl(composerM4937constructorimpl6, currentCompositionLocalMap6, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Updater.m4945setimpl(composerM4937constructorimpl6, Integer.valueOf(iHashCode6), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                    Updater.m4943reconcileimpl(composerM4937constructorimpl6, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                    Updater.m4945setimpl(composerM4937constructorimpl6, modifierMaterializeModifier6, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, str15);
                    ColumnScopeInstance columnScopeInstance3 = ColumnScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1007169351, "C356@13539L362,363@13922L29,364@13972L981:SmartSubwayRealtime.kt#n9ob9m");
                    composer2 = composerStartRestartGroup;
                    String stationName = smartSubwayTimelineStop.getStationName();
                    if (smartSubwayTimelineStop.getActive()) {
                        jColor2 = Color.INSTANCE.m5875getWhite0d7_KjU();
                    } else {
                        jColor2 = ColorKt.Color(4291875285L);
                    }
                    if (smartSubwayTimelineStop.getActive()) {
                        i8 = 17;
                    } else {
                        i8 = 14;
                    }
                    long sp = TextUnitKt.getSp(i8);
                    if (smartSubwayTimelineStop.getActive()) {
                        normal = FontWeight.INSTANCE.getBold();
                    } else {
                        normal = FontWeight.INSTANCE.getNormal();
                    }
                    i9 = i6;
                    String str16 = str9;
                    TextKt.m3661TextNvy7gAk(stationName, null, jColor2, null, sp, null, normal, null, 0L, null, null, 0L, 0, false, 1, 0, null, null, composer2, 0, 24576, 245674);
                    SpacerKt.Spacer(SizeKt.m1476height3ABfNKs(Modifier.INSTANCE, Dp.m8748constructorimpl(2.0f)), composer2, 6);
                    Alignment.Vertical centerVertically3 = Alignment.INSTANCE.getCenterVertically();
                    ComposerKt.sourceInformationMarkerStart(composer2, 844473419, str13);
                    Modifier.Companion companion3 = Modifier.INSTANCE;
                    MeasurePolicy measurePolicyRowMeasurePolicy3 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically3, composer2, 48);
                    ComposerKt.sourceInformationMarkerStart(composer2, -1159599143, str11);
                    int iHashCode7 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer2, 0));
                    CompositionLocalMap currentCompositionLocalMap7 = composer2.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier7 = ComposedModifierKt.materializeModifier(composer2, companion3);
                    constructor5 = ComposeUiNode.INSTANCE.getConstructor();
                    ComposerKt.sourceInformationMarkerStart(composer2, -553112988, str12);
                    if (!(composer2.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composer2.startReusableNode();
                    if (composer2.getInserting()) {
                        composer2.createNode(constructor5);
                    } else {
                        composer2.useNode();
                    }
                    Composer composerM4937constructorimpl7 = Updater.m4937constructorimpl(composer2);
                    Updater.m4945setimpl(composerM4937constructorimpl7, measurePolicyRowMeasurePolicy3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m4945setimpl(composerM4937constructorimpl7, currentCompositionLocalMap7, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Updater.m4945setimpl(composerM4937constructorimpl7, Integer.valueOf(iHashCode7), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                    Updater.m4943reconcileimpl(composerM4937constructorimpl7, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                    Updater.m4945setimpl(composerM4937constructorimpl7, modifierMaterializeModifier7, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composer2, 1456264949, str16);
                    RowScopeInstance rowScopeInstance3 = RowScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composer2, 57013152, "C365@14050L326:SmartSubwayRealtime.kt#n9ob9m");
                    String caption = smartSubwayTimelineStop.getCaption();
                    if (smartSubwayTimelineStop.getActive()) {
                        jColor3 = ColorKt.Color(smartSubwayTimelineStop.getLineColor());
                    } else {
                        jColor3 = ColorKt.Color(4286020224L);
                    }
                    long sp2 = TextUnitKt.getSp(11);
                    if (smartSubwayTimelineStop.getActive()) {
                        normal2 = FontWeight.INSTANCE.getSemiBold();
                    } else {
                        normal2 = FontWeight.INSTANCE.getNormal();
                    }
                    TextKt.m3661TextNvy7gAk(caption, null, jColor3, null, sp2, null, normal2, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer2, 24576, 0, 262058);
                    composerStartRestartGroup = composer2;
                    if (StringsKt.isBlank(smartSubwayTimelineStop.getLineName())) {
                        composerStartRestartGroup.startReplaceGroup(43047248);
                    } else {
                        composerStartRestartGroup.startReplaceGroup(57381214);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "372@14463L28,373@14520L385");
                        SpacerKt.Spacer(SizeKt.m1495width3ABfNKs(Modifier.INSTANCE, Dp.m8748constructorimpl(7.0f)), composerStartRestartGroup, 6);
                        Modifier modifierM1424paddingVpY3zN5 = PaddingKt.m1424paddingVpY3zN4(BackgroundKt.m648backgroundbw27NRU$default(ClipKt.clip(Modifier.INSTANCE, RoundedCornerShapeKt.m1756RoundedCornerShape0680j_4(Dp.m8748constructorimpl(6.0f))), Color.m5837copywmQWz5c$default(ColorKt.Color(smartSubwayTimelineStop.getLineColor()), 0.18f, 0.0f, 0.0f, 0.0f, 14, null), null, 2, null), Dp.m8748constructorimpl(6.0f), Dp.m8748constructorimpl(2.0f));
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, str11);
                        int iHashCode8 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                        CompositionLocalMap currentCompositionLocalMap8 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier8 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1424paddingVpY3zN5);
                        constructor6 = ComposeUiNode.INSTANCE.getConstructor();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, str12);
                        if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composerStartRestartGroup.startReusableNode();
                        if (composerStartRestartGroup.getInserting()) {
                            composerStartRestartGroup.createNode(constructor6);
                        } else {
                            composerStartRestartGroup.useNode();
                        }
                        Composer composerM4937constructorimpl8 = Updater.m4937constructorimpl(composerStartRestartGroup);
                        Updater.m4945setimpl(composerM4937constructorimpl8, measurePolicyMaybeCachedBoxMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m4945setimpl(composerM4937constructorimpl8, currentCompositionLocalMap8, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Updater.m4945setimpl(composerM4937constructorimpl8, Integer.valueOf(iHashCode8), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                        Updater.m4943reconcileimpl(composerM4937constructorimpl8, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                        Updater.m4945setimpl(composerM4937constructorimpl8, modifierMaterializeModifier8, ComposeUiNode.INSTANCE.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                        BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1900039305, "C376@14770L105:SmartSubwayRealtime.kt#n9ob9m");
                        TextKt.m3661TextNvy7gAk(smartSubwayTimelineStop.getLineName(), null, ColorKt.Color(smartSubwayTimelineStop.getLineColor()), null, TextUnitKt.getSp(10), null, FontWeight.INSTANCE.getBold(), null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composerStartRestartGroup, 1597440, 0, 262058);
                        composerStartRestartGroup = composerStartRestartGroup;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composerStartRestartGroup.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    }
                    composerStartRestartGroup.endReplaceGroup();
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
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (i9 < CollectionsKt.getLastIndex(stops)) {
                        composerStartRestartGroup.startReplaceGroup(-2116702044);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "382@15027L29");
                        SpacerKt.Spacer(SizeKt.m1476height3ABfNKs(Modifier.INSTANCE, Dp.m8748constructorimpl(4.0f)), composerStartRestartGroup, 6);
                    } else {
                        composerStartRestartGroup.startReplaceGroup(-1208162597);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    companion = modifier3;
                    str3 = str12;
                    str2 = str11;
                    i4 = i12;
                    f = f3;
                    str4 = str15;
                    str = str14;
                    obj = null;
                    i3 = 1;
                }
                Modifier modifier4 = companion;
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
                modifier2 = modifier4;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.tickets.SmartSubwayRealtimeKt$$ExternalSyntheticLambda10
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj3, Object obj4) {
                        return SmartSubwayRealtimeKt.SmartSubwayGoogleRouteTimeline$lambda$26(stops, modifier2, i, i2, (Composer) obj3, ((Integer) obj4).intValue());
                    }
                });
            }
        }
        i10 |= 48;
        modifier2 = modifier;
        i3 = 1;
        if ((i10 & 19) != 18) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i10 & 1)) {
            if (i11 != 0) {
                companion = Modifier.INSTANCE;
            } else {
                companion = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1441224283, i10, -1, "com.example.tickets.SmartSubwayGoogleRouteTimeline (SmartSubwayRealtime.kt:315)");
            }
            if (stops.isEmpty()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                scopeUpdateScopeEndRestartGroup2 = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup2 != null) {
                    scopeUpdateScopeEndRestartGroup2.updateScope(new Function2() { // from class: com.example.tickets.SmartSubwayRealtimeKt$$ExternalSyntheticLambda9
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj3, Object obj4) {
                            return SmartSubwayRealtimeKt.SmartSubwayGoogleRouteTimeline$lambda$16(stops, companion, i, i2, (Composer) obj3, ((Integer) obj4).intValue());
                        }
                    });
                    return;
                }
                return;
            }
            f = 0.0f;
            obj = null;
            Modifier modifierFillMaxWidth$default4 = SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null);
            str = "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo";
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy4 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
            str2 = "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh";
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
            int iHashCode9 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap9 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier9 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxWidth$default4);
            constructor = ComposeUiNode.INSTANCE.getConstructor();
            str3 = "CC(ReusableComposeNode)N(factory,update,content)410@16216L9:Composables.kt#9igjgp";
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
            Updater.m4945setimpl(composerM4937constructorimpl9, measurePolicyColumnMeasurePolicy4, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m4945setimpl(composerM4937constructorimpl9, currentCompositionLocalMap9, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m4945setimpl(composerM4937constructorimpl9, Integer.valueOf(iHashCode9), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m4943reconcileimpl(composerM4937constructorimpl9, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m4945setimpl(composerM4937constructorimpl9, modifierMaterializeModifier9, ComposeUiNode.INSTANCE.getSetModifier());
            str4 = "C89@4557L9:Column.kt#2w3rfo";
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance4 = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 474760505, "C:SmartSubwayRealtime.kt#n9ob9m");
            composerStartRestartGroup.startReplaceGroup(-954516284);
            ComposerKt.sourceInformation(composerStartRestartGroup, "*338@12418L2567");
            i4 = 0;
            while (r30.hasNext()) {
                int i13 = i4 + 1;
                if (i4 < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                smartSubwayTimelineStop = (SmartSubwayTimelineStop) obj2;
                str5 = str4;
                i5 = i4;
                if (i5 > 0) {
                    modifier3 = companion;
                    str6 = "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo";
                    str7 = str3;
                    str8 = str2;
                    str9 = "C101@5233L9:Row.kt#2w3rfo";
                    str10 = str5;
                    i6 = i5;
                    composerStartRestartGroup.startReplaceGroup(-1208162597);
                } else {
                    modifier3 = companion;
                    str6 = "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo";
                    str7 = str3;
                    str8 = str2;
                    str9 = "C101@5233L9:Row.kt#2w3rfo";
                    str10 = str5;
                    i6 = i5;
                    composerStartRestartGroup.startReplaceGroup(-1208162597);
                }
                composerStartRestartGroup.endReplaceGroup();
                Modifier modifierFillMaxWidth$default5 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                Alignment.Vertical centerVertically4 = Alignment.INSTANCE.getCenterVertically();
                String str17 = str6;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, str17);
                MeasurePolicy measurePolicyRowMeasurePolicy4 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically4, composerStartRestartGroup, 48);
                str11 = str8;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, str11);
                int iHashCode10 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap10 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier10 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxWidth$default5);
                constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                str12 = str7;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, str12);
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor2);
                } else {
                    composerStartRestartGroup.useNode();
                }
                Composer composerM4937constructorimpl10 = Updater.m4937constructorimpl(composerStartRestartGroup);
                Updater.m4945setimpl(composerM4937constructorimpl10, measurePolicyRowMeasurePolicy4, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m4945setimpl(composerM4937constructorimpl10, currentCompositionLocalMap10, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Updater.m4945setimpl(composerM4937constructorimpl10, Integer.valueOf(iHashCode10), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                Updater.m4943reconcileimpl(composerM4937constructorimpl10, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                Updater.m4945setimpl(composerM4937constructorimpl10, modifierMaterializeModifier10, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, str9);
                RowScopeInstance rowScopeInstance4 = RowScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 457621553, "C339@12524L902,354@13443L29,355@13489L1482:SmartSubwayRealtime.kt#n9ob9m");
                Alignment.Horizontal centerHorizontally2 = Alignment.INSTANCE.getCenterHorizontally();
                Modifier modifierM1495width3ABfNKs2 = SizeKt.m1495width3ABfNKs(Modifier.INSTANCE, Dp.m8748constructorimpl(20.0f));
                String str18 = str;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, str18);
                MeasurePolicy measurePolicyColumnMeasurePolicy5 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), centerHorizontally2, composerStartRestartGroup, 48);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, str11);
                int iHashCode11 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap11 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier11 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1495width3ABfNKs2);
                constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, str12);
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor3);
                } else {
                    composerStartRestartGroup.useNode();
                }
                Composer composerM4937constructorimpl11 = Updater.m4937constructorimpl(composerStartRestartGroup);
                Updater.m4945setimpl(composerM4937constructorimpl11, measurePolicyColumnMeasurePolicy5, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m4945setimpl(composerM4937constructorimpl11, currentCompositionLocalMap11, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Updater.m4945setimpl(composerM4937constructorimpl11, Integer.valueOf(iHashCode11), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                Updater.m4943reconcileimpl(composerM4937constructorimpl11, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                Updater.m4945setimpl(composerM4937constructorimpl11, modifierMaterializeModifier11, ComposeUiNode.INSTANCE.getSetModifier());
                String str19 = str10;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, str19);
                ColumnScopeInstance columnScopeInstance5 = ColumnScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 991919605, "C340@12639L428:SmartSubwayRealtime.kt#n9ob9m");
                Modifier.Companion companion4 = Modifier.INSTANCE;
                if (smartSubwayTimelineStop.getActive()) {
                    f2 = 18.0f;
                } else {
                    f2 = 12.0f;
                }
                Modifier modifierClip2 = ClipKt.clip(SizeKt.m1490size3ABfNKs(companion4, Dp.m8748constructorimpl(f2)), RoundedCornerShapeKt.getCircleShape());
                if (smartSubwayTimelineStop.getActive()) {
                    jColor = Color.INSTANCE.m5875getWhite0d7_KjU();
                } else {
                    jColor = ColorKt.Color(smartSubwayTimelineStop.getLineColor());
                }
                Modifier modifierM648backgroundbw27NRU$default2 = BackgroundKt.m648backgroundbw27NRU$default(modifierClip2, jColor, null, 2, null);
                if (smartSubwayTimelineStop.getActive()) {
                    fM8748constructorimpl = Dp.m8748constructorimpl(3.0f);
                    f3 = 0.0f;
                } else {
                    f3 = 0.0f;
                    fM8748constructorimpl = Dp.m8748constructorimpl(0.0f);
                }
                if (smartSubwayTimelineStop.getActive()) {
                    jM5873getTransparent0d7_KjU = ColorKt.Color(smartSubwayTimelineStop.getLineColor());
                } else {
                    jM5873getTransparent0d7_KjU = Color.INSTANCE.m5873getTransparent0d7_KjU();
                }
                BoxKt.Box(BorderKt.m659borderxT4_qwU(modifierM648backgroundbw27NRU$default2, fM8748constructorimpl, jM5873getTransparent0d7_KjU, RoundedCornerShapeKt.getCircleShape()), composerStartRestartGroup, 0);
                if (i6 < CollectionsKt.getLastIndex(stops)) {
                    composerStartRestartGroup.startReplaceGroup(992378962);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "348@13143L29,349@13197L189");
                    i7 = 6;
                    SpacerKt.Spacer(SizeKt.m1476height3ABfNKs(Modifier.INSTANCE, Dp.m8748constructorimpl(4.0f)), composerStartRestartGroup, 6);
                    BoxKt.Box(BackgroundKt.m648backgroundbw27NRU$default(ClipKt.clip(SizeKt.m1476height3ABfNKs(SizeKt.m1495width3ABfNKs(Modifier.INSTANCE, Dp.m8748constructorimpl(4.0f)), Dp.m8748constructorimpl(34.0f)), RoundedCornerShapeKt.m1756RoundedCornerShape0680j_4(Dp.m8748constructorimpl(2.0f))), Color.m5837copywmQWz5c$default(ColorKt.Color(smartSubwayTimelineStop.getLineColor()), 0.75f, 0.0f, 0.0f, 0.0f, 14, null), null, 2, null), composerStartRestartGroup, 0);
                } else {
                    i7 = 6;
                    composerStartRestartGroup.startReplaceGroup(979356885);
                }
                composerStartRestartGroup.endReplaceGroup();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                SpacerKt.Spacer(SizeKt.m1495width3ABfNKs(Modifier.INSTANCE, Dp.m8748constructorimpl(14.0f)), composerStartRestartGroup, i7);
                Modifier modifierWeight$default2 = RowScope.weight$default(rowScopeInstance4, Modifier.INSTANCE, 1.0f, false, 2, null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, str18);
                MeasurePolicy measurePolicyColumnMeasurePolicy6 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, str11);
                int iHashCode12 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap12 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier12 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierWeight$default2);
                constructor4 = ComposeUiNode.INSTANCE.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, str12);
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor4);
                } else {
                    composerStartRestartGroup.useNode();
                }
                Composer composerM4937constructorimpl12 = Updater.m4937constructorimpl(composerStartRestartGroup);
                Updater.m4945setimpl(composerM4937constructorimpl12, measurePolicyColumnMeasurePolicy6, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m4945setimpl(composerM4937constructorimpl12, currentCompositionLocalMap12, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Updater.m4945setimpl(composerM4937constructorimpl12, Integer.valueOf(iHashCode12), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                Updater.m4943reconcileimpl(composerM4937constructorimpl12, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                Updater.m4945setimpl(composerM4937constructorimpl12, modifierMaterializeModifier12, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, str19);
                ColumnScopeInstance columnScopeInstance6 = ColumnScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1007169351, "C356@13539L362,363@13922L29,364@13972L981:SmartSubwayRealtime.kt#n9ob9m");
                composer2 = composerStartRestartGroup;
                String stationName2 = smartSubwayTimelineStop.getStationName();
                if (smartSubwayTimelineStop.getActive()) {
                    jColor2 = Color.INSTANCE.m5875getWhite0d7_KjU();
                } else {
                    jColor2 = ColorKt.Color(4291875285L);
                }
                if (smartSubwayTimelineStop.getActive()) {
                    i8 = 17;
                } else {
                    i8 = 14;
                }
                long sp3 = TextUnitKt.getSp(i8);
                if (smartSubwayTimelineStop.getActive()) {
                    normal = FontWeight.INSTANCE.getBold();
                } else {
                    normal = FontWeight.INSTANCE.getNormal();
                }
                i9 = i6;
                String str110 = str9;
                TextKt.m3661TextNvy7gAk(stationName2, null, jColor2, null, sp3, null, normal, null, 0L, null, null, 0L, 0, false, 1, 0, null, null, composer2, 0, 24576, 245674);
                SpacerKt.Spacer(SizeKt.m1476height3ABfNKs(Modifier.INSTANCE, Dp.m8748constructorimpl(2.0f)), composer2, 6);
                Alignment.Vertical centerVertically5 = Alignment.INSTANCE.getCenterVertically();
                ComposerKt.sourceInformationMarkerStart(composer2, 844473419, str17);
                Modifier.Companion companion5 = Modifier.INSTANCE;
                MeasurePolicy measurePolicyRowMeasurePolicy5 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically5, composer2, 48);
                ComposerKt.sourceInformationMarkerStart(composer2, -1159599143, str11);
                int iHashCode13 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer2, 0));
                CompositionLocalMap currentCompositionLocalMap13 = composer2.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier13 = ComposedModifierKt.materializeModifier(composer2, companion5);
                constructor5 = ComposeUiNode.INSTANCE.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composer2, -553112988, str12);
                if (!(composer2.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composer2.startReusableNode();
                if (composer2.getInserting()) {
                    composer2.createNode(constructor5);
                } else {
                    composer2.useNode();
                }
                Composer composerM4937constructorimpl13 = Updater.m4937constructorimpl(composer2);
                Updater.m4945setimpl(composerM4937constructorimpl13, measurePolicyRowMeasurePolicy5, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m4945setimpl(composerM4937constructorimpl13, currentCompositionLocalMap13, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Updater.m4945setimpl(composerM4937constructorimpl13, Integer.valueOf(iHashCode13), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                Updater.m4943reconcileimpl(composerM4937constructorimpl13, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                Updater.m4945setimpl(composerM4937constructorimpl13, modifierMaterializeModifier13, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composer2, 1456264949, str110);
                RowScopeInstance rowScopeInstance5 = RowScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composer2, 57013152, "C365@14050L326:SmartSubwayRealtime.kt#n9ob9m");
                String caption2 = smartSubwayTimelineStop.getCaption();
                if (smartSubwayTimelineStop.getActive()) {
                    jColor3 = ColorKt.Color(smartSubwayTimelineStop.getLineColor());
                } else {
                    jColor3 = ColorKt.Color(4286020224L);
                }
                long sp4 = TextUnitKt.getSp(11);
                if (smartSubwayTimelineStop.getActive()) {
                    normal2 = FontWeight.INSTANCE.getSemiBold();
                } else {
                    normal2 = FontWeight.INSTANCE.getNormal();
                }
                TextKt.m3661TextNvy7gAk(caption2, null, jColor3, null, sp4, null, normal2, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer2, 24576, 0, 262058);
                composerStartRestartGroup = composer2;
                if (StringsKt.isBlank(smartSubwayTimelineStop.getLineName())) {
                    composerStartRestartGroup.startReplaceGroup(57381214);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "372@14463L28,373@14520L385");
                    SpacerKt.Spacer(SizeKt.m1495width3ABfNKs(Modifier.INSTANCE, Dp.m8748constructorimpl(7.0f)), composerStartRestartGroup, 6);
                    Modifier modifierM1424paddingVpY3zN6 = PaddingKt.m1424paddingVpY3zN4(BackgroundKt.m648backgroundbw27NRU$default(ClipKt.clip(Modifier.INSTANCE, RoundedCornerShapeKt.m1756RoundedCornerShape0680j_4(Dp.m8748constructorimpl(6.0f))), Color.m5837copywmQWz5c$default(ColorKt.Color(smartSubwayTimelineStop.getLineColor()), 0.18f, 0.0f, 0.0f, 0.0f, 14, null), null, 2, null), Dp.m8748constructorimpl(6.0f), Dp.m8748constructorimpl(2.0f));
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, str11);
                    int iHashCode14 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap14 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier14 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1424paddingVpY3zN6);
                    constructor6 = ComposeUiNode.INSTANCE.getConstructor();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, str12);
                    if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(constructor6);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    Composer composerM4937constructorimpl14 = Updater.m4937constructorimpl(composerStartRestartGroup);
                    Updater.m4945setimpl(composerM4937constructorimpl14, measurePolicyMaybeCachedBoxMeasurePolicy3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m4945setimpl(composerM4937constructorimpl14, currentCompositionLocalMap14, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Updater.m4945setimpl(composerM4937constructorimpl14, Integer.valueOf(iHashCode14), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                    Updater.m4943reconcileimpl(composerM4937constructorimpl14, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                    Updater.m4945setimpl(composerM4937constructorimpl14, modifierMaterializeModifier14, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance3 = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1900039305, "C376@14770L105:SmartSubwayRealtime.kt#n9ob9m");
                    TextKt.m3661TextNvy7gAk(smartSubwayTimelineStop.getLineName(), null, ColorKt.Color(smartSubwayTimelineStop.getLineColor()), null, TextUnitKt.getSp(10), null, FontWeight.INSTANCE.getBold(), null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composerStartRestartGroup, 1597440, 0, 262058);
                    composerStartRestartGroup = composerStartRestartGroup;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                } else {
                    composerStartRestartGroup.startReplaceGroup(43047248);
                }
                composerStartRestartGroup.endReplaceGroup();
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
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (i9 < CollectionsKt.getLastIndex(stops)) {
                    composerStartRestartGroup.startReplaceGroup(-2116702044);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "382@15027L29");
                    SpacerKt.Spacer(SizeKt.m1476height3ABfNKs(Modifier.INSTANCE, Dp.m8748constructorimpl(4.0f)), composerStartRestartGroup, 6);
                } else {
                    composerStartRestartGroup.startReplaceGroup(-1208162597);
                }
                composerStartRestartGroup.endReplaceGroup();
                companion = modifier3;
                str3 = str12;
                str2 = str11;
                i4 = i13;
                f = f3;
                str4 = str19;
                str = str18;
                obj = null;
                i3 = 1;
            }
            Modifier modifier5 = companion;
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
            modifier2 = modifier5;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.tickets.SmartSubwayRealtimeKt$$ExternalSyntheticLambda10
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj3, Object obj4) {
                    return SmartSubwayRealtimeKt.SmartSubwayGoogleRouteTimeline$lambda$26(stops, modifier2, i, i2, (Composer) obj3, ((Integer) obj4).intValue());
                }
            });
        }
    }

    public static final NotificationCompat.ProgressStyle buildSmartSubwayProgressStyle(Context context, SmartSubwayRealtimeState state) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(state, "state");
        String previousStation = state.getPreviousStation();
        if (StringsKt.isBlank(previousStation) || StringsKt.equals(previousStation, state.getCurrentStation(), true)) {
            previousStation = null;
        }
        if (previousStation == null) {
            String origin = state.getOrigin();
            if (StringsKt.isBlank(origin)) {
                origin = "上一站";
            }
        }
        String currentStation = state.getCurrentStation();
        if (StringsKt.isBlank(currentStation)) {
            currentStation = "当前站";
        }
        String nextStation = state.getNextStation();
        if (StringsKt.isBlank(nextStation)) {
            nextStation = "下一站";
        }
        NotificationCompat.ProgressStyle.Segment id = new NotificationCompat.ProgressStyle.Segment(100).setColor(state.getPrimaryLineColor()).setId(1);
        Intrinsics.checkNotNullExpressionValue(id, "setId(...)");
        int secondaryLineColor = isAfterTransfer(state) ? state.getSecondaryLineColor() : state.getPrimaryLineColor();
        NotificationCompat.ProgressStyle.Segment id2 = new NotificationCompat.ProgressStyle.Segment(100).setColor(secondaryLineColor).setId(2);
        Intrinsics.checkNotNullExpressionValue(id2, "setId(...)");
        NotificationCompat.ProgressStyle progressPoints = new NotificationCompat.ProgressStyle().setStyledByProgress(true).setProgress(RangesKt.coerceIn(state.isDestination() ? 200 : ((int) Math.rint(RangesKt.coerceIn(state.getSegmentProgress(), 0.0f, 1.0f) * 100.0f)) + 100, 0, 200)).setProgressSegments(CollectionsKt.listOf((Object[]) new NotificationCompat.ProgressStyle.Segment[]{id, id2})).setProgressPoints(CollectionsKt.listOf((Object[]) new NotificationCompat.ProgressStyle.Point[]{new NotificationCompat.ProgressStyle.Point(1).setId(1).setColor(android.graphics.Color.rgb(142, 145, 151)), new NotificationCompat.ProgressStyle.Point(100).setId(2).setColor(state.getPrimaryLineColor()), new NotificationCompat.ProgressStyle.Point(200).setId(3).setColor(secondaryLineColor)}));
        Intrinsics.checkNotNullExpressionValue(progressPoints, "setProgressPoints(...)");
        return progressPoints;
    }

    public static final String buildSmartSubwayProgressText(SmartSubwayRealtimeState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        String previousStation = state.getPreviousStation();
        if (StringsKt.isBlank(previousStation) || StringsKt.equals(previousStation, state.getCurrentStation(), true)) {
            previousStation = null;
        }
        if (previousStation == null) {
            String origin = state.getOrigin();
            if (StringsKt.isBlank(origin)) {
                origin = "上一站";
            }
            previousStation = origin;
        }
        String currentStation = state.getCurrentStation();
        if (StringsKt.isBlank(currentStation)) {
            currentStation = "当前站";
        }
        String str = currentStation;
        String nextStation = state.getNextStation();
        if (StringsKt.isBlank(nextStation)) {
            nextStation = "下一站";
        }
        String str2 = nextStation;
        String strUnifiedSmartSubwayStatusText = unifiedSmartSubwayStatusText(state);
        if (StringsKt.isBlank(strUnifiedSmartSubwayStatusText)) {
            strUnifiedSmartSubwayStatusText = "正在前往下一站";
        }
        return CollectionsKt.joinToString$default(CollectionsKt.listOf((Object[]) new String[]{"上一站：" + previousStation, "当前站：" + str, "下一站：" + str2, strUnifiedSmartSubwayStatusText}), "\n", null, null, 0, null, null, 62, null);
    }

    /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r1v1 com.example.tickets.SmartSubwayRealtimeState, still in use, count: 3, list:
          (r1v1 com.example.tickets.SmartSubwayRealtimeState) from 0x00a7: MOVE (r21v0 com.example.tickets.SmartSubwayRealtimeState) = (r1v1 com.example.tickets.SmartSubwayRealtimeState)
          (r1v1 com.example.tickets.SmartSubwayRealtimeState) from 0x0098: MOVE (r21v1 com.example.tickets.SmartSubwayRealtimeState) = (r1v1 com.example.tickets.SmartSubwayRealtimeState)
          (r1v1 com.example.tickets.SmartSubwayRealtimeState) from 0x007f: MOVE (r21v4 com.example.tickets.SmartSubwayRealtimeState) = (r1v1 com.example.tickets.SmartSubwayRealtimeState)
        	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:164)
        	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:129)
        	at jadx.core.utils.InsnRemover.unbindInsn(InsnRemover.java:93)
        	at jadx.core.utils.InsnRemover.addAndUnbind(InsnRemover.java:59)
        	at jadx.core.dex.visitors.ModVisitor.removeStep(ModVisitor.java:463)
        	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:97)
        */
    public static final com.example.tickets.SmartSubwayRealtimeState toRealtimeState(com.example.tickets.SmartSubwayTrip r24) {
        /*
            java.lang.String r0 = "<this>"
            r1 = r24
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            com.example.tickets.SmartSubwayRealtimeState r1 = new com.example.tickets.SmartSubwayRealtimeState
            java.lang.String r3 = r24.getCityId()
            java.lang.String r4 = r24.getCityName()
            java.lang.String r5 = r24.getOrigin()
            java.lang.String r6 = r24.getCurrentStation()
            java.lang.String r7 = r24.getNextStation()
            java.lang.String r8 = r24.getDestination()
            java.lang.String r9 = r24.getLineName()
            long r10 = r24.m9312getPrimaryLineColor0d7_KjU()
            int r10 = androidx.compose.ui.graphics.ColorKt.m5892toArgb8_81llA(r10)
            long r11 = r24.m9313getSecondaryLineColor0d7_KjU()
            int r11 = androidx.compose.ui.graphics.ColorKt.m5892toArgb8_81llA(r11)
            boolean r12 = r24.isTransferRequired()
            boolean r13 = r24.isDestination()
            java.lang.String r14 = r24.getTransferStation()
            java.lang.String r15 = r24.getPreviousStation()
            float r16 = r24.getSegmentProgress()
            java.lang.String r17 = r24.getTransferLineName()
            java.util.List r18 = r24.getTransferOptions()
            boolean r0 = r24.isDestination()
            if (r0 == 0) goto L5a
            java.lang.String r0 = "已到达"
            goto L5c
        L5a:
            java.lang.String r0 = ""
        L5c:
            r19 = r0
            boolean r0 = r24.isDestination()
            java.lang.String r2 = "准备换乘"
            if (r0 == 0) goto L6b
            java.lang.String r0 = "已到达目的地"
        L68:
            r20 = r0
            goto L77
        L6b:
            boolean r0 = r24.isTransferRequired()
            if (r0 == 0) goto L74
            r20 = r2
            goto L77
        L74:
            java.lang.String r0 = "行程进行中"
            goto L68
        L77:
            boolean r0 = r24.isDestination()
            if (r0 == 0) goto L82
            java.lang.String r2 = "带齐物品准备下车"
            r21 = r1
            goto Lb2
        L82:
            boolean r0 = r24.isTransferRequired()
            if (r0 == 0) goto La7
            java.lang.String r0 = r24.getTransferLineName()
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = kotlin.text.StringsKt.isBlank(r0)
            if (r0 != 0) goto La7
            java.lang.String r0 = r24.getTransferLineName()
            r21 = r1
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r2)
            r1.append(r0)
            java.lang.String r2 = r1.toString()
            goto Lb2
        La7:
            r21 = r1
            boolean r0 = r24.isTransferRequired()
            if (r0 == 0) goto Lb0
            goto Lb2
        Lb0:
            java.lang.String r2 = "正在前往下一站"
        Lb2:
            r22 = 1
            r23 = 0
            r1 = r21
            r21 = r2
            r2 = 0
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.tickets.SmartSubwayRealtimeKt.toRealtimeState(com.example.tickets.SmartSubwayTrip):com.example.tickets.SmartSubwayRealtimeState");
    }

    /* JADX WARN: Code duplicated, block: B:102:0x0312  */
    /* JADX WARN: Code duplicated, block: B:104:0x0318  */
    /* JADX WARN: Code duplicated, block: B:107:0x0323  */
    /* JADX WARN: Code duplicated, block: B:109:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:23:0x0047  */
    /* JADX WARN: Code duplicated, block: B:24:0x004a  */
    /* JADX WARN: Code duplicated, block: B:26:0x004e  */
    /* JADX WARN: Code duplicated, block: B:28:0x0056  */
    /* JADX WARN: Code duplicated, block: B:29:0x0059  */
    /* JADX WARN: Code duplicated, block: B:34:0x0067  */
    /* JADX WARN: Code duplicated, block: B:35:0x0069  */
    /* JADX WARN: Code duplicated, block: B:38:0x0072 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:39:0x0074  */
    /* JADX WARN: Code duplicated, block: B:40:0x0079  */
    /* JADX WARN: Code duplicated, block: B:42:0x007c  */
    /* JADX WARN: Code duplicated, block: B:43:0x007e  */
    /* JADX WARN: Code duplicated, block: B:46:0x0085  */
    /* JADX WARN: Code duplicated, block: B:49:0x0099  */
    /* JADX WARN: Code duplicated, block: B:50:0x009c  */
    /* JADX WARN: Code duplicated, block: B:53:0x00a6 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:54:0x00a8  */
    /* JADX WARN: Code duplicated, block: B:55:0x00ab  */
    /* JADX WARN: Code duplicated, block: B:57:0x00b2 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:58:0x00b4  */
    /* JADX WARN: Code duplicated, block: B:59:0x00b7  */
    /* JADX WARN: Code duplicated, block: B:63:0x0103  */
    /* JADX WARN: Code duplicated, block: B:66:0x010f  */
    /* JADX WARN: Code duplicated, block: B:67:0x0113  */
    /* JADX WARN: Code duplicated, block: B:70:0x016b  */
    /* JADX WARN: Code duplicated, block: B:71:0x016e  */
    /* JADX WARN: Code duplicated, block: B:74:0x0194  */
    /* JADX WARN: Code duplicated, block: B:75:0x0196  */
    /* JADX WARN: Code duplicated, block: B:78:0x019e  */
    /* JADX WARN: Code duplicated, block: B:80:0x01a6  */
    /* JADX WARN: Code duplicated, block: B:83:0x0219  */
    /* JADX WARN: Code duplicated, block: B:86:0x0225  */
    /* JADX WARN: Code duplicated, block: B:87:0x0229  */
    /* JADX WARN: Code duplicated, block: B:90:0x0278  */
    /* JADX WARN: Code duplicated, block: B:91:0x028a  */
    /* JADX WARN: Code duplicated, block: B:94:0x02a7  */
    /* JADX WARN: Code duplicated, block: B:95:0x02b8  */
    /* JADX WARN: Code duplicated, block: B:98:0x02ca  */
    /* JADX WARN: Code duplicated, block: B:99:0x02da  */
    public static final void SmartSubwayRouteCanvas(final SmartSubwayRealtimeState state, Modifier modifier, boolean z, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        boolean z2;
        int i5;
        boolean z3;
        final Modifier modifier3;
        final boolean z4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier.Companion companion;
        final boolean z5;
        boolean zIsUsSmartSubwayCity;
        float f;
        float f2;
        float fM8748constructorimpl;
        Function0<ComposeUiNode> constructor;
        float f3;
        boolean z6;
        boolean z7;
        Object objRememberedValue;
        Function0<ComposeUiNode> constructor2;
        RowScopeInstance rowScopeInstance;
        Modifier.Companion companionWeight$default;
        Modifier.Companion companion2;
        Modifier.Companion companionWeight$default2;
        Modifier.Companion companion3;
        Modifier.Companion companionWeight$default3;
        float f4;
        Intrinsics.checkNotNullParameter(state, "state");
        Composer composerStartRestartGroup = composer.startRestartGroup(1267079049);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(SmartSubwayRouteCanvas)N(state,modifier,compact)534@19762L1630:SmartSubwayRealtime.kt#n9ob9m");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(state) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i6 = i2 & 2;
        if (i6 == 0) {
            if ((i & 48) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            i4 = i2 & 4;
            if (i4 != 0) {
                if ((i & 384) == 0) {
                    z2 = z;
                    if (composerStartRestartGroup.changed(z2)) {
                        i5 = 256;
                    } else {
                        i5 = 128;
                    }
                    i3 |= i5;
                }
                if ((i3 & 147) != 146) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier3 = modifier2;
                    z4 = z2;
                } else {
                    if (i6 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i4 != 0) {
                        z5 = false;
                    } else {
                        z5 = z2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1267079049, i3, -1, "com.example.tickets.SmartSubwayRouteCanvas (SmartSubwayRealtime.kt:524)");
                    }
                    SmartSubwayHorizontalCardContent smartSubwayHorizontalCardContentBuildSmartSubwayHorizontalCardContent = buildSmartSubwayHorizontalCardContent(state);
                    zIsUsSmartSubwayCity = isUsSmartSubwayCity(state.getCityId());
                    if (z5) {
                        f = 48.0f;
                    } else {
                        f = 58.0f;
                    }
                    float fM8748constructorimpl2 = Dp.m8748constructorimpl(f);
                    if (zIsUsSmartSubwayCity) {
                        if (z5) {
                            f4 = 104.0f;
                        } else {
                            f4 = 120.0f;
                        }
                        fM8748constructorimpl = Dp.m8748constructorimpl(f4);
                    } else {
                        if (z5) {
                            f2 = 88.0f;
                        } else {
                            f2 = 106.0f;
                        }
                        fM8748constructorimpl = Dp.m8748constructorimpl(f2);
                    }
                    Modifier modifierM1476height3ABfNKs = SizeKt.m1476height3ABfNKs(companion, fM8748constructorimpl);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
                    int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1476height3ABfNKs);
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
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -761250450, "C540@19993L175,535@19812L356,547@20177L1209:SmartSubwayRealtime.kt#n9ob9m");
                    Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                    if (z5) {
                        f3 = 38.0f;
                    } else {
                        f3 = 46.0f;
                    }
                    Modifier modifierAlign = boxScopeInstance.align(SizeKt.m1476height3ABfNKs(modifierFillMaxWidth$default, Dp.m8748constructorimpl(f3)), Alignment.INSTANCE.getTopCenter());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -855836066, "CC(remember):SmartSubwayRealtime.kt#9igjgp");
                    boolean zChangedInstance = composerStartRestartGroup.changedInstance(state);
                    if ((i3 & 896) == 256) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    z7 = zChangedInstance | z6;
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!z7 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new Function1() { // from class: com.example.tickets.SmartSubwayRealtimeKt$$ExternalSyntheticLambda6
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return SmartSubwayRealtimeKt.SmartSubwayRouteCanvas$lambda$39$lambda$37$lambda$36(state, z5, (DrawScope) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    CanvasKt.Canvas(modifierAlign, (Function1) objRememberedValue, composerStartRestartGroup, 0);
                    Modifier modifierM1427paddingqDBjuR0$default = PaddingKt.m1427paddingqDBjuR0$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), 0.0f, fM8748constructorimpl2, 0.0f, 0.0f, 13, null);
                    Arrangement.HorizontalOrVertical spaceBetween = Arrangement.INSTANCE.getSpaceBetween();
                    Alignment.Vertical top = Alignment.INSTANCE.getTop();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                    MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(spaceBetween, top, composerStartRestartGroup, 54);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
                    int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1427paddingqDBjuR0$default);
                    constructor2 = ComposeUiNode.INSTANCE.getConstructor();
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
                    rowScopeInstance = RowScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1553530932, "C554@20420L312,562@20745L310,570@21068L308:SmartSubwayRealtime.kt#n9ob9m");
                    if (zIsUsSmartSubwayCity) {
                        companionWeight$default = RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null);
                    } else {
                        companionWeight$default = Modifier.INSTANCE;
                    }
                    int i7 = ((i3 << 6) & 57344) | 3456;
                    SmartSubwayThreeStationLabel(companionWeight$default, smartSubwayHorizontalCardContentBuildSmartSubwayHorizontalCardContent.getPreviousStation(), "上一站", false, z5, zIsUsSmartSubwayCity, composerStartRestartGroup, i7, 0);
                    companion2 = Modifier.INSTANCE;
                    if (zIsUsSmartSubwayCity) {
                        companionWeight$default2 = RowScope.weight$default(rowScopeInstance, companion2, 1.0f, false, 2, null);
                        rowScopeInstance = rowScopeInstance;
                    } else {
                        companionWeight$default2 = companion2;
                    }
                    SmartSubwayThreeStationLabel(companionWeight$default2, smartSubwayHorizontalCardContentBuildSmartSubwayHorizontalCardContent.getCurrentStation(), "当前站", true, z5, zIsUsSmartSubwayCity, composerStartRestartGroup, i7, 0);
                    companion3 = Modifier.INSTANCE;
                    if (zIsUsSmartSubwayCity) {
                        companionWeight$default3 = RowScope.weight$default(rowScopeInstance, companion3, 1.0f, false, 2, null);
                    } else {
                        companionWeight$default3 = companion3;
                    }
                    SmartSubwayThreeStationLabel(companionWeight$default3, smartSubwayHorizontalCardContentBuildSmartSubwayHorizontalCardContent.getNextStation(), "下一站", false, z5, zIsUsSmartSubwayCity, composerStartRestartGroup, i7, 0);
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
                    modifier3 = companion;
                    z4 = z5;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.tickets.SmartSubwayRealtimeKt$$ExternalSyntheticLambda7
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return SmartSubwayRealtimeKt.SmartSubwayRouteCanvas$lambda$40(state, modifier3, z4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 384;
            z2 = z;
            if ((i3 & 147) != 146) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                z4 = z2;
            } else {
                if (i6 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i4 != 0) {
                    z5 = false;
                } else {
                    z5 = z2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1267079049, i3, -1, "com.example.tickets.SmartSubwayRouteCanvas (SmartSubwayRealtime.kt:524)");
                }
                SmartSubwayHorizontalCardContent smartSubwayHorizontalCardContentBuildSmartSubwayHorizontalCardContent2 = buildSmartSubwayHorizontalCardContent(state);
                zIsUsSmartSubwayCity = isUsSmartSubwayCity(state.getCityId());
                if (z5) {
                    f = 48.0f;
                } else {
                    f = 58.0f;
                }
                float fM8748constructorimpl3 = Dp.m8748constructorimpl(f);
                if (zIsUsSmartSubwayCity) {
                    if (z5) {
                        f4 = 104.0f;
                    } else {
                        f4 = 120.0f;
                    }
                    fM8748constructorimpl = Dp.m8748constructorimpl(f4);
                } else {
                    if (z5) {
                        f2 = 88.0f;
                    } else {
                        f2 = 106.0f;
                    }
                    fM8748constructorimpl = Dp.m8748constructorimpl(f2);
                }
                Modifier modifierM1476height3ABfNKs2 = SizeKt.m1476height3ABfNKs(companion, fM8748constructorimpl);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
                int iHashCode3 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1476height3ABfNKs2);
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
                Updater.m4945setimpl(composerM4937constructorimpl3, measurePolicyMaybeCachedBoxMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m4945setimpl(composerM4937constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Updater.m4945setimpl(composerM4937constructorimpl3, Integer.valueOf(iHashCode3), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                Updater.m4943reconcileimpl(composerM4937constructorimpl3, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                Updater.m4945setimpl(composerM4937constructorimpl3, modifierMaterializeModifier3, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -761250450, "C540@19993L175,535@19812L356,547@20177L1209:SmartSubwayRealtime.kt#n9ob9m");
                Modifier modifierFillMaxWidth$default2 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                if (z5) {
                    f3 = 38.0f;
                } else {
                    f3 = 46.0f;
                }
                Modifier modifierAlign2 = boxScopeInstance2.align(SizeKt.m1476height3ABfNKs(modifierFillMaxWidth$default2, Dp.m8748constructorimpl(f3)), Alignment.INSTANCE.getTopCenter());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -855836066, "CC(remember):SmartSubwayRealtime.kt#9igjgp");
                boolean zChangedInstance2 = composerStartRestartGroup.changedInstance(state);
                if ((i3 & 896) == 256) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                z7 = zChangedInstance2 | z6;
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!z7) {
                    objRememberedValue = new Function1() { // from class: com.example.tickets.SmartSubwayRealtimeKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return SmartSubwayRealtimeKt.SmartSubwayRouteCanvas$lambda$39$lambda$37$lambda$36(state, z5, (DrawScope) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = new Function1() { // from class: com.example.tickets.SmartSubwayRealtimeKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return SmartSubwayRealtimeKt.SmartSubwayRouteCanvas$lambda$39$lambda$37$lambda$36(state, z5, (DrawScope) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                CanvasKt.Canvas(modifierAlign2, (Function1) objRememberedValue, composerStartRestartGroup, 0);
                Modifier modifierM1427paddingqDBjuR0$default2 = PaddingKt.m1427paddingqDBjuR0$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), 0.0f, fM8748constructorimpl3, 0.0f, 0.0f, 13, null);
                Arrangement.HorizontalOrVertical spaceBetween2 = Arrangement.INSTANCE.getSpaceBetween();
                Alignment.Vertical top2 = Alignment.INSTANCE.getTop();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                MeasurePolicy measurePolicyRowMeasurePolicy2 = RowKt.rowMeasurePolicy(spaceBetween2, top2, composerStartRestartGroup, 54);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
                int iHashCode4 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap4 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1427paddingqDBjuR0$default2);
                constructor2 = ComposeUiNode.INSTANCE.getConstructor();
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
                Composer composerM4937constructorimpl4 = Updater.m4937constructorimpl(composerStartRestartGroup);
                Updater.m4945setimpl(composerM4937constructorimpl4, measurePolicyRowMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m4945setimpl(composerM4937constructorimpl4, currentCompositionLocalMap4, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Updater.m4945setimpl(composerM4937constructorimpl4, Integer.valueOf(iHashCode4), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                Updater.m4943reconcileimpl(composerM4937constructorimpl4, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                Updater.m4945setimpl(composerM4937constructorimpl4, modifierMaterializeModifier4, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                rowScopeInstance = RowScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1553530932, "C554@20420L312,562@20745L310,570@21068L308:SmartSubwayRealtime.kt#n9ob9m");
                if (zIsUsSmartSubwayCity) {
                    companionWeight$default = RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null);
                } else {
                    companionWeight$default = Modifier.INSTANCE;
                }
                int i8 = ((i3 << 6) & 57344) | 3456;
                SmartSubwayThreeStationLabel(companionWeight$default, smartSubwayHorizontalCardContentBuildSmartSubwayHorizontalCardContent2.getPreviousStation(), "上一站", false, z5, zIsUsSmartSubwayCity, composerStartRestartGroup, i8, 0);
                companion2 = Modifier.INSTANCE;
                if (zIsUsSmartSubwayCity) {
                    companionWeight$default2 = RowScope.weight$default(rowScopeInstance, companion2, 1.0f, false, 2, null);
                    rowScopeInstance = rowScopeInstance;
                } else {
                    companionWeight$default2 = companion2;
                }
                SmartSubwayThreeStationLabel(companionWeight$default2, smartSubwayHorizontalCardContentBuildSmartSubwayHorizontalCardContent2.getCurrentStation(), "当前站", true, z5, zIsUsSmartSubwayCity, composerStartRestartGroup, i8, 0);
                companion3 = Modifier.INSTANCE;
                if (zIsUsSmartSubwayCity) {
                    companionWeight$default3 = RowScope.weight$default(rowScopeInstance, companion3, 1.0f, false, 2, null);
                } else {
                    companionWeight$default3 = companion3;
                }
                SmartSubwayThreeStationLabel(companionWeight$default3, smartSubwayHorizontalCardContentBuildSmartSubwayHorizontalCardContent2.getNextStation(), "下一站", false, z5, zIsUsSmartSubwayCity, composerStartRestartGroup, i8, 0);
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
                modifier3 = companion;
                z4 = z5;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.tickets.SmartSubwayRealtimeKt$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return SmartSubwayRealtimeKt.SmartSubwayRouteCanvas$lambda$40(state, modifier3, z4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 48;
        modifier2 = modifier;
        i4 = i2 & 4;
        if (i4 != 0) {
            if ((i & 384) == 0) {
                z2 = z;
                if (composerStartRestartGroup.changed(z2)) {
                    i5 = 256;
                } else {
                    i5 = 128;
                }
                i3 |= i5;
            }
            if ((i3 & 147) != 146) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                z4 = z2;
            } else {
                if (i6 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i4 != 0) {
                    z5 = false;
                } else {
                    z5 = z2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1267079049, i3, -1, "com.example.tickets.SmartSubwayRouteCanvas (SmartSubwayRealtime.kt:524)");
                }
                SmartSubwayHorizontalCardContent smartSubwayHorizontalCardContentBuildSmartSubwayHorizontalCardContent3 = buildSmartSubwayHorizontalCardContent(state);
                zIsUsSmartSubwayCity = isUsSmartSubwayCity(state.getCityId());
                if (z5) {
                    f = 48.0f;
                } else {
                    f = 58.0f;
                }
                float fM8748constructorimpl4 = Dp.m8748constructorimpl(f);
                if (zIsUsSmartSubwayCity) {
                    if (z5) {
                        f4 = 104.0f;
                    } else {
                        f4 = 120.0f;
                    }
                    fM8748constructorimpl = Dp.m8748constructorimpl(f4);
                } else {
                    if (z5) {
                        f2 = 88.0f;
                    } else {
                        f2 = 106.0f;
                    }
                    fM8748constructorimpl = Dp.m8748constructorimpl(f2);
                }
                Modifier modifierM1476height3ABfNKs3 = SizeKt.m1476height3ABfNKs(companion, fM8748constructorimpl);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
                int iHashCode5 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap5 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier5 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1476height3ABfNKs3);
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
                Updater.m4945setimpl(composerM4937constructorimpl5, measurePolicyMaybeCachedBoxMeasurePolicy3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m4945setimpl(composerM4937constructorimpl5, currentCompositionLocalMap5, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Updater.m4945setimpl(composerM4937constructorimpl5, Integer.valueOf(iHashCode5), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                Updater.m4943reconcileimpl(composerM4937constructorimpl5, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                Updater.m4945setimpl(composerM4937constructorimpl5, modifierMaterializeModifier5, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance3 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -761250450, "C540@19993L175,535@19812L356,547@20177L1209:SmartSubwayRealtime.kt#n9ob9m");
                Modifier modifierFillMaxWidth$default3 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                if (z5) {
                    f3 = 38.0f;
                } else {
                    f3 = 46.0f;
                }
                Modifier modifierAlign3 = boxScopeInstance3.align(SizeKt.m1476height3ABfNKs(modifierFillMaxWidth$default3, Dp.m8748constructorimpl(f3)), Alignment.INSTANCE.getTopCenter());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -855836066, "CC(remember):SmartSubwayRealtime.kt#9igjgp");
                boolean zChangedInstance3 = composerStartRestartGroup.changedInstance(state);
                if ((i3 & 896) == 256) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                z7 = zChangedInstance3 | z6;
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!z7) {
                    objRememberedValue = new Function1() { // from class: com.example.tickets.SmartSubwayRealtimeKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return SmartSubwayRealtimeKt.SmartSubwayRouteCanvas$lambda$39$lambda$37$lambda$36(state, z5, (DrawScope) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = new Function1() { // from class: com.example.tickets.SmartSubwayRealtimeKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return SmartSubwayRealtimeKt.SmartSubwayRouteCanvas$lambda$39$lambda$37$lambda$36(state, z5, (DrawScope) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                CanvasKt.Canvas(modifierAlign3, (Function1) objRememberedValue, composerStartRestartGroup, 0);
                Modifier modifierM1427paddingqDBjuR0$default3 = PaddingKt.m1427paddingqDBjuR0$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), 0.0f, fM8748constructorimpl4, 0.0f, 0.0f, 13, null);
                Arrangement.HorizontalOrVertical spaceBetween3 = Arrangement.INSTANCE.getSpaceBetween();
                Alignment.Vertical top3 = Alignment.INSTANCE.getTop();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                MeasurePolicy measurePolicyRowMeasurePolicy3 = RowKt.rowMeasurePolicy(spaceBetween3, top3, composerStartRestartGroup, 54);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
                int iHashCode6 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap6 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier6 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1427paddingqDBjuR0$default3);
                constructor2 = ComposeUiNode.INSTANCE.getConstructor();
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
                Composer composerM4937constructorimpl6 = Updater.m4937constructorimpl(composerStartRestartGroup);
                Updater.m4945setimpl(composerM4937constructorimpl6, measurePolicyRowMeasurePolicy3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m4945setimpl(composerM4937constructorimpl6, currentCompositionLocalMap6, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Updater.m4945setimpl(composerM4937constructorimpl6, Integer.valueOf(iHashCode6), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                Updater.m4943reconcileimpl(composerM4937constructorimpl6, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                Updater.m4945setimpl(composerM4937constructorimpl6, modifierMaterializeModifier6, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                rowScopeInstance = RowScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1553530932, "C554@20420L312,562@20745L310,570@21068L308:SmartSubwayRealtime.kt#n9ob9m");
                if (zIsUsSmartSubwayCity) {
                    companionWeight$default = RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null);
                } else {
                    companionWeight$default = Modifier.INSTANCE;
                }
                int i9 = ((i3 << 6) & 57344) | 3456;
                SmartSubwayThreeStationLabel(companionWeight$default, smartSubwayHorizontalCardContentBuildSmartSubwayHorizontalCardContent3.getPreviousStation(), "上一站", false, z5, zIsUsSmartSubwayCity, composerStartRestartGroup, i9, 0);
                companion2 = Modifier.INSTANCE;
                if (zIsUsSmartSubwayCity) {
                    companionWeight$default2 = RowScope.weight$default(rowScopeInstance, companion2, 1.0f, false, 2, null);
                    rowScopeInstance = rowScopeInstance;
                } else {
                    companionWeight$default2 = companion2;
                }
                SmartSubwayThreeStationLabel(companionWeight$default2, smartSubwayHorizontalCardContentBuildSmartSubwayHorizontalCardContent3.getCurrentStation(), "当前站", true, z5, zIsUsSmartSubwayCity, composerStartRestartGroup, i9, 0);
                companion3 = Modifier.INSTANCE;
                if (zIsUsSmartSubwayCity) {
                    companionWeight$default3 = RowScope.weight$default(rowScopeInstance, companion3, 1.0f, false, 2, null);
                } else {
                    companionWeight$default3 = companion3;
                }
                SmartSubwayThreeStationLabel(companionWeight$default3, smartSubwayHorizontalCardContentBuildSmartSubwayHorizontalCardContent3.getNextStation(), "下一站", false, z5, zIsUsSmartSubwayCity, composerStartRestartGroup, i9, 0);
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
                modifier3 = companion;
                z4 = z5;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.tickets.SmartSubwayRealtimeKt$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return SmartSubwayRealtimeKt.SmartSubwayRouteCanvas$lambda$40(state, modifier3, z4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 384;
        z2 = z;
        if ((i3 & 147) != 146) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
            z4 = z2;
        } else {
            if (i6 != 0) {
                companion = Modifier.INSTANCE;
            } else {
                companion = modifier2;
            }
            if (i4 != 0) {
                z5 = false;
            } else {
                z5 = z2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1267079049, i3, -1, "com.example.tickets.SmartSubwayRouteCanvas (SmartSubwayRealtime.kt:524)");
            }
            SmartSubwayHorizontalCardContent smartSubwayHorizontalCardContentBuildSmartSubwayHorizontalCardContent4 = buildSmartSubwayHorizontalCardContent(state);
            zIsUsSmartSubwayCity = isUsSmartSubwayCity(state.getCityId());
            if (z5) {
                f = 48.0f;
            } else {
                f = 58.0f;
            }
            float fM8748constructorimpl5 = Dp.m8748constructorimpl(f);
            if (zIsUsSmartSubwayCity) {
                if (z5) {
                    f4 = 104.0f;
                } else {
                    f4 = 120.0f;
                }
                fM8748constructorimpl = Dp.m8748constructorimpl(f4);
            } else {
                if (z5) {
                    f2 = 88.0f;
                } else {
                    f2 = 106.0f;
                }
                fM8748constructorimpl = Dp.m8748constructorimpl(f2);
            }
            Modifier modifierM1476height3ABfNKs4 = SizeKt.m1476height3ABfNKs(companion, fM8748constructorimpl);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy4 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
            int iHashCode7 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap7 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier7 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1476height3ABfNKs4);
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
            Updater.m4945setimpl(composerM4937constructorimpl7, measurePolicyMaybeCachedBoxMeasurePolicy4, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m4945setimpl(composerM4937constructorimpl7, currentCompositionLocalMap7, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m4945setimpl(composerM4937constructorimpl7, Integer.valueOf(iHashCode7), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m4943reconcileimpl(composerM4937constructorimpl7, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m4945setimpl(composerM4937constructorimpl7, modifierMaterializeModifier7, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance4 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -761250450, "C540@19993L175,535@19812L356,547@20177L1209:SmartSubwayRealtime.kt#n9ob9m");
            Modifier modifierFillMaxWidth$default4 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
            if (z5) {
                f3 = 38.0f;
            } else {
                f3 = 46.0f;
            }
            Modifier modifierAlign4 = boxScopeInstance4.align(SizeKt.m1476height3ABfNKs(modifierFillMaxWidth$default4, Dp.m8748constructorimpl(f3)), Alignment.INSTANCE.getTopCenter());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -855836066, "CC(remember):SmartSubwayRealtime.kt#9igjgp");
            boolean zChangedInstance4 = composerStartRestartGroup.changedInstance(state);
            if ((i3 & 896) == 256) {
                z6 = true;
            } else {
                z6 = false;
            }
            z7 = zChangedInstance4 | z6;
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (!z7) {
                objRememberedValue = new Function1() { // from class: com.example.tickets.SmartSubwayRealtimeKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return SmartSubwayRealtimeKt.SmartSubwayRouteCanvas$lambda$39$lambda$37$lambda$36(state, z5, (DrawScope) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            } else {
                objRememberedValue = new Function1() { // from class: com.example.tickets.SmartSubwayRealtimeKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return SmartSubwayRealtimeKt.SmartSubwayRouteCanvas$lambda$39$lambda$37$lambda$36(state, z5, (DrawScope) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            CanvasKt.Canvas(modifierAlign4, (Function1) objRememberedValue, composerStartRestartGroup, 0);
            Modifier modifierM1427paddingqDBjuR0$default4 = PaddingKt.m1427paddingqDBjuR0$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), 0.0f, fM8748constructorimpl5, 0.0f, 0.0f, 13, null);
            Arrangement.HorizontalOrVertical spaceBetween4 = Arrangement.INSTANCE.getSpaceBetween();
            Alignment.Vertical top4 = Alignment.INSTANCE.getTop();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy4 = RowKt.rowMeasurePolicy(spaceBetween4, top4, composerStartRestartGroup, 54);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
            int iHashCode8 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap8 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier8 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1427paddingqDBjuR0$default4);
            constructor2 = ComposeUiNode.INSTANCE.getConstructor();
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
            Composer composerM4937constructorimpl8 = Updater.m4937constructorimpl(composerStartRestartGroup);
            Updater.m4945setimpl(composerM4937constructorimpl8, measurePolicyRowMeasurePolicy4, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m4945setimpl(composerM4937constructorimpl8, currentCompositionLocalMap8, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m4945setimpl(composerM4937constructorimpl8, Integer.valueOf(iHashCode8), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m4943reconcileimpl(composerM4937constructorimpl8, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m4945setimpl(composerM4937constructorimpl8, modifierMaterializeModifier8, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            rowScopeInstance = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1553530932, "C554@20420L312,562@20745L310,570@21068L308:SmartSubwayRealtime.kt#n9ob9m");
            if (zIsUsSmartSubwayCity) {
                companionWeight$default = RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null);
            } else {
                companionWeight$default = Modifier.INSTANCE;
            }
            int i10 = ((i3 << 6) & 57344) | 3456;
            SmartSubwayThreeStationLabel(companionWeight$default, smartSubwayHorizontalCardContentBuildSmartSubwayHorizontalCardContent4.getPreviousStation(), "上一站", false, z5, zIsUsSmartSubwayCity, composerStartRestartGroup, i10, 0);
            companion2 = Modifier.INSTANCE;
            if (zIsUsSmartSubwayCity) {
                companionWeight$default2 = RowScope.weight$default(rowScopeInstance, companion2, 1.0f, false, 2, null);
                rowScopeInstance = rowScopeInstance;
            } else {
                companionWeight$default2 = companion2;
            }
            SmartSubwayThreeStationLabel(companionWeight$default2, smartSubwayHorizontalCardContentBuildSmartSubwayHorizontalCardContent4.getCurrentStation(), "当前站", true, z5, zIsUsSmartSubwayCity, composerStartRestartGroup, i10, 0);
            companion3 = Modifier.INSTANCE;
            if (zIsUsSmartSubwayCity) {
                companionWeight$default3 = RowScope.weight$default(rowScopeInstance, companion3, 1.0f, false, 2, null);
            } else {
                companionWeight$default3 = companion3;
            }
            SmartSubwayThreeStationLabel(companionWeight$default3, smartSubwayHorizontalCardContentBuildSmartSubwayHorizontalCardContent4.getNextStation(), "下一站", false, z5, zIsUsSmartSubwayCity, composerStartRestartGroup, i10, 0);
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
            modifier3 = companion;
            z4 = z5;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.tickets.SmartSubwayRealtimeKt$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SmartSubwayRealtimeKt.SmartSubwayRouteCanvas$lambda$40(state, modifier3, z4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    static final Unit SmartSubwayRouteCanvas$lambda$39$lambda$37$lambda$36(SmartSubwayRealtimeState smartSubwayRealtimeState, boolean z, DrawScope Canvas) {
        Intrinsics.checkNotNullParameter(Canvas, "$this$Canvas");
        drawSmartSubwayHorizontalRoute(Canvas, smartSubwayRealtimeState, Float.intBitsToFloat((int) (Canvas.mo6437getSizeNHjbRc() & 4294967295L)) * 0.55f, z);
        return Unit.INSTANCE;
    }

    private static final void SmartSubwayThreeStationLabel(Modifier modifier, final String str, final String str2, final boolean z, final boolean z2, final boolean z3, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        Composer composer2;
        final Modifier modifier3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Function2<? super Composer, ? super Integer, Unit> function2;
        long sp;
        long sp2;
        long sp3;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1266198614);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(SmartSubwayThreeStationLabel)N(modifier,title,caption,active,compact,usLongNameLayout)622@22812L1331:SmartSubwayRealtime.kt#n9ob9m");
        int i4 = i2 & 1;
        if (i4 != 0) {
            i3 = i | 6;
            modifier2 = modifier;
        } else if ((i & 6) == 0) {
            modifier2 = modifier;
            i3 = (composerStartRestartGroup.changed(modifier2) ? 4 : 2) | i;
        } else {
            modifier2 = modifier;
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changed(str) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changed(str2) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i3 |= composerStartRestartGroup.changed(z) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i3 |= composerStartRestartGroup.changed(z2) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i3 |= composerStartRestartGroup.changed(z3) ? 131072 : 65536;
        }
        if (!composerStartRestartGroup.shouldExecute((74899 & i3) != 74898, i3 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            modifier3 = modifier2;
        } else {
            Modifier.Companion companion = i4 != 0 ? Modifier.INSTANCE : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1266198614, i3, -1, "com.example.tickets.SmartSubwayThreeStationLabel (SmartSubwayRealtime.kt:590)");
            }
            if (!z3) {
                composerStartRestartGroup.startReplaceGroup(1375116828);
                ComposerKt.sourceInformation(composerStartRestartGroup, "592@21639L1085");
                final Modifier modifier4 = companion;
                Modifier modifierFillMaxWidth = SizeKt.fillMaxWidth(Modifier.INSTANCE, 0.24f);
                Alignment.Horizontal centerHorizontally = Alignment.INSTANCE.getCenterHorizontally();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), centerHorizontally, composerStartRestartGroup, 48);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
                int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxWidth);
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
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1776506496, "C596@21776L585,609@22374L340:SmartSubwayRealtime.kt#n9ob9m");
                Modifier modifierM1476height3ABfNKs = SizeKt.m1476height3ABfNKs(Modifier.INSTANCE, Dp.m8748constructorimpl(z2 ? 24.0f : 30.0f));
                Alignment center = Alignment.INSTANCE.getCenter();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
                int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1476height3ABfNKs);
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
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 719458318, "C600@21929L418:SmartSubwayRealtime.kt#n9ob9m");
                long jM5875getWhite0d7_KjU = z ? Color.INSTANCE.m5875getWhite0d7_KjU() : ColorKt.Color(4289770168L);
                if (z) {
                    sp3 = z2 ? TextUnitKt.getSp(16) : TextUnitKt.getSp(21);
                } else {
                    sp3 = z2 ? TextUnitKt.getSp(13) : TextUnitKt.getSp(17);
                }
                long j = sp3;
                FontWeight.Companion companion2 = FontWeight.INSTANCE;
                int i5 = i3;
                TextKt.m3661TextNvy7gAk(str, null, jM5875getWhite0d7_KjU, null, j, null, z ? companion2.getBold() : companion2.getMedium(), null, 0L, null, TextAlign.m8619boximpl(TextAlign.INSTANCE.m8626getCentere0LSkKk()), 0L, 0, false, 1, 0, null, null, composerStartRestartGroup, (i3 >> 3) & 14, 24576, 244650);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                long jM5875getWhite0d7_KjU2 = z ? Color.INSTANCE.m5875getWhite0d7_KjU() : ColorKt.Color(4286020224L);
                long sp4 = TextUnitKt.getSp(z2 ? 9 : 10);
                FontWeight.Companion companion3 = FontWeight.INSTANCE;
                TextKt.m3661TextNvy7gAk(str2, null, jM5875getWhite0d7_KjU2, null, sp4, null, z ? companion3.getSemiBold() : companion3.getNormal(), null, 0L, null, TextAlign.m8619boximpl(TextAlign.INSTANCE.m8626getCentere0LSkKk()), 0L, 0, false, 1, 0, null, null, composerStartRestartGroup, (i5 >> 6) & 14, 24576, 244650);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                } else {
                    function2 = new Function2() { // from class: com.example.tickets.SmartSubwayRealtimeKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return SmartSubwayRealtimeKt.SmartSubwayThreeStationLabel$lambda$43(modifier4, str, str2, z, z2, z3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    };
                }
            } else {
                int i6 = i3;
                composerStartRestartGroup.startReplaceGroup(1353625272);
                composerStartRestartGroup.endReplaceGroup();
                String smartSubwayUsStationName = formatSmartSubwayUsStationName(str);
                Alignment.Horizontal centerHorizontally2 = Alignment.INSTANCE.getCenterHorizontally();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                MeasurePolicy measurePolicyColumnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), centerHorizontally2, composerStartRestartGroup, 48);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
                int iHashCode3 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion);
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
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 950815154, "C626@22924L840,651@23773L364:SmartSubwayRealtime.kt#n9ob9m");
                Modifier modifierM1476height3ABfNKs2 = SizeKt.m1476height3ABfNKs(Modifier.INSTANCE, Dp.m8748constructorimpl(z2 ? 40.0f : 44.0f));
                Alignment center2 = Alignment.INSTANCE.getCenter();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(center2, false);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
                int iHashCode4 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap4 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1476height3ABfNKs2);
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
                Updater.m4945setimpl(composerM4937constructorimpl4, measurePolicyMaybeCachedBoxMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m4945setimpl(composerM4937constructorimpl4, currentCompositionLocalMap4, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Updater.m4945setimpl(composerM4937constructorimpl4, Integer.valueOf(iHashCode4), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                Updater.m4943reconcileimpl(composerM4937constructorimpl4, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                Updater.m4945setimpl(composerM4937constructorimpl4, modifierMaterializeModifier4, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -45912631, "C632@23102L652:SmartSubwayRealtime.kt#n9ob9m");
                long jM5875getWhite0d7_KjU3 = z ? Color.INSTANCE.m5875getWhite0d7_KjU() : ColorKt.Color(4293520109L);
                if (z2) {
                    sp = z ? TextUnitKt.getSp(16) : TextUnitKt.getSp(13);
                } else {
                    sp = z ? TextUnitKt.getSp(21) : TextUnitKt.getSp(17);
                }
                if (z2) {
                    sp2 = z ? TextUnitKt.getSp(17) : TextUnitKt.getSp(14);
                } else {
                    sp2 = TextUnitKt.getSp(z ? 22 : 18);
                }
                Modifier modifier5 = companion;
                composer2 = composerStartRestartGroup;
                TextKt.m3661TextNvy7gAk(smartSubwayUsStationName, null, jM5875getWhite0d7_KjU3, null, sp, null, FontWeight.INSTANCE.getBold(), null, 0L, null, TextAlign.m8619boximpl(TextAlign.INSTANCE.m8626getCentere0LSkKk()), sp2, 0, true, 2, 0, null, null, composer2, 1572864, 27648, 234410);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                long jM5875getWhite0d7_KjU4 = z ? Color.INSTANCE.m5875getWhite0d7_KjU() : ColorKt.Color(4288125858L);
                long sp5 = TextUnitKt.getSp(z2 ? 9 : 10);
                long sp6 = TextUnitKt.getSp(z2 ? 11 : 12);
                FontWeight.Companion companion4 = FontWeight.INSTANCE;
                TextKt.m3661TextNvy7gAk(str2, null, jM5875getWhite0d7_KjU4, null, sp5, null, z ? companion4.getBold() : companion4.getNormal(), null, 0L, null, TextAlign.m8619boximpl(TextAlign.INSTANCE.m8626getCentere0LSkKk()), sp6, 0, false, 1, 0, null, null, composer2, (i6 >> 6) & 14, 24576, 242602);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier5;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(function2);
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            function2 = new Function2() { // from class: com.example.tickets.SmartSubwayRealtimeKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SmartSubwayRealtimeKt.SmartSubwayThreeStationLabel$lambda$46(modifier3, str, str2, z, z2, z3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            };
            scopeUpdateScopeEndRestartGroup.updateScope(function2);
        }
    }

    private static final void drawSmartSubwayHorizontalRoute(DrawScope drawScope, SmartSubwayRealtimeState smartSubwayRealtimeState, float f, boolean z) {
        float fM8748constructorimpl;
        List listListOf = CollectionsKt.listOf((Object[]) new Float[]{Float.valueOf(0.12f), Float.valueOf(0.5f), Float.valueOf(0.88f)});
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listListOf, 10));
        Iterator it = listListOf.iterator();
        while (it.hasNext()) {
            arrayList.add(Float.valueOf(((Number) it.next()).floatValue() * Float.intBitsToFloat((int) (drawScope.mo6437getSizeNHjbRc() >> 32))));
        }
        ArrayList arrayList2 = arrayList;
        float f2 = drawScope.mo803toPx0680j_4(z ? Dp.m8748constructorimpl(8.0f) : Dp.m8748constructorimpl(9.0f));
        if (z) {
            fM8748constructorimpl = Dp.m8748constructorimpl(4.0f);
        } else {
            fM8748constructorimpl = Dp.m8748constructorimpl(4.5f);
        }
        float f3 = drawScope.mo803toPx0680j_4(fM8748constructorimpl);
        float f4 = drawScope.mo803toPx0680j_4(z ? Dp.m8748constructorimpl(8.0f) : Dp.m8748constructorimpl(9.0f));
        long jColor = isAfterTransfer(smartSubwayRealtimeState) ? ColorKt.Color(smartSubwayRealtimeState.getSecondaryLineColor()) : ColorKt.Color(smartSubwayRealtimeState.getPrimaryLineColor());
        long jColor2 = smartSubwayRealtimeState.isTransferRequired() ? ColorKt.Color(smartSubwayRealtimeState.getSecondaryLineColor()) : ColorKt.Color(smartSubwayRealtimeState.getPrimaryLineColor());
        long jColor3 = ColorKt.Color(4282598988L);
        long jM5559constructorimpl = Offset.m5559constructorimpl((((long) Float.floatToRawIntBits(((Number) arrayList2.get(0)).floatValue() + f3)) << 32) | (((long) Float.floatToRawIntBits(f)) & 4294967295L));
        long jFloatToRawIntBits = Float.floatToRawIntBits(((Number) arrayList2.get(1)).floatValue() - f4);
        long j = jColor;
        DrawScope.m6423drawLineNGM6Ib0$default(drawScope, j, jM5559constructorimpl, Offset.m5559constructorimpl((jFloatToRawIntBits << 32) | (((long) Float.floatToRawIntBits(f)) & 4294967295L)), f2, StrokeCap.INSTANCE.m6236getRoundKaPHkGw(), null, 0.0f, null, 0, WindowSizeClass.HEIGHT_DP_MEDIUM_LOWER_BOUND, null);
        DrawScope.m6423drawLineNGM6Ib0$default(drawScope, jColor3, Offset.m5559constructorimpl((((long) Float.floatToRawIntBits(((Number) arrayList2.get(1)).floatValue() + f4)) << 32) | (((long) Float.floatToRawIntBits(f)) & 4294967295L)), Offset.m5559constructorimpl((((long) Float.floatToRawIntBits(((Number) arrayList2.get(2)).floatValue() - f3)) << 32) | (((long) Float.floatToRawIntBits(f)) & 4294967295L)), f2, StrokeCap.INSTANCE.m6236getRoundKaPHkGw(), null, 0.0f, null, 0, WindowSizeClass.HEIGHT_DP_MEDIUM_LOWER_BOUND, null);
        DrawScope.m6418drawCircleVaOC9Bg$default(drawScope, ColorKt.Color(4279967008L), f3 + drawScope.mo803toPx0680j_4(Dp.m8748constructorimpl(2.0f)), Offset.m5559constructorimpl((((long) Float.floatToRawIntBits(((Number) arrayList2.get(0)).floatValue())) << 32) | (((long) Float.floatToRawIntBits(f)) & 4294967295L)), 0.0f, null, null, 0, 120, null);
        DrawScope.m6418drawCircleVaOC9Bg$default(drawScope, ColorKt.Color(4288322980L), f3, Offset.m5559constructorimpl((((long) Float.floatToRawIntBits(((Number) arrayList2.get(0)).floatValue())) << 32) | (((long) Float.floatToRawIntBits(f)) & 4294967295L)), 0.0f, null, null, 0, 120, null);
        DrawScope.m6418drawCircleVaOC9Bg$default(drawScope, ColorKt.Color(4279967008L), drawScope.mo803toPx0680j_4(Dp.m8748constructorimpl(2.0f)) + f3, Offset.m5559constructorimpl((((long) Float.floatToRawIntBits(((Number) arrayList2.get(2)).floatValue())) << 32) | (((long) Float.floatToRawIntBits(f)) & 4294967295L)), 0.0f, null, null, 0, 120, null);
        DrawScope.m6418drawCircleVaOC9Bg$default(drawScope, jColor2, f3, Offset.m5559constructorimpl((((long) Float.floatToRawIntBits(((Number) arrayList2.get(2)).floatValue())) << 32) | (((long) Float.floatToRawIntBits(f)) & 4294967295L)), 0.0f, null, null, 0, 120, null);
        DrawScope.m6418drawCircleVaOC9Bg$default(drawScope, Color.INSTANCE.m5875getWhite0d7_KjU(), f4, Offset.m5559constructorimpl((((long) Float.floatToRawIntBits(((Number) arrayList2.get(1)).floatValue())) << 32) | (((long) Float.floatToRawIntBits(f)) & 4294967295L)), 0.0f, null, null, 0, 120, null);
        DrawScope.m6418drawCircleVaOC9Bg$default(drawScope, j, f3, Offset.m5559constructorimpl((((long) Float.floatToRawIntBits(((Number) arrayList2.get(1)).floatValue())) << 32) | (((long) Float.floatToRawIntBits(f)) & 4294967295L)), 0.0f, null, null, 0, 120, null);
    }

    public static final void SmartSubwayRouteTimeline(final SmartSubwayRealtimeState state, final Modifier modifier, Composer composer, final int i, final int i2) {
        int i3;
        long jColor;
        Intrinsics.checkNotNullParameter(state, "state");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1453272676);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(SmartSubwayRouteTimeline)N(state,modifier)743@26543L1646:SmartSubwayRealtime.kt#n9ob9m");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(state) ? 4 : 2) | i;
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
                ComposerKt.traceEventStart(-1453272676, i3, -1, "com.example.tickets.SmartSubwayRouteTimeline (SmartSubwayRealtime.kt:742)");
            }
            Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(modifier, 0.0f, 1, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxWidth$default);
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -248161428, "C746@26610L179,764@27382L186,775@27746L40,776@27795L165,782@27969L40,783@28018L165:SmartSubwayRealtime.kt#n9ob9m");
            m9307SmartSubwayVerticalNodeBx497Mc(state.getOrigin(), "出发站", false, ColorKt.Color(state.getPrimaryLineColor()), composerStartRestartGroup, 432);
            if (state.isTransferRequired() && !StringsKt.isBlank(state.getTransferStation())) {
                composerStartRestartGroup.startReplaceGroup(-247943282);
                ComposerKt.sourceInformation(composerStartRestartGroup, "753@26880L59,754@26952L248,760@27213L61");
                m9306SmartSubwayVerticalConnectorek8zF_U(ColorKt.Color(state.getPrimaryLineColor()), composerStartRestartGroup, 0);
                m9307SmartSubwayVerticalNodeBx497Mc(state.getTransferStation(), "换乘站", Intrinsics.areEqual(state.getCurrentStation(), state.getTransferStation()), ColorKt.Color(state.getPrimaryLineColor()), composerStartRestartGroup, 48);
                m9306SmartSubwayVerticalConnectorek8zF_U(ColorKt.Color(state.getSecondaryLineColor()), composerStartRestartGroup, 0);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(-247533059);
                ComposerKt.sourceInformation(composerStartRestartGroup, "762@27304L59");
                m9306SmartSubwayVerticalConnectorek8zF_U(ColorKt.Color(state.getPrimaryLineColor()), composerStartRestartGroup, 0);
                composerStartRestartGroup.endReplaceGroup();
            }
            m9307SmartSubwayVerticalNodeBx497Mc(state.getCurrentStation(), "当前站", true, ColorKt.Color(state.getPrimaryLineColor()), composerStartRestartGroup, 432);
            if (isAfterTransfer(state)) {
                jColor = ColorKt.Color(state.getSecondaryLineColor());
            } else {
                jColor = ColorKt.Color(state.getPrimaryLineColor());
            }
            long j = jColor;
            m9306SmartSubwayVerticalConnectorek8zF_U(j, composerStartRestartGroup, 0);
            m9307SmartSubwayVerticalNodeBx497Mc(state.getNextStation(), "下一站", false, j, composerStartRestartGroup, 432);
            m9306SmartSubwayVerticalConnectorek8zF_U(j, composerStartRestartGroup, 0);
            m9307SmartSubwayVerticalNodeBx497Mc(state.getDestination(), "终点站", false, j, composerStartRestartGroup, 432);
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.tickets.SmartSubwayRealtimeKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SmartSubwayRealtimeKt.SmartSubwayRouteTimeline$lambda$49(state, modifier, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: renamed from: SmartSubwayVerticalNode-Bx497Mc, reason: not valid java name */
    private static final void m9307SmartSubwayVerticalNodeBx497Mc(final String str, final String str2, final boolean z, final long j, Composer composer, final int i) {
        int i2;
        String str3;
        Composer composer2;
        String str4;
        int i3;
        Composer composerStartRestartGroup = composer.startRestartGroup(-945421776);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(SmartSubwayVerticalNode)N(title,caption,active,lineColor:c#ui.graphics.Color)799@28332L1461:SmartSubwayRealtime.kt#n9ob9m");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(str) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            str3 = str2;
            i2 |= composerStartRestartGroup.changed(str3) ? 32 : 16;
        } else {
            str3 = str2;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changed(z) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= composerStartRestartGroup.changed(j) ? 2048 : 1024;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 1171) != 1170, i2 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-945421776, i2, -1, "com.example.tickets.SmartSubwayVerticalNode (SmartSubwayRealtime.kt:798)");
            }
            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Modifier.Companion companion = Modifier.INSTANCE;
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, composerStartRestartGroup, 48);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion);
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -559681292, "C802@28408L830,828@29247L29,829@29285L502:SmartSubwayRealtime.kt#n9ob9m");
            Modifier modifierM1490size3ABfNKs = SizeKt.m1490size3ABfNKs(Modifier.INSTANCE, z ? Dp.m8748constructorimpl(18.0f) : Dp.m8748constructorimpl(12.0f));
            Alignment center = Alignment.INSTANCE.getCenter();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
            int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1490size3ABfNKs);
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -48983494, "C:SmartSubwayRealtime.kt#n9ob9m");
            if (z) {
                composerStartRestartGroup.startReplaceGroup(-48985603);
                ComposerKt.sourceInformation(composerStartRestartGroup, "807@28583L191");
                BoxKt.Box(BackgroundKt.m648backgroundbw27NRU$default(ClipKt.clip(SizeKt.m1490size3ABfNKs(Modifier.INSTANCE, Dp.m8748constructorimpl(18.0f)), RoundedCornerShapeKt.getCircleShape()), Color.INSTANCE.m5875getWhite0d7_KjU(), null, 2, null), composerStartRestartGroup, 0);
                composerStartRestartGroup.endReplaceGroup();
                str4 = "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh";
                i3 = -553112988;
            } else {
                composerStartRestartGroup.startReplaceGroup(-48751894);
                ComposerKt.sourceInformation(composerStartRestartGroup, "814@28812L197,820@29026L188");
                BoxKt.Box(BackgroundKt.m648backgroundbw27NRU$default(ClipKt.clip(SizeKt.m1490size3ABfNKs(Modifier.INSTANCE, Dp.m8748constructorimpl(12.0f)), RoundedCornerShapeKt.getCircleShape()), ColorKt.Color(4280559146L), null, 2, null), composerStartRestartGroup, 0);
                str4 = "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh";
                i3 = -553112988;
                BoxKt.Box(BackgroundKt.m648backgroundbw27NRU$default(ClipKt.clip(SizeKt.m1490size3ABfNKs(Modifier.INSTANCE, Dp.m8748constructorimpl(7.0f)), RoundedCornerShapeKt.getCircleShape()), j, null, 2, null), composerStartRestartGroup, 0);
                composerStartRestartGroup.endReplaceGroup();
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            SpacerKt.Spacer(SizeKt.m1495width3ABfNKs(Modifier.INSTANCE, Dp.m8748constructorimpl(12.0f)), composerStartRestartGroup, 6);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Modifier.Companion companion2 = Modifier.INSTANCE;
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, str4);
            int iHashCode3 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion2);
            Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, i3, "CC(ReusableComposeNode)N(factory,update,content)410@16216L9:Composables.kt#9igjgp");
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 514627062, "C830@29306L260,836@29579L29,837@29621L156:SmartSubwayRealtime.kt#n9ob9m");
            long jM5875getWhite0d7_KjU = z ? Color.INSTANCE.m5875getWhite0d7_KjU() : ColorKt.Color(4291875285L);
            long sp = z ? TextUnitKt.getSp(15) : TextUnitKt.getSp(14);
            FontWeight.Companion companion3 = FontWeight.INSTANCE;
            TextKt.m3661TextNvy7gAk(str, null, jM5875getWhite0d7_KjU, null, sp, null, z ? companion3.getMedium() : companion3.getNormal(), null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composerStartRestartGroup, i2 & 14, 0, 262058);
            SpacerKt.Spacer(SizeKt.m1476height3ABfNKs(Modifier.INSTANCE, Dp.m8748constructorimpl(2.0f)), composerStartRestartGroup, 6);
            composer2 = composerStartRestartGroup;
            TextKt.m3661TextNvy7gAk(str3, null, z ? Color.INSTANCE.m5875getWhite0d7_KjU() : ColorKt.Color(4286020224L), null, TextUnitKt.getSp(11), null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer2, (14 & (i2 >> 3)) | 24576, 0, 262122);
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.tickets.SmartSubwayRealtimeKt$$ExternalSyntheticLambda8
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SmartSubwayRealtimeKt.SmartSubwayVerticalNode_Bx497Mc$lambda$53(str, str2, z, j, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: renamed from: SmartSubwayVerticalConnector-ek8zF_U, reason: not valid java name */
    private static final void m9306SmartSubwayVerticalConnectorek8zF_U(long j, Composer composer, final int i) {
        int i2;
        final long j2;
        Composer composerStartRestartGroup = composer.startRestartGroup(306984321);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(SmartSubwayVerticalConnector)N(color:c#ui.graphics.Color)848@29870L156:SmartSubwayRealtime.kt#n9ob9m");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(j) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            j2 = j;
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(306984321, i2, -1, "com.example.tickets.SmartSubwayVerticalConnector (SmartSubwayRealtime.kt:847)");
            }
            j2 = j;
            BoxKt.Box(BackgroundKt.m648backgroundbw27NRU$default(SizeKt.m1476height3ABfNKs(SizeKt.m1495width3ABfNKs(PaddingKt.m1427paddingqDBjuR0$default(Modifier.INSTANCE, Dp.m8748constructorimpl(8.0f), 0.0f, 0.0f, 0.0f, 14, null), Dp.m8748constructorimpl(6.0f)), Dp.m8748constructorimpl(26.0f)), j2, null, 2, null), composerStartRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.tickets.SmartSubwayRealtimeKt$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SmartSubwayRealtimeKt.SmartSubwayVerticalConnector_ek8zF_U$lambda$54(j2, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static /* synthetic */ Bitmap renderSmartSubwayRouteBitmap$default(SmartSubwayRealtimeState smartSubwayRealtimeState, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 1000;
        }
        if ((i3 & 4) != 0) {
            i2 = 260;
        }
        return renderSmartSubwayRouteBitmap(smartSubwayRealtimeState, i, i2);
    }

    public static final Bitmap renderSmartSubwayRouteBitmap(SmartSubwayRealtimeState state, int i, int i2) {
        Intrinsics.checkNotNullParameter(state, "state");
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(RangesKt.coerceAtLeast(i, 700), RangesKt.coerceAtLeast(i2, 240), Bitmap.Config.ARGB_8888);
        Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(...)");
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        boolean z = false;
        canvas.drawColor(0);
        float width = bitmapCreateBitmap.getWidth();
        float height = bitmapCreateBitmap.getHeight();
        float f = height * 0.3f;
        float[] fArr = {0.1f * width, 0.5f * width, width * 0.9f};
        int secondaryLineColor = isAfterTransfer(state) ? state.getSecondaryLineColor() : state.getPrimaryLineColor();
        Paint paint = new Paint(1);
        paint.setStrokeWidth(18.0f);
        paint.setStrokeCap(Paint.Cap.BUTT);
        paint.setStyle(Paint.Style.STROKE);
        Paint paint2 = new Paint(1);
        paint2.setStyle(Paint.Style.FILL);
        Paint paint3 = new Paint(1);
        paint3.setColor(-1);
        paint3.setStyle(Paint.Style.STROKE);
        paint3.setStrokeWidth(7.0f);
        Paint paint4 = new Paint(1);
        paint4.setColor(-1);
        paint4.setTextSize(42.0f);
        paint4.setTypeface(Typeface.create("sans-serif-medium", 1));
        paint4.setTextAlign(Paint.Align.CENTER);
        Paint paint5 = new Paint(1);
        paint5.setColor(-1);
        paint5.setTextSize(52.0f);
        paint5.setTypeface(Typeface.create("sans-serif", 1));
        paint5.setTextAlign(Paint.Align.CENTER);
        Paint paint6 = new Paint(1);
        paint6.setColor(SmartSubwayNotificationSpec.INSTANCE.getSecondaryText());
        paint6.setTextSize(28.0f);
        paint6.setTypeface(Typeface.create("sans-serif", 0));
        paint6.setTextAlign(Paint.Align.CENTER);
        renderSmartSubwayRouteBitmap$segment(fArr, paint, secondaryLineColor, canvas, f, 0, 1);
        renderSmartSubwayRouteBitmap$segment(fArr, paint, secondaryLineColor, canvas, f, 1, 2);
        int i3 = 0;
        int i4 = 0;
        while (i3 < 3) {
            float f2 = fArr[i3];
            int i5 = i4 + 1;
            boolean z2 = z;
            if (i4 == 1) {
                canvas.drawCircle(f2, f, 34.0f, paint3);
                paint2.setColor(-1);
                canvas.drawCircle(f2, f, 25.0f, paint2);
            } else {
                paint2.setColor(android.graphics.Color.rgb(30, 33, 37));
                canvas.drawCircle(f2, f, 18.0f, paint2);
                paint2.setColor(android.graphics.Color.rgb(155, 158, 164));
                canvas.drawCircle(f2, f, 13.0f, paint2);
            }
            i3++;
            i4 = i5;
            z = z2;
        }
        boolean z3 = z;
        String previousStation = state.getPreviousStation();
        if (StringsKt.isBlank(previousStation) || StringsKt.equals(previousStation, state.getCurrentStation(), true)) {
            previousStation = null;
        }
        if (previousStation == null) {
            previousStation = "上一站";
        }
        String currentStation = state.getCurrentStation();
        if (StringsKt.isBlank(currentStation)) {
            currentStation = "当前站";
        }
        String str = currentStation;
        String nextStation = state.getNextStation();
        if (StringsKt.isBlank(nextStation)) {
            nextStation = "下一站";
        }
        float f3 = 0.67f * height;
        canvas.drawText(previousStation, fArr[z3 ? 1 : 0], f3, paint4);
        canvas.drawText(str, fArr[1], f3, paint5);
        canvas.drawText(nextStation, fArr[2], f3, paint4);
        float f4 = height * 0.9f;
        canvas.drawText("上一站", fArr[z3 ? 1 : 0], f4, paint6);
        canvas.drawText("当前站", fArr[1], f4, paint6);
        canvas.drawText("下一站", fArr[2], f4, paint6);
        return bitmapCreateBitmap;
    }

    private static final void renderSmartSubwayRouteBitmap$segment(float[] fArr, Paint paint, int i, Canvas canvas, float f, int i2, int i3) {
        float f2 = fArr[i2] + (i2 == 1 ? 28.0f : 25.0f);
        float f3 = fArr[i3] - (i3 != 1 ? 25.0f : 28.0f);
        if (f3 <= f2) {
            return;
        }
        paint.setColor(i);
        canvas.drawLine(f2, f, f3, f, paint);
    }

    public static final void applySmartSubwayRouteBitmap(RemoteViews remoteViews, int i, SmartSubwayRealtimeState state) {
        Intrinsics.checkNotNullParameter(remoteViews, "remoteViews");
        Intrinsics.checkNotNullParameter(state, "state");
        remoteViews.setImageViewBitmap(i, renderSmartSubwayRouteBitmap$default(state, 0, 0, 6, null));
        remoteViews.setViewVisibility(i, 0);
    }
}
