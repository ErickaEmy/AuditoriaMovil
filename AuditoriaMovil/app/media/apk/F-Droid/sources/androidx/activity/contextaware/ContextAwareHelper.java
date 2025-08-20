package androidx.activity.contextaware;

import android.content.Context;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ContextAwareHelper.kt */
/* loaded from: classes.dex */
public final class ContextAwareHelper {
    private volatile Context context;
    private final Set listeners = new CopyOnWriteArraySet();

    public final void clearAvailableContext() {
        this.context = null;
    }

    public final Context peekAvailableContext() {
        return this.context;
    }

    public final void addOnContextAvailableListener(OnContextAvailableListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        Context context = this.context;
        if (context != null) {
            listener.onContextAvailable(context);
        }
        this.listeners.add(listener);
    }

    public final void removeOnContextAvailableListener(OnContextAvailableListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listeners.remove(listener);
    }

    public final void dispatchOnContextAvailable(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        for (OnContextAvailableListener onContextAvailableListener : this.listeners) {
            onContextAvailableListener.onContextAvailable(context);
        }
    }
}
