package n;

import c.xc;
import java.util.ArrayList;
import java.util.Arrays;
/* loaded from: classes.dex */
public class c5 extends v implements s {

    /* renamed from: o0  reason: collision with root package name */
    public v[] f11656o0 = new v[4];

    /* renamed from: xb  reason: collision with root package name */
    public int f11657xb;

    public int j3(int i) {
        int i5;
        int i6;
        for (int i8 = 0; i8 < this.f11657xb; i8++) {
            v vVar = this.f11656o0[i8];
            if (i == 0 && (i6 = vVar.f11731pz) != -1) {
                return i6;
            }
            if (i == 1 && (i5 = vVar.f11730pq) != -1) {
                return i5;
            }
        }
        return -1;
    }

    @Override // n.s
    public void n3(v vVar) {
        if (vVar != this && vVar != null) {
            int i = this.f11657xb + 1;
            v[] vVarArr = this.f11656o0;
            if (i > vVarArr.length) {
                this.f11656o0 = (v[]) Arrays.copyOf(vVarArr, vVarArr.length * 2);
            }
            v[] vVarArr2 = this.f11656o0;
            int i5 = this.f11657xb;
            vVarArr2[i5] = vVar;
            this.f11657xb = i5 + 1;
        }
    }

    public void vn(ArrayList<xc> arrayList, int i, xc xcVar) {
        for (int i5 = 0; i5 < this.f11657xb; i5++) {
            xcVar.y(this.f11656o0[i5]);
        }
        for (int i6 = 0; i6 < this.f11657xb; i6++) {
            c.c5.y(this.f11656o0[i6], i, arrayList, xcVar);
        }
    }

    @Override // n.s
    public void zn() {
        this.f11657xb = 0;
        Arrays.fill(this.f11656o0, (Object) null);
    }

    @Override // n.s
    public void y(a aVar) {
    }
}
