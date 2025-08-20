package com.facebook.ads.redexgen.X;

import android.os.Bundle;
import com.facebook.ads.AdError;
import com.facebook.ads.InterstitialAdExtendedListener;
import com.uv.v7.R;
import java.util.Arrays;
/* renamed from: com.facebook.ads.redexgen.X.aH  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C1169aH extends C2I implements InterstitialAdExtendedListener {
    public static byte[] A01;
    public final C1181aT A00;

    static {
        A01();
    }

    public static String A00(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] - i6) - 77);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{-68, -63, -57, -46, -72, -59, -59, -62, -59, -46, -74, -62, -73, -72, -46, -66, -72, -52, -103, -100, -101, -108, -84, -106, -101, -93, -114, -103, -106, -111, -114, -95, -106, -100, -101, -84, -95, -106, -102, -110, -84, -104, -110, -90, 15, 16, 14, 27, 1, 14, 14, 11, 14, 27, 9, 1, 15, 15, -3, 3, 1, 27, 7, 1, 21};
    }

    public C1169aH(String str, C2K c2k, C1181aT c1181aT) {
        super(str, c2k);
        this.A00 = c1181aT;
    }

    public final void onAdClicked(com.facebook.ads.Ad ad2) {
        super.A00.ACJ(1024, this.A01, null);
    }

    public final void onAdLoaded(com.facebook.ads.Ad ad2) {
        Bundle bundle = new Bundle();
        bundle.putLong(A00(18, 26, 0), this.A00.A0D());
        super.A00.ACJ(1020, this.A01, bundle);
    }

    public final void onError(com.facebook.ads.Ad ad2, AdError adError) {
        Bundle bundle = new Bundle();
        bundle.putString(A00(44, 21, R.styleable.AppCompatTheme_textColorSearchUrl), adError.getErrorMessage());
        bundle.putInt(A00(0, 18, 38), adError.getErrorCode());
        super.A00.ACJ(1023, this.A01, bundle);
    }

    public final void onInterstitialActivityDestroyed() {
        super.A00.ACJ(1026, this.A01, null);
    }

    public final void onInterstitialDismissed(com.facebook.ads.Ad ad2) {
        super.A00.ACJ(1022, this.A01, null);
    }

    public final void onInterstitialDisplayed(com.facebook.ads.Ad ad2) {
        super.A00.ACJ(1021, this.A01, null);
    }

    public final void onLoggingImpression(com.facebook.ads.Ad ad2) {
        super.A00.ACJ(1025, this.A01, null);
    }

    public final void onRewardedAdCompleted() {
        super.A00.ACJ(3000, this.A01, null);
    }

    public final void onRewardedAdServerFailed() {
        super.A00.ACJ(3002, this.A01, null);
    }

    public final void onRewardedAdServerSucceeded() {
        super.A00.ACJ(3001, this.A01, null);
    }
}
