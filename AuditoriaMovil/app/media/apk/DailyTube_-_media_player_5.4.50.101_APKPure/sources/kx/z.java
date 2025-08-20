package kx;

import android.content.Context;
import android.os.Handler;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.NetworkTypeObserver;
import java.util.HashMap;
import java.util.Map;
import kx.a;
/* loaded from: classes.dex */
public final class z implements a, o {
    @Nullable

    /* renamed from: x4  reason: collision with root package name */
    public static z f10168x4;

    /* renamed from: a  reason: collision with root package name */
    public int f10170a;

    /* renamed from: c5  reason: collision with root package name */
    public int f10171c5;

    /* renamed from: f  reason: collision with root package name */
    public long f10172f;

    /* renamed from: fb  reason: collision with root package name */
    public long f10173fb;

    /* renamed from: gv  reason: collision with root package name */
    public final v5.v f10174gv;

    /* renamed from: i9  reason: collision with root package name */
    public long f10175i9;

    /* renamed from: n3  reason: collision with root package name */
    public final a.y.C0143y f10176n3;

    /* renamed from: s  reason: collision with root package name */
    public long f10177s;

    /* renamed from: t  reason: collision with root package name */
    public long f10178t;

    /* renamed from: tl  reason: collision with root package name */
    public long f10179tl;

    /* renamed from: v  reason: collision with root package name */
    public final boolean f10180v;

    /* renamed from: wz  reason: collision with root package name */
    public boolean f10181wz;

    /* renamed from: xc  reason: collision with root package name */
    public int f10182xc;
    public final z0.f3<Integer, Long> y;

    /* renamed from: zn  reason: collision with root package name */
    public final hw f10183zn;

    /* renamed from: w  reason: collision with root package name */
    public static final z0.x4<Long> f10167w = z0.x4.jz(4400000L, 3200000L, 2300000L, 1600000L, 810000L);

    /* renamed from: p  reason: collision with root package name */
    public static final z0.x4<Long> f10165p = z0.x4.jz(1400000L, 990000L, 730000L, 510000L, 230000L);

    /* renamed from: mt  reason: collision with root package name */
    public static final z0.x4<Long> f10164mt = z0.x4.jz(2100000L, 1400000L, 1000000L, 890000L, 640000L);

    /* renamed from: co  reason: collision with root package name */
    public static final z0.x4<Long> f10163co = z0.x4.jz(2600000L, 1700000L, 1300000L, 1000000L, 700000L);

    /* renamed from: z  reason: collision with root package name */
    public static final z0.x4<Long> f10169z = z0.x4.jz(5700000L, 3700000L, 2300000L, 1700000L, 990000L);

    /* renamed from: r  reason: collision with root package name */
    public static final z0.x4<Long> f10166r = z0.x4.jz(2800000L, 1800000L, 1400000L, 1100000L, 870000L);

    /* loaded from: classes.dex */
    public static final class n3 {

        /* renamed from: gv  reason: collision with root package name */
        public v5.v f10184gv;

        /* renamed from: n3  reason: collision with root package name */
        public Map<Integer, Long> f10185n3;

        /* renamed from: v  reason: collision with root package name */
        public boolean f10186v;
        @Nullable
        public final Context y;

        /* renamed from: zn  reason: collision with root package name */
        public int f10187zn;

        public n3(Context context) {
            Context applicationContext;
            if (context == null) {
                applicationContext = null;
            } else {
                applicationContext = context.getApplicationContext();
            }
            this.y = applicationContext;
            this.f10185n3 = n3(v5.j5.yt(context));
            this.f10187zn = 2000;
            this.f10184gv = v5.v.y;
            this.f10186v = true;
        }

        public static Map<Integer, Long> n3(String str) {
            int[] t2 = z.t(str);
            HashMap hashMap = new HashMap(8);
            hashMap.put(0, 1000000L);
            z0.x4<Long> x4Var = z.f10167w;
            hashMap.put(2, x4Var.get(t2[0]));
            hashMap.put(3, z.f10165p.get(t2[1]));
            hashMap.put(4, z.f10164mt.get(t2[2]));
            hashMap.put(5, z.f10163co.get(t2[3]));
            hashMap.put(10, z.f10169z.get(t2[4]));
            hashMap.put(9, z.f10166r.get(t2[5]));
            hashMap.put(7, x4Var.get(t2[0]));
            return hashMap;
        }

        public z y() {
            return new z(this.y, this.f10185n3, this.f10187zn, this.f10184gv, this.f10186v);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:954:0x0cf8, code lost:
        if (r8.equals("AD") == false) goto L3;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int[] t(java.lang.String r8) {
        /*
            Method dump skipped, instructions count: 8436
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: kx.z.t(java.lang.String):int[]");
    }

    public static synchronized z wz(Context context) {
        z zVar;
        synchronized (z.class) {
            try {
                if (f10168x4 == null) {
                    f10168x4 = new n3(context).y();
                }
                zVar = f10168x4;
            } catch (Throwable th) {
                throw th;
            }
        }
        return zVar;
    }

    public static boolean xc(p pVar, boolean z2) {
        if (z2 && !pVar.gv(8)) {
            return true;
        }
        return false;
    }

    @Override // kx.a
    public synchronized long a() {
        return this.f10178t;
    }

    @Override // kx.a
    public void c5(Handler handler, a.y yVar) {
        v5.y.v(handler);
        v5.y.v(yVar);
        this.f10176n3.n3(handler, yVar);
    }

    @Override // kx.o
    public synchronized void gv(tl tlVar, p pVar, boolean z2) {
        boolean z3;
        try {
            if (!xc(pVar, z2)) {
                return;
            }
            if (this.f10170a > 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            v5.y.fb(z3);
            long elapsedRealtime = this.f10174gv.elapsedRealtime();
            int i = (int) (elapsedRealtime - this.f10173fb);
            this.f10175i9 += i;
            long j2 = this.f10172f;
            long j4 = this.f10177s;
            this.f10172f = j2 + j4;
            if (i > 0) {
                this.f10183zn.zn((int) Math.sqrt(j4), (((float) j4) * 8000.0f) / i);
                if (this.f10175i9 < 2000) {
                    if (this.f10172f >= 524288) {
                    }
                    w(i, this.f10177s, this.f10178t);
                    this.f10173fb = elapsedRealtime;
                    this.f10177s = 0L;
                }
                this.f10178t = this.f10183zn.a(0.5f);
                w(i, this.f10177s, this.f10178t);
                this.f10173fb = elapsedRealtime;
                this.f10177s = 0L;
            }
            this.f10170a--;
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // kx.a
    public /* synthetic */ long n3() {
        return gv.y(this);
    }

    public final synchronized void p(int i) {
        int i5;
        int i6 = this.f10171c5;
        if (i6 != 0 && !this.f10180v) {
            return;
        }
        if (this.f10181wz) {
            i = this.f10182xc;
        }
        if (i6 == i) {
            return;
        }
        this.f10171c5 = i;
        if (i != 1 && i != 0 && i != 8) {
            this.f10178t = tl(i);
            long elapsedRealtime = this.f10174gv.elapsedRealtime();
            if (this.f10170a > 0) {
                i5 = (int) (elapsedRealtime - this.f10173fb);
            } else {
                i5 = 0;
            }
            w(i5, this.f10177s, this.f10178t);
            this.f10173fb = elapsedRealtime;
            this.f10177s = 0L;
            this.f10172f = 0L;
            this.f10175i9 = 0L;
            this.f10183zn.c5();
        }
    }

    @Override // kx.a
    public void s(a.y yVar) {
        this.f10176n3.v(yVar);
    }

    public final long tl(int i) {
        Long l2 = this.y.get(Integer.valueOf(i));
        if (l2 == null) {
            l2 = this.y.get(0);
        }
        if (l2 == null) {
            l2 = 1000000L;
        }
        return l2.longValue();
    }

    @Override // kx.o
    public synchronized void v(tl tlVar, p pVar, boolean z2, int i) {
        if (!xc(pVar, z2)) {
            return;
        }
        this.f10177s += i;
    }

    public final void w(int i, long j2, long j4) {
        if (i == 0 && j2 == 0 && j4 == this.f10179tl) {
            return;
        }
        this.f10179tl = j4;
        this.f10176n3.zn(i, j2, j4);
    }

    @Override // kx.o
    public synchronized void y(tl tlVar, p pVar, boolean z2) {
        try {
            if (!xc(pVar, z2)) {
                return;
            }
            if (this.f10170a == 0) {
                this.f10173fb = this.f10174gv.elapsedRealtime();
            }
            this.f10170a++;
        } catch (Throwable th) {
            throw th;
        }
    }

    public z(@Nullable Context context, Map<Integer, Long> map, int i, v5.v vVar, boolean z2) {
        this.y = z0.f3.s(map);
        this.f10176n3 = new a.y.C0143y();
        this.f10183zn = new hw(i);
        this.f10174gv = vVar;
        this.f10180v = z2;
        if (context != null) {
            NetworkTypeObserver networkTypeObserver = NetworkTypeObserver.getInstance(context);
            int networkType = networkTypeObserver.getNetworkType();
            this.f10171c5 = networkType;
            this.f10178t = tl(networkType);
            networkTypeObserver.register(new NetworkTypeObserver.Listener() { // from class: kx.co
                @Override // com.google.android.exoplayer2.util.NetworkTypeObserver.Listener
                public final void onNetworkTypeChanged(int i5) {
                    z.this.p(i5);
                }
            });
            return;
        }
        this.f10171c5 = 0;
        this.f10178t = tl(0);
    }

    @Override // kx.a
    public o zn() {
        return this;
    }

    @Override // kx.o
    public void fb(tl tlVar, p pVar, boolean z2) {
    }
}
