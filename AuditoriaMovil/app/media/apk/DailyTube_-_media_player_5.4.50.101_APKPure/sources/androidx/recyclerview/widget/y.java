package androidx.recyclerview.widget;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.i9;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public final class y implements i9.y {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f3322a;

    /* renamed from: fb  reason: collision with root package name */
    public final i9 f3323fb;

    /* renamed from: gv  reason: collision with root package name */
    public final InterfaceC0026y f3324gv;

    /* renamed from: n3  reason: collision with root package name */
    public final ArrayList<n3> f3325n3;

    /* renamed from: s  reason: collision with root package name */
    public int f3326s;

    /* renamed from: v  reason: collision with root package name */
    public Runnable f3327v;
    public vl.v<n3> y;

    /* renamed from: zn  reason: collision with root package name */
    public final ArrayList<n3> f3328zn;

    /* loaded from: classes.dex */
    public static final class n3 {

        /* renamed from: gv  reason: collision with root package name */
        public int f3329gv;

        /* renamed from: n3  reason: collision with root package name */
        public int f3330n3;
        public int y;

        /* renamed from: zn  reason: collision with root package name */
        public Object f3331zn;

        public n3(int i, int i5, int i6, Object obj) {
            this.y = i;
            this.f3330n3 = i5;
            this.f3329gv = i6;
            this.f3331zn = obj;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof n3)) {
                return false;
            }
            n3 n3Var = (n3) obj;
            int i = this.y;
            if (i != n3Var.y) {
                return false;
            }
            if (i == 8 && Math.abs(this.f3329gv - this.f3330n3) == 1 && this.f3329gv == n3Var.f3330n3 && this.f3330n3 == n3Var.f3329gv) {
                return true;
            }
            if (this.f3329gv != n3Var.f3329gv || this.f3330n3 != n3Var.f3330n3) {
                return false;
            }
            Object obj2 = this.f3331zn;
            if (obj2 != null) {
                if (!obj2.equals(n3Var.f3331zn)) {
                    return false;
                }
            } else if (n3Var.f3331zn != null) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return (((this.y * 31) + this.f3330n3) * 31) + this.f3329gv;
        }

        public String toString() {
            return Integer.toHexString(System.identityHashCode(this)) + "[" + y() + ",s:" + this.f3330n3 + "c:" + this.f3329gv + ",p:" + this.f3331zn + "]";
        }

        public String y() {
            int i = this.y;
            if (i != 1) {
                if (i != 2) {
                    if (i != 4) {
                        if (i != 8) {
                            return "??";
                        }
                        return "mv";
                    }
                    return "up";
                }
                return "rm";
            }
            return "add";
        }
    }

    /* renamed from: androidx.recyclerview.widget.y$y  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0026y {
        RecyclerView.ta a(int i);

        void fb(int i, int i5);

        void gv(int i, int i5);

        void n3(n3 n3Var);

        void s(int i, int i5);

        void v(int i, int i5, Object obj);

        void y(int i, int i5);

        void zn(n3 n3Var);
    }

    public y(InterfaceC0026y interfaceC0026y) {
        this(interfaceC0026y, false);
    }

    public final void a(n3 n3Var) {
        boolean z2;
        char c2;
        int i = n3Var.f3330n3;
        int i5 = n3Var.f3329gv + i;
        char c4 = 65535;
        int i6 = i;
        int i8 = 0;
        while (i6 < i5) {
            if (this.f3324gv.a(i6) == null && !s(i6)) {
                if (c4 == 1) {
                    x4(y(2, i, i8, null));
                    z2 = true;
                } else {
                    z2 = false;
                }
                c2 = 0;
            } else {
                if (c4 == 0) {
                    f(y(2, i, i8, null));
                    z2 = true;
                } else {
                    z2 = false;
                }
                c2 = 1;
            }
            if (z2) {
                i6 -= i8;
                i5 -= i8;
                i8 = 1;
            } else {
                i8++;
            }
            i6++;
            c4 = c2;
        }
        if (i8 != n3Var.f3329gv) {
            n3(n3Var);
            n3Var = y(2, i, i8, null);
        }
        if (c4 == 0) {
            f(n3Var);
        } else {
            x4(n3Var);
        }
    }

    public final int c(int i, int i5) {
        int i6;
        int i8;
        for (int size = this.f3328zn.size() - 1; size >= 0; size--) {
            n3 n3Var = this.f3328zn.get(size);
            int i10 = n3Var.y;
            if (i10 == 8) {
                int i11 = n3Var.f3330n3;
                int i12 = n3Var.f3329gv;
                if (i11 < i12) {
                    i8 = i11;
                    i6 = i12;
                } else {
                    i6 = i11;
                    i8 = i12;
                }
                if (i >= i8 && i <= i6) {
                    if (i8 == i11) {
                        if (i5 == 1) {
                            n3Var.f3329gv = i12 + 1;
                        } else if (i5 == 2) {
                            n3Var.f3329gv = i12 - 1;
                        }
                        i++;
                    } else {
                        if (i5 == 1) {
                            n3Var.f3330n3 = i11 + 1;
                        } else if (i5 == 2) {
                            n3Var.f3330n3 = i11 - 1;
                        }
                        i--;
                    }
                } else if (i < i11) {
                    if (i5 == 1) {
                        n3Var.f3330n3 = i11 + 1;
                        n3Var.f3329gv = i12 + 1;
                    } else if (i5 == 2) {
                        n3Var.f3330n3 = i11 - 1;
                        n3Var.f3329gv = i12 - 1;
                    }
                }
            } else {
                int i13 = n3Var.f3330n3;
                if (i13 <= i) {
                    if (i10 == 1) {
                        i -= n3Var.f3329gv;
                    } else if (i10 == 2) {
                        i += n3Var.f3329gv;
                    }
                } else if (i5 == 1) {
                    n3Var.f3330n3 = i13 + 1;
                } else if (i5 == 2) {
                    n3Var.f3330n3 = i13 - 1;
                }
            }
        }
        for (int size2 = this.f3328zn.size() - 1; size2 >= 0; size2--) {
            n3 n3Var2 = this.f3328zn.get(size2);
            if (n3Var2.y == 8) {
                int i14 = n3Var2.f3329gv;
                if (i14 == n3Var2.f3330n3 || i14 < 0) {
                    this.f3328zn.remove(size2);
                    n3(n3Var2);
                }
            } else if (n3Var2.f3329gv <= 0) {
                this.f3328zn.remove(size2);
                n3(n3Var2);
            }
        }
        return i;
    }

    public void c5() {
        int size = this.f3328zn.size();
        for (int i = 0; i < size; i++) {
            this.f3324gv.zn(this.f3328zn.get(i));
        }
        f3(this.f3328zn);
        this.f3326s = 0;
    }

    public boolean co(int i, int i5) {
        if (i5 < 1) {
            return false;
        }
        this.f3325n3.add(y(1, i, i5, null));
        this.f3326s |= 1;
        if (this.f3325n3.size() != 1) {
            return false;
        }
        return true;
    }

    public final void f(n3 n3Var) {
        int i;
        int i5 = n3Var.y;
        if (i5 != 1 && i5 != 8) {
            int c2 = c(n3Var.f3330n3, i5);
            int i6 = n3Var.f3330n3;
            int i8 = n3Var.y;
            if (i8 != 2) {
                if (i8 == 4) {
                    i = 1;
                } else {
                    throw new IllegalArgumentException("op should be remove or update." + n3Var);
                }
            } else {
                i = 0;
            }
            int i10 = 1;
            for (int i11 = 1; i11 < n3Var.f3329gv; i11++) {
                int c4 = c(n3Var.f3330n3 + (i * i11), n3Var.y);
                int i12 = n3Var.y;
                if (i12 == 2 ? c4 == c2 : !(i12 != 4 || c4 != c2 + 1)) {
                    i10++;
                } else {
                    n3 y = y(i12, c2, i10, n3Var.f3331zn);
                    t(y, i6);
                    n3(y);
                    if (n3Var.y == 4) {
                        i6 += i10;
                    }
                    c2 = c4;
                    i10 = 1;
                }
            }
            Object obj = n3Var.f3331zn;
            n3(n3Var);
            if (i10 > 0) {
                n3 y2 = y(n3Var.y, c2, i10, obj);
                t(y2, i6);
                n3(y2);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("should not dispatch add or move for pre layout");
    }

    public void f3(List<n3> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            n3(list.get(i));
        }
        list.clear();
    }

    public final void fb(n3 n3Var) {
        int i = n3Var.f3330n3;
        int i5 = n3Var.f3329gv + i;
        int i6 = i;
        char c2 = 65535;
        int i8 = 0;
        while (i < i5) {
            if (this.f3324gv.a(i) == null && !s(i)) {
                if (c2 == 1) {
                    x4(y(4, i6, i8, n3Var.f3331zn));
                    i6 = i;
                    i8 = 0;
                }
                c2 = 0;
            } else {
                if (c2 == 0) {
                    f(y(4, i6, i8, n3Var.f3331zn));
                    i6 = i;
                    i8 = 0;
                }
                c2 = 1;
            }
            i8++;
            i++;
        }
        if (i8 != n3Var.f3329gv) {
            Object obj = n3Var.f3331zn;
            n3(n3Var);
            n3Var = y(4, i6, i8, obj);
        }
        if (c2 == 0) {
            f(n3Var);
        } else {
            x4(n3Var);
        }
    }

    public final void gv(n3 n3Var) {
        x4(n3Var);
    }

    public void i4() {
        this.f3323fb.n3(this.f3325n3);
        int size = this.f3325n3.size();
        for (int i = 0; i < size; i++) {
            n3 n3Var = this.f3325n3.get(i);
            int i5 = n3Var.y;
            if (i5 != 1) {
                if (i5 != 2) {
                    if (i5 != 4) {
                        if (i5 == 8) {
                            gv(n3Var);
                        }
                    } else {
                        fb(n3Var);
                    }
                } else {
                    a(n3Var);
                }
            } else {
                zn(n3Var);
            }
            Runnable runnable = this.f3327v;
            if (runnable != null) {
                runnable.run();
            }
        }
        this.f3325n3.clear();
    }

    public void i9() {
        c5();
        int size = this.f3325n3.size();
        for (int i = 0; i < size; i++) {
            n3 n3Var = this.f3325n3.get(i);
            int i5 = n3Var.y;
            if (i5 != 1) {
                if (i5 != 2) {
                    if (i5 != 4) {
                        if (i5 == 8) {
                            this.f3324gv.zn(n3Var);
                            this.f3324gv.y(n3Var.f3330n3, n3Var.f3329gv);
                        }
                    } else {
                        this.f3324gv.zn(n3Var);
                        this.f3324gv.v(n3Var.f3330n3, n3Var.f3329gv, n3Var.f3331zn);
                    }
                } else {
                    this.f3324gv.zn(n3Var);
                    this.f3324gv.s(n3Var.f3330n3, n3Var.f3329gv);
                }
            } else {
                this.f3324gv.zn(n3Var);
                this.f3324gv.fb(n3Var.f3330n3, n3Var.f3329gv);
            }
            Runnable runnable = this.f3327v;
            if (runnable != null) {
                runnable.run();
            }
        }
        f3(this.f3325n3);
        this.f3326s = 0;
    }

    public boolean mt(int i, int i5, Object obj) {
        if (i5 < 1) {
            return false;
        }
        this.f3325n3.add(y(4, i, i5, obj));
        this.f3326s |= 4;
        if (this.f3325n3.size() != 1) {
            return false;
        }
        return true;
    }

    public void n() {
        f3(this.f3325n3);
        f3(this.f3328zn);
        this.f3326s = 0;
    }

    @Override // androidx.recyclerview.widget.i9.y
    public void n3(n3 n3Var) {
        if (!this.f3322a) {
            n3Var.f3331zn = null;
            this.y.y(n3Var);
        }
    }

    public boolean p() {
        if (!this.f3328zn.isEmpty() && !this.f3325n3.isEmpty()) {
            return true;
        }
        return false;
    }

    public boolean r(int i, int i5) {
        if (i5 < 1) {
            return false;
        }
        this.f3325n3.add(y(2, i, i5, null));
        this.f3326s |= 2;
        if (this.f3325n3.size() != 1) {
            return false;
        }
        return true;
    }

    public final boolean s(int i) {
        int size = this.f3328zn.size();
        for (int i5 = 0; i5 < size; i5++) {
            n3 n3Var = this.f3328zn.get(i5);
            int i6 = n3Var.y;
            if (i6 == 8) {
                if (wz(n3Var.f3329gv, i5 + 1) == i) {
                    return true;
                }
            } else if (i6 == 1) {
                int i8 = n3Var.f3330n3;
                int i10 = n3Var.f3329gv + i8;
                while (i8 < i10) {
                    if (wz(i8, i5 + 1) == i) {
                        return true;
                    }
                    i8++;
                }
                continue;
            } else {
                continue;
            }
        }
        return false;
    }

    public void t(n3 n3Var, int i) {
        this.f3324gv.n3(n3Var);
        int i5 = n3Var.y;
        if (i5 != 2) {
            if (i5 == 4) {
                this.f3324gv.v(i, n3Var.f3329gv, n3Var.f3331zn);
                return;
            }
            throw new IllegalArgumentException("only remove and update ops can be dispatched in first pass");
        }
        this.f3324gv.s(i, n3Var.f3329gv);
    }

    public int tl(int i) {
        return wz(i, 0);
    }

    public int v(int i) {
        int size = this.f3325n3.size();
        for (int i5 = 0; i5 < size; i5++) {
            n3 n3Var = this.f3325n3.get(i5);
            int i6 = n3Var.y;
            if (i6 != 1) {
                if (i6 != 2) {
                    if (i6 == 8) {
                        int i8 = n3Var.f3330n3;
                        if (i8 == i) {
                            i = n3Var.f3329gv;
                        } else {
                            if (i8 < i) {
                                i--;
                            }
                            if (n3Var.f3329gv <= i) {
                                i++;
                            }
                        }
                    }
                } else {
                    int i10 = n3Var.f3330n3;
                    if (i10 <= i) {
                        int i11 = n3Var.f3329gv;
                        if (i10 + i11 > i) {
                            return -1;
                        }
                        i -= i11;
                    } else {
                        continue;
                    }
                }
            } else if (n3Var.f3330n3 <= i) {
                i += n3Var.f3329gv;
            }
        }
        return i;
    }

    public boolean w() {
        if (this.f3325n3.size() > 0) {
            return true;
        }
        return false;
    }

    public int wz(int i, int i5) {
        int size = this.f3328zn.size();
        while (i5 < size) {
            n3 n3Var = this.f3328zn.get(i5);
            int i6 = n3Var.y;
            if (i6 == 8) {
                int i8 = n3Var.f3330n3;
                if (i8 == i) {
                    i = n3Var.f3329gv;
                } else {
                    if (i8 < i) {
                        i--;
                    }
                    if (n3Var.f3329gv <= i) {
                        i++;
                    }
                }
            } else {
                int i10 = n3Var.f3330n3;
                if (i10 > i) {
                    continue;
                } else if (i6 == 2) {
                    int i11 = n3Var.f3329gv;
                    if (i < i10 + i11) {
                        return -1;
                    }
                    i -= i11;
                } else if (i6 == 1) {
                    i += n3Var.f3329gv;
                }
            }
            i5++;
        }
        return i;
    }

    public final void x4(n3 n3Var) {
        this.f3328zn.add(n3Var);
        int i = n3Var.y;
        if (i != 1) {
            if (i != 2) {
                if (i != 4) {
                    if (i == 8) {
                        this.f3324gv.y(n3Var.f3330n3, n3Var.f3329gv);
                        return;
                    }
                    throw new IllegalArgumentException("Unknown update op type for " + n3Var);
                }
                this.f3324gv.v(n3Var.f3330n3, n3Var.f3329gv, n3Var.f3331zn);
                return;
            }
            this.f3324gv.gv(n3Var.f3330n3, n3Var.f3329gv);
            return;
        }
        this.f3324gv.fb(n3Var.f3330n3, n3Var.f3329gv);
    }

    public boolean xc(int i) {
        if ((i & this.f3326s) != 0) {
            return true;
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.i9.y
    public n3 y(int i, int i5, int i6, Object obj) {
        n3 n32 = this.y.n3();
        if (n32 == null) {
            return new n3(i, i5, i6, obj);
        }
        n32.y = i;
        n32.f3330n3 = i5;
        n32.f3329gv = i6;
        n32.f3331zn = obj;
        return n32;
    }

    public boolean z(int i, int i5, int i6) {
        if (i == i5) {
            return false;
        }
        if (i6 == 1) {
            this.f3325n3.add(y(8, i, i5, null));
            this.f3326s |= 8;
            if (this.f3325n3.size() != 1) {
                return false;
            }
            return true;
        }
        throw new IllegalArgumentException("Moving more than 1 item is not supported yet");
    }

    public final void zn(n3 n3Var) {
        x4(n3Var);
    }

    public y(InterfaceC0026y interfaceC0026y, boolean z2) {
        this.y = new vl.a(30);
        this.f3325n3 = new ArrayList<>();
        this.f3328zn = new ArrayList<>();
        this.f3326s = 0;
        this.f3324gv = interfaceC0026y;
        this.f3322a = z2;
        this.f3323fb = new i9(this);
    }
}
