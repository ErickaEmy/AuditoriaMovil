package io.ktor.util.collections;

import java.util.Map;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: CopyOnWriteHashMap.kt */
/* loaded from: classes.dex */
public final class CopyOnWriteHashMap {
    private static final /* synthetic */ AtomicReferenceFieldUpdater current$FU = AtomicReferenceFieldUpdater.newUpdater(CopyOnWriteHashMap.class, Object.class, "current");
    private volatile /* synthetic */ Object current;

    public CopyOnWriteHashMap() {
        Map emptyMap;
        emptyMap = MapsKt__MapsKt.emptyMap();
        this.current = emptyMap;
    }

    public final Object get(Object key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return ((Map) this.current).get(key);
    }
}
