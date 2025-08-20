package ie1;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.NoSuchElementException;
import kc1.mg;
/* loaded from: classes.dex */
public final class i4 {
    public static final Type[] y = new Type[0];

    /* loaded from: classes.dex */
    public static final class n3 implements ParameterizedType {

        /* renamed from: fb  reason: collision with root package name */
        public final Type[] f9205fb;

        /* renamed from: v  reason: collision with root package name */
        public final Type f9206v;
        public final Type y;

        public n3(Type type, Type type2, Type... typeArr) {
            boolean z2;
            if (type2 instanceof Class) {
                if (type == null) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2 != (((Class) type2).getEnclosingClass() == null)) {
                    throw new IllegalArgumentException();
                }
            }
            for (Type type3 : typeArr) {
                i4.n3(type3, "typeArgument == null");
                i4.zn(type3);
            }
            this.y = type;
            this.f9206v = type2;
            this.f9205fb = (Type[]) typeArr.clone();
        }

        public boolean equals(Object obj) {
            if ((obj instanceof ParameterizedType) && i4.v(this, (ParameterizedType) obj)) {
                return true;
            }
            return false;
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type[] getActualTypeArguments() {
            return (Type[]) this.f9205fb.clone();
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type getOwnerType() {
            return this.y;
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type getRawType() {
            return this.f9206v;
        }

        public int hashCode() {
            int i;
            int hashCode = Arrays.hashCode(this.f9205fb) ^ this.f9206v.hashCode();
            Type type = this.y;
            if (type != null) {
                i = type.hashCode();
            } else {
                i = 0;
            }
            return hashCode ^ i;
        }

        public String toString() {
            Type[] typeArr = this.f9205fb;
            if (typeArr.length == 0) {
                return i4.r(this.f9206v);
            }
            StringBuilder sb = new StringBuilder((typeArr.length + 1) * 30);
            sb.append(i4.r(this.f9206v));
            sb.append("<");
            sb.append(i4.r(this.f9205fb[0]));
            for (int i = 1; i < this.f9205fb.length; i++) {
                sb.append(", ");
                sb.append(i4.r(this.f9205fb[i]));
            }
            sb.append(">");
            return sb.toString();
        }
    }

    /* loaded from: classes.dex */
    public static final class y implements GenericArrayType {
        public final Type y;

        public y(Type type) {
            this.y = type;
        }

        public boolean equals(Object obj) {
            if ((obj instanceof GenericArrayType) && i4.v(this, (GenericArrayType) obj)) {
                return true;
            }
            return false;
        }

        @Override // java.lang.reflect.GenericArrayType
        public Type getGenericComponentType() {
            return this.y;
        }

        public int hashCode() {
            return this.y.hashCode();
        }

        public String toString() {
            return i4.r(this.y) + "[]";
        }
    }

    /* loaded from: classes.dex */
    public static final class zn implements WildcardType {

        /* renamed from: v  reason: collision with root package name */
        public final Type f9207v;
        public final Type y;

        public zn(Type[] typeArr, Type[] typeArr2) {
            if (typeArr2.length <= 1) {
                if (typeArr.length == 1) {
                    if (typeArr2.length == 1) {
                        typeArr2[0].getClass();
                        i4.zn(typeArr2[0]);
                        if (typeArr[0] == Object.class) {
                            this.f9207v = typeArr2[0];
                            this.y = Object.class;
                            return;
                        }
                        throw new IllegalArgumentException();
                    }
                    typeArr[0].getClass();
                    i4.zn(typeArr[0]);
                    this.f9207v = null;
                    this.y = typeArr[0];
                    return;
                }
                throw new IllegalArgumentException();
            }
            throw new IllegalArgumentException();
        }

        public boolean equals(Object obj) {
            if ((obj instanceof WildcardType) && i4.v(this, (WildcardType) obj)) {
                return true;
            }
            return false;
        }

        @Override // java.lang.reflect.WildcardType
        public Type[] getLowerBounds() {
            Type type = this.f9207v;
            return type != null ? new Type[]{type} : i4.y;
        }

        @Override // java.lang.reflect.WildcardType
        public Type[] getUpperBounds() {
            return new Type[]{this.y};
        }

        public int hashCode() {
            int i;
            Type type = this.f9207v;
            if (type != null) {
                i = type.hashCode() + 31;
            } else {
                i = 1;
            }
            return i ^ (this.y.hashCode() + 31);
        }

        public String toString() {
            if (this.f9207v != null) {
                return "? super " + i4.r(this.f9207v);
            } else if (this.y == Object.class) {
                return "?";
            } else {
                return "? extends " + i4.r(this.y);
            }
        }
    }

    public static Type a(Type type, Class<?> cls, Class<?> cls2) {
        if (cls2 == cls) {
            return type;
        }
        if (cls2.isInterface()) {
            Class<?>[] interfaces = cls.getInterfaces();
            int length = interfaces.length;
            for (int i = 0; i < length; i++) {
                Class<?> cls3 = interfaces[i];
                if (cls3 == cls2) {
                    return cls.getGenericInterfaces()[i];
                }
                if (cls2.isAssignableFrom(cls3)) {
                    return a(cls.getGenericInterfaces()[i], interfaces[i], cls2);
                }
            }
        }
        if (!cls.isInterface()) {
            while (cls != Object.class) {
                Class<? super Object> superclass = cls.getSuperclass();
                if (superclass == cls2) {
                    return cls.getGenericSuperclass();
                }
                if (cls2.isAssignableFrom(superclass)) {
                    return a(cls.getGenericSuperclass(), superclass, cls2);
                }
                cls = superclass;
            }
        }
        return cls2;
    }

    public static Class<?> c5(Type type) {
        n3(type, "type == null");
        if (type instanceof Class) {
            return (Class) type;
        }
        if (type instanceof ParameterizedType) {
            Type rawType = ((ParameterizedType) type).getRawType();
            if (rawType instanceof Class) {
                return (Class) rawType;
            }
            throw new IllegalArgumentException();
        } else if (type instanceof GenericArrayType) {
            return Array.newInstance(c5(((GenericArrayType) type).getGenericComponentType()), 0).getClass();
        } else {
            if (type instanceof TypeVariable) {
                return Object.class;
            }
            if (type instanceof WildcardType) {
                return c5(((WildcardType) type).getUpperBounds()[0]);
            }
            throw new IllegalArgumentException("Expected a Class, ParameterizedType, or GenericArrayType, but <" + type + "> is of type " + type.getClass().getName());
        }
    }

    public static Type co(Type type, Class<?> cls, TypeVariable<?> typeVariable) {
        Class<?> gv2 = gv(typeVariable);
        if (gv2 == null) {
            return typeVariable;
        }
        Type a2 = a(type, cls, gv2);
        if (a2 instanceof ParameterizedType) {
            return ((ParameterizedType) a2).getActualTypeArguments()[t(gv2.getTypeParameters(), typeVariable)];
        }
        return typeVariable;
    }

    public static boolean f(Type type) {
        String name;
        if (type instanceof Class) {
            return false;
        }
        if (type instanceof ParameterizedType) {
            for (Type type2 : ((ParameterizedType) type).getActualTypeArguments()) {
                if (f(type2)) {
                    return true;
                }
            }
            return false;
        } else if (type instanceof GenericArrayType) {
            return f(((GenericArrayType) type).getGenericComponentType());
        } else {
            if ((type instanceof TypeVariable) || (type instanceof WildcardType)) {
                return true;
            }
            if (type == null) {
                name = "null";
            } else {
                name = type.getClass().getName();
            }
            throw new IllegalArgumentException("Expected a Class, ParameterizedType, or GenericArrayType, but <" + type + "> is of type " + name);
        }
    }

    public static Type fb(int i, ParameterizedType parameterizedType) {
        Type type = parameterizedType.getActualTypeArguments()[i];
        if (type instanceof WildcardType) {
            return ((WildcardType) type).getLowerBounds()[0];
        }
        return type;
    }

    public static Class<?> gv(TypeVariable<?> typeVariable) {
        Object genericDeclaration = typeVariable.getGenericDeclaration();
        if (genericDeclaration instanceof Class) {
            return (Class) genericDeclaration;
        }
        return null;
    }

    public static Type i9(Type type, Class<?> cls, Class<?> cls2) {
        if (cls2.isAssignableFrom(cls)) {
            return mt(type, cls, a(type, cls, cls2));
        }
        throw new IllegalArgumentException();
    }

    public static Type mt(Type type, Class<?> cls, Type type2) {
        boolean z2;
        Type type3 = type2;
        while (type3 instanceof TypeVariable) {
            TypeVariable typeVariable = (TypeVariable) type3;
            Type co2 = co(type, cls, typeVariable);
            if (co2 == typeVariable) {
                return co2;
            }
            type3 = co2;
        }
        if (type3 instanceof Class) {
            Class cls2 = (Class) type3;
            if (cls2.isArray()) {
                Class<?> componentType = cls2.getComponentType();
                Type mt2 = mt(type, cls, componentType);
                if (componentType != mt2) {
                    return new y(mt2);
                }
                return cls2;
            }
        }
        if (type3 instanceof GenericArrayType) {
            GenericArrayType genericArrayType = (GenericArrayType) type3;
            Type genericComponentType = genericArrayType.getGenericComponentType();
            Type mt3 = mt(type, cls, genericComponentType);
            if (genericComponentType != mt3) {
                return new y(mt3);
            }
            return genericArrayType;
        } else if (type3 instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type3;
            Type ownerType = parameterizedType.getOwnerType();
            Type mt4 = mt(type, cls, ownerType);
            if (mt4 != ownerType) {
                z2 = true;
            } else {
                z2 = false;
            }
            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            int length = actualTypeArguments.length;
            for (int i = 0; i < length; i++) {
                Type mt5 = mt(type, cls, actualTypeArguments[i]);
                if (mt5 != actualTypeArguments[i]) {
                    if (!z2) {
                        actualTypeArguments = (Type[]) actualTypeArguments.clone();
                        z2 = true;
                    }
                    actualTypeArguments[i] = mt5;
                }
            }
            if (z2) {
                return new n3(mt4, parameterizedType.getRawType(), actualTypeArguments);
            }
            return parameterizedType;
        } else {
            boolean z3 = type3 instanceof WildcardType;
            WildcardType wildcardType = type3;
            if (z3) {
                WildcardType wildcardType2 = (WildcardType) type3;
                Type[] lowerBounds = wildcardType2.getLowerBounds();
                Type[] upperBounds = wildcardType2.getUpperBounds();
                if (lowerBounds.length == 1) {
                    Type mt6 = mt(type, cls, lowerBounds[0]);
                    wildcardType = wildcardType2;
                    if (mt6 != lowerBounds[0]) {
                        return new zn(new Type[]{Object.class}, new Type[]{mt6});
                    }
                } else {
                    wildcardType = wildcardType2;
                    if (upperBounds.length == 1) {
                        Type mt7 = mt(type, cls, upperBounds[0]);
                        wildcardType = wildcardType2;
                        if (mt7 != upperBounds[0]) {
                            return new zn(new Type[]{mt7}, y);
                        }
                    }
                }
            }
            return wildcardType;
        }
    }

    public static <T> T n3(T t2, String str) {
        if (t2 != null) {
            return t2;
        }
        throw new NullPointerException(str);
    }

    public static RuntimeException p(Method method, Throwable th, int i, String str, Object... objArr) {
        return xc(method, th, str + " (parameter #" + (i + 1) + ")", objArr);
    }

    public static String r(Type type) {
        if (type instanceof Class) {
            return ((Class) type).getName();
        }
        return type.toString();
    }

    public static Type s(int i, ParameterizedType parameterizedType) {
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        if (i >= 0 && i < actualTypeArguments.length) {
            Type type = actualTypeArguments[i];
            if (type instanceof WildcardType) {
                return ((WildcardType) type).getUpperBounds()[0];
            }
            return type;
        }
        throw new IllegalArgumentException("Index " + i + " not in range [0," + actualTypeArguments.length + ") for " + parameterizedType);
    }

    public static int t(Object[] objArr, Object obj) {
        for (int i = 0; i < objArr.length; i++) {
            if (obj.equals(objArr[i])) {
                return i;
            }
        }
        throw new NoSuchElementException();
    }

    public static boolean tl(Annotation[] annotationArr, Class<? extends Annotation> cls) {
        for (Annotation annotation : annotationArr) {
            if (cls.isInstance(annotation)) {
                return true;
            }
        }
        return false;
    }

    public static boolean v(Type type, Type type2) {
        if (type == type2) {
            return true;
        }
        if (type instanceof Class) {
            return type.equals(type2);
        }
        if (type instanceof ParameterizedType) {
            if (!(type2 instanceof ParameterizedType)) {
                return false;
            }
            ParameterizedType parameterizedType = (ParameterizedType) type;
            ParameterizedType parameterizedType2 = (ParameterizedType) type2;
            Type ownerType = parameterizedType.getOwnerType();
            Type ownerType2 = parameterizedType2.getOwnerType();
            if ((ownerType == ownerType2 || (ownerType != null && ownerType.equals(ownerType2))) && parameterizedType.getRawType().equals(parameterizedType2.getRawType()) && Arrays.equals(parameterizedType.getActualTypeArguments(), parameterizedType2.getActualTypeArguments())) {
                return true;
            }
            return false;
        } else if (type instanceof GenericArrayType) {
            if (!(type2 instanceof GenericArrayType)) {
                return false;
            }
            return v(((GenericArrayType) type).getGenericComponentType(), ((GenericArrayType) type2).getGenericComponentType());
        } else if (type instanceof WildcardType) {
            if (!(type2 instanceof WildcardType)) {
                return false;
            }
            WildcardType wildcardType = (WildcardType) type;
            WildcardType wildcardType2 = (WildcardType) type2;
            if (Arrays.equals(wildcardType.getUpperBounds(), wildcardType2.getUpperBounds()) && Arrays.equals(wildcardType.getLowerBounds(), wildcardType2.getLowerBounds())) {
                return true;
            }
            return false;
        } else if (!(type instanceof TypeVariable) || !(type2 instanceof TypeVariable)) {
            return false;
        } else {
            TypeVariable typeVariable = (TypeVariable) type;
            TypeVariable typeVariable2 = (TypeVariable) type2;
            if (typeVariable.getGenericDeclaration() == typeVariable2.getGenericDeclaration() && typeVariable.getName().equals(typeVariable2.getName())) {
                return true;
            }
            return false;
        }
    }

    public static RuntimeException w(Method method, int i, String str, Object... objArr) {
        return wz(method, str + " (parameter #" + (i + 1) + ")", objArr);
    }

    public static RuntimeException wz(Method method, String str, Object... objArr) {
        return xc(method, null, str, objArr);
    }

    public static <T> void x4(Class<T> cls) {
        if (cls.isInterface()) {
            if (cls.getInterfaces().length <= 0) {
                return;
            }
            throw new IllegalArgumentException("API interfaces must not extend other interfaces.");
        }
        throw new IllegalArgumentException("API declarations must be interfaces.");
    }

    public static RuntimeException xc(Method method, Throwable th, String str, Object... objArr) {
        String format = String.format(str, objArr);
        return new IllegalArgumentException(format + "\n    for method " + method.getDeclaringClass().getSimpleName() + "." + method.getName(), th);
    }

    public static mg y(mg mgVar) throws IOException {
        zc1.v vVar = new zc1.v();
        mgVar.source().o(vVar);
        return mg.create(mgVar.contentType(), mgVar.contentLength(), (zc1.fb) vVar);
    }

    public static void z(Throwable th) {
        if (!(th instanceof VirtualMachineError)) {
            if (!(th instanceof ThreadDeath)) {
                if (!(th instanceof LinkageError)) {
                    return;
                }
                throw ((LinkageError) th);
            }
            throw ((ThreadDeath) th);
        }
        throw ((VirtualMachineError) th);
    }

    public static void zn(Type type) {
        if ((type instanceof Class) && ((Class) type).isPrimitive()) {
            throw new IllegalArgumentException();
        }
    }
}
