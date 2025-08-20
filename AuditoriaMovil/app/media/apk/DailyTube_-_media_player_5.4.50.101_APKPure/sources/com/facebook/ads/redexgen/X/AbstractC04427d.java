package com.facebook.ads.redexgen.X;

import java.util.concurrent.atomic.AtomicReference;
/* renamed from: com.facebook.ads.redexgen.X.7d  reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public abstract /* synthetic */ class AbstractC04427d {
    public static /* synthetic */ boolean A00(AtomicReference atomicReference, Object obj, Object obj2) {
        while (!atomicReference.compareAndSet(obj, obj2)) {
            if (atomicReference.get() != obj) {
                return false;
            }
        }
        return true;
    }
}
