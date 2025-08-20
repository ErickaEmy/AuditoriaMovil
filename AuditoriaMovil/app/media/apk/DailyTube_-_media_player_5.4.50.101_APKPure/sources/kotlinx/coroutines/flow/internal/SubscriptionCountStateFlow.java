package kotlinx.coroutines.flow.internal;

import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.SharedFlowImpl;
import kotlinx.coroutines.flow.StateFlow;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class SubscriptionCountStateFlow extends SharedFlowImpl<Integer> implements StateFlow<Integer> {
    public SubscriptionCountStateFlow(int i) {
        super(1, Integer.MAX_VALUE, BufferOverflow.DROP_OLDEST);
        tryEmit(Integer.valueOf(i));
    }

    public final boolean increment(int i) {
        boolean tryEmit;
        synchronized (this) {
            tryEmit = tryEmit(Integer.valueOf(getLastReplayedLocked().intValue() + i));
        }
        return tryEmit;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlinx.coroutines.flow.StateFlow
    public Integer getValue() {
        Integer valueOf;
        synchronized (this) {
            valueOf = Integer.valueOf(getLastReplayedLocked().intValue());
        }
        return valueOf;
    }
}
