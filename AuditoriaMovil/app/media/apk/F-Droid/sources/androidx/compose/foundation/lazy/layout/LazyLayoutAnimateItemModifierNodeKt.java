package androidx.compose.foundation.lazy.layout;

import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.animation.core.VisibilityThresholdsKt;
import androidx.compose.ui.unit.IntOffset;
/* compiled from: LazyLayoutAnimateItemModifierNode.kt */
/* loaded from: classes.dex */
public abstract class LazyLayoutAnimateItemModifierNodeKt {
    private static final SpringSpec InterruptionSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntOffset.m1929boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntOffset.Companion)), 1, null);
}
