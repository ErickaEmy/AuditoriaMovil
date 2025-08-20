package com.facebook.ads.redexgen.X;

import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.Arrays;
/* loaded from: assets/audience_network.dex */
public final class U5 extends AbstractC0809Mo {
    public static byte[] A06;
    public static final int A07;
    public static final int A08;
    public static final int A09;
    public final HorizontalScrollView A00;
    public final ImageView A01;
    public final LinearLayout A02;
    public final LinearLayout A03;
    public final C2S A04;
    public final C1116Yn A05;

    public static String A0B(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A06, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] - i6) - 8);
        }
        return new String(copyOfRange);
    }

    public static void A0C() {
        A06 = new byte[]{-57, -26, -24, -16, -92, -51, -48, -44, -58, -127, -94, -59, -127, -77, -58, -47, -48, -45, -43, -54, -49, -56};
    }

    static {
        A0C();
        A09 = (int) (LD.A02 * 4.0f);
        A08 = (int) (LD.A02 * 10.0f);
        A07 = (int) (LD.A02 * 44.0f);
    }

    public U5(C1116Yn c1116Yn, J2 j2, String str) {
        super(c1116Yn, j2, str);
        this.A05 = c1116Yn;
        this.A04 = C2T.A00(c1116Yn.A01());
        ImageView imageView = new ImageView(getContext());
        this.A01 = imageView;
        int i = A08;
        imageView.setPadding(i, i, i, i);
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        imageView.setColorFilter(-10459280);
        int i5 = A07;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i5, i5);
        layoutParams.gravity = 16;
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.A02 = linearLayout;
        linearLayout.setOrientation(0);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.gravity = 17;
        HorizontalScrollView horizontalScrollView = new HorizontalScrollView(getContext());
        this.A00 = horizontalScrollView;
        horizontalScrollView.setHorizontalScrollBarEnabled(false);
        horizontalScrollView.setLayoutParams(layoutParams2);
        horizontalScrollView.addView(linearLayout, layoutParams2);
        LinearLayout linearLayout2 = new LinearLayout(getContext());
        this.A03 = linearLayout2;
        linearLayout2.setOrientation(0);
        AbstractC0783Lo.A0M(linearLayout2, -218103809);
        linearLayout2.setMotionEventSplittingEnabled(false);
        linearLayout2.addView(imageView, layoutParams);
        linearLayout2.addView(horizontalScrollView, layoutParams2);
        addView(linearLayout2, new FrameLayout.LayoutParams(-1, -1));
        linearLayout2.setClickable(true);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0809Mo
    public final void A0L() {
        this.A01.setImageBitmap(AbstractC0792Lx.A01(EnumC0791Lw.CROSS));
        this.A01.setOnClickListener(new View$OnClickListenerC0818Mx(this));
        this.A01.setContentDescription(A0B(4, 18, 89));
        C0813Ms c0813Ms = new C0813Ms(this.A05);
        c0813Ms.setData(this.A04.A0H(), EnumC0791Lw.HIDE_AD);
        c0813Ms.setOnClickListener(new View$OnClickListenerC0819My(this, c0813Ms));
        C0813Ms c0813Ms2 = new C0813Ms(this.A05);
        c0813Ms2.setData(this.A04.A0L(), EnumC0791Lw.REPORT_AD);
        c0813Ms2.setOnClickListener(new View$OnClickListenerC0820Mz(this, c0813Ms2));
        C0813Ms c0813Ms3 = new C0813Ms(this.A05);
        c0813Ms3.setData(this.A04.A0M(), EnumC0791Lw.AD_CHOICES_ICON);
        c0813Ms3.setOnClickListener(new N0(this, c0813Ms3));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        int i = A09;
        layoutParams.setMargins(0, i, i, i);
        AbstractC0783Lo.A0T(this.A03);
        this.A02.removeAllViews();
        this.A02.addView(c0813Ms, layoutParams);
        this.A02.addView(c0813Ms2, layoutParams);
        this.A02.addView(c0813Ms3, layoutParams);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0809Mo
    public final void A0M() {
        AbstractC0783Lo.A0I(this);
        AbstractC0783Lo.A0J(this);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0809Mo
    public final void A0N(C2W c2w, C2U c2u) {
        this.A01.setOnClickListener(null);
        TextView textView = new TextView(getContext());
        AbstractC0783Lo.A0X(textView, true, 14);
        textView.setText(this.A04.A0D());
        textView.setGravity(17);
        AbstractC0783Lo.A0T(this.A03);
        this.A03.removeAllViews();
        this.A03.addView(textView, new LinearLayout.LayoutParams(-1, -1));
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0809Mo
    public final void A0O(C2W c2w, C2U c2u) {
        AbstractC0783Lo.A0T(this.A03);
        this.A01.setImageBitmap(AbstractC0792Lx.A01(EnumC0791Lw.BACK_ARROW));
        this.A01.setOnClickListener(new N1(this));
        this.A01.setContentDescription(A0B(0, 4, 125));
        this.A02.removeAllViews();
        this.A00.fullScroll(17);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        int i = A09;
        layoutParams.setMargins(0, i, i, i);
        for (C2W c2w2 : c2w.A05()) {
            C0813Ms c0813Ms = new C0813Ms(this.A05);
            c0813Ms.setData(c2w2.A04(), null);
            c0813Ms.setOnClickListener(new N2(this, c0813Ms, c2w2));
            this.A02.addView(c0813Ms, layoutParams);
        }
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0809Mo
    public final boolean A0P() {
        return true;
    }
}
