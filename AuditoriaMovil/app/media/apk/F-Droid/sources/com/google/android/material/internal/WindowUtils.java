package com.google.android.material.internal;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.view.Display;
import android.view.WindowManager;
import android.view.WindowMetrics;
/* loaded from: classes.dex */
public abstract class WindowUtils {
    public static Rect getCurrentWindowBounds(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        if (Build.VERSION.SDK_INT >= 30) {
            return Api30Impl.getCurrentWindowBounds(windowManager);
        }
        return Api17Impl.getCurrentWindowBounds(windowManager);
    }

    /* loaded from: classes.dex */
    private static class Api30Impl {
        static Rect getCurrentWindowBounds(WindowManager windowManager) {
            WindowMetrics currentWindowMetrics;
            Rect bounds;
            currentWindowMetrics = windowManager.getCurrentWindowMetrics();
            bounds = currentWindowMetrics.getBounds();
            return bounds;
        }
    }

    /* loaded from: classes.dex */
    private static class Api17Impl {
        static Rect getCurrentWindowBounds(WindowManager windowManager) {
            Display defaultDisplay = windowManager.getDefaultDisplay();
            Point point = new Point();
            defaultDisplay.getRealSize(point);
            Rect rect = new Rect();
            rect.right = point.x;
            rect.bottom = point.y;
            return rect;
        }
    }
}
