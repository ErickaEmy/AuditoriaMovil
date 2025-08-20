package com.facebook.ads.redexgen.X;

import android.graphics.drawable.GradientDrawable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.Arrays;
/* loaded from: assets/audience_network.dex */
public final class M9 extends LinearLayout {
    public static byte[] A04;
    public static final int A05;
    public static final int A06;
    public static final int A07;
    public static final int A08;
    public static final int A09;
    public final ImageView A00;
    public final ImageView A01;
    public final C2S A02;
    public final C1116Yn A03;

    public static String A02(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A04, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] ^ i6) ^ 91);
        }
        return new String(copyOfRange);
    }

    public static void A03() {
        A04 = new byte[]{118, 83};
    }

    static {
        A03();
        A08 = (int) (LD.A02 * 50.0f);
        A05 = (int) (LD.A02 * 10.0f);
        A06 = (int) (LD.A02 * 20.0f);
        A09 = (int) (LD.A02 * 4.0f);
        A07 = (int) (LD.A02 * 12.0f);
    }

    public M9(C1116Yn c1116Yn, int i) {
        super(c1116Yn);
        this.A03 = c1116Yn;
        this.A02 = C2T.A00(c1116Yn.A01());
        setOrientation(0);
        this.A00 = new ImageView(c1116Yn);
        this.A01 = new ImageView(c1116Yn);
        A04(i);
    }

    private void A04(int i) {
        EnumC0791Lw enumC0791Lw;
        A05(this.A00, EnumC0791Lw.AD_CHOICES_ICON);
        if (i == 2) {
            int i5 = A05;
            setPadding(i5, i5 / 3, i5, i5 / 3);
            TextView textView = new TextView(this.A03);
            textView.setText(A02(0, 2, 108));
            textView.setTextColor(-1);
            textView.setPadding(0, i5 / 2, i5 / 2, i5 / 2);
            AbstractC0783Lo.A0X(textView, true, 13);
            LinearLayout.LayoutParams textViewParams = new LinearLayout.LayoutParams(-2, -2);
            textViewParams.gravity = 16;
            addView(textView, textViewParams);
            int i6 = A07;
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i6, i6);
            layoutParams.gravity = 16;
            addView(this.A00, layoutParams);
            return;
        }
        int i8 = A05;
        setPadding(i8, i8, i8, i8);
        if (i == 1) {
            enumC0791Lw = EnumC0791Lw.AN_INFO_ICON;
        } else {
            enumC0791Lw = EnumC0791Lw.DEFAULT_INFO_ICON;
        }
        A05(this.A01, enumC0791Lw);
        int i10 = A06;
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(i10, i10);
        layoutParams2.gravity = 17;
        addView(this.A01, layoutParams2);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(i10, i10);
        layoutParams3.setMargins(A09, 0, 0, 0);
        layoutParams3.gravity = 17;
        addView(this.A00, layoutParams3);
    }

    public static void A05(ImageView imageView, EnumC0791Lw enumC0791Lw) {
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        imageView.setImageBitmap(AbstractC0792Lx.A01(enumC0791Lw));
        imageView.setColorFilter(-1);
    }

    public void setAdDetails(C02911a c02911a, String str, JA ja, MC mc2) {
        setOnClickListener(new M8(this, ja, mc2, str, c02911a));
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(A08);
        gradientDrawable.setColor(i);
        AbstractC0783Lo.A0S(this, gradientDrawable);
    }

    public void setIconColors(int i) {
        this.A00.setColorFilter(i);
        this.A01.setColorFilter(i);
    }
}
