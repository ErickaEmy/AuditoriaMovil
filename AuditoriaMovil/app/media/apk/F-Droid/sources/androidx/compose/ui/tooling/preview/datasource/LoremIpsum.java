package androidx.compose.ui.tooling.preview.datasource;

import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt__SequencesKt;
import kotlin.sequences.SequencesKt___SequencesKt;
/* compiled from: LoremIpsum.kt */
/* loaded from: classes.dex */
public final class LoremIpsum {
    private final int words;

    public LoremIpsum(int i) {
        this.words = i;
    }

    public Sequence getValues() {
        Sequence sequenceOf;
        sequenceOf = SequencesKt__SequencesKt.sequenceOf(generateLoremIpsum(this.words));
        return sequenceOf;
    }

    private final String generateLoremIpsum(int i) {
        List list;
        Sequence generateSequence;
        Sequence take;
        String joinToString$default;
        final Ref$IntRef ref$IntRef = new Ref$IntRef();
        list = LoremIpsumKt.LOREM_IPSUM_SOURCE;
        final int size = list.size();
        generateSequence = SequencesKt__SequencesKt.generateSequence(new Function0() { // from class: androidx.compose.ui.tooling.preview.datasource.LoremIpsum$generateLoremIpsum$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                List list2;
                list2 = LoremIpsumKt.LOREM_IPSUM_SOURCE;
                Ref$IntRef ref$IntRef2 = Ref$IntRef.this;
                int i2 = ref$IntRef2.element;
                ref$IntRef2.element = i2 + 1;
                return (String) list2.get(i2 % size);
            }
        });
        take = SequencesKt___SequencesKt.take(generateSequence, i);
        joinToString$default = SequencesKt___SequencesKt.joinToString$default(take, " ", null, null, 0, null, null, 62, null);
        return joinToString$default;
    }
}
