package androidx.recyclerview.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class n3 {
    public final InterfaceC0025n3 y;

    /* renamed from: n3  reason: collision with root package name */
    public final y f3263n3 = new y();

    /* renamed from: zn  reason: collision with root package name */
    public final List<View> f3264zn = new ArrayList();

    /* renamed from: androidx.recyclerview.widget.n3$n3  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0025n3 {
        void a();

        void addView(View view, int i);

        void c5(int i);

        int fb(View view);

        RecyclerView.ta gv(View view);

        void i9(View view, int i, ViewGroup.LayoutParams layoutParams);

        void n3(View view);

        void s(View view);

        void v(int i);

        View y(int i);

        int zn();
    }

    /* loaded from: classes.dex */
    public static class y {

        /* renamed from: n3  reason: collision with root package name */
        public y f3265n3;
        public long y;

        public boolean a(int i) {
            boolean z2;
            if (i >= 64) {
                zn();
                return this.f3265n3.a(i - 64);
            }
            long j2 = 1 << i;
            long j4 = this.y;
            if ((j4 & j2) != 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            long j6 = j4 & (~j2);
            this.y = j6;
            long j7 = j2 - 1;
            this.y = (j6 & j7) | Long.rotateRight((~j7) & j6, 1);
            y yVar = this.f3265n3;
            if (yVar != null) {
                if (yVar.gv(0)) {
                    s(63);
                }
                this.f3265n3.a(0);
            }
            return z2;
        }

        public void fb() {
            this.y = 0L;
            y yVar = this.f3265n3;
            if (yVar != null) {
                yVar.fb();
            }
        }

        public boolean gv(int i) {
            if (i >= 64) {
                zn();
                return this.f3265n3.gv(i - 64);
            } else if ((this.y & (1 << i)) != 0) {
                return true;
            } else {
                return false;
            }
        }

        public int n3(int i) {
            y yVar = this.f3265n3;
            if (yVar == null) {
                if (i >= 64) {
                    return Long.bitCount(this.y);
                }
                return Long.bitCount(this.y & ((1 << i) - 1));
            } else if (i < 64) {
                return Long.bitCount(this.y & ((1 << i) - 1));
            } else {
                return yVar.n3(i - 64) + Long.bitCount(this.y);
            }
        }

        public void s(int i) {
            if (i >= 64) {
                zn();
                this.f3265n3.s(i - 64);
                return;
            }
            this.y |= 1 << i;
        }

        public String toString() {
            if (this.f3265n3 == null) {
                return Long.toBinaryString(this.y);
            }
            return this.f3265n3.toString() + "xx" + Long.toBinaryString(this.y);
        }

        public void v(int i, boolean z2) {
            boolean z3;
            if (i >= 64) {
                zn();
                this.f3265n3.v(i - 64, z2);
                return;
            }
            long j2 = this.y;
            if ((Long.MIN_VALUE & j2) != 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            long j4 = (1 << i) - 1;
            this.y = ((j2 & (~j4)) << 1) | (j2 & j4);
            if (z2) {
                s(i);
            } else {
                y(i);
            }
            if (z3 || this.f3265n3 != null) {
                zn();
                this.f3265n3.v(0, z3);
            }
        }

        public void y(int i) {
            if (i >= 64) {
                y yVar = this.f3265n3;
                if (yVar != null) {
                    yVar.y(i - 64);
                    return;
                }
                return;
            }
            this.y &= ~(1 << i);
        }

        public final void zn() {
            if (this.f3265n3 == null) {
                this.f3265n3 = new y();
            }
        }
    }

    public n3(InterfaceC0025n3 interfaceC0025n3) {
        this.y = interfaceC0025n3;
    }

    public View a(int i) {
        return this.y.y(s(i));
    }

    public View c5(int i) {
        return this.y.y(i);
    }

    public void co(View view) {
        int fb2 = this.y.fb(view);
        if (fb2 >= 0) {
            if (this.f3263n3.gv(fb2)) {
                this.f3263n3.y(fb2);
                z(view);
                return;
            }
            throw new RuntimeException("trying to unhide a view that was not hidden" + view);
        }
        throw new IllegalArgumentException("view is not a child, cannot hide " + view);
    }

    public void f(View view) {
        int fb2 = this.y.fb(view);
        if (fb2 >= 0) {
            this.f3263n3.s(fb2);
            t(view);
            return;
        }
        throw new IllegalArgumentException("view is not a child, cannot hide " + view);
    }

    public int fb() {
        return this.y.zn() - this.f3264zn.size();
    }

    public void gv(int i) {
        int s2 = s(i);
        this.f3263n3.a(s2);
        this.y.v(s2);
    }

    public int i9() {
        return this.y.zn();
    }

    public boolean mt(View view) {
        int fb2 = this.y.fb(view);
        if (fb2 == -1) {
            z(view);
            return true;
        } else if (this.f3263n3.gv(fb2)) {
            this.f3263n3.a(fb2);
            z(view);
            this.y.c5(fb2);
            return true;
        } else {
            return false;
        }
    }

    public void n3(View view, boolean z2) {
        y(view, -1, z2);
    }

    public void p(int i) {
        int s2 = s(i);
        View y2 = this.y.y(s2);
        if (y2 == null) {
            return;
        }
        if (this.f3263n3.a(s2)) {
            z(y2);
        }
        this.y.c5(s2);
    }

    public final int s(int i) {
        if (i < 0) {
            return -1;
        }
        int zn2 = this.y.zn();
        int i5 = i;
        while (i5 < zn2) {
            int n32 = i - (i5 - this.f3263n3.n3(i5));
            if (n32 == 0) {
                while (this.f3263n3.gv(i5)) {
                    i5++;
                }
                return i5;
            }
            i5 += n32;
        }
        return -1;
    }

    public final void t(View view) {
        this.f3264zn.add(view);
        this.y.n3(view);
    }

    public int tl(View view) {
        int fb2 = this.y.fb(view);
        if (fb2 == -1 || this.f3263n3.gv(fb2)) {
            return -1;
        }
        return fb2 - this.f3263n3.n3(fb2);
    }

    public String toString() {
        return this.f3263n3.toString() + ", hidden list:" + this.f3264zn.size();
    }

    public View v(int i) {
        int size = this.f3264zn.size();
        for (int i5 = 0; i5 < size; i5++) {
            View view = this.f3264zn.get(i5);
            RecyclerView.ta gv2 = this.y.gv(view);
            if (gv2.getLayoutPosition() == i && !gv2.isInvalid() && !gv2.isRemoved()) {
                return view;
            }
        }
        return null;
    }

    public void w(View view) {
        int fb2 = this.y.fb(view);
        if (fb2 < 0) {
            return;
        }
        if (this.f3263n3.a(fb2)) {
            z(view);
        }
        this.y.c5(fb2);
    }

    public boolean wz(View view) {
        return this.f3264zn.contains(view);
    }

    public void xc() {
        this.f3263n3.fb();
        for (int size = this.f3264zn.size() - 1; size >= 0; size--) {
            this.y.s(this.f3264zn.get(size));
            this.f3264zn.remove(size);
        }
        this.y.a();
    }

    public void y(View view, int i, boolean z2) {
        int s2;
        if (i < 0) {
            s2 = this.y.zn();
        } else {
            s2 = s(i);
        }
        this.f3263n3.v(s2, z2);
        if (z2) {
            t(view);
        }
        this.y.addView(view, s2);
    }

    public final boolean z(View view) {
        if (this.f3264zn.remove(view)) {
            this.y.s(view);
            return true;
        }
        return false;
    }

    public void zn(View view, int i, ViewGroup.LayoutParams layoutParams, boolean z2) {
        int s2;
        if (i < 0) {
            s2 = this.y.zn();
        } else {
            s2 = s(i);
        }
        this.f3263n3.v(s2, z2);
        if (z2) {
            t(view);
        }
        this.y.i9(view, s2, layoutParams);
    }
}
