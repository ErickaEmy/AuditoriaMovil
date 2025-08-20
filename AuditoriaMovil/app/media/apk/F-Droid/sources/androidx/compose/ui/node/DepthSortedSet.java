package androidx.compose.ui.node;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: DepthSortedSet.kt */
/* loaded from: classes.dex */
public final class DepthSortedSet {
    private final Comparator DepthComparator;
    private final boolean extraAssertions;
    private final Lazy mapOfOriginalDepth$delegate;
    private final TreeSet set;

    public DepthSortedSet(boolean z) {
        Lazy lazy;
        this.extraAssertions = z;
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, new Function0() { // from class: androidx.compose.ui.node.DepthSortedSet$mapOfOriginalDepth$2
            @Override // kotlin.jvm.functions.Function0
            public final Map invoke() {
                return new LinkedHashMap();
            }
        });
        this.mapOfOriginalDepth$delegate = lazy;
        Comparator comparator = new Comparator() { // from class: androidx.compose.ui.node.DepthSortedSet$DepthComparator$1
            @Override // java.util.Comparator
            public int compare(LayoutNode l1, LayoutNode l2) {
                Intrinsics.checkNotNullParameter(l1, "l1");
                Intrinsics.checkNotNullParameter(l2, "l2");
                int compare = Intrinsics.compare(l1.getDepth$ui_release(), l2.getDepth$ui_release());
                return compare != 0 ? compare : Intrinsics.compare(l1.hashCode(), l2.hashCode());
            }
        };
        this.DepthComparator = comparator;
        this.set = new TreeSet(comparator);
    }

    private final Map getMapOfOriginalDepth() {
        return (Map) this.mapOfOriginalDepth$delegate.getValue();
    }

    public final boolean contains(LayoutNode node) {
        Intrinsics.checkNotNullParameter(node, "node");
        boolean contains = this.set.contains(node);
        if (!this.extraAssertions || contains == getMapOfOriginalDepth().containsKey(node)) {
            return contains;
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    public final void add(LayoutNode node) {
        Intrinsics.checkNotNullParameter(node, "node");
        if (!node.isAttached()) {
            throw new IllegalStateException("Check failed.".toString());
        }
        if (this.extraAssertions) {
            Integer num = (Integer) getMapOfOriginalDepth().get(node);
            if (num == null) {
                getMapOfOriginalDepth().put(node, Integer.valueOf(node.getDepth$ui_release()));
            } else {
                if (num.intValue() != node.getDepth$ui_release()) {
                    throw new IllegalStateException("Check failed.".toString());
                }
            }
        }
        this.set.add(node);
    }

    public final boolean remove(LayoutNode node) {
        Intrinsics.checkNotNullParameter(node, "node");
        if (!node.isAttached()) {
            throw new IllegalStateException("Check failed.".toString());
        }
        boolean remove = this.set.remove(node);
        if (this.extraAssertions) {
            Integer num = (Integer) getMapOfOriginalDepth().remove(node);
            if (remove) {
                int depth$ui_release = node.getDepth$ui_release();
                if (num == null || num.intValue() != depth$ui_release) {
                    throw new IllegalStateException("Check failed.".toString());
                }
            } else if (num != null) {
                throw new IllegalStateException("Check failed.".toString());
            }
        }
        return remove;
    }

    public final LayoutNode pop() {
        LayoutNode node = (LayoutNode) this.set.first();
        Intrinsics.checkNotNullExpressionValue(node, "node");
        remove(node);
        return node;
    }

    public final boolean isEmpty() {
        return this.set.isEmpty();
    }

    public String toString() {
        String obj = this.set.toString();
        Intrinsics.checkNotNullExpressionValue(obj, "set.toString()");
        return obj;
    }
}
