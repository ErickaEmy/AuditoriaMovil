package androidx.work.impl.constraints.trackers;

import androidx.work.Logger;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: BatteryChargingTracker.kt */
/* loaded from: classes.dex */
public abstract class BatteryChargingTrackerKt {
    private static final String TAG;

    static {
        String tagWithPrefix = Logger.tagWithPrefix("BatteryChrgTracker");
        Intrinsics.checkNotNullExpressionValue(tagWithPrefix, "tagWithPrefix(\"BatteryChrgTracker\")");
        TAG = tagWithPrefix;
    }
}
