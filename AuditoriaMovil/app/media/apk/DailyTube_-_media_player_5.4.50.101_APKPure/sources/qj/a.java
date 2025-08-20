package qj;

import android.webkit.ServiceWorkerClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
/* loaded from: classes.dex */
public class a extends ServiceWorkerClient {
    public final qk.y y;

    public a(@NonNull qk.y yVar) {
        this.y = yVar;
    }

    @Override // android.webkit.ServiceWorkerClient
    @Nullable
    public WebResourceResponse shouldInterceptRequest(@NonNull WebResourceRequest webResourceRequest) {
        return this.y.y(webResourceRequest);
    }
}
