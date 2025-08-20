package qk;

import android.annotation.SuppressLint;
import android.content.pm.PackageInfo;
import android.net.Uri;
import android.os.Build;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.lang.reflect.InvocationTargetException;
import org.chromium.support_lib_boundary.WebViewProviderBoundaryInterface;
import qj.t;
import qj.tl;
import qj.wz;
import qj.xc;
import qj.y;
/* loaded from: classes.dex */
public class v {
    public static final Uri y = Uri.parse("*");

    /* renamed from: n3  reason: collision with root package name */
    public static final Uri f12990n3 = Uri.parse("");

    @NonNull
    public static WebViewClient a(@NonNull WebView webView) {
        y.v vVar = t.f12940ej;
        if (vVar.n3()) {
            return qj.zn.gv(webView);
        }
        if (vVar.gv()) {
            return v(webView).y();
        }
        throw t.y();
    }

    public static boolean fb() {
        if (t.f12964qn.gv()) {
            return zn().getStatics().isMultiProcessEnabled();
        }
        throw t.y();
    }

    @SuppressLint({"PrivateApi"})
    public static PackageInfo gv() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        return (PackageInfo) Class.forName("android.webkit.WebViewFactory").getMethod("getLoadedPackageInfo", null).invoke(null, null);
    }

    @Nullable
    public static PackageInfo n3() {
        if (Build.VERSION.SDK_INT >= 26) {
            return qj.zn.y();
        }
        try {
            return gv();
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            return null;
        }
    }

    public static wz v(WebView webView) {
        return new wz(y(webView));
    }

    public static WebViewProviderBoundaryInterface y(WebView webView) {
        return zn().createWebView(webView);
    }

    public static xc zn() {
        return tl.zn();
    }
}
