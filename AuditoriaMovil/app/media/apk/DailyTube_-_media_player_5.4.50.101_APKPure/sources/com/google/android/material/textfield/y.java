package com.google.android.material.textfield;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import androidx.annotation.NonNull;
import com.google.android.material.R$drawable;
import com.google.android.material.R$string;
import com.google.android.material.textfield.TextInputLayout;
/* loaded from: classes.dex */
public class y extends e7.zn {

    /* renamed from: a  reason: collision with root package name */
    public final TextInputLayout.a f6072a;

    /* renamed from: c5  reason: collision with root package name */
    public ValueAnimator f6073c5;

    /* renamed from: fb  reason: collision with root package name */
    public final TextInputLayout.fb f6074fb;

    /* renamed from: gv  reason: collision with root package name */
    public final TextWatcher f6075gv;

    /* renamed from: s  reason: collision with root package name */
    public AnimatorSet f6076s;

    /* renamed from: v  reason: collision with root package name */
    public final View.OnFocusChangeListener f6077v;

    /* loaded from: classes.dex */
    public class a extends AnimatorListenerAdapter {
        public a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            y.this.y.setEndIconVisible(true);
        }
    }

    /* loaded from: classes.dex */
    public class c5 implements ValueAnimator.AnimatorUpdateListener {
        public c5() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            y.this.f7588zn.setScaleX(floatValue);
            y.this.f7588zn.setScaleY(floatValue);
        }
    }

    /* loaded from: classes.dex */
    public class fb extends AnimatorListenerAdapter {
        public fb() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            y.this.y.setEndIconVisible(false);
        }
    }

    /* loaded from: classes.dex */
    public class gv implements TextInputLayout.fb {

        /* renamed from: com.google.android.material.textfield.y$gv$y  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0068y implements Runnable {
            public final /* synthetic */ EditText y;

            public RunnableC0068y(EditText editText) {
                this.y = editText;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.y.removeTextChangedListener(y.this.f6075gv);
            }
        }

        public gv() {
        }

        @Override // com.google.android.material.textfield.TextInputLayout.fb
        public void y(@NonNull TextInputLayout textInputLayout, int i) {
            EditText editText = textInputLayout.getEditText();
            if (editText != null && i == 2) {
                editText.post(new RunnableC0068y(editText));
                if (editText.getOnFocusChangeListener() == y.this.f6077v) {
                    editText.setOnFocusChangeListener(null);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class n3 implements View.OnFocusChangeListener {
        public n3() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z2) {
            boolean z3;
            boolean isEmpty = TextUtils.isEmpty(((EditText) view).getText());
            y yVar = y.this;
            if (!isEmpty && z2) {
                z3 = true;
            } else {
                z3 = false;
            }
            yVar.c5(z3);
        }
    }

    /* loaded from: classes.dex */
    public class s implements ValueAnimator.AnimatorUpdateListener {
        public s() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
            y.this.f7588zn.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    /* loaded from: classes.dex */
    public class v implements View.OnClickListener {
        public v() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Editable text = y.this.y.getEditText().getText();
            if (text != null) {
                text.clear();
            }
            y.this.y.ut();
        }
    }

    /* renamed from: com.google.android.material.textfield.y$y  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0069y implements TextWatcher {
        public C0069y() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(@NonNull Editable editable) {
            if (y.this.y.getSuffixText() == null) {
                y.this.c5(y.t(editable));
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i5, int i6) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i5, int i6) {
        }
    }

    /* loaded from: classes.dex */
    public class zn implements TextInputLayout.a {
        public zn() {
        }

        @Override // com.google.android.material.textfield.TextInputLayout.a
        public void y(@NonNull TextInputLayout textInputLayout) {
            boolean z2;
            EditText editText = textInputLayout.getEditText();
            if (editText.hasFocus() && y.t(editText.getText())) {
                z2 = true;
            } else {
                z2 = false;
            }
            textInputLayout.setEndIconVisible(z2);
            textInputLayout.setEndIconCheckable(false);
            editText.setOnFocusChangeListener(y.this.f6077v);
            editText.removeTextChangedListener(y.this.f6075gv);
            editText.addTextChangedListener(y.this.f6075gv);
        }
    }

    public y(@NonNull TextInputLayout textInputLayout) {
        super(textInputLayout);
        this.f6075gv = new C0069y();
        this.f6077v = new n3();
        this.f6072a = new zn();
        this.f6074fb = new gv();
    }

    public static boolean t(@NonNull Editable editable) {
        if (editable.length() > 0) {
            return true;
        }
        return false;
    }

    public final void c5(boolean z2) {
        boolean z3;
        if (this.y.x() == z2) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (z2 && !this.f6076s.isRunning()) {
            this.f6073c5.cancel();
            this.f6076s.start();
            if (z3) {
                this.f6076s.end();
            }
        } else if (!z2) {
            this.f6076s.cancel();
            this.f6073c5.start();
            if (z3) {
                this.f6073c5.end();
            }
        }
    }

    public final ValueAnimator f() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.8f, 1.0f);
        ofFloat.setInterpolator(y6.y.f15324gv);
        ofFloat.setDuration(150L);
        ofFloat.addUpdateListener(new c5());
        return ofFloat;
    }

    public final ValueAnimator i9(float... fArr) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(fArr);
        ofFloat.setInterpolator(y6.y.y);
        ofFloat.setDuration(100L);
        ofFloat.addUpdateListener(new s());
        return ofFloat;
    }

    public final void tl() {
        ValueAnimator f4 = f();
        ValueAnimator i92 = i9(0.0f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        this.f6076s = animatorSet;
        animatorSet.playTogether(f4, i92);
        this.f6076s.addListener(new a());
        ValueAnimator i93 = i9(1.0f, 0.0f);
        this.f6073c5 = i93;
        i93.addListener(new fb());
    }

    @Override // e7.zn
    public void y() {
        this.y.setEndIconDrawable(c5.y.gv(this.f7587n3, R$drawable.fgr));
        TextInputLayout textInputLayout = this.y;
        textInputLayout.setEndIconContentDescription(textInputLayout.getResources().getText(R$string.gl));
        this.y.setEndIconOnClickListener(new v());
        this.y.v(this.f6072a);
        this.y.a(this.f6074fb);
        tl();
    }

    @Override // e7.zn
    public void zn(boolean z2) {
        if (this.y.getSuffixText() == null) {
            return;
        }
        c5(z2);
    }
}
