package br;

import android.graphics.Path;
import android.graphics.PointF;
import i3.f;
import java.util.List;
import wm.wz;
/* loaded from: classes.dex */
public class fb {
    public static final PointF y = new PointF();

    public static int a(float f4, float f6) {
        return fb((int) f4, (int) f6);
    }

    public static float c5(float f4, float f6, float f9) {
        return f4 + (f9 * (f6 - f4));
    }

    public static void f(ne.v vVar, int i, List<ne.v> list, ne.v vVar2, f fVar) {
        if (vVar.zn(fVar.getName(), i)) {
            list.add(vVar2.y(fVar.getName()).c5(fVar));
        }
    }

    public static int fb(int i, int i5) {
        return i - (i5 * v(i, i5));
    }

    public static boolean gv(float f4, float f6, float f9) {
        if (f4 >= f6 && f4 <= f9) {
            return true;
        }
        return false;
    }

    public static int i9(int i, int i5, float f4) {
        return (int) (i + (f4 * (i5 - i)));
    }

    public static float n3(float f4, float f6, float f9) {
        return Math.max(f6, Math.min(f9, f4));
    }

    public static void s(wz wzVar, Path path) {
        path.reset();
        PointF n32 = wzVar.n3();
        path.moveTo(n32.x, n32.y);
        y.set(n32.x, n32.y);
        for (int i = 0; i < wzVar.y().size(); i++) {
            ne.y yVar = wzVar.y().get(i);
            PointF y2 = yVar.y();
            PointF n33 = yVar.n3();
            PointF zn2 = yVar.zn();
            PointF pointF = y;
            if (y2.equals(pointF) && n33.equals(zn2)) {
                path.lineTo(zn2.x, zn2.y);
            } else {
                path.cubicTo(y2.x, y2.y, n33.x, n33.y, zn2.x, zn2.y);
            }
            pointF.set(zn2.x, zn2.y);
        }
        if (wzVar.gv()) {
            path.close();
        }
    }

    public static int v(int i, int i5) {
        boolean z2;
        int i6 = i / i5;
        if ((i ^ i5) >= 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        int i8 = i % i5;
        if (!z2 && i8 != 0) {
            return i6 - 1;
        }
        return i6;
    }

    public static PointF y(PointF pointF, PointF pointF2) {
        return new PointF(pointF.x + pointF2.x, pointF.y + pointF2.y);
    }

    public static int zn(int i, int i5, int i6) {
        return Math.max(i5, Math.min(i6, i));
    }
}
