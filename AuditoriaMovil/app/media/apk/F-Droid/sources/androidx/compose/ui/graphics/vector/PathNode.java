package androidx.compose.ui.graphics.vector;

import ch.qos.logback.core.CoreConstants;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: PathNode.kt */
/* loaded from: classes.dex */
public abstract class PathNode {
    private final boolean isCurve;
    private final boolean isQuad;

    public /* synthetic */ PathNode(boolean z, boolean z2, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, z2);
    }

    public final boolean isCurve() {
        return this.isCurve;
    }

    private PathNode(boolean z, boolean z2) {
        this.isCurve = z;
        this.isQuad = z2;
    }

    public /* synthetic */ PathNode(boolean z, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? false : z2, null);
    }

    /* compiled from: PathNode.kt */
    /* loaded from: classes.dex */
    public static final class Close extends PathNode {
        public static final Close INSTANCE = new Close();

        private Close() {
            super(false, false, 3, null);
        }
    }

    /* compiled from: PathNode.kt */
    /* loaded from: classes.dex */
    public static final class MoveTo extends PathNode {
        private final float x;
        private final float y;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof MoveTo) {
                MoveTo moveTo = (MoveTo) obj;
                return Float.compare(this.x, moveTo.x) == 0 && Float.compare(this.y, moveTo.y) == 0;
            }
            return false;
        }

        public final float getX() {
            return this.x;
        }

        public final float getY() {
            return this.y;
        }

        public int hashCode() {
            return (Float.floatToIntBits(this.x) * 31) + Float.floatToIntBits(this.y);
        }

        public String toString() {
            return "MoveTo(x=" + this.x + ", y=" + this.y + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        public MoveTo(float f, float f2) {
            super(false, false, 3, null);
            this.x = f;
            this.y = f2;
        }
    }

    /* compiled from: PathNode.kt */
    /* loaded from: classes.dex */
    public static final class RelativeLineTo extends PathNode {
        private final float dx;
        private final float dy;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof RelativeLineTo) {
                RelativeLineTo relativeLineTo = (RelativeLineTo) obj;
                return Float.compare(this.dx, relativeLineTo.dx) == 0 && Float.compare(this.dy, relativeLineTo.dy) == 0;
            }
            return false;
        }

        public final float getDx() {
            return this.dx;
        }

        public final float getDy() {
            return this.dy;
        }

        public int hashCode() {
            return (Float.floatToIntBits(this.dx) * 31) + Float.floatToIntBits(this.dy);
        }

        public String toString() {
            return "RelativeLineTo(dx=" + this.dx + ", dy=" + this.dy + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        public RelativeLineTo(float f, float f2) {
            super(false, false, 3, null);
            this.dx = f;
            this.dy = f2;
        }
    }

    /* compiled from: PathNode.kt */
    /* loaded from: classes.dex */
    public static final class LineTo extends PathNode {
        private final float x;
        private final float y;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof LineTo) {
                LineTo lineTo = (LineTo) obj;
                return Float.compare(this.x, lineTo.x) == 0 && Float.compare(this.y, lineTo.y) == 0;
            }
            return false;
        }

        public final float getX() {
            return this.x;
        }

        public final float getY() {
            return this.y;
        }

        public int hashCode() {
            return (Float.floatToIntBits(this.x) * 31) + Float.floatToIntBits(this.y);
        }

        public String toString() {
            return "LineTo(x=" + this.x + ", y=" + this.y + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        public LineTo(float f, float f2) {
            super(false, false, 3, null);
            this.x = f;
            this.y = f2;
        }
    }

    /* compiled from: PathNode.kt */
    /* loaded from: classes.dex */
    public static final class RelativeHorizontalTo extends PathNode {
        private final float dx;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof RelativeHorizontalTo) && Float.compare(this.dx, ((RelativeHorizontalTo) obj).dx) == 0;
        }

        public final float getDx() {
            return this.dx;
        }

        public int hashCode() {
            return Float.floatToIntBits(this.dx);
        }

        public String toString() {
            return "RelativeHorizontalTo(dx=" + this.dx + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        public RelativeHorizontalTo(float f) {
            super(false, false, 3, null);
            this.dx = f;
        }
    }

    /* compiled from: PathNode.kt */
    /* loaded from: classes.dex */
    public static final class HorizontalTo extends PathNode {
        private final float x;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof HorizontalTo) && Float.compare(this.x, ((HorizontalTo) obj).x) == 0;
        }

        public final float getX() {
            return this.x;
        }

        public int hashCode() {
            return Float.floatToIntBits(this.x);
        }

        public String toString() {
            return "HorizontalTo(x=" + this.x + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        public HorizontalTo(float f) {
            super(false, false, 3, null);
            this.x = f;
        }
    }

    /* compiled from: PathNode.kt */
    /* loaded from: classes.dex */
    public static final class RelativeVerticalTo extends PathNode {
        private final float dy;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof RelativeVerticalTo) && Float.compare(this.dy, ((RelativeVerticalTo) obj).dy) == 0;
        }

        public final float getDy() {
            return this.dy;
        }

        public int hashCode() {
            return Float.floatToIntBits(this.dy);
        }

        public String toString() {
            return "RelativeVerticalTo(dy=" + this.dy + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        public RelativeVerticalTo(float f) {
            super(false, false, 3, null);
            this.dy = f;
        }
    }

    /* compiled from: PathNode.kt */
    /* loaded from: classes.dex */
    public static final class VerticalTo extends PathNode {
        private final float y;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof VerticalTo) && Float.compare(this.y, ((VerticalTo) obj).y) == 0;
        }

        public final float getY() {
            return this.y;
        }

        public int hashCode() {
            return Float.floatToIntBits(this.y);
        }

        public String toString() {
            return "VerticalTo(y=" + this.y + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        public VerticalTo(float f) {
            super(false, false, 3, null);
            this.y = f;
        }
    }

    /* compiled from: PathNode.kt */
    /* loaded from: classes.dex */
    public static final class RelativeCurveTo extends PathNode {
        private final float dx1;
        private final float dx2;
        private final float dx3;
        private final float dy1;
        private final float dy2;
        private final float dy3;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof RelativeCurveTo) {
                RelativeCurveTo relativeCurveTo = (RelativeCurveTo) obj;
                return Float.compare(this.dx1, relativeCurveTo.dx1) == 0 && Float.compare(this.dy1, relativeCurveTo.dy1) == 0 && Float.compare(this.dx2, relativeCurveTo.dx2) == 0 && Float.compare(this.dy2, relativeCurveTo.dy2) == 0 && Float.compare(this.dx3, relativeCurveTo.dx3) == 0 && Float.compare(this.dy3, relativeCurveTo.dy3) == 0;
            }
            return false;
        }

        public final float getDx1() {
            return this.dx1;
        }

        public final float getDx2() {
            return this.dx2;
        }

        public final float getDx3() {
            return this.dx3;
        }

        public final float getDy1() {
            return this.dy1;
        }

        public final float getDy2() {
            return this.dy2;
        }

        public final float getDy3() {
            return this.dy3;
        }

        public int hashCode() {
            return (((((((((Float.floatToIntBits(this.dx1) * 31) + Float.floatToIntBits(this.dy1)) * 31) + Float.floatToIntBits(this.dx2)) * 31) + Float.floatToIntBits(this.dy2)) * 31) + Float.floatToIntBits(this.dx3)) * 31) + Float.floatToIntBits(this.dy3);
        }

        public String toString() {
            return "RelativeCurveTo(dx1=" + this.dx1 + ", dy1=" + this.dy1 + ", dx2=" + this.dx2 + ", dy2=" + this.dy2 + ", dx3=" + this.dx3 + ", dy3=" + this.dy3 + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        public RelativeCurveTo(float f, float f2, float f3, float f4, float f5, float f6) {
            super(true, false, 2, null);
            this.dx1 = f;
            this.dy1 = f2;
            this.dx2 = f3;
            this.dy2 = f4;
            this.dx3 = f5;
            this.dy3 = f6;
        }
    }

    /* compiled from: PathNode.kt */
    /* loaded from: classes.dex */
    public static final class CurveTo extends PathNode {
        private final float x1;
        private final float x2;
        private final float x3;
        private final float y1;
        private final float y2;
        private final float y3;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof CurveTo) {
                CurveTo curveTo = (CurveTo) obj;
                return Float.compare(this.x1, curveTo.x1) == 0 && Float.compare(this.y1, curveTo.y1) == 0 && Float.compare(this.x2, curveTo.x2) == 0 && Float.compare(this.y2, curveTo.y2) == 0 && Float.compare(this.x3, curveTo.x3) == 0 && Float.compare(this.y3, curveTo.y3) == 0;
            }
            return false;
        }

        public final float getX1() {
            return this.x1;
        }

        public final float getX2() {
            return this.x2;
        }

        public final float getX3() {
            return this.x3;
        }

        public final float getY1() {
            return this.y1;
        }

        public final float getY2() {
            return this.y2;
        }

        public final float getY3() {
            return this.y3;
        }

        public int hashCode() {
            return (((((((((Float.floatToIntBits(this.x1) * 31) + Float.floatToIntBits(this.y1)) * 31) + Float.floatToIntBits(this.x2)) * 31) + Float.floatToIntBits(this.y2)) * 31) + Float.floatToIntBits(this.x3)) * 31) + Float.floatToIntBits(this.y3);
        }

        public String toString() {
            return "CurveTo(x1=" + this.x1 + ", y1=" + this.y1 + ", x2=" + this.x2 + ", y2=" + this.y2 + ", x3=" + this.x3 + ", y3=" + this.y3 + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        public CurveTo(float f, float f2, float f3, float f4, float f5, float f6) {
            super(true, false, 2, null);
            this.x1 = f;
            this.y1 = f2;
            this.x2 = f3;
            this.y2 = f4;
            this.x3 = f5;
            this.y3 = f6;
        }
    }

    /* compiled from: PathNode.kt */
    /* loaded from: classes.dex */
    public static final class RelativeReflectiveCurveTo extends PathNode {
        private final float dx1;
        private final float dx2;
        private final float dy1;
        private final float dy2;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof RelativeReflectiveCurveTo) {
                RelativeReflectiveCurveTo relativeReflectiveCurveTo = (RelativeReflectiveCurveTo) obj;
                return Float.compare(this.dx1, relativeReflectiveCurveTo.dx1) == 0 && Float.compare(this.dy1, relativeReflectiveCurveTo.dy1) == 0 && Float.compare(this.dx2, relativeReflectiveCurveTo.dx2) == 0 && Float.compare(this.dy2, relativeReflectiveCurveTo.dy2) == 0;
            }
            return false;
        }

        public final float getDx1() {
            return this.dx1;
        }

        public final float getDx2() {
            return this.dx2;
        }

        public final float getDy1() {
            return this.dy1;
        }

        public final float getDy2() {
            return this.dy2;
        }

        public int hashCode() {
            return (((((Float.floatToIntBits(this.dx1) * 31) + Float.floatToIntBits(this.dy1)) * 31) + Float.floatToIntBits(this.dx2)) * 31) + Float.floatToIntBits(this.dy2);
        }

        public String toString() {
            return "RelativeReflectiveCurveTo(dx1=" + this.dx1 + ", dy1=" + this.dy1 + ", dx2=" + this.dx2 + ", dy2=" + this.dy2 + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        public RelativeReflectiveCurveTo(float f, float f2, float f3, float f4) {
            super(true, false, 2, null);
            this.dx1 = f;
            this.dy1 = f2;
            this.dx2 = f3;
            this.dy2 = f4;
        }
    }

    /* compiled from: PathNode.kt */
    /* loaded from: classes.dex */
    public static final class ReflectiveCurveTo extends PathNode {
        private final float x1;
        private final float x2;
        private final float y1;
        private final float y2;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ReflectiveCurveTo) {
                ReflectiveCurveTo reflectiveCurveTo = (ReflectiveCurveTo) obj;
                return Float.compare(this.x1, reflectiveCurveTo.x1) == 0 && Float.compare(this.y1, reflectiveCurveTo.y1) == 0 && Float.compare(this.x2, reflectiveCurveTo.x2) == 0 && Float.compare(this.y2, reflectiveCurveTo.y2) == 0;
            }
            return false;
        }

        public final float getX1() {
            return this.x1;
        }

        public final float getX2() {
            return this.x2;
        }

        public final float getY1() {
            return this.y1;
        }

        public final float getY2() {
            return this.y2;
        }

        public int hashCode() {
            return (((((Float.floatToIntBits(this.x1) * 31) + Float.floatToIntBits(this.y1)) * 31) + Float.floatToIntBits(this.x2)) * 31) + Float.floatToIntBits(this.y2);
        }

        public String toString() {
            return "ReflectiveCurveTo(x1=" + this.x1 + ", y1=" + this.y1 + ", x2=" + this.x2 + ", y2=" + this.y2 + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        public ReflectiveCurveTo(float f, float f2, float f3, float f4) {
            super(true, false, 2, null);
            this.x1 = f;
            this.y1 = f2;
            this.x2 = f3;
            this.y2 = f4;
        }
    }
}
