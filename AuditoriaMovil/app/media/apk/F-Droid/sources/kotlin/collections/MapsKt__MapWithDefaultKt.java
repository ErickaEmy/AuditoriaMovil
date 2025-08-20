package kotlin.collections;

import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MapWithDefault.kt */
/* loaded from: classes.dex */
public abstract class MapsKt__MapWithDefaultKt {
    public static final Object getOrImplicitDefaultNullable(Map map, Object obj) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        if (map instanceof MapWithDefault) {
            return ((MapWithDefault) map).getOrImplicitDefault(obj);
        }
        Object obj2 = map.get(obj);
        if (obj2 != null || map.containsKey(obj)) {
            return obj2;
        }
        throw new NoSuchElementException("Key " + obj + " is missing in the map.");
    }

    public static Map withDefaultMutable(Map map, Function1 defaultValue) {
        Map withDefaultMutable;
        Intrinsics.checkNotNullParameter(map, "<this>");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        if (map instanceof MutableMapWithDefault) {
            withDefaultMutable = withDefaultMutable(((MutableMapWithDefault) map).getMap(), defaultValue);
            return withDefaultMutable;
        }
        return new MutableMapWithDefaultImpl(map, defaultValue);
    }
}
