package com.facebook.ads.redexgen.X;

import android.widget.RelativeLayout;
import java.util.HashMap;
/* renamed from: com.facebook.ads.redexgen.X.Ns  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public abstract class AbstractC0839Ns {
    /* JADX WARN: Type inference failed for: r0v0, types: [com.facebook.ads.redexgen.X.3n] */
    public static C03563n A00(final OP op, final V2 v2, final String str, final BQ bq) {
        return new BK(op, v2, true, str, bq) { // from class: com.facebook.ads.redexgen.X.3n
            public View$OnClickListenerC0988Tl A00;
            public C0888Pp A01;
            public final J2 A02 = this.A0I.A05().A01().A09();
            public final V2 A03;
            public final BQ A04;
            public final String A05;
            public static final int A07 = (int) (LD.A02 * (-4.0f));
            public static final int A06 = (int) (LD.A02 * 6.0f);

            {
                this.A03 = v2;
                this.A05 = str;
                this.A04 = bq;
                v2.A1K(this);
            }

            @Override // com.facebook.ads.redexgen.X.TS
            public void setupNativeCtaExtension(C0888Pp c0888Pp) {
                C1U A0y;
                this.A01 = c0888Pp;
                int A0M = C0705Ih.A0M(this.A0I.A05());
                C1P A01 = this.A03.A0z().A0w().A01();
                C1116Yn A05 = this.A0I.A05();
                String A0L = this.A03.A0z().A0L();
                J2 j2 = this.A02;
                MC dummyListener = NW.getDummyListener();
                RE A0b = this.A04.A0b();
                C0775Lg A19 = this.A03.A19();
                if (this.A03.A0z() == null) {
                    A0y = null;
                } else {
                    A0y = this.A03.A0z().A0y();
                }
                View$OnClickListenerC0988Tl view$OnClickListenerC0988Tl = new View$OnClickListenerC0988Tl(A05, A0L, A01, j2, dummyListener, A0b, A19, A0y);
                this.A00 = view$OnClickListenerC0988Tl;
                view$OnClickListenerC0988Tl.setCta(c0888Pp.A03().A0F(), this.A05, new HashMap());
                this.A03.A1K(this.A00);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                if (A0M == 1) {
                    layoutParams.addRule(12);
                    AbstractC0783Lo.A0P(this.A00, A06, 5, A01.A09(false));
                    ((BK) this).A06.addView(this.A00, layoutParams);
                } else if (A0M != 2) {
                } else {
                    layoutParams.addRule(3, ((BK) this).A06.getId());
                    int extensionVariant = A07;
                    layoutParams.setMargins(0, extensionVariant, 0, 0);
                    addView(this.A00, 0, layoutParams);
                    ((BK) this).A06.bringToFront();
                }
            }
        };
    }
}
