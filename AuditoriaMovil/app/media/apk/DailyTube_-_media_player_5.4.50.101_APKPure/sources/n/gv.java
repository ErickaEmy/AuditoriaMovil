package n;

import c.xc;
import f3.c5;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
/* loaded from: classes.dex */
public class gv {

    /* renamed from: a  reason: collision with root package name */
    public gv f11667a;

    /* renamed from: c5  reason: collision with root package name */
    public f3.c5 f11668c5;

    /* renamed from: fb  reason: collision with root package name */
    public int f11669fb;

    /* renamed from: gv  reason: collision with root package name */
    public final v f11670gv;

    /* renamed from: n3  reason: collision with root package name */
    public int f11671n3;

    /* renamed from: s  reason: collision with root package name */
    public int f11672s = -1;

    /* renamed from: v  reason: collision with root package name */
    public final n3 f11673v;
    public HashSet<gv> y;

    /* renamed from: zn  reason: collision with root package name */
    public boolean f11674zn;

    /* loaded from: classes.dex */
    public enum n3 {
        NONE,
        LEFT,
        TOP,
        RIGHT,
        BOTTOM,
        BASELINE,
        CENTER,
        CENTER_X,
        CENTER_Y
    }

    /* loaded from: classes.dex */
    public static /* synthetic */ class y {
        public static final /* synthetic */ int[] y;

        static {
            int[] iArr = new int[n3.values().length];
            y = iArr;
            try {
                iArr[n3.CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                y[n3.LEFT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                y[n3.RIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                y[n3.TOP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                y[n3.BOTTOM.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                y[n3.BASELINE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                y[n3.CENTER_X.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                y[n3.CENTER_Y.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                y[n3.NONE.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    public gv(v vVar, n3 n3Var) {
        this.f11670gv = vVar;
        this.f11673v = n3Var;
    }

    public final gv a() {
        switch (y.y[this.f11673v.ordinal()]) {
            case 1:
            case 6:
            case 7:
            case 8:
            case 9:
                return null;
            case 2:
                return this.f11670gv.f11687a8;
            case 3:
                return this.f11670gv.f11700ej;
            case 4:
                return this.f11670gv.f11753x;
            case 5:
                return this.f11670gv.f11747ud;
            default:
                throw new AssertionError(this.f11673v.name());
        }
    }

    public gv c5() {
        return this.f11667a;
    }

    public void co(int i) {
        this.f11671n3 = i;
        this.f11674zn = true;
    }

    public boolean f() {
        HashSet<gv> hashSet = this.y;
        if (hashSet == null) {
            return false;
        }
        Iterator<gv> it = hashSet.iterator();
        while (it.hasNext()) {
            if (it.next().a().wz()) {
                return true;
            }
        }
        return false;
    }

    public v fb() {
        return this.f11670gv;
    }

    public int gv() {
        if (!this.f11674zn) {
            return 0;
        }
        return this.f11671n3;
    }

    public n3 i9() {
        return this.f11673v;
    }

    public void mt(f3.zn znVar) {
        f3.c5 c5Var = this.f11668c5;
        if (c5Var == null) {
            this.f11668c5 = new f3.c5(c5.y.UNRESTRICTED, null);
        } else {
            c5Var.gv();
        }
    }

    public void n3(int i, ArrayList<xc> arrayList, xc xcVar) {
        HashSet<gv> hashSet = this.y;
        if (hashSet != null) {
            Iterator<gv> it = hashSet.iterator();
            while (it.hasNext()) {
                c.c5.y(it.next().f11670gv, i, arrayList, xcVar);
            }
        }
    }

    public void p() {
        this.f11674zn = false;
        this.f11671n3 = 0;
    }

    public f3.c5 s() {
        return this.f11668c5;
    }

    public boolean t() {
        HashSet<gv> hashSet = this.y;
        if (hashSet == null || hashSet.size() <= 0) {
            return false;
        }
        return true;
    }

    public boolean tl() {
        return this.f11674zn;
    }

    public String toString() {
        return this.f11670gv.mt() + ":" + this.f11673v.toString();
    }

    public int v() {
        gv gvVar;
        if (this.f11670gv.j5() == 8) {
            return 0;
        }
        if (this.f11672s > -1 && (gvVar = this.f11667a) != null && gvVar.f11670gv.j5() == 8) {
            return this.f11672s;
        }
        return this.f11669fb;
    }

    public void w() {
        HashSet<gv> hashSet;
        gv gvVar = this.f11667a;
        if (gvVar != null && (hashSet = gvVar.y) != null) {
            hashSet.remove(this);
            if (this.f11667a.y.size() == 0) {
                this.f11667a.y = null;
            }
        }
        this.y = null;
        this.f11667a = null;
        this.f11669fb = 0;
        this.f11672s = -1;
        this.f11674zn = false;
        this.f11671n3 = 0;
    }

    public boolean wz() {
        if (this.f11667a != null) {
            return true;
        }
        return false;
    }

    public boolean xc(gv gvVar) {
        boolean z2;
        boolean z3;
        boolean z4 = false;
        if (gvVar == null) {
            return false;
        }
        n3 i92 = gvVar.i9();
        n3 n3Var = this.f11673v;
        if (i92 == n3Var) {
            if (n3Var == n3.BASELINE && (!gvVar.fb().oz() || !fb().oz())) {
                return false;
            }
            return true;
        }
        switch (y.y[n3Var.ordinal()]) {
            case 1:
                if (i92 == n3.BASELINE || i92 == n3.CENTER_X || i92 == n3.CENTER_Y) {
                    return false;
                }
                return true;
            case 2:
            case 3:
                if (i92 != n3.LEFT && i92 != n3.RIGHT) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                if (gvVar.fb() instanceof fb) {
                    return (z2 || i92 == n3.CENTER_X) ? true : true;
                }
                return z2;
            case 4:
            case 5:
                if (i92 != n3.TOP && i92 != n3.BOTTOM) {
                    z3 = false;
                } else {
                    z3 = true;
                }
                if (gvVar.fb() instanceof fb) {
                    return (z3 || i92 == n3.CENTER_Y) ? true : true;
                }
                return z3;
            case 6:
            case 7:
            case 8:
            case 9:
                return false;
            default:
                throw new AssertionError(this.f11673v.name());
        }
    }

    public boolean y(gv gvVar, int i, int i5, boolean z2) {
        if (gvVar == null) {
            w();
            return true;
        } else if (!z2 && !xc(gvVar)) {
            return false;
        } else {
            this.f11667a = gvVar;
            if (gvVar.y == null) {
                gvVar.y = new HashSet<>();
            }
            HashSet<gv> hashSet = this.f11667a.y;
            if (hashSet != null) {
                hashSet.add(this);
            }
            if (i > 0) {
                this.f11669fb = i;
            } else {
                this.f11669fb = 0;
            }
            this.f11672s = i5;
            return true;
        }
    }

    public HashSet<gv> zn() {
        return this.y;
    }
}
