package pz;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.view.animation.Animation;
import android.widget.ImageView;
import androidx.swiperefreshlayout.R$styleable;
import hw.i4;
/* loaded from: classes.dex */
public class y extends ImageView {

    /* renamed from: fb  reason: collision with root package name */
    public int f12689fb;

    /* renamed from: v  reason: collision with root package name */
    public int f12690v;
    public Animation.AnimationListener y;

    /* renamed from: pz.y$y  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0183y extends OvalShape {

        /* renamed from: fb  reason: collision with root package name */
        public y f12691fb;

        /* renamed from: v  reason: collision with root package name */
        public int f12692v;
        public Paint y = new Paint();

        public C0183y(y yVar, int i) {
            this.f12691fb = yVar;
            this.f12692v = i;
            n3((int) rect().width());
        }

        @Override // android.graphics.drawable.shapes.OvalShape, android.graphics.drawable.shapes.RectShape, android.graphics.drawable.shapes.Shape
        public void draw(Canvas canvas, Paint paint) {
            int width;
            float width2 = this.f12691fb.getWidth() / 2;
            float height = this.f12691fb.getHeight() / 2;
            canvas.drawCircle(width2, height, width2, this.y);
            canvas.drawCircle(width2, height, width - this.f12692v, paint);
        }

        public final void n3(int i) {
            float f4 = i / 2;
            this.y.setShader(new RadialGradient(f4, f4, this.f12692v, new int[]{1023410176, 0}, (float[]) null, Shader.TileMode.CLAMP));
        }

        @Override // android.graphics.drawable.shapes.RectShape, android.graphics.drawable.shapes.Shape
        public void onResize(float f4, float f6) {
            super.onResize(f4, f6);
            n3((int) f4);
        }
    }

    public y(Context context) {
        super(context);
        ShapeDrawable shapeDrawable;
        float f4 = getContext().getResources().getDisplayMetrics().density;
        int i = (int) (1.75f * f4);
        int i5 = (int) (0.0f * f4);
        this.f12690v = (int) (3.5f * f4);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(R$styleable.f3385a);
        this.f12689fb = obtainStyledAttributes.getColor(R$styleable.f3386fb, -328966);
        obtainStyledAttributes.recycle();
        if (y()) {
            shapeDrawable = new ShapeDrawable(new OvalShape());
            i4.pz(this, f4 * 4.0f);
        } else {
            ShapeDrawable shapeDrawable2 = new ShapeDrawable(new C0183y(this, this.f12690v));
            setLayerType(1, shapeDrawable2.getPaint());
            shapeDrawable2.getPaint().setShadowLayer(this.f12690v, i5, i, 503316480);
            int i6 = this.f12690v;
            setPadding(i6, i6, i6, i6);
            shapeDrawable = shapeDrawable2;
        }
        shapeDrawable.getPaint().setColor(this.f12689fb);
        i4.u0(this, shapeDrawable);
    }

    public void n3(Animation.AnimationListener animationListener) {
        this.y = animationListener;
    }

    @Override // android.view.View
    public void onAnimationEnd() {
        super.onAnimationEnd();
        Animation.AnimationListener animationListener = this.y;
        if (animationListener != null) {
            animationListener.onAnimationEnd(getAnimation());
        }
    }

    @Override // android.view.View
    public void onAnimationStart() {
        super.onAnimationStart();
        Animation.AnimationListener animationListener = this.y;
        if (animationListener != null) {
            animationListener.onAnimationStart(getAnimation());
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int i, int i5) {
        super.onMeasure(i, i5);
        if (!y()) {
            setMeasuredDimension(getMeasuredWidth() + (this.f12690v * 2), getMeasuredHeight() + (this.f12690v * 2));
        }
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        if (getBackground() instanceof ShapeDrawable) {
            ((ShapeDrawable) getBackground()).getPaint().setColor(i);
            this.f12689fb = i;
        }
    }

    public final boolean y() {
        return true;
    }
}
