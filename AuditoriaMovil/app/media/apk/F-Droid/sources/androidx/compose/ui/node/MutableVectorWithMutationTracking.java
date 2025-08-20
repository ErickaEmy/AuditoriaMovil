package androidx.compose.ui.node;

import androidx.compose.runtime.collection.MutableVector;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: MutableVectorWithMutationTracking.kt */
/* loaded from: classes.dex */
public final class MutableVectorWithMutationTracking {
    private final Function0 onVectorMutated;
    private final MutableVector vector;

    public final MutableVector getVector() {
        return this.vector;
    }

    public MutableVectorWithMutationTracking(MutableVector vector, Function0 onVectorMutated) {
        Intrinsics.checkNotNullParameter(vector, "vector");
        Intrinsics.checkNotNullParameter(onVectorMutated, "onVectorMutated");
        this.vector = vector;
        this.onVectorMutated = onVectorMutated;
    }

    public final int getSize() {
        return this.vector.getSize();
    }

    public final void clear() {
        this.vector.clear();
        this.onVectorMutated.invoke();
    }

    public final void add(int i, Object obj) {
        this.vector.add(i, obj);
        this.onVectorMutated.invoke();
    }

    public final Object removeAt(int i) {
        Object removeAt = this.vector.removeAt(i);
        this.onVectorMutated.invoke();
        return removeAt;
    }

    public final List asList() {
        return this.vector.asMutableList();
    }

    public final Object get(int i) {
        return this.vector.getContent()[i];
    }
}
