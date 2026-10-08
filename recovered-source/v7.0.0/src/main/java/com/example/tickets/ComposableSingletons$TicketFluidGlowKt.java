package com.example.tickets;

import androidx.compose.foundation.layout.RowScope;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TicketFluidGlow.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class ComposableSingletons$TicketFluidGlowKt {
    public static final ComposableSingletons$TicketFluidGlowKt INSTANCE = new ComposableSingletons$TicketFluidGlowKt();
    private static Function2<Composer, Integer, Unit> lambda$1712105811 = ComposableLambdaKt.composableLambdaInstance(1712105811, false, new Function2() { // from class: com.example.tickets.ComposableSingletons$TicketFluidGlowKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$TicketFluidGlowKt.lambda_1712105811$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-1372975506, reason: not valid java name */
    private static Function3<RowScope, Composer, Integer, Unit> f47lambda$1372975506 = ComposableLambdaKt.composableLambdaInstance(-1372975506, false, new Function3() { // from class: com.example.tickets.ComposableSingletons$TicketFluidGlowKt$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$TicketFluidGlowKt.lambda__1372975506$lambda$1((RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });
    private static Function3<RowScope, Composer, Integer, Unit> lambda$704994213 = ComposableLambdaKt.composableLambdaInstance(704994213, false, new Function3() { // from class: com.example.tickets.ComposableSingletons$TicketFluidGlowKt$$ExternalSyntheticLambda2
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$TicketFluidGlowKt.lambda_704994213$lambda$2((RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });
    private static Function3<RowScope, Composer, Integer, Unit> lambda$1959776230 = ComposableLambdaKt.composableLambdaInstance(1959776230, false, new Function3() { // from class: com.example.tickets.ComposableSingletons$TicketFluidGlowKt$$ExternalSyntheticLambda3
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$TicketFluidGlowKt.lambda_1959776230$lambda$3((RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-1080409049, reason: not valid java name */
    private static Function3<RowScope, Composer, Integer, Unit> f46lambda$1080409049 = ComposableLambdaKt.composableLambdaInstance(-1080409049, false, new Function3() { // from class: com.example.tickets.ComposableSingletons$TicketFluidGlowKt$$ExternalSyntheticLambda4
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$TicketFluidGlowKt.lambda__1080409049$lambda$4((RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* JADX INFO: renamed from: getLambda$-1080409049$app, reason: not valid java name */
    public final Function3<RowScope, Composer, Integer, Unit> m9291getLambda$1080409049$app() {
        return f46lambda$1080409049;
    }

    /* JADX INFO: renamed from: getLambda$-1372975506$app, reason: not valid java name */
    public final Function3<RowScope, Composer, Integer, Unit> m9292getLambda$1372975506$app() {
        return f47lambda$1372975506;
    }

    public final Function2<Composer, Integer, Unit> getLambda$1712105811$app() {
        return lambda$1712105811;
    }

    public final Function3<RowScope, Composer, Integer, Unit> getLambda$1959776230$app() {
        return lambda$1959776230;
    }

    public final Function3<RowScope, Composer, Integer, Unit> getLambda$704994213$app() {
        return lambda$704994213;
    }

    static final Unit lambda_1712105811$lambda$0(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C378@11277L35:TicketFluidGlow.kt#n9ob9m");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1712105811, i, -1, "com.example.tickets.ComposableSingletons$TicketFluidGlowKt.lambda$1712105811.<anonymous> (TicketFluidGlow.kt:378)");
            }
            TicketFluidGlowKt.TicketFluidGlowPreviewDemoContent(composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    static final Unit lambda__1372975506$lambda$1(RowScope Button, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(Button, "$this$Button");
        ComposerKt.sourceInformation(composer, "C428@12616L10:TicketFluidGlow.kt#n9ob9m");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1372975506, i, -1, "com.example.tickets.ComposableSingletons$TicketFluidGlowKt.lambda$-1372975506.<anonymous> (TicketFluidGlow.kt:428)");
            }
            TextKt.m3661TextNvy7gAk("正常", null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer, 6, 0, 262142);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    static final Unit lambda_704994213$lambda$2(RowScope Button, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(Button, "$this$Button");
        ComposerKt.sourceInformation(composer, "C435@12809L10:TicketFluidGlow.kt#n9ob9m");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(704994213, i, -1, "com.example.tickets.ComposableSingletons$TicketFluidGlowKt.lambda$704994213.<anonymous> (TicketFluidGlow.kt:435)");
            }
            TextKt.m3661TextNvy7gAk("接近", null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer, 6, 0, 262142);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    static final Unit lambda_1959776230$lambda$3(RowScope Button, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(Button, "$this$Button");
        ComposerKt.sourceInformation(composer, "C442@13001L11:TicketFluidGlow.kt#n9ob9m");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1959776230, i, -1, "com.example.tickets.ComposableSingletons$TicketFluidGlowKt.lambda$1959776230.<anonymous> (TicketFluidGlow.kt:442)");
            }
            TextKt.m3661TextNvy7gAk("进行中", null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer, 6, 0, 262142);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    static final Unit lambda__1080409049$lambda$4(RowScope Button, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(Button, "$this$Button");
        ComposerKt.sourceInformation(composer, "C449@13188L11:TicketFluidGlow.kt#n9ob9m");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1080409049, i, -1, "com.example.tickets.ComposableSingletons$TicketFluidGlowKt.lambda$-1080409049.<anonymous> (TicketFluidGlow.kt:449)");
            }
            TextKt.m3661TextNvy7gAk("已使用", null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer, 6, 0, 262142);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
