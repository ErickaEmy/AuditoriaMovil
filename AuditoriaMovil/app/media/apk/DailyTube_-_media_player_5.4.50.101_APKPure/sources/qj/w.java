package qj;

import android.webkit.WebView;
import androidx.annotation.NonNull;
import org.chromium.support_lib_boundary.ServiceWorkerControllerBoundaryInterface;
import org.chromium.support_lib_boundary.StaticsBoundaryInterface;
import org.chromium.support_lib_boundary.WebViewProviderBoundaryInterface;
import org.chromium.support_lib_boundary.WebViewProviderFactoryBoundaryInterface;
/* loaded from: classes.dex */
public class w implements xc {
    public final WebViewProviderFactoryBoundaryInterface y;

    public w(@NonNull WebViewProviderFactoryBoundaryInterface webViewProviderFactoryBoundaryInterface) {
        this.y = webViewProviderFactoryBoundaryInterface;
    }

    @Override // qj.xc
    @NonNull
    public WebViewProviderBoundaryInterface createWebView(@NonNull WebView webView) {
        return (WebViewProviderBoundaryInterface) cd1.y.y(WebViewProviderBoundaryInterface.class, this.y.createWebView(webView));
    }

    @Override // qj.xc
    @NonNull
    public ServiceWorkerControllerBoundaryInterface getServiceWorkerController() {
        return (ServiceWorkerControllerBoundaryInterface) cd1.y.y(ServiceWorkerControllerBoundaryInterface.class, this.y.getServiceWorkerController());
    }

    @Override // qj.xc
    @NonNull
    public StaticsBoundaryInterface getStatics() {
        return (StaticsBoundaryInterface) cd1.y.y(StaticsBoundaryInterface.class, this.y.getStatics());
    }

    @Override // qj.xc
    @NonNull
    public String[] y() {
        return this.y.getSupportedFeatures();
    }
}
