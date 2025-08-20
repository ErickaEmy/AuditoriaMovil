package y3;

import android.util.SparseArray;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import java.util.ArrayList;
import java.util.List;
import m1.m;
import y3.ud;
/* loaded from: classes.dex */
public final class i9 implements ud.zn {

    /* renamed from: n3  reason: collision with root package name */
    public final List<m> f15082n3;
    public final int y;

    public i9(int i) {
        this(i, z0.x4.j5());
    }

    public final boolean a(int i) {
        if ((i & this.y) != 0) {
            return true;
        }
        return false;
    }

    public final x gv(ud.n3 n3Var) {
        return new x(v(n3Var));
    }

    @Override // y3.ud.zn
    @Nullable
    public ud n3(int i, ud.n3 n3Var) {
        if (i != 2) {
            if (i != 3 && i != 4) {
                if (i != 21) {
                    if (i != 27) {
                        if (i != 36) {
                            if (i != 89) {
                                if (i != 138) {
                                    if (i != 172) {
                                        if (i != 257) {
                                            if (i != 134) {
                                                if (i != 135) {
                                                    switch (i) {
                                                        case 15:
                                                            if (a(2)) {
                                                                return null;
                                                            }
                                                            return new i4(new c5(false, n3Var.f15158n3));
                                                        case 16:
                                                            return new i4(new xc(gv(n3Var)));
                                                        case 17:
                                                            if (a(2)) {
                                                                return null;
                                                            }
                                                            return new i4(new co(n3Var.f15158n3));
                                                        default:
                                                            switch (i) {
                                                                case NotificationCompat.FLAG_HIGH_PRIORITY /* 128 */:
                                                                    break;
                                                                case 129:
                                                                    break;
                                                                case 130:
                                                                    if (!a(64)) {
                                                                        return null;
                                                                    }
                                                                    break;
                                                                default:
                                                                    return null;
                                                            }
                                                    }
                                                }
                                                return new i4(new zn(n3Var.f15158n3));
                                            } else if (a(16)) {
                                                return null;
                                            } else {
                                                return new rz(new x4("application/x-scte35"));
                                            }
                                        }
                                        return new rz(new x4("application/vnd.dvb.ait"));
                                    }
                                    return new i4(new a(n3Var.f15158n3));
                                }
                                return new i4(new f(n3Var.f15158n3));
                            }
                            return new i4(new t(n3Var.f15159zn));
                        }
                        return new i4(new p(zn(n3Var)));
                    } else if (a(4)) {
                        return null;
                    } else {
                        return new i4(new w(zn(n3Var), a(1), a(8)));
                    }
                }
                return new i4(new mt());
            }
            return new i4(new z(n3Var.f15158n3));
        }
        return new i4(new wz(gv(n3Var)));
    }

    public final List<m> v(ud.n3 n3Var) {
        boolean z2;
        String str;
        int i;
        List<byte[]> list;
        if (a(32)) {
            return this.f15082n3;
        }
        v5.rz rzVar = new v5.rz(n3Var.f15157gv);
        List<m> list2 = this.f15082n3;
        while (rzVar.y() > 0) {
            int ej2 = rzVar.ej();
            int a2 = rzVar.a() + rzVar.ej();
            if (ej2 == 134) {
                list2 = new ArrayList<>();
                int ej3 = rzVar.ej() & 31;
                for (int i5 = 0; i5 < ej3; i5++) {
                    String ta2 = rzVar.ta(3);
                    int ej4 = rzVar.ej();
                    boolean z3 = true;
                    if ((ej4 & NotificationCompat.FLAG_HIGH_PRIORITY) != 0) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (z2) {
                        i = ej4 & 63;
                        str = "application/cea-708";
                    } else {
                        str = "application/cea-608";
                        i = 1;
                    }
                    byte ej5 = (byte) rzVar.ej();
                    rzVar.ut(1);
                    if (z2) {
                        if ((ej5 & 64) == 0) {
                            z3 = false;
                        }
                        list = v5.a.n3(z3);
                    } else {
                        list = null;
                    }
                    list2.add(new m.n3().o4(str).k(ta2).ej(i).ut(list).z6());
                }
            }
            rzVar.oz(a2);
        }
        return list2;
    }

    @Override // y3.ud.zn
    public SparseArray<ud> y() {
        return new SparseArray<>();
    }

    public final mg zn(ud.n3 n3Var) {
        return new mg(v(n3Var));
    }

    public i9(int i, List<m> list) {
        this.y = i;
        this.f15082n3 = list;
    }
}
