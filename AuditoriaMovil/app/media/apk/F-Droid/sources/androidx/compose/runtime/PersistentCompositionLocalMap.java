package androidx.compose.runtime;

import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap;
/* compiled from: CompositionLocalMap.kt */
/* loaded from: classes.dex */
public interface PersistentCompositionLocalMap extends PersistentMap, CompositionLocalMap {

    /* compiled from: CompositionLocalMap.kt */
    /* loaded from: classes.dex */
    public interface Builder extends PersistentMap.Builder {
        @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap.Builder
        PersistentCompositionLocalMap build();
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap
    Builder builder();
}
