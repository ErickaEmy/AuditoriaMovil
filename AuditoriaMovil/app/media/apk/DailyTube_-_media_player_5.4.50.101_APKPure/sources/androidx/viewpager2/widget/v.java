package androidx.viewpager2.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import java.util.Locale;
/* loaded from: classes.dex */
public final class v extends RecyclerView.r {

    /* renamed from: a  reason: collision with root package name */
    public int f3664a;

    /* renamed from: c5  reason: collision with root package name */
    public int f3665c5;

    /* renamed from: f  reason: collision with root package name */
    public boolean f3666f;

    /* renamed from: fb  reason: collision with root package name */
    public y f3667fb;
    @NonNull

    /* renamed from: gv  reason: collision with root package name */
    public final LinearLayoutManager f3668gv;

    /* renamed from: i9  reason: collision with root package name */
    public boolean f3669i9;
    @NonNull

    /* renamed from: n3  reason: collision with root package name */
    public final ViewPager2 f3670n3;

    /* renamed from: s  reason: collision with root package name */
    public int f3671s;

    /* renamed from: t  reason: collision with root package name */
    public boolean f3672t;

    /* renamed from: tl  reason: collision with root package name */
    public boolean f3673tl;

    /* renamed from: v  reason: collision with root package name */
    public int f3674v;
    public ViewPager2.c5 y;
    @NonNull

    /* renamed from: zn  reason: collision with root package name */
    public final RecyclerView f3675zn;

    /* loaded from: classes.dex */
    public static final class y {

        /* renamed from: n3  reason: collision with root package name */
        public float f3676n3;
        public int y;

        /* renamed from: zn  reason: collision with root package name */
        public int f3677zn;

        public void y() {
            this.y = -1;
            this.f3676n3 = 0.0f;
            this.f3677zn = 0;
        }
    }

    public v(@NonNull ViewPager2 viewPager2) {
        this.f3670n3 = viewPager2;
        RecyclerView recyclerView = viewPager2.f3652z;
        this.f3675zn = recyclerView;
        this.f3668gv = (LinearLayoutManager) recyclerView.getLayoutManager();
        this.f3667fb = new y();
        wz();
    }

    public final int a() {
        return this.f3668gv.e5();
    }

    public boolean c5() {
        return this.f3673tl;
    }

    public final boolean f() {
        int i = this.f3674v;
        if (i == 1 || i == 4) {
            return true;
        }
        return false;
    }

    public double fb() {
        p();
        y yVar = this.f3667fb;
        return yVar.y + yVar.f3676n3;
    }

    public final void gv(int i) {
        ViewPager2.c5 c5Var = this.y;
        if (c5Var != null) {
            c5Var.onPageSelected(i);
        }
    }

    public boolean i9() {
        if (this.f3664a == 0) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x001d, code lost:
        if (r5 == r3.f3670n3.gv()) goto L31;
     */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0033  */
    @Override // androidx.recyclerview.widget.RecyclerView.r
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void n3(@androidx.annotation.NonNull androidx.recyclerview.widget.RecyclerView r4, int r5, int r6) {
        /*
            r3 = this;
            r4 = 1
            r3.f3666f = r4
            r3.p()
            boolean r0 = r3.f3669i9
            r1 = -1
            r2 = 0
            if (r0 == 0) goto L37
            r3.f3669i9 = r2
            if (r6 > 0) goto L1f
            if (r6 != 0) goto L29
            if (r5 >= 0) goto L16
            r5 = 1
            goto L17
        L16:
            r5 = 0
        L17:
            androidx.viewpager2.widget.ViewPager2 r6 = r3.f3670n3
            boolean r6 = r6.gv()
            if (r5 != r6) goto L29
        L1f:
            androidx.viewpager2.widget.v$y r5 = r3.f3667fb
            int r6 = r5.f3677zn
            if (r6 == 0) goto L29
            int r5 = r5.y
            int r5 = r5 + r4
            goto L2d
        L29:
            androidx.viewpager2.widget.v$y r5 = r3.f3667fb
            int r5 = r5.y
        L2d:
            r3.f3665c5 = r5
            int r6 = r3.f3671s
            if (r6 == r5) goto L45
            r3.gv(r5)
            goto L45
        L37:
            int r5 = r3.f3674v
            if (r5 != 0) goto L45
            androidx.viewpager2.widget.v$y r5 = r3.f3667fb
            int r5 = r5.y
            if (r5 != r1) goto L42
            r5 = 0
        L42:
            r3.gv(r5)
        L45:
            androidx.viewpager2.widget.v$y r5 = r3.f3667fb
            int r6 = r5.y
            if (r6 != r1) goto L4c
            r6 = 0
        L4c:
            float r0 = r5.f3676n3
            int r5 = r5.f3677zn
            r3.zn(r6, r0, r5)
            androidx.viewpager2.widget.v$y r5 = r3.f3667fb
            int r6 = r5.y
            int r0 = r3.f3665c5
            if (r6 == r0) goto L5d
            if (r0 != r1) goto L6b
        L5d:
            int r5 = r5.f3677zn
            if (r5 != 0) goto L6b
            int r5 = r3.f3664a
            if (r5 == r4) goto L6b
            r3.v(r2)
            r3.wz()
        L6b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager2.widget.v.n3(androidx.recyclerview.widget.RecyclerView, int, int):void");
    }

    public final void p() {
        int top;
        float f4;
        y yVar = this.f3667fb;
        int e5 = this.f3668gv.e5();
        yVar.y = e5;
        if (e5 == -1) {
            yVar.y();
            return;
        }
        View yt2 = this.f3668gv.yt(e5);
        if (yt2 == null) {
            yVar.y();
            return;
        }
        int ra2 = this.f3668gv.ra(yt2);
        int yc2 = this.f3668gv.yc(yt2);
        int g32 = this.f3668gv.g3(yt2);
        int o2 = this.f3668gv.o(yt2);
        ViewGroup.LayoutParams layoutParams = yt2.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            ra2 += marginLayoutParams.leftMargin;
            yc2 += marginLayoutParams.rightMargin;
            g32 += marginLayoutParams.topMargin;
            o2 += marginLayoutParams.bottomMargin;
        }
        int height = yt2.getHeight() + g32 + o2;
        int width = yt2.getWidth() + ra2 + yc2;
        if (this.f3668gv.j4() == 0) {
            top = (yt2.getLeft() - ra2) - this.f3675zn.getPaddingLeft();
            if (this.f3670n3.gv()) {
                top = -top;
            }
            height = width;
        } else {
            top = (yt2.getTop() - g32) - this.f3675zn.getPaddingTop();
        }
        int i = -top;
        yVar.f3677zn = i;
        if (i < 0) {
            if (new cy.y(this.f3668gv).gv()) {
                throw new IllegalStateException("Page(s) contain a ViewGroup with a LayoutTransition (or animateLayoutChanges=\"true\"), which interferes with the scrolling animation. Make sure to call getLayoutTransition().setAnimateParentHierarchy(false) on all ViewGroups with a LayoutTransition before an animation is started.");
            }
            throw new IllegalStateException(String.format(Locale.US, "Page can only be offset by a positive amount, not by %d", Integer.valueOf(yVar.f3677zn)));
        }
        if (height == 0) {
            f4 = 0.0f;
        } else {
            f4 = i / height;
        }
        yVar.f3676n3 = f4;
    }

    public int s() {
        return this.f3664a;
    }

    public void t() {
        this.f3672t = true;
    }

    public void tl(int i, boolean z2) {
        int i5;
        if (z2) {
            i5 = 2;
        } else {
            i5 = 3;
        }
        this.f3674v = i5;
        boolean z3 = false;
        this.f3673tl = false;
        if (this.f3665c5 != i) {
            z3 = true;
        }
        this.f3665c5 = i;
        v(2);
        if (z3) {
            gv(i);
        }
    }

    public final void v(int i) {
        if ((this.f3674v == 3 && this.f3664a == 0) || this.f3664a == i) {
            return;
        }
        this.f3664a = i;
        ViewPager2.c5 c5Var = this.y;
        if (c5Var != null) {
            c5Var.onPageScrollStateChanged(i);
        }
    }

    public final void w(boolean z2) {
        int i;
        this.f3673tl = z2;
        if (z2) {
            i = 4;
        } else {
            i = 1;
        }
        this.f3674v = i;
        int i5 = this.f3665c5;
        if (i5 != -1) {
            this.f3671s = i5;
            this.f3665c5 = -1;
        } else if (this.f3671s == -1) {
            this.f3671s = a();
        }
        v(1);
    }

    public final void wz() {
        this.f3674v = 0;
        this.f3664a = 0;
        this.f3667fb.y();
        this.f3671s = -1;
        this.f3665c5 = -1;
        this.f3669i9 = false;
        this.f3666f = false;
        this.f3673tl = false;
        this.f3672t = false;
    }

    public void xc(ViewPager2.c5 c5Var) {
        this.y = c5Var;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.r
    public void y(@NonNull RecyclerView recyclerView, int i) {
        if ((this.f3674v != 1 || this.f3664a != 1) && i == 1) {
            w(false);
        } else if (f() && i == 2) {
            if (this.f3666f) {
                v(2);
                this.f3669i9 = true;
            }
        } else {
            if (f() && i == 0) {
                p();
                if (!this.f3666f) {
                    int i5 = this.f3667fb.y;
                    if (i5 != -1) {
                        zn(i5, 0.0f, 0);
                    }
                } else {
                    y yVar = this.f3667fb;
                    if (yVar.f3677zn == 0) {
                        int i6 = this.f3671s;
                        int i8 = yVar.y;
                        if (i6 != i8) {
                            gv(i8);
                        }
                    }
                }
                v(0);
                wz();
            }
            if (this.f3674v == 2 && i == 0 && this.f3672t) {
                p();
                y yVar2 = this.f3667fb;
                if (yVar2.f3677zn == 0) {
                    int i10 = this.f3665c5;
                    int i11 = yVar2.y;
                    if (i10 != i11) {
                        if (i11 == -1) {
                            i11 = 0;
                        }
                        gv(i11);
                    }
                    v(0);
                    wz();
                }
            }
        }
    }

    public final void zn(int i, float f4, int i5) {
        ViewPager2.c5 c5Var = this.y;
        if (c5Var != null) {
            c5Var.onPageScrolled(i, f4, i5);
        }
    }
}
