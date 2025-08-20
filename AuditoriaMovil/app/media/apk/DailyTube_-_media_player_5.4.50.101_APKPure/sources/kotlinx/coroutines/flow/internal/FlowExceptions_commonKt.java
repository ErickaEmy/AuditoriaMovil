package kotlinx.coroutines.flow.internal;

import kotlinx.coroutines.flow.FlowCollector;
/* loaded from: classes.dex */
public final class FlowExceptions_commonKt {
    public static final void checkOwnership(AbortFlowException abortFlowException, FlowCollector<?> flowCollector) {
        if (abortFlowException.owner == flowCollector) {
            return;
        }
        throw abortFlowException;
    }
}
