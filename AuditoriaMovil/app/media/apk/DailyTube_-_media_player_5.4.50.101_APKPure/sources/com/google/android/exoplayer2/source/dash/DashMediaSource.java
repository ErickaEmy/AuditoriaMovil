package com.google.android.exoplayer2.source.dash;

import af.b;
import af.c;
import af.c5;
import af.d0;
import af.i4;
import af.mg;
import af.t;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseArray;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.offline.StreamKey;
import com.google.android.exoplayer2.source.dash.DashMediaSource;
import com.google.android.exoplayer2.source.dash.gv;
import com.google.android.exoplayer2.source.dash.v;
import com.google.android.exoplayer2.source.dash.y;
import dq.i9;
import dq.mt;
import f8.r;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.RoundingMode;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kx.d;
import kx.mg;
import kx.n;
import kx.o;
import kx.ta;
import kx.tl;
import kx.z6;
import m1.hy;
import m1.kp;
import m1.ne;
import m1.o0;
import v5.ej;
import v5.j5;
/* loaded from: classes.dex */
public final class DashMediaSource extends af.y {

    /* renamed from: b  reason: collision with root package name */
    public final Object f4333b;

    /* renamed from: c  reason: collision with root package name */
    public final mg f4334c;

    /* renamed from: co  reason: collision with root package name */
    public final boolean f4335co;

    /* renamed from: ct  reason: collision with root package name */
    public long f4336ct;

    /* renamed from: d  reason: collision with root package name */
    public final b.y f4337d;

    /* renamed from: d0  reason: collision with root package name */
    public final zr.n3 f4338d0;

    /* renamed from: dm  reason: collision with root package name */
    public boolean f4339dm;

    /* renamed from: eb  reason: collision with root package name */
    public int f4340eb;

    /* renamed from: ej  reason: collision with root package name */
    public final z6.y<? extends dq.zn> f4341ej;

    /* renamed from: en  reason: collision with root package name */
    public Handler f4342en;

    /* renamed from: f3  reason: collision with root package name */
    public final c5 f4343f3;

    /* renamed from: f7  reason: collision with root package name */
    public IOException f4344f7;

    /* renamed from: fh  reason: collision with root package name */
    public final long f4345fh;

    /* renamed from: j  reason: collision with root package name */
    public final v.n3 f4346j;

    /* renamed from: j5  reason: collision with root package name */
    public final SparseArray<com.google.android.exoplayer2.source.dash.n3> f4347j5;

    /* renamed from: jz  reason: collision with root package name */
    public o0.fb f4348jz;
    @Nullable

    /* renamed from: k  reason: collision with root package name */
    public o f4349k;

    /* renamed from: lc  reason: collision with root package name */
    public long f4350lc;

    /* renamed from: n  reason: collision with root package name */
    public final com.google.android.exoplayer2.drm.a f4351n;

    /* renamed from: nf  reason: collision with root package name */
    public int f4352nf;

    /* renamed from: o  reason: collision with root package name */
    public final Runnable f4353o;

    /* renamed from: o4  reason: collision with root package name */
    public long f4354o4;

    /* renamed from: oz  reason: collision with root package name */
    public final d f4355oz;

    /* renamed from: p  reason: collision with root package name */
    public final o0 f4356p;

    /* renamed from: q9  reason: collision with root package name */
    public ta f4357q9;

    /* renamed from: qn  reason: collision with root package name */
    public final Runnable f4358qn;

    /* renamed from: r  reason: collision with root package name */
    public final y.InterfaceC0047y f4359r;

    /* renamed from: rs  reason: collision with root package name */
    public long f4360rs;

    /* renamed from: u  reason: collision with root package name */
    public Uri f4361u;

    /* renamed from: ut  reason: collision with root package name */
    public tl f4362ut;

    /* renamed from: x  reason: collision with root package name */
    public final v f4363x;

    /* renamed from: xg  reason: collision with root package name */
    public dq.zn f4364xg;

    /* renamed from: y5  reason: collision with root package name */
    public Uri f4365y5;

    /* renamed from: z  reason: collision with root package name */
    public final tl.y f4366z;

    /* loaded from: classes.dex */
    public static final class Factory implements mg.y {

        /* renamed from: a  reason: collision with root package name */
        public long f4367a;
        @Nullable

        /* renamed from: fb  reason: collision with root package name */
        public z6.y<? extends dq.zn> f4368fb;

        /* renamed from: gv  reason: collision with root package name */
        public c5 f4369gv;
        @Nullable

        /* renamed from: n3  reason: collision with root package name */
        public final tl.y f4370n3;

        /* renamed from: v  reason: collision with root package name */
        public kx.mg f4371v;
        public final y.InterfaceC0047y y;

        /* renamed from: zn  reason: collision with root package name */
        public r f4372zn;

        public Factory(tl.y yVar) {
            this(new gv.y(yVar), yVar);
        }

        @Override // af.mg.y
        /* renamed from: a */
        public Factory zn(r rVar) {
            this.f4372zn = (r) v5.y.a(rVar, "MediaSource.Factory#setDrmSessionManagerProvider no longer handles null by instantiating a new DefaultDrmSessionManagerProvider. Explicitly construct and pass an instance in order to retain the old behavior.");
            return this;
        }

        @Override // af.mg.y
        /* renamed from: fb */
        public Factory y(kx.mg mgVar) {
            this.f4371v = (kx.mg) v5.y.a(mgVar, "MediaSource.Factory#setLoadErrorHandlingPolicy no longer handles null by instantiating a new DefaultLoadErrorHandlingPolicy. Explicitly construct and pass an instance in order to retain the old behavior.");
            return this;
        }

        public DashMediaSource gv(dq.zn znVar, o0 o0Var) {
            v5.y.y(!znVar.f7423gv);
            o0.zn v2 = o0Var.n3().v("application/dash+xml");
            if (o0Var.f11022v == null) {
                v2.s(Uri.EMPTY);
            }
            o0 y = v2.y();
            return new DashMediaSource(y, znVar, null, null, this.y, this.f4369gv, this.f4372zn.y(y), this.f4371v, this.f4367a, null);
        }

        public Factory s(@Nullable z6.y<? extends dq.zn> yVar) {
            this.f4368fb = yVar;
            return this;
        }

        @Override // af.mg.y
        /* renamed from: v */
        public DashMediaSource n3(o0 o0Var) {
            ea.n3 n3Var;
            v5.y.v(o0Var.f11022v);
            z6.y yVar = this.f4368fb;
            if (yVar == null) {
                yVar = new dq.a();
            }
            List<StreamKey> list = o0Var.f11022v.f11082gv;
            if (!list.isEmpty()) {
                n3Var = new ea.n3(yVar, list);
            } else {
                n3Var = yVar;
            }
            return new DashMediaSource(o0Var, null, this.f4370n3, n3Var, this.y, this.f4369gv, this.f4372zn.y(o0Var), this.f4371v, this.f4367a, null);
        }

        public Factory(y.InterfaceC0047y interfaceC0047y, @Nullable tl.y yVar) {
            this.y = (y.InterfaceC0047y) v5.y.v(interfaceC0047y);
            this.f4370n3 = yVar;
            this.f4372zn = new com.google.android.exoplayer2.drm.zn();
            this.f4371v = new n();
            this.f4367a = 30000L;
            this.f4369gv = new t();
        }
    }

    /* loaded from: classes.dex */
    public final class a implements d {
        public a() {
        }

        @Override // kx.d
        public void n3() throws IOException {
            DashMediaSource.this.f4357q9.n3();
            y();
        }

        public final void y() throws IOException {
            if (DashMediaSource.this.f4344f7 == null) {
                return;
            }
            throw DashMediaSource.this.f4344f7;
        }
    }

    /* loaded from: classes.dex */
    public final class fb implements ta.n3<z6<Long>> {
        public fb() {
        }

        @Override // kx.ta.n3
        /* renamed from: n3 */
        public void ta(z6<Long> z6Var, long j2, long j4) {
            DashMediaSource.this.qk(z6Var, j2, j4);
        }

        @Override // kx.ta.n3
        /* renamed from: y */
        public void ud(z6<Long> z6Var, long j2, long j4, boolean z2) {
            DashMediaSource.this.wf(z6Var, j2, j4);
        }

        @Override // kx.ta.n3
        /* renamed from: zn */
        public ta.zn oz(z6<Long> z6Var, long j2, long j4, IOException iOException, int i) {
            return DashMediaSource.this.qj(z6Var, j2, j4, iOException);
        }

        public /* synthetic */ fb(DashMediaSource dashMediaSource, y yVar) {
            this();
        }
    }

    /* loaded from: classes.dex */
    public static final class gv implements z6.y<Long> {
        public static final Pattern y = Pattern.compile("(.+?)(Z|((\\+|-|−)(\\d\\d)(:?(\\d\\d))?))");

        @Override // kx.z6.y
        /* renamed from: n3 */
        public Long y(Uri uri, InputStream inputStream) throws IOException {
            long j2;
            long parseLong;
            String readLine = new BufferedReader(new InputStreamReader(inputStream, w0.v.f14523zn)).readLine();
            try {
                Matcher matcher = y.matcher(readLine);
                if (matcher.matches()) {
                    String group = matcher.group(1);
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.US);
                    simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
                    long time = simpleDateFormat.parse(group).getTime();
                    if (!"Z".equals(matcher.group(2))) {
                        if ("+".equals(matcher.group(4))) {
                            j2 = 1;
                        } else {
                            j2 = -1;
                        }
                        long parseLong2 = Long.parseLong(matcher.group(5));
                        String group2 = matcher.group(7);
                        if (TextUtils.isEmpty(group2)) {
                            parseLong = 0;
                        } else {
                            parseLong = Long.parseLong(group2);
                        }
                        time -= j2 * (((parseLong2 * 60) + parseLong) * 60000);
                    }
                    return Long.valueOf(time);
                }
                throw ne.v("Couldn't parse timestamp: " + readLine, null);
            } catch (ParseException e2) {
                throw ne.v(null, e2);
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class n3 extends hy {

        /* renamed from: c  reason: collision with root package name */
        public final o0 f4373c;

        /* renamed from: co  reason: collision with root package name */
        public final int f4374co;
        @Nullable

        /* renamed from: d0  reason: collision with root package name */
        public final o0.fb f4375d0;

        /* renamed from: f3  reason: collision with root package name */
        public final long f4376f3;

        /* renamed from: n  reason: collision with root package name */
        public final dq.zn f4377n;

        /* renamed from: p  reason: collision with root package name */
        public final long f4378p;

        /* renamed from: r  reason: collision with root package name */
        public final long f4379r;

        /* renamed from: t  reason: collision with root package name */
        public final long f4380t;

        /* renamed from: w  reason: collision with root package name */
        public final long f4381w;

        /* renamed from: z  reason: collision with root package name */
        public final long f4382z;

        public n3(long j2, long j4, long j6, int i, long j7, long j8, long j9, dq.zn znVar, o0 o0Var, @Nullable o0.fb fbVar) {
            boolean z2;
            boolean z3 = znVar.f7423gv;
            if (fbVar != null) {
                z2 = true;
            } else {
                z2 = false;
            }
            v5.y.fb(z3 == z2);
            this.f4380t = j2;
            this.f4381w = j4;
            this.f4378p = j6;
            this.f4374co = i;
            this.f4382z = j7;
            this.f4379r = j8;
            this.f4376f3 = j9;
            this.f4377n = znVar;
            this.f4373c = o0Var;
            this.f4375d0 = fbVar;
        }

        public static boolean f3(dq.zn znVar) {
            if (znVar.f7423gv && znVar.f7429v != -9223372036854775807L && znVar.f7425n3 == -9223372036854775807L) {
                return true;
            }
            return false;
        }

        @Override // m1.hy
        public int a(Object obj) {
            int intValue;
            if (!(obj instanceof Integer) || (intValue = ((Integer) obj).intValue() - this.f4374co) < 0 || intValue >= tl()) {
                return -1;
            }
            return intValue;
        }

        @Override // m1.hy
        public hy.gv co(int i, hy.gv gvVar, long j2) {
            v5.y.zn(i, 0, 1);
            long i42 = i4(j2);
            Object obj = hy.gv.f10789ej;
            o0 o0Var = this.f4373c;
            dq.zn znVar = this.f4377n;
            return gvVar.c5(obj, o0Var, znVar, this.f4380t, this.f4381w, this.f4378p, true, f3(znVar), this.f4375d0, i42, this.f4379r, 0, tl() - 1, this.f4382z);
        }

        @Override // m1.hy
        public hy.n3 f(int i, hy.n3 n3Var, boolean z2) {
            String str;
            v5.y.zn(i, 0, tl());
            Integer num = null;
            if (z2) {
                str = this.f4377n.gv(i).y;
            } else {
                str = null;
            }
            if (z2) {
                num = Integer.valueOf(this.f4374co + i);
            }
            return n3Var.r(str, num, 0, this.f4377n.fb(i), j5.xb(this.f4377n.gv(i).f7365n3 - this.f4377n.gv(0).f7365n3) - this.f4382z);
        }

        public final long i4(long j2) {
            long j4 = this.f4376f3;
            if (!f3(this.f4377n)) {
                return j4;
            }
            if (j2 > 0) {
                j4 += j2;
                if (j4 > this.f4379r) {
                    return -9223372036854775807L;
                }
            }
            long j6 = this.f4382z + j4;
            long fb2 = this.f4377n.fb(0);
            int i = 0;
            while (i < this.f4377n.v() - 1 && j6 >= fb2) {
                j6 -= fb2;
                i++;
                fb2 = this.f4377n.fb(i);
            }
            i9 gv2 = this.f4377n.gv(i);
            int y = gv2.y(2);
            if (y == -1) {
                return j4;
            }
            zr.s t2 = gv2.f7367zn.get(y).f7418zn.get(0).t();
            if (t2 != null && t2.fb(fb2) != 0) {
                return (j4 + t2.n3(t2.a(j6, fb2))) - j6;
            }
            return j4;
        }

        @Override // m1.hy
        public Object p(int i) {
            v5.y.zn(i, 0, tl());
            return Integer.valueOf(this.f4374co + i);
        }

        @Override // m1.hy
        public int tl() {
            return this.f4377n.v();
        }

        @Override // m1.hy
        public int z() {
            return 1;
        }
    }

    /* loaded from: classes.dex */
    public static final class s implements z6.y<Long> {
        public s() {
        }

        @Override // kx.z6.y
        /* renamed from: n3 */
        public Long y(Uri uri, InputStream inputStream) throws IOException {
            return Long.valueOf(j5.gq(new BufferedReader(new InputStreamReader(inputStream)).readLine()));
        }

        public /* synthetic */ s(y yVar) {
            this();
        }
    }

    /* loaded from: classes.dex */
    public final class v implements ta.n3<z6<dq.zn>> {
        public v() {
        }

        @Override // kx.ta.n3
        /* renamed from: n3 */
        public void ta(z6<dq.zn> z6Var, long j2, long j4) {
            DashMediaSource.this.ad(z6Var, j2, j4);
        }

        @Override // kx.ta.n3
        /* renamed from: y */
        public void ud(z6<dq.zn> z6Var, long j2, long j4, boolean z2) {
            DashMediaSource.this.wf(z6Var, j2, j4);
        }

        @Override // kx.ta.n3
        /* renamed from: zn */
        public ta.zn oz(z6<dq.zn> z6Var, long j2, long j4, IOException iOException, int i) {
            return DashMediaSource.this.cy(z6Var, j2, j4, iOException, i);
        }

        public /* synthetic */ v(DashMediaSource dashMediaSource, y yVar) {
            this();
        }
    }

    /* loaded from: classes.dex */
    public class y implements ej.n3 {
        public y() {
        }

        @Override // v5.ej.n3
        public void n3(IOException iOException) {
            DashMediaSource.this.l(iOException);
        }

        @Override // v5.ej.n3
        public void y() {
            DashMediaSource.this.gq(ej.s());
        }
    }

    /* loaded from: classes.dex */
    public final class zn implements v.n3 {
        public zn() {
        }

        @Override // com.google.android.exoplayer2.source.dash.v.n3
        public void n3() {
            DashMediaSource.this.xb();
        }

        @Override // com.google.android.exoplayer2.source.dash.v.n3
        public void y(long j2) {
            DashMediaSource.this.o0(j2);
        }

        public /* synthetic */ zn(DashMediaSource dashMediaSource, y yVar) {
            this();
        }
    }

    static {
        kp.y("goog.exo.dash");
    }

    public /* synthetic */ DashMediaSource(o0 o0Var, dq.zn znVar, tl.y yVar, z6.y yVar2, y.InterfaceC0047y interfaceC0047y, c5 c5Var, com.google.android.exoplayer2.drm.a aVar, kx.mg mgVar, long j2, y yVar3) {
        this(o0Var, znVar, yVar, yVar2, interfaceC0047y, c5Var, aVar, mgVar, j2);
    }

    private static long bk(dq.zn znVar, long j2) {
        zr.s t2;
        int v2 = znVar.v() - 1;
        i9 gv2 = znVar.gv(v2);
        long xb2 = j5.xb(gv2.f7365n3);
        long fb2 = znVar.fb(v2);
        long xb3 = j5.xb(j2);
        long xb4 = j5.xb(znVar.y);
        long xb5 = j5.xb(5000L);
        for (int i = 0; i < gv2.f7367zn.size(); i++) {
            List<dq.tl> list = gv2.f7367zn.get(i).f7418zn;
            if (!list.isEmpty() && (t2 = list.get(0).t()) != null) {
                long gv3 = ((xb4 + xb2) + t2.gv(fb2, xb3)) - xb3;
                if (gv3 < xb5 - 100000 || (gv3 > xb5 && gv3 < xb5 + 100000)) {
                    xb5 = gv3;
                }
            }
        }
        return c1.zn.y(xb5, 1000L, RoundingMode.CEILING);
    }

    public static long g(i9 i9Var, long j2, long j4) {
        long xb2 = j5.xb(i9Var.f7365n3);
        boolean tg2 = tg(i9Var);
        long j6 = Long.MAX_VALUE;
        for (int i = 0; i < i9Var.f7367zn.size(); i++) {
            dq.y yVar = i9Var.f7367zn.get(i);
            List<dq.tl> list = yVar.f7418zn;
            int i5 = yVar.f7416n3;
            boolean z2 = true;
            z2 = (i5 == 1 || i5 == 2) ? false : false;
            if ((!tg2 || !z2) && !list.isEmpty()) {
                zr.s t2 = list.get(0).t();
                if (t2 == null) {
                    return xb2 + j2;
                }
                long i92 = t2.i9(j2, j4);
                if (i92 == 0) {
                    return xb2;
                }
                long zn2 = (t2.zn(j2, j4) + i92) - 1;
                j6 = Math.min(j6, t2.y(zn2, j2) + t2.n3(zn2) + xb2);
            }
        }
        return j6;
    }

    public static boolean pz(i9 i9Var) {
        for (int i = 0; i < i9Var.f7367zn.size(); i++) {
            zr.s t2 = i9Var.f7367zn.get(i).f7418zn.get(0).t();
            if (t2 == null || t2.s()) {
                return true;
            }
        }
        return false;
    }

    public static boolean tg(i9 i9Var) {
        for (int i = 0; i < i9Var.f7367zn.size(); i++) {
            int i5 = i9Var.f7367zn.get(i).f7416n3;
            if (i5 == 1 || i5 == 2) {
                return true;
            }
        }
        return false;
    }

    public static long u0(i9 i9Var, long j2, long j4) {
        long xb2 = j5.xb(i9Var.f7365n3);
        boolean tg2 = tg(i9Var);
        long j6 = xb2;
        for (int i = 0; i < i9Var.f7367zn.size(); i++) {
            dq.y yVar = i9Var.f7367zn.get(i);
            List<dq.tl> list = yVar.f7418zn;
            int i5 = yVar.f7416n3;
            boolean z2 = true;
            z2 = (i5 == 1 || i5 == 2) ? false : false;
            if ((!tg2 || !z2) && !list.isEmpty()) {
                zr.s t2 = list.get(0).t();
                if (t2 == null) {
                    return xb2;
                }
                if (t2.i9(j2, j4) == 0) {
                    return xb2;
                }
                j6 = Math.max(j6, t2.n3(t2.zn(j2, j4)) + xb2);
            }
        }
        return j6;
    }

    private void vp(boolean z2) {
        boolean z3;
        i9 i9Var;
        long j2;
        long j4;
        o0.fb fbVar;
        boolean z4;
        for (int i = 0; i < this.f4347j5.size(); i++) {
            int keyAt = this.f4347j5.keyAt(i);
            if (keyAt >= this.f4352nf) {
                this.f4347j5.valueAt(i).b(this.f4364xg, keyAt - this.f4352nf);
            }
        }
        i9 gv2 = this.f4364xg.gv(0);
        int v2 = this.f4364xg.v() - 1;
        i9 gv3 = this.f4364xg.gv(v2);
        long fb2 = this.f4364xg.fb(v2);
        long xb2 = j5.xb(j5.y5(this.f4360rs));
        long u02 = u0(gv2, this.f4364xg.fb(0), xb2);
        long g2 = g(gv3, fb2, xb2);
        if (this.f4364xg.f7423gv && !pz(gv3)) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (z3) {
            long j6 = this.f4364xg.f7419a;
            if (j6 != -9223372036854775807L) {
                u02 = Math.max(u02, g2 - j5.xb(j6));
            }
        }
        long j7 = g2 - u02;
        dq.zn znVar = this.f4364xg;
        if (znVar.f7423gv) {
            if (znVar.y != -9223372036854775807L) {
                z4 = true;
            } else {
                z4 = false;
            }
            v5.y.fb(z4);
            long xb3 = (xb2 - j5.xb(this.f4364xg.y)) - u02;
            le(xb3, j7);
            long gf = this.f4364xg.y + j5.gf(u02);
            long xb4 = xb3 - j5.xb(this.f4348jz.y);
            long min = Math.min(5000000L, j7 / 2);
            j2 = gf;
            if (xb4 < min) {
                j4 = min;
            } else {
                j4 = xb4;
            }
            i9Var = gv2;
        } else {
            i9Var = gv2;
            j2 = -9223372036854775807L;
            j4 = 0;
        }
        long xb5 = u02 - j5.xb(i9Var.f7365n3);
        dq.zn znVar2 = this.f4364xg;
        long j8 = znVar2.y;
        long j9 = this.f4360rs;
        int i5 = this.f4352nf;
        o0 o0Var = this.f4356p;
        if (znVar2.f7423gv) {
            fbVar = this.f4348jz;
        } else {
            fbVar = null;
        }
        s8(new n3(j8, j2, j9, i5, xb5, j7, j4, znVar2, o0Var, fbVar));
        if (!this.f4335co) {
            this.f4342en.removeCallbacks(this.f4353o);
            if (z3) {
                this.f4342en.postDelayed(this.f4353o, bk(this.f4364xg, j5.y5(this.f4360rs)));
            }
            if (this.f4339dm) {
                mp();
            } else if (z2) {
                dq.zn znVar3 = this.f4364xg;
                if (znVar3.f7423gv) {
                    long j10 = znVar3.f7429v;
                    if (j10 != -9223372036854775807L) {
                        if (j10 == 0) {
                            j10 = 5000;
                        }
                        x5(Math.max(0L, (this.f4336ct + j10) - SystemClock.elapsedRealtime()));
                    }
                }
            }
        }
    }

    public void ad(z6<dq.zn> z6Var, long j2, long j4) {
        int v2;
        i4 i4Var = new i4(z6Var.y, z6Var.f10190n3, z6Var.v(), z6Var.zn(), j2, j4, z6Var.y());
        this.f4334c.zn(z6Var.y);
        this.f4337d.z(i4Var, z6Var.f10192zn);
        dq.zn gv2 = z6Var.gv();
        dq.zn znVar = this.f4364xg;
        if (znVar == null) {
            v2 = 0;
        } else {
            v2 = znVar.v();
        }
        long j6 = gv2.gv(0).f7365n3;
        int i = 0;
        while (i < v2 && this.f4364xg.gv(i).f7365n3 < j6) {
            i++;
        }
        if (gv2.f7423gv) {
            if (v2 - i > gv2.v()) {
                v5.r.c5("DashMediaSource", "Loaded out of sync manifest");
            } else {
                long j7 = this.f4350lc;
                if (j7 != -9223372036854775807L && gv2.f7426s * 1000 <= j7) {
                    v5.r.c5("DashMediaSource", "Loaded stale dynamic manifest: " + gv2.f7426s + ", " + this.f4350lc);
                } else {
                    this.f4340eb = 0;
                }
            }
            int i5 = this.f4340eb;
            this.f4340eb = i5 + 1;
            if (i5 < this.f4334c.y(z6Var.f10192zn)) {
                x5(y4());
                return;
            } else {
                this.f4344f7 = new zr.zn();
                return;
            }
        }
        this.f4364xg = gv2;
        this.f4339dm = gv2.f7423gv & this.f4339dm;
        this.f4336ct = j2 - j4;
        this.f4354o4 = j2;
        synchronized (this.f4333b) {
            try {
                if (z6Var.f10190n3.y == this.f4361u) {
                    Uri uri = this.f4364xg.f7421f;
                    if (uri == null) {
                        uri = z6Var.v();
                    }
                    this.f4361u = uri;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (v2 == 0) {
            dq.zn znVar2 = this.f4364xg;
            if (znVar2.f7423gv) {
                mt mtVar = znVar2.f7420c5;
                if (mtVar != null) {
                    oa(mtVar);
                    return;
                } else {
                    cr();
                    return;
                }
            }
            vp(true);
            return;
        }
        this.f4352nf += i;
        vp(true);
    }

    @Override // af.y
    public void ap() {
        dq.zn znVar;
        this.f4339dm = false;
        this.f4362ut = null;
        ta taVar = this.f4357q9;
        if (taVar != null) {
            taVar.t();
            this.f4357q9 = null;
        }
        this.f4336ct = 0L;
        this.f4354o4 = 0L;
        if (this.f4335co) {
            znVar = this.f4364xg;
        } else {
            znVar = null;
        }
        this.f4364xg = znVar;
        this.f4361u = this.f4365y5;
        this.f4344f7 = null;
        Handler handler = this.f4342en;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.f4342en = null;
        }
        this.f4360rs = -9223372036854775807L;
        this.f4340eb = 0;
        this.f4350lc = -9223372036854775807L;
        this.f4352nf = 0;
        this.f4347j5.clear();
        this.f4338d0.c5();
        this.f4351n.release();
    }

    @Override // af.mg
    public o0 c() {
        return this.f4356p;
    }

    public final void cr() {
        ej.i9(this.f4357q9, new y());
    }

    public ta.zn cy(z6<dq.zn> z6Var, long j2, long j4, IOException iOException, int i) {
        ta.zn s2;
        i4 i4Var = new i4(z6Var.y, z6Var.f10190n3, z6Var.v(), z6Var.zn(), j2, j4, z6Var.y());
        long gv2 = this.f4334c.gv(new mg.zn(i4Var, new c(z6Var.f10192zn), iOException, i));
        if (gv2 == -9223372036854775807L) {
            s2 = ta.f10109fb;
        } else {
            s2 = ta.s(false, gv2);
        }
        boolean zn2 = s2.zn();
        this.f4337d.f3(i4Var, z6Var.f10192zn, iOException, !zn2);
        if (!zn2) {
            this.f4334c.zn(z6Var.y);
        }
        return s2;
    }

    @Override // af.y
    public void e(@Nullable o oVar) {
        this.f4349k = oVar;
        this.f4351n.gv(Looper.myLooper(), nf());
        this.f4351n.prepare();
        if (this.f4335co) {
            vp(false);
            return;
        }
        this.f4362ut = this.f4366z.y();
        this.f4357q9 = new ta("DashMediaSource");
        this.f4342en = j5.i4();
        mp();
    }

    @Override // af.mg
    public d0 f7(mg.n3 n3Var, kx.n3 n3Var2, long j2) {
        int intValue = ((Integer) n3Var.y).intValue() - this.f4352nf;
        b.y rs2 = rs(n3Var, this.f4364xg.gv(intValue).f7365n3);
        com.google.android.exoplayer2.source.dash.n3 n3Var3 = new com.google.android.exoplayer2.source.dash.n3(intValue + this.f4352nf, this.f4364xg, this.f4338d0, intValue, this.f4359r, this.f4349k, this.f4351n, dm(n3Var), this.f4334c, rs2, this.f4360rs, this.f4355oz, n3Var2, this.f4343f3, this.f4346j, nf());
        this.f4347j5.put(n3Var3.y, n3Var3);
        return n3Var3;
    }

    public final void gq(long j2) {
        this.f4360rs = j2;
        vp(true);
    }

    public final void l(IOException iOException) {
        v5.r.gv("DashMediaSource", "Failed to resolve time offset.", iOException);
        vp(true);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00d1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void le(long r18, long r20) {
        /*
            Method dump skipped, instructions count: 277
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.dash.DashMediaSource.le(long, long):void");
    }

    public final void mp() {
        Uri uri;
        this.f4342en.removeCallbacks(this.f4358qn);
        if (this.f4357q9.c5()) {
            return;
        }
        if (this.f4357q9.i9()) {
            this.f4339dm = true;
            return;
        }
        synchronized (this.f4333b) {
            uri = this.f4361u;
        }
        this.f4339dm = false;
        q5(new z6(this.f4362ut, uri, 4, this.f4341ej), this.f4363x, this.f4334c.y(4));
    }

    public void o0(long j2) {
        long j4 = this.f4350lc;
        if (j4 == -9223372036854775807L || j4 < j2) {
            this.f4350lc = j2;
        }
    }

    public final void oa(mt mtVar) {
        String str = mtVar.y;
        if (!j5.zn(str, "urn:mpeg:dash:utc:direct:2014") && !j5.zn(str, "urn:mpeg:dash:utc:direct:2012")) {
            if (!j5.zn(str, "urn:mpeg:dash:utc:http-iso:2014") && !j5.zn(str, "urn:mpeg:dash:utc:http-iso:2012")) {
                if (!j5.zn(str, "urn:mpeg:dash:utc:http-xsdate:2014") && !j5.zn(str, "urn:mpeg:dash:utc:http-xsdate:2012")) {
                    if (!j5.zn(str, "urn:mpeg:dash:utc:ntp:2014") && !j5.zn(str, "urn:mpeg:dash:utc:ntp:2012")) {
                        l(new IOException("Unsupported UTC timing scheme"));
                        return;
                    } else {
                        cr();
                        return;
                    }
                }
                w2(mtVar, new s(null));
                return;
            }
            w2(mtVar, new gv());
            return;
        }
        w9(mtVar);
    }

    public final /* synthetic */ void pq() {
        vp(false);
    }

    public final <T> void q5(z6<T> z6Var, ta.n3<z6<T>> n3Var, int i) {
        this.f4337d.c(new i4(z6Var.y, z6Var.f10190n3, this.f4357q9.wz(z6Var, n3Var, i)), z6Var.f10192zn);
    }

    public ta.zn qj(z6<Long> z6Var, long j2, long j4, IOException iOException) {
        this.f4337d.f3(new i4(z6Var.y, z6Var.f10190n3, z6Var.v(), z6Var.zn(), j2, j4, z6Var.y()), z6Var.f10192zn, iOException, true);
        this.f4334c.zn(z6Var.y);
        l(iOException);
        return ta.f10108a;
    }

    public void qk(z6<Long> z6Var, long j2, long j4) {
        i4 i4Var = new i4(z6Var.y, z6Var.f10190n3, z6Var.v(), z6Var.zn(), j2, j4, z6Var.y());
        this.f4334c.zn(z6Var.y);
        this.f4337d.z(i4Var, z6Var.f10192zn);
        gq(z6Var.gv().longValue() - j2);
    }

    @Override // af.mg
    public void u(d0 d0Var) {
        com.google.android.exoplayer2.source.dash.n3 n3Var = (com.google.android.exoplayer2.source.dash.n3) d0Var;
        n3Var.ej();
        this.f4347j5.remove(n3Var.y);
    }

    @Override // af.mg
    public void ut() throws IOException {
        this.f4355oz.n3();
    }

    public final void w2(mt mtVar, z6.y<Long> yVar) {
        q5(new z6(this.f4362ut, Uri.parse(mtVar.f7368n3), 5, yVar), new fb(this, null), 1);
    }

    public final void w9(mt mtVar) {
        try {
            gq(j5.gq(mtVar.f7368n3) - this.f4354o4);
        } catch (ne e2) {
            l(e2);
        }
    }

    public void wf(z6<?> z6Var, long j2, long j4) {
        i4 i4Var = new i4(z6Var.y, z6Var.f10190n3, z6Var.v(), z6Var.zn(), j2, j4, z6Var.y());
        this.f4334c.zn(z6Var.y);
        this.f4337d.p(i4Var, z6Var.f10192zn);
    }

    public final void x5(long j2) {
        this.f4342en.postDelayed(this.f4358qn, j2);
    }

    public void xb() {
        this.f4342en.removeCallbacks(this.f4353o);
        mp();
    }

    public final long y4() {
        return Math.min((this.f4340eb - 1) * 1000, 5000);
    }

    public DashMediaSource(o0 o0Var, @Nullable dq.zn znVar, @Nullable tl.y yVar, @Nullable z6.y<? extends dq.zn> yVar2, y.InterfaceC0047y interfaceC0047y, c5 c5Var, com.google.android.exoplayer2.drm.a aVar, kx.mg mgVar, long j2) {
        this.f4356p = o0Var;
        this.f4348jz = o0Var.f11020s;
        this.f4361u = ((o0.s) v5.y.v(o0Var.f11022v)).y;
        this.f4365y5 = o0Var.f11022v.y;
        this.f4364xg = znVar;
        this.f4366z = yVar;
        this.f4341ej = yVar2;
        this.f4359r = interfaceC0047y;
        this.f4351n = aVar;
        this.f4334c = mgVar;
        this.f4345fh = j2;
        this.f4343f3 = c5Var;
        this.f4338d0 = new zr.n3();
        boolean z2 = znVar != null;
        this.f4335co = z2;
        this.f4337d = o4(null);
        this.f4333b = new Object();
        this.f4347j5 = new SparseArray<>();
        this.f4346j = new zn(this, null);
        this.f4350lc = -9223372036854775807L;
        this.f4360rs = -9223372036854775807L;
        if (z2) {
            v5.y.fb(true ^ znVar.f7423gv);
            this.f4363x = null;
            this.f4358qn = null;
            this.f4353o = null;
            this.f4355oz = new d.y();
            return;
        }
        this.f4363x = new v(this, null);
        this.f4355oz = new a();
        this.f4358qn = new Runnable() { // from class: zr.gv
            @Override // java.lang.Runnable
            public final void run() {
                DashMediaSource.this.mp();
            }
        };
        this.f4353o = new Runnable() { // from class: zr.v
            @Override // java.lang.Runnable
            public final void run() {
                DashMediaSource.this.pq();
            }
        };
    }
}
