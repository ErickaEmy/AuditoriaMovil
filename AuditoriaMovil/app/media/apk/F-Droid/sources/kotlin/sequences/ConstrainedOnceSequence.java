package kotlin.sequences;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: SequencesJVM.kt */
/* loaded from: classes2.dex */
public final class ConstrainedOnceSequence implements Sequence {
    private final AtomicReference sequenceRef;

    public ConstrainedOnceSequence(Sequence sequence) {
        Intrinsics.checkNotNullParameter(sequence, "sequence");
        this.sequenceRef = new AtomicReference(sequence);
    }

    @Override // kotlin.sequences.Sequence
    public Iterator iterator() {
        Sequence sequence = (Sequence) this.sequenceRef.getAndSet(null);
        if (sequence == null) {
            throw new IllegalStateException("This sequence can be consumed only once.");
        }
        return sequence.iterator();
    }
}
