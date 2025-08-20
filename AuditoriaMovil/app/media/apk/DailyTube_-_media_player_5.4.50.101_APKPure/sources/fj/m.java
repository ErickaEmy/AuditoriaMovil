package fj;

import androidx.annotation.Nullable;
import fj.zn;
import java.util.Collections;
import java.util.List;
/* loaded from: classes.dex */
public final class m {

    /* renamed from: vl  reason: collision with root package name */
    public static final m f8028vl = co(new m[0]);

    /* renamed from: a  reason: collision with root package name */
    public final int f8029a;

    /* renamed from: a8  reason: collision with root package name */
    public final int f8030a8;

    /* renamed from: b  reason: collision with root package name */
    public final List<y> f8031b;

    /* renamed from: c  reason: collision with root package name */
    public final int f8032c;

    /* renamed from: c5  reason: collision with root package name */
    public final long f8033c5;

    /* renamed from: co  reason: collision with root package name */
    public final long f8034co;

    /* renamed from: d  reason: collision with root package name */
    public final long f8035d;

    /* renamed from: d0  reason: collision with root package name */
    public final int f8036d0;

    /* renamed from: ej  reason: collision with root package name */
    public final long f8037ej;

    /* renamed from: f  reason: collision with root package name */
    public final int f8038f;

    /* renamed from: f3  reason: collision with root package name */
    public final long f8039f3;

    /* renamed from: fb  reason: collision with root package name */
    public final int f8040fb;

    /* renamed from: fh  reason: collision with root package name */
    public final long f8041fh;

    /* renamed from: gv  reason: collision with root package name */
    public final long f8042gv;

    /* renamed from: i4  reason: collision with root package name */
    public final long f8043i4;

    /* renamed from: i9  reason: collision with root package name */
    public final int f8044i9;

    /* renamed from: k5  reason: collision with root package name */
    public final List<y> f8045k5;

    /* renamed from: mg  reason: collision with root package name */
    public final long f8046mg;

    /* renamed from: mt  reason: collision with root package name */
    public final List<n3> f8047mt;

    /* renamed from: n  reason: collision with root package name */
    public final int f8048n;

    /* renamed from: n3  reason: collision with root package name */
    public final List<zn> f8049n3;

    /* renamed from: p  reason: collision with root package name */
    public final List<n3> f8050p;

    /* renamed from: r  reason: collision with root package name */
    public final long f8051r;

    /* renamed from: rz  reason: collision with root package name */
    public final int f8052rz;

    /* renamed from: s  reason: collision with root package name */
    public final int f8053s;

    /* renamed from: t  reason: collision with root package name */
    public final int f8054t;

    /* renamed from: ta  reason: collision with root package name */
    public final long f8055ta;

    /* renamed from: tl  reason: collision with root package name */
    public final int f8056tl;

    /* renamed from: ud  reason: collision with root package name */
    public final int f8057ud;

    /* renamed from: v  reason: collision with root package name */
    public final int f8058v;

    /* renamed from: w  reason: collision with root package name */
    public final int f8059w;

    /* renamed from: wz  reason: collision with root package name */
    public final int f8060wz;

    /* renamed from: x  reason: collision with root package name */
    public final int f8061x;

    /* renamed from: x4  reason: collision with root package name */
    public final long f8062x4;

    /* renamed from: xc  reason: collision with root package name */
    public final long f8063xc;
    public final int y;

    /* renamed from: yt  reason: collision with root package name */
    public final long[] f8064yt;

    /* renamed from: z  reason: collision with root package name */
    public final long f8065z;

    /* renamed from: z6  reason: collision with root package name */
    public final long f8066z6;

    /* renamed from: zn  reason: collision with root package name */
    public final List<long[]> f8067zn;

    /* loaded from: classes.dex */
    public static final class n3 {
        @Nullable

        /* renamed from: n3  reason: collision with root package name */
        public final m1.m f8068n3;
        public final zn.y y;

        public n3(zn.y yVar, @Nullable m1.m mVar) {
            this.y = yVar;
            this.f8068n3 = mVar;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || n3.class != obj.getClass()) {
                return false;
            }
            n3 n3Var = (n3) obj;
            if (!this.y.equals(n3Var.y)) {
                return false;
            }
            m1.m mVar = this.f8068n3;
            m1.m mVar2 = n3Var.f8068n3;
            if (mVar != null) {
                return mVar.equals(mVar2);
            }
            if (mVar2 == null) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int i;
            int hashCode = this.y.hashCode() * 31;
            m1.m mVar = this.f8068n3;
            if (mVar != null) {
                i = mVar.hashCode();
            } else {
                i = 0;
            }
            return hashCode + i;
        }
    }

    /* loaded from: classes.dex */
    public static final class y {

        /* renamed from: n3  reason: collision with root package name */
        public final Exception f8069n3;
        public final zn.y y;

        public y(zn.y yVar, Exception exc) {
            this.y = yVar;
            this.f8069n3 = exc;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || y.class != obj.getClass()) {
                return false;
            }
            y yVar = (y) obj;
            if (!this.y.equals(yVar.y)) {
                return false;
            }
            return this.f8069n3.equals(yVar.f8069n3);
        }

        public int hashCode() {
            return (this.y.hashCode() * 31) + this.f8069n3.hashCode();
        }
    }

    /* loaded from: classes.dex */
    public static final class zn {

        /* renamed from: n3  reason: collision with root package name */
        public final int f8070n3;
        public final zn.y y;

        public zn(zn.y yVar, int i) {
            this.y = yVar;
            this.f8070n3 = i;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || zn.class != obj.getClass()) {
                return false;
            }
            zn znVar = (zn) obj;
            if (this.f8070n3 != znVar.f8070n3) {
                return false;
            }
            return this.y.equals(znVar.y);
        }

        public int hashCode() {
            return (this.y.hashCode() * 31) + this.f8070n3;
        }
    }

    public m(int i, long[] jArr, List<zn> list, List<long[]> list2, long j2, int i5, int i6, int i8, int i10, long j4, int i11, int i12, int i13, int i14, int i15, long j6, int i16, List<n3> list3, List<n3> list4, long j7, long j8, long j9, long j10, long j11, long j12, int i17, int i18, int i19, long j13, int i20, long j14, long j15, long j16, long j17, long j18, int i21, int i22, int i23, List<y> list5, List<y> list6) {
        this.y = i;
        this.f8064yt = jArr;
        this.f8049n3 = Collections.unmodifiableList(list);
        this.f8067zn = Collections.unmodifiableList(list2);
        this.f8042gv = j2;
        this.f8058v = i5;
        this.f8029a = i6;
        this.f8040fb = i8;
        this.f8053s = i10;
        this.f8033c5 = j4;
        this.f8044i9 = i11;
        this.f8038f = i12;
        this.f8054t = i13;
        this.f8056tl = i14;
        this.f8060wz = i15;
        this.f8063xc = j6;
        this.f8059w = i16;
        this.f8050p = Collections.unmodifiableList(list3);
        this.f8047mt = Collections.unmodifiableList(list4);
        this.f8034co = j7;
        this.f8065z = j8;
        this.f8051r = j9;
        this.f8062x4 = j10;
        this.f8043i4 = j11;
        this.f8039f3 = j12;
        this.f8048n = i17;
        this.f8032c = i18;
        this.f8036d0 = i19;
        this.f8041fh = j13;
        this.f8052rz = i20;
        this.f8046mg = j14;
        this.f8055ta = j15;
        this.f8035d = j16;
        this.f8066z6 = j17;
        this.f8037ej = j18;
        this.f8057ud = i21;
        this.f8030a8 = i22;
        this.f8061x = i23;
        this.f8031b = Collections.unmodifiableList(list5);
        this.f8045k5 = Collections.unmodifiableList(list6);
    }

    public static m co(m... mVarArr) {
        int i;
        int i5 = 16;
        long[] jArr = new long[16];
        int length = mVarArr.length;
        long j2 = 0;
        long j4 = 0;
        long j6 = 0;
        long j7 = 0;
        long j8 = 0;
        long j9 = 0;
        long j10 = 0;
        long j11 = 0;
        long j12 = 0;
        long j13 = 0;
        int i6 = 0;
        int i8 = 0;
        int i10 = -1;
        long j14 = -9223372036854775807L;
        long j15 = -9223372036854775807L;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        long j16 = -9223372036854775807L;
        int i15 = 0;
        int i16 = 0;
        int i17 = 0;
        int i18 = 0;
        int i19 = 0;
        int i20 = 0;
        int i21 = 0;
        int i22 = 0;
        long j17 = -1;
        int i23 = 0;
        long j18 = -1;
        int i24 = 0;
        int i25 = 0;
        int i26 = 0;
        while (i6 < length) {
            m mVar = mVarArr[i6];
            i8 += mVar.y;
            for (int i27 = 0; i27 < i5; i27++) {
                jArr[i27] = jArr[i27] + mVar.f8064yt[i27];
            }
            if (j15 == -9223372036854775807L) {
                j15 = mVar.f8042gv;
                i = length;
            } else {
                i = length;
                long j19 = mVar.f8042gv;
                if (j19 != -9223372036854775807L) {
                    j15 = Math.min(j15, j19);
                }
            }
            i11 += mVar.f8058v;
            i12 += mVar.f8029a;
            i13 += mVar.f8040fb;
            i14 += mVar.f8053s;
            if (j16 == -9223372036854775807L) {
                j16 = mVar.f8033c5;
            } else {
                long j20 = mVar.f8033c5;
                if (j20 != -9223372036854775807L) {
                    j16 += j20;
                }
            }
            i15 += mVar.f8044i9;
            i16 += mVar.f8038f;
            i17 += mVar.f8054t;
            i18 += mVar.f8056tl;
            i19 += mVar.f8060wz;
            if (j14 == -9223372036854775807L) {
                j14 = mVar.f8063xc;
            } else {
                long j21 = mVar.f8063xc;
                if (j21 != -9223372036854775807L) {
                    j14 = Math.max(j14, j21);
                }
            }
            i20 += mVar.f8059w;
            j2 += mVar.f8034co;
            j4 += mVar.f8065z;
            j6 += mVar.f8051r;
            j7 += mVar.f8062x4;
            j8 += mVar.f8043i4;
            j9 += mVar.f8039f3;
            i21 += mVar.f8048n;
            i22 += mVar.f8032c;
            if (i10 == -1) {
                i10 = mVar.f8036d0;
            } else {
                int i28 = mVar.f8036d0;
                if (i28 != -1) {
                    i10 += i28;
                }
            }
            if (j17 == -1) {
                j17 = mVar.f8041fh;
            } else {
                long j22 = mVar.f8041fh;
                if (j22 != -1) {
                    j17 += j22;
                }
            }
            i23 += mVar.f8052rz;
            if (j18 == -1) {
                j18 = mVar.f8046mg;
            } else {
                long j23 = mVar.f8046mg;
                if (j23 != -1) {
                    j18 += j23;
                }
            }
            j10 += mVar.f8055ta;
            j11 += mVar.f8035d;
            j12 += mVar.f8066z6;
            j13 += mVar.f8037ej;
            i24 += mVar.f8057ud;
            i25 += mVar.f8030a8;
            i26 += mVar.f8061x;
            i6++;
            length = i;
            i5 = 16;
        }
        return new m(i8, jArr, Collections.emptyList(), Collections.emptyList(), j15, i11, i12, i13, i14, j16, i15, i16, i17, i18, i19, j14, i20, Collections.emptyList(), Collections.emptyList(), j2, j4, j6, j7, j8, j9, i21, i22, i10, j17, i23, j18, j10, j11, j12, j13, i24, i25, i26, Collections.emptyList(), Collections.emptyList());
    }

    public int a() {
        long j2 = this.f8055ta;
        if (j2 == 0) {
            return -1;
        }
        return (int) ((this.f8035d * 8000) / j2);
    }

    public int c5() {
        int i = this.f8048n;
        if (i == 0) {
            return -1;
        }
        return this.f8036d0 / i;
    }

    public int f() {
        long j2 = this.f8034co;
        if (j2 == 0) {
            return -1;
        }
        return (int) (this.f8065z / j2);
    }

    public int fb() {
        int i = this.f8052rz;
        if (i == 0) {
            return -1;
        }
        return (int) (this.f8046mg / i);
    }

    public float gv() {
        int i = this.f8058v;
        if (i == 0) {
            return 0.0f;
        }
        return this.f8040fb / i;
    }

    public int i9() {
        long j2 = this.f8051r;
        if (j2 == 0) {
            return -1;
        }
        return (int) (this.f8062x4 / j2);
    }

    public long mt() {
        return t(2) + t(6) + t(5);
    }

    public float n3() {
        long w4 = w();
        if (w4 == 0) {
            return 0.0f;
        }
        return (((float) this.f8037ej) * 1000.0f) / ((float) w4);
    }

    public long p() {
        return t(6);
    }

    public int s() {
        int i = this.f8032c;
        if (i == 0) {
            return -1;
        }
        return (int) (this.f8041fh / i);
    }

    public long t(int i) {
        return this.f8064yt[i];
    }

    public float tl() {
        long w4 = w();
        if (w4 == 0) {
            return 0.0f;
        }
        return (this.f8060wz * 1000.0f) / ((float) w4);
    }

    public int v() {
        long j2 = this.f8043i4;
        if (j2 == 0) {
            return -1;
        }
        return (int) (this.f8039f3 / j2);
    }

    public long w() {
        return t(3);
    }

    public float wz() {
        long xc2 = xc();
        if (xc2 == 0) {
            return 0.0f;
        }
        return ((float) p()) / ((float) xc2);
    }

    public long xc() {
        return w() + mt();
    }

    public float y() {
        int i = this.f8029a;
        int i5 = this.y;
        int i6 = this.f8058v;
        int i8 = i - (i5 - i6);
        if (i6 == 0) {
            return 0.0f;
        }
        return i8 / i6;
    }

    public float zn() {
        long w4 = w();
        if (w4 == 0) {
            return 0.0f;
        }
        return (((float) this.f8066z6) * 1000.0f) / ((float) w4);
    }
}
