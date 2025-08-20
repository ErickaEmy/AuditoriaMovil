package kotlin.sequences;

import java.util.Iterator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public final class TransformingSequence<T, R> implements Sequence<R> {
    private final Sequence<T> sequence;
    private final Function1<T, R> transformer;

    /* JADX WARN: Multi-variable type inference failed */
    public TransformingSequence(Sequence<? extends T> sequence, Function1<? super T, ? extends R> transformer) {
        Intrinsics.checkNotNullParameter(sequence, "sequence");
        Intrinsics.checkNotNullParameter(transformer, "transformer");
        this.sequence = sequence;
        this.transformer = transformer;
    }

    public final <E> Sequence<E> flatten$kotlin_stdlib(Function1<? super R, ? extends Iterator<? extends E>> iterator) {
        Intrinsics.checkNotNullParameter(iterator, "iterator");
        return new FlatteningSequence(this.sequence, this.transformer, iterator);
    }

    @Override // kotlin.sequences.Sequence
    public Iterator<R> iterator() {
        return new TransformingSequence$iterator$1(this);
    }
}
