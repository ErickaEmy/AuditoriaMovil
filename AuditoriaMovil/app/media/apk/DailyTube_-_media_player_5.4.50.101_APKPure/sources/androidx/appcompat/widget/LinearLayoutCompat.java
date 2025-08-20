package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.R$styleable;
import com.uv.v7.R;
import hw.i4;
import wz.hw;
import wz.oz;
/* loaded from: classes.dex */
public class LinearLayoutCompat extends ViewGroup {

    /* renamed from: c  reason: collision with root package name */
    public int f1343c;

    /* renamed from: co  reason: collision with root package name */
    public int[] f1344co;

    /* renamed from: d0  reason: collision with root package name */
    public int f1345d0;

    /* renamed from: f  reason: collision with root package name */
    public int f1346f;

    /* renamed from: f3  reason: collision with root package name */
    public int f1347f3;

    /* renamed from: fb  reason: collision with root package name */
    public int f1348fb;

    /* renamed from: n  reason: collision with root package name */
    public int f1349n;

    /* renamed from: p  reason: collision with root package name */
    public boolean f1350p;

    /* renamed from: r  reason: collision with root package name */
    public Drawable f1351r;

    /* renamed from: s  reason: collision with root package name */
    public int f1352s;

    /* renamed from: t  reason: collision with root package name */
    public int f1353t;

    /* renamed from: v  reason: collision with root package name */
    public int f1354v;

    /* renamed from: w  reason: collision with root package name */
    public float f1355w;
    public boolean y;

    /* renamed from: z  reason: collision with root package name */
    public int[] f1356z;

    /* loaded from: classes.dex */
    public static class y extends LinearLayout.LayoutParams {
        public y(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public y(int i, int i5) {
            super(i, i5);
        }

        public y(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    public LinearLayoutCompat(@NonNull Context context) {
        this(context, null);
    }

    private void d0(View view, int i, int i5, int i6, int i8) {
        view.layout(i, i5, i6 + i, i8 + i5);
    }

    private void t(int i, int i5) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824);
        for (int i6 = 0; i6 < i; i6++) {
            View co2 = co(i6);
            if (co2.getVisibility() != 8) {
                y yVar = (y) co2.getLayoutParams();
                if (((LinearLayout.LayoutParams) yVar).width == -1) {
                    int i8 = ((LinearLayout.LayoutParams) yVar).height;
                    ((LinearLayout.LayoutParams) yVar).height = co2.getMeasuredHeight();
                    measureChildWithMargins(co2, makeMeasureSpec, 0, i5, 0);
                    ((LinearLayout.LayoutParams) yVar).height = i8;
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:143:0x031a, code lost:
        if (((android.widget.LinearLayout.LayoutParams) r14).width == (-1)) goto L158;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void c(int r34, int r35) {
        /*
            Method dump skipped, instructions count: 908
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.LinearLayoutCompat.c(int, int):void");
    }

    public void c5(Canvas canvas, int i) {
        this.f1351r.setBounds(getPaddingLeft() + this.f1345d0, i, (getWidth() - getPaddingRight()) - this.f1345d0, this.f1349n + i);
        this.f1351r.draw(canvas);
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof y;
    }

    public View co(int i) {
        return getChildAt(i);
    }

    public final void f(int i, int i5) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824);
        for (int i6 = 0; i6 < i; i6++) {
            View co2 = co(i6);
            if (co2.getVisibility() != 8) {
                y yVar = (y) co2.getLayoutParams();
                if (((LinearLayout.LayoutParams) yVar).height == -1) {
                    int i8 = ((LinearLayout.LayoutParams) yVar).width;
                    ((LinearLayout.LayoutParams) yVar).width = co2.getMeasuredWidth();
                    measureChildWithMargins(co2, i5, 0, makeMeasureSpec, 0);
                    ((LinearLayout.LayoutParams) yVar).width = i8;
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:200:0x0455  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0193  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01c7  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x01d5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void f3(int r39, int r40) {
        /*
            Method dump skipped, instructions count: 1287
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.LinearLayoutCompat.f3(int, int):void");
    }

    public void fb(Canvas canvas) {
        int right;
        int left;
        int i;
        int left2;
        int virtualChildCount = getVirtualChildCount();
        boolean n32 = oz.n3(this);
        for (int i5 = 0; i5 < virtualChildCount; i5++) {
            View co2 = co(i5);
            if (co2 != null && co2.getVisibility() != 8 && z(i5)) {
                y yVar = (y) co2.getLayoutParams();
                if (n32) {
                    left2 = co2.getRight() + ((LinearLayout.LayoutParams) yVar).rightMargin;
                } else {
                    left2 = (co2.getLeft() - ((LinearLayout.LayoutParams) yVar).leftMargin) - this.f1347f3;
                }
                i9(canvas, left2);
            }
        }
        if (z(virtualChildCount)) {
            View co3 = co(virtualChildCount - 1);
            if (co3 == null) {
                if (n32) {
                    right = getPaddingLeft();
                } else {
                    left = getWidth() - getPaddingRight();
                    i = this.f1347f3;
                    right = left - i;
                }
            } else {
                y yVar2 = (y) co3.getLayoutParams();
                if (n32) {
                    left = co3.getLeft() - ((LinearLayout.LayoutParams) yVar2).leftMargin;
                    i = this.f1347f3;
                    right = left - i;
                } else {
                    right = co3.getRight() + ((LinearLayout.LayoutParams) yVar2).rightMargin;
                }
            }
            i9(canvas, right);
        }
    }

    @Override // android.view.View
    public int getBaseline() {
        int i;
        if (this.f1354v < 0) {
            return super.getBaseline();
        }
        int childCount = getChildCount();
        int i5 = this.f1354v;
        if (childCount > i5) {
            View childAt = getChildAt(i5);
            int baseline = childAt.getBaseline();
            if (baseline == -1) {
                if (this.f1354v == 0) {
                    return -1;
                }
                throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout points to a View that doesn't know how to get its baseline.");
            }
            int i6 = this.f1348fb;
            if (this.f1352s == 1 && (i = this.f1346f & R.styleable.AppCompatTheme_toolbarNavigationButtonStyle) != 48) {
                if (i != 16) {
                    if (i == 80) {
                        i6 = ((getBottom() - getTop()) - getPaddingBottom()) - this.f1353t;
                    }
                } else {
                    i6 += ((((getBottom() - getTop()) - getPaddingTop()) - getPaddingBottom()) - this.f1353t) / 2;
                }
            }
            return i6 + ((LinearLayout.LayoutParams) ((y) childAt.getLayoutParams())).topMargin + baseline;
        }
        throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout set to an index that is out of bounds.");
    }

    public int getBaselineAlignedChildIndex() {
        return this.f1354v;
    }

    public Drawable getDividerDrawable() {
        return this.f1351r;
    }

    public int getDividerPadding() {
        return this.f1345d0;
    }

    public int getDividerWidth() {
        return this.f1347f3;
    }

    public int getGravity() {
        return this.f1346f;
    }

    public int getOrientation() {
        return this.f1352s;
    }

    public int getShowDividers() {
        return this.f1343c;
    }

    public int getVirtualChildCount() {
        return getChildCount();
    }

    public float getWeightSum() {
        return this.f1355w;
    }

    public void i4(View view, int i, int i5, int i6, int i8, int i10) {
        measureChildWithMargins(view, i5, i6, i8, i10);
    }

    public void i9(Canvas canvas, int i) {
        this.f1351r.setBounds(i, getPaddingTop() + this.f1345d0, this.f1347f3 + i, (getHeight() - getPaddingBottom()) - this.f1345d0);
        this.f1351r.draw(canvas);
    }

    public int mt(View view) {
        return 0;
    }

    public int n(int i) {
        return 0;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (this.f1351r == null) {
            return;
        }
        if (this.f1352s == 1) {
            s(canvas);
        } else {
            fb(canvas);
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName("androidx.appcompat.widget.LinearLayoutCompat");
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("androidx.appcompat.widget.LinearLayoutCompat");
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z2, int i, int i5, int i6, int i8) {
        if (this.f1352s == 1) {
            x4(i, i5, i6, i8);
        } else {
            r(i, i5, i6, i8);
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i5) {
        if (this.f1352s == 1) {
            c(i, i5);
        } else {
            f3(i, i5);
        }
    }

    public int p(View view) {
        return 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0100  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void r(int r25, int r26, int r27, int r28) {
        /*
            Method dump skipped, instructions count: 322
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.LinearLayoutCompat.r(int, int, int, int):void");
    }

    public void s(Canvas canvas) {
        int bottom;
        int virtualChildCount = getVirtualChildCount();
        for (int i = 0; i < virtualChildCount; i++) {
            View co2 = co(i);
            if (co2 != null && co2.getVisibility() != 8 && z(i)) {
                c5(canvas, (co2.getTop() - ((LinearLayout.LayoutParams) ((y) co2.getLayoutParams())).topMargin) - this.f1349n);
            }
        }
        if (z(virtualChildCount)) {
            View co3 = co(virtualChildCount - 1);
            if (co3 == null) {
                bottom = (getHeight() - getPaddingBottom()) - this.f1349n;
            } else {
                bottom = co3.getBottom() + ((LinearLayout.LayoutParams) ((y) co3.getLayoutParams())).bottomMargin;
            }
            c5(canvas, bottom);
        }
    }

    public void setBaselineAligned(boolean z2) {
        this.y = z2;
    }

    public void setBaselineAlignedChildIndex(int i) {
        if (i >= 0 && i < getChildCount()) {
            this.f1354v = i;
            return;
        }
        throw new IllegalArgumentException("base aligned child index out of range (0, " + getChildCount() + ")");
    }

    public void setDividerDrawable(Drawable drawable) {
        if (drawable == this.f1351r) {
            return;
        }
        this.f1351r = drawable;
        boolean z2 = false;
        if (drawable != null) {
            this.f1347f3 = drawable.getIntrinsicWidth();
            this.f1349n = drawable.getIntrinsicHeight();
        } else {
            this.f1347f3 = 0;
            this.f1349n = 0;
        }
        if (drawable == null) {
            z2 = true;
        }
        setWillNotDraw(z2);
        requestLayout();
    }

    public void setDividerPadding(int i) {
        this.f1345d0 = i;
    }

    public void setGravity(int i) {
        if (this.f1346f != i) {
            if ((8388615 & i) == 0) {
                i |= 8388611;
            }
            if ((i & R.styleable.AppCompatTheme_toolbarNavigationButtonStyle) == 0) {
                i |= 48;
            }
            this.f1346f = i;
            requestLayout();
        }
    }

    public void setHorizontalGravity(int i) {
        int i5 = i & 8388615;
        int i6 = this.f1346f;
        if ((8388615 & i6) != i5) {
            this.f1346f = i5 | ((-8388616) & i6);
            requestLayout();
        }
    }

    public void setMeasureWithLargestChildEnabled(boolean z2) {
        this.f1350p = z2;
    }

    public void setOrientation(int i) {
        if (this.f1352s != i) {
            this.f1352s = i;
            requestLayout();
        }
    }

    public void setShowDividers(int i) {
        if (i != this.f1343c) {
            requestLayout();
        }
        this.f1343c = i;
    }

    public void setVerticalGravity(int i) {
        int i5 = i & R.styleable.AppCompatTheme_toolbarNavigationButtonStyle;
        int i6 = this.f1346f;
        if ((i6 & R.styleable.AppCompatTheme_toolbarNavigationButtonStyle) != i5) {
            this.f1346f = i5 | (i6 & (-113));
            requestLayout();
        }
    }

    public void setWeightSum(float f4) {
        this.f1355w = Math.max(0.0f, f4);
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    @Override // android.view.ViewGroup
    /* renamed from: tl */
    public y generateDefaultLayoutParams() {
        int i = this.f1352s;
        if (i == 0) {
            return new y(-2, -2);
        }
        if (i == 1) {
            return new y(-1, -2);
        }
        return null;
    }

    public int w(View view, int i) {
        return 0;
    }

    @Override // android.view.ViewGroup
    /* renamed from: wz */
    public y generateLayoutParams(AttributeSet attributeSet) {
        return new y(getContext(), attributeSet);
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x00a1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void x4(int r18, int r19, int r20, int r21) {
        /*
            r17 = this;
            r6 = r17
            int r7 = r17.getPaddingLeft()
            int r0 = r20 - r18
            int r1 = r17.getPaddingRight()
            int r8 = r0 - r1
            int r0 = r0 - r7
            int r1 = r17.getPaddingRight()
            int r9 = r0 - r1
            int r10 = r17.getVirtualChildCount()
            int r0 = r6.f1346f
            r1 = r0 & 112(0x70, float:1.57E-43)
            r2 = 8388615(0x800007, float:1.1754953E-38)
            r11 = r0 & r2
            r0 = 16
            if (r1 == r0) goto L3b
            r0 = 80
            if (r1 == r0) goto L2f
            int r0 = r17.getPaddingTop()
            goto L47
        L2f:
            int r0 = r17.getPaddingTop()
            int r0 = r0 + r21
            int r0 = r0 - r19
            int r1 = r6.f1353t
            int r0 = r0 - r1
            goto L47
        L3b:
            int r0 = r17.getPaddingTop()
            int r1 = r21 - r19
            int r2 = r6.f1353t
            int r1 = r1 - r2
            int r1 = r1 / 2
            int r0 = r0 + r1
        L47:
            r1 = 0
            r12 = 0
        L49:
            if (r12 >= r10) goto Lcb
            android.view.View r13 = r6.co(r12)
            r14 = 1
            if (r13 != 0) goto L5a
            int r1 = r6.n(r12)
            int r0 = r0 + r1
        L57:
            r1 = 1
            goto Lc8
        L5a:
            int r1 = r13.getVisibility()
            r2 = 8
            if (r1 == r2) goto L57
            int r4 = r13.getMeasuredWidth()
            int r15 = r13.getMeasuredHeight()
            android.view.ViewGroup$LayoutParams r1 = r13.getLayoutParams()
            r5 = r1
            androidx.appcompat.widget.LinearLayoutCompat$y r5 = (androidx.appcompat.widget.LinearLayoutCompat.y) r5
            int r1 = r5.gravity
            if (r1 >= 0) goto L76
            r1 = r11
        L76:
            int r2 = hw.i4.ta(r17)
            int r1 = hw.v.n3(r1, r2)
            r1 = r1 & 7
            if (r1 == r14) goto L90
            r2 = 5
            if (r1 == r2) goto L8a
            int r1 = r5.leftMargin
            int r1 = r1 + r7
        L88:
            r2 = r1
            goto L9b
        L8a:
            int r1 = r8 - r4
            int r2 = r5.rightMargin
        L8e:
            int r1 = r1 - r2
            goto L88
        L90:
            int r1 = r9 - r4
            int r1 = r1 / 2
            int r1 = r1 + r7
            int r2 = r5.leftMargin
            int r1 = r1 + r2
            int r2 = r5.rightMargin
            goto L8e
        L9b:
            boolean r1 = r6.z(r12)
            if (r1 == 0) goto La4
            int r1 = r6.f1349n
            int r0 = r0 + r1
        La4:
            int r1 = r5.topMargin
            int r16 = r0 + r1
            int r0 = r6.p(r13)
            int r3 = r16 + r0
            r0 = r17
            r1 = r13
            r14 = r5
            r5 = r15
            r0.d0(r1, r2, r3, r4, r5)
            int r0 = r14.bottomMargin
            int r15 = r15 + r0
            int r0 = r6.mt(r13)
            int r15 = r15 + r0
            int r16 = r16 + r15
            int r0 = r6.w(r13, r12)
            int r12 = r12 + r0
            r0 = r16
            goto L57
        Lc8:
            int r12 = r12 + r1
            goto L49
        Lcb:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.LinearLayoutCompat.x4(int, int, int, int):void");
    }

    @Override // android.view.ViewGroup
    /* renamed from: xc */
    public y generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new y(layoutParams);
    }

    public boolean z(int i) {
        if (i == 0) {
            if ((this.f1343c & 1) == 0) {
                return false;
            }
            return true;
        } else if (i == getChildCount()) {
            if ((this.f1343c & 4) == 0) {
                return false;
            }
            return true;
        } else if ((this.f1343c & 2) == 0) {
            return false;
        } else {
            for (int i5 = i - 1; i5 >= 0; i5--) {
                if (getChildAt(i5).getVisibility() != 8) {
                    return true;
                }
            }
            return false;
        }
    }

    public LinearLayoutCompat(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LinearLayoutCompat(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.y = true;
        this.f1354v = -1;
        this.f1346f = 8388659;
        int[] iArr = R$styleable.f883q;
        hw x42 = hw.x4(context, attributeSet, iArr, i, 0);
        i4.kp(this, context, iArr, attributeSet, x42.mt(), i, 0);
        int f4 = x42.f(R$styleable.f872nd, -1);
        if (f4 >= 0) {
            setOrientation(f4);
        }
        int f6 = x42.f(R$styleable.f915wm, -1);
        if (f6 >= 0) {
            setGravity(f6);
        }
        boolean y2 = x42.y(R$styleable.gf, true);
        if (!y2) {
            setBaselineAligned(y2);
        }
        this.f1355w = x42.c5(R$styleable.fc, -1.0f);
        this.f1354v = x42.f(R$styleable.f814bv, -1);
        this.f1350p = x42.y(R$styleable.im, false);
        setDividerDrawable(x42.fb(R$styleable.f813br));
        this.f1343c = x42.f(R$styleable.mh, 0);
        this.f1345d0 = x42.a(R$styleable.f905uo, 0);
        x42.i4();
    }
}
