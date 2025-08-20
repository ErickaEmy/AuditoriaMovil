package kotlinx.coroutines.internal;

import kotlinx.coroutines.DebugStringsKt;
/* compiled from: Atomic.kt */
/* loaded from: classes2.dex */
public abstract class OpDescriptor {
    public abstract Object perform(Object obj);

    public String toString() {
        return DebugStringsKt.getClassSimpleName(this) + '@' + DebugStringsKt.getHexAddress(this);
    }
}
