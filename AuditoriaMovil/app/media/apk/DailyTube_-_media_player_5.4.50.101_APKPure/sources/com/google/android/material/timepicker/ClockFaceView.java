package com.google.android.material.timepicker;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.R$attr;
import com.google.android.material.R$color;
import com.google.android.material.R$dimen;
import com.google.android.material.R$id;
import com.google.android.material.R$layout;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.timepicker.ClockHandView;
import hw.i4;
import j5.zn;
import java.util.Arrays;
/* loaded from: classes.dex */
class ClockFaceView extends e0.n3 implements ClockHandView.zn {

    /* renamed from: ct  reason: collision with root package name */
    public float f6087ct;

    /* renamed from: dm  reason: collision with root package name */
    public String[] f6088dm;

    /* renamed from: en  reason: collision with root package name */
    public final SparseArray<TextView> f6089en;

    /* renamed from: f7  reason: collision with root package name */
    public final RectF f6090f7;

    /* renamed from: jz  reason: collision with root package name */
    public final hw.y f6091jz;

    /* renamed from: k  reason: collision with root package name */
    public final Rect f6092k;

    /* renamed from: o4  reason: collision with root package name */
    public final ColorStateList f6093o4;

    /* renamed from: q9  reason: collision with root package name */
    public final ClockHandView f6094q9;

    /* renamed from: u  reason: collision with root package name */
    public final int[] f6095u;

    /* renamed from: xg  reason: collision with root package name */
    public final int f6096xg;

    /* renamed from: y5  reason: collision with root package name */
    public final float[] f6097y5;

    /* loaded from: classes.dex */
    public class n3 extends hw.y {
        public n3() {
        }

        @Override // hw.y
        public void fb(View view, @NonNull zn znVar) {
            super.fb(view, znVar);
            int intValue = ((Integer) view.getTag(R$id.material_value_index)).intValue();
            if (intValue > 0) {
                znVar.vp((View) ClockFaceView.this.f6089en.get(intValue - 1));
            }
            znVar.yg(zn.fb.y(0, 1, intValue, 1, false, view.isSelected()));
        }
    }

    /* loaded from: classes.dex */
    public class y implements ViewTreeObserver.OnPreDrawListener {
        public y() {
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            if (!ClockFaceView.this.isShown()) {
                return true;
            }
            ClockFaceView.this.getViewTreeObserver().removeOnPreDrawListener(this);
            ClockFaceView.this.i4(((ClockFaceView.this.getHeight() / 2) - ClockFaceView.this.f6094q9.fb()) - ClockFaceView.this.f6096xg);
            return true;
        }
    }

    public ClockFaceView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.fr4);
    }

    public void d(String[] strArr, int i) {
        this.f6088dm = strArr;
        z6(i);
    }

    @Override // e0.n3
    public void i4(int i) {
        if (i != x4()) {
            super.i4(i);
            this.f6094q9.i9(x4());
        }
    }

    public final void mg() {
        RectF gv2 = this.f6094q9.gv();
        for (int i = 0; i < this.f6089en.size(); i++) {
            TextView textView = this.f6089en.get(i);
            if (textView != null) {
                textView.getDrawingRect(this.f6092k);
                this.f6092k.offset(textView.getPaddingLeft(), textView.getPaddingTop());
                offsetDescendantRectToMyCoords(textView, this.f6092k);
                this.f6090f7.set(this.f6092k);
                textView.getPaint().setShader(ta(gv2, this.f6090f7));
                textView.invalidate();
            }
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        zn.w2(accessibilityNodeInfo).ap(zn.a.y(1, this.f6088dm.length, false, 1));
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z2, int i, int i5, int i6, int i8) {
        super.onLayout(z2, i, i5, i6, i8);
        mg();
    }

    public final RadialGradient ta(RectF rectF, RectF rectF2) {
        if (!RectF.intersects(rectF, rectF2)) {
            return null;
        }
        return new RadialGradient(rectF.centerX() - this.f6090f7.left, rectF.centerY() - this.f6090f7.top, rectF.width() * 0.5f, this.f6095u, this.f6097y5, Shader.TileMode.CLAMP);
    }

    @Override // com.google.android.material.timepicker.ClockHandView.zn
    public void y(float f4, boolean z2) {
        if (Math.abs(this.f6087ct - f4) > 0.001f) {
            this.f6087ct = f4;
            mg();
        }
    }

    public final void z6(int i) {
        LayoutInflater from = LayoutInflater.from(getContext());
        int size = this.f6089en.size();
        for (int i5 = 0; i5 < Math.max(this.f6088dm.length, size); i5++) {
            TextView textView = this.f6089en.get(i5);
            if (i5 >= this.f6088dm.length) {
                removeView(textView);
                this.f6089en.remove(i5);
            } else {
                if (textView == null) {
                    textView = (TextView) from.inflate(R$layout.or, (ViewGroup) this, false);
                    this.f6089en.put(i5, textView);
                    addView(textView);
                }
                textView.setVisibility(0);
                textView.setText(this.f6088dm[i5]);
                textView.setTag(R$id.material_value_index, Integer.valueOf(i5));
                i4.g3(textView, this.f6091jz);
                textView.setTextColor(this.f6093o4);
                if (i != 0) {
                    textView.setContentDescription(getResources().getString(i, this.f6088dm[i5]));
                }
            }
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public ClockFaceView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f6092k = new Rect();
        this.f6090f7 = new RectF();
        this.f6089en = new SparseArray<>();
        this.f6097y5 = new float[]{0.0f, 0.9f, 1.0f};
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.f5229nd, i, R$style.eq);
        Resources resources = getResources();
        ColorStateList y2 = pv.zn.y(context, obtainStyledAttributes, R$styleable.f5126bv);
        this.f6093o4 = y2;
        LayoutInflater.from(context).inflate(R$layout.os, (ViewGroup) this, true);
        ClockHandView clockHandView = (ClockHandView) findViewById(R$id.material_clock_hand);
        this.f6094q9 = clockHandView;
        this.f6096xg = resources.getDimensionPixelSize(R$dimen.xl);
        int colorForState = y2.getColorForState(new int[]{16842913}, y2.getDefaultColor());
        this.f6095u = new int[]{colorForState, colorForState, y2.getDefaultColor()};
        clockHandView.n3(this);
        int defaultColor = c5.y.zn(context, R$color.tj).getDefaultColor();
        ColorStateList y7 = pv.zn.y(context, obtainStyledAttributes, R$styleable.gf);
        setBackgroundColor(y7 != null ? y7.getDefaultColor() : defaultColor);
        getViewTreeObserver().addOnPreDrawListener(new y());
        setFocusable(true);
        obtainStyledAttributes.recycle();
        this.f6091jz = new n3();
        String[] strArr = new String[12];
        Arrays.fill(strArr, "");
        d(strArr, 0);
    }
}
