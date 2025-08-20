package dq;

import androidx.annotation.Nullable;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.List;
import m1.m;
import v5.j5;
/* loaded from: classes.dex */
public abstract class wz {

    /* renamed from: n3  reason: collision with root package name */
    public final long f7395n3;
    @Nullable
    public final t y;

    /* renamed from: zn  reason: collision with root package name */
    public final long f7396zn;

    /* loaded from: classes.dex */
    public static final class gv {

        /* renamed from: n3  reason: collision with root package name */
        public final long f7397n3;
        public final long y;

        public gv(long j2, long j4) {
            this.y = j2;
            this.f7397n3 = j4;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || gv.class != obj.getClass()) {
                return false;
            }
            gv gvVar = (gv) obj;
            if (this.y == gvVar.y && this.f7397n3 == gvVar.f7397n3) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (((int) this.y) * 31) + ((int) this.f7397n3);
        }
    }

    /* loaded from: classes.dex */
    public static final class n3 extends y {
        @Nullable

        /* renamed from: i9  reason: collision with root package name */
        public final List<t> f7398i9;

        public n3(t tVar, long j2, long j4, long j6, long j7, @Nullable List<gv> list, long j8, @Nullable List<t> list2, long j9, long j10) {
            super(tVar, j2, j4, j6, j7, list, j8, j9, j10);
            this.f7398i9 = list2;
        }

        @Override // dq.wz.y
        public t f(tl tlVar, long j2) {
            return this.f7398i9.get((int) (j2 - this.f7404gv));
        }

        @Override // dq.wz.y
        public long fb(long j2) {
            return this.f7398i9.size();
        }

        @Override // dq.wz.y
        public boolean t() {
            return true;
        }
    }

    /* loaded from: classes.dex */
    public static abstract class y extends wz {
        @Nullable

        /* renamed from: a  reason: collision with root package name */
        public final List<gv> f7401a;

        /* renamed from: c5  reason: collision with root package name */
        public final long f7402c5;

        /* renamed from: fb  reason: collision with root package name */
        public final long f7403fb;

        /* renamed from: gv  reason: collision with root package name */
        public final long f7404gv;

        /* renamed from: s  reason: collision with root package name */
        public final long f7405s;

        /* renamed from: v  reason: collision with root package name */
        public final long f7406v;

        public y(@Nullable t tVar, long j2, long j4, long j6, long j7, @Nullable List<gv> list, long j8, long j9, long j10) {
            super(tVar, j2, j4);
            this.f7404gv = j6;
            this.f7406v = j7;
            this.f7401a = list;
            this.f7402c5 = j8;
            this.f7403fb = j9;
            this.f7405s = j10;
        }

        public long a(long j2, long j4) {
            if (this.f7401a != null) {
                return -9223372036854775807L;
            }
            long gv2 = gv(j2, j4) + zn(j2, j4);
            return (i9(gv2) + s(gv2, j2)) - this.f7402c5;
        }

        public long c5(long j2, long j4) {
            long v2 = v();
            long fb2 = fb(j4);
            if (fb2 == 0) {
                return v2;
            }
            if (this.f7401a == null) {
                long j6 = this.f7404gv + (j2 / ((this.f7406v * 1000000) / this.f7395n3));
                if (j6 >= v2) {
                    if (fb2 == -1) {
                        return j6;
                    }
                    return Math.min(j6, (v2 + fb2) - 1);
                }
                return v2;
            }
            long j7 = (fb2 + v2) - 1;
            long j8 = v2;
            while (j8 <= j7) {
                long j9 = ((j7 - j8) / 2) + j8;
                int i = (i9(j9) > j2 ? 1 : (i9(j9) == j2 ? 0 : -1));
                if (i < 0) {
                    j8 = j9 + 1;
                } else if (i > 0) {
                    j7 = j9 - 1;
                } else {
                    return j9;
                }
            }
            if (j8 == v2) {
                return j8;
            }
            return j7;
        }

        public abstract t f(tl tlVar, long j2);

        public abstract long fb(long j2);

        public long gv(long j2, long j4) {
            if (fb(j2) == -1) {
                long j6 = this.f7403fb;
                if (j6 != -9223372036854775807L) {
                    return Math.max(v(), c5((j4 - this.f7405s) - j6, j2));
                }
            }
            return v();
        }

        public final long i9(long j2) {
            long j4;
            List<gv> list = this.f7401a;
            if (list != null) {
                j4 = list.get((int) (j2 - this.f7404gv)).y - this.f7396zn;
            } else {
                j4 = (j2 - this.f7404gv) * this.f7406v;
            }
            return j5.x5(j4, 1000000L, this.f7395n3);
        }

        public final long s(long j2, long j4) {
            List<gv> list = this.f7401a;
            if (list != null) {
                return (list.get((int) (j2 - this.f7404gv)).f7397n3 * 1000000) / this.f7395n3;
            }
            long fb2 = fb(j4);
            if (fb2 != -1 && j2 == (v() + fb2) - 1) {
                return j4 - i9(j2);
            }
            return (this.f7406v * 1000000) / this.f7395n3;
        }

        public boolean t() {
            if (this.f7401a != null) {
                return true;
            }
            return false;
        }

        public long v() {
            return this.f7404gv;
        }

        public long zn(long j2, long j4) {
            long fb2 = fb(j2);
            if (fb2 != -1) {
                return fb2;
            }
            return (int) (c5((j4 - this.f7405s) + this.f7402c5, j2) - gv(j2, j4));
        }
    }

    /* loaded from: classes.dex */
    public static final class zn extends y {
        @Nullable

        /* renamed from: f  reason: collision with root package name */
        public final p f7407f;
        @Nullable

        /* renamed from: i9  reason: collision with root package name */
        public final p f7408i9;

        /* renamed from: t  reason: collision with root package name */
        public final long f7409t;

        public zn(t tVar, long j2, long j4, long j6, long j7, long j8, @Nullable List<gv> list, long j9, @Nullable p pVar, @Nullable p pVar2, long j10, long j11) {
            super(tVar, j2, j4, j6, j8, list, j9, j10, j11);
            this.f7408i9 = pVar;
            this.f7407f = pVar2;
            this.f7409t = j7;
        }

        @Override // dq.wz.y
        public t f(tl tlVar, long j2) {
            long j4;
            List<gv> list = this.f7401a;
            if (list != null) {
                j4 = list.get((int) (j2 - this.f7404gv)).y;
            } else {
                j4 = (j2 - this.f7404gv) * this.f7406v;
            }
            long j6 = j4;
            p pVar = this.f7407f;
            m mVar = tlVar.f7385n3;
            return new t(pVar.y(mVar.y, j2, mVar.f10959p, j6), 0L, -1L);
        }

        @Override // dq.wz.y
        public long fb(long j2) {
            List<gv> list = this.f7401a;
            if (list != null) {
                return list.size();
            }
            long j4 = this.f7409t;
            if (j4 != -1) {
                return (j4 - this.f7404gv) + 1;
            }
            if (j2 == -9223372036854775807L) {
                return -1L;
            }
            return c1.y.y(BigInteger.valueOf(j2).multiply(BigInteger.valueOf(this.f7395n3)), BigInteger.valueOf(this.f7406v).multiply(BigInteger.valueOf(1000000L)), RoundingMode.CEILING).longValue();
        }

        @Override // dq.wz
        @Nullable
        public t y(tl tlVar) {
            p pVar = this.f7408i9;
            if (pVar != null) {
                m mVar = tlVar.f7385n3;
                return new t(pVar.y(mVar.y, 0L, mVar.f10959p, 0L), 0L, -1L);
            }
            return super.y(tlVar);
        }
    }

    public wz(@Nullable t tVar, long j2, long j4) {
        this.y = tVar;
        this.f7395n3 = j2;
        this.f7396zn = j4;
    }

    public long n3() {
        return j5.x5(this.f7396zn, 1000000L, this.f7395n3);
    }

    @Nullable
    public t y(tl tlVar) {
        return this.y;
    }

    /* loaded from: classes.dex */
    public static class v extends wz {

        /* renamed from: gv  reason: collision with root package name */
        public final long f7399gv;

        /* renamed from: v  reason: collision with root package name */
        public final long f7400v;

        public v(@Nullable t tVar, long j2, long j4, long j6, long j7) {
            super(tVar, j2, j4);
            this.f7399gv = j6;
            this.f7400v = j7;
        }

        @Nullable
        public t zn() {
            long j2 = this.f7400v;
            if (j2 <= 0) {
                return null;
            }
            return new t(null, this.f7399gv, j2);
        }

        public v() {
            this(null, 1L, 0L, 0L, 0L);
        }
    }
}
