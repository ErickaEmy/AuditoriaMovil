package kotlin.collections;

import java.util.Collection;
import kotlin.jvm.internal.markers.KMutableCollection;
/* loaded from: classes.dex */
public abstract class AbstractMutableCollection<E> extends java.util.AbstractCollection<E> implements Collection<E>, KMutableCollection {
    public abstract int getSize();

    @Override // java.util.AbstractCollection, java.util.Collection
    public final /* bridge */ int size() {
        return getSize();
    }
}
