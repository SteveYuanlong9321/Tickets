package com.example.tickets;

import android.content.Context;
import androidx.compose.runtime.MutableState;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: GlobalSubwayData.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.example.tickets.GlobalSubwayDataKt$GlobalSubwayStationField$1$1", f = "GlobalSubwayData.kt", i = {}, l = {4853}, m = "invokeSuspend", n = {}, s = {})
final class GlobalSubwayDataKt$GlobalSubwayStationField$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $cityId;
    final /* synthetic */ Context $context;
    final /* synthetic */ MutableState<Boolean> $focused$delegate;
    final /* synthetic */ MutableState<Boolean> $loading$delegate;
    final /* synthetic */ MutableState<List<GlobalSubwayDataManager.SubwayStationOption>> $results$delegate;
    final /* synthetic */ String $value;
    Object L$0;
    Object L$1;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    GlobalSubwayDataKt$GlobalSubwayStationField$1$1(Context context, String str, String str2, MutableState<Boolean> mutableState, MutableState<Boolean> mutableState2, MutableState<List<GlobalSubwayDataManager.SubwayStationOption>> mutableState3, Continuation<? super GlobalSubwayDataKt$GlobalSubwayStationField$1$1> continuation) {
        super(2, continuation);
        this.$context = context;
        this.$cityId = str;
        this.$value = str2;
        this.$focused$delegate = mutableState;
        this.$loading$delegate = mutableState2;
        this.$results$delegate = mutableState3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new GlobalSubwayDataKt$GlobalSubwayStationField$1$1(this.$context, this.$cityId, this.$value, this.$focused$delegate, this.$loading$delegate, this.$results$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((GlobalSubwayDataKt$GlobalSubwayStationField$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        MutableState<List<GlobalSubwayDataManager.SubwayStationOption>> mutableState;
        MutableState<List<GlobalSubwayDataManager.SubwayStationOption>> mutableState2;
        List listEmptyList;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            if (!GlobalSubwayDataKt.GlobalSubwayStationField$lambda$1(this.$focused$delegate)) {
                return Unit.INSTANCE;
            }
            GlobalSubwayDataKt.GlobalSubwayStationField$lambda$5(this.$loading$delegate, true);
            MutableState<List<GlobalSubwayDataManager.SubwayStationOption>> mutableState3 = this.$results$delegate;
            try {
                this.L$0 = mutableState3;
                this.L$1 = mutableState3;
                this.label = 1;
                Object objSearchStations = GlobalSubwayDataManager.INSTANCE.searchStations(this.$context, this.$cityId, this.$value, 8, this);
                if (objSearchStations == coroutine_suspended) {
                    return coroutine_suspended;
                }
                mutableState2 = mutableState3;
                obj = objSearchStations;
                mutableState = mutableState2;
            } catch (Throwable unused) {
                mutableState = mutableState3;
                listEmptyList = CollectionsKt.emptyList();
                mutableState2 = mutableState;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            mutableState2 = (MutableState) this.L$1;
            mutableState = (MutableState) this.L$0;
            try {
                ResultKt.throwOnFailure(obj);
            } catch (Throwable unused2) {
                listEmptyList = CollectionsKt.emptyList();
                mutableState2 = mutableState;
            }
        }
        listEmptyList = (List) obj;
        mutableState2.setValue(listEmptyList);
        GlobalSubwayDataKt.GlobalSubwayStationField$lambda$5(this.$loading$delegate, false);
        return Unit.INSTANCE;
    }
}
