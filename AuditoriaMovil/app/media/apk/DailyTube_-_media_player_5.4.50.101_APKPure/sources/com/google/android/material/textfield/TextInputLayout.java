package com.google.android.material.textfield;

import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStructure;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.R$attr;
import com.google.android.material.R$color;
import com.google.android.material.R$dimen;
import com.google.android.material.R$id;
import com.google.android.material.R$string;
import com.google.android.material.R$style;
import com.google.android.material.internal.CheckableImageButton;
import hw.i4;
import hw.s;
import hx.f;
import j.tl;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import wz.c5;
import wz.n;
/* loaded from: classes.dex */
public class TextInputLayout extends LinearLayout {

    /* renamed from: ne  reason: collision with root package name */
    public static final int f5964ne = R$style.f5108f;

    /* renamed from: ad  reason: collision with root package name */
    public View.OnLongClickListener f5965ad;

    /* renamed from: ap  reason: collision with root package name */
    public boolean f5966ap;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    public ColorStateList f5967b;
    @NonNull

    /* renamed from: bk  reason: collision with root package name */
    public final CheckableImageButton f5968bk;

    /* renamed from: c  reason: collision with root package name */
    public CharSequence f5969c;

    /* renamed from: co  reason: collision with root package name */
    public int f5970co;

    /* renamed from: cr  reason: collision with root package name */
    public boolean f5971cr;

    /* renamed from: cs  reason: collision with root package name */
    public int f5972cs;

    /* renamed from: ct  reason: collision with root package name */
    public int f5973ct;

    /* renamed from: cy  reason: collision with root package name */
    public View.OnLongClickListener f5974cy;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public ColorStateList f5975d;

    /* renamed from: d0  reason: collision with root package name */
    public boolean f5976d0;

    /* renamed from: dm  reason: collision with root package name */
    public int f5977dm;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public final CheckableImageButton f5978e;

    /* renamed from: eb  reason: collision with root package name */
    public final Rect f5979eb;

    /* renamed from: ej  reason: collision with root package name */
    public int f5980ej;
    @NonNull

    /* renamed from: en  reason: collision with root package name */
    public f f5981en;

    /* renamed from: f  reason: collision with root package name */
    public EditText f5982f;

    /* renamed from: f3  reason: collision with root package name */
    public int f5983f3;
    @Nullable

    /* renamed from: f7  reason: collision with root package name */
    public hx.fb f5984f7;
    @NonNull

    /* renamed from: fb  reason: collision with root package name */
    public final LinearLayout f5985fb;

    /* renamed from: fh  reason: collision with root package name */
    public TextView f5986fh;

    /* renamed from: g  reason: collision with root package name */
    public int f5987g;

    /* renamed from: g3  reason: collision with root package name */
    public View.OnLongClickListener f5988g3;

    /* renamed from: gq  reason: collision with root package name */
    public ColorStateList f5989gq;

    /* renamed from: i2  reason: collision with root package name */
    public boolean f5990i2;

    /* renamed from: i3  reason: collision with root package name */
    public ValueAnimator f5991i3;

    /* renamed from: ix  reason: collision with root package name */
    public final ur.y f5992ix;
    @NonNull

    /* renamed from: j  reason: collision with root package name */
    public final TextView f5993j;

    /* renamed from: j3  reason: collision with root package name */
    public boolean f5994j3;
    @Nullable

    /* renamed from: j5  reason: collision with root package name */
    public CharSequence f5995j5;

    /* renamed from: jz  reason: collision with root package name */
    public final int f5996jz;
    @Nullable

    /* renamed from: k  reason: collision with root package name */
    public hx.fb f5997k;
    @Nullable

    /* renamed from: kp  reason: collision with root package name */
    public Drawable f5998kp;

    /* renamed from: l  reason: collision with root package name */
    public ColorStateList f5999l;

    /* renamed from: lc  reason: collision with root package name */
    public final Rect f6000lc;

    /* renamed from: le  reason: collision with root package name */
    public int f6001le;

    /* renamed from: m  reason: collision with root package name */
    public final LinkedHashSet<a> f6002m;

    /* renamed from: mp  reason: collision with root package name */
    public int f6003mp;

    /* renamed from: n  reason: collision with root package name */
    public int f6004n;

    /* renamed from: nf  reason: collision with root package name */
    public final RectF f6005nf;
    @Nullable

    /* renamed from: o  reason: collision with root package name */
    public CharSequence f6006o;
    @Nullable

    /* renamed from: o0  reason: collision with root package name */
    public Drawable f6007o0;

    /* renamed from: o4  reason: collision with root package name */
    public int f6008o4;

    /* renamed from: oa  reason: collision with root package name */
    public int f6009oa;

    /* renamed from: oz  reason: collision with root package name */
    public boolean f6010oz;

    /* renamed from: p  reason: collision with root package name */
    public boolean f6011p;

    /* renamed from: pq  reason: collision with root package name */
    public PorterDuff.Mode f6012pq;

    /* renamed from: pz  reason: collision with root package name */
    public boolean f6013pz;

    /* renamed from: q5  reason: collision with root package name */
    public int f6014q5;

    /* renamed from: q9  reason: collision with root package name */
    public boolean f6015q9;

    /* renamed from: qj  reason: collision with root package name */
    public ColorStateList f6016qj;
    @NonNull

    /* renamed from: qk  reason: collision with root package name */
    public final CheckableImageButton f6017qk;
    @NonNull

    /* renamed from: qn  reason: collision with root package name */
    public final TextView f6018qn;
    @Nullable

    /* renamed from: r  reason: collision with root package name */
    public TextView f6019r;

    /* renamed from: ra  reason: collision with root package name */
    public Typeface f6020ra;

    /* renamed from: rb  reason: collision with root package name */
    public int f6021rb;

    /* renamed from: ro  reason: collision with root package name */
    public boolean f6022ro;

    /* renamed from: rs  reason: collision with root package name */
    public int f6023rs;
    @NonNull

    /* renamed from: s  reason: collision with root package name */
    public final FrameLayout f6024s;

    /* renamed from: s8  reason: collision with root package name */
    public ColorStateList f6025s8;

    /* renamed from: t  reason: collision with root package name */
    public CharSequence f6026t;

    /* renamed from: tg  reason: collision with root package name */
    public ColorStateList f6027tg;

    /* renamed from: u  reason: collision with root package name */
    public int f6028u;

    /* renamed from: u0  reason: collision with root package name */
    public final SparseArray<e7.zn> f6029u0;

    /* renamed from: ut  reason: collision with root package name */
    public CharSequence f6030ut;
    @NonNull

    /* renamed from: v  reason: collision with root package name */
    public final LinearLayout f6031v;

    /* renamed from: vn  reason: collision with root package name */
    public boolean f6032vn;

    /* renamed from: vp  reason: collision with root package name */
    public int f6033vp;

    /* renamed from: w  reason: collision with root package name */
    public final e7.gv f6034w;

    /* renamed from: w2  reason: collision with root package name */
    public ColorStateList f6035w2;

    /* renamed from: w9  reason: collision with root package name */
    public int f6036w9;

    /* renamed from: wf  reason: collision with root package name */
    public Drawable f6037wf;
    @Nullable

    /* renamed from: x  reason: collision with root package name */
    public ColorStateList f6038x;

    /* renamed from: x5  reason: collision with root package name */
    public int f6039x5;

    /* renamed from: xb  reason: collision with root package name */
    public int f6040xb;

    /* renamed from: xg  reason: collision with root package name */
    public int f6041xg;
    @NonNull
    public final FrameLayout y;

    /* renamed from: y4  reason: collision with root package name */
    public final LinkedHashSet<fb> f6042y4;

    /* renamed from: y5  reason: collision with root package name */
    public int f6043y5;

    /* renamed from: yc  reason: collision with root package name */
    public boolean f6044yc;

    /* renamed from: yg  reason: collision with root package name */
    public PorterDuff.Mode f6045yg;

    /* renamed from: yk  reason: collision with root package name */
    public boolean f6046yk;

    /* renamed from: z  reason: collision with root package name */
    public boolean f6047z;

    /* loaded from: classes.dex */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new y();
        @Nullable

        /* renamed from: f  reason: collision with root package name */
        public CharSequence f6048f;
        @Nullable

        /* renamed from: fb  reason: collision with root package name */
        public CharSequence f6049fb;

        /* renamed from: s  reason: collision with root package name */
        public boolean f6050s;
        @Nullable

        /* renamed from: t  reason: collision with root package name */
        public CharSequence f6051t;
        @Nullable

        /* renamed from: w  reason: collision with root package name */
        public CharSequence f6052w;

        /* loaded from: classes.dex */
        public static class y implements Parcelable.ClassLoaderCreator<SavedState> {
            @Override // android.os.Parcelable.ClassLoaderCreator
            @NonNull
            /* renamed from: n3 */
            public SavedState createFromParcel(@NonNull Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            @Nullable
            /* renamed from: y */
            public SavedState createFromParcel(@NonNull Parcel parcel) {
                return new SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            @NonNull
            /* renamed from: zn */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        @NonNull
        public String toString() {
            return "TextInputLayout.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " error=" + ((Object) this.f6049fb) + " hint=" + ((Object) this.f6048f) + " helperText=" + ((Object) this.f6051t) + " placeholderText=" + ((Object) this.f6052w) + "}";
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(@NonNull Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            TextUtils.writeToParcel(this.f6049fb, parcel, i);
            parcel.writeInt(this.f6050s ? 1 : 0);
            TextUtils.writeToParcel(this.f6048f, parcel, i);
            TextUtils.writeToParcel(this.f6051t, parcel, i);
            TextUtils.writeToParcel(this.f6052w, parcel, i);
        }

        public SavedState(@NonNull Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            Parcelable.Creator creator = TextUtils.CHAR_SEQUENCE_CREATOR;
            this.f6049fb = (CharSequence) creator.createFromParcel(parcel);
            this.f6050s = parcel.readInt() == 1;
            this.f6048f = (CharSequence) creator.createFromParcel(parcel);
            this.f6051t = (CharSequence) creator.createFromParcel(parcel);
            this.f6052w = (CharSequence) creator.createFromParcel(parcel);
        }
    }

    /* loaded from: classes.dex */
    public interface a {
        void y(@NonNull TextInputLayout textInputLayout);
    }

    /* loaded from: classes.dex */
    public interface fb {
        void y(@NonNull TextInputLayout textInputLayout, int i);
    }

    /* loaded from: classes.dex */
    public class gv implements ValueAnimator.AnimatorUpdateListener {
        public gv() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
            TextInputLayout.this.f5992ix.ut(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    /* loaded from: classes.dex */
    public class n3 implements Runnable {
        public n3() {
        }

        @Override // java.lang.Runnable
        public void run() {
            TextInputLayout.this.f5968bk.performClick();
            TextInputLayout.this.f5968bk.jumpDrawablesToCurrentState();
        }
    }

    /* loaded from: classes.dex */
    public static class v extends hw.y {

        /* renamed from: gv  reason: collision with root package name */
        public final TextInputLayout f6053gv;

        public v(@NonNull TextInputLayout textInputLayout) {
            this.f6053gv = textInputLayout;
        }

        @Override // hw.y
        public void fb(@NonNull View view, @NonNull j5.zn znVar) {
            CharSequence charSequence;
            boolean z2;
            String str;
            super.fb(view, znVar);
            EditText editText = this.f6053gv.getEditText();
            if (editText != null) {
                charSequence = editText.getText();
            } else {
                charSequence = null;
            }
            CharSequence hint = this.f6053gv.getHint();
            CharSequence error = this.f6053gv.getError();
            CharSequence placeholderText = this.f6053gv.getPlaceholderText();
            int counterMaxLength = this.f6053gv.getCounterMaxLength();
            CharSequence counterOverflowDescription = this.f6053gv.getCounterOverflowDescription();
            boolean isEmpty = TextUtils.isEmpty(charSequence);
            boolean isEmpty2 = TextUtils.isEmpty(hint);
            boolean yt2 = this.f6053gv.yt();
            boolean isEmpty3 = TextUtils.isEmpty(error);
            if (isEmpty3 && TextUtils.isEmpty(counterOverflowDescription)) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (!isEmpty2) {
                str = hint.toString();
            } else {
                str = "";
            }
            if (!isEmpty) {
                znVar.gq(charSequence);
            } else if (!TextUtils.isEmpty(str)) {
                znVar.gq(str);
                if (!yt2 && placeholderText != null) {
                    znVar.gq(str + ", " + ((Object) placeholderText));
                }
            } else if (placeholderText != null) {
                znVar.gq(placeholderText);
            }
            if (!TextUtils.isEmpty(str)) {
                if (Build.VERSION.SDK_INT >= 26) {
                    znVar.bk(str);
                } else {
                    if (!isEmpty) {
                        str = ((Object) charSequence) + ", " + str;
                    }
                    znVar.gq(str);
                }
                znVar.cy(isEmpty);
            }
            znVar.y4((charSequence == null || charSequence.length() != counterMaxLength) ? -1 : -1);
            if (z2) {
                if (isEmpty3) {
                    error = counterOverflowDescription;
                }
                znVar.g3(error);
            }
            if (editText != null) {
                editText.setLabelFor(R$id.textinput_helper_text);
            }
        }
    }

    /* loaded from: classes.dex */
    public class y implements TextWatcher {
        public y() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(@NonNull Editable editable) {
            TextInputLayout textInputLayout = TextInputLayout.this;
            textInputLayout.m(!textInputLayout.f5994j3);
            TextInputLayout textInputLayout2 = TextInputLayout.this;
            if (textInputLayout2.f6011p) {
                textInputLayout2.s8(editable.length());
            }
            if (TextInputLayout.this.f5976d0) {
                TextInputLayout.this.y4(editable.length());
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
    public class zn implements Runnable {
        public zn() {
        }

        @Override // java.lang.Runnable
        public void run() {
            TextInputLayout.this.f5982f.requestLayout();
        }
    }

    public TextInputLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.fd3);
    }

    public static void ap(@NonNull Context context, @NonNull TextView textView, int i, int i5, boolean z2) {
        int i6;
        if (z2) {
            i6 = R$string.gr;
        } else {
            i6 = R$string.gf;
        }
        textView.setContentDescription(context.getString(i6, Integer.valueOf(i), Integer.valueOf(i5)));
    }

    private e7.zn getEndIconDelegate() {
        e7.zn znVar = this.f6029u0.get(this.f5987g);
        if (znVar == null) {
            return this.f6029u0.get(0);
        }
        return znVar;
    }

    @Nullable
    private CheckableImageButton getEndIconToUpdateDummyDrawable() {
        if (this.f6017qk.getVisibility() == 0) {
            return this.f6017qk;
        }
        if (ud() && x()) {
            return this.f5968bk;
        }
        return null;
    }

    public static void oz(@NonNull ViewGroup viewGroup, boolean z2) {
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            childAt.setEnabled(z2);
            if (childAt instanceof ViewGroup) {
                oz((ViewGroup) childAt, z2);
            }
        }
    }

    private void setEditText(EditText editText) {
        if (this.f5982f == null) {
            if (this.f5987g != 3) {
                boolean z2 = editText instanceof TextInputEditText;
            }
            this.f5982f = editText;
            o();
            setTextInputAccessibilityDelegate(new v(this));
            this.f5992ix.u(this.f5982f.getTypeface());
            this.f5992ix.j(this.f5982f.getTextSize());
            int gravity = this.f5982f.getGravity();
            this.f5992ix.b((gravity & (-113)) | 48);
            this.f5992ix.o(gravity);
            this.f5982f.addTextChangedListener(new y());
            if (this.f5999l == null) {
                this.f5999l = this.f5982f.getHintTextColors();
            }
            if (this.f6010oz) {
                if (TextUtils.isEmpty(this.f6030ut)) {
                    CharSequence hint = this.f5982f.getHint();
                    this.f6026t = hint;
                    setHint(hint);
                    this.f5982f.setHint((CharSequence) null);
                }
                this.f6015q9 = true;
            }
            if (this.f6019r != null) {
                s8(this.f5982f.getText().length());
            }
            kp();
            this.f6034w.v();
            this.f6031v.bringToFront();
            this.f5985fb.bringToFront();
            this.f6024s.bringToFront();
            this.f6017qk.bringToFront();
            fh();
            tg();
            cr();
            if (!isEnabled()) {
                editText.setEnabled(false);
            }
            g(false, true);
            return;
        }
        throw new IllegalArgumentException("We already have an EditText, can only have one");
    }

    private void setErrorIconVisible(boolean z2) {
        int i;
        CheckableImageButton checkableImageButton = this.f6017qk;
        int i5 = 8;
        if (z2) {
            i = 0;
        } else {
            i = 8;
        }
        checkableImageButton.setVisibility(i);
        FrameLayout frameLayout = this.f6024s;
        if (!z2) {
            i5 = 0;
        }
        frameLayout.setVisibility(i5);
        cr();
        if (!ud()) {
            yc();
        }
    }

    private void setHintInternal(CharSequence charSequence) {
        if (!TextUtils.equals(charSequence, this.f6030ut)) {
            this.f6030ut = charSequence;
            this.f5992ix.en(charSequence);
            if (!this.f6022ro) {
                j();
            }
        }
    }

    private void setPlaceholderTextEnabled(boolean z2) {
        if (this.f5976d0 == z2) {
            return;
        }
        if (z2) {
            AppCompatTextView appCompatTextView = new AppCompatTextView(getContext());
            this.f5986fh = appCompatTextView;
            appCompatTextView.setId(R$id.textinput_placeholder);
            i4.g(this.f5986fh, 1);
            setPlaceholderTextAppearance(this.f5980ej);
            setPlaceholderTextColor(this.f5975d);
            fb();
        } else {
            en();
            this.f5986fh = null;
        }
        this.f5976d0 = z2;
    }

    public static void u(@NonNull CheckableImageButton checkableImageButton, @Nullable View.OnLongClickListener onLongClickListener) {
        boolean z2;
        boolean qn2 = i4.qn(checkableImageButton);
        boolean z3 = false;
        int i = 1;
        if (onLongClickListener != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        z3 = (qn2 || z2) ? true : true;
        checkableImageButton.setFocusable(z3);
        checkableImageButton.setClickable(qn2);
        checkableImageButton.setPressable(qn2);
        checkableImageButton.setLongClickable(z2);
        if (!z3) {
            i = 2;
        }
        i4.o0(checkableImageButton, i);
    }

    public static void xg(@NonNull CheckableImageButton checkableImageButton, @Nullable View.OnLongClickListener onLongClickListener) {
        checkableImageButton.setOnLongClickListener(onLongClickListener);
        u(checkableImageButton, onLongClickListener);
    }

    public static void y5(@NonNull CheckableImageButton checkableImageButton, @Nullable View.OnClickListener onClickListener, @Nullable View.OnLongClickListener onLongClickListener) {
        checkableImageButton.setOnClickListener(onClickListener);
        u(checkableImageButton, onLongClickListener);
    }

    public void a(@NonNull fb fbVar) {
        this.f6042y4.add(fbVar);
    }

    public final void a8() {
        TextView textView = this.f5986fh;
        if (textView != null && this.f5976d0) {
            textView.setText((CharSequence) null);
            this.f5986fh.setVisibility(4);
        }
    }

    @Override // android.view.ViewGroup
    public void addView(@NonNull View view, int i, @NonNull ViewGroup.LayoutParams layoutParams) {
        if (view instanceof EditText) {
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(layoutParams);
            layoutParams2.gravity = (layoutParams2.gravity & (-113)) | 16;
            this.y.addView(view, layoutParams2);
            this.y.setLayoutParams(layoutParams);
            g3();
            setEditText((EditText) view);
            return;
        }
        super.addView(view, i, layoutParams);
    }

    public final boolean b() {
        if (this.f6017qk.getVisibility() == 0) {
            return true;
        }
        return false;
    }

    public final void bk() {
        int length;
        EditText editText = this.f5982f;
        if (editText == null) {
            length = 0;
        } else {
            length = editText.getText().length();
        }
        y4(length);
    }

    public final void c(boolean z2) {
        ValueAnimator valueAnimator = this.f5991i3;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.f5991i3.cancel();
        }
        if (z2 && this.f5990i2) {
            c5(1.0f);
        } else {
            this.f5992ix.ut(1.0f);
        }
        this.f6022ro = false;
        if (d0()) {
            j();
        }
        bk();
        pz();
        o0();
    }

    public void c5(float f4) {
        if (this.f5992ix.x4() == f4) {
            return;
        }
        if (this.f5991i3 == null) {
            ValueAnimator valueAnimator = new ValueAnimator();
            this.f5991i3 = valueAnimator;
            valueAnimator.setInterpolator(y6.y.f15325n3);
            this.f5991i3.setDuration(167L);
            this.f5991i3.addUpdateListener(new gv());
        }
        this.f5991i3.setFloatValues(this.f5992ix.x4(), f4);
        this.f5991i3.start();
    }

    public final int co(@NonNull Rect rect, @NonNull Rect rect2, float f4) {
        if (hw()) {
            return (int) (rect2.top + f4);
        }
        return rect.bottom - this.f5982f.getCompoundPaddingBottom();
    }

    public final void cr() {
        int i;
        if (this.f5982f == null) {
            return;
        }
        if (!x() && !b()) {
            i = i4.ud(this.f5982f);
        } else {
            i = 0;
        }
        i4.cy(this.f5993j, getContext().getResources().getDimensionPixelSize(R$dimen.x9), this.f5982f.getPaddingTop(), i, this.f5982f.getPaddingBottom());
    }

    public final boolean ct() {
        if ((this.f6017qk.getVisibility() == 0 || ((ud() && x()) || this.f6006o != null)) && this.f5985fb.getMeasuredWidth() > 0) {
            return true;
        }
        return false;
    }

    public final void d(boolean z2) {
        ValueAnimator valueAnimator = this.f5991i3;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.f5991i3.cancel();
        }
        if (z2 && this.f5990i2) {
            c5(0.0f);
        } else {
            this.f5992ix.ut(0.0f);
        }
        if (d0() && ((e7.n3) this.f5997k).lc()) {
            n();
        }
        this.f6022ro = true;
        a8();
        pz();
        o0();
    }

    public final boolean d0() {
        if (this.f6010oz && !TextUtils.isEmpty(this.f6030ut) && (this.f5997k instanceof e7.n3)) {
            return true;
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    @TargetApi(26)
    public void dispatchProvideAutofillStructure(@NonNull ViewStructure viewStructure, int i) {
        EditText editText = this.f5982f;
        if (editText == null) {
            super.dispatchProvideAutofillStructure(viewStructure, i);
            return;
        }
        if (this.f6026t != null) {
            boolean z2 = this.f6015q9;
            this.f6015q9 = false;
            CharSequence hint = editText.getHint();
            this.f5982f.setHint(this.f6026t);
            try {
                super.dispatchProvideAutofillStructure(viewStructure, i);
                return;
            } finally {
                this.f5982f.setHint(hint);
                this.f6015q9 = z2;
            }
        }
        viewStructure.setAutofillId(getAutofillId());
        onProvideAutofillStructure(viewStructure, i);
        onProvideAutofillVirtualStructure(viewStructure, i);
        viewStructure.setChildCount(this.y.getChildCount());
        for (int i5 = 0; i5 < this.y.getChildCount(); i5++) {
            View childAt = this.y.getChildAt(i5);
            ViewStructure newChild = viewStructure.newChild(i5);
            childAt.dispatchProvideAutofillStructure(newChild, i);
            if (childAt == this.f5982f) {
                newChild.setHint(getHint());
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchRestoreInstanceState(@NonNull SparseArray<Parcelable> sparseArray) {
        this.f5994j3 = true;
        super.dispatchRestoreInstanceState(sparseArray);
        this.f5994j3 = false;
    }

    public void dm(@NonNull TextView textView, int i) {
        try {
            tl.xc(textView, i);
        } catch (Exception unused) {
        }
        if (Build.VERSION.SDK_INT >= 23) {
            if (textView.getTextColors().getDefaultColor() != -65281) {
                return;
            }
            tl.xc(textView, R$style.y);
            textView.setTextColor(mg.y.zn(getContext(), R$color.hq));
        }
    }

    @Override // android.view.View
    public void draw(@NonNull Canvas canvas) {
        super.draw(canvas);
        ta(canvas);
        mg(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        boolean z2;
        if (this.f6032vn) {
            return;
        }
        boolean z3 = true;
        this.f6032vn = true;
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        ur.y yVar = this.f5992ix;
        if (yVar != null) {
            z2 = yVar.f7(drawableState);
        } else {
            z2 = false;
        }
        if (this.f5982f != null) {
            m((i4.q9(this) && isEnabled()) ? false : false);
        }
        kp();
        xb();
        if (z2) {
            invalidate();
        }
        this.f6032vn = false;
    }

    public final void e() {
        int length;
        if (this.f6019r != null) {
            EditText editText = this.f5982f;
            if (editText == null) {
                length = 0;
            } else {
                length = editText.getText().length();
            }
            s8(length);
        }
    }

    public final void eb() {
        TextView textView = this.f5986fh;
        if (textView != null && this.f5976d0) {
            textView.setText(this.f5969c);
            this.f5986fh.setVisibility(0);
            this.f5986fh.bringToFront();
        }
    }

    public final int ej(int i, boolean z2) {
        int compoundPaddingRight = i - this.f5982f.getCompoundPaddingRight();
        if (this.f5995j5 != null && z2) {
            return compoundPaddingRight + (this.f6018qn.getMeasuredWidth() - this.f6018qn.getPaddingRight());
        }
        return compoundPaddingRight;
    }

    public final void en() {
        TextView textView = this.f5986fh;
        if (textView != null) {
            textView.setVisibility(8);
        }
    }

    public final void f() {
        if (this.f5984f7 == null) {
            return;
        }
        if (f3()) {
            this.f5984f7.k(ColorStateList.valueOf(this.f6008o4));
        }
        invalidate();
    }

    public final boolean f3() {
        if (this.f6041xg > -1 && this.f6008o4 != 0) {
            return true;
        }
        return false;
    }

    public void f7() {
        k(this.f5978e, this.f6025s8);
    }

    public final void fb() {
        TextView textView = this.f5986fh;
        if (textView != null) {
            this.y.addView(textView);
            this.f5986fh.setVisibility(0);
        }
    }

    public final void fh() {
        Iterator<a> it = this.f6002m.iterator();
        while (it.hasNext()) {
            it.next().y(this);
        }
    }

    public final void g(boolean z2, boolean z3) {
        boolean z4;
        ColorStateList colorStateList;
        TextView textView;
        int i;
        boolean isEnabled = isEnabled();
        EditText editText = this.f5982f;
        boolean z5 = false;
        if (editText != null && !TextUtils.isEmpty(editText.getText())) {
            z4 = true;
        } else {
            z4 = false;
        }
        EditText editText2 = this.f5982f;
        if (editText2 != null && editText2.hasFocus()) {
            z5 = true;
        }
        boolean f4 = this.f6034w.f();
        ColorStateList colorStateList2 = this.f5999l;
        if (colorStateList2 != null) {
            this.f5992ix.x(colorStateList2);
            this.f5992ix.qn(this.f5999l);
        }
        if (!isEnabled) {
            ColorStateList colorStateList3 = this.f5999l;
            if (colorStateList3 != null) {
                i = colorStateList3.getColorForState(new int[]{-16842910}, this.f5972cs);
            } else {
                i = this.f5972cs;
            }
            this.f5992ix.x(ColorStateList.valueOf(i));
            this.f5992ix.qn(ColorStateList.valueOf(i));
        } else if (f4) {
            this.f5992ix.x(this.f6034w.w());
        } else if (this.f6047z && (textView = this.f6019r) != null) {
            this.f5992ix.x(textView.getTextColors());
        } else if (z5 && (colorStateList = this.f5989gq) != null) {
            this.f5992ix.x(colorStateList);
        }
        if (!z4 && this.f6046yk && (!isEnabled() || !z5)) {
            if (z3 || !this.f6022ro) {
                d(z2);
            }
        } else if (z3 || this.f6022ro) {
            c(z2);
        }
    }

    public final void g3() {
        if (this.f6028u != 1) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.y.getLayoutParams();
            int x42 = x4();
            if (x42 != layoutParams.topMargin) {
                layoutParams.topMargin = x42;
                this.y.requestLayout();
            }
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public int getBaseline() {
        EditText editText = this.f5982f;
        if (editText != null) {
            return editText.getBaseline() + getPaddingTop() + x4();
        }
        return super.getBaseline();
    }

    @NonNull
    public hx.fb getBoxBackground() {
        int i = this.f6028u;
        if (i != 1 && i != 2) {
            throw new IllegalStateException();
        }
        return this.f5997k;
    }

    public int getBoxBackgroundColor() {
        return this.f6023rs;
    }

    public int getBoxBackgroundMode() {
        return this.f6028u;
    }

    public float getBoxCornerRadiusBottomEnd() {
        return this.f5997k.co();
    }

    public float getBoxCornerRadiusBottomStart() {
        return this.f5997k.z();
    }

    public float getBoxCornerRadiusTopEnd() {
        return this.f5997k.z6();
    }

    public float getBoxCornerRadiusTopStart() {
        return this.f5997k.d();
    }

    public int getBoxStrokeColor() {
        return this.f6036w9;
    }

    @Nullable
    public ColorStateList getBoxStrokeErrorColor() {
        return this.f6035w2;
    }

    public int getBoxStrokeWidth() {
        return this.f5977dm;
    }

    public int getBoxStrokeWidthFocused() {
        return this.f5973ct;
    }

    public int getCounterMaxLength() {
        return this.f5970co;
    }

    @Nullable
    public CharSequence getCounterOverflowDescription() {
        TextView textView;
        if (this.f6011p && this.f6047z && (textView = this.f6019r) != null) {
            return textView.getContentDescription();
        }
        return null;
    }

    @Nullable
    public ColorStateList getCounterOverflowTextColor() {
        return this.f6038x;
    }

    @Nullable
    public ColorStateList getCounterTextColor() {
        return this.f6038x;
    }

    @Nullable
    public ColorStateList getDefaultHintTextColor() {
        return this.f5999l;
    }

    @Nullable
    public EditText getEditText() {
        return this.f5982f;
    }

    @Nullable
    public CharSequence getEndIconContentDescription() {
        return this.f5968bk.getContentDescription();
    }

    @Nullable
    public Drawable getEndIconDrawable() {
        return this.f5968bk.getDrawable();
    }

    public int getEndIconMode() {
        return this.f5987g;
    }

    @NonNull
    public CheckableImageButton getEndIconView() {
        return this.f5968bk;
    }

    @Nullable
    public CharSequence getError() {
        if (this.f6034w.f3()) {
            return this.f6034w.wz();
        }
        return null;
    }

    @Nullable
    public CharSequence getErrorContentDescription() {
        return this.f6034w.tl();
    }

    public int getErrorCurrentTextColors() {
        return this.f6034w.xc();
    }

    @Nullable
    public Drawable getErrorIconDrawable() {
        return this.f6017qk.getDrawable();
    }

    public final int getErrorTextCurrentColor() {
        return this.f6034w.xc();
    }

    @Nullable
    public CharSequence getHelperText() {
        if (this.f6034w.n()) {
            return this.f6034w.p();
        }
        return null;
    }

    public int getHelperTextCurrentTextColor() {
        return this.f6034w.mt();
    }

    @Nullable
    public CharSequence getHint() {
        if (this.f6010oz) {
            return this.f6030ut;
        }
        return null;
    }

    public final float getHintCollapsedTextHeight() {
        return this.f5992ix.xc();
    }

    public final int getHintCurrentCollapsedTextColor() {
        return this.f5992ix.mt();
    }

    @Nullable
    public ColorStateList getHintTextColor() {
        return this.f5989gq;
    }

    @Nullable
    @Deprecated
    public CharSequence getPasswordVisibilityToggleContentDescription() {
        return this.f5968bk.getContentDescription();
    }

    @Nullable
    @Deprecated
    public Drawable getPasswordVisibilityToggleDrawable() {
        return this.f5968bk.getDrawable();
    }

    @Nullable
    public CharSequence getPlaceholderText() {
        if (this.f5976d0) {
            return this.f5969c;
        }
        return null;
    }

    public int getPlaceholderTextAppearance() {
        return this.f5980ej;
    }

    @Nullable
    public ColorStateList getPlaceholderTextColor() {
        return this.f5975d;
    }

    @Nullable
    public CharSequence getPrefixText() {
        return this.f5995j5;
    }

    @Nullable
    public ColorStateList getPrefixTextColor() {
        return this.f6018qn.getTextColors();
    }

    @NonNull
    public TextView getPrefixTextView() {
        return this.f6018qn;
    }

    @Nullable
    public CharSequence getStartIconContentDescription() {
        return this.f5978e.getContentDescription();
    }

    @Nullable
    public Drawable getStartIconDrawable() {
        return this.f5978e.getDrawable();
    }

    @Nullable
    public CharSequence getSuffixText() {
        return this.f6006o;
    }

    @Nullable
    public ColorStateList getSuffixTextColor() {
        return this.f5993j.getTextColors();
    }

    @NonNull
    public TextView getSuffixTextView() {
        return this.f5993j;
    }

    @Nullable
    public Typeface getTypeface() {
        return this.f6020ra;
    }

    public final boolean hw() {
        if (this.f6028u == 1 && this.f5982f.getMinLines() <= 1) {
            return true;
        }
        return false;
    }

    public final boolean i4() {
        if (this.f6028u == 2 && f3()) {
            return true;
        }
        return false;
    }

    public final void i9() {
        hx.fb fbVar = this.f5997k;
        if (fbVar == null) {
            return;
        }
        fbVar.setShapeAppearanceModel(this.f5981en);
        if (i4()) {
            this.f5997k.y5(this.f6041xg, this.f6008o4);
        }
        int p2 = p();
        this.f6023rs = p2;
        this.f5997k.k(ColorStateList.valueOf(p2));
        if (this.f5987g == 3) {
            this.f5982f.getBackground().invalidateSelf();
        }
        f();
        invalidate();
    }

    public final void j() {
        if (!d0()) {
            return;
        }
        RectF rectF = this.f6005nf;
        this.f5992ix.tl(rectF, this.f5982f.getWidth(), this.f5982f.getGravity());
        t(rectF);
        rectF.offset(-getPaddingLeft(), -getPaddingTop());
        ((e7.n3) this.f5997k).yg(rectF);
    }

    public boolean j5() {
        if (this.f5978e.getVisibility() == 0) {
            return true;
        }
        return false;
    }

    public final void jz() {
        if (rs()) {
            i4.u0(this.f5982f, this.f5997k);
        }
    }

    public final void k(CheckableImageButton checkableImageButton, ColorStateList colorStateList) {
        Drawable drawable = checkableImageButton.getDrawable();
        if (checkableImageButton.getDrawable() != null && colorStateList != null && colorStateList.isStateful()) {
            int colorForState = colorStateList.getColorForState(qn(checkableImageButton), colorStateList.getDefaultColor());
            Drawable mutate = ej.y.mt(drawable).mutate();
            ej.y.xc(mutate, ColorStateList.valueOf(colorForState));
            checkableImageButton.setImageDrawable(mutate);
        }
    }

    public boolean k5() {
        return this.f6034w.n();
    }

    public void kp() {
        Drawable background;
        TextView textView;
        EditText editText = this.f5982f;
        if (editText == null || this.f6028u != 0 || (background = editText.getBackground()) == null) {
            return;
        }
        if (n.y(background)) {
            background = background.mutate();
        }
        if (this.f6034w.f()) {
            background.setColorFilter(c5.v(this.f6034w.xc(), PorterDuff.Mode.SRC_IN));
        } else if (this.f6047z && (textView = this.f6019r) != null) {
            background.setColorFilter(c5.v(textView.getCurrentTextColor(), PorterDuff.Mode.SRC_IN));
        } else {
            ej.y.zn(background);
            this.f5982f.refreshDrawableState();
        }
    }

    public final void lc(boolean z2) {
        if (z2 && getEndIconDrawable() != null) {
            Drawable mutate = ej.y.mt(getEndIconDrawable()).mutate();
            ej.y.wz(mutate, this.f6034w.xc());
            this.f5968bk.setImageDrawable(mutate);
            return;
        }
        tl();
    }

    public void m(boolean z2) {
        g(z2, false);
    }

    public final void mg(Canvas canvas) {
        hx.fb fbVar = this.f5984f7;
        if (fbVar != null) {
            Rect bounds = fbVar.getBounds();
            bounds.top = bounds.bottom - this.f6041xg;
            this.f5984f7.draw(canvas);
        }
    }

    @NonNull
    public final Rect mt(@NonNull Rect rect) {
        boolean z2;
        if (this.f5982f != null) {
            Rect rect2 = this.f6000lc;
            if (i4.ta(this) == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            rect2.bottom = rect.bottom;
            int i = this.f6028u;
            if (i != 1) {
                if (i != 2) {
                    rect2.left = z6(rect.left, z2);
                    rect2.top = getPaddingTop();
                    rect2.right = ej(rect.right, z2);
                    return rect2;
                }
                rect2.left = rect.left + this.f5982f.getPaddingLeft();
                rect2.top = rect.top - x4();
                rect2.right = rect.right - this.f5982f.getPaddingRight();
                return rect2;
            }
            rect2.left = z6(rect.left, z2);
            rect2.top = rect.top + this.f6043y5;
            rect2.right = ej(rect.right, z2);
            return rect2;
        }
        throw new IllegalStateException();
    }

    public final void n() {
        if (d0()) {
            ((e7.n3) this.f5997k).e();
        }
    }

    public final void nf() {
        if (this.f6028u == 1) {
            if (pv.zn.s(getContext())) {
                this.f6043y5 = getResources().getDimensionPixelSize(R$dimen.co);
            } else if (pv.zn.fb(getContext())) {
                this.f6043y5 = getResources().getDimensionPixelSize(R$dimen.mt);
            }
        }
    }

    public final void o() {
        w();
        jz();
        xb();
        nf();
        s();
        if (this.f6028u != 0) {
            g3();
        }
    }

    public final void o0() {
        boolean z2;
        int visibility = this.f5993j.getVisibility();
        int i = 0;
        if (this.f6006o != null && !yt()) {
            z2 = true;
        } else {
            z2 = false;
        }
        TextView textView = this.f5993j;
        if (!z2) {
            i = 8;
        }
        textView.setVisibility(i);
        if (visibility != this.f5993j.getVisibility()) {
            getEndIconDelegate().zn(z2);
        }
        yc();
    }

    public final boolean o4() {
        if ((getStartIconDrawable() != null || this.f5995j5 != null) && this.f6031v.getMeasuredWidth() > 0) {
            return true;
        }
        return false;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z2, int i, int i5, int i6, int i8) {
        super.onLayout(z2, i, i5, i6, i8);
        EditText editText = this.f5982f;
        if (editText != null) {
            Rect rect = this.f5979eb;
            ur.n3.y(this, editText, rect);
            ra(rect);
            if (this.f6010oz) {
                this.f5992ix.j(this.f5982f.getTextSize());
                int gravity = this.f5982f.getGravity();
                this.f5992ix.b((gravity & (-113)) | 48);
                this.f5992ix.o(gravity);
                this.f5992ix.ej(mt(rect));
                this.f5992ix.hw(r(rect));
                this.f5992ix.ta();
                if (d0() && !this.f6022ro) {
                    j();
                }
            }
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i, int i5) {
        super.onMeasure(i, i5);
        boolean rb2 = rb();
        boolean yc2 = yc();
        if (rb2 || yc2) {
            this.f5982f.post(new zn());
        }
        u0();
        tg();
        cr();
    }

    @Override // android.view.View
    public void onRestoreInstanceState(@Nullable Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.y());
        setError(savedState.f6049fb);
        if (savedState.f6050s) {
            this.f5968bk.post(new n3());
        }
        setHint(savedState.f6048f);
        setHelperText(savedState.f6051t);
        setPlaceholderText(savedState.f6052w);
        requestLayout();
    }

    @Override // android.view.View
    @Nullable
    public Parcelable onSaveInstanceState() {
        boolean z2;
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        if (this.f6034w.f()) {
            savedState.f6049fb = getError();
        }
        if (ud() && this.f5968bk.isChecked()) {
            z2 = true;
        } else {
            z2 = false;
        }
        savedState.f6050s = z2;
        savedState.f6048f = getHint();
        savedState.f6051t = getHelperText();
        savedState.f6052w = getPlaceholderText();
        return savedState;
    }

    public final int p() {
        int i = this.f6023rs;
        if (this.f6028u == 1) {
            return td.y.a(td.y.v(this, R$attr.uh, 0), this.f6023rs);
        }
        return i;
    }

    public final void pq(boolean z2, boolean z3) {
        int defaultColor = this.f6035w2.getDefaultColor();
        int colorForState = this.f6035w2.getColorForState(new int[]{16843623, 16842910}, defaultColor);
        int colorForState2 = this.f6035w2.getColorForState(new int[]{16843518, 16842910}, defaultColor);
        if (z2) {
            this.f6008o4 = colorForState2;
        } else if (z3) {
            this.f6008o4 = colorForState;
        } else {
            this.f6008o4 = defaultColor;
        }
    }

    public final void pz() {
        int i;
        TextView textView = this.f6018qn;
        if (this.f5995j5 != null && !yt()) {
            i = 0;
        } else {
            i = 8;
        }
        textView.setVisibility(i);
        yc();
    }

    public void q9() {
        k(this.f6017qk, this.f6016qj);
    }

    public final int[] qn(CheckableImageButton checkableImageButton) {
        int[] drawableState = getDrawableState();
        int[] drawableState2 = checkableImageButton.getDrawableState();
        int length = drawableState.length;
        int[] copyOf = Arrays.copyOf(drawableState, drawableState.length + drawableState2.length);
        System.arraycopy(drawableState2, 0, copyOf, length, drawableState2.length);
        return copyOf;
    }

    @NonNull
    public final Rect r(@NonNull Rect rect) {
        if (this.f5982f != null) {
            Rect rect2 = this.f6000lc;
            float r2 = this.f5992ix.r();
            rect2.left = rect.left + this.f5982f.getCompoundPaddingLeft();
            rect2.top = z(rect, r2);
            rect2.right = rect.right - this.f5982f.getCompoundPaddingRight();
            rect2.bottom = co(rect, rect2, r2);
            return rect2;
        }
        throw new IllegalStateException();
    }

    public final void ra(@NonNull Rect rect) {
        hx.fb fbVar = this.f5984f7;
        if (fbVar != null) {
            int i = rect.bottom;
            fbVar.setBounds(rect.left, i - this.f5973ct, rect.right, i);
        }
    }

    public final boolean rb() {
        int max;
        if (this.f5982f == null || this.f5982f.getMeasuredHeight() >= (max = Math.max(this.f5985fb.getMeasuredHeight(), this.f6031v.getMeasuredHeight()))) {
            return false;
        }
        this.f5982f.setMinimumHeight(max);
        return true;
    }

    public final boolean rs() {
        EditText editText = this.f5982f;
        if (editText != null && this.f5997k != null && editText.getBackground() == null && this.f6028u != 0) {
            return true;
        }
        return false;
    }

    public final void rz(int i) {
        Iterator<fb> it = this.f6042y4.iterator();
        while (it.hasNext()) {
            it.next().y(this, i);
        }
    }

    public final void s() {
        if (this.f5982f != null && this.f6028u == 1) {
            if (pv.zn.s(getContext())) {
                EditText editText = this.f5982f;
                i4.cy(editText, i4.a8(editText), getResources().getDimensionPixelSize(R$dimen.x3), i4.ud(this.f5982f), getResources().getDimensionPixelSize(R$dimen.x2));
            } else if (pv.zn.fb(getContext())) {
                EditText editText2 = this.f5982f;
                i4.cy(editText2, i4.a8(editText2), getResources().getDimensionPixelSize(R$dimen.x1), i4.ud(this.f5982f), getResources().getDimensionPixelSize(R$dimen.x0));
            }
        }
    }

    public void s8(int i) {
        boolean z2;
        boolean z3 = this.f6047z;
        int i5 = this.f5970co;
        if (i5 == -1) {
            this.f6019r.setText(String.valueOf(i));
            this.f6019r.setContentDescription(null);
            this.f6047z = false;
        } else {
            if (i > i5) {
                z2 = true;
            } else {
                z2 = false;
            }
            this.f6047z = z2;
            ap(getContext(), this.f6019r, i, this.f5970co, this.f6047z);
            if (z3 != this.f6047z) {
                yg();
            }
            this.f6019r.setText(yt.y.zn().i9(getContext().getString(R$string.gs, Integer.valueOf(i), Integer.valueOf(this.f5970co))));
        }
        if (this.f5982f != null && z3 != this.f6047z) {
            m(false);
            xb();
            kp();
        }
    }

    public void setBoxBackgroundColor(int i) {
        if (this.f6023rs != i) {
            this.f6023rs = i;
            this.f6039x5 = i;
            this.f6003mp = i;
            this.f6001le = i;
            i9();
        }
    }

    public void setBoxBackgroundColorResource(int i) {
        setBoxBackgroundColor(mg.y.zn(getContext(), i));
    }

    public void setBoxBackgroundColorStateList(@NonNull ColorStateList colorStateList) {
        int defaultColor = colorStateList.getDefaultColor();
        this.f6039x5 = defaultColor;
        this.f6023rs = defaultColor;
        this.f6014q5 = colorStateList.getColorForState(new int[]{-16842910}, -1);
        this.f6003mp = colorStateList.getColorForState(new int[]{16842908, 16842910}, -1);
        this.f6001le = colorStateList.getColorForState(new int[]{16843623, 16842910}, -1);
        i9();
    }

    public void setBoxBackgroundMode(int i) {
        if (i == this.f6028u) {
            return;
        }
        this.f6028u = i;
        if (this.f5982f != null) {
            o();
        }
    }

    public void setBoxStrokeColor(int i) {
        if (this.f6036w9 != i) {
            this.f6036w9 = i;
            xb();
        }
    }

    public void setBoxStrokeColorStateList(@NonNull ColorStateList colorStateList) {
        if (colorStateList.isStateful()) {
            this.f6033vp = colorStateList.getDefaultColor();
            this.f5972cs = colorStateList.getColorForState(new int[]{-16842910}, -1);
            this.f6009oa = colorStateList.getColorForState(new int[]{16843623, 16842910}, -1);
            this.f6036w9 = colorStateList.getColorForState(new int[]{16842908, 16842910}, -1);
        } else if (this.f6036w9 != colorStateList.getDefaultColor()) {
            this.f6036w9 = colorStateList.getDefaultColor();
        }
        xb();
    }

    public void setBoxStrokeErrorColor(@Nullable ColorStateList colorStateList) {
        if (this.f6035w2 != colorStateList) {
            this.f6035w2 = colorStateList;
            xb();
        }
    }

    public void setBoxStrokeWidth(int i) {
        this.f5977dm = i;
        xb();
    }

    public void setBoxStrokeWidthFocused(int i) {
        this.f5973ct = i;
        xb();
    }

    public void setBoxStrokeWidthFocusedResource(int i) {
        setBoxStrokeWidthFocused(getResources().getDimensionPixelSize(i));
    }

    public void setBoxStrokeWidthResource(int i) {
        setBoxStrokeWidth(getResources().getDimensionPixelSize(i));
    }

    public void setCounterEnabled(boolean z2) {
        if (this.f6011p != z2) {
            if (z2) {
                AppCompatTextView appCompatTextView = new AppCompatTextView(getContext());
                this.f6019r = appCompatTextView;
                appCompatTextView.setId(R$id.textinput_counter);
                Typeface typeface = this.f6020ra;
                if (typeface != null) {
                    this.f6019r.setTypeface(typeface);
                }
                this.f6019r.setMaxLines(1);
                this.f6034w.gv(this.f6019r, 2);
                s.gv((ViewGroup.MarginLayoutParams) this.f6019r.getLayoutParams(), getResources().getDimensionPixelOffset(R$dimen.cj));
                yg();
                e();
            } else {
                this.f6034w.c(this.f6019r, 2);
                this.f6019r = null;
            }
            this.f6011p = z2;
        }
    }

    public void setCounterMaxLength(int i) {
        if (this.f5970co != i) {
            if (i > 0) {
                this.f5970co = i;
            } else {
                this.f5970co = -1;
            }
            if (this.f6011p) {
                e();
            }
        }
    }

    public void setCounterOverflowTextAppearance(int i) {
        if (this.f5983f3 != i) {
            this.f5983f3 = i;
            yg();
        }
    }

    public void setCounterOverflowTextColor(@Nullable ColorStateList colorStateList) {
        if (this.f5967b != colorStateList) {
            this.f5967b = colorStateList;
            yg();
        }
    }

    public void setCounterTextAppearance(int i) {
        if (this.f6004n != i) {
            this.f6004n = i;
            yg();
        }
    }

    public void setCounterTextColor(@Nullable ColorStateList colorStateList) {
        if (this.f6038x != colorStateList) {
            this.f6038x = colorStateList;
            yg();
        }
    }

    public void setDefaultHintTextColor(@Nullable ColorStateList colorStateList) {
        this.f5999l = colorStateList;
        this.f5989gq = colorStateList;
        if (this.f5982f != null) {
            m(false);
        }
    }

    @Override // android.view.View
    public void setEnabled(boolean z2) {
        oz(this, z2);
        super.setEnabled(z2);
    }

    public void setEndIconActivated(boolean z2) {
        this.f5968bk.setActivated(z2);
    }

    public void setEndIconCheckable(boolean z2) {
        this.f5968bk.setCheckable(z2);
    }

    public void setEndIconContentDescription(int i) {
        setEndIconContentDescription(i != 0 ? getResources().getText(i) : null);
    }

    public void setEndIconDrawable(int i) {
        setEndIconDrawable(i != 0 ? c5.y.gv(getContext(), i) : null);
    }

    public void setEndIconMode(int i) {
        boolean z2;
        int i5 = this.f5987g;
        this.f5987g = i;
        rz(i5);
        if (i != 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        setEndIconVisible(z2);
        if (getEndIconDelegate().n3(this.f6028u)) {
            getEndIconDelegate().y();
            tl();
            return;
        }
        throw new IllegalStateException("The current box background mode " + this.f6028u + " is not supported by the end icon mode " + i);
    }

    public void setEndIconOnClickListener(@Nullable View.OnClickListener onClickListener) {
        y5(this.f5968bk, onClickListener, this.f5965ad);
    }

    public void setEndIconOnLongClickListener(@Nullable View.OnLongClickListener onLongClickListener) {
        this.f5965ad = onLongClickListener;
        xg(this.f5968bk, onLongClickListener);
    }

    public void setEndIconTintList(@Nullable ColorStateList colorStateList) {
        if (this.f6027tg != colorStateList) {
            this.f6027tg = colorStateList;
            this.f6013pz = true;
            tl();
        }
    }

    public void setEndIconTintMode(@Nullable PorterDuff.Mode mode) {
        if (this.f6012pq != mode) {
            this.f6012pq = mode;
            this.f5971cr = true;
            tl();
        }
    }

    public void setEndIconVisible(boolean z2) {
        int i;
        if (x() != z2) {
            CheckableImageButton checkableImageButton = this.f5968bk;
            if (z2) {
                i = 0;
            } else {
                i = 8;
            }
            checkableImageButton.setVisibility(i);
            cr();
            yc();
        }
    }

    public void setError(@Nullable CharSequence charSequence) {
        if (!this.f6034w.f3()) {
            if (TextUtils.isEmpty(charSequence)) {
                return;
            }
            setErrorEnabled(true);
        }
        if (!TextUtils.isEmpty(charSequence)) {
            this.f6034w.k5(charSequence);
        } else {
            this.f6034w.z();
        }
    }

    public void setErrorContentDescription(@Nullable CharSequence charSequence) {
        this.f6034w.fh(charSequence);
    }

    public void setErrorEnabled(boolean z2) {
        this.f6034w.rz(z2);
    }

    public void setErrorIconDrawable(int i) {
        setErrorIconDrawable(i != 0 ? c5.y.gv(getContext(), i) : null);
        q9();
    }

    public void setErrorIconOnClickListener(@Nullable View.OnClickListener onClickListener) {
        y5(this.f6017qk, onClickListener, this.f5974cy);
    }

    public void setErrorIconOnLongClickListener(@Nullable View.OnLongClickListener onLongClickListener) {
        this.f5974cy = onLongClickListener;
        xg(this.f6017qk, onLongClickListener);
    }

    public void setErrorIconTintList(@Nullable ColorStateList colorStateList) {
        this.f6016qj = colorStateList;
        Drawable drawable = this.f6017qk.getDrawable();
        if (drawable != null) {
            drawable = ej.y.mt(drawable).mutate();
            ej.y.xc(drawable, colorStateList);
        }
        if (this.f6017qk.getDrawable() != drawable) {
            this.f6017qk.setImageDrawable(drawable);
        }
    }

    public void setErrorIconTintMode(@Nullable PorterDuff.Mode mode) {
        Drawable drawable = this.f6017qk.getDrawable();
        if (drawable != null) {
            drawable = ej.y.mt(drawable).mutate();
            ej.y.w(drawable, mode);
        }
        if (this.f6017qk.getDrawable() != drawable) {
            this.f6017qk.setImageDrawable(drawable);
        }
    }

    public void setErrorTextAppearance(int i) {
        this.f6034w.mg(i);
    }

    public void setErrorTextColor(@Nullable ColorStateList colorStateList) {
        this.f6034w.ta(colorStateList);
    }

    public void setExpandedHintEnabled(boolean z2) {
        if (this.f6046yk != z2) {
            this.f6046yk = z2;
            m(false);
        }
    }

    public void setHelperText(@Nullable CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            if (k5()) {
                setHelperTextEnabled(false);
                return;
            }
            return;
        }
        if (!k5()) {
            setHelperTextEnabled(true);
        }
        this.f6034w.yt(charSequence);
    }

    public void setHelperTextColor(@Nullable ColorStateList colorStateList) {
        this.f6034w.ej(colorStateList);
    }

    public void setHelperTextEnabled(boolean z2) {
        this.f6034w.z6(z2);
    }

    public void setHelperTextTextAppearance(int i) {
        this.f6034w.d(i);
    }

    public void setHint(@Nullable CharSequence charSequence) {
        if (this.f6010oz) {
            setHintInternal(charSequence);
            sendAccessibilityEvent(2048);
        }
    }

    public void setHintAnimationEnabled(boolean z2) {
        this.f5990i2 = z2;
    }

    public void setHintEnabled(boolean z2) {
        if (z2 != this.f6010oz) {
            this.f6010oz = z2;
            if (!z2) {
                this.f6015q9 = false;
                if (!TextUtils.isEmpty(this.f6030ut) && TextUtils.isEmpty(this.f5982f.getHint())) {
                    this.f5982f.setHint(this.f6030ut);
                }
                setHintInternal(null);
            } else {
                CharSequence hint = this.f5982f.getHint();
                if (!TextUtils.isEmpty(hint)) {
                    if (TextUtils.isEmpty(this.f6030ut)) {
                        setHint(hint);
                    }
                    this.f5982f.setHint((CharSequence) null);
                }
                this.f6015q9 = true;
            }
            if (this.f5982f != null) {
                g3();
            }
        }
    }

    public void setHintTextAppearance(int i) {
        this.f5992ix.ud(i);
        this.f5989gq = this.f5992ix.wz();
        if (this.f5982f != null) {
            m(false);
            g3();
        }
    }

    public void setHintTextColor(@Nullable ColorStateList colorStateList) {
        if (this.f5989gq != colorStateList) {
            if (this.f5999l == null) {
                this.f5992ix.x(colorStateList);
            }
            this.f5989gq = colorStateList;
            if (this.f5982f != null) {
                m(false);
            }
        }
    }

    @Deprecated
    public void setPasswordVisibilityToggleContentDescription(int i) {
        setPasswordVisibilityToggleContentDescription(i != 0 ? getResources().getText(i) : null);
    }

    @Deprecated
    public void setPasswordVisibilityToggleDrawable(int i) {
        setPasswordVisibilityToggleDrawable(i != 0 ? c5.y.gv(getContext(), i) : null);
    }

    @Deprecated
    public void setPasswordVisibilityToggleEnabled(boolean z2) {
        if (z2 && this.f5987g != 1) {
            setEndIconMode(1);
        } else if (!z2) {
            setEndIconMode(0);
        }
    }

    @Deprecated
    public void setPasswordVisibilityToggleTintList(@Nullable ColorStateList colorStateList) {
        this.f6027tg = colorStateList;
        this.f6013pz = true;
        tl();
    }

    @Deprecated
    public void setPasswordVisibilityToggleTintMode(@Nullable PorterDuff.Mode mode) {
        this.f6012pq = mode;
        this.f5971cr = true;
        tl();
    }

    public void setPlaceholderText(@Nullable CharSequence charSequence) {
        if (this.f5976d0 && TextUtils.isEmpty(charSequence)) {
            setPlaceholderTextEnabled(false);
        } else {
            if (!this.f5976d0) {
                setPlaceholderTextEnabled(true);
            }
            this.f5969c = charSequence;
        }
        bk();
    }

    public void setPlaceholderTextAppearance(int i) {
        this.f5980ej = i;
        TextView textView = this.f5986fh;
        if (textView != null) {
            tl.xc(textView, i);
        }
    }

    public void setPlaceholderTextColor(@Nullable ColorStateList colorStateList) {
        if (this.f5975d != colorStateList) {
            this.f5975d = colorStateList;
            TextView textView = this.f5986fh;
            if (textView != null && colorStateList != null) {
                textView.setTextColor(colorStateList);
            }
        }
    }

    public void setPrefixText(@Nullable CharSequence charSequence) {
        CharSequence charSequence2;
        if (TextUtils.isEmpty(charSequence)) {
            charSequence2 = null;
        } else {
            charSequence2 = charSequence;
        }
        this.f5995j5 = charSequence2;
        this.f6018qn.setText(charSequence);
        pz();
    }

    public void setPrefixTextAppearance(int i) {
        tl.xc(this.f6018qn, i);
    }

    public void setPrefixTextColor(@NonNull ColorStateList colorStateList) {
        this.f6018qn.setTextColor(colorStateList);
    }

    public void setStartIconCheckable(boolean z2) {
        this.f5978e.setCheckable(z2);
    }

    public void setStartIconContentDescription(int i) {
        setStartIconContentDescription(i != 0 ? getResources().getText(i) : null);
    }

    public void setStartIconDrawable(int i) {
        setStartIconDrawable(i != 0 ? c5.y.gv(getContext(), i) : null);
    }

    public void setStartIconOnClickListener(@Nullable View.OnClickListener onClickListener) {
        y5(this.f5978e, onClickListener, this.f5988g3);
    }

    public void setStartIconOnLongClickListener(@Nullable View.OnLongClickListener onLongClickListener) {
        this.f5988g3 = onLongClickListener;
        xg(this.f5978e, onLongClickListener);
    }

    public void setStartIconTintList(@Nullable ColorStateList colorStateList) {
        if (this.f6025s8 != colorStateList) {
            this.f6025s8 = colorStateList;
            this.f5966ap = true;
            xc();
        }
    }

    public void setStartIconTintMode(@Nullable PorterDuff.Mode mode) {
        if (this.f6045yg != mode) {
            this.f6045yg = mode;
            this.f6044yc = true;
            xc();
        }
    }

    public void setStartIconVisible(boolean z2) {
        int i;
        if (j5() != z2) {
            CheckableImageButton checkableImageButton = this.f5978e;
            if (z2) {
                i = 0;
            } else {
                i = 8;
            }
            checkableImageButton.setVisibility(i);
            tg();
            yc();
        }
    }

    public void setSuffixText(@Nullable CharSequence charSequence) {
        CharSequence charSequence2;
        if (TextUtils.isEmpty(charSequence)) {
            charSequence2 = null;
        } else {
            charSequence2 = charSequence;
        }
        this.f6006o = charSequence2;
        this.f5993j.setText(charSequence);
        o0();
    }

    public void setSuffixTextAppearance(int i) {
        tl.xc(this.f5993j, i);
    }

    public void setSuffixTextColor(@NonNull ColorStateList colorStateList) {
        this.f5993j.setTextColor(colorStateList);
    }

    public void setTextInputAccessibilityDelegate(@Nullable v vVar) {
        EditText editText = this.f5982f;
        if (editText != null) {
            i4.g3(editText, vVar);
        }
    }

    public void setTypeface(@Nullable Typeface typeface) {
        if (typeface != this.f6020ra) {
            this.f6020ra = typeface;
            this.f5992ix.u(typeface);
            this.f6034w.a8(typeface);
            TextView textView = this.f6019r;
            if (textView != null) {
                textView.setTypeface(typeface);
            }
        }
    }

    public final void t(@NonNull RectF rectF) {
        float f4 = rectF.left;
        int i = this.f5996jz;
        rectF.left = f4 - i;
        rectF.top -= i;
        rectF.right += i;
        rectF.bottom += i;
    }

    public final void ta(@NonNull Canvas canvas) {
        if (this.f6010oz) {
            this.f5992ix.i9(canvas);
        }
    }

    public final void tg() {
        int a82;
        if (this.f5982f == null) {
            return;
        }
        if (j5()) {
            a82 = 0;
        } else {
            a82 = i4.a8(this.f5982f);
        }
        i4.cy(this.f6018qn, a82, this.f5982f.getCompoundPaddingTop(), getContext().getResources().getDimensionPixelSize(R$dimen.x9), this.f5982f.getCompoundPaddingBottom());
    }

    public final void tl() {
        wz(this.f5968bk, this.f6013pz, this.f6027tg, this.f5971cr, this.f6012pq);
    }

    public final void u0() {
        EditText editText;
        if (this.f5986fh != null && (editText = this.f5982f) != null) {
            this.f5986fh.setGravity(editText.getGravity());
            this.f5986fh.setPadding(this.f5982f.getCompoundPaddingLeft(), this.f5982f.getCompoundPaddingTop(), this.f5982f.getCompoundPaddingRight(), this.f5982f.getCompoundPaddingBottom());
        }
    }

    public final boolean ud() {
        if (this.f5987g != 0) {
            return true;
        }
        return false;
    }

    public void ut() {
        k(this.f5968bk, this.f6027tg);
    }

    public void v(@NonNull a aVar) {
        this.f6002m.add(aVar);
        if (this.f5982f != null) {
            aVar.y(this);
        }
    }

    public boolean vl() {
        return this.f6015q9;
    }

    public final void w() {
        int i = this.f6028u;
        if (i != 0) {
            if (i != 1) {
                if (i == 2) {
                    if (this.f6010oz && !(this.f5997k instanceof e7.n3)) {
                        this.f5997k = new e7.n3(this.f5981en);
                    } else {
                        this.f5997k = new hx.fb(this.f5981en);
                    }
                    this.f5984f7 = null;
                    return;
                }
                throw new IllegalArgumentException(this.f6028u + " is illegal; only @BoxBackgroundMode constants are supported.");
            }
            this.f5997k = new hx.fb(this.f5981en);
            this.f5984f7 = new hx.fb();
            return;
        }
        this.f5997k = null;
        this.f5984f7 = null;
    }

    public final void wz(@NonNull CheckableImageButton checkableImageButton, boolean z2, ColorStateList colorStateList, boolean z3, PorterDuff.Mode mode) {
        Drawable drawable = checkableImageButton.getDrawable();
        if (drawable != null && (z2 || z3)) {
            drawable = ej.y.mt(drawable).mutate();
            if (z2) {
                ej.y.xc(drawable, colorStateList);
            }
            if (z3) {
                ej.y.w(drawable, mode);
            }
        }
        if (checkableImageButton.getDrawable() != drawable) {
            checkableImageButton.setImageDrawable(drawable);
        }
    }

    public boolean x() {
        if (this.f6024s.getVisibility() == 0 && this.f5968bk.getVisibility() == 0) {
            return true;
        }
        return false;
    }

    public final int x4() {
        float xc2;
        if (!this.f6010oz) {
            return 0;
        }
        int i = this.f6028u;
        if (i != 0 && i != 1) {
            if (i != 2) {
                return 0;
            }
            xc2 = this.f5992ix.xc() / 2.0f;
        } else {
            xc2 = this.f5992ix.xc();
        }
        return (int) xc2;
    }

    public void xb() {
        boolean z2;
        boolean z3;
        TextView textView;
        EditText editText;
        EditText editText2;
        if (this.f5997k != null && this.f6028u != 0) {
            boolean z4 = false;
            if (!isFocused() && ((editText2 = this.f5982f) == null || !editText2.hasFocus())) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (!isHovered() && ((editText = this.f5982f) == null || !editText.isHovered())) {
                z3 = false;
            } else {
                z3 = true;
            }
            if (!isEnabled()) {
                this.f6008o4 = this.f5972cs;
            } else if (this.f6034w.f()) {
                if (this.f6035w2 != null) {
                    pq(z2, z3);
                } else {
                    this.f6008o4 = this.f6034w.xc();
                }
            } else if (this.f6047z && (textView = this.f6019r) != null) {
                if (this.f6035w2 != null) {
                    pq(z2, z3);
                } else {
                    this.f6008o4 = textView.getCurrentTextColor();
                }
            } else if (z2) {
                this.f6008o4 = this.f6036w9;
            } else if (z3) {
                this.f6008o4 = this.f6009oa;
            } else {
                this.f6008o4 = this.f6033vp;
            }
            if (getErrorIconDrawable() != null && this.f6034w.f3() && this.f6034w.f()) {
                z4 = true;
            }
            setErrorIconVisible(z4);
            q9();
            f7();
            ut();
            if (getEndIconDelegate().gv()) {
                lc(this.f6034w.f());
            }
            if (z2 && isEnabled()) {
                this.f6041xg = this.f5973ct;
            } else {
                this.f6041xg = this.f5977dm;
            }
            if (this.f6028u == 1) {
                if (!isEnabled()) {
                    this.f6023rs = this.f6014q5;
                } else if (z3 && !z2) {
                    this.f6023rs = this.f6001le;
                } else if (z2) {
                    this.f6023rs = this.f6003mp;
                } else {
                    this.f6023rs = this.f6039x5;
                }
            }
            i9();
        }
    }

    public final void xc() {
        wz(this.f5978e, this.f5966ap, this.f6025s8, this.f6044yc, this.f6045yg);
    }

    public final void y4(int i) {
        if (i == 0 && !this.f6022ro) {
            eb();
        } else {
            a8();
        }
    }

    public final boolean yc() {
        boolean z2;
        if (this.f5982f == null) {
            return false;
        }
        boolean z3 = true;
        if (o4()) {
            int measuredWidth = this.f6031v.getMeasuredWidth() - this.f5982f.getPaddingLeft();
            if (this.f5998kp == null || this.f6021rb != measuredWidth) {
                ColorDrawable colorDrawable = new ColorDrawable();
                this.f5998kp = colorDrawable;
                this.f6021rb = measuredWidth;
                colorDrawable.setBounds(0, 0, measuredWidth, 1);
            }
            Drawable[] y2 = tl.y(this.f5982f);
            Drawable drawable = y2[0];
            Drawable drawable2 = this.f5998kp;
            if (drawable != drawable2) {
                tl.i9(this.f5982f, drawable2, y2[1], y2[2], y2[3]);
                z2 = true;
            }
            z2 = false;
        } else {
            if (this.f5998kp != null) {
                Drawable[] y7 = tl.y(this.f5982f);
                tl.i9(this.f5982f, null, y7[1], y7[2], y7[3]);
                this.f5998kp = null;
                z2 = true;
            }
            z2 = false;
        }
        if (ct()) {
            int measuredWidth2 = this.f5993j.getMeasuredWidth() - this.f5982f.getPaddingRight();
            CheckableImageButton endIconToUpdateDummyDrawable = getEndIconToUpdateDummyDrawable();
            if (endIconToUpdateDummyDrawable != null) {
                measuredWidth2 = measuredWidth2 + endIconToUpdateDummyDrawable.getMeasuredWidth() + s.n3((ViewGroup.MarginLayoutParams) endIconToUpdateDummyDrawable.getLayoutParams());
            }
            Drawable[] y8 = tl.y(this.f5982f);
            Drawable drawable3 = this.f6007o0;
            if (drawable3 != null && this.f6040xb != measuredWidth2) {
                this.f6040xb = measuredWidth2;
                drawable3.setBounds(0, 0, measuredWidth2, 1);
                tl.i9(this.f5982f, y8[0], y8[1], this.f6007o0, y8[3]);
            } else {
                if (drawable3 == null) {
                    ColorDrawable colorDrawable2 = new ColorDrawable();
                    this.f6007o0 = colorDrawable2;
                    this.f6040xb = measuredWidth2;
                    colorDrawable2.setBounds(0, 0, measuredWidth2, 1);
                }
                Drawable drawable4 = y8[2];
                Drawable drawable5 = this.f6007o0;
                if (drawable4 != drawable5) {
                    this.f6037wf = drawable4;
                    tl.i9(this.f5982f, y8[0], y8[1], drawable5, y8[3]);
                } else {
                    z3 = z2;
                }
            }
        } else if (this.f6007o0 != null) {
            Drawable[] y9 = tl.y(this.f5982f);
            if (y9[2] == this.f6007o0) {
                tl.i9(this.f5982f, y9[0], y9[1], this.f6037wf, y9[3]);
            } else {
                z3 = z2;
            }
            this.f6007o0 = null;
        } else {
            return z2;
        }
        return z3;
    }

    public final void yg() {
        int i;
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        TextView textView = this.f6019r;
        if (textView != null) {
            if (this.f6047z) {
                i = this.f5983f3;
            } else {
                i = this.f6004n;
            }
            dm(textView, i);
            if (!this.f6047z && (colorStateList2 = this.f6038x) != null) {
                this.f6019r.setTextColor(colorStateList2);
            }
            if (this.f6047z && (colorStateList = this.f5967b) != null) {
                this.f6019r.setTextColor(colorStateList);
            }
        }
    }

    public final boolean yt() {
        return this.f6022ro;
    }

    public final int z(@NonNull Rect rect, float f4) {
        if (hw()) {
            return (int) (rect.centerY() - (f4 / 2.0f));
        }
        return rect.top + this.f5982f.getCompoundPaddingTop();
    }

    public final int z6(int i, boolean z2) {
        int compoundPaddingLeft = i + this.f5982f.getCompoundPaddingLeft();
        if (this.f5995j5 != null && !z2) {
            return (compoundPaddingLeft - this.f6018qn.getMeasuredWidth()) + this.f6018qn.getPaddingLeft();
        }
        return compoundPaddingLeft;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v45 */
    /* JADX WARN: Type inference failed for: r2v46, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r2v88 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public TextInputLayout(@androidx.annotation.NonNull android.content.Context r28, @androidx.annotation.Nullable android.util.AttributeSet r29, int r30) {
        /*
            Method dump skipped, instructions count: 1502
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.textfield.TextInputLayout.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    public void setEndIconContentDescription(@Nullable CharSequence charSequence) {
        if (getEndIconContentDescription() != charSequence) {
            this.f5968bk.setContentDescription(charSequence);
        }
    }

    public void setEndIconDrawable(@Nullable Drawable drawable) {
        this.f5968bk.setImageDrawable(drawable);
        ut();
    }

    public void setStartIconContentDescription(@Nullable CharSequence charSequence) {
        if (getStartIconContentDescription() != charSequence) {
            this.f5978e.setContentDescription(charSequence);
        }
    }

    public void setStartIconDrawable(@Nullable Drawable drawable) {
        this.f5978e.setImageDrawable(drawable);
        if (drawable != null) {
            setStartIconVisible(true);
            f7();
            return;
        }
        setStartIconVisible(false);
        setStartIconOnClickListener(null);
        setStartIconOnLongClickListener(null);
        setStartIconContentDescription((CharSequence) null);
    }

    public void setErrorIconDrawable(@Nullable Drawable drawable) {
        this.f6017qk.setImageDrawable(drawable);
        setErrorIconVisible(drawable != null && this.f6034w.f3());
    }

    @Deprecated
    public void setPasswordVisibilityToggleContentDescription(@Nullable CharSequence charSequence) {
        this.f5968bk.setContentDescription(charSequence);
    }

    @Deprecated
    public void setPasswordVisibilityToggleDrawable(@Nullable Drawable drawable) {
        this.f5968bk.setImageDrawable(drawable);
    }

    public void setHint(int i) {
        setHint(i != 0 ? getResources().getText(i) : null);
    }
}
