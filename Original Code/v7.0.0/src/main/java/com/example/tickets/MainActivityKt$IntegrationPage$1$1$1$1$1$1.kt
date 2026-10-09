package com.example.tickets;

import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: compiled from: MainActivity.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.example.tickets.MainActivityKt$IntegrationPage$1$1$1$1$1$1", f = "MainActivity.kt", i = {1, 1, 1, 1, 1}, l = {16822, 16832}, m = "invokeSuspend", n = {"$this$forEach$iv", "element$iv", "ticket", "$i$f$forEach", "$i$a$-forEach-MainActivityKt$IntegrationPage$1$1$1$1$1$1$2"}, s = {"L$0", "L$4", "L$5", "I$0", "I$1"})
final class MainActivityKt$IntegrationPage$1$1$1$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ String $mode;
    final /* synthetic */ List<TicketData> $tickets;
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    MainActivityKt$IntegrationPage$1$1$1$1$1$1(Context context, List<TicketData> list, String str, Continuation<? super MainActivityKt$IntegrationPage$1$1$1$1$1$1> continuation) {
        super(2, continuation);
        this.$context = context;
        this.$tickets = list;
        this.$mode = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MainActivityKt$IntegrationPage$1$1$1$1$1$1(this.$context, this.$tickets, this.$mode, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((MainActivityKt$IntegrationPage$1$1$1$1$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:22:0x008c  */
    /* JADX WARN: Code duplicated, block: B:28:0x00bc A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:30:? A[LOOP:0: B:20:0x0086->B:30:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x004a, code lost:
    
        if (kotlinx.coroutines.DelayKt.delay(250, r10) == r0) goto L24;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        String str;
        Iterator it;
        Context context;
        Iterable iterable;
        int i;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            MainActivityKt.cancelIntegrationNotifications(this.$context, this.$tickets);
            this.label = 1;
        } else {
            if (i2 == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                if (i2 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                i = this.I$0;
                it = (Iterator) this.L$3;
                str = (String) this.L$2;
                context = (Context) this.L$1;
                iterable = (Iterable) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
            while (it.hasNext()) {
                Object next = it.next();
                TicketData ticketData = (TicketData) next;
                MainActivityKt.showIntegrationTicketSafely(context, ticketData, str);
                this.L$0 = SpillingKt.nullOutSpilledVariable(iterable);
                this.L$1 = context;
                this.L$2 = str;
                this.L$3 = it;
                this.L$4 = SpillingKt.nullOutSpilledVariable(next);
                this.L$5 = SpillingKt.nullOutSpilledVariable(ticketData);
                this.I$0 = i;
                this.I$1 = 0;
                this.label = 2;
                if (DelayKt.delay(100L, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Unit.INSTANCE;
        }
        List<TicketData> list = this.$tickets;
        ArrayList arrayList = new ArrayList();
        for (Object obj2 : list) {
            if (!((TicketData) obj2).getManuallyUsed()) {
                arrayList.add(obj2);
            }
        }
        ArrayList arrayList2 = arrayList;
        Context context2 = this.$context;
        str = this.$mode;
        it = arrayList2.iterator();
        context = context2;
        iterable = arrayList2;
        i = 0;
        while (it.hasNext()) {
            Object next2 = it.next();
            TicketData ticketData2 = (TicketData) next2;
            MainActivityKt.showIntegrationTicketSafely(context, ticketData2, str);
            this.L$0 = SpillingKt.nullOutSpilledVariable(iterable);
            this.L$1 = context;
            this.L$2 = str;
            this.L$3 = it;
            this.L$4 = SpillingKt.nullOutSpilledVariable(next2);
            this.L$5 = SpillingKt.nullOutSpilledVariable(ticketData2);
            this.I$0 = i;
            this.I$1 = 0;
            this.label = 2;
            if (DelayKt.delay(100L, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }
}
