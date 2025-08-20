package androidx.compose.ui.platform;

import androidx.compose.runtime.collection.MutableVector;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
/* compiled from: WeakCache.kt */
/* loaded from: classes.dex */
public final class WeakCache {
    private final MutableVector values = new MutableVector(new Reference[16], 0);
    private final ReferenceQueue referenceQueue = new ReferenceQueue();

    public final void push(Object obj) {
        clearWeakReferences();
        this.values.add(new WeakReference(obj, this.referenceQueue));
    }

    public final Object pop() {
        clearWeakReferences();
        while (this.values.isNotEmpty()) {
            MutableVector mutableVector = this.values;
            Object obj = ((Reference) mutableVector.removeAt(mutableVector.getSize() - 1)).get();
            if (obj != null) {
                return obj;
            }
        }
        return null;
    }

    private final void clearWeakReferences() {
        Reference poll;
        do {
            poll = this.referenceQueue.poll();
            if (poll != null) {
                this.values.remove(poll);
                continue;
            }
        } while (poll != null);
    }
}
