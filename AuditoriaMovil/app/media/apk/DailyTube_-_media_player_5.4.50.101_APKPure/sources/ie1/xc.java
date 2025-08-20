package ie1;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import ie1.a;
import ie1.zn;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;
/* loaded from: classes.dex */
public class xc {
    public static final xc y = v();

    @IgnoreJRERequirement
    /* loaded from: classes.dex */
    public static class n3 extends xc {
        @Override // ie1.xc
        public Object fb(Method method, Class<?> cls, Object obj, Object... objArr) throws Throwable {
            Constructor declaredConstructor = MethodHandles.Lookup.class.getDeclaredConstructor(Class.class, Integer.TYPE);
            declaredConstructor.setAccessible(true);
            return ((MethodHandles.Lookup) declaredConstructor.newInstance(cls, -1)).unreflectSpecial(method, cls).bindTo(obj).invokeWithArguments(objArr);
        }

        @Override // ie1.xc
        public int gv() {
            return 1;
        }

        @Override // ie1.xc
        public boolean s(Method method) {
            return method.isDefault();
        }

        @Override // ie1.xc
        public List<? extends zn.y> y(Executor executor) {
            ArrayList arrayList = new ArrayList(2);
            arrayList.add(v.y);
            arrayList.add(new fb(executor));
            return Collections.unmodifiableList(arrayList);
        }

        @Override // ie1.xc
        public List<? extends a.y> zn() {
            return Collections.singletonList(tl.y);
        }
    }

    /* loaded from: classes.dex */
    public static class y extends xc {

        /* renamed from: ie1.xc$y$y  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static class ExecutorC0121y implements Executor {
            public final Handler y = new Handler(Looper.getMainLooper());

            @Override // java.util.concurrent.Executor
            public void execute(Runnable runnable) {
                this.y.post(runnable);
            }
        }

        @Override // ie1.xc
        public int gv() {
            if (Build.VERSION.SDK_INT >= 24) {
                return 1;
            }
            return 0;
        }

        @Override // ie1.xc
        public Executor n3() {
            return new ExecutorC0121y();
        }

        @Override // ie1.xc
        @IgnoreJRERequirement
        public boolean s(Method method) {
            if (Build.VERSION.SDK_INT < 24) {
                return false;
            }
            return method.isDefault();
        }

        @Override // ie1.xc
        public List<? extends zn.y> y(Executor executor) {
            if (executor != null) {
                fb fbVar = new fb(executor);
                if (Build.VERSION.SDK_INT >= 24) {
                    return Arrays.asList(v.y, fbVar);
                }
                return Collections.singletonList(fbVar);
            }
            throw new AssertionError();
        }

        @Override // ie1.xc
        public List<? extends a.y> zn() {
            if (Build.VERSION.SDK_INT >= 24) {
                return Collections.singletonList(tl.y);
            }
            return Collections.emptyList();
        }
    }

    public static xc a() {
        return y;
    }

    public static xc v() {
        try {
            try {
                Class.forName("android.os.Build");
                return new y();
            } catch (ClassNotFoundException unused) {
                return new xc();
            }
        } catch (ClassNotFoundException unused2) {
            Class.forName("java.util.Optional");
            return new n3();
        }
    }

    public Object fb(Method method, Class<?> cls, Object obj, Object... objArr) throws Throwable {
        throw new UnsupportedOperationException();
    }

    public int gv() {
        return 0;
    }

    public Executor n3() {
        return null;
    }

    public boolean s(Method method) {
        return false;
    }

    public List<? extends zn.y> y(Executor executor) {
        return Collections.singletonList(new fb(executor));
    }

    public List<? extends a.y> zn() {
        return Collections.emptyList();
    }
}
