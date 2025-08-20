package kotlin.properties;

import kotlin.reflect.KProperty;
/* compiled from: Interfaces.kt */
/* loaded from: classes.dex */
public interface ReadWriteProperty extends ReadOnlyProperty {
    @Override // kotlin.properties.ReadOnlyProperty
    Object getValue(Object obj, KProperty kProperty);

    void setValue(Object obj, KProperty kProperty, Object obj2);
}
