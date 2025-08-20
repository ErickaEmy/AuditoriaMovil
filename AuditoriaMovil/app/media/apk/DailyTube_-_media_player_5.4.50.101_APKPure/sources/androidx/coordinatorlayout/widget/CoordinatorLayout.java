package androidx.coordinatorlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.R$attr;
import androidx.coordinatorlayout.R$style;
import androidx.coordinatorlayout.R$styleable;
import androidx.customview.view.AbsSavedState;
import com.uv.v7.R;
import hw.ej;
import hw.i4;
import hw.tl;
import hw.w;
import hw.wz;
import hw.xc;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class CoordinatorLayout extends ViewGroup implements tl, wz {

    /* renamed from: j  reason: collision with root package name */
    public static final Comparator<View> f2047j;

    /* renamed from: j5  reason: collision with root package name */
    public static final String f2048j5;

    /* renamed from: o  reason: collision with root package name */
    public static final ThreadLocal<Map<String, Constructor<zn>>> f2049o;

    /* renamed from: oz  reason: collision with root package name */
    public static final vl.v<Rect> f2050oz;

    /* renamed from: qn  reason: collision with root package name */
    public static final Class<?>[] f2051qn;

    /* renamed from: b  reason: collision with root package name */
    public final xc f2052b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f2053c;

    /* renamed from: co  reason: collision with root package name */
    public boolean f2054co;

    /* renamed from: d  reason: collision with root package name */
    public Drawable f2055d;

    /* renamed from: d0  reason: collision with root package name */
    public ej f2056d0;

    /* renamed from: ej  reason: collision with root package name */
    public ViewGroup.OnHierarchyChangeListener f2057ej;

    /* renamed from: f  reason: collision with root package name */
    public Paint f2058f;

    /* renamed from: f3  reason: collision with root package name */
    public View f2059f3;

    /* renamed from: fb  reason: collision with root package name */
    public final List<View> f2060fb;

    /* renamed from: fh  reason: collision with root package name */
    public boolean f2061fh;

    /* renamed from: n  reason: collision with root package name */
    public fb f2062n;

    /* renamed from: p  reason: collision with root package name */
    public boolean f2063p;

    /* renamed from: r  reason: collision with root package name */
    public View f2064r;

    /* renamed from: s  reason: collision with root package name */
    public final List<View> f2065s;

    /* renamed from: t  reason: collision with root package name */
    public final int[] f2066t;

    /* renamed from: v  reason: collision with root package name */
    public final fh.y<View> f2067v;

    /* renamed from: w  reason: collision with root package name */
    public final int[] f2068w;

    /* renamed from: x  reason: collision with root package name */
    public w f2069x;
    public final List<View> y;

    /* renamed from: z  reason: collision with root package name */
    public int[] f2070z;

    /* loaded from: classes.dex */
    public class fb implements ViewTreeObserver.OnPreDrawListener {
        public fb() {
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            CoordinatorLayout.this.ej(0);
            return true;
        }
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Deprecated
    /* loaded from: classes.dex */
    public @interface gv {
        Class<? extends zn> value();
    }

    /* loaded from: classes.dex */
    public interface n3 {
        @NonNull
        zn getBehavior();
    }

    /* loaded from: classes.dex */
    public static class s implements Comparator<View> {
        @Override // java.util.Comparator
        /* renamed from: y */
        public int compare(View view, View view2) {
            float j52 = i4.j5(view);
            float j53 = i4.j5(view2);
            if (j52 > j53) {
                return -1;
            }
            if (j52 < j53) {
                return 1;
            }
            return 0;
        }
    }

    /* loaded from: classes.dex */
    public class v implements ViewGroup.OnHierarchyChangeListener {
        public v() {
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewAdded(View view, View view2) {
            ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = CoordinatorLayout.this.f2057ej;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewAdded(view, view2);
            }
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewRemoved(View view, View view2) {
            CoordinatorLayout.this.ej(2);
            ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = CoordinatorLayout.this.f2057ej;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewRemoved(view, view2);
            }
        }
    }

    /* loaded from: classes.dex */
    public class y implements w {
        public y() {
        }

        @Override // hw.w
        public ej y(View view, ej ejVar) {
            return CoordinatorLayout.this.q9(ejVar);
        }
    }

    /* loaded from: classes.dex */
    public static abstract class zn<V extends View> {
        public zn() {
        }

        @Deprecated
        public boolean c(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v2, @NonNull View view, @NonNull View view2, int i) {
            return false;
        }

        public void c5(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v2, @NonNull View view) {
        }

        @Deprecated
        public void co(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v2, @NonNull View view, int i, int i5, int i6, int i8, int i10) {
            if (i10 == 0) {
                mt(coordinatorLayout, v2, view, i, i5, i6, i8);
            }
        }

        public boolean d0(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v2, @NonNull View view, @NonNull View view2, int i, int i5) {
            if (i5 == 0) {
                return c(coordinatorLayout, v2, view, view2, i);
            }
            return false;
        }

        public boolean f(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v2, @NonNull MotionEvent motionEvent) {
            return false;
        }

        public void f3(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v2, @NonNull Parcelable parcelable) {
        }

        public void fb(@NonNull a aVar) {
        }

        @Deprecated
        public void fh(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v2, @NonNull View view) {
        }

        public float gv(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v2) {
            return 0.0f;
        }

        public boolean i4(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v2, @NonNull Rect rect, boolean z2) {
            return false;
        }

        public void i9() {
        }

        public boolean mg(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v2, @NonNull MotionEvent motionEvent) {
            return false;
        }

        @Deprecated
        public void mt(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v2, @NonNull View view, int i, int i5, int i6, int i8) {
        }

        @Nullable
        public Parcelable n(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v2) {
            return View.BaseSavedState.EMPTY_STATE;
        }

        public boolean n3(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v2, @NonNull Rect rect) {
            return false;
        }

        public void p(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v2, @NonNull View view, int i, int i5, @NonNull int[] iArr, int i6) {
            if (i6 == 0) {
                w(coordinatorLayout, v2, view, i, i5, iArr);
            }
        }

        @Deprecated
        public void r(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v2, @NonNull View view, @NonNull View view2, int i) {
        }

        public void rz(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v2, @NonNull View view, int i) {
            if (i == 0) {
                fh(coordinatorLayout, v2, view);
            }
        }

        public boolean s(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v2, @NonNull View view) {
            return false;
        }

        public boolean t(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v2, int i) {
            return false;
        }

        public boolean tl(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v2, int i, int i5, int i6, int i8) {
            return false;
        }

        public boolean v(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v2, @NonNull View view) {
            return false;
        }

        @Deprecated
        public void w(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v2, @NonNull View view, int i, int i5, @NonNull int[] iArr) {
        }

        public boolean wz(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v2, @NonNull View view, float f4, float f6, boolean z2) {
            return false;
        }

        public void x4(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v2, @NonNull View view, @NonNull View view2, int i, int i5) {
            if (i5 == 0) {
                r(coordinatorLayout, v2, view, view2, i);
            }
        }

        public boolean xc(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v2, @NonNull View view, float f4, float f6) {
            return false;
        }

        public boolean y(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v2) {
            if (gv(coordinatorLayout, v2) > 0.0f) {
                return true;
            }
            return false;
        }

        public void z(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v2, @NonNull View view, int i, int i5, int i6, int i8, int i10, @NonNull int[] iArr) {
            iArr[0] = iArr[0] + i6;
            iArr[1] = iArr[1] + i8;
            co(coordinatorLayout, v2, view, i, i5, i6, i8, i10);
        }

        public int zn(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v2) {
            return -16777216;
        }

        public zn(Context context, AttributeSet attributeSet) {
        }

        @NonNull
        public ej a(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v2, @NonNull ej ejVar) {
            return ejVar;
        }
    }

    static {
        String str;
        Package r0 = CoordinatorLayout.class.getPackage();
        if (r0 != null) {
            str = r0.getName();
        } else {
            str = null;
        }
        f2048j5 = str;
        f2047j = new s();
        f2051qn = new Class[]{Context.class, AttributeSet.class};
        f2049o = new ThreadLocal<>();
        f2050oz = new vl.fb(12);
    }

    public CoordinatorLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.g3);
    }

    public static int j(int i) {
        if (i == 0) {
            return 8388661;
        }
        return i;
    }

    public static int o(int i) {
        if ((i & 7) == 0) {
            i |= 8388611;
        }
        return (i & R.styleable.AppCompatTheme_toolbarNavigationButtonStyle) == 0 ? i | 48 : i;
    }

    public static int qn(int i) {
        if (i == 0) {
            return 17;
        }
        return i;
    }

    public static void vl(@NonNull Rect rect) {
        rect.setEmpty();
        f2050oz.y(rect);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static zn x(Context context, AttributeSet attributeSet, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.startsWith(".")) {
            str = context.getPackageName() + str;
        } else if (str.indexOf(46) < 0) {
            String str2 = f2048j5;
            if (!TextUtils.isEmpty(str2)) {
                str = str2 + '.' + str;
            }
        }
        try {
            ThreadLocal<Map<String, Constructor<zn>>> threadLocal = f2049o;
            Map<String, Constructor<zn>> map = threadLocal.get();
            if (map == null) {
                map = new HashMap<>();
                threadLocal.set(map);
            }
            Constructor<zn> constructor = map.get(str);
            if (constructor == null) {
                constructor = Class.forName(str, false, context.getClassLoader()).getConstructor(f2051qn);
                constructor.setAccessible(true);
                map.put(str, constructor);
            }
            return constructor.newInstance(context, attributeSet);
        } catch (Exception e2) {
            throw new RuntimeException("Could not inflate Behavior subclass " + str, e2);
        }
    }

    @NonNull
    public static Rect y() {
        Rect n32 = f2050oz.n3();
        if (n32 == null) {
            return new Rect();
        }
        return n32;
    }

    private static int zn(int i, int i5, int i6) {
        return i < i5 ? i5 : i > i6 ? i6 : i;
    }

    public void a(@NonNull View view) {
        List fb2 = this.f2067v.fb(view);
        if (fb2 != null && !fb2.isEmpty()) {
            for (int i = 0; i < fb2.size(); i++) {
                View view2 = (View) fb2.get(i);
                zn a2 = ((a) view2.getLayoutParams()).a();
                if (a2 != null) {
                    a2.s(this, view2, view);
                }
            }
        }
    }

    public void a8(View view, int i, int i5, int i6, int i8) {
        measureChildWithMargins(view, i, i5, i6, i8);
    }

    public final boolean b(MotionEvent motionEvent, int i) {
        int actionMasked = motionEvent.getActionMasked();
        List<View> list = this.f2060fb;
        c(list);
        int size = list.size();
        MotionEvent motionEvent2 = null;
        boolean z2 = false;
        boolean z3 = false;
        for (int i5 = 0; i5 < size; i5++) {
            View view = list.get(i5);
            a aVar = (a) view.getLayoutParams();
            zn a2 = aVar.a();
            if ((z2 || z3) && actionMasked != 0) {
                if (a2 != null) {
                    if (motionEvent2 == null) {
                        long uptimeMillis = SystemClock.uptimeMillis();
                        motionEvent2 = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                    }
                    if (i != 0) {
                        if (i == 1) {
                            a2.mg(this, view, motionEvent2);
                        }
                    } else {
                        a2.f(this, view, motionEvent2);
                    }
                }
            } else {
                if (!z2 && a2 != null) {
                    if (i != 0) {
                        if (i == 1) {
                            z2 = a2.mg(this, view, motionEvent);
                        }
                    } else {
                        z2 = a2.f(this, view, motionEvent);
                    }
                    if (z2) {
                        this.f2064r = view;
                    }
                }
                boolean zn2 = aVar.zn();
                boolean c52 = aVar.c5(this, view);
                if (c52 && !zn2) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (c52 && !z3) {
                    break;
                }
            }
        }
        list.clear();
        return z2;
    }

    public final void c(List<View> list) {
        int i;
        list.clear();
        boolean isChildrenDrawingOrderEnabled = isChildrenDrawingOrderEnabled();
        int childCount = getChildCount();
        for (int i5 = childCount - 1; i5 >= 0; i5--) {
            if (isChildrenDrawingOrderEnabled) {
                i = getChildDrawingOrder(childCount, i5);
            } else {
                i = i5;
            }
            list.add(getChildAt(i));
        }
        Comparator<View> comparator = f2047j;
        if (comparator != null) {
            Collections.sort(list, comparator);
        }
    }

    @Override // hw.tl
    public void c5(View view, View view2, int i, int i5) {
        zn a2;
        this.f2052b.zn(view, view2, i, i5);
        this.f2059f3 = view2;
        int childCount = getChildCount();
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            a aVar = (a) childAt.getLayoutParams();
            if (aVar.i9(i5) && (a2 = aVar.a()) != null) {
                a2.x4(this, childAt, view, view2, i, i5);
            }
        }
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if ((layoutParams instanceof a) && super.checkLayoutParams(layoutParams)) {
            return true;
        }
        return false;
    }

    @NonNull
    public List<View> co(@NonNull View view) {
        List fb2 = this.f2067v.fb(view);
        this.f2065s.clear();
        if (fb2 != null) {
            this.f2065s.addAll(fb2);
        }
        return this.f2065s;
    }

    public final void d(View view, Rect rect, int i) {
        boolean z2;
        boolean z3;
        int width;
        int i5;
        int i6;
        int i8;
        int height;
        int i10;
        int i11;
        int i12;
        if (i4.q9(view) && view.getWidth() > 0 && view.getHeight() > 0) {
            a aVar = (a) view.getLayoutParams();
            zn a2 = aVar.a();
            Rect y2 = y();
            Rect y7 = y();
            y7.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            if (a2 != null && a2.n3(this, view, y2)) {
                if (!y7.contains(y2)) {
                    throw new IllegalArgumentException("Rect should be within the child's bounds. Rect:" + y2.toShortString() + " | Bounds:" + y7.toShortString());
                }
            } else {
                y2.set(y7);
            }
            vl(y7);
            if (y2.isEmpty()) {
                vl(y2);
                return;
            }
            int n32 = hw.v.n3(aVar.f2081s, i);
            boolean z4 = true;
            if ((n32 & 48) == 48 && (i11 = (y2.top - ((ViewGroup.MarginLayoutParams) aVar).topMargin) - aVar.f2077i9) < (i12 = rect.top)) {
                ut(view, i12 - i11);
                z2 = true;
            } else {
                z2 = false;
            }
            if ((n32 & 80) == 80 && (height = ((getHeight() - y2.bottom) - ((ViewGroup.MarginLayoutParams) aVar).bottomMargin) + aVar.f2077i9) < (i10 = rect.bottom)) {
                ut(view, height - i10);
                z2 = true;
            }
            if (!z2) {
                ut(view, 0);
            }
            if ((n32 & 3) == 3 && (i6 = (y2.left - ((ViewGroup.MarginLayoutParams) aVar).leftMargin) - aVar.f2073c5) < (i8 = rect.left)) {
                oz(view, i8 - i6);
                z3 = true;
            } else {
                z3 = false;
            }
            if ((n32 & 5) == 5 && (width = ((getWidth() - y2.right) - ((ViewGroup.MarginLayoutParams) aVar).rightMargin) + aVar.f2073c5) < (i5 = rect.right)) {
                oz(view, width - i5);
            } else {
                z4 = z3;
            }
            if (!z4) {
                oz(view, 0);
            }
            vl(y2);
        }
    }

    public final boolean d0(View view) {
        return this.f2067v.i9(view);
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas canvas, View view, long j2) {
        a aVar = (a) view.getLayoutParams();
        zn znVar = aVar.y;
        if (znVar != null) {
            float gv2 = znVar.gv(this, view);
            if (gv2 > 0.0f) {
                if (this.f2058f == null) {
                    this.f2058f = new Paint();
                }
                this.f2058f.setColor(aVar.y.zn(this, view));
                this.f2058f.setAlpha(zn(Math.round(gv2 * 255.0f), 0, 255));
                int save = canvas.save();
                if (view.isOpaque()) {
                    canvas.clipRect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom(), Region.Op.DIFFERENCE);
                }
                canvas.drawRect(getPaddingLeft(), getPaddingTop(), getWidth() - getPaddingRight(), getHeight() - getPaddingBottom(), this.f2058f);
                canvas.restoreToCount(save);
            }
        }
        return super.drawChild(canvas, view, j2);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        boolean z2;
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.f2055d;
        if (drawable != null && drawable.isStateful()) {
            z2 = drawable.setState(drawableState);
        } else {
            z2 = false;
        }
        if (z2) {
            invalidate();
        }
    }

    public final void ej(int i) {
        boolean z2;
        int ta2 = i4.ta(this);
        int size = this.y.size();
        Rect y2 = y();
        Rect y7 = y();
        Rect y8 = y();
        for (int i5 = 0; i5 < size; i5++) {
            View view = this.y.get(i5);
            a aVar = (a) view.getLayoutParams();
            if (i != 0 || view.getVisibility() != 8) {
                for (int i6 = 0; i6 < i5; i6++) {
                    if (aVar.f2082t == this.y.get(i6)) {
                        z6(view, ta2);
                    }
                }
                p(view, true, y7);
                if (aVar.f2075fb != 0 && !y7.isEmpty()) {
                    int n32 = hw.v.n3(aVar.f2075fb, ta2);
                    int i8 = n32 & R.styleable.AppCompatTheme_toolbarNavigationButtonStyle;
                    if (i8 != 48) {
                        if (i8 == 80) {
                            y2.bottom = Math.max(y2.bottom, getHeight() - y7.top);
                        }
                    } else {
                        y2.top = Math.max(y2.top, y7.bottom);
                    }
                    int i10 = n32 & 7;
                    if (i10 != 3) {
                        if (i10 == 5) {
                            y2.right = Math.max(y2.right, getWidth() - y7.left);
                        }
                    } else {
                        y2.left = Math.max(y2.left, y7.right);
                    }
                }
                if (aVar.f2081s != 0 && view.getVisibility() == 0) {
                    d(view, y2, ta2);
                }
                if (i != 2) {
                    f3(view, y8);
                    if (!y8.equals(y7)) {
                        yt(view, y7);
                    }
                }
                for (int i11 = i5 + 1; i11 < size; i11++) {
                    View view2 = this.y.get(i11);
                    a aVar2 = (a) view2.getLayoutParams();
                    zn a2 = aVar2.a();
                    if (a2 != null && a2.v(this, view2, view)) {
                        if (i == 0 && aVar2.fb()) {
                            aVar2.f();
                        } else {
                            if (i != 2) {
                                z2 = a2.s(this, view2, view);
                            } else {
                                a2.c5(this, view2, view);
                                z2 = true;
                            }
                            if (i == 1) {
                                aVar2.w(z2);
                            }
                        }
                    }
                }
            }
        }
        vl(y2);
        vl(y7);
        vl(y8);
    }

    @Override // hw.tl
    public void f(View view, int i, int i5, int[] iArr, int i6) {
        zn a2;
        int min;
        int min2;
        int childCount = getChildCount();
        boolean z2 = false;
        int i8 = 0;
        int i10 = 0;
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = getChildAt(i11);
            if (childAt.getVisibility() != 8) {
                a aVar = (a) childAt.getLayoutParams();
                if (aVar.i9(i6) && (a2 = aVar.a()) != null) {
                    int[] iArr2 = this.f2066t;
                    iArr2[0] = 0;
                    iArr2[1] = 0;
                    a2.p(this, childAt, view, i, i5, iArr2, i6);
                    int[] iArr3 = this.f2066t;
                    if (i > 0) {
                        min = Math.max(i8, iArr3[0]);
                    } else {
                        min = Math.min(i8, iArr3[0]);
                    }
                    i8 = min;
                    int[] iArr4 = this.f2066t;
                    if (i5 > 0) {
                        min2 = Math.max(i10, iArr4[1]);
                    } else {
                        min2 = Math.min(i10, iArr4[1]);
                    }
                    i10 = min2;
                    z2 = true;
                }
            }
        }
        iArr[0] = i8;
        iArr[1] = i10;
        if (z2) {
            ej(1);
        }
    }

    public void f3(View view, Rect rect) {
        rect.set(((a) view.getLayoutParams()).s());
    }

    public void fb() {
        int childCount = getChildCount();
        boolean z2 = false;
        int i = 0;
        while (true) {
            if (i >= childCount) {
                break;
            } else if (d0(getChildAt(i))) {
                z2 = true;
                break;
            } else {
                i++;
            }
        }
        if (z2 != this.f2053c) {
            if (z2) {
                n3();
            } else {
                hw();
            }
        }
    }

    public boolean fh(@NonNull View view, int i, int i5) {
        Rect y2 = y();
        z(view, y2);
        try {
            return y2.contains(i, i5);
        } finally {
            vl(y2);
        }
    }

    public final List<View> getDependencySortedChildren() {
        k5();
        return Collections.unmodifiableList(this.y);
    }

    public final ej getLastWindowInsets() {
        return this.f2056d0;
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        return this.f2052b.y();
    }

    @Nullable
    public Drawable getStatusBarBackground() {
        return this.f2055d;
    }

    @Override // android.view.View
    public int getSuggestedMinimumHeight() {
        return Math.max(super.getSuggestedMinimumHeight(), getPaddingTop() + getPaddingBottom());
    }

    @Override // android.view.View
    public int getSuggestedMinimumWidth() {
        return Math.max(super.getSuggestedMinimumWidth(), getPaddingLeft() + getPaddingRight());
    }

    public final void gv(a aVar, Rect rect, int i, int i5) {
        int width = getWidth();
        int height = getHeight();
        int max = Math.max(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) aVar).leftMargin, Math.min(rect.left, ((width - getPaddingRight()) - i) - ((ViewGroup.MarginLayoutParams) aVar).rightMargin));
        int max2 = Math.max(getPaddingTop() + ((ViewGroup.MarginLayoutParams) aVar).topMargin, Math.min(rect.top, ((height - getPaddingBottom()) - i5) - ((ViewGroup.MarginLayoutParams) aVar).bottomMargin));
        rect.set(max, max2, i + max, i5 + max2);
    }

    public void hw() {
        if (this.f2054co && this.f2062n != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.f2062n);
        }
        this.f2053c = false;
    }

    public final int i4(int i) {
        int[] iArr = this.f2070z;
        if (iArr == null) {
            Log.e("CoordinatorLayout", "No keylines defined for " + this + " - attempted index lookup " + i);
            return 0;
        } else if (i >= 0 && i < iArr.length) {
            return iArr[i];
        } else {
            Log.e("CoordinatorLayout", "Keyline index " + i + " out of range for " + this);
            return 0;
        }
    }

    @Override // hw.tl
    public void i9(View view, int i) {
        this.f2052b.v(view, i);
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            a aVar = (a) childAt.getLayoutParams();
            if (aVar.i9(i)) {
                zn a2 = aVar.a();
                if (a2 != null) {
                    a2.rz(this, childAt, view, i);
                }
                aVar.t(i);
                aVar.f();
            }
        }
        this.f2059f3 = null;
    }

    public final void j5(boolean z2) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            zn a2 = ((a) childAt.getLayoutParams()).a();
            if (a2 != null) {
                long uptimeMillis = SystemClock.uptimeMillis();
                MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                if (z2) {
                    a2.f(this, childAt, obtain);
                } else {
                    a2.mg(this, childAt, obtain);
                }
                obtain.recycle();
            }
        }
        for (int i5 = 0; i5 < childCount; i5++) {
            ((a) getChildAt(i5).getLayoutParams()).tl();
        }
        this.f2064r = null;
        this.f2063p = false;
    }

    public final void k() {
        if (i4.fh(this)) {
            if (this.f2069x == null) {
                this.f2069x = new y();
            }
            i4.ad(this, this.f2069x);
            setSystemUiVisibility(1280);
            return;
        }
        i4.ad(this, null);
    }

    public final void k5() {
        this.y.clear();
        this.f2067v.zn();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            a n2 = n(childAt);
            n2.gv(this, childAt);
            this.f2067v.n3(childAt);
            for (int i5 = 0; i5 < childCount; i5++) {
                if (i5 != i) {
                    View childAt2 = getChildAt(i5);
                    if (n2.n3(this, childAt, childAt2)) {
                        if (!this.f2067v.gv(childAt2)) {
                            this.f2067v.n3(childAt2);
                        }
                        this.f2067v.y(childAt2, childAt);
                    }
                }
            }
        }
        this.y.addAll(this.f2067v.c5());
        Collections.reverse(this.y);
    }

    public final void mg(View view, View view2, int i) {
        Rect y2 = y();
        Rect y7 = y();
        try {
            z(view2, y2);
            r(view, i, y2, y7);
            view.layout(y7.left, y7.top, y7.right, y7.bottom);
        } finally {
            vl(y2);
            vl(y7);
        }
    }

    @NonNull
    public List<View> mt(@NonNull View view) {
        List<View> s2 = this.f2067v.s(view);
        this.f2065s.clear();
        if (s2 != null) {
            this.f2065s.addAll(s2);
        }
        return this.f2065s;
    }

    public a n(View view) {
        a aVar = (a) view.getLayoutParams();
        if (!aVar.f2079n3) {
            if (view instanceof n3) {
                zn behavior = ((n3) view).getBehavior();
                if (behavior == null) {
                    Log.e("CoordinatorLayout", "Attached behavior class is null");
                }
                aVar.xc(behavior);
                aVar.f2079n3 = true;
            } else {
                gv gvVar = null;
                for (Class<?> cls = view.getClass(); cls != null; cls = cls.getSuperclass()) {
                    gvVar = (gv) cls.getAnnotation(gv.class);
                    if (gvVar != null) {
                        break;
                    }
                }
                if (gvVar != null) {
                    try {
                        aVar.xc(gvVar.value().getDeclaredConstructor(null).newInstance(null));
                    } catch (Exception e2) {
                        Log.e("CoordinatorLayout", "Default behavior class " + gvVar.value().getName() + " could not be instantiated. Did you forget a default constructor?", e2);
                    }
                }
                aVar.f2079n3 = true;
            }
        }
        return aVar;
    }

    public void n3() {
        if (this.f2054co) {
            if (this.f2062n == null) {
                this.f2062n = new fb();
            }
            getViewTreeObserver().addOnPreDrawListener(this.f2062n);
        }
        this.f2053c = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        j5(false);
        if (this.f2053c) {
            if (this.f2062n == null) {
                this.f2062n = new fb();
            }
            getViewTreeObserver().addOnPreDrawListener(this.f2062n);
        }
        if (this.f2056d0 == null && i4.fh(this)) {
            i4.yg(this);
        }
        this.f2054co = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        j5(false);
        if (this.f2053c && this.f2062n != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.f2062n);
        }
        View view = this.f2059f3;
        if (view != null) {
            onStopNestedScroll(view);
        }
        this.f2054co = false;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        int i;
        super.onDraw(canvas);
        if (this.f2061fh && this.f2055d != null) {
            ej ejVar = this.f2056d0;
            if (ejVar != null) {
                i = ejVar.tl();
            } else {
                i = 0;
            }
            if (i > 0) {
                this.f2055d.setBounds(0, 0, getWidth(), i);
                this.f2055d.draw(canvas);
            }
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            j5(true);
        }
        boolean b2 = b(motionEvent, 0);
        if (actionMasked == 1 || actionMasked == 3) {
            j5(true);
        }
        return b2;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z2, int i, int i5, int i6, int i8) {
        zn a2;
        int ta2 = i4.ta(this);
        int size = this.y.size();
        for (int i10 = 0; i10 < size; i10++) {
            View view = this.y.get(i10);
            if (view.getVisibility() != 8 && ((a2 = ((a) view.getLayoutParams()).a()) == null || !a2.t(this, view, ta2))) {
                ud(view, ta2);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:44:0x011c, code lost:
        if (r0.tl(r30, r20, r11, r21, r23, 0) == false) goto L33;
     */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x011f  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onMeasure(int r31, int r32) {
        /*
            Method dump skipped, instructions count: 393
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.CoordinatorLayout.onMeasure(int, int):void");
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedFling(View view, float f4, float f6, boolean z2) {
        zn a2;
        int childCount = getChildCount();
        boolean z3 = false;
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() != 8) {
                a aVar = (a) childAt.getLayoutParams();
                if (aVar.i9(0) && (a2 = aVar.a()) != null) {
                    z3 |= a2.wz(this, childAt, view, f4, f6, z2);
                }
            }
        }
        if (z3) {
            ej(1);
        }
        return z3;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedPreFling(View view, float f4, float f6) {
        zn a2;
        int childCount = getChildCount();
        boolean z2 = false;
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() != 8) {
                a aVar = (a) childAt.getLayoutParams();
                if (aVar.i9(0) && (a2 = aVar.a()) != null) {
                    z2 |= a2.xc(this, childAt, view, f4, f6);
                }
            }
        }
        return z2;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedPreScroll(View view, int i, int i5, int[] iArr) {
        f(view, i, i5, iArr, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedScroll(View view, int i, int i5, int i6, int i8) {
        wz(view, i, i5, i6, i8, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedScrollAccepted(View view, View view2, int i) {
        c5(view, view2, i, 0);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        Parcelable parcelable2;
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.y());
        SparseArray<Parcelable> sparseArray = savedState.f2071fb;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            int id = childAt.getId();
            zn a2 = n(childAt).a();
            if (id != -1 && a2 != null && (parcelable2 = sparseArray.get(id)) != null) {
                a2.f3(this, childAt, parcelable2);
            }
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        Parcelable n2;
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        SparseArray<Parcelable> sparseArray = new SparseArray<>();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            int id = childAt.getId();
            zn a2 = ((a) childAt.getLayoutParams()).a();
            if (id != -1 && a2 != null && (n2 = a2.n(this, childAt)) != null) {
                sparseArray.append(id, n2);
            }
        }
        savedState.f2071fb = sparseArray;
        return savedState;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onStartNestedScroll(View view, View view2, int i) {
        return xc(view, view2, i, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onStopNestedScroll(View view) {
        i9(view, 0);
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0012, code lost:
        if (r3 != false) goto L19;
     */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x004c  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r18) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            int r2 = r18.getActionMasked()
            android.view.View r3 = r0.f2064r
            r4 = 1
            r5 = 0
            if (r3 != 0) goto L17
            boolean r3 = r0.b(r1, r4)
            if (r3 == 0) goto L15
            goto L18
        L15:
            r6 = 0
            goto L2c
        L17:
            r3 = 0
        L18:
            android.view.View r6 = r0.f2064r
            android.view.ViewGroup$LayoutParams r6 = r6.getLayoutParams()
            androidx.coordinatorlayout.widget.CoordinatorLayout$a r6 = (androidx.coordinatorlayout.widget.CoordinatorLayout.a) r6
            androidx.coordinatorlayout.widget.CoordinatorLayout$zn r6 = r6.a()
            if (r6 == 0) goto L15
            android.view.View r7 = r0.f2064r
            boolean r6 = r6.mg(r0, r7, r1)
        L2c:
            android.view.View r7 = r0.f2064r
            r8 = 0
            if (r7 != 0) goto L37
            boolean r1 = super.onTouchEvent(r18)
            r6 = r6 | r1
            goto L4a
        L37:
            if (r3 == 0) goto L4a
            long r11 = android.os.SystemClock.uptimeMillis()
            r15 = 0
            r16 = 0
            r13 = 3
            r14 = 0
            r9 = r11
            android.view.MotionEvent r8 = android.view.MotionEvent.obtain(r9, r11, r13, r14, r15, r16)
            super.onTouchEvent(r8)
        L4a:
            if (r8 == 0) goto L4f
            r8.recycle()
        L4f:
            if (r2 == r4) goto L54
            r1 = 3
            if (r2 != r1) goto L57
        L54:
            r0.j5(r5)
        L57:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.CoordinatorLayout.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public final void oz(View view, int i) {
        a aVar = (a) view.getLayoutParams();
        int i5 = aVar.f2073c5;
        if (i5 != i) {
            i4.y5(view, i - i5);
            aVar.f2073c5 = i;
        }
    }

    public void p(View view, boolean z2, Rect rect) {
        if (!view.isLayoutRequested() && view.getVisibility() != 8) {
            if (z2) {
                z(view, rect);
                return;
            } else {
                rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
                return;
            }
        }
        rect.setEmpty();
    }

    public final ej q9(ej ejVar) {
        boolean z2;
        if (!vl.zn.y(this.f2056d0, ejVar)) {
            this.f2056d0 = ejVar;
            boolean z3 = false;
            if (ejVar != null && ejVar.tl() > 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            this.f2061fh = z2;
            if (!z2 && getBackground() == null) {
                z3 = true;
            }
            setWillNotDraw(z3);
            ej v2 = v(ejVar);
            requestLayout();
            return v2;
        }
        return ejVar;
    }

    public void r(View view, int i, Rect rect, Rect rect2) {
        a aVar = (a) view.getLayoutParams();
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        x4(view, i, rect, rect2, aVar, measuredWidth, measuredHeight);
        gv(aVar, rect2, measuredWidth, measuredHeight);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z2) {
        zn a2 = ((a) view.getLayoutParams()).a();
        if (a2 != null && a2.i4(this, view, rect, z2)) {
            return true;
        }
        return super.requestChildRectangleOnScreen(view, rect, z2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z2) {
        super.requestDisallowInterceptTouchEvent(z2);
        if (z2 && !this.f2063p) {
            j5(false);
            this.f2063p = true;
        }
    }

    public final void rz(View view, int i) {
        a aVar = (a) view.getLayoutParams();
        Rect y2 = y();
        y2.set(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) aVar).leftMargin, getPaddingTop() + ((ViewGroup.MarginLayoutParams) aVar).topMargin, (getWidth() - getPaddingRight()) - ((ViewGroup.MarginLayoutParams) aVar).rightMargin, (getHeight() - getPaddingBottom()) - ((ViewGroup.MarginLayoutParams) aVar).bottomMargin);
        if (this.f2056d0 != null && i4.fh(this) && !i4.fh(view)) {
            y2.left += this.f2056d0.f();
            y2.top += this.f2056d0.tl();
            y2.right -= this.f2056d0.t();
            y2.bottom -= this.f2056d0.i9();
        }
        Rect y7 = y();
        hw.v.y(o(aVar.f2088zn), view.getMeasuredWidth(), view.getMeasuredHeight(), y2, y7, i);
        view.layout(y7.left, y7.top, y7.right, y7.bottom);
        vl(y2);
        vl(y7);
    }

    @Override // android.view.ViewGroup
    /* renamed from: s */
    public a generateDefaultLayoutParams() {
        return new a(-2, -2);
    }

    @Override // android.view.View
    public void setFitsSystemWindows(boolean z2) {
        super.setFitsSystemWindows(z2);
        k();
    }

    @Override // android.view.ViewGroup
    public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener) {
        this.f2057ej = onHierarchyChangeListener;
    }

    public void setStatusBarBackground(@Nullable Drawable drawable) {
        boolean z2;
        Drawable drawable2 = this.f2055d;
        if (drawable2 != drawable) {
            Drawable drawable3 = null;
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            if (drawable != null) {
                drawable3 = drawable.mutate();
            }
            this.f2055d = drawable3;
            if (drawable3 != null) {
                if (drawable3.isStateful()) {
                    this.f2055d.setState(getDrawableState());
                }
                ej.y.tl(this.f2055d, i4.ta(this));
                Drawable drawable4 = this.f2055d;
                if (getVisibility() == 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                drawable4.setVisible(z2, false);
                this.f2055d.setCallback(this);
            }
            i4.lc(this);
        }
    }

    public void setStatusBarBackgroundColor(int i) {
        setStatusBarBackground(new ColorDrawable(i));
    }

    public void setStatusBarBackgroundResource(int i) {
        Drawable drawable;
        if (i != 0) {
            drawable = mg.y.v(getContext(), i);
        } else {
            drawable = null;
        }
        setStatusBarBackground(drawable);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        boolean z2;
        super.setVisibility(i);
        if (i == 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        Drawable drawable = this.f2055d;
        if (drawable != null && drawable.isVisible() != z2) {
            this.f2055d.setVisible(z2, false);
        }
    }

    @Override // android.view.ViewGroup
    /* renamed from: t */
    public a generateLayoutParams(AttributeSet attributeSet) {
        return new a(getContext(), attributeSet);
    }

    public final void ta(View view, int i, int i5) {
        int i6;
        a aVar = (a) view.getLayoutParams();
        int n32 = hw.v.n3(j(aVar.f2088zn), i5);
        int i8 = n32 & 7;
        int i10 = n32 & R.styleable.AppCompatTheme_toolbarNavigationButtonStyle;
        int width = getWidth();
        int height = getHeight();
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        if (i5 == 1) {
            i = width - i;
        }
        int i42 = i4(i) - measuredWidth;
        if (i8 != 1) {
            if (i8 == 5) {
                i42 += measuredWidth;
            }
        } else {
            i42 += measuredWidth / 2;
        }
        if (i10 != 16) {
            if (i10 != 80) {
                i6 = 0;
            } else {
                i6 = measuredHeight;
            }
        } else {
            i6 = measuredHeight / 2;
        }
        int max = Math.max(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) aVar).leftMargin, Math.min(i42, ((width - getPaddingRight()) - measuredWidth) - ((ViewGroup.MarginLayoutParams) aVar).rightMargin));
        int max2 = Math.max(getPaddingTop() + ((ViewGroup.MarginLayoutParams) aVar).topMargin, Math.min(i6, ((height - getPaddingBottom()) - measuredHeight) - ((ViewGroup.MarginLayoutParams) aVar).bottomMargin));
        view.layout(max, max2, measuredWidth + max, measuredHeight + max2);
    }

    @Override // hw.wz
    public void tl(@NonNull View view, int i, int i5, int i6, int i8, int i10, @NonNull int[] iArr) {
        zn a2;
        int min;
        int min2;
        int childCount = getChildCount();
        boolean z2 = false;
        int i11 = 0;
        int i12 = 0;
        for (int i13 = 0; i13 < childCount; i13++) {
            View childAt = getChildAt(i13);
            if (childAt.getVisibility() != 8) {
                a aVar = (a) childAt.getLayoutParams();
                if (aVar.i9(i10) && (a2 = aVar.a()) != null) {
                    int[] iArr2 = this.f2066t;
                    iArr2[0] = 0;
                    iArr2[1] = 0;
                    a2.z(this, childAt, view, i, i5, i6, i8, i10, iArr2);
                    int[] iArr3 = this.f2066t;
                    if (i6 > 0) {
                        min = Math.max(i11, iArr3[0]);
                    } else {
                        min = Math.min(i11, iArr3[0]);
                    }
                    i11 = min;
                    if (i8 > 0) {
                        min2 = Math.max(i12, this.f2066t[1]);
                    } else {
                        min2 = Math.min(i12, this.f2066t[1]);
                    }
                    i12 = min2;
                    z2 = true;
                }
            }
        }
        iArr[0] = iArr[0] + i11;
        iArr[1] = iArr[1] + i12;
        if (z2) {
            ej(1);
        }
    }

    public void ud(@NonNull View view, int i) {
        a aVar = (a) view.getLayoutParams();
        if (!aVar.y()) {
            View view2 = aVar.f2074f;
            if (view2 != null) {
                mg(view, view2, i);
                return;
            }
            int i5 = aVar.f2084v;
            if (i5 >= 0) {
                ta(view, i5, i);
                return;
            } else {
                rz(view, i);
                return;
            }
        }
        throw new IllegalStateException("An anchor may not be changed after CoordinatorLayout measurement begins before layout is complete.");
    }

    public final void ut(View view, int i) {
        a aVar = (a) view.getLayoutParams();
        int i5 = aVar.f2077i9;
        if (i5 != i) {
            i4.xg(view, i - i5);
            aVar.f2077i9 = i;
        }
    }

    public final ej v(ej ejVar) {
        zn a2;
        if (ejVar.w()) {
            return ejVar;
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (i4.fh(childAt) && (a2 = ((a) childAt.getLayoutParams()).a()) != null) {
                ejVar = a2.a(this, childAt, ejVar);
                if (ejVar.w()) {
                    break;
                }
            }
        }
        return ejVar;
    }

    @Override // android.view.View
    public boolean verifyDrawable(Drawable drawable) {
        if (!super.verifyDrawable(drawable) && drawable != this.f2055d) {
            return false;
        }
        return true;
    }

    @Override // android.view.ViewGroup
    /* renamed from: w */
    public a generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof a) {
            return new a((a) layoutParams);
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new a((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new a(layoutParams);
    }

    @Override // hw.tl
    public void wz(View view, int i, int i5, int i6, int i8, int i10) {
        tl(view, i, i5, i6, i8, 0, this.f2068w);
    }

    public final void x4(View view, int i, Rect rect, Rect rect2, a aVar, int i5, int i6) {
        int width;
        int height;
        int n32 = hw.v.n3(qn(aVar.f2088zn), i);
        int n33 = hw.v.n3(o(aVar.f2076gv), i);
        int i8 = n32 & 7;
        int i10 = n32 & R.styleable.AppCompatTheme_toolbarNavigationButtonStyle;
        int i11 = n33 & 7;
        int i12 = n33 & R.styleable.AppCompatTheme_toolbarNavigationButtonStyle;
        if (i11 != 1) {
            if (i11 != 5) {
                width = rect.left;
            } else {
                width = rect.right;
            }
        } else {
            width = rect.left + (rect.width() / 2);
        }
        if (i12 != 16) {
            if (i12 != 80) {
                height = rect.top;
            } else {
                height = rect.bottom;
            }
        } else {
            height = rect.top + (rect.height() / 2);
        }
        if (i8 != 1) {
            if (i8 != 5) {
                width -= i5;
            }
        } else {
            width -= i5 / 2;
        }
        if (i10 != 16) {
            if (i10 != 80) {
                height -= i6;
            }
        } else {
            height -= i6 / 2;
        }
        rect2.set(width, height, i5 + width, i6 + height);
    }

    @Override // hw.tl
    public boolean xc(View view, View view2, int i, int i5) {
        int childCount = getChildCount();
        boolean z2 = false;
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() != 8) {
                a aVar = (a) childAt.getLayoutParams();
                zn a2 = aVar.a();
                if (a2 != null) {
                    boolean d02 = a2.d0(this, childAt, view, view2, i, i5);
                    z2 |= d02;
                    aVar.mt(i5, d02);
                } else {
                    aVar.mt(i5, false);
                }
            }
        }
        return z2;
    }

    public void yt(View view, Rect rect) {
        ((a) view.getLayoutParams()).p(rect);
    }

    public void z(View view, Rect rect) {
        fh.n3.y(this, view, rect);
    }

    public void z6(View view, int i) {
        zn a2;
        a aVar = (a) view.getLayoutParams();
        if (aVar.f2074f != null) {
            Rect y2 = y();
            Rect y7 = y();
            Rect y8 = y();
            z(aVar.f2074f, y2);
            boolean z2 = false;
            p(view, false, y7);
            int measuredWidth = view.getMeasuredWidth();
            int measuredHeight = view.getMeasuredHeight();
            x4(view, i, y2, y8, aVar, measuredWidth, measuredHeight);
            z2 = (y8.left == y7.left && y8.top == y7.top) ? true : true;
            gv(aVar, y8, measuredWidth, measuredHeight);
            int i5 = y8.left - y7.left;
            int i6 = y8.top - y7.top;
            if (i5 != 0) {
                i4.y5(view, i5);
            }
            if (i6 != 0) {
                i4.xg(view, i6);
            }
            if (z2 && (a2 = aVar.a()) != null) {
                a2.s(this, view, aVar.f2074f);
            }
            vl(y2);
            vl(y7);
            vl(y8);
        }
    }

    public CoordinatorLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes;
        this.y = new ArrayList();
        this.f2067v = new fh.y<>();
        this.f2060fb = new ArrayList();
        this.f2065s = new ArrayList();
        this.f2066t = new int[2];
        this.f2068w = new int[2];
        this.f2052b = new xc(this);
        if (i == 0) {
            obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.f2038n3, 0, R$style.e2);
        } else {
            obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.f2038n3, i, 0);
        }
        if (Build.VERSION.SDK_INT >= 29) {
            if (i == 0) {
                saveAttributeDataForStyleable(context, R$styleable.f2038n3, attributeSet, obtainStyledAttributes, 0, R$style.e2);
            } else {
                saveAttributeDataForStyleable(context, R$styleable.f2038n3, attributeSet, obtainStyledAttributes, i, 0);
            }
        }
        int resourceId = obtainStyledAttributes.getResourceId(R$styleable.f2046zn, 0);
        if (resourceId != 0) {
            Resources resources = context.getResources();
            this.f2070z = resources.getIntArray(resourceId);
            float f4 = resources.getDisplayMetrics().density;
            int length = this.f2070z.length;
            for (int i5 = 0; i5 < length; i5++) {
                int[] iArr = this.f2070z;
                iArr[i5] = (int) (iArr[i5] * f4);
            }
        }
        this.f2055d = obtainStyledAttributes.getDrawable(R$styleable.f2036gv);
        obtainStyledAttributes.recycle();
        k();
        super.setOnHierarchyChangeListener(new v());
        if (i4.rz(this) == 0) {
            i4.o0(this, 1);
        }
    }

    /* loaded from: classes.dex */
    public static class a extends ViewGroup.MarginLayoutParams {

        /* renamed from: a  reason: collision with root package name */
        public int f2072a;

        /* renamed from: c5  reason: collision with root package name */
        public int f2073c5;

        /* renamed from: f  reason: collision with root package name */
        public View f2074f;

        /* renamed from: fb  reason: collision with root package name */
        public int f2075fb;

        /* renamed from: gv  reason: collision with root package name */
        public int f2076gv;

        /* renamed from: i9  reason: collision with root package name */
        public int f2077i9;

        /* renamed from: mt  reason: collision with root package name */
        public Object f2078mt;

        /* renamed from: n3  reason: collision with root package name */
        public boolean f2079n3;

        /* renamed from: p  reason: collision with root package name */
        public final Rect f2080p;

        /* renamed from: s  reason: collision with root package name */
        public int f2081s;

        /* renamed from: t  reason: collision with root package name */
        public View f2082t;

        /* renamed from: tl  reason: collision with root package name */
        public boolean f2083tl;

        /* renamed from: v  reason: collision with root package name */
        public int f2084v;

        /* renamed from: w  reason: collision with root package name */
        public boolean f2085w;

        /* renamed from: wz  reason: collision with root package name */
        public boolean f2086wz;

        /* renamed from: xc  reason: collision with root package name */
        public boolean f2087xc;
        public zn y;

        /* renamed from: zn  reason: collision with root package name */
        public int f2088zn;

        public a(int i, int i5) {
            super(i, i5);
            this.f2084v = -1;
            this.f2072a = -1;
            this.f2080p = new Rect();
        }

        @Nullable
        public zn a() {
            return this.y;
        }

        public boolean c5(CoordinatorLayout coordinatorLayout, View view) {
            boolean z2;
            boolean z3 = this.f2083tl;
            if (z3) {
                return true;
            }
            zn znVar = this.y;
            if (znVar != null) {
                z2 = znVar.y(coordinatorLayout, view);
            } else {
                z2 = false;
            }
            boolean z4 = z2 | z3;
            this.f2083tl = z4;
            return z4;
        }

        public final boolean co(View view, int i) {
            int n32 = hw.v.n3(((a) view.getLayoutParams()).f2075fb, i);
            if (n32 != 0 && (hw.v.n3(this.f2081s, i) & n32) == n32) {
                return true;
            }
            return false;
        }

        public void f() {
            this.f2085w = false;
        }

        public boolean fb() {
            return this.f2085w;
        }

        public View gv(CoordinatorLayout coordinatorLayout, View view) {
            if (this.f2072a == -1) {
                this.f2082t = null;
                this.f2074f = null;
                return null;
            }
            if (this.f2074f == null || !z(view, coordinatorLayout)) {
                wz(view, coordinatorLayout);
            }
            return this.f2074f;
        }

        public boolean i9(int i) {
            if (i != 0) {
                if (i != 1) {
                    return false;
                }
                return this.f2087xc;
            }
            return this.f2086wz;
        }

        public void mt(int i, boolean z2) {
            if (i != 0) {
                if (i == 1) {
                    this.f2087xc = z2;
                    return;
                }
                return;
            }
            this.f2086wz = z2;
        }

        public boolean n3(CoordinatorLayout coordinatorLayout, View view, View view2) {
            zn znVar;
            if (view2 != this.f2082t && !co(view2, i4.ta(coordinatorLayout)) && ((znVar = this.y) == null || !znVar.v(coordinatorLayout, view, view2))) {
                return false;
            }
            return true;
        }

        public void p(Rect rect) {
            this.f2080p.set(rect);
        }

        public Rect s() {
            return this.f2080p;
        }

        public void t(int i) {
            mt(i, false);
        }

        public void tl() {
            this.f2083tl = false;
        }

        public int v() {
            return this.f2072a;
        }

        public void w(boolean z2) {
            this.f2085w = z2;
        }

        public final void wz(View view, CoordinatorLayout coordinatorLayout) {
            View findViewById = coordinatorLayout.findViewById(this.f2072a);
            this.f2074f = findViewById;
            if (findViewById != null) {
                if (findViewById == coordinatorLayout) {
                    if (coordinatorLayout.isInEditMode()) {
                        this.f2082t = null;
                        this.f2074f = null;
                        return;
                    }
                    throw new IllegalStateException("View can not be anchored to the the parent CoordinatorLayout");
                }
                for (ViewParent parent = findViewById.getParent(); parent != coordinatorLayout && parent != null; parent = parent.getParent()) {
                    if (parent == view) {
                        if (coordinatorLayout.isInEditMode()) {
                            this.f2082t = null;
                            this.f2074f = null;
                            return;
                        }
                        throw new IllegalStateException("Anchor must not be a descendant of the anchored view");
                    }
                    if (parent instanceof View) {
                        findViewById = (View) parent;
                    }
                }
                this.f2082t = findViewById;
            } else if (coordinatorLayout.isInEditMode()) {
                this.f2082t = null;
                this.f2074f = null;
            } else {
                throw new IllegalStateException("Could not find CoordinatorLayout descendant view with id " + coordinatorLayout.getResources().getResourceName(this.f2072a) + " to anchor view " + view);
            }
        }

        public void xc(@Nullable zn znVar) {
            zn znVar2 = this.y;
            if (znVar2 != znVar) {
                if (znVar2 != null) {
                    znVar2.i9();
                }
                this.y = znVar;
                this.f2078mt = null;
                this.f2079n3 = true;
                if (znVar != null) {
                    znVar.fb(this);
                }
            }
        }

        public boolean y() {
            if (this.f2074f == null && this.f2072a != -1) {
                return true;
            }
            return false;
        }

        public final boolean z(View view, CoordinatorLayout coordinatorLayout) {
            if (this.f2074f.getId() != this.f2072a) {
                return false;
            }
            View view2 = this.f2074f;
            for (ViewParent parent = view2.getParent(); parent != coordinatorLayout; parent = parent.getParent()) {
                if (parent != null && parent != view) {
                    if (parent instanceof View) {
                        view2 = (View) parent;
                    }
                } else {
                    this.f2082t = null;
                    this.f2074f = null;
                    return false;
                }
            }
            this.f2082t = view2;
            return true;
        }

        public boolean zn() {
            if (this.y == null) {
                this.f2083tl = false;
            }
            return this.f2083tl;
        }

        public a(@NonNull Context context, @Nullable AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f2084v = -1;
            this.f2072a = -1;
            this.f2080p = new Rect();
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.f2042v);
            this.f2088zn = obtainStyledAttributes.getInteger(R$styleable.f2032a, 0);
            this.f2072a = obtainStyledAttributes.getResourceId(R$styleable.f2035fb, -1);
            this.f2076gv = obtainStyledAttributes.getInteger(R$styleable.f2039s, 0);
            this.f2084v = obtainStyledAttributes.getInteger(R$styleable.f2040t, -1);
            this.f2075fb = obtainStyledAttributes.getInt(R$styleable.f2034f, 0);
            this.f2081s = obtainStyledAttributes.getInt(R$styleable.f2037i9, 0);
            int i = R$styleable.f2033c5;
            boolean hasValue = obtainStyledAttributes.hasValue(i);
            this.f2079n3 = hasValue;
            if (hasValue) {
                this.y = CoordinatorLayout.x(context, attributeSet, obtainStyledAttributes.getString(i));
            }
            obtainStyledAttributes.recycle();
            zn znVar = this.y;
            if (znVar != null) {
                znVar.fb(this);
            }
        }

        public a(a aVar) {
            super((ViewGroup.MarginLayoutParams) aVar);
            this.f2084v = -1;
            this.f2072a = -1;
            this.f2080p = new Rect();
        }

        public a(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f2084v = -1;
            this.f2072a = -1;
            this.f2080p = new Rect();
        }

        public a(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f2084v = -1;
            this.f2072a = -1;
            this.f2080p = new Rect();
        }
    }

    /* loaded from: classes.dex */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new y();

        /* renamed from: fb  reason: collision with root package name */
        public SparseArray<Parcelable> f2071fb;

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

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            int readInt = parcel.readInt();
            int[] iArr = new int[readInt];
            parcel.readIntArray(iArr);
            Parcelable[] readParcelableArray = parcel.readParcelableArray(classLoader);
            this.f2071fb = new SparseArray<>(readInt);
            for (int i = 0; i < readInt; i++) {
                this.f2071fb.append(iArr[i], readParcelableArray[i]);
            }
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            int i5;
            super.writeToParcel(parcel, i);
            SparseArray<Parcelable> sparseArray = this.f2071fb;
            if (sparseArray != null) {
                i5 = sparseArray.size();
            } else {
                i5 = 0;
            }
            parcel.writeInt(i5);
            int[] iArr = new int[i5];
            Parcelable[] parcelableArr = new Parcelable[i5];
            for (int i6 = 0; i6 < i5; i6++) {
                iArr[i6] = this.f2071fb.keyAt(i6);
                parcelableArr[i6] = this.f2071fb.valueAt(i6);
            }
            parcel.writeIntArray(iArr);
            parcel.writeParcelableArray(parcelableArr, i);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }
}
