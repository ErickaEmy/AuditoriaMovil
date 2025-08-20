package kotlin.reflect.jvm.internal.impl.types;

import kotlin.reflect.KClass;
/* compiled from: TypeAttributes.kt */
/* loaded from: classes2.dex */
public abstract class TypeAttribute {
    public abstract TypeAttribute add(TypeAttribute typeAttribute);

    public abstract KClass getKey();

    public abstract TypeAttribute intersect(TypeAttribute typeAttribute);
}
