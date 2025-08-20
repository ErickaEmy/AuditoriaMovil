package com.facebook.ads.redexgen.X;

import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
/* renamed from: com.facebook.ads.redexgen.X.Pg  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C0879Pg extends LinearLayout {
    public LinearLayout A00;
    public final int A01;
    public final C1116Yn A02;
    public final O3 A03;
    public final O9 A04;
    public static final int A07 = (int) (LD.A02 * 16.0f);
    public static final int A08 = (int) (LD.A02 * 16.0f);
    public static final int A06 = (int) (LD.A02 * 8.0f);
    public static final int A05 = (int) (LD.A02 * 72.0f);

    public C0879Pg(C0877Pe c0877Pe) {
        super(C0877Pe.A04(c0877Pe));
        C1116Yn A04 = C0877Pe.A04(c0877Pe);
        this.A02 = A04;
        this.A03 = new O3(A04);
        this.A04 = new O9(A04, C0877Pe.A02(c0877Pe), true, false, true);
        this.A01 = C0877Pe.A00(c0877Pe);
        A03(c0877Pe);
    }

    public /* synthetic */ C0879Pg(C0877Pe c0877Pe, C0960Sj c0960Sj) {
        this(c0877Pe);
    }

    private void A00() {
        A01(this.A03, 150);
        A01(this.A04, 170);
        LinearLayout linearLayout = this.A00;
        if (linearLayout != null) {
            A01(linearLayout, 190);
        }
    }

    private void A01(View view, int i) {
        view.setTranslationY(i);
        view.setScaleY(0.75f);
        view.setScaleX(0.75f);
        view.animate().translationYBy(-i).scaleX(1.0f).scaleY(1.0f).setDuration(300L).setInterpolator(new DecelerateInterpolator(2.0f));
    }

    private void A02(C0877Pe c0877Pe) {
        if (!TextUtils.isEmpty(C0877Pe.A05(c0877Pe))) {
            LinearLayout linearLayout = new LinearLayout(getContext());
            this.A00 = linearLayout;
            linearLayout.setGravity(17);
            LinearLayout linearLayout2 = this.A00;
            int i = A08;
            linearLayout2.setPadding(i, i / 2, i, i / 2);
            LinearLayout.LayoutParams informativeTextViewParams = new LinearLayout.LayoutParams(-2, -2);
            informativeTextViewParams.setMargins(0, i / 2, 0, 0);
            TextView textView = new TextView(getContext());
            textView.setTextColor(-1);
            AbstractC0783Lo.A0X(textView, false, 16);
            textView.setText(C0877Pe.A05(c0877Pe));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            ImageView imageView = new ImageView(getContext());
            new AsyncTaskC0993Tq(imageView, this.A02).A04().A07(C0877Pe.A06(c0877Pe));
            int i5 = A07;
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(i5, i5);
            layoutParams2.setMargins(0, 0, i / 2, 0);
            this.A00.addView(imageView, layoutParams2);
            this.A00.addView(textView, layoutParams);
            GradientDrawable bgDrawable = new GradientDrawable();
            bgDrawable.setCornerRadius(100.0f);
            bgDrawable.setColor(469762047);
            AbstractC0783Lo.A0S(this.A00, bgDrawable);
            addView(this.A00, informativeTextViewParams);
        }
    }

    private void A03(C0877Pe c0877Pe) {
        AbstractC0783Lo.A0M(this.A03, 0);
        this.A03.setRadius(50);
        if (C0877Pe.A01(c0877Pe).A00() == C1L.A05) {
            this.A03.setFullCircleCorners(true);
        } else {
            this.A03.setRadius(A06);
        }
        new AsyncTaskC0993Tq(this.A03, this.A02).A04().A07(C0877Pe.A03(c0877Pe).A01());
        this.A04.A03(C0877Pe.A01(c0877Pe).A06(), C0877Pe.A03(c0877Pe).A03(), null, false, true);
        this.A04.getDescriptionTextView().setAlpha(0.8f);
        this.A04.setAlignment(17);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        int i = A08;
        layoutParams.setMargins(0, i, 0, i / 2);
        View view = this.A03;
        int i5 = A05;
        LinearLayout.LayoutParams titleAndDescriptionParams = new LinearLayout.LayoutParams(i5, i5);
        addView(view, titleAndDescriptionParams);
        addView(this.A04, layoutParams);
        A02(c0877Pe);
        AbstractC0783Lo.A0M(this, -14473425);
        setGravity(17);
        setOrientation(1);
    }

    public final void A04(InterfaceC0878Pf interfaceC0878Pf) {
        A00();
        postDelayed(new C0960Sj(this, interfaceC0878Pf), this.A01);
    }
}
