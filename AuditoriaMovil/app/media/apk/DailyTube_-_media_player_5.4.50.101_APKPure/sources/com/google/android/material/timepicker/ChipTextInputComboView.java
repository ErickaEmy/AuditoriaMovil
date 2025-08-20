package com.google.android.material.timepicker;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Checkable;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.R$id;
import com.google.android.material.R$layout;
import com.google.android.material.chip.Chip;
import com.google.android.material.textfield.TextInputLayout;
import ur.c5;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ChipTextInputComboView extends FrameLayout implements Checkable {

    /* renamed from: f  reason: collision with root package name */
    public TextView f6083f;

    /* renamed from: fb  reason: collision with root package name */
    public final EditText f6084fb;

    /* renamed from: s  reason: collision with root package name */
    public TextWatcher f6085s;

    /* renamed from: v  reason: collision with root package name */
    public final TextInputLayout f6086v;
    public final Chip y;

    /* loaded from: classes.dex */
    public class n3 extends c5 {
        public n3() {
        }

        @Override // ur.c5, android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (TextUtils.isEmpty(editable)) {
                ChipTextInputComboView.this.y.setText(ChipTextInputComboView.this.zn("00"));
            } else {
                ChipTextInputComboView.this.y.setText(ChipTextInputComboView.this.zn(editable));
            }
        }
    }

    public ChipTextInputComboView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public final void gv() {
        if (Build.VERSION.SDK_INT >= 24) {
            this.f6084fb.setImeHintLocales(getContext().getResources().getConfiguration().getLocales());
        }
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.y.isChecked();
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        gv();
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z2) {
        int i;
        this.y.setChecked(z2);
        EditText editText = this.f6084fb;
        int i5 = 0;
        if (z2) {
            i = 0;
        } else {
            i = 4;
        }
        editText.setVisibility(i);
        Chip chip = this.y;
        if (z2) {
            i5 = 8;
        }
        chip.setVisibility(i5);
        if (isChecked()) {
            this.f6084fb.requestFocus();
            if (!TextUtils.isEmpty(this.f6084fb.getText())) {
                EditText editText2 = this.f6084fb;
                editText2.setSelection(editText2.getText().length());
            }
        }
    }

    @Override // android.view.View
    public void setOnClickListener(@Nullable View.OnClickListener onClickListener) {
        this.y.setOnClickListener(onClickListener);
    }

    @Override // android.view.View
    public void setTag(int i, Object obj) {
        this.y.setTag(i, obj);
    }

    @Override // android.widget.Checkable
    public void toggle() {
        this.y.toggle();
    }

    public final String zn(CharSequence charSequence) {
        return TimeModel.y(getResources(), charSequence);
    }

    public ChipTextInputComboView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        LayoutInflater from = LayoutInflater.from(context);
        Chip chip = (Chip) from.inflate(R$layout.ok, (ViewGroup) this, false);
        this.y = chip;
        TextInputLayout textInputLayout = (TextInputLayout) from.inflate(R$layout.tl, (ViewGroup) this, false);
        this.f6086v = textInputLayout;
        EditText editText = textInputLayout.getEditText();
        this.f6084fb = editText;
        editText.setVisibility(4);
        n3 n3Var = new n3();
        this.f6085s = n3Var;
        editText.addTextChangedListener(n3Var);
        gv();
        addView(chip);
        addView(textInputLayout);
        this.f6083f = (TextView) findViewById(R$id.material_label);
        editText.setSaveEnabled(false);
    }
}
