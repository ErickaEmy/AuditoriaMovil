package kotlin.reflect;

import kotlin.jvm.functions.Function0;
import kotlin.reflect.KProperty;
/* compiled from: KProperty.kt */
/* loaded from: classes.dex */
public interface KProperty0 extends KProperty, Function0 {

    /* compiled from: KProperty.kt */
    /* loaded from: classes.dex */
    public interface Getter extends KProperty.Getter, Function0 {
    }

    Object get();

    @Override // kotlin.reflect.KProperty
    Getter getGetter();
}
