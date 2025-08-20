package androidx.compose.runtime.snapshots;

import java.util.ConcurrentModificationException;
import java.util.ListIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SnapshotStateList.kt */
/* loaded from: classes.dex */
public final class StateListIterator implements ListIterator, KMappedMarker {
    private int index;
    private final SnapshotStateList list;
    private int modification;

    @Override // java.util.ListIterator
    public boolean hasPrevious() {
        return this.index >= 0;
    }

    @Override // java.util.ListIterator
    public int nextIndex() {
        return this.index + 1;
    }

    @Override // java.util.ListIterator
    public int previousIndex() {
        return this.index;
    }

    public StateListIterator(SnapshotStateList list, int i) {
        Intrinsics.checkNotNullParameter(list, "list");
        this.list = list;
        this.index = i - 1;
        this.modification = list.getModification$runtime_release();
    }

    @Override // java.util.ListIterator
    public Object previous() {
        validateModification();
        SnapshotStateListKt.validateRange(this.index, this.list.size());
        this.index--;
        return this.list.get(this.index);
    }

    @Override // java.util.ListIterator
    public void add(Object obj) {
        validateModification();
        this.list.add(this.index + 1, obj);
        this.index++;
        this.modification = this.list.getModification$runtime_release();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public boolean hasNext() {
        return this.index < this.list.size() - 1;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public Object next() {
        validateModification();
        int i = this.index + 1;
        SnapshotStateListKt.validateRange(i, this.list.size());
        Object obj = this.list.get(i);
        this.index = i;
        return obj;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public void remove() {
        validateModification();
        this.list.remove(this.index);
        this.index--;
        this.modification = this.list.getModification$runtime_release();
    }

    @Override // java.util.ListIterator
    public void set(Object obj) {
        validateModification();
        this.list.set(this.index, obj);
        this.modification = this.list.getModification$runtime_release();
    }

    private final void validateModification() {
        if (this.list.getModification$runtime_release() != this.modification) {
            throw new ConcurrentModificationException();
        }
    }
}
