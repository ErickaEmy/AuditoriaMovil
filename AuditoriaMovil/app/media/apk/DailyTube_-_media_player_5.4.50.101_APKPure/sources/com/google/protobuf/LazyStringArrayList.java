package com.google.protobuf;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;
/* loaded from: classes.dex */
public class LazyStringArrayList extends AbstractProtobufList<String> implements LazyStringList, RandomAccess {
    @Deprecated
    public static final LazyStringList EMPTY;

    /* renamed from: fb  reason: collision with root package name */
    public static final LazyStringArrayList f6465fb;

    /* renamed from: v  reason: collision with root package name */
    public final List<Object> f6466v;

    /* loaded from: classes.dex */
    public static class ByteArrayListView extends AbstractList<byte[]> implements RandomAccess {
        public final LazyStringArrayList y;

        public ByteArrayListView(LazyStringArrayList lazyStringArrayList) {
            this.y = lazyStringArrayList;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.y.size();
        }

        @Override // java.util.AbstractList, java.util.List
        public void add(int i, byte[] bArr) {
            this.y.i9(i, bArr);
            ((AbstractList) this).modCount++;
        }

        @Override // java.util.AbstractList, java.util.List
        public byte[] get(int i) {
            return this.y.getByteArray(i);
        }

        @Override // java.util.AbstractList, java.util.List
        public byte[] remove(int i) {
            String remove = this.y.remove(i);
            ((AbstractList) this).modCount++;
            return LazyStringArrayList.f(remove);
        }

        @Override // java.util.AbstractList, java.util.List
        public byte[] set(int i, byte[] bArr) {
            Object xc2 = this.y.xc(i, bArr);
            ((AbstractList) this).modCount++;
            return LazyStringArrayList.f(xc2);
        }
    }

    /* loaded from: classes.dex */
    public static class ByteStringListView extends AbstractList<ByteString> implements RandomAccess {
        public final LazyStringArrayList y;

        public ByteStringListView(LazyStringArrayList lazyStringArrayList) {
            this.y = lazyStringArrayList;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.y.size();
        }

        @Override // java.util.AbstractList, java.util.List
        public void add(int i, ByteString byteString) {
            this.y.c5(i, byteString);
            ((AbstractList) this).modCount++;
        }

        @Override // java.util.AbstractList, java.util.List
        public ByteString get(int i) {
            return this.y.getByteString(i);
        }

        @Override // java.util.AbstractList, java.util.List
        public ByteString remove(int i) {
            String remove = this.y.remove(i);
            ((AbstractList) this).modCount++;
            return LazyStringArrayList.t(remove);
        }

        @Override // java.util.AbstractList, java.util.List
        public ByteString set(int i, ByteString byteString) {
            Object wz2 = this.y.wz(i, byteString);
            ((AbstractList) this).modCount++;
            return LazyStringArrayList.t(wz2);
        }
    }

    static {
        LazyStringArrayList lazyStringArrayList = new LazyStringArrayList(false);
        f6465fb = lazyStringArrayList;
        EMPTY = lazyStringArrayList;
    }

    public LazyStringArrayList() {
        this(10);
    }

    public static LazyStringArrayList emptyList() {
        return f6465fb;
    }

    public static byte[] f(Object obj) {
        if (obj instanceof byte[]) {
            return (byte[]) obj;
        }
        if (obj instanceof String) {
            return Internal.toByteArray((String) obj);
        }
        return ((ByteString) obj).toByteArray();
    }

    public static ByteString t(Object obj) {
        if (obj instanceof ByteString) {
            return (ByteString) obj;
        }
        if (obj instanceof String) {
            return ByteString.copyFromUtf8((String) obj);
        }
        return ByteString.copyFrom((byte[]) obj);
    }

    public static String tl(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof ByteString) {
            return ((ByteString) obj).toStringUtf8();
        }
        return Internal.toStringUtf8((byte[]) obj);
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends String> collection) {
        return addAll(size(), collection);
    }

    @Override // com.google.protobuf.LazyStringList
    public boolean addAllByteArray(Collection<byte[]> collection) {
        y();
        boolean addAll = this.f6466v.addAll(collection);
        ((AbstractList) this).modCount++;
        return addAll;
    }

    @Override // com.google.protobuf.LazyStringList
    public boolean addAllByteString(Collection<? extends ByteString> collection) {
        y();
        boolean addAll = this.f6466v.addAll(collection);
        ((AbstractList) this).modCount++;
        return addAll;
    }

    @Override // com.google.protobuf.LazyStringList
    public List<byte[]> asByteArrayList() {
        return new ByteArrayListView(this);
    }

    @Override // com.google.protobuf.ProtocolStringList
    public List<ByteString> asByteStringList() {
        return new ByteStringListView(this);
    }

    public final void c5(int i, ByteString byteString) {
        y();
        this.f6466v.add(i, byteString);
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        y();
        this.f6466v.clear();
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.Collection, java.util.List
    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.protobuf.LazyStringList
    public byte[] getByteArray(int i) {
        Object obj = this.f6466v.get(i);
        byte[] f4 = f(obj);
        if (f4 != obj) {
            this.f6466v.set(i, f4);
        }
        return f4;
    }

    @Override // com.google.protobuf.LazyStringList
    public ByteString getByteString(int i) {
        Object obj = this.f6466v.get(i);
        ByteString t2 = t(obj);
        if (t2 != obj) {
            this.f6466v.set(i, t2);
        }
        return t2;
    }

    @Override // com.google.protobuf.LazyStringList
    public Object getRaw(int i) {
        return this.f6466v.get(i);
    }

    @Override // com.google.protobuf.LazyStringList
    public List<?> getUnderlyingElements() {
        return Collections.unmodifiableList(this.f6466v);
    }

    @Override // com.google.protobuf.LazyStringList
    public LazyStringList getUnmodifiableView() {
        if (isModifiable()) {
            return new UnmodifiableLazyStringList(this);
        }
        return this;
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.Collection, java.util.List
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    public final void i9(int i, byte[] bArr) {
        y();
        this.f6466v.add(i, bArr);
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.protobuf.AbstractProtobufList, com.google.protobuf.Internal.ProtobufList
    public /* bridge */ /* synthetic */ boolean isModifiable() {
        return super.isModifiable();
    }

    @Override // com.google.protobuf.LazyStringList
    public void mergeFrom(LazyStringList lazyStringList) {
        y();
        for (Object obj : lazyStringList.getUnderlyingElements()) {
            if (obj instanceof byte[]) {
                byte[] bArr = (byte[]) obj;
                this.f6466v.add(Arrays.copyOf(bArr, bArr.length));
            } else {
                this.f6466v.add(obj);
            }
        }
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public /* bridge */ /* synthetic */ boolean removeAll(Collection collection) {
        return super.removeAll(collection);
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public /* bridge */ /* synthetic */ boolean retainAll(Collection collection) {
        return super.retainAll(collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f6466v.size();
    }

    public final Object wz(int i, ByteString byteString) {
        y();
        return this.f6466v.set(i, byteString);
    }

    public final Object xc(int i, byte[] bArr) {
        y();
        return this.f6466v.set(i, bArr);
    }

    public LazyStringArrayList(boolean z2) {
        super(z2);
        this.f6466v = Collections.emptyList();
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public /* bridge */ /* synthetic */ boolean add(Object obj) {
        return super.add((LazyStringArrayList) obj);
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public boolean addAll(int i, Collection<? extends String> collection) {
        y();
        if (collection instanceof LazyStringList) {
            collection = ((LazyStringList) collection).getUnderlyingElements();
        }
        boolean addAll = this.f6466v.addAll(i, collection);
        ((AbstractList) this).modCount++;
        return addAll;
    }

    @Override // java.util.AbstractList, java.util.List
    public String get(int i) {
        Object obj = this.f6466v.get(i);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof ByteString) {
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.f6466v.set(i, stringUtf8);
            }
            return stringUtf8;
        }
        byte[] bArr = (byte[]) obj;
        String stringUtf82 = Internal.toStringUtf8(bArr);
        if (Internal.isValidUtf8(bArr)) {
            this.f6466v.set(i, stringUtf82);
        }
        return stringUtf82;
    }

    @Override // com.google.protobuf.Internal.ProtobufList, com.google.protobuf.Internal.BooleanList
    public LazyStringArrayList mutableCopyWithCapacity(int i) {
        if (i >= size()) {
            ArrayList arrayList = new ArrayList(i);
            arrayList.addAll(this.f6466v);
            return new LazyStringArrayList((ArrayList<Object>) arrayList);
        }
        throw new IllegalArgumentException();
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public /* bridge */ /* synthetic */ boolean remove(Object obj) {
        return super.remove(obj);
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public String set(int i, String str) {
        y();
        return tl(this.f6466v.set(i, str));
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public void add(int i, String str) {
        y();
        this.f6466v.add(i, str);
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public String remove(int i) {
        y();
        Object remove = this.f6466v.remove(i);
        ((AbstractList) this).modCount++;
        return tl(remove);
    }

    public LazyStringArrayList(int i) {
        this((ArrayList<Object>) new ArrayList(i));
    }

    public LazyStringArrayList(LazyStringList lazyStringList) {
        this.f6466v = new ArrayList(lazyStringList.size());
        addAll(lazyStringList);
    }

    @Override // com.google.protobuf.LazyStringList
    public void set(int i, ByteString byteString) {
        wz(i, byteString);
    }

    @Override // com.google.protobuf.LazyStringList
    public void add(ByteString byteString) {
        y();
        this.f6466v.add(byteString);
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.protobuf.LazyStringList
    public void set(int i, byte[] bArr) {
        xc(i, bArr);
    }

    public LazyStringArrayList(List<String> list) {
        this((ArrayList<Object>) new ArrayList(list));
    }

    public LazyStringArrayList(ArrayList<Object> arrayList) {
        this.f6466v = arrayList;
    }

    @Override // com.google.protobuf.LazyStringList
    public void add(byte[] bArr) {
        y();
        this.f6466v.add(bArr);
        ((AbstractList) this).modCount++;
    }
}
