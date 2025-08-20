package androidx.work.impl.foreground;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.work.impl.foreground.y;
import l.f;
import y5.x4;
/* loaded from: classes.dex */
public class SystemForegroundService extends x4 implements y.n3 {

    /* renamed from: t  reason: collision with root package name */
    public static final String f3732t = f.a("SystemFgService");
    @Nullable

    /* renamed from: w  reason: collision with root package name */
    public static SystemForegroundService f3733w = null;

    /* renamed from: f  reason: collision with root package name */
    public NotificationManager f3734f;

    /* renamed from: fb  reason: collision with root package name */
    public boolean f3735fb;

    /* renamed from: s  reason: collision with root package name */
    public androidx.work.impl.foreground.y f3736s;

    /* renamed from: v  reason: collision with root package name */
    public Handler f3737v;

    /* loaded from: classes.dex */
    public class n3 implements Runnable {

        /* renamed from: v  reason: collision with root package name */
        public final /* synthetic */ Notification f3739v;
        public final /* synthetic */ int y;

        public n3(int i, Notification notification) {
            this.y = i;
            this.f3739v = notification;
        }

        @Override // java.lang.Runnable
        public void run() {
            SystemForegroundService.this.f3734f.notify(this.y, this.f3739v);
        }
    }

    /* loaded from: classes.dex */
    public class y implements Runnable {

        /* renamed from: fb  reason: collision with root package name */
        public final /* synthetic */ int f3740fb;

        /* renamed from: v  reason: collision with root package name */
        public final /* synthetic */ Notification f3742v;
        public final /* synthetic */ int y;

        public y(int i, Notification notification, int i5) {
            this.y = i;
            this.f3742v = notification;
            this.f3740fb = i5;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (Build.VERSION.SDK_INT >= 29) {
                SystemForegroundService.this.startForeground(this.y, this.f3742v, this.f3740fb);
            } else {
                SystemForegroundService.this.startForeground(this.y, this.f3742v);
            }
        }
    }

    /* loaded from: classes.dex */
    public class zn implements Runnable {
        public final /* synthetic */ int y;

        public zn(int i) {
            this.y = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            SystemForegroundService.this.f3734f.cancel(this.y);
        }
    }

    private void v() {
        this.f3737v = new Handler(Looper.getMainLooper());
        this.f3734f = (NotificationManager) getApplicationContext().getSystemService("notification");
        androidx.work.impl.foreground.y yVar = new androidx.work.impl.foreground.y(getApplicationContext());
        this.f3736s = yVar;
        yVar.tl(this);
    }

    @Override // androidx.work.impl.foreground.y.n3
    public void gv(int i) {
        this.f3737v.post(new zn(i));
    }

    @Override // y5.x4, android.app.Service
    public void onCreate() {
        super.onCreate();
        f3733w = this;
        v();
    }

    @Override // y5.x4, android.app.Service
    public void onDestroy() {
        super.onDestroy();
        this.f3736s.f();
    }

    @Override // y5.x4, android.app.Service
    public int onStartCommand(@Nullable Intent intent, int i, int i5) {
        super.onStartCommand(intent, i, i5);
        if (this.f3735fb) {
            f.zn().gv(f3732t, "Re-initializing SystemForegroundService after a request to shut-down.", new Throwable[0]);
            this.f3736s.f();
            v();
            this.f3735fb = false;
        }
        if (intent != null) {
            this.f3736s.t(intent);
            return 3;
        }
        return 3;
    }

    @Override // androidx.work.impl.foreground.y.n3
    public void stop() {
        this.f3735fb = true;
        f.zn().y(f3732t, "All commands completed.", new Throwable[0]);
        if (Build.VERSION.SDK_INT >= 26) {
            stopForeground(true);
        }
        f3733w = null;
        stopSelf();
    }

    @Override // androidx.work.impl.foreground.y.n3
    public void y(int i, @NonNull Notification notification) {
        this.f3737v.post(new n3(i, notification));
    }

    @Override // androidx.work.impl.foreground.y.n3
    public void zn(int i, int i5, @NonNull Notification notification) {
        this.f3737v.post(new y(i, notification, i5));
    }
}
