package kotlinx.coroutines;

import kotlinx.coroutines.internal.Symbol;
/* loaded from: classes.dex */
public final class EventLoop_commonKt {
    private static final Symbol DISPOSED_TASK = new Symbol("REMOVED_TASK");
    private static final Symbol CLOSED_EMPTY = new Symbol("CLOSED_EMPTY");

    public static final long delayToNanos(long j2) {
        if (j2 <= 0) {
            return 0L;
        }
        if (j2 >= 9223372036854L) {
            return Long.MAX_VALUE;
        }
        return 1000000 * j2;
    }
}
