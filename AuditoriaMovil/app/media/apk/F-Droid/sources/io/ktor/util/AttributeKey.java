package io.ktor.util;

import kotlin.jvm.internal.Intrinsics;
/* compiled from: Attributes.kt */
/* loaded from: classes.dex */
public final class AttributeKey {
    private final String name;

    public AttributeKey(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.name = name;
        if (name.length() == 0) {
            throw new IllegalStateException("Name can't be blank");
        }
    }

    public String toString() {
        return "AttributeKey: " + this.name;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && AttributeKey.class == obj.getClass() && Intrinsics.areEqual(this.name, ((AttributeKey) obj).name);
    }

    public int hashCode() {
        return this.name.hashCode();
    }
}
