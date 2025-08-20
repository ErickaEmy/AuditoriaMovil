package y6;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
/* loaded from: classes.dex */
public class c5 {

    /* renamed from: gv  reason: collision with root package name */
    public int f15314gv;

    /* renamed from: n3  reason: collision with root package name */
    public long f15315n3;

    /* renamed from: v  reason: collision with root package name */
    public int f15316v = 1;
    public long y;
    @Nullable

    /* renamed from: zn  reason: collision with root package name */
    public TimeInterpolator f15317zn;

    public c5(long j2, long j4) {
        this.y = j2;
        this.f15315n3 = j4;
    }

    public static TimeInterpolator a(@NonNull ValueAnimator valueAnimator) {
        TimeInterpolator interpolator = valueAnimator.getInterpolator();
        if (!(interpolator instanceof AccelerateDecelerateInterpolator) && interpolator != null) {
            if (interpolator instanceof AccelerateInterpolator) {
                return y.f15327zn;
            }
            if (interpolator instanceof DecelerateInterpolator) {
                return y.f15324gv;
            }
            return interpolator;
        }
        return y.f15325n3;
    }

    @NonNull
    public static c5 n3(@NonNull ValueAnimator valueAnimator) {
        c5 c5Var = new c5(valueAnimator.getStartDelay(), valueAnimator.getDuration(), a(valueAnimator));
        c5Var.f15314gv = valueAnimator.getRepeatCount();
        c5Var.f15316v = valueAnimator.getRepeatMode();
        return c5Var;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c5)) {
            return false;
        }
        c5 c5Var = (c5) obj;
        if (zn() != c5Var.zn() || gv() != c5Var.gv() || fb() != c5Var.fb() || s() != c5Var.s()) {
            return false;
        }
        return v().getClass().equals(c5Var.v().getClass());
    }

    public int fb() {
        return this.f15314gv;
    }

    public long gv() {
        return this.f15315n3;
    }

    public int hashCode() {
        return (((((((((int) (zn() ^ (zn() >>> 32))) * 31) + ((int) (gv() ^ (gv() >>> 32)))) * 31) + v().getClass().hashCode()) * 31) + fb()) * 31) + s();
    }

    public int s() {
        return this.f15316v;
    }

    @NonNull
    public String toString() {
        return '\n' + getClass().getName() + '{' + Integer.toHexString(System.identityHashCode(this)) + " delay: " + zn() + " duration: " + gv() + " interpolator: " + v().getClass() + " repeatCount: " + fb() + " repeatMode: " + s() + "}\n";
    }

    @Nullable
    public TimeInterpolator v() {
        TimeInterpolator timeInterpolator = this.f15317zn;
        if (timeInterpolator == null) {
            return y.f15325n3;
        }
        return timeInterpolator;
    }

    public void y(@NonNull Animator animator) {
        animator.setStartDelay(zn());
        animator.setDuration(gv());
        animator.setInterpolator(v());
        if (animator instanceof ValueAnimator) {
            ValueAnimator valueAnimator = (ValueAnimator) animator;
            valueAnimator.setRepeatCount(fb());
            valueAnimator.setRepeatMode(s());
        }
    }

    public long zn() {
        return this.y;
    }

    public c5(long j2, long j4, @NonNull TimeInterpolator timeInterpolator) {
        this.y = j2;
        this.f15315n3 = j4;
        this.f15317zn = timeInterpolator;
    }
}
