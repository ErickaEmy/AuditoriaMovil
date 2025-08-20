package free.daily.tube.background.dtoapp;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
/* loaded from: classes.dex */
public class MxApp extends Application {

    /* renamed from: v  reason: collision with root package name */
    public static boolean f8175v;
    public final free.daily.tube.background.dtoapp.y y = new free.daily.tube.background.dtoapp.y(this);

    /* loaded from: classes.dex */
    public class n3 {
        public n3() {
        }

        public SharedPreferences y(String str, Integer num) {
            return MxApp.super.getSharedPreferences(str, num.intValue());
        }
    }

    /* loaded from: classes.dex */
    public class y {
        public y() {
        }

        public String y() {
            return MxApp.super.getPackageName();
        }
    }

    public static long a() {
        return free.daily.tube.background.dtoapp.y.f8178zn.n3();
    }

    public static MxApp gv() {
        return free.daily.tube.background.dtoapp.y.f8178zn.y();
    }

    @Override // android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        this.y.zn(context);
    }

    public boolean fb() {
        return this.y.fb();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public String getPackageName() {
        return this.y.v(new y());
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public SharedPreferences getSharedPreferences(String str, int i) {
        return this.y.a(str, i, new n3());
    }

    @Override // android.app.Application, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NonNull Configuration configuration) {
        this.y.s(configuration);
        super.onConfigurationChanged(configuration);
    }

    @Override // android.app.Application
    @SuppressLint({"MissingSuperCall"})
    public void onCreate() {
        this.y.c5();
        super.onCreate();
        this.y.i9();
    }

    @Override // android.app.Application, android.content.ComponentCallbacks
    public void onLowMemory() {
        super.onLowMemory();
        this.y.f();
    }

    @Override // android.app.Application, android.content.ComponentCallbacks2
    public void onTrimMemory(int i) {
        super.onTrimMemory(i);
        this.y.t(i);
    }

    @Nullable
    public String v() {
        return this.y.gv();
    }
}
