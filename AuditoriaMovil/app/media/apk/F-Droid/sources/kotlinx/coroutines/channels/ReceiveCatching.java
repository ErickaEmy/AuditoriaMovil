package kotlinx.coroutines.channels;

import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.Waiter;
import kotlinx.coroutines.internal.Segment;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BufferedChannel.kt */
/* loaded from: classes2.dex */
public final class ReceiveCatching implements Waiter {
    public final CancellableContinuationImpl cont;

    @Override // kotlinx.coroutines.Waiter
    public void invokeOnCancellation(Segment segment, int i) {
        this.cont.invokeOnCancellation(segment, i);
    }

    public ReceiveCatching(CancellableContinuationImpl cancellableContinuationImpl) {
        this.cont = cancellableContinuationImpl;
    }
}
