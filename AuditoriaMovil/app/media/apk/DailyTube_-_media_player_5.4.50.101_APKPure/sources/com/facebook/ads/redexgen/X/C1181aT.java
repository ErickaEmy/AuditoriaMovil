package com.facebook.ads.redexgen.X;

import android.util.Log;
import com.facebook.ads.AdError;
import com.facebook.ads.CacheFlag;
import com.facebook.ads.InterstitialAd;
import com.facebook.ads.InterstitialAdExtendedListener;
import com.facebook.ads.internal.protocol.AdErrorType;
import com.facebook.ads.internal.protocol.AdPlacementType;
import java.util.Arrays;
import java.util.EnumSet;
/* renamed from: com.facebook.ads.redexgen.X.aT  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C1181aT implements AnonymousClass23 {
    public static byte[] A09;
    public static String[] A0A = {"Q9RghtL5kPMxXUG2hlpmHrVaJwYYGwGq", "TIO3FaU0Mikock0w3rckrPhiuYRMfGhJ", "k6SAISDvmHdOF1rkjeEeymm6HvDlJVR0", "eDRhFd25R2oFsFg27vb0d5UADzs1KoZv", "MaVPWgska1IH7XOKtPwNB8GdxIWUIxDt", "dS1g8OO0fBonmOwqVSSlXi39LbvMIXQb", "JdFW5Fpsu4G", "QGzwgj8zvaLwI8"};
    public static final String A0B;
    public long A00 = -1;
    public InterstitialAd A01;
    public C1F A02;
    public FQ A03;
    public boolean A04;
    public boolean A05;
    public final C1116Yn A06;
    public final InterstitialAdExtendedListener A07;
    public final AnonymousClass26 A08;

    public static String A09(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A09, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] - i6) - 110);
        }
        return new String(copyOfRange);
    }

    public static void A0A() {
        A09 = new byte[]{-59, -14, -92, -27, -24, -92, -16, -13, -27, -24, -92, -19, -9, -92, -27, -16, -10, -23, -27, -24, -3, -92, -19, -14, -92, -12, -10, -13, -21, -10, -23, -9, -9, -78, -92, -35, -13, -7, -92, -9, -20, -13, -7, -16, -24, -92, -5, -27, -19, -8, -92, -22, -13, -10, -92, -27, -24, -48, -13, -27, -24, -23, -24, -84, -83, -92, -8, -13, -92, -26, -23, -92, -25, -27, -16, -16, -23, -24, -4, 33, 39, 24, 37, 38, 39, 28, 39, 28, 20, 31, -45, 31, 34, 20, 23, -45, 22, 20, 31, 31, 24, 23, -45, 42, 27, 28, 31, 24, -45, 38, 27, 34, 42, 28, 33, 26, -45, 28, 33, 39, 24, 37, 38, 39, 28, 39, 28, 20, 31, -31, 13, 28, 21};
    }

    static {
        A0A();
        A0B = C1181aT.class.getSimpleName();
    }

    public C1181aT(AnonymousClass26 anonymousClass26, C2K c2k, String str) {
        this.A08 = anonymousClass26;
        this.A06 = anonymousClass26.A05();
        this.A07 = new C1169aH(str, c2k, this);
    }

    public final long A0D() {
        FQ fq = this.A03;
        if (fq != null) {
            return fq.A0E();
        }
        return -1L;
    }

    public final AnonymousClass26 A0E() {
        return this.A08;
    }

    public final C1116Yn A0F() {
        return this.A06;
    }

    public final void A0G(EnumSet<CacheFlag> cacheFlags, String str) {
        String A02;
        this.A00 = System.currentTimeMillis();
        if (!this.A05 && this.A03 != null) {
            Log.w(A0B, A09(0, 78, 22));
        }
        this.A05 = false;
        if (this.A04 && !C0705Ih.A0e(this.A06)) {
            this.A06.A07().A9a(A09(130, 3, 62), C8A.A0L, new C8B(A09(78, 52, 69)));
            AdErrorType adErrorType = AdErrorType.LOAD_CALLED_WHILE_SHOWING_AD;
            this.A06.A0E().A2m(C0774Lf.A01(this.A00), adErrorType.getErrorCode(), adErrorType.getDefaultErrorMessage());
            this.A07.onError(this.A08.A01(), new AdError(adErrorType.getErrorCode(), adErrorType.getDefaultErrorMessage()));
            return;
        }
        FQ fq = this.A03;
        if (fq != null) {
            fq.A0P(new C1186aY(this));
            this.A03.A0K();
            this.A03 = null;
        }
        C03111u c03111u = new C03111u(this.A08.A0A(), AbstractC0728Ji.A00(this.A06.getResources().getDisplayMetrics()), AdPlacementType.INTERSTITIAL, EnumC0724Je.A07, 1, cacheFlags, this.A08.A06());
        if (C0705Ih.A28(this.A06) && (A02 = C0768Kz.A02(this.A06, this.A08.A08())) != null) {
            AnonymousClass26 anonymousClass26 = this.A08;
            if (A0A[6].length() != 11) {
                throw new RuntimeException();
            }
            String[] strArr = A0A;
            strArr[3] = "6YCA3PHZSlLj0jmN2b2hvaW99ZyRMwjh";
            strArr[5] = "7PoIPIeUN8KAt8vfreK3c69iBAU82q7R";
            anonymousClass26.A0I(A02);
        }
        c03111u.A06(this.A08.A08());
        c03111u.A07(this.A08.A09());
        c03111u.A04(this.A08.A03());
        FQ fq2 = new FQ(this.A06, c03111u);
        this.A03 = fq2;
        fq2.A0P(new C1183aV(this));
        this.A03.A0T(str);
    }

    public final boolean A0H() {
        FQ fq = this.A03;
        return fq == null || fq.A0W();
    }

    public final boolean A0I() {
        return this.A05;
    }

    public final boolean A0J() {
        AdError adError = AdError.SHOW_CALLED_BEFORE_LOAD_ERROR;
        if (!this.A05) {
            this.A06.A0E().A2m(C0774Lf.A01(this.A00), adError.getErrorCode(), adError.getErrorMessage());
            this.A07.onError(this.A08.A01(), adError);
            return false;
        }
        FQ fq = this.A03;
        if (fq == null) {
            this.A06.A07().A9a(A09(130, 3, 62), C8A.A0S, new C8B(AdErrorType.INTERSTITIAL_CONTROLLER_IS_NULL.getDefaultErrorMessage()));
            this.A06.A0E().A2m(C0774Lf.A01(this.A00), adError.getErrorCode(), adError.getErrorMessage());
            this.A07.onError(this.A08.A01(), adError);
            return false;
        }
        fq.A0J();
        this.A04 = true;
        this.A05 = false;
        return true;
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass23
    public final void destroy() {
        FQ fq = this.A03;
        if (fq != null) {
            fq.A0P(new C1182aU(this));
            this.A03.A0V(true);
            this.A03 = null;
            this.A05 = false;
            this.A04 = false;
        }
    }
}
