package qx;

import e4.ta;
import m1.ne;
import v5.rz;
/* loaded from: classes.dex */
public abstract class v {
    public final ta y;

    /* loaded from: classes.dex */
    public static final class y extends ne {
        public y(String str) {
            super(str, null, false, 1);
        }
    }

    public v(ta taVar) {
        this.y = taVar;
    }

    public abstract boolean n3(rz rzVar) throws ne;

    public final boolean y(rz rzVar, long j2) throws ne {
        if (n3(rzVar) && zn(rzVar, j2)) {
            return true;
        }
        return false;
    }

    public abstract boolean zn(rz rzVar, long j2) throws ne;
}
