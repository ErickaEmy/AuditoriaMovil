package com.facebook.ads.redexgen.X;

import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
/* renamed from: com.facebook.ads.redexgen.X.Mn  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C0808Mn extends RelativeLayout {
    public static final int A06;
    public static final int A07;
    public static final int A08;
    public static final int A09;
    public static final int A0A;
    public static final int A0B;
    public static final int A0C;
    public static final int A0D;
    public static final int A0E;
    public static final int A0F;
    public final int A00;
    public final int A01;
    public final C2S A02;
    public final C1116Yn A03;
    public final InterfaceC0811Mq A04;
    public final boolean A05;

    static {
        int i = (int) (LD.A02 * 16.0f);
        A09 = i;
        A0A = (int) (LD.A02 * 8.0f);
        A0D = (int) (LD.A02 * 44.0f);
        int i5 = (int) (LD.A02 * 10.0f);
        A08 = i5;
        A07 = i - i5;
        A0E = (int) (LD.A02 * 75.0f);
        A0B = (int) (LD.A02 * 25.0f);
        A0F = (int) (LD.A02 * 45.0f);
        A0C = (int) (LD.A02 * 15.0f);
        A06 = (int) (LD.A02 * 16.0f);
    }

    public C0808Mn(C0807Mm c0807Mm) {
        super(C0807Mm.A01(c0807Mm));
        C1116Yn A01 = C0807Mm.A01(c0807Mm);
        this.A03 = A01;
        this.A02 = C2T.A00(A01.A01());
        this.A04 = C0807Mm.A03(c0807Mm);
        this.A01 = C0807Mm.A09(c0807Mm) ? A0E : A0F;
        this.A00 = C0807Mm.A09(c0807Mm) ? A0B : A0C;
        this.A05 = C0807Mm.A0A(c0807Mm);
        setFocusable(true);
        View A012 = A01(c0807Mm);
        View A00 = A00(c0807Mm);
        View footerView = getFooterView();
        AbstractC0783Lo.A0K(A012);
        AbstractC0783Lo.A0K(A00);
        AbstractC0783Lo.A0K(footerView);
        RelativeLayout.LayoutParams footerParams = new RelativeLayout.LayoutParams(-1, -2);
        footerParams.addRule(10);
        RelativeLayout.LayoutParams headerParams = new RelativeLayout.LayoutParams(-1, -1);
        headerParams.addRule(13);
        headerParams.addRule(3, A012.getId());
        headerParams.addRule(2, footerView.getId());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        int i = A09;
        layoutParams.setMargins(i, 0, i, i);
        addView(A012, footerParams);
        addView(A00, headerParams);
        addView(footerView, layoutParams);
        footerView.setVisibility(C0807Mm.A0B(c0807Mm) ? 0 : 8);
    }

    public /* synthetic */ C0808Mn(C0807Mm c0807Mm, View$OnClickListenerC0805Mk view$OnClickListenerC0805Mk) {
        this(c0807Mm);
    }

    private View A00(C0807Mm c0807Mm) {
        ImageView imageView = new ImageView(getContext());
        int i = this.A00;
        imageView.setPadding(i, i, i, i);
        imageView.setImageBitmap(AbstractC0792Lx.A01(C0807Mm.A02(c0807Mm)));
        imageView.setColorFilter(-1);
        int i5 = this.A01;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i5, i5);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(1);
        gradientDrawable.setColor(C0807Mm.A00(c0807Mm));
        AbstractC0783Lo.A0S(imageView, gradientDrawable);
        layoutParams.gravity = 17;
        int i6 = A09;
        layoutParams.setMargins(i6, 0, i6, i6);
        TextView textView = new TextView(getContext());
        AbstractC0783Lo.A0X(textView, true, 20);
        textView.setTextColor(-14934495);
        textView.setText(C0807Mm.A04(c0807Mm));
        textView.setGravity(17);
        LinearLayout.LayoutParams iconParams = new LinearLayout.LayoutParams(-1, -2);
        iconParams.setMargins(i6, 0, i6, i6);
        TextView textView2 = new TextView(getContext());
        AbstractC0783Lo.A0X(textView2, false, 16);
        textView2.setTextColor(-10459280);
        textView2.setText(C0807Mm.A05(c0807Mm));
        textView2.setGravity(17);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.setMargins(i6, 0, i6, i6);
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(1);
        linearLayout.setGravity(17);
        linearLayout.addView(imageView, layoutParams);
        linearLayout.addView(textView, iconParams);
        linearLayout.addView(textView2, layoutParams2);
        if (C0807Mm.A08(c0807Mm)) {
            LinearLayout linearLayout2 = new LinearLayout(getContext());
            linearLayout2.setOrientation(0);
            linearLayout2.setGravity(17);
            if (!TextUtils.isEmpty(C0807Mm.A06(c0807Mm))) {
                O3 o3 = new O3(this.A03);
                int i8 = A0F;
                LinearLayout.LayoutParams subtitleParams = new LinearLayout.LayoutParams(i8, i8);
                subtitleParams.setMargins(0, 0, A0A, 0);
                o3.setFullCircleCorners(true);
                new AsyncTaskC0993Tq(o3, this.A03).A05(i8, i8).A07(C0807Mm.A06(c0807Mm));
                linearLayout2.addView(o3, subtitleParams);
            }
            C0813Ms c0813Ms = new C0813Ms(this.A03);
            c0813Ms.setData(C0807Mm.A07(c0807Mm), EnumC0791Lw.CHECKMARK);
            c0813Ms.setSelected(true);
            linearLayout2.addView(c0813Ms, new LinearLayout.LayoutParams(-2, -2));
            linearLayout.addView(linearLayout2);
        }
        return linearLayout;
    }

    private View A01(C0807Mm c0807Mm) {
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(0);
        if (C0807Mm.A0C(c0807Mm)) {
            ImageView imageView = new ImageView(getContext());
            int i = A08;
            imageView.setPadding(i, i, i, i);
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            imageView.setImageBitmap(AbstractC0792Lx.A01(EnumC0791Lw.CROSS));
            imageView.setOnClickListener(new View$OnClickListenerC0805Mk(this));
            int i5 = A0D;
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i5, i5);
            int i6 = A07;
            layoutParams.setMargins(i6, i6, i6, i6);
            linearLayout.addView(imageView, layoutParams);
        }
        return linearLayout;
    }

    private View getFooterView() {
        ImageView imageView = new ImageView(getContext());
        imageView.setImageBitmap(AbstractC0792Lx.A01(EnumC0791Lw.SETTINGS));
        imageView.setColorFilter(-13272859);
        int i = A06;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i, i);
        layoutParams.gravity = 17;
        TextView managePrefsText = new TextView(getContext());
        AbstractC0783Lo.A0X(managePrefsText, false, 16);
        managePrefsText.setTextColor(-13272859);
        int i5 = A0A;
        managePrefsText.setPadding(i5, i5, i5, i5);
        managePrefsText.setText(this.A02.A0J());
        LinearLayout.LayoutParams settingsIconParams = new LinearLayout.LayoutParams(-2, -2);
        settingsIconParams.gravity = 17;
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(0);
        linearLayout.setGravity(17);
        linearLayout.setOnClickListener(new View$OnClickListenerC0806Ml(this));
        linearLayout.addView(imageView, layoutParams);
        linearLayout.addView(managePrefsText, settingsIconParams);
        return linearLayout;
    }
}
