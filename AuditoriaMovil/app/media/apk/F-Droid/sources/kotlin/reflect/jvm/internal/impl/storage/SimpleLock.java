package kotlin.reflect.jvm.internal.impl.storage;

import kotlin.jvm.functions.Function1;
/* compiled from: locks.kt */
/* loaded from: classes2.dex */
public interface SimpleLock {
    public static final Companion Companion = Companion.$$INSTANCE;

    void lock();

    void unlock();

    /* compiled from: locks.kt */
    /* loaded from: classes2.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        public final DefaultSimpleLock simpleLock(Runnable runnable, Function1 function1) {
            if (runnable != null && function1 != null) {
                return new CancellableSimpleLock(runnable, function1);
            }
            return new DefaultSimpleLock(null, 1, null);
        }
    }
}
