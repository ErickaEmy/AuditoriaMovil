package kotlinx.coroutines.internal;
/* loaded from: classes.dex */
public final class ThreadLocalKt {
    public static final <T> ThreadLocal<T> commonThreadLocal(Symbol symbol) {
        return new ThreadLocal<>();
    }
}
