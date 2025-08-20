package com.google.android.material.textfield;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.text.Editable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatEditText;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$id;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import ur.i9;
import ur.v;
/* loaded from: classes.dex */
public class TextInputEditText extends AppCompatEditText {

    /* renamed from: f  reason: collision with root package name */
    public final Rect f5962f;

    /* renamed from: t  reason: collision with root package name */
    public boolean f5963t;

    public TextInputEditText(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.f5087xc);
    }

    @Nullable
    private CharSequence getHintFromLayout() {
        TextInputLayout textInputLayout = getTextInputLayout();
        if (textInputLayout != null) {
            return textInputLayout.getHint();
        }
        return null;
    }

    @Nullable
    private TextInputLayout getTextInputLayout() {
        for (ViewParent parent = getParent(); parent instanceof View; parent = parent.getParent()) {
            if (parent instanceof TextInputLayout) {
                return (TextInputLayout) parent;
            }
        }
        return null;
    }

    @Override // android.widget.TextView, android.view.View
    public void getFocusedRect(@Nullable Rect rect) {
        super.getFocusedRect(rect);
        TextInputLayout textInputLayout = getTextInputLayout();
        if (textInputLayout != null && this.f5963t && rect != null) {
            textInputLayout.getFocusedRect(this.f5962f);
            rect.bottom = this.f5962f.bottom;
        }
    }

    @Override // android.view.View
    public boolean getGlobalVisibleRect(@Nullable Rect rect, @Nullable Point point) {
        boolean globalVisibleRect = super.getGlobalVisibleRect(rect, point);
        TextInputLayout textInputLayout = getTextInputLayout();
        if (textInputLayout != null && this.f5963t && rect != null) {
            textInputLayout.getGlobalVisibleRect(this.f5962f, point);
            rect.bottom = this.f5962f.bottom;
        }
        return globalVisibleRect;
    }

    @Override // android.widget.TextView
    @Nullable
    public CharSequence getHint() {
        TextInputLayout textInputLayout = getTextInputLayout();
        if (textInputLayout != null && textInputLayout.vl()) {
            return textInputLayout.getHint();
        }
        return super.getHint();
    }

    @NonNull
    public final String n3(@NonNull TextInputLayout textInputLayout) {
        String str;
        Editable text = getText();
        CharSequence hint = textInputLayout.getHint();
        boolean isEmpty = TextUtils.isEmpty(text);
        boolean isEmpty2 = TextUtils.isEmpty(hint);
        setLabelFor(R$id.textinput_helper_text);
        String str2 = "";
        if (isEmpty2) {
            str = "";
        } else {
            str = hint.toString();
        }
        if (!isEmpty) {
            StringBuilder sb = new StringBuilder();
            sb.append((Object) text);
            if (!TextUtils.isEmpty(str)) {
                str2 = ", " + str;
            }
            sb.append(str2);
            return sb.toString();
        } else if (TextUtils.isEmpty(str)) {
            return "";
        } else {
            return str;
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        TextInputLayout textInputLayout = getTextInputLayout();
        if (textInputLayout != null && textInputLayout.vl() && super.getHint() == null && v.y()) {
            setHint("");
        }
    }

    @Override // androidx.appcompat.widget.AppCompatEditText, android.widget.TextView, android.view.View
    @Nullable
    public InputConnection onCreateInputConnection(@NonNull EditorInfo editorInfo) {
        InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
        if (onCreateInputConnection != null && editorInfo.hintText == null) {
            editorInfo.hintText = getHintFromLayout();
        }
        return onCreateInputConnection;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        TextInputLayout textInputLayout = getTextInputLayout();
        if (Build.VERSION.SDK_INT < 23 && textInputLayout != null) {
            accessibilityNodeInfo.setText(n3(textInputLayout));
        }
    }

    @Override // android.view.View
    public boolean requestRectangleOnScreen(@Nullable Rect rect) {
        boolean requestRectangleOnScreen = super.requestRectangleOnScreen(rect);
        TextInputLayout textInputLayout = getTextInputLayout();
        if (textInputLayout != null && this.f5963t) {
            this.f5962f.set(0, textInputLayout.getHeight() - getResources().getDimensionPixelOffset(R$dimen.i8), textInputLayout.getWidth(), textInputLayout.getHeight());
            textInputLayout.requestRectangleOnScreen(this.f5962f, true);
        }
        return requestRectangleOnScreen;
    }

    public void setTextInputLayoutFocusedRectEnabled(boolean z2) {
        this.f5963t = z2;
    }

    public TextInputEditText(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(c0.y.zn(context, attributeSet, i, 0), attributeSet, i);
        this.f5962f = new Rect();
        TypedArray s2 = i9.s(context, attributeSet, R$styleable.I, i, R$style.zz, new int[0]);
        setTextInputLayoutFocusedRectEnabled(s2.getBoolean(R$styleable.J, false));
        s2.recycle();
    }
}
