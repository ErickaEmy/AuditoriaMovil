package com.google.android.flexbox;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import com.google.android.flexbox.n3;
import hw.i4;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class FlexboxLayout extends ViewGroup implements zf.y {

    /* renamed from: c  reason: collision with root package name */
    public SparseIntArray f4945c;

    /* renamed from: co  reason: collision with root package name */
    public int f4946co;

    /* renamed from: d  reason: collision with root package name */
    public n3.C0056n3 f4947d;

    /* renamed from: d0  reason: collision with root package name */
    public n3 f4948d0;

    /* renamed from: f  reason: collision with root package name */
    public int f4949f;

    /* renamed from: f3  reason: collision with root package name */
    public int f4950f3;

    /* renamed from: fb  reason: collision with root package name */
    public int f4951fb;

    /* renamed from: fh  reason: collision with root package name */
    public List<y> f4952fh;

    /* renamed from: n  reason: collision with root package name */
    public int[] f4953n;
    @Nullable

    /* renamed from: p  reason: collision with root package name */
    public Drawable f4954p;

    /* renamed from: r  reason: collision with root package name */
    public int f4955r;

    /* renamed from: s  reason: collision with root package name */
    public int f4956s;

    /* renamed from: t  reason: collision with root package name */
    public int f4957t;

    /* renamed from: v  reason: collision with root package name */
    public int f4958v;
    @Nullable

    /* renamed from: w  reason: collision with root package name */
    public Drawable f4959w;
    public int y;

    /* renamed from: z  reason: collision with root package name */
    public int f4960z;

    public FlexboxLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // zf.y
    public int a(View view) {
        return 0;
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (this.f4945c == null) {
            this.f4945c = new SparseIntArray(getChildCount());
        }
        this.f4953n = this.f4948d0.wz(view, i, layoutParams, this.f4945c);
        super.addView(view, i, layoutParams);
    }

    public final void c(int i, int i5, int i6, int i8) {
        int sumOfCrossSize;
        int largestMainSize;
        int resolveSizeAndState;
        int resolveSizeAndState2;
        int mode = View.MeasureSpec.getMode(i5);
        int size = View.MeasureSpec.getSize(i5);
        int mode2 = View.MeasureSpec.getMode(i6);
        int size2 = View.MeasureSpec.getSize(i6);
        if (i != 0 && i != 1) {
            if (i != 2 && i != 3) {
                throw new IllegalArgumentException("Invalid flex direction: " + i);
            }
            sumOfCrossSize = getLargestMainSize();
            largestMainSize = getSumOfCrossSize() + getPaddingLeft() + getPaddingRight();
        } else {
            sumOfCrossSize = getSumOfCrossSize() + getPaddingTop() + getPaddingBottom();
            largestMainSize = getLargestMainSize();
        }
        if (mode != Integer.MIN_VALUE) {
            if (mode != 0) {
                if (mode == 1073741824) {
                    if (size < largestMainSize) {
                        i8 = View.combineMeasuredStates(i8, 16777216);
                    }
                    resolveSizeAndState = View.resolveSizeAndState(size, i5, i8);
                } else {
                    throw new IllegalStateException("Unknown width mode is set: " + mode);
                }
            } else {
                resolveSizeAndState = View.resolveSizeAndState(largestMainSize, i5, i8);
            }
        } else {
            if (size < largestMainSize) {
                i8 = View.combineMeasuredStates(i8, 16777216);
            } else {
                size = largestMainSize;
            }
            resolveSizeAndState = View.resolveSizeAndState(size, i5, i8);
        }
        if (mode2 != Integer.MIN_VALUE) {
            if (mode2 != 0) {
                if (mode2 == 1073741824) {
                    if (size2 < sumOfCrossSize) {
                        i8 = View.combineMeasuredStates(i8, 256);
                    }
                    resolveSizeAndState2 = View.resolveSizeAndState(size2, i6, i8);
                } else {
                    throw new IllegalStateException("Unknown height mode is set: " + mode2);
                }
            } else {
                resolveSizeAndState2 = View.resolveSizeAndState(sumOfCrossSize, i6, i8);
            }
        } else {
            if (size2 < sumOfCrossSize) {
                i8 = View.combineMeasuredStates(i8, 256);
            } else {
                size2 = sumOfCrossSize;
            }
            resolveSizeAndState2 = View.resolveSizeAndState(size2, i6, i8);
        }
        setMeasuredDimension(resolveSizeAndState, resolveSizeAndState2);
    }

    @Override // zf.y
    public void c5(int i, View view) {
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    public final boolean co(int i, int i5) {
        if (t(i, i5)) {
            if (f()) {
                if ((this.f4960z & 1) == 0) {
                    return false;
                }
                return true;
            } else if ((this.f4946co & 1) == 0) {
                return false;
            } else {
                return true;
            }
        } else if (f()) {
            if ((this.f4960z & 2) == 0) {
                return false;
            }
            return true;
        } else if ((this.f4946co & 2) == 0) {
            return false;
        } else {
            return true;
        }
    }

    public final void d0() {
        if (this.f4959w == null && this.f4954p == null) {
            setWillNotDraw(true);
        } else {
            setWillNotDraw(false);
        }
    }

    @Override // zf.y
    public boolean f() {
        int i = this.y;
        if (i == 0 || i == 1) {
            return true;
        }
        return false;
    }

    public final void f3(int i, int i5) {
        this.f4952fh.clear();
        this.f4947d.y();
        this.f4948d0.zn(this.f4947d, i, i5);
        this.f4952fh = this.f4947d.y;
        this.f4948d0.w(i, i5);
        if (this.f4956s == 3) {
            for (y yVar : this.f4952fh) {
                int i6 = Integer.MIN_VALUE;
                for (int i8 = 0; i8 < yVar.f5067s; i8++) {
                    View mt2 = mt(yVar.f5073xc + i8);
                    if (mt2 != null && mt2.getVisibility() != 8) {
                        LayoutParams layoutParams = (LayoutParams) mt2.getLayoutParams();
                        if (this.f4958v != 2) {
                            i6 = Math.max(i6, mt2.getMeasuredHeight() + Math.max(yVar.f5068t - mt2.getBaseline(), ((ViewGroup.MarginLayoutParams) layoutParams).topMargin) + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin);
                        } else {
                            i6 = Math.max(i6, mt2.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + Math.max((yVar.f5068t - mt2.getMeasuredHeight()) + mt2.getBaseline(), ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin));
                        }
                    }
                }
                yVar.f5061fb = i6;
            }
        }
        this.f4948d0.xc(i, i5, getPaddingTop() + getPaddingBottom());
        this.f4948d0.k();
        c(this.y, i, i5, this.f4947d.f5056n3);
    }

    @Override // zf.y
    public void fb(y yVar) {
        if (f()) {
            if ((this.f4960z & 4) > 0) {
                int i = yVar.f5070v;
                int i5 = this.f4950f3;
                yVar.f5070v = i + i5;
                yVar.f5058a += i5;
            }
        } else if ((this.f4946co & 4) > 0) {
            int i6 = yVar.f5070v;
            int i8 = this.f4955r;
            yVar.f5070v = i6 + i8;
            yVar.f5058a += i8;
        }
    }

    @Override // zf.y
    public int getAlignContent() {
        return this.f4949f;
    }

    @Override // zf.y
    public int getAlignItems() {
        return this.f4956s;
    }

    @Nullable
    public Drawable getDividerDrawableHorizontal() {
        return this.f4959w;
    }

    @Nullable
    public Drawable getDividerDrawableVertical() {
        return this.f4954p;
    }

    @Override // zf.y
    public int getFlexDirection() {
        return this.y;
    }

    @Override // zf.y
    public int getFlexItemCount() {
        return getChildCount();
    }

    public List<y> getFlexLines() {
        ArrayList arrayList = new ArrayList(this.f4952fh.size());
        for (y yVar : this.f4952fh) {
            if (yVar.zn() != 0) {
                arrayList.add(yVar);
            }
        }
        return arrayList;
    }

    @Override // zf.y
    public List<y> getFlexLinesInternal() {
        return this.f4952fh;
    }

    @Override // zf.y
    public int getFlexWrap() {
        return this.f4958v;
    }

    public int getJustifyContent() {
        return this.f4951fb;
    }

    @Override // zf.y
    public int getLargestMainSize() {
        int i = Integer.MIN_VALUE;
        for (y yVar : this.f4952fh) {
            i = Math.max(i, yVar.f5070v);
        }
        return i;
    }

    @Override // zf.y
    public int getMaxLine() {
        return this.f4957t;
    }

    public int getShowDividerHorizontal() {
        return this.f4946co;
    }

    public int getShowDividerVertical() {
        return this.f4960z;
    }

    @Override // zf.y
    public int getSumOfCrossSize() {
        int i;
        int i5;
        int size = this.f4952fh.size();
        int i6 = 0;
        for (int i8 = 0; i8 < size; i8++) {
            y yVar = this.f4952fh.get(i8);
            if (z(i8)) {
                if (f()) {
                    i5 = this.f4955r;
                } else {
                    i5 = this.f4950f3;
                }
                i6 += i5;
            }
            if (r(i8)) {
                if (f()) {
                    i = this.f4955r;
                } else {
                    i = this.f4950f3;
                }
                i6 += i;
            }
            i6 += yVar.f5061fb;
        }
        return i6;
    }

    @Override // zf.y
    public View gv(int i) {
        return getChildAt(i);
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0185  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x01e8  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x01f5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void i4(boolean r30, boolean r31, int r32, int r33, int r34, int r35) {
        /*
            Method dump skipped, instructions count: 532
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.flexbox.FlexboxLayout.i4(boolean, boolean, int, int, int, int):void");
    }

    @Override // zf.y
    public int i9(View view, int i, int i5) {
        int i6;
        int i8 = 0;
        if (f()) {
            if (co(i, i5)) {
                i8 = this.f4950f3;
            }
            if ((this.f4960z & 4) > 0) {
                i6 = this.f4950f3;
            } else {
                return i8;
            }
        } else {
            if (co(i, i5)) {
                i8 = this.f4955r;
            }
            if ((this.f4946co & 4) > 0) {
                i6 = this.f4955r;
            } else {
                return i8;
            }
        }
        return i8 + i6;
    }

    public View mt(int i) {
        if (i >= 0) {
            int[] iArr = this.f4953n;
            if (i < iArr.length) {
                return getChildAt(iArr[i]);
            }
            return null;
        }
        return null;
    }

    public final void n(int i, int i5) {
        this.f4952fh.clear();
        this.f4947d.y();
        this.f4948d0.a(this.f4947d, i, i5);
        this.f4952fh = this.f4947d.y;
        this.f4948d0.w(i, i5);
        this.f4948d0.xc(i, i5, getPaddingLeft() + getPaddingRight());
        this.f4948d0.k();
        c(this.y, i, i5, this.f4947d.f5056n3);
    }

    @Override // zf.y
    public void n3(View view, int i, int i5, y yVar) {
        if (co(i, i5)) {
            if (f()) {
                int i6 = yVar.f5070v;
                int i8 = this.f4950f3;
                yVar.f5070v = i6 + i8;
                yVar.f5058a += i8;
                return;
            }
            int i10 = yVar.f5070v;
            int i11 = this.f4955r;
            yVar.f5070v = i10 + i11;
            yVar.f5058a += i11;
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        boolean z2;
        boolean z3;
        if (this.f4954p == null && this.f4959w == null) {
            return;
        }
        if (this.f4946co == 0 && this.f4960z == 0) {
            return;
        }
        int ta2 = i4.ta(this);
        int i = this.y;
        boolean z4 = false;
        boolean z5 = true;
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i == 3) {
                        if (ta2 == 1) {
                            z4 = true;
                        }
                        if (this.f4958v == 2) {
                            z4 = !z4;
                        }
                        wz(canvas, z4, true);
                        return;
                    }
                    return;
                }
                if (ta2 != 1) {
                    z5 = false;
                }
                if (this.f4958v == 2) {
                    z5 = !z5;
                }
                wz(canvas, z5, false);
                return;
            }
            if (ta2 != 1) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (this.f4958v == 2) {
                z4 = true;
            }
            tl(canvas, z3, z4);
            return;
        }
        if (ta2 == 1) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (this.f4958v == 2) {
            z4 = true;
        }
        tl(canvas, z2, z4);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z2, int i, int i5, int i6, int i8) {
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z7;
        int ta2 = i4.ta(this);
        int i10 = this.y;
        boolean z8 = false;
        if (i10 != 0) {
            if (i10 != 1) {
                if (i10 != 2) {
                    if (i10 == 3) {
                        if (ta2 == 1) {
                            z8 = true;
                        }
                        if (this.f4958v == 2) {
                            z7 = !z8;
                        } else {
                            z7 = z8;
                        }
                        i4(z7, true, i, i5, i6, i8);
                        return;
                    }
                    throw new IllegalStateException("Invalid flex direction is set: " + this.y);
                }
                if (ta2 == 1) {
                    z8 = true;
                }
                if (this.f4958v == 2) {
                    z5 = !z8;
                } else {
                    z5 = z8;
                }
                i4(z5, false, i, i5, i6, i8);
                return;
            }
            if (ta2 != 1) {
                z4 = true;
            } else {
                z4 = false;
            }
            x4(z4, i, i5, i6, i8);
            return;
        }
        if (ta2 == 1) {
            z3 = true;
        } else {
            z3 = false;
        }
        x4(z3, i, i5, i6, i8);
    }

    @Override // android.view.View
    public void onMeasure(int i, int i5) {
        if (this.f4945c == null) {
            this.f4945c = new SparseIntArray(getChildCount());
        }
        if (this.f4948d0.vl(this.f4945c)) {
            this.f4953n = this.f4948d0.tl(this.f4945c);
        }
        int i6 = this.y;
        if (i6 != 0 && i6 != 1) {
            if (i6 != 2 && i6 != 3) {
                throw new IllegalStateException("Invalid value for the flex direction is set: " + this.y);
            }
            n(i, i5);
            return;
        }
        f3(i, i5);
    }

    @Override // android.view.ViewGroup
    /* renamed from: p */
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public final boolean r(int i) {
        if (i < 0 || i >= this.f4952fh.size()) {
            return false;
        }
        for (int i5 = i + 1; i5 < this.f4952fh.size(); i5++) {
            if (this.f4952fh.get(i5).zn() > 0) {
                return false;
            }
        }
        if (f()) {
            if ((this.f4946co & 4) == 0) {
                return false;
            }
            return true;
        } else if ((this.f4960z & 4) == 0) {
            return false;
        } else {
            return true;
        }
    }

    @Override // zf.y
    public View s(int i) {
        return mt(i);
    }

    public void setAlignContent(int i) {
        if (this.f4949f != i) {
            this.f4949f = i;
            requestLayout();
        }
    }

    public void setAlignItems(int i) {
        if (this.f4956s != i) {
            this.f4956s = i;
            requestLayout();
        }
    }

    public void setDividerDrawable(Drawable drawable) {
        setDividerDrawableHorizontal(drawable);
        setDividerDrawableVertical(drawable);
    }

    public void setDividerDrawableHorizontal(@Nullable Drawable drawable) {
        if (drawable == this.f4959w) {
            return;
        }
        this.f4959w = drawable;
        if (drawable != null) {
            this.f4955r = drawable.getIntrinsicHeight();
        } else {
            this.f4955r = 0;
        }
        d0();
        requestLayout();
    }

    public void setDividerDrawableVertical(@Nullable Drawable drawable) {
        if (drawable == this.f4954p) {
            return;
        }
        this.f4954p = drawable;
        if (drawable != null) {
            this.f4950f3 = drawable.getIntrinsicWidth();
        } else {
            this.f4950f3 = 0;
        }
        d0();
        requestLayout();
    }

    public void setFlexDirection(int i) {
        if (this.y != i) {
            this.y = i;
            requestLayout();
        }
    }

    @Override // zf.y
    public void setFlexLines(List<y> list) {
        this.f4952fh = list;
    }

    public void setFlexWrap(int i) {
        if (this.f4958v != i) {
            this.f4958v = i;
            requestLayout();
        }
    }

    public void setJustifyContent(int i) {
        if (this.f4951fb != i) {
            this.f4951fb = i;
            requestLayout();
        }
    }

    public void setMaxLine(int i) {
        if (this.f4957t != i) {
            this.f4957t = i;
            requestLayout();
        }
    }

    public void setShowDivider(int i) {
        setShowDividerVertical(i);
        setShowDividerHorizontal(i);
    }

    public void setShowDividerHorizontal(int i) {
        if (i != this.f4946co) {
            this.f4946co = i;
            requestLayout();
        }
    }

    public void setShowDividerVertical(int i) {
        if (i != this.f4960z) {
            this.f4960z = i;
            requestLayout();
        }
    }

    public final boolean t(int i, int i5) {
        for (int i6 = 1; i6 <= i5; i6++) {
            View mt2 = mt(i - i6);
            if (mt2 != null && mt2.getVisibility() != 8) {
                return false;
            }
        }
        return true;
    }

    public final void tl(Canvas canvas, boolean z2, boolean z3) {
        int i;
        int i5;
        int right;
        int left;
        int paddingLeft = getPaddingLeft();
        int max = Math.max(0, (getWidth() - getPaddingRight()) - paddingLeft);
        int size = this.f4952fh.size();
        for (int i6 = 0; i6 < size; i6++) {
            y yVar = this.f4952fh.get(i6);
            for (int i8 = 0; i8 < yVar.f5067s; i8++) {
                int i10 = yVar.f5073xc + i8;
                View mt2 = mt(i10);
                if (mt2 != null && mt2.getVisibility() != 8) {
                    LayoutParams layoutParams = (LayoutParams) mt2.getLayoutParams();
                    if (co(i10, i8)) {
                        if (z2) {
                            left = mt2.getRight() + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
                        } else {
                            left = (mt2.getLeft() - ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin) - this.f4950f3;
                        }
                        w(canvas, left, yVar.f5065n3, yVar.f5061fb);
                    }
                    if (i8 == yVar.f5067s - 1 && (this.f4960z & 4) > 0) {
                        if (z2) {
                            right = (mt2.getLeft() - ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin) - this.f4950f3;
                        } else {
                            right = mt2.getRight() + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
                        }
                        w(canvas, right, yVar.f5065n3, yVar.f5061fb);
                    }
                }
            }
            if (z(i6)) {
                if (z3) {
                    i5 = yVar.f5062gv;
                } else {
                    i5 = yVar.f5065n3 - this.f4955r;
                }
                xc(canvas, paddingLeft, i5, max);
            }
            if (r(i6) && (this.f4946co & 4) > 0) {
                if (z3) {
                    i = yVar.f5065n3 - this.f4955r;
                } else {
                    i = yVar.f5062gv;
                }
                xc(canvas, paddingLeft, i, max);
            }
        }
    }

    @Override // zf.y
    public int v(int i, int i5, int i6) {
        return ViewGroup.getChildMeasureSpec(i, i5, i6);
    }

    public final void w(Canvas canvas, int i, int i5, int i6) {
        Drawable drawable = this.f4954p;
        if (drawable == null) {
            return;
        }
        drawable.setBounds(i, i5, this.f4950f3 + i, i6 + i5);
        this.f4954p.draw(canvas);
    }

    public final void wz(Canvas canvas, boolean z2, boolean z3) {
        int i;
        int i5;
        int bottom;
        int top;
        int paddingTop = getPaddingTop();
        int max = Math.max(0, (getHeight() - getPaddingBottom()) - paddingTop);
        int size = this.f4952fh.size();
        for (int i6 = 0; i6 < size; i6++) {
            y yVar = this.f4952fh.get(i6);
            for (int i8 = 0; i8 < yVar.f5067s; i8++) {
                int i10 = yVar.f5073xc + i8;
                View mt2 = mt(i10);
                if (mt2 != null && mt2.getVisibility() != 8) {
                    LayoutParams layoutParams = (LayoutParams) mt2.getLayoutParams();
                    if (co(i10, i8)) {
                        if (z3) {
                            top = mt2.getBottom() + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
                        } else {
                            top = (mt2.getTop() - ((ViewGroup.MarginLayoutParams) layoutParams).topMargin) - this.f4955r;
                        }
                        xc(canvas, yVar.y, top, yVar.f5061fb);
                    }
                    if (i8 == yVar.f5067s - 1 && (this.f4946co & 4) > 0) {
                        if (z3) {
                            bottom = (mt2.getTop() - ((ViewGroup.MarginLayoutParams) layoutParams).topMargin) - this.f4955r;
                        } else {
                            bottom = mt2.getBottom() + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
                        }
                        xc(canvas, yVar.y, bottom, yVar.f5061fb);
                    }
                }
            }
            if (z(i6)) {
                if (z2) {
                    i5 = yVar.f5074zn;
                } else {
                    i5 = yVar.y - this.f4950f3;
                }
                w(canvas, i5, paddingTop, max);
            }
            if (r(i6) && (this.f4960z & 4) > 0) {
                if (z2) {
                    i = yVar.y - this.f4950f3;
                } else {
                    i = yVar.f5074zn;
                }
                w(canvas, i, paddingTop, max);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x01f3  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0200  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void x4(boolean r29, int r30, int r31, int r32, int r33) {
        /*
            Method dump skipped, instructions count: 547
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.flexbox.FlexboxLayout.x4(boolean, int, int, int, int):void");
    }

    public final void xc(Canvas canvas, int i, int i5, int i6) {
        Drawable drawable = this.f4959w;
        if (drawable == null) {
            return;
        }
        drawable.setBounds(i, i5, i6 + i, this.f4955r + i5);
        this.f4959w.draw(canvas);
    }

    public final boolean y(int i) {
        for (int i5 = 0; i5 < i; i5++) {
            if (this.f4952fh.get(i5).zn() > 0) {
                return false;
            }
        }
        return true;
    }

    public final boolean z(int i) {
        if (i < 0 || i >= this.f4952fh.size()) {
            return false;
        }
        if (y(i)) {
            if (f()) {
                if ((this.f4946co & 1) == 0) {
                    return false;
                }
                return true;
            } else if ((this.f4960z & 1) == 0) {
                return false;
            } else {
                return true;
            }
        } else if (f()) {
            if ((this.f4946co & 2) == 0) {
                return false;
            }
            return true;
        } else if ((this.f4960z & 2) == 0) {
            return false;
        } else {
            return true;
        }
    }

    @Override // zf.y
    public int zn(int i, int i5, int i6) {
        return ViewGroup.getChildMeasureSpec(i, i5, i6);
    }

    public FlexboxLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f4957t = -1;
        this.f4948d0 = new n3(this);
        this.f4952fh = new ArrayList();
        this.f4947d = new n3.C0056n3();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.f5038n3, i, 0);
        this.y = obtainStyledAttributes.getInt(R$styleable.f5042s, 0);
        this.f4958v = obtainStyledAttributes.getInt(R$styleable.f5025c5, 0);
        this.f4951fb = obtainStyledAttributes.getInt(R$styleable.f5034i9, 0);
        this.f4956s = obtainStyledAttributes.getInt(R$styleable.f5032gv, 0);
        this.f4949f = obtainStyledAttributes.getInt(R$styleable.f5051zn, 0);
        this.f4957t = obtainStyledAttributes.getInt(R$styleable.f5028f, -1);
        Drawable drawable = obtainStyledAttributes.getDrawable(R$styleable.f5045v);
        if (drawable != null) {
            setDividerDrawableHorizontal(drawable);
            setDividerDrawableVertical(drawable);
        }
        Drawable drawable2 = obtainStyledAttributes.getDrawable(R$styleable.f5023a);
        if (drawable2 != null) {
            setDividerDrawableHorizontal(drawable2);
        }
        Drawable drawable3 = obtainStyledAttributes.getDrawable(R$styleable.f5030fb);
        if (drawable3 != null) {
            setDividerDrawableVertical(drawable3);
        }
        int i5 = obtainStyledAttributes.getInt(R$styleable.f5043t, 0);
        if (i5 != 0) {
            this.f4960z = i5;
            this.f4946co = i5;
        }
        int i6 = obtainStyledAttributes.getInt(R$styleable.f5047wz, 0);
        if (i6 != 0) {
            this.f4960z = i6;
        }
        int i8 = obtainStyledAttributes.getInt(R$styleable.f5044tl, 0);
        if (i8 != 0) {
            this.f4946co = i8;
        }
        obtainStyledAttributes.recycle();
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof LayoutParams) {
            return new LayoutParams((LayoutParams) layoutParams);
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new LayoutParams(layoutParams);
    }

    /* loaded from: classes.dex */
    public static class LayoutParams extends ViewGroup.MarginLayoutParams implements FlexItem {
        public static final Parcelable.Creator<LayoutParams> CREATOR = new y();

        /* renamed from: co  reason: collision with root package name */
        public int f4961co;

        /* renamed from: f  reason: collision with root package name */
        public float f4962f;

        /* renamed from: fb  reason: collision with root package name */
        public float f4963fb;

        /* renamed from: p  reason: collision with root package name */
        public int f4964p;

        /* renamed from: s  reason: collision with root package name */
        public int f4965s;

        /* renamed from: t  reason: collision with root package name */
        public int f4966t;

        /* renamed from: v  reason: collision with root package name */
        public float f4967v;

        /* renamed from: w  reason: collision with root package name */
        public int f4968w;
        public int y;

        /* renamed from: z  reason: collision with root package name */
        public boolean f4969z;

        /* loaded from: classes.dex */
        public class y implements Parcelable.Creator<LayoutParams> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: n3 */
            public LayoutParams[] newArray(int i) {
                return new LayoutParams[i];
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: y */
            public LayoutParams createFromParcel(Parcel parcel) {
                return new LayoutParams(parcel);
            }
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.y = 1;
            this.f4963fb = 1.0f;
            this.f4965s = -1;
            this.f4962f = -1.0f;
            this.f4966t = -1;
            this.f4968w = -1;
            this.f4964p = 16777215;
            this.f4961co = 16777215;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.f5049xc);
            this.y = obtainStyledAttributes.getInt(R$styleable.f5029f3, 1);
            this.f4967v = obtainStyledAttributes.getFloat(R$styleable.f5036mt, 0.0f);
            this.f4963fb = obtainStyledAttributes.getFloat(R$styleable.f5026co, 1.0f);
            this.f4965s = obtainStyledAttributes.getInt(R$styleable.f5046w, -1);
            this.f4962f = obtainStyledAttributes.getFraction(R$styleable.f5039p, 1, 1, -1.0f);
            this.f4966t = obtainStyledAttributes.getDimensionPixelSize(R$styleable.f5033i4, -1);
            this.f4968w = obtainStyledAttributes.getDimensionPixelSize(R$styleable.f5048x4, -1);
            this.f4964p = obtainStyledAttributes.getDimensionPixelSize(R$styleable.f5040r, 16777215);
            this.f4961co = obtainStyledAttributes.getDimensionPixelSize(R$styleable.f5050z, 16777215);
            this.f4969z = obtainStyledAttributes.getBoolean(R$styleable.f5037n, false);
            obtainStyledAttributes.recycle();
        }

        @Override // com.google.android.flexbox.FlexItem
        public int ap() {
            return ((ViewGroup.MarginLayoutParams) this).bottomMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void d(int i) {
            this.f4968w = i;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getHeight() {
            return ((ViewGroup.MarginLayoutParams) this).height;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getOrder() {
            return this.y;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getWidth() {
            return ((ViewGroup.MarginLayoutParams) this).width;
        }

        @Override // com.google.android.flexbox.FlexItem
        public boolean j() {
            return this.f4969z;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int jz() {
            return this.f4964p;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int l() {
            return this.f4968w;
        }

        @Override // com.google.android.flexbox.FlexItem
        public float mt() {
            return this.f4963fb;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int p() {
            return this.f4965s;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int qk() {
            return ((ViewGroup.MarginLayoutParams) this).rightMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void setMinWidth(int i) {
            this.f4966t = i;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int ta() {
            return ((ViewGroup.MarginLayoutParams) this).topMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public float ud() {
            return this.f4967v;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int vp() {
            return this.f4961co;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.y);
            parcel.writeFloat(this.f4967v);
            parcel.writeFloat(this.f4963fb);
            parcel.writeInt(this.f4965s);
            parcel.writeFloat(this.f4962f);
            parcel.writeInt(this.f4966t);
            parcel.writeInt(this.f4968w);
            parcel.writeInt(this.f4964p);
            parcel.writeInt(this.f4961co);
            parcel.writeByte(this.f4969z ? (byte) 1 : (byte) 0);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).bottomMargin);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).leftMargin);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).rightMargin);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).topMargin);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).height);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).width);
        }

        @Override // com.google.android.flexbox.FlexItem
        public int x4() {
            return this.f4966t;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int yc() {
            return ((ViewGroup.MarginLayoutParams) this).leftMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public float yt() {
            return this.f4962f;
        }

        public LayoutParams(LayoutParams layoutParams) {
            super((ViewGroup.MarginLayoutParams) layoutParams);
            this.y = 1;
            this.f4963fb = 1.0f;
            this.f4965s = -1;
            this.f4962f = -1.0f;
            this.f4966t = -1;
            this.f4968w = -1;
            this.f4964p = 16777215;
            this.f4961co = 16777215;
            this.y = layoutParams.y;
            this.f4967v = layoutParams.f4967v;
            this.f4963fb = layoutParams.f4963fb;
            this.f4965s = layoutParams.f4965s;
            this.f4962f = layoutParams.f4962f;
            this.f4966t = layoutParams.f4966t;
            this.f4968w = layoutParams.f4968w;
            this.f4964p = layoutParams.f4964p;
            this.f4961co = layoutParams.f4961co;
            this.f4969z = layoutParams.f4969z;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.y = 1;
            this.f4963fb = 1.0f;
            this.f4965s = -1;
            this.f4962f = -1.0f;
            this.f4966t = -1;
            this.f4968w = -1;
            this.f4964p = 16777215;
            this.f4961co = 16777215;
        }

        public LayoutParams(int i, int i5) {
            super(new ViewGroup.LayoutParams(i, i5));
            this.y = 1;
            this.f4967v = 0.0f;
            this.f4963fb = 1.0f;
            this.f4965s = -1;
            this.f4962f = -1.0f;
            this.f4966t = -1;
            this.f4968w = -1;
            this.f4964p = 16777215;
            this.f4961co = 16777215;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.y = 1;
            this.f4963fb = 1.0f;
            this.f4965s = -1;
            this.f4962f = -1.0f;
            this.f4966t = -1;
            this.f4968w = -1;
            this.f4964p = 16777215;
            this.f4961co = 16777215;
        }

        public LayoutParams(Parcel parcel) {
            super(0, 0);
            this.y = 1;
            this.f4963fb = 1.0f;
            this.f4965s = -1;
            this.f4962f = -1.0f;
            this.f4966t = -1;
            this.f4968w = -1;
            this.f4964p = 16777215;
            this.f4961co = 16777215;
            this.y = parcel.readInt();
            this.f4967v = parcel.readFloat();
            this.f4963fb = parcel.readFloat();
            this.f4965s = parcel.readInt();
            this.f4962f = parcel.readFloat();
            this.f4966t = parcel.readInt();
            this.f4968w = parcel.readInt();
            this.f4964p = parcel.readInt();
            this.f4961co = parcel.readInt();
            this.f4969z = parcel.readByte() != 0;
            ((ViewGroup.MarginLayoutParams) this).bottomMargin = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).leftMargin = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).rightMargin = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).topMargin = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).height = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).width = parcel.readInt();
        }
    }
}
