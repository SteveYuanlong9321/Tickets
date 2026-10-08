package com.example.tickets;

import android.content.Context;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.style.StylePropertiesKt;
import androidx.compose.foundation.text.BasicTextFieldKt;
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.focus.FocusChangedModifierKt;
import androidx.compose.ui.focus.FocusState;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.text.PlatformTextStyle;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.text.style.TextMotion;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.profileinstaller.ProfileVerifier;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: GlobalSubwayData.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000F\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \u001aK\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00032\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\nH\u0007¢\u0006\u0002\u0010\u000b\u001a+\u0010\f\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00010\u0010H\u0003¢\u0006\u0002\u0010\u0011\u001a\u0015\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002¢\u0006\u0002\u0010\u0016¨\u0006\u0017²\u0006\n\u0010\u0018\u001a\u00020\u0019X\u008a\u008e\u0002²\u0006\n\u0010\u001a\u001a\u00020\u0019X\u008a\u008e\u0002²\u0006\u0010\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u000e0\u001cX\u008a\u008e\u0002"}, d2 = {"GlobalSubwayStationField", "", "cityId", "", "title", "value", "placeholder", "onValueChange", "Lkotlin/Function1;", "modifier", "Landroidx/compose/ui/Modifier;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "GlobalSubwayStationResultChip", "station", "Lcom/example/tickets/GlobalSubwayDataManager$SubwayStationOption;", "onClick", "Lkotlin/Function0;", "(Ljava/lang/String;Lcom/example/tickets/GlobalSubwayDataManager$SubwayStationOption;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "routeBadgeTextColor", "Landroidx/compose/ui/graphics/Color;", "color", "", "(I)J", "app", "focused", "", "loading", "results", ""}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class GlobalSubwayDataKt {
    static final Unit GlobalSubwayStationField$lambda$19(String str, String str2, String str3, String str4, Function1 function1, Modifier modifier, int i, int i2, Composer composer, int i3) {
        GlobalSubwayStationField(str, str2, str3, str4, function1, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    static final Unit GlobalSubwayStationResultChip$lambda$24(String str, GlobalSubwayDataManager.SubwayStationOption subwayStationOption, Function0 function0, int i, Composer composer, int i2) {
        GlobalSubwayStationResultChip(str, subwayStationOption, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:102:0x0414  */
    /* JADX WARN: Code duplicated, block: B:104:0x043e  */
    /* JADX WARN: Code duplicated, block: B:106:0x047f  */
    /* JADX WARN: Code duplicated, block: B:108:0x0489  */
    /* JADX WARN: Code duplicated, block: B:110:0x049e  */
    /* JADX WARN: Code duplicated, block: B:111:0x04a1  */
    /* JADX WARN: Code duplicated, block: B:113:0x04d5  */
    /* JADX WARN: Code duplicated, block: B:115:0x04fc  */
    /* JADX WARN: Code duplicated, block: B:116:0x04ff  */
    /* JADX WARN: Code duplicated, block: B:120:0x050b  */
    /* JADX WARN: Code duplicated, block: B:127:0x0521  */
    /* JADX WARN: Code duplicated, block: B:129:0x0548  */
    /* JADX WARN: Code duplicated, block: B:132:0x056b  */
    /* JADX WARN: Code duplicated, block: B:134:0x0571  */
    /* JADX WARN: Code duplicated, block: B:137:0x057c  */
    /* JADX WARN: Code duplicated, block: B:139:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:51:0x00ad  */
    /* JADX WARN: Code duplicated, block: B:52:0x00af  */
    /* JADX WARN: Code duplicated, block: B:55:0x00b8 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:56:0x00ba  */
    /* JADX WARN: Code duplicated, block: B:57:0x00c0  */
    /* JADX WARN: Code duplicated, block: B:60:0x00c7  */
    /* JADX WARN: Code duplicated, block: B:63:0x00f9  */
    /* JADX WARN: Code duplicated, block: B:66:0x011d  */
    /* JADX WARN: Code duplicated, block: B:69:0x013f  */
    /* JADX WARN: Code duplicated, block: B:72:0x0167  */
    /* JADX WARN: Code duplicated, block: B:73:0x016a  */
    /* JADX WARN: Code duplicated, block: B:76:0x0172  */
    /* JADX WARN: Code duplicated, block: B:77:0x0174  */
    /* JADX WARN: Code duplicated, block: B:84:0x018d  */
    /* JADX WARN: Code duplicated, block: B:87:0x01ee  */
    /* JADX WARN: Code duplicated, block: B:88:0x0206  */
    /* JADX WARN: Code duplicated, block: B:91:0x0274  */
    /* JADX WARN: Code duplicated, block: B:94:0x0280  */
    /* JADX WARN: Code duplicated, block: B:95:0x0284  */
    /* JADX WARN: Code duplicated, block: B:98:0x03ab  */
    /* JADX WARN: Code duplicated, block: B:99:0x03b6  */
    public static final void GlobalSubwayStationField(final String cityId, final String title, final String value, final String placeholder, Function1<? super String, Unit> onValueChange, Modifier modifier, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        boolean z;
        final Function1<? super String, Unit> function1;
        final Modifier modifier3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier modifier4;
        Context context;
        Object objRememberedValue;
        MutableState mutableState;
        Object objRememberedValue2;
        MutableState mutableState2;
        Object objRememberedValue3;
        MutableState mutableState3;
        int i5;
        boolean z2;
        boolean z3;
        boolean z4;
        String str;
        MutableState mutableState4;
        MutableState mutableState5;
        MutableState mutableState6;
        GlobalSubwayDataKt$GlobalSubwayStationField$1$1 globalSubwayDataKt$GlobalSubwayStationField$1$1;
        long jM5873getTransparent0d7_KjU;
        Function0<ComposeUiNode> constructor;
        MutableState mutableState7;
        final MutableState mutableState8;
        String str2;
        Object objRememberedValue4;
        final MutableState mutableState9;
        final MutableState mutableState10;
        boolean z5;
        boolean z6;
        boolean z7;
        Object objRememberedValue5;
        String str3;
        Intrinsics.checkNotNullParameter(cityId, "cityId");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(placeholder, "placeholder");
        Intrinsics.checkNotNullParameter(onValueChange, "onValueChange");
        Composer composerStartRestartGroup = composer.startRestartGroup(-2055449582);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(GlobalSubwayStationField)N(cityId,title,value,placeholder,onValueChange,modifier)4841@177900L7,4842@177927L34,4843@177981L34,4844@178035L103,4848@178183L380,4848@178144L419,4864@178569L2592:GlobalSubwayData.kt#n9ob9m");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(cityId) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changed(title) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changed(value) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i3 |= composerStartRestartGroup.changed(placeholder) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(onValueChange) ? 16384 : 8192;
        }
        int i6 = i2 & 32;
        if (i6 == 0) {
            if ((196608 & i) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 131072 : 65536;
            }
            i4 = i3;
            if ((74899 & i4) != 74898) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
                function1 = onValueChange;
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
            } else {
                if (i6 != 0) {
                    modifier4 = Modifier.INSTANCE;
                } else {
                    modifier4 = modifier2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-2055449582, i4, -1, "com.example.tickets.GlobalSubwayStationField (GlobalSubwayData.kt:4840)");
                }
                ProvidableCompositionLocal<Context> localContext = AndroidCompositionLocals_androidKt.getLocalContext();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume = composerStartRestartGroup.consume(localContext);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                context = (Context) objConsume;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 397916148, "CC(remember):GlobalSubwayData.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                mutableState = (MutableState) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 397917876, "CC(remember):GlobalSubwayData.kt#9igjgp");
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                mutableState2 = (MutableState) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 397919673, "CC(remember):GlobalSubwayData.kt#9igjgp");
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(CollectionsKt.emptyList(), null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                mutableState3 = (MutableState) objRememberedValue3;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Boolean boolValueOf = Boolean.valueOf(GlobalSubwayStationField$lambda$1(mutableState));
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 397924686, "CC(remember):GlobalSubwayData.kt#9igjgp");
                boolean zChangedInstance = composerStartRestartGroup.changedInstance(context);
                i5 = i4 & 14;
                if (i5 == 4) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                boolean z8 = zChangedInstance | z2;
                if ((i4 & 896) == 256) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                z4 = z8 | z3;
                Object objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                if (!z4 || objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                    str = "CC(remember):GlobalSubwayData.kt#9igjgp";
                    GlobalSubwayDataKt$GlobalSubwayStationField$1$1 globalSubwayDataKt$GlobalSubwayStationField$1$2 = new GlobalSubwayDataKt$GlobalSubwayStationField$1$1(context, cityId, value, mutableState, mutableState2, mutableState3, null);
                    mutableState4 = mutableState2;
                    mutableState5 = mutableState3;
                    mutableState6 = mutableState;
                    globalSubwayDataKt$GlobalSubwayStationField$1$1 = globalSubwayDataKt$GlobalSubwayStationField$1$2;
                    composerStartRestartGroup.updateRememberedValue(globalSubwayDataKt$GlobalSubwayStationField$1$1);
                } else {
                    globalSubwayDataKt$GlobalSubwayStationField$1$1 = objRememberedValue6;
                    mutableState4 = mutableState2;
                    mutableState5 = mutableState3;
                    mutableState6 = mutableState;
                    str = "CC(remember):GlobalSubwayData.kt#9igjgp";
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                int i7 = i4 >> 3;
                EffectsKt.LaunchedEffect(cityId, value, boolValueOf, (Function2) globalSubwayDataKt$GlobalSubwayStationField$1$1, composerStartRestartGroup, i5 | (i7 & StylePropertiesKt.TextDirectionMask));
                Modifier modifierM648backgroundbw27NRU$default = BackgroundKt.m648backgroundbw27NRU$default(ClipKt.clip(SizeKt.fillMaxWidth$default(modifier4, 0.0f, 1, null), RoundedCornerShapeKt.m1756RoundedCornerShape0680j_4(Dp.m8748constructorimpl(16.0f))), ColorKt.Color(4280558630L), null, 2, null);
                float fM8748constructorimpl = Dp.m8748constructorimpl(1.0f);
                if (GlobalSubwayStationField$lambda$1(mutableState6)) {
                    jM5873getTransparent0d7_KjU = Color.m5837copywmQWz5c$default(Color.INSTANCE.m5875getWhite0d7_KjU(), 0.14f, 0.0f, 0.0f, 0.0f, 14, null);
                } else {
                    jM5873getTransparent0d7_KjU = Color.INSTANCE.m5873getTransparent0d7_KjU();
                }
                Modifier modifierM1424paddingVpY3zN4 = PaddingKt.m1424paddingVpY3zN4(BorderKt.m659borderxT4_qwU(modifierM648backgroundbw27NRU$default, fM8748constructorimpl, jM5873getTransparent0d7_KjU, RoundedCornerShapeKt.m1756RoundedCornerShape0680j_4(Dp.m8748constructorimpl(16.0f))), Dp.m8748constructorimpl(12.0f), Dp.m8748constructorimpl(9.0f));
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
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1014239533, "C4876@179030L109,4881@179148L29,4891@179525L26,4892@179581L442,4883@179187L846:GlobalSubwayData.kt#n9ob9m");
                mutableState7 = mutableState6;
                mutableState8 = mutableState5;
                str2 = str;
                Modifier modifier5 = modifier4;
                TextKt.m3661TextNvy7gAk(title, null, ColorKt.Color(4287532691L), null, TextUnitKt.getSp(10), null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composerStartRestartGroup, (i7 & 14) | 24960, 0, 262122);
                SpacerKt.Spacer(SizeKt.m1476height3ABfNKs(Modifier.INSTANCE, Dp.m8748constructorimpl(3.0f)), composerStartRestartGroup, 6);
                TextStyle textStyle = new TextStyle(Color.INSTANCE.m5875getWhite0d7_KjU(), TextUnitKt.getSp(15), (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777212, (DefaultConstructorMarker) null);
                SolidColor solidColor = new SolidColor(Color.INSTANCE.m5875getWhite0d7_KjU(), null);
                Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 382939170, str2);
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                    mutableState9 = mutableState7;
                    objRememberedValue4 = new Function1() { // from class: com.example.tickets.GlobalSubwayDataKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return GlobalSubwayDataKt.GlobalSubwayStationField$lambda$18$lambda$11$lambda$10(mutableState9, (FocusState) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                } else {
                    mutableState9 = mutableState7;
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                mutableState10 = mutableState9;
                function1 = onValueChange;
                z5 = true;
                BasicTextFieldKt.BasicTextField(value, function1, FocusChangedModifierKt.onFocusChanged(modifierFillMaxWidth$default, (Function1) objRememberedValue4), false, false, textStyle, (KeyboardOptions) null, (KeyboardActions) null, true, 0, 0, (VisualTransformation) null, (Function1<? super TextLayoutResult, Unit>) null, (MutableInteractionSource) null, (Brush) solidColor, (Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit>) ComposableLambdaKt.rememberComposableLambda(2055523205, true, new Function3() { // from class: com.example.tickets.GlobalSubwayDataKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return GlobalSubwayDataKt.GlobalSubwayStationField$lambda$18$lambda$13(value, placeholder, (Function2) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i4 >> 6) & 14) | 100859904 | ((i4 >> 9) & StylePropertiesKt.TextDirectionMask), 221184, 16088);
                composerStartRestartGroup = composerStartRestartGroup;
                if (GlobalSubwayStationField$lambda$1(mutableState10)) {
                    composerStartRestartGroup.startReplaceGroup(-1191878214);
                } else {
                    composerStartRestartGroup.startReplaceGroup(-1013227601);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "4907@180070L29");
                    SpacerKt.Spacer(SizeKt.m1476height3ABfNKs(Modifier.INSTANCE, Dp.m8748constructorimpl(8.0f)), composerStartRestartGroup, 6);
                    if (GlobalSubwayStationField$lambda$4(mutableState4)) {
                        composerStartRestartGroup.startReplaceGroup(382960023);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "4909@180173L143");
                        TextKt.m3661TextNvy7gAk("正在搜索…", null, ColorKt.Color(4286019709L), null, TextUnitKt.getSp(12), null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composerStartRestartGroup, 24966, 0, 262122);
                        composerStartRestartGroup = composerStartRestartGroup;
                        composerStartRestartGroup.endReplaceGroup();
                    } else if (GlobalSubwayStationField$lambda$7(mutableState8).isEmpty()) {
                        composerStartRestartGroup.startReplaceGroup(382966753);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "4915@180382L185");
                        if (StringsKt.isBlank(value)) {
                            str3 = "输入站点名称开始搜索";
                        } else {
                            str3 = "没有找到匹配站点";
                        }
                        TextKt.m3661TextNvy7gAk(str3, null, ColorKt.Color(4286019709L), null, TextUnitKt.getSp(12), null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composerStartRestartGroup, 24960, 0, 262122);
                        composerStartRestartGroup = composerStartRestartGroup;
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(382973858);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "4923@180691L440,4921@180593L538");
                        Arrangement.HorizontalOrVertical horizontalOrVerticalM1115spacedBy0680j_4 = Arrangement.INSTANCE.m1115spacedBy0680j_4(Dp.m8748constructorimpl(6.0f));
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 382976896, str2);
                        if (i5 == 4) {
                            z6 = true;
                        } else {
                            z6 = false;
                        }
                        if ((i4 & 57344) != 16384) {
                            z5 = false;
                        }
                        z7 = z6 | z5;
                        objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                        if (!z7 || objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue5 = new Function1() { // from class: com.example.tickets.GlobalSubwayDataKt$$ExternalSyntheticLambda2
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return GlobalSubwayDataKt.GlobalSubwayStationField$lambda$18$lambda$17$lambda$16(mutableState8, cityId, function1, mutableState10, (LazyListScope) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        LazyDslKt.LazyRow(null, null, null, false, horizontalOrVerticalM1115spacedBy0680j_4, null, null, false, null, (Function1) objRememberedValue5, composerStartRestartGroup, 24576, 495);
                        composerStartRestartGroup.endReplaceGroup();
                    }
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
                modifier3 = modifier5;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                final Function1<? super String, Unit> function2 = function1;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.tickets.GlobalSubwayDataKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return GlobalSubwayDataKt.GlobalSubwayStationField$lambda$19(cityId, title, value, placeholder, function2, modifier3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        modifier2 = modifier;
        i4 = i3;
        if ((74899 & i4) != 74898) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
            function1 = onValueChange;
            composerStartRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
        } else {
            if (i6 != 0) {
                modifier4 = Modifier.INSTANCE;
            } else {
                modifier4 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2055449582, i4, -1, "com.example.tickets.GlobalSubwayStationField (GlobalSubwayData.kt:4840)");
            }
            ProvidableCompositionLocal<Context> localContext2 = AndroidCompositionLocals_androidKt.getLocalContext();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume2 = composerStartRestartGroup.consume(localContext2);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            context = (Context) objConsume2;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 397916148, "CC(remember):GlobalSubwayData.kt#9igjgp");
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            mutableState = (MutableState) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 397917876, "CC(remember):GlobalSubwayData.kt#9igjgp");
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            mutableState2 = (MutableState) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 397919673, "CC(remember):GlobalSubwayData.kt#9igjgp");
            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(CollectionsKt.emptyList(), null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            mutableState3 = (MutableState) objRememberedValue3;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Boolean boolValueOf2 = Boolean.valueOf(GlobalSubwayStationField$lambda$1(mutableState));
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 397924686, "CC(remember):GlobalSubwayData.kt#9igjgp");
            boolean zChangedInstance2 = composerStartRestartGroup.changedInstance(context);
            i5 = i4 & 14;
            if (i5 == 4) {
                z2 = true;
            } else {
                z2 = false;
            }
            boolean z9 = zChangedInstance2 | z2;
            if ((i4 & 896) == 256) {
                z3 = true;
            } else {
                z3 = false;
            }
            z4 = z9 | z3;
            Object objRememberedValue7 = composerStartRestartGroup.rememberedValue();
            if (!z4) {
                str = "CC(remember):GlobalSubwayData.kt#9igjgp";
                GlobalSubwayDataKt$GlobalSubwayStationField$1$1 globalSubwayDataKt$GlobalSubwayStationField$1$3 = new GlobalSubwayDataKt$GlobalSubwayStationField$1$1(context, cityId, value, mutableState, mutableState2, mutableState3, null);
                mutableState4 = mutableState2;
                mutableState5 = mutableState3;
                mutableState6 = mutableState;
                globalSubwayDataKt$GlobalSubwayStationField$1$1 = globalSubwayDataKt$GlobalSubwayStationField$1$3;
                composerStartRestartGroup.updateRememberedValue(globalSubwayDataKt$GlobalSubwayStationField$1$1);
            } else {
                str = "CC(remember):GlobalSubwayData.kt#9igjgp";
                GlobalSubwayDataKt$GlobalSubwayStationField$1$1 globalSubwayDataKt$GlobalSubwayStationField$1$4 = new GlobalSubwayDataKt$GlobalSubwayStationField$1$1(context, cityId, value, mutableState, mutableState2, mutableState3, null);
                mutableState4 = mutableState2;
                mutableState5 = mutableState3;
                mutableState6 = mutableState;
                globalSubwayDataKt$GlobalSubwayStationField$1$1 = globalSubwayDataKt$GlobalSubwayStationField$1$4;
                composerStartRestartGroup.updateRememberedValue(globalSubwayDataKt$GlobalSubwayStationField$1$1);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            int i8 = i4 >> 3;
            EffectsKt.LaunchedEffect(cityId, value, boolValueOf2, (Function2) globalSubwayDataKt$GlobalSubwayStationField$1$1, composerStartRestartGroup, i5 | (i8 & StylePropertiesKt.TextDirectionMask));
            Modifier modifierM648backgroundbw27NRU$default2 = BackgroundKt.m648backgroundbw27NRU$default(ClipKt.clip(SizeKt.fillMaxWidth$default(modifier4, 0.0f, 1, null), RoundedCornerShapeKt.m1756RoundedCornerShape0680j_4(Dp.m8748constructorimpl(16.0f))), ColorKt.Color(4280558630L), null, 2, null);
            float fM8748constructorimpl2 = Dp.m8748constructorimpl(1.0f);
            if (GlobalSubwayStationField$lambda$1(mutableState6)) {
                jM5873getTransparent0d7_KjU = Color.m5837copywmQWz5c$default(Color.INSTANCE.m5875getWhite0d7_KjU(), 0.14f, 0.0f, 0.0f, 0.0f, 14, null);
            } else {
                jM5873getTransparent0d7_KjU = Color.INSTANCE.m5873getTransparent0d7_KjU();
            }
            Modifier modifierM1424paddingVpY3zN5 = PaddingKt.m1424paddingVpY3zN4(BorderKt.m659borderxT4_qwU(modifierM648backgroundbw27NRU$default2, fM8748constructorimpl2, jM5873getTransparent0d7_KjU, RoundedCornerShapeKt.m1756RoundedCornerShape0680j_4(Dp.m8748constructorimpl(16.0f))), Dp.m8748constructorimpl(12.0f), Dp.m8748constructorimpl(9.0f));
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
            int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1424paddingVpY3zN5);
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
            Updater.m4945setimpl(composerM4937constructorimpl2, measurePolicyColumnMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m4945setimpl(composerM4937constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m4945setimpl(composerM4937constructorimpl2, Integer.valueOf(iHashCode2), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m4943reconcileimpl(composerM4937constructorimpl2, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m4945setimpl(composerM4937constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1014239533, "C4876@179030L109,4881@179148L29,4891@179525L26,4892@179581L442,4883@179187L846:GlobalSubwayData.kt#n9ob9m");
            mutableState7 = mutableState6;
            mutableState8 = mutableState5;
            str2 = str;
            Modifier modifier6 = modifier4;
            TextKt.m3661TextNvy7gAk(title, null, ColorKt.Color(4287532691L), null, TextUnitKt.getSp(10), null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composerStartRestartGroup, (i8 & 14) | 24960, 0, 262122);
            SpacerKt.Spacer(SizeKt.m1476height3ABfNKs(Modifier.INSTANCE, Dp.m8748constructorimpl(3.0f)), composerStartRestartGroup, 6);
            TextStyle textStyle2 = new TextStyle(Color.INSTANCE.m5875getWhite0d7_KjU(), TextUnitKt.getSp(15), (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777212, (DefaultConstructorMarker) null);
            SolidColor solidColor2 = new SolidColor(Color.INSTANCE.m5875getWhite0d7_KjU(), null);
            Modifier modifierFillMaxWidth$default2 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 382939170, str2);
            objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                mutableState9 = mutableState7;
                objRememberedValue4 = new Function1() { // from class: com.example.tickets.GlobalSubwayDataKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return GlobalSubwayDataKt.GlobalSubwayStationField$lambda$18$lambda$11$lambda$10(mutableState9, (FocusState) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            } else {
                mutableState9 = mutableState7;
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            mutableState10 = mutableState9;
            function1 = onValueChange;
            z5 = true;
            BasicTextFieldKt.BasicTextField(value, function1, FocusChangedModifierKt.onFocusChanged(modifierFillMaxWidth$default2, (Function1) objRememberedValue4), false, false, textStyle2, (KeyboardOptions) null, (KeyboardActions) null, true, 0, 0, (VisualTransformation) null, (Function1<? super TextLayoutResult, Unit>) null, (MutableInteractionSource) null, (Brush) solidColor2, (Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit>) ComposableLambdaKt.rememberComposableLambda(2055523205, true, new Function3() { // from class: com.example.tickets.GlobalSubwayDataKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return GlobalSubwayDataKt.GlobalSubwayStationField$lambda$18$lambda$13(value, placeholder, (Function2) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i4 >> 6) & 14) | 100859904 | ((i4 >> 9) & StylePropertiesKt.TextDirectionMask), 221184, 16088);
            composerStartRestartGroup = composerStartRestartGroup;
            if (GlobalSubwayStationField$lambda$1(mutableState10)) {
                composerStartRestartGroup.startReplaceGroup(-1191878214);
            } else {
                composerStartRestartGroup.startReplaceGroup(-1013227601);
                ComposerKt.sourceInformation(composerStartRestartGroup, "4907@180070L29");
                SpacerKt.Spacer(SizeKt.m1476height3ABfNKs(Modifier.INSTANCE, Dp.m8748constructorimpl(8.0f)), composerStartRestartGroup, 6);
                if (GlobalSubwayStationField$lambda$4(mutableState4)) {
                    composerStartRestartGroup.startReplaceGroup(382960023);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "4909@180173L143");
                    TextKt.m3661TextNvy7gAk("正在搜索…", null, ColorKt.Color(4286019709L), null, TextUnitKt.getSp(12), null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composerStartRestartGroup, 24966, 0, 262122);
                    composerStartRestartGroup = composerStartRestartGroup;
                    composerStartRestartGroup.endReplaceGroup();
                } else if (GlobalSubwayStationField$lambda$7(mutableState8).isEmpty()) {
                    composerStartRestartGroup.startReplaceGroup(382966753);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "4915@180382L185");
                    if (StringsKt.isBlank(value)) {
                        str3 = "输入站点名称开始搜索";
                    } else {
                        str3 = "没有找到匹配站点";
                    }
                    TextKt.m3661TextNvy7gAk(str3, null, ColorKt.Color(4286019709L), null, TextUnitKt.getSp(12), null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composerStartRestartGroup, 24960, 0, 262122);
                    composerStartRestartGroup = composerStartRestartGroup;
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(382973858);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "4923@180691L440,4921@180593L538");
                    Arrangement.HorizontalOrVertical horizontalOrVerticalM1115spacedBy0680j_5 = Arrangement.INSTANCE.m1115spacedBy0680j_4(Dp.m8748constructorimpl(6.0f));
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 382976896, str2);
                    if (i5 == 4) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    if ((i4 & 57344) != 16384) {
                        z5 = false;
                    }
                    z7 = z6 | z5;
                    objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                    if (!z7) {
                        objRememberedValue5 = new Function1() { // from class: com.example.tickets.GlobalSubwayDataKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return GlobalSubwayDataKt.GlobalSubwayStationField$lambda$18$lambda$17$lambda$16(mutableState8, cityId, function1, mutableState10, (LazyListScope) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                    } else {
                        objRememberedValue5 = new Function1() { // from class: com.example.tickets.GlobalSubwayDataKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return GlobalSubwayDataKt.GlobalSubwayStationField$lambda$18$lambda$17$lambda$16(mutableState8, cityId, function1, mutableState10, (LazyListScope) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    LazyDslKt.LazyRow(null, null, null, false, horizontalOrVerticalM1115spacedBy0680j_5, null, null, false, null, (Function1) objRememberedValue5, composerStartRestartGroup, 24576, 495);
                    composerStartRestartGroup.endReplaceGroup();
                }
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
            modifier3 = modifier6;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Function1 function3 = function1;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.tickets.GlobalSubwayDataKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return GlobalSubwayDataKt.GlobalSubwayStationField$lambda$19(cityId, title, value, placeholder, function3, modifier3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean GlobalSubwayStationField$lambda$1(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void GlobalSubwayStationField$lambda$2(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final boolean GlobalSubwayStationField$lambda$4(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void GlobalSubwayStationField$lambda$5(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final List<GlobalSubwayDataManager.SubwayStationOption> GlobalSubwayStationField$lambda$7(MutableState<List<GlobalSubwayDataManager.SubwayStationOption>> mutableState) {
        return mutableState.getValue();
    }

    static final Unit GlobalSubwayStationField$lambda$18$lambda$11$lambda$10(MutableState mutableState, FocusState it) {
        Intrinsics.checkNotNullParameter(it, "it");
        GlobalSubwayStationField$lambda$2(mutableState, it.isFocused());
        return Unit.INSTANCE;
    }

    static final Unit GlobalSubwayStationField$lambda$18$lambda$13(String str, String str2, Function2 innerTextField, Composer composer, int i) {
        int i2;
        int i3;
        Composer composer2 = composer;
        Intrinsics.checkNotNullParameter(innerTextField, "innerTextField");
        ComposerKt.sourceInformation(composer2, "CN(innerTextField)4893@179617L392:GlobalSubwayData.kt#n9ob9m");
        if ((i & 6) == 0) {
            i2 = i | (composer2.changedInstance(innerTextField) ? 4 : 2);
        } else {
            i2 = i;
        }
        if (!composer2.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2055523205, i2, -1, "com.example.tickets.GlobalSubwayStationField.<anonymous>.<anonymous> (GlobalSubwayData.kt:4893)");
            }
            Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
            ComposerKt.sourceInformationMarkerStart(composer2, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composer2, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer2, 0));
            CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer2, modifierFillMaxWidth$default);
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
            Updater.m4945setimpl(composerM4937constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m4945setimpl(composerM4937constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m4945setimpl(composerM4937constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m4943reconcileimpl(composerM4937constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m4945setimpl(composerM4937constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer2, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer2, 1163287200, "C4901@179975L16:GlobalSubwayData.kt#n9ob9m");
            if (!StringsKt.isBlank(str)) {
                i3 = i2;
                composer2.startReplaceGroup(985034967);
            } else {
                composer2.startReplaceGroup(1163306233);
                ComposerKt.sourceInformation(composer2, "4895@179753L179");
                i3 = i2;
                TextKt.m3661TextNvy7gAk(str2, null, ColorKt.Color(4284901228L), null, TextUnitKt.getSp(15), null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer2, 24960, 0, 262122);
                composer2 = composer2;
            }
            composer2.endReplaceGroup();
            innerTextField.invoke(composer2, Integer.valueOf(i3 & 14));
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

    static final Unit GlobalSubwayStationField$lambda$18$lambda$17$lambda$16(MutableState mutableState, final String str, final Function1 function1, final MutableState mutableState2, LazyListScope LazyRow) {
        Intrinsics.checkNotNullParameter(LazyRow, "$this$LazyRow");
        final List<GlobalSubwayDataManager.SubwayStationOption> listGlobalSubwayStationField$lambda$7 = GlobalSubwayStationField$lambda$7(mutableState);
        final GlobalSubwayDataKt$GlobalSubwayStationField$lambda$18$lambda$17$lambda$16$$inlined$items$default$1 globalSubwayDataKt$GlobalSubwayStationField$lambda$18$lambda$17$lambda$16$$inlined$items$default$1 = new Function1() { // from class: com.example.tickets.GlobalSubwayDataKt$GlobalSubwayStationField$lambda$18$lambda$17$lambda$16$$inlined$items$default$1
            @Override // kotlin.jvm.functions.Function1
            public final Void invoke(GlobalSubwayDataManager.SubwayStationOption subwayStationOption) {
                return null;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return invoke((GlobalSubwayDataManager.SubwayStationOption) obj);
            }
        };
        LazyRow.items(listGlobalSubwayStationField$lambda$7.size(), null, new Function1<Integer, Object>() { // from class: com.example.tickets.GlobalSubwayDataKt$GlobalSubwayStationField$lambda$18$lambda$17$lambda$16$$inlined$items$default$3
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final Object invoke(int i) {
                return globalSubwayDataKt$GlobalSubwayStationField$lambda$18$lambda$17$lambda$16$$inlined$items$default$1.invoke(listGlobalSubwayStationField$lambda$7.get(i));
            }
        }, ComposableLambdaKt.composableLambdaInstance(802480018, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: com.example.tickets.GlobalSubwayDataKt$GlobalSubwayStationField$lambda$18$lambda$17$lambda$16$$inlined$items$default$4
            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Integer num, Composer composer, Integer num2) {
                invoke(lazyItemScope, num.intValue(), composer, num2.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(LazyItemScope lazyItemScope, int i, Composer composer, int i2) {
                int i3;
                ComposerKt.sourceInformation(composer, "CN(it)178@8834L22:LazyDsl.kt#428nma");
                if ((i2 & 6) == 0) {
                    i3 = (composer.changed(lazyItemScope) ? 4 : 2) | i2;
                } else {
                    i3 = i2;
                }
                if ((i2 & 48) == 0) {
                    i3 |= composer.changed(i) ? 32 : 16;
                }
                if (!composer.shouldExecute((i3 & 147) != 146, i3 & 1)) {
                    composer.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(802480018, i3, -1, "androidx.compose.foundation.lazy.items.<anonymous> (LazyDsl.kt:178)");
                }
                final GlobalSubwayDataManager.SubwayStationOption subwayStationOption = (GlobalSubwayDataManager.SubwayStationOption) listGlobalSubwayStationField$lambda$7.get(i);
                composer.startReplaceGroup(131522960);
                ComposerKt.sourceInformation(composer, "CN(station)*4928@180926L139,4925@180765L326:GlobalSubwayData.kt#n9ob9m");
                String str2 = str;
                ComposerKt.sourceInformationMarkerStart(composer, -1104131016, "CC(remember):GlobalSubwayData.kt#9igjgp");
                boolean zChanged = composer.changed(function1) | composer.changedInstance(subwayStationOption);
                Object objRememberedValue = composer.rememberedValue();
                if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    final Function1 function2 = function1;
                    final MutableState mutableState3 = mutableState2;
                    objRememberedValue = (Function0) new Function0<Unit>() { // from class: com.example.tickets.GlobalSubwayDataKt$GlobalSubwayStationField$2$3$1$1$1$1
                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            function2.invoke(subwayStationOption.getName());
                            GlobalSubwayDataKt.GlobalSubwayStationField$lambda$2(mutableState3, false);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                GlobalSubwayDataKt.GlobalSubwayStationResultChip(str2, subwayStationOption, (Function0) objRememberedValue, composer, 0);
                composer.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void GlobalSubwayStationResultChip(final String str, final GlobalSubwayDataManager.SubwayStationOption subwayStationOption, final Function0<Unit> function0, Composer composer, final int i) {
        Composer composer2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-715461124);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(GlobalSubwayStationResultChip)N(cityId,station,onClick)4946@181330L1600:GlobalSubwayData.kt#n9ob9m");
        int i2 = (i & 6) == 0 ? (composerStartRestartGroup.changed(str) ? 4 : 2) | i : i;
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(subwayStationOption) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function0) ? 256 : 128;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 147) != 146, i2 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-715461124, i2, -1, "com.example.tickets.GlobalSubwayStationResultChip (GlobalSubwayData.kt:4945)");
            }
            Modifier modifierM1424paddingVpY3zN4 = PaddingKt.m1424paddingVpY3zN4(ClickableKt.m683clickableoSLSa3U$default(BackgroundKt.m648backgroundbw27NRU$default(ClipKt.clip(SizeKt.m1495width3ABfNKs(Modifier.INSTANCE, Dp.m8748constructorimpl(180.0f)), RoundedCornerShapeKt.m1756RoundedCornerShape0680j_4(Dp.m8748constructorimpl(14.0f))), Color.m5837copywmQWz5c$default(Color.INSTANCE.m5875getWhite0d7_KjU(), 0.05f, 0.0f, 0.0f, 0.0f, 14, null), null, 2, null), false, null, null, null, function0, 15, null), Dp.m8748constructorimpl(10.0f), Dp.m8748constructorimpl(8.0f));
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
            int i3 = -1159599143;
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 948307772, "C4954@181638L180,4961@181827L29,4962@181865L1059:GlobalSubwayData.kt#n9ob9m");
            int i4 = -553112988;
            TextKt.m3661TextNvy7gAk(subwayStationOption.getName(), null, Color.INSTANCE.m5875getWhite0d7_KjU(), null, TextUnitKt.getSp(13), null, FontWeight.INSTANCE.getMedium(), null, 0L, null, null, 0L, 0, false, 2, 0, null, null, composerStartRestartGroup, 1597824, 24576, 245674);
            SpacerKt.Spacer(SizeKt.m1476height3ABfNKs(Modifier.INSTANCE, Dp.m8748constructorimpl(5.0f)), composerStartRestartGroup, 6);
            Arrangement.HorizontalOrVertical horizontalOrVerticalM1115spacedBy0680j_4 = Arrangement.INSTANCE.m1115spacedBy0680j_4(Dp.m8748constructorimpl(4.0f));
            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Modifier.Companion companion = Modifier.INSTANCE;
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(horizontalOrVerticalM1115spacedBy0680j_4, centerVertically, composerStartRestartGroup, 54);
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -935110720, "C:GlobalSubwayData.kt#n9ob9m");
            composerStartRestartGroup.startReplaceGroup(1078214508);
            ComposerKt.sourceInformation(composerStartRestartGroup, "*4967@182075L825");
            for (GlobalSubwayDataManager.SubwayRouteInfo subwayRouteInfo : CollectionsKt.take(subwayStationOption.getRoutes(), 8)) {
                Modifier modifierM648backgroundbw27NRU$default = BackgroundKt.m648backgroundbw27NRU$default(ClipKt.clip(SizeKt.m1490size3ABfNKs(Modifier.INSTANCE, Dp.m8748constructorimpl(22.0f)), RoundedCornerShapeKt.m1756RoundedCornerShape0680j_4(Dp.m8748constructorimpl(7.0f))), ColorKt.Color(subwayRouteInfo.getColor()), null, 2, null);
                Alignment center = Alignment.INSTANCE.getCenter();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, i3, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
                int iHashCode3 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM648backgroundbw27NRU$default);
                Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, i4, "CC(ReusableComposeNode)N(factory,update,content)410@16216L9:Composables.kt#9igjgp");
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
                Updater.m4945setimpl(composerM4937constructorimpl3, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m4945setimpl(composerM4937constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Updater.m4945setimpl(composerM4937constructorimpl3, Integer.valueOf(iHashCode3), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                Updater.m4943reconcileimpl(composerM4937constructorimpl3, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                Updater.m4945setimpl(composerM4937constructorimpl3, modifierMaterializeModifier3, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1810978124, "C4974@182393L489:GlobalSubwayData.kt#n9ob9m");
                TextKt.m3661TextNvy7gAk(GlobalSubwayDataManager.INSTANCE.displayLineBadgeName$app(str, subwayRouteInfo.getShortName(), subwayRouteInfo.getRouteId()), null, routeBadgeTextColor(subwayRouteInfo.getColor()), null, TextUnitKt.getSp(subwayRouteInfo.getShortName().length() <= 1 ? 10 : 7), null, FontWeight.INSTANCE.getBold(), null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composerStartRestartGroup, 1572864, 0, 262058);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                i4 = -553112988;
                i3 = -1159599143;
            }
            composer2 = composerStartRestartGroup;
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.tickets.GlobalSubwayDataKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return GlobalSubwayDataKt.GlobalSubwayStationResultChip$lambda$24(str, subwayStationOption, function0, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final long routeBadgeTextColor(int i) {
        return (((((double) ((i >> 16) & 255)) * 0.299d) + (((double) ((i >> 8) & 255)) * 0.587d)) + (((double) (i & 255)) * 0.114d)) / 255.0d > 0.62d ? Color.INSTANCE.m5864getBlack0d7_KjU() : Color.INSTANCE.m5875getWhite0d7_KjU();
    }
}
