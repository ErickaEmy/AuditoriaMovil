package kotlin.properties;

import kotlin.reflect.KProperty;
/* compiled from: Interfaces.kt */
/* loaded from: classes.dex */
public interface ReadOnlyProperty {
    Object getValue(Object obj, KProperty kProperty);
}
