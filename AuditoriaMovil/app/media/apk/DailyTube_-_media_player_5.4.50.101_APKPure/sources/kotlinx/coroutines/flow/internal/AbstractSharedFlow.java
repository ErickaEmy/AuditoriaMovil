package kotlinx.coroutines.flow.internal;

import java.util.Arrays;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot;
/* loaded from: classes.dex */
public abstract class AbstractSharedFlow<S extends AbstractSharedFlowSlot<?>> {
    private SubscriptionCountStateFlow _subscriptionCount;
    private int nCollectors;
    private int nextIndex;
    private S[] slots;

    public static final /* synthetic */ int access$getNCollectors(AbstractSharedFlow abstractSharedFlow) {
        return abstractSharedFlow.nCollectors;
    }

    public static final /* synthetic */ AbstractSharedFlowSlot[] access$getSlots(AbstractSharedFlow abstractSharedFlow) {
        return abstractSharedFlow.slots;
    }

    public final S allocateSlot() {
        S s2;
        SubscriptionCountStateFlow subscriptionCountStateFlow;
        synchronized (this) {
            try {
                S[] sArr = this.slots;
                if (sArr == null) {
                    sArr = createSlotArray(2);
                    this.slots = sArr;
                } else if (this.nCollectors >= sArr.length) {
                    Object[] copyOf = Arrays.copyOf(sArr, sArr.length * 2);
                    Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
                    this.slots = (S[]) ((AbstractSharedFlowSlot[]) copyOf);
                    sArr = (S[]) ((AbstractSharedFlowSlot[]) copyOf);
                }
                int i = this.nextIndex;
                do {
                    s2 = sArr[i];
                    if (s2 == null) {
                        s2 = createSlot();
                        sArr[i] = s2;
                    }
                    i++;
                    if (i >= sArr.length) {
                        i = 0;
                    }
                    Intrinsics.checkNotNull(s2, "null cannot be cast to non-null type kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot<kotlin.Any>");
                } while (!s2.allocateLocked(this));
                this.nextIndex = i;
                this.nCollectors++;
                subscriptionCountStateFlow = this._subscriptionCount;
            } catch (Throwable th) {
                throw th;
            }
        }
        if (subscriptionCountStateFlow != null) {
            subscriptionCountStateFlow.increment(1);
        }
        return s2;
    }

    public abstract S createSlot();

    public abstract S[] createSlotArray(int i);

    public final void freeSlot(S s2) {
        SubscriptionCountStateFlow subscriptionCountStateFlow;
        int i;
        Continuation<Unit>[] freeLocked;
        synchronized (this) {
            try {
                int i5 = this.nCollectors - 1;
                this.nCollectors = i5;
                subscriptionCountStateFlow = this._subscriptionCount;
                if (i5 == 0) {
                    this.nextIndex = 0;
                }
                Intrinsics.checkNotNull(s2, "null cannot be cast to non-null type kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot<kotlin.Any>");
                freeLocked = s2.freeLocked(this);
            } catch (Throwable th) {
                throw th;
            }
        }
        for (Continuation<Unit> continuation : freeLocked) {
            if (continuation != null) {
                Result.Companion companion = Result.Companion;
                continuation.resumeWith(Result.m28constructorimpl(Unit.INSTANCE));
            }
        }
        if (subscriptionCountStateFlow != null) {
            subscriptionCountStateFlow.increment(-1);
        }
    }

    public final int getNCollectors() {
        return this.nCollectors;
    }

    public final S[] getSlots() {
        return this.slots;
    }

    public final StateFlow<Integer> getSubscriptionCount() {
        SubscriptionCountStateFlow subscriptionCountStateFlow;
        synchronized (this) {
            subscriptionCountStateFlow = this._subscriptionCount;
            if (subscriptionCountStateFlow == null) {
                subscriptionCountStateFlow = new SubscriptionCountStateFlow(this.nCollectors);
                this._subscriptionCount = subscriptionCountStateFlow;
            }
        }
        return subscriptionCountStateFlow;
    }
}
