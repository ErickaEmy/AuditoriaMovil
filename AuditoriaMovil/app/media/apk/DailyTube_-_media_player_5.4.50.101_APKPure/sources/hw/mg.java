package hw;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.Interpolator;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public final class mg {

    /* renamed from: n3  reason: collision with root package name */
    public int f8981n3 = -1;
    public final WeakReference<View> y;

    /* loaded from: classes.dex */
    public static class n3 {
        public static ViewPropertyAnimator y(ViewPropertyAnimator viewPropertyAnimator, ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
            return viewPropertyAnimator.setUpdateListener(animatorUpdateListener);
        }
    }

    /* loaded from: classes.dex */
    public class y extends AnimatorListenerAdapter {

        /* renamed from: n3  reason: collision with root package name */
        public final /* synthetic */ View f8982n3;
        public final /* synthetic */ ta y;

        public y(ta taVar, View view) {
            this.y = taVar;
            this.f8982n3 = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.y.y(this.f8982n3);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.y.n3(this.f8982n3);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            this.y.zn(this.f8982n3);
        }
    }

    public mg(View view) {
        this.y = new WeakReference<>(view);
    }

    @NonNull
    public mg a(long j2) {
        View view = this.y.get();
        if (view != null) {
            view.animate().setDuration(j2);
        }
        return this;
    }

    public final void c5(View view, ta taVar) {
        if (taVar != null) {
            view.animate().setListener(new y(taVar, view));
        } else {
            view.animate().setListener(null);
        }
    }

    @NonNull
    public mg f(@Nullable final z6 z6Var) {
        ValueAnimator.AnimatorUpdateListener animatorUpdateListener;
        final View view = this.y.get();
        if (view != null) {
            if (z6Var != null) {
                animatorUpdateListener = new ValueAnimator.AnimatorUpdateListener() { // from class: hw.rz
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        z6.this.y(view);
                    }
                };
            } else {
                animatorUpdateListener = null;
            }
            n3.y(view.animate(), animatorUpdateListener);
        }
        return this;
    }

    @NonNull
    public mg fb(@Nullable Interpolator interpolator) {
        View view = this.y.get();
        if (view != null) {
            view.animate().setInterpolator(interpolator);
        }
        return this;
    }

    public long gv() {
        View view = this.y.get();
        if (view != null) {
            return view.animate().getDuration();
        }
        return 0L;
    }

    @NonNull
    public mg i9(long j2) {
        View view = this.y.get();
        if (view != null) {
            view.animate().setStartDelay(j2);
        }
        return this;
    }

    @NonNull
    public mg n3(float f4) {
        View view = this.y.get();
        if (view != null) {
            view.animate().alpha(f4);
        }
        return this;
    }

    @NonNull
    public mg s(@Nullable ta taVar) {
        View view = this.y.get();
        if (view != null) {
            c5(view, taVar);
        }
        return this;
    }

    public void t() {
        View view = this.y.get();
        if (view != null) {
            view.animate().start();
        }
    }

    @NonNull
    public mg tl(float f4) {
        View view = this.y.get();
        if (view != null) {
            view.animate().translationY(f4);
        }
        return this;
    }

    public void zn() {
        View view = this.y.get();
        if (view != null) {
            view.animate().cancel();
        }
    }
}
