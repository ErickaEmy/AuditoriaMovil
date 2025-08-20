package kotlin.collections;

import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
/* loaded from: classes.dex */
public final class SlidingWindowKt {
    public static final void checkWindowSizeStep(int i, int i5) {
        String str;
        if (i > 0 && i5 > 0) {
            return;
        }
        if (i != i5) {
            str = "Both size " + i + " and step " + i5 + " must be greater than zero.";
        } else {
            str = "size " + i + " must be greater than zero.";
        }
        throw new IllegalArgumentException(str.toString());
    }

    public static final <T> Iterator<List<T>> windowedIterator(Iterator<? extends T> iterator, int i, int i5, boolean z2, boolean z3) {
        Intrinsics.checkNotNullParameter(iterator, "iterator");
        if (!iterator.hasNext()) {
            return EmptyIterator.INSTANCE;
        }
        return SequencesKt.iterator(new SlidingWindowKt$windowedIterator$1(i, i5, iterator, z3, z2, null));
    }
}
