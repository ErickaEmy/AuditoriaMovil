package com.google.android.exoplayer2.source.dash;

import af.f7;
import android.os.Handler;
import android.os.Message;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.emsg.EventMessage;
import e4.mg;
import e4.ta;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import kx.c5;
import m1.g;
import m1.m;
import m1.ne;
import p7.a;
import v5.j5;
import v5.rz;
/* loaded from: classes.dex */
public final class v implements Handler.Callback {

    /* renamed from: co  reason: collision with root package name */
    public boolean f4441co;

    /* renamed from: p  reason: collision with root package name */
    public boolean f4444p;

    /* renamed from: t  reason: collision with root package name */
    public dq.zn f4446t;

    /* renamed from: v  reason: collision with root package name */
    public final n3 f4447v;

    /* renamed from: w  reason: collision with root package name */
    public long f4448w;
    public final kx.n3 y;

    /* renamed from: z  reason: collision with root package name */
    public boolean f4449z;

    /* renamed from: f  reason: collision with root package name */
    public final TreeMap<Long, Long> f4442f = new TreeMap<>();

    /* renamed from: s  reason: collision with root package name */
    public final Handler f4445s = j5.f3(this);

    /* renamed from: fb  reason: collision with root package name */
    public final f5.y f4443fb = new f5.y();

    /* loaded from: classes.dex */
    public interface n3 {
        void n3();

        void y(long j2);
    }

    /* loaded from: classes.dex */
    public static final class y {

        /* renamed from: n3  reason: collision with root package name */
        public final long f4450n3;
        public final long y;

        public y(long j2, long j4) {
            this.y = j2;
            this.f4450n3 = j4;
        }
    }

    /* loaded from: classes.dex */
    public final class zn implements ta {
        public final f7 y;

        /* renamed from: n3  reason: collision with root package name */
        public final g f4452n3 = new g();

        /* renamed from: zn  reason: collision with root package name */
        public final hd.gv f4454zn = new hd.gv();

        /* renamed from: gv  reason: collision with root package name */
        public long f4451gv = -9223372036854775807L;

        public zn(kx.n3 n3Var) {
            this.y = f7.t(n3Var);
        }

        @Override // e4.ta
        public void a(rz rzVar, int i, int i5) {
            this.y.zn(rzVar, i);
        }

        public void c5(a aVar) {
            long j2 = this.f4451gv;
            if (j2 == -9223372036854775807L || aVar.f12446s > j2) {
                this.f4451gv = aVar.f12446s;
            }
            v.this.tl(aVar);
        }

        public final void f(long j2, long j4) {
            v.this.f4445s.sendMessage(v.this.f4445s.obtainMessage(1, new y(j2, j4)));
        }

        @Nullable
        public final hd.gv fb() {
            this.f4454zn.a();
            if (this.y.o(this.f4452n3, this.f4454zn, 0, false) == -4) {
                this.f4454zn.co();
                return this.f4454zn;
            }
            return null;
        }

        @Override // e4.ta
        public void gv(long j2, int i, int i5, int i6, @Nullable ta.y yVar) {
            this.y.gv(j2, i, i5, i6, yVar);
            t();
        }

        public boolean i9(a aVar) {
            boolean z2;
            long j2 = this.f4451gv;
            if (j2 != -9223372036854775807L && j2 < aVar.f12443fb) {
                z2 = true;
            } else {
                z2 = false;
            }
            return v.this.wz(z2);
        }

        @Override // e4.ta
        public /* synthetic */ int n3(c5 c5Var, int i, boolean z2) {
            return mg.y(this, c5Var, i, z2);
        }

        public boolean s(long j2) {
            return v.this.i9(j2);
        }

        public final void t() {
            while (this.y.x(false)) {
                hd.gv fb2 = fb();
                if (fb2 != null) {
                    long j2 = fb2.f55f;
                    Metadata y = v.this.f4443fb.y(fb2);
                    if (y != null) {
                        EventMessage eventMessage = (EventMessage) y.gv(0);
                        if (v.s(eventMessage.y, eventMessage.f4226v)) {
                            tl(j2, eventMessage);
                        }
                    }
                }
            }
            this.y.co();
        }

        public final void tl(long j2, EventMessage eventMessage) {
            long a2 = v.a(eventMessage);
            if (a2 == -9223372036854775807L) {
                return;
            }
            f(j2, a2);
        }

        @Override // e4.ta
        public void v(m mVar) {
            this.y.v(mVar);
        }

        public void wz() {
            this.y.j();
        }

        @Override // e4.ta
        public int y(c5 c5Var, int i, boolean z2, int i5) throws IOException {
            return this.y.n3(c5Var, i, z2);
        }

        @Override // e4.ta
        public /* synthetic */ void zn(rz rzVar, int i) {
            mg.n3(this, rzVar, i);
        }
    }

    public v(dq.zn znVar, n3 n3Var, kx.n3 n3Var2) {
        this.f4446t = znVar;
        this.f4447v = n3Var;
        this.y = n3Var2;
    }

    public static long a(EventMessage eventMessage) {
        try {
            return j5.gq(j5.mg(eventMessage.f4222f));
        } catch (ne unused) {
            return -9223372036854775807L;
        }
    }

    public static boolean s(String str, String str2) {
        if ("urn:mpeg:dash:event:2012".equals(str) && ("1".equals(str2) || "2".equals(str2) || "3".equals(str2))) {
            return true;
        }
        return false;
    }

    public final void c5() {
        if (!this.f4444p) {
            return;
        }
        this.f4441co = true;
        this.f4444p = false;
        this.f4447v.n3();
    }

    public zn f() {
        return new zn(this.y);
    }

    public final void fb(long j2, long j4) {
        Long l2 = this.f4442f.get(Long.valueOf(j4));
        if (l2 == null) {
            this.f4442f.put(Long.valueOf(j4), Long.valueOf(j2));
        } else if (l2.longValue() > j2) {
            this.f4442f.put(Long.valueOf(j4), Long.valueOf(j2));
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (this.f4449z) {
            return true;
        }
        if (message.what != 1) {
            return false;
        }
        y yVar = (y) message.obj;
        fb(yVar.y, yVar.f4450n3);
        return true;
    }

    public boolean i9(long j2) {
        dq.zn znVar = this.f4446t;
        boolean z2 = false;
        if (!znVar.f7423gv) {
            return false;
        }
        if (this.f4441co) {
            return true;
        }
        Map.Entry<Long, Long> v2 = v(znVar.f7426s);
        if (v2 != null && v2.getValue().longValue() < j2) {
            this.f4448w = v2.getKey().longValue();
            t();
            z2 = true;
        }
        if (z2) {
            c5();
        }
        return z2;
    }

    public void p(dq.zn znVar) {
        this.f4441co = false;
        this.f4448w = -9223372036854775807L;
        this.f4446t = znVar;
        w();
    }

    public final void t() {
        this.f4447v.y(this.f4448w);
    }

    public void tl(a aVar) {
        this.f4444p = true;
    }

    @Nullable
    public final Map.Entry<Long, Long> v(long j2) {
        return this.f4442f.ceilingEntry(Long.valueOf(j2));
    }

    public final void w() {
        Iterator<Map.Entry<Long, Long>> it = this.f4442f.entrySet().iterator();
        while (it.hasNext()) {
            if (it.next().getKey().longValue() < this.f4446t.f7426s) {
                it.remove();
            }
        }
    }

    public boolean wz(boolean z2) {
        if (!this.f4446t.f7423gv) {
            return false;
        }
        if (this.f4441co) {
            return true;
        }
        if (!z2) {
            return false;
        }
        c5();
        return true;
    }

    public void xc() {
        this.f4449z = true;
        this.f4445s.removeCallbacksAndMessages(null);
    }
}
