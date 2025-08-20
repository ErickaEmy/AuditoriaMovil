package p6;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Constructor;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import o6.a;
import o6.co;
import o6.f;
import o6.fb;
import o6.i9;
import o6.s;
import o6.v;
import o6.x4;
/* loaded from: classes.dex */
public final class n3 {

    /* renamed from: gv  reason: collision with root package name */
    public static final Class<? extends Annotation> f12434gv;

    /* renamed from: n3  reason: collision with root package name */
    public static final Type[] f12435n3;

    /* renamed from: v  reason: collision with root package name */
    public static final Map<Class<?>, Class<?>> f12436v;
    public static final Set<Annotation> y;

    /* renamed from: zn  reason: collision with root package name */
    public static final Class<?> f12437zn;

    /* renamed from: p6.n3$n3  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0180n3 implements ParameterizedType {

        /* renamed from: fb  reason: collision with root package name */
        public final Type[] f12438fb;

        /* renamed from: v  reason: collision with root package name */
        public final Type f12439v;
        public final Type y;

        public C0180n3(Type type, Type type2, Type... typeArr) {
            Type y;
            if (type2 instanceof Class) {
                Class<?> enclosingClass = ((Class) type2).getEnclosingClass();
                if (type != null) {
                    if (enclosingClass == null || x4.fb(type) != enclosingClass) {
                        throw new IllegalArgumentException("unexpected owner type for " + type2 + ": " + type);
                    }
                } else if (enclosingClass != null) {
                    throw new IllegalArgumentException("unexpected owner type for " + type2 + ": null");
                }
            }
            if (type == null) {
                y = null;
            } else {
                y = n3.y(type);
            }
            this.y = y;
            this.f12439v = n3.y(type2);
            this.f12438fb = (Type[]) typeArr.clone();
            int i = 0;
            while (true) {
                Type[] typeArr2 = this.f12438fb;
                if (i < typeArr2.length) {
                    typeArr2[i].getClass();
                    n3.n3(this.f12438fb[i]);
                    Type[] typeArr3 = this.f12438fb;
                    typeArr3[i] = n3.y(typeArr3[i]);
                    i++;
                } else {
                    return;
                }
            }
        }

        public boolean equals(Object obj) {
            if ((obj instanceof ParameterizedType) && x4.gv(this, (ParameterizedType) obj)) {
                return true;
            }
            return false;
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type[] getActualTypeArguments() {
            return (Type[]) this.f12438fb.clone();
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type getOwnerType() {
            return this.y;
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type getRawType() {
            return this.f12439v;
        }

        public int hashCode() {
            return (Arrays.hashCode(this.f12438fb) ^ this.f12439v.hashCode()) ^ n3.a(this.y);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder((this.f12438fb.length + 1) * 30);
            sb.append(n3.r(this.f12439v));
            if (this.f12438fb.length == 0) {
                return sb.toString();
            }
            sb.append("<");
            sb.append(n3.r(this.f12438fb[0]));
            for (int i = 1; i < this.f12438fb.length; i++) {
                sb.append(", ");
                sb.append(n3.r(this.f12438fb[i]));
            }
            sb.append(">");
            return sb.toString();
        }
    }

    /* loaded from: classes.dex */
    public static final class y implements GenericArrayType {
        public final Type y;

        public y(Type type) {
            this.y = n3.y(type);
        }

        public boolean equals(Object obj) {
            if ((obj instanceof GenericArrayType) && x4.gv(this, (GenericArrayType) obj)) {
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
            return n3.r(this.y) + "[]";
        }
    }

    /* loaded from: classes.dex */
    public static final class zn implements WildcardType {

        /* renamed from: v  reason: collision with root package name */
        public final Type f12440v;
        public final Type y;

        public zn(Type[] typeArr, Type[] typeArr2) {
            if (typeArr2.length <= 1) {
                if (typeArr.length == 1) {
                    if (typeArr2.length == 1) {
                        typeArr2[0].getClass();
                        n3.n3(typeArr2[0]);
                        if (typeArr[0] == Object.class) {
                            this.f12440v = n3.y(typeArr2[0]);
                            this.y = Object.class;
                            return;
                        }
                        throw new IllegalArgumentException();
                    }
                    typeArr[0].getClass();
                    n3.n3(typeArr[0]);
                    this.f12440v = null;
                    this.y = n3.y(typeArr[0]);
                    return;
                }
                throw new IllegalArgumentException();
            }
            throw new IllegalArgumentException();
        }

        public boolean equals(Object obj) {
            if ((obj instanceof WildcardType) && x4.gv(this, (WildcardType) obj)) {
                return true;
            }
            return false;
        }

        @Override // java.lang.reflect.WildcardType
        public Type[] getLowerBounds() {
            Type type = this.f12440v;
            return type != null ? new Type[]{type} : n3.f12435n3;
        }

        @Override // java.lang.reflect.WildcardType
        public Type[] getUpperBounds() {
            return new Type[]{this.y};
        }

        public int hashCode() {
            int i;
            Type type = this.f12440v;
            if (type != null) {
                i = type.hashCode() + 31;
            } else {
                i = 1;
            }
            return i ^ (this.y.hashCode() + 31);
        }

        public String toString() {
            if (this.f12440v != null) {
                return "? super " + n3.r(this.f12440v);
            } else if (this.y == Object.class) {
                return "?";
            } else {
                return "? extends " + n3.r(this.y);
            }
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:10:0x001a
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:81)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:47)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    static {
        /*
            java.util.Set r0 = java.util.Collections.emptySet()
            p6.n3.y = r0
            r0 = 0
            java.lang.reflect.Type[] r0 = new java.lang.reflect.Type[r0]
            p6.n3.f12435n3 = r0
            r0 = 0
            java.lang.String r1 = getKotlinMetadataClassName()     // Catch: java.lang.ClassNotFoundException -> L15
            java.lang.Class r1 = java.lang.Class.forName(r1)     // Catch: java.lang.ClassNotFoundException -> L15
            goto L16
        L15:
            r1 = r0
        L16:
            p6.n3.f12434gv = r1
            java.lang.Class<kotlin.jvm.internal.DefaultConstructorMarker> r0 = kotlin.jvm.internal.DefaultConstructorMarker.class
        L1a:
            p6.n3.f12437zn = r0
            java.util.LinkedHashMap r0 = new java.util.LinkedHashMap
            r1 = 16
            r0.<init>(r1)
            java.lang.Class r1 = java.lang.Boolean.TYPE
            java.lang.Class<java.lang.Boolean> r2 = java.lang.Boolean.class
            r0.put(r1, r2)
            java.lang.Class r1 = java.lang.Byte.TYPE
            java.lang.Class<java.lang.Byte> r2 = java.lang.Byte.class
            r0.put(r1, r2)
            java.lang.Class r1 = java.lang.Character.TYPE
            java.lang.Class<java.lang.Character> r2 = java.lang.Character.class
            r0.put(r1, r2)
            java.lang.Class r1 = java.lang.Double.TYPE
            java.lang.Class<java.lang.Double> r2 = java.lang.Double.class
            r0.put(r1, r2)
            java.lang.Class r1 = java.lang.Float.TYPE
            java.lang.Class<java.lang.Float> r2 = java.lang.Float.class
            r0.put(r1, r2)
            java.lang.Class r1 = java.lang.Integer.TYPE
            java.lang.Class<java.lang.Integer> r2 = java.lang.Integer.class
            r0.put(r1, r2)
            java.lang.Class r1 = java.lang.Long.TYPE
            java.lang.Class<java.lang.Long> r2 = java.lang.Long.class
            r0.put(r1, r2)
            java.lang.Class r1 = java.lang.Short.TYPE
            java.lang.Class<java.lang.Short> r2 = java.lang.Short.class
            r0.put(r1, r2)
            java.lang.Class r1 = java.lang.Void.TYPE
            java.lang.Class<java.lang.Void> r2 = java.lang.Void.class
            r0.put(r1, r2)
            java.util.Map r0 = java.util.Collections.unmodifiableMap(r0)
            p6.n3.f12436v = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p6.n3.<clinit>():void");
    }

    public static int a(Object obj) {
        if (obj != null) {
            return obj.hashCode();
        }
        return 0;
    }

    public static boolean c5(Class<?> cls) {
        String name = cls.getName();
        if (!name.startsWith("android.") && !name.startsWith("androidx.") && !name.startsWith("java.") && !name.startsWith("javax.") && !name.startsWith("kotlin.") && !name.startsWith("kotlinx.") && !name.startsWith("scala.")) {
            return false;
        }
        return true;
    }

    public static RuntimeException co(InvocationTargetException invocationTargetException) {
        Throwable targetException = invocationTargetException.getTargetException();
        if (!(targetException instanceof RuntimeException)) {
            if (targetException instanceof Error) {
                throw ((Error) targetException);
            }
            throw new RuntimeException(targetException);
        }
        throw ((RuntimeException) targetException);
    }

    public static Set<? extends Annotation> f(Annotation[] annotationArr) {
        LinkedHashSet linkedHashSet = null;
        for (Annotation annotation : annotationArr) {
            if (annotation.annotationType().isAnnotationPresent(i9.class)) {
                if (linkedHashSet == null) {
                    linkedHashSet = new LinkedHashSet();
                }
                linkedHashSet.add(annotation);
            }
        }
        if (linkedHashSet != null) {
            return Collections.unmodifiableSet(linkedHashSet);
        }
        return y;
    }

    public static int fb(Object[] objArr, Object obj) {
        for (int i = 0; i < objArr.length; i++) {
            if (obj.equals(objArr[i])) {
                return i;
            }
        }
        throw new NoSuchElementException();
    }

    private static String getKotlinMetadataClassName() {
        return "kotlin.Metadata";
    }

    public static a<?> gv(co coVar, Type type, Class<?> cls) {
        Constructor<?> declaredConstructor;
        Object[] objArr;
        fb fbVar = (fb) cls.getAnnotation(fb.class);
        Class<?> cls2 = null;
        if (fbVar == null || !fbVar.generateAdapter()) {
            return null;
        }
        try {
            try {
                Class<?> cls3 = Class.forName(x4.v(cls.getName()), true, cls.getClassLoader());
                try {
                    if (type instanceof ParameterizedType) {
                        Type[] actualTypeArguments = ((ParameterizedType) type).getActualTypeArguments();
                        try {
                            declaredConstructor = cls3.getDeclaredConstructor(co.class, Type[].class);
                            objArr = new Object[]{coVar, actualTypeArguments};
                        } catch (NoSuchMethodException unused) {
                            declaredConstructor = cls3.getDeclaredConstructor(Type[].class);
                            objArr = new Object[]{actualTypeArguments};
                        }
                    } else {
                        try {
                            Object[] objArr2 = {coVar};
                            declaredConstructor = cls3.getDeclaredConstructor(co.class);
                            objArr = objArr2;
                        } catch (NoSuchMethodException unused2) {
                            declaredConstructor = cls3.getDeclaredConstructor(null);
                            objArr = new Object[0];
                        }
                    }
                    declaredConstructor.setAccessible(true);
                    return ((a) declaredConstructor.newInstance(objArr)).gv();
                } catch (NoSuchMethodException e2) {
                    e = e2;
                    cls2 = cls3;
                    if (!(type instanceof ParameterizedType) && cls2.getTypeParameters().length != 0) {
                        throw new RuntimeException("Failed to find the generated JsonAdapter constructor for '" + type + "'. Suspiciously, the type was not parameterized but the target class '" + cls2.getCanonicalName() + "' is generic. Consider using Types#newParameterizedType() to define these missing type variables.", e);
                    }
                    throw new RuntimeException("Failed to find the generated JsonAdapter constructor for " + type, e);
                }
            } catch (NoSuchMethodException e3) {
                e = e3;
            }
        } catch (ClassNotFoundException e5) {
            throw new RuntimeException("Failed to find the generated JsonAdapter class for " + type, e5);
        } catch (IllegalAccessException e6) {
            throw new RuntimeException("Failed to access the generated JsonAdapter for " + type, e6);
        } catch (InstantiationException e8) {
            throw new RuntimeException("Failed to instantiate the generated JsonAdapter for " + type, e8);
        } catch (InvocationTargetException e9) {
            throw co(e9);
        }
    }

    public static Set<? extends Annotation> i9(AnnotatedElement annotatedElement) {
        return f(annotatedElement.getAnnotations());
    }

    public static Type mt(Type type, Class<?> cls, TypeVariable<?> typeVariable) {
        Class<?> zn2 = zn(typeVariable);
        if (zn2 == null) {
            return typeVariable;
        }
        Type v2 = v(type, cls, zn2);
        if (v2 instanceof ParameterizedType) {
            return ((ParameterizedType) v2).getActualTypeArguments()[fb(zn2.getTypeParameters(), typeVariable)];
        }
        return typeVariable;
    }

    public static void n3(Type type) {
        if ((type instanceof Class) && ((Class) type).isPrimitive()) {
            throw new IllegalArgumentException("Unexpected primitive " + type + ". Use the boxed type.");
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:0:?, code lost:
        r10 = r10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.reflect.Type p(java.lang.reflect.Type r8, java.lang.Class<?> r9, java.lang.reflect.Type r10, java.util.Collection<java.lang.reflect.TypeVariable<?>> r11) {
        /*
        L0:
            boolean r0 = r10 instanceof java.lang.reflect.TypeVariable
            if (r0 == 0) goto L18
            r0 = r10
            java.lang.reflect.TypeVariable r0 = (java.lang.reflect.TypeVariable) r0
            boolean r1 = r11.contains(r0)
            if (r1 == 0) goto Le
            return r10
        Le:
            r11.add(r0)
            java.lang.reflect.Type r10 = mt(r8, r9, r0)
            if (r10 != r0) goto L0
            return r10
        L18:
            boolean r0 = r10 instanceof java.lang.Class
            if (r0 == 0) goto L35
            r0 = r10
            java.lang.Class r0 = (java.lang.Class) r0
            boolean r1 = r0.isArray()
            if (r1 == 0) goto L35
            java.lang.Class r10 = r0.getComponentType()
            java.lang.reflect.Type r8 = p(r8, r9, r10, r11)
            if (r10 != r8) goto L30
            goto L34
        L30:
            java.lang.reflect.GenericArrayType r0 = o6.x4.n3(r8)
        L34:
            return r0
        L35:
            boolean r0 = r10 instanceof java.lang.reflect.GenericArrayType
            if (r0 == 0) goto L4b
            java.lang.reflect.GenericArrayType r10 = (java.lang.reflect.GenericArrayType) r10
            java.lang.reflect.Type r0 = r10.getGenericComponentType()
            java.lang.reflect.Type r8 = p(r8, r9, r0, r11)
            if (r0 != r8) goto L46
            goto L4a
        L46:
            java.lang.reflect.GenericArrayType r10 = o6.x4.n3(r8)
        L4a:
            return r10
        L4b:
            boolean r0 = r10 instanceof java.lang.reflect.ParameterizedType
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L8d
            java.lang.reflect.ParameterizedType r10 = (java.lang.reflect.ParameterizedType) r10
            java.lang.reflect.Type r0 = r10.getOwnerType()
            java.lang.reflect.Type r3 = p(r8, r9, r0, r11)
            if (r3 == r0) goto L5f
            r0 = 1
            goto L60
        L5f:
            r0 = 0
        L60:
            java.lang.reflect.Type[] r4 = r10.getActualTypeArguments()
            int r5 = r4.length
        L65:
            if (r2 >= r5) goto L80
            r6 = r4[r2]
            java.lang.reflect.Type r6 = p(r8, r9, r6, r11)
            r7 = r4[r2]
            if (r6 == r7) goto L7d
            if (r0 != 0) goto L7b
            java.lang.Object r0 = r4.clone()
            r4 = r0
            java.lang.reflect.Type[] r4 = (java.lang.reflect.Type[]) r4
            r0 = 1
        L7b:
            r4[r2] = r6
        L7d:
            int r2 = r2 + 1
            goto L65
        L80:
            if (r0 == 0) goto L8c
            p6.n3$n3 r8 = new p6.n3$n3
            java.lang.reflect.Type r9 = r10.getRawType()
            r8.<init>(r3, r9, r4)
            r10 = r8
        L8c:
            return r10
        L8d:
            boolean r0 = r10 instanceof java.lang.reflect.WildcardType
            if (r0 == 0) goto Lc1
            java.lang.reflect.WildcardType r10 = (java.lang.reflect.WildcardType) r10
            java.lang.reflect.Type[] r0 = r10.getLowerBounds()
            java.lang.reflect.Type[] r3 = r10.getUpperBounds()
            int r4 = r0.length
            if (r4 != r1) goto Lad
            r1 = r0[r2]
            java.lang.reflect.Type r8 = p(r8, r9, r1, r11)
            r9 = r0[r2]
            if (r8 == r9) goto Lc1
            java.lang.reflect.WildcardType r8 = o6.x4.t(r8)
            return r8
        Lad:
            int r0 = r3.length
            if (r0 != r1) goto Lc1
            r0 = r3[r2]
            java.lang.reflect.Type r8 = p(r8, r9, r0, r11)     // Catch: java.lang.Throwable -> Lbf
            r9 = r3[r2]
            if (r8 == r9) goto Lc1
            java.lang.reflect.WildcardType r8 = o6.x4.f(r8)
            return r8
        Lbf:
            r8 = move-exception
            throw r8
        Lc1:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: p6.n3.p(java.lang.reflect.Type, java.lang.Class, java.lang.reflect.Type, java.util.Collection):java.lang.reflect.Type");
    }

    public static String r(Type type) {
        if (type instanceof Class) {
            return ((Class) type).getName();
        }
        return type.toString();
    }

    public static boolean s(Class<?> cls) {
        Class<? extends Annotation> cls2 = f12434gv;
        if (cls2 != null && cls.isAnnotationPresent(cls2)) {
            return true;
        }
        return false;
    }

    public static String t(String str, AnnotatedElement annotatedElement) {
        return tl(str, (v) annotatedElement.getAnnotation(v.class));
    }

    public static String tl(String str, v vVar) {
        if (vVar == null) {
            return str;
        }
        String name = vVar.name();
        if (!"\u0000".equals(name)) {
            return name;
        }
        return str;
    }

    public static Type v(Type type, Class<?> cls, Class<?> cls2) {
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
                    return v(cls.getGenericInterfaces()[i], interfaces[i], cls2);
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
                    return v(cls.getGenericSuperclass(), superclass, cls2);
                }
                cls = superclass;
            }
        }
        return cls2;
    }

    public static Type w(Type type, Class<?> cls, Type type2) {
        return p(type, cls, type2, new LinkedHashSet());
    }

    public static s wz(String str, String str2, f fVar) {
        String format;
        String path = fVar.getPath();
        if (str2.equals(str)) {
            format = String.format("Required value '%s' missing at %s", str, path);
        } else {
            format = String.format("Required value '%s' (JSON name '%s') missing at %s", str, str2, path);
        }
        return new s(format);
    }

    public static s x4(String str, String str2, f fVar) {
        String format;
        String path = fVar.getPath();
        if (str2.equals(str)) {
            format = String.format("Non-null value '%s' was null at %s", str, path);
        } else {
            format = String.format("Non-null value '%s' (JSON name '%s') was null at %s", str, str2, path);
        }
        return new s(format);
    }

    public static Type xc(Type type) {
        if (!(type instanceof WildcardType)) {
            return type;
        }
        WildcardType wildcardType = (WildcardType) type;
        if (wildcardType.getLowerBounds().length != 0) {
            return type;
        }
        Type[] upperBounds = wildcardType.getUpperBounds();
        if (upperBounds.length == 1) {
            return upperBounds[0];
        }
        throw new IllegalArgumentException();
    }

    public static Type y(Type type) {
        if (type instanceof Class) {
            Class cls = (Class) type;
            if (cls.isArray()) {
                return new y(y(cls.getComponentType()));
            }
            return cls;
        } else if (type instanceof ParameterizedType) {
            if (type instanceof C0180n3) {
                return type;
            }
            ParameterizedType parameterizedType = (ParameterizedType) type;
            return new C0180n3(parameterizedType.getOwnerType(), parameterizedType.getRawType(), parameterizedType.getActualTypeArguments());
        } else if (type instanceof GenericArrayType) {
            if (type instanceof y) {
                return type;
            }
            return new y(((GenericArrayType) type).getGenericComponentType());
        } else if (type instanceof WildcardType) {
            if (type instanceof zn) {
                return type;
            }
            WildcardType wildcardType = (WildcardType) type;
            return new zn(wildcardType.getUpperBounds(), wildcardType.getLowerBounds());
        } else {
            return type;
        }
    }

    public static String z(Type type, Set<? extends Annotation> set) {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append(type);
        if (set.isEmpty()) {
            str = " (with no annotations)";
        } else {
            str = " annotated " + set;
        }
        sb.append(str);
        return sb.toString();
    }

    public static Class<?> zn(TypeVariable<?> typeVariable) {
        Object genericDeclaration = typeVariable.getGenericDeclaration();
        if (genericDeclaration instanceof Class) {
            return (Class) genericDeclaration;
        }
        return null;
    }
}
