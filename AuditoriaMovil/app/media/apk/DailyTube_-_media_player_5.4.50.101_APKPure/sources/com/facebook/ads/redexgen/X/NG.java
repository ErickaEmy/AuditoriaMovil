package com.facebook.ads.redexgen.X;

import android.view.View;
import android.webkit.WebView;
/* loaded from: assets/audience_network.dex */
public class NG implements View.OnClickListener {
    public final /* synthetic */ NJ A00;

    public NG(NJ nj2) {
        this.A00 = nj2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        WebView webView;
        WebView webView2;
        if (KL.A02(this)) {
            return;
        }
        try {
            webView = this.A00.A0A;
            if (!webView.canGoForward()) {
                return;
            }
            webView2 = this.A00.A0A;
            webView2.goForward();
        } catch (Throwable th) {
            KL.A00(th, this);
        }
    }
}
