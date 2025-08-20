package br;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.os.Build;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
/* loaded from: classes.dex */
public abstract class y extends ValueAnimator {
    public final Set<ValueAnimator.AnimatorUpdateListener> y = new CopyOnWriteArraySet();

    /* renamed from: v  reason: collision with root package name */
    public final Set<Animator.AnimatorListener> f3884v = new CopyOnWriteArraySet();

    /* renamed from: fb  reason: collision with root package name */
    public final Set<Animator.AnimatorPauseListener> f3883fb = new CopyOnWriteArraySet();

    public void a() {
        for (Animator.AnimatorListener animatorListener : this.f3884v) {
            animatorListener.onAnimationRepeat(this);
        }
    }

    @Override // android.animation.Animator
    public void addListener(Animator.AnimatorListener animatorListener) {
        this.f3884v.add(animatorListener);
    }

    @Override // android.animation.Animator
    public void addPauseListener(Animator.AnimatorPauseListener animatorPauseListener) {
        this.f3883fb.add(animatorPauseListener);
    }

    @Override // android.animation.ValueAnimator
    public void addUpdateListener(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.y.add(animatorUpdateListener);
    }

    public void c5() {
        for (ValueAnimator.AnimatorUpdateListener animatorUpdateListener : this.y) {
            animatorUpdateListener.onAnimationUpdate(this);
        }
    }

    public void fb() {
        for (Animator.AnimatorPauseListener animatorPauseListener : this.f3883fb) {
            animatorPauseListener.onAnimationResume(this);
        }
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public long getStartDelay() {
        throw new UnsupportedOperationException("LottieAnimator does not support getStartDelay.");
    }

    public void gv() {
        for (Animator.AnimatorPauseListener animatorPauseListener : this.f3883fb) {
            animatorPauseListener.onAnimationPause(this);
        }
    }

    public void n3() {
        for (Animator.AnimatorListener animatorListener : this.f3884v) {
            animatorListener.onAnimationCancel(this);
        }
    }

    @Override // android.animation.Animator
    public void removeAllListeners() {
        this.f3884v.clear();
    }

    @Override // android.animation.ValueAnimator
    public void removeAllUpdateListeners() {
        this.y.clear();
    }

    @Override // android.animation.Animator
    public void removeListener(Animator.AnimatorListener animatorListener) {
        this.f3884v.remove(animatorListener);
    }

    @Override // android.animation.Animator
    public void removePauseListener(Animator.AnimatorPauseListener animatorPauseListener) {
        this.f3883fb.remove(animatorPauseListener);
    }

    @Override // android.animation.ValueAnimator
    public void removeUpdateListener(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.y.remove(animatorUpdateListener);
    }

    public void s(boolean z2) {
        for (Animator.AnimatorListener animatorListener : this.f3884v) {
            if (Build.VERSION.SDK_INT >= 26) {
                animatorListener.onAnimationStart(this, z2);
            } else {
                animatorListener.onAnimationStart(this);
            }
        }
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public void setInterpolator(TimeInterpolator timeInterpolator) {
        throw new UnsupportedOperationException("LottieAnimator does not support setInterpolator.");
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public void setStartDelay(long j2) {
        throw new UnsupportedOperationException("LottieAnimator does not support setStartDelay.");
    }

    public void zn(boolean z2) {
        for (Animator.AnimatorListener animatorListener : this.f3884v) {
            if (Build.VERSION.SDK_INT >= 26) {
                animatorListener.onAnimationEnd(this, z2);
            } else {
                animatorListener.onAnimationEnd(this);
            }
        }
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public ValueAnimator setDuration(long j2) {
        throw new UnsupportedOperationException("LottieAnimator does not support setDuration.");
    }
}
