package com.example.tickets;

import com.google.firebase.messaging.Constants;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: compiled from: MainActivity.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\f\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u001b\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Lcom/example/tickets/LocalArchivePolicy;", "", Constants.ScionAnalytics.PARAM_LABEL, "", "days", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Long;)V", "getLabel", "()Ljava/lang/String;", "getDays", "()Ljava/lang/Long;", "Ljava/lang/Long;", "OFF", "DAYS_7", "DAYS_30", "DAYS_90", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
enum LocalArchivePolicy {
    OFF("关闭", null),
    DAYS_7("7天", 7L),
    DAYS_30("30天", 30L),
    DAYS_90("90天", 90L);

    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
    private final Long days;
    private final String label;

    public static EnumEntries<LocalArchivePolicy> getEntries() {
        return $ENTRIES;
    }

    LocalArchivePolicy(String str, Long l) {
        this.label = str;
        this.days = l;
    }

    public final Long getDays() {
        return this.days;
    }

    public final String getLabel() {
        return this.label;
    }
}
