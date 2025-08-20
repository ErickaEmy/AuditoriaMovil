package androidx.compose.ui.layout;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.function.Predicate;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
/* compiled from: SubcomposeLayout.kt */
/* loaded from: classes.dex */
public interface SubcomposeSlotReusePolicy {
    boolean areCompatible(Object obj, Object obj2);

    void getSlotsToRetain(SlotIdsSet slotIdsSet);

    /* compiled from: SubcomposeLayout.kt */
    /* loaded from: classes.dex */
    public static final class SlotIdsSet implements Collection, KMappedMarker {
        private final Set set;

        @Override // java.util.Collection
        public boolean addAll(Collection collection) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.Collection
        public boolean contains(Object obj) {
            return this.set.contains(obj);
        }

        @Override // java.util.Collection
        public boolean containsAll(Collection elements) {
            Intrinsics.checkNotNullParameter(elements, "elements");
            return this.set.containsAll(elements);
        }

        public int getSize() {
            return this.set.size();
        }

        @Override // java.util.Collection
        public boolean isEmpty() {
            return this.set.isEmpty();
        }

        @Override // java.util.Collection
        public boolean removeIf(Predicate predicate) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.Collection
        public Object[] toArray() {
            return CollectionToArray.toArray(this);
        }

        @Override // java.util.Collection
        public Object[] toArray(Object[] array) {
            Intrinsics.checkNotNullParameter(array, "array");
            return CollectionToArray.toArray(this, array);
        }

        public SlotIdsSet(Set set) {
            Intrinsics.checkNotNullParameter(set, "set");
            this.set = set;
        }

        @Override // java.util.Collection
        public final /* bridge */ int size() {
            return getSize();
        }

        public /* synthetic */ SlotIdsSet(Set set, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? new LinkedHashSet() : set);
        }

        @Override // java.util.Collection
        /* renamed from: add$ui_release */
        public final boolean add(Object obj) {
            return this.set.add(obj);
        }

        @Override // java.util.Collection, java.lang.Iterable
        public Iterator iterator() {
            return this.set.iterator();
        }

        @Override // java.util.Collection
        public final boolean remove(Object obj) {
            return this.set.remove(obj);
        }

        @Override // java.util.Collection
        public final boolean removeAll(Collection slotIds) {
            Intrinsics.checkNotNullParameter(slotIds, "slotIds");
            return this.set.remove(slotIds);
        }

        @Override // java.util.Collection
        public final boolean retainAll(Collection slotIds) {
            Intrinsics.checkNotNullParameter(slotIds, "slotIds");
            return this.set.retainAll(slotIds);
        }

        @Override // java.util.Collection
        public final void clear() {
            this.set.clear();
        }
    }
}
