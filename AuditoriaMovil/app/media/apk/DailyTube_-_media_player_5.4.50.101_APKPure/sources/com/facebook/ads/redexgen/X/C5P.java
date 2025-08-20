package com.facebook.ads.redexgen.X;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.facebook.ads.AdListener;
import com.facebook.ads.AdSize;
import com.facebook.ads.AdView;
import com.facebook.ads.ExtraHints;
import com.facebook.ads.internal.api.AdViewApi;
import com.facebook.ads.internal.api.AdViewParentApi;
import com.facebook.ads.internal.protocol.AdErrorType;
import com.facebook.ads.internal.protocol.AdPlacementType;
import com.uv.v7.R;
import java.util.Arrays;
import java.util.Locale;
/* renamed from: com.facebook.ads.redexgen.X.5P  reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public final class C5P implements AdViewApi {
    public static byte[] A0D;
    public static String[] A0E = {"of0bzA7MwNGTia9F31tAkieNA09H6OOQ", "TyTQj7xFBxvma6AaZ1TUwVS6lItsexiQ", "kN9yyhhGlFuDqh5wulKzoOOSsFZblOVu", "DXKKP4SSVuW5x9unPZpKCS00jdGSX4q", "ceBkREnsnDPWKQGMERGG6oDocc2kf8dJ", "ULZujO58Hn4sCnlurEwExiI5FfKtYml", "oBzM86F4GMvLYp6iWCqbmyfPVfF4ncm8", "8s2Qgj6JQYkd4IbFNTxV1lfTN5yJUxqm"};
    public long A00;
    public View A01;
    public AdListener A02;
    public FR A03;
    public C0827Ng A04;
    public String A05;
    public String A06;
    public final DisplayMetrics A07;
    public final AdView A08;
    public final AdViewParentApi A09;
    public final EQ A0A;
    public final EnumC0724Je A0B;
    public final String A0C;

    public static String A01(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A0D, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] - i6) - 64);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        byte[] bArr = {-76, -78, -75, -30, -71, -74, -70, -77, 120, 124, 126, -85, -86, 123, -90, 120, -13, 35, -17, -13, 35, 37, -14, -12, -17, 14, 27, 27, 18, 31, -51, 14, 17, -51, 17, 18, 32, 33, 31, 28, 38, 18, 17, -14, 17, 30, 30, 21, 34, -48, 17, 20, -48, 28, 31, 17, 20, -48, 34, 21, 33, 37, 21, 35, 36, 21, 20, -118, -88, -75, -75, -74, -69, 103, -83, -80, -75, -85, 103, -88, 103, -69, -84, -76, -73, -77, -88, -69, -84, 103, -69, -81, -88, -69, 103, -77, -74, -88, -85, 103, -87, -80, -85, 103, 110, 108, -70, 110, -77, -74, -91, -69, -52, -73, -20, -19, -5, -4, -6, -9, 1, -40, -37, -51, -48, -83, -48};
        if (A0E[2].charAt(11) != 'D') {
            throw new RuntimeException();
        }
        String[] strArr = A0E;
        strArr[7] = "i0zr3oWhaZ1ZQYjulO9yltnfKtDweGPM";
        strArr[6] = "f16HnFk6V4WfoRTY4RGQrwGHYb77b2mz";
        A0D = bArr;
    }

    static {
        A02();
    }

    public C5P(Context context, String str, AdSize adSize, AdViewParentApi adViewParentApi, AdView adView) {
        this.A00 = -1L;
        if (adSize != null && adSize != AdSize.INTERSTITIAL) {
            this.A07 = adView.getContext().getResources().getDisplayMetrics();
            EnumC0724Je A04 = L3.A04(adSize);
            this.A0B = A04;
            this.A0C = str;
            this.A09 = adViewParentApi;
            this.A08 = adView;
            EQ A08 = C03955c.A08(context);
            this.A0A = A08;
            A08.A0E().A2s(AdPlacementType.BANNER.toString(), str);
            C03111u c03111u = new C03111u(str, L3.A05(A04), AdPlacementType.BANNER, L3.A04(adSize), 1, new C1187aZ());
            c03111u.A06(this.A05);
            c03111u.A07(this.A06);
            FR fr = new FR(A08, c03111u);
            this.A03 = fr;
            fr.A0P(new ZQ(this));
            return;
        }
        throw new IllegalArgumentException(A01(108, 6, 18));
    }

    public C5P(Context context, String str, String str2, AdViewParentApi adViewParentApi, AdView adView) throws C0723Jc {
        this(context, str, A00(str2), adViewParentApi, adView);
        this.A0A.A0E().A3n();
    }

    public static AdSize A00(String str) throws C0723Jc {
        EnumC0726Jg template = C0731Jl.A00(str);
        if (template != null) {
            C0731Jl.A03(template);
            return L3.A01(template);
        }
        throw new C0723Jc(AdErrorType.BID_PAYLOAD_ERROR, String.format(Locale.US, A01(67, 41, 7), str));
    }

    private void A03(String str) {
        this.A00 = System.currentTimeMillis();
        if (str == null) {
            this.A0A.A0E().A2p();
        } else {
            this.A0A.A0E().A2o();
        }
        FR fr = this.A03;
        String[] strArr = A0E;
        if (strArr[3].length() != strArr[5].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A0E;
        strArr2[3] = "8EJDtH9EjlwutgZO3WtzB3nx702AY4O";
        strArr2[5] = "dTiKD7UwUCw1SvcKYJrEphBgoR9CLtC";
        if (fr != null) {
            fr.A0T(str);
        }
        this.A0A.A0E().A2n();
    }

    public final long A04() {
        return this.A00;
    }

    public final DisplayMetrics A05() {
        return this.A07;
    }

    public final AdListener A06() {
        return this.A02;
    }

    public final AdView A07() {
        return this.A08;
    }

    public final FR A08() {
        return this.A03;
    }

    public final EQ A09() {
        return this.A0A;
    }

    public final EnumC0724Je A0A() {
        return this.A0B;
    }

    public final void A0B(RelativeLayout relativeLayout, View view) {
        C0896Px A01;
        this.A0A.A0E().A40(this.A06 != null);
        String str = this.A06;
        if (str != null && (A01 = AbstractC0895Pw.A01(this.A0A, str)) != null) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            relativeLayout.addView(A01, new RelativeLayout.LayoutParams(layoutParams.width, layoutParams.height));
        }
    }

    public final void A0C(AdListener adListener) {
        this.A0A.A0E().A2l(adListener != null);
        this.A02 = adListener;
    }

    public final void A0D(C0827Ng c0827Ng) {
        this.A04 = c0827Ng;
    }

    public final AdView.AdViewLoadConfigBuilder buildLoadAdConfig() {
        return new JG(this);
    }

    public final void destroy() {
        AbstractC0735Jp.A05(A01(R.styleable.AppCompatTheme_tooltipForegroundColor, 7, 72), A01(24, 19, 109), A01(0, 8, 65));
        this.A0A.A0E().A2t();
        FR fr = this.A03;
        if (fr != null) {
            fr.A0V(true);
            this.A03 = null;
        }
        if (Build.VERSION.SDK_INT >= 18 && this.A04 != null && C0705Ih.A11(this.A08.getContext())) {
            C0827Ng c0827Ng = this.A04;
            String[] strArr = A0E;
            if (strArr[3].length() != strArr[5].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0E;
            strArr2[7] = "fmi4ltQko56R0Ot1hIU3uMuoiOam3SD1";
            strArr2[6] = "7H1g3sSDF1cZj7eOXlokIXc1uirRZwhG";
            c0827Ng.A07();
            View view = this.A01;
            if (view != null) {
                view.getOverlay().remove(this.A04);
            }
        }
        this.A08.removeAllViews();
        this.A01 = null;
        this.A02 = null;
    }

    public final String getPlacementId() {
        return this.A0C;
    }

    public final boolean isAdInvalidated() {
        FR fr = this.A03;
        boolean z2 = fr == null || fr.A0W();
        this.A0A.A0E().A4s(z2);
        return z2;
    }

    public final void loadAd() {
        AbstractC0735Jp.A05(A01(121, 6, 44), A01(43, 24, R.styleable.AppCompatTheme_toolbarNavigationButtonStyle), A01(16, 8, 127));
        A03(null);
    }

    public final void loadAd(AdView.AdViewLoadConfig adViewLoadConfig) {
        AbstractC0735Jp.A05(A01(121, 6, 44), A01(43, 24, R.styleable.AppCompatTheme_toolbarNavigationButtonStyle), A01(8, 8, 5));
        A03(((JG) adViewLoadConfig).A00());
    }

    public final void onConfigurationChanged(Configuration configuration) {
        this.A09.onConfigurationChanged(configuration);
        View view = this.A01;
        if (view != null) {
            AbstractC0728Ji.A01(this.A07, view, this.A0B);
        }
    }

    @Deprecated
    public final void setExtraHints(ExtraHints extraHints) {
        FR fr;
        this.A05 = extraHints.getHints();
        this.A06 = extraHints.getMediationData();
        if (C0705Ih.A0g(this.A0A) && (fr = this.A03) != null) {
            fr.A07.A06(this.A05);
            this.A03.A07.A07(this.A06);
        }
    }
}
