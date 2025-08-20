package o6;

import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/* loaded from: classes.dex */
public abstract class n3<T> {

    /* loaded from: classes.dex */
    public class gv extends n3<T> {

        /* renamed from: n3  reason: collision with root package name */
        public final /* synthetic */ Class f12175n3;
        public final /* synthetic */ Method y;

        public gv(Method method, Class cls) {
            this.y = method;
            this.f12175n3 = cls;
        }

        @Override // o6.n3
        public T n3() throws InvocationTargetException, IllegalAccessException {
            return (T) this.y.invoke(null, this.f12175n3, Object.class);
        }

        public String toString() {
            return this.f12175n3.getName();
        }
    }

    /* renamed from: o6.n3$n3  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0173n3 extends n3<T> {

        /* renamed from: n3  reason: collision with root package name */
        public final /* synthetic */ Object f12176n3;
        public final /* synthetic */ Method y;

        /* renamed from: zn  reason: collision with root package name */
        public final /* synthetic */ Class f12177zn;

        public C0173n3(Method method, Object obj, Class cls) {
            this.y = method;
            this.f12176n3 = obj;
            this.f12177zn = cls;
        }

        @Override // o6.n3
        public T n3() throws InvocationTargetException, IllegalAccessException {
            return (T) this.y.invoke(this.f12176n3, this.f12177zn);
        }

        public String toString() {
            return this.f12177zn.getName();
        }
    }

    /* loaded from: classes.dex */
    public class y extends n3<T> {

        /* renamed from: n3  reason: collision with root package name */
        public final /* synthetic */ Class f12178n3;
        public final /* synthetic */ Constructor y;

        public y(Constructor constructor, Class cls) {
            this.y = constructor;
            this.f12178n3 = cls;
        }

        @Override // o6.n3
        public T n3() throws IllegalAccessException, InvocationTargetException, InstantiationException {
            return (T) this.y.newInstance(null);
        }

        public String toString() {
            return this.f12178n3.getName();
        }
    }

    /* loaded from: classes.dex */
    public class zn extends n3<T> {

        /* renamed from: n3  reason: collision with root package name */
        public final /* synthetic */ Class f12179n3;
        public final /* synthetic */ Method y;

        /* renamed from: zn  reason: collision with root package name */
        public final /* synthetic */ int f12180zn;

        public zn(Method method, Class cls, int i) {
            this.y = method;
            this.f12179n3 = cls;
            this.f12180zn = i;
        }

        @Override // o6.n3
        public T n3() throws InvocationTargetException, IllegalAccessException {
            return (T) this.y.invoke(null, this.f12179n3, Integer.valueOf(this.f12180zn));
        }

        public String toString() {
            return this.f12179n3.getName();
        }
    }

    public static <T> n3<T> y(Class<?> cls) {
        try {
            try {
                try {
                    try {
                        Constructor<?> declaredConstructor = cls.getDeclaredConstructor(null);
                        declaredConstructor.setAccessible(true);
                        return new y(declaredConstructor, cls);
                    } catch (Exception unused) {
                        throw new IllegalArgumentException("cannot construct instances of " + cls.getName());
                    }
                } catch (NoSuchMethodException unused2) {
                    Class<?> cls2 = Class.forName("sun.misc.Unsafe");
                    Field declaredField = cls2.getDeclaredField("theUnsafe");
                    declaredField.setAccessible(true);
                    return new C0173n3(cls2.getMethod("allocateInstance", Class.class), declaredField.get(null), cls);
                }
            } catch (ClassNotFoundException | NoSuchFieldException | NoSuchMethodException unused3) {
                Method declaredMethod = ObjectStreamClass.class.getDeclaredMethod("getConstructorId", Class.class);
                declaredMethod.setAccessible(true);
                int intValue = ((Integer) declaredMethod.invoke(null, Object.class)).intValue();
                Method declaredMethod2 = ObjectStreamClass.class.getDeclaredMethod("newInstance", Class.class, Integer.TYPE);
                declaredMethod2.setAccessible(true);
                return new zn(declaredMethod2, cls, intValue);
            } catch (IllegalAccessException unused4) {
                throw new AssertionError();
            }
        } catch (IllegalAccessException unused5) {
            throw new AssertionError();
        } catch (NoSuchMethodException unused6) {
            Method declaredMethod3 = ObjectInputStream.class.getDeclaredMethod("newInstance", Class.class, Class.class);
            declaredMethod3.setAccessible(true);
            return new gv(declaredMethod3, cls);
        } catch (InvocationTargetException e2) {
            throw p6.n3.co(e2);
        }
    }

    public abstract T n3() throws InvocationTargetException, IllegalAccessException, InstantiationException;
}
