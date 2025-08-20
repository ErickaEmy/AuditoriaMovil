package j0;

import android.util.Log;
import java.util.List;
/* loaded from: classes.dex */
public final class mt implements Runnable {

    /* renamed from: fb  reason: collision with root package name */
    public final /* synthetic */ co f9356fb;

    /* renamed from: v  reason: collision with root package name */
    public final /* synthetic */ n0.ej f9357v;
    public final /* synthetic */ List y;

    public mt(co coVar, List list, n0.ej ejVar) {
        this.f9356fb = coVar;
        this.y = list;
        this.f9357v = ejVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        r rVar;
        try {
            rVar = this.f9356fb.f9355zn;
            if (rVar.n3(this.y)) {
                co.gv(this.f9356fb, this.f9357v);
            } else {
                co.zn(this.f9356fb, this.y, this.f9357v);
            }
        } catch (Exception e2) {
            Log.e("SplitCompat", "Error checking verified files.", e2);
            this.f9357v.zzb(-11);
        }
    }
}
