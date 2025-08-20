package ae1;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public final class zn {

    /* renamed from: gv  reason: collision with root package name */
    public final be1.y f106gv;

    /* renamed from: n3  reason: collision with root package name */
    public final HashSet<zd1.y> f107n3;
    public final qd1.y y;

    /* renamed from: zn  reason: collision with root package name */
    public final Map<String, be1.y> f108zn;

    /* renamed from: v  reason: collision with root package name */
    public static final y f105v = new y(null);

    /* renamed from: a  reason: collision with root package name */
    public static final zd1.zn f104a = zd1.n3.y("_");

    /* loaded from: classes.dex */
    public static final class y {
        public /* synthetic */ y(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final zd1.zn y() {
            return zn.f104a;
        }

        public y() {
        }
    }

    public zn(qd1.y _koin) {
        Intrinsics.checkNotNullParameter(_koin, "_koin");
        this.y = _koin;
        HashSet<zd1.y> hashSet = new HashSet<>();
        this.f107n3 = hashSet;
        Map<String, be1.y> gv2 = fe1.y.y.gv();
        this.f108zn = gv2;
        be1.y yVar = new be1.y(f104a, "_", true, _koin);
        this.f106gv = yVar;
        hashSet.add(yVar.fb());
        gv2.put(yVar.v(), yVar);
    }

    public final void gv(List<xd1.y> modules) {
        Intrinsics.checkNotNullParameter(modules, "modules");
        for (xd1.y yVar : modules) {
            zn(yVar);
        }
    }

    public final be1.y n3() {
        return this.f106gv;
    }

    public final void zn(xd1.y yVar) {
        this.f107n3.addAll(yVar.gv());
    }
}
