package n;

import java.util.ArrayList;
import n.v;
/* loaded from: classes.dex */
public class zn {

    /* renamed from: a  reason: collision with root package name */
    public v f11774a;

    /* renamed from: c5  reason: collision with root package name */
    public int f11775c5;

    /* renamed from: co  reason: collision with root package name */
    public boolean f11776co;

    /* renamed from: f  reason: collision with root package name */
    public float f11777f;

    /* renamed from: fb  reason: collision with root package name */
    public v f11778fb;

    /* renamed from: gv  reason: collision with root package name */
    public v f11779gv;

    /* renamed from: i9  reason: collision with root package name */
    public int f11780i9;

    /* renamed from: mt  reason: collision with root package name */
    public boolean f11781mt;

    /* renamed from: n3  reason: collision with root package name */
    public v f11782n3;

    /* renamed from: p  reason: collision with root package name */
    public boolean f11783p;

    /* renamed from: r  reason: collision with root package name */
    public boolean f11784r;

    /* renamed from: s  reason: collision with root package name */
    public ArrayList<v> f11785s;

    /* renamed from: t  reason: collision with root package name */
    public int f11786t;

    /* renamed from: tl  reason: collision with root package name */
    public int f11787tl;

    /* renamed from: v  reason: collision with root package name */
    public v f11788v;

    /* renamed from: w  reason: collision with root package name */
    public int f11789w;

    /* renamed from: wz  reason: collision with root package name */
    public int f11790wz;

    /* renamed from: x4  reason: collision with root package name */
    public boolean f11791x4;

    /* renamed from: xc  reason: collision with root package name */
    public boolean f11792xc;
    public v y;

    /* renamed from: z  reason: collision with root package name */
    public boolean f11793z;

    /* renamed from: zn  reason: collision with root package name */
    public v f11794zn;

    public zn(v vVar, int i, boolean z2) {
        this.y = vVar;
        this.f11789w = i;
        this.f11783p = z2;
    }

    public static boolean zn(v vVar, int i) {
        int i5;
        if (vVar.j5() != 8 && vVar.f11726o[i] == v.n3.MATCH_CONSTRAINT && ((i5 = vVar.f11722mt[i]) == 0 || i5 == 3)) {
            return true;
        }
        return false;
    }

    public final void n3() {
        int i = this.f11789w * 2;
        v vVar = this.y;
        boolean z2 = true;
        this.f11792xc = true;
        v vVar2 = vVar;
        boolean z3 = false;
        while (!z3) {
            this.f11775c5++;
            v[] vVarArr = vVar.f11690bk;
            int i5 = this.f11789w;
            v vVar3 = null;
            vVarArr[i5] = null;
            vVar.f11746u0[i5] = null;
            if (vVar.j5() != 8) {
                this.f11786t++;
                v.n3 co2 = vVar.co(this.f11789w);
                v.n3 n3Var = v.n3.MATCH_CONSTRAINT;
                if (co2 != n3Var) {
                    this.f11787tl += vVar.rz(this.f11789w);
                }
                int v2 = this.f11787tl + vVar.f11710hw[i].v();
                this.f11787tl = v2;
                int i6 = i + 1;
                this.f11787tl = v2 + vVar.f11710hw[i6].v();
                int v3 = this.f11790wz + vVar.f11710hw[i].v();
                this.f11790wz = v3;
                this.f11790wz = v3 + vVar.f11710hw[i6].v();
                if (this.f11782n3 == null) {
                    this.f11782n3 = vVar;
                }
                this.f11779gv = vVar;
                v.n3[] n3VarArr = vVar.f11726o;
                int i8 = this.f11789w;
                if (n3VarArr[i8] == n3Var) {
                    int i10 = vVar.f11722mt[i8];
                    if (i10 == 0 || i10 == 3 || i10 == 2) {
                        this.f11780i9++;
                        float f4 = vVar.f11707g[i8];
                        if (f4 > 0.0f) {
                            this.f11777f += f4;
                        }
                        if (zn(vVar, i8)) {
                            if (f4 < 0.0f) {
                                this.f11781mt = true;
                            } else {
                                this.f11776co = true;
                            }
                            if (this.f11785s == null) {
                                this.f11785s = new ArrayList<>();
                            }
                            this.f11785s.add(vVar);
                        }
                        if (this.f11774a == null) {
                            this.f11774a = vVar;
                        }
                        v vVar4 = this.f11778fb;
                        if (vVar4 != null) {
                            vVar4.f11746u0[this.f11789w] = vVar;
                        }
                        this.f11778fb = vVar;
                    }
                    if (this.f11789w == 0) {
                        if (vVar.f11751w != 0) {
                            this.f11792xc = false;
                        } else if (vVar.f11693co != 0 || vVar.f11762z != 0) {
                            this.f11792xc = false;
                        }
                    } else if (vVar.f11729p != 0) {
                        this.f11792xc = false;
                    } else if (vVar.f11754x4 != 0 || vVar.f11711i4 != 0) {
                        this.f11792xc = false;
                    }
                    if (vVar.f11732q9 != 0.0f) {
                        this.f11792xc = false;
                        this.f11784r = true;
                    }
                }
            }
            if (vVar2 != vVar) {
                vVar2.f11690bk[this.f11789w] = vVar;
            }
            gv gvVar = vVar.f11710hw[i + 1].f11667a;
            if (gvVar != null) {
                v vVar5 = gvVar.f11670gv;
                gv gvVar2 = vVar5.f11710hw[i].f11667a;
                if (gvVar2 != null && gvVar2.f11670gv == vVar) {
                    vVar3 = vVar5;
                }
            }
            if (vVar3 == null) {
                vVar3 = vVar;
                z3 = true;
            }
            vVar2 = vVar;
            vVar = vVar3;
        }
        v vVar6 = this.f11782n3;
        if (vVar6 != null) {
            this.f11787tl -= vVar6.f11710hw[i].v();
        }
        v vVar7 = this.f11779gv;
        if (vVar7 != null) {
            this.f11787tl -= vVar7.f11710hw[i + 1].v();
        }
        this.f11794zn = vVar;
        if (this.f11789w == 0 && this.f11783p) {
            this.f11788v = vVar;
        } else {
            this.f11788v = this.y;
        }
        this.f11793z = (this.f11776co && this.f11781mt) ? false : false;
    }

    public void y() {
        if (!this.f11791x4) {
            n3();
        }
        this.f11791x4 = true;
    }
}
