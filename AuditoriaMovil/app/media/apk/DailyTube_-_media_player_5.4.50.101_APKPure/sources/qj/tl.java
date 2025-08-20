package qj;

import android.os.Build;
import android.webkit.WebView;
import androidx.annotation.NonNull;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.chromium.support_lib_boundary.WebViewProviderFactoryBoundaryInterface;
/* loaded from: classes.dex */
public class tl {

    /* loaded from: classes.dex */
    public static class y {
        public static final xc y = tl.y();
    }

    @NonNull
    public static ClassLoader gv() {
        if (Build.VERSION.SDK_INT >= 28) {
            return gv.n3();
        }
        return v().getClass().getClassLoader();
    }

    public static InvocationHandler n3() throws IllegalAccessException, InvocationTargetException, ClassNotFoundException, NoSuchMethodException {
        return (InvocationHandler) Class.forName("org.chromium.support_lib_glue.SupportLibReflectionUtil", false, gv()).getDeclaredMethod("createWebViewProviderFactory", null).invoke(null, null);
    }

    public static Object v() {
        try {
            Method declaredMethod = WebView.class.getDeclaredMethod("getFactory", null);
            declaredMethod.setAccessible(true);
            return declaredMethod.invoke(null, null);
        } catch (IllegalAccessException e2) {
            throw new RuntimeException(e2);
        } catch (NoSuchMethodException e3) {
            throw new RuntimeException(e3);
        } catch (InvocationTargetException e5) {
            throw new RuntimeException(e5);
        }
    }

    @NonNull
    public static xc y() {
        try {
            return new w((WebViewProviderFactoryBoundaryInterface) cd1.y.y(WebViewProviderFactoryBoundaryInterface.class, n3()));
        } catch (ClassNotFoundException unused) {
            return new fb();
        } catch (IllegalAccessException e2) {
            throw new RuntimeException(e2);
        } catch (NoSuchMethodException e3) {
            throw new RuntimeException(e3);
        } catch (InvocationTargetException e5) {
            throw new RuntimeException(e5);
        }
    }

    @NonNull
    public static xc zn() {
        return y.y;
    }
}
