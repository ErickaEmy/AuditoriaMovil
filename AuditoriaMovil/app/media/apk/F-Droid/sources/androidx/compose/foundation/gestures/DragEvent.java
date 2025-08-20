package androidx.compose.foundation.gestures;

import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: Draggable.kt */
/* loaded from: classes.dex */
abstract class DragEvent {
    private DragEvent() {
    }

    public /* synthetic */ DragEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* compiled from: Draggable.kt */
    /* loaded from: classes.dex */
    public static final class DragStarted extends DragEvent {
        private final long startPoint;

        public /* synthetic */ DragStarted(long j, DefaultConstructorMarker defaultConstructorMarker) {
            this(j);
        }

        /* renamed from: getStartPoint-F1C5BW0  reason: not valid java name */
        public final long m128getStartPointF1C5BW0() {
            return this.startPoint;
        }

        private DragStarted(long j) {
            super(null);
            this.startPoint = j;
        }
    }

    /* compiled from: Draggable.kt */
    /* loaded from: classes.dex */
    public static final class DragStopped extends DragEvent {
        private final long velocity;

        public /* synthetic */ DragStopped(long j, DefaultConstructorMarker defaultConstructorMarker) {
            this(j);
        }

        /* renamed from: getVelocity-9UxMQ8M  reason: not valid java name */
        public final long m129getVelocity9UxMQ8M() {
            return this.velocity;
        }

        private DragStopped(long j) {
            super(null);
            this.velocity = j;
        }
    }

    /* compiled from: Draggable.kt */
    /* loaded from: classes.dex */
    public static final class DragCancelled extends DragEvent {
        public static final DragCancelled INSTANCE = new DragCancelled();

        private DragCancelled() {
            super(null);
        }
    }

    /* compiled from: Draggable.kt */
    /* loaded from: classes.dex */
    public static final class DragDelta extends DragEvent {
        private final long delta;

        public /* synthetic */ DragDelta(long j, DefaultConstructorMarker defaultConstructorMarker) {
            this(j);
        }

        /* renamed from: getDelta-F1C5BW0  reason: not valid java name */
        public final long m127getDeltaF1C5BW0() {
            return this.delta;
        }

        private DragDelta(long j) {
            super(null);
            this.delta = j;
        }
    }
}
