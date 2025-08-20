package kotlinx.coroutines.sync;

import kotlinx.coroutines.internal.Symbol;
/* loaded from: classes.dex */
public final class MutexKt {
    private static final Symbol NO_OWNER = new Symbol("NO_OWNER");
    private static final Symbol ON_LOCK_ALREADY_LOCKED_BY_OWNER = new Symbol("ALREADY_LOCKED_BY_OWNER");

    public static final Mutex Mutex(boolean z2) {
        return new MutexImpl(z2);
    }

    public static /* synthetic */ Mutex Mutex$default(boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = false;
        }
        return Mutex(z2);
    }
}
