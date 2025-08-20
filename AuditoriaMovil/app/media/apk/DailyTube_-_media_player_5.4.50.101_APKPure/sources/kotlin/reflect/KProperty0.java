package kotlin.reflect;

import kotlin.jvm.functions.Function0;
/* loaded from: classes.dex */
public interface KProperty0<V> extends KProperty<V>, Function0<V> {

    /* loaded from: classes.dex */
    public interface Getter<V> extends KFunction, Function0<V> {
    }

    V get();

    Getter<V> getGetter();
}
