package com.google.protobuf;

import com.google.protobuf.Internal;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class IntArrayList extends AbstractProtobufList<Integer> implements Internal.IntList, RandomAccess, PrimitiveNonBoxingCollection {

    /* renamed from: s  reason: collision with root package name */
    public static final IntArrayList f6447s = new IntArrayList(new int[0], 0, false);

    /* renamed from: fb  reason: collision with root package name */
    public int f6448fb;

    /* renamed from: v  reason: collision with root package name */
    public int[] f6449v;

    public IntArrayList() {
        this(new int[10], 0, true);
    }

    public static IntArrayList emptyList() {
        return f6447s;
    }

    private String gv(int i) {
        return "Index:" + i + ", Size:" + this.f6448fb;
    }

    private void zn(int i) {
        if (i >= 0 && i < this.f6448fb) {
            return;
        }
        throw new IndexOutOfBoundsException(gv(i));
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends Integer> collection) {
        y();
        Internal.y(collection);
        if (!(collection instanceof IntArrayList)) {
            return super.addAll(collection);
        }
        IntArrayList intArrayList = (IntArrayList) collection;
        int i = intArrayList.f6448fb;
        if (i == 0) {
            return false;
        }
        int i5 = this.f6448fb;
        if (Integer.MAX_VALUE - i5 >= i) {
            int i6 = i5 + i;
            int[] iArr = this.f6449v;
            if (i6 > iArr.length) {
                this.f6449v = Arrays.copyOf(iArr, i6);
            }
            System.arraycopy(intArrayList.f6449v, 0, this.f6449v, this.f6448fb, intArrayList.f6448fb);
            this.f6448fb = i6;
            ((AbstractList) this).modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    @Override // com.google.protobuf.Internal.IntList
    public void addInt(int i) {
        y();
        int i5 = this.f6448fb;
        int[] iArr = this.f6449v;
        if (i5 == iArr.length) {
            int[] iArr2 = new int[((i5 * 3) / 2) + 1];
            System.arraycopy(iArr, 0, iArr2, 0, i5);
            this.f6449v = iArr2;
        }
        int[] iArr3 = this.f6449v;
        int i6 = this.f6448fb;
        this.f6448fb = i6 + 1;
        iArr3[i6] = i;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean contains(Object obj) {
        if (indexOf(obj) != -1) {
            return true;
        }
        return false;
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.Collection, java.util.List
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof IntArrayList)) {
            return super.equals(obj);
        }
        IntArrayList intArrayList = (IntArrayList) obj;
        if (this.f6448fb != intArrayList.f6448fb) {
            return false;
        }
        int[] iArr = intArrayList.f6449v;
        for (int i = 0; i < this.f6448fb; i++) {
            if (this.f6449v[i] != iArr[i]) {
                return false;
            }
        }
        return true;
    }

    @Override // com.google.protobuf.Internal.IntList
    public int getInt(int i) {
        zn(i);
        return this.f6449v[i];
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.Collection, java.util.List
    public int hashCode() {
        int i = 1;
        for (int i5 = 0; i5 < this.f6448fb; i5++) {
            i = (i * 31) + this.f6449v[i5];
        }
        return i;
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object obj) {
        if (!(obj instanceof Integer)) {
            return -1;
        }
        int intValue = ((Integer) obj).intValue();
        int size = size();
        for (int i = 0; i < size; i++) {
            if (this.f6449v[i] == intValue) {
                return i;
            }
        }
        return -1;
    }

    public final void n3(int i, int i5) {
        int i6;
        y();
        if (i >= 0 && i <= (i6 = this.f6448fb)) {
            int[] iArr = this.f6449v;
            if (i6 < iArr.length) {
                System.arraycopy(iArr, i, iArr, i + 1, i6 - i);
            } else {
                int[] iArr2 = new int[((i6 * 3) / 2) + 1];
                System.arraycopy(iArr, 0, iArr2, 0, i);
                System.arraycopy(this.f6449v, i, iArr2, i + 1, this.f6448fb - i);
                this.f6449v = iArr2;
            }
            this.f6449v[i] = i5;
            this.f6448fb++;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException(gv(i));
    }

    @Override // java.util.AbstractList
    public void removeRange(int i, int i5) {
        y();
        if (i5 >= i) {
            int[] iArr = this.f6449v;
            System.arraycopy(iArr, i5, iArr, i, this.f6448fb - i5);
            this.f6448fb -= i5 - i;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    @Override // com.google.protobuf.Internal.IntList
    public int setInt(int i, int i5) {
        y();
        zn(i);
        int[] iArr = this.f6449v;
        int i6 = iArr[i];
        iArr[i] = i5;
        return i6;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f6448fb;
    }

    public IntArrayList(int[] iArr, int i, boolean z2) {
        super(z2);
        this.f6449v = iArr;
        this.f6448fb = i;
    }

    @Override // java.util.AbstractList, java.util.List
    public Integer get(int i) {
        return Integer.valueOf(getInt(i));
    }

    @Override // com.google.protobuf.Internal.ProtobufList, com.google.protobuf.Internal.BooleanList
    /* renamed from: mutableCopyWithCapacity */
    public Internal.ProtobufList<Integer> mutableCopyWithCapacity2(int i) {
        if (i >= this.f6448fb) {
            return new IntArrayList(Arrays.copyOf(this.f6449v, i), this.f6448fb, true);
        }
        throw new IllegalArgumentException();
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public Integer remove(int i) {
        int i5;
        y();
        zn(i);
        int[] iArr = this.f6449v;
        int i6 = iArr[i];
        if (i < this.f6448fb - 1) {
            System.arraycopy(iArr, i + 1, iArr, i, (i5 - i) - 1);
        }
        this.f6448fb--;
        ((AbstractList) this).modCount++;
        return Integer.valueOf(i6);
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public Integer set(int i, Integer num) {
        return Integer.valueOf(setInt(i, num.intValue()));
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(Integer num) {
        addInt(num.intValue());
        return true;
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public void add(int i, Integer num) {
        n3(i, num.intValue());
    }
}
