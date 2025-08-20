package qj;

import android.webkit.WebViewClient;
import androidx.annotation.NonNull;
import org.chromium.support_lib_boundary.WebViewProviderBoundaryInterface;
/* loaded from: classes.dex */
public class wz {
    public WebViewProviderBoundaryInterface y;

    public wz(@NonNull WebViewProviderBoundaryInterface webViewProviderBoundaryInterface) {
        this.y = webViewProviderBoundaryInterface;
    }

    @NonNull
    public WebViewClient y() {
        return this.y.getWebViewClient();
    }
}
