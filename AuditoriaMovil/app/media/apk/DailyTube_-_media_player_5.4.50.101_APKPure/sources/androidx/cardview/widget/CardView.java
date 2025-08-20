package androidx.cardview.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.R$attr;
import androidx.cardview.R$color;
import androidx.cardview.R$style;
import androidx.cardview.R$styleable;
import co.n3;
import co.zn;
/* loaded from: classes.dex */
public class CardView extends FrameLayout {

    /* renamed from: co  reason: collision with root package name */
    public static final zn f1583co;

    /* renamed from: p  reason: collision with root package name */
    public static final int[] f1584p = {16842801};

    /* renamed from: f  reason: collision with root package name */
    public final Rect f1585f;

    /* renamed from: fb  reason: collision with root package name */
    public int f1586fb;

    /* renamed from: s  reason: collision with root package name */
    public int f1587s;

    /* renamed from: t  reason: collision with root package name */
    public final Rect f1588t;

    /* renamed from: v  reason: collision with root package name */
    public boolean f1589v;

    /* renamed from: w  reason: collision with root package name */
    public final n3 f1590w;
    public boolean y;

    /* loaded from: classes.dex */
    public class y implements n3 {
        public Drawable y;

        public y() {
        }

        @Override // co.n3
        public View a() {
            return CardView.this;
        }

        @Override // co.n3
        public Drawable gv() {
            return this.y;
        }

        @Override // co.n3
        public void n3(Drawable drawable) {
            this.y = drawable;
            CardView.this.setBackgroundDrawable(drawable);
        }

        @Override // co.n3
        public boolean v() {
            return CardView.this.getPreventCornerOverlap();
        }

        @Override // co.n3
        public void y(int i, int i5, int i6, int i8) {
            CardView.this.f1588t.set(i, i5, i6, i8);
            CardView cardView = CardView.this;
            Rect rect = cardView.f1585f;
            CardView.super.setPadding(i + rect.left, i5 + rect.top, i6 + rect.right, i8 + rect.bottom);
        }

        @Override // co.n3
        public boolean zn() {
            return CardView.this.getUseCompatPadding();
        }
    }

    static {
        co.y yVar = new co.y();
        f1583co = yVar;
        yVar.c5();
    }

    public CardView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.kb);
    }

    @NonNull
    public ColorStateList getCardBackgroundColor() {
        return f1583co.s(this.f1590w);
    }

    public float getCardElevation() {
        return f1583co.a(this.f1590w);
    }

    public int getContentPaddingBottom() {
        return this.f1585f.bottom;
    }

    public int getContentPaddingLeft() {
        return this.f1585f.left;
    }

    public int getContentPaddingRight() {
        return this.f1585f.right;
    }

    public int getContentPaddingTop() {
        return this.f1585f.top;
    }

    public float getMaxCardElevation() {
        return f1583co.t(this.f1590w);
    }

    public boolean getPreventCornerOverlap() {
        return this.f1589v;
    }

    public float getRadius() {
        return f1583co.n3(this.f1590w);
    }

    public boolean getUseCompatPadding() {
        return this.y;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i5) {
        zn znVar = f1583co;
        if (!(znVar instanceof co.y)) {
            int mode = View.MeasureSpec.getMode(i);
            if (mode == Integer.MIN_VALUE || mode == 1073741824) {
                i = View.MeasureSpec.makeMeasureSpec(Math.max((int) Math.ceil(znVar.y(this.f1590w)), View.MeasureSpec.getSize(i)), mode);
            }
            int mode2 = View.MeasureSpec.getMode(i5);
            if (mode2 == Integer.MIN_VALUE || mode2 == 1073741824) {
                i5 = View.MeasureSpec.makeMeasureSpec(Math.max((int) Math.ceil(znVar.wz(this.f1590w)), View.MeasureSpec.getSize(i5)), mode2);
            }
            super.onMeasure(i, i5);
            return;
        }
        super.onMeasure(i, i5);
    }

    public void setCardBackgroundColor(int i) {
        f1583co.tl(this.f1590w, ColorStateList.valueOf(i));
    }

    public void setCardElevation(float f4) {
        f1583co.zn(this.f1590w, f4);
    }

    public void setMaxCardElevation(float f4) {
        f1583co.gv(this.f1590w, f4);
    }

    @Override // android.view.View
    public void setMinimumHeight(int i) {
        this.f1587s = i;
        super.setMinimumHeight(i);
    }

    @Override // android.view.View
    public void setMinimumWidth(int i) {
        this.f1586fb = i;
        super.setMinimumWidth(i);
    }

    @Override // android.view.View
    public void setPadding(int i, int i5, int i6, int i8) {
    }

    @Override // android.view.View
    public void setPaddingRelative(int i, int i5, int i6, int i8) {
    }

    public void setPreventCornerOverlap(boolean z2) {
        if (z2 != this.f1589v) {
            this.f1589v = z2;
            f1583co.f(this.f1590w);
        }
    }

    public void setRadius(float f4) {
        f1583co.fb(this.f1590w, f4);
    }

    public void setUseCompatPadding(boolean z2) {
        if (this.y != z2) {
            this.y = z2;
            f1583co.v(this.f1590w);
        }
    }

    public CardView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        int color;
        ColorStateList valueOf;
        Rect rect = new Rect();
        this.f1585f = rect;
        this.f1588t = new Rect();
        y yVar = new y();
        this.f1590w = yVar;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.y, i, R$style.yj);
        int i5 = R$styleable.f1574gv;
        if (obtainStyledAttributes.hasValue(i5)) {
            valueOf = obtainStyledAttributes.getColorStateList(i5);
        } else {
            TypedArray obtainStyledAttributes2 = getContext().obtainStyledAttributes(f1584p);
            int color2 = obtainStyledAttributes2.getColor(0, 0);
            obtainStyledAttributes2.recycle();
            float[] fArr = new float[3];
            Color.colorToHSV(color2, fArr);
            if (fArr[2] > 0.5f) {
                color = getResources().getColor(R$color.sp);
            } else {
                color = getResources().getColor(R$color.sq);
            }
            valueOf = ColorStateList.valueOf(color);
        }
        ColorStateList colorStateList = valueOf;
        float dimension = obtainStyledAttributes.getDimension(R$styleable.f1580v, 0.0f);
        float dimension2 = obtainStyledAttributes.getDimension(R$styleable.f1570a, 0.0f);
        float dimension3 = obtainStyledAttributes.getDimension(R$styleable.f1573fb, 0.0f);
        this.y = obtainStyledAttributes.getBoolean(R$styleable.f1571c5, false);
        this.f1589v = obtainStyledAttributes.getBoolean(R$styleable.f1577s, true);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R$styleable.f1575i9, 0);
        rect.left = obtainStyledAttributes.getDimensionPixelSize(R$styleable.f1578t, dimensionPixelSize);
        rect.top = obtainStyledAttributes.getDimensionPixelSize(R$styleable.f1581wz, dimensionPixelSize);
        rect.right = obtainStyledAttributes.getDimensionPixelSize(R$styleable.f1579tl, dimensionPixelSize);
        rect.bottom = obtainStyledAttributes.getDimensionPixelSize(R$styleable.f1572f, dimensionPixelSize);
        float f4 = dimension2 > dimension3 ? dimension2 : dimension3;
        this.f1586fb = obtainStyledAttributes.getDimensionPixelSize(R$styleable.f1576n3, 0);
        this.f1587s = obtainStyledAttributes.getDimensionPixelSize(R$styleable.f1582zn, 0);
        obtainStyledAttributes.recycle();
        f1583co.i9(yVar, context, colorStateList, dimension, dimension2, f4);
    }

    public void setCardBackgroundColor(@Nullable ColorStateList colorStateList) {
        f1583co.tl(this.f1590w, colorStateList);
    }
}
