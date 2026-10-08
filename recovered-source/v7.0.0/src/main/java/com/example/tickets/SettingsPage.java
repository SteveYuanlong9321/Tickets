package com.example.tickets;

import com.google.android.gms.stats.CodePackage;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: compiled from: MainActivity.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000b\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/example/tickets/SettingsPage;", "", "<init>", "(Ljava/lang/String;I)V", "HOME", "PREFERENCES", CodePackage.REMINDERS, "OCR", "OCR_PROMPT", "INTEGRATION", "ABOUT", "CHANGELOG", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
enum SettingsPage {
    HOME,
    PREFERENCES,
    REMINDERS,
    OCR,
    OCR_PROMPT,
    INTEGRATION,
    ABOUT,
    CHANGELOG;

    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

    public static EnumEntries<SettingsPage> getEntries() {
        return $ENTRIES;
    }
}
