package androidx.lifecycle;

import android.app.Application;
import androidx.annotation.NonNull;
import java.lang.reflect.InvocationTargetException;
import y5.b;
import y5.ud;
/* loaded from: classes.dex */
public class wz {

    /* renamed from: n3  reason: collision with root package name */
    public final b f2659n3;
    public final n3 y;

    /* loaded from: classes.dex */
    public static class gv implements n3 {
        public static gv y;

        @NonNull
        public static gv y() {
            if (y == null) {
                y = new gv();
            }
            return y;
        }

        @Override // androidx.lifecycle.wz.n3
        @NonNull
        public <T extends ud> T create(@NonNull Class<T> cls) {
            try {
                return cls.newInstance();
            } catch (IllegalAccessException e2) {
                throw new RuntimeException("Cannot create an instance of " + cls, e2);
            } catch (InstantiationException e3) {
                throw new RuntimeException("Cannot create an instance of " + cls, e3);
            }
        }
    }

    /* loaded from: classes.dex */
    public interface n3 {
        @NonNull
        <T extends ud> T create(@NonNull Class<T> cls);
    }

    /* loaded from: classes.dex */
    public static class y extends gv {

        /* renamed from: zn  reason: collision with root package name */
        public static y f2660zn;

        /* renamed from: n3  reason: collision with root package name */
        public Application f2661n3;

        public y(@NonNull Application application) {
            this.f2661n3 = application;
        }

        @NonNull
        public static y n3(@NonNull Application application) {
            if (f2660zn == null) {
                f2660zn = new y(application);
            }
            return f2660zn;
        }

        @Override // androidx.lifecycle.wz.gv, androidx.lifecycle.wz.n3
        @NonNull
        public <T extends ud> T create(@NonNull Class<T> cls) {
            if (y5.y.class.isAssignableFrom(cls)) {
                try {
                    return cls.getConstructor(Application.class).newInstance(this.f2661n3);
                } catch (IllegalAccessException e2) {
                    throw new RuntimeException("Cannot create an instance of " + cls, e2);
                } catch (InstantiationException e3) {
                    throw new RuntimeException("Cannot create an instance of " + cls, e3);
                } catch (NoSuchMethodException e5) {
                    throw new RuntimeException("Cannot create an instance of " + cls, e5);
                } catch (InvocationTargetException e6) {
                    throw new RuntimeException("Cannot create an instance of " + cls, e6);
                }
            }
            return (T) super.create(cls);
        }
    }

    /* loaded from: classes.dex */
    public static abstract class zn extends v implements n3 {
        @NonNull
        public <T extends ud> T create(@NonNull Class<T> cls) {
            throw new UnsupportedOperationException("create(String, Class<?>) must be called on implementaions of KeyedFactory");
        }

        @NonNull
        public abstract <T extends ud> T n3(@NonNull String str, @NonNull Class<T> cls);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public wz(@androidx.annotation.NonNull y5.k5 r3) {
        /*
            r2 = this;
            y5.b r0 = r3.getViewModelStore()
            boolean r1 = r3 instanceof androidx.lifecycle.gv
            if (r1 == 0) goto Lf
            androidx.lifecycle.gv r3 = (androidx.lifecycle.gv) r3
            androidx.lifecycle.wz$n3 r3 = r3.getDefaultViewModelProviderFactory()
            goto L13
        Lf:
            androidx.lifecycle.wz$gv r3 = androidx.lifecycle.wz.gv.y()
        L13:
            r2.<init>(r0, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.lifecycle.wz.<init>(y5.k5):void");
    }

    @NonNull
    public <T extends ud> T n3(@NonNull String str, @NonNull Class<T> cls) {
        T t2;
        T t3 = (T) this.f2659n3.n3(str);
        if (cls.isInstance(t3)) {
            n3 n3Var = this.y;
            if (n3Var instanceof v) {
                ((v) n3Var).y(t3);
            }
            return t3;
        }
        n3 n3Var2 = this.y;
        if (n3Var2 instanceof zn) {
            t2 = (T) ((zn) n3Var2).n3(str, cls);
        } else {
            t2 = (T) n3Var2.create(cls);
        }
        this.f2659n3.gv(str, t2);
        return t2;
    }

    @NonNull
    public <T extends ud> T y(@NonNull Class<T> cls) {
        String canonicalName = cls.getCanonicalName();
        if (canonicalName != null) {
            return (T) n3("androidx.lifecycle.ViewModelProvider.DefaultKey:" + canonicalName, cls);
        }
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }

    public wz(@NonNull b bVar, @NonNull n3 n3Var) {
        this.y = n3Var;
        this.f2659n3 = bVar;
    }

    /* loaded from: classes.dex */
    public static class v {
        public void y(@NonNull ud udVar) {
        }
    }
}
