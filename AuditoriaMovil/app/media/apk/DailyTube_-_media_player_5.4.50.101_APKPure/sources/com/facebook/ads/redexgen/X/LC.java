package com.facebook.ads.redexgen.X;

import android.util.DisplayMetrics;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: assets/audience_network.dex */
public abstract class LC {
    public static final AtomicReference<DisplayMetrics> A00 = new AtomicReference<>();

    public static DisplayMetrics A00() {
        AtomicReference<DisplayMetrics> atomicReference = A00;
        if (atomicReference.get() != null) {
            return atomicReference.get();
        }
        return LD.A03;
    }
}
