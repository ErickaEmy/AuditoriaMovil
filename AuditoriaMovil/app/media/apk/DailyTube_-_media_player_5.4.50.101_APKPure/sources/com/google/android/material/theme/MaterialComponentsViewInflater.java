package com.google.android.material.theme;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatTextView;
import com.google.android.material.button.MaterialButton;
import e7.v;
import lf.y;
import s.s;
import wz.a;
import wz.gv;
import wz.xc;
/* loaded from: classes.dex */
public class MaterialComponentsViewInflater extends s {
    @Override // s.s
    @NonNull
    public a gv(Context context, AttributeSet attributeSet) {
        return new y(context, attributeSet);
    }

    @Override // s.s
    @NonNull
    public xc i9(Context context, AttributeSet attributeSet) {
        return new sd.y(context, attributeSet);
    }

    @Override // s.s
    @NonNull
    public gv n3(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        return new v(context, attributeSet);
    }

    @Override // s.s
    @NonNull
    public AppCompatTextView wz(Context context, AttributeSet attributeSet) {
        return new b0.y(context, attributeSet);
    }

    @Override // s.s
    @NonNull
    public AppCompatButton zn(@NonNull Context context, @NonNull AttributeSet attributeSet) {
        return new MaterialButton(context, attributeSet);
    }
}
