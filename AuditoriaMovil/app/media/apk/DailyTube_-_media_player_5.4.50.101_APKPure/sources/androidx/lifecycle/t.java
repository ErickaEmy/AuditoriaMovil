package androidx.lifecycle;

import android.annotation.SuppressLint;
import android.app.Application;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.wz;
import androidx.savedstate.SavedStateRegistry;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import y5.ta;
import y5.ud;
/* loaded from: classes.dex */
public final class t extends wz.zn {

    /* renamed from: a  reason: collision with root package name */
    public static final Class<?>[] f2643a = {Application.class, ta.class};

    /* renamed from: fb  reason: collision with root package name */
    public static final Class<?>[] f2644fb = {ta.class};

    /* renamed from: gv  reason: collision with root package name */
    public final v f2645gv;

    /* renamed from: n3  reason: collision with root package name */
    public final wz.n3 f2646n3;

    /* renamed from: v  reason: collision with root package name */
    public final SavedStateRegistry f2647v;
    public final Application y;

    /* renamed from: zn  reason: collision with root package name */
    public final Bundle f2648zn;

    @SuppressLint({"LambdaLast"})
    public t(@Nullable Application application, @NonNull g.y yVar, @Nullable Bundle bundle) {
        wz.n3 y;
        this.f2647v = yVar.getSavedStateRegistry();
        this.f2645gv = yVar.getLifecycle();
        this.f2648zn = bundle;
        this.y = application;
        if (application != null) {
            y = wz.y.n3(application);
        } else {
            y = wz.gv.y();
        }
        this.f2646n3 = y;
    }

    public static <T> Constructor<T> zn(Class<T> cls, Class<?>[] clsArr) {
        for (Constructor<?> constructor : cls.getConstructors()) {
            Constructor<T> constructor2 = (Constructor<T>) constructor;
            if (Arrays.equals(clsArr, constructor2.getParameterTypes())) {
                return constructor2;
            }
        }
        return null;
    }

    @Override // androidx.lifecycle.wz.zn, androidx.lifecycle.wz.n3
    @NonNull
    public <T extends ud> T create(@NonNull Class<T> cls) {
        String canonicalName = cls.getCanonicalName();
        if (canonicalName != null) {
            return (T) n3(canonicalName, cls);
        }
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }

    @Override // androidx.lifecycle.wz.zn
    @NonNull
    public <T extends ud> T n3(@NonNull String str, @NonNull Class<T> cls) {
        Constructor zn2;
        T t2;
        boolean isAssignableFrom = y5.y.class.isAssignableFrom(cls);
        if (isAssignableFrom && this.y != null) {
            zn2 = zn(cls, f2643a);
        } else {
            zn2 = zn(cls, f2644fb);
        }
        if (zn2 == null) {
            return (T) this.f2646n3.create(cls);
        }
        SavedStateHandleController zn3 = SavedStateHandleController.zn(this.f2647v, this.f2645gv, str, this.f2648zn);
        if (isAssignableFrom) {
            try {
                Application application = this.y;
                if (application != null) {
                    t2 = (T) zn2.newInstance(application, zn3.gv());
                    t2.setTagIfAbsent("androidx.lifecycle.savedstate.vm.tag", zn3);
                    return t2;
                }
            } catch (IllegalAccessException e2) {
                throw new RuntimeException("Failed to access " + cls, e2);
            } catch (InstantiationException e3) {
                throw new RuntimeException("A " + cls + " cannot be instantiated.", e3);
            } catch (InvocationTargetException e5) {
                throw new RuntimeException("An exception happened in constructor of " + cls, e5.getCause());
            }
        }
        t2 = (T) zn2.newInstance(zn3.gv());
        t2.setTagIfAbsent("androidx.lifecycle.savedstate.vm.tag", zn3);
        return t2;
    }

    @Override // androidx.lifecycle.wz.v
    public void y(@NonNull ud udVar) {
        SavedStateHandleController.y(udVar, this.f2647v, this.f2645gv);
    }
}
