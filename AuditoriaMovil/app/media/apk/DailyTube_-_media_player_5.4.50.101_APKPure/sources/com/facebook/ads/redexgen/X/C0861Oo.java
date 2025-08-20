package com.facebook.ads.redexgen.X;

import android.graphics.Typeface;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import java.util.HashMap;
import java.util.Locale;
/* renamed from: com.facebook.ads.redexgen.X.Oo  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C0861Oo extends FrameLayout {
    public final int A00;
    public final RelativeLayout A01;
    public final View$OnClickListenerC0988Tl A02;
    public static final int A05 = (int) (LD.A02 * 36.0f);
    public static final int A06 = (int) (LD.A02 * 36.0f);
    public static final int A03 = (int) (LD.A02 * 23.0f);
    public static final int A04 = (int) (LD.A02 * 3.0f);
    public static final int A07 = (int) (LD.A02 * 4.0f);

    public C0861Oo(C1116Yn c1116Yn, AbstractC1219b5 abstractC1219b5, J2 j2, MC mc2, RE re, C0775Lg c0775Lg, C1P c1p, InterfaceC0837Nq interfaceC0837Nq) {
        super(c1116Yn);
        this.A00 = c1p.A08(true);
        RelativeLayout relativeLayout = new RelativeLayout(c1116Yn);
        this.A01 = relativeLayout;
        addView(relativeLayout, new FrameLayout.LayoutParams(-1, -1));
        relativeLayout.setClickable(false);
        A01(c1116Yn, abstractC1219b5.A0x().A0F().A04());
        View$OnClickListenerC0988Tl view$OnClickListenerC0988Tl = new View$OnClickListenerC0988Tl(c1116Yn, abstractC1219b5.A0L(), null, j2, mc2, re, c0775Lg, abstractC1219b5.A0y());
        this.A02 = view$OnClickListenerC0988Tl;
        view$OnClickListenerC0988Tl.setCta(abstractC1219b5.A0x().A0F(), abstractC1219b5.A12(), new HashMap(), interfaceC0837Nq);
        view$OnClickListenerC0988Tl.setIsInAppBrowser(true);
        addView(view$OnClickListenerC0988Tl, new FrameLayout.LayoutParams(-1, -1));
    }

    private void A00(C1116Yn c1116Yn, View view) {
        ImageView imageView = new ImageView(c1116Yn);
        imageView.setImageBitmap(AbstractC0792Lx.A01(EnumC0791Lw.MINIMIZE_ARROW));
        imageView.setRotation(180.0f);
        imageView.setClickable(false);
        imageView.setColorFilter(this.A00);
        int i = A03;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i, i);
        int i5 = A04;
        imageView.setPadding(i5, i5, i5, i5);
        layoutParams.addRule(2, view.getId());
        layoutParams.addRule(14);
        this.A01.addView(imageView, layoutParams);
    }

    private void A01(C1116Yn c1116Yn, String str) {
        Button button = new Button(c1116Yn);
        AbstractC0783Lo.A0K(button);
        int i = A06;
        button.setPadding(i, 0, i, 0);
        button.setText(str.toUpperCase(Locale.getDefault()));
        button.setTextSize(14.0f);
        button.setTypeface(Typeface.defaultFromStyle(1));
        AbstractC0783Lo.A0O(button, this.A00, A07);
        button.setTextColor(-16777216);
        RelativeLayout.LayoutParams ctaParams = new RelativeLayout.LayoutParams(-2, A05);
        ctaParams.addRule(12);
        ctaParams.addRule(14);
        this.A01.addView(button, ctaParams);
        A00(c1116Yn, button);
    }

    public final void A02(String str) {
        this.A02.A09(str);
    }

    @Override // android.view.View
    public final boolean performClick() {
        return this.A02.performClick();
    }

    public void setAutoClickTime(AbstractC1219b5 abstractC1219b5, MB mb) {
        this.A02.A0A(abstractC1219b5, mb);
    }
}
