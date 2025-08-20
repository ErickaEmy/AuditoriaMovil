package androidx.customview.poolingcontainer;

import java.util.ArrayList;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PoolingContainer.kt */
/* loaded from: classes.dex */
public final class PoolingContainerListenerHolder {
    private final ArrayList listeners = new ArrayList();

    public final void addListener(PoolingContainerListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listeners.add(listener);
    }

    public final void removeListener(PoolingContainerListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listeners.remove(listener);
    }

    public final void onRelease() {
        int lastIndex;
        for (lastIndex = CollectionsKt__CollectionsKt.getLastIndex(this.listeners); -1 < lastIndex; lastIndex--) {
            ((PoolingContainerListener) this.listeners.get(lastIndex)).onRelease();
        }
    }
}
