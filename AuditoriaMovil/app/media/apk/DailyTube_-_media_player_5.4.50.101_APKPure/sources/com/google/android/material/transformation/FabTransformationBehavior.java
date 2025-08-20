package com.google.android.material.transformation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Pair;
import android.util.Property;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.R$id;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.uv.v7.R;
import hw.i4;
import i7.gv;
import java.util.ArrayList;
import java.util.List;
import y6.c5;
import y6.i9;
import y6.s;
@Deprecated
/* loaded from: classes.dex */
public abstract class FabTransformationBehavior extends ExpandableTransformationBehavior {

    /* renamed from: a  reason: collision with root package name */
    public final int[] f6131a;

    /* renamed from: fb  reason: collision with root package name */
    public float f6132fb;

    /* renamed from: gv  reason: collision with root package name */
    public final RectF f6133gv;

    /* renamed from: s  reason: collision with root package name */
    public float f6134s;

    /* renamed from: v  reason: collision with root package name */
    public final RectF f6135v;

    /* renamed from: zn  reason: collision with root package name */
    public final Rect f6136zn;

    /* loaded from: classes.dex */
    public class gv extends AnimatorListenerAdapter {
        public final /* synthetic */ i7.gv y;

        public gv(i7.gv gvVar) {
            this.y = gvVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            gv.v revealInfo = this.y.getRevealInfo();
            revealInfo.f9118zn = Float.MAX_VALUE;
            this.y.setRevealInfo(revealInfo);
        }
    }

    /* loaded from: classes.dex */
    public class n3 implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ View y;

        public n3(View view) {
            this.y = view;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.y.invalidate();
        }
    }

    /* loaded from: classes.dex */
    public static class v {

        /* renamed from: n3  reason: collision with root package name */
        public i9 f6139n3;
        @Nullable
        public s y;
    }

    /* loaded from: classes.dex */
    public class y extends AnimatorListenerAdapter {

        /* renamed from: n3  reason: collision with root package name */
        public final /* synthetic */ View f6141n3;
        public final /* synthetic */ boolean y;

        /* renamed from: zn  reason: collision with root package name */
        public final /* synthetic */ View f6142zn;

        public y(boolean z2, View view, View view2) {
            this.y = z2;
            this.f6141n3 = view;
            this.f6142zn = view2;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (!this.y) {
                this.f6141n3.setVisibility(4);
                this.f6142zn.setAlpha(1.0f);
                this.f6142zn.setVisibility(0);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (this.y) {
                this.f6141n3.setVisibility(0);
                this.f6142zn.setAlpha(0.0f);
                this.f6142zn.setVisibility(4);
            }
        }
    }

    /* loaded from: classes.dex */
    public class zn extends AnimatorListenerAdapter {

        /* renamed from: n3  reason: collision with root package name */
        public final /* synthetic */ Drawable f6143n3;
        public final /* synthetic */ i7.gv y;

        public zn(i7.gv gvVar, Drawable drawable) {
            this.y = gvVar;
            this.f6143n3 = drawable;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.y.setCircularRevealOverlayDrawable(null);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            this.y.setCircularRevealOverlayDrawable(this.f6143n3);
        }
    }

    public FabTransformationBehavior() {
        this.f6136zn = new Rect();
        this.f6133gv = new RectF();
        this.f6135v = new RectF();
        this.f6131a = new int[2];
    }

    @Override // com.google.android.material.transformation.ExpandableTransformationBehavior
    @NonNull
    public AnimatorSet a8(@NonNull View view, @NonNull View view2, boolean z2, boolean z3) {
        v dm2 = dm(view2.getContext(), z2);
        if (z2) {
            this.f6132fb = view.getTranslationX();
            this.f6134s = view.getTranslationY();
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        k(view, view2, z2, z3, dm2, arrayList, arrayList2);
        RectF rectF = this.f6133gv;
        y5(view, view2, z2, z3, dm2, arrayList, arrayList2, rectF);
        float width = rectF.width();
        float height = rectF.height();
        q9(view, view2, z2, dm2, arrayList);
        en(view, view2, z2, z3, dm2, arrayList, arrayList2);
        f7(view, view2, z2, z3, dm2, width, height, arrayList, arrayList2);
        ut(view, view2, z2, z3, dm2, arrayList, arrayList2);
        oz(view, view2, z2, z3, dm2, arrayList, arrayList2);
        AnimatorSet animatorSet = new AnimatorSet();
        y6.n3.y(animatorSet, arrayList);
        animatorSet.addListener(new y(z2, view2, view));
        int size = arrayList2.size();
        for (int i = 0; i < size; i++) {
            animatorSet.addListener(arrayList2.get(i));
        }
        return animatorSet;
    }

    public final void b(@NonNull View view, @NonNull v vVar, @NonNull c5 c5Var, @NonNull c5 c5Var2, float f4, float f6, float f9, float f10, @NonNull RectF rectF) {
        float o2 = o(vVar, c5Var, f4, f9);
        float o3 = o(vVar, c5Var2, f6, f10);
        Rect rect = this.f6136zn;
        view.getWindowVisibleDisplayFrame(rect);
        RectF rectF2 = this.f6133gv;
        rectF2.set(rect);
        RectF rectF3 = this.f6135v;
        j(view, rectF3);
        rectF3.offset(o2, o3);
        rectF3.intersect(rectF2);
        rectF.set(rectF3);
    }

    @Nullable
    public final ViewGroup ct(View view) {
        if (view instanceof ViewGroup) {
            return (ViewGroup) view;
        }
        return null;
    }

    public abstract v dm(Context context, boolean z2);

    public final void en(View view, View view2, boolean z2, boolean z3, @NonNull v vVar, @NonNull List<Animator> list, @NonNull List<Animator.AnimatorListener> list2) {
        ObjectAnimator ofInt;
        if ((view2 instanceof i7.gv) && (view instanceof ImageView)) {
            i7.gv gvVar = (i7.gv) view2;
            Drawable drawable = ((ImageView) view).getDrawable();
            if (drawable == null) {
                return;
            }
            drawable.mutate();
            if (z2) {
                if (!z3) {
                    drawable.setAlpha(255);
                }
                ofInt = ObjectAnimator.ofInt(drawable, y6.v.f15323n3, 0);
            } else {
                ofInt = ObjectAnimator.ofInt(drawable, y6.v.f15323n3, 255);
            }
            ofInt.addUpdateListener(new n3(view2));
            vVar.y.v("iconFade").y(ofInt);
            list.add(ofInt);
            list2.add(new zn(gvVar, drawable));
        }
    }

    public final void f7(@NonNull View view, View view2, boolean z2, boolean z3, @NonNull v vVar, float f4, float f6, @NonNull List<Animator> list, @NonNull List<Animator.AnimatorListener> list2) {
        Animator animator;
        if (!(view2 instanceof i7.gv)) {
            return;
        }
        i7.gv gvVar = (i7.gv) view2;
        float vl2 = vl(view, view2, vVar.f6139n3);
        float hw2 = hw(view, view2, vVar.f6139n3);
        ((FloatingActionButton) view).c5(this.f6136zn);
        float width = this.f6136zn.width() / 2.0f;
        c5 v2 = vVar.y.v("expansion");
        if (z2) {
            if (!z3) {
                gvVar.setRevealInfo(new gv.v(vl2, hw2, width));
            }
            if (z3) {
                width = gvVar.getRevealInfo().f9118zn;
            }
            animator = i7.y.y(gvVar, vl2, hw2, s6.y.n3(vl2, hw2, 0.0f, 0.0f, f4, f6));
            animator.addListener(new gv(gvVar));
            u(view2, v2.zn(), (int) vl2, (int) hw2, width, list);
        } else {
            float f9 = gvVar.getRevealInfo().f9118zn;
            Animator y2 = i7.y.y(gvVar, vl2, hw2, width);
            int i = (int) vl2;
            int i5 = (int) hw2;
            u(view2, v2.zn(), i, i5, f9, list);
            jz(view2, v2.zn(), v2.gv(), vVar.y.a(), i, i5, width, list);
            animator = y2;
        }
        v2.y(animator);
        list.add(animator);
        list2.add(i7.y.n3(gvVar));
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.zn
    public void fb(@NonNull CoordinatorLayout.a aVar) {
        if (aVar.f2081s == 0) {
            aVar.f2081s = 80;
        }
    }

    public final float hw(@NonNull View view, @NonNull View view2, @NonNull i9 i9Var) {
        RectF rectF = this.f6133gv;
        RectF rectF2 = this.f6135v;
        k5(view, rectF);
        j(view2, rectF2);
        rectF2.offset(0.0f, -qn(view, view2, i9Var));
        return rectF.centerY() - rectF2.top;
    }

    public final void j(@NonNull View view, RectF rectF) {
        rectF.set(0.0f, 0.0f, view.getWidth(), view.getHeight());
        int[] iArr = this.f6131a;
        view.getLocationInWindow(iArr);
        rectF.offsetTo(iArr[0], iArr[1]);
        rectF.offset((int) (-view.getTranslationX()), (int) (-view.getTranslationY()));
    }

    public final float j5(@NonNull View view, @NonNull View view2, @NonNull i9 i9Var) {
        float centerX;
        float centerX2;
        float f4;
        RectF rectF = this.f6133gv;
        RectF rectF2 = this.f6135v;
        k5(view, rectF);
        j(view2, rectF2);
        int i = i9Var.y & 7;
        if (i != 1) {
            if (i != 3) {
                if (i != 5) {
                    f4 = 0.0f;
                    return f4 + i9Var.f15320n3;
                }
                centerX = rectF2.right;
                centerX2 = rectF.right;
            } else {
                centerX = rectF2.left;
                centerX2 = rectF.left;
            }
        } else {
            centerX = rectF2.centerX();
            centerX2 = rectF.centerX();
        }
        f4 = centerX - centerX2;
        return f4 + i9Var.f15320n3;
    }

    public final void jz(View view, long j2, long j4, long j6, int i, int i5, float f4, @NonNull List<Animator> list) {
        long j7 = j2 + j4;
        if (j7 < j6) {
            Animator createCircularReveal = ViewAnimationUtils.createCircularReveal(view, i, i5, f4, f4);
            createCircularReveal.setStartDelay(j7);
            createCircularReveal.setDuration(j6 - j7);
            list.add(createCircularReveal);
        }
    }

    @TargetApi(21)
    public final void k(View view, @NonNull View view2, boolean z2, boolean z3, @NonNull v vVar, @NonNull List<Animator> list, List<Animator.AnimatorListener> list2) {
        ObjectAnimator ofFloat;
        float n2 = i4.n(view2) - i4.n(view);
        if (z2) {
            if (!z3) {
                view2.setTranslationZ(-n2);
            }
            ofFloat = ObjectAnimator.ofFloat(view2, View.TRANSLATION_Z, 0.0f);
        } else {
            ofFloat = ObjectAnimator.ofFloat(view2, View.TRANSLATION_Z, -n2);
        }
        vVar.y.v("elevation").y(ofFloat);
        list.add(ofFloat);
    }

    public final void k5(@NonNull View view, @NonNull RectF rectF) {
        j(view, rectF);
        rectF.offset(this.f6132fb, this.f6134s);
    }

    public final float o(@NonNull v vVar, @NonNull c5 c5Var, float f4, float f6) {
        long zn2 = c5Var.zn();
        long gv2 = c5Var.gv();
        c5 v2 = vVar.y.v("expansion");
        return y6.y.y(f4, f6, c5Var.v().getInterpolation(((float) (((v2.zn() + v2.gv()) + 17) - zn2)) / ((float) gv2)));
    }

    public final void oz(View view, View view2, boolean z2, boolean z3, @NonNull v vVar, @NonNull List<Animator> list, List<Animator.AnimatorListener> list2) {
        ViewGroup x2;
        ObjectAnimator ofFloat;
        if (!(view2 instanceof ViewGroup)) {
            return;
        }
        if (((view2 instanceof i7.gv) && i7.zn.y == 0) || (x2 = x(view2)) == null) {
            return;
        }
        if (z2) {
            if (!z3) {
                y6.gv.y.set(x2, Float.valueOf(0.0f));
            }
            ofFloat = ObjectAnimator.ofFloat(x2, y6.gv.y, 1.0f);
        } else {
            ofFloat = ObjectAnimator.ofFloat(x2, y6.gv.y, 0.0f);
        }
        vVar.y.v("contentFade").y(ofFloat);
        list.add(ofFloat);
    }

    public final void q9(@NonNull View view, @NonNull View view2, boolean z2, @NonNull v vVar, @NonNull List<Animator> list) {
        float j52 = j5(view, view2, vVar.f6139n3);
        float qn2 = qn(view, view2, vVar.f6139n3);
        Pair<c5, c5> yt2 = yt(j52, qn2, z2, vVar);
        c5 c5Var = (c5) yt2.first;
        c5 c5Var2 = (c5) yt2.second;
        Property property = View.TRANSLATION_X;
        if (!z2) {
            j52 = this.f6132fb;
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, property, j52);
        Property property2 = View.TRANSLATION_Y;
        if (!z2) {
            qn2 = this.f6134s;
        }
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, property2, qn2);
        c5Var.y(ofFloat);
        c5Var2.y(ofFloat2);
        list.add(ofFloat);
        list.add(ofFloat2);
    }

    public final float qn(@NonNull View view, @NonNull View view2, @NonNull i9 i9Var) {
        float centerY;
        float centerY2;
        float f4;
        RectF rectF = this.f6133gv;
        RectF rectF2 = this.f6135v;
        k5(view, rectF);
        j(view2, rectF2);
        int i = i9Var.y & R.styleable.AppCompatTheme_toolbarNavigationButtonStyle;
        if (i != 16) {
            if (i != 48) {
                if (i != 80) {
                    f4 = 0.0f;
                    return f4 + i9Var.f15321zn;
                }
                centerY = rectF2.bottom;
                centerY2 = rectF.bottom;
            } else {
                centerY = rectF2.top;
                centerY2 = rectF.top;
            }
        } else {
            centerY = rectF2.centerY();
            centerY2 = rectF.centerY();
        }
        f4 = centerY - centerY2;
        return f4 + i9Var.f15321zn;
    }

    public final void u(View view, long j2, int i, int i5, float f4, @NonNull List<Animator> list) {
        if (j2 > 0) {
            Animator createCircularReveal = ViewAnimationUtils.createCircularReveal(view, i, i5, f4, f4);
            createCircularReveal.setStartDelay(0L);
            createCircularReveal.setDuration(j2);
            list.add(createCircularReveal);
        }
    }

    public final void ut(@NonNull View view, View view2, boolean z2, boolean z3, @NonNull v vVar, @NonNull List<Animator> list, List<Animator.AnimatorListener> list2) {
        ObjectAnimator ofInt;
        if (!(view2 instanceof i7.gv)) {
            return;
        }
        i7.gv gvVar = (i7.gv) view2;
        int xg2 = xg(view);
        int i = 16777215 & xg2;
        if (z2) {
            if (!z3) {
                gvVar.setCircularRevealScrimColor(xg2);
            }
            ofInt = ObjectAnimator.ofInt(gvVar, gv.C0112gv.y, i);
        } else {
            ofInt = ObjectAnimator.ofInt(gvVar, gv.C0112gv.y, xg2);
        }
        ofInt.setEvaluator(y6.zn.n3());
        vVar.y.v("color").y(ofInt);
        list.add(ofInt);
    }

    @Override // com.google.android.material.transformation.ExpandableBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.zn
    public boolean v(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, @NonNull View view2) {
        if (view.getVisibility() != 8) {
            if (!(view2 instanceof FloatingActionButton)) {
                return false;
            }
            int expandedComponentIdHint = ((FloatingActionButton) view2).getExpandedComponentIdHint();
            if (expandedComponentIdHint != 0 && expandedComponentIdHint != view.getId()) {
                return false;
            }
            return true;
        }
        throw new IllegalStateException("This behavior cannot be attached to a GONE view. Set the view to INVISIBLE instead.");
    }

    public final float vl(@NonNull View view, @NonNull View view2, @NonNull i9 i9Var) {
        RectF rectF = this.f6133gv;
        RectF rectF2 = this.f6135v;
        k5(view, rectF);
        j(view2, rectF2);
        rectF2.offset(-j5(view, view2, i9Var), 0.0f);
        return rectF.centerX() - rectF2.left;
    }

    @Nullable
    public final ViewGroup x(@NonNull View view) {
        View findViewById = view.findViewById(R$id.mtrl_child_content_container);
        if (findViewById != null) {
            return ct(findViewById);
        }
        if (!(view instanceof f0.n3) && !(view instanceof f0.y)) {
            return ct(view);
        }
        return ct(((ViewGroup) view).getChildAt(0));
    }

    public final int xg(@NonNull View view) {
        ColorStateList r2 = i4.r(view);
        if (r2 != null) {
            return r2.getColorForState(view.getDrawableState(), r2.getDefaultColor());
        }
        return 0;
    }

    public final void y5(@NonNull View view, @NonNull View view2, boolean z2, boolean z3, @NonNull v vVar, @NonNull List<Animator> list, List<Animator.AnimatorListener> list2, @NonNull RectF rectF) {
        ObjectAnimator ofFloat;
        ObjectAnimator ofFloat2;
        float j52 = j5(view, view2, vVar.f6139n3);
        float qn2 = qn(view, view2, vVar.f6139n3);
        Pair<c5, c5> yt2 = yt(j52, qn2, z2, vVar);
        c5 c5Var = (c5) yt2.first;
        c5 c5Var2 = (c5) yt2.second;
        if (z2) {
            if (!z3) {
                view2.setTranslationX(-j52);
                view2.setTranslationY(-qn2);
            }
            ofFloat = ObjectAnimator.ofFloat(view2, View.TRANSLATION_X, 0.0f);
            ofFloat2 = ObjectAnimator.ofFloat(view2, View.TRANSLATION_Y, 0.0f);
            b(view2, vVar, c5Var, c5Var2, -j52, -qn2, 0.0f, 0.0f, rectF);
        } else {
            ofFloat = ObjectAnimator.ofFloat(view2, View.TRANSLATION_X, -j52);
            ofFloat2 = ObjectAnimator.ofFloat(view2, View.TRANSLATION_Y, -qn2);
        }
        c5Var.y(ofFloat);
        c5Var2.y(ofFloat2);
        list.add(ofFloat);
        list.add(ofFloat2);
    }

    @NonNull
    public final Pair<c5, c5> yt(float f4, float f6, boolean z2, @NonNull v vVar) {
        c5 v2;
        c5 v3;
        int i;
        if (f4 != 0.0f && f6 != 0.0f) {
            if ((z2 && f6 < 0.0f) || (!z2 && i > 0)) {
                v2 = vVar.y.v("translationXCurveUpwards");
                v3 = vVar.y.v("translationYCurveUpwards");
            } else {
                v2 = vVar.y.v("translationXCurveDownwards");
                v3 = vVar.y.v("translationYCurveDownwards");
            }
        } else {
            v2 = vVar.y.v("translationXLinear");
            v3 = vVar.y.v("translationYLinear");
        }
        return new Pair<>(v2, v3);
    }

    public FabTransformationBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f6136zn = new Rect();
        this.f6133gv = new RectF();
        this.f6135v = new RectF();
        this.f6131a = new int[2];
    }
}
