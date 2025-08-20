package c;

import java.util.ArrayList;
import n.v;
/* loaded from: classes.dex */
public class c5 {
    public static boolean gv(v.n3 n3Var, v.n3 n3Var2, v.n3 n3Var3, v.n3 n3Var4) {
        boolean z2;
        boolean z3;
        v.n3 n3Var5;
        v.n3 n3Var6;
        v.n3 n3Var7 = v.n3.FIXED;
        if (n3Var3 != n3Var7 && n3Var3 != (n3Var6 = v.n3.WRAP_CONTENT) && (n3Var3 != v.n3.MATCH_PARENT || n3Var == n3Var6)) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (n3Var4 != n3Var7 && n3Var4 != (n3Var5 = v.n3.WRAP_CONTENT) && (n3Var4 != v.n3.MATCH_PARENT || n3Var2 == n3Var5)) {
            z3 = false;
        } else {
            z3 = true;
        }
        if (z2 || z3) {
            return true;
        }
        return false;
    }

    public static xc n3(ArrayList<xc> arrayList, int i) {
        int size = arrayList.size();
        for (int i5 = 0; i5 < size; i5++) {
            xc xcVar = arrayList.get(i5);
            if (i == xcVar.f3958n3) {
                return xcVar;
            }
        }
        return null;
    }

    public static xc y(n.v vVar, int i, ArrayList<xc> arrayList, xc xcVar) {
        int i5;
        int j32;
        if (i == 0) {
            i5 = vVar.f11731pz;
        } else {
            i5 = vVar.f11730pq;
        }
        int i6 = 0;
        if (i5 != -1 && (xcVar == null || i5 != xcVar.f3958n3)) {
            int i8 = 0;
            while (true) {
                if (i8 >= arrayList.size()) {
                    break;
                }
                xc xcVar2 = arrayList.get(i8);
                if (xcVar2.zn() == i5) {
                    if (xcVar != null) {
                        xcVar.fb(i, xcVar2);
                        arrayList.remove(xcVar);
                    }
                    xcVar = xcVar2;
                } else {
                    i8++;
                }
            }
        } else if (i5 != -1) {
            return xcVar;
        }
        if (xcVar == null) {
            if ((vVar instanceof n.c5) && (j32 = ((n.c5) vVar).j3(i)) != -1) {
                int i10 = 0;
                while (true) {
                    if (i10 >= arrayList.size()) {
                        break;
                    }
                    xc xcVar3 = arrayList.get(i10);
                    if (xcVar3.zn() == j32) {
                        xcVar = xcVar3;
                        break;
                    }
                    i10++;
                }
            }
            if (xcVar == null) {
                xcVar = new xc(i);
            }
            arrayList.add(xcVar);
        }
        if (xcVar.y(vVar)) {
            if (vVar instanceof n.fb) {
                n.fb fbVar = (n.fb) vVar;
                n.gv vn2 = fbVar.vn();
                if (fbVar.j3() == 0) {
                    i6 = 1;
                }
                vn2.n3(i6, arrayList, xcVar);
            }
            if (i == 0) {
                vVar.f11731pz = xcVar.zn();
                vVar.f11700ej.n3(i, arrayList, xcVar);
                vVar.f11687a8.n3(i, arrayList, xcVar);
            } else {
                vVar.f11730pq = xcVar.zn();
                vVar.f11747ud.n3(i, arrayList, xcVar);
                vVar.f11689b.n3(i, arrayList, xcVar);
                vVar.f11753x.n3(i, arrayList, xcVar);
            }
            vVar.f11750vl.n3(i, arrayList, xcVar);
        }
        return xcVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:176:0x0340  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x037a  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x037e A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean zn(n.a r16, c.n3.InterfaceC0040n3 r17) {
        /*
            Method dump skipped, instructions count: 901
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: c.c5.zn(n.a, c.n3$n3):boolean");
    }
}
