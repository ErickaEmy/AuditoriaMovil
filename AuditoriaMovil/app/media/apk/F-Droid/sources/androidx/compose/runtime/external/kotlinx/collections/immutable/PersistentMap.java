package androidx.compose.runtime.external.kotlinx.collections.immutable;

import java.util.Map;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.jvm.internal.markers.KMutableMap;
/* compiled from: ImmutableMap.kt */
/* loaded from: classes.dex */
public interface PersistentMap extends Map, KMappedMarker {

    /* compiled from: ImmutableMap.kt */
    /* loaded from: classes.dex */
    public interface Builder extends Map, KMutableMap {
        PersistentMap build();
    }

    Builder builder();
}
