package io.ktor.utils.io.pool;

import io.ktor.utils.io.pool.ObjectPool;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import org.bouncycastle.asn1.cmc.BodyPartID;
/* compiled from: DefaultPool.kt */
/* loaded from: classes.dex */
public abstract class DefaultPool implements ObjectPool {
    public static final Companion Companion = new Companion(null);
    private static final AtomicLongFieldUpdater Top;
    private final int capacity;
    private final AtomicReferenceArray instances;
    private final int maxIndex;
    private final int[] next;
    private final int shift;
    private volatile long top;

    /* compiled from: DefaultPool.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Object clearInstance(Object instance) {
        Intrinsics.checkNotNullParameter(instance, "instance");
        return instance;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void disposeInstance(Object instance) {
        Intrinsics.checkNotNullParameter(instance, "instance");
    }

    protected abstract Object produceInstance();

    /* JADX INFO: Access modifiers changed from: protected */
    public void validateInstance(Object instance) {
        Intrinsics.checkNotNullParameter(instance, "instance");
    }

    public DefaultPool(int i) {
        this.capacity = i;
        if (i <= 0) {
            throw new IllegalArgumentException(("capacity should be positive but it is " + i).toString());
        } else if (i > 536870911) {
            throw new IllegalArgumentException(("capacity should be less or equal to 536870911 but it is " + i).toString());
        } else {
            int highestOneBit = Integer.highestOneBit((i * 4) - 1) * 2;
            this.maxIndex = highestOneBit;
            this.shift = Integer.numberOfLeadingZeros(highestOneBit) + 1;
            this.instances = new AtomicReferenceArray(highestOneBit + 1);
            this.next = new int[highestOneBit + 1];
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        ObjectPool.DefaultImpls.close(this);
    }

    @Override // io.ktor.utils.io.pool.ObjectPool
    public final Object borrow() {
        Object clearInstance;
        Object tryPop = tryPop();
        return (tryPop == null || (clearInstance = clearInstance(tryPop)) == null) ? produceInstance() : clearInstance;
    }

    @Override // io.ktor.utils.io.pool.ObjectPool
    public final void recycle(Object instance) {
        Intrinsics.checkNotNullParameter(instance, "instance");
        validateInstance(instance);
        if (tryPush(instance)) {
            return;
        }
        disposeInstance(instance);
    }

    @Override // io.ktor.utils.io.pool.ObjectPool
    public final void dispose() {
        while (true) {
            Object tryPop = tryPop();
            if (tryPop == null) {
                return;
            }
            disposeInstance(tryPop);
        }
    }

    private final boolean tryPush(Object obj) {
        int identityHashCode = ((System.identityHashCode(obj) * (-1640531527)) >>> this.shift) + 1;
        for (int i = 0; i < 8; i++) {
            if (DefaultPool$$ExternalSyntheticBackportWithForwarding0.m(this.instances, identityHashCode, null, obj)) {
                pushTop(identityHashCode);
                return true;
            }
            identityHashCode--;
            if (identityHashCode == 0) {
                identityHashCode = this.maxIndex;
            }
        }
        return false;
    }

    private final Object tryPop() {
        int popTop = popTop();
        if (popTop == 0) {
            return null;
        }
        return this.instances.getAndSet(popTop, null);
    }

    private final void pushTop(int i) {
        long j;
        if (i <= 0) {
            throw new IllegalArgumentException("index should be positive".toString());
        }
        do {
            j = this.top;
            this.next[i] = (int) (BodyPartID.bodyIdMax & j);
        } while (!Top.compareAndSet(this, j, ((((j >> 32) & BodyPartID.bodyIdMax) + 1) << 32) | i));
    }

    private final int popTop() {
        long j;
        long j2;
        int i;
        do {
            j = this.top;
            if (j == 0) {
                return 0;
            }
            j2 = ((j >> 32) & BodyPartID.bodyIdMax) + 1;
            i = (int) (BodyPartID.bodyIdMax & j);
            if (i == 0) {
                return 0;
            }
        } while (!Top.compareAndSet(this, j, (j2 << 32) | this.next[i]));
        return i;
    }

    static {
        AtomicLongFieldUpdater newUpdater = AtomicLongFieldUpdater.newUpdater(DefaultPool.class, new MutablePropertyReference1Impl() { // from class: io.ktor.utils.io.pool.DefaultPool$Companion$Top$1
            @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                long j;
                j = ((DefaultPool) obj).top;
                return Long.valueOf(j);
            }
        }.getName());
        Intrinsics.checkNotNullExpressionValue(newUpdater, "newUpdater(Owner::class.java, p.name)");
        Top = newUpdater;
    }
}
