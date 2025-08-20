package qj;

import android.os.Looper;
import android.webkit.TracingConfig;
import android.webkit.TracingController;
import android.webkit.WebView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.OutputStream;
import java.util.concurrent.Executor;
/* loaded from: classes.dex */
public class gv {
    public static void a(@NonNull TracingController tracingController, @NonNull qk.gv gvVar) {
        new TracingConfig.Builder();
        throw null;
    }

    public static boolean fb(@NonNull TracingController tracingController, @Nullable OutputStream outputStream, @NonNull Executor executor) {
        return tracingController.stop(outputStream, executor);
    }

    public static boolean gv(@NonNull TracingController tracingController) {
        return tracingController.isTracing();
    }

    @NonNull
    public static ClassLoader n3() {
        return WebView.getWebViewClassLoader();
    }

    public static void v(@NonNull String str) {
        WebView.setDataDirectorySuffix(str);
    }

    @NonNull
    public static TracingController y() {
        return TracingController.getInstance();
    }

    @NonNull
    public static Looper zn(@NonNull WebView webView) {
        return webView.getWebViewLooper();
    }
}
