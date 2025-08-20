package y3;

import android.util.SparseArray;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import java.util.ArrayList;
import java.util.Arrays;
import m1.m;
import v5.c;
import v5.j5;
import y3.ud;
/* loaded from: classes.dex */
public final class w implements tl {

    /* renamed from: c5  reason: collision with root package name */
    public String f15166c5;

    /* renamed from: f  reason: collision with root package name */
    public n3 f15167f;

    /* renamed from: fb  reason: collision with root package name */
    public long f15168fb;

    /* renamed from: i9  reason: collision with root package name */
    public e4.ta f15170i9;

    /* renamed from: n3  reason: collision with root package name */
    public final boolean f15171n3;

    /* renamed from: t  reason: collision with root package name */
    public boolean f15173t;

    /* renamed from: wz  reason: collision with root package name */
    public boolean f15176wz;
    public final mg y;

    /* renamed from: zn  reason: collision with root package name */
    public final boolean f15178zn;

    /* renamed from: s  reason: collision with root package name */
    public final boolean[] f15172s = new boolean[3];

    /* renamed from: gv  reason: collision with root package name */
    public final r f15169gv = new r(7, NotificationCompat.FLAG_HIGH_PRIORITY);

    /* renamed from: v  reason: collision with root package name */
    public final r f15175v = new r(8, NotificationCompat.FLAG_HIGH_PRIORITY);

    /* renamed from: a  reason: collision with root package name */
    public final r f15165a = new r(6, NotificationCompat.FLAG_HIGH_PRIORITY);

    /* renamed from: tl  reason: collision with root package name */
    public long f15174tl = -9223372036854775807L;

    /* renamed from: xc  reason: collision with root package name */
    public final v5.rz f15177xc = new v5.rz();

    /* loaded from: classes.dex */
    public static final class n3 {

        /* renamed from: a  reason: collision with root package name */
        public final v5.mg f15179a;

        /* renamed from: c5  reason: collision with root package name */
        public int f15180c5;

        /* renamed from: f  reason: collision with root package name */
        public boolean f15181f;

        /* renamed from: fb  reason: collision with root package name */
        public byte[] f15182fb;

        /* renamed from: i9  reason: collision with root package name */
        public long f15184i9;

        /* renamed from: mt  reason: collision with root package name */
        public boolean f15185mt;

        /* renamed from: n3  reason: collision with root package name */
        public final boolean f15186n3;

        /* renamed from: p  reason: collision with root package name */
        public long f15187p;

        /* renamed from: s  reason: collision with root package name */
        public int f15188s;

        /* renamed from: t  reason: collision with root package name */
        public long f15189t;

        /* renamed from: w  reason: collision with root package name */
        public long f15192w;

        /* renamed from: xc  reason: collision with root package name */
        public boolean f15194xc;
        public final e4.ta y;

        /* renamed from: zn  reason: collision with root package name */
        public final boolean f15195zn;

        /* renamed from: gv  reason: collision with root package name */
        public final SparseArray<c.zn> f15183gv = new SparseArray<>();

        /* renamed from: v  reason: collision with root package name */
        public final SparseArray<c.n3> f15191v = new SparseArray<>();

        /* renamed from: tl  reason: collision with root package name */
        public y f15190tl = new y();

        /* renamed from: wz  reason: collision with root package name */
        public y f15193wz = new y();

        /* loaded from: classes.dex */
        public static final class y {

            /* renamed from: a  reason: collision with root package name */
            public int f15196a;

            /* renamed from: c5  reason: collision with root package name */
            public boolean f15197c5;

            /* renamed from: f  reason: collision with root package name */
            public boolean f15198f;

            /* renamed from: fb  reason: collision with root package name */
            public int f15199fb;

            /* renamed from: gv  reason: collision with root package name */
            public int f15200gv;

            /* renamed from: i9  reason: collision with root package name */
            public boolean f15201i9;

            /* renamed from: n3  reason: collision with root package name */
            public boolean f15202n3;

            /* renamed from: s  reason: collision with root package name */
            public boolean f15203s;

            /* renamed from: t  reason: collision with root package name */
            public int f15204t;

            /* renamed from: tl  reason: collision with root package name */
            public int f15205tl;

            /* renamed from: v  reason: collision with root package name */
            public int f15206v;

            /* renamed from: w  reason: collision with root package name */
            public int f15207w;

            /* renamed from: wz  reason: collision with root package name */
            public int f15208wz;

            /* renamed from: xc  reason: collision with root package name */
            public int f15209xc;
            public boolean y;
            @Nullable

            /* renamed from: zn  reason: collision with root package name */
            public c.zn f15210zn;

            public y() {
            }

            public void a(int i) {
                this.f15206v = i;
                this.f15202n3 = true;
            }

            public boolean gv() {
                int i;
                if (this.f15202n3 && ((i = this.f15206v) == 7 || i == 2)) {
                    return true;
                }
                return false;
            }

            public void n3() {
                this.f15202n3 = false;
                this.y = false;
            }

            public void v(c.zn znVar, int i, int i5, int i6, int i8, boolean z2, boolean z3, boolean z4, boolean z5, int i10, int i11, int i12, int i13, int i14) {
                this.f15210zn = znVar;
                this.f15200gv = i;
                this.f15206v = i5;
                this.f15196a = i6;
                this.f15199fb = i8;
                this.f15203s = z2;
                this.f15197c5 = z3;
                this.f15201i9 = z4;
                this.f15198f = z5;
                this.f15204t = i10;
                this.f15205tl = i11;
                this.f15208wz = i12;
                this.f15209xc = i13;
                this.f15207w = i14;
                this.y = true;
                this.f15202n3 = true;
            }

            public final boolean zn(y yVar) {
                int i;
                int i5;
                int i6;
                boolean z2;
                if (!this.y) {
                    return false;
                }
                if (!yVar.y) {
                    return true;
                }
                c.zn znVar = (c.zn) v5.y.c5(this.f15210zn);
                c.zn znVar2 = (c.zn) v5.y.c5(yVar.f15210zn);
                if (this.f15196a == yVar.f15196a && this.f15199fb == yVar.f15199fb && this.f15203s == yVar.f15203s && ((!this.f15197c5 || !yVar.f15197c5 || this.f15201i9 == yVar.f15201i9) && (((i = this.f15200gv) == (i5 = yVar.f15200gv) || (i != 0 && i5 != 0)) && (((i6 = znVar.f14332t) != 0 || znVar2.f14332t != 0 || (this.f15205tl == yVar.f15205tl && this.f15208wz == yVar.f15208wz)) && ((i6 != 1 || znVar2.f14332t != 1 || (this.f15209xc == yVar.f15209xc && this.f15207w == yVar.f15207w)) && (z2 = this.f15198f) == yVar.f15198f && (!z2 || this.f15204t == yVar.f15204t)))))) {
                    return false;
                }
                return true;
            }
        }

        public n3(e4.ta taVar, boolean z2, boolean z3) {
            this.y = taVar;
            this.f15186n3 = z2;
            this.f15195zn = z3;
            byte[] bArr = new byte[NotificationCompat.FLAG_HIGH_PRIORITY];
            this.f15182fb = bArr;
            this.f15179a = new v5.mg(bArr, 0, 0);
            fb();
        }

        public void a(c.zn znVar) {
            this.f15183gv.append(znVar.f14328gv, znVar);
        }

        public void fb() {
            this.f15181f = false;
            this.f15194xc = false;
            this.f15193wz.n3();
        }

        public final void gv(int i) {
            long j2 = this.f15187p;
            if (j2 == -9223372036854775807L) {
                return;
            }
            boolean z2 = this.f15185mt;
            this.y.gv(j2, z2 ? 1 : 0, (int) (this.f15184i9 - this.f15192w), i, null);
        }

        public boolean n3(long j2, int i, boolean z2, boolean z3) {
            boolean z4 = false;
            if (this.f15180c5 == 9 || (this.f15195zn && this.f15193wz.zn(this.f15190tl))) {
                if (z2 && this.f15194xc) {
                    gv(i + ((int) (j2 - this.f15184i9)));
                }
                this.f15192w = this.f15184i9;
                this.f15187p = this.f15189t;
                this.f15185mt = false;
                this.f15194xc = true;
            }
            if (this.f15186n3) {
                z3 = this.f15193wz.gv();
            }
            boolean z5 = this.f15185mt;
            int i5 = this.f15180c5;
            if (i5 == 5 || (z3 && i5 == 1)) {
                z4 = true;
            }
            boolean z7 = z5 | z4;
            this.f15185mt = z7;
            return z7;
        }

        public void s(long j2, int i, long j4) {
            this.f15180c5 = i;
            this.f15189t = j4;
            this.f15184i9 = j2;
            if (!this.f15186n3 || i != 1) {
                if (this.f15195zn) {
                    if (i != 5 && i != 1 && i != 2) {
                        return;
                    }
                } else {
                    return;
                }
            }
            y yVar = this.f15190tl;
            this.f15190tl = this.f15193wz;
            this.f15193wz = yVar;
            yVar.n3();
            this.f15188s = 0;
            this.f15181f = true;
        }

        public void v(c.n3 n3Var) {
            this.f15191v.append(n3Var.y, n3Var);
        }

        /* JADX WARN: Removed duplicated region for block: B:53:0x0100  */
        /* JADX WARN: Removed duplicated region for block: B:54:0x0103  */
        /* JADX WARN: Removed duplicated region for block: B:56:0x0107  */
        /* JADX WARN: Removed duplicated region for block: B:60:0x0119  */
        /* JADX WARN: Removed duplicated region for block: B:63:0x011f  */
        /* JADX WARN: Removed duplicated region for block: B:77:0x0155  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void y(byte[] r24, int r25, int r26) {
            /*
                Method dump skipped, instructions count: 410
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: y3.w.n3.y(byte[], int, int):void");
        }

        public boolean zn() {
            return this.f15195zn;
        }
    }

    public w(mg mgVar, boolean z2, boolean z3) {
        this.y = mgVar;
        this.f15171n3 = z2;
        this.f15178zn = z3;
    }

    private void y() {
        v5.y.c5(this.f15170i9);
        j5.i9(this.f15167f);
    }

    @Override // y3.tl
    public void a(long j2, int i) {
        boolean z2;
        if (j2 != -9223372036854775807L) {
            this.f15174tl = j2;
        }
        boolean z3 = this.f15176wz;
        if ((i & 2) != 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        this.f15176wz = z3 | z2;
    }

    public final void c5(long j2, int i, long j4) {
        if (!this.f15173t || this.f15167f.zn()) {
            this.f15169gv.v(i);
            this.f15175v.v(i);
        }
        this.f15165a.v(i);
        this.f15167f.s(j2, i, j4);
    }

    public final void fb(long j2, int i, int i5, long j4) {
        if (!this.f15173t || this.f15167f.zn()) {
            this.f15169gv.n3(i5);
            this.f15175v.n3(i5);
            if (!this.f15173t) {
                if (this.f15169gv.zn() && this.f15175v.zn()) {
                    ArrayList arrayList = new ArrayList();
                    r rVar = this.f15169gv;
                    arrayList.add(Arrays.copyOf(rVar.f15124gv, rVar.f15126v));
                    r rVar2 = this.f15175v;
                    arrayList.add(Arrays.copyOf(rVar2.f15124gv, rVar2.f15126v));
                    r rVar3 = this.f15169gv;
                    c.zn t2 = v5.c.t(rVar3.f15124gv, 3, rVar3.f15126v);
                    r rVar4 = this.f15175v;
                    c.n3 i92 = v5.c.i9(rVar4.f15124gv, 3, rVar4.f15126v);
                    this.f15170i9.v(new m.n3().oz(this.f15166c5).o4("video/avc").x(v5.a.y(t2.y, t2.f14330n3, t2.f14336zn)).s8(t2.f14324a).o(t2.f14327fb).y5(t2.f14331s).ut(arrayList).z6());
                    this.f15173t = true;
                    this.f15167f.a(t2);
                    this.f15167f.v(i92);
                    this.f15169gv.gv();
                    this.f15175v.gv();
                }
            } else if (this.f15169gv.zn()) {
                r rVar5 = this.f15169gv;
                this.f15167f.a(v5.c.t(rVar5.f15124gv, 3, rVar5.f15126v));
                this.f15169gv.gv();
            } else if (this.f15175v.zn()) {
                r rVar6 = this.f15175v;
                this.f15167f.v(v5.c.i9(rVar6.f15124gv, 3, rVar6.f15126v));
                this.f15175v.gv();
            }
        }
        if (this.f15165a.n3(i5)) {
            r rVar7 = this.f15165a;
            this.f15177xc.o(this.f15165a.f15124gv, v5.c.p(rVar7.f15124gv, rVar7.f15126v));
            this.f15177xc.oz(4);
            this.y.y(j4, this.f15177xc);
        }
        if (this.f15167f.n3(j2, i, this.f15173t, this.f15176wz)) {
            this.f15176wz = false;
        }
    }

    @Override // y3.tl
    public void n3(v5.rz rzVar) {
        int i;
        y();
        int a2 = rzVar.a();
        int fb2 = rzVar.fb();
        byte[] v2 = rzVar.v();
        this.f15168fb += rzVar.y();
        this.f15170i9.zn(rzVar, rzVar.y());
        while (true) {
            int zn2 = v5.c.zn(v2, a2, fb2, this.f15172s);
            if (zn2 == fb2) {
                s(v2, a2, fb2);
                return;
            }
            int a3 = v5.c.a(v2, zn2);
            int i5 = zn2 - a2;
            if (i5 > 0) {
                s(v2, a2, zn2);
            }
            int i6 = fb2 - zn2;
            long j2 = this.f15168fb - i6;
            if (i5 < 0) {
                i = -i5;
            } else {
                i = 0;
            }
            fb(j2, i6, i, this.f15174tl);
            c5(j2, a3, this.f15174tl);
            a2 = zn2 + 3;
        }
    }

    public final void s(byte[] bArr, int i, int i5) {
        if (!this.f15173t || this.f15167f.zn()) {
            this.f15169gv.y(bArr, i, i5);
            this.f15175v.y(bArr, i, i5);
        }
        this.f15165a.y(bArr, i, i5);
        this.f15167f.y(bArr, i, i5);
    }

    @Override // y3.tl
    public void v(e4.wz wzVar, ud.gv gvVar) {
        gvVar.y();
        this.f15166c5 = gvVar.n3();
        e4.ta a2 = wzVar.a(gvVar.zn(), 2);
        this.f15170i9 = a2;
        this.f15167f = new n3(a2, this.f15171n3, this.f15178zn);
        this.y.n3(wzVar, gvVar);
    }

    @Override // y3.tl
    public void zn() {
        this.f15168fb = 0L;
        this.f15176wz = false;
        this.f15174tl = -9223372036854775807L;
        v5.c.y(this.f15172s);
        this.f15169gv.gv();
        this.f15175v.gv();
        this.f15165a.gv();
        n3 n3Var = this.f15167f;
        if (n3Var != null) {
            n3Var.fb();
        }
    }

    @Override // y3.tl
    public void gv() {
    }
}
