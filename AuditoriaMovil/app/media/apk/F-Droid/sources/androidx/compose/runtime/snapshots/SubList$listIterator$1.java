package androidx.compose.runtime.snapshots;

import java.util.ListIterator;
import kotlin.KotlinNothingValueException;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.jvm.internal.markers.KMappedMarker;
/* compiled from: SnapshotStateList.kt */
/* loaded from: classes.dex */
public final class SubList$listIterator$1 implements ListIterator, KMappedMarker {
    final /* synthetic */ Ref$IntRef $current;
    final /* synthetic */ SubList this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SubList$listIterator$1(Ref$IntRef ref$IntRef, SubList subList) {
        this.$current = ref$IntRef;
        this.this$0 = subList;
    }

    @Override // java.util.ListIterator
    public boolean hasPrevious() {
        return this.$current.element >= 0;
    }

    @Override // java.util.ListIterator
    public int nextIndex() {
        return this.$current.element + 1;
    }

    @Override // java.util.ListIterator
    public Object previous() {
        int i = this.$current.element;
        SnapshotStateListKt.validateRange(i, this.this$0.size());
        this.$current.element = i - 1;
        return this.this$0.get(i);
    }

    @Override // java.util.ListIterator
    public int previousIndex() {
        return this.$current.element;
    }

    @Override // java.util.ListIterator
    public Void add(Object obj) {
        SnapshotStateListKt.modificationError();
        throw new KotlinNothingValueException();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public boolean hasNext() {
        return this.$current.element < this.this$0.size() - 1;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public Object next() {
        int i = this.$current.element + 1;
        SnapshotStateListKt.validateRange(i, this.this$0.size());
        this.$current.element = i;
        return this.this$0.get(i);
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public Void remove() {
        SnapshotStateListKt.modificationError();
        throw new KotlinNothingValueException();
    }

    @Override // java.util.ListIterator
    public Void set(Object obj) {
        SnapshotStateListKt.modificationError();
        throw new KotlinNothingValueException();
    }
}
