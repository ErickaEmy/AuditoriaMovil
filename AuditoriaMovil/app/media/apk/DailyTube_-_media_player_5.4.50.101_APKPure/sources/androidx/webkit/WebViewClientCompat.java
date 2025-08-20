package androidx.webkit;

import android.os.Build;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.annotation.Keep;
import org.chromium.support_lib_boundary.WebViewClientBoundaryInterface;
import timber.log.Timber;
/* loaded from: classes.dex */
public class WebViewClientCompat extends WebViewClient implements WebViewClientBoundaryInterface {
    public static final String[] y = {"VISUAL_STATE_CALLBACK", "RECEIVE_WEB_RESOURCE_ERROR", "RECEIVE_HTTP_ERROR", "SHOULD_OVERRIDE_WITH_REDIRECTS", "SAFE_BROWSING_HIT"};

    /* loaded from: classes.dex */
    class _boostWeave {
        @Keep
        public static boolean HookProxy_onRenderProcessGoneAdWebViewClient(WebViewClientCompat webViewClientCompat, WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
            String str;
            String str2;
            WebViewClientCompat.y(webViewClientCompat, webView, renderProcessGoneDetail);
            boolean didCrash = Build.VERSION.SDK_INT >= 26 ? renderProcessGoneDetail.didCrash() : false;
            str = "";
            if (webView != null) {
                String name = webView.getClass().getName();
                str2 = webView.getUrl() != null ? webView.getUrl() : "";
                str = name;
            } else {
                str2 = "";
            }
            Timber.Tree tag = Timber.tag("HookProxy");
            tag.e("onRenderProcessGone webView:" + str + " crashHappen:" + didCrash + " url:" + str2, new Object[0]);
            return true;
        }
    }

    public static /* synthetic */ boolean y(WebViewClientCompat webViewClientCompat, WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        throw null;
    }
}
