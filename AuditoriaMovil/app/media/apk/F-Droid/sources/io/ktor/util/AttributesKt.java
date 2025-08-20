package io.ktor.util;

import kotlin.jvm.internal.Intrinsics;
/* compiled from: Attributes.kt */
/* loaded from: classes.dex */
public abstract class AttributesKt {
    public static final void putAll(Attributes attributes, Attributes other) {
        Intrinsics.checkNotNullParameter(attributes, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        for (AttributeKey attributeKey : other.getAllKeys()) {
            Intrinsics.checkNotNull(attributeKey, "null cannot be cast to non-null type io.ktor.util.AttributeKey<kotlin.Any>");
            attributes.put(attributeKey, other.get(attributeKey));
        }
    }
}
