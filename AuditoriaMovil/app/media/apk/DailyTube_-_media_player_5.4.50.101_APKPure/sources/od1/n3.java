package od1;

import android.os.Bundle;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import y5.k5;
/* loaded from: classes.dex */
public final class n3<T> {

    /* renamed from: a  reason: collision with root package name */
    public final g.y f12262a;

    /* renamed from: gv  reason: collision with root package name */
    public final Function0<yd1.y> f12263gv;

    /* renamed from: n3  reason: collision with root package name */
    public final zd1.y f12264n3;

    /* renamed from: v  reason: collision with root package name */
    public final k5 f12265v;
    public final KClass<T> y;

    /* renamed from: zn  reason: collision with root package name */
    public final Function0<Bundle> f12266zn;

    /* JADX WARN: Multi-variable type inference failed */
    public n3(KClass<T> clazz, zd1.y yVar, Function0<Bundle> function0, Function0<? extends yd1.y> function02, k5 viewModelStoreOwner, g.y yVar2) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        Intrinsics.checkNotNullParameter(viewModelStoreOwner, "viewModelStoreOwner");
        this.y = clazz;
        this.f12264n3 = yVar;
        this.f12266zn = function0;
        this.f12263gv = function02;
        this.f12265v = viewModelStoreOwner;
        this.f12262a = yVar2;
    }

    public final g.y gv() {
        return this.f12262a;
    }

    public final Function0<yd1.y> n3() {
        return this.f12263gv;
    }

    public final Function0<Bundle> v() {
        return this.f12266zn;
    }

    public final KClass<T> y() {
        return this.y;
    }

    public final zd1.y zn() {
        return this.f12264n3;
    }
}
