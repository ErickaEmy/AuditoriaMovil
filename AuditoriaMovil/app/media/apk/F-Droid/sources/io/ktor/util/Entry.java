package io.ktor.util;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableMap;
/* compiled from: CaseInsensitiveMap.kt */
/* loaded from: classes.dex */
final class Entry implements Map.Entry, KMutableMap.Entry {
    private final Object key;
    private Object value;

    @Override // java.util.Map.Entry
    public Object getKey() {
        return this.key;
    }

    @Override // java.util.Map.Entry
    public Object getValue() {
        return this.value;
    }

    @Override // java.util.Map.Entry
    public void setValue(Object obj) {
        this.value = obj;
    }

    public Entry(Object obj, Object obj2) {
        this.key = obj;
        this.value = obj2;
    }

    @Override // java.util.Map.Entry
    public Object setValue(Object obj) {
        setValue(obj);
        return getValue();
    }

    @Override // java.util.Map.Entry
    public int hashCode() {
        Object key = getKey();
        Intrinsics.checkNotNull(key);
        Object value = getValue();
        Intrinsics.checkNotNull(value);
        return key.hashCode() + 527 + value.hashCode();
    }

    @Override // java.util.Map.Entry
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        return Intrinsics.areEqual(entry.getKey(), getKey()) && Intrinsics.areEqual(entry.getValue(), getValue());
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getKey());
        sb.append('=');
        sb.append(getValue());
        return sb.toString();
    }
}
