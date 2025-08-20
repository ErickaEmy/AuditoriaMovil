package rc1;

import kc1.z;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import zc1.fb;
/* loaded from: classes.dex */
public final class y {

    /* renamed from: zn  reason: collision with root package name */
    public static final C0205y f13316zn = new C0205y(null);

    /* renamed from: n3  reason: collision with root package name */
    public final fb f13317n3;
    public long y;

    /* renamed from: rc1.y$y  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0205y {
        public C0205y() {
        }

        public /* synthetic */ C0205y(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public y(fb source) {
        Intrinsics.checkNotNullParameter(source, "source");
        this.f13317n3 = source;
        this.y = 262144;
    }

    public final String n3() {
        String f32 = this.f13317n3.f3(this.y);
        this.y -= f32.length();
        return f32;
    }

    public final z y() {
        z.y yVar = new z.y();
        while (true) {
            String n32 = n3();
            if (n32.length() == 0) {
                return yVar.a();
            }
            yVar.zn(n32);
        }
    }
}
