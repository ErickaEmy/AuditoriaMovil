package kotlin.collections;

import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public final class IndexedValue<T> {
    private final int index;
    private final T value;

    public IndexedValue(int i, T t2) {
        this.index = i;
        this.value = t2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof IndexedValue) {
            IndexedValue indexedValue = (IndexedValue) obj;
            return this.index == indexedValue.index && Intrinsics.areEqual(this.value, indexedValue.value);
        }
        return false;
    }

    public final int getIndex() {
        return this.index;
    }

    public final T getValue() {
        return this.value;
    }

    public int hashCode() {
        int i = this.index * 31;
        T t2 = this.value;
        return i + (t2 == null ? 0 : t2.hashCode());
    }

    public String toString() {
        return "IndexedValue(index=" + this.index + ", value=" + this.value + ')';
    }
}
