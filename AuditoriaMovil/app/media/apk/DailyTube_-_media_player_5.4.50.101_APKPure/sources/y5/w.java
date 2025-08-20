package y5;

import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes.dex */
public final /* synthetic */ class w {
    public static /* synthetic */ boolean y(AtomicReference atomicReference, Object obj, Object obj2) {
        while (!atomicReference.compareAndSet(obj, obj2)) {
            if (atomicReference.get() != obj) {
                return false;
            }
        }
        return true;
    }
}
