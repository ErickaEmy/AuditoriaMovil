package androidx.core.view;

import android.view.View;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt__SequenceBuilderKt;
import kotlin.sequences.SequencesKt__SequencesKt;
/* compiled from: View.kt */
/* loaded from: classes.dex */
public abstract class ViewKt {
    public static final Sequence getAncestors(View view) {
        Sequence generateSequence;
        generateSequence = SequencesKt__SequencesKt.generateSequence(view.getParent(), ViewKt$ancestors$1.INSTANCE);
        return generateSequence;
    }

    public static final Sequence getAllViews(View view) {
        Sequence sequence;
        sequence = SequencesKt__SequenceBuilderKt.sequence(new ViewKt$allViews$1(view, null));
        return sequence;
    }
}
