package sd1;

import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import ud1.gv;
/* loaded from: classes.dex */
public final class n3 implements zn {

    /* renamed from: n3  reason: collision with root package name */
    public static qd1.y f13857n3;
    public static final n3 y = new n3();

    /* renamed from: zn  reason: collision with root package name */
    public static qd1.n3 f13858zn;

    public final void gv(qd1.n3 n3Var) {
        if (f13857n3 == null) {
            f13858zn = n3Var;
            f13857n3 = n3Var.n3();
            return;
        }
        throw new gv("A Koin Application has already been started");
    }

    @Override // sd1.zn
    public qd1.n3 n3(Function1<? super qd1.n3, Unit> appDeclaration) {
        qd1.n3 y2;
        Intrinsics.checkNotNullParameter(appDeclaration, "appDeclaration");
        synchronized (this) {
            y2 = qd1.n3.f12806zn.y();
            y.gv(y2);
            appDeclaration.invoke(y2);
            y2.y();
        }
        return y2;
    }

    @Override // sd1.zn
    public void y(xd1.y module) {
        Intrinsics.checkNotNullParameter(module, "module");
        synchronized (this) {
            qd1.y.fb(y.zn(), CollectionsKt.listOf(module), false, 2, null);
            Unit unit = Unit.INSTANCE;
        }
    }

    public qd1.y zn() {
        qd1.y yVar = f13857n3;
        if (yVar != null) {
            return yVar;
        }
        throw new IllegalStateException("KoinApplication has not been started");
    }
}
