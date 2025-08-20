package kotlin.reflect;

import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;
/* compiled from: KProperty.kt */
/* loaded from: classes.dex */
public interface KProperty1 extends KProperty, Function1 {

    /* compiled from: KProperty.kt */
    /* loaded from: classes.dex */
    public interface Getter extends KProperty.Getter, Function1 {
    }

    Object get(Object obj);

    @Override // kotlin.reflect.KProperty
    Getter getGetter();
}
