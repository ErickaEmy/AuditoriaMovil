package com.facebook.ads.redexgen.X;
/* loaded from: assets/audience_network.dex */
public abstract class OI {
    public static float A00(C1G c1g) {
        int height = c1g.A0D().A01();
        int width = c1g.A0D().A00();
        if (width > 0) {
            return height / width;
        }
        return -1.0f;
    }

    public static int A01(double d2) {
        int availableWidth = (int) ((LC.A00().widthPixels - (OL.A07 * 2)) / d2);
        return availableWidth;
    }

    public static int A02(int bottomMargin) {
        int ctaMargin = AbstractC0783Lo.A01(16);
        int ctaTextHeight = AbstractC0842Nv.A0A;
        int ctaSpacing = ctaTextHeight * 2;
        int ctaTextHeight2 = OL.A07;
        int ctaMargin2 = ctaMargin + ctaSpacing + (ctaTextHeight2 * 2);
        int ctaTextHeight3 = LC.A00().heightPixels;
        return (ctaTextHeight3 - bottomMargin) - ctaMargin2;
    }

    public static OH A03(View$OnClickListenerC0988Tl view$OnClickListenerC0988Tl, String str) {
        return new OH(view$OnClickListenerC0988Tl, str);
    }

    public static boolean A04(double d2) {
        return d2 < 0.9d;
    }

    public static boolean A05(double d2, int i) {
        return A02(i) < A01(d2);
    }

    public static boolean A06(int i, int i5, double d2) {
        return i == 2 || A05(d2, i5);
    }
}
