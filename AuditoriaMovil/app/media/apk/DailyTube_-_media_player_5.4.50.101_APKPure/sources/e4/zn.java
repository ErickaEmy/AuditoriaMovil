package e4;
/* loaded from: classes.dex */
public final class zn {
    public static void n3(long j2, v5.rz rzVar, ta[] taVarArr) {
        int ej2 = rzVar.ej();
        if ((ej2 & 64) != 0) {
            rzVar.ut(1);
            int i = (ej2 & 31) * 3;
            int a2 = rzVar.a();
            for (ta taVar : taVarArr) {
                rzVar.oz(a2);
                taVar.zn(rzVar, i);
                if (j2 != -9223372036854775807L) {
                    taVar.gv(j2, 1, i, 0, null);
                }
            }
        }
    }

    public static void y(long j2, v5.rz rzVar, ta[] taVarArr) {
        int i;
        boolean z2;
        while (true) {
            boolean z3 = true;
            if (rzVar.y() > 1) {
                int zn2 = zn(rzVar);
                int zn3 = zn(rzVar);
                int a2 = rzVar.a() + zn3;
                if (zn3 != -1 && zn3 <= rzVar.y()) {
                    if (zn2 == 4 && zn3 >= 8) {
                        int ej2 = rzVar.ej();
                        int yt2 = rzVar.yt();
                        if (yt2 == 49) {
                            i = rzVar.p();
                        } else {
                            i = 0;
                        }
                        int ej3 = rzVar.ej();
                        if (yt2 == 47) {
                            rzVar.ut(1);
                        }
                        if (ej2 == 181 && ((yt2 == 49 || yt2 == 47) && ej3 == 3)) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        if (yt2 == 49) {
                            if (i != 1195456820) {
                                z3 = false;
                            }
                            z2 &= z3;
                        }
                        if (z2) {
                            n3(j2, rzVar, taVarArr);
                        }
                    }
                } else {
                    v5.r.c5("CeaUtil", "Skipping remainder of malformed SEI NAL unit.");
                    a2 = rzVar.fb();
                }
                rzVar.oz(a2);
            } else {
                return;
            }
        }
    }

    public static int zn(v5.rz rzVar) {
        int i = 0;
        while (rzVar.y() != 0) {
            int ej2 = rzVar.ej();
            i += ej2;
            if (ej2 != 255) {
                return i;
            }
        }
        return -1;
    }
}
