package com.facebook.ads.redexgen.X;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
/* loaded from: assets/audience_network.dex */
public final class N6 extends LinearLayout {
    public static final int A03 = (int) (LD.A02 * 40.0f);
    public static final int A04 = (int) (LD.A02 * 20.0f);
    public static final int A05 = (int) (LD.A02 * 10.0f);
    public final C2W A00;
    public final C1116Yn A01;
    public final InterfaceC0811Mq A02;

    public N6(C1116Yn c1116Yn, C2W c2w, InterfaceC0811Mq interfaceC0811Mq, EnumC0791Lw enumC0791Lw) {
        this(c1116Yn, c2w, interfaceC0811Mq, null, enumC0791Lw);
    }

    public N6(C1116Yn c1116Yn, C2W c2w, InterfaceC0811Mq interfaceC0811Mq, String str, EnumC0791Lw enumC0791Lw) {
        super(c1116Yn);
        this.A01 = c1116Yn;
        this.A00 = c2w;
        this.A02 = interfaceC0811Mq;
        setOrientation(1);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        if (!TextUtils.isEmpty(str)) {
            View A01 = A01(str);
            A01.setPadding(0, 0, 0, 0);
            View view = new View(getContext());
            view.setLayoutParams(new LinearLayout.LayoutParams(-1, 1));
            AbstractC0783Lo.A0M(view, -10459280);
            addView(A01, layoutParams);
            addView(view);
        }
        if (!TextUtils.isEmpty(c2w.A03())) {
            View A00 = A00(enumC0791Lw, c2w.A03());
            int i = A05;
            A00.setPadding(0, i, 0, i);
            addView(A00, layoutParams);
        }
        NC A032 = A03();
        A032.setPadding(0, A05, 0, 0);
        addView(A032, layoutParams);
    }

    private View A00(EnumC0791Lw enumC0791Lw, String str) {
        ImageView imageView = new ImageView(getContext());
        imageView.setColorFilter(-10459280);
        int i = A04;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i, i);
        layoutParams.gravity = 16;
        imageView.setImageBitmap(AbstractC0792Lx.A01(enumC0791Lw));
        TextView textView = new TextView(getContext());
        AbstractC0783Lo.A0X(textView, true, 14);
        textView.setTextColor(-10459280);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        textView.setText(str);
        textView.setPadding(A05, 0, 0, 0);
        textView.setFocusable(true);
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(0);
        linearLayout.addView(imageView, layoutParams);
        linearLayout.addView(textView, layoutParams2);
        return linearLayout;
    }

    private View A01(String str) {
        ImageView imageView = new ImageView(getContext());
        imageView.setColorFilter(-10459280);
        imageView.setImageBitmap(AbstractC0792Lx.A01(EnumC0791Lw.BACK_ARROW));
        int i = A05;
        imageView.setPadding(0, i, i * 2, i);
        int i5 = A03;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i5, i5);
        imageView.setOnClickListener(new N4(this));
        TextView titleView = new TextView(getContext());
        titleView.setGravity(17);
        titleView.setText(str);
        AbstractC0783Lo.A0X(titleView, true, 16);
        titleView.setTextColor(-14934495);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.setMargins(0, 0, i5, 0);
        layoutParams2.gravity = 17;
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(0);
        linearLayout.addView(imageView, layoutParams);
        linearLayout.addView(titleView, layoutParams2);
        return linearLayout;
    }

    private NC A03() {
        NC nc = new NC(this.A01);
        for (C2W c2w : this.A00.A05()) {
            C0813Ms c0813Ms = new C0813Ms(this.A01);
            c0813Ms.setData(c2w.A04(), null);
            c0813Ms.setOnClickListener(new N5(this, c0813Ms, c2w));
            nc.addView(c0813Ms);
        }
        return nc;
    }
}
