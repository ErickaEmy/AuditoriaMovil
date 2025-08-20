package com.facebook.ads.redexgen.X;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Canvas;
import android.os.Build;
import android.webkit.ValueCallback;
import android.webkit.WebBackForwardList;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
/* loaded from: assets/audience_network.dex */
public final class U1 extends NY {
    public static ValueCallback A08;
    public static boolean A09;
    public static boolean A0A;
    public static byte[] A0B;
    public static final String A0C;
    public static final Set<String> A0D;
    public long A00;
    public long A01;
    public long A02;
    public long A03;
    public C1116Yn A04;
    public NO A05;
    public NS A06;
    public NV A07;

    public static String A05(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A0B, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] ^ i6) ^ 93);
        }
        return new String(copyOfRange);
    }

    public static void A08() {
        A0B = new byte[]{83, 79, 79, 75, 49, 45, 45, 41, 42};
    }

    static {
        A08();
        A0C = U1.class.getSimpleName();
        HashSet hashSet = new HashSet(2);
        A0D = hashSet;
        A09 = false;
        A0A = false;
        hashSet.add(A05(0, 4, 102));
        hashSet.add(A05(4, 5, 4));
    }

    public U1(C1116Yn c1116Yn, Activity activity, NS ns) {
        super(activity, c1116Yn);
        this.A02 = -1L;
        this.A00 = -1L;
        this.A03 = -1L;
        this.A01 = -1L;
        A0A(c1116Yn, ns);
    }

    public U1(C1116Yn c1116Yn, NS ns) {
        super(c1116Yn);
        this.A02 = -1L;
        this.A00 = -1L;
        this.A03 = -1L;
        this.A01 = -1L;
        A0A(c1116Yn, ns);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.X.NY
    /* renamed from: A04 */
    public final NV A0E() {
        return new NV(new WeakReference(this.A04), new WeakReference(this.A06), new WeakReference(this.A05));
    }

    private void A07() {
        if (this.A02 > -1 && this.A00 > -1 && this.A01 > -1) {
            this.A05.A05(false);
        }
    }

    public static void A09(int i, int i5, Intent intent) {
        if (A08 != null && i == 1001) {
            if (Build.VERSION.SDK_INT >= 21) {
                A08.onReceiveValue(WebChromeClient.FileChooserParams.parseResult(i5, intent));
            } else {
                A08.onReceiveValue(intent.getData());
            }
            A08 = null;
        }
    }

    private void A0A(C1116Yn c1116Yn, NS ns) {
        this.A04 = c1116Yn;
        this.A06 = ns;
        this.A05 = new NO(this);
        A09 = AbstractC0706Ii.A03(this.A04);
        A0A = AbstractC0706Ii.A04(this.A04);
        WebSettings settings = getSettings();
        settings.setSupportZoom(true);
        settings.setBuiltInZoomControls(true);
        settings.setDisplayZoomControls(false);
        settings.setLoadWithOverviewMode(true);
        settings.setUseWideViewPort(true);
        settings.setAllowContentAccess(false);
        settings.setAllowFileAccessFromFileURLs(false);
        settings.setAllowUniversalAccessFromFileURLs(false);
        settings.setAllowFileAccess(false);
        setWebChromeClient(A0D());
        NV A0E = A0E();
        this.A07 = A0E;
        setWebViewClient(A0E);
    }

    @Override // com.facebook.ads.redexgen.X.NY
    public final WebChromeClient A0D() {
        return new NU(new WeakReference(this.A04), new WeakReference(this.A06), new WeakReference(this.A05));
    }

    public final void A0F(long j2) {
        if (this.A00 < 0) {
            this.A00 = j2;
        }
        A07();
    }

    public final void A0G(long j2) {
        if (this.A01 < 0) {
            this.A01 = j2;
        }
        A07();
    }

    public final void A0H(long j2) {
        if (this.A02 < 0) {
            this.A02 = j2;
        }
        A07();
    }

    @Override // com.facebook.ads.redexgen.X.NY, android.webkit.WebView
    public final void destroy() {
        this.A06 = null;
        AbstractC0825Ne.A03(this);
        super.destroy();
    }

    public long getDomContentLoadedMs() {
        return this.A00;
    }

    public String getFirstUrl() {
        WebBackForwardList copyBackForwardList = copyBackForwardList();
        if (copyBackForwardList.getSize() > 0) {
            return copyBackForwardList.getItemAtIndex(0).getUrl();
        }
        return getUrl();
    }

    public long getLoadFinishMs() {
        return this.A01;
    }

    public long getResponseEndMs() {
        return this.A02;
    }

    public long getScrollReadyMs() {
        return this.A03;
    }

    @Override // android.webkit.WebView, android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.A03 < 0 && computeVerticalScrollRange() > getHeight()) {
            this.A03 = System.currentTimeMillis();
        }
    }

    public void setBrowserNavigationListener(NT nt) {
        this.A07.A06(new WeakReference<>(nt));
    }

    public void setInterceptRedirectRequest(NR nr2) {
        this.A07.A05(nr2);
    }
}
