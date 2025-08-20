package ao;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.R$attr;
import com.google.android.material.R$styleable;
import com.google.android.material.button.MaterialButton;
import hw.i4;
import hx.f;
import hx.fb;
import hx.wz;
import nr.n3;
import pv.zn;
/* loaded from: classes.dex */
public class y {

    /* renamed from: z  reason: collision with root package name */
    public static final boolean f3795z = true;

    /* renamed from: a  reason: collision with root package name */
    public int f3796a;
    @Nullable

    /* renamed from: c5  reason: collision with root package name */
    public PorterDuff.Mode f3797c5;

    /* renamed from: co  reason: collision with root package name */
    public int f3798co;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public ColorStateList f3799f;

    /* renamed from: fb  reason: collision with root package name */
    public int f3800fb;

    /* renamed from: gv  reason: collision with root package name */
    public int f3801gv;
    @Nullable

    /* renamed from: i9  reason: collision with root package name */
    public ColorStateList f3802i9;

    /* renamed from: mt  reason: collision with root package name */
    public LayerDrawable f3803mt;
    @NonNull

    /* renamed from: n3  reason: collision with root package name */
    public f f3804n3;

    /* renamed from: p  reason: collision with root package name */
    public boolean f3805p;

    /* renamed from: s  reason: collision with root package name */
    public int f3806s;
    @Nullable

    /* renamed from: t  reason: collision with root package name */
    public ColorStateList f3807t;
    @Nullable

    /* renamed from: tl  reason: collision with root package name */
    public Drawable f3808tl;

    /* renamed from: v  reason: collision with root package name */
    public int f3809v;

    /* renamed from: w  reason: collision with root package name */
    public boolean f3810w;

    /* renamed from: wz  reason: collision with root package name */
    public boolean f3811wz;

    /* renamed from: xc  reason: collision with root package name */
    public boolean f3812xc;
    public final MaterialButton y;

    /* renamed from: zn  reason: collision with root package name */
    public int f3813zn;

    public y(MaterialButton materialButton, @NonNull f fVar) {
        this.y = materialButton;
        this.f3804n3 = fVar;
    }

    @Nullable
    public fb a() {
        return fb(false);
    }

    @NonNull
    public final InsetDrawable a8(Drawable drawable) {
        return new InsetDrawable(drawable, this.f3813zn, this.f3809v, this.f3801gv, this.f3796a);
    }

    public void c(boolean z2) {
        this.f3811wz = z2;
        ud();
    }

    @NonNull
    public f c5() {
        return this.f3804n3;
    }

    public void co() {
        this.f3812xc = true;
        this.y.setSupportBackgroundTintList(this.f3802i9);
        this.y.setSupportBackgroundTintMode(this.f3797c5);
    }

    public final void d() {
        this.y.setInternalBackground(y());
        fb a2 = a();
        if (a2 != null) {
            a2.q9(this.f3798co);
        }
    }

    public void d0(@Nullable ColorStateList colorStateList) {
        if (this.f3799f != colorStateList) {
            this.f3799f = colorStateList;
            ud();
        }
    }

    public void ej(int i, int i5) {
        Drawable drawable = this.f3808tl;
        if (drawable != null) {
            drawable.setBounds(this.f3813zn, this.f3809v, i5 - this.f3801gv, i - this.f3796a);
        }
    }

    public int f() {
        return this.f3806s;
    }

    public void f3(@Nullable ColorStateList colorStateList) {
        if (this.f3807t != colorStateList) {
            this.f3807t = colorStateList;
            boolean z2 = f3795z;
            if (z2 && (this.y.getBackground() instanceof RippleDrawable)) {
                ((RippleDrawable) this.y.getBackground()).setColor(n3.gv(colorStateList));
            } else if (!z2 && (this.y.getBackground() instanceof nr.y)) {
                ((nr.y) this.y.getBackground()).setTintList(n3.gv(colorStateList));
            }
        }
    }

    @Nullable
    public final fb fb(boolean z2) {
        LayerDrawable layerDrawable = this.f3803mt;
        if (layerDrawable != null && layerDrawable.getNumberOfLayers() > 0) {
            if (f3795z) {
                return (fb) ((LayerDrawable) ((InsetDrawable) this.f3803mt.getDrawable(0)).getDrawable()).getDrawable(!z2 ? 1 : 0);
            }
            return (fb) this.f3803mt.getDrawable(!z2 ? 1 : 0);
        }
        return null;
    }

    public void fh(int i) {
        if (this.f3806s != i) {
            this.f3806s = i;
            ud();
        }
    }

    public int gv() {
        return this.f3809v;
    }

    public void i4(int i) {
        ta(i, this.f3796a);
    }

    @Nullable
    public ColorStateList i9() {
        return this.f3799f;
    }

    public void mg(@Nullable PorterDuff.Mode mode) {
        if (this.f3797c5 != mode) {
            this.f3797c5 = mode;
            if (a() != null && this.f3797c5 != null) {
                ej.y.w(a(), this.f3797c5);
            }
        }
    }

    public void mt(int i) {
        if (a() != null) {
            a().setTint(i);
        }
    }

    public void n(@NonNull f fVar) {
        this.f3804n3 = fVar;
        z6(fVar);
    }

    public int n3() {
        return this.f3800fb;
    }

    public void p(@NonNull TypedArray typedArray) {
        this.f3813zn = typedArray.getDimensionPixelOffset(R$styleable.ez, 0);
        this.f3801gv = typedArray.getDimensionPixelOffset(R$styleable.wb, 0);
        this.f3809v = typedArray.getDimensionPixelOffset(R$styleable.j4, 0);
        this.f3796a = typedArray.getDimensionPixelOffset(R$styleable.t7, 0);
        int i = R$styleable.nz;
        if (typedArray.hasValue(i)) {
            int dimensionPixelSize = typedArray.getDimensionPixelSize(i, -1);
            this.f3800fb = dimensionPixelSize;
            n(this.f3804n3.i4(dimensionPixelSize));
            this.f3810w = true;
        }
        this.f3806s = typedArray.getDimensionPixelSize(R$styleable.y0, 0);
        this.f3797c5 = ur.f.v(typedArray.getInt(R$styleable.cw, -1), PorterDuff.Mode.SRC_IN);
        this.f3802i9 = zn.y(this.y.getContext(), typedArray, R$styleable.iu);
        this.f3799f = zn.y(this.y.getContext(), typedArray, R$styleable.ng);
        this.f3807t = zn.y(this.y.getContext(), typedArray, R$styleable.gd);
        this.f3805p = typedArray.getBoolean(R$styleable.p2, false);
        this.f3798co = typedArray.getDimensionPixelSize(R$styleable.f5207l8, 0);
        int a82 = i4.a8(this.y);
        int paddingTop = this.y.getPaddingTop();
        int ud2 = i4.ud(this.y);
        int paddingBottom = this.y.getPaddingBottom();
        if (typedArray.hasValue(R$styleable.f5217mc)) {
            co();
        } else {
            d();
        }
        i4.cy(this.y, a82 + this.f3813zn, paddingTop + this.f3809v, ud2 + this.f3801gv, paddingBottom + this.f3796a);
    }

    public void r(int i) {
        if (!this.f3810w || this.f3800fb != i) {
            this.f3800fb = i;
            this.f3810w = true;
            n(this.f3804n3.i4(i));
        }
    }

    public void rz(@Nullable ColorStateList colorStateList) {
        if (this.f3802i9 != colorStateList) {
            this.f3802i9 = colorStateList;
            if (a() != null) {
                ej.y.xc(a(), this.f3802i9);
            }
        }
    }

    @Nullable
    public ColorStateList s() {
        return this.f3807t;
    }

    public ColorStateList t() {
        return this.f3802i9;
    }

    public final void ta(int i, int i5) {
        int a82 = i4.a8(this.y);
        int paddingTop = this.y.getPaddingTop();
        int ud2 = i4.ud(this.y);
        int paddingBottom = this.y.getPaddingBottom();
        int i6 = this.f3809v;
        int i8 = this.f3796a;
        this.f3796a = i5;
        this.f3809v = i;
        if (!this.f3812xc) {
            d();
        }
        i4.cy(this.y, a82, (paddingTop + i) - i6, ud2, (paddingBottom + i5) - i8);
    }

    public PorterDuff.Mode tl() {
        return this.f3797c5;
    }

    public final void ud() {
        int i;
        fb a2 = a();
        fb wz2 = wz();
        if (a2 != null) {
            a2.xg(this.f3806s, this.f3799f);
            if (wz2 != null) {
                float f4 = this.f3806s;
                if (this.f3811wz) {
                    i = td.y.gv(this.y, R$attr.uh);
                } else {
                    i = 0;
                }
                wz2.y5(f4, i);
            }
        }
    }

    @Nullable
    public wz v() {
        LayerDrawable layerDrawable = this.f3803mt;
        if (layerDrawable != null && layerDrawable.getNumberOfLayers() > 1) {
            if (this.f3803mt.getNumberOfLayers() > 2) {
                return (wz) this.f3803mt.getDrawable(2);
            }
            return (wz) this.f3803mt.getDrawable(1);
        }
        return null;
    }

    public boolean w() {
        return this.f3805p;
    }

    @Nullable
    public final fb wz() {
        return fb(true);
    }

    public void x4(int i) {
        ta(this.f3809v, i);
    }

    public boolean xc() {
        return this.f3812xc;
    }

    public final Drawable y() {
        int i;
        fb fbVar = new fb(this.f3804n3);
        fbVar.k5(this.y.getContext());
        ej.y.xc(fbVar, this.f3802i9);
        PorterDuff.Mode mode = this.f3797c5;
        if (mode != null) {
            ej.y.w(fbVar, mode);
        }
        fbVar.xg(this.f3806s, this.f3799f);
        fb fbVar2 = new fb(this.f3804n3);
        fbVar2.setTint(0);
        float f4 = this.f3806s;
        if (this.f3811wz) {
            i = td.y.gv(this.y, R$attr.uh);
        } else {
            i = 0;
        }
        fbVar2.y5(f4, i);
        if (f3795z) {
            fb fbVar3 = new fb(this.f3804n3);
            this.f3808tl = fbVar3;
            ej.y.wz(fbVar3, -1);
            RippleDrawable rippleDrawable = new RippleDrawable(n3.gv(this.f3807t), a8(new LayerDrawable(new Drawable[]{fbVar2, fbVar})), this.f3808tl);
            this.f3803mt = rippleDrawable;
            return rippleDrawable;
        }
        nr.y yVar = new nr.y(this.f3804n3);
        this.f3808tl = yVar;
        ej.y.xc(yVar, n3.gv(this.f3807t));
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{fbVar2, fbVar, this.f3808tl});
        this.f3803mt = layerDrawable;
        return a8(layerDrawable);
    }

    public void z(boolean z2) {
        this.f3805p = z2;
    }

    public final void z6(@NonNull f fVar) {
        if (a() != null) {
            a().setShapeAppearanceModel(fVar);
        }
        if (wz() != null) {
            wz().setShapeAppearanceModel(fVar);
        }
        if (v() != null) {
            v().setShapeAppearanceModel(fVar);
        }
    }

    public int zn() {
        return this.f3796a;
    }
}
