package kotlin.collections;

import java.util.Collections;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
class CollectionsKt___CollectionsJvmKt extends CollectionsKt__ReversedViewsKt {
    public static final <T> void reverse(List<T> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Collections.reverse(list);
    }
}
