package kotlin.collections;

import java.util.AbstractSet;
import java.util.Set;
import kotlin.jvm.internal.markers.KMutableCollection;
/* loaded from: classes.dex */
public abstract class AbstractMutableSet<E> extends AbstractSet<E> implements Set<E>, KMutableCollection {
    public abstract int getSize();

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final /* bridge */ int size() {
        return getSize();
    }
}
