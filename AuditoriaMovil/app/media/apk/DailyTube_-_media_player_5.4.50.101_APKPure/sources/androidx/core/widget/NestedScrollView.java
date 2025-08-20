package androidx.core.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.AnimationUtils;
import android.widget.EdgeEffect;
import android.widget.FrameLayout;
import android.widget.OverScroller;
import android.widget.ScrollView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.R$attr;
import hw.f;
import hw.i4;
import hw.i9;
import hw.t;
import hw.wz;
import hw.xc;
import j.s;
import j5.v;
import j5.zn;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class NestedScrollView extends FrameLayout implements wz, f {

    /* renamed from: b  reason: collision with root package name */
    public final int[] f2346b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f2347c;

    /* renamed from: co  reason: collision with root package name */
    public boolean f2348co;

    /* renamed from: d  reason: collision with root package name */
    public int f2349d;

    /* renamed from: d0  reason: collision with root package name */
    public int f2350d0;

    /* renamed from: ej  reason: collision with root package name */
    public int f2351ej;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public EdgeEffect f2352f;

    /* renamed from: f3  reason: collision with root package name */
    public VelocityTracker f2353f3;

    /* renamed from: fb  reason: collision with root package name */
    public final Rect f2354fb;

    /* renamed from: fh  reason: collision with root package name */
    public int f2355fh;

    /* renamed from: j  reason: collision with root package name */
    public final xc f2356j;

    /* renamed from: j5  reason: collision with root package name */
    public int f2357j5;

    /* renamed from: n  reason: collision with root package name */
    public boolean f2358n;

    /* renamed from: o  reason: collision with root package name */
    public SavedState f2359o;

    /* renamed from: oz  reason: collision with root package name */
    public final t f2360oz;

    /* renamed from: p  reason: collision with root package name */
    public boolean f2361p;

    /* renamed from: q9  reason: collision with root package name */
    public zn f2362q9;

    /* renamed from: qn  reason: collision with root package name */
    public int f2363qn;

    /* renamed from: r  reason: collision with root package name */
    public boolean f2364r;

    /* renamed from: s  reason: collision with root package name */
    public OverScroller f2365s;
    @NonNull

    /* renamed from: t  reason: collision with root package name */
    public EdgeEffect f2366t;

    /* renamed from: ut  reason: collision with root package name */
    public float f2367ut;

    /* renamed from: v  reason: collision with root package name */
    public long f2368v;

    /* renamed from: w  reason: collision with root package name */
    public int f2369w;

    /* renamed from: x  reason: collision with root package name */
    public final int[] f2370x;
    public final float y;

    /* renamed from: z  reason: collision with root package name */
    public View f2371z;

    /* renamed from: k  reason: collision with root package name */
    public static final float f2345k = (float) (Math.log(0.78d) / Math.log(0.9d));

    /* renamed from: f7  reason: collision with root package name */
    public static final y f2344f7 = new y();

    /* renamed from: en  reason: collision with root package name */
    public static final int[] f2343en = {16843130};

    /* loaded from: classes.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new y();
        public int y;

        /* loaded from: classes.dex */
        public class y implements Parcelable.Creator<SavedState> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: n3 */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: y */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        @NonNull
        public String toString() {
            return "HorizontalScrollView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " scrollPosition=" + this.y + "}";
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.y);
        }

        public SavedState(Parcel parcel) {
            super(parcel);
            this.y = parcel.readInt();
        }
    }

    /* loaded from: classes.dex */
    public static class n3 {
        public static boolean y(ViewGroup viewGroup) {
            return viewGroup.getClipToPadding();
        }
    }

    /* loaded from: classes.dex */
    public static class y extends hw.y {
        @Override // hw.y
        public void a(View view, AccessibilityEvent accessibilityEvent) {
            boolean z2;
            super.a(view, accessibilityEvent);
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            accessibilityEvent.setClassName(ScrollView.class.getName());
            if (nestedScrollView.getScrollRange() > 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            accessibilityEvent.setScrollable(z2);
            accessibilityEvent.setScrollX(nestedScrollView.getScrollX());
            accessibilityEvent.setScrollY(nestedScrollView.getScrollY());
            v.y(accessibilityEvent, nestedScrollView.getScrollX());
            v.n3(accessibilityEvent, nestedScrollView.getScrollRange());
        }

        @Override // hw.y
        public void fb(View view, j5.zn znVar) {
            int scrollRange;
            super.fb(view, znVar);
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            znVar.e(ScrollView.class.getName());
            if (nestedScrollView.isEnabled() && (scrollRange = nestedScrollView.getScrollRange()) > 0) {
                znVar.wf(true);
                if (nestedScrollView.getScrollY() > 0) {
                    znVar.n3(zn.y.f9397mt);
                    znVar.n3(zn.y.f9404rz);
                }
                if (nestedScrollView.getScrollY() < scrollRange) {
                    znVar.n3(zn.y.f9401p);
                    znVar.n3(zn.y.f9407ta);
                }
            }
        }

        @Override // hw.y
        public boolean i9(View view, int i, Bundle bundle) {
            if (super.i9(view, i, bundle)) {
                return true;
            }
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            if (!nestedScrollView.isEnabled()) {
                return false;
            }
            int height = nestedScrollView.getHeight();
            Rect rect = new Rect();
            if (nestedScrollView.getMatrix().isIdentity() && nestedScrollView.getGlobalVisibleRect(rect)) {
                height = rect.height();
            }
            if (i != 4096) {
                if (i != 8192 && i != 16908344) {
                    if (i != 16908346) {
                        return false;
                    }
                } else {
                    int max = Math.max(nestedScrollView.getScrollY() - ((height - nestedScrollView.getPaddingBottom()) - nestedScrollView.getPaddingTop()), 0);
                    if (max == nestedScrollView.getScrollY()) {
                        return false;
                    }
                    nestedScrollView.ut(0, max, true);
                    return true;
                }
            }
            int min = Math.min(nestedScrollView.getScrollY() + ((height - nestedScrollView.getPaddingBottom()) - nestedScrollView.getPaddingTop()), nestedScrollView.getScrollRange());
            if (min == nestedScrollView.getScrollY()) {
                return false;
            }
            nestedScrollView.ut(0, min, true);
            return true;
        }
    }

    /* loaded from: classes.dex */
    public interface zn {
        void y(@NonNull NestedScrollView nestedScrollView, int i, int i5, int i6, int i8);
    }

    public NestedScrollView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.f2090zn);
    }

    private float getVerticalScrollFactorCompat() {
        if (this.f2367ut == 0.0f) {
            TypedValue typedValue = new TypedValue();
            Context context = getContext();
            if (context.getTheme().resolveAttribute(16842829, typedValue, true)) {
                this.f2367ut = typedValue.getDimension(context.getResources().getDisplayMetrics());
            } else {
                throw new IllegalStateException("Expected theme to define listPreferredItemHeight.");
            }
        }
        return this.f2367ut;
    }

    public static boolean ta(View view, View view2) {
        if (view == view2) {
            return true;
        }
        ViewParent parent = view.getParent();
        if ((parent instanceof ViewGroup) && ta((View) parent, view2)) {
            return true;
        }
        return false;
    }

    public static int v(int i, int i5, int i6) {
        if (i5 >= i6 || i < 0) {
            return 0;
        }
        return i5 + i > i6 ? i6 - i5 : i;
    }

    public int a(Rect rect) {
        int i;
        int i5;
        int i6;
        if (getChildCount() == 0) {
            return 0;
        }
        int height = getHeight();
        int scrollY = getScrollY();
        int i8 = scrollY + height;
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        if (rect.top > 0) {
            scrollY += verticalFadingEdgeLength;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        if (rect.bottom < childAt.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin) {
            i = i8 - verticalFadingEdgeLength;
        } else {
            i = i8;
        }
        int i10 = rect.bottom;
        if (i10 > i && rect.top > scrollY) {
            if (rect.height() > height) {
                i6 = rect.top - scrollY;
            } else {
                i6 = rect.bottom - i;
            }
            return Math.min(i6, (childAt.getBottom() + layoutParams.bottomMargin) - i8);
        } else if (rect.top >= scrollY || i10 >= i) {
            return 0;
        } else {
            if (rect.height() > height) {
                i5 = 0 - (i - rect.bottom);
            } else {
                i5 = 0 - (scrollY - rect.top);
            }
            return Math.max(i5, -getScrollY());
        }
    }

    public boolean a8(int i) {
        boolean z2;
        if (i == 130) {
            z2 = true;
        } else {
            z2 = false;
        }
        int height = getHeight();
        if (z2) {
            this.f2354fb.top = getScrollY() + height;
            int childCount = getChildCount();
            if (childCount > 0) {
                View childAt = getChildAt(childCount - 1);
                int bottom = childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin + getPaddingBottom();
                Rect rect = this.f2354fb;
                if (rect.top + height > bottom) {
                    rect.top = bottom - height;
                }
            }
        } else {
            this.f2354fb.top = getScrollY() - height;
            Rect rect2 = this.f2354fb;
            if (rect2.top < 0) {
                rect2.top = 0;
            }
        }
        Rect rect3 = this.f2354fb;
        int i5 = rect3.top;
        int i6 = height + i5;
        rect3.bottom = i6;
        return yt(i, i5, i6);
    }

    @Override // android.view.ViewGroup
    public void addView(@NonNull View view) {
        if (getChildCount() <= 0) {
            super.addView(view);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0061  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int b(int r4, float r5) {
        /*
            r3 = this;
            int r0 = r3.getWidth()
            float r0 = (float) r0
            float r5 = r5 / r0
            float r4 = (float) r4
            int r0 = r3.getHeight()
            float r0 = (float) r0
            float r4 = r4 / r0
            android.widget.EdgeEffect r0 = r3.f2352f
            float r0 = j.s.n3(r0)
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 == 0) goto L31
            android.widget.EdgeEffect r0 = r3.f2352f
            float r4 = -r4
            float r4 = j.s.gv(r0, r4, r5)
            float r4 = -r4
            android.widget.EdgeEffect r5 = r3.f2352f
            float r5 = j.s.n3(r5)
            int r5 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
            if (r5 != 0) goto L2f
            android.widget.EdgeEffect r5 = r3.f2352f
            r5.onRelease()
        L2f:
            r1 = r4
            goto L54
        L31:
            android.widget.EdgeEffect r0 = r3.f2366t
            float r0 = j.s.n3(r0)
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 == 0) goto L54
            android.widget.EdgeEffect r0 = r3.f2366t
            r2 = 1065353216(0x3f800000, float:1.0)
            float r2 = r2 - r5
            float r4 = j.s.gv(r0, r4, r2)
            android.widget.EdgeEffect r5 = r3.f2366t
            float r5 = j.s.n3(r5)
            int r5 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
            if (r5 != 0) goto L2f
            android.widget.EdgeEffect r5 = r3.f2366t
            r5.onRelease()
            goto L2f
        L54:
            int r4 = r3.getHeight()
            float r4 = (float) r4
            float r1 = r1 * r4
            int r4 = java.lang.Math.round(r1)
            if (r4 == 0) goto L64
            r3.invalidate()
        L64:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.NestedScrollView.b(int, float):int");
    }

    public final void c() {
        VelocityTracker velocityTracker = this.f2353f3;
        if (velocityTracker == null) {
            this.f2353f3 = VelocityTracker.obtain();
        } else {
            velocityTracker.clear();
        }
    }

    @Override // hw.tl
    public void c5(@NonNull View view, @NonNull View view2, int i, int i5) {
        this.f2356j.zn(view, view2, i, i5);
        q9(2, i5);
    }

    public boolean co(@NonNull KeyEvent keyEvent) {
        this.f2354fb.setEmpty();
        int i = 130;
        if (!gv()) {
            if (!isFocused() || keyEvent.getKeyCode() == 4) {
                return false;
            }
            View findFocus = findFocus();
            if (findFocus == this) {
                findFocus = null;
            }
            View findNextFocus = FocusFinder.getInstance().findNextFocus(this, findFocus, 130);
            if (findNextFocus == null || findNextFocus == this || !findNextFocus.requestFocus(130)) {
                return false;
            }
            return true;
        } else if (keyEvent.getAction() != 0) {
            return false;
        } else {
            int keyCode = keyEvent.getKeyCode();
            if (keyCode != 19) {
                if (keyCode != 20) {
                    if (keyCode != 62) {
                        if (keyCode != 92) {
                            if (keyCode != 93) {
                                if (keyCode != 122) {
                                    if (keyCode != 123) {
                                        return false;
                                    }
                                    a8(130);
                                    return false;
                                }
                                a8(33);
                                return false;
                            }
                            return x4(130);
                        }
                        return x4(33);
                    }
                    if (keyEvent.isShiftPressed()) {
                        i = 33;
                    }
                    a8(i);
                    return false;
                } else if (keyEvent.isAltPressed()) {
                    return x4(130);
                } else {
                    return n3(130);
                }
            } else if (keyEvent.isAltPressed()) {
                return x4(33);
            } else {
                return n3(33);
            }
        }
    }

    @Override // android.view.View
    public int computeHorizontalScrollExtent() {
        return super.computeHorizontalScrollExtent();
    }

    @Override // android.view.View
    public int computeHorizontalScrollOffset() {
        return super.computeHorizontalScrollOffset();
    }

    @Override // android.view.View
    public int computeHorizontalScrollRange() {
        return super.computeHorizontalScrollRange();
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.f2365s.isFinished()) {
            return;
        }
        this.f2365s.computeScrollOffset();
        int currY = this.f2365s.getCurrY();
        int fb2 = fb(currY - this.f2363qn);
        this.f2363qn = currY;
        int[] iArr = this.f2346b;
        iArr[1] = 0;
        s(0, fb2, iArr, null, 1);
        int i = fb2 - this.f2346b[1];
        int scrollRange = getScrollRange();
        if (i != 0) {
            int scrollY = getScrollY();
            ud(0, i, getScrollX(), scrollY, 0, scrollRange, 0, 0, false);
            int scrollY2 = getScrollY() - scrollY;
            int i5 = i - scrollY2;
            int[] iArr2 = this.f2346b;
            iArr2[1] = 0;
            t(0, scrollY2, 0, i5, this.f2370x, 1, iArr2);
            i = i5 - this.f2346b[1];
        }
        if (i != 0) {
            int overScrollMode = getOverScrollMode();
            if (overScrollMode == 0 || (overScrollMode == 1 && scrollRange > 0)) {
                if (i < 0) {
                    if (this.f2352f.isFinished()) {
                        this.f2352f.onAbsorb((int) this.f2365s.getCurrVelocity());
                    }
                } else if (this.f2366t.isFinished()) {
                    this.f2366t.onAbsorb((int) this.f2365s.getCurrVelocity());
                }
            }
            y();
        }
        if (!this.f2365s.isFinished()) {
            i4.lc(this);
        } else {
            f7(1);
        }
    }

    @Override // android.view.View
    public int computeVerticalScrollExtent() {
        return super.computeVerticalScrollExtent();
    }

    @Override // android.view.View
    public int computeVerticalScrollOffset() {
        return Math.max(0, super.computeVerticalScrollOffset());
    }

    @Override // android.view.View
    public int computeVerticalScrollRange() {
        int childCount = getChildCount();
        int height = (getHeight() - getPaddingBottom()) - getPaddingTop();
        if (childCount == 0) {
            return height;
        }
        View childAt = getChildAt(0);
        int bottom = childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin;
        int scrollY = getScrollY();
        int max = Math.max(0, bottom - height);
        if (scrollY < 0) {
            return bottom - scrollY;
        }
        if (scrollY > max) {
            return bottom + (scrollY - max);
        }
        return bottom;
    }

    public final boolean d(View view, int i, int i5) {
        view.getDrawingRect(this.f2354fb);
        offsetDescendantRectToMyCoords(view, this.f2354fb);
        if (this.f2354fb.bottom + i >= getScrollY() && this.f2354fb.top - i <= getScrollY() + i5) {
            return true;
        }
        return false;
    }

    public final void d0() {
        this.f2365s = new OverScroller(getContext());
        setFocusable(true);
        setDescendantFocusability(262144);
        setWillNotDraw(false);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        this.f2350d0 = viewConfiguration.getScaledTouchSlop();
        this.f2355fh = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f2349d = viewConfiguration.getScaledMaximumFlingVelocity();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (!super.dispatchKeyEvent(keyEvent) && !co(keyEvent)) {
            return false;
        }
        return true;
    }

    @Override // android.view.View
    public boolean dispatchNestedFling(float f4, float f6, boolean z2) {
        return this.f2360oz.y(f4, f6, z2);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreFling(float f4, float f6) {
        return this.f2360oz.n3(f4, f6);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreScroll(int i, int i5, @Nullable int[] iArr, @Nullable int[] iArr2) {
        return s(i, i5, iArr, iArr2, 0);
    }

    @Override // android.view.View
    public boolean dispatchNestedScroll(int i, int i5, int i6, int i8, @Nullable int[] iArr) {
        return this.f2360oz.a(i, i5, i6, i8, iArr);
    }

    @Override // android.view.View
    public void draw(@NonNull Canvas canvas) {
        int i;
        super.draw(canvas);
        int scrollY = getScrollY();
        int i5 = 0;
        if (!this.f2352f.isFinished()) {
            int save = canvas.save();
            int width = getWidth();
            int height = getHeight();
            int min = Math.min(0, scrollY);
            if (n3.y(this)) {
                width -= getPaddingLeft() + getPaddingRight();
                i = getPaddingLeft();
            } else {
                i = 0;
            }
            if (n3.y(this)) {
                height -= getPaddingTop() + getPaddingBottom();
                min += getPaddingTop();
            }
            canvas.translate(i, min);
            this.f2352f.setSize(width, height);
            if (this.f2352f.draw(canvas)) {
                i4.lc(this);
            }
            canvas.restoreToCount(save);
        }
        if (!this.f2366t.isFinished()) {
            int save2 = canvas.save();
            int width2 = getWidth();
            int height2 = getHeight();
            int max = Math.max(getScrollRange(), scrollY) + height2;
            if (n3.y(this)) {
                width2 -= getPaddingLeft() + getPaddingRight();
                i5 = getPaddingLeft();
            }
            if (n3.y(this)) {
                height2 -= getPaddingTop() + getPaddingBottom();
                max -= getPaddingBottom();
            }
            canvas.translate(i5 - width2, max);
            canvas.rotate(180.0f, width2, 0.0f);
            this.f2366t.setSize(width2, height2);
            if (this.f2366t.draw(canvas)) {
                i4.lc(this);
            }
            canvas.restoreToCount(save2);
        }
    }

    public final void ej(MotionEvent motionEvent) {
        int i;
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.f2351ej) {
            if (actionIndex == 0) {
                i = 1;
            } else {
                i = 0;
            }
            this.f2369w = (int) motionEvent.getY(i);
            this.f2351ej = motionEvent.getPointerId(i);
            VelocityTracker velocityTracker = this.f2353f3;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }

    @Override // hw.tl
    public void f(@NonNull View view, int i, int i5, @NonNull int[] iArr, int i6) {
        s(i, i5, iArr, null, i6);
    }

    public boolean f3(int i) {
        return this.f2360oz.t(i);
    }

    public void f7(int i) {
        this.f2360oz.co(i);
    }

    public int fb(int i) {
        int height = getHeight();
        if (i > 0 && s.n3(this.f2352f) != 0.0f) {
            int round = Math.round(((-height) / 4.0f) * s.gv(this.f2352f, ((-i) * 4.0f) / height, 0.5f));
            if (round != i) {
                this.f2352f.finish();
            }
            return i - round;
        } else if (i < 0 && s.n3(this.f2366t) != 0.0f) {
            float f4 = height;
            int round2 = Math.round((f4 / 4.0f) * s.gv(this.f2366t, (i * 4.0f) / f4, 0.5f));
            if (round2 != i) {
                this.f2366t.finish();
            }
            return i - round2;
        } else {
            return i;
        }
    }

    public final void fh() {
        if (this.f2353f3 == null) {
            this.f2353f3 = VelocityTracker.obtain();
        }
    }

    @Override // android.view.View
    public float getBottomFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
        }
        View childAt = getChildAt(0);
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int bottom = ((childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin) - getScrollY()) - (getHeight() - getPaddingBottom());
        if (bottom < verticalFadingEdgeLength) {
            return bottom / verticalFadingEdgeLength;
        }
        return 1.0f;
    }

    public int getMaxScrollAmount() {
        return (int) (getHeight() * 0.5f);
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        return this.f2356j.y();
    }

    public int getScrollRange() {
        if (getChildCount() <= 0) {
            return 0;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        return Math.max(0, ((childAt.getHeight() + layoutParams.topMargin) + layoutParams.bottomMargin) - ((getHeight() - getPaddingTop()) - getPaddingBottom()));
    }

    @Override // android.view.View
    public float getTopFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
        }
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int scrollY = getScrollY();
        if (scrollY < verticalFadingEdgeLength) {
            return scrollY / verticalFadingEdgeLength;
        }
        return 1.0f;
    }

    public final boolean gv() {
        if (getChildCount() <= 0) {
            return false;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        if (childAt.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin <= (getHeight() - getPaddingTop()) - getPaddingBottom()) {
            return false;
        }
        return true;
    }

    @Override // android.view.View
    public boolean hasNestedScrollingParent() {
        return f3(0);
    }

    public final void hw(View view) {
        view.getDrawingRect(this.f2354fb);
        offsetDescendantRectToMyCoords(view, this.f2354fb);
        int a2 = a(this.f2354fb);
        if (a2 != 0) {
            scrollBy(0, a2);
        }
    }

    public final float i4(int i) {
        double log = Math.log((Math.abs(i) * 0.35f) / (this.y * 0.015f));
        float f4 = f2345k;
        return (float) (this.y * 0.015f * Math.exp((f4 / (f4 - 1.0d)) * log));
    }

    @Override // hw.tl
    public void i9(@NonNull View view, int i) {
        this.f2356j.v(view, i);
        f7(i);
    }

    @Override // android.view.View
    public boolean isNestedScrollingEnabled() {
        return this.f2360oz.tl();
    }

    public final void j(int i, int i5, int i6, boolean z2) {
        if (getChildCount() == 0) {
            return;
        }
        if (AnimationUtils.currentAnimationTimeMillis() - this.f2368v > 250) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            int scrollY = getScrollY();
            OverScroller overScroller = this.f2365s;
            int scrollX = getScrollX();
            overScroller.startScroll(scrollX, scrollY, 0, Math.max(0, Math.min(i5 + scrollY, Math.max(0, ((childAt.getHeight() + layoutParams.topMargin) + layoutParams.bottomMargin) - ((getHeight() - getPaddingTop()) - getPaddingBottom())))) - scrollY, i6);
            k5(z2);
        } else {
            if (!this.f2365s.isFinished()) {
                y();
            }
            scrollBy(i, i5);
        }
        this.f2368v = AnimationUtils.currentAnimationTimeMillis();
    }

    public final boolean j5(Rect rect, boolean z2) {
        boolean z3;
        int a2 = a(rect);
        if (a2 != 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (z3) {
            if (z2) {
                scrollBy(0, a2);
            } else {
                o(0, a2);
            }
        }
        return z3;
    }

    public final boolean k(MotionEvent motionEvent) {
        boolean z2;
        if (s.n3(this.f2352f) != 0.0f) {
            s.gv(this.f2352f, 0.0f, motionEvent.getX() / getWidth());
            z2 = true;
        } else {
            z2 = false;
        }
        if (s.n3(this.f2366t) != 0.0f) {
            s.gv(this.f2366t, 0.0f, 1.0f - (motionEvent.getX() / getWidth()));
            return true;
        }
        return z2;
    }

    public final void k5(boolean z2) {
        if (z2) {
            q9(2, 1);
        } else {
            f7(1);
        }
        this.f2363qn = getScrollY();
        i4.lc(this);
    }

    @Override // android.view.ViewGroup
    public void measureChild(@NonNull View view, int i, int i5) {
        view.measure(ViewGroup.getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight(), view.getLayoutParams().width), View.MeasureSpec.makeMeasureSpec(0, 0));
    }

    @Override // android.view.ViewGroup
    public void measureChildWithMargins(View view, int i, int i5, int i6, int i8) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        view.measure(ViewGroup.getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i5, marginLayoutParams.width), View.MeasureSpec.makeMeasureSpec(marginLayoutParams.topMargin + marginLayoutParams.bottomMargin, 0));
    }

    public final boolean mg(View view) {
        return !d(view, 0, getHeight());
    }

    public final void mt() {
        this.f2351ej = -1;
        this.f2364r = false;
        x();
        f7(0);
        this.f2352f.onRelease();
        this.f2366t.onRelease();
    }

    public final boolean n(int i, int i5) {
        if (getChildCount() <= 0) {
            return false;
        }
        int scrollY = getScrollY();
        View childAt = getChildAt(0);
        if (i5 < childAt.getTop() - scrollY || i5 >= childAt.getBottom() - scrollY || i < childAt.getLeft() || i >= childAt.getRight()) {
            return false;
        }
        return true;
    }

    public boolean n3(int i) {
        View findFocus = findFocus();
        if (findFocus == this) {
            findFocus = null;
        }
        View findNextFocus = FocusFinder.getInstance().findNextFocus(this, findFocus, i);
        int maxScrollAmount = getMaxScrollAmount();
        if (findNextFocus != null && d(findNextFocus, maxScrollAmount, getHeight())) {
            findNextFocus.getDrawingRect(this.f2354fb);
            offsetDescendantRectToMyCoords(findNextFocus, this.f2354fb);
            vl(a(this.f2354fb), 0, 1, true);
            findNextFocus.requestFocus(i);
        } else {
            if (i == 33 && getScrollY() < maxScrollAmount) {
                maxScrollAmount = getScrollY();
            } else if (i == 130 && getChildCount() > 0) {
                View childAt = getChildAt(0);
                maxScrollAmount = Math.min((childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin) - ((getScrollY() + getHeight()) - getPaddingBottom()), maxScrollAmount);
            }
            if (maxScrollAmount == 0) {
                return false;
            }
            if (i != 130) {
                maxScrollAmount = -maxScrollAmount;
            }
            vl(maxScrollAmount, 0, 1, true);
        }
        if (findFocus != null && findFocus.isFocused() && mg(findFocus)) {
            int descendantFocusability = getDescendantFocusability();
            setDescendantFocusability(131072);
            requestFocus();
            setDescendantFocusability(descendantFocusability);
        }
        return true;
    }

    public final void o(int i, int i5) {
        j(i, i5, 250, false);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f2348co = false;
    }

    @Override // android.view.View
    public boolean onGenericMotionEvent(@NonNull MotionEvent motionEvent) {
        float f4;
        int i;
        if (motionEvent.getAction() != 8 || this.f2364r) {
            return false;
        }
        if (i9.y(motionEvent, 2)) {
            f4 = motionEvent.getAxisValue(9);
            i = (int) motionEvent.getX();
        } else if (i9.y(motionEvent, 4194304)) {
            float axisValue = motionEvent.getAxisValue(26);
            i = getWidth() / 2;
            f4 = axisValue;
        } else {
            f4 = 0.0f;
            i = 0;
        }
        if (f4 == 0.0f) {
            return false;
        }
        vl(-((int) (f4 * getVerticalScrollFactorCompat())), i, 1, i9.y(motionEvent, 8194));
        return true;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(@NonNull MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        boolean z2 = true;
        if (action == 2 && this.f2364r) {
            return true;
        }
        int i = action & 255;
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i == 6) {
                            ej(motionEvent);
                        }
                    }
                } else {
                    int i5 = this.f2351ej;
                    if (i5 != -1) {
                        int findPointerIndex = motionEvent.findPointerIndex(i5);
                        if (findPointerIndex == -1) {
                            Log.e("NestedScrollView", "Invalid pointerId=" + i5 + " in onInterceptTouchEvent");
                        } else {
                            int y2 = (int) motionEvent.getY(findPointerIndex);
                            if (Math.abs(y2 - this.f2369w) > this.f2350d0 && (2 & getNestedScrollAxes()) == 0) {
                                this.f2364r = true;
                                this.f2369w = y2;
                                fh();
                                this.f2353f3.addMovement(motionEvent);
                                this.f2357j5 = 0;
                                ViewParent parent = getParent();
                                if (parent != null) {
                                    parent.requestDisallowInterceptTouchEvent(true);
                                }
                            }
                        }
                    }
                }
            }
            this.f2364r = false;
            this.f2351ej = -1;
            x();
            if (this.f2365s.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                i4.lc(this);
            }
            f7(0);
        } else {
            int y7 = (int) motionEvent.getY();
            if (!n((int) motionEvent.getX(), y7)) {
                if (!k(motionEvent) && this.f2365s.isFinished()) {
                    z2 = false;
                }
                this.f2364r = z2;
                x();
            } else {
                this.f2369w = y7;
                this.f2351ej = motionEvent.getPointerId(0);
                c();
                this.f2353f3.addMovement(motionEvent);
                this.f2365s.computeScrollOffset();
                if (!k(motionEvent) && this.f2365s.isFinished()) {
                    z2 = false;
                }
                this.f2364r = z2;
                q9(2, 0);
            }
        }
        return this.f2364r;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z2, int i, int i5, int i6, int i8) {
        super.onLayout(z2, i, i5, i6, i8);
        int i10 = 0;
        this.f2361p = false;
        View view = this.f2371z;
        if (view != null && ta(view, this)) {
            hw(this.f2371z);
        }
        this.f2371z = null;
        if (!this.f2348co) {
            if (this.f2359o != null) {
                scrollTo(getScrollX(), this.f2359o.y);
                this.f2359o = null;
            }
            if (getChildCount() > 0) {
                View childAt = getChildAt(0);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
                i10 = childAt.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
            }
            int paddingTop = ((i8 - i5) - getPaddingTop()) - getPaddingBottom();
            int scrollY = getScrollY();
            int v2 = v(scrollY, paddingTop, i10);
            if (v2 != scrollY) {
                scrollTo(getScrollX(), v2);
            }
        }
        scrollTo(getScrollX(), getScrollY());
        this.f2348co = true;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i5) {
        super.onMeasure(i, i5);
        if (this.f2358n && View.MeasureSpec.getMode(i5) != 0 && getChildCount() > 0) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int measuredHeight2 = (((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom()) - layoutParams.topMargin) - layoutParams.bottomMargin;
            if (measuredHeight < measuredHeight2) {
                childAt.measure(ViewGroup.getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight() + layoutParams.leftMargin + layoutParams.rightMargin, layoutParams.width), View.MeasureSpec.makeMeasureSpec(measuredHeight2, 1073741824));
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedFling(@NonNull View view, float f4, float f6, boolean z2) {
        if (!z2) {
            dispatchNestedFling(0.0f, f6, true);
            r((int) f6);
            return true;
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedPreFling(@NonNull View view, float f4, float f6) {
        return dispatchNestedPreFling(f4, f6);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedPreScroll(@NonNull View view, int i, int i5, @NonNull int[] iArr) {
        f(view, i, i5, iArr, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedScroll(@NonNull View view, int i, int i5, int i6, int i8) {
        z6(i8, 0, null);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedScrollAccepted(@NonNull View view, @NonNull View view2, int i) {
        c5(view, view2, i, 0);
    }

    @Override // android.view.View
    public void onOverScrolled(int i, int i5, boolean z2, boolean z3) {
        super.scrollTo(i, i5);
    }

    @Override // android.view.ViewGroup
    public boolean onRequestFocusInDescendants(int i, Rect rect) {
        View findNextFocusFromRect;
        if (i == 2) {
            i = 130;
        } else if (i == 1) {
            i = 33;
        }
        if (rect == null) {
            findNextFocusFromRect = FocusFinder.getInstance().findNextFocus(this, null, i);
        } else {
            findNextFocusFromRect = FocusFinder.getInstance().findNextFocusFromRect(this, rect, i);
        }
        if (findNextFocusFromRect == null || mg(findNextFocusFromRect)) {
            return false;
        }
        return findNextFocusFromRect.requestFocus(i, rect);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.f2359o = savedState;
        requestLayout();
    }

    @Override // android.view.View
    @NonNull
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.y = getScrollY();
        return savedState;
    }

    @Override // android.view.View
    public void onScrollChanged(int i, int i5, int i6, int i8) {
        super.onScrollChanged(i, i5, i6, i8);
        zn znVar = this.f2362q9;
        if (znVar != null) {
            znVar.y(this, i, i5, i6, i8);
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i5, int i6, int i8) {
        super.onSizeChanged(i, i5, i6, i8);
        View findFocus = findFocus();
        if (findFocus != null && this != findFocus && d(findFocus, 0, i8)) {
            findFocus.getDrawingRect(this.f2354fb);
            offsetDescendantRectToMyCoords(findFocus, this.f2354fb);
            w(a(this.f2354fb));
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onStartNestedScroll(@NonNull View view, @NonNull View view2, int i) {
        return xc(view, view2, i, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onStopNestedScroll(@NonNull View view) {
        i9(view, 0);
    }

    @Override // android.view.View
    public boolean onTouchEvent(@NonNull MotionEvent motionEvent) {
        ViewParent parent;
        fh();
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f2357j5 = 0;
        }
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        obtain.offsetLocation(0.0f, this.f2357j5);
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked != 2) {
                    if (actionMasked != 3) {
                        if (actionMasked != 5) {
                            if (actionMasked == 6) {
                                ej(motionEvent);
                                this.f2369w = (int) motionEvent.getY(motionEvent.findPointerIndex(this.f2351ej));
                            }
                        } else {
                            int actionIndex = motionEvent.getActionIndex();
                            this.f2369w = (int) motionEvent.getY(actionIndex);
                            this.f2351ej = motionEvent.getPointerId(actionIndex);
                        }
                    } else {
                        if (this.f2364r && getChildCount() > 0 && this.f2365s.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                            i4.lc(this);
                        }
                        mt();
                    }
                } else {
                    int findPointerIndex = motionEvent.findPointerIndex(this.f2351ej);
                    if (findPointerIndex == -1) {
                        Log.e("NestedScrollView", "Invalid pointerId=" + this.f2351ej + " in onTouchEvent");
                    } else {
                        int y2 = (int) motionEvent.getY(findPointerIndex);
                        int i = this.f2369w - y2;
                        int b2 = i - b(i, motionEvent.getX(findPointerIndex));
                        if (!this.f2364r && Math.abs(b2) > this.f2350d0) {
                            ViewParent parent2 = getParent();
                            if (parent2 != null) {
                                parent2.requestDisallowInterceptTouchEvent(true);
                            }
                            this.f2364r = true;
                            b2 = b2 > 0 ? b2 - this.f2350d0 : b2 + this.f2350d0;
                        }
                        if (this.f2364r) {
                            int vl2 = vl(b2, (int) motionEvent.getX(findPointerIndex), 0, false);
                            this.f2369w = y2 - vl2;
                            this.f2357j5 += vl2;
                        }
                    }
                }
            } else {
                VelocityTracker velocityTracker = this.f2353f3;
                velocityTracker.computeCurrentVelocity(1000, this.f2349d);
                int yVelocity = (int) velocityTracker.getYVelocity(this.f2351ej);
                if (Math.abs(yVelocity) >= this.f2355fh) {
                    if (!p(yVelocity)) {
                        int i5 = -yVelocity;
                        float f4 = i5;
                        if (!dispatchNestedPreFling(0.0f, f4)) {
                            dispatchNestedFling(0.0f, f4, true);
                            r(i5);
                        }
                    }
                } else if (this.f2365s.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                    i4.lc(this);
                }
                mt();
            }
        } else if (getChildCount() == 0) {
            return false;
        } else {
            if (this.f2364r && (parent = getParent()) != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
            if (!this.f2365s.isFinished()) {
                y();
            }
            rz((int) motionEvent.getY(), motionEvent.getPointerId(0));
        }
        VelocityTracker velocityTracker2 = this.f2353f3;
        if (velocityTracker2 != null) {
            velocityTracker2.addMovement(obtain);
        }
        obtain.recycle();
        return true;
    }

    public void oz(int i, int i5, int i6, boolean z2) {
        j(i - getScrollX(), i5 - getScrollY(), i6, z2);
    }

    public final boolean p(int i) {
        if (s.n3(this.f2352f) != 0.0f) {
            if (qn(this.f2352f, i)) {
                this.f2352f.onAbsorb(i);
            } else {
                r(-i);
            }
        } else if (s.n3(this.f2366t) != 0.0f) {
            int i5 = -i;
            if (qn(this.f2366t, i5)) {
                this.f2366t.onAbsorb(i5);
            } else {
                r(i5);
            }
        } else {
            return false;
        }
        return true;
    }

    public boolean q9(int i, int i5) {
        return this.f2360oz.p(i, i5);
    }

    public final boolean qn(@NonNull EdgeEffect edgeEffect, int i) {
        if (i > 0) {
            return true;
        }
        if (i4(-i) < s.n3(edgeEffect) * getHeight()) {
            return true;
        }
        return false;
    }

    public void r(int i) {
        if (getChildCount() > 0) {
            this.f2365s.fling(getScrollX(), getScrollY(), 0, i, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE, 0, 0);
            k5(true);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view, View view2) {
        if (!this.f2361p) {
            hw(view2);
        } else {
            this.f2371z = view2;
        }
        super.requestChildFocus(view, view2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(@NonNull View view, Rect rect, boolean z2) {
        rect.offset(view.getLeft() - view.getScrollX(), view.getTop() - view.getScrollY());
        return j5(rect, z2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z2) {
        if (z2) {
            x();
        }
        super.requestDisallowInterceptTouchEvent(z2);
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        this.f2361p = true;
        super.requestLayout();
    }

    public final void rz(int i, int i5) {
        this.f2369w = i;
        this.f2351ej = i5;
        q9(2, 0);
    }

    public boolean s(int i, int i5, @Nullable int[] iArr, @Nullable int[] iArr2, int i6) {
        return this.f2360oz.gv(i, i5, iArr, iArr2, i6);
    }

    @Override // android.view.View
    public void scrollTo(int i, int i5) {
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            int v2 = v(i, (getWidth() - getPaddingLeft()) - getPaddingRight(), childAt.getWidth() + layoutParams.leftMargin + layoutParams.rightMargin);
            int v3 = v(i5, (getHeight() - getPaddingTop()) - getPaddingBottom(), childAt.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin);
            if (v2 != getScrollX() || v3 != getScrollY()) {
                super.scrollTo(v2, v3);
            }
        }
    }

    public void setFillViewport(boolean z2) {
        if (z2 != this.f2358n) {
            this.f2358n = z2;
            requestLayout();
        }
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean z2) {
        this.f2360oz.wz(z2);
    }

    public void setOnScrollChangeListener(@Nullable zn znVar) {
        this.f2362q9 = znVar;
    }

    public void setSmoothScrollingEnabled(boolean z2) {
        this.f2347c = z2;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return true;
    }

    @Override // android.view.View
    public boolean startNestedScroll(int i) {
        return q9(i, 0);
    }

    @Override // android.view.View
    public void stopNestedScroll() {
        f7(0);
    }

    public void t(int i, int i5, int i6, int i8, @Nullable int[] iArr, int i10, @NonNull int[] iArr2) {
        this.f2360oz.v(i, i5, i6, i8, iArr, i10, iArr2);
    }

    @Override // hw.wz
    public void tl(@NonNull View view, int i, int i5, int i6, int i8, int i10, @NonNull int[] iArr) {
        z6(i8, i10, iArr);
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0083 A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean ud(int r13, int r14, int r15, int r16, int r17, int r18, int r19, int r20, boolean r21) {
        /*
            r12 = this;
            r0 = r12
            int r1 = r12.getOverScrollMode()
            int r2 = r12.computeHorizontalScrollRange()
            int r3 = r12.computeHorizontalScrollExtent()
            r4 = 0
            r5 = 1
            if (r2 <= r3) goto L13
            r2 = 1
            goto L14
        L13:
            r2 = 0
        L14:
            int r3 = r12.computeVerticalScrollRange()
            int r6 = r12.computeVerticalScrollExtent()
            if (r3 <= r6) goto L20
            r3 = 1
            goto L21
        L20:
            r3 = 0
        L21:
            if (r1 == 0) goto L2a
            if (r1 != r5) goto L28
            if (r2 == 0) goto L28
            goto L2a
        L28:
            r2 = 0
            goto L2b
        L2a:
            r2 = 1
        L2b:
            if (r1 == 0) goto L34
            if (r1 != r5) goto L32
            if (r3 == 0) goto L32
            goto L34
        L32:
            r1 = 0
            goto L35
        L34:
            r1 = 1
        L35:
            int r3 = r15 + r13
            if (r2 != 0) goto L3b
            r2 = 0
            goto L3d
        L3b:
            r2 = r19
        L3d:
            int r6 = r16 + r14
            if (r1 != 0) goto L43
            r1 = 0
            goto L45
        L43:
            r1 = r20
        L45:
            int r7 = -r2
            int r2 = r2 + r17
            int r8 = -r1
            int r1 = r1 + r18
            if (r3 <= r2) goto L50
            r3 = r2
        L4e:
            r2 = 1
            goto L55
        L50:
            if (r3 >= r7) goto L54
            r3 = r7
            goto L4e
        L54:
            r2 = 0
        L55:
            if (r6 <= r1) goto L5a
            r6 = r1
        L58:
            r1 = 1
            goto L5f
        L5a:
            if (r6 >= r8) goto L5e
            r6 = r8
            goto L58
        L5e:
            r1 = 0
        L5f:
            if (r1 == 0) goto L7e
            boolean r7 = r12.f3(r5)
            if (r7 != 0) goto L7e
            android.widget.OverScroller r7 = r0.f2365s
            r8 = 0
            int r9 = r12.getScrollRange()
            r10 = 0
            r11 = 0
            r13 = r7
            r14 = r3
            r15 = r6
            r16 = r10
            r17 = r11
            r18 = r8
            r19 = r9
            r13.springBack(r14, r15, r16, r17, r18, r19)
        L7e:
            r12.onOverScrolled(r3, r6, r2, r1)
            if (r2 != 0) goto L85
            if (r1 == 0) goto L86
        L85:
            r4 = 1
        L86:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.NestedScrollView.ud(int, int, int, int, int, int, int, int, boolean):boolean");
    }

    public void ut(int i, int i5, boolean z2) {
        oz(i, i5, 250, z2);
    }

    public final int vl(int i, int i5, int i6, boolean z2) {
        int i8;
        int i10;
        boolean z3;
        boolean z4;
        if (i6 == 1) {
            q9(2, i6);
        }
        boolean z5 = false;
        if (s(0, i, this.f2346b, this.f2370x, i6)) {
            i8 = i - this.f2346b[1];
            i10 = this.f2370x[1];
        } else {
            i8 = i;
            i10 = 0;
        }
        int scrollY = getScrollY();
        int scrollRange = getScrollRange();
        if (zn() && !z2) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (ud(0, i8, 0, scrollY, 0, scrollRange, 0, 0, true) && !f3(i6)) {
            z4 = true;
        } else {
            z4 = false;
        }
        int scrollY2 = getScrollY() - scrollY;
        int[] iArr = this.f2346b;
        iArr[1] = 0;
        t(0, scrollY2, 0, i8 - scrollY2, this.f2370x, i6, iArr);
        int i11 = i10 + this.f2370x[1];
        int i12 = i8 - this.f2346b[1];
        int i13 = scrollY + i12;
        if (i13 < 0) {
            if (z3) {
                s.gv(this.f2352f, (-i12) / getHeight(), i5 / getWidth());
                if (!this.f2366t.isFinished()) {
                    this.f2366t.onRelease();
                }
            }
        } else if (i13 > scrollRange && z3) {
            s.gv(this.f2366t, i12 / getHeight(), 1.0f - (i5 / getWidth()));
            if (!this.f2352f.isFinished()) {
                this.f2352f.onRelease();
            }
        }
        if (this.f2352f.isFinished() && this.f2366t.isFinished()) {
            z5 = z4;
        } else {
            i4.lc(this);
        }
        if (z5 && i6 == 0) {
            this.f2353f3.clear();
        }
        if (i6 == 1) {
            f7(i6);
            this.f2352f.onRelease();
            this.f2366t.onRelease();
        }
        return i11;
    }

    public final void w(int i) {
        if (i != 0) {
            if (this.f2347c) {
                o(0, i);
            } else {
                scrollBy(0, i);
            }
        }
    }

    @Override // hw.tl
    public void wz(@NonNull View view, int i, int i5, int i6, int i8, int i10) {
        z6(i8, i10, null);
    }

    public final void x() {
        VelocityTracker velocityTracker = this.f2353f3;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f2353f3 = null;
        }
    }

    public boolean x4(int i) {
        boolean z2;
        int childCount;
        if (i == 130) {
            z2 = true;
        } else {
            z2 = false;
        }
        int height = getHeight();
        Rect rect = this.f2354fb;
        rect.top = 0;
        rect.bottom = height;
        if (z2 && (childCount = getChildCount()) > 0) {
            View childAt = getChildAt(childCount - 1);
            this.f2354fb.bottom = childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin + getPaddingBottom();
            Rect rect2 = this.f2354fb;
            rect2.top = rect2.bottom - height;
        }
        Rect rect3 = this.f2354fb;
        return yt(i, rect3.top, rect3.bottom);
    }

    @Override // hw.tl
    public boolean xc(@NonNull View view, @NonNull View view2, int i, int i5) {
        return (i & 2) != 0;
    }

    public final void y() {
        this.f2365s.abortAnimation();
        f7(1);
    }

    public final boolean yt(int i, int i5, int i6) {
        boolean z2;
        int i8;
        int height = getHeight();
        int scrollY = getScrollY();
        int i10 = height + scrollY;
        boolean z3 = false;
        if (i == 33) {
            z2 = true;
        } else {
            z2 = false;
        }
        View z4 = z(z2, i5, i6);
        if (z4 == null) {
            z4 = this;
        }
        if (i5 < scrollY || i6 > i10) {
            if (z2) {
                i8 = i5 - scrollY;
            } else {
                i8 = i6 - i10;
            }
            vl(i8, 0, 1, true);
            z3 = true;
        }
        if (z4 != findFocus()) {
            z4.requestFocus(i);
        }
        return z3;
    }

    public final View z(boolean z2, int i, int i5) {
        boolean z3;
        boolean z4;
        ArrayList<View> focusables = getFocusables(2);
        int size = focusables.size();
        View view = null;
        boolean z5 = false;
        for (int i6 = 0; i6 < size; i6++) {
            View view2 = focusables.get(i6);
            int top = view2.getTop();
            int bottom = view2.getBottom();
            if (i < bottom && top < i5) {
                if (i < top && bottom < i5) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (view == null) {
                    view = view2;
                    z5 = z3;
                } else {
                    if ((z2 && top < view.getTop()) || (!z2 && bottom > view.getBottom())) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    if (z5) {
                        if (z3) {
                            if (!z4) {
                            }
                            view = view2;
                        }
                    } else if (z3) {
                        view = view2;
                        z5 = true;
                    } else {
                        if (!z4) {
                        }
                        view = view2;
                    }
                }
            }
        }
        return view;
    }

    public final void z6(int i, int i5, @Nullable int[] iArr) {
        int scrollY = getScrollY();
        scrollBy(0, i);
        int scrollY2 = getScrollY() - scrollY;
        if (iArr != null) {
            iArr[1] = iArr[1] + scrollY2;
        }
        this.f2360oz.v(0, scrollY2, 0, i - scrollY2, null, i5, iArr);
    }

    public final boolean zn() {
        int overScrollMode = getOverScrollMode();
        if (overScrollMode == 0) {
            return true;
        }
        if (overScrollMode == 1 && getScrollRange() > 0) {
            return true;
        }
        return false;
    }

    public NestedScrollView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2354fb = new Rect();
        this.f2361p = true;
        this.f2348co = false;
        this.f2371z = null;
        this.f2364r = false;
        this.f2347c = true;
        this.f2351ej = -1;
        this.f2370x = new int[2];
        this.f2346b = new int[2];
        this.f2352f = s.y(context, attributeSet);
        this.f2366t = s.y(context, attributeSet);
        this.y = context.getResources().getDisplayMetrics().density * 160.0f * 386.0878f * 0.84f;
        d0();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f2343en, i, 0);
        setFillViewport(obtainStyledAttributes.getBoolean(0, false));
        obtainStyledAttributes.recycle();
        this.f2356j = new xc(this);
        this.f2360oz = new t(this);
        setNestedScrollingEnabled(true);
        i4.g3(this, f2344f7);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i) {
        if (getChildCount() <= 0) {
            super.addView(view, i);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        if (getChildCount() <= 0) {
            super.addView(view, layoutParams);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (getChildCount() <= 0) {
            super.addView(view, i, layoutParams);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }
}
