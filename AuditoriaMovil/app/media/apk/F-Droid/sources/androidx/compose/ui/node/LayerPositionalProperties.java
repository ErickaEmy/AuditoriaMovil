package androidx.compose.ui.node;

import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.TransformOrigin;
import kotlin.jvm.internal.Intrinsics;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NodeCoordinator.kt */
/* loaded from: classes.dex */
public final class LayerPositionalProperties {
    private float rotationX;
    private float rotationY;
    private float rotationZ;
    private float translationX;
    private float translationY;
    private float scaleX = 1.0f;
    private float scaleY = 1.0f;
    private float cameraDistance = 8.0f;
    private long transformOrigin = TransformOrigin.Companion.m992getCenterSzJe1aQ();

    public final void copyFrom(LayerPositionalProperties other) {
        Intrinsics.checkNotNullParameter(other, "other");
        this.scaleX = other.scaleX;
        this.scaleY = other.scaleY;
        this.translationX = other.translationX;
        this.translationY = other.translationY;
        this.rotationX = other.rotationX;
        this.rotationY = other.rotationY;
        this.rotationZ = other.rotationZ;
        this.cameraDistance = other.cameraDistance;
        this.transformOrigin = other.transformOrigin;
    }

    public final void copyFrom(GraphicsLayerScope scope) {
        Intrinsics.checkNotNullParameter(scope, "scope");
        this.scaleX = scope.getScaleX();
        this.scaleY = scope.getScaleY();
        this.translationX = scope.getTranslationX();
        this.translationY = scope.getTranslationY();
        this.rotationX = scope.getRotationX();
        this.rotationY = scope.getRotationY();
        this.rotationZ = scope.getRotationZ();
        this.cameraDistance = scope.getCameraDistance();
        this.transformOrigin = scope.mo890getTransformOriginSzJe1aQ();
    }

    public final boolean hasSameValuesAs(LayerPositionalProperties other) {
        Intrinsics.checkNotNullParameter(other, "other");
        return this.scaleX == other.scaleX && this.scaleY == other.scaleY && this.translationX == other.translationX && this.translationY == other.translationY && this.rotationX == other.rotationX && this.rotationY == other.rotationY && this.rotationZ == other.rotationZ && this.cameraDistance == other.cameraDistance && TransformOrigin.m986equalsimpl0(this.transformOrigin, other.transformOrigin);
    }
}
