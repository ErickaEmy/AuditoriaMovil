package androidx.compose.ui.text.font;

import androidx.compose.ui.util.MathHelpersKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
/* compiled from: FontWeight.kt */
/* loaded from: classes.dex */
public abstract class FontWeightKt {
    public static final FontWeight lerp(FontWeight start, FontWeight stop, float f) {
        int coerceIn;
        Intrinsics.checkNotNullParameter(start, "start");
        Intrinsics.checkNotNullParameter(stop, "stop");
        coerceIn = RangesKt___RangesKt.coerceIn(MathHelpersKt.lerp(start.getWeight(), stop.getWeight(), f), 1, 1000);
        return new FontWeight(coerceIn);
    }
}
