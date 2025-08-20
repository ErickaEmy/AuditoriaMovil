package androidx.compose.ui;

import kotlin.jvm.internal.Intrinsics;
/* compiled from: Actual.kt */
/* loaded from: classes.dex */
public abstract class ActualKt {
    public static final boolean areObjectsOfSameType(Object a, Object b) {
        Intrinsics.checkNotNullParameter(a, "a");
        Intrinsics.checkNotNullParameter(b, "b");
        return a.getClass() == b.getClass();
    }
}
