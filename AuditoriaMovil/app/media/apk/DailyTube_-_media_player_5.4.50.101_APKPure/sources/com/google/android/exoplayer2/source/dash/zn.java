package com.google.android.exoplayer2.source.dash;

import af.b;
import af.c;
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
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.offline.StreamKey;
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
import java.util.Map;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kx.d;
import kx.mg;
import kx.n;
import kx.o;
import kx.ta;
import kx.tl;
import m1.hy;
import m1.kp;
import m1.ne;
import m1.o0;
import p71.zn;
import v5.ej;
import v5.j5;
/* loaded from: classes.dex */
public class zn extends af.y {

    /* renamed from: b  reason: collision with root package name */
    public final Object f4455b;

    /* renamed from: c  reason: collision with root package name */
    public final mg f4456c;

    /* renamed from: co  reason: collision with root package name */
    public final boolean f4457co;

    /* renamed from: ct  reason: collision with root package name */
    public long f4458ct;

    /* renamed from: d  reason: collision with root package name */
    public final b.y f4459d;

    /* renamed from: d0  reason: collision with root package name */
    public final zr.n3 f4460d0 = new zr.n3();

    /* renamed from: dm  reason: collision with root package name */
    public boolean f4461dm;

    /* renamed from: eb  reason: collision with root package name */
    public int f4462eb;

    /* renamed from: ej  reason: collision with root package name */
    public final zn.y<? extends dq.zn> f4463ej;

    /* renamed from: en  reason: collision with root package name */
    public Handler f4464en;

    /* renamed from: f3  reason: collision with root package name */
    public final af.c5 f4465f3;

    /* renamed from: f7  reason: collision with root package name */
    public IOException f4466f7;

    /* renamed from: fh  reason: collision with root package name */
    public final long f4467fh;

    /* renamed from: j  reason: collision with root package name */
    public final v.n3 f4468j;

    /* renamed from: j5  reason: collision with root package name */
    public final SparseArray<com.google.android.exoplayer2.source.dash.n3> f4469j5;

    /* renamed from: jz  reason: collision with root package name */
    public o0.fb f4470jz;
    @Nullable

    /* renamed from: k  reason: collision with root package name */
    public o f4471k;

    /* renamed from: lc  reason: collision with root package name */
    public long f4472lc;

    /* renamed from: n  reason: collision with root package name */
    public final com.google.android.exoplayer2.drm.a f4473n;

    /* renamed from: nf  reason: collision with root package name */
    public int f4474nf;

    /* renamed from: o  reason: collision with root package name */
    public final Runnable f4475o;

    /* renamed from: o4  reason: collision with root package name */
    public long f4476o4;

    /* renamed from: oz  reason: collision with root package name */
    public final d f4477oz;

    /* renamed from: p  reason: collision with root package name */
    public final o0 f4478p;

    /* renamed from: q9  reason: collision with root package name */
    public ta f4479q9;

    /* renamed from: qn  reason: collision with root package name */
    public final Runnable f4480qn;

    /* renamed from: r  reason: collision with root package name */
    public final y.InterfaceC0047y f4481r;

    /* renamed from: rs  reason: collision with root package name */
    public long f4482rs;

    /* renamed from: u  reason: collision with root package name */
    public Uri f4483u;

    /* renamed from: ut  reason: collision with root package name */
    public tl f4484ut;

    /* renamed from: x  reason: collision with root package name */
    public final a f4485x;

    /* renamed from: xg  reason: collision with root package name */
    public dq.zn f4486xg;

    /* renamed from: y5  reason: collision with root package name */
    public Uri f4487y5;

    /* renamed from: z  reason: collision with root package name */
    public final tl.y f4488z;

    /* loaded from: classes.dex */
    public final class a implements ta.n3<p71.zn<dq.zn>> {
        public a() {
        }

        @Override // kx.ta.n3
        /* renamed from: n3 */
        public void ta(p71.zn<dq.zn> znVar, long j2, long j4) {
            zn.this.ad(znVar, j2, j4);
        }

        @Override // kx.ta.n3
        /* renamed from: y */
        public void ud(p71.zn<dq.zn> znVar, long j2, long j4, boolean z2) {
            zn.this.wf(znVar, j2, j4);
        }

        @Override // kx.ta.n3
        /* renamed from: zn */
        public ta.zn oz(p71.zn<dq.zn> znVar, long j2, long j4, IOException iOException, int i) {
            return zn.this.cy(znVar, j2, j4, iOException, i);
        }

        public /* synthetic */ a(zn znVar, y yVar) {
            this();
        }
    }

    /* loaded from: classes.dex */
    public static final class c5 implements zn.y<Long> {
        public c5() {
        }

        /* renamed from: n3 */
        public Long y(@NonNull Uri uri, @NonNull Map<String, List<String>> map, @NonNull InputStream inputStream) throws IOException {
            return Long.valueOf(j5.gq(new BufferedReader(new InputStreamReader(inputStream)).readLine()));
        }

        public /* synthetic */ c5(y yVar) {
            this();
        }
    }

    /* loaded from: classes.dex */
    public final class fb implements d {
        public fb() {
        }

        private void y() throws IOException {
            if (zn.this.f4466f7 == null) {
                return;
            }
            throw zn.this.f4466f7;
        }

        @Override // kx.d
        public void n3() throws IOException {
            zn.this.f4479q9.n3();
            y();
        }
    }

    /* loaded from: classes.dex */
    public static final class gv implements mg.y {
        @Nullable

        /* renamed from: fb  reason: collision with root package name */
        public zn.y<? extends dq.zn> f4490fb;
        @Nullable

        /* renamed from: n3  reason: collision with root package name */
        public final tl.y f4492n3;
        public final y.InterfaceC0047y y;

        /* renamed from: zn  reason: collision with root package name */
        public r f4494zn = new com.google.android.exoplayer2.drm.zn();

        /* renamed from: v  reason: collision with root package name */
        public kx.mg f4493v = new n();

        /* renamed from: a  reason: collision with root package name */
        public long f4489a = 30000;

        /* renamed from: gv  reason: collision with root package name */
        public af.c5 f4491gv = new t();

        public gv(y.InterfaceC0047y interfaceC0047y, @Nullable tl.y yVar) {
            this.y = (y.InterfaceC0047y) v5.y.v(interfaceC0047y);
            this.f4492n3 = yVar;
        }

        @Override // af.mg.y
        /* renamed from: a */
        public gv zn(r rVar) {
            this.f4494zn = (r) v5.y.a(rVar, "MediaSource.Factory#setDrmSessionManagerProvider no longer handles null by instantiating a new DefaultDrmSessionManagerProvider. Explicitly construct and pass an instance in order to retain the old behavior.");
            return this;
        }

        @Override // af.mg.y
        /* renamed from: fb */
        public gv y(kx.mg mgVar) {
            this.f4493v = (kx.mg) v5.y.a(mgVar, "MediaSource.Factory#setLoadErrorHandlingPolicy no longer handles null by instantiating a new DefaultLoadErrorHandlingPolicy. Explicitly construct and pass an instance in order to retain the old behavior.");
            return this;
        }

        public zn gv(dq.zn znVar, o0 o0Var) {
            o0.zn v2 = o0Var.n3().v("application/dash+xml");
            if (o0Var.f11022v == null) {
                v2.s(Uri.EMPTY);
            }
            o0 y = v2.y();
            return new o71.zn(y, znVar, (tl.y) null, (zn.y) null, this.y, this.f4491gv, this.f4494zn.y(y), this.f4493v, this.f4489a);
        }

        public gv s(@Nullable zn.y<? extends dq.zn> yVar) {
            this.f4490fb = yVar;
            return this;
        }

        @Override // af.mg.y
        /* renamed from: v */
        public zn n3(o0 o0Var) {
            p71.n3 n3Var;
            v5.y.v(o0Var.f11022v);
            p71.n3 n3Var2 = this.f4490fb;
            if (n3Var2 == null) {
                n3Var2 = new p71.n3(new dq.a());
            }
            List<StreamKey> list = o0Var.f11022v.f11082gv;
            if (!list.isEmpty()) {
                n3Var = new p71.y(n3Var2, list);
            } else {
                n3Var = n3Var2;
            }
            return new zn(o0Var, null, this.f4492n3, n3Var, this.y, this.f4491gv, this.f4494zn.y(o0Var), this.f4493v, this.f4489a);
        }
    }

    /* loaded from: classes.dex */
    public static final class n3 extends hy {

        /* renamed from: c  reason: collision with root package name */
        public final o0 f4495c;

        /* renamed from: co  reason: collision with root package name */
        public final int f4496co;
        @Nullable

        /* renamed from: d0  reason: collision with root package name */
        public final o0.fb f4497d0;

        /* renamed from: f3  reason: collision with root package name */
        public final long f4498f3;

        /* renamed from: n  reason: collision with root package name */
        public final dq.zn f4499n;

        /* renamed from: p  reason: collision with root package name */
        public final long f4500p;

        /* renamed from: r  reason: collision with root package name */
        public final long f4501r;

        /* renamed from: t  reason: collision with root package name */
        public final long f4502t;

        /* renamed from: w  reason: collision with root package name */
        public final long f4503w;

        /* renamed from: z  reason: collision with root package name */
        public final long f4504z;

        public n3(long j2, long j4, long j6, int i, long j7, long j8, long j9, dq.zn znVar, o0 o0Var, @Nullable o0.fb fbVar) {
            boolean z2;
            boolean z3 = znVar.f7423gv;
            if (fbVar != null) {
                z2 = true;
            } else {
                z2 = false;
            }
            v5.y.fb(z3 == z2);
            this.f4502t = j2;
            this.f4503w = j4;
            this.f4500p = j6;
            this.f4496co = i;
            this.f4504z = j7;
            this.f4501r = j8;
            this.f4498f3 = j9;
            this.f4499n = znVar;
            this.f4495c = o0Var;
            this.f4497d0 = fbVar;
        }

        private static boolean f3(dq.zn znVar) {
            if (znVar.f7423gv && znVar.f7429v != -9223372036854775807L && znVar.f7425n3 == -9223372036854775807L) {
                return true;
            }
            return false;
        }

        private long i4(long j2) {
            long j4 = this.f4498f3;
            if (!f3(this.f4499n)) {
                return j4;
            }
            if (j2 > 0) {
                j4 += j2;
                if (j4 > this.f4501r) {
                    return -9223372036854775807L;
                }
            }
            long j6 = this.f4504z + j4;
            long fb2 = this.f4499n.fb(0);
            int i = 0;
            while (i < this.f4499n.v() - 1 && j6 >= fb2) {
                j6 -= fb2;
                i++;
                fb2 = this.f4499n.fb(i);
            }
            i9 gv2 = this.f4499n.gv(i);
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
        public int a(Object obj) {
            int intValue;
            if (!(obj instanceof Integer) || (intValue = ((Integer) obj).intValue() - this.f4496co) < 0 || intValue >= tl()) {
                return -1;
            }
            return intValue;
        }

        @Override // m1.hy
        public hy.gv co(int i, hy.gv gvVar, long j2) {
            v5.y.zn(i, 0, 1);
            long i42 = i4(j2);
            Object obj = hy.gv.f10789ej;
            o0 o0Var = this.f4495c;
            dq.zn znVar = this.f4499n;
            return gvVar.c5(obj, o0Var, znVar, this.f4502t, this.f4503w, this.f4500p, true, f3(znVar), this.f4497d0, i42, this.f4501r, 0, tl() - 1, this.f4504z);
        }

        @Override // m1.hy
        public hy.n3 f(int i, hy.n3 n3Var, boolean z2) {
            String str;
            v5.y.zn(i, 0, tl());
            Integer num = null;
            if (z2) {
                str = this.f4499n.gv(i).y;
            } else {
                str = null;
            }
            if (z2) {
                num = Integer.valueOf(this.f4496co + i);
            }
            return n3Var.r(str, num, 0, this.f4499n.fb(i), j5.xb(this.f4499n.gv(i).f7365n3 - this.f4499n.gv(0).f7365n3) - this.f4504z);
        }

        @Override // m1.hy
        public Object p(int i) {
            v5.y.zn(i, 0, tl());
            return Integer.valueOf(this.f4496co + i);
        }

        @Override // m1.hy
        public int tl() {
            return this.f4499n.v();
        }

        @Override // m1.hy
        public int z() {
            return 1;
        }
    }

    /* loaded from: classes.dex */
    public final class s implements ta.n3<p71.zn<Long>> {
        public s() {
        }

        @Override // kx.ta.n3
        /* renamed from: n3 */
        public void ta(p71.zn<Long> znVar, long j2, long j4) {
            zn.this.qk(znVar, j2, j4);
        }

        @Override // kx.ta.n3
        /* renamed from: y */
        public void ud(p71.zn<Long> znVar, long j2, long j4, boolean z2) {
            zn.this.wf(znVar, j2, j4);
        }

        @Override // kx.ta.n3
        /* renamed from: zn */
        public ta.zn oz(p71.zn<Long> znVar, long j2, long j4, IOException iOException, int i) {
            return zn.this.qj(znVar, j2, j4, iOException);
        }

        public /* synthetic */ s(zn znVar, y yVar) {
            this();
        }
    }

    /* loaded from: classes.dex */
    public static final class v implements zn.y<Long> {
        public static final Pattern y = Pattern.compile("(.+?)(Z|((\\+|-|−)(\\d\\d)(:?(\\d\\d))?))");

        /* renamed from: n3 */
        public Long y(@NonNull Uri uri, @NonNull Map<String, List<String>> map, @NonNull InputStream inputStream) throws IOException {
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
    public class y implements ej.n3 {
        public y() {
        }

        @Override // v5.ej.n3
        public void n3(IOException iOException) {
            zn.this.l(iOException);
        }

        @Override // v5.ej.n3
        public void y() {
            zn.this.gq(ej.s());
        }
    }

    /* renamed from: com.google.android.exoplayer2.source.dash.zn$zn  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public final class C0048zn implements v.n3 {
        public C0048zn() {
        }

        @Override // com.google.android.exoplayer2.source.dash.v.n3
        public void n3() {
            zn.this.xb();
        }

        @Override // com.google.android.exoplayer2.source.dash.v.n3
        public void y(long j2) {
            zn.this.o0(j2);
        }

        public /* synthetic */ C0048zn(zn znVar, y yVar) {
            this();
        }
    }

    static {
        kp.y("goog.exo.dash");
    }

    public zn(o0 o0Var, @Nullable dq.zn znVar, @Nullable tl.y yVar, @Nullable zn.y<? extends dq.zn> yVar2, y.InterfaceC0047y interfaceC0047y, af.c5 c5Var, com.google.android.exoplayer2.drm.a aVar, kx.mg mgVar, long j2) {
        boolean z2;
        this.f4478p = o0Var;
        this.f4470jz = o0Var.f11020s;
        this.f4483u = ((o0.s) v5.y.v(o0Var.f11022v)).y;
        this.f4487y5 = o0Var.f11022v.y;
        this.f4486xg = znVar;
        this.f4488z = yVar;
        this.f4463ej = yVar2;
        this.f4481r = interfaceC0047y;
        this.f4473n = aVar;
        this.f4456c = mgVar;
        this.f4467fh = j2;
        this.f4465f3 = c5Var;
        if (znVar != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        this.f4457co = z2;
        this.f4459d = o4(null);
        this.f4455b = new Object();
        this.f4469j5 = new SparseArray<>();
        this.f4468j = new C0048zn(this, null);
        this.f4472lc = -9223372036854775807L;
        this.f4482rs = -9223372036854775807L;
        if (z2) {
            this.f4485x = null;
            this.f4480qn = null;
            this.f4475o = null;
            this.f4477oz = new d.y();
            return;
        }
        this.f4485x = new a(this, null);
        this.f4477oz = new fb();
        this.f4480qn = new Runnable() { // from class: zr.a
            @Override // java.lang.Runnable
            public final void run() {
                com.google.android.exoplayer2.source.dash.zn.this.mp();
            }
        };
        this.f4475o = new Runnable() { // from class: zr.fb
            @Override // java.lang.Runnable
            public final void run() {
                com.google.android.exoplayer2.source.dash.zn.this.pq();
            }
        };
    }

    public static long bk(dq.zn znVar, long j2) {
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

    private void cr() {
        ej.i9(this.f4479q9, new y());
    }

    private static long g(i9 i9Var, long j2, long j4) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public void gq(long j2) {
        this.f4482rs = j2;
        vp(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(IOException iOException) {
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
    private void le(long r18, long r20) {
        /*
            Method dump skipped, instructions count: 277
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.dash.zn.le(long, long):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mp() {
        Uri uri;
        this.f4464en.removeCallbacks(this.f4480qn);
        if (this.f4479q9.c5()) {
            return;
        }
        if (this.f4479q9.i9()) {
            this.f4461dm = true;
            return;
        }
        synchronized (this.f4455b) {
            uri = this.f4483u;
        }
        this.f4461dm = false;
        q5(new p71.zn(this.f4484ut, uri, 4, this.f4463ej), this.f4485x, this.f4456c.y(4));
    }

    private void oa(mt mtVar) {
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
                w2(mtVar, new c5(null));
                return;
            }
            w2(mtVar, new v());
            return;
        }
        w9(mtVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void pq() {
        vp(false);
    }

    private static boolean pz(i9 i9Var) {
        for (int i = 0; i < i9Var.f7367zn.size(); i++) {
            zr.s t2 = i9Var.f7367zn.get(i).f7418zn.get(0).t();
            if (t2 == null || t2.s()) {
                return true;
            }
        }
        return false;
    }

    private static boolean tg(i9 i9Var) {
        for (int i = 0; i < i9Var.f7367zn.size(); i++) {
            int i5 = i9Var.f7367zn.get(i).f7416n3;
            if (i5 == 1 || i5 == 2) {
                return true;
            }
        }
        return false;
    }

    private static long u0(i9 i9Var, long j2, long j4) {
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

    private void w9(mt mtVar) {
        try {
            gq(j5.gq(mtVar.f7368n3) - this.f4476o4);
        } catch (ne e2) {
            l(e2);
        }
    }

    private void x5(long j2) {
        this.f4464en.postDelayed(this.f4480qn, j2);
    }

    private long y4() {
        return Math.min((this.f4462eb - 1) * 1000, 5000);
    }

    public void ad(p71.zn<dq.zn> znVar, long j2, long j4) {
        int v2;
        i4 i4Var = new i4(znVar.y, znVar.n3, znVar.v(), znVar.zn(), j2, j4, znVar.y());
        this.f4456c.zn(znVar.y);
        this.f4459d.z(i4Var, znVar.zn);
        dq.zn znVar2 = (dq.zn) znVar.gv();
        dq.zn znVar3 = this.f4486xg;
        if (znVar3 == null) {
            v2 = 0;
        } else {
            v2 = znVar3.v();
        }
        long j6 = znVar2.gv(0).f7365n3;
        int i = 0;
        while (i < v2 && this.f4486xg.gv(i).f7365n3 < j6) {
            i++;
        }
        if (znVar2.f7423gv) {
            if (v2 - i > znVar2.v()) {
                v5.r.c5("DashMediaSource", "Loaded out of sync manifest");
            } else {
                long j7 = this.f4472lc;
                if (j7 != -9223372036854775807L && znVar2.f7426s * 1000 <= j7) {
                    v5.r.c5("DashMediaSource", "Loaded stale dynamic manifest: " + znVar2.f7426s + ", " + this.f4472lc);
                } else {
                    this.f4462eb = 0;
                }
            }
            int i5 = this.f4462eb;
            this.f4462eb = i5 + 1;
            if (i5 < this.f4456c.y(znVar.zn)) {
                x5(y4());
                return;
            } else {
                this.f4466f7 = new zr.zn();
                return;
            }
        }
        this.f4486xg = znVar2;
        this.f4461dm = znVar2.f7423gv & this.f4461dm;
        this.f4458ct = j2 - j4;
        this.f4476o4 = j2;
        synchronized (this.f4455b) {
            try {
                if (znVar.n3.y == this.f4483u) {
                    Uri uri = this.f4486xg.f7421f;
                    if (uri == null) {
                        uri = znVar.v();
                    }
                    this.f4483u = uri;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (v2 == 0) {
            dq.zn znVar4 = this.f4486xg;
            if (znVar4.f7423gv) {
                mt mtVar = znVar4.f7420c5;
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
        this.f4474nf += i;
        vp(true);
    }

    @Override // af.y
    public void ap() {
        dq.zn znVar;
        this.f4461dm = false;
        this.f4484ut = null;
        ta taVar = this.f4479q9;
        if (taVar != null) {
            taVar.t();
            this.f4479q9 = null;
        }
        this.f4458ct = 0L;
        this.f4476o4 = 0L;
        if (this.f4457co) {
            znVar = this.f4486xg;
        } else {
            znVar = null;
        }
        this.f4486xg = znVar;
        this.f4483u = this.f4487y5;
        this.f4466f7 = null;
        Handler handler = this.f4464en;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.f4464en = null;
        }
        this.f4482rs = -9223372036854775807L;
        this.f4462eb = 0;
        this.f4472lc = -9223372036854775807L;
        this.f4474nf = 0;
        this.f4469j5.clear();
        this.f4460d0.c5();
        this.f4473n.release();
    }

    @Override // af.mg
    public o0 c() {
        return this.f4478p;
    }

    public ta.zn cy(p71.zn<dq.zn> znVar, long j2, long j4, IOException iOException, int i) {
        ta.zn s2;
        i4 i4Var = new i4(znVar.y, znVar.n3, znVar.v(), znVar.zn(), j2, j4, znVar.y());
        long gv2 = this.f4456c.gv(new mg.zn(i4Var, new c(znVar.zn), iOException, i));
        if (gv2 == -9223372036854775807L) {
            s2 = ta.f10109fb;
        } else {
            s2 = ta.s(false, gv2);
        }
        boolean zn2 = s2.zn();
        this.f4459d.f3(i4Var, znVar.zn, iOException, !zn2);
        if (!zn2) {
            this.f4456c.zn(znVar.y);
        }
        return s2;
    }

    @Override // af.y
    public void e(@Nullable o oVar) {
        this.f4471k = oVar;
        this.f4473n.gv(Looper.myLooper(), nf());
        this.f4473n.prepare();
        if (this.f4457co) {
            vp(false);
            return;
        }
        this.f4484ut = this.f4488z.y();
        this.f4479q9 = new ta("DashMediaSource");
        this.f4464en = j5.i4();
        mp();
    }

    @Override // af.mg
    public d0 f7(mg.n3 n3Var, kx.n3 n3Var2, long j2) {
        int intValue = ((Integer) n3Var.y).intValue() - this.f4474nf;
        b.y rs2 = rs(n3Var, this.f4486xg.gv(intValue).f7365n3);
        com.google.android.exoplayer2.source.dash.n3 n3Var3 = new com.google.android.exoplayer2.source.dash.n3(intValue + this.f4474nf, this.f4486xg, this.f4460d0, intValue, this.f4481r, this.f4471k, this.f4473n, dm(n3Var), this.f4456c, rs2, this.f4482rs, this.f4477oz, n3Var2, this.f4465f3, this.f4468j, nf());
        this.f4469j5.put(n3Var3.y, n3Var3);
        return n3Var3;
    }

    public void o0(long j2) {
        long j4 = this.f4472lc;
        if (j4 == -9223372036854775807L || j4 < j2) {
            this.f4472lc = j2;
        }
    }

    public final <T> void q5(p71.zn<T> znVar, ta.n3<p71.zn<T>> n3Var, int i) {
        this.f4459d.c(new i4(znVar.y, znVar.n3, this.f4479q9.wz(znVar, n3Var, i)), znVar.zn);
    }

    public ta.zn qj(p71.zn<Long> znVar, long j2, long j4, IOException iOException) {
        this.f4459d.f3(new i4(znVar.y, znVar.n3, znVar.v(), znVar.zn(), j2, j4, znVar.y()), znVar.zn, iOException, true);
        this.f4456c.zn(znVar.y);
        l(iOException);
        return ta.f10108a;
    }

    public void qk(p71.zn<Long> znVar, long j2, long j4) {
        i4 i4Var = new i4(znVar.y, znVar.n3, znVar.v(), znVar.zn(), j2, j4, znVar.y());
        this.f4456c.zn(znVar.y);
        this.f4459d.z(i4Var, znVar.zn);
        gq(((Long) znVar.gv()).longValue() - j2);
    }

    @Override // af.mg
    public void u(d0 d0Var) {
        com.google.android.exoplayer2.source.dash.n3 n3Var = (com.google.android.exoplayer2.source.dash.n3) d0Var;
        n3Var.ej();
        this.f4469j5.remove(n3Var.y);
    }

    @Override // af.mg
    public void ut() throws IOException {
        this.f4477oz.n3();
    }

    public void vp(boolean z2) {
        boolean z3;
        i9 i9Var;
        long j2;
        long j4;
        o0.fb fbVar;
        boolean z4;
        for (int i = 0; i < this.f4469j5.size(); i++) {
            int keyAt = this.f4469j5.keyAt(i);
            if (keyAt >= this.f4474nf) {
                this.f4469j5.valueAt(i).b(this.f4486xg, keyAt - this.f4474nf);
            }
        }
        i9 gv2 = this.f4486xg.gv(0);
        int v2 = this.f4486xg.v() - 1;
        i9 gv3 = this.f4486xg.gv(v2);
        long fb2 = this.f4486xg.fb(v2);
        long xb2 = j5.xb(j5.y5(this.f4482rs));
        long u02 = u0(gv2, this.f4486xg.fb(0), xb2);
        long g2 = g(gv3, fb2, xb2);
        if (this.f4486xg.f7423gv && !pz(gv3)) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (z3) {
            long j6 = this.f4486xg.f7419a;
            if (j6 != -9223372036854775807L) {
                u02 = Math.max(u02, g2 - j5.xb(j6));
            }
        }
        long j7 = g2 - u02;
        dq.zn znVar = this.f4486xg;
        if (znVar.f7423gv) {
            if (znVar.y != -9223372036854775807L) {
                z4 = true;
            } else {
                z4 = false;
            }
            v5.y.fb(z4);
            long xb3 = (xb2 - j5.xb(this.f4486xg.y)) - u02;
            le(xb3, j7);
            long gf = this.f4486xg.y + j5.gf(u02);
            long xb4 = xb3 - j5.xb(this.f4470jz.y);
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
        dq.zn znVar2 = this.f4486xg;
        long j8 = znVar2.y;
        long j9 = this.f4482rs;
        int i5 = this.f4474nf;
        o0 o0Var = this.f4478p;
        if (znVar2.f7423gv) {
            fbVar = this.f4470jz;
        } else {
            fbVar = null;
        }
        s8(new n3(j8, j2, j9, i5, xb5, j7, j4, znVar2, o0Var, fbVar));
        if (!this.f4457co) {
            this.f4464en.removeCallbacks(this.f4475o);
            if (z3) {
                this.f4464en.postDelayed(this.f4475o, bk(this.f4486xg, j5.y5(this.f4482rs)));
            }
            if (this.f4461dm) {
                mp();
            } else if (z2) {
                dq.zn znVar3 = this.f4486xg;
                if (znVar3.f7423gv) {
                    long j10 = znVar3.f7429v;
                    if (j10 != -9223372036854775807L) {
                        if (j10 == 0) {
                            j10 = 5000;
                        }
                        x5(Math.max(0L, (this.f4458ct + j10) - SystemClock.elapsedRealtime()));
                    }
                }
            }
        }
    }

    public final void w2(mt mtVar, zn.y<Long> yVar) {
        q5(new p71.zn(this.f4484ut, Uri.parse(mtVar.f7368n3), 5, yVar), new s(this, null), 1);
    }

    public void wf(p71.zn<?> znVar, long j2, long j4) {
        i4 i4Var = new i4(znVar.y, znVar.n3, znVar.v(), znVar.zn(), j2, j4, znVar.y());
        this.f4456c.zn(znVar.y);
        this.f4459d.p(i4Var, znVar.zn);
    }

    public void xb() {
        this.f4464en.removeCallbacks(this.f4475o);
        mp();
    }
}
