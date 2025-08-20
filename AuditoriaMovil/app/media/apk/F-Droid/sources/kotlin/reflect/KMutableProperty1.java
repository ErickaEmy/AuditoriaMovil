package kotlin.reflect;

import kotlin.jvm.functions.Function2;
import kotlin.reflect.KMutableProperty;
/* compiled from: KProperty.kt */
/* loaded from: classes.dex */
public interface KMutableProperty1 extends KProperty1, KMutableProperty {

    /* compiled from: KProperty.kt */
    /* loaded from: classes.dex */
    public interface Setter extends KMutableProperty.Setter, Function2 {
    }

    @Override // kotlin.reflect.KMutableProperty
    Setter getSetter();
}
