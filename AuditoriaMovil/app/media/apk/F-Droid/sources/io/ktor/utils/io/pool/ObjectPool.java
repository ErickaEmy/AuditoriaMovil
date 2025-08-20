package io.ktor.utils.io.pool;

import java.io.Closeable;
/* compiled from: Pool.kt */
/* loaded from: classes.dex */
public interface ObjectPool extends Closeable {
    Object borrow();

    void dispose();

    void recycle(Object obj);

    /* compiled from: Pool.kt */
    /* loaded from: classes.dex */
    public static final class DefaultImpls {
        public static void close(ObjectPool objectPool) {
            objectPool.dispose();
        }
    }
}
