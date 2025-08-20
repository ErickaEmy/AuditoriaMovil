package androidx.compose.runtime.collection;

import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
/* compiled from: IdentityArraySet.kt */
/* loaded from: classes.dex */
public final class IdentityArraySet$iterator$1 implements Iterator, KMappedMarker {
    private int index;
    final /* synthetic */ IdentityArraySet this$0;

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public IdentityArraySet$iterator$1(IdentityArraySet identityArraySet) {
        this.this$0 = identityArraySet;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.index < this.this$0.size();
    }

    @Override // java.util.Iterator
    public Object next() {
        Object[] values = this.this$0.getValues();
        int i = this.index;
        this.index = i + 1;
        Object obj = values[i];
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet");
        return obj;
    }
}
