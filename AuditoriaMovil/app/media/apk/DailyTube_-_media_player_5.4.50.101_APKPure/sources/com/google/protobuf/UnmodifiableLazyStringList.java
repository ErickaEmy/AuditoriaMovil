package com.google.protobuf;

import java.util.AbstractList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
@Deprecated
/* loaded from: classes.dex */
public class UnmodifiableLazyStringList extends AbstractList<String> implements LazyStringList, RandomAccess {
    public final LazyStringList y;

    public UnmodifiableLazyStringList(LazyStringList lazyStringList) {
        this.y = lazyStringList;
    }

    @Override // com.google.protobuf.LazyStringList
    public void add(ByteString byteString) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.protobuf.LazyStringList
    public boolean addAllByteArray(Collection<byte[]> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.protobuf.LazyStringList
    public boolean addAllByteString(Collection<? extends ByteString> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.protobuf.LazyStringList
    public List<byte[]> asByteArrayList() {
        return Collections.unmodifiableList(this.y.asByteArrayList());
    }

    @Override // com.google.protobuf.ProtocolStringList
    public List<ByteString> asByteStringList() {
        return Collections.unmodifiableList(this.y.asByteStringList());
    }

    @Override // com.google.protobuf.LazyStringList
    public byte[] getByteArray(int i) {
        return this.y.getByteArray(i);
    }

    @Override // com.google.protobuf.LazyStringList
    public ByteString getByteString(int i) {
        return this.y.getByteString(i);
    }

    @Override // com.google.protobuf.LazyStringList
    public Object getRaw(int i) {
        return this.y.getRaw(i);
    }

    @Override // com.google.protobuf.LazyStringList
    public List<?> getUnderlyingElements() {
        return this.y.getUnderlyingElements();
    }

    @Override // com.google.protobuf.LazyStringList
    public LazyStringList getUnmodifiableView() {
        return this;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator<String> iterator() {
        return new Iterator<String>() { // from class: com.google.protobuf.UnmodifiableLazyStringList.2
            public Iterator<String> y;

            {
                this.y = UnmodifiableLazyStringList.this.y.iterator();
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.y.hasNext();
            }

            @Override // java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException();
            }

            @Override // java.util.Iterator
            public String next() {
                return this.y.next();
            }
        };
    }

    @Override // java.util.AbstractList, java.util.List
    public ListIterator<String> listIterator(int i) {
        return new ListIterator<String>(i) { // from class: com.google.protobuf.UnmodifiableLazyStringList.1

            /* renamed from: v  reason: collision with root package name */
            public final /* synthetic */ int f6546v;
            public ListIterator<String> y;

            {
                this.f6546v = i;
                this.y = UnmodifiableLazyStringList.this.y.listIterator(i);
            }

            @Override // java.util.ListIterator, java.util.Iterator
            public boolean hasNext() {
                return this.y.hasNext();
            }

            @Override // java.util.ListIterator
            public boolean hasPrevious() {
                return this.y.hasPrevious();
            }

            @Override // java.util.ListIterator
            public int nextIndex() {
                return this.y.nextIndex();
            }

            @Override // java.util.ListIterator
            public int previousIndex() {
                return this.y.previousIndex();
            }

            @Override // java.util.ListIterator, java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException();
            }

            @Override // java.util.ListIterator
            public void add(String str) {
                throw new UnsupportedOperationException();
            }

            @Override // java.util.ListIterator, java.util.Iterator
            public String next() {
                return this.y.next();
            }

            @Override // java.util.ListIterator
            public String previous() {
                return this.y.previous();
            }

            @Override // java.util.ListIterator
            public void set(String str) {
                throw new UnsupportedOperationException();
            }
        };
    }

    @Override // com.google.protobuf.LazyStringList
    public void mergeFrom(LazyStringList lazyStringList) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.protobuf.LazyStringList
    public void set(int i, ByteString byteString) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.y.size();
    }

    @Override // com.google.protobuf.LazyStringList
    public void add(byte[] bArr) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractList, java.util.List
    public String get(int i) {
        return this.y.get(i);
    }

    @Override // com.google.protobuf.LazyStringList
    public void set(int i, byte[] bArr) {
        throw new UnsupportedOperationException();
    }
}
