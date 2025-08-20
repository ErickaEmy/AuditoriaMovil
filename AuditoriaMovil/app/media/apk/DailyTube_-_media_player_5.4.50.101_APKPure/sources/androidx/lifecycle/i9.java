package androidx.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.f;
import androidx.lifecycle.v;
import y5.co;
/* loaded from: classes.dex */
public class i9 implements co {

    /* renamed from: co  reason: collision with root package name */
    public static final i9 f2630co = new i9();

    /* renamed from: f  reason: collision with root package name */
    public Handler f2631f;

    /* renamed from: v  reason: collision with root package name */
    public int f2636v;
    public int y;

    /* renamed from: fb  reason: collision with root package name */
    public boolean f2632fb = true;

    /* renamed from: s  reason: collision with root package name */
    public boolean f2634s = true;

    /* renamed from: t  reason: collision with root package name */
    public final fb f2635t = new fb(this);

    /* renamed from: w  reason: collision with root package name */
    public Runnable f2637w = new y();

    /* renamed from: p  reason: collision with root package name */
    public f.y f2633p = new n3();

    /* loaded from: classes.dex */
    public class n3 implements f.y {
        public n3() {
        }

        @Override // androidx.lifecycle.f.y
        public void onCreate() {
        }

        @Override // androidx.lifecycle.f.y
        public void onResume() {
            i9.this.n3();
        }

        @Override // androidx.lifecycle.f.y
        public void onStart() {
            i9.this.zn();
        }
    }

    /* loaded from: classes.dex */
    public class y implements Runnable {
        public y() {
        }

        @Override // java.lang.Runnable
        public void run() {
            i9.this.a();
            i9.this.s();
        }
    }

    /* loaded from: classes.dex */
    public class zn extends y5.i9 {

        /* loaded from: classes.dex */
        public class y extends y5.i9 {
            public y() {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPostResumed(@NonNull Activity activity) {
                i9.this.n3();
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPostStarted(@NonNull Activity activity) {
                i9.this.zn();
            }
        }

        public zn() {
        }

        @Override // y5.i9, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            if (Build.VERSION.SDK_INT < 29) {
                f.a(activity).s(i9.this.f2633p);
            }
        }

        @Override // y5.i9, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            i9.this.y();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPreCreated(@NonNull Activity activity, @Nullable Bundle bundle) {
            activity.registerActivityLifecycleCallbacks(new y());
        }

        @Override // y5.i9, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            i9.this.gv();
        }
    }

    @NonNull
    public static co c5() {
        return f2630co;
    }

    public static void i9(Context context) {
        f2630co.v(context);
    }

    public void a() {
        if (this.f2636v == 0) {
            this.f2632fb = true;
            this.f2635t.s(v.n3.ON_PAUSE);
        }
    }

    @Override // y5.co
    @NonNull
    public v getLifecycle() {
        return this.f2635t;
    }

    public void gv() {
        this.y--;
        s();
    }

    public void n3() {
        int i = this.f2636v + 1;
        this.f2636v = i;
        if (i == 1) {
            if (this.f2632fb) {
                this.f2635t.s(v.n3.ON_RESUME);
                this.f2632fb = false;
                return;
            }
            this.f2631f.removeCallbacks(this.f2637w);
        }
    }

    public void s() {
        if (this.y == 0 && this.f2632fb) {
            this.f2635t.s(v.n3.ON_STOP);
            this.f2634s = true;
        }
    }

    public void v(Context context) {
        this.f2631f = new Handler();
        this.f2635t.s(v.n3.ON_CREATE);
        ((Application) context.getApplicationContext()).registerActivityLifecycleCallbacks(new zn());
    }

    public void y() {
        int i = this.f2636v - 1;
        this.f2636v = i;
        if (i == 0) {
            this.f2631f.postDelayed(this.f2637w, 700L);
        }
    }

    public void zn() {
        int i = this.y + 1;
        this.y = i;
        if (i == 1 && this.f2634s) {
            this.f2635t.s(v.n3.ON_START);
            this.f2634s = false;
        }
    }
}
