package androidx.compose.ui.layout;

import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.LayoutNodeLayoutDelegate;
import androidx.compose.ui.node.LookaheadCapablePlaceable;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: MeasureScope.kt */
/* loaded from: classes.dex */
public interface MeasureScope extends IntrinsicMeasureScope {
    MeasureResult layout(int i, int i2, Map map, Function1 function1);

    /* compiled from: MeasureScope.kt */
    /* renamed from: androidx.compose.ui.layout.MeasureScope$-CC  reason: invalid class name */
    /* loaded from: classes.dex */
    public abstract /* synthetic */ class CC {
        public static /* synthetic */ MeasureResult layout$default(MeasureScope measureScope, int i, int i2, Map map, Function1 function1, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 4) != 0) {
                    map = MapsKt.emptyMap();
                }
                return measureScope.layout(i, i2, map, function1);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: layout");
        }

        public static MeasureResult $default$layout(final MeasureScope measureScope, final int i, final int i2, final Map alignmentLines, final Function1 placementBlock) {
            Intrinsics.checkNotNullParameter(alignmentLines, "alignmentLines");
            Intrinsics.checkNotNullParameter(placementBlock, "placementBlock");
            return new MeasureResult(i, i2, alignmentLines, measureScope, placementBlock) { // from class: androidx.compose.ui.layout.MeasureScope$layout$1
                final /* synthetic */ Function1 $placementBlock;
                final /* synthetic */ int $width;
                private final Map alignmentLines;
                private final int height;
                final /* synthetic */ MeasureScope this$0;
                private final int width;

                @Override // androidx.compose.ui.layout.MeasureResult
                public Map getAlignmentLines() {
                    return this.alignmentLines;
                }

                @Override // androidx.compose.ui.layout.MeasureResult
                public int getHeight() {
                    return this.height;
                }

                @Override // androidx.compose.ui.layout.MeasureResult
                public int getWidth() {
                    return this.width;
                }

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.$width = i;
                    this.this$0 = measureScope;
                    this.$placementBlock = placementBlock;
                    this.width = i;
                    this.height = i2;
                    this.alignmentLines = alignmentLines;
                }

                @Override // androidx.compose.ui.layout.MeasureResult
                public void placeChildren() {
                    Placeable.PlacementScope.Companion companion = Placeable.PlacementScope.Companion;
                    int i3 = this.$width;
                    LayoutDirection layoutDirection = this.this$0.getLayoutDirection();
                    MeasureScope measureScope2 = this.this$0;
                    LookaheadCapablePlaceable lookaheadCapablePlaceable = measureScope2 instanceof LookaheadCapablePlaceable ? (LookaheadCapablePlaceable) measureScope2 : null;
                    Function1 function1 = this.$placementBlock;
                    LayoutCoordinates access$get_coordinates$cp = Placeable.PlacementScope.access$get_coordinates$cp();
                    int access$getParentWidth = Placeable.PlacementScope.Companion.access$getParentWidth(companion);
                    LayoutDirection access$getParentLayoutDirection = Placeable.PlacementScope.Companion.access$getParentLayoutDirection(companion);
                    LayoutNodeLayoutDelegate access$getLayoutDelegate$cp = Placeable.PlacementScope.access$getLayoutDelegate$cp();
                    Placeable.PlacementScope.access$setParentWidth$cp(i3);
                    Placeable.PlacementScope.access$setParentLayoutDirection$cp(layoutDirection);
                    boolean access$configureForPlacingForAlignment = Placeable.PlacementScope.Companion.access$configureForPlacingForAlignment(companion, lookaheadCapablePlaceable);
                    function1.invoke(companion);
                    if (lookaheadCapablePlaceable != null) {
                        lookaheadCapablePlaceable.setPlacingForAlignment$ui_release(access$configureForPlacingForAlignment);
                    }
                    Placeable.PlacementScope.access$setParentWidth$cp(access$getParentWidth);
                    Placeable.PlacementScope.access$setParentLayoutDirection$cp(access$getParentLayoutDirection);
                    Placeable.PlacementScope.access$set_coordinates$cp(access$get_coordinates$cp);
                    Placeable.PlacementScope.access$setLayoutDelegate$cp(access$getLayoutDelegate$cp);
                }
            };
        }
    }
}
