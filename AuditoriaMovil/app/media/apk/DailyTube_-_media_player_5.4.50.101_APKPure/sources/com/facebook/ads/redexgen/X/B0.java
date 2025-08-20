package com.facebook.ads.redexgen.X;

import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.facebook.ads.internal.util.activity.AdActivityIntent;
import com.uv.v7.R;
import java.util.Arrays;
import java.util.HashMap;
/* loaded from: assets/audience_network.dex */
public final class B0 extends FrameLayout implements TD {
    public static byte[] A0A;
    public static String[] A0B = {"gR8VXB3ia", "OJTiurBFiCqcREvzh7o4PkhSqDGudpIq", "iaBHwIBC1utH6CwOSIC2yyAu4ZYXfJ61", "YdU4", "YcTfP9iPeB3iMp", "vsmHP1kkKyGC9kag", "2EZKw0n31g6TC4", "KAWIkc2sX"};
    public RE A00;
    public final int A01;
    public final AbstractC1219b5 A02;
    public final C1116Yn A03;
    public final J2 A04;
    public final C0775Lg A05;
    public final P0 A06;
    public final PB A07;
    public final String A08;
    public final boolean A09;

    public static String A01(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A0A, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] ^ i6) ^ R.styleable.AppCompatTheme_toolbarStyle);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A0A = new byte[]{118, 84, 91, 18, 65, 21, 70, 65, 84, 71, 65, 21, 116, 64, 81, 92, 80, 91, 86, 80, 123, 80, 65, 66, 90, 71, 94, 116, 86, 65, 92, 67, 92, 65, 76, 27, 21, 120, 84, 94, 80, 21, 70, 64, 71, 80, 21, 65, 93, 84, 65, 21, 92, 65, 18, 70, 21, 92, 91, 21, 76, 90, 64, 71, 21, 116, 91, 81, 71, 90, 92, 81, 120, 84, 91, 92, 83, 80, 70, 65, 27, 77, 88, 89, 21, 83, 92, 89, 80, 27, 30, 26, 25, 45, 60, 49, 61, 54, 59, 61, 22, 61, 44, 47, 55, 42, 51, 54, 57, 8, 54, 52, 35, 62, 33, 62, 35, 46, 77, 66, 71, 77, 69, 113, 93, 65, 91, 92, 77, 75, 55, 56, 45, 48, 47, 60, 24, 61, 29, 56, 45, 56, 27, 44, 55, 61, 53, 60, 33, 39, 49, 38, 55, 56, 61, 55, 63, 22, 9, 5, 23, 52, 25, 16, 5};
    }

    static {
        A02();
    }

    public B0(C1116Yn c1116Yn, J2 j2, P0 p02, AbstractC1219b5 abstractC1219b5, String str, int i, C0775Lg c0775Lg) {
        super(c1116Yn);
        this.A03 = c1116Yn;
        this.A04 = j2;
        this.A02 = abstractC1219b5;
        this.A08 = str;
        this.A06 = p02;
        this.A01 = i;
        PB preloadedDynamicWebViewController = PC.A02(abstractC1219b5.A0S());
        if (preloadedDynamicWebViewController != null) {
            this.A07 = preloadedDynamicWebViewController;
            this.A09 = true;
        } else {
            PB preloadedDynamicWebViewController2 = new PB(c1116Yn, abstractC1219b5, j2, i);
            this.A07 = preloadedDynamicWebViewController2;
            PC.A03(abstractC1219b5, preloadedDynamicWebViewController2);
            this.A09 = false;
        }
        if (c0775Lg != null) {
            this.A05 = c0775Lg;
            this.A07.A0Z(c0775Lg);
        } else {
            this.A05 = this.A07.A0L();
        }
        this.A07.A0c(new TK(this));
        this.A07.A0a(p02);
        LI.A04(this, LI.A0A);
        if (C0705Ih.A1W(c1116Yn)) {
            c1116Yn.A0A().AGx(this.A07.A0O(), abstractC1219b5.A12(), false, false, true);
        }
        A04();
    }

    private final void A03() {
        this.A07.A0d(this);
        if (!this.A09) {
            this.A03.A0E().A5H();
            this.A07.A0X();
        } else {
            this.A03.A0E().A5I();
            String[] strArr = A0B;
            if (strArr[6].length() != strArr[4].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0B;
            strArr2[6] = "EW3rEVX7vA8fzU";
            strArr2[4] = "ztAtYR2DvpL08d";
            if (this.A07.A0k()) {
                if (this.A01 == 4) {
                    P0 p02 = this.A06;
                    if (p02 != null) {
                        p02.ABO(this);
                    }
                    if (C0705Ih.A1W(this.A03)) {
                        this.A03.A0A().ABG();
                    }
                } else {
                    AGY();
                }
            }
        }
        A08();
    }

    private final void A04() {
        PB.A0B().incrementAndGet();
        A03();
        this.A07.A0W();
    }

    private void A05(Intent intent, AbstractC1219b5 abstractC1219b5) {
        intent.putExtra(A01(157, 8, 17), KB.A07);
        intent.putExtra(A01(130, 18, 40), abstractC1219b5);
        intent.addFlags(268435456);
    }

    private final void A06(AbstractC1219b5 abstractC1219b5) {
        AdActivityIntent A04 = C0754Kj.A04(this.A03);
        A05(A04, abstractC1219b5);
        try {
            C0754Kj.A0A(this.A03, A04);
        } catch (Exception e2) {
            this.A03.A07().A9a(A01(107, 11, 38), C8A.A0D, new C8B(e2));
            Log.e(A01(90, 17, 41), A01(0, 90, 68), e2);
        }
    }

    private void A07(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        C0838Nr c0838Nr = new C0838Nr(this.A03, this.A08, this.A00, this.A05, this.A04, this.A02.A0y());
        HashMap hashMap = new HashMap();
        hashMap.put(A01(118, 12, 95), A01(148, 9, 37));
        c0838Nr.A07(this.A02.A12(), str, hashMap);
    }

    public final void A08() {
        AbstractC0783Lo.A0J(this.A07.A0O());
        addView(this.A07.A0O(), new FrameLayout.LayoutParams(-1, -1));
    }

    @Override // com.facebook.ads.redexgen.X.TD
    public final void A8S() {
        A07(this.A02.A0x().A0F().A05());
    }

    @Override // com.facebook.ads.redexgen.X.TD
    public final void A8T(String str) {
        A07(str);
    }

    @Override // com.facebook.ads.redexgen.X.TD
    public final void A8X() {
    }

    @Override // com.facebook.ads.redexgen.X.TD
    public final void A9K() {
        new Handler(Looper.getMainLooper()).post(new TJ(this));
    }

    @Override // com.facebook.ads.redexgen.X.TD
    public final void ABb() {
        A06(this.A02);
    }

    @Override // com.facebook.ads.redexgen.X.TD
    public final void ABf() {
    }

    @Override // com.facebook.ads.redexgen.X.TD
    public final void ACL(boolean z2) {
    }

    @Override // com.facebook.ads.redexgen.X.TD
    public final void AD8() {
    }

    @Override // com.facebook.ads.redexgen.X.TD
    public final void ADc(boolean z2) {
    }

    @Override // com.facebook.ads.redexgen.X.TD
    public final void ADe(boolean z2) {
    }

    @Override // com.facebook.ads.redexgen.X.TD
    public final void ADr(String str) {
    }

    @Override // com.facebook.ads.redexgen.X.TD
    public final void AGY() {
        P0 p02 = this.A06;
        if (p02 != null) {
            p02.ABO(this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.TD
    public final void close() {
    }

    public J2 getAdEventManager() {
        return this.A04;
    }

    public PB getDynamicWebViewController() {
        return this.A07;
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        requestDisallowInterceptTouchEvent(true);
        return super.onTouchEvent(motionEvent);
    }

    public void setAdViewabilityChecker(RE re) {
        this.A00 = re;
        this.A07.A0e(re);
    }
}
