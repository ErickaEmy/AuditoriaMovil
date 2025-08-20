package io.ktor.util;

import java.util.Collections;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: CollectionsJvm.kt */
/* loaded from: classes.dex */
public abstract class CollectionsJvmKt {
    public static final Set unmodifiable(Set set) {
        Intrinsics.checkNotNullParameter(set, "<this>");
        Set unmodifiableSet = Collections.unmodifiableSet(set);
        Intrinsics.checkNotNullExpressionValue(unmodifiableSet, "unmodifiableSet(this)");
        return unmodifiableSet;
    }
}
