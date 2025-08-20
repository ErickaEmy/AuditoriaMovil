package qg;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.google.android.material.R$styleable;
import hw.i4;
/* loaded from: classes.dex */
public final class y {

    /* renamed from: a  reason: collision with root package name */
    public final hx.f f12828a;

    /* renamed from: gv  reason: collision with root package name */
    public final ColorStateList f12829gv;

    /* renamed from: n3  reason: collision with root package name */
    public final ColorStateList f12830n3;

    /* renamed from: v  reason: collision with root package name */
    public final int f12831v;
    @NonNull
    public final Rect y;

    /* renamed from: zn  reason: collision with root package name */
    public final ColorStateList f12832zn;

    public y(ColorStateList colorStateList, ColorStateList colorStateList2, ColorStateList colorStateList3, int i, hx.f fVar, @NonNull Rect rect) {
        vl.s.gv(rect.left);
        vl.s.gv(rect.top);
        vl.s.gv(rect.right);
        vl.s.gv(rect.bottom);
        this.y = rect;
        this.f12830n3 = colorStateList2;
        this.f12832zn = colorStateList;
        this.f12829gv = colorStateList3;
        this.f12831v = i;
        this.f12828a = fVar;
    }

    @NonNull
    public static y y(@NonNull Context context, int i) {
        boolean z2;
        if (i != 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        vl.s.n3(z2, "Cannot create a CalendarItemStyle with a styleResId of 0");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i, R$styleable.r3);
        Rect rect = new Rect(obtainStyledAttributes.getDimensionPixelOffset(R$styleable.st, 0), obtainStyledAttributes.getDimensionPixelOffset(R$styleable.g6, 0), obtainStyledAttributes.getDimensionPixelOffset(R$styleable.el, 0), obtainStyledAttributes.getDimensionPixelOffset(R$styleable.ky, 0));
        ColorStateList y = pv.zn.y(context, obtainStyledAttributes, R$styleable.yz);
        ColorStateList y2 = pv.zn.y(context, obtainStyledAttributes, R$styleable.pk);
        ColorStateList y7 = pv.zn.y(context, obtainStyledAttributes, R$styleable.xd);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R$styleable.r5, 0);
        hx.f tl2 = hx.f.n3(context, obtainStyledAttributes.getResourceId(R$styleable.oj, 0), obtainStyledAttributes.getResourceId(R$styleable.iv, 0)).tl();
        obtainStyledAttributes.recycle();
        return new y(y, y2, y7, dimensionPixelSize, tl2, rect);
    }

    public void gv(@NonNull TextView textView) {
        hx.fb fbVar = new hx.fb();
        hx.fb fbVar2 = new hx.fb();
        fbVar.setShapeAppearanceModel(this.f12828a);
        fbVar2.setShapeAppearanceModel(this.f12828a);
        fbVar.k(this.f12832zn);
        fbVar.xg(this.f12831v, this.f12829gv);
        textView.setTextColor(this.f12830n3);
        RippleDrawable rippleDrawable = new RippleDrawable(this.f12830n3.withAlpha(30), fbVar, fbVar2);
        Rect rect = this.y;
        i4.u0(textView, new InsetDrawable((Drawable) rippleDrawable, rect.left, rect.top, rect.right, rect.bottom));
    }

    public int n3() {
        return this.y.bottom;
    }

    public int zn() {
        return this.y.top;
    }
}
