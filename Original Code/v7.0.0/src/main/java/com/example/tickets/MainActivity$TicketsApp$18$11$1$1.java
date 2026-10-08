package com.example.tickets;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: MainActivity.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.example.tickets.MainActivity$TicketsApp$18$11$1$1", f = "MainActivity.kt", i = {}, l = {3123, 3139, 3195, 3202}, m = "invokeSuspend", n = {}, s = {})
final class MainActivity$TicketsApp$18$11$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ AppSettings $backgroundSettings;
    final /* synthetic */ TicketData $backgroundTicket;
    int label;
    final /* synthetic */ MainActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    MainActivity$TicketsApp$18$11$1$1(AppSettings appSettings, MainActivity mainActivity, TicketData ticketData, Continuation<? super MainActivity$TicketsApp$18$11$1$1> continuation) {
        super(2, continuation);
        this.$backgroundSettings = appSettings;
        this.this$0 = mainActivity;
        this.$backgroundTicket = ticketData;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MainActivity$TicketsApp$18$11$1$1(this.$backgroundSettings, this.this$0, this.$backgroundTicket, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((MainActivity$TicketsApp$18$11$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0073, code lost:
    
        if (kotlinx.coroutines.BuildersKt.withContext(kotlinx.coroutines.Dispatchers.getMain(), new com.example.tickets.MainActivity$TicketsApp$18$11$1$1.AnonymousClass2(r10.$backgroundTicket, r10.this$0, null), r10) == r0) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0098, code lost:
    
        if (kotlinx.coroutines.BuildersKt.withContext(kotlinx.coroutines.Dispatchers.getMain(), new com.example.tickets.MainActivity$TicketsApp$18$11$1$1.AnonymousClass3(r10.this$0, r10.$backgroundTicket, null), r10) == r0) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00b7, code lost:
    
        if (kotlinx.coroutines.BuildersKt.withContext(kotlinx.coroutines.Dispatchers.getMain(), new com.example.tickets.MainActivity$TicketsApp$18$11$1$1.AnonymousClass4(r10.this$0, r10.$backgroundTicket, r10.$backgroundSettings, null), r10) == r0) goto L30;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            if (this.$backgroundSettings.getReminderEnabled()) {
                this.label = 1;
                if (BuildersKt.withContext(Dispatchers.getMain(), new AnonymousClass1(this.this$0, this.$backgroundTicket, this.$backgroundSettings, null), this) != coroutine_suspended) {
                }
                return coroutine_suspended;
            }
        } else {
            if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                if (i != 2 && i != 3 && i != 4) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
        if (this.$backgroundSettings.getLiveUpdate()) {
            this.label = 2;
        } else if (this.$backgroundSettings.getSuperIsland()) {
            this.label = 3;
        } else {
            this.label = 4;
        }
    }

    /* JADX INFO: renamed from: com.example.tickets.MainActivity$TicketsApp$18$11$1$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: MainActivity.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.tickets.MainActivity$TicketsApp$18$11$1$1$1", f = "MainActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ AppSettings $backgroundSettings;
        final /* synthetic */ TicketData $backgroundTicket;
        int label;
        final /* synthetic */ MainActivity this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(MainActivity mainActivity, TicketData ticketData, AppSettings appSettings, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = mainActivity;
            this.$backgroundTicket = ticketData;
            this.$backgroundSettings = appSettings;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, this.$backgroundTicket, this.$backgroundSettings, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            ReminderManager.INSTANCE.scheduleTicketReminder$app(this.this$0, this.$backgroundTicket, this.$backgroundSettings);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.example.tickets.MainActivity$TicketsApp$18$11$1$1$2, reason: invalid class name */
    /* JADX INFO: compiled from: MainActivity.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.tickets.MainActivity$TicketsApp$18$11$1$1$2", f = "MainActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ TicketData $backgroundTicket;
        int label;
        final /* synthetic */ MainActivity this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(TicketData ticketData, MainActivity mainActivity, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$backgroundTicket = ticketData;
            this.this$0 = mainActivity;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.$backgroundTicket, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            LiveUpdateManager liveUpdateManager = LiveUpdateManager.INSTANCE;
            int id = this.$backgroundTicket.getId();
            String strTicketTypeName = MainActivityKt.ticketTypeName(this.$backgroundTicket.getType());
            String title = this.$backgroundTicket.getTitle();
            String code = this.$backgroundTicket.getCode();
            String date = this.$backgroundTicket.getDate();
            String departureDate = this.$backgroundTicket.getDepartureDate();
            String arrivalDate = this.$backgroundTicket.getArrivalDate();
            String time = this.$backgroundTicket.getTime();
            String from = this.$backgroundTicket.getFrom();
            String to = this.$backgroundTicket.getTo();
            String departurePlatform = this.$backgroundTicket.getDeparturePlatform();
            String arrivalPlatform = this.$backgroundTicket.getArrivalPlatform();
            liveUpdateManager.showTicketLiveUpdate(this.this$0, id, strTicketTypeName, title, code, date, time, (196992 & 128) != 0 ? "" : departureDate, (196992 & 256) != 0 ? "" : arrivalDate, from, to, (196992 & 2048) != 0 ? "" : departurePlatform, (196992 & 4096) != 0 ? "" : arrivalPlatform, this.$backgroundTicket.getHall(), this.$backgroundTicket.getSeat(), this.$backgroundTicket.getVenue(), (65536 & 196992) != 0 ? "" : null, (131072 & 196992) != 0 ? "" : null, (262144 & 196992) != 0 ? "" : this.$backgroundTicket.getStartTime(), (524288 & 196992) != 0 ? "" : this.$backgroundTicket.getEndTime(), (1048576 & 196992) != 0 ? "" : this.$backgroundTicket.getTakeoffTime(), (2097152 & 196992) != 0 ? "" : this.$backgroundTicket.getLandingTime(), (196992 & 4194304) != 0 ? "" : this.$backgroundTicket.getBrand());
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.example.tickets.MainActivity$TicketsApp$18$11$1$1$3, reason: invalid class name */
    /* JADX INFO: compiled from: MainActivity.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.tickets.MainActivity$TicketsApp$18$11$1$1$3", f = "MainActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ TicketData $backgroundTicket;
        int label;
        final /* synthetic */ MainActivity this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(MainActivity mainActivity, TicketData ticketData, Continuation<? super AnonymousClass3> continuation) {
            super(2, continuation);
            this.this$0 = mainActivity;
            this.$backgroundTicket = ticketData;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass3(this.this$0, this.$backgroundTicket, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            XiaomiSuperIslandManager.INSTANCE.showTicket$app(this.this$0, this.$backgroundTicket);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.example.tickets.MainActivity$TicketsApp$18$11$1$1$4, reason: invalid class name */
    /* JADX INFO: compiled from: MainActivity.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.tickets.MainActivity$TicketsApp$18$11$1$1$4", f = "MainActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ AppSettings $backgroundSettings;
        final /* synthetic */ TicketData $backgroundTicket;
        int label;
        final /* synthetic */ MainActivity this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass4(MainActivity mainActivity, TicketData ticketData, AppSettings appSettings, Continuation<? super AnonymousClass4> continuation) {
            super(2, continuation);
            this.this$0 = mainActivity;
            this.$backgroundTicket = ticketData;
            this.$backgroundSettings = appSettings;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass4(this.this$0, this.$backgroundTicket, this.$backgroundSettings, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass4) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                MainActivityKt.showIntegrationTicketSafely(this.this$0, this.$backgroundTicket, this.$backgroundSettings.getIntegrationMode());
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
