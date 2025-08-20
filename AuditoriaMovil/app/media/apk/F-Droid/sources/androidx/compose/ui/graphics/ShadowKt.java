package androidx.compose.ui.graphics;

import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.util.MathHelpersKt;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: Shadow.kt */
/* loaded from: classes.dex */
public abstract class ShadowKt {
    public static final Shadow lerp(Shadow start, Shadow stop, float f) {
        Intrinsics.checkNotNullParameter(start, "start");
        Intrinsics.checkNotNullParameter(stop, "stop");
        return new Shadow(ColorKt.m869lerpjxsXWHM(start.m952getColor0d7_KjU(), stop.m952getColor0d7_KjU(), f), OffsetKt.m724lerpWko1d7g(start.m953getOffsetF1C5BW0(), stop.m953getOffsetF1C5BW0(), f), MathHelpersKt.lerp(start.getBlurRadius(), stop.getBlurRadius(), f), null);
    }
}
