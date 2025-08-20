package io.ktor.utils.io.pool;

import io.ktor.utils.io.pool.ObjectPool;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: Pool.kt */
/* loaded from: classes.dex */
public abstract class NoPoolImpl implements ObjectPool {
    @Override // io.ktor.utils.io.pool.ObjectPool
    public void dispose() {
    }

    @Override // io.ktor.utils.io.pool.ObjectPool
    public void recycle(Object instance) {
        Intrinsics.checkNotNullParameter(instance, "instance");
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        ObjectPool.DefaultImpls.close(this);
    }
}
