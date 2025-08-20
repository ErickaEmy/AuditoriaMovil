package c;

import androidx.core.app.NotificationCompat;
import java.util.ArrayList;
import n.gv;
import n.v;
/* loaded from: classes.dex */
public class n3 {

    /* renamed from: zn  reason: collision with root package name */
    public n.a f3912zn;
    public final ArrayList<n.v> y = new ArrayList<>();

    /* renamed from: n3  reason: collision with root package name */
    public y f3911n3 = new y();

    /* renamed from: c.n3$n3  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0040n3 {
        void n3(n.v vVar, y yVar);

        void y();
    }

    /* loaded from: classes.dex */
    public static class y {

        /* renamed from: f  reason: collision with root package name */
        public static int f3913f = 0;

        /* renamed from: t  reason: collision with root package name */
        public static int f3914t = 1;

        /* renamed from: tl  reason: collision with root package name */
        public static int f3915tl = 2;

        /* renamed from: a  reason: collision with root package name */
        public int f3916a;

        /* renamed from: c5  reason: collision with root package name */
        public boolean f3917c5;

        /* renamed from: fb  reason: collision with root package name */
        public int f3918fb;

        /* renamed from: gv  reason: collision with root package name */
        public int f3919gv;

        /* renamed from: i9  reason: collision with root package name */
        public int f3920i9;

        /* renamed from: n3  reason: collision with root package name */
        public v.n3 f3921n3;

        /* renamed from: s  reason: collision with root package name */
        public boolean f3922s;

        /* renamed from: v  reason: collision with root package name */
        public int f3923v;
        public v.n3 y;

        /* renamed from: zn  reason: collision with root package name */
        public int f3924zn;
    }

    public n3(n.a aVar) {
        this.f3912zn = aVar;
    }

    public long gv(n.a aVar, int i, int i5, int i6, int i8, int i10, int i11, int i12, int i13, int i14) {
        boolean z2;
        boolean z3;
        boolean z4;
        int i15;
        n.a aVar2;
        int i16;
        boolean z5;
        boolean z7;
        boolean z8;
        boolean z9;
        boolean z10;
        int i17;
        boolean z11;
        int i18;
        int i19;
        boolean z12;
        boolean z13;
        boolean z14;
        boolean z15;
        boolean z16;
        boolean z17;
        InterfaceC0040n3 r6 = aVar.r6();
        int size = aVar.f11684o0.size();
        int qn2 = aVar.qn();
        int x42 = aVar.x4();
        boolean n32 = n.i9.n3(i, NotificationCompat.FLAG_HIGH_PRIORITY);
        if (!n32 && !n.i9.n3(i, 64)) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (z2) {
            for (int i20 = 0; i20 < size; i20++) {
                n.v vVar = aVar.f11684o0.get(i20);
                v.n3 n2 = vVar.n();
                v.n3 n3Var = v.n3.MATCH_CONSTRAINT;
                if (n2 == n3Var) {
                    z15 = true;
                } else {
                    z15 = false;
                }
                if (vVar.vl() == n3Var) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z15 && z16 && vVar.z() > 0.0f) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if ((vVar.en() && z17) || ((vVar.u() && z17) || (vVar instanceof n.f) || vVar.en() || vVar.u())) {
                    z2 = false;
                    break;
                }
            }
        }
        if (z2) {
            boolean z18 = f3.gv.f7795mt;
        }
        if ((i8 == 1073741824 && i11 == 1073741824) || n32) {
            z3 = true;
        } else {
            z3 = false;
        }
        boolean z19 = z2 & z3;
        if (z19) {
            int min = Math.min(aVar.ta(), i10);
            int min2 = Math.min(aVar.mg(), i12);
            if (i8 == 1073741824 && aVar.qn() != min) {
                aVar.cs(min);
                aVar.hk();
            }
            if (i11 == 1073741824 && aVar.x4() != min2) {
                aVar.g(min2);
                aVar.hk();
            }
            if (i8 == 1073741824 && i11 == 1073741824) {
                z4 = aVar.c8(n32);
                i15 = 2;
            } else {
                boolean h = aVar.h(n32);
                if (i8 == 1073741824) {
                    h &= aVar.ia(n32, 0);
                    i15 = 1;
                } else {
                    i15 = 0;
                }
                if (i11 == 1073741824) {
                    z4 = aVar.ia(n32, 1) & h;
                    i15++;
                } else {
                    z4 = h;
                }
            }
            if (z4) {
                if (i8 == 1073741824) {
                    z13 = true;
                } else {
                    z13 = false;
                }
                if (i11 == 1073741824) {
                    z14 = true;
                } else {
                    z14 = false;
                }
                aVar.i2(z13, z14);
            }
        } else {
            z4 = false;
            i15 = 0;
        }
        if (!z4 || i15 != 2) {
            int jr = aVar.jr();
            if (size > 0) {
                n3(aVar);
            }
            v(aVar);
            int size2 = this.y.size();
            if (size > 0) {
                zn(aVar, "First pass", qn2, x42);
            }
            if (size2 > 0) {
                v.n3 n4 = aVar.n();
                v.n3 n3Var2 = v.n3.WRAP_CONTENT;
                if (n4 == n3Var2) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                if (aVar.vl() == n3Var2) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                int max = Math.max(aVar.qn(), this.f3912zn.z6());
                int max2 = Math.max(aVar.x4(), this.f3912zn.d());
                int i21 = 0;
                boolean z20 = false;
                while (i21 < size2) {
                    n.v vVar2 = this.y.get(i21);
                    if (!(vVar2 instanceof n.f)) {
                        i19 = jr;
                    } else {
                        int qn3 = vVar2.qn();
                        int x43 = vVar2.x4();
                        i19 = jr;
                        boolean y2 = z20 | y(r6, vVar2, y.f3914t);
                        int qn4 = vVar2.qn();
                        int x44 = vVar2.x4();
                        if (qn4 != qn3) {
                            vVar2.cs(qn4);
                            if (z5 && vVar2.x() > max) {
                                max = Math.max(max, vVar2.x() + vVar2.tl(gv.n3.RIGHT).v());
                            }
                            z12 = true;
                        } else {
                            z12 = y2;
                        }
                        if (x44 != x43) {
                            vVar2.g(x44);
                            if (z7 && vVar2.w() > max2) {
                                max2 = Math.max(max2, vVar2.w() + vVar2.tl(gv.n3.BOTTOM).v());
                            }
                            z12 = true;
                        }
                        z20 = z12 | ((n.f) vVar2).q();
                    }
                    i21++;
                    jr = i19;
                }
                int i22 = jr;
                int i23 = 2;
                int i24 = 0;
                while (true) {
                    if (i24 < i23) {
                        int i25 = 0;
                        while (i25 < size2) {
                            n.v vVar3 = this.y.get(i25);
                            if (((vVar3 instanceof n.s) && !(vVar3 instanceof n.f)) || (vVar3 instanceof n.fb) || vVar3.j5() == 8 || ((z19 && vVar3.f11749v.f3947v.f3896i9 && vVar3.f11686a.f3947v.f3896i9) || (vVar3 instanceof n.f))) {
                                z10 = z19;
                                i17 = size2;
                            } else {
                                int qn5 = vVar3.qn();
                                int x45 = vVar3.x4();
                                int wz2 = vVar3.wz();
                                int i26 = y.f3914t;
                                z10 = z19;
                                if (i24 == 1) {
                                    i26 = y.f3915tl;
                                }
                                boolean y7 = z20 | y(r6, vVar3, i26);
                                int qn6 = vVar3.qn();
                                i17 = size2;
                                int x46 = vVar3.x4();
                                if (qn6 != qn5) {
                                    vVar3.cs(qn6);
                                    if (z5 && vVar3.x() > max) {
                                        max = Math.max(max, vVar3.x() + vVar3.tl(gv.n3.RIGHT).v());
                                    }
                                    z11 = true;
                                } else {
                                    z11 = y7;
                                }
                                if (x46 != x45) {
                                    vVar3.g(x46);
                                    if (z7 && vVar3.w() > max2) {
                                        max2 = Math.max(max2, vVar3.w() + vVar3.tl(gv.n3.BOTTOM).v());
                                    }
                                    z11 = true;
                                }
                                if (vVar3.oz() && wz2 != vVar3.wz()) {
                                    i18 = 1;
                                    z20 = true;
                                    i25 += i18;
                                    size2 = i17;
                                    z19 = z10;
                                } else {
                                    z20 = z11;
                                }
                            }
                            i18 = 1;
                            i25 += i18;
                            size2 = i17;
                            z19 = z10;
                        }
                        boolean z21 = z19;
                        int i27 = size2;
                        if (z20) {
                            zn(aVar, "intermediate pass", qn2, x42);
                            i24++;
                            size2 = i27;
                            z19 = z21;
                            i23 = 2;
                            z20 = false;
                        } else {
                            aVar2 = aVar;
                            break;
                        }
                    } else {
                        aVar2 = aVar;
                        break;
                    }
                }
                if (z20) {
                    zn(aVar2, "2nd pass", qn2, x42);
                    if (aVar.qn() < max) {
                        aVar2.cs(max);
                        z8 = true;
                    } else {
                        z8 = false;
                    }
                    if (aVar.x4() < max2) {
                        aVar2.g(max2);
                        z9 = true;
                    } else {
                        z9 = z8;
                    }
                    if (z9) {
                        zn(aVar2, "3rd pass", qn2, x42);
                    }
                }
                i16 = i22;
            } else {
                aVar2 = aVar;
                i16 = jr;
            }
            aVar2.cx(i16);
            return 0L;
        }
        return 0L;
    }

    /* JADX WARN: Code restructure failed: missing block: B:52:0x008d, code lost:
        if (r8 != r9) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0094, code lost:
        if (r5.f11732q9 <= 0.0f) goto L55;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void n3(n.a r13) {
        /*
            r12 = this;
            java.util.ArrayList<n.v> r0 = r13.f11684o0
            int r0 = r0.size()
            r1 = 64
            boolean r1 = r13.rv(r1)
            c.n3$n3 r2 = r13.r6()
            r3 = 0
            r4 = 0
        L12:
            if (r4 >= r0) goto La4
            java.util.ArrayList<n.v> r5 = r13.f11684o0
            java.lang.Object r5 = r5.get(r4)
            n.v r5 = (n.v) r5
            boolean r6 = r5 instanceof n.fb
            if (r6 == 0) goto L22
            goto La0
        L22:
            boolean r6 = r5 instanceof n.y
            if (r6 == 0) goto L28
            goto La0
        L28:
            boolean r6 = r5.y5()
            if (r6 == 0) goto L30
            goto La0
        L30:
            if (r1 == 0) goto L47
            c.t r6 = r5.f11749v
            if (r6 == 0) goto L47
            c.wz r7 = r5.f11686a
            if (r7 == 0) goto L47
            c.fb r6 = r6.f3947v
            boolean r6 = r6.f3896i9
            if (r6 == 0) goto L47
            c.fb r6 = r7.f3947v
            boolean r6 = r6.f3896i9
            if (r6 == 0) goto L47
            goto La0
        L47:
            n.v$n3 r6 = r5.co(r3)
            r7 = 1
            n.v$n3 r8 = r5.co(r7)
            n.v$n3 r9 = n.v.n3.MATCH_CONSTRAINT
            if (r6 != r9) goto L60
            int r10 = r5.f11751w
            if (r10 == r7) goto L60
            if (r8 != r9) goto L60
            int r10 = r5.f11729p
            if (r10 == r7) goto L60
            r10 = 1
            goto L61
        L60:
            r10 = 0
        L61:
            if (r10 != 0) goto L97
            boolean r11 = r13.rv(r7)
            if (r11 == 0) goto L97
            boolean r11 = r5 instanceof n.f
            if (r11 != 0) goto L97
            if (r6 != r9) goto L7c
            int r11 = r5.f11751w
            if (r11 != 0) goto L7c
            if (r8 == r9) goto L7c
            boolean r11 = r5.en()
            if (r11 != 0) goto L7c
            r10 = 1
        L7c:
            if (r8 != r9) goto L8b
            int r11 = r5.f11729p
            if (r11 != 0) goto L8b
            if (r6 == r9) goto L8b
            boolean r11 = r5.en()
            if (r11 != 0) goto L8b
            r10 = 1
        L8b:
            if (r6 == r9) goto L8f
            if (r8 != r9) goto L97
        L8f:
            float r6 = r5.f11732q9
            r8 = 0
            int r6 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r6 <= 0) goto L97
            goto L98
        L97:
            r7 = r10
        L98:
            if (r7 == 0) goto L9b
            goto La0
        L9b:
            int r6 = c.n3.y.f3913f
            r12.y(r2, r5, r6)
        La0:
            int r4 = r4 + 1
            goto L12
        La4:
            r2.y()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: c.n3.n3(n.a):void");
    }

    public void v(n.a aVar) {
        this.y.clear();
        int size = aVar.f11684o0.size();
        for (int i = 0; i < size; i++) {
            n.v vVar = aVar.f11684o0.get(i);
            v.n3 n2 = vVar.n();
            v.n3 n3Var = v.n3.MATCH_CONSTRAINT;
            if (n2 == n3Var || vVar.vl() == n3Var) {
                this.y.add(vVar);
            }
        }
        aVar.hk();
    }

    public final boolean y(InterfaceC0040n3 interfaceC0040n3, n.v vVar, int i) {
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        this.f3911n3.y = vVar.n();
        this.f3911n3.f3921n3 = vVar.vl();
        this.f3911n3.f3924zn = vVar.qn();
        this.f3911n3.f3919gv = vVar.x4();
        y yVar = this.f3911n3;
        yVar.f3917c5 = false;
        yVar.f3920i9 = i;
        v.n3 n3Var = yVar.y;
        v.n3 n3Var2 = v.n3.MATCH_CONSTRAINT;
        if (n3Var == n3Var2) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (yVar.f3921n3 == n3Var2) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (z2 && vVar.f11732q9 > 0.0f) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (z3 && vVar.f11732q9 > 0.0f) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (z4 && vVar.f11722mt[0] == 4) {
            yVar.y = v.n3.FIXED;
        }
        if (z5 && vVar.f11722mt[1] == 4) {
            yVar.f3921n3 = v.n3.FIXED;
        }
        interfaceC0040n3.n3(vVar, yVar);
        vVar.cs(this.f3911n3.f3923v);
        vVar.g(this.f3911n3.f3916a);
        vVar.m(this.f3911n3.f3922s);
        vVar.nf(this.f3911n3.f3918fb);
        y yVar2 = this.f3911n3;
        yVar2.f3920i9 = y.f3913f;
        return yVar2.f3917c5;
    }

    public final void zn(n.a aVar, String str, int i, int i5) {
        int z62 = aVar.z6();
        int d2 = aVar.d();
        aVar.l(0);
        aVar.qj(0);
        aVar.cs(i);
        aVar.g(i5);
        aVar.l(z62);
        aVar.qj(d2);
        this.f3912zn.j3();
    }
}
