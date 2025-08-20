package androidx.fragment.app;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import y5.b;
/* loaded from: classes.dex */
public final class FragmentViewModelLazyKt$activityViewModels$1 extends Lambda implements Function0<b> {
    final /* synthetic */ Fragment $this_activityViewModels;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FragmentViewModelLazyKt$activityViewModels$1(Fragment fragment) {
        super(0);
        this.$this_activityViewModels = fragment;
    }

    @Override // kotlin.jvm.functions.Function0
    public final b invoke() {
        FragmentActivity requireActivity = this.$this_activityViewModels.requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        b viewModelStore = requireActivity.getViewModelStore();
        Intrinsics.checkNotNullExpressionValue(viewModelStore, "requireActivity().viewModelStore");
        return viewModelStore;
    }
}
