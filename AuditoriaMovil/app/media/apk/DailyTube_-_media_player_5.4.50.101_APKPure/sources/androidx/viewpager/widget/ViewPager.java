package androidx.viewpager.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.Scroller;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.customview.view.AbsSavedState;
import hw.i4;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
/* loaded from: classes.dex */
public class ViewPager extends ViewGroup {

    /* renamed from: ap  reason: collision with root package name */
    public boolean f3541ap;

    /* renamed from: b  reason: collision with root package name */
    public int f3542b;

    /* renamed from: bk  reason: collision with root package name */
    public int f3543bk;

    /* renamed from: c  reason: collision with root package name */
    public Drawable f3544c;

    /* renamed from: co  reason: collision with root package name */
    public ClassLoader f3545co;

    /* renamed from: ct  reason: collision with root package name */
    public int f3546ct;

    /* renamed from: d  reason: collision with root package name */
    public float f3547d;

    /* renamed from: d0  reason: collision with root package name */
    public int f3548d0;

    /* renamed from: dm  reason: collision with root package name */
    public VelocityTracker f3549dm;

    /* renamed from: e  reason: collision with root package name */
    public boolean f3550e;

    /* renamed from: eb  reason: collision with root package name */
    public int f3551eb;

    /* renamed from: ej  reason: collision with root package name */
    public float f3552ej;

    /* renamed from: en  reason: collision with root package name */
    public float f3553en;

    /* renamed from: f  reason: collision with root package name */
    public PagerAdapter f3554f;

    /* renamed from: f3  reason: collision with root package name */
    public s f3555f3;

    /* renamed from: f7  reason: collision with root package name */
    public int f3556f7;

    /* renamed from: fb  reason: collision with root package name */
    public final gv f3557fb;

    /* renamed from: fh  reason: collision with root package name */
    public int f3558fh;

    /* renamed from: g  reason: collision with root package name */
    public ArrayList<View> f3559g;

    /* renamed from: g3  reason: collision with root package name */
    public List<a> f3560g3;

    /* renamed from: j  reason: collision with root package name */
    public int f3561j;

    /* renamed from: j5  reason: collision with root package name */
    public boolean f3562j5;

    /* renamed from: jz  reason: collision with root package name */
    public float f3563jz;

    /* renamed from: k  reason: collision with root package name */
    public int f3564k;

    /* renamed from: kp  reason: collision with root package name */
    public fb f3565kp;

    /* renamed from: lc  reason: collision with root package name */
    public boolean f3566lc;

    /* renamed from: m  reason: collision with root package name */
    public int f3567m;

    /* renamed from: n  reason: collision with root package name */
    public int f3568n;

    /* renamed from: nf  reason: collision with root package name */
    public EdgeEffect f3569nf;

    /* renamed from: o  reason: collision with root package name */
    public boolean f3570o;

    /* renamed from: o4  reason: collision with root package name */
    public int f3571o4;

    /* renamed from: oz  reason: collision with root package name */
    public boolean f3572oz;

    /* renamed from: p  reason: collision with root package name */
    public Parcelable f3573p;

    /* renamed from: q9  reason: collision with root package name */
    public int f3574q9;

    /* renamed from: qn  reason: collision with root package name */
    public boolean f3575qn;

    /* renamed from: r  reason: collision with root package name */
    public boolean f3576r;

    /* renamed from: ra  reason: collision with root package name */
    public EdgeEffect f3577ra;

    /* renamed from: rb  reason: collision with root package name */
    public fb f3578rb;

    /* renamed from: rs  reason: collision with root package name */
    public int f3579rs;

    /* renamed from: s  reason: collision with root package name */
    public final Rect f3580s;

    /* renamed from: s8  reason: collision with root package name */
    public boolean f3581s8;

    /* renamed from: t  reason: collision with root package name */
    public int f3582t;

    /* renamed from: u  reason: collision with root package name */
    public float f3583u;

    /* renamed from: u0  reason: collision with root package name */
    public final Runnable f3584u0;

    /* renamed from: ut  reason: collision with root package name */
    public boolean f3585ut;

    /* renamed from: v  reason: collision with root package name */
    public final ArrayList<gv> f3586v;

    /* renamed from: w  reason: collision with root package name */
    public int f3587w;

    /* renamed from: x  reason: collision with root package name */
    public int f3588x;

    /* renamed from: xg  reason: collision with root package name */
    public int f3589xg;
    public int y;

    /* renamed from: y5  reason: collision with root package name */
    public float f3590y5;

    /* renamed from: yc  reason: collision with root package name */
    public List<fb> f3591yc;

    /* renamed from: yg  reason: collision with root package name */
    public int f3592yg;

    /* renamed from: z  reason: collision with root package name */
    public Scroller f3593z;

    /* renamed from: y4  reason: collision with root package name */
    public static final int[] f3540y4 = {16842931};

    /* renamed from: tg  reason: collision with root package name */
    public static final Comparator<gv> f3539tg = new y();

    /* renamed from: pz  reason: collision with root package name */
    public static final Interpolator f3538pz = new n3();

    /* renamed from: pq  reason: collision with root package name */
    public static final c5 f3537pq = new c5();

    /* loaded from: classes.dex */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new y();

        /* renamed from: f  reason: collision with root package name */
        public ClassLoader f3594f;

        /* renamed from: fb  reason: collision with root package name */
        public int f3595fb;

        /* renamed from: s  reason: collision with root package name */
        public Parcelable f3596s;

        /* loaded from: classes.dex */
        public static class y implements Parcelable.ClassLoaderCreator<SavedState> {
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

        public SavedState(@NonNull Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "FragmentPager.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " position=" + this.f3595fb + "}";
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f3595fb);
            parcel.writeParcelable(this.f3596s, i);
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            classLoader = classLoader == null ? getClass().getClassLoader() : classLoader;
            this.f3595fb = parcel.readInt();
            this.f3596s = parcel.readParcelable(classLoader);
            this.f3594f = classLoader;
        }
    }

    /* loaded from: classes.dex */
    public interface a {
        void y(@NonNull ViewPager viewPager, @Nullable PagerAdapter pagerAdapter, @Nullable PagerAdapter pagerAdapter2);
    }

    /* loaded from: classes.dex */
    public static class c5 implements Comparator<View> {
        @Override // java.util.Comparator
        /* renamed from: y */
        public int compare(View view, View view2) {
            v vVar = (v) view.getLayoutParams();
            v vVar2 = (v) view2.getLayoutParams();
            boolean z2 = vVar.y;
            if (z2 != vVar2.y) {
                if (z2) {
                    return 1;
                }
                return -1;
            }
            return vVar.f3604v - vVar2.f3604v;
        }
    }

    /* loaded from: classes.dex */
    public interface fb {
        void n3(int i);

        void y(int i, float f4, int i5);

        void zn(int i);
    }

    /* loaded from: classes.dex */
    public static class gv {

        /* renamed from: gv  reason: collision with root package name */
        public float f3597gv;

        /* renamed from: n3  reason: collision with root package name */
        public int f3598n3;

        /* renamed from: v  reason: collision with root package name */
        public float f3599v;
        public Object y;

        /* renamed from: zn  reason: collision with root package name */
        public boolean f3600zn;
    }

    /* loaded from: classes.dex */
    public static class n3 implements Interpolator {
        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f4) {
            float f6 = f4 - 1.0f;
            return (f6 * f6 * f6 * f6 * f6) + 1.0f;
        }
    }

    /* loaded from: classes.dex */
    public class s extends DataSetObserver {
        public s() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            ViewPager.this.s();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            ViewPager.this.s();
        }
    }

    /* loaded from: classes.dex */
    public static class v extends ViewGroup.LayoutParams {

        /* renamed from: a  reason: collision with root package name */
        public int f3601a;

        /* renamed from: gv  reason: collision with root package name */
        public boolean f3602gv;

        /* renamed from: n3  reason: collision with root package name */
        public int f3603n3;

        /* renamed from: v  reason: collision with root package name */
        public int f3604v;
        public boolean y;

        /* renamed from: zn  reason: collision with root package name */
        public float f3605zn;

        public v() {
            super(-1, -1);
        }

        public v(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ViewPager.f3540y4);
            this.f3603n3 = obtainStyledAttributes.getInteger(0, 48);
            obtainStyledAttributes.recycle();
        }
    }

    /* loaded from: classes.dex */
    public static class y implements Comparator<gv> {
        @Override // java.util.Comparator
        /* renamed from: y */
        public int compare(gv gvVar, gv gvVar2) {
            return gvVar.f3598n3 - gvVar2.f3598n3;
        }
    }

    @Target({ElementType.TYPE})
    @Inherited
    @Retention(RetentionPolicy.RUNTIME)
    /* loaded from: classes.dex */
    public @interface zn {
    }

    private int getClientWidth() {
        return (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
    }

    public static boolean r(@NonNull View view) {
        if (view.getClass().getAnnotation(zn.class) != null) {
            return true;
        }
        return false;
    }

    private void setScrollingCacheEnabled(boolean z2) {
        if (this.f3575qn != z2) {
            this.f3575qn = z2;
        }
    }

    public boolean a(View view, boolean z2, int i, int i5, int i6) {
        int i8;
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                int i10 = i5 + scrollX;
                if (i10 >= childAt.getLeft() && i10 < childAt.getRight() && (i8 = i6 + scrollY) >= childAt.getTop() && i8 < childAt.getBottom() && a(childAt, true, i, i10 - childAt.getLeft(), i8 - childAt.getTop())) {
                    return true;
                }
            }
        }
        if (z2 && view.canScrollHorizontally(-i)) {
            return true;
        }
        return false;
    }

    public final boolean a8() {
        this.f3589xg = -1;
        wz();
        this.f3569nf.onRelease();
        this.f3577ra.onRelease();
        if (!this.f3569nf.isFinished() && !this.f3577ra.isFinished()) {
            return false;
        }
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> arrayList, int i, int i5) {
        gv mt2;
        int size = arrayList.size();
        int descendantFocusability = getDescendantFocusability();
        if (descendantFocusability != 393216) {
            for (int i6 = 0; i6 < getChildCount(); i6++) {
                View childAt = getChildAt(i6);
                if (childAt.getVisibility() == 0 && (mt2 = mt(childAt)) != null && mt2.f3598n3 == this.f3582t) {
                    childAt.addFocusables(arrayList, i, i5);
                }
            }
        }
        if ((descendantFocusability == 262144 && size != arrayList.size()) || !isFocusable()) {
            return;
        }
        if ((i5 & 1) == 1 && isInTouchMode() && !isFocusableInTouchMode()) {
            return;
        }
        arrayList.add(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addTouchables(ArrayList<View> arrayList) {
        gv mt2;
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 0 && (mt2 = mt(childAt)) != null && mt2.f3598n3 == this.f3582t) {
                childAt.addTouchables(arrayList);
            }
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (!checkLayoutParams(layoutParams)) {
            layoutParams = generateLayoutParams(layoutParams);
        }
        v vVar = (v) layoutParams;
        boolean r2 = vVar.y | r(view);
        vVar.y = r2;
        if (this.f3562j5) {
            if (!r2) {
                vVar.f3602gv = true;
                addViewInLayout(view, i, layoutParams);
                return;
            }
            throw new IllegalStateException("Cannot add pager decor view during layout");
        }
        super.addView(view, i, layoutParams);
    }

    public void b(int i, boolean z2) {
        this.f3570o = false;
        k5(i, z2, false);
    }

    public boolean c() {
        PagerAdapter pagerAdapter = this.f3554f;
        if (pagerAdapter != null && this.f3582t < pagerAdapter.getCount() - 1) {
            b(this.f3582t + 1, true);
            return true;
        }
        return false;
    }

    public final int c5(int i, float f4, int i5, int i6) {
        float f6;
        if (Math.abs(i6) > this.f3579rs && Math.abs(i5) > this.f3546ct) {
            if (i5 <= 0) {
                i++;
            }
        } else {
            if (i >= this.f3582t) {
                f6 = 0.4f;
            } else {
                f6 = 0.6f;
            }
            i += (int) (f4 + f6);
        }
        if (this.f3586v.size() > 0) {
            ArrayList<gv> arrayList = this.f3586v;
            return Math.max(this.f3586v.get(0).f3598n3, Math.min(i, arrayList.get(arrayList.size() - 1).f3598n3));
        }
        return i;
    }

    @Override // android.view.View
    public boolean canScrollHorizontally(int i) {
        if (this.f3554f == null) {
            return false;
        }
        int clientWidth = getClientWidth();
        int scrollX = getScrollX();
        if (i < 0) {
            if (scrollX <= ((int) (clientWidth * this.f3547d))) {
                return false;
            }
            return true;
        } else if (i <= 0 || scrollX >= ((int) (clientWidth * this.f3552ej))) {
            return false;
        } else {
            return true;
        }
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if ((layoutParams instanceof v) && super.checkLayoutParams(layoutParams)) {
            return true;
        }
        return false;
    }

    public final gv co() {
        float f4;
        float f6;
        int i;
        int clientWidth = getClientWidth();
        float f9 = 0.0f;
        if (clientWidth > 0) {
            f4 = getScrollX() / clientWidth;
        } else {
            f4 = 0.0f;
        }
        if (clientWidth > 0) {
            f6 = this.f3568n / clientWidth;
        } else {
            f6 = 0.0f;
        }
        gv gvVar = null;
        float f10 = 0.0f;
        int i5 = -1;
        int i6 = 0;
        boolean z2 = true;
        while (i6 < this.f3586v.size()) {
            gv gvVar2 = this.f3586v.get(i6);
            if (!z2 && gvVar2.f3598n3 != (i = i5 + 1)) {
                gvVar2 = this.f3557fb;
                gvVar2.f3599v = f9 + f10 + f6;
                gvVar2.f3598n3 = i;
                gvVar2.f3597gv = this.f3554f.getPageWidth(i);
                i6--;
            }
            gv gvVar3 = gvVar2;
            f9 = gvVar3.f3599v;
            float f11 = gvVar3.f3597gv + f9 + f6;
            if (!z2 && f4 < f9) {
                return gvVar;
            }
            if (f4 >= f11 && i6 != this.f3586v.size() - 1) {
                int i8 = gvVar3.f3598n3;
                float f12 = gvVar3.f3597gv;
                i6++;
                z2 = false;
                i5 = i8;
                f10 = f12;
                gvVar = gvVar3;
            } else {
                return gvVar3;
            }
        }
        return gvVar;
    }

    @Override // android.view.View
    public void computeScroll() {
        this.f3576r = true;
        if (!this.f3593z.isFinished() && this.f3593z.computeScrollOffset()) {
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            int currX = this.f3593z.getCurrX();
            int currY = this.f3593z.getCurrY();
            if (scrollX != currX || scrollY != currY) {
                scrollTo(currX, currY);
                if (!d0(currX)) {
                    this.f3593z.abortAnimation();
                    scrollTo(0, currY);
                }
            }
            i4.lc(this);
            return;
        }
        fb(true);
    }

    public final void d() {
        int i = 0;
        while (i < getChildCount()) {
            if (!((v) getChildAt(i).getLayoutParams()).y) {
                removeViewAt(i);
                i--;
            }
            i++;
        }
    }

    public final boolean d0(int i) {
        if (this.f3586v.size() == 0) {
            if (this.f3550e) {
                return false;
            }
            this.f3541ap = false;
            i4(0, 0.0f, 0);
            if (this.f3541ap) {
                return false;
            }
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        }
        gv co2 = co();
        int clientWidth = getClientWidth();
        int i5 = this.f3568n;
        int i6 = clientWidth + i5;
        float f4 = clientWidth;
        int i8 = co2.f3598n3;
        float f6 = ((i / f4) - co2.f3599v) / (co2.f3597gv + (i5 / f4));
        this.f3541ap = false;
        i4(i8, f6, (int) (i6 * f6));
        if (this.f3541ap) {
            return true;
        }
        throw new IllegalStateException("onPageScrolled did not call superclass implementation");
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (!super.dispatchKeyEvent(keyEvent) && !xc(keyEvent)) {
            return false;
        }
        return true;
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        gv mt2;
        if (accessibilityEvent.getEventType() == 4096) {
            return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 0 && (mt2 = mt(childAt)) != null && mt2.f3598n3 == this.f3582t && childAt.dispatchPopulateAccessibilityEvent(accessibilityEvent)) {
                return true;
            }
        }
        return false;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        PagerAdapter pagerAdapter;
        super.draw(canvas);
        int overScrollMode = getOverScrollMode();
        boolean z2 = false;
        if (overScrollMode != 0 && (overScrollMode != 1 || (pagerAdapter = this.f3554f) == null || pagerAdapter.getCount() <= 1)) {
            this.f3569nf.finish();
            this.f3577ra.finish();
        } else {
            if (!this.f3569nf.isFinished()) {
                int save = canvas.save();
                int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
                int width = getWidth();
                canvas.rotate(270.0f);
                canvas.translate((-height) + getPaddingTop(), this.f3547d * width);
                this.f3569nf.setSize(height, width);
                z2 = this.f3569nf.draw(canvas);
                canvas.restoreToCount(save);
            }
            if (!this.f3577ra.isFinished()) {
                int save2 = canvas.save();
                int width2 = getWidth();
                int height2 = (getHeight() - getPaddingTop()) - getPaddingBottom();
                canvas.rotate(90.0f);
                canvas.translate(-getPaddingTop(), (-(this.f3552ej + 1.0f)) * width2);
                this.f3577ra.setSize(height2, width2);
                z2 |= this.f3577ra.draw(canvas);
                canvas.restoreToCount(save2);
            }
        }
        if (z2) {
            i4.lc(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.f3544c;
        if (drawable != null && drawable.isStateful()) {
            drawable.setState(getDrawableState());
        }
    }

    public void ej(@NonNull fb fbVar) {
        List<fb> list = this.f3591yc;
        if (list != null) {
            list.remove(fbVar);
        }
    }

    public final void f(int i) {
        fb fbVar = this.f3565kp;
        if (fbVar != null) {
            fbVar.zn(i);
        }
        List<fb> list = this.f3591yc;
        if (list != null) {
            int size = list.size();
            for (int i5 = 0; i5 < size; i5++) {
                fb fbVar2 = this.f3591yc.get(i5);
                if (fbVar2 != null) {
                    fbVar2.zn(i);
                }
            }
        }
        fb fbVar3 = this.f3578rb;
        if (fbVar3 != null) {
            fbVar3.zn(i);
        }
    }

    public final void f3(MotionEvent motionEvent) {
        int i;
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.f3589xg) {
            if (actionIndex == 0) {
                i = 1;
            } else {
                i = 0;
            }
            this.f3553en = motionEvent.getX(i);
            this.f3589xg = motionEvent.getPointerId(i);
            VelocityTracker velocityTracker = this.f3549dm;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }

    public final void fb(boolean z2) {
        boolean z3;
        if (this.f3543bk == 2) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (z3) {
            setScrollingCacheEnabled(false);
            if (!this.f3593z.isFinished()) {
                this.f3593z.abortAnimation();
                int scrollX = getScrollX();
                int scrollY = getScrollY();
                int currX = this.f3593z.getCurrX();
                int currY = this.f3593z.getCurrY();
                if (scrollX != currX || scrollY != currY) {
                    scrollTo(currX, currY);
                    if (currX != scrollX) {
                        d0(currX);
                    }
                }
            }
        }
        this.f3570o = false;
        for (int i = 0; i < this.f3586v.size(); i++) {
            gv gvVar = this.f3586v.get(i);
            if (gvVar.f3600zn) {
                gvVar.f3600zn = false;
                z3 = true;
            }
        }
        if (z3) {
            if (z2) {
                i4.nf(this, this.f3584u0);
            } else {
                this.f3584u0.run();
            }
        }
    }

    public final boolean fh(float f4) {
        boolean z2;
        boolean z3;
        float f6 = this.f3553en - f4;
        this.f3553en = f4;
        float scrollX = getScrollX() + f6;
        float clientWidth = getClientWidth();
        float f9 = this.f3547d * clientWidth;
        float f10 = this.f3552ej * clientWidth;
        boolean z4 = false;
        gv gvVar = this.f3586v.get(0);
        ArrayList<gv> arrayList = this.f3586v;
        gv gvVar2 = arrayList.get(arrayList.size() - 1);
        if (gvVar.f3598n3 != 0) {
            f9 = gvVar.f3599v * clientWidth;
            z2 = false;
        } else {
            z2 = true;
        }
        if (gvVar2.f3598n3 != this.f3554f.getCount() - 1) {
            f10 = gvVar2.f3599v * clientWidth;
            z3 = false;
        } else {
            z3 = true;
        }
        if (scrollX < f9) {
            if (z2) {
                this.f3569nf.onPull(Math.abs(f9 - scrollX) / clientWidth);
                z4 = true;
            }
            scrollX = f9;
        } else if (scrollX > f10) {
            if (z3) {
                this.f3577ra.onPull(Math.abs(scrollX - f10) / clientWidth);
                z4 = true;
            }
            scrollX = f10;
        }
        int i = (int) scrollX;
        this.f3553en += scrollX - i;
        scrollTo(i, getScrollY());
        d0(i);
        return z4;
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new v();
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return generateDefaultLayoutParams();
    }

    @Nullable
    public PagerAdapter getAdapter() {
        return this.f3554f;
    }

    @Override // android.view.ViewGroup
    public int getChildDrawingOrder(int i, int i5) {
        if (this.f3567m == 2) {
            i5 = (i - 1) - i5;
        }
        return ((v) this.f3559g.get(i5).getLayoutParams()).f3601a;
    }

    public int getCurrentItem() {
        return this.f3582t;
    }

    public int getOffscreenPageLimit() {
        return this.f3561j;
    }

    public int getPageMargin() {
        return this.f3568n;
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x00cc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean gv(int r5) {
        /*
            r4 = this;
            android.view.View r0 = r4.findFocus()
            r1 = 0
            if (r0 != r4) goto L9
        L7:
            r0 = r1
            goto L63
        L9:
            if (r0 == 0) goto L63
            android.view.ViewParent r2 = r0.getParent()
        Lf:
            boolean r3 = r2 instanceof android.view.ViewGroup
            if (r3 == 0) goto L1b
            if (r2 != r4) goto L16
            goto L63
        L16:
            android.view.ViewParent r2 = r2.getParent()
            goto Lf
        L1b:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.Class r3 = r0.getClass()
            java.lang.String r3 = r3.getSimpleName()
            r2.append(r3)
            android.view.ViewParent r0 = r0.getParent()
        L2f:
            boolean r3 = r0 instanceof android.view.ViewGroup
            if (r3 == 0) goto L48
            java.lang.String r3 = " => "
            r2.append(r3)
            java.lang.Class r3 = r0.getClass()
            java.lang.String r3 = r3.getSimpleName()
            r2.append(r3)
            android.view.ViewParent r0 = r0.getParent()
            goto L2f
        L48:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r3 = "arrowScroll tried to find focus based on non-child current focused view "
            r0.append(r3)
            java.lang.String r2 = r2.toString()
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            java.lang.String r2 = "ViewPager"
            android.util.Log.e(r2, r0)
            goto L7
        L63:
            android.view.FocusFinder r1 = android.view.FocusFinder.getInstance()
            android.view.View r1 = r1.findNextFocus(r4, r0, r5)
            r2 = 66
            r3 = 17
            if (r1 == 0) goto Lb3
            if (r1 == r0) goto Lb3
            if (r5 != r3) goto L93
            android.graphics.Rect r2 = r4.f3580s
            android.graphics.Rect r2 = r4.w(r2, r1)
            int r2 = r2.left
            android.graphics.Rect r3 = r4.f3580s
            android.graphics.Rect r3 = r4.w(r3, r0)
            int r3 = r3.left
            if (r0 == 0) goto L8e
            if (r2 < r3) goto L8e
            boolean r0 = r4.n()
            goto Lca
        L8e:
            boolean r0 = r1.requestFocus()
            goto Lca
        L93:
            if (r5 != r2) goto Lbf
            android.graphics.Rect r2 = r4.f3580s
            android.graphics.Rect r2 = r4.w(r2, r1)
            int r2 = r2.left
            android.graphics.Rect r3 = r4.f3580s
            android.graphics.Rect r3 = r4.w(r3, r0)
            int r3 = r3.left
            if (r0 == 0) goto Lae
            if (r2 > r3) goto Lae
            boolean r0 = r4.c()
            goto Lca
        Lae:
            boolean r0 = r1.requestFocus()
            goto Lca
        Lb3:
            if (r5 == r3) goto Lc6
            r0 = 1
            if (r5 != r0) goto Lb9
            goto Lc6
        Lb9:
            if (r5 == r2) goto Lc1
            r0 = 2
            if (r5 != r0) goto Lbf
            goto Lc1
        Lbf:
            r0 = 0
            goto Lca
        Lc1:
            boolean r0 = r4.c()
            goto Lca
        Lc6:
            boolean r0 = r4.n()
        Lca:
            if (r0 == 0) goto Ld3
            int r5 = android.view.SoundEffectConstants.getContantForFocusDirection(r5)
            r4.playSoundEffect(r5)
        Ld3:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager.widget.ViewPager.gv(int):boolean");
    }

    public final void hw() {
        if (this.f3567m != 0) {
            ArrayList<View> arrayList = this.f3559g;
            if (arrayList == null) {
                this.f3559g = new ArrayList<>();
            } else {
                arrayList.clear();
            }
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                this.f3559g.add(getChildAt(i));
            }
            Collections.sort(this.f3559g, f3537pq);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0064  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void i4(int r12, float r13, int r14) {
        /*
            r11 = this;
            int r0 = r11.f3592yg
            r1 = 1
            if (r0 <= 0) goto L6b
            int r0 = r11.getScrollX()
            int r2 = r11.getPaddingLeft()
            int r3 = r11.getPaddingRight()
            int r4 = r11.getWidth()
            int r5 = r11.getChildCount()
            r6 = 0
        L1a:
            if (r6 >= r5) goto L6b
            android.view.View r7 = r11.getChildAt(r6)
            android.view.ViewGroup$LayoutParams r8 = r7.getLayoutParams()
            androidx.viewpager.widget.ViewPager$v r8 = (androidx.viewpager.widget.ViewPager.v) r8
            boolean r9 = r8.y
            if (r9 != 0) goto L2b
            goto L68
        L2b:
            int r8 = r8.f3603n3
            r8 = r8 & 7
            if (r8 == r1) goto L4f
            r9 = 3
            if (r8 == r9) goto L49
            r9 = 5
            if (r8 == r9) goto L39
            r8 = r2
            goto L5c
        L39:
            int r8 = r4 - r3
            int r9 = r7.getMeasuredWidth()
            int r8 = r8 - r9
            int r9 = r7.getMeasuredWidth()
            int r3 = r3 + r9
        L45:
            r10 = r8
            r8 = r2
            r2 = r10
            goto L5c
        L49:
            int r8 = r7.getWidth()
            int r8 = r8 + r2
            goto L5c
        L4f:
            int r8 = r7.getMeasuredWidth()
            int r8 = r4 - r8
            int r8 = r8 / 2
            int r8 = java.lang.Math.max(r8, r2)
            goto L45
        L5c:
            int r2 = r2 + r0
            int r9 = r7.getLeft()
            int r2 = r2 - r9
            if (r2 == 0) goto L67
            r7.offsetLeftAndRight(r2)
        L67:
            r2 = r8
        L68:
            int r6 = r6 + 1
            goto L1a
        L6b:
            r11.i9(r12, r13, r14)
            r11.f3541ap = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager.widget.ViewPager.i4(int, float, int):void");
    }

    public final void i9(int i, float f4, int i5) {
        fb fbVar = this.f3565kp;
        if (fbVar != null) {
            fbVar.y(i, f4, i5);
        }
        List<fb> list = this.f3591yc;
        if (list != null) {
            int size = list.size();
            for (int i6 = 0; i6 < size; i6++) {
                fb fbVar2 = this.f3591yc.get(i6);
                if (fbVar2 != null) {
                    fbVar2.y(i, f4, i5);
                }
            }
        }
        fb fbVar3 = this.f3578rb;
        if (fbVar3 != null) {
            fbVar3.y(i, f4, i5);
        }
    }

    public void k5(int i, boolean z2, boolean z3) {
        yt(i, z2, z3, 0);
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0060, code lost:
        if (r9 == r10) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0066, code lost:
        r8 = null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void mg(int r18) {
        /*
            Method dump skipped, instructions count: 615
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager.widget.ViewPager.mg(int):void");
    }

    public gv mt(View view) {
        for (int i = 0; i < this.f3586v.size(); i++) {
            gv gvVar = this.f3586v.get(i);
            if (this.f3554f.isViewFromObject(view, gvVar.y)) {
                return gvVar;
            }
        }
        return null;
    }

    public boolean n() {
        int i = this.f3582t;
        if (i > 0) {
            b(i - 1, true);
            return true;
        }
        return false;
    }

    public void n3(@NonNull a aVar) {
        if (this.f3560g3 == null) {
            this.f3560g3 = new ArrayList();
        }
        this.f3560g3.add(aVar);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f3550e = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        removeCallbacks(this.f3584u0);
        Scroller scroller = this.f3593z;
        if (scroller != null && !scroller.isFinished()) {
            this.f3593z.abortAnimation();
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        int width;
        int i;
        float f4;
        float f6;
        super.onDraw(canvas);
        if (this.f3568n > 0 && this.f3544c != null && this.f3586v.size() > 0 && this.f3554f != null) {
            int scrollX = getScrollX();
            float width2 = getWidth();
            float f9 = this.f3568n / width2;
            int i5 = 0;
            gv gvVar = this.f3586v.get(0);
            float f10 = gvVar.f3599v;
            int size = this.f3586v.size();
            int i6 = gvVar.f3598n3;
            int i8 = this.f3586v.get(size - 1).f3598n3;
            while (i6 < i8) {
                while (true) {
                    i = gvVar.f3598n3;
                    if (i6 <= i || i5 >= size) {
                        break;
                    }
                    i5++;
                    gvVar = this.f3586v.get(i5);
                }
                if (i6 == i) {
                    float f11 = gvVar.f3599v;
                    float f12 = gvVar.f3597gv;
                    f4 = (f11 + f12) * width2;
                    f10 = f11 + f12 + f9;
                } else {
                    float pageWidth = this.f3554f.getPageWidth(i6);
                    f4 = (f10 + pageWidth) * width2;
                    f10 += pageWidth + f9;
                }
                if (this.f3568n + f4 > scrollX) {
                    f6 = f9;
                    this.f3544c.setBounds(Math.round(f4), this.f3548d0, Math.round(this.f3568n + f4), this.f3558fh);
                    this.f3544c.draw(canvas);
                } else {
                    f6 = f9;
                }
                if (f4 <= scrollX + width) {
                    i6++;
                    f9 = f6;
                } else {
                    return;
                }
            }
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        float f4;
        int action = motionEvent.getAction() & 255;
        if (action != 3 && action != 1) {
            if (action != 0) {
                if (this.f3572oz) {
                    return true;
                }
                if (this.f3585ut) {
                    return false;
                }
            }
            if (action != 0) {
                if (action != 2) {
                    if (action == 6) {
                        f3(motionEvent);
                    }
                } else {
                    int i = this.f3589xg;
                    if (i != -1) {
                        int findPointerIndex = motionEvent.findPointerIndex(i);
                        float x2 = motionEvent.getX(findPointerIndex);
                        float f6 = x2 - this.f3553en;
                        float abs = Math.abs(f6);
                        float y2 = motionEvent.getY(findPointerIndex);
                        float abs2 = Math.abs(y2 - this.f3590y5);
                        int i5 = (f6 > 0.0f ? 1 : (f6 == 0.0f ? 0 : -1));
                        if (i5 != 0 && !x4(this.f3553en, f6) && a(this, false, (int) f6, (int) x2, (int) y2)) {
                            this.f3553en = x2;
                            this.f3563jz = y2;
                            this.f3585ut = true;
                            return false;
                        }
                        int i6 = this.f3556f7;
                        if (abs > i6 && abs * 0.5f > abs2) {
                            this.f3572oz = true;
                            ud(true);
                            setScrollState(1);
                            float f9 = this.f3583u;
                            float f10 = this.f3556f7;
                            if (i5 > 0) {
                                f4 = f9 + f10;
                            } else {
                                f4 = f9 - f10;
                            }
                            this.f3553en = f4;
                            this.f3563jz = y2;
                            setScrollingCacheEnabled(true);
                        } else if (abs2 > i6) {
                            this.f3585ut = true;
                        }
                        if (this.f3572oz && fh(x2)) {
                            i4.lc(this);
                        }
                    }
                }
            } else {
                float x3 = motionEvent.getX();
                this.f3583u = x3;
                this.f3553en = x3;
                float y7 = motionEvent.getY();
                this.f3590y5 = y7;
                this.f3563jz = y7;
                this.f3589xg = motionEvent.getPointerId(0);
                this.f3585ut = false;
                this.f3576r = true;
                this.f3593z.computeScrollOffset();
                if (this.f3543bk == 2 && Math.abs(this.f3593z.getFinalX() - this.f3593z.getCurrX()) > this.f3551eb) {
                    this.f3593z.abortAnimation();
                    this.f3570o = false;
                    rz();
                    this.f3572oz = true;
                    ud(true);
                    setScrollState(1);
                } else {
                    fb(false);
                    this.f3572oz = false;
                }
            }
            if (this.f3549dm == null) {
                this.f3549dm = VelocityTracker.obtain();
            }
            this.f3549dm.addMovement(motionEvent);
            return this.f3572oz;
        }
        a8();
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0094  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onLayout(boolean r19, int r20, int r21, int r22, int r23) {
        /*
            Method dump skipped, instructions count: 288
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager.widget.ViewPager.onLayout(boolean, int, int, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00a7  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onMeasure(int r14, int r15) {
        /*
            Method dump skipped, instructions count: 243
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager.widget.ViewPager.onMeasure(int, int):void");
    }

    @Override // android.view.ViewGroup
    public boolean onRequestFocusInDescendants(int i, Rect rect) {
        int i5;
        int i6;
        int i8;
        gv mt2;
        int childCount = getChildCount();
        if ((i & 2) != 0) {
            i6 = childCount;
            i5 = 0;
            i8 = 1;
        } else {
            i5 = childCount - 1;
            i6 = -1;
            i8 = -1;
        }
        while (i5 != i6) {
            View childAt = getChildAt(i5);
            if (childAt.getVisibility() == 0 && (mt2 = mt(childAt)) != null && mt2.f3598n3 == this.f3582t && childAt.requestFocus(i, rect)) {
                return true;
            }
            i5 += i8;
        }
        return false;
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.y());
        PagerAdapter pagerAdapter = this.f3554f;
        if (pagerAdapter != null) {
            pagerAdapter.restoreState(savedState.f3596s, savedState.f3594f);
            k5(savedState.f3595fb, false, true);
            return;
        }
        this.f3587w = savedState.f3595fb;
        this.f3573p = savedState.f3596s;
        this.f3545co = savedState.f3594f;
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f3595fb = this.f3582t;
        PagerAdapter pagerAdapter = this.f3554f;
        if (pagerAdapter != null) {
            savedState.f3596s = pagerAdapter.saveState();
        }
        return savedState;
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i5, int i6, int i8) {
        super.onSizeChanged(i, i5, i6, i8);
        if (i != i6) {
            int i10 = this.f3568n;
            ta(i, i6, i10, i10);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        PagerAdapter pagerAdapter;
        float f4;
        if (this.f3566lc) {
            return true;
        }
        boolean z2 = false;
        if ((motionEvent.getAction() == 0 && motionEvent.getEdgeFlags() != 0) || (pagerAdapter = this.f3554f) == null || pagerAdapter.getCount() == 0) {
            return false;
        }
        if (this.f3549dm == null) {
            this.f3549dm = VelocityTracker.obtain();
        }
        this.f3549dm.addMovement(motionEvent);
        int action = motionEvent.getAction() & 255;
        if (action != 0) {
            if (action != 1) {
                if (action != 2) {
                    if (action != 3) {
                        if (action != 5) {
                            if (action == 6) {
                                f3(motionEvent);
                                this.f3553en = motionEvent.getX(motionEvent.findPointerIndex(this.f3589xg));
                            }
                        } else {
                            int actionIndex = motionEvent.getActionIndex();
                            this.f3553en = motionEvent.getX(actionIndex);
                            this.f3589xg = motionEvent.getPointerId(actionIndex);
                        }
                    } else if (this.f3572oz) {
                        x(this.f3582t, true, 0, false);
                        z2 = a8();
                    }
                } else {
                    if (!this.f3572oz) {
                        int findPointerIndex = motionEvent.findPointerIndex(this.f3589xg);
                        if (findPointerIndex == -1) {
                            z2 = a8();
                        } else {
                            float x2 = motionEvent.getX(findPointerIndex);
                            float abs = Math.abs(x2 - this.f3553en);
                            float y2 = motionEvent.getY(findPointerIndex);
                            float abs2 = Math.abs(y2 - this.f3563jz);
                            if (abs > this.f3556f7 && abs > abs2) {
                                this.f3572oz = true;
                                ud(true);
                                float f6 = this.f3583u;
                                if (x2 - f6 > 0.0f) {
                                    f4 = f6 + this.f3556f7;
                                } else {
                                    f4 = f6 - this.f3556f7;
                                }
                                this.f3553en = f4;
                                this.f3563jz = y2;
                                setScrollState(1);
                                setScrollingCacheEnabled(true);
                                ViewParent parent = getParent();
                                if (parent != null) {
                                    parent.requestDisallowInterceptTouchEvent(true);
                                }
                            }
                        }
                    }
                    if (this.f3572oz) {
                        z2 = fh(motionEvent.getX(motionEvent.findPointerIndex(this.f3589xg)));
                    }
                }
            } else if (this.f3572oz) {
                VelocityTracker velocityTracker = this.f3549dm;
                velocityTracker.computeCurrentVelocity(1000, this.f3571o4);
                int xVelocity = (int) velocityTracker.getXVelocity(this.f3589xg);
                this.f3570o = true;
                int clientWidth = getClientWidth();
                int scrollX = getScrollX();
                gv co2 = co();
                float f9 = clientWidth;
                yt(c5(co2.f3598n3, ((scrollX / f9) - co2.f3599v) / (co2.f3597gv + (this.f3568n / f9)), xVelocity, (int) (motionEvent.getX(motionEvent.findPointerIndex(this.f3589xg)) - this.f3583u)), true, true, xVelocity);
                z2 = a8();
            }
        } else {
            this.f3593z.abortAnimation();
            this.f3570o = false;
            rz();
            float x3 = motionEvent.getX();
            this.f3583u = x3;
            this.f3553en = x3;
            float y7 = motionEvent.getY();
            this.f3590y5 = y7;
            this.f3563jz = y7;
            this.f3589xg = motionEvent.getPointerId(0);
        }
        if (z2) {
            i4.lc(this);
        }
        return true;
    }

    public gv p(View view) {
        while (true) {
            ViewParent parent = view.getParent();
            if (parent != this) {
                if (parent != null && (parent instanceof View)) {
                    view = (View) parent;
                } else {
                    return null;
                }
            } else {
                return mt(view);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        if (this.f3562j5) {
            removeViewInLayout(view);
        } else {
            super.removeView(view);
        }
    }

    public void rz() {
        mg(this.f3582t);
    }

    public void s() {
        boolean z2;
        int count = this.f3554f.getCount();
        this.y = count;
        if (this.f3586v.size() < (this.f3561j * 2) + 1 && this.f3586v.size() < count) {
            z2 = true;
        } else {
            z2 = false;
        }
        int i = this.f3582t;
        int i5 = 0;
        boolean z3 = false;
        while (i5 < this.f3586v.size()) {
            gv gvVar = this.f3586v.get(i5);
            int itemPosition = this.f3554f.getItemPosition(gvVar.y);
            if (itemPosition != -1) {
                if (itemPosition == -2) {
                    this.f3586v.remove(i5);
                    i5--;
                    if (!z3) {
                        this.f3554f.startUpdate((ViewGroup) this);
                        z3 = true;
                    }
                    this.f3554f.destroyItem((ViewGroup) this, gvVar.f3598n3, gvVar.y);
                    int i6 = this.f3582t;
                    if (i6 == gvVar.f3598n3) {
                        i = Math.max(0, Math.min(i6, count - 1));
                    }
                } else {
                    int i8 = gvVar.f3598n3;
                    if (i8 != itemPosition) {
                        if (i8 == this.f3582t) {
                            i = itemPosition;
                        }
                        gvVar.f3598n3 = itemPosition;
                    }
                }
                z2 = true;
            }
            i5++;
        }
        if (z3) {
            this.f3554f.finishUpdate((ViewGroup) this);
        }
        Collections.sort(this.f3586v, f3539tg);
        if (z2) {
            int childCount = getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                v vVar = (v) getChildAt(i10).getLayoutParams();
                if (!vVar.y) {
                    vVar.f3605zn = 0.0f;
                }
            }
            k5(i, false, true);
            requestLayout();
        }
    }

    public void setAdapter(@Nullable PagerAdapter pagerAdapter) {
        PagerAdapter pagerAdapter2 = this.f3554f;
        if (pagerAdapter2 != null) {
            pagerAdapter2.setViewPagerObserver(null);
            this.f3554f.startUpdate((ViewGroup) this);
            for (int i = 0; i < this.f3586v.size(); i++) {
                gv gvVar = this.f3586v.get(i);
                this.f3554f.destroyItem((ViewGroup) this, gvVar.f3598n3, gvVar.y);
            }
            this.f3554f.finishUpdate((ViewGroup) this);
            this.f3586v.clear();
            d();
            this.f3582t = 0;
            scrollTo(0, 0);
        }
        PagerAdapter pagerAdapter3 = this.f3554f;
        this.f3554f = pagerAdapter;
        this.y = 0;
        if (pagerAdapter != null) {
            if (this.f3555f3 == null) {
                this.f3555f3 = new s();
            }
            this.f3554f.setViewPagerObserver(this.f3555f3);
            this.f3570o = false;
            boolean z2 = this.f3550e;
            this.f3550e = true;
            this.y = this.f3554f.getCount();
            if (this.f3587w >= 0) {
                this.f3554f.restoreState(this.f3573p, this.f3545co);
                k5(this.f3587w, false, true);
                this.f3587w = -1;
                this.f3573p = null;
                this.f3545co = null;
            } else if (!z2) {
                rz();
            } else {
                requestLayout();
            }
        }
        List<a> list = this.f3560g3;
        if (list != null && !list.isEmpty()) {
            int size = this.f3560g3.size();
            for (int i5 = 0; i5 < size; i5++) {
                this.f3560g3.get(i5).y(this, pagerAdapter3, pagerAdapter);
            }
        }
    }

    public void setCurrentItem(int i) {
        this.f3570o = false;
        k5(i, !this.f3550e, false);
    }

    public void setOffscreenPageLimit(int i) {
        if (i < 1) {
            Log.w("ViewPager", "Requested offscreen page limit " + i + " too small; defaulting to 1");
            i = 1;
        }
        if (i != this.f3561j) {
            this.f3561j = i;
            rz();
        }
    }

    @Deprecated
    public void setOnPageChangeListener(fb fbVar) {
        this.f3565kp = fbVar;
    }

    public void setPageMargin(int i) {
        int i5 = this.f3568n;
        this.f3568n = i;
        int width = getWidth();
        ta(width, width, i, i5);
        requestLayout();
    }

    public void setPageMarginDrawable(@Nullable Drawable drawable) {
        this.f3544c = drawable;
        if (drawable != null) {
            refreshDrawableState();
        }
        setWillNotDraw(drawable == null);
        invalidate();
    }

    public void setScrollState(int i) {
        if (this.f3543bk == i) {
            return;
        }
        this.f3543bk = i;
        t(i);
    }

    public final void t(int i) {
        fb fbVar = this.f3565kp;
        if (fbVar != null) {
            fbVar.n3(i);
        }
        List<fb> list = this.f3591yc;
        if (list != null) {
            int size = list.size();
            for (int i5 = 0; i5 < size; i5++) {
                fb fbVar2 = this.f3591yc.get(i5);
                if (fbVar2 != null) {
                    fbVar2.n3(i);
                }
            }
        }
        fb fbVar3 = this.f3578rb;
        if (fbVar3 != null) {
            fbVar3.n3(i);
        }
    }

    public final void ta(int i, int i5, int i6, int i8) {
        float f4;
        if (i5 > 0 && !this.f3586v.isEmpty()) {
            if (!this.f3593z.isFinished()) {
                this.f3593z.setFinalX(getCurrentItem() * getClientWidth());
                return;
            }
            scrollTo((int) ((getScrollX() / (((i5 - getPaddingLeft()) - getPaddingRight()) + i8)) * (((i - getPaddingLeft()) - getPaddingRight()) + i6)), getScrollY());
            return;
        }
        gv z2 = z(this.f3582t);
        if (z2 != null) {
            f4 = Math.min(z2.f3599v, this.f3552ej);
        } else {
            f4 = 0.0f;
        }
        int paddingLeft = (int) (f4 * ((i - getPaddingLeft()) - getPaddingRight()));
        if (paddingLeft != getScrollX()) {
            fb(false);
            scrollTo(paddingLeft, getScrollY());
        }
    }

    public float tl(float f4) {
        return (float) Math.sin((f4 - 0.5f) * 0.47123894f);
    }

    public final void ud(boolean z2) {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z2);
        }
    }

    public final void v(gv gvVar, int i, gv gvVar2) {
        float f4;
        float f6;
        float f9;
        int i5;
        int i6;
        gv gvVar3;
        gv gvVar4;
        int count = this.f3554f.getCount();
        int clientWidth = getClientWidth();
        if (clientWidth > 0) {
            f4 = this.f3568n / clientWidth;
        } else {
            f4 = 0.0f;
        }
        if (gvVar2 != null) {
            int i8 = gvVar2.f3598n3;
            int i10 = gvVar.f3598n3;
            if (i8 < i10) {
                float f10 = gvVar2.f3599v + gvVar2.f3597gv + f4;
                int i11 = i8 + 1;
                int i12 = 0;
                while (i11 <= gvVar.f3598n3 && i12 < this.f3586v.size()) {
                    gv gvVar5 = this.f3586v.get(i12);
                    while (true) {
                        gvVar4 = gvVar5;
                        if (i11 <= gvVar4.f3598n3 || i12 >= this.f3586v.size() - 1) {
                            break;
                        }
                        i12++;
                        gvVar5 = this.f3586v.get(i12);
                    }
                    while (i11 < gvVar4.f3598n3) {
                        f10 += this.f3554f.getPageWidth(i11) + f4;
                        i11++;
                    }
                    gvVar4.f3599v = f10;
                    f10 += gvVar4.f3597gv + f4;
                    i11++;
                }
            } else if (i8 > i10) {
                int size = this.f3586v.size() - 1;
                float f11 = gvVar2.f3599v;
                while (true) {
                    i8--;
                    if (i8 < gvVar.f3598n3 || size < 0) {
                        break;
                    }
                    gv gvVar6 = this.f3586v.get(size);
                    while (true) {
                        gvVar3 = gvVar6;
                        if (i8 >= gvVar3.f3598n3 || size <= 0) {
                            break;
                        }
                        size--;
                        gvVar6 = this.f3586v.get(size);
                    }
                    while (i8 > gvVar3.f3598n3) {
                        f11 -= this.f3554f.getPageWidth(i8) + f4;
                        i8--;
                    }
                    f11 -= gvVar3.f3597gv + f4;
                    gvVar3.f3599v = f11;
                }
            }
        }
        int size2 = this.f3586v.size();
        float f12 = gvVar.f3599v;
        int i13 = gvVar.f3598n3;
        int i14 = i13 - 1;
        if (i13 == 0) {
            f6 = f12;
        } else {
            f6 = -3.4028235E38f;
        }
        this.f3547d = f6;
        int i15 = count - 1;
        if (i13 == i15) {
            f9 = (gvVar.f3597gv + f12) - 1.0f;
        } else {
            f9 = Float.MAX_VALUE;
        }
        this.f3552ej = f9;
        int i16 = i - 1;
        while (i16 >= 0) {
            gv gvVar7 = this.f3586v.get(i16);
            while (true) {
                i6 = gvVar7.f3598n3;
                if (i14 <= i6) {
                    break;
                }
                f12 -= this.f3554f.getPageWidth(i14) + f4;
                i14--;
            }
            f12 -= gvVar7.f3597gv + f4;
            gvVar7.f3599v = f12;
            if (i6 == 0) {
                this.f3547d = f12;
            }
            i16--;
            i14--;
        }
        float f13 = gvVar.f3599v + gvVar.f3597gv + f4;
        int i17 = gvVar.f3598n3 + 1;
        int i18 = i + 1;
        while (i18 < size2) {
            gv gvVar8 = this.f3586v.get(i18);
            while (true) {
                i5 = gvVar8.f3598n3;
                if (i17 >= i5) {
                    break;
                }
                f13 += this.f3554f.getPageWidth(i17) + f4;
                i17++;
            }
            if (i5 == i15) {
                this.f3552ej = (gvVar8.f3597gv + f13) - 1.0f;
            }
            gvVar8.f3599v = f13;
            f13 += gvVar8.f3597gv + f4;
            i18++;
            i17++;
        }
        this.f3581s8 = false;
    }

    @Override // android.view.View
    public boolean verifyDrawable(Drawable drawable) {
        if (!super.verifyDrawable(drawable) && drawable != this.f3544c) {
            return false;
        }
        return true;
    }

    public void vl(int i, int i5, int i6) {
        int scrollX;
        int abs;
        if (getChildCount() == 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        Scroller scroller = this.f3593z;
        if (scroller != null && !scroller.isFinished()) {
            if (this.f3576r) {
                scrollX = this.f3593z.getCurrX();
            } else {
                scrollX = this.f3593z.getStartX();
            }
            this.f3593z.abortAnimation();
            setScrollingCacheEnabled(false);
        } else {
            scrollX = getScrollX();
        }
        int i8 = scrollX;
        int scrollY = getScrollY();
        int i10 = i - i8;
        int i11 = i5 - scrollY;
        if (i10 == 0 && i11 == 0) {
            fb(false);
            rz();
            setScrollState(0);
            return;
        }
        setScrollingCacheEnabled(true);
        setScrollState(2);
        int clientWidth = getClientWidth();
        int i12 = clientWidth / 2;
        float f4 = clientWidth;
        float f6 = i12;
        float tl2 = f6 + (tl(Math.min(1.0f, (Math.abs(i10) * 1.0f) / f4)) * f6);
        int abs2 = Math.abs(i6);
        if (abs2 > 0) {
            abs = Math.round(Math.abs(tl2 / abs2) * 1000.0f) * 4;
        } else {
            abs = (int) (((Math.abs(i10) / ((f4 * this.f3554f.getPageWidth(this.f3582t)) + this.f3568n)) + 1.0f) * 100.0f);
        }
        int min = Math.min(abs, 600);
        this.f3576r = false;
        this.f3593z.startScroll(i8, scrollY, i10, i11, min);
        i4.lc(this);
    }

    public final Rect w(Rect rect, View view) {
        if (rect == null) {
            rect = new Rect();
        }
        if (view == null) {
            rect.set(0, 0, 0, 0);
            return rect;
        }
        rect.left = view.getLeft();
        rect.right = view.getRight();
        rect.top = view.getTop();
        rect.bottom = view.getBottom();
        ViewParent parent = view.getParent();
        while ((parent instanceof ViewGroup) && parent != this) {
            ViewGroup viewGroup = (ViewGroup) parent;
            rect.left += viewGroup.getLeft();
            rect.right += viewGroup.getRight();
            rect.top += viewGroup.getTop();
            rect.bottom += viewGroup.getBottom();
            parent = viewGroup.getParent();
        }
        return rect;
    }

    public final void wz() {
        this.f3572oz = false;
        this.f3585ut = false;
        VelocityTracker velocityTracker = this.f3549dm;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f3549dm = null;
        }
    }

    public final void x(int i, boolean z2, int i5, boolean z3) {
        int i6;
        gv z4 = z(i);
        if (z4 != null) {
            i6 = (int) (getClientWidth() * Math.max(this.f3547d, Math.min(z4.f3599v, this.f3552ej)));
        } else {
            i6 = 0;
        }
        if (z2) {
            vl(i6, 0, i5);
            if (z3) {
                f(i);
                return;
            }
            return;
        }
        if (z3) {
            f(i);
        }
        fb(false);
        scrollTo(i6, 0);
        d0(i6);
    }

    public final boolean x4(float f4, float f6) {
        if ((f4 < this.f3564k && f6 > 0.0f) || (f4 > getWidth() - this.f3564k && f6 < 0.0f)) {
            return true;
        }
        return false;
    }

    public boolean xc(@NonNull KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0) {
            int keyCode = keyEvent.getKeyCode();
            if (keyCode != 21) {
                if (keyCode != 22) {
                    if (keyCode == 61) {
                        if (keyEvent.hasNoModifiers()) {
                            return gv(2);
                        }
                        if (keyEvent.hasModifiers(1)) {
                            return gv(1);
                        }
                    }
                } else if (keyEvent.hasModifiers(2)) {
                    return c();
                } else {
                    return gv(66);
                }
            } else if (keyEvent.hasModifiers(2)) {
                return n();
            } else {
                return gv(17);
            }
        }
        return false;
    }

    public gv y(int i, int i5) {
        gv gvVar = new gv();
        gvVar.f3598n3 = i;
        gvVar.y = this.f3554f.instantiateItem((ViewGroup) this, i);
        gvVar.f3597gv = this.f3554f.getPageWidth(i);
        if (i5 >= 0 && i5 < this.f3586v.size()) {
            this.f3586v.add(i5, gvVar);
        } else {
            this.f3586v.add(gvVar);
        }
        return gvVar;
    }

    public void yt(int i, boolean z2, boolean z3, int i5) {
        PagerAdapter pagerAdapter = this.f3554f;
        boolean z4 = false;
        if (pagerAdapter != null && pagerAdapter.getCount() > 0) {
            if (!z3 && this.f3582t == i && this.f3586v.size() != 0) {
                setScrollingCacheEnabled(false);
                return;
            }
            if (i < 0) {
                i = 0;
            } else if (i >= this.f3554f.getCount()) {
                i = this.f3554f.getCount() - 1;
            }
            int i6 = this.f3561j;
            int i8 = this.f3582t;
            if (i > i8 + i6 || i < i8 - i6) {
                for (int i10 = 0; i10 < this.f3586v.size(); i10++) {
                    this.f3586v.get(i10).f3600zn = true;
                }
            }
            if (this.f3582t != i) {
                z4 = true;
            }
            if (this.f3550e) {
                this.f3582t = i;
                if (z4) {
                    f(i);
                }
                requestLayout();
                return;
            }
            mg(i);
            x(i, z2, i5, z4);
            return;
        }
        setScrollingCacheEnabled(false);
    }

    public gv z(int i) {
        for (int i5 = 0; i5 < this.f3586v.size(); i5++) {
            gv gvVar = this.f3586v.get(i5);
            if (gvVar.f3598n3 == i) {
                return gvVar;
            }
        }
        return null;
    }

    public void z6(@NonNull a aVar) {
        List<a> list = this.f3560g3;
        if (list != null) {
            list.remove(aVar);
        }
    }

    public void zn(@NonNull fb fbVar) {
        if (this.f3591yc == null) {
            this.f3591yc = new ArrayList();
        }
        this.f3591yc.add(fbVar);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new v(getContext(), attributeSet);
    }

    public void setPageMarginDrawable(int i) {
        setPageMarginDrawable(mg.y.v(getContext(), i));
    }
}
