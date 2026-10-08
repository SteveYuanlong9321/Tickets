package com.google.android.gms.common.util;

import android.graphics.RuntimeShader;
import android.os.Binder;
import android.view.DisplayCutout;
import android.view.View;
import android.view.WindowMetrics;
import android.view.accessibility.AccessibilityNodeInfo;
import dalvik.system.DelegateLastClassLoader;
import java.util.Map;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class zzc$$ExternalSyntheticApiModelOutline0 {
    public static /* synthetic */ RuntimeShader m(String str) {
        return new RuntimeShader(str);
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static /* synthetic */ Binder m9344m(String str) {
        return new Binder(str);
    }

    public static /* bridge */ /* synthetic */ DisplayCutout m(Object obj) {
        return (DisplayCutout) obj;
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static /* synthetic */ AccessibilityNodeInfo.CollectionItemInfo.Builder m9346m() {
        return new AccessibilityNodeInfo.CollectionItemInfo.Builder();
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ AccessibilityNodeInfo.MathInfo m9347m(Object obj) {
        return (AccessibilityNodeInfo.MathInfo) obj;
    }

    public static /* synthetic */ AccessibilityNodeInfo.Selection m(AccessibilityNodeInfo.SelectionPosition selectionPosition, AccessibilityNodeInfo.SelectionPosition selectionPosition2) {
        return new AccessibilityNodeInfo.Selection(selectionPosition, selectionPosition2);
    }

    public static /* synthetic */ AccessibilityNodeInfo.SelectionPosition m(View view, int i) {
        return new AccessibilityNodeInfo.SelectionPosition(view, i);
    }

    public static /* synthetic */ AccessibilityNodeInfo.SelectionPosition m(View view, int i, int i2) {
        return new AccessibilityNodeInfo.SelectionPosition(view, i, i2);
    }

    public static /* synthetic */ AccessibilityNodeInfo.SelectionPosition m(AccessibilityNodeInfo accessibilityNodeInfo, int i) {
        return new AccessibilityNodeInfo.SelectionPosition(accessibilityNodeInfo, i);
    }

    public static /* synthetic */ AccessibilityNodeInfo.TouchDelegateInfo m(Map map) {
        return new AccessibilityNodeInfo.TouchDelegateInfo(map);
    }

    public static /* synthetic */ DelegateLastClassLoader m(String str, ClassLoader classLoader) {
        return new DelegateLastClassLoader(str, classLoader);
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ Class m9351m() {
        return WindowMetrics.class;
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static /* synthetic */ void m9353m() {
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ boolean m9356m(Object obj) {
        return obj instanceof AccessibilityNodeInfo.MathInfo;
    }

    /* JADX INFO: renamed from: m$1, reason: collision with other method in class */
    public static /* synthetic */ void m9358m$1() {
    }

    public static /* bridge */ /* synthetic */ boolean m$1(Object obj) {
        return obj instanceof DisplayCutout;
    }

    /* JADX INFO: renamed from: m$2, reason: collision with other method in class */
    public static /* synthetic */ void m9360m$2() {
    }

    /* JADX INFO: renamed from: m$3, reason: collision with other method in class */
    public static /* synthetic */ void m9361m$3() {
    }
}
