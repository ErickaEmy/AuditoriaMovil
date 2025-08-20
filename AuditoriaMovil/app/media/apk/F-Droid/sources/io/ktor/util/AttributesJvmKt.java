package io.ktor.util;
/* compiled from: AttributesJvm.kt */
/* loaded from: classes.dex */
public abstract class AttributesJvmKt {
    public static final Attributes Attributes(boolean z) {
        return z ? new ConcurrentSafeAttributes() : new HashMapAttributes();
    }
}
