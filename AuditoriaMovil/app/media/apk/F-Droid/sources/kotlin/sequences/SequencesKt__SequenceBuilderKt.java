package kotlin.sequences;

import java.util.Iterator;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SequenceBuilder.kt */
/* loaded from: classes2.dex */
public abstract class SequencesKt__SequenceBuilderKt {
    public static Sequence sequence(final Function2 block) {
        Intrinsics.checkNotNullParameter(block, "block");
        return new Sequence() { // from class: kotlin.sequences.SequencesKt__SequenceBuilderKt$sequence$$inlined$Sequence$1
            @Override // kotlin.sequences.Sequence
            public Iterator iterator() {
                Iterator it;
                it = SequencesKt__SequenceBuilderKt.iterator(Function2.this);
                return it;
            }
        };
    }

    public static Iterator iterator(Function2 block) {
        Continuation createCoroutineUnintercepted;
        Intrinsics.checkNotNullParameter(block, "block");
        SequenceBuilderIterator sequenceBuilderIterator = new SequenceBuilderIterator();
        createCoroutineUnintercepted = IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted(block, sequenceBuilderIterator, sequenceBuilderIterator);
        sequenceBuilderIterator.setNextStep(createCoroutineUnintercepted);
        return sequenceBuilderIterator;
    }
}
