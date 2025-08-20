package androidx.appcompat.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$id;
import androidx.appcompat.R$layout;
import androidx.appcompat.R$styleable;
import androidx.appcompat.view.menu.v;
import hw.i4;
import hw.mg;
import wz.hw;
import wz.oz;
/* loaded from: classes.dex */
public class ActionBarContextView extends wz.y {

    /* renamed from: b  reason: collision with root package name */
    public int f1243b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f1244c;

    /* renamed from: co  reason: collision with root package name */
    public CharSequence f1245co;

    /* renamed from: d  reason: collision with root package name */
    public int f1246d;

    /* renamed from: d0  reason: collision with root package name */
    public TextView f1247d0;

    /* renamed from: ej  reason: collision with root package name */
    public int f1248ej;

    /* renamed from: f3  reason: collision with root package name */
    public View f1249f3;

    /* renamed from: fh  reason: collision with root package name */
    public TextView f1250fh;

    /* renamed from: n  reason: collision with root package name */
    public View f1251n;

    /* renamed from: r  reason: collision with root package name */
    public View f1252r;

    /* renamed from: x  reason: collision with root package name */
    public boolean f1253x;

    /* renamed from: z  reason: collision with root package name */
    public CharSequence f1254z;

    /* loaded from: classes.dex */
    public class y implements View.OnClickListener {
        public final /* synthetic */ t.n3 y;

        public y(t.n3 n3Var) {
            this.y = n3Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.y.zn();
        }
    }

    public ActionBarContextView(@NonNull Context context) {
        this(context, null);
    }

    @Override // wz.y
    public /* bridge */ /* synthetic */ mg a(int i, long j2) {
        return super.a(i, j2);
    }

    public final void c5() {
        int i;
        if (this.f1244c == null) {
            LayoutInflater.from(getContext()).inflate(R$layout.y, this);
            LinearLayout linearLayout = (LinearLayout) getChildAt(getChildCount() - 1);
            this.f1244c = linearLayout;
            this.f1247d0 = (TextView) linearLayout.findViewById(R$id.f760v);
            this.f1250fh = (TextView) this.f1244c.findViewById(R$id.f743gv);
            if (this.f1246d != 0) {
                this.f1247d0.setTextAppearance(getContext(), this.f1246d);
            }
            if (this.f1248ej != 0) {
                this.f1250fh.setTextAppearance(getContext(), this.f1248ej);
            }
        }
        this.f1247d0.setText(this.f1245co);
        this.f1250fh.setText(this.f1254z);
        boolean isEmpty = TextUtils.isEmpty(this.f1245co);
        boolean isEmpty2 = TextUtils.isEmpty(this.f1254z);
        TextView textView = this.f1250fh;
        int i5 = 8;
        if (!isEmpty2) {
            i = 0;
        } else {
            i = 8;
        }
        textView.setVisibility(i);
        this.f1244c.setVisibility((isEmpty && isEmpty2) ? 0 : 0);
        if (this.f1244c.getParent() == null) {
            addView(this.f1244c);
        }
    }

    public void f() {
        removeAllViews();
        this.f1251n = null;
        this.f14843fb = null;
        this.f14845s = null;
        View view = this.f1249f3;
        if (view != null) {
            view.setOnClickListener(null);
        }
    }

    public void fb() {
        if (this.f1252r == null) {
            f();
        }
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-1, -2);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ViewGroup.MarginLayoutParams(getContext(), attributeSet);
    }

    @Override // wz.y
    public /* bridge */ /* synthetic */ int getAnimatedVisibility() {
        return super.getAnimatedVisibility();
    }

    @Override // wz.y
    public /* bridge */ /* synthetic */ int getContentHeight() {
        return super.getContentHeight();
    }

    public CharSequence getSubtitle() {
        return this.f1254z;
    }

    public CharSequence getTitle() {
        return this.f1245co;
    }

    public boolean i9() {
        return this.f1253x;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        androidx.appcompat.widget.y yVar = this.f14845s;
        if (yVar != null) {
            yVar.fh();
            this.f14845s.rz();
        }
    }

    @Override // wz.y, android.view.View
    public /* bridge */ /* synthetic */ boolean onHoverEvent(MotionEvent motionEvent) {
        return super.onHoverEvent(motionEvent);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (accessibilityEvent.getEventType() == 32) {
            accessibilityEvent.setSource(this);
            accessibilityEvent.setClassName(getClass().getName());
            accessibilityEvent.setPackageName(getContext().getPackageName());
            accessibilityEvent.setContentDescription(this.f1245co);
            return;
        }
        super.onInitializeAccessibilityEvent(accessibilityEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z2, int i, int i5, int i6, int i8) {
        int paddingLeft;
        int paddingRight;
        int i10;
        int i11;
        boolean n32 = oz.n3(this);
        if (n32) {
            paddingLeft = (i6 - i) - getPaddingRight();
        } else {
            paddingLeft = getPaddingLeft();
        }
        int paddingTop = getPaddingTop();
        int paddingTop2 = ((i8 - i5) - getPaddingTop()) - getPaddingBottom();
        View view = this.f1252r;
        if (view != null && view.getVisibility() != 8) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f1252r.getLayoutParams();
            if (n32) {
                i10 = marginLayoutParams.rightMargin;
            } else {
                i10 = marginLayoutParams.leftMargin;
            }
            if (n32) {
                i11 = marginLayoutParams.leftMargin;
            } else {
                i11 = marginLayoutParams.rightMargin;
            }
            int gv2 = wz.y.gv(paddingLeft, i10, n32);
            paddingLeft = wz.y.gv(gv2 + v(this.f1252r, gv2, paddingTop, paddingTop2, n32), i11, n32);
        }
        int i12 = paddingLeft;
        LinearLayout linearLayout = this.f1244c;
        if (linearLayout != null && this.f1251n == null && linearLayout.getVisibility() != 8) {
            i12 += v(this.f1244c, i12, paddingTop, paddingTop2, n32);
        }
        int i13 = i12;
        View view2 = this.f1251n;
        if (view2 != null) {
            v(view2, i13, paddingTop, paddingTop2, n32);
        }
        if (n32) {
            paddingRight = getPaddingLeft();
        } else {
            paddingRight = (i6 - i) - getPaddingRight();
        }
        ActionMenuView actionMenuView = this.f14843fb;
        if (actionMenuView != null) {
            v(actionMenuView, paddingRight, paddingTop, paddingTop2, !n32);
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i5) {
        int i6;
        boolean z2;
        int i8;
        int i10 = 1073741824;
        if (View.MeasureSpec.getMode(i) == 1073741824) {
            if (View.MeasureSpec.getMode(i5) != 0) {
                int size = View.MeasureSpec.getSize(i);
                int i11 = this.f14842f;
                if (i11 <= 0) {
                    i11 = View.MeasureSpec.getSize(i5);
                }
                int paddingTop = getPaddingTop() + getPaddingBottom();
                int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
                int i12 = i11 - paddingTop;
                int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i12, Integer.MIN_VALUE);
                View view = this.f1252r;
                if (view != null) {
                    int zn2 = zn(view, paddingLeft, makeMeasureSpec, 0);
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f1252r.getLayoutParams();
                    paddingLeft = zn2 - (marginLayoutParams.leftMargin + marginLayoutParams.rightMargin);
                }
                ActionMenuView actionMenuView = this.f14843fb;
                if (actionMenuView != null && actionMenuView.getParent() == this) {
                    paddingLeft = zn(this.f14843fb, paddingLeft, makeMeasureSpec, 0);
                }
                LinearLayout linearLayout = this.f1244c;
                if (linearLayout != null && this.f1251n == null) {
                    if (this.f1253x) {
                        this.f1244c.measure(View.MeasureSpec.makeMeasureSpec(0, 0), makeMeasureSpec);
                        int measuredWidth = this.f1244c.getMeasuredWidth();
                        if (measuredWidth <= paddingLeft) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        if (z2) {
                            paddingLeft -= measuredWidth;
                        }
                        LinearLayout linearLayout2 = this.f1244c;
                        if (z2) {
                            i8 = 0;
                        } else {
                            i8 = 8;
                        }
                        linearLayout2.setVisibility(i8);
                    } else {
                        paddingLeft = zn(linearLayout, paddingLeft, makeMeasureSpec, 0);
                    }
                }
                View view2 = this.f1251n;
                if (view2 != null) {
                    ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
                    int i13 = layoutParams.width;
                    if (i13 != -2) {
                        i6 = 1073741824;
                    } else {
                        i6 = Integer.MIN_VALUE;
                    }
                    if (i13 >= 0) {
                        paddingLeft = Math.min(i13, paddingLeft);
                    }
                    int i14 = layoutParams.height;
                    if (i14 == -2) {
                        i10 = Integer.MIN_VALUE;
                    }
                    if (i14 >= 0) {
                        i12 = Math.min(i14, i12);
                    }
                    this.f1251n.measure(View.MeasureSpec.makeMeasureSpec(paddingLeft, i6), View.MeasureSpec.makeMeasureSpec(i12, i10));
                }
                if (this.f14842f <= 0) {
                    int childCount = getChildCount();
                    int i15 = 0;
                    for (int i16 = 0; i16 < childCount; i16++) {
                        int measuredHeight = getChildAt(i16).getMeasuredHeight() + paddingTop;
                        if (measuredHeight > i15) {
                            i15 = measuredHeight;
                        }
                    }
                    setMeasuredDimension(size, i15);
                    return;
                }
                setMeasuredDimension(size, i11);
                return;
            }
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with android:layout_height=\"wrap_content\"");
        }
        throw new IllegalStateException(getClass().getSimpleName() + " can only be used with android:layout_width=\"match_parent\" (or fill_parent)");
    }

    @Override // wz.y, android.view.View
    public /* bridge */ /* synthetic */ boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    public void s(t.n3 n3Var) {
        View view = this.f1252r;
        if (view == null) {
            View inflate = LayoutInflater.from(getContext()).inflate(this.f1243b, (ViewGroup) this, false);
            this.f1252r = inflate;
            addView(inflate);
        } else if (view.getParent() == null) {
            addView(this.f1252r);
        }
        View findViewById = this.f1252r.findViewById(R$id.f734c5);
        this.f1249f3 = findViewById;
        findViewById.setOnClickListener(new y(n3Var));
        v vVar = (v) n3Var.v();
        androidx.appcompat.widget.y yVar = this.f14845s;
        if (yVar != null) {
            yVar.n();
        }
        androidx.appcompat.widget.y yVar2 = new androidx.appcompat.widget.y(getContext());
        this.f14845s = yVar2;
        yVar2.a8(true);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-2, -1);
        vVar.zn(this.f14845s, this.f14847v);
        ActionMenuView actionMenuView = (ActionMenuView) this.f14845s.xc(this);
        this.f14843fb = actionMenuView;
        i4.u0(actionMenuView, null);
        addView(this.f14843fb, layoutParams);
    }

    @Override // wz.y
    public void setContentHeight(int i) {
        this.f14842f = i;
    }

    public void setCustomView(View view) {
        LinearLayout linearLayout;
        View view2 = this.f1251n;
        if (view2 != null) {
            removeView(view2);
        }
        this.f1251n = view;
        if (view != null && (linearLayout = this.f1244c) != null) {
            removeView(linearLayout);
            this.f1244c = null;
        }
        if (view != null) {
            addView(view);
        }
        requestLayout();
    }

    public void setSubtitle(CharSequence charSequence) {
        this.f1254z = charSequence;
        c5();
    }

    public void setTitle(CharSequence charSequence) {
        this.f1245co = charSequence;
        c5();
    }

    public void setTitleOptional(boolean z2) {
        if (z2 != this.f1253x) {
            requestLayout();
        }
        this.f1253x = z2;
    }

    @Override // wz.y, android.view.View
    public /* bridge */ /* synthetic */ void setVisibility(int i) {
        super.setVisibility(i);
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public boolean t() {
        androidx.appcompat.widget.y yVar = this.f14845s;
        if (yVar != null) {
            return yVar.x();
        }
        return false;
    }

    public ActionBarContextView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.f640i9);
    }

    public ActionBarContextView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        hw x42 = hw.x4(context, attributeSet, R$styleable.f870n, i, 0);
        i4.u0(this, x42.fb(R$styleable.f815c));
        this.f1246d = x42.wz(R$styleable.f867mg, 0);
        this.f1248ej = x42.wz(R$styleable.f894rz, 0);
        this.f14842f = x42.tl(R$styleable.f839fh, 0);
        this.f1243b = x42.wz(R$styleable.f823d0, R$layout.f776gv);
        x42.i4();
    }
}
