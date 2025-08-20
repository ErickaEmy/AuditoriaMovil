package m1;

import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Pair;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import je.zn;
import m1.hy;
import m1.o0;
import m1.s;
import z0.x4;
/* loaded from: classes.dex */
public abstract class hy implements s {
    public static final hy y = new y();

    /* renamed from: v  reason: collision with root package name */
    public static final String f10787v = v5.j5.g3(0);

    /* renamed from: fb  reason: collision with root package name */
    public static final String f10785fb = v5.j5.g3(1);

    /* renamed from: s  reason: collision with root package name */
    public static final String f10786s = v5.j5.g3(2);

    /* renamed from: f  reason: collision with root package name */
    public static final s.y<hy> f10784f = new s.y() { // from class: m1.vh
        @Override // m1.s.y
        public final s fromBundle(Bundle bundle) {
            hy n32;
            n32 = hy.n3(bundle);
            return n32;
        }
    };

    /* loaded from: classes.dex */
    public static final class gv implements s {

        /* renamed from: c  reason: collision with root package name */
        public long f10805c;

        /* renamed from: co  reason: collision with root package name */
        public boolean f10806co;

        /* renamed from: d  reason: collision with root package name */
        public long f10807d;

        /* renamed from: d0  reason: collision with root package name */
        public int f10808d0;

        /* renamed from: f  reason: collision with root package name */
        public long f10809f;

        /* renamed from: f3  reason: collision with root package name */
        public boolean f10810f3;

        /* renamed from: fh  reason: collision with root package name */
        public int f10812fh;

        /* renamed from: n  reason: collision with root package name */
        public long f10813n;

        /* renamed from: p  reason: collision with root package name */
        public boolean f10814p;
        @Nullable

        /* renamed from: r  reason: collision with root package name */
        public o0.fb f10815r;
        @Nullable

        /* renamed from: s  reason: collision with root package name */
        public Object f10816s;

        /* renamed from: t  reason: collision with root package name */
        public long f10817t;
        @Nullable
        @Deprecated

        /* renamed from: v  reason: collision with root package name */
        public Object f10818v;

        /* renamed from: w  reason: collision with root package name */
        public long f10819w;
        @Deprecated

        /* renamed from: z  reason: collision with root package name */
        public boolean f10820z;

        /* renamed from: ej  reason: collision with root package name */
        public static final Object f10789ej = new Object();

        /* renamed from: x  reason: collision with root package name */
        public static final Object f10802x = new Object();

        /* renamed from: b  reason: collision with root package name */
        public static final o0 f10788b = new o0.zn().gv("com.google.android.exoplayer2.Timeline").s(Uri.EMPTY).y();

        /* renamed from: j5  reason: collision with root package name */
        public static final String f10793j5 = v5.j5.g3(1);

        /* renamed from: qn  reason: collision with root package name */
        public static final String f10799qn = v5.j5.g3(2);

        /* renamed from: o  reason: collision with root package name */
        public static final String f10796o = v5.j5.g3(3);

        /* renamed from: j  reason: collision with root package name */
        public static final String f10792j = v5.j5.g3(4);

        /* renamed from: oz  reason: collision with root package name */
        public static final String f10797oz = v5.j5.g3(5);

        /* renamed from: ut  reason: collision with root package name */
        public static final String f10801ut = v5.j5.g3(6);

        /* renamed from: q9  reason: collision with root package name */
        public static final String f10798q9 = v5.j5.g3(7);

        /* renamed from: k  reason: collision with root package name */
        public static final String f10795k = v5.j5.g3(8);

        /* renamed from: f7  reason: collision with root package name */
        public static final String f10791f7 = v5.j5.g3(9);

        /* renamed from: en  reason: collision with root package name */
        public static final String f10790en = v5.j5.g3(10);

        /* renamed from: jz  reason: collision with root package name */
        public static final String f10794jz = v5.j5.g3(11);

        /* renamed from: u  reason: collision with root package name */
        public static final String f10800u = v5.j5.g3(12);

        /* renamed from: y5  reason: collision with root package name */
        public static final String f10804y5 = v5.j5.g3(13);

        /* renamed from: xg  reason: collision with root package name */
        public static final s.y<gv> f10803xg = new s.y() { // from class: m1.jt
            @Override // m1.s.y
            public final s fromBundle(Bundle bundle) {
                hy.gv n32;
                n32 = hy.gv.n3(bundle);
                return n32;
            }
        };
        public Object y = f10789ej;

        /* renamed from: fb  reason: collision with root package name */
        public o0 f10811fb = f10788b;

        public static gv n3(Bundle bundle) {
            o0 o0Var;
            o0.fb fbVar;
            Bundle bundle2 = bundle.getBundle(f10793j5);
            if (bundle2 != null) {
                o0Var = o0.f11012d0.fromBundle(bundle2);
            } else {
                o0Var = o0.f11011co;
            }
            o0 o0Var2 = o0Var;
            long j2 = bundle.getLong(f10799qn, -9223372036854775807L);
            long j4 = bundle.getLong(f10796o, -9223372036854775807L);
            long j6 = bundle.getLong(f10792j, -9223372036854775807L);
            boolean z2 = bundle.getBoolean(f10797oz, false);
            boolean z3 = bundle.getBoolean(f10801ut, false);
            Bundle bundle3 = bundle.getBundle(f10798q9);
            if (bundle3 != null) {
                fbVar = o0.fb.f11042f3.fromBundle(bundle3);
            } else {
                fbVar = null;
            }
            o0.fb fbVar2 = fbVar;
            boolean z4 = bundle.getBoolean(f10795k, false);
            long j7 = bundle.getLong(f10791f7, 0L);
            long j8 = bundle.getLong(f10790en, -9223372036854775807L);
            int i = bundle.getInt(f10794jz, 0);
            int i5 = bundle.getInt(f10800u, 0);
            long j9 = bundle.getLong(f10804y5, 0L);
            gv gvVar = new gv();
            gvVar.c5(f10802x, o0Var2, null, j2, j4, j6, z2, z3, fbVar2, j7, j8, i, i5, j9);
            gvVar.f10810f3 = z4;
            return gvVar;
        }

        public long a() {
            return v5.j5.gf(this.f10805c);
        }

        public gv c5(Object obj, @Nullable o0 o0Var, @Nullable Object obj2, long j2, long j4, long j6, boolean z2, boolean z3, @Nullable o0.fb fbVar, long j7, long j8, int i, int i5, long j9) {
            o0 o0Var2;
            Object obj3;
            boolean z4;
            o0.s sVar;
            this.y = obj;
            if (o0Var != null) {
                o0Var2 = o0Var;
            } else {
                o0Var2 = f10788b;
            }
            this.f10811fb = o0Var2;
            if (o0Var != null && (sVar = o0Var.f11022v) != null) {
                obj3 = sVar.f11084s;
            } else {
                obj3 = null;
            }
            this.f10818v = obj3;
            this.f10816s = obj2;
            this.f10809f = j2;
            this.f10817t = j4;
            this.f10819w = j6;
            this.f10814p = z2;
            this.f10806co = z3;
            if (fbVar != null) {
                z4 = true;
            } else {
                z4 = false;
            }
            this.f10820z = z4;
            this.f10815r = fbVar;
            this.f10813n = j7;
            this.f10805c = j8;
            this.f10808d0 = i;
            this.f10812fh = i5;
            this.f10807d = j9;
            this.f10810f3 = false;
            return this;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || !gv.class.equals(obj.getClass())) {
                return false;
            }
            gv gvVar = (gv) obj;
            if (v5.j5.zn(this.y, gvVar.y) && v5.j5.zn(this.f10811fb, gvVar.f10811fb) && v5.j5.zn(this.f10816s, gvVar.f10816s) && v5.j5.zn(this.f10815r, gvVar.f10815r) && this.f10809f == gvVar.f10809f && this.f10817t == gvVar.f10817t && this.f10819w == gvVar.f10819w && this.f10814p == gvVar.f10814p && this.f10806co == gvVar.f10806co && this.f10810f3 == gvVar.f10810f3 && this.f10813n == gvVar.f10813n && this.f10805c == gvVar.f10805c && this.f10808d0 == gvVar.f10808d0 && this.f10812fh == gvVar.f10812fh && this.f10807d == gvVar.f10807d) {
                return true;
            }
            return false;
        }

        public long fb() {
            return this.f10807d;
        }

        public long gv() {
            return v5.j5.gf(this.f10813n);
        }

        public int hashCode() {
            int hashCode;
            int hashCode2 = (((217 + this.y.hashCode()) * 31) + this.f10811fb.hashCode()) * 31;
            Object obj = this.f10816s;
            int i = 0;
            if (obj == null) {
                hashCode = 0;
            } else {
                hashCode = obj.hashCode();
            }
            int i5 = (hashCode2 + hashCode) * 31;
            o0.fb fbVar = this.f10815r;
            if (fbVar != null) {
                i = fbVar.hashCode();
            }
            long j2 = this.f10809f;
            long j4 = this.f10817t;
            long j6 = this.f10819w;
            long j7 = this.f10813n;
            long j8 = this.f10805c;
            long j9 = this.f10807d;
            return ((((((((((((((((((((((i5 + i) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31) + ((int) (j4 ^ (j4 >>> 32)))) * 31) + ((int) (j6 ^ (j6 >>> 32)))) * 31) + (this.f10814p ? 1 : 0)) * 31) + (this.f10806co ? 1 : 0)) * 31) + (this.f10810f3 ? 1 : 0)) * 31) + ((int) (j7 ^ (j7 >>> 32)))) * 31) + ((int) (j8 ^ (j8 >>> 32)))) * 31) + this.f10808d0) * 31) + this.f10812fh) * 31) + ((int) (j9 ^ (j9 >>> 32)));
        }

        public boolean s() {
            boolean z2;
            boolean z3;
            boolean z4 = this.f10820z;
            if (this.f10815r != null) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z4 == z2) {
                z3 = true;
            } else {
                z3 = false;
            }
            v5.y.fb(z3);
            if (this.f10815r == null) {
                return false;
            }
            return true;
        }

        @Override // m1.s
        public Bundle toBundle() {
            Bundle bundle = new Bundle();
            if (!o0.f11011co.equals(this.f10811fb)) {
                bundle.putBundle(f10793j5, this.f10811fb.toBundle());
            }
            long j2 = this.f10809f;
            if (j2 != -9223372036854775807L) {
                bundle.putLong(f10799qn, j2);
            }
            long j4 = this.f10817t;
            if (j4 != -9223372036854775807L) {
                bundle.putLong(f10796o, j4);
            }
            long j6 = this.f10819w;
            if (j6 != -9223372036854775807L) {
                bundle.putLong(f10792j, j6);
            }
            boolean z2 = this.f10814p;
            if (z2) {
                bundle.putBoolean(f10797oz, z2);
            }
            boolean z3 = this.f10806co;
            if (z3) {
                bundle.putBoolean(f10801ut, z3);
            }
            o0.fb fbVar = this.f10815r;
            if (fbVar != null) {
                bundle.putBundle(f10798q9, fbVar.toBundle());
            }
            boolean z4 = this.f10810f3;
            if (z4) {
                bundle.putBoolean(f10795k, z4);
            }
            long j7 = this.f10813n;
            if (j7 != 0) {
                bundle.putLong(f10791f7, j7);
            }
            long j8 = this.f10805c;
            if (j8 != -9223372036854775807L) {
                bundle.putLong(f10790en, j8);
            }
            int i = this.f10808d0;
            if (i != 0) {
                bundle.putInt(f10794jz, i);
            }
            int i5 = this.f10812fh;
            if (i5 != 0) {
                bundle.putInt(f10800u, i5);
            }
            long j9 = this.f10807d;
            if (j9 != 0) {
                bundle.putLong(f10804y5, j9);
            }
            return bundle;
        }

        public long v() {
            return this.f10813n;
        }

        public long zn() {
            return v5.j5.y5(this.f10819w);
        }
    }

    /* loaded from: classes.dex */
    public static final class n3 implements s {

        /* renamed from: f  reason: collision with root package name */
        public long f10827f;

        /* renamed from: fb  reason: collision with root package name */
        public int f10828fb;

        /* renamed from: s  reason: collision with root package name */
        public long f10829s;

        /* renamed from: t  reason: collision with root package name */
        public boolean f10830t;
        @Nullable

        /* renamed from: v  reason: collision with root package name */
        public Object f10831v;

        /* renamed from: w  reason: collision with root package name */
        public je.zn f10832w = je.zn.f9429w;
        @Nullable
        public Object y;

        /* renamed from: p  reason: collision with root package name */
        public static final String f10824p = v5.j5.g3(0);

        /* renamed from: co  reason: collision with root package name */
        public static final String f10821co = v5.j5.g3(1);

        /* renamed from: z  reason: collision with root package name */
        public static final String f10826z = v5.j5.g3(2);

        /* renamed from: r  reason: collision with root package name */
        public static final String f10825r = v5.j5.g3(3);

        /* renamed from: f3  reason: collision with root package name */
        public static final String f10822f3 = v5.j5.g3(4);

        /* renamed from: n  reason: collision with root package name */
        public static final s.y<n3> f10823n = new s.y() { // from class: m1.xq
            @Override // m1.s.y
            public final s fromBundle(Bundle bundle) {
                hy.n3 zn2;
                zn2 = hy.n3.zn(bundle);
                return zn2;
            }
        };

        public static n3 zn(Bundle bundle) {
            je.zn znVar;
            int i = bundle.getInt(f10824p, 0);
            long j2 = bundle.getLong(f10821co, -9223372036854775807L);
            long j4 = bundle.getLong(f10826z, 0L);
            boolean z2 = bundle.getBoolean(f10825r, false);
            Bundle bundle2 = bundle.getBundle(f10822f3);
            if (bundle2 != null) {
                znVar = je.zn.f9426n.fromBundle(bundle2);
            } else {
                znVar = je.zn.f9429w;
            }
            je.zn znVar2 = znVar;
            n3 n3Var = new n3();
            n3Var.x4(null, null, i, j2, j4, znVar2, z2);
            return n3Var;
        }

        public int a() {
            return this.f10832w.f9435v;
        }

        public long c5(int i) {
            return this.f10832w.zn(i).y;
        }

        public boolean co(int i) {
            return !this.f10832w.zn(i).fb();
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || !n3.class.equals(obj.getClass())) {
                return false;
            }
            n3 n3Var = (n3) obj;
            if (v5.j5.zn(this.y, n3Var.y) && v5.j5.zn(this.f10831v, n3Var.f10831v) && this.f10828fb == n3Var.f10828fb && this.f10829s == n3Var.f10829s && this.f10827f == n3Var.f10827f && this.f10830t == n3Var.f10830t && v5.j5.zn(this.f10832w, n3Var.f10832w)) {
                return true;
            }
            return false;
        }

        public int f(int i, int i5) {
            zn.y zn2 = this.f10832w.zn(i);
            if (zn2.f9450v != -1) {
                return zn2.f9445f[i5];
            }
            return 0;
        }

        public int fb(long j2) {
            return this.f10832w.gv(j2, this.f10829s);
        }

        public int gv(int i) {
            return this.f10832w.zn(i).f9450v;
        }

        public int hashCode() {
            int hashCode;
            Object obj = this.y;
            int i = 0;
            if (obj == null) {
                hashCode = 0;
            } else {
                hashCode = obj.hashCode();
            }
            int i5 = (217 + hashCode) * 31;
            Object obj2 = this.f10831v;
            if (obj2 != null) {
                i = obj2.hashCode();
            }
            long j2 = this.f10829s;
            long j4 = this.f10827f;
            return ((((((((((i5 + i) * 31) + this.f10828fb) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31) + ((int) (j4 ^ (j4 >>> 32)))) * 31) + (this.f10830t ? 1 : 0)) * 31) + this.f10832w.hashCode();
        }

        public long i9() {
            return this.f10832w.f9432fb;
        }

        public int mt() {
            return this.f10832w.f9431f;
        }

        public long p() {
            return this.f10827f;
        }

        public n3 r(@Nullable Object obj, @Nullable Object obj2, int i, long j2, long j4) {
            return x4(obj, obj2, i, j2, j4, je.zn.f9429w, false);
        }

        public int s(long j2) {
            return this.f10832w.v(j2, this.f10829s);
        }

        public long t(int i) {
            return this.f10832w.zn(i).f9451w;
        }

        public long tl() {
            return this.f10829s;
        }

        @Override // m1.s
        public Bundle toBundle() {
            Bundle bundle = new Bundle();
            int i = this.f10828fb;
            if (i != 0) {
                bundle.putInt(f10824p, i);
            }
            long j2 = this.f10829s;
            if (j2 != -9223372036854775807L) {
                bundle.putLong(f10821co, j2);
            }
            long j4 = this.f10827f;
            if (j4 != 0) {
                bundle.putLong(f10826z, j4);
            }
            boolean z2 = this.f10830t;
            if (z2) {
                bundle.putBoolean(f10825r, z2);
            }
            if (!this.f10832w.equals(je.zn.f9429w)) {
                bundle.putBundle(f10822f3, this.f10832w.toBundle());
            }
            return bundle;
        }

        public long v(int i, int i5) {
            zn.y zn2 = this.f10832w.zn(i);
            if (zn2.f9450v != -1) {
                return zn2.f9449t[i5];
            }
            return -9223372036854775807L;
        }

        public long w() {
            return v5.j5.gf(this.f10827f);
        }

        public int wz(int i) {
            return this.f10832w.zn(i).v();
        }

        public n3 x4(@Nullable Object obj, @Nullable Object obj2, int i, long j2, long j4, je.zn znVar, boolean z2) {
            this.y = obj;
            this.f10831v = obj2;
            this.f10828fb = i;
            this.f10829s = j2;
            this.f10827f = j4;
            this.f10832w = znVar;
            this.f10830t = z2;
            return this;
        }

        public int xc(int i, int i5) {
            return this.f10832w.zn(i).a(i5);
        }

        public boolean z(int i) {
            return this.f10832w.zn(i).f9447p;
        }
    }

    /* loaded from: classes.dex */
    public class y extends hy {
        @Override // m1.hy
        public int a(Object obj) {
            return -1;
        }

        @Override // m1.hy
        public gv co(int i, gv gvVar, long j2) {
            throw new IndexOutOfBoundsException();
        }

        @Override // m1.hy
        public n3 f(int i, n3 n3Var, boolean z2) {
            throw new IndexOutOfBoundsException();
        }

        @Override // m1.hy
        public Object p(int i) {
            throw new IndexOutOfBoundsException();
        }

        @Override // m1.hy
        public int tl() {
            return 0;
        }

        @Override // m1.hy
        public int z() {
            return 0;
        }
    }

    /* loaded from: classes.dex */
    public static final class zn extends hy {

        /* renamed from: co  reason: collision with root package name */
        public final int[] f10833co;

        /* renamed from: p  reason: collision with root package name */
        public final int[] f10834p;

        /* renamed from: t  reason: collision with root package name */
        public final z0.x4<gv> f10835t;

        /* renamed from: w  reason: collision with root package name */
        public final z0.x4<n3> f10836w;

        public zn(z0.x4<gv> x4Var, z0.x4<n3> x4Var2, int[] iArr) {
            boolean z2;
            if (x4Var.size() == iArr.length) {
                z2 = true;
            } else {
                z2 = false;
            }
            v5.y.y(z2);
            this.f10835t = x4Var;
            this.f10836w = x4Var2;
            this.f10834p = iArr;
            this.f10833co = new int[iArr.length];
            for (int i = 0; i < iArr.length; i++) {
                this.f10833co[iArr[i]] = i;
            }
        }

        @Override // m1.hy
        public int a(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // m1.hy
        public int c5(int i, int i5, boolean z2) {
            if (i5 == 1) {
                return i;
            }
            if (i == fb(z2)) {
                if (i5 == 2) {
                    return v(z2);
                }
                return -1;
            } else if (z2) {
                return this.f10834p[this.f10833co[i] + 1];
            } else {
                return i + 1;
            }
        }

        @Override // m1.hy
        public gv co(int i, gv gvVar, long j2) {
            gv gvVar2 = this.f10835t.get(i);
            gvVar.c5(gvVar2.y, gvVar2.f10811fb, gvVar2.f10816s, gvVar2.f10809f, gvVar2.f10817t, gvVar2.f10819w, gvVar2.f10814p, gvVar2.f10806co, gvVar2.f10815r, gvVar2.f10813n, gvVar2.f10805c, gvVar2.f10808d0, gvVar2.f10812fh, gvVar2.f10807d);
            gvVar.f10810f3 = gvVar2.f10810f3;
            return gvVar;
        }

        @Override // m1.hy
        public n3 f(int i, n3 n3Var, boolean z2) {
            n3 n3Var2 = this.f10836w.get(i);
            n3Var.x4(n3Var2.y, n3Var2.f10831v, n3Var2.f10828fb, n3Var2.f10829s, n3Var2.f10827f, n3Var2.f10832w, n3Var2.f10830t);
            return n3Var;
        }

        @Override // m1.hy
        public int fb(boolean z2) {
            if (r()) {
                return -1;
            }
            if (z2) {
                return this.f10834p[z() - 1];
            }
            return z() - 1;
        }

        @Override // m1.hy
        public Object p(int i) {
            throw new UnsupportedOperationException();
        }

        @Override // m1.hy
        public int tl() {
            return this.f10836w.size();
        }

        @Override // m1.hy
        public int v(boolean z2) {
            if (r()) {
                return -1;
            }
            if (!z2) {
                return 0;
            }
            return this.f10834p[0];
        }

        @Override // m1.hy
        public int w(int i, int i5, boolean z2) {
            if (i5 == 1) {
                return i;
            }
            if (i == v(z2)) {
                if (i5 == 2) {
                    return fb(z2);
                }
                return -1;
            } else if (z2) {
                return this.f10834p[this.f10833co[i] - 1];
            } else {
                return i - 1;
            }
        }

        @Override // m1.hy
        public int z() {
            return this.f10835t.size();
        }
    }

    public static int[] gv(int i) {
        int[] iArr = new int[i];
        for (int i5 = 0; i5 < i; i5++) {
            iArr[i5] = i5;
        }
        return iArr;
    }

    public static hy n3(Bundle bundle) {
        z0.x4 zn2 = zn(gv.f10803xg, v5.zn.y(bundle, f10787v));
        z0.x4 zn3 = zn(n3.f10823n, v5.zn.y(bundle, f10785fb));
        int[] intArray = bundle.getIntArray(f10786s);
        if (intArray == null) {
            intArray = gv(zn2.size());
        }
        return new zn(zn2, zn3, intArray);
    }

    public static <T extends s> z0.x4<T> zn(s.y<T> yVar, @Nullable IBinder iBinder) {
        if (iBinder == null) {
            return z0.x4.j5();
        }
        x4.y yVar2 = new x4.y();
        z0.x4<Bundle> y2 = fb.y(iBinder);
        for (int i = 0; i < y2.size(); i++) {
            yVar2.y(yVar.fromBundle(y2.get(i)));
        }
        return yVar2.s();
    }

    public abstract int a(Object obj);

    public int c5(int i, int i5, boolean z2) {
        if (i5 != 0) {
            if (i5 != 1) {
                if (i5 == 2) {
                    if (i == fb(z2)) {
                        return v(z2);
                    }
                    return i + 1;
                }
                throw new IllegalStateException();
            }
            return i;
        } else if (i == fb(z2)) {
            return -1;
        } else {
            return i + 1;
        }
    }

    public abstract gv co(int i, gv gvVar, long j2);

    public boolean equals(@Nullable Object obj) {
        int fb2;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof hy)) {
            return false;
        }
        hy hyVar = (hy) obj;
        if (hyVar.z() != z() || hyVar.tl() != tl()) {
            return false;
        }
        gv gvVar = new gv();
        n3 n3Var = new n3();
        gv gvVar2 = new gv();
        n3 n3Var2 = new n3();
        for (int i = 0; i < z(); i++) {
            if (!mt(i, gvVar).equals(hyVar.mt(i, gvVar2))) {
                return false;
            }
        }
        for (int i5 = 0; i5 < tl(); i5++) {
            if (!f(i5, n3Var, true).equals(hyVar.f(i5, n3Var2, true))) {
                return false;
            }
        }
        int v2 = v(true);
        if (v2 != hyVar.v(true) || (fb2 = fb(true)) != hyVar.fb(true)) {
            return false;
        }
        while (v2 != fb2) {
            int c52 = c5(v2, 0, true);
            if (c52 != hyVar.c5(v2, 0, true)) {
                return false;
            }
            v2 = c52;
        }
        return true;
    }

    public abstract n3 f(int i, n3 n3Var, boolean z2);

    public int fb(boolean z2) {
        if (r()) {
            return -1;
        }
        return z() - 1;
    }

    public int hashCode() {
        gv gvVar = new gv();
        n3 n3Var = new n3();
        int z2 = 217 + z();
        for (int i = 0; i < z(); i++) {
            z2 = (z2 * 31) + mt(i, gvVar).hashCode();
        }
        int tl2 = (z2 * 31) + tl();
        for (int i5 = 0; i5 < tl(); i5++) {
            tl2 = (tl2 * 31) + f(i5, n3Var, true).hashCode();
        }
        int v2 = v(true);
        while (v2 != -1) {
            tl2 = (tl2 * 31) + v2;
            v2 = c5(v2, 0, true);
        }
        return tl2;
    }

    public final n3 i9(int i, n3 n3Var) {
        return f(i, n3Var, false);
    }

    public final gv mt(int i, gv gvVar) {
        return co(i, gvVar, 0L);
    }

    public abstract Object p(int i);

    public final boolean r() {
        if (z() == 0) {
            return true;
        }
        return false;
    }

    public final int s(int i, n3 n3Var, gv gvVar, int i5, boolean z2) {
        int i6 = i9(i, n3Var).f10828fb;
        if (mt(i6, gvVar).f10812fh == i) {
            int c52 = c5(i6, i5, z2);
            if (c52 == -1) {
                return -1;
            }
            return mt(c52, gvVar).f10808d0;
        }
        return i + 1;
    }

    public n3 t(Object obj, n3 n3Var) {
        return f(a(obj), n3Var, true);
    }

    public abstract int tl();

    @Override // m1.s
    public final Bundle toBundle() {
        ArrayList arrayList = new ArrayList();
        int z2 = z();
        gv gvVar = new gv();
        for (int i = 0; i < z2; i++) {
            arrayList.add(co(i, gvVar, 0L).toBundle());
        }
        ArrayList arrayList2 = new ArrayList();
        int tl2 = tl();
        n3 n3Var = new n3();
        for (int i5 = 0; i5 < tl2; i5++) {
            arrayList2.add(f(i5, n3Var, false).toBundle());
        }
        int[] iArr = new int[z2];
        if (z2 > 0) {
            iArr[0] = v(true);
        }
        for (int i6 = 1; i6 < z2; i6++) {
            iArr[i6] = c5(iArr[i6 - 1], 0, true);
        }
        Bundle bundle = new Bundle();
        v5.zn.zn(bundle, f10787v, new fb(arrayList));
        v5.zn.zn(bundle, f10785fb, new fb(arrayList2));
        bundle.putIntArray(f10786s, iArr);
        return bundle;
    }

    public int v(boolean z2) {
        if (r()) {
            return -1;
        }
        return 0;
    }

    public int w(int i, int i5, boolean z2) {
        if (i5 != 0) {
            if (i5 != 1) {
                if (i5 == 2) {
                    if (i == v(z2)) {
                        return fb(z2);
                    }
                    return i - 1;
                }
                throw new IllegalStateException();
            }
            return i;
        } else if (i == v(z2)) {
            return -1;
        } else {
            return i - 1;
        }
    }

    public final Pair<Object, Long> wz(gv gvVar, n3 n3Var, int i, long j2) {
        return (Pair) v5.y.v(xc(gvVar, n3Var, i, j2, 0L));
    }

    public final boolean x4(int i, n3 n3Var, gv gvVar, int i5, boolean z2) {
        if (s(i, n3Var, gvVar, i5, z2) == -1) {
            return true;
        }
        return false;
    }

    @Nullable
    public final Pair<Object, Long> xc(gv gvVar, n3 n3Var, int i, long j2, long j4) {
        v5.y.zn(i, 0, z());
        co(i, gvVar, j4);
        if (j2 == -9223372036854775807L) {
            j2 = gvVar.v();
            if (j2 == -9223372036854775807L) {
                return null;
            }
        }
        int i5 = gvVar.f10808d0;
        i9(i5, n3Var);
        while (i5 < gvVar.f10812fh && n3Var.f10827f != j2) {
            int i6 = i5 + 1;
            if (i9(i6, n3Var).f10827f > j2) {
                break;
            }
            i5 = i6;
        }
        f(i5, n3Var, true);
        long j6 = j2 - n3Var.f10827f;
        long j7 = n3Var.f10829s;
        if (j7 != -9223372036854775807L) {
            j6 = Math.min(j6, j7 - 1);
        }
        return Pair.create(v5.y.v(n3Var.f10831v), Long.valueOf(Math.max(0L, j6)));
    }

    public abstract int z();
}
