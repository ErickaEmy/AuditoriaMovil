package com.facebook.ads.redexgen.X;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.ads.AdOptionsView;
import com.facebook.ads.NativeAd;
/* loaded from: assets/audience_network.dex */
public final class QC extends LinearLayout {
    public static final int A00 = (int) (LD.A02 * 32.0f);
    public static final int A01 = (int) (LD.A02 * 8.0f);

    public QC(C1116Yn c1116Yn, NativeAd nativeAd, JR jr, O3 o3, AdOptionsView adOptionsView) {
        super(c1116Yn);
        setOrientation(0);
        o3.setFullCircleCorners(true);
        int i = A00;
        LinearLayout.LayoutParams iconViewParams = new LinearLayout.LayoutParams(i, i);
        iconViewParams.gravity = 16;
        iconViewParams.setMargins(0, 0, A01, 0);
        addView(o3, iconViewParams);
        TextView textView = new TextView(c1116Yn);
        jr.A08(textView);
        textView.setMaxLines(1);
        textView.setText(nativeAd.getAdvertiserName());
        TextView sponsoredTextView = new TextView(c1116Yn);
        jr.A06(sponsoredTextView);
        sponsoredTextView.setMaxLines(1);
        sponsoredTextView.setText(nativeAd.getSponsoredTranslation());
        LinearLayout linearLayout = new LinearLayout(c1116Yn);
        linearLayout.setOrientation(1);
        LinearLayout.LayoutParams iconViewParams2 = new LinearLayout.LayoutParams(0, -2);
        iconViewParams2.weight = 1.0f;
        iconViewParams2.gravity = 16;
        LinearLayout.LayoutParams textContainerParams = new LinearLayout.LayoutParams(-1, -2);
        linearLayout.addView(textView, textContainerParams);
        LinearLayout.LayoutParams textContainerParams2 = new LinearLayout.LayoutParams(-1, -2);
        linearLayout.addView(sponsoredTextView, textContainerParams2);
        addView(linearLayout, iconViewParams2);
        LinearLayout.LayoutParams textContainerParams3 = new LinearLayout.LayoutParams(-2, -2);
        addView((View) adOptionsView, (ViewGroup.LayoutParams) textContainerParams3);
    }
}
