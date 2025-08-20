package com.google.protobuf;

import com.google.protobuf.Internal;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class LongArrayList extends AbstractProtobufList<Long> implements Internal.LongList, RandomAccess, PrimitiveNonBoxingCollection {

    /* renamed from: s  reason: collision with root package name */
    public static final LongArrayList f6469s = new LongArrayList(new long[0], 0, false);

    /* renamed from: fb  reason: collision with root package name */
    public int f6470fb;

    /* renamed from: v  reason: collision with root package name */
    public long[] f6471v;

    public LongArrayList() {
        this(new long[10], 0, true);
    }

    public static LongArrayList emptyList() {
        return f6469s;
    }

    private String gv(int i) {
        return "Index:" + i + ", Size:" + this.f6470fb;
    }

    private void zn(int i) {
        if (i >= 0 && i < this.f6470fb) {
            return;
        }
        throw new IndexOutOfBoundsException(gv(i));
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends Long> collection) {
        y();
        Internal.y(collection);
        if (!(collection instanceof LongArrayList)) {
            return super.addAll(collection);
        }
        LongArrayList longArrayList = (LongArrayList) collection;
        int i = longArrayList.f6470fb;
        if (i == 0) {
            return false;
        }
        int i5 = this.f6470fb;
        if (Integer.MAX_VALUE - i5 >= i) {
            int i6 = i5 + i;
            long[] jArr = this.f6471v;
            if (i6 > jArr.length) {
                this.f6471v = Arrays.copyOf(jArr, i6);
            }
            System.arraycopy(longArrayList.f6471v, 0, this.f6471v, this.f6470fb, longArrayList.f6470fb);
            this.f6470fb = i6;
            ((AbstractList) this).modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    @Override // com.google.protobuf.Internal.LongList
    public void addLong(long j2) {
        y();
        int i = this.f6470fb;
        long[] jArr = this.f6471v;
        if (i == jArr.length) {
            long[] jArr2 = new long[((i * 3) / 2) + 1];
            System.arraycopy(jArr, 0, jArr2, 0, i);
            this.f6471v = jArr2;
        }
        long[] jArr3 = this.f6471v;
        int i5 = this.f6470fb;
        this.f6470fb = i5 + 1;
        jArr3[i5] = j2;
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
        if (!(obj instanceof LongArrayList)) {
            return super.equals(obj);
        }
        LongArrayList longArrayList = (LongArrayList) obj;
        if (this.f6470fb != longArrayList.f6470fb) {
            return false;
        }
        long[] jArr = longArrayList.f6471v;
        for (int i = 0; i < this.f6470fb; i++) {
            if (this.f6471v[i] != jArr[i]) {
                return false;
            }
        }
        return true;
    }

    @Override // com.google.protobuf.Internal.LongList
    public long getLong(int i) {
        zn(i);
        return this.f6471v[i];
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.Collection, java.util.List
    public int hashCode() {
        int i = 1;
        for (int i5 = 0; i5 < this.f6470fb; i5++) {
            i = (i * 31) + Internal.hashLong(this.f6471v[i5]);
        }
        return i;
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object obj) {
        if (!(obj instanceof Long)) {
            return -1;
        }
        long longValue = ((Long) obj).longValue();
        int size = size();
        for (int i = 0; i < size; i++) {
            if (this.f6471v[i] == longValue) {
                return i;
            }
        }
        return -1;
    }

    public final void n3(int i, long j2) {
        int i5;
        y();
        if (i >= 0 && i <= (i5 = this.f6470fb)) {
            long[] jArr = this.f6471v;
            if (i5 < jArr.length) {
                System.arraycopy(jArr, i, jArr, i + 1, i5 - i);
            } else {
                long[] jArr2 = new long[((i5 * 3) / 2) + 1];
                System.arraycopy(jArr, 0, jArr2, 0, i);
                System.arraycopy(this.f6471v, i, jArr2, i + 1, this.f6470fb - i);
                this.f6471v = jArr2;
            }
            this.f6471v[i] = j2;
            this.f6470fb++;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException(gv(i));
    }

    @Override // java.util.AbstractList
    public void removeRange(int i, int i5) {
        y();
        if (i5 >= i) {
            long[] jArr = this.f6471v;
            System.arraycopy(jArr, i5, jArr, i, this.f6470fb - i5);
            this.f6470fb -= i5 - i;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    @Override // com.google.protobuf.Internal.LongList
    public long setLong(int i, long j2) {
        y();
        zn(i);
        long[] jArr = this.f6471v;
        long j4 = jArr[i];
        jArr[i] = j2;
        return j4;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f6470fb;
    }

    public LongArrayList(long[] jArr, int i, boolean z2) {
        super(z2);
        this.f6471v = jArr;
        this.f6470fb = i;
    }

    @Override // java.util.AbstractList, java.util.List
    public Long get(int i) {
        return Long.valueOf(getLong(i));
    }

    @Override // com.google.protobuf.Internal.ProtobufList, com.google.protobuf.Internal.BooleanList
    /* renamed from: mutableCopyWithCapacity */
    public Internal.ProtobufList<Long> mutableCopyWithCapacity2(int i) {
        if (i >= this.f6470fb) {
            return new LongArrayList(Arrays.copyOf(this.f6471v, i), this.f6470fb, true);
        }
        throw new IllegalArgumentException();
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public Long remove(int i) {
        int i5;
        y();
        zn(i);
        long[] jArr = this.f6471v;
        long j2 = jArr[i];
        if (i < this.f6470fb - 1) {
            System.arraycopy(jArr, i + 1, jArr, i, (i5 - i) - 1);
        }
        this.f6470fb--;
        ((AbstractList) this).modCount++;
        return Long.valueOf(j2);
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public Long set(int i, Long l2) {
        return Long.valueOf(setLong(i, l2.longValue()));
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(Long l2) {
        addLong(l2.longValue());
        return true;
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public void add(int i, Long l2) {
        n3(i, l2.longValue());
    }
}
