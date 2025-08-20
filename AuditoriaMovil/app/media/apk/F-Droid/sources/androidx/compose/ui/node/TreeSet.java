package androidx.compose.ui.node;

import java.util.Comparator;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: JvmTreeSet.jvm.kt */
/* loaded from: classes.dex */
public final class TreeSet extends java.util.TreeSet {
    public /* bridge */ int getSize() {
        return super.size();
    }

    @Override // java.util.TreeSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final /* bridge */ int size() {
        return getSize();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TreeSet(Comparator comparator) {
        super(comparator);
        Intrinsics.checkNotNullParameter(comparator, "comparator");
    }
}
