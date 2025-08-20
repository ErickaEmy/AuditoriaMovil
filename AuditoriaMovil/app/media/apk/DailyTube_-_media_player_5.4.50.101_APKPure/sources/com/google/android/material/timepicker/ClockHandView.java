package com.google.android.material.timepicker;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.annotation.Nullable;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import hw.i4;
import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ClockHandView extends View {

    /* renamed from: c  reason: collision with root package name */
    public boolean f6099c;

    /* renamed from: co  reason: collision with root package name */
    public final float f6100co;

    /* renamed from: d0  reason: collision with root package name */
    public double f6101d0;

    /* renamed from: f  reason: collision with root package name */
    public boolean f6102f;

    /* renamed from: f3  reason: collision with root package name */
    public final int f6103f3;

    /* renamed from: fb  reason: collision with root package name */
    public float f6104fb;

    /* renamed from: fh  reason: collision with root package name */
    public int f6105fh;

    /* renamed from: n  reason: collision with root package name */
    public float f6106n;

    /* renamed from: p  reason: collision with root package name */
    public final int f6107p;

    /* renamed from: r  reason: collision with root package name */
    public final RectF f6108r;

    /* renamed from: s  reason: collision with root package name */
    public float f6109s;

    /* renamed from: t  reason: collision with root package name */
    public int f6110t;

    /* renamed from: v  reason: collision with root package name */
    public boolean f6111v;

    /* renamed from: w  reason: collision with root package name */
    public final List<zn> f6112w;
    public ValueAnimator y;

    /* renamed from: z  reason: collision with root package name */
    public final Paint f6113z;

    /* loaded from: classes.dex */
    public class n3 extends AnimatorListenerAdapter {
        public n3() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            animator.end();
        }
    }

    /* loaded from: classes.dex */
    public class y implements ValueAnimator.AnimatorUpdateListener {
        public y() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            ClockHandView.this.tl(((Float) valueAnimator.getAnimatedValue()).floatValue(), true);
        }
    }

    /* loaded from: classes.dex */
    public interface zn {
        void y(float f4, boolean z2);
    }

    public ClockHandView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.fr4);
    }

    public float a() {
        return this.f6106n;
    }

    public final boolean c5(float f4, float f6, boolean z2, boolean z3, boolean z4) {
        boolean z5;
        float v2 = v(f4, f6);
        boolean z7 = false;
        if (a() != v2) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (z3 && z5) {
            return true;
        }
        if (!z5 && !z2) {
            return false;
        }
        if (z4 && this.f6111v) {
            z7 = true;
        }
        t(v2, z7);
        return true;
    }

    public void f(float f4) {
        t(f4, false);
    }

    public int fb() {
        return this.f6107p;
    }

    public RectF gv() {
        return this.f6108r;
    }

    public void i9(int i) {
        this.f6105fh = i;
        invalidate();
    }

    public void n3(zn znVar) {
        this.f6112w.add(znVar);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        zn(canvas);
    }

    @Override // android.view.View
    public void onLayout(boolean z2, int i, int i5, int i6, int i8) {
        super.onLayout(z2, i, i5, i6, i8);
        f(a());
    }

    @Override // android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z7;
        int actionMasked = motionEvent.getActionMasked();
        float x2 = motionEvent.getX();
        float y2 = motionEvent.getY();
        if (actionMasked != 0) {
            if (actionMasked != 1 && actionMasked != 2) {
                z2 = false;
                z3 = false;
            } else {
                int i = (int) (x2 - this.f6104fb);
                int i5 = (int) (y2 - this.f6109s);
                if ((i * i) + (i5 * i5) > this.f6110t) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                this.f6102f = z5;
                z2 = this.f6099c;
                if (actionMasked == 1) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                z4 = z7;
                z3 = false;
                this.f6099c |= c5(x2, y2, z2, z3, z4);
                return true;
            }
        } else {
            this.f6104fb = x2;
            this.f6109s = y2;
            this.f6102f = true;
            this.f6099c = false;
            z2 = false;
            z3 = true;
        }
        z4 = false;
        this.f6099c |= c5(x2, y2, z2, z3, z4);
        return true;
    }

    public final Pair<Float, Float> s(float f4) {
        float a2 = a();
        if (Math.abs(a2 - f4) > 180.0f) {
            if (a2 > 180.0f && f4 < 180.0f) {
                f4 += 360.0f;
            }
            if (a2 < 180.0f && f4 > 180.0f) {
                a2 += 360.0f;
            }
        }
        return new Pair<>(Float.valueOf(a2), Float.valueOf(f4));
    }

    public void t(float f4, boolean z2) {
        ValueAnimator valueAnimator = this.y;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        if (!z2) {
            tl(f4, false);
            return;
        }
        Pair<Float, Float> s2 = s(f4);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(((Float) s2.first).floatValue(), ((Float) s2.second).floatValue());
        this.y = ofFloat;
        ofFloat.setDuration(200L);
        this.y.addUpdateListener(new y());
        this.y.addListener(new n3());
        this.y.start();
    }

    public final void tl(float f4, boolean z2) {
        float f6 = f4 % 360.0f;
        this.f6106n = f6;
        this.f6101d0 = Math.toRadians(f6 - 90.0f);
        float width = (getWidth() / 2) + (this.f6105fh * ((float) Math.cos(this.f6101d0)));
        float height = (getHeight() / 2) + (this.f6105fh * ((float) Math.sin(this.f6101d0)));
        RectF rectF = this.f6108r;
        int i = this.f6107p;
        rectF.set(width - i, height - i, width + i, height + i);
        for (zn znVar : this.f6112w) {
            znVar.y(f6, z2);
        }
        invalidate();
    }

    public final int v(float f4, float f6) {
        int degrees = (int) Math.toDegrees(Math.atan2(f6 - (getHeight() / 2), f4 - (getWidth() / 2)));
        int i = degrees + 90;
        if (i < 0) {
            return degrees + 450;
        }
        return i;
    }

    public final void zn(Canvas canvas) {
        int width;
        int height = getHeight() / 2;
        float width2 = getWidth() / 2;
        float f4 = height;
        this.f6113z.setStrokeWidth(0.0f);
        canvas.drawCircle((this.f6105fh * ((float) Math.cos(this.f6101d0))) + width2, (this.f6105fh * ((float) Math.sin(this.f6101d0))) + f4, this.f6107p, this.f6113z);
        double sin = Math.sin(this.f6101d0);
        double cos = Math.cos(this.f6101d0);
        this.f6113z.setStrokeWidth(this.f6103f3);
        canvas.drawLine(width2, f4, width + ((int) (cos * r6)), height + ((int) (r6 * sin)), this.f6113z);
        canvas.drawCircle(width2, f4, this.f6100co, this.f6113z);
    }

    public ClockHandView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f6112w = new ArrayList();
        Paint paint = new Paint();
        this.f6113z = paint;
        this.f6108r = new RectF();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.fc, i, R$style.eq);
        this.f6105fh = obtainStyledAttributes.getDimensionPixelSize(R$styleable.f5287uo, 0);
        this.f6107p = obtainStyledAttributes.getDimensionPixelSize(R$styleable.im, 0);
        Resources resources = getResources();
        this.f6103f3 = resources.getDimensionPixelSize(R$dimen.tl);
        this.f6100co = resources.getDimensionPixelSize(R$dimen.xd);
        int color = obtainStyledAttributes.getColor(R$styleable.f5125br, 0);
        paint.setAntiAlias(true);
        paint.setColor(color);
        f(0.0f);
        this.f6110t = ViewConfiguration.get(context).getScaledTouchSlop();
        i4.o0(this, 2);
        obtainStyledAttributes.recycle();
    }
}
