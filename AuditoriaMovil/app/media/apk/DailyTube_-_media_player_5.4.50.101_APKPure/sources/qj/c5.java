package qj;

import android.webkit.ServiceWorkerController;
import androidx.annotation.Nullable;
import org.chromium.support_lib_boundary.ServiceWorkerControllerBoundaryInterface;
import qj.y;
/* loaded from: classes.dex */
public class c5 extends qk.n3 {

    /* renamed from: n3  reason: collision with root package name */
    public ServiceWorkerControllerBoundaryInterface f12927n3;
    public ServiceWorkerController y;

    /* renamed from: zn  reason: collision with root package name */
    public final qk.zn f12928zn;

    public c5() {
        y.zn znVar = t.f12942f;
        if (znVar.n3()) {
            this.y = n3.fb();
            this.f12927n3 = null;
            this.f12928zn = n3.c5(gv());
        } else if (znVar.gv()) {
            this.y = null;
            ServiceWorkerControllerBoundaryInterface serviceWorkerController = tl.zn().getServiceWorkerController();
            this.f12927n3 = serviceWorkerController;
            this.f12928zn = new i9(serviceWorkerController.getServiceWorkerWebSettings());
        } else {
            throw t.y();
        }
    }

    public final ServiceWorkerController gv() {
        if (this.y == null) {
            this.y = n3.fb();
        }
        return this.y;
    }

    @Override // qk.n3
    public void n3(@Nullable qk.y yVar) {
        y.zn znVar = t.f12942f;
        if (znVar.n3()) {
            if (yVar == null) {
                n3.w(gv(), null);
            } else {
                n3.p(gv(), yVar);
            }
        } else if (znVar.gv()) {
            if (yVar == null) {
                zn().setServiceWorkerClient(null);
            } else {
                zn().setServiceWorkerClient(cd1.y.zn(new s(yVar)));
            }
        } else {
            throw t.y();
        }
    }

    public final ServiceWorkerControllerBoundaryInterface zn() {
        if (this.f12927n3 == null) {
            this.f12927n3 = tl.zn().getServiceWorkerController();
        }
        return this.f12927n3;
    }
}
