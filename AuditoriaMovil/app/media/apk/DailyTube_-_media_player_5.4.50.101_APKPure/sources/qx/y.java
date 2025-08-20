package qx;

import d9.y;
import e4.ta;
import java.util.Collections;
import m1.m;
import m1.ne;
import qx.v;
import v5.rz;
/* loaded from: classes.dex */
public final class y extends v {

    /* renamed from: v  reason: collision with root package name */
    public static final int[] f13000v = {5512, 11025, 22050, 44100};

    /* renamed from: gv  reason: collision with root package name */
    public int f13001gv;

    /* renamed from: n3  reason: collision with root package name */
    public boolean f13002n3;

    /* renamed from: zn  reason: collision with root package name */
    public boolean f13003zn;

    public y(ta taVar) {
        super(taVar);
    }

    @Override // qx.v
    public boolean n3(rz rzVar) throws v.y {
        String str;
        if (!this.f13002n3) {
            int ej2 = rzVar.ej();
            int i = (ej2 >> 4) & 15;
            this.f13001gv = i;
            if (i == 2) {
                this.y.v(new m.n3().o4("audio/mpeg").a8(1).rs(f13000v[(ej2 >> 2) & 3]).z6());
                this.f13003zn = true;
            } else if (i != 7 && i != 8) {
                if (i != 10) {
                    throw new v.y("Audio format not supported: " + this.f13001gv);
                }
            } else {
                if (i == 7) {
                    str = "audio/g711-alaw";
                } else {
                    str = "audio/g711-mlaw";
                }
                this.y.v(new m.n3().o4(str).a8(1).rs(8000).z6());
                this.f13003zn = true;
            }
            this.f13002n3 = true;
        } else {
            rzVar.ut(1);
        }
        return true;
    }

    @Override // qx.v
    public boolean zn(rz rzVar, long j2) throws ne {
        if (this.f13001gv == 2) {
            int y = rzVar.y();
            this.y.zn(rzVar, y);
            this.y.gv(j2, 1, y, 0, null);
            return true;
        }
        int ej2 = rzVar.ej();
        if (ej2 == 0 && !this.f13003zn) {
            int y2 = rzVar.y();
            byte[] bArr = new byte[y2];
            rzVar.t(bArr, 0, y2);
            y.n3 a2 = d9.y.a(bArr);
            this.y.v(new m.n3().o4("audio/mp4a-latm").x(a2.f7227zn).a8(a2.f7226n3).rs(a2.y).ut(Collections.singletonList(bArr)).z6());
            this.f13003zn = true;
            return false;
        } else if (this.f13001gv == 10 && ej2 != 1) {
            return false;
        } else {
            int y7 = rzVar.y();
            this.y.zn(rzVar, y7);
            this.y.gv(j2, 1, y7, 0, null);
            return true;
        }
    }
}
