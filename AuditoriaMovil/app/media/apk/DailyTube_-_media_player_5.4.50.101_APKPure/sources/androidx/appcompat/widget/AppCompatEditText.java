package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Editable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.DragEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.textclassifier.TextClassifier;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.R$attr;
import hw.i4;
import hw.mt;
import j.tl;
import j.wz;
import wz.co;
import wz.i9;
import wz.k5;
import wz.p;
import wz.v;
import wz.x;
import wz.z;
/* loaded from: classes.dex */
public class AppCompatEditText extends EditText implements mt {

    /* renamed from: fb  reason: collision with root package name */
    public final co f1305fb;

    /* renamed from: s  reason: collision with root package name */
    public final wz f1306s;

    /* renamed from: v  reason: collision with root package name */
    public final z f1307v;
    public final v y;

    public AppCompatEditText(@NonNull Context context) {
        this(context, null);
    }

    @Override // android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        v vVar = this.y;
        if (vVar != null) {
            vVar.n3();
        }
        z zVar = this.f1307v;
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

    @Override // android.widget.TextView
    @NonNull
    public TextClassifier getTextClassifier() {
        co coVar;
        if (Build.VERSION.SDK_INT < 28 && (coVar = this.f1305fb) != null) {
            return coVar.y();
        }
        return super.getTextClassifier();
    }

    @Override // android.widget.TextView, android.view.View
    @Nullable
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
        this.f1307v.mt(this, onCreateInputConnection, editorInfo);
        InputConnection y = i9.y(onCreateInputConnection, editorInfo, this);
        String[] ej2 = i4.ej(this);
        if (y != null && ej2 != null) {
            o.y.gv(editorInfo, ej2);
            return o.n3.y(y, editorInfo, p.y(this));
        }
        return y;
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onDragEvent(DragEvent dragEvent) {
        if (p.n3(this, dragEvent)) {
            return true;
        }
        return super.onDragEvent(dragEvent);
    }

    @Override // android.widget.TextView
    public boolean onTextContextMenuItem(int i) {
        if (p.zn(this, i)) {
            return true;
        }
        return super.onTextContextMenuItem(i);
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
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(tl.p(this, callback));
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
        z zVar = this.f1307v;
        if (zVar != null) {
            zVar.p(context, i);
        }
    }

    @Override // android.widget.TextView
    public void setTextClassifier(@Nullable TextClassifier textClassifier) {
        co coVar;
        if (Build.VERSION.SDK_INT < 28 && (coVar = this.f1305fb) != null) {
            coVar.n3(textClassifier);
        } else {
            super.setTextClassifier(textClassifier);
        }
    }

    @Override // hw.mt
    @Nullable
    public hw.zn y(@NonNull hw.zn znVar) {
        return this.f1306s.y(this, znVar);
    }

    public AppCompatEditText(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.f632d0);
    }

    @Override // android.widget.EditText, android.widget.TextView
    @Nullable
    public Editable getText() {
        if (Build.VERSION.SDK_INT >= 28) {
            return super.getText();
        }
        return super.getEditableText();
    }

    public AppCompatEditText(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(k5.n3(context), attributeSet, i);
        x.y(this, getContext());
        v vVar = new v(this);
        this.y = vVar;
        vVar.v(attributeSet, i);
        z zVar = new z(this);
        this.f1307v = zVar;
        zVar.tl(attributeSet, i);
        zVar.n3();
        this.f1305fb = new co(this);
        this.f1306s = new wz();
    }
}
