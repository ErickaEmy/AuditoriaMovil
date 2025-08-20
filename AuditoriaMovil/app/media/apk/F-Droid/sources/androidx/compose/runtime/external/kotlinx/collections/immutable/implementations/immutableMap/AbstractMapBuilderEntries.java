package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap;

import java.util.Map;
import kotlin.collections.AbstractMutableSet;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: PersistentHashMapBuilderContentViews.kt */
/* loaded from: classes.dex */
public abstract class AbstractMapBuilderEntries extends AbstractMutableSet {
    public abstract boolean containsEntry(Map.Entry entry);

    public abstract boolean removeEntry(Map.Entry entry);

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof Map.Entry) {
            return contains((Map.Entry) obj);
        }
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final /* bridge */ boolean remove(Object obj) {
        if (obj instanceof Map.Entry) {
            return remove((Map.Entry) obj);
        }
        return false;
    }

    public final boolean contains(Map.Entry element) {
        Intrinsics.checkNotNullParameter(element, "element");
        if ((element instanceof Object ? element : null) instanceof Map.Entry) {
            return containsEntry(element);
        }
        return false;
    }

    public final boolean remove(Map.Entry element) {
        Intrinsics.checkNotNullParameter(element, "element");
        if ((element instanceof Object ? element : null) instanceof Map.Entry) {
            return removeEntry(element);
        }
        return false;
    }
}
