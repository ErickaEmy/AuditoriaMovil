package v;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
/* loaded from: classes.dex */
public final class y {

    /* renamed from: n3  reason: collision with root package name */
    public volatile Context f14302n3;
    public final Set<n3> y = new CopyOnWriteArraySet();

    @Nullable
    public Context gv() {
        return this.f14302n3;
    }

    public void n3() {
        this.f14302n3 = null;
    }

    public void v(@NonNull n3 n3Var) {
        this.y.remove(n3Var);
    }

    public void y(@NonNull n3 n3Var) {
        if (this.f14302n3 != null) {
            n3Var.onContextAvailable(this.f14302n3);
        }
        this.y.add(n3Var);
    }

    public void zn(@NonNull Context context) {
        this.f14302n3 = context;
        for (n3 n3Var : this.y) {
            n3Var.onContextAvailable(context);
        }
    }
}
