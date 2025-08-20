package androidx.compose.ui.graphics.vector;

import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: VectorPainter.kt */
/* loaded from: classes.dex */
public abstract class VectorProperty {
    private VectorProperty() {
    }

    public /* synthetic */ VectorProperty(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* compiled from: VectorPainter.kt */
    /* loaded from: classes.dex */
    public static final class Rotation extends VectorProperty {
        public static final Rotation INSTANCE = new Rotation();

        private Rotation() {
            super(null);
        }
    }

    /* compiled from: VectorPainter.kt */
    /* loaded from: classes.dex */
    public static final class PivotX extends VectorProperty {
        public static final PivotX INSTANCE = new PivotX();

        private PivotX() {
            super(null);
        }
    }

    /* compiled from: VectorPainter.kt */
    /* loaded from: classes.dex */
    public static final class PivotY extends VectorProperty {
        public static final PivotY INSTANCE = new PivotY();

        private PivotY() {
            super(null);
        }
    }

    /* compiled from: VectorPainter.kt */
    /* loaded from: classes.dex */
    public static final class ScaleX extends VectorProperty {
        public static final ScaleX INSTANCE = new ScaleX();

        private ScaleX() {
            super(null);
        }
    }

    /* compiled from: VectorPainter.kt */
    /* loaded from: classes.dex */
    public static final class ScaleY extends VectorProperty {
        public static final ScaleY INSTANCE = new ScaleY();

        private ScaleY() {
            super(null);
        }
    }

    /* compiled from: VectorPainter.kt */
    /* loaded from: classes.dex */
    public static final class TranslateX extends VectorProperty {
        public static final TranslateX INSTANCE = new TranslateX();

        private TranslateX() {
            super(null);
        }
    }

    /* compiled from: VectorPainter.kt */
    /* loaded from: classes.dex */
    public static final class TranslateY extends VectorProperty {
        public static final TranslateY INSTANCE = new TranslateY();

        private TranslateY() {
            super(null);
        }
    }

    /* compiled from: VectorPainter.kt */
    /* loaded from: classes.dex */
    public static final class PathData extends VectorProperty {
        public static final PathData INSTANCE = new PathData();

        private PathData() {
            super(null);
        }
    }

    /* compiled from: VectorPainter.kt */
    /* loaded from: classes.dex */
    public static final class Fill extends VectorProperty {
        public static final Fill INSTANCE = new Fill();

        private Fill() {
            super(null);
        }
    }

    /* compiled from: VectorPainter.kt */
    /* loaded from: classes.dex */
    public static final class FillAlpha extends VectorProperty {
        public static final FillAlpha INSTANCE = new FillAlpha();

        private FillAlpha() {
            super(null);
        }
    }

    /* compiled from: VectorPainter.kt */
    /* loaded from: classes.dex */
    public static final class Stroke extends VectorProperty {
        public static final Stroke INSTANCE = new Stroke();

        private Stroke() {
            super(null);
        }
    }

    /* compiled from: VectorPainter.kt */
    /* loaded from: classes.dex */
    public static final class StrokeLineWidth extends VectorProperty {
        public static final StrokeLineWidth INSTANCE = new StrokeLineWidth();

        private StrokeLineWidth() {
            super(null);
        }
    }

    /* compiled from: VectorPainter.kt */
    /* loaded from: classes.dex */
    public static final class StrokeAlpha extends VectorProperty {
        public static final StrokeAlpha INSTANCE = new StrokeAlpha();

        private StrokeAlpha() {
            super(null);
        }
    }

    /* compiled from: VectorPainter.kt */
    /* loaded from: classes.dex */
    public static final class TrimPathStart extends VectorProperty {
        public static final TrimPathStart INSTANCE = new TrimPathStart();

        private TrimPathStart() {
            super(null);
        }
    }

    /* compiled from: VectorPainter.kt */
    /* loaded from: classes.dex */
    public static final class TrimPathEnd extends VectorProperty {
        public static final TrimPathEnd INSTANCE = new TrimPathEnd();

        private TrimPathEnd() {
            super(null);
        }
    }

    /* compiled from: VectorPainter.kt */
    /* loaded from: classes.dex */
    public static final class TrimPathOffset extends VectorProperty {
        public static final TrimPathOffset INSTANCE = new TrimPathOffset();

        private TrimPathOffset() {
            super(null);
        }
    }
}
