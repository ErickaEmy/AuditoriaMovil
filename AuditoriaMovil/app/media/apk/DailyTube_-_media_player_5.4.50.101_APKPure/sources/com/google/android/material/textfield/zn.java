package com.google.android.material.textfield;

import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.EditText;
import androidx.annotation.NonNull;
import com.google.android.material.R$drawable;
import com.google.android.material.R$string;
import com.google.android.material.textfield.TextInputLayout;
import ur.c5;
/* loaded from: classes.dex */
public class zn extends e7.zn {

    /* renamed from: a  reason: collision with root package name */
    public final TextInputLayout.fb f6079a;

    /* renamed from: gv  reason: collision with root package name */
    public final TextWatcher f6080gv;

    /* renamed from: v  reason: collision with root package name */
    public final TextInputLayout.a f6081v;

    /* loaded from: classes.dex */
    public class gv implements View.OnClickListener {
        public gv() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EditText editText = zn.this.y.getEditText();
            if (editText == null) {
                return;
            }
            int selectionEnd = editText.getSelectionEnd();
            if (zn.this.fb()) {
                editText.setTransformationMethod(null);
            } else {
                editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
            }
            if (selectionEnd >= 0) {
                editText.setSelection(selectionEnd);
            }
            zn.this.y.ut();
        }
    }

    /* loaded from: classes.dex */
    public class n3 implements TextInputLayout.a {
        public n3() {
        }

        @Override // com.google.android.material.textfield.TextInputLayout.a
        public void y(@NonNull TextInputLayout textInputLayout) {
            EditText editText = textInputLayout.getEditText();
            textInputLayout.setEndIconVisible(true);
            textInputLayout.setEndIconCheckable(true);
            zn znVar = zn.this;
            znVar.f7588zn.setChecked(!znVar.fb());
            editText.removeTextChangedListener(zn.this.f6080gv);
            editText.addTextChangedListener(zn.this.f6080gv);
        }
    }

    /* loaded from: classes.dex */
    public class y extends c5 {
        public y() {
        }

        @Override // ur.c5, android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i5, int i6) {
            zn znVar = zn.this;
            znVar.f7588zn.setChecked(!znVar.fb());
        }
    }

    /* renamed from: com.google.android.material.textfield.zn$zn  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0070zn implements TextInputLayout.fb {

        /* renamed from: com.google.android.material.textfield.zn$zn$y */
        /* loaded from: classes.dex */
        public class y implements Runnable {
            public final /* synthetic */ EditText y;

            public y(EditText editText) {
                this.y = editText;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.y.removeTextChangedListener(zn.this.f6080gv);
            }
        }

        public C0070zn() {
        }

        @Override // com.google.android.material.textfield.TextInputLayout.fb
        public void y(@NonNull TextInputLayout textInputLayout, int i) {
            EditText editText = textInputLayout.getEditText();
            if (editText != null && i == 1) {
                editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
                editText.post(new y(editText));
            }
        }
    }

    public zn(@NonNull TextInputLayout textInputLayout) {
        super(textInputLayout);
        this.f6080gv = new y();
        this.f6081v = new n3();
        this.f6079a = new C0070zn();
    }

    public static boolean s(EditText editText) {
        if (editText != null && (editText.getInputType() == 16 || editText.getInputType() == 128 || editText.getInputType() == 144 || editText.getInputType() == 224)) {
            return true;
        }
        return false;
    }

    public final boolean fb() {
        EditText editText = this.y.getEditText();
        if (editText != null && (editText.getTransformationMethod() instanceof PasswordTransformationMethod)) {
            return true;
        }
        return false;
    }

    @Override // e7.zn
    public void y() {
        this.y.setEndIconDrawable(c5.y.gv(this.f7587n3, R$drawable.l0));
        TextInputLayout textInputLayout = this.y;
        textInputLayout.setEndIconContentDescription(textInputLayout.getResources().getText(R$string.fqv));
        this.y.setEndIconOnClickListener(new gv());
        this.y.v(this.f6081v);
        this.y.a(this.f6079a);
        EditText editText = this.y.getEditText();
        if (s(editText)) {
            editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
        }
    }
}
