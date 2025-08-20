package androidx.drawerlayout.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowInsets;
import android.view.accessibility.AccessibilityEvent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.customview.view.AbsSavedState;
import androidx.drawerlayout.R$attr;
import androidx.drawerlayout.R$dimen;
import androidx.drawerlayout.R$styleable;
import com.uv.v7.R;
import hw.ej;
import hw.i4;
import j5.a;
import j5.zn;
import java.util.ArrayList;
import java.util.List;
import ut.zn;
/* loaded from: classes.dex */
public class DrawerLayout extends ViewGroup {

    /* renamed from: lc  reason: collision with root package name */
    public static final boolean f2482lc;

    /* renamed from: nf  reason: collision with root package name */
    public static final boolean f2483nf;

    /* renamed from: ra  reason: collision with root package name */
    public static boolean f2484ra;

    /* renamed from: b  reason: collision with root package name */
    public List<v> f2486b;

    /* renamed from: c  reason: collision with root package name */
    public int f2487c;

    /* renamed from: co  reason: collision with root package name */
    public final fb f2488co;

    /* renamed from: ct  reason: collision with root package name */
    public Matrix f2489ct;

    /* renamed from: d  reason: collision with root package name */
    public int f2490d;

    /* renamed from: d0  reason: collision with root package name */
    public int f2491d0;

    /* renamed from: dm  reason: collision with root package name */
    public Rect f2492dm;

    /* renamed from: ej  reason: collision with root package name */
    public boolean f2493ej;

    /* renamed from: en  reason: collision with root package name */
    public Drawable f2494en;

    /* renamed from: f  reason: collision with root package name */
    public float f2495f;

    /* renamed from: f3  reason: collision with root package name */
    public boolean f2496f3;

    /* renamed from: f7  reason: collision with root package name */
    public boolean f2497f7;

    /* renamed from: fb  reason: collision with root package name */
    public int f2498fb;

    /* renamed from: fh  reason: collision with root package name */
    public int f2499fh;

    /* renamed from: j  reason: collision with root package name */
    public Drawable f2500j;

    /* renamed from: j5  reason: collision with root package name */
    public float f2501j5;

    /* renamed from: jz  reason: collision with root package name */
    public Drawable f2502jz;

    /* renamed from: k  reason: collision with root package name */
    public Object f2503k;

    /* renamed from: n  reason: collision with root package name */
    public boolean f2504n;

    /* renamed from: o  reason: collision with root package name */
    public Drawable f2505o;

    /* renamed from: o4  reason: collision with root package name */
    public final j5.a f2506o4;

    /* renamed from: oz  reason: collision with root package name */
    public Drawable f2507oz;

    /* renamed from: p  reason: collision with root package name */
    public final ut.zn f2508p;

    /* renamed from: q9  reason: collision with root package name */
    public CharSequence f2509q9;

    /* renamed from: qn  reason: collision with root package name */
    public float f2510qn;

    /* renamed from: r  reason: collision with root package name */
    public int f2511r;

    /* renamed from: s  reason: collision with root package name */
    public int f2512s;

    /* renamed from: t  reason: collision with root package name */
    public Paint f2513t;

    /* renamed from: u  reason: collision with root package name */
    public Drawable f2514u;

    /* renamed from: ut  reason: collision with root package name */
    public CharSequence f2515ut;

    /* renamed from: v  reason: collision with root package name */
    public float f2516v;

    /* renamed from: w  reason: collision with root package name */
    public final ut.zn f2517w;
    @Nullable

    /* renamed from: x  reason: collision with root package name */
    public v f2518x;

    /* renamed from: xg  reason: collision with root package name */
    public final ArrayList<View> f2519xg;
    public final gv y;

    /* renamed from: y5  reason: collision with root package name */
    public Drawable f2520y5;

    /* renamed from: z  reason: collision with root package name */
    public final fb f2521z;

    /* renamed from: rs  reason: collision with root package name */
    public static final int[] f2485rs = {16843828};

    /* renamed from: eb  reason: collision with root package name */
    public static final int[] f2481eb = {16842931};

    /* loaded from: classes.dex */
    public class fb extends zn.AbstractC0235zn {

        /* renamed from: n3  reason: collision with root package name */
        public ut.zn f2531n3;
        public final int y;

        /* renamed from: zn  reason: collision with root package name */
        public final Runnable f2532zn = new y();

        /* loaded from: classes.dex */
        public class y implements Runnable {
            public y() {
            }

            @Override // java.lang.Runnable
            public void run() {
                fb.this.xc();
            }
        }

        public fb(int i) {
            this.y = i;
        }

        @Override // ut.zn.AbstractC0235zn
        public void a(int i, int i5) {
            View wz2;
            if ((i & 1) == 1) {
                wz2 = DrawerLayout.this.wz(3);
            } else {
                wz2 = DrawerLayout.this.wz(5);
            }
            if (wz2 != null && DrawerLayout.this.mt(wz2) == 0) {
                this.f2531n3.n3(wz2, i5);
            }
        }

        @Override // ut.zn.AbstractC0235zn
        public void c5(View view, int i) {
            ((a) view.getLayoutParams()).f2529zn = false;
            wz();
        }

        @Override // ut.zn.AbstractC0235zn
        public void f(View view, int i, int i5, int i6, int i8) {
            float width;
            int i10;
            int width2 = view.getWidth();
            if (DrawerLayout.this.zn(view, 3)) {
                width = i + width2;
            } else {
                width = DrawerLayout.this.getWidth() - i;
            }
            float f4 = width / width2;
            DrawerLayout.this.o(view, f4);
            if (f4 == 0.0f) {
                i10 = 4;
            } else {
                i10 = 0;
            }
            view.setVisibility(i10);
            DrawerLayout.this.invalidate();
        }

        @Override // ut.zn.AbstractC0235zn
        public boolean fb(int i) {
            return false;
        }

        @Override // ut.zn.AbstractC0235zn
        public int gv(View view) {
            if (DrawerLayout.this.mg(view)) {
                return view.getWidth();
            }
            return 0;
        }

        @Override // ut.zn.AbstractC0235zn
        public void i9(int i) {
            DrawerLayout.this.ut(i, this.f2531n3.x4());
        }

        @Override // ut.zn.AbstractC0235zn
        public int n3(View view, int i, int i5) {
            return view.getTop();
        }

        public void p(ut.zn znVar) {
            this.f2531n3 = znVar;
        }

        @Override // ut.zn.AbstractC0235zn
        public void s(int i, int i5) {
            DrawerLayout.this.postDelayed(this.f2532zn, 160L);
        }

        @Override // ut.zn.AbstractC0235zn
        public void t(View view, float f4, float f6) {
            int i;
            float r2 = DrawerLayout.this.r(view);
            int width = view.getWidth();
            if (DrawerLayout.this.zn(view, 3)) {
                int i5 = (f4 > 0.0f ? 1 : (f4 == 0.0f ? 0 : -1));
                if (i5 <= 0 && (i5 != 0 || r2 <= 0.5f)) {
                    i = -width;
                } else {
                    i = 0;
                }
            } else {
                int width2 = DrawerLayout.this.getWidth();
                if (f4 < 0.0f || (f4 == 0.0f && r2 > 0.5f)) {
                    width2 -= width;
                }
                i = width2;
            }
            this.f2531n3.vl(i, view.getTop());
            DrawerLayout.this.invalidate();
        }

        @Override // ut.zn.AbstractC0235zn
        public boolean tl(View view, int i) {
            if (DrawerLayout.this.mg(view) && DrawerLayout.this.zn(view, this.y) && DrawerLayout.this.mt(view) == 0) {
                return true;
            }
            return false;
        }

        public void w() {
            DrawerLayout.this.removeCallbacks(this.f2532zn);
        }

        public final void wz() {
            int i = 3;
            if (this.y == 3) {
                i = 5;
            }
            View wz2 = DrawerLayout.this.wz(i);
            if (wz2 != null) {
                DrawerLayout.this.a(wz2);
            }
        }

        public void xc() {
            boolean z2;
            View wz2;
            int width;
            int f32 = this.f2531n3.f3();
            int i = 0;
            if (this.y == 3) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                wz2 = DrawerLayout.this.wz(3);
                if (wz2 != null) {
                    i = -wz2.getWidth();
                }
                width = i + f32;
            } else {
                wz2 = DrawerLayout.this.wz(5);
                width = DrawerLayout.this.getWidth() - f32;
            }
            if (wz2 != null) {
                if (((z2 && wz2.getLeft() < width) || (!z2 && wz2.getLeft() > width)) && DrawerLayout.this.mt(wz2) == 0) {
                    this.f2531n3.j5(wz2, width, wz2.getTop());
                    ((a) wz2.getLayoutParams()).f2529zn = true;
                    DrawerLayout.this.invalidate();
                    wz();
                    DrawerLayout.this.n3();
                }
            }
        }

        @Override // ut.zn.AbstractC0235zn
        public int y(View view, int i, int i5) {
            if (DrawerLayout.this.zn(view, 3)) {
                return Math.max(-view.getWidth(), Math.min(i, 0));
            }
            int width = DrawerLayout.this.getWidth();
            return Math.max(width - view.getWidth(), Math.min(i, width));
        }
    }

    /* loaded from: classes.dex */
    public static final class gv extends hw.y {
        @Override // hw.y
        public void fb(View view, j5.zn znVar) {
            super.fb(view, znVar);
            if (!DrawerLayout.d0(view)) {
                znVar.pq(null);
            }
        }
    }

    /* loaded from: classes.dex */
    public class n3 implements View.OnApplyWindowInsetsListener {
        public n3() {
        }

        @Override // android.view.View.OnApplyWindowInsetsListener
        public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
            boolean z2;
            DrawerLayout drawerLayout = (DrawerLayout) view;
            if (windowInsets.getSystemWindowInsetTop() > 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            drawerLayout.j5(windowInsets, z2);
            return windowInsets.consumeSystemWindowInsets();
        }
    }

    /* loaded from: classes.dex */
    public interface v {
        void gv(@NonNull View view, float f4);

        void n3(@NonNull View view);

        void y(@NonNull View view);

        void zn(int i);
    }

    /* loaded from: classes.dex */
    public class y implements j5.a {
        public y() {
        }

        @Override // j5.a
        public boolean y(@NonNull View view, @Nullable a.y yVar) {
            if (DrawerLayout.this.rz(view) && DrawerLayout.this.mt(view) != 2) {
                DrawerLayout.this.a(view);
                return true;
            }
            return false;
        }
    }

    /* loaded from: classes.dex */
    public class zn extends hw.y {

        /* renamed from: gv  reason: collision with root package name */
        public final Rect f2533gv = new Rect();

        public zn() {
        }

        @Override // hw.y
        public void a(View view, AccessibilityEvent accessibilityEvent) {
            super.a(view, accessibilityEvent);
            accessibilityEvent.setClassName("androidx.drawerlayout.widget.DrawerLayout");
        }

        @Override // hw.y
        public boolean c5(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            if (!DrawerLayout.f2482lc && !DrawerLayout.d0(view)) {
                return false;
            }
            return super.c5(viewGroup, view, accessibilityEvent);
        }

        @Override // hw.y
        public void fb(View view, j5.zn znVar) {
            if (DrawerLayout.f2482lc) {
                super.fb(view, znVar);
            } else {
                j5.zn u2 = j5.zn.u(znVar);
                super.fb(view, u2);
                znVar.qk(view);
                ViewParent x2 = i4.x(view);
                if (x2 instanceof View) {
                    znVar.pq((View) x2);
                }
                xc(znVar, u2);
                u2.xg();
                wz(znVar, (ViewGroup) view);
            }
            znVar.e("androidx.drawerlayout.widget.DrawerLayout");
            znVar.m(false);
            znVar.g(false);
            znVar.dm(zn.y.f9411v);
            znVar.dm(zn.y.f9377a);
        }

        public final void wz(j5.zn znVar, ViewGroup viewGroup) {
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = viewGroup.getChildAt(i);
                if (DrawerLayout.d0(childAt)) {
                    znVar.zn(childAt);
                }
            }
        }

        public final void xc(j5.zn znVar, j5.zn znVar2) {
            Rect rect = this.f2533gv;
            znVar2.wz(rect);
            znVar.lc(rect);
            znVar.oa(znVar2.f7());
            znVar.tg(znVar2.n());
            znVar.e(znVar2.p());
            znVar.yc(znVar2.z());
            znVar.rb(znVar2.yt());
            znVar.g(znVar2.hw());
            znVar.o4(znVar2.ud());
            znVar.ad(znVar2.ut());
            znVar.y(znVar2.f());
        }

        @Override // hw.y
        public boolean y(View view, AccessibilityEvent accessibilityEvent) {
            if (accessibilityEvent.getEventType() == 32) {
                List<CharSequence> text = accessibilityEvent.getText();
                View w4 = DrawerLayout.this.w();
                if (w4 != null) {
                    CharSequence co2 = DrawerLayout.this.co(DrawerLayout.this.z(w4));
                    if (co2 != null) {
                        text.add(co2);
                        return true;
                    }
                    return true;
                }
                return true;
            }
            return super.y(view, accessibilityEvent);
        }
    }

    static {
        int i = Build.VERSION.SDK_INT;
        boolean z2 = true;
        f2482lc = true;
        f2483nf = true;
        if (i < 29) {
            z2 = false;
        }
        f2484ra = z2;
    }

    public DrawerLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.dk);
    }

    public static boolean d0(View view) {
        if (i4.rz(view) != 4 && i4.rz(view) != 2) {
            return true;
        }
        return false;
    }

    public static boolean f3(View view) {
        Drawable background = view.getBackground();
        if (background == null || background.getOpacity() != -1) {
            return false;
        }
        return true;
    }

    public static String i4(int i) {
        if ((i & 3) == 3) {
            return "LEFT";
        }
        if ((i & 5) == 5) {
            return "RIGHT";
        }
        return Integer.toHexString(i);
    }

    public void a(@NonNull View view) {
        fb(view, true);
    }

    public void a8(int i, boolean z2) {
        View wz2 = wz(i);
        if (wz2 != null) {
            b(wz2, z2);
            return;
        }
        throw new IllegalArgumentException("No drawer view found with gravity " + i4(i));
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> arrayList, int i, int i5) {
        if (getDescendantFocusability() == 393216) {
            return;
        }
        int childCount = getChildCount();
        boolean z2 = false;
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            if (mg(childAt)) {
                if (rz(childAt)) {
                    childAt.addFocusables(arrayList, i, i5);
                    z2 = true;
                }
            } else {
                this.f2519xg.add(childAt);
            }
        }
        if (!z2) {
            int size = this.f2519xg.size();
            for (int i8 = 0; i8 < size; i8++) {
                View view = this.f2519xg.get(i8);
                if (view.getVisibility() == 0) {
                    view.addFocusables(arrayList, i, i5);
                }
            }
        }
        this.f2519xg.clear();
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
        if (xc() == null && !mg(view)) {
            i4.o0(view, 1);
        } else {
            i4.o0(view, 4);
        }
        if (!f2482lc) {
            i4.g3(view, this.y);
        }
    }

    public void b(@NonNull View view, boolean z2) {
        if (mg(view)) {
            a aVar = (a) view.getLayoutParams();
            if (this.f2504n) {
                aVar.f2528n3 = 1.0f;
                aVar.f2527gv = 1;
                oz(view, true);
                j(view);
            } else if (z2) {
                aVar.f2527gv |= 2;
                if (zn(view, 3)) {
                    this.f2517w.j5(view, 0, view.getTop());
                } else {
                    this.f2508p.j5(view, getWidth() - view.getWidth(), view.getTop());
                }
            } else {
                ej(view, 1.0f);
                ut(0, view);
                view.setVisibility(0);
            }
            invalidate();
            return;
        }
        throw new IllegalArgumentException("View " + view + " is not a sliding drawer");
    }

    public final boolean c() {
        if (w() != null) {
            return true;
        }
        return false;
    }

    public void c5(boolean z2) {
        boolean j52;
        int childCount = getChildCount();
        boolean z3 = false;
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            a aVar = (a) childAt.getLayoutParams();
            if (mg(childAt) && (!z2 || aVar.f2529zn)) {
                int width = childAt.getWidth();
                if (zn(childAt, 3)) {
                    j52 = this.f2517w.j5(childAt, -width, childAt.getTop());
                } else {
                    j52 = this.f2508p.j5(childAt, getWidth(), childAt.getTop());
                }
                z3 |= j52;
                aVar.f2529zn = false;
            }
        }
        this.f2488co.w();
        this.f2521z.w();
        if (z3) {
            invalidate();
        }
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if ((layoutParams instanceof a) && super.checkLayoutParams(layoutParams)) {
            return true;
        }
        return false;
    }

    @Nullable
    public CharSequence co(int i) {
        int n32 = hw.v.n3(i, i4.ta(this));
        if (n32 == 3) {
            return this.f2515ut;
        }
        if (n32 == 5) {
            return this.f2509q9;
        }
        return null;
    }

    @Override // android.view.View
    public void computeScroll() {
        int childCount = getChildCount();
        float f4 = 0.0f;
        for (int i = 0; i < childCount; i++) {
            f4 = Math.max(f4, ((a) getChildAt(i).getLayoutParams()).f2528n3);
        }
        this.f2495f = f4;
        boolean tl2 = this.f2517w.tl(true);
        boolean tl3 = this.f2508p.tl(true);
        if (tl2 || tl3) {
            i4.lc(this);
        }
    }

    public final boolean d(float f4, float f6, View view) {
        if (this.f2492dm == null) {
            this.f2492dm = new Rect();
        }
        view.getHitRect(this.f2492dm);
        return this.f2492dm.contains((int) f4, (int) f6);
    }

    @Override // android.view.View
    public boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        if ((motionEvent.getSource() & 2) != 0 && motionEvent.getAction() != 10 && this.f2495f > 0.0f) {
            int childCount = getChildCount();
            if (childCount != 0) {
                float x2 = motionEvent.getX();
                float y2 = motionEvent.getY();
                for (int i = childCount - 1; i >= 0; i--) {
                    View childAt = getChildAt(i);
                    if (d(x2, y2, childAt) && !fh(childAt) && tl(motionEvent, childAt)) {
                        return true;
                    }
                }
                return false;
            }
            return false;
        }
        return super.dispatchGenericMotionEvent(motionEvent);
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas canvas, View view, long j2) {
        int height = getHeight();
        boolean fh2 = fh(view);
        int width = getWidth();
        int save = canvas.save();
        int i = 0;
        if (fh2) {
            int childCount = getChildCount();
            int i5 = 0;
            for (int i6 = 0; i6 < childCount; i6++) {
                View childAt = getChildAt(i6);
                if (childAt != view && childAt.getVisibility() == 0 && f3(childAt) && mg(childAt) && childAt.getHeight() >= height) {
                    if (zn(childAt, 3)) {
                        int right = childAt.getRight();
                        if (right > i5) {
                            i5 = right;
                        }
                    } else {
                        int left = childAt.getLeft();
                        if (left < width) {
                            width = left;
                        }
                    }
                }
            }
            canvas.clipRect(i5, 0, width, getHeight());
            i = i5;
        }
        boolean drawChild = super.drawChild(canvas, view, j2);
        canvas.restoreToCount(save);
        float f4 = this.f2495f;
        if (f4 > 0.0f && fh2) {
            int i8 = this.f2512s;
            this.f2513t.setColor((i8 & 16777215) | (((int) ((((-16777216) & i8) >>> 24) * f4)) << 24));
            canvas.drawRect(i, 0.0f, width, getHeight(), this.f2513t);
        } else if (this.f2500j != null && zn(view, 3)) {
            int intrinsicWidth = this.f2500j.getIntrinsicWidth();
            int right2 = view.getRight();
            float max = Math.max(0.0f, Math.min(right2 / this.f2517w.f3(), 1.0f));
            this.f2500j.setBounds(right2, view.getTop(), intrinsicWidth + right2, view.getBottom());
            this.f2500j.setAlpha((int) (max * 255.0f));
            this.f2500j.draw(canvas);
        } else if (this.f2507oz != null && zn(view, 5)) {
            int intrinsicWidth2 = this.f2507oz.getIntrinsicWidth();
            int left2 = view.getLeft();
            float max2 = Math.max(0.0f, Math.min((getWidth() - left2) / this.f2508p.f3(), 1.0f));
            this.f2507oz.setBounds(left2 - intrinsicWidth2, view.getTop(), left2, view.getBottom());
            this.f2507oz.setAlpha((int) (max2 * 255.0f));
            this.f2507oz.draw(canvas);
        }
        return drawChild;
    }

    public void ej(View view, float f4) {
        float r2 = r(view);
        float width = view.getWidth();
        int i = ((int) (width * f4)) - ((int) (r2 * width));
        if (!zn(view, 3)) {
            i = -i;
        }
        view.offsetLeftAndRight(i);
        o(view, f4);
    }

    public void f(View view) {
        a aVar = (a) view.getLayoutParams();
        if ((aVar.f2527gv & 1) == 0) {
            aVar.f2527gv = 1;
            List<v> list = this.f2486b;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    this.f2486b.get(size).y(view);
                }
            }
            oz(view, true);
            j(view);
            if (hasWindowFocus()) {
                sendAccessibilityEvent(32);
            }
        }
    }

    public void fb(@NonNull View view, boolean z2) {
        if (mg(view)) {
            a aVar = (a) view.getLayoutParams();
            if (this.f2504n) {
                aVar.f2528n3 = 0.0f;
                aVar.f2527gv = 0;
            } else if (z2) {
                aVar.f2527gv |= 4;
                if (zn(view, 3)) {
                    this.f2517w.j5(view, -view.getWidth(), view.getTop());
                } else {
                    this.f2508p.j5(view, getWidth(), view.getTop());
                }
            } else {
                ej(view, 0.0f);
                ut(0, view);
                view.setVisibility(4);
            }
            invalidate();
            return;
        }
        throw new IllegalArgumentException("View " + view + " is not a sliding drawer");
    }

    public boolean fh(View view) {
        if (((a) view.getLayoutParams()).y == 0) {
            return true;
        }
        return false;
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new a(-1, -1);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof a) {
            return new a((a) layoutParams);
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new a((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new a(layoutParams);
    }

    public float getDrawerElevation() {
        if (f2483nf) {
            return this.f2516v;
        }
        return 0.0f;
    }

    @Nullable
    public Drawable getStatusBarBackgroundDrawable() {
        return this.f2505o;
    }

    public void gv(int i) {
        v(i, true);
    }

    public final void hw() {
        if (f2483nf) {
            return;
        }
        this.f2500j = yt();
        this.f2507oz = vl();
    }

    public void i9(View view) {
        View rootView;
        a aVar = (a) view.getLayoutParams();
        if ((aVar.f2527gv & 1) == 1) {
            aVar.f2527gv = 0;
            List<v> list = this.f2486b;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    this.f2486b.get(size).n3(view);
                }
            }
            oz(view, false);
            j(view);
            if (hasWindowFocus() && (rootView = getRootView()) != null) {
                rootView.sendAccessibilityEvent(32);
            }
        }
    }

    public final void j(View view) {
        zn.y yVar = zn.y.f9398n;
        i4.e(view, yVar.n3());
        if (rz(view) && mt(view) != 2) {
            i4.ap(view, yVar, null, this.f2506o4);
        }
    }

    public void j5(Object obj, boolean z2) {
        boolean z3;
        this.f2503k = obj;
        this.f2497f7 = z2;
        if (!z2 && getBackground() == null) {
            z3 = true;
        } else {
            z3 = false;
        }
        setWillNotDraw(z3);
        requestLayout();
    }

    public void k5(@NonNull v vVar) {
        List<v> list;
        if (vVar == null || (list = this.f2486b) == null) {
            return;
        }
        list.remove(vVar);
    }

    public boolean mg(View view) {
        int n32 = hw.v.n3(((a) view.getLayoutParams()).y, i4.ta(view));
        if ((n32 & 3) != 0 || (n32 & 5) != 0) {
            return true;
        }
        return false;
    }

    public int mt(@NonNull View view) {
        if (mg(view)) {
            return p(((a) view.getLayoutParams()).y);
        }
        throw new IllegalArgumentException("View " + view + " is not a drawer");
    }

    public final boolean n() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (((a) getChildAt(i).getLayoutParams()).f2529zn) {
                return true;
            }
        }
        return false;
    }

    public void n3() {
        if (!this.f2493ej) {
            long uptimeMillis = SystemClock.uptimeMillis();
            MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                getChildAt(i).dispatchTouchEvent(obtain);
            }
            obtain.recycle();
            this.f2493ej = true;
        }
    }

    public void o(View view, float f4) {
        a aVar = (a) view.getLayoutParams();
        if (f4 == aVar.f2528n3) {
            return;
        }
        aVar.f2528n3 = f4;
        t(view, f4);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f2504n = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f2504n = true;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        int i;
        super.onDraw(canvas);
        if (this.f2497f7 && this.f2505o != null) {
            Object obj = this.f2503k;
            if (obj != null) {
                i = ((WindowInsets) obj).getSystemWindowInsetTop();
            } else {
                i = 0;
            }
            if (i > 0) {
                this.f2505o.setBounds(0, 0, getWidth(), i);
                this.f2505o.draw(canvas);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x001b, code lost:
        if (r0 != 3) goto L7;
     */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onInterceptTouchEvent(android.view.MotionEvent r7) {
        /*
            r6 = this;
            int r0 = r7.getActionMasked()
            ut.zn r1 = r6.f2517w
            boolean r1 = r1.hw(r7)
            ut.zn r2 = r6.f2508p
            boolean r2 = r2.hw(r7)
            r1 = r1 | r2
            r2 = 1
            r3 = 0
            if (r0 == 0) goto L38
            if (r0 == r2) goto L31
            r7 = 2
            r4 = 3
            if (r0 == r7) goto L1e
            if (r0 == r4) goto L31
            goto L36
        L1e:
            ut.zn r7 = r6.f2517w
            boolean r7 = r7.gv(r4)
            if (r7 == 0) goto L36
            androidx.drawerlayout.widget.DrawerLayout$fb r7 = r6.f2488co
            r7.w()
            androidx.drawerlayout.widget.DrawerLayout$fb r7 = r6.f2521z
            r7.w()
            goto L36
        L31:
            r6.c5(r2)
            r6.f2493ej = r3
        L36:
            r7 = 0
            goto L60
        L38:
            float r0 = r7.getX()
            float r7 = r7.getY()
            r6.f2501j5 = r0
            r6.f2510qn = r7
            float r4 = r6.f2495f
            r5 = 0
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 <= 0) goto L5d
            ut.zn r4 = r6.f2517w
            int r0 = (int) r0
            int r7 = (int) r7
            android.view.View r7 = r4.z(r0, r7)
            if (r7 == 0) goto L5d
            boolean r7 = r6.fh(r7)
            if (r7 == 0) goto L5d
            r7 = 1
            goto L5e
        L5d:
            r7 = 0
        L5e:
            r6.f2493ej = r3
        L60:
            if (r1 != 0) goto L70
            if (r7 != 0) goto L70
            boolean r7 = r6.n()
            if (r7 != 0) goto L70
            boolean r7 = r6.f2493ej
            if (r7 == 0) goto L6f
            goto L70
        L6f:
            r2 = 0
        L70:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.drawerlayout.widget.DrawerLayout.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && c()) {
            keyEvent.startTracking();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i == 4) {
            View w4 = w();
            if (w4 != null && mt(w4) == 0) {
                s();
            }
            if (w4 != null) {
                return true;
            }
            return false;
        }
        return super.onKeyUp(i, keyEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z2, int i, int i5, int i6, int i8) {
        WindowInsets rootWindowInsets;
        int i10;
        float f4;
        int i11;
        boolean z3;
        int i12;
        this.f2496f3 = true;
        int i13 = i6 - i;
        int childCount = getChildCount();
        for (int i14 = 0; i14 < childCount; i14++) {
            View childAt = getChildAt(i14);
            if (childAt.getVisibility() != 8) {
                a aVar = (a) childAt.getLayoutParams();
                if (fh(childAt)) {
                    int i15 = ((ViewGroup.MarginLayoutParams) aVar).leftMargin;
                    childAt.layout(i15, ((ViewGroup.MarginLayoutParams) aVar).topMargin, childAt.getMeasuredWidth() + i15, ((ViewGroup.MarginLayoutParams) aVar).topMargin + childAt.getMeasuredHeight());
                } else {
                    int measuredWidth = childAt.getMeasuredWidth();
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (zn(childAt, 3)) {
                        float f6 = measuredWidth;
                        i11 = (-measuredWidth) + ((int) (aVar.f2528n3 * f6));
                        f4 = (measuredWidth + i11) / f6;
                    } else {
                        float f9 = measuredWidth;
                        f4 = (i13 - i10) / f9;
                        i11 = i13 - ((int) (aVar.f2528n3 * f9));
                    }
                    if (f4 != aVar.f2528n3) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    int i16 = aVar.y & R.styleable.AppCompatTheme_toolbarNavigationButtonStyle;
                    if (i16 != 16) {
                        if (i16 != 80) {
                            int i17 = ((ViewGroup.MarginLayoutParams) aVar).topMargin;
                            childAt.layout(i11, i17, measuredWidth + i11, measuredHeight + i17);
                        } else {
                            int i18 = i8 - i5;
                            childAt.layout(i11, (i18 - ((ViewGroup.MarginLayoutParams) aVar).bottomMargin) - childAt.getMeasuredHeight(), measuredWidth + i11, i18 - ((ViewGroup.MarginLayoutParams) aVar).bottomMargin);
                        }
                    } else {
                        int i19 = i8 - i5;
                        int i20 = (i19 - measuredHeight) / 2;
                        int i21 = ((ViewGroup.MarginLayoutParams) aVar).topMargin;
                        if (i20 < i21) {
                            i20 = i21;
                        } else {
                            int i22 = i20 + measuredHeight;
                            int i23 = ((ViewGroup.MarginLayoutParams) aVar).bottomMargin;
                            if (i22 > i19 - i23) {
                                i20 = (i19 - i23) - measuredHeight;
                            }
                        }
                        childAt.layout(i11, i20, measuredWidth + i11, measuredHeight + i20);
                    }
                    if (z3) {
                        o(childAt, f4);
                    }
                    if (aVar.f2528n3 > 0.0f) {
                        i12 = 0;
                    } else {
                        i12 = 4;
                    }
                    if (childAt.getVisibility() != i12) {
                        childAt.setVisibility(i12);
                    }
                }
            }
        }
        if (f2484ra && (rootWindowInsets = getRootWindowInsets()) != null) {
            z6.n3 c52 = ej.i4(rootWindowInsets).c5();
            ut.zn znVar = this.f2517w;
            znVar.b(Math.max(znVar.i4(), c52.y));
            ut.zn znVar2 = this.f2508p;
            znVar2.b(Math.max(znVar2.i4(), c52.f15665zn));
        }
        this.f2496f3 = false;
        this.f2504n = false;
    }

    @Override // android.view.View
    @SuppressLint({"WrongConstant"})
    public void onMeasure(int i, int i5) {
        boolean z2;
        boolean z3;
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i5);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i5);
        if (mode != 1073741824 || mode2 != 1073741824) {
            if (isInEditMode()) {
                if (mode == 0) {
                    size = 300;
                }
                if (mode2 == 0) {
                    size2 = 300;
                }
            } else {
                throw new IllegalArgumentException("DrawerLayout must be measured with MeasureSpec.EXACTLY.");
            }
        }
        setMeasuredDimension(size, size2);
        if (this.f2503k != null && i4.fh(this)) {
            z2 = true;
        } else {
            z2 = false;
        }
        int ta2 = i4.ta(this);
        int childCount = getChildCount();
        boolean z4 = false;
        boolean z5 = false;
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() != 8) {
                a aVar = (a) childAt.getLayoutParams();
                if (z2) {
                    int n32 = hw.v.n3(aVar.y, ta2);
                    if (i4.fh(childAt)) {
                        WindowInsets windowInsets = (WindowInsets) this.f2503k;
                        if (n32 == 3) {
                            windowInsets = windowInsets.replaceSystemWindowInsets(windowInsets.getSystemWindowInsetLeft(), windowInsets.getSystemWindowInsetTop(), 0, windowInsets.getSystemWindowInsetBottom());
                        } else if (n32 == 5) {
                            windowInsets = windowInsets.replaceSystemWindowInsets(0, windowInsets.getSystemWindowInsetTop(), windowInsets.getSystemWindowInsetRight(), windowInsets.getSystemWindowInsetBottom());
                        }
                        childAt.dispatchApplyWindowInsets(windowInsets);
                    } else {
                        WindowInsets windowInsets2 = (WindowInsets) this.f2503k;
                        if (n32 == 3) {
                            windowInsets2 = windowInsets2.replaceSystemWindowInsets(windowInsets2.getSystemWindowInsetLeft(), windowInsets2.getSystemWindowInsetTop(), 0, windowInsets2.getSystemWindowInsetBottom());
                        } else if (n32 == 5) {
                            windowInsets2 = windowInsets2.replaceSystemWindowInsets(0, windowInsets2.getSystemWindowInsetTop(), windowInsets2.getSystemWindowInsetRight(), windowInsets2.getSystemWindowInsetBottom());
                        }
                        ((ViewGroup.MarginLayoutParams) aVar).leftMargin = windowInsets2.getSystemWindowInsetLeft();
                        ((ViewGroup.MarginLayoutParams) aVar).topMargin = windowInsets2.getSystemWindowInsetTop();
                        ((ViewGroup.MarginLayoutParams) aVar).rightMargin = windowInsets2.getSystemWindowInsetRight();
                        ((ViewGroup.MarginLayoutParams) aVar).bottomMargin = windowInsets2.getSystemWindowInsetBottom();
                    }
                }
                if (fh(childAt)) {
                    childAt.measure(View.MeasureSpec.makeMeasureSpec((size - ((ViewGroup.MarginLayoutParams) aVar).leftMargin) - ((ViewGroup.MarginLayoutParams) aVar).rightMargin, 1073741824), View.MeasureSpec.makeMeasureSpec((size2 - ((ViewGroup.MarginLayoutParams) aVar).topMargin) - ((ViewGroup.MarginLayoutParams) aVar).bottomMargin, 1073741824));
                } else if (mg(childAt)) {
                    if (f2483nf) {
                        float n2 = i4.n(childAt);
                        float f4 = this.f2516v;
                        if (n2 != f4) {
                            i4.pz(childAt, f4);
                        }
                    }
                    int z7 = z(childAt) & 7;
                    if (z7 == 3) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if ((z3 && z4) || (!z3 && z5)) {
                        throw new IllegalStateException("Child drawer has absolute gravity " + i4(z7) + " but this DrawerLayout already has a drawer view along that edge");
                    }
                    if (z3) {
                        z4 = true;
                    } else {
                        z5 = true;
                    }
                    childAt.measure(ViewGroup.getChildMeasureSpec(i, this.f2498fb + ((ViewGroup.MarginLayoutParams) aVar).leftMargin + ((ViewGroup.MarginLayoutParams) aVar).rightMargin, ((ViewGroup.MarginLayoutParams) aVar).width), ViewGroup.getChildMeasureSpec(i5, ((ViewGroup.MarginLayoutParams) aVar).topMargin + ((ViewGroup.MarginLayoutParams) aVar).bottomMargin, ((ViewGroup.MarginLayoutParams) aVar).height));
                } else {
                    throw new IllegalStateException("Child " + childAt + " at index " + i6 + " does not have a valid layout_gravity - must be Gravity.LEFT, Gravity.RIGHT or Gravity.NO_GRAVITY");
                }
            }
        }
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        View wz2;
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.y());
        int i = savedState.f2523fb;
        if (i != 0 && (wz2 = wz(i)) != null) {
            x(wz2);
        }
        int i5 = savedState.f2524s;
        if (i5 != 3) {
            qn(i5, 3);
        }
        int i6 = savedState.f2522f;
        if (i6 != 3) {
            qn(i6, 5);
        }
        int i8 = savedState.f2525t;
        if (i8 != 3) {
            qn(i8, 8388611);
        }
        int i10 = savedState.f2526w;
        if (i10 != 3) {
            qn(i10, 8388613);
        }
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i) {
        hw();
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        boolean z2;
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            a aVar = (a) getChildAt(i).getLayoutParams();
            int i5 = aVar.f2527gv;
            boolean z3 = true;
            if (i5 == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (i5 != 2) {
                z3 = false;
            }
            if (z2 || z3) {
                savedState.f2523fb = aVar.y;
                break;
            }
        }
        savedState.f2524s = this.f2487c;
        savedState.f2522f = this.f2491d0;
        savedState.f2525t = this.f2499fh;
        savedState.f2526w = this.f2490d;
        return savedState;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x005b, code lost:
        if (mt(r7) != 2) goto L19;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r7) {
        /*
            r6 = this;
            ut.zn r0 = r6.f2517w
            r0.d(r7)
            ut.zn r0 = r6.f2508p
            r0.d(r7)
            int r0 = r7.getAction()
            r0 = r0 & 255(0xff, float:3.57E-43)
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L62
            if (r0 == r2) goto L20
            r7 = 3
            if (r0 == r7) goto L1a
            goto L70
        L1a:
            r6.c5(r2)
            r6.f2493ej = r1
            goto L70
        L20:
            float r0 = r7.getX()
            float r7 = r7.getY()
            ut.zn r3 = r6.f2517w
            int r4 = (int) r0
            int r5 = (int) r7
            android.view.View r3 = r3.z(r4, r5)
            if (r3 == 0) goto L5d
            boolean r3 = r6.fh(r3)
            if (r3 == 0) goto L5d
            float r3 = r6.f2501j5
            float r0 = r0 - r3
            float r3 = r6.f2510qn
            float r7 = r7 - r3
            ut.zn r3 = r6.f2517w
            int r3 = r3.c()
            float r0 = r0 * r0
            float r7 = r7 * r7
            float r0 = r0 + r7
            int r3 = r3 * r3
            float r7 = (float) r3
            int r7 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
            if (r7 >= 0) goto L5d
            android.view.View r7 = r6.xc()
            if (r7 == 0) goto L5d
            int r7 = r6.mt(r7)
            r0 = 2
            if (r7 != r0) goto L5e
        L5d:
            r1 = 1
        L5e:
            r6.c5(r1)
            goto L70
        L62:
            float r0 = r7.getX()
            float r7 = r7.getY()
            r6.f2501j5 = r0
            r6.f2510qn = r7
            r6.f2493ej = r1
        L70:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.drawerlayout.widget.DrawerLayout.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public final void oz(View view, boolean z2) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if ((!z2 && !mg(childAt)) || (z2 && childAt == view)) {
                i4.o0(childAt, 1);
            } else {
                i4.o0(childAt, 4);
            }
        }
    }

    public int p(int i) {
        int i5;
        int i6;
        int i8;
        int i10;
        int ta2 = i4.ta(this);
        if (i != 3) {
            if (i != 5) {
                if (i != 8388611) {
                    if (i == 8388613) {
                        int i11 = this.f2490d;
                        if (i11 != 3) {
                            return i11;
                        }
                        if (ta2 == 0) {
                            i10 = this.f2491d0;
                        } else {
                            i10 = this.f2487c;
                        }
                        if (i10 != 3) {
                            return i10;
                        }
                        return 0;
                    }
                    return 0;
                }
                int i12 = this.f2499fh;
                if (i12 != 3) {
                    return i12;
                }
                if (ta2 == 0) {
                    i8 = this.f2487c;
                } else {
                    i8 = this.f2491d0;
                }
                if (i8 != 3) {
                    return i8;
                }
                return 0;
            }
            int i13 = this.f2491d0;
            if (i13 != 3) {
                return i13;
            }
            if (ta2 == 0) {
                i6 = this.f2490d;
            } else {
                i6 = this.f2499fh;
            }
            if (i6 != 3) {
                return i6;
            }
            return 0;
        }
        int i14 = this.f2487c;
        if (i14 != 3) {
            return i14;
        }
        if (ta2 == 0) {
            i5 = this.f2499fh;
        } else {
            i5 = this.f2490d;
        }
        if (i5 != 3) {
            return i5;
        }
        return 0;
    }

    public void qn(int i, int i5) {
        View wz2;
        ut.zn znVar;
        int n32 = hw.v.n3(i5, i4.ta(this));
        if (i5 != 3) {
            if (i5 != 5) {
                if (i5 != 8388611) {
                    if (i5 == 8388613) {
                        this.f2490d = i;
                    }
                } else {
                    this.f2499fh = i;
                }
            } else {
                this.f2491d0 = i;
            }
        } else {
            this.f2487c = i;
        }
        if (i != 0) {
            if (n32 == 3) {
                znVar = this.f2517w;
            } else {
                znVar = this.f2508p;
            }
            znVar.y();
        }
        if (i != 1) {
            if (i == 2 && (wz2 = wz(n32)) != null) {
                x(wz2);
                return;
            }
            return;
        }
        View wz3 = wz(n32);
        if (wz3 != null) {
            a(wz3);
        }
    }

    public float r(View view) {
        return ((a) view.getLayoutParams()).f2528n3;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z2) {
        super.requestDisallowInterceptTouchEvent(z2);
        if (z2) {
            c5(true);
        }
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (!this.f2496f3) {
            super.requestLayout();
        }
    }

    public boolean rz(@NonNull View view) {
        if (mg(view)) {
            if ((((a) view.getLayoutParams()).f2527gv & 1) == 1) {
                return true;
            }
            return false;
        }
        throw new IllegalArgumentException("View " + view + " is not a drawer");
    }

    public void s() {
        c5(false);
    }

    public void setDrawerElevation(float f4) {
        this.f2516v = f4;
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (mg(childAt)) {
                i4.pz(childAt, this.f2516v);
            }
        }
    }

    @Deprecated
    public void setDrawerListener(v vVar) {
        v vVar2 = this.f2518x;
        if (vVar2 != null) {
            k5(vVar2);
        }
        if (vVar != null) {
            y(vVar);
        }
        this.f2518x = vVar;
    }

    public void setDrawerLockMode(int i) {
        qn(i, 3);
        qn(i, 5);
    }

    public void setScrimColor(int i) {
        this.f2512s = i;
        invalidate();
    }

    public void setStatusBarBackground(@Nullable Drawable drawable) {
        this.f2505o = drawable;
        invalidate();
    }

    public void setStatusBarBackgroundColor(int i) {
        this.f2505o = new ColorDrawable(i);
        invalidate();
    }

    public void t(View view, float f4) {
        List<v> list = this.f2486b;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.f2486b.get(size).gv(view, f4);
            }
        }
    }

    public boolean ta(@NonNull View view) {
        if (mg(view)) {
            if (((a) view.getLayoutParams()).f2528n3 > 0.0f) {
                return true;
            }
            return false;
        }
        throw new IllegalArgumentException("View " + view + " is not a drawer");
    }

    public final boolean tl(MotionEvent motionEvent, View view) {
        if (!view.getMatrix().isIdentity()) {
            MotionEvent x42 = x4(motionEvent, view);
            boolean dispatchGenericMotionEvent = view.dispatchGenericMotionEvent(x42);
            x42.recycle();
            return dispatchGenericMotionEvent;
        }
        float scrollX = getScrollX() - view.getLeft();
        float scrollY = getScrollY() - view.getTop();
        motionEvent.offsetLocation(scrollX, scrollY);
        boolean dispatchGenericMotionEvent2 = view.dispatchGenericMotionEvent(motionEvent);
        motionEvent.offsetLocation(-scrollX, -scrollY);
        return dispatchGenericMotionEvent2;
    }

    public void ud(int i) {
        a8(i, true);
    }

    public void ut(int i, View view) {
        int i5;
        int d02 = this.f2517w.d0();
        int d03 = this.f2508p.d0();
        if (d02 != 1 && d03 != 1) {
            i5 = 2;
            if (d02 != 2 && d03 != 2) {
                i5 = 0;
            }
        } else {
            i5 = 1;
        }
        if (view != null && i == 0) {
            float f4 = ((a) view.getLayoutParams()).f2528n3;
            if (f4 == 0.0f) {
                i9(view);
            } else if (f4 == 1.0f) {
                f(view);
            }
        }
        if (i5 != this.f2511r) {
            this.f2511r = i5;
            List<v> list = this.f2486b;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    this.f2486b.get(size).zn(i5);
                }
            }
        }
    }

    public void v(int i, boolean z2) {
        View wz2 = wz(i);
        if (wz2 != null) {
            fb(wz2, z2);
            return;
        }
        throw new IllegalArgumentException("No drawer view found with gravity " + i4(i));
    }

    public final Drawable vl() {
        int ta2 = i4.ta(this);
        if (ta2 == 0) {
            Drawable drawable = this.f2502jz;
            if (drawable != null) {
                z6(drawable, ta2);
                return this.f2502jz;
            }
        } else {
            Drawable drawable2 = this.f2494en;
            if (drawable2 != null) {
                z6(drawable2, ta2);
                return this.f2494en;
            }
        }
        return this.f2520y5;
    }

    public View w() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (mg(childAt) && ta(childAt)) {
                return childAt;
            }
        }
        return null;
    }

    public View wz(int i) {
        int n32 = hw.v.n3(i, i4.ta(this)) & 7;
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if ((z(childAt) & 7) == n32) {
                return childAt;
            }
        }
        return null;
    }

    public void x(@NonNull View view) {
        b(view, true);
    }

    public final MotionEvent x4(MotionEvent motionEvent, View view) {
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        obtain.offsetLocation(getScrollX() - view.getLeft(), getScrollY() - view.getTop());
        Matrix matrix = view.getMatrix();
        if (!matrix.isIdentity()) {
            if (this.f2489ct == null) {
                this.f2489ct = new Matrix();
            }
            matrix.invert(this.f2489ct);
            obtain.transform(this.f2489ct);
        }
        return obtain;
    }

    public View xc() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if ((((a) childAt.getLayoutParams()).f2527gv & 1) == 1) {
                return childAt;
            }
        }
        return null;
    }

    public void y(@NonNull v vVar) {
        if (vVar == null) {
            return;
        }
        if (this.f2486b == null) {
            this.f2486b = new ArrayList();
        }
        this.f2486b.add(vVar);
    }

    public final Drawable yt() {
        int ta2 = i4.ta(this);
        if (ta2 == 0) {
            Drawable drawable = this.f2494en;
            if (drawable != null) {
                z6(drawable, ta2);
                return this.f2494en;
            }
        } else {
            Drawable drawable2 = this.f2502jz;
            if (drawable2 != null) {
                z6(drawable2, ta2);
                return this.f2502jz;
            }
        }
        return this.f2514u;
    }

    public int z(View view) {
        return hw.v.n3(((a) view.getLayoutParams()).y, i4.ta(this));
    }

    public final void z6(Drawable drawable, int i) {
        if (drawable != null && ej.y.s(drawable)) {
            ej.y.tl(drawable, i);
        }
    }

    public boolean zn(View view, int i) {
        if ((z(view) & i) == i) {
            return true;
        }
        return false;
    }

    public DrawerLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.y = new gv();
        this.f2512s = -1728053248;
        this.f2513t = new Paint();
        this.f2504n = true;
        this.f2487c = 3;
        this.f2491d0 = 3;
        this.f2499fh = 3;
        this.f2490d = 3;
        this.f2494en = null;
        this.f2502jz = null;
        this.f2514u = null;
        this.f2520y5 = null;
        this.f2506o4 = new y();
        setDescendantFocusability(262144);
        float f4 = getResources().getDisplayMetrics().density;
        this.f2498fb = (int) ((64.0f * f4) + 0.5f);
        float f6 = f4 * 400.0f;
        fb fbVar = new fb(3);
        this.f2488co = fbVar;
        fb fbVar2 = new fb(5);
        this.f2521z = fbVar2;
        ut.zn wz2 = ut.zn.wz(this, 1.0f, fbVar);
        this.f2517w = wz2;
        wz2.k5(1);
        wz2.yt(f6);
        fbVar.p(wz2);
        ut.zn wz3 = ut.zn.wz(this, 1.0f, fbVar2);
        this.f2508p = wz3;
        wz3.k5(2);
        wz3.yt(f6);
        fbVar2.p(wz3);
        setFocusableInTouchMode(true);
        i4.o0(this, 1);
        i4.g3(this, new zn());
        setMotionEventSplittingEnabled(false);
        if (i4.fh(this)) {
            setOnApplyWindowInsetsListener(new n3());
            setSystemUiVisibility(1280);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(f2485rs);
            try {
                this.f2505o = obtainStyledAttributes.getDrawable(0);
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, R$styleable.f2478n3, i, 0);
        try {
            int i5 = R$styleable.f2480zn;
            if (obtainStyledAttributes2.hasValue(i5)) {
                this.f2516v = obtainStyledAttributes2.getDimension(i5, 0.0f);
            } else {
                this.f2516v = getResources().getDimension(R$dimen.b8);
            }
            obtainStyledAttributes2.recycle();
            this.f2519xg = new ArrayList<>();
        } catch (Throwable th) {
            obtainStyledAttributes2.recycle();
            throw th;
        }
    }

    public void setStatusBarBackground(int i) {
        this.f2505o = i != 0 ? mg.y.v(getContext(), i) : null;
        invalidate();
    }

    /* loaded from: classes.dex */
    public static class a extends ViewGroup.MarginLayoutParams {

        /* renamed from: gv  reason: collision with root package name */
        public int f2527gv;

        /* renamed from: n3  reason: collision with root package name */
        public float f2528n3;
        public int y;

        /* renamed from: zn  reason: collision with root package name */
        public boolean f2529zn;

        public a(@NonNull Context context, @Nullable AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, DrawerLayout.f2481eb);
            this.y = obtainStyledAttributes.getInt(0, 0);
            obtainStyledAttributes.recycle();
        }

        public a(int i, int i5) {
            super(i, i5);
        }

        public a(@NonNull a aVar) {
            super((ViewGroup.MarginLayoutParams) aVar);
            this.y = aVar.y;
        }

        public a(@NonNull ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public a(@NonNull ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }
    }

    /* loaded from: classes.dex */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new y();

        /* renamed from: f  reason: collision with root package name */
        public int f2522f;

        /* renamed from: fb  reason: collision with root package name */
        public int f2523fb;

        /* renamed from: s  reason: collision with root package name */
        public int f2524s;

        /* renamed from: t  reason: collision with root package name */
        public int f2525t;

        /* renamed from: w  reason: collision with root package name */
        public int f2526w;

        /* loaded from: classes.dex */
        public class y implements Parcelable.ClassLoaderCreator<SavedState> {
            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: n3 */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: y */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: zn */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        }

        public SavedState(@NonNull Parcel parcel, @Nullable ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f2523fb = parcel.readInt();
            this.f2524s = parcel.readInt();
            this.f2522f = parcel.readInt();
            this.f2525t = parcel.readInt();
            this.f2526w = parcel.readInt();
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f2523fb);
            parcel.writeInt(this.f2524s);
            parcel.writeInt(this.f2522f);
            parcel.writeInt(this.f2525t);
            parcel.writeInt(this.f2526w);
        }

        public SavedState(@NonNull Parcelable parcelable) {
            super(parcelable);
        }
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new a(getContext(), attributeSet);
    }
}
