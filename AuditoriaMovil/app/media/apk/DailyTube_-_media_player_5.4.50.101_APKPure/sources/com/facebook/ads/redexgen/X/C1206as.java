package com.facebook.ads.redexgen.X;

import android.webkit.WebView;
import com.facebook.ads.AdError;
/* renamed from: com.facebook.ads.redexgen.X.as  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C1206as implements C6U {
    public final C02931c A00;
    public final InterfaceC03071q A01;
    public final C04216c A02;
    public final C1116Yn A03;
    public final boolean A04;

    public C1206as(C1116Yn c1116Yn, InterfaceC03071q interfaceC03071q, C04216c c04216c, C02931c c02931c, boolean z2) {
        this.A03 = c1116Yn;
        this.A01 = interfaceC03071q;
        this.A02 = c04216c;
        this.A00 = c02931c;
        this.A04 = z2;
    }

    private final void A00() {
        WebView webView = new WebView(this.A03);
        webView.getSettings().setCacheMode(1);
        webView.setWebViewClient(new C03081r(this.A00, this.A01, this.A04));
        webView.loadUrl(this.A00.A0E());
    }

    private void A01(boolean z2) {
        if (this.A00.A09() == EnumC02941d.A05) {
            A00();
            return;
        }
        String A0E = this.A00.A0E();
        if (z2) {
            C04216c c04216c = this.A02;
            String markupUrlResult = this.A00.A0E();
            A0E = c04216c.A0R(markupUrlResult);
        }
        this.A00.A0H(A0E);
        this.A01.ACa();
    }

    @Override // com.facebook.ads.redexgen.X.C6U
    public final void AB2() {
        if (this.A04) {
            this.A01.ACZ(AdError.CACHE_ERROR);
        } else {
            A01(false);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C6U
    public final void ABB() {
        A01(true);
    }
}
