package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap;

import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.CommonFunctionsKt;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
/* compiled from: PersistentHashMapContentIterators.kt */
/* loaded from: classes.dex */
public abstract class TrieNodeBaseIterator implements Iterator, KMappedMarker {
    private Object[] buffer = TrieNode.Companion.getEMPTY$runtime_release().getBuffer$runtime_release();
    private int dataSize;
    private int index;

    /* JADX INFO: Access modifiers changed from: protected */
    public final Object[] getBuffer() {
        return this.buffer;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int getIndex() {
        return this.index;
    }

    public final boolean hasNextKey() {
        return this.index < this.dataSize;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final void reset(Object[] buffer, int i, int i2) {
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        this.buffer = buffer;
        this.dataSize = i;
        this.index = i2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void setIndex(int i) {
        this.index = i;
    }

    public final void reset(Object[] buffer, int i) {
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        reset(buffer, i, 0);
    }

    public final Object currentKey() {
        CommonFunctionsKt.m626assert(hasNextKey());
        return this.buffer[this.index];
    }

    public final void moveToNextKey() {
        CommonFunctionsKt.m626assert(hasNextKey());
        this.index += 2;
    }

    public final boolean hasNextNode() {
        CommonFunctionsKt.m626assert(this.index >= this.dataSize);
        return this.index < this.buffer.length;
    }

    public final TrieNode currentNode() {
        CommonFunctionsKt.m626assert(hasNextNode());
        Object obj = this.buffer[this.index];
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode<K of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNodeBaseIterator, V of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNodeBaseIterator>");
        return (TrieNode) obj;
    }

    public final void moveToNextNode() {
        CommonFunctionsKt.m626assert(hasNextNode());
        this.index++;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return hasNextKey();
    }
}
