package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.internal.ConcurrentLinkedListNode;
import r.n3;
/* loaded from: classes.dex */
public abstract class ConcurrentLinkedListNode<N extends ConcurrentLinkedListNode<N>> {
    private static final AtomicReferenceFieldUpdater _next$FU = AtomicReferenceFieldUpdater.newUpdater(ConcurrentLinkedListNode.class, Object.class, "_next");
    private static final AtomicReferenceFieldUpdater _prev$FU = AtomicReferenceFieldUpdater.newUpdater(ConcurrentLinkedListNode.class, Object.class, "_prev");
    private volatile Object _next;
    private volatile Object _prev;

    public ConcurrentLinkedListNode(N n2) {
        this._prev = n2;
    }

    private final N getAliveSegmentLeft() {
        N prev = getPrev();
        while (prev != null && prev.isRemoved()) {
            prev = (N) _prev$FU.get(prev);
        }
        return prev;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [kotlinx.coroutines.internal.ConcurrentLinkedListNode] */
    private final N getAliveSegmentRight() {
        if (DebugKt.getASSERTIONS_ENABLED() && isTail()) {
            throw new AssertionError();
        }
        N next = getNext();
        Intrinsics.checkNotNull(next);
        while (next.isRemoved()) {
            ?? next2 = next.getNext();
            if (next2 == 0) {
                return next;
            }
            next = next2;
        }
        return next;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object getNextOrClosed() {
        return _next$FU.get(this);
    }

    public final void cleanPrev() {
        _prev$FU.lazySet(this, null);
    }

    public final N getNext() {
        Object nextOrClosed = getNextOrClosed();
        if (nextOrClosed == ConcurrentLinkedListKt.access$getCLOSED$p()) {
            return null;
        }
        return (N) nextOrClosed;
    }

    public final N getPrev() {
        return (N) _prev$FU.get(this);
    }

    public abstract boolean isRemoved();

    public final boolean isTail() {
        if (getNext() == null) {
            return true;
        }
        return false;
    }

    public final boolean markAsClosed() {
        return n3.y(_next$FU, this, null, ConcurrentLinkedListKt.access$getCLOSED$p());
    }

    public final void remove() {
        Object obj;
        N n2;
        if (DebugKt.getASSERTIONS_ENABLED() && !isRemoved() && !isTail()) {
            throw new AssertionError();
        }
        if (isTail()) {
            return;
        }
        while (true) {
            N aliveSegmentLeft = getAliveSegmentLeft();
            N aliveSegmentRight = getAliveSegmentRight();
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _prev$FU;
            do {
                obj = atomicReferenceFieldUpdater.get(aliveSegmentRight);
                if (((ConcurrentLinkedListNode) obj) == null) {
                    n2 = null;
                } else {
                    n2 = aliveSegmentLeft;
                }
            } while (!n3.y(atomicReferenceFieldUpdater, aliveSegmentRight, obj, n2));
            if (aliveSegmentLeft != null) {
                _next$FU.set(aliveSegmentLeft, aliveSegmentRight);
            }
            if (!aliveSegmentRight.isRemoved() || aliveSegmentRight.isTail()) {
                if (aliveSegmentLeft == null || !aliveSegmentLeft.isRemoved()) {
                    return;
                }
            }
        }
    }

    public final boolean trySetNext(N n2) {
        return n3.y(_next$FU, this, null, n2);
    }
}
