package androidx.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.v;
import y5.co;
import y5.r;
/* loaded from: classes.dex */
public class f extends Fragment {
    public y y;

    /* loaded from: classes.dex */
    public static class n3 implements Application.ActivityLifecycleCallbacks {
        public static void registerIn(Activity activity) {
            activity.registerActivityLifecycleCallbacks(new n3());
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(@NonNull Activity activity, @Nullable Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(@NonNull Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(@NonNull Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPostCreated(@NonNull Activity activity, @Nullable Bundle bundle) {
            f.y(activity, v.n3.ON_CREATE);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPostResumed(@NonNull Activity activity) {
            f.y(activity, v.n3.ON_RESUME);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPostStarted(@NonNull Activity activity) {
            f.y(activity, v.n3.ON_START);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPreDestroyed(@NonNull Activity activity) {
            f.y(activity, v.n3.ON_DESTROY);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPrePaused(@NonNull Activity activity) {
            f.y(activity, v.n3.ON_PAUSE);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPreStopped(@NonNull Activity activity) {
            f.y(activity, v.n3.ON_STOP);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(@NonNull Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(@NonNull Activity activity, @NonNull Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(@NonNull Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(@NonNull Activity activity) {
        }
    }

    /* loaded from: classes.dex */
    public interface y {
        void onCreate();

        void onResume();

        void onStart();
    }

    public static f a(Activity activity) {
        return (f) activity.getFragmentManager().findFragmentByTag("androidx.lifecycle.LifecycleDispatcher.report_fragment_tag");
    }

    public static void fb(Activity activity) {
        if (Build.VERSION.SDK_INT >= 29) {
            n3.registerIn(activity);
        }
        FragmentManager fragmentManager = activity.getFragmentManager();
        if (fragmentManager.findFragmentByTag("androidx.lifecycle.LifecycleDispatcher.report_fragment_tag") == null) {
            fragmentManager.beginTransaction().add(new f(), "androidx.lifecycle.LifecycleDispatcher.report_fragment_tag").commit();
            fragmentManager.executePendingTransactions();
        }
    }

    public static void y(@NonNull Activity activity, @NonNull v.n3 n3Var) {
        if (activity instanceof r) {
            ((r) activity).getLifecycle().s(n3Var);
        } else if (activity instanceof co) {
            v lifecycle = ((co) activity).getLifecycle();
            if (lifecycle instanceof fb) {
                ((fb) lifecycle).s(n3Var);
            }
        }
    }

    public final void gv(y yVar) {
        if (yVar != null) {
            yVar.onResume();
        }
    }

    public final void n3(@NonNull v.n3 n3Var) {
        if (Build.VERSION.SDK_INT < 29) {
            y(getActivity(), n3Var);
        }
    }

    @Override // android.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        zn(this.y);
        n3(v.n3.ON_CREATE);
    }

    @Override // android.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        n3(v.n3.ON_DESTROY);
        this.y = null;
    }

    @Override // android.app.Fragment
    public void onPause() {
        super.onPause();
        n3(v.n3.ON_PAUSE);
    }

    @Override // android.app.Fragment
    public void onResume() {
        super.onResume();
        gv(this.y);
        n3(v.n3.ON_RESUME);
    }

    @Override // android.app.Fragment
    public void onStart() {
        super.onStart();
        v(this.y);
        n3(v.n3.ON_START);
    }

    @Override // android.app.Fragment
    public void onStop() {
        super.onStop();
        n3(v.n3.ON_STOP);
    }

    public void s(y yVar) {
        this.y = yVar;
    }

    public final void v(y yVar) {
        if (yVar != null) {
            yVar.onStart();
        }
    }

    public final void zn(y yVar) {
        if (yVar != null) {
            yVar.onCreate();
        }
    }
}
