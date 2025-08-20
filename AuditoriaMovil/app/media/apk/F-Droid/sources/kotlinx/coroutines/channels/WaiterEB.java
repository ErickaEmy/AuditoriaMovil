package kotlinx.coroutines.channels;

import ch.qos.logback.core.CoreConstants;
import kotlinx.coroutines.Waiter;
/* compiled from: BufferedChannel.kt */
/* loaded from: classes2.dex */
final class WaiterEB {
    public final Waiter waiter;

    public WaiterEB(Waiter waiter) {
        this.waiter = waiter;
    }

    public String toString() {
        return "WaiterEB(" + this.waiter + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }
}
