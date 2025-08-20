package qj;

import android.content.pm.PackageInfo;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
/* loaded from: classes.dex */
public class zn {
    @Nullable
    public static WebViewClient gv(@NonNull WebView webView) {
        return webView.getWebViewClient();
    }

    public static boolean n3(@NonNull WebSettings webSettings) {
        return webSettings.getSafeBrowsingEnabled();
    }

    public static void v(@NonNull WebSettings webSettings, boolean z2) {
        webSettings.setSafeBrowsingEnabled(z2);
    }

    @NonNull
    public static PackageInfo y() {
        return WebView.getCurrentWebViewPackage();
    }

    @Nullable
    public static WebChromeClient zn(@NonNull WebView webView) {
        return webView.getWebChromeClient();
    }
}
