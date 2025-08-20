package kotlinx.coroutines.internal;

import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public final class LockFreeLinkedListKt {
    private static final Object CONDITION_FALSE = new Symbol("CONDITION_FALSE");

    public static final Object getCONDITION_FALSE() {
        return CONDITION_FALSE;
    }

    public static final LockFreeLinkedListNode unwrap(Object obj) {
        Removed removed;
        LockFreeLinkedListNode lockFreeLinkedListNode;
        if (obj instanceof Removed) {
            removed = (Removed) obj;
        } else {
            removed = null;
        }
        if (removed == null || (lockFreeLinkedListNode = removed.ref) == null) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
            return (LockFreeLinkedListNode) obj;
        }
        return lockFreeLinkedListNode;
    }
}
