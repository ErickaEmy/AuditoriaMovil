package io.ktor.utils.io.pool;

import java.util.concurrent.atomic.AtomicReferenceArray;
/* compiled from: R8$$SyntheticClass */
/* loaded from: classes.dex */
public abstract /* synthetic */ class DefaultPool$$ExternalSyntheticBackportWithForwarding0 {
    public static /* synthetic */ boolean m(AtomicReferenceArray atomicReferenceArray, int i, Object obj, Object obj2) {
        while (!atomicReferenceArray.compareAndSet(i, obj, obj2)) {
            if (atomicReferenceArray.get(i) != obj) {
                return false;
            }
        }
        return true;
    }
}
