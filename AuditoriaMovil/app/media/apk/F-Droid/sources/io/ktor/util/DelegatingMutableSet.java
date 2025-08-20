package io.ktor.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableSet;
/* compiled from: DelegatingMutableSet.kt */
/* loaded from: classes.dex */
public class DelegatingMutableSet implements Set, KMutableSet {
    private final Function1 convert;
    private final Function1 convertTo;
    private final Set delegate;
    private final int size;

    public int getSize() {
        return this.size;
    }

    @Override // java.util.Set, java.util.Collection
    public Object[] toArray() {
        return CollectionToArray.toArray(this);
    }

    @Override // java.util.Set, java.util.Collection
    public Object[] toArray(Object[] array) {
        Intrinsics.checkNotNullParameter(array, "array");
        return CollectionToArray.toArray(this, array);
    }

    public DelegatingMutableSet(Set delegate, Function1 convertTo, Function1 convert) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        Intrinsics.checkNotNullParameter(convertTo, "convertTo");
        Intrinsics.checkNotNullParameter(convert, "convert");
        this.delegate = delegate;
        this.convertTo = convertTo;
        this.convert = convert;
        this.size = delegate.size();
    }

    @Override // java.util.Set, java.util.Collection
    public final /* bridge */ int size() {
        return getSize();
    }

    public Collection convert(Collection collection) {
        int collectionSizeOrDefault;
        Intrinsics.checkNotNullParameter(collection, "<this>");
        Collection<Object> collection2 = collection;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(collection2, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (Object obj : collection2) {
            arrayList.add(this.convert.invoke(obj));
        }
        return arrayList;
    }

    public Collection convertTo(Collection collection) {
        int collectionSizeOrDefault;
        Intrinsics.checkNotNullParameter(collection, "<this>");
        Collection<Object> collection2 = collection;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(collection2, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (Object obj : collection2) {
            arrayList.add(this.convertTo.invoke(obj));
        }
        return arrayList;
    }

    @Override // java.util.Set, java.util.Collection
    public boolean add(Object obj) {
        return this.delegate.add(this.convert.invoke(obj));
    }

    @Override // java.util.Set, java.util.Collection
    public boolean addAll(Collection elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return this.delegate.addAll(convert(elements));
    }

    @Override // java.util.Set, java.util.Collection
    public void clear() {
        this.delegate.clear();
    }

    @Override // java.util.Set, java.util.Collection
    public boolean remove(Object obj) {
        return this.delegate.remove(this.convert.invoke(obj));
    }

    @Override // java.util.Set, java.util.Collection
    public boolean removeAll(Collection elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return this.delegate.removeAll(convert(elements));
    }

    @Override // java.util.Set, java.util.Collection
    public boolean retainAll(Collection elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return this.delegate.retainAll(convert(elements));
    }

    @Override // java.util.Set, java.util.Collection
    public boolean contains(Object obj) {
        return this.delegate.contains(this.convert.invoke(obj));
    }

    @Override // java.util.Set, java.util.Collection
    public boolean containsAll(Collection elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return this.delegate.containsAll(convert(elements));
    }

    @Override // java.util.Set, java.util.Collection
    public boolean isEmpty() {
        return this.delegate.isEmpty();
    }

    @Override // java.util.Set, java.util.Collection, java.lang.Iterable
    public Iterator iterator() {
        return new DelegatingMutableSet$iterator$1(this);
    }

    @Override // java.util.Set, java.util.Collection
    public int hashCode() {
        return this.delegate.hashCode();
    }

    @Override // java.util.Set, java.util.Collection
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Set)) {
            return false;
        }
        Collection<?> convertTo = convertTo(this.delegate);
        return ((Set) obj).containsAll(convertTo) && convertTo.containsAll((Collection) obj);
    }

    public String toString() {
        return convertTo(this.delegate).toString();
    }
}
