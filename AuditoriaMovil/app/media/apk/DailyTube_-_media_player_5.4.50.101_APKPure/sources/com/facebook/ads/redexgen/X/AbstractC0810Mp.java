package com.facebook.ads.redexgen.X;

import com.facebook.ads.NativeAdLayout;
/* renamed from: com.facebook.ads.redexgen.X.Mp  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public abstract class AbstractC0810Mp {
    public static String[] A00 = {"Mh7OQPY25mJ4xZdJdnJU4lIWxnSb2W80", "uMvQGqYS2R9kLiwAhxbB5gyg9uPLoFmG", "JD8RnvPxGeaTxsc34jN0O6vhnDfoaLvm", "v", "yiVoJ6", "bh6EDcFJy1WMlrC6ew5uNV", "HsXTYL", "k"};
    public static final int A01 = (int) (LD.A02 * 200.0f);
    public static final int A03 = (int) (LD.A02 * 200.0f);
    public static final int A02 = (int) (LD.A02 * 50.0f);

    public static AnonymousClass13 A00(NativeAdLayout nativeAdLayout) {
        if (nativeAdLayout == null) {
            return AnonymousClass13.A05;
        }
        if (A03(nativeAdLayout)) {
            return AnonymousClass13.A06;
        }
        return AnonymousClass13.A04;
    }

    public static AbstractC0809Mo A01(C1116Yn c1116Yn, J2 j2, String str, NativeAdLayout nativeAdLayout) {
        if (nativeAdLayout == null) {
            return null;
        }
        int h = nativeAdLayout.getWidth();
        int w4 = nativeAdLayout.getHeight();
        int i = A01;
        if (h >= i && w4 >= i) {
            return new U4(c1116Yn, j2, str);
        }
        if (h < A03 || w4 < A02) {
            return null;
        }
        return new U5(c1116Yn, j2, str);
    }

    public static U6 A02(C1116Yn c1116Yn, J2 j2, String str, C02911a c02911a, MD md, MC mc2) {
        return new U6(c1116Yn, j2, str, c02911a, md, mc2);
    }

    public static boolean A03(NativeAdLayout nativeAdLayout) {
        int h = nativeAdLayout.getWidth();
        int height = nativeAdLayout.getHeight();
        int w4 = A01;
        if (h < w4 || height < w4) {
            if (h >= A03) {
                int i = A02;
                if (A00[5].length() != 22) {
                    throw new RuntimeException();
                }
                A00[5] = "hhrIY4o6fKEkU42z4UVpb3";
                if (height < i) {
                }
            }
            return true;
        }
        return false;
    }
}
