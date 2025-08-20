package qj;

import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import org.chromium.support_lib_boundary.ServiceWorkerClientBoundaryInterface;
/* loaded from: classes.dex */
public class s implements ServiceWorkerClientBoundaryInterface {
    public final qk.y y;

    public s(@NonNull qk.y yVar) {
        this.y = yVar;
    }

    @Override // org.chromium.support_lib_boundary.FeatureFlagHolderBoundaryInterface
    @NonNull
    public String[] getSupportedFeatures() {
        return new String[]{"SERVICE_WORKER_SHOULD_INTERCEPT_REQUEST"};
    }

    @Override // org.chromium.support_lib_boundary.ServiceWorkerClientBoundaryInterface
    @Nullable
    public WebResourceResponse shouldInterceptRequest(@NonNull WebResourceRequest webResourceRequest) {
        return this.y.y(webResourceRequest);
    }
}
