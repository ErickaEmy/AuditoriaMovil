package rz;

import android.app.Activity;
import android.app.Application;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.NonNull;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;
/* loaded from: classes.dex */
public final class gv {

    /* renamed from: a  reason: collision with root package name */
    public static final Method f13342a;

    /* renamed from: fb  reason: collision with root package name */
    public static final Handler f13343fb = new Handler(Looper.getMainLooper());

    /* renamed from: gv  reason: collision with root package name */
    public static final Method f13344gv;

    /* renamed from: n3  reason: collision with root package name */
    public static final Field f13345n3;

    /* renamed from: v  reason: collision with root package name */
    public static final Method f13346v;
    public static final Class<?> y;

    /* renamed from: zn  reason: collision with root package name */
    public static final Field f13347zn;

    /* loaded from: classes.dex */
    public class n3 implements Runnable {

        /* renamed from: v  reason: collision with root package name */
        public final /* synthetic */ C0208gv f13353v;
        public final /* synthetic */ Application y;

        public n3(Application application, C0208gv c0208gv) {
            this.y = application;
            this.f13353v = c0208gv;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.y.unregisterActivityLifecycleCallbacks(this.f13353v);
        }
    }

    /* loaded from: classes.dex */
    public class y implements Runnable {

        /* renamed from: v  reason: collision with root package name */
        public final /* synthetic */ Object f13354v;
        public final /* synthetic */ C0208gv y;

        public y(C0208gv c0208gv, Object obj) {
            this.y = c0208gv;
            this.f13354v = obj;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.y.y = this.f13354v;
        }
    }

    /* loaded from: classes.dex */
    public class zn implements Runnable {

        /* renamed from: v  reason: collision with root package name */
        public final /* synthetic */ Object f13355v;
        public final /* synthetic */ Object y;

        public zn(Object obj, Object obj2) {
            this.y = obj;
            this.f13355v = obj2;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Method method = gv.f13344gv;
                if (method != null) {
                    method.invoke(this.y, this.f13355v, Boolean.FALSE, "AppCompat recreation");
                } else {
                    gv.f13346v.invoke(this.y, this.f13355v, Boolean.FALSE);
                }
            } catch (RuntimeException e2) {
                if (e2.getClass() == RuntimeException.class && e2.getMessage() != null && e2.getMessage().startsWith("Unable to stop")) {
                    throw e2;
                }
            } catch (Throwable th) {
                Log.e("ActivityRecreator", "Exception while invoking performStopActivity", th);
            }
        }
    }

    static {
        Class<?> y2 = y();
        y = y2;
        f13345n3 = n3();
        f13347zn = a();
        f13344gv = gv(y2);
        f13346v = zn(y2);
        f13342a = v(y2);
    }

    public static Field a() {
        try {
            Field declaredField = Activity.class.getDeclaredField("mToken");
            declaredField.setAccessible(true);
            return declaredField;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static boolean c5(@NonNull Activity activity) {
        Object obj;
        if (Build.VERSION.SDK_INT >= 28) {
            activity.recreate();
            return true;
        } else if (fb() && f13342a == null) {
            return false;
        } else {
            if (f13346v == null && f13344gv == null) {
                return false;
            }
            try {
                Object obj2 = f13347zn.get(activity);
                if (obj2 == null || (obj = f13345n3.get(activity)) == null) {
                    return false;
                }
                Application application = activity.getApplication();
                C0208gv c0208gv = new C0208gv(activity);
                application.registerActivityLifecycleCallbacks(c0208gv);
                Handler handler = f13343fb;
                handler.post(new y(c0208gv, obj2));
                if (fb()) {
                    Method method = f13342a;
                    Boolean bool = Boolean.FALSE;
                    method.invoke(obj, obj2, null, null, 0, bool, null, null, bool, bool);
                } else {
                    activity.recreate();
                }
                handler.post(new n3(application, c0208gv));
                return true;
            } catch (Throwable unused) {
                return false;
            }
        }
    }

    public static boolean fb() {
        int i = Build.VERSION.SDK_INT;
        if (i != 26 && i != 27) {
            return false;
        }
        return true;
    }

    public static Method gv(Class<?> cls) {
        if (cls == null) {
            return null;
        }
        try {
            Method declaredMethod = cls.getDeclaredMethod("performStopActivity", IBinder.class, Boolean.TYPE, String.class);
            declaredMethod.setAccessible(true);
            return declaredMethod;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Field n3() {
        try {
            Field declaredField = Activity.class.getDeclaredField("mMainThread");
            declaredField.setAccessible(true);
            return declaredField;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static boolean s(Object obj, int i, Activity activity) {
        try {
            Object obj2 = f13347zn.get(activity);
            if (obj2 == obj && activity.hashCode() == i) {
                f13343fb.postAtFrontOfQueue(new zn(f13345n3.get(activity), obj2));
                return true;
            }
            return false;
        } catch (Throwable th) {
            Log.e("ActivityRecreator", "Exception while fetching field values", th);
            return false;
        }
    }

    public static Method v(Class<?> cls) {
        if (fb() && cls != null) {
            try {
                Class<?> cls2 = Boolean.TYPE;
                Method declaredMethod = cls.getDeclaredMethod("requestRelaunchActivity", IBinder.class, List.class, List.class, Integer.TYPE, cls2, Configuration.class, Configuration.class, cls2, cls2);
                declaredMethod.setAccessible(true);
                return declaredMethod;
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    public static Class<?> y() {
        try {
            return Class.forName("android.app.ActivityThread");
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Method zn(Class<?> cls) {
        if (cls == null) {
            return null;
        }
        try {
            Method declaredMethod = cls.getDeclaredMethod("performStopActivity", IBinder.class, Boolean.TYPE);
            declaredMethod.setAccessible(true);
            return declaredMethod;
        } catch (Throwable unused) {
            return null;
        }
    }

    /* renamed from: rz.gv$gv  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0208gv implements Application.ActivityLifecycleCallbacks {

        /* renamed from: f  reason: collision with root package name */
        public boolean f13348f;

        /* renamed from: fb  reason: collision with root package name */
        public final int f13349fb;

        /* renamed from: s  reason: collision with root package name */
        public boolean f13350s;

        /* renamed from: t  reason: collision with root package name */
        public boolean f13351t;

        /* renamed from: v  reason: collision with root package name */
        public Activity f13352v;
        public Object y;

        public C0208gv(@NonNull Activity activity) {
            this.f13352v = activity;
            this.f13349fb = activity.hashCode();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            if (this.f13352v == activity) {
                this.f13352v = null;
                this.f13348f = true;
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            if (this.f13348f && !this.f13351t && !this.f13350s && gv.s(this.y, this.f13349fb, activity)) {
                this.f13351t = true;
                this.y = null;
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            if (this.f13352v == activity) {
                this.f13350s = true;
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }
    }
}
