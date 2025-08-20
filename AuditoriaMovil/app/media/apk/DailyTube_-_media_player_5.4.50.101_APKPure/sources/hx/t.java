package hx;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
/* loaded from: classes.dex */
public class t {
    public final tl[] y = new tl[4];

    /* renamed from: n3  reason: collision with root package name */
    public final Matrix[] f9083n3 = new Matrix[4];

    /* renamed from: zn  reason: collision with root package name */
    public final Matrix[] f9087zn = new Matrix[4];

    /* renamed from: gv  reason: collision with root package name */
    public final PointF f9081gv = new PointF();

    /* renamed from: v  reason: collision with root package name */
    public final Path f9086v = new Path();

    /* renamed from: a  reason: collision with root package name */
    public final Path f9077a = new Path();

    /* renamed from: fb  reason: collision with root package name */
    public final tl f9080fb = new tl();

    /* renamed from: s  reason: collision with root package name */
    public final float[] f9084s = new float[2];

    /* renamed from: c5  reason: collision with root package name */
    public final float[] f9078c5 = new float[2];

    /* renamed from: i9  reason: collision with root package name */
    public final Path f9082i9 = new Path();

    /* renamed from: f  reason: collision with root package name */
    public final Path f9079f = new Path();

    /* renamed from: t  reason: collision with root package name */
    public boolean f9085t = true;

    /* loaded from: classes.dex */
    public interface n3 {
        void n3(tl tlVar, Matrix matrix, int i);

        void y(tl tlVar, Matrix matrix, int i);
    }

    /* loaded from: classes.dex */
    public static class y {
        public static final t y = new t();
    }

    /* loaded from: classes.dex */
    public static final class zn {
        @Nullable

        /* renamed from: gv  reason: collision with root package name */
        public final n3 f9088gv;
        @NonNull

        /* renamed from: n3  reason: collision with root package name */
        public final Path f9089n3;

        /* renamed from: v  reason: collision with root package name */
        public final float f9090v;
        @NonNull
        public final f y;
        @NonNull

        /* renamed from: zn  reason: collision with root package name */
        public final RectF f9091zn;

        public zn(@NonNull f fVar, float f4, RectF rectF, @Nullable n3 n3Var, Path path) {
            this.f9088gv = n3Var;
            this.y = fVar;
            this.f9090v = f4;
            this.f9091zn = rectF;
            this.f9089n3 = path;
        }
    }

    public t() {
        for (int i = 0; i < 4; i++) {
            this.y[i] = new tl();
            this.f9083n3[i] = new Matrix();
            this.f9087zn[i] = new Matrix();
        }
    }

    @NonNull
    public static t f() {
        return y.y;
    }

    public final void a(int i, @NonNull RectF rectF, @NonNull PointF pointF) {
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    pointF.set(rectF.right, rectF.top);
                    return;
                } else {
                    pointF.set(rectF.left, rectF.top);
                    return;
                }
            }
            pointF.set(rectF.left, rectF.bottom);
            return;
        }
        pointF.set(rectF.right, rectF.bottom);
    }

    public final float c5(@NonNull RectF rectF, int i) {
        float[] fArr = this.f9084s;
        tl tlVar = this.y[i];
        fArr[0] = tlVar.f9099zn;
        fArr[1] = tlVar.f9095gv;
        this.f9083n3[i].mapPoints(fArr);
        if (i != 1 && i != 3) {
            return Math.abs(rectF.centerY() - this.f9084s[1]);
        }
        return Math.abs(rectF.centerX() - this.f9084s[0]);
    }

    public final hx.zn fb(int i, @NonNull f fVar) {
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    return fVar.z();
                }
                return fVar.mt();
            }
            return fVar.i9();
        }
        return fVar.t();
    }

    public void gv(f fVar, float f4, RectF rectF, @NonNull Path path) {
        v(fVar, f4, rectF, null, path);
    }

    public final a i9(int i, @NonNull f fVar) {
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    return fVar.xc();
                }
                return fVar.w();
            }
            return fVar.wz();
        }
        return fVar.s();
    }

    public final void n3(@NonNull zn znVar, int i) {
        this.f9084s[0] = this.y[i].f();
        this.f9084s[1] = this.y[i].t();
        this.f9083n3[i].mapPoints(this.f9084s);
        if (i == 0) {
            Path path = znVar.f9089n3;
            float[] fArr = this.f9084s;
            path.moveTo(fArr[0], fArr[1]);
        } else {
            Path path2 = znVar.f9089n3;
            float[] fArr2 = this.f9084s;
            path2.lineTo(fArr2[0], fArr2[1]);
        }
        this.y[i].gv(this.f9083n3[i], znVar.f9089n3);
        n3 n3Var = znVar.f9088gv;
        if (n3Var != null) {
            n3Var.n3(this.y[i], this.f9083n3[i], i);
        }
    }

    public final gv s(int i, @NonNull f fVar) {
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    return fVar.co();
                }
                return fVar.p();
            }
            return fVar.c5();
        }
        return fVar.f();
    }

    public final boolean t(Path path, int i) {
        this.f9079f.reset();
        this.y[i].gv(this.f9083n3[i], this.f9079f);
        RectF rectF = new RectF();
        path.computeBounds(rectF, true);
        this.f9079f.computeBounds(rectF, true);
        path.op(this.f9079f, Path.Op.INTERSECT);
        path.computeBounds(rectF, true);
        if (!rectF.isEmpty()) {
            return true;
        }
        if (rectF.width() > 1.0f && rectF.height() > 1.0f) {
            return true;
        }
        return false;
    }

    public final void tl(@NonNull zn znVar, int i) {
        s(i, znVar.y).n3(this.y[i], 90.0f, znVar.f9090v, znVar.f9091zn, fb(i, znVar.y));
        float y2 = y(i);
        this.f9083n3[i].reset();
        a(i, znVar.f9091zn, this.f9081gv);
        Matrix matrix = this.f9083n3[i];
        PointF pointF = this.f9081gv;
        matrix.setTranslate(pointF.x, pointF.y);
        this.f9083n3[i].preRotate(y2);
    }

    public void v(f fVar, float f4, RectF rectF, n3 n3Var, @NonNull Path path) {
        path.rewind();
        this.f9086v.rewind();
        this.f9077a.rewind();
        this.f9077a.addRect(rectF, Path.Direction.CW);
        zn znVar = new zn(fVar, f4, rectF, n3Var, path);
        for (int i = 0; i < 4; i++) {
            tl(znVar, i);
            wz(i);
        }
        for (int i5 = 0; i5 < 4; i5++) {
            n3(znVar, i5);
            zn(znVar, i5);
        }
        path.close();
        this.f9086v.close();
        if (!this.f9086v.isEmpty()) {
            path.op(this.f9086v, Path.Op.UNION);
        }
    }

    public final void wz(int i) {
        this.f9084s[0] = this.y[i].c5();
        this.f9084s[1] = this.y[i].i9();
        this.f9083n3[i].mapPoints(this.f9084s);
        float y2 = y(i);
        this.f9087zn[i].reset();
        Matrix matrix = this.f9087zn[i];
        float[] fArr = this.f9084s;
        matrix.setTranslate(fArr[0], fArr[1]);
        this.f9087zn[i].preRotate(y2);
    }

    public final float y(int i) {
        return (i + 1) * 90;
    }

    public final void zn(@NonNull zn znVar, int i) {
        int i5 = (i + 1) % 4;
        this.f9084s[0] = this.y[i].c5();
        this.f9084s[1] = this.y[i].i9();
        this.f9083n3[i].mapPoints(this.f9084s);
        this.f9078c5[0] = this.y[i5].f();
        this.f9078c5[1] = this.y[i5].t();
        this.f9083n3[i5].mapPoints(this.f9078c5);
        float[] fArr = this.f9084s;
        float f4 = fArr[0];
        float[] fArr2 = this.f9078c5;
        float max = Math.max(((float) Math.hypot(f4 - fArr2[0], fArr[1] - fArr2[1])) - 0.001f, 0.0f);
        float c52 = c5(znVar.f9091zn, i);
        this.f9080fb.wz(0.0f, 0.0f);
        a i92 = i9(i, znVar.y);
        i92.zn(max, c52, znVar.f9090v, this.f9080fb);
        this.f9082i9.reset();
        this.f9080fb.gv(this.f9087zn[i], this.f9082i9);
        if (this.f9085t && (i92.n3() || t(this.f9082i9, i) || t(this.f9082i9, i5))) {
            Path path = this.f9082i9;
            path.op(path, this.f9077a, Path.Op.DIFFERENCE);
            this.f9084s[0] = this.f9080fb.f();
            this.f9084s[1] = this.f9080fb.t();
            this.f9087zn[i].mapPoints(this.f9084s);
            Path path2 = this.f9086v;
            float[] fArr3 = this.f9084s;
            path2.moveTo(fArr3[0], fArr3[1]);
            this.f9080fb.gv(this.f9087zn[i], this.f9086v);
        } else {
            this.f9080fb.gv(this.f9087zn[i], znVar.f9089n3);
        }
        n3 n3Var = znVar.f9088gv;
        if (n3Var != null) {
            n3Var.y(this.f9080fb, this.f9087zn[i], i);
        }
    }
}
