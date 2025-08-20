package com.google.protobuf;

import com.google.protobuf.Internal;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class DoubleArrayList extends AbstractProtobufList<Double> implements Internal.DoubleList, RandomAccess, PrimitiveNonBoxingCollection {

    /* renamed from: s  reason: collision with root package name */
    public static final DoubleArrayList f6391s = new DoubleArrayList(new double[0], 0, false);

    /* renamed from: fb  reason: collision with root package name */
    public int f6392fb;

    /* renamed from: v  reason: collision with root package name */
    public double[] f6393v;

    public DoubleArrayList() {
        this(new double[10], 0, true);
    }

    public static DoubleArrayList emptyList() {
        return f6391s;
    }

    private String gv(int i) {
        return "Index:" + i + ", Size:" + this.f6392fb;
    }

    private void zn(int i) {
        if (i >= 0 && i < this.f6392fb) {
            return;
        }
        throw new IndexOutOfBoundsException(gv(i));
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends Double> collection) {
        y();
        Internal.y(collection);
        if (!(collection instanceof DoubleArrayList)) {
            return super.addAll(collection);
        }
        DoubleArrayList doubleArrayList = (DoubleArrayList) collection;
        int i = doubleArrayList.f6392fb;
        if (i == 0) {
            return false;
        }
        int i5 = this.f6392fb;
        if (Integer.MAX_VALUE - i5 >= i) {
            int i6 = i5 + i;
            double[] dArr = this.f6393v;
            if (i6 > dArr.length) {
                this.f6393v = Arrays.copyOf(dArr, i6);
            }
            System.arraycopy(doubleArrayList.f6393v, 0, this.f6393v, this.f6392fb, doubleArrayList.f6392fb);
            this.f6392fb = i6;
            ((AbstractList) this).modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    @Override // com.google.protobuf.Internal.DoubleList
    public void addDouble(double d2) {
        y();
        int i = this.f6392fb;
        double[] dArr = this.f6393v;
        if (i == dArr.length) {
            double[] dArr2 = new double[((i * 3) / 2) + 1];
            System.arraycopy(dArr, 0, dArr2, 0, i);
            this.f6393v = dArr2;
        }
        double[] dArr3 = this.f6393v;
        int i5 = this.f6392fb;
        this.f6392fb = i5 + 1;
        dArr3[i5] = d2;
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
        if (!(obj instanceof DoubleArrayList)) {
            return super.equals(obj);
        }
        DoubleArrayList doubleArrayList = (DoubleArrayList) obj;
        if (this.f6392fb != doubleArrayList.f6392fb) {
            return false;
        }
        double[] dArr = doubleArrayList.f6393v;
        for (int i = 0; i < this.f6392fb; i++) {
            if (Double.doubleToLongBits(this.f6393v[i]) != Double.doubleToLongBits(dArr[i])) {
                return false;
            }
        }
        return true;
    }

    @Override // com.google.protobuf.Internal.DoubleList
    public double getDouble(int i) {
        zn(i);
        return this.f6393v[i];
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.Collection, java.util.List
    public int hashCode() {
        int i = 1;
        for (int i5 = 0; i5 < this.f6392fb; i5++) {
            i = (i * 31) + Internal.hashLong(Double.doubleToLongBits(this.f6393v[i5]));
        }
        return i;
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object obj) {
        if (!(obj instanceof Double)) {
            return -1;
        }
        double doubleValue = ((Double) obj).doubleValue();
        int size = size();
        for (int i = 0; i < size; i++) {
            if (this.f6393v[i] == doubleValue) {
                return i;
            }
        }
        return -1;
    }

    public final void n3(int i, double d2) {
        int i5;
        y();
        if (i >= 0 && i <= (i5 = this.f6392fb)) {
            double[] dArr = this.f6393v;
            if (i5 < dArr.length) {
                System.arraycopy(dArr, i, dArr, i + 1, i5 - i);
            } else {
                double[] dArr2 = new double[((i5 * 3) / 2) + 1];
                System.arraycopy(dArr, 0, dArr2, 0, i);
                System.arraycopy(this.f6393v, i, dArr2, i + 1, this.f6392fb - i);
                this.f6393v = dArr2;
            }
            this.f6393v[i] = d2;
            this.f6392fb++;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException(gv(i));
    }

    @Override // java.util.AbstractList
    public void removeRange(int i, int i5) {
        y();
        if (i5 >= i) {
            double[] dArr = this.f6393v;
            System.arraycopy(dArr, i5, dArr, i, this.f6392fb - i5);
            this.f6392fb -= i5 - i;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    @Override // com.google.protobuf.Internal.DoubleList
    public double setDouble(int i, double d2) {
        y();
        zn(i);
        double[] dArr = this.f6393v;
        double d3 = dArr[i];
        dArr[i] = d2;
        return d3;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f6392fb;
    }

    public DoubleArrayList(double[] dArr, int i, boolean z2) {
        super(z2);
        this.f6393v = dArr;
        this.f6392fb = i;
    }

    @Override // java.util.AbstractList, java.util.List
    public Double get(int i) {
        return Double.valueOf(getDouble(i));
    }

    @Override // com.google.protobuf.Internal.ProtobufList, com.google.protobuf.Internal.BooleanList
    /* renamed from: mutableCopyWithCapacity */
    public Internal.ProtobufList<Double> mutableCopyWithCapacity2(int i) {
        if (i >= this.f6392fb) {
            return new DoubleArrayList(Arrays.copyOf(this.f6393v, i), this.f6392fb, true);
        }
        throw new IllegalArgumentException();
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public Double remove(int i) {
        int i5;
        y();
        zn(i);
        double[] dArr = this.f6393v;
        double d2 = dArr[i];
        if (i < this.f6392fb - 1) {
            System.arraycopy(dArr, i + 1, dArr, i, (i5 - i) - 1);
        }
        this.f6392fb--;
        ((AbstractList) this).modCount++;
        return Double.valueOf(d2);
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public Double set(int i, Double d2) {
        return Double.valueOf(setDouble(i, d2.doubleValue()));
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(Double d2) {
        addDouble(d2.doubleValue());
        return true;
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public void add(int i, Double d2) {
        n3(i, d2.doubleValue());
    }
}
