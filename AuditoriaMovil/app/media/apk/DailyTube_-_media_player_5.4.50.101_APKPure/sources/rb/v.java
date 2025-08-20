package rb;

import kotlin.jvm.internal.Intrinsics;
import u0.s;
/* loaded from: classes.dex */
public final class v implements s.zn {

    /* renamed from: n3  reason: collision with root package name */
    public final zn f13267n3;
    public final s.zn y;

    public v(s.zn delegate, zn autoCloser) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        Intrinsics.checkNotNullParameter(autoCloser, "autoCloser");
        this.y = delegate;
        this.f13267n3 = autoCloser;
    }

    @Override // u0.s.zn
    /* renamed from: n3 */
    public gv y(s.n3 configuration) {
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        return new gv(this.y.y(configuration), this.f13267n3);
    }
}
