package androidx.work.impl.constraints.trackers;

import androidx.work.Logger;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: StorageNotLowTracker.kt */
/* loaded from: classes.dex */
public abstract class StorageNotLowTrackerKt {
    private static final String TAG;

    static {
        String tagWithPrefix = Logger.tagWithPrefix("StorageNotLowTracker");
        Intrinsics.checkNotNullExpressionValue(tagWithPrefix, "tagWithPrefix(\"StorageNotLowTracker\")");
        TAG = tagWithPrefix;
    }
}
