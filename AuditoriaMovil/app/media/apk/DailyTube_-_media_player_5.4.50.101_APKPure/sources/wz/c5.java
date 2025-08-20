package wz;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import androidx.annotation.NonNull;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$color;
import androidx.appcompat.R$dimen;
import androidx.appcompat.R$drawable;
import wz.z6;
/* loaded from: classes.dex */
public final class c5 {

    /* renamed from: n3  reason: collision with root package name */
    public static final PorterDuff.Mode f14697n3 = PorterDuff.Mode.SRC_IN;

    /* renamed from: zn  reason: collision with root package name */
    public static c5 f14698zn;
    public z6 y;

    /* loaded from: classes.dex */
    public class y implements z6.a {
        public final int[] y = {R$drawable.f711qn, R$drawable.f700hw, R$drawable.y};

        /* renamed from: n3  reason: collision with root package name */
        public final int[] f14701n3 = {R$drawable.f725xc, R$drawable.f698fh, R$drawable.f727z, R$drawable.f721w, R$drawable.f710p, R$drawable.f691co, R$drawable.f706mt};

        /* renamed from: zn  reason: collision with root package name */
        public final int[] f14703zn = {R$drawable.f720vl, R$drawable.f703j5, R$drawable.f695f, R$drawable.f723x, R$drawable.f688b, R$drawable.f704k5, R$drawable.f726yt};

        /* renamed from: gv  reason: collision with root package name */
        public final int[] f14700gv = {R$drawable.f701i4, R$drawable.f690c5, R$drawable.f724x4};

        /* renamed from: v  reason: collision with root package name */
        public final int[] f14702v = {R$drawable.f687a8, R$drawable.f709o};

        /* renamed from: a  reason: collision with root package name */
        public final int[] f14699a = {R$drawable.f729zn, R$drawable.f697fb, R$drawable.f699gv, R$drawable.f714s};

        public final boolean a(int[] iArr, int i) {
            for (int i5 : iArr) {
                if (i5 == i) {
                    return true;
                }
            }
            return false;
        }

        public final ColorStateList c5(@NonNull Context context) {
            return s(context, x.zn(context, R$attr.f630co));
        }

        public final ColorStateList f(Context context) {
            int[][] iArr = new int[3];
            int[] iArr2 = new int[3];
            int i = R$attr.f635f3;
            ColorStateList v2 = x.v(context, i);
            if (v2 != null && v2.isStateful()) {
                int[] iArr3 = x.f14835n3;
                iArr[0] = iArr3;
                iArr2[0] = v2.getColorForState(iArr3, 0);
                iArr[1] = x.f14830a;
                iArr2[1] = x.zn(context, R$attr.f647r);
                iArr[2] = x.f14831c5;
                iArr2[2] = v2.getDefaultColor();
            } else {
                iArr[0] = x.f14835n3;
                iArr2[0] = x.n3(context, i);
                iArr[1] = x.f14830a;
                iArr2[1] = x.zn(context, R$attr.f647r);
                iArr[2] = x.f14831c5;
                iArr2[2] = x.zn(context, i);
            }
            return new ColorStateList(iArr, iArr2);
        }

        public final ColorStateList fb(@NonNull Context context) {
            return s(context, 0);
        }

        @Override // wz.z6.a
        public PorterDuff.Mode gv(int i) {
            if (i == R$drawable.f694ej) {
                return PorterDuff.Mode.MULTIPLY;
            }
            return null;
        }

        public final ColorStateList i9(@NonNull Context context) {
            return s(context, x.zn(context, R$attr.f662z));
        }

        @Override // wz.z6.a
        public Drawable n3(@NonNull z6 z6Var, @NonNull Context context, int i) {
            if (i == R$drawable.f702i9) {
                return new LayerDrawable(new Drawable[]{z6Var.i9(context, R$drawable.f690c5), z6Var.i9(context, R$drawable.f695f)});
            }
            if (i == R$drawable.f707n) {
                return t(z6Var, context, R$dimen.f673c5);
            }
            if (i == R$drawable.f696f3) {
                return t(z6Var, context, R$dimen.f677i9);
            }
            if (i == R$drawable.f689c) {
                return t(z6Var, context, R$dimen.f674f);
            }
            return null;
        }

        public final ColorStateList s(@NonNull Context context, int i) {
            int zn2 = x.zn(context, R$attr.f659x4);
            return new ColorStateList(new int[][]{x.f14835n3, x.f14837v, x.f14838zn, x.f14831c5}, new int[]{x.n3(context, R$attr.f662z), z6.y.zn(zn2, i), z6.y.zn(zn2, i), i});
        }

        public final LayerDrawable t(@NonNull z6 z6Var, @NonNull Context context, int i) {
            BitmapDrawable bitmapDrawable;
            BitmapDrawable bitmapDrawable2;
            BitmapDrawable bitmapDrawable3;
            int dimensionPixelSize = context.getResources().getDimensionPixelSize(i);
            Drawable i92 = z6Var.i9(context, R$drawable.f692d);
            Drawable i93 = z6Var.i9(context, R$drawable.f728z6);
            if ((i92 instanceof BitmapDrawable) && i92.getIntrinsicWidth() == dimensionPixelSize && i92.getIntrinsicHeight() == dimensionPixelSize) {
                bitmapDrawable = (BitmapDrawable) i92;
                bitmapDrawable2 = new BitmapDrawable(bitmapDrawable.getBitmap());
            } else {
                Bitmap createBitmap = Bitmap.createBitmap(dimensionPixelSize, dimensionPixelSize, Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(createBitmap);
                i92.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
                i92.draw(canvas);
                bitmapDrawable = new BitmapDrawable(createBitmap);
                bitmapDrawable2 = new BitmapDrawable(createBitmap);
            }
            bitmapDrawable2.setTileModeX(Shader.TileMode.REPEAT);
            if ((i93 instanceof BitmapDrawable) && i93.getIntrinsicWidth() == dimensionPixelSize && i93.getIntrinsicHeight() == dimensionPixelSize) {
                bitmapDrawable3 = (BitmapDrawable) i93;
            } else {
                Bitmap createBitmap2 = Bitmap.createBitmap(dimensionPixelSize, dimensionPixelSize, Bitmap.Config.ARGB_8888);
                Canvas canvas2 = new Canvas(createBitmap2);
                i93.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
                i93.draw(canvas2);
                bitmapDrawable3 = new BitmapDrawable(createBitmap2);
            }
            LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{bitmapDrawable, bitmapDrawable3, bitmapDrawable2});
            layerDrawable.setId(0, 16908288);
            layerDrawable.setId(1, 16908303);
            layerDrawable.setId(2, 16908301);
            return layerDrawable;
        }

        public final void tl(Drawable drawable, int i, PorterDuff.Mode mode) {
            if (n.y(drawable)) {
                drawable = drawable.mutate();
            }
            if (mode == null) {
                mode = c5.f14697n3;
            }
            drawable.setColorFilter(c5.v(i, mode));
        }

        @Override // wz.z6.a
        public boolean v(@NonNull Context context, int i, @NonNull Drawable drawable) {
            if (i == R$drawable.f713rz) {
                LayerDrawable layerDrawable = (LayerDrawable) drawable;
                Drawable findDrawableByLayerId = layerDrawable.findDrawableByLayerId(16908288);
                int i5 = R$attr.f639i4;
                tl(findDrawableByLayerId, x.zn(context, i5), c5.f14697n3);
                tl(layerDrawable.findDrawableByLayerId(16908303), x.zn(context, i5), c5.f14697n3);
                tl(layerDrawable.findDrawableByLayerId(16908301), x.zn(context, R$attr.f647r), c5.f14697n3);
                return true;
            } else if (i != R$drawable.f707n && i != R$drawable.f696f3 && i != R$drawable.f689c) {
                return false;
            } else {
                LayerDrawable layerDrawable2 = (LayerDrawable) drawable;
                tl(layerDrawable2.findDrawableByLayerId(16908288), x.n3(context, R$attr.f639i4), c5.f14697n3);
                Drawable findDrawableByLayerId2 = layerDrawable2.findDrawableByLayerId(16908303);
                int i6 = R$attr.f647r;
                tl(findDrawableByLayerId2, x.zn(context, i6), c5.f14697n3);
                tl(layerDrawable2.findDrawableByLayerId(16908301), x.zn(context, i6), c5.f14697n3);
                return true;
            }
        }

        @Override // wz.z6.a
        public ColorStateList y(@NonNull Context context, int i) {
            if (i == R$drawable.f717tl) {
                return c5.y.zn(context, R$color.f670v);
            }
            if (i == R$drawable.f718ud) {
                return c5.y.zn(context, R$color.f669s);
            }
            if (i == R$drawable.f694ej) {
                return f(context);
            }
            if (i == R$drawable.f686a) {
                return i9(context);
            }
            if (i == R$drawable.f708n3) {
                return fb(context);
            }
            if (i == R$drawable.f719v) {
                return c5(context);
            }
            if (i != R$drawable.f705mg && i != R$drawable.f716ta) {
                if (a(this.f14701n3, i)) {
                    return x.v(context, R$attr.f639i4);
                }
                if (a(this.f14702v, i)) {
                    return c5.y.zn(context, R$color.f667gv);
                }
                if (a(this.f14699a, i)) {
                    return c5.y.zn(context, R$color.f671zn);
                }
                if (i == R$drawable.f693d0) {
                    return c5.y.zn(context, R$color.f665a);
                }
                return null;
            }
            return c5.y.zn(context, R$color.f666fb);
        }

        /* JADX WARN: Removed duplicated region for block: B:22:0x0052  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x006d A[RETURN] */
        @Override // wz.z6.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public boolean zn(@androidx.annotation.NonNull android.content.Context r7, int r8, @androidx.annotation.NonNull android.graphics.drawable.Drawable r9) {
            /*
                r6 = this;
                android.graphics.PorterDuff$Mode r0 = wz.c5.y()
                int[] r1 = r6.y
                boolean r1 = r6.a(r1, r8)
                r2 = 1
                r3 = 0
                r4 = -1
                if (r1 == 0) goto L15
                int r8 = androidx.appcompat.R$attr.f639i4
            L11:
                r1 = r0
            L12:
                r0 = -1
                r5 = 1
                goto L50
            L15:
                int[] r1 = r6.f14703zn
                boolean r1 = r6.a(r1, r8)
                if (r1 == 0) goto L20
                int r8 = androidx.appcompat.R$attr.f647r
                goto L11
            L20:
                int[] r1 = r6.f14700gv
                boolean r1 = r6.a(r1, r8)
                r5 = 16842801(0x1010031, float:2.3693695E-38)
                if (r1 == 0) goto L32
                android.graphics.PorterDuff$Mode r0 = android.graphics.PorterDuff.Mode.MULTIPLY
            L2d:
                r1 = r0
                r8 = 16842801(0x1010031, float:2.3693695E-38)
                goto L12
            L32:
                int r1 = androidx.appcompat.R$drawable.f712r
                if (r8 != r1) goto L47
                r8 = 1109603123(0x42233333, float:40.8)
                int r8 = java.lang.Math.round(r8)
                r1 = 16842800(0x1010030, float:2.3693693E-38)
                r1 = r0
                r5 = 1
                r0 = r8
                r8 = 16842800(0x1010030, float:2.3693693E-38)
                goto L50
            L47:
                int r1 = androidx.appcompat.R$drawable.f715t
                if (r8 != r1) goto L4c
                goto L2d
            L4c:
                r1 = r0
                r8 = 0
                r0 = -1
                r5 = 0
            L50:
                if (r5 == 0) goto L6d
                boolean r3 = wz.n.y(r9)
                if (r3 == 0) goto L5c
                android.graphics.drawable.Drawable r9 = r9.mutate()
            L5c:
                int r7 = wz.x.zn(r7, r8)
                android.graphics.PorterDuffColorFilter r7 = wz.c5.v(r7, r1)
                r9.setColorFilter(r7)
                if (r0 == r4) goto L6c
                r9.setAlpha(r0)
            L6c:
                return r2
            L6d:
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: wz.c5.y.zn(android.content.Context, int, android.graphics.drawable.Drawable):boolean");
        }
    }

    public static void c5(Drawable drawable, yt ytVar, int[] iArr) {
        z6.i4(drawable, ytVar, iArr);
    }

    public static synchronized c5 n3() {
        c5 c5Var;
        synchronized (c5.class) {
            try {
                if (f14698zn == null) {
                    s();
                }
                c5Var = f14698zn;
            } catch (Throwable th) {
                throw th;
            }
        }
        return c5Var;
    }

    public static synchronized void s() {
        synchronized (c5.class) {
            if (f14698zn == null) {
                c5 c5Var = new c5();
                f14698zn = c5Var;
                c5Var.y = z6.s();
                f14698zn.y.r(new y());
            }
        }
    }

    public static synchronized PorterDuffColorFilter v(int i, PorterDuff.Mode mode) {
        PorterDuffColorFilter t2;
        synchronized (c5.class) {
            t2 = z6.t(i, mode);
        }
        return t2;
    }

    public synchronized ColorStateList a(@NonNull Context context, int i) {
        return this.y.tl(context, i);
    }

    public synchronized void fb(@NonNull Context context) {
        this.y.co(context);
    }

    public synchronized Drawable gv(@NonNull Context context, int i, boolean z2) {
        return this.y.f(context, i, z2);
    }

    public synchronized Drawable zn(@NonNull Context context, int i) {
        return this.y.i9(context, i);
    }
}
