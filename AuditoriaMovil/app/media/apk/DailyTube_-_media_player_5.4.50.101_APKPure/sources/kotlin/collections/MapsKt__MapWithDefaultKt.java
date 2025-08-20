package kotlin.collections;

import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
class MapsKt__MapWithDefaultKt {
    public static final <K, V> V getOrImplicitDefaultNullable(Map<K, ? extends V> map, K k2) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        if (map instanceof MapWithDefault) {
            return (V) ((MapWithDefault) map).getOrImplicitDefault(k2);
        }
        V v2 = map.get(k2);
        if (v2 == null && !map.containsKey(k2)) {
            throw new NoSuchElementException("Key " + k2 + " is missing in the map.");
        }
        return v2;
    }
}
