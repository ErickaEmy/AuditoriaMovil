package io.ktor.events;

import io.ktor.util.collections.CopyOnWriteHashMap;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.LockFreeLinkedListHead;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
/* compiled from: Events.kt */
/* loaded from: classes.dex */
public final class Events {
    private final CopyOnWriteHashMap handlers = new CopyOnWriteHashMap();

    public final void raise(EventDefinition definition, Object obj) {
        Intrinsics.checkNotNullParameter(definition, "definition");
        LockFreeLinkedListHead lockFreeLinkedListHead = (LockFreeLinkedListHead) this.handlers.get(definition);
        if (lockFreeLinkedListHead != null) {
            Object next = lockFreeLinkedListHead.getNext();
            Intrinsics.checkNotNull(next, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
            for (LockFreeLinkedListNode lockFreeLinkedListNode = (LockFreeLinkedListNode) next; !Intrinsics.areEqual(lockFreeLinkedListNode, lockFreeLinkedListHead); lockFreeLinkedListNode = lockFreeLinkedListNode.getNextNode()) {
            }
        }
    }
}
