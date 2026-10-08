package com.example.tickets;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MainActivity.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0082\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J1\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\r¨\u0006\u001a"}, d2 = {"Lcom/example/tickets/AppUpdateInfo;", "", "versionCode", "", "versionName", "", "downloadUrl", "changelog", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getVersionCode", "()I", "getVersionName", "()Ljava/lang/String;", "getDownloadUrl", "getChangelog", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
final /* data */ class AppUpdateInfo {
    private final String changelog;
    private final String downloadUrl;
    private final int versionCode;
    private final String versionName;

    public static /* synthetic */ AppUpdateInfo copy$default(AppUpdateInfo appUpdateInfo, int i, String str, String str2, String str3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = appUpdateInfo.versionCode;
        }
        if ((i2 & 2) != 0) {
            str = appUpdateInfo.versionName;
        }
        if ((i2 & 4) != 0) {
            str2 = appUpdateInfo.downloadUrl;
        }
        if ((i2 & 8) != 0) {
            str3 = appUpdateInfo.changelog;
        }
        return appUpdateInfo.copy(i, str, str2, str3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getVersionCode() {
        return this.versionCode;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getVersionName() {
        return this.versionName;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getDownloadUrl() {
        return this.downloadUrl;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getChangelog() {
        return this.changelog;
    }

    public final AppUpdateInfo copy(int versionCode, String versionName, String downloadUrl, String changelog) {
        Intrinsics.checkNotNullParameter(versionName, "versionName");
        Intrinsics.checkNotNullParameter(downloadUrl, "downloadUrl");
        Intrinsics.checkNotNullParameter(changelog, "changelog");
        return new AppUpdateInfo(versionCode, versionName, downloadUrl, changelog);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AppUpdateInfo)) {
            return false;
        }
        AppUpdateInfo appUpdateInfo = (AppUpdateInfo) other;
        return this.versionCode == appUpdateInfo.versionCode && Intrinsics.areEqual(this.versionName, appUpdateInfo.versionName) && Intrinsics.areEqual(this.downloadUrl, appUpdateInfo.downloadUrl) && Intrinsics.areEqual(this.changelog, appUpdateInfo.changelog);
    }

    public int hashCode() {
        return (((((Integer.hashCode(this.versionCode) * 31) + this.versionName.hashCode()) * 31) + this.downloadUrl.hashCode()) * 31) + this.changelog.hashCode();
    }

    public String toString() {
        return "AppUpdateInfo(versionCode=" + this.versionCode + ", versionName=" + this.versionName + ", downloadUrl=" + this.downloadUrl + ", changelog=" + this.changelog + ")";
    }

    public AppUpdateInfo(int i, String versionName, String downloadUrl, String changelog) {
        Intrinsics.checkNotNullParameter(versionName, "versionName");
        Intrinsics.checkNotNullParameter(downloadUrl, "downloadUrl");
        Intrinsics.checkNotNullParameter(changelog, "changelog");
        this.versionCode = i;
        this.versionName = versionName;
        this.downloadUrl = downloadUrl;
        this.changelog = changelog;
    }

    public final int getVersionCode() {
        return this.versionCode;
    }

    public final String getVersionName() {
        return this.versionName;
    }

    public final String getDownloadUrl() {
        return this.downloadUrl;
    }

    public final String getChangelog() {
        return this.changelog;
    }
}
