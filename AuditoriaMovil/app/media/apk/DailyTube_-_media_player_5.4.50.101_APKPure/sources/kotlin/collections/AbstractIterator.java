package kotlin.collections;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.markers.KMappedMarker;
/* loaded from: classes.dex */
public abstract class AbstractIterator<T> implements Iterator<T>, KMappedMarker {
    private T nextValue;
    private State state = State.NotReady;

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

    private final boolean tryToComputeNext() {
        this.state = State.Failed;
        computeNext();
        if (this.state == State.Ready) {
            return true;
        }
        return false;
    }

    public abstract void computeNext();

    public final void done() {
        this.state = State.Done;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        State state = this.state;
        if (state != State.Failed) {
            int i = WhenMappings.$EnumSwitchMapping$0[state.ordinal()];
            if (i != 1) {
                if (i == 2) {
                    return true;
                }
                return tryToComputeNext();
            }
            return false;
        }
        throw new IllegalArgumentException("Failed requirement.");
    }

    @Override // java.util.Iterator
    public T next() {
        if (hasNext()) {
            this.state = State.NotReady;
            return this.nextValue;
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final void setNext(T t2) {
        this.nextValue = t2;
        this.state = State.Ready;
    }
}
