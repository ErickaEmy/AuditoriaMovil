package com.facebook.ads.redexgen.X;

import android.os.Bundle;
import com.facebook.ads.AdError;
import com.facebook.ads.S2SRewardedVideoAdExtendedListener;
import com.uv.v7.R;
import java.util.Arrays;
/* renamed from: com.facebook.ads.redexgen.X.aG  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C1168aG extends C2I implements S2SRewardedVideoAdExtendedListener {
    public static byte[] A02;
    public final C1178aQ A00;
    public final C2F A01;

    static {
        A01();
    }

    public static String A00(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A02, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] ^ i6) ^ 24);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A02 = new byte[]{103, 96, 122, 113, 107, 124, 124, 97, 124, 113, 109, 97, 106, 107, 113, 101, 107, 119, 34, 37, 63, 52, 57, 61, 52, 61, 34, 47, 46, 36, 52, 47, 62, 57, 42, 63, 34, 36, 37, 52, 32, 46, 50, 62, 61, 60, 53, 45, 59, 60, 36, 51, 62, 59, 54, 51, 38, 59, 61, 60, 45, 38, 59, 63, 55, 45, 57, 55, 43, 74, 77, 75, 70, 92, 75, 75, 86, 75, 70, 84, 92, 74, 74, 88, 94, 92, 70, 82, 92, 64};
    }

    public C1168aG(String str, C2K c2k, C1178aQ c1178aQ, C2F c2f) {
        super(str, c2k);
        this.A00 = c1178aQ;
        this.A01 = c2f;
    }

    public final void onAdClicked(com.facebook.ads.Ad ad2) {
        super.A00.ACJ(2104, super.A01, null);
    }

    public final void onAdLoaded(com.facebook.ads.Ad ad2) {
        Bundle bundle = new Bundle();
        bundle.putLong(A00(43, 26, R.styleable.AppCompatTheme_textAppearancePopupMenuHeader), this.A00.A0F());
        bundle.putInt(A00(18, 25, R.styleable.AppCompatTheme_tooltipFrameBackground), this.A01.A00);
        super.A00.ACJ(2100, super.A01, bundle);
    }

    public final void onError(com.facebook.ads.Ad ad2, AdError adError) {
        Bundle bundle = new Bundle();
        bundle.putString(A00(69, 21, 1), adError.getErrorMessage());
        bundle.putInt(A00(0, 18, 54), adError.getErrorCode());
        super.A00.ACJ(2103, super.A01, bundle);
    }

    public final void onLoggingImpression(com.facebook.ads.Ad ad2) {
        super.A00.ACJ(2105, super.A01, null);
    }

    public final void onRewardServerFailed() {
        super.A00.ACJ(3002, super.A01, null);
    }

    public final void onRewardServerSuccess() {
        super.A00.ACJ(3001, super.A01, null);
    }

    public final void onRewardedVideoActivityDestroyed() {
        super.A00.ACJ(2106, super.A01, null);
    }

    public final void onRewardedVideoClosed() {
        super.A00.ACJ(2110, super.A01, null);
    }

    public final void onRewardedVideoCompleted() {
        super.A00.ACJ(3000, super.A01, null);
    }
}
