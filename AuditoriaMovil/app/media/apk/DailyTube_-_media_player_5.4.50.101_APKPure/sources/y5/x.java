package y5;

import androidx.lifecycle.wz;
import kotlin.Lazy;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import y5.ud;
/* loaded from: classes.dex */
public final class x<VM extends ud> implements Lazy<VM> {

    /* renamed from: fb  reason: collision with root package name */
    public final Function0<b> f15309fb;

    /* renamed from: s  reason: collision with root package name */
    public final Function0<wz.n3> f15310s;

    /* renamed from: v  reason: collision with root package name */
    public final KClass<VM> f15311v;
    public VM y;

    /* JADX WARN: Multi-variable type inference failed */
    public x(KClass<VM> viewModelClass, Function0<? extends b> storeProducer, Function0<? extends wz.n3> factoryProducer) {
        Intrinsics.checkNotNullParameter(viewModelClass, "viewModelClass");
        Intrinsics.checkNotNullParameter(storeProducer, "storeProducer");
        Intrinsics.checkNotNullParameter(factoryProducer, "factoryProducer");
        this.f15311v = viewModelClass;
        this.f15309fb = storeProducer;
        this.f15310s = factoryProducer;
    }

    @Override // kotlin.Lazy
    public boolean isInitialized() {
        if (this.y != null) {
            return true;
        }
        return false;
    }

    @Override // kotlin.Lazy
    /* renamed from: y */
    public VM getValue() {
        VM vm = this.y;
        if (vm == null) {
            VM vm2 = (VM) new androidx.lifecycle.wz(this.f15309fb.invoke(), this.f15310s.invoke()).y(JvmClassMappingKt.getJavaClass(this.f15311v));
            this.y = vm2;
            Intrinsics.checkNotNullExpressionValue(vm2, "ViewModelProvider(store,…ed = it\n                }");
            return vm2;
        }
        return vm;
    }
}
