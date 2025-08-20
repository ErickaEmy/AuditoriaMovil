package androidx.compose.ui.layout;

import androidx.compose.ui.layout.Measured;
import androidx.compose.ui.node.LayoutNodeLayoutDelegate;
import androidx.compose.ui.node.LookaheadCapablePlaceable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
/* compiled from: Placeable.kt */
/* loaded from: classes.dex */
public abstract class Placeable implements Measured {
    private long apparentToRealOffset;
    private int height;
    private long measuredSize = IntSizeKt.IntSize(0, 0);
    private long measurementConstraints;
    private int width;

    /* renamed from: getApparentToRealOffset-nOcc-ac */
    public final long m1267getApparentToRealOffsetnOccac() {
        return this.apparentToRealOffset;
    }

    public final int getHeight() {
        return this.height;
    }

    /* renamed from: getMeasuredSize-YbymL2g */
    public final long m1268getMeasuredSizeYbymL2g() {
        return this.measuredSize;
    }

    /* renamed from: getMeasurementConstraints-msEJaDk */
    public final long m1269getMeasurementConstraintsmsEJaDk() {
        return this.measurementConstraints;
    }

    public /* synthetic */ Object getParentData() {
        return Measured.CC.$default$getParentData(this);
    }

    public final int getWidth() {
        return this.width;
    }

    /* renamed from: placeAt-f8xVGno */
    public abstract void mo1252placeAtf8xVGno(long j, float f, Function1 function1);

    public Placeable() {
        long j;
        j = PlaceableKt.DefaultConstraints;
        this.measurementConstraints = j;
        this.apparentToRealOffset = IntOffset.Companion.m1942getZeronOccac();
    }

    public int getMeasuredWidth() {
        return IntSize.m1951getWidthimpl(this.measuredSize);
    }

    public int getMeasuredHeight() {
        return IntSize.m1950getHeightimpl(this.measuredSize);
    }

    /* renamed from: setMeasuredSize-ozmzZPI */
    public final void m1270setMeasuredSizeozmzZPI(long j) {
        if (IntSize.m1949equalsimpl0(this.measuredSize, j)) {
            return;
        }
        this.measuredSize = j;
        onMeasuredSizeChanged();
    }

    private final void onMeasuredSizeChanged() {
        int coerceIn;
        int coerceIn2;
        coerceIn = RangesKt___RangesKt.coerceIn(IntSize.m1951getWidthimpl(this.measuredSize), Constraints.m1874getMinWidthimpl(this.measurementConstraints), Constraints.m1872getMaxWidthimpl(this.measurementConstraints));
        this.width = coerceIn;
        coerceIn2 = RangesKt___RangesKt.coerceIn(IntSize.m1950getHeightimpl(this.measuredSize), Constraints.m1873getMinHeightimpl(this.measurementConstraints), Constraints.m1871getMaxHeightimpl(this.measurementConstraints));
        this.height = coerceIn2;
        this.apparentToRealOffset = IntOffsetKt.IntOffset((this.width - IntSize.m1951getWidthimpl(this.measuredSize)) / 2, (this.height - IntSize.m1950getHeightimpl(this.measuredSize)) / 2);
    }

    /* renamed from: setMeasurementConstraints-BRTryo0 */
    public final void m1271setMeasurementConstraintsBRTryo0(long j) {
        if (Constraints.m1865equalsimpl0(this.measurementConstraints, j)) {
            return;
        }
        this.measurementConstraints = j;
        onMeasuredSizeChanged();
    }

    /* compiled from: Placeable.kt */
    /* loaded from: classes.dex */
    public static abstract class PlacementScope {
        private static LayoutCoordinates _coordinates;
        private static LayoutNodeLayoutDelegate layoutDelegate;
        private static int parentWidth;
        public static final Companion Companion = new Companion(null);
        private static LayoutDirection parentLayoutDirection = LayoutDirection.Ltr;

        public static final /* synthetic */ LayoutNodeLayoutDelegate access$getLayoutDelegate$cp() {
            return layoutDelegate;
        }

        public static final /* synthetic */ LayoutCoordinates access$get_coordinates$cp() {
            return _coordinates;
        }

        public static final /* synthetic */ void access$setLayoutDelegate$cp(LayoutNodeLayoutDelegate layoutNodeLayoutDelegate) {
            layoutDelegate = layoutNodeLayoutDelegate;
        }

        public static final /* synthetic */ void access$setParentLayoutDirection$cp(LayoutDirection layoutDirection) {
            parentLayoutDirection = layoutDirection;
        }

        public static final /* synthetic */ void access$setParentWidth$cp(int i) {
            parentWidth = i;
        }

        public static final /* synthetic */ void access$set_coordinates$cp(LayoutCoordinates layoutCoordinates) {
            _coordinates = layoutCoordinates;
        }

        public abstract LayoutDirection getParentLayoutDirection();

        public abstract int getParentWidth();

        /* renamed from: placeRelative-70tqf50$default */
        public static /* synthetic */ void m1273placeRelative70tqf50$default(PlacementScope placementScope, Placeable placeable, long j, float f, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: placeRelative-70tqf50");
            }
            if ((i & 2) != 0) {
                f = 0.0f;
            }
            placementScope.m1277placeRelative70tqf50(placeable, j, f);
        }

        public static /* synthetic */ void placeRelative$default(PlacementScope placementScope, Placeable placeable, int i, int i2, float f, int i3, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: placeRelative");
            }
            if ((i3 & 4) != 0) {
                f = 0.0f;
            }
            placementScope.placeRelative(placeable, i, i2, f);
        }

        public final void placeRelative(Placeable placeable, int i, int i2, float f) {
            Intrinsics.checkNotNullParameter(placeable, "<this>");
            long IntOffset = IntOffsetKt.IntOffset(i, i2);
            if (getParentLayoutDirection() == LayoutDirection.Ltr || getParentWidth() == 0) {
                long j = placeable.apparentToRealOffset;
                placeable.mo1252placeAtf8xVGno(IntOffsetKt.IntOffset(IntOffset.m1937getXimpl(IntOffset) + IntOffset.m1937getXimpl(j), IntOffset.m1938getYimpl(IntOffset) + IntOffset.m1938getYimpl(j)), f, null);
                return;
            }
            long IntOffset2 = IntOffsetKt.IntOffset((getParentWidth() - placeable.getWidth()) - IntOffset.m1937getXimpl(IntOffset), IntOffset.m1938getYimpl(IntOffset));
            long j2 = placeable.apparentToRealOffset;
            placeable.mo1252placeAtf8xVGno(IntOffsetKt.IntOffset(IntOffset.m1937getXimpl(IntOffset2) + IntOffset.m1937getXimpl(j2), IntOffset.m1938getYimpl(IntOffset2) + IntOffset.m1938getYimpl(j2)), f, null);
        }

        public static /* synthetic */ void place$default(PlacementScope placementScope, Placeable placeable, int i, int i2, float f, int i3, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: place");
            }
            if ((i3 & 4) != 0) {
                f = 0.0f;
            }
            placementScope.place(placeable, i, i2, f);
        }

        public final void place(Placeable placeable, int i, int i2, float f) {
            Intrinsics.checkNotNullParameter(placeable, "<this>");
            long IntOffset = IntOffsetKt.IntOffset(i, i2);
            long j = placeable.apparentToRealOffset;
            placeable.mo1252placeAtf8xVGno(IntOffsetKt.IntOffset(IntOffset.m1937getXimpl(IntOffset) + IntOffset.m1937getXimpl(j), IntOffset.m1938getYimpl(IntOffset) + IntOffset.m1938getYimpl(j)), f, null);
        }

        /* renamed from: place-70tqf50$default */
        public static /* synthetic */ void m1272place70tqf50$default(PlacementScope placementScope, Placeable placeable, long j, float f, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: place-70tqf50");
            }
            if ((i & 2) != 0) {
                f = 0.0f;
            }
            placementScope.m1276place70tqf50(placeable, j, f);
        }

        /* renamed from: placeRelativeWithLayer-aW-9-wM$default */
        public static /* synthetic */ void m1274placeRelativeWithLayeraW9wM$default(PlacementScope placementScope, Placeable placeable, long j, float f, Function1 function1, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: placeRelativeWithLayer-aW-9-wM");
            }
            if ((i & 2) != 0) {
                f = 0.0f;
            }
            float f2 = f;
            if ((i & 4) != 0) {
                function1 = PlaceableKt.DefaultLayerBlock;
            }
            placementScope.m1278placeRelativeWithLayeraW9wM(placeable, j, f2, function1);
        }

        public static /* synthetic */ void placeRelativeWithLayer$default(PlacementScope placementScope, Placeable placeable, int i, int i2, float f, Function1 function1, int i3, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: placeRelativeWithLayer");
            }
            if ((i3 & 4) != 0) {
                f = 0.0f;
            }
            float f2 = f;
            if ((i3 & 8) != 0) {
                function1 = PlaceableKt.DefaultLayerBlock;
            }
            placementScope.placeRelativeWithLayer(placeable, i, i2, f2, function1);
        }

        public final void placeRelativeWithLayer(Placeable placeable, int i, int i2, float f, Function1 layerBlock) {
            Intrinsics.checkNotNullParameter(placeable, "<this>");
            Intrinsics.checkNotNullParameter(layerBlock, "layerBlock");
            long IntOffset = IntOffsetKt.IntOffset(i, i2);
            if (getParentLayoutDirection() == LayoutDirection.Ltr || getParentWidth() == 0) {
                long j = placeable.apparentToRealOffset;
                placeable.mo1252placeAtf8xVGno(IntOffsetKt.IntOffset(IntOffset.m1937getXimpl(IntOffset) + IntOffset.m1937getXimpl(j), IntOffset.m1938getYimpl(IntOffset) + IntOffset.m1938getYimpl(j)), f, layerBlock);
                return;
            }
            long IntOffset2 = IntOffsetKt.IntOffset((getParentWidth() - placeable.getWidth()) - IntOffset.m1937getXimpl(IntOffset), IntOffset.m1938getYimpl(IntOffset));
            long j2 = placeable.apparentToRealOffset;
            placeable.mo1252placeAtf8xVGno(IntOffsetKt.IntOffset(IntOffset.m1937getXimpl(IntOffset2) + IntOffset.m1937getXimpl(j2), IntOffset.m1938getYimpl(IntOffset2) + IntOffset.m1938getYimpl(j2)), f, layerBlock);
        }

        public static /* synthetic */ void placeWithLayer$default(PlacementScope placementScope, Placeable placeable, int i, int i2, float f, Function1 function1, int i3, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: placeWithLayer");
            }
            if ((i3 & 4) != 0) {
                f = 0.0f;
            }
            float f2 = f;
            if ((i3 & 8) != 0) {
                function1 = PlaceableKt.DefaultLayerBlock;
            }
            placementScope.placeWithLayer(placeable, i, i2, f2, function1);
        }

        public final void placeWithLayer(Placeable placeable, int i, int i2, float f, Function1 layerBlock) {
            Intrinsics.checkNotNullParameter(placeable, "<this>");
            Intrinsics.checkNotNullParameter(layerBlock, "layerBlock");
            long IntOffset = IntOffsetKt.IntOffset(i, i2);
            long j = placeable.apparentToRealOffset;
            placeable.mo1252placeAtf8xVGno(IntOffsetKt.IntOffset(IntOffset.m1937getXimpl(IntOffset) + IntOffset.m1937getXimpl(j), IntOffset.m1938getYimpl(IntOffset) + IntOffset.m1938getYimpl(j)), f, layerBlock);
        }

        /* renamed from: placeWithLayer-aW-9-wM$default */
        public static /* synthetic */ void m1275placeWithLayeraW9wM$default(PlacementScope placementScope, Placeable placeable, long j, float f, Function1 function1, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: placeWithLayer-aW-9-wM");
            }
            if ((i & 2) != 0) {
                f = 0.0f;
            }
            float f2 = f;
            if ((i & 4) != 0) {
                function1 = PlaceableKt.DefaultLayerBlock;
            }
            placementScope.m1279placeWithLayeraW9wM(placeable, j, f2, function1);
        }

        /* renamed from: placeRelative-70tqf50 */
        public final void m1277placeRelative70tqf50(Placeable placeRelative, long j, float f) {
            Intrinsics.checkNotNullParameter(placeRelative, "$this$placeRelative");
            if (getParentLayoutDirection() == LayoutDirection.Ltr || getParentWidth() == 0) {
                long j2 = placeRelative.apparentToRealOffset;
                placeRelative.mo1252placeAtf8xVGno(IntOffsetKt.IntOffset(IntOffset.m1937getXimpl(j) + IntOffset.m1937getXimpl(j2), IntOffset.m1938getYimpl(j) + IntOffset.m1938getYimpl(j2)), f, null);
                return;
            }
            long IntOffset = IntOffsetKt.IntOffset((getParentWidth() - placeRelative.getWidth()) - IntOffset.m1937getXimpl(j), IntOffset.m1938getYimpl(j));
            long j3 = placeRelative.apparentToRealOffset;
            placeRelative.mo1252placeAtf8xVGno(IntOffsetKt.IntOffset(IntOffset.m1937getXimpl(IntOffset) + IntOffset.m1937getXimpl(j3), IntOffset.m1938getYimpl(IntOffset) + IntOffset.m1938getYimpl(j3)), f, null);
        }

        /* renamed from: placeRelativeWithLayer-aW-9-wM */
        public final void m1278placeRelativeWithLayeraW9wM(Placeable placeRelativeWithLayer, long j, float f, Function1 layerBlock) {
            Intrinsics.checkNotNullParameter(placeRelativeWithLayer, "$this$placeRelativeWithLayer");
            Intrinsics.checkNotNullParameter(layerBlock, "layerBlock");
            if (getParentLayoutDirection() == LayoutDirection.Ltr || getParentWidth() == 0) {
                long j2 = placeRelativeWithLayer.apparentToRealOffset;
                placeRelativeWithLayer.mo1252placeAtf8xVGno(IntOffsetKt.IntOffset(IntOffset.m1937getXimpl(j) + IntOffset.m1937getXimpl(j2), IntOffset.m1938getYimpl(j) + IntOffset.m1938getYimpl(j2)), f, layerBlock);
                return;
            }
            long IntOffset = IntOffsetKt.IntOffset((getParentWidth() - placeRelativeWithLayer.getWidth()) - IntOffset.m1937getXimpl(j), IntOffset.m1938getYimpl(j));
            long j3 = placeRelativeWithLayer.apparentToRealOffset;
            placeRelativeWithLayer.mo1252placeAtf8xVGno(IntOffsetKt.IntOffset(IntOffset.m1937getXimpl(IntOffset) + IntOffset.m1937getXimpl(j3), IntOffset.m1938getYimpl(IntOffset) + IntOffset.m1938getYimpl(j3)), f, layerBlock);
        }

        /* renamed from: place-70tqf50 */
        public final void m1276place70tqf50(Placeable place, long j, float f) {
            Intrinsics.checkNotNullParameter(place, "$this$place");
            long j2 = place.apparentToRealOffset;
            place.mo1252placeAtf8xVGno(IntOffsetKt.IntOffset(IntOffset.m1937getXimpl(j) + IntOffset.m1937getXimpl(j2), IntOffset.m1938getYimpl(j) + IntOffset.m1938getYimpl(j2)), f, null);
        }

        /* renamed from: placeWithLayer-aW-9-wM */
        public final void m1279placeWithLayeraW9wM(Placeable placeWithLayer, long j, float f, Function1 layerBlock) {
            Intrinsics.checkNotNullParameter(placeWithLayer, "$this$placeWithLayer");
            Intrinsics.checkNotNullParameter(layerBlock, "layerBlock");
            long j2 = placeWithLayer.apparentToRealOffset;
            placeWithLayer.mo1252placeAtf8xVGno(IntOffsetKt.IntOffset(IntOffset.m1937getXimpl(j) + IntOffset.m1937getXimpl(j2), IntOffset.m1938getYimpl(j) + IntOffset.m1938getYimpl(j2)), f, layerBlock);
        }

        /* compiled from: Placeable.kt */
        /* loaded from: classes.dex */
        public static final class Companion extends PlacementScope {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public static final /* synthetic */ boolean access$configureForPlacingForAlignment(Companion companion, LookaheadCapablePlaceable lookaheadCapablePlaceable) {
                return companion.configureForPlacingForAlignment(lookaheadCapablePlaceable);
            }

            public static final /* synthetic */ LayoutDirection access$getParentLayoutDirection(Companion companion) {
                return companion.getParentLayoutDirection();
            }

            public static final /* synthetic */ int access$getParentWidth(Companion companion) {
                return companion.getParentWidth();
            }

            @Override // androidx.compose.ui.layout.Placeable.PlacementScope
            public LayoutDirection getParentLayoutDirection() {
                return PlacementScope.parentLayoutDirection;
            }

            @Override // androidx.compose.ui.layout.Placeable.PlacementScope
            public int getParentWidth() {
                return PlacementScope.parentWidth;
            }

            public final boolean configureForPlacingForAlignment(LookaheadCapablePlaceable lookaheadCapablePlaceable) {
                if (lookaheadCapablePlaceable == null) {
                    PlacementScope._coordinates = null;
                    PlacementScope.layoutDelegate = null;
                    return false;
                }
                boolean isPlacingForAlignment$ui_release = lookaheadCapablePlaceable.isPlacingForAlignment$ui_release();
                LookaheadCapablePlaceable parent = lookaheadCapablePlaceable.getParent();
                if (parent != null && parent.isPlacingForAlignment$ui_release()) {
                    lookaheadCapablePlaceable.setPlacingForAlignment$ui_release(true);
                }
                PlacementScope.layoutDelegate = lookaheadCapablePlaceable.getLayoutNode().getLayoutDelegate$ui_release();
                if (lookaheadCapablePlaceable.isPlacingForAlignment$ui_release() || lookaheadCapablePlaceable.isShallowPlacing$ui_release()) {
                    PlacementScope._coordinates = null;
                } else {
                    PlacementScope._coordinates = lookaheadCapablePlaceable.getCoordinates();
                }
                return isPlacingForAlignment$ui_release;
            }
        }
    }
}
