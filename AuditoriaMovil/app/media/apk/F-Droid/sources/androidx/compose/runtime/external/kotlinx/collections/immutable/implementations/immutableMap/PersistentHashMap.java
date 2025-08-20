package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap;

import androidx.compose.runtime.external.kotlinx.collections.immutable.ImmutableCollection;
import androidx.compose.runtime.external.kotlinx.collections.immutable.ImmutableSet;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode;
import java.util.Set;
import kotlin.collections.AbstractMap;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: PersistentHashMap.kt */
/* loaded from: classes.dex */
public class PersistentHashMap extends AbstractMap implements PersistentMap {
    public static final Companion Companion = new Companion(null);
    private static final PersistentHashMap EMPTY = new PersistentHashMap(TrieNode.Companion.getEMPTY$runtime_release(), 0);
    private final TrieNode node;
    private final int size;

    public final TrieNode getNode$runtime_release() {
        return this.node;
    }

    @Override // kotlin.collections.AbstractMap
    public int getSize() {
        return this.size;
    }

    public PersistentHashMap(TrieNode node, int i) {
        Intrinsics.checkNotNullParameter(node, "node");
        this.node = node;
        this.size = i;
    }

    @Override // kotlin.collections.AbstractMap
    public ImmutableSet getKeys() {
        return new PersistentHashMapKeys(this);
    }

    @Override // kotlin.collections.AbstractMap
    public ImmutableCollection getValues() {
        return new PersistentHashMapValues(this);
    }

    private final ImmutableSet createEntries() {
        return new PersistentHashMapEntries(this);
    }

    @Override // kotlin.collections.AbstractMap
    public final Set getEntries() {
        return createEntries();
    }

    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        return this.node.containsKey(obj != null ? obj.hashCode() : 0, obj, 0);
    }

    @Override // java.util.Map
    public Object get(Object obj) {
        return this.node.get(obj != null ? obj.hashCode() : 0, obj, 0);
    }

    @Override // kotlin.collections.AbstractMap, java.util.Map
    public PersistentHashMap put(Object obj, Object obj2) {
        TrieNode.ModificationResult put = this.node.put(obj != null ? obj.hashCode() : 0, obj, obj2, 0);
        return put == null ? this : new PersistentHashMap(put.getNode(), size() + put.getSizeDelta());
    }

    @Override // kotlin.collections.AbstractMap, java.util.Map
    public PersistentHashMap remove(Object obj) {
        TrieNode remove = this.node.remove(obj != null ? obj.hashCode() : 0, obj, 0);
        if (this.node == remove) {
            return this;
        }
        if (remove == null) {
            return Companion.emptyOf$runtime_release();
        }
        return new PersistentHashMap(remove, size() - 1);
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap
    public PersistentHashMapBuilder builder() {
        return new PersistentHashMapBuilder(this);
    }

    /* compiled from: PersistentHashMap.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final PersistentHashMap emptyOf$runtime_release() {
            PersistentHashMap persistentHashMap = PersistentHashMap.EMPTY;
            Intrinsics.checkNotNull(persistentHashMap, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMap<K of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMap.Companion.emptyOf, V of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMap.Companion.emptyOf>");
            return persistentHashMap;
        }
    }
}
