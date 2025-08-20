package f3;

import f3.c5;
import java.util.Arrays;
import java.util.HashMap;
import n.gv;
/* loaded from: classes.dex */
public class gv {

    /* renamed from: co  reason: collision with root package name */
    public static boolean f7792co = true;

    /* renamed from: f3  reason: collision with root package name */
    public static long f7793f3 = 0;

    /* renamed from: i4  reason: collision with root package name */
    public static int f7794i4 = 1000;

    /* renamed from: mt  reason: collision with root package name */
    public static boolean f7795mt = false;

    /* renamed from: n  reason: collision with root package name */
    public static long f7796n = 0;

    /* renamed from: r  reason: collision with root package name */
    public static boolean f7797r = true;

    /* renamed from: x4  reason: collision with root package name */
    public static boolean f7798x4 = false;

    /* renamed from: z  reason: collision with root package name */
    public static boolean f7799z = true;

    /* renamed from: c5  reason: collision with root package name */
    public boolean f7801c5;

    /* renamed from: gv  reason: collision with root package name */
    public y f7804gv;

    /* renamed from: n3  reason: collision with root package name */
    public int f7806n3;

    /* renamed from: p  reason: collision with root package name */
    public y f7807p;

    /* renamed from: s  reason: collision with root package name */
    public boolean f7808s;

    /* renamed from: t  reason: collision with root package name */
    public int f7809t;

    /* renamed from: w  reason: collision with root package name */
    public int f7812w;

    /* renamed from: wz  reason: collision with root package name */
    public final zn f7813wz;
    public boolean y;

    /* renamed from: zn  reason: collision with root package name */
    public HashMap<String, c5> f7815zn;

    /* renamed from: v  reason: collision with root package name */
    public int f7811v = 32;

    /* renamed from: a  reason: collision with root package name */
    public int f7800a = 32;

    /* renamed from: i9  reason: collision with root package name */
    public boolean[] f7805i9 = new boolean[32];

    /* renamed from: f  reason: collision with root package name */
    public int f7802f = 1;

    /* renamed from: tl  reason: collision with root package name */
    public int f7810tl = 32;

    /* renamed from: xc  reason: collision with root package name */
    public c5[] f7814xc = new c5[f7794i4];

    /* renamed from: fb  reason: collision with root package name */
    public f3.n3[] f7803fb = new f3.n3[32];

    /* loaded from: classes.dex */
    public class n3 extends f3.n3 {
        public n3(zn znVar) {
            this.f7833v = new i9(this, znVar);
        }
    }

    /* loaded from: classes.dex */
    public interface y {
        void clear();

        c5 getKey();

        boolean isEmpty();

        void n3(c5 c5Var);

        void y(y yVar);

        c5 zn(gv gvVar, boolean[] zArr);
    }

    public gv() {
        rz();
        zn znVar = new zn();
        this.f7813wz = znVar;
        this.f7804gv = new s(znVar);
        if (f7798x4) {
            this.f7807p = new n3(znVar);
        } else {
            this.f7807p = new f3.n3(znVar);
        }
    }

    public static f3.n3 co(gv gvVar, c5 c5Var, c5 c5Var2, float f4) {
        return gvVar.mt().i9(c5Var, c5Var2, f4);
    }

    public static v i4() {
        return null;
    }

    public void a(c5 c5Var, int i) {
        if (f7792co && c5Var.f7775gv == -1) {
            float f4 = i;
            c5Var.v(this, f4);
            for (int i5 = 0; i5 < this.f7806n3 + 1; i5++) {
                c5 c5Var2 = this.f7813wz.f7854gv[i5];
                if (c5Var2 != null && c5Var2.f7783wz && c5Var2.f7784xc == c5Var.f7785zn) {
                    c5Var2.v(this, c5Var2.f7782w + f4);
                }
            }
            return;
        }
        int i6 = c5Var.f7775gv;
        if (i6 != -1) {
            f3.n3 n3Var = this.f7803fb[i6];
            if (n3Var.f7830a) {
                n3Var.f7832n3 = i;
                return;
            } else if (n3Var.f7833v.gv() == 0) {
                n3Var.f7830a = true;
                n3Var.f7832n3 = i;
                return;
            } else {
                f3.n3 mt2 = mt();
                mt2.tl(c5Var, i);
                gv(mt2);
                return;
            }
        }
        f3.n3 mt3 = mt();
        mt3.c5(c5Var, i);
        gv(mt3);
    }

    public void c() throws Exception {
        if (this.f7804gv.isEmpty()) {
            wz();
        } else if (!this.f7808s && !this.f7801c5) {
            d0(this.f7804gv);
        } else {
            for (int i = 0; i < this.f7809t; i++) {
                if (!this.f7803fb[i].f7830a) {
                    d0(this.f7804gv);
                    return;
                }
            }
            wz();
        }
    }

    public void c5(c5 c5Var, c5 c5Var2, int i, boolean z2) {
        f3.n3 mt2 = mt();
        c5 z3 = z();
        z3.f7781v = 0;
        mt2.w(c5Var, c5Var2, z3, i);
        gv(mt2);
    }

    public void d0(y yVar) throws Exception {
        r(yVar);
        fh(yVar, false);
        wz();
    }

    public void f(c5 c5Var, c5 c5Var2, c5 c5Var3, c5 c5Var4, float f4, int i) {
        f3.n3 mt2 = mt();
        mt2.f(c5Var, c5Var2, c5Var3, c5Var4, f4);
        if (i != 8) {
            mt2.gv(this, i);
        }
        gv(mt2);
    }

    public int f3(Object obj) {
        c5 s2 = ((n.gv) obj).s();
        if (s2 != null) {
            return (int) (s2.f7771a + 0.5f);
        }
        return 0;
    }

    public void fb(c5 c5Var, c5 c5Var2, int i, boolean z2) {
        f3.n3 mt2 = mt();
        c5 z3 = z();
        z3.f7781v = 0;
        mt2.xc(c5Var, c5Var2, z3, i);
        gv(mt2);
    }

    public final int fh(y yVar, boolean z2) {
        for (int i = 0; i < this.f7802f; i++) {
            this.f7805i9[i] = false;
        }
        boolean z3 = false;
        int i5 = 0;
        while (!z3) {
            i5++;
            if (i5 >= this.f7802f * 2) {
                return i5;
            }
            if (yVar.getKey() != null) {
                this.f7805i9[yVar.getKey().f7785zn] = true;
            }
            c5 zn2 = yVar.zn(this, this.f7805i9);
            if (zn2 != null) {
                boolean[] zArr = this.f7805i9;
                int i6 = zn2.f7785zn;
                if (zArr[i6]) {
                    return i5;
                }
                zArr[i6] = true;
            }
            if (zn2 != null) {
                float f4 = Float.MAX_VALUE;
                int i8 = -1;
                for (int i10 = 0; i10 < this.f7809t; i10++) {
                    f3.n3 n3Var = this.f7803fb[i10];
                    if (n3Var.y.f7776i9 != c5.y.UNRESTRICTED && !n3Var.f7830a && n3Var.z(zn2)) {
                        float tl2 = n3Var.f7833v.tl(zn2);
                        if (tl2 < 0.0f) {
                            float f6 = (-n3Var.f7832n3) / tl2;
                            if (f6 < f4) {
                                i8 = i10;
                                f4 = f6;
                            }
                        }
                    }
                }
                if (i8 > -1) {
                    f3.n3 n3Var2 = this.f7803fb[i8];
                    n3Var2.y.f7775gv = -1;
                    n3Var2.f3(zn2);
                    c5 c5Var = n3Var2.y;
                    c5Var.f7775gv = i8;
                    c5Var.fb(this, n3Var2);
                }
            } else {
                z3 = true;
            }
        }
        return i5;
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x0082 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0083  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void gv(f3.n3 r6) {
        /*
            r5 = this;
            if (r6 != 0) goto L3
            return
        L3:
            int r0 = r5.f7809t
            r1 = 1
            int r0 = r0 + r1
            int r2 = r5.f7810tl
            if (r0 >= r2) goto L12
            int r0 = r5.f7802f
            int r0 = r0 + r1
            int r2 = r5.f7800a
            if (r0 < r2) goto L15
        L12:
            r5.n()
        L15:
            boolean r0 = r6.f7830a
            r2 = 0
            if (r0 != 0) goto L84
            r6.mg(r5)
            boolean r0 = r6.isEmpty()
            if (r0 == 0) goto L24
            return
        L24:
            r6.mt()
            boolean r0 = r6.a(r5)
            if (r0 == 0) goto L7b
            f3.c5 r0 = r5.w()
            r6.y = r0
            int r3 = r5.f7809t
            r5.t(r6)
            int r4 = r5.f7809t
            int r3 = r3 + r1
            if (r4 != r3) goto L7b
            f3.gv$y r2 = r5.f7807p
            r2.y(r6)
            f3.gv$y r2 = r5.f7807p
            r5.fh(r2, r1)
            int r2 = r0.f7775gv
            r3 = -1
            if (r2 != r3) goto L7c
            f3.c5 r2 = r6.y
            if (r2 != r0) goto L59
            f3.c5 r0 = r6.x4(r0)
            if (r0 == 0) goto L59
            r6.f3(r0)
        L59:
            boolean r0 = r6.f7830a
            if (r0 != 0) goto L62
            f3.c5 r0 = r6.y
            r0.fb(r5, r6)
        L62:
            boolean r0 = f3.gv.f7798x4
            if (r0 == 0) goto L6e
            f3.zn r0 = r5.f7813wz
            f3.a<f3.n3> r0 = r0.y
            r0.y(r6)
            goto L75
        L6e:
            f3.zn r0 = r5.f7813wz
            f3.a<f3.n3> r0 = r0.f7855n3
            r0.y(r6)
        L75:
            int r0 = r5.f7809t
            int r0 = r0 - r1
            r5.f7809t = r0
            goto L7c
        L7b:
            r1 = 0
        L7c:
            boolean r0 = r6.co()
            if (r0 != 0) goto L83
            return
        L83:
            r2 = r1
        L84:
            if (r2 != 0) goto L89
            r5.t(r6)
        L89:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: f3.gv.gv(f3.n3):void");
    }

    public void i9(c5 c5Var, c5 c5Var2, int i, int i5) {
        f3.n3 mt2 = mt();
        c5 z2 = z();
        z2.f7781v = 0;
        mt2.w(c5Var, c5Var2, z2, i);
        if (i5 != 8) {
            tl(mt2, (int) (mt2.f7833v.tl(z2) * (-1.0f)), i5);
        }
        gv(mt2);
    }

    public void mg() {
        zn znVar;
        int i = 0;
        while (true) {
            znVar = this.f7813wz;
            c5[] c5VarArr = znVar.f7854gv;
            if (i >= c5VarArr.length) {
                break;
            }
            c5 c5Var = c5VarArr[i];
            if (c5Var != null) {
                c5Var.gv();
            }
            i++;
        }
        znVar.f7856zn.zn(this.f7814xc, this.f7812w);
        this.f7812w = 0;
        Arrays.fill(this.f7813wz.f7854gv, (Object) null);
        HashMap<String, c5> hashMap = this.f7815zn;
        if (hashMap != null) {
            hashMap.clear();
        }
        this.f7806n3 = 0;
        this.f7804gv.clear();
        this.f7802f = 1;
        for (int i5 = 0; i5 < this.f7809t; i5++) {
            f3.n3 n3Var = this.f7803fb[i5];
            if (n3Var != null) {
                n3Var.f7834zn = false;
            }
        }
        rz();
        this.f7809t = 0;
        if (f7798x4) {
            this.f7807p = new n3(this.f7813wz);
        } else {
            this.f7807p = new f3.n3(this.f7813wz);
        }
    }

    public f3.n3 mt() {
        f3.n3 n32;
        if (f7798x4) {
            n32 = this.f7813wz.y.n3();
            if (n32 == null) {
                n32 = new n3(this.f7813wz);
                f7796n++;
            } else {
                n32.n();
            }
        } else {
            n32 = this.f7813wz.f7855n3.n3();
            if (n32 == null) {
                n32 = new f3.n3(this.f7813wz);
                f7793f3++;
            } else {
                n32.n();
            }
        }
        c5.n3();
        return n32;
    }

    public final void n() {
        int i = this.f7811v * 2;
        this.f7811v = i;
        this.f7803fb = (f3.n3[]) Arrays.copyOf(this.f7803fb, i);
        zn znVar = this.f7813wz;
        znVar.f7854gv = (c5[]) Arrays.copyOf(znVar.f7854gv, this.f7811v);
        int i5 = this.f7811v;
        this.f7805i9 = new boolean[i5];
        this.f7800a = i5;
        this.f7810tl = i5;
    }

    public void n3(n.v vVar, n.v vVar2, float f4, int i) {
        gv.n3 n3Var = gv.n3.LEFT;
        c5 p2 = p(vVar.tl(n3Var));
        gv.n3 n3Var2 = gv.n3.TOP;
        c5 p3 = p(vVar.tl(n3Var2));
        gv.n3 n3Var3 = gv.n3.RIGHT;
        c5 p4 = p(vVar.tl(n3Var3));
        gv.n3 n3Var4 = gv.n3.BOTTOM;
        c5 p8 = p(vVar.tl(n3Var4));
        c5 p9 = p(vVar2.tl(n3Var));
        c5 p10 = p(vVar2.tl(n3Var2));
        c5 p11 = p(vVar2.tl(n3Var3));
        c5 p12 = p(vVar2.tl(n3Var4));
        f3.n3 mt2 = mt();
        double d2 = f4;
        double d3 = i;
        mt2.p(p3, p8, p10, p12, (float) (Math.sin(d2) * d3));
        gv(mt2);
        f3.n3 mt3 = mt();
        mt3.p(p2, p4, p9, p11, (float) (Math.cos(d2) * d3));
        gv(mt3);
    }

    public c5 p(Object obj) {
        c5 c5Var = null;
        if (obj == null) {
            return null;
        }
        if (this.f7802f + 1 >= this.f7800a) {
            n();
        }
        if (obj instanceof n.gv) {
            n.gv gvVar = (n.gv) obj;
            c5Var = gvVar.s();
            if (c5Var == null) {
                gvVar.mt(this.f7813wz);
                c5Var = gvVar.s();
            }
            int i = c5Var.f7785zn;
            if (i == -1 || i > this.f7806n3 || this.f7813wz.f7854gv[i] == null) {
                if (i != -1) {
                    c5Var.gv();
                }
                int i5 = this.f7806n3 + 1;
                this.f7806n3 = i5;
                this.f7802f++;
                c5Var.f7785zn = i5;
                c5Var.f7776i9 = c5.y.UNRESTRICTED;
                this.f7813wz.f7854gv[i5] = c5Var;
            }
        }
        return c5Var;
    }

    public final int r(y yVar) throws Exception {
        for (int i = 0; i < this.f7809t; i++) {
            f3.n3 n3Var = this.f7803fb[i];
            if (n3Var.y.f7776i9 != c5.y.UNRESTRICTED && n3Var.f7832n3 < 0.0f) {
                boolean z2 = false;
                int i5 = 0;
                while (!z2) {
                    i5++;
                    float f4 = Float.MAX_VALUE;
                    int i6 = 0;
                    int i8 = -1;
                    int i10 = -1;
                    int i11 = 0;
                    while (true) {
                        if (i6 >= this.f7809t) {
                            break;
                        }
                        f3.n3 n3Var2 = this.f7803fb[i6];
                        if (n3Var2.y.f7776i9 != c5.y.UNRESTRICTED && !n3Var2.f7830a && n3Var2.f7832n3 < 0.0f) {
                            int i12 = 9;
                            if (f7797r) {
                                int gv2 = n3Var2.f7833v.gv();
                                int i13 = 0;
                                while (i13 < gv2) {
                                    c5 v2 = n3Var2.f7833v.v(i13);
                                    float tl2 = n3Var2.f7833v.tl(v2);
                                    if (tl2 > 0.0f) {
                                        int i14 = 0;
                                        while (i14 < i12) {
                                            float f6 = v2.f7778s[i14] / tl2;
                                            if ((f6 < f4 && i14 == i11) || i14 > i11) {
                                                i11 = i14;
                                                i10 = v2.f7785zn;
                                                i8 = i6;
                                                f4 = f6;
                                            }
                                            i14++;
                                            i12 = 9;
                                        }
                                    }
                                    i13++;
                                    i12 = 9;
                                }
                            } else {
                                for (int i15 = 1; i15 < this.f7802f; i15++) {
                                    c5 c5Var = this.f7813wz.f7854gv[i15];
                                    float tl3 = n3Var2.f7833v.tl(c5Var);
                                    if (tl3 > 0.0f) {
                                        for (int i16 = 0; i16 < 9; i16++) {
                                            float f9 = c5Var.f7778s[i16] / tl3;
                                            if ((f9 < f4 && i16 == i11) || i16 > i11) {
                                                i8 = i6;
                                                i10 = i15;
                                                i11 = i16;
                                                f4 = f9;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        i6++;
                    }
                    if (i8 != -1) {
                        f3.n3 n3Var3 = this.f7803fb[i8];
                        n3Var3.y.f7775gv = -1;
                        n3Var3.f3(this.f7813wz.f7854gv[i10]);
                        c5 c5Var2 = n3Var3.y;
                        c5Var2.f7775gv = i8;
                        c5Var2.fb(this, n3Var3);
                    } else {
                        z2 = true;
                    }
                    if (i5 > this.f7802f / 2) {
                        z2 = true;
                    }
                }
                return i5;
            }
        }
        return 0;
    }

    public final void rz() {
        int i = 0;
        if (f7798x4) {
            while (i < this.f7809t) {
                f3.n3 n3Var = this.f7803fb[i];
                if (n3Var != null) {
                    this.f7813wz.y.y(n3Var);
                }
                this.f7803fb[i] = null;
                i++;
            }
            return;
        }
        while (i < this.f7809t) {
            f3.n3 n3Var2 = this.f7803fb[i];
            if (n3Var2 != null) {
                this.f7813wz.f7855n3.y(n3Var2);
            }
            this.f7803fb[i] = null;
            i++;
        }
    }

    public void s(c5 c5Var, c5 c5Var2, int i, int i5) {
        f3.n3 mt2 = mt();
        c5 z2 = z();
        z2.f7781v = 0;
        mt2.xc(c5Var, c5Var2, z2, i);
        if (i5 != 8) {
            tl(mt2, (int) (mt2.f7833v.tl(z2) * (-1.0f)), i5);
        }
        gv(mt2);
    }

    public final void t(f3.n3 n3Var) {
        int i;
        if (f7799z && n3Var.f7830a) {
            n3Var.y.v(this, n3Var.f7832n3);
        } else {
            f3.n3[] n3VarArr = this.f7803fb;
            int i5 = this.f7809t;
            n3VarArr[i5] = n3Var;
            c5 c5Var = n3Var.y;
            c5Var.f7775gv = i5;
            this.f7809t = i5 + 1;
            c5Var.fb(this, n3Var);
        }
        if (f7799z && this.y) {
            int i6 = 0;
            while (i6 < this.f7809t) {
                if (this.f7803fb[i6] == null) {
                    System.out.println("WTF");
                }
                f3.n3 n3Var2 = this.f7803fb[i6];
                if (n3Var2 != null && n3Var2.f7830a) {
                    n3Var2.y.v(this, n3Var2.f7832n3);
                    if (f7798x4) {
                        this.f7813wz.y.y(n3Var2);
                    } else {
                        this.f7813wz.f7855n3.y(n3Var2);
                    }
                    this.f7803fb[i6] = null;
                    int i8 = i6 + 1;
                    int i10 = i8;
                    while (true) {
                        i = this.f7809t;
                        if (i8 >= i) {
                            break;
                        }
                        f3.n3[] n3VarArr2 = this.f7803fb;
                        int i11 = i8 - 1;
                        f3.n3 n3Var3 = n3VarArr2[i8];
                        n3VarArr2[i11] = n3Var3;
                        c5 c5Var2 = n3Var3.y;
                        if (c5Var2.f7775gv == i8) {
                            c5Var2.f7775gv = i11;
                        }
                        i10 = i8;
                        i8++;
                    }
                    if (i10 < i) {
                        this.f7803fb[i10] = null;
                    }
                    this.f7809t = i - 1;
                    i6--;
                }
                i6++;
            }
            this.y = false;
        }
    }

    public void tl(f3.n3 n3Var, int i, int i5) {
        n3Var.v(xc(i5, null), i);
    }

    public f3.n3 v(c5 c5Var, c5 c5Var2, int i, int i5) {
        if (f7792co && i5 == 8 && c5Var2.f7774fb && c5Var.f7775gv == -1) {
            c5Var.v(this, c5Var2.f7771a + i);
            return null;
        }
        f3.n3 mt2 = mt();
        mt2.wz(c5Var, c5Var2, i);
        if (i5 != 8) {
            mt2.gv(this, i5);
        }
        gv(mt2);
        return mt2;
    }

    public c5 w() {
        if (this.f7802f + 1 >= this.f7800a) {
            n();
        }
        c5 y2 = y(c5.y.SLACK, null);
        int i = this.f7806n3 + 1;
        this.f7806n3 = i;
        this.f7802f++;
        y2.f7785zn = i;
        this.f7813wz.f7854gv[i] = y2;
        return y2;
    }

    public final void wz() {
        for (int i = 0; i < this.f7809t; i++) {
            f3.n3 n3Var = this.f7803fb[i];
            n3Var.y.f7771a = n3Var.f7832n3;
        }
    }

    public zn x4() {
        return this.f7813wz;
    }

    public c5 xc(int i, String str) {
        if (this.f7802f + 1 >= this.f7800a) {
            n();
        }
        c5 y2 = y(c5.y.ERROR, str);
        int i5 = this.f7806n3 + 1;
        this.f7806n3 = i5;
        this.f7802f++;
        y2.f7785zn = i5;
        y2.f7781v = i;
        this.f7813wz.f7854gv[i5] = y2;
        this.f7804gv.n3(y2);
        return y2;
    }

    public final c5 y(c5.y yVar, String str) {
        c5 n32 = this.f7813wz.f7856zn.n3();
        if (n32 == null) {
            n32 = new c5(yVar, str);
            n32.a(yVar, str);
        } else {
            n32.gv();
            n32.a(yVar, str);
        }
        int i = this.f7812w;
        int i5 = f7794i4;
        if (i >= i5) {
            int i6 = i5 * 2;
            f7794i4 = i6;
            this.f7814xc = (c5[]) Arrays.copyOf(this.f7814xc, i6);
        }
        c5[] c5VarArr = this.f7814xc;
        int i8 = this.f7812w;
        this.f7812w = i8 + 1;
        c5VarArr[i8] = n32;
        return n32;
    }

    public c5 z() {
        if (this.f7802f + 1 >= this.f7800a) {
            n();
        }
        c5 y2 = y(c5.y.SLACK, null);
        int i = this.f7806n3 + 1;
        this.f7806n3 = i;
        this.f7802f++;
        y2.f7785zn = i;
        this.f7813wz.f7854gv[i] = y2;
        return y2;
    }

    public void zn(c5 c5Var, c5 c5Var2, int i, float f4, c5 c5Var3, c5 c5Var4, int i5, int i6) {
        f3.n3 mt2 = mt();
        mt2.s(c5Var, c5Var2, i, f4, c5Var3, c5Var4, i5);
        if (i6 != 8) {
            mt2.gv(this, i6);
        }
        gv(mt2);
    }
}
