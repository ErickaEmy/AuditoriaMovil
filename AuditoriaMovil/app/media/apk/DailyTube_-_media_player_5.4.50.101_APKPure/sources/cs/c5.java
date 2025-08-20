package cs;

import androidx.annotation.NonNull;
import androidx.work.impl.WorkDatabase;
import l.z;
import le.p;
/* loaded from: classes.dex */
public class c5 implements Runnable {

    /* renamed from: s  reason: collision with root package name */
    public static final String f6850s = l.f.a("StopWorkRunnable");

    /* renamed from: fb  reason: collision with root package name */
    public final boolean f6851fb;

    /* renamed from: v  reason: collision with root package name */
    public final String f6852v;
    public final gq.c5 y;

    public c5(@NonNull gq.c5 c5Var, @NonNull String str, boolean z2) {
        this.y = c5Var;
        this.f6852v = str;
        this.f6851fb = z2;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean xc2;
        WorkDatabase co2 = this.y.co();
        gq.gv p2 = this.y.p();
        p f4 = co2.f();
        co2.beginTransaction();
        try {
            boolean s2 = p2.s(this.f6852v);
            if (this.f6851fb) {
                xc2 = this.y.p().wz(this.f6852v);
            } else {
                if (!s2 && f4.v(this.f6852v) == z.y.RUNNING) {
                    f4.fb(z.y.ENQUEUED, this.f6852v);
                }
                xc2 = this.y.p().xc(this.f6852v);
            }
            l.f.zn().y(f6850s, String.format("StopWorkRunnable for %s; Processor.stopWork = %s", this.f6852v, Boolean.valueOf(xc2)), new Throwable[0]);
            co2.setTransactionSuccessful();
            co2.endTransaction();
        } catch (Throwable th) {
            co2.endTransaction();
            throw th;
        }
    }
}
