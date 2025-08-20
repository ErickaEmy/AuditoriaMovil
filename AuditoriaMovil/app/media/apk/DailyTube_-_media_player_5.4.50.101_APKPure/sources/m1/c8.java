package m1;

import android.os.Looper;
import androidx.annotation.Nullable;
import java.util.concurrent.TimeoutException;
/* loaded from: classes.dex */
public final class c8 {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    public Object f10608a;

    /* renamed from: f  reason: collision with root package name */
    public boolean f10610f;

    /* renamed from: fb  reason: collision with root package name */
    public Looper f10611fb;

    /* renamed from: gv  reason: collision with root package name */
    public final hy f10612gv;

    /* renamed from: n3  reason: collision with root package name */
    public final y f10614n3;

    /* renamed from: s  reason: collision with root package name */
    public int f10615s;

    /* renamed from: t  reason: collision with root package name */
    public boolean f10616t;

    /* renamed from: tl  reason: collision with root package name */
    public boolean f10617tl;

    /* renamed from: v  reason: collision with root package name */
    public int f10618v;

    /* renamed from: wz  reason: collision with root package name */
    public boolean f10619wz;
    public final n3 y;

    /* renamed from: zn  reason: collision with root package name */
    public final v5.v f10620zn;

    /* renamed from: c5  reason: collision with root package name */
    public long f10609c5 = -9223372036854775807L;

    /* renamed from: i9  reason: collision with root package name */
    public boolean f10613i9 = true;

    /* loaded from: classes.dex */
    public interface n3 {
        void tl(int i, @Nullable Object obj) throws p;
    }

    /* loaded from: classes.dex */
    public interface y {
        void gv(c8 c8Var);
    }

    public c8(y yVar, n3 n3Var, hy hyVar, int i, v5.v vVar, Looper looper) {
        this.f10614n3 = yVar;
        this.y = n3Var;
        this.f10612gv = hyVar;
        this.f10611fb = looper;
        this.f10620zn = vVar;
        this.f10615s = i;
    }

    public long a() {
        return this.f10609c5;
    }

    public int c5() {
        return this.f10618v;
    }

    public synchronized void f(boolean z2) {
        this.f10616t = z2 | this.f10616t;
        this.f10617tl = true;
        notifyAll();
    }

    public n3 fb() {
        return this.y;
    }

    public int gv() {
        return this.f10615s;
    }

    public synchronized boolean i9() {
        return this.f10619wz;
    }

    public boolean n3() {
        return this.f10613i9;
    }

    public hy s() {
        return this.f10612gv;
    }

    public c8 t() {
        v5.y.fb(!this.f10610f);
        if (this.f10609c5 == -9223372036854775807L) {
            v5.y.y(this.f10613i9);
        }
        this.f10610f = true;
        this.f10614n3.gv(this);
        return this;
    }

    public c8 tl(@Nullable Object obj) {
        v5.y.fb(!this.f10610f);
        this.f10608a = obj;
        return this;
    }

    @Nullable
    public Object v() {
        return this.f10608a;
    }

    public c8 wz(int i) {
        v5.y.fb(!this.f10610f);
        this.f10618v = i;
        return this;
    }

    public synchronized boolean y(long j2) throws InterruptedException, TimeoutException {
        boolean z2;
        boolean z3;
        try {
            v5.y.fb(this.f10610f);
            if (this.f10611fb.getThread() != Thread.currentThread()) {
                z2 = true;
            } else {
                z2 = false;
            }
            v5.y.fb(z2);
            long elapsedRealtime = this.f10620zn.elapsedRealtime() + j2;
            while (true) {
                z3 = this.f10617tl;
                if (z3 || j2 <= 0) {
                    break;
                }
                this.f10620zn.zn();
                wait(j2);
                j2 = elapsedRealtime - this.f10620zn.elapsedRealtime();
            }
            if (z3) {
            } else {
                throw new TimeoutException("Message delivery timed out.");
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.f10616t;
    }

    public Looper zn() {
        return this.f10611fb;
    }
}
