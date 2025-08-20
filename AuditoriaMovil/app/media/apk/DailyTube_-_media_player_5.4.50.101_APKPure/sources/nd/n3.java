package nd;

import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.Build;
import androidx.annotation.Nullable;
import bv.i9;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import nd.v;
import vn.w;
import vn.y;
import wm.s;
import wm.wz;
import yk.mg;
/* loaded from: classes.dex */
public abstract class n3 implements i3.v, y.n3, ne.a {

    /* renamed from: a  reason: collision with root package name */
    public final Paint f11944a;

    /* renamed from: c  reason: collision with root package name */
    public boolean f11945c;

    /* renamed from: c5  reason: collision with root package name */
    public final RectF f11946c5;
    @Nullable

    /* renamed from: co  reason: collision with root package name */
    public vn.gv f11947co;
    @Nullable

    /* renamed from: d0  reason: collision with root package name */
    public Paint f11948d0;

    /* renamed from: f  reason: collision with root package name */
    public final RectF f11949f;

    /* renamed from: f3  reason: collision with root package name */
    public final w f11950f3;

    /* renamed from: fb  reason: collision with root package name */
    public final Paint f11951fb;

    /* renamed from: fh  reason: collision with root package name */
    public float f11952fh;

    /* renamed from: i4  reason: collision with root package name */
    public final List<vn.y<?, ?>> f11954i4;

    /* renamed from: i9  reason: collision with root package name */
    public final RectF f11955i9;
    @Nullable

    /* renamed from: mt  reason: collision with root package name */
    public vn.s f11956mt;

    /* renamed from: n  reason: collision with root package name */
    public boolean f11957n;

    /* renamed from: p  reason: collision with root package name */
    public final v f11959p;
    @Nullable

    /* renamed from: r  reason: collision with root package name */
    public n3 f11960r;
    @Nullable

    /* renamed from: rz  reason: collision with root package name */
    public BlurMaskFilter f11961rz;

    /* renamed from: s  reason: collision with root package name */
    public final Paint f11962s;

    /* renamed from: t  reason: collision with root package name */
    public final RectF f11963t;

    /* renamed from: tl  reason: collision with root package name */
    public final RectF f11964tl;

    /* renamed from: v  reason: collision with root package name */
    public final Paint f11965v;

    /* renamed from: w  reason: collision with root package name */
    public final mg f11966w;

    /* renamed from: wz  reason: collision with root package name */
    public final String f11967wz;

    /* renamed from: x4  reason: collision with root package name */
    public List<n3> f11968x4;

    /* renamed from: xc  reason: collision with root package name */
    public final Matrix f11969xc;
    @Nullable

    /* renamed from: z  reason: collision with root package name */
    public n3 f11970z;
    public final Path y = new Path();

    /* renamed from: n3  reason: collision with root package name */
    public final Matrix f11958n3 = new Matrix();

    /* renamed from: zn  reason: collision with root package name */
    public final Matrix f11971zn = new Matrix();

    /* renamed from: gv  reason: collision with root package name */
    public final Paint f11953gv = new i2.y(1);

    /* loaded from: classes.dex */
    public static /* synthetic */ class y {

        /* renamed from: n3  reason: collision with root package name */
        public static final /* synthetic */ int[] f11972n3;
        public static final /* synthetic */ int[] y;

        static {
            int[] iArr = new int[s.y.values().length];
            f11972n3 = iArr;
            try {
                iArr[s.y.MASK_MODE_NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f11972n3[s.y.MASK_MODE_SUBTRACT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f11972n3[s.y.MASK_MODE_INTERSECT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f11972n3[s.y.MASK_MODE_ADD.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[v.y.values().length];
            y = iArr2;
            try {
                iArr2[v.y.SHAPE.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                y[v.y.PRE_COMP.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                y[v.y.SOLID.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                y[v.y.IMAGE.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                y[v.y.NULL.ordinal()] = 5;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                y[v.y.TEXT.ordinal()] = 6;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                y[v.y.UNKNOWN.ordinal()] = 7;
            } catch (NoSuchFieldError unused11) {
            }
        }
    }

    public n3(mg mgVar, v vVar) {
        PorterDuff.Mode mode = PorterDuff.Mode.DST_IN;
        this.f11965v = new i2.y(1, mode);
        PorterDuff.Mode mode2 = PorterDuff.Mode.DST_OUT;
        this.f11944a = new i2.y(1, mode2);
        i2.y yVar = new i2.y(1);
        this.f11951fb = yVar;
        this.f11962s = new i2.y(PorterDuff.Mode.CLEAR);
        this.f11946c5 = new RectF();
        this.f11955i9 = new RectF();
        this.f11949f = new RectF();
        this.f11963t = new RectF();
        this.f11964tl = new RectF();
        this.f11969xc = new Matrix();
        this.f11954i4 = new ArrayList();
        this.f11957n = true;
        this.f11952fh = 0.0f;
        this.f11966w = mgVar;
        this.f11959p = vVar;
        this.f11967wz = vVar.c5() + "#draw";
        if (vVar.s() == v.n3.INVERT) {
            yVar.setXfermode(new PorterDuffXfermode(mode2));
        } else {
            yVar.setXfermode(new PorterDuffXfermode(mode));
        }
        w n32 = vVar.i4().n3();
        this.f11950f3 = n32;
        n32.n3(this);
        if (vVar.fb() != null && !vVar.fb().isEmpty()) {
            vn.s sVar = new vn.s(vVar.fb());
            this.f11956mt = sVar;
            for (vn.y<wz, Path> yVar2 : sVar.y()) {
                yVar2.y(this);
            }
            for (vn.y<Integer, Integer> yVar3 : this.f11956mt.zn()) {
                c5(yVar3);
                yVar3.y(this);
            }
        }
        yt();
    }

    @Nullable
    public static n3 r(zn znVar, v vVar, mg mgVar, yk.s sVar) {
        switch (y.y[vVar.a().ordinal()]) {
            case 1:
                return new fb(mgVar, vVar, znVar, sVar);
            case 2:
                return new zn(mgVar, vVar, sVar.xc(vVar.tl()), sVar);
            case 3:
                return new s(mgVar, vVar);
            case 4:
                return new gv(mgVar, vVar);
            case 5:
                return new a(mgVar, vVar);
            case 6:
                return new c5(mgVar, vVar);
            default:
                br.gv.zn("Unknown layer type " + vVar.a());
                return null;
        }
    }

    public <T> void a(T t2, @Nullable uo.zn<T> znVar) {
        this.f11950f3.zn(t2, znVar);
    }

    public void a8(boolean z2) {
        if (z2 && this.f11948d0 == null) {
            this.f11948d0 = new i2.y();
        }
        this.f11945c = z2;
    }

    public void b(float f4) {
        this.f11950f3.i9(f4);
        if (this.f11956mt != null) {
            for (int i = 0; i < this.f11956mt.y().size(); i++) {
                this.f11956mt.y().get(i).tl(f4);
            }
        }
        vn.gv gvVar = this.f11947co;
        if (gvVar != null) {
            gvVar.tl(f4);
        }
        n3 n3Var = this.f11970z;
        if (n3Var != null) {
            n3Var.b(f4);
        }
        for (int i5 = 0; i5 < this.f11954i4.size(); i5++) {
            this.f11954i4.get(i5).tl(f4);
        }
    }

    public boolean c() {
        vn.s sVar = this.f11956mt;
        if (sVar != null && !sVar.y().isEmpty()) {
            return true;
        }
        return false;
    }

    public void c5(@Nullable vn.y<?, ?> yVar) {
        if (yVar == null) {
            return;
        }
        this.f11954i4.add(yVar);
    }

    public final void co(Canvas canvas) {
        yk.zn.y("Layer#clearLayer");
        RectF rectF = this.f11946c5;
        canvas.drawRect(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f, this.f11962s);
        yk.zn.n3("Layer#clearLayer");
    }

    public final void d(float f4) {
        this.f11966w.d().wz().y(this.f11959p.c5(), f4);
    }

    public boolean d0() {
        if (this.f11970z != null) {
            return true;
        }
        return false;
    }

    public final void f(Canvas canvas, Matrix matrix, vn.y<wz, Path> yVar, vn.y<Integer, Integer> yVar2) {
        br.s.tl(canvas, this.f11946c5, this.f11965v);
        this.y.set(yVar.s());
        this.y.transform(matrix);
        this.f11953gv.setAlpha((int) (yVar2.s().intValue() * 2.55f));
        canvas.drawPath(this.y, this.f11953gv);
        canvas.restore();
    }

    @Nullable
    public i9 f3() {
        return this.f11959p.zn();
    }

    @Override // i3.v
    public void fb(Canvas canvas, Matrix matrix, int i) {
        int i5;
        Paint paint;
        Integer s2;
        yk.zn.y(this.f11967wz);
        if (this.f11957n && !this.f11959p.f3()) {
            mt();
            yk.zn.y("Layer#parentMatrix");
            this.f11958n3.reset();
            this.f11958n3.set(matrix);
            for (int size = this.f11968x4.size() - 1; size >= 0; size--) {
                this.f11958n3.preConcat(this.f11968x4.get(size).f11950f3.a());
            }
            yk.zn.n3("Layer#parentMatrix");
            vn.y<?, Integer> s3 = this.f11950f3.s();
            if (s3 != null && (s2 = s3.s()) != null) {
                i5 = s2.intValue();
            } else {
                i5 = 100;
            }
            int i6 = (int) ((((i / 255.0f) * i5) / 100.0f) * 255.0f);
            if (!d0() && !c()) {
                this.f11958n3.preConcat(this.f11950f3.a());
                yk.zn.y("Layer#drawLayer");
                z(canvas, this.f11958n3, i6);
                yk.zn.n3("Layer#drawLayer");
                d(yk.zn.n3(this.f11967wz));
                return;
            }
            yk.zn.y("Layer#computeBounds");
            gv(this.f11946c5, this.f11958n3, false);
            rz(this.f11946c5, matrix);
            this.f11958n3.preConcat(this.f11950f3.a());
            fh(this.f11946c5, this.f11958n3);
            this.f11955i9.set(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight());
            canvas.getMatrix(this.f11971zn);
            if (!this.f11971zn.isIdentity()) {
                Matrix matrix2 = this.f11971zn;
                matrix2.invert(matrix2);
                this.f11971zn.mapRect(this.f11955i9);
            }
            if (!this.f11946c5.intersect(this.f11955i9)) {
                this.f11946c5.set(0.0f, 0.0f, 0.0f, 0.0f);
            }
            yk.zn.n3("Layer#computeBounds");
            if (this.f11946c5.width() >= 1.0f && this.f11946c5.height() >= 1.0f) {
                yk.zn.y("Layer#saveLayer");
                this.f11953gv.setAlpha(255);
                br.s.tl(canvas, this.f11946c5, this.f11953gv);
                yk.zn.n3("Layer#saveLayer");
                co(canvas);
                yk.zn.y("Layer#drawLayer");
                z(canvas, this.f11958n3, i6);
                yk.zn.n3("Layer#drawLayer");
                if (c()) {
                    xc(canvas, this.f11958n3);
                }
                if (d0()) {
                    yk.zn.y("Layer#drawMatte");
                    yk.zn.y("Layer#saveLayer");
                    br.s.wz(canvas, this.f11946c5, this.f11951fb, 19);
                    yk.zn.n3("Layer#saveLayer");
                    co(canvas);
                    this.f11970z.fb(canvas, matrix, i6);
                    yk.zn.y("Layer#restoreLayer");
                    canvas.restore();
                    yk.zn.n3("Layer#restoreLayer");
                    yk.zn.n3("Layer#drawMatte");
                }
                yk.zn.y("Layer#restoreLayer");
                canvas.restore();
                yk.zn.n3("Layer#restoreLayer");
            }
            if (this.f11945c && (paint = this.f11948d0) != null) {
                paint.setStyle(Paint.Style.STROKE);
                this.f11948d0.setColor(-251901);
                this.f11948d0.setStrokeWidth(4.0f);
                canvas.drawRect(this.f11946c5, this.f11948d0);
                this.f11948d0.setStyle(Paint.Style.FILL);
                this.f11948d0.setColor(1357638635);
                canvas.drawRect(this.f11946c5, this.f11948d0);
            }
            d(yk.zn.n3(this.f11967wz));
            return;
        }
        yk.zn.n3(this.f11967wz);
    }

    public final void fh(RectF rectF, Matrix matrix) {
        this.f11949f.set(0.0f, 0.0f, 0.0f, 0.0f);
        if (!c()) {
            return;
        }
        int size = this.f11956mt.n3().size();
        for (int i = 0; i < size; i++) {
            wm.s sVar = this.f11956mt.n3().get(i);
            Path s2 = this.f11956mt.y().get(i).s();
            if (s2 != null) {
                this.y.set(s2);
                this.y.transform(matrix);
                int i5 = y.f11972n3[sVar.y().ordinal()];
                if (i5 != 1 && i5 != 2) {
                    if ((i5 == 3 || i5 == 4) && sVar.gv()) {
                        return;
                    }
                    this.y.computeBounds(this.f11964tl, false);
                    if (i == 0) {
                        this.f11949f.set(this.f11964tl);
                    } else {
                        RectF rectF2 = this.f11949f;
                        rectF2.set(Math.min(rectF2.left, this.f11964tl.left), Math.min(this.f11949f.top, this.f11964tl.top), Math.max(this.f11949f.right, this.f11964tl.right), Math.max(this.f11949f.bottom, this.f11964tl.bottom));
                    }
                } else {
                    return;
                }
            }
        }
        if (!rectF.intersect(this.f11949f)) {
            rectF.set(0.0f, 0.0f, 0.0f, 0.0f);
        }
    }

    @Override // i3.zn
    public String getName() {
        return this.f11959p.c5();
    }

    @Override // i3.v
    public void gv(RectF rectF, Matrix matrix, boolean z2) {
        this.f11946c5.set(0.0f, 0.0f, 0.0f, 0.0f);
        mt();
        this.f11969xc.set(matrix);
        if (z2) {
            List<n3> list = this.f11968x4;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    this.f11969xc.preConcat(this.f11968x4.get(size).f11950f3.a());
                }
            } else {
                n3 n3Var = this.f11960r;
                if (n3Var != null) {
                    this.f11969xc.preConcat(n3Var.f11950f3.a());
                }
            }
        }
        this.f11969xc.preConcat(this.f11950f3.a());
    }

    public BlurMaskFilter i4(float f4) {
        if (this.f11952fh == f4) {
            return this.f11961rz;
        }
        BlurMaskFilter blurMaskFilter = new BlurMaskFilter(f4 / 2.0f, BlurMaskFilter.Blur.NORMAL);
        this.f11961rz = blurMaskFilter;
        this.f11952fh = f4;
        return blurMaskFilter;
    }

    public final void i9(Canvas canvas, Matrix matrix, vn.y<wz, Path> yVar, vn.y<Integer, Integer> yVar2) {
        this.y.set(yVar.s());
        this.y.transform(matrix);
        this.f11953gv.setAlpha((int) (yVar2.s().intValue() * 2.55f));
        canvas.drawPath(this.y, this.f11953gv);
    }

    public final void k5(boolean z2) {
        if (z2 != this.f11957n) {
            this.f11957n = z2;
            mg();
        }
    }

    public final void mg() {
        this.f11966w.invalidateSelf();
    }

    public final void mt() {
        if (this.f11968x4 != null) {
            return;
        }
        if (this.f11960r == null) {
            this.f11968x4 = Collections.emptyList();
            return;
        }
        this.f11968x4 = new ArrayList();
        for (n3 n3Var = this.f11960r; n3Var != null; n3Var = n3Var.f11960r) {
            this.f11968x4.add(n3Var);
        }
    }

    public v n() {
        return this.f11959p;
    }

    public final boolean p() {
        if (this.f11956mt.y().isEmpty()) {
            return false;
        }
        for (int i = 0; i < this.f11956mt.n3().size(); i++) {
            if (this.f11956mt.n3().get(i).y() != s.y.MASK_MODE_NONE) {
                return false;
            }
        }
        return true;
    }

    public final void rz(RectF rectF, Matrix matrix) {
        if (!d0() || this.f11959p.s() == v.n3.INVERT) {
            return;
        }
        this.f11963t.set(0.0f, 0.0f, 0.0f, 0.0f);
        this.f11970z.gv(this.f11963t, matrix, true);
        if (!rectF.intersect(this.f11963t)) {
            rectF.set(0.0f, 0.0f, 0.0f, 0.0f);
        }
    }

    public final void t(Canvas canvas, Matrix matrix, vn.y<wz, Path> yVar, vn.y<Integer, Integer> yVar2) {
        br.s.tl(canvas, this.f11946c5, this.f11953gv);
        canvas.drawRect(this.f11946c5, this.f11953gv);
        this.y.set(yVar.s());
        this.y.transform(matrix);
        this.f11953gv.setAlpha((int) (yVar2.s().intValue() * 2.55f));
        canvas.drawPath(this.y, this.f11944a);
        canvas.restore();
    }

    public final /* synthetic */ void ta() {
        boolean z2;
        if (this.f11947co.w() == 1.0f) {
            z2 = true;
        } else {
            z2 = false;
        }
        k5(z2);
    }

    public final void tl(Canvas canvas, Matrix matrix, vn.y<wz, Path> yVar, vn.y<Integer, Integer> yVar2) {
        br.s.tl(canvas, this.f11946c5, this.f11965v);
        canvas.drawRect(this.f11946c5, this.f11953gv);
        this.f11944a.setAlpha((int) (yVar2.s().intValue() * 2.55f));
        this.y.set(yVar.s());
        this.y.transform(matrix);
        canvas.drawPath(this.y, this.f11944a);
        canvas.restore();
    }

    public void ud(@Nullable n3 n3Var) {
        this.f11970z = n3Var;
    }

    public final void w(Canvas canvas, Matrix matrix, vn.y<wz, Path> yVar) {
        this.y.set(yVar.s());
        this.y.transform(matrix);
        canvas.drawPath(this.y, this.f11944a);
    }

    public final void wz(Canvas canvas, Matrix matrix, vn.y<wz, Path> yVar, vn.y<Integer, Integer> yVar2) {
        br.s.tl(canvas, this.f11946c5, this.f11944a);
        canvas.drawRect(this.f11946c5, this.f11953gv);
        this.f11944a.setAlpha((int) (yVar2.s().intValue() * 2.55f));
        this.y.set(yVar.s());
        this.y.transform(matrix);
        canvas.drawPath(this.y, this.f11944a);
        canvas.restore();
    }

    public void x(@Nullable n3 n3Var) {
        this.f11960r = n3Var;
    }

    @Nullable
    public wm.y x4() {
        return this.f11959p.y();
    }

    public final void xc(Canvas canvas, Matrix matrix) {
        yk.zn.y("Layer#saveLayer");
        br.s.wz(canvas, this.f11946c5, this.f11965v, 19);
        if (Build.VERSION.SDK_INT < 28) {
            co(canvas);
        }
        yk.zn.n3("Layer#saveLayer");
        for (int i = 0; i < this.f11956mt.n3().size(); i++) {
            wm.s sVar = this.f11956mt.n3().get(i);
            vn.y<wz, Path> yVar = this.f11956mt.y().get(i);
            vn.y<Integer, Integer> yVar2 = this.f11956mt.zn().get(i);
            int i5 = y.f11972n3[sVar.y().ordinal()];
            if (i5 != 1) {
                if (i5 != 2) {
                    if (i5 != 3) {
                        if (i5 == 4) {
                            if (sVar.gv()) {
                                t(canvas, matrix, yVar, yVar2);
                            } else {
                                i9(canvas, matrix, yVar, yVar2);
                            }
                        }
                    } else if (sVar.gv()) {
                        tl(canvas, matrix, yVar, yVar2);
                    } else {
                        f(canvas, matrix, yVar, yVar2);
                    }
                } else {
                    if (i == 0) {
                        this.f11953gv.setColor(-16777216);
                        this.f11953gv.setAlpha(255);
                        canvas.drawRect(this.f11946c5, this.f11953gv);
                    }
                    if (sVar.gv()) {
                        wz(canvas, matrix, yVar, yVar2);
                    } else {
                        w(canvas, matrix, yVar);
                    }
                }
            } else if (p()) {
                this.f11953gv.setAlpha(255);
                canvas.drawRect(this.f11946c5, this.f11953gv);
            }
        }
        yk.zn.y("Layer#restoreLayer");
        canvas.restore();
        yk.zn.n3("Layer#restoreLayer");
    }

    @Override // vn.y.n3
    public void y() {
        mg();
    }

    public final void yt() {
        boolean z2 = true;
        if (!this.f11959p.v().isEmpty()) {
            vn.gv gvVar = new vn.gv(this.f11959p.v());
            this.f11947co = gvVar;
            gvVar.t();
            this.f11947co.y(new y.n3() { // from class: nd.y
                @Override // vn.y.n3
                public final void y() {
                    n3.this.ta();
                }
            });
            if (this.f11947co.s().floatValue() != 1.0f) {
                z2 = false;
            }
            k5(z2);
            c5(this.f11947co);
            return;
        }
        k5(true);
    }

    public abstract void z(Canvas canvas, Matrix matrix, int i);

    public void z6(vn.y<?, ?> yVar) {
        this.f11954i4.remove(yVar);
    }

    @Override // ne.a
    public void zn(ne.v vVar, int i, List<ne.v> list, ne.v vVar2) {
        n3 n3Var = this.f11970z;
        if (n3Var != null) {
            ne.v y2 = vVar2.y(n3Var.getName());
            if (vVar.zn(this.f11970z.getName(), i)) {
                list.add(y2.c5(this.f11970z));
            }
            if (vVar.s(getName(), i)) {
                this.f11970z.ej(vVar, vVar.v(this.f11970z.getName(), i) + i, list, y2);
            }
        }
        if (!vVar.fb(getName(), i)) {
            return;
        }
        if (!"__container".equals(getName())) {
            vVar2 = vVar2.y(getName());
            if (vVar.zn(getName(), i)) {
                list.add(vVar2.c5(this));
            }
        }
        if (vVar.s(getName(), i)) {
            ej(vVar, i + vVar.v(getName(), i), list, vVar2);
        }
    }

    @Override // i3.zn
    public void n3(List<i3.zn> list, List<i3.zn> list2) {
    }

    public void ej(ne.v vVar, int i, List<ne.v> list, ne.v vVar2) {
    }
}
