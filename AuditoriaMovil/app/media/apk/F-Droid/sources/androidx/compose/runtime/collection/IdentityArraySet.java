package androidx.compose.runtime.collection;

import androidx.compose.runtime.ActualJvm_jvmKt;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
/* compiled from: IdentityArraySet.kt */
/* loaded from: classes.dex */
public final class IdentityArraySet implements Set, KMappedMarker {
    private int size;
    private Object[] values = new Object[16];

    @Override // java.util.Set, java.util.Collection
    public boolean addAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public int getSize() {
        return this.size;
    }

    public final Object[] getValues() {
        return this.values;
    }

    @Override // java.util.Set, java.util.Collection
    public boolean removeAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Set, java.util.Collection
    public boolean retainAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
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

    @Override // java.util.Set, java.util.Collection
    public final /* bridge */ int size() {
        return getSize();
    }

    @Override // java.util.Set, java.util.Collection
    public boolean contains(Object obj) {
        return obj != null && find(obj) >= 0;
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean add(Object value) {
        int i;
        Intrinsics.checkNotNullParameter(value, "value");
        int size = size();
        Object[] objArr = this.values;
        if (size > 0) {
            i = find(value);
            if (i >= 0) {
                return false;
            }
        } else {
            i = -1;
        }
        int i2 = -(i + 1);
        if (size == objArr.length) {
            Object[] objArr2 = new Object[objArr.length * 2];
            ArraysKt___ArraysJvmKt.copyInto(objArr, objArr2, i2 + 1, i2, size);
            ArraysKt___ArraysJvmKt.copyInto$default(objArr, objArr2, 0, 0, i2, 6, (Object) null);
            this.values = objArr2;
        } else {
            ArraysKt___ArraysJvmKt.copyInto(objArr, objArr, i2 + 1, i2, size);
        }
        this.values[i2] = value;
        this.size = size() + 1;
        return true;
    }

    @Override // java.util.Set, java.util.Collection
    public final void clear() {
        ArraysKt___ArraysJvmKt.fill$default(this.values, (Object) null, 0, 0, 6, (Object) null);
        this.size = 0;
    }

    @Override // java.util.Set, java.util.Collection
    public final void addAll(Collection collection) {
        Object[] objArr;
        int i;
        Object obj;
        Intrinsics.checkNotNullParameter(collection, "collection");
        if (collection.isEmpty()) {
            return;
        }
        if (!(collection instanceof IdentityArraySet)) {
            for (Object obj2 : collection) {
                add(obj2);
            }
            return;
        }
        Object[] objArr2 = this.values;
        IdentityArraySet identityArraySet = (IdentityArraySet) collection;
        Object[] objArr3 = identityArraySet.values;
        int size = size();
        int size2 = identityArraySet.size();
        int i2 = size + size2;
        boolean z = this.values.length < i2;
        boolean z2 = size == 0 || ActualJvm_jvmKt.identityHashCode(objArr2[size + (-1)]) < ActualJvm_jvmKt.identityHashCode(objArr3[0]);
        if (!z && z2) {
            ArraysKt___ArraysJvmKt.copyInto(objArr3, objArr2, size, 0, size2);
            this.size = size() + size2;
            return;
        }
        if (z) {
            objArr = new Object[size > size2 ? size * 2 : size2 * 2];
        } else {
            objArr = objArr2;
        }
        int i3 = size - 1;
        int i4 = size2 - 1;
        int i5 = i2 - 1;
        while (true) {
            if (i3 < 0 && i4 < 0) {
                break;
            }
            if (i3 < 0) {
                i = i4 - 1;
                obj = objArr3[i4];
            } else if (i4 < 0) {
                i = i4;
                obj = objArr2[i3];
                i3--;
            } else {
                Object obj3 = objArr2[i3];
                Object obj4 = objArr3[i4];
                int identityHashCode = ActualJvm_jvmKt.identityHashCode(obj3);
                int identityHashCode2 = ActualJvm_jvmKt.identityHashCode(obj4);
                if (identityHashCode > identityHashCode2) {
                    i3--;
                } else {
                    if (identityHashCode >= identityHashCode2) {
                        if (obj3 != obj4) {
                            int i6 = i3 - 1;
                            while (i6 >= 0) {
                                int i7 = i6 - 1;
                                Object obj5 = objArr2[i6];
                                if (ActualJvm_jvmKt.identityHashCode(obj5) != identityHashCode2) {
                                    break;
                                } else if (obj4 == obj5) {
                                    i4--;
                                    break;
                                } else {
                                    i6 = i7;
                                }
                            }
                        } else {
                            i3--;
                            i4--;
                        }
                    }
                    i = i4 - 1;
                    obj = obj4;
                }
                i = i4;
                obj = obj3;
            }
            objArr[i5] = obj;
            i4 = i;
            i5--;
        }
        if (i5 >= 0) {
            ArraysKt___ArraysJvmKt.copyInto(objArr, objArr, 0, i5 + 1, i2);
        }
        int i8 = i2 - (i5 + 1);
        ArraysKt___ArraysJvmKt.fill(objArr, (Object) null, i8, i2);
        this.values = objArr;
        this.size = i8;
    }

    @Override // java.util.Set, java.util.Collection
    public boolean isEmpty() {
        return size() == 0;
    }

    public final boolean isNotEmpty() {
        return size() > 0;
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean remove(Object obj) {
        if (obj == null) {
            return false;
        }
        int find = find(obj);
        Object[] objArr = this.values;
        int size = size();
        if (find >= 0) {
            int i = size - 1;
            if (find < i) {
                ArraysKt___ArraysJvmKt.copyInto(objArr, objArr, find, find + 1, size);
            }
            objArr[i] = null;
            this.size = size() - 1;
            return true;
        }
        return false;
    }

    private final int find(Object obj) {
        int size = size() - 1;
        int identityHashCode = ActualJvm_jvmKt.identityHashCode(obj);
        Object[] objArr = this.values;
        int i = 0;
        while (i <= size) {
            int i2 = (i + size) >>> 1;
            Object obj2 = objArr[i2];
            int identityHashCode2 = ActualJvm_jvmKt.identityHashCode(obj2);
            if (identityHashCode2 < identityHashCode) {
                i = i2 + 1;
            } else if (identityHashCode2 <= identityHashCode) {
                return obj2 == obj ? i2 : findExactIndex(i2, obj, identityHashCode);
            } else {
                size = i2 - 1;
            }
        }
        return -(i + 1);
    }

    private final int findExactIndex(int i, Object obj, int i2) {
        Object obj2;
        Object[] objArr = this.values;
        int size = size();
        for (int i3 = i - 1; -1 < i3; i3--) {
            Object obj3 = objArr[i3];
            if (obj3 == obj) {
                return i3;
            }
            if (ActualJvm_jvmKt.identityHashCode(obj3) != i2) {
                break;
            }
        }
        do {
            i++;
            if (i >= size) {
                return -(size + 1);
            }
            obj2 = objArr[i];
            if (obj2 == obj) {
                return i;
            }
        } while (ActualJvm_jvmKt.identityHashCode(obj2) == i2);
        return -(i + 1);
    }

    @Override // java.util.Set, java.util.Collection
    public boolean containsAll(Collection elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        Collection<Object> collection = elements;
        if (collection.isEmpty()) {
            return true;
        }
        for (Object obj : collection) {
            if (!contains(obj)) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Set, java.util.Collection, java.lang.Iterable
    public Iterator iterator() {
        return new IdentityArraySet$iterator$1(this);
    }

    public String toString() {
        String joinToString$default;
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(this, null, "[", "]", 0, null, new Function1() { // from class: androidx.compose.runtime.collection.IdentityArraySet$toString$1
            @Override // kotlin.jvm.functions.Function1
            public final CharSequence invoke(Object it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return it.toString();
            }
        }, 25, null);
        return joinToString$default;
    }
}
