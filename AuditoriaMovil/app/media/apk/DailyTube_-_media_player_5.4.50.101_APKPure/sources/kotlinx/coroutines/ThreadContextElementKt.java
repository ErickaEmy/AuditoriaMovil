package kotlinx.coroutines;

import kotlinx.coroutines.internal.ThreadLocalElement;
/* loaded from: classes.dex */
public final class ThreadContextElementKt {
    public static final <T> ThreadContextElement<T> asContextElement(ThreadLocal<T> threadLocal, T t2) {
        return new ThreadLocalElement(t2, threadLocal);
    }
}
