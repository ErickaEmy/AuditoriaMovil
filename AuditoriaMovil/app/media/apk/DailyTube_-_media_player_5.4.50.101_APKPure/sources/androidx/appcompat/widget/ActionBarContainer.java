package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.R$id;
import androidx.appcompat.R$styleable;
import hw.i4;
/* loaded from: classes.dex */
public class ActionBarContainer extends FrameLayout {

    /* renamed from: co  reason: collision with root package name */
    public boolean f1234co;

    /* renamed from: f  reason: collision with root package name */
    public Drawable f1235f;

    /* renamed from: fb  reason: collision with root package name */
    public View f1236fb;

    /* renamed from: p  reason: collision with root package name */
    public boolean f1237p;

    /* renamed from: s  reason: collision with root package name */
    public View f1238s;

    /* renamed from: t  reason: collision with root package name */
    public Drawable f1239t;

    /* renamed from: v  reason: collision with root package name */
    public View f1240v;

    /* renamed from: w  reason: collision with root package name */
    public Drawable f1241w;
    public boolean y;

    /* renamed from: z  reason: collision with root package name */
    public int f1242z;

    public ActionBarContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        i4.u0(this, new wz.n3(this));
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.y);
        this.f1235f = obtainStyledAttributes.getDrawable(R$styleable.f871n3);
        this.f1239t = obtainStyledAttributes.getDrawable(R$styleable.f844gv);
        this.f1242z = obtainStyledAttributes.getDimensionPixelSize(R$styleable.f849i9, -1);
        boolean z2 = true;
        if (getId() == R$id.f738ej) {
            this.f1237p = true;
            this.f1241w = obtainStyledAttributes.getDrawable(R$styleable.f931zn);
        }
        obtainStyledAttributes.recycle();
        if (!this.f1237p ? this.f1235f != null || this.f1239t != null : this.f1241w != null) {
            z2 = false;
        }
        setWillNotDraw(z2);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.f1235f;
        if (drawable != null && drawable.isStateful()) {
            this.f1235f.setState(getDrawableState());
        }
        Drawable drawable2 = this.f1239t;
        if (drawable2 != null && drawable2.isStateful()) {
            this.f1239t.setState(getDrawableState());
        }
        Drawable drawable3 = this.f1241w;
        if (drawable3 != null && drawable3.isStateful()) {
            this.f1241w.setState(getDrawableState());
        }
    }

    public View getTabContainer() {
        return this.f1240v;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f1235f;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
        Drawable drawable2 = this.f1239t;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
        }
        Drawable drawable3 = this.f1241w;
        if (drawable3 != null) {
            drawable3.jumpToCurrentState();
        }
    }

    public final boolean n3(View view) {
        if (view != null && view.getVisibility() != 8 && view.getMeasuredHeight() != 0) {
            return false;
        }
        return true;
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.f1236fb = findViewById(R$id.y);
        this.f1238s = findViewById(R$id.f730a);
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        super.onHoverEvent(motionEvent);
        return true;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!this.y && !super.onInterceptTouchEvent(motionEvent)) {
            return false;
        }
        return true;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z2, int i, int i5, int i6, int i8) {
        boolean z3;
        Drawable drawable;
        super.onLayout(z2, i, i5, i6, i8);
        View view = this.f1240v;
        boolean z4 = true;
        boolean z5 = false;
        if (view != null && view.getVisibility() != 8) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (view != null && view.getVisibility() != 8) {
            int measuredHeight = getMeasuredHeight();
            int i10 = ((FrameLayout.LayoutParams) view.getLayoutParams()).bottomMargin;
            view.layout(i, (measuredHeight - view.getMeasuredHeight()) - i10, i6, measuredHeight - i10);
        }
        if (this.f1237p) {
            Drawable drawable2 = this.f1241w;
            if (drawable2 != null) {
                drawable2.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            } else {
                z4 = false;
            }
        } else {
            if (this.f1235f != null) {
                if (this.f1236fb.getVisibility() == 0) {
                    this.f1235f.setBounds(this.f1236fb.getLeft(), this.f1236fb.getTop(), this.f1236fb.getRight(), this.f1236fb.getBottom());
                } else {
                    View view2 = this.f1238s;
                    if (view2 != null && view2.getVisibility() == 0) {
                        this.f1235f.setBounds(this.f1238s.getLeft(), this.f1238s.getTop(), this.f1238s.getRight(), this.f1238s.getBottom());
                    } else {
                        this.f1235f.setBounds(0, 0, 0, 0);
                    }
                }
                z5 = true;
            }
            this.f1234co = z3;
            if (z3 && (drawable = this.f1239t) != null) {
                drawable.setBounds(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            } else {
                z4 = z5;
            }
        }
        if (z4) {
            invalidate();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i5) {
        int i6;
        int i8;
        int i10;
        if (this.f1236fb == null && View.MeasureSpec.getMode(i5) == Integer.MIN_VALUE && (i10 = this.f1242z) >= 0) {
            i5 = View.MeasureSpec.makeMeasureSpec(Math.min(i10, View.MeasureSpec.getSize(i5)), Integer.MIN_VALUE);
        }
        super.onMeasure(i, i5);
        if (this.f1236fb == null) {
            return;
        }
        int mode = View.MeasureSpec.getMode(i5);
        View view = this.f1240v;
        if (view != null && view.getVisibility() != 8 && mode != 1073741824) {
            if (!n3(this.f1236fb)) {
                i6 = y(this.f1236fb);
            } else if (!n3(this.f1238s)) {
                i6 = y(this.f1238s);
            } else {
                i6 = 0;
            }
            if (mode == Integer.MIN_VALUE) {
                i8 = View.MeasureSpec.getSize(i5);
            } else {
                i8 = Integer.MAX_VALUE;
            }
            setMeasuredDimension(getMeasuredWidth(), Math.min(i6 + y(this.f1240v), i8));
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        return true;
    }

    public void setPrimaryBackground(Drawable drawable) {
        Drawable drawable2 = this.f1235f;
        if (drawable2 != null) {
            drawable2.setCallback(null);
            unscheduleDrawable(this.f1235f);
        }
        this.f1235f = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            View view = this.f1236fb;
            if (view != null) {
                this.f1235f.setBounds(view.getLeft(), this.f1236fb.getTop(), this.f1236fb.getRight(), this.f1236fb.getBottom());
            }
        }
        boolean z2 = false;
        if (!this.f1237p ? !(this.f1235f != null || this.f1239t != null) : this.f1241w == null) {
            z2 = true;
        }
        setWillNotDraw(z2);
        invalidate();
        invalidateOutline();
    }

    public void setSplitBackground(Drawable drawable) {
        Drawable drawable2;
        Drawable drawable3 = this.f1241w;
        if (drawable3 != null) {
            drawable3.setCallback(null);
            unscheduleDrawable(this.f1241w);
        }
        this.f1241w = drawable;
        boolean z2 = false;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.f1237p && (drawable2 = this.f1241w) != null) {
                drawable2.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            }
        }
        if (!this.f1237p ? !(this.f1235f != null || this.f1239t != null) : this.f1241w == null) {
            z2 = true;
        }
        setWillNotDraw(z2);
        invalidate();
        invalidateOutline();
    }

    public void setStackedBackground(Drawable drawable) {
        Drawable drawable2;
        Drawable drawable3 = this.f1239t;
        if (drawable3 != null) {
            drawable3.setCallback(null);
            unscheduleDrawable(this.f1239t);
        }
        this.f1239t = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.f1234co && (drawable2 = this.f1239t) != null) {
                drawable2.setBounds(this.f1240v.getLeft(), this.f1240v.getTop(), this.f1240v.getRight(), this.f1240v.getBottom());
            }
        }
        boolean z2 = false;
        if (!this.f1237p ? !(this.f1235f != null || this.f1239t != null) : this.f1241w == null) {
            z2 = true;
        }
        setWillNotDraw(z2);
        invalidate();
        invalidateOutline();
    }

    public void setTabContainer(n3 n3Var) {
        View view = this.f1240v;
        if (view != null) {
            removeView(view);
        }
        this.f1240v = n3Var;
        if (n3Var != null) {
            addView(n3Var);
            ViewGroup.LayoutParams layoutParams = n3Var.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -2;
            n3Var.setAllowCollapse(false);
        }
    }

    public void setTransitioning(boolean z2) {
        int i;
        this.y = z2;
        if (z2) {
            i = 393216;
        } else {
            i = 262144;
        }
        setDescendantFocusability(i);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        boolean z2;
        super.setVisibility(i);
        if (i == 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        Drawable drawable = this.f1235f;
        if (drawable != null) {
            drawable.setVisible(z2, false);
        }
        Drawable drawable2 = this.f1239t;
        if (drawable2 != null) {
            drawable2.setVisible(z2, false);
        }
        Drawable drawable3 = this.f1241w;
        if (drawable3 != null) {
            drawable3.setVisible(z2, false);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public ActionMode startActionModeForChild(View view, ActionMode.Callback callback) {
        return null;
    }

    @Override // android.view.View
    public boolean verifyDrawable(Drawable drawable) {
        if ((drawable == this.f1235f && !this.f1237p) || ((drawable == this.f1239t && this.f1234co) || ((drawable == this.f1241w && this.f1237p) || super.verifyDrawable(drawable)))) {
            return true;
        }
        return false;
    }

    public final int y(View view) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        return view.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public ActionMode startActionModeForChild(View view, ActionMode.Callback callback, int i) {
        if (i != 0) {
            return super.startActionModeForChild(view, callback, i);
        }
        return null;
    }
}
