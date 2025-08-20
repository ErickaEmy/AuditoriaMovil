package kotlin.collections;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.markers.KMappedMarker;
/* compiled from: AbstractIterator.kt */
/* loaded from: classes.dex */
public abstract class AbstractIterator implements Iterator, KMappedMarker {
    private Object nextValue;
    private State state = State.NotReady;

    /* compiled from: AbstractIterator.kt */
    /* loaded from: classes.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[State.values().length];
            try {
                iArr[State.Done.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[State.Ready.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    protected abstract void computeNext();

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        State state = this.state;
        if (state == State.Failed) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        int i = WhenMappings.$EnumSwitchMapping$0[state.ordinal()];
        if (i != 1) {
            if (i != 2) {
                return tryToComputeNext();
            }
            return true;
        }
        return false;
    }

    @Override // java.util.Iterator
    public Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        this.state = State.NotReady;
        return this.nextValue;
    }

    private final boolean tryToComputeNext() {
        this.state = State.Failed;
        computeNext();
        return this.state == State.Ready;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void setNext(Object obj) {
        this.nextValue = obj;
        this.state = State.Ready;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void done() {
        this.state = State.Done;
    }
}
