package com.example.tickets;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.InfiniteRepeatableSpec;
import androidx.compose.animation.core.InfiniteTransition;
import androidx.compose.animation.core.InfiniteTransitionKt;
import androidx.compose.animation.core.RepeatMode;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.style.StylePropertiesKt;
import androidx.compose.material3.ButtonKt;
import androidx.compose.material3.MaterialThemeKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.composer.linkbuffer.GroupFlagsKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.AlphaKt;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.draw.RotateKt;
import androidx.compose.ui.draw.ScaleKt;
import androidx.compose.ui.geometry.CornerRadius;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.profileinstaller.ProfileVerifier;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: TicketFluidGlow.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000Z\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\u001ai\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u0012H\u0007¢\u0006\u0004\b\u0013\u0010\u0014\u001a?\u0010\u0015\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u00122\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0012H\u0003¢\u0006\u0004\b\u0019\u0010\u001a\u001a3\u0010\u001b\u001a\u00020\u0001*\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u00122\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u001e\u0010\u001f\u001aA\u0010 \u001a\u00020\u0001*\u00020!2\u0006\u0010\"\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u000b2\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020&H\u0007¢\u0006\u0004\b'\u0010(\u001a\u0013\u0010)\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010*\u001a\u000e\u0010+\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005\u001a\r\u0010,\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010-\u001a\r\u0010.\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010-\u001a-\u0010/\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u0003H\u0003¢\u0006\u0002\u00100¨\u00061²\u0006\n\u00102\u001a\u00020\u0012X\u008a\u0084\u0002²\u0006\n\u0010\u0006\u001a\u00020\u0007X\u008a\u008e\u0002"}, d2 = {"TicketFluidGlow", "", "modifier", "Landroidx/compose/ui/Modifier;", "ticketType", "", "state", "Lcom/example/tickets/TicketFluidState;", "edge", "Lcom/example/tickets/TicketFluidEdge;", "themeColor", "Landroidx/compose/ui/graphics/Color;", "stampText", "showStamp", "", "shape", "Landroidx/compose/ui/graphics/Shape;", "coverage", "", "TicketFluidGlow-eq_XX3s", "(Landroidx/compose/ui/Modifier;Ljava/lang/String;Lcom/example/tickets/TicketFluidState;Lcom/example/tickets/TicketFluidEdge;Landroidx/compose/ui/graphics/Color;Ljava/lang/String;ZLandroidx/compose/ui/graphics/Shape;FLandroidx/compose/runtime/Composer;II)V", "TicketFluidGlowCanvas", "color", "intensity", "animate", "TicketFluidGlowCanvas-8V94_ZQ", "(Landroidx/compose/ui/Modifier;JFLcom/example/tickets/TicketFluidEdge;ZFLandroidx/compose/runtime/Composer;I)V", "drawTicketFluidField", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "baseColor", "drawTicketFluidField-iJQMabo", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;JFLcom/example/tickets/TicketFluidEdge;F)V", "TicketUsedStamp", "Landroidx/compose/foundation/layout/BoxScope;", "text", "alignment", "Landroidx/compose/ui/Alignment;", "endPadding", "Landroidx/compose/ui/unit/Dp;", "TicketUsedStamp-wC_cr3g", "(Landroidx/compose/foundation/layout/BoxScope;Ljava/lang/String;JLandroidx/compose/ui/Modifier;Landroidx/compose/ui/Alignment;FLandroidx/compose/runtime/Composer;II)V", "ticketFluidThemeColor", "(Ljava/lang/String;)J", "ticketFluidStampText", "TicketFluidGlowPreviewDemo", "(Landroidx/compose/runtime/Composer;I)V", "TicketFluidGlowPreviewDemoContent", "DemoGlowCard", "(Ljava/lang/String;Lcom/example/tickets/TicketFluidState;Lcom/example/tickets/TicketFluidEdge;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)V", "app", "alphaBreath"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class TicketFluidGlowKt {

    /* JADX INFO: compiled from: TicketFluidGlow.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[TicketFluidState.values().length];
            try {
                iArr[TicketFluidState.Normal.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[TicketFluidState.Approaching.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[TicketFluidState.InProgress.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[TicketFluidState.Ended.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[TicketFluidState.Used.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[TicketFluidEdge.values().length];
            try {
                iArr2[TicketFluidEdge.Bottom.ordinal()] = 1;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[TicketFluidEdge.Top.ordinal()] = 2;
            } catch (NoSuchFieldError unused7) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    static final Unit DemoGlowCard$lambda$31(String str, TicketFluidState ticketFluidState, TicketFluidEdge ticketFluidEdge, Modifier modifier, int i, Composer composer, int i2) {
        DemoGlowCard(str, ticketFluidState, ticketFluidEdge, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    static final Unit TicketFluidGlowCanvas_8V94_ZQ$lambda$3(Modifier modifier, long j, float f, TicketFluidEdge ticketFluidEdge, boolean z, float f2, int i, Composer composer, int i2) {
        m9315TicketFluidGlowCanvas8V94_ZQ(modifier, j, f, ticketFluidEdge, z, f2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    static final Unit TicketFluidGlowCanvas_8V94_ZQ$lambda$7(Modifier modifier, long j, float f, TicketFluidEdge ticketFluidEdge, boolean z, float f2, int i, Composer composer, int i2) {
        m9315TicketFluidGlowCanvas8V94_ZQ(modifier, j, f, ticketFluidEdge, z, f2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    static final Unit TicketFluidGlowPreviewDemo$lambda$15(int i, Composer composer, int i2) {
        TicketFluidGlowPreviewDemo(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    static final Unit TicketFluidGlowPreviewDemoContent$lambda$29(int i, Composer composer, int i2) {
        TicketFluidGlowPreviewDemoContent(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    static final Unit TicketFluidGlow_eq_XX3s$lambda$2(Modifier modifier, String str, TicketFluidState ticketFluidState, TicketFluidEdge ticketFluidEdge, Color color, String str2, boolean z, Shape shape, float f, int i, int i2, Composer composer, int i3) {
        m9314TicketFluidGloweq_XX3s(modifier, str, ticketFluidState, ticketFluidEdge, color, str2, z, shape, f, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    static final Unit TicketUsedStamp_wC_cr3g$lambda$14(BoxScope boxScope, String str, long j, Modifier modifier, Alignment alignment, float f, int i, int i2, Composer composer, int i3) {
        m9316TicketUsedStampwC_cr3g(boxScope, str, j, modifier, alignment, f, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:107:0x0158 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:108:0x015a  */
    /* JADX WARN: Code duplicated, block: B:110:0x0161  */
    /* JADX WARN: Code duplicated, block: B:111:0x0164  */
    /* JADX WARN: Code duplicated, block: B:113:0x0168  */
    /* JADX WARN: Code duplicated, block: B:115:0x016b  */
    /* JADX WARN: Code duplicated, block: B:117:0x016e  */
    /* JADX WARN: Code duplicated, block: B:120:0x0173  */
    /* JADX WARN: Code duplicated, block: B:121:0x0182  */
    /* JADX WARN: Code duplicated, block: B:124:0x0188  */
    /* JADX WARN: Code duplicated, block: B:125:0x018c  */
    /* JADX WARN: Code duplicated, block: B:128:0x0197  */
    /* JADX WARN: Code duplicated, block: B:131:0x01ae  */
    /* JADX WARN: Code duplicated, block: B:132:0x01b0  */
    /* JADX WARN: Code duplicated, block: B:135:0x01b9  */
    /* JADX WARN: Code duplicated, block: B:136:0x01bb  */
    /* JADX WARN: Code duplicated, block: B:141:0x01cb A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:142:0x01cd  */
    /* JADX WARN: Code duplicated, block: B:143:0x01d2  */
    /* JADX WARN: Code duplicated, block: B:147:0x01f0  */
    /* JADX WARN: Code duplicated, block: B:149:0x01f3  */
    /* JADX WARN: Code duplicated, block: B:151:0x01f6  */
    /* JADX WARN: Code duplicated, block: B:158:0x0203  */
    /* JADX WARN: Code duplicated, block: B:159:0x0207  */
    /* JADX WARN: Code duplicated, block: B:161:0x020c  */
    /* JADX WARN: Code duplicated, block: B:164:0x025d  */
    /* JADX WARN: Code duplicated, block: B:167:0x0269  */
    /* JADX WARN: Code duplicated, block: B:168:0x026d  */
    /* JADX WARN: Code duplicated, block: B:175:0x02d0  */
    /* JADX WARN: Code duplicated, block: B:184:0x0334  */
    /* JADX WARN: Code duplicated, block: B:187:0x0355  */
    /* JADX WARN: Code duplicated, block: B:189:0x0363  */
    /* JADX WARN: Code duplicated, block: B:192:0x0373  */
    /* JADX WARN: Code duplicated, block: B:194:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:53:0x00ab  */
    /* JADX WARN: Code duplicated, block: B:54:0x00b0  */
    /* JADX WARN: Code duplicated, block: B:56:0x00b6  */
    /* JADX WARN: Code duplicated, block: B:58:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:59:0x00bf  */
    /* JADX WARN: Code duplicated, block: B:63:0x00c9  */
    /* JADX WARN: Code duplicated, block: B:64:0x00ce  */
    /* JADX WARN: Code duplicated, block: B:66:0x00d4  */
    /* JADX WARN: Code duplicated, block: B:68:0x00da  */
    /* JADX WARN: Code duplicated, block: B:69:0x00dd  */
    /* JADX WARN: Code duplicated, block: B:73:0x00e7  */
    /* JADX WARN: Code duplicated, block: B:75:0x00eb  */
    /* JADX WARN: Code duplicated, block: B:77:0x00f3  */
    /* JADX WARN: Code duplicated, block: B:78:0x00f6  */
    /* JADX WARN: Code duplicated, block: B:81:0x00fd  */
    /* JADX WARN: Code duplicated, block: B:84:0x0105  */
    /* JADX WARN: Code duplicated, block: B:85:0x010a  */
    /* JADX WARN: Code duplicated, block: B:87:0x0110  */
    /* JADX WARN: Code duplicated, block: B:89:0x0116  */
    /* JADX WARN: Code duplicated, block: B:90:0x0119  */
    /* JADX WARN: Code duplicated, block: B:94:0x012c  */
    /* JADX WARN: Code duplicated, block: B:95:0x012e  */
    /* JADX WARN: Code duplicated, block: B:98:0x0137  */
    /* JADX INFO: renamed from: TicketFluidGlow-eq_XX3s, reason: not valid java name */
    public static final void m9314TicketFluidGloweq_XX3s(Modifier modifier, final String ticketType, final TicketFluidState state, TicketFluidEdge ticketFluidEdge, Color color, String str, boolean z, Shape shape, float f, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        final Color color2;
        int i4;
        final String str2;
        int i5;
        int i6;
        boolean z2;
        int i7;
        Shape shape2;
        int i8;
        float f2;
        int i9;
        boolean z3;
        final TicketFluidEdge ticketFluidEdge2;
        Modifier modifier3;
        final Shape shape3;
        final float f3;
        final boolean z4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        TicketFluidEdge ticketFluidEdge3;
        RoundedCornerShape roundedCornerShapeM1756RoundedCornerShape0680j_4;
        TicketFluidEdge ticketFluidEdge4;
        int i10;
        float f4;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        Object objRememberedValue;
        long jTicketFluidThemeColor;
        int i11;
        float f5;
        Function0<ComposeUiNode> constructor;
        boolean z9;
        float f6;
        Intrinsics.checkNotNullParameter(ticketType, "ticketType");
        Intrinsics.checkNotNullParameter(state, "state");
        Composer composerStartRestartGroup = composer.startRestartGroup(440005261);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(TicketFluidGlow)N(modifier,ticketType,state,edge,themeColor:c#ui.graphics.Color,stampText,showStamp,shape,coverage)76@2771L96,88@3123L762:TicketFluidGlow.kt#n9ob9m");
        int i12 = i2 & 1;
        if (i12 != 0) {
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
            i3 |= composerStartRestartGroup.changed(ticketType) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changed(state.ordinal()) ? 256 : 128;
        }
        int i13 = i2 & 8;
        if (i13 != 0) {
            i3 |= 3072;
        } else if ((i & 3072) == 0) {
            i3 |= composerStartRestartGroup.changed(ticketFluidEdge == null ? -1 : ticketFluidEdge.ordinal()) ? 2048 : 1024;
        }
        int i14 = i2 & 16;
        if (i14 == 0) {
            if ((i & 24576) == 0) {
                color2 = color;
                i3 |= composerStartRestartGroup.changed(color2) ? 16384 : 8192;
            }
            i4 = i2 & 32;
            if (i4 != 0) {
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                str2 = str;
            } else {
                str2 = str;
                if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    if (composerStartRestartGroup.changed(str2)) {
                        i5 = 131072;
                    } else {
                        i5 = 65536;
                    }
                    i3 |= i5;
                }
            }
            i6 = i2 & 64;
            if (i6 != 0) {
                i3 |= 1572864;
                z2 = z;
            } else {
                z2 = z;
                if ((i & 1572864) == 0) {
                    if (composerStartRestartGroup.changed(z2)) {
                        i7 = 1048576;
                    } else {
                        i7 = 524288;
                    }
                    i3 |= i7;
                }
            }
            if ((i & 12582912) == 0) {
                if ((i2 & 128) == 0) {
                    shape2 = shape;
                    int i15 = composerStartRestartGroup.changed(shape2) ? 8388608 : 4194304;
                    i3 |= i15;
                } else {
                    shape2 = shape;
                }
                i3 |= i15;
            } else {
                shape2 = shape;
            }
            i8 = i2 & 256;
            if (i8 != 0) {
                i3 |= 100663296;
                f2 = f;
            } else {
                f2 = f;
                if ((i & 100663296) == 0) {
                    if (composerStartRestartGroup.changed(f2)) {
                        i9 = 67108864;
                    } else {
                        i9 = GroupFlagsKt.HasAuxSlotFlag;
                    }
                    i3 |= i9;
                }
            }
            if ((i3 & 38347923) != 38347922) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                    if (i12 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i13 != 0) {
                        ticketFluidEdge3 = TicketFluidEdge.Bottom;
                    } else {
                        ticketFluidEdge3 = ticketFluidEdge;
                    }
                    if (i14 != 0) {
                        color2 = null;
                    }
                    if (i4 != 0) {
                        str2 = null;
                    }
                    if (i6 != 0) {
                        z2 = true;
                    }
                    if ((i2 & 128) != 0) {
                        roundedCornerShapeM1756RoundedCornerShape0680j_4 = RoundedCornerShapeKt.m1756RoundedCornerShape0680j_4(Dp.m8748constructorimpl(18.0f));
                        i3 &= -29360129;
                    } else {
                        roundedCornerShapeM1756RoundedCornerShape0680j_4 = shape2;
                    }
                    ticketFluidEdge4 = ticketFluidEdge3;
                    i10 = i3;
                    if (i8 != 0) {
                        z5 = z2;
                        f4 = 1.0f;
                    } else {
                        f4 = f2;
                        z5 = z2;
                    }
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    if ((i2 & 128) != 0) {
                        i3 &= -29360129;
                    }
                    ticketFluidEdge4 = ticketFluidEdge;
                    roundedCornerShapeM1756RoundedCornerShape0680j_4 = shape2;
                    z5 = z2;
                    i10 = i3;
                    f4 = f2;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(440005261, i10, -1, "com.example.tickets.TicketFluidGlow (TicketFluidGlow.kt:75)");
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1938272589, "CC(remember):TicketFluidGlow.kt#9igjgp");
                if ((i10 & StylePropertiesKt.TextDirectionMask) == 32) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                if ((57344 & i10) == 16384) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                z8 = z6 | z7;
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!z8 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    if (color2 != null) {
                        jTicketFluidThemeColor = color2.m5848unboximpl();
                    } else {
                        jTicketFluidThemeColor = ticketFluidThemeColor(ticketType);
                    }
                    objRememberedValue = Color.m5828boximpl(jTicketFluidThemeColor);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                long jM5848unboximpl = ((Color) objRememberedValue).m5848unboximpl();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                i11 = WhenMappings.$EnumSwitchMapping$0[state.ordinal()];
                if (i11 == 1) {
                    f5 = 0.0f;
                } else {
                    if (i11 != 2) {
                        f6 = 0.34f;
                    } else if (i11 != 3) {
                        if (i11 != 4 && i11 != 5) {
                            throw new NoWhenBranchMatchedException();
                        }
                        f5 = 0.0f;
                    } else {
                        f6 = 0.56f;
                    }
                    f5 = f6;
                }
                Modifier modifierClip = ClipKt.clip(modifier2, roundedCornerShapeM1756RoundedCornerShape0680j_4);
                boolean z10 = z5;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                Color color3 = color2;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
                int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierClip);
                constructor = ComposeUiNode.INSTANCE.getConstructor();
                String str3 = str2;
                modifier3 = modifier2;
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
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -71124155, "C91@3184L347:TicketFluidGlow.kt#n9ob9m");
                Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                if (state != TicketFluidState.Approaching || state == TicketFluidState.InProgress) {
                    z9 = true;
                } else {
                    z9 = false;
                }
                m9315TicketFluidGlowCanvas8V94_ZQ(modifierFillMaxSize$default, jM5848unboximpl, f5, ticketFluidEdge4, z9, RangesKt.coerceIn(f4, 0.72f, 1.0f), composerStartRestartGroup, (i10 & 7168) | 6);
                TicketFluidEdge ticketFluidEdge5 = ticketFluidEdge4;
                if (state == TicketFluidState.Used || !z10) {
                    composerStartRestartGroup.startReplaceGroup(-74305221);
                } else {
                    composerStartRestartGroup.startReplaceGroup(-70733990);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "102@3604L265");
                    m9316TicketUsedStampwC_cr3g(boxScopeInstance, str3 == null ? ticketFluidStampText(ticketType) : str3, jM5848unboximpl, PaddingKt.m1427paddingqDBjuR0$default(boxScopeInstance.align(Modifier.INSTANCE, Alignment.INSTANCE.getCenterEnd()), 0.0f, 0.0f, Dp.m8748constructorimpl(10.0f), 0.0f, 11, null), null, 0.0f, composerStartRestartGroup, 6, 24);
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
                Shape shape4 = roundedCornerShapeM1756RoundedCornerShape0680j_4;
                f3 = f4;
                shape3 = shape4;
                z4 = z10;
                color2 = color3;
                str2 = str3;
                ticketFluidEdge2 = ticketFluidEdge5;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                ticketFluidEdge2 = ticketFluidEdge;
                modifier3 = modifier2;
                shape3 = shape2;
                f3 = f2;
                z4 = z2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                final Modifier modifier4 = modifier3;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.tickets.TicketFluidGlowKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return TicketFluidGlowKt.TicketFluidGlow_eq_XX3s$lambda$2(modifier4, ticketType, state, ticketFluidEdge2, color2, str2, z4, shape3, f3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 24576;
        color2 = color;
        i4 = i2 & 32;
        if (i4 != 0) {
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            str2 = str;
        } else {
            str2 = str;
            if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                if (composerStartRestartGroup.changed(str2)) {
                    i5 = 131072;
                } else {
                    i5 = 65536;
                }
                i3 |= i5;
            }
        }
        i6 = i2 & 64;
        if (i6 != 0) {
            i3 |= 1572864;
            z2 = z;
        } else {
            z2 = z;
            if ((i & 1572864) == 0) {
                if (composerStartRestartGroup.changed(z2)) {
                    i7 = 1048576;
                } else {
                    i7 = 524288;
                }
                i3 |= i7;
            }
        }
        if ((i & 12582912) == 0) {
            if ((i2 & 128) == 0) {
                shape2 = shape;
                if (composerStartRestartGroup.changed(shape2)) {
                }
                i3 |= i15;
            } else {
                shape2 = shape;
            }
            i3 |= i15;
        } else {
            shape2 = shape;
        }
        i8 = i2 & 256;
        if (i8 != 0) {
            i3 |= 100663296;
            f2 = f;
        } else {
            f2 = f;
            if ((i & 100663296) == 0) {
                if (composerStartRestartGroup.changed(f2)) {
                    i9 = 67108864;
                } else {
                    i9 = GroupFlagsKt.HasAuxSlotFlag;
                }
                i3 |= i9;
            }
        }
        if ((i3 & 38347923) != 38347922) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i12 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (i13 != 0) {
                    ticketFluidEdge3 = TicketFluidEdge.Bottom;
                } else {
                    ticketFluidEdge3 = ticketFluidEdge;
                }
                if (i14 != 0) {
                    color2 = null;
                }
                if (i4 != 0) {
                    str2 = null;
                }
                if (i6 != 0) {
                    z2 = true;
                }
                if ((i2 & 128) != 0) {
                    roundedCornerShapeM1756RoundedCornerShape0680j_4 = RoundedCornerShapeKt.m1756RoundedCornerShape0680j_4(Dp.m8748constructorimpl(18.0f));
                    i3 &= -29360129;
                } else {
                    roundedCornerShapeM1756RoundedCornerShape0680j_4 = shape2;
                }
                ticketFluidEdge4 = ticketFluidEdge3;
                i10 = i3;
                if (i8 != 0) {
                    z5 = z2;
                    f4 = 1.0f;
                } else {
                    f4 = f2;
                    z5 = z2;
                }
            } else {
                if (i12 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (i13 != 0) {
                    ticketFluidEdge3 = TicketFluidEdge.Bottom;
                } else {
                    ticketFluidEdge3 = ticketFluidEdge;
                }
                if (i14 != 0) {
                    color2 = null;
                }
                if (i4 != 0) {
                    str2 = null;
                }
                if (i6 != 0) {
                    z2 = true;
                }
                if ((i2 & 128) != 0) {
                    roundedCornerShapeM1756RoundedCornerShape0680j_4 = RoundedCornerShapeKt.m1756RoundedCornerShape0680j_4(Dp.m8748constructorimpl(18.0f));
                    i3 &= -29360129;
                } else {
                    roundedCornerShapeM1756RoundedCornerShape0680j_4 = shape2;
                }
                ticketFluidEdge4 = ticketFluidEdge3;
                i10 = i3;
                if (i8 != 0) {
                    z5 = z2;
                    f4 = 1.0f;
                } else {
                    f4 = f2;
                    z5 = z2;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(440005261, i10, -1, "com.example.tickets.TicketFluidGlow (TicketFluidGlow.kt:75)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1938272589, "CC(remember):TicketFluidGlow.kt#9igjgp");
            if ((i10 & StylePropertiesKt.TextDirectionMask) == 32) {
                z6 = true;
            } else {
                z6 = false;
            }
            if ((57344 & i10) == 16384) {
                z7 = true;
            } else {
                z7 = false;
            }
            z8 = z6 | z7;
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (!z8) {
                if (color2 != null) {
                    jTicketFluidThemeColor = color2.m5848unboximpl();
                } else {
                    jTicketFluidThemeColor = ticketFluidThemeColor(ticketType);
                }
                objRememberedValue = Color.m5828boximpl(jTicketFluidThemeColor);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            } else {
                if (color2 != null) {
                    jTicketFluidThemeColor = color2.m5848unboximpl();
                } else {
                    jTicketFluidThemeColor = ticketFluidThemeColor(ticketType);
                }
                objRememberedValue = Color.m5828boximpl(jTicketFluidThemeColor);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            long jM5848unboximpl2 = ((Color) objRememberedValue).m5848unboximpl();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            i11 = WhenMappings.$EnumSwitchMapping$0[state.ordinal()];
            if (i11 == 1) {
                f5 = 0.0f;
            } else {
                if (i11 != 2) {
                    f6 = 0.34f;
                } else if (i11 != 3) {
                    if (i11 != 4) {
                        throw new NoWhenBranchMatchedException();
                    }
                    f5 = 0.0f;
                } else {
                    f6 = 0.56f;
                }
                f5 = f6;
            }
            Modifier modifierClip2 = ClipKt.clip(modifier2, roundedCornerShapeM1756RoundedCornerShape0680j_4);
            boolean z11 = z5;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            Color color4 = color2;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
            int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierClip2);
            constructor = ComposeUiNode.INSTANCE.getConstructor();
            String str4 = str2;
            modifier3 = modifier2;
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -71124155, "C91@3184L347:TicketFluidGlow.kt#n9ob9m");
            Modifier modifierFillMaxSize$default2 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
            if (state != TicketFluidState.Approaching) {
                z9 = true;
            } else {
                z9 = true;
            }
            m9315TicketFluidGlowCanvas8V94_ZQ(modifierFillMaxSize$default2, jM5848unboximpl2, f5, ticketFluidEdge4, z9, RangesKt.coerceIn(f4, 0.72f, 1.0f), composerStartRestartGroup, (i10 & 7168) | 6);
            TicketFluidEdge ticketFluidEdge6 = ticketFluidEdge4;
            if (state == TicketFluidState.Used) {
                composerStartRestartGroup.startReplaceGroup(-74305221);
            } else {
                composerStartRestartGroup.startReplaceGroup(-74305221);
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
            Shape shape5 = roundedCornerShapeM1756RoundedCornerShape0680j_4;
            f3 = f4;
            shape3 = shape5;
            z4 = z11;
            color2 = color4;
            str2 = str4;
            ticketFluidEdge2 = ticketFluidEdge6;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            ticketFluidEdge2 = ticketFluidEdge;
            modifier3 = modifier2;
            shape3 = shape2;
            f3 = f2;
            z4 = z2;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.tickets.TicketFluidGlowKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TicketFluidGlowKt.TicketFluidGlow_eq_XX3s$lambda$2(modifier5, ticketType, state, ticketFluidEdge2, color2, str2, z4, shape3, f3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: renamed from: TicketFluidGlowCanvas-8V94_ZQ, reason: not valid java name */
    private static final void m9315TicketFluidGlowCanvas8V94_ZQ(final Modifier modifier, final long j, final float f, final TicketFluidEdge ticketFluidEdge, final boolean z, final float f2, Composer composer, final int i) {
        int i2;
        boolean z2;
        final float f3;
        Modifier modifier2;
        Composer composer2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Function2<? super Composer, ? super Integer, Unit> function2;
        Composer composerStartRestartGroup = composer.startRestartGroup(1983639541);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(TicketFluidGlowCanvas)N(modifier,color:c#ui.graphics.Color,intensity,edge,animate,coverage)124@4127L55,128@4277L342,141@4653L226,141@4625L254:TicketFluidGlow.kt#n9ob9m");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(j) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changed(f) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= composerStartRestartGroup.changed(ticketFluidEdge.ordinal()) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            z2 = z;
            i2 |= composerStartRestartGroup.changed(z2) ? 16384 : 8192;
        } else {
            z2 = z;
        }
        if ((196608 & i) == 0) {
            f3 = f2;
            i2 |= composerStartRestartGroup.changed(f3) ? 131072 : 65536;
        } else {
            f3 = f2;
        }
        if (composerStartRestartGroup.shouldExecute((i2 & 74899) != 74898, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1983639541, i2, -1, "com.example.tickets.TicketFluidGlowCanvas (TicketFluidGlow.kt:121)");
            }
            if (f <= 0.0f) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                final boolean z3 = z2;
                function2 = new Function2() { // from class: com.example.tickets.TicketFluidGlowKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return TicketFluidGlowKt.TicketFluidGlowCanvas_8V94_ZQ$lambda$3(modifier, j, f, ticketFluidEdge, z3, f3, i, (Composer) obj, ((Integer) obj2).intValue());
                    }
                };
            } else {
                modifier2 = modifier;
                int i3 = i2;
                final State<Float> stateAnimateFloat = InfiniteTransitionKt.animateFloat(InfiniteTransitionKt.rememberInfiniteTransition("ticket_fluid_glow", composerStartRestartGroup, 6, 0), 0.0f, 1.0f, AnimationSpecKt.m555infiniteRepeatable9IiC70o$default(AnimationSpecKt.tween$default(6600, 0, EasingKt.getFastOutSlowInEasing(), 2, null), RepeatMode.Reverse, 0L, 4, null), "fluid_alpha_breath", composerStartRestartGroup, InfiniteTransition.$stable | 25008 | (InfiniteRepeatableSpec.$stable << 9), 0);
                composer2 = composerStartRestartGroup;
                ComposerKt.sourceInformationMarkerStart(composer2, -687855849, "CC(remember):TicketFluidGlow.kt#9igjgp");
                boolean zChanged = ((i3 & StylePropertiesKt.TextDirectionMask) == 32) | ((i3 & 896) == 256) | ((57344 & i3) == 16384) | composer2.changed(stateAnimateFloat) | ((i3 & 7168) == 2048) | ((458752 & i3) == 131072);
                Object objRememberedValue = composer2.rememberedValue();
                if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    Function1 function1 = new Function1() { // from class: com.example.tickets.TicketFluidGlowKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return TicketFluidGlowKt.TicketFluidGlowCanvas_8V94_ZQ$lambda$6$lambda$5(j, f, z, ticketFluidEdge, f2, stateAnimateFloat, (DrawScope) obj);
                        }
                    };
                    composer2.updateRememberedValue(function1);
                    objRememberedValue = function1;
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                CanvasKt.Canvas(modifier2, (Function1) objRememberedValue, composer2, i3 & 14);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            scopeUpdateScopeEndRestartGroup.updateScope(function2);
        }
        modifier2 = modifier;
        composer2 = composerStartRestartGroup;
        composer2.skipToGroupEnd();
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier3 = modifier2;
            function2 = new Function2() { // from class: com.example.tickets.TicketFluidGlowKt$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TicketFluidGlowKt.TicketFluidGlowCanvas_8V94_ZQ$lambda$7(modifier3, j, f, ticketFluidEdge, z, f2, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            };
            scopeUpdateScopeEndRestartGroup.updateScope(function2);
        }
    }

    static final Unit TicketFluidGlowCanvas_8V94_ZQ$lambda$6$lambda$5(long j, float f, boolean z, TicketFluidEdge ticketFluidEdge, float f2, State state, DrawScope Canvas) {
        Intrinsics.checkNotNullParameter(Canvas, "$this$Canvas");
        m9317drawTicketFluidFieldiJQMabo(Canvas, j, f * (z ? (TicketFluidGlowCanvas_8V94_ZQ$lambda$4(state) * 0.7f) + 0.3f : 0.86f), ticketFluidEdge, f2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: drawTicketFluidField-iJQMabo, reason: not valid java name */
    private static final void m9317drawTicketFluidFieldiJQMabo(DrawScope drawScope, long j, float f, TicketFluidEdge ticketFluidEdge, float f2) {
        float f3;
        float f4;
        float f5;
        float fIntBitsToFloat = Float.intBitsToFloat((int) (drawScope.mo6437getSizeNHjbRc() >> 32));
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (drawScope.mo6437getSizeNHjbRc() & 4294967295L));
        float fMax = Math.max(fIntBitsToFloat, fIntBitsToFloat2);
        int i = WhenMappings.$EnumSwitchMapping$1[ticketFluidEdge.ordinal()];
        if (i == 1) {
            f3 = 0.115f;
        } else {
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            f3 = 0.095f;
        }
        float f6 = f3 * f;
        float fCoerceIn = RangesKt.coerceIn(f2, 0.68f, 1.0f);
        int i2 = WhenMappings.$EnumSwitchMapping$1[ticketFluidEdge.ordinal()];
        if (i2 == 1) {
            f4 = (1.0f - fCoerceIn) * 0.2f;
            f5 = 1.18f;
        } else {
            if (i2 != 2) {
                throw new NoWhenBranchMatchedException();
            }
            fIntBitsToFloat2 = -fIntBitsToFloat2;
            f4 = (1.0f - fCoerceIn) * 0.12f;
            f5 = 0.18f;
        }
        Brush.Companion companion = Brush.INSTANCE;
        List listListOf = CollectionsKt.listOf((Object[]) new Color[]{Color.m5828boximpl(Color.m5837copywmQWz5c$default(j, f6, 0.0f, 0.0f, 0.0f, 14, null)), Color.m5828boximpl(Color.m5837copywmQWz5c$default(j, 0.78f * f6, 0.0f, 0.0f, 0.0f, 14, null)), Color.m5828boximpl(Color.m5837copywmQWz5c$default(j, f6 * 0.42f, 0.0f, 0.0f, 0.0f, 14, null)), Color.m5828boximpl(Color.m5837copywmQWz5c$default(j, f6 * 0.14f, 0.0f, 0.0f, 0.0f, 14, null)), Color.m5828boximpl(Color.INSTANCE.m5873getTransparent0d7_KjU())});
        DrawScope.m6430drawRectAsUm42w$default(drawScope, Brush.Companion.m5765radialGradientP_VxKs$default(companion, listListOf, Offset.m5559constructorimpl((((long) Float.floatToRawIntBits(fIntBitsToFloat2 * (f4 + f5))) & 4294967295L) | (((long) Float.floatToRawIntBits(fIntBitsToFloat * 0.5f)) << 32)), fMax * (((1.0f - fCoerceIn) * 0.8f) + 2.65f), 0, 8, (Object) null), 0L, 0L, 0.0f, null, null, 0, 126, null);
    }

    /* JADX WARN: Code duplicated, block: B:101:0x026c  */
    /* JADX WARN: Code duplicated, block: B:104:0x02e9  */
    /* JADX WARN: Code duplicated, block: B:106:0x02f2  */
    /* JADX WARN: Code duplicated, block: B:109:0x0300  */
    /* JADX WARN: Code duplicated, block: B:111:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:37:0x0070  */
    /* JADX WARN: Code duplicated, block: B:38:0x0073  */
    /* JADX WARN: Code duplicated, block: B:40:0x0077  */
    /* JADX WARN: Code duplicated, block: B:42:0x007f  */
    /* JADX WARN: Code duplicated, block: B:43:0x0082  */
    /* JADX WARN: Code duplicated, block: B:48:0x008e  */
    /* JADX WARN: Code duplicated, block: B:49:0x0090  */
    /* JADX WARN: Code duplicated, block: B:51:0x0093  */
    /* JADX WARN: Code duplicated, block: B:53:0x009b  */
    /* JADX WARN: Code duplicated, block: B:54:0x009e  */
    /* JADX WARN: Code duplicated, block: B:59:0x00af  */
    /* JADX WARN: Code duplicated, block: B:60:0x00b1  */
    /* JADX WARN: Code duplicated, block: B:63:0x00ba A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:64:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:65:0x00c1  */
    /* JADX WARN: Code duplicated, block: B:67:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:68:0x00cc  */
    /* JADX WARN: Code duplicated, block: B:70:0x00cf  */
    /* JADX WARN: Code duplicated, block: B:71:0x00d8  */
    /* JADX WARN: Code duplicated, block: B:74:0x00e0  */
    /* JADX WARN: Code duplicated, block: B:77:0x00ff  */
    /* JADX WARN: Code duplicated, block: B:80:0x0121  */
    /* JADX WARN: Code duplicated, block: B:83:0x0146  */
    /* JADX WARN: Code duplicated, block: B:85:0x014e  */
    /* JADX WARN: Code duplicated, block: B:88:0x01e8  */
    /* JADX WARN: Code duplicated, block: B:91:0x01f4  */
    /* JADX WARN: Code duplicated, block: B:92:0x01f8  */
    /* JADX WARN: Code duplicated, block: B:95:0x025b  */
    /* JADX WARN: Code duplicated, block: B:96:0x025d  */
    /* JADX WARN: Code duplicated, block: B:99:0x0264  */
    /* JADX INFO: renamed from: TicketUsedStamp-wC_cr3g, reason: not valid java name */
    public static final void m9316TicketUsedStampwC_cr3g(final BoxScope TicketUsedStamp, final String text, final long j, Modifier modifier, Alignment alignment, float f, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        Alignment alignment2;
        int i5;
        int i6;
        float f2;
        int i7;
        boolean z;
        Composer composer2;
        final Modifier modifier3;
        final Alignment alignment3;
        final float f3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier.Companion companion;
        Alignment centerEnd;
        float fM8748constructorimpl;
        Object objRememberedValue;
        Animatable animatable;
        Object objRememberedValue2;
        Animatable animatable2;
        boolean zChangedInstance;
        TicketFluidGlowKt$TicketUsedStamp$1$1 ticketFluidGlowKt$TicketUsedStamp$1$1RememberedValue;
        Function0<ComposeUiNode> constructor;
        boolean z2;
        Object objRememberedValue3;
        Intrinsics.checkNotNullParameter(TicketUsedStamp, "$this$TicketUsedStamp");
        Intrinsics.checkNotNullParameter(text, "text");
        Composer composerStartRestartGroup = composer.startRestartGroup(-149765162);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(TicketUsedStamp)N(text,color:c#ui.graphics.Color,modifier,alignment,endPadding:c#ui.unit.Dp)206@6438L30,207@6490L27,209@6544L401,209@6523L422,227@6951L1408:TicketFluidGlow.kt#n9ob9m");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(TicketUsedStamp) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changed(text) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changed(j) ? 256 : 128;
        }
        int i8 = i2 & 4;
        if (i8 == 0) {
            if ((i & 3072) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 2048 : 1024;
            }
            i4 = i2 & 8;
            if (i4 != 0) {
                if ((i & 24576) == 0) {
                    alignment2 = alignment;
                    if (composerStartRestartGroup.changed(alignment2)) {
                        i5 = 16384;
                    } else {
                        i5 = 8192;
                    }
                    i3 |= i5;
                }
                i6 = i2 & 16;
                if (i6 != 0) {
                    if ((196608 & i) == 0) {
                        f2 = f;
                        if (composerStartRestartGroup.changed(f2)) {
                            i7 = 131072;
                        } else {
                            i7 = 65536;
                        }
                        i3 |= i7;
                    }
                    if ((i3 & 74899) != 74898) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        modifier3 = modifier2;
                        alignment3 = alignment2;
                        f3 = f2;
                    } else {
                        if (i8 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i4 != 0) {
                            centerEnd = Alignment.INSTANCE.getCenterEnd();
                        } else {
                            centerEnd = alignment2;
                        }
                        if (i6 != 0) {
                            fM8748constructorimpl = Dp.m8748constructorimpl(14.0f);
                        } else {
                            fM8748constructorimpl = f2;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-149765162, i3, -1, "com.example.tickets.TicketUsedStamp (TicketFluidGlow.kt:205)");
                        }
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2104575028, "CC(remember):TicketFluidGlow.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = AnimatableKt.Animatable$default(0.72f, 0.0f, 2, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        animatable = (Animatable) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2104576689, "CC(remember):TicketFluidGlow.kt#9igjgp");
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue2 = AnimatableKt.Animatable$default(0.0f, 0.0f, 2, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        animatable2 = (Animatable) objRememberedValue2;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        Unit unit = Unit.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2104578791, "CC(remember):TicketFluidGlow.kt#9igjgp");
                        zChangedInstance = composerStartRestartGroup.changedInstance(animatable2) | composerStartRestartGroup.changedInstance(animatable);
                        ticketFluidGlowKt$TicketUsedStamp$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!zChangedInstance || ticketFluidGlowKt$TicketUsedStamp$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                            ticketFluidGlowKt$TicketUsedStamp$1$1RememberedValue = new TicketFluidGlowKt$TicketUsedStamp$1$1(animatable2, animatable, null);
                            composerStartRestartGroup.updateRememberedValue(ticketFluidGlowKt$TicketUsedStamp$1$1RememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        EffectsKt.LaunchedEffect(unit, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) ticketFluidGlowKt$TicketUsedStamp$1$1RememberedValue, composerStartRestartGroup, 6);
                        float f4 = fM8748constructorimpl;
                        Modifier modifierM1492sizeVpY3zN4 = SizeKt.m1492sizeVpY3zN4(RotateKt.rotate(AlphaKt.alpha(ScaleKt.scale(PaddingKt.m1427paddingqDBjuR0$default(TicketUsedStamp.align(companion, centerEnd), 0.0f, 0.0f, fM8748constructorimpl, 0.0f, 11, null), ((Number) animatable.getValue()).floatValue()), ((Number) animatable2.getValue()).floatValue()), -7.0f), Dp.m8748constructorimpl(122.0f), Dp.m8748constructorimpl(60.0f));
                        Alignment center = Alignment.INSTANCE.getCenter();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
                        int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                        CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1492sizeVpY3zN4);
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
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 835633088, "C239@7310L832,237@7246L896,264@8152L201:TicketFluidGlow.kt#n9ob9m");
                        Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1135336336, "CC(remember):TicketFluidGlow.kt#9igjgp");
                        if ((i3 & 896) == 256) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (!z2 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue3 = new Function1() { // from class: com.example.tickets.TicketFluidGlowKt$$ExternalSyntheticLambda8
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return TicketFluidGlowKt.TicketUsedStamp_wC_cr3g$lambda$13$lambda$12$lambda$11(j, (DrawScope) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        CanvasKt.Canvas(modifierFillMaxSize$default, (Function1) objRememberedValue3, composerStartRestartGroup, 6);
                        Modifier modifier4 = companion;
                        Alignment alignment4 = centerEnd;
                        composer2 = composerStartRestartGroup;
                        TextKt.m3661TextNvy7gAk(text, null, Color.m5837copywmQWz5c$default(j, 0.92f, 0.0f, 0.0f, 0.0f, 14, null), null, TextUnitKt.getSp(16.5d), null, FontWeight.INSTANCE.getExtraBold(), null, TextUnitKt.getSp(1.8d), null, null, 0L, 0, false, 0, 0, null, null, composer2, ((i3 >> 3) & 14) | 102260736, 0, 261802);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        composer2.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        alignment3 = alignment4;
                        f3 = f4;
                        modifier3 = modifier4;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.tickets.TicketFluidGlowKt$$ExternalSyntheticLambda9
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return TicketFluidGlowKt.TicketUsedStamp_wC_cr3g$lambda$14(TicketUsedStamp, text, j, modifier3, alignment3, f3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                f2 = f;
                if ((i3 & 74899) != 74898) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    modifier3 = modifier2;
                    alignment3 = alignment2;
                    f3 = f2;
                } else {
                    if (i8 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i4 != 0) {
                        centerEnd = Alignment.INSTANCE.getCenterEnd();
                    } else {
                        centerEnd = alignment2;
                    }
                    if (i6 != 0) {
                        fM8748constructorimpl = Dp.m8748constructorimpl(14.0f);
                    } else {
                        fM8748constructorimpl = f2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-149765162, i3, -1, "com.example.tickets.TicketUsedStamp (TicketFluidGlow.kt:205)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2104575028, "CC(remember):TicketFluidGlow.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = AnimatableKt.Animatable$default(0.72f, 0.0f, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    animatable = (Animatable) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2104576689, "CC(remember):TicketFluidGlow.kt#9igjgp");
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = AnimatableKt.Animatable$default(0.0f, 0.0f, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    animatable2 = (Animatable) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Unit unit2 = Unit.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2104578791, "CC(remember):TicketFluidGlow.kt#9igjgp");
                    zChangedInstance = composerStartRestartGroup.changedInstance(animatable2) | composerStartRestartGroup.changedInstance(animatable);
                    ticketFluidGlowKt$TicketUsedStamp$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!zChangedInstance) {
                        ticketFluidGlowKt$TicketUsedStamp$1$1RememberedValue = new TicketFluidGlowKt$TicketUsedStamp$1$1(animatable2, animatable, null);
                        composerStartRestartGroup.updateRememberedValue(ticketFluidGlowKt$TicketUsedStamp$1$1RememberedValue);
                    } else {
                        ticketFluidGlowKt$TicketUsedStamp$1$1RememberedValue = new TicketFluidGlowKt$TicketUsedStamp$1$1(animatable2, animatable, null);
                        composerStartRestartGroup.updateRememberedValue(ticketFluidGlowKt$TicketUsedStamp$1$1RememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    EffectsKt.LaunchedEffect(unit2, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) ticketFluidGlowKt$TicketUsedStamp$1$1RememberedValue, composerStartRestartGroup, 6);
                    float f5 = fM8748constructorimpl;
                    Modifier modifierM1492sizeVpY3zN5 = SizeKt.m1492sizeVpY3zN4(RotateKt.rotate(AlphaKt.alpha(ScaleKt.scale(PaddingKt.m1427paddingqDBjuR0$default(TicketUsedStamp.align(companion, centerEnd), 0.0f, 0.0f, fM8748constructorimpl, 0.0f, 11, null), ((Number) animatable.getValue()).floatValue()), ((Number) animatable2.getValue()).floatValue()), -7.0f), Dp.m8748constructorimpl(122.0f), Dp.m8748constructorimpl(60.0f));
                    Alignment center2 = Alignment.INSTANCE.getCenter();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(center2, false);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
                    int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1492sizeVpY3zN5);
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
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 835633088, "C239@7310L832,237@7246L896,264@8152L201:TicketFluidGlow.kt#n9ob9m");
                    Modifier modifierFillMaxSize$default2 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1135336336, "CC(remember):TicketFluidGlow.kt#9igjgp");
                    if ((i3 & 896) == 256) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (!z2) {
                        objRememberedValue3 = new Function1() { // from class: com.example.tickets.TicketFluidGlowKt$$ExternalSyntheticLambda8
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return TicketFluidGlowKt.TicketUsedStamp_wC_cr3g$lambda$13$lambda$12$lambda$11(j, (DrawScope) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = new Function1() { // from class: com.example.tickets.TicketFluidGlowKt$$ExternalSyntheticLambda8
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return TicketFluidGlowKt.TicketUsedStamp_wC_cr3g$lambda$13$lambda$12$lambda$11(j, (DrawScope) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    CanvasKt.Canvas(modifierFillMaxSize$default2, (Function1) objRememberedValue3, composerStartRestartGroup, 6);
                    Modifier modifier5 = companion;
                    Alignment alignment5 = centerEnd;
                    composer2 = composerStartRestartGroup;
                    TextKt.m3661TextNvy7gAk(text, null, Color.m5837copywmQWz5c$default(j, 0.92f, 0.0f, 0.0f, 0.0f, 14, null), null, TextUnitKt.getSp(16.5d), null, FontWeight.INSTANCE.getExtraBold(), null, TextUnitKt.getSp(1.8d), null, null, 0L, 0, false, 0, 0, null, null, composer2, ((i3 >> 3) & 14) | 102260736, 0, 261802);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    composer2.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    alignment3 = alignment5;
                    f3 = f5;
                    modifier3 = modifier5;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.tickets.TicketFluidGlowKt$$ExternalSyntheticLambda9
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return TicketFluidGlowKt.TicketUsedStamp_wC_cr3g$lambda$14(TicketUsedStamp, text, j, modifier3, alignment3, f3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 24576;
            alignment2 = alignment;
            i6 = i2 & 16;
            if (i6 != 0) {
                if ((196608 & i) == 0) {
                    f2 = f;
                    if (composerStartRestartGroup.changed(f2)) {
                        i7 = 131072;
                    } else {
                        i7 = 65536;
                    }
                    i3 |= i7;
                }
                if ((i3 & 74899) != 74898) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    modifier3 = modifier2;
                    alignment3 = alignment2;
                    f3 = f2;
                } else {
                    if (i8 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i4 != 0) {
                        centerEnd = Alignment.INSTANCE.getCenterEnd();
                    } else {
                        centerEnd = alignment2;
                    }
                    if (i6 != 0) {
                        fM8748constructorimpl = Dp.m8748constructorimpl(14.0f);
                    } else {
                        fM8748constructorimpl = f2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-149765162, i3, -1, "com.example.tickets.TicketUsedStamp (TicketFluidGlow.kt:205)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2104575028, "CC(remember):TicketFluidGlow.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = AnimatableKt.Animatable$default(0.72f, 0.0f, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    animatable = (Animatable) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2104576689, "CC(remember):TicketFluidGlow.kt#9igjgp");
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = AnimatableKt.Animatable$default(0.0f, 0.0f, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    animatable2 = (Animatable) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Unit unit3 = Unit.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2104578791, "CC(remember):TicketFluidGlow.kt#9igjgp");
                    zChangedInstance = composerStartRestartGroup.changedInstance(animatable2) | composerStartRestartGroup.changedInstance(animatable);
                    ticketFluidGlowKt$TicketUsedStamp$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!zChangedInstance) {
                        ticketFluidGlowKt$TicketUsedStamp$1$1RememberedValue = new TicketFluidGlowKt$TicketUsedStamp$1$1(animatable2, animatable, null);
                        composerStartRestartGroup.updateRememberedValue(ticketFluidGlowKt$TicketUsedStamp$1$1RememberedValue);
                    } else {
                        ticketFluidGlowKt$TicketUsedStamp$1$1RememberedValue = new TicketFluidGlowKt$TicketUsedStamp$1$1(animatable2, animatable, null);
                        composerStartRestartGroup.updateRememberedValue(ticketFluidGlowKt$TicketUsedStamp$1$1RememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    EffectsKt.LaunchedEffect(unit3, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) ticketFluidGlowKt$TicketUsedStamp$1$1RememberedValue, composerStartRestartGroup, 6);
                    float f6 = fM8748constructorimpl;
                    Modifier modifierM1492sizeVpY3zN6 = SizeKt.m1492sizeVpY3zN4(RotateKt.rotate(AlphaKt.alpha(ScaleKt.scale(PaddingKt.m1427paddingqDBjuR0$default(TicketUsedStamp.align(companion, centerEnd), 0.0f, 0.0f, fM8748constructorimpl, 0.0f, 11, null), ((Number) animatable.getValue()).floatValue()), ((Number) animatable2.getValue()).floatValue()), -7.0f), Dp.m8748constructorimpl(122.0f), Dp.m8748constructorimpl(60.0f));
                    Alignment center3 = Alignment.INSTANCE.getCenter();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(center3, false);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
                    int iHashCode3 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1492sizeVpY3zN6);
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
                    Updater.m4945setimpl(composerM4937constructorimpl3, measurePolicyMaybeCachedBoxMeasurePolicy3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m4945setimpl(composerM4937constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Updater.m4945setimpl(composerM4937constructorimpl3, Integer.valueOf(iHashCode3), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                    Updater.m4943reconcileimpl(composerM4937constructorimpl3, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                    Updater.m4945setimpl(composerM4937constructorimpl3, modifierMaterializeModifier3, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance3 = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 835633088, "C239@7310L832,237@7246L896,264@8152L201:TicketFluidGlow.kt#n9ob9m");
                    Modifier modifierFillMaxSize$default3 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1135336336, "CC(remember):TicketFluidGlow.kt#9igjgp");
                    if ((i3 & 896) == 256) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (!z2) {
                        objRememberedValue3 = new Function1() { // from class: com.example.tickets.TicketFluidGlowKt$$ExternalSyntheticLambda8
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return TicketFluidGlowKt.TicketUsedStamp_wC_cr3g$lambda$13$lambda$12$lambda$11(j, (DrawScope) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = new Function1() { // from class: com.example.tickets.TicketFluidGlowKt$$ExternalSyntheticLambda8
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return TicketFluidGlowKt.TicketUsedStamp_wC_cr3g$lambda$13$lambda$12$lambda$11(j, (DrawScope) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    CanvasKt.Canvas(modifierFillMaxSize$default3, (Function1) objRememberedValue3, composerStartRestartGroup, 6);
                    Modifier modifier6 = companion;
                    Alignment alignment6 = centerEnd;
                    composer2 = composerStartRestartGroup;
                    TextKt.m3661TextNvy7gAk(text, null, Color.m5837copywmQWz5c$default(j, 0.92f, 0.0f, 0.0f, 0.0f, 14, null), null, TextUnitKt.getSp(16.5d), null, FontWeight.INSTANCE.getExtraBold(), null, TextUnitKt.getSp(1.8d), null, null, 0L, 0, false, 0, 0, null, null, composer2, ((i3 >> 3) & 14) | 102260736, 0, 261802);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    composer2.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    alignment3 = alignment6;
                    f3 = f6;
                    modifier3 = modifier6;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.tickets.TicketFluidGlowKt$$ExternalSyntheticLambda9
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return TicketFluidGlowKt.TicketUsedStamp_wC_cr3g$lambda$14(TicketUsedStamp, text, j, modifier3, alignment3, f3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            f2 = f;
            if ((i3 & 74899) != 74898) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                modifier3 = modifier2;
                alignment3 = alignment2;
                f3 = f2;
            } else {
                if (i8 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i4 != 0) {
                    centerEnd = Alignment.INSTANCE.getCenterEnd();
                } else {
                    centerEnd = alignment2;
                }
                if (i6 != 0) {
                    fM8748constructorimpl = Dp.m8748constructorimpl(14.0f);
                } else {
                    fM8748constructorimpl = f2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-149765162, i3, -1, "com.example.tickets.TicketUsedStamp (TicketFluidGlow.kt:205)");
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2104575028, "CC(remember):TicketFluidGlow.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = AnimatableKt.Animatable$default(0.72f, 0.0f, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                animatable = (Animatable) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2104576689, "CC(remember):TicketFluidGlow.kt#9igjgp");
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = AnimatableKt.Animatable$default(0.0f, 0.0f, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                animatable2 = (Animatable) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Unit unit4 = Unit.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2104578791, "CC(remember):TicketFluidGlow.kt#9igjgp");
                zChangedInstance = composerStartRestartGroup.changedInstance(animatable2) | composerStartRestartGroup.changedInstance(animatable);
                ticketFluidGlowKt$TicketUsedStamp$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (!zChangedInstance) {
                    ticketFluidGlowKt$TicketUsedStamp$1$1RememberedValue = new TicketFluidGlowKt$TicketUsedStamp$1$1(animatable2, animatable, null);
                    composerStartRestartGroup.updateRememberedValue(ticketFluidGlowKt$TicketUsedStamp$1$1RememberedValue);
                } else {
                    ticketFluidGlowKt$TicketUsedStamp$1$1RememberedValue = new TicketFluidGlowKt$TicketUsedStamp$1$1(animatable2, animatable, null);
                    composerStartRestartGroup.updateRememberedValue(ticketFluidGlowKt$TicketUsedStamp$1$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                EffectsKt.LaunchedEffect(unit4, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) ticketFluidGlowKt$TicketUsedStamp$1$1RememberedValue, composerStartRestartGroup, 6);
                float f7 = fM8748constructorimpl;
                Modifier modifierM1492sizeVpY3zN7 = SizeKt.m1492sizeVpY3zN4(RotateKt.rotate(AlphaKt.alpha(ScaleKt.scale(PaddingKt.m1427paddingqDBjuR0$default(TicketUsedStamp.align(companion, centerEnd), 0.0f, 0.0f, fM8748constructorimpl, 0.0f, 11, null), ((Number) animatable.getValue()).floatValue()), ((Number) animatable2.getValue()).floatValue()), -7.0f), Dp.m8748constructorimpl(122.0f), Dp.m8748constructorimpl(60.0f));
                Alignment center4 = Alignment.INSTANCE.getCenter();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy4 = BoxKt.maybeCachedBoxMeasurePolicy(center4, false);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
                int iHashCode4 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap4 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1492sizeVpY3zN7);
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
                Updater.m4945setimpl(composerM4937constructorimpl4, measurePolicyMaybeCachedBoxMeasurePolicy4, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m4945setimpl(composerM4937constructorimpl4, currentCompositionLocalMap4, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Updater.m4945setimpl(composerM4937constructorimpl4, Integer.valueOf(iHashCode4), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                Updater.m4943reconcileimpl(composerM4937constructorimpl4, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                Updater.m4945setimpl(composerM4937constructorimpl4, modifierMaterializeModifier4, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance4 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 835633088, "C239@7310L832,237@7246L896,264@8152L201:TicketFluidGlow.kt#n9ob9m");
                Modifier modifierFillMaxSize$default4 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1135336336, "CC(remember):TicketFluidGlow.kt#9igjgp");
                if ((i3 & 896) == 256) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (!z2) {
                    objRememberedValue3 = new Function1() { // from class: com.example.tickets.TicketFluidGlowKt$$ExternalSyntheticLambda8
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return TicketFluidGlowKt.TicketUsedStamp_wC_cr3g$lambda$13$lambda$12$lambda$11(j, (DrawScope) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = new Function1() { // from class: com.example.tickets.TicketFluidGlowKt$$ExternalSyntheticLambda8
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return TicketFluidGlowKt.TicketUsedStamp_wC_cr3g$lambda$13$lambda$12$lambda$11(j, (DrawScope) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                CanvasKt.Canvas(modifierFillMaxSize$default4, (Function1) objRememberedValue3, composerStartRestartGroup, 6);
                Modifier modifier7 = companion;
                Alignment alignment7 = centerEnd;
                composer2 = composerStartRestartGroup;
                TextKt.m3661TextNvy7gAk(text, null, Color.m5837copywmQWz5c$default(j, 0.92f, 0.0f, 0.0f, 0.0f, 14, null), null, TextUnitKt.getSp(16.5d), null, FontWeight.INSTANCE.getExtraBold(), null, TextUnitKt.getSp(1.8d), null, null, 0L, 0, false, 0, 0, null, null, composer2, ((i3 >> 3) & 14) | 102260736, 0, 261802);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                alignment3 = alignment7;
                f3 = f7;
                modifier3 = modifier7;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.tickets.TicketFluidGlowKt$$ExternalSyntheticLambda9
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return TicketFluidGlowKt.TicketUsedStamp_wC_cr3g$lambda$14(TicketUsedStamp, text, j, modifier3, alignment3, f3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 3072;
        modifier2 = modifier;
        i4 = i2 & 8;
        if (i4 != 0) {
            if ((i & 24576) == 0) {
                alignment2 = alignment;
                if (composerStartRestartGroup.changed(alignment2)) {
                    i5 = 16384;
                } else {
                    i5 = 8192;
                }
                i3 |= i5;
            }
            i6 = i2 & 16;
            if (i6 != 0) {
                if ((196608 & i) == 0) {
                    f2 = f;
                    if (composerStartRestartGroup.changed(f2)) {
                        i7 = 131072;
                    } else {
                        i7 = 65536;
                    }
                    i3 |= i7;
                }
                if ((i3 & 74899) != 74898) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    modifier3 = modifier2;
                    alignment3 = alignment2;
                    f3 = f2;
                } else {
                    if (i8 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i4 != 0) {
                        centerEnd = Alignment.INSTANCE.getCenterEnd();
                    } else {
                        centerEnd = alignment2;
                    }
                    if (i6 != 0) {
                        fM8748constructorimpl = Dp.m8748constructorimpl(14.0f);
                    } else {
                        fM8748constructorimpl = f2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-149765162, i3, -1, "com.example.tickets.TicketUsedStamp (TicketFluidGlow.kt:205)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2104575028, "CC(remember):TicketFluidGlow.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = AnimatableKt.Animatable$default(0.72f, 0.0f, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    animatable = (Animatable) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2104576689, "CC(remember):TicketFluidGlow.kt#9igjgp");
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = AnimatableKt.Animatable$default(0.0f, 0.0f, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    animatable2 = (Animatable) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Unit unit5 = Unit.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2104578791, "CC(remember):TicketFluidGlow.kt#9igjgp");
                    zChangedInstance = composerStartRestartGroup.changedInstance(animatable2) | composerStartRestartGroup.changedInstance(animatable);
                    ticketFluidGlowKt$TicketUsedStamp$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!zChangedInstance) {
                        ticketFluidGlowKt$TicketUsedStamp$1$1RememberedValue = new TicketFluidGlowKt$TicketUsedStamp$1$1(animatable2, animatable, null);
                        composerStartRestartGroup.updateRememberedValue(ticketFluidGlowKt$TicketUsedStamp$1$1RememberedValue);
                    } else {
                        ticketFluidGlowKt$TicketUsedStamp$1$1RememberedValue = new TicketFluidGlowKt$TicketUsedStamp$1$1(animatable2, animatable, null);
                        composerStartRestartGroup.updateRememberedValue(ticketFluidGlowKt$TicketUsedStamp$1$1RememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    EffectsKt.LaunchedEffect(unit5, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) ticketFluidGlowKt$TicketUsedStamp$1$1RememberedValue, composerStartRestartGroup, 6);
                    float f8 = fM8748constructorimpl;
                    Modifier modifierM1492sizeVpY3zN8 = SizeKt.m1492sizeVpY3zN4(RotateKt.rotate(AlphaKt.alpha(ScaleKt.scale(PaddingKt.m1427paddingqDBjuR0$default(TicketUsedStamp.align(companion, centerEnd), 0.0f, 0.0f, fM8748constructorimpl, 0.0f, 11, null), ((Number) animatable.getValue()).floatValue()), ((Number) animatable2.getValue()).floatValue()), -7.0f), Dp.m8748constructorimpl(122.0f), Dp.m8748constructorimpl(60.0f));
                    Alignment center5 = Alignment.INSTANCE.getCenter();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy5 = BoxKt.maybeCachedBoxMeasurePolicy(center5, false);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
                    int iHashCode5 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap5 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier5 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1492sizeVpY3zN8);
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
                    Updater.m4945setimpl(composerM4937constructorimpl5, measurePolicyMaybeCachedBoxMeasurePolicy5, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m4945setimpl(composerM4937constructorimpl5, currentCompositionLocalMap5, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Updater.m4945setimpl(composerM4937constructorimpl5, Integer.valueOf(iHashCode5), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                    Updater.m4943reconcileimpl(composerM4937constructorimpl5, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                    Updater.m4945setimpl(composerM4937constructorimpl5, modifierMaterializeModifier5, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance5 = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 835633088, "C239@7310L832,237@7246L896,264@8152L201:TicketFluidGlow.kt#n9ob9m");
                    Modifier modifierFillMaxSize$default5 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1135336336, "CC(remember):TicketFluidGlow.kt#9igjgp");
                    if ((i3 & 896) == 256) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (!z2) {
                        objRememberedValue3 = new Function1() { // from class: com.example.tickets.TicketFluidGlowKt$$ExternalSyntheticLambda8
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return TicketFluidGlowKt.TicketUsedStamp_wC_cr3g$lambda$13$lambda$12$lambda$11(j, (DrawScope) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = new Function1() { // from class: com.example.tickets.TicketFluidGlowKt$$ExternalSyntheticLambda8
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return TicketFluidGlowKt.TicketUsedStamp_wC_cr3g$lambda$13$lambda$12$lambda$11(j, (DrawScope) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    CanvasKt.Canvas(modifierFillMaxSize$default5, (Function1) objRememberedValue3, composerStartRestartGroup, 6);
                    Modifier modifier8 = companion;
                    Alignment alignment8 = centerEnd;
                    composer2 = composerStartRestartGroup;
                    TextKt.m3661TextNvy7gAk(text, null, Color.m5837copywmQWz5c$default(j, 0.92f, 0.0f, 0.0f, 0.0f, 14, null), null, TextUnitKt.getSp(16.5d), null, FontWeight.INSTANCE.getExtraBold(), null, TextUnitKt.getSp(1.8d), null, null, 0L, 0, false, 0, 0, null, null, composer2, ((i3 >> 3) & 14) | 102260736, 0, 261802);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    composer2.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    alignment3 = alignment8;
                    f3 = f8;
                    modifier3 = modifier8;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.tickets.TicketFluidGlowKt$$ExternalSyntheticLambda9
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return TicketFluidGlowKt.TicketUsedStamp_wC_cr3g$lambda$14(TicketUsedStamp, text, j, modifier3, alignment3, f3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            f2 = f;
            if ((i3 & 74899) != 74898) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                modifier3 = modifier2;
                alignment3 = alignment2;
                f3 = f2;
            } else {
                if (i8 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i4 != 0) {
                    centerEnd = Alignment.INSTANCE.getCenterEnd();
                } else {
                    centerEnd = alignment2;
                }
                if (i6 != 0) {
                    fM8748constructorimpl = Dp.m8748constructorimpl(14.0f);
                } else {
                    fM8748constructorimpl = f2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-149765162, i3, -1, "com.example.tickets.TicketUsedStamp (TicketFluidGlow.kt:205)");
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2104575028, "CC(remember):TicketFluidGlow.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = AnimatableKt.Animatable$default(0.72f, 0.0f, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                animatable = (Animatable) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2104576689, "CC(remember):TicketFluidGlow.kt#9igjgp");
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = AnimatableKt.Animatable$default(0.0f, 0.0f, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                animatable2 = (Animatable) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Unit unit6 = Unit.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2104578791, "CC(remember):TicketFluidGlow.kt#9igjgp");
                zChangedInstance = composerStartRestartGroup.changedInstance(animatable2) | composerStartRestartGroup.changedInstance(animatable);
                ticketFluidGlowKt$TicketUsedStamp$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (!zChangedInstance) {
                    ticketFluidGlowKt$TicketUsedStamp$1$1RememberedValue = new TicketFluidGlowKt$TicketUsedStamp$1$1(animatable2, animatable, null);
                    composerStartRestartGroup.updateRememberedValue(ticketFluidGlowKt$TicketUsedStamp$1$1RememberedValue);
                } else {
                    ticketFluidGlowKt$TicketUsedStamp$1$1RememberedValue = new TicketFluidGlowKt$TicketUsedStamp$1$1(animatable2, animatable, null);
                    composerStartRestartGroup.updateRememberedValue(ticketFluidGlowKt$TicketUsedStamp$1$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                EffectsKt.LaunchedEffect(unit6, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) ticketFluidGlowKt$TicketUsedStamp$1$1RememberedValue, composerStartRestartGroup, 6);
                float f9 = fM8748constructorimpl;
                Modifier modifierM1492sizeVpY3zN9 = SizeKt.m1492sizeVpY3zN4(RotateKt.rotate(AlphaKt.alpha(ScaleKt.scale(PaddingKt.m1427paddingqDBjuR0$default(TicketUsedStamp.align(companion, centerEnd), 0.0f, 0.0f, fM8748constructorimpl, 0.0f, 11, null), ((Number) animatable.getValue()).floatValue()), ((Number) animatable2.getValue()).floatValue()), -7.0f), Dp.m8748constructorimpl(122.0f), Dp.m8748constructorimpl(60.0f));
                Alignment center6 = Alignment.INSTANCE.getCenter();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy6 = BoxKt.maybeCachedBoxMeasurePolicy(center6, false);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
                int iHashCode6 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap6 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier6 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1492sizeVpY3zN9);
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
                Composer composerM4937constructorimpl6 = Updater.m4937constructorimpl(composerStartRestartGroup);
                Updater.m4945setimpl(composerM4937constructorimpl6, measurePolicyMaybeCachedBoxMeasurePolicy6, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m4945setimpl(composerM4937constructorimpl6, currentCompositionLocalMap6, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Updater.m4945setimpl(composerM4937constructorimpl6, Integer.valueOf(iHashCode6), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                Updater.m4943reconcileimpl(composerM4937constructorimpl6, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                Updater.m4945setimpl(composerM4937constructorimpl6, modifierMaterializeModifier6, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance6 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 835633088, "C239@7310L832,237@7246L896,264@8152L201:TicketFluidGlow.kt#n9ob9m");
                Modifier modifierFillMaxSize$default6 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1135336336, "CC(remember):TicketFluidGlow.kt#9igjgp");
                if ((i3 & 896) == 256) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (!z2) {
                    objRememberedValue3 = new Function1() { // from class: com.example.tickets.TicketFluidGlowKt$$ExternalSyntheticLambda8
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return TicketFluidGlowKt.TicketUsedStamp_wC_cr3g$lambda$13$lambda$12$lambda$11(j, (DrawScope) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = new Function1() { // from class: com.example.tickets.TicketFluidGlowKt$$ExternalSyntheticLambda8
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return TicketFluidGlowKt.TicketUsedStamp_wC_cr3g$lambda$13$lambda$12$lambda$11(j, (DrawScope) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                CanvasKt.Canvas(modifierFillMaxSize$default6, (Function1) objRememberedValue3, composerStartRestartGroup, 6);
                Modifier modifier9 = companion;
                Alignment alignment9 = centerEnd;
                composer2 = composerStartRestartGroup;
                TextKt.m3661TextNvy7gAk(text, null, Color.m5837copywmQWz5c$default(j, 0.92f, 0.0f, 0.0f, 0.0f, 14, null), null, TextUnitKt.getSp(16.5d), null, FontWeight.INSTANCE.getExtraBold(), null, TextUnitKt.getSp(1.8d), null, null, 0L, 0, false, 0, 0, null, null, composer2, ((i3 >> 3) & 14) | 102260736, 0, 261802);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                alignment3 = alignment9;
                f3 = f9;
                modifier3 = modifier9;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.tickets.TicketFluidGlowKt$$ExternalSyntheticLambda9
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return TicketFluidGlowKt.TicketUsedStamp_wC_cr3g$lambda$14(TicketUsedStamp, text, j, modifier3, alignment3, f3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 24576;
        alignment2 = alignment;
        i6 = i2 & 16;
        if (i6 != 0) {
            if ((196608 & i) == 0) {
                f2 = f;
                if (composerStartRestartGroup.changed(f2)) {
                    i7 = 131072;
                } else {
                    i7 = 65536;
                }
                i3 |= i7;
            }
            if ((i3 & 74899) != 74898) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                modifier3 = modifier2;
                alignment3 = alignment2;
                f3 = f2;
            } else {
                if (i8 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i4 != 0) {
                    centerEnd = Alignment.INSTANCE.getCenterEnd();
                } else {
                    centerEnd = alignment2;
                }
                if (i6 != 0) {
                    fM8748constructorimpl = Dp.m8748constructorimpl(14.0f);
                } else {
                    fM8748constructorimpl = f2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-149765162, i3, -1, "com.example.tickets.TicketUsedStamp (TicketFluidGlow.kt:205)");
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2104575028, "CC(remember):TicketFluidGlow.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = AnimatableKt.Animatable$default(0.72f, 0.0f, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                animatable = (Animatable) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2104576689, "CC(remember):TicketFluidGlow.kt#9igjgp");
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = AnimatableKt.Animatable$default(0.0f, 0.0f, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                animatable2 = (Animatable) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Unit unit7 = Unit.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2104578791, "CC(remember):TicketFluidGlow.kt#9igjgp");
                zChangedInstance = composerStartRestartGroup.changedInstance(animatable2) | composerStartRestartGroup.changedInstance(animatable);
                ticketFluidGlowKt$TicketUsedStamp$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (!zChangedInstance) {
                    ticketFluidGlowKt$TicketUsedStamp$1$1RememberedValue = new TicketFluidGlowKt$TicketUsedStamp$1$1(animatable2, animatable, null);
                    composerStartRestartGroup.updateRememberedValue(ticketFluidGlowKt$TicketUsedStamp$1$1RememberedValue);
                } else {
                    ticketFluidGlowKt$TicketUsedStamp$1$1RememberedValue = new TicketFluidGlowKt$TicketUsedStamp$1$1(animatable2, animatable, null);
                    composerStartRestartGroup.updateRememberedValue(ticketFluidGlowKt$TicketUsedStamp$1$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                EffectsKt.LaunchedEffect(unit7, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) ticketFluidGlowKt$TicketUsedStamp$1$1RememberedValue, composerStartRestartGroup, 6);
                float f10 = fM8748constructorimpl;
                Modifier modifierM1492sizeVpY3zN10 = SizeKt.m1492sizeVpY3zN4(RotateKt.rotate(AlphaKt.alpha(ScaleKt.scale(PaddingKt.m1427paddingqDBjuR0$default(TicketUsedStamp.align(companion, centerEnd), 0.0f, 0.0f, fM8748constructorimpl, 0.0f, 11, null), ((Number) animatable.getValue()).floatValue()), ((Number) animatable2.getValue()).floatValue()), -7.0f), Dp.m8748constructorimpl(122.0f), Dp.m8748constructorimpl(60.0f));
                Alignment center7 = Alignment.INSTANCE.getCenter();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy7 = BoxKt.maybeCachedBoxMeasurePolicy(center7, false);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
                int iHashCode7 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap7 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier7 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1492sizeVpY3zN10);
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
                Updater.m4945setimpl(composerM4937constructorimpl7, measurePolicyMaybeCachedBoxMeasurePolicy7, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m4945setimpl(composerM4937constructorimpl7, currentCompositionLocalMap7, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Updater.m4945setimpl(composerM4937constructorimpl7, Integer.valueOf(iHashCode7), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                Updater.m4943reconcileimpl(composerM4937constructorimpl7, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                Updater.m4945setimpl(composerM4937constructorimpl7, modifierMaterializeModifier7, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance7 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 835633088, "C239@7310L832,237@7246L896,264@8152L201:TicketFluidGlow.kt#n9ob9m");
                Modifier modifierFillMaxSize$default7 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1135336336, "CC(remember):TicketFluidGlow.kt#9igjgp");
                if ((i3 & 896) == 256) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (!z2) {
                    objRememberedValue3 = new Function1() { // from class: com.example.tickets.TicketFluidGlowKt$$ExternalSyntheticLambda8
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return TicketFluidGlowKt.TicketUsedStamp_wC_cr3g$lambda$13$lambda$12$lambda$11(j, (DrawScope) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = new Function1() { // from class: com.example.tickets.TicketFluidGlowKt$$ExternalSyntheticLambda8
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return TicketFluidGlowKt.TicketUsedStamp_wC_cr3g$lambda$13$lambda$12$lambda$11(j, (DrawScope) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                CanvasKt.Canvas(modifierFillMaxSize$default7, (Function1) objRememberedValue3, composerStartRestartGroup, 6);
                Modifier modifier10 = companion;
                Alignment alignment10 = centerEnd;
                composer2 = composerStartRestartGroup;
                TextKt.m3661TextNvy7gAk(text, null, Color.m5837copywmQWz5c$default(j, 0.92f, 0.0f, 0.0f, 0.0f, 14, null), null, TextUnitKt.getSp(16.5d), null, FontWeight.INSTANCE.getExtraBold(), null, TextUnitKt.getSp(1.8d), null, null, 0L, 0, false, 0, 0, null, null, composer2, ((i3 >> 3) & 14) | 102260736, 0, 261802);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                alignment3 = alignment10;
                f3 = f10;
                modifier3 = modifier10;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.tickets.TicketFluidGlowKt$$ExternalSyntheticLambda9
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return TicketFluidGlowKt.TicketUsedStamp_wC_cr3g$lambda$14(TicketUsedStamp, text, j, modifier3, alignment3, f3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        f2 = f;
        if ((i3 & 74899) != 74898) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            modifier3 = modifier2;
            alignment3 = alignment2;
            f3 = f2;
        } else {
            if (i8 != 0) {
                companion = Modifier.INSTANCE;
            } else {
                companion = modifier2;
            }
            if (i4 != 0) {
                centerEnd = Alignment.INSTANCE.getCenterEnd();
            } else {
                centerEnd = alignment2;
            }
            if (i6 != 0) {
                fM8748constructorimpl = Dp.m8748constructorimpl(14.0f);
            } else {
                fM8748constructorimpl = f2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-149765162, i3, -1, "com.example.tickets.TicketUsedStamp (TicketFluidGlow.kt:205)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2104575028, "CC(remember):TicketFluidGlow.kt#9igjgp");
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = AnimatableKt.Animatable$default(0.72f, 0.0f, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            animatable = (Animatable) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2104576689, "CC(remember):TicketFluidGlow.kt#9igjgp");
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = AnimatableKt.Animatable$default(0.0f, 0.0f, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            animatable2 = (Animatable) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Unit unit8 = Unit.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2104578791, "CC(remember):TicketFluidGlow.kt#9igjgp");
            zChangedInstance = composerStartRestartGroup.changedInstance(animatable2) | composerStartRestartGroup.changedInstance(animatable);
            ticketFluidGlowKt$TicketUsedStamp$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (!zChangedInstance) {
                ticketFluidGlowKt$TicketUsedStamp$1$1RememberedValue = new TicketFluidGlowKt$TicketUsedStamp$1$1(animatable2, animatable, null);
                composerStartRestartGroup.updateRememberedValue(ticketFluidGlowKt$TicketUsedStamp$1$1RememberedValue);
            } else {
                ticketFluidGlowKt$TicketUsedStamp$1$1RememberedValue = new TicketFluidGlowKt$TicketUsedStamp$1$1(animatable2, animatable, null);
                composerStartRestartGroup.updateRememberedValue(ticketFluidGlowKt$TicketUsedStamp$1$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.LaunchedEffect(unit8, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) ticketFluidGlowKt$TicketUsedStamp$1$1RememberedValue, composerStartRestartGroup, 6);
            float f11 = fM8748constructorimpl;
            Modifier modifierM1492sizeVpY3zN11 = SizeKt.m1492sizeVpY3zN4(RotateKt.rotate(AlphaKt.alpha(ScaleKt.scale(PaddingKt.m1427paddingqDBjuR0$default(TicketUsedStamp.align(companion, centerEnd), 0.0f, 0.0f, fM8748constructorimpl, 0.0f, 11, null), ((Number) animatable.getValue()).floatValue()), ((Number) animatable2.getValue()).floatValue()), -7.0f), Dp.m8748constructorimpl(122.0f), Dp.m8748constructorimpl(60.0f));
            Alignment center8 = Alignment.INSTANCE.getCenter();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy8 = BoxKt.maybeCachedBoxMeasurePolicy(center8, false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
            int iHashCode8 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap8 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier8 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1492sizeVpY3zN11);
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
            Updater.m4945setimpl(composerM4937constructorimpl8, measurePolicyMaybeCachedBoxMeasurePolicy8, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m4945setimpl(composerM4937constructorimpl8, currentCompositionLocalMap8, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m4945setimpl(composerM4937constructorimpl8, Integer.valueOf(iHashCode8), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m4943reconcileimpl(composerM4937constructorimpl8, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m4945setimpl(composerM4937constructorimpl8, modifierMaterializeModifier8, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance8 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 835633088, "C239@7310L832,237@7246L896,264@8152L201:TicketFluidGlow.kt#n9ob9m");
            Modifier modifierFillMaxSize$default8 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1135336336, "CC(remember):TicketFluidGlow.kt#9igjgp");
            if ((i3 & 896) == 256) {
                z2 = true;
            } else {
                z2 = false;
            }
            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (!z2) {
                objRememberedValue3 = new Function1() { // from class: com.example.tickets.TicketFluidGlowKt$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return TicketFluidGlowKt.TicketUsedStamp_wC_cr3g$lambda$13$lambda$12$lambda$11(j, (DrawScope) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            } else {
                objRememberedValue3 = new Function1() { // from class: com.example.tickets.TicketFluidGlowKt$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return TicketFluidGlowKt.TicketUsedStamp_wC_cr3g$lambda$13$lambda$12$lambda$11(j, (DrawScope) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            CanvasKt.Canvas(modifierFillMaxSize$default8, (Function1) objRememberedValue3, composerStartRestartGroup, 6);
            Modifier modifier11 = companion;
            Alignment alignment11 = centerEnd;
            composer2 = composerStartRestartGroup;
            TextKt.m3661TextNvy7gAk(text, null, Color.m5837copywmQWz5c$default(j, 0.92f, 0.0f, 0.0f, 0.0f, 14, null), null, TextUnitKt.getSp(16.5d), null, FontWeight.INSTANCE.getExtraBold(), null, TextUnitKt.getSp(1.8d), null, null, 0L, 0, false, 0, 0, null, null, composer2, ((i3 >> 3) & 14) | 102260736, 0, 261802);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            alignment3 = alignment11;
            f3 = f11;
            modifier3 = modifier11;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.tickets.TicketFluidGlowKt$$ExternalSyntheticLambda9
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TicketFluidGlowKt.TicketUsedStamp_wC_cr3g$lambda$14(TicketUsedStamp, text, j, modifier3, alignment3, f3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    static final Unit TicketUsedStamp_wC_cr3g$lambda$13$lambda$12$lambda$11(long j, DrawScope Canvas) {
        Intrinsics.checkNotNullParameter(Canvas, "$this$Canvas");
        long jM5837copywmQWz5c$default = Color.m5837copywmQWz5c$default(j, 0.9f, 0.0f, 0.0f, 0.0f, 14, null);
        float f = Canvas.mo803toPx0680j_4(Dp.m8748constructorimpl(13.0f));
        DrawScope.m6433drawRoundRectuAw5IA$default(Canvas, jM5837copywmQWz5c$default, 0L, 0L, CornerRadius.m5521constructorimpl((((long) Float.floatToRawIntBits(f)) << 32) | (((long) Float.floatToRawIntBits(f)) & 4294967295L)), new Stroke(Canvas.mo803toPx0680j_4(Dp.m8748constructorimpl(3.2f)), 0.0f, 0, 0, null, 30, null), 0.0f, null, 0, 230, null);
        long jM5837copywmQWz5c$default2 = Color.m5837copywmQWz5c$default(jM5837copywmQWz5c$default, 0.52f, 0.0f, 0.0f, 0.0f, 14, null);
        Stroke stroke = new Stroke(Canvas.mo803toPx0680j_4(Dp.m8748constructorimpl(1.7f)), 0.0f, 0, 0, null, 30, null);
        float f2 = Canvas.mo803toPx0680j_4(Dp.m8748constructorimpl(5.0f));
        float f3 = Canvas.mo803toPx0680j_4(Dp.m8748constructorimpl(5.0f));
        long jM5559constructorimpl = Offset.m5559constructorimpl((((long) Float.floatToRawIntBits(f2)) << 32) | (((long) Float.floatToRawIntBits(f3)) & 4294967295L));
        float fIntBitsToFloat = Float.intBitsToFloat((int) (Canvas.mo6437getSizeNHjbRc() >> 32)) - Canvas.mo803toPx0680j_4(Dp.m8748constructorimpl(10.0f));
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (Canvas.mo6437getSizeNHjbRc() & 4294967295L)) - Canvas.mo803toPx0680j_4(Dp.m8748constructorimpl(10.0f));
        float f4 = f * 0.78f;
        DrawScope.m6433drawRoundRectuAw5IA$default(Canvas, jM5837copywmQWz5c$default2, jM5559constructorimpl, Size.m5627constructorimpl((((long) Float.floatToRawIntBits(fIntBitsToFloat)) << 32) | (((long) Float.floatToRawIntBits(fIntBitsToFloat2)) & 4294967295L)), CornerRadius.m5521constructorimpl((((long) Float.floatToRawIntBits(f4)) << 32) | (((long) Float.floatToRawIntBits(f4)) & 4294967295L)), stroke, 0.0f, null, 0, 224, null);
        return Unit.INSTANCE;
    }

    public static final long ticketFluidThemeColor(String ticketType) {
        Intrinsics.checkNotNullParameter(ticketType, "ticketType");
        String str = ticketType;
        if (StringsKt.contains$default((CharSequence) str, (CharSequence) "机票", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) str, (CharSequence) "飞机", false, 2, (Object) null) || StringsKt.contains((CharSequence) str, (CharSequence) "Airplane", true)) {
            return ColorKt.Color(4283278335L);
        }
        if (StringsKt.contains$default((CharSequence) str, (CharSequence) "火车", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) str, (CharSequence) "车票", false, 2, (Object) null) || StringsKt.contains((CharSequence) str, (CharSequence) "Train", true)) {
            return ColorKt.Color(4281910949L);
        }
        if (StringsKt.contains$default((CharSequence) str, (CharSequence) "电影", false, 2, (Object) null) || StringsKt.contains((CharSequence) str, (CharSequence) "Movie", true)) {
            return ColorKt.Color(4290079999L);
        }
        if (StringsKt.contains$default((CharSequence) str, (CharSequence) "演出", false, 2, (Object) null) || StringsKt.contains((CharSequence) str, (CharSequence) "Event", true)) {
            return ColorKt.Color(4294930321L);
        }
        if (StringsKt.contains$default((CharSequence) str, (CharSequence) "门票", false, 2, (Object) null) || StringsKt.contains((CharSequence) str, (CharSequence) "Admission", true)) {
            return ColorKt.Color(4294944842L);
        }
        if (StringsKt.contains$default((CharSequence) str, (CharSequence) "取餐", false, 2, (Object) null) || StringsKt.contains((CharSequence) str, (CharSequence) "Takeout", true)) {
            return ColorKt.Color(4294933061L);
        }
        if (StringsKt.contains$default((CharSequence) str, (CharSequence) "取件", false, 2, (Object) null) || StringsKt.contains((CharSequence) str, (CharSequence) "Pickup", true)) {
            return ColorKt.Color(4283807999L);
        }
        return ColorKt.Color(4284721407L);
    }

    public static final String ticketFluidStampText(String ticketType) {
        Intrinsics.checkNotNullParameter(ticketType, "ticketType");
        String str = ticketType;
        if (StringsKt.contains$default((CharSequence) str, (CharSequence) "机票", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) str, (CharSequence) "飞机", false, 2, (Object) null) || StringsKt.contains((CharSequence) str, (CharSequence) "Airplane", true) || StringsKt.contains$default((CharSequence) str, (CharSequence) "火车", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) str, (CharSequence) "车票", false, 2, (Object) null) || StringsKt.contains((CharSequence) str, (CharSequence) "Train", true)) {
            return "ARRIVED";
        }
        if (StringsKt.contains$default((CharSequence) str, (CharSequence) "电影", false, 2, (Object) null) || StringsKt.contains((CharSequence) str, (CharSequence) "Movie", true)) {
            return "WATCHED";
        }
        if (StringsKt.contains$default((CharSequence) str, (CharSequence) "演出", false, 2, (Object) null) || StringsKt.contains((CharSequence) str, (CharSequence) "Event", true)) {
            return "ATTENDED";
        }
        if (StringsKt.contains$default((CharSequence) str, (CharSequence) "门票", false, 2, (Object) null) || StringsKt.contains((CharSequence) str, (CharSequence) "Admission", true)) {
            return "VISITED";
        }
        if (StringsKt.contains$default((CharSequence) str, (CharSequence) "取餐", false, 2, (Object) null) || StringsKt.contains((CharSequence) str, (CharSequence) "Takeout", true)) {
            return "PICKED UP";
        }
        if (StringsKt.contains$default((CharSequence) str, (CharSequence) "取件", false, 2, (Object) null) || StringsKt.contains((CharSequence) str, (CharSequence) "Pickup", true)) {
            return "COLLECTED";
        }
        return "USED";
    }

    public static final void TicketFluidGlowPreviewDemo(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(251576999);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(TicketFluidGlowPreviewDemo)377@11253L65:TicketFluidGlow.kt#n9ob9m");
        if (!composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(251576999, i, -1, "com.example.tickets.TicketFluidGlowPreviewDemo (TicketFluidGlow.kt:376)");
            }
            MaterialThemeKt.MaterialTheme(null, null, null, ComposableSingletons$TicketFluidGlowKt.INSTANCE.getLambda$1712105811$app(), composerStartRestartGroup, 3072, 7);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.tickets.TicketFluidGlowKt$$ExternalSyntheticLambda10
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TicketFluidGlowKt.TicketFluidGlowPreviewDemo$lambda$15(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final void TicketFluidGlowPreviewDemoContent(Composer composer, final int i) {
        final MutableState mutableState;
        Composer composerStartRestartGroup = composer.startRestartGroup(38790436);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(TicketFluidGlowPreviewDemoContent)384@11393L68,388@11467L1762:TicketFluidGlow.kt#n9ob9m");
        if (!composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(38790436, i, -1, "com.example.tickets.TicketFluidGlowPreviewDemoContent (TicketFluidGlow.kt:383)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1377094328, "CC(remember):TicketFluidGlow.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(TicketFluidState.InProgress, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            MutableState mutableState2 = (MutableState) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierM1423padding3ABfNKs = PaddingKt.m1423padding3ABfNKs(BackgroundKt.m648backgroundbw27NRU$default(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), ColorKt.Color(4278651408L), null, 2, null), Dp.m8748constructorimpl(20.0f));
            Arrangement.HorizontalOrVertical horizontalOrVerticalM1115spacedBy0680j_4 = Arrangement.INSTANCE.m1115spacedBy0680j_4(Dp.m8748constructorimpl(16.0f));
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(horizontalOrVerticalM1115spacedBy0680j_4, Alignment.INSTANCE.getStart(), composerStartRestartGroup, 6);
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1510528322, "C395@11676L183,402@11869L220,411@12099L217,420@12326L897:TicketFluidGlow.kt#n9ob9m");
            TextKt.m3661TextNvy7gAk("Ticket Fluid Glow", null, Color.m5837copywmQWz5c$default(Color.INSTANCE.m5875getWhite0d7_KjU(), 0.88f, 0.0f, 0.0f, 0.0f, 14, null), null, TextUnitKt.getSp(18), null, FontWeight.INSTANCE.getSemiBold(), null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composerStartRestartGroup, 1597830, 0, 262058);
            composerStartRestartGroup = composerStartRestartGroup;
            DemoGlowCard("机票", TicketFluidGlowPreviewDemoContent$lambda$17(mutableState2), TicketFluidEdge.Bottom, SizeKt.m1476height3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m8748constructorimpl(150.0f)), composerStartRestartGroup, 3462);
            DemoGlowCard("演出", TicketFluidGlowPreviewDemoContent$lambda$17(mutableState2), TicketFluidEdge.Top, SizeKt.m1476height3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m8748constructorimpl(150.0f)), composerStartRestartGroup, 3462);
            Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
            Arrangement.HorizontalOrVertical horizontalOrVerticalM1115spacedBy0680j_5 = Arrangement.INSTANCE.m1115spacedBy0680j_4(Dp.m8748constructorimpl(8.0f));
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(horizontalOrVerticalM1115spacedBy0680j_5, Alignment.INSTANCE.getTop(), composerStartRestartGroup, 6);
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1657611910, "C425@12500L35,424@12466L174,432@12688L40,431@12654L179,439@12881L39,438@12847L179,446@13074L33,445@13040L173:TicketFluidGlow.kt#n9ob9m");
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1054907681, "CC(remember):TicketFluidGlow.kt#9igjgp");
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                mutableState = mutableState2;
                objRememberedValue2 = new Function0() { // from class: com.example.tickets.TicketFluidGlowKt$$ExternalSyntheticLambda11
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return TicketFluidGlowKt.TicketFluidGlowPreviewDemoContent$lambda$28$lambda$27$lambda$20$lambda$19(mutableState);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            } else {
                mutableState = mutableState2;
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            final MutableState mutableState3 = mutableState;
            ButtonKt.Button((Function0) objRememberedValue2, RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null), false, null, null, null, null, null, null, ComposableSingletons$TicketFluidGlowKt.INSTANCE.m9292getLambda$1372975506$app(), composerStartRestartGroup, 805306374, 508);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1054913702, "CC(remember):TicketFluidGlow.kt#9igjgp");
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = new Function0() { // from class: com.example.tickets.TicketFluidGlowKt$$ExternalSyntheticLambda12
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return TicketFluidGlowKt.TicketFluidGlowPreviewDemoContent$lambda$28$lambda$27$lambda$22$lambda$21(mutableState3);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ButtonKt.Button((Function0) objRememberedValue3, RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null), false, null, null, null, null, null, null, ComposableSingletons$TicketFluidGlowKt.INSTANCE.getLambda$704994213$app(), composerStartRestartGroup, 805306374, 508);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1054919877, "CC(remember):TicketFluidGlow.kt#9igjgp");
            Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue4 = new Function0() { // from class: com.example.tickets.TicketFluidGlowKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return TicketFluidGlowKt.TicketFluidGlowPreviewDemoContent$lambda$28$lambda$27$lambda$24$lambda$23(mutableState3);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ButtonKt.Button((Function0) objRememberedValue4, RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null), false, null, null, null, null, null, null, ComposableSingletons$TicketFluidGlowKt.INSTANCE.getLambda$1959776230$app(), composerStartRestartGroup, 805306374, 508);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1054926047, "CC(remember):TicketFluidGlow.kt#9igjgp");
            Object objRememberedValue5 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue5 = new Function0() { // from class: com.example.tickets.TicketFluidGlowKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return TicketFluidGlowKt.TicketFluidGlowPreviewDemoContent$lambda$28$lambda$27$lambda$26$lambda$25(mutableState3);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ButtonKt.Button((Function0) objRememberedValue5, RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null), false, null, null, null, null, null, null, ComposableSingletons$TicketFluidGlowKt.INSTANCE.m9291getLambda$1080409049$app(), composerStartRestartGroup, 805306374, 508);
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.tickets.TicketFluidGlowKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TicketFluidGlowKt.TicketFluidGlowPreviewDemoContent$lambda$29(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final TicketFluidState TicketFluidGlowPreviewDemoContent$lambda$17(MutableState<TicketFluidState> mutableState) {
        return mutableState.getValue();
    }

    static final Unit TicketFluidGlowPreviewDemoContent$lambda$28$lambda$27$lambda$20$lambda$19(MutableState mutableState) {
        mutableState.setValue(TicketFluidState.Normal);
        return Unit.INSTANCE;
    }

    static final Unit TicketFluidGlowPreviewDemoContent$lambda$28$lambda$27$lambda$22$lambda$21(MutableState mutableState) {
        mutableState.setValue(TicketFluidState.Approaching);
        return Unit.INSTANCE;
    }

    static final Unit TicketFluidGlowPreviewDemoContent$lambda$28$lambda$27$lambda$24$lambda$23(MutableState mutableState) {
        mutableState.setValue(TicketFluidState.InProgress);
        return Unit.INSTANCE;
    }

    static final Unit TicketFluidGlowPreviewDemoContent$lambda$28$lambda$27$lambda$26$lambda$25(MutableState mutableState) {
        mutableState.setValue(TicketFluidState.Used);
        return Unit.INSTANCE;
    }

    private static final void DemoGlowCard(final String str, final TicketFluidState ticketFluidState, final TicketFluidEdge ticketFluidEdge, final Modifier modifier, Composer composer, final int i) {
        String str2;
        int i2;
        Composer composer2;
        Composer composerStartRestartGroup = composer.startRestartGroup(2126780641);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(DemoGlowCard)N(ticketType,state,edge,modifier)462@13382L767:TicketFluidGlow.kt#n9ob9m");
        if ((i & 6) == 0) {
            str2 = str;
            i2 = (composerStartRestartGroup.changed(str2) ? 4 : 2) | i;
        } else {
            str2 = str;
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(ticketFluidState.ordinal()) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changed(ticketFluidEdge.ordinal()) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= composerStartRestartGroup.changed(modifier) ? 2048 : 1024;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 1171) != 1170, i2 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2126780641, i2, -1, "com.example.tickets.DemoGlowCard (TicketFluidGlow.kt:461)");
            }
            Modifier modifierM659borderxT4_qwU = BorderKt.m659borderxT4_qwU(BackgroundKt.m648backgroundbw27NRU$default(ClipKt.clip(modifier, RoundedCornerShapeKt.m1756RoundedCornerShape0680j_4(Dp.m8748constructorimpl(22.0f))), ColorKt.Color(4279309597L), null, 2, null), Dp.m8748constructorimpl(1.0f), Color.m5837copywmQWz5c$default(Color.INSTANCE.m5875getWhite0d7_KjU(), 0.055f, 0.0f, 0.0f, 0.0f, 14, null), RoundedCornerShapeKt.m1756RoundedCornerShape0680j_4(Dp.m8748constructorimpl(22.0f)));
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 172257765, "C472@13692L280,482@13982L161:TicketFluidGlow.kt#n9ob9m");
            composer2 = composerStartRestartGroup;
            TextKt.m3661TextNvy7gAk(str2, PaddingKt.m1423padding3ABfNKs(boxScopeInstance.align(Modifier.INSTANCE, Alignment.INSTANCE.getCenter()), Dp.m8748constructorimpl(12.0f)), Color.m5837copywmQWz5c$default(Color.INSTANCE.m5875getWhite0d7_KjU(), 0.82f, 0.0f, 0.0f, 0.0f, 14, null), null, TextUnitKt.getSp(16.5d), null, FontWeight.INSTANCE.getMedium(), null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer2, (i2 & 14) | 1597824, 0, 262056);
            int i3 = i2 << 3;
            m9314TicketFluidGloweq_XX3s(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), str, ticketFluidState, ticketFluidEdge, null, null, false, null, 0.0f, composer2, (i3 & StylePropertiesKt.TextDirectionMask) | 6 | (i3 & 896) | (i3 & 7168), 496);
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.tickets.TicketFluidGlowKt$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TicketFluidGlowKt.DemoGlowCard$lambda$31(str, ticketFluidState, ticketFluidEdge, modifier, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final float TicketFluidGlowCanvas_8V94_ZQ$lambda$4(State<Float> state) {
        return state.getValue().floatValue();
    }
}
