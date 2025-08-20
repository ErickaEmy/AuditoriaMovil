package androidx.work.impl.background.systemalarm;

import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.work.impl.background.systemalarm.gv;
import cs.i9;
import cs.wz;
import java.util.Collections;
import java.util.List;
import l.f;
import le.w;
/* loaded from: classes.dex */
public class zn implements w2.zn, gq.n3, wz.n3 {

    /* renamed from: z  reason: collision with root package name */
    public static final String f3721z = f.a("DelayMetCommandHandler");

    /* renamed from: f  reason: collision with root package name */
    public final w2.gv f3723f;

    /* renamed from: fb  reason: collision with root package name */
    public final String f3724fb;
    @Nullable

    /* renamed from: p  reason: collision with root package name */
    public PowerManager.WakeLock f3725p;

    /* renamed from: s  reason: collision with root package name */
    public final gv f3726s;

    /* renamed from: v  reason: collision with root package name */
    public final int f3728v;
    public final Context y;

    /* renamed from: co  reason: collision with root package name */
    public boolean f3722co = false;

    /* renamed from: w  reason: collision with root package name */
    public int f3729w = 0;

    /* renamed from: t  reason: collision with root package name */
    public final Object f3727t = new Object();

    public zn(@NonNull Context context, int i, @NonNull String str, @NonNull gv gvVar) {
        this.y = context;
        this.f3728v = i;
        this.f3726s = gvVar;
        this.f3724fb = str;
        this.f3723f = new w2.gv(context, gvVar.a(), this);
    }

    public void a() {
        this.f3725p = i9.n3(this.y, String.format("%s (%s)", this.f3724fb, Integer.valueOf(this.f3728v)));
        f zn2 = f.zn();
        String str = f3721z;
        zn2.y(str, String.format("Acquiring wakelock %s for WorkSpec %s", this.f3725p, this.f3724fb), new Throwable[0]);
        this.f3725p.acquire();
        w a2 = this.f3726s.fb().co().f().a(this.f3724fb);
        if (a2 == null) {
            fb();
            return;
        }
        boolean n32 = a2.n3();
        this.f3722co = n32;
        if (!n32) {
            f.zn().y(str, String.format("No constraints for %s", this.f3724fb), new Throwable[0]);
            v(Collections.singletonList(this.f3724fb));
            return;
        }
        this.f3723f.gv(Collections.singletonList(a2));
    }

    public final void fb() {
        synchronized (this.f3727t) {
            try {
                if (this.f3729w < 2) {
                    this.f3729w = 2;
                    f zn2 = f.zn();
                    String str = f3721z;
                    zn2.y(str, String.format("Stopping work for WorkSpec %s", this.f3724fb), new Throwable[0]);
                    Intent fb2 = y.fb(this.y, this.f3724fb);
                    gv gvVar = this.f3726s;
                    gvVar.f(new gv.n3(gvVar, fb2, this.f3728v));
                    if (this.f3726s.v().fb(this.f3724fb)) {
                        f.zn().y(str, String.format("WorkSpec %s needs to be rescheduled", this.f3724fb), new Throwable[0]);
                        Intent a2 = y.a(this.y, this.f3724fb);
                        gv gvVar2 = this.f3726s;
                        gvVar2.f(new gv.n3(gvVar2, a2, this.f3728v));
                    } else {
                        f.zn().y(str, String.format("Processor does not have WorkSpec %s. No need to reschedule ", this.f3724fb), new Throwable[0]);
                    }
                } else {
                    f.zn().y(f3721z, String.format("Already stopped work for %s", this.f3724fb), new Throwable[0]);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // gq.n3
    public void gv(@NonNull String str, boolean z2) {
        f.zn().y(f3721z, String.format("onExecuted %s, %s", str, Boolean.valueOf(z2)), new Throwable[0]);
        zn();
        if (z2) {
            Intent a2 = y.a(this.y, this.f3724fb);
            gv gvVar = this.f3726s;
            gvVar.f(new gv.n3(gvVar, a2, this.f3728v));
        }
        if (this.f3722co) {
            Intent y = y.y(this.y);
            gv gvVar2 = this.f3726s;
            gvVar2.f(new gv.n3(gvVar2, y, this.f3728v));
        }
    }

    @Override // w2.zn
    public void n3(@NonNull List<String> list) {
        fb();
    }

    @Override // w2.zn
    public void v(@NonNull List<String> list) {
        if (!list.contains(this.f3724fb)) {
            return;
        }
        synchronized (this.f3727t) {
            try {
                if (this.f3729w == 0) {
                    this.f3729w = 1;
                    f.zn().y(f3721z, String.format("onAllConstraintsMet for %s", this.f3724fb), new Throwable[0]);
                    if (this.f3726s.v().i9(this.f3724fb)) {
                        this.f3726s.s().n3(this.f3724fb, 600000L, this);
                    } else {
                        zn();
                    }
                } else {
                    f.zn().y(f3721z, String.format("Already started work for %s", this.f3724fb), new Throwable[0]);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // cs.wz.n3
    public void y(@NonNull String str) {
        f.zn().y(f3721z, String.format("Exceeded time limits on execution for %s", str), new Throwable[0]);
        fb();
    }

    public final void zn() {
        synchronized (this.f3727t) {
            try {
                this.f3723f.v();
                this.f3726s.s().zn(this.f3724fb);
                PowerManager.WakeLock wakeLock = this.f3725p;
                if (wakeLock != null && wakeLock.isHeld()) {
                    f.zn().y(f3721z, String.format("Releasing wakelock %s for WorkSpec %s", this.f3725p, this.f3724fb), new Throwable[0]);
                    this.f3725p.release();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
