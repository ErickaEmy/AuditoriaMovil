package nc1;

import java.util.Date;
import java.util.concurrent.TimeUnit;
import kc1.d0;
import kc1.rz;
import kc1.z;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
/* loaded from: classes.dex */
public final class zn {

    /* renamed from: zn  reason: collision with root package name */
    public static final y f11902zn = new y(null);

    /* renamed from: n3  reason: collision with root package name */
    public final rz f11903n3;
    public final d0 y;

    /* loaded from: classes.dex */
    public static final class n3 {

        /* renamed from: a  reason: collision with root package name */
        public long f11904a;

        /* renamed from: c5  reason: collision with root package name */
        public int f11905c5;

        /* renamed from: f  reason: collision with root package name */
        public final d0 f11906f;

        /* renamed from: fb  reason: collision with root package name */
        public long f11907fb;

        /* renamed from: gv  reason: collision with root package name */
        public String f11908gv;

        /* renamed from: i9  reason: collision with root package name */
        public final long f11909i9;

        /* renamed from: n3  reason: collision with root package name */
        public String f11910n3;

        /* renamed from: s  reason: collision with root package name */
        public String f11911s;

        /* renamed from: t  reason: collision with root package name */
        public final rz f11912t;

        /* renamed from: v  reason: collision with root package name */
        public Date f11913v;
        public Date y;

        /* renamed from: zn  reason: collision with root package name */
        public Date f11914zn;

        public n3(long j2, d0 request, rz rzVar) {
            Intrinsics.checkNotNullParameter(request, "request");
            this.f11909i9 = j2;
            this.f11906f = request;
            this.f11912t = rzVar;
            this.f11905c5 = -1;
            if (rzVar != null) {
                this.f11904a = rzVar.ap();
                this.f11907fb = rzVar.ct();
                z b2 = rzVar.b();
                int size = b2.size();
                for (int i = 0; i < size; i++) {
                    String zn2 = b2.zn(i);
                    String c52 = b2.c5(i);
                    if (StringsKt.equals(zn2, "Date", true)) {
                        this.y = qc1.zn.y(c52);
                        this.f11910n3 = c52;
                    } else if (StringsKt.equals(zn2, "Expires", true)) {
                        this.f11913v = qc1.zn.y(c52);
                    } else if (StringsKt.equals(zn2, "Last-Modified", true)) {
                        this.f11914zn = qc1.zn.y(c52);
                        this.f11908gv = c52;
                    } else if (StringsKt.equals(zn2, "ETag", true)) {
                        this.f11911s = c52;
                    } else if (StringsKt.equals(zn2, "Age", true)) {
                        this.f11905c5 = lc1.n3.j(c52, -1);
                    }
                }
            }
        }

        public final boolean a() {
            rz rzVar = this.f11912t;
            Intrinsics.checkNotNull(rzVar);
            if (rzVar.v().zn() == -1 && this.f11913v == null) {
                return true;
            }
            return false;
        }

        public final long gv() {
            long j2;
            long j4;
            rz rzVar = this.f11912t;
            Intrinsics.checkNotNull(rzVar);
            kc1.gv v2 = rzVar.v();
            if (v2.zn() != -1) {
                return TimeUnit.SECONDS.toMillis(v2.zn());
            }
            Date date = this.f11913v;
            if (date != null) {
                Date date2 = this.y;
                if (date2 != null) {
                    j4 = date2.getTime();
                } else {
                    j4 = this.f11907fb;
                }
                long time = date.getTime() - j4;
                if (time <= 0) {
                    return 0L;
                }
                return time;
            } else if (this.f11914zn == null || this.f11912t.o4().t().co() != null) {
                return 0L;
            } else {
                Date date3 = this.y;
                if (date3 != null) {
                    j2 = date3.getTime();
                } else {
                    j2 = this.f11904a;
                }
                Date date4 = this.f11914zn;
                Intrinsics.checkNotNull(date4);
                long time2 = j2 - date4.getTime();
                if (time2 <= 0) {
                    return 0L;
                }
                return time2 / 10;
            }
        }

        public final zn n3() {
            zn zn2 = zn();
            if (zn2.n3() != null && this.f11906f.n3().c5()) {
                return new zn(null, null);
            }
            return zn2;
        }

        public final boolean v(d0 d0Var) {
            if (d0Var.gv("If-Modified-Since") == null && d0Var.gv("If-None-Match") == null) {
                return false;
            }
            return true;
        }

        public final long y() {
            Date date = this.y;
            long j2 = 0;
            if (date != null) {
                j2 = Math.max(0L, this.f11907fb - date.getTime());
            }
            int i = this.f11905c5;
            if (i != -1) {
                j2 = Math.max(j2, TimeUnit.SECONDS.toMillis(i));
            }
            long j4 = this.f11907fb;
            return j2 + (j4 - this.f11904a) + (this.f11909i9 - j4);
        }

        public final zn zn() {
            long j2;
            String str;
            if (this.f11912t == null) {
                return new zn(this.f11906f, null);
            }
            if (this.f11906f.fb() && this.f11912t.r() == null) {
                return new zn(this.f11906f, null);
            }
            if (!zn.f11902zn.y(this.f11912t, this.f11906f)) {
                return new zn(this.f11906f, null);
            }
            kc1.gv n32 = this.f11906f.n3();
            if (!n32.fb() && !v(this.f11906f)) {
                kc1.gv v2 = this.f11912t.v();
                long y = y();
                long gv2 = gv();
                if (n32.zn() != -1) {
                    gv2 = Math.min(gv2, TimeUnit.SECONDS.toMillis(n32.zn()));
                }
                long j4 = 0;
                if (n32.v() != -1) {
                    j2 = TimeUnit.SECONDS.toMillis(n32.v());
                } else {
                    j2 = 0;
                }
                if (!v2.a() && n32.gv() != -1) {
                    j4 = TimeUnit.SECONDS.toMillis(n32.gv());
                }
                if (!v2.fb()) {
                    long j6 = j2 + y;
                    if (j6 < j4 + gv2) {
                        rz.y j52 = this.f11912t.j5();
                        if (j6 >= gv2) {
                            j52.y("Warning", "110 HttpURLConnection \"Response is stale\"");
                        }
                        if (y > 86400000 && a()) {
                            j52.y("Warning", "113 HttpURLConnection \"Heuristic expiration\"");
                        }
                        return new zn(null, j52.zn());
                    }
                }
                String str2 = this.f11911s;
                if (str2 != null) {
                    str = "If-None-Match";
                } else {
                    if (this.f11914zn != null) {
                        str2 = this.f11908gv;
                    } else if (this.y != null) {
                        str2 = this.f11910n3;
                    } else {
                        return new zn(this.f11906f, null);
                    }
                    str = "If-Modified-Since";
                }
                z.y v3 = this.f11906f.a().v();
                Intrinsics.checkNotNull(str2);
                v3.gv(str, str2);
                return new zn(this.f11906f.c5().s(v3.a()).n3(), this.f11912t);
            }
            return new zn(this.f11906f, null);
        }
    }

    /* loaded from: classes.dex */
    public static final class y {
        public y() {
        }

        public final boolean y(rz response, d0 request) {
            Intrinsics.checkNotNullParameter(response, "response");
            Intrinsics.checkNotNullParameter(request, "request");
            int mt2 = response.mt();
            if (mt2 != 200 && mt2 != 410 && mt2 != 414 && mt2 != 501 && mt2 != 203 && mt2 != 204) {
                if (mt2 != 307) {
                    if (mt2 != 308 && mt2 != 404 && mt2 != 405) {
                        switch (mt2) {
                            case 300:
                            case 301:
                                break;
                            case 302:
                                break;
                            default:
                                return false;
                        }
                    }
                }
                if (rz.d(response, "Expires", null, 2, null) == null && response.v().zn() == -1 && !response.v().n3() && !response.v().y()) {
                    return false;
                }
            }
            if (response.v().s() || request.n3().s()) {
                return false;
            }
            return true;
        }

        public /* synthetic */ y(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public zn(d0 d0Var, rz rzVar) {
        this.y = d0Var;
        this.f11903n3 = rzVar;
    }

    public final d0 n3() {
        return this.y;
    }

    public final rz y() {
        return this.f11903n3;
    }
}
