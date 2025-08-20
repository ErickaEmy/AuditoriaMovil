package androidx.compose.ui.res;

import androidx.appcompat.app.ToolbarActionBar$$ExternalSyntheticThrowCCEIfNotNull0;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: VectorResources.android.kt */
/* loaded from: classes.dex */
public final class ImageVectorCache {
    private final HashMap map = new HashMap();

    public final void prune(int i) {
        Iterator it = this.map.entrySet().iterator();
        while (it.hasNext()) {
            Object next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "it.next()");
            ToolbarActionBar$$ExternalSyntheticThrowCCEIfNotNull0.m(((WeakReference) ((Map.Entry) next).getValue()).get());
            it.remove();
        }
    }

    public final void clear() {
        this.map.clear();
    }
}
