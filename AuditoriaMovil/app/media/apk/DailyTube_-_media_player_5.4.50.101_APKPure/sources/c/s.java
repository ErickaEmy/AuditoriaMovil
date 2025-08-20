package c;

import c.n3;
import java.util.ArrayList;
import java.util.Iterator;
import n.gv;
import n.v;
/* loaded from: classes.dex */
public class s {
    public static n3.y y = new n3.y();

    public static void a(n3.InterfaceC0040n3 interfaceC0040n3, n.v vVar) {
        float k52 = vVar.k5();
        int gv2 = vVar.f11747ud.f11667a.gv();
        int gv3 = vVar.f11753x.f11667a.gv();
        int v2 = vVar.f11747ud.v() + gv2;
        int v3 = gv3 - vVar.f11753x.v();
        if (gv2 == gv3) {
            k52 = 0.5f;
        } else {
            gv2 = v2;
            gv3 = v3;
        }
        int x42 = vVar.x4();
        int i = (gv3 - gv2) - x42;
        if (gv2 > gv3) {
            i = (gv2 - gv3) - x42;
        }
        int i5 = (int) ((k52 * i) + 0.5f);
        int i6 = gv2 + i5;
        int i8 = i6 + x42;
        if (gv2 > gv3) {
            i6 = gv2 - i5;
            i8 = i6 - x42;
        }
        vVar.rb(i6, i8);
        c5(vVar, interfaceC0040n3);
    }

    public static void c5(n.v vVar, n3.InterfaceC0040n3 interfaceC0040n3) {
        boolean z2;
        n.gv gvVar;
        n.gv gvVar2;
        n.gv gvVar3;
        n.gv gvVar4;
        n.gv gvVar5;
        if (!(vVar instanceof n.a) && vVar.xg() && y(vVar)) {
            n.a.i(vVar, interfaceC0040n3, new n3.y(), n3.y.f3913f);
        }
        n.gv tl2 = vVar.tl(gv.n3.TOP);
        n.gv tl3 = vVar.tl(gv.n3.BOTTOM);
        int gv2 = tl2.gv();
        int gv3 = tl3.gv();
        if (tl2.zn() != null && tl2.tl()) {
            Iterator<n.gv> it = tl2.zn().iterator();
            while (it.hasNext()) {
                n.gv next = it.next();
                n.v vVar2 = next.f11670gv;
                boolean y2 = y(vVar2);
                if (vVar2.xg() && y2) {
                    n.a.i(vVar2, interfaceC0040n3, new n3.y(), n3.y.f3913f);
                }
                v.n3 vl2 = vVar2.vl();
                v.n3 n3Var = v.n3.MATCH_CONSTRAINT;
                if (vl2 == n3Var && !y2) {
                    if (vVar2.vl() == n3Var && vVar2.f11711i4 >= 0 && vVar2.f11754x4 >= 0 && (vVar2.j5() == 8 || (vVar2.f11729p == 0 && vVar2.z() == 0.0f))) {
                        if (!vVar2.u() && !vVar2.y5() && ((next == vVar2.f11747ud && (gvVar5 = vVar2.f11753x.f11667a) != null && gvVar5.tl()) || (next == vVar2.f11753x && (gvVar4 = vVar2.f11747ud.f11667a) != null && gvVar4.tl()))) {
                            if (!vVar2.u()) {
                                fb(vVar, interfaceC0040n3, vVar2);
                            }
                        }
                    }
                } else if (!vVar2.xg()) {
                    n.gv gvVar6 = vVar2.f11747ud;
                    if (next == gvVar6 && vVar2.f11753x.f11667a == null) {
                        int v2 = gvVar6.v() + gv2;
                        vVar2.rb(v2, vVar2.x4() + v2);
                        c5(vVar2, interfaceC0040n3);
                    } else {
                        n.gv gvVar7 = vVar2.f11753x;
                        if (next == gvVar7 && gvVar7.f11667a == null) {
                            int v3 = gv2 - gvVar7.v();
                            vVar2.rb(v3 - vVar2.x4(), v3);
                            c5(vVar2, interfaceC0040n3);
                        } else if (next == gvVar6 && (gvVar3 = gvVar7.f11667a) != null && gvVar3.tl()) {
                            a(interfaceC0040n3, vVar2);
                        }
                    }
                }
            }
        }
        if (vVar instanceof n.fb) {
            return;
        }
        if (tl3.zn() != null && tl3.tl()) {
            Iterator<n.gv> it2 = tl3.zn().iterator();
            while (it2.hasNext()) {
                n.gv next2 = it2.next();
                n.v vVar3 = next2.f11670gv;
                boolean y7 = y(vVar3);
                if (vVar3.xg() && y7) {
                    n.a.i(vVar3, interfaceC0040n3, new n3.y(), n3.y.f3913f);
                }
                if ((next2 == vVar3.f11747ud && (gvVar2 = vVar3.f11753x.f11667a) != null && gvVar2.tl()) || (next2 == vVar3.f11753x && (gvVar = vVar3.f11747ud.f11667a) != null && gvVar.tl())) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                v.n3 vl3 = vVar3.vl();
                v.n3 n3Var2 = v.n3.MATCH_CONSTRAINT;
                if (vl3 == n3Var2 && !y7) {
                    if (vVar3.vl() == n3Var2 && vVar3.f11711i4 >= 0 && vVar3.f11754x4 >= 0 && (vVar3.j5() == 8 || (vVar3.f11729p == 0 && vVar3.z() == 0.0f))) {
                        if (!vVar3.u() && !vVar3.y5() && z2 && !vVar3.u()) {
                            fb(vVar, interfaceC0040n3, vVar3);
                        }
                    }
                } else if (!vVar3.xg()) {
                    n.gv gvVar8 = vVar3.f11747ud;
                    if (next2 == gvVar8 && vVar3.f11753x.f11667a == null) {
                        int v4 = gvVar8.v() + gv3;
                        vVar3.rb(v4, vVar3.x4() + v4);
                        c5(vVar3, interfaceC0040n3);
                    } else {
                        n.gv gvVar9 = vVar3.f11753x;
                        if (next2 == gvVar9 && gvVar8.f11667a == null) {
                            int v6 = gv3 - gvVar9.v();
                            vVar3.rb(v6 - vVar3.x4(), v6);
                            c5(vVar3, interfaceC0040n3);
                        } else if (z2 && !vVar3.u()) {
                            a(interfaceC0040n3, vVar3);
                        }
                    }
                }
            }
        }
        n.gv tl4 = vVar.tl(gv.n3.BASELINE);
        if (tl4.zn() != null && tl4.tl()) {
            int gv4 = tl4.gv();
            Iterator<n.gv> it3 = tl4.zn().iterator();
            while (it3.hasNext()) {
                n.gv next3 = it3.next();
                n.v vVar4 = next3.f11670gv;
                boolean y8 = y(vVar4);
                if (vVar4.xg() && y8) {
                    n.a.i(vVar4, interfaceC0040n3, new n3.y(), n3.y.f3913f);
                }
                if (vVar4.vl() != v.n3.MATCH_CONSTRAINT || y8) {
                    if (!vVar4.xg() && next3 == vVar4.f11689b) {
                        vVar4.ap(gv4);
                        c5(vVar4, interfaceC0040n3);
                    }
                }
            }
        }
    }

    public static void fb(n.v vVar, n3.InterfaceC0040n3 interfaceC0040n3, n.v vVar2) {
        int x42;
        float k52 = vVar2.k5();
        int gv2 = vVar2.f11747ud.f11667a.gv() + vVar2.f11747ud.v();
        int gv3 = vVar2.f11753x.f11667a.gv() - vVar2.f11753x.v();
        if (gv3 >= gv2) {
            int x43 = vVar2.x4();
            if (vVar2.j5() != 8) {
                int i = vVar2.f11729p;
                if (i == 2) {
                    if (vVar instanceof n.a) {
                        x42 = vVar.x4();
                    } else {
                        x42 = vVar.ud().x4();
                    }
                    x43 = (int) (k52 * 0.5f * x42);
                } else if (i == 0) {
                    x43 = gv3 - gv2;
                }
                x43 = Math.max(vVar2.f11754x4, x43);
                int i5 = vVar2.f11711i4;
                if (i5 > 0) {
                    x43 = Math.min(i5, x43);
                }
            }
            int i6 = gv2 + ((int) ((k52 * ((gv3 - gv2) - x43)) + 0.5f));
            vVar2.rb(i6, x43 + i6);
            c5(vVar2, interfaceC0040n3);
        }
    }

    public static void gv(n3.InterfaceC0040n3 interfaceC0040n3, n.v vVar, boolean z2) {
        float i42 = vVar.i4();
        int gv2 = vVar.f11700ej.f11667a.gv();
        int gv3 = vVar.f11687a8.f11667a.gv();
        int v2 = vVar.f11700ej.v() + gv2;
        int v3 = gv3 - vVar.f11687a8.v();
        if (gv2 == gv3) {
            i42 = 0.5f;
        } else {
            gv2 = v2;
            gv3 = v3;
        }
        int qn2 = vVar.qn();
        int i = (gv3 - gv2) - qn2;
        if (gv2 > gv3) {
            i = (gv2 - gv3) - qn2;
        }
        int i5 = ((int) ((i42 * i) + 0.5f)) + gv2;
        int i6 = i5 + qn2;
        if (gv2 > gv3) {
            i6 = i5 - qn2;
        }
        vVar.yg(i5, i6);
        n3(vVar, interfaceC0040n3, z2);
    }

    public static void n3(n.v vVar, n3.InterfaceC0040n3 interfaceC0040n3, boolean z2) {
        boolean z3;
        n.gv gvVar;
        n.gv gvVar2;
        n.gv gvVar3;
        n.gv gvVar4;
        n.gv gvVar5;
        if (!(vVar instanceof n.a) && vVar.xg() && y(vVar)) {
            n.a.i(vVar, interfaceC0040n3, new n3.y(), n3.y.f3913f);
        }
        n.gv tl2 = vVar.tl(gv.n3.LEFT);
        n.gv tl3 = vVar.tl(gv.n3.RIGHT);
        int gv2 = tl2.gv();
        int gv3 = tl3.gv();
        if (tl2.zn() != null && tl2.tl()) {
            Iterator<n.gv> it = tl2.zn().iterator();
            while (it.hasNext()) {
                n.gv next = it.next();
                n.v vVar2 = next.f11670gv;
                boolean y2 = y(vVar2);
                if (vVar2.xg() && y2) {
                    n.a.i(vVar2, interfaceC0040n3, new n3.y(), n3.y.f3913f);
                }
                v.n3 n2 = vVar2.n();
                v.n3 n3Var = v.n3.MATCH_CONSTRAINT;
                if (n2 == n3Var && !y2) {
                    if (vVar2.n() == n3Var && vVar2.f11762z >= 0 && vVar2.f11693co >= 0 && (vVar2.j5() == 8 || (vVar2.f11751w == 0 && vVar2.z() == 0.0f))) {
                        if (!vVar2.en() && !vVar2.y5() && ((next == vVar2.f11700ej && (gvVar5 = vVar2.f11687a8.f11667a) != null && gvVar5.tl()) || (next == vVar2.f11687a8 && (gvVar4 = vVar2.f11700ej.f11667a) != null && gvVar4.tl()))) {
                            if (!vVar2.en()) {
                                v(vVar, interfaceC0040n3, vVar2, z2);
                            }
                        }
                    }
                } else if (!vVar2.xg()) {
                    n.gv gvVar6 = vVar2.f11700ej;
                    if (next == gvVar6 && vVar2.f11687a8.f11667a == null) {
                        int v2 = gvVar6.v() + gv2;
                        vVar2.yg(v2, vVar2.qn() + v2);
                        n3(vVar2, interfaceC0040n3, z2);
                    } else {
                        n.gv gvVar7 = vVar2.f11687a8;
                        if (next == gvVar7 && gvVar6.f11667a == null) {
                            int v3 = gv2 - gvVar7.v();
                            vVar2.yg(v3 - vVar2.qn(), v3);
                            n3(vVar2, interfaceC0040n3, z2);
                        } else if (next == gvVar6 && (gvVar3 = gvVar7.f11667a) != null && gvVar3.tl() && !vVar2.en()) {
                            gv(interfaceC0040n3, vVar2, z2);
                        }
                    }
                }
            }
        }
        if (!(vVar instanceof n.fb) && tl3.zn() != null && tl3.tl()) {
            Iterator<n.gv> it2 = tl3.zn().iterator();
            while (it2.hasNext()) {
                n.gv next2 = it2.next();
                n.v vVar3 = next2.f11670gv;
                boolean y7 = y(vVar3);
                if (vVar3.xg() && y7) {
                    n.a.i(vVar3, interfaceC0040n3, new n3.y(), n3.y.f3913f);
                }
                if ((next2 == vVar3.f11700ej && (gvVar2 = vVar3.f11687a8.f11667a) != null && gvVar2.tl()) || (next2 == vVar3.f11687a8 && (gvVar = vVar3.f11700ej.f11667a) != null && gvVar.tl())) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                v.n3 n4 = vVar3.n();
                v.n3 n3Var2 = v.n3.MATCH_CONSTRAINT;
                if (n4 == n3Var2 && !y7) {
                    if (vVar3.n() == n3Var2 && vVar3.f11762z >= 0 && vVar3.f11693co >= 0 && (vVar3.j5() == 8 || (vVar3.f11751w == 0 && vVar3.z() == 0.0f))) {
                        if (!vVar3.en() && !vVar3.y5() && z3 && !vVar3.en()) {
                            v(vVar, interfaceC0040n3, vVar3, z2);
                        }
                    }
                } else if (!vVar3.xg()) {
                    n.gv gvVar8 = vVar3.f11700ej;
                    if (next2 == gvVar8 && vVar3.f11687a8.f11667a == null) {
                        int v4 = gvVar8.v() + gv3;
                        vVar3.yg(v4, vVar3.qn() + v4);
                        n3(vVar3, interfaceC0040n3, z2);
                    } else {
                        n.gv gvVar9 = vVar3.f11687a8;
                        if (next2 == gvVar9 && gvVar8.f11667a == null) {
                            int v6 = gv3 - gvVar9.v();
                            vVar3.yg(v6 - vVar3.qn(), v6);
                            n3(vVar3, interfaceC0040n3, z2);
                        } else if (z3 && !vVar3.en()) {
                            gv(interfaceC0040n3, vVar3, z2);
                        }
                    }
                }
            }
        }
    }

    public static void s(n.a aVar, n3.InterfaceC0040n3 interfaceC0040n3) {
        v.n3 n2 = aVar.n();
        v.n3 vl2 = aVar.vl();
        aVar.eb();
        ArrayList<n.v> vn2 = aVar.vn();
        int size = vn2.size();
        for (int i = 0; i < size; i++) {
            vn2.get(i).eb();
        }
        boolean gn = aVar.gn();
        if (n2 == v.n3.FIXED) {
            aVar.yg(0, aVar.qn());
        } else {
            aVar.yc(0);
        }
        boolean z2 = false;
        boolean z3 = false;
        for (int i5 = 0; i5 < size; i5++) {
            n.v vVar = vn2.get(i5);
            if (vVar instanceof n.fb) {
                n.fb fbVar = (n.fb) vVar;
                if (fbVar.j3() == 1) {
                    if (fbVar.ne() != -1) {
                        fbVar.nd(fbVar.ne());
                    } else if (fbVar.q() != -1 && aVar.dm()) {
                        fbVar.nd(aVar.qn() - fbVar.q());
                    } else if (aVar.dm()) {
                        fbVar.nd((int) ((fbVar.wm() * aVar.qn()) + 0.5f));
                    }
                    z2 = true;
                }
            } else if ((vVar instanceof n.y) && ((n.y) vVar).gf() == 0) {
                z3 = true;
            }
        }
        if (z2) {
            for (int i6 = 0; i6 < size; i6++) {
                n.v vVar2 = vn2.get(i6);
                if (vVar2 instanceof n.fb) {
                    n.fb fbVar2 = (n.fb) vVar2;
                    if (fbVar2.j3() == 1) {
                        n3(fbVar2, interfaceC0040n3, gn);
                    }
                }
            }
        }
        n3(aVar, interfaceC0040n3, gn);
        if (z3) {
            for (int i8 = 0; i8 < size; i8++) {
                n.v vVar3 = vn2.get(i8);
                if (vVar3 instanceof n.y) {
                    n.y yVar = (n.y) vVar3;
                    if (yVar.gf() == 0) {
                        zn(yVar, interfaceC0040n3, 0, gn);
                    }
                }
            }
        }
        if (vl2 == v.n3.FIXED) {
            aVar.rb(0, aVar.x4());
        } else {
            aVar.kp(0);
        }
        boolean z4 = false;
        boolean z5 = false;
        for (int i10 = 0; i10 < size; i10++) {
            n.v vVar4 = vn2.get(i10);
            if (vVar4 instanceof n.fb) {
                n.fb fbVar3 = (n.fb) vVar4;
                if (fbVar3.j3() == 0) {
                    if (fbVar3.ne() != -1) {
                        fbVar3.nd(fbVar3.ne());
                    } else if (fbVar3.q() != -1 && aVar.ct()) {
                        fbVar3.nd(aVar.x4() - fbVar3.q());
                    } else if (aVar.ct()) {
                        fbVar3.nd((int) ((fbVar3.wm() * aVar.x4()) + 0.5f));
                    }
                    z4 = true;
                }
            } else if ((vVar4 instanceof n.y) && ((n.y) vVar4).gf() == 1) {
                z5 = true;
            }
        }
        if (z4) {
            for (int i11 = 0; i11 < size; i11++) {
                n.v vVar5 = vn2.get(i11);
                if (vVar5 instanceof n.fb) {
                    n.fb fbVar4 = (n.fb) vVar5;
                    if (fbVar4.j3() == 0) {
                        c5(fbVar4, interfaceC0040n3);
                    }
                }
            }
        }
        c5(aVar, interfaceC0040n3);
        if (z5) {
            for (int i12 = 0; i12 < size; i12++) {
                n.v vVar6 = vn2.get(i12);
                if (vVar6 instanceof n.y) {
                    n.y yVar2 = (n.y) vVar6;
                    if (yVar2.gf() == 1) {
                        zn(yVar2, interfaceC0040n3, 1, gn);
                    }
                }
            }
        }
        for (int i13 = 0; i13 < size; i13++) {
            n.v vVar7 = vn2.get(i13);
            if (vVar7.xg() && y(vVar7)) {
                n.a.i(vVar7, interfaceC0040n3, y, n3.y.f3913f);
                n3(vVar7, interfaceC0040n3, gn);
                c5(vVar7, interfaceC0040n3);
            }
        }
    }

    public static void v(n.v vVar, n3.InterfaceC0040n3 interfaceC0040n3, n.v vVar2, boolean z2) {
        int qn2;
        float i42 = vVar2.i4();
        int gv2 = vVar2.f11700ej.f11667a.gv() + vVar2.f11700ej.v();
        int gv3 = vVar2.f11687a8.f11667a.gv() - vVar2.f11687a8.v();
        if (gv3 >= gv2) {
            int qn3 = vVar2.qn();
            if (vVar2.j5() != 8) {
                int i = vVar2.f11751w;
                if (i == 2) {
                    if (vVar instanceof n.a) {
                        qn2 = vVar.qn();
                    } else {
                        qn2 = vVar.ud().qn();
                    }
                    qn3 = (int) (vVar2.i4() * 0.5f * qn2);
                } else if (i == 0) {
                    qn3 = gv3 - gv2;
                }
                qn3 = Math.max(vVar2.f11693co, qn3);
                int i5 = vVar2.f11762z;
                if (i5 > 0) {
                    qn3 = Math.min(i5, qn3);
                }
            }
            int i6 = gv2 + ((int) ((i42 * ((gv3 - gv2) - qn3)) + 0.5f));
            vVar2.yg(i6, qn3 + i6);
            n3(vVar2, interfaceC0040n3, z2);
        }
    }

    public static boolean y(n.v vVar) {
        n.a aVar;
        boolean z2;
        boolean z3;
        v.n3 n2 = vVar.n();
        v.n3 vl2 = vVar.vl();
        if (vVar.ud() != null) {
            aVar = (n.a) vVar.ud();
        } else {
            aVar = null;
        }
        if (aVar != null) {
            aVar.n();
            v.n3 n3Var = v.n3.FIXED;
        }
        if (aVar != null) {
            aVar.vl();
            v.n3 n3Var2 = v.n3.FIXED;
        }
        v.n3 n3Var3 = v.n3.FIXED;
        if (n2 != n3Var3 && n2 != v.n3.WRAP_CONTENT && ((n2 != v.n3.MATCH_CONSTRAINT || vVar.f11751w != 0 || vVar.f11732q9 != 0.0f || !vVar.ut(0)) && !vVar.dm())) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (vl2 != n3Var3 && vl2 != v.n3.WRAP_CONTENT && ((vl2 != v.n3.MATCH_CONSTRAINT || vVar.f11729p != 0 || vVar.f11732q9 != 0.0f || !vVar.ut(1)) && !vVar.ct())) {
            z3 = false;
        } else {
            z3 = true;
        }
        if (vVar.f11732q9 > 0.0f && (z2 || z3)) {
            return true;
        }
        if (!z2 || !z3) {
            return false;
        }
        return true;
    }

    public static void zn(n.y yVar, n3.InterfaceC0040n3 interfaceC0040n3, int i, boolean z2) {
        if (yVar.ne()) {
            if (i == 0) {
                n3(yVar, interfaceC0040n3, z2);
            } else {
                c5(yVar, interfaceC0040n3);
            }
        }
    }
}
