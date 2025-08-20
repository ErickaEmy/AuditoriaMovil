package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
/* compiled from: typeSignatureMapping.kt */
/* loaded from: classes2.dex */
public interface JvmTypeFactory {
    Object boxType(Object obj);

    Object createFromString(String str);

    Object createObjectType(String str);

    Object createPrimitiveType(PrimitiveType primitiveType);

    Object getJavaLangClassType();

    String toString(Object obj);
}
