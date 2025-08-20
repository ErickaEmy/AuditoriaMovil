package kotlin.sequences;

import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: Sequences.kt */
/* loaded from: classes2.dex */
public final class SubSequence implements Sequence, DropTakeSequence {
    private final int endIndex;
    private final Sequence sequence;
    private final int startIndex;

    private final int getCount() {
        return this.endIndex - this.startIndex;
    }

    public SubSequence(Sequence sequence, int i, int i2) {
        Intrinsics.checkNotNullParameter(sequence, "sequence");
        this.sequence = sequence;
        this.startIndex = i;
        this.endIndex = i2;
        if (i < 0) {
            throw new IllegalArgumentException(("startIndex should be non-negative, but is " + i).toString());
        } else if (i2 < 0) {
            throw new IllegalArgumentException(("endIndex should be non-negative, but is " + i2).toString());
        } else if (i2 >= i) {
        } else {
            throw new IllegalArgumentException(("endIndex should be not less than startIndex, but was " + i2 + " < " + i).toString());
        }
    }

    @Override // kotlin.sequences.DropTakeSequence
    public Sequence drop(int i) {
        return i >= getCount() ? SequencesKt.emptySequence() : new SubSequence(this.sequence, this.startIndex + i, this.endIndex);
    }

    @Override // kotlin.sequences.DropTakeSequence
    public Sequence take(int i) {
        if (i >= getCount()) {
            return this;
        }
        Sequence sequence = this.sequence;
        int i2 = this.startIndex;
        return new SubSequence(sequence, i2, i + i2);
    }

    @Override // kotlin.sequences.Sequence
    public Iterator iterator() {
        return new SubSequence$iterator$1(this);
    }
}
