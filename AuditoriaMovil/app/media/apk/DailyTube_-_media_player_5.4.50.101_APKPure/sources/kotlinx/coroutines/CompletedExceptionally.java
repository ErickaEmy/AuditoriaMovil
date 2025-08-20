package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* loaded from: classes.dex */
public class CompletedExceptionally {
    private static final AtomicIntegerFieldUpdater _handled$FU = AtomicIntegerFieldUpdater.newUpdater(CompletedExceptionally.class, "_handled");
    private volatile int _handled;
    public final Throwable cause;

    public CompletedExceptionally(Throwable th, boolean z2) {
        this.cause = th;
        this._handled = z2 ? 1 : 0;
    }

    public final boolean getHandled() {
        if (_handled$FU.get(this) != 0) {
            return true;
        }
        return false;
    }

    public final boolean makeHandled() {
        return _handled$FU.compareAndSet(this, 0, 1);
    }

    public String toString() {
        return DebugStringsKt.getClassSimpleName(this) + '[' + this.cause + ']';
    }

    public /* synthetic */ CompletedExceptionally(Throwable th, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(th, (i & 2) != 0 ? false : z2);
    }
}
