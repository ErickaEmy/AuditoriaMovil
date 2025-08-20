package vn;

import android.graphics.Matrix;
import android.graphics.PointF;
import androidx.annotation.Nullable;
import java.util.Collections;
import nd.n3;
import q.t;
import uo.zn;
import vn.y;
import yk.ud;
/* loaded from: classes.dex */
public class w {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    public y<PointF, PointF> f14460a;
    @Nullable

    /* renamed from: c5  reason: collision with root package name */
    public y<Float, Float> f14461c5;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public gv f14462f;
    @Nullable

    /* renamed from: fb  reason: collision with root package name */
    public y<?, PointF> f14463fb;

    /* renamed from: gv  reason: collision with root package name */
    public final Matrix f14464gv;
    @Nullable

    /* renamed from: i9  reason: collision with root package name */
    public y<Integer, Integer> f14465i9;

    /* renamed from: n3  reason: collision with root package name */
    public final Matrix f14466n3;
    @Nullable

    /* renamed from: s  reason: collision with root package name */
    public y<uo.gv, uo.gv> f14467s;
    @Nullable

    /* renamed from: t  reason: collision with root package name */
    public gv f14468t;
    @Nullable

    /* renamed from: tl  reason: collision with root package name */
    public y<?, Float> f14469tl;

    /* renamed from: v  reason: collision with root package name */
    public final float[] f14470v;
    @Nullable

    /* renamed from: wz  reason: collision with root package name */
    public y<?, Float> f14471wz;
    public final Matrix y = new Matrix();

    /* renamed from: zn  reason: collision with root package name */
    public final Matrix f14472zn;

    public w(t tVar) {
        y<PointF, PointF> y;
        y<PointF, PointF> y2;
        y<uo.gv, uo.gv> y7;
        y<Float, Float> y8;
        gv gvVar;
        gv gvVar2;
        if (tVar.zn() == null) {
            y = null;
        } else {
            y = tVar.zn().y();
        }
        this.f14460a = y;
        if (tVar.a() == null) {
            y2 = null;
        } else {
            y2 = tVar.a().y();
        }
        this.f14463fb = y2;
        if (tVar.s() == null) {
            y7 = null;
        } else {
            y7 = tVar.s().y();
        }
        this.f14467s = y7;
        if (tVar.fb() == null) {
            y8 = null;
        } else {
            y8 = tVar.fb().y();
        }
        this.f14461c5 = y8;
        if (tVar.c5() == null) {
            gvVar = null;
        } else {
            gvVar = (gv) tVar.c5().y();
        }
        this.f14462f = gvVar;
        if (gvVar != null) {
            this.f14466n3 = new Matrix();
            this.f14472zn = new Matrix();
            this.f14464gv = new Matrix();
            this.f14470v = new float[9];
        } else {
            this.f14466n3 = null;
            this.f14472zn = null;
            this.f14464gv = null;
            this.f14470v = null;
        }
        if (tVar.i9() == null) {
            gvVar2 = null;
        } else {
            gvVar2 = (gv) tVar.i9().y();
        }
        this.f14468t = gvVar2;
        if (tVar.v() != null) {
            this.f14465i9 = tVar.v().y();
        }
        if (tVar.f() != null) {
            this.f14469tl = tVar.f().y();
        } else {
            this.f14469tl = null;
        }
        if (tVar.gv() != null) {
            this.f14471wz = tVar.gv().y();
        } else {
            this.f14471wz = null;
        }
    }

    public Matrix a() {
        PointF s2;
        float cos;
        float sin;
        float w4;
        PointF s3;
        this.y.reset();
        y<?, PointF> yVar = this.f14463fb;
        if (yVar != null && (s3 = yVar.s()) != null) {
            float f4 = s3.x;
            if (f4 != 0.0f || s3.y != 0.0f) {
                this.y.preTranslate(f4, s3.y);
            }
        }
        y<Float, Float> yVar2 = this.f14461c5;
        if (yVar2 != null) {
            if (yVar2 instanceof p) {
                w4 = yVar2.s().floatValue();
            } else {
                w4 = ((gv) yVar2).w();
            }
            if (w4 != 0.0f) {
                this.y.preRotate(w4);
            }
        }
        gv gvVar = this.f14462f;
        if (gvVar != null) {
            gv gvVar2 = this.f14468t;
            if (gvVar2 == null) {
                cos = 0.0f;
            } else {
                cos = (float) Math.cos(Math.toRadians((-gvVar2.w()) + 90.0f));
            }
            gv gvVar3 = this.f14468t;
            if (gvVar3 == null) {
                sin = 1.0f;
            } else {
                sin = (float) Math.sin(Math.toRadians((-gvVar3.w()) + 90.0f));
            }
            float tan = (float) Math.tan(Math.toRadians(gvVar.w()));
            gv();
            float[] fArr = this.f14470v;
            fArr[0] = cos;
            fArr[1] = sin;
            float f6 = -sin;
            fArr[3] = f6;
            fArr[4] = cos;
            fArr[8] = 1.0f;
            this.f14466n3.setValues(fArr);
            gv();
            float[] fArr2 = this.f14470v;
            fArr2[0] = 1.0f;
            fArr2[3] = tan;
            fArr2[4] = 1.0f;
            fArr2[8] = 1.0f;
            this.f14472zn.setValues(fArr2);
            gv();
            float[] fArr3 = this.f14470v;
            fArr3[0] = cos;
            fArr3[1] = f6;
            fArr3[3] = sin;
            fArr3[4] = cos;
            fArr3[8] = 1.0f;
            this.f14464gv.setValues(fArr3);
            this.f14472zn.preConcat(this.f14466n3);
            this.f14464gv.preConcat(this.f14472zn);
            this.y.preConcat(this.f14464gv);
        }
        y<uo.gv, uo.gv> yVar3 = this.f14467s;
        if (yVar3 != null) {
            uo.gv s4 = yVar3.s();
            if (s4.n3() != 1.0f || s4.zn() != 1.0f) {
                this.y.preScale(s4.n3(), s4.zn());
            }
        }
        y<PointF, PointF> yVar4 = this.f14460a;
        if (yVar4 != null && (((s2 = yVar4.s()) != null && s2.x != 0.0f) || s2.y != 0.0f)) {
            this.y.preTranslate(-s2.x, -s2.y);
        }
        return this.y;
    }

    @Nullable
    public y<?, Float> c5() {
        return this.f14469tl;
    }

    public Matrix fb(float f4) {
        PointF s2;
        uo.gv s3;
        float f6;
        y<?, PointF> yVar = this.f14463fb;
        PointF pointF = null;
        if (yVar == null) {
            s2 = null;
        } else {
            s2 = yVar.s();
        }
        y<uo.gv, uo.gv> yVar2 = this.f14467s;
        if (yVar2 == null) {
            s3 = null;
        } else {
            s3 = yVar2.s();
        }
        this.y.reset();
        if (s2 != null) {
            this.y.preTranslate(s2.x * f4, s2.y * f4);
        }
        if (s3 != null) {
            double d2 = f4;
            this.y.preScale((float) Math.pow(s3.n3(), d2), (float) Math.pow(s3.zn(), d2));
        }
        y<Float, Float> yVar3 = this.f14461c5;
        if (yVar3 != null) {
            float floatValue = yVar3.s().floatValue();
            y<PointF, PointF> yVar4 = this.f14460a;
            if (yVar4 != null) {
                pointF = yVar4.s();
            }
            Matrix matrix = this.y;
            float f9 = floatValue * f4;
            float f10 = 0.0f;
            if (pointF == null) {
                f6 = 0.0f;
            } else {
                f6 = pointF.x;
            }
            if (pointF != null) {
                f10 = pointF.y;
            }
            matrix.preRotate(f9, f6, f10);
        }
        return this.y;
    }

    public final void gv() {
        for (int i = 0; i < 9; i++) {
            this.f14470v[i] = 0.0f;
        }
    }

    public void i9(float f4) {
        y<Integer, Integer> yVar = this.f14465i9;
        if (yVar != null) {
            yVar.tl(f4);
        }
        y<?, Float> yVar2 = this.f14469tl;
        if (yVar2 != null) {
            yVar2.tl(f4);
        }
        y<?, Float> yVar3 = this.f14471wz;
        if (yVar3 != null) {
            yVar3.tl(f4);
        }
        y<PointF, PointF> yVar4 = this.f14460a;
        if (yVar4 != null) {
            yVar4.tl(f4);
        }
        y<?, PointF> yVar5 = this.f14463fb;
        if (yVar5 != null) {
            yVar5.tl(f4);
        }
        y<uo.gv, uo.gv> yVar6 = this.f14467s;
        if (yVar6 != null) {
            yVar6.tl(f4);
        }
        y<Float, Float> yVar7 = this.f14461c5;
        if (yVar7 != null) {
            yVar7.tl(f4);
        }
        gv gvVar = this.f14462f;
        if (gvVar != null) {
            gvVar.tl(f4);
        }
        gv gvVar2 = this.f14468t;
        if (gvVar2 != null) {
            gvVar2.tl(f4);
        }
    }

    public void n3(y.n3 n3Var) {
        y<Integer, Integer> yVar = this.f14465i9;
        if (yVar != null) {
            yVar.y(n3Var);
        }
        y<?, Float> yVar2 = this.f14469tl;
        if (yVar2 != null) {
            yVar2.y(n3Var);
        }
        y<?, Float> yVar3 = this.f14471wz;
        if (yVar3 != null) {
            yVar3.y(n3Var);
        }
        y<PointF, PointF> yVar4 = this.f14460a;
        if (yVar4 != null) {
            yVar4.y(n3Var);
        }
        y<?, PointF> yVar5 = this.f14463fb;
        if (yVar5 != null) {
            yVar5.y(n3Var);
        }
        y<uo.gv, uo.gv> yVar6 = this.f14467s;
        if (yVar6 != null) {
            yVar6.y(n3Var);
        }
        y<Float, Float> yVar7 = this.f14461c5;
        if (yVar7 != null) {
            yVar7.y(n3Var);
        }
        gv gvVar = this.f14462f;
        if (gvVar != null) {
            gvVar.y(n3Var);
        }
        gv gvVar2 = this.f14468t;
        if (gvVar2 != null) {
            gvVar2.y(n3Var);
        }
    }

    @Nullable
    public y<?, Integer> s() {
        return this.f14465i9;
    }

    @Nullable
    public y<?, Float> v() {
        return this.f14471wz;
    }

    public void y(n3 n3Var) {
        n3Var.c5(this.f14465i9);
        n3Var.c5(this.f14469tl);
        n3Var.c5(this.f14471wz);
        n3Var.c5(this.f14460a);
        n3Var.c5(this.f14463fb);
        n3Var.c5(this.f14467s);
        n3Var.c5(this.f14461c5);
        n3Var.c5(this.f14462f);
        n3Var.c5(this.f14468t);
    }

    public <T> boolean zn(T t2, @Nullable zn<T> znVar) {
        if (t2 == ud.f15416a) {
            y<PointF, PointF> yVar = this.f14460a;
            if (yVar == null) {
                this.f14460a = new p(znVar, new PointF());
                return true;
            }
            yVar.wz(znVar);
            return true;
        } else if (t2 == ud.f15427fb) {
            y<?, PointF> yVar2 = this.f14463fb;
            if (yVar2 == null) {
                this.f14463fb = new p(znVar, new PointF());
                return true;
            }
            yVar2.wz(znVar);
            return true;
        } else {
            if (t2 == ud.f15440s) {
                wz wzVar = this.f14463fb;
                if (wzVar instanceof wz) {
                    wzVar.mt(znVar);
                    return true;
                }
            }
            if (t2 == ud.f15420c5) {
                wz wzVar2 = this.f14463fb;
                if (wzVar2 instanceof wz) {
                    wzVar2.co(znVar);
                    return true;
                }
            }
            if (t2 == ud.f15451xc) {
                y<uo.gv, uo.gv> yVar3 = this.f14467s;
                if (yVar3 == null) {
                    this.f14467s = new p(znVar, new uo.gv());
                    return true;
                }
                yVar3.wz(znVar);
                return true;
            } else if (t2 == ud.f15447w) {
                y<Float, Float> yVar4 = this.f14461c5;
                if (yVar4 == null) {
                    this.f14461c5 = new p(znVar, Float.valueOf(0.0f));
                    return true;
                }
                yVar4.wz(znVar);
                return true;
            } else if (t2 == ud.f15455zn) {
                y<Integer, Integer> yVar5 = this.f14465i9;
                if (yVar5 == null) {
                    this.f14465i9 = new p(znVar, 100);
                    return true;
                }
                yVar5.wz(znVar);
                return true;
            } else if (t2 == ud.f15439rz) {
                y<?, Float> yVar6 = this.f14469tl;
                if (yVar6 == null) {
                    this.f14469tl = new p(znVar, Float.valueOf(100.0f));
                    return true;
                }
                yVar6.wz(znVar);
                return true;
            } else if (t2 == ud.f15433mg) {
                y<?, Float> yVar7 = this.f14471wz;
                if (yVar7 == null) {
                    this.f14471wz = new p(znVar, Float.valueOf(100.0f));
                    return true;
                }
                yVar7.wz(znVar);
                return true;
            } else if (t2 == ud.f15437p) {
                if (this.f14462f == null) {
                    this.f14462f = new gv(Collections.singletonList(new uo.y(Float.valueOf(0.0f))));
                }
                this.f14462f.wz(znVar);
                return true;
            } else if (t2 == ud.f15434mt) {
                if (this.f14468t == null) {
                    this.f14468t = new gv(Collections.singletonList(new uo.y(Float.valueOf(0.0f))));
                }
                this.f14468t.wz(znVar);
                return true;
            } else {
                return false;
            }
        }
    }
}
