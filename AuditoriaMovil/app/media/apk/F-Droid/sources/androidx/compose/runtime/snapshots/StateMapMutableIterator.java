package androidx.compose.runtime.snapshots;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: SnapshotStateMap.kt */
/* loaded from: classes.dex */
abstract class StateMapMutableIterator {
    private Map.Entry current;
    private final Iterator iterator;
    private final SnapshotStateMap map;
    private int modification;
    private Map.Entry next;

    /* JADX INFO: Access modifiers changed from: protected */
    public final Map.Entry getCurrent() {
        return this.current;
    }

    public final SnapshotStateMap getMap() {
        return this.map;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Map.Entry getNext() {
        return this.next;
    }

    public final boolean hasNext() {
        return this.next != null;
    }

    public StateMapMutableIterator(SnapshotStateMap map, Iterator iterator) {
        Intrinsics.checkNotNullParameter(map, "map");
        Intrinsics.checkNotNullParameter(iterator, "iterator");
        this.map = map;
        this.iterator = iterator;
        this.modification = map.getModification$runtime_release();
        advance();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void advance() {
        this.current = this.next;
        this.next = this.iterator.hasNext() ? (Map.Entry) this.iterator.next() : null;
    }

    public final void remove() {
        if (getMap().getModification$runtime_release() != this.modification) {
            throw new ConcurrentModificationException();
        }
        Map.Entry entry = this.current;
        if (entry != null) {
            this.map.remove(entry.getKey());
            this.current = null;
            Unit unit = Unit.INSTANCE;
            this.modification = getMap().getModification$runtime_release();
            return;
        }
        throw new IllegalStateException();
    }
}
