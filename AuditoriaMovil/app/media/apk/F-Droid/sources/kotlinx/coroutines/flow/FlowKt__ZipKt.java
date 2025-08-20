package kotlinx.coroutines.flow;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.flow.internal.CombineKt;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Zip.kt */
/* loaded from: classes2.dex */
public abstract /* synthetic */ class FlowKt__ZipKt {
    public static final Flow combine(Flow flow, Flow flow2, Function3 function3) {
        return FlowKt.flowCombine(flow, flow2, function3);
    }

    public static final Flow flowCombine(final Flow flow, final Flow flow2, final Function3 function3) {
        return new Flow() { // from class: kotlinx.coroutines.flow.FlowKt__ZipKt$combine$$inlined$unsafeFlow$1
            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector flowCollector, Continuation continuation) {
                Function0 function0;
                Object coroutine_suspended;
                Flow[] flowArr = {Flow.this, flow2};
                function0 = new Function0() { // from class: kotlinx.coroutines.flow.FlowKt__ZipKt$nullArrayFactory$1
                    @Override // kotlin.jvm.functions.Function0
                    public final Void invoke() {
                        return null;
                    }
                };
                Object combineInternal = CombineKt.combineInternal(flowCollector, flowArr, function0, new FlowKt__ZipKt$combine$1$1(function3, null), continuation);
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                return combineInternal == coroutine_suspended ? combineInternal : Unit.INSTANCE;
            }
        };
    }
}
