package com.facebook.ads.redexgen.X;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import java.util.Arrays;
/* loaded from: assets/audience_network.dex */
public final class BJ extends AbstractC0983Tg {
    public static byte[] A02;
    public static final int A03;
    public final View A00;
    public final boolean A01;

    public static String A00(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A02, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] - i6) - 101);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A02 = new byte[]{-24, -20, -32, -26, -28};
    }

    static {
        A01();
        A03 = Resources.getSystem().getDisplayMetrics().widthPixels;
    }

    public BJ(OP op, boolean z2) {
        super(op, true);
        this.A01 = z2;
        View A022 = op.A02();
        this.A00 = A022;
        A14();
        if (z2) {
            addView(op.A02(), new RelativeLayout.LayoutParams(-1, -1));
        } else {
            FrameLayout frameLayout = new FrameLayout(op.A05());
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(2, getAdDetailsView().getId());
            frameLayout.setLayoutParams(layoutParams);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -2);
            layoutParams2.gravity = 17;
            layoutParams2.setMargins(OL.A07, 0, OL.A07, 0);
            frameLayout.addView(A022, layoutParams2);
            addView(frameLayout);
        }
        OF A09 = this.A07.A09(getAdDataBundle());
        op.A05().A0F().A00(A09.A01);
        if (A022 != null) {
            if (A09.A00) {
                getCtaButton().setCreativeAsCtaLoggingHelper(this.A07);
                A022.setOnClickListener(new View.OnClickListener() { // from class: com.facebook.ads.redexgen.X.OQ
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        BJ.this.A15(view);
                    }
                });
            } else if (C0705Ih.A16(getAdContextWrapper())) {
                AbstractC0832Nl.A00(A022, C0705Ih.A17(getAdContextWrapper()), new OR(this));
            }
        }
        getAdDetailsView().bringToFront();
    }

    @Override // com.facebook.ads.redexgen.X.OL
    public final boolean A02() {
        return this.A01 && super.A02();
    }

    @Override // com.facebook.ads.redexgen.X.OL
    public final boolean A0D() {
        return this.A01 && super.A02();
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0983Tg, com.facebook.ads.redexgen.X.OL
    public final void A10(C1G c1g, String str, double d2, Bundle bundle) {
        super.A10(c1g, str, d2, bundle);
        if (!this.A01 && d2 > 0.0d) {
            int mediaHeight = (int) ((A03 - (OL.A07 * 2)) / d2);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, mediaHeight);
            layoutParams.gravity = 17;
            int i = OL.A07;
            int mediaHeight2 = OL.A07;
            layoutParams.setMargins(i, 0, mediaHeight2, 0);
            this.A00.setLayoutParams(layoutParams);
        }
    }

    @Override // com.facebook.ads.redexgen.X.OL
    public final boolean A11() {
        return this.A01;
    }

    public final /* synthetic */ void A15(View view) {
        getCtaButton().A09(A00(0, 5, 26));
    }
}
