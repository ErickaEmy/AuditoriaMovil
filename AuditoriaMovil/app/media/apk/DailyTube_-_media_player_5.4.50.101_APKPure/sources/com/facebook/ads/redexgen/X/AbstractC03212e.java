package com.facebook.ads.redexgen.X;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
/* renamed from: com.facebook.ads.redexgen.X.2e  reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public abstract class AbstractC03212e extends FrameLayout {
    public static final float A08;
    public static final int A09;
    public static final InterfaceC03232g A0A;
    public int A00;
    public int A01;
    public boolean A02;
    public boolean A03;
    public final Rect A04;
    public final Rect A05;
    public final InterfaceC03222f A06;
    public static String[] A07 = {"jVZ1Tu881vaZhMQc7G1YnAdrBZwLOzLZ", "MIZgMzLB91QWfj9gVmnmcTG9oR84Ntwz", "DCbfL76gOTURmFCUeHCsoybhclYkmTay", "EMPd0g2FUYEiLKskd4o9XcZgPaWME7KU", "G2pxhAodnNK6EDlWmu9QTAPYKMlMfLOc", "qEeDuFDfyNwl7ByTckOuFZ9zHyfaVY7D", "VB67ht075LyAy5nhvmM9NplNYlVRYF1n", "i4ARItf07QURagRfhioscqF5iwXVDFyZ"};
    public static final int[] A0B = {16842801};

    static {
        float f4 = Resources.getSystem().getDisplayMetrics().density;
        A08 = f4;
        A09 = (int) (f4 * 1.0f);
        if (Build.VERSION.SDK_INT >= 21) {
            A0A = new C1161a9();
        } else if (Build.VERSION.SDK_INT >= 17) {
            A0A = new F6();
        } else {
            A0A = new C1159a7();
        }
        A0A.A8r();
    }

    public AbstractC03212e(Context context) {
        this(context, null);
    }

    public AbstractC03212e(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AbstractC03212e(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Rect rect = new Rect();
        this.A04 = rect;
        this.A05 = new Rect();
        C1163aB c1163aB = new C1163aB(this);
        this.A06 = c1163aB;
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(A0B);
        int color = obtainStyledAttributes.getColor(0, 0);
        obtainStyledAttributes.recycle();
        Color.colorToHSV(color, new float[3]);
        ColorStateList valueOf = ColorStateList.valueOf(-328966);
        this.A02 = false;
        this.A03 = true;
        rect.left = 0;
        rect.top = 0;
        rect.right = 0;
        rect.bottom = 0;
        int themeColorBackground = 10.0f > 50.0f ? 1092616192 : 1112014848;
        this.A01 = 0;
        this.A00 = 0;
        A0A.A8s(c1163aB, context, valueOf, 10.0f, 10.0f, themeColorBackground);
    }

    public ColorStateList getCardBackgroundColor() {
        return A0A.A66(this.A06);
    }

    public float getCardElevation() {
        return A0A.A6t(this.A06);
    }

    public int getContentPaddingBottom() {
        return this.A04.bottom;
    }

    public int getContentPaddingLeft() {
        return this.A04.left;
    }

    public int getContentPaddingRight() {
        return this.A04.right;
    }

    public int getContentPaddingTop() {
        return this.A04.top;
    }

    public float getMaxCardElevation() {
        return A0A.A7M(this.A06);
    }

    public boolean getPreventCornerOverlap() {
        return this.A03;
    }

    public float getRadius() {
        return A0A.A7m(this.A06);
    }

    public boolean getUseCompatPadding() {
        return this.A02;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int i, int i5) {
        InterfaceC03232g interfaceC03232g = A0A;
        if (!(interfaceC03232g instanceof C1161a9)) {
            int mode = View.MeasureSpec.getMode(i);
            switch (mode) {
                case Integer.MIN_VALUE:
                case 1073741824:
                    double ceil = Math.ceil(interfaceC03232g.A7S(this.A06));
                    if (A07[1].charAt(21) == 'T') {
                        A07[1] = "CoEZjfZf0TpQ2BZBlHTi5T6DWNYutRLI";
                        int minHeight = View.MeasureSpec.getSize(i);
                        i = View.MeasureSpec.makeMeasureSpec(Math.max((int) ceil, minHeight), mode);
                        break;
                    } else {
                        throw new RuntimeException();
                    }
            }
            int mode2 = View.MeasureSpec.getMode(i5);
            switch (mode2) {
                case Integer.MIN_VALUE:
                case 1073741824:
                    int minHeight2 = View.MeasureSpec.getSize(i5);
                    i5 = View.MeasureSpec.makeMeasureSpec(Math.max((int) Math.ceil(interfaceC03232g.A7R(this.A06)), minHeight2), mode2);
                    break;
            }
            super.onMeasure(i, i5);
            return;
        }
        super.onMeasure(i, i5);
    }

    public void setCardBackgroundColor(int i) {
        A0A.AFt(this.A06, ColorStateList.valueOf(i));
    }

    public void setCardBackgroundColor(ColorStateList colorStateList) {
        A0A.AFt(this.A06, colorStateList);
    }

    public void setCardElevation(float f4) {
        A0A.AFz(this.A06, f4);
    }

    public void setMaxCardElevation(float f4) {
        A0A.AG6(this.A06, f4);
    }

    @Override // android.view.View
    public void setMinimumHeight(int i) {
        this.A00 = i;
        super.setMinimumHeight(i);
    }

    @Override // android.view.View
    public void setMinimumWidth(int i) {
        this.A01 = i;
        super.setMinimumWidth(i);
    }

    @Override // android.view.View
    public final void setPadding(int i, int i5, int i6, int i8) {
    }

    @Override // android.view.View
    public final void setPaddingRelative(int i, int i5, int i6, int i8) {
    }

    public void setPreventCornerOverlap(boolean z2) {
        if (z2 != this.A03) {
            this.A03 = z2;
            String[] strArr = A07;
            if (strArr[5].charAt(25) == strArr[2].charAt(25)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A07;
            strArr2[5] = "AF11DlndTIGSrqZz8tUh3XTR3YFTmMvs";
            strArr2[2] = "M7b5sm4OMM6QoyOKa0AwC0c4wRmpSBfx";
            A0A.ACk(this.A06);
        }
    }

    public void setRadius(float f4) {
        A0A.AGC(this.A06, f4);
    }

    public void setUseCompatPadding(boolean z2) {
        if (this.A02 != z2) {
            this.A02 = z2;
            A0A.AB7(this.A06);
        }
    }
}
