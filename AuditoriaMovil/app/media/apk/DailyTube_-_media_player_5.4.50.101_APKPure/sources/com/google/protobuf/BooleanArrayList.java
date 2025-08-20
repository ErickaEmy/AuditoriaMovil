package com.google.protobuf;

import com.google.protobuf.Internal;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class BooleanArrayList extends AbstractProtobufList<Boolean> implements Internal.BooleanList, RandomAccess, PrimitiveNonBoxingCollection {

    /* renamed from: s  reason: collision with root package name */
    public static final BooleanArrayList f6304s = new BooleanArrayList(new boolean[0], 0, false);

    /* renamed from: fb  reason: collision with root package name */
    public int f6305fb;

    /* renamed from: v  reason: collision with root package name */
    public boolean[] f6306v;

    public BooleanArrayList() {
        this(new boolean[10], 0, true);
    }

    public static BooleanArrayList emptyList() {
        return f6304s;
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends Boolean> collection) {
        y();
        Internal.y(collection);
        if (!(collection instanceof BooleanArrayList)) {
            return super.addAll(collection);
        }
        BooleanArrayList booleanArrayList = (BooleanArrayList) collection;
        int i = booleanArrayList.f6305fb;
        if (i == 0) {
            return false;
        }
        int i5 = this.f6305fb;
        if (Integer.MAX_VALUE - i5 >= i) {
            int i6 = i5 + i;
            boolean[] zArr = this.f6306v;
            if (i6 > zArr.length) {
                this.f6306v = Arrays.copyOf(zArr, i6);
            }
            System.arraycopy(booleanArrayList.f6306v, 0, this.f6306v, this.f6305fb, booleanArrayList.f6305fb);
            this.f6305fb = i6;
            ((AbstractList) this).modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    @Override // com.google.protobuf.Internal.BooleanList
    public void addBoolean(boolean z2) {
        y();
        int i = this.f6305fb;
        boolean[] zArr = this.f6306v;
        if (i == zArr.length) {
            boolean[] zArr2 = new boolean[((i * 3) / 2) + 1];
            System.arraycopy(zArr, 0, zArr2, 0, i);
            this.f6306v = zArr2;
        }
        boolean[] zArr3 = this.f6306v;
        int i5 = this.f6305fb;
        this.f6305fb = i5 + 1;
        zArr3[i5] = z2;
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
        if (!(obj instanceof BooleanArrayList)) {
            return super.equals(obj);
        }
        BooleanArrayList booleanArrayList = (BooleanArrayList) obj;
        if (this.f6305fb != booleanArrayList.f6305fb) {
            return false;
        }
        boolean[] zArr = booleanArrayList.f6306v;
        for (int i = 0; i < this.f6305fb; i++) {
            if (this.f6306v[i] != zArr[i]) {
                return false;
            }
        }
        return true;
    }

    @Override // com.google.protobuf.Internal.BooleanList
    public boolean getBoolean(int i) {
        zn(i);
        return this.f6306v[i];
    }

    public final String gv(int i) {
        return "Index:" + i + ", Size:" + this.f6305fb;
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.Collection, java.util.List
    public int hashCode() {
        int i = 1;
        for (int i5 = 0; i5 < this.f6305fb; i5++) {
            i = (i * 31) + Internal.hashBoolean(this.f6306v[i5]);
        }
        return i;
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object obj) {
        if (!(obj instanceof Boolean)) {
            return -1;
        }
        boolean booleanValue = ((Boolean) obj).booleanValue();
        int size = size();
        for (int i = 0; i < size; i++) {
            if (this.f6306v[i] == booleanValue) {
                return i;
            }
        }
        return -1;
    }

    public final void n3(int i, boolean z2) {
        int i5;
        y();
        if (i >= 0 && i <= (i5 = this.f6305fb)) {
            boolean[] zArr = this.f6306v;
            if (i5 < zArr.length) {
                System.arraycopy(zArr, i, zArr, i + 1, i5 - i);
            } else {
                boolean[] zArr2 = new boolean[((i5 * 3) / 2) + 1];
                System.arraycopy(zArr, 0, zArr2, 0, i);
                System.arraycopy(this.f6306v, i, zArr2, i + 1, this.f6305fb - i);
                this.f6306v = zArr2;
            }
            this.f6306v[i] = z2;
            this.f6305fb++;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException(gv(i));
    }

    @Override // java.util.AbstractList
    public void removeRange(int i, int i5) {
        y();
        if (i5 >= i) {
            boolean[] zArr = this.f6306v;
            System.arraycopy(zArr, i5, zArr, i, this.f6305fb - i5);
            this.f6305fb -= i5 - i;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    @Override // com.google.protobuf.Internal.BooleanList
    public boolean setBoolean(int i, boolean z2) {
        y();
        zn(i);
        boolean[] zArr = this.f6306v;
        boolean z3 = zArr[i];
        zArr[i] = z2;
        return z3;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f6305fb;
    }

    public final void zn(int i) {
        if (i >= 0 && i < this.f6305fb) {
            return;
        }
        throw new IndexOutOfBoundsException(gv(i));
    }

    public BooleanArrayList(boolean[] zArr, int i, boolean z2) {
        super(z2);
        this.f6306v = zArr;
        this.f6305fb = i;
    }

    @Override // java.util.AbstractList, java.util.List
    public Boolean get(int i) {
        return Boolean.valueOf(getBoolean(i));
    }

    @Override // com.google.protobuf.Internal.ProtobufList, com.google.protobuf.Internal.BooleanList
    /* renamed from: mutableCopyWithCapacity */
    public Internal.ProtobufList<Boolean> mutableCopyWithCapacity2(int i) {
        if (i >= this.f6305fb) {
            return new BooleanArrayList(Arrays.copyOf(this.f6306v, i), this.f6305fb, true);
        }
        throw new IllegalArgumentException();
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public Boolean remove(int i) {
        int i5;
        y();
        zn(i);
        boolean[] zArr = this.f6306v;
        boolean z2 = zArr[i];
        if (i < this.f6305fb - 1) {
            System.arraycopy(zArr, i + 1, zArr, i, (i5 - i) - 1);
        }
        this.f6305fb--;
        ((AbstractList) this).modCount++;
        return Boolean.valueOf(z2);
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public Boolean set(int i, Boolean bool) {
        return Boolean.valueOf(setBoolean(i, bool.booleanValue()));
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(Boolean bool) {
        addBoolean(bool.booleanValue());
        return true;
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public void add(int i, Boolean bool) {
        n3(i, bool.booleanValue());
    }
}
