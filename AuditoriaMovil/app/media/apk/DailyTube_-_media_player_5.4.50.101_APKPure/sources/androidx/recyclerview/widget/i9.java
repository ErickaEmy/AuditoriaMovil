package androidx.recyclerview.widget;

import androidx.recyclerview.widget.y;
import java.util.List;
/* loaded from: classes.dex */
public class i9 {
    public final y y;

    /* loaded from: classes.dex */
    public interface y {
        void n3(y.n3 n3Var);

        y.n3 y(int i, int i5, int i6, Object obj);
    }

    public i9(y yVar) {
        this.y = yVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(java.util.List<androidx.recyclerview.widget.y.n3> r9, int r10, androidx.recyclerview.widget.y.n3 r11, int r12, androidx.recyclerview.widget.y.n3 r13) {
        /*
            r8 = this;
            int r0 = r11.f3329gv
            int r1 = r13.f3330n3
            r2 = 4
            r3 = 1
            r4 = 0
            if (r0 >= r1) goto Ld
            int r1 = r1 - r3
            r13.f3330n3 = r1
            goto L20
        Ld:
            int r5 = r13.f3329gv
            int r1 = r1 + r5
            if (r0 >= r1) goto L20
            int r5 = r5 - r3
            r13.f3329gv = r5
            androidx.recyclerview.widget.i9$y r0 = r8.y
            int r1 = r11.f3330n3
            java.lang.Object r5 = r13.f3331zn
            androidx.recyclerview.widget.y$n3 r0 = r0.y(r2, r1, r3, r5)
            goto L21
        L20:
            r0 = r4
        L21:
            int r1 = r11.f3330n3
            int r5 = r13.f3330n3
            if (r1 > r5) goto L2b
            int r5 = r5 + r3
            r13.f3330n3 = r5
            goto L41
        L2b:
            int r6 = r13.f3329gv
            int r7 = r5 + r6
            if (r1 >= r7) goto L41
            int r5 = r5 + r6
            int r5 = r5 - r1
            androidx.recyclerview.widget.i9$y r4 = r8.y
            int r1 = r1 + r3
            java.lang.Object r3 = r13.f3331zn
            androidx.recyclerview.widget.y$n3 r4 = r4.y(r2, r1, r5, r3)
            int r1 = r13.f3329gv
            int r1 = r1 - r5
            r13.f3329gv = r1
        L41:
            r9.set(r12, r11)
            int r11 = r13.f3329gv
            if (r11 <= 0) goto L4c
            r9.set(r10, r13)
            goto L54
        L4c:
            r9.remove(r10)
            androidx.recyclerview.widget.i9$y r11 = r8.y
            r11.n3(r13)
        L54:
            if (r0 == 0) goto L59
            r9.add(r10, r0)
        L59:
            if (r4 == 0) goto L5e
            r9.add(r10, r4)
        L5e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.i9.a(java.util.List, int, androidx.recyclerview.widget.y$n3, int, androidx.recyclerview.widget.y$n3):void");
    }

    public final void gv(List<y.n3> list, int i, int i5) {
        y.n3 n3Var = list.get(i);
        y.n3 n3Var2 = list.get(i5);
        int i6 = n3Var2.y;
        if (i6 != 1) {
            if (i6 != 2) {
                if (i6 == 4) {
                    a(list, i, n3Var, i5, n3Var2);
                    return;
                }
                return;
            }
            v(list, i, n3Var, i5, n3Var2);
            return;
        }
        zn(list, i, n3Var, i5, n3Var2);
    }

    public void n3(List<y.n3> list) {
        while (true) {
            int y2 = y(list);
            if (y2 != -1) {
                gv(list, y2, y2 + 1);
            } else {
                return;
            }
        }
    }

    public void v(List<y.n3> list, int i, y.n3 n3Var, int i5, y.n3 n3Var2) {
        boolean z2;
        int i6 = n3Var.f3330n3;
        int i8 = n3Var.f3329gv;
        boolean z3 = false;
        if (i6 < i8) {
            if (n3Var2.f3330n3 == i6 && n3Var2.f3329gv == i8 - i6) {
                z2 = false;
                z3 = true;
            } else {
                z2 = false;
            }
        } else if (n3Var2.f3330n3 == i8 + 1 && n3Var2.f3329gv == i6 - i8) {
            z2 = true;
            z3 = true;
        } else {
            z2 = true;
        }
        int i10 = n3Var2.f3330n3;
        if (i8 < i10) {
            n3Var2.f3330n3 = i10 - 1;
        } else {
            int i11 = n3Var2.f3329gv;
            if (i8 < i10 + i11) {
                n3Var2.f3329gv = i11 - 1;
                n3Var.y = 2;
                n3Var.f3329gv = 1;
                if (n3Var2.f3329gv == 0) {
                    list.remove(i5);
                    this.y.n3(n3Var2);
                    return;
                }
                return;
            }
        }
        int i12 = n3Var.f3330n3;
        int i13 = n3Var2.f3330n3;
        y.n3 n3Var3 = null;
        if (i12 <= i13) {
            n3Var2.f3330n3 = i13 + 1;
        } else {
            int i14 = n3Var2.f3329gv;
            if (i12 < i13 + i14) {
                n3Var3 = this.y.y(2, i12 + 1, (i13 + i14) - i12, null);
                n3Var2.f3329gv = n3Var.f3330n3 - n3Var2.f3330n3;
            }
        }
        if (z3) {
            list.set(i, n3Var2);
            list.remove(i5);
            this.y.n3(n3Var);
            return;
        }
        if (z2) {
            if (n3Var3 != null) {
                int i15 = n3Var.f3330n3;
                if (i15 > n3Var3.f3330n3) {
                    n3Var.f3330n3 = i15 - n3Var3.f3329gv;
                }
                int i16 = n3Var.f3329gv;
                if (i16 > n3Var3.f3330n3) {
                    n3Var.f3329gv = i16 - n3Var3.f3329gv;
                }
            }
            int i17 = n3Var.f3330n3;
            if (i17 > n3Var2.f3330n3) {
                n3Var.f3330n3 = i17 - n3Var2.f3329gv;
            }
            int i18 = n3Var.f3329gv;
            if (i18 > n3Var2.f3330n3) {
                n3Var.f3329gv = i18 - n3Var2.f3329gv;
            }
        } else {
            if (n3Var3 != null) {
                int i19 = n3Var.f3330n3;
                if (i19 >= n3Var3.f3330n3) {
                    n3Var.f3330n3 = i19 - n3Var3.f3329gv;
                }
                int i20 = n3Var.f3329gv;
                if (i20 >= n3Var3.f3330n3) {
                    n3Var.f3329gv = i20 - n3Var3.f3329gv;
                }
            }
            int i21 = n3Var.f3330n3;
            if (i21 >= n3Var2.f3330n3) {
                n3Var.f3330n3 = i21 - n3Var2.f3329gv;
            }
            int i22 = n3Var.f3329gv;
            if (i22 >= n3Var2.f3330n3) {
                n3Var.f3329gv = i22 - n3Var2.f3329gv;
            }
        }
        list.set(i, n3Var2);
        if (n3Var.f3330n3 != n3Var.f3329gv) {
            list.set(i5, n3Var);
        } else {
            list.remove(i5);
        }
        if (n3Var3 != null) {
            list.add(i, n3Var3);
        }
    }

    public final int y(List<y.n3> list) {
        boolean z2 = false;
        for (int size = list.size() - 1; size >= 0; size--) {
            if (list.get(size).y == 8) {
                if (z2) {
                    return size;
                }
            } else {
                z2 = true;
            }
        }
        return -1;
    }

    public final void zn(List<y.n3> list, int i, y.n3 n3Var, int i5, y.n3 n3Var2) {
        int i6;
        int i8 = n3Var.f3329gv;
        int i10 = n3Var2.f3330n3;
        if (i8 < i10) {
            i6 = -1;
        } else {
            i6 = 0;
        }
        int i11 = n3Var.f3330n3;
        if (i11 < i10) {
            i6++;
        }
        if (i10 <= i11) {
            n3Var.f3330n3 = i11 + n3Var2.f3329gv;
        }
        int i12 = n3Var2.f3330n3;
        if (i12 <= i8) {
            n3Var.f3329gv = i8 + n3Var2.f3329gv;
        }
        n3Var2.f3330n3 = i12 + i6;
        list.set(i, n3Var2);
        list.set(i5, n3Var);
    }
}
