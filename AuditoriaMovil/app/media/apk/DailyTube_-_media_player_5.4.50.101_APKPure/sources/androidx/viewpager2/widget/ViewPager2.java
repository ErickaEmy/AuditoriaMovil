package androidx.viewpager2.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.R$styleable;
import hw.i4;
import j5.a;
import j5.zn;
/* loaded from: classes.dex */
public final class ViewPager2 extends ViewGroup {

    /* renamed from: j5  reason: collision with root package name */
    public static boolean f3633j5 = true;

    /* renamed from: b  reason: collision with root package name */
    public v f3634b;

    /* renamed from: c  reason: collision with root package name */
    public cy.n3 f3635c;

    /* renamed from: co  reason: collision with root package name */
    public Parcelable f3636co;

    /* renamed from: d  reason: collision with root package name */
    public boolean f3637d;

    /* renamed from: d0  reason: collision with root package name */
    public androidx.viewpager2.widget.gv f3638d0;

    /* renamed from: ej  reason: collision with root package name */
    public boolean f3639ej;

    /* renamed from: f  reason: collision with root package name */
    public boolean f3640f;

    /* renamed from: f3  reason: collision with root package name */
    public androidx.viewpager2.widget.v f3641f3;

    /* renamed from: fb  reason: collision with root package name */
    public androidx.viewpager2.widget.y f3642fb;

    /* renamed from: fh  reason: collision with root package name */
    public RecyclerView.tl f3643fh;

    /* renamed from: n  reason: collision with root package name */
    public androidx.viewpager2.widget.y f3644n;

    /* renamed from: p  reason: collision with root package name */
    public int f3645p;

    /* renamed from: r  reason: collision with root package name */
    public androidx.recyclerview.widget.t f3646r;

    /* renamed from: s  reason: collision with root package name */
    public int f3647s;

    /* renamed from: t  reason: collision with root package name */
    public RecyclerView.i9 f3648t;

    /* renamed from: v  reason: collision with root package name */
    public final Rect f3649v;

    /* renamed from: w  reason: collision with root package name */
    public LinearLayoutManager f3650w;

    /* renamed from: x  reason: collision with root package name */
    public int f3651x;
    public final Rect y;

    /* renamed from: z  reason: collision with root package name */
    public RecyclerView f3652z;

    /* loaded from: classes.dex */
    public class a extends v {
        public a() {
            super(ViewPager2.this, null);
        }

        @Override // androidx.viewpager2.widget.ViewPager2.v
        public boolean f(int i) {
            if (n3(i)) {
                return false;
            }
            throw new IllegalStateException();
        }

        @Override // androidx.viewpager2.widget.ViewPager2.v
        public boolean gv() {
            return true;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.v
        public void i9(@NonNull j5.zn znVar) {
            if (!ViewPager2.this.v()) {
                znVar.dm(zn.y.f9397mt);
                znVar.dm(zn.y.f9401p);
                znVar.wf(false);
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.v
        public boolean n3(int i) {
            if ((i == 8192 || i == 4096) && !ViewPager2.this.v()) {
                return true;
            }
            return false;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.v
        public CharSequence wz() {
            if (gv()) {
                return "androidx.viewpager.widget.ViewPager";
            }
            throw new IllegalStateException();
        }
    }

    /* loaded from: classes.dex */
    public static abstract class c5 {
        public void onPageScrollStateChanged(int i) {
        }

        public void onPageScrolled(int i, float f4, int i5) {
        }

        public void onPageSelected(int i) {
        }
    }

    /* loaded from: classes.dex */
    public interface f {
        void transformPage(@NonNull View view, float f4);
    }

    /* loaded from: classes.dex */
    public static abstract class fb extends RecyclerView.i9 {
        public fb() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i9
        public abstract void onChanged();

        @Override // androidx.recyclerview.widget.RecyclerView.i9
        public final void onItemRangeChanged(int i, int i5) {
            onChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i9
        public final void onItemRangeInserted(int i, int i5) {
            onChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i9
        public final void onItemRangeMoved(int i, int i5, int i6) {
            onChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i9
        public final void onItemRangeRemoved(int i, int i5) {
            onChanged();
        }

        public /* synthetic */ fb(y yVar) {
            this();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i9
        public final void onItemRangeChanged(int i, int i5, @Nullable Object obj) {
            onChanged();
        }
    }

    /* loaded from: classes.dex */
    public class gv implements RecyclerView.mt {
        public gv() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.mt
        public void n3(@NonNull View view) {
            RecyclerView.p pVar = (RecyclerView.p) view.getLayoutParams();
            if (((ViewGroup.MarginLayoutParams) pVar).width == -1 && ((ViewGroup.MarginLayoutParams) pVar).height == -1) {
                return;
            }
            throw new IllegalStateException("Pages must fill the whole ViewPager2 (use match_parent)");
        }

        @Override // androidx.recyclerview.widget.RecyclerView.mt
        public void y(@NonNull View view) {
        }
    }

    /* loaded from: classes.dex */
    public class i9 extends v {

        /* renamed from: gv  reason: collision with root package name */
        public RecyclerView.i9 f3656gv;

        /* renamed from: n3  reason: collision with root package name */
        public final j5.a f3657n3;

        /* renamed from: zn  reason: collision with root package name */
        public final j5.a f3659zn;

        /* loaded from: classes.dex */
        public class n3 implements j5.a {
            public n3() {
            }

            @Override // j5.a
            public boolean y(@NonNull View view, @Nullable a.y yVar) {
                i9.this.x4(((ViewPager2) view).getCurrentItem() - 1);
                return true;
            }
        }

        /* loaded from: classes.dex */
        public class y implements j5.a {
            public y() {
            }

            @Override // j5.a
            public boolean y(@NonNull View view, @Nullable a.y yVar) {
                i9.this.x4(((ViewPager2) view).getCurrentItem() + 1);
                return true;
            }
        }

        /* loaded from: classes.dex */
        public class zn extends fb {
            public zn() {
                super(null);
            }

            @Override // androidx.viewpager2.widget.ViewPager2.fb, androidx.recyclerview.widget.RecyclerView.i9
            public void onChanged() {
                i9.this.i4();
            }
        }

        public i9() {
            super(ViewPager2.this, null);
            this.f3657n3 = new y();
            this.f3659zn = new n3();
        }

        @Override // androidx.viewpager2.widget.ViewPager2.v
        public void a(@Nullable RecyclerView.s<?> sVar) {
            if (sVar != null) {
                sVar.unregisterAdapterDataObserver(this.f3656gv);
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.v
        public void c5(AccessibilityNodeInfo accessibilityNodeInfo) {
            z(accessibilityNodeInfo);
            r(accessibilityNodeInfo);
        }

        @Override // androidx.viewpager2.widget.ViewPager2.v
        public void co() {
            i4();
        }

        @Override // androidx.viewpager2.widget.ViewPager2.v
        public String fb() {
            if (y()) {
                return "androidx.viewpager.widget.ViewPager";
            }
            throw new IllegalStateException();
        }

        public void i4() {
            int itemCount;
            int i;
            ViewPager2 viewPager2 = ViewPager2.this;
            int i5 = 16908360;
            i4.e(viewPager2, 16908360);
            i4.e(viewPager2, 16908361);
            i4.e(viewPager2, 16908358);
            i4.e(viewPager2, 16908359);
            if (ViewPager2.this.getAdapter() == null || (itemCount = ViewPager2.this.getAdapter().getItemCount()) == 0 || !ViewPager2.this.v()) {
                return;
            }
            if (ViewPager2.this.getOrientation() == 0) {
                boolean gv2 = ViewPager2.this.gv();
                if (gv2) {
                    i = 16908360;
                } else {
                    i = 16908361;
                }
                if (gv2) {
                    i5 = 16908361;
                }
                if (ViewPager2.this.f3647s < itemCount - 1) {
                    i4.ap(viewPager2, new zn.y(i, null), null, this.f3657n3);
                }
                if (ViewPager2.this.f3647s > 0) {
                    i4.ap(viewPager2, new zn.y(i5, null), null, this.f3659zn);
                    return;
                }
                return;
            }
            if (ViewPager2.this.f3647s < itemCount - 1) {
                i4.ap(viewPager2, new zn.y(16908359, null), null, this.f3657n3);
            }
            if (ViewPager2.this.f3647s > 0) {
                i4.ap(viewPager2, new zn.y(16908358, null), null, this.f3659zn);
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.v
        public void mt() {
            i4();
        }

        @Override // androidx.viewpager2.widget.ViewPager2.v
        public void p() {
            i4();
        }

        public final void r(AccessibilityNodeInfo accessibilityNodeInfo) {
            int itemCount;
            RecyclerView.s adapter = ViewPager2.this.getAdapter();
            if (adapter != null && (itemCount = adapter.getItemCount()) != 0 && ViewPager2.this.v()) {
                if (ViewPager2.this.f3647s > 0) {
                    accessibilityNodeInfo.addAction(8192);
                }
                if (ViewPager2.this.f3647s < itemCount - 1) {
                    accessibilityNodeInfo.addAction(4096);
                }
                accessibilityNodeInfo.setScrollable(true);
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.v
        public void s(@NonNull androidx.viewpager2.widget.y yVar, @NonNull RecyclerView recyclerView) {
            i4.o0(recyclerView, 2);
            this.f3656gv = new zn();
            if (i4.rz(ViewPager2.this) == 0) {
                i4.o0(ViewPager2.this, 1);
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.v
        public boolean t(int i, Bundle bundle) {
            int currentItem;
            if (zn(i, bundle)) {
                if (i == 8192) {
                    currentItem = ViewPager2.this.getCurrentItem() - 1;
                } else {
                    currentItem = ViewPager2.this.getCurrentItem() + 1;
                }
                x4(currentItem);
                return true;
            }
            throw new IllegalStateException();
        }

        @Override // androidx.viewpager2.widget.ViewPager2.v
        public void tl() {
            i4();
        }

        @Override // androidx.viewpager2.widget.ViewPager2.v
        public void v(@Nullable RecyclerView.s<?> sVar) {
            i4();
            if (sVar != null) {
                sVar.registerAdapterDataObserver(this.f3656gv);
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.v
        public void w() {
            i4();
        }

        public void x4(int i) {
            if (ViewPager2.this.v()) {
                ViewPager2.this.f(i, true);
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.v
        public void xc(@NonNull AccessibilityEvent accessibilityEvent) {
            accessibilityEvent.setSource(ViewPager2.this);
            accessibilityEvent.setClassName(fb());
        }

        @Override // androidx.viewpager2.widget.ViewPager2.v
        public boolean y() {
            return true;
        }

        public final void z(AccessibilityNodeInfo accessibilityNodeInfo) {
            int i;
            int i5;
            if (ViewPager2.this.getAdapter() != null) {
                if (ViewPager2.this.getOrientation() == 1) {
                    i = ViewPager2.this.getAdapter().getItemCount();
                } else {
                    i5 = ViewPager2.this.getAdapter().getItemCount();
                    i = 0;
                    j5.zn.w2(accessibilityNodeInfo).ap(zn.a.y(i, i5, false, 0));
                }
            } else {
                i = 0;
            }
            i5 = 0;
            j5.zn.w2(accessibilityNodeInfo).ap(zn.a.y(i, i5, false, 0));
        }

        @Override // androidx.viewpager2.widget.ViewPager2.v
        public boolean zn(int i, Bundle bundle) {
            return i == 8192 || i == 4096;
        }
    }

    /* loaded from: classes.dex */
    public class n3 extends c5 {
        public n3() {
        }

        @Override // androidx.viewpager2.widget.ViewPager2.c5
        public void onPageScrollStateChanged(int i) {
            if (i == 0) {
                ViewPager2.this.xc();
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.c5
        public void onPageSelected(int i) {
            ViewPager2 viewPager2 = ViewPager2.this;
            if (viewPager2.f3647s != i) {
                viewPager2.f3647s = i;
                viewPager2.f3634b.p();
            }
        }
    }

    /* loaded from: classes.dex */
    public class s extends LinearLayoutManager {
        public s(Context context) {
            super(context);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.w
        public boolean dp(@NonNull RecyclerView recyclerView, @NonNull View view, @NonNull Rect rect, boolean z2, boolean z3) {
            return false;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.w
        public boolean ia(@NonNull RecyclerView.i4 i4Var, @NonNull RecyclerView.fh fhVar, int i, @Nullable Bundle bundle) {
            if (ViewPager2.this.f3634b.n3(i)) {
                return ViewPager2.this.f3634b.f(i);
            }
            return super.ia(i4Var, fhVar, i, bundle);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.w
        public void ro(@NonNull RecyclerView.i4 i4Var, @NonNull RecyclerView.fh fhVar, @NonNull j5.zn znVar) {
            super.ro(i4Var, fhVar, znVar);
            ViewPager2.this.f3634b.i9(znVar);
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager
        public void ux(@NonNull RecyclerView.fh fhVar, @NonNull int[] iArr) {
            int offscreenPageLimit = ViewPager2.this.getOffscreenPageLimit();
            if (offscreenPageLimit == -1) {
                super.ux(fhVar, iArr);
                return;
            }
            int pageSize = ViewPager2.this.getPageSize() * offscreenPageLimit;
            iArr[0] = pageSize;
            iArr[1] = pageSize;
        }
    }

    /* loaded from: classes.dex */
    public class t extends androidx.recyclerview.widget.t {
        public t() {
        }

        @Override // androidx.recyclerview.widget.t, androidx.recyclerview.widget.w
        @Nullable
        public View fb(RecyclerView.w wVar) {
            if (ViewPager2.this.zn()) {
                return null;
            }
            return super.fb(wVar);
        }
    }

    /* loaded from: classes.dex */
    public class tl extends RecyclerView {
        public tl(@NonNull Context context) {
            super(context);
        }

        @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
        public CharSequence getAccessibilityClassName() {
            if (ViewPager2.this.f3634b.gv()) {
                return ViewPager2.this.f3634b.wz();
            }
            return super.getAccessibilityClassName();
        }

        @Override // android.view.View
        public void onInitializeAccessibilityEvent(@NonNull AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setFromIndex(ViewPager2.this.f3647s);
            accessibilityEvent.setToIndex(ViewPager2.this.f3647s);
            ViewPager2.this.f3634b.xc(accessibilityEvent);
        }

        @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            if (ViewPager2.this.v() && super.onInterceptTouchEvent(motionEvent)) {
                return true;
            }
            return false;
        }

        @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
        @SuppressLint({"ClickableViewAccessibility"})
        public boolean onTouchEvent(MotionEvent motionEvent) {
            if (ViewPager2.this.v() && super.onTouchEvent(motionEvent)) {
                return true;
            }
            return false;
        }
    }

    /* loaded from: classes.dex */
    public abstract class v {
        public v() {
        }

        public void a(@Nullable RecyclerView.s<?> sVar) {
        }

        public void c5(AccessibilityNodeInfo accessibilityNodeInfo) {
        }

        public void co() {
        }

        public boolean f(int i) {
            throw new IllegalStateException("Not implemented.");
        }

        public String fb() {
            throw new IllegalStateException("Not implemented.");
        }

        public boolean gv() {
            return false;
        }

        public void mt() {
        }

        public boolean n3(int i) {
            return false;
        }

        public void p() {
        }

        public void s(@NonNull androidx.viewpager2.widget.y yVar, @NonNull RecyclerView recyclerView) {
        }

        public boolean t(int i, Bundle bundle) {
            throw new IllegalStateException("Not implemented.");
        }

        public void tl() {
        }

        public void v(@Nullable RecyclerView.s<?> sVar) {
        }

        public void w() {
        }

        public CharSequence wz() {
            throw new IllegalStateException("Not implemented.");
        }

        public void xc(@NonNull AccessibilityEvent accessibilityEvent) {
        }

        public boolean y() {
            return false;
        }

        public boolean zn(int i, Bundle bundle) {
            return false;
        }

        public /* synthetic */ v(ViewPager2 viewPager2, y yVar) {
            this();
        }

        public void i9(@NonNull j5.zn znVar) {
        }
    }

    /* loaded from: classes.dex */
    public static class wz implements Runnable {

        /* renamed from: v  reason: collision with root package name */
        public final RecyclerView f3662v;
        public final int y;

        public wz(int i, RecyclerView recyclerView) {
            this.y = i;
            this.f3662v = recyclerView;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f3662v.smoothScrollToPosition(this.y);
        }
    }

    /* loaded from: classes.dex */
    public class y extends fb {
        public y() {
            super(null);
        }

        @Override // androidx.viewpager2.widget.ViewPager2.fb, androidx.recyclerview.widget.RecyclerView.i9
        public void onChanged() {
            ViewPager2 viewPager2 = ViewPager2.this;
            viewPager2.f3640f = true;
            viewPager2.f3641f3.t();
        }
    }

    /* loaded from: classes.dex */
    public class zn extends c5 {
        public zn() {
        }

        @Override // androidx.viewpager2.widget.ViewPager2.c5
        public void onPageSelected(int i) {
            ViewPager2.this.clearFocus();
            if (ViewPager2.this.hasFocus()) {
                ViewPager2.this.f3652z.requestFocus(2);
            }
        }
    }

    public ViewPager2(@NonNull Context context) {
        super(context);
        this.y = new Rect();
        this.f3649v = new Rect();
        this.f3642fb = new androidx.viewpager2.widget.y(3);
        this.f3640f = false;
        this.f3648t = new y();
        this.f3645p = -1;
        this.f3643fh = null;
        this.f3637d = false;
        this.f3639ej = true;
        this.f3651x = -1;
        n3(context, null);
    }

    public final void a(@Nullable RecyclerView.s<?> sVar) {
        if (sVar != null) {
            sVar.registerAdapterDataObserver(this.f3648t);
        }
    }

    public final void c5() {
        RecyclerView.s adapter;
        if (this.f3645p == -1 || (adapter = getAdapter()) == null) {
            return;
        }
        Parcelable parcelable = this.f3636co;
        if (parcelable != null) {
            if (adapter instanceof ad.n3) {
                ((ad.n3) adapter).y(parcelable);
            }
            this.f3636co = null;
        }
        int max = Math.max(0, Math.min(this.f3645p, adapter.getItemCount() - 1));
        this.f3647s = max;
        this.f3645p = -1;
        this.f3652z.scrollToPosition(max);
        this.f3634b.tl();
    }

    @Override // android.view.View
    public boolean canScrollHorizontally(int i) {
        return this.f3652z.canScrollHorizontally(i);
    }

    @Override // android.view.View
    public boolean canScrollVertically(int i) {
        return this.f3652z.canScrollVertically(i);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        Parcelable parcelable = sparseArray.get(getId());
        if (parcelable instanceof SavedState) {
            int i = ((SavedState) parcelable).y;
            sparseArray.put(this.f3652z.getId(), sparseArray.get(i));
            sparseArray.remove(i);
        }
        super.dispatchRestoreInstanceState(sparseArray);
        c5();
    }

    public void f(int i, boolean z2) {
        int i5;
        RecyclerView.s adapter = getAdapter();
        if (adapter == null) {
            if (this.f3645p != -1) {
                this.f3645p = Math.max(i, 0);
            }
        } else if (adapter.getItemCount() <= 0) {
        } else {
            int min = Math.min(Math.max(i, 0), adapter.getItemCount() - 1);
            if (min == this.f3647s && this.f3641f3.i9()) {
                return;
            }
            int i6 = this.f3647s;
            if (min == i6 && z2) {
                return;
            }
            double d2 = i6;
            this.f3647s = min;
            this.f3634b.p();
            if (!this.f3641f3.i9()) {
                d2 = this.f3641f3.fb();
            }
            this.f3641f3.tl(min, z2);
            if (!z2) {
                this.f3652z.scrollToPosition(min);
                return;
            }
            double d3 = min;
            if (Math.abs(d3 - d2) > 3.0d) {
                RecyclerView recyclerView = this.f3652z;
                if (d3 > d2) {
                    i5 = min - 3;
                } else {
                    i5 = min + 3;
                }
                recyclerView.scrollToPosition(i5);
                RecyclerView recyclerView2 = this.f3652z;
                recyclerView2.post(new wz(min, recyclerView2));
                return;
            }
            this.f3652z.smoothScrollToPosition(min);
        }
    }

    public void fb(@NonNull c5 c5Var) {
        this.f3642fb.y(c5Var);
    }

    @Override // android.view.ViewGroup, android.view.View
    public CharSequence getAccessibilityClassName() {
        if (this.f3634b.y()) {
            return this.f3634b.fb();
        }
        return super.getAccessibilityClassName();
    }

    @Nullable
    public RecyclerView.s getAdapter() {
        return this.f3652z.getAdapter();
    }

    public int getCurrentItem() {
        return this.f3647s;
    }

    public int getItemDecorationCount() {
        return this.f3652z.getItemDecorationCount();
    }

    public int getOffscreenPageLimit() {
        return this.f3651x;
    }

    public int getOrientation() {
        return this.f3650w.j4();
    }

    public int getPageSize() {
        int height;
        int paddingBottom;
        RecyclerView recyclerView = this.f3652z;
        if (getOrientation() == 0) {
            height = recyclerView.getWidth() - recyclerView.getPaddingLeft();
            paddingBottom = recyclerView.getPaddingRight();
        } else {
            height = recyclerView.getHeight() - recyclerView.getPaddingTop();
            paddingBottom = recyclerView.getPaddingBottom();
        }
        return height - paddingBottom;
    }

    public int getScrollState() {
        return this.f3641f3.s();
    }

    public boolean gv() {
        if (this.f3650w.nf() == 1) {
            return true;
        }
        return false;
    }

    public void i9(int i, boolean z2) {
        if (!zn()) {
            f(i, z2);
            return;
        }
        throw new IllegalStateException("Cannot change current item when ViewPager2 is fake dragging");
    }

    public final void n3(Context context, AttributeSet attributeSet) {
        v aVar;
        if (f3633j5) {
            aVar = new i9();
        } else {
            aVar = new a();
        }
        this.f3634b = aVar;
        tl tlVar = new tl(context);
        this.f3652z = tlVar;
        tlVar.setId(i4.tl());
        this.f3652z.setDescendantFocusability(131072);
        s sVar = new s(context);
        this.f3650w = sVar;
        this.f3652z.setLayoutManager(sVar);
        this.f3652z.setScrollingTouchSlop(1);
        t(context, attributeSet);
        this.f3652z.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.f3652z.addOnChildAttachStateChangeListener(y());
        androidx.viewpager2.widget.v vVar = new androidx.viewpager2.widget.v(this);
        this.f3641f3 = vVar;
        this.f3635c = new cy.n3(this, vVar, this.f3652z);
        t tVar = new t();
        this.f3646r = tVar;
        tVar.n3(this.f3652z);
        this.f3652z.addOnScrollListener(this.f3641f3);
        androidx.viewpager2.widget.y yVar = new androidx.viewpager2.widget.y(3);
        this.f3644n = yVar;
        this.f3641f3.xc(yVar);
        n3 n3Var = new n3();
        zn znVar = new zn();
        this.f3644n.y(n3Var);
        this.f3644n.y(znVar);
        this.f3634b.s(this.f3644n, this.f3652z);
        this.f3644n.y(this.f3642fb);
        androidx.viewpager2.widget.gv gvVar = new androidx.viewpager2.widget.gv(this.f3650w);
        this.f3638d0 = gvVar;
        this.f3644n.y(gvVar);
        RecyclerView recyclerView = this.f3652z;
        attachViewToParent(recyclerView, 0, recyclerView.getLayoutParams());
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        this.f3634b.c5(accessibilityNodeInfo);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z2, int i, int i5, int i6, int i8) {
        int measuredWidth = this.f3652z.getMeasuredWidth();
        int measuredHeight = this.f3652z.getMeasuredHeight();
        this.y.left = getPaddingLeft();
        this.y.right = (i6 - i) - getPaddingRight();
        this.y.top = getPaddingTop();
        this.y.bottom = (i8 - i5) - getPaddingBottom();
        Gravity.apply(8388659, measuredWidth, measuredHeight, this.y, this.f3649v);
        RecyclerView recyclerView = this.f3652z;
        Rect rect = this.f3649v;
        recyclerView.layout(rect.left, rect.top, rect.right, rect.bottom);
        if (this.f3640f) {
            xc();
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i5) {
        measureChild(this.f3652z, i, i5);
        int measuredWidth = this.f3652z.getMeasuredWidth();
        int measuredHeight = this.f3652z.getMeasuredHeight();
        int measuredState = this.f3652z.getMeasuredState();
        int paddingLeft = measuredWidth + getPaddingLeft() + getPaddingRight();
        int paddingTop = measuredHeight + getPaddingTop() + getPaddingBottom();
        setMeasuredDimension(View.resolveSizeAndState(Math.max(paddingLeft, getSuggestedMinimumWidth()), i, measuredState), View.resolveSizeAndState(Math.max(paddingTop, getSuggestedMinimumHeight()), i5, measuredState << 16));
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.f3645p = savedState.f3654v;
        this.f3636co = savedState.f3653fb;
    }

    @Override // android.view.View
    @Nullable
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.y = this.f3652z.getId();
        int i = this.f3645p;
        if (i == -1) {
            i = this.f3647s;
        }
        savedState.f3654v = i;
        Parcelable parcelable = this.f3636co;
        if (parcelable != null) {
            savedState.f3653fb = parcelable;
        } else {
            RecyclerView.s adapter = this.f3652z.getAdapter();
            if (adapter instanceof ad.n3) {
                savedState.f3653fb = ((ad.n3) adapter).saveState();
            }
        }
        return savedState;
    }

    @Override // android.view.ViewGroup
    public void onViewAdded(View view) {
        throw new IllegalStateException(ViewPager2.class.getSimpleName() + " does not support direct child views");
    }

    @Override // android.view.View
    public boolean performAccessibilityAction(int i, Bundle bundle) {
        if (this.f3634b.zn(i, bundle)) {
            return this.f3634b.t(i, bundle);
        }
        return super.performAccessibilityAction(i, bundle);
    }

    public void s() {
        if (this.f3638d0.y() == null) {
            return;
        }
        double fb2 = this.f3641f3.fb();
        int i = (int) fb2;
        float f4 = (float) (fb2 - i);
        this.f3638d0.onPageScrolled(i, f4, Math.round(getPageSize() * f4));
    }

    public void setAdapter(@Nullable RecyclerView.s sVar) {
        RecyclerView.s adapter = this.f3652z.getAdapter();
        this.f3634b.a(adapter);
        tl(adapter);
        this.f3652z.setAdapter(sVar);
        this.f3647s = 0;
        c5();
        this.f3634b.v(sVar);
        a(sVar);
    }

    public void setCurrentItem(int i) {
        i9(i, true);
    }

    @Override // android.view.View
    public void setLayoutDirection(int i) {
        super.setLayoutDirection(i);
        this.f3634b.w();
    }

    public void setOffscreenPageLimit(int i) {
        if (i < 1 && i != -1) {
            throw new IllegalArgumentException("Offscreen page limit must be OFFSCREEN_PAGE_LIMIT_DEFAULT or a number > 0");
        }
        this.f3651x = i;
        this.f3652z.requestLayout();
    }

    public void setOrientation(int i) {
        this.f3650w.y0(i);
        this.f3634b.mt();
    }

    public void setPageTransformer(@Nullable f fVar) {
        if (fVar != null) {
            if (!this.f3637d) {
                this.f3643fh = this.f3652z.getItemAnimator();
                this.f3637d = true;
            }
            this.f3652z.setItemAnimator(null);
        } else if (this.f3637d) {
            this.f3652z.setItemAnimator(this.f3643fh);
            this.f3643fh = null;
            this.f3637d = false;
        }
        if (fVar == this.f3638d0.y()) {
            return;
        }
        this.f3638d0.n3(fVar);
        s();
    }

    public void setUserInputEnabled(boolean z2) {
        this.f3639ej = z2;
        this.f3634b.co();
    }

    public final void t(Context context, AttributeSet attributeSet) {
        int[] iArr = R$styleable.f3607fb;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr);
        if (Build.VERSION.SDK_INT >= 29) {
            saveAttributeDataForStyleable(context, iArr, attributeSet, obtainStyledAttributes, 0, 0);
        }
        try {
            setOrientation(obtainStyledAttributes.getInt(R$styleable.f3610s, 0));
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public final void tl(@Nullable RecyclerView.s<?> sVar) {
        if (sVar != null) {
            sVar.unregisterAdapterDataObserver(this.f3648t);
        }
    }

    public boolean v() {
        return this.f3639ej;
    }

    public void wz(@NonNull c5 c5Var) {
        this.f3642fb.n3(c5Var);
    }

    public void xc() {
        androidx.recyclerview.widget.t tVar = this.f3646r;
        if (tVar != null) {
            View fb2 = tVar.fb(this.f3650w);
            if (fb2 == null) {
                return;
            }
            int ap2 = this.f3650w.ap(fb2);
            if (ap2 != this.f3647s && getScrollState() == 0) {
                this.f3644n.onPageSelected(ap2);
            }
            this.f3640f = false;
            return;
        }
        throw new IllegalStateException("Design assumption violated.");
    }

    public final RecyclerView.mt y() {
        return new gv();
    }

    public boolean zn() {
        return this.f3635c.y();
    }

    /* loaded from: classes.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new y();

        /* renamed from: fb  reason: collision with root package name */
        public Parcelable f3653fb;

        /* renamed from: v  reason: collision with root package name */
        public int f3654v;
        public int y;

        /* loaded from: classes.dex */
        public static class y implements Parcelable.ClassLoaderCreator<SavedState> {
            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: n3 */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                if (Build.VERSION.SDK_INT >= 24) {
                    return new SavedState(parcel, classLoader);
                }
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: y */
            public SavedState createFromParcel(Parcel parcel) {
                return createFromParcel(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: zn */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            y(parcel, classLoader);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.y);
            parcel.writeInt(this.f3654v);
            parcel.writeParcelable(this.f3653fb, i);
        }

        public final void y(Parcel parcel, ClassLoader classLoader) {
            this.y = parcel.readInt();
            this.f3654v = parcel.readInt();
            this.f3653fb = parcel.readParcelable(classLoader);
        }

        public SavedState(Parcel parcel) {
            super(parcel);
            y(parcel, null);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public ViewPager2(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.y = new Rect();
        this.f3649v = new Rect();
        this.f3642fb = new androidx.viewpager2.widget.y(3);
        this.f3640f = false;
        this.f3648t = new y();
        this.f3645p = -1;
        this.f3643fh = null;
        this.f3637d = false;
        this.f3639ej = true;
        this.f3651x = -1;
        n3(context, attributeSet);
    }
}
