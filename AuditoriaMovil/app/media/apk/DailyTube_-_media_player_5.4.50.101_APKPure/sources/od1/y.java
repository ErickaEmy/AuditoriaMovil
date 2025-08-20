package od1;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import y5.k5;
/* loaded from: classes.dex */
public final class y {

    /* renamed from: zn  reason: collision with root package name */
    public static final C0175y f12267zn = new C0175y(null);

    /* renamed from: n3  reason: collision with root package name */
    public final g.y f12268n3;
    public final k5 y;

    /* renamed from: od1.y$y  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0175y {
        public /* synthetic */ C0175y(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final y y(k5 storeOwner, g.y yVar) {
            Intrinsics.checkNotNullParameter(storeOwner, "storeOwner");
            return new y(storeOwner, yVar);
        }

        public C0175y() {
        }
    }

    public y(k5 storeOwner, g.y yVar) {
        Intrinsics.checkNotNullParameter(storeOwner, "storeOwner");
        this.y = storeOwner;
        this.f12268n3 = yVar;
    }

    public final k5 n3() {
        return this.y;
    }

    public final g.y y() {
        return this.f12268n3;
    }
}
