package com.facebook.ads.redexgen.X;

import android.graphics.drawable.GradientDrawable;
import android.text.SpannableString;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.ads.internal.api.AdNativeComponentView;
/* loaded from: assets/audience_network.dex */
public final class MI extends AdNativeComponentView {
    public final LinearLayout A00;
    public final RelativeLayout A01;
    public final RelativeLayout A02;
    public final TextView A03;
    public final TextView A04;
    public final TextView A05;
    public final JR A06;
    public final UB A07;
    public static String[] A08 = {"uC9D5qmNt6hBQ30WTqHbWjXyd7i1Eya7", "gODvKHA4maP1ueedVTfLSKuHicNhKgsI", "CsSG52h0mPiGpGKpZqt1sL51qY2PgKJk", "t8ZdPgNdDyW7PJ5OFmmKGTW0QKkF2iLl", "957CjoSzFmlmvQzAWdXFvCjH6Z48RGY7", "Wj5TDMvsQRhldaVPvD6nNpKwpdYrUsC9", "EcmINfrxIVIGvxUX8", "04S0zAGn7nkSUB63PmP3o85Q9zROVkT0"};
    public static final int A09 = ((int) LD.A02) * 500;
    public static final int A0H = (int) (LD.A02 * 500.0f);
    public static final int A0D = (int) (LD.A02 * 4.0f);
    public static final int A0B = (int) (LD.A02 * 8.0f);
    public static final int A0G = (int) (LD.A02 * 8.0f);
    public static final int A0E = (int) (LD.A02 * 4.0f);
    public static final int A0C = (int) LD.A02;
    public static final int A0F = (int) (LD.A02 * 4.0f);
    public static final int A0A = (int) (LD.A02 * 0.5d);

    public MI(C1116Yn c1116Yn, JR jr) {
        super(c1116Yn);
        this.A06 = jr;
        this.A05 = new TextView(c1116Yn);
        this.A04 = new TextView(c1116Yn);
        this.A03 = new TextView(c1116Yn);
        this.A02 = new RelativeLayout(c1116Yn);
        this.A00 = new LinearLayout(c1116Yn);
        this.A01 = new RelativeLayout(c1116Yn);
        this.A07 = new UB(c1116Yn);
        A09();
        A0D();
        A05();
        A0A();
        A00();
        A0B();
        A03();
        A0A();
        A08();
        A0C();
    }

    private void A00() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.weight = 1.0f;
        layoutParams.gravity = 1;
        this.A00.addView(this.A01, layoutParams);
    }

    private void A01() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(3, this.A04.getId());
        AbstractC0783Lo.A0J(this.A03);
        this.A02.addView(this.A03, layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        this.A02.setBackgroundDrawable(null);
        RelativeLayout relativeLayout = this.A02;
        int i = A0G;
        relativeLayout.setPadding(i, i, i, i);
        AbstractC0783Lo.A0J(this.A02);
        this.A00.addView(this.A02, layoutParams2);
    }

    private void A02() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        int i = A0B;
        int i5 = A0D;
        layoutParams.setMargins(i, i5, i, i5);
        AbstractC0783Lo.A0J(this.A03);
        this.A00.addView(this.A03, layoutParams);
    }

    private void A03() {
        this.A01.addView(this.A07, new LinearLayout.LayoutParams(-2, -1));
    }

    private void A04() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(8, this.A07.getId());
        layoutParams.addRule(5, this.A07.getId());
        layoutParams.addRule(7, this.A07.getId());
        RelativeLayout relativeLayout = this.A02;
        int i = A0G;
        relativeLayout.setPadding(i, 0, i, 0);
        GradientDrawable shape = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[]{-872415232, 0});
        this.A02.setBackgroundDrawable(shape);
        AbstractC0783Lo.A0J(this.A02);
        this.A01.addView(this.A02, layoutParams);
    }

    private void A05() {
        addView(this.A00, new LinearLayout.LayoutParams(-2, -2));
    }

    private void A06() {
        this.A05.setTextColor(-1);
        this.A04.setTextColor(-1);
        this.A03.setTextColor(this.A06.A03());
    }

    private void A07() {
        this.A07.setMaxWidth(A0H);
        this.A05.setTextColor(this.A06.A04(0.2f));
        this.A04.setTextColor(this.A06.A04(0.4f));
        this.A03.setTextColor(this.A06.A03());
        ((LinearLayout.LayoutParams) this.A01.getLayoutParams()).gravity = 1;
    }

    private void A08() {
        TextView textView = this.A03;
        int i = A0C;
        textView.setPadding(i, i, i, i);
        this.A03.setTextSize(14.0f);
        AbstractC0783Lo.A0K(this.A03);
    }

    private void A09() {
        setLayoutParams(new RelativeLayout.LayoutParams(-2, -1));
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(this.A06.A01());
        gradientDrawable.setCornerRadius(A0F);
        gradientDrawable.setStroke(1, this.A06.A02());
        setBackgroundDrawable(gradientDrawable);
        int i = A0A;
        setPadding(i, i, i, i);
    }

    private void A0A() {
        AbstractC0783Lo.A0K(this.A01);
    }

    private void A0B() {
        this.A07.setScaleType(ImageView.ScaleType.FIT_XY);
        UB ub = this.A07;
        int i = A0F;
        ub.setRadius(new float[]{i, i, i, i, 0.0f, 0.0f, 0.0f, 0.0f});
        this.A07.setAdjustViewBounds(true);
        LI.A04(this.A07, LI.A0A);
        AbstractC0783Lo.A0K(this.A07);
    }

    private void A0C() {
        AbstractC0783Lo.A0K(this.A02);
        this.A05.setTextSize(14.0f);
        AbstractC0783Lo.A0K(this.A05);
        this.A05.setMaxLines(1);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        int i = A0E;
        layoutParams.setMargins(0, 0, 0, i);
        this.A02.addView(this.A05, layoutParams);
        this.A04.setTextSize(12.0f);
        AbstractC0783Lo.A0K(this.A04);
        this.A04.setMaxLines(1);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(3, this.A05.getId());
        layoutParams2.setMargins(0, 0, 0, i);
        this.A02.addView(this.A04, layoutParams2);
    }

    private void A0D() {
        this.A00.setOrientation(1);
        AbstractC0783Lo.A0K(this.A00);
    }

    public View getAdContentsView() {
        return this.A07;
    }

    public ImageView getImageCardView() {
        return this.A07;
    }

    public final void onMeasure(int i, int i5) {
        int A0E2 = ((int) LD.A02) * C0705Ih.A0E(getContext());
        int heightThreshold = View.MeasureSpec.getSize(i5);
        if (heightThreshold < A0E2) {
            int mode = View.MeasureSpec.getMode(i5);
            String[] strArr = A08;
            String str = strArr[3];
            String str2 = strArr[0];
            int charAt = str.charAt(18);
            int heightThreshold2 = str2.charAt(18);
            if (charAt == heightThreshold2) {
                throw new RuntimeException();
            }
            String[] strArr2 = A08;
            strArr2[2] = "15DEnWMwGzueTnQFE8qATib1q5d5oHj9";
            strArr2[4] = "kyJeuSgnvxhO6LbcYzomu9S0GmVFz9Qa";
            if (mode != 0) {
                A02();
                A04();
                A06();
                super.onMeasure(i, i5);
            }
        }
        A01();
        A07();
        super.onMeasure(i, i5);
    }

    public void setButtonText(String str) {
        if (str == null || str.trim().isEmpty()) {
            this.A03.setVisibility(8);
            return;
        }
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new StyleSpan(1), 0, spannableString.length(), 0);
        this.A03.setText(spannableString);
    }

    public void setSubtitle(String str) {
        if (str == null || str.trim().isEmpty()) {
            this.A04.setVisibility(8);
        }
        this.A04.setText(str);
    }

    public void setTitle(String str) {
        if (str == null || str.trim().isEmpty()) {
            this.A05.setVisibility(8);
        }
        this.A05.setText(str);
    }
}
