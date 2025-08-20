package kotlinx.coroutines.flow.internal;

import kotlinx.coroutines.flow.FlowCollector;
/* compiled from: FlowExceptions.common.kt */
/* loaded from: classes2.dex */
public abstract class FlowExceptions_commonKt {
    public static final void checkOwnership(AbortFlowException abortFlowException, FlowCollector flowCollector) {
        if (abortFlowException.owner != flowCollector) {
            throw abortFlowException;
        }
    }
}
