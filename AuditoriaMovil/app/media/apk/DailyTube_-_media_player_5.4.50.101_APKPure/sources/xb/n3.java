package xb;

import android.os.Parcelable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/* loaded from: classes.dex */
public abstract class n3 {

    /* renamed from: n3  reason: collision with root package name */
    public final z.y<String, Method> f14925n3;
    public final z.y<String, Method> y;

    /* renamed from: zn  reason: collision with root package name */
    public final z.y<String, Class> f14926zn;

    public n3(z.y<String, Method> yVar, z.y<String, Method> yVar2, z.y<String, Class> yVar3) {
        this.y = yVar;
        this.f14925n3 = yVar2;
        this.f14926zn = yVar3;
    }

    public boolean a() {
        return false;
    }

    public void a8(String str, int i) {
        i4(i);
        ud(str);
    }

    public void b(gv gvVar) {
        if (gvVar == null) {
            ud(null);
            return;
        }
        yt(gvVar);
        n3 n32 = n3();
        x(gvVar, n32);
        n32.y();
    }

    public void c(boolean z2, int i) {
        i4(i);
        n(z2);
    }

    public abstract byte[] c5();

    public abstract String co();

    public void d(int i, int i5) {
        i4(i5);
        ta(i);
    }

    public abstract void d0(byte[] bArr);

    public void ej(Parcelable parcelable, int i) {
        i4(i);
        z6(parcelable);
    }

    public abstract CharSequence f();

    public abstract boolean fb();

    public void fh(byte[] bArr, int i) {
        i4(i);
        d0(bArr);
    }

    public final Method gv(String str) throws IllegalAccessException, NoSuchMethodException, ClassNotFoundException {
        Method method = this.y.get(str);
        if (method == null) {
            System.currentTimeMillis();
            Method declaredMethod = Class.forName(str, true, n3.class.getClassLoader()).getDeclaredMethod("read", n3.class);
            this.y.put(str, declaredMethod);
            return declaredMethod;
        }
        return method;
    }

    public abstract void i4(int i);

    public byte[] i9(byte[] bArr, int i) {
        if (!tl(i)) {
            return bArr;
        }
        return c5();
    }

    public void k5(gv gvVar, int i) {
        i4(i);
        b(gvVar);
    }

    public void mg(CharSequence charSequence, int i) {
        i4(i);
        rz(charSequence);
    }

    public <T extends Parcelable> T mt(T t2, int i) {
        if (!tl(i)) {
            return t2;
        }
        return (T) p();
    }

    public abstract void n(boolean z2);

    public abstract n3 n3();

    public abstract <T extends Parcelable> T p();

    public <T extends gv> T r() {
        String co2 = co();
        if (co2 == null) {
            return null;
        }
        return (T) wz(co2, n3());
    }

    public abstract void rz(CharSequence charSequence);

    public boolean s(boolean z2, int i) {
        if (!tl(i)) {
            return z2;
        }
        return fb();
    }

    public CharSequence t(CharSequence charSequence, int i) {
        if (!tl(i)) {
            return charSequence;
        }
        return f();
    }

    public abstract void ta(int i);

    public abstract boolean tl(int i);

    public abstract void ud(String str);

    public final Method v(Class cls) throws IllegalAccessException, NoSuchMethodException, ClassNotFoundException {
        Method method = this.f14925n3.get(cls.getName());
        if (method == null) {
            Class zn2 = zn(cls);
            System.currentTimeMillis();
            Method declaredMethod = zn2.getDeclaredMethod("write", cls, n3.class);
            this.f14925n3.put(cls.getName(), declaredMethod);
            return declaredMethod;
        }
        return method;
    }

    public int w(int i, int i5) {
        if (!tl(i5)) {
            return i;
        }
        return xc();
    }

    public <T extends gv> T wz(String str, n3 n3Var) {
        try {
            return (T) gv(str).invoke(null, n3Var);
        } catch (ClassNotFoundException e2) {
            throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e2);
        } catch (IllegalAccessException e3) {
            throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e3);
        } catch (NoSuchMethodException e5) {
            throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e5);
        } catch (InvocationTargetException e6) {
            if (e6.getCause() instanceof RuntimeException) {
                throw ((RuntimeException) e6.getCause());
            }
            throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e6);
        }
    }

    public <T extends gv> void x(T t2, n3 n3Var) {
        try {
            v(t2.getClass()).invoke(null, t2, n3Var);
        } catch (ClassNotFoundException e2) {
            throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e2);
        } catch (IllegalAccessException e3) {
            throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e3);
        } catch (NoSuchMethodException e5) {
            throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e5);
        } catch (InvocationTargetException e6) {
            if (e6.getCause() instanceof RuntimeException) {
                throw ((RuntimeException) e6.getCause());
            }
            throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e6);
        }
    }

    public <T extends gv> T x4(T t2, int i) {
        if (!tl(i)) {
            return t2;
        }
        return (T) r();
    }

    public abstract int xc();

    public abstract void y();

    /* JADX WARN: Multi-variable type inference failed */
    public final void yt(gv gvVar) {
        try {
            ud(zn(gvVar.getClass()).getName());
        } catch (ClassNotFoundException e2) {
            throw new RuntimeException(gvVar.getClass().getSimpleName() + " does not have a Parcelizer", e2);
        }
    }

    public String z(String str, int i) {
        if (!tl(i)) {
            return str;
        }
        return co();
    }

    public abstract void z6(Parcelable parcelable);

    public final Class zn(Class<? extends gv> cls) throws ClassNotFoundException {
        Class cls2 = this.f14926zn.get(cls.getName());
        if (cls2 == null) {
            Class<?> cls3 = Class.forName(String.format("%s.%sParcelizer", cls.getPackage().getName(), cls.getSimpleName()), false, cls.getClassLoader());
            this.f14926zn.put(cls.getName(), cls3);
            return cls3;
        }
        return cls2;
    }

    public void f3(boolean z2, boolean z3) {
    }
}
