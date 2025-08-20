package androidx.compose.ui.node;

import androidx.compose.ui.Modifier;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.function.UnaryOperator;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
/* compiled from: HitTestResult.kt */
/* loaded from: classes.dex */
public final class HitTestResult implements List, KMappedMarker {
    private int size;
    private Object[] values = new Object[16];
    private long[] distanceFromEdgeAndInLayer = new long[16];
    private int hitDepth = -1;

    @Override // java.util.List
    public /* bridge */ /* synthetic */ void add(int i, Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public /* bridge */ /* synthetic */ boolean add(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public boolean addAll(int i, Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public boolean addAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public int getSize() {
        return this.size;
    }

    @Override // java.util.List
    public /* bridge */ /* synthetic */ Object remove(int i) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public boolean removeAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public void replaceAll(UnaryOperator unaryOperator) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public boolean retainAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public /* bridge */ /* synthetic */ Object set(int i, Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public void sort(Comparator comparator) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public Object[] toArray() {
        return CollectionToArray.toArray(this);
    }

    @Override // java.util.List, java.util.Collection
    public Object[] toArray(Object[] array) {
        Intrinsics.checkNotNullParameter(array, "array");
        return CollectionToArray.toArray(this, array);
    }

    @Override // java.util.List, java.util.Collection
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof Modifier.Node) {
            return contains((Modifier.Node) obj);
        }
        return false;
    }

    @Override // java.util.List
    public final /* bridge */ int indexOf(Object obj) {
        if (obj instanceof Modifier.Node) {
            return indexOf((Modifier.Node) obj);
        }
        return -1;
    }

    @Override // java.util.List
    public final /* bridge */ int lastIndexOf(Object obj) {
        if (obj instanceof Modifier.Node) {
            return lastIndexOf((Modifier.Node) obj);
        }
        return -1;
    }

    @Override // java.util.List, java.util.Collection
    public final /* bridge */ int size() {
        return getSize();
    }

    public final boolean hasHit() {
        long m1301findBestHitDistanceptXAw2c = m1301findBestHitDistanceptXAw2c();
        return DistanceAndInLayer.m1299getDistanceimpl(m1301findBestHitDistanceptXAw2c) < 0.0f && DistanceAndInLayer.m1300isInLayerimpl(m1301findBestHitDistanceptXAw2c);
    }

    public final void acceptHits() {
        this.hitDepth = size() - 1;
    }

    private final void resizeToHitDepth() {
        int lastIndex;
        int i = this.hitDepth + 1;
        lastIndex = CollectionsKt__CollectionsKt.getLastIndex(this);
        if (i <= lastIndex) {
            while (true) {
                this.values[i] = null;
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        this.size = this.hitDepth + 1;
    }

    public final boolean isHitInMinimumTouchTargetBetter(float f, boolean z) {
        int lastIndex;
        long DistanceAndInLayer;
        int i = this.hitDepth;
        lastIndex = CollectionsKt__CollectionsKt.getLastIndex(this);
        if (i == lastIndex) {
            return true;
        }
        DistanceAndInLayer = HitTestResultKt.DistanceAndInLayer(f, z);
        return DistanceAndInLayer.m1297compareToS_HNhKs(m1301findBestHitDistanceptXAw2c(), DistanceAndInLayer) > 0;
    }

    /* renamed from: findBestHitDistance-ptXAw2c  reason: not valid java name */
    private final long m1301findBestHitDistanceptXAw2c() {
        long DistanceAndInLayer;
        int lastIndex;
        DistanceAndInLayer = HitTestResultKt.DistanceAndInLayer(Float.POSITIVE_INFINITY, false);
        int i = this.hitDepth + 1;
        lastIndex = CollectionsKt__CollectionsKt.getLastIndex(this);
        if (i <= lastIndex) {
            while (true) {
                long m1298constructorimpl = DistanceAndInLayer.m1298constructorimpl(this.distanceFromEdgeAndInLayer[i]);
                if (DistanceAndInLayer.m1297compareToS_HNhKs(m1298constructorimpl, DistanceAndInLayer) < 0) {
                    DistanceAndInLayer = m1298constructorimpl;
                }
                if (DistanceAndInLayer.m1299getDistanceimpl(DistanceAndInLayer) < 0.0f && DistanceAndInLayer.m1300isInLayerimpl(DistanceAndInLayer)) {
                    return DistanceAndInLayer;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return DistanceAndInLayer;
    }

    public final void hit(Modifier.Node node, boolean z, Function0 childHitTest) {
        Intrinsics.checkNotNullParameter(node, "node");
        Intrinsics.checkNotNullParameter(childHitTest, "childHitTest");
        hitInMinimumTouchTarget(node, -1.0f, z, childHitTest);
    }

    public final void hitInMinimumTouchTarget(Modifier.Node node, float f, boolean z, Function0 childHitTest) {
        long DistanceAndInLayer;
        Intrinsics.checkNotNullParameter(node, "node");
        Intrinsics.checkNotNullParameter(childHitTest, "childHitTest");
        int i = this.hitDepth;
        this.hitDepth = i + 1;
        ensureContainerSize();
        Object[] objArr = this.values;
        int i2 = this.hitDepth;
        objArr[i2] = node;
        long[] jArr = this.distanceFromEdgeAndInLayer;
        DistanceAndInLayer = HitTestResultKt.DistanceAndInLayer(f, z);
        jArr[i2] = DistanceAndInLayer;
        resizeToHitDepth();
        childHitTest.invoke();
        this.hitDepth = i;
    }

    public final void speculativeHit(Modifier.Node node, float f, boolean z, Function0 childHitTest) {
        int lastIndex;
        int lastIndex2;
        int lastIndex3;
        int lastIndex4;
        Intrinsics.checkNotNullParameter(node, "node");
        Intrinsics.checkNotNullParameter(childHitTest, "childHitTest");
        int i = this.hitDepth;
        lastIndex = CollectionsKt__CollectionsKt.getLastIndex(this);
        if (i == lastIndex) {
            hitInMinimumTouchTarget(node, f, z, childHitTest);
            int i2 = this.hitDepth + 1;
            lastIndex4 = CollectionsKt__CollectionsKt.getLastIndex(this);
            if (i2 == lastIndex4) {
                resizeToHitDepth();
                return;
            }
            return;
        }
        long m1301findBestHitDistanceptXAw2c = m1301findBestHitDistanceptXAw2c();
        int i3 = this.hitDepth;
        lastIndex2 = CollectionsKt__CollectionsKt.getLastIndex(this);
        this.hitDepth = lastIndex2;
        hitInMinimumTouchTarget(node, f, z, childHitTest);
        int i4 = this.hitDepth + 1;
        lastIndex3 = CollectionsKt__CollectionsKt.getLastIndex(this);
        if (i4 < lastIndex3 && DistanceAndInLayer.m1297compareToS_HNhKs(m1301findBestHitDistanceptXAw2c, m1301findBestHitDistanceptXAw2c()) > 0) {
            int i5 = this.hitDepth + 1;
            int i6 = i3 + 1;
            Object[] objArr = this.values;
            ArraysKt___ArraysJvmKt.copyInto(objArr, objArr, i6, i5, size());
            long[] jArr = this.distanceFromEdgeAndInLayer;
            ArraysKt___ArraysJvmKt.copyInto(jArr, jArr, i6, i5, size());
            this.hitDepth = ((size() + i3) - this.hitDepth) - 1;
        }
        resizeToHitDepth();
        this.hitDepth = i3;
    }

    private final void ensureContainerSize() {
        int i = this.hitDepth;
        Object[] objArr = this.values;
        if (i >= objArr.length) {
            int length = objArr.length + 16;
            Object[] copyOf = Arrays.copyOf(objArr, length);
            Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
            this.values = copyOf;
            long[] copyOf2 = Arrays.copyOf(this.distanceFromEdgeAndInLayer, length);
            Intrinsics.checkNotNullExpressionValue(copyOf2, "copyOf(this, newSize)");
            this.distanceFromEdgeAndInLayer = copyOf2;
        }
    }

    public boolean contains(Modifier.Node element) {
        Intrinsics.checkNotNullParameter(element, "element");
        return indexOf((Object) element) != -1;
    }

    @Override // java.util.List, java.util.Collection
    public boolean containsAll(Collection elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        Iterator it = elements.iterator();
        while (it.hasNext()) {
            if (!contains((Object) ((Modifier.Node) it.next()))) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.List
    public Modifier.Node get(int i) {
        Object obj = this.values[i];
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type androidx.compose.ui.Modifier.Node");
        return (Modifier.Node) obj;
    }

    public int indexOf(Modifier.Node element) {
        int lastIndex;
        Intrinsics.checkNotNullParameter(element, "element");
        lastIndex = CollectionsKt__CollectionsKt.getLastIndex(this);
        if (lastIndex >= 0) {
            int i = 0;
            while (!Intrinsics.areEqual(this.values[i], element)) {
                if (i == lastIndex) {
                    return -1;
                }
                i++;
            }
            return i;
        }
        return -1;
    }

    @Override // java.util.List, java.util.Collection
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    public Iterator iterator() {
        return new HitTestResultIterator(this, 0, 0, 0, 7, null);
    }

    public int lastIndexOf(Modifier.Node element) {
        int lastIndex;
        Intrinsics.checkNotNullParameter(element, "element");
        for (lastIndex = CollectionsKt__CollectionsKt.getLastIndex(this); -1 < lastIndex; lastIndex--) {
            if (Intrinsics.areEqual(this.values[lastIndex], element)) {
                return lastIndex;
            }
        }
        return -1;
    }

    @Override // java.util.List
    public ListIterator listIterator() {
        return new HitTestResultIterator(this, 0, 0, 0, 7, null);
    }

    @Override // java.util.List
    public ListIterator listIterator(int i) {
        return new HitTestResultIterator(this, i, 0, 0, 6, null);
    }

    @Override // java.util.List
    public List subList(int i, int i2) {
        return new SubList(i, i2);
    }

    @Override // java.util.List, java.util.Collection
    public final void clear() {
        this.hitDepth = -1;
        resizeToHitDepth();
    }

    /* compiled from: HitTestResult.kt */
    /* loaded from: classes.dex */
    private final class HitTestResultIterator implements ListIterator, KMappedMarker {
        private int index;
        private final int maxIndex;
        private final int minIndex;

        @Override // java.util.ListIterator
        public /* bridge */ /* synthetic */ void add(Object obj) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            return this.index < this.maxIndex;
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return this.index > this.minIndex;
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.index - this.minIndex;
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return (this.index - this.minIndex) - 1;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.ListIterator
        public /* bridge */ /* synthetic */ void set(Object obj) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public HitTestResultIterator(int i, int i2, int i3) {
            this.index = i;
            this.minIndex = i2;
            this.maxIndex = i3;
        }

        public /* synthetic */ HitTestResultIterator(HitTestResult hitTestResult, int i, int i2, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
            this((i4 & 1) != 0 ? 0 : i, (i4 & 2) != 0 ? 0 : i2, (i4 & 4) != 0 ? hitTestResult.size() : i3);
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public Modifier.Node next() {
            Object[] objArr = HitTestResult.this.values;
            int i = this.index;
            this.index = i + 1;
            Object obj = objArr[i];
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type androidx.compose.ui.Modifier.Node");
            return (Modifier.Node) obj;
        }

        @Override // java.util.ListIterator
        public Modifier.Node previous() {
            Object[] objArr = HitTestResult.this.values;
            int i = this.index - 1;
            this.index = i;
            Object obj = objArr[i];
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type androidx.compose.ui.Modifier.Node");
            return (Modifier.Node) obj;
        }
    }

    /* compiled from: HitTestResult.kt */
    /* loaded from: classes.dex */
    private final class SubList implements List, KMappedMarker {
        private final int maxIndex;
        private final int minIndex;

        @Override // java.util.List
        public /* bridge */ /* synthetic */ void add(int i, Object obj) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.List, java.util.Collection
        public /* bridge */ /* synthetic */ boolean add(Object obj) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.List
        public boolean addAll(int i, Collection collection) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.List, java.util.Collection
        public boolean addAll(Collection collection) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.List, java.util.Collection
        public void clear() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public int getSize() {
            return this.maxIndex - this.minIndex;
        }

        @Override // java.util.List
        public /* bridge */ /* synthetic */ Object remove(int i) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.List, java.util.Collection
        public boolean remove(Object obj) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.List, java.util.Collection
        public boolean removeAll(Collection collection) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.List
        public void replaceAll(UnaryOperator unaryOperator) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.List, java.util.Collection
        public boolean retainAll(Collection collection) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.List
        public /* bridge */ /* synthetic */ Object set(int i, Object obj) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.List
        public void sort(Comparator comparator) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.List, java.util.Collection
        public Object[] toArray() {
            return CollectionToArray.toArray(this);
        }

        @Override // java.util.List, java.util.Collection
        public Object[] toArray(Object[] array) {
            Intrinsics.checkNotNullParameter(array, "array");
            return CollectionToArray.toArray(this, array);
        }

        public SubList(int i, int i2) {
            this.minIndex = i;
            this.maxIndex = i2;
        }

        @Override // java.util.List, java.util.Collection
        public final /* bridge */ boolean contains(Object obj) {
            if (obj instanceof Modifier.Node) {
                return contains((Modifier.Node) obj);
            }
            return false;
        }

        @Override // java.util.List
        public final /* bridge */ int indexOf(Object obj) {
            if (obj instanceof Modifier.Node) {
                return indexOf((Modifier.Node) obj);
            }
            return -1;
        }

        @Override // java.util.List
        public final /* bridge */ int lastIndexOf(Object obj) {
            if (obj instanceof Modifier.Node) {
                return lastIndexOf((Modifier.Node) obj);
            }
            return -1;
        }

        @Override // java.util.List, java.util.Collection
        public final /* bridge */ int size() {
            return getSize();
        }

        public boolean contains(Modifier.Node element) {
            Intrinsics.checkNotNullParameter(element, "element");
            return indexOf((Object) element) != -1;
        }

        @Override // java.util.List, java.util.Collection
        public boolean containsAll(Collection elements) {
            Intrinsics.checkNotNullParameter(elements, "elements");
            Iterator it = elements.iterator();
            while (it.hasNext()) {
                if (!contains((Object) ((Modifier.Node) it.next()))) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.List
        public Modifier.Node get(int i) {
            Object obj = HitTestResult.this.values[i + this.minIndex];
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type androidx.compose.ui.Modifier.Node");
            return (Modifier.Node) obj;
        }

        public int indexOf(Modifier.Node element) {
            Intrinsics.checkNotNullParameter(element, "element");
            int i = this.minIndex;
            int i2 = this.maxIndex;
            if (i <= i2) {
                while (!Intrinsics.areEqual(HitTestResult.this.values[i], element)) {
                    if (i == i2) {
                        return -1;
                    }
                    i++;
                }
                return i - this.minIndex;
            }
            return -1;
        }

        @Override // java.util.List, java.util.Collection
        public boolean isEmpty() {
            return size() == 0;
        }

        @Override // java.util.List, java.util.Collection, java.lang.Iterable
        public Iterator iterator() {
            HitTestResult hitTestResult = HitTestResult.this;
            int i = this.minIndex;
            return new HitTestResultIterator(i, i, this.maxIndex);
        }

        public int lastIndexOf(Modifier.Node element) {
            Intrinsics.checkNotNullParameter(element, "element");
            int i = this.maxIndex;
            int i2 = this.minIndex;
            if (i2 <= i) {
                while (!Intrinsics.areEqual(HitTestResult.this.values[i], element)) {
                    if (i == i2) {
                        return -1;
                    }
                    i--;
                }
                return i - this.minIndex;
            }
            return -1;
        }

        @Override // java.util.List
        public ListIterator listIterator() {
            HitTestResult hitTestResult = HitTestResult.this;
            int i = this.minIndex;
            return new HitTestResultIterator(i, i, this.maxIndex);
        }

        @Override // java.util.List
        public ListIterator listIterator(int i) {
            HitTestResult hitTestResult = HitTestResult.this;
            int i2 = this.minIndex;
            return new HitTestResultIterator(i + i2, i2, this.maxIndex);
        }

        @Override // java.util.List
        public List subList(int i, int i2) {
            HitTestResult hitTestResult = HitTestResult.this;
            int i3 = this.minIndex;
            return new SubList(i + i3, i3 + i2);
        }
    }
}
