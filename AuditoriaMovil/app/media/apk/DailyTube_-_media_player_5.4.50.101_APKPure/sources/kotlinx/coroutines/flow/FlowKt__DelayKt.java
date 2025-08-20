package kotlinx.coroutines.flow;

import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.flow.internal.FlowCoroutineKt;
/* loaded from: classes.dex */
final /* synthetic */ class FlowKt__DelayKt {
    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> Flow<T> debounce(Flow<? extends T> flow, final long j2) {
        int i = (j2 > 0L ? 1 : (j2 == 0L ? 0 : -1));
        if (i >= 0) {
            if (i == 0) {
                return flow;
            }
            return debounceInternal$FlowKt__DelayKt(flow, new Function1<T, Long>() { // from class: kotlinx.coroutines.flow.FlowKt__DelayKt$debounce$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function1
                public final Long invoke(T t2) {
                    return Long.valueOf(j2);
                }

                /* JADX WARN: Multi-variable type inference failed */
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Long invoke(Object obj) {
                    return invoke((FlowKt__DelayKt$debounce$2<T>) obj);
                }
            });
        }
        throw new IllegalArgumentException("Debounce timeout should not be negative");
    }

    private static final <T> Flow<T> debounceInternal$FlowKt__DelayKt(Flow<? extends T> flow, Function1<? super T, Long> function1) {
        return FlowCoroutineKt.scopedFlow(new FlowKt__DelayKt$debounceInternal$1(function1, flow, null));
    }
}
