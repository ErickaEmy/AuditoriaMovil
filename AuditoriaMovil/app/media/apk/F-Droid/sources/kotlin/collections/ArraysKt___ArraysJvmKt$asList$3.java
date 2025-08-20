package kotlin.collections;

import java.util.RandomAccess;
/* compiled from: _ArraysJvm.kt */
/* loaded from: classes.dex */
public final class ArraysKt___ArraysJvmKt$asList$3 extends AbstractList implements RandomAccess {
    final /* synthetic */ int[] $this_asList;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArraysKt___ArraysJvmKt$asList$3(int[] iArr) {
        this.$this_asList = iArr;
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof Integer) {
            return contains(((Number) obj).intValue());
        }
        return false;
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public final /* bridge */ int indexOf(Object obj) {
        if (obj instanceof Integer) {
            return indexOf(((Number) obj).intValue());
        }
        return -1;
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public final /* bridge */ int lastIndexOf(Object obj) {
        if (obj instanceof Integer) {
            return lastIndexOf(((Number) obj).intValue());
        }
        return -1;
    }

    @Override // kotlin.collections.AbstractCollection
    public int getSize() {
        return this.$this_asList.length;
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return this.$this_asList.length == 0;
    }

    public boolean contains(int i) {
        boolean contains;
        contains = ArraysKt___ArraysKt.contains(this.$this_asList, i);
        return contains;
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public Integer get(int i) {
        return Integer.valueOf(this.$this_asList[i]);
    }

    public int indexOf(int i) {
        return ArraysKt___ArraysKt.indexOf(this.$this_asList, i);
    }

    public int lastIndexOf(int i) {
        return ArraysKt___ArraysKt.lastIndexOf(this.$this_asList, i);
    }
}
