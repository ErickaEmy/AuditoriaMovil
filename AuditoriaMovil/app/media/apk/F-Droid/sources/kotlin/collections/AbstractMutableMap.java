package kotlin.collections;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.markers.KMutableMap;
/* compiled from: AbstractMutableMap.kt */
/* loaded from: classes.dex */
public abstract class AbstractMutableMap extends java.util.AbstractMap implements Map, KMutableMap {
    public abstract Set getEntries();

    public abstract /* bridge */ Set getKeys();

    public abstract /* bridge */ int getSize();

    public abstract /* bridge */ Collection getValues();

    @Override // java.util.AbstractMap, java.util.Map
    public final /* bridge */ Set entrySet() {
        return getEntries();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final /* bridge */ Set keySet() {
        return getKeys();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final /* bridge */ int size() {
        return getSize();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final /* bridge */ Collection values() {
        return getValues();
    }
}
