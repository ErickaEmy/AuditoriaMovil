package mn;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import v5.j5;
/* loaded from: classes.dex */
public final class f {

    /* renamed from: a  reason: collision with root package name */
    public final TextPaint f11474a;

    /* renamed from: a8  reason: collision with root package name */
    public Rect f11475a8;

    /* renamed from: c  reason: collision with root package name */
    public float f11476c;
    @Nullable

    /* renamed from: c5  reason: collision with root package name */
    public CharSequence f11477c5;

    /* renamed from: co  reason: collision with root package name */
    public int f11478co;

    /* renamed from: d  reason: collision with root package name */
    public StaticLayout f11479d;

    /* renamed from: d0  reason: collision with root package name */
    public int f11480d0;

    /* renamed from: ej  reason: collision with root package name */
    public int f11481ej;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public Bitmap f11482f;

    /* renamed from: f3  reason: collision with root package name */
    public float f11483f3;

    /* renamed from: fb  reason: collision with root package name */
    public final Paint f11484fb;

    /* renamed from: fh  reason: collision with root package name */
    public int f11485fh;

    /* renamed from: gv  reason: collision with root package name */
    public final float f11486gv;

    /* renamed from: i4  reason: collision with root package name */
    public int f11487i4;
    @Nullable

    /* renamed from: i9  reason: collision with root package name */
    public Layout.Alignment f11488i9;

    /* renamed from: mg  reason: collision with root package name */
    public int f11489mg;

    /* renamed from: mt  reason: collision with root package name */
    public float f11490mt;

    /* renamed from: n  reason: collision with root package name */
    public float f11491n;

    /* renamed from: n3  reason: collision with root package name */
    public final float f11492n3;

    /* renamed from: p  reason: collision with root package name */
    public float f11493p;

    /* renamed from: r  reason: collision with root package name */
    public int f11494r;

    /* renamed from: rz  reason: collision with root package name */
    public int f11495rz;

    /* renamed from: s  reason: collision with root package name */
    public final Paint f11496s;

    /* renamed from: t  reason: collision with root package name */
    public float f11497t;

    /* renamed from: ta  reason: collision with root package name */
    public StaticLayout f11498ta;

    /* renamed from: tl  reason: collision with root package name */
    public int f11499tl;

    /* renamed from: ud  reason: collision with root package name */
    public int f11500ud;

    /* renamed from: v  reason: collision with root package name */
    public final float f11501v;

    /* renamed from: w  reason: collision with root package name */
    public int f11502w;

    /* renamed from: wz  reason: collision with root package name */
    public int f11503wz;

    /* renamed from: x4  reason: collision with root package name */
    public int f11504x4;

    /* renamed from: xc  reason: collision with root package name */
    public float f11505xc;
    public final float y;

    /* renamed from: z  reason: collision with root package name */
    public int f11506z;

    /* renamed from: z6  reason: collision with root package name */
    public int f11507z6;

    /* renamed from: zn  reason: collision with root package name */
    public final float f11508zn;

    public f(Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(null, new int[]{16843287, 16843288}, 0, 0);
        this.f11501v = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.f11486gv = obtainStyledAttributes.getFloat(1, 1.0f);
        obtainStyledAttributes.recycle();
        float round = Math.round((context.getResources().getDisplayMetrics().densityDpi * 2.0f) / 160.0f);
        this.y = round;
        this.f11492n3 = round;
        this.f11508zn = round;
        TextPaint textPaint = new TextPaint();
        this.f11474a = textPaint;
        textPaint.setAntiAlias(true);
        textPaint.setSubpixelText(true);
        Paint paint = new Paint();
        this.f11484fb = paint;
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
        Paint paint2 = new Paint();
        this.f11496s = paint2;
        paint2.setAntiAlias(true);
        paint2.setFilterBitmap(true);
    }

    public static boolean y(@Nullable CharSequence charSequence, @Nullable CharSequence charSequence2) {
        if (charSequence != charSequence2 && (charSequence == null || !charSequence.equals(charSequence2))) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x005e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a() {
        /*
            r7 = this;
            android.graphics.Bitmap r0 = r7.f11482f
            int r1 = r7.f11495rz
            int r2 = r7.f11480d0
            int r1 = r1 - r2
            int r3 = r7.f11489mg
            int r4 = r7.f11485fh
            int r3 = r3 - r4
            float r2 = (float) r2
            float r1 = (float) r1
            float r5 = r7.f11505xc
            float r5 = r5 * r1
            float r2 = r2 + r5
            float r4 = (float) r4
            float r3 = (float) r3
            float r5 = r7.f11497t
            float r5 = r5 * r3
            float r4 = r4 + r5
            float r5 = r7.f11493p
            float r1 = r1 * r5
            int r1 = java.lang.Math.round(r1)
            float r5 = r7.f11490mt
            r6 = -8388609(0xffffffffff7fffff, float:-3.4028235E38)
            int r6 = (r5 > r6 ? 1 : (r5 == r6 ? 0 : -1))
            if (r6 == 0) goto L32
            float r3 = r3 * r5
            int r0 = java.lang.Math.round(r3)
            goto L44
        L32:
            float r3 = (float) r1
            int r5 = r0.getHeight()
            float r5 = (float) r5
            int r0 = r0.getWidth()
            float r0 = (float) r0
            float r5 = r5 / r0
            float r3 = r3 * r5
            int r0 = java.lang.Math.round(r3)
        L44:
            int r3 = r7.f11502w
            r5 = 1
            r6 = 2
            if (r3 != r6) goto L4d
            float r3 = (float) r1
        L4b:
            float r2 = r2 - r3
            goto L53
        L4d:
            if (r3 != r5) goto L53
            int r3 = r1 / 2
            float r3 = (float) r3
            goto L4b
        L53:
            int r2 = java.lang.Math.round(r2)
            int r3 = r7.f11503wz
            if (r3 != r6) goto L5e
            float r3 = (float) r0
        L5c:
            float r4 = r4 - r3
            goto L64
        L5e:
            if (r3 != r5) goto L64
            int r3 = r0 / 2
            float r3 = (float) r3
            goto L5c
        L64:
            int r3 = java.lang.Math.round(r4)
            android.graphics.Rect r4 = new android.graphics.Rect
            int r1 = r1 + r2
            int r0 = r0 + r3
            r4.<init>(r2, r3, r1, r0)
            r7.f11475a8 = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: mn.f.a():void");
    }

    /* JADX WARN: Removed duplicated region for block: B:71:0x01a5  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x01a9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void fb() {
        /*
            Method dump skipped, instructions count: 496
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: mn.f.fb():void");
    }

    public final void gv(Canvas canvas, boolean z2) {
        if (z2) {
            v(canvas);
            return;
        }
        v5.y.v(this.f11475a8);
        v5.y.v(this.f11482f);
        zn(canvas);
    }

    public void n3(qh.n3 n3Var, n3 n3Var2, float f4, float f6, float f9, Canvas canvas, int i, int i5, int i6, int i8) {
        boolean z2;
        int i10;
        if (n3Var.f12874s == null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            if (TextUtils.isEmpty(n3Var.y)) {
                return;
            }
            if (n3Var.f12868f3) {
                i10 = n3Var.f12871n;
            } else {
                i10 = n3Var2.f11514zn;
            }
        } else {
            i10 = -16777216;
        }
        if (y(this.f11477c5, n3Var.y) && j5.zn(this.f11488i9, n3Var.f12876v) && this.f11482f == n3Var.f12874s && this.f11497t == n3Var.f12867f && this.f11499tl == n3Var.f12875t && j5.zn(Integer.valueOf(this.f11503wz), Integer.valueOf(n3Var.f12877w)) && this.f11505xc == n3Var.f12872p && j5.zn(Integer.valueOf(this.f11502w), Integer.valueOf(n3Var.f12864co)) && this.f11493p == n3Var.f12878z && this.f11490mt == n3Var.f12873r && this.f11478co == n3Var2.y && this.f11506z == n3Var2.f11512n3 && this.f11494r == i10 && this.f11487i4 == n3Var2.f11511gv && this.f11504x4 == n3Var2.f11513v && j5.zn(this.f11474a.getTypeface(), n3Var2.f11510a) && this.f11483f3 == f4 && this.f11491n == f6 && this.f11476c == f9 && this.f11480d0 == i && this.f11485fh == i5 && this.f11495rz == i6 && this.f11489mg == i8) {
            gv(canvas, z2);
            return;
        }
        this.f11477c5 = n3Var.y;
        this.f11488i9 = n3Var.f12876v;
        this.f11482f = n3Var.f12874s;
        this.f11497t = n3Var.f12867f;
        this.f11499tl = n3Var.f12875t;
        this.f11503wz = n3Var.f12877w;
        this.f11505xc = n3Var.f12872p;
        this.f11502w = n3Var.f12864co;
        this.f11493p = n3Var.f12878z;
        this.f11490mt = n3Var.f12873r;
        this.f11478co = n3Var2.y;
        this.f11506z = n3Var2.f11512n3;
        this.f11494r = i10;
        this.f11487i4 = n3Var2.f11511gv;
        this.f11504x4 = n3Var2.f11513v;
        this.f11474a.setTypeface(n3Var2.f11510a);
        this.f11483f3 = f4;
        this.f11491n = f6;
        this.f11476c = f9;
        this.f11480d0 = i;
        this.f11485fh = i5;
        this.f11495rz = i6;
        this.f11489mg = i8;
        if (z2) {
            v5.y.v(this.f11477c5);
            fb();
        } else {
            v5.y.v(this.f11482f);
            a();
        }
        gv(canvas, z2);
    }

    public final void v(Canvas canvas) {
        int i;
        StaticLayout staticLayout = this.f11498ta;
        StaticLayout staticLayout2 = this.f11479d;
        if (staticLayout != null && staticLayout2 != null) {
            int save = canvas.save();
            canvas.translate(this.f11507z6, this.f11481ej);
            if (Color.alpha(this.f11494r) > 0) {
                this.f11484fb.setColor(this.f11494r);
                canvas.drawRect(-this.f11500ud, 0.0f, staticLayout.getWidth() + this.f11500ud, staticLayout.getHeight(), this.f11484fb);
            }
            int i5 = this.f11487i4;
            boolean z2 = true;
            if (i5 == 1) {
                this.f11474a.setStrokeJoin(Paint.Join.ROUND);
                this.f11474a.setStrokeWidth(this.y);
                this.f11474a.setColor(this.f11504x4);
                this.f11474a.setStyle(Paint.Style.FILL_AND_STROKE);
                staticLayout2.draw(canvas);
            } else if (i5 == 2) {
                TextPaint textPaint = this.f11474a;
                float f4 = this.f11492n3;
                float f6 = this.f11508zn;
                textPaint.setShadowLayer(f4, f6, f6, this.f11504x4);
            } else if (i5 == 3 || i5 == 4) {
                if (i5 != 3) {
                    z2 = false;
                }
                int i6 = -1;
                if (z2) {
                    i = -1;
                } else {
                    i = this.f11504x4;
                }
                if (z2) {
                    i6 = this.f11504x4;
                }
                float f9 = this.f11492n3 / 2.0f;
                this.f11474a.setColor(this.f11478co);
                this.f11474a.setStyle(Paint.Style.FILL);
                float f10 = -f9;
                this.f11474a.setShadowLayer(this.f11492n3, f10, f10, i);
                staticLayout2.draw(canvas);
                this.f11474a.setShadowLayer(this.f11492n3, f9, f9, i6);
            }
            this.f11474a.setColor(this.f11478co);
            this.f11474a.setStyle(Paint.Style.FILL);
            staticLayout.draw(canvas);
            this.f11474a.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
            canvas.restoreToCount(save);
        }
    }

    public final void zn(Canvas canvas) {
        canvas.drawBitmap(this.f11482f, (Rect) null, this.f11475a8, this.f11496s);
    }
}
