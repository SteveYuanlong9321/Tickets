package com.example.tickets;

import android.graphics.RuntimeShader;
import android.os.Build;
import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.InfiniteRepeatableSpec;
import androidx.compose.animation.core.InfiniteTransition;
import androidx.compose.animation.core.InfiniteTransitionKt;
import androidx.compose.animation.core.KeyframesSpec;
import androidx.compose.animation.core.RepeatMode;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.style.StylePropertiesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.AndroidPaint_androidKt;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Paint;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.unit.Dp;
import androidx.core.app.NotificationCompat;
import androidx.core.location.LocationRequestCompat;
import androidx.vectordrawable.graphics.drawable.PathInterpolatorCompat;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: TicketTransferBeamEffect.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0007\u001a\u001f\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0001¢\u0006\u0002\u0010\u0006\u001a'\u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0001¢\u0006\u0002\u0010\n\u001a-\u0010\u000b\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0003¢\u0006\u0002\u0010\u000e\u001a\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0003H\u0002\u001a \u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0003H\u0002\"\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016²\u0006\n\u0010\u0017\u001a\u00020\u0003X\u008a\u0084\u0002²\u0006\n\u0010\r\u001a\u00020\u0003X\u008a\u0084\u0002"}, d2 = {"TicketNfcContactRippleEffect", "", NotificationCompat.CATEGORY_PROGRESS, "", "modifier", "Landroidx/compose/ui/Modifier;", "(FLandroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "TicketTransferBeamEffect", "mode", "Lcom/example/tickets/TicketBeamMode;", "(Lcom/example/tickets/TicketBeamMode;FLandroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "LegacyTopGlassFallback", "p", "time", "(Lcom/example/tickets/TicketBeamMode;FFLandroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)V", "TOP_GLASS_AGSL", "", "easeOutCubic", "value", "smoothStep", "edge0", "edge1", "app", "shimmer"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class TicketTransferBeamEffectKt {
    private static final String TOP_GLASS_AGSL = "uniform float2 uResolution;\nuniform float uProgress;\nuniform float uTime;\nuniform float uDirection;\n\nfloat saturate(float x) {\n    return clamp(x, 0.0, 1.0);\n}\n\nfloat softExp(float x) {\n    return exp(-x * x);\n}\n\nhalf4 main(float2 fragCoord) {\n    float2 uv = fragCoord / uResolution;\n    float aspect = uResolution.x / max(uResolution.y, 1.0);\n\n    // Coordinates are anchored at the top-center. The visible wave is a\n    // lower half-ellipse, so it feels attached to the phone's top hardware.\n    float2 q = float2((uv.x - 0.5) * aspect, uv.y);\n    float t = saturate(uProgress);\n    float grow = smoothstep(0.0, 1.0, t);\n    float appear = smoothstep(0.0, 0.20, t);\n    // 扩散完成后保持住，不再把整片光场淡掉。\n    float hold = smoothstep(0.40, 1.0, t);\n\n    float rx = mix(0.028, 1.48, grow);\n    float ry = mix(0.020, 0.50, grow);\n    float cy = mix(0.006, 0.018, grow);\n\n    float ellipseR = length(float2(q.x / max(rx, 0.001), (q.y - cy) / max(ry, 0.001)));\n    float lowerMask = smoothstep(-0.01, 0.035, q.y);\n\n    // Broad translucent body of the liquid-glass bloom.\n    float body = softExp((ellipseR - 0.58) * 2.35) * lowerMask;\n    body *= (0.70 + 0.30 * appear);\n\n    // Soft moving refractive lip — deliberately blurred, not a hard ring.\n    float lip = softExp((ellipseR - 0.96) * 7.5) * lowerMask;\n\n    // Secondary haze makes the light look volumetric rather than like a stroke.\n    float haze = softExp(q.x * 1.65) * softExp((q.y - 0.055) * 3.2);\n    haze *= grow;\n\n    // 全屏液态玻璃场：波从顶部中心向整个界面扩散，底部不会被截断。\n    // 这是柔和的体积场，不是一条可见的圆环。\n    float fullField = exp(-pow(ellipseR * 1.18, 2.15));\n    float lowerField = smoothstep(-0.03, 0.14, q.y);\n    fullField *= lowerField * grow;\n\n    // 无线呼吸波纹：波峰只向外跑，不回收整个光场。\n    float breath = 0.5 + 0.5 * sin(uTime * 6.2831853);\n    float drift = (uTime * 1.55 + breath * 0.24) * uDirection;\n\n    float causticA = 0.5 + 0.5 * sin(q.x * 18.0 + q.y * 14.0 + drift);\n    float causticB = 0.5 + 0.5 * sin(q.x * 34.0 - q.y * 21.0 - drift * 1.24);\n    float caustic = pow(causticA * causticB, 3.8) * lip;\n\n    // 三层柔性椭圆波，持续从顶部中心向屏幕外缘滑行。\n    float waveA = fract(ellipseR * 1.72 - uTime * 0.92);\n    float waveB = fract(ellipseR * 2.35 - uTime * 0.74 + 0.29);\n    float waveC = fract(ellipseR * 3.05 - uTime * 0.58 + 0.61);\n\n    float rippleA = exp(-pow((waveA - 0.11) / 0.075, 2.0));\n    float rippleB = exp(-pow((waveB - 0.10) / 0.070, 2.0));\n    float rippleC = exp(-pow((waveC - 0.09) / 0.065, 2.0));\n\n    float breathing = (\n        0.52 * rippleA +\n        0.31 * rippleB +\n        0.17 * rippleC\n    ) * lowerMask * (0.65 + 0.35 * hold);\n\n    // Central energy pocket; it never becomes an opaque white flash.\n    float core = exp(-length(float2(q.x * 7.0, (q.y - 0.015) * 22.0)));\n    core *= (0.55 + 0.45 * sin(uTime * 6.283 + 0.6) * 0.08) * appear;\n\n    // Very faint vertical dispersion below the top lip: a glass sheet catching light.\n    float dispersion = exp(-abs(q.x) * 5.4) * exp(-max(q.y - 0.01, 0.0) * 5.4);\n    dispersion *= 0.16 * grow;\n\n    float alpha =\n        0.050 * body +\n        0.085 * haze +\n        0.090 * lip +\n        0.060 * caustic +\n        0.072 * breathing +\n        0.050 * core +\n        0.020 * dispersion +\n        0.032 * fullField * (0.76 + 0.24 * breath);\n\n    // Tiny cool-tinted glass separation at the shoulders.\n    float shoulder = pow(saturate(abs(q.x) / max(rx, 0.001)), 2.2) * lip * 0.035;\n\n    float3 rgb = float3(\n        1.0,\n        0.995 - shoulder,\n        0.99\n    );\n\n    return half4(half3(rgb), half(saturate(alpha)));\n}";

    static final Unit LegacyTopGlassFallback$lambda$24(TicketBeamMode ticketBeamMode, float f, float f2, Modifier modifier, int i, Composer composer, int i2) {
        LegacyTopGlassFallback(ticketBeamMode, f, f2, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    static final Unit TicketNfcContactRippleEffect$lambda$0(float f, Modifier modifier, int i, int i2, Composer composer, int i3) {
        TicketNfcContactRippleEffect(f, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    static final Unit TicketNfcContactRippleEffect$lambda$6(float f, Modifier modifier, int i, int i2, Composer composer, int i3) {
        TicketNfcContactRippleEffect(f, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    static final Unit TicketTransferBeamEffect$lambda$21(TicketBeamMode ticketBeamMode, float f, Modifier modifier, int i, int i2, Composer composer, int i3) {
        TicketTransferBeamEffect(ticketBeamMode, f, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    static final Unit TicketTransferBeamEffect$lambda$7(TicketBeamMode ticketBeamMode, float f, Modifier modifier, int i, int i2, Composer composer, int i3) {
        TicketTransferBeamEffect(ticketBeamMode, f, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0048  */
    /* JADX WARN: Code duplicated, block: B:24:0x004a  */
    /* JADX WARN: Code duplicated, block: B:27:0x0053 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:28:0x0055  */
    /* JADX WARN: Code duplicated, block: B:29:0x005b  */
    /* JADX WARN: Code duplicated, block: B:32:0x0062  */
    /* JADX WARN: Code duplicated, block: B:35:0x0073  */
    /* JADX WARN: Code duplicated, block: B:37:0x0079  */
    /* JADX WARN: Code duplicated, block: B:40:0x0082  */
    /* JADX WARN: Code duplicated, block: B:43:0x008b  */
    /* JADX WARN: Code duplicated, block: B:45:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:50:0x00f7  */
    /* JADX WARN: Code duplicated, block: B:53:0x0111  */
    /* JADX WARN: Code duplicated, block: B:54:0x0115  */
    /* JADX WARN: Code duplicated, block: B:57:0x011f  */
    /* JADX WARN: Code duplicated, block: B:58:0x0126 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Code duplicated, block: B:59:? A[RETURN, SYNTHETIC] */
    public static final void TicketNfcContactRippleEffect(final float f, Modifier modifier, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        boolean z;
        final Modifier modifier3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Function2<? super Composer, ? super Integer, Unit> function2;
        final float fCoerceIn;
        Object objRememberedValue;
        final State<Float> stateAnimateFloat;
        boolean zChanged;
        Object objRememberedValue2;
        Composer composerStartRestartGroup = composer.startRestartGroup(2086450186);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(TicketNfcContactRippleEffect)N(progress,modifier)40@1299L56,45@1529L260,41@1384L504,58@1911L1223,58@1894L1240:TicketTransferBeamEffect.kt#n9ob9m");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(f) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i5 = i2 & 2;
        if (i5 == 0) {
            if ((i & 48) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            i4 = i3;
            if ((i4 & 19) != 18) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
            } else {
                if (i5 != 0) {
                    modifier3 = Modifier.INSTANCE;
                } else {
                    modifier3 = modifier2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(2086450186, i4, -1, "com.example.tickets.TicketNfcContactRippleEffect (TicketTransferBeamEffect.kt:36)");
                }
                fCoerceIn = RangesKt.coerceIn(f, 0.0f, 1.0f);
                if (fCoerceIn <= 0.0f) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        return;
                    } else {
                        function2 = new Function2() { // from class: com.example.tickets.TicketTransferBeamEffectKt$$ExternalSyntheticLambda10
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return TicketTransferBeamEffectKt.TicketNfcContactRippleEffect$lambda$0(f, modifier3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        };
                    }
                } else {
                    InfiniteTransition infiniteTransitionRememberInfiniteTransition = InfiniteTransitionKt.rememberInfiniteTransition("nfc-contact-ripple", composerStartRestartGroup, 6, 0);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -671084594, "CC(remember):TicketTransferBeamEffect.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new Function1() { // from class: com.example.tickets.TicketTransferBeamEffectKt$$ExternalSyntheticLambda11
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return TicketTransferBeamEffectKt.TicketNfcContactRippleEffect$lambda$2$lambda$1((KeyframesSpec.KeyframesSpecConfig) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    stateAnimateFloat = InfiniteTransitionKt.animateFloat(infiniteTransitionRememberInfiniteTransition, 0.0f, 1.0f, AnimationSpecKt.m555infiniteRepeatable9IiC70o$default(AnimationSpecKt.keyframes((Function1) objRememberedValue), RepeatMode.Reverse, 0L, 4, null), "nfc-contact-breath", composerStartRestartGroup, InfiniteTransition.$stable | 25008 | (InfiniteRepeatableSpec.$stable << 9), 0);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -671071407, "CC(remember):TicketTransferBeamEffect.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(fCoerceIn) | composerStartRestartGroup.changed(stateAnimateFloat);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = new Function1() { // from class: com.example.tickets.TicketTransferBeamEffectKt$$ExternalSyntheticLambda12
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return TicketTransferBeamEffectKt.TicketNfcContactRippleEffect$lambda$5$lambda$4(fCoerceIn, stateAnimateFloat, (DrawScope) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    CanvasKt.Canvas(modifier3, (Function1) objRememberedValue2, composerStartRestartGroup, (i4 >> 3) & 14);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                scopeUpdateScopeEndRestartGroup.updateScope(function2);
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                function2 = new Function2() { // from class: com.example.tickets.TicketTransferBeamEffectKt$$ExternalSyntheticLambda13
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return TicketTransferBeamEffectKt.TicketNfcContactRippleEffect$lambda$6(f, modifier3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                };
                scopeUpdateScopeEndRestartGroup.updateScope(function2);
            }
        }
        i3 |= 48;
        modifier2 = modifier;
        i4 = i3;
        if ((i4 & 19) != 18) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
        } else {
            if (i5 != 0) {
                modifier3 = Modifier.INSTANCE;
            } else {
                modifier3 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2086450186, i4, -1, "com.example.tickets.TicketNfcContactRippleEffect (TicketTransferBeamEffect.kt:36)");
            }
            fCoerceIn = RangesKt.coerceIn(f, 0.0f, 1.0f);
            if (fCoerceIn <= 0.0f) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    return;
                } else {
                    function2 = new Function2() { // from class: com.example.tickets.TicketTransferBeamEffectKt$$ExternalSyntheticLambda10
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return TicketTransferBeamEffectKt.TicketNfcContactRippleEffect$lambda$0(f, modifier3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    };
                }
            } else {
                InfiniteTransition infiniteTransitionRememberInfiniteTransition2 = InfiniteTransitionKt.rememberInfiniteTransition("nfc-contact-ripple", composerStartRestartGroup, 6, 0);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -671084594, "CC(remember):TicketTransferBeamEffect.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function1() { // from class: com.example.tickets.TicketTransferBeamEffectKt$$ExternalSyntheticLambda11
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return TicketTransferBeamEffectKt.TicketNfcContactRippleEffect$lambda$2$lambda$1((KeyframesSpec.KeyframesSpecConfig) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                stateAnimateFloat = InfiniteTransitionKt.animateFloat(infiniteTransitionRememberInfiniteTransition2, 0.0f, 1.0f, AnimationSpecKt.m555infiniteRepeatable9IiC70o$default(AnimationSpecKt.keyframes((Function1) objRememberedValue), RepeatMode.Reverse, 0L, 4, null), "nfc-contact-breath", composerStartRestartGroup, InfiniteTransition.$stable | 25008 | (InfiniteRepeatableSpec.$stable << 9), 0);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -671071407, "CC(remember):TicketTransferBeamEffect.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(fCoerceIn) | composerStartRestartGroup.changed(stateAnimateFloat);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    objRememberedValue2 = new Function1() { // from class: com.example.tickets.TicketTransferBeamEffectKt$$ExternalSyntheticLambda12
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return TicketTransferBeamEffectKt.TicketNfcContactRippleEffect$lambda$5$lambda$4(fCoerceIn, stateAnimateFloat, (DrawScope) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = new Function1() { // from class: com.example.tickets.TicketTransferBeamEffectKt$$ExternalSyntheticLambda12
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return TicketTransferBeamEffectKt.TicketNfcContactRippleEffect$lambda$5$lambda$4(fCoerceIn, stateAnimateFloat, (DrawScope) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                CanvasKt.Canvas(modifier3, (Function1) objRememberedValue2, composerStartRestartGroup, (i4 >> 3) & 14);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            scopeUpdateScopeEndRestartGroup.updateScope(function2);
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            function2 = new Function2() { // from class: com.example.tickets.TicketTransferBeamEffectKt$$ExternalSyntheticLambda13
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TicketTransferBeamEffectKt.TicketNfcContactRippleEffect$lambda$6(f, modifier3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            };
            scopeUpdateScopeEndRestartGroup.updateScope(function2);
        }
    }

    static final Unit TicketNfcContactRippleEffect$lambda$2$lambda$1(KeyframesSpec.KeyframesSpecConfig keyframes) {
        Intrinsics.checkNotNullParameter(keyframes, "$this$keyframes");
        keyframes.setDurationMillis(1800);
        keyframes.at(Float.valueOf(0.0f), 0);
        keyframes.at(Float.valueOf(0.28f), 360);
        keyframes.at(Float.valueOf(0.58f), 980);
        keyframes.at(Float.valueOf(0.84f), 1450);
        keyframes.using(keyframes.at(Float.valueOf(1.0f), keyframes.getDurationMillis()), EasingKt.getFastOutSlowInEasing());
        return Unit.INSTANCE;
    }

    static final Unit TicketNfcContactRippleEffect$lambda$5$lambda$4(float f, State state, DrawScope Canvas) {
        int i;
        Intrinsics.checkNotNullParameter(Canvas, "$this$Canvas");
        float fIntBitsToFloat = Float.intBitsToFloat((int) (Canvas.mo6437getSizeNHjbRc() >> 32)) * 0.5f;
        float f2 = Canvas.mo803toPx0680j_4(Dp.m8748constructorimpl(86.0f));
        float fCoerceIn = RangesKt.coerceIn(1.0f - f, 0.0f, 1.0f);
        DrawScope.m6418drawCircleVaOC9Bg$default(Canvas, Color.m5837copywmQWz5c$default(Color.INSTANCE.m5875getWhite0d7_KjU(), fCoerceIn * 0.74f, 0.0f, 0.0f, 0.0f, 14, null), Canvas.mo803toPx0680j_4(Dp.m8748constructorimpl((3.0f * fCoerceIn) + 5.0f)), Offset.m5559constructorimpl((((long) Float.floatToRawIntBits(fIntBitsToFloat)) << 32) | (((long) Float.floatToRawIntBits(f2)) & 4294967295L)), 0.0f, null, null, 0, 120, null);
        int i2 = 0;
        while (i2 < 5) {
            float f3 = i2;
            float fCoerceIn2 = RangesKt.coerceIn((1.28f * f) - (0.16f * f3), 0.0f, 1.0f);
            if (fCoerceIn2 > 0.0f) {
                i = i2;
                DrawScope.m6418drawCircleVaOC9Bg$default(Canvas, Color.m5837copywmQWz5c$default(Color.INSTANCE.m5875getWhite0d7_KjU(), RangesKt.coerceAtLeast((1.0f - fCoerceIn2) * (0.34f - (0.055f * f3)), 0.0f), 0.0f, 0.0f, 0.0f, 14, null), Canvas.mo803toPx0680j_4(Dp.m8748constructorimpl((((17.0f * f3) + 34.0f) * fCoerceIn2) + 9.0f)), Offset.m5559constructorimpl((((long) Float.floatToRawIntBits(fIntBitsToFloat)) << 32) | (((long) Float.floatToRawIntBits(f2)) & 4294967295L)), 0.0f, new Stroke(Canvas.mo803toPx0680j_4(Dp.m8748constructorimpl(1.35f - (f3 * 0.12f))), 0.0f, 0, 0, null, 30, null), null, 0, LocationRequestCompat.QUALITY_LOW_POWER, null);
            } else {
                i = i2;
            }
            i2 = i + 1;
        }
        float f4 = Canvas.mo803toPx0680j_4(Dp.m8748constructorimpl((TicketNfcContactRippleEffect$lambda$3(state) * 20.0f) + 18.0f + (18.0f * fCoerceIn)));
        DrawScope.m6417drawCircleV9BoPsw$default(Canvas, Brush.Companion.m5765radialGradientP_VxKs$default(Brush.INSTANCE, CollectionsKt.listOf((Object[]) new Color[]{Color.m5828boximpl(Color.m5837copywmQWz5c$default(Color.INSTANCE.m5875getWhite0d7_KjU(), fCoerceIn * 0.18f, 0.0f, 0.0f, 0.0f, 14, null)), Color.m5828boximpl(Color.INSTANCE.m5873getTransparent0d7_KjU())}), 0L, f4, 0, 10, (Object) null), f4, Offset.m5559constructorimpl((((long) Float.floatToRawIntBits(fIntBitsToFloat)) << 32) | (((long) Float.floatToRawIntBits(f2)) & 4294967295L)), 0.0f, null, null, 0, 120, null);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:103:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:104:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:30:0x0067  */
    /* JADX WARN: Code duplicated, block: B:31:0x006a  */
    /* JADX WARN: Code duplicated, block: B:34:0x0073 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:35:0x0075  */
    /* JADX WARN: Code duplicated, block: B:36:0x007a  */
    /* JADX WARN: Code duplicated, block: B:39:0x0081  */
    /* JADX WARN: Code duplicated, block: B:91:0x0236  */
    /* JADX WARN: Code duplicated, block: B:94:0x023f  */
    /* JADX WARN: Code duplicated, block: B:96:0x024e  */
    /* JADX WARN: Code duplicated, block: B:99:0x0258  */
    public static final void TicketTransferBeamEffect(final TicketBeamMode mode, final float f, Modifier modifier, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        boolean z;
        final Modifier modifier3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier.Companion companion;
        final Modifier modifier4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup2;
        final RuntimeShader runtimeShaderM;
        Object objM9536constructorimpl;
        Intrinsics.checkNotNullParameter(mode, "mode");
        Composer composerStartRestartGroup = composer.startRestartGroup(-328298883);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(TicketTransferBeamEffect)N(mode,progress,modifier)117@3864L27,118@3917L624,118@3896L645,141@4682L52,146@4905L261,142@4760L508:TicketTransferBeamEffect.kt#n9ob9m");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(mode.ordinal()) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changed(f) ? 32 : 16;
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
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
            } else {
                if (i4 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-328298883, i3, -1, "com.example.tickets.TicketTransferBeamEffect (TicketTransferBeamEffect.kt:111)");
                }
                float fCoerceIn = RangesKt.coerceIn(f, 0.0f, 1.0f);
                if (mode != TicketBeamMode.NONE || fCoerceIn <= 0.001f) {
                    modifier4 = companion;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    scopeUpdateScopeEndRestartGroup2 = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup2 != null) {
                        scopeUpdateScopeEndRestartGroup2.updateScope(new Function2() { // from class: com.example.tickets.TicketTransferBeamEffectKt$$ExternalSyntheticLambda6
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return TicketTransferBeamEffectKt.TicketTransferBeamEffect$lambda$7(mode, f, modifier4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                        return;
                    }
                    return;
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1962601832, "CC(remember):TicketTransferBeamEffect.kt#9igjgp");
                Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = AnimatableKt.Animatable$default(0.0f, 0.0f, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                final Animatable animatable = (Animatable) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1962599539, "CC(remember):TicketTransferBeamEffect.kt#9igjgp");
                int i5 = i3 & 14;
                boolean zChangedInstance = (i5 == 4) | composerStartRestartGroup.changedInstance(animatable);
                TicketTransferBeamEffectKt$TicketTransferBeamEffect$2$1 ticketTransferBeamEffectKt$TicketTransferBeamEffect$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (zChangedInstance || ticketTransferBeamEffectKt$TicketTransferBeamEffect$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                    ticketTransferBeamEffectKt$TicketTransferBeamEffect$2$1RememberedValue = new TicketTransferBeamEffectKt$TicketTransferBeamEffect$2$1(mode, animatable, null);
                    composerStartRestartGroup.updateRememberedValue(ticketTransferBeamEffectKt$TicketTransferBeamEffect$2$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                EffectsKt.LaunchedEffect(mode, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) ticketTransferBeamEffectKt$TicketTransferBeamEffect$2$1RememberedValue, composerStartRestartGroup, i5);
                InfiniteTransition infiniteTransitionRememberInfiniteTransition = InfiniteTransitionKt.rememberInfiniteTransition("glass-transfer", composerStartRestartGroup, 6, 0);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1962568286, "CC(remember):TicketTransferBeamEffect.kt#9igjgp");
                Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = new Function1() { // from class: com.example.tickets.TicketTransferBeamEffectKt$$ExternalSyntheticLambda7
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return TicketTransferBeamEffectKt.TicketTransferBeamEffect$lambda$11$lambda$10((KeyframesSpec.KeyframesSpecConfig) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                final State<Float> stateAnimateFloat = InfiniteTransitionKt.animateFloat(infiniteTransitionRememberInfiniteTransition, 0.0f, 1.0f, AnimationSpecKt.m555infiniteRepeatable9IiC70o$default(AnimationSpecKt.keyframes((Function1) objRememberedValue2), RepeatMode.Restart, 0L, 4, null), "glass-material-breath", composerStartRestartGroup, InfiniteTransition.$stable | 25008 | (InfiniteRepeatableSpec.$stable << 9), 0);
                if (Build.VERSION.SDK_INT >= 33) {
                    composerStartRestartGroup.startReplaceGroup(-709509125);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "163@5490L90");
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1962549737, "CC(remember):TicketTransferBeamEffect.kt#9igjgp");
                    Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                        try {
                            Result.Companion companion2 = Result.INSTANCE;
                            MainActivity$$ExternalSyntheticApiModelOutline0.m9299m();
                            objM9536constructorimpl = Result.m9536constructorimpl(MainActivity$$ExternalSyntheticApiModelOutline0.m(TOP_GLASS_AGSL));
                        } catch (Throwable th) {
                            Result.Companion companion3 = Result.INSTANCE;
                            objM9536constructorimpl = Result.m9536constructorimpl(ResultKt.createFailure(th));
                        }
                        Object obj = objM9536constructorimpl;
                        if (Result.m9542isFailureimpl(obj)) {
                            obj = null;
                        }
                        objRememberedValue3 = MainActivity$$ExternalSyntheticApiModelOutline0.m(obj);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    runtimeShaderM = MainActivity$$ExternalSyntheticApiModelOutline0.m(objRememberedValue3);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(-709400687);
                    composerStartRestartGroup.endReplaceGroup();
                    runtimeShaderM = null;
                }
                if (runtimeShaderM != null) {
                    composerStartRestartGroup.startReplaceGroup(-709332580);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "171@5665L712,171@5648L729");
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1962543515, "CC(remember):TicketTransferBeamEffect.kt#9igjgp");
                    boolean zChangedInstance2 = composerStartRestartGroup.changedInstance(runtimeShaderM) | composerStartRestartGroup.changedInstance(animatable) | composerStartRestartGroup.changed(stateAnimateFloat) | (i5 == 4);
                    Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (zChangedInstance2 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue4 = new Function1() { // from class: com.example.tickets.TicketTransferBeamEffectKt$$ExternalSyntheticLambda8
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj2) {
                                return TicketTransferBeamEffectKt.TicketTransferBeamEffect$lambda$20$lambda$19(runtimeShaderM, animatable, mode, stateAnimateFloat, (DrawScope) obj2);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    CanvasKt.Canvas(companion, (Function1) objRememberedValue4, composerStartRestartGroup, (i3 >> 6) & 14);
                    composerStartRestartGroup.endReplaceGroup();
                    modifier3 = companion;
                } else {
                    composerStartRestartGroup.startReplaceGroup(-708608389);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "189@6399L58");
                    Modifier modifier5 = companion;
                    LegacyTopGlassFallback(mode, ((Number) animatable.getValue()).floatValue(), TicketTransferBeamEffect$lambda$12(stateAnimateFloat), modifier5, composerStartRestartGroup, i5 | ((i3 << 3) & 7168));
                    modifier3 = modifier5;
                    composerStartRestartGroup.endReplaceGroup();
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.tickets.TicketTransferBeamEffectKt$$ExternalSyntheticLambda9
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj2, Object obj3) {
                        return TicketTransferBeamEffectKt.TicketTransferBeamEffect$lambda$21(mode, f, modifier3, i, i2, (Composer) obj2, ((Integer) obj3).intValue());
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
            composerStartRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
        } else {
            if (i4 != 0) {
                companion = Modifier.INSTANCE;
            } else {
                companion = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-328298883, i3, -1, "com.example.tickets.TicketTransferBeamEffect (TicketTransferBeamEffect.kt:111)");
            }
            float fCoerceIn2 = RangesKt.coerceIn(f, 0.0f, 1.0f);
            if (mode != TicketBeamMode.NONE) {
            }
            modifier4 = companion;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            scopeUpdateScopeEndRestartGroup2 = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup2 != null) {
                scopeUpdateScopeEndRestartGroup2.updateScope(new Function2() { // from class: com.example.tickets.TicketTransferBeamEffectKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj2, Object obj3) {
                        return TicketTransferBeamEffectKt.TicketTransferBeamEffect$lambda$7(mode, f, modifier4, i, i2, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                });
                return;
            }
            return;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.tickets.TicketTransferBeamEffectKt$$ExternalSyntheticLambda9
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    return TicketTransferBeamEffectKt.TicketTransferBeamEffect$lambda$21(mode, f, modifier3, i, i2, (Composer) obj2, ((Integer) obj3).intValue());
                }
            });
        }
    }

    static final Unit TicketTransferBeamEffect$lambda$11$lambda$10(KeyframesSpec.KeyframesSpecConfig keyframes) {
        Intrinsics.checkNotNullParameter(keyframes, "$this$keyframes");
        keyframes.setDurationMillis(PathInterpolatorCompat.MAX_NUM_POINTS);
        keyframes.at(Float.valueOf(0.0f), 0);
        keyframes.at(Float.valueOf(0.25f), 750);
        keyframes.using(keyframes.at(Float.valueOf(0.55f), 1650), EasingKt.getFastOutSlowInEasing());
        keyframes.at(Float.valueOf(0.82f), 2380);
        keyframes.at(Float.valueOf(1.0f), keyframes.getDurationMillis());
        return Unit.INSTANCE;
    }

    private static final void LegacyTopGlassFallback(final TicketBeamMode ticketBeamMode, final float f, final float f2, final Modifier modifier, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1459449624);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(LegacyTopGlassFallback)N(mode,p,time,modifier)200@6620L2438,200@6603L2455:TicketTransferBeamEffect.kt#n9ob9m");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(ticketBeamMode.ordinal()) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(f) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changed(f2) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= composerStartRestartGroup.changed(modifier) ? 2048 : 1024;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 1171) != 1170, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1459449624, i2, -1, "com.example.tickets.LegacyTopGlassFallback (TicketTransferBeamEffect.kt:199)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1923224462, "CC(remember):TicketTransferBeamEffect.kt#9igjgp");
            boolean z = ((i2 & StylePropertiesKt.TextDirectionMask) == 32) | ((i2 & 896) == 256) | ((i2 & 14) == 4);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: com.example.tickets.TicketTransferBeamEffectKt$$ExternalSyntheticLambda14
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return TicketTransferBeamEffectKt.LegacyTopGlassFallback$lambda$23$lambda$22(f, f2, ticketBeamMode, (DrawScope) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            CanvasKt.Canvas(modifier, (Function1) objRememberedValue, composerStartRestartGroup, (i2 >> 9) & 14);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.tickets.TicketTransferBeamEffectKt$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TicketTransferBeamEffectKt.LegacyTopGlassFallback$lambda$24(ticketBeamMode, f, f2, modifier, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    static final Unit LegacyTopGlassFallback$lambda$23$lambda$22(float f, float f2, TicketBeamMode ticketBeamMode, DrawScope Canvas) {
        Intrinsics.checkNotNullParameter(Canvas, "$this$Canvas");
        float fIntBitsToFloat = Float.intBitsToFloat((int) (Canvas.mo6437getSizeNHjbRc() >> 32));
        Float.intBitsToFloat((int) (Canvas.mo6437getSizeNHjbRc() & 4294967295L));
        float f3 = fIntBitsToFloat * 0.5f;
        float f4 = Canvas.mo803toPx0680j_4(Dp.m8748constructorimpl(2.0f));
        float fEaseOutCubic = easeOutCubic(RangesKt.coerceIn(f / 0.34f, 0.0f, 1.0f));
        float fCoerceIn = RangesKt.coerceIn(1.0f - smoothStep(0.74f, 1.0f, f), 0.0f, 1.0f);
        float f5 = fIntBitsToFloat * ((1.38f * fEaseOutCubic) + 0.04f);
        float f6 = Canvas.mo803toPx0680j_4(Dp.m8748constructorimpl((118.0f * fEaseOutCubic) + 10.0f));
        DrawScope.m6424drawOvalAsUm42w$default(Canvas, Brush.Companion.m5765radialGradientP_VxKs$default(Brush.INSTANCE, CollectionsKt.listOf((Object[]) new Color[]{Color.m5828boximpl(Color.m5837copywmQWz5c$default(Color.INSTANCE.m5875getWhite0d7_KjU(), fCoerceIn * 0.1f, 0.0f, 0.0f, 0.0f, 14, null)), Color.m5828boximpl(Color.m5837copywmQWz5c$default(Color.INSTANCE.m5875getWhite0d7_KjU(), fCoerceIn * 0.055f, 0.0f, 0.0f, 0.0f, 14, null)), Color.m5828boximpl(Color.INSTANCE.m5873getTransparent0d7_KjU())}), Offset.m5559constructorimpl((((long) Float.floatToRawIntBits(f3)) << 32) | (((long) Float.floatToRawIntBits(f4 + (0.28f * f6))) & 4294967295L)), Math.max(Canvas.mo803toPx0680j_4(Dp.m8748constructorimpl(120.0f)), 0.68f * f5), 0, 8, (Object) null), Offset.m5559constructorimpl((((long) Float.floatToRawIntBits(f4 - (0.18f * f6))) & 4294967295L) | (((long) Float.floatToRawIntBits(f3 - (0.55f * f5))) << 32)), Size.m5627constructorimpl((((long) Float.floatToRawIntBits(1.75f * f6)) & 4294967295L) | (((long) Float.floatToRawIntBits(1.1f * f5)) << 32)), 0.0f, null, null, 0, 120, null);
        float f7 = f4 + (f6 * 0.34f);
        float f8 = Canvas.mo803toPx0680j_4(Dp.m8748constructorimpl((fEaseOutCubic * 18.0f) + 5.0f));
        double d = (float) (((double) f2) * 3.141592653589793d * 2.0d);
        float fSin = ((float) Math.sin(d)) * f5 * 0.12f;
        float f9 = fCoerceIn * 0.035f;
        float f10 = f5 * 0.5f;
        float f11 = f3 - f10;
        DrawScope.m6424drawOvalAsUm42w$default(Canvas, Brush.Companion.m5761horizontalGradient8A3gB4$default(Brush.INSTANCE, CollectionsKt.listOf((Object[]) new Color[]{Color.m5828boximpl(Color.INSTANCE.m5873getTransparent0d7_KjU()), Color.m5828boximpl(Color.m5837copywmQWz5c$default(Color.INSTANCE.m5875getWhite0d7_KjU(), fCoerceIn * 0.03f, 0.0f, 0.0f, 0.0f, 14, null)), Color.m5828boximpl(Color.m5837copywmQWz5c$default(Color.INSTANCE.m5875getWhite0d7_KjU(), fCoerceIn * 0.12f, 0.0f, 0.0f, 0.0f, 14, null)), Color.m5828boximpl(Color.m5837copywmQWz5c$default(Color.INSTANCE.m5875getWhite0d7_KjU(), f9, 0.0f, 0.0f, 0.0f, 14, null)), Color.m5828boximpl(Color.INSTANCE.m5873getTransparent0d7_KjU())}), f11 + fSin, f3 + f10 + fSin, 0, 8, (Object) null), Offset.m5559constructorimpl((((long) Float.floatToRawIntBits(f11)) << 32) | (((long) Float.floatToRawIntBits(f7 - (0.5f * f8))) & 4294967295L)), Size.m5627constructorimpl((((long) Float.floatToRawIntBits(f5)) << 32) | (((long) Float.floatToRawIntBits(f8)) & 4294967295L)), 0.0f, null, null, 0, 120, null);
        DrawScope.m6424drawOvalAsUm42w$default(Canvas, Brush.Companion.m5765radialGradientP_VxKs$default(Brush.INSTANCE, CollectionsKt.listOf((Object[]) new Color[]{Color.m5828boximpl(Color.m5837copywmQWz5c$default(Color.INSTANCE.m5875getWhite0d7_KjU(), fCoerceIn * 0.13f, 0.0f, 0.0f, 0.0f, 14, null)), Color.m5828boximpl(Color.m5837copywmQWz5c$default(Color.INSTANCE.m5875getWhite0d7_KjU(), f9, 0.0f, 0.0f, 0.0f, 14, null)), Color.m5828boximpl(Color.INSTANCE.m5873getTransparent0d7_KjU())}), 0L, Canvas.mo803toPx0680j_4(Dp.m8748constructorimpl(58.0f)), 0, 10, (Object) null), Offset.m5559constructorimpl((((long) Float.floatToRawIntBits((f3 + (((f5 * 0.34f) * ((float) Math.sin(d))) * (ticketBeamMode == TicketBeamMode.SEND ? 1.0f : -1.0f))) - Canvas.mo803toPx0680j_4(Dp.m8748constructorimpl(58.0f)))) << 32) | (((long) Float.floatToRawIntBits(f7 - Canvas.mo803toPx0680j_4(Dp.m8748constructorimpl(18.0f)))) & 4294967295L)), Size.m5627constructorimpl((((long) Float.floatToRawIntBits(Canvas.mo803toPx0680j_4(Dp.m8748constructorimpl(36.0f)))) & 4294967295L) | (((long) Float.floatToRawIntBits(Canvas.mo803toPx0680j_4(Dp.m8748constructorimpl(116.0f)))) << 32)), 0.0f, null, null, 0, 120, null);
        return Unit.INSTANCE;
    }

    private static final float easeOutCubic(float f) {
        float fCoerceIn = 1.0f - RangesKt.coerceIn(f, 0.0f, 1.0f);
        return 1.0f - ((fCoerceIn * fCoerceIn) * fCoerceIn);
    }

    private static final float smoothStep(float f, float f2, float f3) {
        float fCoerceIn = RangesKt.coerceIn((f3 - f) / (f2 - f), 0.0f, 1.0f);
        return fCoerceIn * fCoerceIn * (3.0f - (fCoerceIn * 2.0f));
    }

    private static final float TicketNfcContactRippleEffect$lambda$3(State<Float> state) {
        return state.getValue().floatValue();
    }

    private static final float TicketTransferBeamEffect$lambda$12(State<Float> state) {
        return state.getValue().floatValue();
    }

    static final Unit TicketTransferBeamEffect$lambda$20$lambda$19(RuntimeShader runtimeShader, Animatable animatable, TicketBeamMode ticketBeamMode, State state, DrawScope Canvas) {
        Object objM9536constructorimpl;
        Intrinsics.checkNotNullParameter(Canvas, "$this$Canvas");
        Canvas canvas = Canvas.getDrawContext().getCanvas();
        try {
            Result.Companion companion = Result.INSTANCE;
            runtimeShader.setFloatUniform("uResolution", Float.intBitsToFloat((int) (Canvas.mo6437getSizeNHjbRc() >> 32)), Float.intBitsToFloat((int) (Canvas.mo6437getSizeNHjbRc() & 4294967295L)));
            runtimeShader.setFloatUniform("uProgress", ((Number) animatable.getValue()).floatValue());
            runtimeShader.setFloatUniform("uTime", TicketTransferBeamEffect$lambda$12(state));
            runtimeShader.setFloatUniform("uDirection", ticketBeamMode == TicketBeamMode.SEND ? 1.0f : -1.0f);
            Paint Paint = AndroidPaint_androidKt.Paint();
            Paint.getInternalPaint().setShader(runtimeShader);
            canvas.drawRect(0.0f, 0.0f, Float.intBitsToFloat((int) (Canvas.mo6437getSizeNHjbRc() >> 32)), Float.intBitsToFloat((int) (Canvas.mo6437getSizeNHjbRc() & 4294967295L)), Paint);
            objM9536constructorimpl = Result.m9536constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM9536constructorimpl = Result.m9536constructorimpl(ResultKt.createFailure(th));
        }
        Result.m9539exceptionOrNullimpl(objM9536constructorimpl);
        return Unit.INSTANCE;
    }
}
