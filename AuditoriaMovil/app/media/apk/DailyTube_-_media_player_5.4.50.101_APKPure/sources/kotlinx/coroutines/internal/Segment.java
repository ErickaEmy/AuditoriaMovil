package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.NotCompleted;
import kotlinx.coroutines.internal.Segment;
/* loaded from: classes.dex */
public abstract class Segment<S extends Segment<S>> extends ConcurrentLinkedListNode<S> implements NotCompleted {
    private static final AtomicIntegerFieldUpdater cleanedAndPointers$FU = AtomicIntegerFieldUpdater.newUpdater(Segment.class, "cleanedAndPointers");
    private volatile int cleanedAndPointers;
    public final long id;

    public Segment(long j2, S s2, int i) {
        super(s2);
        this.id = j2;
        this.cleanedAndPointers = i << 16;
    }

    public final boolean decPointers$kotlinx_coroutines_core() {
        if (cleanedAndPointers$FU.addAndGet(this, -65536) == getNumberOfSlots() && !isTail()) {
            return true;
        }
        return false;
    }

    public abstract int getNumberOfSlots();

    @Override // kotlinx.coroutines.internal.ConcurrentLinkedListNode
    public boolean isRemoved() {
        if (cleanedAndPointers$FU.get(this) == getNumberOfSlots() && !isTail()) {
            return true;
        }
        return false;
    }

    public abstract void onCancellation(int i, Throwable th, CoroutineContext coroutineContext);

    public final void onSlotCleaned() {
        if (cleanedAndPointers$FU.incrementAndGet(this) == getNumberOfSlots()) {
            remove();
        }
    }

    public final boolean tryIncPointers$kotlinx_coroutines_core() {
        int i;
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = cleanedAndPointers$FU;
        do {
            i = atomicIntegerFieldUpdater.get(this);
            if (i == getNumberOfSlots() && !isTail()) {
                return false;
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, i, 65536 + i));
        return true;
    }
}
