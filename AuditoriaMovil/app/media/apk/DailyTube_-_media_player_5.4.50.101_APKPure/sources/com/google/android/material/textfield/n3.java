package com.google.android.material.textfield;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Spinner;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$drawable;
import com.google.android.material.R$string;
import com.google.android.material.textfield.TextInputLayout;
import hw.i4;
import hx.f;
/* loaded from: classes.dex */
public class n3 extends e7.zn {

    /* renamed from: p  reason: collision with root package name */
    public static final boolean f6054p = true;

    /* renamed from: a  reason: collision with root package name */
    public final TextInputLayout.v f6055a;

    /* renamed from: c5  reason: collision with root package name */
    public boolean f6056c5;

    /* renamed from: f  reason: collision with root package name */
    public long f6057f;

    /* renamed from: fb  reason: collision with root package name */
    public final TextInputLayout.a f6058fb;

    /* renamed from: gv  reason: collision with root package name */
    public final TextWatcher f6059gv;

    /* renamed from: i9  reason: collision with root package name */
    public boolean f6060i9;
    @SuppressLint({"ClickableViewAccessibility"})

    /* renamed from: s  reason: collision with root package name */
    public final TextInputLayout.fb f6061s;

    /* renamed from: t  reason: collision with root package name */
    public StateListDrawable f6062t;

    /* renamed from: tl  reason: collision with root package name */
    public hx.fb f6063tl;

    /* renamed from: v  reason: collision with root package name */
    public final View.OnFocusChangeListener f6064v;

    /* renamed from: w  reason: collision with root package name */
    public ValueAnimator f6065w;
    @Nullable

    /* renamed from: wz  reason: collision with root package name */
    public AccessibilityManager f6066wz;

    /* renamed from: xc  reason: collision with root package name */
    public ValueAnimator f6067xc;

    /* loaded from: classes.dex */
    public class a implements TextInputLayout.fb {

        /* loaded from: classes.dex */
        public class y implements Runnable {
            public final /* synthetic */ AutoCompleteTextView y;

            public y(AutoCompleteTextView autoCompleteTextView) {
                this.y = autoCompleteTextView;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.y.removeTextChangedListener(n3.this.f6059gv);
            }
        }

        public a() {
        }

        @Override // com.google.android.material.textfield.TextInputLayout.fb
        public void y(@NonNull TextInputLayout textInputLayout, int i) {
            AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) textInputLayout.getEditText();
            if (autoCompleteTextView != null && i == 3) {
                autoCompleteTextView.post(new y(autoCompleteTextView));
                if (autoCompleteTextView.getOnFocusChangeListener() == n3.this.f6064v) {
                    autoCompleteTextView.setOnFocusChangeListener(null);
                }
                autoCompleteTextView.setOnTouchListener(null);
                if (n3.f6054p) {
                    autoCompleteTextView.setOnDismissListener(null);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class c5 implements AutoCompleteTextView.OnDismissListener {
        public c5() {
        }

        @Override // android.widget.AutoCompleteTextView.OnDismissListener
        public void onDismiss() {
            n3.this.f6056c5 = true;
            n3.this.f6057f = System.currentTimeMillis();
            n3.this.ta(false);
        }
    }

    /* loaded from: classes.dex */
    public class fb implements View.OnClickListener {
        public fb() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            n3.this.ej((AutoCompleteTextView) n3.this.y.getEditText());
        }
    }

    /* loaded from: classes.dex */
    public class gv extends TextInputLayout.v {
        public gv(TextInputLayout textInputLayout) {
            super(textInputLayout);
        }

        @Override // com.google.android.material.textfield.TextInputLayout.v, hw.y
        public void fb(View view, @NonNull j5.zn znVar) {
            super.fb(view, znVar);
            if (!n3.mg(n3.this.y.getEditText())) {
                znVar.e(Spinner.class.getName());
            }
            if (znVar.q9()) {
                znVar.bk(null);
            }
        }

        @Override // hw.y
        public void s(View view, @NonNull AccessibilityEvent accessibilityEvent) {
            super.s(view, accessibilityEvent);
            AutoCompleteTextView n2 = n3.n(n3.this.y.getEditText());
            if (accessibilityEvent.getEventType() == 1 && n3.this.f6066wz.isTouchExplorationEnabled() && !n3.mg(n3.this.y.getEditText())) {
                n3.this.ej(n2);
            }
        }
    }

    /* loaded from: classes.dex */
    public class i9 extends AnimatorListenerAdapter {
        public i9() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            n3 n3Var = n3.this;
            n3Var.f7588zn.setChecked(n3Var.f6060i9);
            n3.this.f6065w.start();
        }
    }

    /* renamed from: com.google.android.material.textfield.n3$n3  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0066n3 implements ValueAnimator.AnimatorUpdateListener {
        public C0066n3() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
            n3.this.f7588zn.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    /* loaded from: classes.dex */
    public class s implements View.OnTouchListener {
        public final /* synthetic */ AutoCompleteTextView y;

        public s(AutoCompleteTextView autoCompleteTextView) {
            this.y = autoCompleteTextView;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(@NonNull View view, @NonNull MotionEvent motionEvent) {
            if (motionEvent.getAction() == 1) {
                if (n3.this.rz()) {
                    n3.this.f6056c5 = false;
                }
                n3.this.ej(this.y);
            }
            return false;
        }
    }

    /* loaded from: classes.dex */
    public class v implements TextInputLayout.a {
        public v() {
        }

        @Override // com.google.android.material.textfield.TextInputLayout.a
        public void y(@NonNull TextInputLayout textInputLayout) {
            AutoCompleteTextView n2 = n3.n(textInputLayout.getEditText());
            n3.this.d(n2);
            n3.this.x4(n2);
            n3.this.z6(n2);
            n2.setThreshold(0);
            n2.removeTextChangedListener(n3.this.f6059gv);
            n2.addTextChangedListener(n3.this.f6059gv);
            textInputLayout.setEndIconCheckable(true);
            textInputLayout.setErrorIconDrawable((Drawable) null);
            if (!n3.mg(n2)) {
                i4.o0(n3.this.f7588zn, 2);
            }
            textInputLayout.setTextInputAccessibilityDelegate(n3.this.f6055a);
            textInputLayout.setEndIconVisible(true);
        }
    }

    /* loaded from: classes.dex */
    public class y extends ur.c5 {

        /* renamed from: com.google.android.material.textfield.n3$y$y  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0067y implements Runnable {
            public final /* synthetic */ AutoCompleteTextView y;

            public RunnableC0067y(AutoCompleteTextView autoCompleteTextView) {
                this.y = autoCompleteTextView;
            }

            @Override // java.lang.Runnable
            public void run() {
                boolean isPopupShowing = this.y.isPopupShowing();
                n3.this.ta(isPopupShowing);
                n3.this.f6056c5 = isPopupShowing;
            }
        }

        public y() {
        }

        @Override // ur.c5, android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            AutoCompleteTextView n2 = n3.n(n3.this.y.getEditText());
            if (n3.this.f6066wz.isTouchExplorationEnabled() && n3.mg(n2) && !n3.this.f7588zn.hasFocus()) {
                n2.dismissDropDown();
            }
            n2.post(new RunnableC0067y(n2));
        }
    }

    /* loaded from: classes.dex */
    public class zn implements View.OnFocusChangeListener {
        public zn() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z2) {
            n3.this.y.setEndIconActivated(z2);
            if (!z2) {
                n3.this.ta(false);
                n3.this.f6056c5 = false;
            }
        }
    }

    public n3(@NonNull TextInputLayout textInputLayout) {
        super(textInputLayout);
        this.f6059gv = new y();
        this.f6064v = new zn();
        this.f6055a = new gv(this.y);
        this.f6058fb = new v();
        this.f6061s = new a();
        this.f6056c5 = false;
        this.f6060i9 = false;
        this.f6057f = Long.MAX_VALUE;
    }

    private void fh() {
        this.f6065w = c(67, 0.0f, 1.0f);
        ValueAnimator c2 = c(50, 1.0f, 0.0f);
        this.f6067xc = c2;
        c2.addListener(new i9());
    }

    public static boolean mg(@NonNull EditText editText) {
        if (editText.getKeyListener() != null) {
            return true;
        }
        return false;
    }

    @NonNull
    public static AutoCompleteTextView n(EditText editText) {
        if (editText instanceof AutoCompleteTextView) {
            return (AutoCompleteTextView) editText;
        }
        throw new RuntimeException("EditText needs to be an AutoCompleteTextView if an Exposed Dropdown Menu is being used.");
    }

    public final ValueAnimator c(int i, float... fArr) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(fArr);
        ofFloat.setInterpolator(y6.y.y);
        ofFloat.setDuration(i);
        ofFloat.addUpdateListener(new C0066n3());
        return ofFloat;
    }

    public final void d(@NonNull AutoCompleteTextView autoCompleteTextView) {
        if (f6054p) {
            int boxBackgroundMode = this.y.getBoxBackgroundMode();
            if (boxBackgroundMode == 2) {
                autoCompleteTextView.setDropDownBackgroundDrawable(this.f6063tl);
            } else if (boxBackgroundMode == 1) {
                autoCompleteTextView.setDropDownBackgroundDrawable(this.f6062t);
            }
        }
    }

    public final hx.fb d0(float f4, float f6, float f9, int i) {
        f tl2 = f.y().fh(f4).d(f4).z(f6).f3(f6).tl();
        hx.fb tl3 = hx.fb.tl(this.f7587n3, f9);
        tl3.setShapeAppearanceModel(tl2);
        tl3.en(0, i, 0, i);
        return tl3;
    }

    public final void ej(@Nullable AutoCompleteTextView autoCompleteTextView) {
        if (autoCompleteTextView == null) {
            return;
        }
        if (rz()) {
            this.f6056c5 = false;
        }
        if (!this.f6056c5) {
            if (f6054p) {
                ta(!this.f6060i9);
            } else {
                this.f6060i9 = !this.f6060i9;
                this.f7588zn.toggle();
            }
            if (this.f6060i9) {
                autoCompleteTextView.requestFocus();
                autoCompleteTextView.showDropDown();
                return;
            }
            autoCompleteTextView.dismissDropDown();
            return;
        }
        this.f6056c5 = false;
    }

    public final void f3(@NonNull AutoCompleteTextView autoCompleteTextView, int i, int[][] iArr, @NonNull hx.fb fbVar) {
        LayerDrawable layerDrawable;
        int gv2 = td.y.gv(autoCompleteTextView, R$attr.uh);
        hx.fb fbVar2 = new hx.fb(fbVar.rz());
        int fb2 = td.y.fb(i, gv2, 0.1f);
        fbVar2.k(new ColorStateList(iArr, new int[]{fb2, 0}));
        if (f6054p) {
            fbVar2.setTint(gv2);
            ColorStateList colorStateList = new ColorStateList(iArr, new int[]{fb2, gv2});
            hx.fb fbVar3 = new hx.fb(fbVar.rz());
            fbVar3.setTint(-1);
            layerDrawable = new LayerDrawable(new Drawable[]{new RippleDrawable(colorStateList, fbVar2, fbVar3), fbVar});
        } else {
            layerDrawable = new LayerDrawable(new Drawable[]{fbVar2, fbVar});
        }
        i4.u0(autoCompleteTextView, layerDrawable);
    }

    @Override // e7.zn
    public boolean gv() {
        return true;
    }

    public final void i4(@NonNull AutoCompleteTextView autoCompleteTextView, int i, int[][] iArr, @NonNull hx.fb fbVar) {
        int boxBackgroundColor = this.y.getBoxBackgroundColor();
        int[] iArr2 = {td.y.fb(i, boxBackgroundColor, 0.1f), boxBackgroundColor};
        if (f6054p) {
            i4.u0(autoCompleteTextView, new RippleDrawable(new ColorStateList(iArr, iArr2), fbVar, fbVar));
            return;
        }
        hx.fb fbVar2 = new hx.fb(fbVar.rz());
        fbVar2.k(new ColorStateList(iArr, iArr2));
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{fbVar, fbVar2});
        int a82 = i4.a8(autoCompleteTextView);
        int paddingTop = autoCompleteTextView.getPaddingTop();
        int ud2 = i4.ud(autoCompleteTextView);
        int paddingBottom = autoCompleteTextView.getPaddingBottom();
        i4.u0(autoCompleteTextView, layerDrawable);
        i4.cy(autoCompleteTextView, a82, paddingTop, ud2, paddingBottom);
    }

    @Override // e7.zn
    public boolean n3(int i) {
        return i != 0;
    }

    public final boolean rz() {
        long currentTimeMillis = System.currentTimeMillis() - this.f6057f;
        if (currentTimeMillis >= 0 && currentTimeMillis <= 300) {
            return false;
        }
        return true;
    }

    public final void ta(boolean z2) {
        if (this.f6060i9 != z2) {
            this.f6060i9 = z2;
            this.f6065w.cancel();
            this.f6067xc.start();
        }
    }

    public final void x4(@NonNull AutoCompleteTextView autoCompleteTextView) {
        if (mg(autoCompleteTextView)) {
            return;
        }
        int boxBackgroundMode = this.y.getBoxBackgroundMode();
        hx.fb boxBackground = this.y.getBoxBackground();
        int gv2 = td.y.gv(autoCompleteTextView, R$attr.f5083i9);
        int[][] iArr = {new int[]{16842919}, new int[0]};
        if (boxBackgroundMode == 2) {
            f3(autoCompleteTextView, gv2, iArr, boxBackground);
        } else if (boxBackgroundMode == 1) {
            i4(autoCompleteTextView, gv2, iArr, boxBackground);
        }
    }

    @Override // e7.zn
    public void y() {
        int i;
        float dimensionPixelOffset = this.f7587n3.getResources().getDimensionPixelOffset(R$dimen.mp);
        float dimensionPixelOffset2 = this.f7587n3.getResources().getDimensionPixelOffset(R$dimen.i9);
        int dimensionPixelOffset3 = this.f7587n3.getResources().getDimensionPixelOffset(R$dimen.tr);
        hx.fb d02 = d0(dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset2, dimensionPixelOffset3);
        hx.fb d03 = d0(0.0f, dimensionPixelOffset, dimensionPixelOffset2, dimensionPixelOffset3);
        this.f6063tl = d02;
        StateListDrawable stateListDrawable = new StateListDrawable();
        this.f6062t = stateListDrawable;
        stateListDrawable.addState(new int[]{16842922}, d02);
        this.f6062t.addState(new int[0], d03);
        if (f6054p) {
            i = R$drawable.fu8;
        } else {
            i = R$drawable.fu9;
        }
        this.y.setEndIconDrawable(c5.y.gv(this.f7587n3, i));
        TextInputLayout textInputLayout = this.y;
        textInputLayout.setEndIconContentDescription(textInputLayout.getResources().getText(R$string.zg));
        this.y.setEndIconOnClickListener(new fb());
        this.y.v(this.f6058fb);
        this.y.a(this.f6061s);
        fh();
        this.f6066wz = (AccessibilityManager) this.f7587n3.getSystemService("accessibility");
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public final void z6(@NonNull AutoCompleteTextView autoCompleteTextView) {
        autoCompleteTextView.setOnTouchListener(new s(autoCompleteTextView));
        autoCompleteTextView.setOnFocusChangeListener(this.f6064v);
        if (f6054p) {
            autoCompleteTextView.setOnDismissListener(new c5());
        }
    }
}
