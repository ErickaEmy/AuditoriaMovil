package qh;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.Nullable;
import m1.g;
import m1.hk;
import m1.m;
import v5.j5;
import v5.n;
import v5.r;
import z0.x4;
/* loaded from: classes.dex */
public final class p extends m1.a implements Handler.Callback {

    /* renamed from: b  reason: collision with root package name */
    public boolean f12895b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public final Handler f12896c;

    /* renamed from: d  reason: collision with root package name */
    public final g f12897d;

    /* renamed from: d0  reason: collision with root package name */
    public final w f12898d0;

    /* renamed from: ej  reason: collision with root package name */
    public boolean f12899ej;

    /* renamed from: en  reason: collision with root package name */
    public long f12900en;

    /* renamed from: f7  reason: collision with root package name */
    public long f12901f7;

    /* renamed from: fh  reason: collision with root package name */
    public final t f12902fh;
    @Nullable

    /* renamed from: j  reason: collision with root package name */
    public wz f12903j;

    /* renamed from: j5  reason: collision with root package name */
    public int f12904j5;

    /* renamed from: k  reason: collision with root package name */
    public long f12905k;
    @Nullable

    /* renamed from: o  reason: collision with root package name */
    public i9 f12906o;
    @Nullable

    /* renamed from: oz  reason: collision with root package name */
    public xc f12907oz;

    /* renamed from: q9  reason: collision with root package name */
    public int f12908q9;
    @Nullable

    /* renamed from: qn  reason: collision with root package name */
    public m f12909qn;
    @Nullable

    /* renamed from: ut  reason: collision with root package name */
    public xc f12910ut;

    /* renamed from: x  reason: collision with root package name */
    public boolean f12911x;

    public p(w wVar, @Nullable Looper looper) {
        this(wVar, looper, t.y);
    }

    private long o(long j2) {
        boolean z2;
        boolean z3 = false;
        if (j2 != -9223372036854775807L) {
            z2 = true;
        } else {
            z2 = false;
        }
        v5.y.fb(z2);
        if (this.f12901f7 != -9223372036854775807L) {
            z3 = true;
        }
        v5.y.fb(z3);
        return j2 - this.f12901f7;
    }

    @Override // m1.zq
    public boolean a() {
        return this.f12911x;
    }

    @Override // m1.a
    public void b(m[] mVarArr, long j2, long j4) {
        this.f12901f7 = j4;
        this.f12909qn = mVarArr[0];
        if (this.f12906o != null) {
            this.f12904j5 = 1;
        } else {
            oz();
        }
    }

    @Override // m1.a
    public void d() {
        this.f12909qn = null;
        this.f12905k = -9223372036854775807L;
        hw();
        this.f12901f7 = -9223372036854775807L;
        this.f12900en = -9223372036854775807L;
        k();
    }

    @Override // m1.a
    public void ej(long j2, boolean z2) {
        this.f12900en = j2;
        hw();
        this.f12899ej = false;
        this.f12911x = false;
        this.f12905k = -9223372036854775807L;
        if (this.f12904j5 != 0) {
            f7();
            return;
        }
        q9();
        ((i9) v5.y.v(this.f12906o)).flush();
    }

    public void en(long j2) {
        v5.y.fb(xc());
        this.f12905k = j2;
    }

    public final void f7() {
        k();
        oz();
    }

    @Override // m1.zq, m1.k3
    public String getName() {
        return "TextRenderer";
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what == 0) {
            ut((a) message.obj);
            return true;
        }
        throw new IllegalStateException();
    }

    public final void hw() {
        jz(new a(x4.j5(), o(this.f12900en)));
    }

    @Override // m1.zq
    public boolean isReady() {
        return true;
    }

    public final void j(f fVar) {
        r.gv("TextRenderer", "Subtitle decoding failed. streamFormat=" + this.f12909qn, fVar);
        hw();
        f7();
    }

    public final long j5(long j2) {
        int y = this.f12907oz.y(j2);
        if (y != 0 && this.f12907oz.gv() != 0) {
            if (y == -1) {
                xc xcVar = this.f12907oz;
                return xcVar.zn(xcVar.gv() - 1);
            }
            return this.f12907oz.zn(y - 1);
        }
        return this.f12907oz.f75v;
    }

    public final void jz(a aVar) {
        Handler handler = this.f12896c;
        if (handler != null) {
            handler.obtainMessage(0, aVar).sendToTarget();
        } else {
            ut(aVar);
        }
    }

    public final void k() {
        q9();
        ((i9) v5.y.v(this.f12906o)).release();
        this.f12906o = null;
        this.f12904j5 = 0;
    }

    @Override // m1.k3
    public int n3(m mVar) {
        int i;
        if (this.f12902fh.n3(mVar)) {
            if (mVar.f10971y5 == 0) {
                i = 4;
            } else {
                i = 2;
            }
            return hk.y(i);
        } else if (n.mt(mVar.f10948f3)) {
            return hk.y(1);
        } else {
            return hk.y(0);
        }
    }

    public final void oz() {
        this.f12895b = true;
        this.f12906o = this.f12902fh.y((m) v5.y.v(this.f12909qn));
    }

    public final void q9() {
        this.f12903j = null;
        this.f12908q9 = -1;
        xc xcVar = this.f12907oz;
        if (xcVar != null) {
            xcVar.p();
            this.f12907oz = null;
        }
        xc xcVar2 = this.f12910ut;
        if (xcVar2 != null) {
            xcVar2.p();
            this.f12910ut = null;
        }
    }

    public final long qn() {
        if (this.f12908q9 == -1) {
            return Long.MAX_VALUE;
        }
        v5.y.v(this.f12907oz);
        if (this.f12908q9 >= this.f12907oz.gv()) {
            return Long.MAX_VALUE;
        }
        return this.f12907oz.zn(this.f12908q9);
    }

    public final void ut(a aVar) {
        this.f12898d0.onCues(aVar.y);
        this.f12898d0.onCues(aVar);
    }

    @Override // m1.zq
    public void z(long j2, long j4) {
        boolean z2;
        this.f12900en = j2;
        if (xc()) {
            long j6 = this.f12905k;
            if (j6 != -9223372036854775807L && j2 >= j6) {
                q9();
                this.f12911x = true;
            }
        }
        if (this.f12911x) {
            return;
        }
        if (this.f12910ut == null) {
            ((i9) v5.y.v(this.f12906o)).y(j2);
            try {
                this.f12910ut = ((i9) v5.y.v(this.f12906o)).n3();
            } catch (f e2) {
                j(e2);
                return;
            }
        }
        if (getState() != 2) {
            return;
        }
        if (this.f12907oz != null) {
            long qn2 = qn();
            z2 = false;
            while (qn2 <= j2) {
                this.f12908q9++;
                qn2 = qn();
                z2 = true;
            }
        } else {
            z2 = false;
        }
        xc xcVar = this.f12910ut;
        if (xcVar != null) {
            if (xcVar.t()) {
                if (!z2 && qn() == Long.MAX_VALUE) {
                    if (this.f12904j5 == 2) {
                        f7();
                    } else {
                        q9();
                        this.f12911x = true;
                    }
                }
            } else if (xcVar.f75v <= j2) {
                xc xcVar2 = this.f12907oz;
                if (xcVar2 != null) {
                    xcVar2.p();
                }
                this.f12908q9 = xcVar.y(j2);
                this.f12907oz = xcVar;
                this.f12910ut = null;
                z2 = true;
            }
        }
        if (z2) {
            v5.y.v(this.f12907oz);
            jz(new a(this.f12907oz.n3(j2), o(j5(j2))));
        }
        if (this.f12904j5 == 2) {
            return;
        }
        while (!this.f12899ej) {
            try {
                wz wzVar = this.f12903j;
                if (wzVar == null) {
                    wzVar = ((i9) v5.y.v(this.f12906o)).gv();
                    if (wzVar == null) {
                        return;
                    }
                    this.f12903j = wzVar;
                }
                if (this.f12904j5 == 1) {
                    wzVar.w(4);
                    ((i9) v5.y.v(this.f12906o)).zn(wzVar);
                    this.f12903j = null;
                    this.f12904j5 = 2;
                    return;
                }
                int k52 = k5(this.f12897d, wzVar, 0);
                if (k52 == -4) {
                    if (wzVar.t()) {
                        this.f12899ej = true;
                        this.f12895b = false;
                    } else {
                        m mVar = this.f12897d.f10757n3;
                        if (mVar == null) {
                            return;
                        }
                        wzVar.f12924co = mVar.f10951fh;
                        wzVar.co();
                        this.f12895b &= !wzVar.wz();
                    }
                    if (!this.f12895b) {
                        ((i9) v5.y.v(this.f12906o)).zn(wzVar);
                        this.f12903j = null;
                    }
                } else if (k52 == -3) {
                    return;
                }
            } catch (f e3) {
                j(e3);
                return;
            }
        }
    }

    public p(w wVar, @Nullable Looper looper, t tVar) {
        super(3);
        this.f12898d0 = (w) v5.y.v(wVar);
        this.f12896c = looper == null ? null : j5.x4(looper, this);
        this.f12902fh = tVar;
        this.f12897d = new g();
        this.f12905k = -9223372036854775807L;
        this.f12901f7 = -9223372036854775807L;
        this.f12900en = -9223372036854775807L;
    }
}
