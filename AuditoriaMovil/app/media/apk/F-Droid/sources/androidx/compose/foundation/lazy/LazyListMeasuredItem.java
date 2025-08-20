package androidx.compose.foundation.lazy;

import androidx.compose.foundation.lazy.layout.LazyLayoutAnimateItemModifierNode;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
/* compiled from: LazyListMeasuredItem.kt */
/* loaded from: classes.dex */
public final class LazyListMeasuredItem implements LazyListItemInfo {
    private final int afterContentPadding;
    private final int beforeContentPadding;
    private final Object contentType;
    private final int crossAxisSize;
    private final Alignment.Horizontal horizontalAlignment;
    private final int index;
    private final boolean isVertical;
    private final Object key;
    private final LayoutDirection layoutDirection;
    private int mainAxisLayoutSize;
    private int maxMainAxisOffset;
    private int minMainAxisOffset;
    private int offset;
    private final int[] placeableOffsets;
    private final List placeables;
    private final boolean reverseLayout;
    private final int size;
    private final int sizeWithSpacings;
    private final int spacing;
    private final Alignment.Vertical verticalAlignment;
    private final long visualOffset;

    public /* synthetic */ LazyListMeasuredItem(int i, List list, boolean z, Alignment.Horizontal horizontal, Alignment.Vertical vertical, LayoutDirection layoutDirection, boolean z2, int i2, int i3, int i4, long j, Object obj, Object obj2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, list, z, horizontal, vertical, layoutDirection, z2, i2, i3, i4, j, obj, obj2);
    }

    public final int getCrossAxisSize() {
        return this.crossAxisSize;
    }

    @Override // androidx.compose.foundation.lazy.LazyListItemInfo
    public int getIndex() {
        return this.index;
    }

    public Object getKey() {
        return this.key;
    }

    public int getOffset() {
        return this.offset;
    }

    public int getSize() {
        return this.size;
    }

    public final int getSizeWithSpacings() {
        return this.sizeWithSpacings;
    }

    public final boolean isVertical() {
        return this.isVertical;
    }

    private LazyListMeasuredItem(int i, List placeables, boolean z, Alignment.Horizontal horizontal, Alignment.Vertical vertical, LayoutDirection layoutDirection, boolean z2, int i2, int i3, int i4, long j, Object key, Object obj) {
        int coerceAtLeast;
        Intrinsics.checkNotNullParameter(placeables, "placeables");
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        Intrinsics.checkNotNullParameter(key, "key");
        this.index = i;
        this.placeables = placeables;
        this.isVertical = z;
        this.horizontalAlignment = horizontal;
        this.verticalAlignment = vertical;
        this.layoutDirection = layoutDirection;
        this.reverseLayout = z2;
        this.beforeContentPadding = i2;
        this.afterContentPadding = i3;
        this.spacing = i4;
        this.visualOffset = j;
        this.key = key;
        this.contentType = obj;
        this.mainAxisLayoutSize = Integer.MIN_VALUE;
        int size = placeables.size();
        int i5 = 0;
        int i6 = 0;
        for (int i7 = 0; i7 < size; i7++) {
            Placeable placeable = (Placeable) placeables.get(i7);
            i5 += this.isVertical ? placeable.getHeight() : placeable.getWidth();
            i6 = Math.max(i6, !this.isVertical ? placeable.getHeight() : placeable.getWidth());
        }
        this.size = i5;
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(getSize() + this.spacing, 0);
        this.sizeWithSpacings = coerceAtLeast;
        this.crossAxisSize = i6;
        this.placeableOffsets = new int[this.placeables.size() * 2];
    }

    public final void position(int i, int i2, int i3) {
        int width;
        this.offset = i;
        this.mainAxisLayoutSize = this.isVertical ? i3 : i2;
        List list = this.placeables;
        int size = list.size();
        for (int i4 = 0; i4 < size; i4++) {
            Placeable placeable = (Placeable) list.get(i4);
            int i5 = i4 * 2;
            if (this.isVertical) {
                int[] iArr = this.placeableOffsets;
                Alignment.Horizontal horizontal = this.horizontalAlignment;
                if (horizontal == null) {
                    throw new IllegalArgumentException("Required value was null.".toString());
                }
                iArr[i5] = horizontal.align(placeable.getWidth(), i2, this.layoutDirection);
                this.placeableOffsets[i5 + 1] = i;
                width = placeable.getHeight();
            } else {
                int[] iArr2 = this.placeableOffsets;
                iArr2[i5] = i;
                int i6 = i5 + 1;
                Alignment.Vertical vertical = this.verticalAlignment;
                if (vertical == null) {
                    throw new IllegalArgumentException("Required value was null.".toString());
                }
                iArr2[i6] = vertical.align(placeable.getHeight(), i3);
                width = placeable.getWidth();
            }
            i += width;
        }
        this.minMainAxisOffset = -this.beforeContentPadding;
        this.maxMainAxisOffset = this.mainAxisLayoutSize + this.afterContentPadding;
    }

    public final int getPlaceablesCount() {
        return this.placeables.size();
    }

    public final Object getParentData(int i) {
        return ((Placeable) this.placeables.get(i)).getParentData();
    }

    /* renamed from: getOffset-Bjo55l4  reason: not valid java name */
    public final long m249getOffsetBjo55l4(int i) {
        int[] iArr = this.placeableOffsets;
        int i2 = i * 2;
        return IntOffsetKt.IntOffset(iArr[i2], iArr[i2 + 1]);
    }

    public final void place(Placeable.PlacementScope scope) {
        int m1937getXimpl;
        int m1938getYimpl;
        Intrinsics.checkNotNullParameter(scope, "scope");
        if (this.mainAxisLayoutSize == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("position() should be called first".toString());
        }
        int placeablesCount = getPlaceablesCount();
        for (int i = 0; i < placeablesCount; i++) {
            Placeable placeable = (Placeable) this.placeables.get(i);
            int mainAxisSize = this.minMainAxisOffset - getMainAxisSize(placeable);
            int i2 = this.maxMainAxisOffset;
            long m249getOffsetBjo55l4 = m249getOffsetBjo55l4(i);
            Object parentData = getParentData(i);
            LazyLayoutAnimateItemModifierNode lazyLayoutAnimateItemModifierNode = parentData instanceof LazyLayoutAnimateItemModifierNode ? (LazyLayoutAnimateItemModifierNode) parentData : null;
            if (lazyLayoutAnimateItemModifierNode != null) {
                long m255getPlacementDeltanOccac = lazyLayoutAnimateItemModifierNode.m255getPlacementDeltanOccac();
                long IntOffset = IntOffsetKt.IntOffset(IntOffset.m1937getXimpl(m249getOffsetBjo55l4) + IntOffset.m1937getXimpl(m255getPlacementDeltanOccac), IntOffset.m1938getYimpl(m249getOffsetBjo55l4) + IntOffset.m1938getYimpl(m255getPlacementDeltanOccac));
                if ((m248getMainAxisgyyYBs(m249getOffsetBjo55l4) <= mainAxisSize && m248getMainAxisgyyYBs(IntOffset) <= mainAxisSize) || (m248getMainAxisgyyYBs(m249getOffsetBjo55l4) >= i2 && m248getMainAxisgyyYBs(IntOffset) >= i2)) {
                    lazyLayoutAnimateItemModifierNode.cancelAnimation();
                }
                m249getOffsetBjo55l4 = IntOffset;
            }
            if (this.reverseLayout) {
                if (!this.isVertical) {
                    m1937getXimpl = (this.mainAxisLayoutSize - IntOffset.m1937getXimpl(m249getOffsetBjo55l4)) - getMainAxisSize(placeable);
                } else {
                    m1937getXimpl = IntOffset.m1937getXimpl(m249getOffsetBjo55l4);
                }
                if (this.isVertical) {
                    m1938getYimpl = (this.mainAxisLayoutSize - IntOffset.m1938getYimpl(m249getOffsetBjo55l4)) - getMainAxisSize(placeable);
                } else {
                    m1938getYimpl = IntOffset.m1938getYimpl(m249getOffsetBjo55l4);
                }
                m249getOffsetBjo55l4 = IntOffsetKt.IntOffset(m1937getXimpl, m1938getYimpl);
            }
            long j = this.visualOffset;
            long IntOffset2 = IntOffsetKt.IntOffset(IntOffset.m1937getXimpl(m249getOffsetBjo55l4) + IntOffset.m1937getXimpl(j), IntOffset.m1938getYimpl(m249getOffsetBjo55l4) + IntOffset.m1938getYimpl(j));
            if (this.isVertical) {
                Placeable.PlacementScope.m1275placeWithLayeraW9wM$default(scope, placeable, IntOffset2, 0.0f, null, 6, null);
            } else {
                Placeable.PlacementScope.m1274placeRelativeWithLayeraW9wM$default(scope, placeable, IntOffset2, 0.0f, null, 6, null);
            }
        }
    }

    /* renamed from: getMainAxis--gyyYBs  reason: not valid java name */
    private final int m248getMainAxisgyyYBs(long j) {
        return this.isVertical ? IntOffset.m1938getYimpl(j) : IntOffset.m1937getXimpl(j);
    }

    private final int getMainAxisSize(Placeable placeable) {
        return this.isVertical ? placeable.getHeight() : placeable.getWidth();
    }
}
