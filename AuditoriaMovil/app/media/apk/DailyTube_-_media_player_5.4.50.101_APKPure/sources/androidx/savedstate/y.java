package androidx.savedstate;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.v;
/* loaded from: classes.dex */
public final class y {

    /* renamed from: n3  reason: collision with root package name */
    public final SavedStateRegistry f3380n3 = new SavedStateRegistry();
    public final g.y y;

    public y(g.y yVar) {
        this.y = yVar;
    }

    @NonNull
    public static y y(@NonNull g.y yVar) {
        return new y(yVar);
    }

    public void gv(@NonNull Bundle bundle) {
        this.f3380n3.zn(bundle);
    }

    @NonNull
    public SavedStateRegistry n3() {
        return this.f3380n3;
    }

    public void zn(@Nullable Bundle bundle) {
        v lifecycle = this.y.getLifecycle();
        if (lifecycle.n3() == v.zn.INITIALIZED) {
            lifecycle.y(new Recreator(this.y));
            this.f3380n3.n3(lifecycle, bundle);
            return;
        }
        throw new IllegalStateException("Restarter must be created only during owner's initialization stage");
    }
}
