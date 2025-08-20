package ua;

import sun.misc.Unsafe;
/* loaded from: classes.dex */
public final /* synthetic */ class y {
    public static /* synthetic */ boolean y(Unsafe unsafe, Object obj, long j2, Object obj2, Object obj3) {
        while (!unsafe.compareAndSwapObject(obj, j2, obj2, obj3)) {
            if (unsafe.getObject(obj, j2) != obj2) {
                return false;
            }
        }
        return true;
    }
}
