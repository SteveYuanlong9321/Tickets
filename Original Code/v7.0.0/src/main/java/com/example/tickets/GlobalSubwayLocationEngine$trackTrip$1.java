package com.example.tickets;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: compiled from: GlobalSubwayData.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.example.tickets.GlobalSubwayLocationEngine", f = "GlobalSubwayData.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2}, l = {3751, 3764, 3770}, m = "trackTrip$app", n = {"context", "initialTrip", "onUpdate", "city", "needsInitialPreparation", "context", "initialTrip", "onUpdate", "city", "prepared", "needsInitialPreparation", "context", "initialTrip", "onUpdate", "city", "prepared", "needsInitialPreparation"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "I$0"})
final class GlobalSubwayLocationEngine$trackTrip$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ GlobalSubwayLocationEngine this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    GlobalSubwayLocationEngine$trackTrip$1(GlobalSubwayLocationEngine globalSubwayLocationEngine, Continuation<? super GlobalSubwayLocationEngine$trackTrip$1> continuation) {
        super(continuation);
        this.this$0 = globalSubwayLocationEngine;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.trackTrip$app(null, null, null, this);
    }
}
