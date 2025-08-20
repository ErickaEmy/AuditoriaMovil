package com.google.android.exoplayer2.drm;

import af.c;
import af.i4;
import android.annotation.SuppressLint;
import android.media.NotProvisionedException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Pair;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.gv;
import com.google.android.exoplayer2.drm.i9;
import com.google.android.exoplayer2.drm.v;
import f8.d0;
import f8.rz;
import fj.u0;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kx.mg;
import v5.j5;
import v5.r;
/* loaded from: classes.dex */
public class y implements com.google.android.exoplayer2.drm.gv {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f4170a;

    /* renamed from: c5  reason: collision with root package name */
    public final v5.i9<v.y> f4171c5;
    @Nullable

    /* renamed from: co  reason: collision with root package name */
    public zn f4172co;

    /* renamed from: f  reason: collision with root package name */
    public final u0 f4173f;
    @Nullable

    /* renamed from: f3  reason: collision with root package name */
    public i9.y f4174f3;

    /* renamed from: fb  reason: collision with root package name */
    public final boolean f4175fb;

    /* renamed from: gv  reason: collision with root package name */
    public final n3 f4176gv;

    /* renamed from: i4  reason: collision with root package name */
    public byte[] f4177i4;

    /* renamed from: i9  reason: collision with root package name */
    public final mg f4178i9;
    @Nullable

    /* renamed from: mt  reason: collision with root package name */
    public HandlerThread f4179mt;
    @Nullable

    /* renamed from: n  reason: collision with root package name */
    public i9.gv f4180n;

    /* renamed from: n3  reason: collision with root package name */
    public final i9 f4181n3;

    /* renamed from: p  reason: collision with root package name */
    public int f4182p;
    @Nullable

    /* renamed from: r  reason: collision with root package name */
    public gv.y f4183r;

    /* renamed from: s  reason: collision with root package name */
    public final HashMap<String, String> f4184s;

    /* renamed from: t  reason: collision with root package name */
    public final tl f4185t;

    /* renamed from: tl  reason: collision with root package name */
    public final UUID f4186tl;

    /* renamed from: v  reason: collision with root package name */
    public final int f4187v;

    /* renamed from: w  reason: collision with root package name */
    public int f4188w;

    /* renamed from: wz  reason: collision with root package name */
    public final Looper f4189wz;
    @Nullable

    /* renamed from: x4  reason: collision with root package name */
    public byte[] f4190x4;

    /* renamed from: xc  reason: collision with root package name */
    public final v f4191xc;
    @Nullable
    public final List<DrmInitData.SchemeData> y;
    @Nullable

    /* renamed from: z  reason: collision with root package name */
    public a9.n3 f4192z;

    /* renamed from: zn  reason: collision with root package name */
    public final InterfaceC0046y f4193zn;

    /* loaded from: classes.dex */
    public static final class a extends IOException {
        public a(@Nullable Throwable th) {
            super(th);
        }
    }

    /* loaded from: classes.dex */
    public static final class gv {

        /* renamed from: gv  reason: collision with root package name */
        public final Object f4194gv;

        /* renamed from: n3  reason: collision with root package name */
        public final boolean f4195n3;

        /* renamed from: v  reason: collision with root package name */
        public int f4196v;
        public final long y;

        /* renamed from: zn  reason: collision with root package name */
        public final long f4197zn;

        public gv(long j2, boolean z2, long j4, Object obj) {
            this.y = j2;
            this.f4195n3 = z2;
            this.f4197zn = j4;
            this.f4194gv = obj;
        }
    }

    /* loaded from: classes.dex */
    public interface n3 {
        void n3(y yVar, int i);

        void y(y yVar, int i);
    }

    @SuppressLint({"HandlerLeak"})
    /* loaded from: classes.dex */
    public class v extends Handler {
        public v(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Pair pair = (Pair) message.obj;
            Object obj = pair.first;
            Object obj2 = pair.second;
            int i = message.what;
            if (i == 0) {
                y.this.mg(obj, obj2);
            } else if (i == 1) {
                y.this.f3(obj, obj2);
            }
        }
    }

    /* renamed from: com.google.android.exoplayer2.drm.y$y  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0046y {
        void n3(y yVar);

        void y(Exception exc, boolean z2);

        void zn();
    }

    @SuppressLint({"HandlerLeak"})
    /* loaded from: classes.dex */
    public class zn extends Handler {
        public boolean y;

        public zn(Looper looper) {
            super(looper);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.Throwable, java.lang.Exception] */
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            byte[] bArr;
            gv gvVar = (gv) message.obj;
            try {
                int i = message.what;
                if (i != 0) {
                    if (i == 1) {
                        bArr = y.this.f4185t.n3(y.this.f4186tl, (i9.y) gvVar.f4194gv);
                    } else {
                        throw new RuntimeException();
                    }
                } else {
                    bArr = y.this.f4185t.y(y.this.f4186tl, (i9.gv) gvVar.f4194gv);
                }
            } catch (d0 e2) {
                boolean y = y(message, e2);
                bArr = e2;
                if (y) {
                    return;
                }
            } catch (Exception e3) {
                r.i9("DefaultDrmSession", "Key/provisioning request produced an unexpected exception. Not retrying.", e3);
                bArr = e3;
            }
            y.this.f4178i9.zn(gvVar.y);
            synchronized (this) {
                try {
                    if (!this.y) {
                        y.this.f4191xc.obtainMessage(message.what, Pair.create(gvVar.f4194gv, bArr)).sendToTarget();
                    }
                } finally {
                }
            }
        }

        public void n3(int i, Object obj, boolean z2) {
            obtainMessage(i, new gv(i4.y(), z2, SystemClock.elapsedRealtime(), obj)).sendToTarget();
        }

        public final boolean y(Message message, d0 d0Var) {
            IOException aVar;
            gv gvVar = (gv) message.obj;
            if (!gvVar.f4195n3) {
                return false;
            }
            int i = gvVar.f4196v + 1;
            gvVar.f4196v = i;
            if (i > y.this.f4178i9.y(3)) {
                return false;
            }
            i4 i4Var = new i4(gvVar.y, d0Var.dataSpec, d0Var.uriAfterRedirects, d0Var.responseHeaders, SystemClock.elapsedRealtime(), SystemClock.elapsedRealtime() - gvVar.f4197zn, d0Var.bytesLoaded);
            c cVar = new c(3);
            if (d0Var.getCause() instanceof IOException) {
                aVar = (IOException) d0Var.getCause();
            } else {
                aVar = new a(d0Var.getCause());
            }
            long gv2 = y.this.f4178i9.gv(new mg.zn(i4Var, cVar, aVar, gvVar.f4196v));
            if (gv2 == -9223372036854775807L) {
                return false;
            }
            synchronized (this) {
                try {
                    if (this.y) {
                        return false;
                    }
                    sendMessageDelayed(Message.obtain(message), gv2);
                    return true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public synchronized void zn() {
            removeCallbacksAndMessages(null);
            this.y = true;
        }
    }

    public y(UUID uuid, i9 i9Var, InterfaceC0046y interfaceC0046y, n3 n3Var, @Nullable List<DrmInitData.SchemeData> list, int i, boolean z2, boolean z3, @Nullable byte[] bArr, HashMap<String, String> hashMap, tl tlVar, Looper looper, mg mgVar, u0 u0Var) {
        if (i == 1 || i == 3) {
            v5.y.v(bArr);
        }
        this.f4186tl = uuid;
        this.f4193zn = interfaceC0046y;
        this.f4176gv = n3Var;
        this.f4181n3 = i9Var;
        this.f4187v = i;
        this.f4170a = z2;
        this.f4175fb = z3;
        if (bArr != null) {
            this.f4177i4 = bArr;
            this.y = null;
        } else {
            this.y = Collections.unmodifiableList((List) v5.y.v(list));
        }
        this.f4184s = hashMap;
        this.f4185t = tlVar;
        this.f4171c5 = new v5.i9<>();
        this.f4178i9 = mgVar;
        this.f4173f = u0Var;
        this.f4188w = 2;
        this.f4189wz = looper;
        this.f4191xc = new v(looper);
    }

    @Override // com.google.android.exoplayer2.drm.gv
    @Nullable
    public Map<String, String> a() {
        ud();
        byte[] bArr = this.f4190x4;
        if (bArr == null) {
            return null;
        }
        return this.f4181n3.n3(bArr);
    }

    public final void c() {
        if (this.f4187v == 0 && this.f4188w == 4) {
            j5.i9(this.f4190x4);
            p(false);
        }
    }

    public boolean co(byte[] bArr) {
        ud();
        return Arrays.equals(this.f4190x4, bArr);
    }

    public final void d(byte[] bArr, int i, boolean z2) {
        try {
            this.f4174f3 = this.f4181n3.tl(bArr, this.y, i, this.f4184s);
            ((zn) j5.i9(this.f4172co)).n3(1, v5.y.v(this.f4174f3), z2);
        } catch (Exception e2) {
            n(e2, true);
        }
    }

    public void d0(int i) {
        if (i == 2) {
            c();
        }
    }

    public final boolean ej() {
        try {
            this.f4181n3.v(this.f4190x4, this.f4177i4);
            return true;
        } catch (Exception e2) {
            i4(e2, 1);
            return false;
        }
    }

    public final void f3(Object obj, Object obj2) {
        if (obj == this.f4174f3 && z()) {
            this.f4174f3 = null;
            if (obj2 instanceof Exception) {
                n((Exception) obj2, false);
                return;
            }
            try {
                byte[] bArr = (byte[]) obj2;
                if (this.f4187v == 3) {
                    this.f4181n3.t((byte[]) j5.i9(this.f4177i4), bArr);
                    w(new v5.c5() { // from class: f8.v
                        @Override // v5.c5
                        public final void accept(Object obj3) {
                            ((v.y) obj3).c5();
                        }
                    });
                    return;
                }
                byte[] t2 = this.f4181n3.t(this.f4190x4, bArr);
                int i = this.f4187v;
                if ((i == 2 || (i == 0 && this.f4177i4 != null)) && t2 != null && t2.length != 0) {
                    this.f4177i4 = t2;
                }
                this.f4188w = 4;
                w(new v5.c5() { // from class: f8.a
                    @Override // v5.c5
                    public final void accept(Object obj3) {
                        ((v.y) obj3).s();
                    }
                });
            } catch (Exception e2) {
                n(e2, true);
            }
        }
    }

    @Override // com.google.android.exoplayer2.drm.gv
    public boolean fb(String str) {
        ud();
        return this.f4181n3.i9((byte[]) v5.y.c5(this.f4190x4), str);
    }

    public void fh() {
        if (ta()) {
            p(true);
        }
    }

    @Override // com.google.android.exoplayer2.drm.gv
    @Nullable
    public final gv.y getError() {
        ud();
        if (this.f4188w == 1) {
            return this.f4183r;
        }
        return null;
    }

    @Override // com.google.android.exoplayer2.drm.gv
    public final int getState() {
        ud();
        return this.f4188w;
    }

    @Override // com.google.android.exoplayer2.drm.gv
    public boolean gv() {
        ud();
        return this.f4170a;
    }

    public final void i4(final Exception exc, int i) {
        this.f4183r = new gv.y(exc, fb.y(exc, i));
        r.gv("DefaultDrmSession", "DRM session error", exc);
        w(new v5.c5() { // from class: f8.gv
            @Override // v5.c5
            public final void accept(Object obj) {
                ((v.y) obj).t(exc);
            }
        });
        if (this.f4188w != 4) {
            this.f4188w = 1;
        }
    }

    public final void mg(Object obj, Object obj2) {
        if (obj == this.f4180n) {
            if (this.f4188w == 2 || z()) {
                this.f4180n = null;
                if (obj2 instanceof Exception) {
                    this.f4193zn.y((Exception) obj2, false);
                    return;
                }
                try {
                    this.f4181n3.fb((byte[]) obj2);
                    this.f4193zn.zn();
                } catch (Exception e2) {
                    this.f4193zn.y(e2, true);
                }
            }
        }
    }

    public final long mt() {
        if (!m1.c5.f10604gv.equals(this.f4186tl)) {
            return Long.MAX_VALUE;
        }
        Pair pair = (Pair) v5.y.v(rz.n3(this));
        return Math.min(((Long) pair.first).longValue(), ((Long) pair.second).longValue());
    }

    public final void n(Exception exc, boolean z2) {
        int i;
        if (exc instanceof NotProvisionedException) {
            this.f4193zn.n3(this);
            return;
        }
        if (z2) {
            i = 1;
        } else {
            i = 2;
        }
        i4(exc, i);
    }

    @Override // com.google.android.exoplayer2.drm.gv
    public void n3(@Nullable v.y yVar) {
        ud();
        int i = this.f4182p;
        if (i <= 0) {
            r.zn("DefaultDrmSession", "release() called on a session that's already fully released.");
            return;
        }
        int i5 = i - 1;
        this.f4182p = i5;
        if (i5 == 0) {
            this.f4188w = 0;
            ((v) j5.i9(this.f4191xc)).removeCallbacksAndMessages(null);
            ((zn) j5.i9(this.f4172co)).zn();
            this.f4172co = null;
            ((HandlerThread) j5.i9(this.f4179mt)).quit();
            this.f4179mt = null;
            this.f4192z = null;
            this.f4183r = null;
            this.f4174f3 = null;
            this.f4180n = null;
            byte[] bArr = this.f4190x4;
            if (bArr != null) {
                this.f4181n3.f(bArr);
                this.f4190x4 = null;
            }
        }
        if (yVar != null) {
            this.f4171c5.zn(yVar);
            if (this.f4171c5.n3(yVar) == 0) {
                yVar.tl();
            }
        }
        this.f4176gv.n3(this, this.f4182p);
    }

    public final void p(boolean z2) {
        if (this.f4175fb) {
            return;
        }
        byte[] bArr = (byte[]) j5.i9(this.f4190x4);
        int i = this.f4187v;
        if (i != 0 && i != 1) {
            if (i != 2) {
                if (i == 3) {
                    v5.y.v(this.f4177i4);
                    v5.y.v(this.f4190x4);
                    d(this.f4177i4, 3, z2);
                }
            } else if (this.f4177i4 == null || ej()) {
                d(bArr, 2, z2);
            }
        } else if (this.f4177i4 == null) {
            d(bArr, 1, z2);
        } else if (this.f4188w == 4 || ej()) {
            long mt2 = mt();
            if (this.f4187v == 0 && mt2 <= 60) {
                r.n3("DefaultDrmSession", "Offline license has expired or will expire soon. Remaining seconds: " + mt2);
                d(bArr, 2, z2);
            } else if (mt2 <= 0) {
                i4(new f8.c(), 2);
            } else {
                this.f4188w = 4;
                w(new v5.c5() { // from class: f8.zn
                    @Override // v5.c5
                    public final void accept(Object obj) {
                        ((v.y) obj).i9();
                    }
                });
            }
        }
    }

    public void rz(Exception exc, boolean z2) {
        int i;
        if (z2) {
            i = 1;
        } else {
            i = 3;
        }
        i4(exc, i);
    }

    public final boolean ta() {
        if (z()) {
            return true;
        }
        try {
            byte[] gv2 = this.f4181n3.gv();
            this.f4190x4 = gv2;
            this.f4181n3.y(gv2, this.f4173f);
            this.f4192z = this.f4181n3.c5(this.f4190x4);
            this.f4188w = 3;
            w(new v5.c5() { // from class: f8.n3
                @Override // v5.c5
                public final void accept(Object obj) {
                    ((v.y) obj).f(r1);
                }
            });
            v5.y.v(this.f4190x4);
            return true;
        } catch (NotProvisionedException unused) {
            this.f4193zn.n3(this);
            return false;
        } catch (Exception e2) {
            i4(e2, 1);
            return false;
        }
    }

    public final void ud() {
        if (Thread.currentThread() != this.f4189wz.getThread()) {
            r.i9("DefaultDrmSession", "DefaultDrmSession accessed on the wrong thread.\nCurrent thread: " + Thread.currentThread().getName() + "\nExpected thread: " + this.f4189wz.getThread().getName(), new IllegalStateException());
        }
    }

    @Override // com.google.android.exoplayer2.drm.gv
    @Nullable
    public final a9.n3 v() {
        ud();
        return this.f4192z;
    }

    public final void w(v5.c5<v.y> c5Var) {
        for (v.y yVar : this.f4171c5.ct()) {
            c5Var.accept(yVar);
        }
    }

    @Override // com.google.android.exoplayer2.drm.gv
    public void y(@Nullable v.y yVar) {
        ud();
        boolean z2 = false;
        if (this.f4182p < 0) {
            r.zn("DefaultDrmSession", "Session reference count less than zero: " + this.f4182p);
            this.f4182p = 0;
        }
        if (yVar != null) {
            this.f4171c5.y(yVar);
        }
        int i = this.f4182p + 1;
        this.f4182p = i;
        if (i == 1) {
            if (this.f4188w == 2) {
                z2 = true;
            }
            v5.y.fb(z2);
            HandlerThread handlerThread = new HandlerThread("ExoPlayer:DrmRequestHandler");
            this.f4179mt = handlerThread;
            handlerThread.start();
            this.f4172co = new zn(this.f4179mt.getLooper());
            if (ta()) {
                p(true);
            }
        } else if (yVar != null && z() && this.f4171c5.n3(yVar) == 1) {
            yVar.f(this.f4188w);
        }
        this.f4176gv.y(this, this.f4182p);
    }

    public final boolean z() {
        int i = this.f4188w;
        if (i != 3 && i != 4) {
            return false;
        }
        return true;
    }

    public void z6() {
        this.f4180n = this.f4181n3.zn();
        ((zn) j5.i9(this.f4172co)).n3(0, v5.y.v(this.f4180n), true);
    }

    @Override // com.google.android.exoplayer2.drm.gv
    public final UUID zn() {
        ud();
        return this.f4186tl;
    }
}
