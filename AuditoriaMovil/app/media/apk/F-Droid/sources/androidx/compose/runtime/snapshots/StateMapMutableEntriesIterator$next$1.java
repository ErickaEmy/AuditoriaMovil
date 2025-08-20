package androidx.compose.runtime.snapshots;

import java.util.ConcurrentModificationException;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableMap;
/* compiled from: SnapshotStateMap.kt */
/* loaded from: classes.dex */
public final class StateMapMutableEntriesIterator$next$1 implements Map.Entry, KMutableMap.Entry {
    private final Object key;
    final /* synthetic */ StateMapMutableEntriesIterator this$0;
    private Object value;

    @Override // java.util.Map.Entry
    public Object getKey() {
        return this.key;
    }

    @Override // java.util.Map.Entry
    public Object getValue() {
        return this.value;
    }

    @Override // java.util.Map.Entry
    public void setValue(Object obj) {
        this.value = obj;
    }

    @Override // java.util.Map.Entry
    public Object setValue(Object obj) {
        StateMapMutableEntriesIterator stateMapMutableEntriesIterator = this.this$0;
        if (stateMapMutableEntriesIterator.getMap().getModification$runtime_release() != ((StateMapMutableIterator) stateMapMutableEntriesIterator).modification) {
            throw new ConcurrentModificationException();
        }
        Object value = getValue();
        stateMapMutableEntriesIterator.getMap().put(getKey(), obj);
        setValue(obj);
        return value;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public StateMapMutableEntriesIterator$next$1(StateMapMutableEntriesIterator stateMapMutableEntriesIterator) {
        this.this$0 = stateMapMutableEntriesIterator;
        Map.Entry current = stateMapMutableEntriesIterator.getCurrent();
        Intrinsics.checkNotNull(current);
        this.key = current.getKey();
        Map.Entry current2 = stateMapMutableEntriesIterator.getCurrent();
        Intrinsics.checkNotNull(current2);
        this.value = current2.getValue();
    }
}
