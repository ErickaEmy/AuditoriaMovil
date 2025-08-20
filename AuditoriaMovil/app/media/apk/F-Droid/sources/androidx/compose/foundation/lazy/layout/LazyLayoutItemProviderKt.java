package androidx.compose.foundation.lazy.layout;

import kotlin.jvm.internal.Intrinsics;
/* compiled from: LazyLayoutItemProvider.kt */
/* loaded from: classes.dex */
public abstract class LazyLayoutItemProviderKt {
    public static final int findIndexByKey(LazyLayoutItemProvider lazyLayoutItemProvider, Object obj, int i) {
        int index;
        Intrinsics.checkNotNullParameter(lazyLayoutItemProvider, "<this>");
        return (obj == null || lazyLayoutItemProvider.getItemCount() == 0 || (i < lazyLayoutItemProvider.getItemCount() && Intrinsics.areEqual(obj, lazyLayoutItemProvider.getKey(i))) || (index = lazyLayoutItemProvider.getIndex(obj)) == -1) ? i : index;
    }
}
