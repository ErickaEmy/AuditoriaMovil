package androidx.compose.runtime.external.kotlinx.collections.immutable;

import java.util.Collection;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.markers.KMutableCollection;
import kotlin.jvm.internal.markers.KMutableList;
/* compiled from: ImmutableList.kt */
/* loaded from: classes.dex */
public interface PersistentList extends ImmutableList, ImmutableCollection {

    /* compiled from: ImmutableList.kt */
    /* loaded from: classes.dex */
    public interface Builder extends List, Collection, KMutableCollection, KMutableList {
        PersistentList build();
    }

    @Override // java.util.List
    PersistentList add(int i, Object obj);

    @Override // java.util.List, java.util.Collection
    PersistentList add(Object obj);

    @Override // java.util.List, java.util.Collection
    PersistentList addAll(Collection collection);

    Builder builder();

    @Override // java.util.List, java.util.Collection
    PersistentList remove(Object obj);

    @Override // java.util.List, java.util.Collection
    PersistentList removeAll(Collection collection);

    PersistentList removeAll(Function1 function1);

    PersistentList removeAt(int i);

    @Override // java.util.List
    PersistentList set(int i, Object obj);
}
