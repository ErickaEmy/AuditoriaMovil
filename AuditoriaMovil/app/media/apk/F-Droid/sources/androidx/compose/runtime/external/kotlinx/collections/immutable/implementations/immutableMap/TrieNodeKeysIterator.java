package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap;

import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.CommonFunctionsKt;
/* compiled from: PersistentHashMapContentIterators.kt */
/* loaded from: classes.dex */
public final class TrieNodeKeysIterator extends TrieNodeBaseIterator {
    @Override // java.util.Iterator
    public Object next() {
        CommonFunctionsKt.m626assert(hasNextKey());
        setIndex(getIndex() + 2);
        return getBuffer()[getIndex() - 2];
    }
}
