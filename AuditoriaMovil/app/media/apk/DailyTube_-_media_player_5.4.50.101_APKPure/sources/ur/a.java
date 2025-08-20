package ur;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import androidx.annotation.Nullable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public final class a {
    public final ArrayList<n3> y = new ArrayList<>();
    @Nullable

    /* renamed from: n3  reason: collision with root package name */
    public n3 f14083n3 = null;
    @Nullable

    /* renamed from: zn  reason: collision with root package name */
    public ValueAnimator f14084zn = null;

    /* renamed from: gv  reason: collision with root package name */
    public final Animator.AnimatorListener f14082gv = new y();

    /* loaded from: classes.dex */
    public static class n3 {

        /* renamed from: n3  reason: collision with root package name */
        public final ValueAnimator f14085n3;
        public final int[] y;

        public n3(int[] iArr, ValueAnimator valueAnimator) {
            this.y = iArr;
            this.f14085n3 = valueAnimator;
        }
    }

    /* loaded from: classes.dex */
    public class y extends AnimatorListenerAdapter {
        public y() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            a aVar = a.this;
            if (aVar.f14084zn == animator) {
                aVar.f14084zn = null;
            }
        }
    }

    public void y(int[] iArr, ValueAnimator valueAnimator) {
        n3 n3Var = new n3(iArr, valueAnimator);
        valueAnimator.addListener(this.f14082gv);
        this.y.add(n3Var);
    }
}
