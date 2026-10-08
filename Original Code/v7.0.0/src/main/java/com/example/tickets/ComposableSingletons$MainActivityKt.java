package com.example.tickets;

import androidx.compose.animation.AnimatedContentScope;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MainActivity.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class ComposableSingletons$MainActivityKt {
    public static final ComposableSingletons$MainActivityKt INSTANCE = new ComposableSingletons$MainActivityKt();

    /* JADX INFO: renamed from: lambda$-1417816682, reason: not valid java name */
    private static Function3<LazyItemScope, Composer, Integer, Unit> f44lambda$1417816682 = ComposableLambdaKt.composableLambdaInstance(-1417816682, false, new Function3() { // from class: com.example.tickets.ComposableSingletons$MainActivityKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$MainActivityKt.lambda__1417816682$lambda$0((LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });
    private static Function4<AnimatedContentScope, Integer, Composer, Integer, Unit> lambda$670619167 = ComposableLambdaKt.composableLambdaInstance(670619167, false, new Function4() { // from class: com.example.tickets.ComposableSingletons$MainActivityKt$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function4
        public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
            return ComposableSingletons$MainActivityKt.lambda_670619167$lambda$1((AnimatedContentScope) obj, ((Integer) obj2).intValue(), (Composer) obj3, ((Integer) obj4).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-1954422579, reason: not valid java name */
    private static Function3<LazyItemScope, Composer, Integer, Unit> f45lambda$1954422579 = ComposableLambdaKt.composableLambdaInstance(-1954422579, false, new Function3() { // from class: com.example.tickets.ComposableSingletons$MainActivityKt$$ExternalSyntheticLambda2
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$MainActivityKt.lambda__1954422579$lambda$2((LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* JADX INFO: renamed from: getLambda$-1417816682$app, reason: not valid java name */
    public final Function3<LazyItemScope, Composer, Integer, Unit> m9289getLambda$1417816682$app() {
        return f44lambda$1417816682;
    }

    /* JADX INFO: renamed from: getLambda$-1954422579$app, reason: not valid java name */
    public final Function3<LazyItemScope, Composer, Integer, Unit> m9290getLambda$1954422579$app() {
        return f45lambda$1954422579;
    }

    public final Function4<AnimatedContentScope, Integer, Composer, Integer, Unit> getLambda$670619167$app() {
        return lambda$670619167;
    }

    static final Unit lambda__1417816682$lambda$0(LazyItemScope item, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation(composer, "C5245@170465L326:MainActivity.kt#n9ob9m");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1417816682, i, -1, "com.example.tickets.ComposableSingletons$MainActivityKt.lambda$-1417816682.<anonymous> (MainActivity.kt:5245)");
            }
            TextKt.m3661TextNvy7gAk("搜索结果", PaddingKt.m1424paddingVpY3zN4(Modifier.INSTANCE, Dp.m8748constructorimpl(18.0f), Dp.m8748constructorimpl(10.0f)), ColorKt.Color(4287532949L), null, TextUnitKt.getSp(12), null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer, 25014, 0, 262120);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    static final Unit lambda_670619167$lambda$1(AnimatedContentScope AnimatedContent, int i, Composer composer, int i2) {
        Intrinsics.checkNotNullParameter(AnimatedContent, "$this$AnimatedContent");
        ComposerKt.sourceInformation(composer, "CN(filter):MainActivity.kt#n9ob9m");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(670619167, i2, -1, "com.example.tickets.ComposableSingletons$MainActivityKt.lambda$670619167.<anonymous> (MainActivity.kt:6498)");
        }
        if (i == 0 || i == 1 || i == 2) {
            composer.startReplaceGroup(219932626);
            ComposerKt.sourceInformation(composer, "6505@209416L19");
            MainActivityKt.EmptyTicketsState(composer, 0);
            composer.endReplaceGroup();
        } else {
            composer.startReplaceGroup(219935474);
            ComposerKt.sourceInformation(composer, "6508@209505L19");
            MainActivityKt.EmptyTicketsState(composer, 0);
            composer.endReplaceGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    static final Unit lambda__1954422579$lambda$2(LazyItemScope item, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation(composer, "C6647@214684L178:MainActivity.kt#n9ob9m");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1954422579, i, -1, "com.example.tickets.ComposableSingletons$MainActivityKt.lambda$-1954422579.<anonymous> (MainActivity.kt:6647)");
            }
            SpacerKt.Spacer(SizeKt.m1476height3ABfNKs(Modifier.INSTANCE, Dp.m8748constructorimpl(180.0f)), composer, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
