package o6;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import o6.a;
import o6.f;
/* loaded from: classes.dex */
public final class zn<T> extends a<T> {

    /* renamed from: gv  reason: collision with root package name */
    public static final a.y f12236gv = new y();

    /* renamed from: n3  reason: collision with root package name */
    public final n3<?>[] f12237n3;
    public final o6.n3<T> y;

    /* renamed from: zn  reason: collision with root package name */
    public final f.y f12238zn;

    /* loaded from: classes.dex */
    public static class n3<T> {

        /* renamed from: n3  reason: collision with root package name */
        public final Field f12239n3;
        public final String y;

        /* renamed from: zn  reason: collision with root package name */
        public final a<T> f12240zn;

        public n3(String str, Field field, a<T> aVar) {
            this.y = str;
            this.f12239n3 = field;
            this.f12240zn = aVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void n3(w wVar, Object obj) throws IllegalAccessException, IOException {
            this.f12240zn.a(wVar, this.f12239n3.get(obj));
        }

        public void y(f fVar, Object obj) throws IOException, IllegalAccessException {
            this.f12239n3.set(obj, this.f12240zn.n3(fVar));
        }
    }

    /* loaded from: classes.dex */
    public class y implements a.y {
        public final void gv(Type type, Class<?> cls) {
            Class<?> fb2 = x4.fb(type);
            if (!cls.isAssignableFrom(fb2)) {
                return;
            }
            throw new IllegalArgumentException("No JsonAdapter for " + type + ", you should probably use " + cls.getSimpleName() + " instead of " + fb2.getSimpleName() + " (Moshi only supports the collection interfaces by default) or else register a custom JsonAdapter.");
        }

        public final void n3(co coVar, Type type, Map<String, n3<?>> map) {
            Field[] declaredFields;
            v vVar;
            n3<?> n3Var;
            n3<?> put;
            Class<?> fb2 = x4.fb(type);
            boolean c52 = p6.n3.c5(fb2);
            for (Field field : fb2.getDeclaredFields()) {
                if (zn(c52, field.getModifiers()) && ((vVar = (v) field.getAnnotation(v.class)) == null || !vVar.ignore())) {
                    Type w4 = p6.n3.w(type, fb2, field.getGenericType());
                    Set<? extends Annotation> i92 = p6.n3.i9(field);
                    String name = field.getName();
                    a<T> a2 = coVar.a(w4, i92, name);
                    field.setAccessible(true);
                    String tl2 = p6.n3.tl(name, vVar);
                    if (map.put(tl2, new n3<>(tl2, field, a2)) != null) {
                        throw new IllegalArgumentException("Conflicting fields:\n    " + put.f12239n3 + "\n    " + n3Var.f12239n3);
                    }
                }
            }
        }

        @Override // o6.a.y
        public a<?> y(Type type, Set<? extends Annotation> set, co coVar) {
            if (!(type instanceof Class) && !(type instanceof ParameterizedType)) {
                return null;
            }
            Class<?> fb2 = x4.fb(type);
            if (fb2.isInterface() || fb2.isEnum() || !set.isEmpty()) {
                return null;
            }
            if (p6.n3.c5(fb2)) {
                gv(type, List.class);
                gv(type, Set.class);
                gv(type, Map.class);
                gv(type, Collection.class);
                String str = "Platform " + fb2;
                if (type instanceof ParameterizedType) {
                    str = str + " in " + type;
                }
                throw new IllegalArgumentException(str + " requires explicit JsonAdapter to be registered");
            } else if (!fb2.isAnonymousClass()) {
                if (!fb2.isLocalClass()) {
                    if (fb2.getEnclosingClass() != null && !Modifier.isStatic(fb2.getModifiers())) {
                        throw new IllegalArgumentException("Cannot serialize non-static nested class " + fb2.getName());
                    } else if (!Modifier.isAbstract(fb2.getModifiers())) {
                        if (!p6.n3.s(fb2)) {
                            o6.n3 y = o6.n3.y(fb2);
                            TreeMap treeMap = new TreeMap();
                            while (type != Object.class) {
                                n3(coVar, type, treeMap);
                                type = x4.a(type);
                            }
                            return (a<T>) new zn(y, treeMap).gv();
                        }
                        throw new IllegalArgumentException("Cannot serialize Kotlin type " + fb2.getName() + ". Reflective serialization of Kotlin classes without using kotlin-reflect has undefined and unexpected behavior. Please use KotlinJsonAdapterFactory from the moshi-kotlin artifact or use code gen from the moshi-kotlin-codegen artifact.");
                    } else {
                        throw new IllegalArgumentException("Cannot serialize abstract class " + fb2.getName());
                    }
                }
                throw new IllegalArgumentException("Cannot serialize local class " + fb2.getName());
            } else {
                throw new IllegalArgumentException("Cannot serialize anonymous class " + fb2.getName());
            }
        }

        public final boolean zn(boolean z2, int i) {
            if (Modifier.isStatic(i) || Modifier.isTransient(i)) {
                return false;
            }
            if (!Modifier.isPublic(i) && !Modifier.isProtected(i) && z2) {
                return false;
            }
            return true;
        }
    }

    public zn(o6.n3<T> n3Var, Map<String, n3<?>> map) {
        this.y = n3Var;
        this.f12237n3 = (n3[]) map.values().toArray(new n3[map.size()]);
        this.f12238zn = f.y.y((String[]) map.keySet().toArray(new String[map.size()]));
    }

    @Override // o6.a
    public void a(w wVar, T t2) throws IOException {
        n3<?>[] n3VarArr;
        try {
            wVar.v();
            for (n3<?> n3Var : this.f12237n3) {
                wVar.co(n3Var.y);
                n3Var.n3(wVar, t2);
            }
            wVar.mt();
        } catch (IllegalAccessException unused) {
            throw new AssertionError();
        }
    }

    @Override // o6.a
    public T n3(f fVar) throws IOException {
        try {
            T n32 = this.y.n3();
            try {
                fVar.v();
                while (fVar.mt()) {
                    int jz2 = fVar.jz(this.f12238zn);
                    if (jz2 == -1) {
                        fVar.ct();
                        fVar.o4();
                    } else {
                        this.f12237n3[jz2].y(fVar, n32);
                    }
                }
                fVar.p();
                return n32;
            } catch (IllegalAccessException unused) {
                throw new AssertionError();
            }
        } catch (IllegalAccessException unused2) {
            throw new AssertionError();
        } catch (InstantiationException e2) {
            throw new RuntimeException(e2);
        } catch (InvocationTargetException e3) {
            throw p6.n3.co(e3);
        }
    }

    public String toString() {
        return "JsonAdapter(" + this.y + ")";
    }
}
