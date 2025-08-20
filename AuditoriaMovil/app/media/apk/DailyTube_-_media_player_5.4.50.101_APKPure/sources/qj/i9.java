package qj;

import android.webkit.ServiceWorkerWebSettings;
import androidx.annotation.NonNull;
import java.lang.reflect.InvocationHandler;
import org.chromium.support_lib_boundary.ServiceWorkerWebSettingsBoundaryInterface;
/* loaded from: classes.dex */
public class i9 extends qk.zn {

    /* renamed from: n3  reason: collision with root package name */
    public ServiceWorkerWebSettingsBoundaryInterface f12931n3;
    public ServiceWorkerWebSettings y;

    public i9(@NonNull ServiceWorkerWebSettings serviceWorkerWebSettings) {
        this.y = serviceWorkerWebSettings;
    }

    public i9(@NonNull InvocationHandler invocationHandler) {
        this.f12931n3 = (ServiceWorkerWebSettingsBoundaryInterface) cd1.y.y(ServiceWorkerWebSettingsBoundaryInterface.class, invocationHandler);
    }
}
