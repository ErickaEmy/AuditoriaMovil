package gc1;

import java.util.concurrent.atomic.AtomicReferenceArray;
/* loaded from: classes.dex */
public final /* synthetic */ class y {
    public static /* synthetic */ boolean y(AtomicReferenceArray atomicReferenceArray, int i, Object obj, Object obj2) {
        while (!atomicReferenceArray.compareAndSet(i, obj, obj2)) {
            if (atomicReferenceArray.get(i) != obj) {
                return false;
            }
        }
        return true;
    }
}
