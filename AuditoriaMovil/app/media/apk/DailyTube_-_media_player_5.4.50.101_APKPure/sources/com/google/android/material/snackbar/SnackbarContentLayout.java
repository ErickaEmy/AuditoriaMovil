package com.google.android.material.snackbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$id;
import com.google.android.material.R$styleable;
import hw.i4;
/* loaded from: classes.dex */
public class SnackbarContentLayout extends LinearLayout implements jn.y {

    /* renamed from: fb  reason: collision with root package name */
    public int f5867fb;

    /* renamed from: s  reason: collision with root package name */
    public int f5868s;

    /* renamed from: v  reason: collision with root package name */
    public Button f5869v;
    public TextView y;

    public SnackbarContentLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.f5253q3);
        this.f5867fb = obtainStyledAttributes.getDimensionPixelSize(R$styleable.f5257qh, -1);
        this.f5868s = obtainStyledAttributes.getDimensionPixelSize(R$styleable.f5239oh, -1);
        obtainStyledAttributes.recycle();
    }

    public static void gv(@NonNull View view, int i, int i5) {
        if (i4.f7(view)) {
            i4.cy(view, i4.a8(view), i, i4.ud(view), i5);
        } else {
            view.setPadding(view.getPaddingLeft(), i, view.getPaddingRight(), i5);
        }
    }

    public Button getActionView() {
        return this.f5869v;
    }

    public TextView getMessageView() {
        return this.y;
    }

    @Override // jn.y
    public void n3(int i, int i5) {
        this.y.setAlpha(1.0f);
        long j2 = i5;
        long j4 = i;
        this.y.animate().alpha(0.0f).setDuration(j2).setStartDelay(j4).start();
        if (this.f5869v.getVisibility() == 0) {
            this.f5869v.setAlpha(1.0f);
            this.f5869v.animate().alpha(0.0f).setDuration(j2).setStartDelay(j4).start();
        }
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.y = (TextView) findViewById(R$id.snackbar_text);
        this.f5869v = (Button) findViewById(R$id.snackbar_action);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i, int i5) {
        boolean z2;
        super.onMeasure(i, i5);
        if (this.f5867fb > 0) {
            int measuredWidth = getMeasuredWidth();
            int i6 = this.f5867fb;
            if (measuredWidth > i6) {
                i = View.MeasureSpec.makeMeasureSpec(i6, 1073741824);
                super.onMeasure(i, i5);
            }
        }
        int dimensionPixelSize = getResources().getDimensionPixelSize(R$dimen.fb);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(R$dimen.jk);
        if (this.y.getLayout().getLineCount() > 1) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2 && this.f5868s > 0 && this.f5869v.getMeasuredWidth() > this.f5868s) {
            if (!v(1, dimensionPixelSize, dimensionPixelSize - dimensionPixelSize2)) {
                return;
            }
        } else {
            if (!z2) {
                dimensionPixelSize = dimensionPixelSize2;
            }
            if (!v(0, dimensionPixelSize, dimensionPixelSize)) {
                return;
            }
        }
        super.onMeasure(i, i5);
    }

    public void setMaxInlineActionWidth(int i) {
        this.f5868s = i;
    }

    public final boolean v(int i, int i5, int i6) {
        boolean z2;
        if (i != getOrientation()) {
            setOrientation(i);
            z2 = true;
        } else {
            z2 = false;
        }
        if (this.y.getPaddingTop() == i5 && this.y.getPaddingBottom() == i6) {
            return z2;
        }
        gv(this.y, i5, i6);
        return true;
    }

    @Override // jn.y
    public void y(int i, int i5) {
        this.y.setAlpha(0.0f);
        long j2 = i5;
        long j4 = i;
        this.y.animate().alpha(1.0f).setDuration(j2).setStartDelay(j4).start();
        if (this.f5869v.getVisibility() == 0) {
            this.f5869v.setAlpha(0.0f);
            this.f5869v.animate().alpha(1.0f).setDuration(j2).setStartDelay(j4).start();
        }
    }

    public void zn(float f4) {
        if (f4 != 1.0f) {
            this.f5869v.setTextColor(td.y.fb(td.y.gv(this, R$attr.uh), this.f5869v.getCurrentTextColor(), f4));
        }
    }
}
