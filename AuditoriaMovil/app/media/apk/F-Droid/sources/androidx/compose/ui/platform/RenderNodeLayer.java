package androidx.compose.ui.platform;

import android.graphics.Matrix;
import android.os.Build;
import androidx.compose.ui.geometry.MutableRect;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.AndroidCanvas_androidKt;
import androidx.compose.ui.graphics.AndroidPaint_androidKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.CanvasHolder;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Paint;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.graphics.RenderEffect;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.TransformOrigin;
import androidx.compose.ui.node.OwnedLayer;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: RenderNodeLayer.android.kt */
/* loaded from: classes.dex */
public final class RenderNodeLayer implements OwnedLayer {
    public static final Companion Companion = new Companion(null);
    private static final Function2 getMatrix = new Function2() { // from class: androidx.compose.ui.platform.RenderNodeLayer$Companion$getMatrix$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            invoke((DeviceRenderNode) obj, (Matrix) obj2);
            return Unit.INSTANCE;
        }

        public final void invoke(DeviceRenderNode rn, Matrix matrix) {
            Intrinsics.checkNotNullParameter(rn, "rn");
            Intrinsics.checkNotNullParameter(matrix, "matrix");
            rn.getMatrix(matrix);
        }
    };
    private final CanvasHolder canvasHolder;
    private Function1 drawBlock;
    private boolean drawnWithZ;
    private Function0 invalidateParentLayer;
    private boolean isDestroyed;
    private boolean isDirty;
    private final LayerMatrixCache matrixCache;
    private final OutlineResolver outlineResolver;
    private final AndroidComposeView ownerView;
    private final DeviceRenderNode renderNode;
    private Paint softwareLayerPaint;
    private long transformOrigin;

    /* compiled from: RenderNodeLayer.android.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public RenderNodeLayer(AndroidComposeView ownerView, Function1 drawBlock, Function0 invalidateParentLayer) {
        DeviceRenderNode renderNodeApi23;
        Intrinsics.checkNotNullParameter(ownerView, "ownerView");
        Intrinsics.checkNotNullParameter(drawBlock, "drawBlock");
        Intrinsics.checkNotNullParameter(invalidateParentLayer, "invalidateParentLayer");
        this.ownerView = ownerView;
        this.drawBlock = drawBlock;
        this.invalidateParentLayer = invalidateParentLayer;
        this.outlineResolver = new OutlineResolver(ownerView.getDensity());
        this.matrixCache = new LayerMatrixCache(getMatrix);
        this.canvasHolder = new CanvasHolder();
        this.transformOrigin = TransformOrigin.Companion.m992getCenterSzJe1aQ();
        if (Build.VERSION.SDK_INT >= 29) {
            renderNodeApi23 = new RenderNodeApi29(ownerView);
        } else {
            renderNodeApi23 = new RenderNodeApi23(ownerView);
        }
        renderNodeApi23.setHasOverlappingRendering(true);
        this.renderNode = renderNodeApi23;
    }

    private final void setDirty(boolean z) {
        if (z != this.isDirty) {
            this.isDirty = z;
            this.ownerView.notifyLayerIsDirty$ui_release(this, z);
        }
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    /* renamed from: updateLayerProperties-dDxr-wY */
    public void mo1392updateLayerPropertiesdDxrwY(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, long j, Shape shape, boolean z, RenderEffect renderEffect, long j2, long j3, int i, LayoutDirection layoutDirection, Density density) {
        Function0 function0;
        Intrinsics.checkNotNullParameter(shape, "shape");
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        Intrinsics.checkNotNullParameter(density, "density");
        this.transformOrigin = j;
        boolean z2 = false;
        boolean z3 = this.renderNode.getClipToOutline() && !this.outlineResolver.getOutlineClipSupported();
        this.renderNode.setScaleX(f);
        this.renderNode.setScaleY(f2);
        this.renderNode.setAlpha(f3);
        this.renderNode.setTranslationX(f4);
        this.renderNode.setTranslationY(f5);
        this.renderNode.setElevation(f6);
        this.renderNode.setAmbientShadowColor(ColorKt.m871toArgb8_81llA(j2));
        this.renderNode.setSpotShadowColor(ColorKt.m871toArgb8_81llA(j3));
        this.renderNode.setRotationZ(f9);
        this.renderNode.setRotationX(f7);
        this.renderNode.setRotationY(f8);
        this.renderNode.setCameraDistance(f10);
        this.renderNode.setPivotX(TransformOrigin.m987getPivotFractionXimpl(j) * this.renderNode.getWidth());
        this.renderNode.setPivotY(TransformOrigin.m988getPivotFractionYimpl(j) * this.renderNode.getHeight());
        this.renderNode.setClipToOutline(z && shape != RectangleShapeKt.getRectangleShape());
        this.renderNode.setClipToBounds(z && shape == RectangleShapeKt.getRectangleShape());
        this.renderNode.setRenderEffect(renderEffect);
        this.renderNode.mo1435setCompositingStrategyaDBOjCE(i);
        boolean update = this.outlineResolver.update(shape, this.renderNode.getAlpha(), this.renderNode.getClipToOutline(), this.renderNode.getElevation(), layoutDirection, density);
        this.renderNode.setOutline(this.outlineResolver.getOutline());
        if (this.renderNode.getClipToOutline() && !this.outlineResolver.getOutlineClipSupported()) {
            z2 = true;
        }
        if (z3 != z2 || (z2 && update)) {
            invalidate();
        } else {
            triggerRepaint();
        }
        if (!this.drawnWithZ && this.renderNode.getElevation() > 0.0f && (function0 = this.invalidateParentLayer) != null) {
            function0.invoke();
        }
        this.matrixCache.invalidate();
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    /* renamed from: isInLayer-k-4lQ0M */
    public boolean mo1388isInLayerk4lQ0M(long j) {
        float m709getXimpl = Offset.m709getXimpl(j);
        float m710getYimpl = Offset.m710getYimpl(j);
        if (this.renderNode.getClipToBounds()) {
            return 0.0f <= m709getXimpl && m709getXimpl < ((float) this.renderNode.getWidth()) && 0.0f <= m710getYimpl && m710getYimpl < ((float) this.renderNode.getHeight());
        } else if (this.renderNode.getClipToOutline()) {
            return this.outlineResolver.m1455isInOutlinek4lQ0M(j);
        } else {
            return true;
        }
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    /* renamed from: resize-ozmzZPI */
    public void mo1391resizeozmzZPI(long j) {
        int m1951getWidthimpl = IntSize.m1951getWidthimpl(j);
        int m1950getHeightimpl = IntSize.m1950getHeightimpl(j);
        float f = m1951getWidthimpl;
        this.renderNode.setPivotX(TransformOrigin.m987getPivotFractionXimpl(this.transformOrigin) * f);
        float f2 = m1950getHeightimpl;
        this.renderNode.setPivotY(TransformOrigin.m988getPivotFractionYimpl(this.transformOrigin) * f2);
        DeviceRenderNode deviceRenderNode = this.renderNode;
        if (deviceRenderNode.setPosition(deviceRenderNode.getLeft(), this.renderNode.getTop(), this.renderNode.getLeft() + m1951getWidthimpl, this.renderNode.getTop() + m1950getHeightimpl)) {
            this.outlineResolver.m1456updateuvyYCjk(SizeKt.Size(f, f2));
            this.renderNode.setOutline(this.outlineResolver.getOutline());
            invalidate();
            this.matrixCache.invalidate();
        }
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    /* renamed from: move--gyyYBs */
    public void mo1390movegyyYBs(long j) {
        int left = this.renderNode.getLeft();
        int top = this.renderNode.getTop();
        int m1937getXimpl = IntOffset.m1937getXimpl(j);
        int m1938getYimpl = IntOffset.m1938getYimpl(j);
        if (left == m1937getXimpl && top == m1938getYimpl) {
            return;
        }
        if (left != m1937getXimpl) {
            this.renderNode.offsetLeftAndRight(m1937getXimpl - left);
        }
        if (top != m1938getYimpl) {
            this.renderNode.offsetTopAndBottom(m1938getYimpl - top);
        }
        triggerRepaint();
        this.matrixCache.invalidate();
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    public void invalidate() {
        if (this.isDirty || this.isDestroyed) {
            return;
        }
        this.ownerView.invalidate();
        setDirty(true);
    }

    private final void triggerRepaint() {
        if (Build.VERSION.SDK_INT >= 26) {
            WrapperRenderNodeLayerHelperMethods.INSTANCE.onDescendantInvalidated(this.ownerView);
        } else {
            this.ownerView.invalidate();
        }
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    public void drawLayer(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        android.graphics.Canvas nativeCanvas = AndroidCanvas_androidKt.getNativeCanvas(canvas);
        if (nativeCanvas.isHardwareAccelerated()) {
            updateDisplayList();
            boolean z = this.renderNode.getElevation() > 0.0f;
            this.drawnWithZ = z;
            if (z) {
                canvas.enableZ();
            }
            this.renderNode.drawInto(nativeCanvas);
            if (this.drawnWithZ) {
                canvas.disableZ();
                return;
            }
            return;
        }
        float left = this.renderNode.getLeft();
        float top = this.renderNode.getTop();
        float right = this.renderNode.getRight();
        float bottom = this.renderNode.getBottom();
        if (this.renderNode.getAlpha() < 1.0f) {
            Paint paint = this.softwareLayerPaint;
            if (paint == null) {
                paint = AndroidPaint_androidKt.Paint();
                this.softwareLayerPaint = paint;
            }
            paint.setAlpha(this.renderNode.getAlpha());
            nativeCanvas.saveLayer(left, top, right, bottom, paint.asFrameworkPaint());
        } else {
            canvas.save();
        }
        canvas.translate(left, top);
        canvas.mo759concat58bKbWc(this.matrixCache.m1446calculateMatrixGrdbGEg(this.renderNode));
        clipRenderNode(canvas);
        Function1 function1 = this.drawBlock;
        if (function1 != null) {
            function1.invoke(canvas);
        }
        canvas.restore();
        setDirty(false);
    }

    private final void clipRenderNode(Canvas canvas) {
        if (this.renderNode.getClipToOutline() || this.renderNode.getClipToBounds()) {
            this.outlineResolver.clipToOutline(canvas);
        }
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    public void updateDisplayList() {
        if (this.isDirty || !this.renderNode.getHasDisplayList()) {
            setDirty(false);
            Path clipPath = (!this.renderNode.getClipToOutline() || this.outlineResolver.getOutlineClipSupported()) ? null : this.outlineResolver.getClipPath();
            Function1 function1 = this.drawBlock;
            if (function1 != null) {
                this.renderNode.record(this.canvasHolder, clipPath, function1);
            }
        }
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    public void destroy() {
        if (this.renderNode.getHasDisplayList()) {
            this.renderNode.discardDisplayList();
        }
        this.drawBlock = null;
        this.invalidateParentLayer = null;
        this.isDestroyed = true;
        setDirty(false);
        this.ownerView.requestClearInvalidObservations();
        this.ownerView.recycle$ui_release(this);
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    /* renamed from: mapOffset-8S9VItk */
    public long mo1389mapOffset8S9VItk(long j, boolean z) {
        if (z) {
            float[] m1445calculateInverseMatrixbWbORWo = this.matrixCache.m1445calculateInverseMatrixbWbORWo(this.renderNode);
            return m1445calculateInverseMatrixbWbORWo != null ? androidx.compose.ui.graphics.Matrix.m914mapMKHz9U(m1445calculateInverseMatrixbWbORWo, j) : Offset.Companion.m719getInfiniteF1C5BW0();
        }
        return androidx.compose.ui.graphics.Matrix.m914mapMKHz9U(this.matrixCache.m1446calculateMatrixGrdbGEg(this.renderNode), j);
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    public void mapBounds(MutableRect rect, boolean z) {
        Intrinsics.checkNotNullParameter(rect, "rect");
        if (z) {
            float[] m1445calculateInverseMatrixbWbORWo = this.matrixCache.m1445calculateInverseMatrixbWbORWo(this.renderNode);
            if (m1445calculateInverseMatrixbWbORWo == null) {
                rect.set(0.0f, 0.0f, 0.0f, 0.0f);
                return;
            } else {
                androidx.compose.ui.graphics.Matrix.m915mapimpl(m1445calculateInverseMatrixbWbORWo, rect);
                return;
            }
        }
        androidx.compose.ui.graphics.Matrix.m915mapimpl(this.matrixCache.m1446calculateMatrixGrdbGEg(this.renderNode), rect);
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    public void reuseLayer(Function1 drawBlock, Function0 invalidateParentLayer) {
        Intrinsics.checkNotNullParameter(drawBlock, "drawBlock");
        Intrinsics.checkNotNullParameter(invalidateParentLayer, "invalidateParentLayer");
        setDirty(false);
        this.isDestroyed = false;
        this.drawnWithZ = false;
        this.transformOrigin = TransformOrigin.Companion.m992getCenterSzJe1aQ();
        this.drawBlock = drawBlock;
        this.invalidateParentLayer = invalidateParentLayer;
    }
}
