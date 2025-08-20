package ld1;

import android.util.Log;
import kotlin.jvm.internal.Intrinsics;
import wd1.n3;
import wd1.zn;
/* loaded from: classes.dex */
public final class y extends zn {

    /* renamed from: ld1.y$y  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public /* synthetic */ class C0148y {
        public static final /* synthetic */ int[] y;

        static {
            int[] iArr = new int[n3.values().length];
            iArr[n3.DEBUG.ordinal()] = 1;
            iArr[n3.INFO.ordinal()] = 2;
            iArr[n3.ERROR.ordinal()] = 3;
            y = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y(n3 level) {
        super(level);
        Intrinsics.checkNotNullParameter(level, "level");
    }

    public final void i9(String str, n3 n3Var) {
        int i = C0148y.y[n3Var.ordinal()];
        if (i != 1 && i != 2) {
            if (i != 3) {
                Log.e("[Koin]", str);
            } else {
                Log.e("[Koin]", str);
            }
        }
    }

    @Override // wd1.zn
    public void s(n3 level, String msg) {
        Intrinsics.checkNotNullParameter(level, "level");
        Intrinsics.checkNotNullParameter(msg, "msg");
        if (v().compareTo(level) <= 0) {
            i9(msg, level);
        }
    }
}
