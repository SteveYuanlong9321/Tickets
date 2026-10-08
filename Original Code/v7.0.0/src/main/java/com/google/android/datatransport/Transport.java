package com.google.android.datatransport;

/* JADX INFO: loaded from: classes4.dex */
public interface Transport<T> {
    void schedule(Event<T> event, TransportScheduleCallback transportScheduleCallback);

    void send(Event<T> event);
}
