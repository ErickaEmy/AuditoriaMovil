package androidx.compose.runtime;

import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: Recomposer.kt */
/* loaded from: classes.dex */
public abstract class RecomposerKt {
    private static final Object ProduceAnotherFrame = new Object();
    private static final Object FramePending = new Object();

    public static final Object removeLastMultiValue(Map map, Object obj) {
        Object removeFirst;
        Intrinsics.checkNotNullParameter(map, "<this>");
        List list = (List) map.get(obj);
        if (list != null) {
            removeFirst = CollectionsKt__MutableCollectionsKt.removeFirst(list);
            if (list.isEmpty()) {
                map.remove(obj);
                return removeFirst;
            }
            return removeFirst;
        }
        return null;
    }
}
