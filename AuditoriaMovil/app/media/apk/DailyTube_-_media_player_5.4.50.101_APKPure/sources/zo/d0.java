package zo;

import af.lc;
import af.rs;
import android.os.SystemClock;
import java.util.Arrays;
import java.util.List;
import kx.mg;
import m1.v1;
import z0.x4;
import zo.r;
/* loaded from: classes.dex */
public final class d0 {
    public static v1 n3(r.y yVar, x4[] x4VarArr) {
        z0.x4 j52;
        List[] listArr = new List[x4VarArr.length];
        for (int i = 0; i < x4VarArr.length; i++) {
            x4 x4Var = x4VarArr[i];
            if (x4Var != null) {
                j52 = z0.x4.o(x4Var);
            } else {
                j52 = z0.x4.j5();
            }
            listArr[i] = j52;
        }
        return y(yVar, listArr);
    }

    public static v1 y(r.y yVar, List<? extends x4>[] listArr) {
        boolean z2;
        boolean z3;
        x4.y yVar2 = new x4.y();
        for (int i = 0; i < yVar.gv(); i++) {
            lc a2 = yVar.a(i);
            List<? extends x4> list = listArr[i];
            for (int i5 = 0; i5 < a2.y; i5++) {
                rs n32 = a2.n3(i5);
                if (yVar.y(i, i5, false) != 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                int i6 = n32.y;
                int[] iArr = new int[i6];
                boolean[] zArr = new boolean[i6];
                for (int i8 = 0; i8 < n32.y; i8++) {
                    iArr[i8] = yVar.fb(i, i5, i8);
                    int i10 = 0;
                    while (true) {
                        if (i10 < list.size()) {
                            x4 x4Var = list.get(i10);
                            if (x4Var.xc().equals(n32) && x4Var.tl(i8) != -1) {
                                z3 = true;
                                break;
                            }
                            i10++;
                        } else {
                            z3 = false;
                            break;
                        }
                    }
                    zArr[i8] = z3;
                }
                yVar2.y(new v1.y(n32, z2, iArr, zArr));
            }
        }
        lc s2 = yVar.s();
        for (int i11 = 0; i11 < s2.y; i11++) {
            rs n33 = s2.n3(i11);
            int[] iArr2 = new int[n33.y];
            Arrays.fill(iArr2, 0);
            yVar2.y(new v1.y(n33, false, iArr2, new boolean[n33.y]));
        }
        return new v1(yVar2.s());
    }

    public static mg.y zn(co coVar) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        int length = coVar.length();
        int i = 0;
        for (int i5 = 0; i5 < length; i5++) {
            if (coVar.v(i5, elapsedRealtime)) {
                i++;
            }
        }
        return new mg.y(1, 0, length, i);
    }
}
