package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap;

import androidx.compose.runtime.external.kotlinx.collections.immutable.ImmutableSet;
import java.util.Iterator;
import java.util.Map;
import kotlin.collections.AbstractSet;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: PersistentHashMapContentViews.kt */
/* loaded from: classes.dex */
public final class PersistentHashMapEntries extends AbstractSet implements ImmutableSet {
    private final PersistentHashMap map;

    public PersistentHashMapEntries(PersistentHashMap map) {
        Intrinsics.checkNotNullParameter(map, "map");
        this.map = map;
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof Map.Entry) {
            return contains((Map.Entry) obj);
        }
        return false;
    }

    @Override // kotlin.collections.AbstractCollection
    public int getSize() {
        return this.map.size();
    }

    public boolean contains(Map.Entry element) {
        Intrinsics.checkNotNullParameter(element, "element");
        Object obj = this.map.get(element.getKey());
        return obj != null ? Intrinsics.areEqual(obj, element.getValue()) : element.getValue() == null && this.map.containsKey(element.getKey());
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator iterator() {
        return new PersistentHashMapEntriesIterator(this.map.getNode$runtime_release());
    }
}
