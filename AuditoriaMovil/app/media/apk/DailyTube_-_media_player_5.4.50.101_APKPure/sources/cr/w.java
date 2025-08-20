package cr;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
/* loaded from: classes.dex */
public class w {

    /* renamed from: n3  reason: collision with root package name */
    public static final boolean f6811n3;
    public static final boolean y;

    /* renamed from: zn  reason: collision with root package name */
    public static final boolean f6812zn;

    static {
        int i = Build.VERSION.SDK_INT;
        boolean z2 = true;
        y = true;
        f6811n3 = true;
        if (i < 28) {
            z2 = false;
        }
        f6812zn = z2;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0088  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.graphics.Bitmap n3(android.view.View r8, android.graphics.Matrix r9, android.graphics.RectF r10, android.view.ViewGroup r11) {
        /*
            boolean r0 = cr.w.y
            r1 = 0
            if (r0 == 0) goto L13
            boolean r0 = r8.isAttachedToWindow()
            r0 = r0 ^ 1
            if (r11 != 0) goto Le
            goto L14
        Le:
            boolean r2 = r11.isAttachedToWindow()
            goto L15
        L13:
            r0 = 0
        L14:
            r2 = 0
        L15:
            boolean r3 = cr.w.f6811n3
            r4 = 0
            if (r3 == 0) goto L31
            if (r0 == 0) goto L31
            if (r2 != 0) goto L1f
            return r4
        L1f:
            android.view.ViewParent r1 = r8.getParent()
            android.view.ViewGroup r1 = (android.view.ViewGroup) r1
            int r2 = r1.indexOfChild(r8)
            android.view.ViewGroupOverlay r5 = r11.getOverlay()
            r5.add(r8)
            goto L33
        L31:
            r1 = r4
            r2 = 0
        L33:
            float r5 = r10.width()
            int r5 = java.lang.Math.round(r5)
            float r6 = r10.height()
            int r6 = java.lang.Math.round(r6)
            if (r5 <= 0) goto L99
            if (r6 <= 0) goto L99
            int r4 = r5 * r6
            float r4 = (float) r4
            r7 = 1233125376(0x49800000, float:1048576.0)
            float r7 = r7 / r4
            r4 = 1065353216(0x3f800000, float:1.0)
            float r4 = java.lang.Math.min(r4, r7)
            float r5 = (float) r5
            float r5 = r5 * r4
            int r5 = java.lang.Math.round(r5)
            float r6 = (float) r6
            float r6 = r6 * r4
            int r6 = java.lang.Math.round(r6)
            float r7 = r10.left
            float r7 = -r7
            float r10 = r10.top
            float r10 = -r10
            r9.postTranslate(r7, r10)
            r9.postScale(r4, r4)
            boolean r10 = cr.w.f6812zn
            if (r10 == 0) goto L88
            android.graphics.Picture r10 = new android.graphics.Picture
            r10.<init>()
            android.graphics.Canvas r4 = r10.beginRecording(r5, r6)
            r4.concat(r9)
            r8.draw(r4)
            r10.endRecording()
            android.graphics.Bitmap r4 = android.graphics.Bitmap.createBitmap(r10)
            goto L99
        L88:
            android.graphics.Bitmap$Config r10 = android.graphics.Bitmap.Config.ARGB_8888
            android.graphics.Bitmap r4 = android.graphics.Bitmap.createBitmap(r5, r6, r10)
            android.graphics.Canvas r10 = new android.graphics.Canvas
            r10.<init>(r4)
            r10.concat(r9)
            r8.draw(r10)
        L99:
            if (r3 == 0) goto La7
            if (r0 == 0) goto La7
            android.view.ViewGroupOverlay r9 = r11.getOverlay()
            r9.remove(r8)
            r1.addView(r8, r2)
        La7:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: cr.w.n3(android.view.View, android.graphics.Matrix, android.graphics.RectF, android.view.ViewGroup):android.graphics.Bitmap");
    }

    public static View y(ViewGroup viewGroup, View view, View view2) {
        Matrix matrix = new Matrix();
        matrix.setTranslate(-view2.getScrollX(), -view2.getScrollY());
        f3.c5(view, matrix);
        f3.i9(viewGroup, matrix);
        RectF rectF = new RectF(0.0f, 0.0f, view.getWidth(), view.getHeight());
        matrix.mapRect(rectF);
        int round = Math.round(rectF.left);
        int round2 = Math.round(rectF.top);
        int round3 = Math.round(rectF.right);
        int round4 = Math.round(rectF.bottom);
        ImageView imageView = new ImageView(view.getContext());
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        Bitmap n32 = n3(view, matrix, rectF, viewGroup);
        if (n32 != null) {
            imageView.setImageBitmap(n32);
        }
        imageView.measure(View.MeasureSpec.makeMeasureSpec(round3 - round, 1073741824), View.MeasureSpec.makeMeasureSpec(round4 - round2, 1073741824));
        imageView.layout(round, round2, round3, round4);
        return imageView;
    }

    public static Animator zn(Animator animator, Animator animator2) {
        if (animator == null) {
            return animator2;
        }
        if (animator2 == null) {
            return animator;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(animator, animator2);
        return animatorSet;
    }
}
