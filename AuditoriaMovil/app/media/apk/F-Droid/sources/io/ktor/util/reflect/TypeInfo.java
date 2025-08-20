package io.ktor.util.reflect;

import ch.qos.logback.core.CoreConstants;
import java.lang.reflect.Type;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
/* compiled from: Type.kt */
/* loaded from: classes.dex */
public final class TypeInfo {
    private final KType kotlinType;
    private final Type reifiedType;
    private final KClass type;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof TypeInfo) {
            TypeInfo typeInfo = (TypeInfo) obj;
            return Intrinsics.areEqual(this.type, typeInfo.type) && Intrinsics.areEqual(this.reifiedType, typeInfo.reifiedType) && Intrinsics.areEqual(this.kotlinType, typeInfo.kotlinType);
        }
        return false;
    }

    public final KClass getType() {
        return this.type;
    }

    public int hashCode() {
        int hashCode = ((this.type.hashCode() * 31) + this.reifiedType.hashCode()) * 31;
        KType kType = this.kotlinType;
        return hashCode + (kType == null ? 0 : kType.hashCode());
    }

    public String toString() {
        return "TypeInfo(type=" + this.type + ", reifiedType=" + this.reifiedType + ", kotlinType=" + this.kotlinType + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }

    public TypeInfo(KClass type, Type reifiedType, KType kType) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(reifiedType, "reifiedType");
        this.type = type;
        this.reifiedType = reifiedType;
        this.kotlinType = kType;
    }
}
