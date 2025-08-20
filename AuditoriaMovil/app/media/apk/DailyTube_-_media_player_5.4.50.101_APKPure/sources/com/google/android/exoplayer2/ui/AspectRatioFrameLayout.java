package com.google.android.exoplayer2.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
/* loaded from: classes.dex */
public final class AspectRatioFrameLayout extends FrameLayout {

    /* renamed from: fb  reason: collision with root package name */
    public int f4710fb;

    /* renamed from: v  reason: collision with root package name */
    public float f4711v;
    public final zn y;

    /* loaded from: classes.dex */
    public interface n3 {
    }

    /* loaded from: classes.dex */
    public final class zn implements Runnable {

        /* renamed from: fb  reason: collision with root package name */
        public boolean f4713fb;

        /* renamed from: s  reason: collision with root package name */
        public boolean f4714s;

        /* renamed from: v  reason: collision with root package name */
        public float f4715v;
        public float y;

        public zn() {
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f4714s = false;
            AspectRatioFrameLayout.y(AspectRatioFrameLayout.this);
        }

        public void y(float f4, float f6, boolean z2) {
            this.y = f4;
            this.f4715v = f6;
            this.f4713fb = z2;
            if (!this.f4714s) {
                this.f4714s = true;
                AspectRatioFrameLayout.this.post(this);
            }
        }
    }

    public AspectRatioFrameLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R$styleable.y, 0, 0);
            try {
                this.f4710fb = obtainStyledAttributes.getInt(R$styleable.f4780n3, 0);
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
        this.y = new zn();
    }

    public static /* synthetic */ n3 y(AspectRatioFrameLayout aspectRatioFrameLayout) {
        aspectRatioFrameLayout.getClass();
        return null;
    }

    public int getResizeMode() {
        return this.f4710fb;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i5) {
        float f4;
        float f6;
        super.onMeasure(i, i5);
        if (this.f4711v <= 0.0f) {
            return;
        }
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        float f9 = measuredWidth;
        float f10 = measuredHeight;
        float f11 = f9 / f10;
        float f12 = (this.f4711v / f11) - 1.0f;
        if (Math.abs(f12) <= 0.01f) {
            this.y.y(this.f4711v, f11, false);
            return;
        }
        int i6 = this.f4710fb;
        if (i6 != 0) {
            if (i6 != 1) {
                if (i6 != 2) {
                    if (i6 == 4) {
                        if (f12 > 0.0f) {
                            f4 = this.f4711v;
                        } else {
                            f6 = this.f4711v;
                        }
                    }
                } else {
                    f4 = this.f4711v;
                }
                measuredWidth = (int) (f10 * f4);
            } else {
                f6 = this.f4711v;
            }
            measuredHeight = (int) (f9 / f6);
        } else if (f12 > 0.0f) {
            f6 = this.f4711v;
            measuredHeight = (int) (f9 / f6);
        } else {
            f4 = this.f4711v;
            measuredWidth = (int) (f10 * f4);
        }
        this.y.y(this.f4711v, f11, true);
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824));
    }

    public void setAspectRatio(float f4) {
        if (this.f4711v != f4) {
            this.f4711v = f4;
            requestLayout();
        }
    }

    public void setAspectRatioListener(@Nullable n3 n3Var) {
    }

    public void setResizeMode(int i) {
        if (this.f4710fb != i) {
            this.f4710fb = i;
            requestLayout();
        }
    }
}
