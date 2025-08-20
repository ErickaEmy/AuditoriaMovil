package c;

import c.n3;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import n.v;
/* loaded from: classes.dex */
public class v {

    /* renamed from: gv  reason: collision with root package name */
    public n.a f3935gv;
    public n.a y;

    /* renamed from: n3  reason: collision with root package name */
    public boolean f3936n3 = true;

    /* renamed from: zn  reason: collision with root package name */
    public boolean f3939zn = true;

    /* renamed from: v  reason: collision with root package name */
    public ArrayList<w> f3938v = new ArrayList<>();

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<tl> f3932a = new ArrayList<>();

    /* renamed from: fb  reason: collision with root package name */
    public n3.InterfaceC0040n3 f3934fb = null;

    /* renamed from: s  reason: collision with root package name */
    public n3.y f3937s = new n3.y();

    /* renamed from: c5  reason: collision with root package name */
    public ArrayList<tl> f3933c5 = new ArrayList<>();

    public v(n.a aVar) {
        this.y = aVar;
        this.f3935gv = aVar;
    }

    public boolean a(boolean z2) {
        boolean z3;
        boolean z4 = false;
        if (this.f3936n3 || this.f3939zn) {
            Iterator<n.v> it = this.y.f11684o0.iterator();
            while (it.hasNext()) {
                n.v next = it.next();
                next.t();
                next.y = false;
                next.f11749v.mt();
                next.f11686a.p();
            }
            this.y.t();
            n.a aVar = this.y;
            aVar.y = false;
            aVar.f11749v.mt();
            this.y.f11686a.p();
            this.f3939zn = false;
        }
        if (n3(this.f3935gv)) {
            return false;
        }
        this.y.ro(0);
        this.y.ix(0);
        v.n3 co2 = this.y.co(0);
        v.n3 co3 = this.y.co(1);
        if (this.f3936n3) {
            zn();
        }
        int o2 = this.y.o();
        int j2 = this.y.j();
        this.y.f11749v.f3946s.gv(o2);
        this.y.f11686a.f3946s.gv(j2);
        tl();
        v.n3 n3Var = v.n3.WRAP_CONTENT;
        if (co2 == n3Var || co3 == n3Var) {
            if (z2) {
                Iterator<w> it2 = this.f3938v.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    } else if (!it2.next().tl()) {
                        z2 = false;
                        break;
                    }
                }
            }
            if (z2 && co2 == v.n3.WRAP_CONTENT) {
                this.y.tg(v.n3.FIXED);
                n.a aVar2 = this.y;
                aVar2.cs(v(aVar2, 0));
                n.a aVar3 = this.y;
                aVar3.f11749v.f3947v.gv(aVar3.qn());
            }
            if (z2 && co3 == v.n3.WRAP_CONTENT) {
                this.y.x5(v.n3.FIXED);
                n.a aVar4 = this.y;
                aVar4.g(v(aVar4, 1));
                n.a aVar5 = this.y;
                aVar5.f11686a.f3947v.gv(aVar5.x4());
            }
        }
        n.a aVar6 = this.y;
        v.n3 n3Var2 = aVar6.f11726o[0];
        v.n3 n3Var3 = v.n3.FIXED;
        if (n3Var2 != n3Var3 && n3Var2 != v.n3.MATCH_PARENT) {
            z3 = false;
        } else {
            int qn2 = aVar6.qn() + o2;
            this.y.f11749v.f3941c5.gv(qn2);
            this.y.f11749v.f3947v.gv(qn2 - o2);
            tl();
            n.a aVar7 = this.y;
            v.n3 n3Var4 = aVar7.f11726o[1];
            if (n3Var4 == n3Var3 || n3Var4 == v.n3.MATCH_PARENT) {
                int x42 = aVar7.x4() + j2;
                this.y.f11686a.f3941c5.gv(x42);
                this.y.f11686a.f3947v.gv(x42 - j2);
            }
            tl();
            z3 = true;
        }
        Iterator<w> it3 = this.f3938v.iterator();
        while (it3.hasNext()) {
            w next2 = it3.next();
            if (next2.f3945n3 != this.y || next2.f3942fb) {
                next2.v();
            }
        }
        Iterator<w> it4 = this.f3938v.iterator();
        while (true) {
            if (it4.hasNext()) {
                w next3 = it4.next();
                if (z3 || next3.f3945n3 != this.y) {
                    if (!next3.f3946s.f3896i9) {
                        break;
                    }
                    if (!next3.f3941c5.f3896i9) {
                        if (!(next3 instanceof i9)) {
                            break;
                        }
                    }
                    if (!next3.f3947v.f3896i9 && !(next3 instanceof zn) && !(next3 instanceof i9)) {
                        break;
                    }
                }
            } else {
                z4 = true;
                break;
            }
        }
        this.y.tg(co2);
        this.y.x5(co3);
        return z4;
    }

    public final void c5(w wVar, int i, ArrayList<tl> arrayList) {
        for (gv gvVar : wVar.f3946s.f3893f) {
            if (gvVar instanceof a) {
                y((a) gvVar, i, 0, wVar.f3941c5, arrayList, null);
            } else if (gvVar instanceof w) {
                y(((w) gvVar).f3946s, i, 0, wVar.f3941c5, arrayList, null);
            }
        }
        for (gv gvVar2 : wVar.f3941c5.f3893f) {
            if (gvVar2 instanceof a) {
                y((a) gvVar2, i, 1, wVar.f3946s, arrayList, null);
            } else if (gvVar2 instanceof w) {
                y(((w) gvVar2).f3941c5, i, 1, wVar.f3946s, arrayList, null);
            }
        }
        if (i == 1) {
            for (gv gvVar3 : ((wz) wVar).f3953f.f3893f) {
                if (gvVar3 instanceof a) {
                    y((a) gvVar3, i, 2, null, arrayList, null);
                }
            }
        }
    }

    public void f() {
        this.f3939zn = true;
    }

    public boolean fb(boolean z2) {
        if (this.f3936n3) {
            Iterator<n.v> it = this.y.f11684o0.iterator();
            while (it.hasNext()) {
                n.v next = it.next();
                next.t();
                next.y = false;
                t tVar = next.f11749v;
                tVar.f3947v.f3896i9 = false;
                tVar.f3942fb = false;
                tVar.mt();
                wz wzVar = next.f11686a;
                wzVar.f3947v.f3896i9 = false;
                wzVar.f3942fb = false;
                wzVar.p();
            }
            this.y.t();
            n.a aVar = this.y;
            aVar.y = false;
            t tVar2 = aVar.f11749v;
            tVar2.f3947v.f3896i9 = false;
            tVar2.f3942fb = false;
            tVar2.mt();
            wz wzVar2 = this.y.f11686a;
            wzVar2.f3947v.f3896i9 = false;
            wzVar2.f3942fb = false;
            wzVar2.p();
            zn();
        }
        if (n3(this.f3935gv)) {
            return false;
        }
        this.y.ro(0);
        this.y.ix(0);
        this.y.f11749v.f3946s.gv(0);
        this.y.f11686a.f3946s.gv(0);
        return true;
    }

    public void gv(ArrayList<w> arrayList) {
        arrayList.clear();
        this.f3935gv.f11749v.a();
        this.f3935gv.f11686a.a();
        arrayList.add(this.f3935gv.f11749v);
        arrayList.add(this.f3935gv.f11686a);
        Iterator<n.v> it = this.f3935gv.f11684o0.iterator();
        HashSet hashSet = null;
        while (it.hasNext()) {
            n.v next = it.next();
            if (next instanceof n.fb) {
                arrayList.add(new i9(next));
            } else {
                if (next.en()) {
                    if (next.f11764zn == null) {
                        next.f11764zn = new zn(next, 0);
                    }
                    if (hashSet == null) {
                        hashSet = new HashSet();
                    }
                    hashSet.add(next.f11764zn);
                } else {
                    arrayList.add(next.f11749v);
                }
                if (next.u()) {
                    if (next.f11709gv == null) {
                        next.f11709gv = new zn(next, 1);
                    }
                    if (hashSet == null) {
                        hashSet = new HashSet();
                    }
                    hashSet.add(next.f11709gv);
                } else {
                    arrayList.add(next.f11686a);
                }
                if (next instanceof n.c5) {
                    arrayList.add(new f(next));
                }
            }
        }
        if (hashSet != null) {
            arrayList.addAll(hashSet);
        }
        Iterator<w> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            it2.next().a();
        }
        Iterator<w> it3 = arrayList.iterator();
        while (it3.hasNext()) {
            w next2 = it3.next();
            if (next2.f3945n3 != this.f3935gv) {
                next2.gv();
            }
        }
    }

    public void i9() {
        this.f3936n3 = true;
    }

    public final boolean n3(n.a aVar) {
        int i;
        v.n3 n3Var;
        int i5;
        v.n3 n3Var2;
        v.n3[] n3VarArr;
        v.n3 n3Var3;
        v.n3 n3Var4;
        v.n3 n3Var5;
        v.n3 n3Var6;
        Iterator<n.v> it = aVar.f11684o0.iterator();
        while (it.hasNext()) {
            n.v next = it.next();
            v.n3[] n3VarArr2 = next.f11726o;
            v.n3 n3Var7 = n3VarArr2[0];
            v.n3 n3Var8 = n3VarArr2[1];
            if (next.j5() == 8) {
                next.y = true;
            } else {
                if (next.f11734r < 1.0f && n3Var7 == v.n3.MATCH_CONSTRAINT) {
                    next.f11751w = 2;
                }
                if (next.f11703f3 < 1.0f && n3Var8 == v.n3.MATCH_CONSTRAINT) {
                    next.f11729p = 2;
                }
                if (next.z() > 0.0f) {
                    v.n3 n3Var9 = v.n3.MATCH_CONSTRAINT;
                    if (n3Var7 == n3Var9 && (n3Var8 == v.n3.WRAP_CONTENT || n3Var8 == v.n3.FIXED)) {
                        next.f11751w = 3;
                    } else if (n3Var8 == n3Var9 && (n3Var7 == v.n3.WRAP_CONTENT || n3Var7 == v.n3.FIXED)) {
                        next.f11729p = 3;
                    } else if (n3Var7 == n3Var9 && n3Var8 == n3Var9) {
                        if (next.f11751w == 0) {
                            next.f11751w = 3;
                        }
                        if (next.f11729p == 0) {
                            next.f11729p = 3;
                        }
                    }
                }
                v.n3 n3Var10 = v.n3.MATCH_CONSTRAINT;
                if (n3Var7 == n3Var10 && next.f11751w == 1 && (next.f11700ej.f11667a == null || next.f11687a8.f11667a == null)) {
                    n3Var7 = v.n3.WRAP_CONTENT;
                }
                v.n3 n3Var11 = n3Var7;
                if (n3Var8 == n3Var10 && next.f11729p == 1 && (next.f11747ud.f11667a == null || next.f11753x.f11667a == null)) {
                    n3Var8 = v.n3.WRAP_CONTENT;
                }
                v.n3 n3Var12 = n3Var8;
                t tVar = next.f11749v;
                tVar.f3943gv = n3Var11;
                int i6 = next.f11751w;
                tVar.y = i6;
                wz wzVar = next.f11686a;
                wzVar.f3943gv = n3Var12;
                int i8 = next.f11729p;
                wzVar.y = i8;
                v.n3 n3Var13 = v.n3.MATCH_PARENT;
                if ((n3Var11 != n3Var13 && n3Var11 != v.n3.FIXED && n3Var11 != v.n3.WRAP_CONTENT) || (n3Var12 != n3Var13 && n3Var12 != v.n3.FIXED && n3Var12 != v.n3.WRAP_CONTENT)) {
                    if (n3Var11 == n3Var10 && (n3Var12 == (n3Var6 = v.n3.WRAP_CONTENT) || n3Var12 == v.n3.FIXED)) {
                        if (i6 == 3) {
                            if (n3Var12 == n3Var6) {
                                t(next, n3Var6, 0, n3Var6, 0);
                            }
                            int x42 = next.x4();
                            v.n3 n3Var14 = v.n3.FIXED;
                            t(next, n3Var14, (int) ((x42 * next.f11732q9) + 0.5f), n3Var14, x42);
                            next.f11749v.f3947v.gv(next.qn());
                            next.f11686a.f3947v.gv(next.x4());
                            next.y = true;
                        } else if (i6 == 1) {
                            t(next, n3Var6, 0, n3Var12, 0);
                            next.f11749v.f3947v.f3910tl = next.qn();
                        } else if (i6 == 2) {
                            v.n3 n3Var15 = aVar.f11726o[0];
                            v.n3 n3Var16 = v.n3.FIXED;
                            if (n3Var15 == n3Var16 || n3Var15 == n3Var13) {
                                t(next, n3Var16, (int) ((next.f11734r * aVar.qn()) + 0.5f), n3Var12, next.x4());
                                next.f11749v.f3947v.gv(next.qn());
                                next.f11686a.f3947v.gv(next.x4());
                                next.y = true;
                            }
                        } else {
                            n.gv[] gvVarArr = next.f11710hw;
                            if (gvVarArr[0].f11667a == null || gvVarArr[1].f11667a == null) {
                                t(next, n3Var6, 0, n3Var12, 0);
                                next.f11749v.f3947v.gv(next.qn());
                                next.f11686a.f3947v.gv(next.x4());
                                next.y = true;
                            }
                        }
                    }
                    if (n3Var12 == n3Var10 && (n3Var11 == (n3Var5 = v.n3.WRAP_CONTENT) || n3Var11 == v.n3.FIXED)) {
                        if (i8 == 3) {
                            if (n3Var11 == n3Var5) {
                                t(next, n3Var5, 0, n3Var5, 0);
                            }
                            int qn2 = next.qn();
                            float f4 = next.f11732q9;
                            if (next.r() == -1) {
                                f4 = 1.0f / f4;
                            }
                            v.n3 n3Var17 = v.n3.FIXED;
                            t(next, n3Var17, qn2, n3Var17, (int) ((qn2 * f4) + 0.5f));
                            next.f11749v.f3947v.gv(next.qn());
                            next.f11686a.f3947v.gv(next.x4());
                            next.y = true;
                        } else if (i8 == 1) {
                            t(next, n3Var11, 0, n3Var5, 0);
                            next.f11686a.f3947v.f3910tl = next.x4();
                        } else if (i8 == 2) {
                            v.n3 n3Var18 = aVar.f11726o[1];
                            v.n3 n3Var19 = v.n3.FIXED;
                            if (n3Var18 == n3Var19 || n3Var18 == n3Var13) {
                                t(next, n3Var11, next.qn(), n3Var19, (int) ((next.f11703f3 * aVar.x4()) + 0.5f));
                                next.f11749v.f3947v.gv(next.qn());
                                next.f11686a.f3947v.gv(next.x4());
                                next.y = true;
                            }
                        } else {
                            n.gv[] gvVarArr2 = next.f11710hw;
                            if (gvVarArr2[2].f11667a == null || gvVarArr2[3].f11667a == null) {
                                t(next, n3Var5, 0, n3Var12, 0);
                                next.f11749v.f3947v.gv(next.qn());
                                next.f11686a.f3947v.gv(next.x4());
                                next.y = true;
                            }
                        }
                    }
                    if (n3Var11 == n3Var10 && n3Var12 == n3Var10) {
                        if (i6 != 1 && i8 != 1) {
                            if (i8 == 2 && i6 == 2 && ((n3Var3 = (n3VarArr = aVar.f11726o)[0]) == (n3Var4 = v.n3.FIXED) || n3Var3 == n3Var4)) {
                                v.n3 n3Var20 = n3VarArr[1];
                                if (n3Var20 == n3Var4 || n3Var20 == n3Var4) {
                                    t(next, n3Var4, (int) ((next.f11734r * aVar.qn()) + 0.5f), n3Var4, (int) ((next.f11703f3 * aVar.x4()) + 0.5f));
                                    next.f11749v.f3947v.gv(next.qn());
                                    next.f11686a.f3947v.gv(next.x4());
                                    next.y = true;
                                }
                            }
                        } else {
                            v.n3 n3Var21 = v.n3.WRAP_CONTENT;
                            t(next, n3Var21, 0, n3Var21, 0);
                            next.f11749v.f3947v.f3910tl = next.qn();
                            next.f11686a.f3947v.f3910tl = next.x4();
                        }
                    }
                } else {
                    int qn3 = next.qn();
                    if (n3Var11 == n3Var13) {
                        i = (aVar.qn() - next.f11700ej.f11669fb) - next.f11687a8.f11669fb;
                        n3Var = v.n3.FIXED;
                    } else {
                        i = qn3;
                        n3Var = n3Var11;
                    }
                    int x43 = next.x4();
                    if (n3Var12 == n3Var13) {
                        i5 = (aVar.x4() - next.f11747ud.f11669fb) - next.f11753x.f11669fb;
                        n3Var2 = v.n3.FIXED;
                    } else {
                        i5 = x43;
                        n3Var2 = n3Var12;
                    }
                    t(next, n3Var, i, n3Var2, i5);
                    next.f11749v.f3947v.gv(next.qn());
                    next.f11686a.f3947v.gv(next.x4());
                    next.y = true;
                }
            }
        }
        return false;
    }

    public boolean s(boolean z2, int i) {
        boolean z3;
        v.n3 n3Var;
        boolean z4 = false;
        v.n3 co2 = this.y.co(0);
        v.n3 co3 = this.y.co(1);
        int o2 = this.y.o();
        int j2 = this.y.j();
        if (z2 && (co2 == (n3Var = v.n3.WRAP_CONTENT) || co3 == n3Var)) {
            Iterator<w> it = this.f3938v.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                w next = it.next();
                if (next.f3940a == i && !next.tl()) {
                    z2 = false;
                    break;
                }
            }
            if (i == 0) {
                if (z2 && co2 == v.n3.WRAP_CONTENT) {
                    this.y.tg(v.n3.FIXED);
                    n.a aVar = this.y;
                    aVar.cs(v(aVar, 0));
                    n.a aVar2 = this.y;
                    aVar2.f11749v.f3947v.gv(aVar2.qn());
                }
            } else if (z2 && co3 == v.n3.WRAP_CONTENT) {
                this.y.x5(v.n3.FIXED);
                n.a aVar3 = this.y;
                aVar3.g(v(aVar3, 1));
                n.a aVar4 = this.y;
                aVar4.f11686a.f3947v.gv(aVar4.x4());
            }
        }
        if (i == 0) {
            n.a aVar5 = this.y;
            v.n3 n3Var2 = aVar5.f11726o[0];
            if (n3Var2 == v.n3.FIXED || n3Var2 == v.n3.MATCH_PARENT) {
                int qn2 = aVar5.qn() + o2;
                this.y.f11749v.f3941c5.gv(qn2);
                this.y.f11749v.f3947v.gv(qn2 - o2);
                z3 = true;
            }
            z3 = false;
        } else {
            n.a aVar6 = this.y;
            v.n3 n3Var3 = aVar6.f11726o[1];
            if (n3Var3 == v.n3.FIXED || n3Var3 == v.n3.MATCH_PARENT) {
                int x42 = aVar6.x4() + j2;
                this.y.f11686a.f3941c5.gv(x42);
                this.y.f11686a.f3947v.gv(x42 - j2);
                z3 = true;
            }
            z3 = false;
        }
        tl();
        Iterator<w> it2 = this.f3938v.iterator();
        while (it2.hasNext()) {
            w next2 = it2.next();
            if (next2.f3940a == i && (next2.f3945n3 != this.y || next2.f3942fb)) {
                next2.v();
            }
        }
        Iterator<w> it3 = this.f3938v.iterator();
        while (true) {
            if (it3.hasNext()) {
                w next3 = it3.next();
                if (next3.f3940a == i && (z3 || next3.f3945n3 != this.y)) {
                    if (!next3.f3946s.f3896i9) {
                        break;
                    } else if (!next3.f3941c5.f3896i9) {
                        break;
                    } else if (!(next3 instanceof zn) && !next3.f3947v.f3896i9) {
                        break;
                    }
                }
            } else {
                z4 = true;
                break;
            }
        }
        this.y.tg(co2);
        this.y.x5(co3);
        return z4;
    }

    public final void t(n.v vVar, v.n3 n3Var, int i, v.n3 n3Var2, int i5) {
        n3.y yVar = this.f3937s;
        yVar.y = n3Var;
        yVar.f3921n3 = n3Var2;
        yVar.f3924zn = i;
        yVar.f3919gv = i5;
        this.f3934fb.n3(vVar, yVar);
        vVar.cs(this.f3937s.f3923v);
        vVar.g(this.f3937s.f3916a);
        vVar.m(this.f3937s.f3922s);
        vVar.nf(this.f3937s.f3918fb);
    }

    public void tl() {
        boolean z2;
        fb fbVar;
        Iterator<n.v> it = this.y.f11684o0.iterator();
        while (it.hasNext()) {
            n.v next = it.next();
            if (!next.y) {
                v.n3[] n3VarArr = next.f11726o;
                boolean z3 = false;
                v.n3 n3Var = n3VarArr[0];
                v.n3 n3Var2 = n3VarArr[1];
                int i = next.f11751w;
                int i5 = next.f11729p;
                v.n3 n3Var3 = v.n3.WRAP_CONTENT;
                if (n3Var != n3Var3 && (n3Var != v.n3.MATCH_CONSTRAINT || i != 1)) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                if (n3Var2 == n3Var3 || (n3Var2 == v.n3.MATCH_CONSTRAINT && i5 == 1)) {
                    z3 = true;
                }
                fb fbVar2 = next.f11749v.f3947v;
                boolean z4 = fbVar2.f3896i9;
                fb fbVar3 = next.f11686a.f3947v;
                boolean z5 = fbVar3.f3896i9;
                if (z4 && z5) {
                    v.n3 n3Var4 = v.n3.FIXED;
                    t(next, n3Var4, fbVar2.f3894fb, n3Var4, fbVar3.f3894fb);
                    next.y = true;
                } else if (z4 && z3) {
                    t(next, v.n3.FIXED, fbVar2.f3894fb, n3Var3, fbVar3.f3894fb);
                    if (n3Var2 == v.n3.MATCH_CONSTRAINT) {
                        next.f11686a.f3947v.f3910tl = next.x4();
                    } else {
                        next.f11686a.f3947v.gv(next.x4());
                        next.y = true;
                    }
                } else if (z5 && z2) {
                    t(next, n3Var3, fbVar2.f3894fb, v.n3.FIXED, fbVar3.f3894fb);
                    if (n3Var == v.n3.MATCH_CONSTRAINT) {
                        next.f11749v.f3947v.f3910tl = next.qn();
                    } else {
                        next.f11749v.f3947v.gv(next.qn());
                        next.y = true;
                    }
                }
                if (next.y && (fbVar = next.f11686a.f3954t) != null) {
                    fbVar.gv(next.wz());
                }
            }
        }
    }

    public final int v(n.a aVar, int i) {
        int size = this.f3933c5.size();
        long j2 = 0;
        for (int i5 = 0; i5 < size; i5++) {
            j2 = Math.max(j2, this.f3933c5.get(i5).n3(aVar, i));
        }
        return (int) j2;
    }

    public void wz(n3.InterfaceC0040n3 interfaceC0040n3) {
        this.f3934fb = interfaceC0040n3;
    }

    public final void y(a aVar, int i, int i5, a aVar2, ArrayList<tl> arrayList, tl tlVar) {
        w wVar = aVar.f3895gv;
        if (wVar.f3948zn == null) {
            n.a aVar3 = this.y;
            if (wVar != aVar3.f11749v && wVar != aVar3.f11686a) {
                if (tlVar == null) {
                    tlVar = new tl(wVar, i5);
                    arrayList.add(tlVar);
                }
                wVar.f3948zn = tlVar;
                tlVar.y(wVar);
                for (gv gvVar : wVar.f3946s.f3893f) {
                    if (gvVar instanceof a) {
                        y((a) gvVar, i, 0, aVar2, arrayList, tlVar);
                    }
                }
                for (gv gvVar2 : wVar.f3941c5.f3893f) {
                    if (gvVar2 instanceof a) {
                        y((a) gvVar2, i, 1, aVar2, arrayList, tlVar);
                    }
                }
                if (i == 1 && (wVar instanceof wz)) {
                    for (gv gvVar3 : ((wz) wVar).f3953f.f3893f) {
                        if (gvVar3 instanceof a) {
                            y((a) gvVar3, i, 2, aVar2, arrayList, tlVar);
                        }
                    }
                }
                for (a aVar4 : wVar.f3946s.f3899t) {
                    if (aVar4 == aVar2) {
                        tlVar.y = true;
                    }
                    y(aVar4, i, 0, aVar2, arrayList, tlVar);
                }
                for (a aVar5 : wVar.f3941c5.f3899t) {
                    if (aVar5 == aVar2) {
                        tlVar.y = true;
                    }
                    y(aVar5, i, 1, aVar2, arrayList, tlVar);
                }
                if (i == 1 && (wVar instanceof wz)) {
                    for (a aVar6 : ((wz) wVar).f3953f.f3899t) {
                        y(aVar6, i, 2, aVar2, arrayList, tlVar);
                    }
                }
            }
        }
    }

    public void zn() {
        gv(this.f3938v);
        this.f3933c5.clear();
        tl.f3926fb = 0;
        c5(this.y.f11749v, 0, this.f3933c5);
        c5(this.y.f11686a, 1, this.f3933c5);
        this.f3936n3 = false;
    }
}
