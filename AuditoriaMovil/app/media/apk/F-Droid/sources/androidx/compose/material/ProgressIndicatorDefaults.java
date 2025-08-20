package androidx.compose.material;

import androidx.compose.animation.core.SpringSpec;
import androidx.compose.ui.unit.Dp;
/* compiled from: ProgressIndicator.kt */
/* loaded from: classes.dex */
public final class ProgressIndicatorDefaults {
    public static final ProgressIndicatorDefaults INSTANCE = new ProgressIndicatorDefaults();
    private static final float StrokeWidth = Dp.m1897constructorimpl(4);
    private static final SpringSpec ProgressAnimationSpec = new SpringSpec(1.0f, 50.0f, Float.valueOf(0.001f));

    private ProgressIndicatorDefaults() {
    }

    /* renamed from: getStrokeWidth-D9Ej5fM  reason: not valid java name */
    public final float m515getStrokeWidthD9Ej5fM() {
        return StrokeWidth;
    }
}
