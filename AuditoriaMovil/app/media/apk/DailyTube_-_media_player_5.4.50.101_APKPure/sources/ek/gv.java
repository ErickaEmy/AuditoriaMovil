package ek;

import v5.j5;
import v5.r;
import v5.rz;
/* loaded from: classes.dex */
public final class gv implements y {

    /* renamed from: a  reason: collision with root package name */
    public final int f7622a;

    /* renamed from: gv  reason: collision with root package name */
    public final int f7623gv;

    /* renamed from: n3  reason: collision with root package name */
    public final int f7624n3;

    /* renamed from: v  reason: collision with root package name */
    public final int f7625v;
    public final int y;

    /* renamed from: zn  reason: collision with root package name */
    public final int f7626zn;

    public gv(int i, int i5, int i6, int i8, int i10, int i11) {
        this.y = i;
        this.f7624n3 = i5;
        this.f7626zn = i6;
        this.f7623gv = i8;
        this.f7625v = i10;
        this.f7622a = i11;
    }

    public static gv zn(rz rzVar) {
        int r2 = rzVar.r();
        rzVar.ut(12);
        int r3 = rzVar.r();
        int r5 = rzVar.r();
        int r6 = rzVar.r();
        rzVar.ut(4);
        int r7 = rzVar.r();
        int r8 = rzVar.r();
        rzVar.ut(8);
        return new gv(r2, r3, r5, r6, r7, r8);
    }

    @Override // ek.y
    public int getType() {
        return 1752331379;
    }

    public int n3() {
        int i = this.y;
        if (i != 1935960438) {
            if (i != 1935963489) {
                if (i != 1937012852) {
                    r.c5("AviStreamHeaderChunk", "Found unsupported streamType fourCC: " + Integer.toHexString(this.y));
                    return -1;
                }
                return 3;
            }
            return 1;
        }
        return 2;
    }

    public long y() {
        return j5.x5(this.f7625v, this.f7626zn * 1000000, this.f7623gv);
    }
}
