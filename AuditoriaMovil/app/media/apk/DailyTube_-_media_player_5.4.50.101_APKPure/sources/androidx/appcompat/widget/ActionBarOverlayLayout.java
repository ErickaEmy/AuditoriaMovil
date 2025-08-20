package androidx.appcompat.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.view.WindowInsets;
import android.widget.OverScroller;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$id;
import androidx.appcompat.view.menu.c5;
import hw.ej;
import hw.tl;
import hw.wz;
import hw.xc;
import wz.f3;
import wz.i4;
@SuppressLint({"UnknownNullness"})
/* loaded from: classes.dex */
public class ActionBarOverlayLayout extends ViewGroup implements i4, tl, wz {

    /* renamed from: u  reason: collision with root package name */
    public static final int[] f1256u = {R$attr.f645n3, 16842841};

    /* renamed from: b  reason: collision with root package name */
    public final Rect f1257b;

    /* renamed from: c  reason: collision with root package name */
    public final Rect f1258c;

    /* renamed from: co  reason: collision with root package name */
    public boolean f1259co;

    /* renamed from: d  reason: collision with root package name */
    public final Rect f1260d;

    /* renamed from: d0  reason: collision with root package name */
    public final Rect f1261d0;

    /* renamed from: ej  reason: collision with root package name */
    public final Rect f1262ej;

    /* renamed from: en  reason: collision with root package name */
    public final Runnable f1263en;

    /* renamed from: f  reason: collision with root package name */
    public f3 f1264f;

    /* renamed from: f3  reason: collision with root package name */
    public int f1265f3;

    /* renamed from: f7  reason: collision with root package name */
    public final Runnable f1266f7;

    /* renamed from: fb  reason: collision with root package name */
    public ContentFrameLayout f1267fb;

    /* renamed from: fh  reason: collision with root package name */
    public final Rect f1268fh;
    @NonNull

    /* renamed from: j  reason: collision with root package name */
    public ej f1269j;
    @NonNull

    /* renamed from: j5  reason: collision with root package name */
    public ej f1270j5;

    /* renamed from: jz  reason: collision with root package name */
    public final xc f1271jz;

    /* renamed from: k  reason: collision with root package name */
    public final AnimatorListenerAdapter f1272k;

    /* renamed from: n  reason: collision with root package name */
    public int f1273n;
    @NonNull

    /* renamed from: o  reason: collision with root package name */
    public ej f1274o;

    /* renamed from: oz  reason: collision with root package name */
    public gv f1275oz;

    /* renamed from: p  reason: collision with root package name */
    public boolean f1276p;

    /* renamed from: q9  reason: collision with root package name */
    public ViewPropertyAnimator f1277q9;
    @NonNull

    /* renamed from: qn  reason: collision with root package name */
    public ej f1278qn;

    /* renamed from: r  reason: collision with root package name */
    public boolean f1279r;

    /* renamed from: s  reason: collision with root package name */
    public ActionBarContainer f1280s;

    /* renamed from: t  reason: collision with root package name */
    public Drawable f1281t;

    /* renamed from: ut  reason: collision with root package name */
    public OverScroller f1282ut;

    /* renamed from: v  reason: collision with root package name */
    public int f1283v;

    /* renamed from: w  reason: collision with root package name */
    public boolean f1284w;

    /* renamed from: x  reason: collision with root package name */
    public final Rect f1285x;
    public int y;

    /* renamed from: z  reason: collision with root package name */
    public boolean f1286z;

    /* loaded from: classes.dex */
    public interface gv {
        void gv();

        void n3();

        void onWindowVisibilityChanged(int i);

        void v();

        void y();

        void zn(boolean z2);
    }

    /* loaded from: classes.dex */
    public class n3 implements Runnable {
        public n3() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ActionBarOverlayLayout.this.r();
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.f1277q9 = actionBarOverlayLayout.f1280s.animate().translationY(0.0f).setListener(ActionBarOverlayLayout.this.f1272k);
        }
    }

    /* loaded from: classes.dex */
    public static class v extends ViewGroup.MarginLayoutParams {
        public v(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public v(int i, int i5) {
            super(i, i5);
        }

        public v(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    /* loaded from: classes.dex */
    public class y extends AnimatorListenerAdapter {
        public y() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.f1277q9 = null;
            actionBarOverlayLayout.f1279r = false;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.f1277q9 = null;
            actionBarOverlayLayout.f1279r = false;
        }
    }

    /* loaded from: classes.dex */
    public class zn implements Runnable {
        public zn() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ActionBarOverlayLayout.this.r();
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.f1277q9 = actionBarOverlayLayout.f1280s.animate().translationY(-ActionBarOverlayLayout.this.f1280s.getHeight()).setListener(ActionBarOverlayLayout.this.f1272k);
        }
    }

    public ActionBarOverlayLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1258c = new Rect();
        this.f1261d0 = new Rect();
        this.f1268fh = new Rect();
        this.f1260d = new Rect();
        this.f1262ej = new Rect();
        this.f1285x = new Rect();
        this.f1257b = new Rect();
        ej ejVar = ej.f8938n3;
        this.f1270j5 = ejVar;
        this.f1278qn = ejVar;
        this.f1274o = ejVar;
        this.f1269j = ejVar;
        this.f1272k = new y();
        this.f1266f7 = new n3();
        this.f1263en = new zn();
        x4(context);
        this.f1271jz = new xc(this);
    }

    @Override // wz.i4
    public void a() {
        c();
        this.f1264f.a();
    }

    public void c() {
        if (this.f1267fb == null) {
            this.f1267fb = (ContentFrameLayout) findViewById(R$id.f751n3);
            this.f1280s = (ActionBarContainer) findViewById(R$id.f770zn);
            this.f1264f = z(findViewById(R$id.y));
        }
    }

    @Override // hw.tl
    public void c5(View view, View view2, int i, int i5) {
        if (i5 == 0) {
            onNestedScrollAccepted(view, view2, i);
        }
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof v;
    }

    @Override // android.view.ViewGroup
    /* renamed from: co */
    public v generateLayoutParams(AttributeSet attributeSet) {
        return new v(getContext(), attributeSet);
    }

    public final void d0() {
        r();
        this.f1266f7.run();
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        int i;
        super.draw(canvas);
        if (this.f1281t != null && !this.f1284w) {
            if (this.f1280s.getVisibility() == 0) {
                i = (int) (this.f1280s.getBottom() + this.f1280s.getTranslationY() + 0.5f);
            } else {
                i = 0;
            }
            this.f1281t.setBounds(0, i, getWidth(), this.f1281t.getIntrinsicHeight() + i);
            this.f1281t.draw(canvas);
        }
    }

    @Override // hw.tl
    public void f(View view, int i, int i5, int[] iArr, int i6) {
        if (i6 == 0) {
            onNestedPreScroll(view, i, i5, iArr);
        }
    }

    public final void f3() {
        r();
        postDelayed(this.f1263en, 600L);
    }

    @Override // wz.i4
    public boolean fb() {
        c();
        return this.f1264f.fb();
    }

    public final boolean fh(float f4) {
        this.f1282ut.fling(0, 0, 0, (int) f4, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        if (this.f1282ut.getFinalY() > this.f1280s.getHeight()) {
            return true;
        }
        return false;
    }

    @Override // android.view.View
    public boolean fitSystemWindows(Rect rect) {
        return super.fitSystemWindows(rect);
    }

    public int getActionBarHideOffset() {
        ActionBarContainer actionBarContainer = this.f1280s;
        if (actionBarContainer != null) {
            return -((int) actionBarContainer.getTranslationY());
        }
        return 0;
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        return this.f1271jz.y();
    }

    public CharSequence getTitle() {
        c();
        return this.f1264f.getTitle();
    }

    @Override // wz.i4
    public void gv(Menu menu, c5.y yVar) {
        c();
        this.f1264f.gv(menu, yVar);
    }

    public boolean i4() {
        return this.f1276p;
    }

    @Override // hw.tl
    public void i9(View view, int i) {
        if (i == 0) {
            onStopNestedScroll(view);
        }
    }

    @Override // android.view.ViewGroup
    /* renamed from: mt */
    public v generateDefaultLayoutParams() {
        return new v(-1, -1);
    }

    public final void n() {
        r();
        postDelayed(this.f1266f7, 600L);
    }

    @Override // wz.i4
    public boolean n3() {
        c();
        return this.f1264f.n3();
    }

    @Override // android.view.View
    public WindowInsets onApplyWindowInsets(@NonNull WindowInsets windowInsets) {
        c();
        ej f32 = ej.f3(windowInsets, this);
        boolean p2 = p(this.f1280s, new Rect(f32.f(), f32.tl(), f32.t(), f32.i9()), true, true, false, true);
        hw.i4.s(this, f32, this.f1258c);
        Rect rect = this.f1258c;
        ej wz2 = f32.wz(rect.left, rect.top, rect.right, rect.bottom);
        this.f1270j5 = wz2;
        boolean z2 = true;
        if (!this.f1278qn.equals(wz2)) {
            this.f1278qn = this.f1270j5;
            p2 = true;
        }
        if (!this.f1261d0.equals(this.f1258c)) {
            this.f1261d0.set(this.f1258c);
        } else {
            z2 = p2;
        }
        if (z2) {
            requestLayout();
        }
        return f32.y().zn().n3().x4();
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        x4(getContext());
        hw.i4.yg(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        r();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z2, int i, int i5, int i6, int i8) {
        int childCount = getChildCount();
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            if (childAt.getVisibility() != 8) {
                v vVar = (v) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                int i11 = ((ViewGroup.MarginLayoutParams) vVar).leftMargin + paddingLeft;
                int i12 = ((ViewGroup.MarginLayoutParams) vVar).topMargin + paddingTop;
                childAt.layout(i11, i12, measuredWidth + i11, measuredHeight + i12);
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i5) {
        boolean z2;
        int measuredHeight;
        c();
        measureChildWithMargins(this.f1280s, i, 0, i5, 0);
        v vVar = (v) this.f1280s.getLayoutParams();
        int max = Math.max(0, this.f1280s.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) vVar).leftMargin + ((ViewGroup.MarginLayoutParams) vVar).rightMargin);
        int max2 = Math.max(0, this.f1280s.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) vVar).topMargin + ((ViewGroup.MarginLayoutParams) vVar).bottomMargin);
        int combineMeasuredStates = View.combineMeasuredStates(0, this.f1280s.getMeasuredState());
        if ((hw.i4.hw(this) & 256) != 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            measuredHeight = this.y;
            if (this.f1259co && this.f1280s.getTabContainer() != null) {
                measuredHeight += this.y;
            }
        } else {
            measuredHeight = this.f1280s.getVisibility() != 8 ? this.f1280s.getMeasuredHeight() : 0;
        }
        this.f1268fh.set(this.f1258c);
        ej ejVar = this.f1270j5;
        this.f1274o = ejVar;
        if (!this.f1276p && !z2) {
            Rect rect = this.f1268fh;
            rect.top += measuredHeight;
            rect.bottom = rect.bottom;
            this.f1274o = ejVar.wz(0, measuredHeight, 0, 0);
        } else {
            this.f1274o = new ej.n3(this.f1274o).zn(z6.n3.n3(ejVar.f(), this.f1274o.tl() + measuredHeight, this.f1274o.t(), this.f1274o.i9())).y();
        }
        p(this.f1267fb, this.f1268fh, true, true, true, true);
        if (!this.f1269j.equals(this.f1274o)) {
            ej ejVar2 = this.f1274o;
            this.f1269j = ejVar2;
            hw.i4.c5(this.f1267fb, ejVar2);
        }
        measureChildWithMargins(this.f1267fb, i, 0, i5, 0);
        v vVar2 = (v) this.f1267fb.getLayoutParams();
        int max3 = Math.max(max, this.f1267fb.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) vVar2).leftMargin + ((ViewGroup.MarginLayoutParams) vVar2).rightMargin);
        int max4 = Math.max(max2, this.f1267fb.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) vVar2).topMargin + ((ViewGroup.MarginLayoutParams) vVar2).bottomMargin);
        int combineMeasuredStates2 = View.combineMeasuredStates(combineMeasuredStates, this.f1267fb.getMeasuredState());
        setMeasuredDimension(View.resolveSizeAndState(Math.max(max3 + getPaddingLeft() + getPaddingRight(), getSuggestedMinimumWidth()), i, combineMeasuredStates2), View.resolveSizeAndState(Math.max(max4 + getPaddingTop() + getPaddingBottom(), getSuggestedMinimumHeight()), i5, combineMeasuredStates2 << 16));
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedFling(View view, float f4, float f6, boolean z2) {
        if (this.f1286z && z2) {
            if (fh(f6)) {
                w();
            } else {
                d0();
            }
            this.f1279r = true;
            return true;
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedPreFling(View view, float f4, float f6) {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedPreScroll(View view, int i, int i5, int[] iArr) {
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedScroll(View view, int i, int i5, int i6, int i8) {
        int i10 = this.f1265f3 + i5;
        this.f1265f3 = i10;
        setActionBarHideOffset(i10);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedScrollAccepted(View view, View view2, int i) {
        this.f1271jz.n3(view, view2, i);
        this.f1265f3 = getActionBarHideOffset();
        r();
        gv gvVar = this.f1275oz;
        if (gvVar != null) {
            gvVar.v();
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onStartNestedScroll(View view, View view2, int i) {
        if ((i & 2) != 0 && this.f1280s.getVisibility() == 0) {
            return this.f1286z;
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onStopNestedScroll(View view) {
        if (this.f1286z && !this.f1279r) {
            if (this.f1265f3 <= this.f1280s.getHeight()) {
                n();
            } else {
                f3();
            }
        }
        gv gvVar = this.f1275oz;
        if (gvVar != null) {
            gvVar.n3();
        }
    }

    @Override // android.view.View
    @Deprecated
    public void onWindowSystemUiVisibilityChanged(int i) {
        boolean z2;
        super.onWindowSystemUiVisibilityChanged(i);
        c();
        int i5 = this.f1273n ^ i;
        this.f1273n = i;
        boolean z3 = false;
        if ((i & 4) == 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if ((i & 256) != 0) {
            z3 = true;
        }
        gv gvVar = this.f1275oz;
        if (gvVar != null) {
            gvVar.zn(!z3);
            if (!z2 && z3) {
                this.f1275oz.gv();
            } else {
                this.f1275oz.y();
            }
        }
        if ((i5 & 256) != 0 && this.f1275oz != null) {
            hw.i4.yg(this);
        }
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        this.f1283v = i;
        gv gvVar = this.f1275oz;
        if (gvVar != null) {
            gvVar.onWindowVisibilityChanged(i);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0021  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0016  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean p(@androidx.annotation.NonNull android.view.View r3, @androidx.annotation.NonNull android.graphics.Rect r4, boolean r5, boolean r6, boolean r7, boolean r8) {
        /*
            r2 = this;
            android.view.ViewGroup$LayoutParams r3 = r3.getLayoutParams()
            androidx.appcompat.widget.ActionBarOverlayLayout$v r3 = (androidx.appcompat.widget.ActionBarOverlayLayout.v) r3
            r0 = 1
            if (r5 == 0) goto L13
            int r5 = r3.leftMargin
            int r1 = r4.left
            if (r5 == r1) goto L13
            r3.leftMargin = r1
            r5 = 1
            goto L14
        L13:
            r5 = 0
        L14:
            if (r6 == 0) goto L1f
            int r6 = r3.topMargin
            int r1 = r4.top
            if (r6 == r1) goto L1f
            r3.topMargin = r1
            r5 = 1
        L1f:
            if (r8 == 0) goto L2a
            int r6 = r3.rightMargin
            int r8 = r4.right
            if (r6 == r8) goto L2a
            r3.rightMargin = r8
            r5 = 1
        L2a:
            if (r7 == 0) goto L35
            int r6 = r3.bottomMargin
            int r4 = r4.bottom
            if (r6 == r4) goto L35
            r3.bottomMargin = r4
            goto L36
        L35:
            r0 = r5
        L36:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ActionBarOverlayLayout.p(android.view.View, android.graphics.Rect, boolean, boolean, boolean, boolean):boolean");
    }

    public void r() {
        removeCallbacks(this.f1266f7);
        removeCallbacks(this.f1263en);
        ViewPropertyAnimator viewPropertyAnimator = this.f1277q9;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
        }
    }

    @Override // wz.i4
    public void s(int i) {
        c();
        if (i != 2) {
            if (i != 5) {
                if (i == 109) {
                    setOverlayMode(true);
                    return;
                }
                return;
            }
            this.f1264f.i4();
            return;
        }
        this.f1264f.w();
    }

    public void setActionBarHideOffset(int i) {
        r();
        this.f1280s.setTranslationY(-Math.max(0, Math.min(i, this.f1280s.getHeight())));
    }

    public void setActionBarVisibilityCallback(gv gvVar) {
        this.f1275oz = gvVar;
        if (getWindowToken() != null) {
            this.f1275oz.onWindowVisibilityChanged(this.f1283v);
            int i = this.f1273n;
            if (i != 0) {
                onWindowSystemUiVisibilityChanged(i);
                hw.i4.yg(this);
            }
        }
    }

    public void setHasNonEmbeddedTabs(boolean z2) {
        this.f1259co = z2;
    }

    public void setHideOnContentScrollEnabled(boolean z2) {
        if (z2 != this.f1286z) {
            this.f1286z = z2;
            if (!z2) {
                r();
                setActionBarHideOffset(0);
            }
        }
    }

    public void setIcon(int i) {
        c();
        this.f1264f.setIcon(i);
    }

    public void setLogo(int i) {
        c();
        this.f1264f.z(i);
    }

    public void setOverlayMode(boolean z2) {
        boolean z3;
        this.f1276p = z2;
        if (z2 && getContext().getApplicationInfo().targetSdkVersion < 19) {
            z3 = true;
        } else {
            z3 = false;
        }
        this.f1284w = z3;
    }

    public void setShowingForActionMode(boolean z2) {
    }

    public void setUiOptions(int i) {
    }

    @Override // wz.i4
    public void setWindowCallback(Window.Callback callback) {
        c();
        this.f1264f.setWindowCallback(callback);
    }

    @Override // wz.i4
    public void setWindowTitle(CharSequence charSequence) {
        c();
        this.f1264f.setWindowTitle(charSequence);
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    @Override // wz.i4
    public void t() {
        c();
        this.f1264f.mt();
    }

    @Override // hw.wz
    public void tl(View view, int i, int i5, int i6, int i8, int i10, int[] iArr) {
        wz(view, i, i5, i6, i8, i10);
    }

    @Override // wz.i4
    public boolean v() {
        c();
        return this.f1264f.v();
    }

    public final void w() {
        r();
        this.f1263en.run();
    }

    @Override // hw.tl
    public void wz(View view, int i, int i5, int i6, int i8, int i10) {
        if (i10 == 0) {
            onNestedScroll(view, i, i5, i6, i8);
        }
    }

    public final void x4(Context context) {
        boolean z2;
        TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(f1256u);
        boolean z3 = false;
        this.y = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        Drawable drawable = obtainStyledAttributes.getDrawable(1);
        this.f1281t = drawable;
        if (drawable == null) {
            z2 = true;
        } else {
            z2 = false;
        }
        setWillNotDraw(z2);
        obtainStyledAttributes.recycle();
        if (context.getApplicationInfo().targetSdkVersion < 19) {
            z3 = true;
        }
        this.f1284w = z3;
        this.f1282ut = new OverScroller(context);
    }

    @Override // hw.tl
    public boolean xc(View view, View view2, int i, int i5) {
        if (i5 == 0 && onStartNestedScroll(view, view2, i)) {
            return true;
        }
        return false;
    }

    @Override // wz.i4
    public boolean y() {
        c();
        return this.f1264f.y();
    }

    public final f3 z(View view) {
        if (view instanceof f3) {
            return (f3) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        throw new IllegalStateException("Can't make a decor toolbar out of " + view.getClass().getSimpleName());
    }

    @Override // wz.i4
    public boolean zn() {
        c();
        return this.f1264f.zn();
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new v(layoutParams);
    }

    public void setIcon(Drawable drawable) {
        c();
        this.f1264f.setIcon(drawable);
    }
}
