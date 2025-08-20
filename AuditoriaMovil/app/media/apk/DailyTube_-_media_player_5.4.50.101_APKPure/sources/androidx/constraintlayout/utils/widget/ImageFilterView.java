package androidx.constraintlayout.utils.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Outline;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.R$styleable;
/* loaded from: classes.dex */
public class ImageFilterView extends AppCompatImageView {

    /* renamed from: co  reason: collision with root package name */
    public Drawable[] f1592co;

    /* renamed from: f  reason: collision with root package name */
    public float f1593f;

    /* renamed from: fb  reason: collision with root package name */
    public float f1594fb;

    /* renamed from: p  reason: collision with root package name */
    public RectF f1595p;

    /* renamed from: s  reason: collision with root package name */
    public float f1596s;

    /* renamed from: t  reason: collision with root package name */
    public Path f1597t;

    /* renamed from: v  reason: collision with root package name */
    public boolean f1598v;

    /* renamed from: w  reason: collision with root package name */
    public ViewOutlineProvider f1599w;
    public zn y;

    /* renamed from: z  reason: collision with root package name */
    public LayerDrawable f1600z;

    /* loaded from: classes.dex */
    public class n3 extends ViewOutlineProvider {
        public n3() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            outline.setRoundRect(0, 0, ImageFilterView.this.getWidth(), ImageFilterView.this.getHeight(), ImageFilterView.this.f1593f);
        }
    }

    /* loaded from: classes.dex */
    public class y extends ViewOutlineProvider {
        public y() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            int width = ImageFilterView.this.getWidth();
            int height = ImageFilterView.this.getHeight();
            outline.setRoundRect(0, 0, width, height, (Math.min(width, height) * ImageFilterView.this.f1596s) / 2.0f);
        }
    }

    /* loaded from: classes.dex */
    public static class zn {
        public float[] y = new float[20];

        /* renamed from: n3  reason: collision with root package name */
        public ColorMatrix f1604n3 = new ColorMatrix();

        /* renamed from: zn  reason: collision with root package name */
        public ColorMatrix f1606zn = new ColorMatrix();

        /* renamed from: gv  reason: collision with root package name */
        public float f1603gv = 1.0f;

        /* renamed from: v  reason: collision with root package name */
        public float f1605v = 1.0f;

        /* renamed from: a  reason: collision with root package name */
        public float f1601a = 1.0f;

        /* renamed from: fb  reason: collision with root package name */
        public float f1602fb = 1.0f;

        public final void gv(float f4) {
            float log;
            float f6;
            float f9;
            if (f4 <= 0.0f) {
                f4 = 0.01f;
            }
            float f10 = (5000.0f / f4) / 100.0f;
            if (f10 > 66.0f) {
                double d2 = f10 - 60.0f;
                f6 = ((float) Math.pow(d2, -0.13320475816726685d)) * 329.69873f;
                log = ((float) Math.pow(d2, 0.07551484555006027d)) * 288.12216f;
            } else {
                log = (((float) Math.log(f10)) * 99.4708f) - 161.11957f;
                f6 = 255.0f;
            }
            if (f10 < 66.0f) {
                if (f10 > 19.0f) {
                    f9 = (((float) Math.log(f10 - 10.0f)) * 138.51773f) - 305.0448f;
                } else {
                    f9 = 0.0f;
                }
            } else {
                f9 = 255.0f;
            }
            float min = Math.min(255.0f, Math.max(f6, 0.0f));
            float min2 = Math.min(255.0f, Math.max(log, 0.0f));
            float min3 = Math.min(255.0f, Math.max(f9, 0.0f));
            float min4 = Math.min(255.0f, Math.max(255.0f, 0.0f));
            float min5 = Math.min(255.0f, Math.max((((float) Math.log(50.0f)) * 99.4708f) - 161.11957f, 0.0f));
            float min6 = min3 / Math.min(255.0f, Math.max((((float) Math.log(40.0f)) * 138.51773f) - 305.0448f, 0.0f));
            float[] fArr = this.y;
            fArr[0] = min / min4;
            fArr[1] = 0.0f;
            fArr[2] = 0.0f;
            fArr[3] = 0.0f;
            fArr[4] = 0.0f;
            fArr[5] = 0.0f;
            fArr[6] = min2 / min5;
            fArr[7] = 0.0f;
            fArr[8] = 0.0f;
            fArr[9] = 0.0f;
            fArr[10] = 0.0f;
            fArr[11] = 0.0f;
            fArr[12] = min6;
            fArr[13] = 0.0f;
            fArr[14] = 0.0f;
            fArr[15] = 0.0f;
            fArr[16] = 0.0f;
            fArr[17] = 0.0f;
            fArr[18] = 1.0f;
            fArr[19] = 0.0f;
        }

        public final void n3(float f4) {
            float f6 = 1.0f - f4;
            float f9 = 0.2999f * f6;
            float f10 = 0.587f * f6;
            float f11 = f6 * 0.114f;
            float[] fArr = this.y;
            fArr[0] = f9 + f4;
            fArr[1] = f10;
            fArr[2] = f11;
            fArr[3] = 0.0f;
            fArr[4] = 0.0f;
            fArr[5] = f9;
            fArr[6] = f10 + f4;
            fArr[7] = f11;
            fArr[8] = 0.0f;
            fArr[9] = 0.0f;
            fArr[10] = f9;
            fArr[11] = f10;
            fArr[12] = f11 + f4;
            fArr[13] = 0.0f;
            fArr[14] = 0.0f;
            fArr[15] = 0.0f;
            fArr[16] = 0.0f;
            fArr[17] = 0.0f;
            fArr[18] = 1.0f;
            fArr[19] = 0.0f;
        }

        public final void y(float f4) {
            float[] fArr = this.y;
            fArr[0] = f4;
            fArr[1] = 0.0f;
            fArr[2] = 0.0f;
            fArr[3] = 0.0f;
            fArr[4] = 0.0f;
            fArr[5] = 0.0f;
            fArr[6] = f4;
            fArr[7] = 0.0f;
            fArr[8] = 0.0f;
            fArr[9] = 0.0f;
            fArr[10] = 0.0f;
            fArr[11] = 0.0f;
            fArr[12] = f4;
            fArr[13] = 0.0f;
            fArr[14] = 0.0f;
            fArr[15] = 0.0f;
            fArr[16] = 0.0f;
            fArr[17] = 0.0f;
            fArr[18] = 1.0f;
            fArr[19] = 0.0f;
        }

        public void zn(ImageView imageView) {
            boolean z2;
            this.f1604n3.reset();
            float f4 = this.f1605v;
            boolean z3 = true;
            if (f4 != 1.0f) {
                n3(f4);
                this.f1604n3.set(this.y);
                z2 = true;
            } else {
                z2 = false;
            }
            float f6 = this.f1601a;
            if (f6 != 1.0f) {
                this.f1606zn.setScale(f6, f6, f6, 1.0f);
                this.f1604n3.postConcat(this.f1606zn);
                z2 = true;
            }
            float f9 = this.f1602fb;
            if (f9 != 1.0f) {
                gv(f9);
                this.f1606zn.set(this.y);
                this.f1604n3.postConcat(this.f1606zn);
                z2 = true;
            }
            float f10 = this.f1603gv;
            if (f10 != 1.0f) {
                y(f10);
                this.f1606zn.set(this.y);
                this.f1604n3.postConcat(this.f1606zn);
            } else {
                z3 = z2;
            }
            if (z3) {
                imageView.setColorFilter(new ColorMatrixColorFilter(this.f1604n3));
            } else {
                imageView.clearColorFilter();
            }
        }
    }

    public ImageFilterView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.y = new zn();
        this.f1598v = true;
        this.f1594fb = 0.0f;
        this.f1596s = 0.0f;
        this.f1593f = Float.NaN;
        v(context, attributeSet);
    }

    private void setOverlay(boolean z2) {
        this.f1598v = z2;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
    }

    public float getBrightness() {
        return this.y.f1603gv;
    }

    public float getContrast() {
        return this.y.f1601a;
    }

    public float getCrossfade() {
        return this.f1594fb;
    }

    public float getRound() {
        return this.f1593f;
    }

    public float getRoundPercent() {
        return this.f1596s;
    }

    public float getSaturation() {
        return this.y.f1605v;
    }

    public float getWarmth() {
        return this.y.f1602fb;
    }

    public void setBrightness(float f4) {
        zn znVar = this.y;
        znVar.f1603gv = f4;
        znVar.zn(this);
    }

    public void setContrast(float f4) {
        zn znVar = this.y;
        znVar.f1601a = f4;
        znVar.zn(this);
    }

    public void setCrossfade(float f4) {
        this.f1594fb = f4;
        if (this.f1592co != null) {
            if (!this.f1598v) {
                this.f1600z.getDrawable(0).setAlpha((int) ((1.0f - this.f1594fb) * 255.0f));
            }
            this.f1600z.getDrawable(1).setAlpha((int) (this.f1594fb * 255.0f));
            super.setImageDrawable(this.f1600z);
        }
    }

    public void setRound(float f4) {
        boolean z2;
        if (Float.isNaN(f4)) {
            this.f1593f = f4;
            float f6 = this.f1596s;
            this.f1596s = -1.0f;
            setRoundPercent(f6);
            return;
        }
        if (this.f1593f != f4) {
            z2 = true;
        } else {
            z2 = false;
        }
        this.f1593f = f4;
        if (f4 != 0.0f) {
            if (this.f1597t == null) {
                this.f1597t = new Path();
            }
            if (this.f1595p == null) {
                this.f1595p = new RectF();
            }
            if (this.f1599w == null) {
                n3 n3Var = new n3();
                this.f1599w = n3Var;
                setOutlineProvider(n3Var);
            }
            setClipToOutline(true);
            this.f1595p.set(0.0f, 0.0f, getWidth(), getHeight());
            this.f1597t.reset();
            Path path = this.f1597t;
            RectF rectF = this.f1595p;
            float f9 = this.f1593f;
            path.addRoundRect(rectF, f9, f9, Path.Direction.CW);
        } else {
            setClipToOutline(false);
        }
        if (z2) {
            invalidateOutline();
        }
    }

    public void setRoundPercent(float f4) {
        boolean z2;
        if (this.f1596s != f4) {
            z2 = true;
        } else {
            z2 = false;
        }
        this.f1596s = f4;
        if (f4 != 0.0f) {
            if (this.f1597t == null) {
                this.f1597t = new Path();
            }
            if (this.f1595p == null) {
                this.f1595p = new RectF();
            }
            if (this.f1599w == null) {
                y yVar = new y();
                this.f1599w = yVar;
                setOutlineProvider(yVar);
            }
            setClipToOutline(true);
            int width = getWidth();
            int height = getHeight();
            float min = (Math.min(width, height) * this.f1596s) / 2.0f;
            this.f1595p.set(0.0f, 0.0f, width, height);
            this.f1597t.reset();
            this.f1597t.addRoundRect(this.f1595p, min, min, Path.Direction.CW);
        } else {
            setClipToOutline(false);
        }
        if (z2) {
            invalidateOutline();
        }
    }

    public void setSaturation(float f4) {
        zn znVar = this.y;
        znVar.f1605v = f4;
        znVar.zn(this);
    }

    public void setWarmth(float f4) {
        zn znVar = this.y;
        znVar.f1602fb = f4;
        znVar.zn(this);
    }

    public final void v(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.gm);
            int indexCount = obtainStyledAttributes.getIndexCount();
            Drawable drawable = obtainStyledAttributes.getDrawable(R$styleable.jf);
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == R$styleable.mf) {
                    this.f1594fb = obtainStyledAttributes.getFloat(index, 0.0f);
                } else if (index == R$styleable.ni) {
                    setWarmth(obtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == R$styleable.ik) {
                    setSaturation(obtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == R$styleable.x2) {
                    setContrast(obtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == R$styleable.w5) {
                    setRound(obtainStyledAttributes.getDimension(index, 0.0f));
                } else if (index == R$styleable.p4) {
                    setRoundPercent(obtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == R$styleable.fm) {
                    setOverlay(obtainStyledAttributes.getBoolean(index, this.f1598v));
                }
            }
            obtainStyledAttributes.recycle();
            if (drawable != null) {
                Drawable[] drawableArr = new Drawable[2];
                this.f1592co = drawableArr;
                drawableArr[0] = getDrawable();
                this.f1592co[1] = drawable;
                LayerDrawable layerDrawable = new LayerDrawable(this.f1592co);
                this.f1600z = layerDrawable;
                layerDrawable.getDrawable(1).setAlpha((int) (this.f1594fb * 255.0f));
                super.setImageDrawable(this.f1600z);
            }
        }
    }
}
