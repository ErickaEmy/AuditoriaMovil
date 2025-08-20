package com.facebook.ads.redexgen.X;

import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.WebSettings;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: assets/audience_network.dex */
public final class Q0 extends FrameLayout {
    public static byte[] A0C;
    public static String[] A0D = {"2LrpfYyae0azpeRldXrTpIs5j5WolZYJ", "aTWFoH17M5HvBaS06GyoTMgY8LK09kB1", "ZT9jJV1ne", "vwbwskwEgIVHj6V8wHV", "a8UIfMhCahgZVDol7QIaAFMNjSR7v8Rm", "pauq9xVSe1TSbn6Nh8iDWIypG", "tig0s2h3zWgeN1kA13N6tuAlrnUP1dby", "gu60Pcp0oAdbO9RcUpkXMIBgrMh0CW0V"};
    public static final float A0E;
    public static final RelativeLayout.LayoutParams A0F;
    public int A00;
    public long A01;
    public Map<String, String> A02;
    public final AbstractC1219b5 A03;
    public final C02931c A04;
    public final C1116Yn A05;
    public final J2 A06;
    public final InterfaceC0822Nb A07;
    public final C0995Ts A08;
    public final InterfaceC0897Py A09;
    public final AtomicBoolean A0A;
    public final AtomicBoolean A0B;

    public static String A06(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A0C, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            int i10 = copyOfRange[i8] ^ i6;
            if (A0D[5].length() != 25) {
                throw new RuntimeException();
            }
            A0D[4] = "2xsSJQdmJTzWNKbVkLPVv70adF3crTtp";
            copyOfRange[i8] = (byte) (i10 ^ 37);
        }
        return new String(copyOfRange);
    }

    public static void A09() {
        A0C = new byte[]{11, 47, 29, 33, 44, 52, 44, 47, 33, 40, 12, 41, 52, 5, 22, 23, 13, 10, 3, 68, 1, 22, 22, 11, 22, 52, 8, 5, 29, 5, 6, 8, 1, 68, 0, 11, 39, 16, 5, 39, 8, 13, 7, 15, 68, 16, 22, 13, 3, 3, 1, 22, 1, 0, 68, 19, 13, 16, 12, 68, 20, 22, 1, 73, 1, 18, 1, 10, 16, 68, 7, 8, 13, 7, 15, 23, 68, 7, 11, 17, 10, 16, 68, 5, 10, 0, 68, 32, 1, 8, 5, 29, 106, 86, 91, 67, 91, 88, 86, 95, 123, 94, 73, 108, 83, 95, 77, 102, 97, 99, 109, 106, 36, 104, 107, 101, 96, 109, 106, 99, 36, 118, 97, 105, 107, 112, 97, 36, 116, 104, 101, 125, 101, 102, 104, 97, 61, 50, 55, 61, 53, 45, 112, 113, 120, 117, 109, 93, 65, 76, 84, 76, 79, 65, 72, 55, 43, 38, 62, 38, 37, 43, 34, 24, 53, 34, 42, 40, 51, 34, 21, 2, 10, 8, 19, 2, 56, 20, 2, 20, 20, 14, 8, 9, 56, 14, 3, 20, 15, 11, 5, 14, 107, 121, 126, 67, 106, 117, 121, 107};
    }

    static {
        A09();
        A0E = (int) (LD.A02 * 4.0f);
        A0F = new RelativeLayout.LayoutParams(-1, -1);
    }

    public Q0(C1116Yn c1116Yn, AbstractC1219b5 abstractC1219b5, C02931c c02931c, J2 j2, InterfaceC0897Py interfaceC0897Py, Map<String, String> playableMetricsData) {
        super(c1116Yn);
        this.A0A = new AtomicBoolean(false);
        this.A0B = new AtomicBoolean(false);
        this.A01 = -1L;
        this.A00 = 0;
        this.A07 = new AbstractC0998Tv() { // from class: com.facebook.ads.redexgen.X.9O
            @Override // com.facebook.ads.redexgen.X.InterfaceC0822Nb
            public final void AAn() {
            }

            @Override // com.facebook.ads.redexgen.X.AbstractC0998Tv, com.facebook.ads.redexgen.X.InterfaceC0822Nb
            public final void ABW(int i, String str) {
                AtomicBoolean atomicBoolean;
                InterfaceC0897Py interfaceC0897Py2;
                atomicBoolean = Q0.this.A0B;
                atomicBoolean.set(true);
                interfaceC0897Py2 = Q0.this.A09;
                interfaceC0897Py2.AC4();
            }

            @Override // com.facebook.ads.redexgen.X.InterfaceC0822Nb
            public final void ABj() {
                AtomicBoolean atomicBoolean;
                AtomicBoolean atomicBoolean2;
                InterfaceC0897Py interfaceC0897Py2;
                atomicBoolean = Q0.this.A0B;
                if (atomicBoolean.get()) {
                    return;
                }
                atomicBoolean2 = Q0.this.A0A;
                if (!atomicBoolean2.compareAndSet(false, true)) {
                    return;
                }
                interfaceC0897Py2 = Q0.this.A09;
                interfaceC0897Py2.ABj();
            }

            @Override // com.facebook.ads.redexgen.X.InterfaceC0822Nb
            public final void ADj() {
                InterfaceC0897Py interfaceC0897Py2;
                interfaceC0897Py2 = Q0.this.A09;
                interfaceC0897Py2.ADj();
            }
        };
        this.A05 = c1116Yn;
        this.A03 = abstractC1219b5;
        this.A04 = c02931c;
        this.A06 = j2;
        this.A09 = interfaceC0897Py;
        this.A02 = playableMetricsData;
        C0995Ts A04 = A04();
        this.A08 = A04;
        if (C0705Ih.A1W(c1116Yn)) {
            c1116Yn.A0A().AGv(A04, abstractC1219b5.A12(), false);
        }
        addView(A04, A0F);
    }

    public static /* synthetic */ int A00(Q0 q0) {
        int i = q0.A00;
        q0.A00 = i + 1;
        return i;
    }

    private C0995Ts A04() {
        C0995Ts c0995Ts = new C0995Ts(this.A05, new WeakReference(this.A07), 10, C0705Ih.A1f(this.A05));
        c0995Ts.setCornerRadius(A0E);
        c0995Ts.setLogMultipleImpressions(false);
        c0995Ts.setCheckAssetsByJavascriptBridge(false);
        c0995Ts.setWebViewTimeoutInMillis(this.A04.A08());
        c0995Ts.setRequestId(this.A03.A0S());
        c0995Ts.setOnTouchListener(new View$OnTouchListenerC0898Pz(this));
        WebSettings settings = c0995Ts.getSettings();
        settings.setLoadWithOverviewMode(true);
        settings.setUseWideViewPort(true);
        settings.setAllowFileAccess(true);
        if (Build.VERSION.SDK_INT >= 16) {
            settings.setAllowFileAccessFromFileURLs(true);
        }
        if (Build.VERSION.SDK_INT > 16) {
            c0995Ts.addJavascriptInterface(new Q1(this.A05, this, this.A06, this.A02, this.A03.A12()), A06(0, 12, 104));
        }
        return c0995Ts;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x00b8, code lost:
        if (r3 <= com.facebook.ads.redexgen.X.C0705Ih.A0H(r8)) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x00ba, code lost:
        r3 = r9.A09;
        r2 = com.facebook.ads.redexgen.X.Q0.A0D;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x00ce, code lost:
        if (r2[0].charAt(14) == r2[7].charAt(14)) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x00d0, code lost:
        r3.ABD();
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x00d3, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x00d4, code lost:
        r2 = com.facebook.ads.redexgen.X.Q0.A0D;
        r2[0] = "1qrV4xG42mjJ5wR1PYF4mguO0xYm8sMw";
        r2[7] = "To2gWJFbGkwQ4PRGYAw3BZd3UXo54AHv";
        r3.ABD();
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x00f2, code lost:
        if (r3 <= com.facebook.ads.redexgen.X.C0705Ih.A0H(r8)) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x00f5, code lost:
        r7.A05(0);
        r9.A05.A07().A9a(r6, com.facebook.ads.redexgen.X.C8A.A2E, r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:?, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:?, code lost:
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void A0A() {
        /*
            Method dump skipped, instructions count: 272
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.Q0.A0A():void");
    }

    public final void A0B() {
        String A0E2;
        if (this.A04.A0J()) {
            C8B c8b = new C8B(A06(107, 29, 33));
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(A06(170, 17, 66), this.A04.A0F());
                jSONObject.put(A06(187, 5, 69), this.A03.A12());
            } catch (JSONException e2) {
                Log.e(A06(92, 15, 31), A06(12, 13, 65), e2);
            }
            c8b.A07(jSONObject);
            c8b.A05(1);
            AnonymousClass89 A07 = this.A05.A07();
            if (A0D[4].charAt(0) == 'P') {
                throw new RuntimeException();
            }
            A0D[1] = "TEDpWyR4sKSlO4xRZxixfnQAFgDgpHMF";
            int i = C8A.A2G;
            String A06 = A06(155, 15, 98);
            A07.A9b(A06, i, c8b);
            if (C0705Ih.A0m(this.A05) && AbstractC0772Ld.A00(this.A05) == EnumC0771Lc.A07) {
                this.A05.A07().A9b(A06, C8A.A2F, c8b);
                this.A07.ABW(0, null);
                return;
            }
        }
        try {
            C0995Ts c0995Ts = this.A08;
            if (!TextUtils.isEmpty(this.A04.A0B())) {
                A0E2 = this.A04.A0B();
            } else {
                A0E2 = this.A04.A0E();
            }
            c0995Ts.loadUrl(A0E2);
        } catch (Exception e3) {
            this.A05.A07().A9a(A06(192, 8, 57), C8A.A2d, new C8B(e3));
        }
    }

    public final void A0C() {
        if (C0705Ih.A1W(this.A05)) {
            C1116Yn c1116Yn = this.A05;
            if (A0D[2].length() == 31) {
                throw new RuntimeException();
            }
            A0D[1] = "2a9geg5CZy9bcTekyOeVTlcxLNQduX9G";
            c1116Yn.A0A().AGk(this.A08);
        }
        this.A08.removeJavascriptInterface(A06(0, 12, 104));
        if (A0D[3].length() != 23) {
            A0D[6] = "33aduEcFLWt6pdjLdZ5sJJvVvr5WDkst";
            this.A08.destroy();
            return;
        }
        this.A08.destroy();
    }

    public C0775Lg getTouchDataRecorder() {
        return this.A08.getTouchDataRecorder();
    }

    public RE getViewabilityChecker() {
        return this.A08.getViewabilityChecker();
    }
}
