package kotlin.properties;

import kotlin.reflect.KProperty;
/* loaded from: classes.dex */
public interface ReadWriteProperty<T, V> {
    V getValue(T t2, KProperty<?> kProperty);

    void setValue(T t2, KProperty<?> kProperty, V v2);
}
