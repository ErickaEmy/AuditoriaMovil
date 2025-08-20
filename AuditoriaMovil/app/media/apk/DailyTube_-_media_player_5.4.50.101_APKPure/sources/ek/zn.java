package ek;

import v5.rz;
/* loaded from: classes.dex */
public final class zn implements y {

    /* renamed from: gv  reason: collision with root package name */
    public final int f7654gv;

    /* renamed from: n3  reason: collision with root package name */
    public final int f7655n3;
    public final int y;

    /* renamed from: zn  reason: collision with root package name */
    public final int f7656zn;

    public zn(int i, int i5, int i6, int i8) {
        this.y = i;
        this.f7655n3 = i5;
        this.f7656zn = i6;
        this.f7654gv = i8;
    }

    public static zn n3(rz rzVar) {
        int r2 = rzVar.r();
        rzVar.ut(8);
        int r3 = rzVar.r();
        int r5 = rzVar.r();
        rzVar.ut(4);
        int r6 = rzVar.r();
        rzVar.ut(12);
        return new zn(r2, r3, r5, r6);
    }

    @Override // ek.y
    public int getType() {
        return 1751742049;
    }

    public boolean y() {
        if ((this.f7655n3 & 16) == 16) {
            return true;
        }
        return false;
    }
}
