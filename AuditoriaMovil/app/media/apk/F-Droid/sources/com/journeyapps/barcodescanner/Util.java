package com.journeyapps.barcodescanner;

import android.os.Looper;
/* loaded from: classes.dex */
public abstract class Util {
    public static void validateMainThread() {
        if (Looper.getMainLooper() != Looper.myLooper()) {
            throw new IllegalStateException("Must be called from the main thread.");
        }
    }
}
