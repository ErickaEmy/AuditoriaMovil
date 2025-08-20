package wz;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Shader;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.graphics.drawable.shapes.Shape;
import android.util.AttributeSet;
import android.widget.ProgressBar;
/* loaded from: classes.dex */
public class wz {

    /* renamed from: zn  reason: collision with root package name */
    public static final int[] f14828zn = {16843067, 16843068};

    /* renamed from: n3  reason: collision with root package name */
    public Bitmap f14829n3;
    public final ProgressBar y;

    public wz(ProgressBar progressBar) {
        this.y = progressBar;
    }

    public final Drawable gv(Drawable drawable, boolean z2) {
        boolean z3;
        if (drawable instanceof ej.fb) {
            ej.fb fbVar = (ej.fb) drawable;
            Drawable y = fbVar.y();
            if (y != null) {
                fbVar.n3(gv(y, z2));
            }
        } else if (drawable instanceof LayerDrawable) {
            LayerDrawable layerDrawable = (LayerDrawable) drawable;
            int numberOfLayers = layerDrawable.getNumberOfLayers();
            Drawable[] drawableArr = new Drawable[numberOfLayers];
            for (int i = 0; i < numberOfLayers; i++) {
                int id = layerDrawable.getId(i);
                Drawable drawable2 = layerDrawable.getDrawable(i);
                if (id != 16908301 && id != 16908303) {
                    z3 = false;
                } else {
                    z3 = true;
                }
                drawableArr[i] = gv(drawable2, z3);
            }
            LayerDrawable layerDrawable2 = new LayerDrawable(drawableArr);
            for (int i5 = 0; i5 < numberOfLayers; i5++) {
                layerDrawable2.setId(i5, layerDrawable.getId(i5));
            }
            return layerDrawable2;
        } else if (drawable instanceof BitmapDrawable) {
            BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
            Bitmap bitmap = bitmapDrawable.getBitmap();
            if (this.f14829n3 == null) {
                this.f14829n3 = bitmap;
            }
            ShapeDrawable shapeDrawable = new ShapeDrawable(y());
            shapeDrawable.getPaint().setShader(new BitmapShader(bitmap, Shader.TileMode.REPEAT, Shader.TileMode.CLAMP));
            shapeDrawable.getPaint().setColorFilter(bitmapDrawable.getPaint().getColorFilter());
            if (z2) {
                return new ClipDrawable(shapeDrawable, 3, 1);
            }
            return shapeDrawable;
        }
        return drawable;
    }

    public Bitmap n3() {
        return this.f14829n3;
    }

    public final Drawable v(Drawable drawable) {
        if (drawable instanceof AnimationDrawable) {
            AnimationDrawable animationDrawable = (AnimationDrawable) drawable;
            int numberOfFrames = animationDrawable.getNumberOfFrames();
            AnimationDrawable animationDrawable2 = new AnimationDrawable();
            animationDrawable2.setOneShot(animationDrawable.isOneShot());
            for (int i = 0; i < numberOfFrames; i++) {
                Drawable gv2 = gv(animationDrawable.getFrame(i), true);
                gv2.setLevel(10000);
                animationDrawable2.addFrame(gv2, animationDrawable.getDuration(i));
            }
            animationDrawable2.setLevel(10000);
            return animationDrawable2;
        }
        return drawable;
    }

    public final Shape y() {
        return new RoundRectShape(new float[]{5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f}, null, null);
    }

    public void zn(AttributeSet attributeSet, int i) {
        hw x42 = hw.x4(this.y.getContext(), attributeSet, f14828zn, i, 0);
        Drawable s2 = x42.s(0);
        if (s2 != null) {
            this.y.setIndeterminateDrawable(v(s2));
        }
        Drawable s3 = x42.s(1);
        if (s3 != null) {
            this.y.setProgressDrawable(gv(s3, false));
        }
        x42.i4();
    }
}
