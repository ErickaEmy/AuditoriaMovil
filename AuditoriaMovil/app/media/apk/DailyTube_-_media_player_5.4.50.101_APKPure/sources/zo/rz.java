package zo;

import androidx.annotation.Nullable;
import m1.ic;
import m1.v1;
import v5.j5;
/* loaded from: classes.dex */
public final class rz {

    /* renamed from: gv  reason: collision with root package name */
    public final v1 f15771gv;

    /* renamed from: n3  reason: collision with root package name */
    public final ic[] f15772n3;
    @Nullable

    /* renamed from: v  reason: collision with root package name */
    public final Object f15773v;
    public final int y;

    /* renamed from: zn  reason: collision with root package name */
    public final co[] f15774zn;

    public rz(ic[] icVarArr, co[] coVarArr, v1 v1Var, @Nullable Object obj) {
        this.f15772n3 = icVarArr;
        this.f15774zn = (co[]) coVarArr.clone();
        this.f15771gv = v1Var;
        this.f15773v = obj;
        this.y = icVarArr.length;
    }

    public boolean n3(@Nullable rz rzVar, int i) {
        if (rzVar == null || !j5.zn(this.f15772n3[i], rzVar.f15772n3[i]) || !j5.zn(this.f15774zn[i], rzVar.f15774zn[i])) {
            return false;
        }
        return true;
    }

    public boolean y(@Nullable rz rzVar) {
        if (rzVar == null || rzVar.f15774zn.length != this.f15774zn.length) {
            return false;
        }
        for (int i = 0; i < this.f15774zn.length; i++) {
            if (!n3(rzVar, i)) {
                return false;
            }
        }
        return true;
    }

    public boolean zn(int i) {
        if (this.f15772n3[i] != null) {
            return true;
        }
        return false;
    }
}
