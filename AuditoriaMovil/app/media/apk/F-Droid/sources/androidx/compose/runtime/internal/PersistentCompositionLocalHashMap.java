package androidx.compose.runtime.internal;

import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.CompositionLocalMapKt;
import androidx.compose.runtime.PersistentCompositionLocalMap;
import androidx.compose.runtime.State;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMap;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode;
import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.MutabilityOwnership;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: PersistentCompositionLocalMap.kt */
/* loaded from: classes.dex */
public final class PersistentCompositionLocalHashMap extends PersistentHashMap implements PersistentCompositionLocalMap {
    public static final Companion Companion = new Companion(null);
    private static final PersistentCompositionLocalHashMap Empty;

    public /* bridge */ boolean containsKey(CompositionLocal compositionLocal) {
        return super.containsKey((Object) compositionLocal);
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMap, java.util.Map
    public final /* bridge */ boolean containsKey(Object obj) {
        if (obj instanceof CompositionLocal) {
            return containsKey((CompositionLocal) obj);
        }
        return false;
    }

    public /* bridge */ boolean containsValue(State state) {
        return super.containsValue((Object) state);
    }

    @Override // kotlin.collections.AbstractMap, java.util.Map
    public final /* bridge */ boolean containsValue(Object obj) {
        if (obj instanceof State) {
            return containsValue((State) obj);
        }
        return false;
    }

    @Override // androidx.compose.runtime.CompositionLocalMap
    public /* bridge */ State get(CompositionLocal compositionLocal) {
        return (State) super.get((Object) compositionLocal);
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMap, java.util.Map
    public final /* bridge */ /* synthetic */ Object get(Object obj) {
        if (obj instanceof CompositionLocal) {
            return get((CompositionLocal) obj);
        }
        return null;
    }

    public /* bridge */ State getOrDefault(CompositionLocal compositionLocal, State state) {
        return (State) super.getOrDefault((Object) compositionLocal, (CompositionLocal) state);
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ Object getOrDefault(Object obj, Object obj2) {
        return !(obj instanceof CompositionLocal) ? obj2 : getOrDefault((CompositionLocal) obj, (State) obj2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PersistentCompositionLocalHashMap(TrieNode node, int i) {
        super(node, i);
        Intrinsics.checkNotNullParameter(node, "node");
    }

    @Override // androidx.compose.runtime.CompositionLocalMap
    public Object get(CompositionLocal key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return CompositionLocalMapKt.read(this, key);
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMap, androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap
    public Builder builder() {
        return new Builder(this);
    }

    /* compiled from: PersistentCompositionLocalMap.kt */
    /* loaded from: classes.dex */
    public static final class Builder extends PersistentHashMapBuilder implements PersistentCompositionLocalMap.Builder {
        private PersistentCompositionLocalHashMap map;

        public /* bridge */ boolean containsKey(CompositionLocal compositionLocal) {
            return super.containsKey((Object) compositionLocal);
        }

        @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder, java.util.AbstractMap, java.util.Map
        public final /* bridge */ boolean containsKey(Object obj) {
            if (obj instanceof CompositionLocal) {
                return containsKey((CompositionLocal) obj);
            }
            return false;
        }

        public /* bridge */ boolean containsValue(State state) {
            return super.containsValue((Object) state);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public final /* bridge */ boolean containsValue(Object obj) {
            if (obj instanceof State) {
                return containsValue((State) obj);
            }
            return false;
        }

        public /* bridge */ State get(CompositionLocal compositionLocal) {
            return (State) super.get((Object) compositionLocal);
        }

        @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder, java.util.AbstractMap, java.util.Map
        public final /* bridge */ /* synthetic */ Object get(Object obj) {
            if (obj instanceof CompositionLocal) {
                return get((CompositionLocal) obj);
            }
            return null;
        }

        public /* bridge */ State getOrDefault(CompositionLocal compositionLocal, State state) {
            return (State) super.getOrDefault((Object) compositionLocal, (CompositionLocal) state);
        }

        @Override // java.util.Map
        public final /* bridge */ /* synthetic */ Object getOrDefault(Object obj, Object obj2) {
            return !(obj instanceof CompositionLocal) ? obj2 : getOrDefault((CompositionLocal) obj, (State) obj2);
        }

        public /* bridge */ State remove(CompositionLocal compositionLocal) {
            return (State) super.remove((Object) compositionLocal);
        }

        @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder, java.util.AbstractMap, java.util.Map
        public final /* bridge */ /* synthetic */ Object remove(Object obj) {
            if (obj instanceof CompositionLocal) {
                return remove((CompositionLocal) obj);
            }
            return null;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Builder(PersistentCompositionLocalHashMap map) {
            super(map);
            Intrinsics.checkNotNullParameter(map, "map");
            this.map = map;
        }

        @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder, androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap.Builder
        public PersistentCompositionLocalHashMap build() {
            PersistentCompositionLocalHashMap persistentCompositionLocalHashMap;
            if (getNode$runtime_release() == this.map.getNode$runtime_release()) {
                persistentCompositionLocalHashMap = this.map;
            } else {
                setOwnership(new MutabilityOwnership());
                persistentCompositionLocalHashMap = new PersistentCompositionLocalHashMap(getNode$runtime_release(), size());
            }
            this.map = persistentCompositionLocalHashMap;
            return persistentCompositionLocalHashMap;
        }
    }

    /* compiled from: PersistentCompositionLocalMap.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final PersistentCompositionLocalHashMap getEmpty() {
            return PersistentCompositionLocalHashMap.Empty;
        }
    }

    static {
        TrieNode eMPTY$runtime_release = TrieNode.Companion.getEMPTY$runtime_release();
        Intrinsics.checkNotNull(eMPTY$runtime_release, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode<androidx.compose.runtime.CompositionLocal<kotlin.Any?>, androidx.compose.runtime.State<kotlin.Any?>>");
        Empty = new PersistentCompositionLocalHashMap(eMPTY$runtime_release, 0);
    }
}
