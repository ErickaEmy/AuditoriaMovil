package androidx.compose.material;

import androidx.compose.animation.core.SpringSpec;
/* compiled from: AnchoredDraggable.kt */
/* loaded from: classes.dex */
public final class AnchoredDraggableDefaults {
    public static final AnchoredDraggableDefaults INSTANCE = new AnchoredDraggableDefaults();
    private static final SpringSpec AnimationSpec = new SpringSpec(0.0f, 0.0f, null, 7, null);

    private AnchoredDraggableDefaults() {
    }

    public final SpringSpec getAnimationSpec() {
        return AnimationSpec;
    }
}
