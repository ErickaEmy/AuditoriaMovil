package androidx.compose.ui.text.style;

import androidx.compose.ui.util.MathHelpersKt;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: TextGeometricTransform.kt */
/* loaded from: classes.dex */
public abstract class TextGeometricTransformKt {
    public static final TextGeometricTransform lerp(TextGeometricTransform start, TextGeometricTransform stop, float f) {
        Intrinsics.checkNotNullParameter(start, "start");
        Intrinsics.checkNotNullParameter(stop, "stop");
        return new TextGeometricTransform(MathHelpersKt.lerp(start.getScaleX(), stop.getScaleX(), f), MathHelpersKt.lerp(start.getSkewX(), stop.getSkewX(), f));
    }
}
