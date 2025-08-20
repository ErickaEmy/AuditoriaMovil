package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.textclassifier.TextClassifier;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import j.tl;
import j.xc;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import wz.co;
import wz.i9;
import wz.k5;
import wz.v;
import wz.x;
import wz.z;
import yt.zn;
import z6.gv;
/* loaded from: classes.dex */
public class AppCompatTextView extends TextView implements xc, j.n3 {
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public Future<yt.zn> f1330f;

    /* renamed from: fb  reason: collision with root package name */
    public final co f1331fb;

    /* renamed from: s  reason: collision with root package name */
    public boolean f1332s;

    /* renamed from: v  reason: collision with root package name */
    public final z f1333v;
    public final v y;

    public AppCompatTextView(@NonNull Context context) {
        this(context, null);
    }

    @Override // android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        v vVar = this.y;
        if (vVar != null) {
            vVar.n3();
        }
        z zVar = this.f1333v;
        if (zVar != null) {
            zVar.n3();
        }
    }

    @Override // android.widget.TextView
    public int getAutoSizeMaxTextSize() {
        if (j.n3.f9315wz) {
            return super.getAutoSizeMaxTextSize();
        }
        z zVar = this.f1333v;
        if (zVar != null) {
            return zVar.v();
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int getAutoSizeMinTextSize() {
        if (j.n3.f9315wz) {
            return super.getAutoSizeMinTextSize();
        }
        z zVar = this.f1333v;
        if (zVar != null) {
            return zVar.a();
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int getAutoSizeStepGranularity() {
        if (j.n3.f9315wz) {
            return super.getAutoSizeStepGranularity();
        }
        z zVar = this.f1333v;
        if (zVar != null) {
            return zVar.fb();
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int[] getAutoSizeTextAvailableSizes() {
        if (j.n3.f9315wz) {
            return super.getAutoSizeTextAvailableSizes();
        }
        z zVar = this.f1333v;
        if (zVar != null) {
            return zVar.s();
        }
        return new int[0];
    }

    @Override // android.widget.TextView
    @SuppressLint({"WrongConstant"})
    public int getAutoSizeTextType() {
        if (j.n3.f9315wz) {
            if (super.getAutoSizeTextType() != 1) {
                return 0;
            }
            return 1;
        }
        z zVar = this.f1333v;
        if (zVar == null) {
            return 0;
        }
        return zVar.c5();
    }

    @Override // android.widget.TextView
    public int getFirstBaselineToTopHeight() {
        return tl.n3(this);
    }

    @Override // android.widget.TextView
    public int getLastBaselineToBottomHeight() {
        return tl.zn(this);
    }

    @Nullable
    public ColorStateList getSupportBackgroundTintList() {
        v vVar = this.y;
        if (vVar != null) {
            return vVar.zn();
        }
        return null;
    }

    @Nullable
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        v vVar = this.y;
        if (vVar != null) {
            return vVar.gv();
        }
        return null;
    }

    @Nullable
    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f1333v.i9();
    }

    @Nullable
    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f1333v.f();
    }

    @Override // android.widget.TextView
    public CharSequence getText() {
        gv();
        return super.getText();
    }

    @Override // android.widget.TextView
    @NonNull
    public TextClassifier getTextClassifier() {
        co coVar;
        if (Build.VERSION.SDK_INT < 28 && (coVar = this.f1331fb) != null) {
            return coVar.y();
        }
        return super.getTextClassifier();
    }

    @NonNull
    public zn.n3 getTextMetricsParamsCompat() {
        return tl.fb(this);
    }

    public final void gv() {
        Future<yt.zn> future = this.f1330f;
        if (future != null) {
            try {
                this.f1330f = null;
                tl.wz(this, future.get());
            } catch (InterruptedException | ExecutionException unused) {
            }
        }
    }

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
        this.f1333v.mt(this, onCreateInputConnection, editorInfo);
        return i9.y(onCreateInputConnection, editorInfo, this);
    }

    @Override // android.widget.TextView, android.view.View
    public void onLayout(boolean z2, int i, int i5, int i6, int i8) {
        super.onLayout(z2, i, i5, i6, i8);
        z zVar = this.f1333v;
        if (zVar != null) {
            zVar.xc(z2, i, i5, i6, i8);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int i, int i5) {
        gv();
        super.onMeasure(i, i5);
    }

    @Override // android.widget.TextView
    public void onTextChanged(CharSequence charSequence, int i, int i5, int i6) {
        super.onTextChanged(charSequence, i, i5, i6);
        z zVar = this.f1333v;
        if (zVar != null && !j.n3.f9315wz && zVar.t()) {
            this.f1333v.zn();
        }
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeUniformWithConfiguration(int i, int i5, int i6, int i8) throws IllegalArgumentException {
        if (j.n3.f9315wz) {
            super.setAutoSizeTextTypeUniformWithConfiguration(i, i5, i6, i8);
            return;
        }
        z zVar = this.f1333v;
        if (zVar != null) {
            zVar.z(i, i5, i6, i8);
        }
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeUniformWithPresetSizes(@NonNull int[] iArr, int i) throws IllegalArgumentException {
        if (j.n3.f9315wz) {
            super.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i);
            return;
        }
        z zVar = this.f1333v;
        if (zVar != null) {
            zVar.r(iArr, i);
        }
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeWithDefaults(int i) {
        if (j.n3.f9315wz) {
            super.setAutoSizeTextTypeWithDefaults(i);
            return;
        }
        z zVar = this.f1333v;
        if (zVar != null) {
            zVar.x4(i);
        }
    }

    @Override // android.view.View
    public void setBackgroundDrawable(@Nullable Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        v vVar = this.y;
        if (vVar != null) {
            vVar.a(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        v vVar = this.y;
        if (vVar != null) {
            vVar.fb(i);
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawables(@Nullable Drawable drawable, @Nullable Drawable drawable2, @Nullable Drawable drawable3, @Nullable Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        z zVar = this.f1333v;
        if (zVar != null) {
            zVar.w();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelative(@Nullable Drawable drawable, @Nullable Drawable drawable2, @Nullable Drawable drawable3, @Nullable Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        z zVar = this.f1333v;
        if (zVar != null) {
            zVar.w();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(@Nullable Drawable drawable, @Nullable Drawable drawable2, @Nullable Drawable drawable3, @Nullable Drawable drawable4) {
        super.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        z zVar = this.f1333v;
        if (zVar != null) {
            zVar.w();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(@Nullable Drawable drawable, @Nullable Drawable drawable2, @Nullable Drawable drawable3, @Nullable Drawable drawable4) {
        super.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        z zVar = this.f1333v;
        if (zVar != null) {
            zVar.w();
        }
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(tl.p(this, callback));
    }

    @Override // android.widget.TextView
    public void setFirstBaselineToTopHeight(int i) {
        if (Build.VERSION.SDK_INT >= 28) {
            super.setFirstBaselineToTopHeight(i);
        } else {
            tl.f(this, i);
        }
    }

    @Override // android.widget.TextView
    public void setLastBaselineToBottomHeight(int i) {
        if (Build.VERSION.SDK_INT >= 28) {
            super.setLastBaselineToBottomHeight(i);
        } else {
            tl.t(this, i);
        }
    }

    @Override // android.widget.TextView
    public void setLineHeight(int i) {
        tl.tl(this, i);
    }

    public void setPrecomputedText(@NonNull yt.zn znVar) {
        tl.wz(this, znVar);
    }

    public void setSupportBackgroundTintList(@Nullable ColorStateList colorStateList) {
        v vVar = this.y;
        if (vVar != null) {
            vVar.c5(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(@Nullable PorterDuff.Mode mode) {
        v vVar = this.y;
        if (vVar != null) {
            vVar.i9(mode);
        }
    }

    @Override // j.xc
    public void setSupportCompoundDrawablesTintList(@Nullable ColorStateList colorStateList) {
        this.f1333v.i4(colorStateList);
        this.f1333v.n3();
    }

    @Override // j.xc
    public void setSupportCompoundDrawablesTintMode(@Nullable PorterDuff.Mode mode) {
        this.f1333v.f3(mode);
        this.f1333v.n3();
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        z zVar = this.f1333v;
        if (zVar != null) {
            zVar.p(context, i);
        }
    }

    @Override // android.widget.TextView
    public void setTextClassifier(@Nullable TextClassifier textClassifier) {
        co coVar;
        if (Build.VERSION.SDK_INT < 28 && (coVar = this.f1331fb) != null) {
            coVar.n3(textClassifier);
        } else {
            super.setTextClassifier(textClassifier);
        }
    }

    public void setTextFuture(@Nullable Future<yt.zn> future) {
        this.f1330f = future;
        if (future != null) {
            requestLayout();
        }
    }

    public void setTextMetricsParamsCompat(@NonNull zn.n3 n3Var) {
        tl.w(this, n3Var);
    }

    @Override // android.widget.TextView
    public void setTextSize(int i, float f4) {
        if (j.n3.f9315wz) {
            super.setTextSize(i, f4);
            return;
        }
        z zVar = this.f1333v;
        if (zVar != null) {
            zVar.d0(i, f4);
        }
    }

    @Override // android.widget.TextView
    public void setTypeface(@Nullable Typeface typeface, int i) {
        Typeface typeface2;
        if (this.f1332s) {
            return;
        }
        if (typeface != null && i > 0) {
            typeface2 = gv.y(getContext(), typeface, i);
        } else {
            typeface2 = null;
        }
        this.f1332s = true;
        if (typeface2 != null) {
            typeface = typeface2;
        }
        try {
            super.setTypeface(typeface, i);
        } finally {
            this.f1332s = false;
        }
    }

    public AppCompatTextView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 16842884);
    }

    public AppCompatTextView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(k5.n3(context), attributeSet, i);
        this.f1332s = false;
        x.y(this, getContext());
        v vVar = new v(this);
        this.y = vVar;
        vVar.v(attributeSet, i);
        z zVar = new z(this);
        this.f1333v = zVar;
        zVar.tl(attributeSet, i);
        zVar.n3();
        this.f1331fb = new co(this);
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(int i, int i5, int i6, int i8) {
        Context context = getContext();
        setCompoundDrawablesRelativeWithIntrinsicBounds(i != 0 ? c5.y.gv(context, i) : null, i5 != 0 ? c5.y.gv(context, i5) : null, i6 != 0 ? c5.y.gv(context, i6) : null, i8 != 0 ? c5.y.gv(context, i8) : null);
        z zVar = this.f1333v;
        if (zVar != null) {
            zVar.w();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(int i, int i5, int i6, int i8) {
        Context context = getContext();
        setCompoundDrawablesWithIntrinsicBounds(i != 0 ? c5.y.gv(context, i) : null, i5 != 0 ? c5.y.gv(context, i5) : null, i6 != 0 ? c5.y.gv(context, i6) : null, i8 != 0 ? c5.y.gv(context, i8) : null);
        z zVar = this.f1333v;
        if (zVar != null) {
            zVar.w();
        }
    }
}
