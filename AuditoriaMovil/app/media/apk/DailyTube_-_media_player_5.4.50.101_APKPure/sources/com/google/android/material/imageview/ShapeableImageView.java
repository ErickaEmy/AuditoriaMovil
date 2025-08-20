package com.google.android.material.imageview;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import com.google.android.material.R$style;
import hx.f;
import hx.fb;
import hx.t;
import hx.wz;
/* loaded from: classes.dex */
public class ShapeableImageView extends AppCompatImageView implements wz {
    private static final int DEF_STYLE_RES = R$style.w5;
    private final Paint borderPaint;
    private int bottomContentPadding;
    private final Paint clearPaint;
    private final RectF destination;
    private int endContentPadding;
    private boolean hasAdjustedPaddingAfterLayoutDirectionResolved;
    private int leftContentPadding;
    private Path maskPath;
    private final RectF maskRect;
    private final Path path;
    private final t pathProvider;
    private int rightContentPadding;
    @Nullable
    private fb shadowDrawable;
    private f shapeAppearanceModel;
    private int startContentPadding;
    @Nullable
    private ColorStateList strokeColor;
    private float strokeWidth;
    private int topContentPadding;

    @TargetApi(21)
    /* loaded from: classes.dex */
    public class y extends ViewOutlineProvider {
        public final Rect y = new Rect();

        public y() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            if (ShapeableImageView.this.shapeAppearanceModel == null) {
                return;
            }
            if (ShapeableImageView.this.shadowDrawable == null) {
                ShapeableImageView.this.shadowDrawable = new fb(ShapeableImageView.this.shapeAppearanceModel);
            }
            ShapeableImageView.this.destination.round(this.y);
            ShapeableImageView.this.shadowDrawable.setBounds(this.y);
            ShapeableImageView.this.shadowDrawable.getOutline(outline);
        }
    }

    public ShapeableImageView(Context context) {
        this(context, null, 0);
    }

    private void drawStroke(Canvas canvas) {
        if (this.strokeColor == null) {
            return;
        }
        this.borderPaint.setStrokeWidth(this.strokeWidth);
        int colorForState = this.strokeColor.getColorForState(getDrawableState(), this.strokeColor.getDefaultColor());
        if (this.strokeWidth > 0.0f && colorForState != 0) {
            this.borderPaint.setColor(colorForState);
            canvas.drawPath(this.path, this.borderPaint);
        }
    }

    private boolean isContentPaddingRelative() {
        if (this.startContentPadding == Integer.MIN_VALUE && this.endContentPadding == Integer.MIN_VALUE) {
            return false;
        }
        return true;
    }

    private boolean isRtl() {
        if (getLayoutDirection() == 1) {
            return true;
        }
        return false;
    }

    private void updateShapeMask(int i, int i5) {
        this.destination.set(getPaddingLeft(), getPaddingTop(), i - getPaddingRight(), i5 - getPaddingBottom());
        this.pathProvider.gv(this.shapeAppearanceModel, 1.0f, this.destination, this.path);
        this.maskPath.rewind();
        this.maskPath.addPath(this.path);
        this.maskRect.set(0.0f, 0.0f, i, i5);
        this.maskPath.addRect(this.maskRect, Path.Direction.CCW);
    }

    public int getContentPaddingBottom() {
        return this.bottomContentPadding;
    }

    public final int getContentPaddingEnd() {
        int i = this.endContentPadding;
        if (i != Integer.MIN_VALUE) {
            return i;
        }
        if (isRtl()) {
            return this.leftContentPadding;
        }
        return this.rightContentPadding;
    }

    public int getContentPaddingLeft() {
        int i;
        int i5;
        if (isContentPaddingRelative()) {
            if (isRtl() && (i5 = this.endContentPadding) != Integer.MIN_VALUE) {
                return i5;
            }
            if (!isRtl() && (i = this.startContentPadding) != Integer.MIN_VALUE) {
                return i;
            }
        }
        return this.leftContentPadding;
    }

    public int getContentPaddingRight() {
        int i;
        int i5;
        if (isContentPaddingRelative()) {
            if (isRtl() && (i5 = this.startContentPadding) != Integer.MIN_VALUE) {
                return i5;
            }
            if (!isRtl() && (i = this.endContentPadding) != Integer.MIN_VALUE) {
                return i;
            }
        }
        return this.rightContentPadding;
    }

    public final int getContentPaddingStart() {
        int i = this.startContentPadding;
        if (i != Integer.MIN_VALUE) {
            return i;
        }
        if (isRtl()) {
            return this.rightContentPadding;
        }
        return this.leftContentPadding;
    }

    public int getContentPaddingTop() {
        return this.topContentPadding;
    }

    @Override // android.view.View
    public int getPaddingBottom() {
        return super.getPaddingBottom() - getContentPaddingBottom();
    }

    @Override // android.view.View
    public int getPaddingEnd() {
        return super.getPaddingEnd() - getContentPaddingEnd();
    }

    @Override // android.view.View
    public int getPaddingLeft() {
        return super.getPaddingLeft() - getContentPaddingLeft();
    }

    @Override // android.view.View
    public int getPaddingRight() {
        return super.getPaddingRight() - getContentPaddingRight();
    }

    @Override // android.view.View
    public int getPaddingStart() {
        return super.getPaddingStart() - getContentPaddingStart();
    }

    @Override // android.view.View
    public int getPaddingTop() {
        return super.getPaddingTop() - getContentPaddingTop();
    }

    @NonNull
    public f getShapeAppearanceModel() {
        return this.shapeAppearanceModel;
    }

    @Nullable
    public ColorStateList getStrokeColor() {
        return this.strokeColor;
    }

    public float getStrokeWidth() {
        return this.strokeWidth;
    }

    @Override // android.widget.ImageView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        setLayerType(2, null);
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        setLayerType(0, null);
        super.onDetachedFromWindow();
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPath(this.maskPath, this.clearPaint);
        drawStroke(canvas);
    }

    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int i, int i5) {
        super.onMeasure(i, i5);
        if (this.hasAdjustedPaddingAfterLayoutDirectionResolved || !isLayoutDirectionResolved()) {
            return;
        }
        this.hasAdjustedPaddingAfterLayoutDirectionResolved = true;
        if (!isPaddingRelative() && !isContentPaddingRelative()) {
            setPadding(super.getPaddingLeft(), super.getPaddingTop(), super.getPaddingRight(), super.getPaddingBottom());
        } else {
            setPaddingRelative(super.getPaddingStart(), super.getPaddingTop(), super.getPaddingEnd(), super.getPaddingBottom());
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i5, int i6, int i8) {
        super.onSizeChanged(i, i5, i6, i8);
        updateShapeMask(i, i5);
    }

    public void setContentPadding(int i, int i5, int i6, int i8) {
        this.startContentPadding = Integer.MIN_VALUE;
        this.endContentPadding = Integer.MIN_VALUE;
        super.setPadding((super.getPaddingLeft() - this.leftContentPadding) + i, (super.getPaddingTop() - this.topContentPadding) + i5, (super.getPaddingRight() - this.rightContentPadding) + i6, (super.getPaddingBottom() - this.bottomContentPadding) + i8);
        this.leftContentPadding = i;
        this.topContentPadding = i5;
        this.rightContentPadding = i6;
        this.bottomContentPadding = i8;
    }

    public void setContentPaddingRelative(int i, int i5, int i6, int i8) {
        int i10;
        super.setPaddingRelative((super.getPaddingStart() - getContentPaddingStart()) + i, (super.getPaddingTop() - this.topContentPadding) + i5, (super.getPaddingEnd() - getContentPaddingEnd()) + i6, (super.getPaddingBottom() - this.bottomContentPadding) + i8);
        if (isRtl()) {
            i10 = i6;
        } else {
            i10 = i;
        }
        this.leftContentPadding = i10;
        this.topContentPadding = i5;
        if (!isRtl()) {
            i = i6;
        }
        this.rightContentPadding = i;
        this.bottomContentPadding = i8;
    }

    @Override // android.view.View
    public void setPadding(int i, int i5, int i6, int i8) {
        super.setPadding(i + getContentPaddingLeft(), i5 + getContentPaddingTop(), i6 + getContentPaddingRight(), i8 + getContentPaddingBottom());
    }

    @Override // android.view.View
    public void setPaddingRelative(int i, int i5, int i6, int i8) {
        super.setPaddingRelative(i + getContentPaddingStart(), i5 + getContentPaddingTop(), i6 + getContentPaddingEnd(), i8 + getContentPaddingBottom());
    }

    @Override // hx.wz
    public void setShapeAppearanceModel(@NonNull f fVar) {
        this.shapeAppearanceModel = fVar;
        fb fbVar = this.shadowDrawable;
        if (fbVar != null) {
            fbVar.setShapeAppearanceModel(fVar);
        }
        updateShapeMask(getWidth(), getHeight());
        invalidate();
        invalidateOutline();
    }

    public void setStrokeColor(@Nullable ColorStateList colorStateList) {
        this.strokeColor = colorStateList;
        invalidate();
    }

    public void setStrokeColorResource(int i) {
        setStrokeColor(c5.y.zn(getContext(), i));
    }

    public void setStrokeWidth(float f4) {
        if (this.strokeWidth != f4) {
            this.strokeWidth = f4;
            invalidate();
        }
    }

    public void setStrokeWidthResource(int i) {
        setStrokeWidth(getResources().getDimensionPixelSize(i));
    }

    public ShapeableImageView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public ShapeableImageView(android.content.Context r7, @androidx.annotation.Nullable android.util.AttributeSet r8, int r9) {
        /*
            r6 = this;
            int r0 = com.google.android.material.imageview.ShapeableImageView.DEF_STYLE_RES
            android.content.Context r7 = c0.y.zn(r7, r8, r9, r0)
            r6.<init>(r7, r8, r9)
            hx.t r7 = hx.t.f()
            r6.pathProvider = r7
            android.graphics.Path r7 = new android.graphics.Path
            r7.<init>()
            r6.path = r7
            r7 = 0
            r6.hasAdjustedPaddingAfterLayoutDirectionResolved = r7
            android.content.Context r1 = r6.getContext()
            android.graphics.Paint r2 = new android.graphics.Paint
            r2.<init>()
            r6.clearPaint = r2
            r3 = 1
            r2.setAntiAlias(r3)
            r4 = -1
            r2.setColor(r4)
            android.graphics.PorterDuffXfermode r4 = new android.graphics.PorterDuffXfermode
            android.graphics.PorterDuff$Mode r5 = android.graphics.PorterDuff.Mode.DST_OUT
            r4.<init>(r5)
            r2.setXfermode(r4)
            android.graphics.RectF r2 = new android.graphics.RectF
            r2.<init>()
            r6.destination = r2
            android.graphics.RectF r2 = new android.graphics.RectF
            r2.<init>()
            r6.maskRect = r2
            android.graphics.Path r2 = new android.graphics.Path
            r2.<init>()
            r6.maskPath = r2
            int[] r2 = com.google.android.material.R$styleable.f5227n5
            android.content.res.TypedArray r2 = r1.obtainStyledAttributes(r8, r2, r9, r0)
            int r4 = com.google.android.material.R$styleable.f5213lw
            android.content.res.ColorStateList r4 = pv.zn.y(r1, r2, r4)
            r6.strokeColor = r4
            int r4 = com.google.android.material.R$styleable.f5263r4
            int r4 = r2.getDimensionPixelSize(r4, r7)
            float r4 = (float) r4
            r6.strokeWidth = r4
            int r4 = com.google.android.material.R$styleable.f5153ea
            int r7 = r2.getDimensionPixelSize(r4, r7)
            r6.leftContentPadding = r7
            r6.topContentPadding = r7
            r6.rightContentPadding = r7
            r6.bottomContentPadding = r7
            int r4 = com.google.android.material.R$styleable.f5247p7
            int r4 = r2.getDimensionPixelSize(r4, r7)
            r6.leftContentPadding = r4
            int r4 = com.google.android.material.R$styleable.f5176h4
            int r4 = r2.getDimensionPixelSize(r4, r7)
            r6.topContentPadding = r4
            int r4 = com.google.android.material.R$styleable.f5329zr
            int r4 = r2.getDimensionPixelSize(r4, r7)
            r6.rightContentPadding = r4
            int r4 = com.google.android.material.R$styleable.f5117af
            int r7 = r2.getDimensionPixelSize(r4, r7)
            r6.bottomContentPadding = r7
            int r7 = com.google.android.material.R$styleable.f5146dq
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            int r7 = r2.getDimensionPixelSize(r7, r4)
            r6.startContentPadding = r7
            int r7 = com.google.android.material.R$styleable.f5195je
            int r7 = r2.getDimensionPixelSize(r7, r4)
            r6.endContentPadding = r7
            r2.recycle()
            android.graphics.Paint r7 = new android.graphics.Paint
            r7.<init>()
            r6.borderPaint = r7
            android.graphics.Paint$Style r2 = android.graphics.Paint.Style.STROKE
            r7.setStyle(r2)
            r7.setAntiAlias(r3)
            hx.f$n3 r7 = hx.f.v(r1, r8, r9, r0)
            hx.f r7 = r7.tl()
            r6.shapeAppearanceModel = r7
            com.google.android.material.imageview.ShapeableImageView$y r7 = new com.google.android.material.imageview.ShapeableImageView$y
            r7.<init>()
            r6.setOutlineProvider(r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.imageview.ShapeableImageView.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }
}
