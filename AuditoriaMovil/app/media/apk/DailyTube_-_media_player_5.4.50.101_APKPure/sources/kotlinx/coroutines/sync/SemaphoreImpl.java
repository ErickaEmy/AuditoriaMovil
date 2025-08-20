package kotlinx.coroutines.sync;

import gc1.y;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.Waiter;
import kotlinx.coroutines.internal.ConcurrentLinkedListKt;
import kotlinx.coroutines.internal.Segment;
import kotlinx.coroutines.internal.SegmentOrClosed;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.selects.SelectInstance;
import r.n3;
/* loaded from: classes.dex */
public class SemaphoreImpl {
    private volatile int _availablePermits;
    private volatile long deqIdx;
    private volatile long enqIdx;
    private volatile Object head;
    private final Function1<Throwable, Unit> onCancellationRelease;
    private final int permits;
    private volatile Object tail;
    private static final AtomicReferenceFieldUpdater head$FU = AtomicReferenceFieldUpdater.newUpdater(SemaphoreImpl.class, Object.class, "head");
    private static final AtomicLongFieldUpdater deqIdx$FU = AtomicLongFieldUpdater.newUpdater(SemaphoreImpl.class, "deqIdx");
    private static final AtomicReferenceFieldUpdater tail$FU = AtomicReferenceFieldUpdater.newUpdater(SemaphoreImpl.class, Object.class, "tail");
    private static final AtomicLongFieldUpdater enqIdx$FU = AtomicLongFieldUpdater.newUpdater(SemaphoreImpl.class, "enqIdx");
    private static final AtomicIntegerFieldUpdater _availablePermits$FU = AtomicIntegerFieldUpdater.newUpdater(SemaphoreImpl.class, "_availablePermits");

    public SemaphoreImpl(int i, int i5) {
        this.permits = i;
        if (i > 0) {
            if (i5 >= 0 && i5 <= i) {
                SemaphoreSegment semaphoreSegment = new SemaphoreSegment(0L, null, 2);
                this.head = semaphoreSegment;
                this.tail = semaphoreSegment;
                this._availablePermits = i - i5;
                this.onCancellationRelease = new Function1<Throwable, Unit>() { // from class: kotlinx.coroutines.sync.SemaphoreImpl$onCancellationRelease$1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                        invoke2(th);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(Throwable th) {
                        SemaphoreImpl.this.release();
                    }
                };
                return;
            }
            throw new IllegalArgumentException(("The number of acquired permits should be in 0.." + i).toString());
        }
        throw new IllegalArgumentException(("Semaphore should have at least 1 permit, but had " + i).toString());
    }

    private final boolean addAcquireToQueue(Waiter waiter) {
        int i;
        Object findSegmentInternal;
        int i5;
        Symbol symbol;
        Symbol symbol2;
        Symbol symbol3;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = tail$FU;
        SemaphoreSegment semaphoreSegment = (SemaphoreSegment) atomicReferenceFieldUpdater.get(this);
        long andIncrement = enqIdx$FU.getAndIncrement(this);
        SemaphoreImpl$addAcquireToQueue$createNewSegment$1 semaphoreImpl$addAcquireToQueue$createNewSegment$1 = SemaphoreImpl$addAcquireToQueue$createNewSegment$1.INSTANCE;
        i = SemaphoreKt.SEGMENT_SIZE;
        long j2 = andIncrement / i;
        loop0: while (true) {
            findSegmentInternal = ConcurrentLinkedListKt.findSegmentInternal(semaphoreSegment, j2, semaphoreImpl$addAcquireToQueue$createNewSegment$1);
            if (!SegmentOrClosed.m113isClosedimpl(findSegmentInternal)) {
                Segment m112getSegmentimpl = SegmentOrClosed.m112getSegmentimpl(findSegmentInternal);
                while (true) {
                    Segment segment = (Segment) atomicReferenceFieldUpdater.get(this);
                    if (segment.id >= m112getSegmentimpl.id) {
                        break loop0;
                    } else if (!m112getSegmentimpl.tryIncPointers$kotlinx_coroutines_core()) {
                        break;
                    } else if (n3.y(atomicReferenceFieldUpdater, this, segment, m112getSegmentimpl)) {
                        if (segment.decPointers$kotlinx_coroutines_core()) {
                            segment.remove();
                        }
                    } else if (m112getSegmentimpl.decPointers$kotlinx_coroutines_core()) {
                        m112getSegmentimpl.remove();
                    }
                }
            } else {
                break;
            }
        }
        SemaphoreSegment semaphoreSegment2 = (SemaphoreSegment) SegmentOrClosed.m112getSegmentimpl(findSegmentInternal);
        i5 = SemaphoreKt.SEGMENT_SIZE;
        int i6 = (int) (andIncrement % i5);
        if (!y.y(semaphoreSegment2.getAcquirers(), i6, null, waiter)) {
            symbol = SemaphoreKt.PERMIT;
            symbol2 = SemaphoreKt.TAKEN;
            if (y.y(semaphoreSegment2.getAcquirers(), i6, symbol, symbol2)) {
                if (waiter instanceof CancellableContinuation) {
                    Intrinsics.checkNotNull(waiter, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<kotlin.Unit>");
                    ((CancellableContinuation) waiter).resume(Unit.INSTANCE, this.onCancellationRelease);
                } else if (waiter instanceof SelectInstance) {
                    ((SelectInstance) waiter).selectInRegistrationPhase(Unit.INSTANCE);
                } else {
                    throw new IllegalStateException(("unexpected: " + waiter).toString());
                }
                return true;
            } else if (DebugKt.getASSERTIONS_ENABLED()) {
                Object obj = semaphoreSegment2.getAcquirers().get(i6);
                symbol3 = SemaphoreKt.BROKEN;
                if (obj != symbol3) {
                    throw new AssertionError();
                }
                return false;
            } else {
                return false;
            }
        }
        waiter.invokeOnCancellation(semaphoreSegment2, i6);
        return true;
    }

    private final void coerceAvailablePermitsAtMaximum() {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater;
        int i;
        int i5;
        do {
            atomicIntegerFieldUpdater = _availablePermits$FU;
            i = atomicIntegerFieldUpdater.get(this);
            i5 = this.permits;
            if (i <= i5) {
                return;
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, i, i5));
    }

    private final int decPermits() {
        int andDecrement;
        do {
            andDecrement = _availablePermits$FU.getAndDecrement(this);
        } while (andDecrement > this.permits);
        return andDecrement;
    }

    private final boolean tryResumeAcquire(Object obj) {
        if (obj instanceof CancellableContinuation) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<kotlin.Unit>");
            CancellableContinuation cancellableContinuation = (CancellableContinuation) obj;
            Object tryResume = cancellableContinuation.tryResume(Unit.INSTANCE, null, this.onCancellationRelease);
            if (tryResume != null) {
                cancellableContinuation.completeResume(tryResume);
                return true;
            }
            return false;
        } else if (obj instanceof SelectInstance) {
            return ((SelectInstance) obj).trySelect(this, Unit.INSTANCE);
        } else {
            throw new IllegalStateException(("unexpected: " + obj).toString());
        }
    }

    private final boolean tryResumeNextFromQueue() {
        int i;
        Object findSegmentInternal;
        int i5;
        Symbol symbol;
        Symbol symbol2;
        int i6;
        Symbol symbol3;
        Symbol symbol4;
        Symbol symbol5;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = head$FU;
        SemaphoreSegment semaphoreSegment = (SemaphoreSegment) atomicReferenceFieldUpdater.get(this);
        long andIncrement = deqIdx$FU.getAndIncrement(this);
        i = SemaphoreKt.SEGMENT_SIZE;
        long j2 = andIncrement / i;
        SemaphoreImpl$tryResumeNextFromQueue$createNewSegment$1 semaphoreImpl$tryResumeNextFromQueue$createNewSegment$1 = SemaphoreImpl$tryResumeNextFromQueue$createNewSegment$1.INSTANCE;
        loop0: while (true) {
            findSegmentInternal = ConcurrentLinkedListKt.findSegmentInternal(semaphoreSegment, j2, semaphoreImpl$tryResumeNextFromQueue$createNewSegment$1);
            if (SegmentOrClosed.m113isClosedimpl(findSegmentInternal)) {
                break;
            }
            Segment m112getSegmentimpl = SegmentOrClosed.m112getSegmentimpl(findSegmentInternal);
            while (true) {
                Segment segment = (Segment) atomicReferenceFieldUpdater.get(this);
                if (segment.id >= m112getSegmentimpl.id) {
                    break loop0;
                } else if (!m112getSegmentimpl.tryIncPointers$kotlinx_coroutines_core()) {
                    break;
                } else if (n3.y(atomicReferenceFieldUpdater, this, segment, m112getSegmentimpl)) {
                    if (segment.decPointers$kotlinx_coroutines_core()) {
                        segment.remove();
                    }
                } else if (m112getSegmentimpl.decPointers$kotlinx_coroutines_core()) {
                    m112getSegmentimpl.remove();
                }
            }
        }
        SemaphoreSegment semaphoreSegment2 = (SemaphoreSegment) SegmentOrClosed.m112getSegmentimpl(findSegmentInternal);
        semaphoreSegment2.cleanPrev();
        if (semaphoreSegment2.id <= j2) {
            i5 = SemaphoreKt.SEGMENT_SIZE;
            int i8 = (int) (andIncrement % i5);
            symbol = SemaphoreKt.PERMIT;
            Object andSet = semaphoreSegment2.getAcquirers().getAndSet(i8, symbol);
            if (andSet == null) {
                i6 = SemaphoreKt.MAX_SPIN_CYCLES;
                for (int i10 = 0; i10 < i6; i10++) {
                    Object obj = semaphoreSegment2.getAcquirers().get(i8);
                    symbol5 = SemaphoreKt.TAKEN;
                    if (obj == symbol5) {
                        return true;
                    }
                }
                symbol3 = SemaphoreKt.PERMIT;
                symbol4 = SemaphoreKt.BROKEN;
                return !y.y(semaphoreSegment2.getAcquirers(), i8, symbol3, symbol4);
            }
            symbol2 = SemaphoreKt.CANCELLED;
            if (andSet == symbol2) {
                return false;
            }
            return tryResumeAcquire(andSet);
        }
        return false;
    }

    public final void acquire(CancellableContinuation<? super Unit> cancellableContinuation) {
        while (decPermits() <= 0) {
            Intrinsics.checkNotNull(cancellableContinuation, "null cannot be cast to non-null type kotlinx.coroutines.Waiter");
            if (addAcquireToQueue((Waiter) cancellableContinuation)) {
                return;
            }
        }
        cancellableContinuation.resume(Unit.INSTANCE, this.onCancellationRelease);
    }

    public int getAvailablePermits() {
        return Math.max(_availablePermits$FU.get(this), 0);
    }

    public void release() {
        do {
            int andIncrement = _availablePermits$FU.getAndIncrement(this);
            if (andIncrement < this.permits) {
                if (andIncrement >= 0) {
                    return;
                }
            } else {
                coerceAvailablePermitsAtMaximum();
                throw new IllegalStateException(("The number of released permits cannot be greater than " + this.permits).toString());
            }
        } while (!tryResumeNextFromQueue());
    }

    public boolean tryAcquire() {
        while (true) {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = _availablePermits$FU;
            int i = atomicIntegerFieldUpdater.get(this);
            if (i > this.permits) {
                coerceAvailablePermitsAtMaximum();
            } else if (i <= 0) {
                return false;
            } else {
                if (atomicIntegerFieldUpdater.compareAndSet(this, i, i - 1)) {
                    return true;
                }
            }
        }
    }
}
