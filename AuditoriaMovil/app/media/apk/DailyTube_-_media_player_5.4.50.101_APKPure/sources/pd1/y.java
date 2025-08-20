package pd1;

import androidx.lifecycle.wz;
import kotlin.jvm.internal.Intrinsics;
import od1.n3;
import y5.ud;
/* loaded from: classes.dex */
public final class y<T extends ud> implements wz.n3 {

    /* renamed from: n3  reason: collision with root package name */
    public final n3<T> f12596n3;
    public final be1.y y;

    public y(be1.y scope, n3<T> parameters) {
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        this.y = scope;
        this.f12596n3 = parameters;
    }

    @Override // androidx.lifecycle.wz.n3
    public <T extends ud> T create(Class<T> modelClass) {
        Intrinsics.checkNotNullParameter(modelClass, "modelClass");
        return (T) this.y.zn(this.f12596n3.y(), this.f12596n3.zn(), this.f12596n3.n3());
    }
}
