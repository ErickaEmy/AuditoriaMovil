package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.persistentOrderedSet;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
/* compiled from: PersistentOrderedSetIterator.kt */
/* loaded from: classes.dex */
public class PersistentOrderedSetIterator implements Iterator, KMappedMarker {
    private int index;
    private final Map map;
    private Object nextElement;

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public PersistentOrderedSetIterator(Object obj, Map map) {
        Intrinsics.checkNotNullParameter(map, "map");
        this.nextElement = obj;
        this.map = map;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.index < this.map.size();
    }

    @Override // java.util.Iterator
    public Object next() {
        checkHasNext();
        Object obj = this.nextElement;
        this.index++;
        Object obj2 = this.map.get(obj);
        if (obj2 == null) {
            throw new ConcurrentModificationException("Hash code of an element (" + obj + ") has changed after it was added to the persistent set.");
        }
        this.nextElement = ((Links) obj2).getNext();
        return obj;
    }

    private final void checkHasNext() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
    }
}
