package p7;

import af.f7;
import e4.ta;
import p7.fb;
import v5.r;
/* loaded from: classes.dex */
public final class zn implements fb.n3 {

    /* renamed from: n3  reason: collision with root package name */
    public final f7[] f12516n3;
    public final int[] y;

    public zn(int[] iArr, f7[] f7VarArr) {
        this.y = iArr;
        this.f12516n3 = f7VarArr;
    }

    @Override // p7.fb.n3
    public ta a(int i, int i5) {
        int i6 = 0;
        while (true) {
            int[] iArr = this.y;
            if (i6 < iArr.length) {
                if (i5 == iArr[i6]) {
                    return this.f12516n3[i6];
                }
                i6++;
            } else {
                r.zn("BaseMediaChunkOutput", "Unmatched track of type: " + i5);
                return new e4.f();
            }
        }
    }

    public void n3(long j2) {
        for (f7 f7Var : this.f12516n3) {
            f7Var.jz(j2);
        }
    }

    public int[] y() {
        int[] iArr = new int[this.f12516n3.length];
        int i = 0;
        while (true) {
            f7[] f7VarArr = this.f12516n3;
            if (i < f7VarArr.length) {
                iArr[i] = f7VarArr[i].z6();
                i++;
            } else {
                return iArr;
            }
        }
    }
}
