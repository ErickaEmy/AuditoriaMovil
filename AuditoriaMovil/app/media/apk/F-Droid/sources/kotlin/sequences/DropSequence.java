package kotlin.sequences;

import ch.qos.logback.core.CoreConstants;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: Sequences.kt */
/* loaded from: classes2.dex */
public final class DropSequence implements Sequence, DropTakeSequence {
    private final int count;
    private final Sequence sequence;

    public DropSequence(Sequence sequence, int i) {
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
        int i2 = this.count + i;
        return i2 < 0 ? new DropSequence(this, i) : new DropSequence(this.sequence, i2);
    }

    @Override // kotlin.sequences.DropTakeSequence
    public Sequence take(int i) {
        int i2 = this.count;
        int i3 = i2 + i;
        return i3 < 0 ? new TakeSequence(this, i) : new SubSequence(this.sequence, i2, i3);
    }

    @Override // kotlin.sequences.Sequence
    public Iterator iterator() {
        return new DropSequence$iterator$1(this);
    }
}
