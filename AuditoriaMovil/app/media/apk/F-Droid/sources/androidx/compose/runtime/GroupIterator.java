package androidx.compose.runtime;

import androidx.compose.runtime.tooling.CompositionGroup;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
/* compiled from: SlotTable.kt */
/* loaded from: classes.dex */
final class GroupIterator implements Iterator, KMappedMarker {
    private final int end;
    private int index;
    private final SlotTable table;
    private final int version;

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.index < this.end;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public GroupIterator(SlotTable table, int i, int i2) {
        Intrinsics.checkNotNullParameter(table, "table");
        this.table = table;
        this.end = i2;
        this.index = i;
        this.version = table.getVersion$runtime_release();
        if (table.getWriter$runtime_release()) {
            throw new ConcurrentModificationException();
        }
    }

    @Override // java.util.Iterator
    public CompositionGroup next() {
        int groupSize;
        validateRead();
        int i = this.index;
        groupSize = SlotTableKt.groupSize(this.table.getGroups(), i);
        this.index = groupSize + i;
        return new SlotTableGroup(this.table, i, this.version);
    }

    private final void validateRead() {
        if (this.table.getVersion$runtime_release() != this.version) {
            throw new ConcurrentModificationException();
        }
    }
}
