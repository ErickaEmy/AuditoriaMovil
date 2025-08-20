package com.facebook.ads.redexgen.X;

import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import java.util.Arrays;
/* loaded from: assets/audience_network.dex */
public final class U4 extends AbstractC0809Mo {
    public static byte[] A05;
    public static final int A06;
    public static final int A07;
    public static final int A08;
    public final ImageView A00;
    public final LinearLayout A01;
    public final ScrollView A02;
    public final C2S A03;
    public final C1116Yn A04;

    public static String A0B(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A05, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] ^ i6) ^ 55);
        }
        return new String(copyOfRange);
    }

    public static void A0C() {
        A05 = new byte[]{53, 22, 20, 28, 105, 70, 69, 89, 79, 10, 107, 78, 10, 120, 79, 90, 69, 88, 94, 67, 68, 77};
    }

    static {
        A0C();
        A08 = (int) (LD.A02 * 8.0f);
        A07 = (int) (LD.A02 * 10.0f);
        A06 = (int) (LD.A02 * 44.0f);
    }

    public U4(C1116Yn c1116Yn, J2 j2, String str) {
        super(c1116Yn, j2, str);
        this.A04 = c1116Yn;
        this.A03 = C2T.A00(c1116Yn.A01());
        ImageView imageView = new ImageView(getContext());
        this.A00 = imageView;
        int i = A07;
        imageView.setPadding(i, i, i, i);
        imageView.setColorFilter(-10459280);
        int i5 = A06;
        LinearLayout.LayoutParams closeButtonParams = new LinearLayout.LayoutParams(i5, i5);
        closeButtonParams.gravity = 3;
        imageView.setLayoutParams(closeButtonParams);
        ScrollView scrollView = new ScrollView(getContext());
        this.A02 = scrollView;
        scrollView.setFillViewport(true);
        AbstractC0783Lo.A0M(scrollView, -218103809);
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.A01 = linearLayout;
        linearLayout.setOrientation(1);
        int i6 = A08;
        linearLayout.setPadding(i6, i6, i6, i6);
        scrollView.addView(linearLayout, new FrameLayout.LayoutParams(-1, -2));
        addView(scrollView, new FrameLayout.LayoutParams(-1, -1));
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0809Mo
    public final void A0L() {
        this.A00.setImageBitmap(AbstractC0792Lx.A01(EnumC0791Lw.CROSS));
        this.A00.setOnClickListener(new N7(this));
        this.A00.setContentDescription(A0B(4, 18, 29));
        C0813Ms c0813Ms = new C0813Ms(this.A04);
        c0813Ms.setData(this.A03.A0H(), EnumC0791Lw.HIDE_AD);
        c0813Ms.setOnClickListener(new N8(this, c0813Ms));
        C0813Ms c0813Ms2 = new C0813Ms(this.A04);
        c0813Ms2.setData(this.A03.A0L(), EnumC0791Lw.REPORT_AD);
        c0813Ms2.setOnClickListener(new N9(this, c0813Ms2));
        C0813Ms c0813Ms3 = new C0813Ms(this.A04);
        c0813Ms3.setData(this.A03.A0M(), EnumC0791Lw.AD_CHOICES_ICON);
        c0813Ms3.setOnClickListener(new NA(this, c0813Ms3));
        LinearLayout.LayoutParams menuParams = new LinearLayout.LayoutParams(-2, -2);
        int i = A08;
        menuParams.setMargins(i, i, i, i);
        menuParams.gravity = 17;
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(1);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, 0);
        layoutParams.gravity = 17;
        layoutParams.weight = 1.0f;
        AbstractC0783Lo.A0T(this.A01);
        this.A01.removeAllViews();
        this.A01.addView(this.A00);
        this.A01.addView(linearLayout, layoutParams);
        linearLayout.addView(c0813Ms, menuParams);
        linearLayout.addView(c0813Ms2, menuParams);
        linearLayout.addView(c0813Ms3, menuParams);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0809Mo
    public final void A0M() {
        AbstractC0783Lo.A0I(this);
        AbstractC0783Lo.A0J(this);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0809Mo
    public final void A0N(C2W c2w, C2U c2u) {
        String A0H;
        EnumC0791Lw enumC0791Lw;
        int i;
        this.A00.setOnClickListener(null);
        if (c2u == C2U.A05) {
            A0H = this.A03.A0F();
            enumC0791Lw = EnumC0791Lw.REPORT_AD;
            i = -552389;
        } else {
            A0H = this.A03.A0H();
            enumC0791Lw = EnumC0791Lw.HIDE_AD;
            i = -13272859;
        }
        C0807Mm A0I = new C0807Mm(this.A04, this.A0B).A0I(A0H);
        String title = this.A03.A0D();
        C0807Mm A0H2 = A0I.A0H(title);
        String title2 = c2w.A04();
        C0808Mn adHiddenView = A0H2.A0F(title2).A0K(false).A0E(enumC0791Lw).A0D(i).A0L(false).A0J(false).A0M();
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0);
        layoutParams.gravity = 17;
        layoutParams.weight = 1.0f;
        AbstractC0783Lo.A0T(this.A01);
        this.A02.fullScroll(33);
        this.A01.removeAllViews();
        this.A01.addView(adHiddenView, layoutParams);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0809Mo
    public final void A0O(C2W c2w, C2U c2u) {
        boolean isReportFlow = c2u == C2U.A05;
        N6 n62 = new N6(this.A04, c2w, this.A0B, isReportFlow ? EnumC0791Lw.REPORT_AD : EnumC0791Lw.HIDE_AD);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, 0);
        layoutParams.gravity = 17;
        layoutParams.weight = 1.0f;
        this.A00.setImageBitmap(AbstractC0792Lx.A01(EnumC0791Lw.BACK_ARROW));
        this.A00.setOnClickListener(new NB(this));
        this.A00.setContentDescription(A0B(0, 4, 64));
        AbstractC0783Lo.A0T(this.A01);
        this.A02.fullScroll(33);
        this.A01.removeAllViews();
        this.A01.addView(this.A00);
        this.A01.addView(n62, layoutParams);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0809Mo
    public final boolean A0P() {
        return true;
    }
}
