package androidx.fragment.app;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import y5.b;
import y5.k5;
/* loaded from: classes.dex */
public final class FragmentViewModelLazyKt$viewModels$2 extends Lambda implements Function0<b> {
    final /* synthetic */ Function0 $ownerProducer;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FragmentViewModelLazyKt$viewModels$2(Function0 function0) {
        super(0);
        this.$ownerProducer = function0;
    }

    @Override // kotlin.jvm.functions.Function0
    public final b invoke() {
        b viewModelStore = ((k5) this.$ownerProducer.invoke()).getViewModelStore();
        Intrinsics.checkNotNullExpressionValue(viewModelStore, "ownerProducer().viewModelStore");
        return viewModelStore;
    }
}
