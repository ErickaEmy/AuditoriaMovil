package f1;

import java.util.concurrent.locks.LockSupport;
/* loaded from: classes.dex */
public final class v {
    public static void y(Object obj, long j2) {
        LockSupport.parkNanos(obj, Math.min(j2, 2147483647999999999L));
    }
}
