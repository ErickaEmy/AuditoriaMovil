package e1;

import e1.c5;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import w0.xc;
/* loaded from: classes.dex */
public final class v {
    public final y y;

    public final WildcardType a(WildcardType wildcardType) {
        return new c5.c5(v(wildcardType.getLowerBounds()), v(wildcardType.getUpperBounds()));
    }

    public Type gv(Type type) {
        xc.wz(type);
        if (type instanceof TypeVariable) {
            return this.y.y((TypeVariable) type);
        }
        if (type instanceof ParameterizedType) {
            return zn((ParameterizedType) type);
        }
        if (type instanceof GenericArrayType) {
            return n3((GenericArrayType) type);
        }
        if (type instanceof WildcardType) {
            return a((WildcardType) type);
        }
        return type;
    }

    public final Type n3(GenericArrayType genericArrayType) {
        return c5.c5(gv(genericArrayType.getGenericComponentType()));
    }

    public final Type[] v(Type[] typeArr) {
        Type[] typeArr2 = new Type[typeArr.length];
        for (int i = 0; i < typeArr.length; i++) {
            typeArr2[i] = gv(typeArr[i]);
        }
        return typeArr2;
    }

    public final ParameterizedType zn(ParameterizedType parameterizedType) {
        Type gv2;
        Type ownerType = parameterizedType.getOwnerType();
        if (ownerType == null) {
            gv2 = null;
        } else {
            gv2 = gv(ownerType);
        }
        return c5.t(gv2, (Class) gv(parameterizedType.getRawType()), v(parameterizedType.getActualTypeArguments()));
    }

    public v() {
        this.y = new y();
    }

    public v(y yVar) {
        this.y = yVar;
    }
}
