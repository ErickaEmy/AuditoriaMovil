package androidx.recyclerview.widget;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
/* loaded from: classes.dex */
public class mt {
    public final z.s<RecyclerView.ta, y> y = new z.s<>();

    /* renamed from: n3  reason: collision with root package name */
    public final z.v<RecyclerView.ta> f3259n3 = new z.v<>();

    /* loaded from: classes.dex */
    public interface n3 {
        void gv(RecyclerView.ta taVar, @NonNull RecyclerView.tl.zn znVar, @NonNull RecyclerView.tl.zn znVar2);

        void n3(RecyclerView.ta taVar);

        void y(RecyclerView.ta taVar, @Nullable RecyclerView.tl.zn znVar, RecyclerView.tl.zn znVar2);

        void zn(RecyclerView.ta taVar, @NonNull RecyclerView.tl.zn znVar, @Nullable RecyclerView.tl.zn znVar2);
    }

    /* loaded from: classes.dex */
    public static class y {

        /* renamed from: gv  reason: collision with root package name */
        public static vl.v<y> f3260gv = new vl.a(20);
        @Nullable

        /* renamed from: n3  reason: collision with root package name */
        public RecyclerView.tl.zn f3261n3;
        public int y;
        @Nullable

        /* renamed from: zn  reason: collision with root package name */
        public RecyclerView.tl.zn f3262zn;

        public static y n3() {
            y n32 = f3260gv.n3();
            if (n32 == null) {
                return new y();
            }
            return n32;
        }

        public static void y() {
            do {
            } while (f3260gv.n3() != null);
        }

        public static void zn(y yVar) {
            yVar.y = 0;
            yVar.f3261n3 = null;
            yVar.f3262zn = null;
            f3260gv.y(yVar);
        }
    }

    public void a() {
        this.y.clear();
        this.f3259n3.zn();
    }

    public boolean c5(RecyclerView.ta taVar) {
        y yVar = this.y.get(taVar);
        if (yVar != null && (yVar.y & 4) != 0) {
            return true;
        }
        return false;
    }

    public void f(RecyclerView.ta taVar) {
        w(taVar);
    }

    public RecyclerView.ta fb(long j2) {
        return this.f3259n3.s(j2);
    }

    public void gv(RecyclerView.ta taVar, RecyclerView.tl.zn znVar) {
        y yVar = this.y.get(taVar);
        if (yVar == null) {
            yVar = y.n3();
            this.y.put(taVar, yVar);
        }
        yVar.f3262zn = znVar;
        yVar.y |= 8;
    }

    public void i9() {
        y.y();
    }

    public void n3(RecyclerView.ta taVar) {
        y yVar = this.y.get(taVar);
        if (yVar == null) {
            yVar = y.n3();
            this.y.put(taVar, yVar);
        }
        yVar.y |= 1;
    }

    public void p(RecyclerView.ta taVar) {
        int w4 = this.f3259n3.w() - 1;
        while (true) {
            if (w4 < 0) {
                break;
            } else if (taVar == this.f3259n3.p(w4)) {
                this.f3259n3.xc(w4);
                break;
            } else {
                w4--;
            }
        }
        y remove = this.y.remove(taVar);
        if (remove != null) {
            y.zn(remove);
        }
    }

    public boolean s(RecyclerView.ta taVar) {
        y yVar = this.y.get(taVar);
        if (yVar != null && (yVar.y & 1) != 0) {
            return true;
        }
        return false;
    }

    public final RecyclerView.tl.zn t(RecyclerView.ta taVar, int i) {
        y xc2;
        RecyclerView.tl.zn znVar;
        int s2 = this.y.s(taVar);
        if (s2 >= 0 && (xc2 = this.y.xc(s2)) != null) {
            int i5 = xc2.y;
            if ((i5 & i) != 0) {
                int i6 = (~i) & i5;
                xc2.y = i6;
                if (i == 4) {
                    znVar = xc2.f3261n3;
                } else if (i == 8) {
                    znVar = xc2.f3262zn;
                } else {
                    throw new IllegalArgumentException("Must provide flag PRE or POST");
                }
                if ((i6 & 12) == 0) {
                    this.y.tl(s2);
                    y.zn(xc2);
                }
                return znVar;
            }
        }
        return null;
    }

    @Nullable
    public RecyclerView.tl.zn tl(RecyclerView.ta taVar) {
        return t(taVar, 8);
    }

    public void v(RecyclerView.ta taVar, RecyclerView.tl.zn znVar) {
        y yVar = this.y.get(taVar);
        if (yVar == null) {
            yVar = y.n3();
            this.y.put(taVar, yVar);
        }
        yVar.f3261n3 = znVar;
        yVar.y |= 4;
    }

    public void w(RecyclerView.ta taVar) {
        y yVar = this.y.get(taVar);
        if (yVar == null) {
            return;
        }
        yVar.y &= -2;
    }

    @Nullable
    public RecyclerView.tl.zn wz(RecyclerView.ta taVar) {
        return t(taVar, 4);
    }

    public void xc(n3 n3Var) {
        for (int size = this.y.size() - 1; size >= 0; size--) {
            RecyclerView.ta f4 = this.y.f(size);
            y tl2 = this.y.tl(size);
            int i = tl2.y;
            if ((i & 3) == 3) {
                n3Var.n3(f4);
            } else if ((i & 1) != 0) {
                RecyclerView.tl.zn znVar = tl2.f3261n3;
                if (znVar == null) {
                    n3Var.n3(f4);
                } else {
                    n3Var.zn(f4, znVar, tl2.f3262zn);
                }
            } else if ((i & 14) == 14) {
                n3Var.y(f4, tl2.f3261n3, tl2.f3262zn);
            } else if ((i & 12) == 12) {
                n3Var.gv(f4, tl2.f3261n3, tl2.f3262zn);
            } else if ((i & 4) != 0) {
                n3Var.zn(f4, tl2.f3261n3, null);
            } else if ((i & 8) != 0) {
                n3Var.y(f4, tl2.f3261n3, tl2.f3262zn);
            }
            y.zn(tl2);
        }
    }

    public void y(RecyclerView.ta taVar, RecyclerView.tl.zn znVar) {
        y yVar = this.y.get(taVar);
        if (yVar == null) {
            yVar = y.n3();
            this.y.put(taVar, yVar);
        }
        yVar.y |= 2;
        yVar.f3261n3 = znVar;
    }

    public void zn(long j2, RecyclerView.ta taVar) {
        this.f3259n3.tl(j2, taVar);
    }
}
