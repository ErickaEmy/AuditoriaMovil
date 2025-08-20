package rb;

import java.io.File;
import java.io.InputStream;
import java.util.concurrent.Callable;
import kotlin.jvm.internal.Intrinsics;
import u0.s;
/* loaded from: classes.dex */
public final class d implements s.zn {

    /* renamed from: gv  reason: collision with root package name */
    public final s.zn f13160gv;

    /* renamed from: n3  reason: collision with root package name */
    public final File f13161n3;
    public final String y;

    /* renamed from: zn  reason: collision with root package name */
    public final Callable<InputStream> f13162zn;

    public d(String str, File file, Callable<InputStream> callable, s.zn mDelegate) {
        Intrinsics.checkNotNullParameter(mDelegate, "mDelegate");
        this.y = str;
        this.f13161n3 = file;
        this.f13162zn = callable;
        this.f13160gv = mDelegate;
    }

    @Override // u0.s.zn
    public u0.s y(s.n3 configuration) {
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        return new ta(configuration.y, this.y, this.f13161n3, this.f13162zn, configuration.f14022zn.y, this.f13160gv.y(configuration));
    }
}
