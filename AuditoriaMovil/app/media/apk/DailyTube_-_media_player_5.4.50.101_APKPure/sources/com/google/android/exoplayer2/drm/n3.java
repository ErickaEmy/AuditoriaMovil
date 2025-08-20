package com.google.android.exoplayer2.drm;

import android.annotation.SuppressLint;
import android.media.ResourceBusyException;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.a;
import com.google.android.exoplayer2.drm.gv;
import com.google.android.exoplayer2.drm.i9;
import com.google.android.exoplayer2.drm.n3;
import com.google.android.exoplayer2.drm.v;
import com.google.android.exoplayer2.drm.y;
import f8.i4;
import fj.u0;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import kx.mg;
import kx.n;
import m1.m;
import v5.j5;
import v5.r;
import z0.c;
import z0.en;
import z0.q9;
import z0.x4;
/* loaded from: classes.dex */
public class n3 implements com.google.android.exoplayer2.drm.a {

    /* renamed from: a  reason: collision with root package name */
    public final HashMap<String, String> f4128a;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public volatile gv f4129c;

    /* renamed from: c5  reason: collision with root package name */
    public final boolean f4130c5;
    @Nullable

    /* renamed from: co  reason: collision with root package name */
    public com.google.android.exoplayer2.drm.y f4131co;

    /* renamed from: f  reason: collision with root package name */
    public final mg f4132f;
    @Nullable

    /* renamed from: f3  reason: collision with root package name */
    public byte[] f4133f3;

    /* renamed from: fb  reason: collision with root package name */
    public final boolean f4134fb;

    /* renamed from: gv  reason: collision with root package name */
    public final i9.zn f4135gv;

    /* renamed from: i4  reason: collision with root package name */
    public int f4136i4;

    /* renamed from: i9  reason: collision with root package name */
    public final fb f4137i9;
    @Nullable

    /* renamed from: mt  reason: collision with root package name */
    public i9 f4138mt;

    /* renamed from: n  reason: collision with root package name */
    public u0 f4139n;

    /* renamed from: p  reason: collision with root package name */
    public int f4140p;

    /* renamed from: r  reason: collision with root package name */
    public Looper f4141r;

    /* renamed from: s  reason: collision with root package name */
    public final int[] f4142s;

    /* renamed from: t  reason: collision with root package name */
    public final s f4143t;

    /* renamed from: tl  reason: collision with root package name */
    public final long f4144tl;

    /* renamed from: v  reason: collision with root package name */
    public final tl f4145v;

    /* renamed from: w  reason: collision with root package name */
    public final Set<com.google.android.exoplayer2.drm.y> f4146w;

    /* renamed from: wz  reason: collision with root package name */
    public final List<com.google.android.exoplayer2.drm.y> f4147wz;

    /* renamed from: x4  reason: collision with root package name */
    public Handler f4148x4;

    /* renamed from: xc  reason: collision with root package name */
    public final Set<a> f4149xc;
    @Nullable

    /* renamed from: z  reason: collision with root package name */
    public com.google.android.exoplayer2.drm.y f4150z;

    /* renamed from: zn  reason: collision with root package name */
    public final UUID f4151zn;

    /* loaded from: classes.dex */
    public class a implements a.n3 {

        /* renamed from: gv  reason: collision with root package name */
        public boolean f4152gv;
        @Nullable

        /* renamed from: n3  reason: collision with root package name */
        public final v.y f4153n3;
        @Nullable

        /* renamed from: zn  reason: collision with root package name */
        public com.google.android.exoplayer2.drm.gv f4155zn;

        public a(@Nullable v.y yVar) {
            this.f4153n3 = yVar;
        }

        public final /* synthetic */ void gv(m mVar) {
            if (n3.this.f4140p != 0 && !this.f4152gv) {
                n3 n3Var = n3.this;
                this.f4155zn = n3Var.co((Looper) v5.y.v(n3Var.f4141r), this.f4153n3, mVar, false);
                n3.this.f4149xc.add(this);
            }
        }

        @Override // com.google.android.exoplayer2.drm.a.n3
        public void release() {
            j5.oa((Handler) v5.y.v(n3.this.f4148x4), new Runnable() { // from class: f8.s
                @Override // java.lang.Runnable
                public final void run() {
                    n3.a.this.v();
                }
            });
        }

        public final /* synthetic */ void v() {
            if (this.f4152gv) {
                return;
            }
            com.google.android.exoplayer2.drm.gv gvVar = this.f4155zn;
            if (gvVar != null) {
                gvVar.n3(this.f4153n3);
            }
            n3.this.f4149xc.remove(this);
            this.f4152gv = true;
        }

        public void zn(final m mVar) {
            ((Handler) v5.y.v(n3.this.f4148x4)).post(new Runnable() { // from class: f8.fb
                @Override // java.lang.Runnable
                public final void run() {
                    n3.a.this.gv(mVar);
                }
            });
        }
    }

    /* loaded from: classes.dex */
    public class fb implements y.InterfaceC0046y {
        @Nullable

        /* renamed from: n3  reason: collision with root package name */
        public com.google.android.exoplayer2.drm.y f4156n3;
        public final Set<com.google.android.exoplayer2.drm.y> y = new HashSet();

        public fb(n3 n3Var) {
        }

        public void gv(com.google.android.exoplayer2.drm.y yVar) {
            this.y.remove(yVar);
            if (this.f4156n3 == yVar) {
                this.f4156n3 = null;
                if (!this.y.isEmpty()) {
                    com.google.android.exoplayer2.drm.y next = this.y.iterator().next();
                    this.f4156n3 = next;
                    next.z6();
                }
            }
        }

        @Override // com.google.android.exoplayer2.drm.y.InterfaceC0046y
        public void n3(com.google.android.exoplayer2.drm.y yVar) {
            this.y.add(yVar);
            if (this.f4156n3 != null) {
                return;
            }
            this.f4156n3 = yVar;
            yVar.z6();
        }

        @Override // com.google.android.exoplayer2.drm.y.InterfaceC0046y
        public void y(Exception exc, boolean z2) {
            this.f4156n3 = null;
            x4 d2 = x4.d(this.y);
            this.y.clear();
            en it = d2.iterator();
            while (it.hasNext()) {
                ((com.google.android.exoplayer2.drm.y) it.next()).rz(exc, z2);
            }
        }

        @Override // com.google.android.exoplayer2.drm.y.InterfaceC0046y
        public void zn() {
            this.f4156n3 = null;
            x4 d2 = x4.d(this.y);
            this.y.clear();
            en it = d2.iterator();
            while (it.hasNext()) {
                ((com.google.android.exoplayer2.drm.y) it.next()).fh();
            }
        }
    }

    @SuppressLint({"HandlerLeak"})
    /* loaded from: classes.dex */
    public class gv extends Handler {
        public gv(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            byte[] bArr = (byte[]) message.obj;
            if (bArr == null) {
                return;
            }
            for (com.google.android.exoplayer2.drm.y yVar : n3.this.f4147wz) {
                if (yVar.co(bArr)) {
                    yVar.d0(message.what);
                    return;
                }
            }
        }
    }

    /* renamed from: com.google.android.exoplayer2.drm.n3$n3  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0044n3 {

        /* renamed from: a  reason: collision with root package name */
        public boolean f4157a;

        /* renamed from: gv  reason: collision with root package name */
        public boolean f4159gv;
        public final HashMap<String, String> y = new HashMap<>();

        /* renamed from: n3  reason: collision with root package name */
        public UUID f4160n3 = m1.c5.f10604gv;

        /* renamed from: zn  reason: collision with root package name */
        public i9.zn f4163zn = f.f4122gv;

        /* renamed from: fb  reason: collision with root package name */
        public mg f4158fb = new n();

        /* renamed from: v  reason: collision with root package name */
        public int[] f4162v = new int[0];

        /* renamed from: s  reason: collision with root package name */
        public long f4161s = 300000;

        public C0044n3 gv(int... iArr) {
            for (int i : iArr) {
                boolean z2 = true;
                if (i != 2 && i != 1) {
                    z2 = false;
                }
                v5.y.y(z2);
            }
            this.f4162v = (int[]) iArr.clone();
            return this;
        }

        public C0044n3 n3(boolean z2) {
            this.f4159gv = z2;
            return this;
        }

        public C0044n3 v(UUID uuid, i9.zn znVar) {
            this.f4160n3 = (UUID) v5.y.v(uuid);
            this.f4163zn = (i9.zn) v5.y.v(znVar);
            return this;
        }

        public n3 y(tl tlVar) {
            return new n3(this.f4160n3, this.f4163zn, tlVar, this.y, this.f4159gv, this.f4162v, this.f4157a, this.f4158fb, this.f4161s);
        }

        public C0044n3 zn(boolean z2) {
            this.f4157a = z2;
            return this;
        }
    }

    /* loaded from: classes.dex */
    public class s implements y.n3 {
        public s() {
        }

        @Override // com.google.android.exoplayer2.drm.y.n3
        public void n3(final com.google.android.exoplayer2.drm.y yVar, int i) {
            if (i == 1 && n3.this.f4140p > 0 && n3.this.f4144tl != -9223372036854775807L) {
                n3.this.f4146w.add(yVar);
                ((Handler) v5.y.v(n3.this.f4148x4)).postAtTime(new Runnable() { // from class: f8.c5
                    @Override // java.lang.Runnable
                    public final void run() {
                        com.google.android.exoplayer2.drm.y.this.n3(null);
                    }
                }, yVar, SystemClock.uptimeMillis() + n3.this.f4144tl);
            } else if (i == 0) {
                n3.this.f4147wz.remove(yVar);
                if (n3.this.f4131co == yVar) {
                    n3.this.f4131co = null;
                }
                if (n3.this.f4150z == yVar) {
                    n3.this.f4150z = null;
                }
                n3.this.f4137i9.gv(yVar);
                if (n3.this.f4144tl != -9223372036854775807L) {
                    ((Handler) v5.y.v(n3.this.f4148x4)).removeCallbacksAndMessages(yVar);
                    n3.this.f4146w.remove(yVar);
                }
            }
            n3.this.fh();
        }

        @Override // com.google.android.exoplayer2.drm.y.n3
        public void y(com.google.android.exoplayer2.drm.y yVar, int i) {
            if (n3.this.f4144tl != -9223372036854775807L) {
                n3.this.f4146w.remove(yVar);
                ((Handler) v5.y.v(n3.this.f4148x4)).removeCallbacksAndMessages(yVar);
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class v extends Exception {
        public v(UUID uuid) {
            super("Media does not support uuid: " + uuid);
        }
    }

    /* loaded from: classes.dex */
    public class zn implements i9.n3 {
        public zn() {
        }

        @Override // com.google.android.exoplayer2.drm.i9.n3
        public void y(i9 i9Var, @Nullable byte[] bArr, int i, int i5, @Nullable byte[] bArr2) {
            ((gv) v5.y.v(n3.this.f4129c)).obtainMessage(i, bArr).sendToTarget();
        }
    }

    public static List<DrmInitData.SchemeData> f3(DrmInitData drmInitData, UUID uuid, boolean z2) {
        ArrayList arrayList = new ArrayList(drmInitData.f4115s);
        for (int i = 0; i < drmInitData.f4115s; i++) {
            DrmInitData.SchemeData v2 = drmInitData.v(i);
            if ((v2.gv(uuid) || (m1.c5.f10607zn.equals(uuid) && v2.gv(m1.c5.f10605n3))) && (v2.f4117f != null || z2)) {
                arrayList.add(v2);
            }
        }
        return arrayList;
    }

    public static boolean z(com.google.android.exoplayer2.drm.gv gvVar) {
        if (gvVar.getState() == 1 && (j5.y < 19 || (((gv.y) v5.y.v(gvVar.getError())).getCause() instanceof ResourceBusyException))) {
            return true;
        }
        return false;
    }

    @Nullable
    public final com.google.android.exoplayer2.drm.gv c(int i, boolean z2) {
        i9 i9Var = (i9) v5.y.v(this.f4138mt);
        if ((i9Var.s() == 2 && i4.f7905gv) || j5.pq(this.f4142s, i) == -1 || i9Var.s() == 1) {
            return null;
        }
        com.google.android.exoplayer2.drm.y yVar = this.f4131co;
        if (yVar == null) {
            com.google.android.exoplayer2.drm.y i42 = i4(x4.j5(), true, null, z2);
            this.f4147wz.add(i42);
            this.f4131co = i42;
        } else {
            yVar.y(null);
        }
        return this.f4131co;
    }

    @Nullable
    public final com.google.android.exoplayer2.drm.gv co(Looper looper, @Nullable v.y yVar, m mVar, boolean z2) {
        List<DrmInitData.SchemeData> list;
        d0(looper);
        DrmInitData drmInitData = mVar.f10944d0;
        if (drmInitData == null) {
            return c(v5.n.f(mVar.f10948f3), z2);
        }
        com.google.android.exoplayer2.drm.y yVar2 = null;
        if (this.f4133f3 == null) {
            list = f3((DrmInitData) v5.y.v(drmInitData), this.f4151zn, false);
            if (list.isEmpty()) {
                v vVar = new v(this.f4151zn);
                r.gv("DefaultDrmSessionMgr", "DRM error", vVar);
                if (yVar != null) {
                    yVar.t(vVar);
                }
                return new c5(new gv.y(vVar, 6003));
            }
        } else {
            list = null;
        }
        if (!this.f4134fb) {
            yVar2 = this.f4150z;
        } else {
            Iterator<com.google.android.exoplayer2.drm.y> it = this.f4147wz.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.google.android.exoplayer2.drm.y next = it.next();
                if (j5.zn(next.y, list)) {
                    yVar2 = next;
                    break;
                }
            }
        }
        if (yVar2 == null) {
            yVar2 = i4(list, false, yVar, z2);
            if (!this.f4134fb) {
                this.f4150z = yVar2;
            }
            this.f4147wz.add(yVar2);
        } else {
            yVar2.y(yVar);
        }
        return yVar2;
    }

    public final void d(com.google.android.exoplayer2.drm.gv gvVar, @Nullable v.y yVar) {
        gvVar.n3(yVar);
        if (this.f4144tl != -9223372036854775807L) {
            gvVar.n3(null);
        }
    }

    public final void d0(Looper looper) {
        if (this.f4129c == null) {
            this.f4129c = new gv(looper);
        }
    }

    public final void fh() {
        if (this.f4138mt != null && this.f4140p == 0 && this.f4147wz.isEmpty() && this.f4149xc.isEmpty()) {
            ((i9) v5.y.v(this.f4138mt)).release();
            this.f4138mt = null;
        }
    }

    @Override // com.google.android.exoplayer2.drm.a
    public void gv(Looper looper, u0 u0Var) {
        n(looper);
        this.f4139n = u0Var;
    }

    public final com.google.android.exoplayer2.drm.y i4(@Nullable List<DrmInitData.SchemeData> list, boolean z2, @Nullable v.y yVar, boolean z3) {
        com.google.android.exoplayer2.drm.y x42 = x4(list, z2, yVar);
        if (z(x42) && !this.f4146w.isEmpty()) {
            rz();
            d(x42, yVar);
            x42 = x4(list, z2, yVar);
        }
        if (z(x42) && z3 && !this.f4149xc.isEmpty()) {
            mg();
            if (!this.f4146w.isEmpty()) {
                rz();
            }
            d(x42, yVar);
            return x4(list, z2, yVar);
        }
        return x42;
    }

    public final void mg() {
        en it = c.x4(this.f4149xc).iterator();
        while (it.hasNext()) {
            ((a) it.next()).release();
        }
    }

    public final synchronized void n(Looper looper) {
        boolean z2;
        try {
            Looper looper2 = this.f4141r;
            if (looper2 == null) {
                this.f4141r = looper;
                this.f4148x4 = new Handler(looper);
            } else {
                if (looper2 == looper) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                v5.y.fb(z2);
                v5.y.v(this.f4148x4);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.google.android.exoplayer2.drm.a
    public int n3(m mVar) {
        z6(false);
        int s2 = ((i9) v5.y.v(this.f4138mt)).s();
        DrmInitData drmInitData = mVar.f10944d0;
        if (drmInitData == null) {
            if (j5.pq(this.f4142s, v5.n.f(mVar.f10948f3)) == -1) {
                return 0;
            }
            return s2;
        } else if (!r(drmInitData)) {
            return 1;
        } else {
            return s2;
        }
    }

    @Override // com.google.android.exoplayer2.drm.a
    public final void prepare() {
        z6(true);
        int i = this.f4140p;
        this.f4140p = i + 1;
        if (i != 0) {
            return;
        }
        if (this.f4138mt == null) {
            i9 acquireExoMediaDrm = this.f4135gv.acquireExoMediaDrm(this.f4151zn);
            this.f4138mt = acquireExoMediaDrm;
            acquireExoMediaDrm.a(new zn());
        } else if (this.f4144tl != -9223372036854775807L) {
            for (int i5 = 0; i5 < this.f4147wz.size(); i5++) {
                this.f4147wz.get(i5).y(null);
            }
        }
    }

    public final boolean r(DrmInitData drmInitData) {
        if (this.f4133f3 != null) {
            return true;
        }
        if (f3(drmInitData, this.f4151zn, true).isEmpty()) {
            if (drmInitData.f4115s != 1 || !drmInitData.v(0).gv(m1.c5.f10605n3)) {
                return false;
            }
            r.c5("DefaultDrmSessionMgr", "DrmInitData only contains common PSSH SchemeData. Assuming support for: " + this.f4151zn);
        }
        String str = drmInitData.f4114fb;
        if (str == null || "cenc".equals(str)) {
            return true;
        }
        if ("cbcs".equals(str)) {
            if (j5.y >= 25) {
                return true;
            }
            return false;
        } else if (!"cbc1".equals(str) && !"cens".equals(str)) {
            return true;
        } else {
            return false;
        }
    }

    @Override // com.google.android.exoplayer2.drm.a
    public final void release() {
        z6(true);
        int i = this.f4140p - 1;
        this.f4140p = i;
        if (i != 0) {
            return;
        }
        if (this.f4144tl != -9223372036854775807L) {
            ArrayList arrayList = new ArrayList(this.f4147wz);
            for (int i5 = 0; i5 < arrayList.size(); i5++) {
                ((com.google.android.exoplayer2.drm.y) arrayList.get(i5)).n3(null);
            }
        }
        mg();
        fh();
    }

    public final void rz() {
        en it = c.x4(this.f4146w).iterator();
        while (it.hasNext()) {
            ((com.google.android.exoplayer2.drm.gv) it.next()).n3(null);
        }
    }

    public void ta(int i, @Nullable byte[] bArr) {
        v5.y.fb(this.f4147wz.isEmpty());
        if (i == 1 || i == 3) {
            v5.y.v(bArr);
        }
        this.f4136i4 = i;
        this.f4133f3 = bArr;
    }

    public final com.google.android.exoplayer2.drm.y x4(@Nullable List<DrmInitData.SchemeData> list, boolean z2, @Nullable v.y yVar) {
        v5.y.v(this.f4138mt);
        com.google.android.exoplayer2.drm.y yVar2 = new com.google.android.exoplayer2.drm.y(this.f4151zn, this.f4138mt, this.f4137i9, this.f4143t, list, this.f4136i4, this.f4130c5 | z2, z2, this.f4133f3, this.f4128a, this.f4145v, (Looper) v5.y.v(this.f4141r), this.f4132f, (u0) v5.y.v(this.f4139n));
        yVar2.y(yVar);
        if (this.f4144tl != -9223372036854775807L) {
            yVar2.y(null);
        }
        return yVar2;
    }

    @Override // com.google.android.exoplayer2.drm.a
    @Nullable
    public com.google.android.exoplayer2.drm.gv y(@Nullable v.y yVar, m mVar) {
        boolean z2 = false;
        z6(false);
        if (this.f4140p > 0) {
            z2 = true;
        }
        v5.y.fb(z2);
        v5.y.c5(this.f4141r);
        return co(this.f4141r, yVar, mVar, true);
    }

    public final void z6(boolean z2) {
        if (z2 && this.f4141r == null) {
            r.i9("DefaultDrmSessionMgr", "DefaultDrmSessionManager accessed before setPlayer(), possibly on the wrong thread.", new IllegalStateException());
        } else if (Thread.currentThread() != ((Looper) v5.y.v(this.f4141r)).getThread()) {
            r.i9("DefaultDrmSessionMgr", "DefaultDrmSessionManager accessed on the wrong thread.\nCurrent thread: " + Thread.currentThread().getName() + "\nExpected thread: " + this.f4141r.getThread().getName(), new IllegalStateException());
        }
    }

    @Override // com.google.android.exoplayer2.drm.a
    public a.n3 zn(@Nullable v.y yVar, m mVar) {
        boolean z2;
        if (this.f4140p > 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        v5.y.fb(z2);
        v5.y.c5(this.f4141r);
        a aVar = new a(yVar);
        aVar.zn(mVar);
        return aVar;
    }

    public n3(UUID uuid, i9.zn znVar, tl tlVar, HashMap<String, String> hashMap, boolean z2, int[] iArr, boolean z3, mg mgVar, long j2) {
        v5.y.v(uuid);
        v5.y.n3(!m1.c5.f10605n3.equals(uuid), "Use C.CLEARKEY_UUID instead");
        this.f4151zn = uuid;
        this.f4135gv = znVar;
        this.f4145v = tlVar;
        this.f4128a = hashMap;
        this.f4134fb = z2;
        this.f4142s = iArr;
        this.f4130c5 = z3;
        this.f4132f = mgVar;
        this.f4137i9 = new fb(this);
        this.f4143t = new s();
        this.f4136i4 = 0;
        this.f4147wz = new ArrayList();
        this.f4149xc = q9.s();
        this.f4146w = q9.s();
        this.f4144tl = j2;
    }
}
