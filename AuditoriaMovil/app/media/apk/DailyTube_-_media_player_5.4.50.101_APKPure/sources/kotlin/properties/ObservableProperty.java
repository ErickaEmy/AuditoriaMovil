package kotlin.properties;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;
/* loaded from: classes.dex */
public abstract class ObservableProperty<V> implements ReadWriteProperty<Object, V> {
    private V value;

    public ObservableProperty(V v2) {
        this.value = v2;
    }

    public abstract void afterChange(KProperty<?> kProperty, V v2, V v3);

    public boolean beforeChange(KProperty<?> property, V v2, V v3) {
        Intrinsics.checkNotNullParameter(property, "property");
        return true;
    }

    @Override // kotlin.properties.ReadWriteProperty
    public V getValue(Object obj, KProperty<?> property) {
        Intrinsics.checkNotNullParameter(property, "property");
        return this.value;
    }

    @Override // kotlin.properties.ReadWriteProperty
    public void setValue(Object obj, KProperty<?> property, V v2) {
        Intrinsics.checkNotNullParameter(property, "property");
        V v3 = this.value;
        if (!beforeChange(property, v3, v2)) {
            return;
        }
        this.value = v2;
        afterChange(property, v3, v2);
    }

    public String toString() {
        return "ObservableProperty(value=" + this.value + ')';
    }
}
