package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.DebugKt;
import r.n3;
/* loaded from: classes.dex */
public final class LockFreeTaskQueueCore<E> {
    private volatile Object _next;
    private volatile long _state;
    private final AtomicReferenceArray array;
    private final int capacity;
    private final int mask;
    private final boolean singleConsumer;
    public static final Companion Companion = new Companion(null);
    private static final AtomicReferenceFieldUpdater _next$FU = AtomicReferenceFieldUpdater.newUpdater(LockFreeTaskQueueCore.class, Object.class, "_next");
    private static final AtomicLongFieldUpdater _state$FU = AtomicLongFieldUpdater.newUpdater(LockFreeTaskQueueCore.class, "_state");
    public static final Symbol REMOVE_FROZEN = new Symbol("REMOVE_FROZEN");

    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int addFailReason(long j2) {
            return (j2 & 2305843009213693952L) != 0 ? 2 : 1;
        }

        public final long updateHead(long j2, int i) {
            return wo(j2, 1073741823L) | i;
        }

        public final long updateTail(long j2, int i) {
            return wo(j2, 1152921503533105152L) | (i << 30);
        }

        public final long wo(long j2, long j4) {
            return j2 & (~j4);
        }

        private Companion() {
        }
    }

    /* loaded from: classes.dex */
    public static final class Placeholder {
        public final int index;

        public Placeholder(int i) {
            this.index = i;
        }
    }

    public LockFreeTaskQueueCore(int i, boolean z2) {
        this.capacity = i;
        this.singleConsumer = z2;
        int i5 = i - 1;
        this.mask = i5;
        this.array = new AtomicReferenceArray(i);
        if (i5 <= 1073741823) {
            if ((i & i5) == 0) {
                return;
            }
            throw new IllegalStateException("Check failed.");
        }
        throw new IllegalStateException("Check failed.");
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final LockFreeTaskQueueCore<E> allocateNextCopy(long j2) {
        LockFreeTaskQueueCore<E> lockFreeTaskQueueCore = new LockFreeTaskQueueCore<>(this.capacity * 2, this.singleConsumer);
        int i = (int) (1073741823 & j2);
        int i5 = (int) ((1152921503533105152L & j2) >> 30);
        while (true) {
            int i6 = this.mask;
            if ((i & i6) != (i5 & i6)) {
                Object obj = this.array.get(i6 & i);
                if (obj == null) {
                    obj = new Placeholder(i);
                }
                lockFreeTaskQueueCore.array.set(lockFreeTaskQueueCore.mask & i, obj);
                i++;
            } else {
                _state$FU.set(lockFreeTaskQueueCore, Companion.wo(j2, 1152921504606846976L));
                return lockFreeTaskQueueCore;
            }
        }
    }

    private final LockFreeTaskQueueCore<E> allocateOrGetNextCopy(long j2) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _next$FU;
        while (true) {
            LockFreeTaskQueueCore<E> lockFreeTaskQueueCore = (LockFreeTaskQueueCore) atomicReferenceFieldUpdater.get(this);
            if (lockFreeTaskQueueCore != null) {
                return lockFreeTaskQueueCore;
            }
            n3.y(_next$FU, this, null, allocateNextCopy(j2));
        }
    }

    private final LockFreeTaskQueueCore<E> fillPlaceholder(int i, E e2) {
        Object obj = this.array.get(this.mask & i);
        if ((obj instanceof Placeholder) && ((Placeholder) obj).index == i) {
            this.array.set(i & this.mask, e2);
            return this;
        }
        return null;
    }

    private final long markFrozen() {
        long j2;
        long j4;
        AtomicLongFieldUpdater atomicLongFieldUpdater = _state$FU;
        do {
            j2 = atomicLongFieldUpdater.get(this);
            if ((j2 & 1152921504606846976L) != 0) {
                return j2;
            }
            j4 = j2 | 1152921504606846976L;
        } while (!atomicLongFieldUpdater.compareAndSet(this, j2, j4));
        return j4;
    }

    private final LockFreeTaskQueueCore<E> removeSlowPath(int i, int i5) {
        long j2;
        int i6;
        AtomicLongFieldUpdater atomicLongFieldUpdater = _state$FU;
        do {
            j2 = atomicLongFieldUpdater.get(this);
            i6 = (int) (1073741823 & j2);
            if (DebugKt.getASSERTIONS_ENABLED() && i6 != i) {
                throw new AssertionError();
            }
            if ((1152921504606846976L & j2) != 0) {
                return next();
            }
        } while (!_state$FU.compareAndSet(this, j2, Companion.updateHead(j2, i5)));
        this.array.set(this.mask & i6, null);
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x004e, code lost:
        return 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int addLast(E r13) {
        /*
            r12 = this;
            java.util.concurrent.atomic.AtomicLongFieldUpdater r0 = kotlinx.coroutines.internal.LockFreeTaskQueueCore._state$FU
        L2:
            long r3 = r0.get(r12)
            r1 = 3458764513820540928(0x3000000000000000, double:1.727233711018889E-77)
            long r1 = r1 & r3
            r7 = 0
            int r5 = (r1 > r7 ? 1 : (r1 == r7 ? 0 : -1))
            if (r5 == 0) goto L16
            kotlinx.coroutines.internal.LockFreeTaskQueueCore$Companion r13 = kotlinx.coroutines.internal.LockFreeTaskQueueCore.Companion
            int r13 = r13.addFailReason(r3)
            return r13
        L16:
            r1 = 1073741823(0x3fffffff, double:5.304989472E-315)
            long r1 = r1 & r3
            int r2 = (int) r1
            r5 = 1152921503533105152(0xfffffffc0000000, double:1.2882296003504729E-231)
            long r5 = r5 & r3
            r1 = 30
            long r5 = r5 >> r1
            int r9 = (int) r5
            int r10 = r12.mask
            int r1 = r9 + 2
            r1 = r1 & r10
            r5 = r2 & r10
            r6 = 1
            if (r1 != r5) goto L30
            return r6
        L30:
            boolean r1 = r12.singleConsumer
            r5 = 1073741823(0x3fffffff, float:1.9999999)
            if (r1 != 0) goto L4f
            java.util.concurrent.atomic.AtomicReferenceArray r1 = r12.array
            r11 = r9 & r10
            java.lang.Object r1 = r1.get(r11)
            if (r1 == 0) goto L4f
            int r1 = r12.capacity
            r3 = 1024(0x400, float:1.435E-42)
            if (r1 < r3) goto L4e
            int r9 = r9 - r2
            r2 = r9 & r5
            int r1 = r1 >> 1
            if (r2 <= r1) goto L2
        L4e:
            return r6
        L4f:
            int r1 = r9 + 1
            r1 = r1 & r5
            java.util.concurrent.atomic.AtomicLongFieldUpdater r2 = kotlinx.coroutines.internal.LockFreeTaskQueueCore._state$FU
            kotlinx.coroutines.internal.LockFreeTaskQueueCore$Companion r5 = kotlinx.coroutines.internal.LockFreeTaskQueueCore.Companion
            long r5 = r5.updateTail(r3, r1)
            r1 = r2
            r2 = r12
            boolean r1 = r1.compareAndSet(r2, r3, r5)
            if (r1 == 0) goto L2
            java.util.concurrent.atomic.AtomicReferenceArray r0 = r12.array
            r1 = r9 & r10
            r0.set(r1, r13)
            r0 = r12
        L6a:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r1 = kotlinx.coroutines.internal.LockFreeTaskQueueCore._state$FU
            long r1 = r1.get(r0)
            r3 = 1152921504606846976(0x1000000000000000, double:1.2882297539194267E-231)
            long r1 = r1 & r3
            int r3 = (r1 > r7 ? 1 : (r1 == r7 ? 0 : -1))
            if (r3 == 0) goto L81
            kotlinx.coroutines.internal.LockFreeTaskQueueCore r0 = r0.next()
            kotlinx.coroutines.internal.LockFreeTaskQueueCore r0 = r0.fillPlaceholder(r9, r13)
            if (r0 != 0) goto L6a
        L81:
            r13 = 0
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.internal.LockFreeTaskQueueCore.addLast(java.lang.Object):int");
    }

    public final boolean close() {
        long j2;
        AtomicLongFieldUpdater atomicLongFieldUpdater = _state$FU;
        do {
            j2 = atomicLongFieldUpdater.get(this);
            if ((j2 & 2305843009213693952L) != 0) {
                return true;
            }
            if ((1152921504606846976L & j2) != 0) {
                return false;
            }
        } while (!atomicLongFieldUpdater.compareAndSet(this, j2, j2 | 2305843009213693952L));
        return true;
    }

    public final int getSize() {
        long j2 = _state$FU.get(this);
        return 1073741823 & (((int) ((j2 & 1152921503533105152L) >> 30)) - ((int) (1073741823 & j2)));
    }

    public final boolean isEmpty() {
        long j2 = _state$FU.get(this);
        if (((int) (1073741823 & j2)) == ((int) ((j2 & 1152921503533105152L) >> 30))) {
            return true;
        }
        return false;
    }

    public final LockFreeTaskQueueCore<E> next() {
        return allocateOrGetNextCopy(markFrozen());
    }

    public final Object removeFirstOrNull() {
        AtomicLongFieldUpdater atomicLongFieldUpdater = _state$FU;
        while (true) {
            long j2 = atomicLongFieldUpdater.get(this);
            if ((1152921504606846976L & j2) != 0) {
                return REMOVE_FROZEN;
            }
            int i = (int) (1073741823 & j2);
            int i5 = (int) ((1152921503533105152L & j2) >> 30);
            int i6 = this.mask;
            if ((i5 & i6) == (i & i6)) {
                return null;
            }
            Object obj = this.array.get(i6 & i);
            if (obj == null) {
                if (this.singleConsumer) {
                    return null;
                }
            } else if (obj instanceof Placeholder) {
                return null;
            } else {
                int i8 = (i + 1) & 1073741823;
                if (_state$FU.compareAndSet(this, j2, Companion.updateHead(j2, i8))) {
                    this.array.set(this.mask & i, null);
                    return obj;
                } else if (this.singleConsumer) {
                    LockFreeTaskQueueCore<E> lockFreeTaskQueueCore = this;
                    do {
                        lockFreeTaskQueueCore = lockFreeTaskQueueCore.removeSlowPath(i, i8);
                    } while (lockFreeTaskQueueCore != null);
                    return obj;
                }
            }
        }
    }
}
