package vd1;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public final class n3 {

    /* renamed from: n3  reason: collision with root package name */
    public final be1.y f14451n3;
    public final qd1.y y;

    /* renamed from: zn  reason: collision with root package name */
    public final yd1.y f14452zn;

    public n3(qd1.y koin, be1.y scope, yd1.y yVar) {
        Intrinsics.checkNotNullParameter(koin, "koin");
        Intrinsics.checkNotNullParameter(scope, "scope");
        this.y = koin;
        this.f14451n3 = scope;
        this.f14452zn = yVar;
    }

    public final yd1.y n3() {
        return this.f14452zn;
    }

    public final qd1.y y() {
        return this.y;
    }

    public final be1.y zn() {
        return this.f14451n3;
    }

    public /* synthetic */ n3(qd1.y yVar, be1.y yVar2, yd1.y yVar3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(yVar, yVar2, (i & 4) != 0 ? null : yVar3);
    }
}
