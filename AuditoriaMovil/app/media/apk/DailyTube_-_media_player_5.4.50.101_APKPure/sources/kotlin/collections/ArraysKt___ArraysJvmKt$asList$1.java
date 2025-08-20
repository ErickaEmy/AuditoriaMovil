package kotlin.collections;

import java.util.RandomAccess;
/* loaded from: classes.dex */
public final class ArraysKt___ArraysJvmKt$asList$1 extends AbstractList<Byte> implements RandomAccess {
    final /* synthetic */ byte[] $this_asList;

    public ArraysKt___ArraysJvmKt$asList$1(byte[] bArr) {
        this.$this_asList = bArr;
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof Byte) {
            return contains(((Number) obj).byteValue());
        }
        return false;
    }

    @Override // kotlin.collections.AbstractCollection
    public int getSize() {
        return this.$this_asList.length;
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public final /* bridge */ int indexOf(Object obj) {
        if (obj instanceof Byte) {
            return indexOf(((Number) obj).byteValue());
        }
        return -1;
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        if (this.$this_asList.length == 0) {
            return true;
        }
        return false;
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public final /* bridge */ int lastIndexOf(Object obj) {
        if (obj instanceof Byte) {
            return lastIndexOf(((Number) obj).byteValue());
        }
        return -1;
    }

    public boolean contains(byte b2) {
        return ArraysKt___ArraysKt.contains(this.$this_asList, b2);
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public Byte get(int i) {
        return Byte.valueOf(this.$this_asList[i]);
    }

    public int indexOf(byte b2) {
        return ArraysKt___ArraysKt.indexOf(this.$this_asList, b2);
    }

    public int lastIndexOf(byte b2) {
        return ArraysKt___ArraysKt.lastIndexOf(this.$this_asList, b2);
    }
}
