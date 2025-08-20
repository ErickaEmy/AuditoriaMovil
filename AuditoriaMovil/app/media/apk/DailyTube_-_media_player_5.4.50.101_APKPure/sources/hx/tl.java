package hx;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class tl {
    @Deprecated

    /* renamed from: a  reason: collision with root package name */
    public float f9092a;

    /* renamed from: c5  reason: collision with root package name */
    public boolean f9093c5;
    @Deprecated

    /* renamed from: gv  reason: collision with root package name */
    public float f9095gv;
    @Deprecated

    /* renamed from: n3  reason: collision with root package name */
    public float f9096n3;
    @Deprecated

    /* renamed from: v  reason: collision with root package name */
    public float f9098v;
    @Deprecated
    public float y;
    @Deprecated

    /* renamed from: zn  reason: collision with root package name */
    public float f9099zn;

    /* renamed from: fb  reason: collision with root package name */
    public final List<a> f9094fb = new ArrayList();

    /* renamed from: s  reason: collision with root package name */
    public final List<fb> f9097s = new ArrayList();

    /* loaded from: classes.dex */
    public static abstract class a {
        public final Matrix y = new Matrix();

        public abstract void y(Matrix matrix, Path path);
    }

    /* loaded from: classes.dex */
    public static abstract class fb {
        public static final Matrix y = new Matrix();

        public final void n3(os.y yVar, int i, Canvas canvas) {
            y(y, yVar, i, canvas);
        }

        public abstract void y(Matrix matrix, os.y yVar, int i, Canvas canvas);
    }

    /* loaded from: classes.dex */
    public static class gv extends a {

        /* renamed from: s  reason: collision with root package name */
        public static final RectF f9100s = new RectF();
        @Deprecated

        /* renamed from: a  reason: collision with root package name */
        public float f9101a;
        @Deprecated

        /* renamed from: fb  reason: collision with root package name */
        public float f9102fb;
        @Deprecated

        /* renamed from: gv  reason: collision with root package name */
        public float f9103gv;
        @Deprecated

        /* renamed from: n3  reason: collision with root package name */
        public float f9104n3;
        @Deprecated

        /* renamed from: v  reason: collision with root package name */
        public float f9105v;
        @Deprecated

        /* renamed from: zn  reason: collision with root package name */
        public float f9106zn;

        public gv(float f4, float f6, float f9, float f10) {
            p(f4);
            r(f6);
            mt(f9);
            w(f10);
        }

        public final void co(float f4) {
            this.f9101a = f4;
        }

        public final float f() {
            return this.f9104n3;
        }

        public final float i9() {
            return this.f9105v;
        }

        public final void mt(float f4) {
            this.f9103gv = f4;
        }

        public final void p(float f4) {
            this.f9104n3 = f4;
        }

        public final void r(float f4) {
            this.f9106zn = f4;
        }

        public final float t() {
            return this.f9103gv;
        }

        public final float tl() {
            return this.f9101a;
        }

        public final void w(float f4) {
            this.f9105v = f4;
        }

        public final float wz() {
            return this.f9102fb;
        }

        public final float xc() {
            return this.f9106zn;
        }

        @Override // hx.tl.a
        public void y(@NonNull Matrix matrix, @NonNull Path path) {
            Matrix matrix2 = this.y;
            matrix.invert(matrix2);
            path.transform(matrix2);
            RectF rectF = f9100s;
            rectF.set(f(), xc(), t(), i9());
            path.arcTo(rectF, tl(), wz(), false);
            path.transform(matrix);
        }

        public final void z(float f4) {
            this.f9102fb = f4;
        }
    }

    /* loaded from: classes.dex */
    public static class n3 extends fb {

        /* renamed from: n3  reason: collision with root package name */
        public final gv f9107n3;

        public n3(gv gvVar) {
            this.f9107n3 = gvVar;
        }

        @Override // hx.tl.fb
        public void y(Matrix matrix, @NonNull os.y yVar, int i, @NonNull Canvas canvas) {
            yVar.y(canvas, matrix, new RectF(this.f9107n3.f(), this.f9107n3.xc(), this.f9107n3.t(), this.f9107n3.i9()), i, this.f9107n3.tl(), this.f9107n3.wz());
        }
    }

    /* loaded from: classes.dex */
    public static class v extends a {

        /* renamed from: n3  reason: collision with root package name */
        public float f9108n3;

        /* renamed from: zn  reason: collision with root package name */
        public float f9109zn;

        @Override // hx.tl.a
        public void y(@NonNull Matrix matrix, @NonNull Path path) {
            Matrix matrix2 = this.y;
            matrix.invert(matrix2);
            path.transform(matrix2);
            path.lineTo(this.f9108n3, this.f9109zn);
            path.transform(matrix);
        }
    }

    /* loaded from: classes.dex */
    public class y extends fb {

        /* renamed from: n3  reason: collision with root package name */
        public final /* synthetic */ List f9111n3;

        /* renamed from: zn  reason: collision with root package name */
        public final /* synthetic */ Matrix f9112zn;

        public y(List list, Matrix matrix) {
            this.f9111n3 = list;
            this.f9112zn = matrix;
        }

        @Override // hx.tl.fb
        public void y(Matrix matrix, os.y yVar, int i, Canvas canvas) {
            for (fb fbVar : this.f9111n3) {
                fbVar.y(this.f9112zn, yVar, i, canvas);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class zn extends fb {

        /* renamed from: gv  reason: collision with root package name */
        public final float f9113gv;

        /* renamed from: n3  reason: collision with root package name */
        public final v f9114n3;

        /* renamed from: zn  reason: collision with root package name */
        public final float f9115zn;

        public zn(v vVar, float f4, float f6) {
            this.f9114n3 = vVar;
            this.f9115zn = f4;
            this.f9113gv = f6;
        }

        @Override // hx.tl.fb
        public void y(Matrix matrix, @NonNull os.y yVar, int i, @NonNull Canvas canvas) {
            RectF rectF = new RectF(0.0f, 0.0f, (float) Math.hypot(this.f9114n3.f9109zn - this.f9113gv, this.f9114n3.f9108n3 - this.f9115zn), 0.0f);
            Matrix matrix2 = new Matrix(matrix);
            matrix2.preTranslate(this.f9115zn, this.f9113gv);
            matrix2.preRotate(zn());
            yVar.n3(canvas, matrix2, rectF, i);
        }

        public float zn() {
            return (float) Math.toDegrees(Math.atan((this.f9114n3.f9109zn - this.f9113gv) / (this.f9114n3.f9108n3 - this.f9115zn)));
        }
    }

    public tl() {
        wz(0.0f, 0.0f);
    }

    @NonNull
    public fb a(Matrix matrix) {
        n3(s());
        return new y(new ArrayList(this.f9097s), new Matrix(matrix));
    }

    public float c5() {
        return this.f9099zn;
    }

    public final void co(float f4) {
        this.f9095gv = f4;
    }

    public float f() {
        return this.y;
    }

    public final float fb() {
        return this.f9098v;
    }

    public void gv(Matrix matrix, Path path) {
        int size = this.f9094fb.size();
        for (int i = 0; i < size; i++) {
            this.f9094fb.get(i).y(matrix, path);
        }
    }

    public float i9() {
        return this.f9095gv;
    }

    public final void mt(float f4) {
        this.f9099zn = f4;
    }

    public final void n3(float f4) {
        if (fb() == f4) {
            return;
        }
        float fb2 = ((f4 - fb()) + 360.0f) % 360.0f;
        if (fb2 > 180.0f) {
            return;
        }
        gv gvVar = new gv(c5(), i9(), c5(), i9());
        gvVar.co(fb());
        gvVar.z(fb2);
        this.f9097s.add(new n3(gvVar));
        w(f4);
    }

    public final void p(float f4) {
        this.f9092a = f4;
    }

    public final void r(float f4) {
        this.f9096n3 = f4;
    }

    public final float s() {
        return this.f9092a;
    }

    public float t() {
        return this.f9096n3;
    }

    public void tl(float f4, float f6) {
        v vVar = new v();
        vVar.f9108n3 = f4;
        vVar.f9109zn = f6;
        this.f9094fb.add(vVar);
        zn znVar = new zn(vVar, c5(), i9());
        zn(znVar, znVar.zn() + 270.0f, znVar.zn() + 270.0f);
        mt(f4);
        co(f6);
    }

    public boolean v() {
        return this.f9093c5;
    }

    public final void w(float f4) {
        this.f9098v = f4;
    }

    public void wz(float f4, float f6) {
        xc(f4, f6, 270.0f, 0.0f);
    }

    public void xc(float f4, float f6, float f9, float f10) {
        z(f4);
        r(f6);
        mt(f4);
        co(f6);
        w(f9);
        p((f9 + f10) % 360.0f);
        this.f9094fb.clear();
        this.f9097s.clear();
        this.f9093c5 = false;
    }

    public void y(float f4, float f6, float f9, float f10, float f11, float f12) {
        boolean z2;
        float f13;
        gv gvVar = new gv(f4, f6, f9, f10);
        gvVar.co(f11);
        gvVar.z(f12);
        this.f9094fb.add(gvVar);
        n3 n3Var = new n3(gvVar);
        float f14 = f11 + f12;
        if (f12 < 0.0f) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            f11 = (f11 + 180.0f) % 360.0f;
        }
        if (z2) {
            f13 = (180.0f + f14) % 360.0f;
        } else {
            f13 = f14;
        }
        zn(n3Var, f11, f13);
        double d2 = f14;
        mt(((f4 + f9) * 0.5f) + (((f9 - f4) / 2.0f) * ((float) Math.cos(Math.toRadians(d2)))));
        co(((f6 + f10) * 0.5f) + (((f10 - f6) / 2.0f) * ((float) Math.sin(Math.toRadians(d2)))));
    }

    public final void z(float f4) {
        this.y = f4;
    }

    public final void zn(fb fbVar, float f4, float f6) {
        n3(f4);
        this.f9097s.add(fbVar);
        w(f6);
    }
}
