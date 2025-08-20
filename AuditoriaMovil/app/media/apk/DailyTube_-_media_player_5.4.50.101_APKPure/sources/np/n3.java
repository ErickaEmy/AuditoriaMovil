package np;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.R$color;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import hx.f;
import hx.fb;
import java.util.ArrayList;
import vl.s;
/* loaded from: classes.dex */
public class n3 extends com.google.android.material.floatingactionbutton.y {

    /* loaded from: classes.dex */
    public static class y extends fb {
        public y(f fVar) {
            super(fVar);
        }

        @Override // hx.fb, android.graphics.drawable.Drawable
        public boolean isStateful() {
            return true;
        }
    }

    public n3(FloatingActionButton floatingActionButton, os.n3 n3Var) {
        super(floatingActionButton, n3Var);
    }

    @Override // com.google.android.material.floatingactionbutton.y
    public boolean a8() {
        return false;
    }

    @NonNull
    public final Animator eb(float f4, float f6) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ObjectAnimator.ofFloat(this.f5762n, "elevation", f4).setDuration(0L)).with(ObjectAnimator.ofFloat(this.f5762n, View.TRANSLATION_Z, f6).setDuration(100L));
        animatorSet.setInterpolator(com.google.android.material.floatingactionbutton.y.f5743d);
        return animatorSet;
    }

    @Override // com.google.android.material.floatingactionbutton.y
    public boolean f7() {
        if (!this.f5749c.zn() && jz()) {
            return false;
        }
        return true;
    }

    @Override // com.google.android.material.floatingactionbutton.y
    public void fh() {
        dm();
    }

    @Override // com.google.android.material.floatingactionbutton.y
    public void i4(ColorStateList colorStateList, @Nullable PorterDuff.Mode mode, ColorStateList colorStateList2, int i) {
        Drawable drawable;
        fb lc2 = lc();
        this.f5763n3 = lc2;
        lc2.setTintList(colorStateList);
        if (mode != null) {
            this.f5763n3.setTintMode(mode);
        }
        this.f5763n3.k5(this.f5762n.getContext());
        if (i > 0) {
            this.f5757gv = rs(i, colorStateList);
            drawable = new LayerDrawable(new Drawable[]{(Drawable) s.fb(this.f5757gv), (Drawable) s.fb(this.f5763n3)});
        } else {
            this.f5757gv = null;
            drawable = this.f5763n3;
        }
        RippleDrawable rippleDrawable = new RippleDrawable(nr.n3.gv(colorStateList2), drawable, null);
        this.f5777zn = rippleDrawable;
        this.f5771v = rippleDrawable;
    }

    @NonNull
    public fb lc() {
        return new y((f) s.fb(this.y));
    }

    @Override // com.google.android.material.floatingactionbutton.y
    public void mg(int[] iArr) {
        if (Build.VERSION.SDK_INT == 21) {
            if (this.f5762n.isEnabled()) {
                this.f5762n.setElevation(this.f5767s);
                if (this.f5762n.isPressed()) {
                    this.f5762n.setTranslationZ(this.f5759i9);
                    return;
                } else if (!this.f5762n.isFocused() && !this.f5762n.isHovered()) {
                    this.f5762n.setTranslationZ(0.0f);
                    return;
                } else {
                    this.f5762n.setTranslationZ(this.f5750c5);
                    return;
                }
            }
            this.f5762n.setElevation(0.0f);
            this.f5762n.setTranslationZ(0.0f);
        }
    }

    @Override // com.google.android.material.floatingactionbutton.y
    public void mt(@NonNull Rect rect) {
        if (this.f5749c.zn()) {
            super.mt(rect);
        } else if (!jz()) {
            int sizeDimension = (this.f5753f - this.f5762n.getSizeDimension()) / 2;
            rect.set(sizeDimension, sizeDimension, sizeDimension, sizeDimension);
        } else {
            rect.set(0, 0, 0, 0);
        }
    }

    @Override // com.google.android.material.floatingactionbutton.y
    public void oz(@Nullable ColorStateList colorStateList) {
        Drawable drawable = this.f5777zn;
        if (drawable instanceof RippleDrawable) {
            ((RippleDrawable) drawable).setColor(nr.n3.gv(colorStateList));
        } else {
            super.oz(colorStateList);
        }
    }

    @NonNull
    public np.y rs(int i, ColorStateList colorStateList) {
        Context context = this.f5762n.getContext();
        np.y yVar = new np.y((f) s.fb(this.y));
        yVar.v(mg.y.zn(context, R$color.hv), mg.y.zn(context, R$color.hn), mg.y.zn(context, R$color.hw), mg.y.zn(context, R$color.he));
        yVar.gv(i);
        yVar.zn(colorStateList);
        return yVar;
    }

    @Override // com.google.android.material.floatingactionbutton.y
    public void ta(float f4, float f6, float f9) {
        int i = Build.VERSION.SDK_INT;
        if (i == 21) {
            this.f5762n.refreshDrawableState();
        } else {
            StateListAnimator stateListAnimator = new StateListAnimator();
            stateListAnimator.addState(com.google.android.material.floatingactionbutton.y.f5747z6, eb(f4, f9));
            stateListAnimator.addState(com.google.android.material.floatingactionbutton.y.f5744ej, eb(f4, f6));
            stateListAnimator.addState(com.google.android.material.floatingactionbutton.y.f5745ud, eb(f4, f6));
            stateListAnimator.addState(com.google.android.material.floatingactionbutton.y.f5741a8, eb(f4, f6));
            AnimatorSet animatorSet = new AnimatorSet();
            ArrayList arrayList = new ArrayList();
            arrayList.add(ObjectAnimator.ofFloat(this.f5762n, "elevation", f4).setDuration(0L));
            if (i >= 22 && i <= 24) {
                FloatingActionButton floatingActionButton = this.f5762n;
                arrayList.add(ObjectAnimator.ofFloat(floatingActionButton, View.TRANSLATION_Z, floatingActionButton.getTranslationZ()).setDuration(100L));
            }
            arrayList.add(ObjectAnimator.ofFloat(this.f5762n, View.TRANSLATION_Z, 0.0f).setDuration(100L));
            animatorSet.playSequentially((Animator[]) arrayList.toArray(new Animator[0]));
            animatorSet.setInterpolator(com.google.android.material.floatingactionbutton.y.f5743d);
            stateListAnimator.addState(com.google.android.material.floatingactionbutton.y.f5746x, animatorSet);
            stateListAnimator.addState(com.google.android.material.floatingactionbutton.y.f5742b, eb(0.0f, 0.0f));
            this.f5762n.setStateListAnimator(stateListAnimator);
        }
        if (f7()) {
            dm();
        }
    }

    @Override // com.google.android.material.floatingactionbutton.y
    public float tl() {
        return this.f5762n.getElevation();
    }

    @Override // com.google.android.material.floatingactionbutton.y
    public void c() {
    }

    @Override // com.google.android.material.floatingactionbutton.y
    public void y5() {
    }
}
