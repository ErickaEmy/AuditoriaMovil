package androidx.compose.ui.graphics.vector;

import androidx.compose.ui.graphics.vector.PathNode;
import java.util.ArrayList;
import java.util.List;
/* compiled from: PathBuilder.kt */
/* loaded from: classes.dex */
public final class PathBuilder {
    private final List nodes = new ArrayList();

    public final List getNodes() {
        return this.nodes;
    }

    public final PathBuilder close() {
        return addNode(PathNode.Close.INSTANCE);
    }

    public final PathBuilder moveTo(float f, float f2) {
        return addNode(new PathNode.MoveTo(f, f2));
    }

    public final PathBuilder lineTo(float f, float f2) {
        return addNode(new PathNode.LineTo(f, f2));
    }

    public final PathBuilder lineToRelative(float f, float f2) {
        return addNode(new PathNode.RelativeLineTo(f, f2));
    }

    public final PathBuilder horizontalLineTo(float f) {
        return addNode(new PathNode.HorizontalTo(f));
    }

    public final PathBuilder horizontalLineToRelative(float f) {
        return addNode(new PathNode.RelativeHorizontalTo(f));
    }

    public final PathBuilder verticalLineTo(float f) {
        return addNode(new PathNode.VerticalTo(f));
    }

    public final PathBuilder verticalLineToRelative(float f) {
        return addNode(new PathNode.RelativeVerticalTo(f));
    }

    public final PathBuilder curveTo(float f, float f2, float f3, float f4, float f5, float f6) {
        return addNode(new PathNode.CurveTo(f, f2, f3, f4, f5, f6));
    }

    public final PathBuilder curveToRelative(float f, float f2, float f3, float f4, float f5, float f6) {
        return addNode(new PathNode.RelativeCurveTo(f, f2, f3, f4, f5, f6));
    }

    public final PathBuilder reflectiveCurveTo(float f, float f2, float f3, float f4) {
        return addNode(new PathNode.ReflectiveCurveTo(f, f2, f3, f4));
    }

    public final PathBuilder reflectiveCurveToRelative(float f, float f2, float f3, float f4) {
        return addNode(new PathNode.RelativeReflectiveCurveTo(f, f2, f3, f4));
    }

    private final PathBuilder addNode(PathNode pathNode) {
        this.nodes.add(pathNode);
        return this;
    }
}
