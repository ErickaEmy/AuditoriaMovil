package com.google.protobuf;

import java.util.Iterator;
import java.util.Map;
/* loaded from: classes.dex */
public class LazyField extends LazyFieldLite {

    /* renamed from: a  reason: collision with root package name */
    public final MessageLite f6460a;

    /* loaded from: classes.dex */
    public static class LazyEntry<K> implements Map.Entry<K, Object> {
        public Map.Entry<K, LazyField> y;

        public LazyField getField() {
            return this.y.getValue();
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.y.getKey();
        }

        @Override // java.util.Map.Entry
        public Object getValue() {
            LazyField value = this.y.getValue();
            if (value == null) {
                return null;
            }
            return value.getValue();
        }

        @Override // java.util.Map.Entry
        public Object setValue(Object obj) {
            if (obj instanceof MessageLite) {
                return this.y.getValue().setValue((MessageLite) obj);
            }
            throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
        }

        public LazyEntry(Map.Entry<K, LazyField> entry) {
            this.y = entry;
        }
    }

    /* loaded from: classes.dex */
    public static class LazyIterator<K> implements Iterator<Map.Entry<K, Object>> {
        public Iterator<Map.Entry<K, Object>> y;

        public LazyIterator(Iterator<Map.Entry<K, Object>> it) {
            this.y = it;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.y.hasNext();
        }

        @Override // java.util.Iterator
        public void remove() {
            this.y.remove();
        }

        @Override // java.util.Iterator
        public Map.Entry<K, Object> next() {
            Map.Entry<K, Object> next = this.y.next();
            return next.getValue() instanceof LazyField ? new LazyEntry(next) : next;
        }
    }

    public LazyField(MessageLite messageLite, ExtensionRegistryLite extensionRegistryLite, ByteString byteString) {
        super(extensionRegistryLite, byteString);
        this.f6460a = messageLite;
    }

    @Override // com.google.protobuf.LazyFieldLite
    public boolean containsDefaultInstance() {
        if (!super.containsDefaultInstance() && this.f6464zn != this.f6460a) {
            return false;
        }
        return true;
    }

    @Override // com.google.protobuf.LazyFieldLite
    public boolean equals(Object obj) {
        return getValue().equals(obj);
    }

    public MessageLite getValue() {
        return getValue(this.f6460a);
    }

    @Override // com.google.protobuf.LazyFieldLite
    public int hashCode() {
        return getValue().hashCode();
    }

    public String toString() {
        return getValue().toString();
    }
}
