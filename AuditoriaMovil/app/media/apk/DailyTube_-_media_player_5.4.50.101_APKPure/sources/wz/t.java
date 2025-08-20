package wz;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.MultiAutoCompleteTextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.R$attr;
/* loaded from: classes.dex */
public class t extends MultiAutoCompleteTextView {

    /* renamed from: fb  reason: collision with root package name */
    public static final int[] f14806fb = {16843126};

    /* renamed from: v  reason: collision with root package name */
    public final z f14807v;
    public final v y;

    public t(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.f656w);
    }

    @Override // android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        v vVar = this.y;
        if (vVar != null) {
            vVar.n3();
        }
        z zVar = this.f14807v;
        if (zVar != null) {
            zVar.n3();
        }
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

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        return i9.y(super.onCreateInputConnection(editorInfo), editorInfo, this);
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

    @Override // android.widget.AutoCompleteTextView
    public void setDropDownBackgroundResource(int i) {
        setDropDownBackgroundDrawable(c5.y.gv(getContext(), i));
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

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        z zVar = this.f14807v;
        if (zVar != null) {
            zVar.p(context, i);
        }
    }

    public t(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(k5.n3(context), attributeSet, i);
        x.y(this, getContext());
        hw x42 = hw.x4(getContext(), attributeSet, f14806fb, i, 0);
        if (x42.co(0)) {
            setDropDownBackgroundDrawable(x42.fb(0));
        }
        x42.i4();
        v vVar = new v(this);
        this.y = vVar;
        vVar.v(attributeSet, i);
        z zVar = new z(this);
        this.f14807v = zVar;
        zVar.tl(attributeSet, i);
        zVar.n3();
    }
}
