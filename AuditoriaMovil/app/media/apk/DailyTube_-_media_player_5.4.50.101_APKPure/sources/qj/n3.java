package qj;

import android.content.Context;
import android.webkit.ServiceWorkerClient;
import android.webkit.ServiceWorkerController;
import android.webkit.ServiceWorkerWebSettings;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.File;
/* loaded from: classes.dex */
public class n3 {
    public static int a(@NonNull WebSettings webSettings) {
        return webSettings.getDisabledActionModeMenuItems();
    }

    @NonNull
    public static i9 c5(@NonNull ServiceWorkerController serviceWorkerController) {
        return new i9(s(serviceWorkerController));
    }

    public static void f(@NonNull ServiceWorkerWebSettings serviceWorkerWebSettings, boolean z2) {
        serviceWorkerWebSettings.setAllowContentAccess(z2);
    }

    @NonNull
    public static ServiceWorkerController fb() {
        return ServiceWorkerController.getInstance();
    }

    public static int gv(@NonNull ServiceWorkerWebSettings serviceWorkerWebSettings) {
        return serviceWorkerWebSettings.getCacheMode();
    }

    public static boolean i9(@NonNull WebResourceRequest webResourceRequest) {
        return webResourceRequest.isRedirect();
    }

    public static boolean n3(@NonNull ServiceWorkerWebSettings serviceWorkerWebSettings) {
        return serviceWorkerWebSettings.getAllowFileAccess();
    }

    public static void p(@NonNull ServiceWorkerController serviceWorkerController, @NonNull qk.y yVar) {
        serviceWorkerController.setServiceWorkerClient(new a(yVar));
    }

    @NonNull
    public static ServiceWorkerWebSettings s(@NonNull ServiceWorkerController serviceWorkerController) {
        return serviceWorkerController.getServiceWorkerWebSettings();
    }

    public static void t(@NonNull ServiceWorkerWebSettings serviceWorkerWebSettings, boolean z2) {
        serviceWorkerWebSettings.setAllowFileAccess(z2);
    }

    public static void tl(@NonNull ServiceWorkerWebSettings serviceWorkerWebSettings, boolean z2) {
        serviceWorkerWebSettings.setBlockNetworkLoads(z2);
    }

    @NonNull
    public static File v(@NonNull Context context) {
        return context.getDataDir();
    }

    public static void w(@NonNull ServiceWorkerController serviceWorkerController, @Nullable ServiceWorkerClient serviceWorkerClient) {
        serviceWorkerController.setServiceWorkerClient(serviceWorkerClient);
    }

    public static void wz(@NonNull ServiceWorkerWebSettings serviceWorkerWebSettings, int i) {
        serviceWorkerWebSettings.setCacheMode(i);
    }

    public static void xc(@NonNull WebSettings webSettings, int i) {
        webSettings.setDisabledActionModeMenuItems(i);
    }

    public static boolean y(@NonNull ServiceWorkerWebSettings serviceWorkerWebSettings) {
        return serviceWorkerWebSettings.getAllowContentAccess();
    }

    public static boolean zn(@NonNull ServiceWorkerWebSettings serviceWorkerWebSettings) {
        return serviceWorkerWebSettings.getBlockNetworkLoads();
    }
}
