package kotlinx.coroutines.internal;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public final class ThreadLocalKey implements CoroutineContext.Key<ThreadLocalElement<?>> {
    private final ThreadLocal<?> threadLocal;

    public ThreadLocalKey(ThreadLocal<?> threadLocal) {
        this.threadLocal = threadLocal;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ThreadLocalKey) && Intrinsics.areEqual(this.threadLocal, ((ThreadLocalKey) obj).threadLocal);
    }

    public int hashCode() {
        return this.threadLocal.hashCode();
    }

    public String toString() {
        return "ThreadLocalKey(threadLocal=" + this.threadLocal + ')';
    }
}
