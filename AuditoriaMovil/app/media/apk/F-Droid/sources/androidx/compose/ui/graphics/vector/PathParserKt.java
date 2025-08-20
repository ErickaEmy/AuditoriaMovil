package androidx.compose.ui.graphics.vector;

import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.vector.PathNode;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: PathParser.kt */
/* loaded from: classes.dex */
public abstract class PathParserKt {
    private static final float[] EmptyArray = new float[0];

    public static final Path toPath(List list, Path target) {
        PathNode pathNode;
        float f;
        float f2;
        float x1;
        float y1;
        float x2;
        float y2;
        float f3;
        float f4;
        float dy2;
        float dy;
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(target, "target");
        int mo789getFillTypeRgk1Os = target.mo789getFillTypeRgk1Os();
        target.rewind();
        target.mo791setFillTypeoQ8Xj4U(mo789getFillTypeRgk1Os);
        PathNode pathNode2 = list.isEmpty() ? PathNode.Close.INSTANCE : (PathNode) list.get(0);
        int size = list.size();
        float f5 = 0.0f;
        int i = 0;
        float f6 = 0.0f;
        float f7 = 0.0f;
        float f8 = 0.0f;
        float f9 = 0.0f;
        float f10 = 0.0f;
        float f11 = 0.0f;
        while (i < size) {
            PathNode pathNode3 = (PathNode) list.get(i);
            if (pathNode3 instanceof PathNode.Close) {
                target.close();
                target.moveTo(f8, f9);
                pathNode = pathNode3;
                f6 = f8;
                f10 = f6;
                f7 = f9;
                f11 = f7;
            } else if (pathNode3 instanceof PathNode.MoveTo) {
                PathNode.MoveTo moveTo = (PathNode.MoveTo) pathNode3;
                f8 = moveTo.getX();
                f9 = moveTo.getY();
                target.moveTo(moveTo.getX(), moveTo.getY());
                pathNode = pathNode3;
                f10 = f8;
                f11 = f9;
            } else {
                if (pathNode3 instanceof PathNode.RelativeLineTo) {
                    PathNode.RelativeLineTo relativeLineTo = (PathNode.RelativeLineTo) pathNode3;
                    target.relativeLineTo(relativeLineTo.getDx(), relativeLineTo.getDy());
                    f10 += relativeLineTo.getDx();
                    dy = relativeLineTo.getDy();
                } else {
                    if (pathNode3 instanceof PathNode.LineTo) {
                        PathNode.LineTo lineTo = (PathNode.LineTo) pathNode3;
                        target.lineTo(lineTo.getX(), lineTo.getY());
                        float x = lineTo.getX();
                        f11 = lineTo.getY();
                        f10 = x;
                    } else if (pathNode3 instanceof PathNode.RelativeHorizontalTo) {
                        PathNode.RelativeHorizontalTo relativeHorizontalTo = (PathNode.RelativeHorizontalTo) pathNode3;
                        target.relativeLineTo(relativeHorizontalTo.getDx(), f5);
                        f10 += relativeHorizontalTo.getDx();
                    } else if (pathNode3 instanceof PathNode.HorizontalTo) {
                        PathNode.HorizontalTo horizontalTo = (PathNode.HorizontalTo) pathNode3;
                        target.lineTo(horizontalTo.getX(), f11);
                        f10 = horizontalTo.getX();
                    } else if (pathNode3 instanceof PathNode.RelativeVerticalTo) {
                        PathNode.RelativeVerticalTo relativeVerticalTo = (PathNode.RelativeVerticalTo) pathNode3;
                        target.relativeLineTo(f5, relativeVerticalTo.getDy());
                        dy = relativeVerticalTo.getDy();
                    } else if (pathNode3 instanceof PathNode.VerticalTo) {
                        PathNode.VerticalTo verticalTo = (PathNode.VerticalTo) pathNode3;
                        target.lineTo(f10, verticalTo.getY());
                        f11 = verticalTo.getY();
                    } else {
                        if (pathNode3 instanceof PathNode.RelativeCurveTo) {
                            PathNode.RelativeCurveTo relativeCurveTo = (PathNode.RelativeCurveTo) pathNode3;
                            pathNode = pathNode3;
                            target.relativeCubicTo(relativeCurveTo.getDx1(), relativeCurveTo.getDy1(), relativeCurveTo.getDx2(), relativeCurveTo.getDy2(), relativeCurveTo.getDx3(), relativeCurveTo.getDy3());
                            x1 = relativeCurveTo.getDx2() + f10;
                            y1 = relativeCurveTo.getDy2() + f11;
                            f10 += relativeCurveTo.getDx3();
                            dy2 = relativeCurveTo.getDy3();
                        } else {
                            pathNode = pathNode3;
                            if (pathNode instanceof PathNode.CurveTo) {
                                PathNode.CurveTo curveTo = (PathNode.CurveTo) pathNode;
                                target.cubicTo(curveTo.getX1(), curveTo.getY1(), curveTo.getX2(), curveTo.getY2(), curveTo.getX3(), curveTo.getY3());
                                x1 = curveTo.getX2();
                                y1 = curveTo.getY2();
                                x2 = curveTo.getX3();
                                y2 = curveTo.getY3();
                            } else if (pathNode instanceof PathNode.RelativeReflectiveCurveTo) {
                                if (pathNode2.isCurve()) {
                                    f4 = f11 - f7;
                                    f3 = f10 - f6;
                                } else {
                                    f3 = 0.0f;
                                    f4 = 0.0f;
                                }
                                PathNode.RelativeReflectiveCurveTo relativeReflectiveCurveTo = (PathNode.RelativeReflectiveCurveTo) pathNode;
                                target.relativeCubicTo(f3, f4, relativeReflectiveCurveTo.getDx1(), relativeReflectiveCurveTo.getDy1(), relativeReflectiveCurveTo.getDx2(), relativeReflectiveCurveTo.getDy2());
                                x1 = relativeReflectiveCurveTo.getDx1() + f10;
                                y1 = relativeReflectiveCurveTo.getDy1() + f11;
                                f10 += relativeReflectiveCurveTo.getDx2();
                                dy2 = relativeReflectiveCurveTo.getDy2();
                            } else if (pathNode instanceof PathNode.ReflectiveCurveTo) {
                                if (pathNode2.isCurve()) {
                                    float f12 = 2;
                                    f2 = (f12 * f11) - f7;
                                    f = (f10 * f12) - f6;
                                } else {
                                    f = f10;
                                    f2 = f11;
                                }
                                PathNode.ReflectiveCurveTo reflectiveCurveTo = (PathNode.ReflectiveCurveTo) pathNode;
                                target.cubicTo(f, f2, reflectiveCurveTo.getX1(), reflectiveCurveTo.getY1(), reflectiveCurveTo.getX2(), reflectiveCurveTo.getY2());
                                x1 = reflectiveCurveTo.getX1();
                                y1 = reflectiveCurveTo.getY1();
                                x2 = reflectiveCurveTo.getX2();
                                y2 = reflectiveCurveTo.getY2();
                            }
                            f10 = x2;
                            f11 = y2;
                            f7 = y1;
                            f6 = x1;
                        }
                        f11 += dy2;
                        f7 = y1;
                        f6 = x1;
                    }
                    pathNode = pathNode3;
                }
                f11 += dy;
                pathNode = pathNode3;
            }
            i++;
            pathNode2 = pathNode;
            f5 = 0.0f;
        }
        return target;
    }
}
