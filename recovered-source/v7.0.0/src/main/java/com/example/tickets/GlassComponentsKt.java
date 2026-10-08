package com.example.tickets;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.interaction.PressInteractionKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.style.StylePropertiesKt;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.AddKt;
import androidx.compose.material.icons.rounded.ConfirmationNumberKt;
import androidx.compose.material.icons.rounded.SettingsKt;
import androidx.compose.material3.IconButtonKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
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
import androidx.compose.ui.draw.BlurKt;
import androidx.compose.ui.draw.CacheDrawScope;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.draw.DrawResult;
import androidx.compose.ui.draw.ShadowKt;
import androidx.compose.ui.geometry.CornerRadius;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.TransformOrigin;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.TextUnitKt;
import com.google.firebase.messaging.Constants;
import dev.chrisbanes.haze.HazeChildKt;
import dev.chrisbanes.haze.HazeState;
import dev.chrisbanes.haze.HazeStyle;
import dev.chrisbanes.haze.HazeTint;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: GlassComponents.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000J\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0007\u001a?\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tH\u0007¢\u0006\u0002\u0010\n\u001aG\u0010\u000b\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0006\u001a\u00020\u00072\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00010\u0015H\u0003¢\u0006\u0004\b\u0016\u0010\u0017\u001a'\u0010\u0018\u001a\u00020\u00012\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00010\u00152\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tH\u0007¢\u0006\u0002\u0010\u0019¨\u0006\u001a²\u0006\n\u0010\u001b\u001a\u00020\u001cX\u008a\u008e\u0002²\u0006\n\u0010\u001d\u001a\u00020\u000fX\u008a\u008e\u0002²\u0006\n\u0010\u001e\u001a\u00020\u001cX\u008a\u0084\u0002²\u0006\n\u0010\u001f\u001a\u00020\u001cX\u008a\u0084\u0002²\u0006\n\u0010 \u001a\u00020\u001cX\u008a\u0084\u0002²\u0006\n\u0010!\u001a\u00020\u000fX\u008a\u0084\u0002²\u0006\n\u0010!\u001a\u00020\u000fX\u008a\u0084\u0002²\u0006\n\u0010\"\u001a\u00020\u001cX\u008a\u0084\u0002²\u0006\n\u0010#\u001a\u00020\u001cX\u008a\u0084\u0002"}, d2 = {"GlassNavigationBar", "", "selectedTab", "", "onSelectedTab", "Lkotlin/Function1;", "modifier", "Landroidx/compose/ui/Modifier;", "hazeState", "Ldev/chrisbanes/haze/HazeState;", "(ILkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Ldev/chrisbanes/haze/HazeState;Landroidx/compose/runtime/Composer;II)V", "NavigationTab", Constants.ScionAnalytics.PARAM_LABEL, "", "selected", "", "iconType", "Lcom/example/tickets/NavigationIconType;", "horizontalShift", "Landroidx/compose/ui/unit/Dp;", "onClick", "Lkotlin/Function0;", "NavigationTab-jIwJxvA", "(Ljava/lang/String;ZLcom/example/tickets/NavigationIconType;FLandroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "GlassAddButton", "(Lkotlin/jvm/functions/Function0;Ldev/chrisbanes/haze/HazeState;Landroidx/compose/runtime/Composer;II)V", "app", "dragDistance", "", "isDragging", "stretch", "pressScale", "navigationSway", "pressed", "scale", "alpha"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class GlassComponentsKt {

    /* JADX INFO: compiled from: GlassComponents.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[NavigationIconType.values().length];
            try {
                iArr[NavigationIconType.TICKETS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[NavigationIconType.SUBWAY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[NavigationIconType.SETTINGS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    static final Unit GlassAddButton$lambda$50(Function0 function0, HazeState hazeState, int i, int i2, Composer composer, int i3) {
        GlassAddButton(function0, hazeState, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    static final Unit GlassNavigationBar$lambda$37(int i, Function1 function1, Modifier modifier, HazeState hazeState, int i2, int i3, Composer composer, int i4) {
        GlassNavigationBar(i, function1, modifier, hazeState, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    static final Unit NavigationTab_jIwJxvA$lambda$42(String str, boolean z, NavigationIconType navigationIconType, float f, Modifier modifier, Function0 function0, int i, int i2, Composer composer, int i3) {
        m9297NavigationTabjIwJxvA(str, z, navigationIconType, f, modifier, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:101:0x039f  */
    /* JADX WARN: Code duplicated, block: B:104:0x03ab  */
    /* JADX WARN: Code duplicated, block: B:105:0x03af  */
    /* JADX WARN: Code duplicated, block: B:108:0x04b7  */
    /* JADX WARN: Code duplicated, block: B:111:0x04c3  */
    /* JADX WARN: Code duplicated, block: B:112:0x04c7  */
    /* JADX WARN: Code duplicated, block: B:115:0x07f3  */
    /* JADX WARN: Code duplicated, block: B:118:0x07ff  */
    /* JADX WARN: Code duplicated, block: B:119:0x0803  */
    /* JADX WARN: Code duplicated, block: B:122:0x0899  */
    /* JADX WARN: Code duplicated, block: B:125:0x08a5  */
    /* JADX WARN: Code duplicated, block: B:126:0x08a9  */
    /* JADX WARN: Code duplicated, block: B:129:0x08f5  */
    /* JADX WARN: Code duplicated, block: B:130:0x08f7  */
    /* JADX WARN: Code duplicated, block: B:133:0x090f  */
    /* JADX WARN: Code duplicated, block: B:134:0x0911  */
    /* JADX WARN: Code duplicated, block: B:137:0x0918  */
    /* JADX WARN: Code duplicated, block: B:141:0x0924  */
    /* JADX WARN: Code duplicated, block: B:144:0x09a6  */
    /* JADX WARN: Code duplicated, block: B:147:0x09b2  */
    /* JADX WARN: Code duplicated, block: B:148:0x09b6  */
    /* JADX WARN: Code duplicated, block: B:151:0x0a05  */
    /* JADX WARN: Code duplicated, block: B:152:0x0a07  */
    /* JADX WARN: Code duplicated, block: B:155:0x0a1a  */
    /* JADX WARN: Code duplicated, block: B:156:0x0a1d  */
    /* JADX WARN: Code duplicated, block: B:159:0x0a25  */
    /* JADX WARN: Code duplicated, block: B:162:0x0a30  */
    /* JADX WARN: Code duplicated, block: B:166:0x0ab2  */
    /* JADX WARN: Code duplicated, block: B:169:0x0abe  */
    /* JADX WARN: Code duplicated, block: B:170:0x0ac2  */
    /* JADX WARN: Code duplicated, block: B:173:0x0b0f  */
    /* JADX WARN: Code duplicated, block: B:174:0x0b11  */
    /* JADX WARN: Code duplicated, block: B:177:0x0b24  */
    /* JADX WARN: Code duplicated, block: B:178:0x0b26  */
    /* JADX WARN: Code duplicated, block: B:181:0x0b2d  */
    /* JADX WARN: Code duplicated, block: B:183:0x0b35  */
    /* JADX WARN: Code duplicated, block: B:186:0x0b9f  */
    /* JADX WARN: Code duplicated, block: B:188:0x0ba7  */
    /* JADX WARN: Code duplicated, block: B:191:0x0bd3  */
    /* JADX WARN: Code duplicated, block: B:193:0x0bdb  */
    /* JADX WARN: Code duplicated, block: B:196:0x0c0e  */
    /* JADX WARN: Code duplicated, block: B:199:0x0c4b  */
    /* JADX WARN: Code duplicated, block: B:200:0x0c4e  */
    /* JADX WARN: Code duplicated, block: B:203:0x0c5d  */
    /* JADX WARN: Code duplicated, block: B:207:0x0c68  */
    /* JADX WARN: Code duplicated, block: B:210:0x0ca1  */
    /* JADX WARN: Code duplicated, block: B:212:0x0ca9  */
    /* JADX WARN: Code duplicated, block: B:215:0x0cb5  */
    /* JADX WARN: Code duplicated, block: B:217:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:30:0x0059  */
    /* JADX WARN: Code duplicated, block: B:31:0x005c  */
    /* JADX WARN: Code duplicated, block: B:33:0x0060  */
    /* JADX WARN: Code duplicated, block: B:35:0x0068  */
    /* JADX WARN: Code duplicated, block: B:36:0x006b  */
    /* JADX WARN: Code duplicated, block: B:41:0x0078  */
    /* JADX WARN: Code duplicated, block: B:42:0x007a  */
    /* JADX WARN: Code duplicated, block: B:45:0x0083 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:46:0x0085  */
    /* JADX WARN: Code duplicated, block: B:47:0x008a  */
    /* JADX WARN: Code duplicated, block: B:49:0x008d  */
    /* JADX WARN: Code duplicated, block: B:50:0x0090  */
    /* JADX WARN: Code duplicated, block: B:53:0x0098  */
    /* JADX WARN: Code duplicated, block: B:56:0x00d1  */
    /* JADX WARN: Code duplicated, block: B:59:0x0124 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:60:0x0126  */
    /* JADX WARN: Code duplicated, block: B:61:0x012a  */
    /* JADX WARN: Code duplicated, block: B:62:0x012d  */
    /* JADX WARN: Code duplicated, block: B:65:0x0147  */
    /* JADX WARN: Code duplicated, block: B:66:0x0153  */
    /* JADX WARN: Code duplicated, block: B:69:0x016d  */
    /* JADX WARN: Code duplicated, block: B:72:0x018d  */
    /* JADX WARN: Code duplicated, block: B:76:0x01bc  */
    /* JADX WARN: Code duplicated, block: B:79:0x0205  */
    /* JADX WARN: Code duplicated, block: B:80:0x0209  */
    /* JADX WARN: Code duplicated, block: B:83:0x024d  */
    /* JADX WARN: Code duplicated, block: B:84:0x0253  */
    /* JADX WARN: Code duplicated, block: B:87:0x0294  */
    /* JADX WARN: Code duplicated, block: B:89:0x029c  */
    /* JADX WARN: Code duplicated, block: B:92:0x02c2  */
    /* JADX WARN: Code duplicated, block: B:94:0x02ca  */
    /* JADX WARN: Code duplicated, block: B:97:0x02f5  */
    /* JADX WARN: Code duplicated, block: B:98:0x0349  */
    public static final void GlassNavigationBar(final int i, final Function1<? super Integer, Unit> onSelectedTab, Modifier modifier, HazeState hazeState, Composer composer, final int i2, final int i3) {
        int i4;
        Modifier modifier2;
        int i5;
        HazeState hazeState2;
        int i6;
        boolean z;
        Composer composer2;
        final Modifier modifier3;
        final HazeState hazeState3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier.Companion companion;
        HazeState hazeState4;
        final Density density;
        Object objRememberedValue;
        CoroutineScope coroutineScope;
        final float fM8748constructorimpl;
        final float fM8748constructorimpl2;
        float fMo803toPx0680j_4;
        float fMo803toPx0680j_5;
        float f;
        Object objRememberedValue2;
        final Animatable animatable;
        Object objRememberedValue3;
        MutableFloatState mutableFloatState;
        Object objRememberedValue4;
        MutableState mutableState;
        float fCoerceIn;
        float f2;
        final State<Float> stateAnimateFloatAsState;
        float f3;
        final State<Float> stateAnimateFloatAsState2;
        float fCoerceIn2;
        float f4;
        final State<Float> stateAnimateFloatAsState3;
        boolean zChangedInstance;
        GlassComponentsKt$GlassNavigationBar$1$1 glassComponentsKt$GlassNavigationBar$1$1RememberedValue;
        boolean zChanged;
        Object objRememberedValue5;
        HazeState hazeState5;
        Modifier.Companion companionHazeEffect$default;
        Function0<ComposeUiNode> constructor;
        Function0<ComposeUiNode> constructor2;
        Function0<ComposeUiNode> constructor3;
        Function0<ComposeUiNode> constructor4;
        boolean z2;
        int i7;
        boolean z3;
        Object objRememberedValue6;
        final Function1<? super Integer, Unit> function1;
        Function0<ComposeUiNode> constructor5;
        boolean z4;
        NavigationIconType navigationIconType;
        boolean z5;
        Object objRememberedValue7;
        NavigationIconType navigationIconType2;
        Function0<ComposeUiNode> constructor6;
        boolean z6;
        boolean z7;
        Object objRememberedValue8;
        boolean zChangedInstance2;
        Object objRememberedValue9;
        boolean zChanged2;
        Object objRememberedValue10;
        Object objRememberedValue11;
        boolean z8;
        boolean zChanged3;
        GlassComponentsKt$GlassNavigationBar$3$6$1 glassComponentsKt$GlassNavigationBar$3$6$1RememberedValue;
        int i8;
        Intrinsics.checkNotNullParameter(onSelectedTab, "onSelectedTab");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1610624549);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(GlassNavigationBar)N(selectedTab,onSelectedTab,modifier,hazeState)82@3436L7,83@3460L24,127@4257L51,134@4361L48,141@4462L46,158@4819L301,175@5174L297,207@5916L309,227@6423L281,227@6395L309,249@6920L139,247@6867L23857:GlassComponents.kt#n9ob9m");
        if ((i2 & 6) == 0) {
            i4 = (composerStartRestartGroup.changed(i) ? 4 : 2) | i2;
        } else {
            i4 = i2;
        }
        if ((i2 & 48) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(onSelectedTab) ? 32 : 16;
        }
        int i9 = i3 & 4;
        if (i9 == 0) {
            if ((i2 & 384) == 0) {
                modifier2 = modifier;
                i4 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            i5 = i3 & 8;
            if (i5 != 0) {
                if ((i2 & 3072) == 0) {
                    hazeState2 = hazeState;
                    if (composerStartRestartGroup.changed(hazeState2)) {
                        i6 = 2048;
                    } else {
                        i6 = 1024;
                    }
                    i4 |= i6;
                }
                if ((i4 & 1171) != 1170) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    modifier3 = modifier2;
                    hazeState3 = hazeState2;
                } else {
                    if (i9 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i5 != 0) {
                        hazeState4 = null;
                    } else {
                        hazeState4 = hazeState2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1610624549, i4, -1, "com.example.tickets.GlassNavigationBar (GlassComponents.kt:80)");
                    }
                    ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume = composerStartRestartGroup.consume(localDensity);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    density = (Density) objConsume;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 773894976, "CC(rememberCoroutineScope)N(getContext)763@35102L68:Effects.kt#9igjgp");
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 683736516, "CC(remember):Effects.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    coroutineScope = (CoroutineScope) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    float fM8748constructorimpl3 = Dp.m8748constructorimpl(254.0f);
                    fM8748constructorimpl = Dp.m8748constructorimpl(68.0f);
                    float fM8748constructorimpl4 = Dp.m8748constructorimpl(80.0f);
                    fM8748constructorimpl2 = Dp.m8748constructorimpl(62.0f);
                    float fM8748constructorimpl5 = Dp.m8748constructorimpl(4.0f);
                    fMo803toPx0680j_4 = density.mo803toPx0680j_4(fM8748constructorimpl5);
                    fMo803toPx0680j_5 = density.mo803toPx0680j_4(Dp.m8748constructorimpl(Dp.m8748constructorimpl(fM8748constructorimpl3 - fM8748constructorimpl4) - fM8748constructorimpl5));
                    f = (fMo803toPx0680j_4 + fMo803toPx0680j_5) / 2.0f;
                    if (i != 0) {
                        f = fMo803toPx0680j_4;
                    } else if (i != 1) {
                        f = fMo803toPx0680j_5;
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1621932434, "CC(remember):GlassComponents.kt#9igjgp");
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    int i10 = i4;
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = AnimatableKt.Animatable$default(f, 0.0f, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    animatable = (Animatable) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1621929109, "CC(remember):GlassComponents.kt#9igjgp");
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue3 = PrimitiveSnapshotStateKt.mutableFloatStateOf(0.0f);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    mutableFloatState = (MutableFloatState) objRememberedValue3;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1621925879, "CC(remember):GlassComponents.kt#9igjgp");
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    mutableState = (MutableState) objRememberedValue4;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    fCoerceIn = RangesKt.coerceIn(Math.abs(GlassNavigationBar$lambda$4(mutableFloatState)) / 180.0f, 0.0f, 0.09f);
                    if (!GlassNavigationBar$lambda$7(mutableState)) {
                        fCoerceIn = 0.0f;
                    }
                    f2 = f;
                    stateAnimateFloatAsState = AnimateAsStateKt.animateFloatAsState(fCoerceIn, AnimationSpecKt.spring$default(0.78f, 650.0f, null, 4, null), 0.0f, "bubbleStretch", null, composerStartRestartGroup, 3120, 20);
                    if (GlassNavigationBar$lambda$7(mutableState)) {
                        f3 = 1.055f;
                    } else {
                        f3 = 1.0f;
                    }
                    stateAnimateFloatAsState2 = AnimateAsStateKt.animateFloatAsState(f3, AnimationSpecKt.spring$default(0.84f, 760.0f, null, 4, null), 0.0f, "bubblePressScale", null, composerStartRestartGroup, 3120, 20);
                    float fMo803toPx0680j_6 = density.mo803toPx0680j_4(Dp.m8748constructorimpl(5.0f));
                    fCoerceIn2 = RangesKt.coerceIn(GlassNavigationBar$lambda$4(mutableFloatState) * 0.22f, -fMo803toPx0680j_6, fMo803toPx0680j_6);
                    if (GlassNavigationBar$lambda$7(mutableState)) {
                        f4 = fCoerceIn2;
                    } else {
                        f4 = 0.0f;
                    }
                    stateAnimateFloatAsState3 = AnimateAsStateKt.animateFloatAsState(f4, AnimationSpecKt.spring$default(0.86f, 520.0f, null, 4, null), 0.0f, "navigationSway", null, composerStartRestartGroup, 3120, 20);
                    Integer numValueOf = Integer.valueOf(i);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1621862892, "CC(remember):GlassComponents.kt#9igjgp");
                    zChangedInstance = composerStartRestartGroup.changedInstance(animatable) | composerStartRestartGroup.changed(f2);
                    glassComponentsKt$GlassNavigationBar$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!zChangedInstance || glassComponentsKt$GlassNavigationBar$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                        glassComponentsKt$GlassNavigationBar$1$1RememberedValue = new GlassComponentsKt$GlassNavigationBar$1$1(animatable, f2, mutableState, null);
                        composerStartRestartGroup.updateRememberedValue(glassComponentsKt$GlassNavigationBar$1$1RememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    EffectsKt.LaunchedEffect(numValueOf, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) glassComponentsKt$GlassNavigationBar$1$1RememberedValue, composerStartRestartGroup, i10 & 14);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1621847130, "CC(remember):GlassComponents.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(stateAnimateFloatAsState3);
                    objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged || objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue5 = new Function1() { // from class: com.example.tickets.GlassComponentsKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return GlassComponentsKt.GlassNavigationBar$lambda$15$lambda$14(stateAnimateFloatAsState3, (Density) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Modifier modifierClip = ClipKt.clip(SizeKt.m1476height3ABfNKs(SizeKt.m1495width3ABfNKs(OffsetKt.offset(companion, (Function1) objRememberedValue5), fM8748constructorimpl3), fM8748constructorimpl), RoundedCornerShapeKt.m1756RoundedCornerShape0680j_4(Dp.m8748constructorimpl(34.0f)));
                    if (hazeState4 != null) {
                        HazeState hazeState6 = hazeState4;
                        companionHazeEffect$default = HazeChildKt.hazeEffect$default(Modifier.INSTANCE, hazeState6, new HazeStyle(Color.INSTANCE.m5873getTransparent0d7_KjU(), new HazeTint(Color.m5837copywmQWz5c$default(Color.INSTANCE.m5875getWhite0d7_KjU(), 0.16f, 0.0f, 0.0f, 0.0f, 14, null), 0, 2, (DefaultConstructorMarker) null), Dp.m8748constructorimpl(30.0f), 0.0f, (HazeTint) null, 24, (DefaultConstructorMarker) null), null, 4, null);
                        hazeState5 = hazeState6;
                    } else {
                        hazeState5 = hazeState4;
                        companionHazeEffect$default = Modifier.INSTANCE;
                    }
                    Modifier modifierThen = modifierClip.then(companionHazeEffect$default);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
                    int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierThen);
                    Modifier modifier4 = companion;
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
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -671913841, "C292@8191L3886,412@12128L596,437@12904L1951,515@15183L695,535@15910L497,557@16526L10679,844@27242L3466,511@15048L15670:GlassComponents.kt#n9ob9m");
                    Modifier modifierBackground$default = BackgroundKt.background$default(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), Brush.Companion.m5769verticalGradient8A3gB4$default(Brush.INSTANCE, CollectionsKt.listOf((Object[]) new Color[]{Color.m5828boximpl(Color.m5837copywmQWz5c$default(Color.INSTANCE.m5875getWhite0d7_KjU(), 0.155f, 0.0f, 0.0f, 0.0f, 14, null)), Color.m5828boximpl(Color.m5837copywmQWz5c$default(Color.INSTANCE.m5875getWhite0d7_KjU(), 0.085f, 0.0f, 0.0f, 0.0f, 14, null)), Color.m5828boximpl(Color.m5837copywmQWz5c$default(Color.INSTANCE.m5875getWhite0d7_KjU(), 0.055f, 0.0f, 0.0f, 0.0f, 14, null))}), 0.0f, 0.0f, 0, 14, (Object) null), RoundedCornerShapeKt.m1756RoundedCornerShape0680j_4(Dp.m8748constructorimpl(34.0f)), 0.0f, 4, null);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
                    int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierBackground$default);
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
                    Updater.m4945setimpl(composerM4937constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m4945setimpl(composerM4937constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Updater.m4945setimpl(composerM4937constructorimpl2, Integer.valueOf(iHashCode2), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                    Updater.m4943reconcileimpl(composerM4937constructorimpl2, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                    Updater.m4945setimpl(composerM4937constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -700470138, "C312@8853L643,333@9571L322,347@9963L723,370@10758L681,393@11550L517:GlassComponents.kt#n9ob9m");
                    BoxKt.Box(BackgroundKt.background$default(BlurKt.m5339blurF8QBwvs$default(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m8748constructorimpl(18.0f), null, 2, null), Brush.Companion.m5769verticalGradient8A3gB4$default(Brush.INSTANCE, CollectionsKt.listOf((Object[]) new Color[]{Color.m5828boximpl(Color.m5837copywmQWz5c$default(Color.INSTANCE.m5875getWhite0d7_KjU(), 0.11f, 0.0f, 0.0f, 0.0f, 14, null)), Color.m5828boximpl(Color.m5837copywmQWz5c$default(Color.INSTANCE.m5875getWhite0d7_KjU(), 0.06f, 0.0f, 0.0f, 0.0f, 14, null)), Color.m5828boximpl(Color.m5837copywmQWz5c$default(Color.INSTANCE.m5864getBlack0d7_KjU(), 0.035f, 0.0f, 0.0f, 0.0f, 14, null))}), 0.0f, 0.0f, 0, 14, (Object) null), RoundedCornerShapeKt.m1756RoundedCornerShape0680j_4(Dp.m8748constructorimpl(34.0f)), 0.0f, 4, null), composerStartRestartGroup, 0);
                    BoxKt.Box(BackgroundKt.m647backgroundbw27NRU(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), Color.m5837copywmQWz5c$default(Color.INSTANCE.m5875getWhite0d7_KjU(), 0.055f, 0.0f, 0.0f, 0.0f, 14, null), RoundedCornerShapeKt.m1756RoundedCornerShape0680j_4(Dp.m8748constructorimpl(34.0f))), composerStartRestartGroup, 0);
                    BoxKt.Box(BackgroundKt.background$default(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), Brush.Companion.m5765radialGradientP_VxKs$default(Brush.INSTANCE, CollectionsKt.listOf((Object[]) new Color[]{Color.m5828boximpl(Color.m5837copywmQWz5c$default(Color.INSTANCE.m5875getWhite0d7_KjU(), 0.095f, 0.0f, 0.0f, 0.0f, 14, null)), Color.m5828boximpl(Color.m5837copywmQWz5c$default(Color.INSTANCE.m5875getWhite0d7_KjU(), 0.038f, 0.0f, 0.0f, 0.0f, 14, null)), Color.m5828boximpl(Color.INSTANCE.m5873getTransparent0d7_KjU())}), 0L, 390.0f, 0, 10, (Object) null), RoundedCornerShapeKt.m1756RoundedCornerShape0680j_4(Dp.m8748constructorimpl(34.0f)), 0.0f, 4, null), composerStartRestartGroup, 0);
                    BoxKt.Box(BackgroundKt.background$default(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), Brush.Companion.m5769verticalGradient8A3gB4$default(Brush.INSTANCE, CollectionsKt.listOf((Object[]) new Color[]{Color.m5828boximpl(Color.m5837copywmQWz5c$default(Color.INSTANCE.m5875getWhite0d7_KjU(), 0.105f, 0.0f, 0.0f, 0.0f, 14, null)), Color.m5828boximpl(Color.INSTANCE.m5873getTransparent0d7_KjU()), Color.m5828boximpl(Color.m5837copywmQWz5c$default(Color.INSTANCE.m5864getBlack0d7_KjU(), 0.04f, 0.0f, 0.0f, 0.0f, 14, null))}), 0.0f, 0.0f, 0, 14, (Object) null), RoundedCornerShapeKt.m1756RoundedCornerShape0680j_4(Dp.m8748constructorimpl(34.0f)), 0.0f, 4, null), composerStartRestartGroup, 0);
                    BoxKt.Box(BackgroundKt.background$default(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), Brush.Companion.m5765radialGradientP_VxKs$default(Brush.INSTANCE, CollectionsKt.listOf((Object[]) new Color[]{Color.m5828boximpl(Color.INSTANCE.m5873getTransparent0d7_KjU()), Color.m5828boximpl(Color.m5837copywmQWz5c$default(Color.INSTANCE.m5864getBlack0d7_KjU(), 0.045f, 0.0f, 0.0f, 0.0f, 14, null))}), 0L, 250.0f, 0, 10, (Object) null), RoundedCornerShapeKt.m1756RoundedCornerShape0680j_4(Dp.m8748constructorimpl(34.0f)), 0.0f, 4, null), composerStartRestartGroup, 0);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    BoxKt.Box(BorderKt.m661borderziNgDLE(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m8748constructorimpl(1.0f), Brush.Companion.m5769verticalGradient8A3gB4$default(Brush.INSTANCE, CollectionsKt.listOf((Object[]) new Color[]{Color.m5828boximpl(Color.m5837copywmQWz5c$default(Color.INSTANCE.m5875getWhite0d7_KjU(), 0.22f, 0.0f, 0.0f, 0.0f, 14, null)), Color.m5828boximpl(Color.m5837copywmQWz5c$default(Color.INSTANCE.m5875getWhite0d7_KjU(), 0.065f, 0.0f, 0.0f, 0.0f, 14, null))}), 0.0f, 0.0f, 0, 14, (Object) null), RoundedCornerShapeKt.m1756RoundedCornerShape0680j_4(Dp.m8748constructorimpl(34.0f))), composerStartRestartGroup, 0);
                    Modifier modifierM1425paddingVpY3zN4$default = PaddingKt.m1425paddingVpY3zN4$default(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), fM8748constructorimpl5, 0.0f, 2, null);
                    Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                    MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, composerStartRestartGroup, 48);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
                    int iHashCode3 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1425paddingVpY3zN4$default);
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
                    Updater.m4945setimpl(composerM4937constructorimpl3, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m4945setimpl(composerM4937constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Updater.m4945setimpl(composerM4937constructorimpl3, Integer.valueOf(iHashCode3), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                    Updater.m4943reconcileimpl(composerM4937constructorimpl3, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                    Updater.m4945setimpl(composerM4937constructorimpl3, modifierMaterializeModifier3, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                    RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 446008607, "C447@13162L551,466@13727L552,485@14293L552:GlassComponents.kt#n9ob9m");
                    Modifier modifierFillMaxHeight$default = SizeKt.fillMaxHeight$default(SizeKt.m1495width3ABfNKs(Modifier.INSTANCE, fM8748constructorimpl4), 0.0f, 1, null);
                    Alignment center = Alignment.INSTANCE.getCenter();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
                    int iHashCode4 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap4 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxHeight$default);
                    constructor4 = ComposeUiNode.INSTANCE.getConstructor();
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
                    Updater.m4945setimpl(composerM4937constructorimpl4, measurePolicyMaybeCachedBoxMeasurePolicy3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m4945setimpl(composerM4937constructorimpl4, currentCompositionLocalMap4, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Updater.m4945setimpl(composerM4937constructorimpl4, Integer.valueOf(iHashCode4), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                    Updater.m4943reconcileimpl(composerM4937constructorimpl4, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                    Updater.m4945setimpl(composerM4937constructorimpl4, modifierMaterializeModifier4, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance3 = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1753369025, "C460@13617L64,455@13386L313:GlassComponents.kt#n9ob9m");
                    if (i == 0) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    NavigationIconType navigationIconType3 = NavigationIconType.TICKETS;
                    float fM8748constructorimpl6 = Dp.m8748constructorimpl(0.0f);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -887837141, "CC(remember):GlassComponents.kt#9igjgp");
                    i7 = i10 & StylePropertiesKt.TextDirectionMask;
                    if (i7 == 32) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                    if (!z3 || objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                        function1 = onSelectedTab;
                        objRememberedValue6 = new Function0() { // from class: com.example.tickets.GlassComponentsKt$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return GlassComponentsKt.GlassNavigationBar$lambda$36$lambda$26$lambda$19$lambda$18$lambda$17(function1);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                    } else {
                        function1 = onSelectedTab;
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    m9297NavigationTabjIwJxvA("票夹", z2, navigationIconType3, fM8748constructorimpl6, null, (Function0) objRememberedValue6, composerStartRestartGroup, 3462, 16);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Modifier modifierFillMaxHeight$default2 = SizeKt.fillMaxHeight$default(SizeKt.m1495width3ABfNKs(Modifier.INSTANCE, fM8748constructorimpl4), 0.0f, 1, null);
                    Alignment center2 = Alignment.INSTANCE.getCenter();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy4 = BoxKt.maybeCachedBoxMeasurePolicy(center2, false);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
                    int iHashCode5 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap5 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier5 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxHeight$default2);
                    constructor5 = ComposeUiNode.INSTANCE.getConstructor();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)410@16216L9:Composables.kt#9igjgp");
                    if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(constructor5);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    Composer composerM4937constructorimpl5 = Updater.m4937constructorimpl(composerStartRestartGroup);
                    Updater.m4945setimpl(composerM4937constructorimpl5, measurePolicyMaybeCachedBoxMeasurePolicy4, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m4945setimpl(composerM4937constructorimpl5, currentCompositionLocalMap5, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Updater.m4945setimpl(composerM4937constructorimpl5, Integer.valueOf(iHashCode5), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                    Updater.m4943reconcileimpl(composerM4937constructorimpl5, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                    Updater.m4945setimpl(composerM4937constructorimpl5, modifierMaterializeModifier5, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance4 = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1382315563, "C479@14183L64,474@13951L314:GlassComponents.kt#n9ob9m");
                    if (i == 1) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    navigationIconType = NavigationIconType.SUBWAY;
                    float fM8748constructorimpl7 = Dp.m8748constructorimpl(3.0f);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1430056972, "CC(remember):GlassComponents.kt#9igjgp");
                    if (i7 == 32) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                    if (z5) {
                        navigationIconType2 = navigationIconType;
                    } else {
                        navigationIconType2 = navigationIconType;
                        if (objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        m9297NavigationTabjIwJxvA("智能地铁", z4, navigationIconType2, fM8748constructorimpl7, null, (Function0) objRememberedValue7, composerStartRestartGroup, 3462, 16);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composerStartRestartGroup.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        Modifier modifierFillMaxHeight$default3 = SizeKt.fillMaxHeight$default(SizeKt.m1495width3ABfNKs(Modifier.INSTANCE, fM8748constructorimpl4), 0.0f, 1, null);
                        Alignment center3 = Alignment.INSTANCE.getCenter();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy5 = BoxKt.maybeCachedBoxMeasurePolicy(center3, false);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
                        int iHashCode6 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                        CompositionLocalMap currentCompositionLocalMap6 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier6 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxHeight$default3);
                        constructor6 = ComposeUiNode.INSTANCE.getConstructor();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)410@16216L9:Composables.kt#9igjgp");
                        if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composerStartRestartGroup.startReusableNode();
                        if (composerStartRestartGroup.getInserting()) {
                            composerStartRestartGroup.createNode(constructor6);
                        } else {
                            composerStartRestartGroup.useNode();
                        }
                        Composer composerM4937constructorimpl6 = Updater.m4937constructorimpl(composerStartRestartGroup);
                        Updater.m4945setimpl(composerM4937constructorimpl6, measurePolicyMaybeCachedBoxMeasurePolicy5, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m4945setimpl(composerM4937constructorimpl6, currentCompositionLocalMap6, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Updater.m4945setimpl(composerM4937constructorimpl6, Integer.valueOf(iHashCode6), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                        Updater.m4943reconcileimpl(composerM4937constructorimpl6, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                        Updater.m4945setimpl(composerM4937constructorimpl6, modifierMaterializeModifier6, ComposeUiNode.INSTANCE.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                        BoxScopeInstance boxScopeInstance5 = BoxScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1950287786, "C498@14749L64,493@14517L314:GlassComponents.kt#n9ob9m");
                        if (i == 2) {
                            z6 = true;
                        } else {
                            z6 = false;
                        }
                        NavigationIconType navigationIconType4 = NavigationIconType.SETTINGS;
                        float fM8748constructorimpl8 = Dp.m8748constructorimpl(8.0f);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1864020653, "CC(remember):GlassComponents.kt#9igjgp");
                        if (i7 == 32) {
                            z7 = true;
                        } else {
                            z7 = false;
                        }
                        objRememberedValue8 = composerStartRestartGroup.rememberedValue();
                        if (!z7 || objRememberedValue8 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue8 = new Function0() { // from class: com.example.tickets.GlassComponentsKt$$ExternalSyntheticLambda6
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return GlassComponentsKt.GlassNavigationBar$lambda$36$lambda$26$lambda$25$lambda$24$lambda$23(function1);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        m9297NavigationTabjIwJxvA("设置", z6, navigationIconType4, fM8748constructorimpl8, null, (Function0) objRememberedValue8, composerStartRestartGroup, 3462, 16);
                        composer2 = composerStartRestartGroup;
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
                        Modifier modifierM1476height3ABfNKs = SizeKt.m1476height3ABfNKs(SizeKt.m1495width3ABfNKs(Modifier.INSTANCE, fM8748constructorimpl4), fM8748constructorimpl2);
                        ComposerKt.sourceInformationMarkerStart(composer2, 117074604, "CC(remember):GlassComponents.kt#9igjgp");
                        zChangedInstance2 = composer2.changedInstance(animatable) | composer2.changed(density);
                        objRememberedValue9 = composer2.rememberedValue();
                        if (!zChangedInstance2 || objRememberedValue9 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue9 = new Function1() { // from class: com.example.tickets.GlassComponentsKt$$ExternalSyntheticLambda7
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return GlassComponentsKt.GlassNavigationBar$lambda$36$lambda$29$lambda$28(animatable, density, fM8748constructorimpl, fM8748constructorimpl2, (Density) obj);
                                }
                            };
                            composer2.updateRememberedValue(objRememberedValue9);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        Modifier modifierOffset = OffsetKt.offset(modifierM1476height3ABfNKs, (Function1) objRememberedValue9);
                        ComposerKt.sourceInformationMarkerStart(composer2, 117097670, "CC(remember):GlassComponents.kt#9igjgp");
                        zChanged2 = composer2.changed(stateAnimateFloatAsState2) | composer2.changed(stateAnimateFloatAsState);
                        objRememberedValue10 = composer2.rememberedValue();
                        if (!zChanged2 || objRememberedValue10 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue10 = new Function1() { // from class: com.example.tickets.GlassComponentsKt$$ExternalSyntheticLambda8
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return GlassComponentsKt.GlassNavigationBar$lambda$36$lambda$31$lambda$30(stateAnimateFloatAsState2, stateAnimateFloatAsState, (GraphicsLayerScope) obj);
                                }
                            };
                            composer2.updateRememberedValue(objRememberedValue10);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        Modifier modifierClip2 = ClipKt.clip(GraphicsLayerModifierKt.graphicsLayer(modifierOffset, (Function1) objRememberedValue10), RoundedCornerShapeKt.m1756RoundedCornerShape0680j_4(Dp.m8748constructorimpl(31.0f)));
                        ComposerKt.sourceInformationMarkerStart(composer2, 117127564, "CC(remember):GlassComponents.kt#9igjgp");
                        objRememberedValue11 = composer2.rememberedValue();
                        if (objRememberedValue11 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue11 = new Function1() { // from class: com.example.tickets.GlassComponentsKt$$ExternalSyntheticLambda9
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return GlassComponentsKt.GlassNavigationBar$lambda$36$lambda$34$lambda$33((CacheDrawScope) obj);
                                }
                            };
                            composer2.updateRememberedValue(objRememberedValue11);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        Modifier modifierDrawWithCache = DrawModifierKt.drawWithCache(modifierClip2, (Function1) objRememberedValue11);
                        Unit unit = Unit.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composer2, 117463263, "CC(remember):GlassComponents.kt#9igjgp");
                        boolean zChanged4 = composer2.changed(fMo803toPx0680j_4) | composer2.changed(f) | composer2.changed(fMo803toPx0680j_5) | composer2.changedInstance(animatable) | composer2.changedInstance(coroutineScope);
                        if (i7 == 32) {
                            z8 = true;
                        } else {
                            z8 = false;
                        }
                        zChanged3 = zChanged4 | z8 | composer2.changed(f2);
                        glassComponentsKt$GlassNavigationBar$3$6$1RememberedValue = composer2.rememberedValue();
                        if (!zChanged3 || glassComponentsKt$GlassNavigationBar$3$6$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                            i8 = 0;
                            glassComponentsKt$GlassNavigationBar$3$6$1RememberedValue = new GlassComponentsKt$GlassNavigationBar$3$6$1(mutableState, mutableFloatState, fMo803toPx0680j_4, f, fMo803toPx0680j_5, coroutineScope, animatable, function1, f2);
                            composer2.updateRememberedValue(glassComponentsKt$GlassNavigationBar$3$6$1RememberedValue);
                        } else {
                            i8 = 0;
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        BoxKt.Box(SuspendingPointerInputFilterKt.pointerInput(modifierDrawWithCache, unit, (PointerInputEventHandler) glassComponentsKt$GlassNavigationBar$3$6$1RememberedValue), composer2, i8);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        composer2.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        hazeState3 = hazeState5;
                        modifier3 = modifier4;
                    }
                    objRememberedValue7 = new Function0() { // from class: com.example.tickets.GlassComponentsKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return GlassComponentsKt.GlassNavigationBar$lambda$36$lambda$26$lambda$22$lambda$21$lambda$20(function1);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    m9297NavigationTabjIwJxvA("智能地铁", z4, navigationIconType2, fM8748constructorimpl7, null, (Function0) objRememberedValue7, composerStartRestartGroup, 3462, 16);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Modifier modifierFillMaxHeight$default4 = SizeKt.fillMaxHeight$default(SizeKt.m1495width3ABfNKs(Modifier.INSTANCE, fM8748constructorimpl4), 0.0f, 1, null);
                    Alignment center4 = Alignment.INSTANCE.getCenter();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy6 = BoxKt.maybeCachedBoxMeasurePolicy(center4, false);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
                    int iHashCode7 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap7 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier7 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxHeight$default4);
                    constructor6 = ComposeUiNode.INSTANCE.getConstructor();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)410@16216L9:Composables.kt#9igjgp");
                    if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(constructor6);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    Composer composerM4937constructorimpl7 = Updater.m4937constructorimpl(composerStartRestartGroup);
                    Updater.m4945setimpl(composerM4937constructorimpl7, measurePolicyMaybeCachedBoxMeasurePolicy6, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m4945setimpl(composerM4937constructorimpl7, currentCompositionLocalMap7, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Updater.m4945setimpl(composerM4937constructorimpl7, Integer.valueOf(iHashCode7), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                    Updater.m4943reconcileimpl(composerM4937constructorimpl7, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                    Updater.m4945setimpl(composerM4937constructorimpl7, modifierMaterializeModifier7, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance6 = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1950287786, "C498@14749L64,493@14517L314:GlassComponents.kt#n9ob9m");
                    if (i == 2) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    NavigationIconType navigationIconType5 = NavigationIconType.SETTINGS;
                    float fM8748constructorimpl9 = Dp.m8748constructorimpl(8.0f);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1864020653, "CC(remember):GlassComponents.kt#9igjgp");
                    if (i7 == 32) {
                        z7 = true;
                    } else {
                        z7 = false;
                    }
                    objRememberedValue8 = composerStartRestartGroup.rememberedValue();
                    if (!z7) {
                        objRememberedValue8 = new Function0() { // from class: com.example.tickets.GlassComponentsKt$$ExternalSyntheticLambda6
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return GlassComponentsKt.GlassNavigationBar$lambda$36$lambda$26$lambda$25$lambda$24$lambda$23(function1);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                    } else {
                        objRememberedValue8 = new Function0() { // from class: com.example.tickets.GlassComponentsKt$$ExternalSyntheticLambda6
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return GlassComponentsKt.GlassNavigationBar$lambda$36$lambda$26$lambda$25$lambda$24$lambda$23(function1);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    m9297NavigationTabjIwJxvA("设置", z6, navigationIconType5, fM8748constructorimpl9, null, (Function0) objRememberedValue8, composerStartRestartGroup, 3462, 16);
                    composer2 = composerStartRestartGroup;
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
                    Modifier modifierM1476height3ABfNKs2 = SizeKt.m1476height3ABfNKs(SizeKt.m1495width3ABfNKs(Modifier.INSTANCE, fM8748constructorimpl4), fM8748constructorimpl2);
                    ComposerKt.sourceInformationMarkerStart(composer2, 117074604, "CC(remember):GlassComponents.kt#9igjgp");
                    zChangedInstance2 = composer2.changedInstance(animatable) | composer2.changed(density);
                    objRememberedValue9 = composer2.rememberedValue();
                    if (!zChangedInstance2) {
                        objRememberedValue9 = new Function1() { // from class: com.example.tickets.GlassComponentsKt$$ExternalSyntheticLambda7
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return GlassComponentsKt.GlassNavigationBar$lambda$36$lambda$29$lambda$28(animatable, density, fM8748constructorimpl, fM8748constructorimpl2, (Density) obj);
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue9);
                    } else {
                        objRememberedValue9 = new Function1() { // from class: com.example.tickets.GlassComponentsKt$$ExternalSyntheticLambda7
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return GlassComponentsKt.GlassNavigationBar$lambda$36$lambda$29$lambda$28(animatable, density, fM8748constructorimpl, fM8748constructorimpl2, (Density) obj);
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue9);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    Modifier modifierOffset2 = OffsetKt.offset(modifierM1476height3ABfNKs2, (Function1) objRememberedValue9);
                    ComposerKt.sourceInformationMarkerStart(composer2, 117097670, "CC(remember):GlassComponents.kt#9igjgp");
                    zChanged2 = composer2.changed(stateAnimateFloatAsState2) | composer2.changed(stateAnimateFloatAsState);
                    objRememberedValue10 = composer2.rememberedValue();
                    if (!zChanged2) {
                        objRememberedValue10 = new Function1() { // from class: com.example.tickets.GlassComponentsKt$$ExternalSyntheticLambda8
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return GlassComponentsKt.GlassNavigationBar$lambda$36$lambda$31$lambda$30(stateAnimateFloatAsState2, stateAnimateFloatAsState, (GraphicsLayerScope) obj);
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue10);
                    } else {
                        objRememberedValue10 = new Function1() { // from class: com.example.tickets.GlassComponentsKt$$ExternalSyntheticLambda8
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return GlassComponentsKt.GlassNavigationBar$lambda$36$lambda$31$lambda$30(stateAnimateFloatAsState2, stateAnimateFloatAsState, (GraphicsLayerScope) obj);
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue10);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    Modifier modifierClip3 = ClipKt.clip(GraphicsLayerModifierKt.graphicsLayer(modifierOffset2, (Function1) objRememberedValue10), RoundedCornerShapeKt.m1756RoundedCornerShape0680j_4(Dp.m8748constructorimpl(31.0f)));
                    ComposerKt.sourceInformationMarkerStart(composer2, 117127564, "CC(remember):GlassComponents.kt#9igjgp");
                    objRememberedValue11 = composer2.rememberedValue();
                    if (objRememberedValue11 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue11 = new Function1() { // from class: com.example.tickets.GlassComponentsKt$$ExternalSyntheticLambda9
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return GlassComponentsKt.GlassNavigationBar$lambda$36$lambda$34$lambda$33((CacheDrawScope) obj);
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue11);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    Modifier modifierDrawWithCache2 = DrawModifierKt.drawWithCache(modifierClip3, (Function1) objRememberedValue11);
                    Unit unit2 = Unit.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composer2, 117463263, "CC(remember):GlassComponents.kt#9igjgp");
                    boolean zChanged5 = composer2.changed(fMo803toPx0680j_4) | composer2.changed(f) | composer2.changed(fMo803toPx0680j_5) | composer2.changedInstance(animatable) | composer2.changedInstance(coroutineScope);
                    if (i7 == 32) {
                        z8 = true;
                    } else {
                        z8 = false;
                    }
                    zChanged3 = zChanged5 | z8 | composer2.changed(f2);
                    glassComponentsKt$GlassNavigationBar$3$6$1RememberedValue = composer2.rememberedValue();
                    if (zChanged3) {
                        i8 = 0;
                        glassComponentsKt$GlassNavigationBar$3$6$1RememberedValue = new GlassComponentsKt$GlassNavigationBar$3$6$1(mutableState, mutableFloatState, fMo803toPx0680j_4, f, fMo803toPx0680j_5, coroutineScope, animatable, function1, f2);
                        composer2.updateRememberedValue(glassComponentsKt$GlassNavigationBar$3$6$1RememberedValue);
                    } else {
                        i8 = 0;
                        glassComponentsKt$GlassNavigationBar$3$6$1RememberedValue = new GlassComponentsKt$GlassNavigationBar$3$6$1(mutableState, mutableFloatState, fMo803toPx0680j_4, f, fMo803toPx0680j_5, coroutineScope, animatable, function1, f2);
                        composer2.updateRememberedValue(glassComponentsKt$GlassNavigationBar$3$6$1RememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    BoxKt.Box(SuspendingPointerInputFilterKt.pointerInput(modifierDrawWithCache2, unit2, (PointerInputEventHandler) glassComponentsKt$GlassNavigationBar$3$6$1RememberedValue), composer2, i8);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    composer2.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    hazeState3 = hazeState5;
                    modifier3 = modifier4;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.tickets.GlassComponentsKt$$ExternalSyntheticLambda10
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return GlassComponentsKt.GlassNavigationBar$lambda$37(i, onSelectedTab, modifier3, hazeState3, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i4 |= 3072;
            hazeState2 = hazeState;
            if ((i4 & 1171) != 1170) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                modifier3 = modifier2;
                hazeState3 = hazeState2;
            } else {
                if (i9 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i5 != 0) {
                    hazeState4 = null;
                } else {
                    hazeState4 = hazeState2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1610624549, i4, -1, "com.example.tickets.GlassNavigationBar (GlassComponents.kt:80)");
                }
                ProvidableCompositionLocal<Density> localDensity2 = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume2 = composerStartRestartGroup.consume(localDensity2);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                density = (Density) objConsume2;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 773894976, "CC(rememberCoroutineScope)N(getContext)763@35102L68:Effects.kt#9igjgp");
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 683736516, "CC(remember):Effects.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                coroutineScope = (CoroutineScope) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                float fM8748constructorimpl10 = Dp.m8748constructorimpl(254.0f);
                fM8748constructorimpl = Dp.m8748constructorimpl(68.0f);
                float fM8748constructorimpl11 = Dp.m8748constructorimpl(80.0f);
                fM8748constructorimpl2 = Dp.m8748constructorimpl(62.0f);
                float fM8748constructorimpl12 = Dp.m8748constructorimpl(4.0f);
                fMo803toPx0680j_4 = density.mo803toPx0680j_4(fM8748constructorimpl12);
                fMo803toPx0680j_5 = density.mo803toPx0680j_4(Dp.m8748constructorimpl(Dp.m8748constructorimpl(fM8748constructorimpl10 - fM8748constructorimpl11) - fM8748constructorimpl12));
                f = (fMo803toPx0680j_4 + fMo803toPx0680j_5) / 2.0f;
                if (i != 0) {
                    f = fMo803toPx0680j_4;
                } else if (i != 1) {
                    f = fMo803toPx0680j_5;
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1621932434, "CC(remember):GlassComponents.kt#9igjgp");
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                int i11 = i4;
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = AnimatableKt.Animatable$default(f, 0.0f, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                animatable = (Animatable) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1621929109, "CC(remember):GlassComponents.kt#9igjgp");
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue3 = PrimitiveSnapshotStateKt.mutableFloatStateOf(0.0f);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                mutableFloatState = (MutableFloatState) objRememberedValue3;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1621925879, "CC(remember):GlassComponents.kt#9igjgp");
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                mutableState = (MutableState) objRememberedValue4;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                fCoerceIn = RangesKt.coerceIn(Math.abs(GlassNavigationBar$lambda$4(mutableFloatState)) / 180.0f, 0.0f, 0.09f);
                if (!GlassNavigationBar$lambda$7(mutableState)) {
                    fCoerceIn = 0.0f;
                }
                f2 = f;
                stateAnimateFloatAsState = AnimateAsStateKt.animateFloatAsState(fCoerceIn, AnimationSpecKt.spring$default(0.78f, 650.0f, null, 4, null), 0.0f, "bubbleStretch", null, composerStartRestartGroup, 3120, 20);
                if (GlassNavigationBar$lambda$7(mutableState)) {
                    f3 = 1.055f;
                } else {
                    f3 = 1.0f;
                }
                stateAnimateFloatAsState2 = AnimateAsStateKt.animateFloatAsState(f3, AnimationSpecKt.spring$default(0.84f, 760.0f, null, 4, null), 0.0f, "bubblePressScale", null, composerStartRestartGroup, 3120, 20);
                float fMo803toPx0680j_7 = density.mo803toPx0680j_4(Dp.m8748constructorimpl(5.0f));
                fCoerceIn2 = RangesKt.coerceIn(GlassNavigationBar$lambda$4(mutableFloatState) * 0.22f, -fMo803toPx0680j_7, fMo803toPx0680j_7);
                if (GlassNavigationBar$lambda$7(mutableState)) {
                    f4 = fCoerceIn2;
                } else {
                    f4 = 0.0f;
                }
                stateAnimateFloatAsState3 = AnimateAsStateKt.animateFloatAsState(f4, AnimationSpecKt.spring$default(0.86f, 520.0f, null, 4, null), 0.0f, "navigationSway", null, composerStartRestartGroup, 3120, 20);
                Integer numValueOf2 = Integer.valueOf(i);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1621862892, "CC(remember):GlassComponents.kt#9igjgp");
                zChangedInstance = composerStartRestartGroup.changedInstance(animatable) | composerStartRestartGroup.changed(f2);
                glassComponentsKt$GlassNavigationBar$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (!zChangedInstance) {
                    glassComponentsKt$GlassNavigationBar$1$1RememberedValue = new GlassComponentsKt$GlassNavigationBar$1$1(animatable, f2, mutableState, null);
                    composerStartRestartGroup.updateRememberedValue(glassComponentsKt$GlassNavigationBar$1$1RememberedValue);
                } else {
                    glassComponentsKt$GlassNavigationBar$1$1RememberedValue = new GlassComponentsKt$GlassNavigationBar$1$1(animatable, f2, mutableState, null);
                    composerStartRestartGroup.updateRememberedValue(glassComponentsKt$GlassNavigationBar$1$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                EffectsKt.LaunchedEffect(numValueOf2, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) glassComponentsKt$GlassNavigationBar$1$1RememberedValue, composerStartRestartGroup, i11 & 14);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1621847130, "CC(remember):GlassComponents.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(stateAnimateFloatAsState3);
                objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    objRememberedValue5 = new Function1() { // from class: com.example.tickets.GlassComponentsKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return GlassComponentsKt.GlassNavigationBar$lambda$15$lambda$14(stateAnimateFloatAsState3, (Density) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                } else {
                    objRememberedValue5 = new Function1() { // from class: com.example.tickets.GlassComponentsKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return GlassComponentsKt.GlassNavigationBar$lambda$15$lambda$14(stateAnimateFloatAsState3, (Density) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Modifier modifierClip4 = ClipKt.clip(SizeKt.m1476height3ABfNKs(SizeKt.m1495width3ABfNKs(OffsetKt.offset(companion, (Function1) objRememberedValue5), fM8748constructorimpl10), fM8748constructorimpl), RoundedCornerShapeKt.m1756RoundedCornerShape0680j_4(Dp.m8748constructorimpl(34.0f)));
                if (hazeState4 != null) {
                    HazeState hazeState7 = hazeState4;
                    companionHazeEffect$default = HazeChildKt.hazeEffect$default(Modifier.INSTANCE, hazeState7, new HazeStyle(Color.INSTANCE.m5873getTransparent0d7_KjU(), new HazeTint(Color.m5837copywmQWz5c$default(Color.INSTANCE.m5875getWhite0d7_KjU(), 0.16f, 0.0f, 0.0f, 0.0f, 14, null), 0, 2, (DefaultConstructorMarker) null), Dp.m8748constructorimpl(30.0f), 0.0f, (HazeTint) null, 24, (DefaultConstructorMarker) null), null, 4, null);
                    hazeState5 = hazeState7;
                } else {
                    hazeState5 = hazeState4;
                    companionHazeEffect$default = Modifier.INSTANCE;
                }
                Modifier modifierThen2 = modifierClip4.then(companionHazeEffect$default);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy7 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
                int iHashCode8 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap8 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier8 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierThen2);
                Modifier modifier5 = companion;
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
                Composer composerM4937constructorimpl8 = Updater.m4937constructorimpl(composerStartRestartGroup);
                Updater.m4945setimpl(composerM4937constructorimpl8, measurePolicyMaybeCachedBoxMeasurePolicy7, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m4945setimpl(composerM4937constructorimpl8, currentCompositionLocalMap8, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Updater.m4945setimpl(composerM4937constructorimpl8, Integer.valueOf(iHashCode8), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                Updater.m4943reconcileimpl(composerM4937constructorimpl8, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                Updater.m4945setimpl(composerM4937constructorimpl8, modifierMaterializeModifier8, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance7 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -671913841, "C292@8191L3886,412@12128L596,437@12904L1951,515@15183L695,535@15910L497,557@16526L10679,844@27242L3466,511@15048L15670:GlassComponents.kt#n9ob9m");
                Modifier modifierBackground$default2 = BackgroundKt.background$default(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), Brush.Companion.m5769verticalGradient8A3gB4$default(Brush.INSTANCE, CollectionsKt.listOf((Object[]) new Color[]{Color.m5828boximpl(Color.m5837copywmQWz5c$default(Color.INSTANCE.m5875getWhite0d7_KjU(), 0.155f, 0.0f, 0.0f, 0.0f, 14, null)), Color.m5828boximpl(Color.m5837copywmQWz5c$default(Color.INSTANCE.m5875getWhite0d7_KjU(), 0.085f, 0.0f, 0.0f, 0.0f, 14, null)), Color.m5828boximpl(Color.m5837copywmQWz5c$default(Color.INSTANCE.m5875getWhite0d7_KjU(), 0.055f, 0.0f, 0.0f, 0.0f, 14, null))}), 0.0f, 0.0f, 0, 14, (Object) null), RoundedCornerShapeKt.m1756RoundedCornerShape0680j_4(Dp.m8748constructorimpl(34.0f)), 0.0f, 4, null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy8 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
                int iHashCode9 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap9 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier9 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierBackground$default2);
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
                Composer composerM4937constructorimpl9 = Updater.m4937constructorimpl(composerStartRestartGroup);
                Updater.m4945setimpl(composerM4937constructorimpl9, measurePolicyMaybeCachedBoxMeasurePolicy8, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m4945setimpl(composerM4937constructorimpl9, currentCompositionLocalMap9, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Updater.m4945setimpl(composerM4937constructorimpl9, Integer.valueOf(iHashCode9), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                Updater.m4943reconcileimpl(composerM4937constructorimpl9, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                Updater.m4945setimpl(composerM4937constructorimpl9, modifierMaterializeModifier9, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance8 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -700470138, "C312@8853L643,333@9571L322,347@9963L723,370@10758L681,393@11550L517:GlassComponents.kt#n9ob9m");
                BoxKt.Box(BackgroundKt.background$default(BlurKt.m5339blurF8QBwvs$default(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m8748constructorimpl(18.0f), null, 2, null), Brush.Companion.m5769verticalGradient8A3gB4$default(Brush.INSTANCE, CollectionsKt.listOf((Object[]) new Color[]{Color.m5828boximpl(Color.m5837copywmQWz5c$default(Color.INSTANCE.m5875getWhite0d7_KjU(), 0.11f, 0.0f, 0.0f, 0.0f, 14, null)), Color.m5828boximpl(Color.m5837copywmQWz5c$default(Color.INSTANCE.m5875getWhite0d7_KjU(), 0.06f, 0.0f, 0.0f, 0.0f, 14, null)), Color.m5828boximpl(Color.m5837copywmQWz5c$default(Color.INSTANCE.m5864getBlack0d7_KjU(), 0.035f, 0.0f, 0.0f, 0.0f, 14, null))}), 0.0f, 0.0f, 0, 14, (Object) null), RoundedCornerShapeKt.m1756RoundedCornerShape0680j_4(Dp.m8748constructorimpl(34.0f)), 0.0f, 4, null), composerStartRestartGroup, 0);
                BoxKt.Box(BackgroundKt.m647backgroundbw27NRU(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), Color.m5837copywmQWz5c$default(Color.INSTANCE.m5875getWhite0d7_KjU(), 0.055f, 0.0f, 0.0f, 0.0f, 14, null), RoundedCornerShapeKt.m1756RoundedCornerShape0680j_4(Dp.m8748constructorimpl(34.0f))), composerStartRestartGroup, 0);
                BoxKt.Box(BackgroundKt.background$default(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), Brush.Companion.m5765radialGradientP_VxKs$default(Brush.INSTANCE, CollectionsKt.listOf((Object[]) new Color[]{Color.m5828boximpl(Color.m5837copywmQWz5c$default(Color.INSTANCE.m5875getWhite0d7_KjU(), 0.095f, 0.0f, 0.0f, 0.0f, 14, null)), Color.m5828boximpl(Color.m5837copywmQWz5c$default(Color.INSTANCE.m5875getWhite0d7_KjU(), 0.038f, 0.0f, 0.0f, 0.0f, 14, null)), Color.m5828boximpl(Color.INSTANCE.m5873getTransparent0d7_KjU())}), 0L, 390.0f, 0, 10, (Object) null), RoundedCornerShapeKt.m1756RoundedCornerShape0680j_4(Dp.m8748constructorimpl(34.0f)), 0.0f, 4, null), composerStartRestartGroup, 0);
                BoxKt.Box(BackgroundKt.background$default(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), Brush.Companion.m5769verticalGradient8A3gB4$default(Brush.INSTANCE, CollectionsKt.listOf((Object[]) new Color[]{Color.m5828boximpl(Color.m5837copywmQWz5c$default(Color.INSTANCE.m5875getWhite0d7_KjU(), 0.105f, 0.0f, 0.0f, 0.0f, 14, null)), Color.m5828boximpl(Color.INSTANCE.m5873getTransparent0d7_KjU()), Color.m5828boximpl(Color.m5837copywmQWz5c$default(Color.INSTANCE.m5864getBlack0d7_KjU(), 0.04f, 0.0f, 0.0f, 0.0f, 14, null))}), 0.0f, 0.0f, 0, 14, (Object) null), RoundedCornerShapeKt.m1756RoundedCornerShape0680j_4(Dp.m8748constructorimpl(34.0f)), 0.0f, 4, null), composerStartRestartGroup, 0);
                BoxKt.Box(BackgroundKt.background$default(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), Brush.Companion.m5765radialGradientP_VxKs$default(Brush.INSTANCE, CollectionsKt.listOf((Object[]) new Color[]{Color.m5828boximpl(Color.INSTANCE.m5873getTransparent0d7_KjU()), Color.m5828boximpl(Color.m5837copywmQWz5c$default(Color.INSTANCE.m5864getBlack0d7_KjU(), 0.045f, 0.0f, 0.0f, 0.0f, 14, null))}), 0L, 250.0f, 0, 10, (Object) null), RoundedCornerShapeKt.m1756RoundedCornerShape0680j_4(Dp.m8748constructorimpl(34.0f)), 0.0f, 4, null), composerStartRestartGroup, 0);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                BoxKt.Box(BorderKt.m661borderziNgDLE(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m8748constructorimpl(1.0f), Brush.Companion.m5769verticalGradient8A3gB4$default(Brush.INSTANCE, CollectionsKt.listOf((Object[]) new Color[]{Color.m5828boximpl(Color.m5837copywmQWz5c$default(Color.INSTANCE.m5875getWhite0d7_KjU(), 0.22f, 0.0f, 0.0f, 0.0f, 14, null)), Color.m5828boximpl(Color.m5837copywmQWz5c$default(Color.INSTANCE.m5875getWhite0d7_KjU(), 0.065f, 0.0f, 0.0f, 0.0f, 14, null))}), 0.0f, 0.0f, 0, 14, (Object) null), RoundedCornerShapeKt.m1756RoundedCornerShape0680j_4(Dp.m8748constructorimpl(34.0f))), composerStartRestartGroup, 0);
                Modifier modifierM1425paddingVpY3zN4$default2 = PaddingKt.m1425paddingVpY3zN4$default(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), fM8748constructorimpl12, 0.0f, 2, null);
                Alignment.Vertical centerVertically2 = Alignment.INSTANCE.getCenterVertically();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                MeasurePolicy measurePolicyRowMeasurePolicy2 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically2, composerStartRestartGroup, 48);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
                int iHashCode10 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap10 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier10 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1425paddingVpY3zN4$default2);
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
                Composer composerM4937constructorimpl10 = Updater.m4937constructorimpl(composerStartRestartGroup);
                Updater.m4945setimpl(composerM4937constructorimpl10, measurePolicyRowMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m4945setimpl(composerM4937constructorimpl10, currentCompositionLocalMap10, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Updater.m4945setimpl(composerM4937constructorimpl10, Integer.valueOf(iHashCode10), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                Updater.m4943reconcileimpl(composerM4937constructorimpl10, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                Updater.m4945setimpl(composerM4937constructorimpl10, modifierMaterializeModifier10, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 446008607, "C447@13162L551,466@13727L552,485@14293L552:GlassComponents.kt#n9ob9m");
                Modifier modifierFillMaxHeight$default5 = SizeKt.fillMaxHeight$default(SizeKt.m1495width3ABfNKs(Modifier.INSTANCE, fM8748constructorimpl11), 0.0f, 1, null);
                Alignment center5 = Alignment.INSTANCE.getCenter();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy9 = BoxKt.maybeCachedBoxMeasurePolicy(center5, false);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
                int iHashCode11 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap11 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier11 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxHeight$default5);
                constructor4 = ComposeUiNode.INSTANCE.getConstructor();
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
                Composer composerM4937constructorimpl11 = Updater.m4937constructorimpl(composerStartRestartGroup);
                Updater.m4945setimpl(composerM4937constructorimpl11, measurePolicyMaybeCachedBoxMeasurePolicy9, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m4945setimpl(composerM4937constructorimpl11, currentCompositionLocalMap11, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Updater.m4945setimpl(composerM4937constructorimpl11, Integer.valueOf(iHashCode11), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                Updater.m4943reconcileimpl(composerM4937constructorimpl11, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                Updater.m4945setimpl(composerM4937constructorimpl11, modifierMaterializeModifier11, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance9 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1753369025, "C460@13617L64,455@13386L313:GlassComponents.kt#n9ob9m");
                if (i == 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                NavigationIconType navigationIconType6 = NavigationIconType.TICKETS;
                float fM8748constructorimpl13 = Dp.m8748constructorimpl(0.0f);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -887837141, "CC(remember):GlassComponents.kt#9igjgp");
                i7 = i11 & StylePropertiesKt.TextDirectionMask;
                if (i7 == 32) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                if (z3) {
                    function1 = onSelectedTab;
                    objRememberedValue6 = new Function0() { // from class: com.example.tickets.GlassComponentsKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return GlassComponentsKt.GlassNavigationBar$lambda$36$lambda$26$lambda$19$lambda$18$lambda$17(function1);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                } else {
                    function1 = onSelectedTab;
                    objRememberedValue6 = new Function0() { // from class: com.example.tickets.GlassComponentsKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return GlassComponentsKt.GlassNavigationBar$lambda$36$lambda$26$lambda$19$lambda$18$lambda$17(function1);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                m9297NavigationTabjIwJxvA("票夹", z2, navigationIconType6, fM8748constructorimpl13, null, (Function0) objRememberedValue6, composerStartRestartGroup, 3462, 16);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Modifier modifierFillMaxHeight$default6 = SizeKt.fillMaxHeight$default(SizeKt.m1495width3ABfNKs(Modifier.INSTANCE, fM8748constructorimpl11), 0.0f, 1, null);
                Alignment center6 = Alignment.INSTANCE.getCenter();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy10 = BoxKt.maybeCachedBoxMeasurePolicy(center6, false);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
                int iHashCode12 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap12 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier12 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxHeight$default6);
                constructor5 = ComposeUiNode.INSTANCE.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)410@16216L9:Composables.kt#9igjgp");
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor5);
                } else {
                    composerStartRestartGroup.useNode();
                }
                Composer composerM4937constructorimpl12 = Updater.m4937constructorimpl(composerStartRestartGroup);
                Updater.m4945setimpl(composerM4937constructorimpl12, measurePolicyMaybeCachedBoxMeasurePolicy10, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m4945setimpl(composerM4937constructorimpl12, currentCompositionLocalMap12, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Updater.m4945setimpl(composerM4937constructorimpl12, Integer.valueOf(iHashCode12), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                Updater.m4943reconcileimpl(composerM4937constructorimpl12, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                Updater.m4945setimpl(composerM4937constructorimpl12, modifierMaterializeModifier12, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance10 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1382315563, "C479@14183L64,474@13951L314:GlassComponents.kt#n9ob9m");
                if (i == 1) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                navigationIconType = NavigationIconType.SUBWAY;
                float fM8748constructorimpl14 = Dp.m8748constructorimpl(3.0f);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1430056972, "CC(remember):GlassComponents.kt#9igjgp");
                if (i7 == 32) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                if (z5) {
                    navigationIconType2 = navigationIconType;
                    if (objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    m9297NavigationTabjIwJxvA("智能地铁", z4, navigationIconType2, fM8748constructorimpl14, null, (Function0) objRememberedValue7, composerStartRestartGroup, 3462, 16);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Modifier modifierFillMaxHeight$default7 = SizeKt.fillMaxHeight$default(SizeKt.m1495width3ABfNKs(Modifier.INSTANCE, fM8748constructorimpl11), 0.0f, 1, null);
                    Alignment center7 = Alignment.INSTANCE.getCenter();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy11 = BoxKt.maybeCachedBoxMeasurePolicy(center7, false);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
                    int iHashCode13 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap13 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier13 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxHeight$default7);
                    constructor6 = ComposeUiNode.INSTANCE.getConstructor();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)410@16216L9:Composables.kt#9igjgp");
                    if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(constructor6);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    Composer composerM4937constructorimpl13 = Updater.m4937constructorimpl(composerStartRestartGroup);
                    Updater.m4945setimpl(composerM4937constructorimpl13, measurePolicyMaybeCachedBoxMeasurePolicy11, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m4945setimpl(composerM4937constructorimpl13, currentCompositionLocalMap13, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Updater.m4945setimpl(composerM4937constructorimpl13, Integer.valueOf(iHashCode13), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                    Updater.m4943reconcileimpl(composerM4937constructorimpl13, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                    Updater.m4945setimpl(composerM4937constructorimpl13, modifierMaterializeModifier13, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance11 = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1950287786, "C498@14749L64,493@14517L314:GlassComponents.kt#n9ob9m");
                    if (i == 2) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    NavigationIconType navigationIconType7 = NavigationIconType.SETTINGS;
                    float fM8748constructorimpl15 = Dp.m8748constructorimpl(8.0f);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1864020653, "CC(remember):GlassComponents.kt#9igjgp");
                    if (i7 == 32) {
                        z7 = true;
                    } else {
                        z7 = false;
                    }
                    objRememberedValue8 = composerStartRestartGroup.rememberedValue();
                    if (!z7) {
                        objRememberedValue8 = new Function0() { // from class: com.example.tickets.GlassComponentsKt$$ExternalSyntheticLambda6
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return GlassComponentsKt.GlassNavigationBar$lambda$36$lambda$26$lambda$25$lambda$24$lambda$23(function1);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                    } else {
                        objRememberedValue8 = new Function0() { // from class: com.example.tickets.GlassComponentsKt$$ExternalSyntheticLambda6
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return GlassComponentsKt.GlassNavigationBar$lambda$36$lambda$26$lambda$25$lambda$24$lambda$23(function1);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    m9297NavigationTabjIwJxvA("设置", z6, navigationIconType7, fM8748constructorimpl15, null, (Function0) objRememberedValue8, composerStartRestartGroup, 3462, 16);
                    composer2 = composerStartRestartGroup;
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
                    Modifier modifierM1476height3ABfNKs3 = SizeKt.m1476height3ABfNKs(SizeKt.m1495width3ABfNKs(Modifier.INSTANCE, fM8748constructorimpl11), fM8748constructorimpl2);
                    ComposerKt.sourceInformationMarkerStart(composer2, 117074604, "CC(remember):GlassComponents.kt#9igjgp");
                    zChangedInstance2 = composer2.changedInstance(animatable) | composer2.changed(density);
                    objRememberedValue9 = composer2.rememberedValue();
                    if (!zChangedInstance2) {
                        objRememberedValue9 = new Function1() { // from class: com.example.tickets.GlassComponentsKt$$ExternalSyntheticLambda7
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return GlassComponentsKt.GlassNavigationBar$lambda$36$lambda$29$lambda$28(animatable, density, fM8748constructorimpl, fM8748constructorimpl2, (Density) obj);
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue9);
                    } else {
                        objRememberedValue9 = new Function1() { // from class: com.example.tickets.GlassComponentsKt$$ExternalSyntheticLambda7
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return GlassComponentsKt.GlassNavigationBar$lambda$36$lambda$29$lambda$28(animatable, density, fM8748constructorimpl, fM8748constructorimpl2, (Density) obj);
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue9);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    Modifier modifierOffset3 = OffsetKt.offset(modifierM1476height3ABfNKs3, (Function1) objRememberedValue9);
                    ComposerKt.sourceInformationMarkerStart(composer2, 117097670, "CC(remember):GlassComponents.kt#9igjgp");
                    zChanged2 = composer2.changed(stateAnimateFloatAsState2) | composer2.changed(stateAnimateFloatAsState);
                    objRememberedValue10 = composer2.rememberedValue();
                    if (!zChanged2) {
                        objRememberedValue10 = new Function1() { // from class: com.example.tickets.GlassComponentsKt$$ExternalSyntheticLambda8
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return GlassComponentsKt.GlassNavigationBar$lambda$36$lambda$31$lambda$30(stateAnimateFloatAsState2, stateAnimateFloatAsState, (GraphicsLayerScope) obj);
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue10);
                    } else {
                        objRememberedValue10 = new Function1() { // from class: com.example.tickets.GlassComponentsKt$$ExternalSyntheticLambda8
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return GlassComponentsKt.GlassNavigationBar$lambda$36$lambda$31$lambda$30(stateAnimateFloatAsState2, stateAnimateFloatAsState, (GraphicsLayerScope) obj);
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue10);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    Modifier modifierClip5 = ClipKt.clip(GraphicsLayerModifierKt.graphicsLayer(modifierOffset3, (Function1) objRememberedValue10), RoundedCornerShapeKt.m1756RoundedCornerShape0680j_4(Dp.m8748constructorimpl(31.0f)));
                    ComposerKt.sourceInformationMarkerStart(composer2, 117127564, "CC(remember):GlassComponents.kt#9igjgp");
                    objRememberedValue11 = composer2.rememberedValue();
                    if (objRememberedValue11 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue11 = new Function1() { // from class: com.example.tickets.GlassComponentsKt$$ExternalSyntheticLambda9
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return GlassComponentsKt.GlassNavigationBar$lambda$36$lambda$34$lambda$33((CacheDrawScope) obj);
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue11);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    Modifier modifierDrawWithCache3 = DrawModifierKt.drawWithCache(modifierClip5, (Function1) objRememberedValue11);
                    Unit unit3 = Unit.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composer2, 117463263, "CC(remember):GlassComponents.kt#9igjgp");
                    boolean zChanged6 = composer2.changed(fMo803toPx0680j_4) | composer2.changed(f) | composer2.changed(fMo803toPx0680j_5) | composer2.changedInstance(animatable) | composer2.changedInstance(coroutineScope);
                    if (i7 == 32) {
                        z8 = true;
                    } else {
                        z8 = false;
                    }
                    zChanged3 = zChanged6 | z8 | composer2.changed(f2);
                    glassComponentsKt$GlassNavigationBar$3$6$1RememberedValue = composer2.rememberedValue();
                    if (zChanged3) {
                        i8 = 0;
                        glassComponentsKt$GlassNavigationBar$3$6$1RememberedValue = new GlassComponentsKt$GlassNavigationBar$3$6$1(mutableState, mutableFloatState, fMo803toPx0680j_4, f, fMo803toPx0680j_5, coroutineScope, animatable, function1, f2);
                        composer2.updateRememberedValue(glassComponentsKt$GlassNavigationBar$3$6$1RememberedValue);
                    } else {
                        i8 = 0;
                        glassComponentsKt$GlassNavigationBar$3$6$1RememberedValue = new GlassComponentsKt$GlassNavigationBar$3$6$1(mutableState, mutableFloatState, fMo803toPx0680j_4, f, fMo803toPx0680j_5, coroutineScope, animatable, function1, f2);
                        composer2.updateRememberedValue(glassComponentsKt$GlassNavigationBar$3$6$1RememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    BoxKt.Box(SuspendingPointerInputFilterKt.pointerInput(modifierDrawWithCache3, unit3, (PointerInputEventHandler) glassComponentsKt$GlassNavigationBar$3$6$1RememberedValue), composer2, i8);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    composer2.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    hazeState3 = hazeState5;
                    modifier3 = modifier5;
                } else {
                    navigationIconType2 = navigationIconType;
                }
                objRememberedValue7 = new Function0() { // from class: com.example.tickets.GlassComponentsKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return GlassComponentsKt.GlassNavigationBar$lambda$36$lambda$26$lambda$22$lambda$21$lambda$20(function1);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                m9297NavigationTabjIwJxvA("智能地铁", z4, navigationIconType2, fM8748constructorimpl14, null, (Function0) objRememberedValue7, composerStartRestartGroup, 3462, 16);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Modifier modifierFillMaxHeight$default8 = SizeKt.fillMaxHeight$default(SizeKt.m1495width3ABfNKs(Modifier.INSTANCE, fM8748constructorimpl11), 0.0f, 1, null);
                Alignment center8 = Alignment.INSTANCE.getCenter();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy12 = BoxKt.maybeCachedBoxMeasurePolicy(center8, false);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
                int iHashCode14 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap14 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier14 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxHeight$default8);
                constructor6 = ComposeUiNode.INSTANCE.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)410@16216L9:Composables.kt#9igjgp");
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
                Updater.m4945setimpl(composerM4937constructorimpl14, measurePolicyMaybeCachedBoxMeasurePolicy12, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m4945setimpl(composerM4937constructorimpl14, currentCompositionLocalMap14, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Updater.m4945setimpl(composerM4937constructorimpl14, Integer.valueOf(iHashCode14), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                Updater.m4943reconcileimpl(composerM4937constructorimpl14, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                Updater.m4945setimpl(composerM4937constructorimpl14, modifierMaterializeModifier14, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance12 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1950287786, "C498@14749L64,493@14517L314:GlassComponents.kt#n9ob9m");
                if (i == 2) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                NavigationIconType navigationIconType8 = NavigationIconType.SETTINGS;
                float fM8748constructorimpl16 = Dp.m8748constructorimpl(8.0f);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1864020653, "CC(remember):GlassComponents.kt#9igjgp");
                if (i7 == 32) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                objRememberedValue8 = composerStartRestartGroup.rememberedValue();
                if (!z7) {
                    objRememberedValue8 = new Function0() { // from class: com.example.tickets.GlassComponentsKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return GlassComponentsKt.GlassNavigationBar$lambda$36$lambda$26$lambda$25$lambda$24$lambda$23(function1);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                } else {
                    objRememberedValue8 = new Function0() { // from class: com.example.tickets.GlassComponentsKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return GlassComponentsKt.GlassNavigationBar$lambda$36$lambda$26$lambda$25$lambda$24$lambda$23(function1);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                m9297NavigationTabjIwJxvA("设置", z6, navigationIconType8, fM8748constructorimpl16, null, (Function0) objRememberedValue8, composerStartRestartGroup, 3462, 16);
                composer2 = composerStartRestartGroup;
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
                Modifier modifierM1476height3ABfNKs4 = SizeKt.m1476height3ABfNKs(SizeKt.m1495width3ABfNKs(Modifier.INSTANCE, fM8748constructorimpl11), fM8748constructorimpl2);
                ComposerKt.sourceInformationMarkerStart(composer2, 117074604, "CC(remember):GlassComponents.kt#9igjgp");
                zChangedInstance2 = composer2.changedInstance(animatable) | composer2.changed(density);
                objRememberedValue9 = composer2.rememberedValue();
                if (!zChangedInstance2) {
                    objRememberedValue9 = new Function1() { // from class: com.example.tickets.GlassComponentsKt$$ExternalSyntheticLambda7
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return GlassComponentsKt.GlassNavigationBar$lambda$36$lambda$29$lambda$28(animatable, density, fM8748constructorimpl, fM8748constructorimpl2, (Density) obj);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue9);
                } else {
                    objRememberedValue9 = new Function1() { // from class: com.example.tickets.GlassComponentsKt$$ExternalSyntheticLambda7
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return GlassComponentsKt.GlassNavigationBar$lambda$36$lambda$29$lambda$28(animatable, density, fM8748constructorimpl, fM8748constructorimpl2, (Density) obj);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue9);
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                Modifier modifierOffset4 = OffsetKt.offset(modifierM1476height3ABfNKs4, (Function1) objRememberedValue9);
                ComposerKt.sourceInformationMarkerStart(composer2, 117097670, "CC(remember):GlassComponents.kt#9igjgp");
                zChanged2 = composer2.changed(stateAnimateFloatAsState2) | composer2.changed(stateAnimateFloatAsState);
                objRememberedValue10 = composer2.rememberedValue();
                if (!zChanged2) {
                    objRememberedValue10 = new Function1() { // from class: com.example.tickets.GlassComponentsKt$$ExternalSyntheticLambda8
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return GlassComponentsKt.GlassNavigationBar$lambda$36$lambda$31$lambda$30(stateAnimateFloatAsState2, stateAnimateFloatAsState, (GraphicsLayerScope) obj);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue10);
                } else {
                    objRememberedValue10 = new Function1() { // from class: com.example.tickets.GlassComponentsKt$$ExternalSyntheticLambda8
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return GlassComponentsKt.GlassNavigationBar$lambda$36$lambda$31$lambda$30(stateAnimateFloatAsState2, stateAnimateFloatAsState, (GraphicsLayerScope) obj);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue10);
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                Modifier modifierClip6 = ClipKt.clip(GraphicsLayerModifierKt.graphicsLayer(modifierOffset4, (Function1) objRememberedValue10), RoundedCornerShapeKt.m1756RoundedCornerShape0680j_4(Dp.m8748constructorimpl(31.0f)));
                ComposerKt.sourceInformationMarkerStart(composer2, 117127564, "CC(remember):GlassComponents.kt#9igjgp");
                objRememberedValue11 = composer2.rememberedValue();
                if (objRememberedValue11 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue11 = new Function1() { // from class: com.example.tickets.GlassComponentsKt$$ExternalSyntheticLambda9
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return GlassComponentsKt.GlassNavigationBar$lambda$36$lambda$34$lambda$33((CacheDrawScope) obj);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue11);
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                Modifier modifierDrawWithCache4 = DrawModifierKt.drawWithCache(modifierClip6, (Function1) objRememberedValue11);
                Unit unit4 = Unit.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composer2, 117463263, "CC(remember):GlassComponents.kt#9igjgp");
                boolean zChanged7 = composer2.changed(fMo803toPx0680j_4) | composer2.changed(f) | composer2.changed(fMo803toPx0680j_5) | composer2.changedInstance(animatable) | composer2.changedInstance(coroutineScope);
                if (i7 == 32) {
                    z8 = true;
                } else {
                    z8 = false;
                }
                zChanged3 = zChanged7 | z8 | composer2.changed(f2);
                glassComponentsKt$GlassNavigationBar$3$6$1RememberedValue = composer2.rememberedValue();
                if (zChanged3) {
                    i8 = 0;
                    glassComponentsKt$GlassNavigationBar$3$6$1RememberedValue = new GlassComponentsKt$GlassNavigationBar$3$6$1(mutableState, mutableFloatState, fMo803toPx0680j_4, f, fMo803toPx0680j_5, coroutineScope, animatable, function1, f2);
                    composer2.updateRememberedValue(glassComponentsKt$GlassNavigationBar$3$6$1RememberedValue);
                } else {
                    i8 = 0;
                    glassComponentsKt$GlassNavigationBar$3$6$1RememberedValue = new GlassComponentsKt$GlassNavigationBar$3$6$1(mutableState, mutableFloatState, fMo803toPx0680j_4, f, fMo803toPx0680j_5, coroutineScope, animatable, function1, f2);
                    composer2.updateRememberedValue(glassComponentsKt$GlassNavigationBar$3$6$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                BoxKt.Box(SuspendingPointerInputFilterKt.pointerInput(modifierDrawWithCache4, unit4, (PointerInputEventHandler) glassComponentsKt$GlassNavigationBar$3$6$1RememberedValue), composer2, i8);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                hazeState3 = hazeState5;
                modifier3 = modifier5;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.tickets.GlassComponentsKt$$ExternalSyntheticLambda10
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return GlassComponentsKt.GlassNavigationBar$lambda$37(i, onSelectedTab, modifier3, hazeState3, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i4 |= 384;
        modifier2 = modifier;
        i5 = i3 & 8;
        if (i5 != 0) {
            if ((i2 & 3072) == 0) {
                hazeState2 = hazeState;
                if (composerStartRestartGroup.changed(hazeState2)) {
                    i6 = 2048;
                } else {
                    i6 = 1024;
                }
                i4 |= i6;
            }
            if ((i4 & 1171) != 1170) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                modifier3 = modifier2;
                hazeState3 = hazeState2;
            } else {
                if (i9 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i5 != 0) {
                    hazeState4 = null;
                } else {
                    hazeState4 = hazeState2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1610624549, i4, -1, "com.example.tickets.GlassNavigationBar (GlassComponents.kt:80)");
                }
                ProvidableCompositionLocal<Density> localDensity3 = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume3 = composerStartRestartGroup.consume(localDensity3);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                density = (Density) objConsume3;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 773894976, "CC(rememberCoroutineScope)N(getContext)763@35102L68:Effects.kt#9igjgp");
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 683736516, "CC(remember):Effects.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                coroutineScope = (CoroutineScope) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                float fM8748constructorimpl17 = Dp.m8748constructorimpl(254.0f);
                fM8748constructorimpl = Dp.m8748constructorimpl(68.0f);
                float fM8748constructorimpl18 = Dp.m8748constructorimpl(80.0f);
                fM8748constructorimpl2 = Dp.m8748constructorimpl(62.0f);
                float fM8748constructorimpl19 = Dp.m8748constructorimpl(4.0f);
                fMo803toPx0680j_4 = density.mo803toPx0680j_4(fM8748constructorimpl19);
                fMo803toPx0680j_5 = density.mo803toPx0680j_4(Dp.m8748constructorimpl(Dp.m8748constructorimpl(fM8748constructorimpl17 - fM8748constructorimpl18) - fM8748constructorimpl19));
                f = (fMo803toPx0680j_4 + fMo803toPx0680j_5) / 2.0f;
                if (i != 0) {
                    f = fMo803toPx0680j_4;
                } else if (i != 1) {
                    f = fMo803toPx0680j_5;
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1621932434, "CC(remember):GlassComponents.kt#9igjgp");
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                int i12 = i4;
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = AnimatableKt.Animatable$default(f, 0.0f, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                animatable = (Animatable) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1621929109, "CC(remember):GlassComponents.kt#9igjgp");
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue3 = PrimitiveSnapshotStateKt.mutableFloatStateOf(0.0f);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                mutableFloatState = (MutableFloatState) objRememberedValue3;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1621925879, "CC(remember):GlassComponents.kt#9igjgp");
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                mutableState = (MutableState) objRememberedValue4;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                fCoerceIn = RangesKt.coerceIn(Math.abs(GlassNavigationBar$lambda$4(mutableFloatState)) / 180.0f, 0.0f, 0.09f);
                if (!GlassNavigationBar$lambda$7(mutableState)) {
                    fCoerceIn = 0.0f;
                }
                f2 = f;
                stateAnimateFloatAsState = AnimateAsStateKt.animateFloatAsState(fCoerceIn, AnimationSpecKt.spring$default(0.78f, 650.0f, null, 4, null), 0.0f, "bubbleStretch", null, composerStartRestartGroup, 3120, 20);
                if (GlassNavigationBar$lambda$7(mutableState)) {
                    f3 = 1.055f;
                } else {
                    f3 = 1.0f;
                }
                stateAnimateFloatAsState2 = AnimateAsStateKt.animateFloatAsState(f3, AnimationSpecKt.spring$default(0.84f, 760.0f, null, 4, null), 0.0f, "bubblePressScale", null, composerStartRestartGroup, 3120, 20);
                float fMo803toPx0680j_8 = density.mo803toPx0680j_4(Dp.m8748constructorimpl(5.0f));
                fCoerceIn2 = RangesKt.coerceIn(GlassNavigationBar$lambda$4(mutableFloatState) * 0.22f, -fMo803toPx0680j_8, fMo803toPx0680j_8);
                if (GlassNavigationBar$lambda$7(mutableState)) {
                    f4 = fCoerceIn2;
                } else {
                    f4 = 0.0f;
                }
                stateAnimateFloatAsState3 = AnimateAsStateKt.animateFloatAsState(f4, AnimationSpecKt.spring$default(0.86f, 520.0f, null, 4, null), 0.0f, "navigationSway", null, composerStartRestartGroup, 3120, 20);
                Integer numValueOf3 = Integer.valueOf(i);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1621862892, "CC(remember):GlassComponents.kt#9igjgp");
                zChangedInstance = composerStartRestartGroup.changedInstance(animatable) | composerStartRestartGroup.changed(f2);
                glassComponentsKt$GlassNavigationBar$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (!zChangedInstance) {
                    glassComponentsKt$GlassNavigationBar$1$1RememberedValue = new GlassComponentsKt$GlassNavigationBar$1$1(animatable, f2, mutableState, null);
                    composerStartRestartGroup.updateRememberedValue(glassComponentsKt$GlassNavigationBar$1$1RememberedValue);
                } else {
                    glassComponentsKt$GlassNavigationBar$1$1RememberedValue = new GlassComponentsKt$GlassNavigationBar$1$1(animatable, f2, mutableState, null);
                    composerStartRestartGroup.updateRememberedValue(glassComponentsKt$GlassNavigationBar$1$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                EffectsKt.LaunchedEffect(numValueOf3, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) glassComponentsKt$GlassNavigationBar$1$1RememberedValue, composerStartRestartGroup, i12 & 14);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1621847130, "CC(remember):GlassComponents.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(stateAnimateFloatAsState3);
                objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    objRememberedValue5 = new Function1() { // from class: com.example.tickets.GlassComponentsKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return GlassComponentsKt.GlassNavigationBar$lambda$15$lambda$14(stateAnimateFloatAsState3, (Density) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                } else {
                    objRememberedValue5 = new Function1() { // from class: com.example.tickets.GlassComponentsKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return GlassComponentsKt.GlassNavigationBar$lambda$15$lambda$14(stateAnimateFloatAsState3, (Density) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Modifier modifierClip7 = ClipKt.clip(SizeKt.m1476height3ABfNKs(SizeKt.m1495width3ABfNKs(OffsetKt.offset(companion, (Function1) objRememberedValue5), fM8748constructorimpl17), fM8748constructorimpl), RoundedCornerShapeKt.m1756RoundedCornerShape0680j_4(Dp.m8748constructorimpl(34.0f)));
                if (hazeState4 != null) {
                    HazeState hazeState8 = hazeState4;
                    companionHazeEffect$default = HazeChildKt.hazeEffect$default(Modifier.INSTANCE, hazeState8, new HazeStyle(Color.INSTANCE.m5873getTransparent0d7_KjU(), new HazeTint(Color.m5837copywmQWz5c$default(Color.INSTANCE.m5875getWhite0d7_KjU(), 0.16f, 0.0f, 0.0f, 0.0f, 14, null), 0, 2, (DefaultConstructorMarker) null), Dp.m8748constructorimpl(30.0f), 0.0f, (HazeTint) null, 24, (DefaultConstructorMarker) null), null, 4, null);
                    hazeState5 = hazeState8;
                } else {
                    hazeState5 = hazeState4;
                    companionHazeEffect$default = Modifier.INSTANCE;
                }
                Modifier modifierThen3 = modifierClip7.then(companionHazeEffect$default);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy13 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
                int iHashCode15 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap15 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier15 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierThen3);
                Modifier modifier6 = companion;
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
                Updater.m4945setimpl(composerM4937constructorimpl15, measurePolicyMaybeCachedBoxMeasurePolicy13, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m4945setimpl(composerM4937constructorimpl15, currentCompositionLocalMap15, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Updater.m4945setimpl(composerM4937constructorimpl15, Integer.valueOf(iHashCode15), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                Updater.m4943reconcileimpl(composerM4937constructorimpl15, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                Updater.m4945setimpl(composerM4937constructorimpl15, modifierMaterializeModifier15, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance13 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -671913841, "C292@8191L3886,412@12128L596,437@12904L1951,515@15183L695,535@15910L497,557@16526L10679,844@27242L3466,511@15048L15670:GlassComponents.kt#n9ob9m");
                Modifier modifierBackground$default3 = BackgroundKt.background$default(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), Brush.Companion.m5769verticalGradient8A3gB4$default(Brush.INSTANCE, CollectionsKt.listOf((Object[]) new Color[]{Color.m5828boximpl(Color.m5837copywmQWz5c$default(Color.INSTANCE.m5875getWhite0d7_KjU(), 0.155f, 0.0f, 0.0f, 0.0f, 14, null)), Color.m5828boximpl(Color.m5837copywmQWz5c$default(Color.INSTANCE.m5875getWhite0d7_KjU(), 0.085f, 0.0f, 0.0f, 0.0f, 14, null)), Color.m5828boximpl(Color.m5837copywmQWz5c$default(Color.INSTANCE.m5875getWhite0d7_KjU(), 0.055f, 0.0f, 0.0f, 0.0f, 14, null))}), 0.0f, 0.0f, 0, 14, (Object) null), RoundedCornerShapeKt.m1756RoundedCornerShape0680j_4(Dp.m8748constructorimpl(34.0f)), 0.0f, 4, null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy14 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
                int iHashCode16 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap16 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier16 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierBackground$default3);
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
                Composer composerM4937constructorimpl16 = Updater.m4937constructorimpl(composerStartRestartGroup);
                Updater.m4945setimpl(composerM4937constructorimpl16, measurePolicyMaybeCachedBoxMeasurePolicy14, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m4945setimpl(composerM4937constructorimpl16, currentCompositionLocalMap16, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Updater.m4945setimpl(composerM4937constructorimpl16, Integer.valueOf(iHashCode16), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                Updater.m4943reconcileimpl(composerM4937constructorimpl16, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                Updater.m4945setimpl(composerM4937constructorimpl16, modifierMaterializeModifier16, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance14 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -700470138, "C312@8853L643,333@9571L322,347@9963L723,370@10758L681,393@11550L517:GlassComponents.kt#n9ob9m");
                BoxKt.Box(BackgroundKt.background$default(BlurKt.m5339blurF8QBwvs$default(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m8748constructorimpl(18.0f), null, 2, null), Brush.Companion.m5769verticalGradient8A3gB4$default(Brush.INSTANCE, CollectionsKt.listOf((Object[]) new Color[]{Color.m5828boximpl(Color.m5837copywmQWz5c$default(Color.INSTANCE.m5875getWhite0d7_KjU(), 0.11f, 0.0f, 0.0f, 0.0f, 14, null)), Color.m5828boximpl(Color.m5837copywmQWz5c$default(Color.INSTANCE.m5875getWhite0d7_KjU(), 0.06f, 0.0f, 0.0f, 0.0f, 14, null)), Color.m5828boximpl(Color.m5837copywmQWz5c$default(Color.INSTANCE.m5864getBlack0d7_KjU(), 0.035f, 0.0f, 0.0f, 0.0f, 14, null))}), 0.0f, 0.0f, 0, 14, (Object) null), RoundedCornerShapeKt.m1756RoundedCornerShape0680j_4(Dp.m8748constructorimpl(34.0f)), 0.0f, 4, null), composerStartRestartGroup, 0);
                BoxKt.Box(BackgroundKt.m647backgroundbw27NRU(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), Color.m5837copywmQWz5c$default(Color.INSTANCE.m5875getWhite0d7_KjU(), 0.055f, 0.0f, 0.0f, 0.0f, 14, null), RoundedCornerShapeKt.m1756RoundedCornerShape0680j_4(Dp.m8748constructorimpl(34.0f))), composerStartRestartGroup, 0);
                BoxKt.Box(BackgroundKt.background$default(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), Brush.Companion.m5765radialGradientP_VxKs$default(Brush.INSTANCE, CollectionsKt.listOf((Object[]) new Color[]{Color.m5828boximpl(Color.m5837copywmQWz5c$default(Color.INSTANCE.m5875getWhite0d7_KjU(), 0.095f, 0.0f, 0.0f, 0.0f, 14, null)), Color.m5828boximpl(Color.m5837copywmQWz5c$default(Color.INSTANCE.m5875getWhite0d7_KjU(), 0.038f, 0.0f, 0.0f, 0.0f, 14, null)), Color.m5828boximpl(Color.INSTANCE.m5873getTransparent0d7_KjU())}), 0L, 390.0f, 0, 10, (Object) null), RoundedCornerShapeKt.m1756RoundedCornerShape0680j_4(Dp.m8748constructorimpl(34.0f)), 0.0f, 4, null), composerStartRestartGroup, 0);
                BoxKt.Box(BackgroundKt.background$default(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), Brush.Companion.m5769verticalGradient8A3gB4$default(Brush.INSTANCE, CollectionsKt.listOf((Object[]) new Color[]{Color.m5828boximpl(Color.m5837copywmQWz5c$default(Color.INSTANCE.m5875getWhite0d7_KjU(), 0.105f, 0.0f, 0.0f, 0.0f, 14, null)), Color.m5828boximpl(Color.INSTANCE.m5873getTransparent0d7_KjU()), Color.m5828boximpl(Color.m5837copywmQWz5c$default(Color.INSTANCE.m5864getBlack0d7_KjU(), 0.04f, 0.0f, 0.0f, 0.0f, 14, null))}), 0.0f, 0.0f, 0, 14, (Object) null), RoundedCornerShapeKt.m1756RoundedCornerShape0680j_4(Dp.m8748constructorimpl(34.0f)), 0.0f, 4, null), composerStartRestartGroup, 0);
                BoxKt.Box(BackgroundKt.background$default(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), Brush.Companion.m5765radialGradientP_VxKs$default(Brush.INSTANCE, CollectionsKt.listOf((Object[]) new Color[]{Color.m5828boximpl(Color.INSTANCE.m5873getTransparent0d7_KjU()), Color.m5828boximpl(Color.m5837copywmQWz5c$default(Color.INSTANCE.m5864getBlack0d7_KjU(), 0.045f, 0.0f, 0.0f, 0.0f, 14, null))}), 0L, 250.0f, 0, 10, (Object) null), RoundedCornerShapeKt.m1756RoundedCornerShape0680j_4(Dp.m8748constructorimpl(34.0f)), 0.0f, 4, null), composerStartRestartGroup, 0);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                BoxKt.Box(BorderKt.m661borderziNgDLE(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m8748constructorimpl(1.0f), Brush.Companion.m5769verticalGradient8A3gB4$default(Brush.INSTANCE, CollectionsKt.listOf((Object[]) new Color[]{Color.m5828boximpl(Color.m5837copywmQWz5c$default(Color.INSTANCE.m5875getWhite0d7_KjU(), 0.22f, 0.0f, 0.0f, 0.0f, 14, null)), Color.m5828boximpl(Color.m5837copywmQWz5c$default(Color.INSTANCE.m5875getWhite0d7_KjU(), 0.065f, 0.0f, 0.0f, 0.0f, 14, null))}), 0.0f, 0.0f, 0, 14, (Object) null), RoundedCornerShapeKt.m1756RoundedCornerShape0680j_4(Dp.m8748constructorimpl(34.0f))), composerStartRestartGroup, 0);
                Modifier modifierM1425paddingVpY3zN4$default3 = PaddingKt.m1425paddingVpY3zN4$default(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), fM8748constructorimpl19, 0.0f, 2, null);
                Alignment.Vertical centerVertically3 = Alignment.INSTANCE.getCenterVertically();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                MeasurePolicy measurePolicyRowMeasurePolicy3 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically3, composerStartRestartGroup, 48);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
                int iHashCode17 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap17 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier17 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1425paddingVpY3zN4$default3);
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
                Composer composerM4937constructorimpl17 = Updater.m4937constructorimpl(composerStartRestartGroup);
                Updater.m4945setimpl(composerM4937constructorimpl17, measurePolicyRowMeasurePolicy3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m4945setimpl(composerM4937constructorimpl17, currentCompositionLocalMap17, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Updater.m4945setimpl(composerM4937constructorimpl17, Integer.valueOf(iHashCode17), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                Updater.m4943reconcileimpl(composerM4937constructorimpl17, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                Updater.m4945setimpl(composerM4937constructorimpl17, modifierMaterializeModifier17, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                RowScopeInstance rowScopeInstance3 = RowScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 446008607, "C447@13162L551,466@13727L552,485@14293L552:GlassComponents.kt#n9ob9m");
                Modifier modifierFillMaxHeight$default9 = SizeKt.fillMaxHeight$default(SizeKt.m1495width3ABfNKs(Modifier.INSTANCE, fM8748constructorimpl18), 0.0f, 1, null);
                Alignment center9 = Alignment.INSTANCE.getCenter();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy15 = BoxKt.maybeCachedBoxMeasurePolicy(center9, false);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
                int iHashCode18 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap18 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier18 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxHeight$default9);
                constructor4 = ComposeUiNode.INSTANCE.getConstructor();
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
                Composer composerM4937constructorimpl18 = Updater.m4937constructorimpl(composerStartRestartGroup);
                Updater.m4945setimpl(composerM4937constructorimpl18, measurePolicyMaybeCachedBoxMeasurePolicy15, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m4945setimpl(composerM4937constructorimpl18, currentCompositionLocalMap18, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Updater.m4945setimpl(composerM4937constructorimpl18, Integer.valueOf(iHashCode18), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                Updater.m4943reconcileimpl(composerM4937constructorimpl18, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                Updater.m4945setimpl(composerM4937constructorimpl18, modifierMaterializeModifier18, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance15 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1753369025, "C460@13617L64,455@13386L313:GlassComponents.kt#n9ob9m");
                if (i == 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                NavigationIconType navigationIconType9 = NavigationIconType.TICKETS;
                float fM8748constructorimpl110 = Dp.m8748constructorimpl(0.0f);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -887837141, "CC(remember):GlassComponents.kt#9igjgp");
                i7 = i12 & StylePropertiesKt.TextDirectionMask;
                if (i7 == 32) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                if (z3) {
                    function1 = onSelectedTab;
                    objRememberedValue6 = new Function0() { // from class: com.example.tickets.GlassComponentsKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return GlassComponentsKt.GlassNavigationBar$lambda$36$lambda$26$lambda$19$lambda$18$lambda$17(function1);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                } else {
                    function1 = onSelectedTab;
                    objRememberedValue6 = new Function0() { // from class: com.example.tickets.GlassComponentsKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return GlassComponentsKt.GlassNavigationBar$lambda$36$lambda$26$lambda$19$lambda$18$lambda$17(function1);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                m9297NavigationTabjIwJxvA("票夹", z2, navigationIconType9, fM8748constructorimpl110, null, (Function0) objRememberedValue6, composerStartRestartGroup, 3462, 16);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Modifier modifierFillMaxHeight$default10 = SizeKt.fillMaxHeight$default(SizeKt.m1495width3ABfNKs(Modifier.INSTANCE, fM8748constructorimpl18), 0.0f, 1, null);
                Alignment center10 = Alignment.INSTANCE.getCenter();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy16 = BoxKt.maybeCachedBoxMeasurePolicy(center10, false);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
                int iHashCode19 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap19 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier19 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxHeight$default10);
                constructor5 = ComposeUiNode.INSTANCE.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)410@16216L9:Composables.kt#9igjgp");
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor5);
                } else {
                    composerStartRestartGroup.useNode();
                }
                Composer composerM4937constructorimpl19 = Updater.m4937constructorimpl(composerStartRestartGroup);
                Updater.m4945setimpl(composerM4937constructorimpl19, measurePolicyMaybeCachedBoxMeasurePolicy16, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m4945setimpl(composerM4937constructorimpl19, currentCompositionLocalMap19, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Updater.m4945setimpl(composerM4937constructorimpl19, Integer.valueOf(iHashCode19), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                Updater.m4943reconcileimpl(composerM4937constructorimpl19, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                Updater.m4945setimpl(composerM4937constructorimpl19, modifierMaterializeModifier19, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance16 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1382315563, "C479@14183L64,474@13951L314:GlassComponents.kt#n9ob9m");
                if (i == 1) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                navigationIconType = NavigationIconType.SUBWAY;
                float fM8748constructorimpl111 = Dp.m8748constructorimpl(3.0f);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1430056972, "CC(remember):GlassComponents.kt#9igjgp");
                if (i7 == 32) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                if (z5) {
                    navigationIconType2 = navigationIconType;
                    if (objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    m9297NavigationTabjIwJxvA("智能地铁", z4, navigationIconType2, fM8748constructorimpl111, null, (Function0) objRememberedValue7, composerStartRestartGroup, 3462, 16);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Modifier modifierFillMaxHeight$default11 = SizeKt.fillMaxHeight$default(SizeKt.m1495width3ABfNKs(Modifier.INSTANCE, fM8748constructorimpl18), 0.0f, 1, null);
                    Alignment center11 = Alignment.INSTANCE.getCenter();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy17 = BoxKt.maybeCachedBoxMeasurePolicy(center11, false);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
                    int iHashCode110 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap110 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier110 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxHeight$default11);
                    constructor6 = ComposeUiNode.INSTANCE.getConstructor();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)410@16216L9:Composables.kt#9igjgp");
                    if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(constructor6);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    Composer composerM4937constructorimpl110 = Updater.m4937constructorimpl(composerStartRestartGroup);
                    Updater.m4945setimpl(composerM4937constructorimpl110, measurePolicyMaybeCachedBoxMeasurePolicy17, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m4945setimpl(composerM4937constructorimpl110, currentCompositionLocalMap110, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Updater.m4945setimpl(composerM4937constructorimpl110, Integer.valueOf(iHashCode110), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                    Updater.m4943reconcileimpl(composerM4937constructorimpl110, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                    Updater.m4945setimpl(composerM4937constructorimpl110, modifierMaterializeModifier110, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance17 = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1950287786, "C498@14749L64,493@14517L314:GlassComponents.kt#n9ob9m");
                    if (i == 2) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    NavigationIconType navigationIconType10 = NavigationIconType.SETTINGS;
                    float fM8748constructorimpl112 = Dp.m8748constructorimpl(8.0f);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1864020653, "CC(remember):GlassComponents.kt#9igjgp");
                    if (i7 == 32) {
                        z7 = true;
                    } else {
                        z7 = false;
                    }
                    objRememberedValue8 = composerStartRestartGroup.rememberedValue();
                    if (!z7) {
                        objRememberedValue8 = new Function0() { // from class: com.example.tickets.GlassComponentsKt$$ExternalSyntheticLambda6
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return GlassComponentsKt.GlassNavigationBar$lambda$36$lambda$26$lambda$25$lambda$24$lambda$23(function1);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                    } else {
                        objRememberedValue8 = new Function0() { // from class: com.example.tickets.GlassComponentsKt$$ExternalSyntheticLambda6
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return GlassComponentsKt.GlassNavigationBar$lambda$36$lambda$26$lambda$25$lambda$24$lambda$23(function1);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    m9297NavigationTabjIwJxvA("设置", z6, navigationIconType10, fM8748constructorimpl112, null, (Function0) objRememberedValue8, composerStartRestartGroup, 3462, 16);
                    composer2 = composerStartRestartGroup;
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
                    Modifier modifierM1476height3ABfNKs5 = SizeKt.m1476height3ABfNKs(SizeKt.m1495width3ABfNKs(Modifier.INSTANCE, fM8748constructorimpl18), fM8748constructorimpl2);
                    ComposerKt.sourceInformationMarkerStart(composer2, 117074604, "CC(remember):GlassComponents.kt#9igjgp");
                    zChangedInstance2 = composer2.changedInstance(animatable) | composer2.changed(density);
                    objRememberedValue9 = composer2.rememberedValue();
                    if (!zChangedInstance2) {
                        objRememberedValue9 = new Function1() { // from class: com.example.tickets.GlassComponentsKt$$ExternalSyntheticLambda7
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return GlassComponentsKt.GlassNavigationBar$lambda$36$lambda$29$lambda$28(animatable, density, fM8748constructorimpl, fM8748constructorimpl2, (Density) obj);
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue9);
                    } else {
                        objRememberedValue9 = new Function1() { // from class: com.example.tickets.GlassComponentsKt$$ExternalSyntheticLambda7
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return GlassComponentsKt.GlassNavigationBar$lambda$36$lambda$29$lambda$28(animatable, density, fM8748constructorimpl, fM8748constructorimpl2, (Density) obj);
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue9);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    Modifier modifierOffset5 = OffsetKt.offset(modifierM1476height3ABfNKs5, (Function1) objRememberedValue9);
                    ComposerKt.sourceInformationMarkerStart(composer2, 117097670, "CC(remember):GlassComponents.kt#9igjgp");
                    zChanged2 = composer2.changed(stateAnimateFloatAsState2) | composer2.changed(stateAnimateFloatAsState);
                    objRememberedValue10 = composer2.rememberedValue();
                    if (!zChanged2) {
                        objRememberedValue10 = new Function1() { // from class: com.example.tickets.GlassComponentsKt$$ExternalSyntheticLambda8
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return GlassComponentsKt.GlassNavigationBar$lambda$36$lambda$31$lambda$30(stateAnimateFloatAsState2, stateAnimateFloatAsState, (GraphicsLayerScope) obj);
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue10);
                    } else {
                        objRememberedValue10 = new Function1() { // from class: com.example.tickets.GlassComponentsKt$$ExternalSyntheticLambda8
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return GlassComponentsKt.GlassNavigationBar$lambda$36$lambda$31$lambda$30(stateAnimateFloatAsState2, stateAnimateFloatAsState, (GraphicsLayerScope) obj);
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue10);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    Modifier modifierClip8 = ClipKt.clip(GraphicsLayerModifierKt.graphicsLayer(modifierOffset5, (Function1) objRememberedValue10), RoundedCornerShapeKt.m1756RoundedCornerShape0680j_4(Dp.m8748constructorimpl(31.0f)));
                    ComposerKt.sourceInformationMarkerStart(composer2, 117127564, "CC(remember):GlassComponents.kt#9igjgp");
                    objRememberedValue11 = composer2.rememberedValue();
                    if (objRememberedValue11 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue11 = new Function1() { // from class: com.example.tickets.GlassComponentsKt$$ExternalSyntheticLambda9
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return GlassComponentsKt.GlassNavigationBar$lambda$36$lambda$34$lambda$33((CacheDrawScope) obj);
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue11);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    Modifier modifierDrawWithCache5 = DrawModifierKt.drawWithCache(modifierClip8, (Function1) objRememberedValue11);
                    Unit unit5 = Unit.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composer2, 117463263, "CC(remember):GlassComponents.kt#9igjgp");
                    boolean zChanged8 = composer2.changed(fMo803toPx0680j_4) | composer2.changed(f) | composer2.changed(fMo803toPx0680j_5) | composer2.changedInstance(animatable) | composer2.changedInstance(coroutineScope);
                    if (i7 == 32) {
                        z8 = true;
                    } else {
                        z8 = false;
                    }
                    zChanged3 = zChanged8 | z8 | composer2.changed(f2);
                    glassComponentsKt$GlassNavigationBar$3$6$1RememberedValue = composer2.rememberedValue();
                    if (zChanged3) {
                        i8 = 0;
                        glassComponentsKt$GlassNavigationBar$3$6$1RememberedValue = new GlassComponentsKt$GlassNavigationBar$3$6$1(mutableState, mutableFloatState, fMo803toPx0680j_4, f, fMo803toPx0680j_5, coroutineScope, animatable, function1, f2);
                        composer2.updateRememberedValue(glassComponentsKt$GlassNavigationBar$3$6$1RememberedValue);
                    } else {
                        i8 = 0;
                        glassComponentsKt$GlassNavigationBar$3$6$1RememberedValue = new GlassComponentsKt$GlassNavigationBar$3$6$1(mutableState, mutableFloatState, fMo803toPx0680j_4, f, fMo803toPx0680j_5, coroutineScope, animatable, function1, f2);
                        composer2.updateRememberedValue(glassComponentsKt$GlassNavigationBar$3$6$1RememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    BoxKt.Box(SuspendingPointerInputFilterKt.pointerInput(modifierDrawWithCache5, unit5, (PointerInputEventHandler) glassComponentsKt$GlassNavigationBar$3$6$1RememberedValue), composer2, i8);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    composer2.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    hazeState3 = hazeState5;
                    modifier3 = modifier6;
                } else {
                    navigationIconType2 = navigationIconType;
                }
                objRememberedValue7 = new Function0() { // from class: com.example.tickets.GlassComponentsKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return GlassComponentsKt.GlassNavigationBar$lambda$36$lambda$26$lambda$22$lambda$21$lambda$20(function1);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                m9297NavigationTabjIwJxvA("智能地铁", z4, navigationIconType2, fM8748constructorimpl111, null, (Function0) objRememberedValue7, composerStartRestartGroup, 3462, 16);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Modifier modifierFillMaxHeight$default12 = SizeKt.fillMaxHeight$default(SizeKt.m1495width3ABfNKs(Modifier.INSTANCE, fM8748constructorimpl18), 0.0f, 1, null);
                Alignment center12 = Alignment.INSTANCE.getCenter();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy18 = BoxKt.maybeCachedBoxMeasurePolicy(center12, false);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
                int iHashCode111 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap111 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier111 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxHeight$default12);
                constructor6 = ComposeUiNode.INSTANCE.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)410@16216L9:Composables.kt#9igjgp");
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor6);
                } else {
                    composerStartRestartGroup.useNode();
                }
                Composer composerM4937constructorimpl111 = Updater.m4937constructorimpl(composerStartRestartGroup);
                Updater.m4945setimpl(composerM4937constructorimpl111, measurePolicyMaybeCachedBoxMeasurePolicy18, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m4945setimpl(composerM4937constructorimpl111, currentCompositionLocalMap111, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Updater.m4945setimpl(composerM4937constructorimpl111, Integer.valueOf(iHashCode111), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                Updater.m4943reconcileimpl(composerM4937constructorimpl111, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                Updater.m4945setimpl(composerM4937constructorimpl111, modifierMaterializeModifier111, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance18 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1950287786, "C498@14749L64,493@14517L314:GlassComponents.kt#n9ob9m");
                if (i == 2) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                NavigationIconType navigationIconType11 = NavigationIconType.SETTINGS;
                float fM8748constructorimpl113 = Dp.m8748constructorimpl(8.0f);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1864020653, "CC(remember):GlassComponents.kt#9igjgp");
                if (i7 == 32) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                objRememberedValue8 = composerStartRestartGroup.rememberedValue();
                if (!z7) {
                    objRememberedValue8 = new Function0() { // from class: com.example.tickets.GlassComponentsKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return GlassComponentsKt.GlassNavigationBar$lambda$36$lambda$26$lambda$25$lambda$24$lambda$23(function1);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                } else {
                    objRememberedValue8 = new Function0() { // from class: com.example.tickets.GlassComponentsKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return GlassComponentsKt.GlassNavigationBar$lambda$36$lambda$26$lambda$25$lambda$24$lambda$23(function1);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                m9297NavigationTabjIwJxvA("设置", z6, navigationIconType11, fM8748constructorimpl113, null, (Function0) objRememberedValue8, composerStartRestartGroup, 3462, 16);
                composer2 = composerStartRestartGroup;
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
                Modifier modifierM1476height3ABfNKs6 = SizeKt.m1476height3ABfNKs(SizeKt.m1495width3ABfNKs(Modifier.INSTANCE, fM8748constructorimpl18), fM8748constructorimpl2);
                ComposerKt.sourceInformationMarkerStart(composer2, 117074604, "CC(remember):GlassComponents.kt#9igjgp");
                zChangedInstance2 = composer2.changedInstance(animatable) | composer2.changed(density);
                objRememberedValue9 = composer2.rememberedValue();
                if (!zChangedInstance2) {
                    objRememberedValue9 = new Function1() { // from class: com.example.tickets.GlassComponentsKt$$ExternalSyntheticLambda7
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return GlassComponentsKt.GlassNavigationBar$lambda$36$lambda$29$lambda$28(animatable, density, fM8748constructorimpl, fM8748constructorimpl2, (Density) obj);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue9);
                } else {
                    objRememberedValue9 = new Function1() { // from class: com.example.tickets.GlassComponentsKt$$ExternalSyntheticLambda7
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return GlassComponentsKt.GlassNavigationBar$lambda$36$lambda$29$lambda$28(animatable, density, fM8748constructorimpl, fM8748constructorimpl2, (Density) obj);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue9);
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                Modifier modifierOffset6 = OffsetKt.offset(modifierM1476height3ABfNKs6, (Function1) objRememberedValue9);
                ComposerKt.sourceInformationMarkerStart(composer2, 117097670, "CC(remember):GlassComponents.kt#9igjgp");
                zChanged2 = composer2.changed(stateAnimateFloatAsState2) | composer2.changed(stateAnimateFloatAsState);
                objRememberedValue10 = composer2.rememberedValue();
                if (!zChanged2) {
                    objRememberedValue10 = new Function1() { // from class: com.example.tickets.GlassComponentsKt$$ExternalSyntheticLambda8
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return GlassComponentsKt.GlassNavigationBar$lambda$36$lambda$31$lambda$30(stateAnimateFloatAsState2, stateAnimateFloatAsState, (GraphicsLayerScope) obj);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue10);
                } else {
                    objRememberedValue10 = new Function1() { // from class: com.example.tickets.GlassComponentsKt$$ExternalSyntheticLambda8
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return GlassComponentsKt.GlassNavigationBar$lambda$36$lambda$31$lambda$30(stateAnimateFloatAsState2, stateAnimateFloatAsState, (GraphicsLayerScope) obj);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue10);
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                Modifier modifierClip9 = ClipKt.clip(GraphicsLayerModifierKt.graphicsLayer(modifierOffset6, (Function1) objRememberedValue10), RoundedCornerShapeKt.m1756RoundedCornerShape0680j_4(Dp.m8748constructorimpl(31.0f)));
                ComposerKt.sourceInformationMarkerStart(composer2, 117127564, "CC(remember):GlassComponents.kt#9igjgp");
                objRememberedValue11 = composer2.rememberedValue();
                if (objRememberedValue11 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue11 = new Function1() { // from class: com.example.tickets.GlassComponentsKt$$ExternalSyntheticLambda9
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return GlassComponentsKt.GlassNavigationBar$lambda$36$lambda$34$lambda$33((CacheDrawScope) obj);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue11);
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                Modifier modifierDrawWithCache6 = DrawModifierKt.drawWithCache(modifierClip9, (Function1) objRememberedValue11);
                Unit unit6 = Unit.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composer2, 117463263, "CC(remember):GlassComponents.kt#9igjgp");
                boolean zChanged9 = composer2.changed(fMo803toPx0680j_4) | composer2.changed(f) | composer2.changed(fMo803toPx0680j_5) | composer2.changedInstance(animatable) | composer2.changedInstance(coroutineScope);
                if (i7 == 32) {
                    z8 = true;
                } else {
                    z8 = false;
                }
                zChanged3 = zChanged9 | z8 | composer2.changed(f2);
                glassComponentsKt$GlassNavigationBar$3$6$1RememberedValue = composer2.rememberedValue();
                if (zChanged3) {
                    i8 = 0;
                    glassComponentsKt$GlassNavigationBar$3$6$1RememberedValue = new GlassComponentsKt$GlassNavigationBar$3$6$1(mutableState, mutableFloatState, fMo803toPx0680j_4, f, fMo803toPx0680j_5, coroutineScope, animatable, function1, f2);
                    composer2.updateRememberedValue(glassComponentsKt$GlassNavigationBar$3$6$1RememberedValue);
                } else {
                    i8 = 0;
                    glassComponentsKt$GlassNavigationBar$3$6$1RememberedValue = new GlassComponentsKt$GlassNavigationBar$3$6$1(mutableState, mutableFloatState, fMo803toPx0680j_4, f, fMo803toPx0680j_5, coroutineScope, animatable, function1, f2);
                    composer2.updateRememberedValue(glassComponentsKt$GlassNavigationBar$3$6$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                BoxKt.Box(SuspendingPointerInputFilterKt.pointerInput(modifierDrawWithCache6, unit6, (PointerInputEventHandler) glassComponentsKt$GlassNavigationBar$3$6$1RememberedValue), composer2, i8);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                hazeState3 = hazeState5;
                modifier3 = modifier6;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.tickets.GlassComponentsKt$$ExternalSyntheticLambda10
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return GlassComponentsKt.GlassNavigationBar$lambda$37(i, onSelectedTab, modifier3, hazeState3, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i4 |= 3072;
        hazeState2 = hazeState;
        if ((i4 & 1171) != 1170) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            modifier3 = modifier2;
            hazeState3 = hazeState2;
        } else {
            if (i9 != 0) {
                companion = Modifier.INSTANCE;
            } else {
                companion = modifier2;
            }
            if (i5 != 0) {
                hazeState4 = null;
            } else {
                hazeState4 = hazeState2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1610624549, i4, -1, "com.example.tickets.GlassNavigationBar (GlassComponents.kt:80)");
            }
            ProvidableCompositionLocal<Density> localDensity4 = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume4 = composerStartRestartGroup.consume(localDensity4);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            density = (Density) objConsume4;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 773894976, "CC(rememberCoroutineScope)N(getContext)763@35102L68:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 683736516, "CC(remember):Effects.kt#9igjgp");
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            coroutineScope = (CoroutineScope) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            float fM8748constructorimpl114 = Dp.m8748constructorimpl(254.0f);
            fM8748constructorimpl = Dp.m8748constructorimpl(68.0f);
            float fM8748constructorimpl115 = Dp.m8748constructorimpl(80.0f);
            fM8748constructorimpl2 = Dp.m8748constructorimpl(62.0f);
            float fM8748constructorimpl116 = Dp.m8748constructorimpl(4.0f);
            fMo803toPx0680j_4 = density.mo803toPx0680j_4(fM8748constructorimpl116);
            fMo803toPx0680j_5 = density.mo803toPx0680j_4(Dp.m8748constructorimpl(Dp.m8748constructorimpl(fM8748constructorimpl114 - fM8748constructorimpl115) - fM8748constructorimpl116));
            f = (fMo803toPx0680j_4 + fMo803toPx0680j_5) / 2.0f;
            if (i != 0) {
                f = fMo803toPx0680j_4;
            } else if (i != 1) {
                f = fMo803toPx0680j_5;
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1621932434, "CC(remember):GlassComponents.kt#9igjgp");
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            int i13 = i4;
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = AnimatableKt.Animatable$default(f, 0.0f, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            animatable = (Animatable) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1621929109, "CC(remember):GlassComponents.kt#9igjgp");
            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = PrimitiveSnapshotStateKt.mutableFloatStateOf(0.0f);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            mutableFloatState = (MutableFloatState) objRememberedValue3;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1621925879, "CC(remember):GlassComponents.kt#9igjgp");
            objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            mutableState = (MutableState) objRememberedValue4;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            fCoerceIn = RangesKt.coerceIn(Math.abs(GlassNavigationBar$lambda$4(mutableFloatState)) / 180.0f, 0.0f, 0.09f);
            if (!GlassNavigationBar$lambda$7(mutableState)) {
                fCoerceIn = 0.0f;
            }
            f2 = f;
            stateAnimateFloatAsState = AnimateAsStateKt.animateFloatAsState(fCoerceIn, AnimationSpecKt.spring$default(0.78f, 650.0f, null, 4, null), 0.0f, "bubbleStretch", null, composerStartRestartGroup, 3120, 20);
            if (GlassNavigationBar$lambda$7(mutableState)) {
                f3 = 1.055f;
            } else {
                f3 = 1.0f;
            }
            stateAnimateFloatAsState2 = AnimateAsStateKt.animateFloatAsState(f3, AnimationSpecKt.spring$default(0.84f, 760.0f, null, 4, null), 0.0f, "bubblePressScale", null, composerStartRestartGroup, 3120, 20);
            float fMo803toPx0680j_9 = density.mo803toPx0680j_4(Dp.m8748constructorimpl(5.0f));
            fCoerceIn2 = RangesKt.coerceIn(GlassNavigationBar$lambda$4(mutableFloatState) * 0.22f, -fMo803toPx0680j_9, fMo803toPx0680j_9);
            if (GlassNavigationBar$lambda$7(mutableState)) {
                f4 = fCoerceIn2;
            } else {
                f4 = 0.0f;
            }
            stateAnimateFloatAsState3 = AnimateAsStateKt.animateFloatAsState(f4, AnimationSpecKt.spring$default(0.86f, 520.0f, null, 4, null), 0.0f, "navigationSway", null, composerStartRestartGroup, 3120, 20);
            Integer numValueOf4 = Integer.valueOf(i);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1621862892, "CC(remember):GlassComponents.kt#9igjgp");
            zChangedInstance = composerStartRestartGroup.changedInstance(animatable) | composerStartRestartGroup.changed(f2);
            glassComponentsKt$GlassNavigationBar$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (!zChangedInstance) {
                glassComponentsKt$GlassNavigationBar$1$1RememberedValue = new GlassComponentsKt$GlassNavigationBar$1$1(animatable, f2, mutableState, null);
                composerStartRestartGroup.updateRememberedValue(glassComponentsKt$GlassNavigationBar$1$1RememberedValue);
            } else {
                glassComponentsKt$GlassNavigationBar$1$1RememberedValue = new GlassComponentsKt$GlassNavigationBar$1$1(animatable, f2, mutableState, null);
                composerStartRestartGroup.updateRememberedValue(glassComponentsKt$GlassNavigationBar$1$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.LaunchedEffect(numValueOf4, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) glassComponentsKt$GlassNavigationBar$1$1RememberedValue, composerStartRestartGroup, i13 & 14);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1621847130, "CC(remember):GlassComponents.kt#9igjgp");
            zChanged = composerStartRestartGroup.changed(stateAnimateFloatAsState3);
            objRememberedValue5 = composerStartRestartGroup.rememberedValue();
            if (!zChanged) {
                objRememberedValue5 = new Function1() { // from class: com.example.tickets.GlassComponentsKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return GlassComponentsKt.GlassNavigationBar$lambda$15$lambda$14(stateAnimateFloatAsState3, (Density) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
            } else {
                objRememberedValue5 = new Function1() { // from class: com.example.tickets.GlassComponentsKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return GlassComponentsKt.GlassNavigationBar$lambda$15$lambda$14(stateAnimateFloatAsState3, (Density) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierClip10 = ClipKt.clip(SizeKt.m1476height3ABfNKs(SizeKt.m1495width3ABfNKs(OffsetKt.offset(companion, (Function1) objRememberedValue5), fM8748constructorimpl114), fM8748constructorimpl), RoundedCornerShapeKt.m1756RoundedCornerShape0680j_4(Dp.m8748constructorimpl(34.0f)));
            if (hazeState4 != null) {
                HazeState hazeState9 = hazeState4;
                companionHazeEffect$default = HazeChildKt.hazeEffect$default(Modifier.INSTANCE, hazeState9, new HazeStyle(Color.INSTANCE.m5873getTransparent0d7_KjU(), new HazeTint(Color.m5837copywmQWz5c$default(Color.INSTANCE.m5875getWhite0d7_KjU(), 0.16f, 0.0f, 0.0f, 0.0f, 14, null), 0, 2, (DefaultConstructorMarker) null), Dp.m8748constructorimpl(30.0f), 0.0f, (HazeTint) null, 24, (DefaultConstructorMarker) null), null, 4, null);
                hazeState5 = hazeState9;
            } else {
                hazeState5 = hazeState4;
                companionHazeEffect$default = Modifier.INSTANCE;
            }
            Modifier modifierThen4 = modifierClip10.then(companionHazeEffect$default);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy19 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
            int iHashCode112 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap112 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier112 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierThen4);
            Modifier modifier7 = companion;
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
            Updater.m4945setimpl(composerM4937constructorimpl112, measurePolicyMaybeCachedBoxMeasurePolicy19, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m4945setimpl(composerM4937constructorimpl112, currentCompositionLocalMap112, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m4945setimpl(composerM4937constructorimpl112, Integer.valueOf(iHashCode112), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m4943reconcileimpl(composerM4937constructorimpl112, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m4945setimpl(composerM4937constructorimpl112, modifierMaterializeModifier112, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance19 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -671913841, "C292@8191L3886,412@12128L596,437@12904L1951,515@15183L695,535@15910L497,557@16526L10679,844@27242L3466,511@15048L15670:GlassComponents.kt#n9ob9m");
            Modifier modifierBackground$default4 = BackgroundKt.background$default(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), Brush.Companion.m5769verticalGradient8A3gB4$default(Brush.INSTANCE, CollectionsKt.listOf((Object[]) new Color[]{Color.m5828boximpl(Color.m5837copywmQWz5c$default(Color.INSTANCE.m5875getWhite0d7_KjU(), 0.155f, 0.0f, 0.0f, 0.0f, 14, null)), Color.m5828boximpl(Color.m5837copywmQWz5c$default(Color.INSTANCE.m5875getWhite0d7_KjU(), 0.085f, 0.0f, 0.0f, 0.0f, 14, null)), Color.m5828boximpl(Color.m5837copywmQWz5c$default(Color.INSTANCE.m5875getWhite0d7_KjU(), 0.055f, 0.0f, 0.0f, 0.0f, 14, null))}), 0.0f, 0.0f, 0, 14, (Object) null), RoundedCornerShapeKt.m1756RoundedCornerShape0680j_4(Dp.m8748constructorimpl(34.0f)), 0.0f, 4, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy110 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
            int iHashCode113 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap113 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier113 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierBackground$default4);
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
            Composer composerM4937constructorimpl113 = Updater.m4937constructorimpl(composerStartRestartGroup);
            Updater.m4945setimpl(composerM4937constructorimpl113, measurePolicyMaybeCachedBoxMeasurePolicy110, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m4945setimpl(composerM4937constructorimpl113, currentCompositionLocalMap113, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m4945setimpl(composerM4937constructorimpl113, Integer.valueOf(iHashCode113), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m4943reconcileimpl(composerM4937constructorimpl113, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m4945setimpl(composerM4937constructorimpl113, modifierMaterializeModifier113, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance110 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -700470138, "C312@8853L643,333@9571L322,347@9963L723,370@10758L681,393@11550L517:GlassComponents.kt#n9ob9m");
            BoxKt.Box(BackgroundKt.background$default(BlurKt.m5339blurF8QBwvs$default(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m8748constructorimpl(18.0f), null, 2, null), Brush.Companion.m5769verticalGradient8A3gB4$default(Brush.INSTANCE, CollectionsKt.listOf((Object[]) new Color[]{Color.m5828boximpl(Color.m5837copywmQWz5c$default(Color.INSTANCE.m5875getWhite0d7_KjU(), 0.11f, 0.0f, 0.0f, 0.0f, 14, null)), Color.m5828boximpl(Color.m5837copywmQWz5c$default(Color.INSTANCE.m5875getWhite0d7_KjU(), 0.06f, 0.0f, 0.0f, 0.0f, 14, null)), Color.m5828boximpl(Color.m5837copywmQWz5c$default(Color.INSTANCE.m5864getBlack0d7_KjU(), 0.035f, 0.0f, 0.0f, 0.0f, 14, null))}), 0.0f, 0.0f, 0, 14, (Object) null), RoundedCornerShapeKt.m1756RoundedCornerShape0680j_4(Dp.m8748constructorimpl(34.0f)), 0.0f, 4, null), composerStartRestartGroup, 0);
            BoxKt.Box(BackgroundKt.m647backgroundbw27NRU(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), Color.m5837copywmQWz5c$default(Color.INSTANCE.m5875getWhite0d7_KjU(), 0.055f, 0.0f, 0.0f, 0.0f, 14, null), RoundedCornerShapeKt.m1756RoundedCornerShape0680j_4(Dp.m8748constructorimpl(34.0f))), composerStartRestartGroup, 0);
            BoxKt.Box(BackgroundKt.background$default(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), Brush.Companion.m5765radialGradientP_VxKs$default(Brush.INSTANCE, CollectionsKt.listOf((Object[]) new Color[]{Color.m5828boximpl(Color.m5837copywmQWz5c$default(Color.INSTANCE.m5875getWhite0d7_KjU(), 0.095f, 0.0f, 0.0f, 0.0f, 14, null)), Color.m5828boximpl(Color.m5837copywmQWz5c$default(Color.INSTANCE.m5875getWhite0d7_KjU(), 0.038f, 0.0f, 0.0f, 0.0f, 14, null)), Color.m5828boximpl(Color.INSTANCE.m5873getTransparent0d7_KjU())}), 0L, 390.0f, 0, 10, (Object) null), RoundedCornerShapeKt.m1756RoundedCornerShape0680j_4(Dp.m8748constructorimpl(34.0f)), 0.0f, 4, null), composerStartRestartGroup, 0);
            BoxKt.Box(BackgroundKt.background$default(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), Brush.Companion.m5769verticalGradient8A3gB4$default(Brush.INSTANCE, CollectionsKt.listOf((Object[]) new Color[]{Color.m5828boximpl(Color.m5837copywmQWz5c$default(Color.INSTANCE.m5875getWhite0d7_KjU(), 0.105f, 0.0f, 0.0f, 0.0f, 14, null)), Color.m5828boximpl(Color.INSTANCE.m5873getTransparent0d7_KjU()), Color.m5828boximpl(Color.m5837copywmQWz5c$default(Color.INSTANCE.m5864getBlack0d7_KjU(), 0.04f, 0.0f, 0.0f, 0.0f, 14, null))}), 0.0f, 0.0f, 0, 14, (Object) null), RoundedCornerShapeKt.m1756RoundedCornerShape0680j_4(Dp.m8748constructorimpl(34.0f)), 0.0f, 4, null), composerStartRestartGroup, 0);
            BoxKt.Box(BackgroundKt.background$default(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), Brush.Companion.m5765radialGradientP_VxKs$default(Brush.INSTANCE, CollectionsKt.listOf((Object[]) new Color[]{Color.m5828boximpl(Color.INSTANCE.m5873getTransparent0d7_KjU()), Color.m5828boximpl(Color.m5837copywmQWz5c$default(Color.INSTANCE.m5864getBlack0d7_KjU(), 0.045f, 0.0f, 0.0f, 0.0f, 14, null))}), 0L, 250.0f, 0, 10, (Object) null), RoundedCornerShapeKt.m1756RoundedCornerShape0680j_4(Dp.m8748constructorimpl(34.0f)), 0.0f, 4, null), composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            BoxKt.Box(BorderKt.m661borderziNgDLE(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m8748constructorimpl(1.0f), Brush.Companion.m5769verticalGradient8A3gB4$default(Brush.INSTANCE, CollectionsKt.listOf((Object[]) new Color[]{Color.m5828boximpl(Color.m5837copywmQWz5c$default(Color.INSTANCE.m5875getWhite0d7_KjU(), 0.22f, 0.0f, 0.0f, 0.0f, 14, null)), Color.m5828boximpl(Color.m5837copywmQWz5c$default(Color.INSTANCE.m5875getWhite0d7_KjU(), 0.065f, 0.0f, 0.0f, 0.0f, 14, null))}), 0.0f, 0.0f, 0, 14, (Object) null), RoundedCornerShapeKt.m1756RoundedCornerShape0680j_4(Dp.m8748constructorimpl(34.0f))), composerStartRestartGroup, 0);
            Modifier modifierM1425paddingVpY3zN4$default4 = PaddingKt.m1425paddingVpY3zN4$default(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), fM8748constructorimpl116, 0.0f, 2, null);
            Alignment.Vertical centerVertically4 = Alignment.INSTANCE.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy4 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically4, composerStartRestartGroup, 48);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
            int iHashCode114 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap114 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier114 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1425paddingVpY3zN4$default4);
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
            Updater.m4945setimpl(composerM4937constructorimpl114, measurePolicyRowMeasurePolicy4, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m4945setimpl(composerM4937constructorimpl114, currentCompositionLocalMap114, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m4945setimpl(composerM4937constructorimpl114, Integer.valueOf(iHashCode114), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m4943reconcileimpl(composerM4937constructorimpl114, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m4945setimpl(composerM4937constructorimpl114, modifierMaterializeModifier114, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance4 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 446008607, "C447@13162L551,466@13727L552,485@14293L552:GlassComponents.kt#n9ob9m");
            Modifier modifierFillMaxHeight$default13 = SizeKt.fillMaxHeight$default(SizeKt.m1495width3ABfNKs(Modifier.INSTANCE, fM8748constructorimpl115), 0.0f, 1, null);
            Alignment center13 = Alignment.INSTANCE.getCenter();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy111 = BoxKt.maybeCachedBoxMeasurePolicy(center13, false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
            int iHashCode115 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap115 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier115 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxHeight$default13);
            constructor4 = ComposeUiNode.INSTANCE.getConstructor();
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
            Composer composerM4937constructorimpl115 = Updater.m4937constructorimpl(composerStartRestartGroup);
            Updater.m4945setimpl(composerM4937constructorimpl115, measurePolicyMaybeCachedBoxMeasurePolicy111, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m4945setimpl(composerM4937constructorimpl115, currentCompositionLocalMap115, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m4945setimpl(composerM4937constructorimpl115, Integer.valueOf(iHashCode115), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m4943reconcileimpl(composerM4937constructorimpl115, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m4945setimpl(composerM4937constructorimpl115, modifierMaterializeModifier115, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance111 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1753369025, "C460@13617L64,455@13386L313:GlassComponents.kt#n9ob9m");
            if (i == 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            NavigationIconType navigationIconType12 = NavigationIconType.TICKETS;
            float fM8748constructorimpl117 = Dp.m8748constructorimpl(0.0f);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -887837141, "CC(remember):GlassComponents.kt#9igjgp");
            i7 = i13 & StylePropertiesKt.TextDirectionMask;
            if (i7 == 32) {
                z3 = true;
            } else {
                z3 = false;
            }
            objRememberedValue6 = composerStartRestartGroup.rememberedValue();
            if (z3) {
                function1 = onSelectedTab;
                objRememberedValue6 = new Function0() { // from class: com.example.tickets.GlassComponentsKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return GlassComponentsKt.GlassNavigationBar$lambda$36$lambda$26$lambda$19$lambda$18$lambda$17(function1);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
            } else {
                function1 = onSelectedTab;
                objRememberedValue6 = new Function0() { // from class: com.example.tickets.GlassComponentsKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return GlassComponentsKt.GlassNavigationBar$lambda$36$lambda$26$lambda$19$lambda$18$lambda$17(function1);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            m9297NavigationTabjIwJxvA("票夹", z2, navigationIconType12, fM8748constructorimpl117, null, (Function0) objRememberedValue6, composerStartRestartGroup, 3462, 16);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierFillMaxHeight$default14 = SizeKt.fillMaxHeight$default(SizeKt.m1495width3ABfNKs(Modifier.INSTANCE, fM8748constructorimpl115), 0.0f, 1, null);
            Alignment center14 = Alignment.INSTANCE.getCenter();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy112 = BoxKt.maybeCachedBoxMeasurePolicy(center14, false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
            int iHashCode116 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap116 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier116 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxHeight$default14);
            constructor5 = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)410@16216L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor5);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM4937constructorimpl116 = Updater.m4937constructorimpl(composerStartRestartGroup);
            Updater.m4945setimpl(composerM4937constructorimpl116, measurePolicyMaybeCachedBoxMeasurePolicy112, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m4945setimpl(composerM4937constructorimpl116, currentCompositionLocalMap116, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m4945setimpl(composerM4937constructorimpl116, Integer.valueOf(iHashCode116), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m4943reconcileimpl(composerM4937constructorimpl116, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m4945setimpl(composerM4937constructorimpl116, modifierMaterializeModifier116, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance112 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1382315563, "C479@14183L64,474@13951L314:GlassComponents.kt#n9ob9m");
            if (i == 1) {
                z4 = true;
            } else {
                z4 = false;
            }
            navigationIconType = NavigationIconType.SUBWAY;
            float fM8748constructorimpl118 = Dp.m8748constructorimpl(3.0f);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1430056972, "CC(remember):GlassComponents.kt#9igjgp");
            if (i7 == 32) {
                z5 = true;
            } else {
                z5 = false;
            }
            objRememberedValue7 = composerStartRestartGroup.rememberedValue();
            if (z5) {
                navigationIconType2 = navigationIconType;
                if (objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                m9297NavigationTabjIwJxvA("智能地铁", z4, navigationIconType2, fM8748constructorimpl118, null, (Function0) objRememberedValue7, composerStartRestartGroup, 3462, 16);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Modifier modifierFillMaxHeight$default15 = SizeKt.fillMaxHeight$default(SizeKt.m1495width3ABfNKs(Modifier.INSTANCE, fM8748constructorimpl115), 0.0f, 1, null);
                Alignment center15 = Alignment.INSTANCE.getCenter();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy113 = BoxKt.maybeCachedBoxMeasurePolicy(center15, false);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
                int iHashCode117 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap117 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier117 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxHeight$default15);
                constructor6 = ComposeUiNode.INSTANCE.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)410@16216L9:Composables.kt#9igjgp");
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor6);
                } else {
                    composerStartRestartGroup.useNode();
                }
                Composer composerM4937constructorimpl117 = Updater.m4937constructorimpl(composerStartRestartGroup);
                Updater.m4945setimpl(composerM4937constructorimpl117, measurePolicyMaybeCachedBoxMeasurePolicy113, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m4945setimpl(composerM4937constructorimpl117, currentCompositionLocalMap117, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Updater.m4945setimpl(composerM4937constructorimpl117, Integer.valueOf(iHashCode117), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                Updater.m4943reconcileimpl(composerM4937constructorimpl117, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                Updater.m4945setimpl(composerM4937constructorimpl117, modifierMaterializeModifier117, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance113 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1950287786, "C498@14749L64,493@14517L314:GlassComponents.kt#n9ob9m");
                if (i == 2) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                NavigationIconType navigationIconType13 = NavigationIconType.SETTINGS;
                float fM8748constructorimpl119 = Dp.m8748constructorimpl(8.0f);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1864020653, "CC(remember):GlassComponents.kt#9igjgp");
                if (i7 == 32) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                objRememberedValue8 = composerStartRestartGroup.rememberedValue();
                if (!z7) {
                    objRememberedValue8 = new Function0() { // from class: com.example.tickets.GlassComponentsKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return GlassComponentsKt.GlassNavigationBar$lambda$36$lambda$26$lambda$25$lambda$24$lambda$23(function1);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                } else {
                    objRememberedValue8 = new Function0() { // from class: com.example.tickets.GlassComponentsKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return GlassComponentsKt.GlassNavigationBar$lambda$36$lambda$26$lambda$25$lambda$24$lambda$23(function1);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                m9297NavigationTabjIwJxvA("设置", z6, navigationIconType13, fM8748constructorimpl119, null, (Function0) objRememberedValue8, composerStartRestartGroup, 3462, 16);
                composer2 = composerStartRestartGroup;
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
                Modifier modifierM1476height3ABfNKs7 = SizeKt.m1476height3ABfNKs(SizeKt.m1495width3ABfNKs(Modifier.INSTANCE, fM8748constructorimpl115), fM8748constructorimpl2);
                ComposerKt.sourceInformationMarkerStart(composer2, 117074604, "CC(remember):GlassComponents.kt#9igjgp");
                zChangedInstance2 = composer2.changedInstance(animatable) | composer2.changed(density);
                objRememberedValue9 = composer2.rememberedValue();
                if (!zChangedInstance2) {
                    objRememberedValue9 = new Function1() { // from class: com.example.tickets.GlassComponentsKt$$ExternalSyntheticLambda7
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return GlassComponentsKt.GlassNavigationBar$lambda$36$lambda$29$lambda$28(animatable, density, fM8748constructorimpl, fM8748constructorimpl2, (Density) obj);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue9);
                } else {
                    objRememberedValue9 = new Function1() { // from class: com.example.tickets.GlassComponentsKt$$ExternalSyntheticLambda7
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return GlassComponentsKt.GlassNavigationBar$lambda$36$lambda$29$lambda$28(animatable, density, fM8748constructorimpl, fM8748constructorimpl2, (Density) obj);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue9);
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                Modifier modifierOffset7 = OffsetKt.offset(modifierM1476height3ABfNKs7, (Function1) objRememberedValue9);
                ComposerKt.sourceInformationMarkerStart(composer2, 117097670, "CC(remember):GlassComponents.kt#9igjgp");
                zChanged2 = composer2.changed(stateAnimateFloatAsState2) | composer2.changed(stateAnimateFloatAsState);
                objRememberedValue10 = composer2.rememberedValue();
                if (!zChanged2) {
                    objRememberedValue10 = new Function1() { // from class: com.example.tickets.GlassComponentsKt$$ExternalSyntheticLambda8
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return GlassComponentsKt.GlassNavigationBar$lambda$36$lambda$31$lambda$30(stateAnimateFloatAsState2, stateAnimateFloatAsState, (GraphicsLayerScope) obj);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue10);
                } else {
                    objRememberedValue10 = new Function1() { // from class: com.example.tickets.GlassComponentsKt$$ExternalSyntheticLambda8
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return GlassComponentsKt.GlassNavigationBar$lambda$36$lambda$31$lambda$30(stateAnimateFloatAsState2, stateAnimateFloatAsState, (GraphicsLayerScope) obj);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue10);
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                Modifier modifierClip11 = ClipKt.clip(GraphicsLayerModifierKt.graphicsLayer(modifierOffset7, (Function1) objRememberedValue10), RoundedCornerShapeKt.m1756RoundedCornerShape0680j_4(Dp.m8748constructorimpl(31.0f)));
                ComposerKt.sourceInformationMarkerStart(composer2, 117127564, "CC(remember):GlassComponents.kt#9igjgp");
                objRememberedValue11 = composer2.rememberedValue();
                if (objRememberedValue11 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue11 = new Function1() { // from class: com.example.tickets.GlassComponentsKt$$ExternalSyntheticLambda9
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return GlassComponentsKt.GlassNavigationBar$lambda$36$lambda$34$lambda$33((CacheDrawScope) obj);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue11);
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                Modifier modifierDrawWithCache7 = DrawModifierKt.drawWithCache(modifierClip11, (Function1) objRememberedValue11);
                Unit unit7 = Unit.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composer2, 117463263, "CC(remember):GlassComponents.kt#9igjgp");
                boolean zChanged10 = composer2.changed(fMo803toPx0680j_4) | composer2.changed(f) | composer2.changed(fMo803toPx0680j_5) | composer2.changedInstance(animatable) | composer2.changedInstance(coroutineScope);
                if (i7 == 32) {
                    z8 = true;
                } else {
                    z8 = false;
                }
                zChanged3 = zChanged10 | z8 | composer2.changed(f2);
                glassComponentsKt$GlassNavigationBar$3$6$1RememberedValue = composer2.rememberedValue();
                if (zChanged3) {
                    i8 = 0;
                    glassComponentsKt$GlassNavigationBar$3$6$1RememberedValue = new GlassComponentsKt$GlassNavigationBar$3$6$1(mutableState, mutableFloatState, fMo803toPx0680j_4, f, fMo803toPx0680j_5, coroutineScope, animatable, function1, f2);
                    composer2.updateRememberedValue(glassComponentsKt$GlassNavigationBar$3$6$1RememberedValue);
                } else {
                    i8 = 0;
                    glassComponentsKt$GlassNavigationBar$3$6$1RememberedValue = new GlassComponentsKt$GlassNavigationBar$3$6$1(mutableState, mutableFloatState, fMo803toPx0680j_4, f, fMo803toPx0680j_5, coroutineScope, animatable, function1, f2);
                    composer2.updateRememberedValue(glassComponentsKt$GlassNavigationBar$3$6$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                BoxKt.Box(SuspendingPointerInputFilterKt.pointerInput(modifierDrawWithCache7, unit7, (PointerInputEventHandler) glassComponentsKt$GlassNavigationBar$3$6$1RememberedValue), composer2, i8);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                hazeState3 = hazeState5;
                modifier3 = modifier7;
            } else {
                navigationIconType2 = navigationIconType;
            }
            objRememberedValue7 = new Function0() { // from class: com.example.tickets.GlassComponentsKt$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return GlassComponentsKt.GlassNavigationBar$lambda$36$lambda$26$lambda$22$lambda$21$lambda$20(function1);
                }
            };
            composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            m9297NavigationTabjIwJxvA("智能地铁", z4, navigationIconType2, fM8748constructorimpl118, null, (Function0) objRememberedValue7, composerStartRestartGroup, 3462, 16);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierFillMaxHeight$default16 = SizeKt.fillMaxHeight$default(SizeKt.m1495width3ABfNKs(Modifier.INSTANCE, fM8748constructorimpl115), 0.0f, 1, null);
            Alignment center16 = Alignment.INSTANCE.getCenter();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy114 = BoxKt.maybeCachedBoxMeasurePolicy(center16, false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
            int iHashCode118 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap118 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier118 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxHeight$default16);
            constructor6 = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)410@16216L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor6);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM4937constructorimpl118 = Updater.m4937constructorimpl(composerStartRestartGroup);
            Updater.m4945setimpl(composerM4937constructorimpl118, measurePolicyMaybeCachedBoxMeasurePolicy114, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m4945setimpl(composerM4937constructorimpl118, currentCompositionLocalMap118, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m4945setimpl(composerM4937constructorimpl118, Integer.valueOf(iHashCode118), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m4943reconcileimpl(composerM4937constructorimpl118, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m4945setimpl(composerM4937constructorimpl118, modifierMaterializeModifier118, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance114 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1950287786, "C498@14749L64,493@14517L314:GlassComponents.kt#n9ob9m");
            if (i == 2) {
                z6 = true;
            } else {
                z6 = false;
            }
            NavigationIconType navigationIconType14 = NavigationIconType.SETTINGS;
            float fM8748constructorimpl1110 = Dp.m8748constructorimpl(8.0f);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1864020653, "CC(remember):GlassComponents.kt#9igjgp");
            if (i7 == 32) {
                z7 = true;
            } else {
                z7 = false;
            }
            objRememberedValue8 = composerStartRestartGroup.rememberedValue();
            if (!z7) {
                objRememberedValue8 = new Function0() { // from class: com.example.tickets.GlassComponentsKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return GlassComponentsKt.GlassNavigationBar$lambda$36$lambda$26$lambda$25$lambda$24$lambda$23(function1);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
            } else {
                objRememberedValue8 = new Function0() { // from class: com.example.tickets.GlassComponentsKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return GlassComponentsKt.GlassNavigationBar$lambda$36$lambda$26$lambda$25$lambda$24$lambda$23(function1);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            m9297NavigationTabjIwJxvA("设置", z6, navigationIconType14, fM8748constructorimpl1110, null, (Function0) objRememberedValue8, composerStartRestartGroup, 3462, 16);
            composer2 = composerStartRestartGroup;
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
            Modifier modifierM1476height3ABfNKs8 = SizeKt.m1476height3ABfNKs(SizeKt.m1495width3ABfNKs(Modifier.INSTANCE, fM8748constructorimpl115), fM8748constructorimpl2);
            ComposerKt.sourceInformationMarkerStart(composer2, 117074604, "CC(remember):GlassComponents.kt#9igjgp");
            zChangedInstance2 = composer2.changedInstance(animatable) | composer2.changed(density);
            objRememberedValue9 = composer2.rememberedValue();
            if (!zChangedInstance2) {
                objRememberedValue9 = new Function1() { // from class: com.example.tickets.GlassComponentsKt$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return GlassComponentsKt.GlassNavigationBar$lambda$36$lambda$29$lambda$28(animatable, density, fM8748constructorimpl, fM8748constructorimpl2, (Density) obj);
                    }
                };
                composer2.updateRememberedValue(objRememberedValue9);
            } else {
                objRememberedValue9 = new Function1() { // from class: com.example.tickets.GlassComponentsKt$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return GlassComponentsKt.GlassNavigationBar$lambda$36$lambda$29$lambda$28(animatable, density, fM8748constructorimpl, fM8748constructorimpl2, (Density) obj);
                    }
                };
                composer2.updateRememberedValue(objRememberedValue9);
            }
            ComposerKt.sourceInformationMarkerEnd(composer2);
            Modifier modifierOffset8 = OffsetKt.offset(modifierM1476height3ABfNKs8, (Function1) objRememberedValue9);
            ComposerKt.sourceInformationMarkerStart(composer2, 117097670, "CC(remember):GlassComponents.kt#9igjgp");
            zChanged2 = composer2.changed(stateAnimateFloatAsState2) | composer2.changed(stateAnimateFloatAsState);
            objRememberedValue10 = composer2.rememberedValue();
            if (!zChanged2) {
                objRememberedValue10 = new Function1() { // from class: com.example.tickets.GlassComponentsKt$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return GlassComponentsKt.GlassNavigationBar$lambda$36$lambda$31$lambda$30(stateAnimateFloatAsState2, stateAnimateFloatAsState, (GraphicsLayerScope) obj);
                    }
                };
                composer2.updateRememberedValue(objRememberedValue10);
            } else {
                objRememberedValue10 = new Function1() { // from class: com.example.tickets.GlassComponentsKt$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return GlassComponentsKt.GlassNavigationBar$lambda$36$lambda$31$lambda$30(stateAnimateFloatAsState2, stateAnimateFloatAsState, (GraphicsLayerScope) obj);
                    }
                };
                composer2.updateRememberedValue(objRememberedValue10);
            }
            ComposerKt.sourceInformationMarkerEnd(composer2);
            Modifier modifierClip12 = ClipKt.clip(GraphicsLayerModifierKt.graphicsLayer(modifierOffset8, (Function1) objRememberedValue10), RoundedCornerShapeKt.m1756RoundedCornerShape0680j_4(Dp.m8748constructorimpl(31.0f)));
            ComposerKt.sourceInformationMarkerStart(composer2, 117127564, "CC(remember):GlassComponents.kt#9igjgp");
            objRememberedValue11 = composer2.rememberedValue();
            if (objRememberedValue11 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue11 = new Function1() { // from class: com.example.tickets.GlassComponentsKt$$ExternalSyntheticLambda9
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return GlassComponentsKt.GlassNavigationBar$lambda$36$lambda$34$lambda$33((CacheDrawScope) obj);
                    }
                };
                composer2.updateRememberedValue(objRememberedValue11);
            }
            ComposerKt.sourceInformationMarkerEnd(composer2);
            Modifier modifierDrawWithCache8 = DrawModifierKt.drawWithCache(modifierClip12, (Function1) objRememberedValue11);
            Unit unit8 = Unit.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer2, 117463263, "CC(remember):GlassComponents.kt#9igjgp");
            boolean zChanged11 = composer2.changed(fMo803toPx0680j_4) | composer2.changed(f) | composer2.changed(fMo803toPx0680j_5) | composer2.changedInstance(animatable) | composer2.changedInstance(coroutineScope);
            if (i7 == 32) {
                z8 = true;
            } else {
                z8 = false;
            }
            zChanged3 = zChanged11 | z8 | composer2.changed(f2);
            glassComponentsKt$GlassNavigationBar$3$6$1RememberedValue = composer2.rememberedValue();
            if (zChanged3) {
                i8 = 0;
                glassComponentsKt$GlassNavigationBar$3$6$1RememberedValue = new GlassComponentsKt$GlassNavigationBar$3$6$1(mutableState, mutableFloatState, fMo803toPx0680j_4, f, fMo803toPx0680j_5, coroutineScope, animatable, function1, f2);
                composer2.updateRememberedValue(glassComponentsKt$GlassNavigationBar$3$6$1RememberedValue);
            } else {
                i8 = 0;
                glassComponentsKt$GlassNavigationBar$3$6$1RememberedValue = new GlassComponentsKt$GlassNavigationBar$3$6$1(mutableState, mutableFloatState, fMo803toPx0680j_4, f, fMo803toPx0680j_5, coroutineScope, animatable, function1, f2);
                composer2.updateRememberedValue(glassComponentsKt$GlassNavigationBar$3$6$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer2);
            BoxKt.Box(SuspendingPointerInputFilterKt.pointerInput(modifierDrawWithCache8, unit8, (PointerInputEventHandler) glassComponentsKt$GlassNavigationBar$3$6$1RememberedValue), composer2, i8);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            hazeState3 = hazeState5;
            modifier3 = modifier7;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.tickets.GlassComponentsKt$$ExternalSyntheticLambda10
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return GlassComponentsKt.GlassNavigationBar$lambda$37(i, onSelectedTab, modifier3, hazeState3, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float GlassNavigationBar$lambda$4(MutableFloatState mutableFloatState) {
        return mutableFloatState.getFloatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean GlassNavigationBar$lambda$7(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void GlassNavigationBar$lambda$8(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    static final IntOffset GlassNavigationBar$lambda$15$lambda$14(State state, Density offset) {
        Intrinsics.checkNotNullParameter(offset, "$this$offset");
        return IntOffset.m8867boximpl(IntOffset.m8870constructorimpl(((long) MathKt.roundToInt(GlassNavigationBar$lambda$12(state))) << 32));
    }

    static final Unit GlassNavigationBar$lambda$36$lambda$26$lambda$19$lambda$18$lambda$17(Function1 function1) {
        function1.invoke(0);
        return Unit.INSTANCE;
    }

    static final Unit GlassNavigationBar$lambda$36$lambda$26$lambda$22$lambda$21$lambda$20(Function1 function1) {
        function1.invoke(1);
        return Unit.INSTANCE;
    }

    static final Unit GlassNavigationBar$lambda$36$lambda$26$lambda$25$lambda$24$lambda$23(Function1 function1) {
        function1.invoke(2);
        return Unit.INSTANCE;
    }

    static final IntOffset GlassNavigationBar$lambda$36$lambda$29$lambda$28(Animatable animatable, Density density, float f, float f2, Density offset) {
        Intrinsics.checkNotNullParameter(offset, "$this$offset");
        int iRoundToInt = MathKt.roundToInt(((Number) animatable.getValue()).floatValue());
        int iRoundToInt2 = MathKt.roundToInt(density.mo803toPx0680j_4(Dp.m8748constructorimpl(Dp.m8748constructorimpl(f - f2) / 2.0f)));
        return IntOffset.m8867boximpl(IntOffset.m8870constructorimpl((((long) iRoundToInt2) & 4294967295L) | (((long) iRoundToInt) << 32)));
    }

    static final Unit GlassNavigationBar$lambda$36$lambda$31$lambda$30(State state, State state2, GraphicsLayerScope graphicsLayer) {
        Intrinsics.checkNotNullParameter(graphicsLayer, "$this$graphicsLayer");
        graphicsLayer.setScaleX(GlassNavigationBar$lambda$10(state) * (GlassNavigationBar$lambda$9(state2) + 1.0f));
        graphicsLayer.setScaleY(GlassNavigationBar$lambda$10(state) * (1.0f - (GlassNavigationBar$lambda$9(state2) * 0.22f)));
        graphicsLayer.mo6044setTransformOrigin__ExYCQ(TransformOrigin.INSTANCE.m6274getCenterSzJe1aQ());
        return Unit.INSTANCE;
    }

    static final DrawResult GlassNavigationBar$lambda$36$lambda$34$lambda$33(CacheDrawScope drawWithCache) {
        Intrinsics.checkNotNullParameter(drawWithCache, "$this$drawWithCache");
        float fIntBitsToFloat = Float.intBitsToFloat((int) (drawWithCache.m5351getSizeNHjbRc() >> 32));
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (drawWithCache.m5351getSizeNHjbRc() & 4294967295L));
        final float f = fIntBitsToFloat2 / 2.0f;
        float f2 = 0.08f * fIntBitsToFloat2;
        final Brush brushM5763linearGradientmHitzGk$default = Brush.Companion.m5763linearGradientmHitzGk$default(Brush.INSTANCE, CollectionsKt.listOf((Object[]) new Color[]{Color.m5828boximpl(Color.m5837copywmQWz5c$default(Color.INSTANCE.m5875getWhite0d7_KjU(), 0.11f, 0.0f, 0.0f, 0.0f, 14, null)), Color.m5828boximpl(Color.m5837copywmQWz5c$default(Color.INSTANCE.m5875getWhite0d7_KjU(), 0.035f, 0.0f, 0.0f, 0.0f, 14, null)), Color.m5828boximpl(Color.m5837copywmQWz5c$default(Color.INSTANCE.m5875getWhite0d7_KjU(), 0.075f, 0.0f, 0.0f, 0.0f, 14, null)), Color.m5828boximpl(Color.m5837copywmQWz5c$default(Color.INSTANCE.m5875getWhite0d7_KjU(), 0.1f, 0.0f, 0.0f, 0.0f, 14, null))}), Offset.m5559constructorimpl((((long) Float.floatToRawIntBits(f2)) & 4294967295L) | (((long) Float.floatToRawIntBits(fIntBitsToFloat * 0.08f)) << 32)), Offset.m5559constructorimpl((((long) Float.floatToRawIntBits(0.92f * fIntBitsToFloat2)) & 4294967295L) | (((long) Float.floatToRawIntBits(fIntBitsToFloat * 0.92f)) << 32)), 0, 8, (Object) null);
        final Brush brushM5765radialGradientP_VxKs$default = Brush.Companion.m5765radialGradientP_VxKs$default(Brush.INSTANCE, CollectionsKt.listOf((Object[]) new Color[]{Color.m5828boximpl(Color.m5837copywmQWz5c$default(Color.INSTANCE.m5875getWhite0d7_KjU(), 0.08f, 0.0f, 0.0f, 0.0f, 14, null)), Color.m5828boximpl(Color.m5837copywmQWz5c$default(Color.INSTANCE.m5875getWhite0d7_KjU(), 0.025f, 0.0f, 0.0f, 0.0f, 14, null)), Color.m5828boximpl(Color.INSTANCE.m5873getTransparent0d7_KjU())}), Offset.m5559constructorimpl((((long) Float.floatToRawIntBits(0.25f * fIntBitsToFloat2)) & 4294967295L) | (((long) Float.floatToRawIntBits(0.35f * fIntBitsToFloat)) << 32)), fIntBitsToFloat * 0.68f, 0, 8, (Object) null);
        final Brush brushM5765radialGradientP_VxKs$default2 = Brush.Companion.m5765radialGradientP_VxKs$default(Brush.INSTANCE, CollectionsKt.listOf((Object[]) new Color[]{Color.m5828boximpl(Color.m5837copywmQWz5c$default(Color.INSTANCE.m5875getWhite0d7_KjU(), 0.18f, 0.0f, 0.0f, 0.0f, 14, null)), Color.m5828boximpl(Color.m5837copywmQWz5c$default(Color.INSTANCE.m5875getWhite0d7_KjU(), 0.045f, 0.0f, 0.0f, 0.0f, 14, null)), Color.m5828boximpl(Color.INSTANCE.m5873getTransparent0d7_KjU())}), Offset.m5559constructorimpl((((long) Float.floatToRawIntBits(0.27f * fIntBitsToFloat)) << 32) | (((long) Float.floatToRawIntBits(f2)) & 4294967295L)), fIntBitsToFloat * 0.42f, 0, 8, (Object) null);
        final Brush brushM5765radialGradientP_VxKs$default3 = Brush.Companion.m5765radialGradientP_VxKs$default(Brush.INSTANCE, CollectionsKt.listOf((Object[]) new Color[]{Color.m5828boximpl(Color.m5837copywmQWz5c$default(Color.INSTANCE.m5875getWhite0d7_KjU(), 0.045f, 0.0f, 0.0f, 0.0f, 14, null)), Color.m5828boximpl(Color.INSTANCE.m5873getTransparent0d7_KjU())}), Offset.m5559constructorimpl((((long) Float.floatToRawIntBits(fIntBitsToFloat * 0.8f)) << 32) | (((long) Float.floatToRawIntBits(fIntBitsToFloat2 * 0.8f)) & 4294967295L)), fIntBitsToFloat * 0.5f, 0, 8, (Object) null);
        final Brush brushM5767sweepGradientUv8p0NA$default = Brush.Companion.m5767sweepGradientUv8p0NA$default(Brush.INSTANCE, CollectionsKt.listOf((Object[]) new Color[]{Color.m5828boximpl(Color.INSTANCE.m5873getTransparent0d7_KjU()), Color.m5828boximpl(Color.INSTANCE.m5873getTransparent0d7_KjU()), Color.m5828boximpl(Color.INSTANCE.m5873getTransparent0d7_KjU()), Color.m5828boximpl(Color.m5837copywmQWz5c$default(ColorKt.Color(4286113791L), 0.25f, 0.0f, 0.0f, 0.0f, 14, null)), Color.m5828boximpl(Color.INSTANCE.m5873getTransparent0d7_KjU()), Color.m5828boximpl(Color.m5837copywmQWz5c$default(ColorKt.Color(4287470591L), 0.18f, 0.0f, 0.0f, 0.0f, 14, null)), Color.m5828boximpl(Color.INSTANCE.m5873getTransparent0d7_KjU()), Color.m5828boximpl(Color.INSTANCE.m5873getTransparent0d7_KjU()), Color.m5828boximpl(Color.m5837copywmQWz5c$default(ColorKt.Color(4294938568L), 0.2f, 0.0f, 0.0f, 0.0f, 14, null)), Color.m5828boximpl(Color.INSTANCE.m5873getTransparent0d7_KjU()), Color.m5828boximpl(Color.m5837copywmQWz5c$default(ColorKt.Color(4294950018L), 0.12f, 0.0f, 0.0f, 0.0f, 14, null)), Color.m5828boximpl(Color.INSTANCE.m5873getTransparent0d7_KjU()), Color.m5828boximpl(Color.INSTANCE.m5873getTransparent0d7_KjU())}), 0L, 2, (Object) null);
        final Brush brushM5769verticalGradient8A3gB4$default = Brush.Companion.m5769verticalGradient8A3gB4$default(Brush.INSTANCE, CollectionsKt.listOf((Object[]) new Color[]{Color.m5828boximpl(Color.INSTANCE.m5873getTransparent0d7_KjU()), Color.m5828boximpl(Color.m5837copywmQWz5c$default(Color.INSTANCE.m5864getBlack0d7_KjU(), 0.12f, 0.0f, 0.0f, 0.0f, 14, null))}), 0.0f, 0.0f, 0, 14, (Object) null);
        final Brush brushM5769verticalGradient8A3gB4$default2 = Brush.Companion.m5769verticalGradient8A3gB4$default(Brush.INSTANCE, CollectionsKt.listOf((Object[]) new Color[]{Color.m5828boximpl(Color.m5837copywmQWz5c$default(Color.INSTANCE.m5875getWhite0d7_KjU(), 0.25f, 0.0f, 0.0f, 0.0f, 14, null)), Color.m5828boximpl(Color.m5837copywmQWz5c$default(Color.INSTANCE.m5875getWhite0d7_KjU(), 0.05f, 0.0f, 0.0f, 0.0f, 14, null)), Color.m5828boximpl(Color.INSTANCE.m5873getTransparent0d7_KjU()), Color.m5828boximpl(Color.m5837copywmQWz5c$default(Color.INSTANCE.m5864getBlack0d7_KjU(), 0.04f, 0.0f, 0.0f, 0.0f, 14, null))}), 0.0f, 0.0f, 0, 14, (Object) null);
        return drawWithCache.onDrawBehind(new Function1() { // from class: com.example.tickets.GlassComponentsKt$$ExternalSyntheticLambda11
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return GlassComponentsKt.GlassNavigationBar$lambda$36$lambda$34$lambda$33$lambda$32(brushM5763linearGradientmHitzGk$default, f, brushM5765radialGradientP_VxKs$default, brushM5765radialGradientP_VxKs$default2, brushM5765radialGradientP_VxKs$default3, brushM5767sweepGradientUv8p0NA$default, brushM5769verticalGradient8A3gB4$default, brushM5769verticalGradient8A3gB4$default2, (DrawScope) obj);
            }
        });
    }

    /* JADX WARN: Code duplicated, block: B:44:0x0081  */
    /* JADX WARN: Code duplicated, block: B:46:0x0089  */
    /* JADX WARN: Code duplicated, block: B:47:0x008c  */
    /* JADX WARN: Code duplicated, block: B:49:0x0090  */
    /* JADX WARN: Code duplicated, block: B:52:0x009b  */
    /* JADX WARN: Code duplicated, block: B:53:0x009d  */
    /* JADX WARN: Code duplicated, block: B:56:0x00a6 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:57:0x00a8  */
    /* JADX WARN: Code duplicated, block: B:58:0x00ad  */
    /* JADX WARN: Code duplicated, block: B:61:0x00b4  */
    /* JADX WARN: Code duplicated, block: B:64:0x00ce  */
    /* JADX WARN: Code duplicated, block: B:67:0x010d  */
    /* JADX WARN: Code duplicated, block: B:68:0x0114  */
    /* JADX WARN: Code duplicated, block: B:71:0x0162  */
    /* JADX WARN: Code duplicated, block: B:73:0x0167  */
    /* JADX WARN: Code duplicated, block: B:76:0x0171  */
    /* JADX WARN: Code duplicated, block: B:78:? A[RETURN, SYNTHETIC] */
    /* JADX INFO: renamed from: NavigationTab-jIwJxvA, reason: not valid java name */
    private static final void m9297NavigationTabjIwJxvA(final String str, final boolean z, final NavigationIconType navigationIconType, final float f, Modifier modifier, final Function0<Unit> function0, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        boolean z2;
        final Modifier modifier3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier.Companion companion;
        Object objRememberedValue;
        State<Boolean> stateCollectIsPressedAsState;
        float fM8748constructorimpl;
        int i4;
        Composer composerStartRestartGroup = composer.startRestartGroup(441480786);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(NavigationTab)N(label,selected,iconType,horizontalShift:c#ui.unit.Dp,modifier,onClick)970@31189L59,975@31291L25,993@31780L2437,980@31376L2841:GlassComponents.kt#n9ob9m");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(str) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changed(z) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changed(navigationIconType.ordinal()) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i3 |= composerStartRestartGroup.changed(f) ? 2048 : 1024;
        }
        int i5 = i2 & 16;
        if (i5 == 0) {
            if ((i & 24576) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 16384 : 8192;
            }
            if ((196608 & i) != 0) {
                if (composerStartRestartGroup.changedInstance(function0)) {
                    i4 = 131072;
                } else {
                    i4 = 65536;
                }
                i3 |= i4;
            }
            if ((74899 & i3) != 74898) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z2, i3 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
            } else {
                if (i5 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(441480786, i3, -1, "com.example.tickets.NavigationTab (GlassComponents.kt:967)");
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -938719219, "CC(remember):GlassComponents.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                MutableInteractionSource mutableInteractionSource = (MutableInteractionSource) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                stateCollectIsPressedAsState = PressInteractionKt.collectIsPressedAsState(mutableInteractionSource, composerStartRestartGroup, 6);
                RoundedCornerShape roundedCornerShapeM1756RoundedCornerShape0680j_4 = RoundedCornerShapeKt.m1756RoundedCornerShape0680j_4(Dp.m8748constructorimpl(31.0f));
                Modifier modifierM1383offsetVpY3zN4$default = OffsetKt.m1383offsetVpY3zN4$default(SizeKt.m1492sizeVpY3zN4(Modifier.INSTANCE, Dp.m8748constructorimpl(80.0f), Dp.m8748constructorimpl(62.0f)), f, 0.0f, 2, null);
                if (NavigationTab_jIwJxvA$lambda$39(stateCollectIsPressedAsState)) {
                    fM8748constructorimpl = Dp.m8748constructorimpl(3.0f);
                } else {
                    fM8748constructorimpl = Dp.m8748constructorimpl(0.0f);
                }
                RoundedCornerShape roundedCornerShape = roundedCornerShapeM1756RoundedCornerShape0680j_4;
                Modifier modifier4 = companion;
                IconButtonKt.IconButton(function0, ClipKt.clip(ShadowKt.m5414shadows4CzXII$default(modifierM1383offsetVpY3zN4$default, fM8748constructorimpl, roundedCornerShape, false, 0L, 0L, 24, null), roundedCornerShape).then(companion), false, null, mutableInteractionSource, null, ComposableLambdaKt.rememberComposableLambda(1902911732, true, new Function2() { // from class: com.example.tickets.GlassComponentsKt$$ExternalSyntheticLambda12
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return GlassComponentsKt.NavigationTab_jIwJxvA$lambda$41(navigationIconType, z, str, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i3 >> 15) & 14) | 1597440, 44);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier4;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.tickets.GlassComponentsKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return GlassComponentsKt.NavigationTab_jIwJxvA$lambda$42(str, z, navigationIconType, f, modifier3, function0, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 24576;
        modifier2 = modifier;
        if ((196608 & i) != 0) {
            if (composerStartRestartGroup.changedInstance(function0)) {
                i4 = 131072;
            } else {
                i4 = 65536;
            }
            i3 |= i4;
        }
        if ((74899 & i3) != 74898) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z2, i3 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
        } else {
            if (i5 != 0) {
                companion = Modifier.INSTANCE;
            } else {
                companion = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(441480786, i3, -1, "com.example.tickets.NavigationTab (GlassComponents.kt:967)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -938719219, "CC(remember):GlassComponents.kt#9igjgp");
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            MutableInteractionSource mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            stateCollectIsPressedAsState = PressInteractionKt.collectIsPressedAsState(mutableInteractionSource2, composerStartRestartGroup, 6);
            RoundedCornerShape roundedCornerShapeM1756RoundedCornerShape0680j_5 = RoundedCornerShapeKt.m1756RoundedCornerShape0680j_4(Dp.m8748constructorimpl(31.0f));
            Modifier modifierM1383offsetVpY3zN4$default2 = OffsetKt.m1383offsetVpY3zN4$default(SizeKt.m1492sizeVpY3zN4(Modifier.INSTANCE, Dp.m8748constructorimpl(80.0f), Dp.m8748constructorimpl(62.0f)), f, 0.0f, 2, null);
            if (NavigationTab_jIwJxvA$lambda$39(stateCollectIsPressedAsState)) {
                fM8748constructorimpl = Dp.m8748constructorimpl(3.0f);
            } else {
                fM8748constructorimpl = Dp.m8748constructorimpl(0.0f);
            }
            RoundedCornerShape roundedCornerShape2 = roundedCornerShapeM1756RoundedCornerShape0680j_5;
            Modifier modifier5 = companion;
            IconButtonKt.IconButton(function0, ClipKt.clip(ShadowKt.m5414shadows4CzXII$default(modifierM1383offsetVpY3zN4$default2, fM8748constructorimpl, roundedCornerShape2, false, 0L, 0L, 24, null), roundedCornerShape2).then(companion), false, null, mutableInteractionSource2, null, ComposableLambdaKt.rememberComposableLambda(1902911732, true, new Function2() { // from class: com.example.tickets.GlassComponentsKt$$ExternalSyntheticLambda12
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return GlassComponentsKt.NavigationTab_jIwJxvA$lambda$41(navigationIconType, z, str, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i3 >> 15) & 14) | 1597440, 44);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier5;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.tickets.GlassComponentsKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return GlassComponentsKt.NavigationTab_jIwJxvA$lambda$42(str, z, navigationIconType, f, modifier3, function0, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    static final Unit NavigationTab_jIwJxvA$lambda$41(NavigationIconType navigationIconType, boolean z, String str, Composer composer, int i) {
        long jColor;
        long jColor2;
        long jColor3;
        long jColor4;
        ComposerKt.sourceInformation(composer, "C995@31791L2420:GlassComponents.kt#n9ob9m");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1902911732, i, -1, "com.example.tickets.NavigationTab.<anonymous> (GlassComponents.kt:995)");
            }
            Alignment.Horizontal centerHorizontally = Alignment.INSTANCE.getCenterHorizontally();
            Arrangement.HorizontalOrVertical center = Arrangement.INSTANCE.getCenter();
            ComposerKt.sourceInformationMarkerStart(composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Modifier.Companion companion = Modifier.INSTANCE;
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(center, centerHorizontally, composer, 54);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, companion);
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
            ComposerKt.sourceInformationMarkerStart(composer, 168924401, "C1053@33893L308:GlassComponents.kt#n9ob9m");
            int i2 = WhenMappings.$EnumSwitchMapping$0[navigationIconType.ordinal()];
            if (i2 == 1) {
                composer.startReplaceGroup(168933824);
                ComposerKt.sourceInformation(composer, "1004@32059L444");
                ImageVector confirmationNumber = ConfirmationNumberKt.getConfirmationNumber(Icons.Rounded.INSTANCE);
                if (z) {
                    jColor = Color.INSTANCE.m5875getWhite0d7_KjU();
                } else {
                    jColor = ColorKt.Color(4288059036L);
                }
                IconKt.m3109Iconww6aTOc(confirmationNumber, str, SizeKt.m1490size3ABfNKs(Modifier.INSTANCE, Dp.m8748constructorimpl(22.0f)), jColor, composer, 384, 0);
                composer.endReplaceGroup();
            } else if (i2 == 2) {
                composer.startReplaceGroup(169469566);
                ComposerKt.sourceInformation(composer, "1020@32659L108,1018@32590L734");
                Painter painterPainterResource = PainterResources_androidKt.painterResource(R.drawable.train_clipart, composer, 0);
                Modifier modifierM1490size3ABfNKs = SizeKt.m1490size3ABfNKs(Modifier.INSTANCE, Dp.m8748constructorimpl(28.0f));
                ContentScale fit = ContentScale.INSTANCE.getFit();
                ColorFilter.Companion companion2 = ColorFilter.INSTANCE;
                if (z) {
                    jColor3 = Color.INSTANCE.m5875getWhite0d7_KjU();
                } else {
                    jColor3 = ColorKt.Color(4288059036L);
                }
                ImageKt.Image(painterPainterResource, str, modifierM1490size3ABfNKs, (Alignment) null, fit, 0.0f, ColorFilter.Companion.m5879tintxETnrds$default(companion2, jColor3, 0, 2, null), composer, Painter.$stable | 24960, 40);
                composer.endReplaceGroup();
            } else {
                if (i2 != 3) {
                    composer.startReplaceGroup(-133098480);
                    composer.endReplaceGroup();
                    throw new NoWhenBranchMatchedException();
                }
                composer.startReplaceGroup(170276682);
                ComposerKt.sourceInformation(composer, "1039@33413L434");
                ImageVector settings = SettingsKt.getSettings(Icons.Rounded.INSTANCE);
                if (z) {
                    jColor4 = Color.INSTANCE.m5875getWhite0d7_KjU();
                } else {
                    jColor4 = ColorKt.Color(4288059036L);
                }
                IconKt.m3109Iconww6aTOc(settings, str, SizeKt.m1490size3ABfNKs(Modifier.INSTANCE, Dp.m8748constructorimpl(22.0f)), jColor4, composer, 384, 0);
                composer.endReplaceGroup();
            }
            if (z) {
                jColor2 = Color.INSTANCE.m5875getWhite0d7_KjU();
            } else {
                jColor2 = ColorKt.Color(4288059036L);
            }
            TextKt.m3661TextNvy7gAk(str, Modifier.INSTANCE, jColor2, null, TextUnitKt.getSp(9), null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer, 24624, 0, 262120);
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

    /* JADX WARN: Code duplicated, block: B:23:0x0050  */
    /* JADX WARN: Code duplicated, block: B:24:0x0053  */
    /* JADX WARN: Code duplicated, block: B:27:0x005c  */
    /* JADX WARN: Code duplicated, block: B:29:0x005f  */
    /* JADX WARN: Code duplicated, block: B:32:0x0066  */
    /* JADX WARN: Code duplicated, block: B:35:0x0080  */
    /* JADX WARN: Code duplicated, block: B:38:0x009c  */
    /* JADX WARN: Code duplicated, block: B:39:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:42:0x00cd  */
    /* JADX WARN: Code duplicated, block: B:43:0x00d0  */
    /* JADX WARN: Code duplicated, block: B:48:0x0116  */
    /* JADX WARN: Code duplicated, block: B:51:0x0133  */
    /* JADX WARN: Code duplicated, block: B:52:0x0183  */
    /* JADX WARN: Code duplicated, block: B:55:0x02eb  */
    /* JADX WARN: Code duplicated, block: B:58:0x02f7  */
    /* JADX WARN: Code duplicated, block: B:59:0x02fb  */
    /* JADX WARN: Code duplicated, block: B:62:0x0388  */
    /* JADX WARN: Code duplicated, block: B:63:0x038c  */
    /* JADX WARN: Code duplicated, block: B:66:0x0399  */
    /* JADX WARN: Code duplicated, block: B:68:? A[RETURN, SYNTHETIC] */
    public static final void GlassAddButton(Function0<Unit> onClick, HazeState hazeState, Composer composer, final int i, final int i2) {
        int i3;
        HazeState hazeState2;
        boolean z;
        Composer composer2;
        final Function0<Unit> function0;
        final HazeState hazeState3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Object objRememberedValue;
        State<Boolean> stateCollectIsPressedAsState;
        float f;
        final State<Float> stateAnimateFloatAsState;
        float f2;
        final State<Float> stateAnimateFloatAsState2;
        boolean zChanged;
        Object objRememberedValue2;
        Modifier.Companion companionHazeEffect$default;
        Function0<ComposeUiNode> constructor;
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1624179324);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(GlassAddButton)N(onClick,hazeState)1082@34517L59,1087@34619L25,1092@34691L309,1110@35052L273,1127@35416L114,1124@35331L3107:GlassComponents.kt#n9ob9m");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(onClick) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i4 = i2 & 2;
        if (i4 == 0) {
            if ((i & 48) == 0) {
                hazeState2 = hazeState;
                i3 |= composerStartRestartGroup.changed(hazeState2) ? 32 : 16;
            }
            if ((i3 & 19) != 18) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composer2 = composerStartRestartGroup;
                function0 = onClick;
                composer2.skipToGroupEnd();
                hazeState3 = hazeState2;
            } else {
                if (i4 != 0) {
                    hazeState2 = null;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1624179324, i3, -1, "com.example.tickets.GlassAddButton (GlassComponents.kt:1079)");
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1763197665, "CC(remember):GlassComponents.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                MutableInteractionSource mutableInteractionSource = (MutableInteractionSource) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                stateCollectIsPressedAsState = PressInteractionKt.collectIsPressedAsState(mutableInteractionSource, composerStartRestartGroup, 6);
                if (GlassAddButton$lambda$44(stateCollectIsPressedAsState)) {
                    f = 0.91f;
                } else {
                    f = 1.0f;
                }
                stateAnimateFloatAsState = AnimateAsStateKt.animateFloatAsState(f, AnimationSpecKt.spring$default(0.72f, 700.0f, null, 4, null), 0.0f, "addScale", null, composerStartRestartGroup, 3120, 20);
                if (GlassAddButton$lambda$44(stateCollectIsPressedAsState)) {
                    f2 = 0.72f;
                } else {
                    f2 = 1.0f;
                }
                stateAnimateFloatAsState2 = AnimateAsStateKt.animateFloatAsState(f2, AnimationSpecKt.tween$default(70, 0, null, 6, null), 0.0f, "addAlpha", null, composerStartRestartGroup, 3120, 20);
                Modifier modifierM1490size3ABfNKs = SizeKt.m1490size3ABfNKs(Modifier.INSTANCE, Dp.m8748constructorimpl(68.0f));
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1763168842, "CC(remember):GlassComponents.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(stateAnimateFloatAsState) | composerStartRestartGroup.changed(stateAnimateFloatAsState2);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (!zChanged || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = new Function1() { // from class: com.example.tickets.GlassComponentsKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return GlassComponentsKt.GlassAddButton$lambda$48$lambda$47(stateAnimateFloatAsState, stateAnimateFloatAsState2, (GraphicsLayerScope) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Modifier modifierClip = ClipKt.clip(GraphicsLayerModifierKt.graphicsLayer(modifierM1490size3ABfNKs, (Function1) objRememberedValue2), RoundedCornerShapeKt.getCircleShape());
                if (hazeState2 != null) {
                    hazeState3 = hazeState2;
                    companionHazeEffect$default = HazeChildKt.hazeEffect$default(Modifier.INSTANCE, hazeState3, new HazeStyle(Color.INSTANCE.m5873getTransparent0d7_KjU(), new HazeTint(Color.m5837copywmQWz5c$default(Color.INSTANCE.m5875getWhite0d7_KjU(), 0.16f, 0.0f, 0.0f, 0.0f, 14, null), 0, 2, (DefaultConstructorMarker) null), Dp.m8748constructorimpl(30.0f), 0.0f, (HazeTint) null, 24, (DefaultConstructorMarker) null), null, 4, null);
                } else {
                    hazeState3 = hazeState2;
                    companionHazeEffect$default = Modifier.INSTANCE;
                }
                Modifier modifierM679clickableO2vRcR0$default = ClickableKt.m679clickableO2vRcR0$default(BorderKt.m661borderziNgDLE(BackgroundKt.background$default(BackgroundKt.background$default(modifierClip.then(companionHazeEffect$default), Brush.Companion.m5769verticalGradient8A3gB4$default(Brush.INSTANCE, CollectionsKt.listOf((Object[]) new Color[]{Color.m5828boximpl(Color.m5837copywmQWz5c$default(Color.INSTANCE.m5875getWhite0d7_KjU(), 0.18f, 0.0f, 0.0f, 0.0f, 14, null)), Color.m5828boximpl(Color.m5837copywmQWz5c$default(Color.INSTANCE.m5875getWhite0d7_KjU(), 0.105f, 0.0f, 0.0f, 0.0f, 14, null)), Color.m5828boximpl(Color.m5837copywmQWz5c$default(Color.INSTANCE.m5875getWhite0d7_KjU(), 0.075f, 0.0f, 0.0f, 0.0f, 14, null))}), 0.0f, 0.0f, 0, 14, (Object) null), RoundedCornerShapeKt.getCircleShape(), 0.0f, 4, null), Brush.Companion.m5765radialGradientP_VxKs$default(Brush.INSTANCE, CollectionsKt.listOf((Object[]) new Color[]{Color.m5828boximpl(Color.m5837copywmQWz5c$default(Color.INSTANCE.m5875getWhite0d7_KjU(), 0.065f, 0.0f, 0.0f, 0.0f, 14, null)), Color.m5828boximpl(Color.INSTANCE.m5873getTransparent0d7_KjU())}), 0L, 126.0f, 0, 10, (Object) null), RoundedCornerShapeKt.getCircleShape(), 0.0f, 4, null), Dp.m8748constructorimpl(1.0f), Brush.Companion.m5769verticalGradient8A3gB4$default(Brush.INSTANCE, CollectionsKt.listOf((Object[]) new Color[]{Color.m5828boximpl(Color.m5837copywmQWz5c$default(Color.INSTANCE.m5875getWhite0d7_KjU(), 0.22f, 0.0f, 0.0f, 0.0f, 14, null)), Color.m5828boximpl(Color.m5837copywmQWz5c$default(Color.INSTANCE.m5875getWhite0d7_KjU(), 0.065f, 0.0f, 0.0f, 0.0f, 14, null))}), 0.0f, 0.0f, 0, 14, (Object) null), RoundedCornerShapeKt.getCircleShape()), mutableInteractionSource, null, false, null, null, onClick, 28, null);
                function0 = onClick;
                Alignment center = Alignment.INSTANCE.getCenter();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
                int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM679clickableO2vRcR0$default);
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
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1770712952, "C1222@38255L177:GlassComponents.kt#n9ob9m");
                IconKt.m3109Iconww6aTOc(AddKt.getAdd(Icons.INSTANCE.getDefault()), "添加票据", SizeKt.m1490size3ABfNKs(Modifier.INSTANCE, Dp.m8748constructorimpl(34.0f)), Color.INSTANCE.m5875getWhite0d7_KjU(), composerStartRestartGroup, 3504, 0);
                composer2 = composerStartRestartGroup;
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
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.tickets.GlassComponentsKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return GlassComponentsKt.GlassAddButton$lambda$50(function0, hazeState3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 48;
        hazeState2 = hazeState;
        if ((i3 & 19) != 18) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
            composer2 = composerStartRestartGroup;
            function0 = onClick;
            composer2.skipToGroupEnd();
            hazeState3 = hazeState2;
        } else {
            if (i4 != 0) {
                hazeState2 = null;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1624179324, i3, -1, "com.example.tickets.GlassAddButton (GlassComponents.kt:1079)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1763197665, "CC(remember):GlassComponents.kt#9igjgp");
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            MutableInteractionSource mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            stateCollectIsPressedAsState = PressInteractionKt.collectIsPressedAsState(mutableInteractionSource2, composerStartRestartGroup, 6);
            if (GlassAddButton$lambda$44(stateCollectIsPressedAsState)) {
                f = 0.91f;
            } else {
                f = 1.0f;
            }
            stateAnimateFloatAsState = AnimateAsStateKt.animateFloatAsState(f, AnimationSpecKt.spring$default(0.72f, 700.0f, null, 4, null), 0.0f, "addScale", null, composerStartRestartGroup, 3120, 20);
            if (GlassAddButton$lambda$44(stateCollectIsPressedAsState)) {
                f2 = 0.72f;
            } else {
                f2 = 1.0f;
            }
            stateAnimateFloatAsState2 = AnimateAsStateKt.animateFloatAsState(f2, AnimationSpecKt.tween$default(70, 0, null, 6, null), 0.0f, "addAlpha", null, composerStartRestartGroup, 3120, 20);
            Modifier modifierM1490size3ABfNKs2 = SizeKt.m1490size3ABfNKs(Modifier.INSTANCE, Dp.m8748constructorimpl(68.0f));
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1763168842, "CC(remember):GlassComponents.kt#9igjgp");
            zChanged = composerStartRestartGroup.changed(stateAnimateFloatAsState) | composerStartRestartGroup.changed(stateAnimateFloatAsState2);
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (!zChanged) {
                objRememberedValue2 = new Function1() { // from class: com.example.tickets.GlassComponentsKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return GlassComponentsKt.GlassAddButton$lambda$48$lambda$47(stateAnimateFloatAsState, stateAnimateFloatAsState2, (GraphicsLayerScope) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            } else {
                objRememberedValue2 = new Function1() { // from class: com.example.tickets.GlassComponentsKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return GlassComponentsKt.GlassAddButton$lambda$48$lambda$47(stateAnimateFloatAsState, stateAnimateFloatAsState2, (GraphicsLayerScope) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierClip2 = ClipKt.clip(GraphicsLayerModifierKt.graphicsLayer(modifierM1490size3ABfNKs2, (Function1) objRememberedValue2), RoundedCornerShapeKt.getCircleShape());
            if (hazeState2 != null) {
                hazeState3 = hazeState2;
                companionHazeEffect$default = HazeChildKt.hazeEffect$default(Modifier.INSTANCE, hazeState3, new HazeStyle(Color.INSTANCE.m5873getTransparent0d7_KjU(), new HazeTint(Color.m5837copywmQWz5c$default(Color.INSTANCE.m5875getWhite0d7_KjU(), 0.16f, 0.0f, 0.0f, 0.0f, 14, null), 0, 2, (DefaultConstructorMarker) null), Dp.m8748constructorimpl(30.0f), 0.0f, (HazeTint) null, 24, (DefaultConstructorMarker) null), null, 4, null);
            } else {
                hazeState3 = hazeState2;
                companionHazeEffect$default = Modifier.INSTANCE;
            }
            Modifier modifierM679clickableO2vRcR0$default2 = ClickableKt.m679clickableO2vRcR0$default(BorderKt.m661borderziNgDLE(BackgroundKt.background$default(BackgroundKt.background$default(modifierClip2.then(companionHazeEffect$default), Brush.Companion.m5769verticalGradient8A3gB4$default(Brush.INSTANCE, CollectionsKt.listOf((Object[]) new Color[]{Color.m5828boximpl(Color.m5837copywmQWz5c$default(Color.INSTANCE.m5875getWhite0d7_KjU(), 0.18f, 0.0f, 0.0f, 0.0f, 14, null)), Color.m5828boximpl(Color.m5837copywmQWz5c$default(Color.INSTANCE.m5875getWhite0d7_KjU(), 0.105f, 0.0f, 0.0f, 0.0f, 14, null)), Color.m5828boximpl(Color.m5837copywmQWz5c$default(Color.INSTANCE.m5875getWhite0d7_KjU(), 0.075f, 0.0f, 0.0f, 0.0f, 14, null))}), 0.0f, 0.0f, 0, 14, (Object) null), RoundedCornerShapeKt.getCircleShape(), 0.0f, 4, null), Brush.Companion.m5765radialGradientP_VxKs$default(Brush.INSTANCE, CollectionsKt.listOf((Object[]) new Color[]{Color.m5828boximpl(Color.m5837copywmQWz5c$default(Color.INSTANCE.m5875getWhite0d7_KjU(), 0.065f, 0.0f, 0.0f, 0.0f, 14, null)), Color.m5828boximpl(Color.INSTANCE.m5873getTransparent0d7_KjU())}), 0L, 126.0f, 0, 10, (Object) null), RoundedCornerShapeKt.getCircleShape(), 0.0f, 4, null), Dp.m8748constructorimpl(1.0f), Brush.Companion.m5769verticalGradient8A3gB4$default(Brush.INSTANCE, CollectionsKt.listOf((Object[]) new Color[]{Color.m5828boximpl(Color.m5837copywmQWz5c$default(Color.INSTANCE.m5875getWhite0d7_KjU(), 0.22f, 0.0f, 0.0f, 0.0f, 14, null)), Color.m5828boximpl(Color.m5837copywmQWz5c$default(Color.INSTANCE.m5875getWhite0d7_KjU(), 0.065f, 0.0f, 0.0f, 0.0f, 14, null))}), 0.0f, 0.0f, 0, 14, (Object) null), RoundedCornerShapeKt.getCircleShape()), mutableInteractionSource2, null, false, null, null, onClick, 28, null);
            function0 = onClick;
            Alignment center2 = Alignment.INSTANCE.getCenter();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(center2, false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
            int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM679clickableO2vRcR0$default2);
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1770712952, "C1222@38255L177:GlassComponents.kt#n9ob9m");
            IconKt.m3109Iconww6aTOc(AddKt.getAdd(Icons.INSTANCE.getDefault()), "添加票据", SizeKt.m1490size3ABfNKs(Modifier.INSTANCE, Dp.m8748constructorimpl(34.0f)), Color.INSTANCE.m5875getWhite0d7_KjU(), composerStartRestartGroup, 3504, 0);
            composer2 = composerStartRestartGroup;
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.tickets.GlassComponentsKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return GlassComponentsKt.GlassAddButton$lambda$50(function0, hazeState3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    static final Unit GlassAddButton$lambda$48$lambda$47(State state, State state2, GraphicsLayerScope graphicsLayer) {
        Intrinsics.checkNotNullParameter(graphicsLayer, "$this$graphicsLayer");
        graphicsLayer.setScaleX(GlassAddButton$lambda$45(state));
        graphicsLayer.setScaleY(GlassAddButton$lambda$45(state));
        graphicsLayer.setAlpha(GlassAddButton$lambda$46(state2));
        return Unit.INSTANCE;
    }

    private static final float GlassNavigationBar$lambda$9(State<Float> state) {
        return state.getValue().floatValue();
    }

    private static final float GlassNavigationBar$lambda$10(State<Float> state) {
        return state.getValue().floatValue();
    }

    private static final float GlassNavigationBar$lambda$12(State<Float> state) {
        return state.getValue().floatValue();
    }

    static final Unit GlassNavigationBar$lambda$36$lambda$34$lambda$33$lambda$32(Brush brush, float f, Brush brush2, Brush brush3, Brush brush4, Brush brush5, Brush brush6, Brush brush7, DrawScope onDrawBehind) {
        Intrinsics.checkNotNullParameter(onDrawBehind, "$this$onDrawBehind");
        DrawScope.m6432drawRoundRectZuiqVtQ$default(onDrawBehind, brush, 0L, 0L, CornerRadius.m5521constructorimpl((((long) Float.floatToRawIntBits(f)) << 32) | (((long) Float.floatToRawIntBits(f)) & 4294967295L)), 0.0f, null, null, 0, 246, null);
        DrawScope.m6432drawRoundRectZuiqVtQ$default(onDrawBehind, brush2, 0L, 0L, CornerRadius.m5521constructorimpl((((long) Float.floatToRawIntBits(f)) << 32) | (((long) Float.floatToRawIntBits(f)) & 4294967295L)), 0.0f, null, null, 0, 246, null);
        DrawScope.m6432drawRoundRectZuiqVtQ$default(onDrawBehind, brush3, 0L, 0L, CornerRadius.m5521constructorimpl((((long) Float.floatToRawIntBits(f)) << 32) | (((long) Float.floatToRawIntBits(f)) & 4294967295L)), 0.0f, null, null, 0, 246, null);
        DrawScope.m6432drawRoundRectZuiqVtQ$default(onDrawBehind, brush4, 0L, 0L, CornerRadius.m5521constructorimpl((((long) Float.floatToRawIntBits(f)) << 32) | (((long) Float.floatToRawIntBits(f)) & 4294967295L)), 0.0f, null, null, 0, 246, null);
        DrawScope.m6432drawRoundRectZuiqVtQ$default(onDrawBehind, brush5, 0L, 0L, CornerRadius.m5521constructorimpl((((long) Float.floatToRawIntBits(f)) << 32) | (((long) Float.floatToRawIntBits(f)) & 4294967295L)), 0.0f, new Stroke(onDrawBehind.mo803toPx0680j_4(Dp.m8748constructorimpl(1.05f)), 0.0f, 0, 0, null, 30, null), null, 0, 214, null);
        DrawScope.m6432drawRoundRectZuiqVtQ$default(onDrawBehind, brush6, 0L, 0L, CornerRadius.m5521constructorimpl((((long) Float.floatToRawIntBits(f)) << 32) | (((long) Float.floatToRawIntBits(f)) & 4294967295L)), 0.0f, new Stroke(onDrawBehind.mo803toPx0680j_4(Dp.m8748constructorimpl(1.0f)), 0.0f, 0, 0, null, 30, null), null, 0, 214, null);
        Stroke stroke = new Stroke(onDrawBehind.mo803toPx0680j_4(Dp.m8748constructorimpl(0.75f)), 0.0f, 0, 0, null, 30, null);
        float f2 = f - onDrawBehind.mo803toPx0680j_4(Dp.m8748constructorimpl(1.0f));
        DrawScope.m6432drawRoundRectZuiqVtQ$default(onDrawBehind, brush7, 0L, 0L, CornerRadius.m5521constructorimpl((((long) Float.floatToRawIntBits(f - onDrawBehind.mo803toPx0680j_4(Dp.m8748constructorimpl(1.0f)))) & 4294967295L) | (Float.floatToRawIntBits(f2) << 32)), 0.0f, stroke, null, 0, 214, null);
        return Unit.INSTANCE;
    }

    private static final boolean NavigationTab_jIwJxvA$lambda$39(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    private static final boolean GlassAddButton$lambda$44(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    private static final float GlassAddButton$lambda$45(State<Float> state) {
        return state.getValue().floatValue();
    }

    private static final float GlassAddButton$lambda$46(State<Float> state) {
        return state.getValue().floatValue();
    }
}
