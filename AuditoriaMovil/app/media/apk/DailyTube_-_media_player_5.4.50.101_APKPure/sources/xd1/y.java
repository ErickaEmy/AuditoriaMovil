package xd1;

import java.util.HashMap;
import java.util.HashSet;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import vd1.gv;
import vd1.zn;
/* loaded from: classes.dex */
public final class y {

    /* renamed from: gv  reason: collision with root package name */
    public final HashSet<zd1.y> f14944gv;

    /* renamed from: n3  reason: collision with root package name */
    public HashSet<gv<?>> f14945n3;
    public final boolean y;

    /* renamed from: zn  reason: collision with root package name */
    public final HashMap<String, zn<?>> f14946zn;

    public y() {
        this(false, 1, null);
    }

    public static /* synthetic */ void a(y yVar, String str, zn znVar, boolean z2, int i, Object obj) {
        if ((i & 4) != 0) {
            z2 = false;
        }
        yVar.v(str, znVar, z2);
    }

    public final HashSet<zd1.y> gv() {
        return this.f14944gv;
    }

    public final HashSet<gv<?>> n3() {
        return this.f14945n3;
    }

    public final void v(String mapping, zn<?> factory, boolean z2) {
        Intrinsics.checkNotNullParameter(mapping, "mapping");
        Intrinsics.checkNotNullParameter(factory, "factory");
        if (!z2 && this.f14946zn.containsKey(mapping)) {
            n3.y(factory, mapping);
        }
        this.f14946zn.put(mapping, factory);
    }

    public final boolean y() {
        return this.y;
    }

    public final HashMap<String, zn<?>> zn() {
        return this.f14946zn;
    }

    public y(boolean z2) {
        this.y = z2;
        this.f14945n3 = new HashSet<>();
        this.f14946zn = new HashMap<>();
        this.f14944gv = new HashSet<>();
    }

    public /* synthetic */ y(boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z2);
    }
}
