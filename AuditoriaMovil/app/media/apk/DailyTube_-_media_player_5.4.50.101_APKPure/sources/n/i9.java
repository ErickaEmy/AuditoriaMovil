package n;

import n.v;
/* loaded from: classes.dex */
public class i9 {
    public static boolean[] y = new boolean[3];

    public static final boolean n3(int i, int i5) {
        if ((i & i5) == i5) {
            return true;
        }
        return false;
    }

    public static void y(a aVar, f3.gv gvVar, v vVar) {
        vVar.f11752wz = -1;
        vVar.f11755xc = -1;
        v.n3 n3Var = aVar.f11726o[0];
        v.n3 n3Var2 = v.n3.WRAP_CONTENT;
        if (n3Var != n3Var2 && vVar.f11726o[0] == v.n3.MATCH_PARENT) {
            int i = vVar.f11700ej.f11669fb;
            int qn2 = aVar.qn() - vVar.f11687a8.f11669fb;
            gv gvVar2 = vVar.f11700ej;
            gvVar2.f11668c5 = gvVar.p(gvVar2);
            gv gvVar3 = vVar.f11687a8;
            gvVar3.f11668c5 = gvVar.p(gvVar3);
            gvVar.a(vVar.f11700ej.f11668c5, i);
            gvVar.a(vVar.f11687a8.f11668c5, qn2);
            vVar.f11752wz = 2;
            vVar.y4(i, qn2);
        }
        if (aVar.f11726o[1] != n3Var2 && vVar.f11726o[1] == v.n3.MATCH_PARENT) {
            int i5 = vVar.f11747ud.f11669fb;
            int x42 = aVar.x4() - vVar.f11753x.f11669fb;
            gv gvVar4 = vVar.f11747ud;
            gvVar4.f11668c5 = gvVar.p(gvVar4);
            gv gvVar5 = vVar.f11753x;
            gvVar5.f11668c5 = gvVar.p(gvVar5);
            gvVar.a(vVar.f11747ud.f11668c5, i5);
            gvVar.a(vVar.f11753x.f11668c5, x42);
            if (vVar.f11697dm > 0 || vVar.j5() == 8) {
                gv gvVar6 = vVar.f11689b;
                gvVar6.f11668c5 = gvVar.p(gvVar6);
                gvVar.a(vVar.f11689b.f11668c5, vVar.f11697dm + i5);
            }
            vVar.f11755xc = 2;
            vVar.w2(i5, x42);
        }
    }
}
