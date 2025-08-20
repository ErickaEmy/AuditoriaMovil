package androidx.work.impl.constraints.trackers;

import androidx.work.Logger;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ConstraintTracker.kt */
/* loaded from: classes.dex */
public abstract class ConstraintTrackerKt {
    private static final String TAG;

    static {
        String tagWithPrefix = Logger.tagWithPrefix("ConstraintTracker");
        Intrinsics.checkNotNullExpressionValue(tagWithPrefix, "tagWithPrefix(\"ConstraintTracker\")");
        TAG = tagWithPrefix;
    }
}
