package cr;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
/* loaded from: classes.dex */
public class gv extends ta {

    /* loaded from: classes.dex */
    public static class n3 extends AnimatorListenerAdapter {

        /* renamed from: n3  reason: collision with root package name */
        public boolean f6768n3;
        public final View y;

        public n3(View view) {
            this.y = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            f3.fb(this.y, 1.0f);
            if (this.f6768n3) {
                this.y.setLayerType(0, null);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (hw.i4.o(this.y) && this.y.getLayerType() == 0) {
                this.f6768n3 = true;
                this.y.setLayerType(2, null);
            }
        }
    }

    /* loaded from: classes.dex */
    public class y extends t {
        public final /* synthetic */ View y;

        public y(View view) {
            this.y = view;
        }

        @Override // cr.f.fb
        public void zn(@NonNull f fVar) {
            f3.fb(this.y, 1.0f);
            f3.y(this.y);
            fVar.j(this);
        }
    }

    public gv(int i) {
        e(i);
    }

    public static float ap(p pVar, float f4) {
        Float f6;
        if (pVar != null && (f6 = (Float) pVar.y.get("android:fade:transitionAlpha")) != null) {
            return f6.floatValue();
        }
        return f4;
    }

    @Override // cr.ta
    @Nullable
    public Animator eb(ViewGroup viewGroup, View view, p pVar, p pVar2) {
        float f4 = 0.0f;
        float ap2 = ap(pVar, 0.0f);
        if (ap2 != 1.0f) {
            f4 = ap2;
        }
        return s8(view, f4, 1.0f);
    }

    @Override // cr.ta, cr.f
    public void f(@NonNull p pVar) {
        super.f(pVar);
        pVar.y.put("android:fade:transitionAlpha", Float.valueOf(f3.zn(pVar.f6778n3)));
    }

    @Override // cr.ta
    @Nullable
    public Animator nf(ViewGroup viewGroup, View view, p pVar, p pVar2) {
        f3.v(view);
        return s8(view, ap(pVar, 1.0f), 0.0f);
    }

    public final Animator s8(View view, float f4, float f6) {
        if (f4 == f6) {
            return null;
        }
        f3.fb(view, f4);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, f3.f6765n3, f6);
        ofFloat.addListener(new n3(view));
        n3(new y(view));
        return ofFloat;
    }
}
