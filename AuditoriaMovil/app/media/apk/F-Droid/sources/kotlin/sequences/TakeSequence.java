package kotlin.sequences;

import ch.qos.logback.core.CoreConstants;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: Sequences.kt */
/* loaded from: classes2.dex */
public final class TakeSequence implements Sequence, DropTakeSequence {
    private final int count;
    private final Sequence sequence;

    public TakeSequence(Sequence sequence, int i) {
        Intrinsics.checkNotNullParameter(sequence, "sequence");
        this.sequence = sequence;
        this.count = i;
        if (i >= 0) {
            return;
        }
        throw new IllegalArgumentException(("count must be non-negative, but was " + i + CoreConstants.DOT).toString());
    }

    @Override // kotlin.sequences.DropTakeSequence
    public Sequence drop(int i) {
        int i2 = this.count;
        return i >= i2 ? SequencesKt.emptySequence() : new SubSequence(this.sequence, i, i2);
    }

    @Override // kotlin.sequences.DropTakeSequence
    public Sequence take(int i) {
        return i >= this.count ? this : new TakeSequence(this.sequence, i);
    }

    @Override // kotlin.sequences.Sequence
    public Iterator iterator() {
        return new TakeSequence$iterator$1(this);
    }
}
