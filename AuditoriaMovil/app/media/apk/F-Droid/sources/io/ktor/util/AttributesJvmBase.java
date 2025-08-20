package io.ktor.util;

import io.ktor.util.Attributes;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: AttributesJvm.kt */
/* loaded from: classes.dex */
abstract class AttributesJvmBase implements Attributes {
    protected abstract Map getMap();

    @Override // io.ktor.util.Attributes
    public Object get(AttributeKey attributeKey) {
        return Attributes.DefaultImpls.get(this, attributeKey);
    }

    @Override // io.ktor.util.Attributes
    public final Object getOrNull(AttributeKey key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return getMap().get(key);
    }

    @Override // io.ktor.util.Attributes
    public final boolean contains(AttributeKey key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return getMap().containsKey(key);
    }

    @Override // io.ktor.util.Attributes
    public final void put(AttributeKey key, Object value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        getMap().put(key, value);
    }

    @Override // io.ktor.util.Attributes
    public final void remove(AttributeKey key) {
        Intrinsics.checkNotNullParameter(key, "key");
        getMap().remove(key);
    }

    @Override // io.ktor.util.Attributes
    public final List getAllKeys() {
        List list;
        list = CollectionsKt___CollectionsKt.toList(getMap().keySet());
        return list;
    }
}
