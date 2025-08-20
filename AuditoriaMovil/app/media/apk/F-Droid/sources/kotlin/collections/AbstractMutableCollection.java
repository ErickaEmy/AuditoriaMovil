package kotlin.collections;

import java.util.Collection;
import kotlin.jvm.internal.markers.KMutableCollection;
/* compiled from: AbstractMutableCollection.kt */
/* loaded from: classes.dex */
public abstract class AbstractMutableCollection extends java.util.AbstractCollection implements Collection, KMutableCollection {
    public abstract int getSize();

    @Override // java.util.AbstractCollection, java.util.Collection
    public final /* bridge */ int size() {
        return getSize();
    }
}
