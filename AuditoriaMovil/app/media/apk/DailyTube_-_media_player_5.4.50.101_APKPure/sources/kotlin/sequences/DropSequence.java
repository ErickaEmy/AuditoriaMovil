package kotlin.sequences;

import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public final class DropSequence<T> implements Sequence<T>, DropTakeSequence<T> {
    private final int count;
    private final Sequence<T> sequence;

    /* JADX WARN: Multi-variable type inference failed */
    public DropSequence(Sequence<? extends T> sequence, int i) {
        Intrinsics.checkNotNullParameter(sequence, "sequence");
        this.sequence = sequence;
        this.count = i;
        if (i >= 0) {
            return;
        }
        throw new IllegalArgumentException(("count must be non-negative, but was " + i + '.').toString());
    }

    @Override // kotlin.sequences.DropTakeSequence
    public Sequence<T> drop(int i) {
        int i5 = this.count + i;
        if (i5 < 0) {
            return new DropSequence(this, i);
        }
        return new DropSequence(this.sequence, i5);
    }

    @Override // kotlin.sequences.Sequence
    public Iterator<T> iterator() {
        return new DropSequence$iterator$1(this);
    }
}
