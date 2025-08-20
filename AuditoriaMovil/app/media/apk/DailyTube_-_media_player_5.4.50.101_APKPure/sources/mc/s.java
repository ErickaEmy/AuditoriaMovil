package mc;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.DashPathEffect;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.util.Base64;
import android.util.Log;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.Stack;
import mc.fb;
import mc.n3;
/* loaded from: classes.dex */
public class s {

    /* renamed from: c5  reason: collision with root package name */
    public static HashSet<String> f11463c5;

    /* renamed from: a  reason: collision with root package name */
    public Stack<fb.a8> f11464a;

    /* renamed from: fb  reason: collision with root package name */
    public Stack<Matrix> f11465fb;

    /* renamed from: gv  reason: collision with root package name */
    public s f11466gv;

    /* renamed from: n3  reason: collision with root package name */
    public float f11467n3;

    /* renamed from: s  reason: collision with root package name */
    public n3.p f11468s;

    /* renamed from: v  reason: collision with root package name */
    public Stack<s> f11469v;
    public Canvas y;

    /* renamed from: zn  reason: collision with root package name */
    public fb f11470zn;

    public s(Canvas canvas, float f4) {
        this.y = canvas;
        this.f11467n3 = f4;
    }

    public static float[] c5(double d2, double d3) {
        int ceil = (int) Math.ceil((Math.abs(d3) * 2.0d) / 3.141592653589793d);
        double d4 = d3 / ceil;
        double d5 = d4 / 2.0d;
        double sin = (Math.sin(d5) * 1.3333333333333333d) / (Math.cos(d5) + 1.0d);
        float[] fArr = new float[ceil * 6];
        int i = 0;
        int i5 = 0;
        while (i < ceil) {
            double d6 = d2 + (i * d4);
            double cos = Math.cos(d6);
            double sin2 = Math.sin(d6);
            double d7 = d4;
            fArr[i5] = (float) (cos - (sin * sin2));
            fArr[i5 + 1] = (float) (sin2 + (cos * sin));
            double d8 = d6 + d7;
            double cos2 = Math.cos(d8);
            double sin3 = Math.sin(d8);
            fArr[i5 + 2] = (float) ((sin * sin3) + cos2);
            fArr[i5 + 3] = (float) (sin3 - (sin * cos2));
            int i6 = i5 + 5;
            fArr[i5 + 4] = (float) cos2;
            i5 += 6;
            fArr[i6] = (float) sin3;
            i++;
            d4 = d7;
        }
        return fArr;
    }

    public static void d(String str, Object... objArr) {
        Log.e("SVGAndroidRenderer", String.format(str, objArr));
    }

    public static int f3(int i, float f4) {
        int i5 = 255;
        int round = Math.round(((i >> 24) & 255) * f4);
        if (round < 0) {
            i5 = 0;
        } else if (round <= 255) {
            i5 = round;
        }
        return (i & 16777215) | (i5 << 24);
    }

    public static void i3(String str, Object... objArr) {
        Log.w("SVGAndroidRenderer", String.format(str, objArr));
    }

    public static int i4(float f4) {
        int i = (int) (f4 * 256.0f);
        if (i < 0) {
            return 0;
        }
        if (i > 255) {
            return 255;
        }
        return i;
    }

    public static void s(float f4, float f6, float f9, float f10, float f11, boolean z2, boolean z3, float f12, float f13, fb.f3 f3Var) {
        float f14;
        fb.f3 f3Var2;
        double d2;
        double d3;
        if (f4 == f12 && f6 == f13) {
            return;
        }
        if (f9 != 0.0f) {
            if (f10 == 0.0f) {
                f3Var2 = f3Var;
                f14 = f12;
            } else {
                float abs = Math.abs(f9);
                float abs2 = Math.abs(f10);
                double radians = Math.toRadians(f11 % 360.0d);
                double cos = Math.cos(radians);
                double sin = Math.sin(radians);
                double d4 = (f4 - f12) / 2.0d;
                double d5 = (f6 - f13) / 2.0d;
                double d6 = (cos * d4) + (sin * d5);
                double d7 = ((-sin) * d4) + (d5 * cos);
                double d8 = abs * abs;
                double d10 = abs2 * abs2;
                double d11 = d6 * d6;
                double d12 = d7 * d7;
                double d13 = (d11 / d8) + (d12 / d10);
                if (d13 > 0.99999d) {
                    double sqrt = Math.sqrt(d13) * 1.00001d;
                    abs = (float) (abs * sqrt);
                    abs2 = (float) (sqrt * abs2);
                    d8 = abs * abs;
                    d10 = abs2 * abs2;
                }
                double d14 = 1.0d;
                if (z2 == z3) {
                    d2 = -1.0d;
                } else {
                    d2 = 1.0d;
                }
                double d15 = d8 * d10;
                double d16 = d8 * d12;
                double d17 = d10 * d11;
                double d18 = ((d15 - d16) - d17) / (d16 + d17);
                if (d18 < 0.0d) {
                    d18 = 0.0d;
                }
                double sqrt2 = d2 * Math.sqrt(d18);
                double d19 = abs;
                double d20 = abs2;
                double d21 = ((d19 * d7) / d20) * sqrt2;
                float f15 = abs;
                float f16 = abs2;
                double d22 = sqrt2 * (-((d20 * d6) / d19));
                double d23 = ((f4 + f12) / 2.0d) + ((cos * d21) - (sin * d22));
                double d24 = ((f6 + f13) / 2.0d) + (sin * d21) + (cos * d22);
                double d25 = (d6 - d21) / d19;
                double d26 = (d7 - d22) / d20;
                double d27 = ((-d6) - d21) / d19;
                double d28 = ((-d7) - d22) / d20;
                double d29 = (d25 * d25) + (d26 * d26);
                double sqrt3 = Math.sqrt(d29);
                if (d26 < 0.0d) {
                    d3 = -1.0d;
                } else {
                    d3 = 1.0d;
                }
                double acos = d3 * Math.acos(d25 / sqrt3);
                double sqrt4 = Math.sqrt(d29 * ((d27 * d27) + (d28 * d28)));
                double d30 = (d25 * d27) + (d26 * d28);
                if ((d25 * d28) - (d26 * d27) < 0.0d) {
                    d14 = -1.0d;
                }
                double x42 = d14 * x4(d30 / sqrt4);
                if (!z3 && x42 > 0.0d) {
                    x42 -= 6.283185307179586d;
                } else if (z3 && x42 < 0.0d) {
                    x42 += 6.283185307179586d;
                }
                float[] c52 = c5(acos % 6.283185307179586d, x42 % 6.283185307179586d);
                Matrix matrix = new Matrix();
                matrix.postScale(f15, f16);
                matrix.postRotate(f11);
                matrix.postTranslate((float) d23, (float) d24);
                matrix.mapPoints(c52);
                c52[c52.length - 2] = f12;
                c52[c52.length - 1] = f13;
                for (int i = 0; i < c52.length; i += 6) {
                    f3Var.zn(c52[i], c52[i + 1], c52[i + 2], c52[i + 3], c52[i + 4], c52[i + 5]);
                }
                return;
            }
        } else {
            f14 = f12;
            f3Var2 = f3Var;
        }
        f3Var2.v(f14, f13);
    }

    public static synchronized void ut() {
        synchronized (s.class) {
            HashSet<String> hashSet = new HashSet<>();
            f11463c5 = hashSet;
            hashSet.add("Structure");
            f11463c5.add("BasicStructure");
            f11463c5.add("ConditionalProcessing");
            f11463c5.add("Image");
            f11463c5.add("Style");
            f11463c5.add("ViewportAttribute");
            f11463c5.add("Shape");
            f11463c5.add("BasicText");
            f11463c5.add("PaintAttribute");
            f11463c5.add("BasicPaintAttribute");
            f11463c5.add("OpacityAttribute");
            f11463c5.add("BasicGraphicsAttribute");
            f11463c5.add("Marker");
            f11463c5.add("Gradient");
            f11463c5.add("Pattern");
            f11463c5.add("Clip");
            f11463c5.add("BasicClip");
            f11463c5.add("Mask");
            f11463c5.add("View");
        }
    }

    public static double x4(double d2) {
        if (d2 < -1.0d) {
            return 3.141592653589793d;
        }
        if (d2 > 1.0d) {
            return 0.0d;
        }
        return Math.acos(d2);
    }

    public final void a8(fb.j5 j5Var, fb.j5 j5Var2) {
        if (j5Var.tl == null) {
            j5Var.tl = j5Var2.tl;
        }
        if (j5Var.wz == null) {
            j5Var.wz = j5Var2.wz;
        }
        if (j5Var.xc == null) {
            j5Var.xc = j5Var2.xc;
        }
        if (j5Var.w == null) {
            j5Var.w = j5Var2.w;
        }
        if (j5Var.p == null) {
            j5Var.p = j5Var2.p;
        }
    }

    public void ad(fb fbVar, a aVar) {
        fb.n3 n3Var;
        fb.n3 n3Var2;
        v vVar;
        if (aVar != null) {
            this.f11470zn = fbVar;
            fb.d c52 = fbVar.c5();
            if (c52 == null) {
                i3("Nothing to render. Document is empty.", new Object[0]);
                return;
            }
            if (aVar.gv()) {
                fb.ct v2 = this.f11470zn.v(aVar.f11409v);
                if (v2 != null && (v2 instanceof fb.ct)) {
                    fb.ct ctVar = v2;
                    n3Var2 = ctVar.f11445w;
                    if (n3Var2 == null) {
                        Log.w("SVGAndroidRenderer", String.format("View element with id \"%s\" is missing a viewBox attribute.", aVar.f11409v));
                        return;
                    }
                    vVar = ctVar.f11441xc;
                } else {
                    Log.w("SVGAndroidRenderer", String.format("View element with id \"%s\" not found.", aVar.f11409v));
                    return;
                }
            } else {
                if (aVar.v()) {
                    n3Var = aVar.f11407gv;
                } else {
                    n3Var = c52.f11445w;
                }
                n3Var2 = n3Var;
                if (aVar.n3()) {
                    vVar = aVar.f11408n3;
                } else {
                    vVar = c52.f11441xc;
                }
            }
            if (aVar.y()) {
                fbVar.y(aVar.y);
            }
            if (aVar.zn()) {
                n3.p pVar = new n3.p();
                this.f11468s = pVar;
                pVar.y = fbVar.v(aVar.f11410zn);
            }
            oa();
            r(c52);
            mp();
            fb.n3 n3Var3 = new fb.n3(aVar.f11406a);
            fb.w wVar = c52.f11430co;
            if (wVar != null) {
                n3Var3.f11444zn = wVar.a(this, n3Var3.f11444zn);
            }
            fb.w wVar2 = c52.f11434z;
            if (wVar2 != null) {
                n3Var3.f11442gv = wVar2.a(this, n3Var3.f11442gv);
            }
            tg(c52, n3Var3, n3Var2, vVar);
            q5();
            if (aVar.y()) {
                fbVar.n3();
                return;
            }
            return;
        }
        throw new NullPointerException("renderOptions shouldn't be null");
    }

    public final void ap(fb.gv gvVar) {
        n("Circle render", new Object[0]);
        fb.w wVar = gvVar.p;
        if (wVar != null && !wVar.i9()) {
            ix(this.f11466gv, gvVar);
            if (!d0() || !i2()) {
                return;
            }
            Matrix matrix = ((fb.t) gvVar).wz;
            if (matrix != null) {
                this.y.concat(matrix);
            }
            Path f72 = f7(gvVar);
            cs(gvVar);
            mt(gvVar);
            w(gvVar);
            boolean e2 = e();
            if (this.f11466gv.n3) {
                fh(gvVar, f72);
            }
            if (this.f11466gv.zn) {
                rz(f72);
            }
            if (e2) {
                lc(gvVar);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x01fb A[LOOP:3: B:100:0x01f5->B:102:0x01fb, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0217  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0196  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b(mc.fb.x r20, android.graphics.Path r21, mc.fb.n r22) {
        /*
            Method dump skipped, instructions count: 542
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: mc.s.b(mc.fb$x, android.graphics.Path, mc.fb$n):void");
    }

    public final void bk(fb.d dVar) {
        tg(dVar, ct(dVar.f11432p, dVar.f11431mt, dVar.f11430co, dVar.f11434z), dVar.f11445w, dVar.f11441xc);
    }

    public final void c(boolean z2, fb.n3 n3Var, fb.r rVar) {
        String str;
        fb.yt wz2 = this.f11470zn.wz(rVar.y);
        if (wz2 == null) {
            if (z2) {
                str = "Fill";
            } else {
                str = "Stroke";
            }
            d("%s reference '%s' not found", str, rVar.y);
            fb.vl vlVar = rVar.v;
            if (vlVar != null) {
                w2(this.f11466gv, z2, vlVar);
            } else if (z2) {
                this.f11466gv.n3 = false;
            } else {
                this.f11466gv.zn = false;
            }
        } else if (wz2 instanceof fb.k5) {
            k(z2, n3Var, (fb.k5) wz2);
        } else if (wz2 instanceof fb.j5) {
            dm(z2, n3Var, (fb.j5) wz2);
        } else if (wz2 instanceof fb.rz) {
            x5(z2, (fb.rz) wz2);
        }
    }

    public final Bitmap co(String str) {
        int indexOf;
        if (!str.startsWith("data:") || str.length() < 14 || (indexOf = str.indexOf(44)) < 12 || !";base64".equals(str.substring(indexOf - 7, indexOf))) {
            return null;
        }
        try {
            byte[] decode = Base64.decode(str.substring(indexOf + 1), 0);
            return BitmapFactory.decodeByteArray(decode, 0, decode.length);
        } catch (Exception e2) {
            Log.e("SVGAndroidRenderer", "Could not decode bad Data URL", e2);
            return null;
        }
    }

    public final void cr(fb.j jVar, fb.n3 n3Var) {
        n("Symbol render", new Object[0]);
        if (n3Var.f11444zn != 0.0f && n3Var.f11442gv != 0.0f) {
            v vVar = jVar.f11441xc;
            if (vVar == null) {
                vVar = v.v;
            }
            ix(this.f11466gv, jVar);
            s sVar = this.f11466gv;
            sVar.a = n3Var;
            if (!sVar.y.qn.booleanValue()) {
                fb.n3 n3Var2 = this.f11466gv.a;
                w9(n3Var2.y, n3Var2.f11443n3, n3Var2.f11444zn, n3Var2.f11442gv);
            }
            fb.n3 n3Var3 = jVar.f11445w;
            if (n3Var3 != null) {
                this.y.concat(xc(this.f11466gv.a, n3Var3, vVar));
                this.f11466gv.fb = jVar.f11445w;
            } else {
                Canvas canvas = this.y;
                fb.n3 n3Var4 = this.f11466gv.a;
                canvas.translate(n3Var4.y, n3Var4.f11443n3);
            }
            boolean e2 = e();
            wf(jVar, true);
            if (e2) {
                lc(jVar);
            }
            cs(jVar);
        }
    }

    public final void cs(fb.x xVar) {
        if (xVar.f11457n3 == null || xVar.f11447s == null) {
            return;
        }
        Matrix matrix = new Matrix();
        if (this.f11465fb.peek().invert(matrix)) {
            fb.n3 n3Var = xVar.f11447s;
            float f4 = n3Var.y;
            float f6 = n3Var.f11443n3;
            float n32 = n3Var.n3();
            fb.n3 n3Var2 = xVar.f11447s;
            float f9 = n3Var2.f11443n3;
            float n33 = n3Var2.n3();
            float zn2 = xVar.f11447s.zn();
            fb.n3 n3Var3 = xVar.f11447s;
            float[] fArr = {f4, f6, n32, f9, n33, zn2, n3Var3.y, n3Var3.zn()};
            matrix.preConcat(this.y.getMatrix());
            matrix.mapPoints(fArr);
            float f10 = fArr[0];
            float f11 = fArr[1];
            RectF rectF = new RectF(f10, f11, f10, f11);
            for (int i = 2; i <= 6; i += 2) {
                float f12 = fArr[i];
                if (f12 < rectF.left) {
                    rectF.left = f12;
                }
                if (f12 > rectF.right) {
                    rectF.right = f12;
                }
                float f13 = fArr[i + 1];
                if (f13 < rectF.top) {
                    rectF.top = f13;
                }
                if (f13 > rectF.bottom) {
                    rectF.bottom = f13;
                }
            }
            fb.x xVar2 = (fb.x) this.f11464a.peek();
            fb.n3 n3Var4 = xVar2.f11447s;
            if (n3Var4 == null) {
                xVar2.f11447s = fb.n3.y(rectF.left, rectF.top, rectF.right, rectF.bottom);
            } else {
                n3Var4.gv(fb.n3.y(rectF.left, rectF.top, rectF.right, rectF.bottom));
            }
        }
    }

    public final fb.n3 ct(fb.w wVar, fb.w wVar2, fb.w wVar3, fb.w wVar4) {
        float f4;
        float f6;
        float f9;
        float f10 = 0.0f;
        if (wVar != null) {
            f4 = wVar.fb(this);
        } else {
            f4 = 0.0f;
        }
        if (wVar2 != null) {
            f10 = wVar2.s(this);
        }
        fb.n3 o2 = o();
        if (wVar3 != null) {
            f6 = wVar3.fb(this);
        } else {
            f6 = o2.f11444zn;
        }
        if (wVar4 != null) {
            f9 = wVar4.s(this);
        } else {
            f9 = o2.f11442gv;
        }
        return new fb.n3(f4, f10, f6, f9);
    }

    /* JADX WARN: Code restructure failed: missing block: B:63:0x0106, code lost:
        if (r7 != 8) goto L53;
     */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x014f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void cy(mc.fb.mt r12, mc.s.zn r13) {
        /*
            Method dump skipped, instructions count: 358
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: mc.s.cy(mc.fb$mt, mc.s$zn):void");
    }

    public final boolean d0() {
        Boolean bool = this.f11466gv.y.q9;
        if (bool != null) {
            return bool.booleanValue();
        }
        return true;
    }

    public final void dm(boolean z2, fb.n3 n3Var, fb.j5 j5Var) {
        boolean z3;
        Paint paint;
        float f4;
        float f6;
        float f9;
        float f10;
        float f11;
        float fb2;
        float s2;
        float gv2;
        String str = ((fb.i9) j5Var).t;
        if (str != null) {
            ej(j5Var, str);
        }
        Boolean bool = ((fb.i9) j5Var).c5;
        int i = 0;
        if (bool != null && bool.booleanValue()) {
            z3 = true;
        } else {
            z3 = false;
        }
        s sVar = this.f11466gv;
        if (z2) {
            paint = sVar.gv;
        } else {
            paint = sVar.v;
        }
        if (z3) {
            fb.w wVar = new fb.w(50.0f, fb.xg.percent);
            fb.w wVar2 = j5Var.tl;
            if (wVar2 != null) {
                fb2 = wVar2.fb(this);
            } else {
                fb2 = wVar.fb(this);
            }
            fb.w wVar3 = j5Var.wz;
            if (wVar3 != null) {
                s2 = wVar3.s(this);
            } else {
                s2 = wVar.s(this);
            }
            fb.w wVar4 = j5Var.xc;
            if (wVar4 != null) {
                gv2 = wVar4.gv(this);
            } else {
                gv2 = wVar.gv(this);
            }
            f10 = gv2;
            f9 = fb2;
            f11 = s2;
        } else {
            fb.w wVar5 = j5Var.tl;
            float f12 = 0.5f;
            if (wVar5 != null) {
                f4 = wVar5.a(this, 1.0f);
            } else {
                f4 = 0.5f;
            }
            fb.w wVar6 = j5Var.wz;
            if (wVar6 != null) {
                f6 = wVar6.a(this, 1.0f);
            } else {
                f6 = 0.5f;
            }
            fb.w wVar7 = j5Var.xc;
            if (wVar7 != null) {
                f12 = wVar7.a(this, 1.0f);
            }
            f9 = f4;
            f10 = f12;
            f11 = f6;
        }
        mp();
        this.f11466gv = k5(j5Var);
        Matrix matrix = new Matrix();
        if (!z3) {
            matrix.preTranslate(n3Var.y, n3Var.f11443n3);
            matrix.preScale(n3Var.f11444zn, n3Var.f11442gv);
        }
        Matrix matrix2 = ((fb.i9) j5Var).i9;
        if (matrix2 != null) {
            matrix.preConcat(matrix2);
        }
        int size = ((fb.i9) j5Var).s.size();
        if (size == 0) {
            q5();
            if (z2) {
                this.f11466gv.n3 = false;
                return;
            } else {
                this.f11466gv.zn = false;
                return;
            }
        }
        int[] iArr = new int[size];
        float[] fArr = new float[size];
        Iterator it = ((fb.i9) j5Var).s.iterator();
        float f13 = -1.0f;
        while (true) {
            float f14 = 0.0f;
            if (!it.hasNext()) {
                break;
            }
            fb.mg mgVar = (fb.yt) it.next();
            Float f15 = mgVar.s;
            if (f15 != null) {
                f14 = f15.floatValue();
            }
            if (i != 0 && f14 < f13) {
                fArr[i] = f13;
            } else {
                fArr[i] = f14;
                f13 = f14;
            }
            mp();
            ix(this.f11466gv, mgVar);
            fb.ta taVar = this.f11466gv.y;
            fb.a aVar = taVar.f7;
            if (aVar == null) {
                aVar = fb.a.v;
            }
            iArr[i] = f3(aVar.y, taVar.en.floatValue());
            i++;
            q5();
        }
        if (f10 != 0.0f && size != 1) {
            Shader.TileMode tileMode = Shader.TileMode.CLAMP;
            fb.f fVar = ((fb.i9) j5Var).f;
            if (fVar != null) {
                if (fVar == fb.f.v) {
                    tileMode = Shader.TileMode.MIRROR;
                } else if (fVar == fb.f.fb) {
                    tileMode = Shader.TileMode.REPEAT;
                }
            }
            Shader.TileMode tileMode2 = tileMode;
            q5();
            RadialGradient radialGradient = new RadialGradient(f9, f11, f10, iArr, fArr, tileMode2);
            radialGradient.setLocalMatrix(matrix);
            paint.setShader(radialGradient);
            paint.setAlpha(i4(this.f11466gv.y.s.floatValue()));
            return;
        }
        q5();
        paint.setColor(iArr[size - 1]);
    }

    public final boolean e() {
        fb.yt wz2;
        if (!vp()) {
            return false;
        }
        this.y.saveLayerAlpha(null, i4(this.f11466gv.y.n.floatValue()), 31);
        this.f11469v.push(this.f11466gv);
        s sVar = new s(this, this.f11466gv);
        this.f11466gv = sVar;
        String str = sVar.y.y5;
        if (str != null && ((wz2 = this.f11470zn.wz(str)) == null || !(wz2 instanceof fb.co))) {
            d("Mask reference '%s' not found", this.f11466gv.y.y5);
            this.f11466gv.y.y5 = null;
        }
        return true;
    }

    public final void eb(fb.a8 a8Var) {
        this.f11464a.push(a8Var);
        this.f11465fb.push(this.y.getMatrix());
    }

    public final void ej(fb.i9 i9Var, String str) {
        fb.i9 wz2 = i9Var.y.wz(str);
        if (wz2 == null) {
            i3("Gradient reference '%s' not found", str);
        } else if (!(wz2 instanceof fb.i9)) {
            d("Gradient href attributes must point to other gradient elements", new Object[0]);
        } else if (wz2 == i9Var) {
            d("Circular reference in gradient href attribute '%s'", str);
        } else {
            fb.i9 i9Var2 = wz2;
            if (i9Var.c5 == null) {
                i9Var.c5 = i9Var2.c5;
            }
            if (i9Var.i9 == null) {
                i9Var.i9 = i9Var2.i9;
            }
            if (i9Var.f == null) {
                i9Var.f = i9Var2.f;
            }
            if (i9Var.s.isEmpty()) {
                i9Var.s = i9Var2.s;
            }
            try {
                if (i9Var instanceof fb.k5) {
                    ud((fb.k5) i9Var, (fb.k5) wz2);
                } else {
                    a8((fb.j5) i9Var, (fb.j5) wz2);
                }
            } catch (ClassCastException unused) {
            }
            String str2 = i9Var2.t;
            if (str2 != null) {
                ej(i9Var, str2);
            }
        }
    }

    public final Path en(fb.c5 c5Var) {
        float f4;
        fb.w wVar = c5Var.xc;
        float f6 = 0.0f;
        if (wVar != null) {
            f4 = wVar.fb(this);
        } else {
            f4 = 0.0f;
        }
        fb.w wVar2 = c5Var.w;
        if (wVar2 != null) {
            f6 = wVar2.s(this);
        }
        float fb2 = c5Var.p.fb(this);
        float s2 = c5Var.mt.s(this);
        float f9 = f4 - fb2;
        float f10 = f6 - s2;
        float f11 = f4 + fb2;
        float f12 = f6 + s2;
        if (c5Var.f11447s == null) {
            c5Var.f11447s = new fb.n3(f9, f10, fb2 * 2.0f, 2.0f * s2);
        }
        float f13 = fb2 * 0.5522848f;
        float f14 = 0.5522848f * s2;
        Path path = new Path();
        path.moveTo(f4, f10);
        float f15 = f4 + f13;
        float f16 = f6 - f14;
        path.cubicTo(f15, f10, f11, f16, f11, f6);
        float f17 = f14 + f6;
        path.cubicTo(f11, f17, f15, f12, f4, f12);
        float f18 = f4 - f13;
        path.cubicTo(f18, f12, f9, f17, f9, f6);
        path.cubicTo(f9, f16, f18, f10, f4, f10);
        path.close();
        return path;
    }

    public final List<zn> f(fb.p pVar) {
        float f4;
        float f6;
        float f9;
        float f10;
        fb.w wVar = pVar.xc;
        if (wVar != null) {
            f4 = wVar.fb(this);
        } else {
            f4 = 0.0f;
        }
        fb.w wVar2 = pVar.w;
        if (wVar2 != null) {
            f6 = wVar2.s(this);
        } else {
            f6 = 0.0f;
        }
        fb.w wVar3 = pVar.p;
        if (wVar3 != null) {
            f9 = wVar3.fb(this);
        } else {
            f9 = 0.0f;
        }
        fb.w wVar4 = pVar.mt;
        if (wVar4 != null) {
            f10 = wVar4.s(this);
        } else {
            f10 = 0.0f;
        }
        ArrayList arrayList = new ArrayList(2);
        float f11 = f9 - f4;
        float f12 = f10 - f6;
        arrayList.add(new zn(this, f4, f6, f11, f12));
        arrayList.add(new zn(this, f9, f10, f11, f12));
        return arrayList;
    }

    public final Path f7(fb.gv gvVar) {
        float f4;
        fb.w wVar = gvVar.xc;
        float f6 = 0.0f;
        if (wVar != null) {
            f4 = wVar.fb(this);
        } else {
            f4 = 0.0f;
        }
        fb.w wVar2 = gvVar.w;
        if (wVar2 != null) {
            f6 = wVar2.s(this);
        }
        float gv2 = gvVar.p.gv(this);
        float f9 = f4 - gv2;
        float f10 = f6 - gv2;
        float f11 = f4 + gv2;
        float f12 = f6 + gv2;
        if (gvVar.f11447s == null) {
            float f13 = 2.0f * gv2;
            gvVar.f11447s = new fb.n3(f9, f10, f13, f13);
        }
        float f14 = 0.5522848f * gv2;
        Path path = new Path();
        path.moveTo(f4, f10);
        float f15 = f4 + f14;
        float f16 = f6 - f14;
        path.cubicTo(f15, f10, f11, f16, f11, f6);
        float f17 = f6 + f14;
        path.cubicTo(f11, f17, f15, f12, f4, f12);
        float f18 = f4 - f14;
        path.cubicTo(f18, f12, f9, f17, f9, f6);
        path.cubicTo(f9, f16, f18, f10, f4, f10);
        path.close();
        return path;
    }

    public final void fh(fb.x xVar, Path path) {
        fb.r rVar = this.f11466gv.y.v;
        if (rVar instanceof fb.r) {
            fb.yt wz2 = this.f11470zn.wz(rVar.y);
            if (wz2 instanceof fb.n) {
                b(xVar, path, (fb.n) wz2);
                return;
            }
        }
        this.y.drawPath(path, this.f11466gv.gv);
    }

    public final void g(fb.d0 d0Var) {
        n("Polygon render", new Object[0]);
        ix(this.f11466gv, d0Var);
        if (!d0() || !i2()) {
            return;
        }
        s sVar = this.f11466gv;
        if (!sVar.zn && !sVar.n3) {
            return;
        }
        Matrix matrix = ((fb.t) d0Var).wz;
        if (matrix != null) {
            this.y.concat(matrix);
        }
        if (((fb.c) d0Var).xc.length < 2) {
            return;
        }
        Path u2 = u(d0Var);
        cs(d0Var);
        mt(d0Var);
        w(d0Var);
        boolean e2 = e();
        if (this.f11466gv.n3) {
            fh(d0Var, u2);
        }
        if (this.f11466gv.zn) {
            rz(u2);
        }
        qk(d0Var);
        if (e2) {
            lc(d0Var);
        }
    }

    public final void g3(fb.x4 x4Var) {
        n("Path render", new Object[0]);
        if (x4Var.xc == null) {
            return;
        }
        ix(this.f11466gv, x4Var);
        if (!d0() || !i2()) {
            return;
        }
        s sVar = this.f11466gv;
        if (!sVar.zn && !sVar.n3) {
            return;
        }
        Matrix matrix = ((fb.t) x4Var).wz;
        if (matrix != null) {
            this.y.concat(matrix);
        }
        Path a2 = new gv(this, x4Var.xc).a();
        if (x4Var.f11447s == null) {
            x4Var.f11447s = tl(a2);
        }
        cs(x4Var);
        mt(x4Var);
        w(x4Var);
        boolean e2 = e();
        if (this.f11466gv.n3) {
            a2.setFillType(oz());
            fh(x4Var, a2);
        }
        if (this.f11466gv.zn) {
            rz(a2);
        }
        qk(x4Var);
        if (e2) {
            lc(x4Var);
        }
    }

    public final void gq(fb.en enVar) {
        float f4;
        n("TextPath render", new Object[0]);
        ix(this.f11466gv, enVar);
        if (!d0() || !i2()) {
            return;
        }
        fb.x4 wz2 = enVar.y.wz(enVar.xc);
        if (wz2 == null) {
            d("TextPath reference '%s' not found", enVar.xc);
            return;
        }
        fb.x4 x4Var = wz2;
        Path a2 = new gv(this, x4Var.xc).a();
        Matrix matrix = ((fb.t) x4Var).wz;
        if (matrix != null) {
            a2.transform(matrix);
        }
        PathMeasure pathMeasure = new PathMeasure(a2, false);
        fb.w wVar = enVar.w;
        if (wVar != null) {
            f4 = wVar.a(this, pathMeasure.getLength());
        } else {
            f4 = 0.0f;
        }
        fb.ta.a vl2 = vl();
        if (vl2 != fb.ta.a.y) {
            float wz3 = wz(enVar);
            if (vl2 == fb.ta.a.v) {
                wz3 /= 2.0f;
            }
            f4 -= wz3;
        }
        mt((fb.x) enVar.v());
        boolean e2 = e();
        ta(enVar, new v(this, a2, f4, 0.0f));
        if (e2) {
            lc(enVar);
        }
    }

    public final Path.FillType hw() {
        fb.ta.y yVar = this.f11466gv.y.u;
        if (yVar != null && yVar == fb.ta.y.v) {
            return Path.FillType.EVEN_ODD;
        }
        return Path.FillType.WINDING;
    }

    public final boolean i2() {
        Boolean bool = this.f11466gv.y.k;
        if (bool != null) {
            return bool.booleanValue();
        }
        return true;
    }

    @TargetApi(19)
    public final Path i9(fb.x xVar, fb.n3 n3Var) {
        Path o42;
        boolean z2 = false;
        fb.v wz2 = xVar.y.wz(this.f11466gv.y.jz);
        if (wz2 == null) {
            d("ClipPath reference '%s' not found", this.f11466gv.y.jz);
            return null;
        }
        fb.v vVar = wz2;
        this.f11469v.push(this.f11466gv);
        this.f11466gv = k5(vVar);
        Boolean bool = vVar.w;
        z2 = (bool == null || bool.booleanValue()) ? true : true;
        Matrix matrix = new Matrix();
        if (!z2) {
            matrix.preTranslate(n3Var.y, n3Var.f11443n3);
            matrix.preScale(n3Var.f11444zn, n3Var.f11442gv);
        }
        Matrix matrix2 = ((fb.tl) vVar).xc;
        if (matrix2 != null) {
            matrix.preConcat(matrix2);
        }
        Path path = new Path();
        for (fb.yt ytVar : vVar.f11435c5) {
            if ((ytVar instanceof fb.x) && (o42 = o4((fb.x) ytVar, true)) != null) {
                path.op(o42, Path.Op.UNION);
            }
        }
        if (this.f11466gv.y.jz != null) {
            if (vVar.f11447s == null) {
                vVar.f11447s = tl(path);
            }
            Path i92 = i9(vVar, vVar.f11447s);
            if (i92 != null) {
                path.op(i92, Path.Op.INTERSECT);
            }
        }
        path.transform(matrix);
        this.f11466gv = this.f11469v.pop();
        return path;
    }

    public final void ix(s sVar, fb.b bVar) {
        boolean z2;
        if (bVar.f11457n3 == null) {
            z2 = true;
        } else {
            z2 = false;
        }
        sVar.y.zn(z2);
        fb.ta taVar = bVar.f11428v;
        if (taVar != null) {
            ro(sVar, taVar);
        }
        if (this.f11470zn.i9()) {
            for (n3$w n3_w : this.f11470zn.gv()) {
                if (n3.t(this.f11468s, n3_w.y, bVar)) {
                    ro(sVar, n3_w.f11461n3);
                }
            }
        }
        fb.ta taVar2 = bVar.f11425a;
        if (taVar2 != null) {
            ro(sVar, taVar2);
        }
    }

    public float j() {
        return this.f11467n3;
    }

    public float j5() {
        return this.f11466gv.gv.getTextSize();
    }

    public final Path jz(fb.p pVar) {
        float fb2;
        float s2;
        float fb3;
        fb.w wVar = pVar.xc;
        float f4 = 0.0f;
        if (wVar == null) {
            fb2 = 0.0f;
        } else {
            fb2 = wVar.fb(this);
        }
        fb.w wVar2 = pVar.w;
        if (wVar2 == null) {
            s2 = 0.0f;
        } else {
            s2 = wVar2.s(this);
        }
        fb.w wVar3 = pVar.p;
        if (wVar3 == null) {
            fb3 = 0.0f;
        } else {
            fb3 = wVar3.fb(this);
        }
        fb.w wVar4 = pVar.mt;
        if (wVar4 != null) {
            f4 = wVar4.s(this);
        }
        if (pVar.f11447s == null) {
            pVar.f11447s = new fb.n3(Math.min(fb2, fb3), Math.min(s2, f4), Math.abs(fb3 - fb2), Math.abs(f4 - s2));
        }
        Path path = new Path();
        path.moveTo(fb2, s2);
        path.lineTo(fb3, f4);
        return path;
    }

    public final void k(boolean z2, fb.n3 n3Var, fb.k5 k5Var) {
        boolean z3;
        Paint paint;
        float f4;
        float f6;
        float f9;
        float f10;
        float f11;
        float f12;
        float f13;
        float f14;
        float f15;
        float f16;
        float f17;
        float f18;
        float f19;
        String str = ((fb.i9) k5Var).t;
        if (str != null) {
            ej(k5Var, str);
        }
        Boolean bool = ((fb.i9) k5Var).c5;
        int i = 0;
        if (bool != null && bool.booleanValue()) {
            z3 = true;
        } else {
            z3 = false;
        }
        s sVar = this.f11466gv;
        if (z2) {
            paint = sVar.gv;
        } else {
            paint = sVar.v;
        }
        if (z3) {
            fb.n3 o2 = o();
            fb.w wVar = k5Var.tl;
            if (wVar != null) {
                f16 = wVar.fb(this);
            } else {
                f16 = 0.0f;
            }
            fb.w wVar2 = k5Var.wz;
            if (wVar2 != null) {
                f17 = wVar2.s(this);
            } else {
                f17 = 0.0f;
            }
            fb.w wVar3 = k5Var.xc;
            if (wVar3 != null) {
                f18 = wVar3.fb(this);
            } else {
                f18 = o2.f11444zn;
            }
            fb.w wVar4 = k5Var.w;
            if (wVar4 != null) {
                f19 = wVar4.s(this);
            } else {
                f19 = 0.0f;
            }
            f14 = f18;
            f11 = f16;
            f13 = f17;
            f12 = f19;
        } else {
            fb.w wVar5 = k5Var.tl;
            if (wVar5 != null) {
                f4 = wVar5.a(this, 1.0f);
            } else {
                f4 = 0.0f;
            }
            fb.w wVar6 = k5Var.wz;
            if (wVar6 != null) {
                f6 = wVar6.a(this, 1.0f);
            } else {
                f6 = 0.0f;
            }
            fb.w wVar7 = k5Var.xc;
            if (wVar7 != null) {
                f9 = wVar7.a(this, 1.0f);
            } else {
                f9 = 1.0f;
            }
            fb.w wVar8 = k5Var.w;
            if (wVar8 != null) {
                f10 = wVar8.a(this, 1.0f);
            } else {
                f10 = 0.0f;
            }
            f11 = f4;
            f12 = f10;
            f13 = f6;
            f14 = f9;
        }
        mp();
        this.f11466gv = k5(k5Var);
        Matrix matrix = new Matrix();
        if (!z3) {
            matrix.preTranslate(n3Var.y, n3Var.f11443n3);
            matrix.preScale(n3Var.f11444zn, n3Var.f11442gv);
        }
        Matrix matrix2 = ((fb.i9) k5Var).i9;
        if (matrix2 != null) {
            matrix.preConcat(matrix2);
        }
        int size = ((fb.i9) k5Var).s.size();
        if (size == 0) {
            q5();
            if (z2) {
                this.f11466gv.n3 = false;
                return;
            } else {
                this.f11466gv.zn = false;
                return;
            }
        }
        int[] iArr = new int[size];
        float[] fArr = new float[size];
        float f20 = -1.0f;
        for (fb.mg mgVar : ((fb.i9) k5Var).s) {
            Float f21 = mgVar.s;
            if (f21 != null) {
                f15 = f21.floatValue();
            } else {
                f15 = 0.0f;
            }
            if (i != 0 && f15 < f20) {
                fArr[i] = f20;
            } else {
                fArr[i] = f15;
                f20 = f15;
            }
            mp();
            ix(this.f11466gv, mgVar);
            fb.ta taVar = this.f11466gv.y;
            fb.a aVar = taVar.f7;
            if (aVar == null) {
                aVar = fb.a.v;
            }
            iArr[i] = f3(aVar.y, taVar.en.floatValue());
            i++;
            q5();
        }
        if ((f11 == f14 && f13 == f12) || size == 1) {
            q5();
            paint.setColor(iArr[size - 1]);
            return;
        }
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        fb.f fVar = ((fb.i9) k5Var).f;
        if (fVar != null) {
            if (fVar == fb.f.v) {
                tileMode = Shader.TileMode.MIRROR;
            } else if (fVar == fb.f.fb) {
                tileMode = Shader.TileMode.REPEAT;
            }
        }
        Shader.TileMode tileMode2 = tileMode;
        q5();
        LinearGradient linearGradient = new LinearGradient(f11, f13, f14, f12, iArr, fArr, tileMode2);
        linearGradient.setLocalMatrix(matrix);
        paint.setShader(linearGradient);
        paint.setAlpha(i4(this.f11466gv.y.s.floatValue()));
    }

    public final s k5(fb.yt ytVar) {
        s sVar = new s(this);
        ro(sVar, fb.ta.n3());
        return yt(ytVar, sVar);
    }

    public final void kp(fb.xc xcVar) {
        fb.w wVar;
        String str;
        float f4;
        float f6;
        int i = 0;
        n("Image render", new Object[0]);
        fb.w wVar2 = xcVar.co;
        if (wVar2 == null || wVar2.i9() || (wVar = xcVar.z) == null || wVar.i9() || (str = xcVar.w) == null) {
            return;
        }
        v vVar = xcVar.f11441xc;
        if (vVar == null) {
            vVar = v.v;
        }
        Bitmap co2 = co(str);
        if (co2 == null) {
            fb.fb();
            return;
        }
        fb.n3 n3Var = new fb.n3(0.0f, 0.0f, co2.getWidth(), co2.getHeight());
        ix(this.f11466gv, xcVar);
        if (!d0() || !i2()) {
            return;
        }
        Matrix matrix = xcVar.r;
        if (matrix != null) {
            this.y.concat(matrix);
        }
        fb.w wVar3 = xcVar.p;
        if (wVar3 != null) {
            f4 = wVar3.fb(this);
        } else {
            f4 = 0.0f;
        }
        fb.w wVar4 = xcVar.mt;
        if (wVar4 != null) {
            f6 = wVar4.s(this);
        } else {
            f6 = 0.0f;
        }
        this.f11466gv.a = new fb.n3(f4, f6, xcVar.co.fb(this), xcVar.z.fb(this));
        if (!this.f11466gv.y.qn.booleanValue()) {
            fb.n3 n3Var2 = this.f11466gv.a;
            w9(n3Var2.y, n3Var2.f11443n3, n3Var2.f11444zn, n3Var2.f11442gv);
        }
        xcVar.f11447s = this.f11466gv.a;
        cs(xcVar);
        w(xcVar);
        boolean e2 = e();
        yk();
        this.y.save();
        this.y.concat(xc(this.f11466gv.a, n3Var, vVar));
        if (this.f11466gv.y.eb != fb.ta.v.fb) {
            i = 2;
        }
        this.y.drawBitmap(co2, 0.0f, 0.0f, new Paint(i));
        this.y.restore();
        if (e2) {
            lc(xcVar);
        }
    }

    public final void l(fb.o oVar) {
        Set<String> y;
        String language = Locale.getDefault().getLanguage();
        fb.fb();
        for (fb.yt ytVar : oVar.n3()) {
            if (ytVar instanceof fb.z6) {
                fb.z6 z6Var = (fb.z6) ytVar;
                if (z6Var.zn() == null && ((y = z6Var.y()) == null || (!y.isEmpty() && y.contains(language)))) {
                    Set<String> requiredFeatures = z6Var.getRequiredFeatures();
                    if (requiredFeatures != null) {
                        if (f11463c5 == null) {
                            ut();
                        }
                        if (!requiredFeatures.isEmpty() && f11463c5.containsAll(requiredFeatures)) {
                        }
                    }
                    Set<String> t2 = z6Var.t();
                    if (t2 != null) {
                        t2.isEmpty();
                    } else {
                        Set<String> tl2 = z6Var.tl();
                        if (tl2 != null) {
                            tl2.isEmpty();
                        } else {
                            pz(ytVar);
                            return;
                        }
                    }
                }
            }
        }
    }

    public final void lc(fb.x xVar) {
        nf(xVar, xVar.f11447s);
    }

    public final String le(String str, boolean z2, boolean z3) {
        if (this.f11466gv.s) {
            return str.replaceAll("[\\n\\t]", " ");
        }
        String replaceAll = str.replaceAll("\\n", "").replaceAll("\\t", " ");
        if (z2) {
            replaceAll = replaceAll.replaceAll("^\\s+", "");
        }
        if (z3) {
            replaceAll = replaceAll.replaceAll("\\s+$", "");
        }
        return replaceAll.replaceAll("\\s{2,}", " ");
    }

    public final void m(fb.c cVar) {
        n("PolyLine render", new Object[0]);
        ix(this.f11466gv, cVar);
        if (!d0() || !i2()) {
            return;
        }
        s sVar = this.f11466gv;
        if (!sVar.zn && !sVar.n3) {
            return;
        }
        Matrix matrix = ((fb.t) cVar).wz;
        if (matrix != null) {
            this.y.concat(matrix);
        }
        if (cVar.xc.length < 2) {
            return;
        }
        Path u2 = u(cVar);
        cs(cVar);
        u2.setFillType(oz());
        mt(cVar);
        w(cVar);
        boolean e2 = e();
        if (this.f11466gv.n3) {
            fh(cVar, u2);
        }
        if (this.f11466gv.zn) {
            rz(u2);
        }
        qk(cVar);
        if (e2) {
            lc(cVar);
        }
    }

    public final float mg(float f4, float f6, float f9, float f10) {
        return (f4 * f9) + (f6 * f10);
    }

    public final void mp() {
        this.y.save();
        this.f11469v.push(this.f11466gv);
        this.f11466gv = new s(this, this.f11466gv);
    }

    public final void mt(fb.x xVar) {
        fb.vl vlVar = this.f11466gv.y.v;
        if (vlVar instanceof fb.r) {
            c(true, xVar.f11447s, (fb.r) vlVar);
        }
        fb.vl vlVar2 = this.f11466gv.y.f;
        if (vlVar2 instanceof fb.r) {
            c(false, xVar.f11447s, (fb.r) vlVar2);
        }
    }

    public final void nf(fb.x xVar, fb.n3 n3Var) {
        if (this.f11466gv.y.y5 != null) {
            Paint paint = new Paint();
            PorterDuff.Mode mode = PorterDuff.Mode.DST_IN;
            paint.setXfermode(new PorterDuffXfermode(mode));
            this.y.saveLayer(null, paint, 31);
            Paint paint2 = new Paint();
            paint2.setColorFilter(new ColorMatrixColorFilter(new ColorMatrix(new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.2127f, 0.7151f, 0.0722f, 0.0f, 0.0f})));
            this.y.saveLayer(null, paint2, 31);
            fb.co coVar = (fb.co) this.f11470zn.wz(this.f11466gv.y.y5);
            qj(coVar, xVar, n3Var);
            this.y.restore();
            Paint paint3 = new Paint();
            paint3.setXfermode(new PorterDuffXfermode(mode));
            this.y.saveLayer(null, paint3, 31);
            qj(coVar, xVar, n3Var);
            this.y.restore();
            this.y.restore();
        }
        q5();
    }

    public fb.n3 o() {
        s sVar = this.f11466gv;
        fb.n3 n3Var = sVar.fb;
        if (n3Var != null) {
            return n3Var;
        }
        return sVar.a;
    }

    public final void o0(fb.q9 q9Var) {
        float f4;
        float f6;
        float f9;
        n("Text render", new Object[0]);
        ix(this.f11466gv, q9Var);
        if (!d0()) {
            return;
        }
        Matrix matrix = q9Var.co;
        if (matrix != null) {
            this.y.concat(matrix);
        }
        List list = ((fb.jz) q9Var).xc;
        float f10 = 0.0f;
        if (list != null && list.size() != 0) {
            f4 = ((fb.w) ((fb.jz) q9Var).xc.get(0)).fb(this);
        } else {
            f4 = 0.0f;
        }
        List list2 = ((fb.jz) q9Var).w;
        if (list2 != null && list2.size() != 0) {
            f6 = ((fb.w) ((fb.jz) q9Var).w.get(0)).s(this);
        } else {
            f6 = 0.0f;
        }
        List list3 = ((fb.jz) q9Var).p;
        if (list3 != null && list3.size() != 0) {
            f9 = ((fb.w) ((fb.jz) q9Var).p.get(0)).fb(this);
        } else {
            f9 = 0.0f;
        }
        List list4 = ((fb.jz) q9Var).mt;
        if (list4 != null && list4.size() != 0) {
            f10 = ((fb.w) ((fb.jz) q9Var).mt.get(0)).s(this);
        }
        fb.ta.a vl2 = vl();
        if (vl2 != fb.ta.a.y) {
            float wz2 = wz(q9Var);
            if (vl2 == fb.ta.a.v) {
                wz2 /= 2.0f;
            }
            f4 -= wz2;
        }
        if (q9Var.f11447s == null) {
            c5 c5Var = new c5(this, f4, f6);
            ta(q9Var, c5Var);
            RectF rectF = c5Var.gv;
            q9Var.f11447s = new fb.n3(rectF.left, rectF.top, rectF.width(), c5Var.gv.height());
        }
        cs(q9Var);
        mt(q9Var);
        w(q9Var);
        boolean e2 = e();
        ta(q9Var, new a(this, f4 + f9, f6 + f10));
        if (e2) {
            lc(q9Var);
        }
    }

    @TargetApi(19)
    public final Path o4(fb.x xVar, boolean z2) {
        Path xg2;
        Path i92;
        this.f11469v.push(this.f11466gv);
        s sVar = new s(this, this.f11466gv);
        this.f11466gv = sVar;
        ix(sVar, xVar);
        if (d0() && i2()) {
            if (xVar instanceof fb.dm) {
                if (!z2) {
                    d("<use> elements inside a <clipPath> cannot reference another <use>", new Object[0]);
                }
                fb.dm dmVar = (fb.dm) xVar;
                fb.yt wz2 = xVar.y.wz(dmVar.w);
                if (wz2 == null) {
                    d("Use reference '%s' not found", dmVar.w);
                    this.f11466gv = this.f11469v.pop();
                    return null;
                } else if (!(wz2 instanceof fb.x)) {
                    this.f11466gv = this.f11469v.pop();
                    return null;
                } else {
                    xg2 = o4((fb.x) wz2, false);
                    if (xg2 == null) {
                        return null;
                    }
                    if (dmVar.f11447s == null) {
                        dmVar.f11447s = tl(xg2);
                    }
                    Matrix matrix = ((fb.tl) dmVar).xc;
                    if (matrix != null) {
                        xg2.transform(matrix);
                    }
                }
            } else if (xVar instanceof fb.t) {
                fb.t tVar = (fb.t) xVar;
                if (xVar instanceof fb.x4) {
                    xg2 = new gv(this, ((fb.x4) xVar).xc).a();
                    if (xVar.f11447s == null) {
                        xVar.f11447s = tl(xg2);
                    }
                } else {
                    xg2 = xVar instanceof fb.fh ? y5((fb.fh) xVar) : xVar instanceof fb.gv ? f7((fb.gv) xVar) : xVar instanceof fb.c5 ? en((fb.c5) xVar) : xVar instanceof fb.c ? u((fb.c) xVar) : null;
                }
                if (xg2 == null) {
                    return null;
                }
                if (tVar.f11447s == null) {
                    tVar.f11447s = tl(xg2);
                }
                Matrix matrix2 = tVar.wz;
                if (matrix2 != null) {
                    xg2.transform(matrix2);
                }
                xg2.setFillType(hw());
            } else if (xVar instanceof fb.q9) {
                fb.q9 q9Var = (fb.q9) xVar;
                xg2 = xg(q9Var);
                if (xg2 == null) {
                    return null;
                }
                Matrix matrix3 = q9Var.co;
                if (matrix3 != null) {
                    xg2.transform(matrix3);
                }
                xg2.setFillType(hw());
            } else {
                d("Invalid %s element found in clipPath definition", xVar.wz());
                return null;
            }
            if (this.f11466gv.y.jz != null && (i92 = i9(xVar, xVar.f11447s)) != null) {
                xg2.op(i92, Path.Op.INTERSECT);
            }
            this.f11466gv = this.f11469v.pop();
            return xg2;
        }
        this.f11466gv = this.f11469v.pop();
        return null;
    }

    public final void oa() {
        this.f11466gv = new s(this);
        this.f11469v = new Stack<>();
        ro(this.f11466gv, fb.ta.n3());
        s sVar = this.f11466gv;
        sVar.a = null;
        sVar.s = false;
        this.f11469v.push(new s(this, sVar));
        this.f11465fb = new Stack<>();
        this.f11464a = new Stack<>();
    }

    public final Path.FillType oz() {
        fb.ta.y yVar = this.f11466gv.y.fb;
        if (yVar != null && yVar == fb.ta.y.v) {
            return Path.FillType.EVEN_ODD;
        }
        return Path.FillType.WINDING;
    }

    public final void p(fb.x xVar, fb.n3 n3Var) {
        Path i92;
        if (this.f11466gv.y.jz != null && (i92 = i9(xVar, n3Var)) != null) {
            this.y.clipPath(i92);
        }
    }

    public final void pq(fb.o oVar) {
        n("Switch render", new Object[0]);
        ix(this.f11466gv, oVar);
        if (!d0()) {
            return;
        }
        Matrix matrix = ((fb.tl) oVar).xc;
        if (matrix != null) {
            this.y.concat(matrix);
        }
        w(oVar);
        boolean e2 = e();
        l(oVar);
        if (e2) {
            lc(oVar);
        }
        cs(oVar);
    }

    public final void pz(fb.yt ytVar) {
        if (ytVar instanceof fb.z) {
            return;
        }
        mp();
        r(ytVar);
        if (ytVar instanceof fb.d) {
            bk((fb.d) ytVar);
        } else if (ytVar instanceof fb.dm) {
            xb((fb.dm) ytVar);
        } else if (ytVar instanceof fb.o) {
            pq((fb.o) ytVar);
        } else if (ytVar instanceof fb.tl) {
            yc((fb.tl) ytVar);
        } else if (ytVar instanceof fb.xc) {
            kp((fb.xc) ytVar);
        } else if (ytVar instanceof fb.x4) {
            g3((fb.x4) ytVar);
        } else if (ytVar instanceof fb.fh) {
            u0((fb.fh) ytVar);
        } else if (ytVar instanceof fb.gv) {
            ap((fb.gv) ytVar);
        } else if (ytVar instanceof fb.c5) {
            yg((fb.c5) ytVar);
        } else if (ytVar instanceof fb.p) {
            rb((fb.p) ytVar);
        } else if (ytVar instanceof fb.d0) {
            g((fb.d0) ytVar);
        } else if (ytVar instanceof fb.c) {
            m((fb.c) ytVar);
        } else if (ytVar instanceof fb.q9) {
            o0((fb.q9) ytVar);
        }
        q5();
    }

    public final void q5() {
        this.y.restore();
        this.f11466gv = this.f11469v.pop();
    }

    public final boolean q9(fb.ta taVar, long j2) {
        if ((taVar.y & j2) != 0) {
            return true;
        }
        return false;
    }

    public final void qj(fb.co coVar, fb.x xVar, fb.n3 n3Var) {
        float f4;
        float f6;
        float f9;
        n("Mask render", new Object[0]);
        Boolean bool = coVar.xc;
        if (bool != null && bool.booleanValue()) {
            fb.w wVar = coVar.co;
            if (wVar != null) {
                f6 = wVar.fb(this);
            } else {
                f6 = n3Var.f11444zn;
            }
            fb.w wVar2 = coVar.z;
            if (wVar2 != null) {
                f9 = wVar2.s(this);
            } else {
                f9 = n3Var.f11442gv;
            }
        } else {
            fb.w wVar3 = coVar.co;
            float f10 = 1.2f;
            if (wVar3 != null) {
                f4 = wVar3.a(this, 1.0f);
            } else {
                f4 = 1.2f;
            }
            fb.w wVar4 = coVar.z;
            if (wVar4 != null) {
                f10 = wVar4.a(this, 1.0f);
            }
            f6 = f4 * n3Var.f11444zn;
            f9 = f10 * n3Var.f11442gv;
        }
        if (f6 != 0.0f && f9 != 0.0f) {
            mp();
            s k52 = k5(coVar);
            this.f11466gv = k52;
            k52.y.n = Float.valueOf(1.0f);
            boolean e2 = e();
            this.y.save();
            Boolean bool2 = coVar.w;
            if (bool2 != null && !bool2.booleanValue()) {
                this.y.translate(n3Var.y, n3Var.f11443n3);
                this.y.scale(n3Var.f11444zn, n3Var.f11442gv);
            }
            wf(coVar, false);
            this.y.restore();
            if (e2) {
                nf(xVar, n3Var);
            }
            q5();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0098 A[ADDED_TO_REGION, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:62:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void qk(mc.fb.t r10) {
        /*
            Method dump skipped, instructions count: 242
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: mc.s.qk(mc.fb$t):void");
    }

    public float qn() {
        return this.f11466gv.gv.getTextSize() / 2.0f;
    }

    public final void r(fb.yt ytVar) {
        Boolean bool;
        if ((ytVar instanceof fb.b) && (bool = ((fb.b) ytVar).f11427gv) != null) {
            this.f11466gv.s = bool.booleanValue();
        }
    }

    public final void ra(fb.yt ytVar, i9 i9Var) {
        float f4;
        float f6;
        float f9;
        fb.ta.a vl2;
        float fb2;
        boolean z2 = true;
        if (!i9Var.y((fb.f7) ytVar)) {
            return;
        }
        if (ytVar instanceof fb.en) {
            mp();
            gq((fb.en) ytVar);
            q5();
        } else if (ytVar instanceof fb.ut) {
            n("TSpan render", new Object[0]);
            mp();
            fb.f7 f7Var = (fb.ut) ytVar;
            ix(this.f11466gv, f7Var);
            if (d0()) {
                List list = ((fb.jz) f7Var).xc;
                z2 = (list == null || list.size() <= 0) ? false : false;
                boolean z3 = i9Var instanceof a;
                float f10 = 0.0f;
                if (z3) {
                    if (!z2) {
                        fb2 = ((a) i9Var).n3;
                    } else {
                        fb2 = ((fb.w) ((fb.jz) f7Var).xc.get(0)).fb(this);
                    }
                    List list2 = ((fb.jz) f7Var).w;
                    if (list2 != null && list2.size() != 0) {
                        f6 = ((fb.w) ((fb.jz) f7Var).w.get(0)).s(this);
                    } else {
                        f6 = ((a) i9Var).zn;
                    }
                    List list3 = ((fb.jz) f7Var).p;
                    if (list3 != null && list3.size() != 0) {
                        f9 = ((fb.w) ((fb.jz) f7Var).p.get(0)).fb(this);
                    } else {
                        f9 = 0.0f;
                    }
                    List list4 = ((fb.jz) f7Var).mt;
                    if (list4 != null && list4.size() != 0) {
                        f10 = ((fb.w) ((fb.jz) f7Var).mt.get(0)).s(this);
                    }
                    f4 = f10;
                    f10 = fb2;
                } else {
                    f4 = 0.0f;
                    f6 = 0.0f;
                    f9 = 0.0f;
                }
                if (z2 && (vl2 = vl()) != fb.ta.a.y) {
                    float wz2 = wz(f7Var);
                    if (vl2 == fb.ta.a.v) {
                        wz2 /= 2.0f;
                    }
                    f10 -= wz2;
                }
                mt(f7Var.v());
                if (z3) {
                    a aVar = (a) i9Var;
                    aVar.n3 = f10 + f9;
                    aVar.zn = f6 + f4;
                }
                boolean e2 = e();
                ta(f7Var, i9Var);
                if (e2) {
                    lc(f7Var);
                }
            }
            q5();
        } else if (ytVar instanceof fb.oz) {
            mp();
            fb.b bVar = (fb.oz) ytVar;
            ix(this.f11466gv, bVar);
            if (d0()) {
                mt(bVar.v());
                fb.f7 wz3 = ytVar.y.wz(((fb.oz) bVar).xc);
                if (wz3 != null && (wz3 instanceof fb.f7)) {
                    StringBuilder sb = new StringBuilder();
                    z6(wz3, sb);
                    if (sb.length() > 0) {
                        i9Var.n3(sb.toString());
                    }
                } else {
                    d("Tref reference '%s' not found", ((fb.oz) bVar).xc);
                }
            }
            q5();
        }
    }

    public final void rb(fb.p pVar) {
        n("Line render", new Object[0]);
        ix(this.f11466gv, pVar);
        if (!d0() || !i2() || !this.f11466gv.zn) {
            return;
        }
        Matrix matrix = ((fb.t) pVar).wz;
        if (matrix != null) {
            this.y.concat(matrix);
        }
        Path jz2 = jz(pVar);
        cs(pVar);
        mt(pVar);
        w(pVar);
        boolean e2 = e();
        rz(jz2);
        qk(pVar);
        if (e2) {
            lc(pVar);
        }
    }

    public final void ro(s sVar, fb.ta taVar) {
        if (q9(taVar, 4096L)) {
            sVar.y.c = taVar.c;
        }
        if (q9(taVar, 2048L)) {
            sVar.y.n = taVar.n;
        }
        if (q9(taVar, 1L)) {
            sVar.y.v = taVar.v;
            fb.a aVar = taVar.v;
            sVar.n3 = (aVar == null || aVar == fb.a.fb) ? false : true;
        }
        if (q9(taVar, 4L)) {
            sVar.y.s = taVar.s;
        }
        if (q9(taVar, 6149L)) {
            w2(sVar, true, sVar.y.v);
        }
        if (q9(taVar, 2L)) {
            sVar.y.fb = taVar.fb;
        }
        if (q9(taVar, 8L)) {
            sVar.y.f = taVar.f;
            fb.a aVar2 = taVar.f;
            sVar.zn = (aVar2 == null || aVar2 == fb.a.fb) ? false : true;
        }
        if (q9(taVar, 16L)) {
            sVar.y.t = taVar.t;
        }
        if (q9(taVar, 6168L)) {
            w2(sVar, false, sVar.y.f);
        }
        if (q9(taVar, 34359738368L)) {
            sVar.y.rs = taVar.rs;
        }
        if (q9(taVar, 32L)) {
            fb.ta taVar2 = sVar.y;
            fb.w wVar = taVar.w;
            taVar2.w = wVar;
            sVar.v.setStrokeWidth(wVar.gv(this));
        }
        if (q9(taVar, 64L)) {
            sVar.y.p = taVar.p;
            int i = y.n3[taVar.p.ordinal()];
            if (i == 1) {
                sVar.v.setStrokeCap(Paint.Cap.BUTT);
            } else if (i == 2) {
                sVar.v.setStrokeCap(Paint.Cap.ROUND);
            } else if (i == 3) {
                sVar.v.setStrokeCap(Paint.Cap.SQUARE);
            }
        }
        if (q9(taVar, 128L)) {
            sVar.y.co = taVar.co;
            int i5 = y.zn[taVar.co.ordinal()];
            if (i5 == 1) {
                sVar.v.setStrokeJoin(Paint.Join.MITER);
            } else if (i5 == 2) {
                sVar.v.setStrokeJoin(Paint.Join.ROUND);
            } else if (i5 == 3) {
                sVar.v.setStrokeJoin(Paint.Join.BEVEL);
            }
        }
        if (q9(taVar, 256L)) {
            sVar.y.z = taVar.z;
            sVar.v.setStrokeMiter(taVar.z.floatValue());
        }
        if (q9(taVar, 512L)) {
            sVar.y.r = taVar.r;
        }
        if (q9(taVar, 1024L)) {
            sVar.y.f3 = taVar.f3;
        }
        Typeface typeface = null;
        if (q9(taVar, 1536L)) {
            fb.w[] wVarArr = sVar.y.r;
            if (wVarArr == null) {
                sVar.v.setPathEffect(null);
            } else {
                int length = wVarArr.length;
                int i6 = length % 2 == 0 ? length : length * 2;
                float[] fArr = new float[i6];
                float f4 = 0.0f;
                for (int i8 = 0; i8 < i6; i8++) {
                    float gv2 = sVar.y.r[i8 % length].gv(this);
                    fArr[i8] = gv2;
                    f4 += gv2;
                }
                if (f4 == 0.0f) {
                    sVar.v.setPathEffect(null);
                } else {
                    float gv3 = sVar.y.f3.gv(this);
                    if (gv3 < 0.0f) {
                        gv3 = (gv3 % f4) + f4;
                    }
                    sVar.v.setPathEffect(new DashPathEffect(fArr, gv3));
                }
            }
        }
        if (q9(taVar, 16384L)) {
            float j52 = j5();
            sVar.y.fh = taVar.fh;
            sVar.gv.setTextSize(taVar.fh.a(this, j52));
            sVar.v.setTextSize(taVar.fh.a(this, j52));
        }
        if (q9(taVar, 8192L)) {
            sVar.y.d0 = taVar.d0;
        }
        if (q9(taVar, 32768L)) {
            if (taVar.d.intValue() == -1 && sVar.y.d.intValue() > 100) {
                fb.ta taVar3 = sVar.y;
                taVar3.d = Integer.valueOf(taVar3.d.intValue() - 100);
            } else if (taVar.d.intValue() == 1 && sVar.y.d.intValue() < 900) {
                fb.ta taVar4 = sVar.y;
                taVar4.d = Integer.valueOf(taVar4.d.intValue() + 100);
            } else {
                sVar.y.d = taVar.d;
            }
        }
        if (q9(taVar, 65536L)) {
            sVar.y.ej = taVar.ej;
        }
        if (q9(taVar, 106496L)) {
            if (sVar.y.d0 != null && this.f11470zn != null) {
                fb.fb();
                for (String str : sVar.y.d0) {
                    fb.ta taVar5 = sVar.y;
                    typeface = z(str, taVar5.d, taVar5.ej);
                    if (typeface != null) {
                        break;
                    }
                }
            }
            if (typeface == null) {
                fb.ta taVar6 = sVar.y;
                typeface = z("serif", taVar6.d, taVar6.ej);
            }
            sVar.gv.setTypeface(typeface);
            sVar.v.setTypeface(typeface);
        }
        if (q9(taVar, 131072L)) {
            sVar.y.x = taVar.x;
            Paint paint = sVar.gv;
            fb.ta.fb fbVar = taVar.x;
            fb.ta.fb fbVar2 = fb.ta.fb.s;
            paint.setStrikeThruText(fbVar == fbVar2);
            Paint paint2 = sVar.gv;
            fb.ta.fb fbVar3 = taVar.x;
            fb.ta.fb fbVar4 = fb.ta.fb.v;
            paint2.setUnderlineText(fbVar3 == fbVar4);
            sVar.v.setStrikeThruText(taVar.x == fbVar2);
            sVar.v.setUnderlineText(taVar.x == fbVar4);
        }
        if (q9(taVar, 68719476736L)) {
            sVar.y.b = taVar.b;
        }
        if (q9(taVar, 262144L)) {
            sVar.y.j5 = taVar.j5;
        }
        if (q9(taVar, 524288L)) {
            sVar.y.qn = taVar.qn;
        }
        if (q9(taVar, 2097152L)) {
            sVar.y.j = taVar.j;
        }
        if (q9(taVar, 4194304L)) {
            sVar.y.oz = taVar.oz;
        }
        if (q9(taVar, 8388608L)) {
            sVar.y.ut = taVar.ut;
        }
        if (q9(taVar, 16777216L)) {
            sVar.y.q9 = taVar.q9;
        }
        if (q9(taVar, 33554432L)) {
            sVar.y.k = taVar.k;
        }
        if (q9(taVar, 1048576L)) {
            sVar.y.o = taVar.o;
        }
        if (q9(taVar, 268435456L)) {
            sVar.y.jz = taVar.jz;
        }
        if (q9(taVar, 536870912L)) {
            sVar.y.u = taVar.u;
        }
        if (q9(taVar, 1073741824L)) {
            sVar.y.y5 = taVar.y5;
        }
        if (q9(taVar, 67108864L)) {
            sVar.y.f7 = taVar.f7;
        }
        if (q9(taVar, 134217728L)) {
            sVar.y.en = taVar.en;
        }
        if (q9(taVar, 8589934592L)) {
            sVar.y.ct = taVar.ct;
        }
        if (q9(taVar, 17179869184L)) {
            sVar.y.o4 = taVar.o4;
        }
        if (q9(taVar, 137438953472L)) {
            sVar.y.eb = taVar.eb;
        }
    }

    public final void rs() {
        this.f11464a.pop();
        this.f11465fb.pop();
    }

    public final void rz(Path path) {
        s sVar = this.f11466gv;
        if (sVar.y.rs == fb.ta.c5.v) {
            Matrix matrix = this.y.getMatrix();
            Path path2 = new Path();
            path.transform(matrix, path2);
            this.y.setMatrix(new Matrix());
            Shader shader = this.f11466gv.v.getShader();
            Matrix matrix2 = new Matrix();
            if (shader != null) {
                shader.getLocalMatrix(matrix2);
                Matrix matrix3 = new Matrix(matrix2);
                matrix3.postConcat(matrix);
                shader.setLocalMatrix(matrix3);
            }
            this.y.drawPath(path2, this.f11466gv.v);
            this.y.setMatrix(matrix);
            if (shader != null) {
                shader.setLocalMatrix(matrix2);
                return;
            }
            return;
        }
        this.y.drawPath(path, sVar.v);
    }

    public final zn s8(zn znVar, zn znVar2, zn znVar3) {
        float mg2 = mg(znVar2.zn, znVar2.gv, znVar2.y - znVar.y, znVar2.n3 - znVar.n3);
        if (mg2 == 0.0f) {
            mg2 = mg(znVar2.zn, znVar2.gv, znVar3.y - znVar2.y, znVar3.n3 - znVar2.n3);
        }
        int i = (mg2 > 0.0f ? 1 : (mg2 == 0.0f ? 0 : -1));
        if (i > 0) {
            return znVar2;
        }
        if (i == 0 && (znVar2.zn > 0.0f || znVar2.gv >= 0.0f)) {
            return znVar2;
        }
        znVar2.zn = -znVar2.zn;
        znVar2.gv = -znVar2.gv;
        return znVar2;
    }

    public final List<zn> t(fb.c cVar) {
        int length = cVar.xc.length;
        int i = 2;
        if (length < 2) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        float[] fArr = cVar.xc;
        zn znVar = new zn(this, fArr[0], fArr[1], 0.0f, 0.0f);
        float f4 = 0.0f;
        float f6 = 0.0f;
        while (i < length) {
            float[] fArr2 = cVar.xc;
            float f9 = fArr2[i];
            float f10 = fArr2[i + 1];
            znVar.y(f9, f10);
            arrayList.add(znVar);
            i += 2;
            znVar = new zn(this, f9, f10, f9 - znVar.y, f10 - znVar.n3);
            f6 = f10;
            f4 = f9;
        }
        if (cVar instanceof fb.d0) {
            float[] fArr3 = cVar.xc;
            float f11 = fArr3[0];
            if (f4 != f11) {
                float f12 = fArr3[1];
                if (f6 != f12) {
                    znVar.y(f11, f12);
                    arrayList.add(znVar);
                    zn znVar2 = new zn(this, f11, f12, f11 - znVar.y, f12 - znVar.n3);
                    znVar2.n3((zn) arrayList.get(0));
                    arrayList.add(znVar2);
                    arrayList.set(0, znVar2);
                }
            }
        } else {
            arrayList.add(znVar);
        }
        return arrayList;
    }

    public final void ta(fb.f7 f7Var, i9 i9Var) {
        if (!d0()) {
            return;
        }
        Iterator<fb.yt> it = f7Var.f11435c5.iterator();
        boolean z2 = true;
        while (it.hasNext()) {
            fb.y5 y5Var = (fb.yt) it.next();
            if (y5Var instanceof fb.y5) {
                i9Var.n3(le(y5Var.zn, z2, !it.hasNext()));
            } else {
                ra(y5Var, i9Var);
            }
            z2 = false;
        }
    }

    public final void tg(fb.d dVar, fb.n3 n3Var, fb.n3 n3Var2, v vVar) {
        n("Svg render", new Object[0]);
        if (n3Var.f11444zn != 0.0f && n3Var.f11442gv != 0.0f) {
            if (vVar == null && (vVar = dVar.f11441xc) == null) {
                vVar = v.v;
            }
            ix(this.f11466gv, dVar);
            if (!d0()) {
                return;
            }
            s sVar = this.f11466gv;
            sVar.a = n3Var;
            if (!sVar.y.qn.booleanValue()) {
                fb.n3 n3Var3 = this.f11466gv.a;
                w9(n3Var3.y, n3Var3.f11443n3, n3Var3.f11444zn, n3Var3.f11442gv);
            }
            p(dVar, this.f11466gv.a);
            if (n3Var2 != null) {
                this.y.concat(xc(this.f11466gv.a, n3Var2, vVar));
                this.f11466gv.fb = dVar.f11445w;
            } else {
                Canvas canvas = this.y;
                fb.n3 n3Var4 = this.f11466gv.a;
                canvas.translate(n3Var4.y, n3Var4.f11443n3);
            }
            boolean e2 = e();
            yk();
            wf(dVar, true);
            if (e2) {
                lc(dVar);
            }
            cs(dVar);
        }
    }

    public final fb.n3 tl(Path path) {
        RectF rectF = new RectF();
        path.computeBounds(rectF, true);
        return new fb.n3(rectF.left, rectF.top, rectF.width(), rectF.height());
    }

    public final Path u(fb.c cVar) {
        Path path = new Path();
        float[] fArr = cVar.xc;
        path.moveTo(fArr[0], fArr[1]);
        int i = 2;
        while (true) {
            float[] fArr2 = cVar.xc;
            if (i >= fArr2.length) {
                break;
            }
            path.lineTo(fArr2[i], fArr2[i + 1]);
            i += 2;
        }
        if (cVar instanceof fb.d0) {
            path.close();
        }
        if (cVar.f11447s == null) {
            cVar.f11447s = tl(path);
        }
        return path;
    }

    public final void u0(fb.fh fhVar) {
        n("Rect render", new Object[0]);
        fb.w wVar = fhVar.p;
        if (wVar != null && fhVar.mt != null && !wVar.i9() && !fhVar.mt.i9()) {
            ix(this.f11466gv, fhVar);
            if (!d0() || !i2()) {
                return;
            }
            Matrix matrix = ((fb.t) fhVar).wz;
            if (matrix != null) {
                this.y.concat(matrix);
            }
            Path y52 = y5(fhVar);
            cs(fhVar);
            mt(fhVar);
            w(fhVar);
            boolean e2 = e();
            if (this.f11466gv.n3) {
                fh(fhVar, y52);
            }
            if (this.f11466gv.zn) {
                rz(y52);
            }
            if (e2) {
                lc(fhVar);
            }
        }
    }

    public final void ud(fb.k5 k5Var, fb.k5 k5Var2) {
        if (k5Var.tl == null) {
            k5Var.tl = k5Var2.tl;
        }
        if (k5Var.wz == null) {
            k5Var.wz = k5Var2.wz;
        }
        if (k5Var.xc == null) {
            k5Var.xc = k5Var2.xc;
        }
        if (k5Var.w == null) {
            k5Var.w = k5Var2.w;
        }
    }

    public final fb.ta.a vl() {
        fb.ta.a aVar;
        fb.ta taVar = this.f11466gv.y;
        if (taVar.b != fb.ta.s.y && (aVar = taVar.j5) != fb.ta.a.v) {
            fb.ta.a aVar2 = fb.ta.a.y;
            if (aVar == aVar2) {
                return fb.ta.a.fb;
            }
            return aVar2;
        }
        return taVar.j5;
    }

    public final boolean vp() {
        if (this.f11466gv.y.n.floatValue() >= 1.0f && this.f11466gv.y.y5 == null) {
            return false;
        }
        return true;
    }

    public final void w(fb.x xVar) {
        p(xVar, xVar.f11447s);
    }

    public final void w2(s sVar, boolean z2, fb.vl vlVar) {
        Float f4;
        int i;
        fb.ta taVar = sVar.y;
        if (z2) {
            f4 = taVar.s;
        } else {
            f4 = taVar.t;
        }
        float floatValue = f4.floatValue();
        if (vlVar instanceof fb.a) {
            i = ((fb.a) vlVar).y;
        } else if (vlVar instanceof fb.fb) {
            i = sVar.y.c.y;
        } else {
            return;
        }
        int f32 = f3(i, floatValue);
        if (z2) {
            sVar.gv.setColor(f32);
        } else {
            sVar.v.setColor(f32);
        }
    }

    public final void w9(float f4, float f6, float f9, float f10) {
        float f11 = f9 + f4;
        float f12 = f10 + f6;
        fb.zn znVar = this.f11466gv.y.o;
        if (znVar != null) {
            f4 += znVar.gv.fb(this);
            f6 += this.f11466gv.y.o.y.s(this);
            f11 -= this.f11466gv.y.o.n3.fb(this);
            f12 -= this.f11466gv.y.o.zn.s(this);
        }
        this.y.clipRect(f4, f6, f11, f12);
    }

    public final void wf(fb.a8 a8Var, boolean z2) {
        if (z2) {
            eb(a8Var);
        }
        for (fb.yt ytVar : a8Var.n3()) {
            pz(ytVar);
        }
        if (z2) {
            rs();
        }
    }

    public final float wz(fb.f7 f7Var) {
        f fVar = new f(this, (y) null);
        ta(f7Var, fVar);
        return fVar.n3;
    }

    public final void x(fb.n nVar, String str) {
        fb.n wz2 = nVar.y.wz(str);
        if (wz2 == null) {
            i3("Pattern reference '%s' not found", str);
        } else if (!(wz2 instanceof fb.n)) {
            d("Pattern href attributes must point to other pattern elements", new Object[0]);
        } else if (wz2 == nVar) {
            d("Circular reference in pattern href attribute '%s'", str);
        } else {
            fb.n nVar2 = wz2;
            if (nVar.p == null) {
                nVar.p = nVar2.p;
            }
            if (nVar.mt == null) {
                nVar.mt = nVar2.mt;
            }
            if (nVar.co == null) {
                nVar.co = nVar2.co;
            }
            if (nVar.z == null) {
                nVar.z = nVar2.z;
            }
            if (nVar.r == null) {
                nVar.r = nVar2.r;
            }
            if (nVar.x4 == null) {
                nVar.x4 = nVar2.x4;
            }
            if (nVar.i4 == null) {
                nVar.i4 = nVar2.i4;
            }
            if (nVar.f11435c5.isEmpty()) {
                nVar.f11435c5 = nVar2.f11435c5;
            }
            if (nVar.f11445w == null) {
                nVar.f11445w = nVar2.f11445w;
            }
            if (nVar.f11441xc == null) {
                nVar.f11441xc = nVar2.f11441xc;
            }
            String str2 = nVar2.f3;
            if (str2 != null) {
                x(nVar, str2);
            }
        }
    }

    public final void x5(boolean z2, fb.rz rzVar) {
        boolean z3 = false;
        if (z2) {
            if (q9(rzVar.f11428v, 2147483648L)) {
                s sVar = this.f11466gv;
                fb.ta taVar = sVar.y;
                fb.vl vlVar = rzVar.f11428v.xg;
                taVar.v = vlVar;
                if (vlVar != null) {
                    z3 = true;
                }
                sVar.n3 = z3;
            }
            if (q9(rzVar.f11428v, 4294967296L)) {
                this.f11466gv.y.s = rzVar.f11428v.dm;
            }
            if (q9(rzVar.f11428v, 6442450944L)) {
                s sVar2 = this.f11466gv;
                w2(sVar2, z2, sVar2.y.v);
                return;
            }
            return;
        }
        if (q9(rzVar.f11428v, 2147483648L)) {
            s sVar3 = this.f11466gv;
            fb.ta taVar2 = sVar3.y;
            fb.vl vlVar2 = rzVar.f11428v.xg;
            taVar2.f = vlVar2;
            if (vlVar2 != null) {
                z3 = true;
            }
            sVar3.zn = z3;
        }
        if (q9(rzVar.f11428v, 4294967296L)) {
            this.f11466gv.y.t = rzVar.f11428v.dm;
        }
        if (q9(rzVar.f11428v, 6442450944L)) {
            s sVar4 = this.f11466gv;
            w2(sVar4, z2, sVar4.y.f);
        }
    }

    public final void xb(fb.dm dmVar) {
        float f4;
        n("Use render", new Object[0]);
        fb.w wVar = dmVar.co;
        if (wVar == null || !wVar.i9()) {
            fb.w wVar2 = dmVar.z;
            if (wVar2 != null && wVar2.i9()) {
                return;
            }
            ix(this.f11466gv, dmVar);
            if (!d0()) {
                return;
            }
            fb.yt wz2 = dmVar.y.wz(dmVar.w);
            if (wz2 == null) {
                d("Use reference '%s' not found", dmVar.w);
                return;
            }
            Matrix matrix = ((fb.tl) dmVar).xc;
            if (matrix != null) {
                this.y.concat(matrix);
            }
            fb.w wVar3 = dmVar.p;
            float f6 = 0.0f;
            if (wVar3 != null) {
                f4 = wVar3.fb(this);
            } else {
                f4 = 0.0f;
            }
            fb.w wVar4 = dmVar.mt;
            if (wVar4 != null) {
                f6 = wVar4.s(this);
            }
            this.y.translate(f4, f6);
            w(dmVar);
            boolean e2 = e();
            eb(dmVar);
            if (wz2 instanceof fb.d) {
                fb.n3 ct2 = ct(null, null, dmVar.co, dmVar.z);
                mp();
                y4((fb.d) wz2, ct2);
                q5();
            } else if (wz2 instanceof fb.j) {
                fb.w wVar5 = dmVar.co;
                if (wVar5 == null) {
                    wVar5 = new fb.w(100.0f, fb.xg.percent);
                }
                fb.w wVar6 = dmVar.z;
                if (wVar6 == null) {
                    wVar6 = new fb.w(100.0f, fb.xg.percent);
                }
                fb.n3 ct3 = ct(null, null, wVar5, wVar6);
                mp();
                cr((fb.j) wz2, ct3);
                q5();
            } else {
                pz(wz2);
            }
            rs();
            if (e2) {
                lc(dmVar);
            }
            cs(dmVar);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x0083, code lost:
        if (r12 != 8) goto L30;
     */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0075  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.graphics.Matrix xc(mc.fb.n3 r10, mc.fb.n3 r11, mc.v r12) {
        /*
            r9 = this;
            android.graphics.Matrix r0 = new android.graphics.Matrix
            r0.<init>()
            if (r12 == 0) goto L9d
            mc.v$y r1 = r12.y()
            if (r1 != 0) goto Lf
            goto L9d
        Lf:
            float r1 = r10.f11444zn
            float r2 = r11.f11444zn
            float r1 = r1 / r2
            float r2 = r10.f11442gv
            float r3 = r11.f11442gv
            float r2 = r2 / r3
            float r3 = r11.y
            float r3 = -r3
            float r4 = r11.f11443n3
            float r4 = -r4
            mc.v r5 = mc.v.gv
            boolean r5 = r12.equals(r5)
            if (r5 == 0) goto L35
            float r11 = r10.y
            float r10 = r10.f11443n3
            r0.preTranslate(r11, r10)
            r0.preScale(r1, r2)
            r0.preTranslate(r3, r4)
            return r0
        L35:
            mc.v$n3 r5 = r12.n3()
            mc.v$n3 r6 = mc.v.n3.v
            if (r5 != r6) goto L42
            float r1 = java.lang.Math.max(r1, r2)
            goto L46
        L42:
            float r1 = java.lang.Math.min(r1, r2)
        L46:
            float r2 = r10.f11444zn
            float r2 = r2 / r1
            float r5 = r10.f11442gv
            float r5 = r5 / r1
            int[] r6 = mc.s.y.y
            mc.v$y r7 = r12.y()
            int r7 = r7.ordinal()
            r7 = r6[r7]
            r8 = 1073741824(0x40000000, float:2.0)
            switch(r7) {
                case 1: goto L63;
                case 2: goto L63;
                case 3: goto L63;
                case 4: goto L5e;
                case 5: goto L5e;
                case 6: goto L5e;
                default: goto L5d;
            }
        L5d:
            goto L68
        L5e:
            float r7 = r11.f11444zn
            float r7 = r7 - r2
        L61:
            float r3 = r3 - r7
            goto L68
        L63:
            float r7 = r11.f11444zn
            float r7 = r7 - r2
            float r7 = r7 / r8
            goto L61
        L68:
            mc.v$y r12 = r12.y()
            int r12 = r12.ordinal()
            r12 = r6[r12]
            r2 = 2
            if (r12 == r2) goto L8b
            r2 = 3
            if (r12 == r2) goto L86
            r2 = 5
            if (r12 == r2) goto L8b
            r2 = 6
            if (r12 == r2) goto L86
            r2 = 7
            if (r12 == r2) goto L8b
            r2 = 8
            if (r12 == r2) goto L86
            goto L90
        L86:
            float r11 = r11.f11442gv
            float r11 = r11 - r5
        L89:
            float r4 = r4 - r11
            goto L90
        L8b:
            float r11 = r11.f11442gv
            float r11 = r11 - r5
            float r11 = r11 / r8
            goto L89
        L90:
            float r11 = r10.y
            float r10 = r10.f11443n3
            r0.preTranslate(r11, r10)
            r0.preScale(r1, r1)
            r0.preTranslate(r3, r4)
        L9d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: mc.s.xc(mc.fb$n3, mc.fb$n3, mc.v):android.graphics.Matrix");
    }

    public final Path xg(fb.q9 q9Var) {
        float f4;
        float f6;
        float f9;
        List list = ((fb.jz) q9Var).xc;
        float f10 = 0.0f;
        if (list != null && list.size() != 0) {
            f4 = ((fb.w) ((fb.jz) q9Var).xc.get(0)).fb(this);
        } else {
            f4 = 0.0f;
        }
        List list2 = ((fb.jz) q9Var).w;
        if (list2 != null && list2.size() != 0) {
            f6 = ((fb.w) ((fb.jz) q9Var).w.get(0)).s(this);
        } else {
            f6 = 0.0f;
        }
        List list3 = ((fb.jz) q9Var).p;
        if (list3 != null && list3.size() != 0) {
            f9 = ((fb.w) ((fb.jz) q9Var).p.get(0)).fb(this);
        } else {
            f9 = 0.0f;
        }
        List list4 = ((fb.jz) q9Var).mt;
        if (list4 != null && list4.size() != 0) {
            f10 = ((fb.w) ((fb.jz) q9Var).mt.get(0)).s(this);
        }
        if (this.f11466gv.y.j5 != fb.ta.a.y) {
            float wz2 = wz(q9Var);
            if (this.f11466gv.y.j5 == fb.ta.a.v) {
                wz2 /= 2.0f;
            }
            f4 -= wz2;
        }
        if (q9Var.f11447s == null) {
            c5 c5Var = new c5(this, f4, f6);
            ta(q9Var, c5Var);
            RectF rectF = c5Var.gv;
            q9Var.f11447s = new fb.n3(rectF.left, rectF.top, rectF.width(), c5Var.gv.height());
        }
        Path path = new Path();
        ta(q9Var, new fb(this, f4 + f9, f6 + f10, path));
        return path;
    }

    public final void y4(fb.d dVar, fb.n3 n3Var) {
        tg(dVar, n3Var, dVar.f11445w, dVar.f11441xc);
    }

    public final Path y5(fb.fh fhVar) {
        float fb2;
        float s2;
        float f4;
        float f6;
        Path path;
        fb.w wVar = fhVar.co;
        if (wVar == null && fhVar.z == null) {
            fb2 = 0.0f;
            s2 = 0.0f;
        } else {
            if (wVar == null) {
                fb2 = fhVar.z.s(this);
            } else if (fhVar.z == null) {
                fb2 = wVar.fb(this);
            } else {
                fb2 = wVar.fb(this);
                s2 = fhVar.z.s(this);
            }
            s2 = fb2;
        }
        float min = Math.min(fb2, fhVar.p.fb(this) / 2.0f);
        float min2 = Math.min(s2, fhVar.mt.s(this) / 2.0f);
        fb.w wVar2 = fhVar.xc;
        if (wVar2 != null) {
            f4 = wVar2.fb(this);
        } else {
            f4 = 0.0f;
        }
        fb.w wVar3 = fhVar.w;
        if (wVar3 != null) {
            f6 = wVar3.s(this);
        } else {
            f6 = 0.0f;
        }
        float fb3 = fhVar.p.fb(this);
        float s3 = fhVar.mt.s(this);
        if (fhVar.f11447s == null) {
            fhVar.f11447s = new fb.n3(f4, f6, fb3, s3);
        }
        float f9 = f4 + fb3;
        float f10 = f6 + s3;
        Path path2 = new Path();
        if (min == 0.0f || min2 == 0.0f) {
            path = path2;
            path.moveTo(f4, f6);
            path.lineTo(f9, f6);
            path.lineTo(f9, f10);
            path.lineTo(f4, f10);
            path.lineTo(f4, f6);
        } else {
            float f11 = min * 0.5522848f;
            float f12 = 0.5522848f * min2;
            float f13 = f6 + min2;
            path2.moveTo(f4, f13);
            float f14 = f13 - f12;
            float f15 = f4 + min;
            float f16 = f15 - f11;
            path2.cubicTo(f4, f14, f16, f6, f15, f6);
            float f17 = f9 - min;
            path2.lineTo(f17, f6);
            float f18 = f17 + f11;
            path2.cubicTo(f18, f6, f9, f14, f9, f13);
            float f19 = f10 - min2;
            path2.lineTo(f9, f19);
            float f20 = f19 + f12;
            path = path2;
            path2.cubicTo(f9, f20, f18, f10, f17, f10);
            path.lineTo(f15, f10);
            path.cubicTo(f16, f10, f4, f20, f4, f19);
            path.lineTo(f4, f13);
        }
        path.close();
        return path;
    }

    public final void yc(fb.tl tlVar) {
        n("Group render", new Object[0]);
        ix(this.f11466gv, tlVar);
        if (!d0()) {
            return;
        }
        Matrix matrix = tlVar.xc;
        if (matrix != null) {
            this.y.concat(matrix);
        }
        w(tlVar);
        boolean e2 = e();
        wf(tlVar, true);
        if (e2) {
            lc(tlVar);
        }
        cs(tlVar);
    }

    public final void yg(fb.c5 c5Var) {
        n("Ellipse render", new Object[0]);
        fb.w wVar = c5Var.p;
        if (wVar != null && c5Var.mt != null && !wVar.i9() && !c5Var.mt.i9()) {
            ix(this.f11466gv, c5Var);
            if (!d0() || !i2()) {
                return;
            }
            Matrix matrix = ((fb.t) c5Var).wz;
            if (matrix != null) {
                this.y.concat(matrix);
            }
            Path en2 = en(c5Var);
            cs(c5Var);
            mt(c5Var);
            w(c5Var);
            boolean e2 = e();
            if (this.f11466gv.n3) {
                fh(c5Var, en2);
            }
            if (this.f11466gv.zn) {
                rz(en2);
            }
            if (e2) {
                lc(c5Var);
            }
        }
    }

    public final void yk() {
        int i;
        fb.ta taVar = this.f11466gv.y;
        fb.a aVar = taVar.ct;
        if (aVar instanceof fb.a) {
            i = aVar.y;
        } else if (aVar instanceof fb.fb) {
            i = taVar.c.y;
        } else {
            return;
        }
        Float f4 = taVar.o4;
        if (f4 != null) {
            i = f3(i, f4.floatValue());
        }
        this.y.drawColor(i);
    }

    public final s yt(fb.yt ytVar, s sVar) {
        ArrayList<fb.b> arrayList = new ArrayList();
        while (true) {
            if (ytVar instanceof fb.b) {
                arrayList.add(0, (fb.b) ytVar);
            }
            fb.a8 a8Var = ytVar.f11457n3;
            if (a8Var == null) {
                break;
            }
            ytVar = (fb.yt) a8Var;
        }
        for (fb.b bVar : arrayList) {
            ix(sVar, bVar);
        }
        s sVar2 = this.f11466gv;
        sVar.fb = sVar2.fb;
        sVar.a = sVar2.a;
        return sVar;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0047, code lost:
        if (r6.equals("fantasy") == false) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.graphics.Typeface z(java.lang.String r6, java.lang.Integer r7, mc.fb.ta.n3 r8) {
        /*
            r5 = this;
            r0 = 2
            r1 = 3
            mc.fb$ta$n3 r2 = mc.fb.ta.n3.v
            r3 = 0
            r4 = 1
            if (r8 != r2) goto La
            r8 = 1
            goto Lb
        La:
            r8 = 0
        Lb:
            int r7 = r7.intValue()
            r2 = 500(0x1f4, float:7.0E-43)
            if (r7 <= r2) goto L19
            if (r8 == 0) goto L17
            r7 = 3
            goto L1e
        L17:
            r7 = 1
            goto L1e
        L19:
            if (r8 == 0) goto L1d
            r7 = 2
            goto L1e
        L1d:
            r7 = 0
        L1e:
            r6.hashCode()
            r8 = -1
            int r2 = r6.hashCode()
            switch(r2) {
                case -1536685117: goto L55;
                case -1431958525: goto L4a;
                case -1081737434: goto L41;
                case 109326717: goto L36;
                case 1126973893: goto L2b;
                default: goto L29;
            }
        L29:
            r0 = -1
            goto L5f
        L2b:
            java.lang.String r0 = "cursive"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L34
            goto L29
        L34:
            r0 = 4
            goto L5f
        L36:
            java.lang.String r0 = "serif"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L3f
            goto L29
        L3f:
            r0 = 3
            goto L5f
        L41:
            java.lang.String r1 = "fantasy"
            boolean r6 = r6.equals(r1)
            if (r6 != 0) goto L5f
            goto L29
        L4a:
            java.lang.String r0 = "monospace"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L53
            goto L29
        L53:
            r0 = 1
            goto L5f
        L55:
            java.lang.String r0 = "sans-serif"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L5e
            goto L29
        L5e:
            r0 = 0
        L5f:
            switch(r0) {
                case 0: goto L80;
                case 1: goto L79;
                case 2: goto L72;
                case 3: goto L6b;
                case 4: goto L64;
                default: goto L62;
            }
        L62:
            r6 = 0
            goto L86
        L64:
            android.graphics.Typeface r6 = android.graphics.Typeface.SANS_SERIF
            android.graphics.Typeface r6 = android.graphics.Typeface.create(r6, r7)
            goto L86
        L6b:
            android.graphics.Typeface r6 = android.graphics.Typeface.SERIF
            android.graphics.Typeface r6 = android.graphics.Typeface.create(r6, r7)
            goto L86
        L72:
            android.graphics.Typeface r6 = android.graphics.Typeface.SANS_SERIF
            android.graphics.Typeface r6 = android.graphics.Typeface.create(r6, r7)
            goto L86
        L79:
            android.graphics.Typeface r6 = android.graphics.Typeface.MONOSPACE
            android.graphics.Typeface r6 = android.graphics.Typeface.create(r6, r7)
            goto L86
        L80:
            android.graphics.Typeface r6 = android.graphics.Typeface.SANS_SERIF
            android.graphics.Typeface r6 = android.graphics.Typeface.create(r6, r7)
        L86:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: mc.s.z(java.lang.String, java.lang.Integer, mc.fb$ta$n3):android.graphics.Typeface");
    }

    public final void z6(fb.f7 f7Var, StringBuilder sb) {
        Iterator<fb.yt> it = f7Var.f11435c5.iterator();
        boolean z2 = true;
        while (it.hasNext()) {
            fb.y5 y5Var = (fb.yt) it.next();
            if (y5Var instanceof fb.f7) {
                z6((fb.f7) y5Var, sb);
            } else if (y5Var instanceof fb.y5) {
                sb.append(le(y5Var.zn, z2, !it.hasNext()));
            }
            z2 = false;
        }
    }

    public static void n(String str, Object... objArr) {
    }
}
