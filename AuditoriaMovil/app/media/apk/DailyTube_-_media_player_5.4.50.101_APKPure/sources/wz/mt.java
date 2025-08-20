package wz;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.SeekBar;
import androidx.annotation.Nullable;
import androidx.appcompat.R$styleable;
/* loaded from: classes.dex */
public class mt extends wz {

    /* renamed from: a  reason: collision with root package name */
    public ColorStateList f14729a;

    /* renamed from: c5  reason: collision with root package name */
    public boolean f14730c5;

    /* renamed from: fb  reason: collision with root package name */
    public PorterDuff.Mode f14731fb;

    /* renamed from: gv  reason: collision with root package name */
    public final SeekBar f14732gv;

    /* renamed from: s  reason: collision with root package name */
    public boolean f14733s;

    /* renamed from: v  reason: collision with root package name */
    public Drawable f14734v;

    public mt(SeekBar seekBar) {
        super(seekBar);
        this.f14732gv = seekBar;
    }

    public final void a() {
        Drawable drawable = this.f14734v;
        if (drawable != null) {
            if (this.f14733s || this.f14730c5) {
                Drawable mt2 = ej.y.mt(drawable.mutate());
                this.f14734v = mt2;
                if (this.f14733s) {
                    ej.y.xc(mt2, this.f14729a);
                }
                if (this.f14730c5) {
                    ej.y.w(this.f14734v, this.f14731fb);
                }
                if (this.f14734v.isStateful()) {
                    this.f14734v.setState(this.f14732gv.getDrawableState());
                }
            }
        }
    }

    public void c5() {
        Drawable drawable = this.f14734v;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    public void fb(Canvas canvas) {
        int i;
        if (this.f14734v != null) {
            int max = this.f14732gv.getMax();
            int i5 = 1;
            if (max > 1) {
                int intrinsicWidth = this.f14734v.getIntrinsicWidth();
                int intrinsicHeight = this.f14734v.getIntrinsicHeight();
                if (intrinsicWidth >= 0) {
                    i = intrinsicWidth / 2;
                } else {
                    i = 1;
                }
                if (intrinsicHeight >= 0) {
                    i5 = intrinsicHeight / 2;
                }
                this.f14734v.setBounds(-i, -i5, i, i5);
                float width = ((this.f14732gv.getWidth() - this.f14732gv.getPaddingLeft()) - this.f14732gv.getPaddingRight()) / max;
                int save = canvas.save();
                canvas.translate(this.f14732gv.getPaddingLeft(), this.f14732gv.getHeight() / 2);
                for (int i6 = 0; i6 <= max; i6++) {
                    this.f14734v.draw(canvas);
                    canvas.translate(width, 0.0f);
                }
                canvas.restoreToCount(save);
            }
        }
    }

    public void i9(@Nullable Drawable drawable) {
        Drawable drawable2 = this.f14734v;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.f14734v = drawable;
        if (drawable != null) {
            drawable.setCallback(this.f14732gv);
            ej.y.tl(drawable, hw.i4.ta(this.f14732gv));
            if (drawable.isStateful()) {
                drawable.setState(this.f14732gv.getDrawableState());
            }
            a();
        }
        this.f14732gv.invalidate();
    }

    public void s() {
        Drawable drawable = this.f14734v;
        if (drawable != null && drawable.isStateful() && drawable.setState(this.f14732gv.getDrawableState())) {
            this.f14732gv.invalidateDrawable(drawable);
        }
    }

    @Override // wz.wz
    public void zn(AttributeSet attributeSet, int i) {
        super.zn(attributeSet, i);
        Context context = this.f14732gv.getContext();
        int[] iArr = R$styleable.f906ut;
        hw x42 = hw.x4(context, attributeSet, iArr, i, 0);
        SeekBar seekBar = this.f14732gv;
        hw.i4.kp(seekBar, seekBar.getContext(), iArr, attributeSet, x42.mt(), i, 0);
        Drawable s2 = x42.s(R$styleable.f885q9);
        if (s2 != null) {
            this.f14732gv.setThumb(s2);
        }
        i9(x42.fb(R$styleable.f855k));
        int i5 = R$styleable.f833en;
        if (x42.co(i5)) {
            this.f14731fb = n.v(x42.f(i5, -1), this.f14731fb);
            this.f14730c5 = true;
        }
        int i6 = R$styleable.f836f7;
        if (x42.co(i6)) {
            this.f14729a = x42.zn(i6);
            this.f14733s = true;
        }
        x42.i4();
        a();
    }
}
