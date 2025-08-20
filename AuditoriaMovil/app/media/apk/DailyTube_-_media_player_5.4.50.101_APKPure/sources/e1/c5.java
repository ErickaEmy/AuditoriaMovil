package e1;

import java.lang.reflect.Array;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Collection;
import w0.p;
import w0.s;
import w0.xc;
import z0.d0;
/* loaded from: classes.dex */
public final class c5 {
    public static final w0.fb<Type, String> y = new y();

    /* renamed from: n3  reason: collision with root package name */
    public static final s f7449n3 = s.fb(", ").c5("null");

    public static void a(Type[] typeArr, String str) {
        Class cls;
        for (Type type : typeArr) {
            if (type instanceof Class) {
                xc.f(!cls.isPrimitive(), "Primitive type '%s' used as %s", (Class) type, str);
            }
        }
    }

    public static Type c5(Type type) {
        boolean z2;
        if (type instanceof WildcardType) {
            WildcardType wildcardType = (WildcardType) type;
            Type[] lowerBounds = wildcardType.getLowerBounds();
            boolean z3 = true;
            if (lowerBounds.length <= 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            xc.v(z2, "Wildcard cannot have more than one lower bounds.");
            if (lowerBounds.length == 1) {
                return xc(c5(lowerBounds[0]));
            }
            Type[] upperBounds = wildcardType.getUpperBounds();
            if (upperBounds.length != 1) {
                z3 = false;
            }
            xc.v(z3, "Wildcard should have only one upper bound.");
            return wz(c5(upperBounds[0]));
        }
        return gv.f.v(type);
    }

    public static ParameterizedType f(Class<?> cls, Type... typeArr) {
        return new a(n3.fb.v(cls), cls, typeArr);
    }

    public static Iterable<Type> fb(Iterable<Type> iterable) {
        return d0.zn(iterable, p.a(p.gv(Object.class)));
    }

    public static <D extends GenericDeclaration> TypeVariable<D> i9(D d2, String str, Type... typeArr) {
        if (typeArr.length == 0) {
            typeArr = new Type[]{Object.class};
        }
        return tl(d2, str, typeArr);
    }

    public static String p(Type type) {
        if (type instanceof Class) {
            return ((Class) type).getName();
        }
        return type.toString();
    }

    public static Class<?> s(Class<?> cls) {
        return Array.newInstance(cls, 0).getClass();
    }

    public static ParameterizedType t(Type type, Class<?> cls, Type... typeArr) {
        boolean z2;
        if (type == null) {
            return f(cls, typeArr);
        }
        xc.wz(typeArr);
        if (cls.getEnclosingClass() != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        xc.i9(z2, "Owner type for unenclosed %s", cls);
        return new a(type, cls, typeArr);
    }

    public static <D extends GenericDeclaration> TypeVariable<D> tl(D d2, String str, Type[] typeArr) {
        return (TypeVariable) n3.y(TypeVariable.class, new s(new fb(d2, str, typeArr)));
    }

    public static Type[] w(Collection<Type> collection) {
        return (Type[]) collection.toArray(new Type[0]);
    }

    public static WildcardType wz(Type type) {
        return new c5(new Type[0], new Type[]{type});
    }

    public static WildcardType xc(Type type) {
        return new c5(new Type[]{type}, new Type[]{Object.class});
    }
}
