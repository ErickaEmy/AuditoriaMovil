package com.facebook.ads.redexgen.X;

import android.view.View;
/* renamed from: com.facebook.ads.redexgen.X.57  reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public abstract class AnonymousClass57 {
    public static String[] A00 = {"UqypfisWbLbbWLDfIVvpiaUsz0iS", "wEiCJDeLGzLJebV", "cX", "dRMEhdR7kDOm9Ob", "SmhGT229bW5LAFpAZzaxeRYqKvMDeGhX", "QcSoUKFtoryhyFMFYIfDI81ChPsDlMu7", "SBvSWfqovIH0ljTVzoffsyrdWCNw", "n"};

    public static int A00(AnonymousClass53 anonymousClass53, C4Y c4y, View view, View view2, AbstractC03824o abstractC03824o, boolean z2) {
        if (abstractC03824o.A0W() == 0 || anonymousClass53.A03() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z2) {
            return Math.abs(abstractC03824o.A0p(view) - abstractC03824o.A0p(view2)) + 1;
        }
        int A0C = c4y.A0C(view2);
        int A0F = c4y.A0F(view);
        String[] strArr = A00;
        if (strArr[4].charAt(28) != strArr[5].charAt(28)) {
            String[] strArr2 = A00;
            strArr2[3] = "xd2oZUwi45Npmqe";
            strArr2[1] = "1k2xoHfklbXXQiR";
            int extend = c4y.A0B();
            return Math.min(extend, A0C - A0F);
        }
        throw new RuntimeException();
    }

    public static int A01(AnonymousClass53 anonymousClass53, C4Y c4y, View view, View view2, AbstractC03824o abstractC03824o, boolean z2) {
        if (abstractC03824o.A0W() == 0 || anonymousClass53.A03() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z2) {
            return anonymousClass53.A03();
        }
        int A0C = c4y.A0C(view2) - c4y.A0F(view);
        int A0p = abstractC03824o.A0p(view);
        int laidOutArea = abstractC03824o.A0p(view2);
        float abs = A0C / (Math.abs(A0p - laidOutArea) + 1);
        int laidOutArea2 = anonymousClass53.A03();
        return (int) (abs * laidOutArea2);
    }

    public static int A02(AnonymousClass53 anonymousClass53, C4Y c4y, View view, View view2, AbstractC03824o abstractC03824o, boolean z2, boolean z3) {
        int laidOutArea;
        if (abstractC03824o.A0W() != 0) {
            int A03 = anonymousClass53.A03();
            String[] strArr = A00;
            if (strArr[3].length() != strArr[1].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A00;
            strArr2[6] = "xSzU3PMpL9LC7k2G9V08vNIV3nIP";
            strArr2[0] = "UsrmTbcEPDcBULmsiiLKltF5MwgK";
            if (A03 != 0 && view != null && view2 != null) {
                int maxPosition = Math.min(abstractC03824o.A0p(view), abstractC03824o.A0p(view2));
                int A0p = abstractC03824o.A0p(view);
                int minPosition = abstractC03824o.A0p(view2);
                int max = Math.max(A0p, minPosition);
                if (z3) {
                    int minPosition2 = anonymousClass53.A03();
                    laidOutArea = Math.max(0, (minPosition2 - max) - 1);
                } else {
                    laidOutArea = Math.max(0, maxPosition);
                }
                if (!z2) {
                    return laidOutArea;
                }
                int itemsBefore = c4y.A0C(view2);
                int minPosition3 = c4y.A0F(view);
                int maxPosition2 = Math.abs(itemsBefore - minPosition3);
                int itemsBefore2 = abstractC03824o.A0p(view);
                int minPosition4 = abstractC03824o.A0p(view2);
                float abs = laidOutArea * (maxPosition2 / (Math.abs(itemsBefore2 - minPosition4) + 1));
                int itemsBefore3 = c4y.A0A();
                int minPosition5 = c4y.A0F(view);
                return Math.round(abs + (itemsBefore3 - minPosition5));
            }
        }
        return 0;
    }
}
