package kotlin.collections;

import java.util.Set;
import kotlin.jvm.internal.markers.KMutableSet;
/* compiled from: AbstractMutableSet.kt */
/* loaded from: classes.dex */
public abstract class AbstractMutableSet extends java.util.AbstractSet implements Set, KMutableSet {
    public abstract int getSize();

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final /* bridge */ int size() {
        return getSize();
    }
}
