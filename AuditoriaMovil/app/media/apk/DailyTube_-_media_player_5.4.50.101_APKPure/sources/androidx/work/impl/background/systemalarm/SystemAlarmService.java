package androidx.work.impl.background.systemalarm;

import android.content.Intent;
import androidx.work.impl.background.systemalarm.gv;
import cs.i9;
import l.f;
import y5.x4;
/* loaded from: classes.dex */
public class SystemAlarmService extends x4 implements gv.zn {

    /* renamed from: s  reason: collision with root package name */
    public static final String f3699s = f.a("SystemAlarmService");

    /* renamed from: fb  reason: collision with root package name */
    public boolean f3700fb;

    /* renamed from: v  reason: collision with root package name */
    public gv f3701v;

    @Override // androidx.work.impl.background.systemalarm.gv.zn
    public void n3() {
        this.f3700fb = true;
        f.zn().y(f3699s, "All commands completed in dispatcher", new Throwable[0]);
        i9.y();
        stopSelf();
    }

    @Override // y5.x4, android.app.Service
    public void onCreate() {
        super.onCreate();
        v();
        this.f3700fb = false;
    }

    @Override // y5.x4, android.app.Service
    public void onDestroy() {
        super.onDestroy();
        this.f3700fb = true;
        this.f3701v.i9();
    }

    @Override // y5.x4, android.app.Service
    public int onStartCommand(Intent intent, int i, int i5) {
        super.onStartCommand(intent, i, i5);
        if (this.f3700fb) {
            f.zn().gv(f3699s, "Re-initializing SystemAlarmDispatcher after a request to shut-down.", new Throwable[0]);
            this.f3701v.i9();
            v();
            this.f3700fb = false;
        }
        if (intent != null) {
            this.f3701v.y(intent, i5);
            return 3;
        }
        return 3;
    }

    public final void v() {
        gv gvVar = new gv(this);
        this.f3701v = gvVar;
        gvVar.tl(this);
    }
}
