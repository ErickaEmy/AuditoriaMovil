package androidx.compose.ui.node;

import kotlin.jvm.internal.Intrinsics;
/* compiled from: DepthSortedSet.kt */
/* loaded from: classes.dex */
public final class DepthSortedSetsForDifferentPasses {
    private final DepthSortedSet lookaheadSet;
    private final DepthSortedSet set;

    public DepthSortedSetsForDifferentPasses(boolean z) {
        this.lookaheadSet = new DepthSortedSet(z);
        this.set = new DepthSortedSet(z);
    }

    public final boolean contains(LayoutNode node, boolean z) {
        Intrinsics.checkNotNullParameter(node, "node");
        boolean contains = this.lookaheadSet.contains(node);
        return z ? contains : contains || this.set.contains(node);
    }

    public final boolean contains(LayoutNode node) {
        Intrinsics.checkNotNullParameter(node, "node");
        return this.lookaheadSet.contains(node) || this.set.contains(node);
    }

    public final void add(LayoutNode node, boolean z) {
        Intrinsics.checkNotNullParameter(node, "node");
        if (z) {
            this.lookaheadSet.add(node);
        } else if (this.lookaheadSet.contains(node)) {
        } else {
            this.set.add(node);
        }
    }

    public final boolean remove(LayoutNode node, boolean z) {
        Intrinsics.checkNotNullParameter(node, "node");
        if (z) {
            return this.lookaheadSet.remove(node);
        }
        return this.set.remove(node);
    }

    public final boolean remove(LayoutNode node) {
        Intrinsics.checkNotNullParameter(node, "node");
        return this.set.remove(node) || this.lookaheadSet.remove(node);
    }

    public final boolean isEmpty() {
        return this.set.isEmpty() && this.lookaheadSet.isEmpty();
    }

    public final boolean isNotEmpty() {
        return !isEmpty();
    }
}
