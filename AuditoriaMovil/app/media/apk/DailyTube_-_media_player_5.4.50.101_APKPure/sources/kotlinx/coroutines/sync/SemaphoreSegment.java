package kotlinx.coroutines.sync;

import java.util.concurrent.atomic.AtomicReferenceArray;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.internal.Segment;
import kotlinx.coroutines.internal.Symbol;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class SemaphoreSegment extends Segment<SemaphoreSegment> {
    private final AtomicReferenceArray acquirers;

    public SemaphoreSegment(long j2, SemaphoreSegment semaphoreSegment, int i) {
        super(j2, semaphoreSegment, i);
        int i5;
        i5 = SemaphoreKt.SEGMENT_SIZE;
        this.acquirers = new AtomicReferenceArray(i5);
    }

    public final AtomicReferenceArray getAcquirers() {
        return this.acquirers;
    }

    @Override // kotlinx.coroutines.internal.Segment
    public int getNumberOfSlots() {
        int i;
        i = SemaphoreKt.SEGMENT_SIZE;
        return i;
    }

    @Override // kotlinx.coroutines.internal.Segment
    public void onCancellation(int i, Throwable th, CoroutineContext coroutineContext) {
        Symbol symbol;
        symbol = SemaphoreKt.CANCELLED;
        getAcquirers().set(i, symbol);
        onSlotCleaned();
    }

    public String toString() {
        return "SemaphoreSegment[id=" + this.id + ", hashCode=" + hashCode() + ']';
    }
}
