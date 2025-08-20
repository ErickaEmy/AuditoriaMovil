package e7;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import com.google.android.material.R$dimen;
import com.google.android.material.R$id;
import com.google.android.material.textfield.TextInputLayout;
import hw.i4;
import j.tl;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public final class gv {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    public Animator f7557a;

    /* renamed from: c5  reason: collision with root package name */
    public int f7558c5;

    /* renamed from: co  reason: collision with root package name */
    public int f7559co;

    /* renamed from: f  reason: collision with root package name */
    public boolean f7560f;

    /* renamed from: fb  reason: collision with root package name */
    public final float f7561fb;

    /* renamed from: gv  reason: collision with root package name */
    public int f7562gv;
    @Nullable

    /* renamed from: i9  reason: collision with root package name */
    public CharSequence f7563i9;
    @Nullable

    /* renamed from: mt  reason: collision with root package name */
    public TextView f7564mt;
    @NonNull

    /* renamed from: n3  reason: collision with root package name */
    public final TextInputLayout f7565n3;

    /* renamed from: p  reason: collision with root package name */
    public boolean f7566p;

    /* renamed from: r  reason: collision with root package name */
    public Typeface f7567r;

    /* renamed from: s  reason: collision with root package name */
    public int f7568s;
    @Nullable

    /* renamed from: t  reason: collision with root package name */
    public TextView f7569t;
    @Nullable

    /* renamed from: tl  reason: collision with root package name */
    public CharSequence f7570tl;

    /* renamed from: v  reason: collision with root package name */
    public FrameLayout f7571v;

    /* renamed from: w  reason: collision with root package name */
    public CharSequence f7572w;

    /* renamed from: wz  reason: collision with root package name */
    public int f7573wz;
    @Nullable

    /* renamed from: xc  reason: collision with root package name */
    public ColorStateList f7574xc;
    public final Context y;
    @Nullable

    /* renamed from: z  reason: collision with root package name */
    public ColorStateList f7575z;

    /* renamed from: zn  reason: collision with root package name */
    public LinearLayout f7576zn;

    /* loaded from: classes.dex */
    public class y extends AnimatorListenerAdapter {

        /* renamed from: gv  reason: collision with root package name */
        public final /* synthetic */ TextView f7577gv;

        /* renamed from: n3  reason: collision with root package name */
        public final /* synthetic */ TextView f7578n3;
        public final /* synthetic */ int y;

        /* renamed from: zn  reason: collision with root package name */
        public final /* synthetic */ int f7580zn;

        public y(int i, TextView textView, int i5, TextView textView2) {
            this.y = i;
            this.f7578n3 = textView;
            this.f7580zn = i5;
            this.f7577gv = textView2;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            gv.this.f7568s = this.y;
            gv.this.f7557a = null;
            TextView textView = this.f7578n3;
            if (textView != null) {
                textView.setVisibility(4);
                if (this.f7580zn == 1 && gv.this.f7569t != null) {
                    gv.this.f7569t.setText((CharSequence) null);
                }
            }
            TextView textView2 = this.f7577gv;
            if (textView2 != null) {
                textView2.setTranslationY(0.0f);
                this.f7577gv.setAlpha(1.0f);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            TextView textView = this.f7577gv;
            if (textView != null) {
                textView.setVisibility(0);
            }
        }
    }

    public gv(@NonNull TextInputLayout textInputLayout) {
        Context context = textInputLayout.getContext();
        this.y = context;
        this.f7565n3 = textInputLayout;
        this.f7561fb = context.getResources().getDimensionPixelSize(R$dimen.jd);
    }

    public final boolean a() {
        if (this.f7576zn != null && this.f7565n3.getEditText() != null) {
            return true;
        }
        return false;
    }

    public void a8(Typeface typeface) {
        if (typeface != this.f7567r) {
            this.f7567r = typeface;
            ud(this.f7569t, typeface);
            ud(this.f7564mt, typeface);
        }
    }

    public final boolean b(@Nullable TextView textView, @Nullable CharSequence charSequence) {
        if (i4.q9(this.f7565n3) && this.f7565n3.isEnabled() && (this.f7558c5 != this.f7568s || textView == null || !TextUtils.equals(textView.getText(), charSequence))) {
            return true;
        }
        return false;
    }

    public void c(TextView textView, int i) {
        FrameLayout frameLayout;
        if (this.f7576zn == null) {
            return;
        }
        if (i4(i) && (frameLayout = this.f7571v) != null) {
            frameLayout.removeView(textView);
        } else {
            this.f7576zn.removeView(textView);
        }
        int i5 = this.f7562gv - 1;
        this.f7562gv = i5;
        x(this.f7576zn, i5);
    }

    public final ObjectAnimator c5(TextView textView, boolean z2) {
        float f4;
        if (z2) {
            f4 = 1.0f;
        } else {
            f4 = 0.0f;
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(textView, View.ALPHA, f4);
        ofFloat.setDuration(167L);
        ofFloat.setInterpolator(y6.y.y);
        return ofFloat;
    }

    public final int co(boolean z2, int i, int i5) {
        if (z2) {
            return this.y.getResources().getDimensionPixelSize(i);
        }
        return i5;
    }

    public void d(int i) {
        this.f7559co = i;
        TextView textView = this.f7564mt;
        if (textView != null) {
            tl.xc(textView, i);
        }
    }

    public final void d0(int i, int i5) {
        TextView t2;
        TextView t3;
        if (i == i5) {
            return;
        }
        if (i5 != 0 && (t3 = t(i5)) != null) {
            t3.setVisibility(0);
            t3.setAlpha(1.0f);
        }
        if (i != 0 && (t2 = t(i)) != null) {
            t2.setVisibility(4);
            if (i == 1) {
                t2.setText((CharSequence) null);
            }
        }
        this.f7568s = i5;
    }

    public void ej(@Nullable ColorStateList colorStateList) {
        this.f7575z = colorStateList;
        TextView textView = this.f7564mt;
        if (textView != null && colorStateList != null) {
            textView.setTextColor(colorStateList);
        }
    }

    public boolean f() {
        return x4(this.f7558c5);
    }

    public boolean f3() {
        return this.f7560f;
    }

    public void fb() {
        Animator animator = this.f7557a;
        if (animator != null) {
            animator.cancel();
        }
    }

    public void fh(@Nullable CharSequence charSequence) {
        this.f7570tl = charSequence;
        TextView textView = this.f7569t;
        if (textView != null) {
            textView.setContentDescription(charSequence);
        }
    }

    public void gv(TextView textView, int i) {
        if (this.f7576zn == null && this.f7571v == null) {
            LinearLayout linearLayout = new LinearLayout(this.y);
            this.f7576zn = linearLayout;
            linearLayout.setOrientation(0);
            this.f7565n3.addView(this.f7576zn, -1, -2);
            this.f7571v = new FrameLayout(this.y);
            this.f7576zn.addView(this.f7571v, new LinearLayout.LayoutParams(0, -2, 1.0f));
            if (this.f7565n3.getEditText() != null) {
                v();
            }
        }
        if (i4(i)) {
            this.f7571v.setVisibility(0);
            this.f7571v.addView(textView);
        } else {
            this.f7576zn.addView(textView, new LinearLayout.LayoutParams(-2, -2));
        }
        this.f7576zn.setVisibility(0);
        this.f7562gv++;
    }

    public boolean i4(int i) {
        if (i == 0 || i == 1) {
            return true;
        }
        return false;
    }

    public final ObjectAnimator i9(TextView textView) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(textView, View.TRANSLATION_Y, -this.f7561fb, 0.0f);
        ofFloat.setDuration(217L);
        ofFloat.setInterpolator(y6.y.f15324gv);
        return ofFloat;
    }

    public void k5(CharSequence charSequence) {
        fb();
        this.f7563i9 = charSequence;
        this.f7569t.setText(charSequence);
        int i = this.f7568s;
        if (i != 1) {
            this.f7558c5 = 1;
        }
        vl(i, this.f7558c5, b(this.f7569t, charSequence));
    }

    public void mg(int i) {
        this.f7573wz = i;
        TextView textView = this.f7569t;
        if (textView != null) {
            this.f7565n3.dm(textView, i);
        }
    }

    public int mt() {
        TextView textView = this.f7564mt;
        if (textView != null) {
            return textView.getCurrentTextColor();
        }
        return -1;
    }

    public boolean n() {
        return this.f7566p;
    }

    public CharSequence p() {
        return this.f7572w;
    }

    public void r() {
        fb();
        int i = this.f7568s;
        if (i == 2) {
            this.f7558c5 = 0;
        }
        vl(i, this.f7558c5, b(this.f7564mt, null));
    }

    public void rz(boolean z2) {
        if (this.f7560f == z2) {
            return;
        }
        fb();
        if (z2) {
            AppCompatTextView appCompatTextView = new AppCompatTextView(this.y);
            this.f7569t = appCompatTextView;
            appCompatTextView.setId(R$id.textinput_error);
            this.f7569t.setTextAlignment(5);
            Typeface typeface = this.f7567r;
            if (typeface != null) {
                this.f7569t.setTypeface(typeface);
            }
            mg(this.f7573wz);
            ta(this.f7574xc);
            fh(this.f7570tl);
            this.f7569t.setVisibility(4);
            i4.g(this.f7569t, 1);
            gv(this.f7569t, 0);
        } else {
            z();
            c(this.f7569t, 0);
            this.f7569t = null;
            this.f7565n3.kp();
            this.f7565n3.xb();
        }
        this.f7560f = z2;
    }

    public final void s(@NonNull List<Animator> list, boolean z2, @Nullable TextView textView, int i, int i5, int i6) {
        boolean z3;
        if (textView != null && z2) {
            if (i == i6 || i == i5) {
                if (i6 == i) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                list.add(c5(textView, z3));
                if (i6 == i) {
                    list.add(i9(textView));
                }
            }
        }
    }

    @Nullable
    public final TextView t(int i) {
        if (i != 1) {
            if (i != 2) {
                return null;
            }
            return this.f7564mt;
        }
        return this.f7569t;
    }

    public void ta(@Nullable ColorStateList colorStateList) {
        this.f7574xc = colorStateList;
        TextView textView = this.f7569t;
        if (textView != null && colorStateList != null) {
            textView.setTextColor(colorStateList);
        }
    }

    @Nullable
    public CharSequence tl() {
        return this.f7570tl;
    }

    public final void ud(@Nullable TextView textView, Typeface typeface) {
        if (textView != null) {
            textView.setTypeface(typeface);
        }
    }

    public void v() {
        if (a()) {
            EditText editText = this.f7565n3.getEditText();
            boolean fb2 = pv.zn.fb(this.y);
            LinearLayout linearLayout = this.f7576zn;
            int i = R$dimen.x7;
            i4.cy(linearLayout, co(fb2, i, i4.a8(editText)), co(fb2, R$dimen.x8, this.y.getResources().getDimensionPixelSize(R$dimen.x6)), co(fb2, i, i4.ud(editText)), 0);
        }
    }

    public final void vl(int i, int i5, boolean z2) {
        if (i == i5) {
            return;
        }
        if (z2) {
            AnimatorSet animatorSet = new AnimatorSet();
            this.f7557a = animatorSet;
            ArrayList arrayList = new ArrayList();
            s(arrayList, this.f7566p, this.f7564mt, 2, i, i5);
            s(arrayList, this.f7560f, this.f7569t, 1, i, i5);
            y6.n3.y(animatorSet, arrayList);
            animatorSet.addListener(new y(i5, t(i), i, t(i5)));
            animatorSet.start();
        } else {
            d0(i, i5);
        }
        this.f7565n3.kp();
        this.f7565n3.m(z2);
        this.f7565n3.xb();
    }

    @Nullable
    public ColorStateList w() {
        TextView textView = this.f7569t;
        if (textView != null) {
            return textView.getTextColors();
        }
        return null;
    }

    @Nullable
    public CharSequence wz() {
        return this.f7563i9;
    }

    public final void x(@NonNull ViewGroup viewGroup, int i) {
        if (i == 0) {
            viewGroup.setVisibility(8);
        }
    }

    public final boolean x4(int i) {
        if (i == 1 && this.f7569t != null && !TextUtils.isEmpty(this.f7563i9)) {
            return true;
        }
        return false;
    }

    public int xc() {
        TextView textView = this.f7569t;
        if (textView != null) {
            return textView.getCurrentTextColor();
        }
        return -1;
    }

    public void yt(CharSequence charSequence) {
        fb();
        this.f7572w = charSequence;
        this.f7564mt.setText(charSequence);
        int i = this.f7568s;
        if (i != 2) {
            this.f7558c5 = 2;
        }
        vl(i, this.f7558c5, b(this.f7564mt, charSequence));
    }

    public void z() {
        this.f7563i9 = null;
        fb();
        if (this.f7568s == 1) {
            if (this.f7566p && !TextUtils.isEmpty(this.f7572w)) {
                this.f7558c5 = 2;
            } else {
                this.f7558c5 = 0;
            }
        }
        vl(this.f7568s, this.f7558c5, b(this.f7569t, null));
    }

    public void z6(boolean z2) {
        if (this.f7566p == z2) {
            return;
        }
        fb();
        if (z2) {
            AppCompatTextView appCompatTextView = new AppCompatTextView(this.y);
            this.f7564mt = appCompatTextView;
            appCompatTextView.setId(R$id.textinput_helper_text);
            this.f7564mt.setTextAlignment(5);
            Typeface typeface = this.f7567r;
            if (typeface != null) {
                this.f7564mt.setTypeface(typeface);
            }
            this.f7564mt.setVisibility(4);
            i4.g(this.f7564mt, 1);
            d(this.f7559co);
            ej(this.f7575z);
            gv(this.f7564mt, 1);
        } else {
            r();
            c(this.f7564mt, 1);
            this.f7564mt = null;
            this.f7565n3.kp();
            this.f7565n3.xb();
        }
        this.f7566p = z2;
    }
}
