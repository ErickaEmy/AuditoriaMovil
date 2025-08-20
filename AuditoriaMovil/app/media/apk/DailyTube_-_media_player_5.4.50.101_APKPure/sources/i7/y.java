package i7;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.util.Property;
import android.view.View;
import android.view.ViewAnimationUtils;
import androidx.annotation.NonNull;
import i7.gv;
/* loaded from: classes.dex */
public final class y {

    /* renamed from: i7.y$y  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0113y extends AnimatorListenerAdapter {
        public final /* synthetic */ gv y;

        public C0113y(gv gvVar) {
            this.y = gvVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.y.n3();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            this.y.y();
        }
    }

    @NonNull
    public static Animator.AnimatorListener n3(@NonNull gv gvVar) {
        return new C0113y(gvVar);
    }

    @NonNull
    public static Animator y(@NonNull gv gvVar, float f4, float f6, float f9) {
        ObjectAnimator ofObject = ObjectAnimator.ofObject(gvVar, (Property<gv, V>) gv.zn.y, (TypeEvaluator) gv.n3.f9116n3, (Object[]) new gv.v[]{new gv.v(f4, f6, f9)});
        gv.v revealInfo = gvVar.getRevealInfo();
        if (revealInfo != null) {
            Animator createCircularReveal = ViewAnimationUtils.createCircularReveal((View) gvVar, (int) f4, (int) f6, revealInfo.f9118zn, f9);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(ofObject, createCircularReveal);
            return animatorSet;
        }
        throw new IllegalStateException("Caller must set a non-null RevealInfo before calling this.");
    }
}
