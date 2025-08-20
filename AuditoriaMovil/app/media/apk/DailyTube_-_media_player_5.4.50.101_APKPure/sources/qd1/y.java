package qd1;

import ae1.zn;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
/* loaded from: classes.dex */
public final class y {
    public final zn y = new zn(this);

    /* renamed from: n3  reason: collision with root package name */
    public final ae1.y f12809n3 = new ae1.y(this);

    /* renamed from: zn  reason: collision with root package name */
    public final ae1.n3 f12810zn = new ae1.n3(this);

    /* renamed from: gv  reason: collision with root package name */
    public wd1.zn f12808gv = new wd1.y();

    /* renamed from: qd1.y$y  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0186y extends Lambda implements Function0<Unit> {
        public C0186y() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2() {
            y.this.n3().y();
        }
    }

    public static /* synthetic */ void fb(y yVar, List list, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            z2 = true;
        }
        yVar.a(list, z2);
    }

    public final void a(List<xd1.y> modules, boolean z2) {
        Intrinsics.checkNotNullParameter(modules, "modules");
        this.f12809n3.v(modules, z2);
        this.y.gv(modules);
    }

    public final void c5(wd1.zn logger) {
        Intrinsics.checkNotNullParameter(logger, "logger");
        this.f12808gv = logger;
    }

    public final <T> T gv(String key, T defaultValue) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        T t2 = (T) this.f12810zn.y(key);
        if (t2 != null) {
            return t2;
        }
        return defaultValue;
    }

    public final ae1.y n3() {
        return this.f12809n3;
    }

    public final void s(String key, Object value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        this.f12810zn.n3(key, value);
    }

    public final zn v() {
        return this.y;
    }

    public final void y() {
        this.f12808gv.a("create eager instances ...");
        if (this.f12808gv.fb(wd1.n3.DEBUG)) {
            double y = ce1.y.y(new C0186y());
            wd1.zn znVar = this.f12808gv;
            znVar.n3("eager instances created in " + y + " ms");
            return;
        }
        this.f12809n3.y();
    }

    public final wd1.zn zn() {
        return this.f12808gv;
    }
}
