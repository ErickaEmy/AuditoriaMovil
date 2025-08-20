package com.google.protobuf;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.RandomAccess;
/* loaded from: classes.dex */
final class ProtobufArrayList<E> extends AbstractProtobufList<E> implements RandomAccess {

    /* renamed from: s  reason: collision with root package name */
    public static final ProtobufArrayList<Object> f6502s = new ProtobufArrayList<>(new Object[0], 0, false);

    /* renamed from: fb  reason: collision with root package name */
    public int f6503fb;

    /* renamed from: v  reason: collision with root package name */
    public E[] f6504v;

    public ProtobufArrayList() {
        this(new Object[10], 0, true);
    }

    public static <E> ProtobufArrayList<E> emptyList() {
        return (ProtobufArrayList<E>) f6502s;
    }

    private String gv(int i) {
        return "Index:" + i + ", Size:" + this.f6503fb;
    }

    public static <E> E[] n3(int i) {
        return (E[]) new Object[i];
    }

    private void zn(int i) {
        if (i >= 0 && i < this.f6503fb) {
            return;
        }
        throw new IndexOutOfBoundsException(gv(i));
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(E e2) {
        y();
        int i = this.f6503fb;
        E[] eArr = this.f6504v;
        if (i == eArr.length) {
            this.f6504v = (E[]) Arrays.copyOf(eArr, ((i * 3) / 2) + 1);
        }
        E[] eArr2 = this.f6504v;
        int i5 = this.f6503fb;
        this.f6503fb = i5 + 1;
        eArr2[i5] = e2;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public E get(int i) {
        zn(i);
        return this.f6504v[i];
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public E remove(int i) {
        int i5;
        y();
        zn(i);
        E[] eArr = this.f6504v;
        E e2 = eArr[i];
        if (i < this.f6503fb - 1) {
            System.arraycopy(eArr, i + 1, eArr, i, (i5 - i) - 1);
        }
        this.f6503fb--;
        ((AbstractList) this).modCount++;
        return e2;
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public E set(int i, E e2) {
        y();
        zn(i);
        E[] eArr = this.f6504v;
        E e3 = eArr[i];
        eArr[i] = e2;
        ((AbstractList) this).modCount++;
        return e3;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f6503fb;
    }

    public ProtobufArrayList(E[] eArr, int i, boolean z2) {
        super(z2);
        this.f6504v = eArr;
        this.f6503fb = i;
    }

    @Override // com.google.protobuf.Internal.ProtobufList, com.google.protobuf.Internal.BooleanList
    public ProtobufArrayList<E> mutableCopyWithCapacity(int i) {
        if (i >= this.f6503fb) {
            return new ProtobufArrayList<>(Arrays.copyOf(this.f6504v, i), this.f6503fb, true);
        }
        throw new IllegalArgumentException();
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public void add(int i, E e2) {
        int i5;
        y();
        if (i >= 0 && i <= (i5 = this.f6503fb)) {
            E[] eArr = this.f6504v;
            if (i5 < eArr.length) {
                System.arraycopy(eArr, i, eArr, i + 1, i5 - i);
            } else {
                E[] eArr2 = (E[]) n3(((i5 * 3) / 2) + 1);
                System.arraycopy(this.f6504v, 0, eArr2, 0, i);
                System.arraycopy(this.f6504v, i, eArr2, i + 1, this.f6503fb - i);
                this.f6504v = eArr2;
            }
            this.f6504v[i] = e2;
            this.f6503fb++;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException(gv(i));
    }
}
