package com.facebook.ads.redexgen.X;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.ads.MediaViewVideoRenderer;
import com.facebook.ads.NativeAd;
import com.facebook.ads.VideoAutoplayBehavior;
import com.facebook.ads.VideoStartReason;
import com.facebook.ads.internal.api.AdComponentViewApi;
import com.facebook.ads.internal.api.AdViewConstructorParams;
import com.facebook.ads.internal.api.MediaViewVideoRendererApi;
import com.facebook.ads.internal.settings.AdInternalSettings;
import java.util.Arrays;
/* renamed from: com.facebook.ads.redexgen.X.5h  reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C04005h implements MediaViewVideoRendererApi {
    public static byte[] A0G;
    public static String[] A0H = {"Ds1OlE9QLNwB", "aoTFD1mdY9qS2iG1b6xBMIzf9BXXSrYm", "osndMvDCAJCV1YpU", "nBivoQhUG9UhcV9idWewaYAmGQw5UcJS", "JB025Vwse6xgHKaH4PdlPsgjNbTaZijW", "Rr8Hg5ZtJOltbAd8rryGswWrdJNm13cq", "EfdUYpEvlCzoAxPYZB8PQhxNy", "DXUiKhR"};
    public static final String A0I;
    public MediaViewVideoRenderer A00;
    public VideoAutoplayBehavior A01;
    public C1116Yn A03;
    public JM A04;
    public C0536Ba A05;
    public boolean A06;
    public boolean A07;
    public NativeAd A08;
    public final NX A0D = new EY(this);
    public final O7 A0C = new EX(this);
    public final AbstractC0860On A0B = new EW(this);
    public final AbstractC0801Mg A0E = new EV(this);
    public final AbstractC0893Pu A09 = new EU(this);
    public final MV A0F = new ET(this);
    public final AbstractC0891Ps A0A = new ES(this);
    public C03935a A02 = new C03935a();

    public static String A01(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A0G, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] - i6) - 124);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A0G = new byte[]{-30, 7, 15, -6, 5, 2, -3, -71, -17, 2, -2, 16, -71, -4, 8, 7, 12, 13, 11, 14, -4, 13, 8, 11, -71, 9, -6, 11, -6, 6, 12, -71, 13, 18, 9, -2, -57, -34, -16, -16, -10, -12, -7, -14, -85, -8, 0, -2, -1, -85, -19, -16, -85, -5, -3, -16, -18, -16, -17, -16, -17, -85, -19, 4, -85, -20, -85, -18, -20, -9, -9, -85, -1, -6, -85, -16, -7, -14, -20, -14, -16, -34, -16, -16, -10, -73, -85, -20, -7, -17, -85, -15, -6, -9, -9, -6, 2, -16, -17, -85, -19, 4, -85, -20, -85, -18, -20, -9, -9, -85, -1, -6, -85, -17, -12, -2, -16, -7, -14, -20, -14, -16, -34, -16, -16, -10, -71, -27, -22, -12, -26, -17, -24, -30, -24, -26, -44, -26, -26, -20, -95, -28, -30, -19, -19, -26, -27, -95, -8, -22, -11, -23, -16, -10, -11, -95, -26, -17, -24, -30, -24, -26, -44, -26, -26, -20, -81, 74, 83, 76, 70, 76, 74, 56, 74, 74, 80, 5, 72, 70, 81, 81, 74, 73, 5, 92, 78, 89, 77, 84, 90, 89, 5, 73, 78, 88, 74, 83, 76, 70, 76, 74, 56, 74, 74, 80, 19};
    }

    static {
        A02();
        A0I = MediaViewVideoRenderer.class.getSimpleName();
    }

    public final void A03() {
        this.A00.pause(false);
        this.A05.setClientToken(null);
        this.A05.setVideoMPD(null);
        this.A05.setVideoURI((Uri) null);
        this.A05.setVideoCTA(null);
        this.A05.setNativeAd(null);
        this.A01 = VideoAutoplayBehavior.DEFAULT;
        NativeAd nativeAd = this.A08;
        if (nativeAd != null) {
            V2.A0L(nativeAd.getInternalNativeAd()).A1c(false, false);
        }
        this.A08 = null;
        JM jm = this.A04;
        if (jm != null) {
            jm.AGn();
        }
    }

    public final void A04(NativeAd nativeAd) {
        this.A08 = nativeAd;
        C1116Yn A11 = ((V2) nativeAd.getInternalNativeAd()).A11();
        C1116Yn adObjectContext = this.A03;
        adObjectContext.A0K(A11);
        C04015i c04015i = (C04015i) nativeAd.getNativeAdApi();
        this.A05.setClientToken(V2.A0L(nativeAd.getInternalNativeAd()).A1B());
        this.A05.setVideoMPD(c04015i.A01());
        this.A05.setVideoURI(c04015i.A02());
        C1234bK A0y = V2.A0L(nativeAd.getInternalNativeAd()).A0y();
        if (A0y != null) {
            this.A05.setVideoProgressReportIntervalMs(A0y.A0B());
        }
        this.A05.setVideoCTA(nativeAd.getAdCallToAction());
        this.A05.setNativeAd(nativeAd);
        this.A01 = c04015i.getVideoAutoplayBehavior();
        JM jm = this.A04;
        if (jm != null) {
            jm.AG8(nativeAd);
        }
    }

    public final void A05(J2 j2) {
        this.A05.setAdEventManager(j2);
    }

    public final void A06(JM jm) {
        this.A04 = jm;
    }

    public final void A07(MP mp2) {
        this.A05.setListener(mp2);
    }

    public final void destroy() {
        this.A05.A0V();
    }

    public final void disengageSeek(VideoStartReason videoStartReason) {
        if (!this.A06) {
            boolean isDebugBuild = AdInternalSettings.isDebugBuild();
            if (A0H[6].length() != 25) {
                throw new RuntimeException();
            }
            String[] strArr = A0H;
            strArr[0] = "WtsbSHtQErqq";
            strArr[2] = "XLMSbaKAMNULMDv3";
            if (isDebugBuild) {
                Log.w(A0I, A01(127, 40, 5));
                return;
            }
            return;
        }
        this.A06 = false;
        if (this.A07) {
            this.A05.A0b(AbstractC0779Lk.A00(videoStartReason), 3);
        }
        this.A00.onSeekDisengaged();
    }

    public final void engageSeek() {
        if (this.A06) {
            if (AdInternalSettings.isDebugBuild()) {
                Log.w(A0I, A01(167, 40, 105));
                return;
            }
            return;
        }
        this.A06 = true;
        this.A07 = RB.A0A.equals(this.A05.getState());
        this.A05.A0e(false, 1);
        this.A00.onSeekEngaged();
    }

    public final AdComponentViewApi getAdComponentViewApi() {
        return this.A02;
    }

    public final int getCurrentTimeMs() {
        return this.A05.getCurrentPositionInMillis();
    }

    public final int getDuration() {
        return this.A05.getDuration();
    }

    public final View getVideoView() {
        return this.A05.getVideoView();
    }

    public final float getVolume() {
        return this.A05.getVolume();
    }

    public final void initialize(AdViewConstructorParams adViewConstructorParams, MediaViewVideoRenderer mediaViewVideoRenderer) {
        C1116Yn A03;
        this.A00 = mediaViewVideoRenderer;
        Context context = adViewConstructorParams.getContext();
        if (context instanceof C1116Yn) {
            A03 = (C1116Yn) context;
        } else {
            A03 = C03955c.A03(context);
        }
        this.A03 = A03;
        switch (adViewConstructorParams.getInitializationType()) {
            case 0:
                this.A05 = new C0536Ba(A03);
                break;
            case 1:
                this.A05 = new C0536Ba(A03, adViewConstructorParams.getAttributeSet());
                break;
            case 2:
                this.A05 = new C0536Ba(A03, adViewConstructorParams.getAttributeSet(), adViewConstructorParams.getDefStyleAttr());
                break;
            case 3:
                this.A05 = new C0536Ba(A03, adViewConstructorParams.getAttributeSet(), adViewConstructorParams.getDefStyleRes());
                break;
            default:
                throw new IllegalArgumentException(A01(0, 37, 29));
        }
        this.A05.setEnableBackgroundVideo(mediaViewVideoRenderer.shouldAllowBackgroundPlayback());
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
        this.A05.setLayoutParams(layoutParams);
        this.A02.addView(this.A05, -1, layoutParams);
        LI.A04(this.A05, LI.A0A);
        this.A05.getEventBus().A03(this.A0D, this.A0C, this.A0B, this.A0E, this.A09, this.A0F, this.A0A);
    }

    public final void pause(boolean z2) {
        this.A05.A0e(z2, 2);
    }

    public final void play(VideoStartReason videoStartReason) {
        this.A05.A0b(AbstractC0779Lk.A00(videoStartReason), 2);
    }

    public final void seekTo(int i) {
        if (!this.A06) {
            if (AdInternalSettings.isDebugBuild()) {
                Log.w(A0I, A01(37, 90, 15));
                return;
            }
            return;
        }
        this.A05.A0Y(i);
    }

    public final void setVolume(float f4) {
        this.A05.setVolume(f4);
    }

    public final boolean shouldAutoplay() {
        C0536Ba c0536Ba = this.A05;
        if (c0536Ba == null || c0536Ba.getState() == RB.A06) {
            return false;
        }
        return this.A01 == VideoAutoplayBehavior.ON || this.A01 == VideoAutoplayBehavior.DEFAULT;
    }
}
