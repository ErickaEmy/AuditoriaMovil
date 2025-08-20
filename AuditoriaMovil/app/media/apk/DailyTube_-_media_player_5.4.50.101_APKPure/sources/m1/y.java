package m1;

import android.util.Pair;
import m1.hy;
/* loaded from: classes.dex */
public abstract class y extends hy {

    /* renamed from: p  reason: collision with root package name */
    public final boolean f11325p;

    /* renamed from: t  reason: collision with root package name */
    public final int f11326t;

    /* renamed from: w  reason: collision with root package name */
    public final af.u f11327w;

    public y(boolean z2, af.u uVar) {
        this.f11325p = z2;
        this.f11327w = uVar;
        this.f11326t = uVar.getLength();
    }

    public static Object c(Object obj) {
        return ((Pair) obj).second;
    }

    public static Object d0(Object obj) {
        return ((Pair) obj).first;
    }

    public static Object rz(Object obj, Object obj2) {
        return Pair.create(obj, obj2);
    }

    @Override // m1.hy
    public final int a(Object obj) {
        int a2;
        if (!(obj instanceof Pair)) {
            return -1;
        }
        Object d02 = d0(obj);
        Object c2 = c(obj);
        int i42 = i4(d02);
        if (i42 == -1 || (a2 = ej(i42).a(c2)) == -1) {
            return -1;
        }
        return mg(i42) + a2;
    }

    @Override // m1.hy
    public int c5(int i, int i5, boolean z2) {
        int i6 = 0;
        if (this.f11325p) {
            if (i5 == 1) {
                i5 = 2;
            }
            z2 = false;
        }
        int n2 = n(i);
        int ta2 = ta(n2);
        hy ej2 = ej(n2);
        int i8 = i - ta2;
        if (i5 != 2) {
            i6 = i5;
        }
        int c52 = ej2.c5(i8, i6, z2);
        if (c52 != -1) {
            return ta2 + c52;
        }
        int d2 = d(n2, z2);
        while (d2 != -1 && ej(d2).r()) {
            d2 = d(d2, z2);
        }
        if (d2 != -1) {
            return ta(d2) + ej(d2).v(z2);
        }
        if (i5 != 2) {
            return -1;
        }
        return v(z2);
    }

    @Override // m1.hy
    public final hy.gv co(int i, hy.gv gvVar, long j2) {
        int n2 = n(i);
        int ta2 = ta(n2);
        int mg2 = mg(n2);
        ej(n2).co(i - ta2, gvVar, j2);
        Object fh2 = fh(n2);
        if (!hy.gv.f10789ej.equals(gvVar.y)) {
            fh2 = rz(fh2, gvVar.y);
        }
        gvVar.y = fh2;
        gvVar.f10808d0 += mg2;
        gvVar.f10812fh += mg2;
        return gvVar;
    }

    public final int d(int i, boolean z2) {
        if (z2) {
            return this.f11327w.r(i);
        }
        if (i < this.f11326t - 1) {
            return i + 1;
        }
        return -1;
    }

    public abstract hy ej(int i);

    @Override // m1.hy
    public final hy.n3 f(int i, hy.n3 n3Var, boolean z2) {
        int f32 = f3(i);
        int ta2 = ta(f32);
        ej(f32).f(i - mg(f32), n3Var, z2);
        n3Var.f10828fb += ta2;
        if (z2) {
            n3Var.f10831v = rz(fh(f32), v5.y.v(n3Var.f10831v));
        }
        return n3Var;
    }

    public abstract int f3(int i);

    @Override // m1.hy
    public int fb(boolean z2) {
        int i;
        int i5 = this.f11326t;
        if (i5 == 0) {
            return -1;
        }
        if (this.f11325p) {
            z2 = false;
        }
        if (z2) {
            i = this.f11327w.mt();
        } else {
            i = i5 - 1;
        }
        while (ej(i).r()) {
            i = z6(i, z2);
            if (i == -1) {
                return -1;
            }
        }
        return ta(i) + ej(i).fb(z2);
    }

    public abstract Object fh(int i);

    public abstract int i4(Object obj);

    public abstract int mg(int i);

    public abstract int n(int i);

    @Override // m1.hy
    public final Object p(int i) {
        int f32 = f3(i);
        return rz(fh(f32), ej(f32).p(i - mg(f32)));
    }

    @Override // m1.hy
    public final hy.n3 t(Object obj, hy.n3 n3Var) {
        Object d02 = d0(obj);
        Object c2 = c(obj);
        int i42 = i4(d02);
        int ta2 = ta(i42);
        ej(i42).t(c2, n3Var);
        n3Var.f10828fb += ta2;
        n3Var.f10831v = obj;
        return n3Var;
    }

    public abstract int ta(int i);

    @Override // m1.hy
    public int v(boolean z2) {
        if (this.f11326t == 0) {
            return -1;
        }
        int i = 0;
        if (this.f11325p) {
            z2 = false;
        }
        if (z2) {
            i = this.f11327w.i4();
        }
        while (ej(i).r()) {
            i = d(i, z2);
            if (i == -1) {
                return -1;
            }
        }
        return ta(i) + ej(i).v(z2);
    }

    @Override // m1.hy
    public int w(int i, int i5, boolean z2) {
        int i6 = 0;
        if (this.f11325p) {
            if (i5 == 1) {
                i5 = 2;
            }
            z2 = false;
        }
        int n2 = n(i);
        int ta2 = ta(n2);
        hy ej2 = ej(n2);
        int i8 = i - ta2;
        if (i5 != 2) {
            i6 = i5;
        }
        int w4 = ej2.w(i8, i6, z2);
        if (w4 != -1) {
            return ta2 + w4;
        }
        int z62 = z6(n2, z2);
        while (z62 != -1 && ej(z62).r()) {
            z62 = z6(z62, z2);
        }
        if (z62 != -1) {
            return ta(z62) + ej(z62).fb(z2);
        }
        if (i5 != 2) {
            return -1;
        }
        return fb(z2);
    }

    public final int z6(int i, boolean z2) {
        if (z2) {
            return this.f11327w.z(i);
        }
        if (i > 0) {
            return i - 1;
        }
        return -1;
    }
}
