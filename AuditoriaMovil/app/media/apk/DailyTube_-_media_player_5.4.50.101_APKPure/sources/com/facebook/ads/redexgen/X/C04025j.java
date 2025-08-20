package com.facebook.ads.redexgen.X;

import android.content.Context;
import com.facebook.ads.NativeAdScrollView;
import com.facebook.ads.NativeAdView;
import com.facebook.ads.NativeAdViewAttributes;
import com.facebook.ads.NativeAdsManager;
import com.facebook.ads.internal.api.NativeAdScrollViewApi;
import java.util.Arrays;
/* renamed from: com.facebook.ads.redexgen.X.5j  reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C04025j implements NativeAdScrollViewApi {
    public static byte[] A07;
    public final int A00;
    public final NativeAdScrollView.AdViewProvider A01;
    public final NativeAdView.Type A02;
    public final NativeAdViewAttributes A03;
    public final NativeAdsManager A04;
    public final ZE A05;
    public final C1116Yn A06;

    static {
        A07();
    }

    public static String A06(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A07, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] - i6) - 33);
        }
        return new String(copyOfRange);
    }

    public static void A07() {
        A07 = new byte[]{-61, -21, -23, -22, -106, -26, -24, -27, -20, -33, -38, -37, -106, -41, -106, -60, -41, -22, -33, -20, -37, -73, -38, -52, -33, -37, -19, -92, -54, -17, -26, -37, -94, -106, -73, -38, -52, -33, -37, -19, -58, -24, -27, -20, -33, -38, -37, -24, -106, -27, -24, -106, -41, -106, -28, -41, -22, -33, -20, -37, -73, -38, -52, -33, -37, -19, -66, -37, -33, -35, -34, -22, -70, -26, -106, -87, -68, -79, -66, -83, -119, -84, -69, -107, -87, -74, -87, -81, -83, -70, 104, -74, -73, -68, 104, -76, -73, -87, -84, -83, -84};
    }

    public C04025j(NativeAdScrollView nativeAdScrollView, Context context, NativeAdsManager nativeAdsManager, NativeAdScrollView.AdViewProvider adViewProvider, int i, NativeAdView.Type type, NativeAdViewAttributes nativeAdViewAttributes, int i5) {
        if (nativeAdsManager.isLoaded()) {
            if (type != null || adViewProvider != null || i > 0) {
                this.A06 = C03955c.A03(context);
                this.A04 = nativeAdsManager;
                this.A03 = nativeAdViewAttributes;
                this.A01 = adViewProvider;
                this.A02 = type;
                this.A00 = i5;
                ZF zf2 = new ZF(this);
                ZE ze = new ZE(context);
                this.A05 = ze;
                if (type == null) {
                    if (i > 0) {
                        ze.A00(((int) LD.A02) * i);
                    }
                } else {
                    ze.A00((int) (LD.A02 * type.getHeight()));
                }
                ze.setAdapter(zf2);
                setInset(20);
                zf2.A09();
                nativeAdScrollView.addView(ze);
                return;
            }
            throw new IllegalArgumentException(A06(0, 74, 85));
        }
        throw new IllegalStateException(A06(74, 27, 39));
    }

    public final void setInset(int i) {
        if (i > 0) {
            float f4 = LD.A02;
            float density = i;
            int insetDp = Math.round(density * f4);
            this.A05.setPadding(insetDp, 0, insetDp, 0);
            float density2 = i / 2;
            this.A05.setPageMargin(Math.round(density2 * f4));
            this.A05.setClipToPadding(false);
        }
    }
}
