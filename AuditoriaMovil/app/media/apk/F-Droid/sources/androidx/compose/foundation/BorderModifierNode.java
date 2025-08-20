package androidx.compose.foundation;

import androidx.compose.ui.draw.CacheDrawModifierNode;
import androidx.compose.ui.draw.CacheDrawScope;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.draw.DrawResult;
import androidx.compose.ui.geometry.CornerRadius;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.RoundRectKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.ClipOp;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.unit.Dp;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: Border.kt */
/* loaded from: classes.dex */
public final class BorderModifierNode extends DelegatingNode {
    private BorderCache borderCache;
    private Brush brush;
    private final CacheDrawModifierNode drawWithCacheModifierNode;
    private Shape shape;
    private float width;

    public /* synthetic */ BorderModifierNode(float f, Brush brush, Shape shape, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, brush, shape);
    }

    public final Brush getBrush() {
        return this.brush;
    }

    public final Shape getShape() {
        return this.shape;
    }

    /* renamed from: getWidth-D9Ej5fM  reason: not valid java name */
    public final float m86getWidthD9Ej5fM() {
        return this.width;
    }

    private BorderModifierNode(float f, Brush brushParameter, Shape shapeParameter) {
        Intrinsics.checkNotNullParameter(brushParameter, "brushParameter");
        Intrinsics.checkNotNullParameter(shapeParameter, "shapeParameter");
        this.width = f;
        this.brush = brushParameter;
        this.shape = shapeParameter;
        this.drawWithCacheModifierNode = (CacheDrawModifierNode) delegate(DrawModifierKt.CacheDrawModifierNode(new Function1() { // from class: androidx.compose.foundation.BorderModifierNode$drawWithCacheModifierNode$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final DrawResult invoke(CacheDrawScope CacheDrawModifierNode) {
                DrawResult drawContentWithoutBorder;
                DrawResult m82drawRectBorderNsqcLGU;
                DrawResult m85drawRoundRectBorderJqoCqck;
                DrawResult drawGenericBorder;
                Intrinsics.checkNotNullParameter(CacheDrawModifierNode, "$this$CacheDrawModifierNode");
                if (CacheDrawModifierNode.mo155toPx0680j_4(BorderModifierNode.this.m86getWidthD9Ej5fM()) < 0.0f || Size.m744getMinDimensionimpl(CacheDrawModifierNode.m639getSizeNHjbRc()) <= 0.0f) {
                    drawContentWithoutBorder = BorderKt.drawContentWithoutBorder(CacheDrawModifierNode);
                    return drawContentWithoutBorder;
                }
                float f2 = 2;
                float min = Math.min(Dp.m1899equalsimpl0(BorderModifierNode.this.m86getWidthD9Ej5fM(), Dp.Companion.m1904getHairlineD9Ej5fM()) ? 1.0f : (float) Math.ceil(CacheDrawModifierNode.mo155toPx0680j_4(BorderModifierNode.this.m86getWidthD9Ej5fM())), (float) Math.ceil(Size.m744getMinDimensionimpl(CacheDrawModifierNode.m639getSizeNHjbRc()) / f2));
                float f3 = min / f2;
                long Offset = OffsetKt.Offset(f3, f3);
                long Size = SizeKt.Size(Size.m745getWidthimpl(CacheDrawModifierNode.m639getSizeNHjbRc()) - min, Size.m743getHeightimpl(CacheDrawModifierNode.m639getSizeNHjbRc()) - min);
                boolean z = f2 * min > Size.m744getMinDimensionimpl(CacheDrawModifierNode.m639getSizeNHjbRc());
                Outline mo104createOutlinePq9zytI = BorderModifierNode.this.getShape().mo104createOutlinePq9zytI(CacheDrawModifierNode.m639getSizeNHjbRc(), CacheDrawModifierNode.getLayoutDirection(), CacheDrawModifierNode);
                if (mo104createOutlinePq9zytI instanceof Outline.Generic) {
                    BorderModifierNode borderModifierNode = BorderModifierNode.this;
                    drawGenericBorder = borderModifierNode.drawGenericBorder(CacheDrawModifierNode, borderModifierNode.getBrush(), (Outline.Generic) mo104createOutlinePq9zytI, z, min);
                    return drawGenericBorder;
                } else if (mo104createOutlinePq9zytI instanceof Outline.Rounded) {
                    BorderModifierNode borderModifierNode2 = BorderModifierNode.this;
                    m85drawRoundRectBorderJqoCqck = borderModifierNode2.m85drawRoundRectBorderJqoCqck(CacheDrawModifierNode, borderModifierNode2.getBrush(), (Outline.Rounded) mo104createOutlinePq9zytI, Offset, Size, z, min);
                    return m85drawRoundRectBorderJqoCqck;
                } else if (mo104createOutlinePq9zytI instanceof Outline.Rectangle) {
                    m82drawRectBorderNsqcLGU = BorderKt.m82drawRectBorderNsqcLGU(CacheDrawModifierNode, BorderModifierNode.this.getBrush(), Offset, Size, z, min);
                    return m82drawRectBorderNsqcLGU;
                } else {
                    throw new NoWhenBranchMatchedException();
                }
            }
        }));
    }

    /* renamed from: setWidth-0680j_4  reason: not valid java name */
    public final void m87setWidth0680j_4(float f) {
        if (Dp.m1899equalsimpl0(this.width, f)) {
            return;
        }
        this.width = f;
        this.drawWithCacheModifierNode.invalidateDrawCache();
    }

    public final void setBrush(Brush value) {
        Intrinsics.checkNotNullParameter(value, "value");
        if (Intrinsics.areEqual(this.brush, value)) {
            return;
        }
        this.brush = value;
        this.drawWithCacheModifierNode.invalidateDrawCache();
    }

    public final void setShape(Shape value) {
        Intrinsics.checkNotNullParameter(value, "value");
        if (Intrinsics.areEqual(this.shape, value)) {
            return;
        }
        this.shape = value;
        this.drawWithCacheModifierNode.invalidateDrawCache();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0130  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final androidx.compose.ui.draw.DrawResult drawGenericBorder(androidx.compose.ui.draw.CacheDrawScope r46, final androidx.compose.ui.graphics.Brush r47, final androidx.compose.ui.graphics.Outline.Generic r48, boolean r49, float r50) {
        /*
            Method dump skipped, instructions count: 660
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.BorderModifierNode.drawGenericBorder(androidx.compose.ui.draw.CacheDrawScope, androidx.compose.ui.graphics.Brush, androidx.compose.ui.graphics.Outline$Generic, boolean, float):androidx.compose.ui.draw.DrawResult");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: drawRoundRectBorder-JqoCqck  reason: not valid java name */
    public final DrawResult m85drawRoundRectBorderJqoCqck(CacheDrawScope cacheDrawScope, final Brush brush, Outline.Rounded rounded, final long j, final long j2, final boolean z, final float f) {
        final Path createRoundRectPath;
        if (RoundRectKt.isSimple(rounded.getRoundRect())) {
            final long m735getTopLeftCornerRadiuskKHJgLs = rounded.getRoundRect().m735getTopLeftCornerRadiuskKHJgLs();
            final float f2 = f / 2;
            final Stroke stroke = new Stroke(f, 0.0f, 0, 0, null, 30, null);
            return cacheDrawScope.onDrawWithContent(new Function1() { // from class: androidx.compose.foundation.BorderModifierNode$drawRoundRectBorder$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((ContentDrawScope) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(ContentDrawScope onDrawWithContent) {
                    long m83shrinkKibmq7A;
                    Intrinsics.checkNotNullParameter(onDrawWithContent, "$this$onDrawWithContent");
                    onDrawWithContent.drawContent();
                    if (z) {
                        DrawScope.CC.m1064drawRoundRectZuiqVtQ$default(onDrawWithContent, brush, 0L, 0L, m735getTopLeftCornerRadiuskKHJgLs, 0.0f, null, null, 0, 246, null);
                        return;
                    }
                    float m693getXimpl = CornerRadius.m693getXimpl(m735getTopLeftCornerRadiuskKHJgLs);
                    float f3 = f2;
                    if (m693getXimpl >= f3) {
                        Brush brush2 = brush;
                        long j3 = j;
                        long j4 = j2;
                        m83shrinkKibmq7A = BorderKt.m83shrinkKibmq7A(m735getTopLeftCornerRadiuskKHJgLs, f3);
                        DrawScope.CC.m1064drawRoundRectZuiqVtQ$default(onDrawWithContent, brush2, j3, j4, m83shrinkKibmq7A, 0.0f, stroke, null, 0, 208, null);
                        return;
                    }
                    float f4 = f;
                    float m745getWidthimpl = Size.m745getWidthimpl(onDrawWithContent.mo1040getSizeNHjbRc()) - f;
                    float m743getHeightimpl = Size.m743getHeightimpl(onDrawWithContent.mo1040getSizeNHjbRc()) - f;
                    int m839getDifferencertfAjoo = ClipOp.Companion.m839getDifferencertfAjoo();
                    Brush brush3 = brush;
                    long j5 = m735getTopLeftCornerRadiuskKHJgLs;
                    DrawContext drawContext = onDrawWithContent.getDrawContext();
                    long mo1044getSizeNHjbRc = drawContext.mo1044getSizeNHjbRc();
                    drawContext.getCanvas().save();
                    drawContext.getTransform().mo1047clipRectN_I0leg(f4, f4, m745getWidthimpl, m743getHeightimpl, m839getDifferencertfAjoo);
                    DrawScope.CC.m1064drawRoundRectZuiqVtQ$default(onDrawWithContent, brush3, 0L, 0L, j5, 0.0f, null, null, 0, 246, null);
                    drawContext.getCanvas().restore();
                    drawContext.mo1045setSizeuvyYCjk(mo1044getSizeNHjbRc);
                }
            });
        }
        if (this.borderCache == null) {
            this.borderCache = new BorderCache(null, null, null, null, 15, null);
        }
        BorderCache borderCache = this.borderCache;
        Intrinsics.checkNotNull(borderCache);
        createRoundRectPath = BorderKt.createRoundRectPath(borderCache.obtainPath(), rounded.getRoundRect(), f, z);
        return cacheDrawScope.onDrawWithContent(new Function1() { // from class: androidx.compose.foundation.BorderModifierNode$drawRoundRectBorder$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((ContentDrawScope) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(ContentDrawScope onDrawWithContent) {
                Intrinsics.checkNotNullParameter(onDrawWithContent, "$this$onDrawWithContent");
                onDrawWithContent.drawContent();
                DrawScope.CC.m1061drawPathGBMwjPU$default(onDrawWithContent, Path.this, brush, 0.0f, null, null, 0, 60, null);
            }
        });
    }
}
