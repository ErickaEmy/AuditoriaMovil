package androidx.compose.ui.draw;

import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.ScaleFactorKt;
import androidx.compose.ui.node.DrawModifierNode;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSizeKt;
import ch.qos.logback.core.CoreConstants;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;
/* compiled from: PainterModifier.kt */
/* loaded from: classes.dex */
final class PainterNode extends Modifier.Node implements LayoutModifierNode, DrawModifierNode {
    private Alignment alignment;
    private float alpha;
    private ColorFilter colorFilter;
    private ContentScale contentScale;
    private Painter painter;
    private boolean sizeToIntrinsics;

    public final Painter getPainter() {
        return this.painter;
    }

    @Override // androidx.compose.ui.Modifier.Node
    public boolean getShouldAutoInvalidate() {
        return false;
    }

    public final boolean getSizeToIntrinsics() {
        return this.sizeToIntrinsics;
    }

    @Override // androidx.compose.ui.node.DrawModifierNode
    public /* synthetic */ void onMeasureResultChanged() {
        DrawModifierNode.CC.$default$onMeasureResultChanged(this);
    }

    public final void setAlignment(Alignment alignment) {
        Intrinsics.checkNotNullParameter(alignment, "<set-?>");
        this.alignment = alignment;
    }

    public final void setAlpha(float f) {
        this.alpha = f;
    }

    public final void setColorFilter(ColorFilter colorFilter) {
        this.colorFilter = colorFilter;
    }

    public final void setContentScale(ContentScale contentScale) {
        Intrinsics.checkNotNullParameter(contentScale, "<set-?>");
        this.contentScale = contentScale;
    }

    public final void setPainter(Painter painter) {
        Intrinsics.checkNotNullParameter(painter, "<set-?>");
        this.painter = painter;
    }

    public final void setSizeToIntrinsics(boolean z) {
        this.sizeToIntrinsics = z;
    }

    public PainterNode(Painter painter, boolean z, Alignment alignment, ContentScale contentScale, float f, ColorFilter colorFilter) {
        Intrinsics.checkNotNullParameter(painter, "painter");
        Intrinsics.checkNotNullParameter(alignment, "alignment");
        Intrinsics.checkNotNullParameter(contentScale, "contentScale");
        this.painter = painter;
        this.sizeToIntrinsics = z;
        this.alignment = alignment;
        this.contentScale = contentScale;
        this.alpha = f;
        this.colorFilter = colorFilter;
    }

    private final boolean getUseIntrinsicSize() {
        return this.sizeToIntrinsics && this.painter.mo1072getIntrinsicSizeNHjbRc() != Size.Companion.m750getUnspecifiedNHjbRc();
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* renamed from: measure-3p2s80s */
    public MeasureResult mo117measure3p2s80s(MeasureScope measure, Measurable measurable, long j) {
        Intrinsics.checkNotNullParameter(measure, "$this$measure");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        final Placeable mo1251measureBRTryo0 = measurable.mo1251measureBRTryo0(m643modifyConstraintsZezNO4M(j));
        return MeasureScope.CC.layout$default(measure, mo1251measureBRTryo0.getWidth(), mo1251measureBRTryo0.getHeight(), null, new Function1() { // from class: androidx.compose.ui.draw.PainterNode$measure$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Placeable.PlacementScope) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Placeable.PlacementScope layout) {
                Intrinsics.checkNotNullParameter(layout, "$this$layout");
                Placeable.PlacementScope.placeRelative$default(layout, Placeable.this, 0, 0, 0.0f, 4, null);
            }
        }, 4, null);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable measurable, int i) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        if (getUseIntrinsicSize()) {
            long m643modifyConstraintsZezNO4M = m643modifyConstraintsZezNO4M(ConstraintsKt.Constraints$default(0, 0, 0, i, 7, null));
            return Math.max(Constraints.m1874getMinWidthimpl(m643modifyConstraintsZezNO4M), measurable.minIntrinsicWidth(i));
        }
        return measurable.minIntrinsicWidth(i);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable measurable, int i) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        if (getUseIntrinsicSize()) {
            long m643modifyConstraintsZezNO4M = m643modifyConstraintsZezNO4M(ConstraintsKt.Constraints$default(0, 0, 0, i, 7, null));
            return Math.max(Constraints.m1874getMinWidthimpl(m643modifyConstraintsZezNO4M), measurable.maxIntrinsicWidth(i));
        }
        return measurable.maxIntrinsicWidth(i);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable measurable, int i) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        if (getUseIntrinsicSize()) {
            long m643modifyConstraintsZezNO4M = m643modifyConstraintsZezNO4M(ConstraintsKt.Constraints$default(0, i, 0, 0, 13, null));
            return Math.max(Constraints.m1873getMinHeightimpl(m643modifyConstraintsZezNO4M), measurable.minIntrinsicHeight(i));
        }
        return measurable.minIntrinsicHeight(i);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable measurable, int i) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        if (getUseIntrinsicSize()) {
            long m643modifyConstraintsZezNO4M = m643modifyConstraintsZezNO4M(ConstraintsKt.Constraints$default(0, i, 0, 0, 13, null));
            return Math.max(Constraints.m1873getMinHeightimpl(m643modifyConstraintsZezNO4M), measurable.maxIntrinsicHeight(i));
        }
        return measurable.maxIntrinsicHeight(i);
    }

    /* renamed from: calculateScaledSize-E7KxVPU  reason: not valid java name */
    private final long m640calculateScaledSizeE7KxVPU(long j) {
        float m745getWidthimpl;
        float m743getHeightimpl;
        if (getUseIntrinsicSize()) {
            if (!m642hasSpecifiedAndFiniteWidthuvyYCjk(this.painter.mo1072getIntrinsicSizeNHjbRc())) {
                m745getWidthimpl = Size.m745getWidthimpl(j);
            } else {
                m745getWidthimpl = Size.m745getWidthimpl(this.painter.mo1072getIntrinsicSizeNHjbRc());
            }
            if (!m641hasSpecifiedAndFiniteHeightuvyYCjk(this.painter.mo1072getIntrinsicSizeNHjbRc())) {
                m743getHeightimpl = Size.m743getHeightimpl(j);
            } else {
                m743getHeightimpl = Size.m743getHeightimpl(this.painter.mo1072getIntrinsicSizeNHjbRc());
            }
            long Size = SizeKt.Size(m745getWidthimpl, m743getHeightimpl);
            if (Size.m745getWidthimpl(j) != 0.0f && Size.m743getHeightimpl(j) != 0.0f) {
                return ScaleFactorKt.m1283timesUQTWf7w(Size, this.contentScale.mo1242computeScaleFactorH7hwNQA(Size, j));
            }
            return Size.Companion.m751getZeroNHjbRc();
        }
        return j;
    }

    /* renamed from: modifyConstraints-ZezNO4M  reason: not valid java name */
    private final long m643modifyConstraintsZezNO4M(long j) {
        int m1874getMinWidthimpl;
        int m1873getMinHeightimpl;
        int roundToInt;
        int roundToInt2;
        boolean z = false;
        boolean z2 = Constraints.m1868getHasBoundedWidthimpl(j) && Constraints.m1867getHasBoundedHeightimpl(j);
        if (Constraints.m1870getHasFixedWidthimpl(j) && Constraints.m1869getHasFixedHeightimpl(j)) {
            z = true;
        }
        if ((!getUseIntrinsicSize() && z2) || z) {
            return Constraints.m1863copyZbe2FdA$default(j, Constraints.m1872getMaxWidthimpl(j), 0, Constraints.m1871getMaxHeightimpl(j), 0, 10, null);
        }
        long mo1072getIntrinsicSizeNHjbRc = this.painter.mo1072getIntrinsicSizeNHjbRc();
        if (m642hasSpecifiedAndFiniteWidthuvyYCjk(mo1072getIntrinsicSizeNHjbRc)) {
            m1874getMinWidthimpl = MathKt__MathJVMKt.roundToInt(Size.m745getWidthimpl(mo1072getIntrinsicSizeNHjbRc));
        } else {
            m1874getMinWidthimpl = Constraints.m1874getMinWidthimpl(j);
        }
        if (m641hasSpecifiedAndFiniteHeightuvyYCjk(mo1072getIntrinsicSizeNHjbRc)) {
            m1873getMinHeightimpl = MathKt__MathJVMKt.roundToInt(Size.m743getHeightimpl(mo1072getIntrinsicSizeNHjbRc));
        } else {
            m1873getMinHeightimpl = Constraints.m1873getMinHeightimpl(j);
        }
        long m640calculateScaledSizeE7KxVPU = m640calculateScaledSizeE7KxVPU(SizeKt.Size(ConstraintsKt.m1884constrainWidthK40F9xA(j, m1874getMinWidthimpl), ConstraintsKt.m1883constrainHeightK40F9xA(j, m1873getMinHeightimpl)));
        roundToInt = MathKt__MathJVMKt.roundToInt(Size.m745getWidthimpl(m640calculateScaledSizeE7KxVPU));
        int m1884constrainWidthK40F9xA = ConstraintsKt.m1884constrainWidthK40F9xA(j, roundToInt);
        roundToInt2 = MathKt__MathJVMKt.roundToInt(Size.m743getHeightimpl(m640calculateScaledSizeE7KxVPU));
        return Constraints.m1863copyZbe2FdA$default(j, m1884constrainWidthK40F9xA, 0, ConstraintsKt.m1883constrainHeightK40F9xA(j, roundToInt2), 0, 10, null);
    }

    @Override // androidx.compose.ui.node.DrawModifierNode
    public void draw(ContentDrawScope contentDrawScope) {
        float m745getWidthimpl;
        float m743getHeightimpl;
        long m751getZeroNHjbRc;
        int roundToInt;
        int roundToInt2;
        int roundToInt3;
        int roundToInt4;
        Intrinsics.checkNotNullParameter(contentDrawScope, "<this>");
        long mo1072getIntrinsicSizeNHjbRc = this.painter.mo1072getIntrinsicSizeNHjbRc();
        if (m642hasSpecifiedAndFiniteWidthuvyYCjk(mo1072getIntrinsicSizeNHjbRc)) {
            m745getWidthimpl = Size.m745getWidthimpl(mo1072getIntrinsicSizeNHjbRc);
        } else {
            m745getWidthimpl = Size.m745getWidthimpl(contentDrawScope.mo1040getSizeNHjbRc());
        }
        if (m641hasSpecifiedAndFiniteHeightuvyYCjk(mo1072getIntrinsicSizeNHjbRc)) {
            m743getHeightimpl = Size.m743getHeightimpl(mo1072getIntrinsicSizeNHjbRc);
        } else {
            m743getHeightimpl = Size.m743getHeightimpl(contentDrawScope.mo1040getSizeNHjbRc());
        }
        long Size = SizeKt.Size(m745getWidthimpl, m743getHeightimpl);
        if (Size.m745getWidthimpl(contentDrawScope.mo1040getSizeNHjbRc()) != 0.0f && Size.m743getHeightimpl(contentDrawScope.mo1040getSizeNHjbRc()) != 0.0f) {
            m751getZeroNHjbRc = ScaleFactorKt.m1283timesUQTWf7w(Size, this.contentScale.mo1242computeScaleFactorH7hwNQA(Size, contentDrawScope.mo1040getSizeNHjbRc()));
        } else {
            m751getZeroNHjbRc = Size.Companion.m751getZeroNHjbRc();
        }
        long j = m751getZeroNHjbRc;
        Alignment alignment = this.alignment;
        roundToInt = MathKt__MathJVMKt.roundToInt(Size.m745getWidthimpl(j));
        roundToInt2 = MathKt__MathJVMKt.roundToInt(Size.m743getHeightimpl(j));
        long IntSize = IntSizeKt.IntSize(roundToInt, roundToInt2);
        roundToInt3 = MathKt__MathJVMKt.roundToInt(Size.m745getWidthimpl(contentDrawScope.mo1040getSizeNHjbRc()));
        roundToInt4 = MathKt__MathJVMKt.roundToInt(Size.m743getHeightimpl(contentDrawScope.mo1040getSizeNHjbRc()));
        long mo636alignKFBX0sM = alignment.mo636alignKFBX0sM(IntSize, IntSizeKt.IntSize(roundToInt3, roundToInt4), contentDrawScope.getLayoutDirection());
        float m1937getXimpl = IntOffset.m1937getXimpl(mo636alignKFBX0sM);
        float m1938getYimpl = IntOffset.m1938getYimpl(mo636alignKFBX0sM);
        contentDrawScope.getDrawContext().getTransform().translate(m1937getXimpl, m1938getYimpl);
        this.painter.m1073drawx_KDEd0(contentDrawScope, j, this.alpha, this.colorFilter);
        contentDrawScope.getDrawContext().getTransform().translate(-m1937getXimpl, -m1938getYimpl);
        contentDrawScope.drawContent();
    }

    /* renamed from: hasSpecifiedAndFiniteWidth-uvyYCjk  reason: not valid java name */
    private final boolean m642hasSpecifiedAndFiniteWidthuvyYCjk(long j) {
        if (!Size.m742equalsimpl0(j, Size.Companion.m750getUnspecifiedNHjbRc())) {
            float m745getWidthimpl = Size.m745getWidthimpl(j);
            if (!Float.isInfinite(m745getWidthimpl) && !Float.isNaN(m745getWidthimpl)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: hasSpecifiedAndFiniteHeight-uvyYCjk  reason: not valid java name */
    private final boolean m641hasSpecifiedAndFiniteHeightuvyYCjk(long j) {
        if (!Size.m742equalsimpl0(j, Size.Companion.m750getUnspecifiedNHjbRc())) {
            float m743getHeightimpl = Size.m743getHeightimpl(j);
            if (!Float.isInfinite(m743getHeightimpl) && !Float.isNaN(m743getHeightimpl)) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        return "PainterModifier(painter=" + this.painter + ", sizeToIntrinsics=" + this.sizeToIntrinsics + ", alignment=" + this.alignment + ", alpha=" + this.alpha + ", colorFilter=" + this.colorFilter + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }
}
