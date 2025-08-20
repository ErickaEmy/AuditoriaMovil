package com.google.android.material.progressindicator;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import android.widget.ProgressBar;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.R$attr;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import h6.a;
import h6.fb;
import h6.n3;
import h6.s;
import hw.i4;
import java.util.Arrays;
import ur.i9;
/* loaded from: classes.dex */
public abstract class y<S extends h6.n3> extends ProgressBar {

    /* renamed from: d0  reason: collision with root package name */
    public static final int f5812d0 = R$style.w4;

    /* renamed from: c  reason: collision with root package name */
    public final o0.n3 f5813c;

    /* renamed from: co  reason: collision with root package name */
    public boolean f5814co;

    /* renamed from: f  reason: collision with root package name */
    public final int f5815f;

    /* renamed from: f3  reason: collision with root package name */
    public final Runnable f5816f3;

    /* renamed from: fb  reason: collision with root package name */
    public boolean f5817fb;

    /* renamed from: n  reason: collision with root package name */
    public final o0.n3 f5818n;

    /* renamed from: p  reason: collision with root package name */
    public h6.y f5819p;

    /* renamed from: r  reason: collision with root package name */
    public final Runnable f5820r;

    /* renamed from: s  reason: collision with root package name */
    public boolean f5821s;

    /* renamed from: t  reason: collision with root package name */
    public final int f5822t;

    /* renamed from: v  reason: collision with root package name */
    public int f5823v;

    /* renamed from: w  reason: collision with root package name */
    public long f5824w;
    public S y;

    /* renamed from: z  reason: collision with root package name */
    public int f5825z;

    /* loaded from: classes.dex */
    public class gv extends o0.n3 {
        public gv() {
        }

        @Override // o0.n3
        public void y(Drawable drawable) {
            super.y(drawable);
            if (!y.this.f5814co) {
                y yVar = y.this;
                yVar.setVisibility(yVar.f5825z);
            }
        }
    }

    /* loaded from: classes.dex */
    public class n3 implements Runnable {
        public n3() {
        }

        @Override // java.lang.Runnable
        public void run() {
            y.this.i9();
            y.this.f5824w = -1L;
        }
    }

    /* renamed from: com.google.android.material.progressindicator.y$y  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0063y implements Runnable {
        public RunnableC0063y() {
        }

        @Override // java.lang.Runnable
        public void run() {
            y.this.f();
        }
    }

    /* loaded from: classes.dex */
    public class zn extends o0.n3 {
        public zn() {
        }

        @Override // o0.n3
        public void y(Drawable drawable) {
            y.this.setIndeterminate(false);
            y.this.xc(0, false);
            y yVar = y.this;
            yVar.xc(yVar.f5823v, y.this.f5817fb);
        }
    }

    public y(@NonNull Context context, @Nullable AttributeSet attributeSet, int i, int i5) {
        super(c0.y.zn(context, attributeSet, i, f5812d0), attributeSet, i);
        this.f5824w = -1L;
        this.f5814co = false;
        this.f5825z = 4;
        this.f5820r = new RunnableC0063y();
        this.f5816f3 = new n3();
        this.f5818n = new zn();
        this.f5813c = new gv();
        Context context2 = getContext();
        this.y = c5(context2, attributeSet);
        TypedArray s2 = i9.s(context2, attributeSet, R$styleable.f5305x, i, i5, new int[0]);
        this.f5815f = s2.getInt(R$styleable.f5182hw, -1);
        this.f5822t = Math.min(s2.getInt(R$styleable.f5321yt, -1), 1000);
        s2.recycle();
        this.f5819p = new h6.y();
        this.f5821s = true;
    }

    @Nullable
    private s<S> getCurrentDrawingDelegate() {
        if (isIndeterminate()) {
            if (getIndeterminateDrawable() == null) {
                return null;
            }
            return getIndeterminateDrawable().r();
        } else if (getProgressDrawable() == null) {
            return null;
        } else {
            return getProgressDrawable().x4();
        }
    }

    public abstract S c5(@NonNull Context context, @NonNull AttributeSet attributeSet);

    public final void f() {
        if (this.f5822t > 0) {
            this.f5824w = SystemClock.uptimeMillis();
        }
        setVisibility(0);
    }

    @Override // android.widget.ProgressBar
    @Nullable
    public Drawable getCurrentDrawable() {
        if (isIndeterminate()) {
            return getIndeterminateDrawable();
        }
        return getProgressDrawable();
    }

    public int getHideAnimationBehavior() {
        return this.y.f8751a;
    }

    @NonNull
    public int[] getIndicatorColor() {
        return this.y.f8755zn;
    }

    public int getShowAnimationBehavior() {
        return this.y.f8754v;
    }

    public int getTrackColor() {
        return this.y.f8752gv;
    }

    public int getTrackCornerRadius() {
        return this.y.f8753n3;
    }

    public int getTrackThickness() {
        return this.y.y;
    }

    public final void i9() {
        ((fb) getCurrentDrawable()).w(false, false, true);
        if (tl()) {
            setVisibility(4);
        }
    }

    @Override // android.view.View
    public void invalidate() {
        super.invalidate();
        if (getCurrentDrawable() != null) {
            getCurrentDrawable().invalidateSelf();
        }
    }

    @Override // android.widget.ProgressBar, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        wz();
        if (p()) {
            f();
        }
    }

    @Override // android.widget.ProgressBar, android.view.View
    public void onDetachedFromWindow() {
        removeCallbacks(this.f5816f3);
        removeCallbacks(this.f5820r);
        ((fb) getCurrentDrawable()).s();
        w();
        super.onDetachedFromWindow();
    }

    @Override // android.widget.ProgressBar, android.view.View
    public synchronized void onDraw(@NonNull Canvas canvas) {
        try {
            int save = canvas.save();
            if (getPaddingLeft() == 0) {
                if (getPaddingTop() != 0) {
                }
                if (getPaddingRight() == 0 || getPaddingBottom() != 0) {
                    canvas.clipRect(0, 0, getWidth() - (getPaddingLeft() + getPaddingRight()), getHeight() - (getPaddingTop() + getPaddingBottom()));
                }
                getCurrentDrawable().draw(canvas);
                canvas.restoreToCount(save);
            }
            canvas.translate(getPaddingLeft(), getPaddingTop());
            if (getPaddingRight() == 0) {
            }
            canvas.clipRect(0, 0, getWidth() - (getPaddingLeft() + getPaddingRight()), getHeight() - (getPaddingTop() + getPaddingBottom()));
            getCurrentDrawable().draw(canvas);
            canvas.restoreToCount(save);
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // android.widget.ProgressBar, android.view.View
    public synchronized void onMeasure(int i, int i5) {
        int paddingLeft;
        int paddingTop;
        try {
            super.onMeasure(i, i5);
            s<S> currentDrawingDelegate = getCurrentDrawingDelegate();
            if (currentDrawingDelegate == null) {
                return;
            }
            int v2 = currentDrawingDelegate.v();
            int gv2 = currentDrawingDelegate.gv();
            if (v2 < 0) {
                paddingLeft = getMeasuredWidth();
            } else {
                paddingLeft = v2 + getPaddingLeft() + getPaddingRight();
            }
            if (gv2 < 0) {
                paddingTop = getMeasuredHeight();
            } else {
                paddingTop = gv2 + getPaddingTop() + getPaddingBottom();
            }
            setMeasuredDimension(paddingLeft, paddingTop);
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // android.view.View
    public void onVisibilityChanged(@NonNull View view, int i) {
        boolean z2;
        super.onVisibilityChanged(view, i);
        if (i == 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        s(z2);
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        s(false);
    }

    public boolean p() {
        if (i4.ut(this) && getWindowVisibility() == 0 && t()) {
            return true;
        }
        return false;
    }

    public void s(boolean z2) {
        if (!this.f5821s) {
            return;
        }
        ((fb) getCurrentDrawable()).w(p(), false, z2);
    }

    public void setAnimatorDurationScaleProvider(@NonNull h6.y yVar) {
        this.f5819p = yVar;
        if (getProgressDrawable() != null) {
            getProgressDrawable().f8727fb = yVar;
        }
        if (getIndeterminateDrawable() != null) {
            getIndeterminateDrawable().f8727fb = yVar;
        }
    }

    public void setHideAnimationBehavior(int i) {
        this.y.f8751a = i;
        invalidate();
    }

    @Override // android.widget.ProgressBar
    public synchronized void setIndeterminate(boolean z2) {
        try {
            if (z2 == isIndeterminate()) {
                return;
            }
            if (p() && z2) {
                throw new IllegalStateException("Cannot switch to indeterminate mode while the progress indicator is visible.");
            }
            fb fbVar = (fb) getCurrentDrawable();
            if (fbVar != null) {
                fbVar.s();
            }
            super.setIndeterminate(z2);
            fb fbVar2 = (fb) getCurrentDrawable();
            if (fbVar2 != null) {
                fbVar2.w(p(), false, false);
            }
            this.f5814co = false;
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // android.widget.ProgressBar
    public void setIndeterminateDrawable(@Nullable Drawable drawable) {
        if (drawable == null) {
            super.setIndeterminateDrawable(null);
        } else if (drawable instanceof h6.i9) {
            ((fb) drawable).s();
            super.setIndeterminateDrawable(drawable);
        } else {
            throw new IllegalArgumentException("Cannot set framework drawable as indeterminate drawable.");
        }
    }

    public void setIndicatorColor(int... iArr) {
        if (iArr.length == 0) {
            iArr = new int[]{td.y.n3(getContext(), R$attr.f5086t, -1)};
        }
        if (!Arrays.equals(getIndicatorColor(), iArr)) {
            this.y.f8755zn = iArr;
            getIndeterminateDrawable().z().zn();
            invalidate();
        }
    }

    @Override // android.widget.ProgressBar
    public synchronized void setProgress(int i) {
        if (isIndeterminate()) {
            return;
        }
        xc(i, false);
    }

    @Override // android.widget.ProgressBar
    public void setProgressDrawable(@Nullable Drawable drawable) {
        if (drawable == null) {
            super.setProgressDrawable(null);
        } else if (drawable instanceof a) {
            a aVar = (a) drawable;
            aVar.s();
            super.setProgressDrawable(aVar);
            aVar.c(getProgress() / getMax());
        } else {
            throw new IllegalArgumentException("Cannot set framework drawable as progress drawable.");
        }
    }

    public void setShowAnimationBehavior(int i) {
        this.y.f8754v = i;
        invalidate();
    }

    public void setTrackColor(int i) {
        S s2 = this.y;
        if (s2.f8752gv != i) {
            s2.f8752gv = i;
            invalidate();
        }
    }

    public void setTrackCornerRadius(int i) {
        S s2 = this.y;
        if (s2.f8753n3 != i) {
            s2.f8753n3 = Math.min(i, s2.y / 2);
        }
    }

    public void setTrackThickness(int i) {
        S s2 = this.y;
        if (s2.y != i) {
            s2.y = i;
            requestLayout();
        }
    }

    public void setVisibilityAfterHide(int i) {
        if (i != 0 && i != 4 && i != 8) {
            throw new IllegalArgumentException("The component's visibility must be one of VISIBLE, INVISIBLE, and GONE defined in View.");
        }
        this.f5825z = i;
    }

    public boolean t() {
        View view = this;
        while (view.getVisibility() == 0) {
            ViewParent parent = view.getParent();
            if (parent == null) {
                if (getWindowVisibility() != 0) {
                    return false;
                }
                return true;
            } else if (!(parent instanceof View)) {
                return true;
            } else {
                view = (View) parent;
            }
        }
        return false;
    }

    public final boolean tl() {
        if ((getProgressDrawable() != null && getProgressDrawable().isVisible()) || (getIndeterminateDrawable() != null && getIndeterminateDrawable().isVisible())) {
            return false;
        }
        return true;
    }

    public final void w() {
        if (getIndeterminateDrawable() != null) {
            getIndeterminateDrawable().mt(this.f5813c);
            getIndeterminateDrawable().z().s();
        }
        if (getProgressDrawable() != null) {
            getProgressDrawable().mt(this.f5813c);
        }
    }

    public final void wz() {
        if (getProgressDrawable() != null && getIndeterminateDrawable() != null) {
            getIndeterminateDrawable().z().gv(this.f5818n);
        }
        if (getProgressDrawable() != null) {
            getProgressDrawable().t(this.f5813c);
        }
        if (getIndeterminateDrawable() != null) {
            getIndeterminateDrawable().t(this.f5813c);
        }
    }

    public void xc(int i, boolean z2) {
        if (isIndeterminate()) {
            if (getProgressDrawable() != null) {
                this.f5823v = i;
                this.f5817fb = z2;
                this.f5814co = true;
                if (getIndeterminateDrawable().isVisible() && this.f5819p.y(getContext().getContentResolver()) != 0.0f) {
                    getIndeterminateDrawable().z().a();
                    return;
                } else {
                    this.f5818n.y(getIndeterminateDrawable());
                    return;
                }
            }
            return;
        }
        super.setProgress(i);
        if (getProgressDrawable() != null && !z2) {
            getProgressDrawable().jumpToCurrentState();
        }
    }

    @Override // android.widget.ProgressBar
    @Nullable
    public h6.i9<S> getIndeterminateDrawable() {
        return (h6.i9) super.getIndeterminateDrawable();
    }

    @Override // android.widget.ProgressBar
    @Nullable
    public a<S> getProgressDrawable() {
        return (a) super.getProgressDrawable();
    }
}
