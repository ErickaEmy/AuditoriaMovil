package com.facebook.ads.redexgen.X;

import android.content.Intent;
import android.net.Uri;
import android.util.AttributeSet;
import android.util.Log;
import com.facebook.ads.NativeAd;
import com.facebook.ads.internal.protocol.AdErrorType;
import com.facebook.ads.internal.settings.AdInternalSettings;
import com.facebook.ads.internal.util.activity.AdActivityIntent;
import com.uv.v7.R;
import java.util.Arrays;
import java.util.UUID;
/* renamed from: com.facebook.ads.redexgen.X.Ba  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C0536Ba extends SA {
    public static byte[] A0F;
    public static final String A0G;
    public Uri A00;
    public NativeAd A01;
    public J2 A02;
    public MP A03;
    public SF A04;
    public C9I A05;
    public String A06;
    public String A07;
    public String A08;
    public final C1A A09;
    public final C1116Yn A0A;
    public final AbstractC0893Pu A0B;
    public final AbstractC0860On A0C;
    public final O7 A0D;
    public final String A0E;

    public static String A01(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A0F, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] - i6) - 17);
        }
        return new String(copyOfRange);
    }

    public static void A03() {
        A0F = new byte[]{122, -104, -91, 94, -85, 87, -86, -85, -104, -87, -85, 87, 120, -84, -101, -96, -100, -91, -102, -100, -123, -100, -85, -82, -90, -87, -94, 120, -102, -85, -96, -83, -96, -85, -80, 101, 87, -124, -104, -94, -100, 87, -86, -84, -87, -100, 87, -85, -97, -104, -85, 87, -96, -85, 94, -86, 87, -96, -91, 87, -80, -90, -84, -87, 87, 120, -91, -101, -87, -90, -96, -101, -124, -104, -91, -96, -99, -100, -86, -85, 101, -81, -92, -93, 87, -99, -96, -93, -100, 101, -77, -32, -32, -35, -32, -88, -114, 109, 105, 104, -100, -117, -112, -116, -107, -118, -116, 117, -116, -101, -98, -106, -103, -110, 113, -103, -105, -104, 68, -105, -119, -104, 103, -112, -115, -119, -110, -104, 120, -109, -113, -119, -110, 68, -118, -115, -106, -105, -104, 113, -103, -105, -104, 68, -105, -119, -104, 122, -115, -120, -119, -109, 121, 118, 109, 68, -109, -106, 68, -105, -119, -104, 122, -115, -120, -119, -109, 113, 116, 104, 68, -118, -115, -106, -105, -104, -16, -3, -18, -16, -14, 3, -8, 5, -8, 3, 8, -80, -71, -74, -78, -69, -63, -95, -68, -72, -78, -69, -7, -22, -5, -4, -14, -9, -16, -107, -105, -118, -119, -118, -117, -114, -109, -118, -119, 116, -105, -114, -118, -109, -103, -122, -103, -114, -108, -109, 112, -118, -98, -48, -55, -60, -52, -48, -64, -92, -65, -39, -41, -55, -78, -59, -40, -51, -38, -55, -89, -40, -59, -90, -39, -40, -40, -45, -46, -41, -54, -59, -58, -48, -83, -48, -56, -56, -58, -45, -22, -35, -40, -39, -29, -63, -60, -72, -120, 123, 118, 119, -127, 101, 119, 119, 125, 102, 123, Byte.MAX_VALUE, 119, -40, -53, -58, -57, -47, -73, -76, -82, -3, -16, -21, -20, -10, -26, -5, -16, -12, -20, -26, -9, -10, -13, -13, -16, -11, -18, -26, -16, -11, -5, -20, -7, -3, -24, -13, -87, -100, -104, -86, -121, -84, -93, -104};
    }

    static {
        A03();
        A0G = C0536Ba.class.getSimpleName();
    }

    public C0536Ba(C1116Yn c1116Yn) {
        super(c1116Yn);
        this.A0E = UUID.randomUUID().toString();
        this.A0D = new C0541Bf(this);
        this.A0C = new C0540Be(this);
        this.A0B = new C0539Bd(this);
        this.A09 = new C1A(this, c1116Yn);
        this.A0A = c1116Yn;
        A02();
    }

    public C0536Ba(C1116Yn c1116Yn, AttributeSet attributeSet) {
        super(c1116Yn, attributeSet);
        this.A0E = UUID.randomUUID().toString();
        this.A0D = new C0541Bf(this);
        this.A0C = new C0540Be(this);
        this.A0B = new C0539Bd(this);
        this.A09 = new C1A(this, c1116Yn);
        this.A0A = c1116Yn;
        A02();
    }

    public C0536Ba(C1116Yn c1116Yn, AttributeSet attributeSet, int i) {
        super(c1116Yn, attributeSet, i);
        this.A0E = UUID.randomUUID().toString();
        this.A0D = new C0541Bf(this);
        this.A0C = new C0540Be(this);
        this.A0B = new C0539Bd(this);
        this.A09 = new C1A(this, c1116Yn);
        this.A0A = c1116Yn;
        A02();
    }

    private void A02() {
        getEventBus().A03(this.A0D, this.A0C, this.A0B);
    }

    private void A04(Intent intent) {
        if (this.A05 == null) {
            A05(A01(R.styleable.AppCompatTheme_tooltipForegroundColor, 25, 19));
        } else if (this.A00 == null && this.A08 == null) {
            A05(A01(139, 37, 19));
        } else {
            intent.putExtra(A01(237, 18, 83), this.A07);
            intent.putExtra(A01(322, 8, 34), KB.A09);
            intent.putExtra(A01(287, 8, 81), this.A00.toString());
            String str = this.A06;
            if (str == null) {
                str = A01(0, 0, 39);
            }
            intent.putExtra(A01(187, 11, 60), str);
            intent.putExtra(A01(266, 8, 99), this.A08);
            intent.putExtra(A01(205, 24, 20), LD.A00(this.A0A));
            intent.putExtra(A01(274, 13, 1), getCurrentPositionInMillis());
            intent.putExtra(A01(229, 8, 74), this.A0E);
            intent.putExtra(A01(255, 11, 80), this.A05.A0X());
            intent.putExtra(A01(295, 27, 118), getVideoProgressReportIntervalMs());
            intent.addFlags(268435456);
        }
    }

    private void A05(String str) {
        this.A0A.A07().A9a(A01(198, 7, 120), C8A.A28, new C8B(AdErrorType.PARSER_FAILURE.getDefaultErrorMessage(), A01(90, 7, 93) + str));
        if (AdInternalSettings.isDebugBuild()) {
            Log.w(A0G, str);
        }
    }

    public final void A0m() {
        NativeAd nativeAd = this.A01;
        if (nativeAd != null) {
            nativeAd.onCtaBroadcast();
        }
    }

    public final void A0n() {
        AdActivityIntent A04 = C0754Kj.A04(this.A0A);
        A04(A04);
        try {
            A0e(false, 6);
            setVisibility(8);
            C0754Kj.A0A(this.A0A, A04);
        } catch (Exception e2) {
            this.A0A.A07().A9a(A01(176, 11, 126), C8A.A0D, new C8B(e2));
            Log.e(A01(97, 17, 22), A01(0, 90, 38), e2);
        }
    }

    public MP getListener() {
        return this.A03;
    }

    public String getUniqueId() {
        return this.A0E;
    }

    @Override // com.facebook.ads.redexgen.X.SA, android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.A09.A02();
    }

    @Override // com.facebook.ads.redexgen.X.SA, android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        this.A09.A03();
        super.onDetachedFromWindow();
    }

    public void setAdEventManager(J2 j2) {
        this.A02 = j2;
    }

    public void setClientToken(String str) {
        C9I c9i;
        SF sf = this.A04;
        if (sf != null) {
            sf.A0C();
        }
        C9I c9i2 = this.A05;
        if (c9i2 != null) {
            c9i2.A0i();
        }
        this.A06 = str;
        SF sf2 = null;
        if (str != null) {
            c9i = new C9I(this.A0A, this.A02, this, str);
        } else {
            c9i = null;
        }
        this.A05 = c9i;
        if (c9i != null && C0705Ih.A1X(this.A0A)) {
            if (str != null) {
                sf2 = new SF(this.A0A, this.A02, this, str, this.A05, null);
            }
            this.A04 = sf2;
            return;
        }
        this.A04 = null;
    }

    public void setEnableBackgroundVideo(boolean z2) {
        super.A0D.setBackgroundPlaybackEnabled(z2);
    }

    public void setListener(MP mp2) {
        this.A03 = mp2;
    }

    public void setNativeAd(NativeAd nativeAd) {
        this.A01 = nativeAd;
    }

    public void setVideoCTA(String str) {
        this.A07 = str;
    }

    @Override // com.facebook.ads.redexgen.X.SA
    public void setVideoMPD(String str) {
        if (str != null && this.A05 == null) {
            A05(A01(R.styleable.AppCompatTheme_tooltipForegroundColor, 25, 19));
            return;
        }
        this.A08 = str;
        super.setVideoMPD(str);
    }

    @Override // com.facebook.ads.redexgen.X.SA
    public void setVideoURI(Uri uri) {
        if (uri != null && this.A05 == null) {
            A05(A01(R.styleable.AppCompatTheme_tooltipForegroundColor, 25, 19));
            return;
        }
        this.A00 = uri;
        super.setVideoURI(uri);
    }
}
