package wz;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$styleable;
import androidx.appcompat.widget.ActionMenuView;
/* loaded from: classes.dex */
public abstract class y extends ViewGroup {

    /* renamed from: f  reason: collision with root package name */
    public int f14842f;

    /* renamed from: fb  reason: collision with root package name */
    public ActionMenuView f14843fb;

    /* renamed from: p  reason: collision with root package name */
    public boolean f14844p;

    /* renamed from: s  reason: collision with root package name */
    public androidx.appcompat.widget.y f14845s;

    /* renamed from: t  reason: collision with root package name */
    public hw.mg f14846t;

    /* renamed from: v  reason: collision with root package name */
    public final Context f14847v;

    /* renamed from: w  reason: collision with root package name */
    public boolean f14848w;
    public final C0245y y;

    /* renamed from: wz.y$y  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0245y implements hw.ta {

        /* renamed from: n3  reason: collision with root package name */
        public int f14849n3;
        public boolean y;

        public C0245y() {
        }

        public C0245y gv(hw.mg mgVar, int i) {
            y.this.f14846t = mgVar;
            this.f14849n3 = i;
            return this;
        }

        @Override // hw.ta
        public void n3(View view) {
            if (this.y) {
                return;
            }
            y yVar = y.this;
            yVar.f14846t = null;
            y.super.setVisibility(this.f14849n3);
        }

        @Override // hw.ta
        public void y(View view) {
            this.y = true;
        }

        @Override // hw.ta
        public void zn(View view) {
            y.super.setVisibility(0);
            this.y = false;
        }
    }

    public y(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public static int gv(int i, int i5, boolean z2) {
        if (z2) {
            return i - i5;
        }
        return i + i5;
    }

    public hw.mg a(int i, long j2) {
        hw.mg mgVar = this.f14846t;
        if (mgVar != null) {
            mgVar.zn();
        }
        if (i == 0) {
            if (getVisibility() != 0) {
                setAlpha(0.0f);
            }
            hw.mg n32 = hw.i4.v(this).n3(1.0f);
            n32.a(j2);
            n32.s(this.y.gv(n32, i));
            return n32;
        }
        hw.mg n33 = hw.i4.v(this).n3(0.0f);
        n33.a(j2);
        n33.s(this.y.gv(n33, i));
        return n33;
    }

    public int getAnimatedVisibility() {
        if (this.f14846t != null) {
            return this.y.f14849n3;
        }
        return getVisibility();
    }

    public int getContentHeight() {
        return this.f14842f;
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(null, R$styleable.y, R$attr.f664zn, 0);
        setContentHeight(obtainStyledAttributes.getLayoutDimension(R$styleable.f849i9, 0));
        obtainStyledAttributes.recycle();
        androidx.appcompat.widget.y yVar = this.f14845s;
        if (yVar != null) {
            yVar.d(configuration);
        }
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.f14844p = false;
        }
        if (!this.f14844p) {
            boolean onHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !onHoverEvent) {
                this.f14844p = true;
            }
        }
        if (actionMasked == 10 || actionMasked == 3) {
            this.f14844p = false;
        }
        return true;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f14848w = false;
        }
        if (!this.f14848w) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !onTouchEvent) {
                this.f14848w = true;
            }
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.f14848w = false;
        }
        return true;
    }

    public void setContentHeight(int i) {
        this.f14842f = i;
        requestLayout();
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        if (i != getVisibility()) {
            hw.mg mgVar = this.f14846t;
            if (mgVar != null) {
                mgVar.zn();
            }
            super.setVisibility(i);
        }
    }

    public int v(View view, int i, int i5, int i6, boolean z2) {
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        int i8 = i5 + ((i6 - measuredHeight) / 2);
        if (z2) {
            view.layout(i - measuredWidth, i8, i, measuredHeight + i8);
        } else {
            view.layout(i, i8, i + measuredWidth, measuredHeight + i8);
        }
        if (z2) {
            return -measuredWidth;
        }
        return measuredWidth;
    }

    public int zn(View view, int i, int i5, int i6) {
        view.measure(View.MeasureSpec.makeMeasureSpec(i, Integer.MIN_VALUE), i5);
        return Math.max(0, (i - view.getMeasuredWidth()) - i6);
    }

    public y(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.y = new C0245y();
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(R$attr.y, typedValue, true) && typedValue.resourceId != 0) {
            this.f14847v = new ContextThemeWrapper(context, typedValue.resourceId);
        } else {
            this.f14847v = context;
        }
    }
}
