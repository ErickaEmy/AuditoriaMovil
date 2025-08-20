package androidx.lifecycle;

import androidx.lifecycle.v;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;
import y5.co;
/* loaded from: classes.dex */
public final class LifecycleController {

    /* renamed from: gv  reason: collision with root package name */
    public final y5.s f2580gv;

    /* renamed from: n3  reason: collision with root package name */
    public final v f2581n3;
    public final a y;

    /* renamed from: zn  reason: collision with root package name */
    public final v.zn f2582zn;

    public LifecycleController(v lifecycle, v.zn minState, y5.s dispatchQueue, final Job parentJob) {
        Intrinsics.checkNotNullParameter(lifecycle, "lifecycle");
        Intrinsics.checkNotNullParameter(minState, "minState");
        Intrinsics.checkNotNullParameter(dispatchQueue, "dispatchQueue");
        Intrinsics.checkNotNullParameter(parentJob, "parentJob");
        this.f2581n3 = lifecycle;
        this.f2582zn = minState;
        this.f2580gv = dispatchQueue;
        a aVar = new a() { // from class: androidx.lifecycle.LifecycleController$observer$1
            @Override // androidx.lifecycle.a
            public final void onStateChanged(co source, v.n3 n3Var) {
                v.zn znVar;
                y5.s sVar;
                y5.s sVar2;
                Intrinsics.checkNotNullParameter(source, "source");
                Intrinsics.checkNotNullParameter(n3Var, "<anonymous parameter 1>");
                v lifecycle2 = source.getLifecycle();
                Intrinsics.checkNotNullExpressionValue(lifecycle2, "source.lifecycle");
                if (lifecycle2.n3() == v.zn.DESTROYED) {
                    LifecycleController lifecycleController = LifecycleController.this;
                    Job.DefaultImpls.cancel$default(parentJob, null, 1, null);
                    lifecycleController.zn();
                    return;
                }
                v lifecycle3 = source.getLifecycle();
                Intrinsics.checkNotNullExpressionValue(lifecycle3, "source.lifecycle");
                v.zn n32 = lifecycle3.n3();
                znVar = LifecycleController.this.f2582zn;
                if (n32.compareTo(znVar) < 0) {
                    sVar2 = LifecycleController.this.f2580gv;
                    sVar2.fb();
                    return;
                }
                sVar = LifecycleController.this.f2580gv;
                sVar.s();
            }
        };
        this.y = aVar;
        if (lifecycle.n3() == v.zn.DESTROYED) {
            Job.DefaultImpls.cancel$default(parentJob, null, 1, null);
            zn();
            return;
        }
        lifecycle.y(aVar);
    }

    public final void zn() {
        this.f2581n3.zn(this.y);
        this.f2580gv.a();
    }
}
