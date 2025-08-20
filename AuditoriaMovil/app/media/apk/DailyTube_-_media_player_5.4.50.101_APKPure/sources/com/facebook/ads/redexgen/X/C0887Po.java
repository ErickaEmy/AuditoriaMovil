package com.facebook.ads.redexgen.X;

import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
/* renamed from: com.facebook.ads.redexgen.X.Po  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C0887Po extends LinearLayout {
    public static final int A04 = (int) (LD.A02 * 32.0f);
    public static final int A05 = (int) (LD.A02 * 8.0f);
    public TextView A00;
    public TextView A01;
    public O3 A02;
    public final C1116Yn A03;

    public C0887Po(C1116Yn c1116Yn) {
        super(c1116Yn);
        this.A03 = c1116Yn;
        A00(c1116Yn);
    }

    private final void A00(C1116Yn c1116Yn) {
        setGravity(16);
        O3 o3 = new O3(c1116Yn);
        this.A02 = o3;
        o3.setFullCircleCorners(true);
        int i = A04;
        LinearLayout.LayoutParams pageImageViewParams = new LinearLayout.LayoutParams(i, i);
        pageImageViewParams.setMargins(0, 0, A05, 0);
        addView(this.A02, pageImageViewParams);
        LinearLayout pageInfoView = new LinearLayout(c1116Yn);
        pageInfoView.setOrientation(1);
        this.A00 = new TextView(c1116Yn);
        ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        AbstractC0783Lo.A0X(this.A00, true, 16);
        this.A00.setEllipsize(TextUtils.TruncateAt.END);
        this.A00.setSingleLine(true);
        TextView textView = new TextView(c1116Yn);
        this.A01 = textView;
        AbstractC0783Lo.A0X(textView, false, 14);
        pageInfoView.addView(this.A00);
        pageInfoView.addView(this.A01);
        addView(pageInfoView, layoutParams);
    }

    public final void A01() {
        this.A02.setImageBitmap(null);
        this.A00.setText("");
        this.A01.setText("");
    }

    public final void A02(int i, int i5) {
        this.A00.setTextColor(i);
        this.A01.setTextColor(i5);
    }

    public void setPageDetails(C02911a c02911a) {
        AsyncTaskC0993Tq asyncTaskC0993Tq = new AsyncTaskC0993Tq(this.A02, this.A03);
        int i = A04;
        asyncTaskC0993Tq.A05(i, i);
        asyncTaskC0993Tq.A07(c02911a.A01());
        this.A00.setText(c02911a.A02());
        this.A01.setText(c02911a.A03());
    }
}
