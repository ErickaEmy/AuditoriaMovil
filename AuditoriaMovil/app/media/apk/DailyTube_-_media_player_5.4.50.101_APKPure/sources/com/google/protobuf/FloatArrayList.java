package com.google.protobuf;

import com.google.protobuf.Internal;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class FloatArrayList extends AbstractProtobufList<Float> implements Internal.FloatList, RandomAccess, PrimitiveNonBoxingCollection {

    /* renamed from: s  reason: collision with root package name */
    public static final FloatArrayList f6433s = new FloatArrayList(new float[0], 0, false);

    /* renamed from: fb  reason: collision with root package name */
    public int f6434fb;

    /* renamed from: v  reason: collision with root package name */
    public float[] f6435v;

    public FloatArrayList() {
        this(new float[10], 0, true);
    }

    public static FloatArrayList emptyList() {
        return f6433s;
    }

    private String gv(int i) {
        return "Index:" + i + ", Size:" + this.f6434fb;
    }

    private void zn(int i) {
        if (i >= 0 && i < this.f6434fb) {
            return;
        }
        throw new IndexOutOfBoundsException(gv(i));
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends Float> collection) {
        y();
        Internal.y(collection);
        if (!(collection instanceof FloatArrayList)) {
            return super.addAll(collection);
        }
        FloatArrayList floatArrayList = (FloatArrayList) collection;
        int i = floatArrayList.f6434fb;
        if (i == 0) {
            return false;
        }
        int i5 = this.f6434fb;
        if (Integer.MAX_VALUE - i5 >= i) {
            int i6 = i5 + i;
            float[] fArr = this.f6435v;
            if (i6 > fArr.length) {
                this.f6435v = Arrays.copyOf(fArr, i6);
            }
            System.arraycopy(floatArrayList.f6435v, 0, this.f6435v, this.f6434fb, floatArrayList.f6434fb);
            this.f6434fb = i6;
            ((AbstractList) this).modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    @Override // com.google.protobuf.Internal.FloatList
    public void addFloat(float f4) {
        y();
        int i = this.f6434fb;
        float[] fArr = this.f6435v;
        if (i == fArr.length) {
            float[] fArr2 = new float[((i * 3) / 2) + 1];
            System.arraycopy(fArr, 0, fArr2, 0, i);
            this.f6435v = fArr2;
        }
        float[] fArr3 = this.f6435v;
        int i5 = this.f6434fb;
        this.f6434fb = i5 + 1;
        fArr3[i5] = f4;
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
        if (!(obj instanceof FloatArrayList)) {
            return super.equals(obj);
        }
        FloatArrayList floatArrayList = (FloatArrayList) obj;
        if (this.f6434fb != floatArrayList.f6434fb) {
            return false;
        }
        float[] fArr = floatArrayList.f6435v;
        for (int i = 0; i < this.f6434fb; i++) {
            if (Float.floatToIntBits(this.f6435v[i]) != Float.floatToIntBits(fArr[i])) {
                return false;
            }
        }
        return true;
    }

    @Override // com.google.protobuf.Internal.FloatList
    public float getFloat(int i) {
        zn(i);
        return this.f6435v[i];
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.Collection, java.util.List
    public int hashCode() {
        int i = 1;
        for (int i5 = 0; i5 < this.f6434fb; i5++) {
            i = (i * 31) + Float.floatToIntBits(this.f6435v[i5]);
        }
        return i;
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object obj) {
        if (!(obj instanceof Float)) {
            return -1;
        }
        float floatValue = ((Float) obj).floatValue();
        int size = size();
        for (int i = 0; i < size; i++) {
            if (this.f6435v[i] == floatValue) {
                return i;
            }
        }
        return -1;
    }

    public final void n3(int i, float f4) {
        int i5;
        y();
        if (i >= 0 && i <= (i5 = this.f6434fb)) {
            float[] fArr = this.f6435v;
            if (i5 < fArr.length) {
                System.arraycopy(fArr, i, fArr, i + 1, i5 - i);
            } else {
                float[] fArr2 = new float[((i5 * 3) / 2) + 1];
                System.arraycopy(fArr, 0, fArr2, 0, i);
                System.arraycopy(this.f6435v, i, fArr2, i + 1, this.f6434fb - i);
                this.f6435v = fArr2;
            }
            this.f6435v[i] = f4;
            this.f6434fb++;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException(gv(i));
    }

    @Override // java.util.AbstractList
    public void removeRange(int i, int i5) {
        y();
        if (i5 >= i) {
            float[] fArr = this.f6435v;
            System.arraycopy(fArr, i5, fArr, i, this.f6434fb - i5);
            this.f6434fb -= i5 - i;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    @Override // com.google.protobuf.Internal.FloatList
    public float setFloat(int i, float f4) {
        y();
        zn(i);
        float[] fArr = this.f6435v;
        float f6 = fArr[i];
        fArr[i] = f4;
        return f6;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f6434fb;
    }

    public FloatArrayList(float[] fArr, int i, boolean z2) {
        super(z2);
        this.f6435v = fArr;
        this.f6434fb = i;
    }

    @Override // java.util.AbstractList, java.util.List
    public Float get(int i) {
        return Float.valueOf(getFloat(i));
    }

    @Override // com.google.protobuf.Internal.ProtobufList, com.google.protobuf.Internal.BooleanList
    /* renamed from: mutableCopyWithCapacity */
    public Internal.ProtobufList<Float> mutableCopyWithCapacity2(int i) {
        if (i >= this.f6434fb) {
            return new FloatArrayList(Arrays.copyOf(this.f6435v, i), this.f6434fb, true);
        }
        throw new IllegalArgumentException();
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public Float remove(int i) {
        int i5;
        y();
        zn(i);
        float[] fArr = this.f6435v;
        float f4 = fArr[i];
        if (i < this.f6434fb - 1) {
            System.arraycopy(fArr, i + 1, fArr, i, (i5 - i) - 1);
        }
        this.f6434fb--;
        ((AbstractList) this).modCount++;
        return Float.valueOf(f4);
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public Float set(int i, Float f4) {
        return Float.valueOf(setFloat(i, f4.floatValue()));
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(Float f4) {
        addFloat(f4.floatValue());
        return true;
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public void add(int i, Float f4) {
        n3(i, f4.floatValue());
    }
}
