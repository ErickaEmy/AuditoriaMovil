package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import r.n3;
/* loaded from: classes.dex */
public class LockFreeTaskQueue<E> {
    private static final AtomicReferenceFieldUpdater _cur$FU = AtomicReferenceFieldUpdater.newUpdater(LockFreeTaskQueue.class, Object.class, "_cur");
    private volatile Object _cur;

    public LockFreeTaskQueue(boolean z2) {
        this._cur = new LockFreeTaskQueueCore(8, z2);
    }

    public final boolean addLast(E e2) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _cur$FU;
        while (true) {
            LockFreeTaskQueueCore lockFreeTaskQueueCore = (LockFreeTaskQueueCore) atomicReferenceFieldUpdater.get(this);
            int addLast = lockFreeTaskQueueCore.addLast(e2);
            if (addLast == 0) {
                return true;
            }
            if (addLast != 1) {
                if (addLast == 2) {
                    return false;
                }
            } else {
                n3.y(_cur$FU, this, lockFreeTaskQueueCore, lockFreeTaskQueueCore.next());
            }
        }
    }

    public final void close() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _cur$FU;
        while (true) {
            LockFreeTaskQueueCore lockFreeTaskQueueCore = (LockFreeTaskQueueCore) atomicReferenceFieldUpdater.get(this);
            if (lockFreeTaskQueueCore.close()) {
                return;
            }
            n3.y(_cur$FU, this, lockFreeTaskQueueCore, lockFreeTaskQueueCore.next());
        }
    }

    public final int getSize() {
        return ((LockFreeTaskQueueCore) _cur$FU.get(this)).getSize();
    }

    public final E removeFirstOrNull() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _cur$FU;
        while (true) {
            LockFreeTaskQueueCore lockFreeTaskQueueCore = (LockFreeTaskQueueCore) atomicReferenceFieldUpdater.get(this);
            E e2 = (E) lockFreeTaskQueueCore.removeFirstOrNull();
            if (e2 != LockFreeTaskQueueCore.REMOVE_FROZEN) {
                return e2;
            }
            n3.y(_cur$FU, this, lockFreeTaskQueueCore, lockFreeTaskQueueCore.next());
        }
    }
}
