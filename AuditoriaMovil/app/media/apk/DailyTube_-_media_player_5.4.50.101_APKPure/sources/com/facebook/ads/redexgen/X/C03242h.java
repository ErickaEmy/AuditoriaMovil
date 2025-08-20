package com.facebook.ads.redexgen.X;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
/* renamed from: com.facebook.ads.redexgen.X.2h  reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C03242h extends Drawable {
    public static String[] A0B = {"T9wgumyFZzBjgPRGtDdJxLvchQp6QtpG", "xAIRNqL7iCFb3fPQiKZF3NTrJvk1jHZM", "ZgdHDniCqFTu42359joO0C6Ag3Vf", "B7cBDxdThu3WyyPp08FnAoyqG101l2nd", "DdfMTEhfrXSGZiDoy5ozadnlnRXF", "hm2CCp2b2B9ckvgWvW8I2z4A1orNEdGj", "Fmv", "My1KyA5OUXEJybi78YH1RSZcU6CRiPjd"};
    public float A00;
    public float A01;
    public ColorStateList A02;
    public ColorStateList A03;
    public PorterDuffColorFilter A05;
    public final Rect A09;
    public final RectF A0A;
    public boolean A06 = false;
    public boolean A07 = true;
    public PorterDuff.Mode A04 = PorterDuff.Mode.SRC_IN;
    public final Paint A08 = new Paint(5);

    public C03242h(ColorStateList colorStateList, float f4) {
        this.A01 = f4;
        A01(colorStateList);
        this.A0A = new RectF();
        this.A09 = new Rect();
    }

    private PorterDuffColorFilter A00(ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    private void A01(ColorStateList colorStateList) {
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        this.A02 = colorStateList;
        this.A08.setColor(colorStateList.getColorForState(getState(), this.A02.getDefaultColor()));
    }

    private void A02(Rect rect) {
        if (rect == null) {
            rect = getBounds();
        }
        this.A0A.set(rect.left, rect.top, rect.right, rect.bottom);
        this.A09.set(rect);
        if (this.A06) {
            float A01 = C03262j.A01(this.A00, this.A01, this.A07);
            float vInset = C03262j.A00(this.A00, this.A01, this.A07);
            this.A09.inset((int) Math.ceil(vInset), (int) Math.ceil(A01));
            this.A0A.set(this.A09);
        }
    }

    public final float A03() {
        return this.A00;
    }

    public final float A04() {
        return this.A01;
    }

    public final ColorStateList A05() {
        return this.A02;
    }

    public final void A06(float f4) {
        if (f4 == this.A01) {
            return;
        }
        this.A01 = f4;
        A02(null);
        invalidateSelf();
    }

    public final void A07(float f4, boolean z2, boolean z3) {
        if (f4 == this.A00) {
            boolean z4 = this.A06;
            if (A0B[0].charAt(18) == '8') {
                throw new RuntimeException();
            }
            String[] strArr = A0B;
            strArr[1] = "53dJ9AIfpWgAiYxHMCG9HZc2BFq1OE7v";
            strArr[5] = "L0WiXVvsNCgFHVaJqnPv6kv4Mg7dMukq";
            if (z4 == z2) {
                boolean z5 = this.A07;
                if (A0B[0].charAt(18) == '8') {
                    throw new RuntimeException();
                }
                A0B[6] = "oRFcKwA3BVWliQpK";
                if (z5 == z3) {
                    return;
                }
            }
        }
        this.A00 = f4;
        this.A06 = z2;
        this.A07 = z3;
        A02(null);
        invalidateSelf();
    }

    public final void A08(ColorStateList colorStateList) {
        A01(colorStateList);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        boolean z2;
        Paint paint = this.A08;
        if (this.A05 != null && paint.getColorFilter() == null) {
            paint.setColorFilter(this.A05);
            z2 = true;
        } else {
            z2 = false;
        }
        RectF rectF = this.A0A;
        float f4 = this.A01;
        canvas.drawRoundRect(rectF, f4, f4, paint);
        if (z2) {
            paint.setColorFilter(null);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public final void getOutline(Outline outline) {
        outline.setRoundRect(this.A09, this.A01);
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean isStateful() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2 = this.A03;
        return (colorStateList2 != null && colorStateList2.isStateful()) || ((colorStateList = this.A02) != null && colorStateList.isStateful()) || super.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        A02(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean onStateChange(int[] iArr) {
        PorterDuff.Mode mode;
        ColorStateList colorStateList = this.A02;
        int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
        int newColor = this.A08.getColor();
        boolean z2 = colorForState != newColor;
        if (z2) {
            this.A08.setColor(colorForState);
        }
        ColorStateList colorStateList2 = this.A03;
        if (colorStateList2 != null && (mode = this.A04) != null) {
            this.A05 = A00(colorStateList2, mode);
            String[] strArr = A0B;
            String str = strArr[1];
            String str2 = strArr[5];
            int charAt = str.charAt(5);
            int newColor2 = str2.charAt(5);
            if (charAt != newColor2) {
                String[] strArr2 = A0B;
                strArr2[7] = "gw8aJamP4c9IyEoweL2kyhEgHCjeuWPe";
                strArr2[3] = "K8VP8qVoNq2cy5DWSBLK7jrCKGtgCHwn";
                return true;
            }
            throw new RuntimeException();
        }
        return z2;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i) {
        this.A08.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        this.A08.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTintList(ColorStateList colorStateList) {
        this.A03 = colorStateList;
        this.A05 = A00(colorStateList, this.A04);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTintMode(PorterDuff.Mode mode) {
        this.A04 = mode;
        this.A05 = A00(this.A03, mode);
        invalidateSelf();
    }
}
