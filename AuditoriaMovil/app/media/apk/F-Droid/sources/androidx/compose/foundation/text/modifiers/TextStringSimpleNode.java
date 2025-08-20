package androidx.compose.foundation.text.modifiers;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RectKt;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorProducer;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.drawscope.Fill;
import androidx.compose.ui.layout.AlignmentLineKt;
import androidx.compose.ui.layout.HorizontalAlignmentLine;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.DrawModifierNode;
import androidx.compose.ui.node.DrawModifierNodeKt;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.node.LayoutModifierNodeKt;
import androidx.compose.ui.node.SemanticsModifierNode;
import androidx.compose.ui.node.SemanticsModifierNodeKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.Paragraph;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSize;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;
/* compiled from: TextStringSimpleNode.kt */
/* loaded from: classes.dex */
public final class TextStringSimpleNode extends Modifier.Node implements LayoutModifierNode, DrawModifierNode, SemanticsModifierNode {
    private ParagraphLayoutCache _layoutCache;
    private Map baselineCache;
    private FontFamily.Resolver fontFamilyResolver;
    private int maxLines;
    private int minLines;
    private int overflow;
    private ColorProducer overrideColor;
    private Function1 semanticsTextLayoutResult;
    private boolean softWrap;
    private TextStyle style;
    private String text;

    public /* synthetic */ TextStringSimpleNode(String str, TextStyle textStyle, FontFamily.Resolver resolver, int i, boolean z, int i2, int i3, ColorProducer colorProducer, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, textStyle, resolver, i, z, i2, i3, colorProducer);
    }

    @Override // androidx.compose.ui.node.SemanticsModifierNode
    public /* synthetic */ boolean getShouldClearDescendantSemantics() {
        return SemanticsModifierNode.CC.$default$getShouldClearDescendantSemantics(this);
    }

    @Override // androidx.compose.ui.node.SemanticsModifierNode
    public /* synthetic */ boolean getShouldMergeDescendantSemantics() {
        return SemanticsModifierNode.CC.$default$getShouldMergeDescendantSemantics(this);
    }

    @Override // androidx.compose.ui.node.DrawModifierNode
    public /* synthetic */ void onMeasureResultChanged() {
        DrawModifierNode.CC.$default$onMeasureResultChanged(this);
    }

    private TextStringSimpleNode(String text, TextStyle style, FontFamily.Resolver fontFamilyResolver, int i, boolean z, int i2, int i3, ColorProducer colorProducer) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(style, "style");
        Intrinsics.checkNotNullParameter(fontFamilyResolver, "fontFamilyResolver");
        this.text = text;
        this.style = style;
        this.fontFamilyResolver = fontFamilyResolver;
        this.overflow = i;
        this.softWrap = z;
        this.maxLines = i2;
        this.minLines = i3;
        this.overrideColor = colorProducer;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ParagraphLayoutCache getLayoutCache() {
        if (this._layoutCache == null) {
            this._layoutCache = new ParagraphLayoutCache(this.text, this.style, this.fontFamilyResolver, this.overflow, this.softWrap, this.maxLines, this.minLines, null);
        }
        ParagraphLayoutCache paragraphLayoutCache = this._layoutCache;
        Intrinsics.checkNotNull(paragraphLayoutCache);
        return paragraphLayoutCache;
    }

    private final ParagraphLayoutCache getLayoutCache(Density density) {
        ParagraphLayoutCache layoutCache = getLayoutCache();
        layoutCache.setDensity$foundation_release(density);
        return layoutCache;
    }

    public final boolean updateDraw(ColorProducer colorProducer, TextStyle style) {
        Intrinsics.checkNotNullParameter(style, "style");
        boolean z = !Intrinsics.areEqual(colorProducer, this.overrideColor);
        this.overrideColor = colorProducer;
        return z || !style.hasSameDrawAffectingAttributes(this.style);
    }

    public final boolean updateText(String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        if (Intrinsics.areEqual(this.text, text)) {
            return false;
        }
        this.text = text;
        return true;
    }

    /* renamed from: updateLayoutRelatedArgs-HuAbxIM  reason: not valid java name */
    public final boolean m385updateLayoutRelatedArgsHuAbxIM(TextStyle style, int i, int i2, boolean z, FontFamily.Resolver fontFamilyResolver, int i3) {
        Intrinsics.checkNotNullParameter(style, "style");
        Intrinsics.checkNotNullParameter(fontFamilyResolver, "fontFamilyResolver");
        boolean z2 = !this.style.hasSameLayoutAffectingAttributes(style);
        this.style = style;
        if (this.minLines != i) {
            this.minLines = i;
            z2 = true;
        }
        if (this.maxLines != i2) {
            this.maxLines = i2;
            z2 = true;
        }
        if (this.softWrap != z) {
            this.softWrap = z;
            z2 = true;
        }
        if (!Intrinsics.areEqual(this.fontFamilyResolver, fontFamilyResolver)) {
            this.fontFamilyResolver = fontFamilyResolver;
            z2 = true;
        }
        if (TextOverflow.m1854equalsimpl0(this.overflow, i3)) {
            return z2;
        }
        this.overflow = i3;
        return true;
    }

    public final void doInvalidations(boolean z, boolean z2, boolean z3) {
        if (isAttached()) {
            if (z2 || (z && this.semanticsTextLayoutResult != null)) {
                SemanticsModifierNodeKt.invalidateSemantics(this);
            }
            if (z2 || z3) {
                getLayoutCache().m381updateL6sJoHM(this.text, this.style, this.fontFamilyResolver, this.overflow, this.softWrap, this.maxLines, this.minLines);
                LayoutModifierNodeKt.invalidateMeasurement(this);
                DrawModifierNodeKt.invalidateDraw(this);
            }
            if (z) {
                DrawModifierNodeKt.invalidateDraw(this);
            }
        }
    }

    @Override // androidx.compose.ui.node.SemanticsModifierNode
    public void applySemantics(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        Intrinsics.checkNotNullParameter(semanticsPropertyReceiver, "<this>");
        Function1 function1 = this.semanticsTextLayoutResult;
        if (function1 == null) {
            function1 = new Function1() { // from class: androidx.compose.foundation.text.modifiers.TextStringSimpleNode$applySemantics$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(List textLayoutResult) {
                    ParagraphLayoutCache layoutCache;
                    Intrinsics.checkNotNullParameter(textLayoutResult, "textLayoutResult");
                    layoutCache = TextStringSimpleNode.this.getLayoutCache();
                    TextLayoutResult slowCreateTextLayoutResultOrNull = layoutCache.slowCreateTextLayoutResultOrNull();
                    if (slowCreateTextLayoutResultOrNull != null) {
                        textLayoutResult.add(slowCreateTextLayoutResultOrNull);
                    }
                    return Boolean.FALSE;
                }
            };
            this.semanticsTextLayoutResult = function1;
        }
        SemanticsPropertiesKt.setText(semanticsPropertyReceiver, new AnnotatedString(this.text, null, null, 6, null));
        SemanticsPropertiesKt.getTextLayoutResult$default(semanticsPropertyReceiver, null, function1, 1, null);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* renamed from: measure-3p2s80s */
    public MeasureResult mo117measure3p2s80s(MeasureScope measure, Measurable measurable, long j) {
        int roundToInt;
        int roundToInt2;
        Intrinsics.checkNotNullParameter(measure, "$this$measure");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        ParagraphLayoutCache layoutCache = getLayoutCache(measure);
        boolean m380layoutWithConstraintsK40F9xA = layoutCache.m380layoutWithConstraintsK40F9xA(j, measure.getLayoutDirection());
        layoutCache.getObserveFontChanges$foundation_release();
        Paragraph paragraph$foundation_release = layoutCache.getParagraph$foundation_release();
        Intrinsics.checkNotNull(paragraph$foundation_release);
        long m379getLayoutSizeYbymL2g$foundation_release = layoutCache.m379getLayoutSizeYbymL2g$foundation_release();
        if (m380layoutWithConstraintsK40F9xA) {
            LayoutModifierNodeKt.invalidateLayer(this);
            Map map = this.baselineCache;
            if (map == null) {
                map = new LinkedHashMap(2);
            }
            HorizontalAlignmentLine firstBaseline = AlignmentLineKt.getFirstBaseline();
            roundToInt = MathKt__MathJVMKt.roundToInt(paragraph$foundation_release.getFirstBaseline());
            map.put(firstBaseline, Integer.valueOf(roundToInt));
            HorizontalAlignmentLine lastBaseline = AlignmentLineKt.getLastBaseline();
            roundToInt2 = MathKt__MathJVMKt.roundToInt(paragraph$foundation_release.getLastBaseline());
            map.put(lastBaseline, Integer.valueOf(roundToInt2));
            this.baselineCache = map;
        }
        final Placeable mo1251measureBRTryo0 = measurable.mo1251measureBRTryo0(Constraints.Companion.m1879fixedJhjzzOo(IntSize.m1951getWidthimpl(m379getLayoutSizeYbymL2g$foundation_release), IntSize.m1950getHeightimpl(m379getLayoutSizeYbymL2g$foundation_release)));
        int m1951getWidthimpl = IntSize.m1951getWidthimpl(m379getLayoutSizeYbymL2g$foundation_release);
        int m1950getHeightimpl = IntSize.m1950getHeightimpl(m379getLayoutSizeYbymL2g$foundation_release);
        Map map2 = this.baselineCache;
        Intrinsics.checkNotNull(map2);
        return measure.layout(m1951getWidthimpl, m1950getHeightimpl, map2, new Function1() { // from class: androidx.compose.foundation.text.modifiers.TextStringSimpleNode$measure$1
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
                Placeable.PlacementScope.place$default(layout, Placeable.this, 0, 0, 0.0f, 4, null);
            }
        });
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable measurable, int i) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        return getLayoutCache(intrinsicMeasureScope).minIntrinsicWidth(intrinsicMeasureScope.getLayoutDirection());
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable measurable, int i) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        return getLayoutCache(intrinsicMeasureScope).intrinsicHeight(i, intrinsicMeasureScope.getLayoutDirection());
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable measurable, int i) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        return getLayoutCache(intrinsicMeasureScope).maxIntrinsicWidth(intrinsicMeasureScope.getLayoutDirection());
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable measurable, int i) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        return getLayoutCache(intrinsicMeasureScope).intrinsicHeight(i, intrinsicMeasureScope.getLayoutDirection());
    }

    @Override // androidx.compose.ui.node.DrawModifierNode
    public void draw(ContentDrawScope contentDrawScope) {
        Intrinsics.checkNotNullParameter(contentDrawScope, "<this>");
        if (isAttached()) {
            Paragraph paragraph$foundation_release = getLayoutCache().getParagraph$foundation_release();
            if (paragraph$foundation_release != null) {
                Canvas canvas = contentDrawScope.getDrawContext().getCanvas();
                boolean didOverflow$foundation_release = getLayoutCache().getDidOverflow$foundation_release();
                if (didOverflow$foundation_release) {
                    Rect m732Recttz77jQw = RectKt.m732Recttz77jQw(Offset.Companion.m721getZeroF1C5BW0(), SizeKt.Size(IntSize.m1951getWidthimpl(getLayoutCache().m379getLayoutSizeYbymL2g$foundation_release()), IntSize.m1950getHeightimpl(getLayoutCache().m379getLayoutSizeYbymL2g$foundation_release())));
                    canvas.save();
                    Canvas.CC.m836clipRectmtrdDE$default(canvas, m732Recttz77jQw, 0, 2, null);
                }
                try {
                    TextDecoration textDecoration = this.style.getTextDecoration();
                    if (textDecoration == null) {
                        textDecoration = TextDecoration.Companion.getNone();
                    }
                    TextDecoration textDecoration2 = textDecoration;
                    Shadow shadow = this.style.getShadow();
                    if (shadow == null) {
                        shadow = Shadow.Companion.getNone();
                    }
                    Shadow shadow2 = shadow;
                    DrawStyle drawStyle = this.style.getDrawStyle();
                    if (drawStyle == null) {
                        drawStyle = Fill.INSTANCE;
                    }
                    DrawStyle drawStyle2 = drawStyle;
                    Brush brush = this.style.getBrush();
                    if (brush != null) {
                        Paragraph.CC.m1528painthn5TExg$default(paragraph$foundation_release, canvas, brush, this.style.getAlpha(), shadow2, textDecoration2, drawStyle2, 0, 64, null);
                    } else {
                        ColorProducer colorProducer = this.overrideColor;
                        long mo583invoke0d7_KjU = colorProducer != null ? colorProducer.mo583invoke0d7_KjU() : Color.Companion.m864getUnspecified0d7_KjU();
                        Color.Companion companion = Color.Companion;
                        if (mo583invoke0d7_KjU == companion.m864getUnspecified0d7_KjU()) {
                            if (this.style.m1597getColor0d7_KjU() != companion.m864getUnspecified0d7_KjU()) {
                                mo583invoke0d7_KjU = this.style.m1597getColor0d7_KjU();
                            } else {
                                mo583invoke0d7_KjU = companion.m860getBlack0d7_KjU();
                            }
                        }
                        Paragraph.CC.m1527paintLG529CI$default(paragraph$foundation_release, canvas, mo583invoke0d7_KjU, shadow2, textDecoration2, drawStyle2, 0, 32, null);
                    }
                    if (didOverflow$foundation_release) {
                        canvas.restore();
                        return;
                    }
                    return;
                } catch (Throwable th) {
                    if (didOverflow$foundation_release) {
                        canvas.restore();
                    }
                    throw th;
                }
            }
            throw new IllegalArgumentException("no paragraph".toString());
        }
    }
}
