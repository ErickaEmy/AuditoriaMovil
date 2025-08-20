package com.google.android.material.bottomappbar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.R$dimen;
import com.google.android.material.R$style;
import com.google.android.material.behavior.HideBottomViewOnScrollBehavior;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import hw.i4;
import hx.s;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import ur.f;
/* loaded from: classes.dex */
public class BottomAppBar extends Toolbar implements CoordinatorLayout.n3 {

    /* renamed from: cr  reason: collision with root package name */
    public static final int f5413cr = R$style.z8;
    @Nullable

    /* renamed from: ap  reason: collision with root package name */
    public Animator f5414ap;

    /* renamed from: bk  reason: collision with root package name */
    public Behavior f5415bk;

    /* renamed from: e  reason: collision with root package name */
    public final hx.fb f5416e;

    /* renamed from: g  reason: collision with root package name */
    public boolean f5417g;

    /* renamed from: g3  reason: collision with root package name */
    public ArrayList<fb> f5418g3;

    /* renamed from: kp  reason: collision with root package name */
    public boolean f5419kp;

    /* renamed from: m  reason: collision with root package name */
    public int f5420m;
    @NonNull

    /* renamed from: pq  reason: collision with root package name */
    public AnimatorListenerAdapter f5421pq;

    /* renamed from: pz  reason: collision with root package name */
    public int f5422pz;

    /* renamed from: ra  reason: collision with root package name */
    public final int f5423ra;

    /* renamed from: rb  reason: collision with root package name */
    public int f5424rb;
    @Nullable

    /* renamed from: s8  reason: collision with root package name */
    public Animator f5425s8;

    /* renamed from: tg  reason: collision with root package name */
    public int f5426tg;

    /* renamed from: u0  reason: collision with root package name */
    public boolean f5427u0;

    /* renamed from: y4  reason: collision with root package name */
    public int f5428y4;

    /* renamed from: yc  reason: collision with root package name */
    public int f5429yc;

    /* renamed from: yg  reason: collision with root package name */
    public int f5430yg;

    /* loaded from: classes.dex */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new y();

        /* renamed from: fb  reason: collision with root package name */
        public int f5435fb;

        /* renamed from: s  reason: collision with root package name */
        public boolean f5436s;

        /* loaded from: classes.dex */
        public static class y implements Parcelable.ClassLoaderCreator<SavedState> {
            @Override // android.os.Parcelable.ClassLoaderCreator
            @NonNull
            /* renamed from: n3 */
            public SavedState createFromParcel(@NonNull Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            @Nullable
            /* renamed from: y */
            public SavedState createFromParcel(@NonNull Parcel parcel) {
                return new SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            @NonNull
            /* renamed from: zn */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(@NonNull Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f5435fb);
            parcel.writeInt(this.f5436s ? 1 : 0);
        }

        public SavedState(@NonNull Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f5435fb = parcel.readInt();
            this.f5436s = parcel.readInt() != 0;
        }
    }

    /* loaded from: classes.dex */
    public class a extends AnimatorListenerAdapter {
        public a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            BottomAppBar.this.f5421pq.onAnimationStart(animator);
            FloatingActionButton s82 = BottomAppBar.this.s8();
            if (s82 != null) {
                s82.setTranslationX(BottomAppBar.this.getFabTranslationX());
            }
        }
    }

    /* loaded from: classes.dex */
    public interface fb {
        void n3(BottomAppBar bottomAppBar);

        void y(BottomAppBar bottomAppBar);
    }

    /* loaded from: classes.dex */
    public class gv extends AnimatorListenerAdapter {

        /* renamed from: gv  reason: collision with root package name */
        public final /* synthetic */ boolean f5437gv;

        /* renamed from: n3  reason: collision with root package name */
        public final /* synthetic */ ActionMenuView f5438n3;
        public boolean y;

        /* renamed from: zn  reason: collision with root package name */
        public final /* synthetic */ int f5440zn;

        public gv(ActionMenuView actionMenuView, int i, boolean z2) {
            this.f5438n3 = actionMenuView;
            this.f5440zn = i;
            this.f5437gv = z2;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.y = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            boolean z2;
            if (!this.y) {
                if (BottomAppBar.this.f5420m != 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                BottomAppBar bottomAppBar = BottomAppBar.this;
                bottomAppBar.m(bottomAppBar.f5420m);
                BottomAppBar.this.pz(this.f5438n3, this.f5440zn, this.f5437gv, z2);
            }
        }
    }

    /* loaded from: classes.dex */
    public class n3 extends FloatingActionButton.n3 {
        public final /* synthetic */ int y;

        /* loaded from: classes.dex */
        public class y extends FloatingActionButton.n3 {
            public y() {
            }

            @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.n3
            public void n3(FloatingActionButton floatingActionButton) {
                BottomAppBar.this.ra();
            }
        }

        public n3(int i) {
            this.y = i;
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.n3
        public void y(@NonNull FloatingActionButton floatingActionButton) {
            floatingActionButton.setTranslationX(BottomAppBar.this.yc(this.y));
            floatingActionButton.co(new y());
        }
    }

    /* loaded from: classes.dex */
    public class v implements Runnable {

        /* renamed from: fb  reason: collision with root package name */
        public final /* synthetic */ boolean f5442fb;

        /* renamed from: v  reason: collision with root package name */
        public final /* synthetic */ int f5444v;
        public final /* synthetic */ ActionMenuView y;

        public v(ActionMenuView actionMenuView, int i, boolean z2) {
            this.y = actionMenuView;
            this.f5444v = i;
            this.f5442fb = z2;
        }

        @Override // java.lang.Runnable
        public void run() {
            ActionMenuView actionMenuView = this.y;
            actionMenuView.setTranslationX(BottomAppBar.this.yg(actionMenuView, this.f5444v, this.f5442fb));
        }
    }

    /* loaded from: classes.dex */
    public class y extends AnimatorListenerAdapter {
        public y() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            BottomAppBar.this.ra();
            BottomAppBar.this.f5425s8 = null;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            BottomAppBar.this.e();
        }
    }

    /* loaded from: classes.dex */
    public class zn extends AnimatorListenerAdapter {
        public zn() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            BottomAppBar.this.ra();
            BottomAppBar.this.f5417g = false;
            BottomAppBar.this.f5414ap = null;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            BottomAppBar.this.e();
        }
    }

    @Nullable
    private ActionMenuView getActionMenuView() {
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (childAt instanceof ActionMenuView) {
                return (ActionMenuView) childAt;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getBottomInset() {
        return this.f5428y4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float getFabTranslationX() {
        return yc(this.f5430yg);
    }

    private float getFabTranslationY() {
        return -getTopEdgeTreatment().gv();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getLeftInset() {
        return this.f5422pz;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getRightInset() {
        return this.f5426tg;
    }

    @NonNull
    private oq.y getTopEdgeTreatment() {
        return (oq.y) this.f5416e.rz().w();
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x001e  */
    @androidx.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.view.View ap() {
        /*
            r4 = this;
            android.view.ViewParent r0 = r4.getParent()
            boolean r0 = r0 instanceof androidx.coordinatorlayout.widget.CoordinatorLayout
            r1 = 0
            if (r0 != 0) goto La
            return r1
        La:
            android.view.ViewParent r0 = r4.getParent()
            androidx.coordinatorlayout.widget.CoordinatorLayout r0 = (androidx.coordinatorlayout.widget.CoordinatorLayout) r0
            java.util.List r0 = r0.co(r4)
            java.util.Iterator r0 = r0.iterator()
        L18:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L2d
            java.lang.Object r2 = r0.next()
            android.view.View r2 = (android.view.View) r2
            boolean r3 = r2 instanceof com.google.android.material.floatingactionbutton.FloatingActionButton
            if (r3 != 0) goto L2c
            boolean r3 = r2 instanceof com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton
            if (r3 == 0) goto L18
        L2c:
            return r2
        L2d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomappbar.BottomAppBar.ap():android.view.View");
    }

    public void bk(int i, int i5) {
        this.f5420m = i5;
        this.f5417g = true;
        rb(i, this.f5427u0);
        g3(i);
        this.f5430yg = i;
    }

    public final void e() {
        ArrayList<fb> arrayList;
        int i = this.f5424rb;
        this.f5424rb = i + 1;
        if (i == 0 && (arrayList = this.f5418g3) != null) {
            Iterator<fb> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().n3(this);
            }
        }
    }

    public void eb(int i, List<Animator> list) {
        FloatingActionButton s82 = s8();
        if (s82 != null && !s82.wz()) {
            e();
            s82.t(new n3(i));
        }
    }

    public final void g() {
        ActionMenuView actionMenuView = getActionMenuView();
        if (actionMenuView != null && this.f5414ap == null) {
            actionMenuView.setAlpha(1.0f);
            if (!kp()) {
                tg(actionMenuView, 0, false);
            } else {
                tg(actionMenuView, this.f5430yg, this.f5427u0);
            }
        }
    }

    public final void g3(int i) {
        if (this.f5430yg != i && i4.q9(this)) {
            Animator animator = this.f5425s8;
            if (animator != null) {
                animator.cancel();
            }
            ArrayList arrayList = new ArrayList();
            if (this.f5429yc == 1) {
                lc(i, arrayList);
            } else {
                eb(i, arrayList);
            }
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(arrayList);
            this.f5425s8 = animatorSet;
            animatorSet.addListener(new y());
            this.f5425s8.start();
        }
    }

    @Nullable
    public ColorStateList getBackgroundTint() {
        return this.f5416e.ta();
    }

    public float getCradleVerticalOffset() {
        return getTopEdgeTreatment().gv();
    }

    public int getFabAlignmentMode() {
        return this.f5430yg;
    }

    public int getFabAnimationMode() {
        return this.f5429yc;
    }

    public float getFabCradleMargin() {
        return getTopEdgeTreatment().a();
    }

    public float getFabCradleRoundedCornerRadius() {
        return getTopEdgeTreatment().fb();
    }

    public boolean getHideOnScroll() {
        return this.f5419kp;
    }

    public final boolean kp() {
        FloatingActionButton s82 = s8();
        if (s82 != null && s82.xc()) {
            return true;
        }
        return false;
    }

    public final void lc(int i, @NonNull List<Animator> list) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(s8(), "translationX", yc(i));
        ofFloat.setDuration(300L);
        list.add(ofFloat);
    }

    public void m(int i) {
        if (i != 0) {
            this.f5420m = 0;
            getMenu().clear();
            f3(i);
        }
    }

    public final void nf(int i, boolean z2, @NonNull List<Animator> list) {
        ActionMenuView actionMenuView = getActionMenuView();
        if (actionMenuView == null) {
            return;
        }
        Animator ofFloat = ObjectAnimator.ofFloat(actionMenuView, "alpha", 1.0f);
        if (Math.abs(actionMenuView.getTranslationX() - yg(actionMenuView, i, z2)) > 1.0f) {
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(actionMenuView, "alpha", 0.0f);
            ofFloat2.addListener(new gv(actionMenuView, i, z2));
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setDuration(150L);
            animatorSet.playSequentially(ofFloat2, ofFloat);
            list.add(animatorSet);
        } else if (actionMenuView.getAlpha() < 1.0f) {
            list.add(ofFloat);
        }
    }

    public final void o4(@NonNull FloatingActionButton floatingActionButton) {
        floatingActionButton.v(this.f5421pq);
        floatingActionButton.a(new a());
        floatingActionButton.fb(null);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        s.a(this, this.f5416e);
        if (getParent() instanceof ViewGroup) {
            ((ViewGroup) getParent()).setClipChildren(false);
        }
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z2, int i, int i5, int i6, int i8) {
        super.onLayout(z2, i, i5, i6, i8);
        if (z2) {
            rs();
            u0();
        }
        g();
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.y());
        this.f5430yg = savedState.f5435fb;
        this.f5427u0 = savedState.f5436s;
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.View
    @NonNull
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f5435fb = this.f5430yg;
        savedState.f5436s = this.f5427u0;
        return savedState;
    }

    public final void pz(@NonNull ActionMenuView actionMenuView, int i, boolean z2, boolean z3) {
        v vVar = new v(actionMenuView, i, z2);
        if (z3) {
            actionMenuView.post(vVar);
        } else {
            vVar.run();
        }
    }

    public final void ra() {
        ArrayList<fb> arrayList;
        int i = this.f5424rb - 1;
        this.f5424rb = i;
        if (i == 0 && (arrayList = this.f5418g3) != null) {
            Iterator<fb> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().y(this);
            }
        }
    }

    public final void rb(int i, boolean z2) {
        if (!i4.q9(this)) {
            this.f5417g = false;
            m(this.f5420m);
            return;
        }
        Animator animator = this.f5414ap;
        if (animator != null) {
            animator.cancel();
        }
        ArrayList arrayList = new ArrayList();
        if (!kp()) {
            i = 0;
            z2 = false;
        }
        nf(i, z2, arrayList);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(arrayList);
        this.f5414ap = animatorSet;
        animatorSet.addListener(new zn());
        this.f5414ap.start();
    }

    public final void rs() {
        Animator animator = this.f5414ap;
        if (animator != null) {
            animator.cancel();
        }
        Animator animator2 = this.f5425s8;
        if (animator2 != null) {
            animator2.cancel();
        }
    }

    @Nullable
    public final FloatingActionButton s8() {
        View ap2 = ap();
        if (ap2 instanceof FloatingActionButton) {
            return (FloatingActionButton) ap2;
        }
        return null;
    }

    public void setBackgroundTint(@Nullable ColorStateList colorStateList) {
        ej.y.xc(this.f5416e, colorStateList);
    }

    public void setCradleVerticalOffset(float f4) {
        if (f4 != getCradleVerticalOffset()) {
            getTopEdgeTreatment().c5(f4);
            this.f5416e.invalidateSelf();
            u0();
        }
    }

    @Override // android.view.View
    public void setElevation(float f4) {
        this.f5416e.q9(f4);
        getBehavior().z6(this, this.f5416e.fh() - this.f5416e.d0());
    }

    public void setFabAlignmentMode(int i) {
        bk(i, 0);
    }

    public void setFabAnimationMode(int i) {
        this.f5429yc = i;
    }

    public void setFabCradleMargin(float f4) {
        if (f4 != getFabCradleMargin()) {
            getTopEdgeTreatment().i9(f4);
            this.f5416e.invalidateSelf();
        }
    }

    public void setFabCradleRoundedCornerRadius(float f4) {
        if (f4 != getFabCradleRoundedCornerRadius()) {
            getTopEdgeTreatment().f(f4);
            this.f5416e.invalidateSelf();
        }
    }

    public void setHideOnScroll(boolean z2) {
        this.f5419kp = z2;
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setSubtitle(CharSequence charSequence) {
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setTitle(CharSequence charSequence) {
    }

    public final void tg(@NonNull ActionMenuView actionMenuView, int i, boolean z2) {
        pz(actionMenuView, i, z2, false);
    }

    public final void u0() {
        float f4;
        getTopEdgeTreatment().tl(getFabTranslationX());
        View ap2 = ap();
        hx.fb fbVar = this.f5416e;
        if (this.f5427u0 && kp()) {
            f4 = 1.0f;
        } else {
            f4 = 0.0f;
        }
        fbVar.f7(f4);
        if (ap2 != null) {
            ap2.setTranslationY(getFabTranslationY());
            ap2.setTranslationX(getFabTranslationX());
        }
    }

    public boolean y4(int i) {
        float f4 = i;
        if (f4 != getTopEdgeTreatment().s()) {
            getTopEdgeTreatment().t(f4);
            this.f5416e.invalidateSelf();
            return true;
        }
        return false;
    }

    public final float yc(int i) {
        int i5;
        boolean gv2 = f.gv(this);
        int i6 = 1;
        if (i == 1) {
            if (gv2) {
                i5 = this.f5422pz;
            } else {
                i5 = this.f5426tg;
            }
            int measuredWidth = (getMeasuredWidth() / 2) - (this.f5423ra + i5);
            if (gv2) {
                i6 = -1;
            }
            return measuredWidth * i6;
        }
        return 0.0f;
    }

    public int yg(@NonNull ActionMenuView actionMenuView, int i, boolean z2) {
        int i5;
        int left;
        int i6;
        if (i != 1 || !z2) {
            return 0;
        }
        boolean gv2 = f.gv(this);
        if (gv2) {
            i5 = getMeasuredWidth();
        } else {
            i5 = 0;
        }
        for (int i8 = 0; i8 < getChildCount(); i8++) {
            View childAt = getChildAt(i8);
            if ((childAt.getLayoutParams() instanceof Toolbar.v) && (((Toolbar.v) childAt.getLayoutParams()).y & 8388615) == 8388611) {
                if (gv2) {
                    i5 = Math.min(i5, childAt.getLeft());
                } else {
                    i5 = Math.max(i5, childAt.getRight());
                }
            }
        }
        if (gv2) {
            left = actionMenuView.getRight();
        } else {
            left = actionMenuView.getLeft();
        }
        if (gv2) {
            i6 = this.f5426tg;
        } else {
            i6 = -this.f5422pz;
        }
        return i5 - (left + i6);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.n3
    @NonNull
    public Behavior getBehavior() {
        if (this.f5415bk == null) {
            this.f5415bk = new Behavior();
        }
        return this.f5415bk;
    }

    /* loaded from: classes.dex */
    public static class Behavior extends HideBottomViewOnScrollBehavior<BottomAppBar> {

        /* renamed from: a  reason: collision with root package name */
        public WeakReference<BottomAppBar> f5431a;

        /* renamed from: fb  reason: collision with root package name */
        public int f5432fb;

        /* renamed from: s  reason: collision with root package name */
        public final View.OnLayoutChangeListener f5433s;
        @NonNull

        /* renamed from: v  reason: collision with root package name */
        public final Rect f5434v;

        /* loaded from: classes.dex */
        public class y implements View.OnLayoutChangeListener {
            public y() {
            }

            @Override // android.view.View.OnLayoutChangeListener
            public void onLayoutChange(View view, int i, int i5, int i6, int i8, int i10, int i11, int i12, int i13) {
                BottomAppBar bottomAppBar = (BottomAppBar) Behavior.this.f5431a.get();
                if (bottomAppBar != null && (view instanceof FloatingActionButton)) {
                    FloatingActionButton floatingActionButton = (FloatingActionButton) view;
                    floatingActionButton.i9(Behavior.this.f5434v);
                    int height = Behavior.this.f5434v.height();
                    bottomAppBar.y4(height);
                    CoordinatorLayout.a aVar = (CoordinatorLayout.a) view.getLayoutParams();
                    if (Behavior.this.f5432fb == 0) {
                        ((ViewGroup.MarginLayoutParams) aVar).bottomMargin = bottomAppBar.getBottomInset() + (bottomAppBar.getResources().getDimensionPixelOffset(R$dimen.d2) - ((floatingActionButton.getMeasuredHeight() - height) / 2));
                        ((ViewGroup.MarginLayoutParams) aVar).leftMargin = bottomAppBar.getLeftInset();
                        ((ViewGroup.MarginLayoutParams) aVar).rightMargin = bottomAppBar.getRightInset();
                        if (f.gv(floatingActionButton)) {
                            ((ViewGroup.MarginLayoutParams) aVar).leftMargin += bottomAppBar.f5423ra;
                            return;
                        } else {
                            ((ViewGroup.MarginLayoutParams) aVar).rightMargin += bottomAppBar.f5423ra;
                            return;
                        }
                    }
                    return;
                }
                view.removeOnLayoutChangeListener(this);
            }
        }

        public Behavior() {
            this.f5433s = new y();
            this.f5434v = new Rect();
        }

        @Override // com.google.android.material.behavior.HideBottomViewOnScrollBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.zn
        /* renamed from: k5 */
        public boolean t(@NonNull CoordinatorLayout coordinatorLayout, @NonNull BottomAppBar bottomAppBar, int i) {
            this.f5431a = new WeakReference<>(bottomAppBar);
            View ap2 = bottomAppBar.ap();
            if (ap2 != null && !i4.q9(ap2)) {
                CoordinatorLayout.a aVar = (CoordinatorLayout.a) ap2.getLayoutParams();
                aVar.f2076gv = 49;
                this.f5432fb = ((ViewGroup.MarginLayoutParams) aVar).bottomMargin;
                if (ap2 instanceof FloatingActionButton) {
                    FloatingActionButton floatingActionButton = (FloatingActionButton) ap2;
                    floatingActionButton.addOnLayoutChangeListener(this.f5433s);
                    bottomAppBar.o4(floatingActionButton);
                }
                bottomAppBar.u0();
            }
            coordinatorLayout.ud(bottomAppBar, i);
            return super.t(coordinatorLayout, bottomAppBar, i);
        }

        @Override // com.google.android.material.behavior.HideBottomViewOnScrollBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.zn
        /* renamed from: yt */
        public boolean d0(@NonNull CoordinatorLayout coordinatorLayout, @NonNull BottomAppBar bottomAppBar, @NonNull View view, @NonNull View view2, int i, int i5) {
            if (bottomAppBar.getHideOnScroll() && super.d0(coordinatorLayout, bottomAppBar, view, view2, i, i5)) {
                return true;
            }
            return false;
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f5433s = new y();
            this.f5434v = new Rect();
        }
    }
}
