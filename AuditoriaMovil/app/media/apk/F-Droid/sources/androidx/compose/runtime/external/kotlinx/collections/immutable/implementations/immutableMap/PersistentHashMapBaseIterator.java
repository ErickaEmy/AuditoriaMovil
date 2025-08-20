package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
/* compiled from: PersistentHashMapContentIterators.kt */
/* loaded from: classes.dex */
public abstract class PersistentHashMapBaseIterator implements Iterator, KMappedMarker {
    private boolean hasNext;
    private final TrieNodeBaseIterator[] path;
    private int pathLastIndex;

    /* JADX INFO: Access modifiers changed from: protected */
    public final TrieNodeBaseIterator[] getPath() {
        return this.path;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.hasNext;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void setPathLastIndex(int i) {
        this.pathLastIndex = i;
    }

    public PersistentHashMapBaseIterator(TrieNode node, TrieNodeBaseIterator[] path) {
        Intrinsics.checkNotNullParameter(node, "node");
        Intrinsics.checkNotNullParameter(path, "path");
        this.path = path;
        this.hasNext = true;
        path[0].reset(node.getBuffer$runtime_release(), node.entryCount$runtime_release() * 2);
        this.pathLastIndex = 0;
        ensureNextEntryIsReady();
    }

    private final int moveToNextNodeWithData(int i) {
        if (this.path[i].hasNextKey()) {
            return i;
        }
        if (this.path[i].hasNextNode()) {
            TrieNode currentNode = this.path[i].currentNode();
            if (i == 6) {
                this.path[i + 1].reset(currentNode.getBuffer$runtime_release(), currentNode.getBuffer$runtime_release().length);
            } else {
                this.path[i + 1].reset(currentNode.getBuffer$runtime_release(), currentNode.entryCount$runtime_release() * 2);
            }
            return moveToNextNodeWithData(i + 1);
        }
        return -1;
    }

    private final void ensureNextEntryIsReady() {
        if (this.path[this.pathLastIndex].hasNextKey()) {
            return;
        }
        for (int i = this.pathLastIndex; -1 < i; i--) {
            int moveToNextNodeWithData = moveToNextNodeWithData(i);
            if (moveToNextNodeWithData == -1 && this.path[i].hasNextNode()) {
                this.path[i].moveToNextNode();
                moveToNextNodeWithData = moveToNextNodeWithData(i);
            }
            if (moveToNextNodeWithData != -1) {
                this.pathLastIndex = moveToNextNodeWithData;
                return;
            }
            if (i > 0) {
                this.path[i - 1].moveToNextNode();
            }
            this.path[i].reset(TrieNode.Companion.getEMPTY$runtime_release().getBuffer$runtime_release(), 0);
        }
        this.hasNext = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Object currentKey() {
        checkHasNext();
        return this.path[this.pathLastIndex].currentKey();
    }

    @Override // java.util.Iterator
    public Object next() {
        checkHasNext();
        Object next = this.path[this.pathLastIndex].next();
        ensureNextEntryIsReady();
        return next;
    }

    private final void checkHasNext() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
    }
}
