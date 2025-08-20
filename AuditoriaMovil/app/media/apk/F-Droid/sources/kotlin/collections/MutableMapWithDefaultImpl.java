package kotlin.collections;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MapWithDefault.kt */
/* loaded from: classes.dex */
public final class MutableMapWithDefaultImpl implements MutableMapWithDefault {

    /* renamed from: default  reason: not valid java name */
    private final Function1 f17default;
    private final Map map;

    @Override // kotlin.collections.MutableMapWithDefault
    public Map getMap() {
        return this.map;
    }

    public MutableMapWithDefaultImpl(Map map, Function1 function1) {
        Intrinsics.checkNotNullParameter(map, "map");
        Intrinsics.checkNotNullParameter(function1, "default");
        this.map = map;
        this.f17default = function1;
    }

    @Override // java.util.Map
    public final /* bridge */ Set entrySet() {
        return getEntries();
    }

    @Override // java.util.Map
    public final /* bridge */ Set keySet() {
        return getKeys();
    }

    @Override // java.util.Map
    public final /* bridge */ int size() {
        return getSize();
    }

    @Override // java.util.Map
    public final /* bridge */ Collection values() {
        return getValues();
    }

    @Override // java.util.Map
    public boolean equals(Object obj) {
        return getMap().equals(obj);
    }

    @Override // java.util.Map
    public int hashCode() {
        return getMap().hashCode();
    }

    public String toString() {
        return getMap().toString();
    }

    public int getSize() {
        return getMap().size();
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return getMap().isEmpty();
    }

    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        return getMap().containsKey(obj);
    }

    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        return getMap().containsValue(obj);
    }

    @Override // java.util.Map
    public Object get(Object obj) {
        return getMap().get(obj);
    }

    public Set getKeys() {
        return getMap().keySet();
    }

    public Collection getValues() {
        return getMap().values();
    }

    public Set getEntries() {
        return getMap().entrySet();
    }

    @Override // java.util.Map
    public Object put(Object obj, Object obj2) {
        return getMap().put(obj, obj2);
    }

    @Override // java.util.Map
    public Object remove(Object obj) {
        return getMap().remove(obj);
    }

    @Override // java.util.Map
    public void putAll(Map from) {
        Intrinsics.checkNotNullParameter(from, "from");
        getMap().putAll(from);
    }

    @Override // java.util.Map
    public void clear() {
        getMap().clear();
    }

    @Override // kotlin.collections.MapWithDefault
    public Object getOrImplicitDefault(Object obj) {
        Map map = getMap();
        Object obj2 = map.get(obj);
        return (obj2 != null || map.containsKey(obj)) ? obj2 : this.f17default.invoke(obj);
    }
}
