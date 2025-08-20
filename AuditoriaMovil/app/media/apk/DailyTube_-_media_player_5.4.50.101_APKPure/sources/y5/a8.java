package y5;

import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
/* loaded from: classes.dex */
public final class a8 {
    public static final CoroutineScope y(ud viewModelScope) {
        Intrinsics.checkNotNullParameter(viewModelScope, "$this$viewModelScope");
        CoroutineScope coroutineScope = (CoroutineScope) viewModelScope.getTag("androidx.lifecycle.ViewModelCoroutineScope.JOB_KEY");
        if (coroutineScope != null) {
            return coroutineScope;
        }
        Object tagIfAbsent = viewModelScope.setTagIfAbsent("androidx.lifecycle.ViewModelCoroutineScope.JOB_KEY", new zn(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getMain().getImmediate())));
        Intrinsics.checkNotNullExpressionValue(tagIfAbsent, "setTagIfAbsent(\n        …Main.immediate)\n        )");
        return (CoroutineScope) tagIfAbsent;
    }
}
