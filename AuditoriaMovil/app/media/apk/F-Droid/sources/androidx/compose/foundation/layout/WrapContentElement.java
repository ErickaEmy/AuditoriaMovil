package androidx.compose.foundation.layout;

import androidx.compose.foundation.ClickableElement$$ExternalSyntheticBackport0;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Size.kt */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0002\u0018\u0000 \u001f2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001fBD\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\u0010\u001a\u00020\t\u0012\u0018\u0010\u0016\u001a\u0014\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u0012\u0012\u0006\u0010\u0018\u001a\u00020\u0007\u0012\u0006\u0010\u001b\u001a\u00020\u001aø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001eJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0013\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0096\u0002J\b\u0010\f\u001a\u00020\u000bH\u0016R\u0014\u0010\u000e\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R)\u0010\u0016\u001a\u0014\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u00128\u0002X\u0082\u0004ø\u0001\u0000¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001b\u001a\u00020\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001c\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006 "}, d2 = {"Landroidx/compose/foundation/layout/WrapContentElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/layout/WrapContentNode;", "create", "node", "", "update", "", "other", "", "equals", "", "hashCode", "Landroidx/compose/foundation/layout/Direction;", "direction", "Landroidx/compose/foundation/layout/Direction;", "unbounded", "Z", "Lkotlin/Function2;", "Landroidx/compose/ui/unit/IntSize;", "Landroidx/compose/ui/unit/LayoutDirection;", "Landroidx/compose/ui/unit/IntOffset;", "alignmentCallback", "Lkotlin/jvm/functions/Function2;", "align", "Ljava/lang/Object;", "", "inspectorName", "Ljava/lang/String;", "<init>", "(Landroidx/compose/foundation/layout/Direction;ZLkotlin/jvm/functions/Function2;Ljava/lang/Object;Ljava/lang/String;)V", "Companion", "foundation-layout_release"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes.dex */
public final class WrapContentElement extends ModifierNodeElement {
    public static final Companion Companion = new Companion(null);
    private final Object align;
    private final Function2 alignmentCallback;
    private final Direction direction;
    private final String inspectorName;
    private final boolean unbounded;

    public WrapContentElement(Direction direction, boolean z, Function2 alignmentCallback, Object align, String inspectorName) {
        Intrinsics.checkNotNullParameter(direction, "direction");
        Intrinsics.checkNotNullParameter(alignmentCallback, "alignmentCallback");
        Intrinsics.checkNotNullParameter(align, "align");
        Intrinsics.checkNotNullParameter(inspectorName, "inspectorName");
        this.direction = direction;
        this.unbounded = z;
        this.alignmentCallback = alignmentCallback;
        this.align = align;
        this.inspectorName = inspectorName;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public WrapContentNode create() {
        return new WrapContentNode(this.direction, this.unbounded, this.alignmentCallback);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void update(WrapContentNode node) {
        Intrinsics.checkNotNullParameter(node, "node");
        node.setDirection(this.direction);
        node.setUnbounded(this.unbounded);
        node.setAlignmentCallback(this.alignmentCallback);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (Intrinsics.areEqual(WrapContentElement.class, obj != null ? obj.getClass() : null)) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type androidx.compose.foundation.layout.WrapContentElement");
            WrapContentElement wrapContentElement = (WrapContentElement) obj;
            return this.direction == wrapContentElement.direction && this.unbounded == wrapContentElement.unbounded && Intrinsics.areEqual(this.align, wrapContentElement.align);
        }
        return false;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public int hashCode() {
        return (((this.direction.hashCode() * 31) + ClickableElement$$ExternalSyntheticBackport0.m(this.unbounded)) * 31) + this.align.hashCode();
    }

    /* compiled from: Size.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final WrapContentElement width(final Alignment.Horizontal align, boolean z) {
            Intrinsics.checkNotNullParameter(align, "align");
            return new WrapContentElement(Direction.Horizontal, z, new Function2() { // from class: androidx.compose.foundation.layout.WrapContentElement$Companion$width$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    return IntOffset.m1929boximpl(m245invoke5SAbXVA(((IntSize) obj).m1954unboximpl(), (LayoutDirection) obj2));
                }

                /* renamed from: invoke-5SAbXVA  reason: not valid java name */
                public final long m245invoke5SAbXVA(long j, LayoutDirection layoutDirection) {
                    Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
                    return IntOffsetKt.IntOffset(Alignment.Horizontal.this.align(0, IntSize.m1951getWidthimpl(j), layoutDirection), 0);
                }
            }, align, "wrapContentWidth");
        }

        public final WrapContentElement height(final Alignment.Vertical align, boolean z) {
            Intrinsics.checkNotNullParameter(align, "align");
            return new WrapContentElement(Direction.Vertical, z, new Function2() { // from class: androidx.compose.foundation.layout.WrapContentElement$Companion$height$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    return IntOffset.m1929boximpl(m243invoke5SAbXVA(((IntSize) obj).m1954unboximpl(), (LayoutDirection) obj2));
                }

                /* renamed from: invoke-5SAbXVA  reason: not valid java name */
                public final long m243invoke5SAbXVA(long j, LayoutDirection layoutDirection) {
                    Intrinsics.checkNotNullParameter(layoutDirection, "<anonymous parameter 1>");
                    return IntOffsetKt.IntOffset(0, Alignment.Vertical.this.align(0, IntSize.m1950getHeightimpl(j)));
                }
            }, align, "wrapContentHeight");
        }

        public final WrapContentElement size(final Alignment align, boolean z) {
            Intrinsics.checkNotNullParameter(align, "align");
            return new WrapContentElement(Direction.Both, z, new Function2() { // from class: androidx.compose.foundation.layout.WrapContentElement$Companion$size$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    return IntOffset.m1929boximpl(m244invoke5SAbXVA(((IntSize) obj).m1954unboximpl(), (LayoutDirection) obj2));
                }

                /* renamed from: invoke-5SAbXVA  reason: not valid java name */
                public final long m244invoke5SAbXVA(long j, LayoutDirection layoutDirection) {
                    Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
                    return Alignment.this.mo636alignKFBX0sM(IntSize.Companion.m1955getZeroYbymL2g(), j, layoutDirection);
                }
            }, align, "wrapContentSize");
        }
    }
}
