package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.Collection;
import java.util.List;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaWildcardType;
/* compiled from: ReflectJavaWildcardType.kt */
/* loaded from: classes2.dex */
public final class ReflectJavaWildcardType extends ReflectJavaType implements JavaWildcardType {
    private final Collection annotations;
    private final boolean isDeprecatedInJavaDoc;
    private final WildcardType reflectType;

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner
    public Collection getAnnotations() {
        return this.annotations;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaType
    public WildcardType getReflectType() {
        return this.reflectType;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner
    public boolean isDeprecatedInJavaDoc() {
        return this.isDeprecatedInJavaDoc;
    }

    public ReflectJavaWildcardType(WildcardType reflectType) {
        List emptyList;
        Intrinsics.checkNotNullParameter(reflectType, "reflectType");
        this.reflectType = reflectType;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        this.annotations = emptyList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaWildcardType
    public ReflectJavaType getBound() {
        Object single;
        Object single2;
        Type[] upperBounds = getReflectType().getUpperBounds();
        Type[] lowerBounds = getReflectType().getLowerBounds();
        if (upperBounds.length > 1 || lowerBounds.length > 1) {
            throw new UnsupportedOperationException("Wildcard types with many bounds are not yet supported: " + getReflectType());
        } else if (lowerBounds.length == 1) {
            ReflectJavaType.Factory factory = ReflectJavaType.Factory;
            Intrinsics.checkNotNull(lowerBounds);
            single2 = ArraysKt___ArraysKt.single(lowerBounds);
            Intrinsics.checkNotNullExpressionValue(single2, "single(...)");
            return factory.create((Type) single2);
        } else {
            if (upperBounds.length == 1) {
                Intrinsics.checkNotNull(upperBounds);
                single = ArraysKt___ArraysKt.single(upperBounds);
                Type type = (Type) single;
                if (!Intrinsics.areEqual(type, Object.class)) {
                    ReflectJavaType.Factory factory2 = ReflectJavaType.Factory;
                    Intrinsics.checkNotNull(type);
                    return factory2.create(type);
                }
            }
            return null;
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaWildcardType
    public boolean isExtends() {
        Object firstOrNull;
        Type[] upperBounds = getReflectType().getUpperBounds();
        Intrinsics.checkNotNullExpressionValue(upperBounds, "getUpperBounds(...)");
        firstOrNull = ArraysKt___ArraysKt.firstOrNull(upperBounds);
        return !Intrinsics.areEqual(firstOrNull, Object.class);
    }
}
