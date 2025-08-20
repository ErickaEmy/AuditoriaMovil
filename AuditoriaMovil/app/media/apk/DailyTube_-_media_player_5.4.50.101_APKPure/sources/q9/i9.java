package q9;

import androidx.annotation.Nullable;
import androidx.databinding.ViewDataBinding;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import y5.co;
/* loaded from: classes.dex */
public class i9<T> extends WeakReference<ViewDataBinding> {

    /* renamed from: n3  reason: collision with root package name */
    public final int f12787n3;
    public final fb<T> y;

    /* renamed from: zn  reason: collision with root package name */
    public T f12788zn;

    public i9(ViewDataBinding viewDataBinding, int i, fb<T> fbVar, ReferenceQueue<ViewDataBinding> referenceQueue) {
        super(viewDataBinding, referenceQueue);
        this.f12787n3 = i;
        this.y = fbVar;
    }

    public void gv(T t2) {
        v();
        this.f12788zn = t2;
        if (t2 != null) {
            this.y.zn(t2);
        }
    }

    public T n3() {
        return this.f12788zn;
    }

    public boolean v() {
        boolean z2;
        T t2 = this.f12788zn;
        if (t2 != null) {
            this.y.y(t2);
            z2 = true;
        } else {
            z2 = false;
        }
        this.f12788zn = null;
        return z2;
    }

    @Nullable
    public ViewDataBinding y() {
        ViewDataBinding viewDataBinding = (ViewDataBinding) get();
        if (viewDataBinding == null) {
            v();
        }
        return viewDataBinding;
    }

    public void zn(co coVar) {
        this.y.n3(coVar);
    }
}
