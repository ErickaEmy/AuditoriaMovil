package com.google.android.material.chip;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.R$styleable;
import ej.a;
import hx.fb;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import nr.n3;
import pv.gv;
import pv.zn;
import ur.f;
import ur.i9;
import ur.s;
/* loaded from: classes.dex */
public class y extends fb implements a, Drawable.Callback, s.n3 {

    /* renamed from: ad  reason: collision with root package name */
    public final PointF f5565ad;

    /* renamed from: ap  reason: collision with root package name */
    public boolean f5566ap;

    /* renamed from: bk  reason: collision with root package name */
    public float f5567bk;

    /* renamed from: cr  reason: collision with root package name */
    public final Paint f5568cr;
    @Nullable

    /* renamed from: cs  reason: collision with root package name */
    public ColorStateList f5569cs;

    /* renamed from: ct  reason: collision with root package name */
    public float f5570ct;

    /* renamed from: cy  reason: collision with root package name */
    public final Path f5571cy;
    @Nullable

    /* renamed from: dm  reason: collision with root package name */
    public ColorStateList f5572dm;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    public CharSequence f5573e;
    @Nullable

    /* renamed from: eb  reason: collision with root package name */
    public Drawable f5574eb;

    /* renamed from: en  reason: collision with root package name */
    public float f5575en;
    @Nullable

    /* renamed from: f7  reason: collision with root package name */
    public ColorStateList f5576f7;

    /* renamed from: g  reason: collision with root package name */
    public float f5577g;

    /* renamed from: g3  reason: collision with root package name */
    public float f5578g3;

    /* renamed from: gq  reason: collision with root package name */
    public int f5579gq;
    @Nullable

    /* renamed from: i2  reason: collision with root package name */
    public ColorStateList f5580i2;
    @NonNull

    /* renamed from: i3  reason: collision with root package name */
    public WeakReference<InterfaceC0059y> f5581i3;

    /* renamed from: ix  reason: collision with root package name */
    public int[] f5582ix;

    /* renamed from: j3  reason: collision with root package name */
    public boolean f5583j3;
    @Nullable

    /* renamed from: jz  reason: collision with root package name */
    public ColorStateList f5584jz;

    /* renamed from: k  reason: collision with root package name */
    public float f5585k;
    @Nullable

    /* renamed from: kp  reason: collision with root package name */
    public y6.s f5586kp;

    /* renamed from: l  reason: collision with root package name */
    public int f5587l;
    @Nullable

    /* renamed from: lc  reason: collision with root package name */
    public Drawable f5588lc;
    @Nullable

    /* renamed from: le  reason: collision with root package name */
    public PorterDuffColorFilter f5589le;

    /* renamed from: m  reason: collision with root package name */
    public float f5590m;
    @Nullable

    /* renamed from: mp  reason: collision with root package name */
    public ColorFilter f5591mp;

    /* renamed from: ne  reason: collision with root package name */
    public int f5592ne;
    @Nullable

    /* renamed from: nf  reason: collision with root package name */
    public ColorStateList f5593nf;
    @Nullable

    /* renamed from: o0  reason: collision with root package name */
    public final Paint f5594o0;

    /* renamed from: o4  reason: collision with root package name */
    public boolean f5595o4;

    /* renamed from: oa  reason: collision with root package name */
    public int f5596oa;
    @Nullable

    /* renamed from: oz  reason: collision with root package name */
    public ColorStateList f5597oz;
    @NonNull

    /* renamed from: pq  reason: collision with root package name */
    public final Context f5598pq;

    /* renamed from: pz  reason: collision with root package name */
    public float f5599pz;

    /* renamed from: q  reason: collision with root package name */
    public boolean f5600q;

    /* renamed from: q5  reason: collision with root package name */
    public int f5601q5;

    /* renamed from: q9  reason: collision with root package name */
    public float f5602q9;

    /* renamed from: qj  reason: collision with root package name */
    public int f5603qj;
    @NonNull

    /* renamed from: qk  reason: collision with root package name */
    public final s f5604qk;

    /* renamed from: ra  reason: collision with root package name */
    public float f5605ra;
    @Nullable

    /* renamed from: rb  reason: collision with root package name */
    public y6.s f5606rb;
    @Nullable

    /* renamed from: ro  reason: collision with root package name */
    public PorterDuff.Mode f5607ro;

    /* renamed from: rs  reason: collision with root package name */
    public boolean f5608rs;

    /* renamed from: s8  reason: collision with root package name */
    public boolean f5609s8;

    /* renamed from: tg  reason: collision with root package name */
    public float f5610tg;
    @Nullable

    /* renamed from: u  reason: collision with root package name */
    public CharSequence f5611u;

    /* renamed from: u0  reason: collision with root package name */
    public float f5612u0;
    @Nullable

    /* renamed from: ut  reason: collision with root package name */
    public ColorStateList f5613ut;

    /* renamed from: vn  reason: collision with root package name */
    public TextUtils.TruncateAt f5614vn;

    /* renamed from: vp  reason: collision with root package name */
    public int f5615vp;

    /* renamed from: w2  reason: collision with root package name */
    public boolean f5616w2;

    /* renamed from: w9  reason: collision with root package name */
    public int f5617w9;

    /* renamed from: wf  reason: collision with root package name */
    public final RectF f5618wf;

    /* renamed from: x5  reason: collision with root package name */
    public int f5619x5;

    /* renamed from: xb  reason: collision with root package name */
    public final Paint.FontMetrics f5620xb;
    @Nullable

    /* renamed from: xg  reason: collision with root package name */
    public Drawable f5621xg;

    /* renamed from: y4  reason: collision with root package name */
    public float f5622y4;

    /* renamed from: y5  reason: collision with root package name */
    public boolean f5623y5;
    @Nullable

    /* renamed from: yc  reason: collision with root package name */
    public ColorStateList f5624yc;
    @Nullable

    /* renamed from: yg  reason: collision with root package name */
    public Drawable f5625yg;

    /* renamed from: yk  reason: collision with root package name */
    public boolean f5626yk;

    /* renamed from: wm  reason: collision with root package name */
    public static final int[] f5564wm = {16842910};

    /* renamed from: nd  reason: collision with root package name */
    public static final ShapeDrawable f5563nd = new ShapeDrawable(new OvalShape());

    /* renamed from: com.google.android.material.chip.y$y  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0059y {
        void y();
    }

    public y(@NonNull Context context, AttributeSet attributeSet, int i, int i5) {
        super(context, attributeSet, i, i5);
        this.f5585k = -1.0f;
        this.f5568cr = new Paint(1);
        this.f5620xb = new Paint.FontMetrics();
        this.f5618wf = new RectF();
        this.f5565ad = new PointF();
        this.f5571cy = new Path();
        this.f5601q5 = 255;
        this.f5607ro = PorterDuff.Mode.SRC_IN;
        this.f5581i3 = new WeakReference<>(null);
        k5(context);
        this.f5598pq = context;
        s sVar = new s(this);
        this.f5604qk = sVar;
        this.f5611u = "";
        sVar.v().density = context.getResources().getDisplayMetrics().density;
        this.f5594o0 = null;
        int[] iArr = f5564wm;
        setState(iArr);
        yh(iArr);
        this.f5583j3 = true;
        if (n3.y) {
            f5563nd.setTint(-1);
        }
    }

    public static boolean ia(@Nullable ColorStateList colorStateList) {
        if (colorStateList != null && colorStateList.isStateful()) {
            return true;
        }
        return false;
    }

    public static boolean jr(@Nullable gv gvVar) {
        ColorStateList colorStateList;
        if (gvVar != null && (colorStateList = gvVar.y) != null && colorStateList.isStateful()) {
            return true;
        }
        return false;
    }

    @NonNull
    public static y m(@NonNull Context context, @Nullable AttributeSet attributeSet, int i, int i5) {
        y yVar = new y(context, attributeSet, i, i5);
        yVar.zq(attributeSet, i, i5);
        return yVar;
    }

    public static boolean mh(@Nullable int[] iArr, int i) {
        if (iArr == null) {
            return false;
        }
        for (int i5 : iArr) {
            if (i5 == i) {
                return true;
            }
        }
        return false;
    }

    public static boolean r6(@Nullable Drawable drawable) {
        if (drawable != null && drawable.isStateful()) {
            return true;
        }
        return false;
    }

    @Nullable
    public ColorStateList ad() {
        return this.f5613ut;
    }

    public final void ap(@NonNull Rect rect, @NonNull RectF rectF) {
        rectF.setEmpty();
        if (t6()) {
            float f4 = this.f5599pz + this.f5610tg + this.f5605ra + this.f5622y4 + this.f5567bk;
            if (ej.y.a(this) == 0) {
                float f6 = rect.right;
                rectF.right = f6;
                rectF.left = f6 - f4;
            } else {
                int i = rect.left;
                rectF.left = i;
                rectF.right = i + f4;
            }
            rectF.top = rect.top;
            rectF.bottom = rect.bottom;
        }
    }

    public final void bk(@NonNull Canvas canvas, @NonNull Rect rect) {
        if (y0()) {
            nf(rect, this.f5618wf);
            RectF rectF = this.f5618wf;
            float f4 = rectF.left;
            float f6 = rectF.top;
            canvas.translate(f4, f6);
            this.f5621xg.setBounds(0, 0, (int) this.f5618wf.width(), (int) this.f5618wf.height());
            this.f5621xg.draw(canvas);
            canvas.translate(-f4, -f6);
        }
    }

    public float br() {
        return this.f5612u0;
    }

    @Nullable
    public gv bv() {
        return this.f5604qk.gv();
    }

    public void bx(float f4) {
        if (this.f5612u0 != f4) {
            this.f5612u0 = f4;
            invalidateSelf();
            hk();
        }
    }

    public boolean c8() {
        return r6(this.f5574eb);
    }

    public void cp(boolean z2) {
        if (this.f5626yk != z2) {
            this.f5626yk = z2;
            m5();
            onStateChange(getState());
        }
    }

    public final void cr(@NonNull Canvas canvas, @NonNull Rect rect) {
        Paint paint = this.f5594o0;
        if (paint != null) {
            paint.setColor(z6.y.a(-16777216, 127));
            canvas.drawRect(rect, this.f5594o0);
            if (y0() || ng()) {
                nf(rect, this.f5618wf);
                canvas.drawRect(this.f5618wf, this.f5594o0);
            }
            if (this.f5611u != null) {
                canvas.drawLine(rect.left, rect.exactCenterY(), rect.right, rect.exactCenterY(), this.f5594o0);
            }
            if (t6()) {
                s8(rect, this.f5618wf);
                canvas.drawRect(this.f5618wf, this.f5594o0);
            }
            this.f5594o0.setColor(z6.y.a(-65536, 127));
            e(rect, this.f5618wf);
            canvas.drawRect(this.f5618wf, this.f5594o0);
            this.f5594o0.setColor(z6.y.a(-16711936, 127));
            ap(rect, this.f5618wf);
            canvas.drawRect(this.f5618wf, this.f5594o0);
        }
    }

    public float cs() {
        return this.f5622y4;
    }

    public void cw(int i) {
        iu(y6.s.zn(this.f5598pq, i));
    }

    public void cx(@Nullable ColorStateList colorStateList) {
        if (this.f5613ut != colorStateList) {
            this.f5613ut = colorStateList;
            onStateChange(getState());
        }
    }

    public float cy() {
        if (this.f5600q) {
            return d();
        }
        return this.f5585k;
    }

    public void dp(int i) {
        hr(this.f5598pq.getResources().getBoolean(i));
    }

    @Override // hx.fb, android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        int i;
        Rect bounds = getBounds();
        if (!bounds.isEmpty() && getAlpha() != 0) {
            int i5 = this.f5601q5;
            if (i5 < 255) {
                i = tn.y.y(canvas, bounds.left, bounds.top, bounds.right, bounds.bottom, i5);
            } else {
                i = 0;
            }
            tg(canvas, bounds);
            u0(canvas, bounds);
            if (this.f5600q) {
                super.draw(canvas);
            }
            y4(canvas, bounds);
            pq(canvas, bounds);
            bk(canvas, bounds);
            g(canvas, bounds);
            if (this.f5583j3) {
                o0(canvas, bounds);
            }
            pz(canvas, bounds);
            cr(canvas, bounds);
            if (this.f5601q5 < 255) {
                canvas.restoreToCount(i);
            }
        }
    }

    public final void e(@NonNull Rect rect, @NonNull RectF rectF) {
        rectF.set(rect);
        if (t6()) {
            float f4 = this.f5599pz + this.f5610tg + this.f5605ra + this.f5622y4 + this.f5567bk;
            if (ej.y.a(this) == 0) {
                rectF.right = rect.right - f4;
            } else {
                rectF.left = rect.left + f4;
            }
        }
    }

    public void e5(int i) {
        l3(this.f5598pq.getResources().getDimension(i));
    }

    public void eu(boolean z2) {
        if (this.f5608rs != z2) {
            boolean t6 = t6();
            this.f5608rs = z2;
            boolean t62 = t6();
            if (t6 != t62) {
                if (t62) {
                    lc(this.f5574eb);
                } else {
                    t3(this.f5574eb);
                }
                invalidateSelf();
                hk();
            }
        }
    }

    public void ez(int i) {
        mc(this.f5598pq.getResources().getDimension(i));
    }

    public float fc() {
        return this.f5567bk;
    }

    public void fp(@Nullable Drawable drawable) {
        Drawable drawable2;
        Drawable x52 = x5();
        if (x52 != drawable) {
            float yg2 = yg();
            if (drawable != null) {
                drawable2 = ej.y.mt(drawable).mutate();
            } else {
                drawable2 = null;
            }
            this.f5574eb = drawable2;
            if (n3.y) {
                op();
            }
            float yg3 = yg();
            t3(x52);
            if (t6()) {
                lc(this.f5574eb);
            }
            invalidateSelf();
            if (yg2 != yg3) {
                hk();
            }
        }
    }

    public void fq(float f4) {
        if (this.f5578g3 != f4) {
            this.f5578g3 = f4;
            invalidateSelf();
            hk();
        }
    }

    public final void g(@NonNull Canvas canvas, @NonNull Rect rect) {
        if (ng()) {
            nf(rect, this.f5618wf);
            RectF rectF = this.f5618wf;
            float f4 = rectF.left;
            float f6 = rectF.top;
            canvas.translate(f4, f6);
            this.f5625yg.setBounds(0, 0, (int) this.f5618wf.width(), (int) this.f5618wf.height());
            this.f5625yg.draw(canvas);
            canvas.translate(-f4, -f6);
        }
    }

    public final boolean g3() {
        if (this.f5566ap && this.f5625yg != null && this.f5609s8) {
            return true;
        }
        return false;
    }

    public boolean gd() {
        return this.f5583j3;
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f5601q5;
    }

    @Override // android.graphics.drawable.Drawable
    @Nullable
    public ColorFilter getColorFilter() {
        return this.f5591mp;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return (int) this.f5602q9;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return Math.min(Math.round(this.f5578g3 + ra() + this.f5612u0 + this.f5604qk.a(gf().toString()) + this.f5567bk + yg() + this.f5599pz), this.f5592ne);
    }

    @Override // hx.fb, android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // hx.fb, android.graphics.drawable.Drawable
    @TargetApi(21)
    public void getOutline(@NonNull Outline outline) {
        if (this.f5600q) {
            super.getOutline(outline);
            return;
        }
        Rect bounds = getBounds();
        if (!bounds.isEmpty()) {
            outline.setRoundRect(bounds, this.f5585k);
        } else {
            outline.setRoundRect(0, 0, getIntrinsicWidth(), getIntrinsicHeight(), this.f5585k);
        }
        outline.setAlpha(getAlpha() / 255.0f);
    }

    @Nullable
    public CharSequence gf() {
        return this.f5611u;
    }

    public void gi(float f4) {
        if (this.f5570ct != f4) {
            float ra2 = ra();
            this.f5570ct = f4;
            float ra3 = ra();
            invalidateSelf();
            if (ra2 != ra3) {
                hk();
            }
        }
    }

    public void gn(int i) {
        ic(this.f5598pq.getResources().getBoolean(i));
    }

    @Nullable
    public ColorStateList gq() {
        return this.f5572dm;
    }

    public boolean h() {
        return this.f5608rs;
    }

    public void hb(boolean z2) {
        if (this.f5623y5 != z2) {
            boolean y0 = y0();
            this.f5623y5 = z2;
            boolean y02 = y0();
            if (y0 != y02) {
                if (y02) {
                    lc(this.f5621xg);
                } else {
                    t3(this.f5621xg);
                }
                invalidateSelf();
                hk();
            }
        }
    }

    public void hf(int i) {
        sh(this.f5598pq.getResources().getDimension(i));
    }

    public void hj(@Nullable CharSequence charSequence) {
        if (this.f5573e != charSequence) {
            this.f5573e = yt.y.zn().s(charSequence);
            invalidateSelf();
        }
    }

    public void hk() {
        InterfaceC0059y interfaceC0059y = this.f5581i3.get();
        if (interfaceC0059y != null) {
            interfaceC0059y.y();
        }
    }

    public void hr(boolean z2) {
        if (this.f5566ap != z2) {
            boolean ng = ng();
            this.f5566ap = z2;
            boolean ng2 = ng();
            if (ng != ng2) {
                if (ng2) {
                    lc(this.f5625yg);
                } else {
                    t3(this.f5625yg);
                }
                invalidateSelf();
                hk();
            }
        }
    }

    @Deprecated
    public void hy(float f4) {
        if (this.f5585k != f4) {
            this.f5585k = f4;
            setShapeAppearanceModel(rz().i4(f4));
        }
    }

    public void i(@Nullable ColorStateList colorStateList) {
        if (this.f5624yc != colorStateList) {
            this.f5624yc = colorStateList;
            if (g3()) {
                ej.y.xc(this.f5625yg, colorStateList);
            }
            onStateChange(getState());
        }
    }

    public void i1(int i) {
        nh(c5.y.zn(this.f5598pq, i));
    }

    public final float i2() {
        Drawable drawable;
        if (this.f5616w2) {
            drawable = this.f5625yg;
        } else {
            drawable = this.f5621xg;
        }
        float f4 = this.f5570ct;
        if (f4 <= 0.0f && drawable != null) {
            f4 = (float) Math.ceil(f.n3(this.f5598pq, 24));
            if (drawable.getIntrinsicHeight() <= f4) {
                return drawable.getIntrinsicHeight();
            }
        }
        return f4;
    }

    public final float i3() {
        Drawable drawable;
        if (this.f5616w2) {
            drawable = this.f5625yg;
        } else {
            drawable = this.f5621xg;
        }
        float f4 = this.f5570ct;
        if (f4 <= 0.0f && drawable != null) {
            return drawable.getIntrinsicWidth();
        }
        return f4;
    }

    public void ic(boolean z2) {
        if (this.f5609s8 != z2) {
            this.f5609s8 = z2;
            float ra2 = ra();
            if (!z2 && this.f5616w2) {
                this.f5616w2 = false;
            }
            float ra3 = ra();
            invalidateSelf();
            if (ra2 != ra3) {
                hk();
            }
        }
    }

    public void ih(@Nullable y6.s sVar) {
        this.f5606rb = sVar;
    }

    public boolean im() {
        return this.f5626yk;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(@NonNull Drawable drawable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    @Override // hx.fb, android.graphics.drawable.Drawable
    public boolean isStateful() {
        if (!ia(this.f5597oz) && !ia(this.f5613ut) && !ia(this.f5576f7) && ((!this.f5626yk || !ia(this.f5580i2)) && !jr(this.f5604qk.gv()) && !g3() && !r6(this.f5621xg) && !r6(this.f5625yg) && !ia(this.f5569cs))) {
            return false;
        }
        return true;
    }

    public void iu(@Nullable y6.s sVar) {
        this.f5586kp = sVar;
    }

    @Nullable
    public ColorStateList ix() {
        return this.f5593nf;
    }

    @Nullable
    public y6.s j3() {
        return this.f5606rb;
    }

    public void j4(@Nullable ColorStateList colorStateList) {
        if (this.f5584jz != colorStateList) {
            this.f5584jz = colorStateList;
            m5();
            onStateChange(getState());
        }
    }

    public void ja(int i) {
        bx(this.f5598pq.getResources().getDimension(i));
    }

    public void jb(int i) {
        jt(this.f5598pq.getResources().getDimension(i));
    }

    public void jm(int i) {
        ih(y6.s.zn(this.f5598pq, i));
    }

    public void jt(float f4) {
        if (this.f5599pz != f4) {
            this.f5599pz = f4;
            invalidateSelf();
            hk();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:71:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0152  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean k3(@androidx.annotation.NonNull int[] r7, @androidx.annotation.NonNull int[] r8) {
        /*
            Method dump skipped, instructions count: 342
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.chip.y.k3(int[], int[]):boolean");
    }

    public final float kp() {
        this.f5604qk.v().getFontMetrics(this.f5620xb);
        Paint.FontMetrics fontMetrics = this.f5620xb;
        return (fontMetrics.descent + fontMetrics.ascent) / 2.0f;
    }

    public final void ks(@Nullable ColorStateList colorStateList) {
        if (this.f5597oz != colorStateList) {
            this.f5597oz = colorStateList;
            onStateChange(getState());
        }
    }

    public float l() {
        return this.f5570ct;
    }

    public void l0(@Nullable ColorStateList colorStateList) {
        this.f5595o4 = true;
        if (this.f5572dm != colorStateList) {
            this.f5572dm = colorStateList;
            if (y0()) {
                ej.y.xc(this.f5621xg, colorStateList);
            }
            onStateChange(getState());
        }
    }

    public void l3(float f4) {
        if (this.f5622y4 != f4) {
            this.f5622y4 = f4;
            invalidateSelf();
            if (t6()) {
                hk();
            }
        }
    }

    public void l8(@Nullable gv gvVar) {
        this.f5604qk.s(gvVar, this.f5598pq);
    }

    public final void lc(@Nullable Drawable drawable) {
        if (drawable == null) {
            return;
        }
        drawable.setCallback(this);
        ej.y.tl(drawable, ej.y.a(this));
        drawable.setLevel(getLevel());
        drawable.setVisible(isVisible(), false);
        if (drawable == this.f5574eb) {
            if (drawable.isStateful()) {
                drawable.setState(ro());
            }
            ej.y.xc(drawable, this.f5593nf);
            return;
        }
        if (drawable.isStateful()) {
            drawable.setState(getState());
        }
        Drawable drawable2 = this.f5621xg;
        if (drawable == drawable2 && this.f5595o4) {
            ej.y.xc(drawable2, this.f5572dm);
        }
    }

    public float le() {
        return this.f5605ra;
    }

    public final void m5() {
        ColorStateList colorStateList;
        if (this.f5626yk) {
            colorStateList = n3.gv(this.f5584jz);
        } else {
            colorStateList = null;
        }
        this.f5580i2 = colorStateList;
    }

    public void mc(float f4) {
        if (this.f5590m != f4) {
            float ra2 = ra();
            this.f5590m = f4;
            float ra3 = ra();
            invalidateSelf();
            if (ra2 != ra3) {
                hk();
            }
        }
    }

    public float mp() {
        return this.f5610tg;
    }

    public void mq(float f4) {
        if (this.f5577g != f4) {
            float ra2 = ra();
            this.f5577g = f4;
            float ra3 = ra();
            invalidateSelf();
            if (ra2 != ra3) {
                hk();
            }
        }
    }

    public boolean n7() {
        return this.f5609s8;
    }

    @Nullable
    public y6.s nd() {
        return this.f5586kp;
    }

    public float ne() {
        return this.f5577g;
    }

    public final void nf(@NonNull Rect rect, @NonNull RectF rectF) {
        rectF.setEmpty();
        if (y0() || ng()) {
            float f4 = this.f5578g3 + this.f5590m;
            float i32 = i3();
            if (ej.y.a(this) == 0) {
                float f6 = rect.left + f4;
                rectF.left = f6;
                rectF.right = f6 + i32;
            } else {
                float f9 = rect.right - f4;
                rectF.right = f9;
                rectF.left = f9 - i32;
            }
            float i22 = i2();
            float exactCenterY = rect.exactCenterY() - (i22 / 2.0f);
            rectF.top = exactCenterY;
            rectF.bottom = exactCenterY + i22;
        }
    }

    public final boolean ng() {
        if (this.f5566ap && this.f5625yg != null && this.f5616w2) {
            return true;
        }
        return false;
    }

    public void nh(@Nullable ColorStateList colorStateList) {
        if (this.f5593nf != colorStateList) {
            this.f5593nf = colorStateList;
            if (t6()) {
                ej.y.xc(this.f5574eb, colorStateList);
            }
            onStateChange(getState());
        }
    }

    public void nz(@Nullable CharSequence charSequence) {
        if (charSequence == null) {
            charSequence = "";
        }
        if (!TextUtils.equals(this.f5611u, charSequence)) {
            this.f5611u = charSequence;
            this.f5604qk.c5(true);
            invalidateSelf();
            hk();
        }
    }

    public final void o0(@NonNull Canvas canvas, @NonNull Rect rect) {
        boolean z2;
        if (this.f5611u != null) {
            Paint.Align rb2 = rb(rect, this.f5565ad);
            yc(rect, this.f5618wf);
            if (this.f5604qk.gv() != null) {
                this.f5604qk.v().drawableState = getState();
                this.f5604qk.i9(this.f5598pq);
            }
            this.f5604qk.v().setTextAlign(rb2);
            int i = 0;
            if (Math.round(this.f5604qk.a(gf().toString())) > Math.round(this.f5618wf.width())) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                i = canvas.save();
                canvas.clipRect(this.f5618wf);
            }
            CharSequence charSequence = this.f5611u;
            if (z2 && this.f5614vn != null) {
                charSequence = TextUtils.ellipsize(charSequence, this.f5604qk.v(), this.f5618wf.width(), this.f5614vn);
            }
            CharSequence charSequence2 = charSequence;
            int length = charSequence2.length();
            PointF pointF = this.f5565ad;
            canvas.drawText(charSequence2, 0, length, pointF.x, pointF.y, this.f5604qk.v());
            if (z2) {
                canvas.restoreToCount(i);
            }
        }
    }

    public float oa() {
        return this.f5578g3;
    }

    public void ob(float f4) {
        if (this.f5602q9 != f4) {
            this.f5602q9 = f4;
            invalidateSelf();
            hk();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLayoutDirectionChanged(int i) {
        boolean onLayoutDirectionChanged = super.onLayoutDirectionChanged(i);
        if (y0()) {
            onLayoutDirectionChanged |= ej.y.tl(this.f5621xg, i);
        }
        if (ng()) {
            onLayoutDirectionChanged |= ej.y.tl(this.f5625yg, i);
        }
        if (t6()) {
            onLayoutDirectionChanged |= ej.y.tl(this.f5574eb, i);
        }
        if (onLayoutDirectionChanged) {
            invalidateSelf();
            return true;
        }
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLevelChange(int i) {
        boolean onLevelChange = super.onLevelChange(i);
        if (y0()) {
            onLevelChange |= this.f5621xg.setLevel(i);
        }
        if (ng()) {
            onLevelChange |= this.f5625yg.setLevel(i);
        }
        if (t6()) {
            onLevelChange |= this.f5574eb.setLevel(i);
        }
        if (onLevelChange) {
            invalidateSelf();
        }
        return onLevelChange;
    }

    @Override // hx.fb, android.graphics.drawable.Drawable, ur.s.n3
    public boolean onStateChange(@NonNull int[] iArr) {
        if (this.f5600q) {
            super.onStateChange(iArr);
        }
        return k3(iArr, ro());
    }

    @TargetApi(21)
    public final void op() {
        this.f5588lc = new RippleDrawable(n3.gv(wm()), this.f5574eb, f5563nd);
    }

    public void ou(float f4) {
        if (this.f5605ra != f4) {
            this.f5605ra = f4;
            invalidateSelf();
            if (t6()) {
                hk();
            }
        }
    }

    public void p1(int i) {
        vc(c5.y.gv(this.f5598pq, i));
    }

    public void p2(boolean z2) {
        this.f5583j3 = z2;
    }

    public final void pq(@NonNull Canvas canvas, @NonNull Rect rect) {
        this.f5568cr.setColor(this.f5596oa);
        this.f5568cr.setStyle(Paint.Style.FILL);
        this.f5618wf.set(rect);
        if (!this.f5600q) {
            canvas.drawRoundRect(this.f5618wf, cy(), cy(), this.f5568cr);
            return;
        }
        s(new RectF(rect), this.f5571cy);
        super.w(canvas, this.f5568cr, this.f5571cy, r());
    }

    public final void pz(@NonNull Canvas canvas, @NonNull Rect rect) {
        if (t6()) {
            s8(rect, this.f5618wf);
            RectF rectF = this.f5618wf;
            float f4 = rectF.left;
            float f6 = rectF.top;
            canvas.translate(f4, f6);
            this.f5574eb.setBounds(0, 0, (int) this.f5618wf.width(), (int) this.f5618wf.height());
            if (n3.y) {
                this.f5588lc.setBounds(this.f5574eb.getBounds());
                this.f5588lc.jumpToCurrentState();
                this.f5588lc.draw(canvas);
            } else {
                this.f5574eb.draw(canvas);
            }
            canvas.translate(-f4, -f6);
        }
    }

    public float q() {
        return this.f5590m;
    }

    @Nullable
    public CharSequence q5() {
        return this.f5573e;
    }

    @Nullable
    public Drawable qj() {
        Drawable drawable = this.f5621xg;
        if (drawable != null) {
            return ej.y.p(drawable);
        }
        return null;
    }

    public float qk() {
        return this.f5599pz;
    }

    public float ra() {
        if (!y0() && !ng()) {
            return 0.0f;
        }
        return this.f5590m + i3() + this.f5577g;
    }

    @NonNull
    public Paint.Align rb(@NonNull Rect rect, @NonNull PointF pointF) {
        pointF.set(0.0f, 0.0f);
        Paint.Align align = Paint.Align.LEFT;
        if (this.f5611u != null) {
            float ra2 = this.f5578g3 + ra() + this.f5612u0;
            if (ej.y.a(this) == 0) {
                pointF.x = rect.left + ra2;
            } else {
                pointF.x = rect.right - ra2;
                align = Paint.Align.RIGHT;
            }
            pointF.y = rect.centerY() - kp();
        }
        return align;
    }

    public void rk(int i) {
        wv(this.f5598pq.getResources().getDimension(i));
    }

    @NonNull
    public int[] ro() {
        return this.f5582ix;
    }

    public void rt(int i) {
        t5(this.f5598pq.getResources().getDimension(i));
    }

    public void rv(int i) {
        i(c5.y.zn(this.f5598pq, i));
    }

    public final void s8(@NonNull Rect rect, @NonNull RectF rectF) {
        rectF.setEmpty();
        if (t6()) {
            float f4 = this.f5599pz + this.f5610tg;
            if (ej.y.a(this) == 0) {
                float f6 = rect.right - f4;
                rectF.right = f6;
                rectF.left = f6 - this.f5605ra;
            } else {
                float f9 = rect.left + f4;
                rectF.left = f9;
                rectF.right = f9 + this.f5605ra;
            }
            float exactCenterY = rect.exactCenterY();
            float f10 = this.f5605ra;
            float f11 = exactCenterY - (f10 / 2.0f);
            rectF.top = f11;
            rectF.bottom = f11 + f10;
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable, long j2) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.scheduleDrawable(this, runnable, j2);
        }
    }

    @Override // hx.fb, android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        if (this.f5601q5 != i) {
            this.f5601q5 = i;
            invalidateSelf();
        }
    }

    @Override // hx.fb, android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        if (this.f5591mp != colorFilter) {
            this.f5591mp = colorFilter;
            invalidateSelf();
        }
    }

    @Override // hx.fb, android.graphics.drawable.Drawable
    public void setTintList(@Nullable ColorStateList colorStateList) {
        if (this.f5569cs != colorStateList) {
            this.f5569cs = colorStateList;
            onStateChange(getState());
        }
    }

    @Override // hx.fb, android.graphics.drawable.Drawable
    public void setTintMode(@NonNull PorterDuff.Mode mode) {
        if (this.f5607ro != mode) {
            this.f5607ro = mode;
            this.f5589le = bp.y.y(this, this.f5569cs, mode);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z2, boolean z3) {
        boolean visible = super.setVisible(z2, z3);
        if (y0()) {
            visible |= this.f5621xg.setVisible(z2, z3);
        }
        if (ng()) {
            visible |= this.f5625yg.setVisible(z2, z3);
        }
        if (t6()) {
            visible |= this.f5574eb.setVisible(z2, z3);
        }
        if (visible) {
            invalidateSelf();
        }
        return visible;
    }

    public void sh(float f4) {
        if (this.f5610tg != f4) {
            this.f5610tg = f4;
            invalidateSelf();
            if (t6()) {
                hk();
            }
        }
    }

    public void sw(@Nullable Drawable drawable) {
        Drawable drawable2;
        Drawable qj2 = qj();
        if (qj2 != drawable) {
            float ra2 = ra();
            if (drawable != null) {
                drawable2 = ej.y.mt(drawable).mutate();
            } else {
                drawable2 = null;
            }
            this.f5621xg = drawable2;
            float ra3 = ra();
            t3(qj2);
            if (y0()) {
                lc(this.f5621xg);
            }
            invalidateSelf();
            if (ra2 != ra3) {
                hk();
            }
        }
    }

    public void sx(int i) {
        fq(this.f5598pq.getResources().getDimension(i));
    }

    public final void t3(@Nullable Drawable drawable) {
        if (drawable != null) {
            drawable.setCallback(null);
        }
    }

    public void t5(float f4) {
        if (this.f5575en != f4) {
            this.f5575en = f4;
            this.f5568cr.setStrokeWidth(f4);
            if (this.f5600q) {
                super.ct(f4);
            }
            invalidateSelf();
        }
    }

    public final boolean t6() {
        if (this.f5608rs && this.f5574eb != null) {
            return true;
        }
        return false;
    }

    public void t7(int i) {
        j4(c5.y.zn(this.f5598pq, i));
    }

    public final void tg(@NonNull Canvas canvas, @NonNull Rect rect) {
        if (!this.f5600q) {
            this.f5568cr.setColor(this.f5603qj);
            this.f5568cr.setStyle(Paint.Style.FILL);
            this.f5618wf.set(rect);
            canvas.drawRoundRect(this.f5618wf, cy(), cy(), this.f5568cr);
        }
    }

    public final void u0(@NonNull Canvas canvas, @NonNull Rect rect) {
        if (!this.f5600q) {
            this.f5568cr.setColor(this.f5587l);
            this.f5568cr.setStyle(Paint.Style.FILL);
            this.f5568cr.setColorFilter(uo());
            this.f5618wf.set(rect);
            canvas.drawRoundRect(this.f5618wf, cy(), cy(), this.f5568cr);
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.unscheduleDrawable(this, runnable);
        }
    }

    @Nullable
    public final ColorFilter uo() {
        ColorFilter colorFilter = this.f5591mp;
        if (colorFilter == null) {
            return this.f5589le;
        }
        return colorFilter;
    }

    public void ux(@Nullable ColorStateList colorStateList) {
        if (this.f5576f7 != colorStateList) {
            this.f5576f7 = colorStateList;
            if (this.f5600q) {
                dm(colorStateList);
            }
            onStateChange(getState());
        }
    }

    public void v1(int i) {
        sw(c5.y.gv(this.f5598pq, i));
    }

    public void vb(int i) {
        ob(this.f5598pq.getResources().getDimension(i));
    }

    public void vc(@Nullable Drawable drawable) {
        if (this.f5625yg != drawable) {
            float ra2 = ra();
            this.f5625yg = drawable;
            float ra3 = ra();
            t3(this.f5625yg);
            lc(this.f5625yg);
            invalidateSelf();
            if (ra2 != ra3) {
                hk();
            }
        }
    }

    public void vd(int i) {
        ux(c5.y.zn(this.f5598pq, i));
    }

    public void vh(int i) {
        cx(c5.y.zn(this.f5598pq, i));
    }

    public void vi(int i) {
        ou(this.f5598pq.getResources().getDimension(i));
    }

    public TextUtils.TruncateAt vn() {
        return this.f5614vn;
    }

    public float vp() {
        return this.f5602q9;
    }

    public float w2() {
        return this.f5575en;
    }

    public void w7(int i) {
        fp(c5.y.gv(this.f5598pq, i));
    }

    @Nullable
    public ColorStateList w9() {
        return this.f5576f7;
    }

    public void wb(int i) {
        this.f5592ne = i;
    }

    @Nullable
    public ColorStateList wf() {
        return this.f5624yc;
    }

    @Nullable
    public ColorStateList wm() {
        return this.f5584jz;
    }

    public void wo(int i) {
        l0(c5.y.zn(this.f5598pq, i));
    }

    public void wv(float f4) {
        if (this.f5567bk != f4) {
            this.f5567bk = f4;
            invalidateSelf();
            hk();
        }
    }

    public void x0(int i) {
        mq(this.f5598pq.getResources().getDimension(i));
    }

    @Nullable
    public Drawable x5() {
        Drawable drawable = this.f5574eb;
        if (drawable != null) {
            return ej.y.p(drawable);
        }
        return null;
    }

    @Nullable
    public Drawable xb() {
        return this.f5625yg;
    }

    public void xh(int i) {
        l8(new gv(this.f5598pq, i));
    }

    @Deprecated
    public void xq(int i) {
        hy(this.f5598pq.getResources().getDimension(i));
    }

    public void xu(@Nullable InterfaceC0059y interfaceC0059y) {
        this.f5581i3 = new WeakReference<>(interfaceC0059y);
    }

    @Override // ur.s.n3
    public void y() {
        hk();
        invalidateSelf();
    }

    public final boolean y0() {
        if (this.f5623y5 && this.f5621xg != null) {
            return true;
        }
        return false;
    }

    public final void y4(@NonNull Canvas canvas, @NonNull Rect rect) {
        if (this.f5575en > 0.0f && !this.f5600q) {
            this.f5568cr.setColor(this.f5615vp);
            this.f5568cr.setStyle(Paint.Style.STROKE);
            if (!this.f5600q) {
                this.f5568cr.setColorFilter(uo());
            }
            RectF rectF = this.f5618wf;
            float f4 = this.f5575en;
            rectF.set(rect.left + (f4 / 2.0f), rect.top + (f4 / 2.0f), rect.right - (f4 / 2.0f), rect.bottom - (f4 / 2.0f));
            float f6 = this.f5585k - (this.f5575en / 2.0f);
            canvas.drawRoundRect(this.f5618wf, f6, f6, this.f5568cr);
        }
    }

    public final void yc(@NonNull Rect rect, @NonNull RectF rectF) {
        rectF.setEmpty();
        if (this.f5611u != null) {
            float ra2 = this.f5578g3 + ra() + this.f5612u0;
            float yg2 = this.f5599pz + yg() + this.f5567bk;
            if (ej.y.a(this) == 0) {
                rectF.left = rect.left + ra2;
                rectF.right = rect.right - yg2;
            } else {
                rectF.left = rect.left + yg2;
                rectF.right = rect.right - ra2;
            }
            rectF.top = rect.top;
            rectF.bottom = rect.bottom;
        }
    }

    public float yg() {
        if (t6()) {
            return this.f5622y4 + this.f5605ra + this.f5610tg;
        }
        return 0.0f;
    }

    public boolean yh(@NonNull int[] iArr) {
        if (!Arrays.equals(this.f5582ix, iArr)) {
            this.f5582ix = iArr;
            if (t6()) {
                return k3(getState(), iArr);
            }
            return false;
        }
        return false;
    }

    public void yk(@NonNull RectF rectF) {
        ap(getBounds(), rectF);
    }

    public void z8(@Nullable TextUtils.TruncateAt truncateAt) {
        this.f5614vn = truncateAt;
    }

    public void zh(int i) {
        hb(this.f5598pq.getResources().getBoolean(i));
    }

    public final void zq(@Nullable AttributeSet attributeSet, int i, int i5) {
        TypedArray s2 = i9.s(this.f5598pq, attributeSet, R$styleable.f5231nf, i, i5, new int[0]);
        this.f5600q = s2.hasValue(R$styleable.f5190ix);
        ks(zn.y(this.f5598pq, s2, R$styleable.f5258qj));
        cx(zn.y(this.f5598pq, s2, R$styleable.f5283u0));
        ob(s2.getDimension(R$styleable.f5310xb, 0.0f));
        int i6 = R$styleable.f5122bk;
        if (s2.hasValue(i6)) {
            hy(s2.getDimension(i6, 0.0f));
        }
        ux(zn.y(this.f5598pq, s2, R$styleable.f5136cy));
        t5(s2.getDimension(R$styleable.f5259qk, 0.0f));
        j4(zn.y(this.f5598pq, s2, R$styleable.f5266ro));
        nz(s2.getText(R$styleable.f5318yc));
        gv a2 = zn.a(this.f5598pq, s2, R$styleable.f5264ra);
        a2.f12651wz = s2.getDimension(R$styleable.f5148e, a2.f12651wz);
        l8(a2);
        int i8 = s2.getInt(R$styleable.f5119ap, 0);
        if (i8 != 1) {
            if (i8 != 2) {
                if (i8 == 3) {
                    z8(TextUtils.TruncateAt.END);
                }
            } else {
                z8(TextUtils.TruncateAt.MIDDLE);
            }
        } else {
            z8(TextUtils.TruncateAt.START);
        }
        hb(s2.getBoolean(R$styleable.f5236o0, false));
        if (attributeSet != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "chipIconEnabled") != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "chipIconVisible") == null) {
            hb(s2.getBoolean(R$styleable.f5251pz, false));
        }
        sw(zn.gv(this.f5598pq, s2, R$styleable.f5277tg));
        int i10 = R$styleable.f5133cr;
        if (s2.hasValue(i10)) {
            l0(zn.y(this.f5598pq, s2, i10));
        }
        gi(s2.getDimension(R$styleable.f5248pq, -1.0f));
        eu(s2.getBoolean(R$styleable.f5308x5, false));
        if (attributeSet != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "closeIconEnabled") != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "closeIconVisible") == null) {
            eu(s2.getBoolean(R$styleable.f5173gq, false));
        }
        fp(zn.gv(this.f5598pq, s2, R$styleable.f5206l));
        nh(zn.y(this.f5598pq, s2, R$styleable.f5298w2));
        ou(s2.getDimension(R$styleable.f5238oa, 0.0f));
        ic(s2.getBoolean(R$styleable.f5203kp, false));
        hr(s2.getBoolean(R$styleable.f5169g, false));
        if (attributeSet != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "checkedIconEnabled") != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "checkedIconVisible") == null) {
            hr(s2.getBoolean(R$styleable.f5171g3, false));
        }
        vc(zn.gv(this.f5598pq, s2, R$styleable.f5265rb));
        int i11 = R$styleable.f5214m;
        if (s2.hasValue(i11)) {
            i(zn.y(this.f5598pq, s2, i11));
        }
        iu(y6.s.n3(this.f5598pq, s2, R$styleable.f5320yk));
        ih(y6.s.n3(this.f5598pq, s2, R$styleable.f5221mp));
        fq(s2.getDimension(R$styleable.f5116ad, 0.0f));
        mc(s2.getDimension(R$styleable.f5134cs, 0.0f));
        mq(s2.getDimension(R$styleable.f5210le, 0.0f));
        bx(s2.getDimension(R$styleable.f5185i3, 0.0f));
        wv(s2.getDimension(R$styleable.f5184i2, 0.0f));
        l3(s2.getDimension(R$styleable.f5300w9, 0.0f));
        sh(s2.getDimension(R$styleable.f5295vp, 0.0f));
        jt(s2.getDimension(R$styleable.f5315y4, 0.0f));
        wb(s2.getDimensionPixelSize(R$styleable.f5319yg, Integer.MAX_VALUE));
        s2.recycle();
    }

    public void zx(int i) {
        gi(this.f5598pq.getResources().getDimension(i));
    }
}
